/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0236.js
 *@FileTitle : bookringreport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.06.10 강동윤
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
 * @class esm_bkg_0236 : esm_bkg_0236 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	function esm_bkg_0236() {
		this.processButtonClick = tprocessButtonClick;
		this.setSheetObject = setSheetObject;
		this.loadPage = loadPage;
		this.initSheet = initSheet;
		this.initControl = initControl;
		this.doActionIBSheet = doActionIBSheet;
		this.setTabObject = setTabObject;
		this.validateForm = validateForm;
		this.setTabObject 			= setTabObject;
	}
	/* 개발자 작업	*/
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0;
	var beforetab = 1;
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var prefix = "sheet1_";
	
	var comboCnt = 0;
 	var comboObjects = new Array();
 	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
		var sheetObject4 = sheetObjects[3];
		/*******************************************************/
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			
			
			switch (srcName) {
				case "btn_Retrieve":
					if (tabObjects[0].SelectedIndex == 0){
						doActionIBSheet(sheetObject1, document.form, SEARCH01);
					}else if (tabObjects[0].SelectedIndex == 1){
						doActionIBSheet(sheetObject2, document.form, SEARCH02);
					}
			    	 sheetObjects[2].RemoveAll();
			    	 sheetObjects[3].RemoveAll();
					break;
				case "btn_DtlRetrieve":
					if (tabObjects[0].SelectedIndex == 0){
						doActionIBSheet(sheetObject3, document.form, SEARCH03);
					}else if (tabObjects[0].SelectedIndex == 1){
						doActionIBSheet(sheetObject4, document.form, SEARCH04);
					}
					break;
				case "btn_DownExcel_Summary":
			    	if (tabObjects[0].SelectedIndex == 0){
			    		if(document.form.doc_tp_cd[0].checked == true){  //e-BKG  GSO 불포
			    			sheetObject1.Down2Excel(-1);
			    		}else{ //e-SI  GSO 포함
			    			sheetObject1.Down2Excel(0);
			    		}
			    	}else if (tabObjects[0].SelectedIndex == 1){
			    		if(document.form.doc_tp_cd[0].checked == true){  //e-BKG  GSO 불포
			    			sheetObject2.Down2Excel(-1);
			    		}else{ //e-SI  GSO 포함
			    			sheetObject2.Down2Excel(0);
			    		}
			    	}
			    	break;	
			    case "btn_DownExcel_Detail":			    	
			    	if (tabObjects[0].SelectedIndex == 0){
			    		sheetObject3.Down2Excel(-1);
			    	}else if (tabObjects[0].SelectedIndex == 1){
			    		sheetObject4.Down2Excel(-1);
			    	}
			    	break;
			    	
			    case "btn_period":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.fm_dt, formObject.to_dt, 'yyyy-MM-dd');
					break;
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
	
	
	function initCombo(comboObj, comboId) {
        var formObject = document.form
        with (comboObj) {
        	if(comboId=="grp_cust_tp_cd"){
        		UseCode = true;
        		UseAutoComplete = true;
        		UseEdit = false;
        		MultiSelect = true;
        	}else{
	            MultiSelect = false;//comboId=="region";
	            UseEdit = false;
	            DropHeight = 200;
        	}
        }
    }
    /**
     * grp_cust_tp_cd의 MultiSelection OnCheckClick 이벤트 처리
     */
    function grp_cust_tp_cd_OnCheckClick(comboObj, index, code) {
        // 선택된 Index가 없을 경우는 0번 Index 강제 선택
        if (comboObj.Text == null || comboObj.Text == "") {
            comboObj.CheckIndex(0) = true;

        } else {
            // Index 0번이 선택된 경우는 다른 모든 Index체크를 해제
            if (index == 0) {
                for(var i=1; i<comboObj.GetCount(); i++) {
                    comboObj.CheckIndex(i) = false;
                }
                document.form.cust_grp_tp.value = 'BKG_CUST_TP_CD';

            // 다른Index가 선택된 경우는 Index 0을 해제
            } else {
                comboObj.CheckIndex(0) = false;
                document.form.cust_grp_tp.value = "'" + ComReplaceStr(comboObj.Code, ",", "', '") + "'";
            }
        }
    }
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
		}
		//MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k],comboObjects[k].id);
        }  
		document.form.fm_dt.value = getCalculatedDate(0, 0, -1, "-");
		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
  		ComEnableManyObjects(false, document.form.bkg_no, document.form.gso_cd);
		
		tab1_OnClick(tabObjects[0], 0);
		initControl();
	}
	function initControl() {
		/* KeyPress Event 받아서 format 변환 */
		DATE_SEPARATOR = "-";
		var formObject = document.form;
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerFormat('keypress',       'obj_keypress',    formObject);
		axon_event.addListenerForm  ('click',    'obj_click',      formObject); 
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');//Enter key 처리
	}

    function obj_keypress() {
  		var formObj = document.form;        
  		with(formObj) {
  			switch(event.srcElement.name){
  	            case "cust_grp_id":
  	            	ComKeyOnlyAlphabet('uppernum',"45");  //대문자, 숫자, -  허용
  	            	break;
  			}
  		}
    	
    }

	/**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg_deactivate() {
        var formObj = document.form;
        switch (event.srcElement.getAttribute("name")) {
            case "fm_dt":
                ComAddSeparator(event.srcElement);
            break;
            case "to_dt":
                ComAddSeparator(event.srcElement);
            break;
        }
    }
    /**
     * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
     **/
    function bkg_activate() {
        //입력Validation 확인하기
        switch (event.srcElement.name) {
            case "fm_dt":
                ComClearSeparator(event.srcElement);
            break;
            case "to_dt":
                ComClearSeparator(event.srcElement);
            break;
        }
    }
    
    function obj_click() {
  		var formObj = document.form;        
  		with(formObj) {
  			switch(event.srcElement.name){
  	            case "opt_tp":
  	            	if (event.srcElement.value == "D") {
  	            		document.form.bkg_no.value = "";
  	            		ComEnableManyObjects(false, bkg_no);
  	            		ComEnableManyObjects(true, fm_dt , to_dt);
  	            		ComClassNameManyObjects_loc("input1", fm_dt, to_dt);
  	            		document.form.fm_dt.value = getCalculatedDate(0, 0, -1, "-");
  	            		document.form.to_dt.value = getCalculatedDate(0, 0, 0, "-");
  	            	} else if (event.srcElement.value == "B") {
  	            		document.form.fm_dt.value = "";
  	            		document.form.to_dt.value = "";
  	            		ComEnableManyObjects(false, fm_dt , to_dt);
  	            		ComEnableManyObjects(true, bkg_no);
  	            		ComClassNameManyObjects_loc("input1", bkg_no);
  	            	}

  	            	break;
  	            case "doc_tp_cd":
  	            	
  	            	if(event.srcElement.value =="B"){
  	            		sheetObjects[0].CellText(0,"si_cnt") = "TTL e-BKG";
  	            		sheetObjects[1].CellText(0,"si_cnt") = "TTL e-BKG";
  	            		sheetObjects[0].ColHidden("gso_cd") = true;
  	            		sheetObjects[1].ColHidden("gso_cd") = true;
  	            		sheetObjects[2].CellText(0,"ntc_dt") = "Receipt Out";
  	            		sheetObjects[2].CellText(0,"rqst_dt") = "BKG Receipt";
  	            		sheetObjects[3].CellText(0,"rqst_dt") = "BKG Receipt";
  	            		formObj.gso_cd.value = "";
  	            		ComEnableObject(formObj.gso_cd, false);

  	            	}else{
  	            		sheetObjects[0].CellText(0,"si_cnt") = "TTL e-SI";
  	            		sheetObjects[1].CellText(0,"si_cnt") = "TTL e-SI";
  	            		sheetObjects[0].ColHidden("gso_cd") = false;
  	            		sheetObjects[1].ColHidden("gso_cd") = false;
  	            		sheetObjects[2].CellText(0,"ntc_dt") = "Draft Out"
  	            		sheetObjects[2].CellText(0,"rqst_dt") = "SI Receipt";
  	            		sheetObjects[3].CellText(0,"rqst_dt") = "SI Receipt";
  	            		ComEnableObject(formObj.gso_cd, true);
  	            	}
  	            	
  	            	sheetObjects[0].RemoveAll();
  	            	sheetObjects[1].RemoveAll();
  	            	sheetObjects[2].RemoveAll();
  	            	sheetObjects[3].RemoveAll();
  	            	
  	            	break;
  			}
  		}
    }
    
    function ComClassNameManyObjects_loc(p_className, objs) {
        try {
            var args = arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].className = p_className;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt = 0;
		switch (sheetNo) {
			case 1: //sheet1 init
				with (sheetObj) {
					// 높이 설정
					style.height = 375;
					//전체 너비 설정
					SheetWidth = mainTable[0].clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					prefix = "sheet1_";
					var HeadTitle1 = "|Seq.|Sel|RHQ|GSO|BKG OFC|TTL BKG|TTL e-BKG|TTL Staff|TTL(HRS)|AVG(HRS)|TTL(DD:HH:MM:SS)|AVG(DD:HH:MM:SS)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 30,  daCenter, true,  "Seq"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCheckBox,25,  daCenter, true,  "chk"                ,false, "", dfNone, 0, true,  false);
					InitDataProperty(0, cnt++, dtData,    45,  daCenter, true,  "rhq_cd"         	 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  50,  daCenter, true,  "gso_cd"         	 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    55,  daCenter, true,  "bkg_ofc_cd"         ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60,  daCenter, true,  "bkg_cnt"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    65,  daCenter, true,  "si_cnt"             ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60,  daCenter, true,  "usr_cnt"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "turn_hh"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "avg_turn_hh"        ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    120, daCenter, true,  "turn_tm"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    120, daCenter, true,  "avg_turn_tm"        ,false, "", dfNone, 0, false, false);
				}
				break;
			case 2: //sheet2 init
				with (sheetObj) {
					// 높이 설정
					style.height = 375;
					//전체 너비 설정
					SheetWidth = mainTable[0].clientWidth;
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "")
						InitHostInfo(location.hostname, location.port, page_path);
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 9, 100);
					prefix = "sheet2_";
					var HeadTitle1 = "|Seq.|Sel|RHQ|GSO|BKG OFC|TTL BKG|TTL e-BKG|TTL Staff|TTL(HRS)|AVG(HRS)|TTL(DD:HH:MM:SS)|AVG(DD:HH:MM:SS)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 30,  daCenter, true,  "Seq"                ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCheckBox,25,  daCenter, true,  "chk"                ,false, "", dfNone, 0, true,  false);
					InitDataProperty(0, cnt++, dtData,    45, daCenter, true,  "rhq_cd"         	 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,  50, daCenter, true,  "gso_cd"         	 ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    55, daCenter, true,  "bkg_ofc_cd"         ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "bkg_cnt"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    65, daCenter, true,  "si_cnt"             ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "usr_cnt"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "upld_hh"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    60, daCenter, true,  "avg_upld_hh"        ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    120, daCenter, true,  "upld_tm"            ,false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData,    120, daCenter, true,  "avg_upld_tm"        ,false, "", dfNone, 0, false, false);
				
				}
				break;	
			case 3: //sheet3 init
				with (sheetObj) {
					// 높이 설정
		            style.height = 375;
		            //전체 너비 설정
		            SheetWidth = mainTable[1].clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "Seq|BKG No.|Sender ID|SR No|SR Seq|T.VVD|BKG Office|POL|POD|Via|RHQ|TTL(HRS)|BKG Receive|Receipt Out";
		            var headCount = ComCountHeadTitle(HeadTitle);		            
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtSeq,		 30,	daCenter,	 false,	  "seq");
		            InitDataProperty(0, cnt++ , dtData,   	 90,   daCenter,  	 true,    "bkg_no",         false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden,  	 100,   daCenter,  	 true,    "xter_sndr_id",   false,   "",      dfNone, 		  0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden,    100,   daCenter,    false,   "xter_rqst_no",   false,   "",      dfNone, 		  0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden,    50,    daCenter,  	 false,   "xter_rqst_seq",  false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 75,    daCenter,  	 false,   "vvd",       		false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 65,    daCenter,  	 false,   "bkg_ofc_cd",     false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 50,    daCenter,  	 false,   "pol_cd",         false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 50,    daCenter,  	 false,   "pod_cd",         false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 40,    daCenter,  	 false,   "xter_rqst_via_cd",false,  "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtHidden, 	 70,    daCenter,  	 false,   "rhq_cd",         false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 70,   daCenter,  	 false,   "turn_tm",        false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,  	 120,   daCenter,  	 false,   "rqst_dt",        false,   "",      dfNone,         0,     false,       false);
		            InitDataProperty(0, cnt++ , dtData,   	 120,   daCenter,  	 false,   "ntc_dt",         false,   "",      dfNone,         0,     false,       false);
   
				}
				break;			
			case 4: //sheet3 init
				with (sheetObj) {
					// 높이 설정
		            style.height = 375;
		            //전체 너비 설정
		            SheetWidth = mainTable[1].clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "Seq|BKG No.|Sender ID|SR No|SR Seq|T.VVD|BKG Office|POL|POD|Via|RHQ|TTL(HRS)|BKG Receive|Upload";
		            var headCount = ComCountHeadTitle(HeadTitle);		            
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtSeq,		 30,   daCenter,	 false,	  "seq");
		            InitDataProperty(0, cnt++ , dtData,   	 90,  daCenter,  	 true,    "bkg_no",         false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,    100,  daCenter,  	 true,    "xter_sndr_id",   false,   "",      dfNone, 		  0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,    100,  daCenter,     false,   "xter_rqst_no",   false,   "",      dfNone, 		  0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,    50,   daCenter,  	 false,   "xter_rqst_seq",  false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 75,  daCenter,  	 false,   "vvd",            false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 65,  daCenter,  	 false,   "bkg_ofc_cd",     false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 50,   daCenter,  	 false,   "pol_cd",         false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 50,   daCenter,  	 false,   "pod_cd",         false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 40,   daCenter,  	 false,   "xter_rqst_via_cd",false,  "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,  	 70,   daCenter,  	 false,   "rhq_cd",         false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 70,  daCenter,  	 false,   "upld_tm",        false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 120,  daCenter,  	 false,   "rqst_dt",        false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 120,  daCenter,  	 false,   "upld_dt",        false,   "",      dfNone,         0,     false,      false);

				}
				break;			
		}
	}
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {
			case IBCLEAR:      // List by Queue조회
				formObj.f_cmd.value = INIT;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0236GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], formObj.rhq_cd, "val", "val");
				}				
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.ctrt_tp_cd, "val", "val");
				
				if (arrXml.length > 2){
					ComXml2ComboItem(arrXml[2], formObj.cust_tp_cd, "val", "name");
					ComXml2ComboItem(arrXml[2], formObj.grp_cust_tp_cd, "val", "name");
					formObj.grp_cust_tp_cd.Index = 0;
				}
			  
			  
				break;    
			case SEARCH01: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				formObj.f_cmd.value = SEARCH01;
				ComOpenWait(true);  //대기이미지 표시
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0236GS.do", FormQueryString(formObj));
				
				sheetObj.LoadSearchXml(searchXml);
				ComOpenWait(false); //대기이미지 숨김
				
				break;	
			case SEARCH02: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;
				
				formObj.f_cmd.value = SEARCH02;
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0236GS.do", FormQueryString(formObj));
				
				sheetObj.LoadSearchXml(searchXml);
				
				break;	
			case SEARCH03: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;

				if (0 == sheetObjects[0].CheckedRows("chk")) {
                    ComShowCodeMessage("COM12189");
                    return false;
                }
				
				formObj.f_cmd.value = SEARCH03;
				var param = FormQueryString(formObj)+"&"+ComSetPrifix(sheetObjects[0].GetSaveString(false, true, "chk"), "sheet1_");
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0236GS.do", param);
				
				sheetObj.LoadSearchXml(searchXml);
				
				break;	
			case SEARCH04: 
				if (!validateForm(sheetObj, formObj, sAction))
					return;

				if (0 == sheetObjects[1].CheckedRows("chk")) {
                    ComShowCodeMessage("COM12189");
                    return false;
                }
				
				formObj.f_cmd.value = SEARCH04;
				var param = FormQueryString(formObj)+"&"+ComSetPrifix(sheetObjects[1].GetSaveString(false, true, "chk"), "sheet2_");
				var searchXml = sheetObj.GetSaveXml("ESM_BKG_0236GS.do", param);
				
				sheetObj.LoadSearchXml(searchXml);
				
				break;	
		}
	}
	
	 // Sheet2 관련 프로세스 처리
    function doActionIBSheet4(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시 
               formObj.f_cmd.value = SEARCH01;
               sheetObj.RemoveAll();
               //------------------------------------------------------------------------------------------
               sheetObj.DoSearch("ESM_BKG_0236GS.do", FormQueryString(formObj)  );
               break;
 
               
        }
    }  
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
			case SEARCH01: //조회
			case SEARCH02: //조회
			case SEARCH03: //조회
			case SEARCH04: //조회
				if(ComGetObjValue(formObj.opt_tp) == 'D'){
					if (formObj.fm_dt.value == '' || formObj.to_dt.value == '') {
						ComShowCodeMessage("BKG00499");//Period are mandatory items.
						formObj.fm_dt.focus();
						return false;
					}
					if(ComGetDaysBetween(formObj.fm_dt.value,formObj.to_dt.value) > 31 ) {
						ComShowCodeMessage("COM132001", "Period", "1Month")
						return false;
					}
				}else{
					if(formObj.bkg_no.value==''){
						ComShowMessage(ComGetMsg("BKG00104", "BKG No."));
						formObj.bkg_no.focus();
						return false;
					}
				}
				return true;
				break;
		}
	}
	
	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		sheetObj.CheckAll2("chk") = 0; 
		sheetObj.CellValue(rowIdx, "chk") = 1;
		doActionIBSheet(sheetObjects[2], document.form, SEARCH03);
	}		
	
	function sheet2_OnDblClick(sheetObj,rowIdx,colIdx) {
		sheetObj.CheckAll2("chk") = 0; 
		sheetObj.CellValue(rowIdx, "chk") = 1;		
		doActionIBSheet(sheetObjects[3], document.form, SEARCH04);
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.CellEditable(sheetObj.Rows-1,"chk") = false;
		sheetObj.CellFont("FontBold", sheetObj.Rows-1,"rhq_cd",sheetObj.Rows-1,"avg_turn_tm") = true;
	}
	
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		sheetObj.CellEditable(sheetObj.Rows-1,"chk") = false;
		sheetObj.CellFont("FontBold", sheetObj.Rows-1,"rhq_cd",sheetObj.Rows-1,"avg_upld_tm") = true;
	}
	
 	
 	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");
  	}
 	
 	function sheet4_OnSearchEnd(sheetObj, ErrMsg) {
 		comBkgIndicateLink(sheetObj,"bkg_no");
  	}

 	function sheet3_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}

 	function sheet4_OnDblClick(sheetObj,rowIdx,colIdx) {
		var colName = sheetObj.ColSaveName(colIdx);
		if (colName == "bkg_no"){
			comBkgCallPopBkgDetail(sheetObj.CellValue(rowIdx, colName));
 		}
  	}
	/**
	 * 날짜 계산 함수
	 */
	function getCalculatedDate(iYear, iMonth, iDay, seperator) {
		//현재 날짜 객체를 얻어옴
		var gdCurDate = new Date();
		//현재 날짜에 날짜 계산
		gdCurDate.setYear(gdCurDate.getFullYear() + iYear);
		gdCurDate.setMonth(gdCurDate.getMonth() + iMonth);
		gdCurDate.setDate(gdCurDate.getDate() + iDay);
		//실제 사용할 연,월,일 변수 받기
		var giYear = gdCurDate.getFullYear();
		var giMonth = gdCurDate.getMonth() + 1;
		var giDay = gdCurDate.getDate();
		//월,일의 자릿수를 2자리로 맞춘다.
		giMonth = "0" + giMonth;
		giMonth = giMonth.substring(giMonth.length - 2, giMonth.length);
		giDay = "0" + giDay;
		giDay = giDay.substring(giDay.length - 2, giDay.length);
		//alert(giYear + seperator + giMonth + seperator + giDay);
		//display 형태 맞추기
		return giYear + seperator + giMonth + seperator + giDay;
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
                    InsertTab( cnt++ , "Turn Time" , -1 );
                    InsertTab( cnt++ , "Upload Time" , -1 );
                }
             break;

         }
    }
     function tab1_OnClick(tabObj, nItem){
    	 setSheetVisble(nItem);
    	 sheetObjects[2].RemoveAll();
    	 sheetObjects[3].RemoveAll();
     }
     
     function setSheetVisble(inx){
 		for(var k=0; k< mainTable.length; k++){
 		    mainTable[k].style.display ="none";
 		    detailTable[k].style.display="none";
 		}
 		mainTable[inx].style.display ="";
 		detailTable[inx].style.display ="";
     }
	/* 개발자 작업  끝 */