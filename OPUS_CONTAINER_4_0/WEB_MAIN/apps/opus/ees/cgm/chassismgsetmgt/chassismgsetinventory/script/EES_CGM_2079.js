/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_2079.js
*@FileTitle  : Inventory by Creation Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_2079 : EES_CGM_2079 business script for
     */
    function EES_CGM_2079() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
   	/* developer job	*/
 // common global variables
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
 var comboObjects=new Array();
 var comboCnt=0;
 var oldCntrTypeSize = "";
 var sCntrTypeSize = "";
 
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
/**
 * Event handler processing by button name <br>
 * @param
 * @return 
 * @author 
 * @version 
 */ 
 function processButtonClick(){
      /***** use additional sheet var in case of more than 2 tap each sheet *****/
      var sheetObject=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
 		if(ComGetBtnDisable(srcName)) return false;
         switch(srcName) {
             case "btn_retrieve":
        		if(validateForm(sheetObject,formObject,IBSEARCH) != false) {
        			doActionIBSheet(sheetObject, formObject, IBSEARCH);
        		}
							break;
             case "btn_new":
            	initControl();
							break;
            case "btn_downexcel":
            	doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                break;
            case "ComOpenPopupWithTargetOffice":
            	ComOpenPopupWithTarget('/opuscntr/COM_ENS_071.do', 800, 510, "ofc_cd:crnt_ofc_cd", "0,1,1,1,1,1,1", true);
            	break;
			case "btns_Calendar2" :		// Agreement Date (To Date)
//				var cal = new ComCalendar();
				var cal=new ComCalendarFromTo();
//	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
	    		cal.select(formObject.inq_fm_dys,  formObject.inq_to_dys,  'yyyy-MM-dd');
// 	    		cal.select(formObject.evnt_dt_end, "yyyy-MM-dd");
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
 /**
 * registering IBSheet Object as list <br>
 * @param  {object} sheet_obj	
 * @return 
 * @author 
 * @version
  */
 function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
 }
 /**
 * initializing sheet <br>
 * implementing onLoad event handler in body tag <br>
 * @param  
 * @return 
 * @author 
 * @version
  */
 function loadPage() {
	var formObj=document.form;
	
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC07);

     for(i=0;i<sheetObjects.length;i++){
    	 //
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         //
         ComEndConfigSheet(sheetObjects[i]);
     }
   	 // axon event regist
//     axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
//     axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
     axon_event.addListener('change', 'obj_change' , 'crnt_ofc_cd');   	
  	 // Multi Combo reset
   	 for(var k=0;k<comboObjects.length;k++){
         initCombo(comboObjects[k]);
     } 
     initControl();
}
  
  /**
   * init control of form <br>
   * @param  
   * @return 
   * @author 
   * @version 
   */
 function initControl(){
  	 var formObj=document.form;
  	 var sheetObj=sheetObjects[0];
  	 // Form Object reset
  	 with(formObj){
  		 crnt_ofc_cd.value="";
         inq_fm_dys.value="";
         inq_to_dys.value="";
  	 }
  	 // MultiCombo reset
  	 for(var i=0; i<comboObjects.length; i++){
  		 comboObjects[i].SetSelectText("",false);
  	 }
  	 // Sheet Object reset
  	 sheetObj.RemoveAll();
	 // init value setting
     }
   /**
  * setting sheet initial values and header <br>
  * adding case as numbers of counting sheets <br>
  * @param  {object} sheetObj		 Sheet Object
  * @param  {int} sheetNo
  * @return 
  * @author 
  * @version 
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
	 var sheetID=sheetObj.id;
     switch(sheetID) {
         case "sheet1":
             with (sheetObj) {

		             var HeadTitle="Office|Total";

		             //making data as list for changing column
						oldCntrTypeSize = sCntrTypeSize;
						var arrCntrTypeSize = "";
						if(oldCntrTypeSize != ""){
							arrCntrTypeSize = oldCntrTypeSize.split("|");
						}
						
						//handling header title by changing column
						if (sCntrTypeSize != "") {
							HeadTitle += "|" + oldCntrTypeSize;
						}
		             
		             var headCount=ComCountHeadTitle(HeadTitle);
		             //(headCount, 0, 0, true);
		
		             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		             var info    = { Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		             var headers = [ { Text:HeadTitle, Align:"Center"} ];
		             InitHeaders(headers, info);
		
		             var cols = [ {Type:"Text",      Hidden:0,  Width:260,  Align:"Center",  ColMerge:0,   SaveName:"sts_evnt_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"AutoSum",   Hidden:0, Width:230,  Align:"Right",   ColMerge:0,   SaveName:"eq_tpsz_cd_total",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
		             
					  var sCount = "";
					  var x = 1;
                      var sumCount = 2;
	                  var sumNmVal = "";
					  
	 	              for ( var i = 0; i < arrCntrTypeSize.length; i++) {
					 	  if (arrCntrTypeSize.length > 1) {
					 		  sCount = "eq_tpsz_cd" + x;
				 			  cols.push({Type:"AutoSum",   Hidden:0, Width:230,  Align:"Right",   ColMerge:0,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
					 		  x++;

					 		  if(i == arrCntrTypeSize.length - 1){
								 sumNmVal += "|"+sumCount;
							  }else if(i == 0){
								 sumNmVal += sumCount;
							  }else{
								 sumNmVal += "|"+sumCount;
									
							  }
							  
					 		  sumCount++;

					 	  }
					  }		             
		             
		             InitColumns(cols);
		
		             SetEditable(1);
		             SetEditableColorDiff(0);
//		             SetSheetHeight(510);
		             
		             sheet1.SetSumText(0, 0, "TOTAL");
		             resizeSheet();
                }
                 break;
         }
     }
	function resizeSheet(){
	    ComResizeSheet(sheetObjects[sheetObjects.length-1]);
	}
/**
 * handling process for Sheet <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type
 * @return 
 * @author 
 * @version
 */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //retrieve
	        // Form Object value setting
	    	formObj.f_cmd.value=SEARCH;
	 		formObj.eq_knd_cd.value=EQ_KND_CD_MGSET;
	 		// retrieve
	 		if(validateForm(sheetObj,formObj,sAction))
	 		{
		 		sheetObj.SetWaitImageVisible(0);
		 		ComOpenWait(true);	 		 			
		 		var sXml=sheetObj.GetSearchData("EES_CGM_2079GS.do" , FormQueryString(formObj));
	 			sheetObj.LoadSearchData(sXml,{Sync:0} );
		 		ComOpenWait(false);	 		 			
	 		}
            break;
        case IBSEARCH_ASYNC02:	// Office Code  Validation check 
		   	formObj.f_cmd.value=COMMAND01;
		   	formObj.ofc_cd.value=formObj.crnt_ofc_cd.value;
		   	var sXml=sheetObj.GetSearchData("CgmValidationGS.do", FormQueryString(formObj));
		   	var sCheckResult=ComGetEtcData(sXml,"checkResult");    	
		   	if(sCheckResult == COM_VALIDATION_FALSE){
		   		ComShowCodeMessage('CGM10009','Office');
		   		formObj.crnt_ofc_cd.value="";
		   		formObj.crnt_ofc_cd.focus();
		   	}
		   	break;
    	case IBSEARCH_ASYNC07:	// Sheet Head retrieve
        	formObj.f_cmd.value = SEARCH21;
    		formObj.eq_knd_cd.value = EQ_KND_CD_MGSET;
			var sXml = sheetObj.GetSearchData("CgmCodeMgtGS.do", FormQueryString(formObj),{Sync:1});
			sCntrTypeSize = ComGetEtcData(sXml,"cntrTypeSize");
			
			//getting changing column information from server
			oldCntrTypeSize = sCntrTypeSize;
			
			break;
        case IBDOWNEXCEL:        //down excel
        	if(sheetObj.RowCount() < 1){//no data
        		ComShowCodeMessage("COM132501");
        		}else{
        			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
        		}
 	   		break; 	
     }
 }
/**
 * handling process for input validation <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {object} formObj	 Form Object
 * @param  {String} sAction	 Action Type (IBSEARCH, IBSEARCH_ASYNC01, RDPRINT, IBDOWNEXCEL)
 * @return {boolean}			false => validation check error, true => validation check succes
 * @author 
 * @version 
 */ 
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		switch(sAction){
			case IBSEARCH:
				/*
				if(crnt_ofc_cd.value == ''){
					ComShowCodeMessage('CGM10004','Office');
					crnt_ofc_cd.focus();
					return false;
				} else {
					return true;
				}*/
				if(inq_fm_dys.value == '')
				{
       				ComShowCodeMessage('CGM10004','Period ');
    				inq_fm_dys.focus();
    				return false;
				}
				if(inq_to_dys.value == '')
				{
       				ComShowCodeMessage('CGM10004','Period ');
    				inq_to_dys.focus();
    				return false;
				}
 		 		if(inq_fm_dys.value != '' && inq_to_dys.value != ''){
	        		var dt_str=ComReplaceStr(document.form.inq_fm_dys.value,"-","");
	     			var dt_end=ComReplaceStr(document.form.inq_to_dys.value,"-","");
	 	    		if(dt_str != '' && dt_end != ''){
	 	    			if(dt_end < dt_str){
	 	    				ComShowCodeMessage('COM12133','To date','From date','greater');
	 	    				inq_fm_dys.value='';
	 	    				inq_fm_dys.focus();
	 	    				return false;
	 	    			}
	 	    		}
 		 		}
 		 		break;
		}
	}
	return true;
}
/**
 * Sheet1  OnSearchEnd event handling <br>
 * @param  {object} sheetObj		 Sheet Object
 * @param  {string} ErrMsg		 String
 * @return 
 * @version 
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg)
{
 	with(sheetObj)
 	{
         with(sheetObj)
         {
             //ShowSubSum(0, "1|2|3", -1, false, false,	-1,"");
         }
 	}
 	sheet1.SetSumText(0, 0, "TOTAL");
}
/**
 * Sheet1 OnMouseDown event handling <br>
 * @param  {Integer} Button	mandatory Integer
 * @param  {integer} Shift	mandatory Integer
 * @param  {Integer} X	mandatory Integer
 * @param  {integer} Y	mandatory Integer
 * @return 
 * @author 
 * @version
 */ 
 function sheet1_OnMouseDown (Button, Shift, X, Y){
	 var sheetObj=sheetObjects[0];
	 var formObj=document.form;
	 if(sheetObj.rowcount + 1 == sheetObj.mouseRow)
	 {
		 //alert("ROWCNT:"+ sheetObj.rowcount+"=>"+ sheetObj.MouseRow +":"+sheetObj.MouseCol)	 
		 //var groupValue1 = sheetObj.cellValue(sheetObj.MouseRow, "sts_evnt_ofc_cd");
		 //alert(groupValue1);
		 sheet1_OnDblClick(sheetObj, sheetObj.MouseRow(), sheetObj.MouseCol(), 0, 0, 0, 0);
	 }
 }
function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	var eqKndCd=EQ_KND_CD_MGSET;
	var crntOfcCd=document.form.crnt_ofc_cd.value;
	var inqFmDys=document.form.inq_fm_dys.value;
	var inqToDys=document.form.inq_to_dys.value;
	var group1="";
	var groupValue1=sheetObj.GetCellValue(Row, "sts_evnt_ofc_cd");
	var s2_group1="";
	var s2_groupValue1="";
  	var s3_gtotal="";
	if(groupValue1.substring(0,6) == "SubSum")
	{
		s2_group1="SubSum";
		s2_groupValue1=groupValue1.substring(9);
		groupValue1=groupValue1.substring(9); 
	} else if(groupValue1 == "TOTAL"){
  		s3_gtotal="GTOTAL";
  	} else {
		s2_group1="";
		s2_groupValue1="";
	}
	var s2EqTpszCd="";

	var colSaveName=sheetObj.ColSaveName(Col);
	var k = 1;
	oldCntrTypeSize = sCntrTypeSize;
	var arrCntrTypeSize = oldCntrTypeSize.split("|");

	for ( var i = 0; i < arrCntrTypeSize.length; i++) {
		if (arrCntrTypeSize.length > 1) {
			var gubun = "eq_tpsz_cd" + k;
			if(colSaveName == gubun){
				s2EqTpszCd = arrCntrTypeSize[i];
				break;
			}
			k++;
		}
	}
	
	if(parseInt(Col) == 1)s2EqTpszCd="TOTAL";

	var param="?program_id=2079";
	param=param + "&eq_knd_cd=" + eqKndCd;
	param=param + "&s_crnt_ofc_cd=" + crntOfcCd;
	param=param + "&s1_inq_fm_dys=" + inqFmDys;
	param=param + "&s1_inq_to_dys=" + inqToDys;
	param=param + "&s_group1=" + group1; 
	param=param + "&s_group1_val=" + groupValue1;
	param=param + "&s2_group1=" + s2_group1;
	param=param + "&s2_group1_val=" + s2_groupValue1;
	param=param + "&s2_eq_tpsz_cd=" + s2EqTpszCd;
	param=param + "&s3_gtotal=" + s3_gtotal;
	var seq=sheetObj.GetCellValue(Row, "Seq");
	if(Col >= 1 ){
		ComOpenPopup('/opuscntr/EES_CGM_2084.do' + param,  700, 400, "", "1,0", true, false);
    }else
    {
  	    ComShowCodeMessage('CGM10016');
    }
}    
 /** 
  * Object activate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */
 function obj_activate(){
   	ComClearSeparator(event.srcElement);
 } 
/** 
  * Object deactivate event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */
 function obj_deactivate(){
     	 var formObj=document.form;
     	 obj=event.srcElement;
     	 if(obj.name=="inq_fm_dys"  ){
     		 with(formObj){
     			 var creDtFr=ComReplaceStr(inq_fm_dys.value,"-","");
  	        }
  	        ComChkObjValid(event.srcElement);
         }
       	if(obj.name=="inq_to_dys"  ){
    		with(formObj){
    			 var creDtFr=ComReplaceStr(inq_to_dys.value,"-","");
  	        }
  	        ComChkObjValid(event.srcElement);
        }
 }
 
/** 
  * Object change event handling  <br>
  * @param  
  * @return 
  * @author 
  * @version
  */  
 function obj_change(){
 	 var formObj=document.form;
 	 var sheetObj=sheetObjects[0]; 
 	 obj=event.srcElement;
 	 switch(ComGetEvent("name")){
	 	case "crnt_ofc_cd":
	 		var crntOfcCd=ComTrimAll(formObj.crnt_ofc_cd.value);
	   		if( formObj.crnt_ofc_cd.value.search(',') > 0 || (formObj.crnt_ofc_cd.value == '')) 
	   		{
	   			break;
	   		}
	   		var arrCrntOfcCd=crntOfcCd.split(",");
	   		for(var i=0; i < arrCrntOfcCd.length; i++){
	   		// 
	 			if(arrCrntOfcCd[i] == ''){
	 				ComShowCodeMessage('CGM10009','Office');
	 				formObj.crnt_ofc_cd.value="";
	 				ComSetFocus(formObj.crnt_ofc_cd);
	 				break;
	 			}else
	 			{
	    	 		if(formObj.crnt_ofc_cd.value != ''){
	    	 			doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC02);
	    	 		}
	 			}
	   		}
	 		break;
 	   	case "vndr_seq":
 	   		var vndrSeq=ComTrimAll(formObj.vndr_seq.value);
 	   		var arrVndrSeq=vndrSeq.split(",");
 	   		for(var i=0; i < arrVndrSeq.length; i++){
 	   		// 
 	 			if(arrVndrSeq[i] == ''){
 	 				ComShowCodeMessage('CGM10009','Lessor');
 	 				formObj.vndr_seq.value="";
     	 				ComSetFocus(formObj.vndr_seq);
     	 				break;
     	 			}
     	   		}	 
      	   	     	 break;
     	 }   
     }
/** 
 * Object obj_focusout event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */  
function obj_focusout(){
	 var formObj=document.form;
	 var sheetObj=sheetObjects[0];
	 obj=event.srcElement;
	 switch(ComGetEvent("name")){
	 	case "crnt_ofc_cd":
	 		break;
	 }
}
/** 
  * Combo Object reset  <br>
  * @param  {object} comboObj	Combo Object
  * @return 
  * @author 
  * @version
  */ 
 function initCombo(comboObj) {
 	switch(comboObj) {
    	case "agmt_lstm_cd":
 	 		var cnt=0;
  	        with(comboObj) {
  	        	Code="";
  	            Text="";
  	            SetDropHeight(180);
  	            SetMultiSelect(1);
  	            SetMaxSelect(100);
  //no support[check again]CLT 	            UseCode=true;
  	            SetEnable(1);
//no support[check again]CLT 	        	ValidChar(2,3);       
//no support[check again]CLT 	            IMEMode=0;            
	            SetMaxLength(20);
  	        }
  	        break;
 	}
 }   
 function makeComboObject(cmbObj, arrStr, txtCol, codeCol, opt) {
 	cmbObj.RemoveAll();
 	if(opt == 0) {
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i, arrCode[txtCol], arrCode[codeCol]);
         }
 	} else if(opt == 1){
 		cmbObj.InsertItem(0,"","");
 		for (var i=0; i < arrStr.length;i++ ) {
 			var arrCode=arrStr[i].split("|");
     		cmbObj.InsertItem(i+1, arrCode[txtCol], arrCode[codeCol]);
         }
 	}
 	cmbObj.SetSelectIndex("" ,false);
 } 
 function makeCPMultiCombo(cmbObj, arrStr, txtCol, codeCol) {
    	cmbObj.RemoveAll();
    	if(arrStr == undefined ){
    		cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
    	} else {
        	var arrCode=arrStr[0].split("|");
      	var arrCode2=arrStr[1].split("|");
          	for (var i=0; i < arrCode.length;i++ ) {
          		var arrCode3=arrCode[i].split("|");
          		var arrCode4=arrCode2[i].split("|");
          		if(i==0)
          		{
          			cmbObj.InsertItem(0, "Include Pool Chassis", "I" );
          			cmbObj.InsertItem(1, "Exclude Pool Chassis", "E" );
          			cmbObj.InsertItem(2, "Only Pool Chassis", "O" );
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          		else
          		{
          			cmbObj.InsertItem(i+3, arrCode4[txtCol], arrCode3[codeCol]);
          		}
          	}
    	}
    	cmbObj.SetSelectIndex("" ,false);
    } 

