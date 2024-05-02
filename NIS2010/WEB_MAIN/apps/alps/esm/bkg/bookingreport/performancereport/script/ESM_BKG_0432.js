/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0432.js
*@FileTitle : B/L Perf. by Volume-I (by Region-User Group)
*Open Issues : esm_bkg_0432 화면
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.28 이남경
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
     * @class esm_bkg_0432 : esm_bkg_0432 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0432() {
    	this.processButtonClick		 = processButtonClick;
    	this.setSheetObject 		 = setSheetObject;
    	this.loadPage 				 = loadPage;
    	this.initSheet 				 = initSheet;
    	this.initControl        = initControl;
    	this.doActionIBSheet 		 = doActionIBSheet;
    	this.sheet1_OnSearchEnd      = sheet1_OnSearchEnd;
    	this.doActionIBSheet2		= doActionIBSheet2;
    	this.sheet1_OnDblClick		= sheet1_OnDblClick;
    	this.setComboObject 		= setComboObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
	var comboCnt = 0;
 	var comboObjects = new Array();
    var sheetObjects = new Array();
    var sheetCnt = 0;    
    var rowsPerPage = 50;

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }    
    //페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    //ComComboObject생성자 메소드에서 호출됨
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
    
    function initCombo(comboObj, comboId) {
        var formObject = document.form
        initComboEditable(comboObj, comboId)
    }
    function initComboEditable(combo, comboId) {
        with (combo) {
        	if(comboId == "dpcs_ofc_cd"){
 	 			DropHeight = 150;
	 	 		MultiSelect = false;
	 	 		UseEdit = false;	 	 				
 	 			BackColor = "#ccfffd";	 	 	
        	}else{
        		MultiSelect = false;//comboId=="region";
        		UseEdit = false;
        		DropHeight = 200;
        	}
        }
    }

    function dpcs_ofc_cd_OnChange(comboObj) {
    	var formObj = document.form;
    	ComSetObjValue(formObj.f_cmd, SEARCHLIST01);
    	var param = FormQueryString(formObj);
    	
        if(comboObj.Text == 'PKGSA'){
        	param = param + "&cm_code=CD03249";
        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
        	var arrXml = sXml.split("|$$|");
        	if (arrXml[0].length > 0) {
        		ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
        	}

		    formObj.elements["region"].Index = 0;
        }else{
        	param = param + "&cm_code=CD03250";
        	var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
        	var arrXml = sXml.split("|$$|");
        	if (arrXml[0].length > 0) {
        		ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
        	}
		    formObj.elements["region"].Index = 0;
        }
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form; 
    	 
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);         	
            ComEndConfigSheet(sheetObjects[i]);            
        }
        //MultiCombo초기화
        for (var k=0; k<comboObjects.length; k++) {
            initCombo(comboObjects[k],comboObjects[k].id);
        }        
        axon_event.addListenerForm  ('keyup',    'obj_keyup', formObj); 
        
        initControl();
        doActionIBSheet(sheetObjects[0],document.form,SEARCH03);
        
    }
    function initControl() {
    	var formObject = document.form;

        axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
        axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        
        ComSetObjValue(formObject.from_dt,ComGetNowInfo());
     	ComSetObjValue(formObject.to_dt,ComGetNowInfo());
        
    }           
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        sheetObject1 = sheetObjects[0];
        sheetObject2 = sheetObjects[1];

        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0], document.form, IBSEARCH); 
			    	break;
			    case "btn_down_excel":
			    	sheetObject2.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	break;
			    case "btn_DownExcel_Summary":
			    	sheetObject1.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
			    	break;			    	
				case "btn_period":
 					var cal = new ComCalendarFromTo();
					cal.select(formObject.from_dt, formObject.to_dt,'yyyy-MM-dd');
					break;
            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
    	}
    }

    /**
     * KeyUp 처리 
     */   
 	function obj_keyup() {
 		var formObj = document.form;

 		with (formObj) {
 			if ( window.event.keyCode == 13 ) {
 				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
 			}
 		}
 	}

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "sheet1":    
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 202;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(2, 1, 9, 100);
		
		            var HeadTitle1 = "Region|Group|Staff|Event\n Count|S/I\n Count|B/L\n Count|H/BL\n Count|Original S/I|Original S/I|Original S/I|Original S/I"+
		                            "|Amend\n SI Count|H/BL\n SI Count|AES w/o\n SI Count|B/L CFM\n SI|Etc\n SI|Total\n Points|Aver.\n Point"+
		                            "|Total Time\n(By Sec)|Total Time|Total Time|Total Time|Total Time|Aver. Time\n(By Sec)|Aver. Time(TTL/Event)|Aver. Time(TTL/Event)|Aver. Time(TTL/Event)|Aver. Time(TTL/Event)||";
		            var HeadTitle2 = "Region|Group|Staff|Event\n Count|S/I\n Count|B/L\n Count|H/BL\n Count|Esi|Mail|Fax|JP-SEA"+
				                    "|Amend\n SI Count|H/BL\n SI Count|AES w/o\n SI Count|B/L CFM\n SI|Etc\n SI|Total\n Points|Aver.\n Point"+
				                    "|Total Time\n(By Sec)|Day|Hour|Min|Sec|Aver. Time\n(By Sec)|Day|Hour|Min|Sec||";
    
		            var headCount = ComCountHeadTitle(HeadTitle2);
		            		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            //dtRadioCheck
//		            InitDataProperty(0, cnt++,  dtCheckBox,     30,   daCenter,      false,   "sel");
		            InitDataProperty(0,	cnt++,	dtData,	        80 ,  daCenter,	     true,	  "region_d",                 false,    "",      dfNone,	      0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daLeft,  	     true,   "group_d",                 false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,     	70,   daCenter,  	 true,   "tot_staff",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_his_cnt",   	       false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_si_cnt",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_bkg_cnt",               false,    "",      dfInteger, 		  0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	    70,   daCenter,  	 true,   "tot_hbl_cnt",           false,    "",      dfNone, 		  0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	80,   daCenter,  	 false,   "tot_ori_edi_cnt",   	           false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	80,   daCenter,  	 false,   "tot_ori_mail_cnt",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	80,   daCenter,  	 false,   "tot_ori_fax_cnt",      false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	80,   daCenter,  	 false,   "tot_ori_sen_cnt",      false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_amd_cnt",   	       false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	    70,   daCenter,  	 true,   "tot_hbl_in_cnt",     false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum, 	    70,   daCenter,  	 true,   "tot_aes_cnt",   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_bl_cfm_cnt_cnt",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daCenter,  	 true,   "tot_addi_cnt",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,	    70,   daRight,  	 true,   "total_point",   	   false,    "",      dfFloat,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "avg_point",   	   false,    "",      dfFloat,         2,     false,      false);
		            InitDataProperty(0, cnt++ , dtAutoSum,   	70,   daRight,  	 true,   "tot_elapsed",     false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "tot_elapsed_dd",     false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "tot_elapsed_hh",     false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "tot_elapsed_mm",     false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "tot_elapsed_ss",     false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "avg_time",   	   false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,  	    70,   daRight,  	 true,   "avg_time_dd",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "avg_time_hh",   	   false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "avg_time_mm",   	   false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	    70,   daRight,  	 true,   "avg_time_ss",   	   false,    "",      dfInteger,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,   	70,   daCenter,  	 true,   "region",   	   false,    "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtHidden,   	70,   daCenter,  	 true,   "sr_sts_cd",   	   false,    "",      dfNone,         0,     false,      false);
					AutoSumBottom = 1;
					
		        }
		        break; 
		
	        case "sheet2":      //t1sheet1 init
		        with (sheetObj) {
		            // 높이 설정
		            style.height = 202;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msPrevColumnMerge + msHeaderOnly;
		
		           //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 10, 100);
		
		            var HeadTitle = "Seq|Pic User ID|User Name|User Group|Region|BKG No|S/I No|SI Kind|Urgent|SRC|RTN Freq|Amend Freq|VVD|POL|DEL||";
		            var headCount = ComCountHeadTitle(HeadTitle);		            
		            
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 2, 0, true);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle, true);
		
		            //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		            InitDataProperty(0, cnt++ , dtSeq,		 50,	daCenter,	 false,	  "seq_no");
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "pic_usr_id",        false,   "",      dfNone,         0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,  	 true,    "usr_nm",     false,   "",      dfNone, 		0,     false,      false);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daLeft,      false,   "usr_group",        false,   "",      dfNone, 		0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "region_nm",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "bkg_no",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "si_no",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "si_knd",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "sr_urg_nm",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "src",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "rtn_freq",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "amd_freq",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 100,   daCenter,  	 false,   "vvd_cd",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "pol",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtData,   	 80,   daCenter,  	 false,   "del",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHidden,   	 80,   daLeft,  	 false,   "region",       false,   "",      dfNone,         0,     true,       true);
		            InitDataProperty(0, cnt++ , dtHidden,   	 80,   daLeft,  	 false,   "urgent",       false,   "",      dfNone,         0,     true,       true);
		            
					CountPosition = 0;
		        }
		        break;
	
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
      	    case IBSEARCH: 
      	    	//필수입력체크 
 				if(!validateForm(sheetObj,formObj,sAction)) return;
 				formObj.f_cmd.value = SEARCH;
				sheetObj.RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObj.Redraw = false;    
				sheetObj.WaitImageVisible = true;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0432_1GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchXml(sXml); 
				sheetObj.WaitImageVisible = false;	
				sheetObj.Redraw = true;
            break;
			case SEARCH03:      // List by Queue조회
				formObj.f_cmd.value = SEARCH03;
				sheetObj.WaitImageVisible = false;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0432GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				/* doc part */
			    ComXml2ComboItem(arrXml[0], formObj.region, "val", "val|name");
			    formObj.elements["region"].Index = 0;
			    ComXml2ComboItem(arrXml[1], formObj.dpcs_ofc_cd, "val", "val|name");
			    if(formObj.usr_ofc_cd.value == "PKGSA"){
			    	formObj.elements["dpcs_ofc_cd"].Index =0 ;
            	}else if(formObj.usr_ofc_cd.value == "SZPSC" || formObj.usr_ofc_cd.value == "ZHOSO" ||
            			 formObj.usr_ofc_cd.value == "CANSO" || formObj.usr_ofc_cd.value == "FOCSO" ||
            			 formObj.usr_ofc_cd.value == "XMNSC" || formObj.usr_ofc_cd.value == "HKGSC" ){
            		formObj.elements["dpcs_ofc_cd"].Index =1 ;
            	}
//			    formObj.pfm_by_queue_cd.Code = '%';
//			    formObj.sr_knd_cd.Code = 'L';
			  
				break;            
        }
    }
 // Sheet2 관련 프로세스 처리
    function doActionIBSheet2(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {

           case IBSEARCH:      //Sheet1에서 클릭시 상세 조회 ->Sheet2에 표시 
               formObj.f_cmd.value = SEARCH01;
               sheetObj.RemoveAll();
               //------------------------------------------------------------------------------------------
               sheetObj.DoSearch("ESM_BKG_0432GS.do", FormQueryString(formObj)  );
               break;
 
               
        }
    }    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
	   	switch(sAction) {
	   		case IBSEARCH:
            	if(ComGetObjValue(formObj.dpcs_ofc_cd) == ""){
            		ComShowCodeMessage("BKG01101", "Doc OFC")
                    formObj.dpcs_ofc_cd.focus();
                    return false;
            	}
	    		if ( ComIsNull(formObj.from_dt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.from_dt.focus();
		     					return false;	
		     				
	    		}else if ( ComIsNull(formObj.from_mt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.from_mt.focus();
		     					return false;	
					}else	if ( ComIsNull(formObj.to_dt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.to_dt.focus();
		     					return false;	
		     				
	    		}else if ( ComIsNull(formObj.to_mt)) {
		     					ComShowCodeMessage('BKG00626','Period');
		     					formObj.to_mt.focus();
		     					return false;	
				}else if(ComGetDaysBetween(formObj.from_dt.value,formObj.to_dt.value) > 31 ) {
					ComShowCodeMessage("COM132001","Duration","1Month");
                    return false
				}
	  			break;
	   	 }
        return true;
    }
     
    
    //######################[1. Event]############################################################
 
	/*
	 *  Search Option or Item Option Modify
	 * */
	function sheet1_OnDblClick(sheetObj,rowIdx,colIdx) {
		var formObj = document.form;
		formObj.sel_region.value = sheetObj.CellValue(rowIdx, "region");
		formObj.sel_group.value  = sheetObj.CellValue(rowIdx, "sr_sts_cd"); 
		doActionIBSheet2(sheetObjects[1],formObj, IBSEARCH);  //sheetObjects[1]->sheet2
	}	   
    /**
    * sheet1 조회완료 후 처리 
    */    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
	   	sheetObj.CellValue2(sheetObj.Rows-1, "avg_time" )=  sheetObj.CellValue(sheetObj.Rows-1, "tot_elapsed")/sheetObj.CellValue(sheetObj.Rows-1, "tot_his_cnt") ;
		with(sheetObj)
		{
			 var sum_staff = EtcData("sum_staff") ;
			 var tot_avg_point = EtcData("tot_avg_point");
			 var tot_elapsed_dd = EtcData("tot_elapsed_dd") ;
			 var tot_elapsed_hh = EtcData("tot_elapsed_hh") ;
			 var tot_elapsed_mm = EtcData("tot_elapsed_mm") ;
			 var tot_elapsed_ss = EtcData("tot_elapsed_ss") ;
			 var tot_avg_elapsed_dd = EtcData("tot_avg_elapsed_dd") ;
			 var tot_avg_elapsed_hh = EtcData("tot_avg_elapsed_hh") ;
			 var tot_avg_elapsed_mm = EtcData("tot_avg_elapsed_mm") ;
			 var tot_avg_elapsed_ss = EtcData("tot_avg_elapsed_ss") ;			 
		}
		sheetObj.CellValue2(sheetObj.Rows-1, "avg_point" )= tot_avg_point   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "tot_elapsed_dd" )= tot_elapsed_dd   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "tot_elapsed_hh" )= tot_elapsed_hh   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "tot_elapsed_mm" )= tot_elapsed_mm   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "tot_elapsed_ss" )= tot_elapsed_ss   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "avg_time_dd" )= tot_avg_elapsed_dd   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "avg_time_hh" )= tot_avg_elapsed_hh   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "avg_time_mm" )= tot_avg_elapsed_mm   ;
		sheetObj.CellValue2(sheetObj.Rows-1, "avg_time_ss" )= tot_avg_elapsed_ss   ;		
    }
   
    function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	   	var formObj = document.form;
  	
    }	
	
    /*********************** KEY EVENT START ********************/ 	 
	function bkg_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "ymd":
	        //number
	        ComKeyOnlyNumber(event.srcElement, "-");
	        break;
	    	case "engup":
	        //영문대문자
    			ComKeyOnlyAlphabet('upper');
	        break;
	      case "engupnum":
	        //숫자+"영문대분자"입력하기
	      	ComKeyOnlyAlphabet('uppernum');
	        break;
	      case "num":
	        //숫자 입력하기
	        ComKeyOnlyNumber(event.srcElement);
	        break;	            
	      case "custname":
	        //숫자 입력하기
	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
	        break;	            
	      default:
	    }
	}    
    function bkg_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "from_dt":
	    		ComAddSeparator(event.srcElement);
					break;
	    	case "to_dt":
	    		ComAddSeparator(event.srcElement);
					break;	    		
    		
				default:
					break;
	    }
    } 
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "from_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "to_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}  
    
	/* 개발자 작업  끝 */