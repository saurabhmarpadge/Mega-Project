import React from 'react';
import './App.css';
import Axios from 'axios';

class Add_Book extends React.Component {
  
  constructor(props){
    super(props);
    this.state =  {
      data : {
        name: "",
        author: "",
        price: "",
        isbn:""
      }
    };

    this.nameChange = this.nameChange.bind(this);
    this.authorChange = this.authorChange.bind(this);
    this.priceChange = this.authorChange.bind(this);
    this.isbnChange = this.authorChange.bind(this);
    this.addBook = this.addBook.bind(this);
  }

  nameChange(event) {
    this.state.data.name = event.target.value;
  }

  authorChange(event) {
    this.state.data.author = event.target.value;
  }

  priceChange(event) {
        this.state.data.price = event.target.value;
    }

    isbnChange(event) {
        this.state.data.isbn = event.target.value;
    }

  render(){
  return ( 
    <div>
      <form onSubmit={this.addBook}>
        <div className="form-group">
            <label htmlFor="bookName">Name of the Book</label>
            <input type="text" className="form-control" id="bookName" aria-describedby="bookName" placeholder="Enter book name" onChange={this.nameChange}/>
        </div>
        <div className="form-group">
            <label htmlFor="author">Author</label>
            <input type="text" className="form-control" id="author" placeholder="Enter author name" onChange={this.authorChange}/>
        </div>
        <div className="form-group">
            <label htmlFor="price">Price</label>
            <input type="text" className="form-control" id="price" placeholder="Enter price" onChange={this.priceChange}/>
        </div>
        <div className="form-group">
            <label htmlFor="isbn">ISBN</label>
            <input type="text" className="form-control" id="isbn" placeholder="Enter isbn" onChange={this.isbnChange}/>
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
        </form>  
    </div>
  );
  }

  addBook(event) {
    const headers = {
      Accept: "application/json",
      "Content-Type": "application/json"
    };
    Axios.post("http://localhost:8182/library-service/book", this.state.data , {headers} ).then(response => {
    if(response.status === 201){
       alert("Success");
     }
     })
     event.preventDefault();
  }
}

export default Add_Book;
