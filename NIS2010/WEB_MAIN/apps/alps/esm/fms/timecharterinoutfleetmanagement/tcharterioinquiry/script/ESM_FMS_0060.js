/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0060.js
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
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
     * @class esm_fms_0060 : esm_fms_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_fms_0060() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.sheet1_OnLoadFinish	= sheet1_OnLoadFinish;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setFromOwnerName		= setFromOwnerName;
    	this.setFromLaneCd			= setFromLaneCd;
    	this.initControl			= initControl;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_keypress			= obj_keypress;
    	this.eng_keypress			= eng_keypress;
    	this.obj_change				= obj_change;
    	this.sheet1_OnScroll		= sheet1_OnScroll;
    	this.sheet2_OnScroll		= sheet2_OnScroll;
    	this.sheet2_OnSearchEnd		= sheet2_OnSearchEnd;
    	this.controlScrollBar		= controlScrollBar;
    	this.initRdConfig			= initRdConfig;
    	this.rdOpen					= rdOpen;
    	this.obj_activate			= obj_activate;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var rdObjects = new Array();
    var rdCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];

    /*******************************************************/
    var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    	
    	    switch(srcName) {
    	        case "btn_retrieve":
    	        	if(form.btn_periodFlag[0].checked) {
    	        		form.periodFlag.value = "date";
    	        		form.schMonth.value = "";
    	        		form.schMonthTo.value = "";
    	        		form.schYear.value = "";
    	        		form.schYearTo.value = "";
    	        		form.schDt.value = form.schDate.value.replace(/-/g,"");
    	        		form.schDtTo.value = form.schDateTo.value.replace(/-/g,"");
    	        	} else if(form.btn_periodFlag[1].checked) {
    	        		form.periodFlag.value = "month";
    	        		form.schDate.value = "";
    	        		form.schDateTo.value = "";
    	        		form.schYear.value = "";
    	        		form.schYearTo.value = "";
    	        		form.schDt.value = form.schMonth.value.replace("-","");
    	        		form.schDtTo.value = form.schMonthTo.value.replace("-","");
    	        	} else if(form.btn_periodFlag[2].checked) {
    	        		form.periodFlag.value = "year";
    	        		form.schDate.value = "";
    	        		form.schDateTo.value = "";
    	        		form.schMonth.value = "";
    	        		form.schMonthTo.value = "";
    	        		form.schDt.value = form.schYear.value;
    	        		form.schDtTo.value = form.schYearTo.value;
    	        	}

    	        	if(form.vslSize1.value != '' && form.vslSize2.value != '') {
	    	        	if(form.btn_vslSizeFlag[0].checked) {
	     					form.vslSizeFlag.value = "max";
	     				} else if(form.btn_vslSizeFlag[1].checked) {
	     					form.vslSizeFlag.value = "14ton";
	     				}
    	    		} else {
    	    			form.vslSizeFlag.value = "";
    	    		}
    	        	
    	        	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	            break;
    			
    			case "btn_new":
    				ComResetAll();
    				
    				document.getElementById("style1").style.display = "";
 					document.getElementById("style2").style.display = "none";
 					document.getElementById("style3").style.display = "none";
 					
    				sheetObjects[0].ScrollBar = 1;
    				sheetObjects[1].style.height = 0;
  	  				controlScrollBar();
    	            break;
    	
    			case "btn_savetofile":
    				//sheetObject.SpeedDown2Excel(-1);
    				//sheetObject.Down2Excel(-1);
    				speedDown2Excel();
    	            break;

    			case "btn_print":
    				rdOpen(rdObjects[0], document.form);
    	            break;

    			case "btn_schDate":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.schDate, 'yyyy-MM-dd');
    				break;
    				
    			case "btn_schDateTo":
    				var cal = new ComCalendar();
    				cal.setDisplayType('date');
					cal.select(form.schDateTo, 'yyyy-MM-dd');
    				break;
    				
    			case "btn_schMonth":
    				var cal = new ComCalendar();
    				cal.setDisplayType('month');
					cal.select(form.schMonth, 'yyyy-MM');
    				break;
    				
    			case "btn_schMonthTo":
    				var cal = new ComCalendar();
    				cal.setDisplayType('month');
					cal.select(form.schMonthTo, 'yyyy-MM');
    				break;
    				
    			case "btn_schYear":
    				var cal = new ComCalendar();
    				cal.setDisplayType('year');
 					cal.select(form.schYear, 'yyyy');
 					break;
 					
    			case "btn_schYearTo":
    				var cal = new ComCalendar();
    				cal.setDisplayType('year');
 					cal.select(form.schYearTo, 'yyyy');
 					break;

    			case "btn_periodFlag":
     				if(form.btn_periodFlag[0].checked) {
     					document.getElementById("style1").style.display = "";
     					document.getElementById("style2").style.display = "none";
     					document.getElementById("style3").style.display = "none";     					
     				} else if(form.btn_periodFlag[1].checked) {
     					document.getElementById("style1").style.display = "none";
     					document.getElementById("style2").style.display = "";
     					document.getElementById("style3").style.display = "none";
     				} else if(form.btn_periodFlag[2].checked) {
     					document.getElementById("style1").style.display = "none";
     					document.getElementById("style2").style.display = "none";
     					document.getElementById("style3").style.display = "";
     				}
     				break;

    			case "btn_owner":
     				ComOpenPopup("ESM_FMS_0083.do", 500, 375, "setFromOwnerName", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0083");
     				break;

    			case "btn_ownrClr":
     				form.ownrNm.value = "";
     				form.ownrSeq.value = "";
     				break;
     			
    			case "btn_laneCd":
     				ComOpenPopup("ESM_FMS_0036.do", 620, 430, "setFromLaneCd", "1,0,1,1,1", false, false, null, null, null, "esm_fms_0036");
     				break;

    			case "btn_laneCdClr":
    				form.laneCd.value = "";
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
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage() {
    	for(i=0;i<sheetObjects.length;i++){
    		//khlee-시작 환경 설정 함수 이름 변경
    	    ComConfigSheet (sheetObjects[i] );
    	
    	    initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    	    ComEndConfigSheet(sheetObjects[i]);
    	    
    	    sheetObjects[i].ExtendLastCol = false;
    	}

    	//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"contractType");
    	
    	initControl();
    	
    	//RD
		initRdConfig(rdObjects[0]);
    }
    
    /**
     * body 태그의 onLoad 이벤트핸들러 구현 후 DB 호출시 Sheet 화면 깜빡임 방지
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function sheet1_OnLoadFinish(sheetObj) {  
    	sheetObj.WaitImageVisible = false;
    	
    	doActionIBSheet(sheetObj,document.form,IBSEARCH,"contractType");
		
		sheetObj.WaitImageVisible = true;   
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
    	            style.height = 351;
    	            //전체 너비 설정
    	            SheetWidth = mainTable.clientWidth;
    	
    	            //Host정보 설정[필수][HostIp, Port, PagePath]
    	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    	
    	            //전체Merge 종류 [선택, Default msNone]
    	            MergeSheet = msHeaderOnly;
    	            //MergeSheet =  msNone;
    	
    	            //전체Edit 허용 여부 [선택, Default false]
    	            Editable = true;
    	
    	            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    	            InitRowInfo( 2, 1, 3, 100);
    	
    	            // 해더에서 처리할 수 있는 각종 기능을 설정한다
    	            InitHeadMode(true, true, false, true, false,false);
    	
    	            var HeadTitle1 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
    				var HeadTitle2 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
    				var headCount = ComCountHeadTitle(HeadTitle1);
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    	            InitColumnInfo(headCount, 5, 0, true);

                	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                	InitHeadRow(0, HeadTitle1, true);
    				InitHeadRow(1, HeadTitle2, true);

                	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtDataSeq, 	85,		daCenter,  	true,    "Seq");
    				InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "flet_ctrt_tp_cd",    		false,	"",		dfNone,			0,		false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "vsl_cd",     	 			false,  "", 	dfNone, 		0,  	false,		false);
                	InitDataProperty(0, cnt++ , dtData,   	150,   	daLeft,  	true,    "vsl_eng_nm",   			false,  "", 	dfNone, 		0,  	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	180,   	daLeft,  	true,    "ownr_nm",     			false,  "",		dfNone, 		0,  	false,		false);                                                    
    				InitDataProperty(0, cnt++ , dtData,   	50,    	daCenter,  	true,    "vsl_cnt_cd",  			false,  "",     dfNone,  		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	true,    "vsl_bld_dt",     			false,  "",     dfDateYmd,  	0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "vsl_dznd_capa",     	 	false,  "",     dfInteger, 		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "bse_14ton_vsl_capa",     	false,  "",     dfInteger,		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "eff_dt",  				false,  "",     dfDateYmd,    	0,     	false,		false);                                
    				InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "exp_dt",    				false,  "",     dfDateYmd,     	0,     	false,		false);				
    				InitDataProperty(0, cnt++ , dtData,		75,    	daCenter,  	false,   "hir_curr_n1st_cd",    	false,  "",     dfNone,   		0,     	false,		false);				
    				InitDataProperty(0, cnt++ , dtData,		80,    	daRight,   	false,   "hir_rt_n1st_amt",    		false,  "",     dfNullFloat,   	2,     	false,		false);				
    				InitDataProperty(0, cnt++ , dtData,   	75,    	daCenter,  	true,    "hir_curr_n2nd_cd",  		false,  "",     dfNone,  		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	80,    	daRight,  	true,    "hir_rt_n2nd_amt",     	false,  "",     dfNullFloat,  	2,     	false,		false);                   
    				InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "slan_cd",     	 		false,  "",     dfNone,     	0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "gr_flg",     				false, 	"",     dfNone,   		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,  	85,    	daRight,  	true,    "rf_cntr_plg_qty",  		false,  "",     dfInteger,  	0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,  	80,    	daRight,  	true,    "shp_spd_qty",  			false,  "",     dfFloat,   		2,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,  	100,    daRight,  	true,    "ddwt_cgo_capa_qty",     	false,  "",     dfFloat,   		2,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	100,   	daRight,  	true,    "grs_wgt",     	 		false,  "",     dfFloat,    	2,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	80,   	daRight,  	true,    "nrt_wgt",     			false,  "",     dfInteger,		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "chtr_prd_opt_ctnt",  		false,  "",     dfNone,    		0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_rng_ctnt",     		false,  "",     dfNone,			0,     	false,		false);
    				InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_ntc_ctnt",  			false,  "",     dfNone,			0,     	false,		false);
           		}
            	break;
        	case 2:      //sheet2 init
	        	with (sheetObj) {
	
		            // 높이 설정
		            style.height = 0;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		            //MergeSheet =  msNone;
		            
		
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 2, 1, 3, 100);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(false, true, false, true, false, false);
		
		            var HeadTitle1 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
					var HeadTitle2 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 5, 0, true);
	
	            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            	InitHeadRow(0, HeadTitle1, true, true);
					InitHeadRow(1, HeadTitle2, true, true);
	
	            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtDataSeq, 	85,		daCenter,  	true,    "Seq");
					InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "flet_ctrt_tp_cd",    		false,	"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "vsl_cd",     	 			false,  "", 	dfNone, 		0,  	false,		false);
	            	InitDataProperty(0, cnt++ , dtData,   	150,   	daLeft,  	true,    "vsl_eng_nm",   			false,  "", 	dfNone, 		0,  	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	180,   	daLeft,  	true,    "ownr_nm",     			false,  "",		dfNone, 		0,  	false,		false);                                                    
					InitDataProperty(0, cnt++ , dtData,   	50,    	daCenter,  	true,    "vsl_cnt_cd",  			false,  "",     dfNone,  		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	true,    "vsl_bld_dt",     			false,  "",     dfDateYmd,  	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "vsl_dznd_capa",     	 	false,  "",     dfNullInteger,  0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "bse_14ton_vsl_capa",     	false,  "",     dfNullInteger,	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "eff_dt",  				false,  "",     dfDateYmd,    	0,     	false,		false);                                
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "exp_dt",    				false,  "",     dfDateYmd,     	0,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,		75,    	daCenter,  	false,   "hir_curr_n1st_cd",    	false,  "",     dfNone,   		0,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,		80,    	daRight,   	false,   "hir_rt_n1st_amt",    		false,  "",     dfNullFloat,   	2,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,   	75,    	daCenter,  	true,    "hir_curr_n2nd_cd",  		false,  "",     dfNone,  		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	80,    	daRight,  	true,    "hir_rt_n2nd_amt",     	false,  "",     dfNullFloat,  	2,     	false,		false);                   
					InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "slan_cd",     	 		false,  "",     dfNone,     	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "gr_flg",     				false, 	"",     dfNone,   		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	85,    	daRight,  	true,    "rf_cntr_plg_qty",  		false,  "",     dfNullInteger,  0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	80,    	daRight,  	true,    "shp_spd_qty",  			false,  "",     dfNullFloat,   	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	100,    daRight,  	true,    "ddwt_cgo_capa_qty",     	false,  "",     dfNullFloat,   	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	100,   	daRight,  	true,    "grs_wgt",     	 		false,  "",     dfNullFloat,   	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	80,   	daRight,  	true,    "nrt_wgt",     			false,  "",     dfNullInteger,	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "chtr_prd_opt_ctnt",  		false,  "",     dfNone,    		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_rng_ctnt",     		false,  "",     dfNone,			0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_ntc_ctnt",  			false,  "",     dfNone,			0,     	false,		false);

 					CountPosition = 0;
					SelectHighLight = false;
					SelectFontBold = false;
	        	}
	        	break;
	        	
        	case 3:      //sheet3 init
	        	with (sheetObj) {
	
		            // 높이 설정
		            style.height = 0;
		            //전체 너비 설정
		            SheetWidth = 0;
		
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		            //전체Merge 종류 [선택, Default msNone]
		            MergeSheet = msHeaderOnly;
		
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo( 2, 1, 3, 100);
		
		            // 해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false,false);
		
		            var HeadTitle1 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Designed TEU|Designed TEU|Charter Period|Charter Period|Daily Hire Rate1|Daily Hire Rate1|Daily Hire Rate2|Daily Hire Rate2|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
					var HeadTitle2 = "Seq|Contract|Vessel\nCode|Vessel's \nFull Name|Owners|Flag|Built|Max|14Ton|From|To|CURR|AMT|CURR|AMT|Lane|Gear with|Reefer|Speed|Dead Weight|Gross Ton|Net|Period (+- Option)|Redelivery Range|Redelivery Notice";
					var headCount = ComCountHeadTitle(HeadTitle1);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(headCount, 5, 0, true);
	
	            	//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            	InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
	
	            	//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,   	80,    	daCenter,  	true,    "Seq",    					false,	"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "flet_ctrt_tp_cd",    		false,	"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,   	60,    	daCenter,  	true,    "vsl_cd",     	 			false,  "", 	dfNone, 		0,  	false,		false);
	            	InitDataProperty(0, cnt++ , dtData,   	150,   	daLeft,  	true,    "vsl_eng_nm",   			false,  "", 	dfNone, 		0,  	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	180,   	daLeft,  	true,    "ownr_nm",     			false,  "",		dfNone, 		0,  	false,		false);                                                    
					InitDataProperty(0, cnt++ , dtData,   	50,    	daCenter,  	true,    "vsl_cnt_cd",  			false,  "",     dfNone,  		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	true,    "vsl_bld_dt",     			false,  "",     dfDateYmd,  	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "vsl_dznd_capa",     	 	false,  "",     dfNullInteger, 	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,		70,    	daRight,   	false,   "bse_14ton_vsl_capa",     	false,  "",     dfNullInteger,	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "eff_dt",  				false,  "",     dfDateYmd,    	0,     	false,		false);                                
					InitDataProperty(0, cnt++ , dtData,   	85,    	daCenter,  	false,   "exp_dt",    				false,  "",     dfDateYmd,     	0,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,		75,    	daCenter,  	false,   "hir_curr_n1st_cd",    	false,  "",     dfNone,   		0,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,		75,    	daRight,   	false,   "hir_rt_n1st_amt",    		false,  "",     dfNullFloat,   	2,     	false,		false);				
					InitDataProperty(0, cnt++ , dtData,   	75,    	daCenter,  	true,    "hir_curr_n2nd_cd",  		false,  "",     dfNone,  		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	75,    	daRight,  	true,    "hir_rt_n2nd_amt",     	false,  "",     dfNullFloat,  	2,     	false,		false);                   
					InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "slan_cd",     	 		false,  "",     dfNone,     	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	70,    	daCenter,  	true,    "gr_flg",     				false, 	"",     dfNone,   		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	85,    	daRight,  	true,    "rf_cntr_plg_qty",  		false,  "",     dfNullInteger,  0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	80,    	daRight,  	true,    "shp_spd_qty",  			false,  "",     dfNullFloat,	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,  	100,    daRight,  	true,    "ddwt_cgo_capa_qty",     	false,  "",     dfNullFloat,   	2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	100,   	daRight,  	true,    "grs_wgt",     	 		false,  "",     dfNullFloat,    2,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	80,   	daRight,  	true,    "nrt_wgt",     			false,  "",     dfNullInteger,	0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "chtr_prd_opt_ctnt",  		false,  "",     dfNone,    		0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_rng_ctnt",     		false,  "",     dfNone,			0,     	false,		false);
					InitDataProperty(0, cnt++ , dtData,   	200,   	daLeft,  	true,    "rde_ntc_ctnt",  			false,  "",     dfNone,			0,     	false,		false);
	       		}
	        	break;
    	}
    }

    /**
     * IBSheet 관련 각종 기능(조회,저장 등)을 처리한다.<br>
     **/
    function doActionIBSheet(sheetObj,formObj,sAction,objNm) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:
	    		if(objNm == "laneCd") {
		      		formObj.f_cmd.value = SEARCH05;
		    		
		      		var param = FormQueryString(formObj) + "&lane_cd=" + formObj.laneCd.value;
		   			var sXml = sheetObj.GetSearchXml("ESM_FMS_0022GS.do", param);
		   			var laneNm = ComGetEtcData(sXml, "cdName");
		
		   			if(typeof laneNm != "undefined" && laneNm != "" ) {
		   				form.btn_laneCdClr.checked = true;
					} else {
						form.btn_laneCdClr.checked = false;
						formObj.laneCd.value = "";
						// 존재하지 않는Lane Code입니다
						ComAlertFocus(formObj.laneCd, ComGetMsg("FMS00006", "Lane Code"));
					}
	    		} else if(objNm == "contractType") {
	    			CoFmsGetCombo("FORM", formObj, sheetObj, "CD01513", "contractType", "contractTypeText");
	    		} else {
		      		if(validateForm(sheetObj,formObj,sAction)) {
		      			formObj.f_cmd.value = SEARCH;
						//sheetObj.DoSearch("ESM_FMS_0060GS.do", FormQueryString(formObj));
						var sXml = sheetObj.GetSearchXml("ESM_FMS_0060GS.do", FormQueryString(formObj));
	       	   	  		var arrXml = sXml.split("|$$|");

	       	   	  		if (arrXml.length > 0) {
	       	   	  			sheetObjects[0].LoadSearchXml(arrXml[0]);
	       	   	  			sheetObjects[1].RemoveAll();
	       	   	  			sheetObjects[1].LoadSearchXml(arrXml[1]);
	       	   	  			var total = ComFmsGetAttr(arrXml[1], "DATA", "TOTAL");
	       	   	  			if(total > 0) {
	       	   	  				sheetObjects[1].style.height = 40 + (total * 20);
	       	   	  			} else {
	       	   	  				sheetObjects[1].style.height = 0;
	       	   	  			}
	       	   	  			controlScrollBar();
	       	   	  		} else {
	       	   	  			sheetObjects[1].style.height = 0;
	       	   	  		}
		      		}
	    		}
		       	break;
    	}
    }

    /**
     * 화면 폼입력값에 대한 Validation을 체크한다.<br>
     */
    function validateForm(sheetObj,formObj,sAction){
    	var	exptElems = "";
    	if(form.btn_periodFlag[0].checked) {
    		exptElems = "schMonth|schYear|schMonthTo|schYearTo";
    	} else if(form.btn_periodFlag[1].checked) {
    		exptElems = "schDate|schYear|schDateTo|schYearTo";
    	} else if(form.btn_periodFlag[2].checked) {
    		exptElems = "schDate|schMonth|schDateTo|schMonthTo";
    	}

    	if (!ComFmsChkValid(formObj, exptElems)) {
    		return false;
    	}
    	
    	if(form.btn_periodFlag[0].checked) {
	    	if(parseInt(formObj.schDate.value.trimAll('-')) > parseInt(formObj.schDateTo.value.trimAll('-'))) {
	    		formObj.schDate.value = "";
				ComAlertFocus(formObj.schDate, ComGetMsg('FMS01715'));
				return;
			}
    	} else if(form.btn_periodFlag[1].checked) {
    		if(parseInt(formObj.schMonth.value.trimAll('-')) > parseInt(formObj.schMonthTo.value.trimAll('-'))) {
	    		formObj.schMonth.value = "";
				ComAlertFocus(formObj.schMonth, ComGetMsg('FMS01715'));
				return;
			}
    	} else if(form.btn_periodFlag[2].checked) {
    		if(parseInt(formObj.schYear.value.trimAll('-')) > parseInt(formObj.schYearTo.value.trimAll('-'))) {
	    		formObj.schYear.value = "";
				ComAlertFocus(formObj.schYear, ComGetMsg('FMS01715'));
				return;
			}
    	}
    	
    	if((form.vslSize1.value == "") && (form.vslSize2.value == "")) {
    		form.vslSizeFlag.value = "";
    	}
    	
    	if((formObj.vslSize1.value == "") &&
 		   (formObj.vslSize2.value != "")) {
 			// Vessel Size를 정확히 입력해주세요
 			ComAlertFocus(formObj.vslSize1, ComGetMsg("FMS00011", "Vessel Size"));
 			return false;
 		}
 		
 		if((formObj.vslSize1.value != "") &&
 		   (formObj.vslSize2.value == "")) {
 			// Vessel Size를 정확히 입력해주세요
 			ComAlertFocus(formObj.vslSize2, ComGetMsg("FMS00011", "Vessel Size"));
 			return false;
 		}

 		if(parseInt(formObj.vslSize1.value.replace(/,/g,"")) > parseInt(formObj.vslSize2.value.replace(/,/g,""))) {
 			vslSize2.value = "";
 			// To Vessel Size는 From Vessel Size보다 커야 합니다
 			ComAlertFocus(formObj.vslSize2, ComGetMsg("FMS00010", "To Vessel Size", "From Vessel Size"));
 			return false;
 		}
     		
    	return true;
    }

	/**
	 * Owner List 팝업창에서 선택한 Head Ownership Name과 시퀀스를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFromOwnerName(aryPopupData){
        form.ownrSeq.value = aryPopupData[0][3];
        form.ownrNm.value = aryPopupData[0][4];
        form.btn_ownrClr.checked = true;
	}

	/**
	 * Lane Code 팝업창에서 선택한 Lane Code를 Form항목에 설정한다.<br>
	 * @param {arry} aryPopupData
	 */
	function setFromLaneCd(aryPopupData){
        form.laneCd.value = aryPopupData[0][3];
        form.btn_laneCdClr.checked = true;
	}

	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/
	function initControl() {
		//** Date 구분자 **/
		DATE_SEPARATOR = "-";
	
		//Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); 	//- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
		axon_event.addListenerFormat('keypress', 'obj_keypress', form); 			//- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress 이벤트에 코드 처리
		axon_event.addListenerForm  ('keypress', 'eng_keypress', form); 			//- form 전체 컨트롤 모든 컨트롤의 OnKeypress이벤트에 코드 처리
		axon_event.addListenerForm  ('change', 'obj_change', form); 				//- form 전체 컨트롤 모든 컨트롤의 OnChange이벤트에 코드 처리
		axon_event.addListenerFormat('focus', 'obj_activate', form);
	}
	
	/**
     * HTML Control의 onblur이벤트에서 Duration의 Validation을 체크한다.<br>
     **/
    function obj_deactivate(){
    	if((event.srcElement.name == "schDate") ||
    	   (event.srcElement.name == "schMonth") ||
    	   (event.srcElement.name == "schYear")) {
    		ComChkObjValid(event.srcElement);
    	} else {
    		ComChkObjValid(event.srcElement);
    	}
    }

    /**
     * HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다.<br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    /**
      * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
      **/
	function eng_keypress() {
        if((event.srcElement.name == "laneCd")) { 
	 		//영대문자 자동변환
	 		ComKeyOnlyAlphabet('uppernum');
	 	}
	}

    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다.<br>
     **/
	function obj_change() {
	  	if((event.srcElement.name == "laneCd")) {
	  		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"laneCd");
	   	}
	}
    
    /**
     * sheet1의 OnScroll 이벤트 발생시 sheet2의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet1_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[1].LeftCol = newLeftCol;
    }
    
    /**
     * sheet2의 OnScroll 이벤트 발생시 sheet1의 스크롤 위치를 동일하게 설정한다.<br>
     */
    function sheet2_OnScroll(sheetObj, olTopRow, oldLeftCol, newTopRow, newLeftCol) {
    	sheetObjects[0].LeftCol = newLeftCol;
    }
    
    /**
     * sheet2의 OnSearchEnd 이벤트 발생시 조회된 데이터의 폰트를 Bold로 변경한다.<br>
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg) {
    	if(sheetObj.RowCount > 0) {
    		//sheetObjects[0].ScrollBar = 2
     	}
    	 
    	for(var row=2; row<=sheetObj.LastRow; row++) {
    		if(row == 2) {
    			sheetObj.CellText(row, "Seq") = "Total Amount";
    		} else {
    			sheetObj.CellText(row, "Seq") = "";
    		}
    		sheetObj.RowBackColor(row) = sheetObj.RgbColor(255,230,251); 
    		sheetObj.CellFont("FontBold", row, "Seq") = true;
    		sheetObj.CellFont("FontBold", row, "flet_ctrt_tp_cd") = true;
    		sheetObj.CellFont("FontBold", row, "ownr_nm") = true;
    		sheetObj.CellFont("FontBold", row, "vsl_dznd_capa") = true;
    		sheetObj.CellFont("FontBold", row, "bse_14ton_vsl_capa") = true;
    		sheetObj.CellFont("FontBold", row, "hir_curr_n1st_cd") = true;
    		sheetObj.CellFont("FontBold", row, "hir_rt_n1st_amt") = true;
    		sheetObj.CellFont("FontBold", row, "hir_curr_n2nd_cd") = true;
    		sheetObj.CellFont("FontBold", row, "hir_rt_n2nd_amt") = true;
    		sheetObj.CellFont("FontBold", row, "ddwt_cgo_capa_qty") = true;
    		sheetObj.CellFont("FontBold", row, "grs_wgt") = true;
    		sheetObj.CellFont("FontBold", row, "nrt_wgt") = true;
    	}
    }
    
    /**
     * 데이타 조회시 스크롤바를 자동으로 컨트롤한다.<br>
     **/
	function controlScrollBar() {
		try{
			top.syncHeight();
		} catch(err){ComFuncErrMsg(err.message);}
	}
     
    /**
 	 * 페이지에 있는 RD Object를 로드한다. <br>
 	 * {@link #loadPage}함수에서 이 함수를 호출하여 RD Object를 초기화 한다. <br>
 	 * @param {rdObject} rdObject    RD Object
 	 **/
 	function initRdConfig(rdObject){
 	    var Rdviewer = rdObject ;
 	    Rdviewer.style.height = 0;
 	    Rdviewer.style.width = 0;
 	    
 	    Rdviewer.AutoAdjust = true;
 	    Rdviewer.ViewShowMode(0);

 		Rdviewer.setbackgroundcolor(128,128,128);
 		Rdviewer.SetPageLineColor(128,128,128);
 	}
 	
 	/**
 	 * 조회된 정보를 인쇄한다.<br>
 	 */
 	function rdOpen(rdObject, formObject){
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00015");
 			return;
 		}
 		
		var Rdviewer = rdObject ;
	
		rdParam = RD_FormQueryString(formObject,1);
		var rdParam = '/rv '+ rdParam;
		var rdFile = 'ESM_FMS_061.mrd';

		// 열고자 하는 RD 파일을 지정한다.
	    Rdviewer.FileOpen(RD_path+'apps/alps/esm/fms/timecharterinoutfleetmanagement/tcharterioinquiry/report/'+rdFile, RDServer+rdParam);
		Rdviewer.CMPrint (); //인쇄 시작
	}
 	
 	/**
 	 * sheet가 분리되어 있는 데이타부분과 합계부분을 같이 출력하기 위해 임시 sheet에 데이타를 옮기후 엑셀로 출력한다.<br>
 	 */
 	function speedDown2Excel() {
 		if(sheetObjects[0].RowCount == 0) {
 			ComShowCodeMessage("FMS00016");
 			return;
 		}
 		
    	var targetSheetObj = sheetObjects[2];
    	
    	for(var row=2; row<=sheetObjects[0].LastRow; row++) {
    		var currRow = targetSheetObj.DataInsert();
    		
    		targetSheetObj.CellText(currRow,"Seq") = sheetObjects[0].CellText(row,"Seq");
    		targetSheetObj.CellValue2(currRow,"flet_ctrt_tp_cd") = sheetObjects[0].CellValue(row,"flet_ctrt_tp_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_cd") = sheetObjects[0].CellValue(row,"vsl_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_eng_nm") = sheetObjects[0].CellValue(row,"vsl_eng_nm");
    		targetSheetObj.CellValue2(currRow,"ownr_nm") = sheetObjects[0].CellValue(row,"ownr_nm");
    		targetSheetObj.CellValue2(currRow,"vsl_cnt_cd") = sheetObjects[0].CellValue(row,"vsl_cnt_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_bld_dt") = sheetObjects[0].CellValue(row,"vsl_bld_dt");
    		targetSheetObj.CellValue2(currRow,"vsl_dznd_capa") = sheetObjects[0].CellValue(row,"vsl_dznd_capa");
    		targetSheetObj.CellValue2(currRow,"bse_14ton_vsl_capa") = sheetObjects[0].CellValue(row,"bse_14ton_vsl_capa");
    		targetSheetObj.CellValue2(currRow,"eff_dt") = sheetObjects[0].CellValue(row,"eff_dt");
    		targetSheetObj.CellValue2(currRow,"exp_dt") = sheetObjects[0].CellValue(row,"exp_dt");
    		targetSheetObj.CellValue2(currRow,"hir_curr_n1st_cd") = sheetObjects[0].CellValue(row,"hir_curr_n1st_cd");
    		targetSheetObj.CellValue2(currRow,"hir_rt_n1st_amt") = sheetObjects[0].CellValue(row,"hir_rt_n1st_amt");
    		targetSheetObj.CellValue2(currRow,"hir_curr_n2nd_cd") = sheetObjects[0].CellValue(row,"hir_curr_n2nd_cd");
    		targetSheetObj.CellValue2(currRow,"hir_rt_n2nd_amt") = sheetObjects[0].CellValue(row,"hir_rt_n2nd_amt");
    		targetSheetObj.CellValue2(currRow,"slan_cd") = sheetObjects[0].CellValue(row,"slan_cd");
    		targetSheetObj.CellValue2(currRow,"gr_flg") = sheetObjects[0].CellValue(row,"gr_flg");
    		targetSheetObj.CellValue2(currRow,"slan_cd") = sheetObjects[0].CellValue(row,"slan_cd");
    		targetSheetObj.CellValue2(currRow,"rf_cntr_plg_qty") = sheetObjects[0].CellValue(row,"rf_cntr_plg_qty");
    		targetSheetObj.CellValue2(currRow,"shp_spd_qty") = sheetObjects[0].CellValue(row,"shp_spd_qty");
    		targetSheetObj.CellValue2(currRow,"ddwt_cgo_capa_qty") = sheetObjects[0].CellValue(row,"ddwt_cgo_capa_qty");
    		targetSheetObj.CellValue2(currRow,"grs_wgt") = sheetObjects[0].CellValue(row,"grs_wgt");
    		targetSheetObj.CellValue2(currRow,"nrt_wgt") = sheetObjects[0].CellValue(row,"nrt_wgt");
    		targetSheetObj.CellValue2(currRow,"chtr_prd_opt_ctnt") = sheetObjects[0].CellValue(row,"chtr_prd_opt_ctnt");
    		targetSheetObj.CellValue2(currRow,"rde_rng_ctnt") = sheetObjects[0].CellValue(row,"rde_rng_ctnt");
    		targetSheetObj.CellValue2(currRow,"rde_ntc_ctnt") = sheetObjects[0].CellValue(row,"rde_ntc_ctnt");
    	}
    	
    	for(var row=2; row<=sheetObjects[1].LastRow; row++) {
    		var currRow = targetSheetObj.DataInsert();
    		
    		if(row == 2) {
    			targetSheetObj.CellValue2(currRow,"Seq") = "Total Amount";
    		}
    		targetSheetObj.CellValue2(currRow,"flet_ctrt_tp_cd") = sheetObjects[1].CellValue(row,"flet_ctrt_tp_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_cd") = sheetObjects[1].CellValue(row,"vsl_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_eng_nm") = sheetObjects[1].CellValue(row,"vsl_eng_nm");
    		targetSheetObj.CellValue2(currRow,"ownr_nm") = sheetObjects[1].CellValue(row,"ownr_nm");
    		targetSheetObj.CellValue2(currRow,"vsl_cnt_cd") = sheetObjects[1].CellValue(row,"vsl_cnt_cd");
    		targetSheetObj.CellValue2(currRow,"vsl_bld_dt") = sheetObjects[1].CellValue(row,"vsl_bld_dt");
    		targetSheetObj.CellValue2(currRow,"vsl_dznd_capa") = sheetObjects[1].CellValue(row,"vsl_dznd_capa");
    		targetSheetObj.CellValue2(currRow,"bse_14ton_vsl_capa") = sheetObjects[1].CellValue(row,"bse_14ton_vsl_capa");
    		targetSheetObj.CellValue2(currRow,"eff_dt") = sheetObjects[1].CellValue(row,"eff_dt");
    		targetSheetObj.CellValue2(currRow,"exp_dt") = sheetObjects[1].CellValue(row,"exp_dt");
    		targetSheetObj.CellValue2(currRow,"hir_curr_n1st_cd") = sheetObjects[1].CellValue(row,"hir_curr_n1st_cd");
    		targetSheetObj.CellValue2(currRow,"hir_rt_n1st_amt") = sheetObjects[1].CellValue(row,"hir_rt_n1st_amt");
    		targetSheetObj.CellValue2(currRow,"hir_curr_n2nd_cd") = sheetObjects[1].CellValue(row,"hir_curr_n2nd_cd");
    		targetSheetObj.CellValue2(currRow,"hir_rt_n2nd_amt") = sheetObjects[1].CellValue(row,"hir_rt_n2nd_amt");
    		targetSheetObj.CellValue2(currRow,"slan_cd") = sheetObjects[1].CellValue(row,"slan_cd");
    		targetSheetObj.CellValue2(currRow,"gr_flg") = sheetObjects[1].CellValue(row,"gr_flg");
    		targetSheetObj.CellValue2(currRow,"slan_cd") = sheetObjects[1].CellValue(row,"slan_cd");
    		targetSheetObj.CellValue2(currRow,"rf_cntr_plg_qty") = sheetObjects[1].CellValue(row,"rf_cntr_plg_qty");
    		targetSheetObj.CellValue2(currRow,"shp_spd_qty") = sheetObjects[1].CellValue(row,"shp_spd_qty");
    		targetSheetObj.CellValue2(currRow,"ddwt_cgo_capa_qty") = sheetObjects[1].CellValue(row,"ddwt_cgo_capa_qty");
    		targetSheetObj.CellValue2(currRow,"grs_wgt") = sheetObjects[1].CellValue(row,"grs_wgt");
    		targetSheetObj.CellValue2(currRow,"nrt_wgt") = sheetObjects[1].CellValue(row,"nrt_wgt");
    		targetSheetObj.CellValue2(currRow,"chtr_prd_opt_ctnt") = sheetObjects[1].CellValue(row,"chtr_prd_opt_ctnt");
    		targetSheetObj.CellValue2(currRow,"rde_rng_ctnt") = sheetObjects[1].CellValue(row,"rde_rng_ctnt");
    		targetSheetObj.CellValue2(currRow,"rde_ntc_ctnt") = sheetObjects[1].CellValue(row,"rde_ntc_ctnt");
    	}
    	
    	targetSheetObj.Down2Excel(-1);
    	
    	targetSheetObj.RemoveAll();
    }
 	
 	/**
	 * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다.<br>
	 */
	function obj_activate() {
		ComClearSeparator(event.srcElement);
	}
	
	/**
	 * vsl_cd의 Font를 변경한다.
	 */
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		ComColFontName(sheetObj, "vsl_cd", "Courier New"); 
	}
	/* 개발자 작업  끝 */