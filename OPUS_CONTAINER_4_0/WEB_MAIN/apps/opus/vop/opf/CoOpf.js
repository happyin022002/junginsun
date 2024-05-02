/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CoOpf.js
*@FileTitle  : OPF 공통 자바스크립트
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
	if(msgs == undefined){
		msgs=new Array();
	}
	msgs['OPF50001']='Do you want to save {?msg1}?';
	msgs['OPF50002']='Do you want to delete {?msg1}?';
	msgs['OPF50003']='Data was changed. Do you want to save it?';
	msgs['OPF50004']='{?msg1} is invalid.';
	msgs['OPF50005']='{?msg1} is duplicated.';
	msgs['OPF50006']='{?msg1} was saved successfully.';
	msgs['OPF50007']='{?msg1} must be at least {?msg2} characters long.';
	msgs['OPF50008']='{?msg1} must be either {?msg2} or {?msg3} characters long.';
	msgs['OPF50009']='Please input {?msg1}.';
	msgs['OPF50010']='The added weight group should be less than over the weight group.';
	msgs['OPF50011']='"From" of the last row should be zero(0).';
	msgs['OPF50012']='"To" of the last row should not be zero(0).';
	msgs['OPF50013']='"{?msg1}" should be later than "{?msg2}".';
	msgs['OPF50014']='Booking data was imported successfully.';
	msgs['OPF50015']='There is no corresponding data for the search. For a TDR creation in the subject port manually, Arrival/Departure Time & Vessel Condition will be imported from Actual SKD & COND.';
	msgs['OPF50016']='The Volume will be change with the volume from BKG data.\nDo you want to Import Data?';
	msgs['OPF50017']='No approval from the Vessel Operation Team yet for the unknown responsible party.\nPlease request the Team to give confirmation for this damage case before proceeding to the next process.';
	msgs['OPF50018']='"Damage Date" should be from ETA {?msg1} to ETD {?msg2}.';
	msgs['OPF50019']='There is previously Saved CBF. Do you want to change CBF?';
	msgs['OPF50020']='"{?msg1}" process step should be saved for the first step.';
	msgs['OPF50021']='In view of the data processing time, inquiry period will be limited to one year.';
    msgs['OPF50022']='"{?msg1}" must be less than {?msg2}';
    msgs['OPF50023']='Rows will be saved up to "{?msg1}" at most.';
    msgs['OPF50024']='"{?msg1}" exceeds field length.';
    msgs['OPF50025']='{?msg1} Row [{?msg2}] is mandatory item.';
    msgs['OPF50026']='{?msg1} can not be deleted.';
    msgs['OPF50027']='Damage date is not within the port time. Please check it again.';
    msgs['OPF50028']='Cannot find any rehandling container in bay planning information.';
    msgs['OPF50029']='You cannot input own vessel operator code in this screen.';
    msgs['OPF50030']='{?msg1} is not available.';

    /**
     * Sheet의 특정행의 값을 Form의 각 컨트롤에 값을 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComOPFCopyRowToForm(mySheet, document.mainForm);
     *     ComOPFCopyRowToForm(mySheet, document.mainForm, mySheet.SelectedRow);
     *     ComOPFCopyRowToForm(mySheet, document.mainForm, 1, "str_");
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
     * @version 3.4.0.50
     * @see #IBS_CopyFormToRow
     */
	function ComOPFCopyRowToForm(sheetobj, formobj, row, prefix){
		IBS_CopyRowToForm(sheetobj, formobj, row, prefix);
		/*var frmObjNm=prefix + col_alias;
		for(var k=0; k<comboObjects.length; k++){
			if (comboObjects[k].id == frmObjNm) {
				comboObjects[k].SetSelectCode(sheetvalue);
			}
		}*/
	}
    /**
     * Form의 각 컨트롤에 값을 Sheet의 특정행의 각 컬럼에 복사한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     ComOPFCopyFormToRow(document.mainForm, mySheet);
     *     ComOPFCopyFormToRow(document.mainForm, mySheet, mySheet.SelectRow);
     *     ComOPFCopyFormToRow(document.mainForm, mySheet, 1, "str_");
     * </pre>
     * @param   {form}    formobj   필수,html의 Form 오브젝트 Name
     * @param   {ibsheet} sheetobj  필수,IBSheet Object ID
     * @param   {int}     row       선택,IBSheet의 붙여넣을 행번호, 인자를 설정하지 않으면 현재 선택된 행이 됨
     * @param   {string}  prefix    선택,Form 안에 있는 컨트롤의 이름앞에 붙는 접두사 문자열, 예)"obj_CardNo"이면 이인자는 "obj_"임, 인자를 설정하지 않으면 "frm_"가 기본임
     * @return  없음
     * @version 3.4.0.50
     * @see #IBS_CopyRowToForm
     */
	function ComOPFCopyFormToRow(formobj, sheetobj, row, prefix){
		IBS_CopyFormToRow(formobj, sheetobj, row, prefix);
	}
	/**
     * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * saveColName 파라미터를 이용하여 원하는 컬럼을 지정할수 있고, <br>
     * sCol, sValue 파라미터를 이용하여 원하는 행의 조건을 줄수 있다.(필터링) <br>
     * saveColName의 값이 없으면 전체 컬럼을 대상으로 진행되고, <br>
     * sCol, sValue 값이 없으면 전체 행을 대상으로 진행된다. <br>
     * Sheet의 전체 데이터에 대해 스캔이 이루어지므로, 데이터양이 많을 경우 속도가 저하될수 있음에 유의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriSheet2Xml(sheetObj);
     *     sXml = ComPriSheet2Xml(sheetObj, "col1|col2|col3|col4");
     *     sXml = ComPriSheet2Xml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
     * @param {string}	sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {string}	sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
     * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
	 * @author by PRI박성수
	 * @version 2009.05.07
     */
    function ComPriSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel)  {
        try {
        	if ((!sheetobj) || (!sheetobj.IBSheetVersion)){
                return "";
            }
            var allXml="";
            var sColSep="~~";
            var allRows=false;
            var arrPrcdRow=new Array();
            if (saveColName == undefined || saveColName == null || saveColName == "") {
            	saveColName=IBS_ConcatSaveName(sheetObj);
            }
            var arrCol=saveColName.split("|");
            var condNames=new Array();
            var condValues=new Array();
            if (sCol == undefined || sCol == null || sCol == "" || sValue == undefined || sValue == null || sValue == "") {
            	allRows=true;
            } else {
            	condNames=sCol.split("|");
            	condValues=sValue.split("|");
            }
            var aryTR=new Array();
            var aryTD=new Array(arrCol.length);
            for (var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
                if (!allRows) {
        			for (var j=0; j < condNames.length; j++) {
        				var isMatch=true;
        				if (sheetObj.GetCellValue(i, condNames[j]) != condValues[j]) {
        					isMatch=false;
        					break;
        				}
        			}
                }
                if (!isMatch) {
                	continue;
                }
                for (var j=0; j < arrCol.length; j++) {
                	aryTD[j]=String(sheetObj.GetCellValue(i, arrCol[j]));
                }
                aryTR.push("    <TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>");
                arrPrcdRow.push(i);
            }
            allXml += "<?xml version='1.0'  ?>\n";
            allXml += "<SHEET>\n";            
            allXml += "  <DATA TOTAL='" + arrPrcdRow.length + "' COLORDER='" + saveColName + "' COLSEPARATOR='" + sColSep + "'>\n";
            allXml += aryTR.join("\n");
            allXml += "  </DATA>\n"
            allXml += "</SHEET>";
            if (bRowDel) {
            	if (allRows) {
            		sheetObj.RemoveAll();
            	} else {
                	sheetObj.RenderSheet(0);
                	for(var i=arrPrcdRow.length - 1; i >= 0; i--){
                        sheetObj.RowDelete(arrPrcdRow[i], false);
                    }
                	sheetObj.RenderSheet(1);
            	}
            }
            return allXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/**
	 * 한 화면에 여러개의 Sheet가 있는 경우, SaveString에 prefix를 붙여준다 <br>
	 * 
	 * @param {string} sStr 필수, QueryString from IBSheet.GetSaveString().
	 * @param {string} sPrefix 필수, Prefix.
	 * @return string 쿼리스트링의 각 name앞에, 주어진 prefix가 붙여진 쿼리스트링.
	 * @author by PRI박성수
	 * @version 2009.04.22
	 */
	function ComPriSetPrifix(sStr, sPrefix) {
		if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
			return sStr;
		}
		var regexp=RegExp(/&/g);
		sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
		return sStr;
	}
	/**
	 * IBSheet의 row들을 주어진 값과 일치하는 row의 Index를 배열형태로 반환한다 <br>
	 * 
	 * @param {object} sheetObj 필수, IBSheet Object.
	 * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
	 * @param {string} sValue 필수, 키 데이터. "|"로 연결한다.
	 * @return array 주어진 조건에 일치하는 행의 Index로 이루어진 배열.
	 * @author by PRI박성수
	 * @version 2009.04.22
	 */
	function ComPriSheetFilterRows(sheetObj, sCol, sValue) {
		if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
			return;
		}
		var rtnArr=new Array();
		var arrCol=sCol.split("|");
		var arrValue=sValue.split("|");
 		for (var i=1; i < sheetObj.LastRow(); i++) {
			var isMatch=true;
			for (var j=0; j < arrCol.length; j++) {
				if (sheetObj.GetCellValue(i, arrCol[j]) != arrValue[j]) {
					isMatch=false;
					break;
				}
			}
			if (isMatch) {
				rtnArr.push(i);
			}
		}
		return rtnArr;
	}
	/**
	 * IBSheet의 row들을 주어진 값과 일치하는 row만 보이도록 필터링 한다. <br>
	 * 필터링 후 필터된 row중 첫번째 row를 select해 준다. <br>
	 * 
	 * @param {object} sheetObj 필수, IBSheet Object.
	 * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
	 * @param {string} sValue 필수, 키 데이터. "|"로 연결한다.
	 * @return 없음
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriSheetFilter(sheetObj, sCol, sValue) {
		if (sheetObj == null || sCol == null || sCol == "" || sValue == null || sValue == "") {
			return;
		}
		var arrCol=sCol.split("|");
		var arrValue=sValue.split("|");
		var firstRow=-1;
 		for (var i=1; i < sheetObj.LastRow(); i++) {
			var doHide=false;
			for (var j=0; j < arrCol.length; j++) {
				if (sheetObj.GetCellValue(i, arrCol[j]) != arrValue[j]) {
					doHide=true;
					break;
				}
			}
			if (!doHide && firstRow == -1) {
				firstRow=i;
			}
			sheetObj.SetRowHidden(i,doHide);
		}
		if (firstRow > 0) {
			sheetObj.SetSelectRow(firstRow);
		}
	}
	/**
	 * Master/Detail로 이루어진 2개의 IBSheet에서 Master에서 선택된 row에 해당하는 내용만 Detail에 보이도록 필터링 한다. <br>
	 * 
	 * @param {object} sheetObjM 필수, Master IBSheet Object.
	 * @param {object} sheetObjD 필수, Detail IBSheet Object.
	 * @param {string} sCol 필수, 키 컬럼명(Savename). "|"로 연결한다.
	 * @return 없음
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriMDSheetFilter(sheetObjM, sheetObjD, sCol) {
		if (sheetObjM == null || sheetObjD == null || sCol == null || sCol == "") {
			return;
		}
		var idx=sheetObjM.GetSelectRow();
		var arrCol=sCol.split("|");
		var sValue="";
		for (var i=0; i < arrCol.length; i++) {
			sValue += sheetObjM.GetCellValue(idx, arrCol[i]);
			if (i < arrCol.length - 1) {
				sValue += "|";
			}
		}
		ComPriSheetFilter(sheetObjD, sCol, sValue);
	}
	/**
	 * 주어진 컬럼의 Max값 구하기 <br>
	 * 
	 * @param {object} sheetObj 필수, IBSheet Object.
	 * @param {string} sCol 필수, Max값을 구할 컬럼명(Savename).
	 * @return int Max값
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriGetMax(sheetObj, sCol) {
		var max=0;
		for (var i=1; i < sheetObj.LastRow(); i++) {
			if (parseInt(sheetObj.GetCellValue(i, sCol)) > max) {
				max=sheetObj.GetCellValue(i, sCol);
			}
		}
		return max;
	}
	/**
	 * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 Array형태로 변환한다. <br>
	 * <b>Example :</b>
	 * 
	 * <pre>
	 * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	 * var arrData = ComOPFXml2Array(xmlStr, &quot;user_id|user_nm|status&quot;);
	 * 
	 * 결과: 35X 3 크기의 결과 Array.
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열
	 * @param {string} colList 필수, XML문자열에서 추출하고자하는 컬럼명(Savename). "|"로 연결한다.
	 * @return array   [조회된row수 X 컬럼수] 크기의 string array.
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComOpfXml2Array(xmlStr, colList) {
		var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
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
			var dataChileNodes=dataNode.childNodes;
			if (dataChileNodes == null) {
				return;
			}
			var colListArr=colList.split("|");
			var colListIdx=Array();
			for ( var i=0; i < colListArr.length; i++) {
				for ( var j=0; j < colArr.length; j++) {
					if (colListArr[i] == colArr[j]) {
						colListIdx[i]=j;
						break;
					}
				}
			}
			var count=0;
			for ( var i=0; i < dataChileNodes.length; i++) {
				if (dataChileNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChileNodes[i].firstChild.nodeValue.split(sep);
				var subDataArr=new Array();
				for ( var j=0; j < colListIdx.length; j++) {
					subDataArr[j]=arrData[colListIdx[j]];
				}
				rtnArr[count]=(subDataArr);
				count++;
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
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComOPFXml2ComboItem(xmlStr, cmbObj, codeCol, textCol) {
		if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
		try {
			cmbObj.RemoveAll();
	          cmbObj.RemoveAll();
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
			var arrText=textCol.split("|");
			for ( var i=0; i < colArr.length; i++) {
				if (colArr[i] == codeCol) {
					colListIdx[0]=i;
				}
				for (var j=0; j < arrText.length; j++) {
					if (colArr[i] == arrText[j]) {
						colListIdx[j+1]=i;
					}
				}
			}
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
				var item="";
				for (var j=1; j < colListIdx.length; j++) {
					item += arrData[colListIdx[j]];
					if (j < colListIdx.length - 1) {
						item += "|";
					}
				}
				cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
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
	 * var arrData = ComPriXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
	 * 
	 * </pre>
	 * 
	 * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	 * @param {string} codeCol 필수, Combo의 Code컬럼명.
	 * @param {string} textCol 필수, Combo의 Text컬럼명.
	 * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriXml2ComboString(xmlStr, codeCol, textCol) {
		var rtnArr=new Array();
		if (xmlStr == null || xmlStr == "") {
			return;
		}
		if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
			return;
		}
		try {
	          cmbObj.RemoveAll();
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
			var sCode="";
			var sText="";
			for ( var i=0; i < dataChildNodes.length; i++) {
				if (dataChildNodes[i].nodeType != 1) {
					continue;
				}
				var arrData=dataChildNodes[i].firstChild.nodeValue.split(sep);
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
	 * Save 전, 확인 메시지<br>
	 * 
	 * @param 없음
	 * @returns bool <br>
	 *          true : 확인메시지에서 "확인"을 누른 경우<br>
	 *          false : 확인메시지에서 "취소"을 누른 경우<br>
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmSave() {
		return ComShowCodeConfirm('PRI00001');
	}
	/**
	 * Delete 전, 확인 메시지<br>
	 * 
	 * @param 없음
	 * @returns bool <br>
	 *          true : 확인메시지에서 "확인"을 누른 경우<br>
	 *          false : 확인메시지에서 "취소"을 누른 경우<br>
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmDelete() {
		return ComShowCodeConfirm('PRI00002');
	}
	/**
	 * Delete 전, 확인 메시지<br>
	 * 
	 * @param 없음
	 * @returns bool <br>
	 *          true : 확인메시지에서 "확인"을 누른 경우<br>
	 *          false : 확인메시지에서 "취소"을 누른 경우<br>
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmDeleteAll() {
		return ComShowCodeConfirm('PRI00005');
	}
	/**
	 * Confirm 전, 확인 메시지<br>
	 * 
	 * @param 없음
	 * @returns bool <br>
	 *          true : 확인메시지에서 "확인"을 누른 경우<br>
	 *          false : 확인메시지에서 "취소"을 누른 경우<br>
	  * @author by PRI박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmConfirm() {
		return ComShowCodeConfirm('PRI00003');
	}
	/**
	 * Cancel Confirm 전, 확인 메시지<br>
	 * 
	 * @param 없음
	 * @returns bool <br>
	 *          true : 확인메시지에서 "확인"을 누른 경우<br>
	 *          false : 확인메시지에서 "취소"을 누른 경우<br>
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmCancelConfirm() {
		return ComShowCodeConfirm('PRI00004');
	}
	/**
	 * Save 후, 성공 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComOPFSaveCompleted() {
		ComShowCodeMessage('OPF00101');
	}
	/**
	 * Delete 후, 성공 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriDeleteCompleted() {
		ComShowCodeMessage('PRI00102');
	}
	/**
	 * Confirm 후, 성공 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmCompleted() {
		ComShowCodeMessage('PRI00103');
	}
	/**
	 * Confirm Cancel 후, 성공 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriCancelConfirmCompleted() {
		ComShowCodeMessage('PRI00104');
	}
	/**
	 * Save 후, 실패 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriSaveFailed() {
		ComShowCodeMessage('PRI00201');
	}
	/**
	 * Delete 후, 실패 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriDeleteFailed() {
		ComShowCodeMessage('PRI00202');
	}
	/**
	 * Confirm 후, 실패 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriConfirmFailed() {
		ComShowCodeMessage('PRI00203');
	}
	/**
	 * Confirm Cancel 후, 실패 메시지<br>
	 * 
	 * @param 없음
	 * @return 없음
	  * @author 박성수
	  * @version 2009.04.22
	 */
	function ComPriCancelConfirmFailed() {
		ComShowCodeMessage('PRI00204');
	}
	 /**
	  * IBSheet의 중복컬럼을 체크한다. <br>
	  * 중복이 되었다면 중복된 row 를 return 하고 중복된 row가 없다면 <br>
	  * -1을  return 한다.
	  *
	  * <b>Example :</b>
	  *
	  * <pre>
	  * var dupRow = jsDupCheck(col);  // 중복 체크할 컬럼을 | 로구분하여 입력한다.
	  * </pre>
	  *
	  * @param {string} col 필수
	  * @return int   -1 이면 중복 없음, 중복된 row
	  * @author 
	  * @version 2009.04.22
	  */
	 function jsDupCheck(ColStr)
	 {
		 var sText,ir, ic;
		 var Row, Col, aryCol, bNext;
		 var sheetObject1=sheetObjects[0];
		 Col=-1;
		 aryCol=ColStr.split("|");
		 ColStr="";
		 //첫번째 컬럼을 찾고, 나머지 가능한 유효 컬럼을 찾는다
		 for (ic=0; ic < aryCol.length; ic++) {
			 if (aryCol[ic] >= 0 && aryCol[ic] <= sheetObject1.LastCol())
			 {
				 if (Col == -1)
					 Col=aryCol[ic];
				 else
					 ColStr += (ColStr==""?"":"|") + aryCol[ic];
			 }
		 }
		 //한개 컬럼의 중복 여부를 확인하는 경우
		 if (ColStr == "") {
			 if (Col != -1) return sheetObject1.ColValueDup(Col);
			 //다중 컬럼의 중복 여부를 확인하는 경우
		 } else {
			 aryCol=ColStr.split("|")
			 for (ir=1; ir<= sheetObject1.LastRow(); ir++) {
				 //첫번째 컬럼의 값으로 중복된 행번호를 가져옴
				 sText=sheetObject1.GetCellText(ir, Col);
				 Row=sheetObject1.FindText(Col, sText, ir + 1, true);
				 //해당 값으로 중복된 모든 행을 확인
				 while (Row > 0) {
					 bNext=false;
					 //중복된 행이 있는 경우 나머지 컬럼 값 일치 여부 확인
					 for (ic=0; ic<aryCol.length; ic++){
						 if (sheetObject1.GetCellText(ir, aryCol[ic]) != sheetObject1.GetCellText(Row, aryCol[ic]) ){
							 //하나라도 값이 다르면 그냥 처리 중단, 다음 중복 확인
							 bNext=true;
							 break;
						 }
					 }
					 //모든 컬럼 값이 같으므로 중복 행번 반환
					 if (bNext == false) return Row;
					 Row=sheetObject1.FindText(Col, sText, Row + 1, true);
				 }
			 }
		 }
		 return -1;
	 }
	 /**
	  * 전체 Row 중에 Checkbox의 체크가 되어있는 Row들의 상태를 삭제로 변경한다. <br>
	  * <br><b>Example :</b>
	  * <pre>
	  *     deleteRowCheck(sheetObj);
	  *     deleteRowCheck(sheetObj, "sel_chk", "del_chk");
	  * </pre>
	  * @param {ibsheet} sheetObj 필수 IBSheet Object
	  * @param {string} selColName 선택 화면에 보여지는 checkbox의 SaveName.
	  *                               default="sel_chk"
	  * @return 없음
	  * @author 문동규
	  * @version 2009.04.22
	  */
	 function deleteRowCheck(sheetObj, selColName) {
		 if (arguments.length == 1) {
			 selColName="sel_chk";
		 }
		 ComRowHideDelete(sheetObj, selColName);
	 }
	  /*function deleteRowCheck(sheetObj, selColName, delColName) {
	      if (arguments.length == 1) {
	          selColName="sel_chk";
	          delColName="del_chk";
	      }
	      var chkdRows=sheetObj.FindCheckedRow(selColName);
	      var arr=chkdRows.split("|");
	      var cnt=arr.length;
	      for(var i=cnt-1; i >= 0; i--){
	          if(arr[i] != ''){
if(sheetObj.LastRow()== arr[i] && sheetObj.GetRowStatus(arr[i]) == "I"){
	                  sheetObj.SetRowStatus(arr[i],"D");
	              } 
	              else{ 
	                  sheetObj.SetCellValue(arr[i], delColName,1,0);
	              } 
	          }
	      }
	  }*/
	/**
	 * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
	 * <b>Example :</b>
	 * <pre>
	 * setIBCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
	 * </pre>
	 * 
	 * @param {string} sheetObj 필수
	 * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
	 * @param {string} title 필수, Combo field명(IBSheet SaveName).
	 * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
	 * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
	 * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
	 * @return 
	 * @author 공백진
	 * @version 2009.04.30
	 */
    function setIBCombo(sheetObj, sXml, title, iBlank, sCol){
     	var showCol=0;
     	var bFlag=false;
     	if (sCol != "undifind" && sCol !=""){
     		showCol=sCol;
     	}    	
     	if (iBlank != "undifind" && iBlank !=""){
     		bFlag=iBlank;
     	}    	
 		var arrData=ComPriXml2ComboString(sXml, "cd", "nm");
 		if (bFlag == true){
 			arrData[1]=" \t |"+ arrData[1];
 			arrData[0]=" |"+ arrData[0];
 		}
 		sheetObj.SetColProperty(title, {ComboText:arrData[1] ,ComboCode:arrData[0]} );
    }
	   /**
	    *  Xml에서 Total 건수  가져오기 
	    * @param xmlStr
	    * @param savename
	    * @return value    
	    * @author jkc
	    */      
	    function ComOpfGetTotalValue(xmlStr){
	  	    if ( xmlStr == null  || xmlStr == "" ) return;
	  	    try {
	            var xmlDoc = ComGetXmlDoc(xmlStr);
	            if (xmlDoc == null) return;
	            var xmlRoot = xmlDoc.documentElement;
	            
	  	        var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
	  	        if(dataNode == null) return "";
	  	        return dataNode.getAttribute("TOTAL");
	  	    } catch(err) { ComFuncErrMsg(err.message); }
	  	} 
	    /**
	  *  sXml에서 MESSAGE 내용을 추출 
	  * @param sXml
	  * @return Sring MESSAGE
	  * @author 김종옥
	  */
     function ComOpfGetMessageFromXml(xmlStr){
  	    if ( xmlStr == null  || xmlStr == "" ) return;
  	    try {
            var xmlDoc = ComGetXmlDoc(xmlStr);
            if (xmlDoc == null) return;
            var xmlRoot = xmlDoc.documentElement;
            
  	        var msgNode=xmlRoot.getElementsByTagName("MESSAGE").item(0);
  	        if(msgNode == null) return "";
  	        return msgNode.firstChild.nodeValue;
  	    } catch(err) { ComFuncErrMsg(err.message); }
  	} 
      /**
       * button의 auth에 따라 class를 다르게 한다.
       * @param auth
       * @param editable
       * @return
       */
      function ComOpfSetBtnEnable( auth, editable) {
           var doc=document.all;
           var className="";
           if (!editable) {
               className="_1";
           }
           for ( var i=0; i < doc.length; i++) {
               if (doc[i].id.indexOf("btn") > -1) {
                   if (doc[i].getAttribute("auth") != undefined) {
                       var btnName=doc[i].className.substring(0,4);
                       if (doc[i].getAttribute("auth") == auth) {
                           doc[i].className=btnName+className;
                       }
                   }
               }
           }
       }
    
      /**
       *Excel 다운로드시 기본 설정
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
       function ComOpfGetExcelSet(sheetObj, paramObj){
          var doc   = document.all;
          var pageUrl = "/opuscntr/VOP_OPF_EXCEL.do?";
          
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
        	  for(var i=0; i<= sheetObj.LastCol(); i++){
           	   if ( sheetObj.GetCellProperty(0, i, "Hidden")!= "0"
                       && ! (
                       sheetObj.GetCellProperty(0, i, "Hidden")== "0" &&
                       sheetObj.GetCellProperty(0, i, "Type")== "Status"
                       )
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
        function ComOpfGetPgmTitle(sheetObj, paramObj){
           var doc=document.all;
           var pageUrl="/opuscntr/VOP_SCG_EXCEL.do?";
           /*************************** 제목처리 **********************************/
           var sTitle="";
           /*************************** 정렬처리 **********************************/
           var sTalign="center,left,right";
           var sAlign="";
           /*************************** Col수 처리 **********************************/
           var sCols="";
           var iCols=0;
           /*************************** 용지방향 처리 **********************************/        
           var sOrientation="";
           /*************************** 특정지정 컬럼들 width 처리 **********************************/        
           var sColumnwidth="";
           /*************************** 특정지정 Row 들 Height 처리 **********************************/        
           var sDatarowheight="";
           if(paramObj.title == undefined ){
               sTitle=doc.title.innerHTML.replace("&nbsp;","");
               sTitle=sTitle.replace("&amp;"," ");
           }else{
               sTitle=paramObj.title;
           }
           if(paramObj.align == undefined ){
               sAlign="center"; 
           }else if(sTalign.indexOf(paramObj.align) == -1 ){
               sAlign="left";
           }else{
               sAlign=paramObj.align;
           }
           if(paramObj.cols == undefined ){
               for(var i=0; i<= sheetObj.LastCol(); i++){
   	        	if ( sheetObj.GetCellProperty(0, i, "Hidden")!= "0"
   	                && ! (
   	                sheetObj.GetCellProperty(0, i, "Hidden")== "0" &&
   	                sheetObj.GetCellProperty(0, i, "Type")== "Status" )
   	              )
               	{
                       iCols++;
                   }
               }
           }else{
               iCols=eval(paramObj.cols);
           }
           if(paramObj.orientation == undefined ){
               sOrientation="Landscape";
           }else{
               sOrientation=paramObj.orientation;
           }
           if(paramObj.columnwidth == undefined ){
               sColumnwidth="";
           }else{
               sColumnwidth=paramObj.columnwidth;
           }
           if(paramObj.datarowheight == undefined ){
               sDatarowheight="";
           }else{
               sDatarowheight=paramObj.datarowheight;
           }        
           var sUrl=pageUrl+"title="+sTitle+"&align="+sAlign+"&orientation="+sOrientation+"&cols="+iCols+"&columnwidth="+sColumnwidth+"&datarowheight="+sDatarowheight;
           return sUrl;
        }
        
        /**
         * 엑셀다운로드 픽셀조정 
         * IBSHEET 가 100 이라면 엑셀은 13.34이다 즉, 넓이를 0.134 로 곱해서 조정해야 제대로된 엑셀WIDTH를 구할 수 있다 
         */
        function ComOpfGetExcelDown(sheetObj){
        	var resultStr = "";
   		var colAry = new Array();
   		colAry = makeHiddenSkipCol(sheetObj).split("|");
   		
   		for(var i=0; i<colAry.length; i++){
   			var colWidth = sheetObj.GetCellProperty(0, colAry[i], "Width");
   			var cwi = Number(colWidth) * 0.134;	//SHEET의 width=100은 엑셀의 width=13.34와 근사치이다

   			resultStr += Number(i+1) + ":" + cwi;
   			if(i < colAry.length - 1){
   				resultStr += "|";
   			}
   		}
   		
   		return resultStr;
   	}
        
        /**
         * 엑셀다운로드 픽셀조정 
         * 히든컬럼을 제외한 엑셀다운로드 컬럼의 갯수를 구한다
         */
        function ComOpfGetExcelDownCols(sheetObj){
   		var colAry = new Array();
   		colAry = makeHiddenSkipCol(sheetObj).split("|");
   		
   		return colAry.length-1;
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
    		var rtnArr=new Array();
    		if (xmlStr == null || xmlStr == "" || colList == null || colList == "") {
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
    			var dataChileNodes=dataNode.childNodes;
    			if (dataChileNodes == null) {
    				return;
    			}
    			var colListArr=colList.split("|");
    			var colListIdx=Array();
    			for ( var i=0; i < colListArr.length; i++) {
    				for ( var j=0; j < colArr.length; j++) {
    					if (colListArr[i] == colArr[j]) {
    						colListIdx[i]=j;
    						break;
    					}
    				}
    			}
    			var k = 0;
    			for ( var i=0; i < dataChileNodes.length; i++) {
    				if (dataChileNodes[i].nodeType != 1) {
    					k++;
    					continue;
    				}
    				var arrData=dataChileNodes[i].firstChild.nodeValue.split(sep);
    				var subDataArr=new Array();
    				for ( var j=0; j < colListIdx.length; j++) {
    					subDataArr[j]=arrData[colListIdx[j]];
    				}
    				rtnArr[i-k]=(subDataArr);
    			}
    		} catch (err) {
    			ComFuncErrMsg(err.message);
    		}
    		return rtnArr;
    	}