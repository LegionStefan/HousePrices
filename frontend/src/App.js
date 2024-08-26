import './App.css';
import {Component} from "react";

class App extends Component {
  state = {
    HousePrices: [],
  };

  async componentDidMount() {
    const response = await fetch('/housePrices');
    const body = await response.json();
    console.log(response);

    this.setState({HousePrices: body});
  }

  render() {
    const {HousePrices} = this.state;

    return (
        <div className="App">
          <h2>HousePrices</h2>
          {HousePrices?.map(HousePrice => (
              <div key={HousePrice.id}>
                {HousePrice.price} - {HousePrice.date}
              </div>
          ))}
        </div>
    )
  };
}

export default App;
