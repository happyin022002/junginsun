	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0135.js
	 *@FileTitle : (SAOSC) Split Invoice Re-Issue
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.30
	 *@LastModifier : 정휘택
	 *@LastVersion : 1.0
	 * 2009.06.30 정휘택
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * History
	 * 2012.03.12 권   민 [CHM-201216480] SAOSC의 인보이스 이슈 기능 개발 요청
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
	 * fns_inv_0135 : fns_inv_0135 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     fns_inv_0135()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function fns_inv_0135() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		    = setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl              = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}
	
	/* 개발자 작업	*/
	
	// 공통전역변수
	
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var rdObjects = new Array();
	var rdCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

    /**
     * preview 화면에서 issue 할때, 호출됨<br>
     *
     * @param 없음
     * @return 없음
     */
    function getPreviewIssue(){   
    	
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;
    	
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		formObject.iss_ofc_cd.value = arrStr2[1];
		formObject.ots_smry_cd.value = arrStr2[13];
						
		if (formObject.sel_option[0].checked){                         		

			var invs = "";
			for (var i = 0; i < sheetObject.RowCount; i++) {
				for (var j = 0; j < 5; j++) {
					if(sheetObject.CellValue(i+1, j) != "") {
						//invs = invs + (invs == "" ? "" : "'") +sheetObject.CellValue(i+1, j) + "',";
						invs = invs + "'" + sheetObject.CellValue(i+1, j) + "',";

					}
				}
			}

			if (invs == "") {
				ComShowCodeMessage("INV00071");
				sheetObject.CellValue(1,0) = "";
				return false;
			}   

			invs = invs + "''";     
			
			formObject.flag.value = "S";
			formObject.invs.value = invs;
			
			formObject.prev_flg.value = "N";
			formObject.goto_flg.value = "N";
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   
			if (formObject.r_invs.value != "") {

				var r_invs = formObject.r_invs.value;               	
				var arrStr = r_invs.split("|");

				var cmbFlg = formObject.cmb_flg.value;               	
				var arrStr2 = cmbFlg.split("|");

				var v_copy_cnt = formObject.copy_cnt.value;  
				
				rdObjects[0].SetAppendReport(0);
				for(var i=0; i<arrStr.length-1; i++){
					rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "ORIGINAL", "", "", "N", "Y", arrStr2[i]);
					rdObjects[0].SetAppendReport(1);
					for(var j=0; j<v_copy_cnt; j++) {  						
						rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "COPY", "", "", "N", "Y", arrStr2[i]);
					}

					formObject.inv_no.value = arrStr[i];        					

				}  
				
				// 프린터 세팅
		    	var print_nm = form.print_nm.value;
		    	if(print_nm != ""){
		    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
		    	}
				rdObjects[0].CMPrint (); //인쇄 시작
				rdObjects[0].SetAppendReport(0);
           		
			} else {
				ComShowCodeMessage("INV00097");
				return false;

			}   

		} else {

			var v_f_inv = formObject.f_inv.value;
			var v_t_inv = formObject.t_inv.value;
			var inv_no = "";

			if (v_f_inv == "") {
				ComShowCodeMessage("INV00004");
				formObject.f_inv.focus();
				return false;
			}
			if (v_t_inv == "") {
				ComShowCodeMessage("INV00004");
				formObject.t_inv.focus();
				return false;
			}

			formObject.flag.value = "M";
			formObject.prev_flg.value = "N";
			formObject.goto_flg.value = "N";
			doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   

			if (formObject.r_invs.value != "") {

				var r_invs = formObject.r_invs.value;               	
				var arrStr = r_invs.split("|");
				var v_copy_cnt = formObject.copy_cnt.value;  
				
				rdObjects[0].SetAppendReport(0);
				for(var i=0; i<arrStr.length-1; i++){

					//alert(arrStr[i]);
					rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "ORIGINAL", "", "", "N", "Y", "");
					rdObjects[0].SetAppendReport(1); 
					for(var j=0; j<v_copy_cnt; j++) {  						
						rdOpen(rdObjects[0], arrStr[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "COPY", "", "", "N", "Y", "");
					}

					formObject.inv_no.value = arrStr[i];        					

				}  

				// 프린터 세팅
		    	var print_nm = form.print_nm.value;
		    	if(print_nm != ""){
		    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
		    	}
		    	
				rdObjects[0].CMPrint (); //인쇄 시작
				rdObjects[0].SetAppendReport(0);           		

			} else {
				ComShowCodeMessage("INV00097");
				return false;

			}                        	

		}         
    	
    }
    
	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
	
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch(srcName) {
	
			case "btn_paper":
				
				var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
				formObject.iss_ofc_cd.value = arrStr2[1];
				formObject.ots_smry_cd.value = arrStr2[13];
								
				if (formObject.sel_option[0].checked){                         		
	
					var invs = "";
					for (var i = 0; i < sheetObject.RowCount; i++) {
						for (var j = 0; j < 5; j++) {
							if(sheetObject.CellValue(i+1, j) != "") {
								//invs = invs + (invs == "" ? "" : "'") +sheetObject.CellValue(i+1, j) + "',";
								invs = invs + "'" + sheetObject.CellValue(i+1, j) + "',";
	
							}
						}
					}
	
					if (invs == "") {
						ComShowCodeMessage("INV00071");
						sheetObject.CellValue(1,0) = "";
						return false;
					}   
	
					invs = invs + "''";     
					//alert(invs);
					formObject.flag.value = "S";
					formObject.invs.value = invs;					
					formObject.prev_flg.value = "N";

					formObject.goto_flg.value = "N";
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   
	
					if (formObject.r_invs.value != "") {
	
						var r_invs = formObject.r_invs.value;               	
						var arrStr = r_invs.split("|");
	
						var cmbFlg = formObject.cmb_flg.value;               	
						var arrStr2 = cmbFlg.split("|");
						
						var r_ifnos = formObject.r_ifnos.value;               	
						var arrStr3 = r_ifnos.split("|");
	
						var v_copy_cnt = formObject.copy_cnt.value;  
						
						rdObjects[0].SetAppendReport(0);
						for(var i=0; i<arrStr.length-1; i++){
							// rdOpen(Rdviewer, inv_no, if_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg)
							rdOpen(rdObjects[0], arrStr[i], arrStr3[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "ORIGINAL", "", "", "N", "Y", arrStr2[i]);
							rdObjects[0].SetAppendReport(1);
							for(var j=0; j<v_copy_cnt; j++) {  						
								rdOpen(rdObjects[0], arrStr[i], arrStr3[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "COPY", "", "", "N", "Y", arrStr2[i]);
							}
	
							formObject.inv_no.value = arrStr[i]; 
							formObject.if_no.value = arrStr3[i];   
	
						}  
						
						// 프린터 세팅
				    	var print_nm = form.print_nm.value;
				    	if(print_nm != ""){
				    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
				    	}
						rdObjects[0].CMPrint (); //인쇄 시작
						rdObjects[0].SetAppendReport(0);
                   		
					} else {
						ComShowCodeMessage("INV00097");
						return false;
	
					}   
	
				} else {
	
					var v_f_inv = formObject.f_inv.value;
					var v_t_inv = formObject.t_inv.value;
					var inv_no = "";
	
					if (v_f_inv == "") {
						ComShowCodeMessage("INV00004");
						formObject.f_inv.focus();
						return false;
					}
					if (v_t_inv == "") {
						ComShowCodeMessage("INV00004");
						formObject.t_inv.focus();
						return false;
					}
	
					formObject.flag.value = "M";
					formObject.prev_flg.value = "N";
					formObject.goto_flg.value = "N";
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   
	
					if (formObject.r_invs.value != "") {
	
						var r_invs = formObject.r_invs.value;  
						var r_ifnos = formObject.r_ifnos.value; 
						var arrStr = r_invs.split("|");
						var arrStr2 = r_ifnos.split("|");
						var v_copy_cnt = formObject.copy_cnt.value;  
							
						rdObjects[0].SetAppendReport(0);
						for(var i=0; i<arrStr.length-1; i++){
	
//							alert(arrStr[i]);
//							alert(arrStr2[i]);
							rdOpen(rdObjects[0], arrStr[i], arrStr2[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "ORIGINAL", "", "", "N", "Y", "");
							rdObjects[0].SetAppendReport(1);
							for(var j=0; j<v_copy_cnt; j++) {  						
								rdOpen(rdObjects[0], arrStr[i], arrStr2[i], 15, formObject.user_nm.value, formObject.iss_ofc_cd.value, "COPY", "", "", "N", "Y", "");
							}
	
							formObject.inv_no.value = arrStr[i];
							formObject.if_no.value = arrStr2[i];
	
						}  
	
						// 프린터 세팅
				    	var print_nm = form.print_nm.value;
				    	if(print_nm != ""){
				    		rdObjects[0].SetPrintInfo (print_nm, 1, 1, 4);
				    	}
				    	
						rdObjects[0].CMPrint (); //인쇄 시작
						rdObjects[0].SetAppendReport(0);           		
	
					} else {
						ComShowCodeMessage("INV00097");
						return false;
	
					}                        	
	
				}         
	
				break;
	
			case "btn_new":
				formObject.sel_option[0].checked = true;
				clickOption();
				formObject.ar_ofc_cd.text = formObject.user_ofc.value;
				break;
	
			case "btn_goto":
	
				var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
				formObject.iss_ofc_cd.value = arrStr2[1];
								
				if (formObject.sel_option[0].checked){                         		
					var invs = "";
					for (var i = 0; i < sheetObject.RowCount; i++) {
						for (var j = 0; j < 5; j++) {
							if(sheetObject.CellValue(i+1, j) != "") {
								//invs = invs + (invs == "" ? "" : "'") +sheetObject.CellValue(i+1, j) + "',";
								invs = invs + "'" + sheetObject.CellValue(i+1, j) + "',";
	
							}
						}
					}

					if (invs == "") {
						ComShowCodeMessage("INV00071");
						sheetObject.CellValue(1,0) = "";
						return false;
					}   
	
					invs = invs + "''";     
					//alert(invs);
					formObject.flag.value = "S";
					formObject.invs.value = invs;
					//formObject.goto_flg.value = "Y";
					formObject.prev_flg.value = "Y";
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   

//					if (formObject.r_invs.value == "") {
//						ComShowCodeMessage("INV00097");
//						return false;
//					}   
	
				} else {
	
					var v_f_inv = formObject.f_inv.value;
					var v_t_inv = formObject.t_inv.value;
					var inv_no = "";
	
					if (v_f_inv == "") {
						ComShowCodeMessage("INV00004");
						formObject.f_inv.focus();
						return false;
					}
					if (v_t_inv == "") {
						ComShowCodeMessage("INV00004");
						formObject.t_inv.focus();
						return false;
					}
	
					formObject.flag.value = "M";
					//formObject.goto_flg.value = "Y";
					formObject.prev_flg.value = "Y";
					doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC20);   
	
					if (formObject.r_invs.value == "") {
						ComShowCodeMessage("INV00097");
						return false;
					}                        	
	
				}			
				
				var invs = "";
				for (var i = 0; i < sheetObject.RowCount; i++) {
					for (var j = 0; j < 5; j++) {
						if(sheetObject.CellValue(i+1, j) != "") {
							//invs = invs + (invs == "" ? "" : "'") +sheetObject.CellValue(i+1, j) + "',";
							invs = invs + "'" + sheetObject.CellValue(i+1, j) + "',";
	
						}
					}
				}
	
				invs = invs + "''";			
				formObject.invs_email.value = invs;
								
				openEmail();
	
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
	 * IBSheet Object를 배열로 등록 <br>
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
	 * 배열은 소스 상단에 정의 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setSheetObject(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function setSheetObject(sheetObj){
	
		sheetObjects[sheetCnt++] = sheetObj;
	
	}
	
	/**
	 * Sheet 기본 설정 및 초기화 <br>
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     loadPage();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}

		initControl();
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);                
		initRdConfig(rdObjects[0]);
	
	}
	
	/**
	 * 업무 자바스크립트 sheet1_OnLoadFinish 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnLoadFinish(sheetObj);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet1_OnLoadFinish(sheetObj) {
	
		for(var i=0; i<20; i++){			
			sheetObj.DataInsert(-1);
		}
		sheetObj.SelectCell(1,0,false);
	
		doActionIBSheet(sheetObj,document.form,IBSEARCH);    
	
		var ar_ofc_cd = document.form.ar_ofc_cd.text
	
//		if (ar_ofc_cd == "SZPSC" || ar_ofc_cd == "XMNBB" || ar_ofc_cd == "CANBS") {
//			//document.all.btnPaper.style.display = "none";
//			ComBtnDisable("btn_paper"); 
//		}
//		if (ar_ofc_cd == "SGNSC") {
//			//document.all.btnPaper.style.display = "none";
//			ComBtnDisable("btn_goto"); 
//		}
	
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의 <br> 
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initSheet(sheetObj, 0);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} sheetNo 시트오브젝트 태그의 아이디에 붙인 일련번호 
	 * @return 없음 
	 * @author 정휘택
	 * @version 2009.10.20     
	 */  
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
		var sheetID = sheetObj.id;
		switch(sheetID) {
		case "sheet1":  
	
			with (sheetObj) {
	
				WaitImageVisible = false;
	
				// 높이 설정
				style.height = 230;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
	
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;
	
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
	
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 1, 100);
	
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(5, 0, 0, true);
	
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false)
	
				var HeadTitle = "1|2|3|4|5";
	
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true, true);
	
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtData,    160,    daCenter,  false,    "A",   false,	"",    dfNone,   0,  true,	true,   15,   15);
				InitDataProperty(0, cnt++ , dtData,    160,    daCenter,  false,    "B",   false,   "",    dfNone,   0,  true,	true,   15,   15);
				InitDataProperty(0, cnt++ , dtData,    160,    daCenter,  false,    "C",   false,   "",    dfNone,   0,  true,	true,   15,   15);
				InitDataProperty(0, cnt++ , dtData,    160,    daCenter,  false,    "D",   false,   "",    dfNone,   0,  true,	true,   15,   15);
				InitDataProperty(0, cnt++ , dtData,    100,    daCenter,  false,    "E",   false,   "",    dfNone,   0,  true,	true,   15,   15);
	
				InitDataValid(0, "A", vtEngUpOther, "1234567890");
				InitDataValid(0, "B", vtEngUpOther, "1234567890");
				InitDataValid(0, "C", vtEngUpOther, "1234567890");
				InitDataValid(0, "D", vtEngUpOther, "1234567890");
				InitDataValid(0, "E", vtEngUpOther, "1234567890");
	
			}
			break;
		}
	}
	
	/**
	 * Sheet관련 프로세스 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     doActionIBSheet(sheetObj, document.form, IBSEARCH);
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
	
		case IBSEARCH: // 화면 로딩시 AR Office & Number of copy invoice 조회
				formObj.f_cmd.value = SEARCH;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0035GS.do", FormQueryString(formObj));
				//alert(sXml);
				var sStr = ComGetEtcData(sXml,"ar_ofc_cd");
				var arrStr = sStr.split("|");
			
				MakeComboObject(formObj.ar_ofc_cd, arrStr);
				
				var arrStr2 = arrStr[1].split("^");
				var v_ar_ofc_cd = arrStr2[3];
//				alert(v_ar_ofc_cd);			        
//				alert("L : "+ComGetEtcData(sXml,"copy_cnt"));
				formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");				        
				formObj.ar_ofc_cd.text = v_ar_ofc_cd;
				
//				var sStr = ComGetEtcData(sXml,"inv_prn_dvc_nm");
//				formObj.print_nm.value = sStr;
		
			break;    
	
		case IBSEARCH_ASYNC10: // Number of copy invoice 조회
//				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
//				formObj.iss_ofc_cd.value = arrStr2[1];
//				formObj.f_cmd.value = SEARCH;
//				var sXml = sheetObj.GetSearchXml("FNS_INV_0035GS.do", FormQueryString(formObj));
//				//alert("C : "+ComGetEtcData(sXml,"copy_cnt"));	         	
//				formObj.copy_cnt.value = ComGetEtcData(sXml,"copy_cnt");
		
			break;	
	
		case IBSEARCH_ASYNC20: // invoice number 체크
				var arrStr2 = formObj.ar_ofc_cd.Code.split("^");
				formObj.iss_ofc_cd.value = arrStr2[1];
				formObj.f_cmd.value = SEARCH02;
				//alert(formObj.prev_flg.value+"::"+formObj.goto_flg.value);
				//return false;
				var sXml = sheetObj.GetSearchXml("FNS_INV_0035GS.do", FormQueryString(formObj));
				var sStr = ComGetEtcData(sXml,"r_inv_nos");
				formObj.r_invs.value = sStr;
				var sStr2 = ComGetEtcData(sXml,"cmb_flg");
				formObj.cmb_flg.value = sStr2;
				var sStr3 = ComGetEtcData(sXml,"r_if_nos");
				formObj.r_ifnos.value = sStr3;
		
			break;	
	
		case IBSAVE:        //저장
			if(validateForm(sheetObj,formObj,sAction))
				alert (" Save .. ");
		
			break;
	
		case IBINSERT:      // 입력
	
		break;
		}
	}
	
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
		var formObject = document.form;
		axon_event.addListenerFormat ('keypress', 'objKeypress', formObject);            
		axon_event.addListenerFormat('blur', 'objBlur', formObject);  
	//	axon_event.addListenerFormat('beforeactivate', 'objActivate', formObject);      
	
	}
	
	/**
	 * 업무 자바스크립트 OnKeyPress 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objKeypress();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objKeypress() {
		switch(event.srcElement.dataformat){        	    
	
		case "engup":
			switch(event.srcElement.name){
	
			case "f_inv":	
				//영문대문자+숫자 입력하기  	        
				ComKeyOnlyAlphabet('uppernum'); 
				break;		
	
			case "t_inv":	
				//영문대문자+숫자 입력하기		    	        
				ComKeyOnlyAlphabet('uppernum'); 
				break;
	
			}
	
			break;              
	
		default:
			// 숫자만입력하기
			ComKeyOnlyNumber(event.srcElement);
		}
	}         
	
	/**
	 * 업무 자바스크립트 blur 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    objBlur();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function objBlur(){
		var formObject = document.form;
		switch(event.srcElement.name){
		case "f_inv":	
			//chkInvNum(formObject.f_inv.value);
			chk_inv_per(event.srcElement);
	
			break;
	
		case "t_inv":	
			chk_inv_per(event.srcElement);
	
			break;
	
		}
	
	}
	
	/**
	 * Invoice Number 형식 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    chkInvNum(obj);
	 * </pre>
	 * @param {form} obj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function chkInvNum(obj) {        	
	
		var v_inv_no = obj.value;
		var v_inv_no_e = "";
		var v_inv_no_n = "";
		if (v_inv_no.length != 0) {
			if (v_inv_no.length != 9) {
				ComShowCodeMessage("INV00019");
				obj.focus();
				obj.value = "";
				return false;          		    
			}
//			v_inv_no_e = v_inv_no.substr(0,2);
//			v_inv_no_n = v_inv_no.substr(2,9);
//	
//			if(!ComIsAlphabet(v_inv_no_e, "u") || !ComIsNumber(v_inv_no_n) ) {
//				ComShowCodeMessage("INV00019");
//				obj.focus();
//				obj.value = "";
//				return false; 
//			}
			return true;
		}        	
	}
	
	/**
	 * Invoice Number 형식 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     chkInvNum2(sheetObj,Row,Col,Value);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row ibsheet 해당 row
	 * @param {int} Col ibsheet 해당 col
	 * @param {String} value ibsheet 해당 row, col의 값
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function chkInvNum2(sheetObj,Row,Col,Value) {        	
		var v_inv_no = Value;
		var v_inv_no_e = "";
		var v_inv_no_n = "";
		if (v_inv_no.length != 0) {
			if (v_inv_no.length != 9) {
				ComShowCodeMessage("INV00019");
				sheetObj.CellValue(Row,Col) = "";
				sheetObj.SelectCell(Row,Col);
				return false;          		    
			}
			v_inv_no_e = v_inv_no.substr(0,2);
			v_inv_no_n = v_inv_no.substr(2,9);
	
			if(!ComIsAlphabet(v_inv_no_e, "u") || !ComIsNumber(v_inv_no_n) ) {
				ComShowCodeMessage("INV00019");
				sheetObj.CellValue(Row,Col) = "";
				return false; 
			}
			return true;
		}        	
	}
	
	/**
	 * Multi 선택시 Invoice Number 범위 체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *    chk_inv_per(obj);
	 * </pre>
	 * @param {form} obj 필수 html form object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function chk_inv_per(obj) {  
		if(!chkInvNum(obj)) {
			return false;
		}
	
		var formObject = document.form;
		var v_inv_no_frm = formObject.f_inv.value;
		var v_inv_no_to = formObject.t_inv.value;
	
		if(v_inv_no_frm.length == 9 && v_inv_no_to.length == 9) {
			if(Number(v_inv_no_frm.substr(2,9)) > Number(v_inv_no_to.substr(2,9))) {
				ComShowCodeMessage("INV00020");
				formObject.t_inv.focus();
				formObject.t_inv.value = "";
				return false; 
	
			}  
			return true;
	
		}        	
	
	}
	
	/**
	 * 업무 자바스크립트 sheet1_OnChange 이벤트 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     sheet1_OnChange(sheetObj,Row,Col,Value);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Row
	 * @param {int} IBSheet의 OnChange 이벤트 발생 Col
	 * @param {String} IBSheet의 OnChange 이벤트 발생 Value
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value){        	
	
		invnoDupChk(sheetObj,Value);
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
		for (var i = 1; i < arrStr.length;i++ ) {
			var arrStr2 = arrStr[i].split("^");
			var ar_ofc_cd = arrStr2[1];
			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);
		}
		cmbObj.BackColor = "#CCFFFD";
		cmbObj.DropHeight = 190;
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
		//alert(value);
		getCopyCnt();
	}
	
	/**
	 * Number of copy invoice 조회 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     getCopyCnt();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function getCopyCnt() {
		var sheetObject = sheetObjects[0];
		var formObject = document.form;		    
		doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC10);	    	
	}
	
	/**
	 * Select Option 클릭시 처리 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     clickOption();
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */
	function clickOption() {
	
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
	
		if (formObj.sel_option[0].checked) {
			formObj.f_inv.value = "";
			formObj.t_inv.value = "";
			formObj.f_inv.readOnly = true;
			formObj.t_inv.readOnly = true;
			document.getElementById("f_inv").className = "input2";
			document.getElementById("t_inv").className = "input2";
			sheetObj.Editable = true;
			//sheetObj.SheetBackColor = sheetObj.RgbColor(255,255,255); 
			sheetObj.RemoveAll();    		 
			for(var i=0; i<20; i++){
				sheetObj.DataInsert(-1);
			}
			setColor(sheetObj, "E");
			sheetObj.SelectBackColor = sheetObj.RgbColor(231,250,246);
			sheetObj.SelectCell(1,0);
			//formObj.btn_search.disabled = false;
		} else {
			formObj.f_inv.value = "";
			formObj.t_inv.value = "";
			formObj.f_inv.readOnly = false;
			formObj.t_inv.readOnly = false;
			document.getElementById("f_inv").className = "input1";
			document.getElementById("t_inv").className = "input1";
			sheetObj.Editable = false;
			//sheetObj.SheetBackColor = sheetObj.RgbColor(232,231,236);   		 
			sheetObj.RemoveAll();    		 
			for(var i=0; i<20; i++){
				sheetObj.DataInsert(-1);
			}
			setColor(sheetObj, "D");
			sheetObj.SelectBackColor = sheetObj.RgbColor(232,231,236);
			formObj.f_inv.focus();	
			//formObj.btn_search.disabled = true;
	
		}
	
	}
	
	/**
	 * 시트 컬러 변경 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     setColor(sheetObj, key);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} key color 구분자
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function setColor(sheetObj, key){
		for (var i=1; i<=sheetObj.RowCount; i++) {
			for (var j=0; j<5; j++) {
				if (key == "E") {        			
					sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(255,255,255); 
				} else {
					sheetObj.CellBackColor(i,j) = sheetObj.RgbColor(232,231,236);             			
				}    		        		
			}               	
		}            
	} 
	
	/**
	 * Invoice Number 중복체크 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     invnoDupChk(sheetObj,Value);
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {String} value sheetObj의 해당 컬럼 value
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function invnoDupChk(sheetObj,value){
		var cnt = 0;
		for (var i=1; i<=sheetObj.RowCount; i++) {
			for (var j=0; j<5; j++) {
				if (value != "" && value == sheetObj.CellValue(i, j)) {        			
					cnt++;
					if (cnt > 1) {
						ComShowCodeMessage("INV00021");
						sheetObj.CellValue(i, j) = "";
						return;
					}
				}        		        		
			}               	
		}            
	}   
	
	/**
	 * RD Object 초기화 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     initRdConfig(rdObject)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function initRdConfig(rdObject){
		var Rdviewer = rdObject ;
		Rdviewer.style.height = 0;
		Rdviewer.style.width = 0;
	
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
	
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}
	
	/**
	 * Invoice Issue (Email) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openEmail()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function openEmail() {
		var formObject = document.form;
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		var issOfcCd = arrStr2[1];
		formObject.ar_ofc_cd2.value = arrStr2[1];	
	
//		if (issOfcCd == "SZPSC" || issOfcCd == "XMNBB" || issOfcCd == "CANBS") {
//			ComOpenWindowCenter("FNS_INV_0037.do?issueGubn=R", "pop", 1010, 700);
//		} else {

		
			ComOpenWindowCenter("FNS_INV_0034_02.do?issueGubn=SS", "pop", 1010, 700);
//		}
	}
	
	/**
	 * Invoice Search (FNS_INV_0106) 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openFnsInv0106()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function openFnsInv0106() {
		var formObject = document.form;
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		var issOfcCd = arrStr2[1];
		var selOption = "";
	
		if (formObject.sel_option[0].checked) {
	
			selOption = "S"; 	
	
		} else {
	
			selOption = "M"; 
	
		}
	
		ComOpenPopup('/hanjin/FNS_INV_0106.do?sel_option='+selOption+'&iss_ofc_cd='+issOfcCd+'&split_flg=S', 800, 475, 'getFnsInv0106', '1,0,1,1,1', false, false);
	}
	
	/**
	 * Invoice Search (FNS_INV_0106) 팝업에서 호출하는 함수 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openFnsInv0106()
	 * </pre>
	 * @param rowArray
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function getFnsInv0106(rowArray) {
		var sheetObj = sheetObjects[0];
		var invNos = "";
		for (var i=0; i<rowArray.length; i++) {
			if (invNos.indexOf(rowArray[i][2]) == -1) {
				invNos = invNos + rowArray[i][2] + "|" ;
			}
		}
	
		var arrStr = invNos.split("|");
	
		var cnt = 0;
		for (var i=1; i<=sheetObj.RowCount; i++) {
			for (var j=0; j<5; j++) {
				sheetObj.CellValue(i, j) = arrStr[cnt++];
			}
		}
	}
	
//	/**
//	 * Invoice Search (FNS_INV_0109) 화면 오픈 <br>
//	 * <br><b>Example :</b>
//	 * <pre>
//	 *     openFnsInv0109()
//	 * </pre>
//	 * @param 없음
//	 * @return 없음
//	 * @author 정휘택
//	 * @version 2009.10.20
//	 */ 
//	function openFnsInv0109() {
//		var formObject = document.form;
//		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
//		var issOfcCd = arrStr2[1];
//		var selOption = "";
//	
//		if (formObject.sel_option[0].checked) {
//	
//			selOption = "S"; 	
//	
//		} else {
//	
//			selOption = "M"; 
//	
//		}
//	
//		ComOpenPopup('/hanjin/FNS_INV_0109.do?sel_option='+selOption+'&iss_ofc_cd='+issOfcCd, 800, 440, 'getFnsInv0109', '1,0,1,1,1', false, false);
//	}
	
//	/**
//	 * Invoice Search (FNS_INV_0109) 팝업에서 호출하는 함수 SGNSC<br>
//	 * <br><b>Example :</b>
//	 * <pre>
//	 *     openFnsInv0109()
//	 * </pre>
//	 * @param rowArray
//	 * @return 없음
//	 * @author 정휘택
//	 * @version 2009.10.20
//	 */ 
//	function getFnsInv0109(rowArray) {
//		var sheetObj = sheetObjects[0];
//		var invNos = "";
//		for (var i=0; i<rowArray.length; i++) {
//			if (invNos.indexOf(rowArray[i][2]) == -1) {
//				invNos = invNos + rowArray[i][2] + "|" ;
//			}
//		}
//	
//		var arrStr = invNos.split("|");
//	
//		var cnt = 0;
//		for (var i=1; i<=sheetObj.RowCount; i++) {
//			for (var j=0; j<5; j++) {
//				sheetObj.CellValue(i, j) = arrStr[cnt++];
//			}
//		}
//	}
	
	/**
	 * Invoice Search 화면 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     openInvPopUp()
	 * </pre>
	 * @param 없음
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function openInvPopUp() {
		var formObject = document.form;
		var arrStr2 = formObject.ar_ofc_cd.Code.split("^");
		var issOfcCd = arrStr2[1];
	
		openFnsInv0106();		
	
	}
	
	/**
	 * RD File 오픈 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     rdOpen(Rdviewer, inv_no, if_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn)
	 * </pre>
	 * @param {rdviewer} rdObject Rdviewer Object
	 * @param {String} inv_no Invoice number
	 * @param {String} if_no Interface number
	 * @param {String} line_num Description lile 수 
	 * @param {String} user_nm 사용자명
	 * @param {String} ofc_cd office code
	 * @param {String} logo logo 명
	 * @param {String} vvd vvd
	 * @param {String} port_cd port code
	 * @param {String} attach letter wording 첨부 flag
	 * @param {String} paperYn print, email 구분
	 * @param {String} cmbFlg SGNSC Rd file 구분
	 * @return 없음
	 * @author 정휘택
	 * @version 2009.10.20
	 */ 
	function rdOpen(Rdviewer, inv_no, if_no, line_num, user_nm, ofc_cd, logo, vvd, port_cd, attach, paperYn, cmbFlg){
		var rdFile = "";
		var loginOfcCd = "";
		var rdParam = "";
		var issue_type = "";
			
		if (ofc_cd == "SAOSC") {
			rdFile = "FNS_INV_0544.mrd";
		}
		
		var ar_ofc_cd = ofc_cd;

		rdParam = "/rv frm1_inv_no["+inv_no+"]  frm1_ar_if_no["+if_no+"]  frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type[] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";
//		rdParam = "/rv frm1_inv_no["+inv_no+"] frm1_logo["+logo+"] frm1_login_nm ["+user_nm+"] frm1_ofc_cd ["+ofc_cd+"] frm1_line_num ["+line_num+"] frm1_vsl_cd["+vvd.substr(0,4)+"] frm1_skd_voy_no["+vvd.substr(4,4)+"] frm1_skd_dir_cd["+vvd.substr(8,1)+"] frm1_port_cd ["+port_cd+"] frm1_att_gb ["+attach+"] frm1_paper_yn ["+paperYn+"] frm1_issue_type["+issue_type+"] frm1_att_gb2[N] frm1_cust_cnt_cd[] frm1_cust_seq[]";

	
		var rdUrl = "apps/alps/fns/inv/accountreceivableinvoicemgt/invoiceissue/report/";
		// 열고자 하는 RD 파일을 지정한다.
		Rdviewer.FileOpen(RD_path + rdUrl + rdFile, RDServer + rdParam + "/rpagenuminit [1] /riprnmargin /rwait");
	}     
	
	/* 개발자 작업  끝 */