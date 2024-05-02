/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0225.js
*@FileTitle : Change Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-09-07
*@LastModifier : CJH
*@LastVersion : 1.0
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
     * @class ESD_EAS_0225 : ESD_EAS_0225 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_EAS_0225() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.initTab                = initTab;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
    }
    
   	/* 개발자 작업	*/
    
	//공통전역변수
    var frm = null;
    var sheetObjects     = new Array();
    var sheetCnt         = 0;

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/*******************************************************/
	 	var frm = document.form;
	 	var change = 0;

	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {
	 				
			case "btn_save":
				PopupApply();
			break;
			
			case "btn_delete":
				PopupDeleteApply();
			break;
			
			case "btn_attach":
				openFileAttach();
				break;
			
			case "btn_close":
				window.close();
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
		 * 시트 초기설정값, 헤더 정의
		 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
		 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
		 * 구주 S/O
		 */

		function initSheet(sheetObj, sheetNo) {
		  var cnt = 0;
		  switch(sheetNo) {
		  	case 1: //sheet0 init 
			  with (sheetObj) {
				  // 높이 설정
				  //style.height = GetSheetHeight(10);
				  style.height = 0;
				  //전체 너비 설정
				  SheetWidth = mainTable.clientWidth;
			
				  //Host정보 설정[필수][HostIp, Port, PagePath]
				  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
				  //전체Merge 종류 [선택, Default msNone]
				  MergeSheet = msHeaderOnly;
			
				  //전체Edit 허용 여부 [선택, Default false]
				  Editable = true;
			
				  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				  InitRowInfo( 1, 1, 9, 100);
			
				  // 해더에서 처리할 수 있는 각종 기능을 설정한다
				  InitHeadMode(true, true, true, true, false,false) ;
				  var HeadTitle = "ibflag" ;
				  var HeadCount = ComCountHeadTitle(HeadTitle);
				  
				  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				  InitColumnInfo(HeadCount, 0, 0, true);
				  
				  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				  InitHeadRow(0, HeadTitle, true);
				  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				  InitDataProperty(0,	cnt++,	dtStatus,	50,		daCenter,	false,	"ibflag");
			  }
		  break;
		  }
		}
		
		/**
		 * IBSheet Object를 배열로 등록
		 * comSheetObject(id)에서 호출한다
		 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
		 * 배열은 소스 상단에 정의
		 */
		function setSheetObject(sheet_obj) {
			sheetObjects[sheetCnt++] = sheet_obj;
		}
	 
		/** 
		 * body 태그의 onLoad 이벤트핸들러 구현 <br>
		 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
		 * <br><b>Example :</b>
		 * <pre>
		 * </pre>
		 * @param  없음
		 * @return 없음
		 * @see #
		 * @author Choi Do Soon
		 * @version 2009.11.16
		 */
		function loadPage() {
			frm = document.form;
			for(i=0;i<sheetObjects.length;i++) {
				ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
				initSheet(sheetObjects[i],i+1);
				ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
			}
			var sheetObj = sheetObjects[0];
			
			comboSetting();
			
			// IBMultiCombo 설정
			for(var k = 0; k < comboObjects.length; k++){
				comboObjects[k].DropHeight = 180; //Combo 리스트에 나오는 라인 수 조정
			}
			
			getEasIbComboList2(frm.expn_aud_rslt_cd , expn_aud_rslt_cdCode , expn_aud_rslt_cdText , 'ALL'); //code, name
			getEasIbComboList(frm.auto_aud_sts_cd , auto_aud_sts_cdCode , auto_aud_sts_cdText , 'ALL'); //
			getEasIbComboList(frm.expn_aud_sts_cd , expn_aud_sts_cdCode , expn_aud_sts_cdText , 'ALL'); //

			initControl();
		}	 
		// 콤보셋팅 일괄처리
		function comboSetting(){
			var sheetObj = sheetObjects[0]; 
			frm.f_cmd.value = SEARCH03;
		    var combosXml = sheetObj.GetSearchXml("ESD_EAS_0226GS.do", FormQueryString(frm));
		    
			var arrXml = combosXml.split("|$$|");

			ComXml2ComboItem(arrXml[0], frm.curr_cd, "bil_curr_cd", "bil_curr_cd1");
			
			frm.curr_cd.code2 = window.dialogArguments.form.pop_inv_aud_curr_cd.value;
		}
		function initControl() {
			//axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
			axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
			axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
			
			var parentFrm = window.dialogArguments.form;
			var usr_nm = parentFrm.pop_expn_aud_rslt_usr_nm.value;
			var usr_id = parentFrm.pop_expn_aud_rslt_usr_id.value;
			var ofcLevel = parentFrm.pop_ofcLevel.value;
			var mdlTpCd = parentFrm.pop_mdl_tp_cd.value;
			
			if (usr_nm == "") usr_nm = frm.session_usr_nm.value;
			if (usr_id == "") usr_id = frm.session_usr_id.value;
			
			frm.parent_row.value = parentFrm.pop_parent_row.value;
			frm.expn_aud_rslt_usr_nm.value = usr_nm;
			frm.expn_aud_rslt_usr_id.value = usr_id;
			frm.expn_aud_rslt_rmk.value = parentFrm.pop_expn_aud_rslt_rmk.value;
			frm.mdl_tp_cd.value = parentFrm.pop_mdl_tp_cd.value;
			frm.atch_file_lnk_flg.value = parentFrm.pop_atch_file_lnk_flg.value;
			frm.atch_file_lnk_id.value = parentFrm.pop_atch_file_lnk_id.value;

			frm.auto_aud_sts_cd.Code2 = parentFrm.pop_auto_aud_sts_cd.value;
			frm.expn_aud_sts_cd.Code2 = parentFrm.pop_expn_aud_sts_cd.value;
			frm.expn_aud_rslt_cd.Code2 = parentFrm.pop_expn_aud_rslt_cd.value;
			frm.expn_aud_rslt_display.value = parentFrm.pop_expn_aud_rslt_cd.value;
			frm.inv_no.value = parentFrm.pop_inv_no.value;
						
			frm.expn_aud_rslt_inv_usd_diff_amt.value = parentFrm.pop_inv_usd_diff_amt.value;
			frm.expn_aud_rslt_inv_aud_diff_amt.value = parentFrm.pop_inv_aud_diff_amt.value;
			frm.inv_cfm_dt.value = parentFrm.pop_inv_cfm_dt.value;
			
			frm.auto_aud_sts_cd.Enable=false;
			frm.expn_aud_sts_cd.Enable=false;
			
			// 콤마 생성
			createComma(frm.expn_aud_rslt_inv_usd_diff_amt);
			createComma(frm.expn_aud_rslt_inv_aud_diff_amt);
			
			//HQ, RHQ 오피스가 아닌 경우 저장버튼, 삭제버튼 비활성화
			if (ofcLevel == 'O') {
				ComBtnDisable("btn_save"); // Save 버튼 비활성화
				ComBtnDisable("btn_delete"); // Delete 버튼 비활성화
			}
			
			//Audit Remark가 없을 경우 Delete버튼 비활성화
			var expn_aud_rslt_rmk = frm.expn_aud_rslt_rmk.value;
			if (expn_aud_rslt_rmk == '') {
				ComBtnDisable("btn_delete"); // Delete 버튼 비활성화
			}			
		}	
		 
		//SHEET 관련 프로세스 처리
		function doActionIBSheet(sheetObj, frm, sAction) {
			
			sheetObj.ShowDebugMsg = false;
			switch (sAction) {
				// SEARCH LOGIC
				case IBSEARCH:
					break;
				case REMOVE01:	// Delete시 파일 삭제
					frm.f_cmd.value = REMOVE01;
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0226GS.do", sParam);
					break;
			}
		}
		function obj_blur(){
			var obj = event.srcElement;
			switch(obj.name) {
				case "expn_aud_rslt_inv_aud_diff_amt":
					
				break;			
	
			}
		} 	
		
		function obj_change(sheetObj){
			var obj = event.srcElement;
			switch(obj.name) {
				case "expn_aud_rslt_inv_aud_diff_amt":
					var sheetObj = sheetObjects[0]; 
					frm.f_cmd.value = SEARCH04;
					
					var sParam = FormQueryString(frm);
					var sXml = sheetObj.GetSearchXml("ESD_EAS_0226GS.do", sParam);
					
					var result_expn_aud_rslt_inv_usd_diff_amt = EasXmlString(sXml,"expn_aud_rslt_inv_usd_diff_amt");
					frm.expn_aud_rslt_inv_usd_diff_amt.value = result_expn_aud_rslt_inv_usd_diff_amt;
					break;


			}
		} 
		 /**
		  * Audit Remark 입력값을 Parent 창으로 Return
		  */
		function PopupApply() {
			var parentObj = window.dialogArguments;
			
			removeComma(frm.expn_aud_rslt_inv_aud_diff_amt);
			removeComma(frm.expn_aud_rslt_inv_usd_diff_amt.value);
			
			var expn_curr_cd = frm.curr_cd.text;
			var expn_inv_aud_diff_amt = frm.expn_aud_rslt_inv_aud_diff_amt.value;
			var expn_inv_usd_diff_amt = frm.expn_aud_rslt_inv_usd_diff_amt.value;
			
			var expn_auto_aud_sts_cd = parentObj.form.pop_auto_aud_sts_cd.value;
			
			if( expn_auto_aud_sts_cd == 'F' || expn_auto_aud_sts_cd == 'C') {
				if (expn_inv_aud_diff_amt == null || expn_inv_aud_diff_amt == "") {
					//ComShowCodeMessage('EAS90211'); // Diff AMT가 입력되지 않고 저장될 시 경고 메시지
					alert('Please input Diff amount by auditor.'); // Diff AMT가 입력되지 않고 저장될 시 경고 메시지
					return false;
				}	
			}
			
			
			
			var pRow = frm.parent_row.value;
			
			var expn_aud_rslt_rmk = frm.expn_aud_rslt_rmk.value;
			var expn_aud_rslt_usr_nm = frm.expn_aud_rslt_usr_nm.value;
			var expn_aud_rslt_usr_id = frm.expn_aud_rslt_usr_id.value;
			
			var sCompare1 = ComTrimAll(expn_aud_rslt_rmk.toUpperCase(), " ", "\r\n");
			var sCompare2 = ComTrimAll(frm.expn_aud_rslt_cd.Text.toUpperCase(), " ", "\r\n");
			var sTxt = ComReplaceStr(sCompare1, sCompare2, "");

			//Reasen Name과 Detail의 Text가 완전히 동일할 경우엔 byte로 계산하지 않는다.
			var ret = ComChkLenByByte(sTxt, 10);
			var atch_file_lnk_id = frm.atch_file_lnk_id.value;
			var expn_aud_rslt_cd = frm.expn_aud_rslt_cd.Code;
			if (ret == 1 ) {
				ComShowCodeMessage('EAS90211'); // 10 Byte가 입력되지 않고 저장될시 경고 메시지
				return false;
			}
			if (expn_aud_rslt_cd.length == 0) {
				ComShowCodeMessage('EAS80001', 'Reason'); // Change Reason 미 입력시 경고 메시지
				return false;
			}
			
			parentObj.fn_setAuditRemark2(expn_aud_rslt_rmk, expn_aud_rslt_usr_nm, expn_aud_rslt_usr_id, expn_aud_rslt_cd, 'S', atch_file_lnk_id, expn_curr_cd, expn_inv_aud_diff_amt, expn_inv_usd_diff_amt);
			
			window.close();
		}
		
		function expn_aud_rslt_cd_OnChange(comboObj,Index_Code, Text){   
			var str = Text.split("|");
			for(var i=0; i<str.length; i++){
				if (i == 0) {
					frm.expn_aud_rslt_display.value = str[i];
//				}else{ CHM-201641274 Intensive Audit TRS- Surcharge 조회 기간 확장 요청 및  Auto Audit Grid 추가 
//					frm.expn_aud_rslt_rmk.value = str[i];
				}
			}
		}
		
		function curr_cd_OnChange(){   
			cmaComma(frm.expn_aud_rslt_inv_aud_diff_amt);
		}
		
		 /**
		  * Audit Remark 입력값을 초기화하여 Parent 창으로 Return
		  */
		function PopupDeleteApply() {
			var pRow = frm.parent_row.value;
			var expn_aud_rslt_rmk = '';
			var expn_aud_rslt_usr_nm = frm.expn_aud_rslt_usr_nm.value;
			var expn_aud_rslt_usr_id = frm.expn_aud_rslt_usr_id.value;
			var expn_aud_rslt_cd = '';
			var atch_file_lnk_id = frm.atch_file_lnk_id.value;

        	if (!ComShowCodeConfirm("COM12165", "Change Detail (Including attachments)")) {
        		return false;
        	}
        	if (atch_file_lnk_id.length > 0) { //첨부파일이 존재하면 먼저 삭제한다.
				doActionIBSheet(sheetObjects[0], frm, REMOVE01); 
        	}

        	var atch_file_lnk_id = frm.atch_file_lnk_id.value;
        	
			var parentObj = window.dialogArguments;
			
			frm.curr_cd.text = '';
			frm.expn_aud_rslt_inv_aud_diff_amt.value = '';
			frm.expn_aud_rslt_inv_usd_diff_amt.value = '';
			
			//parentObj.fn_setAuditRemark (expn_aud_rslt_rmk, expn_aud_rslt_usr_nm, expn_aud_rslt_usr_id, expn_aud_rslt_cd, 'S');
			parentObj.fn_setAuditRemark2(expn_aud_rslt_rmk, expn_aud_rslt_usr_nm, expn_aud_rslt_usr_id, expn_aud_rslt_cd, 'S', atch_file_lnk_id, frm.curr_cd.text, frm.expn_aud_rslt_inv_aud_diff_amt.value, frm.expn_aud_rslt_inv_usd_diff_amt.value);

			window.close();
		}
		
		/**
		* File Attach 팝업 호출
		*/
		function openFileAttach() {
			var pRow = frm.parent_row.value;
			var expn_aud_rslt_rmk = frm.expn_aud_rslt_rmk.value;
			var expn_aud_rslt_usr_nm = frm.expn_aud_rslt_usr_nm.value;
			var expn_aud_rslt_usr_id = frm.expn_aud_rslt_usr_id.value;
			var mdl_tp_cd = frm.mdl_tp_cd.value;
			var atch_file_lnk_id = frm.atch_file_lnk_id.value;
			var expn_aud_rslt_cd = frm.expn_aud_rslt_cd.Code;
			var sParam = FormQueryString(frm);

			var parentObj = window.dialogArguments;
			var url = "/hanjin/ESD_EAS_0226.do?"+sParam;
			ComOpenPopup(url, 550, 360, "","1,0,1,1,1", true);
			var atch_file_lnk_id = frm.atch_file_lnk_id.value; //ESD_EAS_0226 화면을 닫을때 값을 설정 

			parentObj.fn_setAuditRemark(expn_aud_rslt_rmk, expn_aud_rslt_usr_nm, expn_aud_rslt_usr_id, expn_aud_rslt_cd, 'F', atch_file_lnk_id);
		}
		
		/**
		* CUR 변경, Diff AMT 변경 이벤트
		*/
		function cmaComma(obj) {
			// 1. 콤마 제거
			removeComma(obj);
			removeComma(frm.expn_aud_rslt_inv_usd_diff_amt);
			
		    // 2. 환율 조회
			var sheetObj = sheetObjects[0]; 
			frm.f_cmd.value = SEARCH04;
			
			var sParam = FormQueryString(frm);
			var sXml = sheetObj.GetSearchXml("ESD_EAS_0226GS.do", sParam);
			
			var result_expn_aud_rslt_inv_usd_diff_amt = EasXmlString(sXml,"expn_aud_rslt_inv_usd_diff_amt");
			frm.expn_aud_rslt_inv_usd_diff_amt.value = result_expn_aud_rslt_inv_usd_diff_amt;
			
			
			// 3. 콤마 생성
			createComma(obj);
			createComma(frm.expn_aud_rslt_inv_usd_diff_amt);
		}
		
		function createComma(obj) {
			var firstNum = obj.value.substring(0,1); // 첫글자 확인 변수
		    var strNum = /^[/,/,0,1,2,3,4,5,6,7,8,9,/]/; // 숫자와 , 만 가능
		    var str = "" + obj.value.replace(/,/gi,''); // 콤마 제거  
		    var regx = new RegExp(/(-?\d+)(\d{3})/);  
		    var bExists = str.indexOf(".",0);  
		    var strArr = str.split('.');  
		 
		    while(regx.test(strArr[0])){  
		        strArr[0] = strArr[0].replace(regx,"$1,$2");  
		    }  
		    if (bExists > -1)  {
		        obj.value = strArr[0] + "." + strArr[1];  
		    } else  {
		        obj.value = strArr[0]; 
		    }
		}
		
		function removeComma(obj) {
			if ( typeof obj.value == "undefined" || obj.value == null || obj.value == "" ) {
		        return;
		    }
		    var txtNumber = '' + obj.value;
		    obj.value = txtNumber.replace(/(,)/g, "");
		}
		
	/* 개발자 작업  끝 */
		