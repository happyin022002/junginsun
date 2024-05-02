/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0098.js
*@FileTitle  : Total Loss Collection & Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0098 : EES_MNR_0098 - Defining a script used by screen
 */
function EES_MNR_0098() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.initControl=initControl;
	this.doActionIBSheet=doActionIBSheet;
	this.setTabObject=setTabObject;
	this.validateForm=validateForm;
}
/* ********* General Functions ************* */
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Using for upload file
	var uploadFileSeq="";
	//History Seq Saving
	var historyMnrStsRefNo="";
	var sSaveRtnXml="";
	var nowLoad=0;
	var currTtlLssNo="";
	var currTtlLssDtlSeq="";
	//Corporate Headquarters Code
	var HOOfc="";
	var actionType="";
	var nowLoad=0;
	// Office level by login user : HQ L1, RHQ L2, Office L3 (from MnrOfficeLevel function of CoMnr.js)
	var strMnrOfficeLevel="";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var sheetObject6=sheetObjects[5];
		var sheetObject7=sheetObjects[6];
		var sheetObject8=sheetObjects[7];
		var sheetObject9=sheetObjects[8];
		var sheetObject10=sheetObjects[9];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		 if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
					case "btn_period" :
						var cal=new ComCalendarFromTo();
						cal.select(formObject.in_st_dt,  formObject.in_end_dt,  'yyyy-MM-dd');
						break;
					case "btn_Retrieve":
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
						break;
					case "btn_New":
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
						break;
					case "btn_Save":
						actionType="IBSAVE";
						doActionIBSheet(sheetObject2,formObject,IBSAVE);
						break;
					case "btn_Complete":
						actionType="COMPLETE";
						doActionIBSheet(sheetObject2,formObject,IBSAVE);
						break;
					case "btn_Delete":
						doActionIBSheet(sheetObject2,formObject,IBSEARCHAPPEND);
						break;
	                //Multi inserting
					case "btn_ttl_lss_no_multi":
						rep_Multiful_inquiry("in_ttl_lss_no");
						break;
					//Multi inserting
					case "eq_no_multi1":
						rep_Multiful_inquiry("in_rqst_eq_no");
						break;
					/** (Tab) D.V Expense (S) **/
					case "btn_t1RowAdd":
						doActionIBSheet(sheetObject3,formObject,IBINSERT);
						break;
					case "btn_t1InvoicePreview":
						if(sheetObjects[2].RowCount()>0)
						{
							var row=sheetObjects[2].GetSelectRow();
							if(sheetObjects[2].GetCellValue(row, "lstm_cd") != "OW"){
								var rdParam='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
								rdParam +=   'inv_no[' + sheetObjects[2].GetCellValue(row,"inv_no") + '] ';
								    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
								rdParam +=   'payer_code[' + sheetObjects[2].GetCellValue(row,"payer_code") + '] ';
								rdParam +=   'curr_cd[' + sheetObjects[2].GetCellValue(row,"curr_cd") + '] ';
									rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
									rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
								formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";
								formObject.com_mrdArguments.value=rdParam;
								formObject.com_mrdBodyTitle.value="Sale Invoice for Total Loss Equipment";
								var sFeatures="resizable=yes,width=720,height=800"
								ComOpenRDPopup(sFeatures);
							}else{
								ComShowCodeMessage("MNR00382");
							}
						}
						break;
					case "btn_t1RowDel":
						doActionIBSheet(sheetObject3,formObject,IBDELETE);
						break;
					/** (Tab) D.V Expense (E) **/
					/** (Tab) 3rd Party (S) **/
					case "btn_t2RowAdd":
						doActionIBSheet(sheetObject4,formObject,IBINSERT);
						break;
					case "btn_t2InvoicePreview":
						if(sheetObjects[3].RowCount()>0)
						{
							var row=sheetObjects[3].GetSelectRow();
							var rdParam='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							rdParam +=   'inv_no[' + sheetObjects[3].GetCellValue(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
							rdParam +=   'payer_code[' + sheetObjects[3].GetCellValue(row,"payer_code") + '] ';
							rdParam +=   'curr_cd[' + sheetObjects[3].GetCellValue(row,"curr_cd") + '] ';
								rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
								rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
							formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";
							formObject.com_mrdArguments.value=rdParam;
							formObject.com_mrdBodyTitle.value="Sale Invoice for Total Loss Equipment";
							var sFeatures="resizable=yes,width=720,height=800"
							ComOpenRDPopup(sFeatures);
						}
						break;
					case "btn_t2RowDel":
						doActionIBSheet(sheetObject4,formObject,IBDELETE);
						break;
					/** (Tab) 3rd Party (E) **/
					/** (Tab) Disposal (S) **/
					case "btn_t3RowAdd":
						doActionIBSheet(sheetObject5,formObject,IBINSERT);
						break;
					case "btn_t3InvoicePreview":
						if(sheetObjects[4].RowCount()>0)
						{
							var row=sheetObjects[4].GetSelectRow();
							var rdParam='/rv ttl_lss_no[' + formObject.ttl_lss_no.value + '] ';
							rdParam +=   'inv_no[' + sheetObjects[4].GetCellValue(row,"inv_no") + '] ';
							    //payer type: S=Service Provide,C=Customer,O=Res Office,N=None
							rdParam +=   'payer_code[' + sheetObjects[4].GetCellValue(row,"payer_code") + '] ';
							rdParam +=   'curr_cd[' + sheetObjects[4].GetCellValue(row,"curr_cd") + '] ';
								rdParam +=   'rqst_ofc_cd[' + formObject.rqst_ofc_cd.value + '] ';
								rdParam +=   'user_ofc_cd[' + formObject.self_ofc.value + '] ';
							formObject.com_mrdPath.value="apps/opus/ees/mnr/operationmanage/totallossmgt/report/EES_MNR_0186.mrd";
							formObject.com_mrdArguments.value=rdParam;
							formObject.com_mrdBodyTitle.value="Sale Invoice for Total Loss Equipment";
							var sFeatures="resizable=yes,width=720,height=800"
							ComOpenRDPopup(sFeatures);
						}
						break;
					case "btn_t3RowDel":
						doActionIBSheet(sheetObject5,formObject,IBDELETE);
						break;
					/** (Tab) Disposal (E) **/
					/** (Tab) Scrapping (S) **/
					case "btn_t4RowAdd":
						doActionIBSheet(sheetObject6,formObject,IBINSERT);
						break;
					case "btn_t4InvoicePreview":
						break;
					case "btn_t4RowDel":
						doActionIBSheet(sheetObject6,formObject,IBDELETE);
						break;
					/** (Tab) Scrapping (E) **/
					/** (Tab) Insurance (S) **/
					case "btn_t5RowAdd":
						doActionIBSheet(sheetObject7,formObject,IBINSERT);
						break;
					case "btn_t5InvoicePreview":
						break;
					case "btn_t5RowDel":
						doActionIBSheet(sheetObject7,formObject,IBDELETE);
						break;
					/** (Tab) Insurance (E) **/
					case "btn_Col_Add":
						doActionIBSheet(sheetObject8,formObject,IBINSERT);
						break;
					case "btn_Col_Delete":
						doActionIBSheet(sheetObject8,formObject,IBDELETE);
						break;
					case "btn_RowAdd2":
						history_Insert(sheetObject9);
						break;
					case "btn_RowDel2":
						history_Remove(sheetObject9);
						break;
					case "btn_FileAdd":
						file_Insert(sheetObject10);
						break;
					case "btn_FileDel":
						file_Remove(sheetObject10);
						break;
					//RES Office. PopUp
					case "respb_ofc_cd_popup":
						if(formObject.ttl_lss_sts_cd.value !='HE' && formObject.respb_ofc_cd.readOnly == false)
						{
							if(MnrNullToBlank(formObject.search_ttl_lss_no.value) != ""){
								ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_COM_ENS_071', '1,0', true);
							}
						}
						break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
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
    	//Setting button
    	MnrWaitControl(true);
    	nowLoad=1;
		// Retrieving and Setting for office level
		MnrOfficeLevel(currOfcCd, rhqOfcCd);
		//Axon Initializing event
		initControl();
		//IBMultiCombo Initializing
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
    	// IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // IBTab Initializing
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
            tabObjects[k].SetSelectedIndex(0);
        }
		//Initializing of file upload
        initUpload();
		//Initializing screen
    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
    }
    
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/MNR_INTGS.do'
 			,Files:[]
	 		,BeforeAddFile : function(result){
			 	return true;
			}
			,BeforeSaveStatus : function(result){ 
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
				var prefix="";
				
				pSheetObj.SetCellValue(pRow, pCol,fileName,0);
				pSheetObj.SetCellValue(pRow, prefix+ "file_dw",'1',0);
				var file_seq=pSheetObj.GetCellValue(pRow, prefix+ "file_seq");
				var file_dtl_seq=pSheetObj.GetCellValue(pRow, prefix+ "file_dtl_seq");
				if(file_dtl_seq=="") file_dtl_seq=pRow;
				var ibflag='U';
				if(file_seq == "" || uploadFileSeq != "") ibflag='I'; // saving initially, in case of not existing saved file
				if(file_seq != "" && uploadFileSeq != "") ibflag='U';
				if(uploadFileSeq != "") {
					file_seq=uploadFileSeq;
				}
		 		var sParam = "f_cmd="+COMMAND01;
		 		sParam+= "&mnr_grp_tp_cd=TLL";       // MNR Work Group Type Code
		 		sParam+= "&file_seq=" + file_seq;    // Existed file sequence
		 		sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
		 		sParam+= "&org_file_nm=" + fileName; // Fileupload file name
		 		sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
		 		paramToForm(sParam);
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
	 				if(uploadFileSeq != "" && uploadFileSeq != undefined){
	 					var fileXml=SearchFileUpload(sheetObjects[9],uploadFileSeq);
	 					sheetObjects[9].LoadSearchData(fileXml,{Sync:1} );
					}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
	 		,AfterAddFile:function(result){
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
	 			pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
				upload1.SaveStatus();
			}
 		});
 	}
    function sheet5_OnMouseMove(sheetObj, e) {
	  	  var row     = sheetObj.MouseRow(),
	        col     = sheetObj.MouseCol(),
	        info    = null;
	        if (row > 0 &&sheetObj.ColSaveName(col) == "org_file_nm") {
	           
	            info = sheetObj.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	        } 
	  }
    
    
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
			case 2:
	    	case 3:
	    	case 4:
	            with (comboObj) {
	    		   SetColAlign(0, "left");
				   SetDropHeight(160);
		        }
	            break;
	     }
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
							      var HeadTitle1="||||||||||||||";
							      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, MergeSheet:5, Page:20, DataRowMerge:1 } );
							      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
							      var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle1, Align:"Center"}];
							      InitHeaders(headers, info);
							      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ofc_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_dt" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_sts_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_rsn_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dt" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"apro_ofc_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_seq" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_cd" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_nm" },
							             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_cfm_dt" }];
							       
							      InitColumns(cols);
							      SetEditable(1);
							      SetCountPosition(0);
							      SetVisible(false);
							      SetEditable(1);
			      }
	            break;
			case "sheet2":
			      with(sheetObj){
					         var HeadTitle1="|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible OFC|D.V Exnpense|D.V Exnpense|D.V Exnpense|D.V Exnpense|3rd Party|3rd Party|Disposal|Disposal|Scrapping|Scrapping|Insurance|Insurance";
					         var HeadTitle2="|Seq.|TTL No.|REQ OFC|REQ User|REQ DT|Status|Main Reason|Sub Reason|TTL DT|APP OFC|Responsible OFC|EQ Q'ty|Expense|Recovery|Balance|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount|EQ Q'ty|Amount";
					         var headCount=ComCountHeadTitle(HeadTitle1);
					         (headCount + 6, 0, 0, true);
					         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
					         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					         var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					         InitHeaders(headers, info);				
					         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                 KeyField:0,   CalcLogic:"",   Format:"" },
					             {Type:"Text",      Hidden:0,  Width:108,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:73,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:1,   SaveName:"rqst_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Date",      Hidden:0,  Width:64,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:0,  Width:52,   Align:"Center",  ColMerge:1,   SaveName:"apro_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"dv_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_recovery",         KeyField:0,   CalcLogic:"|tp_exp|+|ds_exp|+|sc_exp|+|ir_exp|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dv_balance",          KeyField:0,   CalcLogic:"|dv_recovery|-|dv_exp|",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"tp_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"tp_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ds_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ds_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"sc_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"sc_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"ir_eq_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ir_exp",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_dtl_rsn_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"file_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					          
					         InitColumns(cols);
					         SetEditable(1);
					         SetCountPosition(0);
					         SetSheetHeight(142);	         
	                  }
                break;
            case "t1sheet1":
                with(sheetObj){
               
				             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Payee Code|Payee Name|Invoice No.|CURR|Pay Amount|EQ Status|Close Type|Close Date|Remark(s)";
				             var headCount=ComCountHeadTitle(HeadTitle1);
				             (headCount + 20, 0, 0, true);				
				             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				             InitHeaders(headers, info);				
				             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                 {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
//				                 {Type:"CheckBox",  Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cfm_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
				                 {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:65,   Align:"Left",    ColMerge:1,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inv_rgst_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"pay_inv_seq" },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"mnr_swift_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				              
				             InitColumns(cols);
				             SetEditable(1);
				             SetSheetHeight(140);
				             SetCountPosition(0);
				             SetShowButtonImage(2);
				}
                break;
            case "t2sheet1":
                with(sheetObj){
				             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Responsible\nOFC|Payer Code|Payer Name|CURR|3rd Amount|Issue Date|Bank Name|Bank Account|Swift Code|Remark(s)";
				             var headCount=ComCountHeadTitle(HeadTitle1);
				             (headCount + 15, 0, 0, true);
				             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				             InitHeaders(headers, info);
				             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                 {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"dpc_val_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"PopupEdit", Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"respb_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Popup",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:75,   Align:"Left",    ColMerge:1,   SaveName:"bank_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"bank_acct_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
				                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:1,   SaveName:"mnr_swift_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				              
				             InitColumns(cols);
				             SetEditable(1);
				             SetSheetHeight(140);
				             SetCountPosition(0);
				             SetImageList(0,"img/btns_search.gif");
				             SetImageList(1,"img/btns_calendar.gif");
				             SetShowButtonImage(2);
				             SetColHidden("dpc_val_amt",1);
             }
              break;
            case "t3sheet1":
                with(sheetObj){
                
				             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark(s)";
				             var headCount=ComCountHeadTitle(HeadTitle1);
				             (headCount + 14, 0, 0, true);				
				             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				             InitHeaders(headers, info);				
				             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:13 },
				                 {Type:"AutoSum",   Hidden:0, Width:120,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"payer_code",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				              
				             InitColumns(cols);
				             SetEditable(1);
				             SetCountPosition(0);
				             SetSheetHeight(140);
                      }
                break;
            case "t4sheet1":
                with(sheetObj){
				             var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark(s)";
				             var headCount=ComCountHeadTitle(HeadTitle1);
				             (headCount + 14, 0, 0, true);				
				             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				             var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				             InitHeaders(headers, info);				
				             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                 {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                 {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"AutoSum",   Hidden:0, Width:160,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"AutoSum",   Hidden:0, Width:150,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				                 {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				                 {Type:"Text",      Hidden:1, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                 {Type:"Text",      Hidden:1, Width:75,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				              
				             InitColumns(cols);
				             SetEditable(1);
				             SetCountPosition(0);
				             SetSheetHeight(140);
                      }


                break;
            case "t5sheet1":
                with(sheetObj){
               
				              var HeadTitle1="|Sel.|Seq.|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Notification Date|Remark(s)";
				              var headCount=ComCountHeadTitle(HeadTitle1);
				              (headCount + 9, 0, 0, true);				
				              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
				              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				              InitHeaders(headers, info);				
				              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:14 },
				                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				                     {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				                     {Type:"PopupEdit", Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_no" },
				                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_dtl_seq" },
				                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"mnr_inv_tp_cd" },
				                     {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"csr_no" },
				                     {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_cmpl_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				               
				              InitColumns(cols);
				              SetEditable(1);
				              SetSheetHeight(140);
				              SetCountPosition(0);
				              SetColHidden("dpc_val_amt",1);
				              SetShowButtonImage(2);
              }
                break;
			case "sheet3":
			    with(sheetObj){
						      var HeadTitle1="|Sel.|Seq.|Type|Date|Curr.|Amount|Pay Method|CSR No.|Check No.|Inv No.|EQ No|Evidence No.|Remark(s)";
						      var headCount=ComCountHeadTitle(HeadTitle1);
						      (headCount + 6, 0, 0, true);				
						      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );				
						      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						      InitHeaders(headers, info);				
						      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"type",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"PopupEdit", Hidden:0, Width:82,   Align:"Center",  ColMerge:1,   SaveName:"clt_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"clt_amt",          KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
						             {Type:"Combo",     Hidden:0, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inv_pay_mzd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"csr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"evid_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_clt_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_clt_seq" },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"clt_stl_flg" },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"clt_ofc_cd" },
						             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:"chk_trns_no" } ];
						       
						      InitColumns(cols);
						      SetEditable(1);
						      SetCountPosition(0);
						      SetSheetHeight(160);
						      SetEditableColorDiff(1);
						      SetShowButtonImage(2);
						      SetSelectionMode(smSelectionRow);
		      }
                break;
			case "sheet4":
			    with(sheetObj){
						      var HeadTitle1="|Sel|Date|Remark(s)|Creation Office|Creation User";
						      var headCount=ComCountHeadTitle(HeadTitle1);
						      (headCount + 3, 0, 0, true);
						      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
						      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						      InitHeaders(headers, info);
						      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mnr_sts_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_rmk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
						             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_ref_no" },
						             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_sts_dtl_seq" },
						             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_grp_tp_cd" } ];
						       
						      InitColumns(cols);
						      SetEditable(1);
						      SetSheetHeight(140);
						      SetCountPosition(0);
						      SetShowButtonImage(2);
		      }
                break;
			case "sheet5":
			      with(sheetObj){
	            			 var prefix="";	        
					         var HeadTitle1="|Evidence Attached|Evidence Attached|Evidence Attached";
					         var HeadTitle2="|Sel|File|Download";
					         var headCount=ComCountHeadTitle(HeadTitle1);
					         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					         var headers = [ { Text:HeadTitle1, Align:"Center"},
					                   { Text:HeadTitle2, Align:"Center"} ];
					         InitHeaders(headers, info);				
					         var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
					             {Type:"Popup",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
					             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					          
					         InitColumns(cols);
					         SetEditable(1);
					         SetSheetHeight(140);
//					         SetCountPosition(0);
					         SetImageList(0,"img/ico_attach.gif");
					         SetShowButtonImage(1);
	         }
			      break;
        }
    }
    /**
     * Tab Setting default
     * Setting tab's item
     */
    function initTab(tabObj , tabNo) {
    	switch(tabNo) {
    		case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "D.V Expense", "");
					InsertItem( "3rd Party", "");
					InsertItem( "Disposal", "");
                }
                break;
         }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    //axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	    //axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }

    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Assigning array of IBTab object
     * Array defined at the top of the source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
	/**
	 * (Office Code) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function setPopUpParam_Sheet2_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(",");
	    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",arr[3],0);
		if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != ""){
			formObj.respb_ofc_cd.value=arr[3];
			formObj.respb_ofc_nm.value=arr[4];
		}
	}
	/**
	 * (Office Code) Processing input box of Pop-up Return Value<br>
	 * @param {array} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function setPopUpParam_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(",");
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
		sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",formObj.respb_ofc_cd.value,0);
	}
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * OnKeypress event handling <br>
	 **/
//	function obj_keypress(){
//		obj=event.srcElement;
//	    if(obj.dataformat == null) return;
//	    window.defaultStatus=obj.dataformat;
//		switch(obj.dataformat) {
//			case "ymd":
//				ComKeyOnlyNumber(event.srcElement);
//				break;
//			case "engup":
//	         	if(obj.name == "in_ttl_lss_no" || obj.name == "in_rqst_eq_no"){
//					ComKeyOnlyAlphabet('uppernum','45|44');
//				} else {
//					ComKeyOnlyAlphabet('uppernum');
//				}
//	            break;
//	    }
//	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change()
	{
		ComChkObjValid(event.srcElement);
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" )
		{
			switch(ComGetEvent("name"))
			{
			case "respb_ofc_cd":
				if(nowLoad != 0) return;
				respb_ofc_cd_Check();
				break;
			}
		}
	}
    /**
     * Event handling of changing tab
     * Activating tab for selected
     */
    function tab1_OnChange(tabObj , nItem) {
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	 for(var i = 0; i<objs.length; i++){
		       if(i != nItem){
		        objs[i].style.display="none";
		        objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
		       }
		      }
    	beforetab=nItem;
		var sheetObj=sheetObjects[nItem + 2];
		if((sheetObj.RowCount() - sheetObj.RowCount("D")) > 0){
			var Row=sheetObj.GetSelectRow();
			var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
			currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
			currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
			var newSeq=1;
			for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
				with(sheetObjects[7]){
					if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
						sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
						sheetObjects[7].SetRowHidden(x,0);
					} else {
						if(sheetObjects[7].GetCellValue(x, "type")!="OTS"){
							sheetObjects[7].SetRowHidden(x,1);
						}
					}
				}
			}
		} else {
			for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
				sheetObjects[7].SetRowHidden(x,1);
			}
			currTtlLssNo="";
			currTtlLssDtlSeq="";
		}
//		if(nItem==0)
//		{
//			ComBtnDisable("btn_t" + (nItem + 1) + "InvoicePreview");
//		}else{
//			ComBtnEnable("btn_t" + (nItem + 1) + "InvoicePreview");
//		}
    	if(document.form.ttl_lss_sts_cd.value=="HE") //In case of completed status
    	{
			ComBtnDisable("btn_Col_Add");
			ComBtnDisable("btn_Col_Delete");
    	}else{
    		if(nItem==0) //In case of Selected DV tab
    		{
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
    		}else{
    			ComBtnEnable("btn_Col_Add");
    			ComBtnEnable("btn_Col_Delete");
    		}
    	}
    	if(nItem==2){
    		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
	    		if(sheetObjects[7].GetCellValue(x, "type")=="OTS"){
					sheetObjects[7].SetRowHidden(x,0);
					sheetObjects[7].SetRowEditable(x, 0);
				}
    		}
    	}else{
    		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
				sheetObjects[7].SetRowHidden(x,1);
    		}
    	}
    }
	/**
	 * Event handling of OnSearchEnd of sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		var formObj=document.form;
		//Setting value of header
	    var Row=sheetObj.FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
	    if(Row >0)
	    {
	    	sheetObj.SetSelectRow(Row);
	    }else{
	    	return false;
	    }
		var ttlLssNo=sheetObj.GetCellValue(Row, "ttl_lss_no");			//REQ OFC
		var rqstOfcCd=sheetObj.GetCellValue(Row, "rqst_ofc_cd");			//REQ OFC
		var respbOfcNm=sheetObj.GetCellValue(Row, "respb_ofc_nm");          //Responsible\nOFC NM
		var rqstDt=sheetObj.GetCellValue(Row, "rqst_dt"); 				//REQ DT
		var ttlLssStsCd=sheetObj.GetCellValue(Row, "ttl_lss_sts_cd");		//Status
		var ttlLssRsnCd=sheetObj.GetCellValue(Row, "ttl_lss_rsn_cd");		//Main Reason
		var ttlLssDtlRsnCd=sheetObj.GetCellValue(Row, "ttl_lss_dtl_rsn_cd");	//Sub Reason
		var ttlLssDt=sheetObj.GetCellValue(Row, "ttl_lss_dt");			//TLL DT
		var aproOfcCd=sheetObj.GetCellValue(Row, "apro_ofc_cd");			//APP OFC
		var fileSeq=sheetObj.GetCellValue(Row, "file_seq");				//File Seq
		var mnrStsRefNo=sheetObj.GetCellValue(Row, "mnr_sts_ref_no");		//mnr_sts_ref_no
		var ttlLssCfmDt=sheetObj.GetCellValue(Row, "ttl_lss_cfm_dt");		//Close Date
		formObj.ttl_lss_no.value=ttlLssNo;			//TTL NO
		formObj.rqst_ofc_cd.value=rqstOfcCd;		//REQ OFC
//		formObj.respb_ofc_cd.value		    = respbOfcCd;		//Responsible\nOFC
		formObj.respb_ofc_nm.value=respbOfcNm;		//Responsible\nOFC NM
		formObj.rqst_dt.value=rqstDt; 			//REQ DT
		formObj.ttl_lss_sts_cd.value=ttlLssStsCd; 		//Status
		ttl_lss_rsn_cd.SetSelectCode(ttlLssRsnCd); 		//Main Reason
		ttl_lss_dtl_rsn_cd.SetSelectCode(ttlLssDtlRsnCd);	//Sub Reason
		formObj.ttl_lss_dt.value=ttlLssDt;			//TLL DT
		formObj.apro_ofc_cd.value=aproOfcCd;		//APP OFC
		formObj.mnr_sts_ref_no.value=mnrStsRefNo;   	//History key
		formObj.ttl_lss_cfm_dt.value=ttlLssCfmDt;   	//History key
		//Retrieving file list
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[9].LoadSearchData(fileXml,{Sync:1} );
			}
		}
		//Retrieving history list
		if(mnrStsRefNo != "" && mnrStsRefNo != null){
			historyMnrStsRefNo=mnrStsRefNo;
			var sXml=MnrStatusHistorySearch(sheetObjects[8], mnrStsRefNo);
			sheetObjects[8].LoadSearchData(sXml,{Sync:1} );
		}
	}
	function t1sheet1_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "ttl_lss_cmpl_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    }
	/**
	 * Event handling of OnSearchEnd of t1sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
		 
		 for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++){
			 if(sheetObj.GetCellValue(i, "lstm_cd") == "OW"){
				 sheetObj.SetCellEditable(i, "inv_no", 0);
				 sheetObj.SetCellEditable(i, "payer_code", 0);
			 }
		 }
	}
	/**
	 * Event handling of OnSearchEnd of t2sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
    }
	/**
	 * Event handling of OnSearchEnd of t3sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	 }
	/**
	 * Event handling of OnSearchEnd of t4sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * Event handling of OnSearchEnd of t5sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * Event handling of OnSelectCell of t1sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t1sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd)
     	{
     		sheetObj.SetCellEditable(NewRow, "del_chk",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",1);
     		sheetObj.SetCellEditable(NewRow, "dpc_val_amt",1);
     		if(sheetObj.GetCellValue(NewRow, "lstm_cd") != "OW"){
     			sheetObj.SetCellEditable(NewRow, "inv_no",1);
     		}
     		sheetObj.SetCellEditable(NewRow, "curr_cd",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_bil_amt",1);
//     		sheetObj.SetCellEditable(NewRow, "ttl_lss_cfm_flg",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_dtl_sts_cd",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",1);
     	}else{
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",0);
     		sheetObj.SetCellEditable(NewRow, "dpc_val_amt",0);
     		sheetObj.SetCellEditable(NewRow, "inv_no",0);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",0);
     		//sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =false;
//     		sheetObj.SetCellEditable(NewRow, "ttl_lss_cfm_flg",0);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_dtl_sts_cd",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",0);
     	}
		var logOfcCd=document.form.log_ofc_cd.value;
	}
	/**
	 * Event handling of OnSelectCell of t2sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t2sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd)
     	{
     		sheetObj.SetCellEditable(NewRow, "del_chk",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",1);
     		sheetObj.SetCellEditable(NewRow, "dpc_val_amt",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_n3pty_tp_cd",1);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_bil_amt",1);
     		sheetObj.SetCellEditable(NewRow, "n3pty_no",1);
     		sheetObj.SetCellEditable(NewRow, "bank_nm",1);
     		sheetObj.SetCellEditable(NewRow, "bank_acct_no",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",1);
     		var ttlLssN3ptyTpCd=sheetObj.GetCellValue(NewRow, "ttl_lss_n3pty_tp_cd");
    		//service provider
    		if(ttlLssN3ptyTpCd == "O") {
    			sheetObj.SetCellEditable(NewRow, "payer_code",0);
    			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",1);
    		}else if(ttlLssN3ptyTpCd == "N") {
    			sheetObj.SetCellEditable(NewRow, "payer_code",0);
    			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
    		}else{
    			sheetObj.SetCellEditable(NewRow, "payer_code",1);
    			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
    		}
     	}else{
     		sheetObj.SetCellEditable(NewRow, "del_chk",0);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",0);
     		sheetObj.SetCellEditable(NewRow, "dpc_val_amt",0);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_n3pty_tp_cd",0);
     		sheetObj.SetCellEditable(NewRow, "payer_code",0);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",0);
     		//sheetObj.CellEditable(NewRow, "ttl_lss_bil_amt") =false;
     		sheetObj.SetCellEditable(NewRow, "n3pty_no",1);
     		sheetObj.SetCellEditable(NewRow, "bank_nm",1);
     		sheetObj.SetCellEditable(NewRow, "bank_acct_no",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",0);
     	}
     	var ttlLssN3ptyTpCd=sheetObj.GetCellValue(NewRow, "ttl_lss_n3pty_tp_cd");
		//service provider
		if(ttlLssN3ptyTpCd == "O") {
			sheetObj.SetCellEditable(NewRow, "payer_code",0);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",1);
		}else if(ttlLssN3ptyTpCd == "N") {
			sheetObj.SetCellEditable(NewRow, "payer_code",0);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
		}else{
			sheetObj.SetCellEditable(NewRow, "payer_code",1);
			sheetObj.SetCellEditable(NewRow, "respb_ofc_cd",0);
		}
    }
	/**
	 * Event handling of OnSelectCell of t3sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     	if(HOOfc==currOfcCd)
     	{
     		sheetObj.SetCellEditable(NewRow, "del_chk",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",1);
     		sheetObj.SetCellEditable(NewRow, "disp_no",1);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_bil_amt",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",1);
     		var ttlLssBilAmt=sheetObj.GetCellValue(NewRow, "ttl_lss_bil_amt");
			//service provider
			if(ttlLssBilAmt == "" || ttlLssBilAmt == "0") {
				sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",1);
			}else{
				sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",0);
			}
     	}else{
     		sheetObj.SetEditable(0);
     	}
	 }
	/**
	 * Event handling of OnSelectCell of t4sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t4sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     		sheetObj.SetCellEditable(NewRow, "del_chk",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",1);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",1);
     		sheetObj.SetCellEditable(NewRow, "csr_no",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_expn_amt",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",1);
	}
	/**
	 * Event handling of OnSelectCell of t5sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function t5sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
     		sheetObj.SetCellEditable(NewRow, "del_chk",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_yd_cd",1);
     		sheetObj.SetCellEditable(NewRow, "dpc_val_amt",1);
     		sheetObj.SetCellEditable(NewRow, "inv_no",1);
     		sheetObj.SetCellEditable(NewRow, "curr_cd",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_plc_nm",1);
     		sheetObj.SetCellEditable(NewRow, "ttl_lss_expn_amt",1);
     		sheetObj.SetCellEditable(NewRow, "dtl_rmk",1);
	}
	/**
	 * Event handling of OnSearchEnd of sheet3
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateCollectionSum();
	}
	/**
	 * Event handling of OnSearchEnd of sheet4
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
		for(var j=sheetObj.HeaderRows(); j<=sheetObj.LastRow(); j++) {
			sheetObj.SetToolTipText(j,"mnr_sts_rmk",sheetObj.GetCellValue(j,"mnr_sts_rmk"));
		}
	}
	/**
	 * Event handling of OnChange of sheet4
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{String}	ErrMsg
	 */
	function sheet4_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col)  == "mnr_sts_rmk"){
			sheetObj.SetToolTipText(Row,"mnr_sts_rmk",sheetObj.GetCellValue(Row,"mnr_sts_rmk"));
		}
	}
	/**
	 * Event handling of OnPopupClick of t2sheet1
	 * Calling pop-up of Payer Code, Responsible, OFC
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "ttl_lss_bil_dt"){
			var cal=new ComCalendarGrid();
        	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
		} else {
			var ttlLssN3ptyTpCd=sheetObj.GetCellValue(Row, "ttl_lss_n3pty_tp_cd");
			//service provider
			if(ttlLssN3ptyTpCd == "S") {
				ComOpenPopup("/opuscntr/COM_ENS_0C1.do", 700, 450, 'setServiceProvider', '1,0', true);
			//coustomer
			} else if(ttlLssN3ptyTpCd == "C") {
				ComOpenPopup("/opuscntr/COM_ENS_041.do", 770, 520, 'setCustomer', '1,0', true);
			} else if(ttlLssN3ptyTpCd == "O") {
				ComOpenPopup("/opuscntr/COM_ENS_071.do", 770, 450, 'setCOM_ENS_071', '1,0', true);
			}
		}
	}
	/**
	 * Event handling of OnChange of t1sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Close Type
			else if(colname == 'ttl_lss_cmpl_cd') {
				if(sheetObj.GetCellValue(Row,Col) != ""){
					if(sheetObj.GetCellValue(Row,"ttl_lss_cmpl_dt") == ""){
						sheetObj.SetCellValue(Row,"ttl_lss_cmpl_dt",ComGetNowInfo("ymd"),0);
					}
				} else {
					sheetObj.SetCellValue(Row,"ttl_lss_cmpl_dt","",0);
				}
			}
		}
	}
	/**
	 * Event handling of OnChange of t2sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//RES_OFC
			else if(colname == 'respb_ofc_cd') {
				setOfficeInfo(sheetObj,Row, Col, Value);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Payer Type
			else if(colname=='ttl_lss_n3pty_tp_cd'){
				var payerCode=sheetObj.GetCellValue(Row, "payer_code");
				if(payerCode != '') {
					if(!ComShowCodeConfirm("MNR00192")) {
						sheetObj.ReturnCellData(Row,Col);
					    return;
					}
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
				}
				if(Value=="O")
				{
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else if(Value=="N") {
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else{
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",1);
				}
			}
			//Pay Amount
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t3sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Disposal Amt
			else if(colname == 'ttl_lss_bil_amt') {
				setCalculateTotalSum();
			}
			//Disposal Plan Amt
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t4sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Scrapping Income AMT
			else if(colname == 'ttl_lss_incm_amt') {
				setCalculateTotalSum();
			}
			//Scrapping Cost AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnChange of t5sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
			}
			//Yard Cd
		 	else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
		 	}
			//Request AMT
			else if(colname == 'ttl_lss_expn_amt') {
				setCalculateTotalSum();
			}
		}
	}
	/**
	 * Event handling of OnClick of t1sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t1sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		var newSeq=1;
		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
			with(sheetObjects[7]){
				if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
					sheetObjects[7].SetRowHidden(x,0);
				} else {
					sheetObjects[7].SetRowHidden(x,1);
				}
			}
		}
    }
	/**
	 * Event handling of OnClick of t2sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t2sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		var newSeq=1;
		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
			with(sheetObjects[7]){
				if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
					sheetObjects[7].SetRowHidden(x,0);
				} else {
					sheetObjects[7].SetRowHidden(x,1);
				}
			}
		}
    }
	/**
	 * Event handling of OnClick of t3sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t3sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		var newSeq=1;
		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
			with(sheetObjects[7]){
				if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
					sheetObjects[7].SetRowHidden(x,0);
				} else {
					if(GetCellValue(x,"type") != "OTS"){
						sheetObjects[7].SetRowHidden(x,1);
					}
				}
			}
		}
    }
	/**
	 * Event handling of OnClick of t4sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t4sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		var newSeq=1;
		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
			with(sheetObjects[7]){
				if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
					sheetObjects[7].SetRowHidden(x,0);
				} else {
					sheetObjects[7].SetRowHidden(x,1);
				}
			}
		}
    }
	/**
	 * Event handling of OnClick of t5sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function t5sheet1_OnClick(sheetObj,Row,Col,Value)
    {
		var dtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		currTtlLssNo=sheetObj.GetCellValue(Row,"ttl_lss_no");
		currTtlLssDtlSeq=sheetObj.GetCellValue(Row,"ttl_lss_dtl_seq");
		var newSeq=1;
		for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
			with(sheetObjects[7]){
				if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
					sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
					sheetObjects[7].SetRowHidden(x,0);
				} else {
					sheetObjects[7].SetRowHidden(x,1);
				}
			}
		}
    }
	/**
	 * Event handling of OnPoupClick of t5sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
    function t5sheet1_OnPopupClick(sheetObj, Row,Col,Value){
		 var formObject=document.form;
		   with(sheetObj) {
				var sName=ColSaveName(Col);
	        	switch (sName) {
					case "cr_end_dt":
					 var cal=new ComCalendarGrid("myCal");
				      cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
					break;
				}
	 		}
	}
	/**
	 * Event handling of OnChange of sheet3
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet3_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
 			var cltTotal=0;
			//Request AMT
			if(colname == 'clt_amt') {
				if(beforetab == 2){
					var amt = 0.00;
					for(var i=1; i<=sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i, "ttl_lss_dtl_seq") == currTtlLssDtlSeq ){
							amt = amt + sheetObj.GetCellValue(i, "clt_amt");
						}
					}
					sheetObjects[4].SetCellValue(sheetObjects[4].GetSelectRow(), "ttl_lss_bil_amt", amt, 0);
				}
				setCalculateCollectionSum();
			}
		}
	}
	function sheet2_OnDblClick(sheetObj,Row,Col)
    {
		var formObj=document.form;
		with(sheetObj){
			//Initializing
			formObj.search_ttl_lss_no.value=GetCellValue(Row,"ttl_lss_no");				//TLL NO
			formObj.ttl_lss_no.value=GetCellValue(Row,"ttl_lss_no"); 				//TLL NO
			formObj.ttl_lss_no_text.value=GetCellValue(Row,"ttl_lss_no");			//TLL NO
			formObj.rqst_ofc_cd.value=GetCellText(Row,"rqst_ofc_cd");			//REQ OFC
			formObj.rqst_ofc_cd_nm.value=GetCellText(Row,"rqst_ofc_cd");			//REQ OFC
			formObj.apro_ofc_cd.value=GetCellValue(Row,"apro_ofc_cd"); 			//APP OFC
			formObj.mnr_sts_ref_no.value=GetCellValue(Row,"mnr_sts_ref_no");   	    //History key
			var rqstDt=GetCellValue(Row,"rqst_dt");
			if(rqstDt.length>=8)
			{
				rqstDt=rqstDt.substring(0,4)+ "-" + rqstDt.substring(4,6)+ "-" + rqstDt.substring(6,8);
			}else{
				rqstDt="";
			}
			formObj.rqst_dt.value=GetCellValue(Row,"rqst_dt"); 				//REQ DT
			formObj.rqst_dt_text.value=rqstDt; 			//REQ DT
			formObj.ttl_lss_sts_cd.value=GetCellValue(Row,"ttl_lss_sts_cd");  		//Status
			formObj.ttl_lss_sts_cd_nm.value=GetCellText(Row,"ttl_lss_sts_cd");  	//Status
//			formObj.ttl_lss_rsn_cd.value=GetCellValue(Row,"ttl_lss_rsn_cd");  		//Main Reason
//			ttl_lss_dtl_rsn_cd.value=GetCellValue(Row,"ttl_lss_dtl_rsn_cd"); 		//Sub Reason
			var ttlLssDt=GetCellValue(Row,"ttl_lss_dt");
			if(ttlLssDt.length>=8)
			{
				ttlLssDt=ttlLssDt.substring(0,4)+ "-" + ttlLssDt.substring(4,6)+ "-" + ttlLssDt.substring(6,8);
			}else{
				ttlLssDt="";
			}
			formObj.ttl_lss_dt.value=GetCellValue(Row,"ttl_lss_dt"); 				//TLL DT
			formObj.ttl_lss_dt_text.value=ttlLssDt; 			//TLL DT
			formObj.apro_ofc_cd_nm.value=GetCellText(Row,"apro_ofc_cd"); 		//APP OFC
			formObj.respb_ofc_cd.value=GetCellValue(Row,"respb_ofc_cd");   	//Responsible\nOFC
			formObj.ttl_lss_cfm_dt.value=GetCellValue(Row,"ttl_lss_cfm_dt");   	//Close Date
			uploadFileSeq=GetCellValue(Row,"file_seq");                        //FILE SEQ
			formObj.file_seq.value=GetCellValue(Row,"file_seq");   	//FILE SEQ
    		ttl_lss_rsn_cd.SetSelectCode(GetCellValue(Row,"ttl_lss_rsn_cd"));
    		ttl_lss_dtl_rsn_cd.SetSelectCode(GetCellValue(Row,"ttl_lss_dtl_rsn_cd"));
			if(MnrNullToBlank(formObj.search_ttl_lss_no.value) != ""){
	        	tabObjects[0].SetSelectedIndex(0);
				if(formObj.apro_ofc_cd_nm.value==currOfcCd)
	        	{
					if(formObj.ttl_lss_sts_cd.value=="HE")
					{
						formObj.respb_ofc_cd.readOnly=true;
						formObj.respb_ofc_cd.className="input2";
			    		ttl_lss_rsn_cd.SetEnable(1);
			    		ttl_lss_dtl_rsn_cd.SetEnable(1);
						ComBtnDisable("btn_Complete");
						ComBtnDisable("btn_cfm_dt");
					}
					else
					{
						formObj.respb_ofc_cd.readOnly=false;
			    		ttl_lss_rsn_cd.SetEnable(1);
			    		ttl_lss_dtl_rsn_cd.SetEnable(1);
						formObj.respb_ofc_cd.className="input";
						ComBtnEnable("btn_Complete");
						ComBtnEnable("btn_cfm_dt");
					}
	        	}else{
					formObj.respb_ofc_cd.readOnly=true;
		    		ttl_lss_rsn_cd.SetEnable(0);
		    		ttl_lss_dtl_rsn_cd.SetEnable(0);
					formObj.respb_ofc_cd.className="input2";
					ComBtnDisable("btn_Complete");
					ComBtnDisable("btn_cfm_dt");
	        	}
	        	if(formObj.ttl_lss_sts_cd.value=="HE")
	        	{
	        		ComBtnDisable("btn_Delete");
					if(strMnrOfficeLevel=="L1") {
						ComBtnEnable("btn_Save");
					} else {
						ComBtnDisable("btn_Save");
					}
					for(var i=1; i<=5; i++ )
					{
						ComBtnDisable("btn_t"+i+"RowDel");
					}
					ComBtnDisable("btn_Col_Add");
					ComBtnDisable("btn_Col_Delete");
					ComBtnDisable("btn_RowAdd2");
					ComBtnDisable("btn_RowDel2");
					ComBtnDisable("btn_FileAdd");
					ComBtnDisable("btn_FileDel");
					ComBtnDisable("btn_cfm_dt");
	        	} else {
					if(strMnrOfficeLevel == "L1") {
		    			ComBtnEnable("btn_Delete");
	     			} else {
						ComBtnDisable("btn_Delete");
	     			}
					ComBtnEnable("btn_Save");
					for(var i=1; i<=5; i++ )
					{
						ComBtnEnable("btn_t"+i+"RowDel");
					}
					ComBtnDisable("btn_Col_Add");
					ComBtnDisable("btn_Col_Delete");
					ComBtnEnable("btn_RowAdd2");
					ComBtnEnable("btn_RowDel2");
					ComBtnEnable("btn_FileAdd");
					ComBtnEnable("btn_FileDel");
					ComBtnEnable("btn_cfm_dt");
	        	}
				doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
			}
			return;
		}
    }
	/**
	 * Event handling of OnChange of sheet2
	 *
	 * @param {IBSheet}	sheetObj
	 * @param {Int} 	Row
	 * @param {String} 	Col
	 * @return
	 */
	function sheet2_OnChange(sheetObj,Row, Col,Value)
   {
		if(nowLoad==1)
		{
			if(sheetObj.ColSaveName(Col)=="respb_ofc_cd")
			{
				nowLoad=0;
				sheetObj.SelectCell(Row, "respb_ofc_cd", true);
			}
		}else{
			nowLoad=1;
			var formObj=document.form;
			with(sheetObj){
				if(ColSaveName(Col)=="respb_ofc_cd")
				{
					if(GetCellValue(Row,"respb_ofc_cd")=="")return;
					var retArray=null;
					retArray=MnrGeneralCodeCheck(sheetObj,"OFC",GetCellValue(Row,"respb_ofc_cd"));
					if(retArray == null){
						ComShowCodeMessage("MNR00165",GetCellValue(Row,"respb_ofc_cd"),"OFFICE");
						SelectCell(Row, "respb_ofc_cd", true);
						SetCellValue(Row,"respb_ofc_cd","",0);
						if(formObj.search_ttl_lss_no.value 	== GetCellValue(Row,"ttl_lss_no"))
						{
							formObj.respb_ofc_cd.value="";
							formObj.respb_ofc_nm.value="";
						}
					} else {
						var retArray=retArray[0].split("|");
						if(MnrNullToBlank(ComGetObjValue(formObj.search_ttl_lss_no)) != ""
							&& formObj.search_ttl_lss_no.value 	== GetCellValue(Row,"ttl_lss_no"))
						{
							formObj.respb_ofc_cd.value=retArray[0];
							formObj.respb_ofc_nm.value=retArray[1];
						}
					}
				}
			}
		}
		nowLoad=0;
   }
	/**
	 * Event handling of OnPopupClick of sheet2
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
       if (sheetObj.ColSaveName(Col) != "respb_ofc_cd") return;
       ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_Sheet2_COM_ENS_071', '0,1', true);
	}
	/**
	 * Event handling of OnPopupClick of sheet3
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet3_OnPopupClick(sheetObj, row,col){
        if (sheetObj.ColSaveName(col) != "clt_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, row, col, 'yyyy-MM-dd');
    }
	/**
	 * Event handling of OnPopupClick of sheet4
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet4_OnPopupClick(sheetObj,Row,Col){
        if (sheetObj.ColSaveName(Col) != "mnr_sts_dt") return;
        var cal=new ComCalendarGrid();
        cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	/**
	 * Showing result message after saving
	 * @param	{IBSheet}	sheetObj	target object
	 * @param	{String}	ErrMsg
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){
		if (ErrMsg == "") {
			if(actionType == "IBSAVE"){
				ComShowCodeMessage("MNR00153");
			} else if(actionType == "COMPLETE") {
				ComShowCodeMessage("MNR00306");
			} else {
				ComShowCodeMessage("MNR00020");
			}
		}
	}
	//Responsible\nOFC Check
	function respb_ofc_cd_Check(){
		nowLoad=1;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.respb_ofc_cd.value," ")!="")
		{
			var retArray=MnrGeneralCodeCheck(sheetObj,"OFC",formObj.respb_ofc_cd.value);
		    var Row=sheetObjects[1].FindText("ttl_lss_no", formObj.search_ttl_lss_no.value);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",formObj.respb_ofc_cd.value,"OFFICE");
				sheetObjects[1].SetCellValue(Row,"respb_ofc_cd","",0);
				formObj.respb_ofc_cd.value="";
				formObj.respb_ofc_nm.value="";
				ComSetFocus(formObj.respb_ofc_cd);
				nowLoad=0;
				return false;
			} else {
				var retArray=retArray[0].split("|");
				sheetObjects[1].SetCellValue(Row,"respb_ofc_cd",retArray[0],0);
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) != "")
				{
					formObj.respb_ofc_cd.value=retArray[0];
					formObj.respb_ofc_nm.value=retArray[1];
				}
			}
		}
		nowLoad=0;
		return true;
	}
	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
		retArray=MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);
		if(retArray == null){
			return false;
		} else {
			return true;
		}
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
				in_search_dt_tp.RemoveAll();
				in_search_dt_tp.SetEditFontBold(1);
				in_search_dt_tp.InsertItem(0, "Request DT","R");
				in_search_dt_tp.InsertItem(1, "Confirm DT","C");
//				in_search_dt_tp.SetSelectCode("R",false);				
				in_ofc_cd_tp.RemoveAll();
				in_ofc_cd_tp.SetEditFontBold(1);
				in_ofc_cd_tp.InsertItem(0, "APP OFC","A");
				in_ofc_cd_tp.InsertItem(1, "REQ/RES OFC ","R");
//				in_ofc_cd_tp.SetSelectCode("R",false);
				in_status_tp.RemoveAll();
				in_status_tp.InsertItem(0, "Processing","P");
				in_status_tp.InsertItem(1, "Complete ","C");
//				in_status_tp.SetSelectCode("P",false);				
				//Combo data of sheet retrieving and setting
				setSheetCombo(sheetObj);
				formObj.reset();
				//Value setting of initialize
	    		formObj.in_ttl_lss_no.value="";
				//TLL No
				formObj.ttl_lss_no.value="";
//				document.form.t1LossTotal.value="";     //Loss Total
//				document.form.t1RecPlnTotal.value="";   //Recovery Plan Total
//				document.form.t1BalanceTotal.value="";  //Balance Total
				var toDay=ComGetNowInfo("ymd");
				formObj.respb_ofc_cd.readOnly=true;
				formObj.respb_ofc_cd.className="input2";
				formObj.ttl_lss_cfm_dt.value=toDay;
				//Value setting of initialize
				var oneYear=ComGetDateAdd(toDay, "Y", -1);
				ComSetObjValue(formObj.in_st_dt,oneYear);
				ComSetObjValue(formObj.in_end_dt,toDay);
				uploadFileSeq="";
				historyMnrStsRefNo="";
	        	if(HOOfc!=currOfcCd)
	        	{
	        		sheetObjects[1].SetEditable(0);
	        	}
	    		MnrWaitControl(false);
//				ComBtnDisable("btn_t1InvoicePreview");
    			ComBtnDisable("btn_Col_Add");
    			ComBtnDisable("btn_Col_Delete");
				sheetObj.SetWaitImageVisible(1);
	    		nowLoad=0;
	    		// Main Reason Combo Initializing
	    		var sCondition=new Array (
	    				new Array("MnrGenCd","TR", "COMMON")		//Main Reason
	    		)
	    		var comboList=MnrComSearchCombo(sheetObj,sCondition);
	    		if(comboList[0] != null){
	    			for(var j=0; j < comboList[0].length;j++){
	    				var tempText=comboList[0][j].split("|");
	    				ttl_lss_rsn_cd.InsertItem(j, tempText[1] ,tempText[0]);
	    			}
	    		}
	    		in_search_dt_tp.SetSelectIndex(0);
	    		in_ofc_cd_tp.SetSelectIndex(1);
	    		in_status_tp.SetSelectIndex(0);
	    		ttl_lss_rsn_cd.SetEnable(0);
	    		ttl_lss_dtl_rsn_cd.SetEnable(0);
	    		break;
        	//Retrieving
            case IBROWSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    	    		// Initializing all sheet
    	    		for (var i=2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    				formObj.f_cmd.value=SEARCH;
					//Retrieving multi data
    				var sXml=sheetObj.GetSearchData("EES_MNR_0098GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					for(var i=0; i < arrXml.length; i++){
						if(i == 6){
							var tempStr=arrXml[i];
							tempStr=tempStr.replace(/<TR>/g,'<TR HIDDEN="TRUE">');
							arrXml[i]=tempStr;
						}
						if(i == 0){
							sheetObjects[0].LoadSearchData(arrXml[i],{Sync:1} );
						} else {
							sheetObjects[i + 1].LoadSearchData(arrXml[i],{Sync:1} );
						}
					}
					tabObjects[0].SetSelectedIndex(0);
					if((sheetObj.RowCount() - sheetObj.RowCount("D")) > 0){
						sheetObjects[2].SelectCell(1,2);
						var dtlSeq=sheetObjects[2].GetCellValue(1,"ttl_lss_dtl_seq");
						currTtlLssNo=sheetObjects[2].GetCellValue(1,"ttl_lss_no");
						currTtlLssDtlSeq=sheetObjects[2].GetCellValue(1,"ttl_lss_dtl_seq");
						var newSeq=1;
						for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
							with(sheetObjects[7]){
								if(GetCellValue(x,"ttl_lss_dtl_seq") == dtlSeq){
									sheetObjects[7].SetCellValue(x,"seq",newSeq++,0);
									sheetObjects[7].SetRowHidden(x,0);
								} else {
									sheetObjects[7].SetRowHidden(x,1);
								}
							}
						}
					} else {
						for(var x=1 ; x <= sheetObjects[7].RowCount();x++){
							sheetObjects[7].SetRowHidden(x,1);
						}
						currTtlLssNo="";
						currTtlLssDtlSeq="";
					}
	            }
                break;
            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
    				formObj.f_cmd.value=SEARCH01;
    	    		// Initializing all sheet
    	    		for (i=2; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    				formObj.search_ttl_lss_no.value="";   //TLL NO
    				formObj.ttl_lss_no.value="";   //TLL NO
    				formObj.ttl_lss_no_text.value="";	//TLL NO
    				formObj.rqst_ofc_cd_nm.value="";	//REQ OFC
    				formObj.rqst_dt_text.value=""; 	//REQ DT
    				formObj.ttl_lss_sts_cd_nm.value="";  	//Status
    				//ttl_lss_rsn_cd.SetSelectIndex(0);
                    formObj.ttl_lss_dtl_rsn_cd.code="";
    				formObj.ttl_lss_dt_text.value=""; 	//TLL DT
    				formObj.apro_ofc_cd_nm.value=""; 	//APP OFC
    				formObj.respb_ofc_cd.value="";   //Responsible\nOFC
    				formObj.respb_ofc_cd.readOnly=true;
    				formObj.respb_ofc_cd.className="input2";
					formObj.rhq_ofc_cd.value=rhqOfcCd;
					ttl_lss_rsn_cd.SetSelectCode("");
		    		ttl_lss_rsn_cd.SetEnable(0);
		    		//ttl_lss_dtl_rsn_cd.SetEnable(0);
					sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("EES_MNR_0098GS.do", sParam);
				    sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
	            }
                break;
            //Saving
            case IBSAVE:
    			if(nowLoad != 0) return;
    			nowLoad=1;
            	if(validateForm(sheetObj,formObj,sAction)) {
            		formObj.f_cmd.value=MULTI;
            		formObj.file_seq.value=uploadFileSeq;
					if(sheetObjects[6].RowCount()> 0){
						formObj.ttl_lss_sts_cd.value="HC";
					} else {
						formObj.ttl_lss_sts_cd.value="HA";
					}
					setRowStausByRequest();  //Occurring saving event
					setCloseTypeAndDate();   //Close Type Close Date - Copying each sheet
					if(actionType == "COMPLETE")
					{
						formObj.ttl_lss_sts_cd.value="HE";
						formObj.ttl_lss_cfm_dt.value=ComGetNowInfo("ymd");   //Close Date
					}
					//var sParam = ComGetSaveString(sheetObjects);
					tabObjects[0].SetSelectedIndex(0);
					var sParam1=sheetObjects[2].GetSaveString(true, true);
					if(sParam1=="" && sheetObjects[2].RowCount()>0)
					{
						nowLoad=0;
						return;
					}
					tabObjects[0].SetSelectedIndex(1);
					var sParam2=sheetObjects[3].GetSaveString(true, true);
					if(sParam2=="" && sheetObjects[3].RowCount()> 0)
					{
						nowLoad=0;
						return;
					}
					if(sheetObjects[3].IsDataModified()){
						for(var i=sheetObjects[3].HeaderRows();i<=sheetObjects[5].LastRow();i++)
						{
							var checkValue2=ComTrimAll(sheetObjects[3].GetCellValue(i, "bank_nm")," ");
							if(checkValue1=="" && checkValue2=="")
							{
								ComShowCodeMessage("MNR00172","Bank Name");
								sheetObjects[3].SelectCell(i, "bank_nm",true);
								nowLoad=0;
								return false;
							}
							var checkValue2=ComTrimAll(sheetObjects[3].GetCellValue(i, "bank_acct_no")," ");
							if(checkValue1=="" && checkValue2=="")
							{
								ComShowCodeMessage("MNR00172","Bank Account");
								sheetObjects[3].SelectCell(i, "bank_acct_no",true);
								nowLoad=0;
								return false;
							}
						}
					}
					tabObjects[0].SetSelectedIndex(2);
					var sParam3=sheetObjects[4].GetSaveString(true, true);
					if(sParam3=="" && sheetObjects[4].RowCount()> 0)
					{
						nowLoad=0;
						return;
					}
					tabObjects[0].SetSelectedIndex(3);
					var sParam4=sheetObjects[5].GetSaveString(true, true);
					if(sParam4=="" && sheetObjects[5].RowCount()> 0)
					{
						nowLoad=0;
						return;
					}
					if(sheetObjects[5].IsDataModified()){
						for(var i=sheetObjects[5].HeaderRows();i<=sheetObjects[5].LastRow();i++)
						{
							var checkValue1=ComTrimAll(sheetObjects[5].GetCellValue(i, "ttl_lss_incm_amt")," ");
							var checkValue2=ComTrimAll(sheetObjects[5].GetCellValue(i, "ttl_lss_expn_amt")," ");
							if(checkValue1=="" && checkValue2=="")
							{
								ComShowCodeMessage("MNR00172","at least one item amoung Scrapping Income AMT or Scrapping Cost Amt");
								sheetObjects[5].SelectCell(i, "ttl_lss_incm_amt",true);
								nowLoad=0;
								return false;
							}
						}
					}
					tabObjects[0].SetSelectedIndex(4);
					var sParam5=sheetObjects[6].GetSaveString(true, true);
					if(sParam5=="" && sheetObjects[6].RowCount()> 0)
					{
						nowLoad=0;
						return;
					}
					//Total Loss Collection
					var sParam6=sheetObjects[7].GetSaveString(true, true);
					sParam6=ComSetPrifix(sParam6,"coll_");
					// Total Loss History
					var sParam7=sheetObjects[8].GetSaveString(true, true);
					sParam7=ComSetPrifix(sParam7,"statusHistory_");
					formObj.file_seq.value=uploadFileSeq;
					var sParam=FormQueryString(formObj) +"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6 +"&"+ sParam7;
				    if (sParam == "")
				    {
						nowLoad=0;
				    	return;
				    }
				    
				    sSaveRtnXml=sheetObjects[1].GetSaveData("EES_MNR_0098GS.do", sParam);
				    sheetObjects[1].LoadSaveData(sSaveRtnXml);
					if(MnrComGetErrMsg(sSaveRtnXml) == null){
						var ttlLssNo=ComGetEtcData(sSaveRtnXml, "totalLossNo");
						var targetRow=0;
						with(sheetObjects[1]){
							for(var j=2; j <= LastRow();j++){
								if(GetCellValue(j,"ttl_lss_no") == ttlLssNo){
									targetRow=j;
								}
							}
						}
						if(targetRow != 0){
							sheetObjects[1].SelectCell(targetRow,1);
							formObj.search_ttl_lss_no.value=ttlLssNo;
							formObj.ttl_lss_no.value=ttlLssNo;
							if(MnrNullToBlank(formObj.search_ttl_lss_no.value) != ""){
								doActionIBSheet(sheetObjects[0],formObj,IBROWSEARCH);
							}
						}else{
		    				formObj.search_ttl_lss_no.value="";   //TLL NO
		    				formObj.ttl_lss_no.value="";   //TLL NO
		    				formObj.ttl_lss_no_text.value="";	//TLL NO
		    				formObj.rqst_ofc_cd_nm.value="";	//REQ OFC
		    				formObj.rqst_dt_text.value=""; 	//REQ DT
		    				formObj.ttl_lss_sts_cd_nm.value="";  	//Status
		    				ttl_lss_rsn_cd.SetSelectCode("");//Main Reason
		    				ttl_lss_dtl_rsn_cd.SetSelectCode("");//Sub Reason
				    		ttl_lss_rsn_cd.SetEnable(0);
				    		ttl_lss_dtl_rsn_cd.SetEnable(0);
		    				formObj.ttl_lss_dt_text.value=""; 	//TLL DT
		    				formObj.apro_ofc_cd_nm.value=""; 	//APP OFC
		    				formObj.respb_ofc_cd.value="";   //Responsible\nOFC
		    				formObj.respb_ofc_cd.readOnly=true;
		    				formObj.respb_ofc_cd.className="input2";
		    				formObj.tCollectionTotal.value="";   //Total Collection
//		    				formObj.t1RecPlnTotal.value="";   //Recovery Plan Total
//		    				formObj.t1LossTotal.value="";   //Loss Total
//		    				formObj.t1BalanceTotal.value="";   //Balance Total
		    	    		// Initializing all sheet
		    	    		for (i=2; i < sheetObjects.length; i++) {
		    	    			sheetObjects[i].RemoveAll();
		    	    		}
						}
					}
            	}
    			nowLoad=0;
                break;
            //Deleting
            case IBSEARCHAPPEND:
            	if(validateForm(sheetObj,formObj,sAction)) {
					actionType="IBSEARCHAPPEND";
            		formObj.f_cmd.value=REMOVE;
            		setRowStausByRequest();  //Occurring saving event
					var sParam1=sheetObjects[2].GetSaveString(true, true);
					if(sParam1 == "" && sheetObjects[2].IsDataModified()){
							return;
					}
					var sParam2=sheetObjects[3].GetSaveString(true, true);
					if(sParam2 == "" && sheetObjects[3].IsDataModified()){
							return;
					}
					var sParam3=sheetObjects[4].GetSaveString(true, true);
					if(sParam3 == "" && sheetObjects[4].IsDataModified()){
							return;
					}
					var sParam4=sheetObjects[5].GetSaveString(true, true);
					if(sParam4 == "" && sheetObjects[5].IsDataModified()){
							return;
					}
					var sParam5=sheetObjects[6].GetSaveString(true, true);
					if(sParam5 == "" && sheetObjects[6].IsDataModified()){
							return;
					}
					//Total Loss Collection
					var sParam6=sheetObjects[7].GetSaveString(true, true);
					if(sParam6 == "" && sheetObjects[7].IsDataModified()){
							return;
					}
					sParam6=ComSetPrifix(sParam6,"coll_");
					// Total Loss History
					var sParam7=sheetObjects[8].GetSaveString(true, true);
					sParam7=ComSetPrifix(sParam7,"statusHistory_");
					var sParam=FormQueryString(formObj) +"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6 +"&"+ sParam7;
				    sParam += "&" + FormQueryString(formObj);
				    sSaveRtnXml=sheetObjects[1].GetSaveData("EES_MNR_0098GS.do", sParam);	//Retrieving Total Loss No
					//Initializing form value
					formObj.rqst_ofc_cd.value="";
					formObj.rqst_dt.value="";
					formObj.ttl_lss_sts_cd.value="";
					formObj.ttl_lss_rsn_cd.value="";
					formObj.ttl_lss_dtl_rsn_cd.value="";
					formObj.ttl_lss_dt.value="";
					formObj.apro_ofc_cd.value="";
					formObj.ttl_lss_no.value="";
					formObj.mnr_sts_ref_no.value="";
    				formObj.search_ttl_lss_no.value="";   //TLL NO
    				formObj.ttl_lss_no_text.value="";	//TLL NO
    				formObj.rqst_ofc_cd_nm.value="";	//REQ OFC
    				formObj.rqst_dt_text.value=""; 	//REQ DT
    				formObj.ttl_lss_sts_cd_nm.value="";  	//Status
    				ttl_lss_rsn_cd.SetSelectCode("");//Main Reason
    				ttl_lss_dtl_rsn_cd.SetSelectCode("");//Sub Reason
		    		ttl_lss_rsn_cd.SetEnable(0);
		    		ttl_lss_dtl_rsn_cd.SetEnable(0);
    				formObj.ttl_lss_dt_text.value=""; 	//TLL DT
    				formObj.apro_ofc_cd_nm.value=""; 	//APP OFC
    				formObj.respb_ofc_cd.value="";   //Responsible\nOFC
    				formObj.respb_ofc_cd.readOnly=true;
    				formObj.respb_ofc_cd.className="input2";
    				formObj.tCollectionTotal.value="";   //Total Collection
//    				formObj.t1RecPlnTotal.value="";   //Recovery Plan Total
//    				formObj.t1LossTotal.value="";   //Loss Total
//    				formObj.t1BalanceTotal.value="";   //Balance Total
					// Initializing all sheet
    	    		for (i=0; i < sheetObjects.length; i++) {
    	    			sheetObjects[i].RemoveAll();
    	    		}
    	    		sheetObjects[1].LoadSaveData(sSaveRtnXml);
            	}
                break;
			case IBINSERT:
				if(validateForm(sheetObj,formObj,sAction)) {
					var Row="";
					if (sheetObj.id == 'sheet3') {
						if(currTtlLssDtlSeq != ""){
							Row=sheetObj.DataInsert(-1);
							var seq=MnrGetViewRowCntCLT(sheetObj,currTtlLssDtlSeq);
							sheetObj.SetCellValue(Row, "seq",seq,0);
							sheetObj.SetCellValue(Row, "type","Manual",0);
							sheetObj.SetCellValue(Row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
							sheetObj.SetCellValue(Row, "ttl_lss_dtl_seq",currTtlLssDtlSeq,0);
							sheetObj.SetCellValue(Row, "clt_stl_flg","N",0);
							sheetObj.SetCellValue(Row, "clt_ofc_cd",ComGetObjValue(formObj.self_ofc),0);
							sheetObj.SetCellValue(Row, "chk_trns_no","",0);
							sheetObj.SetCellValue(Row, "clt_dt",ComGetNowInfo("ymd","-"),0);
							//Initializing value of sheet combo
							sheetObj.SetCellValue(Row, "curr_cd","USD",0);//CURR
						} else {
							ComShowCodeMessage("MNR00263");
							return;
						}
					} else {
						Row=sheetObj.DataInsert(-1);
						//Setting Total Loss No
						sheetObj.SetCellValue(Row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
						//Setting mnr_inv_tp_cd
						if(sheetObj.id == 't1sheet1') {
							sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DV",0);
						} else if (sheetObj.id == 't2sheet1') {
							sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","TP",0);
						} else if (sheetObj.id == 't3sheet1') {
							sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DS",0);
						} else if (sheetObj.id == 't4sheet1') {
							sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","SC",0);
						} else if (sheetObj.id == 't5sheet1') {
							sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","IR",0);
							sheetObj.SetCellValue(Row, "ttl_lss_plc_nm","",0);
						}
						//Initializing value of sheet combo
						sheetObj.SetCellValue(Row, "curr_cd","USD",0);//CURR
					}
				}
                break;
			case IBDELETE:
			    if(validateForm(sheetObj,formObj,sAction)) {
					if(sheetObj.id != "sheet3"){
						ComRowHideDelete(sheetObj, "del_chk");
					} else {
						MnrRowDelete(sheetObj,"del_chk");
						setCalculateCollectionSum();
					}
				}
				break;
        }
    }
	function MnrGetViewRowCntCLT(sheetObj,dtlSeq){
		var cnt=1;
		for(var i=1 ; i <= sheetObj.RowCount(); i++){
			if(sheetObj.GetRowHidden(i) == false){
				if(sheetObj.GetCellValue(i,"ttl_lss_dtl_seq") == dtlSeq){
					cnt++;
				}
			}
		}
		return cnt;
	}
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        var formObj=document.form;
		with(formObj){
    		if (sAction == IBSEARCH) {
    			// Dataformat
    			if (!ComChkValid(formObj)) {
    				return false;
    			}
    		}
			else if(sAction == IBSAVE) {
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00261");
					return false;
				}
				//responsible Office check
				if(!respb_ofc_cd_Check()) {return false;}
				if(!checkTotalLossfStatus()) {return false;}
				//Mandatory
				if(!checkMandatory(ttl_lss_rsn_cd)) {return false;}
				if(!checkMandatory(ttl_lss_dtl_rsn_cd)) {return false;}
				if(!checkMandatory(formObj.ttl_lss_dt)) {return false;}
				if(!checkMandatory(formObj.apro_ofc_cd)) {return false;}
				//Checking grid row data
				if(!checkIsDetailRow()) {return false;}
				for (var i=2; i <= 6; i++){
					var Row=sheetObjects[i].ColValueDup("rqst_eq_no");
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + "th sheet of " + Row + " row ");
							sheetObjects[i].SelectCell(Row, "rqst_eq_no", true);
							return false;
						}
					}
				}
				var toDay=ComGetNowInfo("ymd");
				if(actionType == "COMPLETE")
				{
					//DV Value
					for(var j=sheetObjects[2].HeaderRows();j <= sheetObjects[2].LastRow()-1;j++)
					{
						if(sheetObjects[2].GetCellValue(j,"ibflag")!= "D" && sheetObjects[2].GetCellValue(j,"seq")!= "0")
						{
							if(sheetObjects[2].GetCellValue(j,"ttl_lss_cmpl_cd") == ""){
								ComShowCodeMessage("MNR00341");
								sheetObjects[2].SelectCell(j,"ttl_lss_cmpl_cd");
								return false;
							} else {
								if(sheetObjects[2].GetCellValue(j,"ttl_lss_cmpl_dt") == ""){
									sheetObjects[2].SetCellValue(j,"ttl_lss_cmpl_dt",toDay,0);
								}
							}
						}
					}
					if (!ComShowCodeConfirm("MNR00275","Total Loss","Complete")){return false;}
				}else if(actionType == "IBSAVE")
				{
					if (!ComShowCodeConfirm("MNR00275","Total Loss","Save")){return false;}
				}
			}
			else if(sAction == IBSEARCHAPPEND) {
				if(MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00260");
					return false;
				}
				if (!ComShowCodeConfirm("MNR00275","Total Loss","Delete")){return false;}
			}
        }
        return true;
    }
    /* ********* User Functions ************* */
	/**
	 * Processing return data of pop-up screen (EES_MNR_0195)
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
    	var formObj=document.form;
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.in_ttl_lss_no.value=aryPopupData[0][4];
		}
	}
	/**
	 * Loss Total : Pay amount sum of DV
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].GetSelectedIndex()+ 1;
       var sheetIndex=2;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount()>0)
			{
				calFlag=true;
				break;
			}
		}
		if(calFlag==true)
		{
		    var tLossTotal=0;
		    var thrdAmtTotal=0;
		    var disposalAmtTotal=0;
		    var disposalPlanAmtTotal=0;
		    var scrapIncomeAmtTotal=0;
            var scrapCostAmtTotal=0;
            var requestAmtTotal=0;
            for(var i=sheetIndex;i<sheetIndex + 5;i++)
            {
			    if(sheetObjects[i].RowCount()>0)
			    {
					for(var j=sheetObjects[i].HeaderRows();j<=sheetObjects[i].LastRow();j++)
					{
						if(sheetObjects[i].GetCellValue(j,"ibflag")!="D" && sheetObjects[i].GetCellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DV"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							tLossTotal=getFloatSumData(tLossTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="TP"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							thrdAmtTotal=getFloatSumData(thrdAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DS"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
							disposalAmtTotal=getFloatSumData(disposalAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
							disposalPlanAmtTotal=getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="SC"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
							scrapIncomeAmtTotal=getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
							scrapCostAmtTotal=getFloatSumData(scrapCostAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							} else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="IR"){
							if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
							requestAmtTotal=getFloatSumData(requestAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
						}
					}
			    }
            }
//            var tempStr=ComAddComma2((tLossTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "LossTotal.value=tempStr;");
//			//Recovery Plan Total(tRecPlnTotal)
//		    var tRecPlnTotal=parseFloat(MnrMakeRound(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)),2));
//			tempStr=ComAddComma2((tRecPlnTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "RecPlnTotal.value=tempStr;");
//			//Balance Total(tBalanceTotal)
//		    var tBalanceTotal=getFloatSumData(tRecPlnTotal,tLossTotal);
//			tempStr=ComAddComma2((tBalanceTotal + ""), "#,###");
//			eval("document.form.t"+ 1 + "BalanceTotal.value=tempStr;");
		}
	}
	/**
	 * @param a  Add value
	 * @param b  Add value
	 * @return sumResult  Result value
	 */
	function getFloatSumData(a,b){
		var aFloat=parseFloat(a + "");
		var bFloat=parseFloat(b + "");
		var sumResult=MnrMakeRound(parseFloat(aFloat + bFloat),2);
		return  parseFloat(sumResult + "");
	}
	/**
	 * Collection Total :Amount sum of Total Loss Collection & Adjustment
	 */
	function setCalculateCollectionSum(){
		var sheetObj=sheetObjects[7];
		var cltTotal=0;
		for(var j=sheetObj.HeaderRows();j<=sheetObj.LastRow();j++)
		{
			if(sheetObj.GetCellValue(j,"ibflag")!="D" && sheetObj.GetCellValue(j,"seq")!="0")
			{
				cltTotal+=parseFloat(sheetObj.GetCellValue(j,"clt_amt"));
			}
		}
		if(sheetObj.RowCount()>0)
		{
			document.form.tCollectionTotal.value=cltTotal;
			ComAddSeparator(document.form.tCollectionTotal, "float");
		}else{
			document.form.tCollectionTotal.value=0;
		}
	}
	/**
	 * Setting and initializing of sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function setSheetCombo(sheetObj) {
		var formObj=document.form;
		//Retrieving sheet
		var sCondition=new Array (
			new Array("MdmCurrency","", "COMMON")		//Currency
			,new Array("MnrGenCd","CD00071", "COMMON")  //The previous state CD00042
			,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00050", "COMMON")  //Total Collection Type
			,new Array("ComIntgCd","CD00809","COMMON")  //Payer Type
			,new Array("MnrGenCd","CD00039", "COMMON")  //Total Loss Status
			,new Array("MnrGenCd","TR", "COMMON")  //Main Reason
			,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
			,new Array("MnrGenCd","CD00072", "COMMON")  //Close Type
			,new Array("MnrGenCd","HOOFC", "COMMON")    //HOOfc Code
			,new Array("MnrGenCd","SELHO","CUSTOM9")	//Eq Kind
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		//Setting sheet
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i < comboList.length; i++) {
			//Initializing each combo of sheets
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault="";
			for(var j=0; j < comboList[i].length; j++){
				var tempText=comboList[i][j].split("|");
				if(i == 8 && j == 0){
					sheetComboText +=  " " + "|";
					sheetComboCode +=  " " + "|";
				}
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(i==9)
				{
					HOOfc=tempText[0];
				}
				if(j == 0){
					sheetComboDefault=tempText[0];
				}
			}
			//Setting combo of sheet of tab
			for(var k=1; k < 8; k++)
			{
				if(i == 0) {
					if(k != 1)
					{
						sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 1) {
					if(k == 2) {
					    sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 2) {
					if(k == 3) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 3) {
					if(k == 7) {
						//sheetObjects[k].InitDataCombo (0, "ttl_lss_clt_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 4) {
					if(k == 7) {
						sheetObjects[k].InitDataCombo (0, "inv_pay_mzd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 5) {
					if(k == 1) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 6) {
					if(k == 1) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_rsn_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 7) {
					if(k == 6) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 8) {
					if(k == 2) {
						sheetObjects[k].InitDataCombo (0, "ttl_lss_cmpl_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				} else if(i == 10){
					if(k != 1 && k != 7 ) {
						sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
					}
				}
			}
		}
	}
	/**
	 * (Responsible Office) Checking existed<br>
	 * @param
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param Value The object is CellValue in case of IBSheet
	 */
	function setOfficeInfo(sheetObj,Row, Col, Value)
	{
		var retArray=null;
		if (Value!="")
		{
		    retArray=MnrGeneralCodeCheck(sheetObj,"OFC",Value);
			if(retArray == null)
			{
				ComShowCodeMessage("MNR00165",Value,"OFFICE");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row,Col,true);
			}
		}
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function setServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].GetSelectRow();
			var vndrSeq=aryPopupData[0][2];
			var vndrNm=aryPopupData[0][4];
			sheetObjects[3].SetCellValue(Row, "payer_code",vndrSeq);
			sheetObjects[3].SetCellValue(Row, "payer_name",vndrNm);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_seq",vndrSeq);
		}
	}
 	/**
	 * function of receiving COM_ENS_071 screen data
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj=document.form;
    	 var Row=sheetObjects[3].GetSelectRow();
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[3].SetCellValue(Row, "respb_ofc_cd",aryPopupData[0][3]);
		 }
    }
	/**
	 * (Customer) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 */
	function setCustomer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[3].GetSelectRow();
			var custCd=aryPopupData[0][3];
			var custNm=aryPopupData[0][4];
			var mnrPrnrCntCd=custCd.substring(0,2);
			var mnrPrnrSeq=custCd.substring(2);
			sheetObjects[3].SetCellValue(Row, "payer_code",custCd);
			sheetObjects[3].SetCellValue(Row, "payer_name",custNm);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_cnt_cd",mnrPrnrCntCd);
			sheetObjects[3].SetCellValue(Row, "mnr_prnr_seq",mnrPrnrSeq);
		}
	}
	 /**
     * Adding row for file upload <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Insert(sheetObj){
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		for(var j=2; j <= sheetObj.LastRow();j++){
			if (sheetObj.GetCellValue(j,"org_file_nm") == ""){
				ComShowMessage(ComGetMsg('MNR00024'));
				sheetObj.SelectCell(j,"org_file_nm");
				return;
			}
		}
		var row=sheetObj.DataInsert(-1);
	}
	 /**
     * Deleting upload file <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @return {nothing}
     **/
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	
	/**
     * Event handling of click of sheet1 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected row
     * @param {ibsheet} Col     	Selected column
     * @param {String} 	Value     	File name
     **/
	function sheet5_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	/**
	 * @return  {Boolean}    true/false
	 */
	function checkTotalLossfStatus() {
		var ttlLssStsCd=document.form.ttl_lss_sts_cd.value; //ttl_lss_sts_cd 
		if(ttlLssStsCd == "HR"){
			ComShowCodeMessage("MNR00208","Total Loss", "Request ");
			return false;
		}
		return true;
	}
	/**
     * Checking mandatory data
     * @param	{Element}	obj : Form element for checking
     */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {
		    ComShowCodeMessage("MNR00003");
		    return false;
		}
		return true;
	}
	/**
	 * In case of saving Checking grid row data
	 */
	function checkIsDetailRow(){
		var cnt=0;
		for (var i=2; i<7; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				cnt++;
			}
		}
		if(cnt<1) { return false}
		return true;
	}
	function setRowStausByRequest(){
		for (var i=2; i < 7; i++) {
			if(sheetObjects[i].RowCount()> 0) {
				for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
					if(sheetObjects[i].GetRowStatus(j)== "R") {
					sheetObjects[i].SetRowStatus(j,"U");
						return;
					}
				}
			}
		}
	}
	/**
	 * Close Type Close Date Copying each sheet
	 */
	function setCloseTypeAndDate(){
		for(var j=sheetObjects[2].HeaderRows(); j <= sheetObjects[2].LastRow(); j++) {
			var Eqno=sheetObjects[2].GetCellValue(j,"rqst_eq_no");
			var cmplCd=sheetObjects[2].GetCellValue(j,"ttl_lss_cmpl_cd");
			var cmplDt=sheetObjects[2].GetCellValue(j,"ttl_lss_cmpl_dt");
			//Excluding DV tab
			for (var i=3; i <= 6; i++) {
				for(var k=sheetObjects[i].HeaderRows(); k <= sheetObjects[i].LastRow(); k++) {
					if(Eqno == sheetObjects[i].GetCellValue(k,"rqst_eq_no")){
						sheetObjects[i].SetCellValue(k,"ttl_lss_cmpl_cd",cmplCd,0);
						sheetObjects[i].SetCellValue(k,"ttl_lss_cmpl_dt",cmplDt,0);
					}
				}
			}
		}
	}
	/**
	 * Resetting value to TP/SZ, DV.Value, Lessor depending EQ Number
	 *
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		//Checking EQ_TYPE
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){
			ComShowCodeMessage("MNR00119");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;
		}
		//Checking existed EQ Number
		var rqstEqNo=sheetObj.GetCellValue(Row, "rqst_eq_no");
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		var totalLossDate=ComGetNowInfo("ymd");
		var retArray=MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		//Retrieving EQ Number
		var formObj=document.form;
		var sCostType="";
		if(eqKndCd == "U"){
			sCostType="MRDRRC";
		} else if(eqKndCd == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr == null){
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd=retArr[0][31];	//TP/SZ
		var dpcValAmt=retArr[0][10];	//DV.Value
		var lessorNm=retArr[0][16];	//Lessor
		var lstmCd=retArr[0][19];	//Term
		var ydCd=retArr[0][18];	//Yard
		//Setting EQ Number
		sheetObj.SetCellValue(Row,"eq_tpsz_cd",eqTpszCd,0);//TP/SZ
		sheetObj.SetCellValue(Row,"lstm_cd",lstmCd,0);//Term
		sheetObj.SetCellValue(Row,"ttl_lss_yd_cd",ydCd,0);//Yard
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm",lessorNm,0);//Lessor
			sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt,0);//Pay Amount
			//In case of not existed invoice number
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
				sheetObj.SetCellValue(Row, "inv_no",invNo);
//			}
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			//In case of not existed invoice number
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"T";
				sheetObj.SetCellValue(Row, "inv_no",invNo);
//			}
		} else if(sheetObj.id == "t3sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			//In case of not existed invoice number
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"S";
				sheetObj.SetCellValue(Row, "inv_no",invNo);
//			}
		} else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
		}
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);//TP/SZ
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm","",0);//Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}
	}
	/**
	 * Adding row of Total Loss History
	 *
	 * @param sheetObj
	 * @return
	 */
	function history_Insert(sheetObj) {
		var Row=sheetObj.DataInsert(-1);
		if(historyMnrStsRefNo=="" || historyMnrStsRefNo==null){
			sheetObj.SetCellValue(Row, "mnr_sts_ref_no","NEW");
		} else {
			sheetObj.SetCellValue(Row, "mnr_sts_ref_no",historyMnrStsRefNo);
		}
		sheetObj.SetCellValue(Row, "mnr_grp_tp_cd","SCR");
		sheetObj.SetCellValue(Row, "mnr_sts_dt",ComGetNowInfo("ymd"));
		sheetObj.SetCellValue(Row, "rqst_ofc_cd",currOfcCd);
		sheetObj.SetCellValue(Row, "cre_usr_id",usrId);
	}
	/**
	 * Deleting row of Total Loss History
	 *
	 * @param sheetObj
	 * @return
	 */
    function history_Remove(sheetObj) {
    	ComRowHideDelete(sheetObj, "del_chk");
    }
	/**
	 * Getting rep_Multiful_inquiry
	 */
	function getMnr_Multi(rowArray,rtn_val) {
		var formObj=document.form;
		var tempText="";
		//Initializing
		formObj.in_ttl_lss_no.value='';
		for(var i=0; i<rowArray.length; i++) {
			var colArray=rowArray[i];
			tempText +=  rowArray[i] + ',';
		}
		//Removing last comma
		tempText=MnrDelLastDelim(tempText);
		tempText=tempText.toUpperCase();
		eval("document.form." + rtn_val + ".value='" + tempText + "';");
	}
	/**
	 * Event handling of Onchange of combo
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function ttl_lss_rsn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){
		//Sub Reason Initializing
		var ttlLssDtlRsnCdObj=ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll();
		ttlLssDtlRsnCdObj.SetSelectCode("");
		//Checking Main Reason
		if(newCode == "A" || newCode == "") {return;}
		//Sub Reason retrieving and setting
		ttlLssDtlRsnCdObj.RemoveAll();
		var sCondition=new Array (
				new Array("MnrGenCd",newCode, "COMMON")
		)
		sheetObjects[0].SetWaitImageVisible(0);
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		sheetObjects[0].SetWaitImageVisible(1);
		for(var j=0; j < comboList[0].length;j++){
			var tempText=comboList[0][j].split("|");
			ttlLssDtlRsnCdObj.InsertItem(j, tempText[1] ,tempText[0]);
		}
		ttlLssDtlRsnCdObj.SetSelectIndex(0);
	}
