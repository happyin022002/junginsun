/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoScg.js
*@FileTitle : SCG 공통 자바스크립트
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.08 이도형
* 1.0 Creation
=========================================================*/

	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */

	// --------------------------------------------------------
	// 전역 상수 
	// --------------------------------------------------------
	
	var SCG_PAGE_SIZE = 200;
    
	// SCG공통 Message
	msgs['SCG10014'] = 'Check again the partner’s approval!';
	msgs['SCG50001'] = 'Do you want to save {?msg1}?';
	msgs['SCG50002'] = 'Do you want to delete {?msg1}?';
	msgs['SCG50003'] = 'Data was changed.\nDo you want to save it?';
	msgs['SCG50004'] = '{?msg1} is not available.';
	msgs['SCG50005'] = '{?msg1} is duplicated.';

	msgs['SCG50006'] = '{?msg1} must be at least {?msg2} characters long.';
	msgs['SCG50007'] = 'Please input {?msg1}.';	
	msgs['SCG50008'] = 'There is no corresponding data.\nYou have to add a new provision first at {?msg1}.';
	msgs['SCG50009'] = '{?msg1} must be either {?msg2} or {?msg3} characters long.';
	msgs['SCG50010'] = '{?msg1} is invalid.';
	
	msgs['SCG50011'] = 'Please select {?msg1}';
	msgs['SCG50012'] = 'For the purpose of documentation and package marking the Proper Shipping Name shall be supplemented with the technical name for this UN No.';	
	msgs['SCG50013'] = 'You have to add a new segregation group first.';
	msgs['SCG50014'] = 'This updating will change stowage & segregation rule.\nDo you want to continue to update?';
	msgs['SCG50015'] = '"Class" must be # or #.#.';
	
	msgs['SCG50016'] = 'This UN No. is not permitted as Limited Quantity.';
	msgs['SCG50017'] = 'BKG No. {?msg1} was cancelled.';
	msgs['SCG50018'] = 'Please use after Save.';
	msgs['SCG50019'] = 'This UN No. is not permitted as Excepted Quantity.';
	msgs['SCG50020'] = 'When conjunction such as "and" or "or" are in the Proper Shipping Name or when segments of the name are punctuated by commas, you have to select the most appropriate one.';

	msgs['SCG50021'] = 'BKG No. {?msg1} is on waiting status.';
	msgs['SCG50022'] = 'This DG Cargo is listed in First Schedule of Singapore.\nYou need to check the total approved cargo net weight on the class for the max quantity of First Schedule DG which may remain on board at a Singapore berth.\nSo far, total {?msg1}kg have been approved on the Class {?msg2}.\nYou are going to approve net weight {?msg3}kg additionally.\nDo you confirm?';	
	msgs['SCG50023'] = 'Flashpoint is expected to be in the range of 23°C (include 23°C) to 60°c(include 60°C) for packing group III.';
	msgs['SCG50024'] = 'Flashpoint is expected to be below 23°C for packing group I or II.';
	msgs['SCG50025'] = 'Do you want to add a new UN No./Sequence?';
	
	msgs['SCG50026'] = 'This UN No. is identified as marine pollutants.';
	msgs['SCG50027'] = 'UN No. {?msg1} doesn\'t exist.\nDo you want to input a new UN No.?';
	msgs['SCG50028'] = 'The Sequence was copied.';
	msgs['SCG50029'] = 'This booking doesn\'t comply with SML policy according to Pre Checking Report.\nDo you want to proceed approval?';
	msgs['SCG50030'] = 'In view of personal computer memory, possible TTL No. of Requests exporting to excel will be limited to 20000.';
	
	msgs['SCG50031'] = 'There is no corresponding data.';
	msgs['SCG50032'] = 'In view of the data processing time, inquiry period will be limited to one {?msg1}.';
    
	msgs['SCG50033'] = 'There alerady exists a restriction.';
	msgs['SCG50034'] = 'Maximun 4,000 characters are allowed.';
	msgs['SCG50035'] = 'It can\'t be handled at POL or POD or T/S port due to G/C limitation.\nPls double check with local BBO/BAO. Are you sure to proceed?';

// PACKING INSTRUCTION 36 ~ 40
	msgs['SCG50036'] = 'Pack. Instruct. Code {?msg1} doesn\'t exist.\nDo you want to input a new Pack. Instruct. Code?';
	msgs['SCG50037'] = 'Please save first.\nDo you want to save it?';
	msgs['SCG50038'] = 'This UN NO-[{?msg1}] limited quantity of [{?msg2} {?msg4}] per package is greater than [{?msg3} {?msg4}] in IMDG regulation. \nPls re-check again.';
	msgs['SCG50039'] = 'Limited Quantity needs Inner and Outer package Quantity. \nPls re-check again.';
	msgs['SCG50040'] = '{?msg1} is not made by {?msg2}.';
	
	msgs['SCG50041'] = 'Please Save the attatched file after saving the subject & content.';
	msgs['SCG50042'] = 'If you checked ‘Permit’, pls input detailed reason and action to be carried by BKG/Sales staff to load/disch DG in \‘Text Explanation\’.';	
	msgs['SCG50043'] = 'Terminal information is not available. Please check manually and update terminal information.'; 
	msgs['SCG50044'] = 'RQST DT Range is available between 1 and 300.'; 
	msgs['SCG50045'] = 'Passed ETA Date is available between 1 and 300.'; 
	msgs['SCG50046'] = 'Mail was already sending.\nWill you again send to mail?'; 
	msgs['SCG50047'] = 'There is no change data.'; 

	/**
     * Sheet의 특정행의 값을 Form의 각 컨트롤에 값을 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComScgCopyRowToForm(mySheet, document.mainForm);
     *     ComScgCopyRowToForm(mySheet, document.mainForm, mySheet.SelectedRow);
     *     ComScgCopyRowToForm(mySheet, document.mainForm, 1, "str_");
     *
     *     &lt;script for="mySheet" event="OnSelectCell(or,oc,nr,nc)"&gt;
     *       if(nr &lt; HeaderRows || nr &gt; LastRow||RowCount  == 0) return mainForm.reset();
     *       if(or==nr) return;
     *
     *       IBS_CopyRowToForm(mySheet, mainForm);
     *     &lt;/script&gt;
     * </pre>
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {int}     row       선택,IBSheet의 복사할 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @see #IBS_CopyFormToRow
     */
	function ComScgCopyRowToForm(sheetobj, formobj, row, prefix){
		//함수의 인자 유효성 확인-시작
		if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
		} else if (formobj==null || typeof formobj != "object" || formobj.tagName != "FORM") {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
		} else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow)) {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 row 인자값이 잘못되었습니다.");
		}
		//함수의 인자 유효성 확인-종료

		//HTML컨트롤의 name 앞에 붙는 글자
		if (prefix == null || prefix=="") prefix = "frm_";
		if (row == null) row=sheetobj.SelectRow;

		//Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
		//컬럼개수만큼 루프 실행
		for(var col=0;col<=sheetobj.LastCol ;col++){
			//컬럼의 별명을 문자열로 가져온다.
			var col_alias = sheetobj.ColSaveName(col)
			if (col_alias=="") continue;
			var sheetvalue = sheetobj.CellValue(row,col);

			//폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
			var frmchild = formobj.elements(prefix +col_alias);

			//폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
			if(frmchild==null) continue;

			var sType = frmchild.type;
			//radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
			if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;

			//타입별로 값을 설정한다.
			switch(sType) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					for (idx=0; idx<frmchild.length; idx++) {
						if(frmchild[idx].value == sheetvalue) {
							frmchild[idx].checked=true;
							break;
						}
					}
					break;
				case "checkbox":
					if (sheetvalue==1) {
						frmchild.checked = (sheetvalue==1);
					}else if (sheetvalue=="Y") {
						frmchild.checked = (sheetvalue=="Y");						
					}
					break;
				case "select-one":			
					var eOpt = frmchild.options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						for ( var k = 0; k < opt_len; k++) {
							if (eOpt[k].value == sheetvalue) {
								idx = k;
								break;
							}
						}
					}
					frmchild.selectedIndex = idx;
					break;
				case "":
					var frmObjNm = prefix + col_alias;
					for(var k=0; k<comboObjects.length; k++){
						if (comboObjects[k].id == frmObjNm) {
							comboObjects[k].Code = sheetvalue;
						}
					}
					break
				default :
					frmchild.value = sheetvalue;
			}//end of switch
		}//end of for(col)
	}

    /**
     * Form의 각 컨트롤에 값을 Sheet의 특정행의 각 컬럼에 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComScgCopyFormToRow(document.mainForm, mySheet);
     *     ComScgCopyFormToRow(document.mainForm, mySheet, mySheet.SelectRow);
     *     ComScgCopyFormToRow(document.mainForm, mySheet, 1, "str_");
     * </pre>
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {int}     row       선택,IBSheet의 붙여넣을 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 접두사 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @see #IBS_CopyRowToForm
     */
	function ComScgCopyFormToRow(formobj, sheetobj, row, prefix){
		//함수의 인자 유효성 확인-시작
		if (sheetobj==null || typeof sheetobj != "object" || sheetobj.tagName != "OBJECT") {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 sheetobj 인자는 IBSheet 태그가 아닙니다.");
		}else if (formobj==null || typeof formobj != "object" || formobj.tagName != "FORM") {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 formobj 인자는 FORM 태그가 아닙니다.");
		}else if (row!=null && (isNaN(row) || row < 0 || row > sheetobj.LastRow)) {
			return IBS_ShowErrMsg("IBS_Sheetformobj 함수의 row 인자값이 잘못되었습니다.");
		}

		//HTML컨트롤의 name 앞에 붙는 글자
		if (prefix == null || prefix=="") prefix = "frm_";
		if (row == null) row=sheetobj.SelectRow;

		sheetobj.Redraw=false;

		//Sheet의 컬럼개수만큼 찾아서 HTML의 Form 각 Control에 값을 설정한다.
		//컬럼개수만큼 루프 실행
		for(var col=0;col<=sheetobj.LastCol ;col++){
			//컬럼의 별명을 문자열로 가져온다.
			var col_alias = sheetobj.ColSaveName(col)
			if (col_alias=="") continue;

			//폼에 있는 해당 이름의 컨트롤을 가져온다.예)"frm_CardNo"
			var frmchild = formobj.elements(prefix +col_alias);

			//폼에 해당하는 이름의 컨트롤이 없는 경우는 계속 진행한다.
			if(frmchild==null) continue;

			var sType = frmchild.type;
			var sValue;
			var frmObjNm;
			//radio의 경우 frmchild가 배열형태가 되므로, frmchild.type으로는 타입을 알수 없다.
			if (sType==undefined && frmchild.length>0) sType=frmchild[0].type;
			//타입별로 값을 설정한다.
			switch(sType) {
				case undefined:
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					for (idx=0; idx<frmchild.length; idx++) {
						if(frmchild[idx].checked) {
							sValue = frmchild[idx].value;
							break;
						}
					}
					break;
				case "checkbox":
					sValue =(frmchild.checked)?1:0;
					break;
				case "":
					frmObjNm = prefix + col_alias;
					for(var k=0; k<comboObjects.length; k++){
						if (comboObjects[k].id == frmObjNm) {
							sValue = comboObjects[k].Code;
						}
					}
					break
				default :
					sValue = frmchild.value;
			}//end of switch

			sheetobj.CellValue2(row,col) = sValue;

		}//end of for(col)

		sheetobj.Redraw=true;
	}

	/**
	 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
	 * 
	 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
	 * @param {string} sPrefix 필수, Prefix.
	 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
	 */
	function ComScgSetPrifix(sStr, sPrefix) {
		if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
			return sStr;
		}
		
		var regexp = RegExp(/&/g);
		sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
		return sStr;
	}
	

	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComScgXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
	 * 
	 * 결과: 35X 3 크기의 결과 Array.
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
	 * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
	 * @return array   [조회된row수 X 컬럼수] 크기의 string array.
	 */
	function ComScgXml2Array(xmlStr, colList) {
		var rtnArr = new Array();
	
		if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
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
	
			var dataChileNodes = dataNode.childNodes;
			if (dataChileNodes == null) {
				return;
			}
	
			var colListArr = colList.split("|");
			var colListIdx = Array();
			for ( var i = 0; i < colListArr.length; i++) {
				for ( var j = 0; j < colArr.length; j++) {
					if (colListArr[i] == colArr[j]) {
						colListIdx[i] = j;
						break;
					}
				}
			}
	
			for ( var i = 0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);
	
				var subDataArr = new Array();
				for ( var j = 0; j < colListIdx.length; j++) {
					subDataArr[j] = arrData[colListIdx[j]];
				}
				rtnArr[i] = (subDataArr);
			}
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	
		return rtnArr;
	}
	
	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * IBMultiCombo의 item으로 insert 해준다.<br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	 * @return 없음.
	 */
	function ComScgXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, nullYn) {
		if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
	
		try {
			cmbObj.RemoveAll();
			
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
			
			var colListIdx = Array();
			var arrText = textCol.split("|");
			
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				for (var j = 0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1] = i;
					}
				}
			}
			
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (nullYn == 'Y') {
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
					var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
					
					var item = "";
					for (var j = 1; j < colListIdx.length; j++) {
						item += arrData[colListIdx[j]];
						if (j < colListIdx.length - 1) {
							item += "|";
						}
					}
					if (i==0){
						cmbObj.InsertItem(i, '', '');						
					}
					cmbObj.InsertItem(i+1, item, arrData[colListIdx[0]]);
				}else{
					if (dataChildNodes[i].nodeType != 1) {
						continue;
					}
					var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
					
					var item = "";
					for (var j = 1; j < colListIdx.length; j++) {
						item += arrData[colListIdx[j]];
						if (j < colListIdx.length - 1) {
							item += "|";
						}
					}
					cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
				}
			}
	
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}
	
	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	 * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
	 * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComScgXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명.
	 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	 */
	function ComScgXml2ComboString(xmlStr, codeCol, textCol) {
		var rtnArr = new Array();
		
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
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
			
			var colListIdx = Array();
			for ( var i = 0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0] = i;
				}
				if (colArr[i] == textCol) {
					colListIdx[1] = i;
				}
			}
			
			var sCode = "";
			var sText = "";
			for ( var i = 0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
				
				sCode += arrData[colListIdx[0]];
				sText += arrData[colListIdx[1]];
				
				if (i != dataChildNodes.length - 1) {
					sCode += "|";
					sText += "|";
				}
			}
			rtnArr.push(sCode);
			rtnArr.push(sText);
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	
		return rtnArr;
	}
	
	/**
	 * Save 후, 성공 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	 */
	function ComScgSaveCompleted() {
		ComShowCodeMessage('SCG00101');
	}

	/**
	 *  sXml에서 MESSAGE 내용을 추출 
	 * @param sXml
	 * @return Sring MESSAGE
	 * @author jkc
	 */
	function ComScgGetMessageFromXml(sXml){
		if ( sXml == null  || sXml == "" ) return;

  	    try {
  	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
  	        xmlDoc.loadXML(sXml);

  	        var xmlRoot = xmlDoc.documentElement;
  	        if(xmlRoot == null) return;
   
  	        var msgNode = xmlRoot.getElementsByTagName("MESSAGE").item(0);
  	      
  	        if(msgNode == null) return "";

  	        return msgNode.firstChild.nodeValue;
  	    } catch(err) { ComFuncErrMsg(err.message); }
	} 
    
	
	/**
	 *  Xml에서 데이타 가져오기 
	 *	savename 복수일경우 | 사용.
	 * @param xmlStr
	 * @param savename
	 * @return value   ex)복수시 리턴값  aaa|dddd
	 * @author jkc
	 */
	function ComScgGetRowValue(xmlStr, cRow, savename)  {
		if (xmlStr == null || xmlStr == ""  ) {
			return;
		}
		if (savename  == null || savename == ""  ) {
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
				return "";
			}
			var TOTAL_ROWS = eval( dataNode.getAttribute("TOTAL") );
 
			if( TOTAL_ROWS == "0" ){
				return "";
			}
			var col = dataNode.getAttribute("COLORDER");
 
			var colArr = col.split("|");
 
			var sep = dataNode.getAttribute("COLSEPARATOR");
			var dataChildNodes = dataNode.childNodes;
			if (dataChildNodes == null) {
				return;
			}
 
			var colListIdx = Array();
			var arrText = savename.split("|");

			for (var i = 0; i < colArr.length; i++) {
				for (var j = 0; j < arrText.length; j++) {
					if ( colArr[i] == arrText[j] && colArr[i] != "" ) {
						colListIdx[j] = i;
					}
				}	
			}

			if(  cRow   >  TOTAL_ROWS ){
				return "";
			}
			var arrData = dataChildNodes[cRow-1].firstChild.nodeValue.split(sep);
 
			var trData = "";
			for (var j = 0; j < colListIdx.length; j++) {
				if( j < colListIdx.length-1){
					trData += arrData[colListIdx[j]]+"|";
				}else{
					trData += arrData[colListIdx[j]];   
				}
			}
			return trData;
		} catch (err) {
			ComFuncErrMsg(err.message);
		}
	}
	
	/**
	 *  Xml에서 Tran 처리 결과 가져오기 
	 * @param xmlStr
	 * @param savename
	 * @return value    
	 * @author jkc
	 */
	function ComScgGetTrAllValue(sXml){
		if ( sXml == null  || sXml == "" ) return;

  	    try {
  	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
  	        xmlDoc.loadXML(sXml);

  	        var xmlRoot = xmlDoc.documentElement;
  	        if(xmlRoot == null) return;

  	        var msgNode = xmlRoot.getElementsByTagName("TR-ALL").item(0);
  	      
  	        if(msgNode == null) return "";

  	        return msgNode.firstChild.nodeValue;
  	    } catch(err) { ComFuncErrMsg(err.message); }
  	}

	/**
	 *  Xml에서 Total 건수  가져오기 
	 * @param xmlStr
	 * @param savename
	 * @return value    
	 * @author jkc
	 */
	function ComScgGetTotalValue(sXml){
		if ( sXml == null  || sXml == "" ) return;

  	    try {
  	        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM" );
  	        xmlDoc.loadXML(sXml);

  	        var xmlRoot = xmlDoc.documentElement;
  	        if(xmlRoot == null) return;

  	        var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
  	      
  	        if(dataNode == null) return "";

  	        return dataNode.getAttribute("TOTAL");
  	    } catch(err) { ComFuncErrMsg(err.message); }
  	} 
	
    /**
     *  String을 쌍으로 만들어서 합치기
     *   ex) a|b|c     vs 1|2|3
     *      a \t 1|b \t 2|c \t 3
     * @param xmlStr
     * @param savename
     * @return value    
     * @author jkc
     */      
     function ComScgClossAppend(str1, str2, delim){
         if( str1 == ""){return;}
         if( str2 == ""){return;}
         if( delim == ""){ delim= "\t";}
         if( delim == null){delim="\t";}
         
         
         var aStr1 = str1.split("|");
         var aStr2 = str2.split("|");
         if(aStr1.length != aStr2.length){return;}
         
         var tStr  = "";
         for(var i=0;i<aStr1.length; i++){
             if( i < aStr1.length ){
                 tStr += aStr1[i]+delim+aStr2[i]+"|";
             }else{
                 tStr = aStr1[i]+delim+aStr2[i];
             }
         }
         return tStr;
     }
     
     /**
      * 팝업모양내기.
      * @author jkc
      */      
     function ComScgMainToMakePopup(){
         var doc = document.all;
//         if(doc.sitelink2 != undefined){
//             var  sitelink = doc.sitelink.parentElement.parentElement.parentElement.parentElement;       
//             sitelink.style.display = "none";
//         }
         navigation.parentElement.innerHTML = "";
         var  objClose = document.all.btn_Close.parentElement.parentElement.parentElement.parentElement;      
         objClose.style.display        = "";
     }
      
    /**
     * 공동운항선사의 특수화물(DG, AWK, BB, RF 등) 선적승인 요청 및 승인 Mail을 보내기 Mail Preview 팝업 화면 열기
     * @param {object}  sheetObj               필수, Sheet Object
     * @param {object}  formObj                필수, Form Object
     * @param {object}  mailObj                필수, Value Object
     * @param {boolean} returnYn               선택, 메일링 후 후처리 여부
     * @param {string}  sDomain                선택, 메일링 후 후처리 도메인(저장만 해당)
     * @param {string}  returnProc             선택, 메일링 후 후처리 추가 프로세스
     * <pre> 
     * mailObj sub value 
     * -----------------------------------------------------------------------------------
     *        {string} crr_cd                 필수(타사), Form Object
     *        {string} bkg_ref_no             필수(타사), Form Object
     *        {string} spcl_cgo_rqst_seq      필수(타사), Form Object
     *        {string} bkg_no                 필수(자사), Form Object
     *        {string} spcl_cgo_apro_rqst_seq 필수(자사), Form Object
     *        {string} rgn_shp_opr_cd         필수, Form Object
     *        {string} scg_flg                필수, Form Object, 예) DG, AK, 45, BB, RF
     *        {string} send_type              필수, Form Object, 예) 자사요청:O0 자사승인:O1, 타사요청:P0 타사승인:P1
     *        {string} user_id                필수, Form Object
     * -----------------------------------------------------------------------------------
     * </pre> 
     */    
    var mailObj = new Object();  
    function ComScgSendMail(sheetObj, formObj, mailObj, returnYn, sDomain, returnProc) {
    	var mailParams = new Array("com_rdSubSysCd","com_from","com_recipient","com_carbonCopy","com_blindCarbonCopy","com_subject","com_content","com_fileKey","com_template","com_argument");
 	    try {
 	    	var sParam = Array();
 	    	sParam[sParam.length] = "crr_cd="+mailObj.crr_cd;
 	    	sParam[sParam.length] = "bkg_ref_no="+mailObj.bkg_ref_no;
 	    	sParam[sParam.length] = "spcl_cgo_rqst_seq="+mailObj.spcl_cgo_rqst_seq;
 	    	sParam[sParam.length] = "bkg_no="+mailObj.bkg_no;
 	    	sParam[sParam.length] = "spcl_cgo_apro_rqst_seq="+mailObj.spcl_cgo_apro_rqst_seq;
 	    	sParam[sParam.length] = "vsl_pre_pst_cd="+mailObj.vsl_pre_pst_cd;
 	    	sParam[sParam.length] = "vsl_seq="+mailObj.vsl_seq;
 	    	sParam[sParam.length] = "rgn_shp_opr_cd="+mailObj.rgn_shp_opr_cd;
 	    	sParam[sParam.length] = "scg_flg="+mailObj.scg_flg;
 	    	sParam[sParam.length] = "send_type="+mailObj.send_type;
 	    	sParam[sParam.length] = "user_id="+mailObj.user_id;
 	    	
 	    	//리턴 프로세스 구성
 	    	if (returnYn==undefined || returnYn==null || returnYn=="") returnYn = false;
 	    	if (sDomain==undefined || sDomain==null || sDomain=="") sDomain = "";
 	    	if (returnProc==undefined || returnProc==null || returnProc=="") returnProc = "";
 	    	if(returnYn) {
 	    		var sProc = "";
 	    		if(sDomain != "") {
 	    			sProc += "try {";
 	    			sProc += "   var sheetObj;";
 	    			sProc += "   for(var sCt=0; sCt<sheetObjects.length; sCt++) {";
 	    			sProc += "      if('"+sheetObj.id+"'==sheetObjects[sCt].id) sheetObj=sheetObjects[sCt];";
 	    			sProc += "   }";
 	    			sProc += "   var sXml = sheetObj.GetSaveXml('"+sDomain+"', 'f_cmd="+MODIFY+"&eml_snd_no='+key+'&'+FormQueryString(document.form));";
 	    			sProc += "   if(sXml.length>0) {";
 	    			sProc += "      "+returnProc;
 	    			sProc += "   }";
 	    			sProc += "} catch(err) {";
 	    			sProc += "   ComFuncErrMsg(err.message);";
 	    			sProc += "}";
 	    		} else {
 	    			sProc = returnProc;
 	    		}
 	    		comMailKeyReturn = new Function("key", sProc);
 	    	} else {
 	    		comMailKeyReturn = new Function();
 	    	}
 	    	 	    	
 	    	ComOpenWait(true, true);
 	    	
 	        formObj.f_cmd.value = SEARCH;
	    	var sXml = sheetObj.GetSearchXml("VOP_SCG_0019GS.do", sParam.join("&")+"&"+FormQueryString(formObj));	    	
	    	
	    	var mailParamObjs = document.getElementById('mail_param');
	    	if(mailParamObjs == null) {
		    	var paramDiv = document.createElement("<div name='mail_param' id='mail_param' style='display:'></div>");	
		    	var paramObj;
		    	for(var idx=0; idx<=mailParams.length; idx++) {   
		    		paramObj = document.createElement("<input type='hidden' name='"+mailParams[idx]+"' value=''>");
		    		paramDiv.appendChild(paramObj); 
		    	}
		    	paramObj = document.createElement("<input type='hidden' id='com_mailKeyFlag' value=''>");
	    		paramDiv.appendChild(paramObj); 
	    		
		    	formObj.appendChild(paramDiv);
    		}
	    	
	    	var body_header = ComGetEtcData(sXml, "body_header");
	    	if(body_header != '') body_header = "<PRE>"+body_header+"</PRE>"+"<BR>"
	    	
	    	ComSetObjValue(formObj.f_cmd,          ComGetEtcData(sXml, SEARCH));
	    	ComSetObjValue(formObj.com_rdSubSysCd, "COM");
	    	ComSetObjValue(formObj.com_from,       ComGetEtcData(sXml, "from_psn"));
	    	ComSetObjValue(formObj.com_recipient,  ComGetEtcData(sXml, "to_psn"));
	    	ComSetObjValue(formObj.com_carbonCopy, ComGetEtcData(sXml, "cc_psn"));
	    	ComSetObjValue(formObj.com_subject,    ComGetEtcData(sXml, "subject"));
	    	ComSetObjValue(formObj.com_content,    body_header+"<PRE>"+ComGetEtcData(sXml, "body_conts")+"</PRE><BR><BR>"+"<PRE>"+ComGetEtcData(sXml, "body_footer")+"</PRE>");
	    	ComSetObjValue(formObj.com_fileKey,    ComGetEtcData(sXml, "attach_file"));
	    	ComSetObjValue(formObj.com_mailKeyFlag,returnYn);
	    
	    	ComOpenWait(false);
	    	
	    	//Waitting 이미지로 인한 창 스크롤 생성 방지용
 			document.body.scroll = "no";
	    	
 			ComSendMailModal();
	    	//ComSendMail(); 			
 			//Session 유지를 위한 임시 팝업 --> 추후 모달로 변경예정--------------------------------------//
 			//if(window.dialogArguments == undefined)
 				//window.open("", "mail", "Width=770, Height=755");
 			//else
 			//	window.dialogArguments.open("", "mail", "Width=770, Height=755");
 			
 			//document.form.action = "/hanjin/Mail.do?f_cmd=2";
 			//document.form.target = "mail";
 			//document.form.method = "post";
 			//document.form.submit();
 			//--------------------------------------------------------------------------------------//
	    	
	    	//paramDiv.removeNode(true);
 			
 			//초기화
 			ComSetObjValue(formObj.f_cmd,          "");
	    	ComSetObjValue(formObj.com_rdSubSysCd, "");
	    	ComSetObjValue(formObj.com_from,       "");
	    	ComSetObjValue(formObj.com_recipient,  "");
	    	ComSetObjValue(formObj.com_carbonCopy, "");
	    	ComSetObjValue(formObj.com_subject,    "");
	    	ComSetObjValue(formObj.com_content,    "");
	    	ComSetObjValue(formObj.com_fileKey,    "");
	    	ComSetObjValue(formObj.com_mailKeyFlag,"");
 	    } catch(err) { ComFuncErrMsg(err.message); }
 	}
    
    /**
     * 메일링후 호출 프로세스 <br>
     * 
     * @param   {object}    sheetObj   필수
     * @param   {string}    sDomain    필수
     * @param   {string}    sParam     필수
     * @see ComScgSendMail()
     */
    function ComScgCallAfterMailing(sheetObj, sDomain, sParam) {
    	try {
    		sheetObj.GetSaveXml(sDomain, sParam);
    	} catch(err) { 
    		ComFuncErrMsg(err.message); 
    	}
    }
    
    /**
     * 
     * <pre>
     *    Excel Title 
     * </pre>
     *
     * @param   sheetObj
     * @param   paramObj
     *          - Attribute : title         : 제목명          (default : 화면제목명);
     *                      : align         : Title 가로 정렬 {"center", "left", "right"}, (default:center)
     *                      : cols          : 타이틀 칼럼수   (default : Sheet Cols수(단, hidden Type 제외 )
     *                      : orientation   : 용지방향        {Landscape,Portrait}(default : Landscape )
     *                      : columnwidth   : 특정 Col Width  (default : 자동) ex)지정필요시, 3 col 30, 4 col 50 일때, 3:30|4:50 
     *                      : datarowheight : 특정 Row Height (default : 20) ex)지정필요시, 3 Row 30, 4 Row 50 일때, 3:30|4:50
     *                                        양식 타이틀이 아닌, 그리드 타이틀부터 1, ex2)그리드 타이틀 row Height을 50으로 변경시
     *                                        paramObj.datarowheight="1:50"
     * @author jang kang cheol
     */
     function ComScgGetPgmTitle(sheetObj, paramObj){
        var doc   = document.all;
        var pageUrl = "VOP_SCG_EXCEL.do?";
        
        /*************************** 제목처리 **********************************/
        var sTitle = "";
        /*************************** 정렬처리 **********************************/
        var sTalign = "center,left,right";
        var sAlign = "";
        /*************************** Col수 처리 **********************************/
        var sCols  = "";
        var iCols = 0;
        /*************************** 용지방향 처리 **********************************/        
        var sOrientation = "";

        /*************************** 특정지정 컬럼들 width 처리 **********************************/        
        var sColumnwidth = "";

        /*************************** 특정지정 Row 들 Height 처리 **********************************/        
        var sDatarowheight = "";
        
        
        if(paramObj.title == undefined ){
            sTitle     = doc.title.innerHTML.replace("&nbsp;","");
            sTitle     = sTitle.replace("&amp;"," ");
        }else{
            sTitle     = paramObj.title;
        }
        if(paramObj.align == undefined ){
            sAlign="center"; 
        }else if(sTalign.indexOf(paramObj.align) == -1 ){
            sAlign = "left";
        }else{
            sAlign = paramObj.align;
        }
        if(paramObj.cols == undefined ){
            for(var i=0; i<= sheetObj.LastCol; i++){
                if ( sheetObj.ReadDataProperty(0, i, dpDataType) != dtHidden 
                     && 
                     sheetObj.ReadDataProperty(0, i, dpDataType) != dtHiddenStatus
                   ){
                    iCols++;
                }
            }
        }else{
            iCols = eval(paramObj.cols);
        }
 
        if(paramObj.orientation == undefined ){
            sOrientation = "Landscape";
        }else{
            sOrientation = paramObj.orientation;
        }
        
        if(paramObj.columnwidth == undefined ){
            sColumnwidth = "";
        }else{
            sColumnwidth = paramObj.columnwidth;
        }
        
        if(paramObj.datarowheight == undefined ){
            sDatarowheight = "";
        }else{
            sDatarowheight = paramObj.datarowheight;
        }        
 
        var sUrl = pageUrl+"title="+sTitle+"&align="+sAlign+"&orientation="+sOrientation+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
        return sUrl;
     }
     
    /**
     * 주어진 컬럼의 Max값 구하기 <br>
     *
     * @param {object} sheetObj 필수, IBSheet Object.
     * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
     * @return int Max값
     * @author 박성수
     * @version 2009.04.22
     */
    function ComScgGetMax(sheetObj, sCol) {
        var max = 0;
        for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
            if (parseInt(sheetObj.CellValue(i, sCol)) > max) {
                max = sheetObj.CellValue(i, sCol);
            }
        }
        return max;
    }
    
    /**
     * 결과값에 따라 Object 색 변경
     * @param objValue : Object의 값
     * @param equalValue : Object와 비교할 값
     * @param objId : Object ID
     * @param color : objValue 와 equalValue와 같을 경우 변경할 색(red,blue...)
     * @param className : objValue 와 equalValue와 같을 경우 변경할 ClassName (현재 사용 안함)
     * @author 김병규
     * @version 2009.09.01
     */
     function changeObjectColor(objValue, equalValue, objId, color, className){
         if(objValue == equalValue){
             document.getElementById(objId).style.color = color;
         }else{
             document.getElementById(objId).style.color = "#737373";

         }
     }

     /**
      * Systematic Inspection Filtering Text 단일메일 팝업 호출<br>
      * <pre>
      *     ComScgSendUDGMail(sheetObj, formObj, mailObj, returnYn, sDomain, returnProc)
      * </pre>
      * @param  bkg_no
      * @return 없음
      * @author 김도현
      * @version 2015.07.06
      */
     function ComScgSendUDGMail(sheetObj, formObj, mailObj, returnYn, sDomain, returnProc) {
     	var mailParams = new Array("com_rdSubSysCd","com_from","com_recipient","com_carbonCopy","com_blindCarbonCopy","com_subject","com_content","com_fileKey","com_template","com_argument");
  	    try {
  	    	var sParam = Array();
  	    	sParam[sParam.length] = "crr_cd="+mailObj.crr_cd;
  	    	sParam[sParam.length] = "bkg_ref_no="+mailObj.bkg_ref_no;
  	    	sParam[sParam.length] = "spcl_cgo_rqst_seq="+mailObj.spcl_cgo_rqst_seq;
  	    	sParam[sParam.length] = "bkg_no="+mailObj.bkg_no;
  	    	sParam[sParam.length] = "spcl_cgo_apro_rqst_seq="+mailObj.spcl_cgo_apro_rqst_seq;
  	    	sParam[sParam.length] = "vsl_pre_pst_cd="+mailObj.vsl_pre_pst_cd;
  	    	sParam[sParam.length] = "vsl_seq="+mailObj.vsl_seq;
  	    	sParam[sParam.length] = "rgn_shp_opr_cd="+mailObj.rgn_shp_opr_cd;
  	    	sParam[sParam.length] = "scg_flg="+mailObj.scg_flg;
  	    	sParam[sParam.length] = "send_type="+mailObj.send_type;
  	    	sParam[sParam.length] = "user_id="+mailObj.user_id;
  	    	sParam[sParam.length] = "non_dcgo_rqst_seq="+mailObj.non_dcgo_rqst_seq;
  	    	
  	    	//리턴 프로세스 구성
  	    	if (returnYn==undefined || returnYn==null || returnYn=="") returnYn = false;
  	    	if (sDomain==undefined || sDomain==null || sDomain=="") sDomain = "";
  	    	if (returnProc==undefined || returnProc==null || returnProc=="") returnProc = "";
  	    	if(returnYn) {
  	    		var sProc = "";
  	    		if(sDomain != "") {
  	    			sProc += "try {";
  	    			sProc += "   var sheetObj;";
  	    			sProc += "   for(var sCt=0; sCt<sheetObjects.length; sCt++) {";
  	    			sProc += "      if('"+sheetObj.id+"'==sheetObjects[sCt].id) sheetObj=sheetObjects[sCt];";
  	    			sProc += "   }";
  	    			sProc += "   var sXml = sheetObj.GetSaveXml('"+sDomain+"', 'f_cmd="+MODIFY+"&eml_snd_no='+key+'&'+FormQueryString(document.form));";
  	    			sProc += "   if(sXml.length>0) {";
  	    			sProc += "      "+returnProc;
  	    			sProc += "   }";
  	    			sProc += "} catch(err) {";
  	    			sProc += "   ComFuncErrMsg(err.message);";
  	    			sProc += "}";
  	    		} else {
  	    			sProc = returnProc;
  	    		}
  	    		comMailKeyReturn = new Function("key", sProc);
  	    	} else {
  	    		comMailKeyReturn = new Function();
  	    	}
  	    	 	    	
  	    	ComOpenWait(true, true);
  	    	
  	        formObj.f_cmd.value = SEARCH01;
 	    	var sXml = sheetObj.GetSearchXml("VOP_SCG_0024GS.do", sParam.join("&")+"&"+FormQueryString(formObj));	    	
 	    	
 	    	var mailParamObjs = document.getElementById('mail_param');
 	    	if(mailParamObjs == null) {
 		    	var paramDiv = document.createElement("<div name='mail_param' id='mail_param' style='display:'></div>");	
 		    	var paramObj;
 		    	for(var idx=0; idx<=mailParams.length; idx++) {   
 		    		paramObj = document.createElement("<input type='hidden' name='"+mailParams[idx]+"' value=''>");
 		    		paramDiv.appendChild(paramObj); 
 		    	}
 		    	paramObj = document.createElement("<input type='hidden' id='com_mailKeyFlag' value=''>");
 	    		paramDiv.appendChild(paramObj); 
 	    		
 		    	formObj.appendChild(paramDiv);
     		}
 	    	
 	    	var body_header = ComGetEtcData(sXml, "body_header");
 	    	if(body_header != '') body_header = "<PRE>"+body_header+"</PRE>"+"<BR>"
 	    	
 	    	ComSetObjValue(formObj.f_cmd,          ComGetEtcData(sXml, SEARCH));
 	    	ComSetObjValue(formObj.com_rdSubSysCd, "COM");
 	    	ComSetObjValue(formObj.com_from,       ComGetEtcData(sXml, "from_psn"));
 	    	ComSetObjValue(formObj.com_recipient,  ComGetEtcData(sXml, "to_psn"));
 	    	ComSetObjValue(formObj.com_carbonCopy, ComGetEtcData(sXml, "cc_psn"));
 	    	ComSetObjValue(formObj.com_subject,    ComGetEtcData(sXml, "subject"));
 	    	ComSetObjValue(formObj.com_content,    body_header+"<PRE>"+ComGetEtcData(sXml, "body_conts")+"</PRE><BR><BR>"+"<PRE>"+ComGetEtcData(sXml, "body_footer")+"</PRE>");
 	    	ComSetObjValue(formObj.com_fileKey,    ComGetEtcData(sXml, "attach_file"));
 	    	ComSetObjValue(formObj.com_mailKeyFlag,returnYn);
 	    	
 	    	ComOpenWait(false);
 	    	
 	    	//Waitting 이미지로 인한 창 스크롤 생성 방지용
  			document.body.scroll = "no";
 	    	
  			ComSendMailModal();
  			
  			//초기화
  			ComSetObjValue(formObj.f_cmd,          "");
 	    	ComSetObjValue(formObj.com_rdSubSysCd, "");
 	    	ComSetObjValue(formObj.com_from,       "");
 	    	ComSetObjValue(formObj.com_recipient,  "");
 	    	ComSetObjValue(formObj.com_carbonCopy, "");
 	    	ComSetObjValue(formObj.com_subject,    "");
 	    	ComSetObjValue(formObj.com_content,    "");
 	    	ComSetObjValue(formObj.com_fileKey,    "");
 	    	ComSetObjValue(formObj.com_mailKeyFlag,"");
  	    } catch(err) { ComFuncErrMsg(err.message); }
  	}

     /**
      * Booking Detail 팝업 호출<br>
      * <pre>
      *     comBkgCallPopBkgDetail(bkgNo);
      * </pre>
      * @param  bkg_no
      * @return 없음
      * @author 김도현
      * @version 2015.07.06
      */
     function comBkgCallPopBkgDetail(bkgNo){
     	var sUrl  = "ESM_BKG_0079_Q.do?bkg_no="+bkgNo;
     	ComOpenWindowCenter(sUrl, "ESM_BKG_0079_Q", 1024, 700, true, "yes");
     }
     
     /**
      * Booking Attachment 팝업 호출<br>
      * <pre>
      *     comBkgCallPopBkgAttachment(bkgNo);
      * </pre>
      * @param  bkg_no
      * @return 없음
      * @author 김양재
      * @version 2016.03.22
      */
     function comBkgCallPopBkgAttachment(bkgNo){
    	var sUrl = "ESM_BKG_0369.do?bkg_no="+bkgNo;
    	ComOpenWindowCenter(sUrl, "ESM_BKG_0369", 400, 370, false);  //modal로 띄울 경우 IE의IBUpload 컴포넌트가 설치되어 있지 않으면 오류남
     }
     