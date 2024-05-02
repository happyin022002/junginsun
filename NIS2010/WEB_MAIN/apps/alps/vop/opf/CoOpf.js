/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CoOpf.js
*@FileTitle : OPF 공통 자바스크립트
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.08
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.08 우지석
* 1.0 Creation 
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
* 2011.08.24 김민아 [CHM-201113050-01] [VOP-OPF] RDR Inquiry 로직 변경 : Message OPF50030 추가
* 2011.12.12 김민아 [CHM-201114776-01] [VOP-OPF] TOR Creation 메뉴 수정 및 프린트 화면 변경 요청건 : TDR->TOR
* 2012.02.23 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
* 2012.04.06 김민아 [선반영] Port Time Activity Creation by VVD 로직 수정 (OPF50031, OPF50032 수정)
* 2012.09.05 김상근 [CHM-201220011] [TOR]: Port Time Activity 입력값 validation 변경(OPF50032 수정, OPF50034 추가)
* 2013.11.25 임옥영 [CHM-201327237] OPF50040 추가 
*  
=========================================================*/

	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 메시지코드와 각종 메시지 처리 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	
	// var msgs = new Array();
	// OPF공통
    msgs['OPF00001'] = 'No data found.({?msg1})';
	msgs['OPF50001'] = 'Do you want to save {?msg1}?';
	msgs['OPF50002'] = 'Do you want to delete {?msg1}?';
	msgs['OPF50003'] = 'Data was changed. Do you want to save it?';
	msgs['OPF50004'] = '{?msg1} is invalid.';
	msgs['OPF50005'] = '{?msg1} is duplicated.';
	msgs['OPF50006'] = '{?msg1} was saved successfully.';
	msgs['OPF50007'] = '{?msg1} must be at least {?msg2} characters long.';
	msgs['OPF50008'] = '{?msg1} must be either {?msg2} or {?msg3} characters long.';
	msgs['OPF50009'] = 'Please input {?msg1}.';
	msgs['OPF50010'] = 'The added weight group should be less than over the weight group.';
	msgs['OPF50011'] = '"From" of the last row should be zero(0).';
	msgs['OPF50012'] = '"To" of the last row should not be zero(0).';
	msgs['OPF50013'] = '"{?msg1}" should be later than "{?msg2}".';
	msgs['OPF50014'] = 'Booking data was imported successfully.';
	msgs['OPF50015'] = 'There is no corresponding data for the search. For a TOR creation in the subject port manually, Arrival/Departure Time & Vessel Condition will be imported from Actual SKD & COND.';
	msgs['OPF50016'] = 'The Volume will be change with the volume from BKG data.\nDo you want to Import Data?';
	msgs['OPF50017'] = 'No approval from PUSMOV yet for the unknown responsible party.\nPlease request PUSMOV to give confirmation for this damage case before proceeding to the next process.';
	msgs['OPF50018'] = '"Damage Date" should be from ETA {?msg1} to ETD {?msg2}.';
	msgs['OPF50019'] = 'There is previously saved CBF. Do you want to change CBF?';
	msgs['OPF50020'] = '"{?msg1}" process step should be saved for the first step.';
	msgs['OPF50021'] = 'In view of the data processing time, inquiry period will be limited to one year.';
    msgs['OPF50022'] = '"{?msg1}" must be less than {?msg2}';
    msgs['OPF50023'] = 'Rows will be saved up to "{?msg1}" at most.';
    msgs['OPF50024'] = '"{?msg1}" exceeds field length.';
    msgs['OPF50025'] = '{?msg1} Row [{?msg2}] is mandatory item.';
    msgs['OPF50026'] = '{?msg1} can not be deleted.';
    msgs['OPF50027'] = 'Damage date is not within the port time. Please check it again.';
    msgs['OPF50028'] = 'The virtual port is not available. Please select port again.';   
    msgs['OPF50029'] = 'There is no data to save.';   
    msgs['OPF50030'] = "Can't find created RDR as {?msg1}.";
    msgs['OPF50031'] = 'Please input "{?msg1}" within ±72 hours of "{?msg2}".';
    msgs['OPF50032'] = 'Performance maximum duration can not be longer than 168 hours.\nPlease check "{?msg1}" and "{?msg2}"';
    msgs['OPF50033'] = '"{?msg1}" should be faster than "{?msg2}".';
	msgs['OPF50034'] = 'Please input "{?msg1}" within ±120 hours of "{?msg2}".';
	msgs['OPF50035'] = 'Work Commenced time should be between \n\n[ "{?msg1}" ] and [ "{?msg2}"]';	
    msgs['OPF50036'] = 'Performance maximum duration can not be longer than 360 hours.\nPlease check "{?msg1}" and "{?msg2}"';
	msgs['OPF50037'] = 'Please input "{?msg1}" within ±360 hours of "{?msg2}".';
	msgs['OPF50038'] = '"{?msg1}" or "{?msg2}" process step should be saved for the first step.';
	msgs['OPF50039'] = 'From Date is Later than To Date.';
	msgs['OPF50040'] = 'To week must be later than From week.';
	msgs['OPF50041'] = '{?msg1} is invalid. \n\nPlease check "{?msg2}".';	
	msgs['OPF50042'] = 'Total Lost time by G/crane exceeds terminal working time.';	
	msgs['OPF50043'] = "Input Move only. Don't input Uint.";	
    msgs['OPF50044'] = "Please enter value format as {?msg1}.";
    msgs['OPF50045'] = "There is no {?msg1}.";
    msgs['OPF50046'] = "Do you want to Submit ?";
    msgs['OPF50047'] = "Do you want to Delete ?";
    msgs['OPF50048'] = "Can't find container[{?msg1}] position.";

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
					frmchild.checked = (sheetvalue==1);
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
     * IBSheet에서 주어진 조건에 맞는 행 또는 모든 데이터행을 조회XML로 구성하여 반환한다. <br>
     * saveColName 파라미터를 이용하여 원하는 컬럼을 지정할수 있고, <br>
     * sCol, sValue 파라미터를 이용하여 원하는 행의 조건을 줄수 있다.(필터링) <br>
     * saveColName의 값이 없으면 전체 컬럼을 대상으로 진행되고, <br>
     * sCol, sValue 값이 없으면 전체 행을 대상으로 진행된다. <br>
     * Sheet의 전체 데이터에 대해 스캔이 이루어지므로, 데이터양이 너무 많을 경우 속도가 저하될수 있음에 유의한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriSheet2Xml(sheetObj);
     *     sXml = ComPriSheet2Xml(sheetObj, "col1|col2|col3|col4");
     *     sXml = ComPriSheet2Xml(sheetObj, null, "svc_scp_cd|gline_seq", "ACE|1", true);
     * </pre>
     * @param {ibsheet} sheetObj    필수,IBSheet Object
     * @param {string}  saveColName 선택,특정 컬럼만 배열로 만들경우 SaveName을 "|"로 연결한 문자열 설정
     *                              지정하지 않으면, 전체 컬럼을 대상으로 한다.
     * @param {string}  sCol        선택, 행조회시 기준이 되는 컬럼의 SaveName. "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {string}  sValue      선택, 행조회시 기준이 되는 컬럼의 값(Value). "|"로 연결
     *                              지정하지 않으면, 전체 행을 대상으로 한다.
     * @param {bool}    bRowDel     선택, 원본행삭제여부, default=false.
     * @param {bool}    bIsStyled   선택, 열과 행의 색상 Editable정보 포함 여부, default=false. ComPriSheet2StyledXml 참조
     * @return string,  Sheet의 데이터를 조회XML로 구성한 문자열
     * @author 박성수
     * @version 2009.05.07
     */
    function ComOpfSheet2Xml(sheetObj, saveColName, sCol, sValue, bRowDel, bIsStyled)  {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT") {
                return "";
            }

            var allXml = "";
            var sColSep = "☜☞";
            var allRows = false;
            var arrPrcdRow = new Array();

            if (saveColName == undefined || saveColName == null || saveColName == "") {
                saveColName = IBS_ConcatSaveName(sheetObj);
            }

            var arrCol = saveColName.split("|");

            var condNames = new Array();
            var condValues = new Array();
            if (sCol == undefined || sCol == null || sCol == "" || sValue == undefined || sValue == null || sValue == "") {
                allRows = true;
            } else {
                condNames = sCol.split("|");
                condValues = sValue.split("|");
            }

            var aryTR  = new Array();
            var aryTD = new Array(arrCol.length);

            if (sheetObj.RowCount > 0) {
                for (var i = sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
                    var isMatch = true;
                    if (!allRows) {
                        for (var j = 0; j < condNames.length; j++) {
                            isMatch = true;
                            if (sheetObj.CellValue(i, condNames[j]) != condValues[j]) {
                                isMatch = false;
                                break;
                            }
                        }
                    }

                    if (!isMatch) {
                        continue;
                    }

                    if (bIsStyled) {
                        var sheetFontColor = sheetObj.SysColor2WebColor(sheetObj.DataFontColor);
                        var sheetBackColor = sheetObj.SysColor2WebColor(sheetObj.DataBackColor);
                        var sheetBackColorAlt = sheetObj.SysColor2WebColor(sheetObj.DataAltanateBackColor);

                        var sTr = "";
                        sTr += "\t<TR";
                        var rowFontColor = sheetObj.SysColor2WebColor(sheetObj.RowFontColor(i));
                        if (rowFontColor !=  "" && rowFontColor != sheetFontColor) {
                            var radixVal = parseInt(rowFontColor.substring(0, 2), 16) + "," + parseInt(rowFontColor.substring(2, 4), 16) + "," + parseInt(rowFontColor.substring(4, 6), 16);
                            sTr += " COLOR=\"" + radixVal + "\"";
                        }

                        var rowBackColor = sheetObj.SysColor2WebColor(sheetObj.RowBackColor(i));
                        if (rowBackColor !=  "" && rowBackColor != sheetBackColor && rowBackColor != sheetBackColorAlt) {
                            var radixVal = parseInt(rowBackColor.substring(0, 2), 16) + "," + parseInt(rowBackColor.substring(2, 4), 16) + "," + parseInt(rowBackColor.substring(4, 6), 16);
                            sTr += " BGCOLOR=\"" + radixVal + "\"";
                        }

                        var rowEditable = new String(sheetObj.RowEditable(i)).toUpperCase();
                        sTr += " EDIT=\"" + rowEditable + "\"";

                        for (var j = 0; j < arrCol.length; j++) {
                            aryTD[j] = "";
                            aryTD[j] += "\t\t<TD";

                            var cellFontColor = sheetObj.SysColor2WebColor(sheetObj.CellFontColor(i, arrCol[j]));
                            if (cellFontColor !=  "" && cellFontColor != sheetFontColor && cellFontColor != rowFontColor) {
                                var radixVal = parseInt(cellFontColor.substring(0, 2), 16) + "," + parseInt(cellFontColor.substring(2, 4), 16) + "," + parseInt(cellFontColor.substring(4, 6), 16);
                                aryTD[j] += " COLOR=\"" + radixVal + "\"";
                            }

                            var cellBackColor = sheetObj.SysColor2WebColor(sheetObj.CellBackColor(i, arrCol[j]));
                            if (cellBackColor !=  "" && cellBackColor != sheetBackColor
                                    && cellBackColor != sheetBackColorAlt && cellBackColor != rowBackColor) {
                                var radixVal = parseInt(cellBackColor.substring(0, 2), 16) + "," + parseInt(cellBackColor.substring(2, 4), 16) + "," + parseInt(cellBackColor.substring(4, 6), 16);
                                aryTD[j] += " BGCOLOR=\"" + radixVal + "\"";
                            }

                            var cellEditable = new String(sheetObj.CellEditable(i, arrCol[j])).toUpperCase()
                            if (cellEditable !=  "" && cellEditable != rowEditable) {
                                aryTD[j] += " EDIT=\"" + cellEditable + "\"";
                            }

                            if (sheetObj.ToolTipText(i, arrCol[j]) != "") {
                                var sTxt = sheetObj.ToolTipText(i, arrCol[j]).replace(/&/g, "&amp;").replace(/\"/g, "&quot;").replace(/</g, "&lt;").replace(/>/g, "&gt;");
                                aryTD[j] += " TOOL-TIP=\"" + sTxt + "\"";
                            }

                            aryTD[j] += "><![CDATA[" + new String(sheetObj.CellValue(i, arrCol[j])) + "]]></TD>";
                        }

                        sTr += ">\n" + aryTD.join("\n")+ "\t</TR>";

                        aryTR.push(sTr);
                    } else {
                        for (var j = 0; j < arrCol.length; j++) {
                            aryTD[j] = String(sheetObj.CellValue(i, arrCol[j]));
                        }
                        aryTR.push("\t<TR><![CDATA[" + aryTD.join(sColSep)+ "]]></TR>");
                    }

                    arrPrcdRow.push(i);
                }
            }

            allXml += "<?xml version='1.0'  ?>\n";
            allXml += "<SHEET>\n";
            allXml += "  <DATA TOTAL='" + arrPrcdRow.length + "' COLORDER='" + saveColName + "'";
            if (!bIsStyled) {
                allXml += " COLSEPARATOR='" + sColSep + "'";
            }
            allXml += ">\n";
            allXml += aryTR.join("\n");
            allXml += "  </DATA>\n";
            allXml += "</SHEET>";

            if (bRowDel) {
                if (allRows) {
                    sheetObj.RemoveAll();
                } else {
                    sheetObj.Redraw = false;
                    sheetObj.RedrawSum = false;
                    for(var i = arrPrcdRow.length - 1; i >= 0; i--){
                        sheetObj.RowDelete(arrPrcdRow[i], false);
                    }
                    sheetObj.RedrawSum = true;
                    sheetObj.Redraw = true;
                }
            }

            return allXml;
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
    /**
     * 주어진 sheetObj에 IBSheet의 SearchXM을 로드한다. <br>
     * AppendMode에 따라 원본sheet 내용의 전체 또는 일부분을 클리어하고 로드하거나, Append할 수 있다.<br>
     * <br><b>Example :</b>
     * <pre>
     *     sXml = ComPriXml2Sheet(sheetObj, sXml);
     *     sXml = ComPriXml2Sheet(sheetObj, sXml, 2);
     *     sXml = ComPriXml2Sheet(sheetObj, sXml, 1, "svc_scp_cd|gline_seq", "ACE|1");
     * </pre>
     * @param {ibsheet} sheetObj    필수, IBSheet Object
     * @param {string}  sXml        필수, Sheet에 로드할 Search XML.
     * @param {int}    bAppendMode  선택, 원본Sheet(sheetObj)의 내용의 처리방법. default=0<br>
     *                              0 : Clear, 원본Sheet의 내용을 모두 삭제하고 sXml의 내용을 sheetObj에 Load한다.<br>
     *                              1 : Replace, 원본Sheet의 내용 중, sCol/sValue의 조건에 해당하는 부분만 삭제하고 Load.<br>
     *                              2 : Append, 원본Sheet의 내용을 변경하지 않고, 뒷부분에 Append한다.
     * @param {string}  sCol        선택, bAppendMode가 1일 경우, 삭제 대상이 되는 조건 컬럼의 SaveName. "|"로 연결.
     * @param {string}  sValue      선택, bAppendMode가 1일 경우, 삭제 대상이 되는 조건의 값. "|"로 연결.
     * @return 없음.
     * @author 박성수
     * @version 2009.05.13
     */
    function ComOpfXml2Sheet(sheetObj, sXml, bAppendMode, sCol, sValue)  {
        try {
            if (typeof sheetObj != "object" || sheetObj.tagName != "OBJECT"  || sXml == undefined || sXml == null || sXml == "") {
                return;
            }
            if (bAppendMode == undefined || bAppendMode == null || bAppendMode == "") {
                bAppendMode = 0;
            }

            if (bAppendMode == 0) {
                sheetObj.RemoveAll();
            } else if (bAppendMode == 1) {
                var arrCol = sCol.split("|");
                var arrValue = sValue.split("|");

                for (var i = sheetObj.LastRow; i >= sheetObj.HeaderRows; i--) {
                    var isMatch = true;
                    for (var j = 0; j < arrCol.length; j++) {
                        if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        sheetObj.RowDelete(i, false);
                    }
                }
            }

            sheetObj.LoadSearchXml(sXml, true);

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
		
		var regexp = RegExp(/&/g);
		sStr = sPrefix + sStr.replace(regexp, "&" + sPrefix);
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
		
		var rtnArr = new Array();
		var arrCol = sCol.split("|");
		var arrValue = sValue.split("|");
		
		
		for (var i = 1; i < sheetObj.Rows; i++) {
			var isMatch = true;
			for (var j = 0; j < arrCol.length; j++) {
				if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
					isMatch = false;
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
		
		var arrCol = sCol.split("|");
		var arrValue = sValue.split("|");
		var firstRow = -1;
		
		for (var i = 1; i < sheetObj.Rows; i++) {
			var doHide = false;
			for (var j = 0; j < arrCol.length; j++) {
				if (sheetObj.CellValue(i, arrCol[j]) != arrValue[j]) {
					doHide = true;
					break;
				}
			}
			if (!doHide && firstRow == -1) {
				firstRow = i;
			}
			sheetObj.RowHidden(i) = doHide;
		}
		
		if (firstRow > 0) {
			sheetObj.SelectRow = firstRow;
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
		var idx = sheetObjM.SelectRow;
		var arrCol = sCol.split("|");
		var sValue = "";
		
		for (var i = 0; i < arrCol.length; i++) {
			sValue += sheetObjM.CellValue(idx, arrCol[i]);
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
		var max = 0;
		for (var i = 1; i < sheetObj.Rows; i++) {
			if (parseInt(sheetObj.CellValue(i, sCol)) > max) {
				max = sheetObj.CellValue(i, sCol);
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
		 var sheetObject1 = sheetObjects[0];

		 Col = -1;
		 aryCol = ColStr.split("|");
		 ColStr = "";

		 //첫번째 컬럼을 찾고, 나머지 가능한 유효 컬럼을 찾는다
		 for (ic=0; ic < aryCol.length; ic++) {
			 if (aryCol[ic] >= 0 && aryCol[ic] <= sheetObject1.LastCol)
			 {
				 if (Col == -1)
					 Col = aryCol[ic];
				 else
					 ColStr += (ColStr==""?"":"|") + aryCol[ic];
			 }
		 }

		 //한개 컬럼의 중복 여부를 확인하는 경우
		 if (ColStr == "") {
			 if (Col != -1) return sheetObject1.ColValueDup(Col);

			 //다중 컬럼의 중복 여부를 확인하는 경우
		 } else {
			 aryCol = ColStr.split("|")

			 for (ir = 1; ir<= sheetObject1.LastRow; ir++) {
				 //첫번째 컬럼의 값으로 중복된 행번호를 가져옴
				 sText = sheetObject1.CellText(ir, Col);
				 Row = sheetObject1.FindText(Col, sText, ir + 1, true);

				 //해당 값으로 중복된 모든 행을 확인
				 while (Row > 0) {
					 bNext = false;

					 //중복된 행이 있는 경우 나머지 컬럼 값 일치 여부 확인
					 for (ic=0; ic<aryCol.length; ic++){
						 if (sheetObject1.CellText(ir, aryCol[ic]) != sheetObject1.CellText(Row, aryCol[ic]) ){
							 //하나라도 값이 다르면 그냥 처리 중단, 다음 중복 확인
							 bNext = true;
							 break;
						 }
					 }

					 //모든 컬럼 값이 같으므로 중복 행번 반환
					 if (bNext == false) return Row;

					 Row = sheetObject1.FindText(Col, sText, Row + 1, true);
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
			 selColName = "sel_chk";
		 }
		 
		 ComRowHideDelete(sheetObj, selColName);
	 }

	  /*function deleteRowCheck(sheetObj, selColName, delColName) {

	      if (arguments.length == 1) {
	          selColName = "sel_chk";
	          delColName = "del_chk";
	      }
	      var chkdRows = sheetObj.FindCheckedRow(selColName);
	      var arr = chkdRows.split("|");
	      var cnt = arr.length;

	      for(var i = cnt-1; i >= 0; i--){
	          if(arr[i] != ''){
	              if(sheetObj.LastRow == arr[i] && sheetObj.RowStatus(arr[i]) == "I"){ 
	                  sheetObj.RowStatus(arr[i]) = "D"; 
	              } 
	              else{ 
	                  sheetObj.CellValue2(arr[i], delColName) = 1; 
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
     	var showCol = 0;
     	var bFlag = false;
     	if (sCol != "undifind" && sCol !=""){
     		showCol = sCol;
     	}    	
     	if (iBlank != "undifind" && iBlank !=""){
     		bFlag = iBlank;
     	}    	
 		var arrData = ComPriXml2ComboString(sXml, "cd", "nm");
 		if (bFlag == true){
 			arrData[1] =" \t |"+ arrData[1];
 			arrData[0] =" |"+ arrData[0];
 		}
 		sheetObj.InitDataCombo(0,title, arrData[1], arrData[0], " ", " ", showCol);			
    }

	   /**
	    *  Xml에서 Total 건수  가져오기 
	    * @param xmlStr
	    * @param savename
	    * @return value    
	    * @author jkc
	    */      
	    function ComOpfGetTotalValue(sXml){
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
	  *  sXml에서 MESSAGE 내용을 추출 
	  * @param sXml
	  * @return Sring MESSAGE
	  * @author 김종옥
	  */
     function ComOpfGetMessageFromXml(sXml){
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
       * button의 auth에 따라 class를 다르게 한다.
       * @param auth
       * @param editable
       * @return
       */
      function ComOpfSetBtnEnable( auth, editable) {
           var doc = document.all;
           var className = "";
 
           if (!editable) {
               className = "_1";
           }

           for ( var i = 0; i < doc.length; i++) {
               if (doc[i].id.indexOf("btn") > -1) {
                   if (doc[i].getAttribute("auth") != undefined) {
                       var btnName   = doc[i].className.substring(0,4);

                       if (doc[i].getAttribute("auth") == auth) {
                           doc[i].className = btnName+className;
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
          var pageUrl = "VOP_OPF_EXCEL.do?";
          
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
       
        
       /** Copy&Paste시 입력문자 제약유지 기능, 멀티콤보에 숫자만 입력 가능하게 수정
        *  combo1_OnKeyDown()에서 호출
        *  @param allowedPattern : 영문대문자(A), 영문소문자(a), 숫자(0), 한글(가)
        *  	-> 영문대문자 및 숫자 입력 가능 : "A|0"    ('|' 로 연결)	
        *  	-> 영문대소문자, 한글 입력 가능 : "A|a|가" ('|' 로 연결)	
        */ 
       function ComOpfSetComboPastePattern(comboObj, KeyCode, Shift, allowedPattern){

       	if(KeyCode == 8 || KeyCode == 46 || KeyCode == 16){	//Back Space, Delete, Shift
       		comboObj.Style = 0;		//Enabled
       		return;
       	}
       	
       	var ok = true;
       	allowedPattern = "|" + allowedPattern + "|";
       	var ENG_CAPITAL = allowedPattern.indexOf("|A|")  > -1 ? true : false;
       	var ENG_SMALL 	= allowedPattern.indexOf("|a|")  > -1 ? true : false;
       	var DIGIT 		= allowedPattern.indexOf("|0|")  > -1 ? true : false;
       	var HANGUL 		= allowedPattern.indexOf("|가|") > -1 ? true : false;

       	if(Shift == 2){		//KeyCode와 동시에 Ctrl키를 누른 경우	
       		var val = window.clipboardData.getData('Text');	//ClipBoard
       		for(i=0; i<val.length; i++){
       			if(val.charCodeAt(i) >= 65 && val.charCodeAt(i) <= 90){					//영대문자
       				ok = ENG_CAPITAL;
       			} else if(val.charCodeAt(i) >= 97 && val.charCodeAt(i) <= 122){			//영소문자
       				ok = ENG_SMALL;
       			} else if(val.charCodeAt(i) >= 48 && val.charCodeAt(i) <= 57){			//숫자
       				ok = DIGIT;
       			} else if(val.charCodeAt(i) >= 44032 && val.charCodeAt(i) <= 55203){	//한글
       				ok = HANGUL;
       			} else{
       				ok = false;
       			}
       			
       			if(ok == false){
       				break;
       			}
       		}
       	} else{				//KeyCode만 누른 경우	
       		if(DIGIT && !ENG_CAPITAL && !ENG_SMALL && !HANGUL){		//오직 숫자만 입력받는 경우 (IBCombo 자체에 숫자만 입력받는 기능이 없으므로, 나머지 제약은 AXON 이용)
       			if((KeyCode >= 48 && KeyCode <= 57) || (KeyCode >= 96 && KeyCode <= 105)){
       				ok = DIGIT;
       			} else{
       				ok = false;
       			}
       		}
       	}	
       	
       	if(ok == true){
       		comboObj.Style = 0;		//Enabled
       	} else{			
       		comboObj.Style = 1;		//Disabled
       	}	
       }
       
       
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
   	function ComOpfCopyRowToForm(sheetobj, formobj, row, prefix){
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