import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By


# Create a fixture to initialize our webdriver
@pytest.fixture(scope="session")
def setup(request):
    # Initialize the webdriver
    driver = webdriver.Firefox()

    # Get the underlying collection
    session = request.node

    # Pass through the driver to the test class
    for item in session.items:
        cls = item.getparent(pytest.Class)
        setattr(cls.obj, "driver", driver)

    # Execute the test method
    yield

    # Close the browser once the test has ended
    request.addfinalizer(driver.close)


@pytest.mark.usefixtures("setup")
class TestSite:

    def test_applyjob(self):
        self.driver.get("https://alchemy.hguy.co/jobs")

        Jobslink = self.driver.find_element(By.LINK_TEXT, "Jobs")
        Jobslink.click()
        #Jobsection = self.driver.find_element(By.CLASS_NAME, "entry-title")
        #print("Heading: ", Jobsection.text)
        GetTitle = self.driver.title
        Expected_title = "Jobs – Alchemy Jobs"

        assert GetTitle == Expected_title, "Title mismatch"
        search = self.driver.find_element(By.XPATH, "//input[@id='search_keywords']")
        place =  self.driver.find_element(By.XPATH, "//input[@id='search_location']")
        search.send_keys("Banking")
        place.send_keys("Banglore")
        #SearchJobs = self.driver.find_element(By.LINK_TEXT, "Search Jobs")
        SearchJobs = self.driver.find_element(By.XPATH, "//input[@type= 'submit' and @value = 'Search Jobs']")
        print(SearchJobs)
        SearchJobs.click()
        self.driver.implicitly_wait(90)
        profile = self.driver.find_element(By.XPATH, "/html/body/div/div/div/div/main/article/div/div/ul/li/a/div[1]/h3")
        print(profile.text)
        profile.click()
        self.driver.implicitly_wait(90)
        ApplyJob = self.driver.find_element(By.XPATH, "//input[@type= 'button' and @value = 'Apply for job']")
        print(ApplyJob)
        ApplyJob.click()
        self.driver.implicitly_wait(3600)
        Jobe = self.driver.find_element(By.CLASS_NAME, "job_application_email")
        print(Jobe)
        Jobe.click()
        self.driver.implicitly_wait(3600)