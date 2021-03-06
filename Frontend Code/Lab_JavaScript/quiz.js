class Quiz {
    constructor(questions) {
      this.score = 0;
      this.questions = questions;
      this.index = 0;
    }
    getQuestionByIndex() {
      return this.questions[this.index];
    }
    checkForCorrectAnswer(answer) {
      let question = this.getQuestionByIndex();
      if (question.isCorrectAnswer(answer)) {
        this.score++;
      }
      this.index++;
    }
    isEnded() {
      return this.index === this.questions.length;
    }
  }
  
  class Question {
    constructor(questionText, choices, answer) {
      this.text = questionText;
      this.choices = choices;
      this.answer = answer;
    }
    isCorrectAnswer(selectedChoice) {
      return this.answer === selectedChoice;
    }
  }
  
  let questions = [
    new Question(
      "Javascript is an _______ language?",
      ["Object-Oriented", "Object Based", "Procedural", "None of Above"],
      "Object-riented"
    ),
    new Question(
      "JavaScript Supports?",
      ["Functions", "XHTML", "CSS", "HTML"],
      "Functions"
    ),
    new Question(
      "Which of the following keywords is used to define a variable in Javascript?",
      ["var", "let", "Both A & B", "None of Above"],
      "Both A & B"
    ),
    new Question(
      "Which language got maximum follwers?",
      ["JavaScript", "Java", "Phython", "Go"],
      "JavaScript"
    ),
    new Question(
      "Which of the following methods is used to access HTML elements using Javascript?",
      ["getElementbyId()", "getElementbyClassName()", "Both A & B", "None of Above"],
      "Both A & B"
    ),
    new Question(
      "Which of the following methods can be used to display data in some form using Javascript?",
      ["document.write()", "console.log()", "window.alert()", "All of the above"],
      "All of the above"
    ),
    new Question(
      "How can a datatype be declared to be a constant type?",
      ["const", "var", "let", "constant"],
      "const"
    ),
    new Question(
      "What does JSON stand for ?",
      [
        "Java Simple Object Notation",
        "JavaScript Object Notation",
        "Java Semi Object Notation",
        "None of the above",
      ],
      "JavaScript Object Notation"
    ),
  ];
  
  function loadQuestions() {
    if (quiz.isEnded()) {
      showFinalScores();
      return;
    }
  
    let currentQuestion = quiz.getQuestionByIndex();
    let questionElement = document.getElementById("question"); 
    questionElement.innerHTML = currentQuestion.text;
  
    let displayedChoices = currentQuestion.choices;
    for (let i = 0; i < displayedChoices.length; i++) {
      let eachChoiceElement = document.getElementById("choice" + i); 
      eachChoiceElement.innerHTML = displayedChoices[i];
  
      let eachChoiceBtn = document.getElementById("btn" + i); 
      eachChoiceBtn.onclick = function () {
        quiz.checkForCorrectAnswer(displayedChoices[i]); 
        loadQuestions();
      };
    }
  
    showProgress();
  }
  
  let quiz = new Quiz(questions);
  loadQuestions();
  
  function showFinalScores() {
    let resPercent = (quiz.score / questions.length) * 100;
    let scoresHTML = `
          <h1>Results... </h1>
          <h2 id='score'>Your Score is :- ${quiz.score} </h2>
          <h2> And overall percentage is :- ${resPercent}% </h2>
          <h1>Congratulations!!!</h1>
      `;
    let quizCanvas = document.getElementById("quiz");
    quizCanvas.innerHTML = scoresHTML;
  }
  
  function showProgress() {
    let questionNumber = quiz.index + 1;
    let progressElement = document.getElementById("progress");
    progressElement.innerHTML = `Question ${questionNumber} of ${quiz.questions.length}`;
  }