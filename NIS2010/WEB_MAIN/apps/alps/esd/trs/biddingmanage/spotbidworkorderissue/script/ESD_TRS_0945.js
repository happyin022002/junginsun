/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_921.js
*@FileTitle : More Bidder 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-2-3
*@LastModifier : Bong-jun
*@LastVersion : 1.125
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.9 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 1.10 2010.12.28 민정호 [CHM-201008042] AGMT 적용시 Customer Nominated 적용
* 2011.05.06  손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.07.03 김영철 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
=========================================================*/ 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0945 : Morecandidate
 */
function ESD_TRS_0945() {
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
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
 
// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
			switch (srcName) {
			case "btn_apply":
				if (setMoreBidder(sheetObject))
					window.close();
				break;
			case "btn_close":
				window.close();
				break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('TRS90384');
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

    /**
	 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는
	 * 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
	
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
		// html컨트롤 이벤트초기화
		initControl();
	}

     /**
		 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
		 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
		 * 
		 * @param {ibsheet}
		 *            sheetObj IBSheet Object
		 * @param {int}
		 *            sheetNo sheetObjects 배열에서 순번
		 */
	function initControl() {
	}

   /**
	 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에
	 * 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 280;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle0 = "More Bidder|More Bidder|More Bidder|More Bidder|More Bidder|More Bidder|More Bidder";

                    var HeadTitle1 = "Sel.|Seq|S/P Code|S/P Name|Currency|Rate|Rate(USD)";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtRadioCheck ,  30, daCenter, true, "ibcheck"																	);
                    InitDataProperty(0, cnt++, dtSeq      	,  30, daCenter, true, ""						, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData       ,  80, daCenter, true, "vndr_seq"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData       , 240, daLeft,   true, "vndr_nm"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  80, daCenter, true, "spot_bid_curr_cd"		, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  80, daRight,  true, "spot_bid_amt"			, false, "", dfFloat		, 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  80, daRight,  true, "spot_bid_usd_amt"		, false, "", dfFloat		, 2, false	, false		);
                    HeadRowHeight = 30;
               }
                break;
        }
    }

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

            case IBSEARCH:        //저장
                formObj.f_cmd.value = SEARCH40;            
                sheetObj.DoSearch4Post ("ESD_TRS_0945GS.do" , TrsFrmQryString(formObj));
                break;
        }
    }


    /**
     * More Bidder
     */
    function setMoreBidder(sheetObj) {
		var formObject = document.form;
		var opener_obj = window.dialogArguments;

		var main_sheetObject = opener_obj.sheetObjects[0];

		for ( var i = 2; i < sheetObj.RowCount + 2; i++) {
			// 체크된 내용을 메인으로전달
			if (sheetObj.CellValue(i, "ibcheck") == "1") {

				var main_row = formObject.spot_bid_sel_row.value;

				if(main_sheetObject != null && main_row != null){
					main_sheetObject.CellValue(main_row, 'spot_bid_win_vndr_seq')	= sheetObj.CellValue(i, 'vndr_seq');
					main_sheetObject.CellValue(main_row, 'spot_bid_win_vndr_nm')	= sheetObj.CellValue(i, 'vndr_nm');
					main_sheetObject.CellValue(main_row, 'spot_bid_win_curr_cd')	= sheetObj.CellValue(i, 'spot_bid_curr_cd');
					main_sheetObject.CellValue(main_row, 'spot_bid_win_amt')		= sheetObj.CellValue(i, 'spot_bid_amt');
					main_sheetObject.CellValue(main_row, 'spot_bid_win_usd_amt')	= sheetObj.CellValue(i, 'spot_bid_usd_amt');
				}
			}
		}		
		return true;
	}

     /**
		 * 조회결과에 오류가 발생했을 때 공통처리하는 함수 IBSheetConfig.js에서
		 * DataSheetObject.prototype.event_OnSearchEnd에서 정의
		 */
     function sheet_OnSearchEnd(sheetObj, errMsg) {
     	var formObj = document.form;
     	
     	if( errMsg != '' ) {
     		ComShowMessage(errMsg);
     	}else{
     		for(var i=1; i<=sheetObjects[0].RowCount+1; i++){
    			if (sheetObj.CellValue(i, 'vndr_seq') == formObj.spot_bid_win_vndr_seq.value) {
    				sheetObj.CellValue(i, 'ibcheck') = 1;
    			}
     		}
     	}
     }     