/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0381.js
*@FileTitle : Arrival Notice Send
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 박성호
*@LastVersion : 1.0
* 2009.06.03 박성호
* 1.0 Creation
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 한진해운
 */

/**
 * @extends
 * @class esm_bkg_0381 : esm_bkg_0381 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function esm_bkg_0381() {
    this.processButtonClick     = tprocessButtonClick;
    this.setSheetObject         = setSheetObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;
    this.initControl            = initControl;
    this.doActionIBSheet        = doActionIBSheet;
    this.setTabObject           = setTabObject;
    this.validateForm           = validateForm;
    this.obj_keypress           = obj_keypress;
}

/* 개발자 작업    */



//공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var t1beforetab = 1;
var t3beforetab = 1;

var sheetObjects = new Array();
var sheetObjectsMap = new Array();
var sheetCnt = 0;

//로컬전역변수
var IBSENDFAX = "IBSENDFAX";
var IBSENDEMAIL = "IBSENDEMAIL";
var IBPREVIEW = "IBPREVIEW";

var arrMrdId = "";
var arrComParam = "";
var arrArrPrvFomCd = "";

var rdObjects = new Array();
var rdCnt = 0;

/*********************** EDTITABLE MULIT COMBO START ********************/
var comboCnt = 0;
var comboObjects = new Array();
var comboObjectsMap = new Array();
/*********************** EDTITABLE MULIT COMBO END ********************/

//@ 탭 변경시 전송할 행 선택 콤보 재세팅을 위한 코드 값을 저장할 변수 
var seletedEmailCboIndex = -1;
var seletedFaxCboIndex   = -1;

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

    var sheetObject1 = sheetObjects[0];


    /*******************************************************/
    var formObject = document.form;

    //try {
    var srcName = window.event.srcElement.getAttribute("name");

    switch(srcName) {
        case "eta_dt_start":
            var cal = new ComCalendarFromTo();
            cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
            break;

        case "eta_dt_end":
            var cal = new ComCalendarFromTo();
            cal.select(formObject.vps_eta_dt_start, formObject.vps_eta_dt_end, 'yyyy-MM-dd');
            break;

        case "btn_Retrieve":
            //
            sheetObject1.HeadCheck(0,"t1sheet1_"+"chk_fax") =false;
            sheetObject1.HeadCheck(0,"t1sheet1_"+"chk_email") =false;
            sheetObject1.HeadCheck(0,"t1sheet1_"+"chg_dp_flg") =false;
            ComSetCookie("esm_bkg_0381_pod_cd", form.pod_cd.value);
            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;

        case "btn_downexcel":
            if(sheetObject1.rowcount < 1){//결과가 없을경우
                ComShowCodeMessage("BKG00109");
            }else{
                //mySheet.Down2Excel([Mode], [UseOpenFile], [NewSheet], [Merge], [SaveAsName],
                //         [ReportPageUrl], [HideExcelMsg],[WriteTreeLevel], [WorkSheetName],
                //         [FocusFirstSheet],[ColumnSkipList],[RowSkipList],[bProtect],[bFormula],
                //         [IncludeImageType])

				//sheetObject1.Down2Excel(true, false, false, true, "",
                //    "", false, false, "",
                //    true);//열린 탭에 따라 엑셀다운로드

				sheetObject1.SpeedDown2Excel(-1);

            }
            break;

        case "btn_fax":
            //validated 검증루틴
            if(formObject.is_validated.value == "N"){
                ComShowCodeMessage("BKG04003");
                return;
            }
            for(var i=0;i<=sheetObject1.RowCount;i++){
                if(sheetObject1.CellValue(i,"t1sheet1_" + "chk_fax") != "1"){
                    continue;
                }

                if(sheetObject1.CellValue(i,"t1sheet1_" + "is_validated") != "Y"){
                    //alert("Code Validation 된 데이터가 없습니다.");
                    ComShowCodeMessage("BKG04003");
                    return;
                }

				if(sheetObject1.CellValue(i,"t1sheet1_" + "rd_prt_flg") == "N"){
                    //alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
                    ComShowCodeMessage("BKG43040");
                    return;
                }
            }

            //RD 정보 구해오기
//            formObject.f_cmd.value = SEARCH02;
//
//            var sParam = FormQueryString(formObject);
//            sParam += "&bkg_no=" + clickBkgNo;
//            //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");
//
//            //alert(sparam);
//
//            //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
//            var arrXml = sheetObject1.GetSearchXml("ESM_BKG_0381GS.do",sParam);
//
//            //alert(arrXml);
//            var mrdId = ComGetEtcData(arrXml, "MRD_ID");
//            var loclLangFlg = ComGetEtcData(arrXml, "LOCL_LANG_FLG");
            var mrdId = sheetObject1.CellValue(clickRow,"t1sheet1_" + "mrd_id");
            var loclLangFlg = sheetObject1.CellValue(clickRow,"t1sheet1_" + "locl_lang_flg");
            if(mrdId == ""){
                //alert("Arrival Notice Setting 정보가 없습니다.");
                ComShowCodeMessage("BKG40050");
                return;
            }

            doActionIBSheet(sheetObject1,formObject,IBSENDFAX);
            break;

        case "btn_email":
            //alert('a');
            //validated 검증루틴
            if(formObject.is_validated.value == "N"){
                ComShowCodeMessage("BKG04003");
                return;
            }
            //alert(sheetObject1.RowCount);
            for(var i=1;i<=sheetObject1.RowCount;i++){

                if(sheetObject1.CellValue(i,"t1sheet1_" + "chk_email") != "1"){
                    continue;
                }

                if(sheetObject1.CellValue(i,"t1sheet1_" + "is_validated") != "Y"){
                    //alert("Code Validation 된 데이터가 없습니다.");
                    ComShowCodeMessage("BKG04003");
                    return;
                }
				if(sheetObject1.CellValue(i,"t1sheet1_" + "rd_prt_flg") == "N"){
                    //alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
                    ComShowCodeMessage("BKG43040");
                    return;
                }
            }
            
            //처리 단위 300
            if (sheetObject1.CheckedRows("t1sheet1_chk_email") > 300) {
            	ComShowCodeMessage("BKG08325","300");
           	 	return false;
            } 
            //RD 정보 구해오기
//            formObject.f_cmd.value = SEARCH02;
//
//            var sParam = FormQueryString(formObject);
//            sParam += "&bkg_no=" + clickBkgNo;
//            //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");
//
//            //alert(sparam);
//
//            //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
//            var arrXml = sheetObject1.GetSearchXml("ESM_BKG_0381GS.do",sParam);
//
//            //alert(arrXml);
//            var mrdId = ComGetEtcData(arrXml, "MRD_ID");
//            var loclLangFlg = ComGetEtcData(arrXml, "LOCL_LANG_FLG");
            var mrdId = sheetObject1.CellValue(clickRow,"t1sheet1_" + "mrd_id");
            var loclLangFlg = sheetObject1.CellValue(clickRow,"t1sheet1_" + "locl_lang_flg");
            //alert(mrdId);
            //return;
            if(mrdId == ""){
                //alert("Arrival Notice Setting 정보가 없습니다.");
                ComShowCodeMessage("BKG40050");
                return;
            }

            doActionIBSheet(sheetObject1,formObject,IBSENDEMAIL);
            break;

		case "btn_email_edit":
            
			if(sheetObject1.checkedrows("t1sheet1_"+"chk_email") < 1){
                //Email만 보낼 수 있는 UI 에서 경고 메세지 :
                //=> BKG40019 : Please select at least one row by mouse click in order to E-mail
                ComShowCodeMessage("BKG40019");
                return;
            }
            
            //validated 검증루틴
            if(formObject.is_validated.value == "N"){
                ComShowCodeMessage("BKG04003");
                return;
            }
            //alert(sheetObject1.RowCount);
            for(var i=1;i<=sheetObject1.RowCount;i++){

                if(sheetObject1.CellValue(i,"t1sheet1_" + "chk_email") != "1"){
                    continue;
                }

                if(sheetObject1.CellValue(i,"t1sheet1_" + "is_validated") != "Y"){
                    //alert("Code Validation 된 데이터가 없습니다.");
                    ComShowCodeMessage("BKG04003");
                    return;
                }
				if(sheetObject1.CellValue(i,"t1sheet1_" + "rd_prt_flg") == "N"){
                    //alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
                    ComShowCodeMessage("BKG43040");
                    return;
                }
            }

            //처리 단위 300
            if (sheetObject1.CheckedRows("t1sheet1_chk_email") > 300) {
            	ComShowCodeMessage("BKG08325","300");
           	 	return false;
            } 
            var mrdId = sheetObject1.CellValue(clickRow,"t1sheet1_" + "mrd_id");
            var loclLangFlg = sheetObject1.CellValue(clickRow,"t1sheet1_" + "locl_lang_flg");
            
            if(mrdId == ""){
                //alert("Arrival Notice Setting 정보가 없습니다.");
                ComShowCodeMessage("BKG40050");
                return;
            }
            
			bkg_no = "";
			ntc_knd_cd = "AN";
			edt_to_eml = "";
			ComOpenWindowCenter("/hanjin/ESM_BKG_1096.do?ui_id=ESM_BKG_0381&ntc_knd_cd="+ntc_knd_cd+"&bkg_no_list="+bkg_no+"&edt_to_eml="+edt_to_eml, "ESM_BKG_1096", 700, 608, true);
		break;            
        case "btn_preview":

			if(sheetObject1.CellValue(clickRow,"t1sheet1_" + "is_validated") != "Y"){
                    //alert("Code Validation 된 데이터가 없습니다.");
               ComShowCodeMessage("BKG04003");
               return;
            }

			if(sheetObject1.CellValue(clickRow,"t1sheet1_" + "rd_prt_flg") == "N"){
				//alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
				ComShowCodeMessage("BKG43040");
				return;
            }


//            //RD 정보 구해오기
//            formObject.f_cmd.value = SEARCH02;
//
//            var sParam = FormQueryString(formObject);
//            sParam += "&bkg_no=" + clickBkgNo;
//            //sparam = sParam + "&" + ComGetPrefixParam("sheet1_");
//
//            //alert(sparam);
//
//            //sheetObj.DoSave("ESM_BKG_0946GS.do", sparam, -1, false);
//            var arrXml = sheetObject1.GetSearchXml("ESM_BKG_0381GS.do",sParam);
//
//            //alert(arrXml);
//            var mrdId = ComGetEtcData(arrXml, "MRD_ID");
//            var loclLangFlg = ComGetEtcData(arrXml, "LOCL_LANG_FLG");
//            var comParam = ComGetEtcData(arrXml, "COM_PARAM");
//            //alert(mrdId);
//            //return;
            var mrdId = sheetObject1.CellValue(clickRow,"t1sheet1_" + "mrd_id");
            var loclLangFlg = sheetObject1.CellValue(clickRow,"t1sheet1_" + "locl_lang_flg");
            var comParam = sheetObject1.CellValue(clickRow,"t1sheet1_" + "com_param");
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
            //alert(mrdId);
            formObject.com_mrdPath.value = "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/"
            + mrdId
            + ".mrd";
            var strArg = "/rv ";
            strArg += " form_bkgNo['" + clickBkgNo + "']";
            //revise flag 추가
            strArg += " form_revise_YN['']";
            strArg += " form_usrId['" + strUsr_id + "']"; 
            strArg += " form_loclFlg['" + loclLangFlg + "']";
            strArg += " form_chgDpFlg['" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"chg_dp_flg") + "']";

			if(formObject.ts_flg.checked){
				strArg += " form_tsFlg['Y'] ";
			}else{
				strArg += " form_tsFlg['N'] ";
			}

            //strArg += " form_mainOnly[N]";
            //strArg += " form_level[(6)]";
            //var _rmk = sheetObject1.CellValue(clickRow,"t1sheet1_"+"diff_rmk");
            //_rmk = _rmk.replace("'","");
            //_rmk = _rmk.replace("\n","");
            //_rmk = _rmk.replace(eval("/\"/gi"),"");


            strArg += " form_remarkCtnt['']";
			strArg += " form_ofcCd['" + strOfc_cd + "']";

            strArg += " " + comParam;

			//strArg += " /rfonttype40";//2010-03-29 by sungho Arial Unicode Font 사용 시 글자의 윗부분이 잘리는 현상을 해결

			//alert(strArg);return;
            //alert(mrdId);
            //alert(strArg);
//alert(formObject.com_mrdPath.value);
            formObject.com_mrdArguments.value = strArg;
            formObject.com_mrdTitle.value = "Arrival Notice Send";
            formObject.com_mrdSaveDialogFileName.value = "AN_" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"bl_no");
            formObject.com_mrdSaveDialogFileExt.value = "pdf";
            formObject.com_mrdDisableToolbar.value = "";
            formObject.com_mrdBodyTitle.value = "Arrival Notice Send";
            ComOpenRDPopupModal();
            break;

        case "btn_Print":
			rdOpen(rdObjects[0]);
            break;

        case "btn_save":
           // alert(srcName);
            break;

        case "btn_setup":
            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_0672.do?";

            param += "1=1";
			//2010-03-23 ; 이후 뜨는창의 스크립트 오류로 인해 값을 초기화함. by sungho
			document.form.f_cmd.value = "";
            param += "&" + FormQueryString(formObject);
            param += "&autoSearchFlg=Y";
            param += "&pgmNo=ESM_BKG_0672-01";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0672",1024,600,true);
            break;

        case "btn_history":
            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_0001.do?";

            param += "1=1";
            //param += "&" + FormQueryString(formObject);
            if(clickRow == 0){
                param += "&bl_no=";
            }else{
                param += "&bl_no="+sheetObjects[0].CellText(clickRow, "t1sheet1_bl_no");
            }
            param += "&sch_tp=B";
            param += "&autoSearchFlg=Y";
            param += "&ntc_knd_cd=AN";
            param += "&pgmNo=ESM_BKG_0001";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0001",1024,670,true);
            break;
        case "btn_goto_invoice":
            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/FNS_INV_0034_01.do?";

            param += "1=1";
            param += "&" + FormQueryString(formObject);
            param += "&autoSearchFlg=N";
            param += "&pgmNo=FNS_INV_0034-01";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"FNS_INV_0034_01",1000,590,true);

            break;
        case "btn_group_by_code":
            //validated 검증루틴
            if(formObject.is_validated == "N"){
                ComShowCodeMessage("BKG04003");
                return;
            }

            if(sheetObject1.CellValue(clickRow,"t1sheet1_" + "is_validated") != "Y"){
                //alert("Code Validation 된 데이터가 없습니다.");
                ComShowCodeMessage("BKG04003");
                return;
            }



            var goUrl = "";
            var param = "";

            if(clickCustCntCd == "" ){
                ComShowCodeMessage("BKG40057");
                return;
            }

            goUrl = "/hanjin/ESM_BKG_0946.do?";

            param += "1=1";
            //param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);

            param += "&cust_cnt_cd="+clickCustCntCd;
            param += "&cust_seq="+clickCustSeq;
            param += "&gubun=C";
            param += "&rvis_flg="+sheetObject1.CellValue(clickRow,"t1sheet1_"+"rvis_flg");
			if(formObject.ts_flg.checked){
				param += "&ts_flg=Y";
			}else{
				param += "&ts_flg=N";
			}

            param += "&bkg_no="+clickBkgNo;

            var tmpFaxNo = "";


            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg1")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no1") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg2")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no2") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg3")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no3") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg4")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no4") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg6")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no6") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg7")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no7") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg5")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no5") + ",";
//            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_chg_flg6")+ ",";
//            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_chg_flg7")+ ",";
            



            var tmpEmail = "";

            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg1")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml1") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg2")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml2") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg3")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml3") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg4")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml4") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg6")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml6") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg7")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml7") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg5")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml5") + ",";
           // A1,A2 Charge 표기 설정을 최종적으로 삭제하기로 하였음. 자리는 유지하고 Hidden처리함. 2016.03.09
//            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_chg_flg6")+ ",";
//            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_chg_flg7")+ ",";

            param += "&fax_no="+tmpFaxNo;
            param += "&email="+tmpEmail;

            //param += "&cust_nm="+encodeURI(clickCustNm);

            //alert(param);return;



            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0946",1024,570,true);
            break;

        case "btn_group_sc":
            //validated 검증루틴
            if(formObject.is_validated == "N"){
                ComShowCodeMessage("BKG04003");
                return;
            }

            if(sheetObject1.CellValue(clickRow,"t1sheet1_" + "is_validated") != "Y"){
                //alert("Code Validation 된 데이터가 없습니다.");
                ComShowCodeMessage("BKG04003");
                return;
            }

            var goUrl = "";
            var param = "";

            if(clickScNo == "" ){
                ComShowCodeMessage("BKG40058");
                return;
            }


            goUrl = "/hanjin/ESM_BKG_0946.do?";

            param += "1=1";
            //param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
            param += "&sc_no="+clickScNo;
            param += "&gubun=S";
			if(formObject.ts_flg.checked){
				param += "&ts_flg=Y";
			}else{
				param += "&ts_flg=N";
			}
            param += "&pgmNo=ESM_BKG_0946";

            //param += "&bkg_no="+clickBkgNo;
            param += "&bkg_no="+clickBkgNo;
            var tmpFaxNo = "";


            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg1")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no1") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg2")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no2") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg3")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no3") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg4")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no4") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg6")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no6") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg7")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no7") + ",";
            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_evnt_flg5")
            + "|" +sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_no5") + ",";
//            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_chg_flg6")+ ",";
//            tmpFaxNo += sheetObject1.CellValue(clickRow,"t1sheet1_"+"fax_chg_flg7")+ ",";



            var tmpEmail = "";

            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg1")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml1") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg2")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml2") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg3")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml3") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg4")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml4") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg6")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml6") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg7")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml7") + ",";
            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_evnt_flg5")
            + "|" + sheetObject1.CellValue(clickRow,"t1sheet1_"+"ntc_eml5") + ",";
         // A1,A2 Charge 표기 설정을 최종적으로 삭제하기로 하였음. 자리는 유지하고 Hidden처리함. 2016.03.09
//            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_chg_flg6")+ ",";
//            tmpEmail += sheetObject1.CellValue(clickRow,"t1sheet1_"+"eml_chg_flg7")+ ",";
            
            param += "&fax_no="+tmpFaxNo;
            param += "&email="+tmpEmail;

            //param += "&cust_nm="+encodeURI(clickCustNm);

            //alert(param);return;

            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0946",1024,570,true);

            break;

        case "btn_multi_contact":
            fncMultiContact();//1044 로 이동
            break;

        case "btn_template":

            var goUrl = "";
            var param = "";
            goUrl = "/hanjin/ESM_BKG_0375.do?";

            param += "1=1";
            param += "&pgmNo=ESM_BKG_0375&autoSearchFlg=Y";

            //선택되지 않을경우는 No Action
            //location.href=goUrl + param;
            ComOpenWindowCenter(goUrl + param,"ESM_BKG_0375",1024,610,true);

            break;

        case "btn_select_rows":
        	input_select_rows();
        	break;



    } // end switch
//}catch(e) {
//	if( e == "[object Error]") {
//		ComShowMessage(OBJECT_ERROR);
//	} else {
//		ComShowMessage(e);
//	}
//}
}

/**
  * IBSheet Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setSheetObject(sheet_obj){

    sheetObjects[sheetCnt++] = sheet_obj;
    sheetObjectsMap[sheet_obj.id] = sheet_obj;

}



/**
  * Sheet 기본 설정 및 초기화
  * body 태그의 onLoad 이벤트핸들러 구현
  * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
  */
function loadPage() {
    var formObj = document.form;


    for(i=0;i<sheetObjects.length;i++){
        //khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가

        ComEndConfigSheet(sheetObjects[i]);
       
    //doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);

    }



    for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

    
  //initializing MultiCombo 
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }    
    
    initControl();


	//2017.10.20 Email Tab 활성화
	tabObjects[0].SelectedIndex = 1;
	// 2017.10.20 한국, 베트남 이외 팩스 전송 안되게 처리
	if(!(strCnt_cd == "KR" || strCnt_cd == "JP" || strCnt_cd == "VN")){
		tabObjects[0].TabEnable(0) = false;
	}
    
    //alert(parAutoSearchFlg);
    if(parAutoSearchFlg != ""){
        formObj.vvd.value = parVvd;
        formObj.vps_eta_dt_start.value = parVpsEtaDtStart;
        formObj.vps_eta_dt_end.value = parVpsEtaDtEnd;
        formObj.pod_cd.value = parPodCd;
        formObj.del_cd.value = parDelCd;
        formObj.pol_cd.value = parPolCd;
        formObj.bl_no.value = parBlNo;

        if(parTsFlg == "Y"){
            formObj.ts_flg.checked = true;
        }
        formObj.cust_cnt_cd.value = parCustCntCd;
        formObj.cust_seq.value = parCustSeq;
        formObj.cust_nm.value  = parCustNm;

        formObj.cust_ref_no.value = parCustRefNo;
        formObj.s_no.value = parSNo;
        formObj.c_no.value = parCNo;

        for(var x=0;x<formObj.sch_tp.length;x++){
            //alert(formObj.sch_tp[x].value);
            if(parSchTp == formObj.sch_tp[x].value){
                formObj.sch_tp[x].checked = true;
                break;
            }
        }
    }



    //로그인 사용자 정보에 의한 UI 변경
    //화면 UI 설계서 - 3번
    //alert(strOfc_cd);
//    if(strOfc_cd == "ANRBS"){
    if(strOfc_cd == "ANRSO"){ //@ 2015.08.03 한진그룹 코드 표준화
        sheetObjects[0].ColHidden("t1sheet1_" + "is_hold") = false;
    }else{
        sheetObjects[0].ColHidden("t1sheet1_" + "is_hold") = true;
    }

    if(strCnt_cd == "US"){
        //1.S/C No. 검색 조건 보여줌.
        //2.Grouping by S/C 버튼 보여줌
        //3.S/C No. 컬럼 보여줌
        //4.IT/Local 검색 조건 보여줌.
        //5.HUB 검색 조건 보여줌.
        search_sc_title.style.visibility = "visible";
        search_sc.style.visibility = "visible";
        ComBtnEnable("btn_group_sc");

        sheetObjects[0].ColHidden("t1sheet1_" + "sc_no") = false;
        sheetObjects[0].ColHidden("t1sheet1_" + "cstms_clr_tp_cd") = false;
        sheetObjects[0].ColHidden("t1sheet1_" + "hub_loc_cd") = false;

    }else{
        search_sc_title.style.visibility = "hidden";
        search_sc.style.visibility = "hidden";
        ComBtnDisable("btn_group_sc");

        sheetObjects[0].ColHidden("t1sheet1_" + "sc_no") = true;
        sheetObjects[0].ColHidden("t1sheet1_" + "cstms_clr_tp_cd") = true;

        sheetObjects[0].ColHidden("t1sheet1_" + "hub_loc_cd") = true;



    }



    if (parAutoSearchFlg == "Y" ) {

        //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        //alert(parSchTp);



        document.getElementById("btn_Retrieve").fireEvent("onclick");

        for ( var idx = 0; idx < formObj.sch_tp.length; idx ++ ) {
            if (formObj.sch_tp[idx].value == parSchTp ){
                formObj.sch_tp[idx].checked = true;
                break;
            }

        }

    }


//헤더 색 변경
//sheetObjects[0].CellBackColor(0,2) = sheetObjects[0].RgbColor(255, 0, 0);
//sheetObjects[0].CellBackColor(0,3) = sheetObjects[0].RgbColor(255, 0, 0);
//sheetObjects[0].CellBackColor(0,4) = sheetObjects[0].RgbColor(255, 128, 0);

	doActionIBSheet(sheetObjects[0],formObj,SEARCH02);
	initRdConfig(rdObjects[0]);
//@ Test Code Start ----------
	
//	formObj.vps_eta_dt_start.value = "20140701";
//	formObj.vps_eta_dt_end.value = "20140701";
//	formObj.pod_cd.value = "KRPUS";
//	document.getElementById("btn_retrieve").fireEvent("onclick");
//	formObj.bl_no.value = "SEL437546200";
//	formObj.sch_tp[2].checked = true;
//@ Test Code End   ----------	
	
	
}


/**
 * registering IBCombo Object as list
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
	comboObjectsMap[combo_obj.id] = combo_obj; 
}


/**
 *  initializing Combo
* @param {object} combo
* @param {String} comboId
 */ 
function initCombo(comboObj, comboId) {
        initComboEditable(comboObj, comboId)
}



function initComboEditable(combo, comboId) {
    with (combo) {
    	if(comboId == "cbo_select_rows" ){
    	}
    }
}


/**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 335;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                //MergeSheet = msHeaderOnly;
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;
                
                var HeadTitle1 = "|Row|Seq.|Sel.|Sel.|Chg Term|Chg|BL No.|TP|S/C No|Code|Customer Name|A/N Sent";
                HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||A/Ntfy #1||A/Ntfy #2||One Time Only";
                HeadTitle1 += "|Result Date";//FAX

                HeadTitle1 += "||CNEE/NTFY||CNEE/NTFY #2||BROKER#1||BROKER#2||A/Ntfy #1||A/Ntfy #2||One Time Only";
                HeadTitle1 += "|Y/N|Doc|Remark";
                HeadTitle1 += "|Hold";
                HeadTitle1 += "|Result Date";//EMAIL
                HeadTitle1 += "|Send ID";

                HeadTitle1 += "|IT \nLocal|HUB|POD|DEL|Type|Term";
                HeadTitle1 += "|A/N Form|Language|Enclose B/L Copy";
                //이하 히든 데이타
                HeadTitle1 += "|usr_nm |bkg_no |an_fom_cd |fax_ntc_snd_rslt_cd1 |fax_ntc_snd_rslt_cd2 |fax_ntc_snd_rslt_cd3 |fax_ntc_snd_rslt_cd4 |fax_ntc_snd_rslt_cd5 |fax_ntc_snd_rslt_cd6 |fax_ntc_snd_rslt_cd7 ";
                HeadTitle1 += "|eml_ntc_snd_rslt_cd1 |eml_ntc_snd_rslt_cd2 |eml_ntc_snd_rslt_cd3 |eml_ntc_snd_rslt_cd4 |eml_ntc_snd_rslt_cd5 |eml_ntc_snd_rslt_cd6 |eml_ntc_snd_rslt_cd7";
                HeadTitle1 += "|fax_snd_flg1 |fax_snd_flg2 |fax_snd_flg3 |fax_snd_flg4 |fax_snd_flg5 |fax_snd_flg6 |fax_snd_flg7 ";
                HeadTitle1 += "|eml_snd_flg1 |eml_snd_flg2 |eml_snd_flg3 |eml_snd_flg4 |eml_snd_flg5 |eml_snd_flg6 |eml_snd_flg7 |file_key |cust_cnt_cd |cust_seq |is_validated |rvis_flg|ts_flg|rd_prt_flg|com_param|mrd_id";

                

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

                var headCount = ComCountHeadTitle(HeadTitle1);
        		//setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
        		InitColumnInfo(headCount, 6, 0, true);
                
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                //해더기능설정(SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D)
                InitHeadMode(true, true, true, true, false,false)

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                //InitHeadRow(1, HeadTitle2, true);

                var prefix = "t1sheet1_";


                //데이터속성      [ROW, COL,  DATATYPE,      WIDTH,      DATAALIGN, COLMERGE, SAVENAME,                  KEYFIELD,    CALCULOGIC, DATAFORMAT,  POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	       daCenter,	true,	prefix + "ibflag");
                InitDataProperty(0, cnt++ , dtDataSeq,		30,		   daCenter,	true,	prefix + "Seq",             false,         "",       dfNone,            0,     false,      false,		0,		false,		false);
                InitDataProperty(0, cnt++ , dtSeq,		    30,		   daCenter,	true,	prefix + "No",              false,         "",       dfNone,            0,     false,      false,		0,		false,		true);
                InitDataProperty(0, cnt++ , dtDummyCheck,	40,		   daCenter,	true,	prefix + "chk_fax",	        false,         "",       dfNone,			0,     true,       true,        -1,     false,      true,"Check");
                InitDataProperty(0, cnt++ , dtDummyCheck,	40,		   daCenter,	true,	prefix + "chk_email",       false,         "",       dfNone,			0,     true,       true,        -1,     false,      true,"Check");
                InitDataProperty(0, cnt++ , dtData,			60,		   daCenter,	true,	prefix + "frt_term_cd",     false,         "",       dfNone,            0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    40,		   daCenter,	true,	prefix + "chg_dp_flg",      false,         "",       dfNone,			0,     true,       true,-1,false,true,"Charge");
                InitDataProperty(0, cnt++ , dtData,			100,	   daCenter,	true,	prefix + "bl_no",		    false,         "",       dfNone,			0,     false,       true);

                InitDataProperty(0, cnt++ , dtData,			30,		   daCenter,	true,	prefix + "bkg_cust_tp_cd",	false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "sc_no",		    false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			80,		   daCenter,	true,	prefix + "cust_cd",			false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			170,	   daLeft,		true,	prefix + "cust_nm",		    false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			80,		   daCenter,	true,	prefix + "an_sent",			false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "fax_evnt_flg1",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no1",			false,          "",      dfNone,			0,     true,       true);

                InitDataProperty(0, cnt++ , dtCheckBox,     20,		   daCenter,	true,	prefix + "fax_evnt_flg2",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no2",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "fax_evnt_flg3",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no3",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "fax_evnt_flg4",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no4",			false,          "",      dfNone,		        0,     true,       true);

                InitDataProperty(0, cnt++ , dtCheckBox,     20,		   daCenter,	true,	prefix + "fax_evnt_flg6",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no6",			false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,     20,		   daCenter,	true,	prefix + "fax_evnt_flg7",	false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no7",			false,          "",      dfNone,			0,     true,       true);

                
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "fax_evnt_flg5",	false,          "",      dfNone,		        0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_no5",			false,          "",      dfNone,		        0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,			90,		   daCenter,	true,	prefix + "fax_snd_dt",		false,          "",      dfNone,		        0,     false,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,  	20,		   daCenter,	true,	prefix + "eml_evnt_flg1",	false,          "",      dfNone,		        0,     true,       true,-1,false,true,"",false);
                                                                                                                                                                        
                InitDataProperty(0, cnt++ , dtData,			90,		   daLeft,		true,	prefix + "ntc_eml1",		false,          "",      dfNone,		        0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "eml_evnt_flg2",	false,          "",      dfNone,		        0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daLeft,		true,	prefix + "ntc_eml2",		false,          "",      dfNone,		        0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		   daCenter,	true,	prefix + "eml_evnt_flg3",	false,          "",      dfNone,		        0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		   daLeft,		true,	prefix + "ntc_eml3",		false,          "",      dfNone,		        0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		  daCenter,		true,	prefix + "eml_evnt_flg4",	     false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		  daLeft,		true,	prefix + "ntc_eml4",		     false,          "",      dfNone,			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		  daCenter,		true,	prefix + "eml_evnt_flg6",	     false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		  daLeft,		true,	prefix + "ntc_eml6",		     false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		  daCenter,		true,	prefix + "eml_evnt_flg7",	     false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		  daLeft,		true,	prefix + "ntc_eml7",		     false,          "",      dfNone,			0,     true,       true);
                
                InitDataProperty(0, cnt++ , dtCheckBox,	    20,		  daCenter,		true,	prefix + "eml_evnt_flg5",	     false,          "",      dfNone,			0,     true,       true,-1,false,true,"",false);
                InitDataProperty(0, cnt++ , dtData,			90,		  daCenter,		true,	prefix + "ntc_eml5",		     false,          "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,		    40,		  daCenter,		true,	prefix + "attach_doc_yn",	     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtPopup,		40,		  daCenter,		true,	prefix + "attach_doc",		     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			400,	  daLeft,		true,	prefix + "diff_rmk",		     false,          "",      dfNone,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtPopup,		50,		  daCenter,		true,	prefix + "is_hold",			     false,          "",      dfNone,			0,     false,       true);
                                                                                                                             
                InitDataProperty(0, cnt++ , dtData,			90,		  daCenter,	    true,	prefix + "eml_snd_dt",		     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			70,		  daCenter,	    true,	prefix + "snd_usr_id",		     false,          "",      dfNone,			0,     false,       true);
                                                                                                                             
                InitDataProperty(0, cnt++ , dtData,			40,		  daCenter,	    true,	prefix + "cstms_clr_tp_cd",	     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			40,		  daCenter,	    true,	prefix + "hub_loc_cd",		     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			45,		  daCenter,	    true,	prefix + "pod_cd",			     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			45,		  daCenter,	    true,	prefix + "del_cd",			     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			40,		  daCenter,	    true,	prefix + "bkg_cgo_tp_cd",	     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtData,			40,		  daCenter,	    true,	prefix + "de_term_cd",		     false,          "",      dfNone,			0,     false,       true);
                                                                                                                             
				InitDataProperty(0, cnt++ , dtCombo,		80,		  daCenter,	    true,	prefix + "arr_prv_fom_cd",       false,          "",      dfNone,           0,     true,        true);
				InitDataProperty(0, cnt++ , dtCombo,		80,		  daCenter,	    true,	prefix + "locl_lang_flg",        false,          "",      dfNone,           0,     true,        true);
				InitDataProperty(0, cnt++ , dtCombo,		100,	  daCenter,	    true,	prefix + "eclz_bl_cpy_flg",      false,          "",      dfNone,           0,     true,        true);
                                                                                                                                                      
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "usr_nm",		         false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "bkg_no",		         false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "an_fom_cd",		     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd1", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd2", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd3", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd4", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd5", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd6", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_ntc_snd_rslt_cd7", false,          "",      dfNone,			0,     false,       true);
                
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd1", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd2", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd3", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd4", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd5", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd6", false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_ntc_snd_rslt_cd7", false,          "",      dfNone,			0,     false,       true);
                
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg1",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg2",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg3",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg4",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg5",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg6",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "fax_snd_flg7",		 false,          "",      dfNone,			0,     false,       true);
                
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg1",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg2",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg3",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg4",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg5",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg6",		 false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "eml_snd_flg7",		 false,          "",      dfNone,			0,     false,       true);
                                                                                    
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "file_key",		     false,          "",      dfNone,			0,     false,       true);
                                                                                                                             
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "cust_cnt_cd",		     false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "cust_seq",		     false,          "",      dfNone,			0,     false,       true);
                                                                                    
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "is_validated",		false,          "",      dfNone,			0,     false,       true);
                InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "rvis_flg",		    false,          "",      dfNone,			0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "ts_flg",		        false,          "",      dfNone,			0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "rd_prt_flg",		    false,          "",      dfNone,			0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "com_param",		    false,          "",      dfNone,			0,     false,       true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		  daCenter,	    true,	prefix + "mrd_id",              false,          "",      dfNone,            0,     true,        true);
				
				
				InitDataCombo(0, prefix + "arr_prv_fom_cd", "General|B/L Form|Notify Letter", "GE|BL|NL");
				InitDataCombo(0, prefix + "locl_lang_flg", "English|Local Language", "N|Y");
				InitDataCombo(0, prefix + "eclz_bl_cpy_flg", "No|Yes", "N|Y");

                //InitUserFormat2(0, prefix + "fax_snd_dt", "####-##-## ##:##", "-|:" );
                //InitUserFormat2(0, prefix + "eml_snd_dt", "####-##-## ##:##", "-|:" );
                InitDataValid(0, prefix + "fax_no1", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no2", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no3", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no4", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no5", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no6", vtNumericOther, "-,");
                InitDataValid(0, prefix + "fax_no7", vtNumericOther, "-,");

				WaitImageVisible = false;


                CountFormat           = "[SELECTDATAROW / TOTALROWS]";
                ShowButtonImage = 2;
                CountPosition = 2;
                AutoRowHeight = false;
                Ellipsis = true;







                }
            break;


    }


}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
    ////sheetObj.ShowDebugMsg = true;
    
    switch(sAction) {

        case IBSEARCH:      //조회



            //alert(sheetObj.id);
            if ( sheetObj.id == "t1sheet1"){


                //헤더행을 제외한 모든 데이터를 지운다.
                formObj.f_cmd.value = SEARCH01;

                //var addParam = "&cust_cnt_cd="+formObj.cust_cnt_cd_ib.value+"&cust_seq="+formObj.cust_seq_ib.value;
                //alert(addParam);
                //formObj.page_no.value = PageNo;
                //alert(validateForm(sheetObj,formObj,sAction));
                //return;

                
                if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);

					var fArgs = new Array("pagerows","f_cmd","vvd","sch_tp","vps_eta_dt_start","vps_eta_dt_end","pod_cd","ts_flg","del_cd","pol_cd"
					,"bl_no","is_validated","frt_term_cd","cust_cnt_cd","cust_seq","cust_nm","cust_ref_no","s_no","c_no"
					,"an_snt_sts","cntc_info_aval","donot_snd_flg", "hub_loc_cd","cstms_loc_cd","entr_tp");
			
                    sheetObj.DoSearch("ESM_BKG_0381GS.do"
                        //,FormQueryString(formObj)
                    	,formToQueryString(formObj,fArgs)
                        + "&"
                        + ComGetPrefixParam("t1sheet1_")
                        );
                }

            }


            break;

        case IBSAVE:        //저장
            if(validateForm(sheetObj,formObj,sAction)){}
                //alert (" Save .. ");
            break;

        case IBINSERT:      // 입력
            break;

        case IBSENDFAX: // fax 전송
            fncSendFaxMulti(sheetObj,formObj);
            break;
        case IBSENDEMAIL: // email 전송
        	//2015.04.03 메일 제목,본문 편집 초기화 - 기본 템플릿 내용으로 발송하기 위함. 
        	formObj.edt_subject.value = "";
        	formObj.edt_contents.value = "";
        	
            fncSendMailMulti(sheetObj,formObj);
            break;
        case "btn_email_edit": // email edit 전송
        	fncSendMailMulti(sheetObj,formObj);
        	//2015.04.03 메일 제목,본문 편집 초기화
        	formObj.edt_subject.value = "";
        	formObj.edt_contents.value = "";

        	break;
        case SEARCH02: //RD MRD_ID 조회
        	formObj.f_cmd.value = SEARCH02;
            var arrXml = sheetObj.GetSearchXml("ESM_BKG_0381GS.do",FormQueryString(formObj));
            
            arrMrdId = ComGetEtcData(arrXml, "MRD_ID").split("|");
            arrComParam = ComGetEtcData(arrXml, "COM_PARAM").split("|");
            arrArrPrvFomCd = ComGetEtcData(arrXml, "ARR_PRV_FOM_CD").split("|");
            
        	break;
    }
}




/**
  * IBTab Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;
}


/**
  * Tab 기본 설정
  * 탭의 항목을 설정한다.
  */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
            with (tabObj) {

                var cnt  = 0 ;
                InsertTab( cnt++ , "Fax" , -1 );
                InsertTab( cnt++ , "E-Mail" , -1 );

                }
            break;

    }
}



/**
  * Tab 클릭시 이벤트 관련
  * 선택한 탭의 요소가 활성화 된다.
  */
function tab1_OnChange(tabObj , nItem)
{

    var objs = document.all.item("tabLayer");
    //alert(nItem);
    var sheetObj = sheetObjects[0];
    var prefix = "t1sheet1_";
    sheetObj.Redraw = false;
    if(nItem == 0){//Fax

        sheetObj.ColHidden(prefix + "chk_fax") = false;
        sheetObj.ColHidden(prefix + "chk_email") = true;

        sheetObj.ColHidden(prefix + "fax_snd_dt") = false;
        sheetObj.ColHidden(prefix + "eml_snd_dt") = true;

        sheetObj.ColHidden(prefix + "fax_evnt_flg1") = false;
        sheetObj.ColHidden(prefix + "fax_no1") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg2") = false;
        sheetObj.ColHidden(prefix + "fax_no2") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg3") = false;
        sheetObj.ColHidden(prefix + "fax_no3") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg4") = false;
        sheetObj.ColHidden(prefix + "fax_no4") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg5") = false;
        sheetObj.ColHidden(prefix + "fax_no5") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg6") = false;
        sheetObj.ColHidden(prefix + "fax_no6") = false;
        sheetObj.ColHidden(prefix + "fax_evnt_flg7") = false;
        sheetObj.ColHidden(prefix + "fax_no7") = false;

        sheetObj.ColHidden(prefix + "eml_evnt_flg1") = true;
        sheetObj.ColHidden(prefix + "ntc_eml1") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg2") = true;
        sheetObj.ColHidden(prefix + "ntc_eml2") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg3") = true;
        sheetObj.ColHidden(prefix + "ntc_eml3") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg4") = true;
        sheetObj.ColHidden(prefix + "ntc_eml4") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg5") = true;
        sheetObj.ColHidden(prefix + "ntc_eml5") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg6") = true;
//        sheetObj.ColHidden(prefix + "eml_chg_flg6") = true;
        sheetObj.ColHidden(prefix + "ntc_eml6") = true;
        sheetObj.ColHidden(prefix + "eml_evnt_flg7") = true;
//        sheetObj.ColHidden(prefix + "eml_chg_flg7") = true;
        sheetObj.ColHidden(prefix + "ntc_eml7") = true;

        sheetObj.ColHidden(prefix + "attach_doc_yn") = true;
        sheetObj.ColHidden(prefix + "attach_doc_clear") = true;
        sheetObj.ColHidden(prefix + "attach_doc") = true;

		ComBtnEnable("btn_fax");
        ComBtnDisable("btn_email");
        ComBtnDisable("btn_email_edit");
        
        //@ 행 선택 콤보 이전 값으로 재 셋팅
//        comboObjectsMap["cbo_select_rows"].Index2 =seletedFaxCboIndex;

    }else if(nItem == 1){//E-Mail

        sheetObj.ColHidden(prefix + "chk_fax") = true;
        sheetObj.ColHidden(prefix + "chk_email") = false;

        sheetObj.ColHidden(prefix + "fax_snd_dt") = true;
        sheetObj.ColHidden(prefix + "eml_snd_dt") = false;

        sheetObj.ColHidden(prefix + "fax_evnt_flg1") = true;
        sheetObj.ColHidden(prefix + "fax_no1") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg2") = true;
        sheetObj.ColHidden(prefix + "fax_no2") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg3") = true;
        sheetObj.ColHidden(prefix + "fax_no3") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg4") = true;
        sheetObj.ColHidden(prefix + "fax_no4") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg5") = true;
        sheetObj.ColHidden(prefix + "fax_no5") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg6") = true;
//        sheetObj.ColHidden(prefix + "fax_chg_flg6") = true;
        sheetObj.ColHidden(prefix + "fax_no6") = true;
        sheetObj.ColHidden(prefix + "fax_evnt_flg7") = true;
//        sheetObj.ColHidden(prefix + "fax_chg_flg7") = true;
        sheetObj.ColHidden(prefix + "fax_no7") = true;

        sheetObj.ColHidden(prefix + "eml_evnt_flg1") = false;
        sheetObj.ColHidden(prefix + "ntc_eml1") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg2") = false;
        sheetObj.ColHidden(prefix + "ntc_eml2") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg3") = false;
        sheetObj.ColHidden(prefix + "ntc_eml3") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg4") = false;
        sheetObj.ColHidden(prefix + "ntc_eml4") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg5") = false;
        sheetObj.ColHidden(prefix + "ntc_eml5") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg6") = false;
//        sheetObj.ColHidden(prefix + "eml_chg_flg6") = false;
        sheetObj.ColHidden(prefix + "ntc_eml6") = false;
        sheetObj.ColHidden(prefix + "eml_evnt_flg7") = false;
//        sheetObj.ColHidden(prefix + "eml_chg_flg7") = false;
        sheetObj.ColHidden(prefix + "ntc_eml7") = false;


        sheetObj.ColHidden(prefix + "attach_doc_yn") = false;
        sheetObj.ColHidden(prefix + "attach_doc_clear") = false;
        sheetObj.ColHidden(prefix + "attach_doc") = false;


        ComBtnDisable("btn_fax");
        ComBtnEnable("btn_email");
        ComBtnEnable("btn_email_edit");

        //@ 행 선택 콤보 이전 값으로 재 셋팅
//        comboObjectsMap["cbo_select_rows"].Index2 =seletedEmailCboIndex;
        
    }
    beforetab = nItem;

    sheetObj.Redraw = true;
    //alert('beforetab' + beforetab);
/*
 * tab layer가 1개이고 sheet column을 show/hide 처리한다.
    objs[nItem].style.display = "Inline";
    objs[beforetab].style.display = "none";

    //--------------- 요기가 중요 --------------------------//
    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
//------------------------------------------------------//
*/


}



/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){

    switch (sAction){
        case IBSEARCH:
            if(!ComChkValid(formObj)) return false;

            if(formObj.sch_tp[0].checked == true) {
                // del또는 pod 둘중 하나는 반드시 입력 되어야 함
                if(formObj.pod_cd.value == "") {
                    ComShowCodeMessage("BKG40115");
                    return false;
                }

                // del는 2또는 5자리만 입력 가능
                if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                    ComShowCodeMessage("BKG40009");
                    ComSetFocus(formObj.del_cd);
                    return false;
                }
            }

            if(formObj.sch_tp[1].checked == true) {
                // del또는 pod 둘중 하나는 반드시 입력 되어야 함
                if(formObj.pod_cd.value == "") {
                    ComShowCodeMessage("BKG40116");
                    return false;
                }
 
                // del는 2또는 5자리만 입력 가능
                if(formObj.del_cd.value.length > 2 && formObj.del_cd.value.length <5) {
                    ComShowCodeMessage("BKG40009");
                    ComSetFocus(formObj.del_cd);
                    return false;
                }

            }


            // Customer Code, S/C No는 하나가 있으면 같이 존재해야 함
            if( formObj.cust_cnt_cd.value.trim() != "" && formObj.cust_seq.value.trim() == "") {
                ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                ComSetFocus(formObj.cust_seq);
                return;
            } else if( formObj.cust_seq.value.trim() != "" && formObj.cust_cnt_cd.value.trim() == "") {
                ComShowCodeMessage("BKG03050","CUSTOMER CODE","CUSTOMER CODE");
                ComSetFocus(formObj.cust_cnt_cd);
                return;
            }

            if( formObj.s_no.value.trim() != "" && formObj.c_no.value.trim() == "") {
                ComShowCodeMessage("BKG03051","S/C No","S/C No");
                ComSetFocus(formObj.c_no);
                return;
            } else if( formObj.c_no.value.trim() != "" && formObj.s_no.value.trim() == "") {
                ComShowCodeMessage("BKG03051","S/C No","S/C No");
                ComSetFocus(formObj.s_no);
                return;
            }

            //alert(ComGetDaysBetween(formObj.vps_eta_dt_start.value,formObj.vps_eta_dt_end.value));

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
/**
	 * 초기화 작업 : 이벤트를 등록한다.
	 * @return
	 */
function initControl() {
    //Axon 이벤트 처리1. 이벤트catch
    axon_event.addListenerForm('click', 'obj_click', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keyup', 'obj_keyup', form );     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm ('blur', 'obj_deactivate', form);
    axon_event.addListenerForm ('activate', 'obj_activate', form);
    axon_event.addListenerFormat('keypress','bkg_keypress',form); //- 키보드 입력할때

    // 화면 초기화 정보등을 입력한다.
    var formObj = document.form;



    if (parPodCd != null && parPodCd != "") {
        formObj.pod_cd.value = parPodCd;
    } else {
        var sPodCd = ComGetCookie("esm_bkg_0381_pod_cd");
        formObj.pod_cd.value = sPodCd;
    }

    if (parVvd != null && parVvd != "") {
        formObj.vvd.value = parVvd;
        formObj.sch_tp[0].checked = true;
        fnToggleSchTp("V", formObj);  // Search type 변경
    }

    if (parDelCd != null && parDelCd != "") {
        formObj.del_cd.value = parDelCd;
    }

    if (parBlNo != null && parBlNo != "") {
        formObj.bl_no.value = parBlNo;
        formObj.sch_tp[2].checked = true;
        fnToggleSchTp("B", formObj);  // Search type 변경
    }
    
    //alert(parEvalFlg);

    for(var k=0;k<formObj.is_validated.options.length;k++){
        if(formObj.is_validated.options[k].value == parEvalFlg){
            formObj.is_validated.options[k].selected = true;
        }
    }


    // calendar 처리
    formObj.vps_eta_dt_start.value=ComGetNowInfo('ymd','-');
    formObj.vps_eta_dt_end.value=ComGetDateAdd(null, 'd', 6, '-');

//formObj.vps_eta_dt_start.value="20080611";
//formObj.vps_eta_dt_end.value="20080611";
//formObj.is_validated.options[k].selected = true;
//formObj.bl_no.value="BOM421402700";
    

}
/**
	 * 해당길이를 채울경우 다음으로 포커스 이동
	 */
function fncNextFocusByMax(srcObj,maxLength,nextObj){

    if(srcObj.value.length == maxLength){
        nextObj.focus();
    }
}


/**
	 * val1컬럼의 값이 있으면 val2컬럼의 체크박스를 체크한다.
	 */
function fncNotNullToYes(sheetObj,Row,val1,val2){
    if(sheetObj.CellValue( Row,"t1sheet1_" + val1) != ""){
        sheetObj.CellValue( Row,"t1sheet1_" + val2) = "Y";
    }
}


/**
 * 화면 개체에 클릭했을 때의 이벤트 처리
 * @return
 */
function obj_click() {

    var objName = event.srcElement.name;
    var formObj = document.form;

    switch(objName) {
        case "vsl_info_set_flg":
            matchUnmatchSetup();
            break;
        case "sch_tp":

            var vSchTp = "";
            for (var i=0; i<formObj.sch_tp.length; i++) {
                if (formObj.sch_tp[i].checked) {
                    vSchTp = formObj.sch_tp[i].value;

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



/**
 * 화면 개체가 변경되었을 때의 이벤트 처리
 * @return
 */
function obj_keyup() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    //var form = document.form;

    // 변경이 일어나면 변경 flag를 true로 변경한다.(여기는 queryStrChange를 위한 if문처럼 사용한다. 다른 이벤트를 처리하기 위해서는 별도 switch문을 사용할 것)
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
        case "s_no":
        case "c_no":
            queryStrChange = true;
            break;
    }
}

/*********************** KEY EVENT START ********************/ 	 
function bkg_keypress(){
    switch(event.srcElement.dataformat){
    	case "num_select":
    		//number
    		ComKeyOnlyNumber(event.srcElement, ",|-");
    		break;            
      	default:
      		break;
    }
}  
/**
  * Form Object가 Deactive될때 발생하는 이벤트를 처리한다.
  * @return
  */
function obj_deactivate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
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
 * Form Object가 Active될때 발생하는 이벤트를 처리한다.
 * @return
 */
function obj_activate(){
    var objName = event.srcElement.name;
    var formObj = document.form;
    //var form = document.form;
    switch(objName) {
        case "vvd":
            formObj.sch_tp[0].checked = true;
            fnToggleSchTp("V", formObj);
            break;

        case "vps_eta_dt_start":
            formObj.sch_tp[1].checked = true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_start.value = formObj.vps_eta_dt_start.value.replace(eval("/-/gi"), "");
            break;
        case "vps_eta_dt_end":
            formObj.sch_tp[1].checked = true;
            fnToggleSchTp("D", formObj);
            formObj.vps_eta_dt_end.value = formObj.vps_eta_dt_end.value.replace(eval("/-/gi"), "");
            break;
        case "bl_no":
            formObj.sch_tp[2].checked = true;
            fnToggleSchTp("B", formObj);
            break;
    }
}


/**
	 * 조회 완료후 실행
	 */
function t1sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    //전체체크
    //sheetObj.CheckAll("t1sheet1_"+"chk_fax") = 1;
    //sheetObj.CheckAll("t1sheet1_"+"chk_email") = 1;

    if(sheetObj.RowCount > 0){
        t1sheet1_OnClick(sheetObj,1,1);
    }

    ComOpenWait(false);
//    setCboSelectRows(sheetObj);
    //@ 데이타 선택 초기화
    form.select_rows.value ="";
}

/*
 * 마우스로 해더를 눌러 소트가 완료되었을 때 발생하는 Event
 * */
function t1sheet1_OnSort(sheetObj, Col, SortArrow) {
}

var clickRow = 0;//선택한 Row 의 번호
var clickBkgNo = "";
var clickCustCntCd = "";
var clickCustSeq = "";
var clickCustNm = "";
var clickScNo = "";
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
	 * 그리드 Click 이벤트 발생후.
	 */
function t1sheet1_OnClick(sheetObj, Row, Col) {

    //전역변수 설정
    clickSheetObj = sheetObj;
    clickRow = Row;
    clickBkgNo = sheetObj.CellValue(Row,"t1sheet1_" + "bkg_no");
    clickCustCntCd = sheetObj.CellValue(Row,"t1sheet1_" + "cust_cnt_cd");
    clickCustSeq = sheetObj.CellValue(Row,"t1sheet1_" + "cust_seq");
    clickCustNm = sheetObj.CellValue(Row,"t1sheet1_" + "cust_nm").split("\r\n").join(" ").split('"').join("'");
    //alert(clickCustNm.replace(eval("/\n/gi"), " "));
    //		alert(clickCustNm.split("\r\n").join(" ").split('"').join("'"));
    clickScNo = sheetObj.CellValue(Row,"t1sheet1_" + "sc_no");

    if(sheetObj.ColSaveName(Col) == "t1sheet1_" + "attach_doc"){
        var returnValue = openUpload("BKG");
        //alert(returnValue);
        document.form.keys.innerText=returnValue;
        if(returnValue != "undefined" && returnValue != ""){
            sheetObj.CellFontColor(Row,"t1sheet1_" + "attach_doc_yn") = sheetObj.RgbColor(255, 0, 0);
            sheetObj.CellValue(Row,"t1sheet1_" + "attach_doc_yn") = "Y (Del)";
            sheetObj.CellValue(Row,"t1sheet1_" + "file_key") = returnValue;
        }
    //alert(returnValue);
    }
    if(sheetObj.ColSaveName(Col) == "t1sheet1_" + "attach_doc_yn"){
        sheetObj.CellValue(Row,"t1sheet1_" + "attach_doc_yn") = "";
        sheetObj.CellValue(Row,"t1sheet1_" + "file_key") = "";
    }
    if(sheetObj.ColSaveName(Col) == "t1sheet1_" + "is_hold"){

        var param = "";
        //clickBkgNo = sheetObj.CellValue(Row,"t1sheet1_" + "bkg_no");

        goUrl = "/hanjin/ESM_BKG_0956.do?";
        if(clickBkgNo == ""){
            //alert("데이터를 선택후 실행하십시오");
            //<7.31>3.1 대상 선택 없이 팝업 버튼 클릭 시 [BKG00149] 메세지 출력 후 작업 중지
            ComShowCodeMessage("BKG00149");
            return;
        }
        param += "1=1";
        //param += "&cust_cnt_cd="+encodeURI(custCntCd3)+"&cust_seq="+encodeURI(custSeq3);
        param += "&bkg_no="+encodeURI(clickBkgNo);
        param += "&pgmNo=ESM_BKG_0956";


        ComOpenWindowCenter(goUrl + param,"ESM_BKG_0956",520,380,true);
    }



}

/**
* Mouse Over 일경우
*/
function t1sheet1_OnMouseMove(sheetObj, button, Shift, X, Y) {

    var Row = sheetObj.MouseRow;
    var Col = sheetObj.MouseCol;
    if(typeof(Col) == "undefined" || typeof(Row) == "undefined"){
        return;
    }

    var colName = "";
    colName = sheetObj.ColSaveName(Col);

    if(colName == "t1sheet1_is_hold"){
        //alert(sheetObj.CellText(Row,"t1sheet1_usr_nm"));
        sheetObj.ToolTipText(Row,Col) = sheetObj.CellText(Row,"t1sheet1_usr_nm");
    }
}

/**
 * seq 에서 포커스를 떠날시
 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
 * @param obj
 * @return
 */
function fncCustSeqBlur(obj){
    var orgV = obj.value;

    if(orgV.length < 1){
        obj.value = "";
    }else{

        obj.value = fncSeqTo6(orgV);

    }

}
/**
 * 숫자를 자동으로 앞에 0을 넣어 6자리로 만들기
 * @param str
 * @return
 */
function fncSeqTo6(str){
    var currentObjLen = str.length;

    var retStr = "";
    for(var i=0;i<6-currentObjLen;i++){
        retStr += "0";
    }
    return retStr + str;
}
/**
* Multi Contact 버튼
* 1044 로 이동
**/

function fncMultiContact(){
    var goUrl = "";
    var param = "";
    goUrl = "/hanjin/ESM_BKG_1044.do?";

    if(clickSheetObj == null){
        ComShowCodeMessage("BKG04007");
        return;
    }

    var sRowStr = clickSheetObj.GetSelectionRows("/");
    var arr = sRowStr.split("/");

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
    +"&cust_nm="+encodeURI(clickCustNm)
    ;
    param += "&pgmNo=ESM_BKG_1044";


    ComOpenWindowCenter(goUrl + param,"ESM_BKG_1044",800,380,true);


}


/**
* 더블클릭 이벤트 발생시
**/
function t1sheet1_OnDblClick(sheetObj, Row, Col, Value){
    var colName = sheetObj.ColSaveName(Col);


    if( colName == "t1sheet1_" + "diff_rmk"){
        sheetObj.CellEditable(Row, colName) = false;
        ComShowMemoPad(sheetObj, Row, colName, false, 200, 100, 200 );
        sheetObj.CellEditable(Row, colName) = true;
    }

    if((colName == "t1sheet1_" + "cust_nm" )){
        if(sheetObj.RowHeight(Row) == 20){
            sheetObj.RowHeight(Row) = 0;
            sheetObj.ColWidth(Col) = 0;

        }else{
            sheetObj.RowHeight(Row) = 20;
            sheetObj.ColWidth(Col)  = 180;

        }
    }



}
/**
* Multi Fax 발송
**/
function fncSendFaxMulti(sheetObj,formObj){

    if(sheetObj.checkedrows("t1sheet1_"+"chk_fax") < 1){
        //Fax만 보낼 수 있는 UI 에서 경고 메세지 :
        //=> BKG40018 : Please select at least one row by mouse click in order to Fax
        ComShowCodeMessage("BKG40018");
        return;
    }

    
    //@ 2015.09.15 E-mail 주소 있으면 E-mail Send 유도 - 한국,싱가폴 제외,  로그인 오피스 : SGNSC, HKGSC 제외
    //@ Also Notify 1,2는 체크하지 않음 2016.01.15 
    if(strCnt_cd != 'KR' && strCnt_cd != 'SG' && strOfc_cd != 'SGNSC' && strOfc_cd != 'HKGSC' ){
    	
	    var checkedRows = sheetObj.FindCheckedRow("t1sheet1_chk_fax");
	    var arrRow = checkedRows.split("|");
	    var rArray = new Array();
	    var emailAnSendSeqs="";
	    var emailAnSendBkgsCnt=0;
	    
	    for (var i = 0; i < arrRow.length -1; i++){
	    	
	        if(    !ComIsNull(sheetObj.CellValue(arrRow[i],"t1sheet1_ntc_eml1")) 
	        	|| !ComIsNull(sheetObj.CellValue(arrRow[i],"t1sheet1_ntc_eml2"))
	        	|| !ComIsNull(sheetObj.CellValue(arrRow[i],"t1sheet1_ntc_eml3"))
	        	|| !ComIsNull(sheetObj.CellValue(arrRow[i],"t1sheet1_ntc_eml4"))
	        	|| !ComIsNull(sheetObj.CellValue(arrRow[i],"t1sheet1_ntc_eml5"))
	           ){
		        	sheetObj.CellValue(arrRow[i],"t1sheet1_chk_fax") = 0;
		        	sheetObj.CellBackColor(arrRow[i],"t1sheet1_No")      = sheetObj.RgbColor(150, 200, 255);
			        sheetObj.CellBackColor(arrRow[i],"t1sheet1_chk_fax") = sheetObj.RgbColor(255, 0, 0);
			        if(emailAnSendBkgsCnt > 0){
			        	emailAnSendSeqs = emailAnSendSeqs +","+ sheetObj.CellValue(arrRow[i],"t1sheet1_No");
			        }else{
			        	emailAnSendSeqs = sheetObj.CellValue(arrRow[i],"t1sheet1_No");
			        }
			        
			        emailAnSendBkgsCnt++;
	        	}else{
	        		sheetObj.CellBackColor(arrRow[i],"t1sheet1_No")      = sheetObj.RgbColor(255, 255, 255);
	        		sheetObj.CellBackColor(arrRow[i],"t1sheet1_chk_fax") = sheetObj.RgbColor(255, 255, 255);
	        	}
	    }
	    
	    if(emailAnSendBkgsCnt > 0){
	    	//msgs['BKG95099'] = "Red display part, please use the E-mail A/N Send function(BKGs:{?msg1})."
	    	if(emailAnSendBkgsCnt > 10){
	    		ComShowCodeMessage("BKG95099",emailAnSendSeqs.substring(0,22)+"...");
	    	}else{
	    		ComShowCodeMessage("BKG95099",emailAnSendSeqs);
	    	}
	    	return;
	    }
	    
    } // end if(strCnt_cd != 'KR' && strCnt_cd != 'SG'){

    if(!ComShowCodeConfirm("BKG40037","Arrival Notice")){
        return;
    }

    //for(var i=1;i<sheetObj.Rows;i++){
    //	if(sheetObj.CellValue(i,"t1sheet1_"+"chk_fax") == "1"){//check 가 되어있을경우
    //		sheetObj.RowStatus(i) = "U";
    //	}else{
    //		sheetObj.RowStatus(i) = "R";
    //	}
    //}
    formObj.f_cmd.value = MULTI01;

    var sParam = FormQueryString(formObj);

    sparam = sParam + "&" + ComGetPrefixParam("t1sheet1_");

    //if(! sheetObj.IsDataModified){
    //	 ComShowCodeMessage('BKG00743');
    //	 return false;
    //}
	sheetObj.WaitImageVisible=false;
	ComOpenWait(true);
    sheetObj.DoSave("ESM_BKG_0381GS.do", sparam, "t1sheet1_"+"chk_fax", false);

}


function fncSendMailMulti(sheetObj,formObj){

    if(sheetObj.checkedrows("t1sheet1_"+"chk_email") < 1){
        //Email만 보낼 수 있는 UI 에서 경고 메세지 :
        //=> BKG40019 : Please select at least one row by mouse click in order to E-mail
        ComShowCodeMessage("BKG40019");
        return;
    }

    if(!ComShowCodeConfirm("BKG40038","Arrival Notice")){
    	//2015.04.03 메일 제목,본문 편집 초기화
    	//@ edit 내용 초기화
    	formObj.edt_subject.value = "";
    	formObj.edt_contents.value = "";
        ComOpenWait(false);

        return;
    }




    //for(var i=1;i<sheetObj.Rows;i++){
    //	if(sheetObj.CellValue(i,"t1sheet1_"+"chk_email") == "1"){
    //		sheetObj.RowStatus(i) = "U";
    //	}else{
    //		sheetObj.RowStatus(i) = "R";
    //	}
    //}
    formObj.f_cmd.value = MULTI02;

    var sParam = FormQueryString(formObj);

    sparam = sParam + "&" + ComGetPrefixParam("t1sheet1_");

    //if(! sheetObj.IsDataModified){
    //	 ComShowCodeMessage('BKG00743');
    //	 return false;
    //}
	sheetObj.WaitImageVisible=false;
	ComOpenWait(true);//progress 보이자
    sheetObj.DoSave("ESM_BKG_0381GS.do", sparam, "t1sheet1_"+"chk_email", false);
}




function t1sheet1_OnChange(sheetObj, Row, Col) {
    var prefix = "t1sheet1_";
    var colName = sheetObj.ColSaveName(Col);
//alert(Col+sheetObj.ColSaveName(Col));
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //하나라도 체크시 앞에 체크박스 체크[FAX]
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    if(beforetab == 0){

        if(colName == prefix + "fax_no1"
            || colName == prefix + "fax_no2"
            || colName == prefix + "fax_no3"
            || colName == prefix + "fax_no4"
            || colName == prefix + "fax_no5"
            || colName == prefix + "fax_no6"
            || colName == prefix + "fax_no7"
            ){

            if(sheetObj.CellValue(Row,Col) != ""){
            	sheetObj.CellValue(Row,Col -1 ) = "1";
            }else{
            	sheetObj.CellValue(Row,Col -1 ) = "0";
            }

        }else if(colName == prefix + "fax_evnt_flg1"
            || colName == prefix + "fax_evnt_flg2"
            || colName == prefix + "fax_evnt_flg3"
            || colName == prefix + "fax_evnt_flg4"
            || colName == prefix + "fax_evnt_flg5"
            || colName == prefix + "fax_evnt_flg6"
            || colName == prefix + "fax_evnt_flg7"
            ){

            for(var x=1;x < 8;x++){
                if(sheetObj.CellValue(Row,prefix + "fax_evnt_flg"+x) == "1"){
                    sheetObj.CellText(Row, prefix + "chk_fax") = "1";
                    break;
                }else{
                    sheetObj.CellText(Row, prefix + "chk_fax") = "0";
                }
            }

            for(var x=1;x < 8;x++){
            	if(colName == prefix + "fax_evnt_flg"+x){
                   	if(sheetObj.CellValue(Row,Col+1) != "" ){
                   		sheetObj.CellValue(Row,Col) = sheetObj.CellValue(Row,Col);
                    }else{
                        sheetObj.CellValue(Row,Col) = "0";
                    }
                }
            }
        }else if(colName == prefix + "chk_fax"){
            if(sheetObj.CellValue(Row, prefix + "chk_fax") == "0"){
                for(var x=1;x < 8;x++){
                    sheetObj.CellText(Row,prefix + "fax_evnt_flg"+x) = "0";
                }
            }else if(sheetObj.CellValue(Row, prefix + "chk_fax") == "1"){
                for(var x=1;x < 8;x++){
                    if(sheetObj.CellText(Row,prefix + "fax_no"+x) != ""){
                        sheetObj.CellText(Row,prefix + "fax_evnt_flg"+x) = "1";
                    }
                }
            }
        }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //하나라도 체크시 앞에 체크박스 체크(EMAIL)
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }else if(beforetab == 1){
        //<8.25>3.2 Email : Focus Out시 Email 포맷에 대한 Valdation 체크 ( 값이 있을 경우만)
        if(colName == prefix + "ntc_eml1"
            || colName == prefix + "ntc_eml2"
            || colName == prefix + "ntc_eml3"
            || colName == prefix + "ntc_eml4"
            || colName == prefix + "ntc_eml5"
            || colName == prefix + "ntc_eml6"
            || colName == prefix + "ntc_eml7"
            ){

            
            if(sheetObj.CellValue(Row,Col) != ""){
            	sheetObj.CellValue(Row,Col -1 ) = "1";
            }else{
           		sheetObj.CellValue(Row,Col -1 ) = "0";
            }
            

            if(sheetObj.CellValue(Row,Col) != ""
                && !ComIsEmailAddr(sheetObj.CellValue(Row,Col))){
                ComShowCodeMessage("BKG40021" , sheetObj.CellValue(Row,Col));
                sheetObj.SelectCell(Row, Col);
                return;
            }

        }else if(colName == prefix + "eml_evnt_flg1"
            || colName == prefix + "eml_evnt_flg2"
            || colName == prefix + "eml_evnt_flg3"
            || colName == prefix + "eml_evnt_flg4"
            || colName == prefix + "eml_evnt_flg5"
            || colName == prefix + "eml_evnt_flg6"
            || colName == prefix + "eml_evnt_flg7"
            ){

            for(var x=1;x < 8;x++){
                if(sheetObj.CellValue(Row,prefix + "eml_evnt_flg"+x) == "1"){
                    sheetObj.CellText(Row, prefix + "chk_email") = "1";
                    break;
                }else{
                    sheetObj.CellText(Row, prefix + "chk_email") = "0";
                }
            }

            for(var x=1;x < 8;x++){
                if(colName == prefix + "eml_evnt_flg"+x){
                   	if(sheetObj.CellValue(Row,Col+1) != "" ){
                   		sheetObj.CellValue(Row,Col) = sheetObj.CellValue(Row,Col);
                    }else{
                        sheetObj.CellValue(Row,Col) = "0";
                    }
                }                
            }


        }else if(colName == prefix + "chk_email"){
            if(sheetObj.CellValue(Row, prefix + "chk_email") == "0"){
                for(var x=1;x < 8;x++){
                    sheetObj.CellText(Row,prefix + "eml_evnt_flg"+x) = "0";
                }
            }else if(sheetObj.CellValue(Row, prefix + "chk_email") == "1"){
                for(var x=1;x < 8;x++){
                    if(sheetObj.CellText(Row,prefix + "ntc_eml"+x) != ""){
                        sheetObj.CellText(Row,prefix + "eml_evnt_flg"+x) = "1";
                    }
                }
            }
        }
    }
    
    if (colName == prefix + "arr_prv_fom_cd") {
    	for (var i=0; i<arrArrPrvFomCd.length; i++) {
    		if (arrArrPrvFomCd[i] == sheetObj.CellValue(Row,Col)) {
    			sheetObj.CellValue2(Row, prefix + "mrd_id") = arrMrdId[i];
    			sheetObj.CellValue2(Row, prefix + "com_param") = arrComParam[i];
    			break;
    		}
    	}
    }
}

function t1sheet1_OnAfterEdit(sheetObj, Row, Col) {
    var prefix = "t1sheet1_";
    var colName = sheetObj.ColSaveName(Col);

    if(beforetab == 0){

        if(colName == prefix + "fax_no1"
            || colName == prefix + "fax_no2"
            || colName == prefix + "fax_no3"
            || colName == prefix + "fax_no4"
            || colName == prefix + "fax_no5"
            || colName == prefix + "fax_no6"
            || colName == prefix + "fax_no7"
            ){

            if(sheetObj.CellValue(Row,Col) != ""){
           		sheetObj.CellValue(Row,Col -1 ) = "1";
            }else{
           		sheetObj.CellValue(Row,Col -1 ) = "0";
            }
        }


    }else if(beforetab == 1){
        if(colName == prefix + "ntc_eml1"
            || colName == prefix + "ntc_eml2"
            || colName == prefix + "ntc_eml3"
            || colName == prefix + "ntc_eml4"
            || colName == prefix + "ntc_eml5"
            || colName == prefix + "ntc_eml6"
            || colName == prefix + "ntc_eml7"
            ){

            if(sheetObj.CellValue(Row,Col) != ""){
           		sheetObj.CellValue(Row,Col -1 ) = "1";
            }else{
           		sheetObj.CellValue(Row,Col -1 ) = "0";
            }
        }



    }
}



function t1sheet1_OnSaveEnd(sheetObj, errMsg){
    ComOpenWait(false);
    //sheetObj.WaitImageVisible = true;

    if(errMsg != ""){
    	sheetObj.CheckAll2("t1sheet1_chk_fax") = 0;
    	sheetObj.CheckAll2("t1sheet1_chk_email") = 0;
	}

}

function pause(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;


    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return;
    }
}

function t1sheet1_OnLoadFinish(sheetObj){
    var formObj = document.form;



}

function formToQueryString(form,arg){
	var retStr = "";
	
		
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
 * Rd Print 설정
 */
function initRdConfig(rdObject) {
	
	var Rdviewer = rdObject;
	Rdviewer.AutoAdjust = true;
	Rdviewer.ViewShowMode(0);
	Rdviewer.IsShowDlg = 0;
	Rdviewer.setbackgroundcolor(128, 128, 128);
	Rdviewer.SetPageLineColor(128, 128, 128);
	Rdviewer.style.height = 0;
}

/**
 * RD 오픈  및  출력
 */
function rdOpen(rdObject) {
	
	var formObj = document.form;

	var chk = "t1sheet1_" + "chk_fax";
	if (tabObjects[0].SelectedIndex == 1) 
		chk = "t1sheet1_" + "chk_email";
	
	var bkgNo;
	var mrdId;
	var loclLangFlg;
	var comParam;
	var chgDpFlg;
	var tsFlg = "N";
	if(formObj.ts_flg.checked) tsFlg = "Y";

	var rdParam;
	with (sheetObjects[0]) {

		if (CheckedRows(chk) == 0) {
			ComShowCodeMessage("BKG00606");
			return;
		}
		ComOpenWait(true);
		for (var i=1; i<RowCount+1; i++) {
			mrdId = CellValue(i,"t1sheet1_" + "mrd_id");
			
			if (CellValue(i, chk) == "1" && mrdId != "") {
				loclLangFlg= CellValue(i,"t1sheet1_" + "locl_lang_flg");
				comParam = CellValue(i,"t1sheet1_" + "com_param");
				chgDpFlg = CellValue(i,"t1sheet1_" + "chg_dp_flg");
				bkgNo = CellValue(i,"t1sheet1_" + "bkg_no");
				
				rdParam = "/rv ";
				rdParam += " form_bkgNo['" + bkgNo + "']";
				rdParam += " form_usrId['" + strUsr_id + "']";
				rdParam += " form_loclFlg['" + loclLangFlg + "']";
				rdParam += " form_chgDpFlg['" + chgDpFlg + "']";
				rdParam += " form_tsFlg['" + tsFlg +"'] ";
				rdParam += " form_remarkCtnt['']";
				rdParam += " form_ofcCd['" + strOfc_cd + "']";
				rdParam += " " + comParam + " /rop /rwait /rallprn /rprintnexit";
                var strPath = RD_path + "apps/alps/esm/bkg/inbounddocumentation/inboundnoticemgt/inboundnotice/report/" + mrdId + ".mrd";
                rdObject.SetPrintInfo(1,1,1,4);
            	rdObject.FileOpen(strPath, RDServer + rdParam);
			}
		}
		ComShowMessage("Print Completed!!");
		ComOpenWait(false);
	}
}

/**
 * 조회 후 처리개수(300)별 선택 가능하도록 콤보 초기화 및 재세팅
 */
var prcUnit   = 300; //처리 단위
function setCboSelectRows(sheetObj){
    var searchRowCnt = sheetObj.RowCount;
    comboObjectsMap["cbo_select_rows"].RemoveAll();
    var sendCnt   = Math.ceil(searchRowCnt/prcUnit);
    var lastIndex = 0;
    var cnt=0;
    comboObjectsMap["cbo_select_rows"].InsertItem(cnt++, "" , "");
    for (var i=0;i<sendCnt;i++) { 

        lastIndex = (i+1)* prcUnit;
        if(lastIndex >= searchRowCnt ){
            lastIndex = searchRowCnt;
        }
        comboObjectsMap["cbo_select_rows"].InsertItem(cnt++, (i*prcUnit +1)+"~"+ lastIndex , (i*prcUnit +1)+","+ lastIndex );
    } 

    
    comboObjectsMap["cbo_select_rows"];
    
    seletedFaxCboIndex   = -1;
    seletedEmailCboIndex = -1;
}
function cbo_select_rows_OnChange(comboObj,value,text){
	var sheetObj = sheetObjectsMap["t1sheet1"];
	var savedColNm;
//	alert(comboObj.Index);
	if(beforetab == 0){
		seletedFaxCboIndex = comboObj.Index;
		savedColNm = "t1sheet1_chk_fax";
		
	}else{
		seletedEmailCboIndex = comboObj.Index;
		savedColNm = "t1sheet1_chk_email";
	}
	
	if(ComIsNull(value)){
	    sheetObj.CheckAll(savedColNm)  = false; //모든 행 체크 해제
		return;
	}
    sheetObj.Redraw = false;
    
    sheetObj.CheckAll(savedColNm)  = false; //모든 행 체크 해제
    
	var valArr = value.split(",");
	var start = new Number(valArr[0]);
	var end = new Number(valArr[1]);
	//  start가 0이 아니고1부터 시작하므로 1을 빼준다. 
	for( var i = start - 1 + sheetObj.HeaderRows; i < sheetObj.HeaderRows + end ; i++){
		sheetObj.CellValue2(i,savedColNm)   = 1;
	}
	
    sheetObj.Redraw = true;
}

/*
 * combo를 선택해서 전송대상을 선택하던 것을 직접입력으로 바꿈. 2014.08.21
 * */
function input_select_rows(){
	var sheetObj = sheetObjectsMap["t1sheet1"];
	var headCount = sheetObj.HeaderRows;
	
	if(ComIsNull(form.select_rows)) return;
	if(sheetObj.RowCount == 0) return;

	
	var savedColNm;
//	alert(comboObj.Index);
	if(beforetab == 0){
		savedColNm = "t1sheet1_chk_fax";
		
	}else{
		savedColNm = "t1sheet1_chk_email";
	}
	
	sheetObj.Redraw = false;
	
	var arrSelectRows = form.select_rows.value.split(",");
	var selectRows;
	var start = 0;
	var end = 0;
    var actualStart;
    var actualEnd;
	var index;
	
	//alert(arrSelectRows.length);
	for(var i=0; i < arrSelectRows.length; i++){
	        if(arrSelectRows[i] == null || arrSelectRows[i] == "") continue; 
	        selectRows = arrSelectRows[i].split("-");
	
	        if(selectRows.length ==1 ){
	            start = Number(selectRows[0]);
	            if(start == 0) {
	            	start = 1;
	            }
	            
	            actualStart = start + headCount -1;
	            
//            	if(gubun == undefined || gubun =="DATASEQ"){
            		index = actualStart;
//            	}else{
//            		index = sheetObj.FindText("t1sheet1_Seq",actualStart);
//            		if(index < 0 ){
//            			continue;
//            		}
//            	}
            	
	            
	            if(sheetObj.CellValue(index,"t1sheet1_is_validated") != "Y"){
	                ComShowCodeMessage("BKG04003");
	                continue;
	            }
	            
				if(sheetObj.CellValue(index,"t1sheet1_rd_prt_flg") == "N"){
                    //alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
                    ComShowCodeMessage("BKG43040");
                    continue;
                }
	            
	            sheetObj.CellValue2(index,savedColNm)   = 1;
	        }else {
	            start = Number(selectRows[0]);
	            end   = Number(selectRows[1]);
	            //@ 시작, 끝이 없을 경우(1,-)
                if(selectRows[0] == "" &&  selectRows[1] =="") continue;
	
                //@ 시작, 끝이 없을 경우(1-,-2)
	            if(selectRows[0] == "") {
	                start = end;
	            }else if(selectRows[1] =="") {
	                end = start;
	            }
	            
	            //@ 1부터 시작하게한다.
	            if(start == 0 ){
	            	start ++;
	            }
	            
	           //@ 1부터 시작하게한다.
	            if(end == 0 ){
	            	end ++;
	            }
	            
	            //@ 시작이 끝보다 클경우 바꾼다.
	            if(start > end){
	            	var temp_start = start;
	            	start = end;
	            	end = temp_start;
	            }
	         
            	//@ 1부터 시작하므로 -1을 한다.
            	actualStart = start + headCount -1;
            	actualEnd   = end   + headCount -1;
	            
	            for(var j= actualStart ; j <= actualEnd ; j++){
	            	//@ 조회 범위를 넘어설 경우 빠져나온다.
	            	if(j > sheetObj.RowCount + headCount){
	            		break;
	            	}
	            	
	            	
//	            	if(gubun == undefined || gubun =="DATASEQ"){
	            		index = j;
//	            	}else{
//	            		index = sheetObj.FindText("t1sheet1_Seq",j);
//	            		if(index < 0){
//	            			continue;
//	            		}
//	            	}
	            	
			            	
	            	if(sheetObj.CellValue(index,"t1sheet1_is_validated") != "Y"){
		                continue;
		            }
	            	
	            	if(sheetObj.CellValue(index,"t1sheet1_rd_prt_flg") == "N"){
	                    //alert("The B/L No doesn't have a VVD to call at Last POD!!  Please mouse-click to the box of T/S option then press [Retrieve] Button again.");
//	                    ComShowCodeMessage("BKG43040");
	                    continue;
	                }
	            	sheetObj.CellValue2(index,savedColNm)   = 1;
	          }//end for j   
	        }// end if
	}//end for i

	sheetObj.Redraw = true;
}
    /* 개발자 작업  끝 */
