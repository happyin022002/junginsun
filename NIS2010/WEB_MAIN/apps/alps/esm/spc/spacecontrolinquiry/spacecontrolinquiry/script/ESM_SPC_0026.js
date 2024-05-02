/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0026.js
*@FileTitle : Allocation History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.10.29 주선영
* 1.0 Creation
* 2010.07.02 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
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
     * @class ESM_SPC_0026 : ESM_SPC_0026 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0026() {
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
    
    var init_salesOffice = '';
    var init_subOffice = '';

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	// try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
   	            	doActionIBSheet(sheetObjects[beforetab],formObject,IBSEARCH);
    	            break;
    	            
				case "btn_new":
					if(checkModifiedSheet(sheetObjects)) {
						if(ComShowConfirm (getMsg("SPC90001")) != 1) {
							return;
						}
					}
	            	//공통함수사용: 화면을 초기화
					resetAll();
					sheetObject1.RemoveAll();
					document.getElementById("salesOffice").Code2 = init_salesOffice;
					document.getElementById("subOffice").Code2 = init_subOffice;

					break;
					
        	   // case "btn_save":
        	   // 	doActionIBSheet(sheetObjects[beforetab], formObject, IBSAVE);
        	   //     break;
        	   // case "btn_confirm":
        	   // 	confirmData(sheetObjects[beforetab], formObject);
        	   //     break;
        	    case "btn_downexcel":
   	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
        	        break;

			} // end switch
		//}catch(e) {
		//	if( e == "[object Error]") {
		//		ComShowCodeMessage("COM12111");
		//	} else {
		//		ComShowMessage(e);
		//	}
		//}
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
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        tab_retrives = new Array(sheetObjects.length);
        var tdisp = "block";
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
           	//tdisp = tabLayer[i].style.display;
           	//tabLayer[i].style.display = "block";
            initSheet(sheetObjects[i],i+1);
    		//tabLayer[i].style.display = tdisp;
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
    		initDataSelection(i);
        }
        
        
        var sheetResizeFull = true;
		document_onresize();
		

//    		for(k=0;k<tabObjects.length;k++){
//                initTab(tabObjects[k],k+1);
//            }
//    		beforetab = 1;

		var formObject = document.form;
    	var comObj = document.getElementById("salesOffice");
 
        	if(comObj.GetCount() <= 1){
        		
    	    	comObj.Index = 0;
        		var comObj1 = document.getElementById("subOffice");
    		if(comObj.Code != comObj1.Code){
    			comObj1.Enable = false;
    		}
    	}
//        	btnImgEnable("btng_addAccount2", false);
//    	    showDataSelectionItem("divDs2CFM", true);
		var value = "";
		var include = "";
		
		
		if(ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS"){
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
		initData_salesOffice(rtn[0].split("|"), rtn[1].split("|"));
		
////    	if(isDevMode){
////    	    	formObject.week.value = 50;
////    	    	formObject.duration.value = 1;
//	    	formObject.vvd.value = "HNDA0017E";//"SMTN0006W";
//	      	document.getElementById("salesOffice").Code = "DXBSC";
//	    	//document.getElementById("subOffice").Code = "";
//	    	document.all.id_chk_ocn.checked = true;
////    	    	document.all.ds2OTH.checked = false;
//	    	document.all.ds2HC.checked = false;
//	    	document.all.ds245.checked = false;
//	    	document.all.ds2RF.checked = false;
//	    	document.all.ds2WT.checked = false;
//	    	//showDataSelectionItem("divDs2CFM", true);
//	    	//showDataSelectionItem("divDs2INF", true);
//    	}
//		
		init_salesOffice = document.getElementById("salesOffice").Code;
		init_subOffice = document.getElementById("subOffice").Code;

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
	function initSheet1(sheetObj){
	       with (sheetObj) {
	            // 높이 설정
            	style.height = 100 ;
	            //전체 너비 설정
	            SheetWidth = mainTable[beforetab].clientWidth;
	       }
	}
	
    /**
     * TabSheet2에서 조회후 타이틀 변경
     */
    var sheet2 = new Object();
	function initSheet2(sheetObj){
		
		with (sheetObj) {
			// 높이 설정
			//style.height = getSheetHeight(20) ;
			style.height = getSheetHeight(21) ;
			
			//전체 너비 설정
			SheetWidth = mainTable[1].clientWidth;
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
			
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge + msHeaderOnly;
			
			//전체Edit 허용 여부 [선택, Default false]
			var comObj = document.getElementById("salesOffice");
			//RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
			//상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
			Editable = (comObj.GetCount() == 1) || isDevMode;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 9, 100);
			// 9개 컬럼 추가
            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(49, 0 , 0, true);	
		
			//해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			var HeadTitle1 = "Modefied Date(UTC)|Modified By|Office|Group|Local/IPI|Account|Account|POL|POD|Dest|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|lvl|";
			var HeadTitle2 = "Modefied Date(UTC)|Modified By|Office|Group|Local/IPI|CODE|NAME|POL|POD|Dest|TEU|D2|D4|HC|45'|53'|RF|RD|WT|Total TEU|TEU|D2|D4|HC|45'|53'|RF|RD|WT|Total TEU|D2|20'|D4|40'|HC|45'|53'|RF|RD|WT|Total TEU|TEU|HC|45'|53'|RF|WT|lvl|";
			//var HeadTitle1 = "Modefied Date(UTC)|Modified By|Office|Group|POL|POD|Alloc|Alloc|Alloc|Alloc|Alloc|Alloc|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|Fcast|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|BKG(TTL)|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|C.Fcast|lvl|";
			//var HeadTitle2 = "Modefied Date(UTC)|Modified By|Office|Group|POL|POD|TEU|HC|45'|53'|RF|WT|Total TEU|TEU|HC|45'|53'|RF|WT|Total TEU|20'|40'|HC|45'|53'|RF|WT|Total TEU|TEU|HC|45'|53'|RF|WT|lvl|";
	
			//sheet2.ColumnCount = HeadTitle1.split("|").length - 1;
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
			var cnt = 0;
			
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtData ,    120,   daCenterTop,  true,    "aloc_gdt",          	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    120,   daCenterTop,  true,    "user_nm",           	false,          "",       dfNone,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  60,    daCenterTop,  true,    "sls_ofc_cd",        	false,          "",       dfNone,       0,     true,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,  true,    "acct_grp",          	false,          "",       dfNone,       0,     true,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,  true,    "us_mod",          	false,          "",       dfNone,       0,     true,       false); //Local IPI
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,  true,    "acct",          		false,          "",       dfNone,       0,     true,       false); //Account Code
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,  true,    "acct_nm",          	false,          "",       dfNone,       0,     true,       false); //Account Name
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,  true,    "pol_yd_cd",         	false,          "",       dfNone,       0,     true,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,  true,    "pod_yd_cd",         	false,          "",       dfNone,       0,     true,       false);
			InitDataProperty(0, cnt++ , dtData ,    70,    daCenterTop,  true,    "dest",          		false,          "",       dfNone,       0,     true,       false); //dest
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,      true,    "aloc_lod_qty",      	false,          "",       dfNullInteger,       0,     false,       false);
			//컬럼추가 allocation +3
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_d2_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_d4_qty",  	   false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_40ft_hc_qty",  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_45ft_hc_qty",  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_53ft_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_rf_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "aloc_rd_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,      true,    "aloc_ttl_wgt",      false,          "",       dfNullInteger,       0,     false,       false);
			//fcast_ttl_teu_qty
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,      true,    "fcast_ttl_teu_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_ttl_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			//컬럼추가 forecast +3
		    InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_d2_qty",  	   false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_d4_qty",  	   false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_40ft_hc_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_45ft_hc_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_53ft_qty",    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_rf_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "fcast_rd_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,      true,    "fcast_ttl_wgt",     false,          "",       dfNullInteger,       0,     false,       false);
			
			//컬럼추가 booking +3
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,      true,    "usd_bkg_ttl_qty",     false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_d2_qty",      false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,      true,    "usd_bkg_20ft_qty",    false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_d4_qty",      false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,      true,    "usd_bkg_40ft_qty",    false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_40ft_hc_qty", false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_45ft_hc_qty", false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_53ft_qty",    false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_rf_qty",      false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "usd_bkg_rd_qty",      false,        "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,      true,    "usd_bkg_ttl_wgt",     false,        "",       dfNullInteger,       0,     false,       false);
			
			
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,      true,    "cfcast_ttl_teu_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "cfcast_ttl_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "cfcast_40ft_hc_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "cfcast_45ft_hc_qty", false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "cfcast_53ft_qty",    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,      true,    "cfcast_rf_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,      true,    "cfcast_ttl_wgt",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden,   40,    daCenter,     true,    "lvl",                false,          "",       dfNone,              0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,  true,    " ",                  false,          "",       dfNone,              0,     false,       false);

		
			HeadRowHeight  = 10;
			InitTreeInfo("lvl", "", RgbColor(0,0,255), false);
			
		}
	}
	
	function t1sheet2_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "pol_yd_cd":
    	case "pod_yd_cd":
    		var mark = sheetObj.CellValue(row, col);
    		var status = sheetObj.RowStatus(row);
    		if(mark == "+"){
   				sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";
//       				sheetObj.RowStatus(row) = status;
    		}
    		else if(mark == "-"){
   				sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";
//       				sheetObj.RowStatus(row) = status;
    		}
    		break;
    	}
    }
	
   	function toggleExpand(sheetObj, row, col){
		var mark = sheetObj.CellValue(row, col);
	
		if(sheetObj.RowExpanded(row)){
			sheetObj.RowExpanded(row) = false;
			ChangeValue2(sheetObj, row, col, "+");
		}
		else{
			sheetObj.RowExpanded(row) = true;
			ChangeValue2(sheetObj, row, col, "-");
		}
   	}


    function initDataSelection(sheetNo){
    	if(sheetNo == 1){
    		changeDataSelection(document.getElementsByName("chkDs2OFC")[0]);
            changeDataSelection(document.getElementsByName("chkDs2POL")[0]);
			changeDataSelection(document.getElementsByName("chkDs2POD")[0]);
//    		changeDataSelection(document.getElementsByName("chkDs2OTH")[0]);
			changeDataSelection(document.getElementsByName("chkDs2HC")[0]);
			changeDataSelection(document.getElementsByName("chkDs245")[0]);
			changeDataSelection(document.getElementsByName("chkDs253")[0]);
			changeDataSelection(document.getElementsByName("chkDs2RF")[0]);
			changeDataSelection(document.getElementsByName("chkDs2WT")[0]);
			changeDataSelection(document.getElementsByName("chkDs2MDL")[0]);
			//2014.08.06 컬럼 추가
			changeDataSelection(document.getElementsByName("chkDs2D2")[0]);
			changeDataSelection(document.getElementsByName("chkDs2D4")[0]);
			changeDataSelection(document.getElementsByName("chkDs2RD")[0]);
			//2014.08.12 추가
			changeDataSelection(document.getElementsByName("chkDs2LocalIpi")[0]);
			changeDataSelection(document.getElementsByName("chkDs2Acct")[0]);
			changeDataSelection(document.getElementsByName("chkDs2Dest")[0]);
    	}
    }
    

	function changeDataSelection(tobj, internal){
		if(internal == undefined || internal == null){
			internal == false;
		}
		
		var sheetObj = sheetObjects[beforetab];
		var obj = null;
		if(tobj == undefined || tobj == null){
			tobj = null;
			obj = event.srcElement;
		}
		else{
			obj = tobj;
		}
		var sts = obj.checked;
//    		  var chk_pol = document.all.chkDs2POL.checked 
//            var chk_pod = document.all.chkDs2POD.checked
		
		var acct_clss = (document.form.acct_clss.value)=="Y"?true:false ;
    
		switch(obj.name){
			
		case "chkDs2OFC":
	    case "chkDs2POL":
		case "chkDs2POD":
			controlTreeFnc(sheetObj);
			break;
//    		case "chkDs2OTH":
//    		     sheetObj.ColHidden("usd_bkg_20ft_qty") = !sts;
//    		     sheetObj.ColHidden("usd_bkg_40ft_qty") = !sts;
//    			break;
		case "chkDs2HC":
		    sheetObj.ColHidden("aloc_40ft_hc_qty") = !sts;
		    if(!document.form.chkDs245.checked && !document.form.chkDs253.checked){ 
		       sheetObj.ColHidden("fcast_ttl_qty") = !sts;  //Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		       sheetObj.ColHidden("cfcast_ttl_qty") = !sts; //Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    }
		    sheetObj.ColHidden("fcast_40ft_hc_qty") = !sts;
		    sheetObj.ColHidden("cfcast_40ft_hc_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_40ft_hc_qty") = !sts;
			break;
		case "chkDs245":
		    sheetObj.ColHidden("aloc_45ft_hc_qty") = !sts;
		    if(!document.form.chkDs2HC.checked && !document.form.chkDs253.checked){
		        sheetObj.ColHidden("fcast_ttl_qty") = !sts;//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		        sheetObj.ColHidden("cfcast_ttl_qty") = !sts;//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    }
		    sheetObj.ColHidden("fcast_45ft_hc_qty") = !sts;
		    sheetObj.ColHidden("cfcast_45ft_hc_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_45ft_hc_qty") = !sts;
			break;
		case "chkDs253":
		    sheetObj.ColHidden("aloc_53ft_qty") = !sts;
		    if(!document.form.chkDs2HC.checked && !document.form.chkDs245.checked){ 
		        sheetObj.ColHidden("fcast_ttl_qty") = !sts;//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		        sheetObj.ColHidden("cfcast_ttl_qty") = !sts;//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    }
		    sheetObj.ColHidden("fcast_53ft_qty") = !sts;
		    sheetObj.ColHidden("cfcast_53ft_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_53ft_qty") = !sts;
			break;
		case "chkDs2RF":
		    sheetObj.ColHidden("aloc_rf_qty") = !sts;
		    sheetObj.ColHidden("fcast_rf_qty") = !sts;
		    sheetObj.ColHidden("cfcast_rf_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_rf_qty") = !sts;
			break;
		case "chkDs2WT":
		    sheetObj.ColHidden("aloc_ttl_wgt") = !sts;
		    sheetObj.ColHidden("fcast_ttl_wgt") = !sts;
		    sheetObj.ColHidden("cfcast_ttl_wgt") = !sts;
		    sheetObj.ColHidden("usd_bkg_ttl_wgt") = !sts;
			break;	
			
		// 2014.08.07 컬럼추가	
		case "chkDs2D2":
		    sheetObj.ColHidden("aloc_d2_qty") = !sts;
		    sheetObj.ColHidden("fcast_d2_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_d2_qty") = !sts;
			break;	
			
		case "chkDs2D4":
	    	sheetObj.ColHidden("aloc_d4_qty") = !sts;
	    	sheetObj.ColHidden("fcast_d4_qty") = !sts;
	    	sheetObj.ColHidden("usd_bkg_d4_qty") = !sts;
	    	break;	
		
		case "chkDs2RD":
		    sheetObj.ColHidden("aloc_rd_qty") = !sts;
		    sheetObj.ColHidden("fcast_rd_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_rd_qty") = !sts;
			break;
			
		// 2014.08.12 추가
		case "chkDs2LocalIpi" :					
			document.form.chkDs2Acct.checked = sts;
			document.form.chkDs2POL.checked = sts;
			document.form.chkDs2POD.checked = sts;
			document.form.ds2Dest.checked = sts;
			
			sheetObj.ColHidden("us_mod") = !sts;
			sheetObj.ColHidden("acct") = !sts;
			sheetObj.ColHidden("acct_nm") = !sts;
						
			controlTreeFnc(sheetObj);
			sheetObj.ColHidden("dest") = !sts;
			break;
		
		case "chkDs2Acct" :
			document.form.chkDs2POL.checked = sts;
			document.form.chkDs2POD.checked = sts;
			document.form.ds2Dest.checked = sts;
			
			sheetObj.ColHidden("acct") = !sts;
			sheetObj.ColHidden("acct_nm") = !sts;
			
			controlTreeFnc(sheetObj);
			sheetObj.ColHidden("dest") = !sts;
			break;
			
		case "chkDs2Dest" :
			sheetObj.ColHidden("dest") = !sts;
			break;
		}
	}
	
	
	function controlTreeFnc(sheetObj){
		var formObj = document.form;
		var sts1 =  true ;// formObj.chkDs2OFC.checked ;
		var sts2 = formObj.chkDs2POL.checked;
		var sts3 = formObj.chkDs2POD.checked;
		var sts4 = formObj.chkDs2Dest.checked;
        var sts5 = formObj.chkDs2LocalIpi.checked;
        var sts6 = formObj.chkDs2Acct.checked;
		with(sheetObj){
			ShowTreeLevel(sts4?6:(sts3?5:(sts2?4:(sts6?3:(sts5?2:1)))));
			if(sts2){
				ChangeValueFnc(sheetObj, "lvl", "3", "pol_yd_cd", "-");
			}
			if(sts3){
				ChangeValueFnc(sheetObj, "lvl", "4", "pod_yd_cd", "-");
			}
			
			ShowRow(sheetObj, "lvl", 1);

			if(!sts5)HideRow(sheetObj, "lvl", 2);
			if(!sts6)HideRow(sheetObj, "lvl", 3);
			if(!sts1)HideRow(sheetObj, "lvl", 4);
			if(!sts2)HideRow(sheetObj, "lvl", 5);
			if(!sts4)HideRow(sheetObj, "lvl", 6);

			ColHidden("dest") = !sts4;
			ColHidden("pod_yd_cd") = !sts3;
			ColHidden("pol_yd_cd") = !sts2;
			ColHidden("acct") = !sts6;
			ColHidden("acct_nm") = !sts6;
			ColHidden("us_mod") = !sts5;
			
//			
		}
//		return true;
    }
	

    function HideRow(sheetObj, col, val){
    	with(sheetObj){
    		var frow = -1;
    	
    	while((frow = FindText(col, val, frow + 1)) >= 0){
    			RowHidden(frow) = true;
    		}
    	}
    }
    
    
    
    function ChangeValueFnc(sheetObj, col, val, sCol, sVal){
    	with(sheetObj){
    		var frow = -1;
    		
    		while((frow = FindText(col, val, frow + 1)) >= 0){
    			var status = sheetObj.RowStatus(frow);
    			CellValue2(frow, sCol) = sVal;
    			
    			//2013.08.13 CSY dest 도 pod 레벨로 맞춤
    			//CellValue2(frow, "dest") = CellValue(frow, "pod_yd_cd");
    		}
    	}
    }

    
	function changeDataSelectionTpSzAll(idx){
//    	changeDataSelection(document.getElementsByName("chkDs"+idx+"OTH")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"HC")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"45")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"53")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"RF")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"WT")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"D2")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"D4")[0]);
		changeDataSelection(document.getElementsByName("chkDs"+idx+"RD")[0]);
	}
	
	/**
	 * col 컬럼의 값이 val과 일치한 행의 sCol컬럼의 값을 sVal로 변경한다.
	 */
	function ChangeValues2(sheetObj, col, val, sCol, sVal){
		with(sheetObj){
			var frow = -1;
			
			while((frow = FindText(col, val, frow + 1)) >= 0){
				var status = sheetObj.RowStatus(frow);
				CellValue2(frow, sCol) = sVal;
				sheetObj.RowStatus(frow) = status;
			}
		}
	}
	function ChangeValue2(sheetObj, row, col, val){
		with(sheetObj){
			//var status = RowStatus(row);
		    CellValue2(row, col) = val;
			//RowStatus(row) = status;
		}
	}
	function ChangeValue3(sheetObj, row, col, val){
		with(sheetObj){
			//var status = RowStatus(row);
			CellValue(row, col) = val;
			//RowStatus(row) = status;
		}
	}
	
	//var searchSalesRep = new Array();
    //Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, quite) {
    	if(quite == undefined) quite = false;
        sheetObj.ShowDebugMsg = false;		
		
        switch(sAction) {
            case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)){
                    return false;
                }
              
                sheetObj.ReDraw=false;
                var param = SpcFormString(formObj,'vvd,ioc,salesOffice,subOffice,acct_clss');
         
                var rtn = sheetObj.DoSearch4Post("ESM_SPC_0026GS.do", "f_cmd="+(SEARCHLIST01 + beforetab)+"&"+ param );
                        	
                
                sheetObj.ReDraw=true;
                sheetObj.LoadSearchXml(rtn);
                controlTreeFnc(sheetObj);
                initDataSelection(1);
				break;
			
			case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
	function initData2(sheetObj){
		//ChangeValues2(sheetObj, "treeLevel", "2", "d_pol_yd_cd", "-");
		//ChangeValues2(sheetObj, "treeLevel", "3", "d_pod_yd_cd", "-");
	}

	var selectedCell_OldValue = 0;
    function t1sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
    }
	function t1sheet1_OnChange(sheetObj, row, col, value){
	}

	function salesOffice_OnChange(comObj, value, text ){
		if(value == "") return;
		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=5&include=1");
		initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));

	} 
	
	function initDataValue_salesOffice(){
	    var sheetObj = document.getElementById("salesOffice");
	    with(sheetObj){
	        Index2 = 0;
	    }
	}

	function initData_salesOffice(codes, names){
	    var sheetObj = document.getElementById("salesOffice");
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
	function initData_subOffice(codes, names){
		
	    var sheetObj = document.getElementById("subOffice");
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
	        if(codes.length > 1){
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
			Enable = !(Index > 1);
	    }
	}
    
	function initDataValue_subOffice(){
	    var sheetObj = document.getElementById("subOffice");
	    with(sheetObj){
	        Index2 = 0;
	    }
	}
	
	function Clearcombo(){
      
      var comObj1 = document.getElementById("salesOffice");
	  var comObj2 = document.getElementById("subOffice");
	  document.getElementById("salesOffice").Code = "";
	  document.getElementById("subOffice").Code = "";
	    	comObj1.enable = false;
	    	comObj2.enable = false;
	}
	function chk_combo(){
	  var comObj1 = document.getElementById("salesOffice");
	  var comObj2 = document.getElementById("subOffice");
	     comObj1.enable = true;
	     comObj2.enable = true;
	}
	    
	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        var vvd = formObj.vvd.value;
        if(vvd = "" || vvd.length < 9){
        	ComShowCodeMessage("COM12174", "VVD", "9");
            formObj.vvd.focus();
            return false;
        }
          	
        var sales_ofc = comObjects[0].Code;
        
        var chk_nycna = document.all.id_chk_nycna.checked
        var chk_hamur = document.all.id_chk_hamur.checked
           
        
        if(sales_ofc == ""  && ( chk_nycna == false && chk_hamur == false) ){
        	ComShowMessage(getMsg("SPC90114", "Sales Office"));
            document.form.vvd.focus();
            comObjects[0].focus();
            return false;                   
        }
        
        return true;
    }
    
    /**
     * 입력된 항차의 Account Group Control Option을 찾는다.
     */
    function vvdChanged(){
    	var formObj = document.form;
    	var vvd = formObj.vvd.value;
    	
    	var rtn = getCodeList("CheckAcctGroupOpt", "vsl_cd="     +vvd.substr(0, 4)
										          +"&skd_voy_no="+vvd.substr(4, 4)
										          +"&skd_dir_cd="+vvd.substr(8, 1));
    	
    	var acctFlg = rtn[0].split("|");
    	
    	formObj.acct_clss.value = acctFlg[0];
    	sheetObjects[beforetab].ColHidden("acct_grp") 			= acctFlg[0]=="Y"?false:true;
    	formObj.chkDs2MDL.checked = acctFlg[0]=="Y"?true:false;
    }


	/* 개발자 작업  끝 */
