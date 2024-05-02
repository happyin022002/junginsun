/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : fns_inv_0071.js
 *@FileTitle : FNS_INV_0071
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.15
 *@LastModifier : 정휘택
 *@LastVersion : 1.0
 * 2009.05.15 정휘택
 * 1.0 Creation
 * History
 * -------------------------------------------------------- 
 * 2010.11.01 최도순 [] 저장시 REV_SRC_CD null 값 체크 
 * 2011.04.06 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
 * 2011.09.01 오요한 [선처리] INV MRI 관련CUSTOMER CODE체크로직강화
 * 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
 * 2011.11.23 권 민  [CHM-201114430-01] MRI 생성 관련 CREDIT TERM 로직 보완 요청
 * 2012.03.05 김상현 [CHM-201216452-01] (VLCSC) I/B Local charge 관련 USD 선택 기능 보완
 * 2012.04.12 권 민  [CHM-201217167] BOMBB, AR INV_MRI CREATION 보완
 * 2012.11.12 오요한 [CHM-201221172] (현재) VAT성 CHARGE를 기입하더라도 MRI TYPE으로 ERP로 전송되나 실제 VAT에 대한 ACCT는 212111로 보내고 있어 ACCT DIFF 발생의 원임이 됨     
 								  (개선) MOC Type으로 VAT성 Charge (TVA, WHF, AST, VTT, VDT, VST, CDX, VRT, VCT, VET, IEV, CTX) 는 생성하지 못하게 막고, 
         						  System상 에러로 VAT를 조정해야 할 경우 SELADG User 만 MVT Type으로 TVA (Account Code = 212111) 으로만 생성할 수 있도록 변경함. 
 * 2016.05.19 백승일[CHM-201640693]VLCSC MRI IVA 자동계산
 * 2016.06.15 KIM HYUN HWA[CHM-201642164]VLCSC MRI IVA Default 설정 변경 요청(O/B 인 경우 IVA 자동 Checked 제거)
 * 2016.06.17 KIM HYUN HWA[CHM-201642078]인도 세금 변경 관련 MRI 기능 보완(KKC)
=========================================================*/
	/****************************************************************************************
	  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
						[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
						기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	
	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	
	var sheet_container = null;
	
	/**
	 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
	 * @author 한진해운
	 */
	
	/**
	 * fns_inv_0071 : fns_inv_0071 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0071()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0071() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.setComboObject         = setComboObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	var ROWMARK = "|";
	var FIELDMARK = "^";
	var existSvatRegNo = "N";
	
	var usr_ofc_cd = "";
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 Catch <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    initControl();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function initControl() {
		// Axon 이벤트 처리1. 이벤트catch(개발자변경)		
		axon_event.addListenerForm ('change', 'objOnChange', document.form);  
		axon_event.addListenerForm ('beforedeactivate', 'objDeactivate', document.form);
		axon_event.addListener ('keydown', 'objKeyDown', 'form');   
		axon_event.addListenerFormat ('keypress', 'objKeyPress', document.form);
	}
	
	/**
	 * 업무 자바스크립트 OnChange 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objOnChange();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objOnChange() {
		switch(event.srcElement.name){
	
		case "lcl_vvd":
			getExRateSaDate();
			chkLclVvd();
			// 2011.11.23 추가 
			getSADateDueDate();
			break;   
	
		case "io_bnd_cd":
			setButtons();
			getExRateSaDate();
			// 2011.11.23 추가 
			getSADateDueDate();
			break;
	
		case "pol_cd":
			getExRateSaDate();
			// 2011.11.23 추가 
			getSADateDueDate();
			break;
	
		case "pod_cd":
			getExRateSaDate();
			// 2011.11.23 추가 
			getSADateDueDate();
			break;
	
		case "svc_scp_cd":
			getExRate();
			break;
	
		case "cust_cnt_cd":	
			var formObject = document.form;
			if (formObject.cust_seq.value.length != 0 && formObject.cust_seq.value != ""){
				getCustNmByCustCd();
				// 2011.11.23 추가 
				getSADateDueDate();
			}
			break;
			
		case "cust_seq":	        	
	
			//자리수 채우기	            
			var formObject = document.form;	 
			var v_tmp = "";
			if (formObject.cust_seq.value.length != 0 && formObject.cust_seq.value.length < 6) {
				for(i = 0; i < 6 - formObject.cust_seq.value.length; i++){
					v_tmp = v_tmp + "0";
				}
				document.form.cust_seq.value = v_tmp+document.form.cust_seq.value;
			}	    
	
			getCustNmByCustCd();
			// 2011.11.23 추가 
			getSADateDueDate();
			
			break;      
			
		case "cust_rgst_no":	        	
			
			getCustNmByCustRgstNo();
	
			break;
		
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			//ComChkObjValid(event.srcElement);
		}	    
	
	}

	/**
	 * 업무 자바스크립트 Onbeforedeactivate 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objDeactivate()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objDeactivate(){
	
		switch(event.srcElement.name){
		case "eff_dt":
			// 입력Validation 확인 및 마스킹 처리
			ComChkObjValid(event.srcElement);
			break;
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			//ComChkObjValid(event.srcElement);
		}
	
	}    	
	
	/**
	 * 업무 자바스크립트 OnKeyDown 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeyDown();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */	
	function objKeyDown() {
	
		switch(event.srcElement.name){
	
		case "bl_no":
	
			if (event.keyCode == 9 || event.keyCode == 13) {
				//initField();
				document.form.ar_if_no.value = "";
				tabObjects[0].SelectedIndex = 0;
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				getRevSrcCd();
				doVVDRetrieve();
				doRetrieve();
			}
	
			break;   
	
		default:
			//Validation 전체 체크(길이,format,최대,최소 등등)
			//ComChkObjValid(event.srcElement);
		}	    
	
	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeyPress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objKeyPress() {
		switch(event.srcElement.dataformat){
		case "float":
			// 숫자+"."입력하기
			ComKeyOnlyNumber(event.srcElement, "."); break;
	
		case "int":
			// 숫자만 입력하기
			ComKeyOnlyNumber(event.srcElement); break;
	
		case "engup":
	
			switch(event.srcElement.name){
	
			case "cust_cnt_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;		
	
			case "lcl_vvd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "svc_scp_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('upper'); break;	
	
			case "trunk_vvd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "por_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "pol_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "pod_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "del_cd" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
			case "bl_no":
				//영문대문자+숫자입력하기
				ComKeyOnlyAlphabet('uppernum'); 
	
				break;
			case "mst_if_no" :	
				//영문대문자만입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); break;	
	
				
			}
	
			break;              
	
		default:
			//숫자만입력하기
			//ComKeyOnlyNumber(event.srcElement);
		}
	}     

	/**
	 * Customer Name 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getCustNmByCustCd();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getCustNmByCustCd() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		return doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);	
	
	} 
	 
	/**
	 * Customer Name 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getCustNmByCustRgstNo();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getCustNmByCustRgstNo() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC03);		
	} 	 
	
	/**
	 * Office Code, Rev. Type 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getOfcRevCd();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getOfcRevCd() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		    
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC15);	    	
	
	}
	
	/**
	 * Rev. Type 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getRevSrcCd();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getRevSrcCd() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;	
		var arrStr = formObject.ar_ofc_cd.Code.split("^");
		formObject.ofc_cd.value = arrStr[3];
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC16);	    	
	
	}
	 
	 /**
	 * S/A Date, Due Date 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    getSADateDueDate();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 권 민
	 * @version 2011.11.23
	 */
	function getSADateDueDate() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		return doActionIBSheet(sheetObject, formObject, IBSEARCH_ASYNC04);	
	} 
	
	

					
	function getEuCheck() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		    
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);	    	
	
	}
	
	
	/**
	 * Office 변경시 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     ar_ofc_cd_OnChange(comboObj,value,text);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} value cmbObj value
	 * @param {String} text cmbObj text
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function ar_ofc_cd_OnChange(comboObj,value,text) {
	
		var arrStr = value.split("^");
	
		if (arrStr == "" ) { 
			return;
		}	
	
		document.form.cust_cnt_cd.value = arrStr[6].substring(0,2);
	
		if (document.form.classId.value == "") {
			getRevSrcCd();
		} else {
			var sStr = "|TM";        	 
			var arrStr2 = sStr.split("|");
			MakeComboObject2(document.form.rev_src_cd, arrStr2);
			document.form.rev_src_cd.text = "TM";	
		}	
		var sheetObject = sheetObjects[0];
		if (arrStr[16] != "") {
			/* 2017.07.11 인도 세법 변경
			if(arrStr[16] == "GST"){
				sheetObject.CellValue(0, "tva_flg") = "GST/SBC/KKC";
			}else{
			*/
				sheetObject.CellValue(0, "tva_flg") = arrStr[16];
			//}
		}
	
		setButtons();
		
	}

	/**
	 * Rev. Type 변경시 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rev_src_cd_OnChange(comboObj,value,text);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} value cmbObj value
	 * @param {String} text cmbObj text
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function rev_src_cd_OnChange(comboObj,value,text) {
		if (value == "TN" || value == "EQ") {
			setLclVvd(value);
			ComBtnEnable("btn_auto");
		} else {
			ComBtnDisable("btn_auto"); 
		}
	
		if (value == "TM" || value == "TP" || value == "LS" || value == "DT" || value == "RD" || value == "DO" || value == "DM") {
			ComBtnDisable("btn_add");    
			ComBtnDisable("btn_del"); 
		} else {
			ComBtnEnable("btn_add");    
			ComBtnEnable("btn_del");     		
		}
		
		if ((value == "TM" || value == "TN" || value == "EQ") && (document.form.classId.value == "")) {
			
			document.form.eff_dt.className = "input1";
			document.form.eff_dt.readOnly = false;
			document.form.eff_dt.value = document.form.local_time.value.substring(0,4)+"-"
			+ document.form.local_time.value.substring(4,6)+"-"
			+ document.form.local_time.value.substring(6,8);			

		} else {	
			document.form.eff_dt.className = "input2";
			document.form.eff_dt.readOnly = true;
			document.form.eff_dt.value = document.form.eff_dt_tmp.value;
		}
		
		if(document.form.ofc_cd.value == 'VLCSC' && value =='IC' && document.form.io_bnd_cd.value == 'I'){
			document.form.mst_if_no.readOnly = false;
			document.form.mst_if_no.className = "input1";
			document.form.mst_if_no.focus();
		} else{
			document.form.mst_if_no.readOnly = true;
			document.form.mst_if_no.value = '';
			document.form.mst_if_no.className = "input2";
		}
		
		// VT일 경우 그리드를 초기화한다.
		if (value == "VT") {
			//CHG 그리드를 초기화 한다.
			sheetObjects[0].removeAll();
			sheetObjects[1].removeAll();
			initSheet(sheetObjects[0],1,0);
		} 
		
		chrgChk();    
		chkLclVvd(); 
		// 2011.11.23 추가 
		getSADateDueDate();
	}  
	
	/**
	 * Charge Code 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    chrgChk();
	 * </pre>
	 * @param 없음
	 * @return Boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function chrgChk() {  
		var formObj = document.form;	
		var sheetObj = sheetObjects[0];    	
		var revSrcCd = formObj.rev_src_cd.Code; 
	
		for (var j = 1; j < sheetObj.RowCount + 1; j++) {	
	
			var revTpCds = form.rev_src_cds.value;
			//if(sheetObj.CellValue(j, 2) == ""){
			//	return false;
			//}
			if (revTpCds.lastIndexOf("WC") > 0) {
				if (sheetObj.CellValue(j, 2) == "WHF" && revSrcCd != "WC" && revSrcCd != "OC") {
					ComShowCodeMessage("INV00106");					
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
	
				if (sheetObj.CellValue(j, 2) != "WHF" && revSrcCd == "WC") {
					ComShowCodeMessage("INV00106");
					sheetObj.SelectCell(j,2);	
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
			}
	
			if (revTpCds.lastIndexOf("TS") > 0) {
				if ((sheetObj.CellValue(j, 2) == "OTS" || sheetObj.CellValue(j, 2) == "DTS") && revSrcCd != "TS") {
					ComShowCodeMessage("INV00107");
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
	
				if (sheetObj.CellValue(j, 2) != "OTS" && sheetObj.CellValue(j, 2) != "DTS" && revSrcCd == "TS") {
					ComShowCodeMessage("INV00107");
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
			}
	
			if (revTpCds.lastIndexOf("EQ") > 0) {	
				if (sheetObj.CellValue(j, 2) == "CRC" && revSrcCd != "EQ") {
					ComShowCodeMessage("INV00108");
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
	
				if (sheetObj.CellValue(j, 2) != "CRC" && revSrcCd == "EQ") {
					ComShowCodeMessage("INV00108");
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
			}    
	
			if (revTpCds.lastIndexOf("TM") > 0 || revTpCds.lastIndexOf("TN") > 0) {	
	
				if ((revSrcCd == "TM" || revSrcCd == "TN")
						&& !(sheetObj.CellValue(j, 2) == "CFR" || sheetObj.CellValue(j, 2) == "JOP" || sheetObj.CellValue(j, 2) == "TVA")) {
					ComShowCodeMessage("INV00120");
					sheetObj.SelectCell(j,2);
					//sheetObj.CellValue2(j, 2) = "";
					return false;
				}
	
			}   
	
		}
		return true;
	
	}
	
	/**
	 * LCL VVD 세팅 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    setLclVvd(value);
	 * </pre>
	 * @param {String} value Rev. Type Code
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */     
	function setLclVvd(value) {
	
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC13);
		var localTime = formObject.local_time.value;
	
		if (value == "EQ") {
			formObject.lcl_vvd.value = "USAC"+localTime.substring(2,6)+"M";
		} else if (value == "TN") {
			formObject.lcl_vvd.value = "CFDR"+localTime.substring(2,6)+"E";
		}
	
		getExRateSaDate();
	
	}

	/**
	 * 시트값 클릭시 이벤트 처리
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet2_OnClick(sheetObj,Row,Col,Value);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @param {int} Col ibsheet 해당 col
	 * @param {String} value ibsheet 해당 row, col의 값
	 * @return 없음
	 * @author Sang-Hyun Kim
	 * @version 2012.03.05
	 */
	function sheet2_OnClick(sheetObj, Row, Col,Value) {
		if (sheetObj.ColSaveName(Col) == "tva_flg") {
			var formObject = document.form;
			var arrStr = formObject.ar_ofc_cd.Code.split("^");
			var ofcCd = arrStr[1];
			if (formObject.exist_yn.value == "Y" && ofcCd == "VLCSC" && (formObject.io_bnd_cd.value == "I" || (formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y")) && sheetObj.CellValue(Row, "curr_cd").substring(0, 3) == "USD") {
				ComShowCodeMessage("INV00155");
				return;
			}
		}
	}

	/**
	 * 시트값 변경시 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet2_OnChange(sheetObj,Row,Col,Value);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @param {int} Col ibsheet 해당 col
	 * @param {String} value ibsheet 해당 row, col의 값
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet2_OnChange(sheetObj,Row,Col,Value){
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		var formObject = document.form;

		if (sheetObj.ColSaveName(Col) == "per_tp_cd") {
	
			var perTpCd = formObject.per_tp_cds.value;
			if (perTpCd.indexOf("|"+Value) < 0) {
				ComShowCodeMessage("INV00041", "Per"); 
				sheetObj.CellValue2(Row, Col) = "";
				return;
			}
	
		}

		if (sheetObj.ColSaveName(Col) == "chg_cd") {
			if (Value != " "){ 
				
				var arrStr = formObject.ar_ofc_cd.Code.split("^");
				formObject.ofc_cd.value = arrStr[1];
				formObject.p_chg_cd.value = Value;
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC14);	
				
				var chgCds = formObject.chg_cds.value;
				if (chgCds.indexOf(Value) < 0||Value.length!=3) {
					ComShowCodeMessage("INV00041", "Charge"); 
					sheetObj.CellValue2(Row, Col) = "";
					sheetObj.SelectCell(Row, Col) 
					return;
				}
				
				
				//[CHM-201221172] : 2012.11.13
				// (현재) VAT성 CHARGE를 기입하더라도 MRI TYPE으로 ERP로 전송되나 실제 VAT에 대한 ACCT는 212111로 보내고 있어 ACCT DIFF 발생의 원임이 됨     
				// (개선) MOC Type으로 VAT성 Charge (TVA, WHF, AST, VTT, VDT, VST, CDX, VRT, VCT, VET, IEV, GST, CTX) 는 생성하지 못하게 막고, 
				//         System상 에러로 VAT를 조정해야 할 경우 SELADG User 만 MVT Type으로 TVA (Account Code = 212111) 으로만 생성할 수 있도록 변경함. 
				var rev_src_cd = formObject.rev_src_cd.Text;
				if (rev_src_cd == "OC"){
					
					var chg_cd = sheetObjects[0].CellText(Row,"chg_cd");
					
					if (chg_cd == "TVA" || chg_cd == "WHF" || chg_cd == "AST" || chg_cd == "VTT" || chg_cd == "VDT" || chg_cd == "VST" || chg_cd == "CDX" || chg_cd == "VRT" || chg_cd == "VCT" || chg_cd == "VET" || chg_cd == "IEV" || chg_cd == "GST" ||chg_cd == "CTX") {
						ComShowCodeMessage("INV00163");
						sheetObject1.CellValue2(Row, Col) = "";
						return;
					}
				}
				
				
				//rev_src_cd가  IV일때만, 체크한다. - 수정됨.
				//[CHM-201220761] - 2012.10.15 : MRI에서 사용 불가능하도록 규정된 Charge에 대해서, MIV 뿐 아니라 MRI에서 생성시키는 다른 타입의 채권에도 사용하지 못하도록 함.
				//var rev_src_cd = formObject.rev_src_cd.Text;
				// Block Charge -> 허용 Charge 로 변경됨 2015-12-03
				//if (rev_src_cd == "IV"){
				// VLCSC 인 경우 OUTBOUND이며 POL,POD가 둘다 구주 인경우에
				var arrStr = formObject.ar_ofc_cd.Code.split("^");
				var chgCd = Value;
				var ofcCd = arrStr[1];
				var svrId = arrStr[7];
				var invVatChgCd = arrStr[16];
				
 
//				if( ofcCd == "VLCSC" && formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y"){
//					return;
//					
//				}else{
					if (formObject.blck_chg.value == "") {
						ComShowCodeMessage("INV00114");
						sheetObject1.CellValue2(Row, Col) = "";
						return;
					}
//				}
	
				

				if (chrgChk()) {

					if (ofcCd == "VLCSC") {
						formObject.exist_yn.value = "N";
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC18);	

					  if (formObject.io_bnd_cd.value == "I" || (formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y")) {
					  	 if (formObject.exist_yn.value == "Y") {
								if (chgCd == "WHS" || chgCd == "BCU" || chgCd == "WHT") {
									sheetObj.CellValue(Row, "tva_flg") = "0";
									sheetObj.CellEditable(Row, "tva_flg") = false;
								}else if (chgCd == "IVA") {
									sheetObj.CellValue(Row, "tva_flg") = "0";
									sheetObj.CellEditable(Row, "tva_flg") = false;
								} else {
									// 다른 값을 선택 했다가 다시 local 지역, In bound, 'USD' 선택시 tva_flg 값을 unchecked로 초기화. by Sang-Hyun Kim - 2012.03.05
									if (sheetObj.CellValue(Row, "curr_cd").substring(0, 3) == "USD") {
										sheetObj.CellValue(Row, "tva_flg") = "0";
										sheetObj.CellEditable(Row, "tva_flg") = false;
									} else {
										if (formObject.io_bnd_cd.value == "I" ){
									     	sheetObj.CellValue(Row, "tva_flg") = "1";
									     }
										sheetObj.CellEditable(Row, "tva_flg") = true;
									}
								}
																
							} else {
								sheetObj.CellValue(Row, "tva_flg") = "0";
								sheetObj.CellEditable(Row, "tva_flg") = false;								
							}	
						}

						//ar ofc가 VLCSC 인 경우, inv_ar_locl_chg 테이블에 ar ofc code 'VLCSC'로 등록되어 있는 chg code 입력 시에
						// cur가 'EUR'만 가능토록 수정
						if (formObject.exist_yn.value == "Y") {
							// In bound 일 경우에도 'EUR', 'USD' 선택 입력할 수 있도록 수정. by Sang-Hyun Kim - 2012.03.05
							addCellComboItem(sheetObj,"EUR^2|USD^2","curr_cd",true);
						} else {
							sheetObj.CellEditable(Row, "curr_cd") = true;
						}						
					} else {	   
						var chg_cd = sheetObjects[0].CellText(Row,"chg_cd");
						if (ofcCd == "CMBSC" && chg_cd == "VDS") {
							
							if (!chkSvatRegNo(Row)) {
								return;
							}
						}
						if (invVatChgCd != "" && chgCd != "TVA") {
							sheetObject1.CellEditable(Row, "tva_flg") = true;
						} else {
							sheetObject1.CellEditable(Row, "tva_flg") = false;
						}	    
						
						// [CHM-201217167] 수정 by Kwon Min 2012.04.05
						if (invVatChgCd == chg_cd) {
							// uncheck 로 값을 setting 후 editable 불가능하게 처리
							sheetObject1.CellValue(Row, "tva_flg") = 0;
							sheetObject1.CellEditable(Row, "tva_flg") = false;
						} else {
							sheetObject1.CellEditable(Row, "tva_flg") = true;
						}
						
						if (ofcCd == "BOMSC" && (chg_cd == "SBC" || chg_cd == "KKC")){
						   sheetObject1.CellValue(Row, "tva_flg") = 0;
						   sheetObject1.CellEditable(Row, "tva_flg") = false;
				         }
	
					}
	              
				} else {
					if (ofcCd == "VLCSC" && (formObject.io_bnd_cd.value == "I" ||(formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y"))) {

						sheetObj.CellValue(Row, "tva_flg") = "0";
					}					
					
				}
	
			}
	
		}
 
		if (sheetObj.ColSaveName(Col) == "rat_as_cntr_qty") {
			if (Value <= 0 && Value != "") {
				ComShowCodeMessage("INV00105");
				sheetObj.CellValue2(sheetObj.SelectRow, "rat_as_cntr_qty") = "";
				return;
			}
			
			var chg_cd = sheetObj.CellText(Row,"chg_cd");

			var arrStr = formObject.ar_ofc_cd.Code.split("^");
			var ofcCd = arrStr[1];
			
			if ( chg_cd == "IVA" && ofcCd == "VLCSC" &&(formObject.io_bnd_cd.value == "I" || (formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y"))) {
				
				var ratVal = sheetObj.CellText(Row, "rat_as_cntr_qty");
				if (ratVal != null && ComTrim(ratVal) !="") {
					ratVal = parseInt(ratVal);
					//if (ratVal != 16 && ratVal != 18 && ratVal != 21) {
					if (ratVal != 18 && ratVal != 21) {
						ComShowCodeMessage("INV00159");
						var vatChgRt = arrStr[17];
						sheetObj.CellValue(sheetObj.SelectRow, "rat_as_cntr_qty") =vatChgRt;
						sheetObj.SelectCell(Row,"rat_as_cntr_qty");
						return;
					}
				} else {
					ComShowCodeMessage("INV00159");
					var vatChgRt = arrStr[17];
					sheetObj.CellValue(sheetObj.SelectRow, "rat_as_cntr_qty") =vatChgRt;
					sheetObj.SelectCell(Row ,"rat_as_cntr_qty");
					return;
				}
			}				
		}
	
		if (sheetObj.ColSaveName(Col) == "trf_rt_amt") {
	
			if(formObject.rev_src_cd.Code == "IV") {
				//2010-04-28 이상희과장
				//if (Value < 1 && Value != "") {
				if (Value < 0 && Value != "") {
					ComShowCodeMessage("INV00101");
					sheetObj.CellValue2(sheetObj.SelectRow, "trf_rt_amt") = "";
					return;	
				}
			} else if(formObject.rev_src_cd.Code == "IC") {
				//2010-04-28 이상희과장
				//if (Value > -1 && Value != "") {
				if (Value > 0 && Value != "") {
					ComShowCodeMessage("INV00102");
					sheetObj.CellValue2(sheetObj.SelectRow, "trf_rt_amt") = "";
					return;
				}
			}
		}
	
		if (sheetObj.ColSaveName(Col) == "curr_cd") {
	
			var arrStr = formObject.ar_ofc_cd.Code.split("^");	 		        	 
			var loclCurr = arrStr[4].substring(0,3); 
			var ofcCd = arrStr[1];
			var svrId = arrStr[7];
			var tvaFlg = sheetObj.CellValue(Row, 9);
	
			var currCds = formObject.curr_cds.value;
			if (currCds.indexOf(Value) < 0) {
				ComShowCodeMessage("INV00041", "Currency"); 
				sheetObj.CellValue2(Row, Col) = arrStr[4]+"^"+arrStr[9]; 
				return;
			}

			var chgCd = sheetObj.CellValue(Row, "chg_cd");

			if(ofcCd == "VLCSC"){
				getEuCheck();
			}
			
			if (chgCd != "" && (formObject.io_bnd_cd.value == "I"||(formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y" ))) {
				if (formObject.exist_yn.value == "Y") {
					if (chgCd == "WHS" || chgCd == "BCU" || chgCd == "WHT") {
						sheetObj.CellValue(Row, "tva_flg") = "0";
						sheetObj.CellEditable(Row, "tva_flg") = false;
					} else if (chgCd == "IVA") {
						sheetObj.CellValue(Row, "tva_flg") = "0";
						sheetObj.CellEditable(Row, "tva_flg") = false;
					} else {
						// In bound일 경우에도 'USD'를 허용하고 'USD'일 경우 tva_flag값은 unchecked로 변경. by Sang-Hyun Kim - 2012.03.05
						if (sheetObj.CellValue(Row, "curr_cd").substring(0, 3) == "USD") {
							sheetObj.CellValue(Row, "tva_flg") = "0";
							sheetObj.CellEditable(Row, "tva_flg") = false;
						} else {
							if (formObject.io_bnd_cd.value == "I") {
							  sheetObj.CellValue(Row, "tva_flg") = "1";
							}
							sheetObj.CellEditable(Row, "tva_flg") = true;
						}
					}
				} else {
					sheetObj.CellValue(Row, "tva_flg") = "0";
					sheetObj.CellEditable(Row, "tva_flg") = false;
				}
			}

			tvaFlg = sheetObj.CellValue(Row, 9);

			if (ofcCd == "VLCSC" || svrId == "KOR") {

				if (tvaFlg == 1 && loclCurr != Value.substring(0,3)) {
					ComShowCodeMessage("INV00118", Value.substring(0,3));
					sheetObj.CellValue2(Row, Col) = "";
					return;
				}
	
			}
			
			if (tvaFlg == 1) {
				sheetObj.CellValue2(sheetObj.RowCount, Col) = Value;
	
			}
	
		}
	
		if (sheetObj.ColSaveName(Col) == "trf_rt_amt"
			|| sheetObj.ColSaveName(Col) == "rat_as_cntr_qty"
				|| sheetObj.ColSaveName(Col) == "per_tp_cd"
					|| sheetObj.ColSaveName(Col) == "curr_cd") {
			
			var rated_as = sheetObj.CellValue(sheetObj.SelectRow, "rat_as_cntr_qty");
			var rate = sheetObj.CellValue(sheetObj.SelectRow, "trf_rt_amt");
			var per = sheetObj.CellValue(sheetObj.SelectRow, "per_tp_cd");
			var cur = sheetObj.CellValue(sheetObj.SelectRow, "curr_cd").split(FIELDMARK);

			if (document.form.classId.value == "") {
				var point = cur[1];
			} else {
				var point = sheetObj.CellValue(sheetObj.SelectRow, 11);
			}
	
			var amount = rated_as * rate;
	
			if(rated_as != "" && rate != "" && per != ""){
				if (point == '0' || point == undefined) {
					sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfInteger);
				} else {
					sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
				}
				
				if (per == "PC") { 			
					sheetObj.CellValue2(sheetObj.SelectRow, 7) = amount / 100;	    			
				} else {
					sheetObj.CellValue2(sheetObj.SelectRow, 7) = amount;
				}

				if (sheetObj.CellValue(Row, "tva_flg") == "1") {
					setChgSumTvaClick(sheetObj,Row);
				}
				
				setSummary();
				getExRate();
				//sheetObj.CellValue(sheetObj.SelectRow, 10) = formObject.ex_rate.value;
			} else {
				sheetObj.CellValue(sheetObj.SelectRow, 7) = "";
	
			}
			if (sheetObj.CellValue(Row, Col) == "") {
				sheetObj.SelectCell(Row, Col, false);
			}
	
		}
	
		if (sheetObj.ColSaveName(Col) == "tva_flg") {
	
			//[CHM-201221172] : 2012.11.13
			// (현재) VAT성 CHARGE를 기입하더라도 MRI TYPE으로 ERP로 전송되나 실제 VAT에 대한 ACCT는 212111로 보내고 있어 ACCT DIFF 발생의 원임이 됨     
			// (개선) MOC Type으로 VAT성 Charge (TVA, WHF, AST, VTT, VDT, VST, CDX, VRT, VCT, VET, IEV, GTS) 는 생성하지 못하게 막고, 
			//         System상 에러로 VAT를 조정해야 할 경우 SELADG User 만 MVT Type으로 TVA (Account Code = 212111) 으로만 생성할 수 있도록 변경함. 
			var rev_src_cd = formObject.rev_src_cd.Text;
			if (rev_src_cd == "OC"){
				ComShowCodeMessage("INV00163");
				sheetObj.CellValue2(Row, "tva_flg") = "0";
				return;
			}
			
			sheetObj.CellEditable(Row, Col) = false; 
			setChgSumTvaClick(sheetObj,Row);
		
			setSummary();
			getExRate();
			//sheetObj.CellValue(sheetObj.SelectRow, 10) = formObject.ex_rate.value;
			sheetObj.CellEditable(Row, Col) = true; 
	
		}
	
//		if (sheetObj.ColSaveName(Col) == "trf_rt_amt"
//			|| sheetObj.ColSaveName(Col) == "rat_as_cntr_qty"
//				|| sheetObj.ColSaveName(Col) == "per_tp_cd") {
//	
//			if (sheetObj.CellValue(Row, "trf_rt_amt") != "" 
//				&& sheetObj.CellValue(Row, "rat_as_cntr_qty") != ""
//					&& sheetObj.CellValue(Row, "per_tp_cd") != "") {
//				addChgSumRateChange(sheetObj,Row);
//				setSummary();
//				getExRate();
//				sheetObj.CellValue(sheetObj.SelectRow, 10) = formObject.ex_rate.value;
//				if (sheetObj.CellValue(Row, Col) == "") {
//					sheetObj.SelectCell(Row, Col, false);
//				}
//			}	
//		}    
	
	}
	
	/**
	 * TVA 클릭시 Charge Sum 계산 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setChgSumTvaClick(sheetObj,Row);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */     	
	function setChgSumTvaClick(sheetObj,Row){
	  
		var tvaChgCd = sheetObj.CellValue(sheetObj.RowCount, "chg_cd");  
		var cur = sheetObj.CellValue(Row, "curr_cd").split(FIELDMARK);
		var point = cur[1];
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;

		var rated = sheetObj.CellValue(Row, "trf_rt_amt");
		var rateAs = sheetObj.CellValue(Row, "rat_as_cntr_qty");
		var perTpCd = sheetObj.CellValue(Row, "per_tp_cd");

		var arrStr = formObject.ar_ofc_cd.Code.split("^");
		
		formObject.ofc_cd.value = arrStr[1];
		var arOfcCd = arrStr[1];
		var vatChgRt = arrStr[17];
		var addrow1 = 0;
		var addrow2 = 0;
		
		
		if(arOfcCd == 'VLCSC' && formObject.io_bnd_cd.value == 'I' && formObject.rev_src_cd.Code == "IC"){
//		if(arOfcCd == 'VLCSC'  && formObject.rev_src_cd.Code == "IC"){
			if(formObject.mst_if_no.value != ''){
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC05);	
				if(formObject.iva_rate.value != ''){
					//if(formObject.iva_rate.value=='16'||formObject.iva_rate.value=='18'||formObject.iva_rate.value=='21'){
					if(formObject.iva_rate.value=='18'||formObject.iva_rate.value=='21'){
						vatChgRt = formObject.iva_rate.value;
					}
				}	
			} else {
				ComShowCodeMessage("COM130201", "Master I/F No.");
			}
		}
	
		var chgAmtSum2 = 0;

		if (rated != "" && rated != "0" && rateAs != "" && rateAs != "0" && perTpCd != "") {
			var tvaFlg = sheetObj.CellValue(sheetObj.SelectRow, 9);
			var tvaFlgCnt = 0;
			var chgAmt = 0;
			var chgAmtSum = 0;
			var chgSum = 0;
			for (var i = 1; i < sheetObj.RowCount + 1; i++) {     				
	

				if( sheetObj.CellValue(i, "tva_flg") == "1" && sheetObj.CellValue(i, "new_flg") != "Y"){
					tvaFlgCnt++;					
					chgAmt = sheetObj.CellValue(i, "chg_amt") == "" ? "0" : ComTrimAll(sheetObj.CellValue(i, "chg_amt"),",");
					chgAmtSum = parseFloat(chgAmtSum) + parseFloat(chgAmt);
					chgSum = parseFloat(chgSum) + parseFloat(chgAmt) * parseFloat(vatChgRt) / 100;
 
	
				}
			}
	
			if(tvaFlg == "1") {
				
				if (tvaFlgCnt >= 1) {
							
					if(sheetObj.CellValue(sheetObj.LastRow, "new_flg") != "Y"){	
						sheetObj.DataInsert(-1);
 
						// [CHM-201217167] 추가
						// 새로 생성되는 row 의 new_flg 값을 Y 로 setting
						
						//2017.07.11 인도 세법 변경
						//if(arOfcCd != 'BOMSC'){
							sheetObj.CellValue(sheetObj.LastRow, "new_flg") = "Y";
						//}
 
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);	 
					}
				}  	
					
				if (point == '0' || point == undefined) {
					sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfInteger);
				} else {
					sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
				}
					
				sheetObj.CellValue2(sheetObj.RowCount, "chg_cd") = arrStr[16] != "" ? arrStr[16] : "TVA"; 
				getExRate();
				
				// 이미 값이 설정되어 있을 가능성이 있으므로 초기화(18) 하지 않는다.
				var ratVal = sheetObj.CellText(sheetObj.RowCount, "rat_as_cntr_qty");
				if (ratVal != null && ComTrim(ratVal) !="") {
					ratVal = parseInt(ratVal);
					//if (ratVal != 16 && ratVal != 18 && ratVal != 21) {
					if (ratVal != 18 && ratVal != 21) {
						sheetObj.CellValue2(sheetObj.RowCount, "rat_as_cntr_qty") = vatChgRt;
					}
				} else {
					sheetObj.CellValue2(sheetObj.RowCount, "rat_as_cntr_qty") = vatChgRt;
				}
				
				sheetObj.CellValue2(sheetObj.RowCount, "per_tp_cd") = "PC";
				sheetObj.CellValue2(sheetObj.RowCount, "curr_cd") = arrStr[4]+"^"+arrStr[9];
				sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * vatChgRt / 100;
				sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
				
				if (sheetObj.CellValue(sheetObj.RowCount, "trf_rt_amt") == "0") {
					sheetObj.RowEditable(sheetObj.RowCount) = true; 
					sheetObj.CellEditable(sheetObj.RowCount, "chg_cd") = false; 
				} else {
					sheetObj.RowEditable(sheetObj.RowCount) = false; 
				}
	
				// Office가 VLCSC 이며,  I/O Bound 가 Inbound 일때 "Rated As" 부분 수정가능
				if (arOfcCd == 'VLCSC' && (formObject.io_bnd_cd.value == 'I' || (formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y" ))){
//				if (arOfcCd == 'VLCSC' ){
					sheetObj.RowEditable(sheetObj.RowCount) = true; 
					sheetObj.CellEditable(sheetObj.RowCount, "chg_cd") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "curr_cd") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "trf_rt_amt") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "rat_as_cntr_qty") = true; 
					sheetObj.CellEditable(sheetObj.RowCount, "per_tp_cd") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "chg_amt") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "chg_rmk") = false; 
					sheetObj.CellEditable(sheetObj.RowCount, "tva_flg") = false; 
				}
	
			}else if(tvaFlg == "0") {
				
				if (tvaFlgCnt == 0) {
					sheetObj.RowDelete(sheetObj.RowCount, false);
					sheetObj.CellValue(sheetObj.LastRow, "new_flg") = "";
				} else {
	
					sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * vatChgRt / 100;
					sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
	
				}    			
			}
			
			/* 2017.07.11 인도 세법 변경
			if(tvaFlg == "1" && arOfcCd == 'BOMSC'){
				if (tvaFlgCnt >= 1) {

					if(sheetObj.CellValue(sheetObj.LastRow, "new_flg") != "Y"){	
						addrow1 = sheetObj.DataInsert(-1); //SBC
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);
						addrow2 = sheetObj.DataInsert(-1); //KKC
						
						sheetObj.CellValue(sheetObj.LastRow -2, "new_flg") = "Y";
						sheetObj.CellValue(sheetObj.LastRow -1, "new_flg") = "Y";
						sheetObj.CellValue(sheetObj.LastRow, "new_flg") = "Y";
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);	 
					}
				}  	
				
				if (point == '0' || point == undefined) {
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.LastRow -1, 7, dtData , daRight , "chg_amt", "", dfInteger);
					sheetObj.InitCellProperty(sheetObj.LastRow, 7, dtData , daRight , "chg_amt", "", dfInteger);
				} else {
					//sheetObj.InitCellProperty(sheetObj.SelectRow, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
					sheetObj.InitCellProperty(sheetObj.LastRow -1, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
					sheetObj.InitCellProperty(sheetObj.LastRow, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
				}
				//sheetObj.CellValue2(sheetObj.RowCount, "chg_cd") = "SBC"; 
				sheetObj.CellValue2(sheetObj.LastRow -1, "chg_cd") = "SBC"; 
				sheetObj.CellValue2(sheetObj.LastRow, "chg_cd") = "KKC"; 
				getExRate();
			
				// 이미 값이 설정되어 있을 가능성이 있으므로 초기화(18) 하지 않는다.
				var ratVal = sheetObj.CellText(sheetObj.RowCount, "rat_as_cntr_qty");
				var sbcVatChgRt = 0.5 ;
				var kkcVatChgRt = 0.5 ;
				var gstVatChgRt = 14 ;
 
					ratVal = parseInt(ratVal);
					
//					sheetObj.CellValue2(sheetObj.RowCount-1, "rat_as_cntr_qty") = gstVatChgRt;
//					sheetObj.CellValue2(sheetObj.RowCount-1, "per_tp_cd") = "PC";
//					sheetObj.CellValue2(sheetObj.RowCount-1, "curr_cd") = arrStr[4]+"^"+arrStr[9];
//					sheetObj.CellValue2(sheetObj.RowCount-1, "trf_rt_amt") = chgAmtSum;
//					chgAmtSum2 = chgAmtSum * gstVatChgRt / 100;
//					sheetObj.CellValue2(sheetObj.RowCount-1, "chg_amt") = chgAmtSum2.toFixed(2);
//					if (sheetObj.CellValue(sheetObj.RowCount-1, "trf_rt_amt") == "0") {
//						sheetObj.RowEditable(sheetObj.RowCount-1) = true; 
//						sheetObj.CellEditable(sheetObj.RowCount-1, "chg_cd") = false; 
//					} else {
//						sheetObj.RowEditable(sheetObj.RowCount -1) = false; 
//					}
//					
//					
//					sheetObj.CellValue2(sheetObj.RowCount, "rat_as_cntr_qty") = sbcVatChgRt;
//					sheetObj.CellValue2(sheetObj.RowCount, "per_tp_cd") = "PC";
//					sheetObj.CellValue2(sheetObj.RowCount, "curr_cd") = arrStr[4]+"^"+arrStr[9];
//					sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
//					chgAmtSum2 = chgAmtSum * sbcVatChgRt / 100;
//					sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
//					if (sheetObj.CellValue(sheetObj.RowCount, "trf_rt_amt") == "0") {
//						sheetObj.RowEditable(sheetObj.RowCount) = true; 
//						sheetObj.CellEditable(sheetObj.RowCount, "chg_cd") = false; 
//					} else {
//						sheetObj.RowEditable(sheetObj.RowCount) = false; 
//					}

					sheetObj.CellValue2(sheetObj.RowCount-2, "rat_as_cntr_qty") = gstVatChgRt;
					sheetObj.CellValue2(sheetObj.RowCount-2, "per_tp_cd") = "PC";
					sheetObj.CellValue2(sheetObj.RowCount-2, "curr_cd") = arrStr[4]+"^"+arrStr[9];
					sheetObj.CellValue2(sheetObj.RowCount-2, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * gstVatChgRt / 100;
					sheetObj.CellValue2(sheetObj.RowCount-2, "chg_amt") = chgAmtSum2.toFixed(2);
					if (sheetObj.CellValue(sheetObj.RowCount-2, "trf_rt_amt") == "0") {
						sheetObj.RowEditable(sheetObj.RowCount-2) = true; 
						sheetObj.CellEditable(sheetObj.RowCount-2, "chg_cd") = false; 
					} else {
						sheetObj.RowEditable(sheetObj.RowCount -2) = false; 
					}
        
					
					sheetObj.CellValue2(sheetObj.RowCount-1, "rat_as_cntr_qty") = sbcVatChgRt;
					sheetObj.CellValue2(sheetObj.RowCount-1, "per_tp_cd") = "PC";

					sheetObj.CellValue2(sheetObj.RowCount-1, "curr_cd") = arrStr[4]+"^"+arrStr[9];
					sheetObj.CellValue2(sheetObj.RowCount-1, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * sbcVatChgRt / 100;
					sheetObj.CellValue2(sheetObj.RowCount-1, "chg_amt") = chgAmtSum2.toFixed(2);
					if (sheetObj.CellValue(sheetObj.RowCount-1, "trf_rt_amt") == "0") {
						sheetObj.RowEditable(sheetObj.RowCount-1) = true; 
						sheetObj.CellEditable(sheetObj.RowCount-1, "chg_cd") = false; 
					} else {
						sheetObj.RowEditable(sheetObj.RowCount-1) = false; 
					}
					
					sheetObj.CellValue2(sheetObj.RowCount, "rat_as_cntr_qty") = kkcVatChgRt;
					sheetObj.CellValue2(sheetObj.RowCount, "per_tp_cd") = "PC";
					
					sheetObj.CellValue2(sheetObj.RowCount, "curr_cd") = arrStr[4]+"^"+arrStr[9];
					sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * kkcVatChgRt / 100;
					sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
					if (sheetObj.CellValue(sheetObj.RowCount, "trf_rt_amt") == "0") {
						sheetObj.RowEditable(sheetObj.RowCount) = true; 
						sheetObj.CellEditable(sheetObj.RowCount, "chg_cd") = false; 
					} else {
						sheetObj.RowEditable(sheetObj.RowCount) = false; 
					}
					
 
	
			} 
			else if(tvaFlg == "0"  && arOfcCd == 'BOMSC') {

				if (tvaFlgCnt == 0) {
					sheetObj.RowDelete(sheetObj.RowCount, false);
					sheetObj.RowDelete(sheetObj.RowCount, false);
	
					sheetObj.CellValue(sheetObj.LastRow, "new_flg") = "";
				} else {
					sheetObj.CellValue2(sheetObj.RowCount -2, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * 14 / 100;
					sheetObj.CellValue2(sheetObj.RowCount -2 , "chg_amt") = chgAmtSum2.toFixed(2);
					
					sheetObj.CellValue2(sheetObj.RowCount-1, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * 0.5 / 100;
					sheetObj.CellValue2(sheetObj.RowCount-1, "chg_amt") = chgAmtSum2.toFixed(2);

					
					sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
					chgAmtSum2 = chgAmtSum * 0.5 / 100;
					sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
	
				}    			
			}
			*/
		}
	
	}
	
	/**
	 * Row delete 클릭시 Charge Sum 계산 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setChgSumRowDelete();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */    
	function setChgSumRowDelete(){
	
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		var arrStr = formObject.ar_ofc_cd.Code.split("^");
		var vatChgRt = arrStr[17];
		var arOfcCd = arrStr[1];
		var chgCd = sheetObject1.CellValue(sheetObject1.RowCount, "chg_cd");
		var chgAmt = 0;
		var chgAmtSum = 0;
		var chgSum = 0;
		var chgAmtSum2 = 0;
		for(var i = 1; i < sheetObject1.RowCount; i++) {
			if (sheetObject1.CellValue(i, "tva_flg") == "1") {				
				chgAmt = sheetObject1.CellValue(i, "chg_amt") == "" ? "0" : sheetObject1.CellValue(i, "chg_amt");					
				chgAmtSum = parseFloat(chgAmtSum) + parseFloat(chgAmt);
				chgSum = parseFloat(chgSum) + parseFloat(chgAmt) * parseFloat(vatChgRt) / 100;
				
			}    		
		}

		if(arOfcCd =="BOMSC"){ 
			if (sheetObject1.RowCount > 0 ) {
				sheetObject1.CellValue2(sheetObject1.RowCount-2, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * vatChgRt / 100;
				sheetObject1.CellValue2(sheetObject1.RowCount-2, "chg_amt") = chgAmtSum2.toFixed(2);
				
				sheetObject1.CellValue2(sheetObject1.RowCount-1, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * 0.5 / 100;
				sheetObject1.CellValue2(sheetObject1.RowCount-1, "chg_amt") = chgAmtSum2.toFixed(2);
				
				sheetObject1.CellValue2(sheetObject1.RowCount, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * 0.5 / 100;
				sheetObject1.CellValue2(sheetObject1.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
				
			}
		}else{
			if (sheetObject1.RowCount > 0 &&  chgCd == arrStr[16]) {
				sheetObject1.CellValue2(sheetObject1.RowCount, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * vatChgRt / 100;
				sheetObject1.CellValue2(sheetObject1.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
			}
		}
	
	}
	
	/**
	 * Rate 변경시 Charge Sum 계산 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addChgSumRateChange(sheetObj,Row);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */   
	function addChgSumRateChange(sheetObj,Row){
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
	
		var tvaChgCd = sheetObj.CellValue(sheetObj.RowCount, "chg_cd");  
		var rated = sheetObj.CellValue(Row, "trf_rt_amt");
		var rateAs = sheetObj.CellValue(Row, "rat_as_cntr_qty");
		var perTpCd = sheetObj.CellValue(Row, "per_tp_cd");
		var arrStr = formObject.ar_ofc_cd.Code.split("^");
		var vatChgRt = arrStr[17];
		var invVatChgCd = arrStr[16] != "" ? arrStr[16] : "TVA";  
	
		if (rated != "" && rated != "0" && rateAs != "" && rateAs != "0" && perTpCd != "") {
			var tvaFlg = sheetObj.CellValue(sheetObj.SelectRow, 9);
	
			var tvaFlgCnt = 0;
			var chgAmt = 0;
			var chgAmtSum = 0;
			var chgSum = 0;
			var chgAmtSum2 = 0;
			for (var i = 1; i < sheetObj.RowCount + 1; i++) {     				
	
				if (sheetObj.CellValue(i, "tva_flg") == "1") {					
					tvaFlgCnt++;					
					chgAmt = sheetObj.CellValue(i, "chg_amt") == "" ? "0" : sheetObj.CellValue(i, "chg_amt");					
					chgAmtSum = parseFloat(chgAmtSum) + parseFloat(chgAmt);
					chgSum = parseFloat(chgSum) + parseFloat(chgAmt) * parseFloat(vatChgRt) / 100;
				}				
	
			}
	
			if(tvaFlg == "1") {
	
				if (tvaFlgCnt > 0) {
					if (tvaChgCd != invVatChgCd) {
						sheetObj.DataInsert(-1);
						doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);	
					}
	
				}  	
	
				var cur = sheetObj.CellValue(Row, "curr_cd").split(FIELDMARK);
				var point = cur[1];
	
				if (point == '0' || point == undefined) {
					sheetObj.InitCellProperty(sheetObj.RowCount, 7, dtData , daRight , "chg_amt", "", dfInteger);
				} else {
					sheetObj.InitCellProperty(sheetObj.RowCount, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
				}
	
				sheetObj.CellValue2(sheetObj.RowCount, "chg_cd") = arrStr[16] != "" ? arrStr[16] : "TVA";    
				getExRate();
	//			sheetObj.CellValue2(sheetObj.RowCount, "inv_xch_rt") = formObject.ex_rate.value;
	
				sheetObj.CellValue2(sheetObj.RowCount, "rat_as_cntr_qty") = vatChgRt;				
				sheetObj.CellValue2(sheetObj.RowCount, "per_tp_cd") = "PC";
	
				sheetObj.CellValue2(sheetObj.RowCount, "curr_cd") = arrStr[4]+"^"+arrStr[9];
	
				sheetObj.CellValue2(sheetObj.RowCount, "trf_rt_amt") = chgAmtSum;
				chgAmtSum2 = chgAmtSum * vatChgRt / 100;
				sheetObj.CellValue2(sheetObj.RowCount, "chg_amt") = chgAmtSum2.toFixed(2);
	
				sheetObj.RowEditable(sheetObj.RowCount) = false; 
	
			} 
	
		}
	
	}
	
	/**
	 * VLCSC Office의 Charge Sum 추가 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addChgSumVlcbb(chgCd, bnd);
	 * </pre>
	 * @param {String} chgCd CHG
	 * @param {String} bnd BND
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */  
	function addChgSumVlcbb(chgCd, bnd){
		
		getEuCheck();
		
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
	
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");		
		var eu_check = formObject.eu_check.value;
		var tvaChgCnt = 0;
		var tvaChgRow = 0;
		var invVatChgCd = arrStr2[16] != "" ? arrStr2[16] : "TVA";  
	
		for (var i = 1; i < sheetObject1.RowCount + 1; i++) {   	 				
			if (sheetObject1.CellValue(i, "chg_cd") == invVatChgCd) {
				tvaChgCnt++;	
				tvaChgRow = i;
			}
		}	 			 
 
		if (tvaChgCnt == 0) {
			sheetObject1.DataInsert(-1);  
			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);				
			sheetObject1.CellValue2(sheetObject1.RowCount, "chg_cd") = chgCd;
	
			if (bnd == "I" || (bnd == "O" && eu_check =="Y")) {
	
				if (chgCd == "WHS"||chgCd == "WHT") {
					sheetObject1.CellEditable(sheetObject1.RowCount, "tva_flg") = false;
					sheetObject1.CellValue(sheetObject1.RowCount, "tva_flg") = "0";
				} else {
					sheetObject1.CellEditable(sheetObject1.RowCount, "tva_flg") = true;
					if (bnd == "I"){
					  sheetObject1.CellValue(sheetObject1.RowCount, "tva_flg") = "1";
					}
				}
	
			}
			//else {
	
				//sheetObject1.CellEditable(sheetObject1.RowCount, "tva_flg") = false;
			//}
	
		} else {	 				 
			sheetObject1.DataInsert(tvaChgRow - 1);   
			doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);				
			sheetObject1.CellValue2(tvaChgRow, "chg_cd") = chgCd;
	
			if (bnd == "I" || (bnd == "O" && eu_check =="Y")) {
	
				if (chgCd == "WHS"||chgCd == "WHT") {
					sheetObject1.CellEditable(tvaChgRow, "tva_flg") = false;
					sheetObject1.CellValue(tvaChgRow, "tva_flg") = "0";
				} else {
					sheetObject1.CellEditable(tvaChgRow, "tva_flg") = true;
					if(bnd == "I"){
					 sheetObject1.CellValue(tvaChgRow, "tva_flg") = "1";
					}
				}
	
			}// else {
	
			//	sheetObject1.CellEditable(tvaChgRow, "tva_flg") = false;
	
			//}
		}			
	
		var rowCnt1 = sheetObject2.RowCount;
	
		if (rowCnt1 == 0) {
			sheetObject2.DataInsert(-1);
			sheetObject2.CellValue(sheetObject2.SelectRow, 1) = arrStr2[4];
			sheetObject2.CellValue(sheetObject2.SelectRow, 4) = arrStr2[4];
		}
	
		sheetObject1.CellValue2(sheetObject1.SelectRow, "curr_cd") = arrStr2[4]+"^"+arrStr2[9]; 
		
		formObject.p_chg_cd.value = chgCd;
		formObject.exist_yn.value = "N";
		doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC18);
		//ar ofc가 VLCSC 인 경우, inv_ar_locl_chg 테이블에 ar ofc code 'VLCSC'로 등록되어 있는 chg code 입력 시에
		// cur가 'EUR'만 가능토록 수정

		if (formObject.exist_yn.value == "Y") {
			// In bound 일 경우에도 'EUR', 'USD' 선택 입력할 수 있도록 수정 by Sang-Hyun Kim - 2012.03.05
			addCellComboItem(sheetObject1,"EUR^2|USD^2","curr_cd",true);
		}else{
			sheetObject1.CellEditable(sheetObject1.SelectRow, "curr_cd") = true;
		}
		
		setSummary();	
		getExRate();	
		//sheetObject1.CellValue2(sheetObject1.RowCount, "inv_xch_rt") = formObject.ex_rate.value;
	
	}
	
	/**
	 * By Currency GRID 생성 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSummary();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function setSummary() {		
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");	 
		var point = arrStr2[9]
        if (point == 0) {
        	point = -1;
        }
	
		sheetObject2.RemoveAll();	
		
		initSheet(sheetObject2,2,point);
	
		var rowCnt1 = sheetObject2.RowCount;
		var rowCnt2 = sheetObject1.RowCount;
		var curCnt = 0;
		var curs = "";
		var sums = "";
	
		for(var j = 1; j <= rowCnt2; j++){
	
			sums = sums + sheetObject1.CellValue(j, "curr_cd")+"~"+Number(sheetObject1.CellValue(j, 7).replace(/,/gi, ""))+"|";
			if (curs.indexOf(sheetObject1.CellValue(j, "curr_cd")) == -1) {
				curs = curs + sheetObject1.CellValue(j, "curr_cd")+"@"+sheetObject1.CellValue(j, 11) +"|";				
			} 		
	
		}
	
		var curs_item = curs.split("|");
		var curs_item2 = "";
		var curs_item3 = "";
			
		for (var i = 0; i < curs_item.length - 1; i++) {
			curs_item2 = curs_item[i].split("^");
			curs_item3 = curs_item2[0].split("@");
			sheetObject2.DataInsert(-1);
			sheetObject2.CellValue(i+1, 1) = curs_item3[0];			 
			sheetObject2.CellValue(i+1, 4) = arrStr2[4];
			sheetObject2.CellValue(i+1, 6) = curs_item3[1];
	
		}	
	
		var sums_item = sums.split("|");
		var sums_item2 = "";
		var sums_item3 = "";
	
		for (var i = 0; i < sums_item.length - 1; i++) {
			sums_item2 = sums_item[i].split("~");
			sums_item3 = sums_item2[0].split("^");
			for (var j = 0; j < sheetObject2.RowCount; j ++) {				 
	
				if (sheetObject2.CellValue(j+1, 1) == sums_item3[0] && sums_item2[1] != "") {
	
					if (document.form.classId.value == "") {
	
						if (sums_item3[1] == 0 ) {
							sheetObject2.InitCellProperty(j+1, 2, dtData , daRight , "chg_amt", "", dfInteger);
						} else {
							sheetObject2.InitCellProperty(j+1, 2, dtData , daRight , "chg_amt", "", dfNullFloat, sums_item3[1]);
						}
	
					} else {
	
						if (sheetObject2.CellValue(j+1, 6) == 0 ) {
							sheetObject2.InitCellProperty(j+1, 2, dtData , daRight , "chg_amt", "", dfInteger);
						} else {
							sheetObject2.InitCellProperty(j+1, 2, dtData , daRight , "chg_amt", "", dfNullFloat, sheetObject2.CellValue(j+1, 6));
						}
	
					}
					sheetObject2.CellValue(j+1, 2) = Number(sheetObject2.CellValue(j+1, 2)) + Number(sums_item2[1]);
	
				}				 
	
			}
	
		}				 
	
	}	
	
	/**
	 * MRI 처리 대상 B/L 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doRetrieve();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */     
	function doRetrieve() {
	
		var sheetObject = sheetObjects[1];
		var formObject = document.form;
		if(formObject.bl_no.value != "" ){ 
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
		}
		ComBtnEnable("btn_save"); 
	
	}
	

	/**
	 * MRI 처리 대상를 결정하기위해 VVD 변경여부를 Check 하기위해 BKG의 VVD를 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doVVDRetrieve();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 김준호
	 * @version 2013.02.06
	 */     
	function doVVDRetrieve() {

		var sheetObject = sheetObjects[1];
		var formObject = document.form;
		if(formObject.bl_no.value != "" ){ 
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC07);
		}
	}
	
	
	/**
	 * 환율 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     getExRate();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */   
	function getExRate() {
	
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var formObject = document.form;
	
		for (var i = 0; i < sheetObject2.RowCount; i++) {    
	
			var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
			formObject.curr_cd.value = sheetObject2.CellValue(i+1, 1);
			formObject.ofc_cd.value = arrStr2[1];
			formObject.lcl_curr.value = arrStr2[4];  
	
			formObject.select_row.value = i+1;  
			doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC19);
	
			for (var j = 1; j <= sheetObject1.RowCount; j++) {
					
				if (sheetObject1.CellValue(j, "curr_cd").substr(0,3) == sheetObject2.CellValue(i+1, "curr_cd")) {
	
					sheetObject1.CellValue(j, "inv_xch_rt") = sheetObject2.CellValue(i+1, "inv_xch_rt");
	
				}    			
			}    		
		}    
		
		
	
		var lclAmt = 0;
	
		for (var k = 1; k <= sheetObject2.RowCount; k++) {
			lclAmt = lclAmt + Number(sheetObject2.CellValue(k, 5));
	
		}
	
		var dp_prcs_knt = formObject.dp_prcs_knt.value;
	
		sheetObject2.CellValue(sheetObject2.RowCount+1, 5) = lclAmt;
	
	
	}
	
	/**
	 * 환율, SA Date 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     getExRateSaDate();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function getExRateSaDate() {
		var sheetObject = sheetObjects[1];
		var formObject = document.form;
	
		if (sheetObject.RowCount > 0) {
			for (var i = 0; i < sheetObject.RowCount; i++) {    
	
				var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
				formObject.curr_cd.value = sheetObject.CellValue(i+1, 1);
				formObject.ofc_cd.value = arrStr2[1];
				formObject.lcl_curr.value = arrStr2[4];    		
	
				formObject.select_row.value = i+1;  
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC11);
	
			}
		} else {
	
			var lclVvd = formObject.lcl_vvd.value;
	
			if (lclVvd.substring(0,4) == "CFDR" || lclVvd.substring(0,4) == "USAC" || lclVvd.substring(0,4) == "CNTC"){
				formObject.sail_arr_dt.value = formObject.local_time.value.substring(0,2)+lclVvd.substring(4,6)+"-"
				+ lclVvd.substring(6,8)+"-"+"01";
			} else {    		
				doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC12);
			}
	
		}
	
	}  
	
	/**
	 * LCL VVD 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     chkLclVvd();
	 * </pre>
	 * @param 없음
	 * @return Boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */     
	function chkLclVvd() {
	
		var formObject = document.form;
		var revTpCd = formObject.rev_src_cd.text;
		var lclVvd = formObject.lcl_vvd.value;
	
		if (revTpCd == "EQ") {
	
			if (lclVvd.length < 9) {
				ComShowCodeMessage("INV00121");
				return false;
			}
	
			if (lclVvd.substring(0,4) != "USAC") {
				ComShowCodeMessage("INV00121");
				return false;
			}
	
			if (!ComIsNumber(lclVvd.substring(4,6))) {
				ComShowCodeMessage("INV00121");
				return false;
			}
	
			if (!ComIsMonth(lclVvd.substring(6,8))) {
				ComShowCodeMessage("INV00121");
				return false;
			}
	
			if (lclVvd.substring(8,9) != "M") {
				ComShowCodeMessage("INV00121");
				return false;
			}
	
		}
	
		return true;
	
	}        
	
	/**
	 * 그리드내 콤보필드에 데이터를 추가해준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     addCellComboItem(sheetObj,comboValues,colName,isCellCombo);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} comboValues combo 로 생성할 values
	 * @param {String} colName combo 가 위치할 GRID 내 column 명
	 * @param {String} isCellCombo  일반 combo 와 cell combo 구분 flag 
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function addCellComboItem(sheetObj,comboValues,colName,isCellCombo) {
		var sRow = sheetObj.SelectRow;
		var comboTxt = "";
		var comboVal = "";
		var comboItems;
		var comboItem;
	
		if (comboValues != undefined) {
			comboItems = comboValues.split(ROWMARK);
			for (var i = 0 ; i < comboItems.length ; i++) {
				comboItem = comboItems[i].split(FIELDMARK);
	
				if (comboItem[0] != "") {
					comboTxt += comboItem[0];
					//comboVal += comboItem[0];
					if (comboItem[1] != undefined) {
						comboVal += comboItem[0] +"^"+ comboItem[1];
					} else {
						comboVal += comboItem[0];
					}
	
				}
	
				if (i < comboItems.length-1) {
					comboTxt += ROWMARK;
					comboVal += ROWMARK;
				}				
			}
		}
	
		if (isCellCombo) {
			sheetObj.CellComboItem(sRow,colName,comboTxt,comboVal);
		}
		else {
			sheetObj.InitDataCombo(0,colName,comboTxt,comboVal);
		}
	
	}
	
	
	/**
	 * Container Info. 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openContainer();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */      
	function openContainer() {
		ComOpenPopup('/hanjin/FNS_INV_0098.do?pagetype=E', 700, 400, '', '0,0');    	
	}
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
	
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_retrieve":           	 	
				doActionIBSheet(sheetObject2,formObject,IBSEARCH);           	 	
				break;
	
			case "btn_new":
				initField();				 
				break;
	
			case "btn_save":
				doActionIBSheet(sheetObject1,formObject,IBSAVE); 	          	 
				break;
	
			case "btn_add":
				var arrStr2 = formObject.ar_ofc_cd.Code.split("^");			        	 
				var tvaChgCnt = 0;
				var tvaChgRow = 0;
				var invVatChgCd = arrStr2[16] != "" ? arrStr2[16] : "TVA";  
	
				for (var i = 1; i < sheetObject1.RowCount + 1; i++) {   	 				
					if (sheetObject1.CellValue(i, "chg_cd") == invVatChgCd) {
						tvaChgCnt++;	
						tvaChgRow = i;
					}
				}	
				
				if (tvaChgCnt == 0) {
					sheetObject1.DataInsert(-1); 
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);	
					sheetObject2.CellValue(sheetObject2.SelectRow, 1) = arrStr2[4];
				} else {	 				 
					sheetObject1.DataInsert(tvaChgRow - 1); 
					doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC17);		
					sheetObject2.CellValue(sheetObject2.SelectRow, 1) = arrStr2[4];
				}	

				var rowCnt1 = sheetObject2.RowCount;
	
				if (rowCnt1 == 0) {
					sheetObject2.DataInsert(-1);					
					sheetObject2.CellValue(sheetObject2.SelectRow, 1) = arrStr2[4];
					sheetObject2.CellValue(sheetObject2.SelectRow, 4) = arrStr2[4];
				}

				sheetObject1.CellValue(sheetObject1.SelectRow, "curr_cd") = arrStr2[4]+"^"+arrStr2[9];
				
				var arrStr = formObject.ar_ofc_cd.Code.split("^");

 
				if(arrStr[1] == "VLCSC"){
					getEuCheck();
				}
// 2016.06.15 O/B 자동 Checked 제거				
//				if (arrStr[1] == "VLCSC" && (formObject.io_bnd_cd.value == "I"  || (formObject.io_bnd_cd.value == "O" && formObject.eu_check.value =="Y"))) {
//					sheetObject1.CellValue(sheetObject1.SelectRow, "tva_flg") = "1"; 
//				}
				if (arrStr[1] == "VLCSC" && (formObject.io_bnd_cd.value == "I")) {
					sheetObject1.CellValue(sheetObject1.SelectRow, "tva_flg") = "1"; 
				}
				
				if(formObject.rev_src_cd.Code == "TV"){
					sheetObject1.CellValue(sheetObject1.SelectRow, "chg_cd") = "IEV"; 
					sheetObject1.CellEditable(sheetObject1.SelectRow, "chg_cd") = false; 
				}
				
				if ((formObject.rev_src_cd.Code == "VT") && (usr_ofc_cd == "SELADG")) {
					sheetObject1.CellValue2(sheetObject1.SelectRow, "chg_cd") = "TVA";
					sheetObject1.CellEditable(sheetObject1.SelectRow, "chg_cd") = false;
					break;
				}

				//setSummary();	
				//getExRate();
	
				break;
	
			case "btn_del":
				var arrStr = formObject.ar_ofc_cd.Code.split("^");
				var tvaChgCnt = 0;
				var chgCd = sheetObject1.CellValue(sheetObject1.SelectRow, "chg_cd");
				var invVatChgCd = arrStr[16] != "" ? arrStr[16] : "TVA";  
				//if (sheetObject1.RowCount == 2 &&  chgCd != invVatChgCd) {

				if (sheetObject1.RowCount == 2 || (arrStr[16] =="BOMSC" && sheetObject1.RowCount == 4)) {	
					/*for (var i = 1; i < sheetObject1.RowCount + 1; i++) {   	 				
						if (sheetObject1.CellValue(i, "chg_cd") == invVatChgCd) {
							tvaChgCnt++;	 					
						}
					}*/
					if (sheetObject1.CellValue(sheetObject1.SelectRow, "new_flg") != "Y"){ // 남은 row 가 2일 때 선택한 row 가 자동생성 row 이면 삭제여부 묻지 않고 삭제
						sheetObject1.RowDelete();
						sheetObject1.RowDelete(sheetObject1.LastRow, false);
					}
				}else{
					// [CHM-201217167] 추가
					// 새로 생성된 row 는 마지막 row에 생기고 new_flg 값은 Y 이므로 Y 가 아닌 row 만 삭제
					if(sheetObject1.CellValue(sheetObject1.SelectRow, "new_flg") != "Y"){
						sheetObject1.RowDelete();
					}
				}      
				
				setChgSumRowDelete();	 	
				setSummary();	
				getExRate();	
				break;
	
			case "btn_close":
				window.close();
				break;   
	
			case "btn_ib_all":
				addChgSumVlcbb("ATS", "I");
				addChgSumVlcbb("DHS", "I");
				addChgSumVlcbb("SIS", "I");
				addChgSumVlcbb("AHC", "I");
				addChgSumVlcbb("WHS", "I");
				addChgSumVlcbb("PSM", "I");
				addChgSumVlcbb("WHT", "I");	 
				break; 
	
			case "btn_ib_ats":
				addChgSumVlcbb("ATS", "I");
				break;                 
	
			case "btn_ib_dhs":
				addChgSumVlcbb("DHS", "I");
				break;    
	
			case "btn_ib_sis":
				addChgSumVlcbb("SIS", "I");
				break;                 
	
			case "btn_ib_ahc":
				addChgSumVlcbb("AHC", "I");
				break;
	
			case "btn_ib_whs":
				addChgSumVlcbb("WHS", "I");
				break;  
				
			case "btn_ib_wht":
				addChgSumVlcbb("WHT", "I");
				break; 
	
			case "btn_ib_psm":
				addChgSumVlcbb("PSM", "I");
				break;                   
	
			case "btn_ob_all":
				addChgSumVlcbb("ATS", "O");
				addChgSumVlcbb("DHS", "O");
				addChgSumVlcbb("BCU", "O");
				addChgSumVlcbb("WHS", "O");
				addChgSumVlcbb("WHT", "O");
				break; 
	
			case "btn_ob_ats":
				addChgSumVlcbb("ATS", "O");
				break;                 
	
			case "btn_ob_dhs":
				addChgSumVlcbb("DHS", "O");
				break;    
	
			case "btn_ob_bcu":
				addChgSumVlcbb("BCU", "O");
				break;                 
	
			case "btn_ob_whs":
				addChgSumVlcbb("WHS", "O");
				break;
				
			case "btn_ob_wht":
				addChgSumVlcbb("WHT", "O");
				break; 
	
			case "btn_auto":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC09);
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */      
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	
	}
	
	/** 
	 * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * </pre>
	 * @param {IBMultiCombo} combo_obj    IBMultiCombo Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}         
	
	/**
	 * Office Combo 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     MakeComboObject(cmbObj, arrStr);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} 콤보 리스트 스트링
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */      
	function MakeComboObject(cmbObj, arrStr) {
		cmbObj.RemoveAll(); 
		for (var i = 1; i < arrStr.length; i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
	}     
	
	/**
	 * Rev. Type Combo 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     MakeComboObject2(cmbObj, arrStr);
	 * </pre>
	 * @param {ibCombo} cmbObj 필수 IBCombo Object
	 * @param {String} 콤보 리스트 스트링
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */      
	function MakeComboObject2(cmbObj, arrStr) {
		document.form.rev_src_cds.value = arrStr;
		cmbObj.RemoveAll(); 
		for (var i = 1; i < arrStr.length; i++ ) {
			cmbObj.InsertItem(i-1, arrStr[i], arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
	}  
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {
	
		sheet_container = sheetObjects[2]; 
	
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1,-1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
		}
	
		//IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
			initCombo(comboObjects[k],k+1);
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
	
		//ComBtnDisable("btn_save");         
	
	
		// 메뉴에서 오픈
		if (document.form.classId.value == "") {
			getOfcRevCd();             
			document.form.bl_inv_if_dt.value = document.form.local_time.value.substring(0,4)+"-"
			+ document.form.local_time.value.substring(4,6)+"-"
			+ document.form.local_time.value.substring(6,8);
			document.form.bl_no.focus();               
			initControl();      
	
			// 팝업에서 오픈             
		} else {      
			
			getOfcRevCd();
			document.form.ar_ofc_cd.Enable = false; 
			ComBtnDisable("btn_new");
			initControl();    
	
			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC08);
			getExRate();
	
		}
				
//		if (document.form.rev_src_cd.Code == "TM" || document.form.rev_src_cd.Code == "TN") {
//			document.form.eff_dt.value = document.form.local_time.value.substring(0,4)+"-"
//			+ document.form.local_time.value.substring(4,6)+"-"
//			+ document.form.local_time.value.substring(6,8);
//		}

		setButtons();
	
	}
	
	/**
	 * 입력필드 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initField()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */     
	function initField() {
		var formObj = document.form;
	
		tabObjects[0].SelectedIndex = 0;
	
		with(formObj){
			bl_no.value = "";
			bkg_no.value = "";
			//bkg_no_split.value = "";
			cust_cnt_cd.value = "";
			cust_seq.value = "";
			cust_nm.value = "";
			cust_rgst_no.value = "";
			cr_curr_cd.value = "";
			cr_amt.value = "";
			ob_cr_term_dys.value = "";
			ib_cr_term_dys.value = "";
			cr_clt_ofc_cd.value = "";
			lcl_vvd.value = "";
			svc_scp_cd.value = "";
			sail_arr_dt.value = "";
			trunk_vvd.value = "";
			por_cd.value = "";
			pol_cd.value = "";
			pod_cd.value = "";
			del_cd.value = "";
			master_inv.value = "";
			hjs_ref.value = "";
			bkg_teu_qty.value = "";
			bkg_feu_qty.value = "";
			inv_ref_no.value = "";
			bkg_ref_no.value = "";
			si_ref_no.value = "";
			due_dt.value = "";  
			eff_dt.value = "";
			inv_rmk.value = "";
			ar_if_no.value = "";
			io_bnd_cd.value = "O";
			tmp_bl_src_no.value = "";
			mst_if_no.value = "";
	
		}
		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
		sheetObjects[2].RemoveAll();
	
		ComBtnEnable("btn_ib_all");
		ComBtnEnable("btn_ib_ats");
		ComBtnEnable("btn_ib_dhs");
		ComBtnEnable("btn_ib_sis");
		ComBtnEnable("btn_ib_ahc");
		ComBtnEnable("btn_ib_whs");
		ComBtnEnable("btn_ib_psm");		           
		ComBtnEnable("btn_ob_all");
		ComBtnEnable("btn_ob_ats");
		ComBtnEnable("btn_ob_dhs");
		ComBtnEnable("btn_ob_bcu");
		ComBtnEnable("btn_ob_whs");	
	
		getOfcRevCd();
		ComBtnDisable("btn_save"); 
		document.form.bl_no.focus();  
		//document.form.cust_cnt_cd.value = document.form.str_cnt_cd.value;
		document.form.hjs_ref.value = document.form.str_usr_nm.value;
		releField();	      
		setButtons();
	}
	
	/**
	 * 입력필드 Disable 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     lockField()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */   
	function lockField() {
		var formObj = document.form;
	
		with(formObj){
			bl_no.readOnly = true;
			cust_cnt_cd.readOnly = true;
			cust_seq.readOnly = true;
			cust_nm.readOnly = true;
			cust_rgst_no.readOnly = true;
			rev_src_cd.readOnly = true;
			cr_curr_cd.readOnly = true;
			cr_amt.readOnly = true;
			ob_cr_term_dys.readOnly = true;
			ib_cr_term_dys.readOnly = true;
			cr_clt_ofc_cd.readOnly = true;
			lcl_vvd.readOnly = true;
			svc_scp_cd.readOnly = true;
			sail_arr_dt.readOnly = true;
			trunk_vvd.readOnly = true;
			por_cd.readOnly = true;
			pol_cd.readOnly = true;
			pod_cd.readOnly = true;
			del_cd.readOnly = true;
			master_inv.readOnly = true;
			hjs_ref.readOnly = true;
			bkg_teu_qty.readOnly = true;
			bkg_feu_qty.readOnly = true;
			inv_ref_no.readOnly = true;
			bkg_ref_no.readOnly = true;
			si_ref_no.readOnly = true;
			due_dt.readOnly = true; 
			eff_dt.readOnly = true;
			inv_rmk.readOnly = true;
			io_bnd_cd.disabled = true;
			popup1.disabled = true;
			popup2.disabled = true;
			popup3.disabled = true;		  
			ar_ofc_cd.Enable = false; 
	
		}
		sheetObjects[1].Editable = false;
		sheetObjects[0].Editable = false;
		sheetObjects[2].Editable = false;  	
		//comboObjects[0].Enable = false; 
	
		ComBtnDisable("btn_add"); 
		ComBtnDisable("btn_del"); 
	
	}  
	
	/**
	 * 입력필드 Inable 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     releField()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */         
	function releField() {
		var formObj = document.form;
	
		with(formObj){
			bl_no.readOnly = false;
			cust_cnt_cd.readOnly = false;
			cust_seq.readOnly = false;
			cust_nm.readOnly = false;
			cust_rgst_no.readOnly = false;
			rev_src_cd.readOnly = false;
			cr_curr_cd.readOnly = false;
			cr_amt.readOnly = false;
			ob_cr_term_dys.readOnly = false;
			ib_cr_term_dys.readOnly = false;
			cr_clt_ofc_cd.readOnly = false;
			lcl_vvd.readOnly = false;
			svc_scp_cd.readOnly = false;
			sail_arr_dt.readOnly = false;
			trunk_vvd.readOnly = false;
			por_cd.readOnly = false;
			pol_cd.readOnly = false;
			pod_cd.readOnly = false;
			del_cd.readOnly = false;
			master_inv.readOnly = false;
			hjs_ref.readOnly = false;
			bkg_teu_qty.readOnly = false;
			bkg_feu_qty.readOnly = false;
			inv_ref_no.readOnly = false;
			bkg_ref_no.readOnly = false;
			si_ref_no.readOnly = false;
			due_dt.readOnly = false; 
			eff_dt.readOnly = false;
			inv_rmk.readOnly = false;
			io_bnd_cd.disabled = false;
			popup1.disabled = false;
			popup2.disabled = false;
			popup3.disabled = false;
			ar_ofc_cd.Enable = true; 
			mst_if_no.readOnly = true;
			mst_if_no.className = "input2";
	
		}
		sheetObjects[0].Editable = true;
		sheetObjects[1].Editable = true;
		sheetObjects[2].Editable = true;  		  
		//comboObjects[0].Enable = true; 
	
		ComBtnEnable("btn_add"); 
		ComBtnEnable("btn_del"); 
		ComBtnEnable("btn_save"); 
	
	}    
	 
	/**
	 * Customer Information Inquiry 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openFnsInv0013()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 	
	function openFnsInv0013() { 	
		var formObject = document.form;
		if(formObject.cust_cnt_cd.value != "" && formObject.cust_seq.value != "") {
			var param = '?cust_cnt_cd='+formObject.cust_cnt_cd.value+'&cust_seq='+formObject.cust_seq.value+'&pop_yn=Y&ret_yn=Y';
			ComOpenPopup('/hanjin/FNS_INV_0013.do' + param, 920, 650, 'getPopData', '0,0', false, false, "", "", 0);    
		}
	
	}
	
	/**
	 * Quick Customer Search 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openFnsInv0086()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function openFnsInv0086() {
	
		var classId = "FNS_INV_0086";
		var office = document.ar_ofc_cd.Text;
		ComOpenPopup('/hanjin/FNS_INV_0086.do?office='+office, 910, 450, 'getFnsInv0086', '1,0,1,1,1', false, false);
	
	}   
	
	/**
	 * Quick Customer Search 팝업에서 호출하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     getFnsInv0086()
	 * </pre>
	 * @param rowArray
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */    
	function getFnsInv0086(rowArray) {
	
		var colArray = rowArray[0];		
		var formObject = document.form;
	
		formObject.cust_cnt_cd.value = colArray[8];
		formObject.cust_seq.value = ComLpad(colArray[9], 6, '0');
		formObject.cust_nm.value = colArray[4];
		formObject.delt_flg.value = colArray[12] == "Delete" ? "Y" : "N";
		
		// 2011.12.01 customer 정보 처리부분 추가
		getCustNmByCustCd();
		// 2011.11.23 추가 
		getSADateDueDate();
	}    
	
	/** 
	 * 콤보 초기설정값<br>
	 * <br><b>Example :</b>
	 * <pre>
	 * 	   initCombo(comboObj, comboNo)
	 * </pre>
	 * @param {IBMultiCombo} comboObj  comboObj
	 * @param comboNo 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * @author 정휘택
	 * @version 2009.10.20 
	 * @version 2009.04.27
	 */
	function initCombo(comboObj, comboNo) {
		switch (comboObj.id) {
		case "ar_ofc_cd":
			with (comboObj) {
				SetColAlign("left");
				SetColWidth("50");
				MultiSelect = false;
				UseAutoComplete = true;
				DropHeight = 200;
				ValidChar(2,1);
				MaxLength = 6;
			}
			break;
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj,sheetNo,point);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @param {int} point chg_amt 소수 자리수
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */ 
	function initSheet(sheetObj,sheetNo,point) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
			with (sheetObj) {
		
				// 높이 설정
				style.height = 182;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(15, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(false, true, false, true, false,false)
		
				var HeadTitle1 = " |Seq.|CHG|Cur|Rate|Rated As|Per|Amount|Remark(s)|TVA|";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
		
				WaitImageVisible = false;
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,   70,    daCenter,  false,    "ibflag");
				InitDataProperty(0, cnt++ , dtDataSeq,      30,   daCenter,  false,    "seq");
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtComboEdit,    90,   daCenter,  false,    "chg_cd",   			true,     "",      dfNone,        0,  true,	true, 3, true);
				} else {
					InitDataProperty(0, cnt++ , dtComboEdit,    90,   daCenter,  false,    "chg_cd",   			true,     "",      dfNone,        0,  false,	false, 3, true);
				}
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtComboEdit,    90,   daCenter,  false,    "curr_cd",    			true,     "",      dfNone,        0,  true,	true, 3);
				} else {
					InitDataProperty(0, cnt++ , dtComboEdit,    90,   daCenter,  false,    "curr_cd",    			true,     "",      dfNone,        0,  false,	false, 3);
				}
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtData,     90,   daRight,   false,    "trf_rt_amt",   		true,     "",      dfNullFloat,   2,  true,	true);
				} else {
					InitDataProperty(0, cnt++ , dtData,     90,   daRight,   false,    "trf_rt_amt",   		true,     "",      dfNullFloat,   2,  false,	false);
				}
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtData,    100,   daRight,   false,    "rat_as_cntr_qty",    	true,     "",      dfNullFloat,   3,  true,	true);
				} else {
					InitDataProperty(0, cnt++ , dtData,    100,   daRight,   false,    "rat_as_cntr_qty",    	true,     "",      dfNullFloat,   3,  false,	false);
				}
				
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtComboEdit,    100,   daCenter,  false,    "per_tp_cd", 			true,     "",      dfNone,    0,  true,	true, 2);
				} else {
					InitDataProperty(0, cnt++ , dtComboEdit,    100,   daCenter,  false,    "per_tp_cd", 			true,     "",      dfNone,    0,  false,	false, 2);
				}
				
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtData,     90,   daRight,   false,    "chg_amt",       		true,     "",      dfNullFloat,        point,  false,	false);
				} else {
					InitDataProperty(0, cnt++ , dtData,     90,   daRight,   false,    "chg_amt",       		true,     "",      dfNullFloat,        point,  false,	false);
				}
				
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtData,    190,   daCenter,  false,    "chg_rmk",       		false,     "",      dfNone,        0,  true,	true);
				} else { 
					InitDataProperty(0, cnt++ , dtData,    190,   daCenter,  false,    "chg_rmk",       		false,     "",      dfNone,        0,  false,	false);
				}
				InitDataProperty(0, cnt++ , dtCheckBox, 40,   daCenter,  false,    "tva_flg",      		false,     "",      dfNone,        0,  false,	false);
				InitDataProperty(0, cnt++ , dtHidden,   10,   daRight,   false,    "inv_xch_rt",    	    false,     "",      dfNone,        0,  false,	false);
				InitDataProperty(0, cnt++ , dtHidden,   10,   daRight,   false,    "dp_prcs_knt",    	    false,     "",      dfNone,        0,  false,	false);                      
				InitDataProperty(0, cnt++ , dtHidden,   10,   daRight,   false,    "chg_seq",    	    false,     "",      dfNone,        0,  false,	false); 
				InitDataProperty(0, cnt++ , dtHidden,   10,   daRight,   false,    "ar_if_ser_no",    	    false,     "",      dfNone,        0,  false,	false);
				
				InitDataProperty(0, cnt++ , dtHidden, 0,   daCenter,  false,    "new_flg",      		false,     "",      dfNone,        0,  false,	false);
		
				InitDataValid(0,    "chg_cd",   vtEngUpOther, "1234567890/");
				InitDataValid(0,    "per_tp_cd",   vtEngUpOther, "1234567890");
				InitDataValid(0,    "curr_cd",   vtEngUpOther, "1234567890");
				
				InitComboNoMatchText(false);
	
				CountPosition = 0; 
		
			}
			break;
	
		case 2:      //t1sheet1 init
			with (sheetObj) {
		
				// 높이 설정
				style.height = 130;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(7, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
		
				var HeadTitle1 = " |Cur.|Amount|Ex. Rate|Local Cur|Local Amount";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
		
				WaitImageVisible = false;
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,   70,    daCenter,  false,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "curr_cd",   		false,     "",      dfNone,    0,  false,	false);
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtData,    100,   daRight,   false,    "chg_amt", 		false,     "",      dfNullFloat,    0,  false,	false);
				} else {
					InitDataProperty(0, cnt++ , dtData,    100,   daRight,   false,    "chg_amt", 		false,     "",      dfNullFloat,    0,  false,	false);
				}
				InitDataProperty(0, cnt++ , dtData,    90,    daRight,   false,    "inv_xch_rt",    	false,     "",      dfNone,    0,  false,	false);
				InitDataProperty(0, cnt++ , dtData,    90,    daCenter,  false,    "locl_curr_cd",     false,     "",      dfNone,    0,  false,	false);
				if (document.form.classId.value == "") {
					InitDataProperty(0, cnt++ , dtAutoSumEx,    100,   daRight,   false,    "local_total",         false,     "",      dfNullFloat,    point,  false,	false);
				} else {
					InitDataProperty(0, cnt++ , dtAutoSumEx,    100,   daRight,   false,    "local_total",         false,     "",      dfNullFloat,    point,  false,	false);
				}
		
				InitDataProperty(0, cnt++ , dtHidden,   10,   daRight,   false,    "dp_prcs_knt",    	    false,     "",      dfNone,        0,  false,	false);                      
				CountPosition = 0; 
		
			}
			break; 
	
		case 3:      //Container init
			with (sheetObj) {            	
		
				// 높이 설정
				style.height = 100;
		
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
		
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
		
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
		
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 3, 100);
		
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(3, 0, 0, true);
		
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)
		
				var HeadTitle1 = " |Cntr_tpsz_cd|Cntr_no";
		
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false] 
				InitHeadRow(0, HeadTitle1, true);
		
				WaitImageVisible = false;
		
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,  30,    daCenter,  false,   "ibflag");
				InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_tpsz_cd", 	false,     "",      dfNone,    0,  false,	false);
				InitDataProperty(0, cnt++ , dtData,    70,    daCenter,  false,    "cntr_no",   		false,     "",      dfNone,    0,  false,	false);
		
				CountPosition = 0;   
		
			}
			break;
	
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
	
		case IBSEARCH_ASYNC10: // 화면 로딩시 AR Office 조회
			
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
		
			MakeComboObject(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = arrStr[1].split("^");
			var ar_ofc_cd = arrStr2[3];
			formObj.ar_ofc_cd.text = ar_ofc_cd;		
		
			break;
	
		case IBSEARCH_ASYNC20: // customer name 조회
			if (formObj.cust_cnt_cd.value != "" && formObj.cust_seq.value != ""){
		
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ar_ofc_cd2.value = arrStr2[1];
		
				formObj.f_cmd.value = SEARCH03;
				formObj.cust_rgst_no.value = "";
		
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
		
				var deltFlg = ComGetEtcData(sXml,"delt_flg");   
				if (deltFlg == undefined) {						
					formObj.delt_flg.value = "Y";
					formObj.cust_nm.value = "";
					formObj.cust_rgst_no.value = "";
					formObj.cr_curr_cd.value = "";
					formObj.cr_amt.value = "";
					formObj.ob_cr_term_dys.value = "";
					formObj.ib_cr_term_dys.value = "";
					formObj.cr_clt_ofc_cd.value = "";
					formObj.inv_cust_cnt_cd.value = "";
					formObj.inv_cust_seq.value = "";
					ComShowCodeMessage("INV00060");
					return false;						
				} else {
					formObj.delt_flg.value = deltFlg;
				}
				
				var cust_cnt_cd = ComGetEtcData(sXml,"cust_cnt_cd");    
				if (cust_cnt_cd != undefined) {
					formObj.cust_cnt_cd.value = cust_cnt_cd;
				} else {
					formObj.cust_cnt_cd.value = "";
				}
				
				var cust_seq = ComGetEtcData(sXml,"cust_seq");    
				if (cust_seq != undefined) {
					formObj.cust_seq.value = ComLpad(cust_seq, 6, '0');
				} else {
					formObj.cust_seq.value = "";
				}
		
				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");    
				if (cust_nm != undefined) {
					formObj.cust_nm.value = cust_nm;
				} else {
					formObj.cust_nm.value = "";
				}		
		
				var cust_rgst_no = ComGetEtcData(sXml,"cust_rgst_no");    
				if (cust_rgst_no != undefined) {
					formObj.cust_rgst_no.value = cust_rgst_no;
				} else {
					formObj.cust_rgst_no.value = "";
				}
		
				var cr_curr_cd = ComGetEtcData(sXml,"cr_curr_cd");    
				if (cr_curr_cd != undefined) {
					formObj.cr_curr_cd.value = cr_curr_cd;
				} else {
					formObj.cr_curr_cd.value = "";
				}
		
				var cr_amt = ComGetEtcData(sXml,"cr_amt");    
				if (cr_amt != undefined) {
					formObj.cr_amt.value = ComAddComma(cr_amt);
				} else {
					formObj.cr_amt.value = "";
				}
		
				var ob_cr_term_dys = ComGetEtcData(sXml,"ob_cr_term_dys");    
				if (ob_cr_term_dys != undefined) {
					formObj.ob_cr_term_dys.value = ob_cr_term_dys;
				} else {
					formObj.ob_cr_term_dys.value = "";
				}
		
				var ib_cr_term_dys = ComGetEtcData(sXml,"ib_cr_term_dys");    
				if (ib_cr_term_dys != undefined) {
					formObj.ib_cr_term_dys.value = ib_cr_term_dys;
				} else {
					formObj.ib_cr_term_dys.value = "";
				}
		
				var cr_clt_ofc_cd = ComGetEtcData(sXml,"cr_clt_ofc_cd");    
				if (cr_clt_ofc_cd != undefined) {
					formObj.cr_clt_ofc_cd.value = cr_clt_ofc_cd;
				} else {
					formObj.cr_clt_ofc_cd.value = "";
				}
		
			}
		
			break;
			
		case IBSEARCH_ASYNC03: // customer name 조회
			if (formObj.cust_rgst_no.value != ""){
		
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ar_ofc_cd2.value = arrStr2[1];
		
				formObj.f_cmd.value = SEARCH16;
				formObj.cust_cnt_cd.value = "";
				formObj.cust_seq.value = "";
		
				var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
		
				var deltFlg = ComGetEtcData(sXml,"delt_flg");   
				if (deltFlg == undefined) {						
					formObj.delt_flg.value = "Y";
					formObj.cust_nm.value = "";
					formObj.cust_rgst_no.value = "";
					formObj.cr_curr_cd.value = "";
					formObj.cr_amt.value = "";
					formObj.ob_cr_term_dys.value = "";
					formObj.ib_cr_term_dys.value = "";
					formObj.cr_clt_ofc_cd.value = "";
					formObj.inv_cust_cnt_cd.value = "";
					formObj.inv_cust_seq.value = "";
					ComShowCodeMessage("INV00060");
					return;						
				} else {
					formObj.delt_flg.value = deltFlg;
				}
		
				var cust_cnt_cd = ComGetEtcData(sXml,"cust_cnt_cd");    
				if (cust_cnt_cd != undefined) {
					formObj.cust_cnt_cd.value = cust_cnt_cd;
				} else {
					formObj.cust_cnt_cd.value = "";
				}
				
				var cust_seq = ComGetEtcData(sXml,"cust_seq");    
				if (cust_seq != undefined) {
					formObj.cust_seq.value = ComLpad(cust_seq, 6, '0');
				} else {
					formObj.cust_seq.value = "";
				}
				
				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");    
				if (cust_nm != undefined) {
					formObj.cust_nm.value = cust_nm;
				} else {
					formObj.cust_nm.value = "";
				}		
		
				var cust_rgst_no = ComGetEtcData(sXml,"cust_rgst_no");    
				if (cust_rgst_no != undefined) {
					formObj.cust_rgst_no.value = cust_rgst_no;
				} else {
					formObj.cust_rgst_no.value = "";
				}
		
				var cr_curr_cd = ComGetEtcData(sXml,"cr_curr_cd");    
				if (cr_curr_cd != undefined) {
					formObj.cr_curr_cd.value = cr_curr_cd;
				} else {
					formObj.cr_curr_cd.value = "";
				}
		
				var cr_amt = ComGetEtcData(sXml,"cr_amt");    
				if (cr_amt != undefined) {
					formObj.cr_amt.value = ComAddComma(cr_amt);
				} else {
					formObj.cr_amt.value = "";
				}
		
				var ob_cr_term_dys = ComGetEtcData(sXml,"ob_cr_term_dys");    
				if (ob_cr_term_dys != undefined) {
					formObj.ob_cr_term_dys.value = ob_cr_term_dys;
				} else {
					formObj.ob_cr_term_dys.value = "";
				}
		
				var ib_cr_term_dys = ComGetEtcData(sXml,"ib_cr_term_dys");    
				if (ib_cr_term_dys != undefined) {
					formObj.ib_cr_term_dys.value = ib_cr_term_dys;
				} else {
					formObj.ib_cr_term_dys.value = "";
				}
		
				var cr_clt_ofc_cd = ComGetEtcData(sXml,"cr_clt_ofc_cd");    
				if (cr_clt_ofc_cd != undefined) {
					formObj.cr_clt_ofc_cd.value = cr_clt_ofc_cd;
				} else {
					formObj.cr_clt_ofc_cd.value = "";
				}
		
			}
		
			break;
		
		case IBSEARCH_ASYNC15: // AR Office, Rev. Type 조회	   
	
			formObj.f_cmd.value = SEARCH04;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));		            
		
			// Office 조회	
			var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
			var arrStr = sStr.split("|");
		
			MakeComboObject(formObj.ar_ofc_cd, arrStr);
		
			var arrStr2 = arrStr[1].split("^");
			var ar_ofc_cd = arrStr2[3];
			formObj.ar_ofc_cd.text = ar_ofc_cd;	            
		
			// Local Time 조회
			var localTime = ComGetEtcData(sXml, "local_time");	
			formObj.local_time.value = localTime;
	
			break;	        	
	
		case IBSEARCH_ASYNC16: // Rev. Type 조회	   
			if (document.form.classId.value == "") {
				formObj.f_cmd.value = SEARCH06;
		
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
		
				formObj.rhq_cd.value = arrStr2[0];
				formObj.ofc_cd.value = arrStr2[3];
				formObj.svr_id.value = arrStr2[7];
		
				var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
		
				var sStr2 = ComGetEtcData(sXml,"rev_src_cd");
				
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
				if (usr_ofc_cd == "SELADG") {
					sStr2 = sStr2 + "|VT"; 
				}
				var arrStr2 = sStr2.split("|");
		
				MakeComboObject2(formObj.rev_src_cd, arrStr2);	     
				formObj.rev_src_cd.text = "IV";				
			}
		
			break;	
	
		case IBSEARCH_ASYNC17: // Cur. Code 조회	 
	
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));		            
	
			var comboValues = ComGetEtcData(sXml, "chgInfo");	
			formObj.chg_cds.value = comboValues;
			addCellComboItem(sheetObj,comboValues,"chg_cd",true);	
	
			var comboValues2 = ComGetEtcData(sXml, "currInfo");	
			formObj.curr_cds.value = comboValues2;
			var comboItems = comboValues2.split(ROWMARK);
			sheetObj.CellValue2(sheetObj.SelectRow, "curr_cd") = comboItems[1]; 					
			addCellComboItem(sheetObj,comboValues2,"curr_cd",true);	
	
			//var comboValues3 = "| |A2|A4|BL|BX|D2|D4|D5|D7|F2|F4|F5|O2|O4|P2|P4|Q2|Q4|R2|R4|R5|R7|S2|S4|T2|T4|20|40|45|PC|";
			var comboValues3 = ComGetEtcData(sXml, "perInfo");	
			formObj.per_tp_cds.value = comboValues3;
			addCellComboItem(sheetObj,comboValues3,"per_tp_cd",true);	
	
			break;	
	
		case IBSEARCH_ASYNC18: // Local Charge 체크	   
	
			formObj.f_cmd.value = SEARCH08;		   
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
			var existYn = ComGetEtcData(sXml, "exist_yn");	
			formObj.exist_yn.value = existYn;
		
			break;	
	
		case IBSEARCH_ASYNC19: // Ex.Rate 조회	   
	
			formObj.f_cmd.value = SEARCH05;
			
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			formObj.svr_id.value = arrStr2[7];
			
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));	
			
			var ex_rate = ComGetEtcData(sXml,"ex_rate");
			var ex_rate_date = ComGetEtcData(sXml,"ex_rate_date");
			var curr = ComGetEtcData(sXml,"curr");
			var usd_exrate_type = ComGetEtcData(sXml,"usd_exrate_type");
			var third_exrate_type = ComGetEtcData(sXml,"third_exrate_type");
		
			formObj.usd_exrate_type.value = usd_exrate_type;
			formObj.third_exrate_type.value = third_exrate_type;
			formObj.ex_rate_date.value = ex_rate_date;
			formObj.ex_rate.value = ex_rate;
		
			var select_row = formObj.select_row.value;				
			sheetObj.CellValue(select_row, 3) = ex_rate;
				
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			var dp_prcs_knt = arrStr2[9];
			formObj.dp_prcs_knt.value = dp_prcs_knt;
		
			if (dp_prcs_knt == '0') {
				sheetObj.InitCellProperty(select_row, 5, dtData , daRight , "", "", dfInteger );
			} else {
				sheetObj.InitCellProperty(select_row, 5, dtData , daRight , "", "", dfNullFloat, dp_prcs_knt);
			}
		
			sheetObj.CellValue(select_row, 5) = Number(ComReplaceStr(sheetObj.CellValue(select_row, 2), ",", "")) * ex_rate;	
		
			break;
	
		case IBSEARCH_ASYNC11: // Ex.Rate, Sa Date 조회	   
	
			formObj.f_cmd.value = SEARCH09;
			
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			formObj.svr_id.value = arrStr2[7];
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));	
		
			var ex_rate = ComGetEtcData(sXml,"ex_rate");
			var ex_rate_date = ComGetEtcData(sXml,"ex_rate_date");
			var curr = ComGetEtcData(sXml,"curr");
			var usd_exrate_type = ComGetEtcData(sXml,"usd_exrate_type");
			var third_exrate_type = ComGetEtcData(sXml,"third_exrate_type");	
		
			formObj.usd_exrate_type.value = usd_exrate_type;
			formObj.third_exrate_type.value = third_exrate_type;
			formObj.ex_rate_date.value = ex_rate_date;
		
			var select_row = formObj.select_row.value;	
			sheetObj.CellValue(select_row, 3) = ex_rate;
			sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "inv_xch_rt") = ex_rate;
			
			var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
			var dp_prcs_knt = arrStr2[9];
			formObj.dp_prcs_knt.value = dp_prcs_knt;
		
			if (dp_prcs_knt == '0') {
				sheetObj.InitCellProperty(select_row, 5, dtData , daRight , "", "", dfInteger );
			} else {
				sheetObj.InitCellProperty(select_row, 5, dtData , daRight , "", "", dfNullFloat, dp_prcs_knt );
			}
		
			sheetObj.CellValue(select_row, 5) = Number(ComReplaceStr(sheetObj.CellValue(select_row, 2), ",", "")) * ex_rate;
		
			var sa_date = ComGetEtcData(sXml,"sa_date");

			var lclVvd = formObj.lcl_vvd.value;
	
			if (lclVvd.substring(0,4) == "CFDR" || lclVvd.substring(0,4) == "USAC") {
				formObj.sail_arr_dt.value = formObj.local_time.value.substring(0,4)+"-"
				+ formObj.local_time.value.substring(4,6)+"-"
				+ formObj.local_time.value.substring(6,8);
			} else {  
		
				formObj.sail_arr_dt.value = sa_date;
			}
		
			break;
	
		case IBSEARCH_ASYNC12: // Sa Date 조회	
			formObj.vvd.value = formObj.lcl_vvd.value;		        
			formObj.bnd.value = formObj.io_bnd_cd.value;
		
			if(formObj.bnd.value == "I") {
				formObj.port.value = formObj.pod_cd.value;
			} else {
				formObj.port.value = formObj.pol_cd.value;
			}		        
			
			formObj.f_cmd.value = SEARCH07;
			var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));					
			var sail_arr_dt = ComGetEtcData(sXml,"sail_arr_dt");
	
			formObj.sail_arr_dt.value = sail_arr_dt;
		
			break;
		
		case IBSEARCH_ASYNC07: // VVD 비교를 위해서 BKG VVD 조회

			formObj.f_cmd.value = SEARCH22;
			ComOpenWait(true);
		
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));	
		
			ComOpenWait(false);
			
			var ob_vvd = ComGetEtcData(sXml,"ob_vvd");
			var ib_vvd = ComGetEtcData(sXml,"ib_vvd");

			// Hidden item 에 담아둔다.
			formObj.ob_vvd.value = ob_vvd;
			formObj.ib_vvd.value = ib_vvd;

			break;
	
		case IBSEARCH: //조회                
	
			if(validateForm(sheetObj,formObj,sAction)) {
		
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.rhq_cd.value = arrStr2[0];
				formObj.ofc_cd.value = arrStr2[1];
				formObj.svr_id.value = arrStr2[7];
				formObj.loc_cd.value = arrStr2[6];
		
				formObj.f_cmd.value = SEARCH;
				ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));	
				ComOpenWait(false);
		
				var cust_ref_no3 = ComGetEtcData(sXml,"cust_ref_no3");
				var act_cust_seq = ComGetEtcData(sXml,"act_cust_seq");
				var cust_ref_no1 = ComGetEtcData(sXml,"cust_ref_no1");
				var inv_cust_cnt_cd = ComGetEtcData(sXml,"inv_cust_cnt_cd");
				var cust_ref_no2 = ComGetEtcData(sXml,"cust_ref_no2");
				var pol_cd = ComGetEtcData(sXml,"pol_cd");
				var bkg_feu_qty = ComGetEtcData(sXml,"bkg_feu_qty");     
				var inv_cust_seq = ComGetEtcData(sXml,"inv_cust_seq");
				var pagerows = ComGetEtcData(sXml,"pagerows"); 
				var sail_arr_dt = ComGetEtcData(sXml,"sail_arr_dt");
				var ibflag = ComGetEtcData(sXml,"ibflag");
				var io_bnd_cd = ComGetEtcData(sXml,"io_bnd_cd");
				var bkg_no = ComGetEtcData(sXml,"bkg_no");
				var locl_curr_cd = ComGetEtcData(sXml,"locl_curr_cd");
				var master_inv = ComGetEtcData(sXml,"master_inv");
				var act_cust_cnt_cd = ComGetEtcData(sXml,"act_cust_cnt_cd");     
				var bkg_teu_qty = ComGetEtcData(sXml,"bkg_teu_qty");
				var due_dt = ComGetEtcData(sXml,"due_dt"); 
				var gl_eff_dt = ComGetEtcData(sXml,"gl_eff_dt"); 
				var svc_scp_cd = ComGetEtcData(sXml,"svc_scp_cd");
				var del_cd = ComGetEtcData(sXml,"del_cd");
				var por_cd = ComGetEtcData(sXml,"por_cd");
				var bl_src_no = ComGetEtcData(sXml,"bl_src_no");
				var pod_cd = ComGetEtcData(sXml,"pod_cd");     
				var cust_cr_flg = ComGetEtcData(sXml,"cust_cr_flg");
				var lcl_vvd = ComGetEtcData(sXml,"lcl_vvd");
				var trunk_vvd = ComGetEtcData(sXml,"trunk_vvd"); 
				var rev_tp_cd = ComGetEtcData(sXml,"rev_tp_cd"); 
				var rev_src_cd = ComGetEtcData(sXml,"rev_src_cd"); 
				var inv_svc_scp_cd = ComGetEtcData(sXml,"inv_svc_scp_cd");
		
				var cust_nm = ComGetEtcData(sXml,"cust_eng_nm");  			        		        	
				var cust_rgst_no = ComGetEtcData(sXml,"cust_rgst_no");			        	
				var cr_curr_cd = ComGetEtcData(sXml,"cr_curr_cd");  			        	
				var cr_amt = ComGetEtcData(sXml,"cr_amt");  			        	
				var ob_cr_term_dys = ComGetEtcData(sXml,"ob_cr_term_dys"); 			        	
				var ib_cr_term_dys = ComGetEtcData(sXml,"ib_cr_term_dys"); 			        	
				var cr_clt_ofc_cd = ComGetEtcData(sXml,"cr_clt_ofc_cd");   
				var delt_flg = ComGetEtcData(sXml,"delt_flg");	 
	
				//[2013.02.15]
				//미리 조회한 Inbound/Outbound VVD와  MAX IF No로 조회한 VVD 비교해서 BKG의 VVD 변경여부를 판단.
				//동일하면 BKG의 VVD가 기존 Invoice 생성된 VVD와 변경된것이 없으므로 lcl_vvd 그대로 사용하고,
				//다르면 BKG의 VVD가 새로 변경됨을 의미하므로 BKG으로부터 새로 정보를 조회해야 하기 때문에,  lcl_vvd 초기화하여 BKG New(SEARCH05)를 실행하도록 한다.
				var ob_vvd = formObj.ob_vvd.value;
				var ib_vvd = formObj.ib_vvd.value;
	            
	            if(lcl_vvd != ob_vvd && lcl_vvd != ib_vvd) {
	                lcl_vvd = "";
	            }
				
				if (lcl_vvd != undefined && lcl_vvd != "") {
		
					formObj.lcl_vvd.value = lcl_vvd;	 		           
					formObj.svc_scp_cd.value = svc_scp_cd;
					formObj.io_bnd_cd.value = io_bnd_cd;	 		            
					formObj.sail_arr_dt.value = sail_arr_dt;	 		            
					formObj.trunk_vvd.value = trunk_vvd;
					formObj.por_cd.value = por_cd;
					formObj.pol_cd.value = pol_cd;
					formObj.pod_cd.value = pod_cd;
					formObj.del_cd.value = del_cd;	 		            
					formObj.master_inv.value = master_inv;
					formObj.bkg_teu_qty.value = bkg_teu_qty;
					formObj.bkg_feu_qty.value = bkg_feu_qty;	
					formObj.inv_ref_no.value = cust_ref_no1;	
					formObj.bkg_ref_no.value = cust_ref_no2;
					formObj.si_ref_no.value = cust_ref_no3;
					formObj.due_dt.value = due_dt;	
					formObj.eff_dt.value = gl_eff_dt;	
					formObj.eff_dt_tmp.value = gl_eff_dt;	
					formObj.cust_cnt_cd.value = act_cust_cnt_cd;
					formObj.cust_seq.value = act_cust_seq;
					formObj.inv_svc_scp_cd.value = inv_svc_scp_cd;
		
					if (delt_flg != undefined && delt_flg != "Y") {
						//formObj.cust_cnt_cd.value = act_cust_cnt_cd;
						//formObj.cust_seq.value = act_cust_seq;		 		        	
						formObj.cust_nm.value = cust_nm;
						formObj.cust_rgst_no.value = cust_rgst_no;
						formObj.cr_curr_cd.value = cr_curr_cd;
						formObj.cr_amt.value = ComAddComma(cr_amt);
						formObj.ob_cr_term_dys.value = ob_cr_term_dys;
						formObj.ib_cr_term_dys.value = ib_cr_term_dys;
						formObj.cr_clt_ofc_cd.value = cr_clt_ofc_cd;
					}
		
					formObj.bl_no.value = bl_src_no;
					formObj.bkg_no.value = bkg_no;
		
					formObj.inv_cust_cnt_cd.value = inv_cust_cnt_cd;
					formObj.inv_cust_seq.value = inv_cust_seq;
		
					sheetObjects[2].LoadSearchXml(sXml); 
		
					for ( var i = 0; i < sheetObjects[2].RowCount; i++) {
		
						var row = i + 1;
						sheetObjects[2].CellValue2(row, 0) = "I";
					}
		
				} else {
					
					formObj.lcl_vvd.value = "";	 		           
					formObj.svc_scp_cd.value = "";
					formObj.io_bnd_cd.value = "";	 		            
					formObj.sail_arr_dt.value = "";	 		            
					formObj.trunk_vvd.value = "";
					formObj.por_cd.value = "";
					formObj.pol_cd.value = "";
					formObj.pod_cd.value = "";
					formObj.del_cd.value = ""; 		            
					formObj.master_inv.value = "";
					formObj.bkg_teu_qty.value = "";
					formObj.bkg_feu_qty.value = "";	
					formObj.inv_ref_no.value = "";	
					formObj.bkg_ref_no.value = "";
					formObj.si_ref_no.value = "";
					formObj.due_dt.value = "";
					formObj.eff_dt.value = "";
		
					formObj.inv_cust_cnt_cd.value = "";
					formObj.inv_cust_seq.value = "";
		
					sheetObjects[2].RemoveAll();
		
					if(ComShowCodeConfirm("INV00070")) {
						formObj.bnd.value = "O";	
					} else {
						formObj.bnd.value = "I";	
					}
		
					formObj.f_cmd.value = SEARCH05;
					ComOpenWait(true);
					sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));		 		            
					ComOpenWait(false);
		
					var cust_ref_no3 = ComGetEtcData(sXml,"cust_ref_no3");
					//var act_cust_seq = ComGetEtcData(sXml,"act_cust_seq");
					//var act_cust_seq = "";
					var cust_ref_no1 = ComGetEtcData(sXml,"cust_ref_no1");
					var inv_cust_cnt_cd = ComGetEtcData(sXml,"inv_cust_cnt_cd");
					var cust_ref_no2 = ComGetEtcData(sXml,"cust_ref_no2");
					var pol_cd = ComGetEtcData(sXml,"pol_cd");
					var bkg_feu_qty = ComGetEtcData(sXml,"bkg_feu_qty");     
					var inv_cust_seq = ComGetEtcData(sXml,"inv_cust_seq");
					var pagerows = ComGetEtcData(sXml,"pagerows"); 
					var sail_arr_dt = ComGetEtcData(sXml,"sail_arr_dt");
					var ibflag = ComGetEtcData(sXml,"ibflag");
					var io_bnd_cd = ComGetEtcData(sXml,"io_bnd_cd");
					var bkg_no = ComGetEtcData(sXml,"bkg_no");
					var locl_curr_cd = ComGetEtcData(sXml,"locl_curr_cd");
					var master_inv = ComGetEtcData(sXml,"master_inv");
					//var act_cust_cnt_cd = ComGetEtcData(sXml,"act_cust_cnt_cd");     
					//var act_cust_cnt_cd = "";
					var bkg_teu_qty = ComGetEtcData(sXml,"bkg_teu_qty");
					var due_dt = ComGetEtcData(sXml,"due_dt"); 
					var gl_eff_dt = ComGetEtcData(sXml,"gl_eff_dt");
					var svc_scp_cd = ComGetEtcData(sXml,"svc_scp_cd");
					var del_cd = ComGetEtcData(sXml,"del_cd");
					var por_cd = ComGetEtcData(sXml,"por_cd");
					var bl_src_no = ComGetEtcData(sXml,"bl_src_no");
					var pod_cd = ComGetEtcData(sXml,"pod_cd");     
					var cust_cr_flg = ComGetEtcData(sXml,"cust_cr_flg");
					var lcl_vvd = ComGetEtcData(sXml,"lcl_vvd");
					var trunk_vvd = ComGetEtcData(sXml,"trunk_vvd"); 
					var rev_tp_cd = ComGetEtcData(sXml,"rev_tp_cd"); 
					var rev_src_cd = ComGetEtcData(sXml,"rev_src_cd");
		
					var cust_nm = "";  			        		        	
					var cust_rgst_no = "";			        	
					var cr_curr_cd = "";  			        	
					var cr_amt = ""; 			        	
					var ob_cr_term_dys = "";			        	
					var ib_cr_term_dys = ""; 			        	
					var cr_clt_ofc_cd = "";  
		
					if (lcl_vvd != undefined && lcl_vvd != "") {
		
						formObj.lcl_vvd.value = lcl_vvd;	 		           
						formObj.svc_scp_cd.value = svc_scp_cd;
						formObj.io_bnd_cd.value = io_bnd_cd;	 		            
						formObj.sail_arr_dt.value = sail_arr_dt;	 		            
						formObj.trunk_vvd.value = trunk_vvd;
						formObj.por_cd.value = por_cd;
						formObj.pol_cd.value = pol_cd;
						formObj.pod_cd.value = pod_cd;
						formObj.del_cd.value = del_cd;	 		            
						formObj.master_inv.value = master_inv;
						formObj.bkg_teu_qty.value = bkg_teu_qty;
						formObj.bkg_feu_qty.value = bkg_feu_qty;	
						formObj.inv_ref_no.value = cust_ref_no1;	
						formObj.bkg_ref_no.value = cust_ref_no2;
						formObj.si_ref_no.value = cust_ref_no3;
						formObj.due_dt.value = due_dt;	
						formObj.eff_dt.value = gl_eff_dt;
						formObj.eff_dt_tmp.value = gl_eff_dt;	
						//formObj.cust_cnt_cd.value = act_cust_cnt_cd;
						//formObj.cust_seq.value = act_cust_seq;		 		        	
						formObj.cust_nm.value = cust_nm;
						formObj.cust_rgst_no.value = cust_rgst_no;
						formObj.cr_curr_cd.value = cr_curr_cd;
						formObj.cr_amt.value = ComAddComma(cr_amt);
						formObj.ob_cr_term_dys.value = ob_cr_term_dys;
						formObj.ib_cr_term_dys.value = ib_cr_term_dys;
						formObj.cr_clt_ofc_cd.value = cr_clt_ofc_cd;
		
						formObj.bl_no.value = bl_src_no;
						formObj.bkg_no.value = bkg_no;
		
						formObj.inv_cust_cnt_cd.value = inv_cust_cnt_cd;
						formObj.inv_cust_seq.value = inv_cust_seq;
		
						sheetObjects[2].LoadSearchXml(sXml); 
		
						for ( var i = 0; i < sheetObjects[2].RowCount; i++) {
		
							var row = i + 1;
							sheetObjects[2].CellValue2(row, 0) = "I";
						}
					} else {
						formObj.lcl_vvd.value = "";	 		           
						formObj.svc_scp_cd.value = "";
						formObj.io_bnd_cd.value = "";	 		            
						formObj.sail_arr_dt.value = "";	 		            
						formObj.trunk_vvd.value = "";
						formObj.por_cd.value = "";
						formObj.pol_cd.value = "";
						formObj.pod_cd.value = "";
						formObj.del_cd.value = ""; 		            
						formObj.master_inv.value = "";
						formObj.bkg_teu_qty.value = "";
						formObj.bkg_feu_qty.value = "";	
						formObj.inv_ref_no.value = "";	
						formObj.bkg_ref_no.value = "";
						formObj.si_ref_no.value = "";
						formObj.due_dt.value = "";	
						formObj.eff_dt.value = "";
		
						formObj.inv_cust_cnt_cd.value = "";
						formObj.inv_cust_seq.value = "";
		
					}	        		
		
				}	 		 		            
		
			}
		
			setButtons();
		
			break;
	
		case IBSEARCH_ASYNC08:
			if (formObj.ar_if_no.value != "") {		
				
				formObj.f_cmd.value = SEARCH10;
				//ComOpenWait(true);
				var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				//ComOpenWait(false);
	
				if (arrXml.length > 0) {
					sheetObjects[1].LoadSearchXml(arrXml[0]);
				}
				if (arrXml.length > 1) {
					sheetObjects[0].LoadSearchXml(arrXml[1]);
				}
				if (arrXml.length > 2) {
					sheetObjects[2].LoadSearchXml(arrXml[2]);
				}
				
				formObj.f_cmd.value = SEARCH07;
				var sXml = sheetObjects[0].GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj)); 
				var comboValues2 = ComGetEtcData(sXml, "currInfo");	
				formObj.curr_cds.value = comboValues2;
				var comboItems = comboValues2.split(ROWMARK);				
				addCellComboItem(sheetObjects[0],comboValues2,"curr_cd",true);	

	
				formObj.bl_no.value = ComGetEtcData(arrXml[0],"bl_src_no"); 
	
				formObj.value = ComGetEtcData(arrXml[0],"act_cust_cnt_cd"); 
				formObj.cust_seq.value = ComGetEtcData(arrXml[0],"act_cust_seq"); 
				formObj.cust_nm.value = ComGetEtcData(arrXml[0],"cust_nm"); 
				formObj.cust_rgst_no.value = ComGetEtcData(arrXml[0],"cust_rgst_no");  	        		 
				formObj.cr_curr_cd.value = ComGetEtcData(arrXml[0],"cr_curr_cd"); 
				formObj.cr_amt.value = ComAddComma(ComGetEtcData(arrXml[0],"cr_amt")); 
				formObj.ob_cr_term_dys.value = ComGetEtcData(arrXml[0],"ob_cr_term_dys"); 
				formObj.ib_cr_term_dys.value = ComGetEtcData(arrXml[0],"ib_cr_term_dys"); 
				formObj.cr_clt_ofc_cd.value = ComGetEtcData(arrXml[0],"cr_clt_ofc_cd"); 
	
				formObj.lcl_vvd.value = ComGetEtcData(arrXml[0],"vsl_cd")
				+ ComGetEtcData(arrXml[0],"skd_voy_no")
				+ ComGetEtcData(arrXml[0],"skd_dir_cd");
				formObj.svc_scp_cd.value = ComGetEtcData(arrXml[0],"svc_scp_cd");
				formObj.io_bnd_cd.value = ComGetEtcData(arrXml[0],"io_bnd_cd");
				formObj.sail_arr_dt.value = ComGetEtcData(arrXml[0],"sail_arr_dt");
	
				formObj.trunk_vvd.value = ComGetEtcData(arrXml[0],"trnk_vsl_cd")
				+ ComGetEtcData(arrXml[0],"trnk_skd_voy_no")
				+ ComGetEtcData(arrXml[0],"trnk_skd_dir_cd");
				formObj.por_cd.value = ComGetEtcData(arrXml[0],"por_cd");
				formObj.pol_cd.value = ComGetEtcData(arrXml[0],"pol_cd");
				formObj.pod_cd.value = ComGetEtcData(arrXml[0],"pod_cd");
				formObj.del_cd.value = ComGetEtcData(arrXml[0],"del_cd");
	
				formObj.master_inv.value = ComGetEtcData(arrXml[0],"mst_bl_no");
				formObj.hjs_ref.value = ComGetEtcData(arrXml[0],"hjs_stf_ctnt");
				formObj.bkg_teu_qty.value = ComGetEtcData(arrXml[0],"bkg_teu_qty");
				formObj.bkg_feu_qty.value = ComGetEtcData(arrXml[0],"bkg_feu_qty");
	
				formObj.inv_ref_no.value = ComGetEtcData(arrXml[0],"inv_ref_no");
				formObj.bkg_ref_no.value = ComGetEtcData(arrXml[0],"bkg_ref_no");
				formObj.si_ref_no.value = ComGetEtcData(arrXml[0],"si_ref_no");
	
				formObj.inv_rmk.value = ComGetEtcData(arrXml[0],"inv_rmk");
	
				formObj.due_dt.value = ComGetEtcData(arrXml[0],"due_dt");
				formObj.eff_dt.value = ComGetEtcData(arrXml[0],"gl_eff_dt");
				formObj.eff_dt_tmp.value = ComGetEtcData(arrXml[0],"gl_eff_dt");
				formObj.bl_inv_if_dt.value = ComGetEtcData(arrXml[0],"bl_inv_if_dt");
				formObj.ar_ofc_cd.text = ComGetEtcData(arrXml[0],"ar_ofc_cd");	
				formObj.delt_flg.value = ComGetEtcData(arrXml[0],"delt_flg");		
				formObj.bl_inv_cfm_dt.value = ComGetEtcData(arrXml[0],"bl_inv_cfm_dt");
	
				formObj.inv_svc_scp_cd.value = ComGetEtcData(arrXml[0],"inv_svc_scp_cd");				
				
				if (formObj.bl_inv_cfm_dt.value != "") {						 
	
					with(formObj){
						bl_no.readOnly = true;
						cust_cnt_cd.readOnly = true;
						cust_seq.readOnly = true;
						cust_nm.readOnly = true;
						cust_rgst_no.readOnly = true;
						rev_src_cd.readOnly = true;
						cr_curr_cd.readOnly = true;
						cr_amt.readOnly = true;
						ob_cr_term_dys.readOnly = true;
						ib_cr_term_dys.readOnly = true;
						cr_clt_ofc_cd.readOnly = true;
						lcl_vvd.readOnly = true;
						svc_scp_cd.readOnly = true;
						sail_arr_dt.readOnly = true;
						trunk_vvd.readOnly = true;
						por_cd.readOnly = true;
						pol_cd.readOnly = true;
						pod_cd.readOnly = true;
						del_cd.readOnly = true;
						master_inv.readOnly = true;
						hjs_ref.readOnly = true;
						bkg_teu_qty.readOnly = true;
						bkg_feu_qty.readOnly = true;
						inv_ref_no.readOnly = false;
						bkg_ref_no.readOnly = true;
						si_ref_no.readOnly = true;
						due_dt.readOnly = true; 
						eff_dt.readOnly = true;
						inv_rmk.readOnly = false;
						io_bnd_cd.disabled = true;
						popup1.disabled = true;
						popup2.disabled = true;
						popup3.disabled = true;		  
						ar_ofc_cd.Enable = false; 
						rev_src_cd.Enable = false; 							  
	
					}
					
					document.getElementById("bl_no").className = "input2";
					document.getElementById("cust_cnt_cd").className = "input2";
					document.getElementById("cust_seq").className = "input2";
					document.getElementById("lcl_vvd").className = "input2";
					document.getElementById("svc_scp_cd").className = "input2";
					document.getElementById("trunk_vvd").className = "input2";
					document.getElementById("por_cd").className = "input2";
					document.getElementById("pol_cd").className = "input2";
					document.getElementById("pod_cd").className = "input2";
					document.getElementById("del_cd").className = "input2";
					document.getElementById("master_inv").className = "input2";
					document.getElementById("hjs_ref").className = "input2";
					document.getElementById("bkg_teu_qty").className = "input2";
					document.getElementById("bkg_feu_qty").className = "input2";
					document.getElementById("io_bnd_cd").className = "input2";
					document.getElementById("cust_rgst_no").className = "input2";
					document.getElementById("eff_dt").className = "input2";
					
					sheetObjects[1].Editable = false;
					sheetObjects[0].Editable = false;
					sheetObjects[2].Editable = false;  	
	
					ComBtnDisable("btn_add"); 
					ComBtnDisable("btn_del"); 
	
				} else {
					
					
					
					document.form.eff_dt.className = "input1";
					document.form.eff_dt.readOnly = false;
										
					if (document.form.rev_src_cd.Code == "TM" || document.form.rev_src_cd.Code == "TN") {
						document.form.eff_dt.value = document.form.local_time.value.substring(0,4)+"-"
						+ document.form.local_time.value.substring(4,6)+"-"
						+ document.form.local_time.value.substring(6,8);
					}
					
					//2010-03-31
					sheetObjects[1].Editable = false;
					sheetObjects[0].Editable = true;
					sheetObjects[2].Editable = false; 					
					
					
					for(var i = 1; i < sheetObjects[0].RowCount + 1; i++) {
						
						var arrStr = form.ar_ofc_cd.Code.split("^");
						var chgCd = sheetObjects[0].CellValue(i,"chg_cd");
						var ofcCd = arrStr[1];
						var svrId = arrStr[7];
						var invVatChgCd = arrStr[16];
						
						if (invVatChgCd != "" && chgCd != "TVA") {
							sheetObjects[0].CellEditable(i, "tva_flg") = true;
						} else {
							sheetObjects[0].CellEditable(i, "tva_flg") = false;
						}	
						
						sheetObjects[0].CellValue2(i,"curr_cd") = sheetObjects[0].CellValue(i,"curr_cd")+"^"+sheetObjects[0].CellValue(i,"dp_prcs_knt");
						
						sheetObj.CellValue2(i, "chg_amt") = ComTrimAll(sheetObj.CellValue(i, "chg_amt"),",");
						
						point = sheetObjects[0].CellValue(i,"dp_prcs_knt");
						
						if (point == '0' || point == undefined) {
							sheetObjects[0].InitCellProperty(i, 7, dtData , daRight , "chg_amt", "", dfInteger);
						} else {
							sheetObjects[0].InitCellProperty(i, 7, dtData , daRight , "chg_amt", "", dfNullFloat, point);
						}
						
					}					
					
					ComBtnDisable("btn_add"); 
					ComBtnDisable("btn_del"); 
					
				}
	
			}            	
	
			break;
	
		case IBSAVE:        //저장						
			if(validateForm2(sheetObj,formObj,sAction) && chkLclVvd()) {

				// Cust CD 체크 
				if (getCustNmByCustCd() == false) {
					return false;
				}
				
				//chg_cd - curr 체크 시작
				var arrStr = formObj.ar_ofc_cd.Code.split("^");
				var ofcCd = arrStr[1];
				if (ofcCd == "VLCSC") {
					if(chkChgCurr() == false){
						return false;
					}
				}
	
				// 2011.11.14 오요한 [CHM-201113617] SVAT Reg. No for CMBSC
				if (ofcCd == "CMBSC" && !chkSvatRegNoForSave()){
					return false;
				}
				
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr2[1];
				formObj.svr_id.value = arrStr2[7];
				formObj.lcl_curr.value = arrStr2[4];
		
				formObj.f_cmd.value = MULTI;
					
				var sParam = FormQueryString(formObj);					
				var sParam1 = sheetObjects[0].GetSaveString(true); 				   
				var sParam2 = sheetObjects[2].GetSaveString(true); 

				if (sParam1 == "") {				
					return; 
				} else {
					sParam1 = ComSetPrifix(sParam1, "sheet1_");
					sParam = sParam + "&" + sParam1;
				}
		
				if (sParam2 == "") {				
					//return; 
				} else {
					sParam2 = ComSetPrifix(sParam2, "sheet2_");
					sParam = sParam + "&" + sParam2;
 
				}	

				var sXml = sheetObjects[1].GetSaveXml("FNS_INV_0071GS.do", sParam );	
				sheetObjects[1].LoadSaveXml(sXml);
		
				var arIfNo = ComGetEtcData(sXml,"ar_if_no");
				var dueDt = ComGetEtcData(sXml,"due_dt");
				var effDt = ComGetEtcData(sXml,"eff_dt");
		
				if (arIfNo != undefined && arIfNo != "") {
					formObj.ar_if_no.value = arIfNo; 
				} 
				if (dueDt != undefined && dueDt != "") {
					formObj.due_dt.value = dueDt.substring(0,4)+"-"+dueDt.substring(4,6)+"-"+dueDt.substring(6,8); 
				} 
				if (effDt != undefined && dueDt != "") {
					formObj.eff_dt.value = effDt.substring(0,4)+"-"+effDt.substring(4,6)+"-"+effDt.substring(6,8); 
				} 
		
				ComBtnDisable("btn_save"); 
				ComBtnDisable("btn_add");
				ComBtnDisable("btn_del");
		
				ComBtnDisable("btn_ib_all");
				ComBtnDisable("btn_ib_ats");
				ComBtnDisable("btn_ib_dhs");
				ComBtnDisable("btn_ib_sis");
				ComBtnDisable("btn_ib_ahc");
				ComBtnDisable("btn_ib_whs");
				ComBtnDisable("btn_ib_psm");		           
				ComBtnDisable("btn_ob_all");
				ComBtnDisable("btn_ob_ats");
				ComBtnDisable("btn_ob_dhs");
				ComBtnDisable("btn_ob_bcu");
				ComBtnDisable("btn_ob_whs");	
				ComBtnDisable("btn_ob_wht");	
		
				var state = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				formObj.state.value = state;
		
				if (state == "F") {
		
					ComBtnEnable("btn_save"); 
					ComBtnEnable("btn_add");
					ComBtnEnable("btn_del");
		
					ComBtnEnable("btn_ib_all");
					ComBtnEnable("btn_ib_ats");
					ComBtnEnable("btn_ib_dhs");
					ComBtnEnable("btn_ib_sis");
					ComBtnEnable("btn_ib_ahc");
					ComBtnEnable("btn_ib_whs");
					ComBtnEnable("btn_ib_psm");		           
					ComBtnEnable("btn_ob_all");
					ComBtnEnable("btn_ob_ats");
					ComBtnEnable("btn_ob_dhs");
					ComBtnEnable("btn_ob_bcu");
					ComBtnEnable("btn_ob_whs");	
					ComBtnEnable("btn_ob_wht");	
					
					if(formObj.classId.value != "FNS_INV_0071"){
						formObj.ar_if_no.value = ""; 
					}
					
				}else{
					if(formObj.classId.value == "FNS_INV_0071"){
						self.close();
					}
				}
		
			} 
		
			break;
	
		case IBSEARCH_ASYNC13: // Local Time 조회   
	
			formObj.f_cmd.value = SEARCH11;		
			var arrStr = formObj.ar_ofc_cd.Code.split("^");
			formObj.ofc_cd.value = arrStr[1];
		
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
		
			var localTime = ComGetEtcData(sXml, "local_time");	
			formObj.local_time.value = localTime;	
		
			break;	  
	
		case IBSEARCH_ASYNC14: // Block Charge 조회   
	
			formObj.f_cmd.value = SEARCH12;		
		
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
		
			var blckChg = ComGetEtcData(sXml, "blck_chg");	
			formObj.blck_chg.value = blckChg;	
		
			break;	  	
		
		case IBSEARCH_ASYNC09: // auto BL No 조회
		
			var tmpBlSrcNo = formObj.tmp_bl_src_no.value;
			var arOfcCd = "";
			var arHdQtrOfcCd = "";
			if (tmpBlSrcNo == '') {
				formObj.f_cmd.value = MULTI01;
				// OFFICE Info
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				arHdQtrOfcCd = arrStr2[0];
				arOfcCd = arrStr2[1];
				
	 			formObj.ofc_cd.value = arOfcCd;
	 			
				var sXml = sheetObj.GetSaveXml("FNS_INV_0071GS.do", FormQueryString(formObj));
				
				var blMaxSeq = ComGetEtcData(sXml,"bl_max_seq");
				if (blMaxSeq != undefined) {
					// 단, RHQ가 'SELHO'인 OFC는 OFC 앞 3자리 대신 뒤 3자리로 생성한다(예 : OFC = SELPIO → BL NO = PIO090828001)
					if (arHdQtrOfcCd == 'SELHO') {
						blMaxSeq = arOfcCd.substring(3)+blMaxSeq.substring(3);
					}
					
					formObj.bl_no.value = blMaxSeq;
					formObj.tmp_bl_src_no.value = blMaxSeq;
					formObj.bl_no.focus();
				}
				else {
					ComShowMessage(ComGetMsg('INV00095'));
				}
			}
			else {
				formObj.bl_no.value = tmpBlSrcNo;
				formObj.bl_no.focus();
			}
			break;		
	
		case IBINSERT:      // 입력
			break;
		
		case IBSEARCH_ASYNC05:
		
			formObj.f_cmd.value = SEARCH13;		   
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
			var ivaRate = ComGetEtcData(sXml, "iva_rate");	
			formObj.iva_rate.value = ivaRate;
		
			break;	
		
		// [CHM-201113617] SVAT Reg. No for CMBSC 대응 -
		// CMBSC이고 INV_AR_SPND_VAT_RGST_NO에 현재의 Cust코드에 일치하는 값이 있을때 VDS CHG를 선택할 수 없게 구현
		case IBSEARCH_ASYNC06:    
		
			formObj.f_cmd.value = SEARCH14;		   
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
			var exist_rgstNo = ComGetEtcData(sXml, "spnd_vat_rgst");
			if (exist_rgstNo =="Y") {
				existSvatRegNo = "Y";
			} else {
				existSvatRegNo = "N";
			}
			break;
		
		case IBSEARCH_ASYNC04: // Sa Date / Due Date 조회 2011.11.22	권 민

			formObj.vvd.value	= formObj.lcl_vvd.value;		        
			formObj.bnd.value	= formObj.io_bnd_cd.value;
			
			if(formObj.bnd.value == "I") {
				formObj.port.value = formObj.pod_cd.value;
			} else {
				formObj.port.value = formObj.pol_cd.value;
			}		        
		
			formObj.f_cmd.value = SEARCH15;
			
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));					
			
			var lclVvd = formObj.lcl_vvd.value;
			var sail_arr_dt	= ComGetEtcData(sXml,"sa_date");
			var due_dt = ComGetMaskedValue(ComGetEtcData(sXml,"due_date"), "ymd");
			// M type Common VVD면 commonVVD 날짜로 sail_arr_dt 를 구함.
			var m_sail_arr_dt = "20"+lclVvd.substring(4,6)+"-"	+ lclVvd.substring(6,8)+"-"+"01";

			if(lclVvd.substring(0,4) == "CFDR" || lclVvd.substring(0,4) == "CNTC" || lclVvd.substring(0,4) == "USAC"){
				formObj.sail_arr_dt.value	= m_sail_arr_dt;
				formObj.due_dt.value		= due_dt;	
			} else {
				formObj.sail_arr_dt.value	= sail_arr_dt;
				formObj.due_dt.value		= due_dt;
			}
		
			break;
			
		
		case IBSEARCH_ASYNC02:   //USER_ID로 COM_USER의 OFC_CD를 조회한다.  
			
			formObj.f_cmd.value = SEARCH17;		   
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
			usr_ofc_cd = ComGetEtcData(sXml, "usr_ofc_cd");
			
			break;
 
		
		case IBSEARCH_ASYNC01:   // POL_CD, POD_CD 를 이용해서 구주 인지 여부를 조회 한다.
			formObj.f_cmd.value = SEARCH18;		   
			var sXml = sheetObj.GetSearchXml("FNS_INV_0071GS.do", FormQueryString(formObj));
			var eu_check = ComGetEtcData(sXml, "eu_check");
			formObj.eu_check.value = eu_check;
 			break;
		}
	}
	
	 
	/**
	 * VLCSC일 경우 CHG를 체크한다.<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     chkChgCurr();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 오요한
	 * @version 2011.10.17
	 */     
	function chkChgCurr(){
		var formObject = document.form;
		var chg_cd = "";
		var curr_cd = "";		
		for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			chg_cd = sheetObjects[0].CellText(i,"chg_cd");
			curr_cd = sheetObjects[0].CellText(i,"curr_cd");
			formObject.exist_yn.value = "N";
			formObject.p_chg_cd.value = chg_cd;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC18);

			// 2011-10-13 [CHM-201111521] 요청으로 6월에 이미 VLCSC LOCAL CHG 인 경우 O/B 인 경우 EUR 과 USD 도 가능하게 하고,
			// I/B 는 그대로 EUR 을 허용하는것은 기 반영되어 있었으나 최종 SAVE 시점에 한번 더 체크를 하기 위해서 추가 함
			if (formObject.exist_yn.value == "Y") {
				// In bound 일 경우에도 'EUR', 'USD' 선택 입력할 수 있도록 수정. by Sang-Hyun Kim - 2012.03.05
				if (curr_cd != "EUR" && curr_cd != "USD") {
					ComShowCodeMessage("INV00041", "CHG / Cur"); 
					sheetObjects[0].SelectCell(i, "chg_cd");
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * CMBSC인 경우 SVAT Reg NO를 조회한다.(단건)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     chkSvatRegNo(Row);
	 * </pre>
	 * @param selectRow 선택된 Row값
	 * @return boolean
	 * @author 오요한
	 * @version 2011.10.17
	 */     	
	function chkSvatRegNo(selectRow) {
		
		var formObject = document.form;
		var chg_cd = sheetObjects[0].CellText(selectRow,"chg_cd");
		
		if (chg_cd == "VDS") {
			
			formObject.p_chg_cd.value = chg_cd;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC06);

			if (existSvatRegNo == "Y") {
				ComShowCodeMessage("INV00041", "VDS Charge");
				sheetObjects[0].CellText(selectRow,"chg_cd") = "";
				sheetObjects[0].CellEditable(selectRow, "chg_cd") = true;
				sheetObjects[0].SelectCell(selectRow, "chg_cd");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * SAVE버튼 클릭시 CMBSC인 경우 SVAT Reg NO를 조회한다.(복수)<br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     chkSvatRegNoForSave();
	 * </pre>
	 * @param 없음
	 * @return boolean
	 * @author 오요한
	 * @version 2011.10.17
	 */     		
	function chkSvatRegNoForSave(){
	
		var formObject = document.form;
		var chg_cd = "";
		
		for (var i=1; i<=sheetObjects[0].RowCount; i++) {
			chg_cd = sheetObjects[0].CellText(i,"chg_cd");
			
			if (chg_cd == "VDS") {
				
				formObject.p_chg_cd.value = chg_cd;
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC06);
		
				if (existSvatRegNo == "Y") {
					ComShowCodeMessage("INV00041", "VDS Charge");
					sheetObjects[0].CellEditable(i, "chg_cd") = true;
					sheetObjects[0].SelectCell(i, "chg_cd");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * IBTab Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setTabObject(tab_obj)
	 * </pre>
	 * @param {ibtab} tab_obj 필수 IBTab Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */      
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	
	}
	
	/**
	 * Tab 기본 설정 <br> 
	 * 탭의 항목을 설정한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initTab(tabObj, tabNo)
	 * </pre>
	 * @param {ibtab} tabObj 필수 IBTab Object
	 * @param {int} tabNo 탭오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */       
	function initTab(tabObj , tabNo) {
		switch(tabNo) {
		case 1:
			with (tabObj) {
	
				var cnt  = 0 ;
				InsertTab( cnt++ , "Information" , -1 );
				InsertTab( cnt++ , "Charge" , -1 );
	
			}
			break;
	
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련 <br>
	 * 선택한 탭의 요소가 활성화 된다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     tab1_OnChange(tabObj, nItem);
	 * </pre>
	 * @param {ibtab} tabObj 필수 IBTab Object
	 * @param {int} nItem ibtab 해당 index
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */        
	function tab1_OnChange(tabObj, nItem)
	{
	
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	
	} 
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm(sheetObj, formObj, sAction)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		with(formObj){
	
			/* b/l 체크로직 제거  20090717 정휘택     
	
	        	 if(formObj.bl_no.value != "") {        	 
	
			         var v_bl_no = bl_no.value;
			         var sum = 0;
			         var v1 = 0;
	
			         if(v_bl_no.length < 6) {
			        	 ComShowCodeMessage("COM12114", "B/L No.");
			        	 bl_no.focus();
			        	 return false;
			         } else if(v_bl_no.length = 12){
	
			        	 for(var i = 0; i < v_bl_no.length - 1; i++){
			        		 if(v_bl_no.charAt(i) >= 0 && v_bl_no.charAt(i) <= 9){
			        			 sum = sum + parseInt(v_bl_no.charAt(i));
			        		 } else {
			        			 if(v_bl_no.charAt(i).charCodeAt(0) >= "A".charCodeAt(0) && v_bl_no.charAt(i).charCodeAt(0) <= "Z".charCodeAt(0)){
			        				 v1 = v_bl_no.charAt(i).charCodeAt(0) - 64;
			        				 if(String(v1).length != 1){
			        					 v1 = parseInt(String(v1).charAt(0)) + parseInt(String(v1).charAt(1));   
			        				 }
			        				 sum = sum + v1;            				 
	
			        			 } else {
			        				 ComShowCodeMessage("COM12114", "B/L No.");
			        	        	 bl_no.focus();
			        	        	 return false;
			        			 }        			 
			        		 }        		 
			        	 } // for        	 
			         }
	
			         var bl_ck = v_bl_no.charAt(11);
			         var bl_rtn = sum % 7; 
			         var rev_src = rev_src_cd.Code
	
			         if(parseInt(bl_ck) != bl_rtn && parseInt(bl_ck) != bl_rtn + 1 && rev_src != "TM"){
			        	 ComShowCodeMessage("COM12114", "B/L No.");
			        	 bl_no.focus();
			        	 return false;        	 
			         }
	
	        	 }
	
	        	 if(formObj.bl_no.value == "" && formObj.bkg_no.value == ""){
	        		 ComShowCodeMessage("COM12114", "B/L No. or BKG No.");
	        		 return false;   
	
	        	 }
			 */        	 
	
		}
	
		return true;
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     validateForm2(sheetObj, formObj, sAction)
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {form} formObj 필수 html form object
	 * @param {int} sAction 필수 프로세스 플래그 상수
	 * @return boolean
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function validateForm2(sheetObj,formObj,sAction){	  
		with(formObj){ 	    	  
	
			//if (document.form.classId.value == "") {
			if (!chrgChk()) {
				return false;
			}
			//}
			if( formObj.cust_cnt_cd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.cust_cnt_cd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.cust_seq.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.cust_seq.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if (formObj.delt_flg.value == "Y") {
				ComShowCodeMessage("INV00060");
				return;						
			}	    	  
	
			if( formObj.lcl_vvd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.lcl_vvd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.svc_scp_cd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.svc_scp_cd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.io_bnd_cd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.io_bnd_cd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.pol_cd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.pol_cd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.pod_cd.value == "" ){  
				tabObjects[0].SelectedIndex = 0;
				formObj.pod_cd.focus();
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.sail_arr_dt.value == "" ){  
				ComShowCodeMessage("INV00011");
				return false;
			}
			

			if(sheetObj.RowCount < 1){
				ComShowCodeMessage("INV00004");
				return false;        		 
			}   
	
			for(var i = 1; i < sheetObj.RowCount + 1; i++) {
	
				if (sheetObj.CellValue(i,2) == "") {					 
					ComShowCodeMessage("INV00004");
					return false;
				}
				if (sheetObj.CellValue(i,3) == "" || sheetObj.CellValue(i,3) == "0") {
					ComShowCodeMessage("INV00004");
					return false;
				}
				if (sheetObj.CellValue(i,4) == "" || sheetObj.CellValue(i,4) == "0") {
					ComShowCodeMessage("INV00004");
					return false;
				}
				if (sheetObj.CellValue(i,5) == "") {
					ComShowCodeMessage("INV00004");
					return false;
				}
				if (sheetObj.CellValue(i,7) == "0") {
					ComShowCodeMessage("INV00004");
					return false;
				}
	
				
				// IVA 인 경우 체크
				var chg_cd = sheetObj.CellValue(i, "chg_cd");
				var arrStr = formObj.ar_ofc_cd.Code.split("^");

				if(ofcCd == "VLCSC"){
					getEuCheck();
				}

				var ofcCd = arrStr[1];
				if ( chg_cd == "IVA" &&ofcCd == "VLCSC" && ( formObj.io_bnd_cd.value == "I"   || (formObj.io_bnd_cd.value == "O" && formObj.eu_check.value =="Y"))) {
					
					var ratVal = sheetObj.CellText(i, "rat_as_cntr_qty");
					if (ratVal != null && ComTrim(ratVal) !="") {
						ratVal = parseInt(ratVal);
						if (ratVal != 16 && ratVal != 18 && ratVal != 21) {
							ComShowCodeMessage("INV00159");
							var vatChgRt = arrStr[17];
							sheetObj.CellValue(sheetObj.i, "rat_as_cntr_qty") =vatChgRt;
							sheetObj.SelectCell(i,"rat_as_cntr_qty");
							return false;
						}
					} else {
						ComShowCodeMessage("INV00159");
						var vatChgRt = arrStr[17];
						sheetObj.CellValue(sheetObj.i, "rat_as_cntr_qty") =vatChgRt;
						sheetObj.SelectCell(i,"rat_as_cntr_qty");
						return false;
					}
				}				
				
			}
			
			
			// formObj.rev_src_cd.Code == "VT" 이고, Login한 User의 Office code가  "SELADG" 일때 에러 메시지 출력 및 그리드 초기화
			for(var i = 1; i < sheetObj.RowCount + 1; i++) {
				if ((formObj.rev_src_cd.Code == "VT") && (usr_ofc_cd == "SELADG")) {
					if(sheetObj.CellValue(i, "chg_cd")!="TVA"){
						ComShowCodeMessage("INV00163"); 
						
						//그리드를 초기화한다.
						sheetObjects[0].removeAll();
						sheetObjects[1].removeAll();
						initSheet(sheetObjects[0],1,0);
						
						return false;
					}
				}
			}
	
			if( formObj.bl_no.value == "" ){  
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.cust_cnt_cd.value == "" ){  
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			if( formObj.cust_seq.value == "" ){  
				ComShowCodeMessage("INV00004");
				return false;
			}
			
			if( formObj.rev_src_cd.Code == "" ){  
				ComShowCodeMessage("INV00004");
				return false;
			}
	
			//[CHM-201220761] - 2012.10.15 : MRI에서 사용 불가능하도록 규정된 Charge에 대해서, MIV 뿐 아니라 MRI에서 생성시키는 다른 타입의 채권에도 사용하지 못하도록 함.
			for(var i = 1; i < sheetObj.RowCount + 1; i++) {
				if (sheetObj.CellValue(i, "trf_rt_amt") < 0) {
					cnt++;	    				  
				}
				
				formObj.p_chg_cd.value = sheetObj.CellValue(i, "chg_cd");
				doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC14);	

				if (formObj.blck_chg.value == "") {
					ComShowCodeMessage("INV00114");
					sheetObj.CellValue2(i, "chg_cd") = "";
					return;
				}

			}
			

			if(formObj.rev_src_cd.Code == "IV"){ 
				var cnt = 0;
				
				var arrStr = formObj.ar_ofc_cd.Code.split("^");
				formObj.ofc_cd.value = arrStr[1];
				
				for(var i = 1; i < sheetObj.RowCount + 1; i++) {
					if (sheetObj.CellValue(i, "trf_rt_amt") < 0) {
						cnt++;	    				  
					}
					
					formObj.p_chg_cd.value = sheetObj.CellValue(i, "chg_cd");
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC14);	
		//			alert("13");
		//			if( ofcCd == "VLCSC" && formObj.io_bnd_cd.value == "O" && formObj.eu_check.value =="Y"){
//						return;
		//			}else{
					if (formObj.blck_chg.value == "") {
						ComShowCodeMessage("INV00114");
						sheetObj.CellValue2(i, "chg_cd") = "";
						return;
					}
		//			}
				}
				if (cnt > 0) {
					ComShowCodeMessage("INV00101");
					return false;
				}
	
			}

			if(formObj.rev_src_cd.Code == "IC"){ 
				var cnt = 0;
				for(var i = 1; i < sheetObj.RowCount + 1; i++) {
					//2010-04-28 이상희과장
					//if (sheetObj.CellValue(i, "trf_rt_amt") > -1) {
					if (sheetObj.CellValue(i, "trf_rt_amt") > 0) {
						cnt++;	    				  
					}
				}
				if (cnt > 0) {
					ComShowCodeMessage("INV00102");
					return false;
				}
	
			}
			
			if(formObj.rev_src_cd.Code == "TV"){ 				
				for(var i = 1; i < sheetObj.RowCount + 1; i++) {
					if (sheetObj.CellValue(i, "chg_cd") != 'IEV') {
						ComShowCodeMessage("INV00114");
						sheetObj.CellValue2(i, "chg_cd") = "";
						return;
					}
				}	
			}
			
			if( formObj.rev_tp_cd.value == "M"  && formObj.rev_src_cd.Code == "IC"){  
				if(formObj.inv_rmk.value =="" || formObj.inv_rmk.value.length < 10  ){
					tabObjects[0].SelectedIndex = 0;
					formObj.inv_rmk.focus();
					ComShowCodeMessage("INV00175");
					return false;
				}
			}
	
		}
	
		return true;
	}
	
	/**
	 * VLCSC 의 Charge 버튼 세팅 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setButtons();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */   	  
	function setButtons() {
	
		var formObj = document.form;	
		var arrStr = formObj.ar_ofc_cd.Code.split("^");	 		        	 
		var ofcCd = arrStr[1];
		var ioBndCd = formObj.io_bnd_cd.value;
	
		if (ofcCd == "VLCSC") {
			if (ioBndCd == "O") {
				document.all.btn_layer_ib.style.display = "none";
				document.all.btn_layer_ob.style.display = "";
			} else {
				document.all.btn_layer_ob.style.display = "none";
				document.all.btn_layer_ib.style.display = "";				  
			}
		} else {
			document.all.btn_layer_ob.style.display = "none";
			document.all.btn_layer_ib.style.display = "none";	
		}
	
	}
	
	/* 개발자 작업  끝 */