/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0013.js
*@FileTitle : CSR Monitoring Inquiry
*Open Issues :
*Change history : 2007.05 Kim Jung Jae 최초생성
*@LastModifyDate : 2009.09.02
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.02 전재홍
* 1.0 Creation
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
     * @class ESD_LEA_0013 : ESD_LEA_0013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0013() {
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

  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
//  	function InitTab() {
//  		try{
//  			with(document.all.tab1){
//  				InsertTab(0, "Dry Index" , 23 );
//  				InsertTab(1, "Tanker Index" , 23); 
//  				InsertTab(2, "Time Charter" , 23 );
//  				InsertTab(3, "Bunker Price" , 23 );
//  				InsertTab(4, "Ship Price" , 23); 
//  				InsertTab(5, "FFA Index" , 23 );
//  				TabBackColor(0)="146,174,230";
//  			}
//  		}catch(e){
//  			ComShowMessage(e);
//  		}
//  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
//  	function tab1_OnChange(nItem){
//  		ChangeTab(document.all.tab1,nItem);
//  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
//  	function ChangeTab(tabObj,nItem){
//  		tabObj.BackColor="#FFFFFF";
//  		tabObj.TabBackColor(nItem)="146,174,230";
//  	
//  		var objs = document.all.item("tabLayer");
//  		objs[beforetab].style.display = "none";
//  		objs[nItem].style.display = "Inline";
//  		
//  		//--------------- 요기가 중요 --------------------------//
//  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
//  		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
//  		objs[beforetab].style.zIndex = 0;
//  		objs[nItem].style.zIndex = 9;
//  		//------------------------------------------------------//
//  		beforetab= nItem;
//  	}

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
  		
  		notMatchSelected();
  	}

  	/**
  	* @param     : obj	=> 객체
  	* sample	: <input type ="text" name ="date" onblur="lea_com_convertYymmdd(this)">
  	* @return 	: 
  	* 설명		: 년월(YYYY-MM-DD)을 검사 하여 보여주기 
  	**/
  	function lea_convertYymmdd(obj){
  		obj.value = ComReplaceStr(obj.value, '-', '');
  		switch(obj.value.length){
  			case 0 :
  					return;
  					break;
  			case 6 :
  					if (parseInt(obj.value.substring(0,2),10)  > 80 )
  					{
  						obj.value = "19"+obj.value;
  					}
  					else
  					{
  						obj.value = "20"+obj.value;
  					}
  					break;
  			case 8 :
  					break;
  			default :
  					obj.focus();
  					return;
  					break;
  		}
  		
  		var realDate = ComIsDate(obj.value);
  		if (!realDate)
  		{
  			//ComShowMessage('잘못된 날짜입니다.');
  			ComShowMessage(ComGetMsg("LEA90001"));
  			obj.value="";
  			obj.focus();
  			return;
  		}
  		
  		str = obj.value;
  		str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6,8);
  		obj.value = str;
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
  			case 1:	  //IBSheet1 init
  				with (sheetObj) {
  					
  					//전체 너비 설정
  					SheetWidth = mainTable.clientWidth;
  					
  				// 높이 설정
					style.height = 400;
  		
  					//Host정보 설정[필수][HostIp, Port, PagePath]
  					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
  		
  					//전체Merge 종류 [선택, Default msNone]
  					MergeSheet = msHeaderOnly;
  		
  					//전체Edit 허용 여부 [선택, Default false]
  					Editable = true;
  		
  					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
  					InitRowInfo( 2, 1, 9, 1000); //ONEPAGEROW(조회XML을 통해 한번에 조회해오는 행개수)를 Default=100에서 1000으로 조정(대용량 데이터 조회)
  		
  					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
  					InitColumnInfo(34, 5, 0, true); //틀고정 CSR No.
  		
  					// 해더에서 처리할 수 있는 각종 기능을 설정한다
  					InitHeadMode(true, true, false, true, false, false)

  					var HeadTitle  = "Seq||Source|Inv.Office|CSR No.|Inv.No.|LEA I/F Date|G/L Date|R.Month|R.VVD|R.VVD|BKG No.|CNTR No.|CNTR TP/SZ|CNTR TP/SZ|A/G|A/G|A/G Seq|A/G Seq|Cost Code|Cost Code|1st Node|1st Node|2nd Node|2nd Node|3rd Node|3rd Node|4th Node|4th Node|Amount(USD)|Amount(USD)|Amount per CNTR|Amount per CNTR|Result" ;
  					var HeadTitle1 = "Seq||Source|Inv.Office|CSR No.|Inv.No.|LEA I/F Date|G/L Date|R.Month|Inv.|Est.|BKG No.|CNTR No.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Inv.|Est.|Count|Amt|Result" ;


  					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  					InitHeadRow(0, HeadTitle, true);
  					InitHeadRow(1, HeadTitle1, true);

  					//데이터속성	[ROW,	  COL,			DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  					InitDataProperty(0,	cnt++,		dtDataSeq,		35,		daRight, 	true);
  					InitDataProperty(0,	cnt++,	dtHiddenStatus,		0,		daCenter,	false,		"ibflg",					false,	"",	dfNone		,	0,	true,	true);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"inv_sys_id",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_ofc_cd",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,	   130,		daCenter,	true,		"csr_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		90,		daCenter,	true,		"inv_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		70,		daCenter,	true,		"if_dt",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		70,		daCenter,	true,		"gl_dt",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"rev_yrmon",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"inv_rvvd",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"estm_rvvd",				false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		90,		daCenter,	true,		"bkg_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		80,		daCenter,	true,		"cntr_no",					false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		35,		daCenter,	true,		"inv_cntr_tpsz_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		35,		daCenter,	true,		"estm_cntr_tpsz_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"inv_cost_act_grp_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"estm_cost_act_grp_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		30,		daCenter,	true,		"inv_cost_act_grp_seq",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		30,		daCenter,	true,		"estm_cost_act_grp_seq",	false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_coa_cost_src_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_coa_cost_src_cd",		false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n1st_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n1st_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n2nd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n2nd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n3rd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n3rd_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"inv_n4th_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		60,		daCenter,	true,		"estm_n4th_nod_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"inv_cost_amt",				false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"estm_cost_amt",			false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daRight,	true,		"aloc_cntr_qty",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		100,	daRight,	true,		"aloc_cntr_amt",			false,	"",	dfFloat	,	2,	false,	true,	400,	false,	true,	"",	false);
  					InitDataProperty(0,	cnt++,			dtData,		50,		daCenter,	true,		"act_mapg_rslt_cd",			false,	"",	dfNone		,	0,	false,	true,	400,	false,	true,	"",	false);

  					//style.height = 260 ;
  					
  					//ActionMenu = "Header Setting Save|Header Setting Reset|Header Setting Delete";
  					//IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObjects[0], false);
  					
  					
  				}
  				break;
  			case 2:      //IBSheet1 init
  			with (sheetObj) {
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
  				InitColumnInfo(6, 0, 0, true);

  				// 해더에서 처리할 수 있는 각종 기능을 설정한다
  				InitHeadMode(true, true, true, true, false,false)

  				if (document.form.dt_div.value == "GL") {
  					var HeadTitle  = "Invoice Office|G/L Date|G/L Date|Source|CSR No.|Result";
  				} else {
  					var HeadTitle  = "Invoice Office|LEA I/F Date|LEA I/F Date|Source|CSR No.|Result";
  				}

  				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
  				InitHeadRow(0, HeadTitle, true);

  				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"inv_ofc_cd"		,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"opt_st_dt"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"opt_end_dt"		,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"src_ctnt"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"csr_no"			,	false,	"",	dfNone,	0,	false,	false);
  				InitDataProperty(0,	cnt++,	dtData,	100,	daCenter,	true,	"act_mapg_rslt_cd"	,	false,	"",	dfNone,	0,	false,	false);

  				style.height = GetSheetHeight(13) ;
  				}
  				break;
  		}
  	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	
  	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
  	function processButtonClick(){
  		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[0];
  		 var sheetObject1 = sheetObjects[1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;
  			
  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			switch(srcName) {
  				case "btn_retrieve":
  					doActionIBSheet(sheetObject,formObject,IBSEARCH);
  						break;
  				case "btns_calendar1":
  					var cal = new ComCalendar();
  					cal.select(formObject.frm_opt_st_dt, 'yyyy-MM-dd');
  					break;
  				case "btns_calendar2":
  					var cal = new ComCalendar();
  					cal.select(formObject.frm_opt_end_dt,'yyyy-MM-dd');
  					break;
  				case "btng_downexcel":
//  					lea_form2sheet(formObject,sheetObject1);
//  					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true); //Option 조건
//  					sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
  					sheetObject. ExcelOption= "NOCOLOR";
        	    	sheetObject.SpeedDown2Excel(true);
        	    	sheetObject. ExcelOption= "";   
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
  	 * EnterKey Event 조회 프로세스 처리
  	 */
  	function lea_enterRetrieve(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		doActionIBSheet(sheetObject,formObject,IBSEARCH);
  	}
  	
  	/**
  	 * Page Loading Event 조회 프로세스 처리
  	 */
  	function lea_load_page(){
  		var sheetObject = sheetObjects[curTab-1];
  		var formObject = document.form;
  		
  		//popUpWindow 로 호출된 경우 자동 조회처리
  		if (formObject.dt_div.value == "GL") {
  			doActionIBSheet(sheetObject,formObject,IBSEARCH);
  		}
  	}
  	
  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
  			case IBSEARCH:	  //조회
  				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
  				
  				formObj.f_cmd.value = SEARCH;
  				//alert(FormQueryString(formObj)) //Parameter Value
  				//sheetObj.DoSearch4Post("ESD_LEA_0013GS.do", FormQueryString(formObj));
  				
  				sheetObj.DoSearch4Post("ESD_LEA_0013GS.do", leaFormQueryString(formObj));
  				
  				break;
  		}
  	}
  	
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		var formObj = document.form;
  		with(formObj){
  			/**
  			 * @TODO 개발자 분들께서 넣어 주셔야 합니다. 
  			 */
  			if(formObj.frm_inv_ofc_cd.value == '' && formObj.frm_rslt_cd.value == 'ALL'){
			    var sDate = formObj.frm_opt_st_dt.value;//범위 시작날짜
			    var eDate = formObj.frm_opt_end_dt.value;//범위 마지막날짜
			    
			    var oneMonthAfterDate = ComGetDateAdd(ComGetDateAdd(sDate, "M", +1), "D", -1);
				
				if(eDate > oneMonthAfterDate){
					ComShowMessage(ComGetMsg("LEA90028", "1")); 
					return false;
				}
			    
			}
  			 //Inv.Office Code Check
  			/* if (formObj.frm_inv_ofc_cd.value.trim() == '' ) {
  			 	ComShowMessage(ComGetMsg("TRS90091")); //'Please input the Office code.'
  			 	return false;
  			 }
  			 //Date Check
  			 if (parseInt(get_IntervalDay(formObj.frm_opt_st_dt.value, formObj.frm_opt_end_dt.value)) > 7)  {
  			 	ComShowMessage(ComGetMsg("LEA90022", "1")); //'Period is limited to 1 week.'
  			 	return false;
  			 }
  			 */
  			 
  		}
  		
  		return true;
  	}
  	
  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  	}
  	
  	/**
  	 * Excel Head Data
  	 * Form Data를Sheet로 Copy 프로세스 처리
  	 */
  	function lea_form2sheet(formObj,sheetObj){
  		sheetObj.RemoveAll();
  		var Row = sheetObj.DataInsert();
  		
  		sheetObj.CellValue2(Row , "inv_ofc_cd"      ) = formObj.frm_inv_ofc_cd.value;
  		sheetObj.CellValue2(Row , "opt_st_dt"        ) = formObj.frm_opt_st_dt.value;
  		sheetObj.CellValue2(Row , "opt_end_dt"       ) = formObj.frm_opt_end_dt.value;
  		sheetObj.CellValue2(Row , "src_ctnt"        ) = formObj.frm_src_ctnt.value;
  		sheetObj.CellValue2(Row , "csr_no"          ) = formObj.frm_csr_no.value;
  		sheetObj.CellValue2(Row , "act_mapg_rslt_cd") = formObj.frm_rslt_cd.value;
  	}

  	/**
  	 * CSR No.를 Double Click 시 해당 시스템의 CSR 조회 화면을 호출함(TRS, TES)
  	 */
  	function sheet1_OnDblClick(sheet1, row, col){
  		if(col==4 ){ //CSR No
  			var csr_no = sheet1.cellValue(row, col);
  			var inv_sys_id = sheet1.cellValue(row, 2); //TRS, TES
  		
  			if (inv_sys_id == "TRS") {
  				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:520px; help:no; status:no; resizable:yes;");
  			} else if (inv_sys_id == "TES"){
  				window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:910px; dialogHeight:475px; help:no; status:no; resizable:yes;");
  			}
  		}
  	}
  	
//  	function sheet1_OnSelectMenu(sheetObj, MenuString){
//  	
//  		 switch(MenuString){
//  			case('Header Setting Save'):
//  				IBS_SaveGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
//  			break;
//  	
//  			case('Header Setting Reset'):
//  				IBS_RestoreGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
//  			break;
//  	
//  			case('Header Setting Delete'):
//  				IBS_DelGridSetting(document.form.FORM_CRE_USR_ID.value, getPageURL(), sheetObj);
//  			break;
//  		 }
//  	}	
  	
  	function notMatchSelected(){
  		var formObj = document.form;
  		if(formObj.frm_rslt_cd.value != 'NM'){
  			formObj.frm_rslt_cd_not_match.disabled = true;
  		}else if(formObj.frm_rslt_cd.value == 'NM'){
  			formObj.frm_rslt_cd_not_match.disabled = false;
  		}
  		
  	}
  	
  	

	/* 개발자 작업  끝 */