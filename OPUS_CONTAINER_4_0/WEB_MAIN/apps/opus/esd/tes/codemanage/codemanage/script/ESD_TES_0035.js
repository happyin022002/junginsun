/**
 * @fileoverview 에서 사용하는 업무 스크립트를 정의한다.
 * @author 
 */

/**
 * @extends Tes
 * @class ESD_TES_0035 : 에서 사용하는 업무 스크립트를 정의한다.
 */
function ESD_TES_0035() {
	this.processButtonClick = processButtonClick;
	this.setSheetObject = setSheetObject;
	this.setComboObject = setComboObject;
	this.setTabObject = setTabObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.initTab = initTab;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
				 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;
var Mincount = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject = sheetObjects[0];

		 /*******************************************************/
		 var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");


			switch(srcName) {

				case "btn_retrieve":
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
	    	        break;
	
				case "btn_new":
		            sheetObject.RemoveAll();
		            formObject.reset();
	    	        break;
	    	        
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(getMsg('TES21025'));
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
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 * @return
	 */
	function loadPage() {

		for(i=0;i<sheetObjects.length;i++){

		//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);

			initSheet(sheetObjects[i],i+1);
		//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}

		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);

	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {int} sheetNo 	시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 							시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {

		var cnt = 0;

		switch(sheetNo) {
			case 1:	  //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(22);
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

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(13, 1, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					var HeadTitle = "Cost Code|Calc Method|AGMT MGMT Code|MRN TML|On Dock Rail Charge|Off Dock CY TMNL|Off Dock CY STO|STO Inv|CFS|Rail Ramp|Exclude TMNL|RVS CNTR List Code|CNTR STY Code" ;

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++ , dtData,	 		100,		daCenter,		false,	"lgs_cost_cd",			false,			"",			dfNone,			0,			false,			true,   3);
					InitDataProperty(0, cnt++ , dtData,	 		100,		daCenter,		false,	"cost_calc_mzd_cd",		false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		120,		daCenter,		false,	"tml_agmt_mgmt_cd",		false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		80,			daCenter,		false,	"mrn_tml_flg",			false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		120,		daCenter,		false,	"odck_rail_chg_flg",	false,			"",			dfNone,			0,			false,			true	);
					
					InitDataProperty(0, cnt++ , dtData,	 		120,		daCenter,		false,	"fdck_cy_tml_flg",		false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		120,		daCenter,		false,	"fdck_cy_sto_flg",		false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		80,			daCenter,		false,	"sto_inv_flg",			false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		80,			daCenter,		false,	"cfs_flg",				false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		100,		daCenter,		false,	"rail_rmp_flg",			false,			"",			dfNone,			0,			false,			true	);
					
					InitDataProperty(0, cnt++ , dtData,	 		100,		daCenter,		false,	"xcld_tml_flg",			false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		120,		daCenter,		false,	"rvis_cntr_list_cd",	false,			"",			dfNone,			0,			false,			true	);
					InitDataProperty(0, cnt++ , dtData,	 		100,		daCenter,		false,	"cntr_sty_cd",			false,			"",			dfNone,			0,			false,			true	);
			   }
				break;
		}
	}

	/**
	 * Sheet 관련 프로세스 처리
	 * @param {ibsheet} sheetObj 	IBSheet Object
	 * @param {form} 	formObj		Form Object
	 * @param {int}		sAction		실행할 액션 구분 값
	 * @return
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {

            case IBSEARCH:	  //조회

				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("ESD_TES_0035GS.do", tesFrmQryStr(formObj));
					//sheetObj.DoSearch4Post("com.clt.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", tesFrmQryStr(formObj));
				}
				break;
			case IBSAVE:		//저장
				if(validateForm(sheetObj,formObj,sAction)) { 
					//ComShowMessage (" Save .. ");
					formObj.f_cmd.value = MULTI;
				    sheetObj.DoSave("ESD_TES_0035GS.do", tesFrmQryStr(formObj),-1,false);
				}
				break;

			case IBINSERT:	  // 입력
				sheetObj.DataInsert();
				break;

            case IBCOPYROW:		//행 복사
			  sheetObj.DataCopy();
			  break;

		   case IBDOWNEXCEL:		//엑셀 다운로드
			  sheetObj.Down2Excel(-1, false, false, true);

			  break;

		   case IBLOADEXCEL:		//엑셀 업로드
			  sheetObj.LoadExcel();
			  break;

		}
	}


   /**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
//			if (!isNumber(iPage)) {
//
//				return false;
//			}
		}

		return true;
	}

	/**
	 * MInimize 클릭시 이벤트 관련
	 * @param {string}	nItem	display 여부
	 * @return
	 */
	function Minimize(nItem)
	{

		var objs = document.all.item("showMin");

		if ( nItem == "1" )
		{
			objs.style.display = "none";


			sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =20;

		}
		else
		{
			objs.style.display = "inline";

			sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(10);
			sheetObjects[0].focus();
			sheetObjects[0].ViewRows  =10;

		}

	}