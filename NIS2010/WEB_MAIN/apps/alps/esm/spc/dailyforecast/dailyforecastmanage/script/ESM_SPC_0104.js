/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0104.js
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :4
* 2008-09-10 임옥영 CSR:N200809090009
* 각 지역그룹팀에 대한 권한부여 
* 2008-10-10 임옥영 CSR:N200810070001
*   -SINRS에 SELCDO와 동일한 권한 부여
* 2008-12-18 임옥영 CSR:N200812080003 Total TEU 컬럼 추가(TEU+ HC*2 + 45FT*2)
* 2010-07-08 Lee Sang-Yong : [프로젝트] Ticket ID : CHM-201004171 53ft 추가
*@LastModifyDate : 2009.08.27
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.27 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2011.10.28 김종준 [선반영] if(ofc_cd == "SELCDO" || ofc_cd == "SINRS") {   ofc_cd == "SELCTM" 추가 
* 2011.11.10 김종준 [CHM-201114445-01] f"cast history 화면 RGN Office 창 활성화
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.06.13 진마리아 SELCDO 팀코드 변경 (SELCTY)
* 2013.07.16 진마리아 MNLBA->MNLSC 하드코딩 변경
* 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청	
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
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
     * @class ESM_SPC_0104 : ESM_SPC_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0104() {
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
    var beforetab = 0;
    //sheetResizeFull = true;
    //type check
    var type_check;
    //retrive check
    var check_retrive = false;
    var tab_retrives = null;
    var searchParams = "";
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = ''; 
    var init_week = '';
    var init_duration = '';   
    var init_salesOffice = '';
    var init_subOffice = '';
    var init_salesRep = '';
    var init_chkDs2Account = false;
    
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
	            	//공통함수사용: 화면을 초기화
					resetAll();

					formObject.year.value = init_year;
		    		formObject.week.value = init_week;
		    		formObject.duration.value = init_duration;
					document.getElementById("salesOffice").Code2 = init_salesOffice;
					document.getElementById("subOffice").Code2 = init_subOffice;
					document.getElementById("salesRep").Code2 = init_salesRep;
					document.getElementById("chkDs2Account").checked = init_chkDs2Account;
					
					subOffice_OnChange(document.getElementById("subOffice"), init_subOffice, init_subOffice );
		    		SpcSearchOptionWeek("week",false,document.form.year.value);         
		    		
					SpcSearchOptionTrade("trade", true);
					SpcSearchOptionSubTrade("subTrade", true, false);
					SpcSearchOptionLane("lane", true, true); // 0207 SHKIM   
					break;
					
        	 
        	    case "btn_downexcel":
   	            	doActionIBSheet(sheetObjects[beforetab], formObject, IBDOWNEXCEL);
        	        break;
        	     
        	     	case "btn_popup_customer": 
					var cust_cd  = formObject.customer.value;
        	        spcPopup("Customer", "cust_cd="+cust_cd, 770, 470, "callbackPopupCustomer", "1,0,1,1,1,1,1,1");
					break;
				
				    case "btn_popup_customerGrp": 
					var customerGrp  = formObject.customerGrp.value;
        	        spcPopup("CustomerGroup", "cust_grp_id="+customerGrp, 770, 470, "callbackPopupCustomerGrp", "1,0,1,1,1,1,1,1");
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
         
        var formObject = document.form;
        var comObj = document.getElementById("SalesRep");
		var comObj1 = document.getElementById("trade");
		var comObj2 = document.getElementById("subTrade");
		var comObj3 = document.getElementById("lane");
	 
			    
        if(beforetab==0){
      
		    comObj.enable = false;
		    comObj1.enable = true;
		    comObj2.enable = true;
		    comObj3.enable = true;
		    formObj.year.disabled = false;
        	formObj.week.disabled = false;
        	formObj.duration.disabled = false;
        	//formObj.customer.disabled = true;
        	formObj.bound.disabled = false;
        	accountpopup.style.display = "none";
        	salesreppopup.style.display = "none";
               	
          
        }else if(beforetab==1){
        	formObj.year.disabled = true;
        	formObj.week.disabled = true;
        	comObj.enable = true;
		    comObj1.enable = false;
		    comObj2.enable = false;
		    comObj3.enable = false;
		    formObj.duration.disabled = true;
        	//formObj.customer.disabled = false;
		    formObj.bound.disabled = true;
		    accountpopup.style.display = "block";
		    salesreppopup.style.display = "block";
		     
        }
		init_year = formObject.year.value;	//년 초기화용
		init_week = formObject.week.value;	//주차 초기화용
		init_duration = formObject.duration.value;	//duration 초기화용
		if(!check_retrive) return;
    	
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	
    	//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
    	document.getElementById("trade").Enable = false;
    	document.getElementById("subTrade").Enable = false;
    	
    	SpcSearchOptionYear("year");
    	SpcSearchOptionWeek("week");
    	SpcSearchOptionDuration("duration", 5, 4);
    	SpcSearchOptionTrade("trade", true);
    	SpcSearchOptionSubTrade("subTrade", true, false);
    	SpcSearchOptionLane("lane", true, true);
    	SpcSearchOptionBound("bound",false,true,false,true);
    	
    	tab_retrives = new Array(sheetObjects.length);
        var tdisp = "block";
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
           	//tdisp = tabLayer[i].style.display;
           	//tabLayer[i].style.display = "block";
            initSheet(sheetObjects[i],i+1);
			//tabLayer[i].style.display = tdisp;
            ComEndConfigSheet(sheetObjects[i]);
			initDataSelection(i);
        }
        
        var sheetResizeFull = true;
		document_onresize();

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		//beforetab = 1;

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
    	
    	var userRoleYn = doActionIBSheet(sheetObjects[beforetab],formObject,SEARCHLIST03);	//-	Login User가 SPC01 Role을 가진 경우, SELCDO로 로그인한 것과 동일하게 전체 RGN Office가 리스트에 보여지면서        	해당 항목이 활성화 될 수 있도록 로직 보완 

		var value = "";
		var include = "";
		if(ofc_cd == "SELCTY" || ofc_cd == "SELCDO" || ofc_cd == "SINRS" || ofc_cd == "SELCTA" || ofc_cd == "SELCMA" || userRoleYn == 'Y' ){ 	//ofc_cd == "SELCTM" 추가 by kjj //CTA로 변경.2013-04-09
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
		
//    	document.getElementById("trade").Code = "TPS";
//    	document.getElementById("subTrade").Code = "PN";
//    	document.getElementById("lane").Code = "PNHTP";
//    	document.getElementById("salesOffice").Code = "SELSC";
//    	
//    	formObject.vvd.value = "HNGV0105E";//"HJTN0006W";
		
		
		/* test using s
    	if(isDevMode){
	    	formObject.week.value = "08";
	    	formObject.duration.value = 1;
	    	formObject.vvd.value = "HNMI0027E";//"HJTN0006W";
	    	document.getElementById("trade").Code = "TPS";
	    	document.getElementById("subTrade").Code = "PS";
	    	document.getElementById("lane").Code = "PSXTP";
	    	document.getElementById("salesOffice").Code = "SELSC";
	    	//document.getElementById("subOffice").Code = "";
	    	//document.getElementById("salesRep").Code = "KR017";
	    	    document.all.id_chk_ocn.checked = true;
         	    document.all.ds1OTH.checked = false;
	    	    document.all.ds1HC.checked = false;
	    	    document.all.ds145.checked = false;
	    	    document.all.ds1RF.checked = false;
	    	    document.all.ds1WT.checked = false;
	    	    document.all.ds2OTH.checked = false;
	    	    document.all.ds2HC.checked = false;
	    	    document.all.ds245.checked = false;
	    	    document.all.ds2RF.checked = false;
	    	    document.all.ds2WT.checked = false;
	    	 	
   	
	    
    	}
    	test using e */
		//formObject.year.focus();
		
		//
		init_salesOffice = document.getElementById("salesOffice").Code;
		init_subOffice = document.getElementById("subOffice").Code;
		init_salesRep = document.getElementById("salesRep").Code;
		init_chkDs2Account = document.getElementById("chkDs2Account").checked;
		
		//[CHM-201533936] Split13-사용자 표준환경 관련 combo를 diabled 하여 로딩후 다시 enable 
		document.getElementById("trade").Enable = true;
		document.getElementById("subTrade").Enable = true;
		
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
                    InsertTab( cnt++ , "By Office" , -1 );
                    InsertTab( cnt++ , "By Account" , -1 );
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
            case 3:      //sheet1 init
				initSheet3(sheetObj);
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
			var comObj = document.getElementById("salesOffice");
			//RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
			//상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
			Editable = (comObj.GetCount() == 1) || isDevMode;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 9, 1000);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(53, 0 , 0, true);	//42
			
			var HeadTitle1 = "Trade|Sub\nTrade|Lane|BD|O/I/T|Office|Week|VVD|Date|Yield\nGroup|Local/IPI|POL|POD|DEST|";
			var HeadTitle2 = "Trade|Sub\nTrade|Lane|BD|O/I/T|Office|Week|VVD|Date|Yield\nGroup|Local/IPI|POL|POD|DEST|";			
			sheet1.masterColumnCount = HeadTitle1.split("|").length - 1;
			sheet1.forecastColumnCount = 10;//7
			sheet1.contractforecastColumnCount = 7;
			sheet1.allocColumnCount =9;//6
			sheet1.bookingColumnCount = 11;//8
			
			sheet1.itemColumnCount = sheet2.forecastColumnCount +  sheet2.contractforecastColumnCount +  sheet2.bookingColumnCount ;
			sheet1.columnCount = sheet2.masterColumnCount + sheet2.itemColumnCount ;
//    			sheet2.conformColorDif = sheet2.bookingColumnCount + sheet2.forecastColumnCount;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(sheet2.columnCount, sheet2.masterColumnCount, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			HeadTitle2 =HeadTitle2+"Total TEU|TEU|D2|D4|HC|45|53'|RF|RD|WT|Total TEU|TEU|HC|45|53'|RF|WT|TEU|D2|D4|HC|45|53'|RF|RD|WT|Total TEU|TEU|FEU|D2|D4|HC|45|53'|RF|RD|WT|";
			for(var j = 0 ; j < sheet1.forecastColumnCount ; j++){
				HeadTitle1 = HeadTitle1 + "L.FCST|";
				
			}
			for(var j = 0 ; j < sheet1.contractforecastColumnCount ; j++){
				HeadTitle1 = HeadTitle1 + "C.FCST|";
				
			}
			for(var j = 0 ; j < sheet1.allocColumnCount ; j++){
				HeadTitle1 = HeadTitle1 + "Alloc|";
				
			}
			for(var k = 0 ; k < sheet1.bookingColumnCount ; k++){
				 HeadTitle1 = HeadTitle1 + "BKG|";
			}

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
	
			//HeadTitle3 = HeadTitle3 + HeadTail;
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "trd_cd",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "sub_trd_cd",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "rlane_cd",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daCenterTop,   true,    "skd_dir_cd",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daCenterTop,   true,    "ioc_cd",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "sls_ofc_cd",     		false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "bse_wk",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "vvd",     				false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,   daCenterTop,   true,    "bse_dt",     			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "cust_ctrl_cd", 			false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "usa_bkg_mod_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "pol_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "pod_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "dest_loc_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			//fcast_ttl_teu_qty
			InitDataProperty(0, cnt++ , dtData ,    60,   daRight,   	  true,    "fcast_ttl_teu_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,   daRight,   	  true,    "fcast_lod_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_20ft_dry_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_40ft_dry_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_40ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_45ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_53ft_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_rf_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_rd_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daRight,   	  true,    "fcast_ttl_wgt",     	false,          "",       dfNullInteger,       0,     false,       false);

			// Contract Forecast
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "cfcast_ttl_teu_qty",    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "cfcast_lod_qty",        false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_40ft_hc_qty",    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_45ft_hc_qty",    false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_53ft_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_rf_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,   	  true,    "cfcast_ttl_wgt",     	false,          "",       dfNullInteger,       0,     false,       false);
			
			// Allocation
			InitDataProperty(0, cnt++ , dtData ,    60,   daRight,        true,    "aloc_lod_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_20ft_dry_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_40ft_dry_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_40ft_hc_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_45ft_hc_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_53ft_qty",     	false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_rf_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,        true,    "aloc_rd_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,   daRight,        true,    "aloc_ttl_wgt",     		false,          "",       dfNullInteger,       0,     false,       false);

			// Booking
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "usd_bkg_ttl_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_20ft_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_40ft_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_20ft_dry_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_40ft_dry_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_40ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_45ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_53ft_qty",        false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_rf_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_rd_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,   	  true,    "usd_bkg_ttl_wgt",     	  false,          "",       dfNullInteger,       0,     false,       false);
			
			InitDataProperty(0, cnt++ , dtHidden ,  40,   daCenter,       true,    "lvl",     				false,          "",       dfNone,       	   0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,   daCenterTop,    true,    " ",     				false,          "",       dfNone,       	   0,     false,       false);

			HeadRowHeight  = 10;
			InitTreeInfo("lvl", "", RgbColor(0,0,255), false);
				
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
			var comObj = document.getElementById("salesOffice");
			//RGN Office 검색조건 목록이 1개인 경우 RGN Office이거나 Sub Office
			//상위 Office가 들어온 경우 RGN Office가 1개 이상이므로 조회만 가능하도록 변경
			Editable = (comObj.GetCount() == 1) || isDevMode;
			
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo( 2, 1, 9, 100);
			
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
            InitColumnInfo(42, 0 , 0, true);	
			
			var HeadTitle1 = "Sub\nOffice|Sales Rep|Sales Rep|Modified\nDate(UTC)|Modified\nBy|Account|Local/IPI|Account|Account|POL|POD|DEST|";
			var HeadTitle2 = "Sub\nOffice|CODE|NAME|Modified\nDate(UTC)|Modified\nBy|Level|Local/IPI|CODE|NAME|POL|POD|DEST|";
			sheet2.masterColumnCount = HeadTitle1.split("|").length - 1;
			sheet2.forecastColumnCount = 10;//7;//5; //Total, TEU, hc, 45, 53, rf, wt
			sheet2.contractforecastColumnCount = 7;
			sheet2.bookingColumnCount = 11//8;

			sheet2.itemColumnCount = sheet2.forecastColumnCount +  sheet2.contractforecastColumnCount +  sheet2.bookingColumnCount ;
			sheet2.columnCount = sheet2.masterColumnCount + sheet2.itemColumnCount ;
//    			sheet2.conformColorDif = sheet2.bookingColumnCount + sheet2.forecastColumnCount;
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			//InitColumnInfo(sheet2.columnCount, sheet2.masterColumnCount, 0, false);
			
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(false, true, true, true, false,false) ;
			
			HeadTitle2 =HeadTitle2+"Total TEU|TEU|D2|D4|HC|45|53'|RF|RD|WT|Total TEU|TEU|HC|45|53'|RF|WT|Total TEU|TEU|FEU|D2|D4|HC|45|53'|RF|RD|WT|";
			for(var j = 0 ; j < sheet2.forecastColumnCount ; j++){
				HeadTitle1 = HeadTitle1 + "L.FCST|";
				
			}
			for(var j = 0 ; j < sheet2.contractforecastColumnCount ; j++){
				HeadTitle1 = HeadTitle1 + "C.FCST|";
				
			}
			for(var k = 0 ; k < sheet2.bookingColumnCount ; k++){
				 HeadTitle1 = HeadTitle1 + "BKG|";
			}
			
			//HeadTitle3 = HeadTitle3 + HeadTail;
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);

			var cnt = 0;
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "sub_ofc_cd",     		  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daCenterTop,   true,    "srep_usr_id",     		  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "srep_nm",     			  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    120,   daCenterTop,   true,    "modi_gdt",     			  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    120,   daCenterTop,   true,    "modi_usr",     			  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daCenterTop,   true,    "fcast_cust_tp_cd",        false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "usa_bkg_mod_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    "cust_cd",     			  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    100,   daLeftTop,     true,    "cust_nm",     			  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "pol_cd",     			  false,          "",       dfNone,       		 0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "pod_cd",     			  false,          "",       dfNone,       		 0,     true,        false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daCenterTop,   true,    "dest_loc_cd",     			false,          "",       dfNone,       	   0,     true,        false);
			//fcast_ttl_teu_qty
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "fcast_ttl_teu_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "fcast_ttl_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_20ft_dry_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_40ft_dry_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "fcast_40ft_hc_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "fcast_45ft_hc_qty",       false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "fcast_53ft_qty",          false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "fcast_rf_qty",     		  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,   daRight,   	  true,    "fcast_rd_qty",     		false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,   	  true,    "fcast_ttl_wgt",     	  false,          "",       dfNullInteger,       0,     false,       false);
			
			// Contract Forecast
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "cfcast_ttl_teu_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "cfcast_ttl_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_40ft_hc_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_45ft_hc_qty",      false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_53ft_qty",         false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "cfcast_rf_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,   	  true,    "cfcast_ttl_wgt",     	  false,          "",       dfNullInteger,       0,     false,       false);
			
			// Booking
			InitDataProperty(0, cnt++ , dtData ,    60,    daRight,   	  true,    "usd_bkg_ttl_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_20ft_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_40ft_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_20ft_dry_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daRight,   	  true,    "usd_bkg_40ft_dry_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_40ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_45ft_hc_qty",     false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_53ft_qty",        false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_rf_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    40,    daRight,   	  true,    "usd_bkg_rd_qty",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    50,    daRight,   	  true,    "usd_bkg_ttl_wgt",     	  false,          "",       dfNullInteger,       0,     false,       false);
			InitDataProperty(0, cnt++ , dtHidden ,  40,    daCenter,   	  true,    "lvl",     				  false,          "",       dfNone,       		 0,     false,       false);
			InitDataProperty(0, cnt++ , dtData ,    80,    daCenterTop,   true,    " ",     				  false,          "",       dfNone,       		 0,     false,       false);
				
			HeadRowHeight  = 10;
			InitTreeInfo("lvl", "", RgbColor(0,0,255), false);
				
		}
	}

    function t1sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	    case "usa_bkg_mod_cd":
        	case "pol_cd":
        	case "pod_cd":
        		var mark = sheetObj.CellValue(row, col);
        		if(mark == "+"){
       				sheetObj.RowExpanded(row) = true;
       				sheetObj.CellValue2(row, col) = "-";
    
        		}
        		else if(mark == "-"){
       				sheetObj.RowExpanded(row) = false;
       				sheetObj.CellValue2(row, col) = "+";
    
        		}
        		break;
		}
   	}
   	
   	
	function t1sheet2_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
	    case "usa_bkg_mod_cd":
    	case "pol_cd":
    	case "pod_cd":
    		var mark = sheetObj.CellValue(row, col);
    		if(mark == "+"){
   				sheetObj.RowExpanded(row) = true;
   				sheetObj.CellValue2(row, col) = "-";

    		}
    		else if(mark == "-"){
   				sheetObj.RowExpanded(row) = false;
   				sheetObj.CellValue2(row, col) = "+";

    		}
    		break;
		}
   	}
   	
    function initDataSelection(sheetNo){
      //      changeDataSelection1(document.getElementsByName("chkDs1Account")[0]);
        if(sheetNo == 0){
           	changeDataSelection1(document.getElementsByName("chkDs1OFC")[0]);
           	changeDataSelection1(document.getElementsByName("chkDs1US")[0]);
            changeDataSelection1(document.getElementsByName("chkDs1POL")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1POD")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1Dest")[0]);
			//changeDataSelection(document.getElementsByName("chkDs2OTH")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1D2")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1D4")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1HC")[0]);
			changeDataSelection1(document.getElementsByName("chkDs145")[0]);
			changeDataSelection1(document.getElementsByName("chkDs153")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1RF")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1RD")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1WT")[0]);
			changeDataSelection1(document.getElementsByName("chkDs1MDL")[0]);
        }	
        if(sheetNo == 1){
         	changeDataSelection(document.getElementsByName("chkDs2Account")[0]);
			changeDataSelection(document.getElementsByName("chkDs2OFC")[0]);
			changeDataSelection(document.getElementsByName("chkDs2US")[0]);
            changeDataSelection(document.getElementsByName("chkDs2POL")[0]);
			changeDataSelection(document.getElementsByName("chkDs2POD")[0]);
			changeDataSelection(document.getElementsByName("chkDs2Dest")[0]);
			//changeDataSelection(document.getElementsByName("chkDs2OTH")[0]);
			changeDataSelection(document.getElementsByName("chkDs2D2")[0]);
			changeDataSelection(document.getElementsByName("chkDs2D4")[0]);
			changeDataSelection(document.getElementsByName("chkDs2HC")[0]);
			changeDataSelection(document.getElementsByName("chkDs245")[0]);
			changeDataSelection(document.getElementsByName("chkDs253")[0]);
			changeDataSelection(document.getElementsByName("chkDs2RF")[0]);
			changeDataSelection(document.getElementsByName("chkDs2RD")[0]);
			changeDataSelection(document.getElementsByName("chkDs2WT")[0]);
			changeDataSelection(document.getElementsByName("chkDs2MDL")[0]);
        }	
    }
    

	function changeDataSelection(tobj, internal){
		if(internal == undefined || internal == null){
			internal == false;
		}
		
		beforetab = 1;
		var sheetObj = sheetObjects[beforetab];
//    		var comObj = document.getElementById("salesRep");
//    		 comObj.enable = true;
		
		var obj = null;
		if(tobj == undefined || tobj == null){
			tobj = null;
			obj = event.srcElement;
		}
		else{
			obj = tobj;
		}
		var sts = obj.checked;

		switch(obj.name){
	
		case "chkDs2Account":
			//레벨변경
		    sheetObj.ShowTreeLevel(sts?3:2,0);
			sheetObj.ColHidden("fcast_cust_tp_cd") = !sts; 
			sheetObj.ColHidden("cust_cd") = !sts; 
			sheetObj.ColHidden("cust_nm") = !sts;
			sheetObj.ColHidden("pol_cd") = !sts;
			
			if(!sts){
				document.all.ds2POD.checked = false;
    			changeDataSelection(document.all.ds2POD, true);
    			sheetObj.ShowTreeLevel(sts?3:2, 0);
			}
			
	    break;
	
		case "chkDs2US":

			sheetObj.ShowTreeLevel(sts?3:2, 1);
//			if(!sts)HideRow(sheetObj, "lvl", 2);
			if(!sts)HideRow(sheetObj, "lvl", 2);//여기확인
			break;
		case "chkDs2OFC":
	    case "chkDs2POL":
    	case "chkDs2POD":
			if(!internal){
				if(!document.all.ds2Account.checked){
					document.all.ds2Account.checked = true;
					changeDataSelection(document.all.ds2Account);
				}
				sheetObj.ShowTreeLevel(sts?4:3, 1);
			}
			sheetObj.ColHidden("pod_cd") = !sts;
			if(sts){
				_ChangeValue(sheetObj, "pod_cd", "+", "pod_cd", "-");
			}	
			_ChangeValue(sheetObj, "pol_cd", "+", "pol_cd", "-");
			break;
		
//    		controlTree(sheetObj);
//     		break;
//    		case "chkDs2OTH":
//    			hiddenTypeSize(sheetObj, sheet2, -1, sts);
//    			hiddenTypeSize(sheetObj, sheet2, 0, sts);
//    			break;

		case "chkDs2Dest":
			sheetObj.ColHidden("dest_loc_cd") = !sts;
			break;
			
       	case "chkDs2D2":
		    sheetObj.ColHidden("fcast_20ft_dry_qty") = !sts;
		    sheetObj.ColHidden("aloc_20ft_dry_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_20ft_dry_qty") = !sts;
		   	break;
		   	
       	case "chkDs2D4":
		    sheetObj.ColHidden("fcast_40ft_dry_qty") = !sts;
		    sheetObj.ColHidden("aloc_40ft_dry_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_40ft_dry_qty") = !sts;
		   	break;
			
		case "chkDs2HC":
			//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    if(document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked){ 
		    	sheetObj.ColHidden("fcast_ttl_qty") = false;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = false;
		    }else {
		    	sheetObj.ColHidden("fcast_ttl_qty") = true;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = true;
		    }
			sheetObj.ColHidden("fcast_40ft_hc_qty") = !sts;
			sheetObj.ColHidden("cfcast_40ft_hc_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_40ft_hc_qty") = !sts;
		    sheetObj.ColHidden("aloc_40ft_hc_qty") = !sts;
			break;
		case "chkDs245":
			//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    if(document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked) {
		    	sheetObj.ColHidden("fcast_ttl_qty") = false;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = false;
		    }else {
		    	sheetObj.ColHidden("fcast_ttl_qty") = true;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = true;
		    }
			sheetObj.ColHidden("fcast_45ft_hc_qty") = !sts;
			sheetObj.ColHidden("cfcast_45ft_hc_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_45ft_hc_qty") = !sts;
		    sheetObj.ColHidden("aloc_45ft_hc_qty") = !sts;
			break;
		case "chkDs253":
			//Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
		    if(document.form.chkDs2HC.checked || document.form.chkDs245.checked || document.form.chkDs253.checked) {
		    	sheetObj.ColHidden("fcast_ttl_qty") = false;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = false;
		    }else {
		    	sheetObj.ColHidden("fcast_ttl_qty") = true;
		    	sheetObj.ColHidden("cfcast_ttl_qty") = true;
		    }
			sheetObj.ColHidden("fcast_53ft_qty") = !sts;
			sheetObj.ColHidden("cfcast_53ft_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_53ft_qty") = !sts;
		    sheetObj.ColHidden("aloc_53ft_qty") = !sts;
			break;    			
		case "chkDs2RF":
			sheetObj.ColHidden("fcast_rf_qty") = !sts;
			sheetObj.ColHidden("cfcast_rf_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_rf_qty") = !sts;
		    sheetObj.ColHidden("aloc_rf_qty") = !sts;
			break;
		case "chkDs2RD":
			sheetObj.ColHidden("fcast_rd_qty") = !sts;
			sheetObj.ColHidden("cfcast_rd_qty") = !sts;
		    sheetObj.ColHidden("usd_bkg_rd_qty") = !sts;
		    sheetObj.ColHidden("aloc_rd_qty") = !sts;
			break;
			
		case "chkDs2WT":
			sheetObj.ColHidden("fcast_ttl_wgt") = !sts;
			sheetObj.ColHidden("cfcast_ttl_wgt") = !sts;
		    sheetObj.ColHidden("usd_bkg_ttl_wgt") = !sts;
		    sheetObj.ColHidden("aloc_ttl_wgt") = !sts;
			break;		
		case "chkDs2MDL":
			sheetObj.ColHidden("cfcast_ttl_qty") = !sts;
			sheetObj.ColHidden("cfcast_40ft_qty") = !sts;
			sheetObj.ColHidden("cfcast_40ft_hc_qty") = !sts;
			sheetObj.ColHidden("cfcast_45ft_hc_qty") = !sts;
			sheetObj.ColHidden("cfcast_53ft_qty") = !sts;
			sheetObj.ColHidden("cfcast_ttl_wgt") = !sts;
			break;	
		}
	}
	
    function changeDataSelection1(tobj, internal){

		if(internal == undefined || internal == null){
			internal == false;
		}
       beforetab = 0;
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
		switch(obj.name){
    		case "chkDs1OFC":
    		case "chkDs1US":
    	    case "chkDs1POL":
    		case "chkDs1POD":
   			
    		_controlTree(sheetObj);
    		break;
    		
    		case "chkDs1Dest":
    			sheetObj.ColHidden("dest_loc_cd") = !sts;
    		break;
            
           	case "chkDs1D2":
    		    sheetObj.ColHidden("fcast_20ft_dry_qty") = !sts;
    		    sheetObj.ColHidden("aloc_20ft_dry_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_20ft_dry_qty") = !sts;
    		   	break;
    		   	
           	case "chkDs1D4":
    		    sheetObj.ColHidden("fcast_40ft_dry_qty") = !sts;
    		    sheetObj.ColHidden("aloc_40ft_dry_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_40ft_dry_qty") = !sts;
    		   	break;
            
           	case "chkDs1HC":
    		    sheetObj.ColHidden("aloc_40ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("fcast_40ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("cfcast_40ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_40ft_hc_qty") = !sts;

    		    //Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
    		    if(document.form.chkDs1HC.checked ||document.form.chkDs145.checked || document.form.chkDs153.checked) {
    		    	sheetObj.ColHidden("fcast_lod_qty") = false;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = false;
    		    }else { 
    		    	sheetObj.ColHidden("fcast_lod_qty") = true;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = true;
    		    }
    		   	break;
    		case "chkDs145":
    		    sheetObj.ColHidden("aloc_45ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("fcast_45ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("cfcast_45ft_hc_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_45ft_hc_qty") = !sts;
    		    
    		    //Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
    		    if(document.form.chkDs1HC.checked ||document.form.chkDs145.checked || document.form.chkDs153.checked) {
    		    	sheetObj.ColHidden("fcast_lod_qty") = false;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = false;
    		    }else { 
    		    	sheetObj.ColHidden("fcast_lod_qty") = true;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = true;
    		    }
    		  	break;
    		case "chkDs153":
    		    sheetObj.ColHidden("aloc_53ft_qty") = !sts;
    		    sheetObj.ColHidden("fcast_53ft_qty") = !sts;
    		    sheetObj.ColHidden("cfcast_53ft_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_53ft_qty") = !sts;
    		    
    		    //Total TEU추가에 따라 TEU의 경우는 HC, 45, 53가 체크 된경우 나타난다.
    		    if(document.form.chkDs1HC.checked ||document.form.chkDs145.checked || document.form.chkDs153.checked) {
    		    	sheetObj.ColHidden("fcast_lod_qty") = false;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = false;
    		    }else { 
    		    	sheetObj.ColHidden("fcast_lod_qty") = true;
    		    	sheetObj.ColHidden("cfcast_lod_qty") = true;
    		    }
    		  	break;
    		case "chkDs1RF":
    		    sheetObj.ColHidden("aloc_rf_qty") = !sts;
    		    sheetObj.ColHidden("fcast_rf_qty") = !sts;
    		    sheetObj.ColHidden("cfcast_rf_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_rf_qty") = !sts;
    		  	break;
    		  	
    		case "chkDs1RD":
    		    sheetObj.ColHidden("aloc_rd_qty") = !sts;
    		    sheetObj.ColHidden("fcast_rd_qty") = !sts;
    		    sheetObj.ColHidden("usd_bkg_rd_qty") = !sts;
    		  	break;
    		  	
    		case "chkDs1WT":
    		    sheetObj.ColHidden("aloc_ttl_wgt") = !sts;
    		    sheetObj.ColHidden("fcast_ttl_wgt") = !sts;
    		    sheetObj.ColHidden("cfcast_ttl_wgt") = !sts;
    		    sheetObj.ColHidden("usd_bkg_ttl_wgt") = !sts;
    			break;		
    		case "chkDs2MDL":
    			sheetObj.ColHidden("cfcast_ttl_qty") = !sts;
    			sheetObj.ColHidden("cfcast_40ft_qty") = !sts;
    			sheetObj.ColHidden("cfcast_40ft_hc_qty") = !sts;
    			sheetObj.ColHidden("cfcast_45ft_hc_qty") = !sts;
    			sheetObj.ColHidden("cfcast_53ft_qty") = !sts;
    			sheetObj.ColHidden("cfcast_ttl_wgt") = !sts;
    			break;	
		}
	}
	

	function _controlTree(sheetObj){

    	var formObj = document.form;
    	var sts1 = true;//formObj.chkDs1OFC.checked ;
    	var sts2 = formObj.chkDs1US.checked; //2
    	var sts3 = formObj.chkDs1POL.checked; //2->3
    	var sts4 = formObj.chkDs1POD.checked; //3->4
    	var sts5 = formObj.chkDs1Dest.checked; //tree랑 상관없음

    	    	
    	//log("controlTree : sts - " + sts1 + ", " + sts2 + ", " + sts3);
    	with(sheetObj){
    		log("sheetobj" + sheetObj);
    		ShowTreeLevel(sts4?4:(sts3?3:(sts2?2:1)));
    		
    		if(sts2){
    			//ChangeValue(sheetObj, "lvl", "1", "pol_cd", "-");
    			_ChangeValue(sheetObj, "lvl", "1", "usa_ bkg_mod_cd", "-");
    		}
    		
    		if(sts3){   			
    			//ChangeValue(sheetObj, "lvl", "1", "pol_cd", "-");
    			_ChangeValue(sheetObj, "lvl", "2", "pol_cd", "-");
    		}
    		if(sts4){  			
    			//ChangeValue(sheetObj, "lvl", "2", "pod_cd", "-");
    			_ChangeValue(sheetObj, "lvl", "3", "pod_cd", "-");
    		}
    		
    		if(!sts1)HideRow(sheetObj, "lvl", 1);
    		if(!sts2)HideRow(sheetObj, "lvl", 2);
    		if(!sts3)HideRow(sheetObj, "lvl", 3);
    		if(!sts4)HideRow(sheetObj, "lvl", 4);
    		//ColHidden("pod_cd") = !sts3;
    		//ColHidden("pol_cd") = !sts2&&!sts3;
    		ColHidden("dest_loc_cd") =!sts5;
    		ColHidden("pod_cd") = !sts4;
    		ColHidden("pol_cd") = !sts3&&!sts4;
    		ColHidden("usa_bkg_mod_cd") = !sts2; //독립적?
    	}
    	return true;
    }

    function _ShowRow(sheetObj, col, val){
    	with(sheetObj){
    		var frow = -1;
    		while((frow = FindText(col, val, frow + 1)) >= 0){
    			RowHidden(frow) = false;
    		}
    	}
    }
    
    function HideRow(sheetObj, col, val){
    	with(sheetObj){
    		
    		var frow = -1;
    		while((frow = FindText(col, val, frow + 1)) >= 0){
    			//alert("frow" + flow);
    			RowHidden(frow) = true;
    		}
    	}
    }
    
    function _ChangeValue(sheetObj, col, val, sCol, sVal){
    	with(sheetObj){
    		var frow = -1;
    		while((frow = FindText(col, val, frow + 1)) >= 0){
    			CellValue2(frow, sCol) = sVal;
    
    		}
    	}
    }

	var searchSalesRep = new Array();
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
				
                var param = "year=" + formObj.year.value;
                param = param + "&week="        + formObj.week.value;
                param = param + "&duration="    + formObj.duration.value;
                param = param + "&ioc="         + (formObj.id_chk_ocn.checked?formObj.id_chk_ocn.value:(formObj.id_chk_ipc.checked?formObj.id_chk_ipc.value:formObj.id_chk_ts.value));
                param = param + "&vvd="         + formObj.vvd.value;
                param = param + "&trade="       + comObjects[0].Code;
                param = param + "&subtrade="    + comObjects[1].Code;
                param = param + "&lane="        + comObjects[2].Code;
                param = param + "&bound="       + formObj.bound.value;
                param = param + "&salesOffice=" + comObjects[3].Code;;
                param = param + "&subOffice="   + comObjects[4].Code;;
                param = param + "&salesRep="    + comObjects[5].Code;
                param = param + "&customer="    + comObjects[6].Code;
                
//                    searchParams = FormQueryString(formObj);
                searchParams = param;
                
			    if(beforetab==0){
                	searchByOffice(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                	_controlTree(sheetObj);
                }else if(beforetab==1){          	
                	searchByAccount(sheetObj, formObj, (SEARCHLIST01 + beforetab));
                	changeDataSelection(document.all.ds2Account);
                	changeDataSelection(document.all.ds2POD);
                 }
			break;
           case SEARCHLIST03:      //SPC01 권한 조회
               	formObj.f_cmd.value = SEARCHLIST03;
            	var param = SpcFormString(formObj,"usr_role_cd");
            	rtn = sheetObjects[0].GetSearchXml("ESM_SPC_0104GS1.do", "f_cmd="+ formObj.f_cmd.value +"&"+ param);
            	var usrRoleYn = ComGetEtcData(rtn,"usrRoleYn");
        	   return usrRoleYn;
        	   break;
           case IBDOWNEXCEL:        //엑셀 다운로드              
              sheetObj.Down2Excel(-1, false, false, true);
              break;
        }
    }
    
    function searchByOffice(sheetObj, formObj, command){
		
		if(tab_retrives[beforetab]) return;
		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0104GS.do", "f_cmd="+command+"&"+searchParams);
        tab_retrives[beforetab] = true;
    } 
    function searchByAccount(sheetObj, formObj, command){
			
		if(tab_retrives[beforetab]) return;
		var rtn = sheetObj.DoSearch4Post("ESM_SPC_0104GS.do", "f_cmd="+command+"&"+searchParams);
        tab_retrives[beforetab] = true;
    }    
   
	function initData2(sheetObj){
		//ChangeValues2(sheetObj, "treeLevel", "2", "d_pol_cd", "-");
		//ChangeValues2(sheetObj, "treeLevel", "3", "d_pod_cd", "-");
	}
	
    function t1sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    	selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
    }
    
	function t1sheet1_OnChange(sheetObj, row, col, value){
	}
	
  	function vvdChanged(){
  		
  		var obj = event.srcElement;
//  		if(obj.value == ""){
//  			trade_OnChange(comObjects[0], comObjects[0].Code, comObjects[0].Text);
//  		}
//  		else{
			document.all.id_chk_ocn.checked = true;
			document.all.id_chk_ocn.disabled = false;			
	    	document.all.id_chk_ipc.disabled = false;			
	    	document.all.id_chk_ts.disabled = false;
	    	
//  		}
  		
  		var vvd = obj.value;
  		var ioc = getRadioValue(document.form.ioc);
  		var rtn = getCodeList("CheckVVD", "vsl_cd="+vvd.substr(0, 4)
							             +"&skd_voy_no="+vvd.substr(4, 4)
							             +"&skd_dir_cd="+vvd.substr(8, 1)
							             +"&ioc_cd="+ioc);
  		
  		var trade = rtn[0].split("|");
  		var text  = rtn[1].split("|");
  		var dir   = text[0].split("~");
  		
  		if(dir[1] == "Y"){
  			document.form.chkDs1MDL.checked = true;
  			document.form.chkDs2MDL.checked = true;
  		}else{
  			document.form.chkDs1MDL.checked = false;
  			document.form.chkDs2MDL.checked = false;
  		}
  		
  		var rtn = getCodeList("TradeAccount", "trade="+trade[0]
							                 +"&year="+dir[0].substr(0, 4)
							                 +"&week="+dir[0].substr(5)
							                 +"&duration="+1);
		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
  			
  	}
  	
	function trade_OnChange_t(comObj, value, text ){
		if(text == '|ALL'){	optionAllReset("trade",value);   return;} // 0207 SHKIM
		if(value == "") return;
		if(document.all.vvd.value != "") return;
		if(value.charAt() != "I"){
			document.all.id_chk_ocn.checked = true;
			document.all.id_chk_ocn.disabled = true;			
        	document.all.id_chk_ipc.disabled = true;			
        	document.all.id_chk_ts.disabled = true;		
        	
		}
		else{
			document.all.id_chk_ipc.checked = true;
			document.all.id_chk_ocn.disabled = true;			
        	document.all.id_chk_ipc.disabled = false;			
        	document.all.id_chk_ts.disabled = false;	
        			
		}
		SpcSearchOptionSubTrade("subtrade",true,false,"","",value);
		SpcSearchOptionLane("lane",true,true,'',value,'',true);
		
		var rtn = getCodeList("TradeAccount", "trade="+document.form.trade.Code
						                     +"&year="+document.form.year.value
						                     +"&week="+document.form.week.value
						                     +"&duration="+document.form.duration.value);
		initData_acctList(rtn[0].split("|"), rtn[1].split("|"));
	} 
	
	function salesOffice_OnChange(comObj, value, text ){
		if(value == "") return;
		var rtn = getCodeList("ChildOffice", "ofc_cd="+value+"&level=5&include=1");
		initData_subOffice(rtn[0].split("|"), rtn[1].split("|"));
		if(document.getElementById("subOffice").Code == ""){
			var rtn = getCodeList("SalesRep", "ofc_cd="+value+"&level=4");
			initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
		}
		
		// 2010.05.10 subOffice Index = 0 값을 늦게 가져와서 재호출
		var subObj = document.getElementById("subOffice");
		subOffice_OnChange(subObj, subObj.Code, subObj.Text);
	} 
	
	function subOffice_OnChange(comObj, value, text ){
		var rtn = "";
		if(value == ""){
			rtn = getCodeList("SalesRep", "ofc_cd="+document.getElementById("salesOffice").Code+"&level=4");
		}
		else{
			rtn = getCodeList("SalesRep", "ofc_cd="+value+"&level=5");
		}
		initData_salesRep(rtn[0].split("|"), rtn[1].split("|"));
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
			Enable = !(Index > 1);
	    }
	}
    
	function initDataValue_subOffice(){
	    var sheetObj = document.getElementById("subOffice");
	    with(sheetObj){
	        Index2 = 0;
	    }
	}
	
	function initData_salesRep(codes, names){
	    var sheetObj = document.getElementById("salesRep");
//    	     var sheettab = sheetObjects[beforetab];
//                    alert("beforetab" + beforetab);
//              if(beforetab == 0 ){
//              	sheetObj.enable = false;
//              }else{
//              	sheetObj.enable = true;
//              }
                
	        var cnt = 0;
	    with(sheetObj){
	    	RemoveAll();
	        SetTitle("Code|Name|OFC|OFC NM");
	        SetColWidth("60|150|60|100");
	        SetColAlign("left|left|left|left");
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
		    	if(txt[3] == "1"){
		    		selectCode = codes[i];
		    	}
		    	InsertItem(-1, codes[i]+"|"+names[i].replace(/~/g, "|"), codes[i]);
		    }
		    if(selectCode != ""){
		    	Code = selectCode;
		    }
		    else{
		    	Index = 0;
		    }
	    }
	}
    
	function initDataValue_salesRep(){
	    var sheetObj = document.getElementById("salesRep");
	  	   
	     with(sheetObj){
	        Index2 = 0;
	    }
	}
	
	function initDataValue_acct(){
		var sheetObj = document.getElementById("acct");
		
		with(sheetObj){
			Index2 = 0;
		}
	}
    
    function getCustAbbrNm(custCntCd,custSeq){
  	    var custNm = "";

        var rtn = getCodeList("CustAbbrNm", "cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq);
        var code = rtn[0];
        var text = rtn[1];
        var arrText = text.split("|");
        if( arrText.length > 0){
           custNm = arrText[0];
        }  	    
  	    return custNm;
  	}   
  	
   	function getCustGrpNm(customerGrp){
  	    var custNm = "";

        var rtn = getCodeList("CustGrpNm", "cust_grp_id="+customerGrp);
        var code = rtn[0];
        var text = rtn[1];
        var arrText = text.split("|");
        if( arrText.length > 0){
           custNm = arrText[0];
        }  	    
  	    return custNm;
  	} 	
  	       
    function callbackPopupCustomerGrp(rowArray){
        var colArray = rowArray[0];	
    	document.all.customerGrp.value = colArray[3];
    }

    function customer_OnKeyDown(){
    	log(event.keyCode);
       	if(event.keyCode >128){
       		event.cancelBubble = true;
       		return false;
       	}
        if(event.srcElement.value.length >= 2){
        	if(event.keyCode >=65 && event.keyCode <= 90){
        		event.cancelBubble = true;
        		return false;
        	}
        }
    }    
        
    function callbackPopupCustomer(rowArray){
        var colArray = rowArray[0];	
        var val = colArray[3];
    	document.all.customer.value = val;
    	document.all.customerCo.value = val.substring(0,2);
    	document.all.customerCd.value = val.substring(2);
    	document.all.customerNm.value = colArray[4];
    } 	
	
    function customer_OnChange(){
            var obj = event.srcElement;
            var val = obj.value;
            var custCntCd = val.substring(0,2);
            var custSeq = val.substring(2);
        	document.all.customerCo.value = custCntCd
        	document.all.customerCd.value = custSeq
        	if(custSeq.length > 0 ){
        	    obj.value = custCntCd + lpad(custSeq,6,'0');
                document.all.customerNm.value = getCustAbbrNm(custCntCd,custSeq) ;	        
        	}
    		if(obj.value.length < 8){
    			document.all.customerNm.value = "";
    		}
    }  
 
    function customer_OnKeyPress(){
        eventKeyChangeChar(UPPER_CASE);
    }
 
    function customerGrp_OnChange(){
        var obj = event.srcElement;
        var customerGrp = obj.value;
    	if(customerGrp.length > 0 ){
            document.all.customerGrpNm.value = getCustGrpNm(customerGrp ) ;	        
    	}
    }    
    	
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){

        switch(sAction) {
			
           case IBSEARCH:      //조회
                var sheetObj = sheetObjects[beforetab];
               	var vvd = formObj.vvd.value;
				var trade = comObjects[0].Code;
				var lane  = comObjects[2].Code;
				var office = comObjects[3].Code;
				var suboffice = comObjects[4].code;
				if(beforetab == 0){
				
					if(vvd != "" && vvd.length < 9){
						ComShowCodeMessage("COM12174", "VVD", "9");
						formObj.vvd.focus();
						return false;
				    } else if(vvd == "" && trade == ""){
				    	ComShowMessage(getMsg("SPC90114", "Trade"));
					    comObjects[0].focus();
					    return false;
				    }else if(vvd == "" && lane == ""){
				    	ComShowMessage(getMsg("SPC90114", "Lane"));
					    comObjects[2].focus();
					    return false;
				    }else if(office == ""){
				    	ComShowMessage(getMsg("SPC90114", "Office"));
					    comObjects[3].focus();
					    return false;
				    }      
				   
				}else if(beforetab==1){
					
					if(vvd = "" || vvd.length < 9){
						ComShowCodeMessage("COM12174", "VVD", "9");
						formObj.vvd.focus();
						return false;
					  }else if(office == ""){
				    	ComShowMessage(getMsg("SPC90114", "Office"));
					    comObjects[3].focus();
					    return false;
				    }      	
						
				}

		    break;
		}
		return true;
    }

    function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subTrade(){
    	var sheetObj = document.getElementById("subTrade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }        
    
    function subTrade_OnChange_t(comObj,value,text ){
    	SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);
    	if(value == "" ) return;
    	
    	var arrSubtrade = text.split("|");
    	if(arrSubtrade.length > 1) {
    		comObjects[0].Code2 = arrSubtrade[0];
    		comObjects[2].Code2 = '';
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = '';
    	}        	
    }  

    function lane_OnChange(comObj,value,text ){
    	// 해당사항없음.if(text == '||ALL'){	optionAllReset("lane");  } // 0207 SHKIM
    	comObj.UseCode=true;
    	if(value == "" ) return;
    	
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].Code2 = arrLane[0];
    		comObjects[1].Code2 = arrLane[1];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[1].Code2 = comObj.GetText(value,1);  
    	}
    }        
    
    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week",false,document.form.year.value);
    	
    }   
    
    function initData_acctList(codes, names) {
    	var sheetObj = document.getElementById("acct");
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
    			Index = 0;
    		}
    		Enable = (GetCount() > 0);
    	}
    }
    
    /*
     * 선택된 하나의 Radio Object Value를 반환
     * @param     oRadio : object Radio
     * @return    String
     */
    function getRadioValue(oRadio) {
        if (oRadio == null) return "";

        if (oRadio.length != null)
        {
            for(i=0; i<oRadio.length; i++)
            {
                if (oRadio[i].checked) return oRadio[i].value;
            } // end for
        } else  {
            if (oRadio.checked) return oRadio.value;
        } // end if
        return "";
    }
    
    
	 /**************** IE11지원을 위해 combobox 잔상 제거용 코드 추가 ****************/
	 /*
	  * 기존의 onChange를 onChange_t로 변경하고, onChange에서는 timeout을 두어 onChange_t를 호출하도록 변경함
	  */
	 function trade_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("trade").focus(); 
	 }

	 function subTrade_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("subTrade").focus(); 
	 }
	 
	 function lane_OnFocus(combj, value, text){
        document.getElementById("year").focus();
        document.getElementById("lane").focus(); 
	 }
	 
	 function trade_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){trade_OnChange_t(formObj,value)},10);
	 }

	 function subTrade_OnChange(combj, value, text){
		 var formObj = document.form;
		 setTimeout(function(){subTrade_OnChange_t(formObj,value)},10);
	 }
    
    
	/* 개발자 작업  끝 */
