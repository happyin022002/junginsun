/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0808.js
*@FileTitle : Information on Pending TPB
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

/****************************************************************************************
  Event code : 	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    			MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
  OTHER CASE : 	COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_TPB_0808 : business script for ESD_TPB_0808
     */
    function ESD_TPB_0808() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  
  var rowForCorrection = 0;


  

  	/**
	 * Setting IBTab Object Initial.
	 * Tab ID is tab1,tab2,...
	 * InitTab() function is called before the loadPage() function call from setupPage() function.
	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * onChange event of tab1
  	 * Implementing defined function from IBSheetConfig.js
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * Showing tab contents in case of clicking IBTab Object
  	 * ID of Grouped each tab DIV TAG defined "tabLayer"
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- Notice --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//Not a click button in case of zIndex under 2
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

  	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  	}
  	
  	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
  	function loadPage() {
  		for(i=0;i<sheetObjects.length;i++){
  		   //Setting startup environment. Change the name of the function
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			//Setting final environment.
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		
  		//doActionIBSheet(sheetObject,formObject,IBSEARCH);
  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
  		window.onunload = InitWinTopPendingTPBWin;
  	}
  	 
  	function InitWinTopPendingTPBWin(){
        try {
            // window.opener.top.document.PendingTPBWin = false;
            Set_Cookie( "PendingTPBWin", "N", 1, "", "", "" )
        } catch(e){}
    }

  	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
  	function initSheet(sheetObj,sheetNo) {

  		sheetObj.UseUtf8 = true;
  		switch(sheetNo) {
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					var cnt = 0;
  					//Setting height
  					style.height = 180;
  										
  					//Setting width
  					SheetWidth = mainTable.clientWidth;

  					//Setting Host info[Required][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

  					//Merge [Select, Default msNone]
  					MergeSheet = msHeaderOnly;

  				   //Editing allow [Select, Default false]
  					Editable = true;

  					//Setting row info[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 1, 1, 9, 100);

  					//Setting column info[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					//2009-07-31 O Wan-Ki
  					InitColumnInfo(4, 5, 0, true);

  					// Setting function a process from head
  					InitHeadMode(true, true, false, true, false, false)
  					
  					var HeadTitle = "|Data Status|TPB Data|Amount(USD)"; 

  					//Header info[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
  				   
  					//Property      [ROW,   COL, DATATYPE,      WIDTH, DATAALIGN,  COLMERGE,   SAVENAME,  KEYFIELD,  CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++, dtHiddenStatus,	100,  daCenter, 	false,  "ib_flag",	   false,          "",       dfNone,    	0,     	false,       true);
  					InitDataProperty(0, cnt++, dtData, 			130,   	daLeft,  	 true,    "title",     false,          "",       dfNone,    	0,     	false,       false);
  					InitDataProperty(0, cnt++, dtData,      	 60,   daRight,  	false,    	"cnt",     false,          "",       dfNone,    	0,     	false,       false);
  					InitDataProperty(0, cnt++, dtData,      	100,   daRight,  	false,    	"amt",     false,          "",       dfFloat,   	0,    	false,       false);
  				}
  				break;
  		}
  	}

  	/* Event handler defined process to button click event */
  	document.onclick = processButtonClick;
  	
  	/* Event handler is branch processing by name of button */
  	function processButtonClick(){
  		 /***** Assignment sheet in case of over 2 by tab ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");

  			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_close":
					InitWinTopPendingTPBWin();
					window.close();
					break;	
  				
  			} // end switch
  		}catch(e) {			
  			if( e == "[object Error]") {
  				ComShowMessage(getMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}
  	
  	/* Processing Sheet */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		
  		switch(sAction) {
  		
  		   case IBSEARCH:	  //Retrieve
  				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}
  		
  				formObj.f_cmd.value = SEARCH;
  				sheetObj.DoSearch4Post("ESD_TPB_0808GS.do", tpbFrmQryStr(formObj));
  				break;

  			case IBDOWNEXCEL:  //Excel download
  				sheetObj.SpeedDown2Excel(true);
  				break;
  				
  		}
  	}
  	
  	/**
  	 * Checking validation of input value
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;
  		}
  		
  		return true;
  	}
  	
  	/**
     * handling process after ending sheet1 retrieve
     */
  	function sheet1_OnSearchEnd(sheetObj,errMsg){

  	}
  	
	/* Finishing work */