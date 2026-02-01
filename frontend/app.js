const API_URL = "http://localhost:8080/books";

// Load books when page opens
window.onload = loadBooks;

function loadBooks() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("bookList");
            list.innerHTML = "";

            data.forEach(book => {
                const li = document.createElement("li");

                li.innerHTML = `
                    ${book.title} by ${book.author}
                    (Copies:
                    <input type="number"
                           value="${book.copies}"
                           id="copy-${book.id}"
                           style="width:60px" />)
                    <button onclick="updateBook(${book.id})">Update</button>
                    <button onclick="deleteBook(${book.id})">Delete</button>
                `;

                list.appendChild(li);
            });
        });
}

function addBook() {
    const title = document.getElementById("title").value;
    const author = document.getElementById("author").value;
    const copies = document.getElementById("copies").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title,
            author: author,
            copies: copies
        })
    })
    .then(() => {
        loadBooks();
        document.getElementById("title").value = "";
        document.getElementById("author").value = "";
        document.getElementById("copies").value = "";
    });
}

function deleteBook(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => loadBooks());
}

function updateBook(id) {
    const copies = document.getElementById(`copy-${id}`).value;

    fetch(`${API_URL}/${id}?copies=${copies}`, {
        method: "PUT"
    })
    .then(() => loadBooks());
}
