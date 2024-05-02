/*=========================================================
]*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoAcm.js
*@FileTitle  : ACM 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs = new Array();
	}
msgs["ACM00001"]="{?msg1} was {?msg2} successfully.";
msgs["ACM00002"]="Please input covered route of {?msg1} section.";
msgs["ACM00003"]="{?msg1} is invaild. Please check {?msg2} again.";
msgs["ACM00004"]="The effective date of {?msg1}, {?msg2} is duplicated. Please check effective date again.";
msgs["ACM00005"]="Only deleted agreement can be reactivated.";
msgs["ACM00006"]="Selected agreement will be inactivated. Will you proceed?";
msgs["ACM00007"]="The effective start and end date is the same. Please check effective date again.";
msgs["ACM00008"]="The effective date is duplicated to {?msg1}. Please check effective date again.";
msgs["ACM00009"]="The criteria of end date and the next from date should be the same. Please check effective date again.";
msgs["ACM00010"]="Audit for the selected rows will be completed. Are you sure to proceed?";
msgs["ACM00011"]="Audit Success!";
msgs["ACM00012"]="There is no contents to {?msg1}.";
msgs["ACM00013"]="{?msg1} of {?msg2} row is invalid.";
msgs["ACM00014"]="Please check rows to request.";
msgs["ACM00015"]="Please save data first.";
msgs["ACM00016"]="Each CHG consists of maximum of 3 Characters.\n\n (ex:OFT,OTH,DTH)";
msgs["ACM00017"]="{?msg1} is later than {?msg2}. Please check {?msg1} or {?msg2}.";
msgs["ACM00018"]="{?msg1} is earlier than {?msg2}. Please check {?msg1} or {?msg2}.";
msgs["ACM00019"]="{?msg1} row could not be  requested! Because B/L No does not exist.\n\n Please check again.";
msgs["ACM00020"]="There is(are) '{?msg1}' status booking(s). Please exclude '{?msg1}' status booking(s).";
msgs["ACM00021"]="You are requested to designate the proper approval authority prior to Approval Request.";
msgs["ACM00022"]="Please request CS status bookings only!";
msgs["ACM00023"]="Zero commission booking(s) exist(s) due to missing exchange rate. Please exclude zero commission booking(s) first!";
msgs["ACM00024"]="Please select Audited bookings only!";
msgs["ACM00025"]="Bookings before BDR cannot be requested. Please exclude bookings before BDR.";
msgs["ACM00026"]="{?msg1} Items.\n\nDo you want to {?msg2}?";
msgs["ACM00027"]="No ex. rate exits. Please update exchange rate.";
msgs["ACM00028"]="Can't interface. Please check I/F Option.";
msgs["ACM00029"]="A/R center code doesn't exist. Please contact system manager.";
msgs["ACM00029"]="Created BackEndJob File exist already!";
msgs["ACM00030"]="Vendor Code {?msg1} is/are duplicated. Please check Vendor Code again.";
msgs["ACM00031"]="Please check rows to delete.";
msgs["ACM00032"]="Can not copy the Row Data. These is exist only Header";
msgs["ACM00033"]="Group Name [{?msg1}] is duplicated. Please check Group Name again!";
msgs['ACM00034']="{?msg1} is duplicated."
msgs['ACM00035']="Please select {?msg1} bookings only!"
msgs['ACM00036']="Length of {?msg1} must be {?msg2} digit.";

//--------------------------------------------------------//
    /**
     * Form Element의  OnBeforeDeactivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeDeactivate() {
        ComChkObjValid(ComGetEvent());
    }
    /**
     * Form Element의 OnBeforeActivate 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
     */
    function frmObj_OnBeforeActivate() {
        ComClearSeparator(ComGetEvent());
    }
    /**
     * Form Element의 OnKeyPress 이벤트
     * - form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnKeyPress 이벤트에 코드 처리
     */
    function frmObj_OnKeyPress() {
        var obj=ComGetEvent();
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
    function ACMDecideErrXml(shtObj, xmlStr,sheetValue) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
       
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
        	showErrorMsg(xmlStr);
            return true;    // Error일때
        } else {
            return false;
        }
    }
    
    /**
     * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
     *
     * @param {string} shtObj 필수, IBSheet Object
     * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
     * @return {Boorean}
     */
    function ACMDecide2ErrXml(shtObj, xmlStr,sheetValue) {
        if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
        if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
            //shtObj.LoadSearchData(xmlStr,{Sync:1} );
        	ComShowCodeMessage("ACM00003",sheetValue);
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
        if( typeof(xmlStr) == "object" ) xmlStr = xmlStr[0];
        if (ACMDecideErrXml(sheetObjects[0], xmlStr))return false;
        if (codeCol == null || codeCol == "" || textCol == null || textCol == "") return false;
        if (!firstNull || firstNull == null) firstNull == false;
        try {
            // Select Object Clear
            ComClearCombo(selectObj);
            var xmlDoc = ComGetXmlDoc(xmlStr);
            
            var xmlRoot=xmlDoc.documentElement;
            if (xmlRoot == null) return false;
            
            var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
            if (dataNode == null || dataNode.attributes.length < 3) return false;
            var colArr=dataNode.getAttribute("COLORDER").split("|");
            var sep=dataNode.getAttribute("COLSEPARATOR");
            var total=dataNode.getAttribute("TOTAL");
            var dataChildNodes=dataNode.childNodes;
            if (dataChildNodes == null) return false;
            // code/text에 해당하는 컬럼index 추출
            var codeColIdx=0;
            var textColIdx=0;
            for (var i=0; i<colArr.length; i++) {
                if (colArr[i] == codeCol) {
                    codeColIdx=i;
                }
                if (colArr[i] == textCol) {
                    textColIdx=i;
                }
            }
            // firstNull이 true이면 null item생성
            if (firstNull) {
                ComAddComboItem(selectObj, "", "");
                selectObj.options[0].selected=true;
            }
            // 컬럼index로  code/text 내용추출
            for (var i=0; i<dataChildNodes.length; i++) {
                if (dataChildNodes[i].nodeType != 1) continue;
                var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
                // Select Object에 item생성
                ComAddComboItem(selectObj, arrData[textColIdx], arrData[codeColIdx]);
            }
            // 첫번째 항목 선택
            if (selectObj.options.length > 0) {
                selectObj.options[0].selected=true;
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
    function ACMMemoSheet_InitSheet(shtObj, width) {
        with(shtObj){
          //var iWidth = document.getElementById(shtObj.id.toString() + "_td").offsetWidth-10;
          var HeadTitle="STS|Value";
          SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:0, SizeMode:0 } );

          var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:0, Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                       {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"value" } ];
           
          InitColumns(cols);


          SetEditable(1);
          SetColProperty(0 ,"value" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
          SetWaitImageVisible(0);
          SetCountPosition(0);
          SetRowHidden(0,1);
          SetDataRowHeight(24);  // 추가 **************
          SetSheetHeight(25,1);  // 수정 *****************
          //SetSheetWidth(iWidth);
          SetSheetWidth(width);
          
       }
       ACMMemoSheet_OnLoadFinish(shtObj);
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
    	shtObj.RenderSheet(0);
        for (var i=1; i<51; i++) {
        	shtObj.DataInsert(-1);
        }
            //SetRowHidden(0,true);
        shtObj.RenderSheet(1);
        var divObj=document.getElementById(shtObj.id.toString() + "_div");
        var tdObj = document.getElementById(shtObj.id.toString() + "_td");
        divObj.style.top="3px";
        
        //divObj.style.posTop=(divObj.offsetTop+100) +"px";
        //divObj.style.posLeft=tdObj.offsetLeft +"px" ;
        //document.getElementById(shtObj.id.toString() + "_td").style.position="absolute";
        // sheet의 변경여부 flag를 담을 hidden태그 생성
      var spanTag=document.createElement("span");
        spanTag.id=(shtObj.id.toString() + "_change");
        spanTag.textContent = "N";
        spanTag.style.display="none";
        document.body.appendChild(spanTag);
    }
    function memo_sheet1_OnChange(shtObj) {
        var myElement =document.getElementById(shtObj.id.toString() + "_change");
        //var myText = (myElement.innerText || myElement.textContent);
        //myText="Y";
        myElement.textContent = "Y";
    }
    function memo_sheet2_OnChange(shtObj) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
        //var myText = (myElement.innerText || myElement.textContent);
        //myText="Y";
    	myElement.textContent = "Y";
    }
    function memo_sheet3_OnChange(shtObj) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
        //var myText = (myElement.innerText || myElement.textContent);
        //myText="Y";
    	myElement.textContent = "Y";
    }
    function memo_sheet4_OnChange(shtObj) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
        //var myText = (myElement.innerText || myElement.textContent);
        //myText="Y";
    	myElement.textContent = "Y";
    }
    function memo_sheet5_OnChange(shtObj) {
    	var myElement =document.getElementById(shtObj.id.toString() + "_change");
        //var myText = (myElement.innerText || myElement.textContent);
        //myText="Y";
    	myElement.textContent = "Y";
    }

    /**
     * Memo Sheet용 IBSheet의 사이즈 확대
     * @param {object} Sheet Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_Open(shtObj) {
    	document.getElementById(shtObj.id.toString() + "_td").style.position="relative";
    	document.getElementById(shtObj.id.toString() + "_div").style.position="absolute";
        document.getElementById(shtObj.id.toString() + "_div").style.zIndex=999;
        with (shtObj) {
        	shtObj.SetVisible(1);
        	shtObj.SetSheetHeight(185);
            //ScrollBar=2;
            // 포커스 직후 편집 모드
        	shtObj.SetFocusEditMode(0);
            // 첫째행에 focus
            //SelectCell(1, "value", false);
        	shtObj.SetSheetWidth(shtObj.GetSheetWidth());
        }
    }
    /**
     * Memo Sheet용 IBSheet의 사이즈 줄임 및 SQL param 생성
     * @param {object} Sheet Object 필수
     * @param {object} Form Element Object 필수
     * @return 없음.
     */
    function ACMMemoSheet_Close(shtObj, frmElmt) {
    	if (shtObj.GetSheetHeight() > 25) {
            shtObj.SetSheetHeight(25,1)
            document.getElementById(shtObj.id.toString() + "_div").style.position="static";
            document.getElementById(shtObj.id.toString() + "_div").style.zIndex=0;
            //shtObj.SetSheetHeight(ComGetSheetHeight(shtObj,2));    		
    	}
      
        var myElement =document.getElementById(shtObj.id.toString() + "_change");
        if (!myElement) return;
        //var myText = (myElement.innerText || myElement.textContent);
        var myText = myElement.textContent;
        if (myText != "Y") return;
        var screenNo=location.pathname.substring(location.pathname.lastIndexOf("_") + 1, location.pathname.lastIndexOf("."));

        // sheet에서 내용 추출하고 빈 row는 삭제
        var bfrRows=shtObj.RowCount();
        var tempArray=new Array();
        var vvdDiv=false;
        var delRows = "";
        // Multi VVD일때는 10자리로 substring
        if (frmElmt.name == "vvd_cd") vvdDiv=true;
        //shtObj.RenderSheet(0);
        for (var i=shtObj.LastRow() ; i >=shtObj.HeaderRows() ; i--) {
        	if (shtObj.GetCellValue(i, "value") != "") {
                if (vvdDiv) {
                	tempArray[tempArray.length]=shtObj.GetCellValue(i, "value").substring(0, 10);
                } else {
                	tempArray[tempArray.length]=shtObj.GetCellValue(i, "value");
                }
            } else {
            	delRows =delRows+ i+"|";
            	//shtObj.RowDelete(i, 0);
            }
        }
        //shtObj.RenderSheet(1);
        // form의 input에 setting
        if (tempArray.length > 0) {
            frmElmt.value=("'" + ComReplaceStr(tempArray.toString(), ",", "', '") + "'");
            // Multi B/L No일때는 UI상의 date_fm와 date_to의 required를 해제. ESM_ACM_0030, ESM_ACM_0031일때는 적용하지 않음
            if (frmElmt.name == "bl_no" && document.form.date_fm == "[object]" && document.form.date_to == "[object]" && screenNo != "0030" && screenNo != "0031") {
                document.form.date_fm.className="input";
                document.form.date_fm.removeAttribute("required");
                document.form.date_to.className="input";
                document.form.date_to.removeAttribute("required");
            }
        } else {
            frmElmt.value="";
            if (frmElmt.name == "bl_no" && document.form.date_fm == "[object]" && document.form.date_to == "[object]" && screenNo != "0030" && screenNo != "0031") {
                document.form.date_fm.className="input1";
                document.form.date_fm.setAttribute("required", "");
                document.form.date_to.className="input1";
                document.form.date_to.setAttribute("required", "");
            }
        }
        // sheet에 모자란 row만큼 새로 insert
        shtObj.RenderSheet(0);
        if( delRows != ""){
        	shtObj.RowDelete(delRows.substring(0, delRows.length-1), 0);
        }
        for (var k=(shtObj.RowCount()+1); k<=bfrRows; k++) {
        	shtObj.DataInsert(-1);
        }
        shtObj.RenderSheet(1);
        // 첫째행에 focus
        //shtObj.SelectCell(1, "value", false);

        // ESM_ACM_0012일때만 ESM_ACM_0012내의 메서드 호출
        if (screenNo == "0012") {
            frmObj_OnChange();
        }
        //myText="N";
        myElement.textContent = "N";
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
        var tmpStartNo=parseInt(ComGetUnMaskedValue(startObj.value, "int"));
        var tmpEndNo=parseInt(ComGetUnMaskedValue(endObj.value, "int"));
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
                var startRowIdx=(tmpStartNo - 1) + HeaderRows();
                var endRowIdx=(LastRow()< (tmpEndNo - 1) + HeaderRows()? LastRow(): (tmpEndNo - 1) + HeaderRows());
                shtObj.RenderSheet(0);
                for (var i=startRowIdx; i<=endRowIdx; i++) {
                    SetCellValue(i, "chk", chkVal);
                }
                shtObj.RenderSheet(1);
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
        var tempArray=new Array();
        if (startRowIdx == undefined || startRowIdx == null || startRowIdx == "") startRowIdx=0;
        for (var i=startRowIdx; i<chkElmt.length; i++) {
            if (chkElmt[i].checked) {
                tempArray[tempArray.length]=chkElmt[i].value;
            }
        }
        // form의 input에 setting
        if (tempArray.length > 0) {
            HdnElmt.value=("'" + ComReplaceStr(tempArray.toString(), ",", "', '") + "'");
        } else {
            HdnElmt.value="";
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
        if (shtObj.RowCount()< 1) return;
        if (startRowIdx == null || startRowIdx == "") startRowIdx=shtObj.GetTopRow();
        if (endRowIdx == null || endRowIdx == "") endRowIdx=shtObj.LastRow();
        shtObj.RenderSheet(0);
        for (var i=startRowIdx; i<=endRowIdx; i++) {
            for (var k=shtObj.SaveNameCol(startColNm); k<=shtObj.SaveNameCol(endColNm); k++) {
                shtObj.SetCellEditable(i, k,editMode);
            }
        }
        shtObj.RenderSheet(1);
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
            var trnsRowArr=FindStatusRow("I|D").split(";");
            if (trnsRowArr.length > 0) {
                for (var i=0; i<trnsRowArr.length; i++) {
                	if (GetCellValue(trnsRowArr[i] , 0)== "I") {
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
