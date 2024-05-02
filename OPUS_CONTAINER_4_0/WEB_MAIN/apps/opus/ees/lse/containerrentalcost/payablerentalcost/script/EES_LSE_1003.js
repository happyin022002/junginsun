/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_1003.js
*@FileTitle  : Tax Input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/12
=========================================================*/
/****************************************************************************************
 이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
 기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* 개발자 작업 */
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
var mainPage;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_Apply":
        	var formObj=document.form;
        	var cnt = "";
        	var shtObj = "";
        	if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
	        	cnt = parent.sheetObjects[1].RowCount();
	        	shtObj = parent.sheetObjects[1];
        	}else{
        		cnt = parent.sheetObjects[0].RowCount();
	        	shtObj = parent.sheetObjects[0];
        	}
        	
        	
        	var shtcnt = sheetObjects[0].RowCount();
        	var chkCnt = 0;
        	for(var i=0;i<shtcnt;i++) {
        		if(sheetObjects[0].GetCellValue(i+1,"checkbox",0) == "1") {
        			chkCnt = 1;
        			break
        		}
        	}
        	
        	if(chkCnt == 0) {
        		ComShowCodeMessage("LSE01045");
        		return false;
        	}
        	
        	if(parseFloat(ComReplaceStr(isGetNull(formObj.total_amount.value),",","")) <  parseFloat(ComReplaceStr(isGetNull(formObj.total_tax.value),",","")) ) {
        		ComShowCodeMessage("LSE10025");
        		return false;
        	}
        	
			var allTax = parseFloat(ComReplaceStr(isGetNull(formObj.total_tax.value),",",""));
			
        	if(formObj.sType.value == "vaTax" ||  formObj.sType.value == "vaTaxOperation") {
        		parent.document.form.inv_vat_amt.value = ComAddComma(allTax.toFixed(2));
        	}else{
        		parent.document.form.whld_tax_amt.value = ComAddComma(allTax.toFixed(2));
        	}
        	
        	
        	if(shtcnt > 0) {
        		
        		var strInvNo = "";
        		var strAmount = "";
        		var strTax = 0;
        		var strInvNo = "";
        		for(var i=0;i<cnt;i++) {
        			if(formObj.sType.value == "vaTax" ||  formObj.sType.value == "vaTaxOperation") {
						shtObj.SetCellValue(i+1, "inv_vat_amt", "0" );
						shtObj.SetCellFontColor(i+1, "inv_vat_amt","#000000") ;
					}else{
						shtObj.SetCellValue(i+1, "whld_tax_amt", "0" );
						shtObj.SetCellFontColor(i+1, "whld_tax_amt","#000000") ;
					}
        		}
        		
        		for(var i=0;i<shtcnt;i++) { 
        			if(sheetObjects[0].GetCellValue(i+1,"checkbox",0) == "1") {
        				
        				strInvNo = sheetObjects[0].GetCellValue(i+1,"inv_no",0);
        				strTaxAmount = sheetObjects[0].GetCellValue(i+1,"tax_amount",0);
          				
        				for(var j=0;j<cnt;j++) {
        					
        					if(strInvNo == shtObj.GetCellValue(j+1,"inv_no",0)) {
        						if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
	        						if(formObj.sType.value == "vaTax") {
	        							shtObj.SetCellValue(j+1, "inv_vat_amt", strTaxAmount )
	        							shtObj.SetCellFontColor(j+1, "inv_vat_amt","#FF0000") ;
	        						}else{
	        							shtObj.SetCellValue(j+1, "whld_tax_amt", strTaxAmount )
	        							shtObj.SetCellFontColor(j+1, "whld_tax_amt","#FF0000") ;
	        						}
        						}else{
        							if(formObj.sType.value == "vaTaxOperation") {
	        							shtObj.SetCellValue(j+1, "inv_vat_amt", strTaxAmount )
	        							shtObj.SetCellFontColor(j+1, "inv_vat_amt","#FF0000") ;
	        						}else{
	        							shtObj.SetCellValue(j+1, "whld_tax_amt", strTaxAmount )
	        							shtObj.SetCellFontColor(j+1, "whld_tax_amt","#FF0000") ;
	        						}
        						}
        					}
        				}
        			}else{
        				
        				strInvNo = sheetObjects[0].GetCellValue(i+1,"inv_no",0);
        				strTaxAmount = sheetObjects[0].GetCellValue(i+1,"tax_amount",0);
        				
        				for(var j=0;j<cnt;j++) {
        					
        					if(strInvNo == shtObj.GetCellValue(j+1,"inv_no",0)) {
        						if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
	        						if(formObj.sType.value == "vaTax") {
	        							shtObj.SetCellValue(j+1, "inv_vat_amt", "0" )
	        							shtObj.SetCellFontColor(j+1, "inv_vat_amt","#000000") ;
	        						}else{
	        							shtObj.SetCellValue(j+1, "whld_tax_amt", "0" )
	        							shtObj.SetCellFontColor(j+1, "whld_tax_amt","#000000") ;
	        						}
        						}else{
        							if(formObj.sType.value == "vaTaxOperation") {
	        							shtObj.SetCellValue(j+1, "inv_vat_amt", "0" )
	        							shtObj.SetCellFontColor(j+1, "inv_vat_amt","#000000") ;
	        						}else{
	        							shtObj.SetCellValue(j+1, "whld_tax_amt", "0" )
	        							shtObj.SetCellFontColor(j+1, "whld_tax_amt","#000000") ;
	        						}
        						}
        					}
        				}
        				
        			}
        		}
        		
        		
        		parent.form.inv_ttl_amt.value = 	parseFloat(ComReplaceStr(isGetNull(parent.form.inv_amt.value),",","")) + 
				parseFloat(ComReplaceStr(isGetNull(parent.form.inv_vat_amt.value),",","")) - 
				parseFloat(ComReplaceStr(isGetNull(parent.form.whld_tax_amt.value),",",""));

        		parent.form.inv_ttl_amt.value = ComAddComma((Math.round(parent.form.inv_ttl_amt.value * 100)/100).toFixed(2));
        	}
        	
        	ComClosePopup(); 
        	break;
        case "btn_Close":
            ComClosePopup(); 
            break;
        case "btn_tax":
        	var obj=ComGetEvent();
        	var formObj=document.form;
        	if(formObj.dft_tax.value > 100) {
        		ComShowCodeMessage("LSE10016");
        		formObj.dft_tax.value = "0.00";
        		return false;
        	}
        	
    		if( formObj.dft_tax.value != null && formObj.dft_tax.value != "" ) {
    			var cnt = sheetObjects[0].RowCount();
    			
    			if(cnt > 0) {
    				var strInvNo = "";
    				var strAmount = "";
    				var strTax = 0;
    				var allAmount = 0;
    				var allTax = 0;
    				var intPDAmount = 0;
    				var intTotal = 0;
    				strTax = formObj.dft_tax.value;
    				formObj.total_tax.value = 0;
    				for(var i=0;i<cnt;i++) {
    					if(sheetObjects[0].GetCellValue(i+1,"checkbox",0) == "1") {
	    					if(strTax > 0) {
	    						sheetObjects[0].SetCellValue(i+1,"tax_amount", (sheetObjects[0].GetCellValue(i+1,"per_dim_amount",0) * strTax / 100).toFixed(2),0);
	    					}else{
	    						sheetObjects[0].SetCellValue(i+1,"tax_amount", 0.00,0);
	    					}   					
    					}
    					
    					intTotal = sheetObjects[0].GetCellValue(i+1,"tax_amount",0);
    					if(sheetObjects[0].GetCellValue(i+1,"checkbox",0) == "1") {
    						allTax = parseFloat(ComReplaceStr(isGetNull(formObj.total_tax.value),",","")) + parseFloat(intTotal);
    						allTax = ComAddComma((Math.round(allTax * 100)/100).toFixed(2))
        					formObj.total_tax.value = allTax;
    					}    	
    				}
    			}
    		}
        break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}


function isGetNull(obj) {
	var rtn = "";
	if(obj == null || obj == "") {
		rtn = "0.00";
	}else{
		rtn = obj;
	}
	return rtn;
}


function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm('click','obj_click',formObj);         
	axon_event.addListenerForm('change','obj_change',formObj);       
	axon_event.addListenerFormat('blur','obj_blur',formObj);         
}

/**
 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 배열은 소스
 * 상단에 정의
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
 function loadPage(mainpage) {
     mainPage=mainpage;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();

    sheet1_OnLoadFinish(sheetObjects[0]);
    //doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}
 
 
/**
 * Sheet1 OnLoadFinish Event 처리
 * @param sheetObj
 * @return
 */
function sheet1_OnLoadFinish(sheetObj) {
	var formObj=document.form;
	var cnt = "";
	var shtObj = "";
	if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
		cnt = parent.sheetObjects[1].RowCount();
		shtObj = parent.sheetObjects[1];
	}else{
		cnt = parent.sheetObjects[0].RowCount();
		shtObj = parent.sheetObjects[0];
	}
	
	if(cnt > 0) {
		var strInvNo = "";
		var strAmount = "";
		var strTax = 0;
		var k=0;
		for(var i=0;i<cnt;i++) {		
			if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
				if(shtObj.GetCellValue(i+1,"chkbox",0) == "1" && shtObj.GetCellValue(i+1,"pdm_amt",0) != "") {
					sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(k+1,"checkbox", "1");
					sheetObj.SetCellValue(k+1,"seq", k+1);
					sheetObj.SetCellValue(k+1,"inv_no", shtObj.GetCellValue(i+1,"inv_no",0));
					sheetObj.SetCellValue(k+1,"per_dim_amount", shtObj.GetCellValue(i+1,"pdm_amt",0));
					if(formObj.sType.value == "vaTax") {
						sheetObj.SetCellValue(k+1,"tax_amount", shtObj.GetCellValue(i+1,"inv_vat_amt",0));
					}else{
						sheetObj.SetCellValue(k+1,"tax_amount", shtObj.GetCellValue(i+1,"whld_tax_amt",0));
					}
					//sheetObjects[0].SetCellValue(k+1,"tax_amount", (sheetObjects[0].GetCellValue(k+1,"per_dim_amount",0) * strTax / 100).toFixed(2));
				
					k = k+1;
				}
			}else{
				if(shtObj.GetCellValue(i+1,"chkbox",0) == "1" && shtObj.GetCellValue(i+1,"pdm_amt",0) != "") {
					sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(k+1,"checkbox", "1");
					sheetObj.SetCellValue(k+1,"seq", k+1);
					sheetObj.SetCellValue(k+1,"inv_no", shtObj.GetCellValue(i+1,"inv_no",0));
					sheetObj.SetCellValue(k+1,"per_dim_amount", shtObj.GetCellValue(i+1,"pay_amt",0));
					
					//sheetObjects[0].SetCellValue(k+1,"tax_amount", (sheetObjects[0].GetCellValue(k+1,"per_dim_amount",0) * strTax / 100).toFixed(2));
					if(formObj.sType.value == "vaTaxOperation") {
						sheetObj.SetCellValue(k+1,"tax_amount", shtObj.GetCellValue(i+1,"inv_vat_amt",0));
					}else{
						sheetObj.SetCellValue(k+1,"tax_amount", shtObj.GetCellValue(i+1,"whld_tax_amt",0));
					}
					
					k = k+1;
				}
			}
		}
	}
}


/**
 * 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    var sheetID=sheetObj.id;
    var formObj=document.form;
    switch (sheetID) {
    case "sheet1":
        with(sheetObj){
              var HeadTitle1;
              if(formObj.sType.value == "vaTax" || formObj.sType.value == "whTax") {
            	  HeadTitle1="|Seq|Invoice No|Per-Diem Amount|Tax";
              }else{
            	  HeadTitle1="|Seq|Invoice No|Amount|Tax";
              }
              
              
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                     {Type:"Text",      Hidden:0,  Width:180,   Align:"Center",  ColMerge:0,   SaveName:"inv_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",      Hidden:0,  Width:150,  Align:"Right",    ColMerge:0,   SaveName:"per_dim_amount",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Float",      Hidden:0,  Width:150,  Align:"Right",    ColMerge:0,   SaveName:"tax_amount",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 }];
              
              InitColumns(cols);
              SetEditable(1);
              //SetCountPosition(0);
              
              SetCountFormat("[SELECTDATAROW / TOTALROWS]");
              SetWaitImageVisible(false);
              SetSheetHeight(410);
              //resizeSheet();
          }
        break;
    }
}



/*function resizeSheet(){
	 ComResizeSheet(sheetObjects[0]);
}*/

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj, formObj, sAction) {
    switch (sAction) {
    case IBSEARCH: // 조회
        if (sheetObj.id == "sheet1") {
            formObj.f_cmd.value=SEARCH;
            ComOpenWait(true);
            sheetObj.DoSearch("COM_ENS_N13GS.do", FormQueryString(formObj) );
        }
        break;
    case COMMAND01: // 선택
        var selrow = sheetObj.GetSelectRow();
        if (selrow > 0) {
            comPopupOK();
        }
        break;
    }
}


function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    ComOpenWait(false);
}


/**
* handling event in case of Change
*/
function obj_change(){
	
}

/**
* handling event in case of Change
*/
function obj_blur(){
	var formObj=document.form;
	switch(ComGetEvent("name")){
		case "dft_tax":
			var strDftTax="";
			if(formObj.dft_tax.value != "") {
				strDftTax = formObj.dft_tax.value.replaceStr(",","");
			}else{
				strDftTax = "0.00";
			}
			formObj.dft_tax.value = strDftTax;
			if(strDftTax > 100) {
				ComShowCodeMessage("LSE10016");
				formObj.dft_tax.value = "0.00";
				return false;
			}
		break;
	}
}
/**
 * sheet1 Onhandling event in case of Change
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var formObj=document.form;
	var colName=sheetObj.ColSaveName(Col);
	switch (colName) {
		case "checkbox":
			var allAmount = 0;
			var allTax = 0;
			var intPDAmount = sheetObj.GetCellValue(Row,"per_dim_amount",0);
			var intTotal = sheetObj.GetCellValue(Row,"tax_amount",0);
			
			if ( Value == "1" ) {
				allAmount = parseFloat(ComReplaceStr(isGetNull(formObj.total_amount.value),",","")) + parseFloat(ComReplaceStr(isGetNull(intPDAmount),",",""));
				allTax = parseFloat(ComReplaceStr(isGetNull(formObj.total_tax.value),",","")) +parseFloat(ComReplaceStr(isGetNull(intTotal),",",""));
			}else{
				allAmount = parseFloat(ComReplaceStr(isGetNull(formObj.total_amount.value),",","")) - parseFloat(ComReplaceStr(isGetNull(intPDAmount),",",""));
				allTax = parseFloat(ComReplaceStr(isGetNull(formObj.total_tax.value),",","")) - parseFloat(ComReplaceStr(isGetNull(intTotal),",",""));
			}
			
			allAmount = ComAddComma((Math.round(allAmount * 100)/100).toFixed(2))
			allTax = ComAddComma((Math.round(allTax * 100)/100).toFixed(2))
			formObj.total_amount.value = allAmount;
			formObj.total_tax.value = allTax;
			break;

		case "tax_amount":
			var allAmount = 0;
			var allTax = 0;
			
			if(sheetObj.GetCellValue(Row,"tax_amount",0) == "") {
				sheetObj.SetCellValue(Row,"tax_amount",0);
			}
			
			for(var i=0;i<sheetObj.RowCount();i++) {
				var intPDAmount = sheetObj.GetCellValue(i+1,"per_dim_amount",0);
				var intTotal = sheetObj.GetCellValue(i+1,"tax_amount",0);
				if ( sheetObj.GetCellValue(i+1,"checkbox",0) == "1" ) {
					allAmount = parseFloat(ComReplaceStr(isGetNull(allAmount),",","")) + parseFloat(ComReplaceStr(isGetNull(intPDAmount),",",""));
					allTax = parseFloat(ComReplaceStr(isGetNull(allTax),",","")) + parseFloat(ComReplaceStr(isGetNull(intTotal),",",""));
				}
			}
			
			allAmount = ComAddComma((Math.round(allAmount * 100)/100).toFixed(2))
			allTax = ComAddComma((Math.round(allTax * 100)/100).toFixed(2))
			formObj.total_amount.value = allAmount;
			formObj.total_tax.value = allTax;
			break;
		
	}
}

/* 개발자 작업 끝 */
