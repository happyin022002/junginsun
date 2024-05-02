/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0243.js
*@FileTitle : EOTP 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.08.05 서창열
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
 * @class VOP_VSK_0243 : VOP_VSK_0243 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function VOP_VSK_0243() {
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


 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
 function processButtonClick(){
      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
      
      var sheetObject1 = sheetObjects[0];
      var sheetObject2 = sheetObjects[1];
      var sheetObject3 = sheetObjects[2];
      var sheetObject4 = sheetObjects[3];
      
      /*******************************************************/
      var formObject = document.form;

 	try {
 		var srcName = window.event.srcElement.getAttribute("name");

         switch(srcName) {

			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
				
			case "btn_New":
				clearAllData(sheetObject3,sheetObject4);
				break;
				
			case "btn_Close":
				doReturnData(formObject);
				break;
//			case "btn_Ok":
//				doReturnData(formObject);
//				break;	


         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
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

         ComConfigSheet (sheetObjects[i] );

         initSheet(sheetObjects[i],i+1);

         ComEndConfigSheet(sheetObjects[i]);

     }
     parentPfSkdMaster();
     parentPfSkdDetail();

 }
     
 function parentPfSkdMaster(){
	 var formObj = document.form;
	 var parentObj = getParent(0);
	 
	 var sXml = ComMakeSearchXml(parentObj, false, "sheet1_hiddencheck","sheet1_vsl_slan_cd|sheet1_pf_svc_tp_cd|sheet1_slan_stnd_flg|sheet1_svc_dur_dys|sheet1_stnd_svc_spd|sheet1_brth_itval_dys|sheet1_mml_usd_flg|sheet1_sim_dt|sheet1_sim_no|sheet1_n1st_vsl_clss_cd|sheet1_n1st_vsl_clss_knt|sheet1_n2nd_vsl_clss_cd|sheet1_n2nd_vsl_clss_knt|sheet1_n3rd_vsl_clss_cd|sheet1_n3rd_vsl_clss_knt|sheet1_clpt_knt|sheet1_ttl_dist|sheet1_max_spd|sheet1_avg_spd|sheet1_delt_flg|sheet1_pf_skd_rmk", false);
	 sheetObjects[0].LoadSearchXml(sXml, true); 
	 
	 var prefix 	= "sheet1_";
	 var classCount = 0;
	 
	 formObj.n1st_vsl_clss_cd.value 	= sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_cd");	 
	 classCount = sheetObjects[0].CellValue(1,prefix+"n1st_vsl_clss_knt");	 
	 if (classCount == 0) {	 
		 formObj.n1st_vsl_clss_knt.value 	= "";
 	 }else {
		 formObj.n1st_vsl_clss_knt.value 	= classCount;
	 }
	 
	 formObj.n2nd_vsl_clss_cd.value 	= sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_cd");	
	 classCount = sheetObjects[0].CellValue(1,prefix+"n2nd_vsl_clss_knt");	 
	 if (classCount == 0) {	 
		 formObj.n2nd_vsl_clss_knt.value 	= "";
 	 }else {
		 formObj.n2nd_vsl_clss_knt.value 	= classCount;
	 }
	 
	 formObj.n3rd_vsl_clss_cd.value 	= sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_cd");
	 classCount = sheetObjects[0].CellValue(1,prefix+"n3rd_vsl_clss_knt");
	 if (classCount == 0) {	 
		 formObj.n3rd_vsl_clss_knt.value 	= "";
 	 }else {
		 formObj.n3rd_vsl_clss_knt.value 	= classCount;
	 }
	 
 }
 
 function parentPfSkdDetail(){
	 var parentObj = getParent(1);
	 
	 var sXml = ComMakeSearchXml(parentObj, false, "sheet2_hiddencheck","sheet2_ibflag|sheet2_skd_dir_cd|sheet2_port_cd|sheet2_yd_cd|sheet2_zd|sheet2_etb_dy_no|sheet2_etb_dy_cd|sheet2_etb_tm_hrmnt|sheet2_etd_dy_no|sheet2_etd_dy_cd|sheet2_etd_tm_hrmnt|sheet2_lnk_dist|sheet2_lnk_spd|sheet2_tztm_hrs|sheet2_sea_buf_hrs|sheet2_sea_buf_spd|sheet2_mnvr_in_hrs|sheet2_mnvr_out_hrs|sheet2_act_wrk_hrs|sheet2_port_buf_hrs|sheet2_ib_ipcgo_qty|sheet2_ob_ipcgo_qty|sheet2_ib_ocn_cgo_qty|sheet2_ob_ocn_cgo_qty|sheet2_tml_prod_qty|sheet2_crn_knt|sheet2_turn_port_flg|sheet2_turn_port_ind_cd|sheet2_vsl_slan_cd|sheet2_pf_svc_tp_cd", false);
	 sheetObjects[1].LoadSearchXml(sXml, true); 
 } 
 /**
 * 부모창의 활성화된 Sheet 정보를 가져온다.
 * @return
 */
function getParent(idx){
	var opner = window.dialogArguments;
	if(opner.sheetObjects){
		if(opner.sheetObjects.length > 0){
			return opner.sheetObjects[idx];
		}
	}
	
	return opner.sheetObjects[idx];
}

  /**
  * 시트 초기설정값, 헤더 정의
  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
  */
 function initSheet(sheetObj,sheetNo) {

     var cnt = 0;
	 var sheetId = sheetObj.id;

     switch(sheetId) {
     case "sheet1":      //sheet1 init
         with (sheetObj) {

             // 높이 설정
             style.height = 0;
             //전체 너비 설정
             SheetWidth = 0;

             //Host정보 설정[필수][HostIp, Port, PagePath]
             if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

             //전체Merge 종류 [선택, Default msNone]
             MergeSheet = msNone;

            //전체Edit 허용 여부 [선택, Default false]
             Editable = false;

             //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
             InitRowInfo( 1, 1, 3, 100);

             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(true, true, true, true, false,false)

             var HeadTitle = "STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK";
             var headCount = ComCountHeadTitle(HeadTitle);
             
             //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
             InitColumnInfo(headCount, 0, 0, true);

             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle, true);
             
             var prefix = "sheet1_";
             //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
             InitDataProperty(0, cnt++ , dtHiddenStatus, 	30,  	daCenter, 	false, 		prefix+"ibflag");
             InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"vsl_slan_cd",    		false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"pf_svc_tp_cd",    		false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daCenter,  	false,    	prefix+"slan_stnd_flg",    		false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"svc_dur_dys",    		false,          "",      dfNone);
             
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"stnd_svc_spd",    		false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"brth_itval_dys",   		false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"mml_usd_flg",  			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"sim_dt",     			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"sim_no",     			false,          "",      dfNone);
             
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_cd",    	false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n1st_vsl_clss_knt",   	false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n2nd_vsl_clss_cd",  	false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"n2nd_vsl_clss_knt",    	false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"n3rd_vsl_clss_cd",     	false,          "",      dfNone);
             
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"n3rd_vsl_clss_knt",    	false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"clpt_knt",   			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,    		80,    	daLeft,  	false,    	prefix+"ttl_dist",  			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"max_spd",     			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"avg_spd",     			false,          "",      dfNone);
             
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"delt_flg",     			false,          "",      dfNone);
             InitDataProperty(0, cnt++ , dtData,   			80,    	daCenter,  	false,    	prefix+"pf_skd_rmk",     		false,          "",      dfNone);
             
             
             CountPosition = 0;
             WaitImageVisible = false;
        }
         
         break;
         
         case "sheet2":      //sheet1 init
             with (sheetObj) {

                 // 높이 설정
                 style.height = 0;

                 // 전체 너비 설정
                 SheetWidth = 0;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = true;
                 
                 var HeadTitle1 = "|DIR|Port\nCode|TMNL Code|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|Manu.|Manu.|Working\nHour|Port\nBuffer|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|TML Prod.|TML Prod.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
                 var HeadTitle2 = "|DIR|Port\nCode|TMNL Code|ZD|NO.|DAY|TIME|NO.|DAY|TIME|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|IN|OUT|Working\nHour|Port\nBuffer|IPC|IPC|Ocean|Ocean|.|.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
                 var HeadTitle3 = "|DIR|Port\nCode|TMNL Code|ZD|NO.|DAY|TIME|NO.|DAY|TIME|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|IN|OUT|Working\nHour|Port\nBuffer|IN|OUT|IN|OUT|.|.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
 				 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo(3, 1, 10, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, false, true, true, false, false);

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);		
                 InitHeadRow(1, HeadTitle2, true);		
                 InitHeadRow(2, HeadTitle3, true);		
                 
                 var prefix = "sheet2_";
                 //데이터속성    [	ROW, COL,  DATATYPE,   		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  				KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	39,		daCenter,	true,	prefix+"ibflag",			false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			39,		daCenter,	true,	prefix+"skd_dir_cd",		false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			60,		daCenter,	true,	prefix+"port_cd",			false,	"",			dfEngUpKey,		0, 		true,		true,		5,			false,		false);

 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"yd_cd",				false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"zd",				false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etb_dy_no",			false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etb_dy_cd",			false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			45,		daCenter,	true,	prefix+"etb_tm_hrmnt",		false,	"",			dfTimeHm,		0);
                                                                                             	
 				InitDataProperty(0, cnt++ , dtData,			30,		daRight,	true,	prefix+"etd_dy_no",			false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,	prefix+"etd_dy_cd",			false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"etd_tm_hrmnt",		false,	"",			dfTimeHm,		0);
 				InitDataProperty(0, cnt++ , dtData,			40,		daRight,	true,	prefix+"lnk_dist",			false,	"",			dfInteger,		0,		true,		true,		6,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,		    40,		daRight,	true,	prefix+"lnk_spd",			false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                             	
 				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"tztm_hrs",			false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sea_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		4,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"sea_buf_spd",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"mnvr_in_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"mnvr_out_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
                                                                                             	
 				InitDataProperty(0, cnt++ , dtData,			55,		daRight,	true,	prefix+"act_wrk_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"port_buf_hrs",		false,	"",			dfFloat,		1,      true,		true,		3,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			50,		daRight,	true,	prefix+"ib_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"ob_ipcgo_qty",		false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"ib_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
                                                                                             	
 				InitDataProperty(0, cnt++ , dtData,			45,		daRight,	true,	prefix+"ob_ocn_cgo_qty",	false,	"",			dfInteger,		0,      true,		true,		5,			false,		false);
 				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"tml_prod_qty",		false,	"",			dfInteger,		0);
 				InitDataProperty(0, cnt++ , dtData,			35,		daRight,	true,	prefix+"crn_knt",			false,	"",			dfInteger,		1);
 				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"turn_port_flg",		false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"turn_port_ind_cd",	false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"vsl_slan_cd",		false,	"",			dfNone,			0);
 				InitDataProperty(0, cnt++ , dtHidden,		00,		daCenter,	true,	prefix+"pf_svc_tp_cd",		false,	"",			dfNone,			0);
 				
 				
 				CountPosition = 0;
 				SetSortDialog(false);		
 				//SheetOutLineColor = RgbColor(0,0,0);
 				RowHeight(0) = 10;
 				RowHeight(1) = 10;
 				RowHeight(2) = 10;
 				WaitImageVisible = false;
 				
 										
                }
                 break;
         case "sheet3":      
             with (sheetObj) {
                 // 높이 설정
                 style.height = 400;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;                

                 var HeadTitle1 = "Seq.|Port\nCode|TTL\nCount|On-Time|On-Time|EOTP|EOTP|";
                 var HeadTitle2 = "Seq.|Port\nCode|TTL\nCount|Count|Ratio|Count|Ratio|";
                 var headCount = ComCountHeadTitle(HeadTitle1);

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);
                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(headCount, 0, 0, true);
                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 //InitHeadMode(false, true, false, true, false,false)
                 InitHeadMode(false, false, true, true, false, false);
                 

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);	


                 var prefix = "sheet3_";
                 //데이터속성    [ ROW, 	COL,  		DATATYPE,   	WIDTH, DATAALIGN, 	COLMERGE, 		SAVENAME,  				KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, 	cnt++ , 	dtSeq,			30,		daCenter,		true,		prefix+"Seq");
				InitDataProperty(0, 	cnt++ , 	dtData,			50,		daCenter,		true,		prefix+"portcd",		false,		"",			dfNone,			0,			true,		true);
				InitDataProperty(0, 	cnt++ , 	dtAutoSum,		50,		daRight,		true,		prefix+"ttl_cnt",		false,		"",			dfNone,			0,			true,		true);
				InitDataProperty(0, 	cnt++ , 	dtAutoSum,		60,		daRight,		true,		prefix+"on_tm_cnt",		false,		"",			dfNone,			0,			true,		true);
				InitDataProperty(0, 	cnt++ , 	dtAutoAvg,		60,		daRight,		true,		prefix+"on_tm_rt",		false,		"",			dfFloat,		1,			true,		true,		3,			false,		false);
			
				InitDataProperty(0, 	cnt++ , 	dtData,			50,		daRight,		false,		prefix+"eotp_cnt",		false,		"",			dfNone,			0,			true,		true);
				InitDataProperty(0, 	cnt++ , 	dtAutoAvg,		45,		daRight,		false,		prefix+"eotp_rt01",		false,		"",			dfFloat,		1,			true,		true,		3,			false,		false);
				InitDataProperty(0, 	cnt++ , 	dtAutoAvg,		45,		daRight,		false,		prefix+"eotp_rt02",		false,		"",			dfFloat,		1,			true,		true,		3,			false,		false);
				
				CountPosition = 0;

				//20 픽셀로 높이 수정
				RowHeight(0) = 20;
				RowHeight(1) = 20;
				
				ColHidden(prefix+"eotp_rt02") = true;
				WaitImageVisible = false;
             	}
             
             	break;
             
         case "sheet4":      
             with (sheetObj) {
                 // 높이 설정
                 style.height = 400;
                 // 전체 너비 설정
                 SheetWidth = mainTable.clientWidth;

                 //Host정보 설정[필수][HostIp, Port, PagePath]
                 if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                 //전체Merge 종류 [선택, Default msNone]
                 MergeSheet = msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                 Editable = false;

                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                 InitRowInfo( 2, 1, 3, 100);

                 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                 InitColumnInfo(18, 0, 0, true);

                 // 해더에서 처리할 수 있는 각종 기능을 설정한다
                 InitHeadMode(false, true, false, true, false,false)

                 var HeadTitle1 = "Seq.\n|On-time\n(Y/N)|VSL\nCLS\n|VVD|Old\nPort Time|New Port Time|New Port Time|New Sea Time|New Sea Time|Act.\nSea Time|Dist.|Max.\nSpeed\n|Act.\nSp'd\n|MRT|EOTP1|EOTP1-Result|EOPT2|EOTP2-Result";
                 var HeadTitle2 = "Seq.\n|On-time\n(Y/N)|VSL\nCLS\n|VVD|Old\nPort Time|Port|Buf.|Sea|Buf.|Act.\nSea Time|Dist.|Max.\nSpeed\n|Act.\nSp'd\n|MRT|EOTP1|EOTP1-Result|EOPT2|EOTP2-Result";
                 

                 //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                 InitHeadRow(0, HeadTitle1, true);
                 InitHeadRow(1, HeadTitle2, true);

                 var prefix = "sheet4_";
                 //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtSeq,		30,	daCenter,		true,	prefix+"Seq");
				InitDataProperty(0, cnt++ , dtData,		60,	daCenter,		true,	prefix+"on_tm_yn",			false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		35,	daCenter,		true,	prefix+"vsl_class",			false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		70,	daCenter,		true,	prefix+"vvd",				false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		65,	daRight,		true,	prefix+"old_port_tm",		false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		true,	prefix+"new_port_tm",		false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		true,	prefix+"new_port_buf_tm",	false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		false,	prefix+"new_sea_tm1",		false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		false,	prefix+"new_sea_buf_tm",	false,	"",		dfNone,			0,			true,		true);				
				InitDataProperty(0, cnt++ , dtData,		60,	daRight,		true,	prefix+"act_sail_tm",		false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		true,	prefix+"lnk_dist",			false,	"",		dfNone,			0,			true,		true);				
				InitDataProperty(0, cnt++ , dtData,		45,	daRight,		true,	prefix+"max_spd",			false,	"",		dfNone,			0,			true,		true);				
				InitDataProperty(0, cnt++ , dtData,		47,	daRight,		true,	prefix+"act_spd",			false,	"",		dfNone,			0,			true,		true);				
								
				InitDataProperty(0, cnt++ , dtData,		40,	daRight,		true,	prefix+"recovery_tm",		false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		43,	daCenter,		true,	prefix+"chk_eotp01",		false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,	50,	daCenter,		true,	prefix+"eotp01",			false,	"",		dfNone,			0,			true,		true);
				
				InitDataProperty(0, cnt++ , dtData,		40,	daCenter,		true,	prefix+"chk_eotp02",		false,	"",		dfNone,			0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,	50,	daCenter,		true,	prefix+"eotp02"		,		false,	"",		dfNone,			0,			true,		true);

				CountPosition = 0;
				
				//20 픽셀로 높이 수정
				RowHeight(0) = 20;
				RowHeight(1) = 20;

				FrozenCols = SaveNameCol(prefix+"old_port_tm");
				
				WaitImageVisible = false;
             	}
             	break; 
     }
 }

   // Sheet관련 프로세스 처리
 function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
     switch(sAction) {

        case IBSEARCH:      //조회

        	sheetObjects[0].RowStatus(1) = "U";

        	for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
        		sheetObjects[1].RowStatus(i) = "U";
			}

        	ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH;
        	
        	var SaveStr 	= ComGetSaveString(sheetObjects);
        	var aryPrefix 	= new Array("sheet3_", "sheet4_");
	     	var sXml 		= sheetObj.GetSaveXml("VOP_VSK_0243GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	var arrXml 		= sXml.split("|$$|");
	     	
	     	for(var inx=0; inx<arrXml.length; inx++){
				showSheetData(sheetObjects[2+inx],formObj,arrXml[inx]);
			}
	     	
	     	ComOpenWait(false);
            break;
            
		 case SEARCH02:        

//		 	sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U"; 
			 sheetObjects[0].RowStatus(1) = "U";
			 
			for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//				sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
				sheetObjects[1].RowStatus(i) = "U";
			}
			
			ComOpenWait(true);
        	formObj.f_cmd.value = SEARCH02;
        	
        	var SaveStr 	= ComGetSaveString(sheetObjects);
        	var aryPrefix 	= new Array("sheet4_");
	     	var sXml 		= sheetObj.GetSaveXml("VOP_VSK_0243GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	
	     	showSheetData(sheetObjects[3], formObj, sXml);		     	
	     	ComOpenWait(false);
		     	
             break;

     }
 }
 
/**
 * 조회 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml){
	var prefix = sheetObj.id + "_";
	
	switch(sheetObj.id){
		case "sheet3":
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
			
			formObj.eotp01.value = sheetObj.SumValue(0,6)+"%";
			formObj.eotp02.value = sheetObj.SumValue(0,7)+"%";

			sheetObj.Redraw = true;

		break;
		
		case "sheet4":
			
			sheetObj.Redraw = false;
			sheetObj.LoadSearchXml(sXml);
	     	
			var grayColor = sheetObj.RgbColor(eval("239"),eval("235"),eval("239"));
			
			for(var k=2; k < sheetObj.RowCount+2; k++){			
								
				// 회복시간 = Null 일 경우 회색 처리.
				if(sheetObj.CellValue(k, prefix+"recovery_tm") == "" ){					
					sheetObj.CellBackColor(k, prefix+"recovery_tm") = grayColor;
				}
				
				// Max speed = Null 일 경우 회색 처리.
				if(sheetObj.CellValue(k, prefix+"max_spd") == "" ){			
					sheetObj.CellBackColor(k, prefix+"max_spd") = grayColor;
				}
				
				// Actual speed = Null 일 경우 회색 처리.
				if(sheetObj.CellValue(k, prefix+"act_spd") == "" ){			
					sheetObj.CellBackColor(k, prefix+"act_spd") = grayColor;
				}
       	 	}
			
			sheetObj.Redraw = true;
			
		break;
	}

} 

function sheet3_OnDblClick(sheetObj,Row,Col){
	var rowIdx = sheetObj.SelectRow + sheetObj.HeaderRows;
	var ttlCount = sheetObj.CellValue(Row,"sheet3_ttl_cnt");

	var formObj = document.form;
	
	if(rowIdx){
		if(rowIdx > sheetObj.HeaderRows){
			if(ttlCount > 0){
				formObj.eventNav.value = Row - sheetObj.HeaderRows;
				formObj.portNm.value = sheetObj.CellValue(Row,"sheet3_portcd");
				 
				doActionIBSheet(sheetObj, formObj, SEARCH02);
			}
			
		}
	}
}


/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj3,sheetObj4){

	sheetObj3.RemoveAll();
	sheetObj4.RemoveAll();

}

function doReturnData(formObj){
	var cnt = sheetObjects[2].RowCount;
	if(cnt < 1){
		ComShowCodeMessage("VSK00043");
	}
	var eotpVal1 = formObj.eotp01.value;
	var eotpVal2 = formObj.eotp02.value;
	var opner = window.dialogArguments;
	if(eotpVal1 == ""){
		eotpVal1 = "0%";
	}
	
	if(eotpVal2 == ""){
		eotpVal2 = "0%";
	}
	
	opner.document.form.eotp1.value = eotpVal1;
	opner.document.form.eotp2.value = eotpVal2;
	
	window.close();
}

function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
	
    if(sheetObj.RowCount > 0){
    	//마우스 위치를 행과 컬럼과 값 가져오기
        var Row = sheetObj.MouseRow;
        var Col = sheetObj.MouseCol;
        var prefix = sheetObj.id+"_";
        
        // sheet4에서 풍선도움말 사용.
        if (Row < 2) {	
        	sheetObj.ToolTipOption="balloon:true;width:320";
        } else {
        	sheetObj.ToolTipOption="balloon:true;width:1000";
        }
        
        if (Row == 0 || Row == 1) {
        	if (Col == 14) {
        		sheetObj.MouseToolTipText = "(New Port Time + Port Buffer) - Actaul Port Time +\n(Sea Time + Sea Buffer) - (Actual Port Time)"
        		sheetObj.MousePointer = "Hand";
        	} else if (Col == 16) {
        		sheetObj.MouseToolTipText = "(New Port Time + Port Buffer) - Actaul Port Time +\n(Sea Time + Sea Buffer) - (Actual Port Time) +\nStandard Distance * (1/Actual Speed - 1/Max Speed)"
            	sheetObj.MousePointer = "Hand";
        	}
        }
        else if( Row > 1 && Col == 14){
	        var sText = sheetObj.CellText(Row, "sheet4_eotp01");
	        	
	        if(sText != ""){
	        	sheetObj.MouseToolTipText = sText;
	        	sheetObj.MousePointer = "Hand";
	        }else{
	        	sheetObj.MouseToolTipText = "";
	            sheetObj.MousePointer = "Default";	
	        }       	
        } else if (Row > 1 && Col == 16)
        {
        	var sText = sheetObj.CellText(Row, "sheet4_eotp02");
	        	
 	        if(sText != ""){
 	        	sheetObj.MouseToolTipText = sText;
 	        	sheetObj.MousePointer = "Hand";
 	        }else{
 	        	sheetObj.MouseToolTipText = "";
 	            sheetObj.MousePointer = "Default";	
 	        }
        } else {
        	sheetObj.MouseToolTipText = "";
	        sheetObj.MousePointer = "Default";
        }
    } 
}

	/* 개발자 작업  끝 */