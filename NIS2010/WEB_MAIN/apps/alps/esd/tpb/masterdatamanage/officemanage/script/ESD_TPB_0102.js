/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0102.js
*@FileTitle : TPB Office Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.0
* 2009-07-06 Jong-Geon Byeon	1.0 ALPS Migration
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
     * @class ESD_TPB_0102 : ESD_TPB_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0102() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
    var currSheetObj = null;
    var currLayer = 5;
    var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    /**
	 * IBSheet Object를 배열로 등록
	 * ComSheetObject(id)에서 호출한다
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
		
		getTPBGenCombo('s_if_rhq_cd','searchHandleRHQList','F','','1', new Array("s_ofc_cd_for_rhq","s_office_level") );
		document.form.s_if_rhq_cd.onchange = if_rhq_cd_OnChange;
		if_rhq_cd_OnChange();
	}
	
	/**
	 * IBTab Object를 초기화 설정
	 * 탭 ID는 tab1,tab2,...
	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
	 */
	function InitTab() {
		try{
			with(document.all.tab1){
				InsertTab(0, "Dry Index" , 23 );
				InsertTab(1, "Tanker Index" , 23); 
				InsertTab(2, "Time Charter" , 23 );
				InsertTab(3, "Bunker Price" , 23 );
				InsertTab(4, "Ship Price" , 23); 
				InsertTab(5, "FFA Index" , 23 );
				TabBackColor(0)="146,174,230";
			}
		}catch(e){
			ComShowMessage(e);
		}
	}
	
	/**
	 * tab1의 onChange이벤트핸들러
	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
	 */
	function tab1_OnChange(nItem){
		ChangeTab(document.all.tab1,nItem);
	}
	
	/**
	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
	 */
	function ChangeTab(tabObj,nItem){
		tabObj.BackColor="#FFFFFF";
		tabObj.TabBackColor(nItem)="146,174,230";
	
		var objs = document.all.item("tabLayer");
		objs[beforetab].style.display = "none";
		objs[nItem].style.display = "Inline";
	
		//--------------- 요기가 중요 --------------------------//
		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
		objs[beforetab].style.zIndex = 0;
		objs[nItem].style.zIndex = 9;
		//------------------------------------------------------//
		beforetab= nItem;
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		sheetObj.UseUtf8 = true;
		switch(sheetNo) {
			case 1:	  //IBSheet1 init "H"
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Deleted flag|CRE_USR_ID|CRE_DT|Update User|Update Date";					

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData 	,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false	);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false	);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false	);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false	);
					
					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "Head Office", "H" );
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);

				}
				break;
				
			case 2:	  //IBSheet2 init "R"
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtCombo 	,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					

					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "ofc_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "Major RHQ Office", "R" );
					

				}
				break;
				
			case 3:	  //IBSheet3 init "S"
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData 	,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					

					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "All RHQ Office", "S" );
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);

				}
				break;
				
			case 4:	  //IBSheet4 init "C" : Control Office
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);
	
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";
	
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData 	,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					

					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "Control Office", "C" );
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);
	
				}
				break;
				
			case 5:	  //IBSheet4 init "T"
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtData		,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtData		,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					

					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "TPB Office", "T");
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);
					InitDataValid (0, "n3pty_ctrl_ofc_cd", vtEngUpOther);
					InitDataValid (0, "n3pty_ar_ofc_cd", vtEngUpOther);

				}
				break;
				
			case 6:	  //IBSheet5 init "G"
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,80		,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					
	
					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "General Office", "G" );
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);
					InitDataValid (0, "n3pty_ofc_cd", vtEngUpOther);

				}
				break;
				
			
				
			case 7:	  //IBSheet2 init "A" : A/R Office
				with (sheetObj) {
					var cnt = 0;
					style.height = 440;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
		
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
		
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
		
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 10);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(12, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false)
		
					var HeadTitle = "STS|Office Type|Office|RHQ Office|Control Office|TPB Office|A/R Office|Delete flag|CRE_USR_ID|CRE_DT|Update User|Update Date";

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
		
					//데이터속성		[ROW,COL	,DATATYPE	,WIDTH	,DATAALIGN	,COLMERGE	,SAVENAME			,KEYFIELD	,CALCULOGIC	,DATAFORMAT	,POINTCOUNT	,UPDATEEDIT	,INSERTEDIT	,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0	,cnt++	,dtStatus	,30		,daCenter	,true		,"ibflag" 																							);
					InitDataProperty(0	,cnt++	,dtCombo	,140	,daCenter	,true		,"n3pty_ofc_tp_cd"	,true		,""			,dfNone		,0			,false		,false		,1		);
					InitDataProperty(0	,cnt++	,dtData  	,100	,daCenter	,true		,"ofc_cd"			,true		,""			,dfNone		,0			,false		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,80		,daCenter	,true		,"rhq_cd"			,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ctrl_ofc_cd",false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"n3pty_ofc_cd"		,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtHidden	,140	,daCenter	,true		,"n3pty_ar_ofc_cd"	,false		,""			,dfNone		,0			,true		,true		,6		);
					InitDataProperty(0	,cnt++	,dtCombo	,80		,daCenter	,true		,"delt_flg"			,false		,""			,dfNone		,0			,true		,true		,50		);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtHidden	,100	,daCenter	,true		,"cre_dt"			,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_usr_id"		,false		,""			,dfNone		,0			,false		,false				);
					InitDataProperty(0	,cnt++	,dtData		,100	,daCenter	,true		,"upd_dt"			,false		,""			,dfNone		,0			,false		,false				);
					
					InitDataCombo (0, "rhq_cd", combo01Text, combo01Code);
					InitDataCombo (0, "ofc_cd", combo01Text, combo01Code);
					InitDataCombo (0, "delt_flg", "Y|N", "Y|N","N");
					InitDataCombo (0, "n3pty_ofc_tp_cd", combo02Text, combo02Code, "A/R Office", "A" );
					
					InitDataValid (0, "ofc_cd", vtEngUpOther);

				}
				break;
			
		}
	}
	
	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
	function processButtonClick(){
			
		var sheetObject = sheetObjects[currLayer-1 + curTab-1];
		var formObject = document.form;
		if(curTab == 2)
			formObject = document.form2;
			
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			switch(srcName) {
				case "btn_add":
					   doActionIBSheet(sheetObject,formObject,IBINSERT);
					break;
				case "btn_cancel":
					   doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					break;
				case "btn_remove":
					break;
				case "btn_preview":
					sheetObject.ExcelPrint = "PreView";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_downexcel":
					sheetObject.ExcelPrint = "";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_print":
					sheetObject.ExcelPrint = "PrintOnly";
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
			} // end switch
		}catch(e) {			
			if( e == "[object Error]") {
				ComShowMessage(getMsg('COM12111'));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	/* Sheet관련 프로세스 처리 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
	
		currSheetObj = sheetObj;
		
		sheetObj.ShowDebugMsg = false;
		switch(sAction) {
		   case IBSEARCH:	  //조회
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TPB_0102GS.do", tpbFrmQryStr(formObj));
				break;
			case IBSAVE:		//저장
		
				formObj.f_cmd.value = MULTI;
				sheetObj.DoSave("ESD_TPB_0102GS.do", tpbFrmQryStr(formObj));
				break;
			case IBINSERT:	  //입력
				var Row = sheetObj.DataInsert(-1);
				break;
			case IBCLEAR:	   //Clear
				sheetObj.RemoveAll();
				break;
			case IBDOWNEXCEL:  //엑셀내려받기
				sheetObj.SpeedDown2Excel(true);
				break;
		}
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		   if(!ComChkValid(formObj)) return false;
		}
		
		return true;
	}
	
	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSearchEnd(sheetObj,errMsg){
	}

	/**
	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	 */
	function sheet1_OnSaveEnd(sheetObj,errMsg){
		if(errMsg==null || errMsg == ''){
			ComShowMessage(getMsg('COM12149','Data','',''));
		}

	}

	function sheet1_OnPopupClick(sheetObj,Row,Col){
		var url = "ESD_TPB_0804.do?f_cmd="+SEARCH+"&rhq_cd="+sheetObj.CellValue(Row, "rhq_cd");
		var rtnValue = window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:300px;dialogHeight:140px");

		if(rtnValue != undefined && rtnValue != ""){
			sheetObj.CellValue(Row, sheetObj.ColSaveName(Col)) = rtnValue;
		}		
	}
	
  	/**
 	 * IBSheet 내 셀 값이 변경되었을 때 처리되는 함수.
 	 * 
 	 */	
 	function sheet1_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	 
 	function sheet2_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	
 	function sheet3_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	
 	function sheet4_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	
 	function sheet5_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	
 	function sheet6_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}
 	
 	function sheet7_OnChange(sheetObj, Row, Col, Value){
 		var colNm = sheetObj.ColSaveName(Col);
 		var temp;
  		var cnt = 0;

 		if( colNm == 'ofc_cd' && Value != '' )
 		{
	 		for(i=1;i<=sheetObj.RowCount;i++)
			{
				temp = sheetObj.CellValue(i,'ofc_cd');
				if( Value == temp ) cnt++;
			}
			
			if( cnt > 1 )	// 화면상 중복 체크
			{
				ComShowCodeMessage('TPB90073');
				sheetObj.CellValue2(Row,'ofc_cd') = '';
			} else	// DB 중복 체크
			{
				document.form.s_ofc_cd_reg.value = Value;
	 			getTPBGenCombo('CheckRegOffice','checkRegOffice','V','','',new Array('s_ofc_cd_reg','s_n3pty_ofc_tp_cd'),Value);
			}
 		}
 	}

	function if_rhq_cd_OnChange(){
		var f = document.form;
		getTPBGenCombo('s_if_ofc_cd','searchHandleOfficeList','F','','1', new Array("s_if_rhq_cd","s_office_level"));
	}
	
	/**
	 * 결과 그리드 템플릿을 TPB Office Type Code 콤보박스 onChange event에 따라 바꾸는 함수
	 * 
	 */
	function n3pty_ofc_tp_cd_OnChange(v) {

		//_____change templete____
		switch(v) {
			case "H": v = 1; break;
			case "R": v = 2; break;
			case "S": v = 3; break;
			case "C": v = 4; break;
			case "T": v = 5; break;
			case "G": v = 6; break;
			case "A": v = 7; break;
		}
		var i=1;
		
		for( i=1 ; i<8 ; i++){
			eval("document.all.layer"+i).style.display = "none";
		}
		eval("document.all.layer"+v).style.display = "";
		currLayer = v;
		//_____change templete____
				

		//_____init Old Templete____
		if( currSheetObj != null ){
			if( currSheetObj.rowCount > 0 ){
				currSheetObj.Reset();
				for(i=0;i<sheetObjects.length;i++){
					ComConfigSheet(sheetObjects[i]);
					initSheet(sheetObjects[i],i+1);
					ComEndConfigSheet(sheetObjects[i]);
				}
			}
		}//_____init Old Templete____
		
		ComClearCombo(document.form.s_if_ofc_cd);
		if ( v==5 ){
		    document.form.s_if_rhq_cd.disabled = false;
		    document.form.s_if_ofc_cd.disabled = false;
		    if_rhq_cd_OnChange();
		} else {
		    document.form.s_if_rhq_cd.value = "";
		    document.form.s_if_ofc_cd.value = "";
		    document.form.s_if_rhq_cd.disabled = true;
		    document.form.s_if_ofc_cd.disabled = true;
		} 
	}
	/* 개발자 작업  끝 */