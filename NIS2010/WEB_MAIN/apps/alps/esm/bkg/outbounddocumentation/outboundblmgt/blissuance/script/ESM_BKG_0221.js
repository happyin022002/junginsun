/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0221.js
*@FileTitle : Special Cargo Remark
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이병규
*@LastVersion : 1.0
* 2009.06.19 이병규
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
     * @class esm_bkg_0221 : esm_bkg_0221 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0221() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

 // 공통전역변수

 var sheetObjects = new Array();
 var sheetCnt = 0;

 var IBSENDEMAILFAX = "email_fax";
 var por_cd;
 
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_ok":
                    comPopupOK();
                    break;

                case "btn_close":
                    window.close();
                    break;

                case "btn_send":
                    doActionIBSheet(sheetObject,formObject,IBSENDEMAILFAX);
                    break;

            } // end switch
        } catch(e) {
            if ( e == "[object Error]") {
                ComShowCodeMessage("COM12111");
            }
        }
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for (var i=0; i<sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        if ("IBSENDFAX"==document.form2.fax_email.value) {
        	ComEnableObject(document.form.fax,true);
        	ComEnableObject(document.form.email,false);
        	ComClearObject(document.form.email);
        } else if ("IBSENDEMAIL"==document.form2.fax_email.value) {
        	ComEnableObject(document.form.fax,false);
        	ComEnableObject(document.form.email,true);
        	ComClearObject(document.form.fax);
        }
        initControl();
        
		if (document.form.send_hidden.value == "N") {
	        if(!(document.form.strCnt_cd.value == "KR" || document.form.strCnt_cd.value == "VN")){
	        	document.form.fax.disabled = true;
	        }
        }
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

    function initControl() {
	   	if (document.getElementById("ui_id").value == "ESM_BKG_0079_02C") {
	   		document.form.email.value = opener.document.form.eml.value;
	   		ComBtnDisable("btn_ok");
		}
    }

    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        var sheetID = sheetObj.id;
        switch(sheetID) {
            case "sheet1":      //sheet_search
                cnt = 0;
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = 0;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;
                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);
                    var HeadTitle1 = "ibflag|SysCd|TmplMrd|Title|TmplParam|RcvInfo|SndNm|SndEml|Filekey|RcvEml|Contents|Bkg_no|Bl_no|TmplMrdPdf|itr|NtcKndCd";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,      dtStatus,   30,     daCenter,   false,  "ibflag");
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "syscd",        false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "tmplmrd",      false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "title",        false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "tmplparam",    false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "rcvinfo",      false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "sndnm",        false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "sndeml",       false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "filekey",      false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "rcveml",       false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "contents",     false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "bkg_no",       false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "bl_no",        false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "tmplmrdpdf",   false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "itr",          false,  "",  dfNone,    0,  false, false, 0, false, false);
                    InitDataProperty(0, cnt++ ,     dtData,     100,    daLeft,     false,  "ntc_knd_cd",   false,  "",  dfNone,    0,  false, false, 0, false, false);
                    CountPosition = 0;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObject,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
        case IBSEARCH:      //조회
            //formObject.f_cmd.value = SEARCH;
            var sXml = sheetObj.GetSearchXml("ESM_BKG_0221GS.do", FormQueryString(formObject));
            por_cd = ComGetEtcData(sXml,"por_cd");
            break;

        case IBSENDEMAILFAX:        // Fax_Email
            var fax = document.getElementById("fax").value;
            var email = document.getElementById("email").value;
            if (document.getElementById("ui_id").value == "ESM_BKG_0159" ||
 					document.getElementById("ui_id").value == "ESM_BKG_0079_02C" ){
                if (""==document.getElementById("fax").value && ""==document.getElementById("email").value) {
                    ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
                } else {
                    opener.sendFaxEmail(fax, email);
                    window.close();
                }
            } else if (document.getElementById("ui_id").value == "ESM_BKG_0927") {
                if (""==document.getElementById("fax").value && ""==document.getElementById("email").value) {
                    ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
                } else {
                    ParamSet(sheetObj, formObject);
                    //opener.FaxEmailSend(null,null,document.form2.fax_email.value);
                    window.close();
                }
            } else {
                ParamSet(sheetObj, formObject);
            }
            break;
        }
    }

    function ParamSet(sheetObj, formObject) {
        var sheetObject = sheetObjects[0];
        var rdParam = "";
        var strPath = "";
        var strPdf = "";
        var bkg_no         = ComReplaceStr(document.getElementById("bkg_no").value, "|", "','");
        var form_type      = document.getElementById("form_type").value;
        var form_dataOnly  = document.getElementById("form_dataOnly").value;
        var form_manifest  = document.getElementById("form_manifest").value;
        var form_hiddeData = document.getElementById("form_hiddeData").value;
        var form_mainOnly  = document.getElementById("form_mainOnly").value;
        var form_level     = document.getElementById("form_level").value;
        var form_remark    = document.getElementById("form_remark").value;
        var form_Cntr      = document.getElementById("form_Cntr").value;
        var form_CorrNo    = document.getElementById("form_CorrNo").value;
        var form_cntcDtl   = document.getElementById("form_cntcDtl").value;
        var form_his_cntr  = document.getElementById("form_his_cntr").value;
        var form_his_bkg   = document.getElementById("form_his_bkg").value;
        var form_his_mkd   = document.getElementById("form_his_mkd").value;
        var form_his_xpt   = document.getElementById("form_his_xpt").value;
        var form_his_bl    = document.getElementById("form_his_bl").value;
        var rp             = document.getElementById("rp").value;
        var ntc_knd_cd     = document.getElementById("ntc_knd_cd").value;
		form_remark = ComReplaceStr(ComReplaceStr(ComReplaceStr(ComReplaceStr(form_remark,"\'","'||CHR(39)||'"),"\"","'||CHR(34)||'"),"\n","'||CHR(10)||'"),"\r","'||CHR(13)||'");
        if ("BL"==ntc_knd_cd) {
            strPath = "ESM_BKG_0109_DBL.mrd";
			rdParam = "/rv form_bkgNo[( '"+bkg_no+"') ] form_type["+form_type+"] form_dataOnly["+form_dataOnly+"] form_manifest["+form_manifest+"] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData[" + form_hiddeData + "] form_mainOnly["+form_mainOnly+"] form_level[("+form_level+")] form_remark["+form_remark+"] form_Cntr["+form_Cntr+"] form_cntcDtl ["+form_cntcDtl+"] ";
			rdParam += "form_CorrNo[" + form_CorrNo + "] form_his_cntr[" + form_his_cntr + "] form_his_bkg[" + form_his_bkg + "] form_his_mkd[" + form_his_mkd + "] form_his_xpt[" + form_his_xpt + "] form_his_bl[" + form_his_bl + "] /rp [" + rp + "] /riprnmargin" ;
        } else {
        	strPath = "X"==form_manifest || 0==por_cd.indexOf("US") ? "ESM_BKG_0109_OBL_LETTER.mrd":"ESM_BKG_0109_OBL_A4.mrd";
            rdParam = "/rv form_bkgNo[( '"+bkg_no+"') ] form_type["+form_type+"] form_dataOnly["+form_dataOnly+"] form_manifest["+form_manifest+"] form_usrId[" + formObject.strUsr_id.value + "] form_hiddeData["+form_hiddeData+"] form_mainOnly["+form_mainOnly+"] form_level[("+form_level+")] form_remark["+form_remark+"] form_Cntr["+form_Cntr+"] ";
            rdParam += "form_CorrNo[" + form_CorrNo + "] form_his_cntr[" + form_his_cntr + "] form_his_bkg[" + form_his_bkg + "] form_his_mkd[" + form_his_mkd + "] form_his_xpt[" + form_his_xpt + "] form_his_bl[" + form_his_bl + "] /rp [" + rp + "] /riprnmargin" ;
        }
        strPdf = "Original.pdf";
        var Row1 = sheetObject.DataInsert();
        sheetObject.CellValue2(Row1, "bkg_no") = formObject.bkg_no.value;
        sheetObject.CellValue2(Row1, "bl_no") = formObject.bl_no.value;
        sheetObject.CellValue2(Row1, "syscd") = "BKG";
        sheetObject.CellValue2(Row1, "tmplmrd") = strPath;
        sheetObject.CellValue2(Row1, "batchflg") = "N";
        sheetObject.CellValue2(Row1, "tmplparam") = rdParam;
        sheetObject.CellValue2(Row1, "rcvinfo") = formObject.fax.value;
        sheetObject.CellValue2(Row1, "tmplmrdpdf") = strPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
        sheetObject.CellValue2(Row1, "itr") = "|$$|";
        sheetObject.CellValue2(Row1, "ntc_knd_cd") = ntc_knd_cd;

        var Row2 = sheetObject.DataInsert();
        sheetObject.CellValue2(Row2, "bkg_no") = formObject.bkg_no.value;
        sheetObject.CellValue2(Row2, "bl_no") = formObject.bl_no.value;
        sheetObject.CellValue2(Row2, "syscd") = "BKG";
        sheetObject.CellValue2(Row2, "tmplmrd") = strPath;
        sheetObject.CellValue2(Row2, "batchflg") = "N";
        sheetObject.CellValue2(Row2, "tmplparam") = rdParam;
        //sheetObject.CellValue2(Row2, "title") = "B/L Preview"; // 타이틀
        sheetObject.CellValue2(Row2, "contents") = ""; // 메일내용(템플릿메일을위해내용을삭제함:넣으면안됨)
        sheetObject.CellValue2(Row2, "rcveml") = formObject.email.value; // 수신이메일주소
        sheetObject.CellValue2(Row2, "tmplmrdpdf") = strPdf; // 변환될 pdf명(RD파일명 ---> pdf파일명)
        sheetObject.CellValue2(Row2, "itr") = "|$$|";
        sheetObject.CellValue2(Row2, "ntc_knd_cd") = ntc_knd_cd;
        FaxEmailSend(sheetObj, formObject);
    }

    function FaxEmailSend(sheetObj, formObject) {
        if (document.getElementById("fax").value == "" && document.getElementById("email").value == "") {
            ComShowCodeMessage("BKG04006");  //The Fax, E-Mail is invalid
        } else {
            ComOpenWait(true);
            formObject.f_cmd.value = SEARCH01;
            var sXml = sheetObj.GetSaveXml("ESM_BKG_0221GS.do", FormQueryString(formObject) + "&" + sheetObj.GetSaveString());
            ComOpenWait(false);
            if(sXml.substring(1, 6) == "ERROR"){
                ComShowMessage(ComResultMessage(sXml));
            } else {
                var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
                if ( State == "S" ) {
                    var msg = "";
                    if (!ComIsEmpty(document.form2.fax_email)) {
                    	if ("IBSENDFAX"==ComGetObjValue(document.form2.fax_email)) { 
                    		msg += "Fax";
                    	} else if ("IBSENDEMAIL"==ComGetObjValue(document.form2.fax_email)) {
                    		msg += "E-mail";
                    	}
                    } else {
	                    msg += ""!=document.getElementById("fax").value ? "Fax":"";
	                    msg += ""!=msg ? ", ":"";
	                    msg += ""!=document.getElementById("email").value ? "E-mail":"";
                    }
                    ComShowCodeMessage("COM130601",msg);  //{?msg1} was transmitted successfully.
                    window.close();
                }
            }
            sheetObj.RemoveAll();
            return;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }

    // 부모창의 function을 호출
    function comPopupOK() {
        if (!opener) opener = window.dialogArguments;  // 모달창인 경우는 window 객체로부터 opener를 획득
        var formObj2 = document.form2;
        var func     = formObj2.elements["func"    ].value;
        var pop_mode = formObj2.elements["pop_mode"].value;
        var sheetIdx = formObj2.elements["sheetIdx"].value;
        var row      = formObj2.elements["row"     ].value;
        var col      = formObj2.elements["col"     ].value;
        if (""==func) {
            window.close();
            return;
        } else {
            func = eval("opener."+func);
            var item = document.form.getElementsByTagName("input");
            var rArray =  new Array(1);
            rArray[0] = new Array(item.length);
            for (var i=0; i < item.length; i++) {
                if ("text"==item[i].type || "hidden"==item[i].type) {
                    rArray[0][i] = item[i].value;
                }
            }
            try {
                if (""!=row && ""!=col) {
                    if (""!=sheetIdx) {
                        func(rArray,row,col,sheetIdx);
                        window.close();
                    } else {
                        func(rArray,row,col);
                        window.close();
                    }
                } else {
                    func(rArray);
                    window.close();
                }
            } catch(e) {
                ComShowCodeMessage("COM12111");
            }
        }
    }

/* 개발자 작업  끝 */
