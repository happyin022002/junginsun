/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0001.js
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class EXP_SPP_0001 : business script for EXP_SPP_0001 
     */
    function EXP_SPP_0001() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_activate 			= obj_activate;
    	this.obj_change 			= obj_change;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.sheet1_OnSaveEnd 		= sheet1_OnSaveEnd;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnChange 		= sheet1_OnChange;
    	this.sheet1_ComboSetting 	= sheet1_ComboSetting;
    	this.getComboTextCode 		= getComboTextCode;
    	this.sheet1_OnClick 		= sheet1_OnClick;
    	this.setVVDStatus 			= setVVDStatus;
    	this.sheet1_OnPopupClick 	= sheet1_OnPopupClick;

    }

    // The common global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var LANE = "vendor";
    var VVD = "vvd";
    var VVDETC = "vvd_etc";
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var MC_TAB = "\t";  //The tab key value for Multi Combo
    var SearchRecCnt = 0;  //The retrieved record count
    var GlobalRevYr = ""; 
    
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

        // Event handler processing by button name */
        function processButtonClick(){

             var sheetObject1 = sheetObjects[0];
             var comboObject1 = comboObjects[0]; 

             /*******************************************************/
             var formObject = document.form;

        
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	            	  case "btn_Add":
	            	  		doActionIBSheet(sheetObject1,formObject,IBINSERT);
	            	  		break;
	            	  		
	            	  case "btn_Delete":
	            		  	ComRowDelete(sheetObject1,"sheet1_del_chk");
	    					break;
	    					
	            	  case "btn_New":  
			  				if(!ComCodeMsgByInitialize()) return;
			  				ComResetAll();	 
	            	  		setToday(document.form.revyr, "y");
	            	  		setToday(document.form.revmon, "m");
	            	  		setToday(document.form.revyrmon, "ym");
	            	  		GlobalRevYr = document.form.revyr.value;
	            	  		break;
	            	  		
	            	  case "btn_Retrieve": 
			        	  	doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;
							
			          case "btns_calendar":
			        	  GlobalRevYr = document.form.revyr.value;  //Setting the previous year to GlobalRevYr field in case of clicking calendar image button
			        	  //openCalendar("y", document.form.revyr);
			        	  var cal = new ComCalendar();
	        	          cal.setDisplayType('year');
	        	          cal.select(formObject.revyr, 'yyyy');
	        	     
			        	  break;
	            } // end switch
        	
        }

        /**
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++] = sheet_obj;
        }
         
        /** 
         * Registering IBCombo Object as list
         * param : combo_obj
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */ 
        function setComboObject(combo_obj) {  
           comboObjects[comboCnt++] = combo_obj;  
        }

        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() {
            for(i=0;i<sheetObjects.length;i++){

                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            initControl();
        }
         
        /**
         * Adding some occurring events to form. 
         */
        function initControl() {
        	
        	// handling the occurring keypress event to the all fields that contain dataformat attribute
        	axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
        	
        	// handling the occurring blur event to the all fields that contain dataformat attribute               
        	axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form);
        	
        	// handling the occurring focus event to the form in case of contain dataformat attribute
        	axon_event.addListenerFormat('focus', 	'obj_activate',    	form);

        	// handling the occurring keyup event to the form in case of contain dataformat attribute
        	axon_event.addListenerFormat('keyup', 'obj_keyup',    		form);               
               
        	//axon_event.addListener('change',   'obj_change',  'revyr');
        	axon_event.addListener('change',   'obj_change',  'revmon');
               
        	//Today Setting ..
        	setToday(document.form.revyr, "y");
        	setToday(document.form.revmon, "m");
        	setToday(document.form.revyrmon, "ym");
        	GlobalRevYr = document.form.revyr.value;
        	//focusSetting
        	document.form.revyr.focus();
      	 }
           
          /*
           * Handling the code when occurring blur event.
           */
          function obj_deactivate(){
        	   obj = event.srcElement;
               if(ComChkObjValid(event.srcElement)){
	           	   if(obj.name=="revyr"){  
	        		   if(GlobalRevYr != document.form.revyr.value){
	        			   obj_change();
	        			   GlobalRevYr = document.form.revyr.value;
	        		   }
	        		   return; 
	        	   }
               }
          }
         
         /*
          * Handling the code when occurring keyup event
          */ 
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "revyr":
        	    	   ComKeyEnter('LengthNextFocus');  
        		       break;
        		   default:
        			   break;
        	   }
         }          

          /*
           * Handling the code when occurring focus event.
           */
          function obj_activate(){
        	   obj = event.srcElement;
               ComClearSeparator(event.srcElement);
               ComShowFocusCursor(obj);  
          } 
          
          /*
           * Handling the code when occurring change event.
           */
          function obj_change(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "revyr":
        	       case "revmon":	   
        	    	   sheetObjects[0].RemoveAll();
        	    	   document.form.revyrmon.value = document.form.revyr.value + document.form.revmon.value;
        	    	   document.form.vvdstatus.value = "";
        		       break;
        		   default:
        			   break;
        	   }
          }          

          /*
           * Handling the code when occurring keypress event.
           */
          function obj_keypress(){
       	    obj = event.srcElement;
       	    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     	    
       	    if(obj.dataformat == null) return;
     	    
     	    if(keyValue == 13 ){
     	    	//Checking whether Work Month is inputted or not
     	    	var formObject = document.form;

         	  	if(formObject.revyr.value == "" || formObject.revyr.value == undefined){
         	  		ComShowCodeMessage("COM12114", "Year");  //Please check {?msg1}
         	  		formObject.revyr.focus();
         	  		return;
         	  	}
         	  	if(formObject.revmon.value == "" || formObject.revmon.value == undefined){
         	  		ComShowCodeMessage("COM12113", "Canal Transit  List  working Month");  //Please select {?msg1}  
         	  		formObject.revmon.focus();
         	  		return;
         	  	}        	  	
         	  	
         	  	//Setting the set IBCOMBO value to vndr_seq parameter
         	  	doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
        	  	
     	    	return true ;
     	    }
     	    
       	    window.defaultStatus = obj.dataformat;
       	
       	    switch(obj.dataformat) {
       	    	case "yyyy":
       	        case "ymd":
       	        case "ym":
       	        case "hms":
       	        case "hm":
       	        case "jumin":
       	        case "saupja":
       	            ComKeyOnlyNumber(obj);
       	            break;
       	        case "int":
       	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
       	            else ComKeyOnlyNumber(obj);
       	            break;
       	        case "float":
       	            ComKeyOnlyNumber(obj, "-.");
       	            break;
       	        case "eng":
       	            ComKeyOnlyAlphabet(); break;
       	        case "engup":
       	            if(obj.name=="txtEngUp2") ComKeyOnlyAlphabet('uppernum')
       	            else ComKeyOnlyAlphabet('upper');
       	            break;
       	        case "engdn":
       	            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
       	            else ComKeyOnlyAlphabet('lower');
       	            break;
       	    }
       	}
          
        /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {

          var cnt = 0;
    	  var sheetid = sheetObj.id;
    	  var onepagerows = document.form.pagerows.value;
          switch(sheetid) {

    				case "sheet1":
    					with (sheetObj) {
    							// Setting height
    							style.height = 400;

    							//Setting width
    							SheetWidth = mainTable.clientWidth;

    							//Setting the Host information[Required][HostIp, Port, PagePath]
    							if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    							//Kind of merge [Optional, Default msNone]
    							MergeSheet = msHeaderOnly;

    							//Edit kind [Optional, Default false]
    							Editable = true;

    							//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    							InitRowInfo(1, 1, 3, onepagerows);

    							var HeadTitle1 = "|Sel.|Pay To|VVD|Vessel|VesselNm|Voyage|Direction|Lane|Transit Date|Payable Due\nDate|Advance Payment\nStatus|ADV Payment\nRev.Month|Invoice\nStatus|Invoice\nRev.Month|MSA|Result|vnderSEq|eSeq|iSeq|ydCd|VVD ETC";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header
    							/*mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) */
    							InitHeadMode(false, true, false, true, false,false);

    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							var prefix = "sheet1_";
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtCheckBox,		30,		daCenter,	true,		prefix+"del_chk",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"pay_to",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vvd",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtComboEdit,	160,	daCenter,	true,		prefix+"vsl_cd",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daCenter,	true,		prefix+"vsl_nm",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"skd_voy_no",	false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,		prefix+"skd_dir_cd",	false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,		prefix+"lane",			false,		"",	dfNone,		0,		false,	false);
    							//InitDataProperty(0, cnt++ , dtPopupEditFormat,85,		daCenter,	true,		prefix+"trns_dt",		false,		"",	dfDateYmd,		0,		false,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"trns_dt",		false,		"",	dfDateYmd,	0,		false,	true, 10);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"py_due_dt",		false,		"",	dfDateYmd,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		120,	daCenter,	true,		prefix+"adv_py_sts",	false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"adv_py_rev_mon",false,		"",	dfDateYm,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		100,	daCenter,	true,		prefix+"inv_sts",		false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"inv_rev_mon",	false,		"",	dfDateYm,	0,		false,	false);
    							InitDataProperty(0, cnt++ , dtImage,		100,	daCenter,	true,		prefix+"msa",			false,		"",	dfNone,		0,		true,	true);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix+"rslt",			false,		"",	dfNone,		0,		false,	false);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"vndr_seq",		false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"eseq",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"iseq",			false,		"",	dfNone,		0,		false,	true);
    							InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix+"yd_cd",			false,		"",	dfNone,		0,		false,	true);
    							

    							InitDataProperty(0, cnt++ , dtComboEdit,	85,		daCenter,	true,		prefix+"vvd_etc",		false,		"",	dfDateYmd,	0,		false,	true);
    							
    							InitComboNoMatchText(true);  
    							sheetObj.ColHidden(prefix+"vvd_etc") = true;
    							
    							ImageList(0)   = "img/blank.gif";
    							ImageList(01)  = "img/btng_ready1.gif";			// Ready
    							ImageList(02)  = "img/btng_ready2.gif";			// Ready
    							ImageList(03)  = "img/btng_ready3.gif";			// Ready
    							ImageList(04)  = "img/btng_ready4.gif";			// Ready
    							ImageList(05)  = "img/btng_ready5.gif";			// Ready
    							ImageList(06)  = "img/btng_ready6.gif";			// Ready
    							ImageList(07)  = "img/btng_ready7.gif";			// Ready
    							ImageList(08)  = "img/btng_ready8.gif";			// Ready
    							ImageList(09)  = "img/btng_ready9.gif";			// Ready
    							
    							ImageList(10)  = "img/blank.gif";
    							ImageList(11)  = "img/btng_requested1.gif";		// Requested
    							ImageList(12)  = "img/btng_requested2.gif";		// Requested
    							ImageList(13)  = "img/btng_requested3.gif";		// Requested
    							ImageList(14)  = "img/btng_requested4.gif";		// Requested
    							ImageList(15)  = "img/btng_requested5.gif";		// Requested
    							ImageList(16)  = "img/btng_requested6.gif";		// Requested
    							ImageList(17)  = "img/btng_requested7.gif";		// Requested
    							ImageList(18)  = "img/btng_requested8.gif";		// Requested
    							ImageList(19)  = "img/btng_requested9.gif";		// Requested
    							
    							ImageList(20)  = "img/blank.gif";
    							ImageList(21)  = "img/btng_approved.gif";		// Approved
    							ImageList(22)  = "img/btng_approved2.gif";		// Approved
    							ImageList(23)  = "img/btng_approved3.gif";		// Approved
    							ImageList(24)  = "img/btng_approved4.gif";		// Approved
    							ImageList(25)  = "img/btng_approved5.gif";		// Approved
    							ImageList(26)  = "img/btng_approved6.gif";		// Approved
    							ImageList(27)  = "img/btng_approved7.gif";		// Approved
    							ImageList(28)  = "img/btng_approved8.gif";		// Approved
    							ImageList(29)  = "img/btng_approved9.gif";		// Approved
    							
    							ImageList(30)  = "img/blank.gif";
    							ImageList(31)  = "img/btng_paid.gif";			// Paid
    							
    						}
    						break;
    						
            }
        }

        /*
         * Handling the process about the sheet
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
    	    var prefix = "sheet1_";
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

              case IBSEARCH: 
              	formObj.f_cmd.value = SEARCH;
              
              	// Checking whether Work Month is inputted or not
	      	  	if(formObj.revyr.value == "" || formObj.revyr.value == undefined){
	      	  		ComShowCodeMessage("COM12114", "Year");  //Please check {?msg1}
	      	  		formObj.revyr.focus();
	      	  		return;
	      	  	}
	      	  	if(formObj.revmon.value == "" || formObj.revmon.value == undefined){
	      	  		ComShowCodeMessage("COM12113", "Canal Transit  List  working Month");  //Please select {?msg1}  
	      	  		formObj.revmon.focus();
	      	  		return;
	      	  	}
	      	  	
	      	  	formObj.revyrmon.value = formObj.revyr.value + formObj.revmon.value;
	      	  	
       			sheetObj.DoSearch("EXP_SPP_0001GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));


				sheetObj.Copy2SheetCol(sheetObj, prefix+"vsl_nm", prefix+"vsl_cd");               	
				SearchRecCnt = sheetObj.RowCount;//Saving the retrived record count.

        	  	//Setting VVD Status
        	  	setVVDStatus();       					
    			break;

    		  case IBINSERT:  //Adding row
    			  
    		    var insertRowNo = 0;
    		    
    		    if(SearchRecCnt > 0){
    		    	
    		    	sheetObj.DataInsert(sheetObj.Rows-2);
    		    	insertRowNo = sheetObj.Rows-2;  //adding the row at the second of the bottom
    		    
    		    	sheetObj.CellValue2(insertRowNo, prefix+"rslt") = "ADD Row";
        		    sheetObj.CellValue2(insertRowNo, prefix+"adv_py_sts") = "0";  
        		    sheetObj.CellValue2(insertRowNo, prefix+"inv_sts") = "0";  
      		  		sheetObj.CellValue2(insertRowNo, prefix+"trns_dt") = ComGetNowInfo();  //Setting today
        		  	sheetObj.SelectCell(insertRowNo, prefix+"trns_dt");  //selecting cell
    		    }
    		    
                break;
            }
        }
        
        /*
         * Calling this function after finishing to save data
         */
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){
        	var formObj = document.form;
            
        }
         
        /*
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 var prefix = "sheet1_";
        	 switch(sAction){
	        	 default:
	             break;
        	 }
        	 return true;
        } 
        
        /**
        * Calling this function after changing the sheet1 value
        */
        function sheet1_OnChange(sheetObj, Row, Col, Value){
    	    //alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
    	    var formObject = document.form;
    	    var prefix = "sheet1_";
    	    var strColSaveName = sheetObj.ColSaveName(Col);
			if(Value!==null && Value !== "undefined" && Value !== -1){
	        	switch(strColSaveName){
	        		case prefix+"trns_dt":
	        			formObject.transymd.value = sheetObj.CellValue(Row, prefix+"trns_dt");
	        			sheet1_ComboSetting(sheetObj, Row, prefix+"vsl_cd");
	        			break;
	        			
	        		case prefix+"vsl_cd":
	        			var strVslCd = sheetObj.CellValue(Row, prefix+"vsl_cd");
	        			if(strVslCd!=""){

		        			var sText = sheetObj.GetComboInfo(Row, prefix+"vsl_cd", "Text");
		        			var arrText = sText.split(ROWMARK);
		        			var idx = sheetObj.GetComboInfo(Row, prefix+"vsl_cd", "SelectedIndex");
		        			var voyDir = arrText[idx].split(MC_TAB);
		        			var arrVvdEtc = sheetObj.GetComboInfo(Row, prefix+"vvd_etc", "Code").split(ROWMARK);
		        			var arrVvdEtcValue = arrVvdEtc[idx].split(FIELDMARK);
		        			var intAdvPySts = 0;
		        			
		   	        		var rowCnt = sheetObj.Rows; 
			        		for(idx=1;idx<rowCnt;idx++){
			                	 if(sheetObj.RowStatus(idx)=="I"){  
				        			 if(Row!=idx && strVslCd == sheetObj.CellValue(idx, prefix+"vsl_cd")){ 
				        				 ComShowCodeMessage("SPP01005");  
				        				 sheetObj.CellValue2(Row, prefix+"vsl_cd") = "";
				        				 sheetObj.SelectCell(idx, prefix+"vsl_cd", false);
				        				 return;
				        			 }
			                	 }
			        		}		        				
			        		
	        				sheetObj.CellValue2(Row, prefix+"vvd") = sheetObj.CellValue(Row, prefix+"vsl_cd");
	        				sheetObj.CellValue2(Row, prefix+"vsl_nm") = voyDir[0];	
		        			sheetObj.CellValue2(Row, prefix+"skd_voy_no") = voyDir[1];
		        			sheetObj.CellValue2(Row, prefix+"skd_dir_cd") = voyDir[2];
		        			sheetObj.CellValue2(Row, prefix+"lane") = voyDir[3];
		        			sheetObj.CellValue2(Row, prefix+"trns_dt") = arrVvdEtcValue[0];
		        			sheetObj.CellValue2(Row, prefix+"py_due_dt") = arrVvdEtcValue[1];
		        			
		        			
		        			sheetObj.CellEditable(Row,prefix+"adv_py_sts") = false;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_sts") = 21;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = arrVvdEtcValue[3];
		        			sheetObj.CellValue2(Row, prefix+"inv_sts") = 0+ComParseInt(arrVvdEtcValue[6]-1);
		        			sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = "";
		        			sheetObj.CellValue2(Row, prefix+"vndr_seq") = formObject.vndr_seq.value;
		        			sheetObj.CellValue2(Row, prefix+"yd_cd") = arrVvdEtcValue[4];
		        			sheetObj.CellValue2(Row, prefix+"eseq") = arrVvdEtcValue[5];
		        			sheetObj.CellValue2(Row, prefix+"iseq") = arrVvdEtcValue[6];
	        			}else{
	        				sheetObj.CellValue2(Row, prefix+"vvd") = "";
	        				sheetObj.CellValue2(Row, prefix+"vsl_nm") = "";
		        			sheetObj.CellValue2(Row, prefix+"skd_voy_no") = "";
		        			sheetObj.CellValue2(Row, prefix+"skd_dir_cd") = "";
		        			sheetObj.CellValue2(Row, prefix+"lane") = "";
		        			sheetObj.CellValue2(Row, prefix+"trns_dt") = "";
		        			sheetObj.CellValue2(Row, prefix+"py_due_dt") = "";	
		        			sheetObj.CellValue2(Row, prefix+"adv_py_sts") = 00;
		        			sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = "";	
		        			sheetObj.CellValue2(Row, prefix+"inv_sts") = 00;
		        			sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = "";
		        			sheetObj.CellValue2(Row, prefix+"vndr_seq") = formObject.vndr_seq.value;
		        			sheetObj.CellValue2(Row, prefix+"yd_cd") = "";
		        			sheetObj.CellValue2(Row, prefix+"eseq") = "";
		        			sheetObj.CellValue2(Row, prefix+"iseq") = "";
	        			}
	        			break;
	        			
	        		default:
	        			break;
	        			
	        	}//end of switch
			}//end of if
			return;
        }
        
        /**
         * setting the combobox value of sheet1
         */         
        function sheet1_ComboSetting(sheetObj, Row, strColId){
       	 //alert('Row:='+Row+" Colid:="+strColId);
       	 var prefix = "sheet1_";
       	 var formObj = document.form;

            switch(strColId){
            	case prefix+"vsl_cd":            		
     				formObj.f_cmd.value = COMMAND02;
     				formObj.revyrmon.value = formObj.revyr.value + formObj.revmon.value;
     				
     				var tmp = sheetObj.CellValue(Row, prefix+"trns_dt"); 
     				
     				//Initializing the comb field.
     				sheetObj.CellComboItem(Row, prefix+"vsl_cd", " ", " ", 0);
     				sheetObj.CellComboItem(Row, prefix+"vvd_etc", " ", " ", 0);
     				
     				//getting the vvd list
     				sheetObj.WaitImageVisible = false;
     				var sXml = sheetObj.GetSearchXml("EXP_SPP_0001GS.do", FormQueryString(formObj));
     				var comboItems = ComGetEtcData(sXml, VVD).split(ROWMARK);
     				
     				//vvd list is empty
     				if(!comboItems.length || ComIsEmpty(comboItems[0])){
     					sheetObj.CellValue2(Row, prefix+"trns_dt") = tmp;
     					ComCodeMsgByNoRelatedData("VVD ");  //There is no related data!     
     					sheetObj.SelectCell(Row, prefix+"trns_dt");  
     					return;
     				}
     				
     				//vvd list is not empty
     				var comboVvdEtc = ComGetEtcData(sXml, VVDETC);
     				var comboItem = null;
     				
     				comboItem = getComboTextCode(comboItems, true).split(FIELDMARK);  //converting the combo item to type "text,code"(setting empty value at the first combo)
     				sheetObj.CellComboItem(Row, prefix+"vsl_cd", comboItem[0], comboItem[1]);  //   setting the code that vsl_cd, skd_voy_no and skd_dir_cd are linked one another without blank
     				
     				//Occurred change event
     				sheetObj.CellValue2(Row, prefix+"trns_dt") = tmp;
   				
     				sheetObj.CellComboItem(Row, prefix+"vvd_etc", " "+ROWMARK+comboVvdEtc, " "+ROWMARK+comboVvdEtc);  //setting empty value at the first combo
     				
        			sheetObj.SelectCell(Row, prefix+"vsl_cd", false);     				
	      			break;
	      			
	      		default:
	      			break;
            }
        }
        
        /**
         * Getting the xml value from ComGetEtcData() and converting it to "text,code" type
         * param : comboItems, boolTF
         */         
        function getComboTextCode(comboItems, boolTF){
			var comboItems1= "";  //text
			var comboItems2= "";  //code
	
			if ( !comboItems.length ) {
				var comboItem = comboItems.split(FIELDMARK);
				comboItems1 = comboItem[0];
				comboItems2 = comboItem[1]; 		
			} else {
				for (var i = 0 ; i < comboItems.length ; i++) {
					var comboItem = comboItems[i].split(FIELDMARK);
					if( i == 0 ){
						if(boolTF){
							comboItems1 = "Select!" + ROWMARK + comboItem[0];
							comboItems2 = " " + ROWMARK + comboItem[1]; 							
						}else{
							comboItems1 = comboItem[0];
							comboItems2 = comboItem[1]; 
						}
					} else {
						comboItems1 = comboItems1 + ROWMARK +comboItem[0];  //text
						comboItems2 = comboItems2 + ROWMARK +comboItem[1];  //code
					}	
				}   		
			}

			return comboItems1 + FIELDMARK + comboItems2;
        }        
        
        /**
         * Calling this function after clicking sheet1
         */
        function sheet1_OnClick(sheetObj, Row, Col, Value){
        	//alert('Row:='+Row+" Col:="+Col+" Value:="+Value);
			var url = "";
       	 	var prefix = "sheet1_";	
			var formObject = document.form;       	 	
       	 	var strColSaveName = sheetObj.ColSaveName(Col);       	 	
			formObject.revyrmon.value = formObject.revyr.value + formObject.revmon.value;

			if(Value!==null && Value !== "undefined" && Value !== -1){

	        	switch(strColSaveName){
		        	case prefix+"adv_py_sts":  
		        		
		        		if(ComIsEmpty(Value+"") || Value==0) break;  
		        		url = "/opuscntr/EXP_SPP_0002.do?"
		        			  + "vvd=" + sheetObj.CellValue(Row, prefix+'vvd') 
		        			  + "&vslNm=" + sheetObj.CellValue(Row, prefix+'vsl_nm') 
		        		      + "&ydCd=" + sheetObj.CellValue(Row, prefix+'yd_cd')
		        		      + "&callSeq=" + sheetObj.CellValue(Row, prefix+'eseq')
		        		      + "&vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
		        		      + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "")
		        		      + "&diffRmk=" + sheetObj.CellValue(Row, prefix+'rslt');; 

		            	//getting adv_py_sts, adv_py_rev_mon and diff_rmk
		            	var returnVal = ComOpenPopup(url, 1024, 600, '', '0,0', true, false);  //Opening by modal
		            	
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);
		            	
		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpESeq = ComNullToValue(sheetObj.CellValue(Row, prefix+"eseq"), "1");
		            	
		            	sheetObj.CellValue2(Row, prefix+"adv_py_sts") = ComParseInt(tmpStsCd+tmpESeq);
		            	sheetObj.CellValue2(Row, prefix+"adv_py_rev_mon") = arrReturnVal[1]; 
		            	sheetObj.CellValue2(Row, prefix+"rslt") = arrReturnVal[2]; 
		            	sheetObj.RowStatus(Row) = "R";  
		            	
		        	  	//Setting VVD Status
		        	  	setVVDStatus();		            	
		        		break;
		        		
		        	case prefix+"inv_sts":  //Invoice
		        		if(sheetObj.CellValue(Row, prefix+"adv_py_sts")!=21 && sheetObj.CellValue(Row, prefix+"adv_py_sts")!=31){
		        			ComShowCodeMessage("SPP01014");  
		        			break;  //Break if the status of the advance payment is not approved.
		        		}
		        		if(ComIsEmpty(Value+"") || Value==0){
		        			break;  
		        		}
			        	url = "/opuscntr/EXP_SPP_0003.do?"
			        		  + "vvd=" + sheetObj.CellValue(Row, prefix+'vvd') 
		        			  + "&vslNm=" + sheetObj.CellValue(Row, prefix+'vsl_nm')			        		  
			        		  + "&ydCd=" + sheetObj.CellValue(Row, prefix+'yd_cd')
			        		  + "&callSeq=" + sheetObj.CellValue(Row, prefix+'iseq')
			        		  + "&vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
			        		  + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "")
			        		  + "&trnsDt=" + + sheetObj.CellValue(Row, prefix+'trns_dt').replace(/-/gi, "")
			        		  + "&diffRmk=" + sheetObj.CellValue(Row, prefix+'rslt');; 
			        		  
			        	//Getting inv_sts, inv_rev_mon and diff_rmk	  
			        	var returnVal = ComOpenPopup(url, 1024, 600, '', '0,0', true, false);  //Opening by the modal
			        		  
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);

		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpISeq = ComParseInt(ComNullToValue(sheetObj.CellValue(Row, prefix+"iseq"), "3")-1);
		            	
		            	sheetObj.CellValue2(Row, prefix+"inv_sts") = ComParseInt(tmpStsCd+tmpISeq);
		            	sheetObj.CellValue2(Row, prefix+"inv_rev_mon") = arrReturnVal[1]; 
		            	sheetObj.CellValue2(Row, prefix+"rslt") = arrReturnVal[2]; 
		            	sheetObj.RowStatus(Row) = "R";
		            	
		        	  	//Setting VVD Status
		        	  	setVVDStatus();		            	
		        		break;
		        		
		        	case prefix+"msa":  //MSA
		        		
		        		if(ComIsEmpty(Value+"") || Value==0) break;  
		        		
		        		var rowCnt = sheetObj.Rows;
		        		var invCnt = 0;
		        		var advCnt = 0;
		        		var rdyCnt = 0;
		        		var revMon = formObject.revmon.value;
		        		
		        		for(idx=1;idx<rowCnt-1;idx++){
		        			
		        			var advSts = sheetObj.CellValue(idx, prefix+"adv_py_sts");
		        			var invSts = sheetObj.CellValue(idx, prefix+"inv_sts");
		        			var advMon = sheetObj.CellValue(idx, prefix+"adv_py_rev_mon").substring(4,6);
		        			var invMon = sheetObj.CellValue(idx, prefix+"inv_rev_mon").substring(4,6);
		        			
		        			//adv = approve or paid, inv = ready or request
		                	if(advSts.substring(0,1) == 2 || advSts == 31){
		                		//ready
		                		/*
		                		if(invSts.length == 1){
		                			invCnt++;
		                		}
		                		*/
		                		//inv = request and workingmonth = inv month
		                		if((invSts.length == 2 && invSts.substring(0,1) == 1) && (revMon == invMon)){
		                			invCnt++;
		                		}
		                	}
		                	//adv = request and workingmonth = adv month
		                	if((advSts.length == 2 && advSts.substring(0,1) == 1) && (revMon == advMon)){
		                		advCnt++;
		                	}
		                	
		                	if(advSts.length == 1){
		                		rdyCnt++;
		                	}
		        		}
		        		
		        		if(invCnt >0 ){
		        			ComShowCodeMessage("SPP01016");  //
		        			break;  //breaking when invoice status is not approved
		        		}
		        		if(advCnt >0){
		        			ComShowCodeMessage("SPP01014");  //
		        			break;  //breaking when adv is not approved
		        		}
		        		if(rdyCnt == rowCnt-2){
		        			ComShowCodeMessage("SPP01014");  //
		        			break;  //breaking when adv is not approved
		        		}
		        		
		        		
		        		//if(ComTrimAll(formObj.vvdstatus.value).toLowerCase().indexOf('complete')==-1) break;  //Break if VVD status is not complete 
		        		
			        	url = "/opuscntr/EXP_SPP_0004.do?"
			        		  + "vndrSeq=" + sheetObj.CellValue(Row, prefix+'vndr_seq')
			        		  + "&revYrmon=" + formObject.revyrmon.value.replace(/-/gi, "");;
			        		  
			        	//Getting msa value		        		  
			            var returnVal = ComOpenPopup(url, 1024, 540, '', '0,0', true, false);  //opening by modal
			            
		            	if(returnVal==undefined || returnVal==null) return;
		            	var arrReturnVal = returnVal.split(ROWMARK);

		            	var tmpStsCd = arrReturnVal[0];
		            	if(tmpStsCd=="R"){
		            		tmpStsCd = "0";  //Ready Image
		            	}else if(tmpStsCd=="Q"){
		            		tmpStsCd = "1";  //Request Image
		            	}
		            	var tmpSeq = "1";
		            	
		            	sheetObj.CellValue2(Row, prefix+"msa") = ComParseInt(tmpStsCd+tmpSeq);
		            	sheetObj.RowStatus(Row) = "R";				            
			            
		        		break;
		        		
		        	default : 
		        		break;
		        	
	        	}//end of switch
			}//end of if
        	return;
        }
        
        /**
         * Setting VVD Status
         */  
        function setVVDStatus(){
        	var prefix = "sheet1_";	
        	var formObj = document.form;
        	var sheetObj = sheetObjects[0];
	   		var rowCnt = sheetObj.Rows;
	   		var rdyCnt = 0;
	   		
	   		if(rowCnt<=1 || SearchRecCnt==0){  //there is no data row or retrieved data row
	   			formObj.vvdstatus.value = "";
	   			return;
			}            	
	   		
	   		var strResult = "";
	   		
	   		strResult = sheetObj.CellValue(rowCnt-1, prefix+"msa");
	   		//The result is complete if msa is approved
	   		if(strResult == "21"){
	   			strResult = "Complete";
	   		}else{
	   			for(idx=1;idx<rowCnt-1;idx++){
        			
        			var advSts = sheetObj.CellValue(idx, prefix+"adv_py_sts");
        			
        			if(advSts =="1"){
        				rdyCnt++;
        			}
                }

	   			if(rdyCnt == rowCnt-2){	//all adv are ready
	   				strResult = "Ready";
	   			}else{
	   				strResult = "Processing";
	   			}
	   		}
			formObj.vvdstatus.value = strResult;
		}        
        
        /**
         * setting the event when clicking popup button in the sheet
         */        
        function sheet1_OnPopupClick(sheetObj, row, col){
        	var prefix = "sheet1_";
         	var strColSaveName = sheetObj.ColSaveName(col);
         	
         	switch(strColSaveName){
         		case prefix+"trns_dt":
         			var cal = new ComCalendarGrid();
         			document.form.transymd.focus();
         			cal.select2(document.form.transymd, sheetObj, row, col, 'yyyyMMdd');
         			break;
         	}
        }
       
