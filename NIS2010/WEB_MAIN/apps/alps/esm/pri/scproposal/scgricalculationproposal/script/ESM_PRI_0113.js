/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0113.js
*@FileTitle : GRI Calculation - Arbitray
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.09.16 박성수
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview E-Service Compensation Creation 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Pri
 * @class ESM_PRI_0109:ESM_PRI_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_PRI_0109 : ESM_PRI_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_PRI_0113() {
	this.setSheetObject 		= setSheetObject;
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.obj_click              = obj_click;
	this.processButtonClick		= processButtonClick;
	this.sheet3_OnSearchEnd     = sheet3_OnSearchEnd;
	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
	this.sheet5_OnSearchEnd     = sheet5_OnSearchEnd;
	this.sheet1_OnComboChange   = sheet1_OnComboChange;
	this.sheet1_OnSaveEnd       = sheet1_OnSaveEnd;
	this.sheet6_OnSaveEnd       = sheet6_OnSaveEnd;	
	this.sheet1_OnSelectCell    = sheet1_OnSelectCell;	
	this.sheet1_OnSort          = sheet1_OnSort;
	this.setPointComboMake      = setPointComboMake;
	this.setCurrencyComboMake   = setCurrencyComboMake;
	this.setSheet1ComboNextMake = setSheet1ComboNextMake;
	this.setSheet1ComboInit     = setSheet1ComboInit;
	this.setChkAppDupRow        = setChkAppDupRow;
	this.setEditAmtPer          = setEditAmtPer;
	this.doActionIBSheet 		= doActionIBSheet;
	this.doActionIBSheet2 		= doActionIBSheet2;
	this.doActionIBSheet3 		= doActionIBSheet3;
	this.doActionIBSheet5 		= doActionIBSheet5;		
	this.doActionIBSheet6 		= doActionIBSheet6;		
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
var sheet2;
var sheet3;
var sheet4;
//부모창 객체
var vOpener = window.dialogArguments;
// Sheet1 Column 정보
var C1_GRPSEQ         = "gri_grp_seq";
//var C1_APPL_OPTION    = "flt_pct_tp_cd";
var C1_APPLICATION    = "gri_appl_div_cd";
var C1_POINT          = "rout_pnt_loc_def_cd";
var C1_TRANSMODE      = "prc_trsp_mod_cd";
var C1_TERM 		  = "rcv_de_term_cd";
var C1_BASEPORT 	  = "bse_port_def_cd";
var C1_VIA            = "via_port_def_cd";
var C1_POINT_O        = "point_o";
var C1_TRANSMODE_O    = "transmode_o";
var C1_TERM_O 		  = "term_o";
var C1_BASEPORT_O 	  = "baseport_o";
var C1_VIA_O          = "via_o";
//Sheet2 Column 정보
var C2_PER       = "rat_ut_cd";
var C2_CARGOTYPE = "prc_cgo_tp_cd";
var C2_CURRENCY  = "curr_cd";
var C2_AMT       = "gri_rt_amt";
var C2_RTO       = "gri_rt_rto";
//Sheet3 Column 정보
var C3_POINT        = "rout_pnt_loc_def_cd";
var C3_POINT_NM     = "rout_pnt_loc_def_nm";
var C3_TRANSMODE    = "prc_trsp_mod_cd";
var C3_TRANSMODE_NM = "prc_trsp_mod_nm";
var C3_TERM 		= "rcv_de_term_cd";
var C3_TERM_NM 		= "rcv_de_term_nm";
var C3_BASEPORT 	= "bse_port_def_cd";
var C3_BASEPORT_NM 	= "bse_port_def_nm";
var C3_VIA          = "via_port_def_cd";
var C3_VIA_NM       = "via_port_def_nm";
var C3_CURRENCY     = "curr_cd";
//Sheet5 Column 정보
var C5_APPLICATION    = "gri_appl_div_cd";
var C5_POINT          = "rout_pnt_loc_def_cd";
var C5_TRANSMODE      = "prc_trsp_mod_cd";
var C5_TERM 		  = "rcv_de_term_cd";
var C5_BASEPORT 	  = "bse_port_def_cd";
var C5_VIA            = "via_port_def_cd";
var C5_APPL_OPTION    = "flt_pct_tp_cd";
var C5_PER            = "rat_ut_cd";
var C5_CARGOTYPE      = "prc_cgo_tp_cd";
var C5_CURRENCY       = "curr_cd";
var C5_AMT            = "gri_rt_amt";
var C5_RTO            = "gri_rt_rto";
//Sheet6 Column 정보
var C6_POINT          = "rout_pnt_loc_def_cd";
var C6_TRANSMODE      = "prc_trsp_mod_cd";
var C6_TERM 		  = "rcv_de_term_cd";
var C6_BASEPORT 	  = "bse_port_def_cd";
var C6_VIA            = "via_port_def_cd";
var C6_PER            = "rat_ut_cd";
var C6_CARGOTYPE      = "prc_cgo_tp_cd";
var C6_CURRENCY       = "curr_cd";
var C6_APPL_OPTION    = "flt_pct_tp_cd";
var C6_AMT            = "gri_rt_amt";
var C6_RTO            = "gri_rt_rto";
//업무전역변수
var gIsSheet1SearchEnd = false;
var gBeforeRow = -1;
var gBeforeColName = "";
var gBeforeGrpSeq = "";
//필터콤보관련
var gArrPointRange = {};  // Point별 구간
var gArrPointCob = {}; // Point Mode 콤보
var gArrTransCob = {};    // Trans Mode 콤보
var gArrTermCob = {};     // Term 콤보
var gArrBPortCob = {};    // Base Port 콤보
var gArrVIACob = {};      // VIA 콤보

//===================================================================================
//페이지 초기화
//===================================================================================
/** 
* IBSheet Object를 sheetObjects 배열로 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj IBSheet Object
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* body 태그의 onLoad 이벤트핸들러 구현 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/
//var add_chg_tp_cd = form.add_chg_tp_cd.value; // CD01709 : ADDITIONAL CHARGE TYPE CODE  단일코드    VARCHAR2(1) ARB인지 IHC인 구분 코드  
//var n1st_cmnc_dt = form.n1st_cmnc_dt.value; //amd 시 날짜 - 안씀
function loadPage() {
	
 	var form = document.form;
 	
	if( form.prop_no.value == "" || form.amdt_seq.value == "" || form.svc_scp_cd.value == "" || form.add_chg_tp_cd.value == "" 
		|| form.org_dest_tp_cd.value == "" || form.gri_appl_tp_cd.value == "" ) {
		window.close();
	}
	
    sheet1 = sheetObjects[0]; // 상단 그리드
    sheet2 = sheetObjects[1]; // 하단 그리드
    sheet3 = sheetObjects[2]; // 콤보 그리드
    sheet4 = sheetObjects[3]; // find_text 용    
    sheet5 = sheetObjects[4]; // 적용할 모든 GRI Calculation
    sheet6 = sheetObjects[5]; // 적용 Abitrary 리스트  - 중복체크용
    sheetCnt = sheetObjects.length;

    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        sheetObjects[i].WaitImageVisible = false;
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    
    //html컨트롤 이벤트초기화
    initControl();

    //sheet3.WaitImageVisible = false;
    //ComOpenWait(true, false);
    doActionIBSheet3(sheet3, form, IBSEARCH); // 콤보 생성용 데이터를 먼저 가져온다.
    
    var statusObjValue = form.gri_appl_tp_cd.value;

    //ComOpenWait(false, false);
    
}

/** 
* Sheet 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBSheet} sheetObj : 시트오브젝트
* @param {int} sheetNo : 시트오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function initSheet(sheetObj, sheetNo) {

	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1": // 상단 그리드
	      	with (sheet1) {
		            //높이 설정
		            style.height = 130;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 3, 100);
                    HeadTitle1 = "ibflag|Seq.|prop_no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|Application|Point|TransMode|Term|BasePort|VIA|point org|trans org|term org|baseport org|via org";
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            DataAutoTrim = true;       
		            
//데이터속성         ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME             ,KEYFIELD,CALCULOGIC  ,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtHiddenStatus   ,30	    ,daCenter    ,false     ,"ibflag"                                                 );
InitDataProperty(0 ,cnt++ ,dtDataSeq		,40	    ,daCenter    ,false     ,"seq"                                                    );                                                                                                          
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,"prop_no"  		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,"amdt_seq"  		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,30	    ,daCenter	     ,false     ,"svc_scp_cd"  		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,"org_dest_tp_cd"	  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,C1_GRPSEQ  		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_APPLICATION		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_POINT	          ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_TRANSMODE		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_TERM		      ,false   ,""          ,dfNone    ,0 );    
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_BASEPORT		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C1_VIA		          ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,C1_POINT_O	          ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,C1_TRANSMODE_O		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,C1_TERM_O		      ,false   ,""          ,dfNone    ,0 );    
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,C1_BASEPORT_O		  ,false   ,""          ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,C1_VIA_O	          ,false   ,""          ,dfNone    ,0 );

					InitDataCombo(0, C1_APPLICATION, " |Include|Exclude", " |I|E", " ");
					InitComboNoMatchText(true);

						 
	        }
	      	break;
	      	
		case "sheet2": // 하단 그리드
	      	with (sheet2) {
		            //높이 설정
		            style.height = 130;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = false;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 3, 100);
                    var HeadTitle1 = "status|Seq.|prop no|amdt_seq|svc_scp_cd|org_dest_tp_cd|gri_grp_seq|gri_adj_seq|flt_pct_tp_cd|Per|Cargo Type|Currency|GRI Amount|Percentage(%)"
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            DataAutoTrim = true;      
		            
//데이터속성   ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME           ,KEYFIELD,CALCULOGIC  ,DATAFORMAT    ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtHiddenStatus   ,30	    ,daCenter    ,false     ,"ibflag"                                                 );
InitDataProperty(0 ,cnt++ ,dtDataSeq		,40	    ,daCenter    ,false     ,"seq"                                                    );                                                      
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daCenter	     ,false     ,"prop_no"  	  ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,"amdt_seq"  	  ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,30	    ,daCenter	     ,false     ,"svc_scp_cd"  	  ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,"org_dest_tp_cd" ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,30	    ,daCenter	     ,false     ,"gri_grp_seq"    ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,20	    ,daCenter	     ,false     ,"gri_adj_seq"    ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,30	    ,daCenter	     ,false     ,"flt_pct_tp_cd"  ,false   ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C2_PER		      ,false    ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,100    ,daCenter	     ,false     ,C2_CARGOTYPE	  ,false    ,""         ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtCombo		    ,80	    ,daCenter	     ,false     ,C2_CURRENCY	  ,false    ,""          ,dfNone        ,0 );
InitDataProperty(0 ,cnt++ ,dtData		    ,110    ,daRight     ,false     ,C2_AMT		      ,false   ,""          ,dfNullFloat   ,2       ,false      ,false     ,8 );    
InitDataProperty(0 ,cnt++ ,dtData		    ,100    ,daRight     ,false     ,C2_RTO		      ,false   ,""          ,dfNullInteger ,0       ,false      ,false     ,3 );

	        }
	      	break;
	      	
		case "sheet3": // 히든 그리드 : 부모 윈도우 에서 선택된 콤보 데이터
	      	with (sheet3) {
			
		            //높이 설정
		            style.height = 100;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 1, 100);
                    var HeadTitle1 = "rnum|Point|Point Nm|Trans\nMode|Trans\nMode Nm|Term|Term Nm|Base Port|Base Port nm|VIA|VIA nm|Currency"
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            DataAutoTrim = true;
		            
//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtHidden ,40	  ,daLeft   ,false   ,"rnum"             ,false   ,""        ,dfNone    ,0 );
InitDataProperty(0 ,cnt++ ,dtData	,60   ,daLeft	,false   ,C3_POINT	         ,false   ,""        ,dfNone    ,0 );  //point
InitDataProperty(0 ,cnt++ ,dtHidden	,100  ,daLeft	,false   ,C3_POINT_NM	     ,false   ,""        ,dfNone    ,0 );  //point nm    
InitDataProperty(0 ,cnt++ ,dtData	,60   ,daLeft	,false   ,C3_TRANSMODE	     ,false   ,""        ,dfNone    ,0 );  //trans mode cd
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C3_TRANSMODE_NM    ,false   ,""        ,dfNone    ,0 );  //trans mode nm
InitDataProperty(0 ,cnt++ ,dtData	,40   ,daLeft	,false   ,C3_TERM		     ,false   ,""        ,dfNone    ,0 );  //term cd
InitDataProperty(0 ,cnt++ ,dtHidden	,60   ,daLeft	,false   ,C3_TERM_NM		 ,false   ,""        ,dfNone    ,0 );  //term nm   
InitDataProperty(0 ,cnt++ ,dtData	,60   ,daLeft	,false   ,C3_BASEPORT		 ,false   ,""        ,dfNone    ,0 );  //base port 
InitDataProperty(0 ,cnt++ ,dtHidden	,100  ,daLeft	,false   ,C3_BASEPORT_NM     ,false   ,""        ,dfNone    ,0 );  //base port nm
InitDataProperty(0 ,cnt++ ,dtData	,50   ,daLeft	,false   ,C3_VIA	         ,false   ,""        ,dfNone    ,0 );  //via       
InitDataProperty(0 ,cnt++ ,dtHidden	,50   ,daLeft	,false   ,C3_VIA_NM          ,false   ,""        ,dfNone    ,0 );  //via Nm      
InitDataProperty(0 ,cnt++ ,dtData	,40   ,daLeft	,false   ,C3_CURRENCY		 ,false   ,""        ,dfNone    ,0 );  //currency  
		
			}
	      	break;
	      	
		case "sheet4": // find_text 용
	      	with (sheet4) {
			
		            //높이 설정
		            style.height = 100;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 2, 100);
	                var HeadTitle1 = "f_text1"
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            
//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME   ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtData   ,200  ,daLeft   ,false   ,"f_text1"  ,false   ,""        ,dfNone    ,0 );
		            
		            var idx = sheet4.DataInsert();
		
				}
      			break;

		case "sheet5": // GRI 계산 모든 리스트
	      	with (sheet5) {
		            //높이 설정
		            style.height = 100;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 3, 100);
	                var HeadTitle1 = "Seq.|gri_grp_seq|gri_adj_seq|Application|Point|TransMode|Term|BasePort|VIA|Appl Option|Per|Cargo Type|Currency|amt|percentage";
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            DataAutoTrim = true;      
		            
//데이터속성         ROW ,COL   ,DATATYPE         ,WIDTH  ,DATAALIGN   ,COLMERGE  ,SAVENAME             ,KEYFIELD,CALCULOGIC  ,DATAFORMAT   ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtDataSeq		,40	    ,daCenter    ,false     ,"seq"                                                      );                                                      
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,"gri_grp_seq"		  ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,"gri_adj_seq"		  ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_APPLICATION		  ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_POINT	          ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_TRANSMODE		  ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_TERM		      ,false   ,""          ,dfNone       ,0 );    
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_BASEPORT		  ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_VIA		          ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_APPL_OPTION       ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_PER	              ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_CARGOTYPE         ,false   ,""          ,dfNone       ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_CURRENCY		  ,false   ,""          ,dfNone       ,0 );    
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_AMT               ,false   ,""          ,dfNullFloat  ,2 );
InitDataProperty(0 ,cnt++ ,dtHidden		    ,80	    ,daLeft	     ,false     ,C5_RTO 		      ,false   ,""          ,dfNullInteger,0 );    

        	}
      		break;
      	
		case "sheet6": // 적용 대상 Arbitrary 리스트
	      	with (sheet6) {
			
		            //높이 설정
		            style.height = 100;
		            //전체 너비 설정
		            SheetWidth = mainTable.clientWidth;
		            //Host정보 설정[필수][HostIp, Port, PagePath]
		            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		            //전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
		            //전체Edit 허용 여부 [선택, Default false]
		            Editable = true;
		            //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		            InitRowInfo(1, 1, 1, 100);
	                var HeadTitle1 = "status|update cnt|Seq.|prop_no|amdt_seq|svc_scp_cd|add_chg_tp_cd|org_dest_tp_cd|add_chg_seq|gri_grp_seq|Point|Trans Mode|Term|Base Port|VIA|Per|Cargo Type|Currency|appl opt|amt|rto"
		            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
		            //해더에서 처리할 수 있는 각종 기능을 설정한다
		            InitHeadMode(true, true, false, true, false, false);
		            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		            InitHeadRow(0, HeadTitle1, true);
		            DataAutoTrim = true;
	            
//데이터속성          ROW ,COL   ,DATATYPE ,WIDTH,DATAALIGN,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX
InitDataProperty(0 ,cnt++ ,dtStatus ,30	  ,daCenter ,false   ,"ibflag"                                                  );
InitDataProperty(0 ,cnt++ ,dtData	,40   ,daLeft	,false   ,"up_cnt"   		 ,false   ,""        ,dfInteger      ,0 );  
InitDataProperty(0 ,cnt++ ,dtDataSeq,40   ,daCenter ,false   ,"seq"                                                     );     
InitDataProperty(0 ,cnt++ ,dtHidden	,80	  ,daLeft	,false   ,"prop_no"  	     ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,20	  ,daLeft	,false   ,"amdt_seq"  	     ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,30	  ,daLeft	,false   ,"svc_scp_cd"  	 ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,30	  ,daLeft	,false   ,"add_chg_tp_cd"  	 ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,20	  ,daLeft	,false   ,"org_dest_tp_cd"   ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,20	  ,daLeft	,false   ,"add_chg_seq"      ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,20	  ,daLeft	,false   ,"gri_grp_seq"      ,false   ,""        ,dfNone         ,0 );
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_POINT	         ,false   ,""        ,dfNone         ,0 );  //point
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_TRANSMODE	     ,false   ,""        ,dfNone         ,0 );  //trans mode cd
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_TERM		     ,false   ,""        ,dfNone         ,0 );  //term cd
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_BASEPORT		 ,false   ,""        ,dfNone         ,0 );  //base port 
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_VIA	         ,false   ,""        ,dfNone         ,0 );  //via     
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_PER	         ,false   ,""        ,dfNone         ,0 );  //Per
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_CARGOTYPE		 ,false   ,""        ,dfNone         ,0 );  //cargo type  
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_CURRENCY		 ,false   ,""        ,dfNone         ,0 );  //currency
InitDataProperty(0 ,cnt++ ,dtHidden	,80	  ,daLeft   ,false   ,C6_APPL_OPTION     ,false   ,""        ,dfNone         ,0 );  // 적용옵션 -> flt_pct_tp_cd : F : Amount, P : Percent
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_AMT   		     ,false   ,""        ,dfNullFloat    ,2 );  //amt
InitDataProperty(0 ,cnt++ ,dtHidden	,80   ,daLeft	,false   ,C6_RTO		     ,false   ,""        ,dfNullInteger  ,0 );  //rto
	
			}
      		break;
      		
	}
}

/** 
 * html컨트롤 이벤트초기화 <br>
 * <br><b>Example :</b>
 * <pre>
 * </pre>
 * @param 없음  
 * @return 없음
 * @see #
 * @author 김대호
 * @version 2009.08.12
 */ 
function initControl() {
	axon_event.addListenerForm('click', 'obj_click', form);
}

//===================================================================================
//버튼 이벤트 처리
//===================================================================================
document.onclick = processButtonClick;

/** 
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function processButtonClick(){
	var form = document.form;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	    	case "btn_Close":
	    		window.close();
	    		break;

	    } //end switch
    }catch(e) {
    	if( e == "[object Error]") {
    		ComShowMessage(OBJECT_ERROR);
 		} else {
 			ComShowMessage(e);
 		}
 	}
}

//===================================================================================
//Axson Event Handler
//===================================================================================
/**
* Object 의 Onclick 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.24
*/
function obj_click(){
	var form = document.form;
	var obj = event.srcElement;
	switch(obj.name){
	 	case "rdo_appl_option":
	 		setEditAmtPer("CLICK");
	 		break;
	}
 	//if(obj.dataformat == null) return;
}

//===================================================================================
//UI Object Event Handler
//===================================================================================
/** 
* sheet3 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function sheet3_OnSearchEnd(sheetObj, errMsg) {
    if (sheet3.SearchRows == 0) return;
    if (errMsg == "") {
    	sheet2.WaitImageVisible = false;
        ComOpenWait(true, false);
        setPointComboMake();
    	setCurrencyComboMake();
    	doActionIBSheet2(sheet2, form, IBCLEAR);
        ComOpenWait(false, false);
    	sheet2.WaitImageVisible = true;
    	doActionIBSheet(sheet1, form, IBSEARCH);
    }
}   

/** 
* sheet1 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
	
    var form = document.form;
	var rRowCnt = 0;
    if (errMsg == "") {
    	if(sheet1.RowCount > 0) {
            ComOpenWait(true, false);
            var chkPointCd = "", chkPointNm = ""; // 값확인
    		var pointRange, arrPointRange, startRng, endRng; 
    		var pointComboArrCd = "=", pointComboArrNm = " "; // 콤보 데이터 디폴트 공백 만듬.
    		var startRow1 = sheet1.HeaderRows;
    		var endRow1 = sheet1.HeaderRows + sheet1.RowCount;
    		for(var k = startRow1; k < endRow1; k++) {
    			// Trans 생성
    			var pointCd = sheet1.CellValue(k, C1_POINT_O);
        		setSheet1ComboNextMake("SEARCH", k, C1_POINT, pointCd, "");
    			var transModeCd = sheet1.CellValue(k, C1_TRANSMODE_O);
        		sheet1.Cellvalue2(k, C1_TRANSMODE) = transModeCd;
        		// Term 생성
        		setSheet1ComboNextMake("SEARCH", k, C1_TRANSMODE, transModeCd, "");
        		var termCd = sheet1.CellValue(k, C1_TERM_O);
        		sheet1.Cellvalue2(k, C1_TERM) = termCd;
        		// Base Port 생성
        		setSheet1ComboNextMake("SEARCH", k, C1_TERM, termCd, "");
        		var basePortCd = sheet1.CellValue(k, C1_BASEPORT_O);
        		sheet1.Cellvalue2(k, C1_BASEPORT) = basePortCd;
        		// Via 생성
        		setSheet1ComboNextMake("SEARCH", k, C1_BASEPORT, basePortCd, "");
        		var viaCd = sheet1.CellValue(k, C1_VIA_O);
        		sheet1.Cellvalue2(k, C1_VIA) = viaCd;
        		
        		sheet1.RowStatus(k) = "R";
    		}
            ComOpenWait(false, false);
    		//sheet1.SelectCell(sheet1.HeaderRows, C1_APPLICATION);
    		gIsSheet1SearchEnd = true;
    		setSheet1RowChange(0, C1_APPLICATION, sheet1.HeaderRows, C1_APPLICATION);    		
    	}
    }
}   

/** 
* sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.24
*/ 
function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if (errMsg == "") {
    	if(sheet2.RowCount > 0) {
    		setEditAmtPer("SEARCH");    		
    	}
    }
	if(gBeforeRow != -1) {
		sheet1.SelectCell(gBeforeRow, gBeforeColName, false);
		gBeforeRow = -1;
		gBeforeColName = C1_APPLICATION;
	}
}   

/** 
* sheet5 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.24
*/ 
function sheet5_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if (errMsg == "") {
		if(sheet5.RowCount > 0) {
			doActionIBSheet6(sheet6, form, IBSEARCH); // 중복 체크위해 적용할 Arbitrary 정보를 가져온다.
		} else {
			alert("적용할 GRI Calculation 항목이 없습니다.");
			return;
		}
    }
}   

/** 
* sheet6 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} errMsg : 에러메세지  
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.24
*/ 
function sheet6_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if (errMsg == "") {
		if(sheet6.RowCount > 0) {
	        setChkAppDupRow();
		} else {
			alert("적용될 Arbitrary 항목이 없습니다.");
			return;
		}
    }
}   

/** 
* sheet1 콤보선택 변경시 발생하는 sheet1_OnComboChange 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {IBSheet} Row : 변경된 행 정보
* @param  {IBSheet} Col : 변경된 컬럼정보
* @param  {IBSheet} Code : 콤보코드값
* @param  {IBSheet} Text : 콤보텍스트값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/
function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text) {

	var form = document.form;
    var colName = sheet1.ColSaveName(Col);
	switch(colName) {
		case C1_POINT:     // Point 선택시
		case C1_TRANSMODE: // Trans Mode 선택시
		case C1_TERM:      // Term 선택시
		case C1_BASEPORT:  // Base Port 선택시
			ComOpenWait(true, false);
			setSheet1ComboNextMake("CHANGE", Row, colName, Code, Text);
			ComOpenWait(false, false);
			break;
	
	}
}

/** 
* sheet1 셀 선택시 발생하는 sheet1_OnSelectCell 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {string} ErrMsg : 에러 메세지
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/
function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	var form = document.form;
	var oldGrpSeq = sheet1.CellValue(OldRow, C1_GRPSEQ);
	var newGrpSeq = sheet1.CellValue(NewRow, C1_GRPSEQ);
	var oldColName = sheet1.ColSaveName(OldCol);
	var newColName = sheet1.ColSaveName(NewCol);
	//alert("[OldRow]" + OldRow + "<=>[NewRow]" + NewRow + "<=>[oldGrpSeq]" + oldGrpSeq + "<=>[newGrpSeq]" + newGrpSeq);	
	if(gIsSheet1SearchEnd && OldRow != NewRow && oldGrpSeq != newGrpSeq) {
		setSheet1RowChange(OldRow, oldColName, NewRow, newColName);
	}	
}

/** 
* sheet1 소팅시 발생하는 sheet1_OnSort 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {int} Col : 소트가 처리된 컬럼 인덱스  
* @param  {string} SortArrow : 소트 방향 문자열, "ASC","DESC" 
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/
function sheet1_OnSort(sheetObj, Col, SortArrow)  {
	var grpSeq = sheet1.CellValue(sheet1.SelectRow, C1_GRPSEQ);
	var colName = sheet1.ColSaveName(Col);
	if(gBeforeGrpSeq != grpSeq) {
		setSheet1RowChange(-1, colName, sheet1.SelectRow, colName);
	}	
}

/** 
* sheet1 로우변경시 발생하는 setSheet1RowChange 이벤트핸들러 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {int} OldRow        : old 로우  
* @param  {string} OldColName : old 컬럼명
* @param  {int} NewRow        : new 로우  
* @param  {string} NewColName : new 컬럼명
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/
function setSheet1RowChange(OldRow, OldColName, NewRow, NewColName) {
	var form = document.form;
	var grpSeq = sheet1.CellValue(NewRow, C1_GRPSEQ);	
	gBeforeRow = NewRow;
	gBeforeColName = NewColName;
	gBeforeGrpSeq = grpSeq;
	doActionIBSheet2(sheet2, form, IBSEARCH);
}

/** 
* Arbitray 화면에 기입력된 Point들의 정보로 Point 콤보를 생성을 위한 정보를 만드는 setPointComboMake 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param 없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/
function setPointComboMake() {
	var chkPointCd = "", chkPointNm = ""; // 값확인
	var pointRange, arrPointRange, startRng, endRng; 
	var pointComboArrCd = "=", pointComboArrNm = " "; // 콤보 데이터 디폴트 공백 만듬.
	var startRow3 = sheet3.HeaderRows;
	var endRow3 = sheet3.HeaderRows + sheet3.RowCount;
	for(var k = startRow3; k < endRow3; k++) {
		chkPointCd = sheet3.CellValue(k, C3_POINT);           // Point Cd 값을 확인
		chkPointNm = sheet3.CellValue(k, C3_POINT_NM);        // Point Nm 값을 확인
		pointRange = sheet3.GetColSameDataRange(k, C3_POINT); // 같은 값의 구간 확인
		gArrPointRange[chkPointCd] = pointRange;              // Point 별 구간정보를 담는다.
		pointComboArrCd = pointComboArrCd + "|" + chkPointCd;
		pointComboArrNm = pointComboArrNm + "|" + chkPointCd + "\t" +chkPointNm;
		arrPointRange = pointRange.split("|");
		startRng = parseInt(arrPointRange[0],10);
		endRng = parseInt(arrPointRange[1],10);
		if(endRng > startRng) {
			k = k + (endRng - startRng);
		}
	}
	sheet1.InitDataCombo(0, C1_POINT, pointComboArrNm, pointComboArrCd, " ", "=");
}

/** 
* Arbitray 화면에 기입력된 Currency들의 정보로 Currency 콤보를 생성을 위한 정보를 만드는 setCurrencyComboMake 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param 없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/
function setCurrencyComboMake() {
	var chkCurrencyCd = ""; // 값확인
	var currencyRange, arrCurrencyRange, startRng, endRng; 
	var currencyComboArrCd = "="; // 콤보 데이터 디폴트 공백 만듬
	var currencyComboArrNm = " "; // 콤보 데이터 디폴트 공백 만듬	
	var startRow3 = sheet3.HeaderRows;
	var endRow3 = sheet3.HeaderRows + sheet3.RowCount;
	for(var k = startRow3; k < endRow3; k++) {
		chkCurrencyCd = sheet3.CellValue(k, C3_CURRENCY); // Currency Cd 값을 확인
		currencyRange = sheet3.GetColSameDataRange(k, C3_CURRENCY); // 같은 값의 구간 확인
		currencyComboArrCd = currencyComboArrCd + "|" + chkCurrencyCd;
		currencyComboArrNm = currencyComboArrNm + "|" + chkCurrencyCd;
		arrCurrencyRange = currencyRange.split("|");
		startRng = parseInt(arrCurrencyRange[0],10);
		endRng = parseInt(arrCurrencyRange[1],10);
		if(endRng > startRng) {
			k = k + (endRng - startRng);
		}
	}
	sheet2.InitDataCombo(0, C3_CURRENCY, currencyComboArrNm, currencyComboArrCd, " ", "=");
}

/** 
* sheet1 콤보선택 변경시 sheet3의 Point 의 구간정보로 필터링된 콤보를 생성을 위한 setSheet1ComboNextMake 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {int} colRow     : 콤보생성위한 로우
* @param  {string} colName : 선택한 컬럼명
* @param  {string} colCode : 선택된 콤보의 값
* @param  {string} colText : 선택된 콤보의 텍스트
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/
function setSheet1ComboNextMake(mod, colRow, colName, colCode, colText) {
	
	setSheet1ComboInit(colRow, colName); // 다음 콤보 초기화
	sheet4.CellValue2(1, "f_text1") = ""; // 코드검색 sheet 초기화
	
	var colCode        = ComReplaceStr(colCode                               ,'=','');
	var thePointCd     = ComReplaceStr(sheet1.CellValue(colRow, C1_POINT)    ,'=','');
	var theTransModeCd = ComReplaceStr(sheet1.CellValue(colRow, C1_TRANSMODE),'=','');
	var theTermCd      = ComReplaceStr(sheet1.CellValue(colRow, C1_TERM)     ,'=','');
	var theBasePortCd  = ComReplaceStr(sheet1.CellValue(colRow, C1_BASEPORT) ,'=','');

	if(thePointCd.length > 0 &&  undefined == gArrPointRange[thePointCd]) { // Point Range 확인
		alert("필터 생성을 위한  Point 구간 정보가 없습니다.");
		return; 
	}
	
	var startRow = sheet3.HeaderRows;
	var endRow = sheet3.HeaderRows + sheet3.RowCount;
	if("" != thePointCd) {
		var arrRange = gArrPointRange[thePointCd].split("|"); // Point Range 필터구간
		startRow = parseInt(arrRange[0],10);
		endRow = parseInt(arrRange[1],10) + 1;
	}
	var chkFindNum;
	var tmpText;
	
	var chkPointCd, chkTransModeCd, chkTransNm, chkTermCd, chkTermNm, chkBasePortCd, chkBasePortNm, chkVIACd, chkVIANm;
	
	var compPointCd = thePointCd;
	var compTransModeCd = theTransModeCd;
	var compTermCd = theTermCd;
	var compBasePortCd = theBasePortCd;
	
	switch(colName) {
		case C1_POINT: // Point 선택시 Trans Mode 콤보 셋팅
			var keyPoint = "[" + thePointCd + "]";
			var arrTransCd = "=", arrTransNm = " ";
			if(undefined == gArrTransCob[keyPoint]) { // Trans 콤보 없으면 sheet3 의 Point 정보로 Trans 콤보 생성
				for(var i = startRow; i < endRow; i++) {
					chkPointCd = sheet3.CellValue(i, C3_POINT); // point Mode Cd 값을 확인				
					chkTransModeCd = sheet3.CellValue(i, C3_TRANSMODE); // Trans Mode Cd 값을 확인
					chkTransNm = sheet3.CellValue(i, C3_TRANSMODE_NM); // Trans Mode Nm 값을 확인
					if("" == colCode) compPointCd = chkPointCd;
				    if( chkTransModeCd != "" && compPointCd == chkPointCd ) {
						chkFindNum = sheet4.FindText("f_text1", "[" + chkTransModeCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// Trans 콤보 데이터를 만든다.
							arrTransCd = arrTransCd + "|" + chkTransModeCd;
							arrTransNm = arrTransNm + "|" + chkTransNm;
							// 필터를 위한 데이터를 저장한다.
							tmpText = sheet4.CellValue(1, "f_text1"); 
							sheet4.CellValue2(1, "f_text1") = tmpText + "[" + chkTransModeCd + "]";
						}
				    }
				}
				// 재사용할 Trans 콤보 정보를 만든다.
				gArrTransCob[keyPoint] = arrTransNm + "☜☞" + arrTransCd;
			}
			var filterArrTrans = gArrTransCob[keyPoint].split("☜☞");
			sheet1.CellComboItem(colRow, C1_TRANSMODE, filterArrTrans[0], filterArrTrans[1], 0);
			sheet1.CellValue2(colRow, C1_TRANSMODE) = " ";
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_TRANSMODE, "", "");
			}
			break;

		case C1_TRANSMODE: // Trans Mode 선택시
			var keyTrans = "[" + thePointCd + "][" + theTransModeCd + "]";
			var arrTermCd = "=", arrTermNm = " ";
			if(undefined == gArrTermCob[keyTrans]) { // Term 콤보 없으면 sheet3 의 Point와 Trans Mode 정보로 Term 콤보 생성
				for(var i = startRow; i < endRow; i++) {
					chkPointCd = sheet3.CellValue(i, C3_POINT); // point Mode Cd 값을 확인					
					chkTransModeCd = sheet3.CellValue(i, C3_TRANSMODE); // Trans Mode Cd 값을 확인
					chkTermCd = sheet3.CellValue(i, C3_TERM);        // Term Cd 값을 확인
					chkTermNm = sheet3.CellValue(i, C3_TERM_NM);     // Term Nm 값을 확인
					if("" == thePointCd) compPointCd = chkPointCd;
					if("" == colCode) compTransModeCd = chkTransModeCd;
					if( chkTermCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd ) {
						chkFindNum = sheet4.FindText("f_text1", "[" + chkTermCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// Trans 콤보 데이터를 만든다.
							arrTermCd = arrTermCd + "|" + chkTermCd;
							arrTermNm = arrTermNm + "|" + chkTermNm;
							// 필터를 위한 데이터를 저장한다.
							tmpText = sheet4.CellValue(1, "f_text1"); 
							sheet4.CellValue2(1, "f_text1") = tmpText + "[" + chkTermCd + "]";
						}
					}
				}
				// 재사용할 Trans 콤보 정보를 만든다.
				gArrTermCob[keyTrans] = arrTermNm + "☜☞" + arrTermCd;
			}
			var filterArrTerm = gArrTermCob[keyTrans].split("☜☞");
			sheet1.CellComboItem(colRow, C1_TERM, filterArrTerm[0], filterArrTerm[1], 0);
			sheet1.CellValue2(colRow, C1_TERM) = " ";
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_TERM, "", "");
			}
			break;
			
		case C1_TERM:      // Term 선택시
			var keyTerm = "[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "]";
			var arrBasePortCd = "=", arrBasePortNm = " ";
			if(undefined == gArrBPortCob[keyTerm]) { // Term 콤보 없으면 sheet3 의 Point와 Trans Mode, Term 정보로 Base Port 콤보 생성
				for(var i = startRow; i < endRow; i++) {
					chkPointCd = sheet3.CellValue(i, C3_POINT); // point Mode Cd 값을 확인					
					chkTransModeCd = sheet3.CellValue(i, C3_TRANSMODE); // Trans Mode Cd 값을 확인
					chkTermCd = sheet3.CellValue(i, C3_TERM);        // Term Cd 값을 확인
					chkBasePortCd = sheet3.CellValue(i, C3_BASEPORT);    // Base Port Cd 값을 확인
					chkBasePortNm = sheet3.CellValue(i, C3_BASEPORT_NM); // Base Port Nm 값을 확인
					if("" == thePointCd) compPointCd = chkPointCd;
					if("" == theTransModeCd) compTransModeCd = chkTransModeCd;
					if("" == colCode) compTermCd = chkTermCd;
					if( chkBasePortCd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd) {
						chkFindNum = sheet4.FindText("f_text1", "[" + chkBasePortCd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// Trans 콤보 데이터를 만든다.
							arrBasePortCd = arrBasePortCd + "|" + chkBasePortCd;
							arrBasePortNm = arrBasePortNm + "|" + chkBasePortCd + "\t" + chkBasePortNm;
							// 필터를 위한 데이터를 저장한다.
							tmpText = sheet4.CellValue(1, "f_text1"); 
							sheet4.CellValue2(1, "f_text1") = tmpText + "[" + chkBasePortCd + "]";
						}
					}
				}
				// 재사용할 Trans 콤보 정보를 만든다.
				gArrBPortCob[keyTerm] = arrBasePortNm + "☜☞" + arrBasePortCd;
			}
			var filterArrBport = gArrBPortCob[keyTerm].split("☜☞");
			sheet1.CellComboItem(colRow, C1_BASEPORT, filterArrBport[0], filterArrBport[1], 0);
			sheet1.CellValue2(colRow, C1_BASEPORT) = " ";		
			if(mod == "CHANGE") {
        		setSheet1ComboNextMake("CHANGE", colRow, C1_BASEPORT, "", "");
			}
			break;
		
		case C1_BASEPORT:     // Base Port 선택시
			var keyBPort = "[" + thePointCd + "][" + theTransModeCd + "][" +theTermCd + "][" + theBasePortCd + "]";
			var arrVIACd = "=", arrVIANm = " ";
			if(undefined == gArrVIACob[keyBPort]) { // VIA 콤보 없으면 sheet3 의 Point와 Trans Mode, Term, Base Port 정보로 VIA 콤보 생성
				for(var i = startRow; i < endRow; i++) {
					chkPointCd = sheet3.CellValue(i, C3_POINT); // point Mode Cd 값을 확인					
					chkTransModeCd = sheet3.CellValue(i, C3_TRANSMODE); // Trans Mode Cd 값을 확인
					chkTermCd = sheet3.CellValue(i, C3_TERM);        // Term Cd 값을 확인
					chkBasePortCd = sheet3.CellValue(i, C3_BASEPORT);    // Base Port Cd 값을 확인
					chkVIACd = sheet3.CellValue(i, C3_VIA);    // VIA Cd 값을 확인
					chkVIANm = sheet3.CellValue(i, C3_VIA_NM); // VIA Nm 값을 확인
					if("" == thePointCd) compPointCd = chkPointCd;
					if("" == theTransModeCd) compTransModeCd = chkTransModeCd;
					if("" == theTermCd) compTermCd = chkTermCd;
					if("" == colCode) compBasePortCd = chkBasePortCd;
					if( chkVIACd != "" && compPointCd == chkPointCd && compTransModeCd == chkTransModeCd && compTermCd == chkTermCd && compBasePortCd == chkBasePortCd ) {
						chkFindNum = sheet4.FindText("f_text1", "[" + chkVIACd + "]", 1, 2, true);
						if(chkFindNum < 0){
							// Trans 콤보 데이터를 만든다.
							arrVIACd = arrVIACd + "|" + chkVIACd;
							arrVIANm = arrVIANm + "|" + chkVIACd + "\t" + chkVIANm;
							// 필터를 위한 데이터를 저장한다.
							tmpText = sheet4.CellValue(1, "f_text1"); 
							sheet4.CellValue2(1, "f_text1") = tmpText + "[" + chkVIACd + "]";
						}
					}
				}
				// 재사용할 Trans 콤보 정보를 만든다.
				gArrVIACob[keyBPort] = arrVIANm + "☜☞" + arrVIACd;
			}
			var filterArrVia = gArrVIACob[keyBPort].split("☜☞");
			sheet1.CellComboItem(colRow, C1_VIA, filterArrVia[0], filterArrVia[1], 0);
			sheet1.CellValue2(colRow, C1_VIA) = " ";			
			break;
		
	}
	
}

/** 
* Row와 컬럼이름을 받아 sheet1의 콤보를 초기화 하는 setSheet1ComboInit 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {int} colRow  : 선택로우
* @param  {string} colName : 선택된 콤보 네임
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.20
*/
function setSheet1ComboInit(colRow, colName) {
	switch(colName) {
		case C1_POINT: // Point 선택시 Term 콤보 셋팅
			sheet1.CellComboItem(colRow, C1_TRANSMODE, " ", "=");
			sheet1.CellValue2(colRow, C1_TRANSMODE) = " ";			
			sheet1.CellComboItem(colRow, C1_TERM,      " ", "=");
			sheet1.CellValue2(colRow, C1_TERM) = " ";			
			sheet1.CellComboItem(colRow, C1_BASEPORT,  " ", "=");
			sheet1.CellValue2(colRow, C1_BASEPORT) = " ";			
			sheet1.CellComboItem(colRow, C1_VIA,       " ", "=");
			sheet1.CellValue2(colRow, C1_VIA) = " ";			
			return;
		case C1_TRANSMODE:     // Trans Mode 선택시
			sheet1.CellComboItem(colRow, C1_TERM,      " ", "=");
			sheet1.CellValue2(colRow, C1_TERM) = " ";			
			sheet1.CellComboItem(colRow, C1_BASEPORT,  " ", "=");
			sheet1.CellValue2(colRow, C1_BASEPORT) = " ";			
			sheet1.CellComboItem(colRow, C1_VIA,       " ", "=");
			sheet1.CellValue2(colRow, C1_VIA) = " ";			
			break;
		case C1_TERM:      // Term 선택시
			sheet1.CellComboItem(colRow, C1_BASEPORT,  " ", "=");
			sheet1.CellValue2(colRow, C1_BASEPORT) = " ";			
			sheet1.CellComboItem(colRow, C1_VIA,       " ", "=");
			sheet1.CellValue2(colRow, C1_VIA) = " ";			
		    break;
		case C1_BASEPORT:     // Base Port 선택시
			sheet1.CellComboItem(colRow, C1_VIA,       " ", "=");
			sheet1.CellValue2(colRow, C1_VIA) = " ";			
			break;

	}
	
}

/** 
* GRI Calculation - Arbitray 을 적용위한 중복 체크 및 실행 데이터 정보를 만드는 setChkAppDupRow 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param 없음
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.24
*/
function setChkAppDupRow() {
	var form = document.form;
	var totalCnt = 0;
	var calApplication, calApplOpt;
	var calKey, calTarget;
	var calPoint, calTRansMode, calTerm, calBasePort, calVIA, calPer, calCargoType, calCurrency;
	var compPoint, compTRansMode, compTerm, compBasePort, compVIA;
	var arbCnt = 0;
	var arbKey, arbTarget;
	var arbPoint, arbTRansMode, arbTerm, arbBasePort, arbVIA, arbPer, arbCargoType, arbCurrency;
	var startRow5= sheet5.HeaderRows;
	var endRow5 = sheet5.HeaderRows + sheet5.RowCount;
	var startRow6 = sheet6.HeaderRows;
	var endRow6 = sheet6.HeaderRows + sheet6.RowCount;

	for(var i = startRow5; i < endRow5; i++) {
		
		calGrpSeq = sheet5.CellValue(i, "gri_grp_seq");
		calApplication = sheet5.CellValue(i, C5_APPLICATION);
		calApplOpt = sheet5.CellValue(i, C5_APPL_OPTION);
		calAmt = sheet5.CellValue(i, C5_AMT);
		calRto = sheet5.CellValue(i, C5_RTO);		
		
		calPoint = sheet5.CellValue(i, C5_POINT);
		calTRansMode = sheet5.CellValue(i, C5_TRANSMODE);
		calTerm = sheet5.CellValue(i, C5_TERM);
		calBasePort = sheet5.CellValue(i, C5_BASEPORT);
		calVIA = sheet5.CellValue(i, C5_VIA);
		calPer = sheet5.CellValue(i, C5_PER);
		calCargoType = sheet5.CellValue(i, C5_CARGOTYPE);
		calCurrency = sheet5.CellValue(i, C5_CURRENCY);
		
		compPoint     = calPoint    ;
		compTRansMode = calTRansMode;
		compTerm      = calTerm     ;
		compBasePort  = calBasePort ;
		compVIA       = calVIA      ;

		if (calApplication != "I" && calApplication != "E") {
				alert('Application 이 존재하지 않는 GRI Calculation 항목이 존재합니다.');
				return;
		}
	   
		if(calApplOpt == "F") {
			if(calAmt == "" || parseInt(calAmt, 10) == 0) {
				ComShowCodeMessage("PRI00335", "GRI Amount"); //msgs['PRI00335'] = '[{?msg1}]가(이) 입력되지 않았습니다.';
				return;
			}
			if(calRto != "") {
				alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
				return;
			}
		}
		
		if(calApplOpt == "P") {
			if(calRto == "" || parseInt(calRto, 10) == 0) {
				ComShowCodeMessage("PRI00335", "Percentage"); //msgs['PRI00335'] = '[{?msg1}]가(이) 입력되지 않았습니다.';
				return;
			}
			if(calAmt != "") {
				alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
				return;
			}
		}
		
		if( calApplOpt == "" || (calRto != "" && calAmt != "") ) {
			alert("Application Option 과 GRI Amount, Percentage(%) 가 일치하지 않습니다. ");
			return;
		}

		for(var k = startRow6; k < endRow6; k++) {
			var OK = false;
			arbCnt = sheet6.CellValue(k, "up_cnt"); 
			arbPoint = sheet6.CellValue(k, C6_POINT);
			arbTRansMode = sheet6.CellValue(k, C6_TRANSMODE);
			arbTerm = sheet6.CellValue(k, C6_TERM);
			arbBasePort = sheet6.CellValue(k, C6_BASEPORT);
			arbVIA = sheet6.CellValue(k, C6_VIA);
			arbPer = sheet6.CellValue(k, C6_PER);
			arbCargoType = sheet6.CellValue(k, C6_CARGOTYPE);
			arbCurrency = sheet6.CellValue(k, C6_CURRENCY);
			
			if(calApplication == "I" || calApplication == "E") {
				if(calPoint == "") compPoint = arbPoint;
				if(calTRansMode == "") compTRansMode = arbTRansMode;
				if(calTerm == "") compTerm = arbTerm;
				if(calBasePort == "") compBasePort = arbBasePort;
				if(calVIA == "") compVIA = arbVIA;
				
				calKey = compPoint + compTRansMode + compTerm + compBasePort + compVIA;
				calTarget = calPer + calCargoType + calCurrency;
				arbKey = arbPoint + arbTRansMode + arbTerm + arbBasePort + arbVIA;
				abrTarget = arbPer + arbCargoType + arbCurrency;
				
				if(calApplication == "I") {
					if(calKey == arbKey && calTarget == abrTarget) OK = true;
				}else{
					if(calKey != arbKey && calTarget == abrTarget) OK = true;
				}
				if(OK) {
					totalCnt++;
					arbCnt++;
					sheet6.RowStatus(k) = "U";
					sheet6.CellValue(k, "up_cnt") = arbCnt;
					sheet6.CellValue(k, "gri_grp_seq") = calGrpSeq;					
					sheet6.CellValue(k, C6_APPL_OPTION) = calApplOpt;					
					sheet6.CellValue(k, C6_AMT) = calAmt;
					sheet6.CellValue(k, C6_RTO) = calRto;	
				}
			}else{
				return;
			}

			if(arbCnt > 1) {
				alert('Arbitrary 항목중 중복 적용되는 항목이 존재합니다.');
				return;
			}
			
		} // end for Arbitrary
		
	} // end for Calculation
	
	if(totalCnt == 0) {
		alert('적용 항목이 존재하지 않습니다.');
		return;
	}
	
	doActionIBSheet6(sheet6, form, IBSAVE);
	
}

/** 
* Appcication Option 에 따라 sheet2의 셀에디터 여부를 설정하는 setEditAmtPer 함수 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param : applOpttion 코드
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.25
*/
function setEditAmtPer(mod) {
	
	var form = document.form;
	var obj = form.rdo_appl_option;
	var rdoApplOptionValue = ComGetObjValue(obj);
	
	var startRow2 = sheet2.HeaderRows;
	var endRow2 = sheet2.HeaderRows + sheet2.RowCount;
	var isAmt = false;
	var amt, rto;
	if(mod == "SEARCH") {
		for(var i = startRow2; i < endRow2; i++ ) {
			amt = sheet2.CellValue(i, C2_AMT);
			rto = sheet2.CellValue(i, C2_RTO);
			if(amt == "") {
				sheet2.CellEditable(i, C2_AMT) = false;
	  		    sheet2.CellEditable(i, C2_RTO) = true;
			} else {
				isAmt = true;
	  		    sheet2.CellEditable(i, C2_AMT) = true;
	  		    sheet2.CellEditable(i, C2_RTO) = false;
			}
			sheet2.CellValue2(i, "flt_pct_tp_cd") = rdoApplOptionValue;
			sheet2.RowStatus(i) = "R";
		}
		if(isAmt){
			obj[0].checked = true;
		}else{
			obj[1].checked = true;
		}
	}else if(mod == "CLICK"){
		for(var i = startRow2; i < endRow2; i++ ) {
			if(rdoApplOptionValue == "F") {
				sheet2.CellEditable(i, C2_AMT) = true;
	  		    sheet2.CellEditable(i, C2_RTO) = false;
  		    	sheet2.CellValue2(i, C2_RTO) = "";
			} else {
	  		    sheet2.CellEditable(i, C2_AMT) = false;
	  		    sheet2.CellEditable(i, C2_RTO) = true;
  	  		    sheet2.CellValue2(i, C2_AMT) = "";
			}
			sheet2.CellValue2(i, "flt_pct_tp_cd") = rdoApplOptionValue;
		}
	}else if(mod == "ROWADD") {
		if(rdoApplOptionValue == "F") {
			sheet2.CellEditable(sheet2.SelectRow, C2_AMT) = true;
  		    sheet2.CellEditable(sheet2.SelectRow, C2_RTO) = false;
		} else {
  		    sheet2.CellEditable(sheet2.SelectRow, C2_AMT) = false;
  		    sheet2.CellEditable(sheet2.SelectRow, C2_RTO) = true;
		}
		sheet2.CellValue2(sheet2.SelectRow, "flt_pct_tp_cd") = rdoApplOptionValue;
	}
		
}

//===================================================================================
//서버 조회/저장
//===================================================================================
/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {

	sheet1.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBCLEAR: //화면로딩시
			var sXml = "";
			break;
	
        case IBSEARCH: // 상단 그리드 조회
			formObj.f_cmd.value = SEARCH;
			var sXml = sheet1.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));	
			sheet1.LoadSaveXml(sXml);
 			//sheet1.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			break;

	}
}

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet2 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function doActionIBSheet2(sheetObj, formObj, sAction) {

	sheet2.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBCLEAR: //화면로딩시
			var sXml = "";
		
			//per combo
			formObj.f_cmd.value = SEARCH03;
			sXml = sheet2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			setIBCombo(sheet2, sXml, "rat_ut_cd", true, 0);
			//setIBCombo(sheet2, sXml, "rat_ut_cd", true, 0, " ", " ", 1);
		
			//공통 cargo
			formObj.f_cmd.value = SEARCH19;
			formObj.cd.value="CD02202";
			sXml = sheet2.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			//setIBCombo(sheet2, sXml, "prc_cgo_tp_cd", false, 0, "DR");
			setIBCombo(sheet2, sXml, "prc_cgo_tp_cd", true, 0);			
			
			break;
			
        case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH01; // 하단 그리드 조회
            var griGrpSeq = sheet1.CellValue(sheet1.SelectRow, C1_GRPSEQ);
			var sXml = sheet2.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq="+griGrpSeq);	
			sheet2.LoadSaveXml(sXml);
 			break;
	}
}

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet3 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function doActionIBSheet3(sheetObj, formObj, sAction) {

	sheet3.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBCLEAR: //화면로딩시
			var sXml = "";
			break;
			
        case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH02;
        	var pGriGrpSeq = sheet1.CellValue(sheet1.SelectRow, C1_GRPSEQ);
        	var orgDestTpCd = form.org_dest_tp_cd.value;
			var sXml = sheet3.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj) + "&gri_grp_seq=" + pGriGrpSeq + "&org_dest_tp_cd=" + orgDestTpCd);
			sheet3.LoadSaveXml(sXml);
 			//sheet3.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			break;
 			  
	}
}

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet5 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function doActionIBSheet5(sheetObj, formObj, sAction) {

	sheet5.ShowDebugMsg = false;
	sheet5.WaitImageVisible = false;
         
	switch(sAction) {
		case IBCLEAR: //화면로딩시
			var sXml = "";
			break;
			
        case IBSEARCH: //조회
        	sheet5.RemoveAll();
			formObj.f_cmd.value = SEARCH03; // 적용가능 모든 Cal
 			sheet5.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			//var sXml = sheet5.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));	
			//sheet5.LoadSaveXml(sXml);
 			break;
 			  
	}
}

/** 
* 조회 저장등 서버 기능을 호출하는 doActionIBSheet6 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2009.08.18
*/ 
function doActionIBSheet6(sheetObj, formObj, sAction) {

	sheet6.ShowDebugMsg = false;
	sheet6.WaitImageVisible = false;	
         
	switch(sAction) {
		case IBCLEAR: //화면로딩시
			var sXml = "";
			break;
			
        case IBSEARCH: //조회
        	sheet6.RemoveAll();
			formObj.f_cmd.value = SEARCH04; // 중복 체크위해 적용할 Arbitrary 정보를 가져온다.
 			sheet6.DoSearch("ESM_PRI_0109GS.do", FormQueryString(formObj));
 			break;
 			
	}
}
