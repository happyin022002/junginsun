/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_0095.js
*@FileTitle  : Total Loss Request
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
	/****************************************************************************************
	 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0095 : business script for ees_mnr_0095.
	 */
	function ees_mnr_0095() {
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
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var comboObjects=new Array();
	var comboCnt=0;
	var sheetObjects=new Array();
	var sheetCnt=0;
	//file sequence variable
	var uploadFileSeq="";
	//History Seq variable
	var historyMnrStsRefNo="";
	var sSaveRtnXml="";
	//saving type
	var saveType=1;
	//whether load
	var nowLoad=0;
	var errFlag = "N";
	var preTtlLssStsCd = "";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
		var sheetObject5=sheetObjects[4];
		var sheetObject6=sheetObjects[5];
		var sheetObject7=sheetObjects[6];
		var sheetObject8=sheetObjects[7];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
			case "btn_New":
				doActionIBSheet(sheetObject1,document.form,IBCLEAR,0);
				break;
			case "btn_Save":
				//MEXBA office Estimate could not be created anymore
				if(currOfcCd == "MEXBA"){
					ComShowCodeMessage("MNR00357"); 
					break;
				}
				doActionIBSheet(sheetObject1,document.form,IBSAVE,1);
				break;
			case "btn_Request":
				doActionIBSheet(sheetObject1,document.form,IBSAVE,2);
				break;
			case "btn_Delete":
				doActionIBSheet(sheetObject1,document.form,IBSEARCHAPPEND);
				break;
				//TLL No. PopUp
			case "ttl_lss_no_popup":
				if(!formObject.search_ttl_lss_no.readOnly) {
					ComOpenPopup('/opuscntr/EES_MNR_0195.do', 725, 440, 'setEES_MNR_0195', '0,1,1,1,1,1,1,1,1,1,1,1', true);
				}
				break;
				//RES Office. PopUp
			case "respb_ofc_cd_popup":
				ComOpenPopup("COM_ENS_071.do", 810, 415, 'setPopUpParam_COM_ENS_071', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
				//TLL DT Calendar
			case "ttl_lss_dt_cal":
				var cal=new ComCalendar();
				cal.select(formObject.ttl_lss_dt, 'yyyy-MM-dd');
				break;
				/** (Tab) D.V Expense (S) **/
			case "btn_t1EQAdd":
				ComOpenPopup('/opuscntr/EES_MNR_0097.do', 800, 460, 'setEES_MNR_0097', '1,0', true);
				break;
			case "btn_t1RowAdd":
				doActionIBSheet(sheetObject2,document.form,IBINSERT);
				break;
			case "btn_t1RowDel":
				doActionIBSheet(sheetObject2,document.form,IBDELETE);
				break;
				/** (Tab) D.V Expense (E) **/
				/** (Tab) 3rd Party (S) **/
			case "btn_t2RowAdd":
				doActionIBSheet(sheetObject3,document.form,IBINSERT);
				break;
			case "btn_t2RowDel":
				doActionIBSheet(sheetObject3,document.form,IBDELETE);
				break;
				/** (Tab) 3rd Party (E) **/
				/** (Tab) Disposal (S) **/
			case "btn_t3RowAdd":
				doActionIBSheet(sheetObject4,document.form,IBINSERT);
				break;
			case "btn_t3RowDel":
				doActionIBSheet(sheetObject4,document.form,IBDELETE);
				break;
				/** (Tab) Disposal (E) **/
				/** (Tab) Scrapping (S) **/
			case "btn_t4RowAdd":
				doActionIBSheet(sheetObject5,document.form,IBINSERT);
				break;
			case "btn_t4RowDel":
				doActionIBSheet(sheetObject5,document.form,IBDELETE);
				break;
				/** (Tab) Scrapping (E) **/
				/** (Tab) Insurance (S) **/
			case "btn_t5RowAdd":
				doActionIBSheet(sheetObject6,document.form,IBINSERT);
				break;
			case "btn_t5RowDel":
				doActionIBSheet(sheetObject6,document.form,IBDELETE);
				break;
				/** (Tab) Insurance (E) **/
			case "btn_RowAdd2":
				history_Insert(sheetObject7);
				break;
			case "btn_RowDel2":
				history_Remove(sheetObject7);
				break;
			case "btn_FileAdd":
				file_Insert(sheetObjects[7]);
				break;
			case "btn_FileDel":
				file_Remove(sheetObjects[7]);
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject.
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
		//setting button
		//MnrWaitControl(true);
		nowLoad=1;
		// initializing Axon event
		initControl();
		//initializing IBMultiCombo
		for(var k=0; k < comboObjects.length; k++){
			initCombo(comboObjects[k], k + 1);
		}
		// initializing IBSheet
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		// initializing IBTab
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		//Initializing file upload
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,0);
		//MnrWaitControl(false);
		initUpload();
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
				sParam+= "&file_seq=" + file_seq;    // existing File Sequence
				sParam+= "&file_dtl_seq=" + file_dtl_seq;    // existing File Sequence
				sParam+= "&org_file_nm=" + fileName; // Fileupload file name
				sParam+= "&ibflag=" + ibflag;        // I : initial File Upload U : File change
		 		paramToForm(sParam);
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
	 				if(uploadFileSeq != "" && uploadFileSeq != undefined){
	 					var fileXml=SearchFileUpload(sheetObjects[7],uploadFileSeq);
	 					sheetObjects[7].LoadSearchData(fileXml,{Sync:1} );
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
    function sheet3_OnMouseMove(sheetObj, e) {
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
	 * IBsetting combo basic info
	 * @param	{IBCombo}	comboObj	initializing ComboObject
	 * @param	{Number}	comboNo		ComboObject tag serial number
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
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="||||||||||||";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"respb_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"rqst_dt" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_sts_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_rsn_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_rsn_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dt" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"apro_ofc_cd" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"file_seq" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_ref_no" },
			             {Type:"Text",     Hidden:0,  Width:30,   Align:"Left",    ColMerge:1,   SaveName:"respb_ofc_nm" } ];			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetVisible(false);
	            }
			break;
		case "t1sheet1":
		    with(sheetObj){
			      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Lessor|Invoice No.|CURR|Pay Amount|EQ Status|Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"Float",     Hidden:0,  Width:100,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Combo",     Hidden:0, Width:125,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_cnt_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_prnr_seq" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"n3pty_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_incm_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ar_chk_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"inv_rgst_no" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(162);     
			      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			}
			break;
		case "t2sheet1":
		    with(sheetObj){	        
			      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Payer Type|Payer Code|Payer Name|CURR|3rd Amount|Issue Date|Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
			             {Type:"Float",     Hidden:0,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Combo",     Hidden:0, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_n3pty_tp_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Popup",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"payer_code",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:1,   SaveName:"payer_name",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",      KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_bil_dt",       KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
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
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetImageList(0,"img/btns_search.gif");
			      SetImageList(1,"img/btns_calendar.gif");
			      SetShowButtonImage(2);
			      SetColHidden("dpc_val_amt",1);
			      SetSheetHeight(162);
			      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
			}
			break;
		case "t3sheet1":
		    with(sheetObj){
			      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|Disposal No.|CURR|Disposal AMT|Disposal Plan AMT|Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(162);
			      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            }
			break;
		case "t4sheet1":
		    with(sheetObj){
			      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|CURR|CSR No|Scrapping Income AMT|Scrapping Cost AMT|Remark";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );		
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
			             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(162);
			      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            }
			break;
		case "t5sheet1":
		    with(sheetObj){
				      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|Club Ref No|CURR|Insurance Co.|Request AMT|Notification Date|Remark";
				      var headCount=ComCountHeadTitle(HeadTitle1);
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );			
				      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				      InitHeaders(headers, info);
				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 },
				             {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
				             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_plc_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"AutoSum",   Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_expn_amt",  KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
				             {Type:"PopupEdit", Hidden:0, Width:115,  Align:"Center",  ColMerge:1,   SaveName:"cr_end_dt",         KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dtl_rmk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_seq" },
				             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"mnr_inv_tp_cd" },
				             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csr_no" },
				             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_bil_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				      InitColumns(cols);
				      SetEditable(1);
				      SetColHidden("dpc_val_amt",1);
				      SetShowButtonImage(2);
				      SetSheetHeight(162);
				      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	      }
			break;
		case "sheet2":
		    with(sheetObj){
			      var HeadTitle1="|Sel|Date|Remark(s)|Creation Office|Creation User";
			      var headCount=ComCountHeadTitle(HeadTitle1);
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
			      SetShowButtonImage(2);
			      SetSheetHeight(142);
				}
			break;
		case "sheet3":
		    with(sheetObj){
			      var prefix="";
			      var HeadTitle1="|Evidence Attachment|Evidence Attachment|Evidence Attachment";
			      var HeadTitle2="|Sel|File|Download";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
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
			      SetImageList(0,"img/ico_attach.gif");
			      SetShowButtonImage(1);
			      SetSheetHeight(142);
	      	}
			break;
		}
	}
	/**
	 * initializing Tab
	 * setting Tab items.
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
		tabObj.SetSelectedIndex(0);
	}
	/**
	 * initializing  HTML Control event. <br>
	 **/
	function initControl() {
		axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form); 	
//		axon_event.addListenerFormat('focus',  		'obj_focus',    document.form); 	
		//axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);		
		axon_event.addListenerFormat('change',	 	'obj_change',	document.form);		
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
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}

	function setPopUpParam_COM_ENS_071(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(",");
		formObj.respb_ofc_cd.value=arr[3];
		formObj.respb_ofc_nm.value=arr[4];
	}
	/**
	 * checking on HTML Control's onblur event. <br>
	 **/
	function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
	 * checking on HTML Control's focus event. <br>
	 **/
	function obj_focus(){
		ComClearSeparator(ComGetEvent());
	}
	/**
	 * checking on HTML Control's onkeypress event. <br>
	 **/
//	function obj_keypress(){
//		obj=ComGetEvent();
//		if(obj.dataformat == null) return;
//		window.defaultStatus=obj.dataformat;
//		switch(obj.dataformat) {
//		case "ymd":
//			ComKeyOnlyNumber(ComGetEvent());
//			break;
//		case "engup":
//			if(obj.name=="search_ttl_lss_no"){
//				ComKeyOnlyAlphabet('uppernum','45'); //"-"
//			} else {
//				ComKeyOnlyAlphabet('uppernum');
//			}
//			break;
//		}
//	}
	/**
	 * checking validaion onChange event on HTML Contorl. <br>
	 **/
	function obj_change()
	{
		ComChkObjValid(ComGetEvent());
		var obj=ComGetEvent();
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
	 * action event after onLoad Event 
	 * @param {Sheet}sheetObj handling sheetObject
	 */
//no support[check again]CLT 	function t1sheet1_OnLoadFinish(sheetObj) {
//		doActionIBSheet(sheetObjects[1], document.form, IBCLEAR, 0);
//	}
	/**
	 * Event when clicking Tab
	 * activating selected tab items.
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
		if(nowLoad!=1)
		{
			setCalculateTotalSum();
		}
	}
	/**
	 * COMBO changing event
	 *     
	 * @param	{IBMultiCombo}	comboObj	changed comboObject
	 * @param	{Number}		Index_Code	changed combo code
	 * @param	{String}		Text		changed combo name
	 */
	function ttl_lss_rsn_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		//initializing Sub Reason
		var ttlLssDtlRsnCdObj=ttl_lss_dtl_rsn_cd;
		ttlLssDtlRsnCdObj.RemoveAll();
		ttlLssDtlRsnCdObj.SetSelectCode("");
		//checking Main Reason 
		if(oldCode == "A") {return;}
		//retrieving Sub Reason 
		ttlLssDtlRsnCdObj.RemoveAll();
		if(newCode != ""){
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
		
	}
	/**
	 * action after search event
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			var formObj=document.form;
			tabObjects[0].SetSelectedIndex(0);
			if(sheetObj.RowCount() > 0){
				//setting TLL No
				formObj.search_ttl_lss_no.readOnly=true;
				formObj.search_ttl_lss_no.className="input2";
				//setting Header value
				var respbOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "respb_ofc_cd");			//Responsible\nOFC
				var respbOfcNm=sheetObj.GetCellValue(sheetObj.HeaderRows(), "respb_ofc_nm");			//Responsible\nOFC
				var rqstOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rqst_ofc_cd");			//REQ OFC
				var rqstDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "rqst_dt"); 				//REQ DT
				var ttlLssStsCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_sts_cd");		//Status
				var ttlLssRsnCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_rsn_cd");		//Main Reason
				var ttlLssDtlRsnCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_dtl_rsn_cd");	//Sub Reason
				var ttlLssDt=sheetObj.GetCellValue(sheetObj.HeaderRows(), "ttl_lss_dt");			//TLL DT
				var aproOfcCd=sheetObj.GetCellValue(sheetObj.HeaderRows(), "apro_ofc_cd");			//APP OFC
				var fileSeq=sheetObj.GetCellValue(sheetObj.HeaderRows(), "file_seq");				//File Seq
				var mnrStsRefNo=sheetObj.GetCellValue(sheetObj.HeaderRows(), "mnr_sts_ref_no");		//mnr_sts_ref_no
				formObj.respb_ofc_cd.value=respbOfcCd;		//Responsible\nOFC
				formObj.respb_ofc_nm.value=respbOfcNm;		//Responsible\nOFC NM
				formObj.rqst_ofc_cd.value=rqstOfcCd;		//REQ OFC
				formObj.rqst_dt.value=rqstDt; 			//REQ DT
				ttl_lss_sts_cd.SetSelectCode(ttlLssStsCd);//Status
				ttl_lss_rsn_cd.SetSelectCode(ttlLssRsnCd);//Main Reason
				ttl_lss_dtl_rsn_cd.SetSelectCode(ttlLssDtlRsnCd);//Sub Reason
				formObj.ttl_lss_dt.value=ttlLssDt;			//TLL DT
				apro_ofc_cd.SetSelectCode(aproOfcCd);		//APP OFC
				formObj.file_seq.value=fileSeq;		    //File Seq
				formObj.ttl_lss_no.value=formObj.search_ttl_lss_no.value;  //ttl_lss_no
				uploadFileSeq=fileSeq; //File Seq
				//retrieving file list
				if(fileSeq != "" && fileSeq != null){
					var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
					if(!MnrIsEmptyXml(fileXml)){
						sheetObjects[7].LoadSearchData(fileXml,{Sync:1});
					}
				}
				//retrieviing History list
				if(mnrStsRefNo != "" && mnrStsRefNo != null){
					historyMnrStsRefNo=mnrStsRefNo;
					var sXml=MnrStatusHistorySearch(sheetObjects[6], mnrStsRefNo);
					sheetObjects[6].LoadSearchData(sXml,{Sync:1});
				}
				//setting button Status
				if(ttlLssStsCd == 'HR') {
					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Delete");
					ComBtnDisable("btn_Request");
					ComBtnDisable("btn_t1EQAdd");
					ComBtnDisable("btn_t1RowDel");
					ComBtnDisable("btn_t2RowDel");
					ComBtnDisable("btn_t3RowDel");
					ComBtnDisable("btn_t4RowDel");
					ComBtnDisable("btn_t5RowDel");
					ComBtnDisable("btn_RowAdd2");
					ComBtnDisable("btn_RowDel2");
					ComBtnDisable("btn_FileAdd");
					ComBtnDisable("btn_FileDel");
				} else {
					ComBtnEnable("btn_Save");
					ComBtnEnable("btn_Delete");
					ComBtnEnable("btn_Request");
					ComBtnEnable("btn_t1EQAdd");
					ComBtnEnable("btn_t1RowDel");
					ComBtnEnable("btn_t2RowDel");
					ComBtnEnable("btn_t3RowDel");
					ComBtnEnable("btn_t4RowDel");
					ComBtnEnable("btn_t5RowDel");
					ComBtnEnable("btn_RowAdd2");
					ComBtnEnable("btn_RowDel2");
					ComBtnEnable("btn_FileAdd");
					ComBtnEnable("btn_FileDel");
				}
			}else{
				ComShowCodeMessage("MNR00204");
				doActionIBSheet(sheetObj,document.form,IBCLEAR,0);
			}
		} else {
			doActionIBSheet(sheetObj,document.form,IBCLEAR,0);
		}
	}
	/**
	 * setting sum after retriving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
		 for(var i=sheetObj.HeaderRows(); i < sheetObj.LastRow(); i++){
			 if(sheetObj.GetCellValue(i, "lstm_cd") == "OW"){
				 sheetObj.SetCellEditable(i, "inv_no", 0);
			 }
		 }
	}
	/**
	 * setting sum after retriving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * setting sum after retriving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t3sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * setting sum after retriving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * setting sum after retriving
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function t5sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		 setCalculateTotalSum();
		 sheetObj.SetSumValue("eq_knd_cd", "Total");
	}
	/**
	 * in case of clicking sheet popup
	 * calling Payer Code,Responsible\nOFC popup.
	 * @param	{IBSheet}	sheetObj	sheetObject
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
				ComOpenPopup("/opuscntr/COM_ENS_0C1.do", 700, 450, 'setServiceProvider', '1,0,1,1,1,1,1', true);
			//coustomer
			} else if(ttlLssN3ptyTpCd == "C") {
				ComOpenPopup("/opuscntr/COM_ENS_041.do", 770, 520, 'setCustomer', '1,0', true);
			} else if(ttlLssN3ptyTpCd == "O") {
				ComOpenPopup("/opuscntr/COM_ENS_071.do", 770, 450, 'setCOM_ENS_071', '1,0', true);
			}
		}
	}
	/**
	 * in case of sheet select
	 *    calling Payer Code popup.
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
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
	 * in case of sheet select
	 *    whether modify Disposal Plan Amt
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function t3sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var ttlLssBilAmt=sheetObj.GetCellValue(NewRow, "ttl_lss_bil_amt");
		//service provider
		if(ttlLssBilAmt == "" || ttlLssBilAmt == "0") {
			sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",1);
		}else{
			sheetObj.SetCellEditable(NewRow, "ttl_lss_incm_amt",0);
		}
	}
	/**
	 * in case of changing sell value
	 *     setting  TP/SZ, DV.Value, Lessor according to change EQ NO.
	 *
	 * @param	{IBSheet}	sheetObj	sheetObject
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
		}
	}
	/**
	 * 	in case of changing sell value
	 *     setting  TP/SZ, DV.Value, Lessor according to change EQ NO.
	 *     setting  Payer Code and Payer Name according to change Payer Type.
	 *
	 * @param	{IBSheet}	sheetObj	sheetObject
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
				//check Duplicate
				var chkRow=sheetObj.ColValueDup("rqst_eq_no");
					if(chkRow > 0 && sheetObj.GetRowStatus(chkRow) != "D"){
					ComShowCodeMessage("MNR00006",sheetObj.GetCellValue(Row,"rqst_eq_no"));
					sheetObj.SetCellValue(Row, "rqst_eq_no","",0);
					sheetObj.SelectCell(Row, "rqst_eq_no", true);
					return false;
				//Check the EQ is exist in DV
				} else {
					var chkFlag=false;
					for(var j=sheetObjects[1].HeaderRows(); j <= sheetObjects[1].LastRow(); j++) {
						if(sheetObjects[1].GetRowStatus(j) != "D" && (sheetObjects[1].GetCellValue(j,"rqst_eq_no") == sheetObj.GetCellValue(Row,"rqst_eq_no"))){
							//setting true in case of existing
							chkFlag=true;
						}
					}
					if(!chkFlag){
						ComShowCodeMessage("MNR00339");
						sheetObj.SetCellValue(Row, "rqst_eq_no","",0);
						sheetObj.SelectCell(Row, "rqst_eq_no", true);
						return false;
					}
				}
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
					//Do you want to initialize data ?
					if(!ComShowCodeConfirm("MNR00192")) {
							sheetObj.ReturnCellData(Row,Col);
					return;
					}
				}
				if(Value=="O")
				{
					sheetObj.SetCellValue(Row, "mnr_prnr_seq","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else if(Value=="N") {
					sheetObj.SetCellValue(Row, "mnr_prnr_seq","");
					sheetObj.SetCellValue(Row, "payer_code","");
					sheetObj.SetCellValue(Row, "payer_name","");
					sheetObj.SetCellEditable(Row, "payer_code",0);
				}else{
					sheetObj.SetCellValue(Row, "mnr_prnr_seq","");
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
	 * in case of changing sell value
	 *     setting  TP/SZ, DV.Value, Lessor according to change EQ NO.
	 *
	 * @param	{IBSheet}	sheetObj	sheetObject
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
	 * in case of changing sell value
	 *     setting  TP/SZ, DV.Value, Lessor according to change EQ NO.
	 *
	 * @param	{IBSheet}	sheetObj	sheetObject
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
	 * in case of changing sell value
	 *     setting  TP/SZ, DV.Value, Lessor according to change EQ NO.
	 *
	 * @param	{IBSheet}	sheetObj	sheetObject
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
		 * event in case of clicking cell popup
		 *     setting Notification Date.
		 *
		 * @param	{IBSheet}	sheetObj	sheetObject
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
	 * in case of clicking sheet popup
	 *     calling calandar.
	 * @param	{IBSheet}	sheetObj	sheetObject
	 * @param	{Int}	    Row		Row
	 * @param	{String}	Col		Col
	 */
	function sheet2_OnPopupClick(sheetObj,Row,Col){
		if (sheetObj.ColSaveName(Col) != "mnr_sts_dt") return;
		var cal=new ComCalendarGrid();
		cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
	}
	/**
	 * showing message after saving
	 * @param	{IBSheet}	sheetObj	sheetObject of Saving event
	 * @param	{String}	ErrMsg		errorMessage
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){
		 var formObj=document.form;
		if (ErrMsg == "") {
			//Remove
			if(formObj.f_cmd.value == REMOVE)
			{
				ComShowCodeMessage("MNR00020");
			}
			//Request
			else if(saveType == 2) {
				ComShowCodeMessage("MNR00154", "requested");
				saveType=1;
				doActionIBSheet(sheetObjects[1], document.form, IBCLEAR, 0);
				nowLoad=0;
				MnrWaitControl(false);
				return;
			}
			//Save
			else {
				ComShowCodeMessage("MNR00153");
			}
			if(formObj.f_cmd.value != REMOVE)
			{
				formObj.f_cmd.value="";
				document.form.search_ttl_lss_no.value=sheetObj.GetEtcData("totalLossNo");
				document.form.ttl_lss_no.value=sheetObj.GetEtcData("totalLossNo");
				doActionIBSheet(sheetObj,document.form,IBSEARCH);
			}
		}
		else {
			errFlag = "Y";
			ttl_lss_sts_cd.SetSelectCode(preTtlLssStsCd, false);
//			ComShowCodeMessage("MNR00008",ErrMsg);
		}
		nowLoad=0;
		MnrWaitControl(false);
	}
	/**
	 * handling process sheet
	 *
	 * @param {IBSheet}sheetObj handling sheetObject
	 * @param {Form}formObj handling formObject
	 * @param {Number}sAction Action constants 
	 */
	function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		// initializing
		case IBCLEAR:
			// settng button and progressing bar
			sheetObj.SetWaitImageVisible(0);
			MnrWaitControl(true);
			//initializing Combo Data
			for(var i=0; i < comboObjects.length;i++){
				comboObjects[i].RemoveAll();
			}
			//initializing sheet all
			for (i=0; i < sheetObjects.length; i++) {
				sheetObjects[i].RemoveAll();
			}
			//Loading 
			if(sActionIdx == 0) {
				//retrieving combo data 및 설정(Status, Main Reason, APP OFC)
				var sCondition=new Array (
						new Array("MnrGenCd","CD00039", "COMMON") 	//Status
						,new Array("MnrGenCd","TR", "COMMON")		//Main Reason
						,new Array("MnrGenCd","HOOFC", "COMMON") 	//HOOFC
						,new Array("MdmCurrency","", "COMMON")		//Currency
						,new Array("MnrGenCd","CD00071", "COMMON")  //Status 
						,new Array("MnrGenCd","CD00043", "COMMON")  //Payer Type
						,new Array("MnrGenCd","CD00069", "COMMON")  //Insurance Co
						,new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//setting sheet
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboCodeText="";
				var sheetComboDefault="";
				for(var i=0; i < comboList.length;i++){
					//initializing sheetCombo
					sheetComboText="";
					sheetComboCode="";
					sheetComboCodeText="";
					sheetComboDefault="";
					if(comboList[i] != null){
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
							if(j ==0){
								sheetComboDefault=tempText[0];
							}
							//Status
							if(i==0) {
								ttl_lss_sts_cd.InsertItem(j, tempText[1] ,tempText[0]);
							}
							//Main Reason
							else if (i==1) {
								if(j==0){
									ttl_lss_rsn_cd.InsertItem(0, '');	// Main Reason 디폴트 공백 추가
								}
								ttl_lss_rsn_cd.InsertItem(j+1, tempText[1] ,tempText[0]);
							}
							//APP OFC
							else if (i==2) {
								apro_ofc_cd.InsertItem(j, tempText[0] ,tempText[0]);
							}
						}
						//setting sheetCombo per Tab
						for(var k=1; k<6; k++) {
							if(i == 3) {
								sheetObjects[k].InitDataCombo (0, "curr_cd", sheetComboCode, sheetComboCode ,sheetComboDefault);
							} else if(i == 4) {
								if( k==1) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_dtl_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 5) {
								if(k == 2) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_n3pty_tp_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 6) {
								if(k == 5) {
									sheetObjects[k].InitDataCombo (0, "ttl_lss_plc_nm", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							} else if(i == 7){
								sheetObjects[k].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
							}
						}
					}
				}
			}
			//setting initial value
			formObj.search_ttl_lss_no.value="";					//TLL No
			formObj.ttl_lss_no.value="NEW";				//TLL No
			formObj.search_ttl_lss_no.readOnly=false;
			formObj.search_ttl_lss_no.className="input1";
			formObj.respb_ofc_cd.value=currOfcCd; 					//Responsible\nOFC
			formObj.rqst_ofc_cd.value=currOfcCd; 			//REQ OFC
			formObj.rqst_dt.value=ComGetNowInfo("ymd");	//REQ DT
			ttl_lss_sts_cd.SetSelectCode("");//Status
			ttl_lss_sts_cd.SetEnable(0);
			//ttl_lss_rsn_cd.SetSelectIndex(0);
			formObj.ttl_lss_dt.value=ComGetNowInfo("ymd");	//TLL DT
			apro_ofc_cd.SetSelectIndex(0);//APP OFC
			//initializing total AMT
//			for(var i=1;i<=5;i++)
//			{
//				eval("document.form.t"+ i + "LossTotal.value='';");
//				eval("document.form.t"+ i + "RecPlnTotal.value='';");
//				eval("document.form.t"+ i + "BalanceTotal.value='';");
//			}
			formObj.search_ttl_lss_no.focus();
			uploadFileSeq="";
			historyMnrStsRefNo="";
			saveType=1;
			// settng button and progressing bar 
			MnrWaitControl(false);
			sheetObj.SetWaitImageVisible(1);
			nowLoad=0;
			break;
			//retrieving
		case IBSEARCH:
			if(validateForm(sheetObj,formObj,sAction)) {
				//initializing sheet all
				for (i=0; i < sheetObjects.length; i++) {
					sheetObjects[i].RemoveAll();
				}
				sheetObj.SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH;
				//multiple search
				var sXml=sheetObj.GetSearchData("EES_MNR_0095GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				for(var i=0; i < arrXml.length; i++){
					sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
				}
			}
			break;
			//saving
		case IBSAVE:
			if(nowLoad != 0) return;
			nowLoad=1;
			MnrWaitControl(true);
			if(validateForm(sheetObj,formObj,sAction,sActionIdx)) {
				formObj.f_cmd.value=MULTI;
				var currTabIndex=tabObjects[0].GetSelectedIndex();
				tabObjects[0].SetSelectedIndex(0);
				var sParam1=sheetObjects[1].GetSaveString(true, true);
				if(sParam1=="")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SetSelectedIndex(1);
				var sParam2=sheetObjects[2].GetSaveString(true, true);
				if(sParam2=="" && sheetObjects[2].RowCount()> 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SetSelectedIndex(2);
				var sParam3=sheetObjects[3].GetSaveString(true, true);
				if(sParam3=="" && sheetObjects[3].RowCount()> 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				tabObjects[0].SetSelectedIndex(3);
				var sParam4=sheetObjects[4].GetSaveString(true, true);
				if(sParam4=="" && sheetObjects[4].RowCount()> 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				if(sheetObjects[4].IsDataModified()){
					for(var i=sheetObjects[4].HeaderRows();i<=sheetObjects[4].LastRow();i++)
					{
						//2. column is blank
						var checkValue1=ComTrimAll(sheetObjects[4].GetCellValue(i, "ttl_lss_incm_amt")," ");
						var checkValue2=ComTrimAll(sheetObjects[4].GetCellValue(i, "ttl_lss_expn_amt")," ");
						if(checkValue1=="" && checkValue2=="")
						{
							MnrWaitControl(false);
							ComShowCodeMessage("MNR00172","at least one item amoung Scrapping Income AMT or Scrapping Cost Amt");
							sheetObjects[4].SelectCell(i, "ttl_lss_incm_amt",true);
							nowLoad=0;
							return false;
						}
					}
				}
				tabObjects[0].SetSelectedIndex(4);
				var sParam5=sheetObjects[5].GetSaveString(true, true);
				if(sParam5=="" && sheetObjects[5].RowCount()> 0)
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				var sParam6=sheetObjects[6].GetSaveString(true, true);
//				if(sParam6=="")
//				{
//					return;
//				}
				sParam6=ComSetPrifix(sParam6,"statusHistory_");
				tabObjects[0].SetSelectedIndex(currTabIndex);
				formObj.file_seq.value=uploadFileSeq;
				var mnrStsRefNo="";
				var ttlLssNo=formObj.ttl_lss_no.value;
				if(ttlLssNo != "NEW") {
					formObj.mnr_sts_ref_no.value=sheetObjects[0].GetCellValue(sheetObjects[0].HeaderRows(), "mnr_sts_ref_no");
				} else {
					formObj.mnr_sts_ref_no.value=mnrStsRefNo;
				}
				
				preTtlLssStsCd = "";
				//Save
				if(sActionIdx == 1) {
					saveType=1;
					preTtlLssStsCd = ttl_lss_sts_cd.GetSelectCode();
					ttl_lss_sts_cd.SetSelectCode("HS",false);
				}
				//Request
				else if (sActionIdx == 2) {
					saveType=2;
					preTtlLssStsCd = ttl_lss_sts_cd.GetSelectCode();
					ttl_lss_sts_cd.SetSelectCode("HR",false);
					setRowStausByRequest();  
				}
				var sParam=FormQueryString(formObj)+"&"+ sParam1 +"&"+ sParam2 +"&"+ sParam3 +"&"+ sParam4 +"&"+ sParam5 +"&"+ sParam6;
				if (sParam == "")
				{
					nowLoad=0;
					MnrWaitControl(false);
					return;
				}
				sParam += "&" + FormQueryString(formObj);
				//ComDebug(sParam);
				errFlag = "N";
				sSaveRtnXml=sheetObjects[0].GetSaveData("EES_MNR_0095GS.do", sParam);	//return Total Loss No.
				sheetObjects[0].LoadSaveData(sSaveRtnXml);  								//showing message in case of saving
				//Run Request button or without
				if(sActionIdx == 1){
					if(errFlag != "Y"){
						if (ComShowCodeConfirm("MNR00275","Total Loss Request","Request"))
						{
							//action Request button.
							doActionIBSheet(sheetObjects[0], document.form, IBSAVE, 2);
						}
					}
				}
			}
			nowLoad=0;
			MnrWaitControl(false);
			break;
            //deleting
        case IBSEARCHAPPEND:
        	if(validateForm(sheetObj,formObj,sAction)) {
        		MnrWaitControl(true);
				actionType="IBSEARCHAPPEND";
        		formObj.f_cmd.value=REMOVE;
			    sParam=FormQueryString(formObj);
			    sSaveRtnXml=sheetObjects[0].GetSaveData("EES_MNR_0095GS.do", sParam);
				//setting initial value
				formObj.search_ttl_lss_no.value="";					//TLL No
				formObj.ttl_lss_no.value="NEW";				//TLL No
				formObj.search_ttl_lss_no.readOnly=false;
				formObj.search_ttl_lss_no.className="input1";
				formObj.rqst_ofc_cd.value=currOfcCd; 			//REQ OFC
				formObj.rqst_dt.value=ComGetNowInfo("ymd");	//REQ DT
				ttl_lss_sts_cd.SetSelectCode("");//Status
				ttl_lss_sts_cd.SetEnable(0);
				ttl_lss_rsn_cd.SetSelectCode("");//Main Reason
				formObj.ttl_lss_dt.value=ComGetNowInfo("ymd");	//TLL DT
//				apro_ofc_cd.SetSelectCode("");//APP OFC
				//initializing total AMT
//				for(var i=1;i<=5;i++)
//				{
//					eval("document.form.t"+ i + "LossTotal.value='';");
//					eval("document.form.t"+ i + "RecPlnTotal.value='';");
//					eval("document.form.t"+ i + "BalanceTotal.value='';");
//				}
				formObj.search_ttl_lss_no.focus();
				uploadFileSeq="";
				historyMnrStsRefNo="";
				saveType=1;
				//initializing sheet all
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		sheetObjects[0].LoadSaveData(sSaveRtnXml);   //showing message in case of saving
				MnrWaitControl(false);
        	}
            break;
			// input Row
		case IBINSERT:
			if(validateForm(sheetObj,formObj,sAction)) {
				var Row=sheetObj.DataInsert(-1);
				//setting Total Loss No
				sheetObj.SetCellValue(Row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
				//setting mnr_inv_tp_cd
				if(sheetObj.id == 't1sheet1') {
					sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DV",0);
					sheetObj.SetCellValue(Row, "ttl_lss_dtl_sts_cd","",0);
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
				//initializing grid combo
				sheetObj.SetCellValue(Row, "curr_cd","USD",0);//CURR
			}
			break;
			//deleting Row
		case IBDELETE:
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id=="t1sheet1")
				{
					var tabSheetIndex=1; //first index of sheetObjects in D.V Expense Tab
		 			for(var i=sheetObjects[tabSheetIndex].HeaderRows(); i<=sheetObjects[tabSheetIndex].LastRow(); i++)
					{
		 				if(sheetObjects[tabSheetIndex].GetCellValue(i,"del_chk")==1)
		 				{
		 					//selected EQ No of D.V Expense Tab.
		 					var rqstEqNo=sheetObjects[tabSheetIndex].GetCellValue(i,"rqst_eq_no")
		 					//checkiing rqstEqNo variable reference in 3rd Party,Disposal,Scrapping,Insurance Tab
		 					for(var j=tabSheetIndex+1; j<=tabSheetIndex+4;j++)
				 			{
			 					var row=sheetObjects[j].FindText("rqst_eq_no", rqstEqNo);
			 					if(row > 0)
			 					{
				 					sheetObjects[j].SetCellValue(row,"del_chk","1");
				 					ComRowHideDelete(sheetObjects[j], "del_chk");
			 					}
				 			}
		 				}
					}
		 			ComRowHideDelete(sheetObjects[tabSheetIndex], "del_chk");
				}else{
					ComRowHideDelete(sheetObj, "del_chk");
				}
			}
			break;
		}
	}
	//ResponsibleOFC Check
	function respb_ofc_cd_Check(){
		nowLoad=1;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		if(ComTrimAll(formObj.respb_ofc_cd.value," ")!="")
		{
			var retArray=null;
			retArray=MnrGeneralCodeCheck(sheetObj,"OFC",formObj.respb_ofc_cd.value);
			if(retArray == null){
				ComShowCodeMessage("MNR00165",formObj.respb_ofc_cd.value,"OFFICE");
				formObj.respb_ofc_cd.value="";
				formObj.respb_ofc_nm.value="";
				ComSetFocus(formObj.respb_ofc_cd);
				nowLoad=0;
				return false;
			} else {
				var retArray=retArray[0].split("|");
				formObj.respb_ofc_cd.value=retArray[0];
				formObj.respb_ofc_nm.value=retArray[1];
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
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction,sActionIdx){
		with(formObj){
			//adding row시
			if (sAction == IBINSERT) {
				var dvTabRowCnt = sheetObjects[1].RowCount - sheetObjects[1].RowCount("D");
				var chkTabRowCnt = sheetObj.RowCount - sheetObj.RowCount("D");
				if(dvTabRowCnt <= chkTabRowCnt){
					ComShowCodeMessage("MNR00339");
					return false;
				}
			}
			//checking when retrieving
			else if (sAction == IBSEARCH) {
				// Dataformat
				if (!ComChkValid(formObj)) {
					return false;
				}
			}
			//in case of Calling save
			else if(sAction == IBSAVE) {
				// input Total Loss History mandatory
				var rowCnt = sheetObjects[6].RowCount("R")+sheetObjects[6].RowCount("I")+sheetObjects[6].RowCount("U");
				if(rowCnt < 1){
					ComShowCodeMessage("MNR00336");
					return false;
				}
				//responsible Office check
				if(!respb_ofc_cd_Check()) {return false;}
				//checking Total Loss status
				if(!checkTotalLossfStatus()) {return false;}
				//mandatory
				if(!checkMandatory(ttl_lss_rsn_cd)) {return false;}
				if(!checkMandatory(ttl_lss_dtl_rsn_cd)) {return false;}
				if(!checkMandatory(formObj.ttl_lss_dt)) {return false;}
				if(!checkMandatory(apro_ofc_cd)) {return false;}
				//grid whether or not
				if(!checkIsDetailRow(sActionIdx)) {return false;}
				//check Duplicate per sheet
				for (var i=1; i<6; i++){
					var Row=sheetObjects[i].ColValueDup("rqst_eq_no",false);
					if(sheetObjects[i].IsDataModified()){
						if(Row>0){
							ComShowCodeMessage("MNR00006",i + "th sheet of " + Row + " row ");
							sheetObjects[i].SelectCell(Row, "rqst_eq_no", true);
							return false;
						}
					}
				}
			}
			//deleting
			else if(sAction == IBSEARCHAPPEND) {
				if(MnrNullToBlank(ComGetObjValue(formObj.search_ttl_lss_no)) == "" ||
				   MnrNullToBlank(ComGetObjValue(formObj.ttl_lss_no)) == ""){
					ComShowCodeMessage("MNR00260");
					return false;
				}
				if (!ComShowCodeConfirm("MNR00275","Total Loss Request","Delete")){return false;}
			}
		}
		return true;
	}
	/* ********* User Functions ************* */
	/**
	 * EES_MNR_0195 receiving function values ​​from Pop-up
	 */
	function setEES_MNR_0195(aryPopupData, row, col, shhetIdx){
		var formObj=document.form;
		if(aryPopupData[0][4] != null && aryPopupData[0][4] != "") {
			formObj.search_ttl_lss_no.value=aryPopupData[0][4];
			formObj.ttl_lss_no.value=aryPopupData[0][4];
		}
		doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
	}
	/**
	 * Loss Total : Pay Amount sum in DV
	 * Recovery Plan Total : 3rd Amount + Disposal Amount + Scrapping Income AMT
	 *                        + Scrapping Cost AMT + Request AMT
	 * Balance Total = Recovery Plan Total - Loss Tota
	 */
	function setCalculateTotalSum(){
	    var tabIndex=tabObjects[0].GetSelectedIndex()+ 1;
        var sheetIndex=1;
	    var calFlag=false;
		for(var i=sheetIndex;i<sheetIndex + 5;i++)
		{
			if(sheetObjects[i].RowCount()> 0)
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
						//except deleting or  SEQ == NULL(0)
						if(sheetObjects[i].GetCellValue(j,"ibflag")!="D" && sheetObjects[i].GetCellValue(j,"seq")!="0")
						{
							if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DV"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
								tLossTotal=getFloatSumData(tLossTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
							else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="TP"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
								thrdAmtTotal=getFloatSumData(thrdAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
							else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="DS"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt")!="")
									disposalAmtTotal=getFloatSumData(disposalAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
									disposalPlanAmtTotal=getFloatSumData(disposalPlanAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt"));
							} 
							else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="SC"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_incm_amt")!="")
									scrapIncomeAmtTotal=getFloatSumData(scrapIncomeAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
									scrapCostAmtTotal=getFloatSumData(scrapCostAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
							else if(sheetObjects[i].GetCellValue(j,"mnr_inv_tp_cd")=="IR"){
								if(sheetObjects[i].GetCellValue(j,"ttl_lss_expn_amt")!="")
									requestAmtTotal=getFloatSumData(requestAmtTotal,sheetObjects[i].GetCellValue(j,"ttl_lss_bil_amt"));
							}
						}
					}
			    }
            }
//            var tempStr=ComAddComma2((tLossTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "LossTotal.value=tempStr;");
//			//Recovery Plan Total(tRecPlnTotal) = minus(-) 
//		    var tRecPlnTotal=parseFloat(MnrMakeRound(parseFloat((thrdAmtTotal+disposalAmtTotal+disposalPlanAmtTotal+scrapIncomeAmtTotal+scrapCostAmtTotal+requestAmtTotal)*(-1)),2));
//			tempStr=ComAddComma2((tRecPlnTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "RecPlnTotal.value=tempStr;");
//		    var tBalanceTotal=getFloatSumData(tRecPlnTotal,tLossTotal);
//			tempStr=ComAddComma2((tBalanceTotal + ""), "#,###");
//			eval("document.form.t"+ tabIndex + "BalanceTotal.value=tempStr;");
		}
	}
	/**
	 * @param a  add value
	 * @param b  add value
	 * @return sumResult  result value
	 */
	function getFloatSumData(a,b){
		var aFloat=parseFloat(a + "");
		var bFloat=parseFloat(b + "");
		var sumResult=MnrMakeRound(parseFloat(aFloat + bFloat),2);
		return  parseFloat(sumResult + "");
	}
	/**
	 * (Responsible Office) checking whether data exists or not<br>
	 * @param
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 * @param Col IBSheet CellValue
	 */
	/**
	 * checking whether ofc_cd exists or not
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
	 * (Service Provider) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 */
	function setServiceProvider(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[2].GetSelectRow();
			var vndrSeq=aryPopupData[0][2];
			var vndrNm=aryPopupData[0][4];
			sheetObjects[2].SetCellValue(Row, "payer_code",vndrSeq);
			sheetObjects[2].SetCellValue(Row, "payer_name",vndrNm);
			sheetObjects[2].SetCellValue(Row, "mnr_prnr_seq",vndrSeq);
		}
	}
 	/**
	 * COM_ENS_071 receiving function values ​​from Pop-up
	 */
	function setCOM_ENS_071(aryPopupData){
    	 var formObj=document.form;
    	 var Row=sheetObjects[2].GetSelectRow();
		 if(aryPopupData[0][3] != null && aryPopupData[0][3] != "") {
			sheetObjects[2].SetCellValue(Row, "respb_ofc_cd",aryPopupData[0][3]);
		 }
    }
	/**
	 * (Customer) handling Pop-up Return Value<br>
	 * @param {arry} Return value array of returnedValues Pop-up
	 * @param Row IBSheet Row index
	 * @param Col IBSheet Col index
	 */
	function setCustomer(aryPopupData) {
		if ( aryPopupData.length > 0 ) {
			var Row=sheetObjects[2].GetSelectRow();
			var custCd=aryPopupData[0][3];
			var custNm=aryPopupData[0][4];
			var mnrPrnrCntCd=custCd.substring(0,2);
			var mnrPrnrSeq=custCd.substring(2);
			sheetObjects[2].SetCellValue(Row, "payer_code",custCd);
			sheetObjects[2].SetCellValue(Row, "payer_name",custNm);
			sheetObjects[2].SetCellValue(Row, "mnr_prnr_cnt_cd",mnrPrnrCntCd);
			sheetObjects[2].SetCellValue(Row, "mnr_prnr_seq",mnrPrnrSeq);
		}
	}
	/**
	 * adding upload Row of IBSheet. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {nothing}
	 **/
	function file_Insert(sheetObj){
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined ||uploadFileSeq == -1){
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
	 * deleting upload Row of IBSheet. <br>
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
	 * downloading file <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Col     	selected Row of sheetObj
	 * @param {ibsheet} Col     	selected Col of sheetObj
	 * @param {String} 	Value     	file name
	 **/
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	/**
	 * return false in case of Request
	 * other return true
	 * @return  {Boolean}    true/false
	 */
	function checkTotalLossfStatus() {
		var ttlLssStsCd=ttl_lss_sts_cd.GetSelectCode(); //ttl_lss_sts_cd
		if(ttlLssStsCd == "HR"){
			ComShowCodeMessage("MNR00208","Total Loss", "Request ");
			return false;
		}
		return true;
	}
	/**
	 * checking mandatory when saving
	 * @param	{Element}	obj	checking Form Element
	 */
	function checkMandatory(obj) {
		if(ComIsEmpty(ComGetObjValue(obj))) {
			ComShowCodeMessage("MNR00003");
			obj.focus();
			return false;
		}
		return true;
	}
	/**
	 * checking grid whether or not
	 */
	function checkIsDetailRow(sActionIdx){
		var cnt=0;
		for (var i=1; i<6; i++) {
			var rowCnt=0;
			//Request (sActionIdx = 2) ,Save (sActionIdx = 1)
			rowCnt = sheetObjects[i].RowCount("R")+sheetObjects[i].RowCount("I")+sheetObjects[i].RowCount("U");
			if(rowCnt > 0) {
				cnt++;
			}
		}
		if(cnt<1) {
			ComShowCodeMessage("MNR00172"," EQ Information");
			return false
		}
		return true;
	}
	/**
	 * calling saving event in case of clicking Request button
	 */
	function setRowStausByRequest(){
		for (var i=1; i<sheetObjects.length - 2; i++) {
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
	 * setting TP/SZ, DV.Value, Lessor according to changing EQ No.
	 *
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		// checking EQ_TYPE whether select
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){
			ComShowCodeMessage("MNR00119");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;
		}
		//Check EQ No whether or not
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
		//retrieving EQ No related items
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
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd=retArr[0][31];	//TP/SZ
		var dpcValAmt=retArr[0][10];	//DV.Value
		var lessorNm=retArr[0][16];	//Lessor
		var lstmCd=retArr[0][19];	//Term
		var ydCd=retArr[0][18];	//Yard
		var lessorCd    = retArr[0][42];
		
		//setting EQ No related items
		sheetObj.SetCellValue(Row,"eq_tpsz_cd",eqTpszCd,0);//TP/SZ
		sheetObj.SetCellValue(Row,"lstm_cd",lstmCd,0);//Term
		sheetObj.SetCellValue(Row,"ttl_lss_yd_cd",ydCd,0);//Yard
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm",lessorNm,0);//Lessor
			sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt);//Pay Amount.
			sheetObj.SetCellValue(Row, "mnr_prnr_seq", lessorCd,0);
			if(lstmCd != "OW"){
				//in case of not existing Invoice No
				var invNo=sheetObj.GetCellValue(Row, "inv_no");
				var ofcCd=formObj.rqst_ofc_cd.value;
				var yymm=totalLossDate.substring(2,7).split("-").join("");
//				if(invNo=="" || invNo==null) {
				invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
					sheetObj.SetCellValue(Row, "inv_no",invNo);
//				}
			}else{
				sheetObj.SetCellValue(Row, "inv_no"," ");
			}
			
		}else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
			//in case of not existing Invoice No
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
//			if(invNo=="" || invNo==null) {
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"T";
				sheetObj.SetCellValue(Row, "inv_no",invNo);
//			}
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
		}
	}
	/**
	 * deleting in case of not existing EQ No
	 *
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
	 * adding Row  to Total Loss History
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
		sheetObj.SetCellValue(Row, "mnr_grp_tp_cd","TLL");
		sheetObj.SetCellValue(Row, "mnr_sts_dt",ComGetNowInfo("ymd"));
		sheetObj.SetCellValue(Row, "rqst_ofc_cd",currOfcCd);
		sheetObj.SetCellValue(Row, "cre_usr_id",usrId);
	}
	/**
	 * deleting Row of Total Loss History
	 *
	 * @param sheetObj
	 * @return
	 */
	function history_Remove(sheetObj) {
		ComRowHideDelete(sheetObj, "del_chk");
	}
