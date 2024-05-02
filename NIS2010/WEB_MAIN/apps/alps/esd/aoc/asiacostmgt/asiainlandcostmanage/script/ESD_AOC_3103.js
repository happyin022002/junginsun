/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3103.js
*@FileTitle : Inland Cost Management Route Detail(SHA)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class ESD_AOC_3103 : esd_aoc_3103 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3103() {
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
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var btnAction;

	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1  = sheetObjects[0];   //sheet1
		/*******************************************************/
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
			
				case "radio_cd":
					if(formObject.radio_cd[0].checked){
						formObject.in_asc_desc.value = "asc";
					}else if(formObject.radio_cd[1].checked){
						formObject.in_asc_desc.value = "desc";				}
					break;
							
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
					
				case "btn_1strow":
		            ComOpenWait(true, true);
		            setTimeout("setFirstRow();ComOpenWait(false);", 100);
					break;
		            
				case "btn_cost_detail":
					if( sheetObject1.RowCount > 0 ){
						var param = "";
						param = param + '?cost_trf_no='+sheetObject1.CellValue(sheetObject1.SelectRow,"cost_trf_no");
						param = param + '&cost_trf_rout_seq='+sheetObject1.CellValue(sheetObject1.SelectRow,"cost_trf_rout_seq");
						param = param + '&io_bnd_nm='+formObject.io_bnd_nm.value;
						param = param + '&rd_term='+sheetObject1.CellValue(sheetObject1.SelectRow,"rcv_de_term_nm");
						param = param + '&curr_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"curr_cd");
						param = param + '&ttlAmt20='+sheetObject1.CellValue(sheetObject1.SelectRow,"inlnd_20ft_ttl_amt");
						param = param + '&ttlAmt40='+sheetObject1.CellValue(sheetObject1.SelectRow,"inlnd_40ft_ttl_amt");
						param = param + '&port_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"port_nod_cd");
						param = param + '&hub_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"hub_nod_cd");
						param = param + '&loc_cd='+sheetObject1.CellValue(sheetObject1.SelectRow,"loc_nod_cd");
						param = param + '&trns_mode='+sheetObject1.CellValue(sheetObject1.SelectRow,"trsp_crr_mod_cd");
						
						ComOpenPopup('/hanjin/ESD_AOC_3104.do' + param, 1024,620,'', '1,0,1,1,1,1,1,1');
					}
					break;

				case "btn_down_excel":
					sheetObject1.SpeedDown2Excel(-1);
					break;

				case "btn_apply":
					ComOpenWait(true);
					doActionIBSheet(sheetObject1, formObject, MULTI01);
					ComOpenWait(false);
					break;
					
				case "btn_close":
					window.close();
					//window.dialogArguments.call_esd_aoc_3102();
					break;
					
				case "old_ts_route":
					var vBkgNo = ComGetObjValue(formObject.bkg_no);
					var vCodRqstSeq = ComGetObjValue(formObject.cod_rqst_seq);
            		var sUrl = "/hanjin/ESM_BKG_0650.do?bkg_no="+vBkgNo+"&cod_rqst_seq="+vCodRqstSeq+"&op_cd=O";
            		ComOpenPopup(sUrl, 710, 310, "", "0,0", true, false, "", "", "","Transhipment Route and VVD");
					break;
					
				case "btn_delete":
					doActionIBSheet(sheetObject1, formObject, MULTI02);
					break
					
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
 	    var formObj = document.form;
 	    
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
		
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
 	 	
 	 	opener.form.reset_flg.value = "N";
 	 	document.form.s_cost_rout_grp_no.value = opener.form.rout_grp_no.value;
		
		//Cost Tariff No Info 생성
		formObj.f_cmd.value = SEARCH03;
		var sParam = FormQueryString(formObj);
		var sXml = sheetObjects[1].GetSearchXml("ESD_AOC_3102GS.do", sParam);
		
		ComSetObjValue(formObj.io_bnd_nm, ComGetEtcData(sXml, "io_bnd_nm"));
		ComSetObjValue(formObj.cost_trf_sts_nm, ComGetEtcData(sXml, "cost_trf_sts_nm"));
		ComSetObjValue(formObj.eff_fm_dt, ComGetEtcData(sXml, "eff_fm_dt"));
		ComSetObjValue(formObj.upd_dt, ComGetEtcData(sXml, "upd_dt"));
		ComSetObjValue(formObj.upd_usr_id, ComGetEtcData(sXml, "upd_usr_id"));
		
		var colId = sheetObjects[0].SaveNameCol("cost_sel_rout_flg");
		if(ComGetEtcData(sXml, "cost_trf_sts_cd") == "C"){
			ComBtnDisable("btn_1strow");
			ComBtnDisable("btn_delete");
			ComBtnDisable("btn_apply");
			sheetObjects[0].InitDataProperty(0, colId, dtCheckBox, 40, daCenter, true,	"cost_sel_rout_flg",	false, "", dfNone, 0, false ,false);
		}else{
			ComBtnEnable("btn_1strow");
			ComBtnEnable("btn_delete");
			ComBtnEnable("btn_apply");
			sheetObjects[0].InitDataProperty(0, colId, dtCheckBox, 40, daCenter, true,	"cost_sel_rout_flg",	false, "", dfNone, 0, true,	true);
		}
		
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	}

 	/**
 	 * Combo 기본 설정 
 	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 	 */ 
 	function initCombo(comboObj) {
 		var i=0;
    	    switch(comboObj.id) {
 			case "in_sort_by":
 				with(comboObj) {
 					comboObj.DropHeight=140;
 					InsertItem(i++, "Total 40'", "TT4");
					InsertItem(i++, "Total 20'", "TT2");
					InsertItem(i++, "Full Trans 40'", "FT4");
 					InsertItem(i++, "Full Trans 20'", "FT2");
 					InsertItem(i++, "Empty 40'", "MT4");
					InsertItem(i++, "Empty 20'", "MT2"); 					
 					InsertItem(i++, "TMNL 40'", "TM4");
					InsertItem(i++, "TMNL 20'", "TM2");
 					comboObj.Code = "TT4";
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
                    style.height = 380;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msHeaderOnly;
					MergeSheet = msPrevColumnMerge + msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Port-LOC|R/D\nTerm||Sel.|Del.|Port|Hub|LOC|Empty\nPU/RTN|Trans\nMode|CURR|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Full Trans Cost 20’|Full Trans Cost 20’|Full Trans Cost 20’|Full Trans Cost 20’|Full Trans Cost 20’|Full Trans Cost 20’";
					HeadTitle1 += "|Full Trans Cost 40’|Full Trans Cost 40’|Full Trans Cost 40’|Full Trans Cost 40’|Full Trans Cost 40’|Full Trans Cost 40’";
					HeadTitle1 += "|Empty\nCost 20’|Empty\nCost 40’|Terminal Cost 20’|Terminal Cost 20’|Terminal Cost 40’|Terminal Cost 40’|1st Link|1st Link|Com-\nbined|2nd Link|2nd Link|OLD\nAGMT";
					HeadTitle1 += "|cost_trf_no|cost_trf_rout_seq|cost_rout_grp_no|cost_rout_grp_no_rnk|rcv_de_term_cd|rf_cnt|Flag";

					var HeadTitle2 = "Port-LOC|R/D\nTerm||Sel.|Del.|Port|Hub|LOC|Empty\nPU/RTN|Trans\nMode|CURR|20’|40’|SCC|20’|40’";
					HeadTitle2    += "|System\nSource|System\nAmount|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2    += "|System\nSource|System\nAmount|MTY YD\n(AGMT)|MTY\nDiff|Weight\n(AGMT)|Rate\nType";
					HeadTitle2    += "|System\nAmount|System\nAmount|System\nSource|System\nAmount|System\nSource|System\nAmount|S/P\nCode|S/P\nName|Com-\nbined|S/P\nCode|S/P\nName|OLD\nAGMT";
					HeadTitle2    += "|cost_trf_no|cost_trf_rout_seq|cost_rout_grp_no|cost_rout_grp_no_rnk|rcv_de_term_cd|rf_cnt|Flag";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
					//InitDataProperty(0, cnt++, dtDataSeq,	40, daCenter, true,	"seq");
					InitDataProperty(0, cnt++, 	dtData,  			90, daCenter, 	true,		"port_loc", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"rcv_de_term_nm", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			60, daCenter, 	true,		"row_num", 						false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCheckBox, 		40, daCenter, 	true,		"cost_sel_rout_flg",			false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtCheckBox, 		40, daCenter, 	true,		"del_chk",						false, 		"", 		dfNone, 	0, 			true,		true);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"port_nod_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"hub_nod_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"loc_nod_cd",					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"mty_pkup_rtn_yd_cd",       	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daCenter, 	true,		"trsp_crr_mod_cd", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daCenter, 	true,		"curr_cd", 						false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"inlnd_20ft_ttl_amt", 			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			65, daRight, 	true,		"inlnd_40ft_ttl_amt", 			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daCenter, 	true,		"scc_cd", 						false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daRight, 	true,		"mb_20ft_rto", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daRight, 	true,		"mb_40ft_rto", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm",	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"trsp_20ft_cost_amt", 			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			60, daCenter, 	true,		"trsp_agmt_20ft_mty_yd_cd", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"trsp_diff_20ft", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_20ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			60, daCenter, 	true,		"trsp_rate_type_20ft", 			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm",	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"trsp_40ft_cost_amt",			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			60, daCenter, 	true,		"trsp_agmt_40ft_mty_yd_cd", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"trsp_diff_40ft", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_40ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			60, daCenter, 	true,		"trsp_rate_type_40ft", 			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"mty_trsp_20ft_cost_amt", 		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"mty_trsp_40ft_cost_amt", 		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"tml_20ft_cost_amt", 			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daRight, 	true,		"tml_40ft_cost_amt", 			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			60, daCenter, 	true,		"n1st_vndr_seq", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true,		"n1st_vndr_nm",					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daCenter, 	true,		"inlnd_rout_cmb_flg", 			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"n2nd_vndr_seq", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true,		"n2nd_vndr_nm", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			50, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_no", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq", 			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_rout_grp_no", 			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_rout_grp_no_rnk", 		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"rcv_de_term_cd", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"rf_cnt", 						false, 		"", 		dfNone, 	0, 			false, 		false);
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	true,		"ibflag");
				}
				break;
                 
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //Sort
				if (sheetObj.id == "sheet1"){
					formObj.f_cmd.value = SEARCH;
		        	var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESD_AOC_3103GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
					break;
				}

			case MULTI01: //Apply
				if(validateForm(sheetObj,formObj,sAction)){
					btnAction = sAction;
					formObj.f_cmd.value = MULTI01;
					var sParam =  ComGetSaveString(sheetObj, false, true);
					if( sParam == ""){ return;}
					
					opener.form.reset_flg.value = "Y";
					var sXml = sheetObj.GetSaveXml("ESD_AOC_3103GS.do", FormQueryString(formObj) + "&" + sParam, true);	        			
					sheetObj.LoadSaveXml(sXml);
				}
				break;
				
			case MULTI02: //Delete
				if(validateForm(sheetObj,formObj,sAction)){
					btnAction = sAction;
					formObj.f_cmd.value = MULTI02;
					var sParamSheet = sheetObj.GetSaveString(false, true, "del_chk");
		        	var sParam =  FormQueryString(formObj)+ "&" + ComSetPrifix(sParamSheet, "");
		        	
		        	opener.form.reset_flg.value = "Y";
		        	var sXml = sheetObj.GetSaveXml("ESD_AOC_3103GS.do", sParam);
					sheetObj.LoadSaveXml(sXml);
				}
				break;
         }
     }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case MULTI01:
				if( sheetObj.RowCount("U") < 1 ){
					ComShowCodeMessage("COM130503");
					return false;
				}
				break;
				
			case MULTI02:
				var iCheckRow = sheetObj.CheckedRows("del_chk");
				if(iCheckRow <= 0){
					ComShowCodeMessage('AOC90001');
					return false;
				}
				var chkRow = sheetObj.FindCheckedRow("del_chk");
				var chkRowArr = chkRow.split("|");
				for( var idx = 0; idx < chkRowArr.length - 1; idx++ ){
					if( sheetObj.CellValue(chkRowArr[idx], "rf_cnt") > 0 ){
						if( ComShowCodeConfirm("AOC90035") ){
							break;
						} else{
							sheetObj.SelectCell(chkRowArr[idx], "del_chk");
							return false;
						}
					}
				}
				break;
				
		}
        return true;
	}

    function setFirstRow() {
    	var sheetObj  = sheetObjects[0];   //sheet1
    	for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
    		if( sheetObj.CellValue(i, "cost_rout_grp_no_rnk") == "1"){
				sheetObj.CellValue(i, "cost_sel_rout_flg") = "Y";
			}else{
				sheetObj.CellValue(i, "cost_sel_rout_flg") = "N";
			}
		}
    }

    function sheet1_OnChange(sheetObj, Row, Col, Value) {
    	if (Col == 3 && Value == '') {
    		sheetObj.CellValue(Row, "cost_sel_rout_flg") = 1;
    	}
    }
    
    function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
    	if (Col == 3 && KeyCode == 32 ) {
    		sheet1_OnClick(sheetObj, Row, Col, 0, 0, 0, 0, 0);
    	}
    }
    
    function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
    	var formObj = document.form;
    	var sCostTrfStsNm = formObj.cost_trf_sts_nm.value;
    	if (sCostTrfStsNm != "Confirmed") {
	    	var sName = sheetObj.ColSaveName(Col);
	    	if (sName == "cost_sel_rout_flg") {
	    		var fastGrpNo = sheetObj.CellValue(Row, "cost_rout_grp_no");
	    		var fastRow   = sheetObj.FindText("cost_rout_grp_no", sheetObj.CellValue(Row, "cost_rout_grp_no"));
	    		
	    		var arrCount = 0;
	    		for(var i=fastRow ; i<=sheetObj.RowCount+1 ; i++){
	    			if( sheetObj.CellValue(Row, "cost_rout_grp_no") == sheetObj.CellValue(i, "cost_rout_grp_no")){
	    				arrCount++;
	    			}
	    		}
	    		for(var i=fastRow ; i<fastRow+arrCount ; i++){
	    			if(Row != i){
	    				sheetObj.CellValue(i, "cost_sel_rout_flg") = 0;
	    			}
	    		}
	    	}
    	}
    }
	
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		var formObject = document.form;
		//if(applyBtnFlg){
		//	window.close();	
		//}
		switch (btnAction) {
			case MULTI01:
				window.close();	
				break;
				
			case MULTI02:
				doActionIBSheet(sheetObj, formObject, IBSEARCH);
				break;
				
		}		
	}     	   	
	/* 개발자 작업  끝 */