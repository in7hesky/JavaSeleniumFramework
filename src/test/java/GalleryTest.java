import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Gallery Interactions")
public class GalleryTest extends BaseTest {

    @Test
    public void shouldToggleFullSizeViewAfterClickingOnImage() {
        var galleryPage = app.toGalleryPage();

        galleryPage.clickOnImageForFullSizeView(0);

        Assertions.assertTrue(galleryPage.fullSizeViewModeIsOn());
    }

    @Test
    public void shouldLoadEqualToInitialAmountOfNewImages() {
        var galleryPage = app.toGalleryPage();

        int imagesInitialAmount = galleryPage.getCurrentImagesAmount();
        galleryPage.clickMoreImagesButton();

        Assertions.assertEquals(imagesInitialAmount * 2, galleryPage.getCurrentImagesAmount());
    }
}
