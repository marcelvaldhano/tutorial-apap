import React from "react";
import List from "components/List/index.js"
import listMovies from "movies.json";
import './App.css';


export default class App extends React.Component{
  state = {
    favItems: [],
    boolean: false
  };

  render(){
    const{favItems, boolean} =this.state
    let button;
      if(!(this.state.favItems.length===0)){
        button=<button type="button" onClick={this.deleteOnClick}>Delete</button>
    }
    return(
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorite Movies App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
        <div className="d-flex justify-content-center align-items-center">

          <label className="switch">
            <input type="checkbox" onClick={this.toggleButton} />
            <span className="slider round"></span>
          </label>

          <h4 className="fav-margin">My Favourites</h4>
        </div>
        <div className="container pt-3">
          <div className="row">
            <div className="col-sm">
              <List
              title="List Movies"
              items={listMovies}
              onItemClick={this.handleItemClick}
              />
            </div>

            <div className={`col-sm ${boolean ? "d-block" : "d-none"}`}>
              {button}
                <List title="My Favorites"
                items={favItems}
                onItemClick={this.handleFavClick}
            />
            </div>
            </div>
        </div>
      </div>
    );
  }

  
  handleItemClick= item=>{
    const newItems=[...this.state.favItems];
    const newItem={...item};

    const targetInd=newItems.findIndex((it)=>it.id==newItem.id);

    if(targetInd<0) newItems.push(newItem);
    
    this.setState({favItems:newItems});
  };

  handleFavClick = item => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);
    else newItems.splice(targetInd, 1);

    this.setState({ favItems: newItems });
  };

  toggleButton = () => {
    this.setState(currentState => ({
      boolean: !currentState.boolean
    }));
  };

  deleteOnClick=()=>{
    this.setState(
      this.state.favItems=[]
    );
  };

  // handleItemAdd=()(item)=>{
  //   const newItems = [...this.state.favItems];
  //   const newItem = { ...item };

  //   const targetInd = newItems.findIndex(it => it.id === newItem.id);


  // }
  
}

