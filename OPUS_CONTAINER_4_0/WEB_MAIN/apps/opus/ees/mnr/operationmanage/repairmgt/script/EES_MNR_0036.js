/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0036.js
*@FileTitle  : Document Transmision
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0036 : EES_MNR_0036 - Defining a script used by screen
     */
/* Developer's task	*/
// Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var rdObjects=new Array();
var rdCnt=0;
var queryStr="";
var workOrderType="";
var transmissionTypeText=" |";
var transmissionTypeCode=" |";
var transmissionTypeNotEDIText=" |";
var transmissionTypeNotEDICode=" |";
var opener;
// Defining event handler of button click */
document.onclick=processButtonClick;
// Event handler to diverge process by button name */
	function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject=sheetObjects[0];
		var rdObject=rdObjects[0];
		/*******************************************************/
		var formObject=document.form;
    	try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_Print":
					printRd(rdObjects[0]);
					break;
				case "btn_DOCSend":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
                	break;
				case "btn_Close":
					ComClosePopup(); 
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
    	opener = window.dialogArguments;
    	if (!opener)
    		opener = parent;
    	
		MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		initRdConfig(rdObjects[0]);
		//sheetObj.WaitImageVisible = false;
		var formObject=document.form;
		var tempText=mnrOrdSeq.split("|");
		var mnr_ord_seq="";
		var mnr_ord_ofc_cty_cd="";
		for(var j=0; j < tempText.length;j++){
			if(j>0){
				mnr_ord_seq += "," + tempText[j].substr(3, tempText[j].length);
				mnr_ord_ofc_cty_cd += "," + tempText[j].substr(0, 3);
			}else{
				mnr_ord_seq += tempText[j].substr(3, tempText[j].length);
				mnr_ord_ofc_cty_cd += tempText[j].substr(0, 3);
			}
		}
		formObject.mnr_ord_seq.value=mnr_ord_seq;
		formObject.mnr_ord_ofc_cty_cd.value=mnr_ord_ofc_cty_cd;
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		//sheetObj.WaitImageVisible = true;
		MnrWaitControl(false);
    }
  	/**
     * Initializing RD configuration
     * @param	{RdObject}	rdObject	Processing object of RD
     */
	function initRdConfig(rdObject){
	    var Rdviewer=rdObject ;
//		Rdviewer.AutoAdjust=true;
//		Rdviewer.HideToolBar();
//		Rdviewer.HideStatusBar();
//		Rdviewer.ViewShowMode(0);
//		Rdviewer.SetBackgroundColor(128,128,128);
//		Rdviewer.SetPageLineColor(128,128,128);
	}
	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                
	                var HeadTitle="|Sel|Seq.|W/O No|W/O Type|Service Provider|Transmission Type|DOC Subject|E-mail|Memo|Fax";
	                var headCount=ComCountHeadTitle(HeadTitle);
	//                (headCount + 3, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"mnr_ord_seq",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"wo_type",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"vndr_lgl_eng_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Combo",     Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"trsm_mod_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"doc_subject",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_eml",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"memo",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"fax_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"wo_type_code",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"edi_id",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"mnr_grp_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetSheetHeight(100);
	                SetCountPosition(0);
          		}
                break;
        }
    }
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
     }
   /**
    * Event handling of double-click of sheet1
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnDblClick(sheetObj,Row, Col, CellX, CellY, CellW, CellH) {
		if (Col == "2" || Col == "3" || Col == "4" || Col == "5"){
			rdView(sheetObj,Row);
		}
	}
   /**
    * Event handling of search end of sheet1
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg){
		if(sheetObjects[0].RowCount()>0){
	    	for(i=sheetObjects[0].LastRow(); i > 0 ; i--){
	    		if(sheetObj.GetCellValue(i, "wo_type_code")!="EST"){
				  sheetObj.CellComboItem(i,"trsm_mod_cd", {ComboText:transmissionTypeNotEDIText, ComboCode:transmissionTypeNotEDICode} );
				}
	    	}
			rdView(sheetObjects[0],"1");
		}
	}
   /**
    * Event handling of search end of sheet1
    * @param sheetObj
    * @param Row
    * @param Col
    * @param Value
    * @return
    */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			ComShowCodeMessage("MNR00075");
			var isSelfClose="Y";
			for(var x=1 ; x <= sheetObj.RowCount();x++){
				if(sheetObj.GetCellValue(x,"sel") == "0"){
					isSelfClose="N";
				}
			}
			if(isSelfClose == "Y"){
				opener.doActionIBSheet(opener.sheetObjects[1],opener.document.form,IBSEARCH, 1);
				ComClosePopup(); 
			}
		} else {
			ComShowCodeMessage("MNR00076",ErrMsg);
		}
	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			case IBSEARCH:      //Retrieving
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH;
					var param="f_cmd="  +  formObj.f_cmd.value + "&mnr_ord_seq=" + formObj.mnr_ord_seq.value + "&mnr_ord_ofc_cty_cd=" + formObj.mnr_ord_ofc_cty_cd.value;
 					sheetObj.DoSearch("EES_MNR_0036GS.do",param );
				}
				break;
			case IBSAVE:        //Saving
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=MULTI;
					var param="f_cmd="  +  formObj.f_cmd.value + "&mnr_ord_seq=" + formObj.mnr_ord_seq.value + "&mnr_ord_ofc_cty_cd=" + formObj.mnr_ord_ofc_cty_cd.value;
					chksave=sheetObj.DoSave("EES_MNR_0036GS.do", param, -1, false);
				}
				break;
			case IBCLEAR:        //Initializing
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","CD00016", "COMMON")	//Transmission Type
				);
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//Setting combo
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						//Initializing each combo of sheets
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							if(tempText[0]=="E"){
								transmissionTypeText += tempText[1] + "|";
								transmissionTypeCode += tempText[0] + "|";
							}else{
								transmissionTypeText += tempText[1] + "|";
								transmissionTypeCode += tempText[0] + "|";
								transmissionTypeNotEDIText += tempText[1] + "|";
								transmissionTypeNotEDICode += tempText[0] + "|";
							}
						}
						//Transmission Type
						if(i==0) {
							sheetObjects[0].SetColProperty(0,"trsm_mod_cd", {ComboText:transmissionTypeText, ComboCode:transmissionTypeCode} );
						}
					}
				}
                break;
        }
    }
    /**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	switch(sAction) {
				case IBSAVE:
					var chkYn="";
					for(var i=1; i <= sheetObjects[0].RowCount();i++){
						if(sheetObjects[0].GetCellValue(i, "sel")=="1"){
							if (!ComChkValid(formObj)) return false;
						}
						
						if(sheetObjects[0].GetCellValue(i, "sel")=="1" && sheetObjects[0].GetCellValue(i, "trsm_mod_cd")=="M" && sheetObjects[0].GetCellValue(i, "mnr_prnr_eml")==""){
							ComShowCodeMessage("MNR00003");
							sheetObjects[0].SelectCell(i, "mnr_prnr_eml");
							return false;
						}
						if(sheetObjects[0].GetCellValue(i, "sel")=="1" && sheetObjects[0].GetCellValue(i, "trsm_mod_cd")=="F" && sheetObjects[0].GetCellValue(i, "fax_no")==""){
							ComShowCodeMessage("MNR00003");
							sheetObjects[0].SelectCell(i, "fax_no");
							return false;
						}
						if(sheetObjects[0].GetCellValue(i, "sel")=="1" && sheetObjects[0].GetCellValue(i, "trsm_mod_cd")=="E" && sheetObjects[0].GetCellValue(i, "edi_id")==""){
							ComShowCodeMessage("MNR00036","EDI");
							return false;
						}
						if(sheetObjects[0].GetCellValue(i, "sel")=="1" && sheetObjects[0].GetCellValue(i, "trsm_mod_cd")=="M"){
							if(ComIsEmailAddr(sheetObjects[0].GetCellValue(i, "mnr_prnr_eml"))==false){
								ComShowCodeMessage("MNR00036","EMAIL");
								return false;
							}
						}
						if(sheetObjects[0].GetCellValue(i, "sel")=="1"){
							chkYn="1";
						}
					}
					if(chkYn!="1"){
						ComShowCodeMessage("MNR00036","Work Order No");
        				return false;
					}
				 	break;
			}
        }
        return true;
    }
   /**
    * Opening RD
    * @param sheetObj
    * @param Row
    * @return
    */
	function rdView(sheetObj,Row) {
		var Rdviewer=rdObjects[0] ;
		var wo_no=sheetObj.GetCellValue(Row, "mnr_ord_seq");
		var memo=sheetObj.GetCellValue(Row, "memo");
		var subject=sheetObj.GetCellValue(Row, "doc_subject");
		var rdParam='/rv mnr_ord_ofc_cty_cd['+ wo_no.substr(0, 3) +'] mnr_ord_seq['+ wo_no.substr(3, wo_no.length) +'] user_nm[' + self_usr_nm + '] memo[' + memo + '] subject[' + subject + ']';
//		Rdviewer.ApplyLicense("0.0.0.0"); 
		if(sheetObj.GetCellValue(Row, "wo_type_code")=="SPL"){
			viewer.openFile(RD_path+'apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0183.mrd', RDServer + rdParam, {timeout:1800});
		}else if(sheetObj.GetCellValue(Row, "wo_type_code")=="EXT"){
			viewer.openFile(RD_path+'apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0187.mrd', RDServer + rdParam, {timeout:1800});
		}else if(sheetObj.GetCellValue(Row, "wo_type_code")=="RFS"){
			viewer.openFile(RD_path+'apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0231.mrd', RDServer + rdParam, {timeout:1800});
		}else{
			viewer.openFile(RD_path+'apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd', RDServer + rdParam, {timeout:1800});
		}
	}
  	/**
     * Printing RD report
     * @param	{RdObject}	rdObject	Processing object of RD
     */
	function printRd(rdObject){
	    var Rdviewer=rdObject ;
	    viewer.print({isServerSide:true}); //Viewing print dialog
	}
