package com.example.gpbookingapplication.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gpbookingapplication.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts(){
        if (mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProduct();
        }
        return mutableProductList;
    }

    private void loadProduct(){
        List<Product> productList = new ArrayList<>();

        productList.add(new Product(UUID.randomUUID().toString(), "Allacan", 7.89, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/ALLACAN.jpg?alt=media&token=e9709888-f973-4a04-815d-ef7e37147edb",
                "Hay Fever and Allergy Relief.Suitable for: Adults and children aged 6 years and over"));

        productList.add(new Product(UUID.randomUUID().toString(), "Brufen DS", 4.50, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/Brufensyrup.png?alt=media&token=f55d8a56-75c5-4c75-8ac8-0f002b0f9e36",
                "Brufen suspension exhibits antipyretic, analegesic and anti inflammatory, properties with a good safety profile." ));

        productList.add(new Product(UUID.randomUUID().toString(), "Pulse Oximeter", 11.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/Pulse%20Oximeter%20Fingertip%20Blood%20Pressure%20Monitor.jpg?alt=media&token=ac0185ea-fe55-4b7d-a804-1d5ccb4f5d0a",
                "Low Prices on Pulse Oximeter"));

        productList.add(new Product(UUID.randomUUID().toString(), "Sleepwell", 9.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/Sleepwell.jpg?alt=media&token=05dd9d7f-36d7-4a94-8bbd-dde84da6f8f0",
                "Traditional herbal medicinal product used to relieve sleep disturbances due to symptoms of mild anxiety based on long-standing use as a traditional herbal remedy."));

        productList.add(new Product(UUID.randomUUID().toString(), "Amoxicillion", 7.99, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/amoxicillin.png?alt=media&token=d3e2d696-c45e-4a6d-8122-89fa4fc54602",
                "Amoxicillin is an antibiotic. It's used to treat bacterial infections."));

        productList.add(new Product(UUID.randomUUID().toString(), "Anadin Extra", 3.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/anadin.png?alt=media&token=6ea0c784-e0b5-48e7-99e0-709b3ac9d135",
                "An aspirin tablet which also contains Caffeine and Paracetamol providing fast and effective pain relief for conditions."));

        productList.add(new Product(UUID.randomUUID().toString(), "Anticid", 6.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/anticid.png?alt=media&token=124688b1-f356-4ec8-aa8f-7fee6f5deb90",
                "Anticid is counteract (neutralise) the acid in your stomach to relieve indigestion and heartburn. "));

        productList.add(new Product(UUID.randomUUID().toString(), "Aspirin Plus", 4.25, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/asprin.png?alt=media&token=3023eb62-50ae-480c-af44-53ef25de4f63",
                "This medication is a combination of aspirin and caffeine. It is used to treat minor aches and pains."));

        productList.add(new Product(UUID.randomUUID().toString(), "Assicon", 3.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/assicon.jpg?alt=media&token=bf0f7cf1-42b9-463d-b3a0-3f9843964465",
                "It reduces the amount of acid produced by your stomach."));

        productList.add(new Product(UUID.randomUUID().toString(), "Bandage", 2.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/bandage.jpg?alt=media&token=64d4128d-74ad-40b4-aab9-987687468af2",
                " piece of material used either to support a medical device such as a dressing or splint."));

        productList.add(new Product(UUID.randomUUID().toString(), "Benylin", 6.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/benylin.jpg?alt=media&token=37ea5c13-0284-43e2-91cf-039622cf5a3f",
                "Benylin syrup contains the active ingredient dextromethorphan which is a cough suppressant."));

        productList.add(new Product(UUID.randomUUID().toString(), "Gelusil Plus", 3.00, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/bisacodyl%20%20(1).png?alt=media&token=6c831dc9-2e32-4091-82f7-e631b7816b52",
                "Gelusil Plus Liquorice Heartburn Relief In Pregnancy Suspension 200ml relieves heartburn."));

        productList.add(new Product(UUID.randomUUID().toString(), "Dulcolax", 3.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/bisacodyl%20%20(3).png?alt=media&token=e2fdbc99-1b24-478d-a750-1f0d0d327c03",
                "Dulcolax (bisacodyl) is a laxative that stimulates bowel movements. Dulcolax is used to treat constipation."));

        productList.add(new Product(UUID.randomUUID().toString(), "Brain Complex", 15.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/brain%20complax.jpg?alt=media&token=8649f0cc-577a-4af0-af93-b6a61a93f1ae",
                "Brain Complex is a natural food nutrition supplement that works to support your daily diet for your brain health and performance."));

        productList.add(new Product(UUID.randomUUID().toString(), "Brufen", 4.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/brufen.png?alt=media&token=1b251b73-6b3a-4fc7-8ae9-b8494422ec81",
                "A white, pillow-shaped, film-coated tablet. Brufen is indicated for its analgesic and anti-inflammatory effects in the treatment of rheumatoid arthritis."));

        productList.add(new Product(UUID.randomUUID().toString(), "Burnaid", 10.49, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/burnaid.jpg?alt=media&token=69d4549f-8a11-45c0-8c9a-1137eaea3653",
                "Burnaid Burn Kit is a handy first aid burn treatment kit, this little kid is handy to keep around just in case of emergencies. The kit can be used to help cool, soothe and relieve pain caused by minor burns, scales and sunburn."));

        productList.add(new Product(UUID.randomUUID().toString(), "C Powder", 12.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/c%20powder.webp?alt=media&token=460d0ee2-6332-4986-b0fa-6b81410a8fef",
                "Vitamin C is a water-soluble vitamin that helps fight free radicals, which can lead to oxidative stress and the premature ageing of cells."));

        productList.add(new Product(UUID.randomUUID().toString(), "Calpol 6+", 6.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/calpol%206%2B%20years.jpg?alt=media&token=6aab8c8b-da8e-41e0-8551-6e75776cb4b7",
                "Calpol Six Plus Suspension is indicated for the treatment of mild to moderate pain and as an antipyretic."));

        productList.add(new Product(UUID.randomUUID().toString(), "Calpol 2+", 3.49, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/calpol_2%2B_months.png?alt=media&token=ec90c370-922d-4610-bd5e-65cf2934218f",
                "Fever (raised temperature), Post-immunisation fever, Cold & flu symptoms, Teething, Headache, Sore throat, Earache, Other aches & pains."));

        productList.add(new Product(UUID.randomUUID().toString(), "Canesten Cream", 4.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/canesten.jpeg?alt=media&token=c1ad8bf8-10b8-4cc1-a23f-d78309727da8",
                "Product description. Provides soothing relief from the irritation caused by fungal infections."));

        productList.add(new Product(UUID.randomUUID().toString(), "Centrum", 5.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/centrum.jpg?alt=media&token=e51d9b4b-c6ec-4851-bd4a-21e48ccfb422",
                "Centrum multivitamin to support the everyday health and wellbeing of men."));

        productList.add(new Product(UUID.randomUUID().toString(), "Cetirizine Hydrochloride", 1.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/cetirizine.png?alt=media&token=fa2d3ca6-a0a2-4a31-b250-77939213955d",
                "Cetirizine Hydrochloride 10mg Tablets are used for the relief of symptoms of hayfever and other allergic conditions."));

        productList.add(new Product(UUID.randomUUID().toString(), "Clotrimazole", 2.15, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/clotrimazole.jpg?alt=media&token=2a70ac1f-68bc-4910-83ff-a4a99bdc3e8b",
                "Clotrimazole reduces vaginal burning, itching, and discharge that may occur with this condition."));

        productList.add(new Product(UUID.randomUUID().toString(), "Cofsils", 2.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/cofsils.jpg?alt=media&token=cd806a79-5052-45f2-8784-51210c1f0eaf",
                "Cofsils Lozenges kills 99.9% germs* and provides you quick relief from sore throat."));

        productList.add(new Product(UUID.randomUUID().toString(), "Covonia", 5.09, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/covonia.jpg?alt=media&token=67d8dc42-6525-4671-b7e1-5e3ab48f3579",
                "Covonia dry & tickly cough linctus contains glycerol. The sugary syrup works by coating and soothing the back of the throat. "));

        productList.add(new Product(UUID.randomUUID().toString(), "Curafil Gel", 21.15, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/cream.png?alt=media&token=2e149670-c652-4aea-9c52-b4d16d97c88a",
                "Kendall Curafil Gel Wound Dressing conforms to the wound and promotes moist wound healing environment by providing high moisture content."));

        productList.add(new Product(UUID.randomUUID().toString(), "Day & Night Nurse", 8.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/day-night-nurse.jpg?alt=media&token=364f6e45-343c-437c-b8c8-e4456f34f8e7",
                "Day & Night Nurse Capsules Offer Relief From Cold and Flu Day and Night."));

        productList.add(new Product(UUID.randomUUID().toString(), "Optrex Eye Drop", 4.76, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/eye_drop.png?alt=media&token=4073b215-fdcc-482f-9d7a-55de61be67ec",
                "Optrex Refreshing Eye Drops for Tired Eyes - 10ml. A moisture replenishing formula, with natural plant extracts to help eyes feel soothed."));

        productList.add(new Product(UUID.randomUUID().toString(), "Floradix Liquid", 14.40, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/floradix-liquid.jpg?alt=media&token=d939cd27-7b6f-41c3-9312-b6f1e336f47d",
                "Floradix is easy to take and helps safeguard the balance of iron and vitamins B1, B2, B6, B12 and C."));

        productList.add(new Product(UUID.randomUUID().toString(), "Focus factor", 25.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/focus%20factor.jpg?alt=media&token=ddcf5acd-3776-4e74-8d49-568cba419c52",
                "Focus Factor Original pills contain a powerful combination of vitamins, minerals, and neuro-nutrients."));

        productList.add(new Product(UUID.randomUUID().toString(), "Folic Acid", 3.95, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/folic%20acid.jpg?alt=media&token=73b21e0c-85d5-4473-a06d-dcee3c1bc7be",
                "Helps tissues grow and cells work. Works with vitamin B12 and vitamin C to help the body break down, use, and create new proteins."));

        productList.add(new Product(UUID.randomUUID().toString(), "Fucidin H", 15.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/fucidin%20cream.jpg?alt=media&token=a7c4b78e-0762-437a-a116-d1c99a0819dd",
                "Fucidin H Cream contains the active ingredients hydrocortisone 1%, which is an anti-inflammatory steroid, and fusidic acid 2%,"));

        productList.add(new Product(UUID.randomUUID().toString(), "Gavisol", 6.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/gavisol.jpg?alt=media&token=0c6eab45-c20c-4c3c-a4cd-a3052d2ac9a9",
                "On ingestion the product reacts rapidly with gastric acid to form a raft of alginic acid gel having a near neutral pH and which floats on the stomach contents."));

        productList.add(new Product(UUID.randomUUID().toString(), "Greens", 19.70, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/greens.png?alt=media&token=2c749f83-8941-4814-9317-58b27b3ee038",
                " tablet contains as much vitamin B5 as 15 cups of broccoli, vitamin B6 as 6 cups of spinach, vitamin C as 6 oranges, and vitamin B12 of seven cups of milk."));

        productList.add(new Product(UUID.randomUUID().toString(), "Haliborange", 9.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/haliborange.png?alt=media&token=6d554674-4d90-4790-8b79-d8fb4d8d19a2",
                "Haliborange Vitamins A, C & D are a tasty way for the whole family to get some of the essential vitamins"));

        productList.add(new Product(UUID.randomUUID().toString(), "Lemsip Max", 4.50, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/lamsip.jpg?alt=media&token=ab9a011a-e1b1-4c25-92c1-b871385a719f",
                "Lemsip Max All in One is a combination of active ingredients which are effective in relieving the symptoms associated with colds and flu."));

        productList.add(new Product(UUID.randomUUID().toString(), "Maca", 11.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/maca.webp?alt=media&token=64b5bf99-c515-4620-ac50-8c84b98ba44b",
                "Maca is a relative of the radish and has an odor similar to butterscotch. Its root is used to make medicine."));

        productList.add(new Product(UUID.randomUUID().toString(), "Multi-Vitamins", 6.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/multi-vitamins.png?alt=media&token=0da82fd2-59c3-4600-bb79-b112f32104e4",
                "A multivitamin is a preparation intended to serve as a dietary supplement with vitamins, dietary minerals, and other nutritional elements."));

        productList.add(new Product(UUID.randomUUID().toString(), "Nurofen", 4.09, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/nurofen.jpeg?alt=media&token=967f82d5-6687-4c4c-83a7-bf4b270784b8",
                "NUROFEN PLUS tablets contain the active ingredients Ibuprofen and Codeine phosphate."));

        productList.add(new Product(UUID.randomUUID().toString(), "Nuromol", 5.19, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/nuromol.jpg?alt=media&token=940d0dde-5c42-409b-be38-a627c834c8fe",
                "Nuromol is a white to off white, pearlescent, oval shaped, film coated tablet, de-bossed with an identifying helix."));

        productList.add(new Product(UUID.randomUUID().toString(), "Omega-3", 9.95, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/omega-3.png?alt=media&token=89526d34-0b11-4ad6-a2f7-cec528befe0e",
                "A class of essential fatty acids found in fish oils, especially from salmon and other cold-water fish, that acts to lower the levels of cholesterol and LDL (low-density lipoproteins) in the blood."));

        productList.add(new Product(UUID.randomUUID().toString(), "Paracetamol", 4.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/paracetamol.png?alt=media&token=4de126a2-a06a-46d7-b7d3-7415d91b4eb3",
                "Paracetamol, also known as acetaminophen, is a medication used to treat pain and fever. It is typically used for mild to moderate pain relief."));

        productList.add(new Product(UUID.randomUUID().toString(), "Perfectil T-Active", 18.20, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/perfectil.jpg?alt=media&token=1578a863-a087-43e2-a15c-f450b944c11d",
                "Our skin, hair and nails all require specific vitamins and nutrients. Perfectil works by delivering nourishment through the bloodstream."));

        productList.add(new Product(UUID.randomUUID().toString(), "M-Soft Plaster", 3.13, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/plaster.png?alt=media&token=f99b24c7-7e49-48d8-9bfa-68b7ca034b63",
                "self-adherent plaster that can be used to cover a range of wounds."));

        productList.add(new Product(UUID.randomUUID().toString(), "Pregnacare", 14.95, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/pregnacare.jpg?alt=media&token=2d3c4525-e92c-4bf6-a3d2-618718b8bf0b",
                "Pregnacare provides a range of nutrients for overall support, all at sensible, carefully balanced levels."));

        productList.add(new Product(UUID.randomUUID().toString(), "Pressure Checker", 54.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/pressure%20checker.png?alt=media&token=a75ddc76-f513-4131-b5b9-8f8996fa0198",
                "A sphygmomanometer, also known as a blood pressure monitor, or blood pressure gauge."));

        productList.add(new Product(UUID.randomUUID().toString(), "Rennie", 4.89, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/rennie.jpg?alt=media&token=cebaa5f5-0d3c-4423-9d19-4f54f3d49060",
                "Rennie Peppermint is an antacid tablet which quickly relieves indigestion, heartburn, acid indigestion, dyspepsia, hyperacidity, nervous indigestion."));

        productList.add(new Product(UUID.randomUUID().toString(), "Soothe & Cool", 15.21, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/soothe%20%26%20cool.jpeg?alt=media&token=0f8498bf-6a6f-40f0-996d-4179ba122ac6",
                "Soothe & Cool Moisture Barrier Ointment creates a barrier to prevent moisture and fecal matter from contacting the skin. "));

        productList.add(new Product(UUID.randomUUID().toString(), "Soriafit", 3.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/soriafit.jpg?alt=media&token=ee3629d0-a9b2-4cd8-aff2-5a81702068e2",
                "Soriafit effectively helps to treat psoriasis in both acute & chronic conditions."));

        productList.add(new Product(UUID.randomUUID().toString(), "Spirulina", 10.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/spirulina.jpg?alt=media&token=163edd87-7f07-4d25-bd12-6c69c06009f3",
                "Spirulina (Arthrospira platensis) is a filamentous and multicellular blue-green alga capable of reducing inflammation and also manifesting antioxidant effects."));

        productList.add(new Product(UUID.randomUUID().toString(), "Sudocrem", 6.09, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/sudocrem.jpg?alt=media&token=ac708747-a266-404a-adc9-49ed5e1846ab",
                "Sudocrem is an over-the-counter medicated cream aimed primarily at the treatment of nappy rash."));

        productList.add(new Product(UUID.randomUUID().toString(), "Support Bandage", 6.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/support%20bandage.png?alt=media&token=870212e5-8884-49c7-b25d-7c8814e4eac9",
                "Support bandages provide retention and prevent the development of a deformity or change in shape of a mass of tissue due to swelling or sagging."));

        productList.add(new Product(UUID.randomUUID().toString(), "Supradyn", 18.91, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/supradyn.jpg?alt=media&token=92507f3b-7f96-471c-803b-b4384b52e31e",
                "Supradyn is a Multivitamin tablet with minerals and trace elements. It contains 11 vitamins – A, B1, B2, B3, B5, B6, B7, B12, C, D3, and E. It contains 5 minerals."));

        productList.add(new Product(UUID.randomUUID().toString(), "Marical-D", 4.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/syrup.png?alt=media&token=74357237-1220-4fd1-bb56-13e9fdd2714f",
                "MARICAL-D syrup is a complete bone food supplement that is composed of Coral calcium, magnesium and Vitamin D3."));

        productList.add(new Product(UUID.randomUUID().toString(), "Revand T-Paste", 8.00, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/tooth_paste.png?alt=media&token=d4cea849-82d9-4458-9b84-13c2e01ea1cc",
                " Revand Toothpaste is a known solution for promoting good dental hygiene to combat plaque and gingivitis. "));

        productList.add(new Product(UUID.randomUUID().toString(), "T-Bandage", 3.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/tubular%20bandage.jpg?alt=media&token=3b75efa4-903b-4f1d-bf3c-026f38af4865",
                "tubular bandage is a knit bandage with a tubular shape people can wear over an extremity to secure a dressing. "));

        productList.add(new Product(UUID.randomUUID().toString(), "Vitamin D3", 12.99, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/vitamin%20d3.jpg?alt=media&token=1954afc5-7803-4b52-bc17-537426f97bd8",
                "A vitamin produced by the body when exposed to ultraviolet light or obtained from dietary sources. "));

        productList.add(new Product(UUID.randomUUID().toString(), "Voltaren", 5.59, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/voltaren.jpg?alt=media&token=ca3d2a02-0c5f-44ce-86aa-f4913859f953",
                "Voltaren Gel (diclofenac sodium topical gel) is a topical gel nonsteroidal anti-inflammatory drug (NSAID) used to treat pain of osteoarthritis of joints that are amenable to topical treatment."));

        productList.add(new Product(UUID.randomUUID().toString(), "Waterproof Plaster", 2.79, false,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/water%20proof%20plaster.jpg?alt=media&token=2a82ff67-ae46-45ae-8c40-cde9aa51d5bc",
                "waterproof plaster is an extremely waterproof dry plaster mixture that will create a waterproof barrier after application; while it stays breathable at the same time."));

        productList.add(new Product(UUID.randomUUID().toString(), "Wellwoman", 7.95, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/well%20woman.jpg?alt=media&token=2c1c6732-ae5e-4e76-9c65-267fe36ecb6b",
                "Vitabiotics Wellwoman original capsules a spectrum of micronutrients for all-round nutritional support including vitamins B6, B12 and iron."));

        productList.add(new Product(UUID.randomUUID().toString(), "Wellman", 5.50, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/wellman.webp?alt=media&token=83f28527-7fc4-4d03-8355-838e70d7a53b",
                "Wellman has been developed to help maintain health in men of all ages. It is ideal for those with active and hectic lifestyles."));

        productList.add(new Product(UUID.randomUUID().toString(), "Cotton Wool", 1.60, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/wool.jpg?alt=media&token=f3bafca7-9f77-4aae-8ee1-45522a13a1ff",
                "Cotton wool is a soft mass of cotton, used especially for applying liquids or creams to your skin."));

        productList.add(new Product(UUID.randomUUID().toString(), "P-Stips", 11.49, true,
                "https://firebasestorage.googleapis.com/v0/b/gp-booking-application-277ab.appspot.com/o/p-stips.jpg?alt=media&token=d9f4e814-2f9e-4883-a952-fed7dfedaffc",
                "A section of the strip changes color if hCG is detected, indicating that you are probably pregnant."));


        mutableProductList.setValue(productList);
    }
}
