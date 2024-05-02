/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0017.js
*@FileTitle : Sea Inventory  
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.06.03 김종준
* 1.0 Creation
* 
* 2010.11.16 이상민 [CHM-201007040-01]
* 1. SEA Inventory 검색조건 CMDT추가, 빠른Grid "Speed"옵션 추가
* 2. 3번째 탭 CNTR List 외 탭에서 CMDT조건 Hide
* 3. CMDT 체크시 MST_CONTAINER와 BKG_BOOKING 조인하여 CMDT / REMARK select
* 2011.03.30 남궁진호 [CHM-201109765-01] ETD DT, ETA DT 컬럼 추가
* 2011.10.12 신자영 [CHM-201113678-01] [CIM] SEA-INVENTORY POL-POD 검색 관련 보완
* 2012.01.05 신자영 [CHM-201215469-01] [CIM] sea-inventory / cntr list 기능 보완
* 2012.05.03 신자영 [CHM-201217541-01] [CIM] ALPS Inventory-Sea inventory에 제작년도 보여주는 화면
=========================================================*/
	
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var polPodDelFlag = "";

	var head_cntr_tpsz_cd ="";
	var headTitle ="";
	var tot_cnmv_sts_cd ="";
	var tot_lstm_cd ="";
	var comboObjects = new Array();
	var comboCnt = 0 ;
	var IBSEARCH01  = 29;
	var IBSEARCH02  = 30;
	var IBSEARCH03  = 31;
	var IBSEARCH04  = 32;

	/**
	 * @extends 
	 * @class ees_cim_0017 : ees_cim_0017 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ees_cim_0017() {
		this.processButtonClick		= tprocessButtonClick;
		this.setSheetObject 		= setSheetObject;
		this.loadPage 				= loadPage;
		this.initSheet 				= initSheet;
		this.initControl            = initControl;
		this.doActionIBSheet 		= doActionIBSheet;
		this.setTabObject 			= setTabObject;
		this.validateForm 			= validateForm;
	}

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */ 
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var shtCnt = 0;
         var sheetObject = sheetObjects[shtCnt++];
         var sheetObject = sheetObjects[shtCnt++]; 
         var sheetObject = sheetObjects[shtCnt++];
                  
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {
					case "btn_Retrieve":
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
						if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
							doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
							doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
						} else if ( beforetab == 2 ) {	//세번째 탭에서 조회.
							doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
						}
						break;
			        case "btn_new":
			        	formObject.reset();
						comboObjects[0].Code = '';
						comboObjects[1].Code = '';
						sheetObjects[0].RemoveAll();
						sheetObjects[1].RemoveAll();
						sheetObjects[2].RemoveAll();
						document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd;
						
						break;
					case "btn_lane":	//Lane 조회 팝업
						var param = '?mode=svc&lane_cd='+formObject.slan_cd.value+'&lane_nm=&svc_tp=&classId=';
						ComOpenPopup('/hanjin/COM_ENS_081.do' + param , 1000, 450, 'getLineInfo', '1,0,1,1,1,1,1,1', true);
						break;
					case "btn_vvd":  	//vvd 조회 팝업
						ComOpenPopup('/hanjin/COM_ENS_0B2.do', 780, 470, "getVvdInfo", '1,0,1,1,1,1,1,1', true);
						break;
					case "btns_pol_search":
						getPolPodDelInfo("POL");
						break;
					case "btns_pod_search":
						getPolPodDelInfo("POD");
						break;
					case "btns_del_search":
						getPolPodDelInfo("DEL");
						break;
					case "btn_movement":

						if ( sheetObjects[2].rowCount != 0 ) {
			                var cnmv_dt = sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"cnmv_dt");
			                ComOpenWindowCenter("/hanjin/EES_CTM_0408.do?" +
			                                    "p_cntrno=" 	+ sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"cntr_no").substring(0,10) + "&" +
			                                    "check_digit=" 	+ sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"cntr_no").substring(10,11) + "&" +
			                                    "ctnr_tpsz_cd=" + sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"cntr_tpsz_cd") + "&" +
			                                    "p_date1=" 		+ ComGetDateAdd(cnmv_dt, "M", -6, "-", true) + "&" +
			                                    "p_date2=" 		+ ComGetDateAdd(cnmv_dt, "M", 0, "-", true) + "&" +
			                                    "pop_mode=1"
			                                    ,"EES_CTM_0408", 1020, 682);
						}
						break;
					case "btn_master":
						if ( sheetObjects[2].rowCount != 0 ) {
							var cntr_no = sheetObjects[2].CellValue(sheetObjects[2].SelectRow,"cntr_no");
							var cntr_no_len =cntr_no.length;
							if ( cntr_no_len > 10 ) {
								cntr_no = cntr_no.substring(0,10);
							} 
							ComOpenPopup("/hanjin/EES_MST_0019.do?cntr_no="+cntr_no+"&popup_mode=Y",1100, 690, "", "1,0,1,1,1,1,1,1", true);
						}
						break;						
					case "btn_downexcel":
						if ( beforetab == 0 ) {	  //첫번째탭에서 조회
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
							doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
						} else if ( beforetab == 2 ) {	//두번째 탭에서 조회.
							doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
						}
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
     * POL,POD,DEL 정보 조회 팝업호출
    */
    function getPolPodDelInfo(flag) {
    	polPodDelFlag = flag;
		ComOpenPopup("/hanjin/COM_ENS_051.do",755, 460, "popupFinish", "1,0,1,1,1,1,1,1", true);
    }

    /**
     * POL,POD,DEL 정보 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var formObject = document.form;
        if ( polPodDelFlag == 'POL' ) {
            formObject.pol_cd.value = aryPopupData[0][3] 
        } else if ( polPodDelFlag == 'POD' ) {
            formObject.pod_cd.value = aryPopupData[0][3] 
        } else if ( polPodDelFlag == 'DEL' ) {
            formObject.del_cd.value = aryPopupData[0][3]
        }
    }
    /**
     * getLineInfo 1 : 팝업에서 Radio로 단일 선택을 한경우..
     */
    function getLineInfo(rowArray) {
        var colArray = rowArray[0];
        var formObject = document.form;
        
        formObject.slan_cd.value = colArray[3];
    }
  	/**
  	 * Vessel SKD & Code Inquiry부분.<br>
  	 * @param {arry} aryPopupData
  	 */
  	function getVvdInfo(aryPopupData) {
  		var formObject = document.form;
  		var vvd = aryPopupData[0][7];
  		if ( formObject.vvd1.value == ''  ) {
  	  		formObject.vvd1.value = vvd;
  		} else if  ( formObject.vvd2.value == ''  ) {
  	  		formObject.vvd2.value = vvd;
  		} else if  ( formObject.vvd3.value == ''  ) {
  	  		formObject.vvd3.value = vvd;
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
    * IBCombo Object를 배열로 등록
    * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    * 배열은 소스 상단에 정의
    */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
     
    /**
    * Tab 기본 설정
    * 탭의 항목을 설정한다.
    */
    function initCombo (comboObj, comboNo) {
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage( ) {
        for(i=0;i<sheetObjects.length;i++){
        
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
        
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
        initControl();     	
    }
    /**
     * 초기 이벤트 등록
     */
	function initControl() {
     	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no');						//cntr_no keyup 이벤트 처리
     	axon_event.addListener('click', 'pol_pod_wise_click', 'pol_pod_wise', '');			//POL-POD Pair View  클릭시
     	axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리
	}
    /**
     * 키이벤트
     */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "slan_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "pol_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "pod_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "del_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "vvd1":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "vvd2":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "vvd3":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
			case "stay_days":
				ComKeyOnlyNumber(event.srcElement);// 알파벳 대문자,숫자만 입력허용
				break;
		}
	}

    /**
     * TP/SZ  클릭 이벤트 등록
     */
    function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
    
    /**
     * Lease Term  클릭 이벤트 등록
     */
    function lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk = comboObj.CheckIndex(index);
    		if(bChk){
    			for(var i = 1 ; i < comboObj.GetCount() ; i++) {
    				comboObj.CheckIndex(i) = false;
    			}
    		}
    	} else {
    		comboObj.CheckIndex(0) = false;
    	}
    }
    
    /**
     * 포커스가 들어왔을시 이벤트 등록
     */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}

	/**
	* POL-POD Pair View 클릭시 이벤트 처리
	* POL-POD Pair View 조건별 조회.
	*/ 
	function pol_pod_wise_click() {
	   if ( document.form.pol_pod_wise[0].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[0].value;
	   } else if ( document.form.pol_pod_wise[1].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[1].value;
	   } else if ( document.form.pol_pod_wise[2].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[2].value;
	   } else if ( document.form.pol_pod_wise[3].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[3].value;
	   } else if ( document.form.pol_pod_wise[4].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[4].value;
	   } else if ( document.form.pol_pod_wise[5].checked ) {
		   curr_pol_pod_wise = document.form.pol_pod_wise[5].value;
	   }
	   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
	}

    /**
    * cntr_no keyup 이벤트 처리
    * cntr_no keyup시 대분자로 처리
    */
    function cntr_no_onkeyUp() {
        var formObject = document.form;
        formObject.cntr_no.value = formObject.cntr_no.value.toUpperCase();
    }


    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle,viewFlag) {

        var cnt = 0;
        var shtID = sheetObj.id;

        switch(sheetNo) {

            case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 320;
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 20, 100);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)

                    if (headTitle==null || headTitle =="") {
                    	headTitle = "VVD|F/M|L/Term|Total|D2|D4|D5|D7|R2|R5|O2|O4|S2|S4|F2|F4|F5|A4|A2|R7|P2|P4|T2|T4|D8|D9|DW|DX";
                    }
                    var headCnt  = ComCountHeadTitle(headTitle); 
                    InitColumnInfo(headCnt, 0, 0, true);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle, true);
                    CountPosition = 0;	//페이지카운트 없애기
                    sheetObj.FrozenCols = 4;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , 	dtAutoSum,  100,	daCenterTop,	true,	"vvd",			false,	"",    dfNone);
                    InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"division",		false,	"",    dfNone);
                    InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"lstm_cd",		false,	"",	   dfNone);
                    InitDataProperty(0, cnt++ , 	dtData,		60,   	daRight,  		true,	"total_cnt",   	false,	"",	   dfNullInteger);
                    for(var i=1 ; i <= headCnt - 4 ; i++){
                 	   	InitDataProperty(0, cnt++ , dtData,  	60,    	daRight,		true,	"qty"+i,		false,  "",    dfNullInteger,		0,     true,       true);
                    }
               }
               break;

            case 2:      //sheet2 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 290;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 20, 100);
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)
                    if (headTitle==null || headTitle =="") {
                    	headTitle = "VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|R7|P2|P4|T2|T4";
                    }
                    var headCnt  = ComCountHeadTitle(headTitle); 
                    InitColumnInfo(headCnt, 0, 0, true);
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, headTitle, true);
                    CountPosition = 0;	//페이지카운트 없애기
                    sheetObj.FrozenCols = 6;

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(	 0, cnt++ , 	dtAutoSum, 100,		daCenterTop,	true,	"vvd",		false,	"",    dfNone);
                    if ( viewFlag == 'CHG') {
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"pod",		false,	"",	   dfNone);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"eta_dt",	false,	"",	   dfDateYmd);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"pol",		false,	"",    dfNone);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"etd_dt",	false,	"",	   dfDateYmd);
                    } else {
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"pol",		false,	"",    dfNone);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"etd_dt",	false,	"",	   dfDateYmd);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"pod",		false,	"",	   dfNone);
                    	InitDataProperty(0, cnt++ , 	dtData,		75,		daCenterTop,	true,	"eta_dt",	false,	"",	   dfDateYmd);
                    }
                    InitDataProperty(	 0, cnt++ , 	dtData,		60,   	daRight,  		true,	"total_cnt",false,	"",	   dfNullInteger);
                    for(var i=1 ; i <= headCnt - 6 ; i++){
                 	   	InitDataProperty(0, cnt++ , 	dtData,  	60,    	daRight,		true,	"qty"+i,	false,  "",    dfNullInteger,		0,     true,       true);
                    }
               }
               break;
                 
            case 3:      //sheet3 init
                with (sheetObj) {

                    // 높이 설정
                    style.height = 330;
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

                    var HeadTitle1 = "Seq.|VVD|CNTR No.|TP/SZ|F/M|Term|AGMT No|POL|Loading Date|POD|ETA POD|DEL|S. Days|BKG No|B/L No.|CMDT|CMDT(Customs)|DMG|HRT|HBT|HBQ|DP|IM|Lessor|M/Date";
 
                    var headCount = ComCountHeadTitle(HeadTitle1);       

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtDataSeq,		35,	  daRight,	 true,	"seq",        				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			80,   daCenter,  true,	"vvd",        				false,	"",	dfNone);
                                                            		           
                    InitDataProperty(0, cnt++ , dtData,			80,   daCenter,  true,	"cntr_no",     				false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"cntr_tpsz_cd", 			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"full_flg",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"lstm_cd",      			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			70,   daCenter,  true,	"agmt_no",      			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			55,   daCenter,  true,	"pol_cd",       			false,	"",	dfNone);
                                                            		           
                    InitDataProperty(0, cnt++ , dtData,			80,   daCenter,  true,	"cnmv_dt",      			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			55,   daCenter,  true,	"pod_cd",       			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			120,   daCenter,  true,	"pod_eta",       			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			55,   daCenter,  true,	"del_cd",       			false,	"",	dfNone);
                  	InitDataProperty(0, cnt++ , dtData,			50,   daCenter,  true,	"stay_days",    			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			95,   daCenter,  true,	"bkg_no",      				false,	"",	dfNone);
                                                            		           
                    InitDataProperty(0, cnt++ , dtData,			95,   daCenter,  true,	"bl_no",       				false,	"",	dfNone);
                    
                    InitDataProperty(0, cnt++ , dtData,				200,   	daLeft,  	true,	"rep_cmdt_nm",     			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,				200,   	daLeft,  	true,	"mk_desc",    				false,	"",	dfNone);
                    
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"dmg_flg",      			false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			45,   daCenter,  true,	"cntr_hngr_rck_cd",     	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			45,   daCenter,  true,	"mnr_hngr_bar_tp_cd",     	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			40,   daRight,   true,	"cntr_hngr_bar_atch_knt",   false,	"",	dfNullInteger);
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"disp_flg",         		false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			40,   daCenter,  true,	"imdt_ext_flg",         	false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			60,   daCenter,  true,	"lessor",                   false,	"",	dfNone);
                    InitDataProperty(0, cnt++ , dtData,			50,   daCenter,  true,	"mft_dt",         	false,	"",	dfNone);
                    
                }
                break;                  
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;  
        switch(sAction) {
           	case IBSEARCH:      //조회
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 	            
	  	        formObj.f_cmd.value = SEARCH;
	  	        sheetObj.Redraw = false;
	  	        sheetObj.RemoveAll();
	  	        
	  	        sheetObj.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj));
	  	        
		        ComOpenWait(false); 
                break;
           	case IBSEARCH01:      //공통조회
               	form.f_cmd.value = SEARCH01;
               	var sXml = sheetObj.GetSearchXml("EES_CIM_0017GS.do" , FormQueryString(form));
               
               	//TP/SZ 조회
               	var cntr_tpsz_cd = ComGetEtcData(sXml,"cntr_tpsz_cd");	   
               
               	head_cntr_tpsz_cd = cntr_tpsz_cd;
               	document.form.head_cntr_tpsz_cd.value =head_cntr_tpsz_cd;
               	var strCntrTpszCd  = cntr_tpsz_cd.split("|");
      
               	with (form.cntr_tpsz_cd) {
              	 	MultiSelect = true;
              	 	MultiSeparator = ",";
              	 	DropHeight = 330;
              	 	InsertItem(0 , 'ALL','');
              	 	for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
              	 		InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
              	 	}
               	}                  

   			 	var HeadTitle  = "VVD|F/M|L/Term|Total|"+head_cntr_tpsz_cd;
   			 	var HeadTitle2 = "VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|"+head_cntr_tpsz_cd;

   			 	sheetObj.Redraw = false;
   			 	sheetObj.RemoveAll();
   			 	sheetObj.Reset();
   			 	initSheet(sheetObjects[0],1,HeadTitle);
   			 	initSheet(sheetObjects[1],2,HeadTitle2);
   			 	sheetObj.Redraw = true;                    
               
   			 	//Lease Term
   			 	var sLeaseTermNm = ComGetEtcData(sXml,"lease_term_nm");
   			 	var sLeaseTermCd = ComGetEtcData(sXml,"lease_term_cd");
   			 	
   			 	var arrLeaseTermNm = sLeaseTermNm.split("|");
   			 	var arrLeaseTermCd = sLeaseTermCd.split("|");
   			 	tot_lstm_cd = arrLeaseTermCd;
                  
   			 	with (form.lstm_cd) {
   			 		MultiSelect = true;
   			 		MultiSeparator = ",";
   			 		DropHeight = 320;
   			 		InsertItem(0 , 'ALL','');
   			 		for ( var i=1; i<=arrLeaseTermCd.length; i++) {
   			 			InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
   			 		}
   			 	}                     
      
   			 	break;          
           	case IBSEARCH02:      //조회

           		if(formObj.imdt_ext_flg.checked == false && formObj.plst_flr_flg.checked == false){
                	if ( formObj.slan_cd.value.trim() == '' && formObj.vvd1.value == '' && formObj.vvd2.value == '' && formObj.vvd3.value == '' && formObj.pol_cd.value == '' && formObj.pod_cd.value == '' && formObj.del_cd.value == '' ) {
                		ComShowMessage(msgs["CIM30004"]);
                		return false;
                	}           			
           		}
           		
	            if(!validateForm(sheetObj,formObj,sAction)) return;
   			 	var headTitle2 ="";
   			 	var viewFlag = "";
   			 	if ( formObj.pol_pod_wise[0].checked == true || formObj.pol_pod_wise[2].checked == true || formObj.pol_pod_wise[3].checked == true) {
   			 		headTitle2 = "VVD|POL|ETD\nPOL|POD|ETA\nPOD|Total|"+head_cntr_tpsz_cd;
   			 	} else {
   			 		headTitle2 = "VVD|POD|ETA\nPOD|POL|ETD\nPOL|Total|"+head_cntr_tpsz_cd;
   	   			 	viewFlag ="CHG";
   			 	}

   			 	sheetObj.Redraw = false;
   			 	sheetObj.RemoveAll();
   			 	sheetObj.Reset();
   			 	initSheet(sheetObjects[1],2,headTitle2,viewFlag);
   			 	sheetObj.Redraw = true;                    

	  	        sheetObj.Redraw = false;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 	  	        
   			 	formObj.f_cmd.value = SEARCH02;
   			 	
		        sheetObj.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj));
	  	        
		        ComOpenWait(false); 
                break;
           	case IBSEARCH03:      //조회
         	   	if ( eval(formObj.stay_days.value) >= 60 ) {	//60일 이상시 체크 없이 전체 조회 가능
         	   	} else {
         	   	    if(formObj.imdt_ext_flg.checked == false && formObj.plst_flr_flg.checked == false){
    	            	if ( formObj.slan_cd.value.trim() == '' && formObj.vvd1.value == '' && formObj.vvd2.value == '' && formObj.vvd3.value == '' && formObj.pol_cd.value == '' && formObj.pod_cd.value == '' && formObj.del_cd.value == '' ) {
    	            		ComShowMessage(msgs["CIM30004"]);
    	            		return false;
    	            	}	
         	   	    }
         	   	}
           		
	            if(!validateForm(sheetObj,formObj,sAction)) return;
	            sheetObj.WaitImageVisible=false;
	            ComOpenWait(true); 	  	        
	            
	            // 2010.11.16 이상민 [CHM-201007040-01]
	            // 탭에 따라 CMDT 검색조건의 display를 결정한다
	            // Speed 조건에 체크되면 보다 빠른 그리드를 형성한다
	            view_commodity_click();
	            
   			 	formObj.f_cmd.value = SEARCH03;
	  	        sheetObj.SpeedOption = "NOPROGRESSTICK, NOSTATUS,NOFIT,NOSUM,NOCALC,NOROWHEIGHT, NOMERGEROW, NOTRIM, NOTDTAG, NOCOMBO,NOFORMAT";
	  	        if ( formObj.speed.checked ) {
			        sheetObj.DoSearch4Fx("EES_CIM_0017GS.do",FormQueryString(formObj));
	  	        } else {
			        sheetObj.DoSearch("EES_CIM_0017GS.do",FormQueryString(formObj));
	  	        }
	            ComOpenWait(false);
                break;                
            case IBDOWNEXCEL:      // 입력
				if ( beforetab == 0 || beforetab == 1 ) {	  //첫번째탭에서 조회
	            	if ( sheetObj.rowCount > 1000 ) {
	            		sheetObj.SpeedDown2Excel(true);
	            	} else {
	            		sheetObj.Down2Excel(-1, false, false, true);
	            	}
				} else if ( beforetab == 2 ) {	//두번째 탭에서 조회.
            		sheetObj.SpeedDown2Excel(true);
				}
          	  	break;
        }
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Inventory" , -1 );
					InsertTab( cnt++ , "POL-POD Pair" , -1 );                    
					InsertTab( cnt++ , "CNTR List" , -1 );										
                }
             break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");

    	objs[nItem].style.display = "Inline";
    	objs[beforetab].style.display = "none";

    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	//------------------------------------------------------//
    	beforetab= nItem;
    	
    	/**
    	* 2010.11.16 이상민 [CHM-201007040-01]
    	* 3번탭 CNTR List Click시 search조건 CMDT, Speed 활성화	
    	*/	
		if (nItem ==2){
			show_add_info.style.display = "";
			hide_add_info.style.display = "none";
		}else{
			show_add_info.style.display = "none";
			hide_add_info.style.display = "";
		}
		
    }

    /**
    * Tab 클릭시 이벤트 관련
    * 선택한 탭의 data 조회한다.
    */
    function tab1_OnClick(tabObj , nItem)
    {
    	if ( nItem == 0 ) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     	} else if ( nItem == 1 ) {	//POL-POD Pair탭 클릭시
 			doActionIBSheet(sheetObjects[1],document.form,IBSEARCH02);
     	} else if ( nItem == 2 ) {	//CNTR List탭 클릭시
 			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
     	}   
    }
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	   	if (!ComChkValid(formObj)) return false;
        }
        return true;
    }
    
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
	function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
      	if ( sheetObj.rowCount != 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow; i++){
	     		if( sheetObj.CellValue(i,"division") == 'Total' && sheetObj.CellValue(i,"lstm_cd") == 'Total'){
	     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
	     		} 
	     		if( sheetObj.CellValue(i,"vvd") == 'Total' && sheetObj.CellValue(i,"division") == 'Total' ){
	     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
	     		} 
	     	}
		   	HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   	
		   	for ( var j=0; j<=HeadTitleCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
			}
	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
	     	sheetObj.RowHidden(sheetObj.LastRow-1) = true;
	     	sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
	    	sheetObj.CellValue(sheetObj.LastRow,0) = '';
	    	sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
	    	sheetObj.CellValue(sheetObj.LastRow,2) = '';
	    	sheetObj.CellAlign(sheetObj.LastRow,1) = daCenter;
	    	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 3);
     	}
      	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;
	}

    /**
    * Tab2 조회종료
    * Tab2 조회종료후 이벤트 호출
    */	
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
     	if ( sheetObj.rowCount != 0 ) {
	   		if(document.form.pol_pod_wise[0].checked == false 
		   			&& document.form.pol_pod_wise[1].checked == false){
		   		for(var i=1; i<=sheetObj.LastRow; i++){
		   			if( sheetObj.CellValue(i,3) == 'Total' ){
	     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
		   			} 
		   		}
		   		HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   		for ( var j=0; j<=HeadTitleCnt; j++ ) {
		   			sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
		   		}

		   		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
		   		sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		   		sheetObj.RowHidden(sheetObj.LastRow-2) = true;
		   		sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
		   		sheetObj.CellValue(sheetObj.LastRow,0) = '';
		   		sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
		   		sheetObj.CellValue(sheetObj.LastRow,2) = '';
		   		sheetObj.CellAlign(sheetObj.LastRow,1) = daCenter;
		   		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 3);	    			
	   		} else {
		   		for(var i=1; i<=sheetObj.LastRow; i++){
		   			if( sheetObj.CellValue(i,1) == 'Total' ){
	     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
		   			} 
		   		}
		   		HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   		for ( var j=0; j<=HeadTitleCnt; j++ ) {
		   			sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
		   		}

		   		sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
		   		sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		   		sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
		   		sheetObj.CellValue(sheetObj.LastRow,0) = '';
		   		sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
		   		sheetObj.CellValue(sheetObj.LastRow,2) = '';
		   		sheetObj.CellAlign(sheetObj.LastRow,1) = daCenter;
		   		sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 3);	 
	   		}
	     }

     	sheetObj.SelectHighLight = false;
    	sheetObj.Redraw = true;
	}
	
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t2sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t3sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
    }	    
    
    /**
	* 2010.11.16 이상민 [CHM-201007040-01]
	* view_commodity_click click 이벤트 처리 
	* rep_cmdt_nm, mk_desc 컬럼정보 view or unview	
	*/	
    function view_commodity_click() {
    	if ( document.form.view_commodity.checked ) {
    		sheetObjects[2].ColHidden("rep_cmdt_nm") = false;
    		sheetObjects[2].ColHidden("mk_desc") = false;
    	} else {
    		sheetObjects[2].ColHidden("rep_cmdt_nm") = true;
    		sheetObjects[2].ColHidden("mk_desc") = true;
    	}
    }
    