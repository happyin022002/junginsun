/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_MAS_0053.js
*@FileTitle     : LaneSimulation Step3 >> Route projection (Lane Summary,Route Summary,Bunker cost, Vessel's Daily Hire (Own & Chartered)
*                                                           Network Cost Calculation,Network Cost After Ocean T/S) tabs.
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.22
*@LastModifier  : 이연각
*@LastVersion   : 1.0
* 2006-08-28 eunju park
* 1.0 최초 생성
* =======================================================
* History
* 2008,11.06 전성진 CSR No.N200811050011
*					- Grid Header 대소문자 변경
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.06.15 배진화 N200905220060 Lane Simulation System 수정사항
* 2009.07.20 윤진영 Alps전환작업
* 2009.09.07 윤진영 [CHM-20090907] CM / OP에서 CM,EQ,ABC 메뉴 선택시 맨마지막 불피요한 테이블 숨김
* 2009.09.07 윤진영[CHM-20090907] Calculation CM / OP에서 Hire, TC-Rev/Layup 메뉴 선택시 필드명 변경
* 2009.09.07 윤진영[CHM-20090907] TS logic에 Ocean Vessel 추가 및 구분하여 결과에 반영되도록 logic 변경
* 2009.10.26 윤진영[CHM-200901026] Step 2에서 port 정보 수정시 Step 3에서 벙커작업 오류 발생 처리.
* 			 Network cost 와 After Oceasn T/S에서 T/S가 전혀없음에도 불구하고 벙커비용만 차이가 발생 처리 .
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.09 시트의 상태값 변경하기 JS 가이드 적용 cellvalue -> rowstatus
* 2010.05.17 윤진영 아키위배사항 formcommand에서 command 01~40 사용금지 적용
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.03.08 김상수 Ticket ID:CHM-201109234-01 lane simulation 기능 보완
*                    - Sheet의 Header 부분에 delimiter추가
========================================================= */
// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
//Tab1에서 Route Summary 저장후 Lane Summary를 제조회하고 기존에 선택되었던 행을 선택할때사용하기 위해
var sRow = "";

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick(){
		var sheetObject = sheetObjects[0]; // CM_Lane Summary
		var sheetObject1 = sheetObjects[1];// CM_Route Summary
		var sheetObject2 = sheetObjects[2];// CM_Route Summary Hidden
		var sheetObject3 = sheetObjects[3];// Port Charge
		var sheetObject4 = sheetObjects[4];// Bunker Cost
		var sheetObject5 = sheetObjects[5];// Hire/TC Rev/Layup(Daily)
		var sheetObject6 = sheetObjects[6];// Network Cost
		var sheetObject7 = sheetObjects[7];// After OCN T/S
		var formObject = document.form;
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_retrieve":
					if(tabObjects[0].SelectedIndex==0){
						doActionIBSheet(sheetObject,formObject,IBSEARCH);    // CM_Lane Summary
					}else if(tabObjects[0].SelectedIndex==1){
						doActionIBSheet3(sheetObject3,formObject,IBSEARCH);  // Port Charge
					}else if(tabObjects[0].SelectedIndex==2){
						doActionIBSheet4(sheetObject4,formObject,IBSEARCH);  // Bunker Cost
					}else if(tabObjects[0].SelectedIndex==3){
						doActionIBSheet5(sheetObject5,formObject,IBSEARCH);  // Hire/TC Rev/Layup(Daily)
					}else if(tabObjects[0].SelectedIndex==4){
						doActionIBSheet6(sheetObject6,formObject,IBSEARCH);  // Network Cost
					}else if(tabObjects[0].SelectedIndex==5){
						doActionIBSheet7(sheetObject7,formObject,IBSEARCH);  // After OCN T/S
					}
					break;

				case "btn_save1":
					doActionIBSheet1(sheetObject1,formObject,IBSAVE);    // CM_Route Summary
					break;

				case "btn_save":
					if(tabObjects[0].SelectedIndex==1){
						doActionIBSheet3(sheetObject3,formObject,IBSAVE);
					}else if(tabObjects[0].SelectedIndex==2){
						doActionIBSheet4(sheetObject4,formObject,IBSAVE);
					}else if(tabObjects[0].SelectedIndex==3){
						doActionIBSheet5(sheetObject5,formObject,IBSAVE);
//					}else if(tabObjects[0].SelectedIndex==4){
//						doActionIBSheet6(sheetObject6,formObject,IBSAVE);
//					}else if(tabObjects[0].SelectedIndex==5){
//						doActionIBSheet7(sheetObject7,formObject,IBSAVE);
					}
					break;

				case "btng_basic":
					doActionIBSheet4(sheetObject4,formObject,IBCREATE);
					break;

				case "btn_downexcel":
					if(tabObjects[0].SelectedIndex==0){
						doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);    // CM_Lane Summary
					}else if(tabObjects[0].SelectedIndex==1){
						doActionIBSheet3(sheetObject3,formObject,IBDOWNEXCEL);  // Port Charge
					}else if(tabObjects[0].SelectedIndex==2){
						doActionIBSheet4(sheetObject4,formObject,IBDOWNEXCEL);  // Bunker Cost
					}else if(tabObjects[0].SelectedIndex==3){
						doActionIBSheet5(sheetObject5,formObject,IBDOWNEXCEL);  // Hire/TC Rev/Layup(Daily)
					}else if(tabObjects[0].SelectedIndex==4){
						doActionIBSheet6(sheetObject6,formObject,IBDOWNEXCEL);  // Network Cost
					}else if(tabObjects[0].SelectedIndex==5){
						doActionIBSheet7(sheetObject7,formObject,IBDOWNEXCEL);  // After OCN T/S
					}
					break;

//					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
//					doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
//					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					break;

				case "btn_create":
    				if(tabObjects[0].SelectedIndex==1){
    					doActionIBSheet3(sheetObject3,formObject,IBCREATE);
    				} else if (tabObjects[0].SelectedIndex==3){
    					doActionIBSheet5(sheetObject5,formObject,IBCREATE);
					  }else if(tabObjects[0].SelectedIndex==4){
						  doActionIBSheet6(sheetObject6,formObject,IBCREATE);
    				}
					break;

    			case "bu_zoom_in1": //next
    			    var lastRow = 16;
					if(tabObjects[0].SelectedIndex==1){
					    if(sheetObject3.LastRow > 16) {
					        lastRow = sheetObject3.LastRow +3;
					        sheetObject3.style.height = sheetObject3.GetSheetHeight(lastRow);
					    }
					}else if(tabObjects[0].SelectedIndex==2){
					    if(sheetObject4.LastRow > 16) {
					        lastRow = sheetObject4.LastRow +3;
					        sheetObject4.style.height = sheetObject4.GetSheetHeight(lastRow);
					    }
					}else if(tabObjects[0].SelectedIndex==3){
					    if(sheetObject5.LastRow > 16) {
					        lastRow = sheetObject5.LastRow +3;
					        sheetObject5.style.height = sheetObject5.GetSheetHeight(lastRow);
					    }
					}else if(tabObjects[0].SelectedIndex==4){
					    if(sheetObject6.LastRow > 16) {
					        lastRow = sheetObject6.LastRow +3;
					        sheetObject6.style.height = sheetObject6.GetSheetHeight(lastRow);
					    }
					}else if(tabObjects[0].SelectedIndex==5){
					    if(sheetObject7.LastRow > 16) {
					        lastRow = sheetObject7.LastRow +3;
					        sheetObject7.style.height = sheetObject7.GetSheetHeight(lastRow);
					    }
					}
    			    if (lastRow > 16) set_Zoom("open");
    				break;

    			case "bu_zoom_out1": //next
    			    var lastRow = 16;
					if(tabObjects[0].SelectedIndex==1){
        				sheetObject3.style.height = sheetObject3.GetSheetHeight(lastRow);
					}else if(tabObjects[0].SelectedIndex==2){
        				sheetObject4.style.height = sheetObject4.GetSheetHeight(lastRow);
					}else if(tabObjects[0].SelectedIndex==3){
        				sheetObject5.style.height = sheetObject5.GetSheetHeight(lastRow);
					}else if(tabObjects[0].SelectedIndex==4){
        				sheetObject6.style.height = sheetObject6.GetSheetHeight(lastRow);
					}else if(tabObjects[0].SelectedIndex==5){
        				sheetObject7.style.height = sheetObject7.GetSheetHeight(lastRow);
					}
    				set_Zoom("close");
    				break;


				default:
					doActionPageMove(sheetObject, formObject, srcName);

			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

    //화면의 Zoom 처리
    function set_Zoom(zoomFlag) {
		if (zoomFlag == "open") {
		    div_zoom_in1.style.display  = "none";
		    div_zoom_out1.style.display = "inline";
		} else if (zoomFlag == "close") {
		    div_zoom_in1.style.display  = "inline";
		    div_zoom_out1.style.display = "none";
		}
        parent.syncHeight();
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
     * IBCombo Object를 배열로 등록
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
	function loadPage(op_header_cd,op_header_nm, cm_header_cd, cm_header_nm) {
        // 텝 처리
        //---------------------------------------------
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		loadingMode = true;
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        // Sheet 처리
        //---------------------------------------------
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1,op_header_cd,op_header_nm, cm_header_cd, cm_header_nm, "");
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        document.form.f_lyp_cost_amt.value = ComAddComma2("2000",'#,###') ;
        loadingMode = false;
	}
    /**
     * 멀티콤보 항목을 설정한다.
     */
    function initCombo(comboObj, comboId) {
   		with (comboObj) {
   			DropHeight = 300;
   			Index = 0;
   		}
   	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo, op_header_cd,op_header_nm, cm_header_cd, cm_header_nm,port_header) {
		var cnt = 0;
		switch(sheetNo) {
            case 1:      //Step3 : Tab1 : CM_Lane Summary
                    if(cm_header_cd==""){
                        cm_header_cd="|Full Steve|Full Trans|Empty Steve|Empty Trans|EQ Holding|AGT Comm|General Exp";
                    }
                    aryTitle = cm_header_nm.split("|");
                    aryCD    = cm_header_cd.split("|");
                    if(cm_header_nm != "") colCnt = aryTitle.length-1;
                    colTotNum = colCnt+8;

                    with (sheetObj) {
                        SheetWidth = mainTable1.clientWidth;                     //전체너비설정
                        if(location.hostname!="") InitHostInfo(location.hostname,location.port,page_path); //Host정보설정[필수][HostIp,Port,PagePath]
                        MergeSheet = msNone;                                    //전체Merge종류[선택,DefaultmsNone]
                        Editable  =false;                                       //전체Edit허용여부[선택,Defaultfalse]
                        InitRowInfo(1,1,9,100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitColumnInfo(colTotNum,7,0,true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitHeadMode(false,false,false,true,false,false);       //해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
                        var HeadTitle="No|sect_no|Trade|R.Lane|IOC|Dir|Load|port_dys|"+cm_header_nm;
                        InitHeadRow(0,HeadTitle,true);                          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]

                        //데이터속성    [ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,       CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0,     cnt++ , dtData,     50,     daCenter,   false,      "no",           false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtHidden,   60,     daCenter,   false,      "sect_no",      false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtData,     60,     daCenter,   false,      "trd_cd",       false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtData,     60,     daCenter,   false,      "rlane_cd",     false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtData,     60,     daCenter,   false,      "ioc_cd",       false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtData,     60,     daCenter,   false,      "skd_dir_cd",   false,      "",         dfNone,         0,          true,       true);
                        InitDataProperty(0,     cnt++ , dtAutoSum,  100,    daRight,    false,      "lod_ttl_qty",  false,      "",         dfFloatOrg,        2,          true,       true);
                        InitDataProperty(0,     cnt++ , dtHidden,   60,     daRight,    false,      "port_dys",     false,      "",         dfNone,         0,          true,       true);
                        for(j=0; j<colCnt; j++){
                        InitDataProperty(0,     cnt++ , dtAutoSum,  150,    daRight,    false,      aryCD[j],       false,      "",         dfFloatOrg,        1,          true,       true);
                        }
                        //InitDataProperty(0,       cnt++ , dtHidden,   200,    daRight,    false,      "port_info",    false,      "",         dfNone,         0,          true,       true);
                        CountPosition  = 0 ;
                        style.height = GetSheetHeight(7) ;
                }
                break;
            case 2:      //Step3 : Tab1 : CM_Route Summary
                if(port_header == "") port_header = "POD|POD|POD";
                aryTitle = port_header.split("|");
                if(port_header != "") colCnt = aryTitle.length;
                colTotNum = ((colCnt+1)*2)+2;
                with (sheetObj) {
                    SheetWidth = mainTable2.clientWidth;                    //전체너비설정
                    if(location.hostname!="") InitHostInfo(location.hostname,location.port,page_path); //Host정보설정[필수][HostIp,Port,PagePath]
                    MergeSheet = msNone;                                    //전체Merge종류[선택,DefaultmsNone]
                    Editable  =true;                                        //전체Edit허용여부[선택,Defaultfalse]
                    InitRowInfo(1,1,9,100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colTotNum,2,0,true);                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false,false,false,true,false,false);       //해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
                    var HeadTitle="STS|POL\POD|"+port_header+"||"+port_header+"|Total";
                    InitHeadRow(0,HeadTitle,true);                          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                    var tot="";
                    var tot2="";
                    var col=0;
                    //데이터속성    [ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,       CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     col++ , dtStatus,   30,     daCenter,   true,       "ibflag");
                    InitDataProperty(0,     col++ , dtData,     80,     daCenter,   false,      "pol_cd",           false,          "",         dfNone,          0,         false,      false);
                    for(j=0; j<colCnt; j++){
                    InitDataProperty(0,     col++ , dtData,     80,     daRight,    false,      aryTitle[j],        false,          "",         dfFloatOrg,       1,         true,       true);
                    tot = tot + "|" + aryTitle[j] + "| + ";
                    }
                    InitDataProperty(0,     col++ , dtData,  100,    daRight,    false,       "",              false,          "",        dfNone,       1,         false,       false);

                    for(j=0; j<colCnt; j++){
                    InitDataProperty(0,     col++ , dtAutoSum,  80,     daRight,    false,      aryTitle[j]+ "_amt",false,          "",         dfFloatOrg,       1,         true,       true);
                    tot2 = tot2 + "|" + aryTitle[j] + "_amt| + ";
                    }
                    InitDataProperty(0,     col++ , dtAutoSum,  100,    daRight,    false,      "",                 false,          tot2,       dfFloatOrg,       1,         false,       false);

                    CountPosition  = 0 ;
                    style.height = GetSheetHeight(10) ;

                    cnt = (colTotNum -2)/2;
                    for(j=2;j<colTotNum;j++){
                        if(cnt+2<=j) ColHidden(j) = true;
                    }

                }

                break;

             case 3: //Step3 : Tab1 : CM_Route Summary 2_Hidden Sheet
                if(port_header == "") port_header = "POD|POD|POD";
                aryTitle = port_header.split("|");
                if(port_header != "")colCnt = aryTitle.length;
                colTotNum = (colCnt+1)+4;

                with (sheetObj) {

                    SheetWidth = mainTable3.clientWidth;                 //전체너비설정
                    if(location.hostname!="")InitHostInfo(location.hostname,location.port,page_path);//Host정보설정[필수][HostIp,Port,PagePath]
                    MergeSheet=msNone;                                  //전체Merge종류[선택,DefaultmsNone]
                    Editable=true;                                      //전체Edit허용여부[선택,Defaultfalse]
                    InitRowInfo(1,1,9,100);                             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(colTotNum,0,0,true);                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false,false,false,true,false,false);   //해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
                    var HeadTitle="STS|POL\POD|"+port_header+"|Total|";
                    InitHeadRow(0,HeadTitle,true);                      //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
                    var tot="";
                    var tot2="";
                    var col=0;

                    //데이터속성    [ROW,    COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,       CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     col++ , dtStatus,   30,     daCenter,   true,       "vol_ibflag");
                    InitDataProperty(0,     col++ , dtData,     80,     daCenter,   false,      "vol_pol_cd",           false,          "",         dfNone,          0,         false,      false);
                    for(j=0; j<colCnt; j++){
                    InitDataProperty(0,     col++ , dtAutoSum,  80,    daRight,    false,      "vol_"+aryTitle[j],     false,          "",          dfFloatOrg,         0,         true,       true);
                    tot = tot + "|vol_" + aryTitle[j] + "| + ";
                    }
                    InitDataProperty(0,     col++ , dtAutoSum,  100,    daRight,    false,      "vol_tot",              false,          tot,        dfFloatOrg,         0,         false,       false);
                    InitDataProperty(0,     col++ , dtHidden,     80,   daCenter,   false,      "",                     false,          "",         dfNone,          0,         false,      false);

                    CountPosition  = 0 ;
                    style.height = "0" ; // size를 0으로 하여 Hidden 시킴
                  //style.height = GetSheetHeight(10);
                }
                 //sheetObjects[2].Visible = false;
                break;
			case 4:      //Step3 : Tab2 : Port Charge
				with (sheetObj) {
					SheetWidth = mainTable4.clientWidth;								//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msNone;											//전체Merge 종류 [선택, Default msNone]
					Editable = true;												//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 1, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(9, 0, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false) ;			// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle = "STS|Port|TMNL||Port seq|Vsl Class|Port Tariff|Canal Fee|";
					InitHeadRow(0, HeadTitle, true);								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ ,	dtStatus,     30,    daCenter, true,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter, false,   "port_cd",           true,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter, false,   "yd_cd",            true,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter, false,   "tml_cd",            true,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter, false,   "port_seq",          true,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daRight,  false,   "vsl_clss_capa",    true,        "",       dfInteger,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,      100,    daRight,  false,   "port_trf_amt",     false,        "",       dfInteger,       0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      100,    daRight,  false,   "cnl_fee_amt",      false,        "",       dfInteger,       0,     true,       true);

					CountPosition  = 0 ;
					style.height = GetSheetHeight(16) ;
					//AutoSizeMode  = true;
				}
				break;

			case 5:      //Step3 : Tab3 : Bunker Cost
				with (sheetObj) {
				    style.height = GetSheetHeight(16) ;
					SheetWidth = mainTable5.clientWidth;								//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;										//전체Merge 종류 [선택, Default msNone]
					Editable = true;												//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo( 15, 9, 0, true);								//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, true, false, true, false,false) ;			// 해더에서 처리할 수 있는 각종 기능을 설정한다
					var HeadTitle = "STS|No|sect_no|Trade|R.Lane|IOC|Dir|VSL Class|Speed(Kts)|F.O(Daily Basis)|F.O(Daily Basis)|F.O(Daily Basis)|D.O(Daily Basis)|D.O(Daily Basis)";
					var HeadTitle1= "STS|No|sect_no|Trade|R.Lane|IOC|Dir|VSL Class|Speed(Kts)|Sail_Cons|Port_Cons|Unit Cost|Cons|Unit Cost";
					InitHeadRow(0, HeadTitle, true);								//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, false);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ ,	dtStatus,     30,    daCenter, true,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,    "sect_desc",      false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter, true,    "sect_no",        false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter, true,    "trd_cd",         false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter, true,    "rlane_cd",       false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter, true,    "ioc_cd",         false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter, true,    "skd_dir_cd",     false,          "",       dfNone,        0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,    "vsl_clss_capa",  false,          "",       dfNumber,      0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,       80,    daRight,  true,    "bzc_vsl_spd",    false,          "",       dfFloat,       1,     true,       true , 5);
					InitDataProperty(0, cnt++ , dtData,       90,    daRight,  true,    "foil_sail_csm",  false,          "",       dfFloat,       2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       90,    daRight,  true,    "foil_port_csm",  false,          "",       dfFloat,       2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       90,    daRight,  true,    "foil_uc_amt",    false,          "",       dfFloat,       2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       90,    daRight,  true,    "doil_csm",       false,          "",       dfFloat,       2,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       90,    daRight,  true,    "doil_uc_amt",    false,          "",       dfFloat,       2,     true,       true);

					CountPosition  = 0 ;
					RangeBackColor(1, 10, 1, 15) = RgbColor(222, 251, 248);   // ENIS
				}
				break;

			case 6:      //Step3 : Tab4 : Hire/TC Rev/Layup(Daily)
				var aryTitle = "";
				var aryCD = "";
				var colCnt = "";
				var colTotNum = "";
				if(op_header_nm==""){
					//op_header_nm="Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm|";
					//op_header_cd = "Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm|";
				}
        op_header_cd = op_header_cd.substring(1,op_header_cd.length);
				aryCD = op_header_cd.split("|");
        op_header_nm = op_header_nm.substring(1,op_header_nm.length);
				aryTitle = op_header_nm.split("|");
				colCnt = aryTitle.length;
				colTotNum = parseInt(colCnt)+7;

				with (sheetObj) {
					SheetWidth = mainTable6.clientWidth;						//전체너비설정
					if(location.hostname!="") InitHostInfo(location.hostname,location.port,page_path); //Host정보설정[필수][HostIp,Port,PagePath]
					MergeSheet = msNone;									//전체Merge종류[선택,DefaultmsNone]
					Editable  =true;										//전체Edit허용여부[선택,Defaultfalse]
					InitRowInfo(1,1,9,100);									//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colTotNum,7,0,true);						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true,false,false,true,false,false);		//해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
					var HeadTitle="STS|Vessel|OPR|VSLClass|"+op_header_nm+"|Total|Sublet Charge|Layup Cost Savings";
					InitHeadRow(0,HeadTitle,true);							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
					var tot="";
					var col=0;

					//데이터속성    [ROW, 	COL,  	DATATYPE,	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, 		CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ ,	dtStatus,	30,		daCenter,		true, 		"ibflag");
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter,		false,		"vsl_cd",			false,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,		false,		"vop_cd",			false,        "",       dfNone,          0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,		70,		daRight, 		false,		"vsl_clss_capa",	false,        "",       dfInteger,       0,     false,      false);
					for(j=0; j<colCnt; j++){
						InitDataProperty(0, cnt++ , dtData,	120,    daRight, 		false,		aryCD[j],			false,        "",       dfNullInteger,      0,     true,       true);
						tot = tot + "|" + aryCD[j]+  "|" ;
						if(j != colCnt-1 ) tot = tot +  " + ";
					}
					InitDataProperty(0, cnt++ , dtData,	    100,	daRight, 		false,		"tot",				false,        tot,     dfNullInteger,       0,     false,      false);
					InitDataProperty(0, cnt++ , dtData,	    100,	daRight, 		false,		"vsl_dly_uc_amt",	false,        "",      dfNullInteger,       0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,	    100,	daRight, 		false,		"lyp_cost_amt",		false,        "",      dfNullInteger,       0,     false,      false);

					CountPosition  = 0 ;
					style.height = GetSheetHeight(16) ;
				}
				break;

			case 7:      // Step3 : Tab5 : Network Cost > Retrieve
				var aryCD = "";
				var colCnt = "";
				var colTotNum = "";

				if(op_header_nm==""){
					//op_header_nm="Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm";
					//op_header_cd = "Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm";
				}
                op_header_cd = op_header_cd.substring(1,op_header_cd.length);
				aryCD = op_header_cd.split("|");
                op_header_nm = op_header_nm.substring(1,op_header_nm.length);
				aryTitle = op_header_nm.split("|");
				colCnt = aryCD.length;
				colTotNum = (colCnt)+22;

				with (sheetObj) {
				    style.height = GetSheetHeight(16) ;
					SheetWidth = mainTable7.clientWidth;						//전체너비설정
					if(location.hostname!="") InitHostInfo(location.hostname,location.port,page_path); //Host정보설정[필수][HostIp,Port,PagePath]
					MergeSheet = msNone;									//전체Merge종류[선택,DefaultmsNone]
					Editable  = false;										//전체Edit허용여부[선택,Defaultfalse]
					InitRowInfo(1,1,9,100);									//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colTotNum,0,0,true);						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true,false,false,true,false,false);		//해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
					var HeadTitle="totsum_code|subsum_sect|subsum_clss|No|sect_no|R.Lane|Dir|BSA Capa|Vessel|Port|TMNL|Ind|Dir Apply Ratio(%)|Port Charge|Canal Fee|Sea Days|Port Days|Bunker(F.O.)|Bunker(D.O.)|Total Days|"+op_header_nm+"|Total|vop_cd";
					InitHeadRow(0,HeadTitle,true);							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
					var tot="";
					var col=0;

                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "totsum_code",  false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "subsum_sect",  false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "subsum_clss",  false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		" ",			false,              "",       dfNone,            0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,		true,		"sect_no",			false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter, 		true,		"rlane_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"skd_dir_cd",	    false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daRight, 		true,		"vsl_clss_capa",	false,          "",       dfNumber,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"vsl_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"port_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter, 		true,		"tml_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter, 		true,		"vsl_dbl_call_seq",	false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		105,		daRight, 		true,		"dir_asgn_rto",	    false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"pt_tf",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"cl_tf",	        false,          "",       dfFloat,       2,     true,      true);
//					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"port_charge",	    false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"sea_dys",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"port_dys",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"f_o",	            false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"d_o",	            false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"ttl_dys",	        false,          "",       dfFloat,       2,     true,      true);
					tot = "|pt_tf|+|cl_tf|+|f_o|+|d_o|";
					for(j=0; j<colCnt; j++){
    					if(j == 0) tot = tot + "+";
	        			InitDataProperty(0, cnt++ , dtData,	120,    daRight, 		true,		aryCD[j],			false,          "",       dfFloat,       2,     true,       true);
			        	tot = tot + "|" + aryCD[j]+  "|" ;
					    if(j != colCnt-1 ) tot = tot +  " + ";
					}
					InitDataProperty(0, cnt++ , dtData,	100,	daRight, 		true,		"tot",				false,          tot,      dfFloat,       2,     false,      false);
					InitDataProperty(0,	cnt++ , dtHidden,   60,	    daRight,        true,	    "vop_cd",		    false,		    "",		  dfNone,		 0,		false,		false);

					CountPosition  = 0 ;
				}
				break;

			case 8:      // Step3 : Tab6 : Afrter OCN T/S
				var aryCD = "";
				var colCnt = "";
				var colTotNum = "";

				if(op_header_nm==""){
					//op_header_nm="Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm";
					//op_header_cd = "Crew|Store|Repair|Lubricant|Insurance|VSL Dep|Other Exp|General|T/C|Tel Comm";
				}
        op_header_cd = op_header_cd.substring(1,op_header_cd.length);
				aryCD = op_header_cd.split("|");
        op_header_nm = op_header_nm.substring(1,op_header_nm.length);
				aryTitle = op_header_nm.split("|");
				colCnt = aryCD.length;
				colTotNum = (colCnt)+23;

				with (sheetObj) {
				    style.height = GetSheetHeight(16) ;
					SheetWidth = mainTable8.clientWidth;						//전체너비설정
					if(location.hostname!="") InitHostInfo(location.hostname,location.port,page_path); //Host정보설정[필수][HostIp,Port,PagePath]
					MergeSheet = msNone;									//전체Merge종류[선택,DefaultmsNone]
					Editable  = false;										//전체Edit허용여부[선택,Defaultfalse]
					InitRowInfo(1,1,9,100);									//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colTotNum,0,0,true);						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true,false,false,true,false,false);		//해더에서처리할수있는각종기능을설정한다[SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Heade3D]
					var HeadTitle="totsum_code|subsum_sect|subsum_clss|No|sect_no|R.Lane|Dir|BSA Capa|Vessel|Port|TMNL|Ind|Dir Apply Ratio(%)|Local Ratio(%)|Port Charge|Canal Fee|Sea Days|Port Days|Bunker(F.O.)|Bunker(D.O.)|Total Days|"+op_header_nm+"|Total|vop_cd";
					InitHeadRow(0,HeadTitle,true);							//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false,HIDDEN=false]
					var tot="";
					var col=0;

					//데이터속성    [ROW, 	COL,  	DATATYPE,	WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,  		KEYFIELD, 		CALCULOGIC, DATAFORMAT, 	POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "totsum_code",  false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "subsum_sect",  false, "", dfNone,    0, false, false);
                    InitDataProperty(0, cnt++, dtHidden,   0, daCenter, true,  "subsum_clss",  false, "", dfNone,    0, false, false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,		true,		" ",			false,              "",       dfNone,            0,     true,      true);
					InitDataProperty(0, cnt++ , dtHidden,	60,		daCenter,		true,		"sect_no",			false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		70,		daCenter, 		true,		"rlane_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"skd_dir_cd",	    false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daRight, 		true,		"vsl_clss_capa",	false,          "",       dfNumber,      0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"vsl_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter, 		true,		"port_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter, 		true,		"tml_cd",	        false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter, 		true,		"vsl_dbl_call_seq",	false,          "",       dfNone,        0,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		105,	daRight, 	    true,		    "dir_asgn_rto",	    false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"local_ratio",	    false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"pt_tf",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"cl_tf",	        false,          "",       dfFloat,       2,     true,      true);
//					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"port_charge",	    false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"sea_dys",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"port_dys",	        false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"f_o",	            false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"d_o",	            false,          "",       dfFloat,       2,     true,      true);
					InitDataProperty(0, cnt++ , dtData,		90,		daRight, 		true,		"ttl_dys",	        false,          "",       dfFloat,       2,     true,      true);
					tot = "|pt_tf|+|cl_tf|+|f_o|+|d_o|";
					for(j=0; j<colCnt; j++){
					if(j == 0) tot = tot + "+";
					InitDataProperty(0, cnt++ , dtData,	120,    daRight, 		true,		aryCD[j],			false,          "",       dfFloat,       2,     true,       true);
					tot = tot + "|" + aryCD[j]+  "|" ;
					if(j != colCnt-1 ) tot = tot +  " + ";
					}
					InitDataProperty(0, cnt++ , dtData,	100,	daRight, 		true,		"tot",				false,          tot,      dfFloat,       2,     false,      false);
					InitDataProperty(0,	cnt++ , dtHidden,   60,	    daRight,        true,	    "vop_cd",		    false,		    "",		  dfNone,		 0,		false,		false);

					CountPosition  = 0 ;

				}
				break;
		}
	}

// Step3 : Tab1 : CM_Lane Summary  --------------------------------------------------------
	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		var formObj = document.form;

        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;

				var sXml = formObj.sXml.value;
				var arrXml = sXml.split("|$$|");
				document.form.sXml.value = "";

				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.f_slan_cd, "code", "name");
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_dept_cd2, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_sim, "code", "name");
				if (arrXml.length > 3)
					ComXml2ComboItem(arrXml[3], formObj.f_sgrp_cost_cd, "code", "name");

				with(formObj) {
					ComSetObjValue(f_sim, ComMasGetEtcData(arrXml[0], "f_sim"));
					ComSetObjValue(f_slan_cd,ComMasGetEtcData(arrXml[0], "f_slan_cd"));
					ComSetObjValue(f_sim_dt,ComMasGetEtcData(arrXml[0], "f_sim_dt"));
					ComSetObjValue(f_sim_no,ComMasGetEtcData(arrXml[0], "f_sim_no"));
					ComSetObjValue(f_sim_rmk,ComMasGetEtcData(arrXml[0], "f_sim_rmk"));
					ComSetObjValue(f_dept_cd,ComMasGetEtcData(arrXml[0], "f_dept_cd"));
					ComSetObjValue(f_dept_cd2,ComMasGetEtcData(arrXml[0], "f_dept_cd2"));
					ComSetObjValue(f_usr_id,ComMasGetEtcData(arrXml[0], "f_usr_id"));
				}
				ComOpenWait(false);
				break;
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                sheetObj.DoSearch4Post("ESM_MAS_0053GS.do", masFormQueryString(formObj));
                ComOpenWait(false);
                break;

            case IBDOWNEXCEL:        //엑셀 다운로드
                var excelType = selectDownExcelMethod(sheetObj);
				switch (excelType) {
					case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        sheetObjects[1].Down2Excel(0, true, false, true);
                        break;
					case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        sheetObjects[1].Down2Excel(-1, false, false, true);
                        break;
   					case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        sheetObjects[1].SpeedDown2Excel(0, false, false);
                        break;
					case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        sheetObjects[1].SpeedDown2Excel(-1, false, false);
                        break;
                }
//                sheetObj.Down2Excel(-1, false, false, true);
//                sheetObjects[1].Down2Excel(-1, true, false, true);
                break;

        }
	}
    /**
     *
     */
    function sheet1_OnSearchEnd(sheetObj,ErrMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,3) = "TOTAL" ;
    }
    /**
     * section number에 해당하는 vessel info를 조회한다.
     */
    function sheet1_OnDblClick(sheetObj , row, col){
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];
        var formObj = document.form;

        if(sheetObj.CellValue(row, "port_dys")!=""){

            formObj.rdoCode[0].checked = true;
           // formObj.f_sgrp_cost_cd[0].selected = true;
            formObj.f_sgrp_cost_cd.Index= 0;
//            formObj.sRow.value = row;
            displayType("0");

            doActionIBSheet1(sheetObj1,formObj,IBSEARCH);
            formObj.subtitle.value = sheetObj.CellValue(row,0) + " / " + ComGetObjValue(formObj.f_slan_cd)
                                     + " / " + sheetObj.CellValue(row,"rlane_cd") + " / " + sheetObj.CellValue(row,"ioc_cd")+ " / " + sheetObj.CellValue(row,"skd_dir_cd");

        }else{
            //ComShowMessage(sheetObj.CellValue(row, "port_dys"));
            // [MAS10015] : Proforma SKD를 먼저 확인하세요.
            ComShowMessage(ComGetMsg("MAS10015","Proforma SKD"));
            sheetObj1.RemoveAll();
        }
    }

    /**
     * 이전화면에서 넣은 값이 있을경우 현재 셀이 '0'이면 셀에 색깔을 넣는다.
     */
    function drawColor(){
        var sheetObj2 = sheetObjects[1];
        var sheetObj3 = sheetObjects[2];

        for(k=1; k<= sheetObj3.RowCount; k++){
            for(j=2; j< sheetObj3.LastCol-2; j++){
                if(sheetObj3.CellValue(k, j) > 0 && sheetObj2.CellValue(k, j) == 0){
                    sheetObj2.CellBackColor(k, j) = sheetObj2.RgbColor(247,231,236);
                }else if(sheetObj2.CellValue(k, j) > 0 && sheetObj3.CellValue(k, j) == 0){
                    sheetObj2.CellBackColor(k, j) = sheetObj2.RgbColor(221,239,255);
                } else {
                    sheetObj2.CellBackColor(k, j) = sheetObj2.RgbColor(255,255,255);
                }
            }
        }
    }

    /**
     * Tab1 Route Summary 의 cheak box 클릭시 처리
     */
    function displayType(param1){
        var formObj = document.form;
        var sheetObj1 = sheetObjects[1];
        var sheetObj2 = sheetObjects[2];
        var colCnt = 0;        // 총 컬럼수
        var rowNo = 0;
        var cnt = 0;
        var k = 2;

        colCnt = sheetObj1.LastCol+1;
        cnt = (colCnt -2)/2;

        if(param1 == 0){//단가
        	tr_save1.style.display = "";
            sheetObj1.Editable = true;
            for(i=2; i<colCnt; i++){
                if(i<cnt+2){
                    sheetObj1.ColHidden(i) = false;
                }else{
                    sheetObj1.ColHidden(i) = true;
                }
            }

        }else if(param1 == 1){//비용
        	tr_save1.style.display = "none";
            sheetObj1.Editable = false;

            k=2;
            for(i=2; i<colCnt; i++){
                if(cnt+2<=i){
                    sheetObj1.ColHidden(i) = false;
                    for(j=1; j<sheetObj1.LastRow; j++){
                        var status = sheetObj1.CellValue(j,"ibflag") ;
                        //ComShowMessage(sheetObj1.CellValue(j, k)+ " / " +sheetObj1.CellValue(sheetObj1.LastRow, "tot") +" = " +sheetObj1.CellValue(j, k)/sheetObj.CellValue(sheetObj.LastRow, "tot"));
                        sheetObj1.CellValue2(j, i) = sheetObj1.CellValue(j, k) * sheetObj2.CellValue(j, k);
                        if(status == "R") sheetObj1.CellValue2(j,"ibflag") = "R";
                    }
                    k++;
                }else{
                    sheetObj1.ColHidden(i) = true;
                }
            }
        }
    }

    /**
     * Cost Items 변경시
     */
    function chgSgrp_cost(){
        var sheetObj1 = sheetObjects[1];
        var sheetObj = sheetObjects[0];
        var formObj = document.form;

        if(sheetObj.CellValue(sheetObj.SelectRow, "port_dys")!=""){
            displayType(0);
            formObj.rdoCode[0].checked = true;
            doActionIBSheet1(sheetObj1,formObj,IBSEARCH);
        }
    }

//Step3 : Tab1 : CM_Route Summary ------------------------------------------------------
	/**
	 * Step3 : Tab1 : CM_Route Summary
	 */
	function doActionIBSheet1(sheetObj,formObj,sAction) {
        var formObj = document.form;
        var sheetObj1 = sheetObjects[0];
        var sheetObj2 = sheetObjects[1];
        var sheetObj3 = sheetObjects[2];
        var header = "";
        var sect_no = "";

        sect_no = sheetObj1.CellValue(sheetObj1.SelectRow, "sect_no");

        switch(sAction) {
            case IBSEARCH:      //조회
                if(!validateForm(sheetObj,formObj,sAction))return false;
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST02;
                sRow = sheetObj1.SelectRow;
                var sXml = sheetObj2.GetSearchXml("ESM_MAS_0053GS2.do?f_sect_no="+sect_no, masFormQueryString(formObj));

                //sheetObj2.LoadSearchXml(sXml);
                var sxml1 = searchEtcData("sxml1", sXml,1);
                var sxml2 = searchEtcData("sxml2", sXml,1);

                header = searchEtcData("header", sXml);
                formObj.f_tml_cd.value = header; // tml[Header] 정보를  폼변수에 넣는다.

                // sheet 초기화
                sheetObj2.Visible = false;
                sheetObj2.Redraw = false;
                sheetObj2.RemoveAll();
                sheetObj2.Reset();
                initSheet(sheetObj2, 2, "","","","",header);
                sheetObj2.Redraw = true;
                sheetObj2.Visible = true;
                if(sxml1 != "") sheetObj2.LoadSearchXml(sxml1);

                // sheet 초기화
                sheetObj3.Visible = false;
                sheetObj3.Redraw = false;
                sheetObj3.RemoveAll();
                sheetObj3.Reset();
                initSheet(sheetObj3, 3, "","","","",header);
                sheetObj3.Redraw = true;
                sheetObj3.Visible = true;
                if(sxml2 != "") sheetObj3.LoadSearchXml(sxml2);
                // Voulme 정보와 CM 정보를 비교하여 배경색을 달리 준다.
                drawColor();
                ComOpenWait(false);
                break;

            case IBSAVE:        //저장
                if(!validateForm(sheetObj,formObj,sAction))return false;
                if(sheetObj1.SelectRow < 1){
                    // [MAS10005] = Lane Summary 에 조회된 데이터가 존재하지 않습니다. Lane Summary 을(를) 먼저 조회하세요.
                    ComShowMessage(ComGetMsg("MAS10005","Lane Summary","Lane Summary"));
                    return false;
                }
                if(sheetObj1.CellValue(sheetObj1.SelectRow, "port_dys")==""){
                    // [MAS10015] : Proforma SKD를 먼저 확인하세요.
                    ComShowMessage(ComGetMsg("MAS10015","Proforma SKD"));
                    return false;
                }
                if(sheetObj2.LastRow<1){
                    // [MAS10027] : 저장할 내역이 없습니다.
                    ComShowMessage(sheetObj2.MessageText("UserMsg13"));
                    return false;
                }
                // 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;

                var params = new Array();
                params[0] = sheetObj2.GetSaveString(true);
                params[1] = sheetObj3.GetSaveString(true);

                var savexml = sheetObj2.GetSaveXml("ESM_MAS_0053GS.do?f_sect_no="+sect_no, ComGetAryJoin(params,"&")+"&"+masFormQueryString(formObj));
                sheetObj2.LoadSaveXml(savexml,true);
                ComOpenWait(false);
                doActionIBSheet(sheetObj1,formObj,IBSEARCH);
//                return false;
//                var sxml1 = searchEtcData("sxml1", savexml);
//                var sxml2 = searchEtcData("sxml2", savexml);
//                sheetObj1.LoadSaveXml(sxml1,true);
//                sheetObj2.LoadSaveXml(sxml2,true);
//                sheetObj1.SelectCell(sRow, "trd_cd");
                break;

        }
	}

    /**
     *
     */
    function sheet2_OnChange(sheetObj, row, col, value){
        var sheetObj2 = sheetObjects[1];
        var sheetObj3 = sheetObjects[2];

        // 값이 변경되면 해당 Row의 배경색이 초기화된다
        // 따라서 해당행을 모든 컬럼의 배경색을 변경해 주어야 한다.
        //-----------------------------------------------------------------
        for(j=2; j< sheetObj3.LastCol-2; j++){
            if(sheetObj2.CellValue(row, j) == 0 && sheetObj3.CellValue(row, j)>0){
                    sheetObj2.CellBackColor(row, j) = sheetObj2.RgbColor(247,231,236);
            }else if(sheetObj2.CellValue(row, j) > 0 && sheetObj3.CellValue(row, j) == 0){
                    sheetObj2.CellBackColor(row, j) = sheetObj2.RgbColor(221,239,255);
            }else{
                sheetObj2.CellBackColor(row, j) = sheetObj2.RgbColor(255,255,255);
            }
        }
    }
    /**
     *
     */
    function sheet2_OnSearchEnd(sheetObj,ErrMsg){
        var formObj = document.form;
        if(formObj.rdoCode[0].checked){
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,1) = "";
        } else {
            sheetObj.SumText(0,0) = "";
            sheetObj.SumText(0,1) = "TOTAL" ;
        }

    }


// Step3 : Tab2 : Port Charge---------------------------------------------------------
	/**
	 * Step3 : Tab2 : Port Charge
	 */
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;

		switch(sAction) {
			case IBSEARCH:      //조회
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST03;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS3.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBSAVE:        //저장
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI02;
				sheetObj.DoAllSave("ESM_MAS_0053GS3.do", masFormQueryString(formObj));
				ComOpenWait(false);
        doActionIBSheet3(sheetObj,formObj,IBSEARCH);
				break;

			case IBCREATE:        //
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI05;
//			var SaveStr = sheetObj.GetSaveString(true);
				sheetObj.DoSearch4Post("ESM_MAS_0053GS3.do", masFormQueryString(formObj));
				ComOpenWait(false);
        var Result = sheetObj.EtcData("result");
        sheetObj.RemoveEtcData();
        if (Result=="OK"){
              ComShowMessage(ComGetMsg("MAS10006"));
        }
        doActionIBSheet3(sheetObj,formObj,IBSEARCH);
				break;
        case IBDOWNEXCEL:        //엑셀 다운로드
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
//                sheetObj.Down2Excel(-1, false, false, true);
                break;
		}
	}

// Step3 : Tab3 : Bunker Cost --------------------------------------------------------
	/**
	 * Bunker Cost Sheet5관련 프로세스 처리
	 */
	function doActionIBSheet4(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction))return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST04;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS4.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBCREATE:      //creation
				if(!validateForm(sheetObj,formObj,sAction))return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI06;
//				sheetObj.DoSearch4Post("ESM_MAS_0053GS4.do", masFormQueryString(formObj));
				sheetObj.DoAllSave("ESM_MAS_0053GS4.do", masFormQueryString(formObj));
				ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("MAS10006"));
                      doActionIBSheet4(sheetObj,formObj,IBSEARCH);
                }
				break;

			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction))return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI03;
				sheetObj.DoAllSave("ESM_MAS_0053GS4.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

            case IBDOWNEXCEL:        //엑셀 다운로드
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
                //sheetObj.Down2Excel(-1, false, false, true);
                break;
		}
	}
	/**
	 * Bunker Cost Creation 후 재조회한다
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet5_OnSaveEnd(sheetObj,ErrMsg){
	    var formObj = document.form;

        var Result = sheetObj.EtcData("result");
        if (Result=="OK"){
              doActionIBSheet4(sheetObj,formObj,IBSEARCH);
        }

		sheetObj.RemoveEtcData();
	}
    /**
     * Bunker Cost Tab에서 콜
     * Consumption Matrix by Class 클릭시 팝업을 콜해줌
     */
    function callVslConsum(){
        var sheetObj = sheetObjects[4];
        var formObj = document.form;
        var param = "";

        if(sheetObj.SelectRow <2){
            ComShowMessage(ComGetMsg("MAS10002","Vessel Class"));
        } else {
            param = param + "?f_slan_cd=" + ComGetObjValue(formObj.f_slan_cd);
            param = param + "&f_sim_dt=" + ComGetObjValue(formObj.f_sim_dt);
            param = param + "&f_sim_no=" + ComGetObjValue(formObj.f_sim_no);
            param = param + "&f_vsl_capa=" + sheetObj.CellValue(sheetObj.SelectRow , "vsl_clss_capa");

            ComOpenWindowCenter("/hanjin/ESM_MAS_0151.do"+param,"PopupEsmMas0151",400,500,false);
        }
    }

// Step3 : Tab4 : Hire/TC Rev/Layup(Daily) --------------------------------------------
	/**
	 *  Hire/TC Rev/Layup(Daily) Sheet6관련 프로세스 처리
	 */
	function doActionIBSheet5(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;
		switch(sAction) {
			case IBSEARCH:      //조회
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST05;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS5.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBCREATE:      //creation
				if(!validateForm(sheetObj,formObj,sAction))return false;
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI07;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS5.do", masFormQueryString(formObj));
				ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                if (Result=="OK"){
                      ComShowMessage(ComGetMsg("MAS10006"));
                      doActionIBSheet5(sheetObj,formObj,IBSEARCH);
                }
                sheetObj.RemoveEtcData();
				doActionIBSheet5(sheetObj,formObj,IBSEARCH);
				break;

			case IBSAVE:        //저장
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI04;
				sheetObj.DoAllSave("ESM_MAS_0053GS5.do", masFormQueryString(formObj));
				ComOpenWait(false);
				doActionIBSheet5(sheetObj,formObj,IBSEARCH);
				break;

            case IBDOWNEXCEL:        //엑셀 다운로드
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
            //    sheetObj.Down2Excel(-1, false, false, true);
                break;

		}
	}


	function sheet6_OnSearchEnd(sheetObj,ErrMsg){
		var formObj = document.form;
		var v_layup_flg = sheetObj.EtcData("f_layup_flg");
		var v_lyp_cost_amt = sheetObj.EtcData("f_lyp_cost_amt");

		if(v_layup_flg == "Y"){
			formObj.f_layup_flg[0].checked = true;
			formObj.f_lyp_cost_amt.value = ComAddComma2(v_lyp_cost_amt,'#,###');
		} else{
			formObj.f_layup_flg[1].checked = true;
		}
		sheetObj.RemoveEtcData();
	}



	/**
	 * Laypu flag가 선택되었을경우 Layup cost amount를 sheet에 적용한다.
	 * 혹은 Layup cost amount가 변경되면 Layup flag를 확인하여 변경된 값을 sheet에 적용한다.
	 */
	function setLayup(){
	    var formObj = document.form;
	    var sheetObj = sheetObjects[5];
	    var rowcnt   = sheetObj.LastRow;

	    if(formObj.f_layup_flg[0].checked){
	        for(i=1; i<=rowcnt; i++){
	            if(sheetObj.CellValue(i, "vop_cd") == "OWN"){
	                sheetObj.CellValue(i,"lyp_cost_amt") = ComGetObjValue(formObj.f_lyp_cost_amt);
	            }else{
	                sheetObj.CellValue(i,"lyp_cost_amt") = "0";
	            }

	        }
	    } else {
	        for(i=1; i<=rowcnt; i++){
	            sheetObj.CellValue(i,"lyp_cost_amt") = "0";
	        }
	    }
	}

	/**
	 * TC/O Hire Table Popup을  콜한다.
	 */
	function callTCO() {
	    var formObj = document.form;
	    var sheetObj = sheetObjects[5];
	    var param = "";

	    ComOpenWindowCenter("/hanjin/ESM_MAS_0167.do","PopupEsmMas01671",400,350,false);
//	    noRtnPopup("ESM_MAS_167.do"+param, "width=400, height=500,menubar=0,status=0,scrollbars=0,resizable=0");
	}

// Step3 : Tab5 : Network Cost -----------------------------------------------------------
	/**
	 *  Network Cost Sheet7관련 프로세스 처리
	 */
	function doActionIBSheet6(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;

		switch(sAction) {
			case IBSEARCH:      //조회
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST06;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS6.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

			case IBCREATE:      //생성
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI08;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS6.do", masFormQueryString(formObj));
				ComOpenWait(false);
                var Result = sheetObj.EtcData("result");
                sheetObj.RemoveEtcData();
                if (Result=="OK"){
                    ComShowMessage(ComGetMsg("MAS10006"));
                }
				break;

            case IBDOWNEXCEL:        //엑셀 다운로드
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
//                sheetObj.Down2Excel(-1, false, false, true);
                break;

		}
	}
	/**
	 * Network Cost Sheet7 조회후 SubSum을 처리한다.
	 */
	function sheet7_OnSearchEnd(sheetObj,ErrMsg){
		var cols = "13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30";
		sheetObj.ShowSubSum( 0, cols, -1, true, false, 1 ,"3=Total");
		//sheetObj.ShowSubSum(0, "13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30" , true, true, true);
		sheetObj.ShowSubSum( 1, cols, -1, true, false, 1 ,"3=%s;5=Sec Total");
		sheetObj.ShowSubSum( 2, cols, -1, true, false, 1 ,"5=Class Total");
		sheetObj.ShowSubSum( 8, cols, -1, true, false, 1 ,"5=Vessel Total");
	}


// Step3 : Tab6 : Afrter OCN T/S ----------------------------------------------------------
	/**
	 *  After Ocean T/S Sheet8관련 프로세스 처리
	 */
	function doActionIBSheet7(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj = document.form;

		switch(sAction) {
			case IBSEARCH:      //조회
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST07;
				sheetObj.DoSearch4Post("ESM_MAS_0053GS7.do", masFormQueryString(formObj));
				ComOpenWait(false);
				break;

            case IBDOWNEXCEL:        //엑셀 다운로드
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
//                sheetObj.Down2Excel(-1, false, false, true);
                break;


		}
	}

	/**
	 * After Ocean T/S Sheet8 조회후 SubSum을 처리한다.
	 */
	function sheet8_OnSearchEnd(sheetObj,ErrMsg){
		var cols = "14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31";
		sheetObj.ShowSubSum( 0, cols, -1, true, false , 1 ,"3=Total");
		sheetObj.ShowSubSum( 1, cols, -1, true, false , 1 ,"3=%s;5=Sec Total");
		sheetObj.ShowSubSum( 2, cols, -1, true, false , 1 ,"5=Class Total");
		sheetObj.ShowSubSum( 8, cols, -1, true, false , 1 ,"5=Vessel Total");
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++, "    CM/EQ/ABC    " , -1 );
                    InsertTab( cnt++, "   Port Charge   " , -1 );
                    InsertTab( cnt++, "   Bunker Cost   " , -1 );
                    InsertTab( cnt++, "Hire/TC Rev/Layup(Daily)" , -1 );
                    InsertTab( cnt++, "   Network Cost   " , -1 );
                    InsertTab( cnt++, "   After T/S  " , -1 );
                }
             break;
        }
    }

	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer");
		var formObj = document.form;
		var sheetObj1 = sheetObjects[0];
		var sheetObj2 = sheetObjects[1];
		var sheetObj3 = sheetObjects[2];
		var sheetObj4 = sheetObjects[3];

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
		if(nItem == 2){
			document.all.dir_bnk_consum.style.display = "inline";
		} else {
			document.all.dir_bnk_consum.style.display = "none";
	    }
	}

	/**
	 * Step 단계별로 클릭 시 화면 display
	 */
	function InvOnChange( dst , m  ){
		document.getElementById(dst).style.display=m;
	}

	/**
	 * 소계 구하기
	 */
//	function sheet5_OnSearchEnd(sheetObj,ErrMsg){
//		//sheetObj.ShowSubSum( 0, "port_cd|tml_cd", -1, true, false , 1 ,"1=Sub Total");
//		for(j=1; j<sheetObj.LastRow; j++){
//		    if(sheetObj.CellValue(j, "port_clss_capa")==0) {
//		        sheetObj.CellEditable(j, "port_clss_capa") = true;
//		    }else{
//		        //sheetObj.CellEditable(j, "port_clss_capa") = true;
//		    }
//		}
//		sheetObj.SumText(0,0)="";
//		sheetObj.SumText(0,"port_cd")="TOTAL";
//	}


    /**
     *
     */
    function sheet7_OnChange(sheetObj, row, col, value){

        if(sheetObj.CellValue(row, "vop_cd") == "OWN"){
            if(col>6 && sheetObj.ColSaveName(col)!="OFTC"){
                if(value == 0){
                        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(247,231,236);
                }else{
                    sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,255,255);
                }
            } else {
//                sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(247,231,236);
            }
        } else {
            if(sheetObj.ColSaveName(col) == "OFTC"){
                if(value == 0){
                        sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(247,231,236);
                }else{
                    sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,255,255);
                }
            } else {
//                sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(247,231,236);
            }
        }
    }




    /**
     * Service Lane변경시 해당 Simulation No를 조회한다.
     */
    function chgSLane(obj){
    	 var formObj = document.form;
      	 var sheetObj = sheetObjects[0];

      	if (ComGetObjValue(obj) != "") {
         	var simNo = ComGetObjValue(formObj.f_sim);
 	 		formObj.f_cmd.value = SEARCHLIST10;
 	 		var sXml = sheetObj.GetSearchXml("ESM_MAS_0053GS3.do", masFormQueryString(formObj));
 	 		var arrXml = sXml.split("|$$|");

 	 		if (arrXml.length > 0)
 	 			ComXml2ComboItem(arrXml[0], formObj.f_sim, "code", "name");

 	 		ComSetObjValue(formObj.f_sim,simNo);
 	 		if (ComTrim(simNo) != ""){
 	 			setSimNo(formObj.f_sim);
 	 		}
         }
    }

    /**
     * SLane 데이터 변경시 Simulation Number combo box를 다시 세팅한다.
     */
    function f_slan_cd_OnChange(cboObj, value, text){
    	if (loadingMode == true) return;
      	if(ComTrim(value) != "" ) { // S.Lane
      		chgSLane(cboObj);
      	}
    }
	function f_sim_OnChange(cboObj, value, text) {
		if (loadingMode == true)
			return;
		setSimNo(cboObj);
	}

	/**
	 * Simulation No Combo box에서 데이터 선택시 아래의 input box에 데이터를 입력한다.
	 */
	function setSimNo(Obj) {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		if (ComGetObjValue(Obj) != "") {
			var param = "f_cmd=" + SEARCH01;
			param = param + "&f_sim=" + ComGetObjValue(Obj);
			param = param + "&f_slan_cd=" + ComGetObjValue(formObj.f_slan_cd);

			var sXml = sheetObj.GetSearchXml("MasCommonUtilGS.do", param);
			var arrXml = sXml.split("|$$|");
			if (0 < arrXml.length && ComGetEtcData(arrXml[0], "sim_dt") != undefined) {
				ComSetObjValue(formObj.f_sim_dt, ComGetEtcData(arrXml[0], "sim_dt"));
				ComSetObjValue(formObj.f_sim_no, ComGetEtcData(arrXml[0], "sim_no"));
				ComSetObjValue(formObj.f_sim_rmk, ComGetEtcData(arrXml[0], "sim_rmk"));
				ComSetObjValue(formObj.f_usr_id, ComGetEtcData(arrXml[0], "sim_usr_id"));
				ComSetObjValue(formObj.f_dept_cd, ComGetEtcData(arrXml[0], "sim_dept_cd"));
				ComAddSeparator(formObj.f_sim_dt);
			}
		}
	}

    /**
     * 상태표시를 제거한다.
     */
    function closeStatus(){
//        zu_openRunning(false);
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(ComGetObjValue(f_slan_cd) == "") {
			    ComShowMessage(ComGetMsg("MAS10002","S.Lane"));
			    ComSetFocus(f_slan_cd);
			    return false;
			}
			if(ComGetObjValue(f_sim_dt) == "") {
			    ComShowMessage(ComGetMsg("MAS10002","Simulation Date"));
			    ComSetFocus(f_sim_dt);
			    return false;
			}
			if(ComGetObjValue(f_sim_no) == "") {
			    ComShowMessage(ComGetMsg("MAS10002","Simulation Number"));
			    ComSetFocus(f_sim_no);
			    return false;
			}
			if(tabObjects[0].SelectedIndex==3 && sAction == COMMAND01){
				if(ComGetObjValue(formObj.f_fm_yyyymm) == ""){
				    ComShowMessage(ComGetMsg("MAS10002","Source Period"));
				    ComSetFocus(f_fm_yyyymm);
				    return false;
				}
				if(ComGetObjValue(formObj.f_to_yyyymm) == ""){
				    ComShowMessage(ComGetMsg("MAS10002","Source Period"));
				    ComSetFocus(f_to_yyyymm);
				    return false;
				}
			    if(parseInt(ComGetObjValue(f_to_yyyymm).substring(5)) - parseInt(ComGetObjValue(f_fm_yyyymm).substring(5)) > 2){
			        //msgs['MAS10003'] = msg1 + '는(은) ' + msg2 + '만 처리할수 있습니다.';
    			    ComShowMessage(ComGetMsg("MAS10003","Creation", "3 month"));
    			    ComSetFocus(f_to_yyyymm);
    			    return false;
			    }
			}
            // Added By Ki-Dae Kim.
            // when : 2009-06-24
            if(tabObjects[0].SelectedIndex==2 && sAction == IBCREATE){
                var values = false;
                var rowCnt = sheetObj.LastRow;
                for(var i=2; i<=rowCnt; i++){
                    //if(sheetObj.CellValue(i, "ibflag") == "I"){
                    if(sheetObj.RowStatus(i) == "I"){
                        values = true;
                    }
                }
                if(values == true){
                	ComShowMessage(ComGetMsg("MAS10014",""));
                    return false;
                }
            }

		}

		return true;
f	}

	    /**
     * Step 단계별로 화면 이동
     */
    function doActionPageMove(sheetObj, formObj, btnName){
        formObj.f_cmd.value = "";
        formObj.method = "POST";
        formObj.target = "";

        // MultCombo 일경우 submit()으로 넘기면 데이터를 정상적으로 넘길수 었기 때문에 아래와 같이 GET 방식으로 데이터를 넘긴다
        if (btnName == "step01"){
            formObj.action = "ESM_MAS_0051.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_MAS_0051";
            formObj.submit();
        }else if(btnName == "step02"){
            formObj.action = "ESM_MAS_0052.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_MAS_0051";
            formObj.submit();
        }else if(btnName == "step03"){
            formObj.action = "ESM_MAS_0053.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_MAS_0051";
            formObj.submit();
        }else if(btnName == "step04"){
            formObj.action = "ESM_MAS_0054.do?f_slan_cd="+formObj.f_slan_cd.Code+"&pgmNo=ESM_MAS_0051";
            formObj.submit();
        }
    }