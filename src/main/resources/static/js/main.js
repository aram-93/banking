const envURL = 'http://localhost:8080';

function onUpdateCreditsInfo(btn) {

    console.log(btn)
    children = btn.parentElement.parentElement.children;
    id = -1
    bankName = ""
    description = ""
    percent = -1
    for (let i = 0; i < children.length; i++) {
        if (children[i].tagName.toLowerCase() != "td") {
            continue
        }
        if (children[i].getAttribute("name") == "id") {
            id = +children[i].innerHTML
        } else if (children[i].getAttribute("name") == "bankName") {
            bankName = children[i].innerHTML
        } else if (children[i].getAttribute("name") == "description") {
            description = children[i].innerHTML
        } else if (children[i].getAttribute("name") == "percent") {
            strpercent = children[i].innerHTML
            percent = +strpercent.substr(0, strpercent.length - 1)
        }
    }
    var obj = new Object()
    obj.id = id
    obj.bankName = bankName
    obj.description = description
    obj.percent = percent
    var jsonString = JSON.stringify(obj)
    console.log(jsonString)

    fetch(envURL + '/edit', {
        method: 'post', // or 'PUT'
        headers: {
            'Content-Type': 'application/json'
        },
        contentType: "application/json",
        body: jsonString,
    }).then(res => res.json())
        .then(res => console.log(res))
        .catch(err => console.log(err));

    showBanner();
    setInterval(hideBanner, 1000);
    setInterval('refresh()', 1000);
}

function refresh() {
    location.reload();
}

function showBanner() {
    const htmlShow = document.getElementById("showHideElement");
    if (htmlShow.style.display === "none") {
        htmlShow.style.display = "block";
    }
}

function hideBanner() {
    const htmlShow = document.getElementById("showHideElement");
    if (htmlShow.style.display === "block") {
        htmlShow.style.display = "none";
    }
}
function onDeleteCreditsInfo(btn){
    console.log(btn)
    children = btn.parentElement.parentElement.children;
    id = -1
    bankName = ""
    description = ""
    percent = -1
    for (let i = 0; i < children.length; i++) {
        if (children[i].tagName.toLowerCase() != "td") {
            continue
        }
        if (children[i].getAttribute("name") == "id") {
            id = +children[i].innerHTML
        } else if (children[i].getAttribute("name") == "bankName") {
            bankName = children[i].innerHTML
        } else if (children[i].getAttribute("name") == "description") {
            description = children[i].innerHTML
        } else if (children[i].getAttribute("name") == "percent") {
            strpercent = children[i].innerHTML
            percent = +strpercent.substr(0, strpercent.length - 1)
        }
    }
    var obj = new Object()
    obj.id = id
    obj.bankName = bankName
    obj.description = description
    obj.percent = percent
    var jsonString = JSON.stringify(obj)
    console.log(jsonString)

    fetch(envURL + '/delete', {
        method: 'DELETE', // or 'PUT'
        headers: {
            'Content-Type': 'application/json'
        },
        contentType: "application/json",
        body: jsonString,
    })
    //.then(res => res.json())
        .then(response =>
        {
            if(response.ok){
               showDeleteBanner();
               setInterval(hideDeleteBanner, 1000)
               setInterval('refresh()', 1000);
               console.log("success")

            }else{
            alert("wrong arguments ! ")
            }

        })

        .catch(err => {
        console.log("error")
        } );


}

function showDeleteBanner() {
    const htmlShow = document.getElementById("deleteCredit");
    if (htmlShow.style.display === "none") {
        htmlShow.style.display = "block";
    }
}

function hideDeleteBanner() {
    const htmlShow = document.getElementById("deleteCredit");
    if (htmlShow.style.display === "block") {
        htmlShow.style.display = "none";
    }
 }