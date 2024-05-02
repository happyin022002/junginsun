/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1020.js
*@FileTitle : Quantitative Analysis PA Result Detail by S/P
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
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
     * @class ESD_SPE_1020 : ESD_SPE_1020 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1020() {
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

	//공통전역변수
    var frm = null;
    var searchFlag = "0";
    var rhqXml = null;
    var ofcXml = null;
    

	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	
	

	
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 				
	 				break;
	 			case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],frm,IBDOWNEXCEL);
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage() {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
         loadPageFromSetting(sheetObjects[0]);
         doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
	}
	
	function loadPageFromSetting(sheetObj){
		frm.s_ev_yr.value= frm.ev_yr.value;
		frm.s_eg_rhq_cd.value= frm.eg_rhq_cd.value;
		frm.s_eg_ofc_cd.value = frm.eg_ofc_cd.value;
		frm.s_ev_svc_cate_cd.value= frm.ev_svc_cate_cd.value;
		frm.s_sp_seq.value= frm.sp_seq.value;
	    frm.s_sp_nm.value = frm.sp_name.value;
	}	
	
	
	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
	function obj_keypress(){
		 switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;		
	        case "num":
	        	//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	        	ComKeyOnlyAlphabet('num');
	        	break;		
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;		
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break;    
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	        	//숫자만입력하기(정수,날짜,시간)
	        	ComKeyOnlyNumber(event.srcElement);            
		}	
	}	
 	
 	

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	 function initSheet(sheetObj,sheetNo) {

	 	var cnt = 0;

	 	switch(sheetNo) {
	 	case 1:      //sheet1 init
	    	with (sheetObj) {
				// 높이 설정
				style.height = GetSheetHeight(12);
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

			    //전체Edit 허용 여부 [선택, Default false]
			    Editable = false;
			    
			    var HeadTitle1 = "ibflag|Seq|KPICD|KPI|Result (Score)|Target|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)|Performance (Ratio of Achievement %)";
				var HeadTitle2 = "ibflag|Seq|KPICD|KPI|Result (Score)|Target|Avg|JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC";
				var headCount = ComCountHeadTitle(HeadTitle2);
				
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 24, 100);
				
				var headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 5, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false) ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				HeadRowHeight = 12;
				//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,        KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
				InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	true,	"seq");
				InitDataProperty(0, cnt++ , dtHidden,       100,  	daCenter,   true,	"sp_kpi_id",		false,   "",      dfNone,           0,          false,      false,   10);
				InitDataProperty(0, cnt++ , dtData,         180,  	daLeft,     true,	"sp_kpi_nm",		false,   "",      dfNone,           0,          false,      false,   10);
				InitDataProperty(0, cnt++ , dtData,         100,  	daRight,    true,	"rslt_scre_rto",    false,   "",      dfNone,           0,          false,      false,   10);
				InitDataProperty(0, cnt++ , dtData,         60,  	daRight,    true,	"kpi_tgt_rto",      false,   "",      dfNone,           0,          false,      false,   10);
				InitDataProperty(0, cnt++ , dtData,    		60,  	daRight,    true,	"tgt_avg",          false,   "",      dfNone,           0,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"jan_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"feb_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"mar_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"apr_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"may_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"jun_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"jul_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"aug_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"sep_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"oct_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"nov_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				InitDataProperty(0, cnt++ , dtData,    		45,  	daRight,    true,	"dec_rto",          false,   "",      dfFloat,          2,          true,       false,   5);
				
		
			}
			break;   

	    	case 2:      //sheet2 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = 0;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = msHeaderOnly;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag|";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
	    		
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    	    }
	    		break;				

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				sheetObjects[0].RemoveAll();
				
				frm.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(frm);
				var sXml = sheetObj.GetSearchXml("ESD_SPE_1020GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
				// 선택된 행의 표시를 색으로 하지않고 점선으로 한다.

				break;
		
			case IBDOWNEXCEL :	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.WaitImageVisible = false;
        switch(comboObj.id) {
	    case "s_eg_rhq_cd":  
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj); 
	    	comboObj.InsertItem(0, "", "");
	    	doActionIBCombo(frm.s_eg_ofc_cd)
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj); 
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
        sheetObj.WaitImageVisible = true;
    }
    

	/* 개발자 작업  끝 */