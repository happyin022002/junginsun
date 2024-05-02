/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1407.js
*@FileTitle : SC Note Inquiry by Rule Type
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.01.19 김대호
* 1.0 Creation
=========================================================*/
/**
 * @fileoverview Audit by CNTR Qty Discrepancy 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESM_BKG_1407:ESM_BKG_1407 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

/**
 * @extends  
 * @class ESM_BKG_1407 : ESM_BKG_1407 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_BKG_1407() {
	this.setSheetObject 		= setSheetObject;
	this.setComboObject         = setComboObject;	
	this.loadPage 				= loadPage;
	this.initSheet 				= initSheet;
	this.initCombo              = initCombo;
	this.obj_click              = obj_click;
	this.obj_keypress           = obj_keypress;
	this.obj_deactivate         = obj_deactivate;
	this.processButtonClick		= processButtonClick;
	this.doActionIBSheet 		= doActionIBSheet;
}
    
//===================================================================================
//전역변수
//===================================================================================
//공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1;
var sheet2;

var comboObjects = new Array();
var comboCnt = 0;
//업무전역변수
var gCurrDate;
var gCurrFromDate;
var gCurrToDate;
var gXml = "";
var gBkgRhqCd;
var gCtrtTpCdDefault = "S";



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
* @version 2010.01.19
*/ 
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}

/** 
* IBMultiCombo Object를 comboObjects 배열에 등록 <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBMultiCombo} combo_obj : IBMultiCombo Object
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
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
* @version 2010.01.19
*/ 
function loadPage() {
	
	var form = document.form;	
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];
    sheetCnt = sheetObjects.length ;

    //IBMultiCombo 초기화
    comboCnt = comboObjects.length;
    for(var k=0;k<comboCnt;k++){
        initCombo(comboObjects[k],k+1);
    }
    
    //IBSheet 초기화
    for(i=0;i<sheetCnt;i++){
        ComConfigSheet(sheetObjects[i]); //시작 환경 설정 함수 이름 변경
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]); //마지막 환경 설정 함수 추가
    }
    
    sheet1.WaitImageVisible = false;
    sheet1.CountPosition =0;
    sheet2.WaitImageVisible = false;
    sheet2.CountPosition =0;

    
    //html컨트롤 이벤트초기화    
	axon_event.addListenerForm('click', 'obj_click', form);	 
	axon_event.addListenerForm('keypress', 'obj_keypress', form);
	axon_event.addListenerForm('beforeactivate', 'obj_activate', form);
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form);
    axon_event.addListener ('keydown', 'ComKeyEnter', 'form');    	   
    axon_event.addListenerForm('change', 'form_change', document.form);
    

	initIBComboItem();
    
    sheet1.WaitImageVisible = true;
    sheet2.WaitImageVisible = true;
  
    
}

/** 
* sheet1_OnLoadFinish 이벤트핸들러 구현 <br>
* IBSheet를 초기화 한후에 선처리해야 하는 기능을 추가한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/
/*
function sheet1_OnLoadFinish(sheetObj) {
	var form = document.form;	

}
*/

/**
 * IBMultiCombo 에 Item을 setting한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *     initIBComboItem();
 * </pre>
 * @return 없음
 * @author 김대호
 * @version 2010.01.19
 */
function initIBComboItem() {
    ComBkgTextCode2ComboItem(svcScpCdComboValue, svcScpCdComboText, getComboObject(comboObjects, 'svc_scp_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(noteConvTypeComboValue, noteConvTypeComboText, getComboObject(comboObjects, 'note_conv_tp_cd'), "|", "\t" );
    ComBkgTextCode2ComboItem(noteCovRuleComboValue, noteCovRuleComboText, getComboObject(comboObjects, 'note_conv_rule_cd'), "|", "\t" );
    
	document.form.bkg_ctrt_tp_cd.InsertItem(0,'RFA','R');
	document.form.bkg_ctrt_tp_cd.InsertItem(1,'S/C','S');
	getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code = 'S'; 
	
	document.form.note_conv_rule_cd.InsertItem(1,'No Rule','NOR');
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
* @version 2010.01.19
*/ 
function initSheet(sheetObj, sheetNo) {
	
	var cnt = 0;
	var sheetID = sheetObj.id;
   
	switch(sheetID) {
		case "sheet1":
	      	with (sheet1) {
	            //높이 설정
	            style.height = 390;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	           
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	            
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	           
	           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 2, 100);
	            var HeadTitle1 = "||Contract No.|Proposal No.|AMD|Customer Name|Scope|Rate Type|Note\nType|Note\nSeq.|Item|Charge|Note Contents|" +
        		"Seq.|Code|Actual\nEffective Date|Actual\nExpire Date|Application|Cur|Cal|Amount|Per|Cargo\nType|IMDG\nClass|POR|POL|POD|DEL|" +
        		"Commodity|Commodity\nGroup|Origin\nTrans Mode|Destination\nTrans Mode|Receiving\nTerm|Delivery\nTerm|Lane|Direct\nCall|T/S Port|" +
        		"In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|SI|BL Type|Pay Term|Type|By Charge|" +
        		"S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|S/C Condition|" +
        		"S/C Condition|S/C Condition|Updated Date|Updated Staff|ctrt_cnt||";
	            var HeadTitle2 = "||Contract No.|Proposal No.|AMD|Customer Name|Scope|Rate Type|Note\nType|Note\nSeq.|Item|Charge|Note Contents|" +
        		"Seq.|Code|Actual\nEffective Date|Actual\nExpire Date|Application|Cur|Cal|Amount|Per|Cargo\nType|IMDG\nClass|POR|POL|POD|DEL|" +
        		"Commodity|Commodity\nGroup|Origin\nTrans Mode|Destination\nTrans Mode|Receiving\nTerm|Delivery\nTerm|Lane|Direct\nCall|T/S Port|" +
        		"In/Out\nGauge|Canal|VVD|Actual\nCustomer|S.O.C|US SVC Mode|SI|BL Type|Pay Term|Type|By Charge|" +
        		"Ignore\nTariff|Rate\nPattern|Rate\nIndicator|Per|Cargo\nType|Commodity|Origin|Origin Via|Dest. Via|Dest.|" +
        		"Receiving\nTerm|Delivery\nTerm|Updated Date|Updated Staff|ctrt_cnt||";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);

				//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
				InitDataProperty(0, cnt++ , dtHidden,       80,   daCenter,  true,	"bkg_ctrt_tp_cd",			false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtPopup,        100,  daCenter,  true,	"ctrt_no",					false,	"",	dfNone, 			0,     true,        true);
				InitDataProperty(0, cnt++ , dtHidden,       80,   daCenter,  true,	"prop_no",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"amdt_seq",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         200,  daLeft,    true,	"ctrt_pty_nm",				false,	"",	dfNone, 			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"svc_scp_cd",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"rt_tp",	   				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"note_conv_tp_cd",			false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"dp_seq",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"note_clss_cd",				false,	"",	dfNone, 			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"chg_cd",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         250,  daLeft,    true,	"note_ctnt",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"note_conv_seq",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     false,       false,	10);
                
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,       false, 	3);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     false,       false,	5);
                
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     false,       false,	6);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_scg_grp_cmdt_cd", 		false,	"",	dfNone,				0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_org_trsp_mod_cd",		false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_dest_trsp_mod_cd",		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_rcv_term_cd", 			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_de_term_cd",			false,	"",	dfNone,				0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     false,       false,	3);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_io_ga_cd",				false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  true,	"bkg_cnl_tz_cd", 			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     false,       false,	9);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_act_cust_def_cd",		false,	"",	dfNone, 			0,     false,       false,	8);
                
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"bkg_usa_svc_mod_cd",  		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  true,	"bkg_esvc_tp_cd",  			false,	"",	dfNone, 			0,     true,        true);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_mst_hbl_tp_cd",     	false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"rule_appl_chg_tp_cd", 		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"rule_appl_chg_cd", 		false,	"",	dfNone, 			0,     false,       false);                     
                InitDataProperty(0, cnt++ , dtData,         100,  daLeft,    true,	"ign_trf_flg",				false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,  daLeft,    true,	"rt_patt_tp_cd", 			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"gen_spcl_rt_tp_cd",		false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"conv_rat_ut_cd",   		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"conv_prc_cgo_tp_cd",		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"conv_cmdt_def_cd",			false,	"",	dfNone, 			0,     false,       false,	6);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_org_loc_def_cd",  	false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_org_via_loc_def_cd",	false,	"",	dfNone, 			0,     false,       false,	5);
                
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_dest_via_loc_def_cd",	false,	"",	dfNone,				0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_dest_loc_def_cd", 	false,	"",	dfNone,				0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_prc_rcv_term_cd",		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"conv_prc_de_term_cd",		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"upd_dt",					false,	"",	dfDateYmd,			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"usr_nm",					false,	"",	dfNone,				0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"ctrt_cnt",					false,	"", dfNone,				0,	   false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"total_cnt",				false,	"", dfNone,				0,	   false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"curr_page",				false,	"", dfNone,				0,	   false,       false);
				
				ShowButtonImage = 2;
				UnEditableColor = RgbColor(255,255,255);
                FrozenCols = 4;

	      	}
	      	break;
	      	
		case "sheet2":
	      	with (sheet2) {
	            //높이 설정
	            style.height = 390;
	            //전체 너비 설정
	            SheetWidth = mainTable.clientWidth;
	           
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	            
	            //전체Merge 종류 [선택, Default msNone]
	            MergeSheet = msHeaderOnly;
	            
	            //전체Edit 허용 여부 [선택, Default false]
	            Editable = true;
	           
	           //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	            InitRowInfo(2, 1, 2, 100);
	            var HeadTitle1 = "||Contract No.|Proposal No.|AMD|Customer Name|Scope|Rate Type|Note\nType|Note\nSeq.|Item|Charge|Note Contents|" +
        		"Seq.|Code|Actual\nEffective Date|Actual\nExpire Date|Application|Cur|Cal|Amount|Pay Term|Per|Cargo\nType|IMDG\nClass|Lane|T/S Port|VVD|SOC|POR|POL|POD|DEL|" +
        		"SI|Node|CMDT|Weight\n(Ton<=)|Weight\n(>Ton)|Direct\nCall|Bar Type|Updated Date|Updated Staff|ctrt_cnt||";
	            var HeadTitle2 = "||Contract No.|Proposal No.|AMD|Customer Name|Scope|Rate Type|Note\nType|Note\nSeq.|Item|Charge|Note Contents|" +
        		"Seq.|Code|Actual\nEffective Date|Actual\nExpire Date|Application|Cur|Cal|Amount|Pay Term|Per|Cargo\nType|IMDG\nClass|Lane|T/S Port|VVD|SOC|POR|POL|POD|DEL|" +
        		"SI|Node|CMDT|Weight\n(Ton<=)|Weight\n(>Ton)|Direct\nCall|Bar Type|Updated Date|Updated Staff|ctrt_cnt||";
	           
	            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	            InitColumnInfo(ComCountHeadTitle(HeadTitle1), 0, 0, false);
	            
	            //해더에서 처리할 수 있는 각종 기능을 설정한다
	            InitHeadMode(true, true, false, true, false, false);
	            
	            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	            InitHeadRow(0, HeadTitle1, true);
	            InitHeadRow(1, HeadTitle2, true);

				//데이터속성       ROW , COL   ,DATATYPE  ,WIDTH  ,DATAALIGN  ,COLMERGE,SAVENAME           ,KEYFIELD,CALCULOGIC,DATAFORMAT     ,POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN,FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX		            
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,   daCenter,  true,	"ibflag");
				InitDataProperty(0, cnt++ , dtHidden,       80,   daCenter,  true,	"bkg_ctrt_tp_cd",			false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtPopup,        100,  daCenter,  true,	"ctrt_no",					false,	"",	dfNone, 			0,     true,        true);
				InitDataProperty(0, cnt++ , dtHidden,       80,   daCenter,  true,	"prop_no",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"amdt_seq",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         200,  daLeft,    true,	"ctrt_pty_nm",				false,	"",	dfNone, 			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"svc_scp_cd",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         200,  daCenter,  true,	"rt_tp",	   				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"note_conv_tp_cd",			false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"dp_seq",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"note_clss_cd",				false,	"",	dfNone, 			0,     false,       false);
				
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"chg_cd",					false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         250,  daLeft,    true,	"note_ctnt",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"note_conv_seq",				false,	"",	dfNone, 			0,     false,       false);
				InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"chg_rule_def_cd",			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"eff_dt",  					false,	"",	dfDateYmd,			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"exp_dt",     				false,	"",	dfDateYmd, 		 	0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"rt_appl_tp_cd",     		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         45,   daCenter,  true,	"curr_cd",      			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"rt_op_cd",        	 		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         80,   daRight,   true,	"frt_rt_amt",      	 		false,	"",	dfNullFloat,   		3,     false,       false,	10);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"pay_term_cd",       		false,	"",	dfNone,				0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_rat_ut_cd",     		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_prc_cgo_tp_cd",  		false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         40,   daCenter,  true,	"bkg_imdg_clss_cd",   		false,	"",	dfNone, 			0,     false,       false, 	3);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_slan_cd",    			false,	"",	dfNone,				0,     false,       false,	3);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_ts_port_def_cd", 		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         100,  daCenter,  true,	"bkg_vvd_cd",	    		false,	"",	dfNone, 			0,     false,       false,	9);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_soc_flg",				false,	"",	dfNone, 			0,     false,       false);
                
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_por_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_pol_def_cd",   		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_pod_def_cd",    		false,	"",	dfNone, 			0,     false,       false,	5);
                InitDataProperty(0, cnt++ , dtData,         70,   daCenter,  true,	"bkg_del_def_cd",     		false,	"",	dfNone, 			0,     false,       false,	5);
                
                
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  true,	"bkg_esvc_tp_cd",  			false,	"",	dfNone, 			0,     true,        true);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  true,	"bkg_yd_cd",  				false,	"",	dfNone, 			0,     true,        true);
                InitDataProperty(0, cnt++ , dtData,         80,   daCenter,  true,	"bkg_cmdt_def_cd",   		false,	"",	dfNone,				0,     false,       false,	6);
                InitDataProperty(0, cnt++ , dtData,         60,   daRight, 	 true,	"bkg_min_cgo_wgt",  		false,	"",	dfFloat, 			0,     true,        true);
                InitDataProperty(0, cnt++ , dtData,         60,   daRight, 	 true,	"bkg_max_cgo_wgt",  		false,	"",	dfFloat, 			0,     true,        true);
                InitDataProperty(0, cnt++ , dtData,         50,   daCenter,  true,	"bkg_dir_call_flg",			false,	"",	dfNone, 			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         60,   daCenter,  true,	"bkg_hngr_bar_tp_cd",  		false,	"",	dfNone, 			0,     true,        true);
               
                
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"upd_dt",					false,	"",	dfDateYmd,			0,     false,       false);
                InitDataProperty(0, cnt++ , dtData,         90,   daCenter,  true,	"usr_nm",					false,	"",	dfNone,				0,     false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"ctrt_cnt",					false,	"", dfNone,				0,	   false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"total_cnt",				false,	"", dfNone,				0,	   false,       false);
				InitDataProperty(0, cnt++ , dtHidden,       40,	  daCenter,  true,	"curr_page",				false,	"", dfNone,				0,	   false,       false);
				
				ShowButtonImage = 2;
				UnEditableColor = RgbColor(255,255,255);
                FrozenCols = 4;

	      	}
	      	break;
	      	
	}
}

/** 
* IBMultiCombo 기본 설정 및 초기화 <br>
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
* 콤보가 다수일 경우 시트 수만큼 case를 추가하여 콤보 초기화모듈을 구성한다. <br> 
* <br><b>Example :</b>
* <pre>
* </pre>
* @param {IBMultiCombo} comboObj : 시트오브젝트
* @param {int} comboNo : 콤보오브젝트 태그의 아이디에 붙인 일련번호  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function initCombo(comboObj, comboNo) {
	switch (comboObj.id) {
		// scope
		case "svc_scp_cd":
			var i = 0;
			with (comboObj) {
				DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
			}
			break;
		// Converion Type
        case "note_conv_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
            }
            break;  
         // Rule
		case "note_conv_rule_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
            	UseAutoComplete = true;
				ValidChar(2, 0);    // 영문대문자만 입력
                MaxLength = 3;      // 3자리만 입력
            }
            break;
            
        case "bkg_ctrt_tp_cd":
            var i=0;
            with(comboObj) {
            	DropHeight = 200;
				UseAutoComplete = true;
            	ValidChar(1, 2);    // 영문만 입력 + 특수문자
            }
            break;  

	}
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
* @version 2010.01.19
*/ 
function processButtonClick(){
	var form = document.form;
	var rdoDateObj = form.rdoDate;
    try {
	    var srcName = window.event.srcElement.getAttribute("name");
	    switch(srcName) {
	        case "btns_calendar1": //달력버튼
	        	var cal = new ComCalendar();
	        	cal.select(form.eff_dt, 'yyyy-MM-dd');
	        	break;
	        
	        case "btns_calendar2":
		        var cal = new ComCalendar();
		        cal.select(form.exp_dt, 'yyyy-MM-dd');
		        break;
				
	    	case "btn_retrieve":
	    		if (validateForm(sheet1, form, IBSEARCH)) {
	    			ComOpenWait(true);
	    			
	    			if(form.bkg_ctrt_tp_cd.Code=="R"){
		    			sheet2.WaitImageVisible = false;
		    			doActionIBSheet(sheet2, form, IBSEARCH);
	    			}else{
		    			sheet1.WaitImageVisible = false;
		    			doActionIBSheet(sheet1, form, IBSEARCH);
	    			}

	    			ComOpenWait(false);
	    		}
	    		break;
	    		
	    	case "btn_new":
	    		ComResetAll();
	    		getComboObject(comboObjects, 'bkg_ctrt_tp_cd').Code = 'S'; 
	    		getComboObject(comboObjects, 'note_conv_rule_cd').Code = ''; 
	    		break;
	    		
	    	case "btn_downexcel":
	    		
    			if(form.bkg_ctrt_tp_cd.Code=="R"){
    				doActionIBSheet(sheet2, form, IBDOWNEXCEL);
    			}else{
    				doActionIBSheet(sheet1, form, IBDOWNEXCEL);
    			}
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
* Object 의 Keypress 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function obj_keypress(){
	var obj = event.srcElement;
 	if(obj.dataformat == null) return;
 	window.defaultStatus = obj.dataformat;
	switch(obj.dataformat){
 	case "ymd": //날짜 입력하기
		ComKeyOnlyNumber(obj,"-"); 
		break;
 	case "int": //숫자만 입력
 	case "number": //숫자만 입력 	
 		ComKeyOnlyNumber(obj);
 		break;
 	case "engup":
 		ComKeyOnlyAlphabet('upper');
 		break;
 	case "uppernum":
 		ComKeyOnlyAlphabet('uppernum');
 		break;
 	default:
 		//ComKeyOnlyNumber(obj);
 		break;
	}
}


  /**
  * OnClick 이벤트 발생시 호출되는 function <br>
  * 주소입력시 메모장을 화면에 표시한다. <br>
  * <br><b>Example :</b>
  * <pre>
  *
  * </pre>
  * @param {ibsheet} sheetObj 필수 IBSheet Object
  * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
  * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
  * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값 
  * @return 없음
  * @author 이승준
  * @version 2009.06.03
  */  	           
  function sheet1_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	var colname = sheetObj.ColSaveName(Col);  	 
  	switch(colname){
  	case "note_ctnt":
  		ComShowMemoPad(sheetObj,Row,Col,true,400,200); 
  		break;
  	}

  }	 
  function sheet2_OnClick(sheetObj, Row, Col, Value) {
	    //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
	var colname = sheetObj.ColSaveName(Col);  	 
	switch(colname){
	case "note_ctnt":
		ComShowMemoPad(sheetObj,Row,Col,true,400,200); 
		break;
	}

}	 
  
/**
* OnBeforeActivate event를 처리한다. <br>
* <br><b>Example :</b>
* <pre>
*     obj_activate()
* </pre>
* @param 없음
* @return 없음
* @see #
* @author 김대호
* @version 2010.02.26
*/      

function obj_activate() {
    ComClearSeparator (event.srcElement);
}



/** 
* Object 의 Onbeforedeactivate 이벤트핸들러 <br>
* 객체의 dataformat 에 따라 입력값에 대한 Valadation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  없음  
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function obj_deactivate() {
	var form = document.form;
	var formObj = event.srcElement;
    var srcName = formObj.getAttribute("name");
    switch(srcName) {
		case "ctrt_no":
			break;
			
		default :
			ComChkObjValid(formObj);
	}

}


function bkg_ctrt_tp_cd_OnChange(comboObj, Index_Code, Text) {


            	if(Index_Code==""){
            		getComboObject(comboObjects, 'bkg_ctrt_tp_cd') = "S";
            	}else{
            		if(Index_Code == "R"){
            			sheet2.RemoveAll();  
            			eval('sht2').style.display = 'block';
            			eval('sht1').style.display = 'none';
            		}else{
            			sheet1.RemoveAll();  
            			eval('sht1').style.display = 'block';
            			eval('sht2').style.display = 'none';
            		}
            	}
            	
}
 /** 
  * sheet1 팝업연결 선택시 발생하는 sheet1_OnPopupClick 이벤트핸들러 <br>
  * <br><b>Example :</b>
  * <pre>
  * </pre>
  * @param  {IBSheet} sheetObj : 시트오브젝트  
  * @param  {Long} Row : 해당 셀의 Row Index
  * @param  {Long} Col : 해당 셀의 Column Index
  * @return  
  * @see #
  * @author 김대호                                                                               
  * @version 2009.10.28                                                         
  */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	 	var form = document.form;
	 	var colName = sheet1.ColSaveName(Col);
		var sName   = sheet1.ColSaveName(Col);
		var ctrtNo    = sheet1.CellValue(Row, "ctrt_no");	
		var amdtSeq = sheet1.CellValue(Row, "amdt_seq");	
	 	switch(colName){
	 	
			case "ctrt_no":
				ComOpenWindowCenter("ESM_PRI_0087.do?sc_no="+ctrtNo+"&amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
				break;
				

		 	}
}

function sheet2_OnPopupClick(sheetObj, Row, Col) {
 	var form = document.form;
 	var colName = sheet2.ColSaveName(Col);
	var sName   = sheet2.ColSaveName(Col);
	var ctrtNo    = sheet2.CellValue(Row, "ctrt_no");	
	var amdtSeq = sheet2.CellValue(Row, "amdt_seq");	
 	switch(colName){
 	
		case "ctrt_no":
	        if(ctrtNo.substring(5,6)=="G" || ctrtNo.substring(5,6)=="M" ){
	        	ComOpenWindowCenter("ESM_PRI_2120.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
	        }else{ // 일반, Basic
	        	ComOpenWindowCenter("ESM_PRI_2020.do?s_rfa_no="+ctrtNo+"&s_amdt_seq="+amdtSeq, "", '1024', '700', false, "yes");
	        }

			break;
			

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
* @version 2010.01.19
*/ 
function doActionIBSheet(sheetObj, formObj, sAction) {
	   
	sheetObj.ShowDebugMsg = false;
         
	switch(sAction) {
		case IBSEARCH: //조회
			formObj.f_cmd.value = SEARCH;
			sheetObj.RemoveAll();
			formObj.total_cnt.value = 0;
			formObj.curr_page.value = 0;
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1407GS.do", FormQueryString(formObj));
			sheetObj.Redraw = false;    
//			sheetObjects[0].WaitImageVisible = true;
			sheetObj.LoadSearchXml(sXml); 
			sheetObj.Redraw = true;
			
				
			break;
			
		case IBDOWNEXCEL:      //download excel
			sheetObj.SpeedDown2Excel(-1); //, "chk|seq"
			break;
			
			
			
		case IBSEARCHAPPEND:  // 페이징 조회
			formObj.f_cmd.value = SEARCH;
				
			sheetObj.WaitImageVisible=false;
			ComOpenWait(true); // 대기창 보임
				
			var sXml = sheetObj.GetSearchXml("ESM_BKG_1407GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchXml(sXml,true); 
			break;  
	}
	
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 chkDate <br>
* Application 날짜 Validation을 체크한다. <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {object} formObj : 폼 오브젝트
* @return {boolean}
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function chkDate(formObj) {
	
	var form = document.form;	
    var effDtObj  = form.eff_dt;
    var expDtObj  = form.exp_dt;
	var effDtValue = effDtObj.value.replace(/-/g,'');
	var expDtValue = expDtObj.value.replace(/-/g,'');
	
	if(effDtValue != "" && expDtValue != "") {

		if( parseInt(effDtValue,10) > parseInt(expDtValue,10) ) {
			ComShowCodeMessage("BKG95026", "From Date", "To Date");
			event.returnValue = false;			
			ComSetFocus(formObj);
			return false;
		}

		var fromAddDays = ComGetDateAdd(effDtValue, "D", 365, "", true); // 31일
		if( parseInt(expDtValue,10) > parseInt(fromAddDays,10) ) {
			ComShowCodeMessage("BKG95027", "1 year"); // "The period of Date can't be over {?msg1}."
			event.returnValue = false;		
			ComSetFocus(formObj);
			return false;
		}
		
	}
	
	
	return true;
}

/** 
* 화면 폼입력값에 대한 유효성검증 프로세스 처리하는 validateForm <br>
* <br><b>Example :</b>
* <pre>
* </pre>
* @param  {IBSheet} sheetObj : 시트오브젝트  
* @param  {object} formObj : 폼 오브젝트
* @param  {sAction} sAction : form의 f_cmd에 설정하여 조회/저장등에 사용되는 상수값
* @return 없음
* @see #
* @author 김대호
* @version 2010.01.19
*/ 
function validateForm(sheetObj, formObj, sAction){
	
	var form = document.form;
	
	var effDtObj   = form.eff_dt;	
	var expDtObj   = form.exp_dt;
	var effDtValue = effDtObj.value;	
	var expDtValue = expDtObj.value;
	var svcScpObj  = form.svc_scp_cd;
	var bkgCtrtTpCd  = form.bkg_ctrt_tp_cd;
    switch (sAction) {
	    
    	case IBSEARCH: //조회
    	
    		if(!ComChkObjValid(effDtObj)) { return false; }
    		if(!ComChkObjValid(expDtObj)) { return false; }

    		if("" == effDtValue || "" == expDtValue) {
				 ComShowCodeMessage("BKG95025", "Effective Date"); // "Please input {?msg1}."
				 if("" == effDtObj.value) {
					 ComSetFocus(effDtObj);
				 }else{
					 ComSetFocus(expDtObj);
				 }
				 return false;
			}
    		
			if(!chkDate(effDtObj)) {  return false; }
			if(!chkDate(expDtObj)) { return false; }
			
			if(ComGetDaysBetween(expDtObj, effDtObj) > 0){
                ComShowCodeMessage("BKG00421");
                formObj.eff_dt.focus();
                return false;
            }

            // 조회기간 범위 체크 31일 : 1일 부터 31일까지 기간이 30일 체크
            if(ComGetDaysBetween(effDtObj, expDtObj) > 30){
                ComShowCodeMessage("BKG00555","31 Days");
                formObj.eff_dt.focus();
                return false;
            }
            
            
            if(null == svcScpObj.Code || "" == svcScpObj.Code){
				ComShowCodeMessage("BKG95031", "Service Scope");
				event.returnValue = false;
				ComSetFocus(svcScpObj);
				return false;	
    		}
            
            if(null == bkgCtrtTpCd.Code || "" == bkgCtrtTpCd.Code){
				ComShowCodeMessage("BKG95031", "Contract Type");
				event.returnValue = false;
				ComSetFocus(bkgCtrtTpCd);
				return false;	
    		}
			
	    	break;
	    	
    }

    return true;
    
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
* @author 류선우
* @version 2010.04.29
*/ 
function sheet1_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    
    if(sheetObj.RowCount > 0){
    	form.ctrt_cnt.value = sheetObj.CellValue(2,"ctrt_cnt");
    }else{
    	form.ctrt_cnt.value = "0";
    }
    
}   

function sheet2_OnSearchEnd(sheetObj, errMsg) {
    var form = document.form;
    if(sheetObj.RowCount > 0){
    	form.ctrt_cnt.value = sheetObj.CellValue(2,"ctrt_cnt");
    	form.total_cnt.value = sheetObj.CellValue(sheetObj.LastRow,"total_cnt");
    	form.curr_page.value = sheetObj.CellValue(sheetObj.LastRow,"curr_page");
        if(BkgParseInt(form.curr_page.value) < BkgParseInt(form.total_cnt.value)){ 
            doActionIBSheet(sheetObjects[1], document.form, IBSEARCHAPPEND);
        }
    }else{
    	    form.ctrt_cnt.value = "0";
    }



}   

