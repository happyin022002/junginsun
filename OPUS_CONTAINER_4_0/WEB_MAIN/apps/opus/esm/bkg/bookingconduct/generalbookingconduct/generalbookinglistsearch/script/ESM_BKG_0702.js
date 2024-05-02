/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0702.js
*@FileTitle  : Booking Receipt Draft BL EDI 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BKG_0702 : business script for ESM_BKG_0702
     */
    function ESM_BKG_0702() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1; 
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId;
var intervalTime=3000;
var processCnt=0;
var layList = null;

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
         
         if(layList == undefined || layList == null) layList = document.getElementById("layList");
         
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
            case "btn_multBkgNo":	
				
				if($("#btn_multBkgNo").is(":disabled")) return;
				var stop = $("#bkg_no").offset().top;
			    var sleft = $("#bkg_no").offset().left;
			    layList.style.left = sleft + "px";
			    layList.style.top = (stop+25) + "px";
			    
				if($("#layList").is(":visible") == false){
					$("#layList").show();
				}else{
					$("#layList").hide();
				}
				
			break;
			case "btn_SendtoCustomer":
				if (!$('#btn_SendtoCustomer').prop("disabled")) {
					if(!validateForm(sheetObjects[0],formObject,"btn_SendtoCustomer")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],document.form,"btn_SendtoCustomer");
				}
				break;
			case "btn_SendtoTerminal":
				if (!$('#btn_SendtoTerminal').prop("disabled")) {
					if(!validateForm(sheetObjects[0],formObject,"btn_SendtoTerminal")) {
						return false;
					}
					doActionIBSheet(sheetObjects[0],document.form,"btn_SendtoTerminal");
				}
				break;
			case "btn_Retrieve":
//				ComAddSeparator(formObject.bkg_from_dt);
//				ComAddSeparator(formObject.bkg_to_dt);
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				ComClearObject(formObject.bkg_from_dt);
				ComClearObject(formObject.bkg_to_dt);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
			break;
			case "btns_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
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
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	jqueryEvent();
    }
     /**
      * setting sheet initial values and header
      * @param sheetObj
      * @param sheetNo
      * @return
      */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
		   case 1:      //sheet1 init
			   with(sheetObj){
			   (23, 0, 0, true);
			   var HeadTitle1="|Sel.|Seq.|Booking No.|B/L No.|Customer Code|Name|Group EDI ID|EDI Ref|EDI Receive|Receiver Name|VVD|POR|POL|POD|DEL|Sent Time|Sent ID|Sent Status|ACK|Sent Nm||";
			
			   SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0 } );
			
			   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			   InitHeaders(headers, info);
			
			   var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			{Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"slct_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cust_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"group_edi_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"edi_ref",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rcv_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:200,  Align:"Left",    ColMerge:0,   SaveName:"receiver_name",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sent_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"sent_status",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ack",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"snd_usr_nm" },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"group_id" },
			{Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ref_code" } ];
			    
			   InitColumns(cols);
			   SetEditable(1);
			   SetShowButtonImage(2);
			   sheetObj.FrozenCols=5;
			   SetSheetHeight(360);
			   }
	    break;
		}
    }
  // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
		case IBCLEAR:      //initializing
			ComClearObject(formObj.bkg_from_dt);
			ComClearObject(formObj.bkg_to_dt);
			ComClearObject(formObj.vvd);
			ComClearObject(formObj.pol_cd);
			ComClearObject(formObj.pod_cd);
			ComClearObject(formObj.del_cd);
			ComClearObject(formObj.bkg_ofc_cd);
			ComClearObject(formObj.bkg_stf_cd);
			ComClearObject(formObj.sls_ofc_cd);
			ComClearObject(formObj.sales_rep);
			ComClearObject(formObj.bl_ofc_cd);
			ComClearObject(formObj.bkg_no);
			ComClearObject(formObj.bl_no);
			ComClearObject(formObj.sc_no);
			ComClearObject(formObj.cust_cnt_cd);  
			ComClearObject(formObj.cust_seq);
			ComClearObject(formObj.cust_nm);
			ComClearObject(formObj.edi_receive_nm);
			if(ComGetObjValue(formObj.pgm_no)=="ESM_BKG_0702-1"){
				formObj.type_gbn[0].checked=true;
			} else {
				formObj.type_gbn[1].checked=true;
			}
			/*formObj.bkg_from_dt.value=ComGetNowInfo();
			formObj.bkg_to_dt.value=ComGetNowInfo();*/
			formObj.cust_tp_cd.selectedIndex=0;
			sheetObj.RemoveAll();
			checkType()
		break;
        case IBSEARCH:      //retrieve
			if($('#rows').css("color").indexOf('255') > 0){
				ComShowMessage('You can input Booking No up to 100 Maximum. Please kindly check Booking No again.');
				$("#layList").show();
				return false;
			}else if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			
			$("#layList").hide();
			
	  		sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);       			
        	formObj.f_cmd.value=SEARCH;
        	var sXml=sheetObj.GetSearchData("ESM_BKG_0702GS.do", FormQueryString(formObj));
			ComOpenWait(false);       			
	       	var arrXml=sXml.split("|$$|");
	       	for(var i=0; i < arrXml.length; i++){ 
	       		sheetObjects[i].RenderSheet(0);
	       		if(i > 0) {
     				sheetObjects[i].SetWaitImageVisible(0);
	       		}  
	       		sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
	       		sheetObjects[i].RenderSheet(1);
	       	}
			formObj.total.value=ComAddComma(ComGetEtcData(sXml, "total"));
			formObj.success.value=ComAddComma(ComGetEtcData(sXml, "success"));
			formObj.send.value=ComAddComma(ComGetEtcData(sXml, "sending"));
			formObj.unsent.value=ComGetEtcData(sXml, "unSent") + " (No Send : " + ComGetEtcData(sXml, "noSend") + " / Failed : " + ComGetEtcData(sXml, "fail") + ")";
			sheetObjects[0].SetCellFontColor(i, 3,"#0000FF");
			sheetObjects[0].SetCellFontColor(i, 4,"#0000FF");
         break;
		case IBDOWNEXCEL:
			if (sheetObj.RowCount()> 0) {
				sheetObj.Down2Excel({ HiddenColumn:-1});
			} else {
				ComShowMessage(msgs['BKG00155']);
			}
		break;
		case "btn_SendtoCustomer":
//			formObj.f_cmd.value = MULTI;
//			var params = FormQueryString(formObj);
//			params = params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
//			var sXml = sheetObj.GetSaveXml("ESM_BKG_0702GS.do", params);
//			
//			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
//				ComShowCodeMessage("BKG00204");
//				doActionIBSheet(sheetObj, formObj, IBSEARCH);
//			}else{
//				sheetObj.LoadSaveXml(sXml);
//			}
			ComOpenWait(true);
	    	ComSetObjValue(formObj.f_cmd,MULTI);
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0702GS.do", params);
	    	var arrXml=sXml.split("|$$|");
			if (ComGetEtcData(arrXml[0], "jobID")) {
				ComSetObjValue(formObj.key, ComGetEtcData(arrXml[0], "jobID"));
	            intervalId=setInterval(callIntervalBackEndJob, intervalTime);
			} else {  //backendJob ?? ??
				ComOpenWait(false);
			}
		break;
		break;
		case "btn_SendtoTerminal":
			formObj.f_cmd.value=MULTI01;
			var params=FormQueryString(formObj);
			params=params + "&" + ComSetPrifix(sheetObjects[0].GetSaveString(false, true, 1), "sheet1_");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0702GS.do", params);
			if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
				ComShowCodeMessage("BKG00204");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}else{
				sheetObj.LoadSaveData(sXml);
			}	
		break;
    	case SEARCH01: // BackEndJob ?? ??(??)
	    	ComSetObjValue(formObj.f_cmd,SEARCH01);
	    	params=FormQueryString(formObj);
	    	var sXml=sheetObj.GetSearchData("ESM_BKG_0702GS.do", params);
	    	var arrXml=sXml.split("|$$|");
			var jobState=ComGetEtcData(arrXml[0], "jb_sts_flg");
			if ("3"==jobState) {  // BackEndJob ??
				clearInterval(intervalId);
	            doActionIBSheet(sheetObj, document.form, SEARCH02);  // BackEndJob ?? ??
			} else if ("4"==jobState) {  // BackEndJob ??
				clearInterval(intervalId);
				ComOpenWait(false);
				ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ("5"==jobState) {  // ?? BackEndJob ?? ??? ?????.
				clearInterval(intervalId);
				ComOpenWait(false);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
			break;	
    	case SEARCH02: // BackEndJob ?? ??
	    	ComSetObjValue(formObj.f_cmd,SEARCH02);
	    	params=FormQueryString(formObj);
	    	var sXml=sheetObj.GetSearchData("ESM_BKG_0702GS.do", params);
	    	var arrXml=sXml.split("|$$|");
	    	if ("Y"==ComGetEtcData(arrXml[0], "result")) {
	    		clearInterval(intervalId);
				ComOpenWait(false);
				ComShowCodeMessage("BKG00204");
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else if ("N"!=ComGetEtcData(arrXml[0], "result")) {  // BackEndJob 9?30? ??
				ComShowMessage(ComGetEtcData(arrXml[0], "result"));
				ComOpenWait(false);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			} else { // EDI ?? ? Exception ??
				clearInterval(intervalId);
				ComOpenWait(false);
				ComShowCodeMessage("BKG01163");  //Unprocessed data remained, please click \"Send to Customer\" again to complete transmission
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
	    	break;
        }
    }
	function initControl() {
		var formObject=document.form;
		// Axon event handler
//		axon_event.addListenerFormat('keydown',	'obj_keydown', formObject); //- ? ????
//		axon_event.addListenerFormat('keypress', 'obj_keypress', formObject); //- in case of typing keyboard
		axon_event.addListenerForm('beforedeactivate', 'bkg0702_obj_deactivate', formObject); //- focus out
//		axon_event.addListenerFormat('beforeactivate',   'bkg0702_activate', formObject); //- focus in
		axon_event.addListenerForm('blur', 'form1_blur', formObject);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');// Enter key
	}
	 /**
	 * in case of mouse in
	 */
	function bkg0702_activate(){
		//checking input Validation
		switch(event.srcElement.name){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
				break;
			default:
				break;
		}
	}
	function form1_blur(){
		/*if (event.srcElement.name="bkg_stf_cd"){
			return true;
		}
		ComChkObjValid(event.srcElement);*/
	}
//   	function obj_keydown() {
//   		var obj=event.srcElement;
//   		var vKeyCode=event.keyCode;
//   		var formObj=document.form;
//   		if ( vKeyCode == 13 ) {
//   			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
//   		}
//   	}
//	function obj_keypress(){
//		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
//	      var srcName=event.srcElement.getAttribute("name");
//	      var srcValue=event.srcElement.getAttribute("value");
//	    switch(event.srcElement.dataformat){
//	        case "ymd":
//	      	  ComKeyOnlyNumber(event.srcElement);
//	      	  if (srcValue.length == 4) {
//	      		  document.form.elements[srcName].value=srcValue.substring(0,4) + "-"
//	      	  }
//	      	  if (srcValue.length > 4 && srcValue.indexOf('-') < 0) {
//	      		  return;
//	      	  }
//	      	  if (srcValue.length == 7) {
//	      		  document.form.elements[srcName].value=srcValue.substring(0,7) + "-"
//	      	  }
//	            break;
//	    	case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//		        if(keyValue >= 97 && keyValue <= 122) {
//	                event.keyCode=keyValue + 65 - 97;
//	            }
//	            break;
//	        case "engnum":
//    	  	  	ComKeyOnlyAlphabet('num'); 
//	        	break;	      
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "uppernum":
//	        	ComKeyOnlyAlphabet('uppernum');
//	            break;
//	        case "etc": 
//		        if(keyValue >= 97 && keyValue <= 122) {
//	                event.keyCode=keyValue + 65 - 97;
//	            }
//	        	break;
//	        default:
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	}
	function checkType(){
		var formObj=document.form;
		if (formObj.type_gbn[0].checked) {
			ComBtnEnable("btn_SendtoTerminal");
		} else {
			ComBtnDisable("btn_SendtoTerminal");
		}
	}
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	var result=false;
//        with(formObj){
		switch(sAction) {
		case IBSEARCH:
			if( !ComIsNull(formObj.bkg_from_dt) && !ComIsDate(formObj.bkg_from_dt) ) {
				ComShowCodeMessage('COM132201', 'BKG Date');
				ComSetFocus(formObj.bkg_from_dt);
				return false;
			}
			if( !ComIsNull(formObj.bkg_to_dt) && !ComIsDate(formObj.bkg_to_dt) ) {
				ComShowCodeMessage('COM132201', 'BKG Date');
				ComSetFocus(formObj.bkg_to_dt);
				return false;
			}
			
			/* 멀티 부킹 중복 체크 */
			duplicateBkgNoCheck('mult_bkg_no');	
			
			if ( ComIsNull(formObj.bkg_no) && ComIsNull(formObj.mult_bkg_no) && ComIsNull(formObj.bl_no) ) {
				if ( !ComIsNull(formObj.vvd) ) {
					if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj)
						|| checkMendatorySlsOfcCd(formObj) || checkMendatorySalesRep(formObj) || checkMendatoryBlOfcCd(formObj)
						|| checkMendatoryScNo(formObj) || checkMendatoryCust(formObj) || checkMendatoryEdiRcv(formObj)
						|| checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)) {
						result=true;
					} else {
						ComShowCodeMessage('BKG00626', 'Other Value');
						formObj.bkg_ofc_cd.focus();
					}
					return result;
				} else if ( !ComIsNull(formObj.bkg_from_dt) && !ComIsNull(formObj.bkg_to_dt) ) {
					if( checkMendatoryDt(formObj)){
						if ( checkMendatoryPOL(formObj) || checkMendatoryBkgOfcCd(formObj) || checkMendatoryBkgStfCd(formObj)
							|| checkMendatorySlsOfcCd(formObj) || checkMendatorySalesRep(formObj) || checkMendatoryBlOfcCd(formObj)
							|| checkMendatoryScNo(formObj) || checkMendatoryCust(formObj) || checkMendatoryEdiRcv(formObj)
							|| checkMendatoryPOD(formObj) || checkMendatoryDEL(formObj)) {
							result=true;
						} else {
							ComShowCodeMessage('BKG00626', 'Other Value');
							formObj.bkg_ofc_cd.focus();
						}
					}
				} else if ( ComIsNull(formObj.vvd) || ComIsNull(formObj.bkg_from_dt) || ComIsNull(formObj.bkg_to_dt)  || ComIsNull(formObj.bl_no)) {
					ComShowCodeMessage('BKG00626', '\n\n[BKG Date&Other, VVD&Other, BKG NO, BL NO] , One must have value');
					formObj.bkg_from_dt.focus();
				} else return result;
			} else return true;
			break;
		case "btn_SendtoCustomer":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			result=true;
			break;
		case "btn_SendtoTerminal":
			if (sheetObj.RowCount()== 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			if (sheetObj.CheckedRows("slct_flg") == 0) {
				ComShowMessage(msgs['BKG00155']);
				return false;
			}
			result=true;
			break;
		}
//        }
        return result;
    }
	function checkMendatoryDt(formObj) {
		if( ComIsNull(formObj.bkg_from_dt) ) {
			return false;
		}
		if( ComIsNull(formObj.bkg_to_dt) ) {
			return false;
		}
		if (formObj.bkg_from_dt.value != "" && formObj.bkg_to_dt.value != "") {
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) < 0) {
				ComShowMessage(msgs['BKG00112']);
				return false;
			}			
			if (ComGetDaysBetween(formObj.bkg_from_dt,formObj.bkg_to_dt) >= 7){
				ComShowCodeMessage("BKG00756", "Duration", "7 Days");
				return false;
			}
		}
		return true;
	}
	function checkMendatoryVVD(formObj) {
		if( ComIsNull(formObj.vvd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryPOL(formObj) {
		if( ComIsNull(formObj.pol_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryPOD(formObj) {
		if( ComIsNull(formObj.pod_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryDEL(formObj) {
		if( ComIsNull(formObj.del_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryBkgOfcCd(formObj) {
		if( ComIsNull(formObj.bkg_ofc_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryBkgStfCd(formObj) {
		if( ComIsNull(formObj.bkg_stf_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatorySlsOfcCd(formObj) {
		if( ComIsNull(formObj.sls_ofc_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatorySalesRep(formObj) {
		if( ComIsNull(formObj.sales_rep) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryBlOfcCd(formObj) {
		if( ComIsNull(formObj.bl_ofc_cd) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryScNo(formObj) {
		if( ComIsNull(formObj.sc_no) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryCust(formObj) {
		if( ComIsNull(formObj.cust_seq) && ComIsNull(formObj.cust_nm) ) {
			return false;
		}
		return true;
	}
	function checkMendatoryEdiRcv(formObj) {
		if( ComIsNull(formObj.edi_receive_nm) ) {
			return false;
		}
		return true;
	}
	// Event occurring when mouse moves on the sheet
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y)
	{
		with(sheetObj)
		{
			var row=MouseRow();
			var col=MouseCol();
			var colname=ColSaveName(col);
			switch(colname)
			{
				case "SentStatus":
				if ("Failed" == GetCellValue(row, col)){}
				//no support[check again]CLT 						MouseToolTipText="failure reason";
				else
				//no support[check again]CLT 						MouseToolTipText="";
				break;
				default :
				//no support[check again]CLT 						MouseToolTipText="";
			}
		}
	}
	function sheet1_OnDblClick(sheetObj, Row, Col)
	{
		if(Col == 3){
			//freezing modify
			//			ComBkgCall0079(sheetObj.CellValue(Row,Col)); 
			comBkgCallPopBkgDetail(sheetObj.GetCellValue(Row,Col));
		}
		if(Col == 4){
			//ComOpenWindow("/opuscntr/ESM_BKG_0927.do?bkg_no=" + sheetObj.GetCellValue(Row,3)+"&bl_no=" + sheetObj.GetCellValue(Row,Col), "PopupEsmBkg0927", "width=916, height=768, scrollbars=no", false);
			ComOpenWindowCenter2("/opuscntr/ESM_BKG_0927_POP.do?bkg_no=" + sheetObj.GetCellValue(Row,3)+"&bl_no=" + sheetObj.GetCellValue(Row,Col), "BL Preview", 1024,740,false,"scrollbars=yes,resizable=yes");
		}
	} 
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		with(sheetObj)
		{
			SetColFontUnderline("bkg_no",1);
			SetColFontUnderline("bl_no",1);
		}			
	}
    //BackEndJob ?? ??? ?? ??
    function callIntervalBackEndJob() {
    	if (600==processCnt++) {  //intervalTime(3?) * 600=30?
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
        doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
    }

	 /* Multi BKG 기능 추가 함수 START */
        
    function jqueryEvent(){
    	$("#bkg_no").keyup(function(){
    		if($(this).val() != ""){
    			multiBkgTextArea(1, 'mult_bkg_no');
    		}
		});
    	$("#mult_bkg_no").keyup(function(){
    		multiBkgTextArea(2, 'mult_bkg_no');
		});
    }

    /* Multi BKG 기능 추가 함수 END */