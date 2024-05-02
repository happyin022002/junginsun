/**
 * ===============================================================================
 * 프로그램 명 : DOD 공통 자바스크립트 프로그램개요 : DOD모듈내 공통 메시지 및 스크립트 함수를 정의한다. 작 성 자 : 작 성 일 :
 * 2015-11-02
 * ===============================================================================
 * 수정자/수정일 : 수정사유/내역 :
 * ===============================================================================
 * History
 */
// *************** DOD START ***************//
msgs['DOD00001'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['DOD00002'] = 'Please select a row.';
msgs['DOD00003'] = 'Do you want to continue?';
msgs['DOD00004'] = 'Discount Error.';
msgs['DOD00005'] = 'At least one row needs to be selected.';
msgs['DOD00006'] = 'function processButtonClick Object Error';
msgs['DOD00007'] = 'From date must be earlier than To date';
msgs['DOD00008'] = "The period cannot exceed [{?msg1}] days.";
msgs['DOD00009'] = "Tariff comfirmed.";
msgs['DOD00010'] = "You must input either S/C No or RFA No.";
msgs['DOD00011'] = "Please fill in required field.";
msgs['DOD00012'] = "Successfuly saved.";
msgs['DOD00013'] = "Please select only one row."
msgs['DOD00014'] = 'Data format is wrong.  Please enter a valid format. {?msg1}';
msgs['DOD00015'] = 'Unexpected system error occurred during data processing';
msgs['DOD00016'] = 'There is no Tariff!';
msgs['DOD00017'] = 'A/R I/F Success!';
msgs['DOD00018'] = 'A/R I/F Fail!';
msgs['DOD00019'] = 'Date format is wrong.  Please enter a valid date format. [{?msg1}]';
msgs['DOD00020'] = 'Amount must be greater than 0.';
msgs['DOD00021'] = 'Invalid [{?msg1}]';
msgs['DOD00022'] = 'Please select only one [{?msg1}]';
msgs['DOD00023'] = 'AR Invoice Issue?';
msgs['DOD00024'] = 'INV CUST does not exist';
msgs['DOD00025'] = 'Access Denied.';
msgs['DOD00026'] = "Please select  {?msg1}.";
msgs['DOD00027'] = "There is no data to save.";
msgs['DOD00028'] = "Invalid previous I/F";

// DOD BACK END JOB MESSAGE 
msgs['DOD10001'] = 'BackEndJob Request Fail!';
msgs['DOD10002'] = 'It was already created. Please check it again.';

msgs['DOD20001'] = '{?msg1} is Invalid!';

/**
 * 멀티입력 팝업 메서드
 * 
 * @param {String } input_obj 값을 리턴받을 form element명
 */
function rep_Multiful_inquiry(input_obj, title) {
	var formObject = document.form;
	var cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var rep_cmdt_cd_val = ""; // 향후 사용가능 예정변수
	var cmdt_desc_val = ""; // 향후 사용가능 예정변수
	var classId = "DOD_MULTI";
	var xx1 = input_obj; // CONTI
	var xx2 = ""; // SUB CONTI
	var xx3 = ""; // COUNTRY
	var xx4 = ""; // STATE
	var xx5 = ""; // CONTROL OFFIC
	var xx6 = ""; // LOC CODE
	var xx7 = ""; // LOC NAME
	var xx8 = "";
	var xx9 = "";
	var xx10 = "";

	if (title == undefined) {
		xx10 = "";
	} else {
		xx10 = title;
	}

	var param = "?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
			+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
			+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9
			+ "&returntitle=" + xx10;
	ComOpenPopup('/hanjin/EES_DOD_0014.do' + param, 412, 400, '',
			'1,0,1,1,1,1,1,1,1,1,1,1');
}

/**
 * rep_Multiful_inquiry의 리턴처리 메서드
 * 
 * @param {Array} rowArray 반환되는 Array
 * @param {String} return_val 반환되는 form element명 
 */
function getDOD_Return(rowArray, return_val) {
	var formObj = document.form;
	var tempText = "";
	// 초기화
	eval("document.form." + return_val + ".value = '';");

	for (var i = 0; i < rowArray.length; i++) {
		tempText += rowArray[i] + ',';
	}
	// 마지막에 ,를 없애기 위함
	tempText = EasDelLastDelim(tempText);

	eval("document.form." + return_val + ".value = '" + tempText + "';");
}

/**
 * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
 * 
 * @param {String} str 제거 대상 String
 * @return {String} str 제거된 String
 */
function EasDelLastDelim(str) {
	// 마지막에 &를 없애기 위함
	if (str != "") {
		str = str.substr(0, str.length - 1);
	}
	return str;
}
/**
 * location 조회에 따른 yard LIST를 가져온다.(예: a1|a2|a3|a4)
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardList(sheetObj, formObject, value)
{
    sheetObj.WaitImageVisible  = false;
	formObject.f_cmd.value = SEARCH01;
	var queryString = "searchStr="+value+"&"+FormQueryString(formObject);
	sheetObj.DoRowSearch("ESD_TRS_0079GS.do", queryString);
    sheetObj.WaitImageVisible  = true;
	return sheetObj.EtcData('nod');
}

/**
 * yard list를 combo에 설정한다.
 * @param comboObj - 설정될 combo객체
 * @param sheetObj - sheet객체
 * @param formObject - 검색조건이 되는 form 객체
 * @param value - 조회조건 location값
 **/
function getYardCombo(comboObj, sheetObj, formObject, value)
{
	var yardList = getYardList(sheetObj, formObject, value);
	var yardArray = new Array();
	yardArray = yardList.split("|");
	comboObj.RemoveAll();
	if(yardArray.length == 1 && yardArray[0] == ""){
		return yardArray;
	}
	for(var i=0, j=0; i<yardArray.length; i++)
	{	
		if(i == 0){
			comboObj.InsertItem(0 , 'ALL','');
			comboObj.Index = 0;			
		}		
		j = i + 1;
		comboObj.InsertItem(j, yardArray[i], yardArray[i]);
	}
	return yardList;
}

/**
 * ��臾몄옄濡� 諛붽씀�뒗 �븿�닔.
 */
function setgetUpper(obj) {
	return obj.value = obj.value.toUpperCase()
}

/**
 * sep에 해당하는 char를 제거하는 스크립트
 */
function doSepRemove(obj, sep) {
	var ch = "";
	var lvobj = "";
	for(var i=0; i<obj.length; i++) {
		if(obj.charAt(i) == sep) {
			ch = "";
		} else {
			ch = obj.charAt(i);
		}
		lvobj = lvobj + ch;
	}
	return lvobj;
}

/**
 * 영문과 숫자에 대한 유효성을 체크.
 */
function doengnumcheck(obj) {
	var lveng = /[^a-z|A-Z|,|0-9|]/;
	if( lveng.test(obj) ) {
		ComShowMessage(ComGetMsg('COM12127','This field'));
		return false;
	}
	return true;
}

/**
 * DOD Common 숫자만 사용
 * 
 * @param {Object}	obj			Object
 * @param {String}	isChkFmt	Format Check 할지 여부(Y/N)
 * @param {String}	int_str		integer String
 **/
function dod_isNumD(obj, isChkFmt, int_str){
	if (isChkFmt==undefined || isChkFmt==null || isChkFmt.trim()==''){
		// 단순히 숫자와 '-'만 허용
		if (!ComIsNumber(obj, "-")){obj.value = '';
		}
	} else if (isChkFmt!=undefined && isChkFmt!=null && isChkFmt=='Y'){
		var int_char = (int_str!=undefined&&int_str!=null&int_str.trim()!=''?int_str.trim():'-');
		var src = obj.value;
		for (var i=0; src!=null && i<src.length; i++){
			if ((i!=4 && i!=7 && !ComIsNumber(src.charAt(i))) || ((i==4 || i==7) && !ComIsNumber(src.charAt(i), "-"))){
				src = src.substring(0,i) + src.substring(i+1,src.length);
			} else {
				if ((i==4 || i==7) && (src.charAt(i)!=int_char)){
					src = src.substring(0,i) + int_char + src.substring(i,src.length);
				}
			}
		}
		obj.value = src;
	}
	return true;
}

/**
 * [Period] 유효성 체크
 * @param {string]	obj		날짜
 * @return
 */
function dod_validateDateObj(obj) {
	if (obj.readOnly == true) {
		return false;
	}
	obj.value = obj.value.trim();
	if (obj.value == null || obj.value.trim() == '') {
		return false;
	}

	if (!dod_checkPeriodFormat(obj.value) || !dod_isValidDateObject(obj.value,'-')){
		ComShowCodeMessage("COM12132");
		obj.focus();
		return false;
	}

	return true;
}


/**
 * Period 형식 체크
 * @param {string}	obj	날짜
 * @return
 */
function dod_checkPeriodFormat(obj) {
	var date_regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;
	if (!dod_checkFormat2(obj, date_regexp)) {
		return false;
	} else {
		return true;
	}
}

/**
 * DOD Common Check Format.<br>  
 * 사용예:  regexp = /(^\d{4}\-\d{2}\-\d{2}$)/;.<br.
 * 
 * @param {String}	src		Source String
 * @param {String}	regexp	정규표현식
 **/
function dod_checkFormat2(src, regexp){
	if (src==null || src=='' || regexp==null || regexp==''){return false;}
	result = (regexp.test(src));
	if (!result){return false;
	} else {return true;
	}
}

/**
 * DOD Common Check Format  .<br>
 * 사용예:  regexp = "^(\\d{4}-\\d{2}-\\d{2})$";.<br>
 * 
 * @param {String}	src		Source String
 * @param {String}	regexp	정규표현식
 **/
function dod_checkFormat(src, regexp){
	if (src==null || src=='' || regexp==null || regexp==''){return false;}
	re = new RegExp(regexp,"gi");
	if (!re.test(src)){return false;
	} else {return true;
	}
}

/**
 * DOD Common regular expression을 통과해도 진짜 날짜 유형 객체에 적합한지 검사한다.<br>  
 * 사용예: 2006-11-00은 정규식은 통과하지만, 사실상 유효하지 않는 날짜이다.<br>
 * 
 * @param {String}	str_date	Date
 * @param {String}	del			delete 구분자
 **/
function dod_isValidDateObject(str_date, del){
	if (del==undefined || del==null || del.trim()==''){del = '-';}
	var arr_date = str_date.split(del);
	var obj_date = new Date(arr_date[0],arr_date[1]-1,arr_date[2]);
	var result = (1*arr_date[0]==obj_date.getFullYear() && 1*arr_date[1]==(obj_date.getMonth()+1) && 1*arr_date[2]==obj_date.getDate());
	if (result){return true;
	} else {return false; 
	}
}

/**
 * {@link #ComOpenWindow} 함수와 동일한 처리와 함께 팝업화면을 화면의 중앙에 활성화 한다. <br>
 * bModal 인자값에 따라 팝업창이 Modal 인지 Modaless(일반팝업) 인지 선택한다. <br>
 * bModal=true인 경우 window.showModalDialog 함수를 이용하고, bModal=false인 경우 window.open 함수를 이용한다. <br>
 * 팝업을 표시할 경우 가운데 표시하기위한 width, height, left, top 옵션은 자동으로 설정되고, 그외 다음과 같은 옵션이 설정된다. <br>
 * window.showModalDialog 함수의 옵션 : "scroll:no; status:no; help:no;"<br>
 * window.open 함수의 옵션 : "status=no, resizable=no, scrollbars=no"<br>
 * <br><b>Example :</b>
 * <pre>
 *     ComOpenWindowCenter("ESD_TPB_911.do", "ESD_TPB_911", 755, 460);
 *     ComOpenWindowCenter("ESD_TPB_911.do", null,          755, 460);
 *     pWin = ComOpenWindowCenter("ESD_TPB_911.do", null,   755, 460); //pWin은 팝업창 window object이다.
 * </pre>
 * @param {string} sUrl      선택,팝업창의 Url, default="about:blank"
 * @param {string} sWinName  선택,팝업창의 name 또는 dialogArguments, default=null
 * @param {string} iWidth    선택,팝업창의 넓이로 픽셀단위이며 최소100이상 설정
 * @param {string} iHeight   선택,팝업창의 높이로 픽셀단위이며 최소100이상 설정
 * @param {bool}   bModal    선택,팝업의 Modal 여부 (true:Modal, false:일반팝업), default=false
 * @param {bool}   sFeatures 선택,팝업창의 세부 설정, default=""
 * @returns object<br>
 *          bModal=false로 오픈된 경우 리턴값 : 팝업창의 window Object
 *          bModal=true로 오픈된 경우 리턴값  : 팝업창의 window.returnValue값
 * @see #ComOpenWindow
 */

function ComOpenWindowCenter2(sUrl,sWinName,iWidth,iHeight, bModal,sFeatures) {
    try {
        var leftpos = (screen.width - iWidth)/2;    if(leftpos<0) leftpos=0;
        var toppos  = (screen.height- iHeight)/2;   if(toppos<0)  toppos=0;

        if (bModal) {
          return ComOpenWindow(sUrl, sWinName, sFeatures+";dialogWidth:"+iWidth+"px;dialogHeight:"+iHeight+"px;dialogLeft:" + leftpos + ";dialogTop:"+toppos, true);

        } else {
          return ComOpenWindow(sUrl, sWinName, sFeatures+", width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos);

      }

    } catch(err) { ComFuncErrMsg(err.message); }

}

function checkINVCustomer(sheetObj, Row, custCdSeq) {
	var param = "f_cmd=" + SEARCH02 + "&s_value=" + custCdSeq.substr(0,2) + ComLpad(custCdSeq.substr(2), 6, "0");
	var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
	
	var count = ComGetEtcData(sXml, "count");
	var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

	if(result == "S"){
		if(parseInt(count) == 0) {
			ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
			
			var chkRowCount = sheetObj.CheckedRows("selChk");
			
			if(chkRowCount > 0) {
				// 선택 한 체크박스의 rownum을 가져온다.
				var iCheckRow = sheetObj.FindCheckedRow("selChk");
				// 가져온 행을 배열로 만든다.
				var arrRow = iCheckRow.split("|");
				
				for ( var i = 0; i < arrRow.length - 1; i++) {
					if(sheetObj.CellValue(sheetObj.SelectRow, "bkg_no") == sheetObj.CellValue(arrRow[i], "bkg_no")){
						sheetObj.CellValue2(arrRow[i], "cust_cnt_cd") = sheetObj.CellValue(Row, "tmp_cust_cnt_cd");
						sheetObj.CellValue2(arrRow[i], "cust_seq") = sheetObj.CellValue(Row, "tmp_cust_seq");
						sheetObj.CellValue2(arrRow[i], "cust_cd_seq") = sheetObj.CellValue(Row, "tmp_cust_cd_seq");
						sheetObj.CellValue2(arrRow[i], "cust_lgl_eng_nm") = sheetObj.CellValue(Row, "tmp_cust_lgl_eng_nm");
						
					}else{
						sheetObj.CellValue2(Row, "cust_cnt_cd") = sheetObj.CellValue(Row, "tmp_cust_cnt_cd");
						sheetObj.CellValue2(Row, "cust_seq") = sheetObj.CellValue(Row, "tmp_cust_seq");
						sheetObj.CellValue2(Row, "cust_cd_seq") = sheetObj.CellValue(Row, "tmp_cust_cd_seq");
						sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = sheetObj.CellValue(Row, "tmp_cust_lgl_eng_nm");
					}
				}
				
			}else{
				sheetObj.CellValue2(Row, "cust_cnt_cd") = sheetObj.CellValue(Row, "tmp_cust_cnt_cd");
				sheetObj.CellValue2(Row, "cust_seq") = sheetObj.CellValue(Row, "tmp_cust_seq");
				sheetObj.CellValue2(Row, "cust_cd_seq") = sheetObj.CellValue(Row, "tmp_cust_cd_seq");
				sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = sheetObj.CellValue(Row, "tmp_cust_lgl_eng_nm");
				sheetObj.SelectCell(Row, "cust_cd_seq");
				
			}
			return false;
		}
	}

	return true;
}

function changeINVCustomer(sheetObj, Row, custCdSeq) {
	var param = "f_cmd=" + SEARCH + "&cust_cd=" + custCdSeq.substr(0,2) +"&cust="+ custCdSeq.substr(2);
	var sXml = sheetObj.GetSearchXml("COM_ENS_041GS.do", param);
	var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
	var rtnArr2 = ComXml2ComboString(sXml, "cust_cd", "zip_cd");
	
	if(rtnArr != null && rtnArr.length > 1){
		var chkRowCount = sheetObj.CheckedRows("selChk");
//	alert("chkRowCount : " + chkRowCount);
		if(chkRowCount > 0){
			// 선택 한 체크박스의 rownum을 가져온다.
			var iCheckRow = sheetObj.FindCheckedRow("selChk");
			// 가져온 행을 배열로 만든다.
			var arrRow = iCheckRow.split("|");
			
			for ( var i = 0; i < arrRow.length - 1; i++) {
				if(sheetObj.CellValue(sheetObj.SelectRow, "bkg_no") == sheetObj.CellValue(arrRow[i], "bkg_no")){
					sheetObj.CellValue2(arrRow[i], "cust_cd_seq") = rtnArr[0];
					sheetObj.CellValue2(arrRow[i], "cust_lgl_eng_nm") = rtnArr[1];
					sheetObj.CellValue2(arrRow[i], "cust_cnt_cd") = rtnArr[0].substr(0,2);
					sheetObj.CellValue2(arrRow[i], "cust_seq") = rtnArr[0].substr(2);
					sheetObj.CellValue2(arrRow[i], "zip_cd") = rtnArr2[1];	
				}else{
					sheetObj.CellValue2(Row, "cust_cd_seq") = rtnArr[0];
					sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = rtnArr[1];
					sheetObj.CellValue2(Row, "cust_cnt_cd") = rtnArr[0].substr(0,2);
					sheetObj.CellValue2(Row, "cust_seq") = rtnArr[0].substr(2);
					sheetObj.CellValue2(Row, "zip_cd") = rtnArr2[1];
				}
				
			}
			
		}else{
			sheetObj.CellValue2(Row, "cust_cd_seq") = rtnArr[0];
			sheetObj.CellValue2(Row, "cust_lgl_eng_nm") = rtnArr[1];
			sheetObj.CellValue2(Row, "cust_cnt_cd") = rtnArr[0].substr(0,2);
			sheetObj.CellValue2(Row, "cust_seq") = rtnArr[0].substr(2);
			sheetObj.CellValue2(Row, "zip_cd") = rtnArr2[1];
		}
//	alert("INV CustCode : " + rtnArr[0] + " INV CustName : " + rtnArr[1] + " CD : " + rtnArr[0].substr(0,2) + " SEQ : " + rtnArr[0].substr(2) );
	} else {
		ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
		sheetObj.CellValue2(sheetObj.SelectRow, "cust_cnt_cd") = "";
		sheetObj.CellValue2(sheetObj.SelectRow, "cust_seq") = "";
		sheetObj.CellValue2(sheetObj.SelectRow, "cust_cd_seq") = "";
		sheetObj.CellValue2(sheetObj.SelectRow, "cust_lgl_eng_nm") = "";
		sheetObj.SelectCell(sheetObj.SelectRow, "cust_cd_seq");
		sheetObj.CellValue2(sheetObj.SelectRow, "zip_cd") = "";
		
	}
	
}

/**
 * DOD File Upload 팝업 오픈
 * caller : CHG / TRF
 */
function dodFileUploadPopUp(sheetObj, Row, caller, edit_able, prefix) {
	
	var bkgNo = '';
	var cntrNo = '';
	var drpOffChgSeq = '';	 
	var drpOffChgTrfSeq = '';
	var atch_file_lnk_id =  '';
	
	bkgNo =  sheetObj.CellValue(Row, "bkg_no");
	cntrNo =  sheetObj.CellValue(Row, "cntr_no");
	drpOffChgSeq =  sheetObj.CellValue(Row, "drp_off_chg_seq"); 		
	drpOffChgTrfSeq = sheetObj.CellValue(Row, prefix + "drp_off_chg_trf_seq");
	atch_file_lnk_id = sheetObj.CellValue(Row, "atch_file_lnk_id");
	
	if (bkgNo == undefined || bkgNo == null || ComTrim(bkgNo) == ''){
		bkgNo = '';
	}
	if (cntrNo == undefined || cntrNo == null || ComTrim(cntrNo) == ''){
		cntrNo = '';
	}
	if (drpOffChgSeq == undefined || drpOffChgSeq == null || ComTrim(drpOffChgSeq) == ''){
		drpOffChgSeq = '';
	}
	if (drpOffChgTrfSeq == undefined || drpOffChgTrfSeq == null || ComTrim(drpOffChgTrfSeq) == ''){
		drpOffChgTrfSeq = '';
	}	
	if (atch_file_lnk_id == undefined || atch_file_lnk_id == null || ComTrim(atch_file_lnk_id) == ''){
		atch_file_lnk_id = '';
	}
	
	var param = "?atch_file_lnk_id=" + atch_file_lnk_id +
					 "&bkg_no=" + bkgNo +
					 "&cntr_no="+cntrNo +
					 "&drp_off_chg_seq=" + drpOffChgSeq +
					 "&drp_off_chg_trf_seq=" + drpOffChgTrfSeq +
					 "&caller=" + caller +
					 "&edit_able=" + edit_able +
					 "&tab_gubun=" + prefix +
					 "&row=" + Row
					 ;
	ComOpenPopup("/hanjin/EES_DOD_0015.do" + param, 835, 380, "popupFinish", "1,0,1,1,1,1,1,1", true, false, 0, 0, 0, "pop1");	 
}

/**
 * FileUpload PopUp닫고나서 실행할꺼   
 */
function popupFinish(){
}

function dod_chkAmtFmtObj(obj, curr_cd){
	if (obj==undefined || obj.value==null || obj.value.trim()==''){
		return false;
	}
	obj.value = dod_chkAmtFmt(obj.value, curr_cd);
}

function dod_chkAmtFmt(src, curr_cd){
	src = new String(src);
	if (src==undefined || src==null || src.trim()==''){
		return '';
	}
	src = dod_deleteComma(src);
	if (curr_cd!=undefined && curr_cd!=null && dod_isNoDecimalPointCurrCD(curr_cd)){
		if (src.indexOf('.') != -1){
			src = src.substring(0,src.indexOf('.'));
		}
		src = dod_addComma(src);
	} else {
		if (src.indexOf('.') == -1){
			src = dod_addComma(src) + '.00'
		} else {
			var temp = src.split(".");
			if (temp.length == 2){
				if (temp[1]==null || temp[1].trim()==''){temp[1] = '00';}
				if (temp[1].length == 1){temp[1] = temp[1] + '0';
				} else if (temp[1].length == 2){
				} else if (temp[1].length > 2){temp[1] = temp[1].substring(0,2);
				}
				src = dod_addComma(temp[0])+'.'+temp[1];
			} else if (temp.length > 2){
				// 두번째 .부터 .를 다 삭제하고 재계산하기
				var tmp_str = '';
				for (var i=1; i<temp.length; i++){
					tmp_str = tmp_str + new String(temp[i]).trim();
				}
				if (tmp_str==null || tmp_str.trim()==''){tmp_str = '00';}
				if (tmp_str.length == 1){tmp_str = tmp_str + '0';
				} else if (tmp_str.length == 2){
				} else if (tmp_str.length > 2){tmp_str = tmp_str.substring(0,2);
				}
				src = dod_addComma(temp[0])+'.'+tmp_str;
			} else {
				//showErrMessage('ERR!');
				return false;
			}
		}
	}
	return src;
}

function dod_deleteCommaObj(obj){
	obj.value = dod_deleteComma(obj.value);
}

function dod_addCommaObj(obj){
	// comma제거 후 다시 comma적용
	var tmp = obj.value;
	if (tmp==undefined || tmp==null ||tmp.trim()==''){return false;}
	tmp = dod_deleteComma(tmp);
	obj.value = dod_addComma(tmp);
}

function dod_deleteComma(src){
	// comma를 제거
	var src = String(src);
	if (src==null || src==''){
		return '';
	}
	
	return src.replace(/,/gi,'');
}

function dod_addComma(src){
	// comma를 3자리마다 끼워넣기
	var src = String(src);
	if (src==null || src==''){
		return '';
	}
	var re = /(-?\d+)(\d{3})/;
	while (re.test(src)) {
		src = src.replace(re, "$1,$2");
	}
	return  src;
}

function dod_isNoDecimalPointCurrCD(CURR_CD) {
  	var arr_curr = new Array('KRW','JPY','TWD'); //소숫점 이하 제한 통화 단위들
  	for (var i=0; CURR_CD!=undefined && CURR_CD!=null && arr_curr!=null && i<arr_curr.length; i++){
  		if (arr_curr[i]!=undefined && arr_curr[i]==CURR_CD){
  			return true;
  		}
  	}
  	return false;
}
