# Platform Science Test
Architecture Layers

View/UI -> ViewModel -> UseCase -> Repository/Mapper - DataSource

Libs:
- Moshi
- Dagger/Hilt

Implementation:

1) In the UI layer we are using an Activity/Adapter to display the list of drivers, once you click on any item
   a new fragment dialog appears with the final result.
2) The ViewModel only uses the livedata to provide data to the UI layer.
3) All the business logic is FindingMaxSuitabilityUseCase. There you can see step by step all requirements implemented
   in any function.
4) Using moshi we parse the data to kotlin object.


Assumptions:

To solve this, we assumed that the driver list already has the correct priority which means we get the first driver and this one is who going
to select the first route, once the driver has one route, we remove that item from the list, until the last driver only can get the shipment available.

![Screenshot_20230608_230117](https://github.com/OmarVM/PlatformScienceTest/assets/18560308/be1de100-8af3-4970-81b3-f40c2ddb69a3)
![Screenshot_20230608_230140](https://github.com/OmarVM/PlatformScienceTest/assets/18560308/adab4b46-860e-44ae-b81a-e6a9869ef6ab)
