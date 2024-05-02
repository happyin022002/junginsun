/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_COA_0139.js
*@FileTitle : Feeder Term
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2007-05-22 Lee Ho Ik
* 1.0 최초 생성
*=========================================================
* History :
* 2009.07.24 장영석 New Framework 적용
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*                  CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2011.02.25 최성민 [CHM-201109103-01] row add bug fixed
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
*=========================================================*/
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
     * @class ESM_COA_0139 : ESM_COA_0139 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0139() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnDblClick      = sheet1_OnDblClick;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.openLocationCode 		= openLocationCode;
    	this.getFPor     			= getFPor;
    	this.getFDel     			= getFDel;
    	this.Popup       			= Popup;
    }

   	/* 개발자 작업	*/
 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /**
     * 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
     */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
     */
    function processButtonClick(){
    	var sheetObject = sheetObjects[0];
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		switch(srcName) {
    			case "btng_RowAdd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;
    			case "btng_RowDel":
    				doActionIBSheet(sheetObject,formObject,IBDELETE);
    				break;
    			case "btn_Reset":
    				doActionIBSheet(sheetObject,formObject,IBRESET);
                    loadPage();
    				break;
    			case "btn_Retrieve":
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_Save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    			case "btn_DownExcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;
    			case "btn_LoadExcel":
    				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
    				break;
    		} // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(getMsg(OBJECT_ERROR));
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    }

    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

    	if(sheetNo==1) {
    		with (sheetObj) {
    			SheetWidth = mainTable.clientWidth;//전체 너비 설정
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    			MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    			Editable = true;//전체Edit 허용 여부 [선택, Default false]
    			InitRowInfo( 2, 1, 1, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitColumnInfo(7, 3, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitHeadMode(true, true, true, true, true, true)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

    			var HeadTitle  = "Sel.| |Org. Loc.|Dest. Loc.|F/M|Feeder Rcv. Term|Feeder DE. Term" ;
    			var HeadTitle1 = "| |Org. Loc.|Dest. Loc.|F/M|Feeder Rcv. Term|Feeder DE. Term" ;

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle,  true);
    			InitHeadRow(1, HeadTitle1, true);

    			//데이터속성	    [ROW, COL  , DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME               , KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP  , ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0  , cnt++, dtDelCheck, 50   , daCenter , false   , "dtDelCheck"         , false   , ""        ,	dfNone   ,	0        , true      ,	true    , -1     , false    , true      , "");
    			InitDataProperty(0  , cnt++, dtStatus  , 30   , daCenter ,  true   , "ibflag"             , false   , ""        ,	dfNone   ,	0        , false     ,	false   , -1     , false    , true      , "");
    			InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "org_loc_cd"         , true    , ""        ,	dfNone   ,	0        , false     ,	true    , 5);
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "dest_loc_cd"        , true    , ""        ,	dfNone   ,	0        , false     ,	true    , 5);
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "full_mty_cd"        , true    , ""        ,	dfNone   ,	0        , false     ,	true    , 1);
                InitDataProperty(0  , cnt++, dtData    , 150  , daCenter ,  true   , "fdr_rcv_term_cd"    , false   , ""        ,	dfNone   ,	0        , true      ,	true    );
                InitDataProperty(0  , cnt++, dtData    , 100  , daCenter ,  true   , "fdr_de_term_cd"     , false   , ""        ,	dfNone   ,	0        , true      ,	true    );

    			CountPosition	= 2 ;
    			style.height = GetSheetHeight(15) ;
                RangeBackColor(0, 2, 0, 3) = RgbColor(220, 235, 252);

                InitDataValid(0, "org_loc_cd", vtEngUpOther, "1234567890");
                InitDataValid(0, "dest_loc_cd", vtEngUpOther, "1234567890");
                InitDataValid(0, "full_mty_cd", vtEngUpOnly);

                ToolTipOption = "balloon:true;width:1000;icon:1";
                ToolTipText(0,"org_loc_cd") = "DoubleClick Org. Loc. to retrieve the RCV. Term Ratio.";
                ToolTipText(0,"dest_loc_cd") = "DoubleClick Dest. Loc. to retrieve the DEL. Term Ratio.";
    		}
    	}
    }


    /**
    * sheet1을 더블클릭하여 팝업화면을 띄운다.
    * ORG_LOC_CD를 더블 클릭했을 때 RCV CALC 데이터 조회
    * DEST_LOC_CD를 더블 클릭했을 때 DEL CALC 데이터 조회
    */
    function sheet1_OnDblClick(sheetObj , row, col){
        if(sheetObj.ColSaveName(col) == "org_loc_cd"){          // Org을 선택했을 경우
    		var str = "f_calc_term_cd=RCV" +
    				  "&f_wtr_term_cd=" + sheetObj.CellValue(row, "fdr_rcv_term_cd") ;
        } else if(sheetObj.ColSaveName(col) == "dest_loc_cd"){  // Dest를 선택했을 경우
            var str = "f_calc_term_cd=DEL" +
    				  "&f_wtr_term_cd=" + sheetObj.CellValue(row, "fdr_de_term_cd") ;
        } else {
            return;
        }

        str = str + "&sysCommUiTitle=Feeder Term Ratio";

        // 팝업창 팝업
    	Popup(str);
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;

    	switch(sAction) {
    		case IBINSERT:                  // 입력
    			sheetObj.DataInsert(-1);
    			break;
    		case IBDELETE:                  // 입력
    			sheetObj.RowDelete(sheetObj.SelectRow, false);
    			break;
    		case IBRESET:                  // RESET
                sheetObj.reset();
    			break;
    		case IBSEARCH:		           //조회
    			// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = SEARCHLIST;
    			sheetObj.DoSearch4Post("ESM_COA_0139GS.do", coaFormQueryString(formObj));
    			ComOpenWait(false);
    			break;
    		case IBSAVE:                  // 저장
    			// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
    			formObj.f_cmd.value = MULTI;
    			sheetObj.DoSave("ESM_COA_0139GS.do", coaFormQueryString(formObj), -1, true);
    			ComOpenWait(false);
    			break;
           case IBDOWNEXCEL:            //엑셀 다운로드
    			//sheetObj.SpeedDown2Excel(-1, true, true);
    			var excelType = selectDownExcelMethod(sheetObj);
    			switch (excelType) {
    				case "AY":
    					sheetObj.Down2Excel(0, false, false, true, "", "", true);
    					break;
    				case "DY":
    					sheetObj.Down2Excel(-1, false, false, true, "", "", true);
    					break;
    				case "AN":
    					sheetObj.SpeedDown2Excel(0, false, false, "", "", true);
    					break;
    				case "DN":
    					sheetObj.SpeedDown2Excel(-1, false, false, "", "", true);
    					break;
    			}
    			break;
    		case IBLOADEXCEL:                  // 엑셀로드
                sheetObj.LoadExcel(-1, 1, "", -1, -1, "");
    			break;
    	}
    }

    /**
    * location code 공통 팝업 오픈
    */
    function openLocationCode(funtionNm){
    	ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490, funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1');
    }

    /**
     * 팝업창에서 선택한 por location을 받아서
     * por 입력칸에 넣고 del 입력칸으로 커서 이동
     */
    function getFPor(rowArray) {
    	var colArray = rowArray[0];
    	document.form.f_por.value = colArray[3];
    	document.form.f_del.focus();
    }

    /**
     * 팝업창에서 선택한 del location을 받아서
     * del 입력칸에 넣는다.
     */
    function getFDel(rowArray) {
    	var colArray = rowArray[0];
    	document.form.f_del.value = colArray[3];
    }

    /**
     * 팝업 함수
     */
    function Popup(str){
    	ComOpenWindow2("ESM_COA_0140.do?" + str,'','width=900, height=500, menubar=no, scrollbars=no, resizable=yes');

    }

	/* 개발자 작업  끝 */