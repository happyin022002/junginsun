/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_mst_0024.js
*@FileTitle  : Container Status Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	 // common static variable
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 var IBSEARCH01=29;
	 var IBSEARCH02=30;
	 var IBSEARCH03=31;
	 var comboObjects=new Array();
	 var comboCnt=0;
	 var tcnt=0;
	 var blurflg=false;
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var formObject=document.form;
         try {
             var srcName=ComGetEvent("name");
             if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
				case "btn_master":
					if (sheetObjects[0].RowCount() != 0 ) {
						var cntr_no=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no");
						if (sheetObjects[0].GetRowStatus(sheetObjects[0].GetSelectRow()) != "D"){
							var cntr_no_len=cntr_no.length;
							if ( cntr_no_len > 10 ) {
								cntr_no=cntr_no.substring(0,10);
							} 
							ComOpenPopup("/opuscntr/EES_MST_0019_POP.do?popup_mode=Y&cntr_no="+cntr_no,1200, 750, "", "1,0,1,1,1,1,1,1", true);
						}
					}
					break;  
					
				case "btn_retrieve":
					if (formObject.st_cd.value == "") {
						ComShowCodeMessage("MST00001", "Status Code");
						ComSetFocus(formObject.st_cd);
						return;
					} 
					if (formObject.hire_date.value == "") {
						ComShowCodeMessage("MST00001", "Date");
						ComSetFocus(formObject.hire_date);
						return;
					}
					if (formObject.sts_evnt_yd_cd.value == "") {
						ComShowCodeMessage("MST00001", "Yard");
						ComSetFocus(formObject.sts_evnt_yd_cd);
						return;
					}
					if (formObject.st_cd.value == "1" || formObject.st_cd.value == "3"|| formObject.st_cd.value == "5" || formObject.st_cd.value == "7" || formObject.st_cd.value == "8" ) {
						if (formObject.agmt_cty_cd.value == "" || formObject.agmt_seq.value == ""){
							ComShowCodeMessage("MST00001", "AGMT No.");
							ComSetFocus(formObject.agmt_seq);
							return;
						}
					}
					
				    if(formObject.st_cd.value == "1" ||formObject.st_cd.value == "3") {
                		if(approval_no.GetSelectIndex() == -1) {
                			ComShowCodeMessage("MST00001", "Auth No.");
                			return false;
                		} 
                	}

					if ((formObject.st_cd.value == "0" && formObject.agmt_seq.value.trim().length > 0)  || formObject.st_cd.value == "1" || formObject.st_cd.value == "3" || formObject.st_cd.value == "5" || formObject.st_cd.value == "7" || formObject.st_cd.value == "8" || formObject.st_cd.value == "9" || formObject.st_cd.value == "10" || (formObject.st_cd.value == "11" && formObject.agmt_seq.value.trim().length > 0)) {
					   doActionIBSheet(sheetObject1,formObject,IBSEARCH01);
					}
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
				
				case "btn_loadexcel" :
					if (formObject.hire_date.value == "") {
						ComShowCodeMessage("MST00001", "Date");
						ComSetFocus(formObject.hire_date);
						return;
					}
					if (formObject.sts_evnt_yd_cd.value == "") {
						ComShowCodeMessage("MST00001", "Yard");
						ComSetFocus(formObject.sts_evnt_yd_cd);
						return;
					}
					
					if (formObject.st_cd.value == "1" || formObject.st_cd.value == "3"|| formObject.st_cd.value == "5" || formObject.st_cd.value == "7" || formObject.st_cd.value == "8" ) {
						if (formObject.agmt_cty_cd.value == "" || formObject.agmt_seq.value == ""){
							ComShowCodeMessage("MST00001", "AGMT No.");
							ComSetFocus(formObject.agmt_seq);
							return;
						}
					}
					
					if(formObject.st_cd.value == "1" ||formObject.st_cd.value == "3") {
						if (approval_no.GetSelectIndex() != -1){
						}else{
							ComShowCodeMessage("MST00001", "Auth No.");
							return false;
						}
					}
					
					sheetObject1.RemoveAll();
					sheetObjects[1].RemoveAll();
        	    	//var ccheck = sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false});
										
					var ccheck = sheetObject1.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",Append:false});
				break;	
				
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObjects[1].RemoveAll();
					setSearchField('1');
					setFieldOfStatusCode(formObject.st_cd.value);
					formObject.sts_evnt_yd_cd.value="";
					formObject.agmt_cty_cd.value="HHO";
					formObject.agmt_seq.value="";
					formObject.vndr_seq.value="";
					formObject.vndr_abbr.value="";
					formObject.ref_no.value="";
					formObject.vndr_nm.value="";
					formObject.vndr_abbr.value="";
					formObject.yd_cd_nm.value="";
					formObject.st_cd.value="";
					formObject.hire_date.value="";
					formObject.eff_dt.value="";
					formObject.exp_dt.value="";
					sheetObject1.SetHeaderCheck(0,"del_chk",0);
					ComSetFocus(formObject.st_cd);			
					
					formObject.approval_vol.value="";
					formObject.pick_up_vol.value="";
					formObject.pick_up_due_date.value="";
					comboObjects[0].RemoveAll();
					
					ComBtnEnable("btn_add");
					ComBtnEnable("btn_loadexcel");					
					ComBtnEnable("btn_retrieve");
					ComBtnEnable("btn_save");
					load_code_change();
				break;
				
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE)
					ComBtnDisable("btn_save");
				break;
					
				case "btn_add":
					doActionIBSheet(sheetObject1,formObject,IBINSERT)
				break;
					
				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("del_chk")==""){
   						ComShowCodeMessage("MST00010");
   					} else if(ComShowCodeConfirm("MST00005")){ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
   				break;
   				
                case "ComOpenPopupWithTargetYard":
                	if (formObject.sts_evnt_yd_cd.readOnly == false){
         		        ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 530, "3:sts_evnt_yd_cd|4:yd_cd_nm", "0,0,1,1,1,1,1", true);
         		        if (formObject.sts_evnt_yd_cd.value == ""){
         		        	formObject.yd_cd_nm.value="";
         		        }
	                	if (formObject.sts_evnt_yd_cd.value.length > 0 && formObject.sts_evnt_yd_cd.value.length != 7){
	                		ComShowCodeMessage("MST01019", formObject.sts_evnt_yd_cd.value);
	                		formObject.sts_evnt_yd_cd.value="";
	                		formObject.yd_cd_nm.value="";
	                		ComSetFocus(formObject.sts_evnt_yd_cd);
	                		return;
	                	} else {
	                		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	                	}          		       
                	}   
         		break;
         		
                case "ComOpenPopupWithTargetAgmtNo": //agmt no
                if (formObject.agmt_seq.readOnly == false)
   			       ComOpenPopup('/opuscntr/EES_LSE_0091.do', 900, 480, 'setPopData_Agreement', '0,0,1', true); 			                	
                break;       
                
                case "cal_img":
                	func_calendar('calendarPopup1');
                	break;
             } // end switch
         }catch(e) {
             if( e == "[object Error]") {
                 ComShowMessage(OBJECT_ERROR);
             } else {
                 ComShowMessage(e.message);
             }
         }
     }
     
     
     function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    	 if(isExceedMaxRow(msg))return;
    	 
    	 var sheetObject1=sheetObjects[0];
         var formObject=document.form;
         
         
         if(formObject.st_cd.value == "1" ||formObject.st_cd.value == "3") {
			var intpickUpVol = formObject.pick_up_vol.value;
			var intRowCnt = sheetObj.RowCount();
			
			if (approval_no.GetSelectIndex() != -1){
				if(parseInt(intpickUpVol)>= parseInt(intRowCnt)) {
				}else{
					ComShowCodeMessage("MST02050");
					sheetObj.RemoveAll();
					sheetObjects[1].RemoveAll();
					return false;
				}
			}else{
				ComShowCodeMessage("MST00001", "Auth No.");
				return false;
			}
		}
         
    	 if(result) {
    		 doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    	 } else {
    		 
    	 }
    }
     
     
     /**
      * registering IBsheet Object as list
      * adding process for list in case of needing batch processing with other items 
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){        
         sheetObjects[sheetCnt++]=sheet_obj;
     }
     
     /**
    	 * registering IBMultiCombo Object as list
    	 * adding process for list in case of needing batch processing with other items 
    	 * defining list on the top of source
    	 */
   	function setComboObject(combo_obj){
   		comboObjects[comboCnt++]=combo_obj;
   	}      
   	
   	
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
    	 //Login Office가 SINHO가 아닐 경우
    	 var formObj = document.form;    	 
    	 var objstCd = document.getElementById("st_cd");   
    	 
    	 if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd)) ) {
    		 //st_cd 콤보 변경
    		 for(var i=0;i<objstCd.length;i++) {
        		 if(objstCd.options[i].text == "LSO(Direct)") {
        			 objstCd.options[i].text = "SH(XX)";
        		 }
        		 
        		 if(objstCd.options[i].text == "DON")  $('#st_cd option[value=7]').hide();
        		 if(objstCd.options[i].text == "SCR")  $('#st_cd option[value=8]').hide();
        		 if(objstCd.options[i].text == "SLD")  $('#st_cd option[value=9]').hide();
        		 if(objstCd.options[i].text == "TLL")  $('#st_cd option[value=10]').hide();
        	 }
    		
    	 }
    	 
         //IBsheet initailizing
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet(sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             sheetObjects[i].SetCountPosition(0);
             ComEndConfigSheet(sheetObjects[i]);
         }
         for ( k=0 ; k < comboObjects.length ; k++ ){
        	 initCombo(comboObjects[k], k+1);
    	 }   
         
         document.form.st_cd.value="";
         document.form.hidden_curdate.value=ComGetNowInfo("ymd");
         document.form.agmt_cty_cd.value="HHO";
 	     document.getElementById("agmt_cty_cd").className= "input";
 	     document.getElementById("agmt_seq").className= "input";             
         initControl();
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);    
    	 load_code_change();
//         ComBtnDisable("btn_add");
//         ComBtnDisable("btn_loadexcel");
         ComSetFocus(document.form.st_cd);
     }   
     
     /**
 	 * setting combo initial values and header
 	 * param : comboObj ==> combo object, sheetNo ==> combo object combo object no.
 	 */
    	function initCombo(comboObj, comboNo) {
    		var formObj=document.form;
    	    switch(comboObj.options.id) {
    	        case "approval_no":
    	        	with(comboObj) {
	  			   	    SetTitle("Auth No.|Old/New|TP/SZ|Auth Vol.|Pick-up Vol.|Pick-up Period|tpsz|pca|pcca|mod|locg|fdys|lonchg|spno|ppp|qqq");  
	  			   	    SetTitleVisible(true);    
	 					SetColAlign(0, "left");
	 					SetColAlign(1, "center");
	 					SetColAlign(2, "center");
	 					SetColAlign(3, "right");
	 					SetColAlign(4, "right");
	 					SetColAlign(5, "center");
	 					SetColAlign(6, "center");
	 					SetColAlign(7, "center");
	 					SetColAlign(8, "center");
	 					SetColAlign(9, "center");
	 					SetColAlign(10, "center");
	 					SetColAlign(11, "center");
	 					SetColAlign(12, "center");
	 					SetColAlign(13, "center");
	 					SetColAlign(14, "center");
	 					SetColAlign(15, "center");
	 					SetColWidth(0, "180");
	 					SetColWidth(1, "65");
	 					SetColWidth(2, "50");
	 					SetColWidth(3, "110");
	 					SetColWidth(4, "110");
	 					SetColWidth(5, "150");
	 					SetColWidth(6, "-1");
	 					SetColWidth(7, "-1");
	 					SetColWidth(8, "-1");
	 					SetColWidth(9, "-1");
	 					SetColWidth(10, "-1");
	 					SetColWidth(11, "-1");
	 					SetColWidth(12, "-1");
	 					SetColWidth(13, "-1");
	 					SetColWidth(14, "-1");
	 					SetColWidth(15, "-1");
	 				    SetDropHeight(160);
	    	           	SetMultiSelect(0);
	    	           	SetMaxSelect(1);
 	   		  			if (formObj.st_cd.value == "SO" || formObj.st_cd.value == "MO"){
 	   		  				SetBackColor("#D4F6FF");
 	   		  				SetDisabledBackColor("#D4F6FF");
 	   		  			} else {
 	   		  				SetBackColor("#FFFFFF");
 	   		  				SetDisabledBackColor("#FFFFFF");
 	   		  			}
	 	   		  		 	            	
    	            }
    	        	//doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
    	        	break;
    	    }
    	}      
    	
    	
 	 // Axon handling event
 	 // 1. event catch
 	 function initControl() {
 		var formObj=document.form;
        //axon_event.addListenerFormat('beforedeactivate','obj_blur',form);   //- handling OnBeforeDeactivate event of all control except rdoCity
 		axon_event.addListenerFormat('blur',	'obj_blur',          form);   //- handling OnBeforeDeactivate event of all control except rdoCity 		
        axon_event.addListenerFormat('focus',   'obj_focus',         form);   //- handling OnBeforeDeactivate event of all control that has dataformat attribute
        axon_event.addListenerFormat('change','obj_change',formObj); 
 	    axon_event.addListener('keydown',		'ComKeyEnter',	     'form'); //- when key down
 	    // axon_event.addListenerFormat('keypress','obj_keypress',	     form);   //- when key down
		axon_event.addListener('change', 		'status_code_change','st_cd');
		
	     axon_event.addListenerFormat('keyup',	'obj_keyup',		 form);   //- when key down		
	    // axon_event.addListenerFormat('keydown',	'obj_keydown',		 form);   //- when key down
  	}
 	 
 	function obj_change(){
 		var obj=ComGetEvent();
 		var vKeyCode=event.keyCode;
 		var formObj=document.form;
 		if (ComGetEvent("name") == "hire_date"){
	    	ComAddSeparator(formObj.hire_date);
	    	if (ComGetNowInfo("ymd") < formObj.hire_date.value){
	    		formObj.hire_date.value=ComGetNowInfo("ymd");
	    		ComAlertFocus(formObj.hire_date,ComGetMsg("MST01006", "", "", ""));
	    	} else {
	    		ComAddSeparator(formObj.hire_date, "ymd");
	    		if (formObj.sts_evnt_yd_cd.value != "" && formObj.sts_evnt_yd_cd.value.length == 7 && formObj.agmt_seq.value.trim().length > 0){  
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH03);
				}
	    	}
	    	
	    }
	    else if(ComGetEvent("name") == "agmt_seq"){
	    	if (formObj.agmt_seq.value.trim().length > 0){    		    		
    		    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH01);
	    	}
    		
    		if (formObj.agmt_seq.value.trim().length <= 0){    	
    			comboObjects[0].RemoveAll();
    			
    			formObj.ref_no.value="";
    			formObj.vndr_seq.value="";
    			formObj.vndr_abbr.value="";
    			formObj.vndr_nm.value="";
    			
				formObj.approval_vol.value="";
				formObj.pick_up_vol.value="";
				formObj.pick_up_due_date.value="";			      
				formObj.f_cmd.value=SEARCH;
				formObj.f_cmd.value=SEARCH;
    		} 
	    }
	    else if(ComGetEvent("name") == "sts_evnt_yd_cd"){
		    if (formObj.sts_evnt_yd_cd.value == ""){
		    	formObj.yd_cd_nm.value="";
 		    }
        	if (formObj.sts_evnt_yd_cd.value.length > 0 && formObj.sts_evnt_yd_cd.value.length != 7){
        		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
        		formObj.sts_evnt_yd_cd.value="";
        		formObj.yd_cd_nm.value="";
        		ComSetFocus(formObj.sts_evnt_yd_cd);
        		return false;
        	}
        	
        	if(formObj.sts_evnt_yd_cd.value != "" && formObj.sts_evnt_yd_cd.value.length == 7 && formObj.agmt_seq.value.trim().length > 0){
	    		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH03);
	    	}
        	
        	
	    }
	    else {
            //Validation  check(lenth, format, max, min etc)
            ComChkObjValid(obj);
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH02);
	    }
 		
 		
 	}
 	

 	function status_code_change(){
		var formObj=document.form;		
        //formObj.st_cd.value : 0 ==> LSO
		//formObj.st_cd.value : 1 ==> SBO
		//formObj.st_cd.value : 2 ==> SBI
		//formObj.st_cd.value : 3 ==> MUO
		//formObj.st_cd.value : 4 ==> MUI		
		
		 var sheetObject1=sheetObjects[0];
         var formObject=document.form;

         sheetObject1.RemoveAll();
		 sheetObjects[1].RemoveAll();
		 
		setFieldOfStatusCode(formObj.st_cd.value);
		if (formObj.agmt_seq.value != "") {
		   doActionIBSheet(sheetObjects[0],formObj,IBSEARCH01);
		}
	}
 	
 	function load_code_change(){
		var formObj=document.form;		
        //formObj.st_cd.value : 0 ==> LSO
		//formObj.st_cd.value : 1 ==> SBO
		//formObj.st_cd.value : 2 ==> SBI
		//formObj.st_cd.value : 3 ==> MUO
		//formObj.st_cd.value : 4 ==> MUI	
		formObj.st_cd.value = "0";
		
		setFieldOfStatusCode(formObj.st_cd.value);
		if (formObj.agmt_seq.value != "") {
		   doActionIBSheet(sheetObjects[0],formObj,IBSEARCH01);
		}
	}
// 	function obj_keypress(){
//	    obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//	    var vKeyCode=event.keyCode;
//	    switch(obj.dataformat) {
//	        case "engup":
//	            if(obj.name=="sts_evnt_yd_cd") ComKeyOnlyAlphabet('uppernum');	  
//	            if(obj.name=="agmt_cty_cd") ComKeyOnlyAlphabet('upper');
//	            if(obj.name=="agmt_seq") ComKeyOnlyNumber('int');
//	            break;
//	        case "ymd":
//	        	if(obj.name=="hire_date") ComKeyOnlyNumber('int', "-");
//	        	break;
//	    }
//	}
// 	function obj_keydown() {
// 		var obj=event.srcElement;
// 		var vKeyCode=event.keyCode;
// 		var formObj=document.form;
// 		switch(ComGetEvent("name")) {
//			case "agmt_seq":
//				if ((vKeyCode == 13 || vKeyCode == 9) &&   //enter key pressed, unvailalbe to retrieve twice
//					formObj.agmt_cty_cd.value.length == 3 && 
//					formObj.agmt_seq.value.trim().length > 0 &&
//					formObj.agmt_seq.readOnly == false) {
//					// call LSE
//		    		ComSetFocus(formObj.agmt_cty_cd);
//				}
//			break;			
// 	    }
// 	}	
  	function obj_keyup() {
 		var obj=ComGetEvent();
 		var vKeyCode=event.keyCode;
 		var formObj=document.form;
 		switch(ComGetEvent("name")) {
			case "agmt_cty_cd":
				if (formObj.agmt_cty_cd.value.length == 3) {
					ComSetFocus(formObj.agmt_seq);
				}
			break;
			case "sts_evnt_yd_cd":
				if ((vKeyCode == 13 || vKeyCode == 9) && 
					formObj.agmt_cty_cd.value.length == 3 && 
					formObj.agmt_seq.value.trim().length > 0 &&
					formObj.agmt_seq.readOnly == false) {
					// call LSE
					ComSetFocus(formObj.agmt_cty_cd);
				} else if (vKeyCode == 13){
					ComSetFocus(formObj.agmt_cty_cd);
				}
				if (formObj.sts_evnt_yd_cd.value.length == 7) {
	        		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
	        		ComSetFocus(formObj.agmt_cty_cd);		
				}
			break;
 		}
 	}
	//handling event blur
	function obj_blur(){
		var formObj=document.form;
		var obj=ComGetEvent();
		
	    
	}
	//handling event focus
	function obj_focus(){
		var formObj=document.form;
		var obj=ComGetEvent();
	    /*if (ComGetEvent("name") == "hire_date"){		
	    	ComClearSeparator(formObj.hire_date, "ymd");
	    	ComSetFocus(formObj.hire_date);
	    }*/	
	}	
     /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // t1sheet1 init
                 with(sheetObj){
					var HeadTitle1="|Del|CNTR No.|Off-hire\nConfirm Flag|Off-Hire\nDue Date|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor Name|EQ Status|EQ Status Date|F/M|MVMT Status|MVMT Yard|MVMT Date|Off-Hire Yard|DOC\nCharge|DOC\nCredit|Handle On/Off Charge|Handle On/Off Charge|Free Day|Old/New|Pick Up\nCharge|Pick Up\nCredit|Remark(s)|a|b|c|d|e|f|g|h||";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_due_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0  },
								{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:2 },
								{Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:2 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:3 },
								{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:20 },
								{Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:6 },
								{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:100 },
								{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:3 },
								{Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd" },
								{Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"full_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:1 },
								{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:2 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 ,   EditLen:7 },
								{Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd", UpdateEdit:0,   InsertEdit:0  },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lse_co_rtn_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_cr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
								{Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lft_chg_cur",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
								{Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_lft_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
								{Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rntl_chg_free_dys",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
								{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_old_van_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
								{Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_cr_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
								{Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aeflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"beflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"deflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"feflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ieflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ueflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								{Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
					InitColumns(cols);
					SetEditable(1);
					SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
					SetColProperty("cntr_old_van_flg", {ComboText:"Old|New", ComboCode:"O|N"} );
					SetShowButtonImage(1);
					//SetSheetHeight(410);
					resizeSheet();
             		}
                 break;
             case 2:      // t1sheet1 init
            	    with(sheetObj){
		               var HeadTitle1="|Sel.|CNTR No.|Off-Hire\nConfirm Flag|Off-Hire\nConfirm Date|TP/SZ|Term|AGMT No.|Contract No.|Lessor|Lessor\nName|EQ\nStatus|EQ Status\nDate|F/M|MVMT\nStatus|MVMT\nYard|MVMT Date|Off-Hire Yard|DOC\nCharge|DOC\nCredit|Handle On/Off Charge|Handle On/Off Charge|Free Day|Old/New|Pick Up\nCharge|Pick Up\nCredit|Remark(s)|a|b|c|d|e|f|g|h||";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                      {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_due_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"ref_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                      {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		                      {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                      {Type:"Popup",     Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_evnt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"full_flg",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
		                      {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
		                      {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
		                      {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lse_co_rtn_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
		                      {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                      {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_drff_cr_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                      {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_lft_chg_cur",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                      {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cntr_lft_chg_amt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                      {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"rntl_chg_free_dys",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
		                      {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_old_van_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_chg_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                      {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cntr_pkup_cr_chg_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cntr_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"aeflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"beflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ceflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"deflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eeflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"feflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ieflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ueflg",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                      {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"eff_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"exp_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		               InitColumns(cols);
		               SetEditable(1);
		               SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		               SetColProperty("cntr_old_van_flg", {ComboText:"Old|New", ComboCode:"O|N"} );
		               SetShowButtonImage(1);
		               //SetSheetHeight(170);
		               resizeSheet();
             	}
             break;                 
         }
     }
     
     // handling process for sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
			case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
            	var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		var arrRow=dupRows.split(",");
		        if (dupRows != ""){
		        	 ComShowCodeMessage("MST00002", sheetObj.GetCellValue(arrRow[0],2));
		             sheetObj.SelectCell(arrRow[0], 2, true);
	       			 return;
		        }
		        
		        
				//color rollback
				for (var i=1; i <= sheetObj.RowCount(); i++){
					setsheetRowColorBlack(i);				
				}
				
				
                if (formObj.st_cd.value == "0" ){
                   sheetObj.SetWaitImageVisible(0);
                   ComOpenWait(true);
 			       formObj.f_cmd.value=SEARCH;
 			       sheetObj.DoSearch("EES_MST_0024GS.do", FormQueryString(formObj) );
 			       ComOpenWait(false);
 				   setSearchField('0');			       
                } else if(formObj.st_cd.value == "1" || formObj.st_cd.value == "2" || formObj.st_cd.value == "3" || formObj.st_cd.value == "4" || formObj.st_cd.value == "5" || formObj.st_cd.value == "6" || formObj.st_cd.value == "7" || formObj.st_cd.value == "8" || formObj.st_cd.value == "9" || formObj.st_cd.value == "10" ||formObj.st_cd.value == "11"){
                	
                	formObj.hid_cntr_no.value="";
 					for (var i=1; i <= sheetObj.RowCount(); i++){
 						if (formObj.hid_cntr_no.value == ""){
 							if (sheetObj.GetRowHidden(i) != true)
 								formObj.hid_cntr_no.value=sheetObj.GetCellValue(i,"cntr_no");
 						} else {
 							if (sheetObj.GetRowHidden(i) != true)
 								formObj.hid_cntr_no.value=formObj.hid_cntr_no.value + "," + sheetObj.GetCellValue(i,"cntr_no");
 						}
 					}
 					if (sheetObj.RowCount()> 0 && formObj.hid_cntr_no.value != ""){
 	                    sheetObj.SetWaitImageVisible(0);
 	                    ComOpenWait(true); 						
 						formObj.f_cmd.value=SEARCH;
 						sheetObj.DoSearch("EES_MST_0024GS.do", FormQueryString(formObj) );
 						ComOpenWait(false);
 					} else {
 	            		ComShowCodeMessage("MST00001", "CNTR No.");
 	            		return;							
 					}
 					setSearchField('0');
 					var cntrnochk=false;
 					for (var i=1; i <= sheetObj.RowCount(); i++){
 						if(sheetObj.GetCellValue(i, "agmt_no") == ""){
 							cntrnochk=true;
 							sheetObj.SetCellFontColor(i,"cntr_no","#FF0000");
 							sheetObj.SetCellEditable(i, "cntr_no",1);
 						} else {
 							sheetObj.SetCellEditable(i, "cntr_no",0);
 						}
 					}
 				    if (cntrnochk == true)
 				    	ComShowCodeMessage("MST02014");
                }
             }
			break;
			
			case IBINSERT:      // inserting
				if(formObj.st_cd.value == "1" ||formObj.st_cd.value == "3") {
					var intpickUpVol = formObj.pick_up_vol.value;
					var intAuthVol = formObj.approval_vol.value;
					var intGap = intAuthVol - intpickUpVol;
					var intRowCnt = sheetObj.RowCount()+1;
					if (approval_no.GetSelectIndex() != -1){
						if(parseInt(intGap)>= parseInt(intRowCnt)) {
							sheetObj.DataInsert();
						    setFieldOfStatusCode(formObj.st_cd.value);
						    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_tpsz_cd","",0);
						    sheetObj.SelectCell(sheetObj.GetSelectRow(),"cntr_no", true);
						} else{
							ComShowCodeMessage("MST02050");
							return false;
						}
					}else{
						ComShowCodeMessage("MST00001", "Auth No.");
						return false;
					}
				}else{
					sheetObj.DataInsert();
				    setFieldOfStatusCode(formObj.st_cd.value);
				    sheetObj.SetCellValue(sheetObj.GetSelectRow(),"cntr_tpsz_cd","",0);
				    sheetObj.SelectCell(sheetObj.GetSelectRow(),"cntr_no", true);
				}
			break;
			
			case IBDELETE:      // removing
   	   		if (sheetObj.id == 'sheet1') {  
   	   			sheetObj.SelectFontBold=false;
	   	   		if(sheetObj.FindCheckedRow("del_chk") != ""){
					//ComRowHide(sheetObj,"del_chk");
					ComRowHideDelete(sheetObj,"del_chk");
				}
			}
			break;
			
			case IBSAVE:
				var objstCd = document.getElementById("st_cd");  
				
				for (var i=1 ; i <= sheetObj.RowCount(); i++){
					if ( 
						 (sheetObj.GetCellValue(i , "cntr_no") == "") ||
						 (sheetObj.GetCellValue(i , "cntr_no") == null)
						 ) {
						ComShowCodeMessage("MST00001", "CNTR No.");
						return;
					}
					
					if(sheetObj.GetCellValue(i , "agmt_no") == "") {
						ComShowCodeMessage("MST02014");
						return;
					}
				}
				
				var strStatusCd = objstCd.options[objstCd.selectedIndex].text;
				if(strStatusCd == "SBO" || strStatusCd == "MUO") {
					
					var strTpSz = formObj.tpsz_cd.value;
		 			
		 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
			        	if(strTpSz != sheetObj.GetCellValue(i,"cntr_tpsz_cd")) {
			        		sheetObj.SetCellFontColor(i, "cntr_tpsz_cd","#FF0000");
			        		ComShowCodeMessage("MST02030");
			        		return false;
			        	}
			        }
		 			
					formObj.f_cmd.value=SEARCH23;
					sheetObj.SetWaitImageVisible(0);
					var str_agmt_seq = formObj.agmt_seq.value;
					var chk_date = formObj.hire_date.value;
					
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj)+"&sch_date="+chk_date+"&sch_agmt_no="+str_agmt_seq);
					sheetObj.SetWaitImageVisible(1);
	
					if ( sXml != "" ) {
						if ( ComGetEtcData(sXml, "check_date_yn") != undefined && ComGetEtcData(sXml, "check_date_yn") != "") {
							if(ComGetEtcData(sXml, "check_date_yn") == "N") {
								ComShowCodeMessage("MST02045");
								formObj.hire_date.focus();
								return false;
							}
						} 
					}

				}
					
	    		//st_cd 콤보 변경
        		if(objstCd.options[objstCd.selectedIndex].text == "SH(XX)") {		        			
        			for (var i=1 ; i <= sheetObj.RowCount(); i++){		
	        			if(sheetObj.GetCellValue(i , "lstm_cd") != "SH"){
	        				if(sheetObj.GetRowHidden(i) == "0") {
	        					ComShowCodeMessage("MST02007", sheetObj.GetCellValue(i , "lstm_cd"));
	        					sheetObj.SelectCell(i,"lstm_cd");
	        					return;
	        				}
						}
        			}
        		}
				
				//dup checking
            	var dupRows = sheetObj.ColValueDupRows("cntr_no", false);
        		var arrRow=dupRows.split(",");
		        if (dupRows != ""){
	       			 //error message : Data is duplicated, Please check data again.
		        	ComShowCodeMessage("MST00002", sheetObj.GetCellValue(arrRow[0],"cntr_no"));
		             sheetObj.SelectCell(arrRow[0], "cntr_no", true);
	       			 return;
		        }
		        
		        
		        if(sheetObj.RowCount() == 0) {
		        	ComShowCodeMessage("MST00012");
		        	return;
		        }
		        
		        if(formObj.st_cd.value == "0") {
		        } else {
					for(var i=1; i <= sheetObj.RowCount(); i++){
						if (sheetObj.GetCellEditable(i, "cntr_no") == false	&& sheetObj.GetCellEditable(i, "ibflag") == "R"){						
							ComShowCodeMessage("MST02015");
							sheetObj.SelectCell(i, "cntr_no", true);
							return;
						}
						var lftamt=parseFloat(sheetObj.GetCellValue(i,"cntr_lft_chg_amt"));
						var currcd=sheetObj.GetCellValue(i,"cntr_lft_chg_cur");
				    	if (lftamt > 0 && currcd == ""){
				    		ComShowCodeMessage("MST00001", "Lift On/Off Charge Currency.");
				    		sheetObj.SelectCell(i,"cntr_lft_chg_amt");
				    		return;
				    	}
					}		        	
		        }
				//mandatory checking
				var stCdVal = formObj.st_cd.value;
//				if(stCdVal == "0" || stCdVal == "7" || stCdVal == "8" || stCdVal == "9" || stCdVal == "10" || stCdVal == "11"){
				if(stCdVal == "0" || stCdVal == "7" || stCdVal == "8" || stCdVal == "9" || stCdVal == "10" || stCdVal == "11"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   } 
				} else if (stCdVal == "1"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   } else if (formObj.agmt_cty_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "AGMT No.");
			    	   ComSetFocus(formObj.agmt_cty_cd);
			    	   return;					   
				   } else if (formObj.agmt_seq.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "AGMT No.");
			    	   ComSetFocus(formObj.agmt_seq);
			    	   return;					   
				   }
				   // mandatory checking onsheet
				   for(var i=0; i <= sheetObj.RowCount(); i++){
					   var cv=sheetObj.GetCellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }
				} else if (stCdVal == "2"){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   }
				   // mandatory checking onsheet
				   for(var i=0; i <= sheetObj.RowCount(); i++){
					   var cv=sheetObj.GetCellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }					
				} else if (stCdVal == "3"){
					   if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   } else if (formObj.agmt_cty_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_cty_cd);
				    	   return;					   
					   } else if (formObj.agmt_seq.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_seq);
				    	   return;					   
					   }
					   // mandatory checking onsheet
					   for(var i=0; i <= sheetObj.RowCount(); i++){
						   var cv=sheetObj.GetCellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }
				 } else if (stCdVal == "4" ){
				   if (formObj.hire_date.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Date");
			    	   ComSetFocus(formObj.hire_date);
			    	   return;
				   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
			    	   ComShowCodeMessage("MST00001", "Yard");
			    	   ComSetFocus(formObj.sts_evnt_yd_cd);
			    	   return;
				   }
				   // mandatory checking onsheet
				   for(var i=0; i <= sheetObj.RowCount(); i++){
					   var cv=sheetObj.GetCellValue(i,"cntr_no");
					   if (cv.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "CNTR No.");
				    	   sheetObj.SelectCell(i, "cntr_no", true);
				    	   return;						   
					   }
				   }
				 } else if (stCdVal == "5" || stCdVal == "7" || stCdVal == "8" ){
					 if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   } else if (formObj.agmt_cty_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_cty_cd);
				    	   return;					   
					   } else if (formObj.agmt_seq.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "AGMT No.");
				    	   ComSetFocus(formObj.agmt_seq);
				    	   return;					   
					   }
					   // mandatory checking onsheet
					   for(var i=0; i <= sheetObj.RowCount(); i++){
						   var cv=sheetObj.GetCellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }		
				 } else if (formObj.st_cd.value == "6"){
					   if (formObj.hire_date.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Date");
				    	   ComSetFocus(formObj.hire_date);
				    	   return;
					   } else if (formObj.sts_evnt_yd_cd.value.trim() == ""){
				    	   ComShowCodeMessage("MST00001", "Yard");
				    	   ComSetFocus(formObj.sts_evnt_yd_cd);
				    	   return;
					   }
					 // mandatory checking onsheet
					   for(var i=0; i <= sheetObj.RowCount(); i++){
						   var cv=sheetObj.GetCellValue(i,"cntr_no");
						   if (cv.trim() == ""){
					    	   ComShowCodeMessage("MST00001", "CNTR No.");
					    	   sheetObj.SelectCell(i, "cntr_no", true);
					    	   return;						   
						   }
					   }
				}
				var vDelCheck=sheetObj.FindCheckedRow("del_chk").split("|");
				for(var x=0 ; x<vDelCheck.length-1 ; x++) {
					if( (sheetObj.GetCellValue(vDelCheck[x], "full_flg") == "F" && sheetObj.GetCellValue(vDelCheck[x], "cnmv_sts_cd") == "TN") || (sheetObj.GetCellValue(vDelCheck[x], "full_flg") == "F" && sheetObj.GetCellValue(vDelCheck[x], "cnmv_sts_cd") == "EN") ){
							ComShowCodeMessage("MST01031");
							return ;
		 			}
				}
				for (var i=1; i <= sheetObj.RowCount(); i++){
				   setsheetRowColorBlack(i);
				   if (sheetObj.GetRowStatus(i) == "R" && !sheetObj.GetRowHidden(i)){
					   sheetObj.SetRowStatus(i,"U");
				   }
				   else if (sheetObj.GetRowHidden(i) && (sheetObj.GetRowStatus(i) == "U" || sheetObj.GetRowStatus(i) == "I")){
					   sheetObj.SetRowStatus(i,"R");
				   }
				}
				if (sheetObj.RowCount()> 0){
					if (stCdVal == "0" || stCdVal == "11"){
                        /*if (!ComShowCodeConfirm("MST02023","Lease out target", "LSO")){
                            return;
                        }
                        if (!ComShowCodeConfirm("MST02024","LSO")){
                               return;
                        }*/
						if (!ComShowCodeConfirm("MST02043","LSO")){
                            return;
                     }
					}
				}
				sheetObjects[1].RemoveAll();
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);				
		    	formObj.f_cmd.value=MULTI;
     	        var sParam=ComGetSaveString(sheetObjects[0]);
     	        sParam += "&" + FormQueryString(formObj);
     	        var sXml=sheetObj.GetSaveData("EES_MST_0024GS.do", sParam);
     	        sheetObjects[1].LoadSaveData(sXml);
     	        ComOpenWait(false);
				var sheetcnt=1;
				var aecnt=0;
				var becnt=0;
				var cecnt=0;
				var decnt=0;
				var eecnt=0;
				var fecnt=0;
				var iecnt=0;
				var uecnt=0;
				var suc=0;
				for (var j=1; j <= sheetObjects[1].RowCount(); j++){
					if (sheetObjects[1].GetCellValue(j, "aeflg") == "E" || sheetObjects[1].GetCellValue(j, "beflg") == "E" || sheetObjects[1].GetCellValue(j, "ceflg") == "E" || sheetObjects[1].GetCellValue(j, "deflg") == "E" || sheetObjects[1].GetCellValue(j, "eeflg") == "E" || sheetObjects[1].GetCellValue(j, "ieflg") == "E" || sheetObjects[1].GetCellValue(j, "ueflg") == "E" || sheetObjects[1].GetCellValue(j, "feflg") == "E"){
						for (var i=1; i <= sheetObj.RowCount(); i++){
							if (sheetObj.GetCellValue(i,"cntr_no") == sheetObjects[1].GetCellValue(j, "cntr_no")){
								if (sheetObjects[1].GetCellValue(j, "aeflg") == "E"){
									sheetObj.SetCellFontColor(i,"cntr_sts_cd","#FF0000");
									aecnt=aecnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "beflg") == "E"){
									sheetObj.SetCellFontColor(i,"crnt_yd_cd","#FF0000");
									becnt=becnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "ceflg") == "E"){
									sheetObj.SetCellFontColor(i,"cnmv_dt","#FF0000");
									sheetObj.SetCellFontColor(i,"cntr_sts_evnt_dt","#FF0000");									
									cecnt=cecnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "deflg") == "E"){
									sheetObj.SetCellFontColor(i,"cnmv_sts_cd","#FF0000");
									decnt=decnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "eeflg") == "E"){
									sheetObj.SetCellFontColor(i,"cnmv_sts_cd","#FF0000");
									eecnt=eecnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "feflg") == "E"){
									sheetObj.SetCellFontColor(i,"cntr_tpsz_cd","#FF0000");
									fecnt=fecnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "ieflg") == "E"){
									setsheetRowColorRed(i);
									iecnt=iecnt + 1;
								}
								if (sheetObjects[1].GetCellValue(j, "ueflg") == "E"){
									setsheetRowColorRed(i);
									uecnt=uecnt + 1;
								}
							}
						}
					}
					else {
						suc=suc + 1;
					}
				}
				var sMsg="";
				if (suc > 0){
					sMsg=ComGetMsg("MST01025", "", "", "");
				}				
				if (iecnt > 0 || uecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02008", "", "", "");
				}
				if (aecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02004", "", "", "");
				}
				if (becnt > 0){
					sMsg=sMsg + ComGetMsg("MST02011", "", "", "");
				}
				if (cecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02012", "", "", "");
				}
				if (decnt > 0){
					sMsg=sMsg + ComGetMsg("MST02013", "", "", "");
				}
				if (fecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02020", "", "", "");
				}
				if (eecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02022", "", "", "");
				}
				if (aecnt > 0 || becnt > 0 || cecnt > 0 || decnt > 0 || fecnt > 0 || eecnt > 0){
					sMsg=sMsg + ComGetMsg("MST02021", "", "", "");
				}
				
				ComShowMessage (sMsg);
			break;
			
            case IBSEARCH_ASYNC02://sheet Combo data
 	 	   		formObj.f_cmd.value=SEARCH02;
 	 	   		var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&eq_knd_cd=U");
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(xml,{Sync:1} );
				   return;
				} 	  	   		
 	  	   		var cols=ComMstXml2ComboString(xml, "code", "code|code_nm", "\t");
 	  	   		sheetObj.SetColProperty("cntr_tpsz_cd", {ComboText:cols[0], ComboCode:cols[0]} );
 	  	   	break;
 	  	   	
            case IBSEARCH01:
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj));
				var chk=sXml.indexOf("ERROR");
				if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				   sheetObj.LoadSearchData(sXml,{Sync:1} );
				   return;
				}
            	formObj.ref_no.value=ComXmlString(sXml, "ref_no");
            	formObj.vndr_seq.value=ComXmlString(sXml, "vndr_seq");
            	formObj.vndr_nm.value=ComXmlString(sXml, "vndr_lgl_eng_nm");
            	formObj.vndr_abbr.value=ComXmlString(sXml, "vndr_abbr_nm");
            	
            	formObj.eff_dt.value=ComXmlString(sXml, "eff_dt");   
            	formObj.exp_dt.value=ComXmlString(sXml, "exp_dt");   
            	
            	var lstmcd=ComXmlString(sXml, "lstm_cd");
            	if (formObj.ref_no.value.length == 0) {
				    formObj.agmt_seq.value="";
		            formObj.ref_no.value="";
	            	formObj.vndr_seq.value="";
	            	formObj.vndr_nm.value="";
	            	formObj.vndr_abbr.value="";
	            	
	            	comboObjects[0].RemoveAll();
				    
					formObj.approval_vol.value="";
					formObj.pick_up_vol.value="";
					formObj.pick_up_due_date.value="";			      
					formObj.f_cmd.value=SEARCH;
					
	            	ComShowCodeMessage("MST01003");
					ComSetFocus(formObj.agmt_seq);
					blurflg=true;
					return;
            	}
            	
      	    	if (formObj.st_cd.value == "1" && lstmcd != "SO"){
      	    		formObj.agmt_seq.value="";
      	    		formObj.ref_no.value="";
      	    		formObj.vndr_seq.value="";
      	    		formObj.vndr_nm.value="";
      	    		formObj.vndr_abbr.value="";
      	    		blurflg=true;
      	    		ComShowCodeMessage("MST01003");
      	    		comboObjects[0].RemoveAll();    			    
    				formObj.approval_vol.value="";
    				formObj.pick_up_vol.value="";
    				formObj.pick_up_due_date.value="";	      	    		
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	}
      	    	if (formObj.st_cd.value == "3" && lstmcd != "MO"){
      	    		formObj.agmt_seq.value="";
      	    		formObj.ref_no.value="";
      	    		formObj.vndr_seq.value="";
      	    		formObj.vndr_nm.value="";
      	    		formObj.vndr_abbr.value="";
      	    		blurflg=true;
      	    		ComShowCodeMessage("MST01003");
      	    		comboObjects[0].RemoveAll();    			    
    				formObj.approval_vol.value="";
    				formObj.pick_up_vol.value="";
    				formObj.pick_up_due_date.value="";	
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	}
      	    	if ((formObj.st_cd.value == "5" || formObj.st_cd.value == "7" || formObj.st_cd.value == "8" ) && (lstmcd != "OW" && lstmcd != "OL" && lstmcd != "LP")){
      	    		formObj.agmt_seq.value="";
      	    		formObj.ref_no.value="";
      	    		formObj.vndr_seq.value="";
      	    		formObj.vndr_nm.value="";
      	    		formObj.vndr_abbr.value="";
      	    		blurflg=true;
      	    		ComShowCodeMessage("MST01003");
      	    		ComSetFocus(formObj.agmt_seq);
      	    		return;
      	    	} 
      	    	
      	    	if (formObj.agmt_seq.value.trim().length > 0){    	
    	    		if(formObj.st_cd.value == "1" ||formObj.st_cd.value == "3") {
    	    			if(approval_no.GetSelectIndex() == -1 || formObj.agmt_seq.value == "") {
    	    				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH03);
                		} 
    	    		}
      	    	}
            break;
            
			case IBSEARCH02 :
				if (formObj.sts_evnt_yd_cd.value != ""){
					formObj.f_cmd.value=SEARCH06;
					var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+"&code="+formObj.sts_evnt_yd_cd.value+"&yd_chk_flg=Y");
					var chk=sXml.indexOf("ERROR");
					if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
					   sheetObj.LoadSearchData(sXml,{Sync:1} );
					   return;
					}
	            	var codestr=ComXmlString(sXml, "code_nm");
	            	if (codestr == ""){
	            		ComShowCodeMessage("MST01019", formObj.sts_evnt_yd_cd.value);
	            		formObj.sts_evnt_yd_cd.value="";
	            		formObj.yd_cd_nm.value="";
	            		ComSetFocus(formObj.sts_evnt_yd_cd);
	            		return;
	            	} else {
	            		formObj.yd_cd_nm.value=codestr;
	            	}
				} else {
					formObj.yd_cd_nm.value="";
				}
            break;         
			case IBSEARCH03 :
				sheetObj.SetWaitImageVisible(0);
			    ComOpenWait(true);
			    
				comboObjects[0].RemoveAll();
			    
				formObj.approval_vol.value="";
				formObj.pick_up_vol.value="";
				formObj.pkup_fm_dt.value="";
				formObj.pick_up_due_date.value="";
				formObj.tpsz_cd.value="";	
				formObj.f_cmd.value=SEARCH;
				formObj.f_cmd.value=SEARCH;
				var xml="";
				xml=sheetObj.GetSearchData("EES_MST_0014GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				var chk=xml.indexOf("ERROR");
				if (xml.indexOf("ERROR") == -1 && xml.indexOf("Error") == -1){
					ComXml2ComboItem(xml, approval_no, "cntr_onh_auth_no", "cntr_onh_auth_no|new_van_tp_cd|cntr_tpsz_cd|onh_qty|pick_qty|pkup_due_dt|cntr_tpsz_cd|pkup_chg_amt|pkup_chg_cr_amt|min_onh_dys|" +
							"lift_on_chg|free_dys|lon_chg|cntr_spec_no");
				} else {
					sheetObj.LoadSearchData(xml,{Sync:0} );
				}
				
				break;
         }
         sheetObj.ShowDebugMsg(false);
     }
     
     
 	/**
 	 *  handling OnPopupClick Event onsheet<br>
 	 * @param sheetObj
 	 * @param Row
 	 * @param Col
 	 */
	function setPopData_Currency(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( aryPopupData.length > 0 ) {
			sheetObj.SetCellValue(Row,Col,aryPopupData[0][2]);
		}
	} 	
	
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
    
    
     function func_calendar(){
      	var formObj=document.form; 
        if (formObj.hire_date.readOnly == false){    	 
  	       var cal=new ComCalendar();
  	       cal.select(document.form.hire_date, "yyyy-MM-dd");
        } 
     }
     
     
     /**
     * handling event clicking pop-up button onsheet
     */
    function sheet1_OnPopupClick(sheetObj, Row,Col,Value)
    {
    	 if (sheetObj.ColSaveName(Col) == "cntr_lft_chg_cur"){
    		 var param="cnt_cd=&curr_cd="+sheetObj.GetCellValue(Row,Col)+"&curr_desc=";
        	 ComOpenPopup('/opuscntr/COM_ENS_N13.do?classId=COM_ENS_N13&' + param, 700, 450, 'setPopData_Currency', '0,0,1', true, true, Row, "cntr_lft_chg_cur", 1);
    	 }
         if (sheetObj.ColSaveName(Col) != "cnmv_dt" &&
        	 sheetObj.ColSaveName(Col) != "cntr_sts_evnt_dt" &&
        	 sheetObj.ColSaveName(Col) != "offh_due_dt") return;
         var cal=new ComCalendarGrid("myCal");
         cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
    }     
    
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
    	var formObj=document.form;
 		if(sheetObj.RowCount()> 0){	        
	        
 			for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++){
 				if( (sheetObj.GetCellValue(i, "full_flg") == "F" && sheetObj.GetCellValue(i, "cnmv_sts_cd") == "TN") || (sheetObj.GetCellValue(i, "full_flg") == "F" && sheetObj.GetCellValue(i, "cnmv_sts_cd") == "EN") ){
					sheetObj.SetCellBackColor(i, "full_flg","#FF0000");
					sheetObj.SetCellBackColor(i, "cnmv_sts_cd","#FF0000");
				}
 	 		}
 			setFieldOfStatusCode(document.form.st_cd.value);
		}
	 }
    
    
  	/**
  	 * handling Currency Pop-up Return Value<br>
  	 * @param {arry} Return value array of returned Values Pop-up screen
  	 * @param  Row index
  	 * @param Col index
  	 * @paramsheet Array index
  	 */
  	function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
  	    var formObj=document.form;
  	    var sheetObj=sheetObjects[0];
  	    if ( aryPopupData.length > 0 ) {
  	    	if (formObj.st_cd.value == "1" && aryPopupData[0][7] != "SO"){
  	    		formObj.agmt_seq.value="";
  	    		formObj.ref_no.value="";
  	    		formObj.vndr_seq.value="";
  	    		formObj.vndr_nm.value="";
  	    		formObj.vndr_abbr.value="";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	    	if (formObj.st_cd.value == "3" && aryPopupData[0][7] != "MO"){
  	    		formObj.agmt_seq.value="";
  	    		formObj.ref_no.value="";
  	    		formObj.vndr_seq.value="";
  	    		formObj.vndr_nm.value="";
  	    		formObj.vndr_abbr.value="";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	    	if ((formObj.st_cd.value == "5" || formObj.st_cd.value == "7" || formObj.st_cd.value == "8" || formObj.st_cd.value == "9" || formObj.st_cd.value == "10") && (aryPopupData[0][7] != "OW" && aryPopupData[0][7] != "OL" && aryPopupData[0][7] != "LP")){
  	    		formObj.agmt_seq.value="";
  	    		formObj.ref_no.value="";
  	    		formObj.vndr_seq.value="";
  	    		formObj.vndr_nm.value="";
  	    		formObj.vndr_abbr.value="";  	    		
  	    		ComShowCodeMessage("MST01003");
  	    		ComSetFocus(formObj.agmt_seq);
  	    		return;
  	    	}
  	        ComSetObjValue(formObj.agmt_cty_cd, aryPopupData[0][4]);
  	        ComSetObjValue(formObj.agmt_seq, aryPopupData[0][5]);
  	        ComSetObjValue(formObj.ref_no,   aryPopupData[0][6]);
  	        ComSetObjValue(formObj.vndr_seq, aryPopupData[0][8]);
  	        ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][9]);
  	        ComSetObjValue(formObj.vndr_abbr,  aryPopupData[0][14]);
  	        
  	        ComSetObjValue(formObj.eff_dt,  aryPopupData[0][10]);
  	        ComSetObjValue(formObj.exp_dt,  aryPopupData[0][11]);
  	    }    
  	}
  	
  	/*
	* handling event approval_no OnChange 
	*/
	//function approval_no_OnChange(comboObj,Index_Code, Text){
	function approval_no_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){
		newindex = parseInt(newindex, 10);
		var formObj=document.form;
		var strPickUpPeriod               = comboObj.GetText(newindex,5).split("~");
		formObj.pkup_fm_dt.value          = strPickUpPeriod[0]; 
		formObj.pick_up_due_date.value    = strPickUpPeriod[1];
		formObj.tpsz_cd.value          =comboObj.GetText(newindex,2).trim();
		formObj.approval_vol.value=comboObj.GetText(newindex,3).trim(); 
		formObj.pick_up_vol.value=comboObj.GetText(newindex,4).trim(); 
	}	
  	
  	
  	//control screen field andsheet field according status code
  	function setFieldOfStatusCode(code){
  	var formObj=document.form;
       var sheetObj=sheetObjects[0];
       switch(code) {
		    case "0": //LSO
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input";
		       document.getElementById("agmt_seq").className="input";
		       formObj.agmt_cty_cd.readOnly=false;
		       formObj.agmt_seq.readOnly=false;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   sheetObj.SetCellEditable(i, "cntr_no",0);
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",1);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",1);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i,"rntl_chg_free_dys","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetCellValue(i,"cntr_pkup_chg_amt","");
				   sheetObj.SetCellValue(i,"cntr_pkup_cr_chg_amt","");
				   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
				   if (sheetObj.GetCellValue(i,"cntr_lft_chg_amt") != "" && eval(sheetObj.GetCellValue(i,"cntr_lft_chg_amt")) != 0){
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   }
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
			   }
	 		   ComBtnDisable("btn_add");
	 		   ComBtnDisable("btn_loadexcel");
	 		   document.getElementById("auth_display").style.display="none";
	 		   comboObjects[0].SetBackColor("#FFFFFF");
	 		   comboObjects[0].SetDisabledBackColor("#FFFFFF");
			break;
			
			case "1": //SBO
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input1";
		       document.getElementById("agmt_seq").className="input1";
		       formObj.agmt_cty_cd.readOnly=false;
		       formObj.agmt_seq.readOnly=false;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   //sheetObj.CellEditable(i, "cntr_no")              = true;
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i,"cntr_drff_amt","");
				   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   
			   document.getElementById("auth_display").style.display="";
			   comboObjects[0].SetBackColor("#D4F6FF");
			   comboObjects[0].SetDisabledBackColor("#D4F6FF");
			break;
			case "2": //SBI
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input2";
		       document.getElementById("agmt_seq").className="input2";
		       formObj.agmt_cty_cd.value="";
		       formObj.agmt_seq.value="";
		       formObj.agmt_cty_cd.readOnly=true;
		       formObj.agmt_seq.readOnly=true;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   //sheetObj.CellEditable(i, "cntr_no")              = true;
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   if (sheetObj.GetCellValue(i,"cntr_lft_chg_amt") != "") {
					   if (eval(sheetObj.GetCellValue(i,"cntr_lft_chg_amt")) != 0){
						   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
						   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
					   }
				   }
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   document.getElementById("auth_display").style.display="none";
			   comboObjects[0].SetBackColor("#FFFFFF");
			   comboObjects[0].SetDisabledBackColor("#FFFFFF");
			break;
			case "3": //MUO
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input1";
		       document.getElementById("agmt_seq").className="input1";
		       formObj.agmt_cty_cd.readOnly=false;
		       formObj.agmt_seq.readOnly=false;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i,"cntr_drff_amt","");
				   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   document.getElementById("auth_display").style.display="";
			   
			   comboObjects[0].SetBackColor("#D4F6FF");
			   comboObjects[0].SetDisabledBackColor("#D4F6FF");
			break;			
			case "4": //MUI
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input2";
		       document.getElementById("agmt_seq").className="input2";
		       formObj.agmt_cty_cd.value="";
		       formObj.agmt_seq.value="";
		       formObj.agmt_cty_cd.readOnly=true;
		       formObj.agmt_seq.readOnly=true;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",1);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i, "rntl_chg_free_dys","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetCellValue(i, "cntr_pkup_chg_amt","");
				   sheetObj.SetCellValue(i, "cntr_pkup_cr_chg_amt","");
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
			   }		       
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   document.getElementById("auth_display").style.display="none";
			   comboObjects[0].SetBackColor("#FFFFFF");
			   comboObjects[0].SetDisabledBackColor("#FFFFFF");
			break;
			case "5": //SRO
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input1";
		       document.getElementById("agmt_seq").className="input1";
		       formObj.agmt_cty_cd.readOnly=false;
		       formObj.agmt_seq.readOnly=false;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i,"cntr_drff_amt","");
				   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
			   }
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   document.getElementById("auth_display").style.display="none";
			   comboObjects[0].SetBackColor("#FFFFFF");
			   comboObjects[0].SetDisabledBackColor("#FFFFFF");
			break;	
			case "6": //SRI
		       document.getElementById("hire_date").className="input1";
		       document.getElementById("sts_evnt_yd_cd").className="input1";
		       document.getElementById("agmt_cty_cd").className="input2";
		       document.getElementById("agmt_seq").className="input2";
		       formObj.agmt_cty_cd.value="";
		       formObj.agmt_seq.value="";
		       formObj.agmt_cty_cd.readOnly=true;
		       formObj.agmt_seq.readOnly=true;
		       formObj.agmt_cty_cd.value="HHO";
			   for(var i=1; i <= sheetObj.RowCount(); i++){
				   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
				   sheetObj.SetCellEditable(i, "offh_due_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
				   sheetObj.SetCellEditable(i, "lstm_cd",0);
				   sheetObj.SetCellEditable(i, "agmt_no",0);
				   sheetObj.SetCellEditable(i, "ref_no",0);
				   sheetObj.SetCellEditable(i, "vndr_seq",0);
				   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
				   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
				   sheetObj.SetCellEditable(i, "full_flg",0);
				   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
				   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
				   sheetObj.SetCellEditable(i, "cnmv_dt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
				   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
				   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
				   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
				   sheetObj.SetCellEditable(i, "cntr_rmk",1);
				   sheetObj.SetCellValue(i, "rntl_chg_free_dys","");
				   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
				   sheetObj.SetCellValue(i, "cntr_pkup_chg_amt","");
				   sheetObj.SetCellValue(i, "cntr_pkup_cr_chg_amt","");
				   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
				   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
			   }		       
			   ComBtnEnable("btn_add");
			   ComBtnEnable("btn_loadexcel");
			   document.getElementById("auth_display").style.display="none";
			   comboObjects[0].SetBackColor("#FFFFFF");
			   comboObjects[0].SetDisabledBackColor("#FFFFFF");
			break;
			case "7": //DON
			       document.getElementById("hire_date").className="input1";
			       document.getElementById("sts_evnt_yd_cd").className="input1";
			       document.getElementById("agmt_cty_cd").className="input1";
			       document.getElementById("agmt_seq").className="input1";
			       formObj.agmt_cty_cd.readOnly=false;
			       formObj.agmt_seq.readOnly=false;
			       formObj.agmt_cty_cd.value="HHO";
				   for(var i=1; i <= sheetObj.RowCount(); i++){
					   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
					   sheetObj.SetCellEditable(i, "offh_due_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
					   sheetObj.SetCellEditable(i, "lstm_cd",0);
					   sheetObj.SetCellEditable(i, "agmt_no",0);
					   sheetObj.SetCellEditable(i, "ref_no",0);
					   sheetObj.SetCellEditable(i, "vndr_seq",0);
					   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
					   sheetObj.SetCellEditable(i, "full_flg",0);
					   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
					   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
					   sheetObj.SetCellEditable(i, "cnmv_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
					   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_rmk",1);
					   sheetObj.SetCellValue(i,"cntr_drff_amt","");
					   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
					   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
					   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				   }
				   ComBtnEnable("btn_add");
				   ComBtnEnable("btn_loadexcel");
				   document.getElementById("auth_display").style.display="none";
				   comboObjects[0].SetBackColor("#FFFFFF");
				   comboObjects[0].SetDisabledBackColor("#FFFFFF");
				break;
			case "8": //SCR
			       document.getElementById("hire_date").className="input1";
			       document.getElementById("sts_evnt_yd_cd").className="input1";
			       document.getElementById("agmt_cty_cd").className="input1";
			       document.getElementById("agmt_seq").className="input1";
			       formObj.agmt_cty_cd.readOnly=false;
			       formObj.agmt_seq.readOnly=false;
			       formObj.agmt_cty_cd.value="HHO";
				   for(var i=1; i <= sheetObj.RowCount(); i++){
					   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
					   sheetObj.SetCellEditable(i, "offh_due_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
					   sheetObj.SetCellEditable(i, "lstm_cd",0);
					   sheetObj.SetCellEditable(i, "agmt_no",0);
					   sheetObj.SetCellEditable(i, "ref_no",0);
					   sheetObj.SetCellEditable(i, "vndr_seq",0);
					   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
					   sheetObj.SetCellEditable(i, "full_flg",0);
					   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
					   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
					   sheetObj.SetCellEditable(i, "cnmv_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
					   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_rmk",1);
					   sheetObj.SetCellValue(i,"cntr_drff_amt","");
					   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
					   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
					   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				   }
				   ComBtnEnable("btn_add");
				   ComBtnEnable("btn_loadexcel");
				   document.getElementById("auth_display").style.display="none";
				   comboObjects[0].SetBackColor("#FFFFFF");
				   comboObjects[0].SetDisabledBackColor("#FFFFFF");
				break;
			case "9": //SRO
			       document.getElementById("hire_date").className="input1";
			       document.getElementById("sts_evnt_yd_cd").className="input1";
			       document.getElementById("agmt_cty_cd").className="input2";
			       document.getElementById("agmt_seq").className="input";
			       formObj.agmt_cty_cd.readOnly=false;
			       formObj.agmt_seq.readOnly="";
			       formObj.agmt_cty_cd.value="HHO";
				   for(var i=1; i <= sheetObj.RowCount(); i++){
					   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
					   sheetObj.SetCellEditable(i, "offh_due_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
					   sheetObj.SetCellEditable(i, "lstm_cd",0);
					   sheetObj.SetCellEditable(i, "agmt_no",0);
					   sheetObj.SetCellEditable(i, "ref_no",0);
					   sheetObj.SetCellEditable(i, "vndr_seq",0);
					   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
					   sheetObj.SetCellEditable(i, "full_flg",0);
					   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
					   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
					   sheetObj.SetCellEditable(i, "cnmv_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
					   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_rmk",1);
					   sheetObj.SetCellValue(i,"cntr_drff_amt","");
					   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
					   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
					   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				   }
				   ComBtnEnable("btn_add");
				   ComBtnEnable("btn_loadexcel");
				   document.getElementById("auth_display").style.display="none";
				   comboObjects[0].SetBackColor("#FFFFFF");
				   comboObjects[0].SetDisabledBackColor("#FFFFFF");
				break;
			case "10": //TLL
			       document.getElementById("hire_date").className="input1";
			       document.getElementById("sts_evnt_yd_cd").className="input1";
			       document.getElementById("agmt_cty_cd").className="input2";
			       document.getElementById("agmt_seq").className="input";
			       formObj.agmt_cty_cd.readOnly="";
			       formObj.agmt_seq.readOnly="";
			       formObj.agmt_cty_cd.value="HHO";
				   for(var i=1; i <= sheetObj.RowCount(); i++){
					   sheetObj.SetCellEditable(i, "offh_sts_cd",0);
					   sheetObj.SetCellEditable(i, "offh_due_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_tpsz_cd",0);
					   sheetObj.SetCellEditable(i, "lstm_cd",0);
					   sheetObj.SetCellEditable(i, "agmt_no",0);
					   sheetObj.SetCellEditable(i, "ref_no",0);
					   sheetObj.SetCellEditable(i, "vndr_seq",0);
					   sheetObj.SetCellEditable(i, "vndr_lgl_eng_nm",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_cd",0);
					   sheetObj.SetCellEditable(i, "cntr_sts_evnt_dt",0);
					   sheetObj.SetCellEditable(i, "full_flg",0);
					   sheetObj.SetCellEditable(i, "cnmv_sts_cd",0);
					   sheetObj.SetCellEditable(i, "crnt_yd_cd",0);
					   sheetObj.SetCellEditable(i, "cnmv_dt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_cur",0);
					   sheetObj.SetCellEditable(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetCellEditable(i, "rntl_chg_free_dys",0);
					   sheetObj.SetCellEditable(i, "cntr_old_van_flg",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetCellEditable(i, "cntr_rmk",1);
					   sheetObj.SetCellValue(i,"cntr_drff_amt","");
					   sheetObj.SetCellValue(i,"cntr_drff_cr_amt","");
					   sheetObj.SetCellValue(i,"cntr_old_van_flg","");
					   sheetObj.SetMinimumValue(i, "cntr_drff_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_drff_cr_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "cntr_lft_chg_amt",0);
					   sheetObj.SetMinimumValue(i, "rntl_chg_free_dys",0);
				   }
				   ComBtnEnable("btn_add");
				   ComBtnEnable("btn_loadexcel");
				   document.getElementById("auth_display").style.display="none";
				   comboObjects[0].SetBackColor("#FFFFFF");
				   comboObjects[0].SetDisabledBackColor("#FFFFFF");
				break;
		    case "11": //LSO Direct
			       document.getElementById("hire_date").className = "input1";
			       document.getElementById("sts_evnt_yd_cd").className = "input1";
			       document.getElementById("agmt_cty_cd").className = "input";
			       document.getElementById("agmt_seq").className = "input";
			       formObj.agmt_cty_cd.readOnly = false;
			       formObj.agmt_seq.readOnly = false;
			       //formObj.agmt_cty_cd.value = "";

				   for(var i = 1; i <= sheetObj.RowCount; i++){
					   sheetObj.CellEditable(i, "cntr_no",1);
					   sheetObj.CellEditable(i, "offh_sts_cd",0);
					   sheetObj.CellEditable(i, "offh_due_dt",0);
					   sheetObj.CellEditable(i, "cntr_tpsz_cd",0);
					   sheetObj.CellEditable(i, "lstm_cd",0);
					   sheetObj.CellEditable(i, "agmt_no",0);
					   sheetObj.CellEditable(i, "ref_no",0);
					   sheetObj.CellEditable(i, "vndr_seq",0);
					   sheetObj.CellEditable(i, "vndr_lgl_eng_nm",0);
					   sheetObj.CellEditable(i, "cntr_sts_cd",0);
					   sheetObj.CellEditable(i, "cntr_sts_evnt_dt",0);
					   sheetObj.CellEditable(i, "full_flg",0);
					   sheetObj.CellEditable(i, "cnmv_sts_cd",0);
					   sheetObj.CellEditable(i, "crnt_yd_cd",0);
					   sheetObj.CellEditable(i, "cnmv_dt",0);
					   sheetObj.CellEditable(i, "cntr_drff_amt",1);
					   sheetObj.CellEditable(i, "cntr_drff_cr_amt",1);
					   sheetObj.CellEditable(i, "cntr_lft_chg_cur",1);
					   sheetObj.CellEditable(i, "cntr_lft_chg_amt",1);
					   sheetObj.CellEditable(i, "rntl_chg_free_dys",0);
					   sheetObj.CellEditable(i, "cntr_old_van_flg",0);
					   sheetObj.CellEditable(i, "cntr_pkup_chg_amt",0);
					   sheetObj.CellEditable(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.CellEditable(i, "cntr_rmk",1);
					   
					   sheetObj.CellValue(i,"rntl_chg_free_dys","");
					   sheetObj.CellValue(i,"cntr_old_van_flg","");
					   sheetObj.CellValue(i,"cntr_pkup_chg_amt","");
					   sheetObj.CellValue(i,"cntr_pkup_cr_chg_amt","");
					   sheetObj.CellValue(i,"cntr_drff_cr_amt","");			   
					   
					   if (sheetObj.CellValue(i,"cntr_lft_chg_amt") != "" && eval(sheetObj.CellValue(i,"cntr_lft_chg_amt")) != 0){
						   sheetObj.CellEditable(i, "cntr_lft_chg_amt",0);
						   sheetObj.CellEditable(i, "cntr_lft_chg_cur",0);
					   }
					   
					   sheetObj.MinimumValue(i, "cntr_drff_amt",0);
					   sheetObj.MinimumValue(i, "cntr_drff_cr_amt",0);
					   sheetObj.MinimumValue(i, "cntr_pkup_chg_amt",0);
					   sheetObj.MinimumValue(i, "cntr_pkup_cr_chg_amt",0);
					   sheetObj.MinimumValue(i, "cntr_lft_chg_amt",0);
				   }
				   ComBtnEnable("btn_add");
				   ComBtnEnable("btn_loadexcel");
				   document.getElementById("auth_display").style.display="none";
				   comboObjects[0].SetBackColor("#FFFFFF");
				   comboObjects[0].SetDisabledBackColor("#FFFFFF");
				break;				
	     } //end switch
  	}
  	
  	
	function ComRowHide(sheetObj, col, isMsg) {
   	    if (isMsg==undefined || isMsg==null) isMsg=true;
		var org_col=col;
		//in case of not coumn Index, getting column Index
		col=ComIsNumber(col)?ComParseInt(col):sheetObj.SaveNameCol(col);
		//checking column effectiveness
		if (col< 0 || col > sheetObj.LastCol()) {
			ComShowMessage("[ComRowHideDelete] '" + sheetObj.id + "'의 '" + org_col + "' column doesn't exist");
			return -1;
		}
		//getting checked row to string. ex : "1|3|5|"
		var sRow=sheetObj.FindCheckedRow(col);
		if (sRow == "") {
			if(isMsg) ComShowCodeMessage("COM12189");
			return 0;
		}
		//make array with goten string
		var arrRow=sRow.split("|"); 
		sheetObj.SetRenderSheetSum(0);//not calculating total
		//in case of column DataType = dtDelCheck, hidding. not dtDelCheck hidding and chaging transaction
		if (sheetObj.GetCellProperty(0, col, "dpDataType") == dtDelCheck) {
			//hadling removing descending
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row=arrRow[idx];
				sheetObj.SetRowHidden(row,1);//2.hidding row
			}
		} else {
			//hadling removing descending
			for (var idx=arrRow.length-2; idx>=0; idx--){
				var row=arrRow[idx];
				sheetObj.SetCellValue(row, col,0,0);//1.unchecking
				sheetObj.SetRowHidden(row,1);//2.hidding row
			}
		}
		sheetObj.SetRenderSheetSum(1);//calculating total
		return arrRow.length-1;
	}
	
	
	/**
	 * handling event when changing Sheet.<br>
	 * @param SheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 */
	function sheet1_OnAfterEdit(SheetObj, Row, Col) {
		var formObj=document.form;
		with(SheetObj) {
			var sName=ColSaveName(Col);
			switch(sName) {
				case "cntr_drff_amt":
					if((SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true ||SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true) && SheetObj.GetCellValue(Row,"cntr_drff_amt") > 0){
			            SetCellValue(Row,"cntr_drff_cr_amt",0);
			       	}
					break;
				case "cntr_drff_cr_amt":
					if((SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true || SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true) && SheetObj.GetCellValue(Row,"cntr_drff_cr_amt") > 0){
			       	    SheetObj.SetCellValue(Row,"cntr_drff_amt",0);
			       	} 
					break;
				case "cntr_pkup_chg_amt":
					if((SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true || SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true) && SheetObj.GetCellValue(Row,"cntr_pkup_chg_amt") > 0){
			        	SheetObj.SetCellValue(Row,"cntr_pkup_cr_chg_amt",0);
					}      
					break;
				case "cntr_pkup_cr_chg_amt":
					if((SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||  SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true) && SheetObj.GetCellValue(Row,"cntr_pkup_cr_chg_amt") > 0){
			            SetCellValue(Row,"cntr_pkup_chg_amt",0);
			        }    
					break;
			}
 		}
	}
	
    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
    	var formObj=document.form;
    	var sName=SheetObj.ColSaveName(Col);
     	 var celltxt=SheetObj.GetEditText();
     	 var celltxt1=SheetObj.GetCellValue(Row, "cntr_no");
       	 if (celltxt == "" && celltxt1 != ""){
       		 celltxt=celltxt1;
       	 } 
        if (sName == "cntr_drff_amt"){
           if (SheetObj.GetCellEditable(Row,"cntr_drff_amt") == false)
        		return;         	
       	   if(SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true ||SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true){
        	  //if (KeyCode != 9)
         	    // SheetObj.SetCellValue(Row,"cntr_drff_cr_amt",0);
       	   }
        }
        else if (sName == "cntr_drff_cr_amt"){
           if (SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == false)
        		return;          	
       	   if(SheetObj.GetCellEditable(Row,"cntr_drff_cr_amt") == true || SheetObj.GetCellEditable(Row,"cntr_drff_amt") == true){
       		 // if (KeyCode != 9)
       	         //SheetObj.SetCellValue(Row,"cntr_drff_amt",0);
       	   }
        }
        else if (sName == "cntr_pkup_chg_amt"){
        	if (SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == false)
        		return;        	
        	if(SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true || SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true){
        	   //if (KeyCode != 9)
        	     // SheetObj.SetCellValue(Row,"cntr_pkup_cr_chg_amt",0);
        	}        	
        }
        else if (sName == "cntr_pkup_cr_chg_amt"){
        	if (SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == false)
        		return;
        	if(SheetObj.GetCellEditable(Row,"cntr_pkup_cr_chg_amt") == true ||  SheetObj.GetCellEditable(Row,"cntr_pkup_chg_amt") == true){
               //if (KeyCode != 9)
                 // SheetObj.SetCellValue(Row,"cntr_pkup_chg_amt",0);
            }        	
        }
        else if (sName == "cntr_no" && (celltxt.length == 11 || KeyCode == 13)){
        	SheetObj.SetCellValue(Row,"cntr_no",celltxt.toUpperCase(),0);
			if (formObj.st_cd.value == "") {
				ComShowCodeMessage("MST00001", "Status Code");
				ComSetFocus(formObj.st_cd);
				return;
			} 
			if (formObj.hire_date.value == "") {
				ComShowCodeMessage("MST00001", "Date");
				ComSetFocus(formObj.hire_date);
				return;
			}
			if (formObj.sts_evnt_yd_cd.value == "") {
				ComShowCodeMessage("MST00001", "Yard");
				ComSetFocus(formObj.sts_evnt_yd_cd);
				return;
			}
			if (formObj.st_cd.value == "1" || formObj.st_cd.value == "3" || formObj.st_cd.value == "5" || formObj.st_cd.value == "7" || formObj.st_cd.value == "8" ) {
				if (formObj.agmt_cty_cd.value == "" || formObj.agmt_seq.value == ""){
					ComShowCodeMessage("MST00001", "AGMT No.");
					ComSetFocus(formObj.agmt_seq);
					return;
				}
			}
			if ((formObj.st_cd.value == "0" && formObj.agmt_seq.value.trim().length > 0)  || formObj.st_cd.value == "1" || formObj.st_cd.value == "3" || formObj.st_cd.value == "5" || formObj.st_cd.value == "7" || formObj.st_cd.value == "8" || (formObj.st_cd.value == "11" && formObj.agmt_seq.value.trim().length > 0)) {
			   doActionIBSheet(SheetObj,formObj,IBSEARCH01);
			}        	
        	doActionIBSheet(SheetObj,formObj,IBSEARCH);
        }
    }
    
    
    function setSearchField(gubun){
    	var formObj=document.form;
    	if (gubun == '0'){
	    	formObj.st_cd.disabled=true;
	    	formObj.hire_date.readOnly=true;
	    	formObj.sts_evnt_yd_cd.readOnly=true;
	        formObj.agmt_cty_cd.readOnly=true;
	        formObj.agmt_seq.readOnly=true;
    	} else {
	    	formObj.st_cd.disabled=false;
	    	formObj.hire_date.readOnly=false;
	    	formObj.sts_evnt_yd_cd.readOnly=false;
	        formObj.agmt_cty_cd.readOnly=false;
	        formObj.agmt_seq.readOnly=false;    		
    	}
    }
    
    
    function setsheetRowColorBlack(cnt){
   	 	 var formObj=document.form;
	   	 for (var i=1; i <= 25; i++){
	   		 sheetObjects[0].SetCellFontColor(cnt,i,"#000000");
	   	 }
    }
    
    
    function setsheetRowColorRed(cnt){
	   	 var formObj=document.form;
	   	 for (var i=1; i <= 25; i++){
	   		 sheetObjects[0].SetCellFontColor(cnt,i,"#FF0000");
	   	 }
    }  
    
    
    function resizeSheet(){
 	    ComResizeSheet(sheetObjects[0]);
 	   ComResizeSheet(sheetObjects[1]);
 	}