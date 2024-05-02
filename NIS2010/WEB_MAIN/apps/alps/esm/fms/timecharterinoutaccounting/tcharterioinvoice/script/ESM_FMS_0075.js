/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0082.js
*@FileTitle : E-mail / Print - window
*@LastModifyDate : 2009.05.21
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.21 최우석
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
     * @class E-mail / Print - window : E-mail / Print - window 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0075() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.setUploadObject		= setUploadObject;
    	this.rdOpenPreview			= rdOpenPreview;
    }
    
    /* 개발자 작업	*/

    // 공통전역변수  
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
	var rdCnt = 0;
	var queryStr = "";
	
	var uploadObjects = new Array();
	var uploadCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
                                          
    		switch(srcName) {
    			case "btn_email":
    				// RD Down
    				rdOpen(rdObjects[0], formObject, "down");
    				doActionIBSheet(sheetObject, formObject, IBSEARCH);
    				break;   

    			case "btn_print":
					// RD Open
					rdOpen(rdObjects[0], formObject, "print");
    				break;  
    											
    			case "btn_tofile":
    				// RD Save
					rdOpen(rdObjects[0], formObject, "save");
    				break;
    				
    			case "btn_close":
    				window.close();
    				break;
    				
    				//2017.12.08 preview 기능 추가
	        	case "btn_preview":
	        		rdOpenPreview(rdObjects[0], formObject);
	        		break;	
    				
    				
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	// fileUpload 환경 설정
    	ComConfigUpload(uploadObjects[0], "/hanjin/ESM_FMS_0075GS.do");

		// RD
		initRdConfig(rdObjects[0]);
    }
    
    /**
     * Sheet관련 프로세스를 처리한다.<br>
     */
    function doActionIBSheet(sheetObj, formObj, sAction) {
    	switch(sAction) {
    		case IBSEARCH:
    			formObj.f_cmd.value = SEARCH;

    			var sFile = form.file_path.value;
 			   	var upObj = uploadObjects[0];
 
 			   	upObj.Files = "";
 			   	
 			   	// IBUpload에 파일 추가하기
 				upObj.AddFile(sFile);
 			   
 			   	if(upObj.LocalFiles == "") {
 			   		return;
 			   	}

				upObj.ExtendParam = FormQueryString(formObj);
				upObj.ParamDecoding = true;
				var sXml = upObj.DoUpload(true);
         		var fileKey = ComGetEtcData(sXml, "fileKey");
         		
         		if(typeof fileKey != "undefined" && fileKey != "") {
         			var param = "";
         			param = param + "?file_path=" + form.file_path.value; 
         			param = param + "&subject=" + form.subject.value;
         			param = param + "&fileKey=" + fileKey;
         			param = param + "&csrNo=" + form.csr_no.value;
         			
         			//ComOpenWindowCenter("ESM_FMS_0079.do" + param, "ESM_FMS_0079", 400, 456);
         			
         			ComOpenWindowCenter("ESM_FMS_0079.do" + param, "ESM_FMS_0079", 500, 456);
         			
         			//ComOpenWindowCenter("ESM_FMS_0079.do" + param, "ESM_FMS_0079", 400, 386);
         		}
         		break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
        return true;
    }
        
	/**
	 * 페이지에 있는 RD Object를 로드한다.<br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
	 * @param {rdObject} rdObject    RD Object
	 **/
	function initRdConfig(rdObject){
	    var Rdviewer = rdObject ;
	    Rdviewer.style.height = 0;
	    Rdviewer.style.width = 0;
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	/**
	 * 조회된 정보를 이메일 발송시 파일첨부를 위해 파일로 출력한다.<br>
	 */
	function rdOpen(rdObject, formObject, viewType){
		var rdViewer = rdObject;
		queryStr = RD_FormQueryString(formObject, 1);

		var rdParam = "/rv "+ queryStr;
			
		var rdFile = "";
		var rdUrl = "";
		var pgmId = form.pgm_id.value;
		var subject = form.subject.value;

		if(pgmId == "esm_fms_0012") {
			//Hire No
			opener.document.form.hire_no.value = ComLpad(opener.document.form.ppay_hir_no.value,5,'0');
			rdParam = "/rv "+ RD_FormQueryString(opener.form, 1);

			//인쇄에 필요한 Hire Invoice List를 Opener로부터 생성한다.
			rdParam = rdParam + getHireInvList();

			rdFile = "ESM_FMS_013.mrd";
			rdUrl = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/";
		} else {
			rdFile = "ESM_FMS_030.mrd";
			rdUrl = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/";
		}

		// 열고자 하는 RD 파일을 지정한다.

		//rdViewer.SetAppendReport(1);
		
		rdViewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam);
		if(viewType == "print") {			// 인쇄
			rdViewer.CMPrint();
		} else if(viewType == "save") {		// 파일저장
			rdViewer.SaveAsDialog();
		} else if(viewType == "down") {		// 파일다운
			subject = subject.replace(/ /g, "_");
		
			//form.file_path.value = "C:\\\\" + subject + ".gif";
			//rdViewer.SaveAsImageFile("C:\\" + subject + ".gif", 2);
			
			form.file_path.value = "C:\\\\" + subject + ".pdf";
			rdViewer.SaveAsPdfFile("C:\\" + subject + ".pdf");
		}
		
		//rdViewer.SetAppendReport(0);
	}

	/**
     * 인쇄에 필요한 Hire Invoice List를 Opener로부터 생성한다.<br>
     **/
	function getHireInvList() {
		var formObject = opener.document.form;
		var sheetObject1 = opener.sheetObjects[0];
		var sheetObject2 = opener.sheetObjects[1];

	    var arrItemName = new Array();
	    var arrAcctCd = new Array();
	    var arrCurrCd = new Array();
	    var arrInvAmt1 = new Array();
	    var arrInvAmt2 = new Array();

		var rowCnt = sheetObject2.RowCount+1;
		var addRow = 0;
		
		// ---------------------------------------------------------------------------
		// 메인 Grid 의 갯수만큼 Loop를 돌면서 Form의 Hire / Lumpsum 정보의 값도 같이 체크한다
		// Currency / Account Code를 비교함
		// ---------------------------------------------------------------------------
		for (i=1; i<rowCnt; i++) {

			var acctCd = sheetObject2.CellValue(i,"inv_acct_cd");
			if (acctCd == "512641") {//Brokerage 
				continue;
			}	
			
			var colNo;
			if (sheetObject2.CellValue(i,"inv_curr_cd") != '') {
				colNo = "";
			} else {
				colNo = "2";
			}
			var currCd = sheetObject2.CellValue(i,"inv_curr_cd"+colNo);
			var itemName;
			var invAmt1 = 0;
			var invAmt2 = parseFloat(sheetObject2.CellValue(i,"inv_inv_amt"+colNo));

			//Hire
			if (acctCd == "510911") {

				if (invAmt2 > 0) {
						
					itemName = "Hire : " + formObject.inv_usd_dys.value + " days";
				
					//Hire Amount
					if (currCd == formObject.hir_hir_curr_n1st_cd.value) {
						invAmt1 = parseFloat(ComReplaceStr(formObject.hir_hir_rt_n1st_amt.value,',',''));
					} else if (currCd == formObject.hir_hir_curr_n2nd_cd.value) {
						invAmt1 = parseFloat(ComReplaceStr(formObject.hir_hir_rt_n2nd_amt.value,',',''));
					}
						
				} else {	

					itemName = "Address Commission : " + formObject.inv_usd_dys.value + " days";

				} 	
			//Lumpsum
			} else {
					
				itemName = "Lumpsum : " + sheetObject2.CellValue(i,"inv_acct_itm_nm");
				
				var findRow = 1;
				while ((findRow = sheetObject1.FindText("oli_acct_itm_nm", sheetObject2.CellValue(i,"inv_acct_itm_nm"), findRow)) > 0) {
					
					if (sheetObject1.CellValue(findRow, "oli_curr_cd") == currCd) {
						invAmt1 = parseFloat(sheetObject1.CellValue(findRow,"oli_otr_expn_amt"));
						break;
					}

				}
					
			}		

			//첫행이거나 Item Name, 계정, Currency가 다른 경우
			if (i == 1) {
				arrInvAmt1[addRow] = 0;
				arrInvAmt2[addRow] = 0;
			} else if (arrItemName[addRow] != itemName || arrAcctCd[addRow] != acctCd || arrCurrCd[addRow] != currCd) {
				addRow++;
				arrInvAmt1[addRow] = 0;
				arrInvAmt2[addRow] = 0;
			}
			
			arrItemName[addRow] = itemName;
			
			// -------------------------------------------------------
			// RD 왼쪽 데이타 (화면 상단의 Hire / Lumpsum 정보)
			// -------------------------------------------------------
			arrCurrCd[addRow] = currCd;
			arrInvAmt1[addRow] = invAmt1;
			
			// --------------------------------------------------------------------
			// RD 오른쪽 데이타 (화면 메인 Grid 정보 - 기간별로 나누어져 있는 금액을  합친다)
			// --------------------------------------------------------------------
			arrInvAmt2[addRow] = arrInvAmt2[addRow] + invAmt2;
			arrAcctCd[addRow] = acctCd;
			
		} 

	    var arrTotCurrCd = new Array();
	    var arrTotInvAmt = new Array();

		var arrLen = arrAcctCd.length;
		addRow = 0;
		var param = '';
		for (i=0; i<arrLen; i++) {

			if (i==0) {
				arrTotInvAmt[addRow] = 0;
				findRow = addRow;
			} else {
				
				//Total currency 배열에 해당 currency가 있는지 찾기 
				var arrTotLen = arrTotCurrCd.length;
				findRow = -1;
				for (j=0; j<arrTotLen; j++) {
					if (arrTotCurrCd[j] == arrCurrCd[i]) {
						findRow = j;
						break;
					}
				
				}
				
				if (findRow == -1) {
					addRow++;
					arrTotInvAmt[addRow] = 0;
					findRow = addRow;
				}
			}
			
			param = param + " frm1_prn_item_name"+(i+1)+"["+arrItemName[i]+"]";
			param = param + " frm1_prn_curr_cd"+(i+1)+"["+arrCurrCd[i]+"]";
			param = param + " frm1_prn_inv1_amt"+(i+1)+"["+ComAddComma2(ComRound(arrInvAmt1[i])+"", "#,###.00")+"]";
			param = param + " frm1_prn_inv2_amt"+(i+1)+"["+ComAddComma2(ComRound(arrInvAmt2[i])+"", "#,###.00")+"]";
			
			arrTotCurrCd[findRow] = arrCurrCd[i];
			arrTotInvAmt[findRow] = arrTotInvAmt[findRow] + (arrInvAmt2[i] * 100);
			//arrTotInvAmt[findRow] = arrTotInvAmt[findRow] + arrInvAmt2[i];
			
			//alert("arrInvAmt2[i] => " + arrInvAmt2[i] + "   ::   arrTotInvAmt[findRow]=>" + arrTotInvAmt[findRow]);
			
		}
		arrLen = arrTotCurrCd.length;
		for (i=0; i<arrLen; i++) {
			
			param = param + " frm1_prn_tot_curr_cd"+(i+1)+"["+arrTotCurrCd[i]+"]";
			//2011-12-07 소수점 2번째 자리까지만 나오도록 수정 -> 변수 .toString().match(/^.*\.\d{2}/) || 변수
			//param = param + " frm1_prn_tot_inv_amt"+(i+1)+"["+ComAddComma2(arrTotInvAmt[i]+"", "#,###.00")+"]";
			param = param + " frm1_prn_tot_inv_amt"+(i+1)+"["+ComAddComma2((arrTotInvAmt[i]/100)+"", "#,###.00").toString().match(/^.*\.\d{2}/) || ComAddComma2(arrTotInvAmt[i]+"", "#,###.00")+"]";
		}
		return param;
	}

	/**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다.<br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
	 function rdOpenPreview(rdObject, formObject){		

		 	var pgmId = form.pgm_id.value;
			var rdViewer = rdObject;
			queryStr = RD_FormQueryString(formObject, 1);
			
			var strPath = "";
			var rdParam = "/rv "+ queryStr;
			var subject = form.subject.value;

			if(pgmId == "esm_fms_0012") {
				//Hire No
				opener.document.form.hire_no.value = ComLpad(opener.document.form.ppay_hir_no.value,5,'0');
				rdParam = "/rv "+ RD_FormQueryString(opener.form, 1);

				//인쇄에 필요한 Hire Invoice List를 Opener로부터 생성한다.
				rdParam = rdParam + getHireInvList();
				strPath = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioinvoice/report/ESM_FMS_013.mrd";
			} else {
				strPath = "apps/alps/esm/fms/timecharterinoutaccounting/tcharterioconsultation/report/ESM_FMS_030.mrd";
			}	 		

	 		formObject.com_mrdPath.value = strPath;
	 		formObject.com_mrdArguments.value = rdParam;
	        ComOpenRDPopupModal('resizable=yes;dialogWidth:750px;dialogHeight:690px'); 

	 	}
    
 	/* 개발자 작업  끝 */