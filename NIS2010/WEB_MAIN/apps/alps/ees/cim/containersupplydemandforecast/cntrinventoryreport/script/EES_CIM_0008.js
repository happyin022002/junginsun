/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_0008.js
*@FileTitle : Land Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.14 김종준
* 1.0 Creation
* ======================================================
* 2011.03.16 남궁진호 [CHM-201109288-01]Location Code 숫자입력가능하게수정
*                    ComKeyOnlyAlphabet('upper') ->ComKeyOnlyAlphabet('uppernum')
* 2011.03.30 신자영 [CHM-201109821-01] [CIM] Inventory Stataus>Land Inventory의 Location 조회조건 추가
* 2011.11.21 신자영 [CHM-201114598-01] [CIM] INVENTORY 모듈상의 지역검색 기능 보완
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_0008 : ees_cim_0008 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_cim_0008() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
    // 공통전역변수
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
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
    
    
    var detailLoc = '1';
    
    var param = '';
    
    var dSearchFlg = 'N';
    var dLocTpCd = '';
    var dLocCd = '';
    var dTpSz = '';
    var dCnmvCd = '';
    var dLstmCd = '';
    var dFullFlg = '';
    var dDMgFlg = '';
    var dSocCd = '';
    var dCntrprefix = '';
    var dCntrHngrRckCd = '';
    var dDispFlg = '';
    var dD2PayldFlg = '';
    var dCntrYdCd = '';
    var dCodeFlg = '';
    
    var dSubTpSz = '';
    var dSubCnmvCd = '';
    var dSusLoc = '';
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

   	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
   	function processButtonClick(){
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	    var sheetObject1 = sheetObjects[0];
	    var sheetObject2 = sheetObjects[1];
	    var sheetObject3 = sheetObjects[2];	        
	    var sheetObject3 = sheetObjects[3];
	
	    /*******************************************************/
	    var formObject = document.form;
	
		try {
	   		var srcName = window.event.srcElement.getAttribute("name");
	
            switch(srcName) {

			case "btn_New":		//조회조건 초기화
				comboObjects[0].Code = "";
				comboObjects[1].Code = "";
				comboObjects[2].Code = "";
				formObject.loc_type_code.value="1";
				formObject.loc_cd.value="";
				loc_type_code_onchange();
				formObject.full_flg.value = '';
				formObject.dmg_flg.value = '';
				formObject.soc_cd.value = '1';
				formObject.cntr_hngr_rck_cd.checked = false;
				formObject.disp_flg.checked = false;
				formObject.d2_payld_flg.checked = false;
				formObject.cntr_no.value = '';
				
				sheetObjects[0].Redraw = false;
				sheetObjects[0].RemoveAll();
				sheetObjects[0].Redraw = true;

				sheetObjects[1].Redraw = false;
				sheetObjects[1].RemoveAll();
				sheetObjects[1].Redraw = true;

				sheetObjects[2].Redraw = false;
				sheetObjects[2].RemoveAll();
				sheetObjects[2].Redraw = true;

				break;
			case "btn_loc_cd":	//Location 조회 팝업
    	        var cnt_cd = "";
    	        var loc_cd = "";
	            cnt_cd = formObject.loc_type_code.value;
	            loc_cd = formObject.loc_cd.value;
	            if ( formObject.loc_type_code.value != '1' && formObject.loc_type_code.value != '2') {	
        			var loc_code = "";
                    // 2011.03.30 신자영 [CHM-201109821-01] [CIM] Inventory Stataus>Land Inventory의 Location 조회조건 추가
        			// case추가 - RCC (by ECC)
        			if ( form.loc_type_code.value == "3" ) {
        				loc_code = "rcc_cd";
        			} else if ( form.loc_type_code.value == "4" ) {
        				loc_code = "lcc_cd";
        			} else if ( form.loc_type_code.value == "5" ) {
        				loc_code = "lcc_cd";
        			} else if ( form.loc_type_code.value == "6" ) {
        				loc_code = "ecc_cd";
        			} else if ( form.loc_type_code.value == "7" ) {
        				loc_code = "scc_cd";
        			} else if ( form.loc_type_code.value == "8" ) { 
        				loc_code = "rcc_cd";
        			}
					var param = "?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
					ComOpenPopupWithTarget('/hanjin/COM_ENS_051.do', 1000, 460, loc_code+":loc_cd", "0,1,1,1,1,1", true);
	            }
				break;
				
			case "btn_DownExcel":	//DOWN EXCEL
				if ( beforetab == 0 ) {	  //첫번째탭에서 조회
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
				} else if ( beforetab == 2 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
				}
				break;
			case "btn_Retrieve":	//조회
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();

				if ( beforetab == 0 ) {	  //첫번째 탭에서 조회
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 조회.
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
				} else if ( beforetab == 2 ) {	//세번째 탭에서 조회.
					doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
				}
				break;
			case "btn_detail1":	//조회
				
				if('Y' == dSearchFlg){
					detailPop();
				}
				break;
			case "btn_detail2":	//조회
				
				if('Y' == dSearchFlg){
					detailPop();
				}
				break;	
			case "btn_detail3":	//조회
				
				if('Y' == dSearchFlg){
					detailPop();
				}
				break;		
			case "btn_Print":		//Print
				if ( beforetab == 0 ) {	  //첫번째 탭에서 Print
					setSheetPrintCopyObject(sheetObjects[0],2);
				} else if ( beforetab == 1 ) {	//두번째 탭에서 Print.
					setSheetPrintCopyObject(sheetObjects[1],1);
				} else if ( beforetab == 2 ) {	//세번째 탭에서 Print.
					setSheetPrintCopyObject(sheetObjects[2],3);
				}
				break;
			//2011.11.21 신자영 [CHM-201114598-01] Yard Inquiry 버튼 추가
			case "btn_Yard":		//Yard Inquiry
            dispaly = "1,0,1,1,1,1,1,1,1,1,1,1"; // com_ens_051_dispaly.value;
            con_cd_val = ""
            // sheetObject.CellValue(sheetObject.SelectRow, "yd_cd");
            classId = "ESD_PRD_0002";
            param = '?classId=' + classId + '&yard_code=' + con_cd_val;
         
            winObject = window
                    .open("/hanjin/ESD_PRD_0002.do" + param, "한진해운PI", "height=770, width=1000, top=0");

            break;
           } // end switch
   		} catch(e) {
   			if( e == "[object Error]") {
   				ComShowMessage(OBJECT_ERROR);
   			} else {
   				ComShowMessage(e);
   			}
   		}
   	}
   	
    /**
     * 프린트 sheet1의 필터링 시킨다.
     * level =1인 데이타만 필터링 시킨다.
     */
    function setSheetPrintCopyObject(sheetObj,cnt){
    	if ( sheetObj.rowCount != 0 ) {
			var formObject = document.form;
			if ( formObject.loc_type_code.value == "1" ) {
				str_loc_nm = "RCC";
 			} else if ( formObject.loc_type_code.value == "2" ) {
 				str_loc_nm = "Country";
 			} else if ( formObject.loc_type_code.value == "3" ) {
 				str_loc_nm = "LCC";
 			} else if ( formObject.loc_type_code.value == "4" ) {
 				str_loc_nm = "ECC";
 			} else if ( formObject.loc_type_code.value == "5" ) {
 				str_loc_nm = "SCC";
 			} else if ( formObject.loc_type_code.value == "6" ) {
 				str_loc_nm = "SCC";
 			} else if ( formObject.loc_type_code.value == "7" ) {
 				str_loc_nm = "Yard";
 			}
			var HeadTitle = "";
			if (cnt == 1) {
				HeadTitle = str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
			} else if ( cnt ==2 ) {
				HeadTitle = str_loc_nm+"|MVMT|"+head_cntr_tpsz_cd;
			} else if ( cnt ==3 ) {
				HeadTitle = str_loc_nm+"|Term|"+head_cntr_tpsz_cd;
			}
            headTitle = HeadTitle;
	    	if (cnt == 1) {
		   		sheetObjects[3].RemoveAll();
	            sheetObjects[3].Redraw = false;
	            initSheet(sheetObjects[3],4,HeadTitle);
	            sheetObjects[3].Redraw = true;
		    	for ( var i=0; i<=sheetObj.LastRow; i++) {
		    		var level = sheetObj.CellValue(i, "lvl0");
		    		if ( formObject.loc_type_code.value=='2') {
		    			level = '0';
		    		} else {
		    			level = '1';
		    		}
		    		if ( sheetObj.CellValue(i, "lvl0") == level || sheetObj.CellValue(i, "loc_cd").toUpperCase() =='TOTAL' ) {
		    			var Row = sheetObjects[3].DataInsert();
		    			for ( var j=0; j<HeadTitle.split("|").length; j++ ) {
		    				sheetObjects[3].CellValue2(Row,j) =  sheetObj.CellValue(i, j);
		    			}
		    		}
		    	}
	    	}
			ComOpenPopupWithTarget('/hanjin/EES_CIM_0908.do', 775, 750, "", "0,1,1,1,1,1,1", true);
		} else {
			ComShowMessage(msgs["CIM30008"]);	//No data found
			return;
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
    * 초기 이벤트 등록
    */
    function initControl() {
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code', '');		//Location by 변경시 이벤트 처리
    	axon_event.addListener('keyup', 'cntr_no_onkeyUp', 'cntr_no', '');						//cntr_no keyup 이벤트 처리
    	axon_event.addListener('keyup', 'loc_cd_onkeyUp', 'loc_cd', '');						//LOC_CD keyup 이벤트 처리
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerFormat('keypress', 'obj_keypress'  , form);						//알파벳 대문자,숫자만 입력허용
    	axon_event.addListenerFormat('blur', 'obj_blur', form);
    	axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 					//form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
    	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 				//form OnBeforeDeactivate이벤트에 코드 처리

    }
    /**
     * Period FM  beforeactivate 이벤트 처리
     * Period FM  beforeactivate -없애기
     */    
 	function obj_activate() {
 		ComClearSeparator(event.srcElement);
 	}
 	
     /**
 	* Period to  beforedeactivate 이벤트 처리
 	* Period to  beforedeactivate YYYY-MM 포멧 처리
 	*/	
 	function obj_deactivate() {
 		ComAddSeparator(event.srcElement);
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
     * MVMT Status  클릭 이벤트 등록
     */
    function cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
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
	 * Location  blur 이벤트 처리
	 * Location  blur 코드 적합성 체크
	 */	
	function obj_blur() {
		switch (event.srcElement.name) {
			case "loc_cd":
				if ( document.form.loc_cd.value !='') {
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH04);
				}
				break;
		}
	}
	
    /**
     * 키이벤트 목록
     */
	function obj_keypress() {
		var formObject = document.form;
		switch (event.srcElement.name) {
			case "loc_cd":
				ComKeyOnlyAlphabet('uppernum');// 알파벳 대문자,숫자만 입력허용
				break;
		}
	}
    
    /**
    * LOC_CD keyup 이벤트 처리
    * LOC_CD keyup시 대분자로 처리
    */
    function loc_cd_onkeyUp() {
        var formObject = document.form;
        if ( event.keyCode != 37 && event.keyCode != 38 && event.keyCode != 39 && event.keyCode != 40 ) {
	        if ( formObject.loc_type_code.value == '2' ) {
	            if ( formObject.loc_cd.value.length > 1) {
	        	    document.getElementById("loc_cd").setAttribute("maxLength",2);
	        	    formObject.loc_cd.value = formObject.loc_cd.value.substring(0,2).toUpperCase();
	            }
	        } else {
	            document.getElementById("loc_cd").setAttribute("maxLength",5);
	     	   if ( formObject.loc_cd.value.length == 5 ) {
	    		   ComSetFocus(document.form.focus_loc_cd);
	    	   }
	        }
        }
    }
    
    /**
    * Location by 변경시 이벤트 처리
    * ALL (by RCC) 선택시, 입력창은 비활성화 처리 
    * 나머지 활성화
    */
    function loc_type_code_onchange() {
        var formObject = document.form;
        if ( formObject.loc_type_code.value == '1' || formObject.loc_type_code.value == '2') {
            formObject.loc_cd.readOnly = true;
            formObject.loc_cd.className = "input2";
            formObject.loc_cd.value = "";
        } else {
            formObject.loc_cd.readOnly = false;
            formObject.loc_cd.className = "input";
        }
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage( cnmv_sts_cd, cnmv_sts_nm) {
       
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
        
        initControl();
        makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
        
        var formObj = document.form;
        var eqr_loc_type_code = formObj.eqr_loc_type_code.value;
        var eqr_loc_cd = formObj.eqr_loc_cd.value;
        
        if(eqr_loc_type_code != "" && eqr_loc_type_code != null && eqr_loc_type_code != "null"){
        	formObj.loc_type_code.value = eqr_loc_type_code;
        	formObj.loc_cd.value = eqr_loc_cd;
        	formObj.location.value = eqr_loc_cd;
        	formObj.full_flg.value = "N";
        	formObj.cnmv_sts_cd.Code = "MT";
        	
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
        }
    }
    
    //MVMT Status 생성
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
    	
        //MVMT Status
        var arr_cnmv_sts_cd = cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm = cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd = arr_cnmv_sts_cd;
        with (form.cnmv_sts_cd) {
        	MultiSelect = true;
            MultiSeparator = ",";
            DropHeight = 320;
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    
    
    function t1sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //TP/SZ,MVMT Status,Lease Term 데이타 가져오기
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
     * Location by loc_cd 팝업에서 선택한 값 Setting.
    */
    function popupFinish(aryPopupData, row, col, sheetIdx){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        formObject.loc_cd.value = aryPopupData[0][3] 
    }
    
    /**
    * 시트 초기설정값, 헤더 정의
    * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    */
    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt = 0;
        
         var locCode = document.form.loc_type_code.value;
        
        switch(sheetNo) {
        case 1:      //t1sheet1 init
            with (sheetObj) {
    		// 높이 설정
            style.height = 350;
     
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     
            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;
     
           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
     
            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 10, 100);
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, true, true, false,false)

            
            if (headTitle==null || headTitle =="") {
         	   headTitle = "RCC|MVMT|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
         	   InitColumnInfo(25, 0, 0, true);
            }
            
            headTitle = headTitle+"|ydnm";
            
            var headCnt  = headTitle.split("|").length;
            SheetWidth = (headCnt)*50+30;
            if ( SheetWidth>975 ) {
         	   SheetWidth = 975;
            }
            InitColumnInfo(headCnt, 0, 0, true);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, headTitle, true);
            sheetObj.FrozenCols = 3;

            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtAutoSum,      130,   daCenterTop,	true,		"loc_cd",		false,  "",      dfNone,			0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,      	60,    daCenterTop,	true,		"division",		false,  "",      dfNone,			0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,   		60,    daRight,		true,		"total_cnt",	false,  "",      dfNullInteger,		0,     true,       true);
            for(var i=1 ; i <= headCnt - 4 ; i++){
         	   InitDataProperty(0, cnt++ , dtData,  	60,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		0,     true,       true);
            }
            InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	"yd_nm",				false,	"",			dfNone,			0);
            
            CountPosition = 0;	//페이지카운트 없애기 
           }
           break;
        case 2:      //t2sheet1 init
            with (sheetObj) {
            // 높이 설정
            style.height = 350;
            //전체 너비 설정
            SheetWidth = mainTable.clientWidth;
     
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     
            //전체Merge 종류 [선택, Default msNone]
            MergeSheet = msPrevColumnMerge;
     
           //전체Edit 허용 여부 [선택, Default false]
            Editable = false;
     
            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
            InitRowInfo(1, 1, 10, 100);
            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, true, true, false,false)
            if (headTitle==null || headTitle =="") {
         	   headTitle = "RCC|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
            }
            
            headTitle = headTitle+"|ydnm";
            var headCnt  = headTitle.split("|").length;
            var headTitles  = headTitle.split("|");
            InitColumnInfo(headCnt+1, 0, 0, true);
            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, headTitle, true);
            sheetObj.FrozenCols = 2;
     
            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtAutoSum,      150,   daLeft,		true,		"loc_cd",		false,  "",      dfNone,			0,     true,       true);
            InitDataProperty(0, cnt++ , dtData,   		60,    daRight,		true,		"total_cnt",	false,  "",      dfNullInteger,		0,     true,       true);
            for(var i=1 ; i <= headCnt - 3 ; i++){
         	   InitDataProperty(0, cnt++ , dtData,  	60,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		0,     true,       true);
            }
            InitDataProperty(0, cnt++ , dtHidden,      100,    daLeft,		true,		"lvl0",			false,  "",      dfNone,			0,     true,       true);
            InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	    "yd_nm",	    false,	"",		 dfNone,			0);
            InitTreeInfo(0, "sLevel", RgbColor(0,0,255), false);
            CountPosition = 0;	//페이지카운트 없애기
           }
           break;
        case 3:      //t3sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 350;
         
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;
         
               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
         
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false)
         
                if (headTitle==null || headTitle =="") {
             	   headTitle = "RCC|Term|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
             	   InitColumnInfo(24, 0, 0, true);
                }
                headTitle = headTitle+"|ydnm";
                var headCnt  = headTitle.split("|").length;
                SheetWidth = (headCnt)*50+30;
                if ( SheetWidth>975 ) {
             	   SheetWidth = 975;
                }
                InitColumnInfo(headCnt, 0, 0, true);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, headTitle, true);
                sheetObj.FrozenCols = 3;
         
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtAutoSum,      130,   daCenterTop,	true,		"loc_cd",		false,  "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,      	60,    daCenterTop,	true,		"division",		false,  "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   		60,     daRight,	true,		"total_cnt",	false,  "",      dfNullInteger,		0,     true,       true);
                for(var i=1 ; i <= headCnt - 4 ; i++){
             	   InitDataProperty(0, cnt++ , dtData,  	60,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		0,     true,       true);
                }
                InitDataProperty(0, cnt++ , dtHidden,		100,	daCenter,	true,	    "yd_nm",	    false,	"",		 dfNone,			0);
                CountPosition = 0;	//페이지카운트 없애기
           }
           break;    
        case 4:      //t4sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 280;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;
         
                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
         
                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge;
         
               //전체Edit 허용 여부 [선택, Default false]
                Editable = false;
         
                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo(1, 1, 10, 100);
                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(false, true, true, true, false,false)
                if (headTitle==null || headTitle =="") {
             	   headTitle = "RCC|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5|R7|P2|P4|T2|T4";
                }
                var headCnt  = headTitle.split("|").length;
                var headTitles  = headTitle.split("|");
                InitColumnInfo(headCnt, 0, 0, true);
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, headTitle, true);
         
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtData,      130,    daLeft,		true,		"loc_cd",		false,  "",      dfNone,			0,     true,       true);
                InitDataProperty(0, cnt++ , dtData,   		60,    daRight,		true,		"total_cnt",	false,  "",      dfNullInteger,		0,     true,       true);
                sheetObj.FrozenCols = 2;
                for(var i=1 ; i <= headCnt - 2 ; i++){
             	   InitDataProperty(0, cnt++ , dtData,  	60,    daRight,		true,		"qty"+i,		false,  "",      dfNullInteger,		0,     true,       true);
                }
                CountPosition = 0;	//페이지카운트 없애기
           }
           break;           
       }
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, cnmv_sts_cd , cnmv_sts_nm) {
//       sheetObj.ShowDebugMsg = false;
       switch(sAction) {
         case IBSEARCH:      //조회
        	if(!validateForm(sheetObj,formObj,sAction)) return;
        	
        	sheetObj.WaitImageVisible = false;
        	setHeaderValue(sheetObj,2);	//타이틀 해더 세팅
        	sheetObj.RemoveAll();
        	sheetObj.Redraw = false;

        	sheetObj.WaitImageVisible=false;
        	ComOpenWait(true);         	
        	
        	formObj.f_cmd.value = SEARCH; 
            sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj));
            ComOpenWait(false);
            break;
         case IBSEARCH01:      //공통조회
             sheetObj.WaitImageVisible = false;
             form.f_cmd.value = SEARCH01;
             var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do" , FormQueryString(form));
             
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
 			 if ( form.loc_type_code.value == "1" ) {
 				 str_loc_nm = "RCC";
 			 } else if ( form.loc_type_code.value == "2" ) {
 				 str_loc_nm = "Country";
 			 } else if ( form.loc_type_code.value == "3" ) {
 				 str_loc_nm = "LCC";
 			 } else if ( form.loc_type_code.value == "4" ) {
 				 str_loc_nm = "ECC";
 			 } else if ( form.loc_type_code.value == "5" ) {
 				 str_loc_nm = "SCC";
 			 } else if ( form.loc_type_code.value == "6" ) {
 				 str_loc_nm = "SCC";
 			 } else if ( form.loc_type_code.value == "7" ) {
 				 str_loc_nm = "Yard";
 			 }

             var HeadTitle = str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
             var HeadTitle2 = str_loc_nm+"|MVMT|Total|"+head_cntr_tpsz_cd;
             var HeadTitle3 = str_loc_nm+"|Term|Total|"+head_cntr_tpsz_cd;
             
             sheetObj.Redraw = false;
             sheetObj.RemoveAll();
             sheetObj.Reset();
             initSheet(sheetObjects[1],2,HeadTitle);
             initSheet(sheetObjects[2],3,HeadTitle3);
             initSheet(sheetObjects[0],1,HeadTitle2);
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
         	if(!validateForm(sheetObj,formObj,sAction)) return;
         	setHeaderValue(sheetObj,1);	//타이틀 해더 세팅
         	sheetObj.RemoveAll();
         	sheetObj.Redraw = false;
            formObj.f_cmd.value = SEARCH02;

        	sheetObj.WaitImageVisible=false;
        	ComOpenWait(true);         	

            formObj.view_flg.value = "MVMT";
            
            sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj));
            ComOpenWait(false);
            break;
         case IBSEARCH03:      //조회
         	if(!validateForm(sheetObj,formObj,sAction)) return;
         	setHeaderValue(sheetObj,3);	//타이틀 해더 세팅
         	sheetObj.Redraw = false;

        	sheetObj.WaitImageVisible=false;
        	ComOpenWait(true);         	

            formObj.view_flg.value = "LEASE";
            formObj.f_cmd.value = SEARCH03;
            sheetObj.DoSearch("EES_CIM_0008GS.do",FormQueryString(formObj));
            ComOpenWait(false);
            break;
		case IBSEARCH04: //location focusOut
			var inquiryLevel = "";
			if ( formObj.loc_type_code.value == 1 ) {
				inquiryLevel = "R";
			} else if ( formObj.loc_type_code.value == 2 ) {
				inquiryLevel = "C";
			} else if  ( formObj.loc_type_code.value == 3 ) {
				inquiryLevel = "R";
			} else if  ( formObj.loc_type_code.value == 4 ) {
				inquiryLevel = "L";
			} else if  ( formObj.loc_type_code.value == 5 ) {
				inquiryLevel = "L";
			} else if  ( formObj.loc_type_code.value == 6 ) {
				inquiryLevel = "E";
			} else if  ( formObj.loc_type_code.value == 7 ) {
				inquiryLevel = "S";
			}
			formObj.inquiryLevel.value = inquiryLevel;
			formObj.location.value = formObj.loc_cd.value;
			
			formObj.f_cmd.value = SEARCH04;
			if (formObj.loc_cd.value == "") {
				return false;
			}
			sheetObj.WaitImageVisible = false;
			var sXml = sheetObj.GetSearchXml("EES_CIM_0008GS.do",FormQueryString(formObj));
			var sCheck = ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				if (document.form.loc_cd.value != "") {
					ComShowCodeMessage("CIM29013");
					document.form.loc_cd.value = "";
					ComSetFocus(document.form.loc_cd);
					return false;
				} else {
					return true;
				}
			} else {
				ComSetFocus(document.form.lstm_cd);
			}
	
			break;        
          case IBDOWNEXCEL:      // 입력
        	  sheetObj.Down2Excel(-1, false, false, true);
             break;
       }
    }
    
    /**
     * 타이틀 해더 세팅
     */    
    function setHeaderValue(sheetObj,cnt) {
    	var str_loc_nm = "";
		if ( document.form.loc_type_code.value == "1" ) {
			str_loc_nm = "RCC";
		} else if ( document.form.loc_type_code.value == "2" ) {
			str_loc_nm = "Country";
		} else if ( document.form.loc_type_code.value == "3" ) {
			str_loc_nm = "LCC";
		} else if ( document.form.loc_type_code.value == "4" ) {
			str_loc_nm = "ECC";
		} else if ( document.form.loc_type_code.value == "5" ) {
			str_loc_nm = "SCC";
		} else if ( document.form.loc_type_code.value == "6" ) {
			str_loc_nm = "SCC";
		} else if ( document.form.loc_type_code.value == "7" ) {
			str_loc_nm = "Yard";
		}
        var HeadTitle = str_loc_nm+"|Total|"+head_cntr_tpsz_cd;
        var HeadTitle2 = str_loc_nm+"|MVMT|Total|"+head_cntr_tpsz_cd;
        var HeadTitle3 = str_loc_nm+"|Term|Total|"+head_cntr_tpsz_cd;
        if ( cnt ==2 ) {
            initSheet(sheetObj,cnt,HeadTitle);
        } else if ( cnt ==1 ) {
            initSheet(sheetObj,cnt,HeadTitle2);
        } else if ( cnt ==2 ) {
            initSheet(sheetObj,cnt,HeadTitle3);
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
                   InsertTab( cnt++ , "By MVMT" , -1 );                    
                   InsertTab( cnt++ , "By Location" , -1 );
                   InsertTab( cnt++ , "By Lease Term" , -1 );										
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
    }
    
    /**
     * print 파리미터 세팅
     */
    function setPrintParmValues() {
	   	document.form.prt_loc_type_code.value = document.getElementById("loc_type_code").options[document.getElementById("loc_type_code").selectedIndex].text;
	   	document.form.prt_loc_cd.value = document.form.loc_cd.value;
	   	document.form.prt_cntr_tpsz_cd.value = comboObjects[1].Code; 
	   	document.form.prt_full_flg.value = document.form.full_flg.value;
	   	if ( document.form.cntr_hngr_rck_cd.checked ) {
		   	document.form.prt_cntr_hngr_rck_cd.value = "Y"; 
	   	} else {
		   	document.form.prt_cntr_hngr_rck_cd.value = ""; 
	   	}
	   	if ( document.form.disp_flg.checked ) {
		   	document.form.prt_disp_flg.value = "Y"; 
	   	} else {
		   	document.form.prt_disp_flg.value = ""; 
	   	}
	   	if ( document.form.d2_payld_flg.checked ) {
		   	document.form.prt_d2_payld_flg.value = "Y"; 
	   	} else {
		   	document.form.prt_d2_payld_flg.value = ""; 
	   	}
	   	document.form.prt_cnmv_sts_cd.value = comboObjects[2].Code; 
	   	document.form.prt_dmg_flg.value = document.form.dmg_flg.value; 
	   	document.form.prt_cntr_no.value = document.form.cntr_no.value; 
	   	document.form.prt_cntr_use_co_cd.value = document.form.tem_cntr_use_co_cd.value; 
	   	document.form.prt_lstm_cd.value = comboObjects[0].Code; 
	   	document.form.prt_soc_cd.value = document.form.soc_cd.value;
    }
    /**
     * Tab1 조회종료
     * Tab1 조회종료후 이벤트 호출
     */
     function t2sheet1_OnSearchEnd(sheetObj, msg){
     	for(var i=1; i<=sheetObj.LastRow; i++){
     		if(sheetObj.CellValue(i,0).toUpperCase() == 'TOTAL'){
     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(192,192,192);
     		}
     	}
     	if ( sheetObj.rowCount != 0 ) {
 	    	HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+2
 		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
 				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
 			}
 	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
 	    	sheetObj.RowDelete(sheetObj.LastRow-1, false);
     	}
     	sheetObj.SelectHighLight = false;
     	sheetObj.Redraw = true;
     	setPrintParmValues();	//print 파리미터 세팅
     	detailClear();
     	detailSetting();
     }    
    /**
     * Tab2 조회종료
     * Tab2 조회종료후 이벤트 호출
     */
     function t1sheet1_OnSearchEnd(sheetObj, msg){
      	if ( sheetObj.rowCount != 0 ) {
	     	for(var i=1; i<=sheetObj.LastRow; i++){
	     		if( sheetObj.CellValue(i,0) == '' ){
	     			sheetObj.CellValue(i,0) = 'Total';
	     		} else if (  sheetObj.CellValue(i,0) != '' && sheetObj.CellValue(i,1) == '' ){
	     			sheetObj.CellValue(i,1) = 'Total';
	     			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
	     		} 
	     	}
		   	HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
			}
	    	sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
	     	sheetObj.RowHidden(sheetObj.LastRow-1) = true;
	     	sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
	     	sheetObj.CellValue(sheetObj.LastRow-1,1) = 'G.Total';
	    	sheetObj.CellValue(sheetObj.LastRow,0) = '';
	    	sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
	    	sheetObj.CellValue(sheetObj.LastRow,1) = 'G.Total';
	    	sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 2);
	    	sheetObj.SelectHighLight = false;
	     	setPrintParmValues();	//print 파리미터 세팅
	     	detailClear();
	     	detailSetting();
     	}
    	sheetObj.Redraw = true;
     }

     /**
      * Tab3 조회종료
      * Tab3 조회종료후 이벤트 호출
      */
	function t3sheet1_OnSearchEnd(sheetObj, msg){
		if ( sheetObj.rowCount != 0 ) {
		 	for(var i=1; i<=sheetObj.LastRow; i++){
		 		if( sheetObj.CellValue(i,0) == '' ){
		 			sheetObj.CellValue(i,0) = 'Total';
		 		} else if (  sheetObj.CellValue(i,0) != '' && sheetObj.CellValue(i,1) == '' ){
		 			sheetObj.CellValue(i,1) = 'Total';
		 			sheetObj.RowBackColor(i) = sheetObj.RgbColor(201, 213, 235);
		 		} 
		 	}
		   	HeadTitleCnt = head_cntr_tpsz_cd.split("|").length+3
		   	for ( var j=0; j<HeadTitleCnt; j++ ) {
				sheetObj.CellValue2(sheetObj.LastRow,j) =  sheetObj.CellValue(sheetObj.LastRow-1, j);
			}
			sheetObj.RowBackColor(sheetObj.LastRow) = sheetObj.RgbColor(247,225,236);
		 	sheetObj.RowHidden(sheetObj.LastRow-1) = true;
		 	sheetObj.CellValue(sheetObj.LastRow-1,0) = 'G.Total';
		 	sheetObj.CellValue(sheetObj.LastRow-1,1) = 'G.Total';
			sheetObj.CellValue(sheetObj.LastRow,0) = '';
			sheetObj.CellValue(sheetObj.LastRow,0) = 'G.Total';
			sheetObj.CellValue(sheetObj.LastRow,1) = 'G.Total';
			sheetObj.SetMergeCell (sheetObj.LastRow, 0, 0, 2);
			sheetObj.SelectHighLight = false;
		 	setPrintParmValues();	//print 파리미터 세팅
		 	detailClear();
		 	detailSetting();
		}
		sheetObj.Redraw = true;
     }
     
     /**
    * Tab 클릭시 이벤트 관련
    * 선택한 탭의 data 조회한다.
    */
    function tab1_OnClick(tabObj , nItem)
    {
       if ( nItem == 0 ) {
		    doActionIBSheet(sheetObjects[0],document.form,IBSEARCH02);
       } else if ( nItem == 1 ) {	//By MVMT 탭 클릭시
		   doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
       } else if ( nItem == 2 ) {	//By Lease Term탭 클릭시
		   doActionIBSheet(sheetObjects[2],document.form,IBSEARCH03);
       }
    }
    
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
    function validateForm(sheetObj,formObj,sAction){
	   	with(formObj){
		  	var formObject = document.form;
	
		  	if ( doActionIBSheet(sheetObj, document.form, IBSEARCH04) ) {	//Location 유효성체크
		  		ComSetFocus(formObject.loc_cd);
	 	        return false;
	 	    } else {
	 	    	if(formObj.loc_type_code.value != "1" && formObj.loc_type_code.value != "2" && formObj.loc_cd.value == "") {
	    	  		ComShowMessage(msgs["CIM30002"]);	//Location Input is Mandatory.
	    	  		formObject.loc_cd.focus();
	    	  		return false;
	    	  	}
	    	  	if (!ComChkValid(formObj)) return false;
	    	  	
	    	  	return true;
	 	    }
		}
		return true;       
    }
       
    function detailSetting(){

    	dSearchFlg = 'Y';
        detailLoc = document.form.loc_type_code.value;
        dLocCd = document.form.loc_cd.value;
        dTpSz = document.form.prt_cntr_tpsz_cd.value;
        dCnmvCd = document.form.prt_cnmv_sts_cd.value;
        dLstmCd = document.form.prt_lstm_cd.value;
        dFullFlg = document.form.full_flg.value;
        dDMgFlg = document.form.dmg_flg.value;
        dSocCd = document.form.soc_cd.value;
        dCntrprefix = document.form.cntr_no.value;
        dCntrHngrRckCd = '';
        dDispFlg = '';
        dD2PayldFlg = '';
        
        if('true' == document.form.cntr_hngr_rck_cd.checked){
        	dCntrHngrRckCd = 'Y';
        }else{
        	dCntrHngrRckCd = '';
        }
        
        if('true' == document.form.disp_flg.checked){
        	dDispFlg = 'Y';
        }else{
        	dDispFlg = '';
        }
        
        if('true' == document.form.d2_payld_flg.checked){
        	dD2PayldFlg = 'Y';
        }else{
        	dD2PayldFlg = '';
        }
        
        if(detailLoc == '1'){
     	   dLocTpCd = '';
        }else if(detailLoc == '3'){
     	   dLocTpCd = '1';
        }else if(detailLoc == '8'){
     	   dLocTpCd = '7';
        }else if(detailLoc == '4'){
     	   dLocTpCd = '2';
        }else if(detailLoc == '5'){
     	   dLocTpCd = '3';
        }else if(detailLoc == '6'){
     	   dLocTpCd = '4';
        }else if(detailLoc == '7'){
     	   dLocTpCd = '5';
        }else if(detailLoc == '2'){
      	   dLocTpCd = '9';
        }
    }
    
    function detailPop(){
    	    	
    	if(dLocTpCd == '9'){
    		dLocTpCd == '';
    	}

  	   param = "?loc_type_code="+dLocTpCd
  	   +"&loc_cd="+dLocCd
  	   +"&cntr_tpsz_cd="+dTpSz
  	   +"&dmg_flg="+dDMgFlg
  	   +"&cntr_use_co_cd=H"
  	   +"&over_stay_days=0"
  	   +"&cnmv_sts_cd="+dCnmvCd
  	   +"&uclm_ls_div_cd=I"
  	   +"&full_flg="+dFullFlg
  	   +"&lstm_cd="+dLstmCd
  	   +"&soc_cd="+dSocCd
  	   +"&sub_cntr_tpsz_cd="+dSubTpSz
  	   +"&sub_loc_cd="+dSusLoc
  	   +"&sub_cnmv_sts_cd="+dSubCnmvCd
  	   +"&ofc_cd="
  	   +"&titleFlag=Summary"
       +"&cntrprefix="+dCntrprefix 
       +"&cntr_hngr_rck_cd="+dCntrHngrRckCd
       +"&disp_flg="+dDispFlg
       +"&d2_payld_flg="+dD2PayldFlg
       +"&cntr_yd_cd="+dCntrYdCd
       +"&code_flg="+dCodeFlg;
  	   
   	       	
       ComOpenPopup("/hanjin/EES_CIM_0044.do"+param,900, 455, "", "1,0,1,1,1,1,1,1", true);    	
    }
    
    function detailClear(){
         dSearchFlg = 'N';
         dLocTpCd = '';
         dLocCd = '';
         dTpSz = '';
         dCnmvCd = '';
         dLstmCd = '';
         dFullFlg = '';
         dDMgFlg = '';
         dSocCd = '';
         dCntrprefix = '';
         dCntrHngrRckCd = '';
         dDispFlg = '';
         dD2PayldFlg = '';
         dCntrYdCd = '';
         dCodeFlg = '';
        
         dSubTpSz = '';
         dSubCnmvCd = '';
         dSusLoc = '';
    }
   
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t1sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
     	       
     	dSusLoc = sheetObj.CellValue(row,"loc_cd");
     	dSubTpSz = dTpSz;

     	if(col == '0'){
     		
     		if(dLocTpCd == '9'){
     			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
     			dSusLoc = '';
     		}else{
     			dSusLoc = sheetObj.CellValue(row,"loc_cd");
     			dCntrYdCd = '';
     		}
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     		dSubTpSz = dTpSz;
     		dSubCnmvCd = '';
     	}else if(col == '1' || col == '2'){
     		dSubTpSz = dTpSz;
     		if('Total' == sheetObj.CellValue(row,"division")){
     			
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
         		
     			dSubCnmvCd = '';
     		}else{
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		} 
         		
         		dSubCnmvCd = sheetObj.CellValue(row,"division");
     		}
     		
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     		
     	}else{
     		if(dLocTpCd == '9'){
     			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
     			dSusLoc = '';
     		}else{
     			dSusLoc = sheetObj.CellValue(row,"loc_cd");
     			dCntrYdCd = '';
     		}
     		
     		if('Total' == sheetObj.CellValue(row,"division")){
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
     			dSubCnmvCd = '';
     		}else{
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
     			dSubCnmvCd = sheetObj.CellValue(row,"division");
     		}
     		
     		dSubTpSz = sheetObj.CellValue(0,col);
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     	}
    }	
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t2sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
     	dSusLoc = sheetObj.CellValue(row,"loc_cd");
     	dSubTpSz = dTpSz;
     	dCodeFlg = dSusLoc.substring(5,8);

     	if('(R)' == dCodeFlg){
     		dSusLoc = dSusLoc.substring(0,5);
     		dCodeFlg = 'R';
     	}else if('(L)' == dCodeFlg){
     		dSusLoc = dSusLoc.substring(0,5);
     		dCodeFlg = 'L';
     	}else if('(E)' == dCodeFlg){
     		dSusLoc = dSusLoc.substring(0,5);
     		dCodeFlg = 'E';
     	}else if('(S)' == dCodeFlg){
     		dSusLoc = dSusLoc.substring(0,5);
     		dCodeFlg = 'S';
     	}else{
     		dCodeFlg = 'Y';
     	}

 		if(col == '0' || col == '1'){
 			dSubTpSz = dTpSz;
 		}else{
 			dSubTpSz = sheetObj.CellValue(0,col);
 		} 
 		
 		if(dLocTpCd == '9'){
 			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
 			dSusLoc = '';
 			dCodeFlg ='';
 		}
    }	
    
    /**
     * 셀을 클릭했을때 발생하는 이벤트 <br>
     * 선택시 선택행 배경색 세팅
     */
    function t3sheet1_OnClick(sheetObj, row, col, value) {
     	sheetObj.SelectHighLight = true;
     	dSusLoc = sheetObj.CellValue(row,"loc_cd");
     	dSubTpSz = dTpSz;
     	
     	if(col == '0'){
     		
     		if(dLocTpCd == '9'){
     			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
     			dSusLoc = '';
     		}else{
     			dSusLoc = sheetObj.CellValue(row,"loc_cd");
     			dCntrYdCd = '';
     		}
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     		dSubTpSz = dTpSz;
     		dLstmCd = '';
     	}else if(col == '1' || col == '2'){
     		dSubTpSz = dTpSz;
     		if('Total' == sheetObj.CellValue(row,"division")){
     			
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
         		
         		dLstmCd = '';
     		}else{
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
         		
         		dLstmCd = sheetObj.CellValue(row,"division");
     		}
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     		
     	}else{
     		if(dLocTpCd == '9'){
     			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
     			dSusLoc = '';
     		}else{
     			dSusLoc = sheetObj.CellValue(row,"loc_cd");
     			dCntrYdCd = '';
     		}
     		
     		if('Total' == sheetObj.CellValue(row,"division")){
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
         		dLstmCd = '';
     		}else{
         		if(dLocTpCd == '9'){
         			dCntrYdCd = sheetObj.CellValue(row,"loc_cd");
         			dSusLoc = '';
         		}else{
         			dSusLoc = sheetObj.CellValue(row,"loc_cd");
         			dCntrYdCd = '';
         		}
         		dLstmCd = sheetObj.CellValue(row,"division");
     		}
     		
     		dSubTpSz = sheetObj.CellValue(0,col);
     		
     		if(dSusLoc == 'Total'){
     			dSusLoc = '';
     			dCntrYdCd = '';
     		}
     	}
    }
    
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */

    function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var locCode = document.form.loc_type_code.value;
    	
    	if(locCode == '7'){
            if(sheetObj.RowCount > 0){
            	//마우스 위치를 행과 컬럼과 값 가져오기
                var Row = sheetObj.MouseRow;
                var Col = sheetObj.MouseCol;
                var prefix = sheetObj.id+"_";
                
                
                if(Row > 0 && Col == 0){
                	
                	var sText = sheetObj.CellValue(Row,"yd_nm");
                	if(sText != ""){
                		sheetObj.MouseToolTipText = sText;
                		sheetObj.MousePointer = "Hand";
                	}else{
                		sheetObj.MouseToolTipText = "";
                		sheetObj.MousePointer = "Default";
                	}
                }else{
            		sheetObj.MouseToolTipText = "";
                	sheetObj.MousePointer = "Default";	
                }
            }	
    	}    
    }
    
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */

    function t2sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var locCode = document.form.loc_type_code.value;
    	
    	if(locCode != '2'){
            if(sheetObj.RowCount > 0){
            	//마우스 위치를 행과 컬럼과 값 가져오기
                var Row = sheetObj.MouseRow;
                var Col = sheetObj.MouseCol;
                var prefix = sheetObj.id+"_";
                
                
                if(Row > 0 && Col == 0){
                	
                	var sText = sheetObj.CellValue(Row,"yd_nm");
                	if(sText != ""){
                		sheetObj.MouseToolTipText = sText;
                		sheetObj.MousePointer = "Hand";
                	}else{
                		sheetObj.MouseToolTipText = "";
                		sheetObj.MousePointer = "Default";
                	}
                }else{
            		sheetObj.MouseToolTipText = "";
                	sheetObj.MousePointer = "Default";	
                }
            }	
    	}    
    }
    
    /**
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */

    function t3sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var locCode = document.form.loc_type_code.value;
    	
    	if(locCode == '7'){
            if(sheetObj.RowCount > 0){
            	//마우스 위치를 행과 컬럼과 값 가져오기
                var Row = sheetObj.MouseRow;
                var Col = sheetObj.MouseCol;
                var prefix = sheetObj.id+"_";
                
                
                if(Row > 0 && Col == 0){
                	
                	var sText = sheetObj.CellValue(Row,"yd_nm");
                	if(sText != ""){
                		sheetObj.MouseToolTipText = sText;
                		sheetObj.MousePointer = "Hand";
                	}else{
                		sheetObj.MouseToolTipText = "";
                		sheetObj.MousePointer = "Default";
                	}
                }else{
            		sheetObj.MouseToolTipText = "";
                	sheetObj.MousePointer = "Default";	
                }
            }	
    	}    
    }
