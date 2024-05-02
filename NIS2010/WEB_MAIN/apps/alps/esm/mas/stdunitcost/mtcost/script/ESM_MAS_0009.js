/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0009.js
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성
*Open Issues :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.1
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성
* 
* Change history :  
* 2008.07.28 전윤주  : CSR NO. N200807170013 MAS_EQ Repo 단가 조회 화면 변경  
*                    (ECC, LCC, RCC 콤보 IBCombo로 수정)
* 2009.08.20 박수훈 New Framework 적용[0009]
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리                                  
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 [CHM-201004982-01] MAS Architecture 위배사항 수정
* 2010.09.30 이윤정 [CHM-201006104-01] EQ Repo Cost(PA) 메뉴 ECC 조회기능 수정
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가
* 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCH=3;
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
     * @class ESM_MAS_0009 : ESM_MAS_0009 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0009() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initCombo 				= initCombo;
    	this.setSheetObject 		= setSheetObject;
    	this.setComboObject 		= setComboObject;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.sheet2_OnDblClick      = sheet2_OnDblClick;
    	this.sheet3_OnDblClick      = sheet3_OnDblClick;
    	this.sheet4_OnDblClick      = sheet4_OnDblClick;
    	this.sheet6_OnDblClick      = sheet6_OnDblClick;
    	this.sheet8_OnDblClick      = sheet8_OnDblClick;
    	this.sheet9_OnDblClick      = sheet9_OnDblClick;
    	this.sheet10_OnDblClick      = sheet10_OnDblClick;
    	this.sheet11_OnDblClick      = sheet11_OnDblClick;
    	this.sheet13_OnDblClick      = sheet13_OnDblClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.doActionIBSheet2 		= doActionIBSheet2;
    	this.doActionIBSheet3 		= doActionIBSheet3;
    	this.doActionIBSheet4 		= doActionIBSheet4;
    	this.doActionIBSheet5 		= doActionIBSheet5;
    	this.doActionIBSheet6 		= doActionIBSheet6;
    	this.validateForm 			= validateForm;
    	this.changeSheet 			= changeSheet;
    	this.reSearch   			= reSearch;
    	this.reSearch2   			= reSearch2;
    	this.mtCntrHistoryPopup     = mtCntrHistoryPopup;
    	this.changeLocationHierarchy= changeLocationHierarchy;
    	this.changeSearchSheet 		= changeSearchSheet;
    	this.settingHiddenDate 		= settingHiddenDate;
    }

    
    /* 공통전역변수 */
  //var calPop = new calendarPopupGrid();
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;
  var comboObjects = new Array(); // IB Combo 쓰기 위해서 변수 선언 
  var comboCnt = 0;
  var loadingMode = false;
  
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		//mt
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var sheetObject4 = sheetObjects[4];
		var sheetObject5 = sheetObjects[5];
		var sheetObject6 = sheetObjects[6];
		var sheetObject7 = sheetObjects[7];
		
		//full	
		var sheetObject8 = sheetObjects[8];
		var sheetObject9 = sheetObjects[9];
		var sheetObject10 = sheetObjects[10];
		var sheetObject11 = sheetObjects[11];
		var sheetObject12 = sheetObjects[12];
		var sheetObject13 = sheetObjects[13];
		var sheetObject14 = sheetObjects[14];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {

				case "btn_Retrieve":
				   if(formObject.kind[1].checked){ //mt
    					if(document.form.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
     						doActionIBSheet3(sheetObject5,formObject,IBSEARCH);
    					} else if(document.form.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
     						doActionIBSheet2(sheetObject3,formObject,IBSEARCH);
    					} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 0) {//ECC
    						doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					}
    					formObject.f_ecc_cd2.value="";
    					formObject.f_ori_dest[0].checked = true;
				   } else { //full
            			if(formObject.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
            				doActionIBSheet6(sheetObject12,formObject,IBSEARCH);
            			} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
            				doActionIBSheet5(sheetObject10,formObject,IBSEARCH);
            			} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 0) {//ECC
            				doActionIBSheet4(sheetObject7,formObject,IBSEARCH);
            			}
            			
						formObject.f_ecc_cd3.value="";
						formObject.f_ori_dest2[0].checked = true;	
				   }
					break;

				case "btn_DownExcel":
				
    				if(formObject.kind[1].checked){ //mt
    					if(formObject.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
    						doActionIBSheet3(sheetObject5,formObject,IBDOWNEXCEL);
    						doActionIBSheet3(sheetObject6,formObject,IBDOWNEXCEL);
    					} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
    						doActionIBSheet2(sheetObject3,formObject,IBDOWNEXCEL);
    						doActionIBSheet2(sheetObject4,formObject,IBDOWNEXCEL);
    					} else if(formObject.f_cost_loc_grp_cd.selectedIndex ==0) {//ECC
    						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    						doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
    					}
    				} else if(formObject.kind[0].checked){  //full
    					if(formObject.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
    						doActionIBSheet6(sheetObject12,formObject,IBDOWNEXCEL);
    						doActionIBSheet6(sheetObject13,formObject,IBDOWNEXCEL);
    					} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
    						doActionIBSheet5(sheetObject10,formObject,IBDOWNEXCEL);
    						doActionIBSheet5(sheetObject11,formObject,IBDOWNEXCEL);
    					} else if(formObject.f_cost_loc_grp_cd.selectedIndex == 0) {//ECC
    						doActionIBSheet4(sheetObject7,formObject,IBDOWNEXCEL);
    						doActionIBSheet4(sheetObject8,formObject,IBDOWNEXCEL);
    						doActionIBSheet4(sheetObject9,formObject,IBDOWNEXCEL);
    					}   
    				}
					break;
					
				case "btng_EccStatus1":
					if(sheetObject.RowCount >0){
						var sRow = sheetObject.SelectRow;  						
						formObject.p_cost_yrmon.value = sheetObject.CellValue(sRow, "cost_yrmon");  						
						formObject.p_fcntr_ecc_cd.value = sheetObject.CellValue(sRow, "ecc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject.CellValue(sRow, "cntr_io_vol_sts_cd");
						formObject.p_ori_dest.value = sheetObject.CellValue(sRow, "ori_dest_cd").substr(0,1);
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet1');
					}
					break;
				
				case "btng_LccStatus1":
					if(sheetObject3.RowCount >0){
						var sRow = sheetObject3.SelectRow;
						formObject.p_cost_yrmon.value = sheetObject3.CellValue(sRow, "cost_yrmon");
						formObject.p_fcntr_ecc_cd.value = sheetObject3.CellValue(sRow, "lcc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject3.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject3.CellValue(sRow, "cntr_io_vol_sts_cd");
						doActionIBSheet2(sheetObject4,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet4');
					}
					break;
				
				case "btng_RccStatus1":
					if(sheetObject5.RowCount > 0){
						var sRow = sheetObject5.SelectRow;
						formObject.p_cost_yrmon.value = sheetObject5.CellValue(sRow, "cost_yrmon");
						formObject.p_fcntr_ecc_cd.value = sheetObject5.CellValue(sRow, "rcc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject5.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject5.CellValue(sRow, "cntr_io_vol_sts_cd");
						doActionIBSheet3(sheetObject6,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet13');
					}
					break;
					
				case "btng_RouteDetail1":
					if(sheetObject1.RowCount >0){
						var sRow = sheetObject1.SelectRow;
						
						formObject.f_ecc_cd2.value = sheetObject1.CellValue(sRow, "fcntr_ecc_cd");									
						formObject.f_cntr_tpsz_cd2.value = sheetObject1.CellValue(sRow, "cntr_tpsz_cd");
						//초기화						
						if(sheetObject1.CellValue(sRow, "ori_dest_cd").substr(0,1) == 'O') formObject.f_ori_dest[0].checked = true;
						else formObject.f_ori_dest[1].checked = true;
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet2');
					}
					break;
				
				case "btng_RouteDetail2":
					if(sheetObject1.RowCount >0){
						if(sheetObject2.RowCount >0) {
							//get으로 보낼 요소들
							var selrow = sheetObject2.SelectRow;
							var f_ori_dest = '';
							if(formObject.f_ori_dest[1].checked) f_ori_dest = formObject.f_ori_dest[1].value;
							else f_ori_dest = formObject.f_ori_dest[0].value;
							var str = "f_cost_yrmon=" + sheetObject2.CellValue(selrow, "cost_yrmon") +
								"&f_from_ecc=" + sheetObject2.CellValue(selrow, "from_ecc") +
								"&f_to_ecc=" + sheetObject2.CellValue(selrow, "to_ecc") +
								"&f_cntr_tpsz_cd=" + sheetObject2.CellValue(selrow, "cntr_tpsz_cd")+
								"&f_ori_dest=" + f_ori_dest;
							//
							mtCntrHistoryPopup(str);
						} else {
							 ComShowCodeMessage('MAS10005', 'Sheet3');
						}
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet2');
					}
					break;

				case "btng_RouteDetail3":
					if(sheetObject8.RowCount >0){
						var sRow = sheetObject8.SelectRow;
						
						formObject.f_ecc_cd3.value = sheetObject8.CellValue(sRow, "fcntr_ecc_cd");						
						formObject.f_cntr_tpsz_cd3.value = sheetObject8.CellValue(sRow, "cntr_tpsz_cd");
						//초기화
						if(sheetObject8.CellValue(sRow, "ori_dest") == 'O') formObject.f_ori_dest2[0].checked = true;
						else formObject.f_ori_dest2[1].checked = true;
						doActionIBSheet4(sheetObject9,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet9');
					}
					break;

				case "btng_RouteDetail4":
					if(sheetObject8.RowCount >0){
						if(sheetObject9.RowCount >0) {
							//get으로 보낼 요소들
							var selrow = sheetObject9.SelectRow;
							var f_ori_dest2 = '';
							if(formObject.f_ori_dest2[1].checked) f_ori_dest2 = formObject.f_ori_dest2[1].value;
							else f_ori_dest2 = formObject.f_ori_dest2[0].value;

							var str = "f_cost_yrmon=" + sheetObject9.CellValue(selrow, "cost_yrmon") +
								"&f_from_ecc=" + sheetObject9.CellValue(selrow, "from_ecc") +
								"&f_to_ecc=" + sheetObject9.CellValue(selrow, "to_ecc") +
								"&f_cntr_tpsz_cd=" + sheetObject9.CellValue(selrow, "cntr_tpsz_cd")+
								"&f_ori_dest=" + f_ori_dest2;
							//
							mtCntrHistoryPopup(str);
						} else {
							 ComShowCodeMessage('MAS10005', 'Sheet10');
						}
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet9');
					}
					break;
				
				case "btng_EccStatus2":
					if(sheetObject7.RowCount >0){
						var sRow = sheetObject7.SelectRow;
						formObject.p_cost_yrmon.value = sheetObject7.CellValue(sRow, "cost_yrmon");
						formObject.p_fcntr_ecc_cd.value = sheetObject7.CellValue(sRow, "ecc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject7.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject7.CellValue(sRow, "cntr_io_vol_sts_cd");
						formObject.p_ori_dest.value = sheetObject7.CellValue(sRow, "ori_dest").substr(0,1);
						doActionIBSheet4(sheetObject8,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet8');
					}
					break;

				case "btng_LccStatus2":
					if(sheetObject10.RowCount >0){
						var sRow = sheetObject10.SelectRow;
						formObject.p_cost_yrmon.value = sheetObject10.CellValue(sRow, "cost_yrmon");
						formObject.p_fcntr_ecc_cd.value = sheetObject10.CellValue(sRow, "lcc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject10.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject10.CellValue(sRow, "cntr_io_vol_sts_cd");
						doActionIBSheet5(sheetObject11,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet11');
					}
					break;
					
				case "btng_RccStatus2":
					if(sheetObject12.RowCount > 0){
						var sRow = sheetObject12.SelectRow;
						formObject.p_cost_yrmon.value = sheetObject12.CellValue(sRow, "cost_yrmon");
						formObject.p_fcntr_ecc_cd.value = sheetObject12.CellValue(sRow, "rcc_cd");
						formObject.p_cntr_tpsz_cd.value = sheetObject12.CellValue(sRow, "cntr_tpsz_cd");
						formObject.p_cntr_io_vol_sts_cd.value = sheetObject12.CellValue(sRow, "cntr_io_vol_sts_cd");
						doActionIBSheet6(sheetObject13,formObject,IBSEARCH);
					} else {
						 ComShowCodeMessage('MAS10005', 'Sheet13');
					}
					break;
					
				case "btn_Month_Copy":		//팝업창(Month Copy)
		     	       var display = "0,1";
		     	       ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0009", 250, 200, "AverageUcCopy", display, true, false);
		     	    break;						
					
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				 ComShowCodeMessage(OBJECT_ERROR);
			} else {
				 ComShowCodeMessage(e);
			}
		}
	}


	 /**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage(frmECC) {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		loadingMode = true;
    	//SELCDA일 경우만 COPY/SAVE 버튼 활성화  
    	
    	if ( document.form.v_ofc_cd.value == 'SELCSG' || document.form.v_ofc_cd.value == 'CLTCO'
    		 || document.form.v_ofc_cd.value == 'SELAPM' || document.form.v_ofc_cd.value == 'SELCTY'){
    		ComBtnEnable("btn_Month_Copy");
    	} else {
    		ComBtnDisable("btn_Month_Copy");
    	}
    	
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		
		// 멀티콤보 처리
		// ---------------------------------------------
		for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
//          initCombo(comboObjects[k],comboObjects[k].id,frmECC); //2010.09.29 이윤정 [CHM-201006104-01] hard-cording으로 가져오던 ECC 목록을 DB에서 가져 오는 방식으로 변경
        }
		loadingMode = false;
	}	
  	

  	/**
  	 * 시트 초기설정값, 헤더 정의
  	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  	 */
  	function initSheet(sheetObj,sheetNo) {
  		sheetObj.UseUtf8 = true;
  		var cnt = 0;
  		switch(sheetNo) {
  			case 1:	//sheet1 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(18, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|STV|STV|TRS|TRS|TRS_Adjusted|Base Cost TTL|Base Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|U/C|AMT|U/C|AMT|U/C|U/C|U/C_Adjusted|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		70,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);					
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");
  					//
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_stvg_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_trsp_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_trsp_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,	    70,	daRight,	true,	"org_sim_ttl_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_ttl_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_tz_hrs",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(7) ;
  				}
  				break;
  				
  			case 2:	//sheet2 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host?? ??[??][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(9, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|ECC|H_O/D|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성 [ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	false,	"ori_dest_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;
  				
  			case 3:	//sheet3 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 3, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(14, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|From|To|TP/SZ|Vol.|Within Conti|Within Conti|Within Conti|Within Conti|Within Conti|Within Conti|Whole Route|Whole Route|Whole Route";
  					var HeadTitle1 = "H_YM|From|To|TP/SZ|Vol.|MT Steve.|MT Steve.|MT Trans.|MT Trans.|MT TTL U/C|MT Days|MT Steve.|MT Trans.|MT Days";
  					var HeadTitle2 = "H_YM|From|To|TP/SZ|Vol.|AMT|U/C|AMT|U/C|MT TTL U/C|MT Days|MT Steve.|MT Trans.|MT Days";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, true);
  					InitHeadRow(2, HeadTitle2, true);

  					//데이터속성		[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		120,daCenter,	true,	"from_ecc");
  					InitDataProperty(0, cnt++ , dtData,		120,daCenter,	true,	"to_ecc");
  					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,	true,	"vol");
  					
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_steve",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_steve_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_trans",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_trans_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_ttl_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"conti_days",	false,"",dfInteger);
  					
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"mvmt_steve",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"mvmt_trans",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"mvmt_days",	false,"",dfInteger);

  					CountPosition	= 0 ;
  					RangeBackColor(1, 4, 1, 10) = RgbColor(222, 251, 248);	// ENIS
  					style.height = GetSheetHeight(8) ;
  				}
  				break;
  				
  			case 4:	//sheet4 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(18, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|STV|STV|TRS|TRS|TRS_Adjusted|Base Cost TTL|Base Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|U/C|AMT|U/C|AMT|U/C|U/C|U/C_Adjusted|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"lcc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);					
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");
  					
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_stvg_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_trsp_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_trsp_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,	    70,	daRight,	true,	"org_sim_ttl_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_ttl_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"sim_tz_dys",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(8) ;
  				}
  				break;
  			
  			case 5:	//sheet5 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(8, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|LCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;
  			
  			case 6:	//sheet6 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(18, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|STV|STV|TRS|TRS|TRS_Adjusted|Base Cost TTL|Base Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|U/C|AMT|U/C|AMT|U/C|U/C|U/C_Adjusted|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"rcc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);					
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");	
  					
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_stvg_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"org_sim_trsp_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_trsp_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,	    70,	daRight,	true,	"org_sim_ttl_uc_amt",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	true,	"sim_ttl_uc_amt",	    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"sim_tz_dys",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(8) ;
  				}
  				break;
  			
  			case 7:	//sheet7 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(8, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|RCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;
  				
  			case 8:	//sheet8 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(16, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|EMU Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|ECC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);					
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");					
  					//
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	false,	"calcu_ttl",			false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_tz_hrs",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(7) ;
  				}
  				break;

  			case 9:	//sheet9 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host?? ??[??][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(9, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|ECC|H_O/D|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성 [ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtHidden,	100,	daCenter,	false,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;
  				
  			case 10:	//sheet10 init
  				with (sheetObj) {			 		    
  				    
  				    SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 3, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(14, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|From|To|TP/SZ|Vol.|Within Conti|Within Conti|Within Conti|Within Conti|Within Conti|Within Conti|Whole Route|Whole Route|Whole Route";
  					var HeadTitle1 = "H_YM|From|To|TP/SZ|Vol.|MT Steve.|MT Steve.|MT Trans.|MT Trans.|MT TTL U/C|MT Days|MT Steve.|MT Trans.|MT Days";
  					var HeadTitle2 = "H_YM|From|To|TP/SZ|Vol.|AMT|U/C|AMT|U/C|MT TTL U/C|MT Days|MT Steve.|MT Trans.|MT Days";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, true);
  					InitHeadRow(2, HeadTitle2, true);

  					//데이터속성		[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		120,daCenter,	true,	"from_ecc");
  					InitDataProperty(0, cnt++ , dtData,		120,daCenter,	true,	"to_ecc");
  					InitDataProperty(0, cnt++ , dtData,		90,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtAutoSum,	90,	daRight,	true,	"vol");
  					
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_steve",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_steve_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_trans",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_trans_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"conti_ttl_uc",	false,"",dfInteger);
  					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"conti_days",	false,"",dfInteger);
  					
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"mvmt_steve",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	110,daRight,	true,	"mvmt_trans",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtAutoSum,	80,	daRight,	true,	"mvmt_days",	false,"",dfInteger);

  					CountPosition	= 0 ;
  					RangeBackColor(1, 4, 1, 10) = RgbColor(222, 251, 248);	// ENIS
  					style.height = GetSheetHeight(8) ;
  				}
  				break;

  			case 11:	//sheet11 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(16, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|EMU Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|LCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"lcc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);					
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");					
  					//
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	false,	"calcu_ttl",			false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_tz_hrs",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(7) ;
  				}
  				break;

  			case 12:	//sheet12 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(8, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|LCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;

  			case 13:	//sheet13 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 2, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(16, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|MT Stevedorage|MT Stevedorage|MT Transportaion|MT Transportaion|EMU Cost TTL|MT Transit Time|MT Transit Time";
  					var HeadTitle1 = "H_YM|RCC|EQ Status|H_ST|Imbalance(%)|Origin / Dest.|TP / SZ|Vol.|Manual|Unit Cost|AMT|Unit Cost|AMT|Unit Cost|T.Time|Total Days" ;
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,	daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,	"rcc_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"eq_status");
  					InitDataProperty(0, cnt++ , dtHidden,	100,daCenter,	true,	"cntr_io_vol_sts_cd");
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"imbal_rto"      ,      false,"",dfFloat);
  					InitDataProperty(0, cnt++ , dtData,		80,	daCenter,	true,	"ori_dest");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		50,	daCenter,	true,	"vol"            ,      false,"",dfInteger);						
  					InitDataProperty(0, cnt++ , dtCheckBox,	50,	daCenter,	true,	"mnl_rqst_flg");				
  					//
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_stvg_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_steve",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_trsp_uc_amt",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	false,	"calcu_trans",		    false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		90,	daRight,	false,	"calcu_ttl",			false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		70,	daRight,	true,	"mty_tz_hrs",			false,"",dfFloatOrg,	2);					
  					InitDataProperty(0, cnt++ , dtData,		60,	daRight,	true,	"calcu_days",			false,"",dfInteger);

  					RangeBackColor(1, 8, 1, 13) = RgbColor(222, 251, 248);	// ENIS
  					HeadRowHeight	= 10;
  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(7) ;
  				}
  				break;

  			case 14:	//sheet14 init
  				with (sheetObj) {

  					SheetWidth = mainTable.clientWidth;//전체 너비 설정
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
  					MergeSheet = msNone;//전체Merge 종류 [선택, Default msNone]
  					Editable = false;//전체Edit 허용 여부 [선택, Default false]
  					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitColumnInfo(8, 2, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitHeadMode(false, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])
  					var HeadTitle = "H_YM|RCC|TP / SZ|EQ Status|Imbalance %|Imbalance vol|Full In|Full Out";
  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, false);

  					//데이터속성	[ROW, COL,	DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,	true,	"cost_yrmon");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"fcntr_ecc_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_tpsz_cd");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"eq_status");
  					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	false,	"cntr_imbal_rto",   false,"",dfFloat);
  					//
  					InitDataProperty(0, cnt++ , dtData,		120,	daRight,	false,	"cntr_imbal_qty",	false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		100,	daRight,	false,	"cntr_ib_qty",		false,"",dfFloatOrg,	2);
  					InitDataProperty(0, cnt++ , dtData,		60,		daRight,	false,	"cntr_ob_qty",		false,"",dfFloatOrg,	2);

  					CountPosition	= 0 ;
  					style.height = GetSheetHeight(4) ;
  				}
  				break;

  		}
  	}
  	
  	/**
     * 콤보 항목을 설정한다. by.yjjeon
     */
    function initCombo (comboObj, comboNo) {
        with (comboObj) {
            SetColAlign("left");
            SetColWidth("40");
            InsertItem(0,  "All", " ");                  
            sfirstText = Text;
            //UseEdit=true;
            DropHeight = 500; 
            Text = "All";                    
        }
    }
//  2010.09.29 이윤정 [CHM-201006104-01] hard-cording으로 가져오던 ECC 목록을 DB에서 가져 오는 방식으로 변경하기 위해 주석처리
//  function initCombo (comboObj, comboNo, frmECC ) {
//  var cnt  = 0 ;
//  if (comboObj.id == "f_ecc_cd"){
//  	var arrCode = frmECC.split("|");   
//      with (comboObj) {
//           for(j=0; j<arrCode.length; j++){
//              InsertItem(cnt++, arrCode[j], arrCode[j]);
//          }
//      }
//  }
//  with (comboObj) {
//      SetColAlign("left");
//      SetColWidth("40");
//      InsertItem(0,  "All", " ");                  
//      sfirstText = Text;
//      //UseEdit=true;
//      DropHeight = 500; 
//      Text = "All";                    
//  }
//}	
  	/**
  	 * IBSheet Object를 배열로 등록
  	 * comSheetObject(id)에서 호출한다
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setSheetObject(sheet_obj){
  		sheetObjects[sheetCnt++] = sheet_obj;
  	}
  	
  	/**
       * IBCombo Object를 배열로 등록
       * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
       * 배열은 소스 상단에 정의 by.yjjeon
       */
      function setComboObject(combo_obj){
          comboObjects[comboCnt++] = combo_obj;
      }	
  	
    ////////MT 화면 더블 클릭 //////////////////////////////////
  	
  	/**
  	* sheet1을 더블클릭하여 상세조회한다
  	*/	
  	function sheet1_OnDblClick(sheetObj , row, col){
  	    
  	    var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "ecc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		formObject.p_ori_dest.value = sheetObj.CellValue(row, "ori_dest_cd").substr(0,1);
  		
  		doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
  	}
  	
  	/**
  	* sheet2을 더블클릭하여 상세조회한다
  	*/	
  	function sheet2_OnDblClick(sheetObj , row, col){ 
  		
  		var formObject = document.form;
  		
  		formObject.f_ecc_cd2.value = sheetObj.CellValue(row, "fcntr_ecc_cd");
  		formObject.f_cntr_tpsz_cd2.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		//origin_dest
  		if((sheetObj.CellValue(row, "ori_dest_cd")).substr(0,1) == 'O') formObject.f_ori_dest[0].checked = true;
  		else formObject.f_ori_dest[1].checked = true;
  		doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
  	}

  	/**
  	* sheet3을 더블클릭하여 팝업화면을 띄운다.
  	*/
  	function sheet3_OnDblClick(sheetObj , row, col){
  		var f_ori_dest = '';
  		if(document.form.f_ori_dest[1].checked) f_ori_dest=document.form.f_ori_dest[1].value;
  		else f_ori_dest = document.form.f_ori_dest[0].value;

  		var str = "f_cost_yrmon=" + sheetObj.CellValue(row, "cost_yrmon") +
  					"&f_from_ecc=" + sheetObj.CellValue(row, "from_ecc") +
  					"&f_to_ecc=" + sheetObj.CellValue(row, "to_ecc") +
  					"&f_cntr_tpsz_cd=" + sheetObj.CellValue(row, "cntr_tpsz_cd")+
  					"&f_ori_dest=" + f_ori_dest;
  		mtCntrHistoryPopup(str);
  	}
  	
  	/**
  	* sheet4을 더블클릭하여 상세조회한다
  	*/
  	function sheet4_OnDblClick(sheetObj , row, col){
  		var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "lcc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		
  		doActionIBSheet2(sheetObjects[4],formObject,IBSEARCH);
  	}
  	
  	/**
  	* sheet6을 더블클릭하여 상세조회한다
  	*/
  	function sheet6_OnDblClick(sheetObj , row, col){
  		var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "rcc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		
  		doActionIBSheet3(sheetObjects[6],formObject,IBSEARCH);
  	}
  	

    ////////full 화면 더블 클릭 //////////////////////////////////

  	/**
  	* sheet8을 더블클릭하여 상세조회한다
  	*/
  	function sheet8_OnDblClick(sheetObj , row, col){

  		var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "ecc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		formObject.p_ori_dest.value = sheetObj.CellValue(row, "ori_dest").substr(0,1);
  		
  		doActionIBSheet4(sheetObjects[8],formObject,IBSEARCH);
  	}

  	
  	/**
  	* sheet9을 더블클릭하여 상세조회한다
  	*/
  	function sheet9_OnDblClick(sheetObj , row, col){
  	    	        		
  		var formObject = document.form;		
  		formObject.f_ecc_cd3.value = sheetObj.CellValue(row, "fcntr_ecc_cd");		
  		formObject.f_cntr_tpsz_cd3.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		
  		//origin_dest
  		if((sheetObj.CellValue(row, "ori_dest")).substr(0,1) == 'O') formObject.f_ori_dest2[0].checked = true;
  		else formObject.f_ori_dest2[1].checked = true;
  		doActionIBSheet4(sheetObjects[9],formObject,IBSEARCH);
  	}
  	
  	/**
  	* sheet10을 더블클릭하여 팝업화면을 띄운다.
  	*/
  	function sheet10_OnDblClick(sheetObj , row, col){
  		var f_ori_dest2 = '';
  		if(document.form.f_ori_dest2[1].checked) f_ori_dest2=document.form.f_ori_dest2[1].value;
  		else f_ori_dest2 = document.form.f_ori_dest2[0].value;

  		var str = "f_cost_yrmon=" + sheetObj.CellValue(row, "cost_yrmon") +
  					"&f_from_ecc=" + sheetObj.CellValue(row, "from_ecc") +
  					"&f_to_ecc=" + sheetObj.CellValue(row, "to_ecc") +
  					"&f_cntr_tpsz_cd=" + sheetObj.CellValue(row, "cntr_tpsz_cd")+
  					"&f_ori_dest=" + f_ori_dest2;
  		mtCntrHistoryPopup(str);
  	}	

  	/**
  	* sheet11을 더블클릭하여 상세조회한다
  	*/
  	function sheet11_OnDblClick(sheetObj , row, col){
  		var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "lcc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		
  		doActionIBSheet5(sheetObjects[11],formObject,IBSEARCH);
  	}

  	/**
  	* sheet13을 더블클릭하여 상세조회한다
  	*/
  	function sheet13_OnDblClick(sheetObj , row, col){
  		var formObject = document.form;
  		formObject.p_cost_yrmon.value = sheetObj.CellValue(row, "cost_yrmon");
  		formObject.p_fcntr_ecc_cd.value = sheetObj.CellValue(row, "rcc_cd");
  		formObject.p_cntr_tpsz_cd.value = sheetObj.CellValue(row, "cntr_tpsz_cd");
  		formObject.p_cntr_io_vol_sts_cd.value = sheetObj.CellValue(row, "cntr_io_vol_sts_cd");
  		
  		doActionIBSheet6(sheetObjects[13],formObject,IBSEARCH);
  	}
  	

  	/**
  	* Sheet관련 프로세스 처리 MT ECC
  	*/
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0009GS.do", FormQueryString(formObj));
				
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_ecc_cd, "code", "code");//2010.09.29 이윤정 [CHM-201006104-01] hard-cording으로 가져오던 ECC 목록을 DB에서 가져 오는 방식으로 변경
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_lcc_cd, "code", "code");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_rcc_cd, "code", "code");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_cntr_tpsz_cd, "code", "code");
				
				ComOpenWait(false);
				break;
  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				// 업무처리중 버튼사용 금지 처리
  				sheetObj.WaitImageVisible = false;
  				ComOpenWait(true);
  				if(sheetObj.id == "sheet1"){
  					formObj.f_cmd.value = SEARCH01;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  					sheetObjects[1].RemoveAll();
  				} else if (sheetObj.id == "sheet2"){
  					formObj.f_cmd.value = SEARCH02;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				} else if (sheetObj.id == "sheet3"){
  					formObj.f_cmd.value = SEARCH03;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  					sheetObj.SumValue(0,"conti_steve_uc")  = sheetObj.SumValue(0,"conti_steve")/sheetObj.SumValue(0,"vol");
  					sheetObj.SumValue(0,"conti_trans_uc")  = sheetObj.SumValue(0,"conti_trans")/sheetObj.SumValue(0,"vol");
  					sheetObj.SumValue(0,"conti_ttl_uc")  = (sheetObj.SumValue(0,"conti_steve")+sheetObj.SumValue(0,"conti_trans"))/sheetObj.SumValue(0,"vol");
  					
  				}
  				ComOpenWait(false);
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	* Sheet관련 프로세스 처리 MT LCC
  	*/
  	function doActionIBSheet2(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {

  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				
  				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
  				if(sheetObj.id == "sheet4"){
  					formObj.f_cmd.value = SEARCH04;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));					
  				} else{
  					formObj.f_cmd.value = SEARCH05;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				}
  				ComOpenWait(false);
  			   break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	* Sheet관련 프로세스 처리 MT RCC
  	*/
  	function doActionIBSheet3(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {

  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				
  				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
  				if(sheetObj.id == "sheet6"){
  					formObj.f_cmd.value = SEARCH06;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));					
  				} else{
  					formObj.f_cmd.value = SEARCH07;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				} 
  				ComOpenWait(false);
  			   break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	* Sheet관련 프로세스 처리 Full ECC
  	*/
  	function doActionIBSheet4(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;

  		switch(sAction) {
  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
  				if(sheetObj.id == "sheet8"){
  					formObj.f_cmd.value = SEARCH08;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  					sheetObjects[8].RemoveAll();
  				} else if(sheetObj.id == "sheet9") {
  					formObj.f_cmd.value = SEARCH09;
  					//settingHiddenDate("div_period");
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				} else if(sheetObj.id == "sheet10") {
  					formObj.f_cmd.value = SEARCH10;
  					//settingHiddenDate("div_period");
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  					sheetObj.SumValue(0,"conti_steve_uc")  = sheetObj.SumValue(0,"conti_steve")/sheetObj.SumValue(0,"vol");
  					sheetObj.SumValue(0,"conti_trans_uc")  = sheetObj.SumValue(0,"conti_trans")/sheetObj.SumValue(0,"vol");
  					sheetObj.SumValue(0,"conti_ttl_uc")  = (sheetObj.SumValue(0,"conti_steve")+sheetObj.SumValue(0,"conti_trans"))/sheetObj.SumValue(0,"vol");
  				}
  				ComOpenWait(false);
  				break;

  			case IBCOPYROW:	//행 복사
  				sheetObj.DataCopy();
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	* Sheet관련 프로세스 처리 Full LCC
  	*/
  	function doActionIBSheet5(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
  				if(sheetObj.id == "sheet11"){
  					formObj.f_cmd.value = SEARCH11;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				} else if(sheetObj.id == "sheet12"){
  					formObj.f_cmd.value = SEARCH12;
  					//settingHiddenDate("div_period2");
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				}
  				ComOpenWait(false);
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	* Sheet관련 프로세스 처리 Full RCC
  	*/
  	function doActionIBSheet6(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBSEARCH:	//조회
  				if(!validateForm(sheetObj,formObj,sAction)) return false;
  				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
  				if(sheetObj.id == "sheet13"){
  					formObj.f_cmd.value = SEARCH13;
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				} else if(sheetObj.id == "sheet14"){
  					formObj.f_cmd.value = SEARCH14;					
  					sheetObj.DoSearch4Post("ESM_MAS_0009GS.do", masFormQueryString(formObj));
  				}
  				ComOpenWait(false);
  				break;

  			case IBDOWNEXCEL:	//엑셀 다운로드
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
  	 * 화면 조회값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		if(formObj.f_cost_yrmon.value == "") {
  			ComShowCodeMessage('MAS10002', 'YYYY-MM');
  			ComSetFocus(formObj.f_cost_yrmon);
  			return false;	
  		}
  		
  		if (formObj.f_cost_loc_grp_cd.selectedIndex == 0 && formObj.f_ecc_cd.Text == ""){
  			ComShowCodeMessage('MAS10002', 'ECC Code');
  			ComSetFocus(formObj.f_cost_yrmon);			
  			formObj.f_ecc_cd.focus();			
  			return false;
  		}
  		
  		if (formObj.f_cost_loc_grp_cd.selectedIndex == 1 && formObj.f_lcc_cd.Text == ""){
  			ComShowCodeMessage('MAS10002', 'LCC Code');
  			ComSetFocus(formObj.f_lcc_cd);			
  			//formObj.f_lcc_cd.focus();			
  			return false;
  		}
  		
  		if (formObj.f_cost_loc_grp_cd.selectedIndex == 2 && formObj.f_rcc_cd.Text == ""){
  			ComShowCodeMessage('MAS10002', 'RCC Code');
  			ComSetFocus(formObj.f_rcc_cd);			
  			//formObj.f_rcc_cd.focus();			
  			return false;
  		}
  		if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
  			ComShowCodeMessage('COM12180');
  			ComSetFocus(formObj.f_cost_yrmon);
  			return false;	
  		} else {
  				return true;
  		}
  		
  		return true;
  	}


  	/**
  	 * 콤보전환시 화면 전환
  	 */
  	function changeSheet( kind ){
  		for(var k=0; k<11; k++)
  			if(sheetObjects[k].RowCount>0) sheetObjects[k].removeAll();
  		if ( kind == "1" ) { //FUll
  		    div_mt.style.display = "none";
  		    div_full.style.display = "inline";
  		    if(document.form.f_cost_loc_grp_cd.selectedIndex == 0) {//Ecc
           		full_rcc_sheet.style.display = "none";
           		full_lcc_sheet.style.display = "none";
          		full_ecc_sheet.style.display = "inline";  		        
  		    } else if(document.form.f_cost_loc_grp_cd.selectedIndex == 1) {//Lcc
           		full_rcc_sheet.style.display = "none";
           		full_lcc_sheet.style.display = "inline";
          		full_ecc_sheet.style.display = "none";  		        
  		    } else {//RCC
           		full_rcc_sheet.style.display = "inline";
           		full_lcc_sheet.style.display = "none";
          		full_ecc_sheet.style.display = "none";  		        
  		    }
  		} else if ( kind == "2") {//MT
  		    div_mt.style.display = "inline";
  		    div_full.style.display = "none";
  		    if(document.form.f_cost_loc_grp_cd.selectedIndex == 0) {//Ecc
           		mt_rcc_sheet.style.display = "none";
           		mt_lcc_sheet.style.display = "none";
          		mt_ecc_sheet.style.display = "inline";  		        
  		    } else if(document.form.f_cost_loc_grp_cd.selectedIndex == 1) {//Lcc
           		mt_rcc_sheet.style.display = "none";
           		mt_lcc_sheet.style.display = "inline";
          		full_ecc_sheet.style.display = "none";  		        
  		    } else {//RCC
           		mt_rcc_sheet.style.display = "inline";
           		mt_lcc_sheet.style.display = "none";
          		mt_ecc_sheet.style.display = "none";  		        
  		    }
  		    
  		    		    
  		} 
  		document.form.f_cost_yrmon.focus();

  	}
  	
  	/**
  	 * origin/dest radio 버튼 클릭 시 (MT Simulated에서 클릭)
  	 */
  	function reSearch(){		
  		var formObject = document.form;
  		doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
  	}

  	/**
  	 * origin/dest radio 버튼 클릭 시 (Full에서 클릭)
  	 */
  	function reSearch2(){		
  		var formObject = document.form;
  		doActionIBSheet4(sheetObjects[9],formObject,IBSEARCH);
  	}

  	/**
  	 * Inquire MT CNTR MVMT History(0010) 팝업 화면 띄워줌
  	 */
  	function mtCntrHistoryPopup(str){
  		
  		ComOpenWindow2("ESM_MAS_0010.do?" + str,'', 'width=800, height=587, menubar=no, scrollbars=yes, resizable=yes');
  	}

  	/**
  	 * 콤보 박스 활성화
  	 */
  	function changeLocationHierarchy(val) {
          
      	//ecc, rcc hidden
      	if(val == 'R'){//RCC
      		//콤보박스:rcc콤보활성화
      		div_rcc.style.display = "inline";
      		div_lcc.style.display = "none";
      		div_ecc.style.display = "none";
             
              if(document.form.kind[1].checked) {//mt
          		//sheet:sheet3활성화
          		mt_rcc_sheet.style.display = "inline";
          		mt_lcc_sheet.style.display = "none";
          		mt_ecc_sheet.style.display = "none";
              } else {//full
           		full_rcc_sheet.style.display = "inline";
           		full_lcc_sheet.style.display = "none"; 
          		full_ecc_sheet.style.display = "none";               
              }    
              
      	} else if(val == 'L'){//LCC
      		//콤보박스:lcc콤보활성화
      		div_rcc.style.display = "none";
      		div_lcc.style.display = "inline";
      		div_ecc.style.display = "none";
             
              if(document.form.kind[1].checked) {//mt
          		//sheet:sheet3활성화
          		mt_rcc_sheet.style.display = "none";
          		mt_lcc_sheet.style.display = "inline";
          		mt_ecc_sheet.style.display = "none";
              } else {//full
           		full_rcc_sheet.style.display = "none";
           		full_lcc_sheet.style.display = "inline";
          		full_ecc_sheet.style.display = "none";               
              }
      
      	} else if(val == 'E'){//ECC
      		//콤보박스:ecc콤보활성화
      		div_rcc.style.display = "none";
      		div_lcc.style.display = "none";
      		div_ecc.style.display = "inline";
     
      		if(document.form.kind[1].checked) {//mt
          		//sheet:sheet1, sheet2활성화
          		mt_rcc_sheet.style.display = "none";
          		mt_lcc_sheet.style.display = "none";
          		mt_ecc_sheet.style.display = "inline";
      		} else {//full
           		full_rcc_sheet.style.display = "none";
           		full_lcc_sheet.style.display = "none";
          		full_ecc_sheet.style.display = "inline";   		    
      		}
      
      	}


  	}
  	
  	/**
  	* keyEnter를 눌렀을때 쉬트 Retrieve
  	*/
  	function changeSearchSheet(){

  		if(event.keyCode == 13){
  			var fObj = document.form;
  			if(document.form.kind[1].checked) {//mt
  			   if(document.form.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
                    doActionIBSheet3(sheetObjects[5],fObj,IBSEARCH);	
  			   } else if(document.form.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
                    doActionIBSheet2(sheetObjects[3],fObj,IBSEARCH);	
  			   } else if(document.form.f_cost_loc_grp_cd.selectedIndex == 0) {//ECC
  			      doActionIBSheet(sheetObjects[0],fObj,IBSEARCH);
  			   }		    
  			} else if(document.form.kind[0].checked){//full
      			if(document.form.f_cost_loc_grp_cd.selectedIndex == 2) {//RCC
      				doActionIBSheet6(sheetObjects[12],fObj,IBSEARCH);
      			} else if(document.form.f_cost_loc_grp_cd.selectedIndex == 1) {//LCC
      				doActionIBSheet5(sheetObjects[10],fObj,IBSEARCH);
      			} else if(document.form.f_cost_loc_grp_cd.selectedIndex == 0) {//ECC
      				doActionIBSheet4(sheetObjects[7],fObj,IBSEARCH);
      			}
  			}
  		}
  	}
  	
  	
  	/**
  	 * 쉬트의 Hidden 값에 대한 처리
   	 */
  	function settingHiddenDate(divname){
  		var ym = document.form.f_cost_yrmon.value;
  		ym = ym.replace(/\/|\-|\./g,"");
  		var year	= ym.substring(0,4);
  		var month = ym.substring(4,6);
  		y = ComParseInt(year);
  		m = ComParseInt(month);
  		if(m>=3){	m = m-2;}
  		else {//전년도로 변화
  			y = y-1;
  			if(m==1) m=11;
  			else if(m==2) m=12;
  		}

  		year = y + '';
  		if(m<10) month = '0' + m;
  		else month = m + '';
  		var tmp = year + month + ' ~ ' + ym;
  		document.getElementById(divname).innerHTML = "" + tmp;
  	}
  	

 	function setPeriod(obj){
  		
  		var formObj = document.form;
  		var sheetObj = sheetObjects[0];

  		if(obj == null){
            return;
        }
  		
  		if(obj.value == ""){
            if(obj.name == "f_cost_yrmon" ){
                formObj.f_cost_yrmon.value = "";
            } 
            document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            return false;
        } else {
            if(!ComIsDate(formObj.f_cost_yrmon , "ym")){
            	document.getElementById("div_period").innerHTML = "<div id='div_period'></div>";
            	return false;	
            }
        }
  		
  		formObj.f_cmd.value = COMMAND01;
		var sXml = sheetObj.GetSearchXml("ESM_MAS_0009GS.do", masFormQueryString(formObj));
		var arrXml = sXml.split("|$$|");

		if (0<arrXml.length) {
			document.getElementById("div_period").innerHTML = "( "+ComGetEtcData(arrXml[0], "period") +" )";
		}
		
		if (ComGetEtcData(arrXml[0], "period") == ""){
			document.getElementById("div_period").innerHTML = "( YYYY-MM ~ YYYY-MM )";
		}
	}
