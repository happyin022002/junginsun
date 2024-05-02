//*************** CPR START ***************// 
//2011.01.12 [CHM-201108185-01] 남궁진호  CIM30022 MSG 추가  
//2011.05.13 [CHM-201110740-01] 남궁진호  CIM29046 MSG 추가
//2012.05.14 신자영 [CHM-201217818-01] L/F by Trade & Match-back by Vessel 모듈 검색 가능 기간 확장
//2014.07.23 [CHM-201110740-01] DO-HYUN KIM  - Uncollected Cargo 관련 변수 및 메소드추가 추가
msgs['CIM21001'] = 'Mandatory field is missing.  Please enter [{?msg1}].';
msgs['CIM21004'] = 'Date format is wrong.  Please enter a valid date format. [{?msg1}]';
msgs['CIM21031'] = 'Maximum Period is [12 Months or 26 weeks]';
msgs['CIM21032'] = 'Maximum Period is [12 Months or 52 weeks]'; 

msgs['CIM29001'] = 'Mandatory field is missing. Please enter [RCC].';
msgs['CIM29002'] = 'Please input at least one location code.';
msgs['CIM29003'] = 'End week must be greater than start week.';
msgs['CIM29004'] = 'End date must be greater than start date.';
msgs['CIM29005'] = 'Maximum Period is [24].';
msgs['CIM29006'] = 'Please input at least one VVD.';
msgs['CIM29007'] = 'Please input at least one port code.';
msgs['CIM29008'] = '[RCC] code is invalid.';
msgs['CIM29009'] = '[Country] code is invalid.';
msgs['CIM29010'] = '[Port] code is invalid.';
msgs['CIM29011'] = '[POL] code is invalid.';
msgs['CIM29012'] = '[LANE] code is invalid.';
msgs['CIM29013'] = 'code is invalid.';
msgs['CIM29014'] = 'Mandatory field is missing. Please enter [LCC Code].';
msgs['CIM29015'] = 'Mandatory field is missing. Please enter [ECC Code].';
msgs['CIM29016'] = 'Mandatory field is missing. Please enter [SCC Code].';
msgs['CIM29017'] = 'Mandatory field is missing. Please enter [Yard Code].';
msgs['CIM29018'] = '[LCC] code is invalid.';
msgs['CIM29019'] = '[ECC] code is invalid.';
msgs['CIM29020'] = '[SCC] code is invalid.';
msgs['CIM29021'] = '[Yard] code is invalid.';
msgs['CIM29022'] = 'Maximum Period is [3 Months or 12 weeks].';
msgs['CIM29023'] = '[VVD] code is invalid.';
msgs['CIM29024'] = '[Location] code is invalid.';
msgs['CIM29025'] = 'Maximum Period is [3 Months or 12 weeks]';
msgs['CIM29026'] = 'Maximum Period is [12 Months]';
msgs['CIM29027'] = 'Please input a POL code.';
msgs['CIM29028'] = '[Trade] code is invalid.';
msgs['CIM29029'] = 'Maximum Period is [31 days].';
msgs['CIM29030'] = 'No data Found.';
msgs['CIM29031'] = 'Invalid RCC Code.';
msgs['CIM29032'] = 'Invalid LCC Code.';
msgs['CIM29033'] = 'Invalid ECC Code.';
msgs['CIM29034'] = 'Invalid SCC Code.';
msgs['CIM29035'] = 'Invalid Port Code.';
msgs['CIM29036'] = 'Invalid Yard Code.';
msgs['CIM29037'] = 'Invalid Country Code.';
msgs['CIM29038'] = 'Certain to Save?';
msgs['CIM29039'] = 'Certain to Delete?';
msgs['CIM29040'] = '동일한 Port_Cd가 존재합니다.';
msgs['CIM29041'] = 'Country 코드는 필수입력 입니다.';
msgs['CIM29042'] = 'BackEndJob Request Fail!';
msgs['CIM29043'] = 'Created BackEndJob File exist already!';
msgs['CIM29044'] = 'Maximum Period is [3 Months or 13 weeks]';
msgs['CIM29045'] = 'U/C Flagging Not Allowed';
msgs['CIM29046'] = 'End year must be greater than start year.';
msgs['CIM29047'] = '[Sub Trade] code is invalid.';
msgs['CIM29048'] = '[YARD] code is invalid.';

//*************** CPR END ***************//

//*************** CIM START ***************// 
msgs['CIM00008'] = 'Do you want to save ?';
msgs['CIM00010'] = 'There is no selected marking, Please check again.';


msgs['CIM30001'] = 'Maximum Period is 12 Months  or 12 Weeks.';
msgs['CIM30002'] = 'Mandatory field is missing. Please enter Location.';
msgs['CIM30003'] = 'Date format is wrong. Please enter a valid date format(YYYY-WW).';
msgs['CIM30004'] = 'Please input at least one among Lane/ VVD/ POL/ POD/ DEL fields.';
msgs['CIM30005'] = 'Please input at least one TP/SZ.';
msgs['CIM30006'] = '{?msg1} duplicaton occurred.';
msgs['CIM30008'] = 'There is no data to search.';
msgs['CIM30009'] = 'Total S/Days, only available with less than LCC Location by.';
msgs['CIM30010'] = 'Do you want to delete ?';
msgs['CIM30011'] = 'There is no selected marking, Please check again.';
msgs['CIM30013'] = '{?msg1} is invalid.';
msgs['CIM30014'] = 'Mandatory field is missing.  Please enter {?msg1}';
msgs['CIM30017'] = 'Invalid location code with HAMRU.';
msgs['CIM30018'] = 'Save cannot be implemented in a SCC Level';
msgs['CIM30019'] = 'Data was saved successfully.';
msgs['CIM30020'] = '{?msg1} should be same or later than {?msg2}.';
msgs['CIM30021'] = 'Invalid {?msg1} Code.';
msgs['CIM30022'] = 'Mandatory field is missing. Please input {?msg1}';
msgs['CIM30023'] = 'There is no data to search. please check Period ';
msgs['CIM30024'] = 'Data Retrieval Failure due to Data Overload - Please retrieve data using ‘RCC(by LCC)’ option again!';
msgs['CIM30025'] = 'Both L/S & U/C are selected in Seq {?msg1}. Please select one of them.';
msgs['CIM30026'] = 'U/C Date is inputted in Seq {?msg1}. Please change the selction from L/S to U/C.';
msgs['CIM30027'] = 'Do not mix {?msg1}';
//*************** CIM END ***************//

//*************** Uncollected Cargo START ***************//
msgs['CIM30028'] = 'Could not attach file anymore. ' ;
msgs['CIM30029'] = '(Null)' ; // fileupload에서 사용 
msgs['CIM30030'] = 'It would be interfaced to ERP that is managing the formal OTS case.\n\n Do you want to process?' ;
msgs['CIM30031'] = 'Data was processed successfully.';
msgs['CIM30032'] = 'Mandatory field is missing. Please input keyword one more';
msgs['CIM30033'] = 'Do you want to {?msg1} the selected item? ';
msgs['CIM30034'] = "Selected Row can't be deleted. Please delete Upload file first";
msgs['CIM30035'] = 'Please check the inputted date.' ;
msgs['CIM30036'] = 'Exchange Code is unable to used.\nPlease check your key in Exchange Code.';
msgs['CIM30037'] = 'There is no data to search for {?msg1} exchange rate.';
msgs['CIM30038'] = "Selected Row can't be inserted. Please Upload file first";
msgs['CIM30039'] = "Go back to the previous sequence?";

var FileUploadPopupWin = null; // File Upload PopupWindow Object - 전역변수
//*************** Uncollected Cargo END ***************//

/*
function CimMakeRDXml(sheet_obj)  {
    try {
        var allXml = "";
        var sColSep = "•";
        allXml = "<SHEET1>\n  <DATA  TOTAL='"+sheet_obj.LastRow+"'>\n";
        var sheetXml = sheet_obj.GetRangeText(sheet_obj.HeaderRows,0,sheet_obj.LastRow,sheet_obj.LastCol,sColSep,"^");
        sheetXml = sheetXml.replace(/\,/gi, "");
        sheetXml = sheetXml.replace(/•/gi, "]]></TD><TD><![CDATA[");
        allXml += "<TR><TD><![CDATA["+sheetXml.replace(/\^/gi, "]]></TD></TR><TR><TD><![CDATA[")+"]]></TD></TR>";
        allXml += "  </DATA>\n</SHEET1>";
        return allXml;
    } catch(err) { ComFuncErrMsg(err.message); }
}
*/
function CimMakeRDXml(sheet_obj,no){
	  //함수 인자 유효성 확인
	  if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
		alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
		return "";
	  }

	  var rowXml = "";
	  var allXml = "<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow +"'>";

	  var rowcount = sheet_obj.RowCount + sheet_obj.headerRows - 1;
	  for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
		rowXml = "<TR>";
		for (ic = 0; ic<= sheet_obj.LastCol; ic++) {
		  rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir,ic) + "]]></TD>";
		}
		rowXml += "</TR>";

		allXml += rowXml;
	  }

	  allXml += "  </DATA></SHEET" + no + ">";

	  return allXml;
	
}

function CimMakeRDXml2(sheet_obj,no){
	  //함수 인자 유효성 확인
	  if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
		alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
		return "";
	  }

	  var rowXml = "";
	  var allXml = "<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow +"'>";

	  var rowcount = sheet_obj.RowCount + sheet_obj.headerRows - 1;
	  for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.LastRow; ir++) {
		rowXml = "<TR>";
		  if(sheet_obj.CellValue(ir,0) == "0"){
			  rowXml += "<TD><![CDATA[]]></TD>";
		  }
		  else{
			  rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir,0) + "]]></TD>";
		  }
		for (ic = 1; ic<= sheet_obj.LastCol; ic++) {
		  rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir,ic) + "]]></TD>";
		}
		rowXml += "</TR>";

		allXml += rowXml;
	  }

	  allXml += "  </DATA></SHEET" + no + ">";

	  return allXml;
	
}


function CimMakeRDXml3(sheet_obj,no){
	  //함수 인자 유효성 확인
	  if (typeof sheet_obj != "object" || sheet_obj.tagName != "OBJECT") {
		alert("Data2SearchXml 함수의 sheet_obj 인자는 IBSheet가 아닙니다.");
		return "";
	  }

	  var rowXml = "";
	  var allXml = "<SHEET" + no + ">  <DATA TOTAL='"+ sheet_obj.LastRow +"'>";

	  for (ir = sheet_obj.HeaderRows; ir <= sheet_obj.RowCount+1; ir++) {
			rowXml = "<TR>";
			  if(sheet_obj.CellValue(ir,0) == "0"){
				  rowXml += "<TD><![CDATA[]]></TD>";
			  }
			  else{
				  rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir,0) + "]]></TD>";
			  }
			for (ic = 1; ic<= sheet_obj.LastCol; ic++) {
			  rowXml += "<TD><![CDATA[" + sheet_obj.CellValue(ir,ic) + "]]></TD>";
			}
			rowXml += "</TR>";

			allXml += rowXml;
	 }


	  allXml += "  </DATA></SHEET" + no + ">";

	  return allXml;
	
}    

 /**
 * IBSheet의 GetSearchXml 함수 또는 GetSaveXml 함수를 통해 받아온 XML 문자열을 파싱하여 그 안에 MESSAGE 값을 리턴한다.
 * @param   {string} xmlStr     필수,IBSheet를 통해 받아온 xml 문자열
 * @return  string, MESSAGE의 값
 */
 function CimComGetErrMsg(xmlStr){
    if ( xmlStr == null  || xmlStr == "" ) return;

    try {
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
        xmlDoc.loadXML(xmlStr);

        var xmlRoot = xmlDoc.documentElement;
        if(xmlRoot == null) return;

        var msgDataNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
        if(msgDataNode == null) return;

        return msgDataNode.firstChild.nodeValue;
    } catch(err) { ComFuncErrMsg(err.message); }
 }
 
 /**
 * 반복문으로  생성된 라스트 Delim을 제거
 * ex)
 * '1,2,3,4,5,' => '1,2,3,4,5'
 * @param {String} str 		제거 대상 String
 * @return {String} str 	제거된 String
 * @author 박명신
 * @version 2009.06.04
 */
function CimDelLastDelim(str){
	//마지막에 &를 없애기 위함
	if (str != ""){
		 str = str.substr(0, str.length - 1);
	}	
	return str;
}

/** 
 * setting select box <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param {IBMultiCombo} comboObj  
 * @param {string} sBeforeArr
 * @param {string} sSeperater
 * @param {bool} bAllFlg
 * @param {string} cmbType
 * @return 없음
 * @see #
 * @author 박정진
 * @version 2009.05.04
 * @LastModifyDate : 2014.03.24
 * @LastModifier : Kim Chang Young
 * @LastVersion : 1.1
 */
function MakeComboObject(cmbObj, sBeforeArr, sSeperater, bAllFlg, cmbType) {
		cmbObj.RemoveAll(); 
		
		var arrStr = sBeforeArr.split(sSeperater);
		
		if(cmbType == "codeOnly") {
			if(bAllFlg) cmbObj.InsertItem(0, "ALL", "");
		} else if (cmbType = "codeText") {
			if(bAllFlg) cmbObj.InsertItem(0, "|ALL", "");
		}
		
		for (var i = 0; i < arrStr.length;i++ ) {
			if(cmbType == "codeOnly") {
				cmbObj.InsertItem(i + bAllFlg, arrStr[i], arrStr[i]);
			} else if (cmbType = "codeText") {
				arrStr[i].split("|");
				cmbObj.InsertItem(i + bAllFlg, arrStr[i], arrStr[i].split("|")[0]);
			}
		}
		
		if(bAllFlg) cmbObj.Index2 = 0;
		else cmbObj.Index2 = "-1";
}

//*************** Uncollected Cargo START ***************//
/**
 * [Uncollected Cargo] - UC File Attach 팝업을 띄우는 함수
 * @param : uc_cs_no
 * @param : uc_cgo_file_id
 * @param : file_sav_id
 * @param : file_desc
 */
function openFileUploadPopup(uc_cs_no, uc_cgo_file_id, file_sav_id, file_desc) {
	var theURL = "EES_CIM_0065.do?ucCsNo="+uc_cs_no+"&ucCgoFileId="+uc_cgo_file_id+"&fileSavId="+file_sav_id+"&fileDesc="+file_desc;
    	theURL += "&f_cmd="+SEARCH+"&targetFnc=&downloadLink=Y&authYn=Y&modalWindow=Y";
    var winName = "EES_CIM_0065";
	var features = "scroll:no;status:no;help:no;dialogWidth:320px;dialogHeight:430px";
	var rtnValue = window.showModalDialog(theURL, window, features);
	
	return rtnValue;
	
}

/**
 * [Uncollected Cargo] - fileDownload 함수 - EES_CIM_0065에서 사용
 * @param : physicalFileNm - 물리 파일명(시스템)
 * @param : logicalFileNm - 논리 파일명(사용자)
 * @param : filePlace -  물리 파일저장 경로
 * @param : fileRepositoryId - // file-meta 정보  ID (설정파일의 file-id)
 * @param : fileKey
 */
function fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId, fileKey) {
	//alert('fileDownLoad');
	if ( fileRepositoryId == null || fileRepositoryId == undefined || fileRepositoryId.length == 0 ) { 
		fileRepositoryId = "CIM";
	}

	///----- iframe 생성 -----
	var o1 = document.createElement("DIV");
	var f = document.frames;
	var ifr = "frame_"+f.length;
	o1.style.display = "none";
	o1.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="10" width="0" height="0"></iframe>';
	document.body.appendChild(o1);

	///----- form 생성 -----
	var o2 = document.createElement("DIV");
	var formArr = document.forms;
	var formObj = "downFrm_"+formArr.length;
	o2.style.display = "none";
	formStr = "";
	formStr += "<form method='post' name='"+formObj+"' target='"+ifr+"' action='/hanjin/FileDownload' >"; /// Action : FileDownload Servlet
	formStr += "<input type='hidden' name='fileId'>"; //실제 물리 파일명( 저장되어있는 )
	formStr += "<input type='hidden' name='fileDir'>"; // 파일이 저장되어있는 경로
	formStr += "<input type='hidden' name='orgFilename'>"; // 논리 파일명 ( 사용자가 다운로드 받을 명칭 )
	formStr += "<input type='hidden' name='repoId'>"; // file-meta 정보  ID 
	formStr += "<input type='hidden' name='key'>"; // file key
	formStr += "<input type='hidden' name='downloadLocation'>"; // downloadLocation
	formStr += "<input type='hidden' name='stringFile'>"; // stringFile
	formStr += "</form>";
	o2.innerHTML = formStr;
	document.body.appendChild(o2);

	///----- submit, download servlet Call -----
	document.forms[formObj].fileId.value = physicalFileNm;  //실제 물리 파일명( 저장되어있는 )
	document.forms[formObj].orgFilename.value = logicalFileNm; // 논리 파일명 ( 사용자가 다운로드 받을 명칭)
	document.forms[formObj].fileDir.value = filePlace;  // 파일이 저장되어있는 경로
	document.forms[formObj].repoId.value = fileRepositoryId; // file-meta 정보  ID 
	document.forms[formObj].key.value = physicalFileNm; // file key
	document.forms[formObj].downloadLocation.value = filePlace; // downloadLocation
	document.forms[formObj].stringFile.value = logicalFileNm; // stringFile
	document.forms[formObj].submit();
	document.forms[formObj].reset();
}
