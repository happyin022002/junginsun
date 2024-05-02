/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : EES_DOD_0009.js
*@FileTitle : DOD Collection Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-10
*@LastModifier : Wonki Eo
*@LastVersion : 1.0
* 2015-11-04 Wonki EO
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class EES_DOD_0009 : 예)DOD Summary by Office  
	 */
	function EES_DOD_0009() {
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
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수 
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;

	
	var ROWMARK = "|";		// port code 
	var FIELDMARK = ",";	// port code
	
	var timer = null;
	var sheetNum = null;
	
	var sPeriod = "";
	var prePeriod = "";
	var isOpen = true;
	var enterSwitch = false;
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		
		 /******************************************************/
		 var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
//				init_form();
				doInit();
				
				document.getElementById("froms").setAttribute("dataformat", "ymd");
				document.getElementById("tos").setAttribute("dataformat", "ymd");
				document.getElementById("froms").setAttribute("maxLength", 8);
				document.getElementById("tos").setAttribute("maxLength", 8);
				document.getElementById("btns_calendarto").style.display = "";
				break;		
				
			case "btn_downexcel":
				sheetObject.ExcelPrint = "";
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
				break;
			case "btn_correction":
				goCorrection();
			    break;
			case "btn_detail":
				// Popup
				doProcessPopup(srcName);
                 
				//	goDetail();
			    break;
			case "btn_customer":
				goCustomer();
			    break;    
			    
			// Edit Point
			/*case "btns_calendarfm":
				var cal = new ComCalendar();
				cal.setDisplayType('date');
				cal.select(formObject.froms, 'yyyy-MM-dd');
				break;*/
			case "btns_calendarto":
				var cal = new ComCalendarFromTo();
				//cal.setEndFunction("nextFocusOut");
				cal.select(formObject.froms, formObject.tos, 'yyyy-MM-dd');
				break;
				
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				errMsg = ComGetMsg("COM12111" );
				ComShowMessage(errMsg);
			} else {
				ComShowMessage(e);
			}
		}
	}	
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	/**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
    	comboObjects[comboCnt++] = combo_obj;
    }

	 
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {
		formObj = document.form;
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
			comboObjects[k].DropHeight = 600; //Combo 리스트에 나오는 라인 수 조정
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
		axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- 포커스 나갈때
		axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); //- 포커스 들어갈때
  		axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		axon_event.addListenerForm  ( 'change' , 'obj_change' , document.form );
		//Edit Point
		axon_event.addListener('click', 'ofc_flg_click', 'ofc_flg');

		axon_event.addListener('keydown', 'ComKeyEnter', 'form');	
		axon_event.addListenerForm('click', 'obj_click', document.form);
		axon_event.addListenerFormat('keypress', 'obj_keypress', document.form);
		axon_event.addListenerForm('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
		axon_event.addListenerForm('blur', 'obj_deactivate', document.form); //- form OnBeforeDeactivate이벤트에 코드 처리
		axon_event.addListenerFormat('keyup', 'form_keyup', document.form);
		//
		

  	}
  	
	function doInit() {
		var formObj = document.form;
		
		ComResetAll();
		
		// DEM/DET Office 검색 조건 초기화 (Default: RHQ)
		ofc_flg_click();
	}
  	
		
		// IBSeet내의 데이터 영역의 셀을 마우스로 클릭했을 때 발생하는 Event
	 	function sheet1_OnClick(sheetObj, Row, Col, Value) {
	        with(sheetObj) {
	            if (ColSaveName(Col) == "chk") {
	            	//Check box 클릭시  AllCheck box 상태 동기화 처리, ComSyncAllCheck(sheetObj, Col, Value);
	            	var cnt = SearchRows - CheckedRows("chk");
	            	if (cnt == 0) {
	            		HeadCheck(0, "chk") = false;
	                    HeadCheck(1, "chk") = false;
	                } else if(cnt == 1 && Value == '0') {
		            	HeadCheck(0, "chk") = true;
	                    HeadCheck(1, "chk") = true;
	                }
	            }
	        }
	 	}
		
		// Detail 팝업 처리
		function doProcessPopup(srcName) {
	   		var sheetObj = sheetObjects[0];
	   		var formObj = document.form;
	   		var sUrl = '';
	   		var iWidth	= '';
	   		var iHeight = '';
	   		
	   		with(sheetObj) {
	 	  		switch(srcName) {
	 	  			case 'btn_detail':
	 	  				
	 	  				if(CheckedRows("chk") == 0) {
	             			ComShowCodeMessage('COM12114', '');
	             			return;
	             		}
	             		
	             		var chkCnt = 0;
	             		var chkRows = FindCheckedRow("chk").split("|");
	             		
	             		var chkDelCd = '';
	             		var item_list = '';
	             		
	             		var detail_ar_if = '';
	             		var detail_cust_cd = '';
	             		
	             		var detail_from = '';           		
	             		var detail_to = '';
      		
	             		var detail_period = '';
	             		
	             		var detail_curr_cd ='';
	             		
	             		for(var i=0; i < chkRows.length-1; i++) {
	             	
	             			item_list += CellValue(chkRows[i], "tro_ib_cfm_ofc_cd") ;
	             			item_list += CellValue(chkRows[i], "loc_cd") ; 
	             			item_list += CellValue(chkRows[i], "cntr_tpsz_cd") ;
//	             			item_list += CellValue(chkRows[i], "curr_cd") ;
	             			item_list += ",";
	             			
	             			if(comboObjects[1].text == "ALL") {
	             				detail_ar_if = "A"
	             			}else {
	             				detail_ar_if = comboObjects[1].text;
	             			}
	             			
	             			detail_cust_cd = formObj.s_cust_cd.value;
	             			
	             			detail_from = document.getElementById("from").value;
	             			detail_to = document.getElementById("to").value;
	             			             			            			
	             			detail_period =  formObj.period.value;
	             			
//	             			detail_curr_cd = ComGetObjValue(formObj.curr_cd);
	             			
	                        var temp_curr_cd = ComGetObjValue(formObj.curr_cd) ;
	                        
	                        if(temp_curr_cd == 'U'){
	                     	   detail_curr_cd = "USD";
	                        }
	                        else if (temp_curr_cd == 'E'){
	                        	detail_curr_cd = "EUR";
	                        }
	                        else { 
	                        	detail_curr_cd = "LOCAL";
	                        }
	             				             			
	             			}
	             		
             			
	             		
	             		
	             		// 4개의 인수를 연결한 세트를 콤마로 구분하여 item_list라는 이름으로 전달
//	             		var paramVal =	"?item_list=" + item_list ;
	             		//var paramVal =	"?item_list=" + item_list + "&ar_if=" + detail_ar_if + "&cust_cd=" + detail_cust_cd 
	             		//				+ "&from=" + detail_from + "&to=" + detail_to + "&period=" + detail_period+ "&curr_cd=" + detail_curr_cd;
	             		//var paramVal =	"?item_list=" + item_list + "&ar_if=" + detail_ar_if + "&cust_cd=" + detail_cust_cd+ "&from=" + detail_from + "&to=" + detail_to + "&period=" + detail_period;
	             		
	             		//chkDelCd = chkDelCd.substring(1);

			 	  		 sUrl	= 'EES_DOD_0010.do';
			 	  		//post로 창을 띄우기 위해 새로 정의함
			      		 iWidth	= '1030';
			      		 iHeight	= '535';
			      		var sScroll  = 'no';
			       		var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
			    		//ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
			       		var leftpos = (screen.width - iWidth) / 2;
			    		if (leftpos < 0)
			    			leftpos = 0;
			    		var toppos = (screen.height - iHeight) / 2;
			    		if (toppos < 0)
			    			toppos = 0;
			    		var sFeatures =	"scroll:"+sScroll+";status:no;help:no;dialogWidth:" + iWidth
			    						+ "px;dialogHeight:" + iHeight + "px;dialogLeft:"
			    						+ leftpos + ";dialogTop:" + toppos;
			       		
			       		var args = new Array();
			       		args["item_list"] = item_list;
			       		
			       		args["ar_if"] = detail_ar_if;
			       		args["cust_cd"] = detail_cust_cd;
			       		args["from"] = detail_from;
			       		args["to"] = detail_to;
			       		
			       		args["period"] = detail_period;
			       		
			       		//args["curr_cd"] = detail_curr_cd;
			       		
			    		window.showModalDialog(sUrl, args,sFeatures);
			      		break;
	 	  		}
	   		}
	   		

		}
		
		function fillBlanks(n, digits) {
			 var blank = '';
			 n = n.toString();  

			 if  (n.length < digits) {  
			  for (i = 0; i < digits - n.length; i++)  
			   blank += ' ';  
			 }
			 
			 return blank + n;  
			}
		
		
	function form_keyup() {
		var obj = null;
		var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyValue != 13) {
			ComKeyEnter('lengthnextfocus');
		} else {
			obj_deactivate();
		}
	}
	
	// DEM/DET Office Radio Button 클릭 이벤트 처리
	function ofc_flg_click() {
		var formObj = document.form;
		var ofcFlg = ComGetObjValue(formObj.ofc_flg);
		var comboObj = comboObjects[0];

		if(ofcFlg == 'R') {
			// RHQ
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND01);
			ComEnableObject(formObj.chk_sub_ofc, false);
			ComClearObject(formObj.chk_sub_ofc);
			
			// RHQ 선택시 로그인 지역의  RHQ Office Code를 Default.(SELHO는 All)
			var usrRhqOfcCd = ComGetObjValue(formObj.usr_rhq_ofc_cd);
	   		if(usrRhqOfcCd == 'SELHO')
	   			usrRhqOfcCd = "All";
	   		
	   		ComSetObjValue(comboObj, usrRhqOfcCd);
		} 
		else {
			// Office
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND02);
			ComEnableObject(formObj.chk_sub_ofc, true);

		}
	}
	
	function initComboValue_s_ar_if_yn() {
		ComSetObjValue(comboObjects[1], "A");
	}
	
	// CNTR Type Combo 초기화
	function initComboValue_s_cntr_tp() {
		ComSetObjValue(comboObjects[2], "A");
	}
	
	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
   		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
	
 	/**
     * 데이터 영역의 셀을 마우스로 더블클릭했을 때 발생하는 Event
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
//    function sheet1_OnDblClick(sheetObj,Row,Col) {
//    	var sParam = Array();
//    	var formObj = document.form;
//    	
//    	var cfmOfcCd = sheetObj.CellValue(Row, "tro_ib_cfm_ofc_cd");
//    	var cntrRtnYdCd = sheetObj.CellValue(Row, "loc_cd");
//
//    	var cntrTpszCd = sheetObj.CellValue(Row, "cntr_tpsz_cd");
//    	var currCd = sheetObj.CellValue(Row, "curr_cd");
//    
//    	  	
//    	goDetailPopup(cfmOfcCd, cntrRtnYdCd, cntrTpszCd, currCd);
//    	
//		return;
//    }
 	
	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function sheet1_OnLoadFinish() {
		var formObj = document.form
		sheetObjects[0].WaitImageVisible = false;

      	
		//OPEN화면 호출
      	doInit();
      	sheetObjects[0].WaitImageVisible = true;   
	} 
 	
	function setDate() {
		var today = new Date();
		var y = today.getFullYear().toString();
		var m = (today.getMonth() + 1).toString();
		if (m.length == 1) {
			m = 0 + m;
		}
		var ym = y + '-' + m;
		document.form.froms.value = ym;
		document.form.tos.value = ym;
		var day = lastDay(y, m);
		document.form.from.value = y + m + "01";
		document.form.froms.value = y + m + "01";
		document.form.to.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");
		document.form.tos.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");

	}
	
	function chkToDateWeekBlur() {
		var period = document.form.period.value;
		var toDate = document.form.tos.value;
		var frDate = document.form.froms.value;

		var toYearDate = toDate.substring(0, 4);
		var frYearDate = frDate.substring(0, 4);
		var toMonthDate = toDate.substring(5, 7);
		var frMonthDate = frDate.substring(5, 7);
		var frDayDate = "";
		var toDayDate = "";

		if (frDate.length > 7) {
			frDayDate = frDate.substring(8, 10);
			toDayDate = toDate.substring(8, 10);

		} else {
			frDayDate = "01";
			toDayDate = lastDay(toYearDate, toMonthDate);
		}

		var frDateFull = new Date(frYearDate, frMonthDate - 1, frDayDate);
		var toDateFull = new Date(toYearDate, toMonthDate - 1, toDayDate);
		var getDiffTime = toDateFull.getTime() - frDateFull.getTime();
		var retDate = Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
		var retMonth = ((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
		var retWeek = Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
		var week = "";
		var fromTo = 52;
		
		if (period == "M") {
			/*if (retMonth >= 3) {
				if (event.srcElement.name == "tos") {
					ComShowCodeMessage("CIM29025");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}*/
		} else if (period == "W") {
			if (frYearDate == toYearDate) {
				week = eval(toMonthDate) - eval(frMonthDate) + 1;
			} else {
				betwMonth = fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
				if ((eval(toYearDate) - eval(frYearDate)) == 1) { //1년 차이일때
					week = betwMonth;
				} else {
					week = (eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
				}
			}

			/*if (week > 12) {
				if (event.srcElement.name == "tos") {
					ComShowCodeMessage("CIM29025");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}*/
		} else if (period == "D") {
			/*if (retDate >= 31) {
				if (event.srcElement.name == "tos") {
					ComShowCodeMessage("CIM29029");
					ComSetFocus(document.getElementById("tos"));
				}
				return false;
			}*/
		}
	}
	
	
	function obj_activate() {
		ComClearSeparator(event.srcElement);
		ComSetFocus(event.srcElement);
	}


	
	function obj_deactivate() {

		var f = document.getElementById("froms");
		var t = document.getElementById("tos");
		sVal1 = f.value.replace(/\/|\-|\./g, "");
		sVal2 = t.value.replace(/\/|\-|\./g, "");

		switch (event.srcElement.name) {

		case "froms":
			if (ComChkObjValid(event.srcElement, false)) {

				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1 != "" && sVal2 != "") {
						var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
						var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							//	ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1 + "01";
						document.getElementById("to").value = sVal2 + day;
					}

				} else if (f.getAttribute("dataformat") == "ymd") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {

							ComShowCodeMessage("CIM29004");
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;

						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1;
						document.getElementById("to").value = sVal2;
					}

					switch (event.srcElement.name) {
					case "froms":
						if (f.value != "" && t.value == "") {
//							t.value = ComGetDateAdd(f.value, "D", 6, "");
						}
						break;
					}
				} else { // 주별로 조회
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							ComShowCodeMessage("CIM29003");
							enterSwitch = false;
							t.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								t.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
						document.getElementById("from").value = sVal1;
						document.getElementById("to").value = sVal2;
					}
				}

			} else {
				if (f.getAttribute("dataformat") == "ym") {
					if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {

						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYMM");
						enterSwitch = false;
						event.srcElement.focus();
						event.srcElement.select();
						return false;
					}
				} else if (f.getAttribute("dataformat") == "ymd") {

					if (sVal1.length > 0 && !ComIsDate(sVal1) && event.srcElement.name == 'froms') {
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYMMDD");
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;
						return false;
					}

				} else { // 주별로 조회

					if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && event.srcElement.name == 'froms') {
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYWW");
						event.srcElement.focus();
						event.srcElement.select();
						enterSwitch = false;

						return false;
					}
				}
			}

			break;
		case "tos":
			if (ComChkObjValid(event.srcElement, false)) {

				if (t.getAttribute("dataformat") == "ym") {

					var day = lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));

					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1 + "01", sVal2 + day);
						if (flag < 1) {
							if (event.srcElement.name == "tos") {
								ComShowCodeMessage("CIM29004");
							}
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}

					document.getElementById("from").value = sVal1 + "01";
					document.getElementById("to").value = sVal2 + day;
				} else if (t.getAttribute("dataformat") == "ymd") {
					if (sVal1 != "" && sVal2 != "") {
						var flag = ComChkPeriod(sVal1, sVal2);
						if (flag < 1) {
							if (event.srcElement.name == "tos") {
								ComShowCodeMessage("CIM29004");
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}

					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;

					switch (event.srcElement.name) {
					case "froms":
						if (f.value != "" && t.value == "") {
							t.value = ComGetDateAdd(f.value, "D", 6, "");

						}
						break;
					}
				} else { // 주별로 조회
					if (sVal1 != "" && sVal2 != "") {
						if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
							if (event.srcElement.name == "tos") {
								ComShowCodeMessage("CIM29003");
							}
							enterSwitch = false;
							event.srcElement.value = "";
							t.focus();
							t.select();
							return false;
						} else {
							if (chkToDateWeekBlur() == false) {
								enterSwitch = false;
								event.srcElement.value = "";
								t.focus();
								t.select();
								return false;
							}
						}
					}
					document.getElementById("from").value = sVal1;
					document.getElementById("to").value = sVal2;
				}
				enterSwitch = true;
			} else {
				if (t.getAttribute("dataformat") == "ym") {
					if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
						enterSwitch = false;
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYMM");
						t.focus();
						t.select();
						return false;
					}
				} else if (t.getAttribute("dataformat") == "ymd") {

					if (sVal2.length > 0 && !ComIsDate(sVal2)) {
						enterSwitch = false;
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYMMDD");
						t.focus();
						t.select();
						return false;
					}

				} else { // 주별로 조회

					if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
						enterSwitch = false;
						event.srcElement.value = "";
						ComShowCodeMessage("CIM21004", "YYYYWW");
						t.focus();
						t.select();
						return false;
					}
				}
			}

			break;
		}
		return true;
	}
	
	
	function lastDay(y, m) {
		var d, d2, s = "";
		d = new Date();
		d2 = new Date(y, m, "");
		s = d2.getDate();
		return (s);
	}
	
	function setDate() {
		var today = new Date();
		var y = today.getFullYear().toString();
		var m = (today.getMonth() + 1).toString();
		if (m.length == 1) {
			m = 0 + m;
		}
		var ym = y + '-' + m;
		document.form.froms.value = ym;
		document.form.tos.value = ym;
		var day = lastDay(y, m);
		document.form.from.value = y + m + "01";
		document.form.froms.value = y + m + "01";
		document.form.to.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");
		document.form.tos.value = ComGetDateAdd(document.form.froms.value, "D", 6, "");

	}
	
	// Edit Point
	
	function doActionIBCombo(sheetObj, formObj, comboObj, formCmd) {
   	 sheetObj.ShowDebugMsg = false;
   	 sheetObj.WaitImageVisible = false;
   	 
   	 formObj.f_cmd.value = formCmd;
   	 var sXml = sheetObj.GetSearchXml("DODCommonFinderGS.do", FormQueryString(formObj));
  	
  	 switch(formCmd) {
   	 	
   	 	case COMMAND01:	// RHQ
   	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = false;
					SetColWidth("45");
					ValidChar(2);	// 영대문자만 사용
					//MaxLength = 6;
   	 		}
   	 		
   	 		var data = ComGetEtcData(sXml, "office");
   	 			
   	 			if (data != undefined && data != '') {
   	 				var comboItems = data.split("|");
					comboObj.InsertItem(0, "All", "All");
					
					for (var i = 0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(i+1, comboItems[i], comboItems[i]);		
		         	}
				}
				break;
   	 
   	 	case COMMAND02: // Office
   	 		with (comboObj) { 
	    	 		RemoveAll();
					MultiSelect = true;
					SetColWidth("95");
					ValidChar(2, 2); // 영대문자, 특수문자만 가능
   	 		}
				var data = ComGetEtcData(sXml, "OFC_CD");
				if (data != undefined && data != '') {
					var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					var idx = 0;
					
					// 로그인 Office가 멀티콤보 리스트에 없을 경우, 리스트 최상단에 추가
					if(data.indexOf(usrOfcCd) == -1) {
						comboObj.InsertItem(0, usrOfcCd, usrOfcCd);
						idx = 1;
					}
					
		    	    var comboItems = data.split("|");
		    	    for (var i=0 ; i < comboItems.length ; i++) {
		    	    	comboObj.InsertItem(idx+i, comboItems[i], comboItems[i]);
		         	}
	    	  		// 로그인 User Office를 Default로 설정
	    	  		comboObj.Code = usrOfcCd;
				}
	    	    break;
	    	    
   	 	case COMMAND03:	// Incl. Sub Office
   	 		var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
   	 	
   	 		if (subOfcCds != undefined && subOfcCds != '') {
   	 			var usrOfcCd = ComGetObjValue(formObj.usr_ofc_cd);
					
					if(comboObj.Code.indexOf(usrOfcCd) != -1 && subOfcCds.indexOf(usrOfcCd)==-1)
						subOfcCds = usrOfcCd + ',' + subOfcCds;
	    	   			
					comboObj.Code = subOfcCds;
		 		}
   	 		break;
   	 		
   	 }
	}
	
	
	function doInclSubOfc() {
		var formObj = document.form;
		var comboObj = comboObjects[0]; 
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObj.Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObj);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObj);
			doActionIBCombo(sheetObjects[0], formObj, comboObj, COMMAND03);
			
		} else {
			ComSetObjValue(comboObj, formObj.tmp_ofc_cd.value);
		}
	}
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {

			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(17);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 2, 1, 10, 100);


					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, false, true, true, false, false);
					
					var HeadTitle1 = "||Office|Location|TP/SZ|Cur.|General Tariff|General Tariff|Special Tariff|Special Tariff|Adjust Amount|Adjust Amount|Invoice Amount\n(A/R I/F)|Invoice Amount\n(A/R I/F)|Pending Amount|Pending Amount";
					var HeadTitle2 = "||Office|Location|TP/SZ|Cur.|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT|CNTR|AMT";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					
					// 컬럼 고정
					sheetObj.FrozenCols = 6;
										
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	0,		daCenter,	false,	"ibflag",				false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
					InitDataProperty(0, cnt++ , dtDummyCheck, 			 40,  daCenter, true,     "chk");
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"tro_ib_cfm_ofc_cd",		false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		80,		daCenter,	true,	"loc_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		70,		daCenter,	true,	"cntr_tpsz_cd",			false,          "",       dfNone,    0,    false,       true);
					InitDataProperty(0, cnt++, dtData,		60,		daCenter,	true,	"curr_cd",				false,          "",       dfNone,    0,    false,       true);
					
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"gen_trf_cntr",			false,          "",       dfInteger,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"gen_trf_amt",			false,          "",       dfFloat,    2,    false,       true);
					
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"spc_trf_cntr"	,		false,          "",       dfInteger,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"spc_trf_amt",			false,          "",       dfFloat,    2,    false,       true);
					
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"adj_cntr"	,		false,          "",       dfInteger,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"adj_amt",			false,          "",       dfFloat,    2,    false,       true);
														
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"inv_cntr"	,		false,          "",       dfInteger,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"inv_amt",			false,          "",       dfFloat,    2,    false,       true);

					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"pen_cntr"	,		false,          "",       dfInteger,    2,    false,       true);
					InitDataProperty(0, cnt++, dtAutoSum,		80,		daRight,	false,	"pen_amt"	,		false,          "",       dfFloat,    2,    false,       true);
					
					ColHidden('ibflag')= true;

				}
				break;
				
			case "sheet2":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10, 10);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(1, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false)

					var HeadTitle = "";
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtStatus,    50,  	daCenter, false,    "ibflag",         	false,    		"",       dfNone,    0,     true,        true,   0,  false, true,  "", false);
				}
				break;
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:		//조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
	    		sheetObj.RemoveAll();
	    		
	    		sheetObj.WaitImageVisible=false;
	    		
     			ComOpenWait(true);
     			
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("EES_DOD_0009GS.do", FormQueryString(formObj)); 		

				ComOpenWait(false);

//				formObj.f_cmd.value = SEARCHLIST01;
//    			
//    			var sXml = sheetObj.GetSearchXml("EES_DOD_0009GS.do",FormQueryString(formObj));
//    			var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
//    			
//    			if (backendJobKey.length > 0) {
//					formObj.backendjob_key.value = backendJobKey;
//					sheetObj.RequestTimeOut = 10000;
//					timer = setInterval(getBackEndJobStatus, 3000);
//					sheetNum = sheetObj;
//				}    

				break;
				
			case IBDOWNEXCEL:  //EXCEL
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}

	/**
	 * New 버튼 클릭시 화면 초기화.
	 */
//	function init_form() {
//			var formObj = document.form;
//			var sheetObj = sheetObjects[0];
//			
//			formObj.s_ofc_cd.value = loginOfcCd;
//			
//			formObj.s_eq_rtn_from_dt.value = ComGetDateAdd(null, "d", -30, "-");
//			formObj.s_eq_rtn_to_dt.value = ComGetDateAdd(null, "d", 0, "-");
//					
//			formObj.s_loc_tp_cd.selectedIndex = 1;
//			formObj.s_loc_cd.value = "";
//			
//			formObj.s_cust_cd.value = "";
//			formObj.s_cust_nm.value = "";
//			
//			formObj.s_rtn_loc.value = "";
//
//			formObj.s_curr_cd.value = "";
//			
//			formObj.dod_cntr_tp_cd.value = "";
//			
////			comboObjects[1].Code = "A";
////			comboObjects[2].Code = "A";
//
//			//Edit Point//
//			
//	}

	// Tro Date 타입 선택에 따른 변화 설정
	
	function obj_change(){
		var obj = event.srcElement;
		
			
		 if (obj.name == "period") {
				if (obj.value == "M") {

					document.getElementById("froms").setAttribute("dataformat", "ym");
					document.getElementById("tos").setAttribute("dataformat", "ym");
					document.getElementById("froms").setAttribute("maxLength", 6);
					document.getElementById("tos").setAttribute("maxLength", 6);
					document.getElementById("btns_calendarto").style.display = "none";
					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";

					isOpen = false;

				} else if (obj.value == "W") {

					document.getElementById("froms").setAttribute("dataformat", "yw");
					document.getElementById("tos").setAttribute("dataformat", "yw");
					document.getElementById("froms").setAttribute("maxLength", 6);
					document.getElementById("tos").setAttribute("maxLength", 6);
					document.getElementById("btns_calendarto").style.display = "none";

					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";
//					document.form.gubun.value = "S";
					isOpen = false;
					
				} else {

					document.getElementById("froms").setAttribute("dataformat", "ymd");
					document.getElementById("tos").setAttribute("dataformat", "ymd");
					document.getElementById("froms").setAttribute("maxLength", 8);
					document.getElementById("tos").setAttribute("maxLength", 8);
					document.getElementById("btns_calendarto").style.display = "";
					document.form.froms.value = "";
					document.form.tos.value = "";
					document.form.from.value = "";
					document.form.to.value = "";
//					document.form.gubun.value = "S";
				}
				prePeriod = obj.value;
				document.form.froms.focus();
			}
		
		 
		 
		switch(obj.name) {
		
			case "s_ofc_cd":		// OFFICE CODE VAILIDATION
				if(obj.value.trim() == ""){
					return;
				}
				var param = "f_cmd=" + SEARCH01 + "&s_value=" + obj.value;
				var sXml = sheetObjects[1].GetSaveXml("EES_DOD_VALIDGS.do", param);
				
				var count = ComGetEtcData(sXml, "count");
				var result = ComGetEtcData(sXml, "TRANS_RESULT_KEY");

				if(result == "S"){
					if(parseInt(count) == 0) {
						ComShowMessage(ComGetMsg("COM12114", "Office Code"));
						obj.value = "";
						obj.focus();
					}
				}
			break;
			
						
			case "s_cust_cd":		// Customer VAILIDATION
				if(obj.value.trim() == ""){
					document.form.s_cust_nm.value = "";
					return;
				}
				var param = "f_cmd="+SEARCH+"&cust_cd="+ obj.value.substr(0,2).toUpperCase() +"&cust="+ obj.value.substr(2);
				var sXml = sheetObjects[1].GetSearchXml("COM_ENS_041GS.do", param);
				var rtnArr = ComXml2ComboString(sXml, "cust_cd", "cust_nm");
				if(rtnArr != null && rtnArr.length > 1){
					obj.value = rtnArr[0];
					formObj.s_cust_nm.value = rtnArr[1];
				} else {
					ComShowMessage(ComGetMsg("COM12114", "Customer Code"));
					obj.value = "";
					formObj.s_cust_nm.value = "";
					obj.focus();
				}
			break;
	
			
		}		
	} 	

	
	/**
	 * HTML Control의 onfocus이벤트 처리<br>
	 **/
	function obj_focus(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_eq_rtn_from_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		case "s_eq_rtn_to_dt":
			ComClearSeparator(obj);
			obj.select();
			break;	
		}
	}
	
	/**
	 * HTML Control의 onblur이벤트 처리<br>
	 **/
	function obj_blur(){
		var obj = event.srcElement;
		switch(obj.name) {	
		case "s_eq_rtn_from_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
			break;	
		case "s_eq_rtn_to_dt":
			obj.value = ComGetMaskedValue(obj,   "ymd");
			getMonthBetween();
			break;
		}
	}
	
	function getMonthBetween() {
	}


	
	function obj_keypress(){
		
		obj = event.srcElement;
		if(obj.dataformat == null) return;
	
		window.defaultStatus = obj.dataformat;
	
		switch(obj.dataformat) {
		
		case "engup":
			switch (event.srcElement.name) {
				case "s_rtn_loc":
					//영문대문자 입력하기
					ComKeyOnlyAlphabet('uppernum');
					break;					

			}
			break;
		
			case "ym": case "ymd":
				ComKeyOnlyNumber(obj);
				break;
			
	        case "int":
	            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;	
			case "eng":
				ComKeyOnlyAlphabet(); 
				break;
			case "engup":
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "engdn":
				if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
				else ComKeyOnlyAlphabet('lower');
				break;
			case "uppernum":
				ComKeyOnlyAlphabet('uppernum');
				break;
			
			// Edit Point //
			case "froms":
				// 숫자만 + "-"만 입력허용
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "tos":
				// 숫자만 + "-"만 입력허용
				ComKeyOnlyNumber(event.srcElement);
				break;
			// Edit Point //
				
		}
	}
	
	

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
	
		with (formObj) {
		
		switch(sAction) {
			case IBSEARCH:
				// TRO Date Length Validation
				if (period.value == "M") {
					if (froms.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(froms);
						return false;
					}
					if (tos.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(tos);
						return false;
					}
					if (froms.value.length < 6) {
						return false;
					} else if (tos.value.length < 6) {
						return false;
					}

				} else if (period.value == "W") {
					if (froms.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(froms);
						return false;
					}
					if (tos.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(tos);
						return false;
					}
					if (froms.value.length < 6) {
						return false;
					} else if (tos.value.length < 6) {
						return false;
					}

				} else if (period.value == "D") {
					if (froms.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(froms);
						return false;
					}
					if (tos.value == "") {
						ComShowMessage(ComGetMsg("DOD00011"));
						ComSetFocus(tos);
						return false;
					}
					if (froms.value.length < 8) {
						return false;
					} else if (tos.value.length < 8) {
						return false;
					}

				}
				

				
				// DOD Office Validate & Parameter Sending 
                var ofcCd = comboObjects[0].text;
                formObj.ofc_cd.value = ofcCd;
                if(ComIsEmpty(ofcCd)) {
                	ComShowCodeMessage('COM12113', "DOD Office");
         			return false;
                }
                // ComSetObjValue(ofc_cd, ofcCd);
                

               //  Currency Code Sending
               var temp_curr_cd = ComGetObjValue(formObj.curr_cd) ;
               
               if(temp_curr_cd == 'U'){
            	   formObj.s_curr_cd.value = "USD";
               }
               else if (temp_curr_cd == 'E'){
            	   formObj.s_curr_cd.value = "EUR";
               }
               else { 
              		formObj.s_curr_cd.value = "LOCAL";
               }
                                    
                
                // Return Location Empty Validation
//				if(formObj.s_rtn_loc.value == ""){
//					ComShowMessage(ComGetMsg("COM130201", "Location"));
//					formObj.s_loc.focus();
//					return false;
//				}
				
	            
				// Container Type Send
                var cntrType = comboObjects[2].Code;
                               
                // 전체선택이면, 전송할 Code값을 'A'로 설정. 나머지 경우는 그대로 보냄.(DBDAO 내부로직 필요상)
                if(cntrType == 'A'){
                	cntrType = "D,R,S";
                	formObj.dod_cntr_tp_cd.value = cntrType;
//                  ComSetObjValue(dod_cntr_tp_cd, cntrType);

                }
                else {
                	formObj.dod_cntr_tp_cd.value = cntrType;
                	
                }

			break;
		}
	}
		return true;
	}
	
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "s_ar_if_yn":
				with (comboObj) { 
			    	comboObj.InsertItem(0, "ALL", "A");
			    	comboObj.InsertItem(1, "Y", "Y");  
			    	comboObj.InsertItem(2, "N", "N");
//		    		comboObj.Code2 = "A";
				}
			break;
			
			case "s_cntr_tp":
				with (comboObj) { 
			    	comboObj.InsertItem(0, "ALL", "A");
			    	comboObj.InsertItem(1, "Dry", "D");  
			    	comboObj.InsertItem(2, "Reefer", "R");
			    	comboObj.InsertItem(3, "Special", "S");
//		    		comboObj.Code2 = "A";
				}
			break;
			
		}
	}

 

	/**
	 * Customer popup
	 */
	function goCustomer(){
		ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustomer", "1,0,1,1,1,1,1", true);
	}
	
    /*
  	 * Customer 공통팝업에서 선택한 Customer Code값을 해당 필드에 설정 
  	 */
    function getCustomer(aryPopupData) {
    	document.form.s_cust_cd.value = aryPopupData[0][3];
    	document.form.s_cust_nm.value = aryPopupData[0][4];
    }


    
	/**
	 * BackEndJob 관련 Status='3' 이 될때까지 확인한다.
	 */
	function getBackEndJobStatus() {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sXml = sheetNum.GetSearchXml("EES_DOD_0009GS.do", FormQueryString(formObj));
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		if (jobState == "3") {
			getBackEndJobLoadFile();
			clearInterval(timer);
		} else if (jobState == "4") {
			ComShowCodeMessage("DOD10001");
			ComOpenWait(false);
			sheetNum.WaitImageVisible = true;
			clearInterval(timer);
		} else if (jobState == "5") {
			ComShowCodeMessage("DOD10002");
			clearInterval(timer);
		}
	}
	
	/**
	 * BackEndJob의 결과가 완료되면 Excel파일로 내려받음
	 */
	function getBackEndJobLoadFile() {
		var formObj = document.form;
		
		formObj.f_cmd.value = SEARCH03;
		ComOpenWait(false);
		var sXml = sheetNum.GetSearchXml("EES_DOD_0009GS.do", FormQueryString(form));
		sheetNum.LoadSearchXml(sXml);
	}