/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0002.js
*@FileTitle : Requested Advance Payment
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
     * @class EXP_SPP_0002 : business script for EXP_SPP_0002 
     */
    function EXP_SPP_0002() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initControl 			= initControl;
    	this.obj_deactivate         = obj_deactivate;
    	this.obj_change 			= obj_change;
    	this.obj_keyup 				= obj_keyup;
    	this.obj_activate 			= obj_activate;
    	this.obj_keypress 			= obj_keypress;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setBtnEnable 			= setBtnEnable;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnSearchEnd 	= sheet1_OnSearchEnd;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	
    }
    
    // The common global variables
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var ROWMARK = "|";
    var FIELDMARK = ",";    
    var ALLOWANCETEU = "cntr_pnm_capa";
    var CHANGEDVALUE = false;
    var GlobalRevYrmon = "";  	

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
        function processButtonClick(){ 
        	
             var sheetObject1 = sheetObjects[0];
             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

    	          case "btn_DownExcel":
    	        	    if(sheetObject1.RowCount <= 0){
    	        	        ComCodeMsgByNoRelatedData();  // There is no related data!
    	        	        return;
    	        	    }else{
    	        	        if(sheetObject1.RowCount > 0){
    	        	        	
    	        	        	var strTitle = "  VVD : "+formObject.vvdText.value+",  Rev. Month : "+formObject.rev_yrmon.value+",  TTL Amount : "+formObject.ttl_amt.value+",  SCNT : "+formObject.suz_net_tong_wgt.value+",  SDR : "+formObject.locl_xch_rt.value+",  Tier : "+formObject.tr_vol_val.value+",  Allowance TEU : "+formObject.cntr_pnm_capa.value+"  "  ;
    	        	        	
    	        	        	sheetObject1.CellValue(0,1)  = strTitle;
    	        	        	sheetObject1.RowHidden(0) = false;
    	        	        	sheetObject1.SpeedDown2Excel(-1,false,false,"","/apps/opus/exp/spp/ppsoagentcanaltransitfee/agentcanaltransitfee/xml/EXP_SPP_0002_FORMAT.xml",true,false,"",false);
    	        	        	sheetObject1.RowHidden(0) = true;
    	        	        }
    	        	    } 
    	        	    break;
						
				  case "btn_Request":
					  	var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					  	if(procSts!="R") break;  //not requesting in case of not being Ready status
		          	 	if(ComIsEmpty(formObject.rev_yrmon.value)){
		         	 		ComCodeMsgByEmptyData("ADV Payment Rev. Month");  //[{?msg1}] Value is Empty.
		         	 		return false;
		         	 	}
					    doActionIBSheet(sheetObject1,formObject,COMMAND01);
						break;
						
				  case "btn_Save":
					    var procSts = formObject.cnl_tz_proc_sts_cd.value.trim();
					    if(procSts!="" && procSts!="R") break;  //not saving in case of not being Ready status
					    
						//The ADV. Payment TTL Amount value is not same as Estimate TTL Amount value
						if(ComReplaceStr(formObject.ttl_amt.value,",","") != sheetObject1.SumValue(0, "sheet1_rqst_amt")){
							ComCodeMsgByUnMatchData("ADV. Payment TTL Amount", "Estimate TTL Amount");  
							return;
						}
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;	
						
			      case "btns_calendar":
			    	  	GlobalRevYrmon = document.form.rev_yrmon.value;
			        	
			        	var cal = new ComCalendar();
			        		cal.setDisplayType('month');
          					cal.select(formObject.rev_yrmon, 'yyyy-MM');
			        	
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
            
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
         
         /**
          * Adding some occurring events to form. 
          */
         function initControl() {
             //handling the occurring keypress event to the all fields        	  
			 axon_event.addListenerFormat('keypress',  'obj_keypress', 	form);
             //handling the occurring blur event to the all fields that contain dataformat attribute
			 axon_event.addListenerFormat('blur',  	'obj_deactivate',  	form); 
             //handling the occurring focus event to the all fields that contain dataformat attribute
			 axon_event.addListenerFormat('focus', 	'obj_activate',    	form);
			 //handling the occurring change event to the all fields that contain dataformat attribute			 
			 axon_event.addListenerFormat('change', 'obj_change',    	form);
			 //handling the occurring keyup event to the all fields that contain dataformat attribute
			 axon_event.addListenerFormat('keyup', 'obj_keyup',    		form);			 
			
			 //focusSetting
			 document.form.rev_yrmon.focus();
			 GlobalRevYrmon = document.form.rev_yrmon.value;
       	 }
            
         /*
          * Handling the code when occurring blur event
          */ 
         function obj_deactivate(){
      	     obj = event.srcElement;
             if(ComChkObjValid(event.srcElement)){
           	     if(obj.name=="rev_yrmon"){  
        		     if(ComReplaceStr(GlobalRevYrmon,"-","") != ComReplaceStr(document.form.rev_yrmon.value,"-","")){
        			     obj_change();
        			     GlobalRevYrmon = document.form.rev_yrmon.value;
        		     }
        		     return; 
        	     }
             }             
         }

         /*
          * Handling the code when occurring change event
          */
         function obj_change(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "rev_yrmon":
        	       case "ttl_amt":
        	       case "suz_net_tong_wgt":	  
        	       case "locl_xch_rt":	
        	       case "tr_vol_val":
        	       case "cntr_pnm_capa":   
        	    	   CHANGEDVALUE = true;
        		       break;
        		   default:
        			   break;
        	   }
         } 
         
         /*
          * Handling the code when occurring keyup event
          */
         function obj_keyup(){
        	   var srcName = window.event.srcElement.getAttribute("name");
        	   switch(srcName){
        	       case "rev_yrmon":
        	       case "ttl_amt":
        	       case "suz_net_tong_wgt":	  
        	       case "locl_xch_rt":	
        	       case "tr_vol_val":
        	       case "cntr_pnm_capa":   
        	    	   ComKeyEnter('LengthNextFocus');  //moving to next object automatically when the inputted value is the maxlength
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
          * Handling the code when occurring keypress event
          */
         function obj_keypress(){
         	 obj = event.srcElement;
        	 var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

        	 if(obj.dataformat == null) return;
      	    
        	 window.defaultStatus = obj.dataformat;
        	
        	 switch(obj.dataformat) {
        	     case "ymd":
        	     case "ym":
         	 		ComKeyOnlyNumber(obj);
        	 		break;        	    	 
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
    							InitRowInfo(2, 1, 3, onepagerows);
    							
    							//var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Tariff Amount|Diff.|Detail"; //ORG .. BUT DETAIL DEL.
    							
    							var HeadTitle2 = "";       
    							var HeadTitle1 = "|Seq.|COST CODE|ITEM|AMOUNT($)|Remark|Hidden3";
    							var headCount = ComCountHeadTitle(HeadTitle1);

    							//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    							InitColumnInfo(headCount, 6, 0, true);
    							
    							// Setting function handling header
    							InitHeadMode(false, true, false, true, false,false);
    							
    							//The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    							
    							InitHeadRow(0, HeadTitle2, false);
   			                 	InitHeadRow(1, HeadTitle1 , true);

    							var prefix = "sheet1_";
    							//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    							InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	daCenter,	true,	prefix+"ibflag");
    							InitDataProperty(0, cnt++ , dtSeq,			50,	daCenter,	true,	"Seq");
    							InitDataProperty(0, cnt++ , dtHidden,		100,daCenter,	true,	prefix+"lgs_cost_cd",		false,	"",	dfNone,			0,		false,	true);
    							InitDataProperty(0, cnt++ , dtData,			280,daLeft,		true,	prefix+"lgs_cost_full_nm",	false,	"",	dfNone,			0,		false,	true);
    							InitDataProperty(0, cnt++ , dtAutoSum,		150,daRight,	true,	prefix+"rqst_amt",			false,	"",	dfNullFloat,	2,		true,	true, 18);
    							InitDataProperty(0, cnt++ , dtData,			150,daLeft,		true,	prefix+"diff_rmk" ,			false,	"",	dfNone,			0,		true,	true, 50);
    							InitDataProperty(0, cnt++ , dtHidden,		0,	daCenter,	true,	prefix+"yd_cd",				false,	"",	dfNone,			0,		true,	true);
    							
    							InitDataValid(0, prefix+"diff_rmk", vtEngOther, "1234567890!@#$%^&*()_-+=[{]}|\\;:\"\'<,>.?/~` ");
 
    							
    							Ellipsis  	 = true;
    							RowHidden(0) = true;

    						}
    						break;   						
    						
            }
        }

        /*
         * Handling the process about the sheet
         */ 
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            switch(sAction) {

              case IBSEARCH:     
				formObj.f_cmd.value = SEARCH;
				if(validateForm(sheetObj,formObj,sAction)){
					if (sheetObj.id == "sheet1"){
						
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);
						
						ComClearFormSeparator(formObj);  
						var sXml = sheetObj.GetSearchXml("EXP_SPP_0002GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
						sheetObj.LoadSearchXml(sXml);
						
						
						//Setting Allowance TEU value
						var arrRslt = ComGetEtcData(sXml, ALLOWANCETEU).split(FIELDMARK);
						formObj.rev_yrmon.value = ((arrRslt[0]=="")?formObj.ntc_yrmon.value:arrRslt[0]);
						formObj.ttl_amt.value = ((arrRslt[1]=="")? "0.00":arrRslt[1]);
						formObj.suz_net_tong_wgt.value = arrRslt[2];
						formObj.locl_xch_rt.value = arrRslt[3];
						formObj.tr_vol_val.value = arrRslt[4];
						formObj.cnl_tz_proc_sts_cd.value = arrRslt[5];
						formObj.cntr_pnm_capa.value = arrRslt[6];
						
						ComSetFormSeparator(formObj);  				
						
						//Handling that the Request and Save buttons are activating/deactivating
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());
						CHANGEDVALUE = false;
						GlobalRevYrmon = formObj.rev_yrmon.value;
						
						ComOpenWait(false);
					}
				}
				break;
	              
			  case IBSAVE:		//Save
                if(validateForm(sheetObj,formObj,sAction)){
 	    		  	
  	    		  	//There is no data to save
  					if (!sheetObj.IsDataModified && !CHANGEDVALUE) {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}  
  					
  					//Handling multi data
  	    		  	formObj.f_cmd.value = MULTI;   	
  	    		  	formObj.cnl_tz_proc_sts_cd.value = "R";

  	    		    ComClearFormSeparator(formObj);  
  					var sParam = FormQueryStringOrg(formObj);
  					ComSetFormSeparator(formObj);  
  					
  					var sParam1 = sheetObj.GetSaveString();
  					
  					if (sParam1 == "" && !CHANGEDVALUE) {				
  						ComCodeMsgByNoContentsSave();
  						return; 
  					}
  					
  	    			if(!ComCodeMsgBySave()) return;  					
  					
  					sParam = sParam + "&" + sParam1;  //Ready
  	    		  	
  	    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0002GS.do", sParam);
  	    			sheetObj.LoadSaveXml(sXml);  
  	    			
                	if(ComSaveXml2ScssTF(sXml, "TR-ALL", 0)){
                		CHANGEDVALUE = false;
                		GlobalRevYrmon = formObj.rev_yrmon.value;
                		formObj.cnl_tz_proc_sts_cd.value = "R";
						//Handling that the Request and Save buttons are activating/deactivating
						setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	 
						
		    			//Returing adv_py_sts, adv_py_rev_mon and diff_rmk value to the opener window
		            	var strRslt = formObj.cnl_tz_proc_sts_cd.value;
		            	strRslt += "|"+ ComReplaceStr(formObj.rev_yrmon.value,"-","");
		            	strRslt += "|"+ ((formObj.diff_rmk.value.toLowerCase().indexOf("reject")!=-1)?"":formObj.diff_rmk.value);
						window.returnValue = strRslt;
                	}            	
                }
                break;
                
			  case COMMAND01:	//Request
    		  	//There is some data to save
				if (sheetObj.IsDataModified || CHANGEDVALUE) {				
					ComShowCodeMessage("SPP01008");  //There is contents to save. First, save contents!
					return; 
				}  
				
				//Handling multi data
    		  	formObj.f_cmd.value 			 = COMMAND01; 
    		  	formObj.cnl_tz_proc_sts_cd.value ='Q';

    		  	ComClearFormSeparator(formObj);
				var sParam = FormQueryStringOrg(formObj);
				ComSetFormSeparator(formObj);
				
    			if(!ComShowCodeConfirm('SPP01009')) return;
    		  	
    			var sXml = sheetObj.GetSaveXml("EXP_SPP_0002GS.do", sParam);
    			
    			ComShowMessage(ComSaveXml2Message(sXml, "MESSAGE", 0));  
            	if(!ComSaveXml2IsTagExist(sXml, "ERROR")){  //There is no ERROR tag
            		CHANGEDVALUE = false;
            		GlobalRevYrmon = formObj.rev_yrmon.value;
            		formObj.cnl_tz_proc_sts_cd.value = "Q";
            		//Handling that the Request and Save buttons are activating/deactivating
					setBtnEnable(formObj.cnl_tz_proc_sts_cd.value.trim());	            		
    			
	    			//Returining adv_py_sts, adv_py_rev_mon, diff_rmk value to the opener window
	            	var strRslt = formObj.cnl_tz_proc_sts_cd.value;
	            	strRslt += "|"+ ComReplaceStr(formObj.rev_yrmon.value,"-","");
	            	strRslt += "|"+ ((formObj.diff_rmk.value.toLowerCase().indexOf("reject")!=-1)?"":formObj.diff_rmk.value);
					window.returnValue = strRslt;
					self.close();
            	}
    			
    			break;                
            }
        }       
        
        /**
        * Handling that the Request and Save buttons are activating/deactivating
        */        
        function setBtnEnable(procSts){
        	//activating/deactivating Request button 
		    if(procSts!="R"){   //The status is not 'Ready'				
				btn_Request.disabled = true;
		    }else{
		    	btn_Request.disabled = false;
		    }
			
		  //activating/deactivating Save button
		    if(procSts!="" && procSts!="R"){  //The status is not 'Ready' or it is not never been to save
		    	btn_Save.disabled = true; 
		    }else{
		    	btn_Save.disabled = false;
		    }        	
        }

        /**
         * Handling the process for the input validation
         */
        function validateForm(sheetObj,formObj,sAction){
        	 var prefix = "sheet1_";
        	 switch(sAction){
             	 case IBSEARCH:	//Retrieving
             	 	if(ComIsEmpty(formObj.vndr_seq.value)){
             	 		ComCodeMsgByEmptyData("vndr_seq");
             	 		return false;
             	 	}  
	          	 	if(ComIsEmpty(formObj.vvd.value)){
	          	 		ComCodeMsgByEmptyData("vvd");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.yd_cd.value)){
	         	 		ComCodeMsgByEmptyData("yd_cd");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.call_seq.value)){
	         	 		ComCodeMsgByEmptyData("call_seq");
	         	 		return false;
	         	 	} 
	         	 	if(ComIsEmpty(formObj.ntc_yrmon.value)){
	         	 		ComCodeMsgByEmptyData("ntc_yrmon");
	         	 		return false;
	         	 	}          	 	
             	 	break;
             	 
	        	 case IBSAVE:  //SAVE
	        	 	
	        		break;
	        		 
	             default:
	            	break;
        	 }
        	 
        	 return true;
        }

        /*
         * Calling this function in case of occurring OnSearchEnd event in sheet1
         */
		function sheet1_OnSearchEnd(sheetObj, ErrMsg){
			var prefix = "sheet1_";
			with(sheetObj){

				var row = LastRow;
				SumText(0, "Seq") = "";
				SumText(0, prefix+"lgs_cost_full_nm") = "Estimate TTL Amount:";
				CellAlign(row, prefix+"lgs_cost_full_nm") = daRight;
			}
		}
    		
		/**
         * IBSheet Popup Event
         */
         function sheet1_OnPopupClick(sheetObj,Row,Col){
        	 var prefix = "sheet1_";
 			
             switch (sheetObj.ColSaveName(Col)) {
             	  case prefix + "diff_rmk" :
            	 	   var url = 'VOP_VSK_0218.do?strText='+sheetObj.CellValue(Row,Col);
            	 	   url = encodeURI(url);
            	 	   var rsltObj = ComOpenPopup(url, 340, 335, '', '0,0', true, false, Row, Col, 0, 'compopupRemark');

            	 	   if(rsltObj != undefined){  //Checking the returning value in case of clicking close button
	            	 	   sheetObj.CellValue2(Row, prefix + "diff_rmk") = rsltObj;
	             	   }
                  break;
             }
         }    		

