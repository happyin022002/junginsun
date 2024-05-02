/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_MNR_0058.js
 *@FileTitle : M&R Extra Expense W/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
	  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
						COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends
	 * @class ees_mnr_0058 : ees_mnr_0058 - Defining a script used by screen
	 */
/* Developer's task	*/
/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var mnrHngrBarTpCode="";
	var mnrHngrBarTpDesc="";
	var nowLoad=0;
	//Using for upload file
	var arrDataSearchDbXml;
	var frontMnrOrdSeq="";
	var costCdSubstr="";

	var sXml_1 = "";
	var sXml_2 = "";
	var OrgVndrSeq = "";
	var OrgCostCd = "";
	var searchFlg = "";
	var ord_hdr_rmk_org = "";
	
	var oldWoNo = "";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do?req_ofc=" + currOfcCd, 720, 380, 'setParam', '0,0', true);
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[2], formObject, IBSEARCH);
				break;
			case "btn_New":
				var sRow=sheetObject1.FindStatusRow("I|U|D");  // checking sheet status
				if(sheetObject1.GetEditable()) {
					if(sRow != "") // in case of existing edits
					{
						
						if(!ComShowCodeConfirm("MNR00232"))
						{
							return false;
						}
					}
				}
				doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
				break;
			case "btn_W/O_Creation":
				if(currOfcCd == "MEXBA"){
					ComShowCodeMessage("MNR00357");
					break;
				}
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_W/O_Send":
				doActionIBSheet(sheetObjects[0], formObject, COMMAND01);
				break;
			case "btn_delete":
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCHAPPEND);
				break;
			case "btn_RowAdd":
				doRowAdd(sheetObjects[0], formObject);
				break;
			case "btn_RowDel":
				if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
					ComShowCodeMessage("MNR00038","DELETE ");
					return false;
				}
				if(ComShowCodeConfirm("MNR00026")){
					ComRowHideDelete(sheetObjects[0], "del_chk");
					ComBtnEnable("btn_W/O_Creation");
					ComBtnDisable("btn_W/O_Send");
				}
				break;
			case "btn_excelDown":
				if(sheetObjects[0].RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObjects[0]), SheetDesign:1,Merge:1 });
				}
				break;
			case "btn_File_Add":
				file_Insert(sheetObjects[1]);
				break;
			case "btn_File_Del":
				file_Remove(sheetObjects[1]);
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
		MnrWaitControl(true);
		initControl();
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
			if(sheetObjects[i].id.substring(0,2) == "sheet2" ){
				DLCSheets[DLCSheetCnt++]=sheetObjects[i];
			}
		}
		initCombo();
		initUpload();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
		
	}
	
	var pSheetObj, pRow, pCol ;
	function initUpload(){
		var formObj = document.form;
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
				sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
				sParam+= "&file_seq=" + file_seq;
				sParam+= "&file_dtl_seq=" + file_dtl_seq;
				sParam+= "&org_file_nm=" + fileName;
				sParam+= "&ibflag=" + ibflag;
		 		paramToForm(sParam);
		 		
		 		formObj.f_gubuns.value = "";
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	 				uploadFileSeq=ComGetEtcData(sXml,"seqValue");
					if(uploadFileSeq != "" && uploadFileSeq != undefined){
						var fileXml=SearchFileUpload(pSheetObj,uploadFileSeq);
						pSheetObj.LoadSearchData(fileXml,{Sync:1} );
						var sheet1_file_seq=formObj.file_seq.value;
						if(sheet1_file_seq=="0" || sheet1_file_seq=="")
						{
							formObj.file_seq.value=uploadFileSeq;
							MnrWaitControl(false);
							ComBtnDisable("btn_W/O_Send");
						}else{
							MnrWaitControl(false);
							ComBtnDisable("btn_W/O_Creation");
						}
					}else{
						MnrWaitControl(false);
						ComBtnDisable("btn_W/O_Send");
					}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
			,AfterAddFile:function(result){
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
	 			
	 			var prefix="";
	 			var formObj = document.form;
	 			formObj.f_gubuns.value="DTL";
				pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);  // 원래는 풀네임
				upload1.SaveStatus();
			}
 		});
 	}
	
    function sheet2_OnMouseMove(sheetObj, e) {
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
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Initializing of multi combo type
	 * @return
	 */
	function initCombo() {
		with (combo_vndr_seq) {
			SetMultiSeparator("|");
			SetTitle("S/P Name|S/P Code|AGMT No|Office Code|EQ TYPE|Effective Date|Reference No|Tariff No|Currency^AgmtVerNo^EQ code");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColAlign(2, "center");
			SetColAlign(3, "center");
			SetColAlign(4, "left");
			SetColAlign(5, "center");
			SetColAlign(6, "left");
			SetColAlign(7, "left");
			SetColAlign(8, "left");
			SetColWidth(0, "180");
			SetColWidth(1, "70");
			SetColWidth(2, "75");
			SetColWidth(3, "85");
			SetColWidth(4, "70");
			SetColWidth(5, "148");
			SetColWidth(6, "110");
			SetColWidth(7, "135");
			SetColWidth(8, "0");
			SetDropHeight(160);
			SetTitleVisible(true);
		}
		with (combo_cost_cd) {
			SetMultiSeparator("|");
			SetTitle("Code|Name");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
			SetColAlign(1, "left");
			SetColWidth(1, "170");
			SetTitleVisible(true);
			SetDropHeight(160);
		}
		with (combo_eq_knd_cd) {
			SetMultiSeparator("|");
			SetTitle("Code|Name");
			SetColAlign(0, "left");
			SetColAlign(1, "left");
			SetColWidth(0, "90");
			SetColWidth(1, "180");
			SetDropHeight(160);
			SetEnable(0);
		}
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
		      var HeadTitle1="|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Yard Code|Unit Price| Q'ty|Work Date|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Amount|Hanger Offer INFO|Booking No|Trade Code|Remark(s)";
		      var HeadTitle2="|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Yard Code|Unit Price| Q'ty|Work Date|Sound         |Repairable    |Missing    |Disposal   |Amount|Hanger Offer INFO|Booking No|Trade Code|Remark(s)";
		      var headCount=ComCountHeadTitle(HeadTitle1) + 12;
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                      { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		             {Type:"Combo",     Hidden:0, Width:260,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cost_dtl_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"eq_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_expn_dtl_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
		             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_hngr_bar_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Combo",     Hidden:0, Width:140,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_hngr_trf_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_hngr_trf_otr_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",   ColMerge:1,  SaveName:prefix+"yd_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:7 },
		             {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"rpr_qty",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_invt_qty",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_hngr_dmg_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_lost_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_disp_hngr_qty",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_amt",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Popup",     Hidden:0, Width:110,  Align:"Left",    ColMerge:1,   SaveName:prefix+"mnr_hngr_dtl_offr_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:195,  Align:"Left",    ColMerge:1,   SaveName:prefix+"ord_dtl_rmk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"bzc_amt",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"file_seq",               KeyField:0,   CalcLogic:"",   Format:"",       	   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"cost_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_rt_tp_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"eq_no_check_yn",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"recent_rpr_qty",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_hngr_flg_yd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_hngr_rck_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_hngr_flg_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"eq_tpsz_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"eq_knd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_org_hngr_bar_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"pay_inv_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:120,  Align:"Right",   ColMerge:1,   SaveName:prefix+"mnr_inp_tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
		      InitColumns(cols);
		      SetEditable(1);
		      PopupImage="img/btns_search.gif";
		      SetShowButtonImage(2);
		      SetSelectionMode(smSelectionRow);
		      SelectHighLight=true;
		      SelectFontBold=false;
		      //SelectBackColor="#NANNANNAN";
		      SetSheetHeight(200);
		      
		      SetColProperty(0, prefix+"mnr_hngr_trf_otr_desc", {AcceptKeys:"E|N"});
		      SetColProperty(0 ,prefix+"yd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
		      
	      }


			break;
		case 2:      // sheet2 init
			  with(sheetObj){
				   var prefix="";
				   var HeadTitle1="|Evidence Attachment|Evidence Attachment|Evidence Attachment";
				   var HeadTitle2="|Seq.|File|Download";
				   var headCount=ComCountHeadTitle(HeadTitle1);
				   SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"},
				                   { Text:HeadTitle2, Align:"Center"} ];
				   InitHeaders(headers, info);
				   var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_chk" },
				             {Type:"Popup",     Hidden:0, Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
				             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				   InitColumns(cols);
				   SetEditable(1);
				   SetCountPosition(0);
				   SetImageList(0,"img/ico_attach.gif");
				   SetShowButtonImage(1);
				   SetSheetHeight(122);
		   		}
			break;
		case 3:      // sheet1 init
		    with(sheetObj){
		      var HeadTitle1="MNR_ORD_OFC_CTY_CD|MNR_ORD_SEQ|EQ_KND_CD|MNR_GRP_TP_CD|MNR_WO_TP_CD|COST_CD|TRSM_MOD_CD|AGMT_OFC_CTY_CD|AGMT_SEQ"
		      + "|AGMT_VER_NO|CURR_CD|MNR_AGMT_AMT|MNR_WRK_AMT|INV_AMT|ORD_ISS_OFC_CD|MNR_ORD_SND_DT|COST_OFC_CD|VNDR_SEQ"
		      + "|SPR_PRT_SPL_TP_CD|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|SPR_PRT_BRTH_DT|SPR_PRT_SPL_YD_CD|SPR_PRT_SPL_DT|ORD_HDR_RMK"
		      + "|FILE_SEQ|MNR_INP_DT|CRE_USR_ID|CRE_DT|UPD_USR_ID|UPD_DT" ;
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet3_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_grp_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wo_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"trsm_mod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ofc_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"agmt_ver_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_agmt_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_wrk_amt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_amt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_iss_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_snd_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_brth_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_hdr_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"file_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_inp_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetSelectionMode(smSelectionRow);
		      SelectHighLight=true;
		      SelectFontBold=false;
		      //SelectBackColor="#NANNANNAN";
		      SetVisible(0);
	      }


			break;
		}
	}
	/**
     * Processing of sheet process
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
		case IBCLEAR:
			doIBCLEAR(sheetObj, formObj, sAction);
			break;
		case IBSEARCH:      //Retrieving
			var isSearchOk=true;
			for(var i=0; i < sheetObjects.length; i++){
				if(sheetObjects[i].IsDataModified()== true){
					if(!ComShowCodeConfirm("MNR00007"))
					{
						isSearchOk=false;
					}
				}
			}
			if(isSearchOk){
				if(checkWorkOrderNo(sheetObj, formObj, sAction))
				{
					doIBSEARCH(sheetObj, formObj, sAction);
				}
			}
			break;
		case IBSAVE:        //Saving
			doIBSAVE(sheetObj, formObj, sAction);
			break;
		case COMMAND01:     //W/O Doc Send
			var strMnrOrdSeq=formObj.mnr_ord_seq.value;
			if(strMnrOrdSeq != "" && strMnrOrdSeq != "NEW" )
			{
				ComOpenPopup("EES_MNR_0036.do?wo_no="+strMnrOrdSeq, 900, 600, 'setDocSendParam', '0,1', true);
			}else{
				ComShowCodeMessage("MNR00024");
			}
			break;
		case IBSEARCHAPPEND:        //Deleting
			doIBREMOVE(sheetObj, formObj, sAction);
			break;
		}
	}
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		with (formObj) {
			if (!ComChkObjValid(formObj)) {
				return false;
			}
		}
		return true;
	}
/* ********* Event Functions Start ************* */
	/**
	 * Event handling of Onchange of combo(Agreement No)
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	//function combo_vndr_seq_OnChange(indexCode, Text){
	function combo_vndr_seq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		var formObj=document.form;
		if(searchFlg != "Y"){
			for(var i=sheetObjects[0].HeaderRows();i<sheetObjects[0].LastRow();i++)
			{
				var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
				if(intPayInvSeq =="") intPayInvSeq=0;
				if(parseInt(intPayInvSeq) > 0 )
				{
					ComShowCodeMessage("MNR00229");
					combo_vndr_seq.SetSelectCode(OrgVndrSeq,false);
					return false;
				}
			}
		}
		
		var strEtc=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  8 );
		var spltEtc=strEtc.split("^");
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
		formObj.curr_cd.value=spltEtc[0];
		var strAgmtNo=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  2 );
		if(strAgmtNo.length > 3)
		{
			formObj.agmt_ofc_cty_cd.value=strAgmtNo.substring(0,3);
			formObj.agmt_seq.value=strAgmtNo.substring(3);
		}
		var strAgmtVerNo=spltEtc[1];
		if ( ComIsNumber(strAgmtVerNo))
		{
			formObj.agmt_ver_no.value=strAgmtVerNo;
		}
		var arr=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()),  5 ).split("~");
		var tmpEffFrom="";
		var tmpEffTo="";
		if(arr==""){
			tmpEffFrom="";
			tmpEffTo="";
		}else{
			tmpEffFrom=arr[0];
			tmpEffTo=arr[1];
		}
		formObj.eff_dt.value=tmpEffFrom.trim();
		formObj.exp_dt.value=tmpEffTo.trim();
		combo_eq_knd_cd.SetSelectCode(spltEtc[2],false);
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
//				sheet1_cost_dtl_cd_Initialize(Text);
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}else{
				combo_cost_cd.SetSelectCode(OrgCostType,false);
				if(combo_cost_cd.GetSelectCode()==""){
//					sheet1_cost_dtl_cd_Initialize(Text);
					sheetObjects[1].RemoveAll();
					sheetObjects[2].RemoveAll();
				}
			}
		}
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	/**
	 * Event handling of Onchange of combo
	 * @param indexCode
	 * @param Text
	 * @return
	 */
	//function combo_cost_cd_OnChange(indexCode, Text){
	function combo_cost_cd_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
		setSheetColumnDisplay(NewCode);
		var cnt=10;
		if(searchFlg != "Y"){
			for(var i=sheetObjects[0].HeaderRows();i<sheetObjects[0].LastRow();i++)
			{
				var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
				if(intPayInvSeq =="") intPayInvSeq=0;
				if(parseInt(intPayInvSeq) > 0 )
				{
					ComShowCodeMessage("MNR00229");
					combo_vndr_seq.SetSelectCode(OrgCostCd,false);
					return false;
				}
			}
		}
		
		
		if(comboObj.GetSelectCode() == 'MRDRHA' || comboObj.GetSelectCode() == 'MRDRHD'){
			if(combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
				sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",0);
			}else{
				sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
			}
			var info = { EditLen:3 };
			sheetObjects[0].InitCellProperty(0, "sheet1_rpr_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_act_invt_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_hngr_dmg_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_lost_hngr_qty",	info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_disp_hngr_qty", info);
		} else {
			if(combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
				sheetObjects[0].SetColHidden("sheet1_bkg_no",0);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",0);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",0);
			}else{
				sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
				sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
				sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
			}
			var info = { EditLen:6 };
			sheetObjects[0].InitCellProperty(0, "sheet1_rpr_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_act_invt_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_hngr_dmg_qty", info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_lost_hngr_qty",	info);
			sheetObjects[0].InitCellProperty(0, "sheet1_mnr_disp_hngr_qty", info);
//			sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
//			sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
//			sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
		}
		var formObj=document.form;
		if((sheetObjects[0].RowCount()) > 0  && nowLoad == 0){
			if(ComShowCodeConfirm("MNR00080")){
				sheet1_cost_dtl_cd_Initialize(NewCode);
				sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
			}
		} else {
			sheet1_cost_dtl_cd_Initialize(NewCode);
			sheet1_mnr_hngr_bar_tp_cd_Initialize("CD00022");
		}
		OrgCostType=combo_cost_cd.GetSelectCode();
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
		costCdSubstr=combo_cost_cd.GetSelectCode();
		if(costCdSubstr.length >= 5){
			costCdSubstr=costCdSubstr.substr(0,5);
		}
	}
   /**
    * Event handling of search end of sheet1
    * @param sheetObj
    * @return
    */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()> 0){
			var sDate=ComGetNowInfo("ymd");
			var formObj=document.form;
	    	for(var i=sheetObjects[0].HeaderRows();i<sheetObjects[0].LastRow();i++){
	    		if(sheetObj.GetCellValue(i,"sheet1_mnr_hngr_rck_cd")=="O"){
					sheetObj.SetCellEditable(i, "sheet1_cost_dtl_cd",0);
					sheetObj.SetCellValue(i,"sheet1_mnr_hngr_bar_tp_cd","S",0);
					sheetObj.SetCellEditable(i, "sheet1_mnr_hngr_bar_tp_cd",0);
				} else {
					sheetObj.SetCellEditable(i, "sheet1_cost_dtl_cd",1);
					sheetObj.SetCellEditable(i, "sheet1_mnr_hngr_bar_tp_cd",1);
				}
				sheetObj.SetCellValue(i,"sheet1_mnr_hngr_flg_dt",sDate,0);
				sheetObj.SetCellValue(i,"sheet1_eq_knd_cd",combo_eq_knd_cd.GetSelectCode(),0);
			}
		}
    }
	/**
	 * Showing result message after saving
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "" || errMsg == undefined) {
				if(strMnrOrdSeq == "" || strMnrOrdSeq == "NEW" )
				{
					ComShowCodeMessage("MNR00073");
				} else {
					ComShowCodeMessage("MNR00222");
				}
			} else {
				ComShowCodeMessage("MNR00074",errMsg);
			}
			
			var f_gubuns=formObj.f_gubuns.value;
			if(MnrComGetErrMsg(sXml_1) == null && f_gubuns==""){
				var mnrOrdSeq=ComGetEtcData(sXml_1, "mnr_ord_seq");
				formObj.mnr_ord_seq.value=mnrOrdSeq;
				MnrFormSetReadOnly(formObj,true,"mnr_ord_seq");
				doIBSEARCH(sheetObj, formObj, IBSEARCH);
			} else {
				formObj.f_gubuns.value="";
			}
			
		} else if(formObj.f_cmd.value == REMOVE)
		{
			if (errMsg == "" || errMsg == undefined) {
				ComShowCodeMessage("MNR00082");
			} else {
				ComShowCodeMessage("MNR00027");
			}
			
			if(MnrComGetErrMsg(sXml_2) == null){
				var mnrOrdSeq=ComGetEtcData(sXml_2, "mnr_ord_seq");
				
				doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
			}
		}
		nowLoad=0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
	}
	/**
	 * Event handling of change of sheet1
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(nowLoad == 0){
			var intPayInvSeq=sheetObj.GetCellValue(Row,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 && sheetObj.CellSearchValue(Row, Col) != Value  )
			{
				ComShowCodeMessage("MNR00229");
				sheetObj.SetCellValue(Row,Col, sheetObj.CellSearchValue(Row, Col), 0);
				return false;
			}
			
			var formObj=document.form;
			if(sheetObj.ColSaveName(Col) != "del_chk"){
				ComBtnEnable("btn_W/O_Creation");
				ComBtnDisable("btn_W/O_Send");
			}
			if(sheetObj.ColSaveName(Col) == "sheet1_cost_dtl_cd"){
				sheetObj.SetCellValue(Row,"sheet1_mnr_rt_tp_cd",Value,0);
				sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value);
				if(Value == "M1" || Value == "MD"){
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_dtl_offr_desc",1);
				} else {
					sheetObj.SetCellValue(Row,"sheet1_mnr_hngr_dtl_offr_desc","",0);
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_dtl_offr_desc",0);
				}
				if(Value == "RD" || Value == "BD" || Value == "ED"){
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd",0);
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_trf_cd",0);
					sheetObj.SetCellEditable(Row,"sheet1_rpr_qty",0);
				} else {
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd",1);
					sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_trf_cd",1);
					sheetObj.SetCellEditable(Row,"sheet1_rpr_qty",1);
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_rpr_qty" && costCdSubstr !="MRDRH"){
				if(sheetObj.GetCellValue(Row,"sheet1_cost_dtl_cd") == "M1" || sheetObj.GetCellValue(Row,"sheet1_cost_dtl_cd") == "MD"){
					sheetObj.SetCellValue(Row,"sheet1_mnr_hngr_dtl_offr_desc","",0);
				}
				doCalculate(sheetObj, Row, Col, Value);
			} else if(sheetObj.ColSaveName(Col) == "sheet1_spr_prt_uc_amt" && costCdSubstr !="MRDRH"){
				doCalculate(sheetObj, Row, Col, Value);
			} else if(sheetObj.ColSaveName(Col) == "sheet1_eq_no" && costCdSubstr != "MRDRH"){
				var checkEqn=sheetObjects[0].GetCellValue(Row,"sheet1_eq_no");
				if(checkEqn == ""){
					return;
				} else {
					sheetObjects[0].SetCellValue(Row,"sheet1_eq_no",checkEqn.toUpperCase(),0);
					checkEqn=checkEqn.toUpperCase();
					var sEqType=combo_eq_knd_cd.GetSelectCode();
					var sEqNo=checkEqn;
					var sDate=ComGetNowInfo("ymd");
					var sCostType="";
					if(combo_eq_knd_cd.GetSelectCode()== "U"){
						sCostType="MRDRRC";
					} else if(combo_eq_knd_cd.GetSelectCode()== "G"){
						sCostType="MRGSRC";
					} else {
						sCostType="MRZSRC";
					}
					var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sDate,sCostType);
					var retArr=MnrXmlToArray(sXml);
					if(retArr == null){
						ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
						sheetObjects[0].SetCellValue(Row,"sheet1_eq_no","",0);
						sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
						return;
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_eq_no" && costCdSubstr == "MRDRH"){
				var checkEqn=sheetObjects[0].GetCellValue(Row,"sheet1_eq_no");
				if(checkEqn == ""){
					return;
				} else {
					sheetObjects[0].SetCellValue(Row,"sheet1_eq_no",checkEqn.toUpperCase(),0);
					checkEqn=checkEqn.toUpperCase();
					var sEqType=combo_eq_knd_cd.GetSelectCode();
					var sEqNo=checkEqn;
					var sDate=ComGetNowInfo("ymd");
					var sCostType="";
					if(combo_eq_knd_cd.GetSelectCode()== "U"){
						sCostType="MRDRRC";
					} else if(combo_eq_knd_cd.GetSelectCode()== "G"){
						sCostType="MRGSRC";
					} else {
						sCostType="MRZSRC";
					}
					var sXml=MnrComEqGenInfoSearch(sheetObj,sEqType,sEqNo,sDate,sCostType);
					var retArr=MnrXmlToArray(sXml);
					var mnr_hngr_bar_tp_cd="";
					var rpr_qty="";
					var recent_rpr_qty="";
					var mnr_hngr_rck_cd="";
					//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
					//|33 total_loss_date|34 rpr_cost_amt|35 dpp_amt|36 mnr_hngr_trf_cd|37 mnr_hngr_trf_otr_desc|38 act_invt_qty|39 mnr_hngr_dmg_qty|40 mnr_lost_hngr_qty|41 mnr_disp_hngr_qty
					if(retArr != null){
						if(costCdSubstr == "MRDRH" ){
							if(retArr[0][17]==""){
								mnr_hngr_rck_cd="R";
							} else {
								mnr_hngr_rck_cd=retArr[0][17];
							}
							if(retArr[0][24]==""){
								mnr_hngr_bar_tp_cd="S";
							} else {
								mnr_hngr_bar_tp_cd=retArr[0][24];
							}
							rpr_qty="0";
							recent_rpr_qty=retArr[0][22];
							if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
								if(retArr[0][22] != "0"){
									ComShowCodeMessage("MNR00354",checkEqn);
									sheetObjects[0].SetCellValue(Row,"sheet1_eq_no","",0);
									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return;
								}
							} else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
								if(retArr[0][22] == "0"){
									ComShowCodeMessage("MNR00355",checkEqn);
									sheetObjects[0].SetCellValue(Row,"sheet1_eq_no","",0);
									sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
									return;
								}
							}
							var costDtlCd=sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd");
							if(mnr_hngr_rck_cd=="O"){
								if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","RA",0);
								}else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","RD",0);
								}
								sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_bar_tp_cd","S",0);
								sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd",0);
								sheetObjects[0].SetCellEditable(Row, "sheet1_cost_dtl_cd",0);
							} else if(mnr_hngr_rck_cd=="R"){
								if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","BA",0);
								} else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","BD",0);
								}
								sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd",1);
								sheetObjects[0].SetCellEditable(Row, "sheet1_cost_dtl_cd",1);
							} else if(mnr_hngr_rck_cd=="D"){
								if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","EA",0);
								} else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
									sheetObjects[0].SetCellValue(Row,"sheet1_cost_dtl_cd","ED",0);
								}
								sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd",1);
								sheetObjects[0].SetCellEditable(Row, "sheet1_cost_dtl_cd",1);
							} else {
								sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_bar_tp_cd",1);
								sheetObjects[0].SetCellEditable(Row, "sheet1_cost_dtl_cd",1);
							}
							if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd")=="RA"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","BA",0);
									} else {
										sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","EA",0);
									}
								}
								sheetObjects[0].SetCellValue(Row,"sheet1_rpr_qty",rpr_qty,0);
							} else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
								if(mnr_hngr_rck_cd != "O" && sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd")=="RD"){
									ComShowCodeMessage("MNR00331");
									if(mnr_hngr_rck_cd=="R"){
										sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","BD",0);
									} else {
										sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","ED",0);
									}
								}
								sheetObjects[0].SetCellValue(Row,"sheet1_rpr_qty",recent_rpr_qty,0);
								sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_trf_cd",retArr[0][36],0);
								sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_trf_otr_desc",retArr[0][37],0);
							}
							sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_flg_yd_cd",retArr[0][18],0);
							sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_rck_cd",mnr_hngr_rck_cd,0);
							sheetObjects[0].SetCellValue(Row,"sheet1_eq_tpsz_cd",retArr[0][31],0);
							sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_bar_tp_cd",mnr_hngr_bar_tp_cd,0);
							sheetObjects[0].SetCellValue(Row,"sheet1_mnr_org_hngr_bar_tp_cd",mnr_hngr_bar_tp_cd,0);
							sheetObjects[0].SetCellValue(Row,"sheet1_recent_rpr_qty",recent_rpr_qty,0);
							sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_flg_dt",sDate,0);
							sheetObjects[0].SetCellValue(Row,"sheet1_eq_knd_cd",combo_eq_knd_cd.GetSelectCode(),0);
							if(sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd") == "RD" || sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd") == "BD" || sheetObjects[0].GetCellValue(Row,"sheet1_cost_dtl_cd") == "ED"){
								sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd",0);
								sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_trf_cd",0);
								sheetObj.SetCellEditable(Row,"sheet1_rpr_qty",0);
							} else {
								if(mnr_hngr_rck_cd!="O"){
									sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_bar_tp_cd",1);
								}
								sheetObj.SetCellEditable(Row,"sheet1_mnr_hngr_trf_cd",1);
								sheetObj.SetCellEditable(Row,"sheet1_rpr_qty",1);
							}
						}
					} else {
						ComShowCodeMessage("MNR00165",checkEqn,"EQ No.");
						sheetObjects[0].SetCellValue(Row,"sheet1_eq_no","",0);
						sheetObjects[0].SelectCell(Row,"sheet1_eq_no");
						return;
					}
					
					if(sheetObj.GetCellValue(Row,"sheet1_eq_no") != "" && sheetObj.GetCellValue(Row,"sheet1_rpr_rslt_dt") != ""&&combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
						var code = MnrGetBkgTrdCd(sheetObj, checkEqn, sheetObj.GetCellValue(Row, "sheet1_rpr_rslt_dt"), combo_cost_cd.GetSelectCode(), combo_eq_knd_cd.GetSelectCode(), sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd"));
						if(code != ""){
							var arrCode = code.split("|");
							sheetObj.SetCellValue(Row, "sheet1_bkg_no", arrCode[0], 0);
							sheetObj.SetCellValue(Row, "sheet1_trd_cd", arrCode[1], 0);
						}else{
							sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
							sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
						}
					}else{
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
					}
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_mnr_hngr_trf_cd"){
				if(Value == "OT"){
					sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_trf_otr_desc",1);
				} else {
					sheetObjects[0].SetCellEditable(Row, "sheet1_mnr_hngr_trf_otr_desc",0);
					sheetObjects[0].SetCellValue(Row,"sheet1_mnr_hngr_trf_otr_desc","",0);
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_rpr_rslt_dt"){
				if(sheetObj.GetCellValue(Row,"sheet1_eq_no") != "" && sheetObj.GetCellValue(Row,"sheet1_rpr_rslt_dt") != ""&&combo_cost_cd.GetText(parseInt(combo_cost_cd.GetSelectIndex()), 3) != ""){
					var code = MnrGetBkgTrdCd(sheetObj, sheetObj.GetCellValue(Row,"sheet1_eq_no"), sheetObj.GetCellValue(Row, "sheet1_rpr_rslt_dt"), combo_cost_cd.GetSelectCode(), combo_eq_knd_cd.GetSelectCode(), sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd"));
					if(code != ""){
						var arrCode = code.split("|");
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", arrCode[0], 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", arrCode[1], 0);
					}else{
						sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
						sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
					}
					return;
				}else{
					sheetObj.SetCellValue(Row, "sheet1_bkg_no", "", 0);
					sheetObj.SetCellValue(Row, "sheet1_trd_cd", "", 0);
				}
			} else if(sheetObj.ColSaveName(Col) == "sheet1_yd_cd"){
				var strYard=sheetObj.GetCellValue(Row,"sheet1_yd_cd");
				var retArray=MnrGeneralCodeCheck(sheetObj,"YARD",strYard);
				if(retArray == null){
					ComShowCodeMessage("MNR00165",strYard,"Yard");
					sheetObj.SetCellValue(Row,"sheet1_yd_cd","",0);
					sheetObj.SelectCell(Row,"sheet1_yd_cd");
					return;
				}else{
					if(sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd") != ""){
						sheet1_cost_dtl_cd_OnChange(sheetObj,Row, "sheet1_cost_dtl_cd", sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd"));
					}
					
				}
			}
		}
	}
	
	/**
	 * Event handling of change of sheet2
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet2_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) != "del_chk"){
			ComBtnEnable("btn_W/O_Creation");
			ComBtnDisable("btn_W/O_Send");
		}
	}
	
	/**
	 * Event handling of change of sheet1
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function sheet1_cost_dtl_cd_OnChange(sheetObj,Row, Col, Value){
		var formObj=document.form;
		if(combo_cost_cd.GetSelectCode()=="MRDRHA" || combo_cost_cd.GetSelectCode()=="MRDRHD"){
			if(combo_cost_cd.GetSelectCode()=="MRDRHA"){
				if(sheetObj.GetCellValue(Row,  "sheet1_mnr_hngr_rck_cd")!="O" && Value=="RA" && sheetObj.GetCellValue(Row,  "sheet1_eq_no")!=""){
					ComShowCodeMessage("MNR00331");
					if(sheetObj.GetCellValue(Row,  "sheet1_mnr_hngr_rck_cd")=="R"){
						sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","BA",0);
					}else{
						sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","EA",0);
					}
				}
			}else if(combo_cost_cd.GetSelectCode()=="MRDRHD"){
				if(sheetObj.GetCellValue(Row,  "sheet1_mnr_hngr_rck_cd")!="O" && Value=="RD" && sheetObj.GetCellValue(Row,  "sheet1_eq_no")!=""){
					ComShowCodeMessage("MNR00331");
					if(sheetObj.GetCellValue(Row,  "sheet1_mnr_hngr_rck_cd")=="R"){
						sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","BD",0);
					}else{
						sheetObj.SetCellValue(Row,"sheet1_cost_dtl_cd","ED",0);
					}
				}
			}
		} 
//		else {
		if(sheetObj.GetCellValue(Row, "sheet1_yd_cd")!=""){
			MnrWaitControl(true);
			nowLoad=1;
//			formObj.f_cmd.value=SEARCH01;
//			var sParam="";
//			var aryPrefix=new Array("sheet1_");
//			sParam += ComGetPrefixParam(aryPrefix)
//					+ "&f_cmd=101"
//					+ "&ibflag=X"
//					+ "&del_chk=0"
//					+ "&cost_dtl_cd="+ sheetObj.GetCellValue(Row, Col)
//					+ "&agmt_ofc_cty_cd="+ (combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 )).substring(0, 3)
//					+ "&cost_cd="+ combo_cost_cd.GetSelectCode()
//					+ "&mnr_rt_tp_cd="+ sheetObj.GetCellValue(Row, Col)
//					+ "&agmt_seq=" + combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 ).substring(3)
//					+ "&agmt_ver_no=" + formObj.agmt_ver_no.value
//					+ "&yd_cd=" + sheetObj.GetCellValue(Row, "sheet1_yd_cd");
//			 
//			var sXml=sheetObj.GetSearchData("EES_MNR_0058GS.do", sParam);
			var sAgmtOfcCtyCd = (combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 )).substring(0, 3);
			var sAgmtSeq = combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 2 ).substring(3);
			var sAgmtVerNo = formObj.agmt_ver_no.value;
			var sCostCd = combo_cost_cd.GetSelectCode();
			var sCostDtlCd=sheetObj.GetCellValue(Row, Col);
			var sMnrRtTpCd=sheetObj.GetCellValue(Row, Col);
			var sYdCd=sheetObj.GetCellValue(Row, "sheet1_yd_cd");

			var iAgmtRtAmt=0;
			var iRprQty=1;
			var iUnitCost=0;

			var sXml=MnrAgmtRateInfoSearch(sheetObj,sAgmtOfcCtyCd,sAgmtSeq,sAgmtVerNo,sCostCd,sCostDtlCd,sMnrRtTpCd,sYdCd);
			var retArr=MnrXmlToArray(sXml);
			if(retArr != null){
				iAgmtRtAmt=retArr[0][1]; //agmt_rt_amt
				iRprQty=((retArr[0][7]==0)?1:retArr[0][7]); //rpr_qty
				if(iAgmtRtAmt != 0)
					iUnitCost=iAgmtRtAmt/iRprQty;
				
				if((iRprQty <= 0)||(iAgmtRtAmt <= 0)){
					nowLoad=0;
					MnrWaitControl(false);
					ComBtnDisable("btn_W/O_Send");
					return;
				}else{
					var unitAmt = Math.floor((parseFloat(iAgmtRtAmt)/parseFloat(iRprQty))*100)/100;
					sheetObjects[0].SetCellValue(Row, "sheet1_eq_no","");
					sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt",iAgmtRtAmt);
					sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty",iRprQty);
					sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt",unitAmt);
					sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",iAgmtRtAmt);
				}
				
			}else{
				//sheetObjects[0].CellValue(Row, "sheet1_eq_no") = "";
				sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt","");
				sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty","1");
				sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt","");
				sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt","");
				MnrWaitControl(false);
				ComBtnDisable("btn_W/O_Send");
				nowLoad=0;
				return;
			}
			
//			var comboLst=getDataString(sXml, "sheet1_rpr_qty", "sheet1_agmt_rt_amt");
//			if (typeof(comboLst)== "undefined" )
//			{
//				//sheetObjects[0].CellValue(Row, "sheet1_eq_no") = "";
//				sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt","");
//				sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty","1");
//				sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt","");
//				sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt","");
//				MnrWaitControl(false);
//				ComBtnDisable("btn_W/O_Send");
//				nowLoad=0;
//				return;
//			}
//			if (comboLst != null)
//			{
//				var rprqty=comboLst.substring(0, comboLst.indexOf('|'));
//				var amt=comboLst.substring(comboLst.indexOf('|') + 1);
//				if((rprqty <= 0)||(amt <= 0)){
//					nowLoad=0;
//					MnrWaitControl(false);
//					ComBtnDisable("btn_W/O_Send");
//					return;
//				}else{
//					var unitAmt = Math.floor((parseFloat(amt)/parseFloat(rprqty))*100)/100;
//					sheetObjects[0].SetCellValue(Row, "sheet1_eq_no","");
//					sheetObjects[0].SetCellValue(Row, "sheet1_bzc_amt",amt);
//					sheetObjects[0].SetCellValue(Row, "sheet1_rpr_qty",rprqty);
//					sheetObjects[0].SetCellValue(Row, "sheet1_spr_prt_uc_amt",unitAmt);
//					sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",amt);
//				}
//			}
			nowLoad=0;
			MnrWaitControl(false);
		}
			
//		}
		ComBtnDisable("btn_W/O_Send");
	}
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObj=document.form;
		if (sheetObj.ColSaveName(Col) == "sheet1_rpr_rslt_dt") {
			var cal=new ComCalendarGrid();
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
			return;
		}
		
		if (sheetObj.ColSaveName(Col) != "sheet1_mnr_hngr_dtl_offr_desc") return;
		if(sheetObj.GetCellValue(Row, "sheet1_rpr_qty") == "0") return;
		var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(Row, "sheet1_cost_dtl_cd")," ");
		if(strCostDtlCD == "M1" || strCostDtlCD == "MD")
		{
			var param='?rpr_qty=' + sheetObj.GetCellValue(Row, "sheet1_rpr_qty") + '&';
				param += 'sheet_id=' + '0' + '&';
				param += 'presetData=' +  sheetObj.GetCellValue(Row, "sheet1_mnr_hngr_dtl_offr_desc") + '&';
				param += 'targetRow=' +  Row;
			ComOpenPopup('EES_MNR_OFCINFOMULTI.do' + param, 400, 440, 'getMnr_ofcInfoMulti', '1,0,1,1,1,1,1,1,1,1,1,1', true);
//				ComOpenWindow('EES_MNR_OFCINFOMULTI.do' + param, sWinName, sFeatures, bModal)
		}
    }
	/**
	 * Event handling of click of sheet1 <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {ibsheet} Row     	Selected row
	 * @param {ibsheet} Col     	Selected column
	 * @param {String} 	Value		Selected value
	 **/
	function sheet2_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}
	
	
	/**
	 * Event handling of search end of sheet3
	 * @param sheetObj
	 * @param errMsg
	 * @return
	 */
	function sheet3_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet3_";
		if(sheetObj.RowCount()<= 0)
		{
			nowLoad=0;
			doIBCLEAR(sheetObjects[0], formObj, IBCLEAR);
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComShowCodeMessage("MNR00005", "W/O No.");
			ComSetFocus(formObj.mnr_ord_seq);
			MnrWaitControl(false);
			ComBtnDisable("btn_W/O_Send");
			return false;
		}
		combo_vndr_seq.UseCode=false;
		var agree_no=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd") + ComLpad(sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq"),6,"0");
		combo_vndr_seq.SetSelectIndex(combo_vndr_seq.FindItem(agree_no,2, true));
		OrgVndrSeq=combo_vndr_seq.GetSelectCode();
//		combo_vndr_seq.UseCode=true;
		formObj.pic_eng_nm.value=combo_vndr_seq.GetText(parseInt(combo_vndr_seq.GetSelectIndex()), 0 );
		combo_eq_knd_cd.SetSelectCode(sheetObjects[2].GetCellValue(1, prefix+ "eq_knd_cd"),false);
		formObj.curr_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "curr_cd");
		formObj.agmt_ofc_cty_cd.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ofc_cty_cd");
		formObj.agmt_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_seq");
		formObj.agmt_ver_no.value=sheetObjects[2].GetCellValue(1, prefix+ "agmt_ver_no");
		formObj.file_seq.value=sheetObjects[2].GetCellValue(1, prefix+ "file_seq");
		formObj.showDate.value=sheetObjects[2].GetCellValue(1, prefix+ "cre_dt");
		var costcd=sheetObjects[2].GetCellValue(1, prefix+ "cost_cd");
		OrgCostCd=costcd;
		combo_cost_cd_Initialize(combo_eq_knd_cd.GetSelectCode());
		combo_cost_cd.SetSelectCode(costcd);
		formObj.ord_hdr_rmk.value=sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
		ord_hdr_rmk_org =sheetObjects[2].GetCellValue(1, prefix+ "ord_hdr_rmk");
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			if(i>0)break;
			sheetObjects[i].RenderSheet(0);
			if (i > 0) {
				sheetObjects[i].SetWaitImageVisible(0);
			}
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
			sheetObjects[i].RenderSheet(1);
		}
		var prefix="sheet1_";
		var ArrCostDtlDesc=costDtlDesc.split("|");
		var ArrMnrHngrBarTpCdDesc=mnrHngrBarTpDesc.split("|");
		for(var i=sheetObjects[0].HeaderRows();i<=sheetObjects[0].LastRow();i++)
		{
			var idx=sheetObjects[0].GetComboInfo(i, prefix+ "cost_dtl_cd", "SelectedIndex");
			var idx2=sheetObjects[0].GetComboInfo(i, prefix+ "mnr_hngr_bar_tp_cd", "SelectedIndex");
			sheetObjects[0].SetCellText(i, prefix+ "cost_dtl_cd" ,ArrCostDtlDesc[idx]);
			sheetObjects[0].SetCellText(i, prefix+ "mnr_hngr_bar_tp_cd" ,ArrMnrHngrBarTpCdDesc[idx2]);
			
		}
		var fileSeq=formObj.file_seq.value;
		if(fileSeq != "" || fileSeq != undefined){
			var fileXml=SearchFileUpload(sheetObjects[1],fileSeq);
			sheetObjects[1].LoadSearchData(fileXml,{Sync:1} );
		}
		searchFlg = "N";
		nowLoad=0;
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Creation");
		
		for(var i=sheetObjects[0].HeaderRows();i<sheetObjects[0].LastRow();i++){
			var intPayInvSeq=sheetObjects[0].GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				sheetObjects[0].SetEditable(0);
				sheetObjects[1].SetEditable(0);
				MnrFormSetReadOnly(formObj,true,"ord_hdr_rmk");
				ComBtnDisable("btn_File_Add");
				ComBtnDisable("btn_File_Del");
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowDel");
				ComBtnDisable("btn_delete");
				break;
			}else{
				sheetObjects[0].SetEditable(1);
				sheetObjects[1].SetEditable(1);
				MnrFormSetReadOnly(formObj,false,"ord_hdr_rmk");
				ComBtnEnable("btn_File_Add");
				ComBtnEnable("btn_File_Del");
				ComBtnEnable("btn_RowAdd");
				ComBtnEnable("btn_RowDel");
				ComBtnEnable("btn_delete");
			}
		}
		oldWoNo = formObj.mnr_ord_seq.value;
	}
/* ********* Event Functions End ************* */
/* ********* User Functions ************* */
	/**
	 * (Agreement No) Initializing
	 * @return
	 */
	function combo_vndr_seq_Initialize(){
		var formObj=document.form;
		var sXml=MnrAGMTHdrCombo(sheetObjects[0],formObj.cost_ofc_cd.value);
		var arrResult=MnrXmlToArray(sXml);
		if(arrResult != null){
			for(var i=0; i < arrResult.length;i ++){
				var tempComboText=arrResult[i][8]       //8 vndr_nm|
				                 + "|" + arrResult[i][1]  //1 vndr_seq|
				                 + "|" + arrResult[i][9]  //9 agmt_no|
				     			 + "|" + arrResult[i][30]  //29 agmt_ofc_cd|
				                 + "|" + arrResult[i][3]   //3eq_type_name|
				                 + "|" + arrResult[i][13] +"~" + arrResult[i][15]  //  13 eff_dt - 15 exp_dt|
				                 + "|" + arrResult[i][2] //2 agmt_ref_no|
				                 + "|" + arrResult[i][25]   //25 trf_no|
				                 + "|" + arrResult[i][14] //14 curr_cd|
				                 + "^" + arrResult[i][12]   //12 agmt_ver_no|
	                             + "^" + arrResult[i][28]   //28eq_knd_cd|
				                  ;
				combo_vndr_seq.InsertItem(i, tempComboText ,arrResult[i][1]);
			}
		} else {
			ComShowCodeMessage("MNR00056");
		}
		combo_vndr_seq.SetSelectCode("");
	}
	/**
	 * Initializing (Cost Type)
	 * @param eqtype
	 * @return
	 */
	function combo_cost_cd_Initialize(eqtype){
		var formObj=document.form;
		combo_cost_cd.SetSelectCode("-1",false);
		combo_cost_cd.RemoveAll();
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (
				new Array("MnrGenCd",eqtype, "CUSTOM6") //Cost Type
		);
//		var comboList=MnrComSearchCombo(sheetObj,sCondition);
//		for(var i=0; i < comboList.length;i++)
//		{
//			if(comboList[i] != null)
//			{
//				for(var j=0; j < comboList[i].length;j++)
//				{
//					var tempText=comboList[i][j].split("|");
//					if(i==0)
//					{	
//						var tempTxt = tempText[0]+"-"+tempText[1];
//						if(tempText[0]=="MRRFPM"){  //PM
//							if(currOfcCd=="PUSBO" || currOfcCd =="KANBO" || currOfcCd =="INCBO"|| currOfcCd =="SELBB"){
//								combo_cost_cd.InsertItem(j, tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
//							}
//						}else{
//							combo_cost_cd.InsertItem(j, tempText[0]+"|"+tempText[1]+"|"+tempTxt,tempText[0]);
//						}
//					}
//				}
//				if(i==0)
//				{
//					if(combo_cost_cd.FindItem("Reefer Spare Part Purchase", 0, true) != -1){
//						combo_cost_cd.DeleteItem(combo_cost_cd.FindItem("Reefer Spare Part Purchase", 0, true));
//					}
//				}
//			}
//		}
		var f_query = 'f_cmd' + '=' + SEARCH + '&';
		f_query += 'ibflag=X&';
		f_query += 'del_chk=0&';
		f_query += 'searchinfo' + '=' + "MnrGenCd" + '&';
		f_query += 'searchkey' + '=' + eqtype + '&';
		f_query += 'searchcon' + '=' + "CUSTOM6" + '&';
		// 마지막에 &를 없애기 위함
		f_query=MnrDelLastDelim(f_query);
	    var sXml=sheetObj.GetSearchData("MNR_COMGS.do", f_query);
	    var comboList=MnrXmlToArray(sXml);

		for(var i=0; i < comboList.length;i++)
		{
			if(comboList[i] != null)
			{
//				for(var j=0; j < comboList[i].length;j++)
//				{
//					var tempText=comboList[i][j].split("|");
//					if(i==0)
//					{
//						var tempTxt = tempText[2]+"-"+tempText[0];
//						combo_cost_cd.InsertItem(j, tempText[2]+"|"+tempText[0]+"|"+ tempTxt + "|" + tempText[4],tempText[2]);
//					}
//				}
				var tempTxt = comboList[i][2]+"-"+comboList[i][0];
				combo_cost_cd.InsertItem(i, comboList[i][2]+"|"+comboList[i][0]+"|"+ tempTxt + "|" + comboList[i][4],comboList[i][2]);
			}
		}
		
//		if(combo_cost_cd.FindItem("MRRUSP", 0, true) != -1){
//			combo_cost_cd.DeleteItem(combo_cost_cd.FindItem("MRRUSP", 0, true));
//		}
		
		combo_cost_cd.SetSelectCode(OrgCostType);
		ComBtnEnable("btn_W/O_Creation");
		ComBtnDisable("btn_W/O_Send");
	}
	/**
	 * Initializing combo of sheet (Extra Expense Type Sheet Combo)
	 * @param costtype
	 * @return
	 */
	function sheet1_cost_dtl_cd_Initialize(costtype){
		if(nowLoad==0) {
			sheetObjects[0].RemoveAll();
			sheetObjects[0].SetColProperty(0,"sheet1_cost_dtl_cd", {ComboText:"", ComboCode:""} );
		}
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (new Array("MnrGenCd",costtype, "COMMON")); //Service Sub Type
		costDtlCode="";
		costDtlDesc="";
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++) {
			if(comboList[i] != null) {
				for(var j=0; j < comboList[i].length;j++) {
					var tempText=comboList[i][j].split("|");
					if(i==0) {
						costDtlCode=costDtlCode + tempText[0] + "|";
						costDtlDesc=costDtlDesc + tempText[1] + "|";
					}
				}
				if(i==0) {
					costDtlCode=costDtlCode.substring(0, costDtlCode.length - 1);
					costDtlDesc=costDtlDesc.substring(0, costDtlDesc.length - 1);
					sheetObjects[0].SetColProperty(0,"sheet1_cost_dtl_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
				}
			}
		}
	}
	/**
	 * Initializing combo of sheet {MNR_HNGR_BAR_TP_CD Sheet Combo}
	 * @param costtype
	 * @return
	 */
	function sheet1_mnr_hngr_bar_tp_cd_Initialize(costtype){
		if(nowLoad==0)sheetObjects[0].RemoveAll();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var sCondition=new Array (new Array("MnrGenCd",costtype, "COMMON")); //Service Sub Type
		mnrHngrBarTpCode="";
		mnrHngrBarTpDesc="";
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		for(var i=0; i < comboList.length;i++) {
			if(comboList[i] != null) {
				for(var j=0; j < comboList[i].length;j++) {
					var tempText=comboList[i][j].split("|");
					if(i==0) {
						mnrHngrBarTpCode=mnrHngrBarTpCode + tempText[0] + "|";
						mnrHngrBarTpDesc=mnrHngrBarTpDesc + tempText[1] + "|";
					}
				}
				if(i==0) {
					mnrHngrBarTpCode=mnrHngrBarTpCode.substring(0, mnrHngrBarTpCode.length - 1);
					mnrHngrBarTpDesc=mnrHngrBarTpDesc.substring(0, mnrHngrBarTpDesc.length - 1);
					sheetObjects[0].SetColProperty(0,"sheet1_mnr_hngr_bar_tp_cd", {ComboText:mnrHngrBarTpDesc, ComboCode:mnrHngrBarTpCode} );
				}
			}
		}
	}
	/**
	 * Initializing at loading
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBCLEAR(sheetObj, formObj, sAction) {
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboDefault="";
		MnrWaitControl(true);
		formObj.f_gubuns.value="";
		formObj.mnr_ord_seq.value="NEW";
		MnrFormSetReadOnly(formObj,false,"mnr_ord_seq");
		formObj.showDate.value=ComGetNowInfo();
		formObj.cost_ofc_cd.value=currOfcCd;
		formObj.pic_eng_nm.value="";
		formObj.eff_dt.value="";
		formObj.exp_dt.value="";
		formObj.curr_cd.value="";
		formObj.cost_cd.value="";
		combo_vndr_seq.SetSelectCode("-1",false);
		combo_vndr_seq.RemoveAll();
		combo_cost_cd.SetSelectCode("-1",false);
		combo_cost_cd.RemoveAll();
		combo_eq_knd_cd.SetSelectCode("-1",false);
		combo_eq_knd_cd.RemoveAll();
		formObj.ord_hdr_rmk.value="";
		var sCondition=new Array (
			//MultiCombo
			new Array("MnrGenCd","","CUSTOM9"),
			//combo of sheet
			new Array("MnrGenCd","CD00092", "COMMON")
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		//*** EQ_TYPE
		if(comboList[0] != null) {
			for(var j=0; j < comboList[0].length;j++){
				var tempText=comboList[0][j].split("|");
				combo_eq_knd_cd.InsertItem(j, comboList[0][j] ,tempText[0]);
			}
		}
		combo_eq_knd_cd.SetSelectCode("");
		//Tariff Type
		if(comboList[1] != null){
			for(var j=0; j < comboList[1].length;j++){
				var tempText=comboList[1][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				if(j == 0){
					sheetComboDefault=tempText[0];
				}
			}
			sheetComboCode=MnrDelLastDelim(sheetComboCode);
	     	sheetComboText=MnrDelLastDelim(sheetComboText);
			sheetObjects[0].InitDataCombo (0, "sheet1_mnr_hngr_trf_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
		}
		combo_vndr_seq_Initialize();
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		sheetObjects[0].SetEditable(1);
		sheetObjects[1].SetEditable(1);
		MnrFormSetReadOnly(formObj,false,"ord_hdr_rmk");
		sheetObjects[0].SetColHidden("sheet1_bkg_no",1);
		sheetObjects[0].SetColHidden("sheet1_trd_cd",1);
		sheetObjects[0].SetColHidden("sheet1_rpr_rslt_dt",1);
		OrgCostType="";
		costCdSubstr="";
		MnrWaitControl(false);
		ComBtnDisable("btn_W/O_Send");
	}
	/**
	 * Retrieving
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSEARCH(sheetObj, formObj, sAction){
		nowLoad=1;
		formObj.f_gubuns.value="";
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(strMnrOrdSeq.length > 3)
		{
			strMnrOrdSeq=strMnrOrdSeq.substring(3);
			if(!ComIsNumber(strMnrOrdSeq))
			{
				ComShowCodeMessage("MNR00003");
				ComSetObjValue(formObj.mnr_ord_seq, "");
				ComSetFocus(formObj.mnr_ord_seq);
				return false;
			}
		}else{
			ComShowCodeMessage("MNR00003");
			ComSetObjValue(formObj.mnr_ord_seq, "");
			ComSetFocus(formObj.mnr_ord_seq);
			return false;
		}
		MnrWaitControl(true);
		formObj.f_cmd.value=SEARCH;
		var sParam="";
		var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");
		sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
		var sXml=sheetObj.GetSearchData("EES_MNR_0058GS.do", sParam);
		searchFlg = "Y";
		arrDataSearchDbXml=sXml.split("|$$|");
		for ( var i=0; i < arrDataSearchDbXml.length; i++) {
			sheetObjects[i].SetWaitImageVisible(0);
			sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
		}
//		MnrFormSetReadOnly(formObj,true,"mnr_ord_seq");
	}
	/**
	 * Saving
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBSAVE(sheetObj, formObj, sAction) {
		if(nowLoad != 0) return;
		if(combo_vndr_seq.GetSelectIndex()== "-1"){
			ComShowCodeMessage("MNR00036","Agreement No");
			ComSetFocus(combo_vndr_seq);
			return false;
		}
		var Row=sheetObj.ColValueDup("sheet1_eq_no");
		if(Row > 0 && costCdSubstr == "MRDRH"){
			ComShowCodeMessage("MNR00006", "EQ No");
			sheetObj.SelectCell(Row, "sheet1_eq_no", true);
			return false;
		}
		if(combo_cost_cd.GetSelectIndex()== "-1"){
			ComShowCodeMessage("MNR00205");
			ComSetFocus(combo_cost_cd);
			return false;
		}
		var rCnt=sheetObj.RowCount();
		if(rCnt <= 0)
		{
			ComShowCodeMessage("MNR00072");
			return false;
		}
		for(var i=sheetObj.HeaderRows();i < sheetObj.LastRow();i++)
		{
			var strCostDtlCD=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd")," ");
			if(strCostDtlCD == "M1" || strCostDtlCD == "MD")
			{
				if(sheetObj.GetCellValue(i, "sheet1_mnr_hngr_dtl_offr_desc") == ""){
					ComShowCodeMessage("MNR00353");
					sheetObj.SelectCell(i, "sheet1_mnr_hngr_dtl_offr_desc",true);
					return false;
				}
			}
			if(combo_cost_cd.GetSelectCode()== "MRDRHD")
			{
				var rprQty=parseInt(sheetObj.GetCellValue(i,"sheet1_rpr_qty"));
				var actInvtQty=parseInt(sheetObj.GetCellValue(i,"sheet1_act_invt_qty"));
				var mnrHngrDmgQty=parseInt(sheetObj.GetCellValue(i,"sheet1_mnr_hngr_dmg_qty"));
				var mnrLostHngrQty=parseInt(sheetObj.GetCellValue(i,"sheet1_mnr_lost_hngr_qty"));
				var mnrDispHngrQty=parseInt(sheetObj.GetCellValue(i,"sheet1_mnr_disp_hngr_qty"));
			    if(rprQty != (actInvtQty + mnrHngrDmgQty + mnrLostHngrQty + mnrDispHngrQty)){
					ComShowCodeMessage("MNR00356");
					sheetObj.SelectCell(i, "sheet1_act_invt_qty",true);
					return false;
				}
			}
			if(strCostDtlCD == "")
			{
				ComShowCodeMessage("MNR00172","Extra Expense Type");
				sheetObj.SelectCell(i, "sheet1_cost_dtl_cd",true);
				return false;
			}
			if(costCdSubstr == "MRDRH")
			{
				var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_eq_no")," ");
				if(strEqNo=="")
				{
					ComShowCodeMessage("MNR00084");
					sheetObj.SelectCell(i, "sheet1_eq_no",true);
					return false;
				}
				var CostDtlCd=sheetObj.GetCellValue(i, "sheet1_cost_dtl_cd");
				if(CostDtlCd=="RA" || CostDtlCd=="BA")
				{
					var strMnrHngrBarTpCd=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_mnr_hngr_bar_tp_cd")," ");
					if(strMnrHngrBarTpCd=="")
					{
						ComShowCodeMessage("MNR00036","Hanger Bar Type");
						sheetObj.SelectCell(i, "sheet1_mnr_hngr_bar_tp_cd",true);
						return false;
					}
				}
			}
			var strMnrExpnDtlNm=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_mnr_expn_dtl_nm")," ");
			var strEqNo=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_eq_no")," ");
			if(strMnrExpnDtlNm == "" && strEqNo == "" && combo_cost_cd.GetSelectCode()!="MRZSTP")
			{
				ComShowCodeMessage("MNR00172","Description");
				sheetObj.SelectCell(i, "sheet1_mnr_expn_dtl_nm",true);
				return false;
			}
			var strCostAmt=sheetObj.GetCellValue(i, "sheet1_cost_amt");
			if(strCostAmt == 0)
			{
				ComShowCodeMessage("MNR00175","Amount");
				sheetObj.SelectCell(i, "sheet1_spr_prt_uc_amt",true);
				return false;
			}
			
			if(combo_cost_cd.GetSelectCode() == "MRDRHA" || combo_cost_cd.GetSelectCode() == "MRDRHD"){
				var rprRsltDt = ComTrimAll(sheetObj.GetCellValue(i, "sheet1_rpr_rslt_dt")," ");
				if(rprRsltDt=="")
				{
					ComShowCodeMessage("MNR00172","Work Date");
					sheetObj.SelectCell(i, "sheet1_rpr_rslt_dt",true);
					return false;
				}
			}
		}
		
		formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
		formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
		formObj.cost_cd.value=combo_cost_cd.GetSelectCode();
		formObj.f_cmd.value=MULTI;
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var sParam=ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
			return false;
		sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
		
		MnrWaitControl(true);
		if(sheetObj.Rowcount == "1" && sheetObj.GetCellValue(sheetObj.Rowcount, "sheet1_ibflag")=="D"){
			doIBREMOVE(sheetObj, formObj, sAction);
			return false;
		}
		var sXml=sheetObj.GetSaveData("EES_MNR_0058GS.do", sParam);
		sXml_1 = sXml;
		sheetObjects[0].LoadSaveData(sXml);
		
		return true;
	}
	/**
	 * Deleting
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doIBREMOVE(sheetObj, formObj, sAction) {
		formObj.f_cmd.value=REMOVE;
		var rCnt=sheetObjects[2].RowCount();
		if(rCnt<=0)
		{
			ComShowCodeMessage("MNR00081");
			return false;
		}
		var strMnrOrdSeq=formObj.mnr_ord_seq.value;
		if(strMnrOrdSeq.length > 3)
		{
			strMnrOrdSeq=strMnrOrdSeq.substring(3);
			if(!ComIsNumber(strMnrOrdSeq))
			{
				ComShowCodeMessage("MNR00081");
				return false;
			}
		}else{
			ComShowCodeMessage("MNR00081");
			return false;
		}
		if(!ComShowCodeConfirm("MNR00026"))
		{
			return false;
		}
		
		for(var i=sheetObj.HeaderRows();i<sheetObj.LastRow();i++)
		{
			var intPayInvSeq=sheetObj.GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				return false;
			}
		}
		
		MnrWaitControl(true);
		formObj.f_cmd.value=REMOVE;
		formObj.vndr_seq.value=combo_vndr_seq.GetSelectCode();
		formObj.eq_knd_cd.value=combo_eq_knd_cd.GetSelectCode();
		formObj.cost_cd.value=combo_cost_cd.GetSelectCode();
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var sParam=ComGetSaveString(sheetObjects, true, true);
		if (sParam == "")
		{
			MnrWaitControl(false);
			return false;
		}
		sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
		var sXml=sheetObj.GetSaveData("EES_MNR_0058GS.do", sParam);
		sXml_2 = sXml;
		sheetObjects[0].LoadSaveData(sXml);
		
		return true;
	}
	/**
	 * Adding row of sheet
	 */
	function doRowAdd(sheetObj, formObj){
		if(combo_vndr_seq.GetSelectIndex()== "-1"){
			ComShowCodeMessage("MNR00368","Agreement No");
			ComSetFocus(combo_vndr_seq);
			return false;
		}
		if(combo_cost_cd.GetSelectIndex()== "-1"){
			ComShowCodeMessage("MNR00205");
		} else {
			var row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "sheet1_cost_dtl_cd","",0);
			sheetObj.SetCellValue(row, "sheet1_mnr_hngr_bar_tp_cd","",0);
			if(costCdSubstr == "MRDRH" ){
				sheetObj.SetCellValue(row, "sheet1_rpr_qty",0,0);
				sheetObj.SetCellValue(row, "sheet1_recent_rpr_qty",0,0);
			}else{
				sheetObj.SetCellValue(row, "sheet1_rpr_qty",1,0);
			}
			sheetObj.SetCellValue(row, "sheet1_cost_cd",combo_cost_cd.GetSelectCode(),0);
			sheetObj.SetCellValue(row, "sheet1_eq_no_check_yn","N",0);
			sheetObj.SelectCell(row, "sheet1_cost_dtl_cd",true);
			sheetObj.SetSumText(0, "Seq", "TOTAL");
		}
	}
	/**
	 * Adding row for file upload<br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {nothing}
	 **/
	function file_Insert(sheetObj){
		uploadFileSeq=sheetObj.GetCellValue(2,"file_seq");
		if(uploadFileSeq == undefined || uploadFileSeq == -1){
			uploadFileSeq="";
		}
		var row=sheetObj.DataInsert(-1);
		
		ComBtnDisable("btn_W/O_Send");
		ComBtnEnable("btn_W/O_Creation");
	}
	/**
	 * Removing file<br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @return {nothing}
	 **/
	function file_Remove(sheetObj) {
		if(sheetObj.FindCheckedRow("del_chk") != ""){
			if(sheetObj.RowCount()==1 )
			{
				document.form.file_seq.value="0";
				MnrWaitControl(false);
				ComBtnDisable("btn_W/O_Send");
			}
			RemoveFileUpload(sheetObj);
		} else {
			ComShowCodeMessage("MNR00150");
		}
	}
	/**
	 * Calculating
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function doCalculate(sheetObj,Row, Col, Value){
		var formObj=document.form;
		var bzcAmt=MnrNullToZero(sheetObjects[0].GetCellValue(Row, "sheet1_spr_prt_uc_amt"));
		var qty=MnrNullToZero(sheetObjects[0].GetCellValue(Row, "sheet1_rpr_qty"));
		sheetObjects[0].SetCellValue(Row, "sheet1_cost_amt",(parseFloat(qty) * parseFloat(bzcAmt)).toFixed(2));//Hanger Bar Qty
	}
	/**
	 * Convert string of retrieved xml
	 * @param xmlStr
	 * @param codeCol
	 * @param textCol
	 * @return
	 */
	function getDataString(xmlStr, codeCol, textCol) {
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
		try {
			var xmlDoc = ComGetXmlDoc(xmlStr);
			if (xmlDoc == null) return;
			var xmlRoot = xmlDoc.documentElement;
			
			var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}
			var col=dataNode.getAttribute("COLORDER");
			var colArr=col.split("|");
			var sep=dataNode.getAttribute("COLSEPARATOR");
			var total=dataNode.getAttribute("TOTAL");
			var dataChildNodes=dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
			var colListIdx=Array();
			for ( var i=0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0]=i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1]=i;
				}
			}
			var retStr="";
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				retStr=MnrNullToZero(arrData[colListIdx[0]]) + '|'  + MnrNullToZero(arrData[colListIdx[1]]);
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
		return retStr;
	}
	/**
	 * Checking status changed
	 */
	function checkSheetStatus(sheetObj){
		var flag=true;
		var sRow=sheetObj.FindStatusRow("I|U|D");
		if(sRow != "")
		{
			flag=false;
		}
		return flag
	}
	/**
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function checkWorkOrderNo(sheetObj, formObj, sAction){
		var flag=true;
		if( formObj.mnr_ord_seq.value =="" || formObj.mnr_ord_seq.value==null)
		{
			ComShowCodeMessage("MNR00172",'W/O No');
			ComSetFocus(formObj.mnr_ord_seq);
			flag=false;
		}
		return flag
	}
	/**
	 * Processing return data of pop-up screen
	 */
	function getMnr_ofcInfoMulti(retStr,sheet_id,row){
		var formObj=document.form;
		var targetSheet=sheetObjects[sheet_id];
		targetSheet.SetCellValue(row, "sheet1_mnr_hngr_dtl_offr_desc",retStr);
	}
	/**
	 * Processing return data of pop-up screen (EES_MNR_0211)
	 * @param array
	 * @return
	 */
	function setParam(array) {
		if(array == null)return;
		var formObj=document.form;
		var str=array + "";
		var arr=str.split(',');
		formObj.mnr_ord_seq.value=arr[4];
		if(formObj.mnr_ord_seq.value.length > 3){
			doIBSEARCH(sheetObjects[2], formObj, IBSEARCH);
		}
	}
	/**
	 * Setting column display by Cost Type combo
	 * @param costType
	 * @return
	 */
	function setSheetColumnDisplay(costType) {
		//Container - Hanger
		if(costType=="MRDROT"){
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_dtl_offr_desc",0);//hanger pharase offer info
		} else {
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_dtl_offr_desc",1);//hanger pharase offer info
		}
		if (costType=="MRDRHA" || costType=="MRDRHD") {
			sheetObjects[0].SetColHidden("sheet1_eq_no",0);//EQ No
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_bar_tp_cd",0);//Hanger Bar Type
			sheetObjects[0].SetColHidden("sheet1_rpr_qty",0);//Hanger Bar Qty
			sheetObjects[0].SetColHidden("sheet1_mnr_expn_dtl_nm",1);//Description
			sheetObjects[0].SetColHidden("sheet1_spr_prt_uc_amt",1);//Unit Price
			sheetObjects[0].SetColProperty(0, "sheet1_rpr_qty", {EditLen:100});
//			sheetObjects[0].SetColProperty(1, "sheet1_rpr_qty", {EditLen:100});
//			var HeadTitle1="|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Unit Price| Installation\nBar Qty|Collection Qty|Collection Qty|Missing Qty|Missing Qty|Amount|Hanger Offer INFO|Remark(s)";
//		    var HeadTitle2="|Sel|Seq.|Extra Expense Type|EQ No.|Description |Hanger Bar Type|Tariff Type|Other Tariff Desc|Unit Price| Installation\nBar Qty|Sound         |Repairable    |Missing    |Disposal   |Amount|Hanger Offer INFO|Remark(s)";
			sheetObjects[0].SetCellValue(0,"sheet1_rpr_qty","Installation\nBar Qty");
			sheetObjects[0].SetCellValue(1,"sheet1_rpr_qty","Installation\nBar Qty");
			sheetObjects[0].SetColProperty(0, "sheet1_rpr_qty", {EditLen:6});
			sheetObjects[0].SetCellValue(0,"sheet1_cost_amt","Amount");
			sheetObjects[0].SetCellValue(1,"sheet1_cost_amt","Amount");
//		    changeHeaderRow(sheetObjects[0] , 0 , HeadTitle1);
//			changeHeaderRow(sheetObjects[0] , 1 , HeadTitle2);
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_trf_cd",0);//Tariff Type
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_trf_otr_desc",0);//Other Tariff Desc
			if(costType=="MRDRHD"){
				sheetObjects[0].SetColHidden("sheet1_act_invt_qty",0);//Sound
				sheetObjects[0].SetColHidden("sheet1_mnr_hngr_dmg_qty",0);//Repairable
				sheetObjects[0].SetColHidden("sheet1_mnr_lost_hngr_qty",0);//missing
				sheetObjects[0].SetColHidden("sheet1_mnr_disp_hngr_qty",0);//disposal
			} else {
				sheetObjects[0].SetColHidden("sheet1_act_invt_qty",1);//Sound
				sheetObjects[0].SetColHidden("sheet1_mnr_hngr_dmg_qty",1);//Repairable
				sheetObjects[0].SetColHidden("sheet1_mnr_lost_hngr_qty",1);//missing
				sheetObjects[0].SetColHidden("sheet1_mnr_disp_hngr_qty",1);//disposal
			}
			sheetObjects[0].SetColWidth("sheet1_rpr_qty",100);
		} else {
			//Chassis - Pre-Maintenance
			if(costType=="MRZSPR") {
				sheetObjects[0].SetColHidden("sheet1_eq_no",0);//EQ No
			} else {
				sheetObjects[0].SetColHidden("sheet1_eq_no",1);//EQ No
			}
			if(costType=="MRDROT" || costType=="MRZSOT" || costType=="MRGSOT" || costType=="MRZSTP" || costType=="MRZSTR" || costType=="MRDRSL") {
				sheetObjects[0].SetColHidden("sheet1_rpr_qty",0);
			} else {
				sheetObjects[0].SetColHidden("sheet1_rpr_qty",1);
			}
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_bar_tp_cd",1);//Hanger Bar Type
			sheetObjects[0].SetColHidden("sheet1_mnr_expn_dtl_nm",0);//Description
			sheetObjects[0].SetColHidden("sheet1_spr_prt_uc_amt",0);//Unit Price
			sheetObjects[0].SetCellValue(0,"sheet1_rpr_qty","Q'ty");
			sheetObjects[0].SetCellValue(1,"sheet1_rpr_qty","Q'ty");
			sheetObjects[0].SetColWidth("sheet1_rpr_qty",60);
			sheetObjects[0].SetColHidden("sheet1_act_invt_qty",1);//Sound
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_dmg_qty",1);//Repairable
			sheetObjects[0].SetColHidden("sheet1_mnr_lost_hngr_qty",1);//missing
			sheetObjects[0].SetColHidden("sheet1_mnr_disp_hngr_qty",1);//disposal
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_trf_cd",1);//Tariff Type
			sheetObjects[0].SetColHidden("sheet1_mnr_hngr_trf_otr_desc",1);//Other Tariff Desc
		}
		//Chassis - The Pachase
		if(costType=="MRZSTP"){
			sheetObjects[0].SetCellValue(0,"sheet1_mnr_expn_dtl_nm","Brand");
			sheetObjects[0].SetCellValue(1,"sheet1_mnr_expn_dtl_nm","Brand");
			sheetObjects[0].SetCellValue(0,"sheet1_cost_amt","Amount");
			sheetObjects[0].SetCellValue(1,"sheet1_cost_amt","Amount");
		}else{
			sheetObjects[0].SetCellValue(0,"sheet1_mnr_expn_dtl_nm","Description");
			sheetObjects[0].SetCellValue(1,"sheet1_mnr_expn_dtl_nm","Description");
			sheetObjects[0].SetCellValue(0,"sheet1_cost_amt","Amount");
			sheetObjects[0].SetCellValue(1,"sheet1_cost_amt","Amount");
		}
	}
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
		//Axon event handling 1. Catching event
		var formObject=document.form;
		//axon_event.addListenerForm  ('blur',     	'obj_deactivate', 	formObject);
		//axon_event.addListenerFormat('focus',    	'obj_activate',		formObject);
		axon_event.addListenerFormat('keypress',	'obj_keypress', 	formObject);
		axon_event.addListenerFormat('focusout',	 	'obj_change',		formObject);
		axon_event.addListener('change',	 		'obj_change1',		'ord_hdr_rmk');
	}
	/**
     * Onblur event handling <br>
     **/
	function obj_deactivate(){
//		ComChkObjValid(event.srcElement);
	}
	/**
     * Activate event handling <br>
     **/
	function obj_activate(){
		ComClearSeparator(event.srcElement);
	}
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
		obj=event.srcElement;
		keys=event.keyCode;
		if(obj.dataformat == null )
		{
			if(obj.name!="ord_hdr_rmk")
			{
				return;
			}
		}
		window.defaultStatus=obj.dataformat;
		var formObj=document.form;
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
			case "mnr_ord_seq":
				var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
				var strMnrOrdSeqTail="";
				if(strMnrOrdSeqAll=="NEW")
				{
					formObj.mnr_ord_seq.value="";
				}
				if(strMnrOrdSeqAll.length > 3)
				{
					if(keys == 13)
					{
						ComSetFocus(combo_vndr_seq);
						return;
					}
				}
				break;
			}
		}
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
			ComKeyOnlyAlphabet('uppernum');
			break;
		case "engnum":
			ComKeyOnlyAlphabet("num","32|64");
			break;
		}
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change(){
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
			case "mnr_ord_seq":
				if(formObj.mnr_ord_seq.value != oldWoNo){
					var strMnrOrdSeqAll=formObj.mnr_ord_seq.value;
					var strMnrOrdSeqTail=strMnrOrdSeqAll.substring(3);
					if(!ComIsNumber(strMnrOrdSeqTail))
					{
						formObj.mnr_ord_seq.value=strMnrOrdSeqAll.substring(0,3);
					}
					doActionIBSheet(sheetObj, formObj , IBSEARCH);
				}
				break;
			}
		} else {
			switch(obj.id) {
			case "ord_hdr_rmk":
				for(var i=sheetObj.HeaderRows();i<sheetObj.LastRow();i++)
				{
					var intPayInvSeq=sheetObj.GetCellValue(i,"sheet1_pay_inv_seq");
					if(intPayInvSeq =="") intPayInvSeq=0;
					if(parseInt(intPayInvSeq) > 0 )
					{
						ComShowCodeMessage("MNR00229");
						document.form.ord_hdr_rmk.value = ord_hdr_rmk_org;
						return false;
					}
				}
                if(ComGetLenByByte(obj) > 4000){
                	ComShowCodeMessage("MNR00369", "Expense For");
                	ComSetFocus(document.form.ord_hdr_rmk);
                	ComBtnDisable("btn_W/O_Send");
    				ComBtnDisable("btn_W/O_Creation");
                }else{
                	ComBtnDisable("btn_W/O_Send");
    				ComBtnEnable("btn_W/O_Creation");
                }
				break;
			}
		}
	}
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change1(){
		var obj=event.srcElement;
		var sheetObj=sheetObjects[0];
		for(var i=sheetObj.HeaderRows();i<sheetObj.LastRow();i++)
		{
			var intPayInvSeq=sheetObj.GetCellValue(i,"sheet1_pay_inv_seq");
			if(intPayInvSeq =="") intPayInvSeq=0;
			if(parseInt(intPayInvSeq) > 0 )
			{
				ComShowCodeMessage("MNR00229");
				document.form.ord_hdr_rmk.value = ord_hdr_rmk_org;
				return false;
			}
		}
		
		if(ComGetLenByByte(obj) > 4000){
        	ComShowCodeMessage("MNR00369", "Expense For");
        	ComSetFocus(document.form.ord_hdr_rmk);
        	ComBtnDisable("btn_W/O_Send");
			ComBtnDisable("btn_W/O_Creation");
        }else{
        	ComBtnDisable("btn_W/O_Send");
			ComBtnEnable("btn_W/O_Creation");
        }
	}
	
/* End of developer's task */
