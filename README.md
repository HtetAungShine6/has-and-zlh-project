# TODO Tutorial


### Step 1.0.0
- Setup 3 fragments with Viewpager
- Create adapter for viewpager

#### Step 1.0.1
- Add kotlin extention plugin in bulid.gradle(app)
- Add lifecycle and viewmodel plugins in bulid.gradle(app) 

### Step 2.0.0
- Create Share View Model
- Create a variable to store for edit text data
- Create a function to retrieve from edit text data sender (fragment 1)

### Step 3.0.0
- In fragment 1,
- Create a object using Viewmodelprovider
- Setup a button click action to store edit text data

### Step 4.0.0
- In fragment 2,
- Create a object using Viewmodelprovider to observe LiveData from ShareViewModel
- Show that LiveData as Result

### Step 5.0.0
- In MainActivity,
- Show 3 fragments with tab
- In fragment1 (tab1),send edit text value from tab1 to tab2 after button click

