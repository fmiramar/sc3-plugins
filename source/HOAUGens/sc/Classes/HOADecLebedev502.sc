HOADecLebedev502 : MultiOutUGen
{
  *ar { | in1, in2, in3, in4, in5, in6, in7, in8, in9, inputs_gain(0.0), outputs_gain(0.0), yes(0.0), speakers_radius(1.07) |
      ^this.multiNew('audio', in1, in2, in3, in4, in5, in6, in7, in8, in9, inputs_gain, outputs_gain, yes, speakers_radius)
  }

  *kr { | in1, in2, in3, in4, in5, in6, in7, in8, in9, inputs_gain(0.0), outputs_gain(0.0), yes(0.0), speakers_radius(1.07) |
      ^this.multiNew('control', in1, in2, in3, in4, in5, in6, in7, in8, in9, inputs_gain, outputs_gain, yes, speakers_radius)
  } 

  checkInputs {
    if (rate == 'audio', {
      9.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(50, rate)
  }

  name { ^"HOADecLebedev502" }
}

