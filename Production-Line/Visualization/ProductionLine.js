class ProductionLine{

    constructor(){
      this.input = [];
      this.output = [];
      this.robotArm = new Tower();
      this.running = false;
      this.newRun = 0;
      //0 for not running, 1 for processing input
      //2 for sending to output
    }

    getInput(){
      return this.input;
    }

    getOutput(){
      return this.output;
    }

    getRobotArm(){
      return this.robotArm;
    }

    getRun(){
      return this.newRun;
    }

    setRun(r){
      this.running = r;
    }

    setRunn(r){
      this.newRun = r;
    }

    addDisk(d){
      this.input.push(d);
    }

    drawInput(){
      noStroke();
      fill(255);
      //rect(0, windowHeight * .8 - 35, windowWidth * .40 +10, 35);
      let inLen = windowWidth * .40;
      //console.log(inLen);
      let y = windowHeight * .8 - 20;
      for(let inp of this.input){
        let x = inLen - ((10 * inp.getRadius()) - 5);
        inp.coord(x,y);
        inp.display();
        inLen = x -10;
        //console.log(inLen);
      }
    }

    drawOutput(){
      let ouStart = windowWidth * .6;
      let y = windowHeight * .8;
      for(let ou of this.output){
        let len = ou.maxDisk();
        ou.display(ouStart + (5 * len), y);
        ouStart += ((10 * len) + 2);
      }
    }

    drawRobotArm(){
      noStroke();
      let y = windowHeight * .8 - 80;
      let mid = windowWidth * .5 + 15;
      this.robotArm.display(mid, y);
    }

    process(){
      if (this.input.length !== 0){
        var toSend = this.input.shift();
        this.robotArm.push(toSend);
      }
      while (this.input.length !== 0 && this.input[0].getRadius() >= this.robotArm.getDisk(this.robotArm.size() - 1).getRadius()){
        var toS = this.input.shift();
        //console.log("About to add: " + toS);
        this.robotArm.push(toS);
      }
      //console.log(this.robotArm);
    }

    unloadRobot(){
      //this.drawRobotArm();
      var toOutQueue = new Tower();
      //toOutQueue.push(new Disk(3));
  		while(this.robotArm.size() !== 0){
          var top = this.robotArm.pop();
          toOutQueue.push(top);
          //console.log(top);
      }
      //console.log(toOutQueue);
  		this.output.push(toOutQueue.copy());
    }

    run(){
      /*if(this.input.length !== 0 && this.running === true){

        this.drawInput();
        this.process();
  			this.unloadRobot();
        this.drawOutput();
        this.setRun(false);
  		}*/
      if(this.input.length !== 0 && this.newRun === 1){
          this.process();
          this.newRun = 4;
      }
      if(this.newRun === 2){
        this.unloadRobot();
        this.newRun = 0;
      }
  	}

    removeTower() {
  		return this.output.pop();
  	}
}
