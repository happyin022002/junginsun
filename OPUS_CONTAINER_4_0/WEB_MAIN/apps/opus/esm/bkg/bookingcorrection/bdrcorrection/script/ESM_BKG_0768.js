/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0768.js
 *@FileTitle : C/A Reason
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/**
	 * business script for esm_bkg_0768
	 */
    function esm_bkg_0768() {
    	this.processButtonClick		 = tprocessButtonClick;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initSheet 				 = initSheet;
    	this.doActionIBSheet 		 = doActionIBSheet;
    	//this.sheet1_OnSearchEnd      = sheet1_OnSearchEnd;
    	this.setEtcDataToForm_bkg    = setEtcDataToForm_bkg;
    }
    
    // global variable
    var sheetObjects = new Array();
    var sheetCnt = 0;    
       
    // Event handler processing by button click event  */
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
     * @param sheet_obj IBSheet Object
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
			case "sheet1":      //t4sheet1 init
		        with (sheetObj) {
		            // setting Height
		            style.height = 140;
		            //setting Weight
		            SheetWidth = mainTable.clientWidth;
		
		            //setting Host Info [Mandatory][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //setting Merge type [Optional, Default msNone]
		            MergeSheet = msNone;
		
		           //setting Edit Type [Optional, Default false]
		            Editable = true;
		
		            //setting Row Info [Mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "| | |C/A Reason";
		            var headCount = ComCountHeadTitle(HeadTitle);
		            		            
		            //setting Column Info [Mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 0, 0, true);
		
		            // setting HEADER MODE.
		            InitHeadMode(true, true, false, true, false,false);
		
		            //setting HEADER Info. [Mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
		            InitDataProperty(0,	cnt++,	dtCheckBox,		40 ,  daCenter,	     false,	  "radio",       false,    "",      dfNone,	      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHiddenStatus,	70,   daCenter,  	 false,   "ibflag",      false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,     	30,   daCenter,  	 false,   "val",         false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,     	120,  daLeft,  	     false,   "name",   false,    "",      dfNone,         0,     false,      false);
		        }
		        break; 
		}
	}

    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	if (sheetObj.id=="sheet1") {
	      	    	formObj.f_cmd.value = SEARCH;
 	          		sheetObj.DoSearch("ESM_BKG_0768GS.do", FormQueryString(formObj));
      	    	}
                break;
        }
    }

    
    //######################[1. Event]############################################################
	
	
	//######################[2. Etc]##############################################################
	// Booking History : Call Detail View Popup. <br>
/*	 
	function comBkgCallPop0955(callback_func, bkgNo, blNo, hisCateNm, crntCtnt, preCtnt, creUsrId, office, creDt) {
		var param = "?bkg_no="+bkgNo
		          + "&bl_no="+blNo
		          + "&his_cate_nm="+hisCateNm
		          + "&crnt_ctnt="+crntCtnt
		          + "&pre_ctnt="+preCtnt
		          + "&cre_usr_id="+creUsrId
		          + "&office="+office
		          + "&cre_dt="+creDt;		
		var sUrl  = "ESM_BKG_0955.do"+param;
       
        ComOpenWindowCenter(sUrl, "ESM_BKG_0955", 740, 410, true); 
	}
*/ 
	
   
    //#############################(3. Util/Etc)##################################################

