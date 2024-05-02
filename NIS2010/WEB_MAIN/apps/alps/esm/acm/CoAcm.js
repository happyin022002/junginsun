/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CoAcm.js
 *@FileTitle :
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.03.05
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2012.03.05 김상수
 * 1.0 Creation
 * 2013.05.28 박다은 [CHM-201324688] Audit 버튼 클릭은 RS만 되고 Audit Reject는 AS만 되게 수정
 * 2014.06.27 박다은 [CHM-201430726] Audit / CSR 생성 시 건수 제한 로직 추가 요청
=========================================================*/
msgs["ACM00001"] = "{?msg1} was {?msg2} successfully.";
msgs["ACM00002"] = "Please input covered route of {?msg1} section.";
msgs["ACM00003"] = "{?msg1} is invaild. Please check {?msg2} again.";
msgs["ACM00004"] = "The effective date of {?msg1}, {?msg2} is duplicated. Please check effective date again.";
msgs["ACM00005"] = "Only deleted agreement can be reactivated.";
msgs["ACM00006"] = "Selected agreement will be inactivated. Will you proceed?";
msgs["ACM00007"] = "The effective start and end date is the same. Please check effective date again.";
msgs["ACM00008"] = "The effective date is duplicated to {?msg1}. Please check effective date again.";
msgs["ACM00009"] = "The criteria of end date and the next from date should be the same. Please check effective date again.";
msgs["ACM00010"] = "Audit for the selected rows will be completed. Are you sure to proceed?";
msgs["ACM00011"] = "Audit Success!";
msgs["ACM00012"] = "There is no contents to {?msg1}.";
msgs["ACM00013"] = "{?msg1} of {?msg2} row is invalid."; 
msgs["ACM00014"] = "Please check rows to request.";
msgs["ACM00015"] = "Please save data first.";
msgs["ACM00016"] = "Each CHG consists of maximum of 3 Characters.\n\n (ex:OFT,OTH,DTH)";
msgs["ACM00017"] = "{?msg1} is later than {?msg2}. Please check {?msg1} or {?msg2}.";
msgs["ACM00018"] = "{?msg1} is earlier than {?msg2}. Please check {?msg1} or {?msg2}.";
msgs["ACM00019"] = "{?msg1} row could not be  requested! Because B/L No does not exist.\n\n Please check again.";
msgs["ACM00020"] = "There is(are) '{?msg1}' status booking(s). Please exclude '{?msg1}' status booking(s).";
msgs["ACM00021"] = "You are requested to designate the proper approval authority prior to Approval Request.";
msgs["ACM00022"] = "Please request CS status bookings only!";
msgs["ACM00023"] = "Zero commission booking(s) exist(s). Please exclude zero commission booking(s) first!";
msgs["ACM00024"] = "Please select Audited bookings only!";
msgs["ACM00025"] = "Bookings before BDR cannot be requested. Please exclude bookings before BDR.";
msgs["ACM00026"] = "{?msg1} Items.\n\nDo you want to {?msg2}?";
msgs["ACM00027"] = "No ex. rate exits. Please update exchange rate.";
msgs["ACM00028"] = "Can't interface. Please check I/F Option.";
msgs["ACM00029"] = "A/R center code doesn't exist. Please contact system manager.";
msgs["ACM00030"] = "Created BackEndJob File exist already!";
msgs["ACM00031"] = "Please select Requested bookings only!";
msgs["ACM00032"] = "{?msg2} of {?msg1} should be equal to or less than {?msg3}.";

msgs["ACM00033"] = "No data found.";
msgs["ACM00034"] = "The CSR is less than $ 100,000.\n Do you want to use the ALPS Approval System?";
msgs["ACM00035"] = "Retrieve Button available After the Clear Button Click";
msgs["ACM00036"] = "'512694' code can not be requested along with other code.";
msgs["ACM00037"] = "{?msg1} row should be recalculated instead of inputting Ex. Rate!\nEx. rate of charge commission cannot be updated by 'Ex. Rate Input' function.\n\nPlease check again.";
msgs["ACM00038"] = "The surcharge {?msg1} cannot be rated per B/L.";
msgs["ACM00039"] = "Please select only the same type."
	
//--------------------------------------------------------//


    /**
     * Form Element의  OnBeforeDeactivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeDeactivate() {
        ComChkObjValid(window.event.srcElement);
    }


    /**
     * Form Element의 OnBeforeActivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeActivate() {
        ComClearSeparator(window.event.srcElement);
    }


    /**
     * Form Element의 OnKeyPress 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
     */
    function frmObj_OnKeyPress() {
        var obj = window.event.srcElement;
        if (obj.dataformat == null) return;

        switch (obj.dataformat) {
            case "ymd":
            case "ym":
            case "hms":
            case "hm":
            case "jumin":
            case "saupja":
                ComKeyOnlyNumber(obj);
                break;

            case "int":
                ComKeyOnlyNumber(obj, "-");
                break;

            case "float":
                ComKeyOnlyNumber(obj, "-.");
                break;

            case "eng":
                ComKeyOnlyAlphabet("num", "32|64|~");
                break;

            case "engup":
                ComKeyOnlyAlphabet("uppernum");
                break;

            case "engdn":
                ComKeyOnlyAlphabet("lowernum");
                break;
        }
    }


    /**
     * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @return {Boorean}
     */
    function ACMDecideErrXml(shtObj, xmlStr) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
            shtObj.LoadSearchXml(xmlStr);
            return true;    // Error일때
        } else {
            return false;
        }
    }


    /**
     * IBSheet의 GetSearchXml함수를 통해 가져온 XML데이터를
     * HTML Input Select Object의 option으로 insert
     *
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @param {object} Select Object 필수, insert하고자 하는 HTML Input Select Object.
     * @param {string} textCol 필수, xmlStr 중 Text컬럼명.
     * @param {string} codeCol 필수, xmlStr 중 Code컬럼명.
     * @param {boolean} firstNull 선택, 첫번째 Item에 Null Item 생성여부
     * @return {boolean} Select Object의 option생성 실패시 false return.
     */
    function ACMXml2SelectItem(xmlStr, selectObj, textCol, codeCol, firstNull) {
        if (xmlStr == null || xmlStr == "" || selectObj == null || selectObj == "") return false;
        if (ACMDecideErrXml(sheetObjects[0], xmlStr))return false;
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") return false;
        if (!firstNull || firstNull == null) firstNull == false;

        try {
            // Select Object Clear
            ComClearCombo(selectObj);

            var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.loadXML(xmlStr);

            var xmlRoot = xmlDoc.documentElement;
            if (xmlRoot == null) return false;

            var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) return false;

            var colArr = dataNode.getAttribute("COLORDER").split("|");
            var sep = dataNode.getAttribute("COLSEPARATOR");
            var total = dataNode.getAttribute("TOTAL");

            var dataChildNodes = dataNode.childNodes;
            if (dataChildNodes == null) return false;

            // code/text에 해당하는 컬럼index 추출
            var codeColIdx = 0;
            var textColIdx = 0;
            for (var i=0; i<colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    codeColIdx = i;
                }
                if (colArr[i] == textCol) {
                    textColIdx = i;
                }
            }

            // firstNull이 true이면 null item생성
            if (firstNull) {
                ComAddComboItem(selectObj, "", "");
                selectObj.options[0].selected = true;
            }
            // 컬럼index로  code/text 내용추출
            for (var i=0; i<dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) continue;
                var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                // Select Object에 item생성
                ComAddComboItem(selectObj, arrData[textColIdx], arrData[codeColIdx]);
            }
            // 첫번째 항목 선택
            if (selectObj.options.length > 0) {
                selectObj.options[0].selected = true;
            }
            return true;

        } catch (err) {
            ComFuncErrMsg(err.message);
        }
    }


    /**
     * Memo Sheet용 IBSheet의 Initialize
     * @param {object} Sheet Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_InitSheet(shtObj) {
        with (shtObj) {
            var cnt = 0;
            // 높이 설정
            style.height = 20;

            // 전체 너비 설정
            SheetWidth = (shtObj.id.toString() + "_td").clientWidth;

            // Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

            // 전체Edit 허용 여부 [선택, Default false]
            Editable = true;

            // 행정보설정[필수][HEADROWS, DATAROWS, VIEWROWS, ONEPAGEROWS=500]
            InitRowInfo(0, 1, 1, 500);

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(false, false, false, false, false, false);

            // 헤더에서 처리할 수 있는 각종 기능을 설정 [정렬, 컬럼이동, 전체체크, 컬럼너비변경, 좌측헤더이동, 셀입체]
            InitHeadMode(true, true, false, true, false, false);

            // 컬럼 헤더타이틀
            var HeadTitle  = "STS|Value";

            // 컬럼정보설정[필수][COLS, FROZENCOL, LEFTHEADCOLS=0, FROZENMOVE=false]
            InitColumnInfo(ComCountHeadTitle(HeadTitle), 0, 0, false);

            // 헤더행정보[필수][ROW, HEADTEXT, ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);

            // Enter키를 눌렀을때
            EditEnterBehavior = "tab";

            DataAutoTrim = true;

            // 시트의 외곽선 색상을 설정
            SheetOutLineColor = WebColor("#7F9DB9");    // input기본 css와 동일하게 설정

            // 시트 전체의 글자체
//            SheetFontName = "Tahoma";    // input기본 css와 동일하게 설정

            // 시트 전체의 글자크기
//            SheetFontSize = 10;    // input기본 css와 동일하게 설정

            // 헤더 행 높이
            HeadRowHeight = 18;

            // 데이터 행의 기본 행 높이
            DataRowHeight = 18;

            // input기본 css와 동일하게 설정
            DataFontColor = WebColor("#606060");

            // 데이터 셀들 사이의 선 종류
            GridLine = glFlatHorz;

            // 안쪽선색
            InLineColor = WebColor("#7F9DB9");

            // 선택된 행의 포커스 모양
            FocusStyle = 0;

            // Edit 가능한 셀에 포커스가 들어갔을 때 Edit를 시작할지 여부
            FocusEditMode = 2;

            // 스크롤 바 (최초 없음)
            ScrollBar = 0;

            // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++, dtHiddenStatus, 40,     daCenter,    true,    "ibflag");    // [필수]
            InitDataProperty(0, cnt++, dtData,         40,     daLeft,      true,    "value");

            // 입력제한
            InitDataValid(0, "value" , vtEngUpOther, "1234567890");    // 영대문자+숫자만

            WaitImageVisible = false;
            CountPosition = 0;
        }
    }


     function memo_sheet1_OnLoadFinish(shtObj) {
         ACMMemoSheet_OnLoadFinish(shtObj);
     }


     function memo_sheet2_OnLoadFinish(shtObj) {
         ACMMemoSheet_OnLoadFinish(shtObj);
     }


     function memo_sheet3_OnLoadFinish(shtObj) {
         ACMMemoSheet_OnLoadFinish(shtObj);
     }


     function memo_sheet4_OnLoadFinish(shtObj) {
         ACMMemoSheet_OnLoadFinish(shtObj);
     }


     function memo_sheet5_OnLoadFinish(shtObj) {
         ACMMemoSheet_OnLoadFinish(shtObj);
     }


    /**
     * Memo Sheet용 IBSheet의 Initialize
     * @param {object} Sheet Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_OnLoadFinish(shtObj) {
        with (shtObj) {
            ReDraw = false;
            for (var i=1; i<51; i++) {
                DataInsert();
            }
            RowHidden(0) = true;
            ReDraw = true;
        }
        var divObj = document.getElementById(shtObj.id.toString() + "_div");
        var tdObj = document.getElementById(shtObj.id.toString() + "_td");
        divObj.style.posTop = tdObj.getBoundingClientRect().top + 1;
        divObj.style.posLeft = tdObj.getBoundingClientRect().left;
        divObj.style.position = "absolute";

        // sheet의 변경여부 flag를 담을 hidden태그 생성
        var spanTag = document.createElement("span");
        spanTag.id = (shtObj.id.toString() + "_change");
        spanTag.innerText = "N";
        spanTag.style.display = "none";
        document.body.appendChild(spanTag);
    }



    function memo_sheet1_OnChange(shtObj) {
        document.getElementById(shtObj.id.toString() + "_change").innerText = "Y";
    }

    function memo_sheet2_OnChange(shtObj) {
        document.getElementById(shtObj.id.toString() + "_change").innerText = "Y";
    }

    function memo_sheet3_OnChange(shtObj) {
        document.getElementById(shtObj.id.toString() + "_change").innerText = "Y";
    }

    function memo_sheet4_OnChange(shtObj) {
        document.getElementById(shtObj.id.toString() + "_change").innerText = "Y";
    }

    function memo_sheet5_OnChange(shtObj) {
        document.getElementById(shtObj.id.toString() + "_change").innerText = "Y";
    }



    function memo_sheet1_OnMouseDown(shtObj) {
       // 다른 Memo Sheet가 열려있을때 현재 Sheet로 focus가 발생해도 닫히지 않는 부분 보완
       if (shtObj.ScrollBar == 0) {
           // 임시로 생성한 hidden태그에 강제로 onclick이벤트 발생
           document.getElementById(shtObj.id.toString() + "_change").fireEvent("onclick");
           // 다시 첫째행에 focus
           shtObj.SelectCell(0, "value");
       }
    }

    function memo_sheet2_OnMouseDown(shtObj) {
       if (shtObj.ScrollBar == 0) {
           document.getElementById(shtObj.id.toString() + "_change").fireEvent("onclick");
           shtObj.SelectCell(0, "value");
       }
    }

    function memo_sheet3_OnMouseDown(shtObj) {
       if (shtObj.ScrollBar == 0) {
           document.getElementById(shtObj.id.toString() + "_change").fireEvent("onclick");
           shtObj.SelectCell(0, "value");
       }
    }

    function memo_sheet4_OnMouseDown(shtObj) {
       if (shtObj.ScrollBar == 0) {
           document.getElementById(shtObj.id.toString() + "_change").fireEvent("onclick");
           shtObj.SelectCell(0, "value");
       }
    }

    function memo_sheet5_OnMouseDown(shtObj) {
       if (shtObj.ScrollBar == 0) {
           document.getElementById(shtObj.id.toString() + "_change").fireEvent("onclick");
           shtObj.SelectCell(0, "value");
       }
    }


    /**
     * Memo Sheet용 IBSheet의 사이즈 확대
     * @param {object} Sheet Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_Open(shtObj) {
        document.getElementById(shtObj.id.toString() + "_div").style.zIndex = 100;
        with (shtObj) {
            style.height = GetSheetHeight(7);
            ScrollBar = 2;
            // 선택된 행의 하이라이트
            SelectHighLight = true;
            // 포커스 직후 편집 모드
            FocusEditMode = 0;
            // 첫째행에 focus
            SelectCell(1, "value", false);
        }
    }


    /**
     * Memo Sheet용 IBSheet의 사이즈 줄임 및 SQL param 생성
     * @param {object} Sheet Object 필수
     * @param {object} Form Element Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_Close(shtObj, frmElmt) {
        document.getElementById(shtObj.id.toString() + "_div").style.zIndex = 0;
        shtObj.style.height = shtObj.GetSheetHeight(1);
        shtObj.ScrollBar = 0;
        // 선택된 행의 하이라이트
        shtObj.SelectHighLight = false;
        // 포커스 직후 편집 모드
        shtObj.FocusEditMode = 2;
        // 변경된 내용이 없으면 return
        if (document.getElementById(shtObj.id.toString() + "_change").innerText != "Y") return;

        var screenNo = location.pathname.substring(location.pathname.lastIndexOf("_") + 1, location.pathname.lastIndexOf("."));

        with (shtObj) {
            ReDraw = false;
            // sheet에서 내용 추출하고 빈 row는 삭제
            var bfrRows = RowCount;
            var tempArray = new Array();
            var vvdDiv = false;
            // Multi VVD일때는 9자리로 substring
            if (frmElmt.name == "vvd_cd") vvdDiv = true;
            for (var i=HeaderRows; i<=LastRow; i++) {
                if (CellValue(i, "value") != "") {
                    if (vvdDiv) {
                        tempArray[tempArray.length] = CellValue(i, "value").substring(0, 9);
                    } else {
                        tempArray[tempArray.length] = CellValue(i, "value");
                    }
                } else {
                    RowDelete(i, false);
                    i--;    // RowDelete후 row index 감소
                }
            }

            // form의 input에 setting
            if (tempArray.length > 0) {
                frmElmt.value = ("'" + ComReplaceStr(tempArray.toString(), ",", "', '") + "'");
                // Multi B/L No일때는 UI상의 date_fm와 date_to의 required를 해제. ESM_ACM_0030, ESM_ACM_0031일때는 적용하지 않음
                if (frmElmt.name == "bl_no" && document.form.date_fm == "[object]" && document.form.date_to == "[object]" && screenNo != "0030" && screenNo != "0031") {
                    document.form.date_fm.className = "input";
                    document.form.date_fm.removeAttribute("required");
                    document.form.date_to.className = "input";
                    document.form.date_to.removeAttribute("required");
                }
            } else {
                frmElmt.value = "";
                if (frmElmt.name == "bl_no" && document.form.date_fm == "[object]" && document.form.date_to == "[object]" && screenNo != "0030" && screenNo != "0031") {
                    document.form.date_fm.className = "input1";
                    document.form.date_fm.setAttribute("required", "");
                    document.form.date_to.className = "input1";
                    document.form.date_to.setAttribute("required", "");
                }
            }

            // sheet에 모자란 row만큼 새로 insert
            for (var k=(RowCount+1); k<=bfrRows; k++) {
                DataInsert(-1);
            }
            // 첫째행에 focus
            SelectCell(1, "value", false);
            ReDraw = true;
        }
        // ESM_ACM_0012일때만 ESM_ACM_0012내의 메서드 호출
        if (screenNo == "0012") {
            frmObj_OnChange();
        }

        document.getElementById(shtObj.id.toString() + "_change").innerText = "N";
    }


    /**
     * 화면에서 Start Row No.와 End Row No.를 입력하여 여러 Row Check박스에 Check/UnCheck
     * @param {object} Sheet Object 필수
     * @param {object} Start Row No.를 입력받는 Form Element Object 필수
     * @param {object} End Row No.를 입력받는 Form Element Object 필수
     * @param {int} "chk"컬럼에 CellValue로 입력할 값 0/1
     * @return 없음.
     */
    function ACMMultiRowCheck(shtObj, startObj, endObj, chkVal) {
        if(startObj.value == "") {
            ComShowCodeMessage("COM130201", "start row No.");    // Please input {?msg1}.
            ComSetFocus(startObj);
            return;
        } else if (endObj.value == "") {
            ComShowCodeMessage("COM130201", "end row No.");    // Please input {?msg1}.
            ComSetFocus(endObj);
            return;
        }

        var tmpStartNo = parseInt(ComGetUnMaskedValue(startObj.value, "int"));
        var tmpEndNo = parseInt(ComGetUnMaskedValue(endObj.value, "int"));
        if (tmpStartNo < 1) {
            ComShowCodeMessage("COM130201", "number 0 over");    // Please input {?msg1}.
            ComSetFocus(startObj);
            return;
        } else if (tmpEndNo < 1) {
            ComShowCodeMessage("COM130201", "number 0 over");    // Please input {?msg1}.
            ComSetFocus(endObj);
            return;
        } else if (tmpStartNo > tmpEndNo) {
            ComShowCodeMessage("COM12133", "End row No.", "start row No" ,"greater ");    // {?msg1} must be {?msg3} than {?msg2}.
            ComSetFocus(startObj);
            return;
        } else {
            with (shtObj) {
                var startRowIdx = (tmpStartNo - 1) + HeaderRows;
                var endRowIdx = (LastRow < (tmpEndNo - 1) + HeaderRows ? LastRow : (tmpEndNo - 1) + HeaderRows);
                ReDraw = false;
                for (var i=startRowIdx; i<=endRowIdx; i++) {
                    Cellvalue(i, "chk") = chkVal;
                }
                ReDraw = true;
            }
        }
    }


    /**
     * Form의 CheckBox를 클릭했을때 체크된 값만 지정된 Hidden input에 setting
     * @param {object} Form Element CheckBox Object 필수
     * @param {object} Form Element Hidden Object 필수
     * @param {int} startRowIdx 선택, Start Row Index
     * @return 없음.
     */
    function ACMCheckBox_OnClick(chkElmt, HdnElmt, startRowIdx) {
        var tempArray = new Array();
        if (startRowIdx == undefined || startRowIdx == null || startRowIdx == "") startRowIdx = 0;
        for (var i=startRowIdx; i<chkElmt.length; i++) {
            if (chkElmt[i].checked) {
                tempArray[tempArray.length] = chkElmt[i].value;
            }
        }
        // form의 input에 setting
        if (tempArray.length > 0) {
            HdnElmt.value = ("'" + ComReplaceStr(tempArray.toString(), ",", "', '") + "'");
        } else {
            HdnElmt.value = "";
        }
    }


    /**
     * IBSheet에 시작Col과 끝Col을 지정하여 Editable속성을 일괄 변경
     * (행단위 Editable 변경을 shtObj.RowEditable사용 할 것)
     * @param {object} shtObj 필수, 해당 IBSheet Object
     * @param {String} startColNm 필수, Start Col SaveName
     * @param {String} endColNm 필수, End Col SaveName
     * @param {Boolean} editMode 필수, Editable Value
     * @param {int} startRowIdx 선택, Start Row Index
     * @param {int} endRowIdx 선택, End Row Index
     */
    function ACMCellEditable(shtObj, startColNm, endColNm, editMode, startRowIdx, endRowIdx) {
        if (shtObj == null || shtObj == "" || startColNm == null || startColNm == "" || endColNm == null || endColNm == "" || editMode == null) return;
        if (shtObj.RowCount < 1) return;
        if (startRowIdx == null || startRowIdx == "") startRowIdx = shtObj.TopRow;
        if (endRowIdx == null || endRowIdx == "") endRowIdx = shtObj.LastRow;

        shtObj.ReDraw = false;
        for (var i=startRowIdx; i<=endRowIdx; i++) {
            for (var k=shtObj.SaveNameCol(startColNm); k<=shtObj.SaveNameCol(endColNm); k++) {
                shtObj.CellEditable(i, k) = editMode;
            }
        }
        shtObj.ReDraw = true;
    }


    /**
     * IBSheet의 Check가 Radio Check일때 체크되지 않은 다른 row들에 대한 처리
     * (행단위 Editable 변경을 shtObj.RowEditable사용 할 것)
     * @param {object} shtObj 필수, 해당 IBSheet Object
     * @param {String} Row 필수, 해당 IBSheet내의 "chk"된 row
     */
    function ACMRadioChkAction(shtObj, Row) {
        if (shtObj == null || shtObj == "" || Row == null || Row == "") return;
        with (shtObj) {
            // 현재 Check된 RowStatus가 "U"일때, 다른 row의 RowStatus가 "I"면 삭제 "D"는 초기화
            var trnsRowArr = FindStatusRow("I|D").split(";");
            if (trnsRowArr.length > 1) {
                for (var i=0; i<trnsRowArr.length-1; i++) {
                    if (RowStatus(trnsRowArr[i]) == "I") {
                        RowDelete(trnsRowArr[i], false);
                    } else {
                        ReturnData(trnsRowArr[i]);
                    }
                }
                // RowDelete되었을 경우 한 row씩 당겨지므로, 선택 row를 Check row와 동기화
                SelectCell(FindCheckedRow("chk").split("|")[0], 0, false);
            }
        }
    }

    
	/**
	 * 4000바이트 이상 입력되면 에러가 발생한다.
	 * To_CLOB 사용하여 문제를 해결한다.
	 *
	 * @param {string} src 조회대상, 필수
	 * @param {number} cnt 묶음 개수 , default = 1
	 * @param {string} 델리미터, default = ","
	 * @param {string} before_str 묶음 앞 문자 default = "to_clob("
	 * @param {string} after_str  묶음 뒤 문자 default = ")"
	 * @return String
	 */
	function getToClobString(src, cnt, del_str ,before_str, after_str) {
		if( src == null) return "";
		
		if(before_str == null || before_str =="") before_str = "to_clob(";
		if(after_str == null  || after_str  =="") after_str  = ")";
		if(cnt == null  || eval(cnt) == 0 ) cnt = 1;
		if(del_str == null  || del_str =="" ) del_str = ",";
		
		if (typeof(src) =="string")
			return getArrayToClobString(src.split(del_str), cnt, before_str, after_str,del_str);
		else if (typeof(src) =="object")
			return getArrayToClobString(src, cnt, before_str, after_str,del_str);
	}

	//getToClobString 내부 메소드
	function getArrayToClobString(src, cnt, before_str, after_str,del_str) {

		var result_str = "";
		var real_cnt = 1;
		for (var i = 0; i < src.length ; i++) {

			if(src[i] == null  || src[i] =="") continue;

			// 시작부분
			if( cnt == 1 || real_cnt%cnt == 1) {
				//연결부분
				if(real_cnt != 1 ) {
					result_str += "||";
				}
				result_str += before_str+"'";
			}
			//데이타 부분
			result_str += ComTrim(src[i]);

			if(i != src.length -1) {
				result_str += del_str;
			}
			//마감부분
			if(cnt == 1 || (real_cnt != 1 && real_cnt%cnt == 0) ) {
				result_str += "'"+after_str;
			}

			real_cnt++;
		}
		
		//최종 마감부분
		if(cnt != 1 && (real_cnt-1)%cnt !=0)  {
			result_str += "'"+after_str;
		}

		return result_str;
	}

	/**
	 * Agreement File popup
	 * @param v_csr_no
	 * @param ifStatus
	 * @param tpCd
	 */
	function openPopupAgmtFiles(v_csr_no, ifStatus, tpCd) {
/*
		var height = screen.height; 
		var width = screen.width;

		var w = 800;
		var h = 370;
		var leftpos = width/2 - w/2; 
		var toppos = height/2 - h/2; 
		if (leftpos < 0) leftpos = 0;
		if (toppos < 0) toppos = 0;
*/
		var tabStatus = "";
		var readOnly = "";

		if (tpCd == "GW") {
			tabStatus = "1|0|1";
		} else {
			tabStatus = "1|1|1";
		}

		if (ifStatus == "Requesting Approval") {
			readOnly = "N";
		} else {
			readOnly = "Y";
		}

		var url = "/hanjin/COM_CSR_0023.do?csr_no=" + v_csr_no + "&tabStatus=" + tabStatus + "&readOnly=" + readOnly;
		ComOpenPopup(url, 1020, 580, "", "none", true);
//		window.open(url, "stepPop", "status=no, width=" + w + ", height=" + h + ", resizable=no, scrollbars=no, left=" + leftpos + ", top=" + toppos); 
	}

	
	function AcmXmlToArray(xmlStr) {
		var rtnArr = new Array();

		if (xmlStr == null || xmlStr == "") {
			return;
		}

		try {
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.loadXML(xmlStr);

			var xmlRoot = xmlDoc.documentElement;
			if (xmlRoot == null) {
				return;
			}

			var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
			if (dataNode == null || dataNode.attributes.length < 3) {
				return;
			}

			var col = dataNode.getAttribute("COLORDER");
			var colArr = col.split("|");
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var total = dataNode.getAttribute("TOTAL");

			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}

			var retStr = "";
			for ( var i = 0; i < dataChildNodes.length; i++) {
				
				
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var rowObj = new Object();
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				for( var j = 0; j < colArr.length; j++){
					rowObj[colArr[j]] = arrData[j];
				}
				rtnArr.push(rowObj);
			}
		} catch (err) {
			ComFuncErrMsg(err.message);
		}

		return rtnArr;
	}
	
    /**
     * IBSheet에 특정 컬럼이 체크된 데이터행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * 부모창에서 팝업으로 창을 열때 체크된 데이터 또는 모든 데이터행을 팝업창의 IBSheet로 넘기기위해 사용한다. <br>
     * 또는 왼쪽IBSheet에서 오른쪽IBSheet로 데이터를 이동할때도 사용할 수 있다. <br>
     * bRowDel인자를 true로 설정하면 XML생성에 대상이된 행을 삭제처리까지 할수 있다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = AcmMakeSearchCommaXml(sheetObj, false, "chkBox","trd_cd|rlane_cd|dir_cd");
     * </pre>
     * @param {ibsheet} 	sheet_obj   필수,IBSheet Object ID
     * @param {bool}    	allSave     필수,sheet 전체를 xml string으로 만들지 여부[true/false]
     * @param {int,string}	col     	필수,대상이 되는 기준 컬럼의 인덱스 또는 SaveName[체크박스형태]
     * @param {string}  	saveColName 필수,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     * @param {bool}    	bRowDel     선택,대상행삭제여부, default=false
     * @return string,Sheet의 데이터를 조회XML로 구성한 문자열
     */
     function AcmMakeSearchCommaXml(sheet_obj, allSave, col, saveColName, bRowDel)  {
         try {
             //함수 인자 유효성 확인
             if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
                 ComShowMessage("ComMakeSearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
                 return "";
             }

             var allXml = "";
             var sColSep = "^|^";
             var sColOrder = "";
             if (saveColName!=undefined && saveColName != null && saveColName!="") {
                 sColOrder = " COLORDER='" + saveColName + "' ";
             }

             allXml = "<?xml version='1.0'  ?>\n"
                    + "<SHEET>\n"
             if(allSave){
                 allXml += "  <DATA TOTAL='"+ sheet_obj.TotalRows + "' " + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";

                 var aryTR  = new Array(sheet_obj.LastRow - sheet_obj.HeaderRows);
                 var aryTD = new Array(sheet_obj.LastCol);

                 for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
                     for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
                         //TD-셀의 값을 변수에 저장한다.
                         aryTD[ic] = String(sheet_obj.CellValue(ir,ic));
                     }
                     aryTR[ir-sheet_obj.HeaderRows] = "    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>";
                 }
                 if (bRowDel) sheet_obj.RemoveAll();

                 allXml += aryTR.join("\n");
             }else{
                 allXml += "  <DATA" + sColOrder + " COLSEPARATOR='"+sColSep+"'>\n";
                 if(col != ""){
                     var findRows = sheet_obj.FindCheckedRow(col);
                     if(findRows != ""){
                         findRows = findRows.substring(0, findRows.length-1); //맨끝의 "|"제거
                         var arrRow = findRows.split("|");
                         var arrCol = saveColName.split("|");

                         var aryTR  = new Array(arrRow.length);
                         var aryTD = new Array();
                         for(var ir = 0; ir<arrRow.length; ir++){
                       	 	 var icp = 0;
                             for(var ic = 0; ic<arrCol.length; ic++){
                                 //TD-셀의 값을 변수에 저장한다.
                                 aryTD[icp] = String(sheet_obj.CellValue(arrRow[ir], arrCol[ic]));
                                 icp++;
                             }
                         }
                         
                         var arrCommaRow = new Array(arrCol.length);
                         for(var icc = 0; icc<aryTD.length; icc++){
                        	 arrCommaRow[icc] = aryTD[icc].split(",");
                         }
                         
                         var aryTDValue = new Array(aryTD.length);
                         for(var irr = 0; irr<arrCommaRow[58].length; irr++){
                        	 
                        	 for(var irc = 0; irc<aryTD.length; irc++){
                        		 aryTDValue[irc] = arrCommaRow[irc][irr];
                             }
                        	 
                        	 aryTR[irr] = "    <TR><![CDATA[" + aryTDValue.join(sColSep)+ "]]></TR>";
                         }
                         
                         if (bRowDel) {
                         	sheet_obj.Redraw = false;
                         	sheet_obj.RedrawSum = false;
                             for(var ir = arrRow.length-1; ir>=0; ir--){
                                 sheet_obj.RowDelete(arrRow[ir],false);
                             }
                         	sheet_obj.RedrawSum = true;
                         	sheet_obj.Redraw = true;
                         }
                         allXml += aryTR.join("\n");
                     }
                 }
             }
             allXml += "  </DATA>\n"
                    +  "</SHEET>";

             return allXml;
         } catch(err) { ComFuncErrMsg(err.message); }
     }     	