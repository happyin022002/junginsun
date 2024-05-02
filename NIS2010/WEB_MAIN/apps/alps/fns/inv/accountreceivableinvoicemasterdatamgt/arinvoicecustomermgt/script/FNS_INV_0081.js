/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0081.js
*@FileTitle : (N.China)I/B Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
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
     * @class fns_inv_0081 : fns_inv_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function fns_inv_0081() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.MakeComboObject		= MakeComboObject;
    	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
    	this.sheet2_OnPopupClick	= sheet2_OnPopupClick;
    	this.setLocCd				= setLocCd;
    	this.setLaneCd				= setLaneCd;
    	this.combo_ar_ofc_cd_OnChange	= combo_ar_ofc_cd_OnChange;
    	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
    	this.sheet1_OnChange		= sheet1_OnChange;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    	this.setVslCd				= setVslCd;
    	this.sheet2_OnChange		= sheet2_OnChange;
    	this.inputReadOnly			= inputReadOnly;
    	this.sheet1_OnAfterEdit		= sheet1_OnAfterEdit;
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
        var sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;
         
        try {
        	var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
            	case "btn_retrive":
            		if(formObject.btn_opt[0].checked) {
            			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"2");
            		} else {
            			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH,"2");
            		}
            		break;

                case "btn_new":
                	formObject.searchYn.value = "N";
                	formObject.btn_opt[0].checked = true;
                	formObject.opt_type.value = "V";
        			document.getElementById('divVsl').style.display='';
                    document.getElementById('divPod').style.display='none';
                    sheetObjects[0].RemoveAll();
                    sheetObjects[1].RemoveAll();
                    inputReadOnly("2");
                	break;
                	
                case "btn_save":
                	if(formObject.btn_opt[0].checked) {
                		doActionIBSheet(sheetObjects[0],document.form,IBSAVE,"");
                	} else {
                		doActionIBSheet(sheetObjects[1],document.form,IBSAVE,"");
                	}
                	break;
                	
                case "btn_downExcel":
                	if(formObject.btn_opt[0].checked) {
                		sheetObject1.SpeedDown2Excel(-1);
                	} else{
                		sheetObject2.SpeedDown2Excel(-1);
                	}
                	break;
                     
//                case "btn_add":
//                	if(formObject.btn_opt[0].checked) {
//                		if(formObject.searchYn.value == "N") {
//                			return;
//                		}
//                		var row = sheetObject1.DataInsert(-1);
//                		sheetObject1.CellEditable(row, "vsl_cd") = true;
//                	} else {
//                		if(formObject.searchYn.value == "N") {
//                			return;
//                		}
//                		var row = sheetObject2.DataInsert(-1);
//                		sheetObject2.CellEditable(row, "fdr_pod_cd") = true;
//                		sheetObject2.CellEditable(row, "lane_cd") = true;
//                	}
//                	break;
                	 
                case "btn_add":
                	if(formObject.btn_opt[0].checked) {
                		if(formObject.searchYn.value == "N") {
                			return;
                		}
                		var row = sheetObject1.DataInsert();
                		sheetObject1.CellEditable(row, "vsl_cd") = true;
                	} else {
                		if(formObject.searchYn.value == "N") {
                			return;
                		}
                		var row = sheetObject2.DataInsert();
                		sheetObject2.CellEditable(row, "fdr_pod_cd") = true;
                		sheetObject2.CellEditable(row, "lane_cd") = true;
                	}
                	break;

                case "btn_del":
                	if(formObject.btn_opt[0].checked) {
                		ComRowHideDelete(sheetObject1, "DelChk");
                	} else {
                		ComRowHideDelete(sheetObject2, "DelChk");
                	}
                	break;
                	
                case "btn_opt":
                	if(formObject.btn_opt[0].checked) {
                		if(formObject.btn_opt[0].value != formObject.opt_type.value) {
                			formObject.opt_type.value = "V";
                			document.getElementById('divVsl').style.display='';
                            document.getElementById('divPod').style.display='none';
                            sheetObjects[1].RemoveAll();
                            inputReadOnly("2");
                            formObject.searchYn.value = "N";
                    	}
                	} else {
                		if(formObject.btn_opt[1].value != formObject.opt_type.value) {
                			formObject.opt_type.value = "L";
                			document.getElementById('divVsl').style.display='none';
                            document.getElementById('divPod').style.display='';
                            sheetObjects[0].RemoveAll();
                            inputReadOnly("2");
                            formObject.searchYn.value = "N";
                    	}
                	}
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
                     style.height = 440;
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

                     var HeadTitle = "|Sel|Agent|Vessel|Vessel Name|Office|Customer|Vendor|Update Date|cust_cnt_cd|cust_seq|vndr_cnt_cd|vndr_seq|agn_cd1";
                     var headCount = ComCountHeadTitle(HeadTitle);
                     
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,  	true,   "ibflag");
                     InitDataProperty(0, cnt++ , dtDummyCheck,  	40,    	daCenter,  	true,   "DelChk");
//                     InitDataProperty(0, cnt++ , dtDataSeq,         40,    	daCenter,  	true,	"Seq");
                     InitDataProperty(0, cnt++ , dtCombo,    		110,    daCenter,  	true,   "agn_cd",     	true,  "", dfNone);
                     InitDataProperty(0, cnt++ , dtPopupEdit,    	110,    daCenter,  	true,   "vsl_cd",     	true,  "", dfNone, 	0, true, true, 4);
                     InitDataProperty(0, cnt++ , dtData,    		200,    daLeft,  	true,   "vsl_eng_nm",   false,  "", dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    		110,    daCenter,  	true,   "ar_ofc_cd",    false,	"",	dfNone,	0, false, false);
                     InitDataProperty(0, cnt++ , dtPopup,    		140,    daCenter,  	true,   "cust_cd",     	false,  "", dfNone);
//                     InitDataProperty(0, cnt++ , dtPopup,    		21,    	daCenter,  	true,   "cust_cd_popup",false,  "", dfNone, 0, true, true);
                     InitDataProperty(0, cnt++ , dtData,    		140,    daCenter,  	true,   "vndr_cd",     	false,  "", dfNone, 0, false, false);
                     InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	true,   "upd_dt",     	false,  "", dfDateYmd, 	0, false, false);

                     // --------------------------------------------------------
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "cust_cnt_cd",	false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "cust_seq",		false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "vndr_cnt_cd",	false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,  			30,    	daCenter,  	true,   "vndr_seq",		false,  "", dfNone);
  	                 InitDataProperty(0, cnt++, dtHidden,    		30,    	daCenter,  	true,   "agn_cd1",		false,  "", dfNone);
  	                 // --------------------------------------------------------

  	                 DataLinkMouse("vsl_cd") = true;
  	                 DataLinkMouse("cust_cd") = true;
  	                 InitDataValid(0, "vsl_cd", vtEngUpOther, "0123456789");
  	                 ShowButtonImage = 1;
         		}
              	break;

         	case 2:      //t1sheet2 init
         		with (sheetObj) {
         			//높이 설정
 	                style.height = 380;
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

 	                var HeadTitle = "|Sel|Agent|POD|Lane|Office|Customer|Vendor|Update Date|cust_cnt_cd|cust_seq|vndr_cnt_cd|vndr_seq|agn_cd1";
 	                var headCount = ComCountHeadTitle(HeadTitle);
 	                
 	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
 	
 	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
 	                InitHeadRow(0, HeadTitle, true);

 	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,    	daCenter,  	true,   "ibflag");
 	               	InitDataProperty(0, cnt++, dtDummyCheck,  	40,    	daCenter,  	true,   "DelChk");
//                   	InitDataProperty(0, cnt++, dtDataSeq,      	40,    	daCenter,  	true,   "Seq");
 	                InitDataProperty(0, cnt++, dtCombo,    		110,    daCenter,  	true,   "agn_cd",		true,  	"", dfNone);
 	                InitDataProperty(0, cnt++, dtPopupEdit,		110,    daCenter,  	true,   "fdr_pod_cd",   true,  	"", dfNone, 	0, false, false, 5);
 	                InitDataProperty(0, cnt++, dtPopupEdit,    	140,    daCenter,  	true,   "lane_cd",     	true,  	"", dfNone, 	0, false, false, 3);
 	                InitDataProperty(0, cnt++, dtData,    		110,    daCenter,  	true,	"ar_ofc_cd",    false,	"",	dfNone,		0, false, false);
 	                InitDataProperty(0, cnt++, dtPopup,    		140,    daCenter,  	true,   "cust_cd",     	false,  "", dfNone);
// 	                InitDataProperty(0, cnt++, dtPopup,    		20,    	daCenter,  	true,   "cust_cd_popup",false,  "", dfNone);
 	                InitDataProperty(0, cnt++, dtData,    		140,    daCenter,  	true,   "vndr_cd",     	false,  "", dfNone, 	0, false, false);
 	                InitDataProperty(0, cnt++, dtData,    		80,    	daCenter,  	true,   "upd_dt",     	false,  "", dfDateYmd,	0, false, false);
 	                
 	                // --------------------------------------------------------
 	                InitDataProperty(0, cnt++, dtHidden,    	30,    	daCenter,  	true,   "cust_cnt_cd",	false,  "", dfNone);
 	                InitDataProperty(0, cnt++, dtHidden,    	30,    	daCenter,  	true,   "cust_seq",		false,  "", dfNone);
 	                InitDataProperty(0, cnt++, dtHidden,    	30,    	daCenter,  	true,   "vndr_cnt_cd",	false,  "", dfNone);
 	                InitDataProperty(0, cnt++, dtHidden,    	30,    	daCenter,  	true,   "vndr_seq",		false,  "", dfNone);
 	                InitDataProperty(0, cnt++, dtHidden,    	30,    	daCenter,  	true,   "agn_cd1",		false,  "", dfNone);
 	                // --------------------------------------------------------

 	                //InitDataValid(0, "fdr_pod_cd", vtEngUpOnly);
 	                InitDataValid(0, "fdr_pod_cd", vtEngUpOther, "0123456789");
	                InitDataValid(0, "lane_cd", vtEngUpOther, "0123456789");
 	                DataLinkMouse("fdr_pod_cd") = true;
					DataLinkMouse("lane_cd") = true;
					DataLinkMouse("cust_cd") = true;
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
		 			formObj.f_cmd.value = SEARCH01;
		 			sheetObj.DoSearch("FNS_INV_0081GS.do", FormQueryString(formObj));
		 			inputReadOnly("1");
		 			formObj.searchYn.value = "Y";
		 		} else if(flag == "3") {
			 		formObj.f_cmd.value = SEARCH06;
			 		var param = FormQueryString(formObj) + "&vvd=" + sheetObj.CellValue(row, "vsl_cd");
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", param);
					var vslEngNm = ComGetEtcData(sXml, "vsl_eng_nm");
					if(typeof vslEngNm != "undefined" && vslEngNm != "" ) {
						sheetObj.CellValue2(row, "vsl_eng_nm") = vslEngNm;
					} else {
						ComShowCodeMessage("INV00041", "Vessel");
						sheetObj.CellValue2(row, "vsl_eng_nm") = "";
						sheetObj.CellValue2(row, "vsl_cd") = "";
						sheetObj.SelectCell(row, "vsl_cd");
					}
        		} else if(flag == "4") {
					formObj.f_cmd.value = SEARCH02;
					var param = FormQueryString(formObj) + "&cdTp=LOCATION&cd=" + sheetObj.CellValue(row, "fdr_pod_cd");
					var sXml = sheetObj.GetSearchXml("FNS_INV_0102GS.do", param);
					var arrXml = sXml.split("|$$|");
					var portCd = ComGetEtcData(arrXml[0], "hjsCode");
					if(typeof portCd == "undefined" || portCd == "" ) {
						ComShowCodeMessage("INV00041", "Port");
						sheetObj.CellValue2(row, "fdr_pod_cd") = "";
						sheetObj.SelectCell(row, "fdr_pod_cd");
					} else {
						var targetLaneCd = sheetObj.CellValue(row, "lane_cd");
						if(targetLaneCd != "") {
						    for(var i=1; i<sheetObj.RowCount; i++) {
						    	if(sheetObj.CellValue(i, "ibflag") != "D") {
						    		var fdrPodCd = sheetObj.CellValue(i, "fdr_pod_cd");
						    		var laneCd = sheetObj.CellValue(i, "lane_cd");
						    		if((fdrPodCd+laneCd) == (portCd+targetLaneCd)) {
						    			ComShowCodeMessage("INV00052");
						    			sheetObj.CellValue2(row, "fdr_pod_cd") = "";
										sheetObj.SelectCell(row, "fdr_pod_cd");
										return;
									}
						    	}
						    }
						}
					}
		 		} else if(flag == "5") {
					formObj.f_cmd.value = SEARCH14;
					var param = FormQueryString(formObj) + "&lane=" + sheetObj.CellValue(row, "lane_cd");
					var sXml = sheetObj.GetSearchXml("INVCommonGS.do", param);
					var arrXml = sXml.split("|$$|");
					var laneCd = ComGetEtcData(arrXml[0], "lane");
					if(typeof laneCd == "undefined" || laneCd == "" ) {
						ComShowCodeMessage("INV00041", "Lane");
						sheetObj.CellValue2(row, "lane_cd") = "";
						sheetObj.SelectCell(row, "lane_cd");
					} else {
						var targetFdrPodCd = sheetObj.CellValue(row, "fdr_pod_cd");
						var targetLaneCd = sheetObj.CellValue(row, "lane_cd");
						if(targetFdrPodCd != "") {
							for(var i=1; i<sheetObj.RowCount; i++) {
							    if(sheetObj.CellValue(i, "ibflag") != "D") {
									var fdrPodCd = sheetObj.CellValue(i, "fdr_pod_cd");
									var laneCd = sheetObj.CellValue(i, "lane_cd");
									if((row != i) && ((fdrPodCd+laneCd) == (targetFdrPodCd+targetLaneCd))) {
										ComShowCodeMessage("INV00052");
										sheetObj.CellValue2(row, "lane_cd") = "";
										sheetObj.SelectCell(row, "lane_cd");
										return;
									}
								}
							}
						}
					}
		 		}
            	break;
            	
	 		case IBROWSEARCH:
	 			formObj.f_cmd.value = SEARCH;
	 			var sXml = sheetObj.GetSearchXml("FNS_INV_0081GS.do" , FormQueryString(formObj));
	 			var agnText = ComGetEtcData(sXml, "agn_text");
	 			var agnCd = ComGetEtcData(sXml, "agn_cd");
				if(typeof agnCd != "undefined" && agnCd != "" ) {
					var arrXml = agnCd.split("|");
					sheetObjects[0].InitDataCombo(0, "agn_cd", " " + agnText, " " + agnCd);
					sheetObjects[1].InitDataCombo(0, "agn_cd", " " + agnText, " " + agnCd);
				} else {
					ComShowCodeMessage("INV00115");
				}
	 			break;

	 		case IBSAVE:        //저장
	 			formObj.f_cmd.value = MULTI;
	 			if(sheetObj.GetSaveString() == "") {
	 				return;
	 			}
	 			var param = FormQueryString(formObj) + "&" + ComSetPrifix(sheetObj.GetSaveString(), "sheet_");
	 			if(sheetObj.DoSave("FNS_INV_0081GS.do", param)) {
	 				doActionIBSheet(sheetObj,document.form,IBSEARCH,"2");
	 			}
 			 	break;

	 		case IBINSERT:      // 입력
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
     * Sheet1에서 팝업을 클릭시 vessel팝업창을 띄운다.<br>
     * 
     * @param {object} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @return 없음
     */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var classId = "";
    	var param = "";
    	with(sheetObj) {
    		var sName = ColSaveName(Col);
    		if(sName == "vsl_cd") {
	    		classId = "COM_ENS_0A1";
	    		var vslCd = CellValue(Row, "vsl_cd");
	    		var param = "?vsl_cd=" + vslCd + "&classId=" + classId;
	    		ComOpenPopup("COM_ENS_0A1.do"+param, 620, 420, "setVslCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "com_ens_0A1");
    		} else if(sName == "cust_cd") {
    			classId = "FNS_INV_0013";
    			var custCntCd = CellValue(Row, "cust_cnt_cd");
    			var custSeq = CellValue(Row, "cust_seq");
    			var param = "?cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq + "&pop_yn=Y&classId=" + classId;
    			ComOpenPopup("FNS_INV_0013.do"+param, 900, 575, "", "1,0,1,1,1,1", false, false, Row, Col, 0, "fns_inv_0013");
    		}
    	}
    }

    /**
     * Sheet2에서 팝업을 클릭시 fdr_pod_cd와 lane_cd팝업창을 띄운다.<br>
     * 
     * @param {object} sheetObj
     * @param {int} Row
     * @param {int} Col
     * @return 없음
     */
    function sheet2_OnPopupClick(sheetObj, Row, Col) {
    	with(sheetObj) {
 			var sName = ColSaveName(Col);
 			var param = "";
 			var classId = "";
 			
 			if(sName == "fdr_pod_cd") {
 				classId = "COM_ENS_051";
 				var locCd = CellValue(Row, "fdr_pod_cd");
 				param = "?loc_eq_ofc=N&loc_cd=" + locCd + "&classId=" + classId;
 				ComOpenPopup("COM_ENS_051.do"+param, 770, 400, "setLocCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "com_ens_051");
 			} else if (sName == "lane_cd") {
 				classId = "COM_ENS_081";
 				var laneCd = CellValue(Row, "lane_cd");
 				param = "?mode=svc&lane_cd=" + laneCd + "&classId=" + classId;
 				ComOpenPopup("COM_ENS_081.do"+param, 770, 420, "setLaneCd", "1,0,1,1,1,1", false, false, Row, Col, 0, "com_ens_081");
 			} else if(sName == "cust_cd") {
    			classId = "FNS_INV_0013";
    			var custCntCd = CellValue(Row, "cust_cnt_cd");
    			var custSeq = CellValue(Row, "cust_seq");
    			var param = "?cust_cnt_cd=" + custCntCd + "&cust_seq=" + custSeq + "&pop_yn=Y&classId=" + classId;
    			ComOpenPopup("FNS_INV_0013.do"+param, 900, 575, "", "1,0,1,1,1,1", false, false, Row, Col, 0, "fns_inv_0013");
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
		var targetLaneCd = sheetObjects[1].CellValue(Row, "lane_cd");
		if(targetLaneCd != "") {
		    for(var i=1; i<sheetObjects[1].RowCount; i++) {
		    	if(sheetObjects[1].CellValue(i, "ibflag") != "D") {
		    		var fdrPodCd = sheetObjects[1].CellValue(i, "fdr_pod_cd");
		    		var laneCd = sheetObjects[1].CellValue(i, "lane_cd");
		    		if((fdrPodCd+laneCd) == (aryPopupData[0][3]+targetLaneCd)) {
		    			ComShowCodeMessage("INV00052");
						return;
					}
		    	}
		    }
		}
	    
	    sheetObjects[1].CellValue2(Row, "fdr_pod_cd") = aryPopupData[0][3];
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
	function setLaneCd(aryPopupData, Row, Col, sheetIdx){
		var targetFdrPodCd = sheetObjects[1].CellValue(Row, "fdr_pod_cd");
		if(targetFdrPodCd != "") {
			for(var i=1; i<sheetObjects[1].RowCount; i++) {
			    if(sheetObjects[1].CellValue(i, "ibflag") != "D") {
					var fdrPodCd = sheetObjects[1].CellValue(i, "fdr_pod_cd");
					var laneCd = sheetObjects[1].CellValue(i, "lane_cd");
					if((fdrPodCd+laneCd) == (targetFdrPodCd+aryPopupData[0][3])) {
						ComShowCodeMessage("INV00052");
						return;
					}
				}
			}
		}

		sheetObjects[1].CellValue2(Row, "lane_cd") = aryPopupData[0][3];
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
		if(form.btn_opt[0].checked) {
			sheetObjects[0].RemoveAll();
		} else {
			sheetObjects[1].RemoveAll();
		}
		inputReadOnly("2");
		var arOfcCd = value.split("^")[1];
		var arCtrlOfcCd = value.split("^")[5];
		form.ar_ofc_cd.value= arOfcCd;
		form.ar_ctrl_ofc_cd.value = arCtrlOfcCd;
		doActionIBSheet(sheetObjects[0],document.form,IBROWSEARCH,"");
	}

	/**
	 * Sheet1의 조회된 Agent Code로 설정한다.<br>
	 * 
	 * @param {object} sheetObj
	 * @param {string} ErrMsg
     * @return 없음
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		for(var i=1; i<sheetObj.RowCount; i++) {
			sheetObj.CellValue2(i, "agn_cd") = sheetObj.CellValue(i, "agn_cd1");
			//sheetObj.CellValue2(i, "ibflag") = "";
			sheetObj.RowStatus(i) = "";
		}
		sheetObj.ColBackColor("cust_cd") = sheetObj.RgbColor(240,240,240);
	}

	/**
	 * 조회된 Agent Code로 설정한다.<br>
	 * 
	 * @param {object} sheetObj
	 * @param {int} Row
	 * @param {int} Col
	 * @param {string} value
     * @return 없음
     */
	function sheet1_OnChange(sheetObj, Row, Col, value) {
		if(Col == sheetObj.SaveNameCol("agn_cd")) {
			if(value == '') {
				sheetObj.CellValue2(Row, "ar_ofc_cd") = "";
				sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
				sheetObj.CellValue2(Row, "cust_seq") = "";
				sheetObj.CellValue2(Row, "vndr_cnt_cd") = "";
				sheetObj.CellValue2(Row, "vndr_seq") = "";
				sheetObj.CellValue2(Row, "cust_cd") = "";
				sheetObj.CellValue2(Row, "vndr_cd") = "";
			} else {
				var arOfcCd = value.split("^")[1];
				var custCntCd = value.split("^")[3];
				var custSeq = value.split("^")[4];
				var vndrCntCd = value.split("^")[5];
				var vndrSeq = value.split("^")[6];
		
				sheetObj.CellValue2(Row, "ar_ofc_cd") = arOfcCd;
				sheetObj.CellValue2(Row, "cust_cnt_cd") = custCntCd;
				sheetObj.CellValue2(Row, "cust_seq") = custSeq;
				sheetObj.CellValue2(Row, "vndr_cnt_cd") = vndrCntCd;
				sheetObj.CellValue2(Row, "vndr_seq") = vndrSeq;
				sheetObj.CellValue2(Row, "cust_cd") = custCntCd + "-" + custSeq;
				sheetObj.CellValue2(Row, "vndr_cd") = vndrCntCd + "-" + vndrSeq;
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
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	for(var i=1; i<sheetObj.RowCount; i++) {
    		sheetObj.CellValue2(i, "agn_cd") = sheetObj.CellValue(i, "agn_cd1");
    		sheetObj.CellValue2(i, "ibflag") = "";
    		sheetObj.RowStatus(i) = "";
    	}
    	sheetObj.ColBackColor("cust_cd") = sheetObj.RgbColor(240,240,240);
    }

    /**
	 * Owner 팝업창에서 선택한 Vssel Code Sheet에 설정한다.<br>
	 *
	 * @param {arry} aryPopupData
	 * @param {int} Row
	 * @param {int} Col
	 * @param {int} sheetIdx
	 * @return 없음
	 */
	function setVslCd(aryPopupData, Row, Col, sheetIdx) {
		for(var i=1; i<sheetObjects[0].RowCount; i++) {
			if(sheetObjects[0].CellValue(i, "ibflag") != "D") {
				if(sheetObjects[0].CellValue(i, "vsl_cd") == aryPopupData[0][3]) {
					ComShowCodeMessage("INV00052");
					return;
				}
			}
		}

		sheetObjects[0].CellValue2(Row, "vsl_cd") = aryPopupData[0][3];
		sheetObjects[0].CellValue2(Row, "vsl_eng_nm") = aryPopupData[0][4];
	}
	 
	/**
	 * 조회된 Agent Code로 설정한다.<br>
	 * 
	 * @param {object} sheetObj
	 * @param {int} Row
	 * @param {int} Col
	 * @param {string} value
     * @return 없음
     */
	function sheet2_OnChange(sheetObj, Row, Col, value) {
		if(Col == sheetObj.SaveNameCol("agn_cd")) {
			if(value == '') {
				sheetObj.CellValue2(Row, "ar_ofc_cd") = "";
				sheetObj.CellValue2(Row, "cust_cnt_cd") = "";
				sheetObj.CellValue2(Row, "cust_seq") = "";
				sheetObj.CellValue2(Row, "vndr_cnt_cd") = "";
				sheetObj.CellValue2(Row, "vndr_seq") = "";
				sheetObj.CellValue2(Row, "cust_cd") = "";
				sheetObj.CellValue2(Row, "vndr_cd") = "";
			} else {
				var arOfcCd = value.split("^")[1];
				var custCntCd = value.split("^")[3];
				var custSeq = value.split("^")[4];
				var vndrCntCd = value.split("^")[5];
				var vndrSeq = value.split("^")[6];
	
				sheetObj.CellValue2(Row, "ar_ofc_cd") = arOfcCd;
				sheetObj.CellValue2(Row, "cust_cnt_cd") = custCntCd;
				sheetObj.CellValue2(Row, "cust_seq") = custSeq;
				sheetObj.CellValue2(Row, "vndr_cnt_cd") = vndrCntCd;
				sheetObj.CellValue2(Row, "vndr_seq") = vndrSeq;
				sheetObj.CellValue2(Row, "cust_cd") = custCntCd + "-" + custSeq;
				sheetObj.CellValue2(Row, "vndr_cd") = vndrCntCd + "-" + vndrSeq;
			}
		}
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
	 * Vessel Code입력시 Vessel Name을 가져온다.<br>
	 * 
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return 없음
	 */
	function sheet1_OnAfterEdit(sheetObj,row,col) {
		 if(col == sheetObj.SaveNameCol("vsl_cd")) {
			 var vslCd = sheetObj.CellValue(row, "vsl_cd");
			 if(vslCd.length == 4) {
				 doActionIBSheet(sheetObj,document.form,IBSEARCH,"3",row,col);
			 } else if(vslCd != '') {
				 ComShowCodeMessage("INV00041", "Vessel");
				 sheetObj.CellValue2(row, "vsl_eng_nm") = "";
				 sheetObj.CellValue2(row, "vsl_cd") = "";
				 sheetObj.SelectCell(row, "vsl_cd");
			 } else {
				 sheetObj.CellValue2(row, "vsl_eng_nm") = "";
			 }
		 }
	}
	 
	/**
	 * Port와 Lane의 Validation을 체크한다.<br>
	 * 
	 * @param sheetObj
	 * @param row
	 * @param col
	 * @return 없음
	 */
	function sheet2_OnAfterEdit(sheetObj,row,col) {
		if(col == sheetObj.SaveNameCol("fdr_pod_cd")) {
	    	var portCd = sheetObj.CellValue(row, "fdr_pod_cd");
	    	if(portCd.length > 0 && portCd.length < 5) {
	    		ComShowCodeMessage("INV00041", "POD");
	    		sheetObj.CellValue2(row, "fdr_pod_cd")  = "";
	    		sheetObj.SelectCell(row, "fdr_pod_cd");
	    	} else if(portCd.length == 5) {
	    		doActionIBSheet(sheetObj, document.form, IBSEARCH, "4", row, col);
	    	}
	    } else if(col == sheetObj.SaveNameCol("lane_cd")) {
	    	var portCd = sheetObj.CellValue(row, "lane_cd");
	    	if(portCd.length > 0 && portCd.length < 3) {
	    		ComShowCodeMessage("INV00041", "Lane");
	    		sheetObj.CellValue2(row, "lane_cd")  = "";
	    		sheetObj.SelectCell(row, "lane_cd");
	    	} else if(portCd.length == 3) {
	    		doActionIBSheet(sheetObj, document.form, IBSEARCH, "5", row, col);
	    	}
	    }
	}