/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0451.js
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.16 김상수
* 1.0 Creation
* 2011.09.15 나상보[CHM-201113087] Empty Release/Redelivery Order EDI 전송 신규 추가
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
     * @class EES_CTM_0451 : EES_CTM_0451 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_CTM_0451() {
        this.processButtonClick = tprocessButtonClick;
        this.loadPage = loadPage;
        this.validateForm = validateForm;
    }

/* 개발자 작업 */


// 공통전역변수
var httpRequestXml = ""
var rdObjects = new Array();
var rdCnt = 0;
var opener = window.dialogArguments;    // MODAL창에서 부모창 javascript호출
var opnfrmObj = opener.document.form;
var opnSheetObj0 = opener.sheetObjects[0];
var opnSheetObj1 = opener.sheetObjects[1];


// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;


// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var frmObj = document.form;
        var rdObj = rdObjects[0];

        try {
            var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_print":
                    rdObj.PrintDialog();
                    break;

                case "btn_close":
                    window.close();
                    break;

                case "btn_confirm":
                    if (ComShowCodeConfirm("CTM30006")) {
                        opnSheetObj0.WaitImageVisible = false;
                        opnSheetObj1.WaitImageVisible = false;
                        ComOpenWait(true);
                        /* {issue_flag} I:Issue , R:Reissue , C:cancel */
                        opnfrmObj.issue_flag.value = frmObj.issue_flag.value;

                        /* {issue_type} E: EDI F:FAX , E:EMAIL, P:PRINT */
                        if (frmObj.issue_type[0].checked) {    // PRINT
                            opnfrmObj.issue_type.value = frmObj.issue_type[0].value;
                        	if(ComShowCodeConfirm("CTM30014")){
                        		rdObj.CMPrint();
                        	}

                        } else {
                            if (frmObj.issue_type[1].checked) {    // FAX
                                opnfrmObj.issue_type.value = frmObj.issue_type[1].value;
                                // 부모창 sheet[0]의 첫번째 선택row의 Fax주소를 opnfrmObj.receiver_fax setting
                                opnSheetObj1.Redraw = false;
                                for (var i=1; i<opnSheetObj1.RowCount+1; i++) {
                                    opnSheetObj1.CellValue(i, "fax_no") = opnfrmObj.receiver_fax.value;
                                }
                                opnSheetObj1.Redraw = true;

                            } else if (frmObj.issue_type[2].checked) {    // E-MAIL
                                opnfrmObj.issue_type.value = frmObj.issue_type[2].value;
                                // 부모창 sheet[0]의 첫번째 선택row의 Email주소를 opnfrmObj.receiver_eml에 setting
                                opnSheetObj1.Redraw = false;
                                for (var i=1; i<opnSheetObj1.RowCount+1; i++) {
                                    opnSheetObj1.CellValue(i, "email") = opnfrmObj.receiver_eml.value;
                                }
                                opnSheetObj1.Redraw = true;
                            } else if (frmObj.issue_type[3].checked) {    // EDI
                                opnfrmObj.issue_type.value = frmObj.issue_type[3].value;
                            }
                        }
                        // 부모창에 Value setting
                        var issueFlagText = frmObj.issue_flag[frmObj.issue_flag.selectedIndex].text;
                        opnfrmObj.tmpl_param.value = "/rpaper [A4]  /rp [" + issueFlagText + "]  /rfn [" + RDServerIP + "/EES_CTM_0451_RD.do]";
//ComDebug(opnfrmObj.tmpl_param.value);
//ComDebug(opnfrmObj.rd_content.value);

                        // 부모창의 doActionIBSheet메서드를 호출 (저장 및 Fax/Mail전송)
                        opener.doActionIBSheet(opnSheetObj1, opnfrmObj, MULTI02);
                        ComOpenWait(false);
                        opnSheetObj0.WaitImageVisible = true;
                        opnSheetObj1.WaitImageVisible = true;
                        // 저장 완료후 처리
                        if (opener.sheet2_errMsg == "") {
                            opnSheetObj1.RemoveAll();
                            var pageTitle = "";
                            if (opnfrmObj.type.value == "RDV") {    // Re-Delivery 선택시
                                pageTitle = "Empty Container Redelivery Order";
                            } else {
                                pageTitle = "Empty Container Release Order";
                            }
                            ComShowCodeMessage("CTM30010", pageTitle);
                            window.close();
                            opener.doActionIBSheet(opnSheetObj0, opnfrmObj, IBSEARCH);
                        }
                    }
                    break;
            } // end switch

        } catch(e) {
            if ( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        }
    }


    function loadPage() {
        // OnChange 이벤트 (자체function)
        axon_event.addListener("change", "rdOpen", "issue_flag");

        // 부모창의 issued가 N이라면(최초 이슈라면) 현재창의 selectbox에 새로운 option객체를 새로 추가하고 선택되게 한다.
        //   (RD내부 이미지 숨김처리와 JAVA로직을 "Issue"로 타게하기 위함)
        if (opnfrmObj.issued.value == "N") {
            document.form.issue_flag[3] = new Option("", "I", true, true);
            ComEnableObject(document.form.issue_flag, false);
        }

        // 부모창 sheet[0]의 "Sel" 컬럼이 체크된 데이터를 조회XML로 가져옴 (java에서 데이터 처리를 하기위한 Sort목적)
        var header = "";
        for (var j=0; j <= opnSheetObj0.LastCol; j++) {
            header += (opnSheetObj0.ColSaveName(j) + "|");
        }
        var opnSheet0Xml = ComMakeSearchXml(opnSheetObj0, false, "Sel", header);
        // 부모창 sheet[1]로 조회XML Load
        opnSheetObj1.RemoveAll();
        opnSheetObj1.LoadSearchXml(opnSheet0Xml);
        // 부모창 sheet[1] Sort
        opnSheetObj1.ColumnSort("bkg_no|bl_no|wo_no|tp|shpr|pd_date|mode_cd|vndr_lgl_eng_nm|spcl_inst", "ASC", "", true);

        // 부모창 sheet[0]의 첫번째 선택row의 Fax주소를 opnfrmObj.receiver_fax setting
        opnfrmObj.receiver_fax.value = opnSheetObj0.CellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "fax_no");
        // 부모창 sheet[0]의 첫번째 선택row의 Email주소를 opnfrmObj.receiver_eml에 setting
        opnfrmObj.receiver_eml.value = opnSheetObj0.CellValue(opnSheetObj0.FindCheckedRow("Sel").split("|")[0], "email");

        // HTMLAction.java에서 구분용으로 사용
        opnfrmObj.f_cmd.value = PRINT;

        rdObjects[0].AutoAdjust = true;
        rdObjects[0].ViewShowMode(0);
        rdObjects[0].setbackgroundcolor(128,128,128);
        rdObjects[0].SetPageLineColor(128,128,128);

        var xml = opnSheetObj1.GetSearchXml("EES_CTM_0451_PRV.do", opnSheetObj1.GetSaveString(true, true) + "&" + FormQueryString(opnfrmObj));
        if (ComGetEtcData(xml, "RD") == "undefined") {
            LoadSearchXml(xml);
        } else {
            opnfrmObj.rd_content.value = ComGetEtcData(xml, "RD").trim();
//ComDebug(opnfrmObj.rd_content.value);
            rdOpen();
        }
    }


    /**
     * loadPage() / HTML Object의 OnChange이벤트에서 호출
     */
    function rdOpen() {
        rdObjects[0].SetRData(opnfrmObj.rd_content.value);
        var issueFlagText = document.form.issue_flag[document.form.issue_flag.selectedIndex].text;
        rdObjects[0].FileOpen(RD_path + "rpt/report/EES_CTM_0451.mrd", "/rpaper [A4]  /rp [" + issueFlagText + "]");
    }


/* 개발자 작업 끝 */
