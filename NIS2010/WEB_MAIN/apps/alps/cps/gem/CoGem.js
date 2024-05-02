/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CoGem.js
 *@FileTitle : Gem Common javascript
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * ---------------------------------------------------------------------------
 * History
 * 2010.09.17 이준범 [CHM-201006046-01] toLclAmt , toUsdAmt 는 모두  fmLclAmt(fmUsdAmt) 기준으로 생성한다.
 * 2011.02.17 이준범 [CHM-201108627-01] Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 2102.05.29 이준범 [CHM-201218022-01] Message 추가
 * msgs["GEM01096"] = "{?msg1} Slip I/F failed out of total {?msg2}{?msg3}";
 * 2014.10.23 이준범 [CHM-201432508-01]
 * 제목: [GEM] 결산작업을 위한 데이터 업데이트
 * 보완: SELPLI 하드코딩 부분 삭제 
=========================================================*/
// --------------------------------------------------------
// 권한설정
// --------------------------------------------------------
var USR_AUTH_TP_CD = "S";


// --------------------------------------------------------
// 메세지 관련
// 샘플 msgs["GEM01001"] = "{?msg1} {?msg2}하십시오.";
// -------------------------------------------------------
	msgs["GEM00001"] = "{?msg1} data is invalid.";
	msgs["GEM00002"] = "{?msg1} is duplicated.";
	msgs["GEM00003"] = "Please Fill all required entry fields {?msg1}.";
	msgs["GEM00004"] = "{?msg1} You have no authority to request, Please check your authorization";
	msgs["GEM00005"] = "{?msg1} Inserted data exceeds field length.";
	msgs["GEM00006"] = "Do you want to initialize unsaved data ?";
	msgs["GEM00008"] = "Data was saved successfully.";
	msgs["GEM00009"] = "Please input {?msg1}";
	msgs["GEM00010"] = "Data was deleted successfully.";
	msgs["GEM00011"] = "Do you want to initialize unsaved data ?";
	msgs["GEM00012"] = "Do you want to save it?";
	msgs["GEM00013"] = "There is no data to search.";
	msgs["GEM00014"] = "Do you want to execute?";
	msgs["GEM00015"] = "Do you want to initialize?";
	msgs["GEM00016"] = "Do you want to delete it?";
	msgs["GEM01001"] = "The information for Divided by office is duplicated.";
	msgs["GEM01002"] = "Do you want to change the expense code?";
	msgs["GEM01004"] = "The expense code doesn't exist.";
	msgs["GEM01005"] = "Check the date - inserted date must be after closing date.";
	msgs["GEM01006"] = "You have no authority to create.\r\nPlease contact the system adminstrator";
	msgs["GEM01007"] = "You should select either USD or KRW";
	msgs["GEM01008"] = "Currency code is duplicated. Please check the code.";
	msgs["GEM01009"] = "Currency code is invalid. Please refer to the currency code.";
	msgs["GEM01010"] = "The information for Divided by office doesn't exist";
	msgs["GEM01011"] = "Please input the expense code";
	msgs["GEM01012"] = "Failed to retrieve account code. Please try again";
	msgs["GEM01013"] = "Account code was deleted at {?msg1}";
	msgs["GEM01014"] = "Account code used at {?msg1}";
	msgs["GEM01015"] = "Office code doesn't exist.";
	msgs["GEM01016"] = "Office code you have inserted was already deleted.";
	msgs["GEM01017"] = "Please input office code.";
	msgs["GEM01018"] = "The information for Divided by office is duplicated.";
	msgs["GEM01019"] = "The expense code doesn't exist.";
	msgs["GEM01020"] = "Account code is duplicated in account information.";
	msgs["GEM01021"] = "Office and Account code are duplicated in divided by office.";
	msgs["GEM01022"] = "Do you want to save it?";
	msgs["GEM01023"] = "There is no data to search.";
	msgs["GEM01024"] = "Currency code is duplicated. Please check the code.";
	msgs["GEM01025"] = "Currency code is invalid. Please refer to the currency code.";
	msgs["GEM01026"] = "Do you want to initialize unsaved data ?";	
	msgs["GEM01028"] = "Do you want to initialize unsaved data ?";
	msgs["GEM01029"] = "Do you want to save changed data?";
	msgs["GEM01030"] = "Invalid date, Inserted date must be after closing date.";
	msgs["GEM01031"] = "Invalid closing date, Please check the date and try it again.";
	msgs["GEM01032"] = "Please input closing date.";
	msgs["GEM01033"] = "Please first uncheck the CLS MK.";
	msgs["GEM01034"] = "Please first check the G/L I/F.";
	msgs["GEM01035"] = "Please uncheck the CLS MK.";
	msgs["GEM01037"] = "To expense code is greater than From expense code. Please try it again.";
	msgs["GEM01038"] = "Please select {?msg1}";
	msgs["GEM01039"] = "Inserted expense code is not allowed to input in your office code.\r\nif you want to create a new expense matrix,\r\nplease click on \"Request for Expense Code\" button.";
	msgs["GEM01040"] = "Request Amount and Request Total amount are not the same. Please check again.";
	msgs["GEM01041"] = "Data was deleted successfully.";
	msgs["GEM01042"] = "If you want to change request office, you should delete blank rows of request expense code";
	msgs["GEM01043"] = "Do you want to delete Request No.?";
	msgs["GEM01046"] = "Please select assigned expense of from expense code.";
	msgs["GEM01048"] = "Please input Common & Sales expense code";
	msgs["GEM01049"] = "Please input Common & Management expense code";
	msgs["GEM01050"] = "Inserted amount excceded assigned expense amount";
	msgs["GEM01053"] = "FM RQST Amount and FM RQST TTL are unmatched. Please check again.";
	msgs["GEM01054"] = "TO RQST and TO RQST TTL are unmatched. Please check it again.";
	msgs["GEM01055"] = "Please input Account Information or Divided Information.";
	msgs["GEM01056"] = "There is no updated data to save";
	msgs["GEM01056"] = "There is no updated data to save";
	msgs["GEM01057"] = "Data was changed. Do you want to save ?";
	msgs["GEM01058"] = "Are you sure to delete all items?\r\nAll items in a request no. will be deleted.\r\nIf you want to delete one item by item,\r\nplease click on \"Row Delete\" button.";
	msgs["GEM01059"] = "Failed to download. Please try again.";
	msgs["GEM01060"] = "Data was downloaded successfully.";
	msgs["GEM01061"] = "G/L Performance was completed successfully.";
	msgs["GEM01062"] = "There is no data for G/L Performance";
	msgs["GEM01063"] = "Please first check the  Performance(Subsidiary) CLS_MK.";
	msgs["GEM01064"] = "Please input Year";
	msgs["GEM01065"] = "Please input Month";
	msgs["GEM01066"] = "Please select an office type.";
	msgs["GEM01067"] = "{?msg1}th Row[Reason] is mandatory. Please input Reason.";
	msgs["GEM01068"] = "Please input Month";
	msgs["GEM01069"] = "Please input same year";
	msgs["GEM01070"] = "Invalid period, Please check the period and try it again.";
	msgs["GEM01071"] = "Please input Month";
	msgs["GEM01072"] = "Please input same year";
	msgs["GEM01073"] = "Invalid period, Please check the period and try it again.";
	msgs["GEM01074"] = "You should select either USD or KRW";
	msgs["GEM01075"] = "Invalid period, Please check the period and try it again.";
	msgs["GEM01076"] = "Please select a item";
	msgs["GEM01077"] = "Period is mandatory. Please input period.";
	msgs["GEM01078"] = "Invalid period, Please check the period and try it again.";
	msgs["GEM01079"] = "You should select either USD or KRW";
	msgs["GEM01080"] = "The requested amount can't be exceeded the assigned amount.";
	msgs["GEM01081"] = "The requested amount exceed the remainder. only possible within the remainder";
	msgs["GEM01082"] = "Please input the Opinion";
	msgs["GEM01083"] = "You should select LCL and retrieve";
	msgs["GEM01084"] = "You should select either Reject or Approval";
	msgs["GEM01085"] = "Month exceeds maximum duration 3 months.";
	msgs["GEM01086"] = "There is no data to print.";
	msgs["GEM01087"] = "There is no contents to save.";
	msgs["GEM01088"] = "The request no doesn't exist.";
	msgs["GEM01089"] = "Data was already amended by the other user. \nRevised data will be displayed";	
	msgs["GEM01090"] = "Request office can not proceed \"Reject\". \nPlease use the \"Adjustment\" function.";
	msgs["GEM01091"] = "Your office has no authority to access GEM. \nIf you need to access GEM system, \nplease contact committee.";
	msgs["GEM01092"] = "Duplicated slip number found, pls check.\n[{?msg1}]";
	msgs["GEM01093"] = "G/L Effective date out of this month found, pls check.";
	msgs["GEM01094"] = "Incorrect office code found, pls check.";
	msgs["GEM01095"] = "Incorrect center code found, pls check";
	msgs["GEM01096"] = "{?msg1} Slip I/F failed out of total {?msg2}{?msg3}";
	msgs["GEM01097"] = "INV Amount and INV Amount(LCL) are unmatched.\n Please check again.";
	msgs["GEM01098"] = "Csr No is mandatory. Please input Csr No.";
	msgs['GEM01099'] = 'The Invoice date should be less than the Input date !';
	msgs['GEM01100'] = 'You can insert Max 10 rows.';
	msgs['GEM01101'] = 'You input the wrong expense name. Please check the expense name list again.';
	msgs["GEM01102"] = "Cancel CSR No Not Allowed";


/**
 * Gem Common javascript
 * @extends
 * @class Foreign Exchange Rate Maintenance생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CoGem() {    
    this.validateForm = validateForm;
}


/**
* Gem에 존재하지 않는 office에서 로그인시 
* No Authority
*/
function goNoAuthority() {
	
	ComShowCodeMessage("GEM01091");
	
	top.location.href = "/hanjin/alpsMain.screen?parentPgmNo=CPS_GEM_M001";
    
}

/**
* VoList를 array[array[name]]형태로 변환 
* @param {xml} xmlStr 조회 결과 setRsVoList , setRsVo 
*/
function ComXml2ListMap(xmlStr) {
	
	var rtnArr = new Array();

	if (xmlStr == null || xmlStr == "") {
		return rtnArr;
	}

	try {
		var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
		xmlDoc.loadXML(xmlStr);

		var xmlRoot = xmlDoc.documentElement;
		if (xmlRoot == null) {
			return rtnArr;
		}

		var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
		if (dataNode == null || dataNode.attributes.length < 3) {
			return rtnArr;
		}

		var col = dataNode.getAttribute("COLORDER");
		var colArr = col.split("|");
		var sep = dataNode.getAttribute("COLSEPARATOR");
		var total = dataNode.getAttribute("TOTAL");

		if (total == 0) {
			return rtnArr;
		}
		
		var dataChileNodes = dataNode.childNodes;
		if (dataChileNodes == null) {
			return rtnArr;
		}

		for ( var i = 0; i < dataChileNodes.length; i++) {
			if (dataChileNodes[i].nodeType != 1) {
				continue;
			}
			
			var arrData = dataChileNodes[i].firstChild.nodeValue.split(sep);

			var subDataArr = new Array();
			
			for ( var j = 0; j < arrData.length; j++) {
				subDataArr[colArr[j]] = arrData[j];
			}
			
			rtnArr[i] = (subDataArr);
		}

	} catch (err) {
		ComFuncErrMsg(err.message);
	}

	return rtnArr;
}

/**
* Array의 name 과 HTML form의 이름이 동일할경우 form의 객체에 Value설정 
* @param {form} form html 폼 
* @param {map} Array[name] 의 값 
*/
function ComMapToForm(form, map) {		
		//사용가능한 컨트롤을 배열로 생성한다.
		var len = form.elements.length;
		for (var i = 0; i < len; i++) {
			if (form.elements[i].classid == undefined) {
				var xvalue = map[form.elements[i].name];
				if (xvalue == undefined)
					continue;
				switch (form.elements[i].type) {
				case "button":
				case "reset":
				case "submit":
					break;
				case "radio":
					var eRadio = document.all[form.elements[i].name];
					var idx = 0;
					for ( var k = 0; k < eRadio.length; k++) {
						if (eRadio[k].value == xvalue) {
							idx = k;
							break;
						}
					}
					eRadio[idx].checked = true;
					break;
				case "checkbox":
					form.elements[i].checked = xvalue;
					break;
				case "select-one":
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						for ( var k = 0; k < opt_len; k++) {
							if (eOpt[k].value == xvalue) {
								idx = k;
								break;
							}
						}
					}
					form.elements[i].selectedIndex = idx;
					break;
				case "select-multiple": //선택될 값이 '|' 를 구분자로 입력되어있다고 가정한다.
					var eOpt = form.elements[i].options;
					var idx = 0;
					if (eOpt != null && eOpt.length != null && eOpt.length >= 1) {
						var opt_len = eOpt.length;
						var tvalue = xvalue.split("|");
						var tval_len = tvalue.length;
						for ( var k = 0; k < opt_len; k++) {
							for ( var m = 0; m < tval_len; m++) {
								if (eOpt[k].value == tvalue[m])
									eOpt[k].selected = true;
							}
						}
					}
					break;
				default:
					form.elements[i].value = xvalue;
				}
			}
		}      	

}


/**
* Array의 값에 중복 된 데이타 여부 
* @param {form} form html 폼 
* @param {map} Array[name] 의 값
* @return 중복 true 미중복 false 
*/
function ComIsDupData(arr) {		
		
	for( var i = 0 ; i < arr.length ;  i++ ) {
		var a = arr[i];
		for( var j = i+1 ; j < arr.length ;  j++ ) {			
			var b = arr[j];
			if ( a == b ) {
				return true;
			}
		}
	}
	
	return false;

}


/**
*  iframe height자동으로 늘어나고 줄어들기
* @param {string} iframe 이름  
*/
function resizeIframe(iFrameName) {
    var limit = 500;
    var objFrame = window.parent.document.getElementById(iFrameName);   
    var objBody = objFrame.contentWindow.document.body; 
    ifrmHeight = objBody.scrollHeight + (objBody.offsetHeight - objBody.clientHeight);   
   
    if (ifrmHeight > limit ) {
          objFrame.style.height = ifrmHeight ;
    } else {    	
          objFrame.style.height = limit ;
    } 

}




/**
* 입력월 ==> 영문 월   ex(12 -> DEC)
* |JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC
* @param {string} month 월   
*/
function getEngMonthName(month) {
	var mon  = ComParseInt(month);	
	switch (mon) {
	case 1:
		return "JAN";
		break;
	case 2:
		return "FEB";	
		break;
	case 3:
		return "MAR";
		break;
	case 4:
		return "APR";
		break;
	case 5:
		return "MAY";
		break;
	case 6:
		return "JUN";
		break;
	case 7:
		return "JUL";
		break;
	case 8:
		return "AUG";
		break;
	case 9:
		return "SEP";
		break;
	case 10:
		return "OCT";
		break;
	case 11:
		return "NOV";
		break;
	case 12:
		return "DEC";
		break;
	default:
		return "";
		break;
	}


}




/**
* LOC금액을  USD 금액으로 환산  계산
**/
function getUsdAmt(loclAmt , loclUtVal , usdLoclXchRt  ) {
	 
	//FM LOC
	var locl_amt = removeComma(loclAmt);
	
	//FM USD
	var usd_locl_xch_rt = removeComma(usdLoclXchRt);
	
	//FM 단위
	var ut_val = removeComma(loclUtVal);
	
	if (locl_amt < 0) {
		return Math.floor( (locl_amt * ut_val) / usd_locl_xch_rt);	
	} else {
		return Math.ceil( (locl_amt * ut_val) / usd_locl_xch_rt);
	}
	
	
			
}

/**
* LOC금액을  USD 금액으로 환산  계산(csr용)
**/
function getCsrUsdAmt(loclAmt , loclUtVal , usdLoclXchRt  ) {
	 
	//FM LOC
	var locl_amt = removeComma(loclAmt);
	
	//FM USD
	var usd_locl_xch_rt = removeComma(usdLoclXchRt);
	
	//FM 단위
	var ut_val = removeComma(loclUtVal);
	
	var mathresult = (locl_amt * ut_val) / usd_locl_xch_rt;

	if (locl_amt < 0) {
		return Math.floor( (locl_amt * ut_val) / usd_locl_xch_rt);	
	} else {
		return mathresult.toFixed(2);
	}
	
	
			
}

/**
 * USD금액을  LCL 금액으로 환산  계산
 **/
function getLclAmt(usdAmt , loclUtVal , usdLoclXchRt) {
	 	
	//TO USD
	var usd_amt = Math.abs(removeComma(usdAmt));
	//TO 단위
	var ut_val = removeComma(loclUtVal);
	//TO RATE
	var usd_locl_xch_rt = removeComma(usdLoclXchRt);
	
	//KRW금액 계산 (USD / (UNIT*RATE)
	return Math.ceil( (usd_amt * usd_locl_xch_rt) / ut_val);
	
}
 




/**
* 객체 위치 취득 
* @param {htmlObj} Html object    
*/
function getPos(obj){
	 var xy = { x: 0, y: 0 };	 
	 while (obj) {
		 xy.x += obj.offsetLeft; 
		 xy.y += obj.offsetTop;		 
		 obj = obj.offsetParent;
	 }	 
	 return xy;
}







/**
* Status가 "D"가 아닌 row의 갯수를 가져온다 <br>
* <br><b>Example :</b>
* <pre>
*     rowCnt = SheetRowCount(sheetObj);
* </pre>
* @param {ibsheet} sheetObj 필수 IBSheet Object
* @return int sheet내의 유효한 row수
* @author 박성수
* @version 2009.05.13
*/
function SheetRowCount(sheetObj) {
   return (sheetObj.RowCount - sheetObj.RowCount("D"));
}




/**
* Select된 행번호 Array취득 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} chkColName 선택 컬럼명
* @return 행번호 [1,3,7]
* @author 진윤오
* @version 2009.05.13
*/
function selectRowNum(sheet , chkColName) {
	
	var sRow = "";
	if (!ComIsNull(chkColName)) {
		sRow = sheet1.FindCheckedRow(chkColName);
	} else {
		sRow = sheet1.FindCheckedRow("delChk");
	}
	
	if (ComIsNull(sRow)) {
		return null;
	}
	
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	//마지막 빈공백 요소 제거 
	arrRow.pop();
	
	return arrRow;
	
	
}



/**
* 행을 삭제 <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {string} col 컬럼명
* @return 행번호 [1,3,7]
* @author 진윤오
* @version 2009.05.13
*/
function ComRowDelete(sheet, col) {
	//체크박스에 체크된 행 전체를 문자열로 가져온다. 결과 : "1|3|5|"
	var sRow = sheet.FindCheckedRow(col);
	if (sRow == "") return ;
	
	
	//가져온 행을 배열로 만들기 
	var arrRow = sRow.split("|"); //결과 : "1|3|5|"
	
	for (var idx=arrRow.length-2; idx>=0; idx--){
		var row = arrRow[idx];		
		var status = sheet.RowStatus(row);
		
		if (status == "I") {
			sheet.RowDelete(row,false);
		} else {
			sheet.CellValue2(row, col)= 0;	//1.체크박스 없애기 (체크된데이터만 다른 처리 하는 경우도 있으므로)
			sheet.RowHidden(row)= true;		//2.행 숨기기		
			sheet.RowStatus(row)= "D";		//3.트랜잭션 상태 "삭제"로 만들기
		}
	}
	
	return arrRow -1 ;
}

/**
* 시트 첫번째 행번호  <br>
* @param {ibsheet} sheet 필수 IBSheet Object
* @param {int} 시작 행 Index 해더가 2행이면 2  , 1행이면 1  
* @return 행번호 삭제가 아니 행번호
* @author 진윤오
* @version 2009.05.13
*/
function FirstRowNum(sheet , rowIdx) {
	
	var idx = 1;
	
	if (rowIdx != null && rowIdx > 0) {
		idx = rowIdx;
	}
	
	for ( var i = 0; i < sheet.RowCount; i++) {
		var row =  i + idx;
		if (sheet1.RowStatus(row) == "D")  {
			continue;
		} else {
			return row;
		}
	}
	
}

/**
* 콤보 박스 내용 복사   <br>
* @param {combo} combo1 원본
* @param {combo} combo2 대상  
* @param {boolean} init 대상콤보 초기화 여부 
* @author 진윤오
* @version 2009.05.13
*/
function comboCopy(combo1, combo2 , init) {
	
	if (init) {
	 combo2.length = 0;
	}
	
	for ( var i = 0; i < combo1.length; i++) {
		var val = combo1.options[i].value;
		var txt = combo1.options[i].text;
		ComAddComboItem(combo2 , txt , val);
	}
	
	combo2.value = combo1.value;
}

/**
* 윈도우 Center에서 열기   <br>
* @param {string} url url
* @param {string} winName 타겟  
* @param {int} width 타겟
* @param {int} height 타겟 
* @author 진윤오
* @version 2009.05.13
*/
function openWinCenter(url,winName,width,height , scrollYn) {
	   var left = (screen.width - width)/2;    
	   if(left < 0) {
		   left = 0;
	   }
       var top  = (screen.height- width)/2;   
       if( top < 0 ) {
    	   top = 0;
       }
       
       if (ComIsNull(scrollYn)) {
    	   scrollYn = "no";
       } else {
    	   if (scrollYn == "Y") {
    		   scrollYn = "yes";
    	   } else {
    		   scrollYn = "no";
    	   }
       }
       
       var feature = 
    	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
       
       return window.open(url,winName,feature);
	
}

//perfWin  팝업창 (실적)
var perfWin = null;

/**
* performance inquiry 팝업
* @param {sheet} sheet ibsheet
*/
function openPerformance(sheet) {

	var row = sheet.SelectRow;
 	
	if (sheet.SelectRow < 2) {
		return;
	}
	
	var width = 800;
	var height = 380;
 	
	var url = "";
	var winName = "";
	var gen_expn_rqst_tp_cd = sheet.CellValue(row,"gen_expn_rqst_tp_cd");
	
	if (gen_expn_rqst_tp_cd == "ET") {
		url = "CPS_GEM_0107.do";
		winName = "CPS_GEM_0107";
		width = 800;
		height = 390;
	} else {
		url = "CPS_GEM_0108.do";
		winName = "CPS_GEM_0108";
		width = 800;
		height = 350;
	}
	
	if (perfWin != null) {
		perfWin.close();
	}
	
	var param = "";
	
	param += "?fm_ofc_cd=" + sheet.CellValue(row , "fm_ofc_cd");
	param += "&to_ofc_cd=" + sheet.CellValue(row , "to_ofc_cd");
	param += "&fm_gen_expn_cd=" + sheet.CellValue(row , "fm_gen_expn_cd");
	param += "&to_gen_expn_cd=" + sheet.CellValue(row , "to_gen_expn_cd");
	param += "&pln_yrmon=" + frm.pln_yrmon.value;
	
	perfWin = ComOpenWindowCenter(url+param,winName,width,height, false);
	
	perfWin.focus();
	
}



/**
*  체크박스 value를 ","로 문자열 연결   <br>
* @param {obj} checkbox
* @return checked value '1,2,3'  콤마(,) 로분리
* @author 진윤오
* @version 2009.05.13
*/
function checkBoxValue(obj) {
	var txt = "";
	if (obj.length) {
		var checked = 0;
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].checked) {
				txt += "," + obj[i].value;
				checked++;
			}
		}		
		
		if (checked > 0) {
			return txt.substring(1 ,txt.length);
		} else {
			return "";
		}
		
	} else {
		if (obj.checked) {
			return obj.value;
		}
	}
	
	return txt;
}







/**
*  선택한 시트의 row의 column값을 request queryString으로 변환   <br>
* @param {ibsheet} sheet IBSheet
* @param {long} row selected row number
* @return request queryString
* @author 진윤오
* @version 2009.05.13
*/
function getSheetRowQueryString(sheet , row) {

	var queryString = "";
	
	for ( var col = 0; col <= sheet.LastCol ; col++) {		
		queryString += "&" + sheet.ColSaveName(col) + "=" + sheet.CellValue(row,col);
	}
	
	if (queryString != "") {
		queryString = queryString.substring(1 ,queryString.length);
	}
	
	return queryString;
}


/**
*  문자에서 콤마 제거   <br>
* @param {string} str 입력문자 
* @return 콤마 제거 문자열  
* @author 진윤오
* @version 2009.05.13
*/
function removeComma(str) {
	if (str == null) {
		return str; 
	}
		
	return str.replace(/,/g , "");
	
}


/**
 * select box onChange시 포커스 아웃
 * 
 */
function focusOut() {
	document.body.focus();
}



/**
 * HO, HQ 체크 박스 설정 
 * @param {value} 선택된 체크 박스구분
 */
function setHOHQ(obj, lvlName) {
	var colName = obj.name;
	var colValue = obj.value;
	
	var c1 = eval("document.form."+colName+"[0].checked");
	
	var c2 = eval("document.form."+colName+"[1].checked");
	
	if ( c1 && c2 ) {
		if (colValue == "N") {
			eval("document.form."+colName+"[1].checked = false;");
		} else if (colValue == "Y") {
			eval("document.form."+colName+"[0].checked = false;");
		}		
	} else if(!c1 && !c2) {
		// HO & HQ를 선택하지 않았을경우 BU Office정보를 Reset.
		var objLvl1 = eval(lvlName+1);
		objLvl1.options[0] = new Option("", "", true, true);
	}
}
 
/**
 * BUOffice의 HO or HQ 구분
 * @author choijungmi
 */
function isHoHqGubun(url, command, sheetObj, hohq, lvl, colName){	 
	 comLevelChange(url, command, sheetObj, hohq, lvl, colName);
}

/**
 * Ho or Hq 선택여부 Check
 * @author choijungmi
 * @param colName
 * @return
 */
function isRadioUnselected(colName) {
    var isChecked = false;
    
    var c = document.getElementsByName(colName);
	var k = 0;
    for (var i = 0; i < c.length; i++)	{
		if(c[i].checked == true) {
			k = k + 1;      
		}
	}
    if(k > 0) isChecked = true; 
    
    return isChecked;
}

/**
 * BUOffice값의 Level값에 따라 변경
 * url : CPS_GEM_0011.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
 * 
 * @author choijungmi
 * @param url
 * @param command
 * @param sheetObj
 * @param hohq
 * @param lvl
 * @param colName 
 * 
 */
function selLevelChange(url, command, sheetObj, hohq, lvl, colName) {
	if(lvl == "2") {
		var objLvl2 = eval(colName+2);
		if(!isRadioUnselected(hohq)) {
			// HO or HQ를 선택하세요.
			ComShowCodeMessage("GEM01038","an office type");
			objLvl2.options[0] = new Option("", "", true, true);		
			return;
		}
	}
	comLevelChange(url, command, sheetObj, hohq, lvl, colName);
}

function selLevelChange2(url, command, sheetObj, hohq, lvl, colName) {
	if(lvl == "2") {
		var objLvl1 = eval(colName+1);
		var objLvl2 = eval(colName+2);
		if(!isRadioUnselected(hohq)) {
			// HO or HQ를 선택하세요.
			ComShowCodeMessage("GEM01038","an office type");
			objLvl2.options[0] = new Option("", "", true, true);
			
			return;
		}
		if(objLvl1.value == "") {
			// Please select {?msg1}
			ComShowCodeMessage("GEM01038","an office level1");
			objLvl2.options[0] = new Option("", "", true, true);	
			return;
		}
	} else if(lvl == "3") {
		var objLvl1 = eval(colName+1);
		var objLvl2 = eval(colName+2);
		var objLvl3 = eval(colName+3);
		//alert(objLvl1.value+"=="+objLvl2.value+"=="+objLvl3.value);
		if(objLvl1.value == "") {
			// Please select {?msg1}
			ComShowCodeMessage("GEM01038","an office level1");
			objLvl3.options[0] = new Option("", "", true, true);		
			return;
		} 
		if(objLvl2.value == "") {
			// Please select {?msg1}
			ComShowCodeMessage("GEM01038","an office level2");
			objLvl3.options[0] = new Option("", "", true, true);		
			return;
		}
	}
}

/**
 * BUOffice값의 Level값에 따라 변경
 * url : CPS_GEM_0011.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
 * 
 * @author choijungmi
 * @param url
 * @param command
 * @param sheetObj
 * @param hohq
 * @param lvl
 * @param colName
 */
function comLevelChange(url, command, sheetObj, hohq, lvl, colName) {
	var objLvl1 = eval(colName+1);
	var objLvl2 = eval(colName+2);
	var objLvl3 = eval(colName+3);
			
	if(lvl == "1") {		
		objLvl2.length = 1;
		objLvl3.length = 1;
		
		objLvl2.options[0] = new Option("", "", true, true);
		objLvl3.options[0] = new Option("", "", true, true);
		
		comDoAction(url, command, sheetObj, hohq, lvl, colName);
		
		if(objLvl1.value == "") {
			if (!objLvl1.disabled) {
				objLvl1.focus();
			}
		} else {
			if (!objLvl2.disabled) {
				objLvl2.focus();
			}
	    }
		
		
	} else if(lvl == "2") {
		objLvl3.length = 1;
		objLvl3.options[0] = new Option("", "", true, true);
		
		comDoAction(url, command, sheetObj, hohq, lvl, colName);
		if (!objLvl3.disabled) {
			objLvl3.focus();
		}
		
	}	
}

/**
 * 공통 Search를 위한 doActionIBSheet() 역할
 * url : GEM_COMMONGS.do | command : SEARCHLIST | sheetObj : sheet name | hohe : name | lvl : level | colName : level name
 * 
 * @author choijungmi
 * @param url
 * @param command
 * @param sheetObj
 * @param hohq
 * @param lvl
 * @param colName
 * 
 */
function comDoAction(url, command, sheetObj, hohq, lvl, colName) {
	//alert(url+"=="+command+"=="+sheetObj+"=="+lvl+"=="+colName);
	
	var schHohq = "";
	var c = document.getElementsByName(hohq);
	for (var i = 0; i < c.length; i++)	{
		if(c[i].checked == true) {
			schHohq = c[i].value;
			break;
		}
	}
	
	var objLvl1 = eval(colName+1);
	var objLvl2 = eval(colName+2);
	var objLvl3 = eval(colName+3);
	
	// LEVEL 조회
	var sXml = eval(sheetObj).GetSearchXml(url+"?f_cmd="+eval(command)+"&sch_hohq_gbn="+schHohq+"&sch_lvl1="+objLvl1.value+"&sch_lvl2="+objLvl2.value);
	
	if(lvl == "1") {
		// Major
		var etcData = ComGetEtcData(sXml, "searchMajorList");
		
		if (!ComIsNull(etcData)) {
			var comboListData = etcData.split("|");
		
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = objLvl2;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
		}
	} else if(lvl == "2") {
		// Minor
		var etcData = ComGetEtcData(sXml, "searchMinorList");
		if (!ComIsNull(etcData)) {
			var comboListData = etcData.split("|");
			if(typeof comboListData != "undefined" && comboListData != "") {
				var ofcLvl = objLvl3;
				ofcLvl.length = 0;
				ComAddComboItem(ofcLvl,"","");
				
				for(var i=0 ; i < comboListData.length ; i++ ) {
					ComAddComboItem(ofcLvl,comboListData[i],comboListData[i]);
				}
			}
		}
	}
}

/**
 * CheckBox가 All인경우 나머지 선택 안되게 막음.
 * All이 아닌경우 각자 선택 가능하게 함.
 * 
 * @author choijungmi
 * @param val
 * @return
 */
function comAllCheckGubun(val) {
	var colName = val.name;
	
	var c = document.getElementsByName(colName);
	var k = 1;
	for (var i = 0; i < c.length; i++)	{
		if(c[0].checked == true) {
			if(k < c.length) {
				var subCol = colName+k;
				eval('document.all.'+subCol+'.checked = false');
				eval('document.all.'+subCol+'.disabled = true');
			}
		} else {
			if(k < c.length) {
				var subCol = colName+k;
				eval('document.all.'+subCol+'.disabled = false');
			}
		}
		k++;
	}
}

/**
* colName에 해당하는 Document에 Checkd된 Value를 검색
* 검색언어 선택시 이용
* 
* @author choijungmi
* @return String
*/
function getColNameValue(colName) {
	var returnStr = "";
	var c = document.getElementsByName(colName);
	for ( var i = 0; i < c.length; i++) {
		if (c[i].checked == true) {
			returnStr = c[i].value;
			break;
		}
	}
	return returnStr;
}

/**
 * 다음 포커스를 찾아가기 위한 공통
 * 
 * @author choijungmi
 * @param nextCol
 * @return
 */
function comFocusChange(nextCol) {
	var obj = eval(nextCol);
	if(!obj == "") obj.focus();
}
 
/**
 * Do you want to initialize?
 */
function ComCodeMsgByInitialize()
{
	return ComShowCodeConfirm('GEM00015');
}
 
/**
 * Do you want to initialize unsaved data?
 */
function ComCodeMsgByInitializeUnsaved()
{
	return ComShowCodeConfirm('GEM00011');
}
 
/**
 * Do you want to save changes?
 */
function ComCodeMsgBySave()
{
	 return ComShowCodeConfirm('GEM00012');
}
 
/**
 * There is no related data!
 */
function ComCodeMsgByNoRelatedData()
{
	ComShowCodeMessage('GEM00013');
}

/**
 * 지금은 사용하실 수가 없습니다.
 */
function ComCodeMsgByNoUsed()
{
	ComShowCodeMessage('GEM01027');
}
 
 
 
/**
 * There is no contents to save. 
 */
function ComCodeMsgByNoContentsSave()
{
	ComShowCodeMessage('GEM01056');
}

/**
 * IBSheet XML에서 XML 문자열을 파싱하여 그 안의 파라미터 항목 값을 리턴한다 <br>
 * @param {string} xmlStr    IBSheet를 통해 받아온 xml 문자열
 * @param {string} dataNode  파싱할 항목
 * @return {string} xmlValue
 **/
function ComGemGetXMLData(xmlStr, dataNode) {
		
	var xmlData = '';

    try {
        /* XML Parsing */
        var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
        xmlDoc.async = "false";
        xmlDoc.loadXML(xmlStr);
		/* get message */
        xmlData = xmlDoc.documentElement.getElementsByTagName(dataNode).item(0).text
    } catch(err) {
        xmlData = '';
    }
    
	return xmlData;
	}
/**
 * 
 */

/**
 * 
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 