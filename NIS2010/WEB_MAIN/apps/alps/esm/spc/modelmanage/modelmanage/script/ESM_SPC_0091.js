/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0091.js
*@FileTitle : SMP History
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.03.25 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2015.02.06 박은주 [CHM-201533907] IAS노선 SMP/ RFA# Key 추가 
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
     * @class ESM_SPC_0091 : ESM_SPC_0091 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0091() {
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
    
 // 공통전역변수
    var sheetObjects = new Array();
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_office = '';
    var init_rhq = '';
    
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	//try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
        	    	for(var i = 0 ; i < tab_retrives.length ; i++){
				        tab_retrives[i] = false;
				    }
   	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
    	            break;
    	            
				case "btn_new":
					if(checkModifiedSheet(sheetObjects)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
					clearAll();

					document.getElementById("office").Code2 = init_office;
					document.getElementById("rhq").Code2 = init_rhq;
					
					break;
					
        	 
        	    case "btn_downexcel":
   	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
        	        break;
					   

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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
		comObjects[comboCnt++] = combo_obj;
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
     * tab1_OnChange 
     * 
     */
    function tab1_OnChange(tabObj , nItem)
    {
	    var formObj = document.form;
	   
        var objs = document.all.item("tabLayer");
    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";
    	//--------------- 여기가 중요--------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    	
    	if(beforetab==0){
    		formObj.rhq.Enable = true;
    		formObj.office.Enable = true;
    		formObj.subtrade.Enable = true;
    		formObj.lane.Enable = true;
    	}else if(beforetab==1){
    		formObj.rhq.Index2 = 0;
    		formObj.rhq.Enable = false;
    		formObj.office.Index2 = 0;
    		formObj.office.Enable = false;
    		formObj.subtrade.Index2 = 0;
    		formObj.subtrade.Enable = false;
    		formObj.lane.Index2 = 0;
    		formObj.lane.Enable = false;
    	}
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	SpcSearchOptionTrade("trade", true);
    	SpcSearchOptionSubTrade("subtrade", true, false);
    	SpcSearchOptionLane("lane", true, true, '', null, null, null, false, true);
    	SpcSearchOptionRhq("rhq", '', '', '', true);
    	
    	tab_retrives = new Array(sheetObjects.length);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        var sheetResizeFull = true;
		document_onresize();

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

		var formObject = document.form;
    	var comObj = document.getElementById("office");
    	
    	var rhq_cd = document.form.login_rhq_cd.value;
    	var rgn_cd = document.form.login_rgn_cd.value;
    	document.form.rhq.Code         = rhq_cd;
    	document.form.office.Code = rgn_cd;
    	
		var value = "";
		var include = "";
		if(ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS" || ofc_cd == "SELCTA" || ofc_cd == "SELCMA" ){
			value = "SELHO";
		} else if (ofc_cd == "SHARCS" || ofc_cd == "SHARCC" || ofc_cd == "SHARCO") {
			value = "SHARC";
		} else if (ofc_cd == "HAMRUS" || ofc_cd == "HAMRUC" || ofc_cd == "HAMRUO") {
			value = "HAMRU";
		} else if (ofc_cd == "NYCRAS" || ofc_cd == "NYCRAC" || ofc_cd == "NYCRAO") {
			value = "NYCRA";
		} else if (ofc_cd == "SINRSS" || ofc_cd == "SINRSO" || ofc_cd == "SINRSC") {
		    value = "SHARC";
		} else if(ofc_cd == "JKTSC" || ofc_cd == "JKTBA"){
			value = "JKTBA";
		} else if(ofc_cd == "MNLSC"|| ofc_cd == "MNLBA"){
			value = "MNLSC";
  		} else if(ofc_cd == "PHXSA"|| ofc_cd == "LGBSC"){
			value = "LGBSC";
		} else if(ofc_cd == "PKGSA"|| ofc_cd == "PKGSC"){
			value = "PKGSC";
		} else if(ofc_cd == "SELSA"|| ofc_cd == "SELSC"){
			value = "SELSC";
		} else if(ofc_cd == "SLCSC"|| ofc_cd == "SEASC"){
			value = "SEASC";
		} else if("HO|HQ|AQ|BB|BS|BA".indexOf(ofc_tp_cd) < 0){
			value = ofc_cd;
		}
		
		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=4");
		initData_office(rtn[0].split("|"), rtn[1].split("|"));
		init_office = document.getElementById("office").Code;
		init_rhq = document.getElementById("rhq").Code;
		
		document.form.trade.Code = "TPS";
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
                    InsertTab( cnt++ , "SMP" , -1 );
                    InsertTab( cnt++ , "Import" , -1 );
                }
             break;

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
				initSheet1(sheetObj);
			    break;
            case 2:      //sheet1 init
				initSheet2(sheetObj);
                break;
        }
    }
    
	/**
     * TabSheet1에서 조회후 타이틀 변경
     */
    var sheet1 = new Object();
	function initSheet1(sheetObj){
	     
		with (sheetObj) {
			// 높이 설정
			style.height = getSheetHeight(17) ;
			
			//전체 너비 설정
			SheetWidth = mainTable[1].clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			//var comObj = document.getElementById("office");
			//RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
			//상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
			Editable = false; //(comObj.GetCount() == 1) || isDevMode;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 3, 1, 9, 1000);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(28, 4 , 0, true);	
			
			var HeadTitle1 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|Add\n/Del|ACCT\nClass|ACCOUNT\n(Group)|ACCOUNT\n(Individual)|Yield\nGroup|S/C No|RFA#|Sub\nTrade|NEW|NEW|NEW|NEW|NEW|NEW|NEW|OLD|OLD|OLD|OLD|OLD|OLD|OLD|OLD";
			var HeadTitle2 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|Add\n/Del|ACCT\nClass|ACCOUNT\n(Group)|ACCOUNT\n(Individual)|Yield\nGroup|S/C No|RFA#|Sub\nTrade|RHQ|RHQ|L.OFC|L.OFC|Lane|Lane|Remark|RHQ|RHQ|RHQ|L.OFC|L.OFC|Lane|Lane|Remark";
			var HeadTitle3 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|Add\n/Del|ACCT\nClass|ACCOUNT\n(Group)|ACCOUNT\n(Individual)|Yield\nGroup|S/C No|RFA#|Sub\nTrade| RHQ|Guide| L.OFC|Guide| Lane|Guide|Remark| RHQ| RHQ|Guide| L.OFC|Guide| Lane|Guide|Remark";

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
	
			//HeadTitle3 = HeadTitle3 + HeadTail;
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtData ,    110,   daCenter,   true,    "modi_gdt",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,    80,    daCenter, true,    "modi_usr_id",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   	  true,    "modi_usr_nm",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    30,    daCenter,   true,    "ver_seq",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   true,    "cng_itm_nm",   			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daCenter,   true,    "mdl_add_flg",  			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "acct_clss",   			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,   daLeft,        true,    "cust_grp_nm",			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    120,   daLeft,        true,    "cust_nm",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daCenter,   true,    "cust_ctrl_cd", 			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenter,   true,    "sc_no",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenter,   true,    "rfa_no",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daCenter,   true,    "sub_trd_cd",   			false,          "",       dfNone,       	   0,     true,        false);
			
			// new smp
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenter,   true,    "sls_rhq_cd",   			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "cust_adj_qty",		    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,	  true,    "sls_rgn_ofc_cd",	    false,          "",       dfNone,              0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "sub_trd_adj_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,    true,    "rlane_cd",		     	false,          "",       dfNone,              0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,  daRight,   	  true,    "rlane_adj_qty", 	    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,   daLeft,   	  true,    "spc_ctrl_mdl_rmk", 	    false,          "",       dfNone,              0,     false,       false);
			
			// old smp
			InitDataProperty(0, cnt++ , dtData ,    1,    daCenter,   true,    "tmp",   			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,    true,    "old_sls_rhq",  			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "old_cust_adj_qty",		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter, 	  true,    "old_sls_rgn_ofc_cd",	false,          "",       dfNone,              0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "old_sub_trd_adj_qty",   false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,    true,    "old_rlane_cd",		    false,          "",       dfNone,              0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,  daRight,   	  true,    "old_rlane_adj_qty", 	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,   daLeft,   	  true,    "old_spc_ctrl_mdl_rmk", 	false,          "",       dfNone,              0,     false,       false);
			
			HeadRowHeight  = 10;
			
		}
	}
	
    /**
     * TabSheet2에서 조회후 타이틀 변경
     */
    var sheet2 = new Object();
	function initSheet2(sheetObj, isInit){
		if(isInit == undefined){
			isInit = false;
		}
		with (sheetObj) {
			// 높이 설정
			style.height = getSheetHeight(17) ;
			
			//전체 너비 설정
			SheetWidth = mainTable[1].clientWidth;
			
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			//var comObj = document.getElementById("office");
			//RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
			//상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
			Editable = false; //(comObj.GetCount() == 1) || isDevMode;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 3, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(21, 5 , 0, true);	
			
			var HeadTitle1 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|NEW|NEW|NEW|NEW|NEW|NEW|NEW|NEW|OLD|OLD|OLD|OLD|OLD|OLD|OLD|OLD";
			var HeadTitle2 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|ACCOUNT (Group)|ACCOUNT (Group)|ACCOUNT (Individual)|ACCOUNT (Individual)|S/C No|RFA#|MVC WK\n(TEU)|Yield\nGroup|ACCOUNT (Group)|ACCOUNT (Group)|ACCOUNT (Individual)|ACCOUNT (Individual)|S/C No|RFA#|MVC WK\n(TEU)|Yield\nGroup";
			var HeadTitle3 = "Modified\nDate(UTC)||Modified\nBy|Ver.|Changed\nItem|Code|Name|Code|Name|S/C No|RFA#|MVC WK\n(TEU)|Yield\nGroup|Code|Name|Code|Name|S/C No|RFA#|MVC WK\n(TEU)|Yield\nGroup";

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
	
			//HeadTitle3 = HeadTitle3 + HeadTail;
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			InitHeadRow(2, HeadTitle3, true);

			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtData ,    110,    daCenterTop,   true,    "modi_gdt",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,   80,    daCenterTop,   true,    "modi_usr_id",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    	daCenterTop,   true,    "modi_usr_nm",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    30,    	daCenterTop,   true,    "ver_seq",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,		daCenterTop,   true,    "cng_itm_nm",   			false,          "",       dfNone,       	   0,     false,       false);
			
			// new customer import
			InitDataProperty(0, cnt++ , dtData ,    75,   daCenter,    	true,    "cust_grp_id",		    false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,  daLeft,    	true,    "cust_grp_nm",	   		false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,   daCenter,    	true,    "cust_cd",		     	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,  daLeft,    	true,    "cust_nm",		     	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,   daCenter,    	true,    "sc_no", 	    		false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,   daCenter,    	true,    "rfa_no", 	    		false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,   	true,    "wk_mqc_qty", 	    	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,   	true,    "cust_ctrl_cd", 	    	false,          "",       dfNone,       0,     false,       false);
			
			// old customer import
			InitDataProperty(0, cnt++ , dtData ,    75,   daCenter,    	true,    "old_cust_grp_id",		false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,  daLeft,    	true,    "old_cust_grp_nm",	   	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,   daCenter,    	true,    "old_cust_cd",		    false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,  daLeft,    	true,    "old_cust_nm",		    false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,   daCenter,   	true,    "old_sc_no", 	    	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,   daCenter,   	true,    "old_rfa_no", 	    	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,   	true,    "old_wk_mqc_qty", 	    false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daCenter,   	true,    "old_cust_ctrl_cd", 	    false,          "",       dfNone,       0,     false,       false);
			
			HeadRowHeight  = 10;
		}
	}

    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, quite) {
    	if(quite == undefined) quite = false;
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
			
           case IBSEARCH:      //조회
                var sheetObj = sheetObjects[beforetab];
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
				
				var param = SpcFormString(formObj, 'ALL');
                
                searchParams = param;
                
			    if(beforetab==0){
			    	param = SEARCHLIST01 + "&" + param;
			    	sheetObj.DoSearch4Post("ESM_SPC_0091GS.do", "f_cmd="+param);

			    	tab_retrives[beforetab] = true;
                }else if(beforetab==1){
			    	param = SEARCHLIST02 + "&" +  param;
//			    	sheetObj.DoSearch4Post("ESM_SPC_0091GS.do", "f_cmd="+param);
			    	
			    	var rtnXml = sheetObj.GetSearchXml("ESM_SPC_0091GS.do", "f_cmd="+param);
			    	sheetObj.LoadSearchXml(rtnXml);
                	
                	tab_retrives[beforetab] = true;
                 }
			break;
           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
  	
	function trade_OnChange(comObj, value, text ){
		if(text == '|ALL'){	optionAllReset("trade",value);   return;} 
		//if(value == "") return;
		
		// TPS 인 경우에만 S/C No 활성화
		if(value == "TPS"){
			sheetObjects[0].ColHidden("sc_no")     = false;
			sheetObjects[1].ColHidden("sc_no")     = false;
			sheetObjects[1].ColHidden("old_sc_no") = false;
			sheetObjects[1].ColHidden("wk_mqc_qty") = false;
			sheetObjects[1].ColHidden("old_wk_mqc_qty") = false;
			
			sheetObjects[0].ColHidden("rfa_no")     = true;
			sheetObjects[1].ColHidden("rfa_no")     = true;
			sheetObjects[1].ColHidden("old_rfa_no") = true;
		} else if(value == "AES" || value == "IAS"){
			sheetObjects[0].ColHidden("rfa_no")     = false;
			sheetObjects[1].ColHidden("rfa_no")     = false;
			sheetObjects[1].ColHidden("old_rfa_no") = false;
			sheetObjects[1].ColHidden("wk_mqc_qty") = false;
			sheetObjects[1].ColHidden("old_wk_mqc_qty") = false;
			
			sheetObjects[0].ColHidden("sc_no")     = true;
			sheetObjects[1].ColHidden("sc_no")     = true;
			sheetObjects[1].ColHidden("old_sc_no") = true;
		}else{
			sheetObjects[0].ColHidden("sc_no")      = true;
			sheetObjects[1].ColHidden("sc_no")      = true;
			sheetObjects[1].ColHidden("old_sc_no")  = true;
			sheetObjects[0].ColHidden("rfa_no")     = true;
			sheetObjects[1].ColHidden("rfa_no")     = true;
			sheetObjects[1].ColHidden("old_rfa_no") = true;
			
			sheetObjects[1].ColHidden("wk_mqc_qty") = true;
			sheetObjects[1].ColHidden("old_wk_mqc_qty") = true;
		}
		
		SpcSearchOptionSubTrade("subtrade",true,false,"","",value);
		SpcSearchOptionLane("lane",true,true,'',value,'',true);
		
		var rtn = getCodeList("Season", "trade="+value);
		initData_season(rtn[0].split("|"), rtn[1].split("|"));
	} 

	/*
	 * Season Sheet Combo 변경시 해당 Season 의 Version 을 재조회 한다.
	 * @param     comObj
	 * @param     value
	 * @param     text
	 */
	function season_OnChange(comObj, value, text ){
		var rtn = getCodeXmlList("SeasonVersion", "trade="+document.form.trade.Code+"&season="+comObj.Code);
		initData_version(rtn);
		
		var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&season="+document.form.season.Code);
		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
		var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&grp=Y&season="+document.form.season.Code);
		initData_groupAcctList(rtn[0].split("|"), rtn[1].split("|"));
	} 

	/*
	 * Season Sheet Combo 를 초기화 한다.
	 * @param     codes
	 * @param     names
	 */
	function initData_season(codes, names){
		var comboObj = document.getElementById("season");
		
		with(comboObj){
			RemoveAll();
			MultiSelect = false;
			MaxSelect   = 1;
			DropHeight  = 190;
			SetTitle("Season|Pfmc Week");
			SetColWidth("70|120");
			SetColAlign("center|left");
			
			if(codes == undefined || codes == null || codes == ""){
				document.form.version.Code = "";
				return;
			}
			
			for(var i = 0 ; i < codes.length - 1 ; i++){
				InsertItem(-1, codes[i]+"|"+names[i], codes[i]);
			}
			document.form.season.Index = document.form.season.GetCount()-1;
		}
	}

	/*
	 * Version Sheet Combo 를 초기화 한다.
	 * @param     value
	 */
	function initData_version(value){
		var obj = document.getElementById("version");
		
		obj.SetTitle("Version|Status|Version Period");
		obj.SetColWidth("70|120|130");
		obj.SetColAlign("center|left|left");
		obj.DropHeight = 190;
		obj.ShowCol(0);
		
		ComXml2ComboItem(value, obj, "code", "code|text");
	}

	/*
	 * Version Sheet Combo 변경시 해당 Version 의 Status 를 화면에 보여준다.
	 * @param     comObj
	 * @param     value
	 * @param     text
	 */
	function version_OnChange(comObj, value, text ){

		var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&season="+document.form.season.Code+"&version="+document.form.version.Code);
		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
		var rtn = getCodeList("Account", "trade="+document.form.trade.Code+"&grp=Y&season="+document.form.season.Code+"&version="+document.form.version.Code);
		initData_groupAcctList(rtn[0].split("|"), rtn[1].split("|"));
	}
	
	function office_OnChange(comObj, value, text ){
		if(value == "") return;
	} 
	
	function initData_office(codes, names){
	    var sheetObj = document.getElementById("office");
	    var cnt = 0;
	    with(sheetObj){
	        RemoveAll();
	        SetTitle("Office|Name");
	        SetColWidth("60|250");
	        SetColAlign("left|left");
	        ShowCol = 0;
	        MultiSelect = false;
	        MaxSelect = 1;
	        DropHeight = 190;
	        if(codes == undefined || codes == null){
	        	return;
	        }
	        if(codes.length > 2){
	    		InsertItem(-1, "|ALL", "");
	        }
	    	var selectCode = "";
		    for(var i = 0 ; i < codes.length - 1 ; i++){
		    	var txt = names[i].split("~");
		    	if(txt[1] == "1"){
		    		selectCode = codes[i];
		    	}
		    	InsertItem(-1, codes[i]+"|"+txt[0], codes[i]);
		    }
		    if(selectCode != ""){
		    	Code = selectCode;
		    }
		    else{
		    	Index = 0;
		    }
			Enable = (GetCount() > 1);
	    }
	}	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction) {
			
           case IBSEARCH:      //조회
                var sheetObj = sheetObjects[beforetab];
				var trade   = formObj.trade.Code;
				var season  = formObj.season.Code;
				
				if(trade == ""){
			    	ComShowMessage(getMsg("SPC90114", "Trade"));
			    	formObj.trade.focus();
				    return false;
			    }else if(season == ""){
			    	ComShowMessage(getMsg("SPC90114", "Season"));
			    	formObj.season.focus();
				    return false;
			    }      

		    break;
		}
		return true;
    }

    function subtrade_OnChange(comObj,value,text ){
//        	if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code); return; } // 0207 SHKIM
    	SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    	if(value == "" ) return;
    	var formObj = document.form;
    	var arrSubtrade = text.split("|");
    	if(arrSubtrade.length > 1) {
    		formObj.trade.Code2 = arrSubtrade[0];
    		formObj.lane.Code2 = '';
    	} else {
    		formObj.trade.Code2 = comObj.GetText(value,0);  
    		formObj.lane.Code2 = '';
    	}        	
    }  

    function lane_OnChange(comObj,value,text ){
    	// 해당사항없음.if(text == '||ALL'){	optionAllReset("lane");  } // 0207 SHKIM
    	comObj.UseCode=true;
    	if(value == "" ) return;
    	var arrLane = text.split("|");
    	var formObj = document.form;
    	if(arrLane.length > 1) {
    		formObj.trade.Code2 = arrLane[0];
    		formObj.subtrade.Code2 = arrLane[1];
    	} else {
    		formObj.trade.Code2 = comObj.GetText(value,0);  
    		formObj.subtrade.Code2 = comObj.GetText(value,1);  
    	}
    }        
    
    function initData_acctList(codes, names) {
    	var sheetObj = document.getElementById("acct_cd");
    	var cnt = 0;
    	
    	with (sheetObj) {
    		RemoveAll();
    		SetTitle("Code|Name");
    		SetColWidth("80|250");
    		SetColAlign("left|left");
    		ShowCol = 0;
    		MultiSelect = true;
    		//MaxSelect = 1;
    		DropHeight = 190;
    		
    		if (codes == undefined || codes == null) {
    			return;
    		}
    		
    		if (codes.length > 1) {
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for ( var i = 0; i < codes.length - 1; i++) {
    			var txt = names[i].split("~");
    			if (txt[1] == "1") {
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
    		}
    		
    		if (selectCode != "") {
    			Code = selectCode;
    		} else {
    			//Index = 0;
    		}
    		Enable = (GetCount() > 0);
    	}
    }

    function initData_groupAcctList(codes, names) {
    	var sheetObj = document.getElementById("grp_acct");
    	var cnt = 0;
    	
    	with (sheetObj) {
    		RemoveAll();
    		SetTitle("Code|Name");
    		SetColWidth("80|250");
    		SetColAlign("left|left");
    		ShowCol = 0;
    		MultiSelect = true;
    		//MaxSelect = 1;
    		DropHeight = 190;
    		
    		if (codes == undefined || codes == null) {
    			return;
    		}
    		
    		if (codes.length > 1) {
    			InsertItem(-1, "|ALL", "");
    		}
    		
    		var selectCode = "";
    		for ( var i = 0; i < codes.length - 1; i++) {
    			var txt = names[i].split("~");
    			if (txt[1] == "1") {
    				selectCode = codes[i];
    			}
    			InsertItem(-1, codes[i] + "|" + txt[0], codes[i]);
    		}
    		
    		if (selectCode != "") {
    			Code = selectCode;
    		} else {
    			//Index = 0;
    		}
    		Enable = (GetCount() > 0);
    	}
    }
    
    function rhq_OnChange(comObj,value,text){
    	if(value == "")
    		ofc_cd = "SELHO";
    	else 
    		ofc_cd = value;
    	
    	var rtn = getCodeList("ChildOffice", "ofc_cd="+ofc_cd+"&level=4");
		initData_office(rtn[0].split("|"), rtn[1].split("|"));
		init_office = document.getElementById("office").Code;
    }
    
    function t1sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
	    	case "spc_ctrl_mdl_rmk":
	    		ComShowMemoPad(sheetObj, row, col, true);
	    		break;
	    	case "old_spc_ctrl_mdl_rmk":
	    		ComShowMemoPad(sheetObj, row, col, true);
	    		break;
    	}
    }
    
    function t1sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
    	var cfmColor = sheetObj.RgbColor(164,164,164);
    	var lineColor = sheetObj.RgbColor(255,232,243);
    	
    	var tmpMdDt = "";
    	for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
    		if(sheetObj.CellValue(i, "cng_itm_nm")=="Confirmed"){
    			var cnt=0;
    			for (j=0; j<=sheetObj.LastCol; j++) {
    	       		var colName = sheetObj.ColSaveName(j);
    	       		if(cnt>0){
    	       			sheetObj.CellBackColor(i, j) = cfmColor;
    	       		}
    	       		if(colName=="cng_itm_nm"){
    	       			cnt++;
    	       		}
    			}
    		}else{
    			if(sheetObj.CellValue(i, "modi_gdt") != tmpMdDt){
    				var cnt=0;
    				for (j=0; j<=sheetObj.LastCol; j++) {
        	       		var colName = sheetObj.ColSaveName(j);
        	       		if(cnt>0){
        	       			sheetObj.CellBackColor(i, j) = lineColor;
        	       		}
        	       		if(colName=="modi_gdt"){
        	       			cnt++;
        	       		}
    				}
    				tmpMdDt = sheetObj.CellValue(i, "modi_gdt")
    			}
    		}
    	}

    	sheetObj.ColBackColor(sheetObj.SaveNameCol("tmp"))  = sheetObj.RgbColor(230, 230, 230);
    	
    }
    
    function t1sheet1_OnLoadFinish(sheetObj) {
    	sheetObj.RangeBackColor(0,13, 0,19) = sheetObj.RgbColor(0, 176, 240);
    	sheetObj.RangeBackColor(0,20, 0,27) = sheetObj.RgbColor(205, 155, 255);
    } 
    
    function t1sheet2_OnLoadFinish(sheetObj) {
    	sheetObj.RangeBackColor(0,5, 0,12) = sheetObj.RgbColor(0, 176, 240);
    	sheetObj.RangeBackColor(0,13, 0,19) = sheetObj.RgbColor(205, 155, 255);
    } 
    
    function clearAll(){
    	var formObj = document.form;
    	sheetObjects[0].RemoveAll();
    	sheetObjects[1].RemoveAll();
    	comObjects[0].Code = "";
    	comObjects[1].Code = "";
    	comObjects[2].Code = "";
    	comObjects[3].Code = "";
    	comObjects[4].Code = "";
    	comObjects[5].Code = "";
    	comObjects[6].Code = "";
    	comObjects[7].Code = "";
    	comObjects[8].Code = "";
    	
    }
    
    function enter(){
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
    	if(keyValue != 13) return;
    	for(var i = 0 ; i < tab_retrives.length ; i++){
	        tab_retrives[i] = false;
	    }
       	doActionIBSheet(sheetObjects[beforetab],document.form,IBSEARCH);
    }
	/* 개발자 작업  끝 */
