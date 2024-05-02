/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0082.js
*@FileTitle :  (Brazil) Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.09 최우석
* 1.0 Creation
 * -------------------------------------------------------- 
 * History
 * 2011.04.13 최도순 [CHM-201109279-01] Split 01-ALPS의 Location 조회불가건 수정 보완 요청.
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
     * @class fns_inv_0082 : fns_inv_0082 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0082() {
    	this.processButtonClick			= tprocessButtonClick;
    	this.setSheetObject 			= setSheetObject;
    	this.loadPage 					= loadPage;
    	this.initSheet 					= initSheet;
    	this.doActionIBSheet 			= doActionIBSheet;
    	this.MakeComboObject			= MakeComboObject;
    	this.sheet1_OnPopupClick		= sheet1_OnPopupClick;
    	this.setLocCd					= setLocCd;
    	this.setCustCd					= setCustCd;
    	this.combo_ar_ofc_cd_OnChange	= combo_ar_ofc_cd_OnChange;
    	this.inputReadOnly				= inputReadOnly;
    	this.sheet1_OnAfterEdit			= sheet1_OnAfterEdit;
    	this.sheet1_OnSearchEnd			= sheet1_OnSearchEnd;
    }
    
    /* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러<br>
	 * 
	 * @return 없음
	 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];

        /*******************************************************/
        var formObject = document.form;
         
        try {
        	var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_retrive":
            		formObject.combo_ar_ofc_cd.Enable = false;
            		doActionIBSheet(sheetObject1,document.form,IBSEARCH,"2");
            		break;

                case "btn_new":
                	formObject.combo_ar_ofc_cd.Enable = true;
                	formObject.searchYn.value = "N";
                    sheetObject1.RemoveAll();
                    inputReadOnly("2");
                	break;
                	
                case "btn_save":
                	doActionIBSheet(sheetObject1,document.form,IBSAVE,"");
                	break;
                	
                case "btn_downExcel":
                	sheetObject1.SpeedDown2Excel(-1);
                	break;
                     
//                case "btn_add":
//            		if(formObject.searchYn.value == "N") {
//            			return;
//            		}
//            		var row = sheetObject1.DataInsert(-1);
//            		sheetObject1.CellValue2(row, "ar_ofc_cd") = formObject.ar_ofc_cd.value;
//            		sheetObject1.CellValue2(row, "rep_cust_bar") = "-";
//                	break;
                	 
                case "btn_add":
            		if(formObject.searchYn.value == "N") {
            			return;
            		}
            		var row = sheetObject1.DataInsert();
            		sheetObject1.CellEditable(row, "port_cd") = true;
            		sheetObject1.CellValue2(row, "ar_ofc_cd") = formObject.ar_ofc_cd.value;
            		sheetObject1.CellValue2(row, "rep_cust_bar") = "-";
                	break;

                case "btn_del":
                	ComRowHideDelete(sheetObject1, "DelChk");
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의<br>
     *
     * @param {object} sheet_obj
     * @return 없음
     */
    function setSheetObject(sheet_obj){
    	sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화<br>
     * body 태그의 onLoad 이벤트핸들러 구현<br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다<br>
     *
     * @return 없음
     */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		// khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	
    	inputReadOnly("2");
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"1");
    }

    /**
     * 시트 초기설정값, 헤더 정의<br>
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다<br>
     *
     * @param {object} sheetObj
     * @param {int} sheetNo
     * @return 없음
     * @see #loadPage
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt = 0;
    	
    	switch(sheetNo) {
         	case 1:      //t1sheet1 init
         		with (sheetObj) {
                 	// 높이 설정
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                     //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, true, true, false,false)

                     var HeadTitle = "|Sel|Bound|POR|POL|POD|DEL|Customer|Customer|Customer|Customer Name|Delete|Update Date|ar_ofc_cd|ar_agn_stl_cd|delt_flg|port_cd1";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  	true,   "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	true,   "DelChk");
//                     InitDataProperty(0, cnt++ , dtDataSeq,         40,    	daCenter,  	true,	"Seq");
//                     InitDataProperty(0, cnt++ , dtPopupEdit,    	150,    daCenter,  	true,   "port_cd",     		true,  	"", dfNone, 0, false, false, 5);
                     InitDataProperty(0, cnt++ , dtCombo,    		60,    daCenter,  	true,   "io_bnd_cd",   		true,  	"", dfNone);
                     InitDataProperty(0, cnt++ , dtData,  			80,    daCenter,  	true,   "por_cd",	false,  	"", dfNone, 0, true, true, 5);
                     InitDataProperty(0, cnt++ , dtData,  			80,    daCenter,  	true,   "pol_cd",	false,  	"", dfNone, 0, true, true, 5);
                     InitDataProperty(0, cnt++ , dtData,  			80,    daCenter,  	true,   "pod_cd",	false,  	"", dfNone, 0, true, true, 5);
                     InitDataProperty(0, cnt++ , dtData,  			80,    daCenter,  	true,   "del_cd",	false,  	"", dfNone, 0, true, true, 5);
                     
                     InitDataProperty(0, cnt++ , dtData,  			50,    daCenter,  	true,   "rep_cust_cnt_cd",	true,  	"", dfNone, 0, true, true, 2);
                     InitDataProperty(0, cnt++ , dtData,  			15,    daCenter,  	true,   "rep_cust_bar",		false,  "", dfNone, 0, false, false);
  	                 InitDataProperty(0, cnt++ , dtData,  			80,    daCenter,  	true,   "rep_cust_seq",		true,  	"", dfNone, 0, true, true, 6);
                     InitDataProperty(0, cnt++ , dtPopup,    		250,   daLeft,  	true,   "agn_nm",   		true,  	"", dfNone);
                     InitDataProperty(0, cnt++ , dtCombo,    		60,    daCenter,  	true,   "delt_flg",   		true,  	"", dfNone);
                     InitDataProperty(0, cnt++ , dtData,    		80,    daCenter,  	true,   "upd_dt",     		false,  "", dfDateYmd, 0, false, false);

                     // --------------------------------------------------------
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "ar_ofc_cd",		false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "ar_agn_stl_cd",	false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,    		30,    	daCenter,  	true,   "delt_flg",			false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,    		30,    	daCenter,  	true,   "port_cd1",			false,  "", dfNone);
  	                 // --------------------------------------------------------
  	                 
  	                 InitDataCombo(0, "io_bnd_cd", "I|O", "I|O");
  	                 InitDataCombo(0, "delt_flg", "N|Y", "N|Y");
  	                 //InitDataValid(0, "por_cd", vtEngUpOnly);
  	                 //InitDataValid(0, "pol_cd", vtEngUpOnly);
  	                 //InitDataValid(0, "pod_cd", vtEngUpOnly);
  	                 //InitDataValid(0, "del_cd", vtEngUpOnly);
  	                 InitDataValid(0, "por_cd", vtEngUpOther, "0123456789");
  	                 InitDataValid(0, "pol_cd", vtEngUpOther, "0123456789");
  	                 InitDataValid(0, "pod_cd", vtEngUpOther, "0123456789");
  	                 InitDataValid(0, "del_cd", vtEngUpOther, "0123456789");
  	           
  	                 InitDataValid(0, "rep_cust_cnt_cd", vtEngUpOnly);
  	                 InitDataValid(0, "rep_cust_seq", vtNumericOnly);
  	                 
  	                 DataLinkMouse("port_cd") = true;
  	                 DataLinkMouse("agn_nm") = true;
  	                 ShowButtonImage = 1;
         		}
              	break;
    		}
    }

    /** Sheet관련 프로세스 처리<br>
     * 
     * @param {object} sheetObj
     * @param {object} formObj
     * @param {int} sAction
     * @param {string} flag
     * @return 없음
     * @see #processButtonClick
     */
    function doActionIBSheet(sheetObj,formObj,sAction,flag,row,col) {
    	sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	 		case IBSEARCH:      //조회
		 		if(flag == "1") {
					formObj.f_cmd.value = SEARCH02;
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", FormQueryString(formObj));
					var arOfcCd = ComGetEtcData(sXml, "ar_ofc_cd");
					if(typeof arOfcCd != "undefined" && arOfcCd != "" ) {
						var arrXml = arOfcCd.split("|");
						MakeComboObject(formObj.combo_ar_ofc_cd, arrXml);
				        formObj.combo_ar_ofc_cd.text = arrXml[1].split("^")[3];
					}
		 		} else if(flag == "2") {
		 			formObj.f_cmd.value = SEARCH;
		 			sheetObj.DoSearch("FNS_INV_0082GS.do", FormQueryString(formObj));
		 			inputReadOnly("1");
		 			formObj.searchYn.value = "Y";
		 		} else if(flag == "3"){
		 			formObj.f_cmd.value = SEARCH03;
		 			var custCntCd = sheetObj.CellValue(row, "rep_cust_cnt_cd");
		 			var custSeq = sheetObj.CellValue(row, "rep_cust_seq");
		 			var param = FormQueryString(formObj) + "&cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq;
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", param);	
					var custNm = ComGetEtcData(sXml, "cust_eng_nm");
					var deltFlg = ComGetEtcData(sXml, "delt_flg");  
					if(typeof custNm != "undefined" && custNm != "" ) {
						if(deltFlg == 'Y') {
							ComShowCodeMessage("INV00060");
							sheetObj.CellValue2(row, "rep_cust_cnt_cd") = "";
							sheetObj.CellValue2(row, "rep_cust_seq") = "";
							sheetObj.CellValue2(row, "agn_nm") = "";
							sheetObj.SelectCell(row, "rep_cust_cnt_cd");							
						} else {
							sheetObj.CellValue2(row, "agn_nm") = custNm;
						}
					} else {
						sheetObj.CellValue2(row, "agn_nm") = "";
				     	var start = sXml.indexOf('<MESSAGE>');
				    	var end = sXml.indexOf('</MESSAGE>');
				    	alert(sXml.substring(start+18, end-3));
				    	sheetObj.CellValue2(row, "rep_cust_cnt_cd") = "";
						sheetObj.CellValue2(row, "rep_cust_seq") = "";
						sheetObj.CellValue2(row, "agn_nm") = "";
				    	sheetObj.SelectCell(row, "rep_cust_cnt_cd");
					}
		 		} else if(flag == "4") {
					formObj.f_cmd.value = SEARCH02;
					var param = FormQueryString(formObj) + "&cdTp=LOCATION&cd=" + sheetObj.CellValue(row, "port_cd");
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", param);
					var arrXml = sXml.split("|$$|");
					var portCd = ComGetEtcData(arrXml[0], "hjsCode");
					if(typeof portCd == "undefined" || portCd == "" ) {
						ComShowCodeMessage("INV00041", "Port");
						sheetObj.CellValue2(row, "port_cd") = "";
						sheetObj.SelectCell(row, "port_cd");
					} else {
						for(var i=1; i<sheetObj.RowCount; i++) {
							if(sheetObj.CellValue(i, "ibflag") != "D") {
								if(sheetObj.CellValue(i, "port_cd") == portCd) {
									ComShowCodeMessage("INV00052");
									sheetObj.CellValue2(row, "port_cd") = "";
									sheetObj.SelectCell(row, "port_cd");
									return;
								}
							}
						}
					}
		 		}
            	break;

	 		case IBSAVE:        //저장
	 			formObj.f_cmd.value = MULTI;
	 			if(sheetObj.GetSaveString() == "") {
	 				return;
	 			}
	 			
	 			var cnt = 0;
	 			for (idx = 1; idx < sheetObj.RowCount + 1; idx++) {
	 				
	 				if (sheetObj.CellValue(idx, "por_cd") == "" && sheetObj.CellValue(idx, "pol_cd") == ""
	 					&& sheetObj.CellValue(idx, "pod_cd") == "" && sheetObj.CellValue(idx, "del_cd") == "") {
	 					cnt++;
	 				} 				
	 				
	 			}
	 			
	 			if (cnt > 0) {
	 				ComShowCodeMessage("INV00131");
	 				return;
	 			}	 			
	 			
	 			var param = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(), "sheet_");
	 			if(sheetObj.DoSave("FNS_INV_0082GS.do", param)) {
	 				doActionIBSheet(sheetObj,document.form,IBSEARCH,"2");
	 			}
 			 	break;
        }
    }

    /**
     * 콤보박스를 설정한다.<br>
     * 
     * @param {object} cmbObj
     * @param {String} arrStr
     * @return 없음
     * @see #doActionIBSheet
     */
 	function MakeComboObject(cmbObj, arrStr) {
 		for (var i = 1; i < arrStr.length;i++ ) {
 			var arrStr2 = arrStr[i].split("^");
 			var ar_ofc_cd = arrStr2[1];
 			cmbObj.InsertItem(i-1, ar_ofc_cd, arrStr[i]);			 
 		}
 		cmbObj.DropHeight = 190;
 	}

    /**
     * Sheet1에서 팝업을 클릭시 fdr_pod_cd와 lane_cd팝업창을 띄운다.<br>
     * 
     * @param {object} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @return 없음
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	with(sheetObj) {
 			var sName = ColSaveName(Col);
 			var param = "";
 			var classId = "";
 			
 			if(sName == "port_cd") {
 				classId = "COM_ENS_051";
 				var locCd = CellValue(Row, "port_cd");
 				param = "?loc_eq_ofc=N&loc_cd=" + locCd + "&classId=COM_ENS_051";
 				ComOpenPopup("COM_ENS_051.do"+param, 770, 400, "setLocCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "com_ens_051");
 			} else if(sName == "agn_nm") {
 				var custCd = sheetObj.CellValue(Row, "rep_cust_cnt_cd");
 				var custSeq = sheetObj.CellValue(Row, "rep_cust_seq");
 				if(custCd.length != 2 && custSeq.length != 6) {
 					return;
 				} else {
	    			classId = "FNS_INV_0013";
	    			var custCntCd = CellValue(Row, "rep_cust_cnt_cd");
	    			var custSeq = CellValue(Row, "rep_cust_seq");
	    			var param = "?cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq + "&pop_yn=Y&classId=" + classId;
	    			ComOpenPopup("FNS_INV_0013.do"+param, 900, 575, "setCustCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "fns_inv_0013");
 				}
    		}
 		}
 	}

    /**
	 * Owner 팝업창에서 선택한 Location / Port Code Sheet에 설정한다.<br>
	 *
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 * @return 없음
	 */
	function setLocCd(aryPopupData, Row, Col, sheetIdx){
	    for(var i=1; i<sheetObjects[0].RowCount; i++) {
			if(sheetObjects[0].CellValue(i, "ibflag") != "D") {
				if(sheetObjects[0].CellValue(i, "port_cd") == aryPopupData[0][3]) {
					ComShowCodeMessage("INV00052");
					sheetObjects[0].CellValue2(Row, "port_cd") = "";
					sheetObjects[0].SelectCell(Row, "port_cd");
					return;
				}
			}
		}
	    sheetObjects[0].CellValue2(Row, "port_cd") = aryPopupData[0][3];
	}
	 
	/**
	 * Owner 팝업창에서 선택한 Customer Code를 Sheet에 설정한다.<br>
	 *
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 * @return 없음
	 */
	function setCustCd(aryPopupData, Row, Col, sheetIdx){
	    sheetObjects[1].CellValue2(Row, "rep_cust_cnt_cd") = aryPopupData[0][3];
	}

	/**
	 * AR Office 변경값에 따라 AR Control CD를 가져온다.<br>
	 * 
	 * @param {object} comboObj
	 * @param {string} value
	 * @param {string} text
	 * @return 없음
	 */
	function combo_ar_ofc_cd_OnChange(comboObj, value, text) {
		var arOfcCd = value.split("^")[1];
		form.ar_ofc_cd.value= arOfcCd;
	}

	/**
	 * 조건에 따라 해당 오브젝트의 사용여부를 설정한다.<br>
	 * 
	 * @param {int} flag
	 * @return 없음
	 * @see #getBatchJobStatus, #doActionIBSheet
	 */
    function inputReadOnly(flag) {
    	if(flag == 1) {
    		ComBtnEnable("btn_add");
    		ComBtnEnable("btn_ins");
    		ComBtnEnable("btn_del");
    		ComBtnEnable("btn_save");
    	} else {
    		ComBtnDisable("btn_add");
    		ComBtnDisable("btn_ins");
    		ComBtnDisable("btn_del");
    		ComBtnDisable("btn_save");
    	}
    }

	/**
	 * Customer Code와 Seq 입력시 Costomer Name을 가져온다.<br>
	 * 
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return 없음
	 */
	function sheet1_OnAfterEdit(sheetObj,row,col) {
	    if(col == sheetObj.SaveNameCol("rep_cust_cnt_cd") ||
		   col == sheetObj.SaveNameCol("rep_cust_seq")) {
			var custCd = ""; 
			var custSeq = "";
	
			custCd = sheetObj.CellValue(row, "rep_cust_cnt_cd");
			custSeq = sheetObj.CellValue(row, "rep_cust_seq");

			if(custCd.length > 0) {
				if(custCd.length != 2) {
					ComShowCodeMessage("INV00054");
					sheetObj.SelectCell(row, "rep_cust_cnt_cd");
					return;
				}
			}

	    	var tmp = "";
	        if (custSeq.length != 0 && custSeq.length < 6) {
	        	for(i = 0; i < 6 - custSeq.length; i++){
	        		tmp = tmp + "0";
	        	}
	        	custSeq = tmp + custSeq;
	    	}
	        sheetObj.CellValue2(row, "rep_cust_seq") = custSeq;

	        if((custCd.length == 2) && (custSeq.length == 6)) {
	        	doActionIBSheet(sheetObj, document.form, IBSEARCH, "3", row, col);
	        }
	    } else if(col == sheetObj.SaveNameCol("port_cd")) {
	    	var portCd = sheetObj.CellValue(row, "port_cd");
	    	if(portCd.length > 0 && portCd.length < 5) {
	    		ComShowCodeMessage("INV00041", "Port");
	    		sheetObj.CellValue2(row, "port_cd")  = "";
	    		sheetObj.SelectCell(row, "port_cd");
	    	} else if(portCd.length == 5) {
	    		doActionIBSheet(sheetObj, document.form, IBSEARCH, "4", row, col);
	    	}
	    }
	}

	/**
	 * Sheet1의 조회된 Agent Code로 설정한다.<br>
	 * 
	 * @param {object} sheetObj
	 * @param {string} ErrMsg
	 * @return 없음
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.ColBackColor("agn_nm") = sheetObj.RgbColor(240,240,240);
	}