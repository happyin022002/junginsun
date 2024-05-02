/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : EES_CTM_0436.js
 * @FileTitle : Movement Correction Monitoring 
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.02.29
 * @LastModifier : 홍성필
 * @LastVersion : 1.0
 * 2016.02.29 홍성필 1.0 Creation
 * 2016.04.18 김상현 [CHM-201640817] Correction Reason 기능 추가2
 */

	/**
	 * @class EES_CTM_0436 : EES_CTM_0436 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function EES_CTM_0436() {
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
	var tabCnt = 0;
	var beforetab = 0;

	var sheetObjects = new Array();
	var sheetCnt = 0;

 	var comboObjects = new Array();
 	var comboCnt = 0;
 	
 	
 	var t1Ccrn = 0;
 	var t2Ccrn = 0;
 	var t2Lcc = 0;
 	var t3Ccrn = 0;
 	var t3Yard = 0;
 	var t3Lcc = 0;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var sheetObject2 = sheetObjects[2];
        var sheetObject3 = sheetObjects[3];

		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
			case "btn_Retrieve" :
				if(beforetab==1){
					doActionIBSheet(sheetObject, formObject, SEARCH05);
				}else if(beforetab==2){
					doActionIBSheet(sheetObject1, formObject, SEARCH04)
				}else if(beforetab==3){
					doActionIBSheet(sheetObject2, formObject, SEARCH03)
				}else if(beforetab==4){
					doActionIBSheet(sheetObject3, formObject, IBSEARCH);
				}
				break;
			case "btn_New" :
				formObject.reset();
				sheetObject.RemoveAll();
				sheetObject1.RemoveAll();
				sheetObject2.RemoveAll();
				sheetObject3.RemoveAll();
				break;
			case "btn_downExcel" :
				if(beforetab==1){
					sheetObject.Down2Excel(0, false, false, true, "", "", false, false, "", false, "lvl");
				}else if(beforetab==2){
					sheetObject1.Down2Excel(0, false, false, true, "", "", false, false, "", false, "lvl");
				}else if(beforetab==3){
					sheetObject2.Down2Excel(0, false, false, true, "", "", false, false, "", false, "lvl");
				}else if(beforetab==4){
					sheetObject3.Down2Excel(0, false, false, true, "", "", false, false, "", false, "atch_file_sav_id");
				}
				break;
			case "btn_Calendar01" :
				var cal = new ComCalendarFromTo();
				cal.select(formObject.event_from_dt, formObject.event_to_dt, 'yyyy-MM-dd');
				break;
			case "btn_Calendar02" :
				var cal = new ComCalendarFromTo();
				cal.select(formObject.upt_from_dt, formObject.upt_to_dt, 'yyyy-MM-dd');
				break;
			} // end switch
		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
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
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++] = sheet_obj;
	}

	/**
	 * IBMultiCombo Object를 배열로 등록
	 * param : combo_obj ==> 콤보오브젝트
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
	}

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		for (i=0; i<sheetObjects.length; i++) {
			// khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			if(i > 0){
            	tdisp = tabLayer[i-1].style.display;
            	tabLayer[i-1].style.display = "block";
        	}
			initSheet(sheetObjects[i], i+1);
			if(i > 0){
				tabLayer[i-1].style.display = tdisp;
			}
			// khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		
		initControl();

        for (var i=0; i<comboObjects.length; i++) {
            initCombo(comboObjects[i], comboObjects[i].id);
        }

		doActionIBSheet(sheetObjects[0], document.form, SEARCH01);
		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);

		axon_event.addListener("change", "rcc_cd_Change", "rcc_cd");
		axon_event.addListener("keyup", "yard_cd1_Keyup", "yard_cd1");
	}

    function initCombo(comboObj, comboId) {
        var frmObj = document.form;
        with (comboObj) {
        	switch (comboId) {
        	case "p_lcc_cd" :
        		MultiSelect = true;
        		break;
        	case "yard_cd2" :
        		MultiSelect = true;
        		break;
        	default :
        		break;
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
         switch(sheetNo) {
         	case 1:      //sheet1 init
         		with (sheetObj) {
	         		// 높이 설정
	                style.height = 370;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(3, 1, 4, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(18, 2, 0, false);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false,false) ;
	                var HeadTitle1 = "RCC|Correction Reason(+)||" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Total";
	
	                var HeadTitle2 = "RCC|Correction Reason(+)||" +
	                		         "Delete|Insert|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Total";
	                
	                var HeadTitle3 = "RCC|Correction Reason(+)||" +
	                		         "Delete|Insert|MVMT\nStatus|Event\nDate|Origin\nYard|" +
	                		         "VVD\nCode|F/M|I/O|Service\nProvide|Mode|" +
	                		         "Seal No.|Waybill|Pick up\nNo.|etc.|Total";
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                InitHeadRow(2, HeadTitle3, true);
	
	                //데이터속성    [		ROW,	COL,  	DATATYPE,   WIDTH,	DATAALIGN,	COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"rcc_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		240,   	daLeftTop,  true,    	"cnmv_corr_rsn_nm",		false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0,		cnt++,	dtHidden,	50,		daLeft,		false,		"lvl",					false,			"",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"del_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"ins_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_sts_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cnmv_evnt_dt_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"org_yd_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vvd_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"fcntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"ob_cntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vndr_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_trsp_mod_cd_cnt",	false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cntr_seal_no_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"wbl_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"pkup_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"etc_cnt",				false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"tot_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitTreeInfo(2, "sLevel", RgbColor(0,0,255), false);
	                var backColor = RgbColor(222, 251, 248);
	    			RangeBackColor(1, 10, 1, 17) = backColor;
	    			ImageList(0) = "img/nolines_plus.gif";
	    			ImageList(1) = "img/nolines_minus.gif";
	         	}
         		break;
         	case 2:      //sheet1 init
         		with (sheetObj) {
	         		// 높이 설정
	                style.height = 370;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(3, 1, 4, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(19, 3, 0, false);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false,false) ;
	                var HeadTitle1 = "RCC|LCC(+)|Correction Reason(+)||" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Total";
	
	                var HeadTitle2 = "RCC|LCC(+)|Correction Reason(+)||" +
	                		         "Delete|Insert|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Total";
	                
	                var HeadTitle3 = "RCC|LCC(+)|Correction Reason(+)||" +
	                		         "Delete|Insert|MVMT\nStatus|Event\nDate|Origin\nYard|" +
	                		         "VVD\nCode|F/M|I/O|Service\nProvide|Mode|" +
	                		         "Seal No.|Waybill|Pick up\nNo.|etc.|Total";
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                InitHeadRow(2, HeadTitle3, true);
	
	                //데이터속성    [		ROW,	COL,  	DATATYPE,   WIDTH,	DATAALIGN,	COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"rcc_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"lcc_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		240,   	daLeftTop,  true,    	"cnmv_corr_rsn_nm",		false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0,		cnt++,	dtHidden,	50,		daLeft,		false,		"lvl",					false,			"",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"del_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"ins_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_sts_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cnmv_evnt_dt_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"org_yd_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vvd_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"fcntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"ob_cntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vndr_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_trsp_mod_cd_cnt",	false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cntr_seal_no_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"wbl_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"pkup_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"etc_cnt",				false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"tot_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitTreeInfo(3, "sLevel", RgbColor(0,0,255), false);
	                var backColor = RgbColor(222, 251, 248);
	    			RangeBackColor(1, 10, 1, 17) = backColor;
	    			ImageList(0) = "img/nolines_plus.gif";
	    			ImageList(1) = "img/nolines_minus.gif";
	         	}
         		break;
         	case 3:      //sheet1 init
         		with (sheetObj) {
	         		// 높이 설정
	                style.height = 370;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	                
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msPrevColumnMerge + msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(3, 1, 4, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(20, 4, 0, false);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false,false) ;
	                var HeadTitle1 = "RCC|LCC(+)|Yard(+)|Correction Reason(+)||" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Corrction Item|" +
	                		         "Corrction Item|Corrction Item|Corrction Item|Corrction Item|Total";
	
	                var HeadTitle2 = "RCC|LCC(+)|Yard(+)|Correction Reason(+)||" +
	                		         "Delete|Insert|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Update|" +
	                		         "Update|Update|Update|Update|Total";
	                
	                var HeadTitle3 = "RCC|LCC(+)|Yard(+)|Correction Reason(+)||" +
	                		         "Delete|Insert|MVMT\nStatus|Event\nDate|Origin\nYard|" +
	                		         "VVD\nCode|F/M|I/O|Service\nProvide|Mode|" +
	                		         "Seal No.|Waybill|Pick up\nNo.|etc.|Total";
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                InitHeadRow(2, HeadTitle3, true);
	
	                //데이터속성    [		ROW,	COL,  	DATATYPE,   WIDTH,	DATAALIGN,	COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"rcc_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"lcc_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenterTop,true,    	"org_yd_cd",   			false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		240,   	daLeftTop,  true,    	"cnmv_corr_rsn_nm",		false,          "",		dfNone,				0,     false,       false);
	                InitDataProperty(	0,		cnt++,	dtHidden,	50,		daLeft,		false,		"lvl",					false,			"",		dfNone,				0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"del_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"ins_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_sts_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cnmv_evnt_dt_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"org_yd_cd_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vvd_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"fcntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"ob_cntr_flg_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"vndr_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"mvmt_trsp_mod_cd_cnt",	false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"cntr_seal_no_cnt",		false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"wbl_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"pkup_no_cnt",			false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	false,    	"etc_cnt",				false,          "",		dfNone,		0,     false,       false);
	                InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"tot_cnt",   			false,          "",		dfNone,		0,     false,       false);
	                InitTreeInfo(4, "sLevel", RgbColor(0,0,255), false);
	                var backColor = RgbColor(222, 251, 248);
	    			RangeBackColor(1, 10, 1, 17) = backColor;
	    			ImageList(0) = "img/nolines_plus.gif";
	    			ImageList(1) = "img/nolines_minus.gif";
	         	}
         		break;
            case 4:      //sheet2 init
            	with (sheetObj) {
            		// 높이 설정
                     style.height = 370;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;
                     
                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = false;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 4, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(45, 4, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)
                     var HeadTitle1 = "Seq|Container no|Type/Size|Correction Type|CYC|C|STS|A/F|Rcc|Lcc|Origin YD|Return YD|Event Date|VVD Code|Booking No.|";
                     HeadTitle1 += "F/M|I/O|MSG|TP|DM|D|E|R|SP|Service Provider|Service Provider|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Correction Reason|";
                     HeadTitle1 += "Evidence Attached|Remark(s)|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)|Office|User Name||Input Div";

                     var HeadTitle2 = "Seq|Container no|Type/Size|Correction Type|CYC|C|STS|A/F|Rcc|Lcc|Origin YD|Return YD|Event Date|VVD Code|Booking No.|";
                     HeadTitle2 += "F/M|I/O|MSG|TP|DM|D|E|R|SP|Seq|Name|Mode|Chassis No.|M.G Set|Seal No.|Waybill|Pick Up No.|Correction Reason|";
                     HeadTitle2 += "File Attached|Remark(s)|Update Date(L)|Creation Date(L)|Update Date(S)|Creation Date(S)|Office|User Name||Input Div";
                     

                     // 헤더 툴팁
                     var sTipAF = "";
                     sTipAF += "[ Auto Flag ]\n";
                     sTipAF += "A : Missing status automatically created by system.\n";
                     sTipAF += "C : (International) \"TS, IC, MT\" Status automatically created after \"VD\"\n";
                     sTipAF += "      (USA domestic) \"CM\" Status automatically created after \"CD\"\n";
                     sTipAF += "N : Once automatically created status (\"A\") modified by manual,\n";
                     sTipAF += "      \"A\" changed to \"N\"\n";
                     sTipAF += "M : Added status.\n";
                     sTipAF += "U : Status updated due to next status.\n";
                     sTipAF += "E : Status created by Master/Lease.\n";
                     sTipAF += "S : Once automatically created status (\"A\") modified by late EDI,\n";
                     sTipAF += "      \"A\" changed to \"S\"\n";
                     sTipAF += "B : Status updated by manual due to error.\n";
                     sTipAF += "G : Once created without VGM, missing VGM is retroactively inserted by later EDI message.";

                     var sTipIO = "Bound indicator"; //
                     var sTipTP = "[ Cargo type ] \nF: Full, P: Reposition, R: Revenue";
                     var sTipDM = "Damage, Y";
                     var sTipHR = "Hanger Rack, Y";
                     var sTipHB = "Hanger Bar";
                     var sTipD  = "Disposal Candidate, Y";
                     var sTipE  = "Immediate Exit, Y";
                     var sTipR  = "Re-furbishing, Y";
                     var sTipSP = "Special, Y";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [		ROW,	COL,  	DATATYPE,   WIDTH,	DATAALIGN,	COLMERGE, 	SAVENAME,  			KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(	0, 		cnt++, 	dtSeq,		30,   	daCenter,   true,    	"Seq");
                     InitDataProperty(	0, 		cnt++, 	dtData,		90,   	daCenter,  	true,    	"cntr_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"cntr_tpsz_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		100,   	daCenter,  	true,    	"correction_type",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		30,   	daCenter,  	true,    	"cnmv_cyc_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		40,   	daCenter,  	true,    	"cnmv_co_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		30,   	daCenter,  	true,    	"mvmt_sts_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++,  dtData,    	30,     daCenter,   true,    	"mvmt_cre_tp_cd",          false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipAF);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"rcc_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"lcc_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"org_yd_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"dest_yd_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		110,  	daCenter,  	true,    	"cnmv_evnt_dt",   				false,          "",      dfUserFormat2,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		70,   	daCenter,  	true,    	"vvd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		90,   	daCenter,  	true,    	"bkg_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0,		cnt++, 	dtData,		30,   	daCenter,  	true,    	"fcntr_flg",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "ob_cntr_flg",             false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipIO);
                     InitDataProperty(	0, 		cnt++, 	dtData,		35,   	daCenter,  	true,    	"mvmt_edi_msg_tp_id",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "bkg_cgo_tp_cd",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipTP);
                     InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "cntr_dmg_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipDM);
                     InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "cntr_disp_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipD);
                     InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "imdt_ext_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipE);
                     InitDataProperty(0, cnt++,    dtData,    20,     daCenter,    true,    "cntr_rfub_flg",           false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipR);
                     InitDataProperty(0, cnt++,    dtData,    30,     daCenter,    true,    "spcl_cgo_flg",            false,    "",    dfNone,    0,    true,    true,    -1,    false,    false,    sTipSP);
                     InitDataProperty(	0, 		cnt++, 	dtData,		130,  	daCenter,  	true,    	"vndr",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		130,  	daCenter,  	true,    	"vndr_abbr_nm",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		40,   	daCenter,  	true,    	"mvmt_trsp_mod_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		80,   	daCenter,  	true,    	"chss_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		80,   	daCenter,  	true,    	"mgst_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		80,   	daCenter,  	true,    	"cntr_seal_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		90,   	daCenter,  	true,    	"wbl_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		90,   	daCenter,  	true,    	"pkup_no",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		200,  	daLeft,  	true,    	"cnmv_corr_rsn",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtImageText,160,  	daCenter,  	true,    	"atch_file_sav_yn",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		150,  	daCenter,  	true,    	"cnmv_rmk",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		110,  	daCenter,  	true,    	"upd_locl_dt",   				false,          "",      dfUserFormat2,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		110,  	daCenter,  	true,    	"cre_locl_dt",   				false,          "",      dfUserFormat2,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		110,  	daCenter,  	true,    	"upd_dt",   				false,          "",      dfUserFormat2,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		110,  	daCenter,  	true,    	"cre_dt",   				false,          "",      dfUserFormat2,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		60,   	daCenter,  	true,    	"ofc_cd",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++, 	dtData,		90,   	daCenter,  	true,    	"usr_nm",   			false,          "",      dfNone,  			0,     false,       false);
                     InitDataProperty(	0, 		cnt++ , dtHidden,   40,  	daCenter,   false,    	"atch_file_sav_id",		false,   "",       dfNone,   	    0,     false,       false);
                     InitDataProperty(	0, 		cnt++ , dtHidden,   40,  	daCenter,   false,    	"inp_div_flg",		false,   "",       dfNone,   	    0,     false,       false);
                     InitDataProperty(	0, 		cnt++ , dtHidden,   40,  	daCenter,   false,    	"cng_yn",		false,   "",       dfNone,   	    0,     false,       false);
                     InitDataProperty(	0, 		cnt++ , dtHidden,   40,  	daCenter,   false,    	"cnmv_his_col_nm",		false,   "",       dfNone,   	    0,     false,       false);
                     InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "upd_locl_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_locl_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "upd_dt", "####-##-## ##:##", "-|:" );
                     InitUserFormat2(0, "cre_dt", "####-##-## ##:##", "-|:" );
                     ImageList("atch_file_sav_yn")= "/hanjin/img/ico_attach.gif";
                     InitDataImage(0, "atch_file_sav_yn", daCenter);
                     CountPosition = 0;
                     
                     //SelectHighLight = true;
                     //SelectFontBold = true;
            }
            break;
         }
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
                 	 InsertTab( cnt++ , "Summary by RCC" , -1 );
                     InsertTab( cnt++ , "Summary by LCC" , -1 );
                     InsertTab( cnt++ , "Summary by Yard" , -1 );
                     InsertTab( cnt++ , "By Container" , -1 );
                 } 
              break;

          }
     }
     
     function t1sheet1_OnClick(sheetObj, row, col){
    	 switch(sheetObj.ColSaveName(col)){
    	 case "rcc_cd":
    	 case "cnmv_corr_rsn_nm":
    		 var mark = sheetObj.CellValue(row, col);
    		 if(mark == "0" || mark == "1"){
    			 toggleExpand(sheetObj, row, col);
    		 }
    		 break;
    	 }
     }
     
    function t2sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
	    	case "rcc_cd":
	    	case "lcc_cd":
	    	case "cnmv_corr_rsn_nm":
				var mark = sheetObj.CellValue(row, col);
				if(mark == "0" || mark == "1"){
					toggleExpand(sheetObj, row, col);
				}
				break;
		}
   	}

    function t3sheet1_OnClick(sheetObj, row, col){
    	switch(sheetObj.ColSaveName(col)){
    	case "rcc_cd":
    	case "lcc_cd":
    	case "org_yd_cd":
    	case "cnmv_corr_rsn_nm":
    		var mark = sheetObj.CellValue(row, col);
    		if(mark == "0" || mark == "1"){
    			toggleExpand(sheetObj, row, col);
    		}
    		break;
    	}
    }
    
    function toggleExpand(sheetObj, row, col){
    	var mark = sheetObj.CellValue(row, col);
 		if(sheetObj.RowExpanded(row)){
 			sheetObj.RowExpanded(row) = false;
 			ChangeValue2(sheetObj, row, col, "0");
 		}else{
 			sheetObj.RowExpanded(row) = true;
 			ChangeValue2(sheetObj, row, col, "1");
 		}
    }
    
    function ChangeValue2(sheetObj, row, col, val){
		with(sheetObj){
			CellValue2(row, col) = val;
		}
	}


	/**
	 * Sheet관련 프로세스 처리
     */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
		case IBSEARCH : // 조회
			if (validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH;

				if (formObj.p_lcc_cd.Code != "") {
					var tempCds = formObj.p_lcc_cd.Code.split(",");
					var lccCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							lccCds.push("'" + tempCds[i] + "'");
						}
					}
					if (lccCds.length > 0) {
						formObj.lcc_cd.value = lccCds.join(",")
					} else {
						formObj.lcc_cd.value = "";
					}
				}

				if (formObj.yard_cd2.Code != "") {
					var tempCds = formObj.yard_cd2.Code.split(",");
					var yardCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							yardCds.push("'" + formObj.yard_cd1.value + tempCds[i] + "'");
						}
					}
					if (yardCds.length > 0) {
						formObj.org_yd_cd.value = yardCds.join(",")
					} else {
						formObj.org_yd_cd.value = "";
					}
				}
				sheetObj.DoSearch("EES_CTM_0436GS.do", FormQueryString(formObj));
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
			}
			break;
		case SEARCH03 :
			if (validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH03;

				if (formObj.p_lcc_cd.Code != "") {
					var tempCds = formObj.p_lcc_cd.Code.split(",");
					var lccCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							lccCds.push("'" + tempCds[i] + "'");
						}
					}
					if (lccCds.length > 0) {
						formObj.lcc_cd.value = lccCds.join(",")
					} else {
						formObj.lcc_cd.value = "";
					}
				}

				if (formObj.yard_cd2.Code != "") {
					var tempCds = formObj.yard_cd2.Code.split(",");
					var yardCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							yardCds.push("'" + formObj.yard_cd1.value + tempCds[i] + "'");
						}
					}
					if (yardCds.length > 0) {
						formObj.org_yd_cd.value = yardCds.join(",")
					} else {
						formObj.org_yd_cd.value = "";
					}
				}
				sheetObj.DoSearch("EES_CTM_0436GS2.do", FormQueryString(formObj));
				sheetObj.ShowTreeLevel(0,1);
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
			}
			break;
		case SEARCH04 :
			if (validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH04;

				if (formObj.p_lcc_cd.Code != "") {
					var tempCds = formObj.p_lcc_cd.Code.split(",");
					var lccCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							lccCds.push("'" + tempCds[i] + "'");
						}
					}
					if (lccCds.length > 0) {
						formObj.lcc_cd.value = lccCds.join(",")
					} else {
						formObj.lcc_cd.value = "";
					}
				}

				if (formObj.yard_cd2.Code != "") {
					var tempCds = formObj.yard_cd2.Code.split(",");
					var yardCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							yardCds.push("'" + formObj.yard_cd1.value + tempCds[i] + "'");
						}
					}
					if (yardCds.length > 0) {
						formObj.org_yd_cd.value = yardCds.join(",")
					} else {
						formObj.org_yd_cd.value = "";
					}
				}
				sheetObj.DoSearch("EES_CTM_0436GS3.do", FormQueryString(formObj));
				sheetObj.ShowTreeLevel(0,1);
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
			}
			break;
		case SEARCH05 :
			if (validateForm(sheetObj,formObj,sAction)) {
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				formObj.f_cmd.value = SEARCH05;

				if (formObj.p_lcc_cd.Code != "") {
					var tempCds = formObj.p_lcc_cd.Code.split(",");
					var lccCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							lccCds.push("'" + tempCds[i] + "'");
						}
					}
					if (lccCds.length > 0) {
						formObj.lcc_cd.value = lccCds.join(",")
					} else {
						formObj.lcc_cd.value = "";
					}
				}

				if (formObj.yard_cd2.Code != "") {
					var tempCds = formObj.yard_cd2.Code.split(",");
					var yardCds = new Array();
					for (var i=0; i<tempCds.length; i++) {
						if (tempCds[i] != "ALL") {
							yardCds.push("'" + formObj.yard_cd1.value + tempCds[i] + "'");
						}
					}
					if (yardCds.length > 0) {
						formObj.org_yd_cd.value = yardCds.join(",")
					} else {
						formObj.org_yd_cd.value = "";
					}
				}
				sheetObj.DoSearch("EES_CTM_0436GS4.do", FormQueryString(formObj));
				sheetObj.ShowTreeLevel(0,1);
				ComOpenWait(false);
				sheetObj.WaitImageVisible = true;
			}
			break;
		case SEARCH01 : // RCC list 조회
			formObj.f_cmd.value = SEARCH01;

			rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
			if (rtn == "") return;
			rtn = ComGetEtcData(rtn, "rtn");
			rtn = "ALL|0^" + rtn;

			rtnList = rtn.split("^");
			formObj.rcc_cd.RemoveAll();

			for (i=0; i<=rtnList.length; i++) {
				if (rtnList[i]) {
					rtnValue = rtnList[i].split("|");
					formObj.rcc_cd.InsertItem(i, rtnValue[0], rtnValue[0]);
				}
			}
			formObj.rcc_cd.Code = "ALL";
			break;
		case SEARCH02 : // LCC list 조회
			formObj.f_cmd.value = SEARCH02;

			rtn = sheetObj.GetSearchXml("EES_CTM_0418GS.do", FormQueryString(formObj));
			if (rtn == '') return;

			rtn = ComGetEtcData(rtn, "rtn");
			rtn = "ALL^" + rtn;
			rtnList = rtn.split("^");
			formObj.p_lcc_cd.RemoveAll();

			for (i=0; i<=rtnList.length; i++) {
				if (rtnList[i]) {
					formObj.p_lcc_cd.InsertItem(i, rtnList[i], rtnList[i]);
				}
			}
			formObj.p_lcc_cd.Code = "ALL";
			break;
		case SEARCH11 : // Yard code 2
			if (formObj.yard_cd1.value.length > 4) {
				xml = sheetObj.GetSearchXml("CTMCommonGS.do", "f_cmd=" + SEARCH11 + "&p_yard1=" + formObj.yard_cd1.value);
				rtnValue = ComGetEtcData(xml, "rtnValue");
				rtnValue = "ALL|ALL|^" + rtnValue;
				parseYardMultiCombo(rtnValue, document.getElementById("yard_cd2"));
				formObj.yard_cd2.Code = "ALL";
			}
			break;
		}
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction){
		with (formObj) {
			if (sAction == IBSEARCH || sAction == SEARCH03) {
				if (formObj.divflag[0].checked == true) {
					if (ComGetDaysBetween(formObj.event_from_dt.value, formObj.event_to_dt.value) > 365) {
						ComShowMessage("Please check period. The maximum period is 1 year");
						return false;
					}
				} else {
					if (ComGetDaysBetween(formObj.upt_from_dt.value, formObj.upt_to_dt.value) > 365) {
						ComShowMessage("Please check period. The maximum period is 1 year");
						return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * Form의 Conrol 초기화 및 초기 이벤트 등록
	 */
	function initControl() {}
	
 	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tabLayer");
		for(var i = 0 ; i < objs.length ; i++){
			objs[i].style.display = "none";
		}
		objs[nItem].style.display = "Inline";
		beforetab = nItem;
		
		if(nItem==0){			
			beforetab = 1;
		}else if(nItem==1){
			beforetab = 2;
		}else if(nItem==2){
			beforetab = 3;
		}else if(nItem==3){
			beforetab = 4;
		}
		
	}
	
	

     /**
      * IBSheet의 GetSearchXml함수를 통해 가져온 XML데이터를
      * HTML Input Select Object의 option으로 insert
      *
      * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
      * @param {object} Select Object 필수, insert하고자 하는 HTML Input Select Object.
      * @param {string} textCol 필수, xmlStr 중 Text컬럼명.
      * @param {string} codeCol 필수, xmlStr 중 Code컬럼명.
      * @param {boolean} firstNull 선택, 첫번째 Item에 Null Item 생성여부
      * @return {boolean} Select Object의 option생성 실패시 false return.
      */
     function Xml2SelectItem(xmlStr, selectObj, textCol, codeCol, firstNull) {
         if (xmlStr == null || xmlStr == "" || selectObj == null || selectObj == "") return false;
         if (DecideErrXml(sheetObjects[0], xmlStr))return false;
         if (codeCol == null || codeCol == "" || textCol == null || textCol == "") return false;
         if (!firstNull || firstNull == null) firstNull == false;

         try {
             // Select Object Clear
             ComClearCombo(selectObj);

             var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
             xmlDoc.loadXML(xmlStr);

             var xmlRoot = xmlDoc.documentElement;
             if (xmlRoot == null) return false;

             var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
             if (dataNode == null || dataNode.attributes.length < 3) return false;

             var colArr = dataNode.getAttribute("COLORDER").split("|");
             var sep = dataNode.getAttribute("COLSEPARATOR");
             var total = dataNode.getAttribute("TOTAL");

             var dataChildNodes = dataNode.childNodes;
             if (dataChildNodes == null) return false;

             // code/text에 해당하는 컬럼index 추출
             var codeColIdx = 0;
             var textColIdx = 0;
             for (var i=0; i<colArr.length; i++) {
                 if (colArr[i] == codeCol) {
                     codeColIdx = i;
                 }
                 if (colArr[i] == textCol) {
                     textColIdx = i;
                 }
             }

             // firstNull이 true이면 null item생성
             if (firstNull) {
                 ComAddComboItem(selectObj, "ALL", "");
                 selectObj.options[0].selected = true;
             }
             // 컬럼index로  code/text 내용추출
             for (var i=0; i<dataChildNodes.length; i++) {
                 if (dataChildNodes[i].nodeType != 1) continue;
                 var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);
                 // Select Object에 item생성
                 ComAddComboItem(selectObj, arrData[textColIdx], arrData[codeColIdx]);
             }
             // 첫번째 항목 선택
             if (selectObj.options.length > 0) {
                 selectObj.options[0].selected = true;
             }
             return true;

         } catch (err) {
             ComFuncErrMsg(err.message);
         }
     }
     
     /**
      * IBSheet의 결과xml에 에러가 있으면 IBSheet를 통해 Alert
      *
      * @param {string} shtObj 필수, IBSheet Object
      * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
      * @return {Boorean}
      */
     function DecideErrXml(shtObj, xmlStr) {
         if (shtObj == null || shtObj == "" || xmlStr == null || xmlStr == "") return;
         if (ComGetEtcData(xmlStr, "TRANS_RESULT_KEY") == "F") {
             shtObj.LoadSearchXml(xmlStr);
             return true;    // Error일때
         } else {
             return false;
         }
     }
     
     /**
      * Form Element의 OnChange 이벤트
      */
     function frmObj_OnChange() {
         var elementName = window.event.srcElement.getAttribute("name");
         var shtObj = sheetObjects[0];
         with (document.form) {
             switch (elementName) {

                 case "rhq_cd_disp":    // RHQ를 변경시 Office목록을 setting
                     if (rhq_cd_disp.value == "") {
                         ComClearCombo(ofc_cd);
                         ComAddComboItem(ofc_cd, "ALL", "");
                         return;
                     }
                     rhq_cd.value = rhq_cd_disp.value;
                     doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
                     break;
             }
         }
     }
     
     function classToggle(){
 		var formObj = document.form;
 		if(document.form.divflag[0].checked == true){ // Period 가 선택
 			formObj.event_from_dt.className     = "input1";
            formObj.event_to_dt.className       = "input1";
            
            formObj.upt_from_dt.className     = "input";
            formObj.upt_to_dt.className       = "input";
            
            //formObj.upt_from_dt.
            
 		}else{ // VVD 가 선택 
 			formObj.event_from_dt.className     = "input";
            formObj.event_to_dt.className       = "input";
            
            formObj.upt_from_dt.className     = "input1";
            formObj.upt_to_dt.className       = "input1";
 		} 
     }
     
     /**
      * Sheet3의 OnMouseDown 이벤트 처리
      */
     function t1sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
         with(sheetObj) {
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 0){
         		sheetObj.ShowTreeLevel(0,1);
         		t1Ccrn = 0;
         	}
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 1){
        		if(t1Ccrn == 0){
        			sheetObj.ShowTreeLevel(-1);
        			t1Ccrn = 1;
        		}else{
        			sheetObj.ShowTreeLevel(0,1);
        			t1Ccrn = 0;
        		}
        		
        	}
         }
     }

     /**
      * Sheet2의 OnMouseDown 이벤트 처리
      */
     function t2sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
         with(sheetObj) {
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 0){
         		sheetObj.ShowTreeLevel(0,1);
         		t2Lcc = 0;
    			t2Ccrn = 0;
         	}
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 1){
        		if(t2Lcc == 0){
        			sheetObj.ShowTreeLevel(2,1);
        			t2Lcc = 1;
        			t2Ccrn = 0;
        		}else{
        			sheetObj.ShowTreeLevel(0,1);
        			t2Lcc = 0;
        			t2Ccrn = 0;
        		}
        		
        	}
        	
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 2){
        		if(t2Ccrn == 0){
        			sheetObj.ShowTreeLevel(-1);
        			t2Lcc = 1;
        			t2Ccrn = 1;
        		}else{
        			sheetObj.ShowTreeLevel(2,1);
        			t2Lcc = 1;
        			t2Ccrn = 0;
        		}
        		
       	 	}
         }
     }
     
     /**
      * Sheet1의 OnMouseDown 이벤트 처리
      */
     function t3sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
         with(sheetObj) {
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 0){
         		sheetObj.ShowTreeLevel(0,1);
         		t3Lcc = 0;
    			t3Yard = 0;
    			t3Ccrn = 0;
         	}
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 1){
        		if(t3Lcc == 0){
        			sheetObj.ShowTreeLevel(2,1);
        			t3Lcc = 1;
        			t3Yard = 0;
        			t3Ccrn = 0;
        		}else{
        			sheetObj.ShowTreeLevel(0,1);
        			t3Lcc = 0;
        			t3Yard = 0;
        			t3Ccrn = 0;
        		}
        		
        	}
        	
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 2){
        		if(t3Yard == 0){
        			sheetObj.ShowTreeLevel(3,1);
        			t3Lcc = 1;
        			t3Yard = 1;
        			t3Ccrn = 0;
        		}else{
        			sheetObj.ShowTreeLevel(2,1);
        			t3Lcc = 1;
        			t3Yard = 0;
        			t3Ccrn = 0;
        		}
        		
       	 	}
        	
        	if((MouseRow == 0 || MouseRow == 1 || MouseRow == 2) && MouseCol == 3){
        		if(t3Ccrn == 0){
        			sheetObj.ShowTreeLevel(-1);
        			t3Lcc = 1;
        			t3Yard = 1;
        			t3Ccrn = 1;
        		}else{
        			sheetObj.ShowTreeLevel(3,1);
        			t3Lcc = 1;
        			t3Yard = 1;
        			t3Ccrn = 0;
        		}
       	 	}
         }
     }
     
     function t4sheet1_OnClick(sheetObj, Row, Col, Value) {
    	if (Col != 33) return;
    	var key_yn = sheetObj.CellValue(Row, "atch_file_sav_yn");
    	
    	if(key_yn == 'Y'){
    		var key_id = sheetObj.CellValue(Row, "atch_file_sav_id");
    		hiddenFrame.location.href = "/hanjin/FileDownload?key=" + key_id;
    	}
		
		return;
	}

	function t4sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		//event date : 10
		for(var i=1; i<=sheetObj.LastRow; i++){
			var cngYn = sheetObj.CellValue(i, "cng_yn");
			var cnmv_his_col_nm = sheetObj.CellValue(i, "cnmv_his_col_nm");
			var correction_type = sheetObj.CellValue(i, "correction_type")
			if(cngYn == 'Y'){
				var colArray = cnmv_his_col_nm.split(":");
				for(var k=0;k<colArray.length;k++){
					if(colArray[k] != 'ofc_cd' && colArray[k] != 'usr_nm'){
						sheetObj.CellBackColor(i,colArray[k]) = sheetObj.RgbColor(255, 246, 18);
					}else{
						if(colArray[k] == 'vndr'){
							sheetObj.CellBackColor(i,"vndr_abbr_nm") = sheetObj.RgbColor(255, 246, 18);
						}else if(colArray[k] == 'org_yd_cd'){
							sheetObj.CellBackColor(i,"rcc_cd") = sheetObj.RgbColor(255, 246, 18);
							sheetObj.CellBackColor(i,"lcc_cd") = sheetObj.RgbColor(255, 246, 18);
						}
					}
				}
			}
			if(correction_type == 'Insert' || correction_type == 'Delete'){
				sheetObj.CellBackColor(i,"correction_type") = sheetObj.RgbColor(255, 246, 18);
			}
			if(sheetObj.CellValue(i,"atch_file_sav_yn") =='Y'){
    			sheetObj.CellImage(i,"atch_file_sav_yn") = "atch_file_sav_yn";
    		}
			
			
		}
		
    	ComOpenWait(false);
        sheetObj.WaitImageVisible = true;       
	   	//sheetObj.SelectHighLight = t;
	   	sheetObj.Redraw = true;
	}
	
	function t4sheet1_OnMouseMove(sheetObj, ErrMsg){
	}
	
	function t3sheet1_OnMouseMove(sheetObj, ErrMsg){
	}
	
	function t2sheet1_OnMouseMove(sheetObj, ErrMsg){
	}
	
	function t1sheet1_OnMouseMove(sheetObj, ErrMsg){
	}

	/**
	 * RCC Change Event.
	 */
	function rcc_cd_Change(event) {
		doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
	}

	/**
	 * Yard Keyup Event.
	 * @param event
	 */
	function yard_cd1_Keyup(event) {
		var eventElement = event.srcElement;
		eventElement.value = eventElement.value.toUpperCase();

		if (eventElement.value.length < 5) {
			document.form.yard_cd2.RemoveAll();
			return;
		}
		doActionIBSheet(sheetObjects[0], document.form, SEARCH11);
	}
