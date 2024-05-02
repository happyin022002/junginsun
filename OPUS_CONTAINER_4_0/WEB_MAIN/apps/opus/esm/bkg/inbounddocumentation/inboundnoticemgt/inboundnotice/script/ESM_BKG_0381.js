/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0381.js
*@FileTitle  : Arrival Notice Send
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business as a calendar-related functions have been defined.
 * @author
 */
/**
 * @extends
 * @class esm_bkg_0381 : esm_bkg_0381 business script.
 */
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var t1beforetab=1;
var t3beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//local global variable
var IBSENDFAX = "IBSENDFAX";
var IBSENDEMAIL = "IBSENDEMAIL";
var IBPREVIEW = "IBPREVIEW";
var arrMrdId = "";
var arrComParam = "";
var arrArrPrvFomCd = "";
var mailMethod = "";
var mailPopClose = "";

//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){

	/***** using extra sheet valuable if there are more 2 sheets *****/
	var sheetObj = sheetObjects[0];
	/*******************************************************/
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch(srcName) {
		case "eta_dt_start":
			var cal=new ComCalendarFromTo();
			cal.select(formObj.vps_eta_dt_start, formObj.vps_eta_dt_end, 'yyyy-MM-dd');
			break;

		case "eta_dt_end":
			var cal=new ComCalendarFromTo();
			cal.select(formObj.vps_eta_dt_start, formObj.vps_eta_dt_end, 'yyyy-MM-dd');
			break;

		case "btn_Retrieve":
			sheetObj.SetHeaderCheck(0,"t1sheet1_chk_fax",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_chk_email",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_chg_dp_flg",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_show_pu_flg",0);

			sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg1",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg2",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg3",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg4",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg5",0);

			sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg1",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg2",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg3",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg4",0);
			sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg5",0);

			ComSetCookie("esm_bkg_0381_pod_cd", form.pod_cd.value);
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
			break;

		case "btn_DownExcel":
			if(sheetObj.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				sheetObj.Down2Excel({DownCols: makeHiddenSkipColBKG(sheetObj), SheetDesign:1, Merge:1, CheckBoxOnValue:"Y",CheckBoxOffValue:"N"});
			}
			break;

		case "btn_fax":
			if(formObj.is_validated.value == "N"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			for(var i=0;i<=sheetObj.RowCount();i++){
				if(sheetObj.GetCellValue(i,"t1sheet1_chk_fax") != "1"){
					continue;
				}
				if(sheetObj.GetCellValue(i,"t1sheet1_is_validated") != "Y"){
					ComShowCodeMessage("BKG04003");
					return;
				}
				if(sheetObj.GetCellValue(i,"t1sheet1_rd_prt_flg") == "N"){
					//alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
					ComShowCodeMessage("BKG43040");
					return;
				}
			}
			//get RD info
			var mrdId=sheetObj.GetCellValue(clickRow,"t1sheet1_mrd_id");
			var loclLangFlg=sheetObj.GetCellValue(clickRow,"t1sheet1_locl_lang_flg");
			var show_pu=sheetObj.GetCellValue(clickRow, "t1sheet1_show_pu_flg");
			if(mrdId == ""){
				ComShowCodeMessage("BKG40050");
				return;
			}
			doActionIBSheet(sheetObj, formObj, IBSENDFAX);
			break;

		case "btn_email":
			//alert('a');
			if(formObj.is_validated.value == "N"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			//alert(sheetObj.RowCount);
			for(var i=1;i<=sheetObj.RowCount();i++){
				if(sheetObj.GetCellValue(i,"t1sheet1_chk_email") != "1"){
					continue;
				}
				if(sheetObj.GetCellValue(i,"t1sheet1_is_validated") != "Y"){
					//alert("Code Validation 된 데이터가 없습니다.");
					ComShowCodeMessage("BKG04003");
					return;
				}
				if(sheetObj.GetCellValue(i,"t1sheet1_rd_prt_flg") == "N"){
					//alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
					ComShowCodeMessage("BKG43040");
					return;
				}
			}
			//get RD info
			var mrdId=sheetObj.GetCellValue(clickRow,"t1sheet1_mrd_id");
			var loclLangFlg=sheetObj.GetCellValue(clickRow,"t1sheet1_locl_lang_flg");
			var show_pu=sheetObj.GetCellValue(clickRow, "t1sheet1_show_pu_flg");
			//alert(mrdId);
			//return;
			if(mrdId == ""){
				//alert("Arrival Notice Setting 정보가 없습니다.");
				ComShowCodeMessage("BKG40050");
				return;
			}
			if (sheetObj.CheckedRows("t1sheet1_chk_email") < 1){
				//=> BKG40019 : Please select at least one row by mouse click in order to E-mail
				ComShowCodeMessage("BKG40019");
				return;
			}
			if (!ComShowCodeConfirm("BKG40038","Arrival Notice ?")) return;

			ComOpenPopup("ESM_BKG_0381_01.do", 320, 190, "", "1,0", true);
			mailPopTimer = setInterval(getSendPopFlag, 100);   // 0.1초마다 getSendPopFlag함수 실행

			break;

		case "btn_preview":
			if(sheetObj.GetCellValue(clickRow,"t1sheet1_is_validated") != "Y"){
				//alert("Code Validation 된 데이터가 없습니다.");
				ComShowCodeMessage("BKG04003");
				return;
			}
			if(sheetObj.GetCellValue(clickRow,"t1sheet1_rd_prt_flg") == "N"){
				//alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
				ComShowCodeMessage("BKG43040");
				return;
			}
//            //get RD info
			var mrdId=sheetObj.GetCellValue(clickRow,"t1sheet1_mrd_id");
			var loclLangFlg=sheetObj.GetCellValue(clickRow,"t1sheet1_locl_lang_flg");
			var comParam=sheetObj.GetCellValue(clickRow,"t1sheet1_com_param");

			var show_pu=sheetObj.GetCellValue(clickRow, "t1sheet1_show_pu_flg");

			if(mrdId == ""){
				  //alert("Arrival Notice Setting 정보가 없습니다.");
				ComShowCodeMessage("BKG40050");
				return;
			}
			if(clickBkgNo == ""){
				//alert('B');
				ComShowCodeMessage("BKG00149");
				return;
			}
			formObj.com_mrdPath.value="apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/" + mrdId + ".mrd";
			var strArg="/rv ";
				strArg += " form_bkgNo[('" + clickBkgNo + "')]";
				strArg += " form_usrId['" + strUsr_id + "']";
				strArg += " form_loclFlg['" + loclLangFlg + "']";
				strArg += " form_chgDpFlg['" + sheetObj.GetCellValue(clickRow,"t1sheet1_chg_dp_flg") + "']";
			if (formObj.ts_flg.checked){
				strArg += " form_tsFlg['Y'] ";
			} else {
				strArg += " form_tsFlg['N'] ";
			}
			strArg += " form_remarkCtnt['']";
			strArg += " form_ofcCd['" + strOfc_cd + "']";
			strArg += " form_showPuFlg['" + show_pu + "']"
			strArg += " " + comParam;

			formObj.com_mrdArguments.value=strArg;
			formObj.com_mrdTitle.value="Arrival Notice Send";
			formObj.com_mrdSaveDialogFileName.value="AN_" + sheetObj.GetCellValue(clickRow,"t1sheet1_bl_no");
			formObj.com_mrdSaveDialogFileExt.value="pdf";
			formObj.com_mrdDisableToolbar.value="";
			formObj.com_mrdBodyTitle.value="Arrival Notice Send";
			ComOpenRDPopup();
			break;

		case "btn_Print":
			if (sheetObj.GetCellValue(clickRow,"t1sheet1_is_validated") != "Y") {
				//alert("Code Validation 된 데이터가 없습니다.");
				ComShowCodeMessage("BKG04003");
				return;
			}
			
			var mrdId=sheetObj.GetCellValue(clickRow,"t1sheet1_mrd_id");
			if(mrdId == ""){
				  //alert("Arrival Notice Setting 정보가 없습니다.");
				ComShowCodeMessage("BKG40050");
				return;
			}
			
			rdOpen();
			break;

		case "btn_save":
			// alert(srcName);
			break;

		case "btn_setup":
			var goUrl="";
			var param="";
			goUrl="ESM_BKG_0672_POP.do?";
			param += "1=1";
			document.form.f_cmd.value="";
			param += "&" + FormQueryString(formObj);
			param += "&autoSearchFlg=Y";
			param += "&pgmNo=ESM_BKG_0672-01";
			ComOpenWindowCenter(goUrl + param,"ESM_BKG_0672",1024,650,false);
			break;

		case "btn_history":
			var goUrl="";
			var param="";
//            goUrl="ESM_BKG_0001.do?";
			goUrl="ESM_BKG_0001_POP.do?";
			param += "1=1";
			//param += "&" + FormQueryString(formObj);
			if(clickRow == 0){
				param += "&bl_no=";
			}else{
				param += "&bl_no="+sheetObjects[0].GetCellText(clickRow, "t1sheet1_bl_no");
			}
			param += "&sch_tp=B";
			param += "&autoSearchFlg=Y";
			param += "&ntc_knd_cd=AN";
			param += "&pgmNo=ESM_BKG_0001";
			ComOpenWindowCenter(goUrl + param,"ESM_BKG_0001",1024,670,false);
			break;

		case "btn_goto_invoice":
			var goUrl="";
			var param="";
			goUrl="FNS_INV_0034_01_POP.do?";
			param += "1=1";
			param += "&" + FormQueryString(formObj);
			param += "&autoSearchFlg=N";
			param += "&pgmNo=FNS_INV_0034-01";
			ComOpenWindowCenter(goUrl + param,"FNS_INV_0034_01",1000,590,false);
			break;

		case "btn_group_by_code":
			if(formObj.is_validated == "N"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			if(sheetObj.GetCellValue(clickRow,"t1sheet1_is_validated") != "Y"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			var goUrl="";
			var param="";
			if(clickCustCntCd == "" ){
				ComShowCodeMessage("BKG40057");
				return;
			}
			goUrl="ESM_BKG_0946_POP.do?";
			param += "1=1";
			param += "&cust_cnt_cd="+clickCustCntCd;
			param += "&cust_seq="+clickCustSeq;
			param += "&gubun=C";
			param += "&rvis_flg="+sheetObj.GetCellValue(clickRow,"t1sheet1_rvis_flg");
			if(formObj.ts_flg.checked){
				param += "&ts_flg=Y";
			}else{
				param += "&ts_flg=N";
			}
			param += "&bkg_no="+clickBkgNo;
			var tmpFaxNo="";
				tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg1")
				+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no1") + ",";
				tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg2")
				+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no2") + ",";
				tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg3")
				+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no3") + ",";
				tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg4")
				+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no4") + ",";
				tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg5")
				+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no5") + ",";
			var tmpEmail="";
				tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg1")
				+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml1") + ",";
				tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg2")
				+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml2") + ",";
				tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg3")
				+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml3") + ",";
				tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg4")
				+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml4") + ",";
				tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg5")
				+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml5") + ",";
			param += "&fax_no="+tmpFaxNo;
			param += "&email="+tmpEmail;
			ComOpenWindowCenter(goUrl + param,"ESM_BKG_0946_POP",1024,570,true);
			break;

		case "btn_group_sc":
			if(formObj.is_validated == "N"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			if(sheetObj.GetCellValue(clickRow,"t1sheet1_is_validated") != "Y"){
				ComShowCodeMessage("BKG04003");
				return;
			}
			var goUrl="";
			var param="";
			if(clickScNo == "" ){
				ComShowCodeMessage("BKG40058");
				return;
			}
			goUrl="ESM_BKG_0946_POP.do?";
			param += "1=1";
			param += "&sc_no="+clickScNo;
			param += "&gubun=S";
			if(formObj.ts_flg.checked){
				param += "&ts_flg=Y";
			}else{
				param += "&ts_flg=N";
			}
			param += "&pgmNo=ESM_BKG_0946";
			//param += "&bkg_no="+clickBkgNo;
			var tmpFaxNo="";
			tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg1")
			+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no1") + ",";
			tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg2")
			+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no2") + ",";
			tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg3")
			+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no3") + ",";
			tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg4")
			+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no4") + ",";
			tmpFaxNo += sheetObj.GetCellValue(clickRow,"t1sheet1_fax_evnt_flg5")
			+ "|" +sheetObj.GetCellValue(clickRow,"t1sheet1_fax_no5") + ",";
			var tmpEmail="";
			tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg1")
			+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml1") + ",";
			tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg2")
			+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml2") + ",";
			tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg3")
			+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml3") + ",";
			tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg4")
			+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml4") + ",";
			tmpEmail += sheetObj.GetCellValue(clickRow,"t1sheet1_eml_evnt_flg5")
			+ "|" + sheetObj.GetCellValue(clickRow,"t1sheet1_ntc_eml5") + ",";
			param += "&fax_no="+tmpFaxNo;
			param += "&email="+tmpEmail;
			ComOpenWindowCenter(goUrl + param,"ESM_BKG_0946_POP",1024,570,true);
			break;

		case "btn_multi_contact":
			fncMultiContact();
			break;

		case "btn_template":
			var goUrl="";
			var param="";
			goUrl="ESM_BKG_0375_POP.do?";
			param += "1=1";
			param += "&pgmNo=ESM_BKG_0375&autoSearchFlg=Y";
			ComOpenWindowCenter(goUrl + param,"ESM_BKG_0375",1024,610,false);
			break;

		case "btn_Close":
			ComClosePopup();
			break;

	} // end switch
}
/**
 * check Send Mail POP-UP Flag
 */
function getSendPopFlag() {
	if (mailPopClose == "Y") {
		clearInterval(mailPopTimer);
		mailPopClose = "";
		if (mailMethod != "") doActionIBSheet(sheetObjects[0], document.form, "IBSENDEMAIL");
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
	var formObj=document.form;
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k+1);
		tabObjects[k].SetSelectedIndex(0);
	}

	beforetab = 0;

	initControl();
	//alert(parAutoSearchFlg);
	if(parAutoSearchFlg != ""){
		formObj.vvd.value=parVvd;
		formObj.vps_eta_dt_start.value=parVpsEtaDtStart;
		formObj.vps_eta_dt_end.value=parVpsEtaDtEnd;
		formObj.pod_cd.value=parPodCd;
		formObj.del_cd.value=parDelCd;
		formObj.pol_cd.value=parPolCd;
		formObj.bl_no.value=parBlNo;
		if(parTsFlg == "Y"){
			formObj.ts_flg.checked=true;
		}
		formObj.cust_cnt_cd.value=parCustCntCd;
		formObj.cust_seq.value=parCustSeq;
		formObj.cust_nm.value=parCustNm;
		formObj.cust_ref_no.value=parCustRefNo;
		formObj.sc_no.value=parSNo;
		for(var x=0;x<formObj.sch_tp.length;x++){
			//alert(formObj.sch_tp[x].value);
			if(parSchTp == formObj.sch_tp[x].value){
				formObj.sch_tp[x].checked=true;
				break;
			}
		}
	}
	if(strCnt_cd == "US"){
		//1.S/C No.
		//2.Grouping by S/C.
		//3.S/C No.
		//4.IT/Local.
		//5.HUB.
		search_sc_title.style.visibility="visible";
		search_sc.style.visibility="visible";
		ComBtnEnable("btn_group_sc");
		sheetObjects[0].SetColHidden("t1sheet1_sc_no",0);
		sheetObjects[0].SetColHidden("t1sheet1_cstms_clr_tp_cd",0);
		sheetObjects[0].SetColHidden("t1sheet1_hub_loc_cd",0);
	}else{
		search_sc_title.style.visibility="hidden";
		search_sc.style.visibility="hidden";
		ComBtnDisable("btn_group_sc");
		sheetObjects[0].SetColHidden("t1sheet1_sc_no",1);
		sheetObjects[0].SetColHidden("t1sheet1_cstms_clr_tp_cd",1);
		sheetObjects[0].SetColHidden("t1sheet1_hub_loc_cd",1);
	}
	if (parAutoSearchFlg == "Y" ) {
		//document.getElementById("btn_Retrieve").fireEvent("onclick");
		$("#btn_Retrieve").click();
		//$("#btn_Retrieve").trigger("click");

		for ( var idx=0; idx < formObj.sch_tp.length; idx ++ ) {
			if (formObj.sch_tp[idx].value == parSchTp ){
				formObj.sch_tp[idx].checked=true;
				break;
			}
		}
	}

	doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
//	initRdConfig(rdObjects[0]);

	initUpload();
}

function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}

/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //t1sheet1 init
			with(sheetObj){
		  var HeadTitle1="|Seq.|Sel.|Sel.|Chg|Show PU#|BL No.|TP|S/C No|Code|Customer Name|A/N Sent";
		  HeadTitle1 += "||CNEE/NTFY| |CNEE/NTFY #2| |BROKER#1| |BROKER#2| |One Time Only";
		  HeadTitle1 += "|Result Date";//FAX
		  HeadTitle1 += "||CNEE/NTFY| |CNEE/NTFY #2| |BROKER#1| |BROKER#2| |One Time Only";
		  HeadTitle1 += "|Y/N|Doc|Remark";
		  HeadTitle1 += "|Result Date";//EMAIL
		  HeadTitle1 += "|Send ID";
		  HeadTitle1 += "|IT \nLocal|HUB|POD|DEL|Type|Term";
		  HeadTitle1 += "|A/N Form|Language|Enclose B/L Copy";
		  var prefix="t1sheet1_";

		  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1, FrozenCol:6 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",                     Edit:0,   EditLen:0  , HeaderCheck:1},
				 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_fax",                 Edit:1,   EditLen:-1 , HeaderCheck:1},
				 {Type:"DummyCheck", Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_email",               Edit:1,   EditLen:-1 },
				 {Type:"CheckBox",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chg_dp_flg",              Edit:1,   EditLen:-1 , HeaderCheck:1},
				 {Type:"CheckBox",  Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"show_pu_flg",             Edit:1,   EditLen:-1 },
				 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",                   Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_cust_tp_cd",          Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc_no",                   Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_cd",                 Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_nm",                 Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"an_sent",                 Edit:0 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg1",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no1",                 Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg2",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no2",                 Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg3",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no3",                 Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg4",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no4",                 Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_evnt_flg5",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_no5",                 Edit:1 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_dt",              Edit:0 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg1",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml1",                Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg2",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml2",                Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg3",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml3",                Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg4",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"ntc_eml4",                Edit:1 },
				 {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_evnt_flg5",           Edit:1,   EditLen:-1 ,HeaderCheck:1},
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ntc_eml5",                Edit:1 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"attach_doc_yn",           Edit:0 },
				 {Type:"Popup",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"attach_doc",              Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:400,  Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",                Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_dt",              Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"snd_usr_id",              Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_clr_tp_cd",         Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hub_loc_cd",              Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",                  Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",                  Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_cgo_tp_cd",           Edit:0 },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"de_term_cd",              Edit:0 },
				 {Type:"Combo",     Hidden:0, Width:80,    Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_prv_fom_cd",          Edit:1 },
				 {Type:"Combo",     Hidden:0, Width:80,    Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_lang_flg",           Edit:1 },
				 {Type:"Combo",     Hidden:0, Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eclz_bl_cpy_flg",         Edit:1 },

				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"usr_nm" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"an_fom_cd" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_ntc_snd_rslt_cd1" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_ntc_snd_rslt_cd2" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_ntc_snd_rslt_cd3" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_ntc_snd_rslt_cd4" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_ntc_snd_rslt_cd5" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_ntc_snd_rslt_cd1" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_ntc_snd_rslt_cd2" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_ntc_snd_rslt_cd3" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_ntc_snd_rslt_cd4" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_ntc_snd_rslt_cd5" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_flg1" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_flg2" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_flg3" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_flg4" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"fax_snd_flg5" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_flg1" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_flg2" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_flg3" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_flg4" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"eml_snd_flg5" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"file_key" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_cnt_cd" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_seq" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"is_validated" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rvis_flg" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ts_flg" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"rd_prt_flg" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"com_param" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mrd_id" },
				 {Type:"Text",      Hidden:1, Width:90,    Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd" }];

		  InitColumns(cols);

		  SetEditable(1);
		  SetWaitImageVisible(0);
		  SetEllipsis(1);
		  SetColProperty(prefix+"arr_prv_fom_cd", {ComboText:"General|B/L Form|Notify Letter", ComboCode:"GE|BL|NL"} );
		  SetColProperty(prefix+"locl_lang_flg", {ComboText:"English|LocalLanguage", ComboCode:"N|Y"} );
		  SetColProperty(prefix+"eclz_bl_cpy_flg", {ComboText:"No|Yes", ComboCode:"N|Y"} );
		  SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		  SetShowButtonImage(2);
		  SetAutoRowHeight(0);
//          SetSheetHeight(335);
		  resizeSheet();
		  }

			break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			formObj.f_cmd.value=SEARCH01;
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				var fArgs=new Array("pagerows","f_cmd","vvd","sch_tp","vps_eta_dt_start","vps_eta_dt_end","pod_cd","ts_flg","del_cd","pol_cd","bl_no","is_validated","cust_cnt_cd","cust_seq","cust_nm","cust_ref_no","sc_no");
				//alert(formToQueryString(formObj,fArgs));
				sheetObj.DoSearch("ESM_BKG_0381GS.do", formToQueryString(formObj, fArgs) + "&"+ ComGetPrefixParam("t1sheet1_"));
			}
			break;

		case IBSAVE:        //save
			if(validateForm(sheetObj, formObj,sAction)){}
				//alert (" Save .. ");
			break;

		case IBINSERT:      // insert
			break;

		case IBSENDFAX: // fax send
			fncSendFaxMulti(sheetObj, formObj);
			break;

		case IBSENDEMAIL: // email send
			if (mailMethod == "BL") {    // 전역변수 check
				
				ComOpenWait(true);//progress Waiting box가 보이지 않아서 set timeout function 두어서 호출
				
				setTimeout("setTimeoutSendEmail()",1000 );


			} else if (mailMethod == "MAIL") {    // 전역변수 check
				ComOpenWait(true);//progress
				formObj.f_cmd.value = COMMAND04;
				var saveString = sheetObj.GetSaveString(false, true, "t1sheet1_chk_email");
				var xmlStr = sheetObj.GetSaveData("ESM_BKG_0381GS.do", FormQueryString(formObj) + "&" + saveString);
				backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
				if (backEndJobKey != null && backEndJobKey != undefined && backEndJobKey != "" &&
					backEndJobKey.toUpperCase() != "NULL" && backEndJobKey.toUpperCase() != "UNDEFINDE") {
					sheetObj.SetWaitTimeOut(20000);
					timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
				}
			}
			mailMethod = "";
			break;

		case SEARCH02: //RD MRD_ID retrieve
			formObj.f_cmd.value=SEARCH02;
			var arrXml=sheetObj.GetSearchData("ESM_BKG_0381GS.do", FormQueryString(formObj),{Sync:1} );
			arrMrdId=ComGetEtcData(arrXml, "MRD_ID").split("|");
			arrComParam=ComGetEtcData(arrXml, "COM_PARAM").split("|");
			arrArrPrvFomCd=ComGetEtcData(arrXml, "ARR_PRV_FOM_CD").split("|");
			break;
	}
}

function setTimeoutSendEmail(){
	var formObj=document.form;
	formObj.f_cmd.value = COMMAND05;
	ComOpenWait(true);//progress
	with (sheetObjects[0]) {
		// 체크된 row번호만 수집하여 Loop
		var chkdRowArray = FindCheckedRow("t1sheet1_chk_email").split("|");
		for (var k in chkdRowArray) {
			var saveString = (FormQueryString(formObj) + "&" + RowSaveStr(chkdRowArray[k]));
			var xmlStr = GetSaveData("ESM_BKG_0381GS.do", saveString, {Sync : 1});
			if (ComBkgErrMessage(sheetObjects[0], xmlStr)) {
				SetCellValue(chkdRowArray[k], "t1sheet1_chk_email", "0");    // 성공시에는 CheckBox 해제
			} else {
				ComOpenWait(false);    // 오류시에는 종료
				return;
			}
		}
	}
	ComShowMessage("E-Mail Successfully sent!");
	ComOpenWait(false);
	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);

}

/**
 * Call - BackEndJob : check jobState : '3'
 */
function getBackEndJobStatus() {
	var xmlStr = sheetObjects[0].GetSearchData("ESM_BKG_0381GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
	var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

	if (jbStsFlg == "3") {
		ComOpenWait(false);
		sheetObjects[0].LoadSaveData(sheetObjects[0].GetSaveData("ESM_BKG_0381GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey), {Sync:1});
		clearInterval(timer);
		backEndJobKey = "";

	} else if (jbStsFlg == "4") {
		clearInterval(timer);
		backEndJobKey = "";
		ComOpenWait(false);
		ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
	}
}
/**
  * IBTab Object regist array
  * adding process for list in case of needing batch processing with other items
  * defining list on the top of source
  */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
  * initializing Tab
  * Setting Tab items.
  */
function initTab(tabObj , tabNo) {
	switch(tabNo) {
		case 1:
			with (tabObj) {
				var cnt=0 ;
				InsertItem( "Fax" , "");
				InsertItem( "E-Mail" , "");
				}
			break;
	}
}
/**
  * Event when clicking Tab
  * activating selected tab items.
  */
function tab1_OnChange(tabObj , nItem)
{
	var sheetObj=sheetObjects[0];
	var prefix="t1sheet1_";
	sheetObj.RenderSheet(0);
	if(nItem == 0){//Fax
		sheetObj.SetColHidden(prefix + "chk_fax",0);
		sheetObj.SetColHidden(prefix + "chk_email",1);
		sheetObj.SetColHidden(prefix + "fax_snd_dt",0);
		sheetObj.SetColHidden(prefix + "eml_snd_dt",1);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg1",0);
		sheetObj.SetColHidden(prefix + "fax_no1",0);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg2",0);
		sheetObj.SetColHidden(prefix + "fax_no2",0);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg3",0);
		sheetObj.SetColHidden(prefix + "fax_no3",0);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg4",0);
		sheetObj.SetColHidden(prefix + "fax_no4",0);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg5",0);
		sheetObj.SetColHidden(prefix + "fax_no5",0);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg1",1);
		sheetObj.SetColHidden(prefix + "ntc_eml1",1);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg2",1);
		sheetObj.SetColHidden(prefix + "ntc_eml2",1);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg3",1);
		sheetObj.SetColHidden(prefix + "ntc_eml3",1);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg4",1);
		sheetObj.SetColHidden(prefix + "ntc_eml4",1);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg5",1);
		sheetObj.SetColHidden(prefix + "ntc_eml5",1);
		sheetObj.SetColHidden(prefix + "attach_doc_yn",1);
		sheetObj.SetColHidden(prefix + "attach_doc_clear",1);
		sheetObj.SetColHidden(prefix + "attach_doc",1);
		ComBtnEnable("btn_fax");
		ComBtnDisable("btn_email");

		beforetab = 0;
	}else if(nItem == 1){//E-Mail
		sheetObj.SetColHidden(prefix + "chk_fax",1);
		sheetObj.SetColHidden(prefix + "chk_email",0);
		sheetObj.SetColHidden(prefix + "fax_snd_dt",1);
		sheetObj.SetColHidden(prefix + "eml_snd_dt",0);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg1",1);
		sheetObj.SetColHidden(prefix + "fax_no1",1);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg2",1);
		sheetObj.SetColHidden(prefix + "fax_no2",1);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg3",1);
		sheetObj.SetColHidden(prefix + "fax_no3",1);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg4",1);
		sheetObj.SetColHidden(prefix + "fax_no4",1);
		sheetObj.SetColHidden(prefix + "fax_evnt_flg5",1);
		sheetObj.SetColHidden(prefix + "fax_no5",1);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg1",0);
		sheetObj.SetColHidden(prefix + "ntc_eml1",0);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg2",0);
		sheetObj.SetColHidden(prefix + "ntc_eml2",0);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg3",0);
		sheetObj.SetColHidden(prefix + "ntc_eml3",0);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg4",0);
		sheetObj.SetColHidden(prefix + "ntc_eml4",0);
		sheetObj.SetColHidden(prefix + "eml_evnt_flg5",0);
		sheetObj.SetColHidden(prefix + "ntc_eml5",0);
		sheetObj.SetColHidden(prefix + "attach_doc_yn",0);
		sheetObj.SetColHidden(prefix + "attach_doc_clear",0);
		sheetObj.SetColHidden(prefix + "attach_doc",0);
		ComBtnDisable("btn_fax");
		//ComBtnEnable("btn_email");

		if(document.form.sch_tp[1].checked == true){
			ComBtnDisable("btn_email");
		}else{
			ComBtnEnable("btn_email");
		}

		beforetab = 1;
	}
	sheetObj.RenderSheet(1);
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction){
		case IBSEARCH:
			if(!ComChkValid(formObj)) return false;
			if(formObj.sch_tp[0].checked == true) {
				if(formObj.pod_cd.value == "") {
					ComShowCodeMessage("BKG40115");
					return false;
				}
				if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
					ComShowCodeMessage("BKG40009");
					ComSetFocus(formObj.del_cd);
					return false;
				}
			}else if(formObj.sch_tp[1].checked == true) {
				if(formObj.pod_cd.value == "") {
					ComShowCodeMessage("BKG40116");
					return false;
				}
				if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
					ComShowCodeMessage("BKG40009");
					ComSetFocus(formObj.del_cd);
					return false;
				}
			}else if(formObj.sch_tp[2].checked == true) {
				if(formObj.bl_no.value == "") {
					//msgs['BKG00104']="Mandatory item is missing. Please enter ({?msg1})"
					ComShowCodeMessage("BKG00104","B/L No.");
					return false;
				}
			}

			if( formObj.cust_cnt_cd.value.trim() != "" && formObj.cust_seq.value.trim() == "") {
				ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
				ComSetFocus(formObj.cust_seq);
				return;
			} else if( formObj.cust_seq.value.trim() != "" && formObj.cust_cnt_cd.value.trim() == "") {
				ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
				ComSetFocus(formObj.cust_cnt_cd);
				return;
			}
			if(formObj.sch_tp[0].checked
				&& formObj.vvd.value == ""){
				ComShowCodeMessage("BKG00626","VVD");
				ComSetFocus(formObj.vvd);
				return false;
			}
			if(formObj.sch_tp[1].checked
				&& formObj.vps_eta_dt_start.value == ""){
				ComShowCodeMessage("BKG00626","POD ETA");
				ComSetFocus(formObj.vps_eta_dt_start);
				return false;
			}
			if(formObj.sch_tp[1].checked
				&& formObj.vps_eta_dt_end.value == ""){
				ComShowCodeMessage("BKG00626","POD ETA");
				ComSetFocus(formObj.vps_eta_dt_end);
				return false;
			}
			if(formObj.sch_tp[1].checked
				&& (ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) > 6
					|| ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value) < 0 )
				){
				ComShowCodeMessage("BKG40014", "1");
				ComSetFocus(formObj.vps_eta_dt_end);
				return false;
			}
			break;
		case IBSAVE:
			if(!ComChkValid(formObj)) return false;
			break;
		case IBDELETE:
			if(!ComChkValid(formObj)) return false;
			break;
	}
	return true;
}
function t1sheet1_OnPopupClick(sheetObj, Row,	Col)
{
	with(sheetObj)
	{
		window.open("UI_BKG_0381_01_popup.jsp" ,"pop","scrollbars=no,fullscreen=no,width=600,height=145");
		}
}
function initControl() {
	axon_event.addListenerForm('click', 'obj_click', form );
	axon_event.addListenerForm('keyup', 'obj_keyup', form );
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	axon_event.addListenerForm ('blur', 'obj_deactivate', form);
	axon_event.addListenerForm ('activate', 'obj_activate', form);


	var formObj=document.form;
	if (parPodCd != null && parPodCd != "") {
		formObj.pod_cd.value=parPodCd;
	} else {
		var sPodCd=ComGetCookie("esm_bkg_0381_pod_cd");
		formObj.pod_cd.value=sPodCd;
	}
	if (parVvd != null && parVvd != "") {
		formObj.vvd.value=parVvd;
		formObj.sch_tp[0].checked=true;
		fnToggleSchTp("V", formObj);  // Search type change
	}
	if (parDelCd != null && parDelCd != "") {
		formObj.del_cd.value=parDelCd;
	}
	if (parBlNo != null && parBlNo != "") {
		formObj.bl_no.value=parBlNo;
		formObj.sch_tp[2].checked=true;
		fnToggleSchTp("B", formObj);  // Search type change
	}
	//alert(parEvalFlg);
	for(var k=0;k<formObj.is_validated.options.length;k++){
		if(formObj.is_validated.options[k].value == parEvalFlg){
			formObj.is_validated.options[k].selected=true;
		}
	}
	// calendar Handling
	formObj.vps_eta_dt_start.value=ComGetNowInfo('ymd','-');
	formObj.vps_eta_dt_end.value=ComGetDateAdd(null, 'd', 6, '-');
}
/**
 * Next Focus Move
 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){
	if (srcObj.value.length == maxLength) nextObj.focus();
}
/**
 * if val1 column value exist, val2 column CheckBox Check
 */
function fncNotNullToYes(sheetObj,Row,val1,val2){
	if(sheetObj.GetCellValue( Row,"t1sheet1_"+val1) != ""){
		sheetObj.SetCellValue( Row,"t1sheet1_"+val2,"Y");
	}
}
/**
 * click Event Handling
 * @return
 */
function obj_click() {
	var objName=ComGetEvent("name");
	var formObj=document.form;
	//POD ETA로 조회할 때 Email 버튼 숨기기 2015-12-28 Redmine #40604 NG Li CHOO
	//(AN title에 VVD 추가하기위해서 - POD ETA로 조회할 시 VVD가 다른 BL들이  한번에 보내질수있다. 그럼 AN title에 나오는 BL정보와 VVD정보가 달라질 수있다.)
	//한 mail form 에 여러 RD를 합쳐서 나가므로 grid의 마지막 BL정보 하나를 기준으로 나간다. 그래서 POD ETA 조건으로 조회시 Email 버튼은 막는다.
	if(formObj.sch_tp[1].checked == true){
		document.getElementById("btn_email").style.display="none";
	}else{
		document.getElementById("btn_email").style.display="Inline";
		if(beforetab == 1){
			ComBtnEnable("btn_email");
		}else{
			ComBtnDisable("btn_email");
		}
	}

	switch(objName) {
		case "vsl_info_set_flg":
			matchUnmatchSetup();
			break;
		case "sch_tp":
			var vSchTp="";
			for (var i=0; i<formObj.sch_tp.length; i++) {
				if (formObj.sch_tp[i].checked) {
					vSchTp=formObj.sch_tp[i].value;
				}
			}
			//formObj.sch_tp.value = vSchTp;
			fnToggleSchTp(vSchTp, formObj);
			//			alert(vSchTp);
			break;
	}
}
function fnToggleSchTp (vSchTp, formObj) {
	if (vSchTp=="B") {  // BL
		document.getElementsByName("bl_no")[0].setAttribute("required", true);
		//document.getElementsByName("bl_no")[0].setAttribute("fullfill", true);
		document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
		document.getElementsByName("vvd")[0].removeAttribute("required");
		document.getElementsByName("vvd")[0].removeAttribute("fullfill");
		document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
		document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
	} else    if (vSchTp=="V") {
		document.getElementsByName("bl_no")[0].removeAttribute("required");
		//document.getElementsByName("bl_no")[0].removeAttribute("fullfill");
		document.getElementsByName("pod_cd")[0].removeAttribute("fullfill");
		document.getElementsByName("vvd")[0].setAttribute("required", true);
		document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
		document.getElementsByName("vps_eta_dt_start")[0].removeAttribute("required");
		document.getElementsByName("vps_eta_dt_end")[0].removeAttribute("required");
	}else if (vSchTp=="D") {
		document.getElementsByName("bl_no")[0].removeAttribute("required");
		//document.getElementsByName("bl_no")[0].removeAttribute("fullfill");
		document.getElementsByName("pod_cd")[0].setAttribute("fullfill", true);
		document.getElementsByName("vvd")[0].removeAttribute("required");
		document.getElementsByName("vvd")[0].removeAttribute("fullfill");
		document.getElementsByName("vps_eta_dt_start")[0].setAttribute("required", true);
		document.getElementsByName("vps_eta_dt_end")[0].setAttribute("required", true);
	}
}
function obj_keyup() {
	var objName=ComGetEvent("name");
	var formObj=document.form;
	//var form = document.form;
	switch(objName) {
		case "sch_tp":
		case "vvd":
		case "vps_eta_dt_start":
		case "vps_eta_dt_end":
		case "pod_cd":
		case "del_cd":
		case "bl_no":
		case "cust_cnt_cd":
		case "cust_seq":
		case "cust_nm":
		case "po_no":
		case "sc_no":
			queryStrChange=true;
			break;
	}
}
/**
  * Form Object Deactive Event Handling
  * @return
  */
function obj_deactivate(){
	var objName=ComGetEvent("name");
	var formObj=document.form;
	switch(objName) {
		case "vps_eta_dt_start":
			ComChkObjValid(event.srcElement);
			break;
		case "vps_eta_dt_end":
			ComChkObjValid(event.srcElement);
			break;
	}
}
/**
 * Form Object Active Event Handling.
 * @return
 */
function obj_activate(){
	var objName=ComGetEvent("name");
	var formObj=document.form;
	//var form = document.form;
	switch(objName) {
		case "vvd":
			formObj.sch_tp[0].checked=true;
			fnToggleSchTp("V", formObj);
			break;
		case "vps_eta_dt_start":
			formObj.sch_tp[1].checked=true;
			fnToggleSchTp("D", formObj);
			formObj.vps_eta_dt_start.value=formObj.vps_eta_dt_start.value.replace(eval("/-/gi"), "");
			break;
		case "vps_eta_dt_end":
			formObj.sch_tp[1].checked=true;
			fnToggleSchTp("D", formObj);
			formObj.vps_eta_dt_end.value=formObj.vps_eta_dt_end.value.replace(eval("/-/gi"), "");
			break;
		case "bl_no":
			formObj.sch_tp[2].checked=true;
			fnToggleSchTp("B", formObj);
			break;
	}
}
/**
	 * Search End Event Handling
	 */
function t1sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	if(sheetObj.RowCount()> 0){
		sheetObj.CheckAll("t1sheet1_show_pu_flg",1);
		t1sheet1_OnClick(sheetObj,1,1);
	}

	ComOpenWait(false);
	return;
	var maxRow=sheetObj.LastRow();
	var cellValue="";
	for(i=1;i <= maxRow ; i++){
		for(var q=1;q<6;q++){
			//FAX
			cellValue=sheetObj.GetCellValue( i,"t1sheet1_fax_ntc_snd_rslt_cd"+q);
			if(cellValue == "6"){  // fail,red
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_fax_no"+q,"#FF0000");
			}else if(cellValue == "5"){  //success,blue
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_fax_no"+q,"#0000FF");
			}else if(cellValue == ""){  // Black
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_fax_no"+q,"#000000");
			}else {  // Pink
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_fax_no"+q,"#FF00C0");
			}
			cellValue=sheetObj.GetCellValue( i,"t1sheet1_fax_snd_flg"+q);
			if(cellValue == "N") {
				sheetObj.SetCellEditable(i, "t1sheet1_fax_evnt_flg"+q,0);
				sheetObj.SetCellEditable(i, "t1sheet1_fax_no"+q,0);
				sheetObj.SetCellValue(i, "t1sheet1_fax_evnt_flg"+q,0);
			}
			// EMAIL
			cellValue=sheetObj.GetCellValue( i,"t1sheet1_eml_ntc_snd_rslt_cd"+q);
			if(cellValue == "4"){  // fail,red
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_ntc_eml"+q,"#FF0000");
			}else if(cellValue == "3"){//success,blue
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_ntc_eml"+q,"#0000FF");
			}else if(cellValue == ""){  // Black
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_ntc_eml"+q,"#000000");
			}else {  // Pink
//parameter changed[check again]CLT                 sheetObj.SetCellFontColor(i,"t1sheet1_ntc_eml"+q,"#FF00C0");
			}
			cellValue=sheetObj.GetCellValue( i,"t1sheet1_eml_snd_flg"+q);
			if(cellValue == "N") {
				sheetObj.SetCellEditable(i, "t1sheet1_eml_evnt_flg"+q,0);
				sheetObj.SetCellEditable(i, "t1sheet1_ntc_eml"+q,0);
				sheetObj.SetCellValue(i, "t1sheet1_eml_evnt_flg"+q,0);
			}
		}
	}
}

var clickRow=0;
var clickBkgNo="";
var clickCustCntCd="";
var clickCustSeq="";
var clickCustNm="";
var clickScNo="";
var clickSheetObj;
function fnInStr(strSearch, charSearchFor)
{
	for (i=0; i < strSearch.length; i++)
	{
		if (charSearchFor == Mid(strSearch, i, 1))
		{
			return i;
		}
	}
	return -1;
}
/**
	 * grid Click Event Handling.
	 */
function t1sheet1_OnClick(sheetObj, Row, Col) {
	//global variable setting
	clickSheetObj=sheetObj;
	clickRow=Row;
	clickBkgNo=sheetObj.GetCellValue(Row,"t1sheet1_bkg_no");
	clickCustCntCd=sheetObj.GetCellValue(Row,"t1sheet1_cust_cnt_cd");
	clickCustSeq=sheetObj.GetCellValue(Row,"t1sheet1_cust_seq");
	clickCustNm=sheetObj.GetCellValue(Row,"t1sheet1_cust_nm").split("\r\n").join(" ").split('"').join("'");
	clickScNo=sheetObj.GetCellValue(Row,"t1sheet1_sc_no");

	if(sheetObj.ColSaveName(Col) == "t1sheet1_attach_doc_yn"){
		sheetObj.SetCellValue(Row,"t1sheet1_attach_doc_yn","");
		sheetObj.SetCellValue(Row,"t1sheet1_file_key","");
	}
}

/**
 * auto insert 0
 * @param obj
 * @return
 */
function fncCustSeqBlur(obj){
	var orgV=obj.value;
	if(orgV.length < 1){
		obj.value="";
	}else{
		obj.value=fncSeqTo6(orgV);
	}
}
/**
 * auto insert 0
 * @param str
 * @return
 */
function fncSeqTo6(str){
	var currentObjLen=str.length;
	var retStr="";
	for(var i=0;i<6-currentObjLen;i++){
		retStr += "0";
	}
	return retStr + str;
}
/**
* Multi Contact button
**/
function fncMultiContact(){
	var goUrl="";
	var param="";
	goUrl="ESM_BKG_1044.do?";
	if(clickSheetObj == null || clickSheetObj == undefined){
		ComShowCodeMessage("BKG04007");
		return;
	}
	var sRowStr=clickSheetObj.GetSelectionRows("/");
	var arr=sRowStr.split("/");
	if(arr.length > 1){
		//alert("다중 선택을 할수 없습니다.");
		ComShowCodeMessage("BKG04007");
		return;
	}
	if(clickCustCntCd == "" || clickCustSeq == ""){
		ComShowCodeMessage("BKG04007");
		return;
	}
	param += "1=1";
	param += "&cust_cnt_cd="+encodeURI(clickCustCntCd)
	+"&cust_seq="+encodeURI(clickCustSeq)
	+"&cust_nm="+encodeURI(clickCustNm);
	param += "&pgmNo=ESM_BKG_1044";
	ComOpenWindowCenter(goUrl + param,"ESM_BKG_1044",800,380,false);
}
/**
* t1sheet1 Dbl Click Event Handling
**/
function t1sheet1_OnDblClick(sheetObj, Row, Col, Value){
	var colName=sheetObj.ColSaveName(Col);
	if( colName == "t1sheet1_diff_rmk"){
		sheetObj.SetCellEditable(Row, colName,0);
		ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200 );
		sheetObj.SetCellEditable(Row, colName,1);
	}
	if((colName == "t1sheet1_cust_nm" )){
		if(sheetObj.GetRowHeight(Row) == 20){
			sheetObj.SetRowHeight(Row,0);
			sheetObj.SetColWidth(Col,0);
		}else{
			sheetObj.SetRowHeight(Row,20);
			sheetObj.SetColWidth(Col,180);
		}
	}
}
/**
* Multi Fax 발송
**/
function fncSendFaxMulti(sheetObj,formObj){
	if(sheetObj.CheckedRows("t1sheet1_chk_fax") < 1){
		//=> BKG40018 : Please select at least one row by mouse click in order to Fax
		ComShowCodeMessage("BKG40018");
		return;
	}
	if(!ComShowCodeConfirm("BKG40037","Arrival Notice")){
		return;
	}
	formObj.f_cmd.value=MULTI01;
	var sParam=FormQueryString(formObj);
	sparam=sParam + "&" + ComGetPrefixParam("t1sheet1_");
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(true);
	sheetObj.DoSave("ESM_BKG_0381GS.do", sparam, "t1sheet1_chk_fax", false);
}

function t1sheet1_OnChange(sheetObj, Row, Col) {
	var prefix="t1sheet1_";
	var colName=sheetObj.ColSaveName(Col);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//CheckBox Check[FAX]
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	if(beforetab == 0){
		if(colName == prefix + "fax_no1"
			|| colName == prefix + "fax_no2"
			|| colName == prefix + "fax_no3"
			|| colName == prefix + "fax_no4"
			|| colName == prefix + "fax_no5"
			){
			if(sheetObj.GetCellValue(Row,Col) != ""){
				sheetObj.SetCellValue(Row,Col -1 ,"1");
			}else{
				sheetObj.SetCellValue(Row,Col -1 ,"0");
			}
		}
		if(colName == prefix + "fax_evnt_flg1"
			|| colName == prefix + "fax_evnt_flg2"
			|| colName == prefix + "fax_evnt_flg3"
			|| colName == prefix + "fax_evnt_flg4"
			|| colName == prefix + "fax_evnt_flg5"
			){
			for(var x=1;x < 6;x++){
				if(sheetObj.GetCellValue(Row,prefix + "fax_evnt_flg"+x) == "1"){
					sheetObj.SetCellText(Row, prefix + "chk_fax" ,"1");
					break;
				}else{
					sheetObj.SetCellText(Row, prefix + "chk_fax" ,"0");
				}
			}
			for(var x=1;x < 6;x++){
				if(colName == prefix + "fax_evnt_flg"+x){
					if(sheetObj.GetCellValue(Row,Col+1) != ""){
						sheetObj.SetCellValue(Row,Col,sheetObj.GetCellValue(Row,Col));
					}else{
						sheetObj.SetCellValue(Row,Col,"0");
					}
				}
			}
		}else if(colName == prefix + "chk_fax"){
			if(sheetObj.GetCellValue(Row, prefix + "chk_fax") == "0"){
				for(var x=1;x < 6;x++){
					sheetObj.SetCellText(Row,prefix + "fax_evnt_flg"+x ,"0");
				}
			}else if(sheetObj.GetCellValue(Row, prefix + "chk_fax") == "1"){
				for(var x=1;x < 6;x++){
					if(sheetObj.GetCellText(Row,prefix + "fax_no"+x) != ""){
						sheetObj.SetCellText(Row,prefix + "fax_evnt_flg"+x ,"1");
					}
				}
			}
		}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//CheckBox Check(EMAIL)
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}else if(beforetab == 1){
		if(colName == prefix + "ntc_eml1"
			|| colName == prefix + "ntc_eml2"
			|| colName == prefix + "ntc_eml3"
			|| colName == prefix + "ntc_eml4"
			|| colName == prefix + "ntc_eml5"
			){
			if(sheetObj.GetCellValue(Row,Col) != ""){
				sheetObj.SetCellValue(Row,Col -1 ,"1");
			}else{
				sheetObj.SetCellValue(Row,Col -1 ,"0");
			}
			if(sheetObj.GetCellValue(Row,Col) != ""
				&& !ComIsEmailAddr(sheetObj.GetCellValue(Row,Col))){
				ComShowCodeMessage("BKG40021" , sheetObj.GetCellValue(Row,Col));
				sheetObj.SelectCell(Row, Col);
				return;
			}
		}
		if(colName == prefix + "eml_evnt_flg1"
			|| colName == prefix + "eml_evnt_flg2"
			|| colName == prefix + "eml_evnt_flg3"
			|| colName == prefix + "eml_evnt_flg4"
			|| colName == prefix + "eml_evnt_flg5"
			){
			for(var x=1;x < 6;x++){
				if(sheetObj.GetCellValue(Row,prefix + "eml_evnt_flg"+x) == "1"){
					sheetObj.SetCellText(Row, prefix + "chk_email" ,"1");
					break;
				}else{
					sheetObj.SetCellText(Row, prefix + "chk_email" ,"0");
				}
			}
			for(var x=1;x < 6;x++){
				if(colName == prefix + "eml_evnt_flg"+x){
					if(sheetObj.GetCellValue(Row,Col+1) != ""){
						sheetObj.SetCellValue(Row,Col,sheetObj.GetCellValue(Row,Col));
					}else{
						sheetObj.SetCellValue(Row,Col,"0");
					}
				}
			}
		}else if(colName == prefix + "chk_email"){
			if(sheetObj.GetCellValue(Row, prefix + "chk_email") == "0"){
				for(var x=1;x < 6;x++){
					sheetObj.SetCellText(Row,prefix + "eml_evnt_flg"+x ,"0");
				}
			}else if(sheetObj.GetCellValue(Row, prefix + "chk_email") == "1"){
				for(var x=1;x < 6;x++){
					if(sheetObj.GetCellText(Row,prefix + "ntc_eml"+x) != ""){
						sheetObj.SetCellText(Row,prefix + "eml_evnt_flg"+x ,"1");
					}
				}
			}
		}
	}
	if (colName == prefix + "arr_prv_fom_cd") {
		for (var i=0; i<arrArrPrvFomCd.length; i++) {
			if (arrArrPrvFomCd[i] == sheetObj.GetCellValue(Row,Col)) {
				sheetObj.SetCellValue(Row, prefix + "mrd_id",arrMrdId[i],0);
				sheetObj.SetCellValue(Row, prefix + "com_param",arrComParam[i],0);
				break;
			}
		}
	}
}
function t1sheet1_OnAfterEdit(sheetObj, Row, Col) {
	var prefix="t1sheet1_";
	var colName=sheetObj.ColSaveName(Col);
	if(beforetab == 0){
		if(colName == prefix + "fax_no1"
			|| colName == prefix + "fax_no2"
			|| colName == prefix + "fax_no3"
			|| colName == prefix + "fax_no4"
			|| colName == prefix + "fax_no5"
			){
			if(sheetObj.GetCellValue(Row,Col) != ""){
				sheetObj.SetCellValue(Row,Col -1 ,"1");
			}else{
				sheetObj.SetCellValue(Row,Col -1 ,"0");
			}
		}
	}else if(beforetab == 1){
		if(colName == prefix + "ntc_eml1"
			|| colName == prefix + "ntc_eml2"
			|| colName == prefix + "ntc_eml3"
			|| colName == prefix + "ntc_eml4"
			|| colName == prefix + "ntc_eml5"
			){
			if(sheetObj.GetCellValue(Row,Col) != ""){
				sheetObj.SetCellValue(Row,Col -1 ,"1");
			}else{
				sheetObj.SetCellValue(Row,Col -1 ,"0");
			}
		}
	}
}
function t1sheet1_OnSaveEnd(sheetObj, errMsg){
	ComOpenWait(false);
	//sheetObj.WaitImageVisible = true;
	if(errMsg != ""){
		sheetObj.CheckAll("t1sheet1_chk_fax",0,1);
		sheetObj.CheckAll("t1sheet1_chk_email",0,1);
		sheetObj.SetHeaderCheck(0,"t1sheet1_chk_fax",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_chk_email",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_chg_dp_flg",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_show_pu_flg",0);

		sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg1",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg2",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg3",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg4",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_fax_evnt_flg5",0);

		sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg1",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg2",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg3",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg4",0);
		sheetObj.SetHeaderCheck(0,"t1sheet1_eml_evnt_flg5",0);

		ComSetCookie("esm_bkg_0381_pod_cd", form.pod_cd.value);
		doActionIBSheet(sheetObj,document.form,IBSEARCH);
	}
}
function pause(numberMillis) {
	var now=new Date();
	var exitTime=now.getTime() + numberMillis;
	while (true) {
		now=new Date();
		if (now.getTime() > exitTime)
			return;
	}
}
//no support[check again]CLT
function t1sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
}
function formToQueryString(form,arg){
	var retStr="";
		for(var j=0;j<form.elements.length;j++){
			for(var i=0;i < arg.length;i++){
				if(arg[i] == form.elements[j].name){
					if(form.elements[j].type == "checkbox" || form.elements[j].type == "radio"){
						if(form.elements[j].checked == true){
							retStr += form.elements[j].name + "=" + form.elements[j].value + "&";
							continue;
						}
					}else{
						retStr += form.elements[j].name + "=" + form.elements[j].value + "&";
					}
				}
			}
		}
	//alert(retStr);
	return retStr;
}
/**
 * Rd Print setting
 */
function initRdConfig(rdObject) {
	var Rdviewer=rdObject;
	Rdviewer.AutoAdjust=true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.IsShowDlg=0;
	Rdviewer.SetBackgroundColor(128, 128, 128);
	Rdviewer.ApplyLicense("0.0.0.0");
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.style.height = 0;

}
/**
 * RD open  and  print
 */
function rdOpen() {
	var formObj=document.form;
//	var Rdviewer=rdObject;
	var appendReport = [];
	var chk="t1sheet1_chk_fax";
	if (tabObjects[0].GetSelectedIndex()== 1)
		chk="t1sheet1_chk_email";
	var bkgNo;
	var mrdId;
	var loclLangFlg;
	var comParam;
	var chgDpFlg;
	var tsFlg="N";
	if(formObj.ts_flg.checked) tsFlg="Y";
	var rdParam;
	with (sheetObjects[0]) {
		if (CheckedRows(chk) == 0) {
			ComShowCodeMessage("BKG00606");
			return;
		}
		ComOpenWait(true);
		for (var i=1; i<RowCount()+1; i++) {
			mrdId=GetCellValue(i,"t1sheet1_mrd_id");
			if (GetCellValue(i, chk) == "1" && mrdId != "") {
				loclLangFlg=GetCellValue(i,"t1sheet1_locl_lang_flg");
				comParam=GetCellValue(i,"t1sheet1_com_param");
				chgDpFlg=GetCellValue(i,"t1sheet1_chg_dp_flg");
				bkgNo=GetCellValue(i,"t1sheet1_bkg_no");
				show_pu = GetCellValue(i,"t1sheet1_show_pu_flg");
				rdParam="/rv ";
				rdParam += " form_bkgNo['" + bkgNo + "']";
				rdParam += " form_usrId['" + strUsr_id + "']";
				rdParam += " form_loclFlg['" + loclLangFlg + "']";
				rdParam += " form_chgDpFlg['" + chgDpFlg + "']";
				rdParam += " form_tsFlg['" + tsFlg +"'] ";
				rdParam += " form_showPuFlg['" + show_pu + "']";
				rdParam += " form_remarkCtnt['']";
				rdParam += " form_ofcCd['" + strOfc_cd + "']";
//				rdParam += " " + comParam + " /rop /rwait /rallprn /rprintnexit";

				var strPath=RD_path + "apps/opus/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/" + mrdId + ".mrd";

	            appendReport.push({mrdPath:strPath, mrdParam:RDServer + rdParam});
			}
		}
//		ComShowMessage("Print Completed!!");

		directReportDownload(appendReport);
// 	    viewer.print({isServerSide:true}); 
//		ComOpenWait(false);
	}
}




	/* Developer Work End */

var pSheetObj, pRow, pCol ;
function initUpload(){
		upload1.Initialize({
			SaveUrl:'MNR_INTGS.do'
			,Files:[]
			,AfterSaveStatus : function(result) {
			var code = result.code;
//      		console.log("#########code:"+code);
			if( code == 0) {
				var sXml = (new XMLSerializer()).serializeToString(result.xmlData);

				document.form.keys.value=ComGetEtcData(sXml,"seqValue");

				pSheetObj.SetCellFontColor(pRow,"t1sheet1_attach_doc_yn","#FF00C0");
				pSheetObj.SetCellValue(pRow,"t1sheet1_attach_doc_yn","Y (Del)");
				pSheetObj.SetCellValue(pRow,"t1sheet1_file_key" ,ComGetEtcData(sXml,"seqValue"));
//      	        console.debug("##########t1sheet1_file_key:"+pSheetObj.GetCellValue(pRow,"t1sheet1_file_key"));
//				var files = result.files;
//                for( var i = 0; i < files.length; i++) {
//                    files[i].DeleteFromList();
//                }

				ComUploadRemoveFile(upload1, "", true);

			}else {
				ComShowMessage(result.msg);
			}
			ComOpenWait(false);
		}
		,AfterAddFile:function(result){

			var files = result.files;
			var fileName = "";
			var fileName= files[files.length-1].GetFileName();
// 		    console.debug("##########fileName:"+fileName);
			ComOpenWait(true);
			fileUploadFlag=true;
		   var file_seq=pSheetObj.GetCellValue(pRow, 't1sheet1_file_key');
			var file_dtl_seq="1";

			var ibflag='U';
			if(file_seq=="") ibflag='I';
			var sParam="f_cmd="+COMMAND01;
			sParam+= "&mnr_grp_tp_cd=RPR";       // MNR Work Group Type Code
			sParam+= "&file_seq="+file_seq;    // Existed file sequence
			sParam+= "&file_dtl_seq=" + file_dtl_seq;    // Existed file sequence
			sParam+= "&org_file_nm="; // Fileupload file name
			sParam+= "&ibflag=" + ibflag;        // I : First time file upload, U : modify file
			paramToForm(sParam);

			upload1.SaveStatus();
		}
		});
	}

/**
* handling event when MouseMove Sheet1
*/
function t1sheet1_OnMouseMove(sheetObj, e) {
	var row     = sheetObj.MouseRow();
	var col     = sheetObj.MouseCol();
	var saveName = sheetObj.ColSaveName(col);
	var info    = null;
//    var editFlag = sheetObj.GetCellEditable( row , col);
	if (row > 0 && saveName == "t1sheet1_attach_doc") {
		info = sheetObj.GetCellElement(row, col, 1);

		pSheetObj = sheetObj;
		pRow = row;
		pCol = col;
//        console.log("####################saveName:"+saveName+"--"+info);

		upload1.SetFileUploadElement(info);
	}
}
