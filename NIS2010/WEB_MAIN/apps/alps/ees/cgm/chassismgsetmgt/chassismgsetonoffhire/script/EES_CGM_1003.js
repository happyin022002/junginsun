/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_CGM_1003.js
 *@FileTitle : Chassis Master Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.20
 *@LastModifier : 조재성
 *@LastVersion : 1.0
 * 2009.11.20 조재성
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2012.07.09 김창헌 [CHM-201218594-01] Enter나 Retrieve 하지 않고 자동적으로 조회되게 수정
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
 * @class ees_cgm_1003 : ees_cgm_1003 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ees_cgm_1003() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.initControl = initControl;
	this.doActionIBSheet = doActionIBSheet;
	this.setTabObject = setTabObject;
	this.validateForm = validateForm;
}

/* 개발자 작업 */

// 공통전역변수
var tabObjects = new Array();
var tabCnt = 0;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var IBSEARCH02 = 30;

var SEARCH_ENABLE = true;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick() {
	/** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    var sheetObj = sheetObjects[0];

	/** *****************************************************/
	var formObj = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
		var formObj = document.form;

		switch (srcName) {

		case "btn_retrieve":
			formObj.page_status.value = "R";
			// 검색조건이 없을때 알림 메세지
			if(formObj.n2nd_chss_als_no.value == null || formObj.n2nd_chss_als_no.value == "")
			{
				if(formObj.chss_als_no.value == null || formObj.chss_als_no.value == ""){
					if(formObj.eq_no.value == null || formObj.eq_no.value == ""){
						ComShowCodeMessage("CGM20023", "Chassis No or Alias No");
						formObj.eq_no.focus();
						return;
					}
				}
			}
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;

		case "btn_mvmt":
			var param = "";
		  	if(formObj.eq_no.value != '')
		  	{
		  		//param += "?pgmNo=EES_CGM_1105&eq_no="+formObj.eq_no.value;
		    	//ComOpenPopup('/hanjin/EES_CGM_1105.do' + param, 1000, 650, "", "1,0", true, false);
		  		
		  		
		  		var pgmNo = 'EES_CGM_1105';
		  		var pgmUrl = '/hanjin/EES_CGM_1105.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//eq_no 없어도 띄워준다.
		  		//param += "?pgmNo=EES_CGM_1105";
		    	//ComOpenPopup('/hanjin/EES_CGM_1105.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_CGM_1105';
		  		var pgmUrl = '/hanjin/EES_CGM_1105.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;		

		case "btn_status":
			var param = "";
		  	if(formObj.eq_no.value != '')
		  	{
		  		//param += "?pgmNo=EES_CGM_1016&eq_no="+formObj.eq_no.value;
		    	//ComOpenPopup('/hanjin/EES_CGM_1016.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_CGM_1016';
		  		var pgmUrl = '/hanjin/EES_CGM_1016.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_no="+formObj.eq_no.value ;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//eq_no 없어도 띄워준다.
		  		//param += "?pgmNo=EES_CGM_1143";
		    	//ComOpenPopup('/hanjin/EES_CGM_1016.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_CGM_1016';
		  		var pgmUrl = '/hanjin/EES_CGM_1016.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;

		case "btn_spec":
			var param = "";
		  	if(formObj.eq_no.value != '')
		  	{
		  		//param += "?pgmNo=EES_CGM_1002&eq_spec_no="+formObj.eq_spec_no.value;
		    	//ComOpenPopup('/hanjin/EES_CGM_1002.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_CGM_1002';
		  		var pgmUrl = '/hanjin/EES_CGM_1002.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&eq_spec_no="+formObj.eq_spec_no.value ;   
		    	
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//eq_no 없어도 띄워준다.
		  		//param += "?pgmNo=EES_CGM_1002";
		    	//ComOpenPopup('/hanjin/EES_CGM_1002.do' + param, 1000, 650, "", "1,0", true, false);
		    	var pgmNo = 'EES_CGM_1002';
		  		var pgmUrl = '/hanjin/EES_CGM_1002.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo;   
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;

		case "btn_mr":
			var param = "";
		  	if(formObj.eq_no.value != '')
		  	{
		  		//param += "?pgmNo=EES_MNR_0028&rqst_eq_no="+formObj.eq_no.value;
		    	//ComOpenPopup('/hanjin/EES_MNR_0028.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_MNR_0028';
		  		var pgmUrl = '/hanjin/EES_MNR_0028.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=Z&eq_no="+formObj.eq_no.value ;   
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }else
		    {
		    	//eq_no 없어도 띄워준다.
		  		//param += "?pgmNo=EES_MNR_0028";
		    	//ComOpenPopup('/hanjin/EES_MNR_1028.do' + param, 1000, 650, "", "1,0", true, false);
		  		var pgmNo = 'EES_MNR_0028';
		  		var pgmUrl = '/hanjin/EES_MNR_0028.do';
		  		var parentPgmNo = pgmNo.substring(0, 8)+'M001';   
		    	var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+"&from_sys=CGM&eq_type=Z";   
		    	var sFeatures = "status=no, width=1024, height=700, resizable=yes, scrollbars=yes";   
		    	var winObj = window.open("alpsMain.screen?parentPgmNo="+parentPgmNo+src,"",sFeatures);
		    }	
			break;

		case "btn_print": 
			//기본 정보가 전혀 없다면, 데이터가 없다고 판단함.
			if(    form.aciac_div_cd.value == "" 
				&& form.onh_dt.value == ""
				&& form.onh_ofc_cd.value == ""
				&& form.eq_tpsz_cd.value == ""
				&& form.mft_dt.value == ""
				&& form.chss_pool_cd.value == ""
				&& form.eq_spec_no.value == ""
				&& form.chss_tare_wgt_kgs.value == ""
			    && form.chss_tare_wgt.value == ""
				&& form.aciac_div_cd.value == ""
				&& form.aciac_div_cd.value == ""
				&& form.aciac_div_cd.value == ""
				
			) {
					errMsg = 'No data found.';
					ComShowMessage(msgs["CGM10012"]);
					return;
				}
				formObj.f_cmd.value = IBSEARCH02;
				ComOpenPopupWithTarget('/hanjin/EES_CGM_1004.do', 775, 800, "", "0,1,1,1,1,1,1", true);
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
function setSheetObject(sheet_obj) {

	sheetObjects[sheetCnt++] = sheet_obj;
}


/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var sheetObject = sheetObjects[0];
	formObj = document.form;
    for(i=0;i<sheetObjects.length;i++){

        // 시작 환경 설정 함수 이름 변경
    	ComConfigSheet (sheetObjects[i] );

    	initSheet(sheetObjects[i],i+1);
        // 마지막 환경 설정 함수 추가
    	ComEndConfigSheet(sheetObjects[i]);
    }
    // ALIAS NO. 1 속성 함수 호출
    //aliasDisable(); // chungpa 20090803 alias1,2로도 검색가능하도록 함.
    
    axon_event.addListener ("click",	"obj_onClick",	"n2nd_chss_als_no_chk", "chss_rgst_prd_cd");
    axon_event.addListenerFormat("keypress",	"obj_keypress",		formObj);
    axon_event.addListenerFormat('keyup',	'obj_keyup',	form);   //- 키 눌렸을때
    axon_event.addListenerFormat('keydown',	'obj_keydown',	form); //- 키 눌렸을때
    axon_event.addListenerForm('change',	'obj_change',	form); //- 변경될때
    axon_event.addListener('click', 'pop_atch_cntr', 'atch_cntr');			// atch_cntr popup
    axon_event.addListener('click', 'pop_atch_mgs', 'atch_mgs');			// atch_mgs popup
    
    if(formObj.eq_no.value != ""){
    	formObj.page_status.value = 'R';
    	doActionIBSheet(sheetObject, formObj, IBSEARCH);
    }
}


/**
 * 화면 콤보 초기화
 */
function initControl(sheetObj){
	 
	// chungpa 200900803 init impl
	formObj = document.form;
	 
	formObj.eq_no.value				= "";
	formObj.aciac_div_cd.value		= "";
	formObj.onh_dt.value			= "";
	formObj.onh_ofc_cd.value		= "";
	formObj.eq_tpsz_cd.value		= "";
	formObj.mft_dt.value			= "";
	
	formObj.chss_pool_cd.value		= "";
	formObj.disp_flg.value			= "";
	formObj.eq_spec_no.value       	= "";
	formObj.chss_tare_wgt_kgs.value    	= "";
	formObj.chss_tare_wgt.value    	= "";
	formObj.chss_mvmt_sts_cd.value 	= "";
	
	formObj.crnt_yd_cd.value       	= "";
	formObj.chss_mvmt_dt.value     	= "";
	formObj.agreement_no.value     	= "";
	formObj.agreement_no.value     	= "";
	formObj.agmt_lstm_cd.value     	= "";
	
	formObj.act_onh_dt.value       	= "";
	formObj.agmt_ref_no.value      	= "";
	formObj.vndr_abbr_nm.value		= "";
	formObj.chss_als_no.value		= "";
	formObj.n2nd_chss_als_no.value	= "";
	
	formObj.chss_rgst_ste_cd.value	= "";
	formObj.chss_rgst_lic_no.value	= "";
	formObj.chss_rgst_yr.value		= "";
	formObj.chss_veh_id_no.value	= "";
	//formObj.chss_tit_no.value		= "";
	
	formObj.chss_rgst_exp_dt.value	= "";
	formObj.chss_rgst_upd_dt.value	= "";
	formObj.chss_rgst_upd_id.value	= "";
	formObj.upd_dt.value			= "";
	formObj.upd_usr_id.value		= "";
	
	// Disposal 체크
	form.disp_flg.checked = false;
	// Weight 
	formObj.chss_tare_wgt_kgs.value    = ""
	formObj.chss_tare_wgt.value    = ""
	// CNTR 체크박스
	formObj.cntr_chk.checked = false;
	// MGSET 체크박스
	formObj.mgset_chk.checked = false;
	// BARE 체크박스
	formObj.bare_chk.checked = false;
	// DAMAGE 체크박스
	formObj.damage_chk.checked = false;
	// LSTAY 체크박스
	formObj.lstay_chk.checked = false
	formObj.chss_rgst_prd_cd[0].checked = false;
	formObj.chss_rgst_prd_cd[1].checked = false;
	
	formObj.cntr_chk.disabled   = false;
	formObj.mgset_chk.disabled  = false;
	formObj.bare_chk.disabled   = false;
	formObj.damage_chk.disabled = false;
	formObj.lstay_chk.disabled  = false;
	formObj.disp_flg.disabled   = false;
	// 라디오버튼 ENABLE
	formObj.chss_rgst_prd_cd(0).disabled = false;
	formObj.chss_rgst_prd_cd(1).disabled = false;
	
}


/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo) {

    var cnt = 0;

    switch(sheetNo) {
        case 1:      //t1sheet1 init
            with (sheetObj) {

                // 높이 설정
                style.height = 160;
                
                //전체 너비 설정
                SheetWidth = 200;

                //Host정보 설정[필수][HostIp, Port, PagePath]
  				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

               //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)

                var HeadTitle = "|eq_no|eq_knd_cd|aciac_div_cd|onh_dt|onh_ofc_cd|eq_tpsz_cd|mft_dt|chss_pool_cd|disp_flg|eq_spec_no|chss_tare_wgt_kgs|chss_tare_wgt|chss_mvmt_sts_cd|crnt_yd_cd|chss_mvmt_dt|cntr_chk|mgset_chk|bare_chk|damage_chk|lstay_chk|agreement_no|agmt_lstm_cd|act_onh_dt|agmt_ref_no|vndr_abbr_nm|chss_als_no|n2nd_chss_als_no|chss_rgst_ste_cd|chss_rgst_lic_no|chss_rgst_yr|chss_veh_id_no|chss_tit_no|chss_rgst_prd_cd|chss_rgst_exp_dt|cre_dt|cre_usr_id|upd_dt|upd_usr_id|atch_cntr|atch_mgs";
                var headCount = ComCountHeadTitle(HeadTitle);
                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(headCount, 0, 0, true);
                
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, true);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]

                InitDataProperty(0,	cnt++,	dtHiddenStatus,	30,		daCenter,	true,	"ibflag");
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_no",			false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_knd_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"aciac_div_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"onh_dt",			false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"onh_ofc_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_tpsz_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mft_dt",			false,	"",	dfNone,	0,	false,	false);                   
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_pool_cd",		false,	"",	dfNone,	0,	false,	false);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"disp_flg",			false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"eq_spec_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_tare_wgt_kgs",false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_tare_wgt",false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_mvmt_sts_cd",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"crnt_yd_cd",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_mvmt_dt",		false,	"",	dfNone,	0,	false,	false);                   

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cntr_chk",			false,	"",	dfNone,	0,	false,	false);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"mgset_chk",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"bare_chk",			false,	"",	dfNone,	0,	false,	false);                   
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"damage_chk",		false,	"",	dfNone,	0,	false,	false);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"lstay_chk",		false,	"",	dfNone,	0,	false,	false);                    

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agreement_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agmt_lstm_cd",		false,	"",	dfNone,	0,	false,	false);                   
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"act_onh_dt",		false,	"",	dfNone,	0,	false,	false);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"agmt_ref_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"vndr_abbr_nm",		false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_als_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"n2nd_chss_als_no",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_rgst_ste_cd",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_rgst_lic_no",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_rgst_yr",		false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_veh_id_no",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_tit_no",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_rgst_prd_cd",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"chss_rgst_exp_dt",	false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cre_dt",			false,	"",	dfNone,	0,	false,	false);

                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"cre_usr_id",		false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"upd_dt",			false,	"",	dfNone,	0,	false,	false);
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"upd_usr_id",		false,	"",	dfNone,	0,	false,	false);
                
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"atch_cntr",		false,	"",	dfNone,	0,	false,	false);                    
                InitDataProperty(0,	cnt++,	dtData,			100,	daCenter,	true,	"atch_mgs",			false,	"",	dfNone,	0,	false,	false);
            }//chss_rgst_lic_no//chss_veh_id_no//chss_rgst_exp_dt
            break;
    }
}


/**
 * Sheet관련 프로세스 처리
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];

	switch (sAction) {

		// Search
		case IBSEARCH:
	 		sheetObj.WaitImageVisible=false;
	 		ComOpenWait(true);		 
			formObj.f_cmd.value = SEARCH;
			sheetObj.DoSearch("EES_CGM_1003GS.do",FormQueryString(formObj));
			// 조회 데이타가 없을때 메세지 출력 // chungpa 20090803  오류메시지에 입력값출력. AND alias1,2로도 조회가능하게함.
			if(sheetObj.rowCount == 0){
				var tmpMsg = "";
				var tmp_eq_no = formObj.eq_no.value;
				
				/*
				if(formObj.n2nd_chss_als_no.value != null && formObj.n2nd_chss_als_no.value != "")
				{
					tmpMsg += " Alias No. 2("+ formObj.n2nd_chss_als_no.value + ")";
				}
				
				if(formObj.chss_als_no.value != null && formObj.chss_als_no.value != ""){
					tmpMsg = " Alias No. 1("+ formObj.chss_als_no.value + ")" + tmpMsg;
				}
				
				if(formObj.eq_no.value != null && formObj.eq_no.value != ""){
					tmpMsg = "Chassis No.("+ formObj.eq_no.value + ")" + tmpMsg; 
				}*/
				//2차 조회
				formObj.eq_no.value = "";
				formObj.chss_als_no.value = tmp_eq_no;
				sheetObj.DoSearch("EES_CGM_1003GS.do",FormQueryString(formObj));
				if(sheetObj.rowCount == 0)
				{
					//3차 조회
					formObj.eq_no.value = "";
					formObj.chss_als_no.value = "";
					formObj.n2nd_chss_als_no.value = tmp_eq_no;
					sheetObj.DoSearch("EES_CGM_1003GS.do", FormQueryString(formObj));
					if(sheetObj.rowCount == 0)
					{
						initControl();
						formObj.eq_no.value = tmp_eq_no;
						ComShowCodeMessage("CGM20023", formObj.eq_no.value);
						
				 		ComOpenWait(false);	
						return;
					}
					
				}
			}				

	 
			// 조회된 그리드 값을 해당 텍스트 필드에 셋팅
			//Basic Information Start
			formObj.eq_no.value            = sheetObj.CellValue(1, "eq_no");
			formObj.eq_tpsz_cd.value       = sheetObj.CellValue(1, "eq_tpsz_cd");
			formObj.eq_spec_no.value       = sheetObj.CellValue(1, "eq_spec_no");			
			formObj.mft_dt.value           = sheetObj.CellValue(1, "mft_dt");
			
			if(sheetObj.CellValue(1, "chss_tare_wgt") == ""){
				formObj.chss_tare_wgt_kgs.value    = ComAddComma(sheetObj.CellValue(1, "chss_tare_wgt_kgs")); // Weight 값 세자리마다 콤마를 찍어줍니다.(kgs)
				formObj.chss_tare_wgt.value  =  ComAddComma((sheetObj.CellValue(1, "chss_tare_wgt_kgs").replaceStr(",")*2.2046).toFixed(0)); // KG->lbs 환산 후 Weight 값 세자미마다 콤마를 찍어줍니다.	
			} else {
				formObj.chss_tare_wgt.value    = ComAddComma(sheetObj.CellValue(1, "chss_tare_wgt")); // Weight 값 세자리마다 콤마를 찍어줍니다.(lbs)
				formObj.chss_tare_wgt_kgs.value  =  ComAddComma((sheetObj.CellValue(1, "chss_tare_wgt").replaceStr(",")/2.2046).toFixed(0)); // lbs->KG 환산 후 Weight 값 세자미마다 콤마를 찍어줍니다.
			}
			
			//Basic Information End
			
			// Current Status Start
			formObj.aciac_div_cd.value     = sheetObj.CellValue(1, "aciac_div_cd");
			formObj.chss_pool_cd.value     = sheetObj.CellValue(1, "chss_pool_cd");
			formObj.onh_dt.value           = sheetObj.CellValue(1, "onh_dt");
			formObj.onh_ofc_cd.value       = sheetObj.CellValue(1, "onh_ofc_cd");
			formObj.chss_mvmt_sts_cd.value = sheetObj.CellValue(1, "chss_mvmt_sts_cd");
			formObj.crnt_yd_cd.value       = sheetObj.CellValue(1, "crnt_yd_cd");
			formObj.chss_mvmt_dt.value     = sheetObj.CellValue(1, "chss_mvmt_dt");
			
			if(sheetObj.CellValue(1, "cntr_chk") == "Y"){ 			// CNTR 체크박스
				formObj.cntr_chk.checked = true;
			} else {
				formObj.cntr_chk.checked = false;
			}

			if(sheetObj.CellValue(1, "mgset_chk") == "Y"){			// MGSET 체크박스
				formObj.mgset_chk.checked = true;
			} else {
				formObj.mgset_chk.checked = false;
			}

			if(sheetObj.CellValue(1, "bare_chk") == "Y"){			// BARE 체크박스
				formObj.bare_chk.checked = true;
			} else {
				formObj.bare_chk.checked = false;
			}

			if(sheetObj.CellValue(1, "damage_chk") == "Y"){			// DAMAGE 체크박스
				formObj.damage_chk.checked = true;
			} else {
				formObj.damage_chk.checked = false;
			}

			formObj.disp_flg.value = sheetObj.CellValue(1, "disp_flg");			// Disposal 체크
			if(sheetObj.CellValue(1, "disp_flg") == "Y"){
				form.disp_flg.checked = true;
			} else {
				form.disp_flg.checked = false;
			}			

			if(sheetObj.CellValue(1, "lstay_chk") == "Y"){			// LSTAY 체크박스
				formObj.lstay_chk.checked = true;
			} else {
				formObj.lstay_chk.checked = false
			}
			// Current Status End
			
			//Agreement Start
			formObj.agreement_no.value     = sheetObj.CellValue(1, "agreement_no");
			formObj.agmt_lstm_cd.value     = sheetObj.CellValue(1, "agmt_lstm_cd");
			formObj.act_onh_dt.value       = sheetObj.CellValue(1, "act_onh_dt");
			formObj.chss_als_no.value      = sheetObj.CellValue(1, "chss_als_no");
			formObj.agmt_ref_no.value      = sheetObj.CellValue(1, "agmt_ref_no");
			formObj.vndr_abbr_nm.value     = sheetObj.CellValue(1, "vndr_abbr_nm");
			formObj.n2nd_chss_als_no.value = sheetObj.CellValue(1, "n2nd_chss_als_no");
			//Agreement End
			
			//Registration Start
			formObj.chss_rgst_ste_cd.value = sheetObj.CellValue(1, "chss_rgst_ste_cd");
			formObj.chss_rgst_yr.value     = sheetObj.CellValue(1, "chss_rgst_yr");
			formObj.chss_rgst_lic_no.value = sheetObj.CellValue(1, "chss_rgst_lic_no");
			formObj.chss_veh_id_no.value   = sheetObj.CellValue(1, "chss_veh_id_no");
			//Expiry 라디오버튼 체크
			if(sheetObj.CellValue(1, "chss_rgst_prd_cd") == "P"){
				formObj.chss_rgst_prd_cd[0].checked = true;
			} else {
				formObj.chss_rgst_prd_cd[1].checked = true;
			}			
			formObj.chss_rgst_exp_dt.value = sheetObj.CellValue(1, "chss_rgst_exp_dt");
			//formObj.chss_tit_no.value      = sheetObj.CellValue(1, "chss_tit_no"); 기존 있었으나 삭제됨 (20091120 by chungpa)
			//Registration End
			
			//chungpa 20091203 2006 MASTER 추가 항목 start  
			formObj.atch_cntr.value 		= sheetObj.CellValue(1, "atch_cntr");
			formObj.atch_mgs.value 			= sheetObj.CellValue(1, "atch_mgs");
			//chungpa 20091203 2006 MASTER 추가 항목 end
			
			//기본정보2 start
			formObj.chss_rgst_upd_dt.value = sheetObj.CellValue(1, "cre_dt");
			formObj.chss_rgst_upd_id.value = sheetObj.CellValue(1, "cre_usr_id");
			formObj.upd_dt.value           = sheetObj.CellValue(1, "upd_dt");
			formObj.upd_usr_id.value       = sheetObj.CellValue(1, "upd_usr_id");
			//기본정보2 end

			if(formObj.page_status.value == "R"){
				//체크박스 DISABLE
				formObj.cntr_chk.disabled   = true;
				formObj.mgset_chk.disabled  = true;
				formObj.bare_chk.disabled   = true;
				formObj.damage_chk.disabled = true;
				formObj.lstay_chk.disabled  = true;
				formObj.disp_flg.disabled   = true;
				//라디오버튼 DISABLE
				formObj.chss_rgst_prd_cd(0).disabled = true;
				formObj.chss_rgst_prd_cd(1).disabled = true;
			} else {
				// 체크박스 ENABLE
				formObj.cntr_chk.disabled   = false;
				formObj.mgset_chk.disabled  = false;
				formObj.bare_chk.disabled   = false;
				formObj.damage_chk.disabled = false;
				formObj.lstay_chk.disabled  = false;
				formObj.disp_flg.disabled   = false;
				// 라디오버튼 ENABLE
				formObj.chss_rgst_prd_cd(0).disabled = false;
				formObj.chss_rgst_prd_cd(1).disabled = false;
			}
	 		
	 		ComOpenWait(false);	
			break;
	}
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if (!isNumber(formObj.iPage)) {
		// return false;
		// }
	}

	return true;
}


/**
 * ALIAS 체크박스 선택(ALIAS NO 2 ->> ALIAS NO2 TEXT BOX ENABLE-DISABLE)
 */
function obj_onClick(sheetObj, Row, Col){
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];

	// ALIAS CHECKBOX
	if(formObj.n2nd_chss_als_no_chk.checked == true){
		formObj.chss_als_no.disabled = false;
	} else {
		formObj.chss_als_no.disabled = true;
	}

	// EXPIRY RADIO
	if(formObj.chss_rgst_prd_cd[0].checked == true){
		sheetObj.CellValue(1, "chss_rgst_prd_cd") = "P";
	} else {
		sheetObj.CellValue(1, "chss_rgst_prd_cd") = "F";
	}
}


/**
 * ALIAS NO DISABLE
 */
function aliasDisable(){
	var formObj = document.form;
	formObj.chss_als_no.disabled = true;
}


/**
 * 키 입력 제한(JSP 파일  해당 텍스트 필드에 DATAFORMAT에 셋팅해줌.)
 */
function obj_keypress(){
	 obj = event.srcElement;
	 if(obj.dataformat == null){
		 return;
	 }
	 window.defaultStatus = obj.dataformat;
	 
	 switch(obj.dataformat) {
  	    case "engup":
	        if(obj.name == "eq_no" || obj.name=="chss_als_no" || obj.name=="n2nd_chss_als_no"){
	        	ComKeyOnlyAlphabet("uppernum");
	        }
	        break;
	    case "isnum":
	    	ComKeyOnlyNumber(obj);
	    	break;
	 }
 }

/**
 * obj_keyup
 */   
function obj_keyup() {
	var obj = event.srcElement;
	
	switch (obj.name) {
		case "eq_no": 
			ComKeyEnter('LengthNextFocus');
	  		break;
	}
}

/**
 * Key-Down Event 처리
 */
 
function obj_keydown() {
	var obj      = event.srcElement;
	var vKeyCode = event.keyCode;
	var ctrlKey = event.ctrlKey;
	var formObj  = document.form;
	switch (obj.name) {
		case "eq_no":
  		if ( vKeyCode == 9 || vKeyCode == 13 ) {
  			SEARCH_ENABLE = false;
			
  			formObj.page_status.value = "R";
			// 검색조건이 없을때 알림 메세지
			if(formObj.n2nd_chss_als_no.value == null || formObj.n2nd_chss_als_no.value == "")
			{
				if(formObj.chss_als_no.value == null || formObj.chss_als_no.value == ""){
					if(formObj.eq_no.value == null || formObj.eq_no.value == ""){
						ComShowCodeMessage("CGM20023", "Chassis No or Alias No");
						formObj.eq_no.focus();
						return;
					}
				}
			}
  			
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
  			SEARCH_ENABLE = true;
  			ComSetFocus(formObj.eq_no);
  		}
  		break;
	}	
} 	 

/**
 * HTML Control의 Value가 변경되었을 경우 처리한다.
 */
function obj_change(){
	var obj      = event.srcElement;
	var formObj  = document.form;

	if ( ComTrim(ComGetObjValue(obj)) != "" ) {
		switch(obj.name) {
    		case "eq_no":
    			if ( SEARCH_ENABLE ) {
    	  			formObj.page_status.value = "R";
    				// 검색조건이 없을때 알림 메세지
    				if(formObj.n2nd_chss_als_no.value == null || formObj.n2nd_chss_als_no.value == "")
    				{
    					if(formObj.chss_als_no.value == null || formObj.chss_als_no.value == ""){
    						if(formObj.eq_no.value == null || formObj.eq_no.value == ""){
    							ComShowCodeMessage("CGM20023", "Chassis No or Alias No");
    							formObj.eq_no.focus();
    							return;
    						}
    					}
    				}

    				formObj.eq_no.value=formObj.eq_no.value.toUpperCase(); // Copy&paste 소문자를 대문자로 변경
    				doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    				ComSetFocus(formObj.eq_no);
    			}
				break;	
	    }
	}	
}	
		
/** 
 * pop_atch_cntr 의 popup 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.08
 */
 function pop_atch_cntr(){
	  var formObj = document.form;
	  if(formObj.atch_cntr.value != "")
	  {
		  var formObj = document.form;
		  if(formObj.atch_cntr.value != "")
		  {
				var param = "?pgmNo=EES_CGM_1109";
	   		   	param = param + "&f_cmd=" + SEARCH; 
	   			param = param + "&p_cntrno=" + formObj.atch_cntr.value;   
	   		    ComOpenPopup('/hanjin/EES_CGM_1109.do' + param, 1080, 600, "", "1,0", true, false);
		  }
	  }
	  
 }	 

/** 
 * pop_atch_mgs 의 popup 이벤트에 대한 처리  <br>
 * @param  없음
 * @return 없음
 * @author 조재성
 * @version 2009.12.08
 */
 function pop_atch_mgs(){
	  var formObj = document.form;
	  if(formObj.atch_mgs.value != "")
	  {
			var param = "?pgmNo=EES_CGM_2006";
   		   	param = param + "&f_cmd=" + SEARCH; 
   			param = param + "&eq_no=" + formObj.atch_mgs.value;   
   		    ComOpenPopup('/hanjin/EES_CGM_2006.do' + param, 1080, 600, "", "1,0", true, false);
	  }
 }
/* 개발자 작업 끝 */
