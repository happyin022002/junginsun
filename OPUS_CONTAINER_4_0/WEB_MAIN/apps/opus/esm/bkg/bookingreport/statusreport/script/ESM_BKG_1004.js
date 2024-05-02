/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1004.js
*@FileTitle : DPCS: PIC Change
*Open Issues :
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
     * @class esm_bkg_1004 : business script for esm_bkg_1004
     */
    function esm_bkg_1004() {
    	this.processButtonClick	= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				  = loadPage;
    	this.initSheet 				  = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnClick     = sheet1_OnClick;
    	this.sheet1_OnKeyUp     = sheet1_OnKeyUp;
    	this.setComboObject 		= setComboObject;
    }
    
   	
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
     }
     
     
 
 var sheetObjects = new Array();
 var sheetCnt = 0;
 var rowsPerPage = 50;
 
 var prefix = "sheet1_";
 
 
 var grp_cd ="";  
 var queueMap = new Array();
 
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt = 0;
 	var comboObjects = new Array();
	
     
	//registering the created IBCombo Object at page as comboObjects list
	//ComComboObject is called from Constructor method  
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++] = combo_obj;
 	} 	
	


  	
	
 /*********************** EDTITABLE MULIT COMBO END********************/ 
 
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
		 			ComConfigSheet (sheetObjects[i] );
		 			initSheet(sheetObjects[i],i+1);
		 			ComEndConfigSheet(sheetObjects[i]);
		    }	
	
		    initControl();
        if(checkInitData(form)){
		    		inintSearch(); 
        }
     }
   
   /*
    * checking parameters when loading the page<br>
    * sending the message and deactivating the Return button in case of uncertain parameter
    * */
    function checkInitData(formObj){
			if ( ComIsNull(formObj.src_cd) ||  ComIsNull(formObj.sr_no) ||  ComIsNull(formObj.bkg_no) ) {
	     					ComShowCodeMessage('BKG00626','S/R CD, S/R No., BKG No.');
	     					return false;
			}    
			return true;
    }
	/*
	 * retrieve when opening the page
	 * */
	 function inintSearch(){
	 	if ( ComIsNull(form.bkg_no)) {
	 //		ComShowCodeMessage('BKG00626','Booking No');
	 	//	form.bkg_no.focus();
	 	//	return;
	 	}
	 	doActionIBSheet(sheetObjects[0],form,IBSEARCH);
	 }
	
    
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress','bkg_keypress',formObject); //- when typing the keyboard
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus out     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus in
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }        
    
    

 /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}  
	
	/**
     * control onBlur of HTML Control
     **/
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "dura_from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "dura_to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
				default:
					break;
	    }
    }        

	/**
	 * checking validation at the onFocus event of HTML Control<br>
	 **/
	function bkg_activate(){
		//checking input Validation
		switch(event.srcElement.name){	
	    	case "dura_from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "dura_to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  

/*********************** KEY EVENT END ********************/

  
// Event handler processing by button click event */
 		document.onclick  = processButtonClick;

 // Event handler processing by button name */
     function processButtonClick(){
          /***** using extra sheet valuable if there are more 2 sheets *****/
          var sheetObject1 = sheetObjects[0];
					
          /*******************************************************/
          var formObject = document.form;

	     	try {
	     		
	     		var srcName = window.event.srcElement.getAttribute("name");
	     		
		 			switch(srcName) {
		 				case "btn_select":
		 					if(sheetObject1.CheckedRows(prefix+"sel") <= 0 ) {
				      	ComShowCodeMessage("COM12189");
				      	return;
				      }
				      
			 				var checkedRows = sheetObject1.FindCheckedRow(prefix+"sel");
							var arrRow = checkedRows.split("|");
							var selectRow = arrRow[0];
	 					
							formObject.change_usr_id.value = sheetObject1.CellValue(selectRow, prefix+"usr_id");			       			
			      
		 					break;		 					
		 				case "btn_save":
		 					doActionIBSheet(sheetObject1,formObject,MODIFY01);
		 					opener.setSr_wrk_sts_usr_id(formObject.change_usr_id.value);
		 					self.close();
		 					break;
		 				case "btn_close":
		 					self.close();
		 					break;	
		        } // end switch
	     	}catch(e) {
		     		if( e == "[object Error]") {
		    			ComShowMessage(OBJECT_ERROR);
		    		} else {
		    			ComShowMessage(e);
		    		}		     	
	     	}
	     	
	     	
    }
 

   // handling sheet process
     function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {

			 			case IBSEARCH:      //retrieve
			 				//if(!validateForm(sheetObj,formObj,sAction)) return;
			 				formObj.f_cmd.value = SEARCH;
							
							sheetObj.RemoveAll();
							sheetObj.Redraw = false;    
							sheetObj.WaitImageVisible = true;
							var sXml = sheetObj.GetSearchXml("ESM_BKG_1004GS.do", FormQueryString(formObj)+ "&" +  ComGetPrefixParam(prefix));
							sheetObj.LoadSearchXml(sXml); 
							sheetObj.WaitImageVisible = false;	
							sheetObj.Redraw = true; 
							break;
						case MODIFY01:        //저장
				 				formObj.f_cmd.value = MODIFY01;
				 				if(!validateForm(sheetObj,formObj,sAction)) return;
				 				var sParam = "&"+ FormQueryString(formObj);
				 				//alert(sParam);
				 				//return;
								var sXml = sheetObj.GetSaveXml("ESM_BKG_1004GS.do" , sParam);
								 if (ComGetEtcData(sXml, "success_yn") =="Y"){
								 			ComShowCodeMessage('COM130102','Data');
								 }else{
								 	ComShowCodeMessage('COM130103','Data');
								 }
			 				break;									
			    }
     }
     
     
     
     

     /*
      * init data is sheet header number.
      */ 
      var pagedMaxCnt=2; 
			/**
       * event handling after retrieve
      */ 
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
     }
   
   
			/*
		 *  Search condition or Item condition Modify
		 * */
     function sheet1_OnClick(sheetObj,rowIdx,colIdx,val) {
				sheetObj.CellValue(rowIdx, prefix+"sel") = 1;
     }	   

			/*
		 *  Search condition or Item condition Modify
		 * */
     function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
 				var checkedRows = sheetObj.FindCheckedRow(prefix+"sel");
				var arrRow = checkedRows.split("|");
				var selectRow = arrRow[0];
			
				form.change_usr_id.value = sheetObj.CellValue(selectRow, prefix+"usr_id");		
     		
     }	   

     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
    		case MODIFY01:
			  	if(formObj.change_usr_id.value == "" ){
							ComShowCodeMessage('BKG00626','Change ID');
	     				formObj.change_usr_id.focus();
							return false;
					}
	  			break;
    	 	}
            return true;
     }
    
    function isNullEtcData(xmlStr){
    	var rtn = false;
    	var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return true;

        var etcDataNode = xmlRoot.getElementsByTagName("ETC-DATA").item(0);
        if(etcDataNode == null) return true;

        var etcNodes = etcDataNode.childNodes;
        if(etcNodes == null) return true;
        if(etcNodes.length == 0) rtn = true;
        
        return rtn;
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

            case "sheet1":
              with (sheetObj) {
                 // setting height
                 style.height = 150;
                 
                 //setting width
                 SheetWidth = mainTable.clientWidth;

                 //setting Host information[mandatory][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //Kind of Merge [Option, Default msNone]
                 MergeSheet = msHeaderOnly;

                //Edit  [Option, Default false]
                 Editable = true;

								//setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
								InitRowInfo(1, 1, 3, rowsPerPage);

								var HeadTitle1 = "Sel|Group|User ID|User Name";

                 
                var headCount = ComCountHeadTitle(HeadTitle1);

                //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);

                // setting Header Mode
                //([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) 
                InitHeadMode(true, true, true, true, false,false)

                //Header Row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                
								//Data attribute    [ROW,	COL,	DATATYPE,			WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
								InitDataProperty(0,		cnt++ , dtRadioCheck,	  40,		daCenter,	true,		  prefix + "sel");  
		 						InitDataProperty(0,		cnt++ , dtCombo,			  60,	daCenter,	false,	prefix + "dpcs_wrk_grp_cd",	false,		"",		dfNone,			0,		false,		false);
		 						InitDataProperty(0,		cnt++ , dtData,				  120,	daCenter,	false,	prefix + "usr_id",			      false,		"",		dfNone,			0,		false,		false);
		 						InitDataProperty(0,		cnt++ , dtData,				  120,	daCenter,	false,	prefix + "usr_nm",			      false,		"",		dfNone,			0,		false,		false);
//		 						
//		 						InitDataProperty(0,		cnt++ , dtCombo,			  150,	daCenter,	false,	prefix + "dpcs_psn_cd",		  false,		"",		dfNone,			0,		false,		false);
//		 						InitDataProperty(0,		cnt++ , dtData,				  140,	daCenter,	false,	prefix + "cre_dt",			      false,		"",		dfDateYmd,		0,	false,		false);
//		 						
//		 						InitDataProperty(0,		cnt++ , dtData,				  140,	daCenter,	false,	prefix + "upd_dt",			      false,		"",		dfDateYmd,		0,	false,		false);
//		 						InitDataProperty(0,		cnt++ , dtData,				  160,	daCenter,	false,	prefix + "upd_usr_id",		    false,		"",		dfNone,			0,		false,		false);
//		 						InitDataProperty(0,		cnt++ , dtCombo,			  80,		daCenter,	false,	prefix + "dpcs_wrk_prt_cd",	false,		"",		dfNone,			0,		false,		false);
		 														
		 						InitDataCombo(0, prefix + "dpcs_wrk_grp_cd", " |F/OFC|Input|Rate|Audit|Super", " |S|I|R|A|U");
								CountPosition = 0;
								
						}
 				
 					break;
         
         }
     }
    

	    