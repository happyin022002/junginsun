/*
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESM_MAS_0072.js
 * @FileTitle : P&L by Lane
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2010.04.14
 * @LastModifier : 이중환
 * @LastVersion : 1.1
 *  2007-01-22 Kim Jong Beom
 *  1.0 최초 생성
 * =========================================================
 * History  
 * 2009.02.04 박은주 CSR.NO:N200901210014 조직개편련 기능 수정
 * 2009.02.09 박상희 N200901230003 P&L by Lane - OP 아이템명 수정 및 BKG OP 추가 
 * 2009.04.10 박은주 N200903200100 sheet1_OnSearchEnd 에서 수식 계산시 계산하에 데이터를 입력하는 경우 
 *                  ROW 값이 -1일 경우 엉뚱한 곳에 데이터가 들어가서 문제 발생 
 * 2009.04.22 박상희 N200904070094 by VVD 에서 Month -> R.Month, S.Month
 * 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
 * 2009-09-24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영) 
 * 2009.10.26 김기식 Alps전환작업 
 * 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
 * 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
 * 2010.08.24 윤진영 [CHM-201005423] RHQ 컬럼 추가
 * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
 * 2011.05.11 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
 * 2012.01.19 김종준 [CHM-201215724-01] L/F : 소수점 첫째자리까지만 존재 (둘째자리에서 반올림),나머지 모든 계정: 소숫점 존재 X (소숫점 첫째자리에서 반올림 )
 * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
 * 2012.07.10 김성훈 [CHM-201218782-01] [MAS] P&L 신규 계정 추가 - Carriers Haulage Service Charge
 * 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
 * 2012.12.13 송호진 [CHM-201221879]    [MAS] Manual Cost Set up 화면 로직 수정 * 
 * 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
 * 2013.02.21 최성민 [CHM-201323054] [MAS] Manual Cost Set up 화면 수정 - US Domestic 계정 hidden처리
 * 2013.06.12 최성민 [CHM-201324876] [MAS] MAS Report내 "IAS Region " / "Bound2" 추가
 * 2013.06.13 서미진 [CHM-201325024] 2주차씩 Creation이 되고 완료 되었을때 완료 메세지가 뜨게 수정
 * 2013.08.08 최성민 [CHM-201325911] [MAS] P&L 화면 일부 로직 수정
 * 2014.01.02 김수정 [CHM-201327858] [MAS] IAS P&L 추가
 * 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
 * 2017.07.13 김동호 [CSR 1191] P/L by Agreement TAB 추가
 * =========================================================
*/
  
/**
 * @fileoverview  
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESM_MAS_0072 : ESM_MAS_0072 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_0072() {
	this.processButtonClick = processButtonClick;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initTab = initTab;
	this.setSheetObject = setSheetObject;
	this.sheet1_OnSearchEnd = sheet1_OnSearchEnd;
	this.sheet2_OnSearchEnd = sheet2_OnSearchEnd;
	this.sheet3_OnSearchEnd = sheet3_OnSearchEnd;
	this.cobTradeOnChange = cobTradeOnChange;
	this.setPeriod = setPeriod;
	this.cobProfitVwOnChange = cobProfitVwOnChange;
	this.cobProfitLvOnChange = cobProfitLvOnChange;
	this.setCobDisplay = setCobDisplay;
	this.showText = showText;
	this.setZoom = setZoom;
	this.cobOfcLevelOnChange = cobOfcLevelOnChange;
	this.changeCostYrmon = changeCostYrmon;
	this.changeChtBiz = changeChtBiz;
	this.doActionIBSheet = doActionIBSheet;
	this.doActionIBSheet2 = doActionIBSheet2;
	this.doActionIBSheet3 = doActionIBSheet3;
	this.chkValidSearch = chkValidSearch;
	this.validateForm = validateForm;
	this.validateCond = validateCond;
}

/*
 이 소스에 주의 하세요. 탭1에 sheet1,2,3  // 탭2에 sheet4,5,6이 있다가 
 각 탭1에 sheet7 탭2에 sheet8이 추가된것으로 추정됩니다.
 !! 그래서 sheetObject[] 배열에 들어간 순서와 sheet 번호가 맞지 않습니다. !!
 탭3을 추가하다가 고생했습니다. 
 탭3은 순서적으로 맞아 상관 없으나
 탭 1과 2에 있는 sheet는 주의를 기울여야 합니다.
 
 2017.07 김동호
*/

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 0;

var comboObjects = new Array();
var comboCnt = 0;

var loadingMode = false;

var sheet_selno = "1"; //현재 선택된 SHEET ==> 1:By Account, 2:By Lane/BND, 3:By VVD

//tab1
var sheet_height1 = 20; // sheet1의 height
var sheet_height2 = 20; // sheet2의 height
var sheet_height3 = 20; // sheet3의 height
var sheet_height7 = 20; // sheet7의 height
//tab2
var sheet_height4 = 20; // sheet4의 height
var sheet_height5 = 20; // sheet5의 height
var sheet_height6 = 20; // sheet6의 height
var sheet_height8 = 20; // sheet8의 height
//tab3
var sheet_height9  = 20; // sheet9의 height
var sheet_height10 = 20; // sheet10의 height
var sheet_height11 = 20; // sheet11의 height
var sheet_height12 = 20; // sheet12의 height

//tab1
var gHeadCode1 = ""; // sheet1의 header
var gHeadCode2 = ""; // sheet2의 header
var gHeadCode3 = ""; // sheet3의 header
var gHeadCode7 = ""; // sheet7의 header
//tab2
var gHeadCode4 = ""; // sheet4의 header
var gHeadCode5 = ""; // sheet5의 header
var gHeadCode6 = ""; // sheet6의 header
var gHeadCode8 = ""; // sheet8의 header
//tab3
var gHeadCode9  = ""; // sheet9의 header
var gHeadCode10 = ""; // sheet10의 header
var gHeadCode11 = ""; // sheet11의 header
var gHeadCode12 = ""; // sheet12의 header

 //Fixed Header 변경시 sheet_OnSearchEnd() 에도 영향을 줌
//tab1
var fixHeadCnt1 = 4; // sheet1의 fixed header count
var fixHeadCnt2 = 8; // sheet2의 fixed header count
var fixHeadCnt3 = 13; // sheet3의 fixed header count
var fixHeadCnt7 = 14; // sheet7의 fixed header count
//tab2
var fixHeadCnt4 = 4; // sheet4의 fixed header count
var fixHeadCnt5 = 8; // sheet5의 fixed header count
var fixHeadCnt6 = 13; // sheet6의 fixed header count
var fixHeadCnt8 = 14; // sheet8의 fixed header count
//tab3
var fixHeadCnt9  = 4; // sheet9의 fixed header count
var fixHeadCnt10 = 8; // sheet10의 fixed header count
var fixHeadCnt11 = 13; // sheet11의 fixed header count
var fixHeadCnt12 = 14; // sheet12의 fixed header count

//tab1
var zoomFlag1 = "close"; // Zoom Flag #1
var zoomFlag2 = "close"; // Zoom Flag #2
var zoomFlag3 = "close"; // Zoom Flag #3
var zoomFlag7 = "close"; // Zoom Flag #7
//tab2
var zoomFlag4 = "close"; // Zoom Flag #4
var zoomFlag5 = "close"; // Zoom Flag #5
var zoomFlag6 = "close"; // Zoom Flag #6
var zoomFlag8 = "close"; // Zoom Flag #8
//tab3
var zoomFlag9  = "close"; // Zoom Flag #9
var zoomFlag10 = "close"; // Zoom Flag #10
var zoomFlag11 = "close"; // Zoom Flag #11
var zoomFlag12 = "close"; // Zoom Flag #12

//tab1
var first_load1 = true;  //최초 Load시만 sheet1 height 조정
var first_load2 = true;  //최초 Load시만 sheet2 height 조정
var first_load3 = true;  //최초 Load시만 sheet3 height 조정
var first_load7 = true;  //최초 Load시만 sheet7 height 조정
//tab2
var first_load4 = true;  //최초 Load시만 sheet4 height 조정
var first_load5 = true;  //최초 Load시만 sheet5 height 조정
var first_load6 = true;  //최초 Load시만 sheet6 height 조정
var first_load8 = true;  //최초 Load시만 sheet8 height 조정
//tab3
var first_load9  = true;  //최초 Load시만 sheet9  height 조정
var first_load10 = true;  //최초 Load시만 sheet10 height 조정
var first_load11 = true;  //최초 Load시만 sheet11 height 조정
var first_load12 = true;  //최초 Load시만 sheet12 height 조정


/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
function processButtonClick() {
    //tab1
	var sheetObject1 = sheetObjects[0];
	var sheetObject2 = sheetObjects[1];
	var sheetObject3 = sheetObjects[2];
    var sheetObject7 = sheetObjects[3];
    
    //tab2
	var sheetObject4 = sheetObjects[4];
	var sheetObject5 = sheetObjects[5];
	var sheetObject6 = sheetObjects[6];
	var sheetObject8 = sheetObjects[7];
	
	//tab3
    var sheetObject9 = sheetObjects[8];
    var sheetObject10 = sheetObjects[9];
    var sheetObject11 = sheetObjects[10];
    var sheetObject12 = sheetObjects[11];
    
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

		switch(srcName) {

			case "btn_retrieve": 
			    //tab 1
				if (sheet_selno == "1") { 
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				} else if (sheet_selno == "2") { 
					doActionIBSheet2(sheetObject2,formObject,IBSEARCH);
				} else if (sheet_selno == "3") { 
					doActionIBSheet3(sheetObject3,formObject,IBSEARCH);
				} else if (sheet_selno == "7") { 
                    doActionIBSheet7(sheetObject7,formObject,IBSEARCH);
                }
				//tab2
				else if (sheet_selno == "4") { 
					doActionIBSheet4(sheetObject4,formObject,IBSEARCH);
				} else if (sheet_selno == "5") { 
					doActionIBSheet5(sheetObject5,formObject,IBSEARCH);
				} else if (sheet_selno == "6") { 
					doActionIBSheet6(sheetObject6,formObject,IBSEARCH);
				} else if (sheet_selno == "8") { 
					doActionIBSheet8(sheetObject8,formObject,IBSEARCH);
				} 
				//tab3
                else if (sheet_selno == "9") { 
                    doActionIBSheet9(sheetObject9,formObject,IBSEARCH);
                } else if (sheet_selno == "10") { 
                    doActionIBSheet10(sheetObject10,formObject,IBSEARCH);
                } else if (sheet_selno == "11") { 
                    doActionIBSheet11(sheetObject11,formObject,IBSEARCH);
                } else if (sheet_selno == "12") { 
                    doActionIBSheet12(sheetObject12,formObject,IBSEARCH);
                }
				break;

			case "btn_downexcel": 
    			//tab 1
                if (sheet_selno == "1") { 
                    doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "2") { 
                    doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "3") { 
                    doActionIBSheet3(sheetObject3,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "7") { 
                    doActionIBSheet7(sheetObject7,formObject,IBDOWNEXCEL);
                }
                //tab2
                else if (sheet_selno == "4") { 
                    doActionIBSheet4(sheetObject4,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "5") { 
                    doActionIBSheet5(sheetObject5,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "6") { 
                    doActionIBSheet6(sheetObject6,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "8") { 
                    doActionIBSheet8(sheetObject8,formObject,IBDOWNEXCEL);
                } 
                //tab3
                else if (sheet_selno == "9") { 
                    doActionIBSheet9(sheetObject9,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "10") { 
                    doActionIBSheet10(sheetObject10,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "11") { 
                    doActionIBSheet11(sheetObject11,formObject,IBDOWNEXCEL);
                } else if (sheet_selno == "12") { 
                    doActionIBSheet12(sheetObject12,formObject,IBDOWNEXCEL);
                }
				break;

			case "bu_zoom_in1": //next
			case "bu_zoom_in2": //next
			case "bu_zoom_in3":
			    // tab1
				if (sheet_selno == "1") {
					sheet_height1 = getSheetHeightCnt(sheetObject1,"MAX",1);
					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
					zoomFlag1 = "open";
				} else if (sheet_selno == "2") {
					sheet_height2 = getSheetHeightCnt(sheetObject2,"MAX",1);
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
					zoomFlag2 = "open";
				} else if (sheet_selno == "3") {
					sheet_height3 = getSheetHeightCnt(sheetObject3,"MAX",1);
					sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height3);
					zoomFlag3 = "open";
				} else if (sheet_selno == "7") { 
                    sheet_height7 = getSheetHeightCnt(sheetObject7,"MAX",1);
                    sheetObject7.style.height = sheetObject7.GetSheetHeight(sheet_height7);
                    zoomFlag7 = "open";
                }
				// tab2
				else if (sheet_selno == "4") { 
					sheet_height4 = getSheetHeightCnt(sheetObject4,"MAX",1);
					sheetObject4.style.height = sheetObject4.GetSheetHeight(sheet_height4);
					zoomFlag4 = "open";
				} else if (sheet_selno == "5") {
					sheet_height5 = getSheetHeightCnt(sheetObject5,"MAX",1);
					sheetObject5.style.height = sheetObject5.GetSheetHeight(sheet_height5);
					zoomFlag5 = "open";
				} else if (sheet_selno == "6") {
					sheet_height6 = getSheetHeightCnt(sheetObject6,"MAX",1);
					sheetObject6.style.height = sheetObject6.GetSheetHeight(sheet_height6);
					zoomFlag6 = "open";
				} else if (sheet_selno == "8") {
					sheet_height8 = getSheetHeightCnt(sheetObject8,"MAX",1);
					sheetObject8.style.height = sheetObject8.GetSheetHeight(sheet_height8);
					zoomFlag8 = "open";
				} 
				// tab3
                else if (sheet_selno == "9") { 
                    sheet_height9 = getSheetHeightCnt(sheetObject9,"MAX",1);
                    sheetObject9.style.height = sheetObject9.GetSheetHeight(sheet_height9);
                    zoomFlag9 = "open";
                } else if (sheet_selno == "10") {
                    sheet_height10 = getSheetHeightCnt(sheetObject10,"MAX",1);
                    sheetObject10.style.height = sheetObject10.GetSheetHeight(sheet_height10);
                    zoomFlag10 = "open";
                } else if (sheet_selno == "11") {
                    sheet_height11 = getSheetHeightCnt(sheetObject11,"MAX",1);
                    sheetObject11.style.height = sheetObject11.GetSheetHeight(sheet_height11);
                    zoomFlag11 = "open";
                } else if (sheet_selno == "12") {
                    sheet_height12 = getSheetHeightCnt(sheetObject12,"MAX",1);
                    sheetObject12.style.height = sheetObject12.GetSheetHeight(sheet_height12);
                    zoomFlag12 = "open";
                }
				setZoom();
				parent.syncHeight();
				break;

			case "bu_zoom_out1": //next
			case "bu_zoom_out2": //next
			case "bu_zoom_out3":
			    // tab1
				if (sheet_selno == "1") {
					sheet_height1 = getSheetHeightCnt(sheetObject1,"MIN",0);
					sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height1);
					zoomFlag1 = "close";
				} else if (sheet_selno == "2") {
					sheet_height2 = getSheetHeightCnt(sheetObject2,"MIN",0);
					sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height2);
					zoomFlag2 = "close";
				} else if (sheet_selno == "3") {
					sheet_height3 = getSheetHeightCnt(sheetObject3,"MIN",0);
					sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height3);
					zoomFlag3 = "close";
				} else if (sheet_selno == "7") {
                    sheet_height7 = getSheetHeightCnt(sheetObject7,"MIN",0);
                    sheetObject7.style.height = sheetObject7.GetSheetHeight(sheet_height7);
                    zoomFlag7 = "close";
                }		        
                // tab2
				else if (sheet_selno == "4") {
					sheet_height4 = getSheetHeightCnt(sheetObject4,"MIN",0);
					sheetObject4.style.height = sheetObject4.GetSheetHeight(sheet_height4);
					zoomFlag4 = "close";
				} else if (sheet_selno == "5") {
					sheet_height5 = getSheetHeightCnt(sheetObject5,"MIN",0);
					sheetObject5.style.height = sheetObject5.GetSheetHeight(sheet_height5);
					zoomFlag5 = "close";
				} else if (sheet_selno == "6") {
					sheet_height6 = getSheetHeightCnt(sheetObject6,"MIN",0);
					sheetObject6.style.height = sheetObject6.GetSheetHeight(sheet_height6);
					zoomFlag6 = "close";
				} else if (sheet_selno == "8") {
					sheet_height8 = getSheetHeightCnt(sheetObject8,"MIN",0);
					sheetObject8.style.height = sheetObject8.GetSheetHeight(sheet_height8);
					zoomFlag7 = "close";
				}
				// tab3
                else if (sheet_selno == "9") {
                    sheet_height9 = getSheetHeightCnt(sheetObject9,"MIN",0);
                    sheetObject9.style.height = sheetObject9.GetSheetHeight(sheet_height9);
                    zoomFlag9 = "close";
                } else if (sheet_selno == "10") {
                    sheet_height10 = getSheetHeightCnt(sheetObject10,"MIN",0);
                    sheetObject10.style.height = sheetObject10.GetSheetHeight(sheet_height10);
                    zoomFlag10 = "close";
                } else if (sheet_selno == "11") {
                    sheet_height11 = getSheetHeightCnt(sheetObject11,"MIN",0);
                    sheetObject11.style.height = sheetObject11.GetSheetHeight(sheet_height11);
                    zoomFlag11 = "close";
                } else if (sheet_selno == "12") {
                    sheet_height12 = getSheetHeightCnt(sheetObject12,"MIN",0);
                    sheetObject12.style.height = sheetObject12.GetSheetHeight(sheet_height12);
                    zoomFlag12 = "close";
                }
				setZoom();
				parent.syncHeight();
				break;

			case "f_rdotype":
				changeTabInfo(beforetab);
            	setZoom();
            	parent.syncHeight();
				break;

			case "f_rdotype_a":
				changeTabInfo(beforetab);
            	setZoom();
            	parent.syncHeight();
				break;
				
			case "f_rdotype_b":
                changeTabInfo(beforetab);
                setZoom();
                parent.syncHeight();
                break;
			case "btn_create":				
					doActionIBSheet(sheetObject1,formObject,IBCREATE);
				break;
           
           /*
           case "f_iskorean": 	
				if (sheet_selno == "1") { //첫번째 SHEET 이면
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				}
				break;
		   */
		} // end switch

	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}

/**
 * Sheet 기본 설정 및 초기화
 */
function loadPage(hCode1,hName1,hCode2,hName2,hCode3,hName3) {
	var headCode = "";
	var headName = "";
	
    //IBTab초기화
    for(var k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
    }

	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		
		var id = sheetObjects[i].id;
		
		if (id=="sheet1") {
			headCode = hCode1;
			headName = hName1;
		} else if (id=="sheet2") {
			headCode = hCode2;
			headName = hName2;
		} else if (id=="sheet3") {
			headCode = hCode3;
			headName = hName3;
		} else if (id=="sheet7") {
            headCode = hCode3;
            headName = hName3;
        } else if (id=="sheet4") {
			headCode = hCode1;
			headName = hName1;
		} else if (id=="sheet5") {
			headCode = hCode2;
			headName = hName2;
		} else if (id=="sheet6") {
			headCode = hCode3;
			headName = hName3;
		} else if (id=="sheet8") {
			headCode = hCode3;
			headName = hName3;
		} else if (id=="sheet9") {
            headCode = hCode1;
            headName = hName1;
        } else if (id=="sheet10") {
            headCode = hCode2;
            headName = hName2;
        } else if (id=="sheet11") {
            headCode = hCode3;
            headName = hName3;
        } else if (id=="sheet12") {
            headCode = hCode3;
            headName = hName3;
        }
		initSheet(sheetObjects[i], i+1, headCode, headName);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	//SELCDA일 경우만 Create 버튼 활성화 
	
	if ( document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'CLTCO'
		|| document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'SELBPP'){
		ComBtnEnable("btn_create");
	} else {
		ComBtnDisable("btn_create");
	}
	
	loadingMode = true;
    doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    // 멀티콤보 처리
	//---------------------------------------------
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	//---------------------------------------------
	loadingMode = false;
	
	//trade가 IAS일때만 활성화
	document.getElementById("f_ias_rgn_cd").Enable = false;
	
	tabLayer2.style.display = "none";
	tabLayer3.style.display = "none";
    tabLayer7.style.display = "none";
	tabLayer4.style.display = "none";
	tabLayer5.style.display = "none";
	tabLayer6.style.display = "none";
	tabLayer8.style.display = "none";
	tabLayer9.style.display = "none";
    tabLayer10.style.display = "none";
    tabLayer11.style.display = "none";
    tabLayer12.style.display = "none";
	

	sheet_selno = "1"; //default: By Account
	setCobDisplay();
	setZoom();
	
	// Adjusted P&L Default...
	tabObjects[0].SelectedIndex = 1;
}
 /**
* Tab 기본 설정
* 탭의 항목을 설정한다.
*/
function initCombo (comboObj, comboId) {
	with (comboObj) {
		Index = 0;
		DropHeight = 300;
		
		if(comboId == "f_ofc_cd"){
    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
    		MaxLength = 6;
    	} else if(comboId == "f_trd_cd"){
    		ValidChar(2,0); // 영어대문자 사용
    		MaxLength = 3;
    	} else if(comboId == "f_rlane_cd"){
    		ValidChar(2,1); // 영어대문자 사용, 숫자포함 시
    		MaxLength = 5;
    	} else if(comboId == "f_dir_cd"){
    		ValidChar(2,0); // 영어대문자 사용
    		MaxLength = 1;
    	}
	}
}

/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 */
function initTab(tabObj , tabNo) {
    switch(tabNo) {
        case 1:
           with (tabObj) {
               var cnt  = 0 ;
               InsertTab( cnt++ , " P&L Report  " , -1 );
               InsertTab( cnt++ , " Adjusted P&L  " , -1 );
               InsertTab( cnt++ , " P&L by agreement " , -1 );
           }
           break;
    }
}



/**
 * 시트 초기설정값, 헤더 정의
 */
function initSheet(sheetObj, sheetNo, headCode, headName) {
	var formObj = document.form;
	var cnt = 0;
	var varCnt = 0;
	
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			if (headName == "") {
				headCode = "|AES|IAS|IES|IMS|TAS|TPS";
				headName = "|AES|IAS|IES|IMS|TAS|TPS";
			}
			gHeadCode1 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			var arrHead = headName.replace(/(^\s*)/g,'').split("|");
			varCnt = arrHead.length - 1;

			var headText0 = "";
			var headText1 = "";
			for (n=1; n<=varCnt; n++) {
				headText0 = headText0 + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n];
				headText1 = headText1 + "|H/H|B/H|TOT";
			}

			with (sheetObj) {
			    if (first_load1 == true) { style.height = GetSheetHeight(sheet_height1); }
			    first_load1 = false;
				//style.height = GetSheetHeight(sheet_height1) ;

				SheetWidth = mainTable1.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //msNone;
				Editable = false;
				InitRowInfo(2, 1, 9, 100);
				InitColumnInfo(fixHeadCnt1 + (varCnt * 3), fixHeadCnt1 - 1, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle0 = "SEQ|stnd_cost_cd|Items" + headText0 + "|Total";
				var HeadTitle1 = "SEQ|stnd_cost_cd|Items" + headText1 + "|Total";
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, false);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "");
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,   220, daLeft,   true, "itm_desc",     false, "", dfNone, 0, false, false);

				var calcuLogic = "";
				for (n=0; n<varCnt; n++) {
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_e_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_w_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;

					InitDataProperty(0, cnt, dtData, 90, daRight, true, "trd_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					calcuLogic = calcuLogic + "+|trd_amt"+(n+1)+"|";
					cnt++;
				}
				if (calcuLogic != "") { calcuLogic = calcuLogic.substring(1); }

				InitDataProperty(0, cnt++, dtData,  90, daRight, true, "ttl_amt", false, "", dfFloatOrg, 2, false, false);

				HeadRowHeight = 10;
				CountPosition = 0;

				DataLinkMouse("itm_desc") = true;
				InitTreeInfo("itm_desc", "itm_name", RgbColor(0,0,255), true);

			}
			break;

		case "sheet2":      //sheet2 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}

			gHeadCode2 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode2.length;

			with (sheetObj) {
			    if (first_load2 == true) { style.height = GetSheetHeight(sheet_height2); }
			    first_load2 = false;
				//style.height = GetSheetHeight(sheet_height2) ;

				SheetWidth = mainTable2.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(fixHeadCnt2 + varCnt, fixHeadCnt2, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Seq.|Month|Trade|Sub Trade|R.Lane|IOC|Dir.|Trade Dir." + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sls_yrmon",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);

                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
				    if (gHeadCode2[n] == "LOADFACT" || gHeadCode2[n] == "RPB00000" || gHeadCode2[n] == "CMCB0000" || 
				        gHeadCode2[n] == "CMB00000" || gHeadCode2[n] == "OPCB0000" || gHeadCode2[n] == "OPB00000" ||
				        gHeadCode2[n] == "BOPB0000" || gHeadCode2[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    
				    if (gHeadCode2[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}


				HeadRowHeight = 10;
				CountPosition = 0;

			}
			break;

		case "sheet3":      //sheet3 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}
			gHeadCode3 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode3.length;

			with (sheetObj) {
			    if (first_load3 == true) { style.height = GetSheetHeight(sheet_height3); }
			    first_load3 = false;
				//style.height = GetSheetHeight(sheet_height3) ;

				SheetWidth = mainTable3.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(formObj.f_ias_flg.checked?fixHeadCnt7:fixHeadCnt3 + varCnt, fixHeadCnt3, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir." + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
				
				if(formObj.f_ias_flg.checked) {
					InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "status", false, "", dfNone, 0, false, false);
				}
                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
					if (gHeadCode3[n] == "LOADFACT" || gHeadCode3[n] == "RPB00000" || gHeadCode3[n] == "CMCB0000" || 
				        gHeadCode3[n] == "CMB00000" || gHeadCode3[n] == "OPCB0000" || gHeadCode3[n] == "OPB00000" ||
				        gHeadCode3[n] == "BOPB0000" || gHeadCode3[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    if (gHeadCode3[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}
				HeadRowHeight = 10;
				CountPosition = 0;
				sheetObj.ColHidden("rhq") = true;
			}
			break;
		
		case "sheet7":      //sheet7 init
            if (headName == "") {
                headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
                headName = "|Voyage|Supply|Load|L/F|Revenue";
            }
            gHeadCode7 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt = gHeadCode7.length;

            with (sheetObj) {
                if (first_load7 == true) { style.height = GetSheetHeight(sheet_height7); }
                first_load7 = false;
                //style.height = GetSheetHeight(sheet_height3) ;

                SheetWidth = mainTable7.clientWidth * 95 / 100;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone; //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                InitColumnInfo(fixHeadCnt7 + varCnt, fixHeadCnt7, 0, true);
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir.|TS/Local" + headName;
                InitHeadRow(0, HeadTitle, true);


                cnt = 0;
                InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "status", false, "", dfNone, 0, false, false);

                var iDataType = dtData;
                for (n=0; n<varCnt; n++) {
                    if (gHeadCode7[n] == "LOADFACT" || gHeadCode7[n] == "RPB00000" || gHeadCode7[n] == "CMCB0000" || 
                        gHeadCode7[n] == "CMB00000" || gHeadCode7[n] == "OPCB0000" || gHeadCode7[n] == "OPB00000" ||
                        gHeadCode7[n] == "BOPB0000" || gHeadCode7[n] == "BOPB0000" ) {
                        iDataType = dtData;
                    } else {
                        iDataType = dtAutoSum;
                    }
                    if (gHeadCode7[n] == "LOADFACT") {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
                    } else {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
                    }
                    CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;
                }
                HeadRowHeight = 10;
                CountPosition = 0;
                sheetObj.ColHidden("rhq") = true;
            }
            break;  
			
			
		//////////////////////////////////////////////////////////////////////////////
		// tab2
		//////////////////////////////////////////////////////////////////////////
		case "sheet4":      //sheet4 init
			if (headName == "") {
				headCode = "|AES|IAS|IES|IMS|TAS|TPS";
				headName = "|AES|IAS|IES|IMS|TAS|TPS";
			}
			gHeadCode4 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			var arrHead = headName.replace(/(^\s*)/g,'').split("|");
			varCnt = arrHead.length - 1;

			var headText0 = "";
			var headText1 = "";
			for (n=1; n<=varCnt; n++) {
				headText0 = headText0 + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n];
				headText1 = headText1 + "|H/H|B/H|M/B|TOT";
			}

			with (sheetObj) {
			    if (first_load4 == true) { style.height = GetSheetHeight(sheet_height4); }
			    first_load4 = false;
				//style.height = GetSheetHeight(sheet_height1) ;

				SheetWidth = mainTable4.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msHeaderOnly; //msNone;
				Editable = false;
				InitRowInfo(2, 1, 9, 100);
				InitColumnInfo(fixHeadCnt4 + (varCnt * 4) + 1, fixHeadCnt4 - 1, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle0 = "SEQ|stnd_cost_cd|Items" + headText0 + "|COM|Total";
				var HeadTitle1 = "SEQ|stnd_cost_cd|Items" + headText1 + "|COM|Total";
				InitHeadRow(0, HeadTitle0, true);
				InitHeadRow(1, HeadTitle1, false);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "");
				InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData,   220, daLeft,   true, "itm_desc",     false, "", dfNone, 0, false, false);

				var calcuLogic = "";
				for (n=0; n<varCnt; n++) {
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_e_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_w_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
					InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_m_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;

					InitDataProperty(0, cnt, dtData, 90, daRight, true, "trd_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
					CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
					calcuLogic = calcuLogic + "+|trd_amt"+(n+1)+"|";
					cnt++;
				}
				if (calcuLogic != "") { calcuLogic = calcuLogic.substring(1); }

				InitDataProperty(0, cnt++, dtData,  90, daRight, true, "com_amt", false, "", dfFloatOrg, 2, false, false);
				InitDataProperty(0, cnt++, dtData,  90, daRight, true, "ttl_amt", false, "", dfFloatOrg, 2, false, false);

				HeadRowHeight = 10;
				CountPosition = 0;

				DataLinkMouse("itm_desc") = true;
				InitTreeInfo("itm_desc", "itm_name", RgbColor(0,0,255), true);

			}
			break;

		case "sheet5":      //sheet5 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}

			gHeadCode5 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode5.length;

			with (sheetObj) {
			    if (first_load5 == true) { style.height = GetSheetHeight(sheet_height5); }
			    first_load5 = false;
				//style.height = GetSheetHeight(sheet_height2) ;

				SheetWidth = mainTable5.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(fixHeadCnt5 + varCnt, fixHeadCnt5, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "Seq.|Month|Trade|Sub Trade|R.Lane|IOC|Dir.|Trade Dir." + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);

                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
				    if (gHeadCode5[n] == "LOADFACT" || gHeadCode5[n] == "RPB00000" || gHeadCode5[n] == "CMCB0000" || 
				        gHeadCode5[n] == "CMB00000" || gHeadCode5[n] == "OPCB0000" || gHeadCode5[n] == "OPB00000" ||
				        gHeadCode5[n] == "BOPB0000" || gHeadCode5[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    
				    if (gHeadCode5[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}


				HeadRowHeight = 10;
				CountPosition = 0;

			}
			break;

		case "sheet6":      //sheet6 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}
			gHeadCode6 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode6.length;

			with (sheetObj) {
			    if (first_load6 == true) { style.height = GetSheetHeight(sheet_height6); }
			    first_load6 = false;
				//style.height = GetSheetHeight(sheet_height3) ;

				SheetWidth = mainTable6.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(fixHeadCnt6 + varCnt, fixHeadCnt6, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir." + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
					if (gHeadCode6[n] == "LOADFACT" || gHeadCode6[n] == "RPB00000" || gHeadCode6[n] == "CMCB0000" || 
				        gHeadCode6[n] == "CMB00000" || gHeadCode6[n] == "OPCB0000" || gHeadCode6[n] == "OPB00000" ||
				        gHeadCode6[n] == "BOPB0000" || gHeadCode6[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    if (gHeadCode6[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}
				HeadRowHeight = 10;
				CountPosition = 0;
				sheetObj.ColHidden("rhq") = true;
			}
			break;	

		case "sheet8":      //sheet8 init
			if (headName == "") {
				headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
				headName = "|Voyage|Supply|Load|L/F|Revenue";
			}
			gHeadCode6 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
			varCnt = gHeadCode6.length;

			with (sheetObj) {
			    if (first_load8 == true) { style.height = GetSheetHeight(sheet_height8); }
			    first_load8 = false;
				//style.height = GetSheetHeight(sheet_height3) ;

				SheetWidth = mainTable8.clientWidth * 95 / 100;
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				MergeSheet = msNone; //msHeaderOnly;
				Editable = false;
				InitRowInfo(1, 1, 9, 100);
				InitColumnInfo(fixHeadCnt8 + varCnt, fixHeadCnt8, 0, true);
				InitHeadMode(true, true, false, true, false, false);

				var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir.|TS/Local" + headName;
				InitHeadRow(0, HeadTitle, true);


				cnt = 0;
				InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);				
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);								
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
				InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "status", false, "", dfNone, 0, false, false);
                var iDataType = dtData;
				for (n=0; n<varCnt; n++) {
					if (gHeadCode8[n] == "LOADFACT" || gHeadCode8[n] == "RPB00000" || gHeadCode8[n] == "CMCB0000" || 
				        gHeadCode8[n] == "CMB00000" || gHeadCode8[n] == "OPCB0000" || gHeadCode8[n] == "OPB00000" ||
				        gHeadCode8[n] == "BOPB0000" || gHeadCode8[n] == "BOPB0000" ) {
				        iDataType = dtData;
				    } else {
				        iDataType = dtAutoSum;
				    }
				    if (gHeadCode6[n] == "LOADFACT") {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
				    } else {
    					InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
				    }
					CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
					cnt++;
				}
				HeadRowHeight = 10;
				CountPosition = 0;
				sheetObj.ColHidden("rhq") = true;
			}
			break;
			
		//////////////////////////////////////////////////////////////////////////////
	    // tab3
	    //////////////////////////////////////////////////////////////////////////
		case "sheet9": 
		    if (headName == "") {
                headCode = "|AES|IAS|IES|IMS|TAS|TPS";
                headName = "|AES|IAS|IES|IMS|TAS|TPS";
            }
            gHeadCode9 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            var arrHead = headName.replace(/(^\s*)/g,'').split("|");
            varCnt = arrHead.length - 1;

            var headText0 = "";
            var headText1 = "";
            for (n=1; n<=varCnt; n++) {
                headText0 = headText0 + "|"+arrHead[n] + "|"+arrHead[n] + "|"+arrHead[n];
                headText1 = headText1 + "|H/H|B/H|TOT";
            }

            with (sheetObj) {
                if (first_load9 == true) { style.height = GetSheetHeight(sheet_height9); }
                first_load9 = false;
                //style.height = GetSheetHeight(sheet_height1) ;

                SheetWidth = mainTable9.clientWidth * 95 / 100;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msHeaderOnly; //msNone;
                Editable = false;
                InitRowInfo(2, 1, 9, 100);
                InitColumnInfo(fixHeadCnt9 + (varCnt * 3), fixHeadCnt9 - 1, 0, true);
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle0 = "SEQ|stnd_cost_cd|Items" + headText0 + "|Total";
                var HeadTitle1 = "SEQ|stnd_cost_cd|Items" + headText1 + "|Total";
                InitHeadRow(0, HeadTitle0, true);
                InitHeadRow(1, HeadTitle1, false);


                cnt = 0;
                InitDataProperty(0, cnt++, dtSeq,     40, daCenter, true, "");
                InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true, "stnd_cost_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData,   220, daLeft,   true, "itm_desc",     false, "", dfNone, 0, false, false);

                var calcuLogic = "";
                for (n=0; n<varCnt; n++) {
                    InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_e_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
                    CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;
                    InitDataProperty(0, cnt, dtData, 90, daRight, true, "dir_w_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
                    CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;

                    InitDataProperty(0, cnt, dtData, 90, daRight, true, "trd_amt"+(n+1), false, "", dfFloatOrg, 2, false, false);
                    CellBackColor(1, cnt) = RgbColor(222,251,248); //255,248,251
                    calcuLogic = calcuLogic + "+|trd_amt"+(n+1)+"|";
                    cnt++;
                }
                if (calcuLogic != "") { calcuLogic = calcuLogic.substring(1); }

                InitDataProperty(0, cnt++, dtData,  90, daRight, true, "ttl_amt", false, "", dfFloatOrg, 2, false, false);

                HeadRowHeight = 10;
                CountPosition = 0;

                DataLinkMouse("itm_desc") = true;
                InitTreeInfo("itm_desc", "itm_name", RgbColor(0,0,255), true);

            }
            break;

        case "sheet10":      //sheet5 init
            if (headName == "") {
                headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
                headName = "|Voyage|Supply|Load|L/F|Revenue";
            }

            gHeadCode10 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt = gHeadCode10.length;

            with (sheetObj) {
                if (first_load10 == true) { style.height = GetSheetHeight(sheet_height10); }
                first_load10 = false;

                SheetWidth = mainTable10.clientWidth * 95 / 100;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone; //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                InitColumnInfo(fixHeadCnt10 + varCnt, fixHeadCnt10, 0, true);
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "Seq.|Month|Trade|Sub Trade|R.Lane|IOC|Dir.|Trade Dir." + headName;
                InitHeadRow(0, HeadTitle, true);


                cnt = 0;
                InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);

                var iDataType = dtData;
                for (n=0; n<varCnt; n++) {
                    if (gHeadCode10[n] == "LOADFACT" || gHeadCode10[n] == "RPB00000" || gHeadCode10[n] == "CMCB0000" || 
                        gHeadCode10[n] == "CMB00000" || gHeadCode10[n] == "OPCB0000" || gHeadCode10[n] == "OPB00000" ||
                        gHeadCode10[n] == "BOPB0000" || gHeadCode10[n] == "BOPB0000" ) {
                        iDataType = dtData;
                    } else {
                        iDataType = dtAutoSum;
                    }
                    
                    if (gHeadCode10[n] == "LOADFACT") {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
                    } else {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
                    }
                    CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;
                }


                HeadRowHeight = 10;
                CountPosition = 0;

            }
            break;

        case "sheet11": 
            if (headName == "") {
                headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
                headName = "|Voyage|Supply|Load|L/F|Revenue";
            }
            gHeadCode11 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt = gHeadCode11.length;

            with (sheetObj) {
                if (first_load11 == true) { style.height = GetSheetHeight(sheet_height11); }
                first_load11 = false;

                SheetWidth = mainTable11.clientWidth * 95 / 100;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone; //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                InitColumnInfo(fixHeadCnt11 + varCnt, fixHeadCnt11, 0, true);
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir." + headName;
                InitHeadRow(0, HeadTitle, true);


                cnt = 0;
                InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
                var iDataType = dtData;
                for (n=0; n<varCnt; n++) {
                    if (gHeadCode11[n] == "LOADFACT" || gHeadCode11[n] == "RPB00000" || gHeadCode11[n] == "CMCB0000" || 
                        gHeadCode11[n] == "CMB00000" || gHeadCode11[n] == "OPCB0000" || gHeadCode11[n] == "OPB00000" ||
                        gHeadCode11[n] == "BOPB0000" || gHeadCode11[n] == "BOPB0000" ) {
                        iDataType = dtData;
                    } else {
                        iDataType = dtAutoSum;
                    }
                    if (gHeadCode11[n] == "LOADFACT") {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
                    } else {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
                    }
                    CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;
                }
                HeadRowHeight = 10;
                CountPosition = 0;
                sheetObj.ColHidden("rhq") = true;
            }
            break;  

        case "sheet12":      //sheet8 init
            if (headName == "") {
                headCode = "|VOYAGE00|BSA00000|LOAD0000|LOADFACT|REVENUE0";
                headName = "|Voyage|Supply|Load|L/F|Revenue";
            }
            gHeadCode12 = headCode.substring(1).replace(/(^\s*)/g,'').split("|");
            varCnt = gHeadCode12.length;

            with (sheetObj) {
                if (first_load12 == true) { style.height = GetSheetHeight(sheet_height12); }
                first_load12 = false;

                SheetWidth = mainTable12.clientWidth * 95 / 100;
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                MergeSheet = msNone; //msHeaderOnly;
                Editable = false;
                InitRowInfo(1, 1, 9, 100);
                InitColumnInfo(fixHeadCnt12 + varCnt, fixHeadCnt12, 0, true);
                InitHeadMode(true, true, false, true, false, false);

                var HeadTitle = "SEQ|R.Month|S.Month|Week|Rhq|Trade|Sub Trade|R.Lane|IOC|Vessel|Voyage|Dir.|Trade Dir.|TS/Local" + headName;
                InitHeadRow(0, HeadTitle, true);


                cnt = 0;
                InitDataProperty(0, cnt++, dtSeq,  40, daCenter, false, "");
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "cost_yrmon", false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "sls_yrmon",  false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "cost_wk",    false, "", dfNone, 0, false, false);              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rhq",        false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "trd_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 65, daCenter, false, "sub_trd_cd", false, "", dfNone, 0, false, false);                              
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "rlane_cd",   false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "ioc_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "vsl_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 50, daCenter, false, "skd_voy_no", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 40, daCenter, false, "dir_cd",     false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 60, daCenter, false, "hul_bnd_cd", false, "", dfNone, 0, false, false);
                InitDataProperty(0, cnt++, dtData, 80, daCenter, false, "status", false, "", dfNone, 0, false, false);
                var iDataType = dtData;
                for (n=0; n<varCnt; n++) {
                    if (gHeadCode12[n] == "LOADFACT" || gHeadCode12[n] == "RPB00000" || gHeadCode12[n] == "CMCB0000" || 
                        gHeadCode12[n] == "CMB00000" || gHeadCode12[n] == "OPCB0000" || gHeadCode12[n] == "OPB00000" ||
                        gHeadCode12[n] == "BOPB0000" || gHeadCode12[n] == "BOPB0000" ) {
                        iDataType = dtData;
                    } else {
                        iDataType = dtAutoSum;
                    }
                    if (gHeadCode12[n] == "LOADFACT") {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfFloatOrg,   1, false, false);
                    } else {
                        InitDataProperty(0, cnt, iDataType, 110, daRight, false, "cost_amt"+(n+1), false, "", dfInteger, 0, false, false);
                    }
                    CellBackColor(0, cnt) = RgbColor(222,251,248); //255,248,251
                    cnt++;
                }
                HeadRowHeight = 10;
                CountPosition = 0;
                sheetObj.ColHidden("rhq") = true;
            }
            break;

	}
}
 /**
* IBCombo Object를 배열로 등록
* 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
* 배열은 소스 상단에 정의
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++] = combo_obj;
}

/**
 * IBTab Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setTabObject(tab_obj){
    tabObjects[tabCnt++] = tab_obj;
}


/**
 * IBSheet Object를 배열로 등록
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
 
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	var fixCnt = fixHeadCnt1 - 1; //가변길이 뒤 Total 필드 제외
	var supply = 0;
	var load = 0;
	
	with(sheetObj) {
	    // STP REV를 원래 계정 비용으로 나오게 함 2007.07.19 BY LHI 
	    // 일단 HEAD OFFICE 일 경우 같게 함... 
		//Profit View를 'RA'로 검색시 STP Cost --> STP Income으로 복사
//		if (document.form.f_ofc_lvl.value == "1"){    // head office
//    		if (document.form.f_pro_vw.value == "R") {
//    			var sRow = FindText("stnd_cost_cd","92404011"); // STP Cost
//    			var tRow = FindText("stnd_cost_cd","91401011"); // STP Income
//    			for (var n=fixCnt; n<=LastCol; n++) { //3은 seq, stnd_cost_cd, itm_desc 제외
//    				CellValue2(tRow,n) = CellValue(sRow,n);
//    			}
//    		}
//	    }
		//L/F, RPB 합계 재계산
		var loadR   = FindText("stnd_cost_cd","LOAD0000"); // Load
		var supplyR = FindText("stnd_cost_cd","BSA00000"); // Supply
		var revR    = FindText("stnd_cost_cd","REVENUE0"); // Revenue

		var t1R = FindText("stnd_cost_cd","LOADFACT"); // L/F = (Load / Supply) * 100
		var t2R = FindText("stnd_cost_cd","RPB00000"); // RPB = Revenue / Load

		var s3R = FindText("stnd_cost_cd","CMCOST00"); // Cost1 Total
		var t3R = FindText("stnd_cost_cd","CMCB0000"); // Cost1/TEU = Cost1 Total / Load
		var s4R = FindText("stnd_cost_cd","CMCTOTAL"); // CM(Net Revenue) Total
		var t4R = FindText("stnd_cost_cd","CMB00000"); // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		 
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI
		var s7R = FindText("stnd_cost_cd","BCMTOTAL"); // Branch CM(Net Revenue) Total
		var t7R = FindText("stnd_cost_cd","BCMB0000"); // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load		
		
		var s5R = FindText("stnd_cost_cd","OPCOSTEX"); // OP Cost Total(excluding interest)
		var t5R = FindText("stnd_cost_cd","OPCB0000"); // OP Cost(excluding interest) /TEU
		
		var s6R = FindText("stnd_cost_cd","OPCTOTAL"); // OP(Operating Profit) Total
		var t6R = FindText("stnd_cost_cd","OPB00000"); // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load

		var s7R = FindText("stnd_cost_cd","OPUTOTAL"); // BU OP(Operationg Profit) Total
		
		var s8R = FindText("stnd_cost_cd","BOPTTLEX"); // OP(excluding interest)
		var t8R = FindText("stnd_cost_cd","BOPB0000"); // OP(excluding)/TEU
     
		for (var i=fixCnt; i<=LastCol; i++) { //3은 seq, stnd_cost_cd, itm_desc 제외
			if (CellValue(1,i) == "H/H" || CellValue(1,i) == "B/H" || CellValue(1,i) == "TOT") {
				supply = (CellValue(supplyR,i)==null) ? 0 : CellValue(supplyR,i);
				load   = (CellValue(loadR,i)==null) ? 0 : CellValue(loadR,i);

				if (t1R > -1) CellValue2(t1R,i) = (supply==0) ? 0 : (load / supply) * 100;
				if (t2R > -1 && revR > -1) CellValue2(t2R,i) = (load==0) ? 0 : CellValue(revR,i) / load;

				if (t3R > -1 && s3R > -1) CellValue2(t3R,i) = (load==0) ? 0 : CellValue(s3R,i) / load;
				if (t4R > -1 && s4R > -1) CellValue2(t4R,i) = (load==0) ? 0 : CellValue(s4R,i) / load;
				
         		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI				
				if (t7R > -1 && s7R > -1) CellValue2(t7R,i) = (load==0) ? 0 : CellValue(s7R,i) / load;				
				
				if (t5R > -1 && s5R > -1) CellValue2(t5R,i) = (load==0) ? 0 : CellValue(s5R,i) / load;
				if (t6R > -1 && s6R > -1) CellValue2(t6R,i) = (load==0) ? 0 : CellValue(s6R,i) / load;

				if (t8R > -1 && s8R > -1) CellValue2(t8R,i) = (load==0) ? 0 : CellValue(s8R,i) / load;
			}
		}

		//Total 재계산
		supply = (CellValue(supplyR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(supplyR,"ttl_amt"));
		load   = (CellValue(loadR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(loadR,"ttl_amt"));
		if(t1R>0) CellValue2(t1R,"ttl_amt") = (supply==0) ? 0 : (load / supply) * 100;
		if(t2R>0) CellValue2(t2R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(revR,"ttl_amt")) /  load;
		if(t3R>0) CellValue2(t3R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s3R,"ttl_amt")) /  load;
		if(t4R>0) CellValue2(t4R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s4R,"ttl_amt")) /  load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI		
		if(t7R>0) CellValue2(t7R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s7R,"ttl_amt")) /  load;		
		
		if(t5R>0) CellValue2(t5R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s5R,"ttl_amt")) /  load;
		if(t6R>0) CellValue2(t6R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s6R,"ttl_amt")) /  load;
		// BKG OP TEU
		if(t8R>0) CellValue2(t8R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s8R,"ttl_amt"))/   load;
	}

}

function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
		var loadC   = 0; // Load
		var supplyC = 0; // Supply
		var revC    = 0; // Revenue

		var t1C = 0; // L/F = (Load / Supply) * 100
		var t2C = 0; // RPB = Revenue / Load

		var s3C = 0; // Cost1 Total
		var t3C = 0; // Cost1/TEU = Cost1 Total / Load
		var s4C = 0; // CM(Net Revenue) Total
		var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		var s7C = 0; // Branch CM(Net Revenue) Total
		var t7C = 0; // Branch CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load		

		var s5C = 0; // OP Cost Total(excluding interest)
		var t5C = 0; // OP Cost(excluding interest) /TEU
		
		var s6C = 0; // OP(Operating Profit) Total
		var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
				
		var s8C = 0; // OP(excluding interest)
		var t8C = 0; // OP(excluding)/TEU

		var arrCnt = gHeadCode2.length;
		for (var i=0; i<arrCnt; i++) {
			if (gHeadCode2[i] == "LOAD0000") { loadC   = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "BSA00000") { supplyC = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "REVENUE0") { revC    = i + fixHeadCnt2; }

			if (gHeadCode2[i] == "LOADFACT") { t1C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "RPB00000") { t2C = i + fixHeadCnt2; }

			if (gHeadCode2[i] == "CMCOST00") { s3C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "CMCB0000") { t3C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "CMCTOTAL") { s4C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "CMB00000") { t4C = i + fixHeadCnt2; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
			if (gHeadCode2[i] == "BCMTOTAL") { s7C = i + fixHeadCnt2; }			
			if (gHeadCode2[i] == "BCMB0000") { t7C = i + fixHeadCnt2; }
			
			if (gHeadCode2[i] == "OPCOSTEX") { s5C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "OPCB0000") { t5C = i + fixHeadCnt2; }
			
			if (gHeadCode2[i] == "OPCTOTAL") { s6C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "OPB00000") { t6C = i + fixHeadCnt2; }
			
			if (gHeadCode2[i] == "BOPTTLEX") { s8C = i + fixHeadCnt2; }
			if (gHeadCode2[i] == "BOPB0000") { t8C = i + fixHeadCnt2; }
			
		}

		var Row = LastRow;
		
		supply = (CellValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
		load   = (CellValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));
        
		if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
		if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;
        //
		if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
		if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;
				
		if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
		if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
		if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
	}
}

function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
		var loadC   = 0; // Load
		var supplyC = 0; // Supply
		var revC    = 0; // Revenue

		var t1C = 0; // L/F = L/F = (Load / Supply) * 100
		var t2C = 0; // RPB = Revenue / Load

		var s3C = 0; // Cost1 Total
		var t3C = 0; // Cost1/TEU = Cost1 Total / Load
		var s4C = 0; // CM(Net Revenue) Total
		var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI			
		var s7C = 0; // Branch CM(Net Revenue) Total
		var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

		var s5C = 0; // OP Cost Total(excluding interest)
		var t5C = 0; // OP Cost(excluding interest) /TEU
		
		var s6C = 0; // OP(Operating Profit) Total
		var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
				
		var s8C = 0; // OP(excluding interest)
		var t8C = 0; // OP(excluding)/TEU
		
		var arrCnt = gHeadCode3.length;
		
		for (var i=0; i<arrCnt; i++) {
			if (gHeadCode3[i] == "LOAD0000") { loadC   = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "BSA00000") { supplyC = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "REVENUE0") { revC    = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "LOADFACT") { t1C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "RPB00000") { t2C = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "CMCOST00") { s3C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMCB0000") { t3C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMCTOTAL") { s4C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "CMB00000") { t4C = i + fixHeadCnt3; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
			if (gHeadCode3[i] == "BCMTOTAL") { s7C = i + fixHeadCnt3; }			
			if (gHeadCode3[i] == "BCMB0000") { t7C = i + fixHeadCnt3; }

			if (gHeadCode3[i] == "OPCOSTEX") { s5C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "OPCB0000") { t5C = i + fixHeadCnt3; }
			
			if (gHeadCode3[i] == "OPCTOTAL") { s6C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "OPB00000") { t6C = i + fixHeadCnt3; }
			
			if (gHeadCode3[i] == "BOPTTLEX") { s8C = i + fixHeadCnt3; }
			if (gHeadCode3[i] == "BOPB0000") { t8C = i + fixHeadCnt3; }
			
		}

		var Row = LastRow;

		supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
		load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

		if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
		if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

		if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
		if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;		
		
		if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
		if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
		if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
	}
}

function sheet7_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
		var loadC   = 0; // Load
		var supplyC = 0; // Supply
		var revC    = 0; // Revenue

		var t1C = 0; // L/F = L/F = (Load / Supply) * 100
		var t2C = 0; // RPB = Revenue / Load

		var s3C = 0; // Cost1 Total
		var t3C = 0; // Cost1/TEU = Cost1 Total / Load
		var s4C = 0; // CM(Net Revenue) Total
		var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI			
		var s7C = 0; // Branch CM(Net Revenue) Total
		var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

		var s5C = 0; // OP Cost Total(excluding interest)
		var t5C = 0; // OP Cost(excluding interest) /TEU
		
		var s6C = 0; // OP(Operating Profit) Total
		var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
				
		var s8C = 0; // OP(excluding interest)
		var t8C = 0; // OP(excluding)/TEU

		var arrCnt = gHeadCode3.length;
		for (var i=0; i<arrCnt; i++) {
			if (gHeadCode3[i] == "LOAD0000") { loadC   = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "BSA00000") { supplyC = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "REVENUE0") { revC    = i + fixHeadCnt7; }

			if (gHeadCode3[i] == "LOADFACT") { t1C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "RPB00000") { t2C = i + fixHeadCnt7; }

			if (gHeadCode3[i] == "CMCOST00") { s3C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "CMCB0000") { t3C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "CMCTOTAL") { s4C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "CMB00000") { t4C = i + fixHeadCnt7; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
			if (gHeadCode3[i] == "BCMTOTAL") { s7C = i + fixHeadCnt7; }			
			if (gHeadCode3[i] == "BCMB0000") { t7C = i + fixHeadCnt7; }
			
			if (gHeadCode3[i] == "OPCOSTEX") { s5C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "OPCB0000") { t5C = i + fixHeadCnt7; }
			
			if (gHeadCode3[i] == "OPCTOTAL") { s6C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "OPB00000") { t6C = i + fixHeadCnt7; }
			
			if (gHeadCode3[i] == "BOPTTLEX") { s8C = i + fixHeadCnt7; }
			if (gHeadCode3[i] == "BOPB0000") { t8C = i + fixHeadCnt7; }
			
			fixHeadCnt7
		}

		var Row = LastRow;

		supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
		load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

		if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
		if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

		if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
		if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;		
		
		if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
		if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
		if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
	}
}

function sheet4_OnSearchEnd(sheetObj,ErrMsg) {
    var fixCnt = fixHeadCnt4 - 1; //가변길이 뒤 Total 필드 제외
    var supply = 0;
    var load = 0;
    
    with(sheetObj) {
        //L/F, RPB 합계 재계산
        var loadR   = FindText("stnd_cost_cd","LOAD0000"); // Load
        var supplyR = FindText("stnd_cost_cd","BSA00000"); // Supply
        var revR    = FindText("stnd_cost_cd","REVENUE0"); // Revenue

        var t1R = FindText("stnd_cost_cd","LOADFACT"); // L/F = (Load / Supply) * 100
        var t2R = FindText("stnd_cost_cd","RPB00000"); // RPB = Revenue / Load

        var s3R = FindText("stnd_cost_cd","CMCOST00"); // Cost1 Total
        var t3R = FindText("stnd_cost_cd","CMCB0000"); // Cost1/TEU = Cost1 Total / Load
        var s4R = FindText("stnd_cost_cd","CMCTOTAL"); // CM(Net Revenue) Total
        var t4R = FindText("stnd_cost_cd","CMB00000"); // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
         
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI
        var s7R = FindText("stnd_cost_cd","BCMTOTAL"); // Branch CM(Net Revenue) Total
        var t7R = FindText("stnd_cost_cd","BCMB0000"); // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load      
        
        var s5R = FindText("stnd_cost_cd","OPCOSTEX"); // OP Cost Total(excluding interest)
        var t5R = FindText("stnd_cost_cd","OPCB0000"); // OP Cost(excluding interest) /TEU
        
        var s6R = FindText("stnd_cost_cd","OPCTOTAL"); // OP(Operating Profit) Total
        var t6R = FindText("stnd_cost_cd","OPB00000"); // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load

        var s7R = FindText("stnd_cost_cd","OPUTOTAL"); // BU OP(Operationg Profit) Total
        
        var s8R = FindText("stnd_cost_cd","BOPTTLEX"); // OP(excluding interest)
        var t8R = FindText("stnd_cost_cd","BOPB0000"); // OP(excluding)/TEU
     
        for (var i=fixCnt; i<=LastCol; i++) { //3은 seq, stnd_cost_cd, itm_desc 제외
            if (CellValue(1,i) == "H/H" || CellValue(1,i) == "B/H" || CellValue(1,i) == "M/B" || CellValue(1,i) == "TOT") {
                supply = (CellValue(supplyR,i)==null) ? 0 : CellValue(supplyR,i);
                load   = (CellValue(loadR,i)==null) ? 0 : CellValue(loadR,i);

                if (t1R > -1) CellValue2(t1R,i) = (supply==0) ? 0 : (load / supply) * 100;
                if (t2R > -1 && revR > -1) CellValue2(t2R,i) = (load==0) ? 0 : CellValue(revR,i) / load;

                if (t3R > -1 && s3R > -1) CellValue2(t3R,i) = (load==0) ? 0 : CellValue(s3R,i) / load;
                if (t4R > -1 && s4R > -1) CellValue2(t4R,i) = (load==0) ? 0 : CellValue(s4R,i) / load;
                
                //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI               
                if (t7R > -1 && s7R > -1) CellValue2(t7R,i) = (load==0) ? 0 : CellValue(s7R,i) / load;              
                //OP Cost(excluding interest) /TEU
                if (t5R > -1 && s5R > -1) CellValue2(t5R,i) = (load==0) ? 0 : CellValue(s5R,i) / load;
                if (t6R > -1 && s6R > -1) CellValue2(t6R,i) = (load==0) ? 0 : CellValue(s6R,i) / load;

                //OP(excluding)/TEU
                if (t8R > -1 && s8R > -1) CellValue2(t8R,i) = (load==0) ? 0 : CellValue(s8R,i) / load;  
            }
        }

        //Total 재계산
        supply = (CellValue(supplyR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(supplyR,"ttl_amt"));
        load   = (CellValue(loadR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(loadR,"ttl_amt"));
        if(t1R>0) CellValue2(t1R,"ttl_amt") = (supply==0) ? 0 : (load / supply) * 100;
        if(t2R>0) CellValue2(t2R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(revR,"ttl_amt")) /  load;
        if(t3R>0) CellValue2(t3R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s3R,"ttl_amt")) /  load;
        if(t4R>0) CellValue2(t4R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s4R,"ttl_amt")) /  load;
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI       
        if(t7R>0) CellValue2(t7R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s7R,"ttl_amt")) /  load;     
        //OP Cost(excluding interest) /TEU
        if(s5R>0) CellValue2(t5R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s5R,"ttl_amt")) /  load;
        if(t6R>0) CellValue2(t6R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s6R,"ttl_amt")) /  load;
        
        // OP(excluding)/TEU
        if(t8R>0) CellValue2(t8R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s8R,"ttl_amt")) /  load;
    }

}

function sheet5_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC   = 0; // Load
        var supplyC = 0; // Supply
        var revC    = 0; // Revenue

        var t1C = 0; // L/F = (Load / Supply) * 100
        var t2C = 0; // RPB = Revenue / Load

        var s3C = 0; // Cost1 Total
        var t3C = 0; // Cost1/TEU = Cost1 Total / Load
        var s4C = 0; // CM(Net Revenue) Total
        var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI   
        var s7C = 0; // Branch CM(Net Revenue) Total
        var t7C = 0; // Branch CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load       
        
        var s5C = 0; // OP Cost Total(excluding interest)
        var t5C = 0; // OP Cost(excluding interest) /TEU
        
        var s6C = 0; // OP(Operating Profit) Total
        var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
                
        var s8C = 0; // OP(excluding interest)
        var t8C = 0; // OP(excluding)/TEU


        var arrCnt = gHeadCode5.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode5[i] == "LOAD0000") { loadC   = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "BSA00000") { supplyC = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "REVENUE0") { revC    = i + fixHeadCnt5; }

            if (gHeadCode5[i] == "LOADFACT") { t1C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "RPB00000") { t2C = i + fixHeadCnt5; }

            if (gHeadCode5[i] == "CMCOST00") { s3C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "CMCB0000") { t3C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "CMCTOTAL") { s4C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "CMB00000") { t4C = i + fixHeadCnt5; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI   
            if (gHeadCode5[i] == "BCMTOTAL") { s7C = i + fixHeadCnt5; }         
            if (gHeadCode5[i] == "BCMB0000") { t7C = i + fixHeadCnt5; }
            
            if (gHeadCode5[i] == "OPCOSTEX") { s5C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "OPCB0000") { t5C = i + fixHeadCnt5; }
            
            if (gHeadCode5[i] == "OPCTOTAL") { s6C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "OPB00000") { t6C = i + fixHeadCnt5; }
            
            if (gHeadCode5[i] == "BOPTTLEX") { s8C = i + fixHeadCnt5; }
            if (gHeadCode5[i] == "BOPB0000") { t8C = i + fixHeadCnt5; }
            
        }

        var Row = LastRow;
        
        supply = (CellValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
        load   = (CellValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));
        
        if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
        if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;
        //
        if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
        if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI   
        if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;
                
        if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
        if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
        if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
        
        
    }
}

function sheet6_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC   = 0; // Load
        var supplyC = 0; // Supply
        var revC    = 0; // Revenue

        var t1C = 0; // L/F = L/F = (Load / Supply) * 100
        var t2C = 0; // RPB = Revenue / Load

        var s3C = 0; // Cost1 Total
        var t3C = 0; // Cost1/TEU = Cost1 Total / Load
        var s4C = 0; // CM(Net Revenue) Total
        var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI           
        var s7C = 0; // Branch CM(Net Revenue) Total
        var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

        var s5C = 0; // OP Cost Total(excluding interest)
        var t5C = 0; // OP Cost(excluding interest) /TEU
        
        var s6C = 0; // OP(Operating Profit) Total
        var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
                
        var s8C = 0; // OP(excluding interest)
        var t8C = 0; // OP(excluding)/TEU

        var arrCnt = gHeadCode6.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode6[i] == "LOAD0000") { loadC   = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "BSA00000") { supplyC = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "REVENUE0") { revC    = i + fixHeadCnt6; }

            if (gHeadCode6[i] == "LOADFACT") { t1C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "RPB00000") { t2C = i + fixHeadCnt6; }

            if (gHeadCode6[i] == "CMCOST00") { s3C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "CMCB0000") { t3C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "CMCTOTAL") { s4C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "CMB00000") { t4C = i + fixHeadCnt6; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI   
            if (gHeadCode6[i] == "BCMTOTAL") { s7C = i + fixHeadCnt6; }         
            if (gHeadCode6[i] == "BCMB0000") { t7C = i + fixHeadCnt6; }

            if (gHeadCode6[i] == "OPCOSTEX") { s5C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "OPCB0000") { t5C = i + fixHeadCnt6; }
            
            if (gHeadCode6[i] == "OPCTOTAL") { s6C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "OPB00000") { t6C = i + fixHeadCnt6; }
            
            if (gHeadCode6[i] == "BOPTTLEX") { s8C = i + fixHeadCnt6; }
            if (gHeadCode6[i] == "BOPB0000") { t8C = i + fixHeadCnt6; }
        }

        var Row = LastRow;

        supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
        load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

        if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
        if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

        if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
        if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI   
        if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;       
        
        if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
        if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
        if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
    }
}

function sheet8_OnSearchEnd(sheetObj,ErrMsg) {
	with(sheetObj) {
		var loadC   = 0; // Load
		var supplyC = 0; // Supply
		var revC    = 0; // Revenue

		var t1C = 0; // L/F = L/F = (Load / Supply) * 100
		var t2C = 0; // RPB = Revenue / Load

		var s3C = 0; // Cost1 Total
		var t3C = 0; // Cost1/TEU = Cost1 Total / Load
		var s4C = 0; // CM(Net Revenue) Total
		var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI			
		var s7C = 0; // Branch CM(Net Revenue) Total
		var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

		var s5C = 0; // OP Cost Total(excluding interest)
		var t5C = 0; // OP Cost(excluding interest) /TEU
		
		var s6C = 0; // OP(Operating Profit) Total
		var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
				
		var s8C = 0; // OP(excluding interest)
		var t8C = 0; // OP(excluding)/TEU

		var arrCnt = gHeadCode6.length;
		for (var i=0; i<arrCnt; i++) {
			if (gHeadCode8[i] == "LOAD0000") { loadC   = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "BSA00000") { supplyC = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "REVENUE0") { revC    = i + fixHeadCnt8; }

			if (gHeadCode8[i] == "LOADFACT") { t1C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "RPB00000") { t2C = i + fixHeadCnt8; }

			if (gHeadCode8[i] == "CMCOST00") { s3C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "CMCB0000") { t3C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "CMCTOTAL") { s4C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "CMB00000") { t4C = i + fixHeadCnt8; }

            //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
			if (gHeadCode8[i] == "BCMTOTAL") { s7C = i + fixHeadCnt8; }			
			if (gHeadCode8[i] == "BCMB0000") { t7C = i + fixHeadCnt8; }
			
			if (gHeadCode8[i] == "OPCOSTEX") { s5C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "OPCB0000") { t5C = i + fixHeadCnt8; }
			
			if (gHeadCode8[i] == "OPCTOTAL") { s6C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "OPB00000") { t6C = i + fixHeadCnt8; }
			
			if (gHeadCode8[i] == "BOPTTLEX") { s8C = i + fixHeadCnt8; }
			if (gHeadCode8[i] == "BOPB0000") { t8C = i + fixHeadCnt8; }
			
		}

		var Row = LastRow;

		supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
		load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

		if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
		if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

		if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
		if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
		
		//Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI	
		if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;		
		
		if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
		if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
		if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
	}
}

function sheet9_OnSearchEnd(sheetObj,ErrMsg) {
    var fixCnt = fixHeadCnt9 - 1; //가변길이 뒤 Total 필드 제외
    var supply = 0;
    var load = 0;
    
    with(sheetObj) {
        //L/F, RPB 합계 재계산
        var loadR   = FindText("stnd_cost_cd","LOAD0000"); // Load
        var supplyR = FindText("stnd_cost_cd","BSA00000"); // Supply
        var revR    = FindText("stnd_cost_cd","REVENUE0"); // Revenue

        var t1R = FindText("stnd_cost_cd","LOADFACT"); // L/F = (Load / Supply) * 100
        var t2R = FindText("stnd_cost_cd","RPB00000"); // RPB = Revenue / Load

        var s3R = FindText("stnd_cost_cd","CMCOST00"); // Cost1 Total
        var t3R = FindText("stnd_cost_cd","CMCB0000"); // Cost1/TEU = Cost1 Total / Load
        var s4R = FindText("stnd_cost_cd","CMCTOTAL"); // CM(Net Revenue) Total
        var t4R = FindText("stnd_cost_cd","CMB00000"); // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
         
        var s7R = FindText("stnd_cost_cd","BCMTOTAL"); // Branch CM(Net Revenue) Total
        var t7R = FindText("stnd_cost_cd","BCMB0000"); // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load      
        
        var s5R = FindText("stnd_cost_cd","OPCOSTEX"); // OP Cost Total(excluding interest)
        var t5R = FindText("stnd_cost_cd","OPCB0000"); // OP Cost(excluding interest) /TEU
        
        var s6R = FindText("stnd_cost_cd","OPCTOTAL"); // OP(Operating Profit) Total
        var t6R = FindText("stnd_cost_cd","OPB00000"); // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load

        var s7R = FindText("stnd_cost_cd","OPUTOTAL"); // BU OP(Operationg Profit) Total
        
        var s8R = FindText("stnd_cost_cd","BOPTTLEX"); // OP(excluding interest)
        var t8R = FindText("stnd_cost_cd","BOPB0000"); // OP(excluding)/TEU
     
        for (var i=fixCnt; i<=LastCol; i++) { //3은 seq, stnd_cost_cd, itm_desc 제외
            if (CellValue(1,i) == "H/H" || CellValue(1,i) == "B/H" || CellValue(1,i) == "M/B" || CellValue(1,i) == "TOT") {
                supply = (CellValue(supplyR,i)==null) ? 0 : CellValue(supplyR,i);
                load   = (CellValue(loadR,i)==null) ? 0 : CellValue(loadR,i);

                if (t1R > -1) CellValue2(t1R,i) = (supply==0) ? 0 : (load / supply) * 100;
                if (t2R > -1 && revR > -1) CellValue2(t2R,i) = (load==0) ? 0 : CellValue(revR,i) / load;

                if (t3R > -1 && s3R > -1) CellValue2(t3R,i) = (load==0) ? 0 : CellValue(s3R,i) / load;
                if (t4R > -1 && s4R > -1) CellValue2(t4R,i) = (load==0) ? 0 : CellValue(s4R,i) / load;
                
                //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI               
                if (t7R > -1 && s7R > -1) CellValue2(t7R,i) = (load==0) ? 0 : CellValue(s7R,i) / load;              
                //OP Cost(excluding interest) /TEU
                if (t5R > -1 && s5R > -1) CellValue2(t5R,i) = (load==0) ? 0 : CellValue(s5R,i) / load;
                if (t6R > -1 && s6R > -1) CellValue2(t6R,i) = (load==0) ? 0 : CellValue(s6R,i) / load;

                //OP(excluding)/TEU
                if (t8R > -1 && s8R > -1) CellValue2(t8R,i) = (load==0) ? 0 : CellValue(s8R,i) / load;  
            }
        }

        //Total 재계산
        supply = (CellValue(supplyR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(supplyR,"ttl_amt"));
        load   = (CellValue(loadR,"ttl_amt")==null) ? 0 : parseFloat(CellValue(loadR,"ttl_amt"));
        if(t1R>0) CellValue2(t1R,"ttl_amt") = (supply==0) ? 0 : (load / supply) * 100;
        if(t2R>0) CellValue2(t2R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(revR,"ttl_amt")) /  load;
        if(t3R>0) CellValue2(t3R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s3R,"ttl_amt")) /  load;
        if(t4R>0) CellValue2(t4R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s4R,"ttl_amt")) /  load;
        
        //Branch CM의 Per TEU 뱐영 2007.07.30 BY LHI       
        if(t7R>0) CellValue2(t7R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s7R,"ttl_amt")) /  load;     
        //OP Cost(excluding interest) /TEU
        if(s5R>0) CellValue2(t5R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s5R,"ttl_amt")) /  load;
        if(t6R>0) CellValue2(t6R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s6R,"ttl_amt")) /  load;
        
        // OP(excluding)/TEU
        if(t8R>0) CellValue2(t8R,"ttl_amt") = (load==0) ? 0 : parseFloat(CellValue(s8R,"ttl_amt")) /  load;
    }

}

function sheet10_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC   = 0; // Load
        var supplyC = 0; // Supply
        var revC    = 0; // Revenue

        var t1C = 0; // L/F = (Load / Supply) * 100
        var t2C = 0; // RPB = Revenue / Load

        var s3C = 0; // Cost1 Total
        var t3C = 0; // Cost1/TEU = Cost1 Total / Load
        var s4C = 0; // CM(Net Revenue) Total
        var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
        
        var s7C = 0; // Branch CM(Net Revenue) Total
        var t7C = 0; // Branch CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load       
        
        var s5C = 0; // OP Cost Total(excluding interest)
        var t5C = 0; // OP Cost(excluding interest) /TEU
        
        var s6C = 0; // OP(Operating Profit) Total
        var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
                
        var s8C = 0; // OP(excluding interest)
        var t8C = 0; // OP(excluding)/TEU


        var arrCnt = gHeadCode10.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode5[i] == "LOAD0000") { loadC   = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "BSA00000") { supplyC = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "REVENUE0") { revC    = i + fixHeadCnt10; }

            if (gHeadCode5[i] == "LOADFACT") { t1C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "RPB00000") { t2C = i + fixHeadCnt10; }

            if (gHeadCode5[i] == "CMCOST00") { s3C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "CMCB0000") { t3C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "CMCTOTAL") { s4C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "CMB00000") { t4C = i + fixHeadCnt10; }

            if (gHeadCode5[i] == "BCMTOTAL") { s7C = i + fixHeadCnt10; }         
            if (gHeadCode5[i] == "BCMB0000") { t7C = i + fixHeadCnt10; }
            
            if (gHeadCode5[i] == "OPCOSTEX") { s5C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "OPCB0000") { t5C = i + fixHeadCnt10; }
            
            if (gHeadCode5[i] == "OPCTOTAL") { s6C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "OPB00000") { t6C = i + fixHeadCnt10; }
            
            if (gHeadCode5[i] == "BOPTTLEX") { s8C = i + fixHeadCnt10; }
            if (gHeadCode5[i] == "BOPB0000") { t8C = i + fixHeadCnt10; }
            
        }

        var Row = LastRow;
        
        supply = (CellValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
        load   = (CellValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));
        
        if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
        if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;
        //
        if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
        if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
        
        if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;
                
        if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
        if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
        if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
        
        
    }
}

function sheet11_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC   = 0; // Load
        var supplyC = 0; // Supply
        var revC    = 0; // Revenue

        var t1C = 0; // L/F = L/F = (Load / Supply) * 100
        var t2C = 0; // RPB = Revenue / Load

        var s3C = 0; // Cost1 Total
        var t3C = 0; // Cost1/TEU = Cost1 Total / Load
        var s4C = 0; // CM(Net Revenue) Total
        var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
        
        var s7C = 0; // Branch CM(Net Revenue) Total
        var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

        var s5C = 0; // OP Cost Total(excluding interest)
        var t5C = 0; // OP Cost(excluding interest) /TEU
        
        var s6C = 0; // OP(Operating Profit) Total
        var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
                
        var s8C = 0; // OP(excluding interest)
        var t8C = 0; // OP(excluding)/TEU

        var arrCnt = gHeadCode11.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode6[i] == "LOAD0000") { loadC   = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "BSA00000") { supplyC = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "REVENUE0") { revC    = i + fixHeadCnt11; }

            if (gHeadCode6[i] == "LOADFACT") { t1C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "RPB00000") { t2C = i + fixHeadCnt11; }

            if (gHeadCode6[i] == "CMCOST00") { s3C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "CMCB0000") { t3C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "CMCTOTAL") { s4C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "CMB00000") { t4C = i + fixHeadCnt11; }

            if (gHeadCode6[i] == "BCMTOTAL") { s7C = i + fixHeadCnt11; }         
            if (gHeadCode6[i] == "BCMB0000") { t7C = i + fixHeadCnt11; }

            if (gHeadCode6[i] == "OPCOSTEX") { s5C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "OPCB0000") { t5C = i + fixHeadCnt11; }
            
            if (gHeadCode6[i] == "OPCTOTAL") { s6C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "OPB00000") { t6C = i + fixHeadCnt11; }
            
            if (gHeadCode6[i] == "BOPTTLEX") { s8C = i + fixHeadCnt11; }
            if (gHeadCode6[i] == "BOPB0000") { t8C = i + fixHeadCnt11; }
        }

        var Row = LastRow;

        supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
        load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

        if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
        if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

        if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
        if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
        
        if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;       
        
        if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
        if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
        if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
    }
}

function sheet12_OnSearchEnd(sheetObj,ErrMsg) {
    with(sheetObj) {
        var loadC   = 0; // Load
        var supplyC = 0; // Supply
        var revC    = 0; // Revenue

        var t1C = 0; // L/F = L/F = (Load / Supply) * 100
        var t2C = 0; // RPB = Revenue / Load

        var s3C = 0; // Cost1 Total
        var t3C = 0; // Cost1/TEU = Cost1 Total / Load
        var s4C = 0; // CM(Net Revenue) Total
        var t4C = 0; // CM(Net Revenue)/TEU = CM(Net Revenue) Total / Load
        
        var s7C = 0; // Branch CM(Net Revenue) Total
        var t7C = 0; // Branch CM(Net Revenue)/TEU = Branch CM(Net Revenue) Total / Load

        var s5C = 0; // OP Cost Total(excluding interest)
        var t5C = 0; // OP Cost(excluding interest) /TEU
        
        var s6C = 0; // OP(Operating Profit) Total
        var t6C = 0; // OP(Operating Profit)/TEU = OP(Operating Profit) Total / Load
                
        var s8C = 0; // OP(excluding interest)
        var t8C = 0; // OP(excluding)/TEU

        var arrCnt = gHeadCode12.length;
        for (var i=0; i<arrCnt; i++) {
            if (gHeadCode8[i] == "LOAD0000") { loadC   = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "BSA00000") { supplyC = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "REVENUE0") { revC    = i + fixHeadCnt12; }

            if (gHeadCode8[i] == "LOADFACT") { t1C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "RPB00000") { t2C = i + fixHeadCnt12; }

            if (gHeadCode8[i] == "CMCOST00") { s3C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "CMCB0000") { t3C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "CMCTOTAL") { s4C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "CMB00000") { t4C = i + fixHeadCnt12; }

            if (gHeadCode8[i] == "BCMTOTAL") { s7C = i + fixHeadCnt12; }         
            if (gHeadCode8[i] == "BCMB0000") { t7C = i + fixHeadCnt12; }
            
            if (gHeadCode8[i] == "OPCOSTEX") { s5C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "OPCB0000") { t5C = i + fixHeadCnt12; }
            
            if (gHeadCode8[i] == "OPCTOTAL") { s6C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "OPB00000") { t6C = i + fixHeadCnt12; }
            
            if (gHeadCode8[i] == "BOPTTLEX") { s8C = i + fixHeadCnt12; }
            if (gHeadCode8[i] == "BOPB0000") { t8C = i + fixHeadCnt12; }
            
        }

        var Row = LastRow;

        supply = (SumValue(0,supplyC)==null) ? 0 : parseFloat(SumValue(0,supplyC));
        load   = (SumValue(0,loadC)==null) ? 0 : parseFloat(SumValue(0,loadC));

        if (t1C > 0 && loadC > 0) CellValue2(Row,t1C) = (supply==0) ? 0 : (parseFloat(SumValue(0,loadC)) / supply) * 100;
        if (t2C > 0 && revC > 0) CellValue2(Row,t2C) = (load==0) ? 0 : parseFloat(SumValue(0,revC)) / load;

        if (t3C > 0 && s3C > 0) CellValue2(Row,t3C) = (load==0) ? 0 : parseFloat(SumValue(0,s3C)) / load;
        if (t4C > 0 && s4C > 0) CellValue2(Row,t4C) = (load==0) ? 0 : parseFloat(SumValue(0,s4C)) / load;
        
        if (t7C > 0 && s7C > 0) CellValue2(Row,t7C) = (load==0) ? 0 : parseFloat(SumValue(0,s7C)) / load;       
        
        if (t5C > 0 && s5C > 0) CellValue2(Row,t5C) = (load==0) ? 0 : parseFloat(SumValue(0,s5C)) / load;
        if (t6C > 0 && s6C > 0) CellValue2(Row,t6C) = (load==0) ? 0 : parseFloat(SumValue(0,s6C)) / load;
        if (t8C > 0 && s8C > 0) CellValue2(Row,t8C) = (load==0) ? 0 : parseFloat(SumValue(0,s8C)) / load;
    }
}

/**
* trade변경시 R.Lane combo변경
*/
function f_trd_cd_OnChange(obj, code, text) {
	if (loadingMode == true)
		return;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	var tradeCombo = document.getElementById("f_trd_cd");
	var rlaneCombo = document.getElementById("f_rlane_cd");
	var iasRgnCombo = document.getElementById("f_ias_rgn_cd");
		
	if (obj.Text != "") {
		
		formObj.f_cmd.value = SEARCHLIST11;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS4.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], formObj.f_rlane_cd, "code", "code");
			ComXml2ComboItem(arrXml[1], formObj.f_sub_trd_cd, "code", "code");	
			
			// Adjusted P&L Tab
			if(beforetab == "1") {
				if(tradeCombo.Code == "COM") {
					rlaneCombo.InsertItem(-1, 'CDMCO', 'CDMCO');
					rlaneCombo.InsertItem(-1, 'CNTLY', 'CNTLY');
				} else if(tradeCombo.Code != "All") {
					rlaneCombo.InsertItem(-1, 'CNTTS', 'CNTTS');
					rlaneCombo.InsertItem(-1, 'CNTMR', 'CNTMR');
				}
			}
			
			//trade가 IAS가 아니면 비활성화
			if(code == "IAS") {
				iasRgnCombo.Enable = true;
			} else {
				iasRgnCombo.Enable = false;				
			}
		}
		
		formObj.f_rlane_cd.Index = 0;
		formObj.f_sub_trd_cd.Index = 0;
		formObj.f_ias_rgn_cd.Index = 0;
	}
}


/**
 * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
 */
function setPeriod(obj) {
	ComMasSetPeriod(obj);
}

//화면의 Profit View 처리
function f_pro_vw_OnChange(obj) {
    setCobDisplay();
    
	var profitLevelCombo 	= document.getElementById("f_pro_lvl");

    if(obj.Code == "R") {
    	profitLevelCombo.Code = "C";
    	profitLevelCombo.Enable = false;
    } else {
    	profitLevelCombo.Enable = true;
    }
    
    //Profit Level 에 OP 권한 확인
    ComMasOpCheckOfcCd(document.form.f_pro_lvl, ComGetObjValue(document.form.f_usr_lgn_ofc_cd));
}

//화면의 Profit Level 처리
function f_pro_lvl_OnChange(obj) {
    setCobDisplay();
    ias_change();
    
}

//화면의 combo display 처리
function setCobDisplay() {
	var formObj = document.form;

	if (ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O") { // Trade Profit + OP
		div_display1.style.display = "inline";
		div_display2.style.display = "inline";
		
		if(formObj.f_ias_flg.checked){
			div_display3.style.display = "none";
		}else{
			div_display3.style.display = "inline";
		}
		
		if(beforetab == "0") {
			div_chtBiz.style.display = "inline";
			div_chtBiz_a.style.display = "none";
		} else {
			div_chtBiz.style.display = "none";
			div_chtBiz_a.style.display = "inline";
		}
		
		showText();
	} else { 
		div_display1.style.display = "none";
		div_display2.style.display = "none";
		div_display3.style.display = "none";
		div_text.style.display = "none";
		div_chtBiz.style.display = "none";
		div_chtBiz_a.style.display = "none";
	}
	
}

function showText(){
    var formObj = document.form; 
    if(formObj.f_pro_obj.Index == 2){		
    //if(formObj.f_pro_obj.selectedIndex == 2){
        div_text.style.display = "inline";
    } else {
        div_text.style.display = "none";
    }
}
//화면의 Zoom 처리
function setZoom() {
	if (sheet_selno == "1") { 
		if (zoomFlag1 == "open") {
		    div_zoom_in1.style.display  = "none";  
		    div_zoom_out1.style.display = "inline";
		} else if (zoomFlag1 == "close") {
		    div_zoom_in1.style.display  = "inline"; 
		    div_zoom_out1.style.display = "none";
		}
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";

		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "2") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		if (zoomFlag2 == "open") {
		    div_zoom_in2.style.display  = "none";  
		    div_zoom_out2.style.display = "inline";
		} else if (zoomFlag2 == "close") {
		    div_zoom_in2.style.display  = "inline"; 
		    div_zoom_out2.style.display = "none";
		}
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";

		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "3") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		if (zoomFlag3 == "open") {
		    div_zoom_in3.style.display  = "none";  
		    div_zoom_out3.style.display = "inline";
		} else if (zoomFlag3 == "close") {
		    div_zoom_in3.style.display  = "inline"; 
		    div_zoom_out3.style.display = "none";
		}
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";

		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "4") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";

		if (zoomFlag4 == "open") {
		    div_zoom_in4.style.display  = "none";  
		    div_zoom_out4.style.display = "inline";
		} else if (zoomFlag4 == "close") {
		    div_zoom_in4.style.display  = "inline"; 
		    div_zoom_out4.style.display = "none";
		}
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "5") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
        
		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		if (zoomFlag5 == "open") {
		    div_zoom_in5.style.display  = "none";  
		    div_zoom_out5.style.display = "inline";
		} else if (zoomFlag5 == "close") {
		    div_zoom_in5.style.display  = "inline"; 
		    div_zoom_out5.style.display = "none";
		}
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "6") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
				
		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		if (zoomFlag6 == "open") {
		    div_zoom_in6.style.display  = "none";  
		    div_zoom_out6.style.display = "inline";
		} else if (zoomFlag6 == "close") {
		    div_zoom_in6.style.display  = "inline"; 
		    div_zoom_out6.style.display = "none";
		}
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "7") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
		if (zoomFlag7 == "open") {
            div_zoom_in7.style.display  = "none";  
            div_zoom_out7.style.display = "inline";
        } else if (zoomFlag7 == "close") {
            div_zoom_in7.style.display  = "inline"; 
            div_zoom_out7.style.display = "none";
        }
		
		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		div_zoom_in8.style.display  = "none";
		div_zoom_out8.style.display = "none";
		
		div_zoom_in9.style.display  = "none";
		div_zoom_out9.style.display = "none";
		div_zoom_in10.style.display  = "none";
		div_zoom_out10.style.display = "none";
		div_zoom_in11.style.display  = "none";
		div_zoom_out11.style.display = "none";
		div_zoom_in12.style.display  = "none";
		div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "8") { 
		div_zoom_in1.style.display  = "none";
		div_zoom_out1.style.display = "none";
		div_zoom_in2.style.display  = "none";
		div_zoom_out2.style.display = "none";
		div_zoom_in3.style.display  = "none";
		div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
				
		div_zoom_in4.style.display  = "none";
		div_zoom_out4.style.display = "none";
		div_zoom_in5.style.display  = "none";
		div_zoom_out5.style.display = "none";
		div_zoom_in6.style.display  = "none";
		div_zoom_out6.style.display = "none";
		if (zoomFlag8 == "open") {
			div_zoom_in8.style.display  = "none";  
			div_zoom_out8.style.display = "inline";
		} else if (zoomFlag8 == "close") {
			div_zoom_in8.style.display  = "inline"; 
			div_zoom_out8.style.display = "none";
		}
		
		div_zoom_in9.style.display  = "none";
        div_zoom_out9.style.display = "none";
        div_zoom_in10.style.display  = "none";
        div_zoom_out10.style.display = "none";
        div_zoom_in11.style.display  = "none";
        div_zoom_out11.style.display = "none";
        div_zoom_in12.style.display  = "none";
        div_zoom_out12.style.display = "none";
	} else if (sheet_selno == "9") { 
        div_zoom_in1.style.display  = "none";
        div_zoom_out1.style.display = "none";
        div_zoom_in2.style.display  = "none";
        div_zoom_out2.style.display = "none";
        div_zoom_in3.style.display  = "none";
        div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
        
        div_zoom_in4.style.display  = "none";
        div_zoom_out4.style.display = "none";
        div_zoom_in5.style.display  = "none";
        div_zoom_out5.style.display = "none";
        div_zoom_in6.style.display  = "none";
        div_zoom_out6.style.display = "none";
        div_zoom_in8.style.display  = "none";
        div_zoom_out8.style.display = "none";

        if (zoomFlag9 == "open") {
            div_zoom_in9.style.display  = "none";  
            div_zoom_out9.style.display = "inline";
        } else if (zoomFlag9 == "close") {
            div_zoom_in9.style.display  = "inline"; 
            div_zoom_out9.style.display = "none";
        }
        div_zoom_in10.style.display  = "none";
        div_zoom_out10.style.display = "none";
        div_zoom_in11.style.display  = "none";
        div_zoom_out11.style.display = "none";
        div_zoom_in12.style.display  = "none";
        div_zoom_out12.style.display = "none";
    } else if (sheet_selno == "10") {
        div_zoom_in1.style.display  = "none";
        div_zoom_out1.style.display = "none";
        div_zoom_in2.style.display  = "none";
        div_zoom_out2.style.display = "none";
        div_zoom_in3.style.display  = "none";
        div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
        
        div_zoom_in4.style.display  = "none";
        div_zoom_out4.style.display = "none";
        div_zoom_in5.style.display  = "none";
        div_zoom_out5.style.display = "none";
        div_zoom_in6.style.display  = "none";
        div_zoom_out6.style.display = "none";
        div_zoom_in8.style.display  = "none";
        div_zoom_out8.style.display = "none";
        
        div_zoom_in9.style.display  = "none";
        div_zoom_out9.style.display = "none";
        if (zoomFlag10 == "open") {
            div_zoom_in10.style.display  = "none";  
            div_zoom_out10.style.display = "inline";
        } else if (zoomFlag10 == "close") {
            div_zoom_in10.style.display  = "inline"; 
            div_zoom_out10.style.display = "none";
        }
        div_zoom_in11.style.display  = "none";
        div_zoom_out11.style.display = "none";
        div_zoom_in12.style.display  = "none";
        div_zoom_out12.style.display = "none";
    } else if (sheet_selno == "11") { 
        div_zoom_in1.style.display  = "none";
        div_zoom_out1.style.display = "none";
        div_zoom_in2.style.display  = "none";
        div_zoom_out2.style.display = "none";
        div_zoom_in3.style.display  = "none";
        div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
        
        div_zoom_in4.style.display  = "none";
        div_zoom_out4.style.display = "none";
        div_zoom_in5.style.display  = "none";
        div_zoom_out5.style.display = "none";
        div_zoom_in6.style.display  = "none";
        div_zoom_out6.style.display = "none";
        div_zoom_in8.style.display  = "none";
        div_zoom_out8.style.display = "none";	        
        
        div_zoom_in9.style.display  = "none";
        div_zoom_out9.style.display = "none";	        
        div_zoom_in10.style.display  = "none";
        div_zoom_out10.style.display = "none";
        if (zoomFlag11 == "open") {
            div_zoom_in11.style.display  = "none";  
            div_zoom_out11.style.display = "inline";
        } else if (zoomFlag11 == "close") {
            div_zoom_in11.style.display  = "inline"; 
            div_zoom_out11.style.display = "none";
        }
        div_zoom_in12.style.display  = "none";
        div_zoom_out12.style.display = "none";
    } else if (sheet_selno == "12") {
        div_zoom_in1.style.display  = "none";
        div_zoom_out1.style.display = "none";
        div_zoom_in2.style.display  = "none";
        div_zoom_out2.style.display = "none";
        div_zoom_in3.style.display  = "none";
        div_zoom_out3.style.display = "none";
        div_zoom_in7.style.display  = "none";
        div_zoom_out7.style.display = "none";
        
        div_zoom_in4.style.display  = "none";
        div_zoom_out4.style.display = "none";
        div_zoom_in5.style.display  = "none";
        div_zoom_out5.style.display = "none";
        div_zoom_in6.style.display  = "none";
        div_zoom_out6.style.display = "none";
        div_zoom_in8.style.display  = "none";
        div_zoom_out8.style.display = "none";
        
        div_zoom_in9.style.display  = "none";
        div_zoom_out9.style.display = "none";
        div_zoom_in10.style.display  = "none";
        div_zoom_out10.style.display = "none";
        div_zoom_in11.style.display  = "none";
        div_zoom_out11.style.display = "none";
        
        if (zoomFlag12 == "open") {
            div_zoom_in12.style.display  = "none";  
            div_zoom_out12.style.display = "inline";
        } else if (zoomFlag12 == "close") {
            div_zoom_in12.style.display  = "inline"; 
            div_zoom_out12.style.display = "none";
        }
    }
}

/**
* Office Level 변경시 Office combo변경
*/
function f_ofc_lvl_OnChange(obj, code){
	 if (loadingMode == true) return;  
	 chgOffice(obj);
}

/**
* 본부 콤보변경시... 
*/
function chgOffice(obj){
	 var formObj = document.form;
   var sheetObj = sheetObjects[0];
   
   if(obj.Text != ""){
   	formObj.f_cmd.value = SEARCHLIST13;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS4.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], formObj.f_ofc_cd, "code", "code");
		formObj.f_ofc_cd.Index=0;
   }
}

/*
 * 년, 월 데이터가 변경되면 ofc_cd리스트를 새로 가져온다
 */
function changeCostYrmon(val){
    if(val != '') chgOffice(document.form.f_ofc_lvl);
}
//changeCostYrmon

function changeChtBiz(){
    /*
    if (sheet_selno == "1") { //첫번째 SHEET 이면
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    } else if (sheet_selno == "2") { //두번째 SHEET 이면
    	doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH);
    } else if (sheet_selno == "3") { //세번째 SHEET 이면
    	doActionIBSheet3(sheetObjects[2],document.form,IBSEARCH);
    }
    * */
}

// Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBCLEAR:          //조회
	    	formObj.f_year.value = ComGetNowInfo("yy");
	        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
	        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
	        
	        sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = INIT;
			var sXml = document.form.sXml.value; 
			document.form.sXml.value = "";
			var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
			var arrXml = sXml.split("|$$|");
			formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
	        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
	        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
	        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
	        		        
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.f_pro_vw, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], formObj.f_ofc_vw, "code", "name");
			if (arrXml.length > 2) {
				ComXml2ComboItem(arrXml[2], formObj.f_pro_lvl, "code", "name");
				document.getElementById("f_pro_lvl").DeleteItem("M"); 
				
			}
			if (arrXml.length > 3) {
				ComXml2ComboItem(arrXml[3], formObj.f_pro_obj, "code", "name");
				document.getElementById("f_pro_obj").DeleteItem("A"); 
			}
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], formObj.f_ofc_lvl, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], formObj.f_ofc_cd, "code", "code");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], formObj.f_trd_cd, "code", "code");
			if (arrXml.length > 7)
				ComXml2ComboItem(arrXml[7], formObj.f_rlane_cd, "code", "code");
			if (arrXml.length > 8)
				ComXml2ComboItem(arrXml[8], formObj.f_dir_cd, "code", "code");
			if (arrXml.length > 9)
				ComXml2ComboItem(arrXml[9], formObj.f_ias_rgn_cd, "code", "name");
			if (arrXml.length > 10)
				ComXml2ComboItem(arrXml[10], formObj.f_trd_dir_cd, "code", "name");
			if (arrXml.length > 11)
				ComXml2ComboItem(arrXml[11], formObj.f_sub_trd_cd, "code", "code");
			
			ComOpenWait(false);
			break;
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;    		
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST01;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경

			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[0]);
				initSheet(sheetObj, 1, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			sheetObj.ShowTreeLevel(-1); //트리 모두펴기

			//sheetObj.SpeedDown2Excel(-1);
			//sheetObj.Down2Excel(-1, false, false, true);
			
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;
			case IBCREATE:	//저장
  				if(validateForm(sheetObj,formObj,sAction)){
  					// 업무처리중 버튼사용 금지 처리
  					if (ComShowConfirm(ComGetMsg('MAS10020')) == true) {
	  					sheetObj.WaitImageVisible = false;
	  					ComOpenWait(true);
	  					formObj.f_cmd.value = MULTI;
	  					var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS4.do",  masFormQueryString(formObj));
	  				  
	  					if (sXml != "") sheetObj.LoadSearchXml(sXml);

	  					var statusCode = ComGetEtcData(sXml, "BatchStatus" );
	  					
	  					switch(statusCode){
	  						case "4": // 작업 submit			
	  							sheetObj.RemoveAll();  
	  					        ComBtnDisable("btn_create");
	  							monitoringBatchJob();
	  							break;
	  						case "5":// Error 발생
	  							ComShowMessage("P&L Report Creation");
	  							break;
	  						case "6"://해당 작업이 진행 중 
	  							ComShowCodeMessage("MAS00003", "P&L Report Creation");
	  							ComOpenWait(false);  
	  							break;
	  						default: break;							
	  					}  
  					}
  					
  				}
  				break;
	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet2(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		 
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST02;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS2.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[1]);
				initSheet(sheetObj, 2, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			//sheetObj.SpeedDown2Excel(-1);
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet3(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
    		if(!validateForm(sheetObj,formObj,sAction)) return false;
    		  
            // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST03;
            //20100414 이중환, FormQueryString -> masFormQueryString 변경
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS3.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[2]);
				initSheet(sheetObj, 3, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			view_rhq();
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			//sheetObj.SpeedDown2Excel(-1);
            var excelType = selectDownExcelMethod(sheetObj);
            switch (excelType) {
                case "AY":
                    sheetObj.Down2Excel(0, false, false, true);
                    break;
                case "DY":
                    sheetObj.Down2Excel(-1, false, false, true);
                    break;
                case "AN":
                    sheetObj.SpeedDown2Excel(0, false, false);
                    break;
                case "DN":
                    sheetObj.SpeedDown2Excel(-1, false, false);
                    break;
            }               
			break;

	}
}

// Sheet관련 프로세스 처리
function doActionIBSheet7(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {
	case IBSEARCH:      //조회
		// 날짜 조건 체크
		if(!validateForm(sheetObj,formObj,sAction)) return false;
		
		// VVD 체크 
		if(!validateCond(formObj)) return false;
		// 업무처리중 버튼사용 금지 처리
		
		// batch Status에 따라서 조회 금지 처리
		if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
		
		sheetObj.WaitImageVisible = false;
		ComOpenWait(true);
		// IAS P&L
		formObj.f_cmd.value = SEARCHLIST07;
		//20100414 이중환, FormQueryString -> masFormQueryString 변경
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS5.do", masFormQueryString(formObj));
		
		if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
			ComOpenWait(false);
			return false;
		}
		var headCode = searchEtcData("headCode", sXml, "1");
		var headName = searchEtcData("headName", sXml, "1");
		if (headName != "") {
			sheetObj.Redraw = false;
			sheetObj.Visible = false;
			sheetObj.RemoveAll();
			sheetObj.Reset();
			ComConfigSheet(sheetObjects[3]);
			initSheet(sheetObj, 7, headCode, headName);
			sheetObj.Visible = true;
			sheetObj.Redraw = true;
			sheetObj.LoadSearchXml(sXml);
			sheetObj.RemoveEtcData(); // ETC 데이타 삭제
		}
		ComOpenWait(false);
		view_rhq();
		break;
		
	case IBDOWNEXCEL:   //엑셀 다운로드
		//sheetObj.SpeedDown2Excel(-1);
		var excelType = selectDownExcelMethod(sheetObj);
		switch (excelType) {
		case "AY":
			sheetObj.Down2Excel(0, false, false, true);
			break;
		case "DY":
			sheetObj.Down2Excel(-1, false, false, true);
			break;
		case "AN":
			sheetObj.SpeedDown2Excel(0, false, false);
			break;
		case "DN":
			sheetObj.SpeedDown2Excel(-1, false, false);
			break;
		}               
		break;
		
	}
}



//Sheet관련 프로세스 처리
function doActionIBSheet4(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
 		if(!validateForm(sheetObj,formObj,sAction)) return false;    		
         // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST04;			
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS11.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[4]);
				initSheet(sheetObj, 4, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
			sheetObj.ShowTreeLevel(-1); //트리 모두펴기

         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
			break;
	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet5(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
 		if(!validateForm(sheetObj,formObj,sAction)) return false;
 		 
         // VVD 체크 
			if(!validateCond(formObj)) return false;
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			// 업무처리중 버튼사용 금지 처리
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST05;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS2.do", masFormQueryString(formObj));
			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[5]);
				initSheet(sheetObj, 5, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet6(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
 		if(!validateForm(sheetObj,formObj,sAction)) return false;
 		  
         // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST06;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS3.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");
			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[6]);
				initSheet(sheetObj, 6, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			view_rhq();
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet8(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
		    // 날짜 조건 체크
		if(!validateForm(sheetObj,formObj,sAction)) return false;
		  
       // VVD 체크 
			if(!validateCond(formObj)) return false;
			// 업무처리중 버튼사용 금지 처리
			
			// batch Status에 따라서 조회 금지 처리
			if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
			
			sheetObj.WaitImageVisible = false;
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCHLIST08;
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS5.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
				ComOpenWait(false);
				return false;
			}
			
			
			var headCode = searchEtcData("headCode", sXml, "1");
			var headName = searchEtcData("headName", sXml, "1");

			if (headName != "") {
				sheetObj.Redraw = false;
				sheetObj.Visible = false;
				sheetObj.RemoveAll();
				sheetObj.Reset();
				ComConfigSheet(sheetObjects[7]);
				initSheet(sheetObj, 8, headCode, headName);
				sheetObj.Visible = true;
				sheetObj.Redraw = true;
				sheetObj.LoadSearchXml(sXml);
				sheetObj.RemoveEtcData(); // ETC 데이타 삭제
			}
			ComOpenWait(false);
			view_rhq();
			break;

		case IBDOWNEXCEL:   //엑셀 다운로드
       var excelType = selectDownExcelMethod(sheetObj);
       switch (excelType) {
           case "AY":
               sheetObj.Down2Excel(0, false, false, true);
               break;
           case "DY":
               sheetObj.Down2Excel(-1, false, false, true);
               break;
           case "AN":
               sheetObj.SpeedDown2Excel(0, false, false);
               break;
           case "DN":
               sheetObj.SpeedDown2Excel(-1, false, false);
               break;
       }               
			break;

	}
}

//Sheet관련 프로세스 처리
function doActionIBSheet9(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //조회
            // 날짜 조건 체크
        if(!validateForm(sheetObj,formObj,sAction)) return false;           
         // VVD 체크 
            if(!validateCond(formObj)) return false;
            // 업무처리중 버튼사용 금지 처리
            
            // batch Status에 따라서 조회 금지 처리
            if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
            
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST09;         
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS.do", masFormQueryString(formObj));
            if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
                ComOpenWait(false);
                return false;
            }
            
            var headCode = searchEtcData("headCode", sXml, "1");
            var headName = searchEtcData("headName", sXml, "1");
            if (headName != "") {
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObjects[8]);
                initSheet(sheetObj, 9, headCode, headName);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                sheetObj.LoadSearchXml(sXml);
                sheetObj.RemoveEtcData(); // ETC 데이타 삭제
            }
            ComOpenWait(false);
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
            sheetObj.ShowTreeLevel(-1); //트리 모두펴기

         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
            break;
    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet10(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        
        case IBSEARCH:      //조회
            // 날짜 조건 체크
        if(!validateForm(sheetObj,formObj,sAction)) return false;
         
         // VVD 체크 
            if(!validateCond(formObj)) return false;
            
            // batch Status에 따라서 조회 금지 처리
            if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
            
            // 업무처리중 버튼사용 금지 처리
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST10;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS2.do", masFormQueryString(formObj));
            if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
                ComOpenWait(false);
                return false;
            }
            var headCode = searchEtcData("headCode", sXml, "1");
            var headName = searchEtcData("headName", sXml, "1");
            if (headName != "") {
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObjects[9]);
                initSheet(sheetObj, 10, headCode, headName);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                sheetObj.LoadSearchXml(sXml);
                sheetObj.RemoveEtcData(); // ETC 데이타 삭제
            }
            ComOpenWait(false);
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
            break;

    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet11(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //조회
            // 날짜 조건 체크
        if(!validateForm(sheetObj,formObj,sAction)) return false;
          
         // VVD 체크 
            if(!validateCond(formObj)) return false;
            // 업무처리중 버튼사용 금지 처리
            
            // batch Status에 따라서 조회 금지 처리
            if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
            
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST11;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS3.do", masFormQueryString(formObj));

            if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
                ComOpenWait(false);
                return false;
            }
            var headCode = searchEtcData("headCode", sXml, "1");
            var headName = searchEtcData("headName", sXml, "1");
            if (headName != "") {
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObjects[10]);
                initSheet(sheetObj, 11, headCode, headName);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                sheetObj.LoadSearchXml(sXml);
                sheetObj.RemoveEtcData(); // ETC 데이타 삭제
            }
            ComOpenWait(false);
            view_rhq();
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
         var excelType = selectDownExcelMethod(sheetObj);
         switch (excelType) {
             case "AY":
                 sheetObj.Down2Excel(0, false, false, true);
                 break;
             case "DY":
                 sheetObj.Down2Excel(-1, false, false, true);
                 break;
             case "AN":
                 sheetObj.SpeedDown2Excel(0, false, false);
                 break;
             case "DN":
                 sheetObj.SpeedDown2Excel(-1, false, false);
                 break;
         }               
            break;

    }
}

//Sheet관련 프로세스 처리
function doActionIBSheet12(sheetObj,formObj,sAction) {
    alert("Do Not Use IAS P&L flag in P&L by Agreement TAB");
    return;
    sheetObj.ShowDebugMsg = false;

    switch(sAction) {
        case IBSEARCH:      //조회
            // 날짜 조건 체크
        if(!validateForm(sheetObj,formObj,sAction)) return false;
          
       // VVD 체크 
            if(!validateCond(formObj)) return false;
            // 업무처리중 버튼사용 금지 처리
            
            // batch Status에 따라서 조회 금지 처리
            if (!validBatchStatus(sheetObj,formObj,sAction)) return false;
            
            sheetObj.WaitImageVisible = false;
            ComOpenWait(true);
            formObj.f_cmd.value = SEARCHLIST12;
            var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS5.do", masFormQueryString(formObj));

            if (ComGetEtcData(sXml,"TRANS_RESULT_KEY")== 'F') {
                ComOpenWait(false);
                return false;
            }
            
            
            var headCode = searchEtcData("headCode", sXml, "1");
            var headName = searchEtcData("headName", sXml, "1");

            if (headName != "") {
                sheetObj.Redraw = false;
                sheetObj.Visible = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObjects[11]);
                initSheet(sheetObj, 12, headCode, headName);
                sheetObj.Visible = true;
                sheetObj.Redraw = true;
                sheetObj.LoadSearchXml(sXml);
                sheetObj.RemoveEtcData(); // ETC 데이타 삭제
            }
            ComOpenWait(false);
            view_rhq();
            break;

        case IBDOWNEXCEL:   //엑셀 다운로드
       var excelType = selectDownExcelMethod(sheetObj);
       switch (excelType) {
           case "AY":
               sheetObj.Down2Excel(0, false, false, true);
               break;
           case "DY":
               sheetObj.Down2Excel(-1, false, false, true);
               break;
           case "AN":
               sheetObj.SpeedDown2Excel(0, false, false);
               break;
           case "DN":
               sheetObj.SpeedDown2Excel(-1, false, false);
               break;
       }               
            break;

    }
}


   /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;

		with(formObj){
            	if(f_year.value == ""){
	                ComShowMessage(ComGetMsg("COM12114","Year",""));
	                f_year.focus();
	                return false;
	            }
	            if(!ComIsDate(f_year, "yyyy")){
	 		    // [MAS1009] = Year 값을 확인하십시오.
	 		    	ComShowCodeMessage('MAS10009','Year','YYYY');
	 		    	f_year.focus();
	 		    	return false;
	 		    }
	            
	            if(f_chkprd[0].checked){
	            	if (f_to_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "week", ""));
		                f_to_wk.focus();
		                return false;
		            }
		            if (f_fm_wk.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "Week", ""));
		                f_fm_wk.focus();
		                return false;
		            }
		            if(!ComIsWeek(f_fm_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_fm_wk.focus();
						return false;
					}
					if(!ComIsWeek(f_to_wk.value)){
						ComShowMessage(ComGetMsg("COM12114", "Week"));
						f_to_wk.focus();
						return false;
					}
	            }else{
	            	if (f_to_mon.value == ""){
		                ComShowMessage(ComGetMsg("COM12114", "month", ""))
		                f_to_mon.focus();
		                return false;
		            }   
		            if (f_fm_mon.value == "" ) {
		                ComShowMessage(ComGetMsg("COM12114", "Month", ""));
		                f_fm_mon.focus();
		                return false;
		            }
		            if (ComParseInt(f_fm_mon.value) > ComParseInt(f_to_mon.value)) {
		                ComShowMessage(ComGetMsg("MAS10011","Month","From","To"));
		                return false;
		            }
		            if(!ComIsMonth(f_fm_mon.value)){ 
						ComShowMessage(ComGetMsg("COM12114", "Month"));
						f_fm_mon.focus();
						return false;
					}
					if(!ComIsMonth(f_to_mon.value)){
						ComShowMessage(ComGetMsg("COM12114", "Month"));
						f_to_mon.focus();
						return false;
					}
	            }
            }
		return true;
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (f_year.value == "") {
			    // [COM12114] : Year 를(을) 확인하세요.
			    ComShowMessage(ComGetMsg("COM12114", "Year"));
			    f_year.focus();
				return false;
			}
			
			//IBCREATE : PL chart Creation은 week option에서만 생성 가능
			//           2주치까지 생성 할 수 있음.
			
			if (sAction == IBCREATE){
				if (f_chkprd[1].checked) { //Month Option이 켜져 있으면
					ComShowCodeMessage('MAS10003','Creation','Week');
					return false;
				}
				
				if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) < 0){
                    // [MAS10015] : Please check from week first.
                    ComShowMessage(ComGetMsg("MAS10015", "from week"));
                    f_fm_wk.focus();
                    return false;
				}

				 if(ComParseInt(f_to_wk.value)-ComParseInt(f_fm_wk.value) > 9){
                     // [MAS10007] : A maximum of 10 weeks can be entered.
                     ComShowMessage(ComGetMsg("MAS10007", "10"));
                     f_fm_wk.focus();
                     return false;
                 }
			} else { // Create가 아닌 조회 일경우 validation
			
					if((f_chkprd[1].checked && f_fm_mon.value == "" && f_to_mon.value == "") 
					   && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_skd_dir_cd.value == ""){
					    ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
					    return false;
					}
					if((f_chkprd[0].checked && f_fm_wk.value == ""  && f_to_wk.value == "") 
					   && f_vsl_cd.value == "" && f_skd_voy_no.value == "" && f_skd_dir_cd.value == ""){
					    ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
					    return false;
					}
			}
		    if(!chkValidSearch()) return false;
			
//			if((f_chkprd[1].checked && f_year.value == "2007" && parseInt2(f_fm_mon.value) < 7) || 
//			   (f_chkprd[0].checked && f_year.value == "2007" && parseInt2(f_fm_wk.value) < 27)){
//			    // 2007년 07월, 27주 이전데이터는 조회 할수 없습니다. DW, CRM 시스템에서 조회 하시기 바랍니다.
//			    ComShowMessage(ComGetMsg("MAS10037"));
//			    return false;
//			}
		    
		    // Create 기능은 Week 상태에서만 가능, 이때 필수 값은 연도,from week임.
		    // 주차는 1주만 가능 , 1주 이상일경우는 MAS10003
		    
		}
		return true;
	}
	
	/**
	 * 화면 조회값에 대한 유효성검증 프로세스 처리
	 */
	function validateCond(formObj) {
		with(formObj){
			// msg1 + ' 는(은) ' + msg2 + '자리가 되어야 합니다.';
			if (ComTrim(f_vsl_cd.value) != "" && ComTrim(f_vsl_cd.value).length != 4){
				ComShowMessage(ComGetMsg('COM12174','VVD First Element','4'));
				f_vsl_cd.focus();
				return false;
			}
			if (ComTrim(f_skd_voy_no.value) != "" && ComTrim(f_skd_voy_no.value).length != 4){
				ComShowMessage(ComGetMsg('COM12174','VVD Second Element','4'));
				f_skd_voy_no.focus();
				return false;
			}
		}
	
		return true;
	}
	/**
	 *  VVD view에 office level이 regional office 경우 rhq 노출
	 */
    function view_rhq() {
    	formObj = document.form;
        if(formObj.f_rdotype[2].checked && ComGetObjValue(formObj.f_ofc_lvl)==2) {
        	sheetObjects[2].ColHidden("rhq") = false;
        	sheetObjects[5].ColHidden("rhq") = false;
        	sheetObjects[9].ColHidden("rhq") = false;
        } else {
        	sheetObjects[2].ColHidden("rhq") = true;
        	sheetObjects[5].ColHidden("rhq") = true;
        	sheetObjects[9].ColHidden("rhq") = true;
        }
    } 
    
    /**
	 * batch Satus가 running중이거나 Error일때 조회되지 않도록 한다.
	 */
	function validBatchStatus(sheetObj,formObj,sAction){

			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
//
			var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS4.do", masFormQueryString(formObj));

			if (ComGetEtcData(sXml,"BatchStatus")== 'P') {
				ComShowMessage(ComGetMsg("MAS00003", "P&L Report Creation"));
				ComOpenWait(false);
				return false;
			}
////			
			if (ComGetEtcData(sXml,"BatchStatus")== 'E') {
				ComShowMessage(ComGetMsg("MAS00005", "week"+ComGetEtcData(sXml,"BatchWeek")+" creation", "create"));
				ComOpenWait(false);
				return false;
			}
//			
			ComOpenWait(false);

		return true;
	}
	
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	
	function tab1_OnChange(tabObj , tabIndex){
		var formObject = document.form;	

		if(beforetab==tabIndex) return;
	    var objs = document.all.item("tabPLLayer");

	    objs[tabIndex].style.display = "Inline";
	    objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[tabIndex].style.zIndex -1 ;
		//------------------------------------------------------//
		
	    beforetab= tabIndex;
	    // tab 의 Sheet Layer를 설정한다.
		changeTabInfo(beforetab);
		// tab별 검색 조건을 설정한다.
		changeTabSearchCondition(tabIndex);
		
		setZoom();	
		setCobDisplay();
		ias_change();
	}

	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 검색 조건들을 설정한다.
	 */		
	function changeTabSearchCondition(tabIndex) {

		var officeLevelCombo 	= document.getElementById("f_ofc_lvl");
		var profitViewCombo 	= document.getElementById("f_pro_vw");
		var tradeCombo 			= document.getElementById("f_trd_cd");
		var dirCombo 			= document.getElementById("f_dir_cd");
		var rlaneCombo 			= document.getElementById("f_rlane_cd");
		var officeViewCombo 	= document.getElementById("f_ofc_vw");
		
		
		if(tabIndex == 0 || tabIndex == 2) {
			officeLevelCombo.Enable = true;
			profitViewCombo.Enable = true;
			officeViewCombo.Enable = true;
			
			if(tradeCombo.Code == "COM") {
				tradeCombo.Index = 0;

				//rlaneCombo.DeleteItem('CDMCO');
				//rlaneCombo.DeleteItem('CNTLY');
			} else {		
				if(rlaneCombo.Code == "CNTTS" || rlaneCombo.Code == "CNTMR" || rlaneCombo.Code == "CNTLY") {
					rlaneCombo.Index2 = 0;
				}	

				rlaneCombo.DeleteItem('CNTTS');
				rlaneCombo.DeleteItem('CNTMR');
			}

			if(dirCombo.Code == "M") {
				dirCombo.Index2 = 0;
			}
			
			tradeCombo.DeleteItem('COM');			
			dirCombo.DeleteItem('M');
						
		} else if(tabIndex == 1){			
			//Code: 자동 Onchage 발생하도록			
			officeLevelCombo.Code = "1"; // H/O 만 가능	
			officeLevelCombo.Enable = false;

			profitViewCombo.Code = "P"; // Trade Profit 만 가능
			profitViewCombo.Enable = false;
			
			officeViewCombo.Code = "C"; // Trade Contract 만 가능
			officeViewCombo.Enable = false;
			
			tradeCombo.InsertItem(-1, 'COM', 'COM');
			dirCombo.InsertItem(-1, 'M', 'M');
			
			// Adjusted P&L Tab
			if(beforetab == "1" || beforetab == "2") {
				if(tradeCombo.Code == "COM") {
					rlaneCombo.InsertItem(-1, 'CDMCO', 'CDMCO');
					rlaneCombo.InsertItem(-1, 'CNTLY', 'CNTLY');
				} else if(tradeCombo.Code != "All") {
					rlaneCombo.InsertItem(-1, 'CNTTS', 'CNTTS');
					rlaneCombo.InsertItem(-1, 'CNTMR', 'CNTMR');
				}
			}
		}
	}

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	
	function changeTabInfo(tabIndex) {
		var formObj = document.form;
		
		if(tabIndex == "0") {
			if (formObj.f_rdotype[0].checked) { //By Account
	    		sheet_selno = formObj.f_rdotype[0].value;
	    		tabLayer1.style.display = "inline";
	    		tabLayer2.style.display = "none";
	    		tabLayer3.style.display = "none";
	    		tabLayer7.style.display = "none";
	    		div_kor.style.display = "inline"; 
	
	    		tabLayer4.style.display = "none";
	    		tabLayer5.style.display = "none";
	    		tabLayer6.style.display = "none";
	    		tabLayer8.style.display = "none";
	    		div_kor_a.style.display = "none"; 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
	    		          		
	    	} else if (formObj.f_rdotype[1].checked) { //By Lane/BND
	    		sheet_selno = formObj.f_rdotype[1].value;
	    		tabLayer1.style.display = "none";
	    		tabLayer2.style.display = "inline";
	    		tabLayer3.style.display = "none";
	    		tabLayer7.style.display = "none";
	    		div_kor.style.display = "none";
	    		
	    		tabLayer4.style.display = "none";
	    		tabLayer5.style.display = "none";
	    		tabLayer6.style.display = "none";
	    		tabLayer8.style.display = "none";
	    		div_kor_a.style.display = "none"; 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
	    		 
	    	} else if (formObj.f_rdotype[2].checked) { //By VVD
	    		view_rhq();
	    		sheet_selno = formObj.f_rdotype[2].value;
	    		tabLayer1.style.display = "none";
	    		tabLayer2.style.display = "none";
	    		
	    		if(formObj.f_ias_flg.checked){
	    			sheet_selno = "7";
	    			tabLayer3.style.display = "none";
	    			tabLayer7.style.display = "inline";
	    		}else{
	    			sheet_selno = "3";
	    			tabLayer3.style.display = "inline";
	    			tabLayer7.style.display = "none";
	    		}
	    		div_kor.style.display = "none"; 
	    		
	    		tabLayer4.style.display = "none";
	    		tabLayer5.style.display = "none";
	    		tabLayer6.style.display = "none";
	    		tabLayer8.style.display = "none";
	    		div_kor_a.style.display = "none";	 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none";   
	    	} 
		} else if(tabIndex == "1") {
    		if  (formObj.f_rdotype_a[0].checked) { //By Account
	    		sheet_selno = formObj.f_rdotype_a[0].value;
	    		tabLayer1.style.display = "none";
	    		tabLayer2.style.display = "none";
	    		tabLayer3.style.display = "none";
	    		tabLayer7.style.display = "none";
	    		div_kor.style.display = "none"; 
	
	    		tabLayer4.style.display = "inline";
	    		tabLayer5.style.display = "none";
	    		tabLayer6.style.display = "none";
	    		tabLayer8.style.display = "none";
	    		div_kor_a.style.display = "inline"; 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
	    		          		
	    	} else if (formObj.f_rdotype_a[1].checked) { //By Lane/BND
	    		sheet_selno = formObj.f_rdotype_a[1].value;
	    		tabLayer1.style.display = "none";
	    		tabLayer2.style.display = "none";
	    		tabLayer3.style.display = "none";
	    		tabLayer7.style.display = "none";
	    		div_kor.style.display = "none";
	    		
	    		tabLayer4.style.display = "none";
	    		tabLayer5.style.display = "inline";
	    		tabLayer6.style.display = "none";
	    		tabLayer8.style.display = "none";
	    		div_kor_a.style.display = "none"; 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
	    		 
	    	} else if (formObj.f_rdotype_a[2].checked) { //By VVD
	    		view_rhq();
	    		sheet_selno = formObj.f_rdotype_a[2].value;
	    		tabLayer1.style.display = "none";
	    		tabLayer2.style.display = "none";
	    		tabLayer3.style.display = "none";
	    		tabLayer7.style.display = "none";
	    		div_kor.style.display = "none"; 
	    		
	    		tabLayer4.style.display = "none";
	    		tabLayer5.style.display = "none";
	    		
	    		if(formObj.f_ias_flg.checked){
	    			sheet_selno = "8";
	    			tabLayer6.style.display = "none";
	    			tabLayer8.style.display = "inline";
	    		}else{
	    			sheet_selno = "6";
	    			tabLayer6.style.display = "inline";
	    			tabLayer8.style.display = "none";
	    		}
	    		div_kor_a.style.display = "none";	 
	    		
	    		tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
			}
		} else {
            if  (formObj.f_rdotype_b[0].checked) { //By Account
                sheet_selno = formObj.f_rdotype_b[0].value;
                tabLayer1.style.display = "none";
                tabLayer2.style.display = "none";
                tabLayer3.style.display = "none";
                tabLayer7.style.display = "none";
                div_kor.style.display = "none"; 
                
                tabLayer4.style.display = "none";
                tabLayer5.style.display = "none";
                tabLayer6.style.display = "none";
                tabLayer8.style.display = "none";
                div_kor_a.style.display = "none";
    
                tabLayer9.style.display = "inline";
                tabLayer10.style.display = "none";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "inline"; 
                                
            } else if (formObj.f_rdotype_b[1].checked) { //By Lane/BND
                sheet_selno = formObj.f_rdotype_b[1].value;
                tabLayer1.style.display = "none";
                tabLayer2.style.display = "none";
                tabLayer3.style.display = "none";
                tabLayer7.style.display = "none";
                div_kor.style.display = "none";
                
                tabLayer4.style.display = "none";
                tabLayer5.style.display = "none";
                tabLayer6.style.display = "none";
                tabLayer8.style.display = "none";
                div_kor_a.style.display = "none"; 
                
                tabLayer9.style.display = "none";
                tabLayer10.style.display = "inline";
                tabLayer11.style.display = "none";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none"; 
                 
            } else if (formObj.f_rdotype_b[2].checked) { //By VVD
                view_rhq();
                sheet_selno = formObj.f_rdotype_b[2].value;
                tabLayer1.style.display = "none";
                tabLayer2.style.display = "none";
                tabLayer3.style.display = "none";
                tabLayer7.style.display = "none";
                div_kor.style.display = "none"; 
                
                tabLayer4.style.display = "none";
                tabLayer5.style.display = "none";
                tabLayer6.style.display = "none";
                tabLayer8.style.display = "none";
                div_kor_a.style.display = "none";    
                
                tabLayer9.style.display = "none";
                tabLayer10.style.display = "none";
                /* do not use IAS FLG
                if(formObj.f_ias_flg.checked){
                    sheet_selno = "12";
                    tabLayer11.style.display = "none";
                    tabLayer12.style.display = "inline";
                }else{                
                    sheet_selno = "11";
                    tabLayer11.style.display = "inline";
                    tabLayer12.style.display = "none";
                }
                */
                tabLayer11.style.display = "inline";
                tabLayer12.style.display = "none";
                div_kor_b.style.display = "none";        
            }
        }
	}
	

	/**
	 * Adjusted Cost Detail 팝업 화면
	 * 선택한 탭의 요소가 활성화 된다.
	 */	
	function popupAdjCostDetail() {
		var formObj = document.form;
		var sParam = "";

		sParam = 'f_chkprd='     + formObj.f_chkprd.value 
			     + '&f_year='    + formObj.f_year.value
			     + '&f_fm_mon='  + formObj.f_fm_mon.value
			     + '&f_to_mon='  + formObj.f_to_mon.value
			     + '&f_sls_mon=' + formObj.f_sls_mon.value
			     + '&f_fm_wk='   + formObj.f_fm_wk.value
			     + '&f_to_wk='   + formObj.f_to_wk.value;

		ComOpenPopup("/hanjin/ESM_MAS_0073.do?"+masFormQueryString(formObj), 1000, 630, "", "0,0,1,1,1,1,1,1,1,1", false);
		
	}

/**
 * batch job monitoring 
 * 
 * @return 없음
 * @author 서미진
 * @version 2013.02.06
 */ 
function monitoringBatchJob(){
	//개발시에는 모니터링을 하지 않는다.
	if(location.hostname == "localhost"){
		return;
	}
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	formObj.f_cmd.value = SEARCH01;
	var sXml = sheetObj.GetSearchXml("ESM_MAS_0072GS.do", FormQueryString(formObj));
	var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
	if( BatchStatus == "6" ){
		setTimeout(monitoringBatchJob,3000);
	}else{
		ComBtnEnable("btn_create");
		ComShowCodeMessage('MAS10018',"P&L Creation"); 
		ComOpenWait(false);
		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
}

/**
 * IAS P&L 선택시
 *  - Initial Network Cost Display : Default Check
 *  - Disable
 *  	- TRADE : IAS
 *  	- SUB TRADE : IA
 *  	- OFFICE
 *  - OP View 숨김처리 
 */
function ias_change(){
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	
	if(formObj.f_ias_flg.checked) {
		formObj.f_ias_flg.value = "Y";
		formObj.f_init_cost.checked = true;
		div_display3.style.display = "none";
		formObj.f_trd_cd.Code = "IAS";
		formObj.f_trd_cd.Enable = false;
		formObj.f_sub_trd_cd.Code = "IA";
		formObj.f_sub_trd_cd.Enable = false;
		formObj.f_ias_rgn_cd.Enable = false;
		formObj.f_ofc_lvl.Index = 0;
		formObj.f_ofc_lvl.Enable = false;
		formObj.f_ofc_cd.Index = 0;
		formObj.f_ofc_cd.Enable = false;
		
		formObj.f_rdotype[2].checked = true;
		formObj.f_rdotype[2].value = "3";
		formObj.f_rdotype_a[2].checked = true;
		formObj.f_rdotype_a[2].value = "3";
		
		formObj.f_rdotype[0].disabled = true;
		formObj.f_rdotype[1].disabled = true;
		formObj.f_rdotype_a[0].disabled = true;
		formObj.f_rdotype_a[1].disabled = true;
		changeTabInfo(beforetab);
	}else{
		formObj.f_ias_flg.value = "N";
		formObj.f_init_cost.checked = false;
		if (ComGetObjValue(formObj.f_pro_vw) == "P" && ComGetObjValue(formObj.f_pro_lvl) == "O"){
			div_display3.style.display = "inline";
		}
		//formObj.f_trd_cd.Index = 0;
		formObj.f_trd_cd.Enable = true;
		//formObj.f_sub_trd_cd.Index = 0;
		formObj.f_sub_trd_cd.Enable = true;
		if(formObj.f_trd_cd.Code == "IAS"){
			formObj.f_ias_rgn_cd.Enable = true;
		}else{
			formObj.f_ias_rgn_cd.Enable = false;
		}
		
		if(beforetab == 0 || beforetab == 2){
			formObj.f_ofc_lvl.Enable = true;
		}else{
			formObj.f_ofc_lvl.Enable = false;
		}
		formObj.f_ofc_cd.Enable = true;
		
		formObj.f_rdotype[0].disabled = false;
		formObj.f_rdotype[1].disabled = false;
		formObj.f_rdotype_a[0].disabled = false;
		formObj.f_rdotype_a[1].disabled = false;
		
		changeTabInfo(beforetab);
	}
	
}

function initCost_change(){
	var formObj = document.form;
	if(formObj.f_init_cost.checked) {
		formObj.f_init_cost.value = "Y";
	}else{
		formObj.f_init_cost.value = "N";
	}
}