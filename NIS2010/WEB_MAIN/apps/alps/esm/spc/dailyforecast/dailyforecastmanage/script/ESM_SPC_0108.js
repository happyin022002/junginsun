/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0108.js
*@FileTitle : Accumulated Guide&PFMC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.03.12 [선처리] SMP/Allocation control 보완 요청 
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
     * @class ESM_SPC_0108 : ESM_SPC_0108 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0108() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt     = 0;
    
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;
        var srcName = window.event.srcElement.getAttribute("name");
		
        switch(srcName) {

    	    case "btn_retrieve":
    	    	//loading시에는 open 조건에 맞춰 조회. 그 이후부터 validation check
    	    	if(!validateForm(sheetObject,formObject,IBSEARCH)){
                    return false;
                }
            	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;

    	    case "btn_close":
    	    	window.returnValue = "CLOSE";
    	    	self.close();
    	        break;

		} // end switch
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
   
        var sheetResizeFull = true;
		document_onresize();
		
		SpcSearchOptionYear("year1");
		SpcSearchOptionWeek("week1");
		SpcSearchOptionYear("year2");
		SpcSearchOptionWeek("week2");
		
		document.form.year1.value = "";
		document.form.week1.value = "";
		document.form.year2.value = document.form.year.value;
		document.form.week2.value = document.form.week.value;
		
		//Axon 이벤트 처리1. 이벤트catch
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);  
	    

		//  화면 로드시 자동조회하되록함.
		//-----------------------------------------------------
	    doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		//-----------------------------------------------------
	    
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
				initSheet1(sheetObj);
                break;
        }
    }
    
	/**
	 * TabSheet2에서 조회후 타이틀 변경
	 */
	function initSheet1(sheetObj){
		with (sheetObj) {
			// 높이 설정
			//style.height = 100 ;
			style.height = getSheetHeight(19) ;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;
			
			Editable = true;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 1, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(14, 0, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			var HeadTitle = "FM.YRWK|TO.YRWK|S.Office|ACCT Code|ACCT Seq|ACCT Name|SC NO|RFA#|Yield Group|Sub Trade|REV Lane|Accl Guide|Accl PFMC|%|";
			
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle, true);
			
			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHidden 	,    80,    daCenter,	true,    "fm_yrwk"       ,	false,         	"",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden 	,    80,    daCenter,	true,    "to_yrwk"       ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    60,    daCenter,   true,    "sls_rgn_ofc_cd",	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden	,    50,    daCenter,   true,    "cust_cnt_cd"   ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtHidden	,    50,    daCenter,   true,    "cust_seq"      ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    280,   daLeft  ,   true,    "cust_nm"       ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "sc_no"         ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    80,    daCenter,   true,    "rfa_no"        ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "cust_ctrl_cd"  ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "sub_trd_cd"    ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "rlane_cd"      ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "guide"         ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    70,    daCenter,   true,    "bkg_qty"       ,	false,          "",       dfNone,       0,     false,      false);
			InitDataProperty(0, cnt++ , dtData 		,    50,    daCenter,   true,    "perf"          ,	false,          "",       dfNone,       0,     false,      false);
			// 접기 기능 추가

			ImageList(0) = "img/nolines_plus.gif";
			ImageList(1) = "img/nolines_minus.gif";

			InitTreeInfo(10, "slevel", RgbColor(0,0,255), false);
			ShowTreeLevel(0, 1); //모두 접기
			RowExpanded(1) = true; //1행의 트리만 펼치기
			ClipPasteMode = 1;
			
			UnEditableColor = RgbColor(255, 255, 255);
			
			HeadRowHeight  = 10;
		}
	}
	
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
			
           case IBSEARCH:      //조회
        	   
//				if(!validateForm(sheetObj,formObj,sAction)){
//                    return false;
//                }
				
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.ReDraw=false;
				sheetObj.RemoveAll();
				sheetObjects[0].RemoveAll();
				
				var param = SpcFormString(formObj,"f_cmd,year1,week1,year2,week2,sdate,edate,trade,ofc_cd,rhq");
				var sXml = sheetObj.GetSearchXml("ESM_SPC_0108GS.do", param);
				
				if (sXml != ""){
					sheetObj.LoadSearchXml(sXml);
					var sdate = ComGetEtcData(sXml, "sdate");
					var edate = ComGetEtcData(sXml, "edate");
					formObj.sdate.value = sdate;
					formObj.edate.value = edate;
				}
				
				sheetObj.ReDraw=true;
				break;
                
           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
	 
	/**
	 * Sheet1의 조회 후
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		
		if(sheetObj.RowCount > 0) {
			// TPS 외 Trade의 경우에는 S/C No Hidden처리
			if(formObj.trade.value != "TPS")
				sheetObj.ColHidden("sc_no") = true;
			else
				sheetObj.ColHidden("sc_no") = false;
			
			// AES 외 Trade의 경우에는 RFA Hidden처리
			if(formObj.trade.value != "AES")
				sheetObj.ColHidden("rfa_no") = true;
			else
				sheetObj.ColHidden("rfa_no") = false;
			
			if(formObj.ofc_cd.value == "")
				sheetObj.ColHidden("sls_rgn_ofc_cd") = true;
			else
				sheetObj.ColHidden("sls_rgn_ofc_cd") = false;
				
			var fm_yrwk = sheetObj.CellValue(1, "fm_yrwk");
			var to_yrwk = sheetObj.CellValue(1, "to_yrwk");
			
			if(formObj.year1.value==""&&formObj.week1.value==""){
				formObj.year1.value = fm_yrwk.substr(0,4);
				formObj.week1.value = fm_yrwk.substr(4);
			}
			
			for(var i = 1; i < sheetObj.RowCount + 1; i++){
				if(sheetObj.CellValue(i, "cust_nm") == "TTL"){
					sheetObj.RowBackColor(i) = sheetObj.RgbColor(255,232,243);
				}else if(sheetObj.CellValue(i, "cust_nm") != "TTL" && sheetObj.CellValue(i, "sub_trd_cd") == ""){
					sheetObj.RangeBackColor(i, 9, i, 11) = sheetObj.RgbColor(255,255,206);
				}
			}
		}
		sheetObj.ShowTreeLevel(0, 1); //모두 접기
		//RowExpanded(1) = true; //1행의 트리만 펼치기
	}
	
	/**
	* sheet 내의 tree 접고 펴기 기능 추가
	*/
	function changechkExpand(){
			var checked = document.form.chkExpand.checked;

			if(checked == true){
				sheetObjects[0].ShowTreeLevel(-1);
			}else {
				sheetObjects[0].ShowTreeLevel(0, 1);; //모두 접기
			}
			
		}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			switch(sAction) {
				case IBSEARCH:      //조회

					var y1 = formObj.year1.value;
				    var w1 = formObj.week1.value;
				    var y2 = formObj.year2.value;
				    var w2 = formObj.week2.value;
				    
				    if(y1=="" || w1=="" || y2=="" || w2==""){
				    	ComShowCodeMessage("COM130201", "All Period");
				    	return false;
				    }
				    if(Number(y1+""+w1)>Number(y2+""+w2)){
				    	ComShowCodeMessage("COM12133", "To week", "From week", "greater");
				    	return false;
				    }
					if(Number(y1+""+w1)<Number(formObj.sdate.value)){
						ComShowCodeMessage("COM12133", "From week", "Season start week", "greater");
						formObj.week1.focus();
						return false;
					}
					if(Number(y2+""+w2)>Number(formObj.edate.value)){
						ComShowCodeMessage("COM12133", "To week", "Season end week", "lesser");
						formObj.week2.focus();
						return false;
					}
				break;
			}
		}
		return true;
	}
	/* 개발자 작업  끝 */