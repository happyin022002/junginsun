/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0302.js
*@FileTitle : Rental payable invoice inquiry by Lessee via SPP
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
     * @class EXP_SPP_0302 : business script for EXP_SPP_0302 
     */
    function EXP_SPP_0302() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject			= setComboObject;
    	this.loadPage 				= loadPage;
    	this.initCombo 				= initCombo;
    	this.initControl			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_activate 			= obj_activate;
    	this.obj_keyup 				= obj_keyup;
    	this.lstm_cd_mousemove		= lstm_cd_mousemove;
    	this.lstm_cd_mouseout		= lstm_cd_mouseout;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.doActionIBCombo 		= doActionIBCombo;
    	this.combo1_OnCheckClick 	= combo1_OnCheckClick;
    	this.combo1_OnChange 		= combo1_OnChange;
    	this.obj_blur				= obj_blur;
    	this.obj_change				= obj_change;
    	this.clearForm 				= clearForm;

    }

    // The common global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;
     
    var ROWMARK = "|";
    var FIELDMARK = ",";
    var LESSORNAME = "lessor_name";
    
    // Event handler processing by button click event */
    document.onclick = processButtonClick;

        // Event handler processing by button name */
        function processButtonClick(){
        	
             var sheetObject1 = sheetObjects[0];
             var comboObject1 = comboObjects[0]; 
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

	            switch(srcName) {
	            	  case "btn_New":  
			  				if(!ComCodeMsgByInitialize()) return;
			  				ComResetAll();
			   	            setToday(document.form.str_dt, "ymd"); 
				            document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);			  				
			  				comboObject1.Code = "";
	            	  		break;

			          case "btn_Retrieve": 
			        	  	doActionIBSheet(sheetObject1, formObject, IBSEARCH);
							break;
							
			          case "btns_Calendar":
			            	var cal = new ComCalendarFromTo();
			            	cal.select(formObject.str_dt, formObject.end_dt, 'yyyy-MM-dd');
			            	break;	
			          case "btn_search2": 
			        	  if(document.form.admCheck.value == "1"){
			    				openPopup("2");
			        	  }  
		        	  default: 
		        		    break;
		        	  
	            } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("SPP01003");
        		} else {
        			ComShowMessage(e);
        		}
        	}
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
            
            for(var k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],k+1);
            }
            
            //Retrieving the combo data of Lease Term
           doActionIBCombo(sheetObjects[0], comboObjects[0], document.form, IBSEARCH_ASYNC03); 

            initControl();

            if(document.form.admCheck.value == "0"){
            	ComEnableObject(document.form.vndr_seq,false);
            }
        }
         
        /**
         * Initializing Combo 
         * param : comboObj
         * adding first-served functions after loading screen.
         */ 
        function initCombo(comboObj, comboNo){
            var formObj = document.form;
            switch(comboNo) {  
                  case 1: 
                  with (comboObj) { 
        				MultiSelect = true; 
        				UseAutoComplete = true;	
        				DropHeight = 160;
        				ItemHeight = 20;
        				MaxSelect = 20;
         		  }

         		  break; 
         	}         
        }
         
        /**
         * Adding some occurring events to form. 
         */
        function initControl() {
               //handling the occurring keypress event to the all fields        	 
               axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
               //handling the occurring blur event to the all fields that contain dataformat attribute               
               axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form, 'vndr_seq'); 
               // handling the occurring focus event to the form in case of contain dataformat attribute
               axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
  			   // handling the occurring keyup event to the form in case of contain dataformat attribute
  			   axon_event.addListenerFormat('keyup',    'obj_keyup',    	form);
  			   
  			   // handling the occurring mousemove event to lstm_cd
               axon_event.addListener('mousemove', 'lstm_cd_mousemove', 'lstm_cd');
               // handling the occurring mouseout event to lstm_cd
               axon_event.addListener('mouseout', 'lstm_cd_mouseout', 'lstm_cd');
               
         		axon_event.addListenerFormat('beforedeactivate',		'obj_blur',		form); //being out of the focus
        		axon_event.addListenerFormat('change',		'obj_change',	form); //- changing the value

  	           setToday(document.form.str_dt, "ymd"); 
	           document.form.end_dt.value = ComGetDateAdd(document.form.str_dt.value, "M", 1);

      	 }
           
  	/**
	 * Validating when the object is out of the focus
	 */
	function obj_blur(){
		var obj = ComGetEvent();
	    switch(ComGetEvent("name")){
	        case "vndr_seq":
	            break;

	        default:
	            //Checking the validation(length, format, maximum value,minimum value, etc.)
	           ComChkObjValid(obj);
	        	break;
	    }
	}

 	
  	
	 
          /*
           * Handling the code when occurring blur event
           */
          function obj_deactivate(){
       	     obj = event.srcElement;

             var formObj = document.form;
             var srcName = obj.getAttribute("name");
             switch(srcName){
                 case "str_dt":
                 case "end_dt":
                	 if(formObj.str_dt.value=="" || formObj.end_dt.value=="") break;
                	 //validating the inputted from date and to date. The from date is more previous date than the to one.
                	 checkFromTo(formObj.str_dt, formObj.end_dt);
                	 break;
                	 
                 default:
                	 break;
             }
          }

          /*
           * Handling the code when occurring focus event
           */
          function obj_activate(){
        	   obj = event.srcElement;
               ComClearSeparator(event.srcElement);
               ComShowFocusCursor(obj); 
          } 
           
          /*
           * Handling the code when occurring keyup event.
           */ 
          function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
    	           case "str_dt":
        	    	   ComKeyEnter('LengthNextFocus');  //moving to next object automatically when the inputted value is the maxlength
        		       break;
    	           case "vndr_seq":
    	 				if ( ComTrim(obj.value) == "" ) {
    	 					clearForm(obj.name);
    	 				} else {
    	 					ComKeyEnter('LengthNextFocus');
    	 				}
    	 				break;
        		   default:
        			   break;
        	   }
          } 
           
          /*
           * Handling lstm_cd object when occurring mousemove event.
           */            
          function lstm_cd_mousemove(){
        	  obj = event.srcElement;
        	  if(obj.value.trim()=="") return;
        	  var divName = 'divtooltip';
        	  if(!initToolTipDiv(divName)) return;
        	  document.all[divName].style.visibility = 'visible';
        	  document.all[divName].innerHTML = obj.value;
        	  document.all[divName].style.posLeft = event.x;
        	  document.all[divName].style.posTop = event.y;
          }
          
          /*
          * Handling lstm_cd object when occurring mouseover event.
          */           
          function lstm_cd_mouseout(){
        	  obj = event.srcElement;
        	  var divName = 'divtooltip';
        	  if(!initToolTipDiv(divName)) return;
        	  document.all[divName].style.visibility = 'hidden';
          }          

          /*
           * Handling the code when occurring keypress event.
           */
          function obj_keypress(){
       	    obj = event.srcElement;
       	    var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
     	    
       	    if(obj.dataformat == null) return;
     	    
     	    if(keyValue == 13 ){
     	    	var formObject = document.form;

         	  	if(formObject.vndr_seq.value == "" || formObject.vndr_seq.value == undefined){
         	  		ComShowCodeMessage("COM12114", "Lessor I/D");  
         	  		formObject.vndr_seq.focus();
         	  		return;
         	  	}       	  	
         	  	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
        	  	
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
       	            ComKeyOnlyAlphabet(); 
       	            break;
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

    							var HeadTitle1 = "|Seq.|Lessor I/D|Lessor|Term|Invoice No|Currency|Invoice Amount|Invoice Status|Payable AMT|Payment Date";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 0, 0, true);

    							// Setting function handling header
    							/*mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]) */
    							InitHeadMode(true, true, false, true, false,false);
    								
    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							InitHeadRow(0, HeadTitle1, true);

    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							var prefix = "sheet1_";

    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtDataSeq,      50,     daCenter,   true,    "Seq",     false,          "",      dfNone);
    							if(document.form.admCheck.value != "1"){
    								InitDataProperty(0, cnt++ , dtHidden,			120,		daCenter,	true,	prefix+"vndr_seq",			false,	"",	dfNone,		0,	false,	false);
    								InitDataProperty(0, cnt++ , dtHidden,			120,		daLeft,	true,	prefix+"vndr_nm",			false,	"",	dfNone,		0,	false,	false);
    							}else{
    								InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,	prefix+"vndr_seq",			false,	"",	dfNone,		0,	false,	false);
    								InitDataProperty(0, cnt++ , dtData,			180,		daLeft,	true,	prefix+"vndr_nm",			false,	"",	dfNone,		0,	false,	false);
    							}
    							InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"lstm_cd",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"inv_no",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,	prefix+"curr_cd",			false,	"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	prefix+"ttl_cost_amt",		false,	"",	dfNullFloat,2,	false,	false, 13);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"lse_inv_apsts_cd",	false,"",	dfNone,		0,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			110,	daRight,	true,	prefix+"pay_rntl_cost_amt",	false,	"",	dfNullFloat,2,	false,	false);
    							InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,	prefix+"ap_pay_dt",			false,	"",	dfDateYmd,	0,	false,	false);

    						}
    						break;
    						
            }
        }

        /*
         * Handling the process about the sheet
         */
        function doActionIBSheet(sheetObj, formObj, sAction) {
    	    var prefix = "sheet1_";
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {

              case IBSEARCH:  //
            	if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id == "sheet1"){
						var prefix = "sheet1_";
						formObj.f_cmd.value = SEARCH;
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0302GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSearchXml(sXml);
						
    					if(sheetObj.TotalRows==0) break; 

					}
              	}
				break;
              case IBSEARCH_ASYNC02:	//Retrieving(in case of inputting Form Lessor No.)
				if(validateForm(sheetObj,formObj,sAction)) {
					if ( sheetObj.id == "sheet1") {
						var param = "f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
						sheetObj.WaitImageVisible = false;
						var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", param);
						sheetObj.WaitImageVisible = true;

						if ( sXml != "" ) {
							if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
								ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
								ComSetNextFocus(formObj.vndr_seq);
	 						} else {
	 							ComShowCodeMessage("LSE01019");
	 							ComSetObjValue(formObj.vndr_seq, "");
	 							ComSetObjValue(formObj.vndr_nm, "");
	 							ComSetFocus(formObj.vndr_seq);
	 						}
						} else {
							ComShowCodeMessage("LSE01019");
							ComSetObjValue(formObj.vndr_seq, "");
							ComSetFocus(formObj.vndr_seq);
						}
					}
				}

    		    break;  		    

            }
        }
         
        /*
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
             switch(sAction){
	       	 case IBSEARCH:	//
		  	 	       	 	
		  	 	break;	  	 	
		  	 	
             default:
	            break;			  	 	
             }
             
             return true;
        }         
         
        /*
         * Handling the IBCombo process.
         */     
        function doActionIBCombo(sheetObj, comboObj, formObj, sAction) {

             sheetObj.ShowDebugMsg = false;
             switch(sAction) {
            		
            	case IBSEARCH_ASYNC03:  // Retrieving the combo data of Lease Term		
            		sheetObj.WaitImageVisible = false;
            		/* Lease Term Form Combo Item Setting */
            		formObj.f_cmd.value = SEARCH01;
            		var sXml = sheetObj.GetSearchXml("EES_LSE_COMGS.do", FormQueryString(formObj));

            		if ( sXml != "" ) {
            			comboObj.InsertItem(0 , 'ALL','ALL'); 
            			SppComXml2ComboItem(sXml, comboObj, "lease_term_nm", "lease_term_cd", ROWMARK);
            			vOrcLstmCd = ComGetEtcData(sXml, "lease_term_nm");
            		}
            		break;	            		
            		
             }
        } 
         
        /**
         * Calling this function when clicking the check box if multiselect attribute is available
         */
        function combo1_OnCheckClick(comboObj, index, code) {
         	if(index==0) { 	    	
         		var bChk = comboObj.CheckIndex(index);
         		if(bChk){
         			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
         				comboObj.CheckIndex(i) = false;
         			}
         		}
         	} else {
         		comboObj.CheckIndex(0) = false;
         	}
        }          
        
         /**
     	 * Handling change event
     	 */
     	function obj_change(){
     		var obj      = event.srcElement;
     		var formObj  = document.form;
     		var sheetObj = sheetObjects[0];

     		if ( ComTrim(obj.value) != "" ) {
     			switch(ComGetEvent("name")) {
     	    		case "vndr_seq":
     	    			if( formObj.vndr_seq != "")
     	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC02);
     				   	break;
     			}
     	    }
     	}
     	
        /**
         * Calling this function when combo1 item is changed <br>
         * @param comboObj, value, text
         */	 	
        function combo1_OnChange(comboObj, value, text){ 		
        	if(  0 <= value.indexOf("ALL") ){ 			
        		document.form.lstm_cd.value = "";
        	}else{
        		var strLstmCd =  value.replaceStr(ROWMARK, FIELDMARK).split(FIELDMARK);
        		document.form.lstm_cd.value = strLstmCd;
        	}
        }  
         /**
          * Opening the page by Pop-up<br>
          * @param type, Row, Col
          */
          function openPopup(type, Row, Col) {	
          	var formObj = document.form;
          	if ( type == "2") {	
          		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 450, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);

          	} else if ( type == "3") {
          		ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 450, 'setPopData_Agreement', '1,0', true);

          	}	
          }
          /**
           * Setting Lessor(Service Provider) value from the Pop-up
           * @param aryPopupData, Row, Col, SheetIdx
           */
           function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
           	var sheetObj = sheetObjects[SheetIdx];
           	var formObj  = document.form;

           	if ( aryPopupData.length > 0 ) {
           		formObj.vndr_seq.value = aryPopupData[0][2];
           		formObj.vndr_nm.value  = aryPopupData[0][4];

           	}
           }
           
           /**
       	 * Clearing Form Element<br>
       	 * @param fieldName
       	 */
       	function clearForm(fieldName) {
       		var formObj = document.form;
       		switch(fieldName) {
       			case "vndr_seq":
       				ComSetObjValue(formObj.vndr_seq, "");
       				ComSetObjValue(formObj.vndr_nm,  "");
       				break;
       		}
       	}
