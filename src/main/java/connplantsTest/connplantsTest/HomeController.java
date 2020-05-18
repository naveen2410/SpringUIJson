/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package connplantsTest.connplantsTest;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

	UserService userService = new UserService();

   /* @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
	
	@GetMapping
	public String index() {
		return "redirect:/chart";
	}
	
	@GetMapping("/chart")
	public String loginUser1(Model model) {
		// model.addAttribute("username", new SearchCriteria());
		return "samplechart";
	}

	@GetMapping("/test")
	public String loginForm() {
		 //model.addAttribute("username", new SearchCriteria());
		return "test";
	}
	
	@GetMapping("/user")
	public String loginUser(Model model) {
		// model.addAttribute("username", new SearchCriteria());
		return "test";
	}
	
    @PostMapping("/api/search/{username}")
    public ResponseEntity<?> getSearchResultViaAjax(@PathVariable("username") String username) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
      

        List<User> users = userService.findByUserNameOrEmail(username);
        //result.setMsg("success");
        result.setResult(users);

        //String jsonStringResult = "{ \"result\": [ { \"username\": \"mkyongdeveloper"+username+"\", \"password\": \"59\", \"email\": \"mkyong@yahoo.com\" }, { \"username\": \"yflowdeveloper"+username+"\", \"password\": \"22\", \"email\": \"yflow@yahoo.com\" } ] }";
        String jsonStringResult = "{\"y\": 50,\"color\": \"red\",\"drilldown\": {\"categories\": [1,2,3,4], \"series\": [{\"type\": \"column\",\"name\": \"Target\",\"data\": [10.85, 7.35, 33.06, 2.81], \"color\": \"blue\"},{\"type\": \"column\",\"name\": \"Actual\",\"data\": [1, 5, 10, 15], \"color\": \"green\"}]}}";
        return ResponseEntity.ok(jsonStringResult);

    }
}
