/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0257.js
*@FileTitle : ESM_BKG_0257
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.21 경종윤
* 1.0 Creation
* ------------------------------------------------------
* History
* 2011.11.07 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청	
* 2012.04.02 김보배 [CHM-201217042] [BKG] [EUR Customs EDI화면] EXS MRN / Export MRN 추가 - U/I 및 Flat file 업데이트
* 2013.05.30 김보배 [CHM-201324949] EU customs EDI 화면 수정 및 Receiver ID 추가요청
* 2013.06.12 김보배 [CHM-201324260] Europe customs EDI 상 Receiver ID 등록 요청
* 2013.07.03 김보배 [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory 설정요청
* 2013.07.22 김보배 [CHM-201325859] EU customs EDI 화면상 Receiver ID 추가 요청
* 2013.07.22 김보배 [CHM-201325970] EU customs EDI 상 CNTR display 오류 수정요청
* 2013.09.16 김보배 [CHM-201326134] DE 요청사항 #1,2 (EU customs EDI and CTA Transmit history 상 Partial mark 추가)
* 2013.11.29 김보배 [CHM-201327231] [EU Manifest] EU customs EDI 화면상 export(outbound) 전송 버튼 추가 요청
* 2014.03.21 김보배 [CHM-201428553] Split 01-[IRELAND] E-Manifest 개발 요청
* 2014.04.28 김보배 [CHM-201429945] EU customs EDI 상 FR manifest 에 대한 Mandatory item 수정 요청
* 2014.50.30 김보배 [CHM-201430490] EU customs EDI 상 Receiver ID 추가 및 변경 요청[FR customs]
* 2014.11.13 [CHM-201432484] [FR/EDI/#3] EDI Developement - CELTIC Customs
* 2015.09.04 [CHM-201537804] RE: New Customs Rules  DSDT  for Inbound Cargo to France
* 2015.11.03 [CHM-201538543] Commercial Manifest for FR  CELTIC 
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
     * @class ESM_BKG_0257 : ESM_BKG_0257 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0257() {
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
	var sheetCnt = 0;
	
    var comboObjects = new Array();
    var comboCnt = 0;
    
    //전역변수
    var intervalId = "";
    
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	         var sheetObject1 = sheetObjects[0];
	         var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
                                          
           switch(srcName) {
           	
	           case "mode_type":
	      			if(form.mode_type[0].checked){
						form.pol_cd.className = "input1";
						form.pod_cd.className = "input";
					}else if(form.mode_type[1].checked){
						form.pol_cd.className = "input";
						form.pod_cd.className = "input1";
					} 
				break;
				
           		case "btn_retrieve":
					doActionIBSheet(sheetObjects[1],formObject,SEARCH08);
				break;
	
           		case "btn_new":
           			doActionIBSheet(sheetObjects[1], formObject, IBCLEAR);
           			break; 

           		case "btn_DownExcel":
					doActionIBSheet(sheetObjects[1], formObject, IBDOWNEXCEL);
				break; 
					
				case "btn_transmit":
					doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
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
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * 콤보 Object를 comboObjects 배열에 등록
     * @param combo_obj
     * @return
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
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
	        //시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			
			initSheet(sheetObjects[i],i+1);
	        //마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//MultiCombo초기화 -- 2014.11.13 추가
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].id);
	    }
	    
		//화면에서 필요한 이벤트
    	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    	//axon_event.addListenerForm ('beforedeactivate', 'obj_deactivate',  document.form); //- 포커스 나갈때    	
    	axon_event.addListenerForm ('change', 'obj_change',  document.form); //- change    	
    	
    	// UVI 필드 초기화
	    formObj.uvi.readOnly = true;
	    formObj.uvi.style.backgroundColor= "#E8E7EC";
	    
	    doActionIBSheet(sheetObjects[0],formObj,INIT);

	}
    
 	/**
  	 * Combo 기본 설정 
  	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
  	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	* @param {String} comboId 필수,combo ID
 	* @return 없음. 
  	 */ 
  	function initCombo(comboObj, comboId) {
  	    var formObject = document.form
  	    
  	    var cnt = 0;	
  		switch(comboObj.id) {
	  		case "p_type":
	  			with (comboObj) {
		 			DropHeight = 300;
					MultiSelect = false;
					UseEdit = false;
					InsertItem(cnt ++, "General Cargo Manifest",  "GCM");
					InsertItem(cnt ++, "Commercial Manifest for FR", "FR");
					Code = "GCM";				
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
                with (sheetObj) {

                    // 높이 설정
                    style.height = 220;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    var HeadTitle = "|flatFile";
					var headCount = ComCountHeadTitle(HeadTitle);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	 0,    daCenter, 	false,    "ibflag");
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		false,	  "flat_file",	false,			"",      dfNone,	0,		false,		false);
					
					CellSpeedOption="NOFORMAT";
				}
                break;
                
                
        case 2:      //sheet2 init
            with (sheetObj) {
            	
            	// 높이 설정
				style.height = 320;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
				
				var HeadTitle1 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|POL|POD|POL|POD|B/POL|B/POD|DEL|HS Code|Cargo Desc.|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|ERR_YN|LANE|BKG_CGO_TP_CD";
		        var HeadTitle2 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|POL|POD|POL|POD|B/POL|B/POD|DEL|HS Code|Cargo Desc.|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|ERR_YN|LANE|BKG_CGO_TP_CD";
		        var headCount = ComCountHeadTitle(HeadTitle1);
				
				headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 5, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(false, false, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
		        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
				InitDataProperty(0, cnt++ , dtData,			40,	daCenter,  true,  "dt_seq",	   false,  "",  dfNone,	 0,  false,  false);
				InitDataProperty(0, cnt++,  dtDummyCheck,   40, daCenter,  true,  "sel",       false,  "",  dfNone,  0,  true,   false);
				InitDataProperty(0, cnt++ , dtData,   90,  daCenter,  true,  "bl_no",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   90,  daCenter,  true,  "cntr_nos",   	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "cntr_prt_flg",   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden, 60,  daCenter,  true,  "pol_cd",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden, 60,  daCenter,  true,  "pod_cd",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  true,  "pol_yd_cd",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  true,  "pod_yd_cd",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "b_pol_cd",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "b_pod_cd",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "del_cd",         false,  "",  dfNone,  0,  false,  false);
				
				InitDataProperty(0, cnt++ , dtData,   70,  daCenter,  true,  "hs_cd",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   120,  daLeft,   true,  "cgo_desc",       false,  "",  dfNone,  0,  false,  false);
				
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_nm",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_ad",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_ct",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_cn",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_zip",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_str",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_eori",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_nm",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_ad",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_ct",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_cn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_zip",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_str",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_eori",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_nm",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_ad",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_ct",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_cn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_zip",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_str",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_eori",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "pofe",           false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "pofe_eta",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "mrn",            false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "exs_mrn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "export_mrn",     false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "dr_yn",    	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "bkg_no",    	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "err_yn",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden, 80,  daCenter,  true,  "slan_cd",		   false,  "",  dfNone,  0,  false,  false);
				//2015.11.03 add.
				InitDataProperty(0, cnt++ , dtHidden, 120,   daLeft,  true,  "bkg_cgo_tp_cd",  false,  "",  dfNone,  0,  false,  false);
				
				CountPosition = 0;
				
				SetSortDialog(false	);
				//ActionMenu = "Check selected|Unheck selected"
				SelectHighLight= true;
			    MultiSelection = true;
			    SelectionMode = smSelectionRow;
			    
			    WordWrap = true;

           }
           break;
            case 3:      //sheet3 init
            with (sheetObj) {
            	
            	// 높이 설정
				style.height = 300;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;
				
				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				
				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msPrevColumnMerge + msHeaderOnly; -- msAll
				MergeSheet = msPrevColumnMerge + msHeaderOnly;//msPrevColumnMerge;
				
				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;
				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);
								
				var HeadTitle1 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|POL|POD|POL|POD|B/POL|B/POD|DEL|HS Code|Cargo Desc.|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|ERR_YN|BKG_CGO_TP_CD";
		        var HeadTitle2 = "|Seq.|Sel.|B/L No|CNTR  No|Partial|POL|POD|POL|POD|B/POL|B/POD|DEL|HS Code|Cargo Desc.|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|POFE|POFE ETA|ENS MRN|EXS MRN|Export MRN||BKG_NO|ERR_YN|BKG_CGO_TP_CD";
		        var headCount = ComCountHeadTitle(HeadTitle1);
				
				headCount = ComCountHeadTitle(HeadTitle1);
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 5, 0, true);
				
				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				//([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D])
				InitHeadMode(false, false, true, true, false,false);
				
				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
		        //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++,  dtHiddenStatus, 0, 	daCenter,  true, "ibflag");
				InitDataProperty(0, cnt++ , dtData,			40,	daCenter,  true,  "dt_seq",	   false,  "",  dfNone,	 0,  false,  false);
				InitDataProperty(0, cnt++,  dtCheckBox,   40, daCenter,  true,  "sel",       false,  "",  dfNone,  0,  true,   false);
				InitDataProperty(0, cnt++ , dtData,   90,  daCenter,  true,  "bl_no",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   90,  daCenter,  true,  "cntr_nos",   	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "cntr_prt_flg",   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden, 50,  daCenter,  true,  "pol_cd",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden, 50,  daCenter,  true,  "pod_cd",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  true,  "pol_yd_cd",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   60,  daCenter,  true,  "pod_yd_cd",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "b_pol_cd",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "b_pod_cd",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "del_cd",         false,  "",  dfNone,  0,  false,  false);
				
				InitDataProperty(0, cnt++ , dtData,   70,  daCenter,  true,  "hs_cd",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   120, daLeft,  true,  "cgo_desc",       false,  "",  dfNone,  0,  false,  false);
				
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_nm",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_ad",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_ct",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_cn",          false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_zip",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_str",         false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "sh_eori",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_nm",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_ad",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_ct",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_cn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_zip",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_str",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "cnee_eori",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_nm",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_ad",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_ct",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_cn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_zip",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_str",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   40,  daCenter,  true,  "ntfy_eori",      false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,   50,  daCenter,  true,  "pofe",           false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  100,  daCenter,  true,  "pofe_eta",       false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "mrn",            false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "exs_mrn",        false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtData,  120,  daCenter,  true,  "export_mrn",     false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "dr_yn",    	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "bkg_no",    	   false,  "",  dfNone,  0,  false,  false);
				InitDataProperty(0, cnt++ , dtHidden,100,  daCenter,  true,  "err_yn",         false,  "",  dfNone,  0,  false,  false);
				
				//2015.11.03 add.
				InitDataProperty(0, cnt++ , dtHidden,   120, daLeft,  true,  "bkg_cgo_tp_cd",       false,  "",  dfNone,  0,  false,  false);
				
				CountPosition = 0;
				
				SetSortDialog(false	);
				//ActionMenu = "Check selected|Unheck selected"
				SelectHighLight= true;
			    MultiSelection = true;
			    SelectionMode = smSelectionRow;

           }
           break;
                 
        }
    }
    
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case INIT : // receiver id 콤보값 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", FormQueryString(formObj));
				//ComXml2ComboItem(sXml, formObj.receiver, "val", "desc");
				ComXml2ComboItem(sXml, formObj.receiver, "val", "name");
				formObj.receiver.InsertItem(0, "", "");
				
				//country 콥보박스 데이터 설정 2014.10.10 csy						
				var cnt_list = ComGetEtcData(sXml,"cnt_cd").split("|");
				for(var i = 0 ; i < cnt_list.length ; i++) {					
					formObj.cnt_cd.InsertItem(i, cnt_list[i], cnt_list[i]);
				}
				formObj.cnt_cd.InsertItem(0, "", "");
				
				// Add: 2014.11.13 [CHM-201432484]
				sheetObjects[1].ColHidden("hs_cd") = true;
				sheetObjects[1].ColHidden("cgo_desc") = true;
				sheetObjects[2].ColHidden("hs_cd") = true;
				sheetObjects[2].ColHidden("cgo_desc") = true;
				
				break;
				
			case SEARCH08: // 

				ComSetFocus(formObj.f_cmd);
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				sheetObj.Redraw = false;
				sheetObjects[1].WaitImageVisible = true;
//				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH08;
								
				if(formObj.check_frob_search.checked) {
					formObj.check_frob_search.value = "Y";
				}
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", FormQueryString(formObj));
					
				if (ComBkgErrMessage(sheetObj, sXml)) {
					formObj.vvd_nm.value    = (ComGetEtcData(sXml,"vvd_nm") != undefined ? ComGetEtcData(sXml,"vvd_nm") : "") ;
					formObj.vvd_ld.value    = (ComGetEtcData(sXml,"vvd_ld") != undefined ? ComGetEtcData(sXml,"vvd_ld") : "") ;
					formObj.vvd_call.value  = (ComGetEtcData(sXml,"vvd_call") != undefined ? ComGetEtcData(sXml,"vvd_call") : "") ;
					formObj.eta.value    	= (ComGetEtcData(sXml,"eta") != undefined ? ComGetEtcData(sXml,"eta") : "") ;
					formObj.etd.value    	= (ComGetEtcData(sXml,"etd") != undefined ? ComGetEtcData(sXml,"etd") : "") ;

					sheetObj.LoadSearchXml(sXml);
				}
				
				sheetObjects[1].CheckAll2("sel") = 0;
				formObj.p_ori_amd_cd[0].checked = true;
				
				// Add: 2014.11.13 [CHM-201432484]				
				if (formObj.p_type.Code=="FR") {
					sheetObjects[1].ColHidden("hs_cd") = false;
					sheetObjects[1].ColHidden("cgo_desc") = false;
					sheetObjects[2].ColHidden("hs_cd") = false;
					sheetObjects[2].ColHidden("cgo_desc") = false;
					
				} else {
					sheetObjects[1].ColHidden("hs_cd") = true;
					sheetObjects[1].ColHidden("cgo_desc") = true;
					sheetObjects[2].ColHidden("hs_cd") = true;
					sheetObjects[2].ColHidden("cgo_desc") = true;					
				}
				
//				ComOpenWait(false);
				sheetObj.Redraw = true; 
				sheetObjects[1].WaitImageVisible = false;
				break;

			case IBDOWNEXCEL:
				
				if (!validateForm(sheetObj,formObj,sAction)) return;
				ComOpenWait(true);

				sheetObjects[2].RemoveAll();
				sheetObj.Copy2SheetCol(sheetObjects[2],"","",-1,-1,-1,2,true,false,"sel","");
				
				if(sheetObjects[2].RowCount) {
					sheet3_OnSearchEnd(sheetObjects[2], "");
				}

				sheetObjects[2].SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "sel", "");
				ComOpenWait(false);
				break;
				
			case IBCLEAR: // 폼과 시트의 값 삭제
				
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				formObj.reset();
				formObj.vvd_cd.focus();
				formObj.uvi.value = "";
				
				formObj.mode_type[1].checked;
				formObj.pol_cd.className = "input";
				formObj.pod_cd.className = "input1";
				
				// Add: 2014.11.13 [CHM-201432484]
				formObj.p_type.Code = "GCM"; 
				formObj.cnt_cd.Enable = true; 
				formObj.ts_tp_cd.value="";
				formObj.check_frob_search.disabled=false;
				
				//p_type선택 후 country를 null로 바꿔야지 receiver쪽이 재 조회되서 여기에 위치시킴
				comboObjects[1].Code = ""; // formObj.cnt_cd
				
				sheetObjects[1].ColHidden("hs_cd") = true;
				sheetObjects[1].ColHidden("cgo_desc") = true;
				sheetObjects[2].ColHidden("hs_cd") = true;
				sheetObjects[2].ColHidden("cgo_desc") = true;
				
				break;

			case IBSAVE: // EDI FLAT FILE 생성 및 전송
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				// 전송할 대상 B/L존재여부를 조회한다.
//				formObj.f_cmd.value = SEARCH07;
//				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", FormQueryString(formObj));
//	    		var targetListYn = ComGetEtcData(sXml, "targetListYn");
//
//	    		if(targetListYn == "N") {
//	    			//ComShowMessage("전송할 대상 B/L이 없습니다.");
//					ComShowCodeMessage("BKG06114");
//					return false;
//	    		}
				
				
				if(!ComShowConfirm(ComGetMsg("BKG95003", "Transmit"))) {
	            	return false;
	            }
				

				ComOpenWait(true);
				
				var rowCnt = sheetObj.RowCount;

				for(var i=1; i<=rowCnt+1; i++) {
					if(sheetObj.CellValue(i, "sel") == 1) {
						sheetObj.RowStatus(i) = "I";
					} else {
						sheetObj.RowStatus(i) = "";
					}
				}

				var sParam = "";
				var sParamSheet = sheetObj.GetSaveString();

				if (sParamSheet != "") {
					sParam += "&" + sParamSheet;
				}
								
				
				// 전송한다.
				formObj.f_cmd.value = MULTI;
							
				if (document.form.mode_type[0].checked){
					formObj.search_pod_cd.value = formObj.pol_cd.value;
				}else{
					formObj.search_pod_cd.value = formObj.pod_cd.value;
				}
				
				sParam += "&" + FormQueryString(formObj);
				
 				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", sParam)
 				//ComOpenWait(false);
 				
				//formObj.output.value = ComGetEtcData(sXml, "flatFile");
				//sheetObj.LoadSaveXml(sXml);
				
				var key = ComGetEtcData(sXml, "KEY");
				//ComShowMessage(key);
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				break;
				
			case SEARCH05 : // uvi 조회
				
				if(!validateForm(sheetObj,formObj,sAction))return;
				
				formObj.f_cmd.value = SEARCH05;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", FormQueryString(formObj));
	    		var uvi = ComGetEtcData(sXml, "uvi");

				formObj.uvi.value = uvi;
				break;
			
			case SEARCH09 : //Country 콤버 변경시 receiver id 콤보 조회	2014.10.10 csy		    
		 	    
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do?f_cmd="+SEARCH09+"&key="+ComGetObjValue(formObj.cnt_cd));
		 	    ComXml2ComboItem(sXml, formObj.receiver, "val", "name");
                
		 	    // Add : 2014.11.13 CHM-201432484
		 	    if(formObj.p_type.Code=="FR"){			 
		 	    	formObj.receiver.UseCode = false;
		 	    	var maxCnt = formObj.receiver.GetCount();
		 	    	for (var i=maxCnt; i >= 0 ; i--) {
		 	    		var iValue = formObj.receiver.GetIndexText(i,0).indexOf("CELTIC");
		 	    		
		 	    		var sValue = formObj.receiver.GetIndexText(i,0).indexOf("LEH-DSDT");
		 	    		var tValue = formObj.receiver.GetIndexText(i,0).indexOf("FOS-DSDT");
		 	    		
		 	    		if(iValue == -1 && sValue == -1 && tValue == -1 ){
		 	    			formObj.receiver.DeleteItem(i);		        		
		 	    		}
		 	    	}
			    }else if(formObj.p_type.Code=="GCM"){			 
				    formObj.receiver.UseCode = false;
			        var maxCnt = formObj.receiver.GetCount();
			        for (var i=maxCnt; i >= 0 ; i--) {
			        	var iValue = formObj.receiver.GetIndexText(i,0).indexOf("CELTIC");
			        	
			        	var sValue = formObj.receiver.GetIndexText(i,0).indexOf("LEH-DSDT");
		 	    		var tValue = formObj.receiver.GetIndexText(i,0).indexOf("FOS-DSDT");
		 	    		
			        	if(iValue != -1 || sValue != -1 || tValue != -1){
			        		formObj.receiver.DeleteItem(i);		        		
			        	}
			        }
			 	}
		 	 
		 	    formObj.receiver.InsertItem(0, "", "");
		 	    formObj.receiver.UseCode = true;
		 	 
				break;
        }
        
    }
    
    /**
     * BackEndJob 실행결과조회<br>
     * 
     * @param sheetObj
     * @param sKey
     */
    function doActionValidationResult(sheetObj, sKey) {
    	//ComShowMessage("1");
    	var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	var sJbStsFlg = ComGetEtcData(sXml, "jb_sts_flg");

    	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
    	
    	// 에러가 발생했을 경우 대기사항을 종료한다.
    	if (!ComBkgErrMessage(sheetObj, sXml)) {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		return;
    	}
    	if (sJbStsFlg == "SUCCESS") {
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 성공메시지 보여주고
    		ComShowCodeMessage('BKG00101');	
    		return;
    	} else if (sJbStsFlg == "FAIL") {
    		//에러
    		clearInterval(intervalId);
    		ComOpenWait(false);
    		// 에러메시지 보여주고
    		ComShowMessage(ComResultMessage(sXml));
    	}
    }
    
    
    
    
    function baseValidation(sheetObj,formObj,sAction){

    	//기본포멧체크
		//if (!ComChkValid(formObj)) return false;
		
    	if ( ComIsNull(formObj.vvd_cd)) {
			ComShowCodeMessage('BKG00626','VVD');
			formObj.vvd_cd.focus();
			return false;	
		}
    	
		var polVal = formObj.pol_cd.value;
		var podVal = formObj.pod_cd.value;

		
		if(podVal == "" && formObj.mode_type[1].checked) {
			ComShowCodeMessage("BKG00210");
			ComSetFocus(formObj.pod_cd);
			return false;
		}else if(polVal == "" && formObj.mode_type[0].checked) {
			ComShowCodeMessage("BKG00209");
			ComSetFocus(formObj.pol_cd);
			return false;
		}
		
		//ComShowMessage(formObj.receiver.text);
		if(formObj.receiver.text == "") {
			//ComShowMessage("RECEIVER ID는 필수 조회 조건입니다.");
			ComShowCodeMessage("BKG06084");
			ComSetFocus(formObj.receiver);
			return false;
		}

		// POL, POL Validation
		formObj.f_cmd.value = SEARCH06;
		var sXml = sheetObj.GetSearchXml("ESM_BKG_0257GS.do", FormQueryString(formObj));
 		var polResult = ComGetEtcData(sXml, "polResult");
 		var podResult = ComGetEtcData(sXml, "podResult");
 		
 		if(polVal != "" && polResult == "") {
 			//alert("polResult : " + polResult);
 			ComShowCodeMessage('BKG06012', polVal);	// {?msg1} is invalid.
 			ComSetFocus(formObj.pol_cd);
 			return false;
 		}
 		if(podVal != "" && podResult == "") {
 			//alert("podResult : " + podResult);
 			ComShowCodeMessage('BKG06012', podVal);	// {?msg1} is invalid.
 			ComSetFocus(formObj.pod_cd);
 			return false;
 		}
 		
 		return true;

     }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	
	    switch(sAction) {
	    
	    	case SEARCH08: { // Retrieve
	    		//기본포멧체크
				//if (!ComChkValid(formObj)) return false;
	    		sheetObjects[0].RemoveAll();
	    		sheetObjects[1].RemoveAll();

	    		if ( ComIsNull(formObj.vvd_cd)) {
					ComShowCodeMessage('BKG00626','VVD');
					formObj.vvd_cd.focus();
					return false;	
				}else if (formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
					ComShowCodeMessage('BKG00626','POL');
					formObj.pol_cd.focus();
					return false;
				}else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
					ComShowCodeMessage('BKG00626','POD');
					formObj.pod_cd.focus();
					return false;
				}
	    		
				break;
	    	}
	
	    	case IBDOWNEXCEL: {
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return false;
		 		}
	    		break;
	    	}
	    	
	    	case SEARCH05: {
	    		return baseValidation(sheetObj,formObj,sAction);
	    		break;
	    	}
			
	    	case IBSAVE: {
			    
				var baseValFlg = false;
	    		baseValFlg = baseValidation(sheetObj,formObj,sAction);
	    		
	    		if(!baseValFlg) return baseValFlg
	    		
	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return false;
	    	 		}
	    		
	    		var errYN = "N";
	    		var arrRow = ComFindText(sheetObj, "sel", 1);
	    		
	    		/*
	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
	    		 * */
	    		var errorCnt = 0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    		var errorBls = "";
	    		
	    			    		
	    		var tempBl = "";
	    		var errBlArray = new Array();
	    		
	    		/*
	    		 * Receiver ID 의 값이 LEH-LCA / LEH-TOS / LEH-HUMTAC / FOS (프랑스 세관 ) 인 경우
	    		 * SHPR / CNEE / NTFY 정보가 없어도 Error B/L 로 구분하지 않음 
	    		 */ 
	    		var frFlg = "N";
	    			    		
	    		if(formObj.receiver.text == "LEH-LCA" || formObj.receiver.text == "LEH-TOS" 
	    			|| formObj.receiver.text == "LEH-HUMTAC" || formObj.receiver.text == "FOS"
	    			|| formObj.receiver.text == "CELTIC-CN-EX" || formObj.receiver.text == "CELTIC-US-EX"
	    			|| formObj.receiver.text == "CELTIC-IM" || formObj.receiver.text == "CELTIC-EX"
	    			|| formObj.receiver.text == "CELTIC-TS"
	    			|| formObj.receiver.text == "FOS-DSDT" || formObj.receiver.text == "LEH-DSDT") {
	 				
	    			frFlg = "Y";
	    			
	    			// Add: 2014.11.13 [CHM-201432484]
	    			if(document.form.p_type.Code == "FR") {
		    			for(var i=0; i<arrRow.length; i++){
		    				 
		    				if(sheetObj.CellValue(arrRow[i], "cgo_desc")=="" && sheetObj.CellValue(arrRow[i], "bkg_cgo_tp_cd")!="P") {
		    					ComShowCodeMessage("BKG01148",sheetObj.CellValue(arrRow[i], "bl_no"));
		    					return false;
		    				}
		    				if(sheetObj.CellValue(arrRow[i], "hs_cd")==""  && sheetObj.CellValue(arrRow[i], "bkg_cgo_tp_cd")!="P"){
		    					ComShowCodeMessage("BKG01147",sheetObj.CellValue(arrRow[i], "bl_no"));
		    					
		    				}
		    			}
		    		}
	    			
	    		}
	    		

	    		if (frFlg == "N"){
	    			for (var i=0; i<arrRow.length; i++) {
	    				
	    				if(sheetObj.CellValue(arrRow[i], "err_yn") == "Y"){
	    					if(errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
	    						errBlArray[sheetObj.CellValue(arrRow[i], "bl_no")] = sheetObj.CellValue(arrRow[i], "bl_no");
	    						
	    						errorCnt++;
	    						if(errorCnt <= 10)
	    							errorBls += sheetObj.CellValue(arrRow[i], "bl_no")+",";
	    					}
	    				}
	    				
	    				if (tempBl== sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
	    				
	    				tempBl = sheetObj.CellValue(arrRow[i], "bl_no");
	    				
	    			}//end for
	    		}

				if(errorCnt > 0){
					errorBls = errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
			    	ComShowCodeMessage("BKG01133",errorBls,"");
			    	return false;
			    }

				break;
			}

	    }
        return true;

    }
    
    /**
     * 조회조건 입력할 때 처리
     */
    function obj_KeyUp() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd") && ComChkLen(srcValue, srcMaxLength) == "2") {
    		ComSetNextFocus();
    	}
    	
    }
    
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function obj_change() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	if ((srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd")) {
    		formObject.receiver.text = ""; // receiver 필드 초기화
    		formObject.receiver_id.text = ""; // receiver_id 필드 초기화
    	} else if(srcName =="ts_tp_cd"){
    		if(formObject.ts_tp_cd.value=="T"){
    			formObject.check_frob_search.checked=false;
    			formObject.check_frob_search.disabled=true;
        	}else{
        		formObject.check_frob_search.disabled=false;
        	}
    		
    	}
    	
    	
    }
   
    
    /**
     * receiver_id콤보 KeyUp Event
     * @param KeyCode
     * @param Shift
     * @return
     */
    function receiver_OnKeyUp(KeyCode, Shift) {
    	/*
    	var formObj = document.form;
    	//ComShowMessage("[" + KeyCode + "]" + "\n[" + String.fromCharCode(Shift) + "]");
    	
    	var downKeyValue = String.fromCharCode(Shift);
    	
    	//ComShowMessage("KeyCode : " + KeyCode + "\ndownKeyValue : " + downKeyValue);
    	
  		if(downKeyValue == "H") {
  			comboObjects[0].Text2 = "HAM";
  			comboObjects[0].Code2 = "HAM";
  		} else if(downKeyValue == "F") {
  			comboObjects[0].Text2 = "FXT";
  			comboObjects[0].Code2 = "FXT";
  		} else if(downKeyValue == "R") {
  			comboObjects[0].Text2 = "RTM";
  			comboObjects[0].Code2 = "RTM";
  		} else {
			comboObjects[0].Text2 = "";
			comboObjects[0].Code2 = "";
  		} 
  		
  		receiver_id_OnChange(comboObjects[0],comboObjects[0].Code,comboObjects[0].Text);
  		*/
 	
    }
    
    /**
     * receiver_id콤보 변경시 처리
     * @param comboObj
     * @param value
     * @param text
     * @return
     */
    function receiver_OnChange(comboObj,value,text) {
    	
    	var formObj = document.form;
  
    	//alert("value : " +value);
    	// 표준코드 3 자리 입력이 원칙이지만 유저 요청에 의해 Full Word 로 Header 에 입력
    	if(value == "LEL") {
			value = "LEH-LCA";
		} else if(value == "LET") {
			value = "LEH-TOS";
		} else if(value == "RTM") {
			value = "NLRTMPCS";
		} else if(value == "FOF") {
			value = "FOS-FIRST";
		} else if(value == "FOB") {
			value = "FOS-SUBSEQ";
		} else if(value == "LEF") {
			value = "LEH-FIRST";
		} else if(value == "LEB") {
			value = "LEH-SUBSEQ";
		} else if(value == "EUG") {
			value = "EXP_EUROGATE";
		} else if(value == "CTT") {
			value = "EXP_CTT";
		} else if(value == "FOS") {
			value = "FOS-SUD";
		} else if(value == "FOT") {
			value = "FOS-TOS";
		} else if(value == "IRV") {
			value = "IEREVENUE";
		}
    	
    	formObj.receiver_id.value = value;
    	
    	if(text == "FXT" || text == "THP" || text == "TEE" || text == "IMM" || text == "GRG")  {
			formObj.uvi.readOnly = false;
			formObj.uvi.style.backgroundColor= "";
			doActionIBSheet(sheetObjects[0],formObj,SEARCH05);
		} else {
			formObj.uvi.readOnly = true;
			formObj.uvi.style.backgroundColor= "#E8E7EC";
			formObj.uvi.value = "";
			
		}
    	
    	if(formObj.receiver_id.value == "IEREVENUE"){
    		ComShowObject(document.all.span_cancel, true); 
    	}else{
    		ComShowObject(document.all.span_cancel, false); 
    	}
    	
    	ComSetFocus(formObj.uvi);
    }   
     
     
     /**
      * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    	 with (sheetObj) {
    		 
    		 if (document.form.mode_type[0].checked){
    			 // pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			 MessageText("SubSum") = "POD";
    			 ShowSubSum("pod_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		 }else if (document.form.mode_type[1].checked){
    			 // pol별로 그룹을 묶어 pol를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			 MessageText("SubSum") = "POL";
   			  	 ShowSubSum("pol_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		 }
    		 
             var redColor  = RgbColor(255, 0, 0);
             var blueColor  = RgbColor(0, 0, 255);
             
             for(var i= HeaderRows; i<= LastRow; i++) {

            	 ColFontUnderline("bl_no") = true;
                	ColFontColor("bl_no") = blueColor;
                	
	                if (isError(CellValue(i,"sh_nm"))) CellFontColor(i,"sh_nm") = redColor;
	                if (isError(CellValue(i,"sh_ad")))CellFontColor(i,"sh_ad") = redColor;
	                if (isError(CellValue(i,"sh_ct"))) CellFontColor(i,"sh_ct") = redColor;
	                if (isError(CellValue(i,"sh_cn"))) CellFontColor(i,"sh_cn") = redColor;
	                if (isError(CellValue(i,"sh_zip"))) CellFontColor(i,"sh_zip") = redColor;
	                if (isError(CellValue(i,"sh_str"))) CellFontColor(i,"sh_str") = redColor;
	                if (isError(CellValue(i,"sh_eori"))) CellFontColor(i,"sh_eori") = redColor;

	                if (isError(CellValue(i,"cnee_nm"))) CellFontColor(i,"cnee_nm") = redColor;
	                if (isError(CellValue(i,"cnee_ad"))) CellFontColor(i,"cnee_ad") = redColor;
	                if (isError(CellValue(i,"cnee_ct"))) CellFontColor(i,"cnee_ct") = redColor;
	                if (isError(CellValue(i,"cnee_cn"))) CellFontColor(i,"cnee_cn") = redColor;
	                if (isError(CellValue(i,"cnee_zip"))) CellFontColor(i,"cnee_zip") = redColor;
	                if (isError(CellValue(i,"cnee_str"))) CellFontColor(i,"cnee_str") = redColor;
	                if (isError(CellValue(i,"cnee_eori"))) CellFontColor(i,"cnee_eori") = redColor;

	                if (isError(CellValue(i,"ntfy_nm"))) CellFontColor(i,"ntfy_nm") = redColor;
	                if (isError(CellValue(i,"ntfy_ad"))) CellFontColor(i,"ntfy_ad") = redColor;
	                if (isError(CellValue(i,"ntfy_ct"))) CellFontColor(i,"ntfy_ct") = redColor;
	                if (isError(CellValue(i,"ntfy_cn"))) CellFontColor(i,"ntfy_cn") = redColor;
	                if (isError(CellValue(i,"ntfy_zip"))) CellFontColor(i,"ntfy_zip") = redColor;
	                if (isError(CellValue(i,"ntfy_str"))) CellFontColor(i,"ntfy_str") = redColor;
	                if (isError(CellValue(i,"ntfy_eori"))) CellFontColor(i,"ntfy_eori") = redColor;
	                	
             }
         }//end width
         pagedMaxCnt = sheetObj.LastRow;
     }
      
      /**
       * Excel Down 용 group 처리 메서드 
       */
      function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
    	  with (sheetObj) {
    		  
    		  if (document.form.mode_type[0].checked){
    			  // pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			  MessageText("SubSum") = "POD";
    			  ShowSubSum("pod_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		  }else if (document.form.mode_type[1].checked){
    			  // pol별로 그룹을 묶어 pol를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
    			  MessageText("SubSum") = "POL";
    			  ShowSubSum("pol_cd", "dr_yn", 0, true, false, SaveNameCol("cntr_nos"));
    		  }
    		  
          }
      }
      
     /**
      * Booking Creation 화면 이동
      * @param String cellValue
      * return boolean 에러여부
      */
     function isError(cellValue) {
    	 
    	 if(cellValue == "E") return true;
    	 return false;
     
     }
      
	/**
	 * B/L Inquiry 화면 이동
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	 function sheet2_OnDblClick(sheetObj, row, col) {
	        var colSaveName = sheetObj.ColSaveName(col);
	        switch(colSaveName) {
	        	case "bl_no" :
	        		ComBkgCall0079(sheetObj.CellValue(row, "bkg_no"));
		    	break;
	        } // end switch
  	
	 }
	 

	/**
	 * 시트를 클릭했을 때 처리
	 */
	function sheet2_OnClick(sheetObj, row, col) {
		 
		var colSaveName = sheetObj.ColSaveName(col);
		 
		switch(colSaveName) {
			case "cgo_desc" :
				/* 긴 문자열 MemoPad 처리*/
		 		if(sheetObj.CellValue(row,col) != "") {
		    		ComShowMemoPad(sheetObj, null, null, true, 250, 100);
		    	}
		    	break;
	    } // end switch
	        
	}
	 
    
	/**
	 * Country 콤보 변경시 이벤트(2014.10.10 csy)
	 * @param comboObj
	 * @param value 
	 * @param text 
	 */
	function cnt_cd_OnChange(comboObj,value,text) {
		var formObject = document.form;
		
		// modify : 2014.11.13
		if(formObject.cnt_cd.Code=="IE" && formObject.p_type.Code =="GCM"){
			document.getElementById("span_cancel").style.display="Inline";
		}else{
			document.getElementById("span_cancel").style.display="none";
		}
		//End
		
		doActionIBSheet(sheetObjects[0], formObject, SEARCH09);

	}
	
	/**
	 * Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function p_type_OnChange(comboObj, value, text){
		var formObject = document.form;
		
		if(document.form.p_type.Code == "GCM"){
			document.getElementById("span_ap").style.display = "none";
			document.form.mode_type[1].checked=true;
			document.form.pol_cd.className = "input";
			document.form.pod_cd.className = "input1";
			comboObjects[1].Code = ""; //formObject.cnt_cd
			document.form.cnt_cd.Enable = true; 
			
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			formObject.vvd_cd.focus();
			formObject.uvi.value = "";
			formObject.ts_tp_cd.value="";
			formObject.check_frob_search.disabled=false;
			
			sheetObjects[1].ColHidden("hs_cd") = true;
			sheetObjects[1].ColHidden("cgo_desc") = true;
			sheetObjects[2].ColHidden("hs_cd") = true;
			sheetObjects[2].ColHidden("cgo_desc") = true;
						 
		}else{
			document.getElementById("span_ap").style.display = "Inline";
			
			document.form.mode_type[1].checked=true;
			document.form.pol_cd.className = "input";
			document.form.pod_cd.className = "input1";

			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			formObject.reset();
			formObject.vvd_cd.focus();
			formObject.uvi.value = "";
			formObject.ts_tp_cd.value="";
			formObject.check_frob_search.disabled=false;
			
			sheetObjects[1].ColHidden("hs_cd") = false;
			sheetObjects[1].ColHidden("cgo_desc") = false;
			sheetObjects[2].ColHidden("hs_cd") = false;
			sheetObjects[2].ColHidden("cgo_desc") = false;
			 
			document.form.cnt_cd.Code="FR";
			document.form.cnt_cd.Enable = false;
			
			// FR이 기존에 선택시 Receiver ID를 다시 조회해 오기 위해서
			doActionIBSheet(sheetObjects[0], formObject, SEARCH09);
		}
	}
		
    /* 개발자 작업  끝 */
