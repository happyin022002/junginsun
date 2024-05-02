/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_3001.js
*@FileTitle : EUR Hinterland Cost Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.03 변종건 [CHM-201217633] AGMT INQ 버튼 및 기능 추가
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
     * @class ESD_TRS_3001 : esd_trs_3001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_3001() {
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
	var tabCnt = 0 ;
	var beforetab = 1;
	var tabNowCnt = 0;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0]; //sheet1
         var sheetObject2 = sheetObjects[1]; //sheet2
         var sheetObject3 = sheetObjects[2]; //sheet3
		 
         /*******************************************************/
         var formObject = document.form;
 		 var objs = document.all.item("tabLayer");
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, true);   //tab1
						break;

					case "btn_save":
						ComOpenWait(true, true);
						setTimeout("getBtnSave();ComOpenWait(false);", 100);
						break;
						
					case "btn2_save":
						ComSetObjValue(formObject.in_btn_sts, "S");
						doActionIBSheet(sheetObject2, formObject, MULTI02, true);   //tab2
						break;

					case "btn_apply":
						if( objs[0].style.display == "inline" ){
				            ComOpenWait(true, true);
				            setTimeout("getCostAdjustmentTransCal();ComOpenWait(false);", 100);
						}
						break;

					case "btn_reset":
						initForm();
						break;

					case "btn_confirm":
						ComSetObjValue(formObject.in_btn_sts, "C");
						if( sheetObject1.RowCount < 1 ){
							ComShowCodeMessage("TRS90428");
						}else{
							ComOpenWait(true);
							if( objs[0].style.display == "inline" ){
								var idxRow1 = sheetObject1.FindText("loc_grp_no", "");
								if(idxRow1 > -1){
									ComShowCodeMessage("TRS90421");
									ComOpenWait(false);
				            		break;
								}
							}else if( objs[1].style.display == "inline" ){
								//중복체크
								/*
				            	var idxDub = sheetObject2.ColValueDup("trsp_crr_mod_cd|cntr_sz_cd");
				            	if(idxDub > -1){
				            		ComShowCodeMessage("COM12115","[Trans Mode / EQ Size]");
				            		sheetObject2.SelectCell(idxDub, "trsp_crr_mod_cd", true);
									ComOpenWait(false);
				            		break;
				            	}*/
								
								var idxRow1 = sheetObject1.FindText("loc_grp_no", "");
								if(idxRow1 > -1){
									ComShowCodeMessage("TRS90421");
									ComOpenWait(false);
				            		break;
								}
							}
							
							if(ComShowConfirm(ComGetMsg("TRS90422"))){
								doActionIBSheet(sheetObject1, formObject, MULTI01, false);   //tab1
								doActionIBSheet(sheetObject2, formObject, MULTI02, false);   //tab2
								doActionIBSheet(sheetObject1, formObject, MULTI03, false);
							}
							ComOpenWait(false);
						}
						break;
						
					case "btn_confirm_cancel":
						if( sheetObject1.RowCount < 1 ){
							ComShowCodeMessage("TRS90428");
						}else{
							if(ComShowConfirm(ComGetMsg("TRS90437"))){
								doActionIBSheet(sheetObject1, formObject, MULTI04, false);
							}
						}
						break;						
						
					case "btn_down_excel":
						if( objs[0].style.display == "inline" ){
							sheetObject1.SpeedDown2Excel(1);
						}
						break;

					case "btn_load_excel":
						if(sheetObject1.RowCount < 1){
							ComShowCodeMessage("TRS90390");
							break;
						}
						
						if( objs[0].style.display == "inline" ){
							ComOpenWait(true);
							sheetObject3.RemoveAll();
							
							var vLoadFlg = sheetObject3.LoadExcel(-1, 1, "", 1, -1, "", true, false);
							if(vLoadFlg){
								setSheetObject1(sheetObject1, sheetObject3);
							}else{
								ComOpenWait(false);	
							}
						}
						break;

					case "btn_cnt_cd":
						ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 480, 'getInCntCd', "1,0,1,1,1,1,1,1,1,1,1,1", true);
						break;

					case "btn_route_detail":
						popUpCall("ESD_TRS_3002",true);
						break;
						
					case "btn_cost_detail":
						if( sheetObject1.RowCount > 0 ){
							var param = "";
							param = param + '?cost_trf_no='+sheetObject1.CellValue(sheetObject1.SelectRow,"cost_trf_no");
							param = param + '&cost_trf_rout_seq='+sheetObject1.CellValue(sheetObject1.SelectRow,"cost_trf_rout_seq");
							param = param + '&io_bnd_nm='+formObject.io_bnd_nm.value;
							param = param + '&rd_term='+sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm");
							param = param + '&curr_cd='+formObject.curr_cd.value;
							param = param + '&ttlAmt20='+sheetObject1.CellValue(sheetObject1.SelectRow,"inlnd_20ft_ttl_amt");
							param = param + '&ttlAmt40='+sheetObject1.CellValue(sheetObject1.SelectRow,"inlnd_40ft_ttl_amt");
							param = param + '&port_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd");
							param = param + '&hub_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd");
							param = param + '&loc_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd");
							param = param + '&trns_mode='+sheetObject1.CellValue(sheetObject1.SelectRow,"trsp_crr_mod_cd");
							
							ComOpenPopup('/hanjin/ESD_TRS_3005.do' + param, 1024,620,'', '1,0,1,1,1,1,1,1');
						}
						break;
						
					case "btn_agmt_inq":
						//그리드 데이터 없을 경우
						if( sheetObject1.RowCount <= 0 ){
							ComShowCodeMessage("COM130401");
							return;
						}
						
						var param = "";
						if( document.form.io_bnd_cd.value == "O" && sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm") == "Door" ){
							param = param + '?door=' + sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd").substr(0,5);
							param = param + '&via=' + sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd").substr(0,5);
							param = param + '&to=' + sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd").substr(0,5);
						} else if( document.form.io_bnd_cd.value == "O" && sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm") == "CY" ){
							param = param + '?from=' + sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd").substr(0,5);
							param = param + '&via=' + sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd").substr(0,5);
							param = param + '&to=' + sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd").substr(0,5);
						} else if( document.form.io_bnd_cd.value == "I" && sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm") == "Door" ){
							param = param + '?from=' + sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd").substr(0,5);
							param = param + '&via=' + sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd").substr(0,5);
							param = param + '&door=' + sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd").substr(0,5);
						} else if( document.form.io_bnd_cd.value == "I" && sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm") == "CY" ){
							param = param + '?from=' + sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd").substr(0,5);
							param = param + '&via=' + sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd").substr(0,5);
							param = param + '&to=' + sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd").substr(0,5);
						}
						if( sheetObject1.CellValue(sheetObject1.SelectRow,"n2nd_vndr_seq") != "" ){
							if( sheetObject1.CellValue(sheetObject1.SelectRow,"n1st_vndr_seq") == sheetObject1.CellValue(sheetObject1.SelectRow,"n2nd_vndr_seq") ){
								param = param + '&vndr_seq=' + sheetObject1.CellValue(sheetObject1.SelectRow,"n1st_vndr_seq");
								param = param + '&vndr_nm=' + sheetObject1.CellValue(sheetObject1.SelectRow,"n1st_vndr_nm");
							}
						} else{
							param = param + '&vndr_seq=' + sheetObject1.CellValue(sheetObject1.SelectRow,"n1st_vndr_seq");
							param = param + '&vndr_nm=' + sheetObject1.CellValue(sheetObject1.SelectRow,"n1st_vndr_nm");
						}
							
						var sUrl = "/hanjin/ESD_TRS_0231.do";
						var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
						window.open(sUrl + param, "ESD_TRS_0231", myOption);
						break;
						
					case "btn_loc_group":
						if( sheetObject1.RowCount > 0 ){
							var param = "";
							param = param + '?cnt_cd='+formObject.in_cnt_cd.value;
							param = param + '&cost_trf_no='+comboObjects[0].Code;
							param = param + '&io_bnd_nm='+formObject.io_bnd_nm.value;
							param = param + '&sts_nm='+formObject.cost_trf_sts_nm.value;
							param = param + '&curr_cd='+formObject.curr_cd.value;
							param = param + '&eff_fm_dt='+formObject.eff_fm_dt.value;
							param = param + '&upd_dt='+formObject.upd_dt.value;
							param = param + '&upd_usr_id='+formObject.upd_usr_id.value;
							
							ComOpenPopup('/hanjin/ESD_TRS_3018.do' + param, 560,580,'', '1,0,1,1,1,1,1,1', true);
						}
						break;

					case "btn2_down_excel":
						sheetObject2.Down2Excel(-1);
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;
    }

    /**
     * Combo Object를 배열로 등록
     */    
	function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }

		initControl();

		var formObj = document.form;
		if(!ComIsEmpty(formObj.trf_no.value))
		{
			setCostTariffNoMultiCombo(1);
		}
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
		
		//가져온 행을 배열로 반든다.
		var arrRow = f_trns_mode_cdCode.split("|");
		var arrRow2Code = f_sys_src_cdCode.split("|");
		var arrRow2Text = f_sys_src_cdText.split("|");
		
   	    switch(comboObj.id) {
			case "co_trans20":
			case "co_trans40":
			case "co_tmnl20":
			case "co_tmnl40":  
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					comboObj.Code = "R";
				}
				break;
				
			case "co_mty20":
			case "co_mty40":
				with(comboObj) {
					InsertItem(i++, "%", "R");
					InsertItem(i++, "Flat", "F");
					InsertItem(i++, "-SYS AMT", "S");					
					comboObj.Code = "R";
				}
				break;
				
			case "co_tran_mode":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow.length; j++){
						InsertItem(i++,  arrRow[j],  arrRow[j]);
					}
					comboObj.Code = "^";
	        	}
				break;
				
			case "co_trans20_src":
			case "co_mty20_src":
			case "co_tmnl20_src":
			case "co_trans40_src":
			case "co_mty40_src":
			case "co_tmnl40_src":			
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "^");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "^";
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
		var sheetID = sheetObj.id;
        switch(sheetID) {
        	case "sheet1":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 315;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||Port-LOC|Port|Hub|LOC|Empty\nPU/RTN|R/D\nTerm|Trans\nMode|Total Cost|Total Cost|LOC\nGroup|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'";
					HeadTitle1 += "|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|1st Link|1st Link|Com-\nbined|2nd Link|2nd Link|OLD\nAGMT|Load Excel\nValidation|cost_trf_rout_seq|cost_rout_grp_no|cnt_cd|cost_trf_no";

					var HeadTitle2 = "Flag||Port-LOC|Port|Hub|LOC|Empty\nPU/RTN|R/D\nTerm|Trans\nMode|20'|40'|LOC\nGroup|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS2|Total|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS4|Total|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|S/P\nCode|S/P\nName|Com-\nbined|S/P\nCode|S/P\nName|OLD\nAGMT|Load Excel\nValidation|cost_trf_rout_seq|cost_rout_grp_no|cnt_cd|cost_trf_no";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true,	"del_chk",				false, "", dfNone, 0, true,	true);
					InitDataProperty(0, cnt++, dtData,	90, daCenter, true,	"port_loc",                  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"port_nod_cd",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"hub_nod_cd",                	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"loc_nod_cd",                	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"mty_pkup_rtn_yd_cd",          	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true,	"rcv_de_term_nm",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true,	"trsp_crr_mod_cd",           	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daRight, true,	"inlnd_20ft_ttl_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daRight, true,	"inlnd_40ft_ttl_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"loc_grp_no",                	false, "", dfNone, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"scc_cd",                    	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daRight, true,	"mb_20ft_rto",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daRight, true,	"mb_40ft_rto",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_20ft_cost_sys_src_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_20ft_cost_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"trsp_20ft_adj_cost_amt",    	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_20ft_ttl_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_agmt_20ft_mty_yd_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	50, daCenter, true,	"trsp_diff_20ft", 				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"agmt_wgt_20ft",                false, "", dfNone, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_rate_type_20ft", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_40ft_cost_sys_src_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_40ft_cost_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"trsp_40ft_adj_cost_amt",    	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_40ft_ttl_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_agmt_40ft_mty_yd_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	50, daCenter, true,	"trsp_diff_40ft", 				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"agmt_wgt_40ft",                false, "", dfNone, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_rate_type_40ft", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"mty_trsp_20ft_cost_sys_src_cd",false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_20ft_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"mty_trsp_20ft_adj_cost_amt",	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_20ft_ttl_cost_amt",	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"mty_trsp_40ft_cost_sys_src_cd",false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_40ft_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"mty_trsp_40ft_adj_cost_amt",	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_40ft_ttl_cost_amt",	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"tml_20ft_cost_sys_src_cd",  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_20ft_cost_amt",         	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"tml_20ft_adj_cost_amt",     	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_20ft_ttl_cost_amt",     	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"tml_40ft_cost_sys_src_cd",  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_40ft_cost_amt",         	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"tml_40ft_adj_cost_amt",     	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_40ft_ttl_cost_amt",     	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"n1st_vndr_seq",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	120,daLeft, true,	"n1st_vndr_nm",              	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"inlnd_rout_cmb_flg",        	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"n2nd_vndr_seq",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	120,daLeft, true,	"n2nd_vndr_nm",              	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 	50, daCenter, true,	"agmt_old_flg", 				false, "", dfNone, 0, false, true);					
					InitDataProperty(0, cnt++, dtData, 	70, daCenter, true,	"load_excel", 					false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_trf_rout_seq",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_rout_grp_no",				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cnt_cd",						false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_trf_no",					false, "", dfNone, 0, false, true);
					
					InitDataValid(0, "loc_grp_no", vtNumericOnly);
					
					InitDataCombo(0, "trsp_20ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
					InitDataCombo(0, "trsp_40ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
					InitDataCombo(0, "mty_trsp_20ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
					InitDataCombo(0, "mty_trsp_40ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
					InitDataCombo(0, "tml_20ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
					InitDataCombo(0, "tml_40ft_cost_sys_src_cd", f_sys_src_cdText, f_sys_src_cdCode);
				}
				break;

            case "sheet2":
                with (sheetObj) {
					// 높이 설정
                    style.height = 315;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag|Trans\nMode|EQ\nSize|Reefer|Reefer|Reefer|DG|DG|DG|Overweight (Ton)|Overweight (Ton)|Overweight (Ton)|Overweight (Ton)|Overweight (Ton)|cost_trf_no";
					var HeadTitle2 = "Flag|Trans\nMode|EQ\nSize|SVC|Fixed|%|SVC|Fixed|%|SVC|From|To|Fixed|%|cost_trf_no";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);


                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,	daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++, dtData, 	95, daCenter, true,	"trsp_crr_mod_cd", 	false,  "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	95, daCenter, true,	"cntr_sz_cd", 		false,  "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true,	"rc_svc_flg", 		false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"rf_fx_rt", 		false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"rf_fx_rto", 		false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true,	"dcgo_svc_flg", 	false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"dg_fx_rt",			false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"dg_fx_rto", 		false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtCombo, 60, daCenter, true,	"ovwt_cgo_svc_flg", false, "", dfNone, 0, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"min_cgo_wgt", 		false, "", dfFloat, 2, true, true, 7);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"max_cgo_wgt", 		false, "", dfFloat, 2, true, true, 7);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"ovr_wgt_fx_rt", 	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData, 	75, daRight, true,	"ovr_wgt_fx_rto", 	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_trf_no", 		false, "", dfNone, 0, false, true);
					
					InitDataCombo(0, "rc_svc_flg", 		"Y|N", "Y|N");
					InitDataCombo(0, "dcgo_svc_flg",	"Y|N", "Y|N");
					InitDataCombo(0, "ovwt_cgo_svc_flg","Y|N", "Y|N");
				}
				break;

        	case "sheet3":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 300;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag||Port-LOC|Port|Hub|LOC|Empty\nPU/RTN|R/D\nTerm|Trans\nMode|Total Cost|Total Cost|LOC\nGroup|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'|Full Trans Cost 20'";
					HeadTitle1 += "|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'|Full Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|1st Link|1st Link|Com-\nbined|2nd Link|2nd Link|OLD\nAGMT|Load Excel\nValidation|cost_trf_rout_seq|cost_rout_grp_no|cnt_cd|cost_trf_no";

					var HeadTitle2 = "Flag||Port-LOC|Port|Hub|LOC|Empty\nPU/RTN|R/D\nTerm|Trans\nMode|20'|40'|LOC\nGroup|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS2|Total|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS4|Total|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|S/P\nCode|S/P\nName|Com-\nbined|S/P\nCode|S/P\nName|OLD\nAGMT|Load Excel\nValidation|cost_trf_rout_seq|cost_rout_grp_no|cnt_cd|cost_trf_no";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,	30,		daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, dtCheckBox, 30, daCenter, true,	"del_chk",				false, "", dfNone, 0, true,	true);
					InitDataProperty(0, cnt++, dtData,	90, daCenter, true,	"port_loc",                  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"port_nod_cd",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"hub_nod_cd",                	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"loc_nod_cd",                	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daCenter, true,	"mty_pkup_rtn_yd_cd",          	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true,	"rcv_de_term_nm",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daCenter, true,	"trsp_crr_mod_cd",           	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daRight, true,	"inlnd_20ft_ttl_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	65, daRight, true,	"inlnd_40ft_ttl_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"loc_grp_no",                	false, "", dfNone, 0, true, true, 5);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"scc_cd",                    	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daRight, true,	"mb_20ft_rto",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	50, daRight, true,	"mb_40ft_rto",               	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_20ft_cost_sys_src_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_20ft_cost_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"trsp_20ft_adj_cost_amt",    	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_20ft_ttl_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_agmt_20ft_mty_yd_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"agmt_wgt_20ft",                false, "", dfNone, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	50, daCenter, true,	"trsp_diff_20ft", 				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_rate_type_20ft", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_40ft_cost_sys_src_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_40ft_cost_amt",        	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"trsp_40ft_adj_cost_amt",    	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"trsp_40ft_ttl_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_agmt_40ft_mty_yd_cd", 	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	50, daCenter, true,	"trsp_diff_40ft", 				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"agmt_wgt_40ft",                false, "", dfNone, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"trsp_rate_type_40ft", 			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"mty_trsp_20ft_cost_sys_src_cd",false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_20ft_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"mty_trsp_20ft_adj_cost_amt",	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_20ft_ttl_cost_amt",	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"mty_trsp_40ft_cost_sys_src_cd",false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_40ft_cost_amt",    	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"mty_trsp_40ft_adj_cost_amt",	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"mty_trsp_40ft_ttl_cost_amt",	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"tml_20ft_cost_sys_src_cd",  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_20ft_cost_amt",         	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"tml_20ft_adj_cost_amt",     	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_20ft_ttl_cost_amt",     	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtCombo,	60, daCenter, true,	"tml_40ft_cost_sys_src_cd",  	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_40ft_cost_amt",         	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	70, daRight, true,	"tml_40ft_adj_cost_amt",     	false, "", dfFloat, 2, true, true);
					InitDataProperty(0, cnt++, dtData,	60, daRight, true,	"tml_40ft_ttl_cost_amt",     	false, "", dfFloat, 2, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"n1st_vndr_seq",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	120,daLeft, true,	"n1st_vndr_nm",              	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"inlnd_rout_cmb_flg",        	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	60, daCenter, true,	"n2nd_vndr_seq",             	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData,	120,daLeft, true,	"n2nd_vndr_nm",              	false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtData, 	50, daCenter, true,	"agmt_old_flg", 				false, "", dfNone, 0, false, true);					
					InitDataProperty(0, cnt++, dtData, 	70, daCenter, true,	"load_excel", 					false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_trf_rout_seq",			false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_rout_grp_no",				false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cnt_cd",						false, "", dfNone, 0, false, true);
					InitDataProperty(0, cnt++, dtHidden,75, daCenter, true,	"cost_trf_no",					false, "", dfNone, 0, false, true);
				}
				break;
        }
    }

	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "trsp_20ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		}else if (sName == "trsp_40ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))			
		}else if (sName == "mty_trsp_20ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		}else if (sName == "mty_trsp_40ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))
		}else if (sName == "tml_20ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "tml_20ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_20ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_20ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_20ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_20ft_ttl_cost_amt"))
		}else if (sName == "tml_40ft_adj_cost_amt") {
			sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt") = parseFloat(sheetObj.CellValue(Row, "tml_40ft_cost_amt")) + parseFloat(sheetObj.CellValue(Row, "tml_40ft_adj_cost_amt"));
			sheetObj.CellValue(Row, "inlnd_40ft_ttl_amt") = parseFloat(sheetObj.CellValue(Row, "trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "mty_trsp_40ft_ttl_cost_amt"))+ parseFloat(sheetObj.CellValue(Row, "tml_40ft_ttl_cost_amt"))
		}else if (sName == "loc_grp_no") {
			if( Value != "" ){
				if( Value.length > 3 ) Value = Value.substr(0,3);
				var strLen = Value.length;
				for( var idx = 0; idx < 3 - strLen; idx++ ){
					Value = "0" + Value;
				}
				sheetObj.CellValue2(Row, "loc_grp_no") = formObj.in_cnt_cd.value + Value;
			}
		}
	}
	
	function sheet2_OnChange(sheetObj, Row, Col, Value){
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "rf_fx_rt") {
			if( sheetObj.CellValue(Row, "rf_fx_rto") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "rf_fx_rt") = 0;
			}
		}else if (sName == "rf_fx_rto") {
			if( sheetObj.CellValue(Row, "rf_fx_rt") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "rf_fx_rto") = 0;
			}
		}else if (sName == "dg_fx_rt") {
			if( sheetObj.CellValue(Row, "dg_fx_rto") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "dg_fx_rt") = 0;
			}
		}else if (sName == "dg_fx_rto") {
			if( sheetObj.CellValue(Row, "dg_fx_rt") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "dg_fx_rto") = 0;
			}
		}else if (sName == "ovr_wgt_fx_rt") {
			if( sheetObj.CellValue(Row, "ovr_wgt_fx_rto") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "ovr_wgt_fx_rt") = 0;
			}
		}else if (sName == "ovr_wgt_fx_rto") {
			if( sheetObj.CellValue(Row, "ovr_wgt_fx_rt") != 0 ){
				ComShowCodeMessage("TRS90420");
				sheetObj.CellValue2(Row, "ovr_wgt_fx_rto") = 0;
			}
		}
	}
	
	function sheet1_OnDblClick(sheetObj,Row,Col){
		popUpCall("ESD_TRS_3002",false);
	}

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, msgFlg) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = SEARCH;
		        	var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESD_TRS_3001GS.do", sParam);
					var arrXml = sXml.split("|$$|");
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[1].LoadSearchXml(arrXml[1]);
					initForm();
				}	
				break;

			case MULTI01: //Dry Save
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = MULTI01;
					var sParam =  ComGetSaveString(sheetObj, true, false);
					if( sParam == ""){ return;}
					var sXml = sheetObj.GetSaveXml("ESD_TRS_3001GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
	    			var vCnt = ComGetEtcData(sXml, "cnt");
					sheetObj.LoadSaveXml(sXml);
					if(msgFlg){
						if(vCnt > 0){
							ComShowCodeMessage("TRS90419");
						}else{
							//Cost Tariff No Info 생성
							setCostTariffNoInfo();
						}
					} 
				}	
				break;

			case MULTI02: //Special Save
				if(validateForm(sheetObj,formObj,sAction, msgFlg)){
					formObj.f_cmd.value = MULTI02;
					var sParam =  ComGetSaveString(sheetObj, true, true);
					if( sParam == ""){ return;}
					var sXml = sheetObj.GetSaveXml("ESD_TRS_3001GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
					sheetObj.LoadSaveXml(sXml);
	    			var vCnt = ComGetEtcData(sXml, "cnt");
					if(msgFlg){
						if(vCnt > 0){
							ComShowCodeMessage("TRS90419");
						}
					}					
				}	
				break;

			case MULTI03:
				formObj.f_cmd.value = MULTI03;
				var sXml = sheetObj.GetSaveXml("ESD_TRS_3001GS.do", FormQueryString(formObj), true);
    			var vCnt = ComGetEtcData(sXml, "cnt");
				
				if(vCnt > 0){
					ComShowCodeMessage("TRS90419");
				}else{
					sheetObj.LoadSaveXml(sXml);
					
					//Cost Tariff No Info 생성
					setCostTariffNoInfo();
				}
				break;				

			case MULTI04:
				formObj.f_cmd.value = MULTI04;
				var sXml = sheetObj.GetSaveXml("ESD_TRS_3001GS.do", FormQueryString(formObj), true);
				sheetObj.LoadSaveXml(sXml);
				//Cost Tariff No Info 생성
				setCostTariffNoInfo();
				break;				
		
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction, msgFlg){
		switch (sAction) {
			case IBSEARCH:
        		if( ComIsEmpty(formObj.in_cnt_cd.value) )
        		{
        			ComShowCodeMessage("COM130201", "Country Code");
        			ComAlertFocus(formObj.in_cnt_cd, "");
        			return false;
        		} else if( comboObjects[0].Code == "" ){
        			ComShowCodeMessage("COM12113", "Cost Tariff No");
        			ComAlertFocus(formObj.in_cost_trf_no, "");
        			return false;
				}
        		
        		if( beforetab == 0 ){
        			var stsCnt = sheetObjects[0].RowCount("I") + sheetObjects[0].RowCount("U") + sheetObjects[0].RowCount("D");
        		} else{
        			var stsCnt = sheetObjects[1].RowCount("I") + sheetObjects[1].RowCount("U") + sheetObjects[1].RowCount("D");
        		}
        		
        		if( stsCnt > 0 ){
	        		if( !ComShowCodeConfirm("TRS90447", "Adjusted data will not be saved if you click “OK”") ){
		    			return false;
		    		}
        		}
				break;

			case MULTI01:
				if(msgFlg){
					if( sheetObj.RowCount < 1 ){
						ComShowCodeMessage("COM130503");
						return false;
					}
				}
				break;

			case MULTI02:
				if(msgFlg){
					if( sheetObj.RowCount < 1 ){
						ComShowCodeMessage("COM130503");
						return false;
					}
					/*
					else{
						//중복체크
		            	var idxDub = sheetObj.ColValueDup("trsp_crr_mod_cd|cntr_sz_cd");
		            	if(idxDub > -1){
		            		ComShowCodeMessage("COM12115","[Trans Mode / EQ Size]");
		            		sheetObj.SelectCell(idxDub, "trsp_crr_mod_cd", true);
		            		return false;
		            	}
					}*/
				}
				break;
		}
        return true;
    }

	function in_cost_trf_no_OnKeyDown(combo, keycode, shift){
		var formObj = document.form;
		var objs = document.all.item("tabLayer");
		if(keycode == 13){
			if(comboObjects[0].Code != "" ){
				//if( objs[0].style.display == "inline" ){
					doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);   //tab1
				//}else if( objs[1].style.display == "inline" ){
					doActionIBSheet(sheetObjects[1], formObj, IBSEARCH, true);   //tab2
				//}				
			}
		}
	}
	
	function getInCntCd(rowArray) {
		var colArray = rowArray[0];
		document.form.in_cnt_cd.value = colArray[3];

		//Cost Tariff No MultiCombo 생성
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObjects[2].GetSearchXml("ESD_TRS_3001GS.do", sParam);
		ComXml2ComboItem(sXml, comboObjects[0], "cost_trf_no", "cost_trf_no");
	}
	
    function in_cost_trf_no_OnChange(comObj, index, text)
    {
		//Cost Tariff No Info 생성
		setCostTariffNoInfo();

		sheetObjects[0].RemoveAll();
		sheetObjects[1].RemoveAll();
    }
	
    function co_mty20_OnChange(comObj, index, text)
    {
		var formObj = document.form;
		if(text == "-SYS AMT"){
			formObj.in_mty20.value = "";
			formObj.in_mty20.className = "input2";
			formObj.in_mty20.readOnly = true;
		}else{
			formObj.in_mty20.value = "";
			formObj.in_mty20.className = "input";
			formObj.in_mty20.readOnly = false;
		}
    }
	
    function co_mty40_OnChange(comObj, index, text)
    {
		var formObj = document.form;
		if(text == "-SYS AMT"){
			formObj.in_mty40.value = "";
			formObj.in_mty40.className = "input2";
			formObj.in_mty40.readOnly = true;
		}else{
			formObj.in_mty40.value = "";
			formObj.in_mty40.className = "input";
			formObj.in_mty40.readOnly = false;
		}
    }
		
    /* initControl() */
    function initControl() {
    	axon_event.addListenerFormat('keypress', 'obj_keypress', form);
    	axon_event.addListenerForm('blur', 'obj_deactivate', form);
    }
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
        	case "float":
        		ComKeyOnlyNumber(event.srcElement, "-.");
            	break;
     	}
    }    
    
    //업무 자바스크립트 Onblur 이벤트 처리
    function obj_deactivate(){
     	var elementObj = event.srcElement;
		var formObj = document.form;
		
        //입력Validation 확인 및 마스킹 처리
        //ComChkObjValid(event.srcElement);
    	switch(elementObj.name){ 	    	
    		case "in_cnt_cd":
    			if(!isNull(elementObj.value)){
    				if(elementObj.maxLength != elementObj.value.length){
						ComClearObject(formObj.in_cnt_cd);	
						ComShowCodeMessage("COM132201", "Country Code");
						ComSetFocus(formObj.in_cnt_cd);
    				}else{
						formObj.f_cmd.value = SEARCH04;
						var sXml = sheetObjects[2].GetSaveXml("ESD_TRS_3001GS.do", FormQueryString(formObj), true);
	    				var vCnt = ComGetEtcData(sXml, "cnt");
						if(vCnt == 0){
							ComSetObjValue(formObj.io_bnd_cd, "");
							ComSetObjValue(formObj.io_bnd_nm, "");
							ComSetObjValue(formObj.cost_trf_sts_nm, "");
							ComSetObjValue(formObj.cost_trf_sts_cd, "");
							ComSetObjValue(formObj.curr_cd, "");
							ComSetObjValue(formObj.eff_fm_dt, "");
							ComSetObjValue(formObj.upd_dt, "");
							ComSetObjValue(formObj.upd_usr_id, "");

							ComSetObjValue(formObj.in_cnt_cd, "");
							alert("Country Code is invalid.");

							comboObjects[0].RemoveAll();
							sheetObjects[0].RemoveAll();
							sheetObjects[1].RemoveAll();

							//ComClearObject(formObj.in_cnt_cd);	
							//ComShowCodeMessage("COM132201", "Country Code");
							ComSetFocus(formObj.in_cnt_cd);
						}else{
							setCostTariffNoMultiCombo(2);
						}
					}
    			}
				else
				{
					comboObjects[0].RemoveAll();
					sheetObjects[0].RemoveAll();
					sheetObjects[1].RemoveAll();
				}
    			break;

    		case "in_trans20":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_trans20, "");
					}
    			}
    			break;
				
    		case "in_trans40":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_trans40, "");
					}
    			}
    			break;

    		case "in_mty20":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						//ComSetObjValue(formObj.in_mty20, "");
					}
    			}
    			break;
				
    		case "in_mty40":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_mty40, "");
					}
    			}
    			break;				
				
    		case "in_tmnl20":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_tmnl20, "");
					}
    			}
    			break;
				
    		case "in_tmnl40":
    			if(!isNull(elementObj.value)){
					if(elementObj.value.substring(elementObj.value.length-1, elementObj.value.length) == "-"){
						ComSetObjValue(formObj.in_tmnl40, "");
					}
    			}
    			break;				
    	}
    }
	
	//Cost Tariff No MultiCombo 생성
    function setCostTariffNoMultiCombo(trf_flg) {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH02;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObjects[2].GetSearchXml("ESD_TRS_3001GS.do", sParam);
		ComXml2ComboItem(sXml, comboObjects[0], "cost_trf_no", "cost_trf_no");
		if(trf_flg == 1){
			comboObjects[0].Code = ComGetObjValue(formObj.trf_no);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);   //tab1
		}else{
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();	
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
                    InsertTab( cnt++ , "Dry" , -1 );
                    InsertTab( cnt++ , "Special" , -1 );
                }
           		break;
         }
    }
     
    function initForm(){
		comboObjects[1].Code = "^";
		comboObjects[2].Code = "^";
		comboObjects[3].Code = "R";
		comboObjects[4].Code = "^";
		comboObjects[5].Code = "R";
		comboObjects[6].Code = "^";
		comboObjects[7].Code = "R";
		comboObjects[8].Code = "^";
		comboObjects[9].Code = "R";
		comboObjects[10].Code = "^";
		comboObjects[11].Code = "R";
		comboObjects[12].Code = "^";
		comboObjects[13].Code = "R";
					
		ComSetObjValue(document.form.in_trans20, "");
		ComSetObjValue(document.form.in_trans40, "");
		ComSetObjValue(document.form.in_mty20, "");
		ComSetObjValue(document.form.in_mty40, "");
		ComSetObjValue(document.form.in_tmnl20, "");
		ComSetObjValue(document.form.in_tmnl40, "");
    }
    
    /**
     * Pop-Up 창 호출
     * @param String url : URL 구분
     * @param boolean btnFlg : Button 클릭을 이용 여부 Flag
     */
    function popUpCall(url, btnFlg){
    	if( url == "ESD_TRS_3002" ){
    		if(sheetObjects[0].RowCount < 1){
				ComShowCodeMessage("TRS90390");
				return;
			}else{
				var param = "";
				param = param + '?cnt_cd=' + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cnt_cd");
				param = param + '&cost_trf_no=' + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cost_trf_no");
				
				if( !btnFlg ){
					param = param + '&cost_rout_grp_no=' + sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "cost_rout_grp_no");
				}
				
				var sUrl = "/hanjin/ESD_TRS_3002.do";
				var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
				window.open(sUrl + param, "ESD_TRS_3002", myOption);
			}
    	}
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택 전 탭의 변경사항 저장 유무 확인 한다.
     */
    function sheet_Save_Click(tabObj)
    {
        var formObject = document.form;
    	if(tabNowCnt > 0){
   			var beforCnt = tabNowCnt-1
    		var statsCnt = sheetObjects[beforCnt].RowCount("I") + sheetObjects[beforCnt].RowCount("U") + sheetObjects[beforCnt].RowCount("D");
			
    		if(statsCnt > 0){
    			if(ComShowCodeConfirm("COM12152", "("+tabObj.TabText(tabNowCnt-1)+")" )){
					if( beforCnt == 0){
						doActionIBSheet(sheetObjects[beforCnt], formObject, MULTI01, true);   //tab1
					}else if( beforCnt == 1){
						doActionIBSheet(sheetObjects[beforCnt], formObject, MULTI02, true);   //tab2
					}
    			}else{
					if( beforCnt == 0){
						doActionIBSheet(sheetObjects[beforCnt], formObject, IBSEARCH, true);   //tab1
					}else if( beforCnt == 1){
						doActionIBSheet(sheetObjects[beforCnt], formObject, IBSEARCH, true);   //tab2
					}
    			}
    		}	
    	}	
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");
        var formObject = document.form;

	    objs[nItem].style.display = "Inline";
	    objs[beforetab].style.display = "none";

	    //--------------- 요기가 중요 --------------------------//
	    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    //------------------------------------------------------//
	    beforetab= nItem;
        switch(nItem) {
    		case 0:
				sheet_Save_Click(tabObj);
				tabNowCnt = 1;
				if( formObject.cost_trf_sts_cd.value != "C" ){
					ComBtnEnable("btn_apply");
					ComBtnEnable("btn_reset");
				} else{
					ComBtnDisable("btn_apply");
					ComBtnDisable("btn_reset");
				}
    			break;
    		case 1:
				sheet_Save_Click(tabObj);			
				tabNowCnt = 2;
				ComBtnDisable("btn_apply");
				ComBtnDisable("btn_reset");
				
				break;
	
        }
    }

	//tabObjects[k]
    function set_err_tab(tabObj , select1, select2)
    {
        var objs = document.all.item("tabLayer");
        var formObject = document.form;

		//tabObj.SelectedIndex = 1;
		tabObjects[select1].SelectedIndex = 1;

	    objs[select1].style.display = "Inline";
	    objs[select2].style.display = "none";

        switch(select1) {
    		case 0:
				ComBtnEnable("btn_apply");
    			break;
    		case 1:
				ComBtnDisable("btn_apply");
				break;
	
        }
    }

    /**
     * sheetObject3을 sheetObject1에 복사
     */
 	function setSheetObject1(sheetObj1, sheetObj3){
 		var Row3;
 		var formObj = document.form;
 		var msgFlg = "N";
 		var msgCnt = 0;
 		
    	for(var i=sheetObj1.HeaderRows ; i<=sheetObj1.RowCount+1 ; i++){
 			sheetObj1.CellValue(i, "load_excel") = "";
 			Row3 = sheetObj3.FindText("cost_trf_rout_seq", sheetObj1.CellValue(i, "cost_trf_rout_seq"))
 			if( Row3 > -1 ){
 				msgFlg = "N";
 				sheetObj1.CellValue(i, "trsp_20ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "trsp_20ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "trsp_40ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "trsp_40ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "mty_trsp_20ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "mty_trsp_20ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "mty_trsp_40ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "mty_trsp_40ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "tml_20ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "tml_20ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "tml_40ft_adj_cost_amt") = sheetObj3.CellValue(Row3, "tml_40ft_adj_cost_amt");
 				sheetObj1.CellValue(i, "load_excel") = "OK";

 				var loc_grp_no = sheetObj3.CellValue(Row3, "loc_grp_no");
 				
 				if( ComIsNumber(loc_grp_no) ){
 					if( loc_grp_no.length > 3 ){
 						sheetObj1.CellValue(i, "load_excel") = "LOC Group Error";
 					} else{
 						sheetObj1.CellValue(i, "loc_grp_no") = loc_grp_no;
 					}
 				} else{
					if( loc_grp_no.length == 0 ){
						if( sheetObj1.CellValue(i, "trsp_20ft_adj_cost_amt") != 0
 						|| sheetObj1.CellValue(i, "trsp_40ft_adj_cost_amt") != 0
 						|| sheetObj1.CellValue(i, "mty_trsp_20ft_adj_cost_amt") != 0
 						|| sheetObj1.CellValue(i, "mty_trsp_40ft_adj_cost_amt") != 0
 						|| sheetObj1.CellValue(i, "tml_20ft_adj_cost_amt") != 0
 						|| sheetObj1.CellValue(i, "tml_40ft_adj_cost_amt") != 0 ){
							sheetObj1.CellValue(i, "load_excel") = "LOC Group Blank";
 						} else{
							sheetObj1.CellValue(i, "loc_grp_no") = loc_grp_no;
 							sheetObj1.CellValue(i, "load_excel") = "Nothing to Apply";
 							msgFlg = "Y";
 						}
 					} else if( loc_grp_no.length > 5 ){
 						sheetObj1.CellValue(i, "load_excel") = "LOC Group Error";
 					} else{
 						if (!(  ComIsAlphabet(loc_grp_no.substr(0,2)) && ComIsNumber(loc_grp_no.substr(2,4))  )) {
 							sheetObj1.CellValue(i, "load_excel") = "LOC Group Error";
 						} else if( ( (loc_grp_no.substr(0,2) != formObj.in_cnt_cd.value)) ) {
 							sheetObj1.CellValue(i, "load_excel") = "LOC Group Error";
 						} else{
 							sheetObj1.CellValue(i, "loc_grp_no") = loc_grp_no.substr(2,4);
 						}
 					}
 				}
 				
 				if( msgFlg == "N" ){
 					msgCnt++;
 				}
     		}
 		}
 		ComOpenWait(false);
 		
 		if( msgCnt == 0 ){
 			ComShowCodeMessage("TRS90432");
 		}
 	}

	function getBtnSave(){
		var formObj = document.form;
		ComSetObjValue(formObj.in_btn_sts, "S");
		doActionIBSheet(sheetObjects[0], formObj, MULTI01, true);   //tab1
	}

    /**
     * Cost Adjustment Trans 계산 적용
     */
	function getCostAdjustmentTransCal(sheetObj, formObj){
		
        var sheetObj = sheetObjects[0]; //sheet1
        var formObj  = document.form;
    	
		//Cost Adjustment Trans 입력 체크
		var in_mty20_check ;
		if( comboObjects[5].Code == "S"){
			in_mty20_check = false;
		}else{
			if(ComIsEmpty(formObj.in_mty20.value)){
				in_mty20_check = true;
			}else{
				in_mty20_check = false;
			}
		}
		
		var in_mty40_check ;
		if( comboObjects[11].Code == "S"){
			in_mty40_check = false;
		}else{
			if(ComIsEmpty(formObj.in_mty40.value)){
				in_mty40_check = true;
			}else{
				in_mty40_check = false;
			}
		}
		
		if(ComIsEmpty(formObj.in_trans20.value) && ComIsEmpty(formObj.in_trans40.value)
		   && in_mty20_check && in_mty40_check
		   && ComIsEmpty(formObj.in_tmnl20.value) && ComIsEmpty(formObj.in_tmnl40.value)
		)
		{
			ComShowCodeMessage("COM130201", "Cost Adjustment");
			return false;
		}
		
		if( comboObjects[2].Text == "" && comboObjects[4].Text == "" && comboObjects[6].Text == ""
		&& comboObjects[8].Text == "" && comboObjects[10].Text == "" && comboObjects[12].Text == "" ){
			ComShowCodeMessage("TRS90445");
			return false;
		}

		var iCheckRow = sheetObj.CheckedRows("del_chk");
		if(iCheckRow <= 0){
			ComShowCodeMessage("TRS90418", "Cost Adjustment");
			return false;
		}

		//체크된 행의 번호를 읽어온다.
		var iCheckRow = sheetObj.FindCheckedRow(1);
		//SaveName이 "del_chk"인 행에서만 체크된 행의 번호를 읽어온다.
		var iCheckRows = sheetObj.FindCheckedRow("del_chk");
		
		//가져온 행을 배열로 반든다.
		var arrRow = iCheckRows.split("|");
		for (i=0; i<arrRow.length-1; i++){
			
			//T.Mode 
			if(comboObjects[1].Code.indexOf("^") > -1  || comboObjects[1].Code.indexOf(sheetObj.CellValue(arrRow[i], "trsp_crr_mod_cd")) > -1){
			
				if(!ComIsEmpty(formObj.in_trans20.value)){
					if(comboObjects[2].Code.indexOf("^") > -1  || comboObjects[2].Code.indexOf(sheetObj.CellValue(arrRow[i], "trsp_20ft_cost_sys_src_cd")) > -1){
						var in_trans20 = formObj.in_trans20.value;
						if(comboObjects[3].Code == "R"){
							sheetObj.CellValue(arrRow[i], "trsp_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "trsp_20ft_cost_amt"))*(in_trans20/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "trsp_20ft_adj_cost_amt") = in_trans20;
						}
					}
				}
				
				if(!ComIsEmpty(formObj.in_mty20.value) || comboObjects[5].Code == "S"){
					if(comboObjects[4].Code.indexOf("^") > -1  || comboObjects[4].Code.indexOf(sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_cost_sys_src_cd")) > -1){
						var in_mty20 = formObj.in_mty20.value;
						if(comboObjects[5].Code == "S"){
							sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_adj_cost_amt") =  "-"+sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_cost_amt");
						}else if(comboObjects[5].Code == "R"){
							sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_cost_amt"))*(in_mty20/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "mty_trsp_20ft_adj_cost_amt") = in_mty20;
						}
					}
				}
				
				if(!ComIsEmpty(formObj.in_tmnl20.value)){
					if(comboObjects[6].Code.indexOf("^") > -1  || comboObjects[6].Code.indexOf(sheetObj.CellValue(arrRow[i], "tml_20ft_cost_sys_src_cd")) > -1){
						var in_tmnl20 = formObj.in_tmnl20.value;
						if(comboObjects[7].Code == "R"){
							sheetObj.CellValue(arrRow[i], "tml_20ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "tml_20ft_cost_amt"))*(in_tmnl20/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "tml_20ft_adj_cost_amt") = in_tmnl20;
						}
					}
				}
			
				if(!ComIsEmpty(formObj.in_trans40.value)){
					if(comboObjects[8].Code.indexOf("^") > -1  || comboObjects[8].Code.indexOf(sheetObj.CellValue(arrRow[i], "trsp_40ft_cost_sys_src_cd")) > -1){
						var in_trans40 = formObj.in_trans40.value;
						if(comboObjects[9].Code == "R"){
							sheetObj.CellValue(arrRow[i], "trsp_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "trsp_40ft_cost_amt"))*(in_trans40/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "trsp_40ft_adj_cost_amt") = in_trans40;
						}
					}
				}

				if(!ComIsEmpty(formObj.in_mty40.value) || comboObjects[11].Code == "S"){
					if(comboObjects[10].Code.indexOf("^") > -1  || comboObjects[10].Code.indexOf(sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_cost_sys_src_cd")) > -1){
						var in_mty40 = formObj.in_mty40.value;
						if(comboObjects[11].Code == "S"){
							sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_adj_cost_amt") =  "-"+sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_cost_amt");
						}else if(comboObjects[11].Code == "R"){
							sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_cost_amt"))*(in_mty40/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "mty_trsp_40ft_adj_cost_amt") = in_mty40;
						}
					}
				}
	
				if(!ComIsEmpty(formObj.in_tmnl40.value)){
					if(comboObjects[12].Code.indexOf("^") > -1  || comboObjects[12].Code.indexOf(sheetObj.CellValue(arrRow[i], "tml_40ft_cost_sys_src_cd")) > -1){
						var in_tmnl40 = formObj.in_tmnl40.value;
						if(comboObjects[13].Code == "R"){
							sheetObj.CellValue(arrRow[i], "tml_40ft_adj_cost_amt") = ComTrunc(parseFloat(sheetObj.CellValue(arrRow[i], "tml_40ft_cost_amt"))*(in_tmnl40/100), 2);
						}else{
							sheetObj.CellValue(arrRow[i], "tml_40ft_adj_cost_amt") = in_tmnl40;
						}
					}
				}
			}
		}
    }

    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }

    function call_esd_trs_3001(){
		var formObj = document.form;
		//Cost Tariff No Info 생성
		setCostTariffNoInfo();
    	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, true);
    }
	

	//Cost Tariff No Info 생성
    function setCostTariffNoInfo(){
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObjects[2].GetSearchXml("ESD_TRS_3001GS.do", sParam);
		
		ComSetObjValue(formObj.io_bnd_cd, ComGetEtcData(sXml, "io_bnd_cd"));
		ComSetObjValue(formObj.io_bnd_nm, ComGetEtcData(sXml, "io_bnd_nm"));
		ComSetObjValue(formObj.cost_trf_sts_cd, ComGetEtcData(sXml, "cost_trf_sts_cd"));
		ComSetObjValue(formObj.cost_trf_sts_nm, ComGetEtcData(sXml, "cost_trf_sts_nm"));
		ComSetObjValue(formObj.curr_cd, ComGetEtcData(sXml, "curr_cd"));
		ComSetObjValue(formObj.eff_fm_dt, ComGetEtcData(sXml, "eff_fm_dt"));
		ComSetObjValue(formObj.upd_dt, ComGetEtcData(sXml, "upd_dt"));
		ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(sXml, "upd_usr_id"));
		ComSetObjValue(formObj.in_cost_trf_bat_seq, ComGetEtcData(sXml, "cost_trf_bat_seq"));

		if(ComGetEtcData(sXml, "next_trf_flg") == "Y"){
			ComBtnDisable("btn_confirm_cancel");
		}else{
			ComBtnEnable("btn_confirm_cancel");
		}

		if(ComGetEtcData(sXml, "cost_trf_sts_cd") == "C"){
			formDeact();
		}else{
			formAct();
		}
		
		//Trans Mode Combo 생성
		/*
		if( ComGetObjValue(formObj.io_bnd_cd) == "O"){
			sheetObjects[1].InitDataCombo(0, "trsp_crr_mod_cd" , " |"+f_trsp_crr_mod_cd_outText , " |"+f_trsp_crr_mod_cd_outCode);
		}else{
			sheetObjects[1].InitDataCombo(0, "trsp_crr_mod_cd" , " |"+f_trsp_crr_mod_cd_inText , " |"+f_trsp_crr_mod_cd_inCode);
		}*/	
    }
	
	function formDeact(){

    	ComBtnDisable("btn_confirm");
    	ComBtnDisable("btn_apply");
    	ComBtnDisable("btn_reset");
		ComBtnDisable("btn_save");
		ComBtnDisable("btn_loc_group");
		ComBtnDisable("btn_load_excel");
		ComBtnDisable("btn2_save");
		
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("loc_grp_no"), dtData,	60, daCenter, true,	"loc_grp_no",	false, "", dfNone, 0, false, true, 5); //10
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_20ft_adj_cost_amt"), dtData,	70, daRight, true,	"trsp_20ft_adj_cost_amt", false, "", dfFloat, 2, false, true);  //16
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_40ft_adj_cost_amt"), dtData,	70, daRight, true,	"trsp_40ft_adj_cost_amt", false, "", dfFloat, 2, false, true);  //20
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), dtData,70, daRight, true,"mty_trsp_20ft_adj_cost_amt",false, "",dfFloat, 2, false, true);  //23
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), dtData,70, daRight, true,"mty_trsp_40ft_adj_cost_amt",false, "",dfFloat, 2, false, true);  //26
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_20ft_adj_cost_amt"), dtData,	70, daRight, true,	"tml_20ft_adj_cost_amt",  false, "", dfFloat, 2, false, true);  //30
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_40ft_adj_cost_amt"), dtData,	70, daRight, true,	"tml_40ft_adj_cost_amt",  false, "", dfFloat, 2, false, true);  //34
		
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("trsp_crr_mod_cd"), dtData, 95,daCenter,true,	"trsp_crr_mod_cd", 	false,  "", dfNone, 0, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("cntr_sz_cd"),  dtData,		95,daCenter,true,	"cntr_sz_cd", 		false,  "", dfNone, 0, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rc_svc_flg"), 	dtCombo, 	60, daCenter,true,	"rc_svc_flg", 		false, "", dfNone, 0, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rf_fx_rt"), 	dtData,		75, daRight, true,	"rf_fx_rt", 		false, "", dfFloat, 2, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rf_fx_rto"), 	dtData,		75, daRight, true,	"rf_fx_rto", 		false, "", dfFloat, 2, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dcgo_svc_flg"),dtCombo, 	60, daCenter,true,	"dcgo_svc_flg", 	false, "", dfNone, 0, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dg_fx_rt"), 	dtData,		75, daRight, true,	"dg_fx_rt",			false, "", dfFloat, 2, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dg_fx_rto"), 	dtData,		75, daRight, true,	"dg_fx_rto", 		false, "", dfFloat, 2, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovwt_cgo_svc_flg"),dtCombo,60, daCenter,true,	"ovwt_cgo_svc_flg", false, "", dfNone, 0, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("min_cgo_wgt"), dtData,		75, daRight, true,	"min_cgo_wgt", 		false, "", dfFloat, 2, false, true, 7);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("max_cgo_wgt"), dtData,		75, daRight, true,	"max_cgo_wgt", 		false, "", dfFloat, 2, false, true, 7);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovr_wgt_fx_rt"),dtData,	75, daRight, true,	"ovr_wgt_fx_rt", 	false, "", dfFloat, 2, false, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovr_wgt_fx_rto"),dtData,	75, daRight, true,	"ovr_wgt_fx_rto", 	false, "", dfFloat, 2, false, true);
    }
	
    function formAct(){
		
		var objs = document.all.item("tabLayer");
		
    	ComBtnEnable("btn_confirm");
		
		if( objs[0].style.display == "inline" ){
    		ComBtnEnable("btn_apply");
    		ComBtnEnable("btn_reset");
		}
		
    	ComBtnEnable("btn_save");
    	ComBtnEnable("btn_loc_group");
    	ComBtnEnable("btn_load_excel");
    	ComBtnEnable("btn2_save");
		ComBtnDisable("btn_confirm_cancel");
		
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("loc_grp_no"), dtData,	60, daCenter, true,	"loc_grp_no",	false, "", dfNone, 0, true, true, 5); //10
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_20ft_adj_cost_amt"), dtData,	70, daRight, true,	"trsp_20ft_adj_cost_amt", false, "", dfFloat, 2, true, true);  //16
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("trsp_40ft_adj_cost_amt"), dtData,	70, daRight, true,	"trsp_40ft_adj_cost_amt", false, "", dfFloat, 2, true, true);  //20
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_20ft_adj_cost_amt"), dtData,70, daRight, true,"mty_trsp_20ft_adj_cost_amt",false, "",dfFloat, 2, true, true);  //23
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("mty_trsp_40ft_adj_cost_amt"), dtData,70, daRight, true,"mty_trsp_40ft_adj_cost_amt",false, "",dfFloat, 2, true, true);  //26
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_20ft_adj_cost_amt"), dtData,	70, daRight, true,	"tml_20ft_adj_cost_amt",  false, "", dfFloat, 2, true, true);  //30
		sheetObjects[0].InitDataProperty(0, sheetObjects[0].SaveNameCol("tml_40ft_adj_cost_amt"), dtData,	70, daRight, true,	"tml_40ft_adj_cost_amt",  false, "", dfFloat, 2, true, true);  //34
		
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("trsp_crr_mod_cd"), dtData, 95,daCenter, true,"trsp_crr_mod_cd",	false,"", dfNone, 0, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("cntr_sz_cd"), 	dtData, 	95,daCenter, true,"cntr_sz_cd", 		false, "", dfNone, 0, false, false);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rc_svc_flg"), 	dtCombo, 	60, daCenter, true,	"rc_svc_flg", 		false, "", dfNone, 0, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rf_fx_rt"), 	dtData,		75, daRight, true,	"rf_fx_rt", 		false, "", dfFloat, 2, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("rf_fx_rto"), 	dtData,		75, daRight, true,	"rf_fx_rto", 		false, "", dfFloat, 2, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dcgo_svc_flg"),dtCombo, 	60, daCenter, true,	"dcgo_svc_flg", 	false, "", dfNone, 0, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dg_fx_rt"), 	dtData,		75, daRight, true,	"dg_fx_rt",			false, "", dfFloat, 2, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("dg_fx_rto"), 	dtData,		75, daRight, true,	"dg_fx_rto", 		false, "", dfFloat, 2, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovwt_cgo_svc_flg"),dtCombo,60, daCenter, true,	"ovwt_cgo_svc_flg", false, "", dfNone, 0, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("min_cgo_wgt"), dtData,		75, daRight, true,	"min_cgo_wgt", 		false, "", dfFloat, 2, true, true, 7);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("max_cgo_wgt"), dtData,		75, daRight, true,	"max_cgo_wgt", 		false, "", dfFloat, 2, true, true, 7);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovr_wgt_fx_rt"), dtData,	75, daRight, true,	"ovr_wgt_fx_rt", 	false, "", dfFloat, 2, true, true);
		sheetObjects[1].InitDataProperty(0, sheetObjects[1].SaveNameCol("ovr_wgt_fx_rto"), dtData,	75, daRight, true,	"ovr_wgt_fx_rto",	false, "", dfFloat, 2, true, true);
    }
	
	function co_tran_mode_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_trans20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_mty20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	function co_tmnl20_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_trans40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_mty40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}
	
	function co_tmnl40_src_OnCheckClick(comboObj, index, code) {
		if( code == "^" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "^";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	/* 개발자 작업  끝 */