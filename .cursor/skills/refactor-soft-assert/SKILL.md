---
name: refactor-soft-assert
description: Refactor hard autotest assertions from Assertion.assert* to SoftAssert softAssert.*. Use when converting Assertion.assertEquals/assertTrue/assertFalse/assertNotNull (or similar hard asserts) to softAssert, when the user asks to use soft assertions, SoftAssert, or assertAll in tests.
---

# Refactor Assertion.assert → softAssert

## Goal

Replace hard `Assertion.assert*` calls with `softAssert.*` so failures are collected and reported together via `assertAll()`, instead of failing on the first assertion.

Do **not** leave hard `Assertion.assert*` in place when this skill is applied. Prefer soft asserts for multi-check test bodies.

## Rules

1. Replace `Assertion.assertX(...)` with `softAssert.assertX(...)` (same method name and args).
2. Ensure a `SoftAssert` instance exists in the test method (or shared setup the project already uses):
   ```java
   SoftAssert softAssert = new SoftAssert();
   ```
3. Call `softAssert.assertAll()` once at the **end** of the test method (or after the assertion block), before return / end of test.
4. Fix imports:
   - Add `import org.testng.asserts.SoftAssert;` (or the project's SoftAssert type if different).
   - Remove unused `Assertion` imports only if no hard asserts remain.
5. Do not wrap every single assert in its own SoftAssert + assertAll — one SoftAssert per test (or per logical assertion group) is enough.
6. Keep assertion messages and argument order unchanged unless the project's SoftAssert API differs.
7. If a hard assert is intentionally fail-fast (precondition / setup guard), leave it as hard assert and only soft-assert the verification block. When unsure and the user asked to convert assertions, convert verification asserts to soft.

## Mapping

| Before | After |
|--------|--------|
| `Assertion.assertEquals(a, b)` | `softAssert.assertEquals(a, b)` |
| `Assertion.assertEquals(a, b, "msg")` | `softAssert.assertEquals(a, b, "msg")` |
| `Assertion.assertTrue(cond)` | `softAssert.assertTrue(cond)` |
| `Assertion.assertFalse(cond)` | `softAssert.assertFalse(cond)` |
| `Assertion.assertNotNull(obj)` | `softAssert.assertNotNull(obj)` |
| `Assertion.assertNull(obj)` | `softAssert.assertNull(obj)` |
| `Assertion.fail("msg")` | Prefer hard fail for abort; or `softAssert.fail("msg")` + `assertAll()` if collecting |

Also convert common aliases if present: `Assert.assert*`, `Assertions.assert*` → `softAssert.assert*` when the user asked for soft asserts.

## Workflow

1. Find hard asserts in the target test(s): `Assertion.assert`, `Assert.assert`, static assertion helpers.
2. Introduce or reuse `SoftAssert softAssert`.
3. Replace each verification assert with `softAssert.*`.
4. Add `softAssert.assertAll()` at the end of the assertion section.
5. Clean imports and confirm the test still compiles.

## Example

**Before:**
```java
@Test
public void checkProfile() {
    Assertion.assertEquals(page.getName(), "Ann");
    Assertion.assertTrue(page.isActive());
    Assertion.assertNotNull(page.getId());
}
```

**After:**
```java
@Test
public void checkProfile() {
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(page.getName(), "Ann");
    softAssert.assertTrue(page.isActive());
    softAssert.assertNotNull(page.getId());
    softAssert.assertAll();
}
```

## Project-specific SoftAssert

If the codebase already defines a SoftAssert field/helper (e.g. base test `protected SoftAssert softAssert`), reuse that pattern instead of creating a new local instance. Always end the soft-assert block with `assertAll()`.
