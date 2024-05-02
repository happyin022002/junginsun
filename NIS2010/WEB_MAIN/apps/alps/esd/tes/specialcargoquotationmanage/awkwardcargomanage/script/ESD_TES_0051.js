/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_0051.js
*@FileTitle : AWK Cargo Basic Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.04
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.02.04 이혜민
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
     * @author SM LINE
     */

    /**
	 * @extends
	 * @class ESD_TES_0051 : ESD_TES_0051 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function ESD_TES_0051() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.setComboObject			= setComboObject;
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var comboObjects = new Array();
    var comboCnt = 0;     

    var tabNowCnt = 0;
    
    var currCd = "";
	
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){

		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];

        /** **************************************************** */
        var formObject = document.form;
		var objs = document.all.item("tabLayer");
		var yd_cd = "";
		var io_bnd_cd = "";
		var io_ga_cd = "";
		var tml_awk_ts_cd = "";
         
    	try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Calendar":
					if( objs[0].style.display == "inline" || objs[1].style.display == "inline" ){
						var cal = new ComCalendar();
						cal.setDisplayType('month');
						cal.select(formObject.year_month, 'yyyy-MM');
					}
					break;
				
				case "btn_Retrieve":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);   // tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSEARCH);   // tab2
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSEARCH);   // tab3
					}
					break;
					
				case "btn_Save":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBSAVE);    // tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBSAVE);   // tab2
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBSAVE);   // tab3
					}
					break;
					
				case "btn_New":
					if( objs[0].style.display == "inline" ){
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);   // tab1
					}else if( objs[1].style.display == "inline" ){
						doActionIBSheet(sheetObject2,formObject,IBCLEAR);   // tab2
					}else if( objs[2].style.display == "inline" ){
						doActionIBSheet(sheetObject3,formObject,IBCLEAR);   // tab3
					}
					break;
					
				case "btn_His":
					if( objs[0].style.display == "inline" ){
						var selcRow = sheetObject1.SelectRow;
						var port_cd = sheetObject1.CellValue(selcRow, "t1sheet1_port_cd");
						var tml_cd = sheetObject1.CellValue(selcRow, "t1sheet1_tml_cd");
						var tml_awk_ts_cd = sheetObject1.CellValue(selcRow, "t1sheet1_tml_awk_ts_cd");
						var io_bnd_cd = sheetObject1.CellValue(selcRow, "t1sheet1_io_bnd_cd");
						var io_ga_cd = sheetObject1.CellValue(selcRow, "t1sheet1_io_ga_cd");
						var cond_no = sheetObject1.CellValue(selcRow, "t1sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_0052.do?tml_awk_cgo_trf_tp_cd=B&port_cd="+port_cd+"&tml_cd="+tml_cd+"&tml_awk_ts_cd="+tml_awk_ts_cd+"&io_bnd_cd="+io_bnd_cd+"&io_ga_cd="+io_ga_cd+"&cond_no="+cond_no;
						ComOpenPopupWithTarget(sUrl, 1020, 575, "", "0,0", true);
					}else if( objs[1].style.display == "inline" ){
						var selcRow = sheetObject2.SelectRow;	
						var port_cd = sheetObject2.CellValue(selcRow, "t2sheet1_port_cd");
						var tml_cd = sheetObject2.CellValue(selcRow, "t2sheet1_tml_cd");
						var tml_awk_ts_cd = sheetObject2.CellValue(selcRow, "t2sheet1_tml_awk_ts_cd");
						var io_bnd_cd = sheetObject2.CellValue(selcRow, "t2sheet1_io_bnd_cd");
						var io_ga_cd = sheetObject2.CellValue(selcRow, "t2sheet1_io_ga_cd");
						var cond_no = sheetObject2.CellValue(selcRow, "t2sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_0053.do?tml_awk_cgo_trf_tp_cd=T&port_cd="+port_cd+"&tml_cd="+tml_cd+"&tml_awk_ts_cd="+tml_awk_ts_cd+"&io_bnd_cd="+io_bnd_cd+"&io_ga_cd="+io_ga_cd+"&cond_no="+cond_no;
						ComOpenPopupWithTarget(sUrl, 1020, 575, "", "0,0", true);
					}else if( objs[2].style.display == "inline" ){
						var selcRow = sheetObject3.SelectRow;	
						var fm_loc_cd = sheetObject3.CellValue(selcRow, "t3sheet1_fm_loc_cd");
						var fm_nod_yd_no = sheetObject3.CellValue(selcRow, "t3sheet1_fm_nod_yd_no");
						var to_loc_cd = sheetObject3.CellValue(selcRow, "t3sheet1_to_loc_cd");
						var to_nod_yd_no = sheetObject3.CellValue(selcRow, "t3sheet1_to_nod_yd_no");
						var cond_no = sheetObject3.CellValue(selcRow, "t3sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_0054.do?fm_loc_cd="+fm_loc_cd+"&fm_nod_yd_no="+fm_nod_yd_no+"&to_loc_cd="+to_loc_cd+"&to_nod_yd_no="+to_nod_yd_no+"&cond_no="+cond_no;
						ComOpenPopupWithTarget(sUrl, 1020, 575, "", "0,0", true);
					}
					break;	

				case "btn_port":	//Location 조회 팝업
					if(formObject.btn_port.className == ""){
						break;
					}					
					var cnt_cd = "";
					var port_cd = formObject.port_cd.value;
			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.port_cd.value = rVal;
					}					
					break;
					
				case "btn_port_fr":	//Location 조회 팝업
					if(formObject.btn_port_fr.className == ""){
						break;
					}					
					var cnt_cd = "";
					var fm_loc_cd = formObject.fm_loc_cd.value;
			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.fm_loc_cd.value = rVal;
					}					
					break;
				
				case "btn_port_to":	//Location 조회 팝업
					if(formObject.btn_port_to.className == ""){
						break;
					}					
					var cnt_cd = "";
					var to_loc_cd = formObject.to_loc_cd.value;
			    	var sUrl = "/hanjin/VOP_VSK_0043.do";
					var rVal = ComOpenPopupWithTarget(sUrl, 422, 520, "", "0,0", true);
					if(rVal){
						formObject.to_loc_cd.value = rVal;
					}					
					break;
				
				case "btn_trfCond":	//tariff condition 조회 팝업	
					var sUrl = "/hanjin/ESD_TES_0057.do?ui_id=ESD_TES_0051";
					var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
					if(rVal){
						formObject.cond_desc.value = rVal.cond_desc;
						formObject.cond_no.value = rVal.cond_no;
					}
					break;
					
				case "btn_t3trfCond":	//tab3 tariff condition 조회 팝업	
					var sUrl = "/hanjin/ESD_TES_0057.do?ui_id=ESD_TES_0051";
					var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
					if(rVal){
						formObject.cond_desc_t3.value = rVal.cond_desc;
						formObject.cond_no_t3.value = rVal.cond_no;
					}
					break;
				
				case "btn_Exlup":
					if( objs[0].style.display == "inline" ){
						var selcRow = sheetObject1.SelectRow;
						var port_cd = sheetObject1.CellValue(selcRow, "t1sheet1_port_cd");
						var tml_cd = sheetObject1.CellValue(selcRow, "t1sheet1_tml_cd");
						var tml_awk_ts_cd = sheetObject1.CellValue(selcRow, "t1sheet1_tml_awk_ts_cd");
						var io_bnd_cd = sheetObject1.CellValue(selcRow, "t1sheet1_io_bnd_cd");
						var io_ga_cd = sheetObject1.CellValue(selcRow, "t1sheet1_io_ga_cd");
						var cond_no = sheetObject1.CellValue(selcRow, "t1sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_9052.do";
						ComOpenPopupWithTarget(sUrl, 800, 550, "", "0,0", true);
					}else if( objs[1].style.display == "inline" ){
						var selcRow = sheetObject2.SelectRow;	
						var port_cd = sheetObject2.CellValue(selcRow, "t2sheet1_port_cd");
						var tml_cd = sheetObject2.CellValue(selcRow, "t2sheet1_tml_cd");
						var tml_awk_ts_cd = sheetObject2.CellValue(selcRow, "t2sheet1_tml_awk_ts_cd");
						var io_bnd_cd = sheetObject2.CellValue(selcRow, "t2sheet1_io_bnd_cd");
						var io_ga_cd = sheetObject2.CellValue(selcRow, "t2sheet1_io_ga_cd");
						var cond_no = sheetObject2.CellValue(selcRow, "t2sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_9053.do";
						ComOpenPopupWithTarget(sUrl, 800, 550, "", "0,0", true);
					}else if( objs[2].style.display == "inline" ){
						var selcRow = sheetObject3.SelectRow;	
						var fm_loc_cd = sheetObject3.CellValue(selcRow, "t3sheet1_fm_loc_cd");
						var fm_nod_yd_no = sheetObject3.CellValue(selcRow, "t3sheet1_fm_nod_yd_no");
						var to_loc_cd = sheetObject3.CellValue(selcRow, "t3sheet1_to_loc_cd");
						var to_nod_yd_no = sheetObject3.CellValue(selcRow, "t3sheet1_to_nod_yd_no");
						var cond_no = sheetObject3.CellValue(selcRow, "t3sheet1_cond_no");
						var sUrl = "/hanjin/ESD_TES_9051.do";
						ComOpenPopupWithTarget(sUrl, 800, 550, "", "0,0", true);
					}
					break;
					
				/** TAB 1 * */
				case "btn_t1rowadd":
					var prefix = "t1sheet1_";
					var Row = sheetObject1.DataInsert();
					sheetObject1.CellEditable(Row, prefix+"chk_flg") = true;
					sheetObject1.CellEditable(Row, prefix+"port_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"tml_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"io_bnd_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"mn_yd_flg") = true;
					sheetObject1.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
					sheetObject1.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
					sheetObject1.CellEditable(Row, prefix+"ttl_locl_curr_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"ttl_locl_amt_20ft") = true;
					sheetObject1.CellEditable(Row, prefix+"ttl_locl_amt_40ft") = true;
					sheetObject1.CellEditable(Row, prefix+"aply_rto") = true;
					sheetObject1.CellEditable(Row, prefix+"fml_locl_curr_cd") = true;
					sheetObject1.CellEditable(Row, prefix+"fml_locl_amt_20ft") = true;
					sheetObject1.CellEditable(Row, prefix+"fml_locl_amt_40ft") = true;
					sheetObject1.CellEditable(Row, prefix+"cond_desc") = true;
					
					sheetObject1.CellValue2(Row, prefix+"tml_awk_cgo_trf_tp_cd") = "B";
					sheetObject1.CellValue2(Row, prefix+"cond_no") = "0";
					sheetObject1.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
					sheetObject1.CellValue2(Row, prefix+"act_yd_ofc_auth_yn") = "Y";
					sheetObject1.InitCellProperty(Row ,prefix+"tml_cd",dtCombo);
					break;

				case "btn_t1rowdelt":
					var prefix = "t1sheet1_";
					if(chkDelt(sheetObject1, formObject)){
						ComRowHideDelete(sheetObject1,prefix+"chk_flg");
					}
					break;
					
				case "btn_t1rowcopy":
					var prefix = "t1sheet1_";
					var selcRow = sheetObject1.SelectRow;
					if(sheetObject1.CellValue(selcRow, prefix+"act_yd_ofc_auth_yn") == "N" || sheetObject1.CellValue(selcRow, prefix+"chk_auth_yn") == "N"){
						ComShowCodeMessage('TES90105'); //No authority to Row copy.
					}else{
						var Row = sheetObject1.DataInsert();
						sheetObject1.CellValue2(Row, prefix+"port_cd") = sheetObject1.CellValue(selcRow, prefix+"port_cd");
						sheetObject1.CellValue2(Row, prefix+"tml_cd") = sheetObject1.CellValue(selcRow, prefix+"tml_cd");
						sheetObject1.CellValue2(Row, prefix+"io_bnd_cd") = sheetObject1.CellValue(selcRow, prefix+"io_bnd_cd");
						sheetObject1.CellValue2(Row, prefix+"mn_yd_flg") = sheetObject1.CellValue(selcRow, prefix+"mn_yd_flg");
						sheetObject1.CellValue2(Row, prefix+"io_ga_cd") =sheetObject1.CellValue(selcRow, prefix+"io_ga_cd");
						sheetObject1.CellValue2(Row, prefix+"yd_cd") =sheetObject1.CellValue(selcRow, prefix+"yd_cd");
						sheetObject1.CellValue2(Row, prefix+"tml_awk_ts_cd") = sheetObject1.CellValue(selcRow, prefix+"tml_awk_ts_cd");
						sheetObject1.CellValue2(Row, prefix+"man_locl_curr_cd") = sheetObject1.CellValue(selcRow, prefix+"man_locl_curr_cd");
						sheetObject1.CellValue2(Row, prefix+"man_locl_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"man_locl_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"man_locl_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"man_locl_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"man_usd_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"man_usd_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"man_usd_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"man_usd_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"auto_usd_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"auto_usd_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"auto_usd_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"auto_usd_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"ttl_locl_curr_cd") = sheetObject1.CellValue(selcRow, prefix+"ttl_locl_curr_cd");
						sheetObject1.CellValue2(Row, prefix+"ttl_locl_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"ttl_locl_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"ttl_locl_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"ttl_locl_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"ttl_usd_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"ttl_usd_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"ttl_usd_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"ttl_usd_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"aply_rto") = sheetObject1.CellValue(selcRow, prefix+"aply_rto");
						sheetObject1.CellValue2(Row, prefix+"fml_locl_curr_cd") = sheetObject1.CellValue(selcRow, prefix+"fml_locl_curr_cd");
						sheetObject1.CellValue2(Row, prefix+"fml_locl_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"fml_locl_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"fml_locl_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"fml_locl_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"fml_usd_amt_20ft") = sheetObject1.CellValue(selcRow, prefix+"fml_usd_amt_20ft");
						sheetObject1.CellValue2(Row, prefix+"fml_usd_amt_40ft") = sheetObject1.CellValue(selcRow, prefix+"fml_usd_amt_40ft");
						sheetObject1.CellValue2(Row, prefix+"cond_desc") = sheetObject1.CellValue(selcRow, prefix+"cond_desc");
						sheetObject1.CellValue2(Row, prefix+"cond_no") = sheetObject1.CellValue(selcRow, prefix+"cond_no");
						sheetObject1.CellValue2(Row, prefix+"calc_rmk") = sheetObject1.CellValue(selcRow, prefix+"calc_rmk");
						sheetObject1.CellValue2(Row, prefix+"usd_xch_dt") = sheetObject1.CellValue(selcRow, prefix+"usd_xch_dt");
						sheetObject1.CellValue2(Row, prefix+"ibflag") = "I";
						sheetObject1.CellValue2(Row, prefix+"tml_awk_cgo_trf_tp_cd") = "B";
						sheetObject1.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
						sheetObject1.CellValue2(Row, prefix+"act_yd_ofc_auth_yn") = "Y";
						sheetObject1.CellEditable(Row, prefix+"chk_flg") = true;
						sheetObject1.CellEditable(Row, prefix+"port_cd") = true;
						sheetObject1.CellEditable(Row, prefix+"tml_cd") = true;
						sheetObject1.InitCellProperty(Row ,prefix+"tml_cd",dtCombo);
						sheetObject1.CellEditable(Row, prefix+"io_bnd_cd") = true;
						sheetObject1.CellEditable(Row, prefix+"mn_yd_flg") = true;
						sheetObject1.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
						sheetObject1.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
						sheetObject1.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
						sheetObject1.CellEditable(Row, prefix+"ttl_locl_curr_cd") = true;
						sheetObject1.CellEditable(Row, prefix+"ttl_locl_amt_20ft") = true;
						sheetObject1.CellEditable(Row, prefix+"ttl_locl_amt_40ft") = true;
						sheetObject1.CellEditable(Row, prefix+"aply_rto") = true;
						sheetObject1.CellEditable(Row, prefix+"fml_locl_curr_cd") = true;
						sheetObject1.CellEditable(Row, prefix+"fml_locl_amt_20ft") = true;
						sheetObject1.CellEditable(Row, prefix+"fml_locl_amt_40ft") = true;
						sheetObject1.CellEditable(Row, prefix+"cond_desc") = true;
					}
					break;
					
				case "btn_t1calc":
					t1sheet1_calcAppExtCost(sheetObject1);
					break;	
				
				case "btn_t1exlform":
					downform1.submit();
					
					break;
				
				/** TAB 2 * */
				case "btn_t2rowadd":
					var prefix = "t2sheet1_";
					var Row = sheetObject2.DataInsert();
					sheetObject2.CellEditable(Row, prefix+"chk_flg") = true;
					sheetObject2.CellEditable(Row, prefix+"port_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"tml_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"io_bnd_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"tml_awk_ts_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"io_ga_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
					sheetObject2.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
					sheetObject2.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
					sheetObject2.CellEditable(Row, prefix+"cond_desc") = true;
					
					sheetObject2.CellValue2(Row, prefix+"tml_awk_cgo_trf_tp_cd") = "T";
					sheetObject2.CellValue2(Row, prefix+"cond_no") = "0";
					sheetObject2.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
					sheetObject2.CellValue2(Row, prefix+"act_yd_ofc_auth_yn") = "Y";
					sheetObject2.InitCellProperty(Row ,prefix+"tml_cd",dtCombo);
					break;
		
				case "btn_t2rowdelt":
					var prefix = "t2sheet1_";
					if(chkDelt(sheetObject2, formObject)){
						ComRowHideDelete(sheetObject2,prefix+"chk_flg");
					}
					break;
					
				case "btn_t2rowcopy":
					var prefix = "t2sheet1_";
					var selcRow = sheetObject2.SelectRow;
					if(sheetObject2.CellValue(selcRow, prefix+"act_yd_ofc_auth_yn") == "N" || sheetObject2.CellValue(selcRow, prefix+"chk_auth_yn") == "N"){
						ComShowCodeMessage('TES90105'); //No authority to Row copy.
					}else if(sheetObject2.CellValue(selcRow, prefix+"tml_awk_ts_cd") == "A" && sheetObject2.CellValue(selcRow, prefix+"io_bnd_cd") == "A" && sheetObject2.CellValue(selcRow, prefix+"io_ga_cd") == "A"){
						ComShowCodeMessage('TES90118'); //Default Data can't be copied.
					}else{
						var Row = sheetObject2.DataInsert();
						sheetObject2.CellValue2(Row, prefix+"port_cd") = sheetObject2.CellValue(selcRow, prefix+"port_cd");
						sheetObject2.CellValue2(Row, prefix+"tml_cd") = sheetObject2.CellValue(selcRow, prefix+"tml_cd");
						sheetObject2.CellValue2(Row, prefix+"io_bnd_cd") = sheetObject2.CellValue(selcRow, prefix+"io_bnd_cd");
						sheetObject2.CellValue2(Row, prefix+"io_ga_cd") =sheetObject2.CellValue(selcRow, prefix+"io_ga_cd");
						sheetObject2.CellValue2(Row, prefix+"yd_cd") =sheetObject2.CellValue(selcRow, prefix+"yd_cd");
						sheetObject2.CellValue2(Row, prefix+"tml_awk_ts_cd") = sheetObject2.CellValue(selcRow, prefix+"tml_awk_ts_cd");
						sheetObject2.CellValue2(Row, prefix+"man_locl_curr_cd") = sheetObject2.CellValue(selcRow, prefix+"man_locl_curr_cd");
						sheetObject2.CellValue2(Row, prefix+"man_locl_amt_20ft") = sheetObject2.CellValue(selcRow, prefix+"man_locl_amt_20ft");
						sheetObject2.CellValue2(Row, prefix+"man_locl_amt_40ft") = sheetObject2.CellValue(selcRow, prefix+"man_locl_amt_40ft");
						sheetObject2.CellValue2(Row, prefix+"man_usd_amt_20ft") = sheetObject2.CellValue(selcRow, prefix+"man_usd_amt_20ft");
						sheetObject2.CellValue2(Row, prefix+"man_usd_amt_40ft") = sheetObject2.CellValue(selcRow, prefix+"man_usd_amt_40ft");
						sheetObject2.CellValue2(Row, prefix+"auto_usd_amt_20ft") = sheetObject2.CellValue(selcRow, prefix+"auto_usd_amt_20ft");
						sheetObject2.CellValue2(Row, prefix+"auto_usd_amt_40ft") = sheetObject2.CellValue(selcRow, prefix+"auto_usd_amt_40ft");
						sheetObject2.CellValue2(Row, prefix+"sum_usd_amt_20ft") = sheetObject2.CellValue(selcRow, prefix+"sum_usd_amt_20ft");
						sheetObject2.CellValue2(Row, prefix+"sum_usd_amt_40ft") = sheetObject2.CellValue(selcRow, prefix+"sum_usd_amt_40ft");
						sheetObject2.CellValue2(Row, prefix+"cond_desc") = sheetObject2.CellValue(selcRow, prefix+"cond_desc");
						sheetObject2.CellValue2(Row, prefix+"cond_no") = sheetObject2.CellValue(selcRow, prefix+"cond_no");
						sheetObject2.CellValue2(Row, prefix+"calc_rmk") = sheetObject2.CellValue(selcRow, prefix+"calc_rmk");
						sheetObject2.CellValue2(Row, prefix+"usd_xch_dt") = sheetObject2.CellValue(selcRow, prefix+"usd_xch_dt");
						sheetObject2.CellValue2(Row, prefix+"tml_awk_cgo_trf_tp_cd") = "T";
						sheetObject2.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
						sheetObject2.CellValue2(Row, prefix+"act_yd_ofc_auth_yn") = "Y";
						sheetObject2.CellValue2(Row, prefix+"ibflag") = "I";
						sheetObject2.CellEditable(Row, prefix+"chk_flg") = true;
						sheetObject2.CellEditable(Row, prefix+"port_cd") = true;
						sheetObject2.CellEditable(Row, prefix+"tml_cd") = true;
						sheetObject2.InitCellProperty(Row ,prefix+"tml_cd",dtCombo);
						sheetObject2.CellEditable(Row, prefix+"io_bnd_cd") = true;
						sheetObject2.CellEditable(Row, prefix+"tml_awk_ts_cd") = true;
						sheetObject2.CellEditable(Row, prefix+"io_ga_cd") = true;
						sheetObject2.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
						sheetObject2.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
						sheetObject2.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
						sheetObject2.CellEditable(Row, prefix+"cond_desc") = true;
					}
					break;	
				
				case "btn_t2exlform":
					downform2.submit();
					
					break;
					
				/** TAB 3 * */
				case "btn_t3rowadd":
					var prefix = "t3sheet1_";
					var Row = sheetObject3.DataInsert();
					sheetObject3.CellEditable(Row, prefix+"chk_flg") = true;
					sheetObject3.CellEditable(Row, prefix+"fm_loc_cd") = true;
					sheetObject3.CellEditable(Row, prefix+"fm_nod_yd_no") = true;
					sheetObject3.CellEditable(Row, prefix+"to_loc_cd") = true;
					sheetObject3.CellEditable(Row, prefix+"to_nod_yd_no") = true;
					sheetObject3.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
					sheetObject3.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
					sheetObject3.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
					sheetObject3.CellEditable(Row, prefix+"vndr_nm") = true;
					sheetObject3.CellEditable(Row, prefix+"cond_desc") = true;
					
					sheetObject3.CellValue2(Row, prefix+"cond_no") = "0";
					sheetObject3.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
					sheetObject3.InitCellProperty(Row , prefix+"fm_nod_yd_no", dtCombo);
					sheetObject3.InitCellProperty(Row , prefix+"to_nod_yd_no", dtCombo);
					break;
			
				case "btn_t3rowdelt":
					var prefix = "t3sheet1_";
					if(chkDeltAddOn(sheetObject3, formObject)){
						ComRowHideDelete(sheetObject3,prefix+"chk_flg");
					}
					break;
				
				case "btn_t3rowcopy":
					var prefix = "t3sheet1_";
					var selcRow = sheetObject3.SelectRow;
					if(sheetObject3.CellValue(selcRow, prefix+"chk_auth_yn") == "N"){
						ComShowCodeMessage('TES90105'); //No authority to Row copy.
					}else{
						var Row = sheetObject3.DataInsert();
						sheetObject3.CellValue2(Row, prefix+"fm_loc_cd") = sheetObject3.CellValue(selcRow, prefix+"fm_loc_cd");
						sheetObject3.CellValue2(Row, prefix+"fm_nod_yd_no") = sheetObject3.CellValue(selcRow, prefix+"fm_nod_yd_no");
						sheetObject3.CellValue2(Row, prefix+"to_loc_cd") = sheetObject3.CellValue(selcRow, prefix+"to_loc_cd");
						sheetObject3.CellValue2(Row, prefix+"to_nod_yd_no") = sheetObject3.CellValue(selcRow, prefix+"to_nod_yd_no");
						sheetObject3.CellValue2(Row, prefix+"man_locl_curr_cd") = sheetObject3.CellValue(selcRow, prefix+"man_locl_curr_cd");
						sheetObject3.CellValue2(Row, prefix+"man_locl_amt_20ft") = sheetObject3.CellValue(selcRow, prefix+"man_locl_amt_20ft");
						sheetObject3.CellValue2(Row, prefix+"man_locl_amt_40ft") = sheetObject3.CellValue(selcRow, prefix+"man_locl_amt_40ft");
						sheetObject3.CellValue2(Row, prefix+"man_usd_amt_20ft") = sheetObject3.CellValue(selcRow, prefix+"man_usd_amt_20ft");
						sheetObject3.CellValue2(Row, prefix+"man_usd_amt_40ft") = sheetObject3.CellValue(selcRow, prefix+"man_usd_amt_40ft");
						sheetObject3.CellValue2(Row, prefix+"calc_rmk") = sheetObject3.CellValue(selcRow, prefix+"calc_rmk");
						sheetObject3.CellValue2(Row, prefix+"usd_xch_dt") = sheetObject3.CellValue(selcRow, prefix+"usd_xch_dt");
						sheetObject3.CellValue2(Row, prefix+"vndr_nm") = sheetObject3.CellValue(selcRow, prefix+"vndr_nm");
						sheetObject3.CellValue2(Row, prefix+"cond_desc") = sheetObject3.CellValue(selcRow, prefix+"cond_desc");
						sheetObject3.CellValue2(Row, prefix+"cond_no") = sheetObject3.CellValue(selcRow, prefix+"cond_no");
						sheetObject3.CellValue2(Row, prefix+"chk_auth_yn") = "Y";
						sheetObject3.CellValue2(Row, prefix+"ibflag") = "I";

						sheetObject3.CellEditable(Row, prefix+"chk_flg") = true;
						sheetObject3.CellEditable(Row, prefix+"fm_loc_cd") = true;
						sheetObject3.CellEditable(Row, prefix+"fm_nod_yd_no") = true;
						sheetObject3.CellEditable(Row, prefix+"to_loc_cd") = true;
						sheetObject3.CellEditable(Row, prefix+"to_nod_yd_no") = true;
						sheetObject3.InitCellProperty(Row , prefix+"fm_nod_yd_no", dtCombo);
						sheetObject3.InitCellProperty(Row , prefix+"to_nod_yd_no", dtCombo);
						sheetObject3.CellEditable(Row, prefix+"man_locl_curr_cd") = true;
						sheetObject3.CellEditable(Row, prefix+"man_locl_amt_20ft") = true;
						sheetObject3.CellEditable(Row, prefix+"man_locl_amt_40ft") = true;
						sheetObject3.CellEditable(Row, prefix+"vndr_nm") = true;
						sheetObject3.CellEditable(Row, prefix+"cond_desc") = true;
					}
					break;	
					
				case "btn_t3exlform":
					downform3.submit();
					
					break;
					
			} // end switch		
		}catch(e) {
			if( e == "[object Error]") {
				alert(OBJECT_ERROR);
			} else {
				alert(e);
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
    	var sheetObject1 = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];
 		var sheetObject3 = sheetObjects[2];
 		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            initControl(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
        setYearMonth();
        
        t1sheet1_initCurrCd(sheetObject1);
        t2sheet1_initCurrCd(sheetObject2);
        t3sheet1_initCurrCd(sheetObject3);
    }


     /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;
        switch(sheetID) {
            case "t1sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 390;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "FLAG|chk_auth_yn|tml_awk_cgo_trf_tp_cd||yd|Port|Tmnl\nCD|I/O|Main|||Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (USD)|Unit Cost Manual (USD)|Unit Cost Auto (USD)|Unit Cost Auto (USD)|Total Cost Manual (Local Curr.)|Total Cost Manual (Local Curr.)|Total Cost Manual (Local Curr.)|usd|usd|Formula for Extra Cost (Local Curr.)|Formula for Extra Cost (Local Curr.)|Formula for Extra Cost (Local Curr.)|Formula for Extra Cost (Local Curr.)|usd|usd|Applied Extra Cost (USD)|Applied Extra Cost (USD)|Total Handling Cost (USD)|Total Handling Cost (USD)|Tariff Condition|Tariff Condition|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|tml_act_cost_seq|act_yd_ofc_auth_yn"; 
                    var HeadTitle2 = "FLAG|chk_auth_yn|tml_awk_cgo_trf_tp_cd||yd|Port|Tmnl\nCD|I/O|Main|||Curr|20'|40'|20'|40'|20'|40'|Curr|20'|40'|20|40|Ratio(%)|Curr|20'|40'|20|40|20'|40'|20'|40'|ID|Condition Desc|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|tml_act_cost_seq|act_yd_ofc_auth_yn"; 
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true); 
                                  
                    var prefix="t1sheet1_";
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,	40,		daCenter,	true,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"chk_auth_yn");
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"tml_awk_cgo_trf_tp_cd");
                    InitDataProperty(0, cnt++ , dtCheckBox,		40,	 	daCenter,	true,	prefix+"chk_flg",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"yd_cd");
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,	prefix+"port_cd",			true,		"",	dfEngUpKey,		0,		false,		false, 5);
                    InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	prefix+"tml_cd",			true,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,		45,		daCenter,	true,	prefix+"io_bnd_cd",			true,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCheckBox,		45,		daCenter,	true,	prefix+"mn_yd_flg",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"io_ga_cd",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		35,		daCenter,	true,	prefix+"tml_awk_ts_cd",		false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"man_locl_curr_cd",	false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,	prefix+"man_locl_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,	prefix+"man_locl_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"man_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"man_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"auto_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,	prefix+"auto_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtCombo,		55,		daCenter,	true,	prefix+"ttl_locl_curr_cd",	false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,	prefix+"ttl_locl_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,	prefix+"ttl_locl_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	prefix+"ttl_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtHidden,		75,		daRight,	true,	prefix+"ttl_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,	true,	prefix+"aply_rto",			false,		"",	dfNullInteger,	0,		false,		false, 3);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,	prefix+"fml_locl_curr_cd",	false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			75,	 	daRight,	true,	prefix+"fml_locl_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,	 	daRight,	true,	prefix+"fml_locl_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtHidden,		75,	 	daRight,	true,	prefix+"fml_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtHidden,		75,	 	daRight,	true,	prefix+"fml_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,	 	daRight,	true,	prefix+"calc_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,	 	daRight,	true,	prefix+"calc_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			80,	 	daRight,	true,	prefix+"sum_usd_amt_20ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			80,	 	daRight,	true,	prefix+"sum_usd_amt_40ft",	false,		"",	dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,	prefix+"cond_no",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtPopup,		300,	daLeft,		true,	prefix+"cond_desc",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			115,	daLeft,		true,	prefix+"calc_rmk",			false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			95,	 	daCenter,	true,	prefix+"lst_upd_usr_id",	false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,			85,	 	daCenter,	true,	prefix+"lst_upd_dt",		false,		"",	dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,		85,	 	daCenter,	true,	prefix+"usd_xch_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		45,	 	daCenter,	true,	prefix+"spcl_cgo_ref_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"tml_act_cost_seq");
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,	prefix+"act_yd_ofc_auth_yn");

                    CellValue(2, prefix+"tml_awk_cgo_trf_tp_cd") = "B";
                    InitDataCombo(0, prefix+"io_bnd_cd", "I|O", "I|O");
                    ShowButtonImage = 1;	
                    WaitImageVisible = false;
				}
				break;

            case "t2sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 390;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "FLAG|chk_auth_yn|tml_awk_cgo_trf_tp_cd||yd_cd|Port|Tmnl\nCD|T/S\nType|I/O|IN/OOG|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (USD)|Unit Cost Manual (USD)|Unit Cost Auto (USD)|Unit Cost Auto (USD)|Total Handling Cost (USD)|Total Handling Cost (USD)|Tariff Condition|Tariff Condition|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|tml_act_cost_seq|act_yd_ofc_auth_yn"; 
                    var HeadTitle2 = "FLAG|chk_auth_yn|tml_awk_cgo_trf_tp_cd||yd_cd|Port|Tmnl\nCD|T/S\nType|I/O|IN/OOG|Curr|20'|40'|20'|40'|20'|40'|20'|40'|ID|Condition Desc|Remark|Upd\nUser|Upd\nDate|usd_xch_dt|spcl_cgo_ref_seq|tml_act_cost_seq|act_yd_ofc_auth_yn"; 
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    var prefix="t2sheet1_";
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	true,		prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"chk_auth_yn");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"tml_awk_cgo_trf_tp_cd");
					InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	true,		prefix+"chk_flg",				false,		"",		dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"yd_cd");
                    InitDataProperty(0, cnt++ , dtData,				80,	 	daCenter,	true,		prefix+"port_cd",				true,		"",		dfEngUpKey,		0,		false,		false, 5);
					InitDataProperty(0, cnt++ , dtData,				55,		daCenter,	true,		prefix+"tml_cd",				true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			65,		daCenter,	true,		prefix+"tml_awk_ts_cd",			true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			65,		daCenter,	true,		prefix+"io_bnd_cd",				true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			65,		daCenter,	true,		prefix+"io_ga_cd",				true,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix+"man_locl_curr_cd",		false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				75,		daRight,	true,		prefix+"man_locl_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				75,		daRight,	true,		prefix+"man_locl_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		prefix+"man_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		prefix+"man_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		prefix+"auto_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				70,		daRight,	true,		prefix+"auto_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				80,	 	daRight,	true,		prefix+"sum_usd_amt_20ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				80,	 	daRight,	true,		prefix+"sum_usd_amt_40ft",		false,		"",		dfNullFloat,	2,		false,		false, 15);
                    InitDataProperty(0, cnt++ , dtData,				40,		daCenter,	true,		prefix+"cond_no",				false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtPopup,			300,	daLeft,		true,		prefix+"cond_desc",				false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				185,	daLeft,		true,		prefix+"calc_rmk",				false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				95,		daCenter,	true,		prefix+"lst_upd_usr_id",		false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,				85,		daCenter,	true,		prefix+"lst_upd_dt",			false,		"",		dfNone,			0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,			40,	 	daCenter,	true,		prefix+"usd_xch_dt");
                    InitDataProperty(0, cnt++ , dtHidden,			40,	 	daCenter,	true,		prefix+"spcl_cgo_ref_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"tml_act_cost_seq");
                    InitDataProperty(0, cnt++ , dtHidden,			40,		daCenter,	true,		prefix+"act_yd_ofc_auth_yn");

                    CellValue(2, prefix+"tml_awk_cgo_trf_tp_cd") = "T";
                    InitDataCombo(0, prefix+"io_bnd_cd", "I|O|Default", "I|O|A");
                    InitDataCombo(0, prefix+"tml_awk_ts_cd", "SAME|DIFF|Default", "S|D|A");
                    InitDataCombo(0, prefix+"io_ga_cd", "IN|OOG|Default", "I|O|A");
                    ShowButtonImage = 1;
                    WaitImageVisible = false;
				}
				break;

            case "t3sheet1":
                with (sheetObj) {
										// 높이 설정
                    style.height = 390;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    // Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    // 전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	// 전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    // 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

                    var HeadTitle1 = "FLAG|||FROM|FROM|TO|TO|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (Local Curr.)|Unit Cost Manual (USD)|Unit Cost Manual (USD)|Service Provider|Tariff Condition|Tariff Condition|Remark|Upd User|Upd Date||";
                    var HeadTitle2 = "FLAG|||Port|Tmnl|Port|Tmnl|Curr|20'|40'|20'|40'|Service Provider|ID|Condition Desc|Remark|Upd User|Upd Date||"; 
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    var prefix="t3sheet1_";
                    // 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN, COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	true,		prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix+"chk_auth_yn");
					InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix+"chk_flg",			false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		prefix+"fm_loc_cd",			true,		"",		dfEngUpKey,		0,		false,	false, 5);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"fm_nod_yd_no",		false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daCenter,	true,		prefix+"to_loc_cd",			true,		"",		dfEngUpKey,		0,		false,	false, 5);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix+"to_nod_yd_no",		false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtCombo,		50,		daCenter,	true,		prefix+"man_locl_curr_cd",	false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,		prefix+"man_locl_amt_20ft",	false,		"",		dfNullFloat,	2,		false,	false, 15);
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,	true,		prefix+"man_locl_amt_40ft",	false,		"",		dfNullFloat,	2,		false,	false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,		prefix+"man_usd_amt_20ft",	false,		"",		dfNullFloat,	2,		false,	false, 15);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,	true,		prefix+"man_usd_amt_40ft",	false,		"",		dfNullFloat,	2,		false,	false, 15);
                    InitDataProperty(0, cnt++ , dtData,			130,	daLeft,		true,		prefix+"vndr_nm",			false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix+"cond_no",			false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtPopup,		300,	daLeft,		true,		prefix+"cond_desc",			false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		true,		prefix+"calc_rmk",			false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,		prefix+"lst_upd_usr_id",	false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtData,			85,		daCenter,	true,		prefix+"lst_upd_dt", 		false,		"",		dfNone,			0,		false,	false);
                    InitDataProperty(0, cnt++ , dtHidden,		40,	 	daCenter,	true,		prefix+"usd_xch_dt");
                    InitDataProperty(0, cnt++ , dtHidden,		40,	 	daCenter,	true,		prefix+"spcl_cgo_ref_seq");

                    ShowButtonImage = 1;
                    WaitImageVisible = false;
                }
				break;
        }
    }

    function t1sheet1_initCurrCd(sheetObj){
		var prefix = sheetObj.id + "_";
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH05);
		var currCd  = ComGetEtcData(sXml,"curr_cd");
		currCd = " |" + currCd;
		sheetObj.InitDataCombo(0, prefix+"man_locl_curr_cd", currCd, currCd);
		sheetObj.InitDataCombo(0, prefix+"fml_locl_curr_cd", currCd, currCd);
		sheetObj.InitDataCombo(0, prefix+"ttl_locl_curr_cd", currCd, currCd);
    }
     
	function t2sheet1_initCurrCd(sheetObj){
		var prefix = sheetObj.id + "_";
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH05);
		var currCd  = ComGetEtcData(sXml,"curr_cd");
		currCd = " |" + currCd;
		sheetObj.InitDataCombo(0, prefix+"man_locl_curr_cd", currCd, currCd);
	}
         
	function t3sheet1_initCurrCd(sheetObj){
		var prefix = sheetObj.id + "_";
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH05);
		var currCd  = ComGetEtcData(sXml,"curr_cd");
		currCd = " |" + currCd;
		sheetObj.InitDataCombo(0, prefix+"man_locl_curr_cd", currCd, currCd);
	}
         
	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2];
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //조회
				if ( sheetObj.id == "t1sheet1"){
					formObj.f_cmd.value = SEARCH;
					formObj.yd_cd.value = formObj.port_cd.value+formObj.tml_cd_combo.Text;
					var arr = new Array("t1sheet1_", "");
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("t1sheet1_"));
					sheetObj.LoadSearchXml(sXml);
					// 권한제어
					afterSearch(sheetObject1);
					ComOpenWait(false);
				}else if (sheetObj.id == "t2sheet1"){	
					formObj.f_cmd.value = SEARCH01;
					formObj.yd_cd.value = formObj.port_cd.value+formObj.tml_cd_combo.Text;
					var arr = new Array("t2sheet1_", "");
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("t2sheet1_"));
					sheetObj.LoadSearchXml(sXml);
					// 권한제어
					afterSearch(sheetObject2);
					ComOpenWait(false);
				}else if ( sheetObj.id == "t3sheet1"){
					formObj.f_cmd.value = SEARCH02;
					var arr = new Array("t3sheet1_", "");
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam("t3sheet1_"));
					sheetObj.LoadSearchXml(sXml);
					// 권한제어
					afterSearch(sheetObject3);
					ComOpenWait(false);
				}
				break;

			case IBCLEAR:		// 초기화
				if ( sheetObj.id == "t1sheet1"){
					formObj.yd_cd.value = "";
					formObj.port_cd.value = "";
					formObj.fm_loc_cd.value = "";
					formObj.to_loc_cd.value = "";
					formObj.cond_no.value = "";
					formObj.cond_desc.value = "";
					formObj.tml_cd_combo.RemoveAll();
					sheetObj.RemoveAll();
				}else if (sheetObj.id == "t2sheet1"){
					formObj.yd_cd.value = "";
					formObj.port_cd.value = "";
					formObj.fm_loc_cd.value = "";
					formObj.to_loc_cd.value = "";
					formObj.cond_no.value = "";
					formObj.cond_desc.value = "";
					formObj.tml_cd_combo.RemoveAll();
					sheetObj.RemoveAll();
				}else if ( sheetObj.id == "t3sheet1"){
					formObj.yd_cd.value = "";
					formObj.port_cd.value = "";
					formObj.tml_cd_combo.text = "";
					formObj.fm_loc_cd.value = "";
					formObj.to_loc_cd.value = "";
					formObj.cond_no_t3.value = "";
					formObj.cond_desc_t3.value = "";
					sheetObj.RemoveAll();
				}
				break;
			
			case IBSAVE: //저장
				if ( sheetObj.id == "t1sheet1"){
					if(sheetObject1.RowCount < 1){
						ComShowCodeMessage('TES10028'); //There is no contents to save.
						return;
					}
					if(chkSaveAuth(sheetObject1)){ 
						if(validateForm(sheetObj,formObj,sAction)){
							if(t1sheet1_chkDupRow(sheetObject1)){
								ComOpenWait(true);
								t1sheet1_calcAppExtCost(sheetObject1);
								var sParam = ComGetSaveString(sheetObject1, false);
								if (sParam == ""){
									ComOpenWait(false);
									ComShowCodeMessage('TES10028'); //There is no data to Save.\n\n Please check again.
									return;
								} else {
									formObj.f_cmd.value = MULTI;
									sParam = sParam + "&" + FormQueryString(formObj) + "&" +ComGetPrefixParam("t1sheet1_");
								}
								sheetObj.WaitImageVisible = false;
								var sXml = sheetObj.GetSaveXml("ESD_TES_0051GS.do", sParam);
								ComOpenWait(false);
								// SAVE OK 일 경우 저장된 내용 다시 조회.
								var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
								if(nodeText == "S"){
									ComShowCodeMessage('TES90104'); //Data saved successfully
									doActionIBSheet(sheetObject1,formObj,IBSEARCH);
								}
							}
						}
					}	
				}else if (sheetObj.id == "t2sheet1"){
					if(sheetObject2.RowCount < 1){
						ComShowCodeMessage('TES10028'); //There is no contents to save.
						return;
					}
					if(chkSaveAuth(sheetObject2)){
						if(validateForm(sheetObj,formObj,sAction)){
							if(t2sheet1_chkDupRow(sheetObject2)){
								ComOpenWait(true);
								t2sheet1_calcAppExtCost(sheetObject2);
								var sParam = ComGetSaveString(sheetObject2, false);
								if (sParam == ""){
									ComOpenWait(false);
									ComShowCodeMessage('TES10028'); //There is no data to Save.\n\n Please check again.
									return;
								} else {
									formObj.f_cmd.value = MULTI01;
									sParam = sParam + "&" + FormQueryString(formObj) + "&" +ComGetPrefixParam("t2sheet1_");
								}
								sheetObj.WaitImageVisible = false;
								var sXml = sheetObj.GetSaveXml("ESD_TES_0051GS.do", sParam);
								ComOpenWait(false);
								// SAVE OK 일 경우 저장된 내용 다시 조회.
								var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
								if(nodeText == "S"){
									ComShowCodeMessage('TES90104'); //Data saved successfully
									doActionIBSheet(sheetObject2,formObj,IBSEARCH);
								}
							}
						}
					}	
				}else if ( sheetObj.id == "t3sheet1"){
					if(sheetObject3.RowCount < 1){
						ComShowCodeMessage('TES10028'); //There is no contents to save.
						return;
					}
					if(chkSaveAuth(sheetObject3)){
						if(validateForm(sheetObj,formObj,sAction)){
							if(t3sheet1_chkDupRow(sheetObject3)){
								ComOpenWait(true);
								var sParam = ComGetSaveString(sheetObject3, false);
								if (sParam == ""){
									ComOpenWait(false);
									ComShowCodeMessage('TES10028'); //There is no data to Save.\n\n Please check again.
									return;
								} else {
									formObj.f_cmd.value = MULTI02;
									sParam = sParam + "&" + FormQueryString(formObj) + "&" +ComGetPrefixParam("t3sheet1_");
								}
								sheetObj.WaitImageVisible = false;
								var sXml = sheetObj.GetSaveXml("ESD_TES_0051GS.do", sParam);
								ComOpenWait(false);
								// SAVE OK 일 경우 저장된 내용 다시 조회.
								var nodeText = ComGetEtcData(sXml, "TRANS_RESULT_KEY");
								if(nodeText == "S"){
									ComShowCodeMessage('TES90104'); //Data saved successfully
									doActionIBSheet(sheetObject3,formObj,IBSEARCH);
								}
							}
						}
					}	
				}
				break;	
			
			case SEARCH03:		//Port Code 체크
				formObj.f_cmd.value = SEARCH03;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", sParam);
				return sXml;
				break;
			
			case SEARCH04:		//Port에 맞는 Terminal 조회
				formObj.f_cmd.value = SEARCH04;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", sParam);
				return sXml;
				break;	
				
			case SEARCH05:		//Currency 조회
				formObj.f_cmd.value = SEARCH05;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", sParam);
				return sXml;
				break;	
			 
			case SEARCH06:		//Main Yard 체크
				formObj.f_cmd.value = SEARCH06;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do", sParam);
				return sXml;
				break;
				
			case SEARCH07:		//Year, Month 조회
				formObj.f_cmd.value = SEARCH07;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do",sParam);
				return sXml;
				break;
			
			case SEARCH08:		//sheet에 입력한 Port+Tml Cd 입력 권한 체크
				formObj.f_cmd.value = SEARCH08;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do",sParam);
				return sXml;
				break;
				
			case SEARCH09:		//sheet에 입력한 Port+Tml Cd 입력 권한 체크
				formObj.f_cmd.value = SEARCH09;
				var sParam = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_TES_0051GS.do",sParam);
				return sXml;
				break;		
        }
    }

    function initControl() {
    	formObj = document.form;
    	axon_event.addListenerForm('activate', 'obj_activate', form);
    	axon_event.addListenerForm('blur', 'obj_blur', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		
    	axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
    	axon_event.addListenerForm('keyup', 'obj_keyup', form); 
    	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    }

	function obj_keyup(){
		var eleObj = event.srcElement;
		var formObj = document.form;
		switch (eleObj.name) {
		    case "port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.year_month.focus();
		    	}
				break; 
		    case "fm_loc_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.to_loc_cd.focus();
		    	}
				break;
		}
	}
    
	function obj_change(){
		var formObj = document.form;
		var objs = document.all.item("tabLayer");
	    /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 **** */
	    var sheetObject1 = sheetObjects[0];
	    var sheetObject2 = sheetObjects[1];
	    var sheetObject3 = sheetObjects[2];
	    /** **************************************************** */
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	        switch(srcName) {
	            case "port_cd":
	            	if( objs[0].style.display == "inline" ){
	            		formObj.tml_cd_combo.RemoveAll();
	            		formObj.yd_cd.value = "";
    	            	formObj.yd_cd.value = formObj.port_cd.value;
    	            	var ydCd = formObj.yd_cd.value;
    	            	if(ydCd != ""){
    						var sXml = doActionIBSheet(sheetObject1, formObj, SEARCH03);
    						if(!isCheckPortForm(sheetObject1, formObj, sXml)){
    							formObj.port_cd.value = "";
    							formObj.port_cd.focus();
    						}else{
    							var sXml1 = doActionIBSheet(sheetObject1, formObj, SEARCH04);
    							setTmnlCombo(sXml1);
    						}
    	            	}
    	            break;
					}else if( objs[1].style.display == "inline" ){
						formObj.tml_cd_combo.RemoveAll();
						formObj.yd_cd.value = "";
    	            	formObj.yd_cd.value = formObj.port_cd.value;
    	            	var ydCd = formObj.yd_cd.value;
    	            	if(ydCd != ""){
    						var sXml = doActionIBSheet(sheetObject2, formObj, SEARCH03);
    						if(!isCheckPortForm(sheetObject2, formObj, sXml)){
    							formObj.port_cd.value = "";
    							formObj.port_cd.focus();
    						}else{
    							var sXml1 = doActionIBSheet(sheetObject2, formObj, SEARCH04);
    							setTmnlCombo(sXml1);
    						}
    	            	}
    	            break;
					}	

	            case "fm_loc_cd":
	            	formObj.yd_cd.value = "";
	            	formObj.yd_cd.value = formObj.fm_loc_cd.value;
	            	var ydCd = formObj.yd_cd.value;
	            	if(ydCd != ""){
						var sXml = doActionIBSheet(sheetObject3, formObj, SEARCH03);
						if(!isCheckPortForm(sheetObject3, formObj, sXml)){
							formObj.fm_loc_cd.value = "";
							formObj.fm_loc_cd.focus();
						}
	            	}
	            	break;
	
                case "to_loc_cd":
                	formObj.yd_cd.value = "";
                	formObj.yd_cd.value = formObj.to_loc_cd.value;
	            	var ydCd = formObj.yd_cd.value;
	            	if(ydCd != ""){
						var sXml = doActionIBSheet(sheetObject3, formObj, SEARCH03);
						if(!isCheckPortForm(sheetObject3, formObj, sXml)){
							formObj.to_loc_cd.value = "";
							formObj.to_loc_cd.focus();
						}
	            	}
	            	break;
	        } 
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(e);
			} else {
				alert(e);
			}
		}
	}
    	
    function obj_keypress(){
      	 var obj = event.srcElement;
      	 if(obj.dataformat == null) return;
      	 window.defaultStatus = obj.dataformat;
   	   	 switch(obj.dataformat) {
   	   	 	case "ym": case "ymd":
   	   	 		ComKeyOnlyNumber(obj);
   	   	 		break;
   	   	 }
    }
    
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
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
                    InsertTab( cnt++ , "Basic" , -1 );
                    InsertTab( cnt++ , "T/S" , -1 );
                    InsertTab( cnt++ , "Add-On" , -1 );
                }
             break;
         }
    }
    
 	function initCombo(comboObj, comboNo) {
		switch(comboNo) {
        case "tml_cd_combo":
            with(comboObj) {
				DropHeight = 150;
            }
            break;
		} 
	}
     
     /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var headCnt = sheetObj.HeaderRows;
       	if ( sheetObj.id == "t1sheet1"){
       		for(var i=headCnt; i<=sheetObj.LastRow; i++){
       			if(sheetObj.CellValue(i, "t1sheet1_ibflag") != "D"){
	       			if(sheetObj.CellValue(i, "t1sheet1_port_cd") == ""){
	       				ComShowCodeMessage('TES22037', '[Port Code]'); //Port Code is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t1sheet1_man_locl_amt_20ft") == "" && sheetObj.CellValue(i, "t1sheet1_auto_usd_amt_20ft") == ""){
	       				 ComShowCodeMessage("TES22037", "[20ft Unit Cost Manual Amount]"); //20ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t1sheet1_man_locl_amt_40ft") == "" && sheetObj.CellValue(i, "t1sheet1_auto_usd_amt_40ft") == ""){
	       				ComShowCodeMessage("TES22037", "[40ft Unit Cost Manual Amount]"); //40ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t1sheet1_man_usd_amt_20ft") != "" || sheetObj.CellValue(i, "t1sheet1_man_usd_amt_40ft") != "" || sheetObj.CellValue(i, "t1sheet1_auto_usd_amt_20ft") != "" || sheetObj.CellValue(i, "t1sheet1_auto_usd_amt_40ft") != ""){
	       				if(sheetObj.CellValue(i, "t1sheet1_sum_usd_amt_20ft") == "" || sheetObj.CellValue(i, "t1sheet1_sum_usd_amt_40ft") == ""){
	           				ComShowCodeMessage('TES90107'); //Please click [Calculation] button before save.
	           				return false;
	       				}
	       			}
       			}	
       		}
    	}else if ( sheetObj.id == "t2sheet1"){
       		for(var i=headCnt; i<=sheetObj.LastRow; i++){
       			if(sheetObj.CellValue(i, "t2sheet1_ibflag") != "D"){
	       			if(sheetObj.CellValue(i, "t2sheet1_port_cd") == ""){
	       				ComShowCodeMessage('TES22037', '[Port Code]'); //Port Code is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t2sheet1_man_locl_amt_20ft") == "" && sheetObj.CellValue(i, "t2sheet1_auto_usd_amt_20ft") == ""){
	       				 ComShowCodeMessage("TES22037", "[20ft Unit Cost Manual Amount]"); //20ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t2sheet1_man_locl_amt_40ft") == "" && sheetObj.CellValue(i, "t2sheet1_auto_usd_amt_40ft") == ""){
	       				ComShowCodeMessage("TES22037", "[40ft Unit Cost Manual Amount]"); //40ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	           		}
	       			if(sheetObj.CellValue(i, "t2sheet1_cond_no") == "0" && sheetObj.CellValue(i, "t2sheet1_tml_awk_ts_cd") != "A" && sheetObj.CellValue(i, "t2sheet1_io_bnd_cd") != "A" && sheetObj.CellValue(i, "t2sheet1_io_ga_cd") != "A"){
	    				ComShowCodeMessage('TES90119'); //Tariff Condition must be selected./n Plz, select Tariff Condition.
	    				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 217, 250);
	    				return false;
	    			}
       			}	
       		}
    	}else if ( sheetObj.id == "t3sheet1"){
       		for(var i=headCnt; i<=sheetObj.LastRow; i++){
       			if(sheetObj.CellValue(i, "t3sheet1_ibflag") != "D"){
       				if(sheetObj.CellValue(i, "t3sheet1_fm_loc_cd") == "" || sheetObj.CellValue(i, "t3sheet1_to_loc_cd") == ""){
	       				ComShowCodeMessage('TES22037', '[Port Code]'); //Port Code is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t3sheet1_man_usd_amt_20ft") == ""){
	       				 ComShowCodeMessage("TES22037", "[20ft Unit Cost Manual Amount]"); //20ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	       			}
	       			if(sheetObj.CellValue(i, "t3sheet1_man_usd_amt_40ft") == ""){
	       				ComShowCodeMessage("TES22037", "[40ft Unit Cost Manual Amount]"); //40ft Unit Cost Manual Amount is Mandatory item.
	       				return false;
	           		}
       			}	
       		}
    	}
       	return true;
    } 	
        
    function tab1_OnChange(tabObj , nItem){
		var objs = document.all.item("tabLayer");
		var formObj = document.form;
         
 	   	objs[nItem].style.display = "Inline";
 	   	objs[beforetab].style.display = "none";
    	// --------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	// ------------------------------------------------------//
    	beforetab= nItem;

        switch(nItem) {
			case 0:
				formObj.tml_awk_cgo_trf_tp_cd.value = "B";
				formObj.prefix.value = "t1sheet1_";
				formObj.cond_no.value = "";
				formObj.cond_desc.value = "";
				formObj.cond_no_t3.value = "";
				formObj.cond_desc_t3.value = "";
				shuttletab.style.display = "none";
				basictstab.style.display = "block";
				tabNowCnt = 1;
				break;
			case 1:
				formObj.tml_awk_cgo_trf_tp_cd.value = "T";
				formObj.prefix.value = "t2sheet1_";
				formObj.cond_no.value = "";
				formObj.cond_desc.value = "";
				formObj.cond_no_t3.value = "";
				formObj.cond_desc_t3.value = "";
				shuttletab.style.display = "none";
				basictstab.style.display = "block";
				tabNowCnt = 2;
				break;
			case 2:
				formObj.tml_awk_cgo_trf_tp_cd.value = "A";
				formObj.prefix.value = "t3sheet1_";
				formObj.cond_no.value = "";
				formObj.cond_desc.value = "";
				formObj.cond_no_t3.value = "";
				formObj.cond_desc_t3.value = "";
				shuttletab.style.display = "block";
				basictstab.style.display = "none";
				tabNowCnt = 3;            		
				break;
        }
    }

  	function t1sheet1_OnChange(sheetObj, Row, Col, Value){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		var sXml1 = null;
		var colName = sheetObj.ColSaveName(Col);
		formObj.select_row.value = sheetObj.SelectRow;
		formObj.select_col.value = sheetObj.SelectCol;
		if(colName == prefix+"port_cd"){
			if(sheetObj.CellValue(Row, prefix+"port_cd") == ""){
				sheetObj.CellValue(Row, prefix+"tml_cd") = "";
				sheetObj.CellValue(Row, prefix+"yd_cd") = "";
				sheetObj.CellValue2(Row, prefix+"mn_yd_flg") = "0";
			}else{
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"port_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						sheetObj.CellValue2(Row, prefix+"mn_yd_flg") = "0";
						sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH04);
						setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
						createYdCd(sheetObj, Row);
					}
				}else{
					sheetObj.CellValue2(Row, prefix+"port_cd") = "";
					sheetObj.SelectCell(Row, prefix+"port_cd");
				}
			}	
		}else if(colName == prefix+"tml_cd"){
			if(sheetObj.CellValue(Row, prefix+"port_cd")!= ""){
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"port_cd")+ sheetObj.CellValue(Row, prefix+"tml_cd");
				var flg = doActionIBSheet(sheetObj, formObj, SEARCH08);
				flg = ComGetEtcData(flg, "chk_flg");
				if(flg == "N"){
					ComShowCodeMessage('TES90111', formObj.yd_cd.value); //No authority to create data for the Port [{?msg1}]
					sheetObj.CellValue2(Row, prefix+"port_cd")= "";
					sheetObj.CellValue2(Row, prefix+"tml_cd")= "";
					formObj.yd_cd.value = "";
				}else{
					createYdCd(sheetObj, Row);
					sheetObj.CellValue2(Row, prefix+"mn_yd_flg") = "0";
					var port_cd = sheetObj.CellValue(Row, prefix+"port_cd");
					var tml_cd = sheetObj.CellValue(Row, prefix+"tml_cd");
					for(var i=headCnt; i<=sheetObj.LastRow; i++){
						if(sheetObj.CellValue(i, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"port_cd") == port_cd && sheetObj.CellValue(i, prefix+"tml_cd") == tml_cd && sheetObj.CellValue(i, prefix+"mn_yd_flg") == "1" ){
							sheetObj.CellValue2(Row, prefix+"mn_yd_flg") = "1";
						}
					}
					
				}
			}
		}else if(colName == prefix+"cond_desc"){
			if(sheetObj.CellValue(Row, prefix+"cond_desc") == ""){
				sheetObj.CellValue2(Row, prefix+"cond_no") = "0";
			}
		}else if(colName == prefix+"mn_yd_flg"){
			var port_cd = sheetObj.CellValue(Row, prefix+"port_cd");
			var tml_cd = sheetObj.CellValue(Row, prefix+"tml_cd");
			if(sheetObj.CellValue(Row, prefix+"mn_yd_flg") == "1"){
				if(sheetObj.CellValue(Row, prefix+"port_cd") == ""){
					sheetObj.CellValue(Row, prefix+"mn_yd_flg") = "0";
				}
				if(sheetObj.CellValue(Row, prefix+"port_cd") != "" && sheetObj.CellValue(Row, prefix+"tml_cd") != "" ){
					if(checkMnYdFlg(sheetObj,Row)){
						for(var i=headCnt; i<=sheetObj.LastRow; i++){
    						if(sheetObj.SelectRow != i){
	    						if(sheetObj.CellValue(i, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"port_cd") == port_cd && sheetObj.CellValue(i, prefix+"mn_yd_flg") == "1"&& sheetObj.CellValue(i, prefix+"tml_cd") != tml_cd){
	    							ComShowCodeMessage('TES90108', port_cd); //There is a Port checked as main port on the sheet.
	    							sheetObj.CellValue(sheetObj.SelectRow, prefix+"mn_yd_flg") = "0";
									return false;
	    							break;
	    						}else if(sheetObj.CellValue(i, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"port_cd") == port_cd && sheetObj.CellValue(i, prefix+"tml_cd") == tml_cd){
	    							sheetObj.CellValue2(i, prefix+"mn_yd_flg") = "1";
	    						}
    						}
						}
					}
				}
			}else if(sheetObj.CellValue(Row, prefix+"mn_yd_flg") == "0" ){
				if(sheetObj.CellValue(Row, prefix+"port_cd") != "" && sheetObj.CellValue(Row, prefix+"tml_cd") != "" ){
					for(var i=headCnt; i<=sheetObj.LastRow; i++){
						if(sheetObj.CellValue(Row, prefix+"ibflag") != "D" && sheetObj.CellValue(i, prefix+"port_cd") == port_cd && sheetObj.CellValue(i, prefix+"tml_cd") == tml_cd ){
							sheetObj.CellValue(i, prefix+"mn_yd_flg") = "0";
						}
					}
				}
			}
		}else if(colName == prefix+"man_locl_curr_cd"){
			sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
		}else if(colName == prefix+"man_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
				}
			}
		}else if(colName == prefix+"man_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
				}
			}
		}else if(colName == prefix+"ttl_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") != "" ){
				if(sheetObj.CellValue(Row, prefix+"ttl_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"ttl_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
    				sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_usd_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_usd_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"aply_rto") = "";
					
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_20ft") = false;
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_40ft") = false;
					sheetObj.CellEditable(Row,prefix+"aply_rto") = false;
					sheetObj.CellEditable(Row,prefix+"fml_locl_curr_cd") = false;
				}		
			}else if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") == ""){
				sheetObj.CellValue(Row, prefix+"ttl_usd_amt_20ft") = "";
				if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") == "" ){
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_20ft") = true;
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_40ft") = true;
					sheetObj.CellEditable(Row,prefix+"aply_rto") = true;
					sheetObj.CellEditable(Row,prefix+"fml_locl_curr_cd") = true;
				}	
			}
		}else if(colName == prefix+"ttl_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") != "" ){
				if(sheetObj.CellValue(Row, prefix+"ttl_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") = "";
				}else{
					formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"ttl_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
    				sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_usd_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"fml_usd_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"aply_rto") = "";
					
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_20ft") = false;
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_40ft") = false;
					sheetObj.CellEditable(Row,prefix+"aply_rto") = false;
					sheetObj.CellEditable(Row,prefix+"fml_locl_curr_cd") = false;
				}
				
			}else if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") == ""){
				sheetObj.CellValue(Row, prefix+"ttl_usd_amt_40ft") = "";
				if(sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") == "" ){
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_20ft") = true;
					sheetObj.CellEditable(Row,prefix+"fml_locl_amt_40ft") = true;
					sheetObj.CellEditable(Row,prefix+"aply_rto") = true;
					sheetObj.CellEditable(Row,prefix+"fml_locl_curr_cd") = true;
				}	
			}
		}else if(colName == prefix+"ttl_locl_curr_cd"){
			sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") = "";
			sheetObj.CellValue(Row, prefix+"ttl_usd_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"ttl_usd_amt_40ft") = "";
		}else if(colName == prefix+"aply_rto"){
			if(sheetObj.CellValue(Row, prefix+"aply_rto") != ""){
				sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") = "";
				sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") = "";
				sheetObj.CellValue(Row, prefix+"ttl_usd_amt_20ft") = "";
				sheetObj.CellValue(Row, prefix+"ttl_usd_amt_40ft") = "";
				
				sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = false;
				sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = false;
				sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = false;
			}else{
				if(sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") == "" && sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") == ""){
					sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = true;
				}	
			}
		}else if(colName == prefix+"fml_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") != "" ){
				if(sheetObj.CellValue(Row, prefix+"fml_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"fml_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
    				sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_usd_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_usd_amt_40ft") = "";
					
					sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = false;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = false;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = false;
				}
			}else{
				sheetObj.CellValue(Row, prefix+"fml_usd_amt_20ft") = "";
				if(sheetObj.CellValue(Row, prefix+"aply_rto") == "" && sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") == ""){
					sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = true;
				}	
			}
		}else if(colName == prefix+"fml_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") != ""){
				if(sheetObj.CellValue(Row, prefix+"fml_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"fml_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't1sheet1_checkUsdConvert');
    				sheetObj.CellValue(Row, prefix+"ttl_locl_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_locl_amt_40ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_usd_amt_20ft") = "";
					sheetObj.CellValue(Row, prefix+"ttl_usd_amt_40ft") = "";
					
					sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = false;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = false;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = false;
				}
			}else{
				sheetObj.CellValue(Row, prefix+"fml_usd_amt_40ft") = "";
				if(sheetObj.CellValue(Row, prefix+"aply_rto") == "" && sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") == ""){
					sheetObj.CellEditable(Row,prefix+"ttl_locl_curr_cd") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_20ft") = true;
					sheetObj.CellEditable(Row,prefix+"ttl_locl_amt_40ft") = true;
				}	
			}
		}else if(colName == prefix+"fml_locl_curr_cd"){
			sheetObj.CellValue(Row, prefix+"fml_locl_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"fml_locl_amt_40ft") = "";
			sheetObj.CellValue(Row, prefix+"fml_usd_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"fml_usd_amt_40ft") = "";
		}
	}
      	
  	function t2sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		var sXml1 = null;
		var colName = sheetObj.ColSaveName(Col);
		formObj.select_row.value = sheetObj.SelectRow;
		formObj.select_col.value = sheetObj.SelectCol;
		if(colName == prefix+"port_cd"){
			if(sheetObj.CellValue(Row, prefix+"port_cd") == ""){
				sheetObj.CellValue(Row, prefix+"tml_cd") = "";
				sheetObj.CellValue(Row, prefix+"yd_cd") = "";
			}else{
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"port_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH04);
						setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
						createYdCd(sheetObj, Row);
					}
				}else{
					sheetObj.CellValue2(Row, prefix+"port_cd") = "";
					sheetObj.SelectCell(Row, prefix+"port_cd");
				}
			}	
		}else if(colName == prefix+"tml_cd"){
			if(sheetObj.CellValue(Row, prefix+"port_cd")!= ""){
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"port_cd")+ sheetObj.CellValue(Row, prefix+"tml_cd");
				var flg = doActionIBSheet(sheetObj, formObj, SEARCH08);
				flg = ComGetEtcData(flg, "chk_flg");
				if(flg == "N"){
					ComShowCodeMessage('TES90111', formObj.yd_cd.value); //No authority to create data for the Port [{?msg1}]
					sheetObj.CellValue2(Row, prefix+"port_cd")= "";
					sheetObj.CellValue2(Row, prefix+"tml_cd")= "";
					formObj.yd_cd.value = "";
				}else{
					createYdCd(sheetObj, Row);
				}
			}
		}else if(colName == prefix+"cond_desc"){
			if(sheetObj.CellValue(Row, prefix+"cond_desc") == ""){
				sheetObj.CellValue2(Row, prefix+"cond_no") = "0";
			}
		}else if(colName == prefix+"man_locl_curr_cd"){
			sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
		}else if(colName == prefix+"man_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't2sheet1_checkUsdConvert');
				}
			}
		}else if(colName == prefix+"man_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't2sheet1_checkUsdConvert');
				}
			}
		}else if(colName == prefix+"tml_awk_ts_cd" || colName == prefix+"io_bnd_cd" || colName == prefix+"io_ga_cd"){
			if(sheetObj.CellValue(Row, prefix+"tml_awk_ts_cd") == "A" || sheetObj.CellValue(Row, prefix+"io_bnd_cd") == "A" || sheetObj.CellValue(Row, prefix+"io_ga_cd") == "A"){
				ComShowCodeMessage('TES90117'); // Not available to select [Default] for new data.
				sheetObj.CellValue2(Row, prefix+"tml_awk_ts_cd") = "S";
				sheetObj.CellValue2(Row, prefix+"io_bnd_cd") = "I";
				sheetObj.CellValue2(Row, prefix+"io_ga_cd") = "I";
			} 
		}
	}
      	
  	function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		var sXml = null;
		var sXml1 = null;
		var colName = sheetObj.ColSaveName(Col);
		formObj.select_row.value = sheetObj.SelectRow;
		formObj.select_col.value = sheetObj.SelectCol;
		if(colName == prefix+"fm_loc_cd"){
			if(sheetObj.CellValue(Row, prefix+"fm_loc_cd") == ""){
				sheetObj.CellValue(Row, prefix+"fm_nod_yd_no") = "";
			}else{	
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"fm_loc_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH04);
						setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
					}
				}else{
					sheetObj.CellValue2(Row, prefix+"fm_loc_cd") = "";
					sheetObj.SelectCell(Row, prefix+"fm_loc_cd");
				}
			}	
		}else if(colName == prefix+"to_loc_cd"){
			if(sheetObj.CellValue(Row, prefix+"to_loc_cd") == ""){
				sheetObj.CellValue(Row, prefix+"to_nod_yd_no") = "";
			}else{
				formObj.yd_cd.value = "";
				formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"to_loc_cd");
				sXml = doActionIBSheet(sheetObj, formObj, SEARCH03);
				if(isCheckPortForm(sheetObj, formObj, sXml)){
					if(sXml != null && sXml != undefined && sXml != ""){
						sXml1 = doActionIBSheet(sheetObj, formObj, SEARCH04);
						setSheetTmnlCombo(sXml1, sheetObj, Row, Col);
					}
				}else{
					sheetObj.CellValue2(Row, prefix+"to_loc_cd") = "";
					sheetObj.SelectCell(Row, prefix+"to_loc_cd");
				}
			}	
		}else if(colName == prefix+"fm_nod_yd_no"){
			chkYdCdInputAuth(sheetObj, Row);
		}else if(colName == prefix+"to_nod_yd_no"){
			chkYdCdInputAuth(sheetObj, Row);
		}else if(colName == prefix+"cond_desc"){
			if(sheetObj.CellValue(Row, prefix+"cond_desc") == ""){
				sheetObj.CellValue2(Row, prefix+"cond_no") = "0";
			}
		}else if(colName == prefix+"man_locl_curr_cd"){
			sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
		}else if(colName == prefix+"man_locl_amt_20ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_20ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_20ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't3sheet1_checkUsdConvert');
				}
			}
		}else if(colName == prefix+"man_locl_amt_40ft"){
			if(sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") == ""){
				sheetObj.CellValue(Row, prefix+"man_usd_amt_40ft") = "";
			}else{
				if(sheetObj.CellValue(Row, prefix+"man_locl_curr_cd") == ""){
					ComShowCodeMessage('TES90115'); //'Please input [Currency] first.
					sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft") = "";
				}else{
    				formObj.lcl_amt.value = sheetObj.CellValue(Row, prefix+"man_locl_amt_40ft");
    				formObj.curr_cd.value = sheetObj.CellValue(Row, prefix+"man_locl_curr_cd");
    				tes_getInputValue('usd_amt', SEARCHLIST12, 'lcl_amt|curr_cd|select_row|select_col', 't3sheet1_checkUsdConvert');
				}
			}
		}	
	}
      	
  	function chkSaveAuth(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var Row = sheetObj.RowCount;
		if(sheetObj.id == "t1sheet1" || sheetObj.id == "t2sheet1"){
    		for(var i=headCnt; i<=sheetObj.LastRow; i++){
    			if(sheetObj.CellValue(i , prefix+"chk_auth_yn")== "Y" && sheetObj.CellValue(i , prefix+"act_yd_ofc_auth_yn")=="Y"){
    				return true;
    			}
    		}
    		ComShowCodeMessage('TES90106'); //No authority to Save
    		return false;
		}else if(sheetObj.id == "t3sheet1"){
    		for(var i=headCnt; i<=sheetObj.LastRow; i++){
    			if(sheetObj.CellValue(i , prefix+"chk_auth_yn")== "Y"){
    				return true;
    			}
    		}
    		ComShowCodeMessage('TES90106'); //No authority to Save
    		return false;
		}	
  	}
      	
  	function t1sheet1_chkDupRow(sheetObject1){
		var idx = 0;
		var Rows = "";
		Rows = sheetObject1.ColValueDupRows("t1sheet1_port_cd|t1sheet1_tml_cd|t1sheet1_io_bnd_cd|t1sheet1_cond_no", false);
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=""){
			arr_rows = Rows.split(',');
		}
		if(arr_rows != null){
    		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    			sheetObject1.RowFontColor(arr_rows[i]) = sheetObject1.RgbColor(255, 0, 0);
    		}
    		ComShowCodeMessage('TES24030', 'Data');
    		return false;
		}	
		return true;
	}
      	
  	function t2sheet1_chkDupRow(sheetObject2){
		var idx = 0;
		var Rows = "";
		Rows = sheetObject2.ColValueDupRows("t2sheet1_port_cd|t2sheet1_tml_cd|t2sheet1_tml_awk_ts_cd|t2sheet1_io_bnd_cd|t2sheet1_io_ga_cd|t2sheet1_cond_no", false);
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=""){
			arr_rows = Rows.split(',');
		}
		if(arr_rows != null){
    		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    			sheetObject2.RowFontColor(arr_rows[i]) = sheetObject2.RgbColor(255, 0, 0);
    		}
    		ComShowCodeMessage('TES24030', 'Data');
    		return false;
		}
		return true;
	}
      	
  	function t3sheet1_chkDupRow(sheetObject3){
		var idx = 0;
		var Rows = "";
		Rows = sheetObject3.ColValueDupRows("t3sheet1_fm_loc_cd|t3sheet1_fm_nod_yd_no|t3sheet1_to_loc_cd|t3sheet1_to_nod_yd_no|t3sheet1_cond_no", false);
		var arr_rows = null;
		if (Rows!=null && Rows.trim()!=""){
			arr_rows = Rows.split(',');
		}
		if(arr_rows != null){
    		for (var i=0; arr_rows!=null && i<arr_rows.length; i++){
    			sheetObject3.RowFontColor(arr_rows[i]) = sheetObject3.RgbColor(255, 0, 0);
    		}
    		ComShowCodeMessage('TES24030', 'Data');
    		return false;
		}
		return true;
	}
      	
  	function t1sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t1sheet1_cond_desc"){
			var sUrl = "/hanjin/ESD_TES_0057.do?tml_awk_cgo_trf_tp_cd=B";
			var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
			if(rVal){
				sheetObj.CellValue2(Row, "t1sheet1_cond_desc") = rVal.cond_desc;
				sheetObj.CellValue2(Row, "t1sheet1_cond_no") = rVal.cond_no;
			}
		}
	}
      	
  	function t2sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet1_cond_desc"){
			var sUrl = "/hanjin/ESD_TES_0057.do?tml_awk_cgo_trf_tp_cd=T";
			var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
			if(rVal){
				sheetObj.CellValue2(Row, "t2sheet1_cond_desc") = rVal.cond_desc;
				sheetObj.CellValue2(Row, "t2sheet1_cond_no") = rVal.cond_no;
			}
		}
	}
  	
  	function t3sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t3sheet1_cond_desc"){
			var sUrl = "/hanjin/ESD_TES_0057.do?tml_awk_cgo_trf_tp_cd=A";
			var rVal = ComOpenPopupWithTarget(sUrl, 650, 450, "", "0,0", true);
			if(rVal){
				sheetObj.CellValue2(Row, "t3sheet1_cond_desc") = rVal.cond_desc;
				sheetObj.CellValue2(Row, "t3sheet1_cond_no") = rVal.cond_no;
			}
		}
	}
    	 
  	function t1sheet1_OnClick(sheetObj, row, col, value) {
		var prefix = sheetObj.id + "_";
		if (sheetObj.ColSaveName(col) == prefix+"calc_rmk") {
			if(sheetObj.CellValue(row, prefix+"chk_auth_yn") == "N" || sheetObj.CellValue(row, prefix+"act_yd_ofc_auth_yn") == "N"){
				ComShowMemoPad(sheetObj, null, null, true, 300, 120, 600);
			}else{
				ComShowMemoPad(sheetObj, null, null, false, 300, 120, 600);
			}
  		}
  	}
  	
  	function t2sheet1_OnClick(sheetObj, row, col, value) {
  		var prefix = sheetObj.id + "_";
		if (sheetObj.ColSaveName(col) == prefix+"calc_rmk") {
			if(sheetObj.CellValue(row, prefix+"chk_auth_yn") == "N" || sheetObj.CellValue(row, prefix+"act_yd_ofc_auth_yn") == "N"){
				ComShowMemoPad(sheetObj, null, null, true, 300, 120, 600);
			}else{
				ComShowMemoPad(sheetObj, null, null, false, 300, 120, 600);
			}
  		}
  	}
  	
  	function t3sheet1_OnClick(sheetObj, row, col, value) {
  		var prefix = sheetObj.id + "_";
		if (sheetObj.ColSaveName(col) == prefix+"calc_rmk") {
			if(sheetObj.CellValue(row, prefix+"chk_auth_yn") == "N"){
				ComShowMemoPad(sheetObj, null, null, true, 300, 120, 600);
			}else{
				ComShowMemoPad(sheetObj, null, null, false, 300, 120, 600);
			}
  		}
  	}

    function isCheckPortForm(sheetObj, formObj, sXml){
    	var chkPort = ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("TES23006","[Port Code]"); //This is invalid Port Code.
			return false;
		}
    }
    
	function setSheetTmnlCombo(xmlStr, sheetObj, Row, Col){
		var tmlCd = ComGetEtcData(xmlStr,"tml_cd");
		if(sheetObj.id == "t1sheet1" || sheetObj.id == "t2sheet1"){
			sheetObj.CellComboItem(Row, sheetObj.id+"_tml_cd", tmlCd, tmlCd);
		}else if(sheetObj.id == "t3sheet1"){
			tmlCd = " |"+tmlCd;
			if(sheetObj.ColSaveName(Col) == "t3sheet1_fm_loc_cd"){
				sheetObj.CellComboItem(Row, "t3sheet1_fm_nod_yd_no", tmlCd, tmlCd);
				chkYdCdInputAuth(sheetObj, Row);
			}else if(sheetObj.ColSaveName(Col) == "t3sheet1_to_loc_cd"){
				sheetObj.CellComboItem(Row, "t3sheet1_to_nod_yd_no", tmlCd, tmlCd);
				chkYdCdInputAuth(sheetObj, Row);
			}
		}
	}
    	
	function chkYdCdInputAuth(sheetObj, Row){
		var formObj = document.form;
		if(sheetObj.CellValue(Row, "t3sheet1_fm_loc_cd")!= "" && sheetObj.CellValue(Row, "t3sheet1_to_loc_cd")!= "" ){
			formObj.fm_yd_cd.value = "";
			formObj.fm_yd_cd.value = sheetObj.CellValue(Row, "t3sheet1_fm_loc_cd")+ sheetObj.CellValue(Row, "t3sheet1_fm_nod_yd_no");
			formObj.to_yd_cd.value = "";
			formObj.to_yd_cd.value = sheetObj.CellValue(Row, "t3sheet1_to_loc_cd")+ sheetObj.CellValue(Row, "t3sheet1_to_nod_yd_no");
			var flg = doActionIBSheet(sheetObj, formObj, SEARCH09);
			flg = ComGetEtcData(flg, "chk_flg");
			if(flg == "N"){
				ComShowCodeMessage('TES90112', formObj.fm_yd_cd.value, formObj.to_yd_cd.value); //No authority to create data for From [{?msg1}] To [{?msg2}]
				sheetObj.CellValue2(Row, "t3sheet1_fm_loc_cd")= "";
				sheetObj.CellValue2(Row, "t3sheet1_fm_nod_yd_no")= "";
				sheetObj.CellValue2(Row, "t3sheet1_to_loc_cd")= "";
				sheetObj.CellValue2(Row, "t3sheet1_to_nod_yd_no")= "";
			}
		}
	}
    	
	function t1sheet1_checkUsdConvert(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		tmp = formObj.usd_amt.value.split('|');
		// unit cost manual 20ft일 경우
		if(tmp[1] == "12"){                               
			sheetObj.CellValue2(tmp[0], "t1sheet1_man_usd_amt_20ft") = tmp[2];
			sheetObj.CellValue2(tmp[0], "t1sheet1_usd_xch_dt") = tmp[3];
		}else if(tmp[1] == "13"){                               
    			sheetObj.CellValue2(tmp[0], "t1sheet1_man_usd_amt_40ft") = tmp[2];
    			sheetObj.CellValue2(tmp[0], "t1sheet1_usd_xch_dt") = tmp[3];
    	}else if(tmp[1] == "19"){                               
			sheetObj.CellValue2(tmp[0], "t1sheet1_ttl_usd_amt_20ft") = tmp[2];
    	}else if(tmp[1] == "20"){                               
			sheetObj.CellValue2(tmp[0], "t1sheet1_ttl_usd_amt_40ft") = tmp[2];
    	}else if(tmp[1] == "25"){                               
			sheetObj.CellValue2(tmp[0], "t1sheet1_fml_usd_amt_20ft") = tmp[2];
    	}else if(tmp[1] == "26"){
			sheetObj.CellValue2(tmp[0], "t1sheet1_fml_usd_amt_40ft") = tmp[2];
    	}
	}
    	
	function t2sheet1_checkUsdConvert(){
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
		tmp = formObj.usd_amt.value.split('|');
		// unit cost manual 20ft일 경우
		if(tmp[1] == "11"){                               
			sheetObj.CellValue2(tmp[0], "t2sheet1_man_usd_amt_20ft") = tmp[2];
			sheetObj.CellValue2(tmp[0], "t2sheet1_usd_xch_dt") = tmp[3];
		}else if(tmp[1] == "12"){                               
    			sheetObj.CellValue2(tmp[0], "t2sheet1_man_usd_amt_40ft") = tmp[2];
    			sheetObj.CellValue2(tmp[0], "t2sheet1_usd_xch_dt") = tmp[3];
    	}
	}
	
	function t3sheet1_checkUsdConvert(){
		var formObj = document.form;
		var sheetObj = sheetObjects[2];
		tmp = formObj.usd_amt.value.split('|');
		// unit cost manual 20ft일 경우
		if(tmp[1] == "8"){                               
			sheetObj.CellValue2(tmp[0], "t3sheet1_man_usd_amt_20ft") = tmp[2];
			sheetObj.CellValue2(tmp[0], "t3sheet1_usd_xch_dt") = tmp[3];
		}else if(tmp[1] == "9"){                               
    			sheetObj.CellValue2(tmp[0], "t3sheet1_man_usd_amt_40ft") = tmp[2];
    			sheetObj.CellValue2(tmp[0], "t3sheet1_usd_xch_dt") = tmp[3];
    	}
	}
    	
	function setYearMonth(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var sXml = doActionIBSheet(sheetObj, formObj, SEARCH07);
		var ym = ComGetEtcData(sXml,"year_month");
		formObj.year_month.value = ym;
	}
	
	function getChkFlgRow(sheetObj){
		var headCnt = sheetObj.HeaderRows;
		var prefix = sheetObj.id + "_";
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, prefix+"chk_flg") == "1"){
			    var ckrow = i;
			}
		}
		return ckrow;
	}
    	
	function afterSearch(sheetObj){
		var formObj = document.form;
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var Row = sheetObj.RowCount;
		if(sheetObj.id == "t1sheet1"){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				//저장된거면서 수정권한이 있는 거
				if(sheetObj.CellValue(i, prefix+"ibflag") != "I" && sheetObj.CellValue(i, prefix+"chk_auth_yn") == "Y"){
					sheetObj.CellEditable(i, prefix+"chk_flg") = true;
					sheetObj.CellEditable(i, prefix+"mn_yd_flg") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"aply_rto") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_amt_40ft") = true;
					// total 값 있으면 formula값 입력 불가 / formula값 있으면 total 값 입력불가
					if(sheetObj.CellValue(i, prefix+"ttl_locl_amt_20ft") != "" || sheetObj.CellValue(i, prefix+"ttl_locl_amt_40ft") != "" ){
						sheetObj.CellEditable(i,prefix+"fml_locl_amt_20ft") = false;
						sheetObj.CellEditable(i,prefix+"fml_locl_amt_40ft") = false;
						sheetObj.CellEditable(i,prefix+"aply_rto") = false;
						sheetObj.CellEditable(i,prefix+"fml_locl_curr_cd") = false;
					}	
					if(sheetObj.CellValue(i, prefix+"fml_locl_amt_20ft") != "" || sheetObj.CellValue(i, prefix+"fml_locl_amt_40ft") != "" || sheetObj.CellValue(i, prefix+"aply_rto") != ""){
						sheetObj.CellEditable(i,prefix+"ttl_locl_curr_cd") = false;
						sheetObj.CellEditable(i,prefix+"ttl_locl_amt_20ft") = false;
						sheetObj.CellEditable(i,prefix+"ttl_locl_amt_40ft") = false;
					}
				//배치돌린값이면서 수정권한이 있는거	
				}else if(sheetObj.CellValue(i, prefix+"ibflag") == "I" && sheetObj.CellValue(i, prefix+"act_yd_ofc_auth_yn") == "Y"){
					sheetObj.CellEditable(i, prefix+"chk_flg") = true;
					sheetObj.CellEditable(i, prefix+"mn_yd_flg") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"ttl_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"aply_rto") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"fml_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"cond_desc") = true;
				}	
			}
			
			
		}else if(sheetObj.id == "t2sheet1"){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				//저장된거면서 수정권한이 있는 거
				if(sheetObj.CellValue(i, prefix+"ibflag") != "I" && sheetObj.CellValue(i, prefix+"chk_auth_yn") == "Y"){
					sheetObj.CellEditable(i, prefix+"chk_flg") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_40ft") = true;
					if(sheetObj.CellValue(i, prefix+"tml_awk_ts_cd") == "A" && sheetObj.CellValue(i, prefix+"io_bnd_cd") == "A" && sheetObj.CellValue(i, prefix+"io_ga_cd") == "A"){
						sheetObj.CellEditable(i, prefix+"chk_flg") = false;
					}
				// 배치돌린값이면서 수정권한이 있는거
				}else if(sheetObj.CellValue(i, prefix+"ibflag") == "I" && sheetObj.CellValue(i, prefix+"act_yd_ofc_auth_yn") == "Y"){
					sheetObj.CellEditable(i, prefix+"chk_flg") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_curr_cd") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_20ft") = true;
					sheetObj.CellEditable(i, prefix+"man_locl_amt_40ft") = true;
					sheetObj.CellEditable(i, prefix+"cond_desc") = true;
					//Default 값일 경우
					if(sheetObj.CellValue(i, prefix+"tml_awk_ts_cd") == "A" && sheetObj.CellValue(i, prefix+"io_bnd_cd") == "A" && sheetObj.CellValue(i, prefix+"io_ga_cd") == "A"){
						sheetObj.CellEditable(i, prefix+"chk_flg") = false;
						sheetObj.CellEditable(i, prefix+"cond_desc") = false;
					}
				}
			}	
		}else if(sheetObj.id == "t3sheet1"){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				//권한체크
				if(sheetObj.CellValue(i, prefix+"chk_auth_yn") == "Y"){
					sheetObj.CellEditable(i,prefix+"chk_flg") = true;
					sheetObj.CellEditable(i,prefix+"man_locl_curr_cd") = true;
					sheetObj.CellEditable(i,prefix+"man_locl_amt_20ft") = true;
					sheetObj.CellEditable(i,prefix+"man_locl_amt_40ft") = true;
					sheetObj.CellEditable(i,prefix+"vndr_nm") = true;
					
				}
			}
		}
	}	
    	
	function checkMnYdFlg(sheetObj,Row){
		var prefix = sheetObj.id + "_";
		var formObj = document.form;
		var sheetYdCd = "";
		formObj.yd_cd.value = sheetObj.CellValue(Row, prefix+"port_cd");
		sheetYdCd = sheetObj.CellValue(Row, prefix+"port_cd") + sheetObj.CellValue(Row, prefix+"tml_cd");
		var sXml = doActionIBSheet(sheetObj,formObj,SEARCH06);
		var mnYd = ComGetEtcData(sXml,"mn_yd");
		if(mnYd != ""){
			if(mnYd != sheetYdCd){
				ComShowCodeMessage('TES90109', mnYd); //The Port [{?msg1}] is already checked as main port.
				sheetObj.CellValue2(Row, "t1sheet1_mn_yd_flg") = 0;
				return false;
			}	
		}
		return true;
	}
	
	function createYdCd(sheetObj, Row){
		var prefix = sheetObj.id + "_";
		if(sheetObj.id == "t1sheet1"){
    		sheetObj.CellValue2(Row, prefix+"yd_cd") = sheetObj.CellValue(Row, prefix+"port_cd")+sheetObj.CellValue(Row, prefix+"tml_cd");
		}else if(sheetObj.id == "t2sheet1"){
    		sheetObj.CellValue2(Row, prefix+"yd_cd") = sheetObj.CellValue(Row, prefix+"port_cd")+sheetObj.CellValue(Row, prefix+"tml_cd");
		}
	}
	
	function chkDelt(sheetObj, formObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
//		if(formObj.lg_ofc_cd.value != "SELCGS" && formObj.lg_ofc_cd.value != "SELCCB"){
		if(!tes_isAwkSpclAuthOfc(formObj.lg_ofc_cd.value)){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i, prefix+"chk_flg") == "1" && sheetObj.CellValue(i, prefix+"spcl_cgo_ref_seq") != ""){
					var yd_cd = sheetObj.CellValue(i, prefix+"port_cd") + sheetObj.CellValue(i, prefix+"tml_cd");
					ComShowCodeMessage('TES90116',yd_cd ); //Not Available to delete Port [{?msg1}] which are used as Actual Cost.
					sheetObj.CellValue(i, prefix+"chk_flg") = "0";
					return false;
				}
			}
		}	
		return true;
	}
	
	function chkDeltAddOn(sheetObj, formObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
//		if(formObj.lg_ofc_cd.value != "SELCGS" && formObj.lg_ofc_cd.value != "SELCCB"){
		if(!tes_isAwkSpclAuthOfc(formObj.lg_ofc_cd.value)){
			for(var i=headCnt; i<=sheetObj.LastRow; i++){
				if(sheetObj.CellValue(i, prefix+"chk_flg") == "1" && sheetObj.CellValue(i, prefix+"spcl_cgo_ref_seq") != ""){
					var fm_yd_cd = sheetObj.CellValue(i, prefix+"fm_loc_cd") + sheetObj.CellValue(i, prefix+"fm_nod_yd_no");
					var to_yd_cd = sheetObj.CellValue(i, prefix+"to_loc_cd") + sheetObj.CellValue(i, prefix+"to_nod_yd_no");
					ComShowCodeMessage('TES90110',fm_yd_cd ,to_yd_cd ); //Not Available to delete From [{?msg1}] To [{?msg2}] which are used as Actual Cost.
					sheetObj.CellValue(i, prefix+"chk_flg") = "0";
					return false;
				}
			}
		}	
		return true;
	}
	
	function t1sheet1_calcAppExtCost(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		ComOpenWait(true);
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			formObj.man_usd_amt.value = "";
    		formObj.calc_app_ext_cost.value = "";
    		formObj.total_sum_cost.value = "";
			if(sheetObj.CellValue(i, prefix+"ibflag") == "I" || sheetObj.CellValue(i, prefix+"ibflag") == "U"){
				//20ft
				if(sheetObj.CellValue(i, prefix+"man_usd_amt_20ft") != ""){
					formObj.man_usd_amt.value = sheetObj.CellValue(i, prefix+"man_usd_amt_20ft");
				}else{
					if(sheetObj.CellValue(i, prefix+"auto_usd_amt_20ft") == ""){
						ComShowCodeMessage('TES90113'); //Please input [Unit Cost Manual] to calculate handling cost.
						break;
					}else{
						formObj.man_usd_amt.value = sheetObj.CellValue(i, prefix+"auto_usd_amt_20ft");
					}	
				}
				//total값 있을경우
				if(sheetObj.CellValue(i, prefix+"ttl_usd_amt_20ft") != ""){
					sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"ttl_usd_amt_20ft")*1 - formObj.man_usd_amt.value*1;
					sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"ttl_usd_amt_20ft");
				}else{
					//ratio도 있고 extra cost 있을경우
    				if(sheetObj.CellValue(i, prefix+"aply_rto") != ""){
    					sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft") = ((sheetObj.CellValue(i, prefix+"aply_rto")*1)*0.01) * formObj.man_usd_amt.value*1;
						sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = formObj.man_usd_amt.value*1 + (((sheetObj.CellValue(i, prefix+"aply_rto")*1)*0.01) * formObj.man_usd_amt.value*1);
    					if(sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft") != ""){
    						sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft")*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft")*1 ;
    						sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft")*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft")*1 ;
	    				}
    				}else{
    					//ratio 없고 extra cost 있을경우
    					if(sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft") != ""){
    						sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft") ;
    						sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = formObj.man_usd_amt.value*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_20ft")*1 ;
	    				}else{
	    					//ratio 없고 extra cost 도 없을경우
	    					sheetObj.CellValue(i, prefix+"calc_usd_amt_20ft") = "0";
		    				sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = formObj.man_usd_amt.value;
	    				}
    				}
				}
				
				//40ft
				if(sheetObj.CellValue(i, prefix+"man_usd_amt_40ft") != ""){
					formObj.man_usd_amt.value = sheetObj.CellValue(i, prefix+"man_usd_amt_40ft");
				}else{
					if(sheetObj.CellValue(i, prefix+"auto_usd_amt_40ft") == ""){
						ComShowCodeMessage('TES90113'); //Please input [Unit Cost Manual] to calculate handling cost.
						break;
					}else{
						formObj.man_usd_amt.value = sheetObj.CellValue(i, prefix+"auto_usd_amt_40ft");
					}	
				}
				//total값 있을경우
				if(sheetObj.CellValue(i, prefix+"ttl_usd_amt_40ft") != ""){
					sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"ttl_usd_amt_40ft")*1 - formObj.man_usd_amt.value*1;
					sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"ttl_usd_amt_40ft");
				}else{
					//ratio도 있고 extra cost 있을경우
    				if(sheetObj.CellValue(i, prefix+"aply_rto") != ""){
    					sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft") = ((sheetObj.CellValue(i, prefix+"aply_rto")*1)*0.01) * formObj.man_usd_amt.value*1;
						sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = formObj.man_usd_amt.value*1 + (((sheetObj.CellValue(i, prefix+"aply_rto")*1)*0.01) * formObj.man_usd_amt.value*1);
    					if(sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft") != ""){
    						sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft")*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft")*1 ;
    						sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft")*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft")*1 ;
	    				}
    				}else{
    					//ratio 없고 extra cost 있을경우
    					if(sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft") != ""){
    						sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft") ;
    						sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = formObj.man_usd_amt.value*1 + sheetObj.CellValue(i, prefix+"fml_usd_amt_40ft")*1 ;
	    				}else{
	    					//ratio 없고 extra cost 도 없을경우
	    					sheetObj.CellValue(i, prefix+"calc_usd_amt_40ft") = "0";
		    				sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = formObj.man_usd_amt.value;
	    				}
    				}
				}
			}
		}
		ComOpenWait(false);
	}
	
	function t2sheet1_calcAppExtCost(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		var formObj = document.form;
		ComOpenWait(true);
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			formObj.man_usd_amt.value = "";
			if(sheetObj.CellValue(i, prefix+"ibflag") == "I" || sheetObj.CellValue(i, prefix+"ibflag") == "U"){
				//20ft
				if(sheetObj.CellValue(i, prefix+"man_usd_amt_20ft") != ""){
					sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"man_usd_amt_20ft");
				}else if(sheetObj.CellValue(i, prefix+"auto_usd_amt_20ft") != ""){
					sheetObj.CellValue(i, prefix+"sum_usd_amt_20ft") = sheetObj.CellValue(i, prefix+"auto_usd_amt_20ft");
				}
				
				//40ft
				if(sheetObj.CellValue(i, prefix+"man_usd_amt_40ft") != ""){
					sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"man_usd_amt_40ft");
				}else if(sheetObj.CellValue(i, prefix+"auto_usd_amt_40ft") != ""){
					sheetObj.CellValue(i, prefix+"sum_usd_amt_40ft") = sheetObj.CellValue(i, prefix+"auto_usd_amt_40ft");
				}
			}
		}
		ComOpenWait(false);
	}
    
	function t2sheet1_chkDefaultCond(sheetObj){
		var prefix = sheetObj.id + "_";
		var headCnt = sheetObj.HeaderRows;
		for(var i=headCnt; i<=sheetObj.LastRow; i++){
			if(sheetObj.CellValue(i, prefix+"cond_no") == "0" && sheetObj.CellValue(i, prefix+"tml_awk_ts_cd") != "A" && sheetObj.CellValue(i, prefix+"io_bnd_cd") != "A" && sheetObj.CellValue(i, prefix+"io_ga_cd") != "A"){
				ComShowCodeMessage('TES90119'); //Tariff Condition must be selected./n Plz, select Tariff Condition.
				sheetObj.RowBackColor(i) = sheetObj.RgbColor(255, 217, 250);
				return false;
			}
		}
		return true;
	}	
	
	function setTmnlCombo(xmlStr){
		var formObj = document.form;
		var tmlCd = ComGetEtcData(xmlStr,"tml_cd");
		tmlCd = (" |"+ tmlCd).split("|");
		appendMultiComboItem(getComboObject("tml_cd_combo"), tmlCd, tmlCd, "");
	}
	
    /**
    * combo id 로 해당 comboObject를 찾아 반환한다.
    * @param comboId
    * @return
    */
   function getComboObject(comboId){
   	var cnt = comboObjects.length;
   	if(cnt > 0){
   		for(var i=0; i<cnt; i++){
   			if(comboObjects[i].id == comboId){
   				return comboObjects[i];
   			}
   		}
   	}
   	return null;
   }
	
 	/**
	 * Mutil Combo에 item을 추가한다.
	 * @param comboObj
	 * @param optionCds
	 * @param optionTxts
	 * @param selCode
	 * @return
	 */
	function appendMultiComboItem(comboObj, optionCdArr, optionDescArr, selCode){
		comboObj.RemoveAll();
		if(optionCdArr != null){
			for(var i=0; i<optionCdArr.length; i++) {
				comboObj.InsertItem(i, optionDescArr[i]);
			}
			comboObj.Code2 = selCode;
		}
	}
	

	/* 개발자 작업  끝 */