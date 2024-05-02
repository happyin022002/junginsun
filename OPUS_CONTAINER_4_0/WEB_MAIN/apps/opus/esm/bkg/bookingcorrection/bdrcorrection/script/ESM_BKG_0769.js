/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0769.js
*@FileTitle : C/A Kind
*Open Issues : ESM_BKG_0769
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class esm_bkg_0769 : business script for esm_bkg_0769
     */
    function esm_bkg_0769() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initSheet 				 = initSheet;
    	this.doActionIBSheet 		 = doActionIBSheet;
    }
    
   	

    
    var sheetObjects = new Array();
    var sheetCnt = 0;    
       
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

	// Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
        sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_select":
			    	
			    	break;
			    	
				case "btn_close":
					self.close();
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
    	}
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
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }

        //initParam(); 
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
    }

     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
		        with (sheetObj) {
		            // setting height
		            style.height = 260;
		            //setting width
		            SheetWidth = mainTable.clientWidth;
		
		            //setting Host information[mandatory][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //Kind of Merge [Option, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		           //Edit  [Option, Default false]
		            Editable = true;
		
		            //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "| |C/A Kind|C/A Kind";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // setting Header Mode
		            InitHeadMode(true, true, false, true, false,false);
		
		            //Header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0,	cnt++,	dtCheckBox,		30 ,  daCenter,	     false,	  "radio",       false,    "",      dfNone,	        0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	50,   daCenter,  	 false,   "ibflag",      false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	30,   daCenter,  	 false,   "val",         false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	140,  daLeft,  	     false,   "name",        false,    "",      dfNone,         0,     false,      false);
		        }
		        break; 
		}
	}

      /**
       * handling sheet process
       * @param sheetObj
       * @param formObj
       * @param sAction
       * @return void
       */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="sheet1") {
      	    		formObj.f_cmd.value = SEARCH;
 	          		sheetObj.DoSearch("ESM_BKG_0769GS.do", FormQueryString(formObj));
      	    	}
                break;
        }
    }
    
    //######################[1. Event]############################################################
	
	//######################[2. Etc]##############################################################

    
	