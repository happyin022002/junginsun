/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1063.js
*@FileTitle : Pick up down-load
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.21 박미옥
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
     * @class ESM_BKG_1063 : ESM_BKG_1063 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_1063() {
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
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var initManual0 = false;
    var initManual1 = false;
    
    var jobId = "";
    var timeId = "";
    
    var monCnt = 0; // 10분 으로 제한(600sec/3sec=200번)
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * 
     * @return 없슴
     */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/

        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var sheetObject4 = sheetObjects[3];

        /*******************************************************/
        var formObject = document.form;
        var sheetObj = sheetObjects[0];

        if (tabObjects[0].selectedIndex == 0) {
        	sheetObj = sheetObjects[0];
        }
		else if (tabObjects[0].selectedIndex == 1) {
			sheetObj = sheetObjects[1];
		}
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {

                case "img_dt":
        	        ComSetObjValue(formObject.sch_tp_cd, "ATA");
        	        setMandantorySearchType();
        	        var cal = new ComCalendarFromTo();
        		    cal.select(formObject.dt_s, formObject.dt_e, 'yyyy-MM-dd');
                    break;
                
                case "btn_Retrieve":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH);
                    break;

                case "btn_New":
                	doActionIBSheet(sheetObj,formObject,IBRESET);
                	break;

                case "btn_Delete":
                	doActionIBSheet(sheetObj,formObject,IBDELETE);
                	break;
                	
                case "btn_Upload":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01);
                	break;

                case "btn_DataSetup":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02);
                	break;
                	
                case "btn_Save":
                	doActionIBSheet(sheetObj,formObject,IBSAVE);
                	break;
                	
                case "btn_PickupSend":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC03);
                	break;
                	                	
                case "btn_DownExcel":
                	//sheetObj = sheetObjects[2];
                	doActionIBSheet(sheetObj,formObject,IBDOWNEXCEL);
                    break;
                
                case "btn_History":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC04);
                	break;
                	
                case "btn_RtnYD":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC05);
                	break;
                	
                case "btn_Batch":
                	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC06);
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
     * IBSheet Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {IBSheet} sheet_obj 필수, IBSheet 컨트롤
     * @return 없슴
     */
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++] = sheet_obj;
    }


    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다 <br>
     * 
     * @return 없슴
     */
    function loadPage() {

        for(var i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        initControl();

        if (document.form.flag.value == "ESM_BKG_1063") {
        	tabObjects[0].selectedIndex = 0;
        } else if (document.form.flag.value == "ESM_BKG_1063-01") {
        	tabObjects[0].selectedIndex = 1;

        	if (document.form.popUp.value == "Y") {
        		initManual1 = false;
        		
        		ComSetObjValue(document.form.sch_tp_cd, document.form.p_sch_tp_cd.value);
        		setMandantorySearchType();
            	document.form.bl_no.value = document.form.p_bl_no.value;
            	
            	if (document.form.bl_no.value != "") {
                	doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
                }
        	}
        }
    }

    
    /**
     * Form 데이터 초기화 작업. 화면 Open 또는 데이터 삭제 후 초기값을 설정한다.
     * 
     * @return 없슴
     */
    function initForm() {
		with(document.form) {
			if (tabObjects[0].selectedIndex == 0) {
			    div_cre_tp1.style.display  = "";
			    div_cre_tp2.style.display  = "none";
				cre_tp_cd1.value           = "";
			} else {
		        var endDay = ComGetNowInfo("ymd", "-");
		        var startDay = ComGetDateAdd(endDay, "D", -7, "-");        
	            dt_s.value = startDay;
	            dt_e.value = endDay;

				vvd.value            = "";
			    bl_no.value          = "";
			    cntr_no.value        = "";
			    cntr_no_nonbit.value = "";
			    cntr_no_split.value  = "";
			    ofc_cd.value         = "";
				
			    ComSetObjValue(sch_tp_cd, "VVD");
				setMandantorySearchType();
				
			    div_cre_tp1.style.display = "none";
			    div_cre_tp2.style.display = "";
			    cre_tp_cd2.value          = "";
			}
		}
    }
     
    
    /**
     * HTML 태그 이벤트를 등록한다. <br>
     * 
     * @return 없슴
     */
    function initControl() {
        axon_event.addListenerFormat("keypress","obj_KeyPress", form);
      	axon_event.addListener("click","obj_click", "sch_tp_cd", "vvd", "dt_s", "dt_e", "bl_no", "cntr_no_nonbit");
      	axon_event.addListener("blur","obj_deactivate", "dt_s", "dt_e");
      	axon_event.addListener("keydown","ComKeyEnter", "vvd", "dt_s", "dt_e", "bl_no", "cntr_no_nonbit", "ofc_cd");
      	axon_event.addListener("keyup","obj_keyup", "cntr_no_nonbit"); 
      	axon_event.addListener("change","obj_change", "cre_tp_cd1", "cre_tp_cd2");
    }

    
    /**
     * Click 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_click() {
   	    var formObject = document.form;
   	 
   	    switch(event.srcElement.name) {
       	    case "sch_tp_cd":
       	   		setMandantorySearchType();
       	   		break;
   	    	case "vvd":
   	    		ComSetObjValue(formObject.sch_tp_cd, "VVD");
   	    		setMandantorySearchType();
   	    		break;
   	    	case "dt_s":
   	    	case "dt_e":
   	    		ComSetObjValue(formObject.sch_tp_cd, "ATA");
   	    		setMandantorySearchType();
   	    		break;
   	    	case "bl_no":
   	    		ComSetObjValue(formObject.sch_tp_cd, "BL");
   	    		setMandantorySearchType();
   	    		break;
   	    	case "cntr_no_nonbit":
   	    		ComSetObjValue(formObject.sch_tp_cd, "CN");
   	    		setMandantorySearchType();
   	    		break;
   	    }
    }
    
    
    /**
     *Blur 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
   function obj_deactivate() {
       switch(event.srcElement.name) {
           case "dt_s":
           case "dt_e":
               ComChkObjValid(event.srcElement);
               break;
       }
   }

   
   /**
    * Key Up 이벤트를 처리한다.<br>
    * 
    * @return 없슴
    */
    function obj_keyup() {
        switch(event.srcElement.name) {
        case "cntr_no_nonbit":
        	CheckDigitSplit(document.form.cntr_no_nonbit, 'cntr_no_split', 'cntr_no');
        	break;
        }
    }

    
    /**
     * Change 이벤트를 처리한다.<br>
     * 
     * @return 없슴
     */
    function obj_change() {
        switch(event.srcElement.name) {
    	case "cre_tp_cd1":
    	case "cre_tp_cd2":
    	    fncSetFilter();
    		break;
        }
    }
    
    
    /**
     * Filter 리스트 변경 이벤트 발생시 필터링 한다.<br>
     *
     * @return 없슴
     */
    function fncSetFilter() {
    	
    	var sheetObj;
    	var frmObj;
    	
        if (tabObjects[0].selectedIndex == 0) {
        	sheetObj = sheetObjects[0];
        	frmObj = document.form.cre_tp_cd1;
        }
		else if (tabObjects[0].selectedIndex == 1) {
			sheetObj = sheetObjects[1];
			frmObj = document.form.cre_tp_cd2;
		}
        
        var filter = ComGetObjValue(frmObj);
    	
    	with (sheetObj) {
    		for (var i=0; i<RowCount; i++) {
        		if (filter == "") // All 
        		{ 
        			RowHidden(i+1) = false;
            	} 
        		else if (filter == "C") // Created 
            	{ 
            		if (CellValue(i+1, "pkup_cre_usr_id") == "") {
            			RowHidden(i+1) = true;
            		} else {
            			RowHidden(i+1) = false;
            		}
            	} 
        		else if (filter == "N") // Not Created 
            	{ 
            		if (CellValue(i+1, "pkup_cre_usr_id") == "") {
            			RowHidden(i+1) = false;
            		} else {
            			RowHidden(i+1) = true;
            		}
            	}
    		}
    	}
    }

    
    /**
     * 시트 초기설정값, 헤더 정의<br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * 
     * @param {ibsheet} sheetObj 필수, IBSheet 오브젝트
     * @param {number}  sheetNo  필수, IBSheet 오브젝트 일련번호
     * @return 없슴
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;
        
        switch(sheetID) {
                
            case "t1sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 440;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 500);

                    var HeadTitle1 = "|Chk|Seq.|Bkg No|B/L No.|CNTR PRT FLG|Container|TP|AVL DT|FRE DT|Pick up No.|PICK YD|RTN YD|F|O|C|CRE DT|CRE OFC|CRE USER|SN||POD|C LOC|DEL|Filer|TERM|ROUTE GUIDE|RAIL MOVE|TRUCK MOVE|ETA DT||||VSL|DEP DT|ARR DT";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,   daCenter,  false,  "chk",                  false,  "",    dfNone,        0,   true,      true);
                    InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,  false,  "seq");                                                         
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "bkg_no",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "bl_no",                false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_prt_flg",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_no",              false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  false,  "cntr_tpsz_cd",         false,  "",    dfNone,        0,   false,     false);

                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_aval_dt",         false,  "",    dfUserFormat2, 0,   true,      true);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "lst_free_dt",          false,  "",    dfUserFormat2, 0,   true,      true);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_no",              false,  "",    dfEngUpKey,    0,   true,      true,    20);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_yd_cd",           false,  "",    dfEngUpKey,    0,   true,      true,    7);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "rtn_yd_cd",            false,  "",    dfEngUpKey,    0,   true,      true,    7);                                                                                                                                            
                                                                                                                                                        
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "frt_clt_flg",          false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "obl_rdem_flg",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "cstms_clr_cd",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,  false,  "pkup_cre_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "ofc_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_cre_usr_id",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         25,   daCenter,  false,  "pkup_ntc_snd_yn",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       25,   daCenter,  false,  "pkup_ntc_snd_knt",     false,  "",    dfNone,        0,   false,     false);
                                                                                                                                                                                                                                                                                                      
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "pod_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "ibd_trsp_hub_cd",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "del_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  false,  "usa_cstms_file_cd",    false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "de_term_cd",           false,  "",    dfNone,        0,   false,     false);                                                                                                                                              
                                                                                                                                                       
                    InitDataProperty(0, cnt++ , dtData,         230,  daLeft,    false,  "route_guide",          false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "rail_move",            false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "truck_move",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "ata_dt",               false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "vsl_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "skd_voy_no",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "skd_dir_cd",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "vvd",                  false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,        70,  daCenter,  false,  "rail_dep_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,        70,  daCenter,  false,  "rail_arr_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    
                    InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "pkup_cre_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "ata_dt", "####-##-## ##:##:##", "-|:" );
                    InitUserFormat2(0, "rail_dep_dt", "####-##-## ##:##:##", "-|:" );
                    InitUserFormat2(0, "rail_arr_dt", "####-##-## ##:##:##", "-|:" );
                    
                    InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789");
                    InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "0123456789");                    
                }
                
                break;
            	
            	
            	
            case "t2sheet1":
            case "t2sheet2":
                with (sheetObj) {

                    // 높이 설정
                    if (sheetID == "t2sheet1")
                        style.height = 420;
                    else style.height = 0;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 500);

                    var HeadTitle1 = "|Chk|Seq.|Bkg No|B/L No.|CNTR PRT FLG|Container|TP|AVL DT|FRE DT|Pick up No.|PICK YD|RTN YD|F|O|C|Update DT|Update OFC|Update USER|SN||POD|C LOC|DEL|Filer|TERM|ROUTE GUIDE|RAIL MOVE|TRUCK MOVE|ETA DT||||VSL|DEP DT|ARR DT";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,   daCenter,  false,  "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   30,   daCenter,  false,  "chk",                  false,  "",    dfNone,        0,   true,      true);
                    InitDataProperty(0, cnt++ , dtSeq,          30,   daCenter,  false,  "seq");                                                         
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "bkg_no",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "bl_no",                false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_prt_flg",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "cntr_no",              false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  false,  "cntr_tpsz_cd",         false,  "",    dfNone,        0,   false,     false);

                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_aval_dt",         false,  "",    dfUserFormat2, 0,   true,      true);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "lst_free_dt",          false,  "",    dfUserFormat2, 0,   true,      true);
                    InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  false,  "pkup_no",              false,  "",    dfEngUpKey,    0,   true,      true,    20);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "pkup_yd_cd",           false,  "",    dfEngUpKey,    0,   true,      true,    7);
                    InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  false,  "rtn_yd_cd",            false,  "",    dfEngUpKey,    0,   true,      true,    7);                                                                                                                                            
                                                                                                                                                        
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "frt_clt_flg",          false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "obl_rdem_flg",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         20,   daCenter,  false,  "cstms_clr_cd",         false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,  false,  "pkup_upd_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  false,  "ofc_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,        100,   daCenter,  false,  "pkup_upd_usr_id",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         25,   daCenter,  false,  "pkup_ntc_snd_yn",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       25,   daCenter,  false,  "pkup_ntc_snd_knt",     false,  "",    dfNone,        0,   false,     false);
                                                                                                                                                                                                                                                                                                      
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "pod_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "ibd_trsp_hub_cd",      false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "del_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  false,  "usa_cstms_file_cd",    false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  false,  "de_term_cd",           false,  "",    dfNone,        0,   false,     false);                                                                                                                                              
                                                                                                                                                       
                    InitDataProperty(0, cnt++ , dtData,         230,  daLeft,    false,  "route_guide",          false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "rail_move",            false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "truck_move",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         120,  daCenter,  false,  "ata_dt",               false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "vsl_cd",               false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "skd_voy_no",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,       60,   daCenter,  false,  "skd_dir_cd",           false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  false,  "vvd",                  false,  "",    dfNone,        0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,        70,  daCenter,  false,  "rail_dep_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    InitDataProperty(0, cnt++ , dtHidden,        70,  daCenter,  false,  "rail_arr_dt",          false,  "",    dfUserFormat2, 0,   false,     false);
                    
                    InitUserFormat2(0, "pkup_aval_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "lst_free_dt", "####-##-##", "-|:" );
                    InitUserFormat2(0, "pkup_upd_dt", "####-##-## ##:##", "-|:" );
                    InitUserFormat2(0, "ata_dt", "####-##-## ##:##:##", "-|:" );
                    InitUserFormat2(0, "rail_dep_dt", "####-##-## ##:##:##", "-|:" );
                    InitUserFormat2(0, "rail_arr_dt", "####-##-## ##:##:##", "-|:" );
                    
                    InitDataValid(0, "pkup_no", vtEngUpOther, "0123456789");
                    InitDataValid(0, "pkup_yd_cd", vtEngUpOther, "0123456789");
                    InitDataValid(0, "rtn_yd_cd", vtEngUpOther, "0123456789");                    
                }
                
                break;
        }
    }


    /**
     * Sheet관련 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj  필수,IBSheet 오브젝트
     * @param {object}  formObj   필수,HTML Form 오브젝트
     * @param {string}  sAction   필수,Action 명 
     * @param {String}  CondParam 필수,서버전송 정보
     * @param {int}     PageNo    선택,페이지 번호
     * @return 없슴
     */
    function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {
        //sheetObj.ShowDebugMsg = false;
        
        sheetObj.WaitImageVisible = false;
        
        switch(sAction) {
        
        // New
        case IBRESET:        	
        	if (sheetObj.IsDataModified) {
        		if (ComShowCodeConfirm("BKG00254") == true) {
        			doActionIBSheet(sheetObj,formObj,IBSAVE);
        			break;        		
        		}
        	}
        	
        	sheetObj.RemoveAll();
    		initForm();
        	
        	break;
        	
        	
        	
        	// Delete
        case IBDELETE:
        	var iCheckRow = sheetObj.CheckedRows("chk");
        	if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	}

        	for(var i=sheetObj.RowCount; i > 0; i--) {
        		if (sheetObj.CellValue(i, "chk") == "1") {
        			sheetObj.RowDelete(i, false);	
        		}
        	}

        	break;
        	
        	
        	
        	//조회
        case IBSEARCH:      

            if(validateForm(sheetObj,formObj,sAction) == false) break;

            if (sheetObj.id == "t1sheet1") {
                break;
            } else if (sheetObj.id == "t2sheet1") {
            	
            	ComOpenWait(true);
            	
                formObj.f_cmd.value = SEARCH01;
                sheetObj.DoSearch("ESM_BKG_1063_01GS.do", FormQueryString(formObj), "page_no=1", false);
                
                fncSetFilter();
                
                ComOpenWait(false);
            }
            

            break;

            

        case IBSEARCHAPPEND:
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_1063_01GS.do", CondParam, "page_no=" + PageNo, true);
            fncSetFilter();
            
            ComOpenWait(false);
            break;

            
            
            // Upload
        case IBSEARCH_ASYNC01:
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1064.do', 906, 524, "", "none", true);
        	break;
        	
        	
        	
        	// Data Setup
        case IBSEARCH_ASYNC02:
        	var iCheckRow = sheetObj.CheckedRows("chk");
        	if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	}
        	
        	var resultObj = ComOpenPopupWithTarget('/hanjin/ESM_BKG_1065.do', 456, 250, "", "none", true);
        	if (resultObj != null) {
        		ComOpenWait(true);
        		fncSetInfo(sheetObj, resultObj);
        		ComOpenWait(false);
        	}

        	break;
        	
        	
        	
        	// Pickup Send
        case IBSEARCH_ASYNC03:        	
        	var param = "";
        	
        	if (sheetObj.RowCount > 0) {
         	    var arr = (sheetObj.GetSelectionRows("/")).split("/");     	    
         	    
               	if (arr.length == 1) {
               		param = "&bl_no=" +sheetObj.CellValue(arr[0], "bl_no");
            	} else if (arr.length > 1) {
            		ComShowCodeMessage("BKG40075");
            		break;
            	}
        	}

        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1066.do?pgmNo=ESM_BKG_1066' + param, 1020, 700, "", "none", true);

        	break;
        	
        	
        	
        	// History
        case IBSEARCH_ASYNC04:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var arr = (sheetObj.GetSelectionRows("/")).split("/");
           	if (arr.length < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	} else if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var vRow = arr[0];

        	var param = "&bkg_no=" + sheetObj.CellValue(vRow, "bkg_no") +
                        "&cntr_no=" + sheetObj.CellValue(vRow, "cntr_no") +
                        "&ofc_cd=" + sheetObj.CellValue(vRow, "ofc_cd");
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1067.do?' + param, 906, 369, "", "none", true);

        	break;
        	
        	
        	
        	// RTN YD
        case IBSEARCH_ASYNC05:
        	if (sheetObj.RowCount == 0) {
     	    	ComShowCodeMessage("BKG00395"); 
    	        break;
    	    }

     	    var arr = (sheetObj.GetSelectionRows("/")).split("/");
           	if (arr.length < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	} else if (arr.length > 1) {
        		ComShowCodeMessage("BKG40075");
        		break;
        	}

        	var vRow = arr[0];

        	var param = "&pod_cd=" + sheetObj.CellValue(vRow, "pod_cd") +
        	            "&del_cd=" + sheetObj.CellValue(vRow, "del_cd");
        	ComOpenPopupWithTarget('/hanjin/ESM_BKG_1058.do?pgmNo=ESM_BKG_1058' + param, 1024, 670, "", "none", true);

        	break;

        	
        	
        case IBDOWNEXCEL:
            if (sheetObj.id == "t1sheet1") 
            {
    	        ComOpenWait(true);
            	sheetObj.SpeedDown2Excel(-1);
             	ComOpenWait(false);
            } 
            else if (sheetObj.id == "t2sheet1") 
            {
            	if (sheetObj.RowCount == 0) {
         	    	ComShowCodeMessage("BKG00395"); 
        	        break;
        	    }

                if (validateForm(sheetObj, formObj, sAction) == false) break;
                
    	        ComOpenWait(true);

                formObj.f_cmd.value = SEARCH01;
                sheetObjects[2].DoSearch("ESM_BKG_1063_01GS.do", FormQueryString(formObj) + "&excel_flg=Y");
            }

        	break;
        	
        	
        	
        	// 저장
        case IBSAVE:
        	var iCheckRow = sheetObj.CheckedRows("chk");
        	if (iCheckRow < 1) {
        		ComShowCodeMessage("BKG00149");
        		break;
        	}

        	if(validateForm(sheetObj,formObj,sAction) == false) break;

        	ComOpenWait(true);
        	
            formObj.f_cmd.value = MULTI;
            var sParam = FormQueryString(formObj);
            var sParamSheet = sheetObj.GetSaveString(false, true, "chk");
            if (sParamSheet == "") {
            	ComShowCodeMessage("COM130503");
            	ComOpenWait(false);
            	break;
            } else {
                sParam += "&" + ComSetPrifix(sParamSheet, "sheet1_");
            }

            sXml = sheetObj.GetSaveXml("ESM_BKG_1063GS.do", sParam);

			sheetObj.LoadSaveXml(sXml);
			
            if (sheetObj.id == "t1sheet1") {
    			if(ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
    				for(var i=sheetObj.RowCount; i>=0; i--) {
    					if (sheetObj.CellValue(i+1, "chk") == "1") {
    						sheetObj.RowDelete(i+1, false);
    					}
    				}
    			}
    			
    			ComOpenWait(false);
    			
            } else if (sheetObj.id == "t2sheet1") {
            	ComOpenWait(false);
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
            }

    		break;

    		
        	// Execute Batch 
        case IBSEARCH_ASYNC06:
        	
        	ComOpenWait(true);

        	// 1. ESM_BKG_B019 체크
            var sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B019";
       	    var sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComShowCodeMessage("BKG43043");
           	    	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    	break;
       	    }
        	
        	// 2. ESM_BKG_B012 체크
            sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B012";
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComShowCodeMessage("BKG43043");
           	    	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    	break;
       	    }

       	    
       	    // 3. ESM_BKG_B015 체크
            sParam = "&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B015";
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);

       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	var isRunning = ComGetEtcData(sXml,"BATCH_STATUS");
                if (isRunning == "true") {
                	ComShowCodeMessage("BKG43043");
           	    	ComOpenWait(false);
                	break;
                }
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    	break;
       	    }
        	
       	    
        	formObj.f_cmd.value = SEARCH03;
            sParam = FormQueryString(formObj);
       	    sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);
       	           	    
       	    if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
       	    {
       	    	monCnt = 1;
       	    	jobId = ComGetEtcData(sXml,"JOB_ID");
                timeId = setTimeout("monitoringBatchJob()", 1000*3);
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    }
       	     
        	break;
        	
        	
        	// Monitor Batch Status
        case IBSEARCH_ASYNC07:
        	
            var sParam = "&f_cmd=" + SEARCH04 + "&job_id=" + jobId;
        	var sXml = sheetObj.GetSearchXml("ESM_BKG_1063GS.do", sParam);
       	    
        	if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") 
        	{
            	var jobStatus = ComGetEtcData(sXml,"BATCH_STATUS");
       	    	if (jobStatus == "0" || jobStatus == "1" || jobStatus == "3" || jobStatus == "10") // None. Running or Starting or Restart 
       	    	{ 
       	    		if (monCnt < 200) { // 모니터링 10분으로 제한.(3sec*200=10min)
           	    		monCnt++;
           	    		// 계속 모니터링
           	    		timeId = setTimeout("monitoringBatchJob()", 1000*3);
       	    		} else {
           	    		ComOpenWait(false);       	    		
       	    		}
       	    	} 
       	    	else 
       	    	{
       	    		ComOpenWait(false);       	    		
       	    		alert(getBatchStatusDesc(jobStatus));
       	    	}
       	    } else {
       	    	ComBkgErrMessage(sheetObj, sXml);
       	    	ComOpenWait(false);
       	    }

        	break;
        }
    }


    /**
     * IBTab Object를 배열로 등록<br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다<br>
     * 배열은 소스 상단에 정의 <br>
     * 
     * @param {object} tab_obj 필수, Tab 컨트롤
     * @return 없슴
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }


    /**
     * Tab 기본 설정 <br>
     * 탭의 항목을 설정한다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    tabNo  필수, Tab 오브젝트 일련번호
     * @return 없슴
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "File Import" , -1 );
                    InsertTab( cnt++ , "Manual" , -1 );
                }
                break;
        }
    }

    
    /**
     * Tab 클릭시 이벤트 관련 <br>
     * 선택한 탭의 요소가 활성화 된다. <br>
     * 
     * @param {object} tabObj 필수, Tab 컨트롤
     * @param {int}    nItem  필수, Tab 오브젝트 일련번호
     * @return 없슴
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
        
        if (nItem == 0) {
        	ComBtnEnable("btn_Upload");
        	ComBtnDisable("btn_Retrieve");

        	if (initManual0 == false) {
           	    initForm();
           	    initManual0 = true;
        	}
        	
        	div_cre_tp1.style.display = "";
        	div_cre_tp2.style.display = "none";
        	
        } else {
        	ComBtnEnable("btn_Retrieve");
        	ComBtnDisable("btn_Upload");
        	
        	if (initManual1 == false) {
           	    initForm();
           	    initManual1 = true;
        	}

        	div_cre_tp1.style.display = "none";
        	div_cre_tp2.style.display = "";
        }
        
        fncSetFilter();
    }

     /**
     * 수직스크롤바가 바닥에 닿았을 때 발생하는 이벤트 Catch<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {Object} sheetObj 필수, Sheet
     * @param {String} CondParam 필수, Query 
     * @param {int} PageNo 필수, next Page no
     * @param {int} OnePageRows 필수, page size
     * @return void
     */
    function t2sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
        doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, CondParam, PageNo);
    }

    
     /**
      * Excel에 대한 Search 종료시 이벤트 처리한다.(엑셀 추출)<br>
      * <br><b>Example : </b>
      * <pre>
      * </pre>
      * @param {Object} sheetObj 필수, Sheet개체
      * @param {String} errStr 필수, 메시지 문자열
      * @returns void
      */
     function t2sheet2_OnSearchEnd(sheetObj, errXml) {
     	sheetObj.SpeedDown2Excel(-1);
     	ComOpenWait(false);
     }

     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  formObj  필수,HTML Form 오브젝트
     * @param {string}  sAction  필수,Action 명 
     * @return boolean Form 오브젝트 유효성 여부를 반환한다. 유효한 경우 true,  아닌 경우 false
     */
    function validateForm(sheetObj,formObj,sAction){
        with(sheetObj) {
            switch(sAction) {
           	case IBSEARCH:
           	case IBDOWNEXCEL:
    	    	if (!ComChkValid(formObj)) return false;

              	if(ComGetObjValue(formObj.sch_tp_cd) == "ATA") {
                	if(ComGetDaysBetween(formObj.dt_s.value, formObj.dt_e.value) > 7) {
                		ComShowCodeMessage("BKG40008", "7");
                		ComSetFocus(formObj.dt_s);
                		return false;
                	}
              	}

    	    	break;
    	    	
    	    	
    	    	
//           	case IBSAVE:
//           		if (sheetObj.id == "t1sheet1") {
//           		}
//           		
//           		break;
            }
        }

        return true;
    }
     
     
    /**
     * AVL DT, FRE DT, PICK YD, RTN YD 를 "Data Setup" 팝업 화면에서 수정하면
     * 수정된 정보를 Object 에 가져와서 체크한 BL에 일괄 적용한다.<br>
     * 
     * @param {ibsheet} sheetObj 필수,IBSheet 오브젝트
     * @param {object}  infoObj  필수,Data Setup 정보를 갖는 오브젝트
     * @return 없슴
     */
    function fncSetInfo(sheetObj, infoObj) {
    	with(sheetObj) {
    		var idx=0;
    		for (var i=0; i<RowCount; i++) {
    			idx = i+1;
    			if (CellValue(idx, "chk") != "1") continue;
    			
    			if (infoObj.avl_dt != "") {
    				CellValue2(idx, "pkup_aval_dt") = infoObj.avl_dt;
    			}
    			
    			if (infoObj.fre_dt != "") {
    				CellValue2(idx, "lst_free_dt") = infoObj.fre_dt;
    			}
    			
    			if (infoObj.pkup_yd_cd != "") {
    				CellValue2(idx, "pkup_yd_cd") = infoObj.pkup_yd_cd;
    			}
    			
    			if (infoObj.rtn_yd_cd != "") {
    				CellValue2(idx, "rtn_yd_cd") = infoObj.rtn_yd_cd;
    			}
    		}
    	}
    }
    
    
    /**
     * Pkup No 정보가 들어있는 배열에서 정보를 읽어와 쉬트로 복사한다.
     * (이메일 업로드 팝업 화면에서 셋업정보를 생성하여 호출한다.)<br>
     *
     * @param {array} infos 필수. 업로드 정보 배열
     * @return 없슴
     */
    function fncSetPkupNo(infos) {
    	var info = null;
    	var idx = -1;
    	var sheetObj = sheetObjects[0];
    	
    	if (infos == null) return;
    	
    	with (sheetObj) {
        	for (var i=0; i<infos.length; i++) {
        		info = infos[i];
        		
        		idx = DataInsert();
        		
        		CellValue2(idx, "chk")                  = info.chk;
        		CellValue2(idx, "bkg_no")               = info.bkg_no;
				CellValue2(idx, "bl_no")                = info.bl_no; 
				CellValue2(idx, "cntr_prt_flg")         = info.cntr_prt_flg;   
				CellValue2(idx, "cntr_no")              = info.cntr_no;
				CellValue2(idx, "cntr_tpsz_cd")         = info.cntr_tpsz_cd;
				CellValue2(idx, "pkup_aval_dt")         = info.pkup_aval_dt;        
				CellValue2(idx, "lst_free_dt")          = info.lst_free_dt;         
				CellValue2(idx, "pkup_no")              = info.pkup_no;             
				CellValue2(idx, "pkup_yd_cd")           = info.pkup_yd_cd;          
				CellValue2(idx, "rtn_yd_cd")            = info.rtn_yd_cd;           
				CellValue2(idx, "frt_clt_flg")          = info.frt_clt_flg;         
				CellValue2(idx, "obl_rdem_flg")         = info.obl_rdem_flg;        
				CellValue2(idx, "cstms_clr_cd")         = info.cstms_clr_cd;       
				CellValue2(idx, "pkup_cre_dt")          = info.pkup_cre_dt;         
				CellValue2(idx, "ofc_cd")               = info.ofc_cd;              
				CellValue2(idx, "pkup_cre_usr_id")      = info.pkup_cre_usr_id;     
				CellValue2(idx, "pkup_ntc_snd_knt")     = info.pkup_ntc_snd_knt;    
				CellValue2(idx, "pod_cd")               = info.pod_cd;              
				CellValue2(idx, "ibd_trsp_hub_cd")      = info.ibd_trsp_hub_cd;
				CellValue2(idx, "del_cd")               = info.del_cd;              
				CellValue2(idx, "usa_cstms_file_cd")    = info.usa_cstms_file_cd;   
				CellValue2(idx, "de_term_cd")           = info.de_term_cd;          
				CellValue2(idx, "route_guide")          = info.route_guide;         
				CellValue2(idx, "rail_move")            = info.rail_move;           
				CellValue2(idx, "truck_move")           = info.truck_move;          
				CellValue2(idx, "ata_dt")               = info.ata_dt;              
				CellValue2(idx, "vsl_cd")               = info.vsl_cd;
				CellValue2(idx, "skd_voy_no")           = info.skd_voy_no;
				CellValue2(idx, "skd_dir_cd")           = info.skd_dir_cd;
				CellValue2(idx, "vvd")                  = info.vvd;                 				
				CellValue2(idx, "rail_dep_dt")          = info.rail_dep_dt;
				CellValue2(idx, "rail_arr_dt")          = info.rail_arr_dt;
        	}
        	
        	if (sheetObj.RowCount > 1) SelectRow = 1;
        	
        	fncSetFilter();
    	}
    }

     
    /**
     * 선택된 필수 조건을 셋팅한다.<br>
     * 
     * @return 없슴
     */
    function setMandantorySearchType() {
        	with(document.form) {
        		setNotRequiredObject(vvd, dt_s, dt_e, bl_no, cntr_no_nonbit);
        		var schVal = ComGetObjValue(sch_tp_cd); 
            	if (schVal == "VVD") {
        			setRequiredObject(vvd);
        		} else if (schVal == "ATA") {
        			setRequiredObject(dt_s, dt_e);
            	} else if (schVal == "BL") {
        			setRequiredObject(bl_no);
        		} else {
        			setRequiredObject(cntr_no_nonbit);
        		}
        	}
    }
    
    /**
     * 필수 검색 조건을 설정한다.
     * 
     * @param [...] 가변 인자
     */
    function setRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], true);
    	}
    	if (arguments != null & arguments.length == 1) 
    		arguments[0].focus();
    }

    /**
     * 필수 검색 조건이 아님으로 설정한다.
     * 
     * @param [...] 가변 인자
     * @return
     */
    function setNotRequiredObject() {
    	for(var i=0; i<arguments.length; i++) {
    		setRequiredMode(arguments[i], false);
    	}
    }
    
    /**
     * Object 의 Required 속성을 셋팅한다.
     * 
     * @param obj
     * @param requireMode
     * @return
     */
    function setRequiredMode(obj, requireMode) {    	
    	if (requireMode == true) {
    		obj.setAttribute("required", true);
    	} else {
    		obj.removeAttribute("required");
    	}
    }
     
     
     /**
      * Container No. 의 CheckDigit 을 설정.<br>
      * 
      * @param {object} obj         필수
      * @param {string} bitTarget   필수
      * @param {string} valueTarget 필수
      * @return 없슴
      */
    function CheckDigitSplit(obj, bitTarget, valueTarget){
     	var cntrNo = obj.value;

     	with (document.form) {
         	if (cntrNo.length < 10){
         		eval(bitTarget).value   = '';
         		eval(valueTarget).value = cntrNo;
         		return;
         	}

         	var sum = ComGetCntrChkDgt(cntrNo.substr(0,10));
         	
         	var mod = sum % 11;

         	if (mod == 10) mod =0;

         	if (isNaN(mod)) {
         		eval(bitTarget).value   = '';
         		eval(valueTarget).value = obj.value;
         	} else {
         		obj.value               = cntrNo.substr(0,10);
         		eval(bitTarget).value   = mod;
         		eval(valueTarget).value = obj.value + mod;
         	}
     	}
    }
    
      
    /**
     * 배치 상태를 모니터링한다.
     * @return 없슴
     */
    function monitoringBatchJob() {
    	var sheetObj = null;
    	
        if (tabObjects[0].selectedIndex == 0) {
        	sheetObj = sheetObjects[0];
        }
		else if (tabObjects[0].selectedIndex == 1) {
			sheetObj = sheetObjects[1];
		}

    	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC07);
    }
    
    
    /**
     * 배치 상태 Description 을 가져온다
     * @param {string} status 필수 배치 상태 코드
     * @return {string} 배치 상태 Description
     */
    function getBatchStatusDesc(status) {
    	/*
   		상태코드
		status	1	RUNNING	
		status	3	STARTING	
		status	4	SUCCESS	
		status	5	FAILURE	
		status	6	TERMINATED	
		status	7	ON_ICE	
		status	8	INACTIVE	
		status	9	ACTIVATED	
		status	10	RESTART	
		status	11	ON_HOLD	
		status	12	QUE_WAIT
	    */
    	
	    var desc = "";
   
    	if (status == "1") {
    		desc = "Running";
    	} else if (status == "3") {
    		desc = "Starting";
    	} else if (status == "4") {
    		desc = "Success";
    	} else if (status == "5") {
    		desc = "Fail";
    	} else if (status == "6") {
    		desc = "Terminated";
    	} else if (status == "7") {
    		desc = "On Ice";
    	} else if (status == "8") {
    		desc = "Inactive";
    	} else if (status == "9") {
    		desc = "Activated";
    	} else if (status == "10") {
    		desc = "Restart";
    	} else if (status == "11") {
    		desc = "On Hold";
    	} else if (status == "12") {
    		desc = "Que Wait";
    	} else {
    		desc = "Undefined status:" + status + "";
    	}
    	
    	return desc;
    }
      
        
	/* 개발자 작업  끝 */