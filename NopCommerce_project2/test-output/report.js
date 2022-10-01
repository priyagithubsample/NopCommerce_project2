$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/Loginnop.feature");
formatter.feature({
  "name": "login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that user successfully login with valid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user launch chrome browser",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.user_launch_chrome_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user opens URL",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_opens_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters email and password",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.user_enters_email_as_and_password_as()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page tittle should be \"Dashboard / nopCommerce administration\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.page_tittle_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click on log out button",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.user_click_on_log_out_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page tittle should be \"Your store. Login\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.page_tittle_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close browser",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.close_browser()"
});
formatter.result({
  "status": "passed"
});
});