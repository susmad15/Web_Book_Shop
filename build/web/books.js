class Books {

    getFillteredAuthors(evt) {

        console.log("Start getFillteredAuthors");

        if (evt.keyCode === 13) {

            console.log("Drinnen!!!!");

            var url = "BookShopController";

            var authorInput = document.getElementById("authorInput").value;

            fetch(url, {method: "POST", body: authorInput})
                    .then(response => response.json())
                    .then(data => {
                        console.log("DataAuthors: " + data);
                        this.setupSelectAuthor(data)
                    });
        }


    }

    showBookData() {
        console.log("Start showBookData");

        var url = "BookDetailController";

        var selectedAuthor = document.getElementById("authorSelect").value;

        console.log("Selected Author: " + selectedAuthor);

        fetch(url, {method: "POST", body: selectedAuthor})
                .then(response => {
                    console.log("Response: ", response);
                    return response.json();
                }).then(data => {
            console.log("Data: ", data);
            this.setupSelectBook(data);
        });

    }

    setupSelectAuthor(json) {

        var selectString = "";

        for (var i = 0; i < json.length; i++) {
            selectString += "<option>" + json[i].lastname + ", " + json[i].firstname + "</option>";
        }

        document.getElementById("authorSelect").innerHTML = selectString;
    }

    setupSelectBook(json) {
        var selectString = "";

        selectString += "<option> BookId: " + json.bookId + "</option>";
        selectString += "<option> Title: " + json.title + "</option>";
        selectString += "<option> Price: " + json.price + "€ </option>";
        
        console.log("SelectString: " + selectString);

        document.getElementById("bookSelect").innerHTML = selectString;
    }

}