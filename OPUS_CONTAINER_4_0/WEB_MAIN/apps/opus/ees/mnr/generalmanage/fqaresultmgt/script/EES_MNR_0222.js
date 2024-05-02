/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0222.js
*@FileTitle : FQA Result Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_mnr_0222 : ees_mnr_0222 - Defining a script used by screen
     */
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var comboValue="";
var noClick="";
var strMnrOfficeLevel="";	// Office level of login user :  HO - L1, RHQ - L2, Office - L3 (from CoMnr.js MnrOfficialLevel)
//Variable for saving status of clicked retrieve button
var retrieveClick=0;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "sProvider":
				    if(noClick!="Y"){
						ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 550, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
					}
					break;
				case "btn_Detail":
					var vndr_seq="";
					var yd_cd="";
					var fld_aud_dt=""
					var ofc_cd=""
					var reqStr=""
					vndr_seq=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"vndr_seq");
					yd_cd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"yd_cd");
					fld_aud_dt=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"fld_aud_dt");
					ofc_cd=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(),"ofc_cd");
					reqStr="vndr_seq=" + vndr_seq + "&yd_cd=" + yd_cd + "&fld_aud_dt=" + fld_aud_dt+ "&ofc_cd=" + ofc_cd;
					if(sheetObject1.RowCount()>0){
						ComOpenPopup('/opuscntr/EES_MNR_0223.do?'+ reqStr, 1024, 720, 'getInvoiceDetail', "0,1,1,1,1,1", true);
					}
					break;
				case "btn_DownExcel":
					
					 if(sheetObject1.RowCount() < 1){//no data
						  ComShowCodeMessage("COM132501");
						}else{
							sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
						}
					break;
			} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],k + 1);
	    }
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
    /**
	 * Combo Setting default
	 * @param	{IBMultiCombo}	combo_obj.
	 * @param	{Number}	comboNo		Sequence number from combo object tag id
	 */
	function initCombo (comboObj, comboNo) {
	    var formObject=document.form
	    switch(comboNo) {
	        case 1:
	           	with (comboObj) {
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
				ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
		    	}
	        	break;
	        case 2:
	           	with (comboObj) {
				SetMultiSeparator("|");
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				//SetColWidth("100|150");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
				ValidChar(2);
	            SetTitleVisible(1);
	            SetMaxLength(6);
		    	}
	        	break;
	     }
	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                    with(sheetObj){
							var prefix="sheet1_";
						  
						  var HeadTitle1="|Seq|FQA Date|Office|Service Provider|Yard|Point|Audit User|Remark";
						  var headCount=ComCountHeadTitle(HeadTitle1);

						  SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );

						  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						  InitHeaders(headers, info);

						  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
								 {Type:"Seq",       Hidden:0, Width:50,  Align:"Center",  ColMerge:1,   SaveName:"Seq" },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"fld_aud_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"pnt_no",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
								 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"fld_aud_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
						   
							InitColumns(cols);

							SetEditable(0);
							SetCountPosition(0);
							MultiSelection=false;
							SetSelectionMode(smSelectionRow);
							SelectHighLight=true;
							SelectFontBold=false;
//							SetSheetHeight(382);
							resizeSheet( sheetObj );
						  }


         		  break;
		}
     }
	function initControl() {
	    //Axon event handling 1. Catching event
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	 //   axon_event.addListenerFormat('focus',   'obj_activate',    form);
	    //axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
		axon_event.addListenerFormat('change',	 'obj_change',	form);
	}
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
    	comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * Disable event handling <br>
	 **/
	function obj_deactivate(){
		obj=ComGetEvent();
	    ComChkObjValid(ComGetEvent());
	}
	/**
	 * Enable event handling <br>
	 **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		vndr_seq_confirm();
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;
			}
	    }
	}
	/**
	 * Keypress event handling <br>
	 **/
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
	            if(obj.name=="vndr_seq"){
					ComKeyOnlyNumber(obj);
				} else {
					ComKeyOnlyAlphabet('uppernum');
				}
	            break;
	    }
	}
	/**
	 * combo1 : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	//function (comboObj,Index_Code, Text){
		 function combo1_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		var formObj=document.form;
   		if(NewIndex==""){
			comboObj.SetSelectCode("A");
		}
		if(comboObj.GetSelectCode()=="A"){
			formObj.ar_hd_qtr_cd.value = "";
		}else{
			formObj.ar_hd_qtr_cd.value = comboObj.GetSelectCode();
		}
		comboOnChange(comboObj,NewCode, NewText);
	}
	/**
	 * combo2 : OnChange event
	 * @param {IBMultiCombo}  comboObj
	 * @param  {String}    Index_Code
	 * @param  {String}    Text
	 */
	function combo2_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
	
		var formObj=document.form;
   		if(NewIndex==""){
			comboObj.SetSelectCode("A");
		}
		if(comboObj.GetSelectCode()=="A"){
			formObj.ofc_cd.value="";
		}else{
			formObj.ofc_cd.value=comboObj.GetSelectCode();
		}
	}
  //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
        		if(validateForm(sheetObj,formObj,sAction)){
	                formObj.f_cmd.value=SEARCH;
				    retrieveClick=1;
					var sXml=sheetObj.GetSearchData("EES_MNR_0222GS.do" , FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
        	  	}
             	break;
          	case IBCLEAR:      // new
				MnrWaitControl(true);
			    sheetObj.SetWaitImageVisible(0);
        	    //Initializing clicked status of retrieve button
				retrieveClick=0;
				//Initializing sheet
				for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
			    }
				//Initializing combo data
				for(var i=0; i < comboObjects.length;i++){
			 		comboObjects[i].RemoveAll();
			    }
				var sCondition=new Array (
					new Array("MdmOrganization","RHQ","FALSE")  //Regional HQ
				);
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//Setting combo
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						//Initializing each combo of sheets
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							if(i==0){ //Regional HQ
								combo1.InsertItem(j, comboList[i][j] ,tempText[0]);
							}
						}
					}
				}
				combo1.InsertItem(0, "ALL" ,"A" );
				if(strMnrOfficeLevel=="L1"){
					combo1.SetSelectCode("A");
				} else {
					combo1.SetEnable(0);
					combo1.SetSelectCode(rhqOfcCd);
				}
				noClick="";
				formObj.vndr_seq.value="";
				formObj.vndr_lgl_eng_nm.value="";
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);
               	break;
        }
    }
    /**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)      */
    function validateForm(sheetObj,formObj,sAction){
    	var prefix="sheet1_";
    	switch (sAction) {
	 	    case IBSEARCH: // Retrieving
				break;
   	    }
   	    return true;
    }
	/**
	 * Checking existed of vndr_seq
	 */
	function vndr_seq_confirm(){
		var formObj=document.form;
		if(formObj.vndr_seq.value != "" && noClick!="Y"){
			//Retrieving service provider
			var sCondition=new Array (
			 	new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)
			//Setting when returned data exist
			var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
			if(comboList[0] != null){
				var tempText=comboList[0][0].split("|");
				formObj.vndr_lgl_eng_nm.value=tempText[1];
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				ComSetObjValue(formObj.vndr_lgl_eng_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
	}
   /**
	 * Event handling of OnChange of combo
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */
	function comboOnChange(comboObj,Index_Code, Text){
		var formObj=document.form;
		combo2.RemoveAll();
		var sCondition=new Array (
			new Array("MdmOrganization","SEARCH",Index_Code)
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		if(comboList[0] != null){
			for(var j=0; j < comboList[0].length;j++){
		   		var tempText=comboList[0][j].split("|");
		   		combo2.InsertItem(j,comboList[0][j] ,tempText[0]);
			}
		 	combo2.InsertItem(0, "ALL" , "A");
			if(strMnrOfficeLevel=="L3"){
				combo2.SetEnable(0);
				combo2.SetSelectCode(currOfcCd);
			}else {
				combo2.SetSelectCode("A");
			}
		}
	}
    /**
     * getCOM_ENS_0C1 : Processing by received value of pop-up screen
	 * @param	{String[][]}	aryPopupData	Retruned pop-up screen data
     */
    function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
		 var formObj=document.form;
		 var vndrSeq="";
		 var vndrNm="";
		 var i=0;
		 for(i=0; i < aryPopupData.length; i++){
			 vndrSeq=vndrSeq + aryPopupData[i][2];
			 if(aryPopupData.length == 1){
				 vndrNm=vndrNm + aryPopupData[i][4];
			 }
			 if(i < aryPopupData.length - 1){
				 vndrSeq=vndrSeq + ",";
			 }
		 }
		 formObj.vndr_seq.value=vndrSeq;
		 formObj.vndr_lgl_eng_nm.value=vndrNm;
    }
