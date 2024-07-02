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

    def test_JobImage(self):
        self.driver.get("https://alchemy.hguy.co/jobs")


        headerImage1 = self.driver.find_element(By.CSS_SELECTOR,  ".attachment-large")
        headerImage2 = self.driver.find_element(By.XPATH, "/html/body/div/div/div/div/main/article/header/div/img")
        print(headerImage1.get_attribute("src"))
        print(headerImage2.get_attribute("src"))