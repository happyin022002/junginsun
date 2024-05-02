/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESD_EAS_0374.js
*@FileTitle : TES Auto Audit - Off-dock CY Invocie History
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-14 Jong-Ock Kim
* 1.0 최초 생성
*  
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @class ESD_EAS_0374 : 예)M&R Invoice Charge 조회 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESD_EAS_0374() {
	    this.processButtonClick     = processButtonClick;
	    this.setSheetObject         = setSheetObject;
	    this.setComboObject         = setComboObject;
	    this.setTabObject           = setTabObject;
	    this.loadPage               = loadPage;
	    this.initSheet              = initSheet;        
	    this.initControl            = initControl;
	    this.doActionIBSheet        = doActionIBSheet;
	    this.validateForm           = validateForm;
	    this.initCombo				= initCombo;
	}	
	
	/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var formObject = document.form;
	    var objs = document.all.item("tabLayer");
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_new":
				formObject.reset();
				initSet(true);
			    break;
			    
			case "btn_down_excel":
            	if( objs[0].style.display == "inline" ){
    				sheetObject.SpeedDown2Excel(true);
				}else if( objs[1].style.display == "inline" ){
					sheetObject2.SpeedDown2Excel(true);
				}else if( objs[2].style.display == "inline" ){
					sheetObject3.SpeedDown2Excel(true);
				}
				break;
				
            case "btn_close":
				window.close();
				break;

			case "btn_vndr":
				var dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; //com_ens_051_dispaly.value;
				var classId = "COM_ENS_0C1";
				var param = '?classId='+classId;
				var chkStr = dispaly.substring(0,3)
				// radio PopUp
				if (chkStr == "1,0") {
					ComOpenPopup('/hanjin/COM_ENS_0C1.do' + param, 700, 450, 'getVender', dispaly);
				} else {
					//ComShowCodeMessage('TES21906'); //ComShowMessage("팝업을 띄우기dispaly속성 정보가 부족합니다.");
					return;
				}
				break;
				
    		case "btns_from_inv_cfm_dt":
    			var cal = new ComCalendar();
    			cal.select(formObject.s_from_inv_cfm_dt, 'yyyy-MM-dd');
    			break;

    		case "btns_to_inv_cfm_dt":
    			var cal = new ComCalendar();
    			cal.select(formObject.s_to_inv_cfm_dt, 'yyyy-MM-dd');
    			break;				

			case "btn_inv_detail" :
       			if(sheetObject.SelectRow >= sheetObject.HeaderRows){
       				openInvDetail();
       			}else{
					ComShowCodeMessage("COM12177");
				}
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
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer");
		var formObj = document.form;

		objs[nItem].style.display = "inline";
		objs[beforetab].style.display = "none";
		//--------------- 요기가 중요 --------------------------//
		var pre_idx =  objs[nItem].style.zIndex;
		pre_idx--;
		objs[beforetab].style.zIndex = pre_idx ;
		//------------------------------------------------------//

		beforetab = nItem;
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
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}
	
	/**
	* Sheet 기본 설정 및 초기화
	* body 태그의 onLoad 이벤트핸들러 구현
	* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	*/
	function loadPage() {

	    for(k=0;k<tabObjects.length;k++){
	        initTab(tabObjects[k],k+1);
	    }
	    
		for(i=0;i<sheetObjects.length;i++){
			//-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		
 		//html컨트롤 이벤트초기화
 		initControl();
 		initSet(false);
 		
		var formObject = document.form;
		var sheetObject = sheetObjects[0];
 		doActionIBSheet(sheetObject,formObject,IBSEARCH);
	}
	 
	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
  	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
  	 * @param {ibsheet} sheetObj    IBSheet Object
  	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
  	 **/
  	function initControl() {
		axon_event.addListenerFormat( 'keypress','obj_keypress', document.form); //- 키보드 입력할때
  	}
  	
	function obj_keypress(){
	    obj = event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus = obj.dataformat;
	
	    switch(obj.dataformat) {
	        case "int":
	            if(obj.name=="vndr_seq") ComKeyOnlyNumber(obj, "-")
	            else ComKeyOnlyNumber(obj);
	        break;
			case "engup":		//영문대문자
				ComKeyOnlyAlphabet('upper');
			break;
	        
	    }
	}

  	function initSet(flg) {
  		var formObj = document.form;
  		vender_change();
  		ComSetObjValue(formObj.s_from_inv_cfm_dt, ComGetDateAdd(null, "d", -92, "-"));
  		ComSetObjValue(formObj.s_to_inv_cfm_dt, ComGetNowInfo());
  		
  		if(flg){
  			ComSetObjValue(formObj.s_nod_cd, ComGetObjValue(formObj.s_yd_cd).substr(5,2));
  			ComSetObjValue(formObj.s_calc_tp_cd, "");
  			ComSetObjValue(formObj.s_lgs_cost_subj_cd, "");
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
  	                InsertTab( cnt++, "Cost Calc.(TMNL)" , -1 );
  	                InsertTab( cnt++, "Cost Calc.(SRbyFD)" , -1 );
  	                InsertTab( cnt++, "Cost Calc.(SRbyFP)" , -1 );
  	            }
  	        break;
  	    }
  	}
  	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 * * N200903200050 EAS 보완요청 
	 */
	function initSheet(sheetObj) {
		var cnt = 0;
		var sheetNo = sheetObj.id;

		switch(sheetNo) {
			case "sheet1":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(16);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					var HeadTitle  = "|Yard|S/P No|Inv No|Issued|Period|Period|Cal.\nInd|Cal.\nType|Cost\nCode|Type/\nSize|Cal.\nVol|Reefer|Year\nMonth|Rev.\nVol|Uom|Rate|Curr|Ex\nRate|Inv Amt|Remark|3rd\nParty";
					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"yd_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"vndr_seq",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		110,daCenter,	true,	"inv_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"iss_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"fm_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"to_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"tml_calc_ind_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"calc_tp_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"lgs_cost_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"cntr_tpsz_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"calc_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"rc_flg",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"rev_yrmon",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"rvis_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"vol_tr_ut_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ctrt_rt",			false,          "",       dfFloatOrg,    2,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"curr_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daRight,	true,	"inv_xch_rt",		false,          "",       dfFloatOrg,    2,     false,true);
					InitDataProperty(0, cnt++, dtData,		80,	daRight,	true,	"inv_amt",			false,          "",       dfFloatOrg,    2,     false,true);
					InitDataProperty(0, cnt++, dtData,		100,daLeft,		true,	"calc_rmk",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50, daCenter,	true,	"n3pty_flg",		false,          "",       dfNone,    0,     false,       true);
					HeadRowHeight = 30;
				}
				break;
				
			case "sheet2":	  //IBSheet2 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(16);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					var HeadTitle  = "|Yard|S/P No|Inv No|Issued|Period|Period";
					HeadTitle  += "|S/D\nInd|Cal.\nType|Cost\nCode|Type/\nSize|I/O|DG|CNTR|Year/\nMonth|Stay\ndays|F/Days|Pay\ndays|Exclude\ndays|Over\ndays";
					HeadTitle  += "|Uom|Rate|Curr|Ex\nRate|Inv Amt|Remark";
					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"yd_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"vndr_seq",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		110,daCenter,	true,	"inv_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"iss_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"fm_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"to_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"sto_dys_ind_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"calc_tp_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"lgs_cost_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"cntr_tpsz_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"io_bnd_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"dcgo_ind_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		85,	daCenter,	true,	"cntr_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"rev_yrmon",		false,          "",       dfDateYm,  0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"stay_dys",			false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"free_dys",			false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"pay_dys",			false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"free_dy_xcld_dys",	false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ovr_dys",			false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"vol_tr_ut_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ctrt_rt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"curr_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"inv_xch_rt",		false,          "",       dfNullInteger,    0,     false,true);
					InitDataProperty(0, cnt++, dtData,		80,	daRight,	true,	"inv_amt",			false,          "",       dfFloatOrg,    	1,     false,true);
					InitDataProperty(0, cnt++, dtData,		100,daLeft,		true,	"calc_rmk",			false,          "",       dfNone,    0,     false,       true);
					HeadRowHeight = 30;
				}
				break;
				
			case "sheet3":	  //IBSheet1 init
				with (sheetObj) {
	                // 높이 설정
					style.height = GetSheetHeight(16);
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 10, 100);
					
					var HeadTitle  = "|Yard|S/P No|Inv No|Issued|Period|Period";
					HeadTitle  += "|S/D\nInd|Cal.\nType|Cost\nCode|PRD/\nCode|Date|Stacking/\nVol|Inv.\nVol|Diff|Pree\nPool|Over\nVol";
					HeadTitle  += "|Uom|Rate|Curr|Ex\nRate|Inv Amt|Remark";
					
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					//헤더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
	
					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
				   
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	10,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtData,		60,	daCenter,	true,	"yd_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		55,	daCenter,	true,	"vndr_seq",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		110,daCenter,	true,	"inv_no",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"iss_dt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"fm_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"to_prd_dt",		false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"sto_dys_ind_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"calc_tp_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daCenter,	true,	"lgs_cost_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"fp_calc_prd_cd",	false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		70,	daCenter,	true,	"wrk_dt",			false,          "",       dfDateYmd, 0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		60,	daRight,	true,	"stk_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"inv_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"diff_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"fp_teu_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ovr_vol_qty",		false,          "",       dfNullInteger,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"vol_tr_ut_cd",		false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		50,	daRight,	true,	"ctrt_rt",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daCenter,	true,	"curr_cd",			false,          "",       dfNone,    0,     false,       true);
					InitDataProperty(0, cnt++, dtData,		40,	daRight,	true,	"inv_xch_rt",		false,          "",       dfNullInteger,    0,     false,true);
					InitDataProperty(0, cnt++, dtData,		80,	daRight,	true,	"inv_amt",			false,          "",       dfFloatOrg,    	1,     false,true);
					InitDataProperty(0, cnt++, dtData,		100,daLeft,		true,	"calc_rmk",			false,          "",       dfNone,    0,     false,       true);
					HeadRowHeight = 30;
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
				formObj.f_cmd.value = SEARCHLIST01;
				var sXml = sheetObj.GetSearchXml("ESD_EAS_0374GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				for(var i = 0; i<arrXml.length; i++){ 
					sheetObjects[i].LoadSearchXml(arrXml[i]); 
				}
				break;
		}
	}
	
	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var formObject = document.form;
		switch(comboObj.id) {  
		
			case "s_nod_cd": 	//RHQ OFFICE
				with (comboObj) { 
					SetColWidth("40");
					DropHeight = 140;
					setComboData(comboObj);
				}
			break;
			
			case "s_calc_tp_cd": 
				with (comboObj) { 
					SetColWidth("80");
					DropHeight = 80;
					setComboData(comboObj);
				}
			break;
				
			case "s_lgs_cost_subj_cd":
				with (comboObj) { 
					SetColWidth("50");
					DropHeight = 100;
					setComboData(comboObj);
				}
			break;
			
			case "s_lgs_cost_dtl_cd":
				with(comboObj) {
					DropHeight = 150;
					MultiSelect = true;
					UseAutoComplete = true;
					MultiSeparator = ",";
					Style = 0;
				}
			break;
			
			case "s_tml_calc_ind_cd":
				with (comboObj) { 
				SetColWidth("50");
				DropHeight = 100;
				setComboData(comboObj);
				}
				break;
				
			case "s_sto_dys_ind_cd":
				with (comboObj) { 
				SetColWidth("50");
				DropHeight = 100;
				setComboData(comboObj);
				}
				break;			
		}
	}
	
	function setComboData(comboObj){ 
		var comboID = comboObj.id;
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		var cnt  = 0 ;
		switch(comboID){
			case "s_nod_cd":
			    var vParam = "f_cmd="+SEARCH01+"&loc_cd="+ComGetObjValue(formObj.s_loc_cd);		
				var sXml = sheetObj.GetSearchXml("EASCommonGS.do", vParam);
				ComXml2ComboItem(sXml, formObj.s_nod_cd, "nod_cd", "nod_cd");
	    		comboObj.Code = ComGetObjValue(formObj.s_yd_cd).substr(5,2);
				break;
				
			case "s_lane_cd":
			    var vParam = "f_cmd="+SEARCH02+"&vps_port_cd="+ComGetObjValue(formObj.s_loc_cd);		
				var sXml = sheetObj.GetSearchXml("EASCommonGS.do", vParam);
				ComXml2ComboItem(sXml, comboObj, "slan_cd", "slan_cd");
	    		comboObj.insertItem(0, "", "");
	    		comboObj.Index = 0;
				break;
				
			case "s_calc_tp_cd":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "Auto", "A");
				comboObj.InsertItem(cnt++, "Manual", "M");				
				comboObj.Index2 = 0;
				break;
				
			case "s_lgs_cost_subj_cd":
				formObj.f_cmd.value = SEARCH02;
				sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", EasFrmQryString(formObj));
				var catevalue = sheetObj.EtcData("extp_cate_list");
		  	    var tpvalue = sheetObj.EtcData("extp_det_list");
		  	    initComboCost(formObj.s_lgs_cost_subj_cd, catevalue, tpvalue);
  	        	initComboCost(formObj.s_lgs_cost_dtl_cd, "", tpvalue);
				break;

			case "s_tml_calc_ind_cd":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "Through-put", "TP");
				comboObj.InsertItem(cnt++, "Seperate", "SP");				
				comboObj.Index2 = 0;
				break;
				
			case "s_sto_dys_ind_cd":
				comboObj.InsertItem(cnt++, "", "");
				comboObj.InsertItem(cnt++, "Gate I/O", "IO");
				comboObj.InsertItem(cnt++, "Date", "DT");				
				comboObj.Index2 = 0;
				break;
				
		}
	}
	
	function initComboCost (comboObj, catevalue, tpvalue) {
  		var cnt  = 0 ;
  		var cateArray = catevalue.split("|");         
  		var tpArray = tpvalue.split("|");
  		var test1 = "FF";
  		var valueArray;
  		var time;
  	    switch(comboObj.id) {
  	    	case "s_lgs_cost_subj_cd":
  	        if(cateArray.length >1){
  	        	comboObj.RemoveAll();
  	        	with (comboObj) {
  	        		InsertItem(cnt++, 'ALL' + '|' +'', ' ');
  				    for(i=0 ;i<cateArray.length;i++){
  				    	valueArray = cateArray[i].split("--");                
  						if(valueArray[0] !=""){			                              
  							InsertItem(cnt++, valueArray[1] + '|' + valueArray[0], valueArray[0]); 
  						}			                            
  				    } 
  	        	}
  	        }			    	  
  	        break;

  	        case "s_lgs_cost_dtl_cd":
  	        comboObj.RemoveAll();
  	        with (comboObj) {
  				SetColAlign("left");
  				SetColWidth("40");

  				InsertItem(cnt++, 'ALL' + '|' +'', ' ');	            
  				for(i=0 ;i<tpArray.length;i++){
  					valueArray = tpArray[i].split("--");			               	
  					if(valueArray[0] !=""){		
  						InsertItem(i, tpArray[i].substring(8), tpArray[i].substring(0,6));
  					}
  				}
				
//  				comboObjects[1].Code = document.form.lgs_cost_subj_cd1.value ;
  			}
  	        break;
  	   	}
  				
//  		comboObjects[1].Code = document.form.lgs_cost_dtl_cd.value ;
  		
	}
	
  	function s_lgs_cost_subj_cd_OnChange(comObj, value, text)
  	{
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
//		formObj.f_cmd.value = SEARCH02;
//		sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", EasFrmQryString(formObj), "");
	    var vParam = "f_cmd="+SEARCH02+"&lgs_cost_subj_cd="+value;		
	    sheetObj.DoSearch4Post("ESD_TES_0028Combo.do", vParam);
		var catevalue = sheetObj.EtcData("extp_cate_list");
  	    var tpvalue = sheetObj.EtcData("extp_det_list");
      	initComboCost(comboObjects[3], "", tpvalue);
  	}

	function fnYearSet(obj){
	    obj.value = ComGetMaskedValue(obj.value,"ymd");
	}
	
	/**
	 * Vendor Help 화면에서 선택한 벤더를 작업화면으로 보내준다.
	 * @param(rowArray) 
	 */
	function getVender(rowArray) {
		var colArray = rowArray[0];
		document.all.s_vndr_seq.value = colArray[6];
		document.all.s_vndr_seq_name.value = colArray[4];
	}
	
	/**
	 * 글입력시 max length 체크해서 false 리턴함
	 * @param {object}	obj		input object
	 * @return 
	 */
	function chkInput(obj) {
		if (obj.maxLength < ComGetLenByByte(obj.value))
		{
			obj.value = '';
			obj.focus();
			return false;
		}
	}
	
	/**
	* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	*/
	function  vender_change(){
		var frm = document.form;
		if(frm.s_vndr_seq.value =="" ){
			frm.s_vndr_seq.value="";
			frm.s_vndr_seq_name.value="";
			return;
		}
		
	    var vParam = "f_cmd="+SEARCH05+"&s_vndr_seq="+ComGetObjValue(frm.s_vndr_seq);
		var sXml=sheetObjects[1].GetSearchXml("ESD_EAS_0201GS.do", vParam);
		var vndrNm = EasXmlString(sXml,"vndr_nm");
		
		if(vndrNm==0){
			ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
			frm.s_vndr_seq.value="";
			frm.s_vndr_seq_name.value="";
			return;
		}
		frm.s_vndr_seq_name.value = vndrNm;
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(ComIsNull(s_from_inv_cfm_dt)) {
				ComAlertFocus(s_from_inv_cfm_dt, ComGetMsg("COM130201", "Period"));
				return false;
			} else if(ComIsNull(s_to_inv_cfm_dt)) {
				ComAlertFocus(s_to_inv_cfm_dt, ComGetMsg("COM130201", "Period"));
				return false;
			}
			
			var days_between = ComGetDaysBetween(s_from_inv_cfm_dt , s_to_inv_cfm_dt) ;  // 조회 기간
			if ( days_between > 92 ) {
				ComShowCodeMessage("EAS90075");
				s_from_inv_cfm_dt.focus();
				return false;
			}
        }

        return true;
	}
	
    function sheet1_OnDblClick(sheetObj, Row, Col){
    	openInvDetail();
    }
	
	function openInvDetail(){
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var sUrl = "";
		sUrl = "/hanjin/ESD_TES_0018.do";
		var sParam = "?s_eas_flg=Y"
	+"&vndr_seq="+sheetObj.CellValue(sheetObj.SelectRow, "vndr_seq")
	+"&inv_no="+sheetObj.CellValue(sheetObj.SelectRow, "inv_no")
	;	
		sUrl += sParam;
		ComOpenPopup(sUrl, 1020, 720, "", "0,0", true, false, "", "", "", "Detail");
	}
