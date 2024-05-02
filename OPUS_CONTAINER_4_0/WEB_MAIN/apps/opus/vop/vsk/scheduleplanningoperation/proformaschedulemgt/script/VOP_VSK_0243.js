/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0243.js
*@FileTitle  : EOTP 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	   	/* 개발자 작업	*/
	 // 공통전역변수
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	 document.onclick=processButtonClick;
	 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick(){
	      /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	      var sheetObject1=sheetObjects[0];
	      var sheetObject2=sheetObjects[1];
	      var sheetObject3=sheetObjects[2];
	      var sheetObject4=sheetObjects[3];
	      /*******************************************************/
	      var formObject=document.form;
	 	try {
	 		var srcName=ComGetEvent("name");
	        if (!ComIsBtnEnable(srcName)) return;  
			//if(ComGetBtnDisable(srcName)) return false;
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
			}
	 	} catch(e) {
	 		if( e == "[object Error]") {
	 			ComShowCodeMessage('VSK00011');
	 		} else {
	 			ComShowMessage(e.message);
	 		}
	 	}
	 }
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++]=sheet_obj;
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
		 var formObj=document.form;
		 var parentObj=getParent(0);
		 var sXml=ComMakeSearchXml(parentObj, false, "sheet1_hiddencheck","sheet1_vsl_slan_cd|sheet1_pf_svc_tp_cd|sheet1_slan_stnd_flg|sheet1_svc_dur_dys|sheet1_stnd_svc_spd|sheet1_brth_itval_dys|sheet1_mml_usd_flg|sheet1_sim_dt|sheet1_sim_no|sheet1_n1st_vsl_clss_cd|sheet1_n1st_vsl_clss_knt|sheet1_n2nd_vsl_clss_cd|sheet1_n2nd_vsl_clss_knt|sheet1_n3rd_vsl_clss_cd|sheet1_n3rd_vsl_clss_knt|sheet1_clpt_knt|sheet1_ttl_dist|sheet1_max_spd|sheet1_avg_spd|sheet1_delt_flg|sheet1_pf_skd_rmk", false);
		 sheetObjects[0].LoadSearchData(sXml,{Append:1 , Sync:0} );
		 var prefix="sheet1_";
		 var classCount=0;
		 formObj.n1st_vsl_clss_cd.value=sheetObjects[0].GetCellValue(1,prefix+"n1st_vsl_clss_cd");
		 classCount=sheetObjects[0].GetCellValue(1,prefix+"n1st_vsl_clss_knt");
		 if (classCount == 0) {	 
			 formObj.n1st_vsl_clss_knt.value="";
	 	 }else {
			 formObj.n1st_vsl_clss_knt.value=classCount;
		 }
		 formObj.n2nd_vsl_clss_cd.value=sheetObjects[0].GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
		 classCount=sheetObjects[0].GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
		 if (classCount == 0) {	 
			 formObj.n2nd_vsl_clss_knt.value="";
	 	 }else {
			 formObj.n2nd_vsl_clss_knt.value=classCount;
		 }
		 formObj.n3rd_vsl_clss_cd.value=sheetObjects[0].GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
		 classCount=sheetObjects[0].GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
		 if (classCount == 0) {	 
			 formObj.n3rd_vsl_clss_knt.value="";
	 	 }else {
			 formObj.n3rd_vsl_clss_knt.value=classCount;
		 }
	 }
	 function parentPfSkdDetail(){
		 var parentObj=getParent(1);
		 var sXml=ComMakeSearchXml(parentObj, false, "sheet2_hiddencheck","sheet2_ibflag|sheet2_skd_dir_cd|sheet2_port_cd|sheet2_yd_cd|sheet2_zd|sheet2_etb_dy_no|sheet2_etb_dy_cd|sheet2_etb_tm_hrmnt|sheet2_etd_dy_no|sheet2_etd_dy_cd|sheet2_etd_tm_hrmnt|sheet2_lnk_dist|sheet2_lnk_spd|sheet2_tztm_hrs|sheet2_sea_buf_hrs|sheet2_sea_buf_spd|sheet2_mnvr_in_hrs|sheet2_mnvr_out_hrs|sheet2_act_wrk_hrs|sheet2_port_buf_hrs|sheet2_ib_ipcgo_qty|sheet2_ob_ipcgo_qty|sheet2_ib_ocn_cgo_qty|sheet2_ob_ocn_cgo_qty|sheet2_tml_prod_qty|sheet2_crn_knt|sheet2_turn_port_flg|sheet2_turn_port_ind_cd|sheet2_vsl_slan_cd|sheet2_pf_svc_tp_cd", false);
		 sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:0} );
	 } 
	 /**
	 * 부모창의 활성화된 Sheet 정보를 가져온다.
	 * @return
	 */
	function getParent(idx){
		var opener=window.dialogArguments;
		if (!opener)
			opener = parent;
		if(opener.sheetObjects){
			if(opener.sheetObjects.length > 0){
				return opener.sheetObjects[idx];
			}
		}
		return opener.sheetObjects[idx];
	}
	  /**
	  * 시트 초기설정값, 헤더 정의
	  * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	  * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	  */
	 function initSheet(sheetObj,sheetNo) {
	     var cnt=0;
		 var sheetId=sheetObj.id;
	     switch(sheetId) {
	     case "sheet1":      //sheet1 init
	    	    with(sheetObj){
			       var HeadTitle="STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK";
			       var headCount=ComCountHeadTitle(HeadTitle);
			       var prefix="sheet1_";
			       SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
			       var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			       var headers = [ { Text:HeadTitle, Align:"Center"} ];
			       InitHeaders(headers, info);
			       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"stnd_svc_spd",      KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_itval_dys",    KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mml_usd_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_no",            KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_knt",          KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dist",          KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"max_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"" },
			              {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_skd_rmk",        KeyField:0,   CalcLogic:"",   Format:"" } ];
			       InitColumns(cols);
			       SetEditable(0);
			       SetWaitImageVisible(0);
			       SetVisible(0);
	             }
	         break;
	         
	         case "sheet2":      //sheet1 init
	        	    with(sheetObj){
			           var HeadTitle1="|DIR|Port\nCode|TMNL Code|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|Manu.|Manu.|Working\nHour|Port\nBuffer|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|TML Prod.|TML Prod.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
			           var HeadTitle2="|DIR|Port\nCode|TMNL Code|ZD|NO.|DAY|TIME|NO.|DAY|TIME|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|IN|OUT|Working\nHour|Port\nBuffer|IPC|IPC|Ocean|Ocean|.|.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
			           var HeadTitle3="|DIR|Port\nCode|TMNL Code|ZD|NO.|DAY|TIME|NO.|DAY|TIME|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|IN|OUT|Working\nHour|Port\nBuffer|IN|OUT|IN|OUT|.|.|Turning Port\nIndicator(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
			           var headCount=ComCountHeadTitle(HeadTitle1);
			           var prefix="sheet2_";
			           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			           var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			           var headers = [ { Text:HeadTitle1, Align:"Center"},
			                           { Text:HeadTitle2, Align:"Center"},
			                           { Text:HeadTitle3, Align:"Center"} ];
			           InitHeaders(headers, info);
			           var cols = [ {Type:"Status",    Hidden:1, Width:39,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:39,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"zd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etb_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
			                  {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
			                  {Type:"Float",     Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_spd",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Float",     Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                  {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                  {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                  {Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			                  {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
			                  {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1 },
			                  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
			                  {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
			           InitColumns(cols);
			           SetEditable(1);
			           SetCountPosition(0);
			           SetWaitImageVisible(0);
			           SetRowHeight(0,10);
			           SetRowHeight(1,10);
			           SetRowHeight(2,10);
			           SetVisible(0);
	         		}
                 break;
                 
	         case "sheet3":      
	        	    with(sheetObj){
			           var HeadTitle1="Seq.|Port\nCode|TTL\nCount|On-Time|On-Time|EOTP|EOTP|";
			           var HeadTitle2="Seq.|Port\nCode|TTL\nCount|Count|Ratio|Count|Ratio|";
			           var headCount=ComCountHeadTitle(HeadTitle1);
			           var prefix="sheet3_";
			           SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			           var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			           var headers = [ { Text:HeadTitle1, Align:"Center"},
			                           { Text:HeadTitle2, Align:"Center"} ];
			           InitHeaders(headers, info);
			           var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
			                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"portcd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ttl_cnt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"on_tm_cnt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"AutoAvg",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"on_tm_rt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:prefix+"eotp_cnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"AutoAvg",   Hidden:0, Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix+"eotp_rt01", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			                  {Type:"AutoAvg",   Hidden:0, Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix+"eotp_rt02", KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 } ];
			           InitColumns(cols);
			           SetEditable(0);
			           SetWaitImageVisible(0);
			           SetRowHeight(0,20);
			           SetRowHeight(1,20);
			           SetColHidden(prefix+"eotp_rt02",1);
			           SetSheetHeight(400);
	           		}
             	break;
	         case "sheet4":      
	        	    with(sheetObj){
			           var HeadTitle1="Seq.\n|On-time\n(Y/N)|VSL\nCLS\n|VVD|Old\nPort Time|New Port Time|New Port Time|New Sea Time|New Sea Time|Act.\nSea Time|Dist.|Max.\nSpeed\n|Act.\nSp'd\n|MRT|EOTP1|EOTP1-Result|EOPT2|EOTP2-Result";
			           var HeadTitle2="Seq.\n|On-time\n(Y/N)|VSL\nCLS\n|VVD|Old\nPort Time|Port|Buf.|Sea|Buf.|Act.\nSea Time|Dist.|Max.\nSpeed\n|Act.\nSp'd\n|MRT|EOTP1|EOTP1-Result|EOPT2|EOTP2-Result";
			           var prefix="sheet4_";
			           SetConfig( { SearchMode:2, FrozenCol: ColSaveName(prefix+"old_port_tm"), MergeSheet:5, Page:20, DataRowMerge:1 } );
			           var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			           var headers = [ { Text:HeadTitle1, Align:"Center"},
			                           { Text:HeadTitle2, Align:"Center"} ];
			           InitHeaders(headers, info);
			           var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq" },
			                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"on_tm_yn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_class",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+"old_port_tm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"new_port_tm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"new_port_buf_tm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix+"new_sea_tm1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:prefix+"new_sea_buf_tm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_sail_tm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"max_spd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:47,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_spd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"recovery_tm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:43,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_eotp01",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eotp01",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_eotp02",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			                  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"eotp02",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			           InitColumns(cols);
			           SetEditable(0);
			           SetWaitImageVisible(0);
			           SetRowHeight(0,20);
			           SetRowHeight(1,20);
			           FrozenCols=SaveNameCol(prefix+"old_port_tm");
			           SetSheetHeight(400);
 					}
             	break; 
	     }
	 }
	   // Sheet관련 프로세스 처리
	 function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
	     switch(sAction) {
	        case IBSEARCH:      //조회
	        	sheetObjects[0].SetRowStatus(1,"U");
	        	for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
	        		sheetObjects[1].SetRowStatus(i,"U");
				}
	        	ComOpenWait(true);
	        	formObj.f_cmd.value=SEARCH;
	        	var SaveStr=ComGetSaveString(sheetObjects);
	        	var aryPrefix=new Array("sheet3_", "sheet4_");
	        	var sXml=sheetObj.GetSaveData("VOP_VSK_0243GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	var arrXml=sXml.split("|$$|");
		     	for(var inx=0; inx<arrXml.length; inx++){
					showSheetData(sheetObjects[2+inx],formObj,arrXml[inx]);
				}
		     	ComOpenWait(false);
	            break;
			 case SEARCH02:        
				 sheetObjects[0].SetRowStatus(1,"U");
				for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
					sheetObjects[1].SetRowStatus(i,"U");
				}
				ComOpenWait(true);
	        	formObj.f_cmd.value=SEARCH02;
	        	var SaveStr=ComGetSaveString(sheetObjects);
	        	var aryPrefix=new Array("sheet4_");
	        	var sXml=sheetObj.GetSaveData("VOP_VSK_0243GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
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
		var prefix=sheetObj.id + "_";
		switch(sheetObj.id){
			case "sheet3":
				sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				formObj.eotp01.value=sheetObj.GetSumValue(0,6)+"%";
				formObj.eotp02.value=sheetObj.GetSumValue(0,7)+"%";
				sheetObj.RenderSheet(1);
			break;
			case "sheet4":
				sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				var grayColor="#NANNANNAN";
				for(var k=2; k < sheetObj.RowCount()+2; k++){
					// 회복시간 = Null 일 경우 회색 처리.
					if(sheetObj.GetCellValue(k, prefix+"recovery_tm") == "" ){
						sheetObj.SetCellBackColor(k, prefix+"recovery_tm",grayColor);
					}
					// Max speed = Null 일 경우 회색 처리.
					if(sheetObj.GetCellValue(k, prefix+"max_spd") == "" ){
						sheetObj.SetCellBackColor(k, prefix+"max_spd",grayColor);
					}
					// Actual speed = Null 일 경우 회색 처리.
					if(sheetObj.GetCellValue(k, prefix+"act_spd") == "" ){
						sheetObj.SetCellBackColor(k, prefix+"act_spd",grayColor);
					}
	       	 	}
				sheetObj.RenderSheet(1);
			break;
		}
	} 
	function sheet3_OnDblClick(sheetObj,Row,Col){
		var rowIdx=sheetObj.GetSelectRow()+ sheetObj.HeaderRows();
		var ttlCount=sheetObj.GetCellValue(Row,"sheet3_ttl_cnt");
		var formObj=document.form;
		if(rowIdx){
			if(rowIdx > sheetObj.HeaderRows()){
				if(ttlCount > 0){
					formObj.eventNav.value=Row - sheetObj.HeaderRows();
					formObj.portNm.value=sheetObj.GetCellValue(Row,"sheet3_portcd");
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
		var cnt=sheetObjects[2].RowCount();
		if(cnt < 1){
			ComShowCodeMessage("VSK00043");
		}
		var eotpVal1=formObj.eotp01.value;
		var eotpVal2=formObj.eotp02.value;
		var opener=window.dialogArguments;
		if (!opener)
			opener = parent;
		if(eotpVal1 == ""){
			eotpVal1="0%";
		}
		if(eotpVal2 == ""){
			eotpVal2="0%";
		}
		opener.document.form.eotp1.value=eotpVal1;
		opener.document.form.eotp2.value=eotpVal2;
		ComClosePopup(); 
	}
	function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
	    if(sheetObj.RowCount()> 0){
	    	//마우스 위치를 행과 컬럼과 값 가져오기
	        var Row=sheetObj.MouseRow();
	        var Col=sheetObj.MouseCol();
	        var prefix=sheetObj.id+"_";
	        // sheet4에서 풍선도움말 사용.
	        if (Row < 2) {	
	        } else {
	        }
	        if (Row == 0 || Row == 1) {
	        	if (Col == 14) {
	        		sheetObj.SetMousePointer("Hand");
	        	} else if (Col == 16) {
	            	sheetObj.SetMousePointer("Hand");
	        	}
	        }
	        else if( Row > 1 && Col == 14){
		        var sText=sheetObj.GetCellText(Row, "sheet4_eotp01");
		        if(sText != ""){
		        	sheetObj.SetMousePointer("Hand");
		        }else{
		            sheetObj.SetMousePointer("Default");
		        }       	
	        } else if (Row > 1 && Col == 16)
	        {
	        	var sText=sheetObj.GetCellText(Row, "sheet4_eotp02");
	 	        if(sText != ""){
	 	        	sheetObj.SetMousePointer("Hand");
	 	        }else{
	 	            sheetObj.SetMousePointer("Default");
	 	        }
	        } else {
		        sheetObj.SetMousePointer("Default");
	        }
	    } 
	}
	/* 개발자 작업  끝 */