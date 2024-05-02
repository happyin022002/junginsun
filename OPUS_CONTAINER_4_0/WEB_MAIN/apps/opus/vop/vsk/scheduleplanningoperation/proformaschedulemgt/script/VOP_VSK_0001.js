/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : VOP_VSK_0001.js
 *@FileTitle  : P/F SKD Settlement
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/14
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
     * @class VOP_VSK_0001 : VOP_VSK_0001 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects=new Array();
    var sheetCnt=0;
    var portDataFlgs=new Array();		//그리드의 Port 변경여부(Port 변경 시에만 Terminal 조회하기 위함)
    var ydCdsArr=new Array();
    var submitFlg="N";
    var ydCdChgFlg=new Array();
    var bakObjForEdit; // Edit 전후 백업 데이타 보관용
    var editMode=false;
    //P/F Type 체크  글로벌 변수
    var g_pfTypeData="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
	         if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
        		case "btn_RowAdd":
        			var rowIdx = getRowCount(sheetObject2)+ sheetObject2.HeaderRows();
        			var rowIdx2=0;
        			if(rowIdx == sheetObject2.HeaderRows()){
						if(sheetObject1.RowCount()== 0){
							rowIdx2=sheetObject1.DataInsert(-1);
						}
						rowIdx2=sheetObject2.DataInsert(-1);
						resetRowSeq(sheetObject2);
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_dy_no",0);
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_dy_cd","MON");
						sheetObject2.SetCellValue(rowIdx2,sheetObject2.id+"_etb_tm_hrmnt","00:00");
						sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_etd_dy_no",0);
						sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_etd_dy_cd",0);
						sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_etd_tm_hrmnt",0);
						sheetObject2.SelectCell(rowIdx2, sheetObject2.id+"_port_cd", true);
						//if(sheetObject2.CellValue(rowIdx2,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.GetRowStatus(rowIdx2) == "I"){
							sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_tztm_hrs",0);
							sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_sea_buf_spd",0);
							sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_tml_prod_qty",0);
							sheetObject2.SetCellEditable(rowIdx2, sheetObject2.id+"_crn_knt",0);
						}
					}else{
						if(sheetObject1.RowCount()== 0){
							sheetObject1.DataInsert(-1);
						}
						sheetObject2.DataInsert(-1);
						resetRowSeq(sheetObject2);
						var lastRow=searchLastRow(sheetObject2);
						//2009 09 29 임창빈 수석 요청 전 포트의 skd_dir_cd를  add Row한 현재 포트에 셋팅한다
						sheetObject2.SetCellValue(lastRow-1,"sheet2_skd_dir_cd",sheetObject2.GetCellValue(lastRow-2,"sheet2_skd_dir_cd"));
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_dy_no",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_dy_cd",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etb_tm_hrmnt",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_dy_no",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_dy_cd",0);
						sheetObject2.SetCellEditable(lastRow-1, "sheet2_etd_tm_hrmnt",0);
						sheetObject2.SelectCell(lastRow-1, sheetObject2.id+"_port_cd", true);
						//if(sheetObject2.CellValue(lastRow-1,sheetObject2.id+"_ibflag") == "I"){
						if(sheetObject2.GetRowStatus(lastRow-1) == "I"){
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_tztm_hrs",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_sea_buf_spd",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_tml_prod_qty",0);
							sheetObject2.SetCellEditable(lastRow-1, "sheet2_crn_knt",0);
						}
						setlastLowViewUndo(sheetObject2,lastRow-1);
						setlastLowView(sheetObject2,lastRow);
					}
					break;
        		case "btn_RowInsert":
        			var rowIdx=sheetObject2.GetSelectRow()+ sheetObject2.HeaderRows()- 1;
        			if(rowIdx){
        				if(rowIdx > sheetObject2.HeaderRows()){
							sheetObject2.DataInsert(sheetObject2.GetSelectRow());
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etb_dy_no",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etb_dy_cd",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etb_tm_hrmnt",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etd_dy_no",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etd_dy_cd",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_etd_tm_hrmnt",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_tztm_hrs",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_sea_buf_spd",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_tml_prod_qty",0);
							sheetObject2.SetCellEditable(sheetObject2.GetSelectRow(), "sheet2_crn_knt",0);
							//sheetObject2.CellEditable(sheetObject2.SelectRow, "sheet2_lnk_dist") = true;
							resetRowSeq(sheetObject2);
							sheetObject2.SetCellValue(sheetObject2.GetSelectRow(),"sheet2_skd_dir_cd",sheetObject2.GetCellValue(sheetObject2.GetSelectRow()-1,"sheet2_skd_dir_cd"));
							//2009 09 29 임창빈 수석 요청 전 포트의 skd_dir_cd를  add Row한 현재 포트에 셋팅한다
							//insert Row에서 추가를 하면 전체 dir_cd가 바뀐다
							//sheetObject2.CellValue(rowIdx-1,"sheet2_skd_dir_cd") =  sheetObject2.CellValue(rowIdx-2,"sheet2_skd_dir_cd");
							sheetObject2.SelectCell(rowIdx-1, sheetObject2.id+"_port_cd", true);
							var lastRow=searchLastRow(sheetObject2);
							setlastLowViewUndo(sheetObject2,lastRow-1);
							setlastLowView(sheetObject2,lastRow);
        				}
        			}
        			break;
        		case "btn_RowDelete":
        			if(!ComShowCodeConfirm('VSK00005')){return;}
        			var rowIdx=sheetObject2.GetSelectRow()+ sheetObject2.HeaderRows()- 1;
        			if(rowIdx){
        				if(rowIdx > sheetObject2.HeaderRows()- 1){
							var result=ComRowHideDelete(sheetObject2,"sheet2_Sel");
							if(result  > 0){
								doActionIBSheet(sheetObject1,formObject,REMOVE);
							}
        				}
        			}
        			break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_Save":
					if(ComGetBtnDisable("btn_Save")){
						return false;
					}
					doActionIBSheet(sheetObject2, formObject, IBSAVE,"Save");
					break;
				case "btn_MCalculation":
					doActionIBSheet(sheetObject2,formObject,COMMAND01);
					break;
				case "btn_EOTP":
					openEOTPCreation(sheetObject1,sheetObject2,formObject);
					break;
				case "btn_Settlement":
					if(ComGetBtnDisable("btn_Settlement")){
						return false;
					}
					doActionIBSheet(sheetObject2, formObject, IBSAVE,"Settle");
					break;
				case "btn_BerthWindow":
					open_BerthWindow(sheetObject1,sheetObject2,formObject);
					break;
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;
				case "btn_New":
					setEditMode(false);
					clearAllData(sheetObject1,sheetObject2,formObject);
					break;	
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
					break;
				case "btns_search03":
					openSimNoCdHelp(sheetObject2);
					break;	
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
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */                    
	function loadPage() {
		for(i=0; i<sheetObjects.length; i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		initControl();
		document.form.sim_dt.focus();
		if(sheetObjects[0].RowCount()== 0){
			sheetObjects[0].DataInsert(-1);
		}
	}
	/**
	 * 이벤트 컨드롤 정의
	 */
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm('focus', 'obj_focus', formObj);
		//axon_event.addListenerFormat('keypress', 'obj_keypress', form);
		//axon_event.addListenerForm('keyup', 'obj_keyup' , form);
		axon_event.addListenerForm('change', 'obj_change' , form);
	}
	function obj_focus() {
		if(ComGetEvent("options")){
			//ComGetEvent().focus();
			var evtObj = ComGetEvent();
			evtObj.focus();
		}else{
			//ComGetEvent().select();
			var evtObj = ComGetEvent();
			evtObj.focus();
		}
	}
	/**
	 * KEY PRESS 이벤트
	 */
	function obj_keypress() {
	    switch(ComGetEvent("dataformat")){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(ComGetEvent(), ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break; 
	        case "lowernum":
	            //영문 쏘문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('lowernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break;    
	        default:
	            //숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}
	/**
	 * 필드 데이타가 CHANGE될 경우 이벤트
	 */
	function obj_keyup(){
		var formObject=document.form;
	    /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	    var sheetObject1=sheetObjects[0];
	    /*******************************************************/
	    if(sheetObjects[0].RowCount()== 0){
			sheetObjects[0].DataInsert(-1);
		}
		try {
			var srcName=ComGetEvent("name"); 
	        switch(srcName) {
	            case "sim_dt":
					if(formObject.sim_dt.value.length == 8){
						sheetObject1.SetCellValue(1,"sheet1_sim_dt",formObject.sim_dt.value);
						formObject.sim_no.focus();
					}
	            	break;
	            case "sim_no":
	            	sheetObject1.SetCellValue(1,"sheet1_sim_no",formObject.sim_no.value);
	            	break;
	            case "pf_svc_tp_cd":
					var cnt=formObject.pf_svc_tp_cd.value.length;
					if(cnt == 4){
						//2009 11 27 PF_TYPE_CD CHECK LIM 요청
	//					var sXml = doActionIBSheet(sheetObjects[0], formObject, SEARCH06);
						//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
	//					var pfTypeData = ComGetEtcData(sXml, "pfTypeData");
	//					g_pfTypeData = pfTypeData;
	//					if(pfTypeData[0] == "Y"){
	//						ComShowCodeMessage("VSK00091");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else if(pfTypeData[1] == "Y"){
	//						ComShowCodeMessage("VSK00092");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else{
						sheetObject1.SetCellValue(1,"sheet1_pf_svc_tp_cd",formObject.pf_svc_tp_cd.value);
						formObject.pf_skd_rmk.focus();
	//					}
					}
	            case "slan_stnd_flg":
					sheetObject1.SetCellValue(1,"sheet1_slan_stnd_flg",formObject.slan_stnd_flg.value);
	            	break;	
	            case "pf_skd_rmk":
					sheetObject1.SetCellValue(1,"sheet1_pf_skd_rmk",formObject.pf_skd_rmk.value);
	            	break;
	            case "n1st_vsl_clss_cd":
					sheetObject1.SetCellValue(1,"sheet1_n1st_vsl_clss_cd",formObject.n1st_vsl_clss_cd.value);
	            	break;
	            case "n1st_vsl_clss_knt":
					sheetObject1.SetCellValue(1,"sheet1_n1st_vsl_clss_knt",formObject.n1st_vsl_clss_knt.value);
	            	break;
	            case "n2nd_vsl_clss_cd":
					sheetObject1.SetCellValue(1,"sheet1_n2nd_vsl_clss_cd",formObject.n2nd_vsl_clss_cd.value);
	            	break;
	            case "n2nd_vsl_clss_knt":
					sheetObject1.SetCellValue(1,"sheet1_n2nd_vsl_clss_knt",formObject.n2nd_vsl_clss_knt.value);
	            	break;
	            case "n3rd_vsl_clss_cd":
					sheetObject1.SetCellValue(1,"sheet1_n3rd_vsl_clss_cd",formObject.n3rd_vsl_clss_cd.value);
	            	break;
	            case "n3rd_vsl_clss_knt":
					sheetObject1.SetCellValue(1,"sheet1_n3rd_vsl_clss_knt",formObject.n3rd_vsl_clss_knt.value);
	            	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e);
			}
		}
	}
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    if(sheetObj.RowCount()== 0){
	    	sheetObj.DataInsert(-1);
		}
		try {
			var srcName=ComGetEvent("name"); 
	        switch(srcName) {
		        case "sim_dt":
		        	clearDescData(sheetObjects, formObj);
		        	break;
	            case "sim_no":
	            	clearDescData(sheetObjects, formObj);
	            	break;
	            case "vsl_slan_cd":
	            	var cnt=formObj.vsl_slan_cd.value.length;
					if(cnt == 3){
						var sXml=doActionIBSheet(sheetObj, formObj, SEARCH03);
						var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
			  		  	var dirCds=ComGetEtcData(sXml, "checkDirCd");
					  	sheetObjects[1].SetColProperty("sheet2_skd_dir_cd", {ComboText:dirCds, ComboCode:dirCds} );
						if(vslSlanNm == ""){
							ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
							formObj.vsl_slan_cd.value="";	
						}else{
							formObj.pf_svc_tp_cd.focus();
						}
						sheetObj.SetCellValue(1,"sheet1_vsl_slan_cd",formObj.vsl_slan_cd.value);
					}
	            	break;
	            case "pf_svc_tp_cd":
					var cnt=formObj.pf_svc_tp_cd.value.length;
					if(cnt == 4){
						//2009 11 27 PF_TYPE_CD CHECK LIM 요청
						var sXml=doActionIBSheet(sheetObj, formObj, SEARCH06);
						//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
						var pfTypeData=ComGetEtcData(sXml, "pfTypeData");
						g_pfTypeData=pfTypeData;
	//					if(pfTypeData[0] == "Y"){
	//						ComShowCodeMessage("VSK00091");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else if(pfTypeData[1] == "Y"){
	//						ComShowCodeMessage("VSK00092");
	//						formObject.pf_svc_tp_cd.value = "";
	//						return;
	//					}else{
						sheetObj.SetCellValue(1,"sheet1_pf_svc_tp_cd",formObj.pf_svc_tp_cd.value);
						formObj.pf_skd_rmk.focus();
	//					}
					}
	            	break;
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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
	function initSheet(sheetObj,sheetNo) {
	    var cnt=0;
		var sheetID=sheetObj.id;
	    switch(sheetID) {
	    	case "sheet1":      //sheet1 init
				with(sheetObj){
					var HeadTitle="STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|";
					var headCount=ComCountHeadTitle(HeadTitle);
					var prefix="sheet1_";
					SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"stnd_svc_spd",      KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_itval_dys",    KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mml_usd_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_no",            KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_knt",          KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dist",          KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"max_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_skd_rmk",        KeyField:0,   CalcLogic:"",   Format:"" },
					 {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"hiddencheck" } ];
					   
					InitColumns(cols);
					SetVisible(0);
					SetEditable(0);
					SetWaitImageVisible(0);
				}
	        break;
	        case "sheet2":      //sheet1 init
				with(sheetObj){
					var HeadTitle1="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD";
					var HeadTitle2="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD";
					var HeadTitle3="||No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD|HiddenCheck|CheckWkTm|CraneWkTm|CLPT_SEQ|PORT_ROTN_SEQ|MDM_SKD_DIR_CD";
					var headCount=ComCountHeadTitle(HeadTitle1);
					var prefix="sheet2_";
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					 {Type:"CheckBox",  Hidden:0, Width:27,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
					 {Type:"Int",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"row_seq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
					 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Int",      Hidden:0, Width:25,   Align:"Right",   ColMerge:1,   SaveName:prefix+"zd",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Int",      Hidden:0, Width:25,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etb_dy_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
					 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
					 {Type:"Text",      Hidden:0, Width:25,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Combo",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
					 {Type:"Int",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
					 {Type:"Float",      Hidden:0, Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					 {Type:"Float",      Hidden:0, Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					 {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_spd",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",      Hidden:0, Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",      Hidden:0, Width:30,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
					 {Type:"Int",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Int",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Int",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Int",      Hidden:0, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					 {Type:"Int",      Hidden:0, Width:25,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1 },
					 {Type:"Float",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0 },
					 {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
					 {Type:"CheckBox",  Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"hiddencheck" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"check_wk_tm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"crane_wk_tm" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_seq" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"port_rotn_seq" },
					 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mdm_skd_dir_cd" } ];
					   
					InitColumns(cols);
					SetSheetHeight(332);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetColProperty(prefix+"yd_cd", {ComboText:"", ComboCode:""} );
					SetColProperty(prefix+"etb_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
					SetColProperty(prefix+"etd_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
					SetColProperty(prefix+"turn_port_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
					SetRowHeight(0,10);
					SetRowHeight(1,10);
					SetRowHeight(2,10);
					SetColHidden(32,1);
					SetEditEnterBehavior("edit");
					SetFocusAfterProcess(0);
					SetCellBackColor(2, 1, "#555555");
					SetCellBackColor(1, 7, "#555555");
					SetCellBackColor(1, 8, "#555555");
					SetCellBackColor(1, 9, "#555555");
					SetCellBackColor(1, 10, "#555555");
					SetCellBackColor(1, 11, "#555555");
					SetCellBackColor(1, 12, "#555555");
					SetCellBackColor(1, 18, "#555555");
					SetCellBackColor(1, 19, "#555555");
					
					SetCellBackColor(1, 22, "#555555");
					SetCellBackColor(1, 23, "#555555");
					SetCellBackColor(1, 24, "#555555");
					SetCellBackColor(1, 25, "#555555");
					SetCellBackColor(1, 26, "#555555");
					SetCellBackColor(1, 27, "#555555");
					
					SetCellBackColor(2, 22, "#555555");
					SetCellBackColor(2, 23, "#555555");
					SetCellBackColor(2, 24, "#555555");
					SetCellBackColor(2, 25, "#555555");
					SetCellBackColor(2, 26, "#555555");
				}
				break;
	    }
    }
  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction, sFlag) {
    sheetObj.ShowDebugMsg(false);
    //alert(sAction);
    switch(sAction) {
		case IBSEARCH:      //조회
			if(validateForm(sheetObj,formObj,sAction)){
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var	sParm="f_cmd=" +formObj.f_cmd.value+
						"&sim_dt=" +formObj.sim_dt.value+
						"&sim_no=" +formObj.sim_no.value;
		        var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix 문자열 배열
//				var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		        var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do", sParm + "&" + ComGetPrefixParam(aryPrefix));
				var arrXml=sXml.split("|$$|");
				submitFlg="Y";
				for(var inx=0; inx<arrXml.length; inx++){
					searchShowSheetData(sheetObjects[inx],formObj,arrXml[inx],"N");
				}
				var rowPos=sheetObjects[1].HeaderRows()+ sheetObjects[1].RowCount();
				setlastLowView(sheetObjects[1],rowPos);
				ComOpenWait(false);
				setEditMode(false);
			}
		break;
		/*
		case SEARCH02:
			formObj.f_cmd.value=SEARCH02;
			var loc_cd=formObj.port_cd.value;
			var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
//parameter changed[check again]CLT 			var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			return sXml;
		break;
		*/	
		case SEARCH02:
			var prefix="sheet2_";
			// port_cd가 Change될때  해당 port_cd에  대한  check Port, Yd_cd를 조회한다
			//추가 임창빈 수석 20090915
			// FROM, TO PORT간에 DISTANCE, ZD(ZONE DESCRIPTION), CRANE 수, 터미널 생산성 정보를 조회한다.
			var headCnt=sheetObj.HeaderRows();
			var rowCnt=sheetObj.RowCount();
			var totalCnt=headCnt+rowCnt;
			var currRow=sheetObj.GetSelectRow();
			var idx=0;
			//현재 change된 port의 로우
			var currPos=(sheetObj.GetSelectRow()- headCnt)+1;
			//현재 포트 의 전  포트가 존재 하지 않을시 : 1 (add Row로 첫번째 로우의 생성시, 조회 후  첫번째 로우의 포트를  수정시 )
			//현재 포트의 전 포트가 존재 할시   : 1 (add Row로 로우 생성시 )
			//현재 포트의 후 포트가 존재 할 시 : 2 add Row로 로우 추가시, 조회 후 insert Row로 새 포트 추가시
			var portInfoCnt="";
			//현재 포트의 전 포트가 존재 하는지  여부를 저장
			//response 시 ETC Data로 자신의 포트에 데이타를 출력한지 아님 전 포트에 데이타를 출력할지 여부 
			var data_pos="";
			//현재 포트가 첫번째이면서 전체 로우가 하나일때
			if(currPos == 1 && currPos == rowCnt){
				portInfoCnt=1;
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value="";
				//현재 로우가 To Port
				formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가 없다
				formObj.third_port_cd.value="";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value=portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value=currRow;
				//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
				formObj.data_pos.value="S";
			//현재 포트가 첫번째 이하이면서 전체 로우가 하나이상일때	
			}else if(currPos > 1 && currPos <= rowCnt-1){
				portInfoCnt=2;
				//전 port가 FROM PORT된다
				/*
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currRow-1,"sheet2_port_cd");
					return false;
					}else if(sheetObj.GetCellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos+1,"sheet2_port_cd");
					return;
				}
				*/
				//전 port가 FROM PORT된다
				formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가 third_port_cd가 된다
				formObj.third_port_cd.value=sheetObj.GetCellValue(currRow+1,prefix+"port_cd");
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value=portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value=sheetObj.GetSelectRow();
				//현재 포트와 전 포트 , 그리고 다음 포트까지 존해 하므로 A = ALL
				formObj.data_pos.value="A";
			//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
			}else if(currPos == 1 && currPos <= rowCnt-1){
				portInfoCnt=1;
				/*
				if(sheetObj.GetCellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value="";
				//현재 로우가 To Port
				formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value=sheetObj.GetCellValue(currRow+1,prefix+"port_cd");
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value=portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value=sheetObj.GetSelectRow();
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다 T = TO
				formObj.data_pos.value="T";
			//현재 포트가 두번째 로우 이고 전체 로우가 두개일때
			}else if(currPos == 2){
				portInfoCnt=1;
				/*
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value="";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value=portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value=sheetObj.GetSelectRow();
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다 F = FROM
				formObj.data_pos.value="F";
			//현재 포트가 마지  막 로우일때	
			}else if(currPos == rowCnt){
				portInfoCnt=1;
				/*
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK01018", "[Port Code]");
					sheetObj.SelectCell(currPos-1,"sheet2_port_cd");
					return;
				}
				*/
				//현재 로우가  첫번째 로우이기 때문에 FROM PORT가  없다.
				formObj.first_port_cd.value=sheetObj.GetCellValue(currRow-1,prefix+"port_cd");
				//현재 로우가 To Port
				formObj.second_port_cd.value=sheetObj.GetCellValue(currRow,prefix+"port_cd");
				//현재 로우의 다음 port가
				formObj.third_port_cd.value="";
				//실제 DAO에서  searchPortInfo 메서드를 몇번 호출하지 결정
				formObj.port_info_cnt.value=portInfoCnt;
				//현재 port의 몇번째 로우를  파라미터로 보내서 response시 해당 로우에 데이타를 삽입한다
				formObj.curr_pos.value=sheetObj.GetSelectRow();
				//전 포트가 존재 하지 않고 자기 자신의 현재 포트와 다음 포트에 데이타를 출력한다E = END
				formObj.data_pos.value="E";
			}
  		    ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
			formObj.loc_cd.value=formObj.port_cd.value;
			var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix);
			alert( sParam );
			//var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do", sParam);
			ComOpenWait(false);
			return sXml;
		break;
		case SEARCH03:	// Lane Code Check
			formObj.f_cmd.value=SEARCH03;
			var sParam="f_cmd=" + formObj.f_cmd.value + 
						"&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
			var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParam);
//			var sParam = FormQueryString(formObj);
//			var vslSlanCd  = formObj.vsl_slan_cd.value;
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);
  		  	return sXml;
		break;
		case SEARCH04:	//Yard Code 변경시...
  		    ComOpenWait(true);
			formObj.f_cmd.value=SEARCH03;
			var sParam="f_cmd=" + formObj.f_cmd.value + 
						"&yd_cd=" + formObj.yd_cd.value;
			var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do", sParam);
//          var sParam = FormQueryString(formObj);
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do", sParam);
			ComOpenWait(false);
			return sXml;
		break;
		case SEARCH05: // Location에 따른 Yard List 조회.
  		    ComOpenWait(true);
			formObj.f_cmd.value=SEARCH04;
			var sParam="f_cmd=" + formObj.f_cmd.value + 
						"&loc_cd=" + formObj.port_cd.value;
			var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do", sParam);
//			var loc_cd = formObj.port_cd.value;
//          var sParam = FormQueryString(formObj);
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0001GS.do?loc_cd="+loc_cd, sParam);
			ComOpenWait(false);
			return sXml;
		break;
		case SEARCH06: // P/F Type Check
  		    ComOpenWait(true);
			formObj.f_cmd.value=SEARCH05;
			var sParam="f_cmd=" + formObj.f_cmd.value + 
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
						"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
//          var sParam = FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0001GS.do", sParam);
			ComOpenWait(false);
			return sXml;
		break;
		case IBSAVE:        //저장
			if(sFlag == "Settle"){
				//sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I"; 
				sheetObjects[0].SetRowStatus(1,"I");
				for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
				   //sheetObjects[1].CellValue(i,"sheet2_ibflag") = "I";
					sheetObjects[1].SetRowStatus(i,"I");
				}
			   if(validateForm(sheetObj,formObj,"Settle")){
				   var firstRow=getSearchFirstRow(sheetObjects[1]);
				   var lastRow=searchLastRow()(sheetObjects[1]) - 1;
				   var firstPortDirCd=sheetObjects[1].GetCellValue(firstRow,"sheet2_skd_dir_cd");
				   var otherDirCdPos=0;
				   var otherDorCdCnt=0;
				   //2009 12 15 임수석 수정요청
				   //Direction이 바뀌더라도 Turning Port Indicator를 Y로 수정하지 않더라도 무방함	
				   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
					   //처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
					   if(sheetObjects[1].GetCellValue(i,"sheet2_skd_dir_cd") != firstPortDirCd){
						   if(sheetObjects[1].GetCellValue(i,"sheet2_turn_port_flg") == "Y"){
							   if(i != lastRow){
								   otherDirCdPos++;
							   }
						   }
						   otherDorCdCnt++;
					   }
				   }
					//Direction이  바뀐경우 : 양방향일때
				   if(otherDorCdCnt > 0){
					   if(otherDirCdPos < 1){
						   ComShowCodeMessage('VSK00008');
						   return;
					   }
				   //단방향일때	   
				   }
//				   if(otherDirCdPos < 1){
//					   ComShowCodeMessage('VSK00009'); 
//					   return;
//				   }
				   var prefix="sheet1_"
				   sheetObjects[0].SetCellValue(1,prefix+"sim_dt",formObj.sim_dt.value);
				   sheetObjects[0].SetCellValue(1,prefix+"sim_no",formObj.sim_no.value);
				   sheetObjects[0].SetCellValue(1,prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value);
				   sheetObjects[0].SetCellValue(1,prefix+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value);
				   sheetObjects[0].SetCellValue(1,prefix+"slan_stnd_flg",formObj.slan_stnd_flg.value);
				   sheetObjects[0].SetCellValue(1,prefix+"pf_skd_rmk",formObj.pf_skd_rmk.value);
				   if(formObj.brth_itval_dys.value == ""){
					   sheetObjects[0].SetCellValue(1,prefix+"brth_itval_dys","0");
				   }else{
					   sheetObjects[0].SetCellValue(1,prefix+"brth_itval_dys",formObj.brth_itval_dys.value);
				   }
				   if(formObj.svc_dur_dys.value == ""){
					   sheetObjects[0].SetCellValue(1,prefix+"svc_dur_dys","0");
				   }else{
					   sheetObjects[0].SetCellValue(1,prefix+"svc_dur_dys",formObj.svc_dur_dys.value);
				   }
				   ComOpenWait(true);	
				   formObj.f_cmd.value=MULTI;
		     	   var SaveStr=ComGetSaveString(sheetObjects);
		     	   var aryPrefix=new Array("sheet1_", "sheet2_");
		     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
		     	   ComOpenWait(false);
		     	   if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
		     	   sheetObjects[1].CheckAll("sheet2_Sel",0);
			   }
			}else{
//				sheetObjects[0].CellValue(1,"sheet1_ibflag") = "I"; 
//				for(var i=3; i<=sheetObjects[1].RowCount+2; i++){
//					if(sheetObjects[1].CellValue(i,"sheet2_ibflag") != "D"){
//						sheetObjects[1].CellValue(i,"sheet2_ibflag") = "I";
//					}
//				}
				sheetObjects[0].SetRowStatus(1,"I");
				for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
					if(sheetObjects[1].GetRowStatus(i) != "D"){
						sheetObjects[1].SetRowStatus(i,"I");
					}
				}
				 if(validateForm(sheetObj,formObj,"Save")){
					    var confirmFlg=ComShowCodeConfirm("VSK00089");
						var newSimData="";
						if(confirmFlg == true){
							newSimData="I";
						}else{
							newSimData="U";
						}
					   var prefix="sheet1_"
					   sheetObjects[0].SetCellValue(1,prefix+"sim_dt",formObj.sim_dt.value);
					   sheetObjects[0].SetCellValue(1,prefix+"sim_no",formObj.sim_no.value);
					   sheetObjects[0].SetCellValue(1,prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value);
					   sheetObjects[0].SetCellValue(1,prefix+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value);
					   sheetObjects[0].SetCellValue(1,prefix+"slan_stnd_flg",formObj.slan_stnd_flg.value);
					   sheetObjects[0].SetCellValue(1,prefix+"pf_skd_rmk",formObj.pf_skd_rmk.value);
					   ComOpenWait(true);
					   formObj.f_cmd.value=MULTI02;
					   formObj.new_sim_data.value=newSimData;
			     	   var SaveStr=ComGetSaveString(sheetObjects);
			     	   var aryPrefix=new Array("sheet1_", "sheet2_");
			     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			     	   ComOpenWait(false);
			     	   if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
			     	   if(ComGetEtcData(sXml, "simDt") == undefined){
			     	   }else{
			     		   var simDt=ComGetEtcData(sXml, "simDt");
				     	   var simNo=ComGetEtcData(sXml, "simNo");
				     	   formObj.sim_dt.value=simDt;
					       formObj.sim_no.value=simNo;
			     	   }
			     	   sheetObjects[1].CheckAll("sheet2_Sel",0);
				   }
			}
		break;
		case COMMAND01:
			if(validateForm(sheetObj,formObj,"simul")){
			   //sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U"; 
				sheetObjects[0].SetRowStatus(1,"U");
			   var currPos=0;
			   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
				   //if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "I" || sheetObjects[1].CellValue(i,"sheet2_ibflag") == "U"){
				   if(sheetObjects[1].GetRowStatus(i) == "I" || sheetObjects[1].GetRowStatus(i) == "U"){
					   currPos=i;
				   }
			   }
			   for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
//				   if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//					   sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//				   }
				   if(sheetObjects[1].GetRowStatus(i) == "R"){
					   sheetObjects[1].SetRowStatus(i,"U");
				   }
			   }
			   formObj.currPos.value=currPos-1;
	  		   ComOpenWait(true);
			   formObj.f_cmd.value=COMMAND01;
	     	   var SaveStr=ComGetSaveString(sheetObjects);
	     	   var aryPrefix=new Array("sheet1_", "sheet2_");
	     	   var sXml=sheetObj.GetSaveData("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   var checkArrXml=sXml.split("|$$|");
	     	   
	     	   //var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
	     	   //xmlDoc.loadXML(checkArrXml[0]);
			   //var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			   
			   var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
			   if(dataNode){
					var totValue=dataNode;
					if(totValue > 0){
						 var arrXml=sXml.split("|$$|");
				     	   submitFlg="Y";
				     	   for(var inx=0; inx<arrXml.length; inx++){
								simulShowSheetData(sheetObjects[inx],formObj,arrXml[inx],"Y");
							}
							//viewDetailData(sheetObjects[1],formObj);
							gridEndJob(sheetObjects[1],formObj);
							var rowPos=sheetObjects[1].HeaderRows()+ sheetObjects[1].RowCount();
							setlastLowView(sheetObjects[1],rowPos);
							// 정상적으로 수행되었으므로 Save, Settlement 버튼을 풀어준다.
							setEditMode(false);
					}
			   }else{
				   if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
			   ComOpenWait(false);
			}
		break;
		case REMOVE:
			if(validateForm(sheetObj,formObj,"Remove")){
			    //sheetObjects[0].CellValue(1,"sheet1_ibflag") = "U"; 
				sheetObjects[0].SetRowStatus(1,"U");
			    for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
//				    if(sheetObjects[1].CellValue(i,"sheet2_ibflag") == "R"){
//					    sheetObjects[1].CellValue(i,"sheet2_ibflag") = "U";
//				    }
			    	if(sheetObjects[1].GetRowStatus(i) == "R"){
					    sheetObjects[1].SetRowStatus(i,"U");
				    }
			    } 
			    formObj.f_cmd.value=REMOVE;
	     	    var SaveStr=ComGetSaveString(sheetObjects);
	     	    var aryPrefix=new Array("sheet1_", "sheet2_");
	     	    var sXml=sheetObj.GetSaveData("VOP_VSK_0001GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	    var arrXml=sXml.split("|$$|");
	     	    if(arrXml.length > 1){
		     	    for(var inx=0; inx<arrXml.length; inx++){
					 	rowDelshowSheetData(sheetObjects[inx],formObj,arrXml[inx]);
				    }
		     	    var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows();
				    setlastLowView(sheetObjects[1],lastPos);
	     	    }
	     	    sheetObjects[1].CheckAll("sheet2_Sel",0);
	     	    setEditMode(true);
			}
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
function searchShowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			//xmlDoc.loadXML(sXml);
			//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
			if(dataNode){
				var totValue=dataNode;
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					if(Pos != "Y"){
						formObj.vsl_slan_cd.value=sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
					}
					formObj.slan_stnd_flg.value=sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
					var n1stKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt"));
					var n2ndKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt"));
					var n3rdKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt"));
					if(Pos != "Y"){
						var tempPfCd="";
						tempMaxVslClsCnt=Math.max(n1stKnt,n2ndKnt,n3rdKnt);
						//2008 08 07
						//임창빈 수석 Vsl Class의 최대 갯수의  클래스를 PF_TYPE_CD에 셋팅한다
						if(tempMaxVslClsCnt == n1stKnt){
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
						}else if(tempMaxVslClsCnt == n2ndKnt){
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
						}else{
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
						}
						formObj.pf_svc_tp_cd.value=tempPfCd;
					}
					formObj.n1st_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
					formObj.n1st_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt");
					formObj.n2nd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
					formObj.n2nd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
					formObj.n3rd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
					formObj.n3rd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
					formObj.svc_dur_dys.value=sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value=sheetObj.GetCellValue(1,prefix+"brth_itval_dys");
					formObj.pf_skd_rmk.value=sheetObj.GetCellValue(1,prefix+"pf_skd_rmk");
					// MDM에서 조회한 Direction으로 콤보를 초기화한다.
					// 쿼리에 의해 MDM에 존재하지 않는 Lane일 경우 W,E,N,S 네 방향이 모두 나온다.
					var mdmSkdDirCd=ComGetEtcData(sXml, "mdm_skd_dir_cd");
					sheetObjects[1].SetColProperty("sheet2_skd_dir_cd", {ComboText:mdmSkdDirCd, ComboCode:mdmSkdDirCd} );
					var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i]=ydCds[i];
						}
					}
					//[25|21.8|18.4|2.5|3.1|0|99.2|92.1|22]
					var etcdts=ComGetEtcData(sXml, "etcdt").split("|");
					formObj.max_spd.value=etcdts[0]+" Kts";
					//formObj.avg_spd.value = etcdts[1]+" Kts";
					//formObj.buf_spd.value = etcdts[2]+" Kts";
					formObj.tot_buf_rat.value=etcdts[3]+" %";
					formObj.sea_buf_rat.value=etcdts[4]+" %";
					formObj.port_buf_rat.value=etcdts[5]+" %";
					formObj.pf_spd_rat.value=etcdts[6]+" %";
					formObj.buf_spd_rat.value=etcdts[7]+" %";
					formObj.min_max_spd.value=etcdts[8];
					var coadt=ComGetEtcData(sXml, "coadt").split("|");
					formObj.lf.value=coadt[0];
					formObj.rpb.value=coadt[1];
					formObj.rev.value=coadt[2];
					formObj.op.value=coadt[3];
					if(Pos == "Y"){
						formObj.currPos.value=ComGetEtcData(sXml, "currPos");
					}
					//2009 11 27 PF_TYPE_CD CHECK LIM 요청
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
					var pfTypeData=ComGetEtcData(sXml, "pfTypeData");
					g_pfTypeData=pfTypeData;
					/*if(pfTypeData[0] == "Y"){
						ComShowCodeMessage("VSK00091");
						formObj.pf_svc_tp_cd.select();
						return;
					}else if(pfTypeData[1] == "Y"){
						ComShowCodeMessage("VSK00092");
						formObj.pf_svc_tp_cd.select();
						return;
					}*/
				}else{
					clearAllData(sheetObjects[0],sheetObjects[1],formObj)
					formObj.sim_dt.focus();
				}
			}
		break;
		case "sheet2":
			sheetObj.RenderSheet(0);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			initPortDataFlg(sheetObj);
			if(sheetObj.RowCount()> 0){
				sheetObjects[1].CheckAll("sheet2_Sel",0);
				//viewDetailData(sheetObjects[1],formObj);
				var withrColor="#FFFFFF";
				var grayColor="#EFEBE6";
				sheetObj.SetCellEditable(3, "sheet2_mnvr_in_hrs",0);
				sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
				sheetObj.SetCellEditable(sheetObj.RowCount()+2, "sheet2_mnvr_in_hrs",1);
				sheetObj.SetCellBackColor(sheetObj.RowCount()+2, "sheet2_mnvr_in_hrs",withrColor);
				for(var k=4; k<=sheetObj.RowCount()+2; k++){
					sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
					sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
					sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
	       	 	}
				for(var k=3; k<=sheetObj.RowCount()+2; k++){
					sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
					sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
					sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
					sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
					sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
					sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
					sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
					sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
	       	 	}
				for(var k=3; k<=sheetObj.RowCount()+2; k++){
					if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
						var redColor="#555555";
						sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
					}
	       	 	}
				for(var i=0; i<sheetObj.RowCount(); i++){
					sheetObj.CellComboItem(sheetObj.HeaderRows()+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
					sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
					sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
				}
				sheetObj.RenderSheet(1);
				if(Pos == "Y"){
					var posTemp=Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
			}
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
function simulShowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			//xmlDoc.loadXML(sXml);
			//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
			if(dataNode){
				var totValue=Number(dataNode);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					if(Pos != "Y"){
						formObj.vsl_slan_cd.value=sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
					}
					formObj.slan_stnd_flg.value=sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
					var n1stKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt"));
					var n2ndKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt"));
					var n3rdKnt=parseInt(sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt"));
					if(Pos != "Y"){
						var tempPfCd="";
						tempMaxVslClsCnt=Math.max(n1stKnt,n2ndKnt,n3rdKnt);
						//2008 08 07
						//임창빈 수석 Vsl Class의 최대 갯수의  클래스를 PF_TYPE_CD에 셋팅한다
						if(tempMaxVslClsCnt == n1stKnt){
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
						}else if(tempMaxVslClsCnt == n2ndKnt){
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
						}else{
							tempPfCd=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
						}
						formObj.pf_svc_tp_cd.value=tempPfCd;
					}
					formObj.n1st_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
					formObj.n1st_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt");
					formObj.n2nd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
					formObj.n2nd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
					formObj.n3rd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
					formObj.n3rd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
					formObj.svc_dur_dys.value=sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
					formObj.brth_itval_dys.value=sheetObj.GetCellValue(1,prefix+"brth_itval_dys");
					formObj.pf_skd_rmk.value=sheetObj.GetCellValue(1,prefix+"pf_skd_rmk");
					var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i]=ydCds[i];
						}
					}
					//[25|21.8|18.4|2.5|3.1|0|99.2|92.1|22]
					var etcdts=ComGetEtcData(sXml, "etcdt").split("|");
					formObj.max_spd.value=etcdts[0]+" Kts";
					//formObj.avg_spd.value = etcdts[1]+" Kts";
					//formObj.buf_spd.value = etcdts[2]+" Kts";
					formObj.tot_buf_rat.value=etcdts[3]+" %";
					formObj.sea_buf_rat.value=etcdts[4]+" %";
					formObj.port_buf_rat.value=etcdts[5]+" %";
					formObj.pf_spd_rat.value=etcdts[6]+" %";
					formObj.buf_spd_rat.value=etcdts[7]+" %";
					formObj.min_max_spd.value=etcdts[8];
					if(Pos == "Y"){
						formObj.currPos.value=ComGetEtcData(sXml, "currPos");
					}
					//2009 11 27 PF_TYPE_CD CHECK LIM 요청
					var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
					//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
					var pfTypeData=ComGetEtcData(sXml, "pfTypeData");
					g_pfTypeData=pfTypeData;
					/*if(pfTypeData[0] == "Y"){
						ComShowCodeMessage("VSK00091");
						formObj.pf_svc_tp_cd.select();
						return;
					}else if(pfTypeData[1] == "Y"){
						ComShowCodeMessage("VSK00092");
						formObj.pf_svc_tp_cd.select();
						return;
					}*/
				}else{
					
					clearAllData(sheetObjects[0],sheetObjects[1],formObj)
					formObj.sim_dt.focus();
				}
			}
		break;
		case "sheet2":
			sheetObj.RenderSheet(0);
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			initPortDataFlg(sheetObj);
			if(sheetObj.RowCount()> 0){
				sheetObjects[1].CheckAll("sheet2_Sel",0);
				//viewDetailData(sheetObjects[1],formObj);
				var withrColor="#FFFFFF";
				var grayColor="#EFEBEF";
				sheetObj.SetCellEditable(3, "sheet2_mnvr_in_hrs",0);
				sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
				sheetObj.SetCellEditable(sheetObj.RowCount()+2, "sheet2_mnvr_in_hrs",1);
				sheetObj.SetCellBackColor(sheetObj.RowCount()+2, "sheet2_mnvr_in_hrs",withrColor);
				for(var k=4; k<=sheetObj.RowCount()+2; k++){
					sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
					sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
					sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
	       	 	}
				for(var k=3; k<=sheetObj.RowCount()+2; k++){
					sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
					sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
					sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
					sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
					sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
					sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
					sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
					sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
	       	 	}
				for(var k=3; k<=sheetObj.RowCount()+2; k++){
					if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
						var redColor="#FFFFFF";
						sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
						sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
					}
	       	 	}
				for(var i=0; i<sheetObj.RowCount(); i++){
					sheetObj.CellComboItem(sheetObj.HeaderRows+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
					sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//		    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
					sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
				}
				sheetObj.RenderSheet(1);
				if(Pos == "Y"){
					var posTemp=Number(formObj.currPos.value);
					sheetObj.SelectCell(posTemp, sheetObj.id+"_port_cd", true);
				}
			}
		break;
	}
}
/**
 * Row Delete 후 처리로직.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function rowDelshowSheetData(sheetObj, formObj, sXml,Pos){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
			if(ydCds != null && ydCds != undefined && ydCds != ""){
				for(var i=0 ; i < ydCds.length ; i++ ){
					ydCdsArr[i]=ydCds[i];
				}
			}
		break;
		case "sheet2":
			//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			//xmlDoc.loadXML(sXml);
			//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
			if(dataNode){
				var totValue=dataNode;
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if(totValue > 0){
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:1} );
					initPortDataFlg(sheetObj);
					if(sheetObj.RowCount()> 0){
						var lastPos=sheetObjects[1].RowCount()+sheetObjects[1].HeaderRows()- 1;
						var whiteColor="#FFFFFF";
						var grayColor="#EFEBEF";
						sheetObj.SetCellEditable(3, prefix+"mnvr_in_hrs",0);
						sheetObj.SetCellFontColor(3,prefix+"mnvr_in_hrs",grayColor);
						sheetObj.SetCellEditable(lastPos, prefix+"mnvr_in_hrs",1);
						sheetObj.SetCellBackColor(lastPos, prefix+"mnvr_in_hrs",whiteColor);
						for(var k=4; k<=sheetObj.RowCount()+2; k++){
							sheetObj.SetCellEditable(k, "sheet2_etb_dy_no",0);
							sheetObj.SetCellEditable(k, "sheet2_etb_dy_cd",0);
							sheetObj.SetCellEditable(k, "sheet2_etb_tm_hrmnt",0);
			       	 	}
						for(var k=3; k<=sheetObj.RowCount()+2; k++){
							sheetObj.SetCellEditable(k, "sheet2_etd_dy_no",0);
							sheetObj.SetCellEditable(k, "sheet2_etd_dy_cd",0);
							sheetObj.SetCellEditable(k, "sheet2_etd_tm_hrmnt",0);
							sheetObj.SetCellEditable(k, "sheet2_tztm_hrs",0);
							sheetObj.SetCellEditable(k, "sheet2_sea_buf_spd",0);
							sheetObj.SetCellEditable(k, "sheet2_port_cd",1);
							sheetObj.SetCellEditable(k, "sheet2_tml_prod_qty",0);
							sheetObj.SetCellEditable(k, "sheet2_crn_knt",0);
			       	 	}
						for(var k=3; k<=sheetObj.RowCount()+2; k++){
							if(sheetObj.GetCellValue(k, "sheet2_check_wk_tm") == "Y" && sheetObj.GetCellValue(k, "sheet2_crane_wk_tm") != ""){
								var redColor="#555555";
								sheetObj.SetCellBackColor(k,"sheet2_port_cd",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_dy_no",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_dy_cd",redColor);
								sheetObj.SetCellBackColor(k,"sheet2_etb_tm_hrmnt",redColor);
							}
			       	 	}
						resetRowSeq(sheetObj);
						for(var i=0; i<sheetObj.RowCount(); i++){
							sheetObj.CellComboItem(sheetObj.HeaderRows()+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
							sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//				    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
							sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
						}
						sheetObj.RenderSheet(1);
					}
				}
			}
		break;
	}
}
/**
 * P/F Type 설정위한 초기 데이타 셋팅.
 * @param sheetObj
 * @return
 */
function initPortDataFlg(sheetObj){ 
	var rows=sheetObj.Rows;
	for(var i=3; i<rows; i++){
		portDataFlgs[i-3]="N";
	}
}
/**
 * SHEET2 그리드를 Click 이벤트
 */
function sheet2_OnClick(sheetObject, Row, Col) {
	var formObj=document.form;
	var sXml=null;
	var prefix=sheetObject.id + "_";
	var colSaveName=sheetObject.ColSaveName(Col);
	if(Row > 1 && Col > 0){
		switch(colSaveName){
			case prefix + "yd_cd":
				formObj.port_cd.value=sheetObject.GetCellValue(Row, prefix + "port_cd");
				var tempPortCd=formObj.port_cd.value;
				if(tempPortCd.length == 5){
					// 이미 combo가 조회되어 yd_cd가 2개 이상이면 재조회 하지 않는다.
					var ydCdArr=sheetObject.GetComboInfo(Row, prefix + "yd_cd", "Code");
					if(ydCdArr.split("|").length == 1){
						sXml=doActionIBSheet(sheetObject, formObj, SEARCH05);
						if(sXml != null && sXml != undefined && sXml != ""){
							setSheetComboSinc(sXml, sheetObject, Row, Col);
						}
					}
				}
				break;
			case prefix + "port_cd":
				sheetObject.SelectCell(Row, Col);
				break;
		}
	}
}
function sheet2_OnComboChange(sheetObj,Row, Col, Code, Text){
	var formObj=document.form;
	var prefix=sheetObject.id + "_";
	var colSaveName=sheetObject.ColSaveName(Col);
	var tempYdCd=sheetObj.GetCellValue(Row,Col);
	var portCd=sheetObj.GetCellValue(Row,Col-1);
	var ydCd="";
	if(tempYdCd != "" && portCd != ""){
		if(colSaveName == prefix+"yd_cd"){
			formObj.yd_cd.value=portCd+tempYdCd;	
			var sXml=doActionIBSheet(sheetObj, formObj, SEARCH04);
			var mnvrInHrs=ComGetEtcData(sXml, "mnvr_in_hrs");
			var mnvrOutHrs=ComGetEtcData(sXml, "mnvr_out_hrs");
			sheetObj.SetCellValue(Row,prefix+"mnvr_in_hrs",mnvrInHrs);
			sheetObj.SetCellValue(Row,prefix+"mnvr_out_hrs",mnvrOutHrs);
		}
	}
}
/**
 * SHEET2 그리드 데이타 change 이벤트
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var colSaveName = sheetObj.ColSaveName(Col);
	var prefix=sheetObj.id + "_";
	var cnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
	var formObj=document.form;
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	
	var tempVal=Value;
	if(Row > 2){
		if(colSaveName == prefix+"skd_dir_cd"){
			for(var i=Row; i<cnt; i++){
				sheetObj.SetCellValue(i,prefix+"skd_dir_cd",Value,0);
			}
		}else if(colSaveName == prefix+"port_cd"){
			var headCnt=sheetObj.HeaderRows();
			var rowCnt=sheetObj.RowCount();
			var totalCnt=headCnt+rowCnt;
			var currPos=(sheetObj.GetSelectRow()- headCnt)+1;
			var currRow=sheetObj.GetSelectRow();
			if(currPos == 1 && currPos == rowCnt){
				if(tempVal.length == 0){
					return;
				}
			}/*
			else if(currPos > 1 && currPos <= rowCnt-1){
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}else if(sheetObj.GetCellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00071");
					sheetObj.SelectCell(currRow+1,Col);
					return;
				}
			}else if(currPos == 1 && currPos <= rowCnt-1){
				if(sheetObj.GetCellValue(currRow+1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00071");
					sheetObj.SelectCell(currRow+1,Col);
					return;
				}
			}else if(currPos == 2){
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}
			}else if(currPos == rowCnt){
				if(sheetObj.GetCellValue(currRow-1,prefix+"port_cd") == ""){
					ComShowCodeMessage("VSK00070");
					sheetObj.SelectCell(currRow-1,Col);
					return;
				}
			}
			*/
			if(tempVal.length == 5){
				formObj.port_cd.value=tempVal;		
				var sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
				var chkPort=ComGetEtcData(sXml, "check_port");
				if(chkPort == "X"){
					if(sXml != null && sXml != undefined && sXml != ""){
						//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
						//xmlDoc.loadXML(sXml);
						//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
						
						var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
						
						if(dataNode){
							var totValue=Number(dataNode );
							if(totValue > 0){
								setSheetComboSinc(sXml, sheetObj, Row, Col);
							}else{
								setSheetClearCombo(sheetObj, Row, Col);
								sheetObj.SetCellValue(Row, sheetObj.id+"_yd_cd","",0);
							}
						}
					}
					var portInfoCnt=Number(ComGetEtcData(sXml, "portInfoCnt"));
					var currPos=Number(ComGetEtcData(sXml, "currPos"));
					var dataPos=ComGetEtcData(sXml, "dataPos");
					var oneDataPos=0;
					var twoFromDataPos=0;
					var twoToDataPos=0;
					//전 포트가 존재 하지 않기때문에 자기 자신의 현재 포트에 데이타를 출력한다 S = SELF
					if(dataPos == "S"){
						oneDataPos=currPos;
					//전 포트가 존재 하기때문에 자기 자신의 전 포트에 데이타를 출력한다 F = FROM
					}else if(dataPos == "F"){
						oneDataPos=currPos - 1;
					//현재 포트와 전 포트 , 그리고 다음 포트까지 존해 하므로 A = ALL	
					}else if(dataPos == "A"){
						twoFromDataPos=currPos -1;
						twoToDataPos=currPos + 1;
					//현재포트와 다음 포트 존재 T = TO	
					}else if(dataPos == "T"){
						oneDataPos=currPos;
					//현재 포트가 마지막 로우일때 E = END	
					}else if(dataPos == "E"){
						oneDataPos=currPos-1;
					}
					//현재 포트나  현재포트와 전포트, 현재포트와 후 포트를 조회시
					if(portInfoCnt == 1){
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						//전 포트의 LNK_DIST,FM_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY 값을 채운다
						//현재 포트의 TO_ZD를 채운다
						var dataVal=ComGetEtcData(sXml, "one_row");
						var dataValArr=dataVal.split("|");
						//현재 포트가 첫번째이면서 전체 로우가 하나일때
						if(dataPos == "S"){
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[2]);
							sheetObj.SetCellValue(oneDataPos,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos,prefix+"tml_prod_qty",dataValArr[5]);
						//현재 포트가 두번째 로우 이고 전체 로우가 두개일때	
						}else if(dataPos == "F"){
							//현재 포트의 전 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							//현재 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"tml_prod_qty",dataValArr[5]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						//현재 포트가 첫번재 이면서 전체 로우가 하나이상일때	
						}else if(dataPos == "T"){
							//현재 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							sheetObj.SetCellValue(oneDataPos,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos,prefix+"tml_prod_qty",dataValArr[5]);
							//다음 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						//현재 포트가 마지  막 로우일때		
						}else if(dataPos == "E"){
							//전 포트
							sheetObj.SetCellValue(oneDataPos,prefix+"lnk_dist",dataValArr[0]);
							sheetObj.SetCellValue(oneDataPos,prefix+"zd",dataValArr[1]);
							//현재 포트
							sheetObj.SetCellValue(oneDataPos+1,prefix+"port_buf_hrs",dataValArr[3]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"crn_knt",dataValArr[4]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"tml_prod_qty",dataValArr[5]);
							sheetObj.SetCellValue(oneDataPos+1,prefix+"zd",dataValArr[2]);
						}
					//현재 포트와 전,후 포트 모두 조회시
					}else{
						var oneDataVal=ComGetEtcData(sXml, "one_row");
						var twoDataVal=ComGetEtcData(sXml, "two_row");
						var oneDataValArr=oneDataVal.split("|");
						var twoDataValArr=twoDataVal.split("|");
						//ONE_ROW_DATA : LNK_DIST,FM_ZD,TO_ZD,PORT_BUF_HRS,CRN_KNT,TML_PROD_QTY
						sheetObj.SetCellValue(twoFromDataPos,prefix+"lnk_dist",oneDataValArr[0]);
						sheetObj.SetCellValue(twoFromDataPos,prefix+"zd",oneDataValArr[1]);
						sheetObj.SetCellValue(currPos,prefix+"port_buf_hrs",oneDataValArr[3]);
						sheetObj.SetCellValue(currPos,prefix+"crn_knt",oneDataValArr[4]);
						sheetObj.SetCellValue(currPos,prefix+"tml_prod_qty",oneDataValArr[5]);
						sheetObj.SetCellValue(currPos,prefix+"lnk_dist",twoDataValArr[0]);
						sheetObj.SetCellValue(currPos,prefix+"zd",oneDataValArr[2]);
						//sheetObj.CellValue(twoToDataPos,prefix+"port_buf_hrs") = twoDataValArr[3];
						//sheetObj.CellValue(twoToDataPos,prefix+"crn_knt") = twoDataValArr[4];
						//sheetObj.CellValue(twoToDataPos,prefix+"tml_prod_qty") = twoDataValArr[5];
						sheetObj.SetCellValue(twoToDataPos,prefix+"zd",twoDataValArr[2]);
					}
				}else{
					ComShowCodeMessage('VSK00029', Value);
					//sheetObj.CellValue(Row,"sheet2_port_cd") = "";
					//sheetObj.CellValue(Row,"sheet2_yd_cd") = "";
					sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
					sheetObj.SetCellValue(Row, prefix+"zd","",0);
					sheetObj.SetCellValue(Row, prefix+"port_cd","",0);
					sheetObj.SelectCell(Row, Col, true);
					//sheetObj.SetCellBackColor(Row, prefix+"port_cd","#000000");
					//sheetObj.SetCellBackColor(Row, prefix+"etb_dy_no","#000000");
					//sheetObj.SetCellBackColor(Row, prefix+"etb_dy_cd","#000000");
					//sheetObj.SetCellBackColor(Row, prefix+"etb_tm_hrmnt","#000000");
				}
			}else{ // port_cd가 5자리가 아닌 경우
				if(tempVal.length!=""){ // port_cd의 값이 1자리이상 5자리 미만인 경우
					ComShowCodeMessage('VSK00029', tempVal);
				}
				sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
				sheetObj.SetCellValue(Row,"sheet2_zd","",0);
				sheetObj.SetCellValue(Row,"sheet2_etb_dy_no","",0);
				sheetObj.SetCellValue(Row,"sheet2_etb_dy_cd","",0);
				sheetObj.SetCellValue(Row,"sheet2_etb_tm_hrmnt","",0);
				//sheetObj.SetCellBackColor(Row, prefix+"port_cd","#000000");
				//sheetObj.SetCellBackColor(Row, prefix+"etb_dy_no","#000000");
				//sheetObj.SetCellBackColor(Row, prefix+"etb_dy_cd","#000000");
				//sheetObj.SetCellBackColor(Row, prefix+"etb_tm_hrmnt","#000000");
				sheetObj.SelectCell(Row, prefix+"port_cd", true);
			}
		}/*
		else if(Col == 5){
			var tempYdCd=sheetObj.GetCellValue(Row,Col);
			var portCd=sheetObj.GetCellValue(Row,Col-1);
			var ydCd="";
			if(submitFlg != "Y"){
				if(tempYdCd != "" && portCd != ""){
					formObj.yd_cd.value=portCd+tempYdCd;					
					var sXml=doActionIBSheet(sheetObj, formObj, SEARCH04);
					var mnvrInHrs=ComGetEtcData(sXml, "mnvr_in_hrs");
					var mnvrOutHrs=ComGetEtcData(sXml, "mnvr_out_hrs");
					sheetObj.SetCellValue(Row,prefix+"mnvr_in_hrs",mnvrInHrs);
					sheetObj.SetCellValue(Row,prefix+"mnvr_out_hrs",mnvrOutHrs);
				}
			}
		}*/
		else if(colSaveName == prefix+"etb_dy_no"){
			var tempEtbDyNo=parseInt(sheetObj.GetCellValue(Row, Col));
			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				ComShowCodeMessage('VSK00041');
				sheetObj.SetCellValue(Row, Col,0);
				sheetObj.SelectCell(Row, Col, true);
			}
		}else if(colSaveName == prefix+"etb_tm_hrmnt"){
			var tempEtbTmHrmnt=parseInt(sheetObj.GetCellValue(Row, Col));
			if(tempEtbTmHrmnt != 0){
				sheetObj.SelectCell(Row, 16, true);
			}
		}else if(colSaveName == prefix+"turn_port_flg"){
			var tempPortFlg=sheetObj.GetCellValue(Row, Col);
			sheetObj.SetCellValue(Row, Col+1,tempPortFlg);
		}
	}
}
/*
function sheet2_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift){
	var prefix=sheetObj.id + "_";
	var cnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
	var formObj=document.form;
	if(Row > 2){
		if(Col == 4){
//no support[check again]CLT 			var tempVal=sheetObj.EditValue;
			if(tempVal.length == 5){
				formObj.port_cd.value=tempVal;
				doActionIBSheet(sheetObj, formObj, SEARCH04);
				portDataFlgs[Row]="N";
				sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
				if(formObj.port_name.value == "" || formObj.port_name.value == "undefined"){
					ComShowCodeMessage('VSK00029', formObj.port_cd.value);
					sheetObj.SetCellValue(Row, Col,"");
					sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
					sheetObj.SelectCell(Row, Col, true);
				}else{
					sheetObj.SelectCell(Row, Col+1, true);
					sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
					if(sXml != null && sXml != undefined && sXml != ""){
						var xmlEtcData=ComGetEtcData(sXml, "yd_kind");
						if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
							sheetObj.CellComboItem(Row,sheetObj.id+"_yd_cd", {ComboText:xmlEtcData, ComboCode:xmlEtcData} );
							sheetObj.SetCellValue(Row,sheetObj.id+"_zd",formObj.zd.value);
						}
					}
				}
				portDataFlgs[Row]="Y";
			}
		}
	}
}
*/
/**
 * SHEET2 그리드 Terminal 코드 이벤트
 */
function setSheetComboSinc(xmlStr, sheetObj, Row, Col){
	var ydKindCode=ComGetEtcData(xmlStr, "yd_kind");
	var ydNm=ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt="";
	if(ydKindCode != null && ydKindCode != undefined && ydKindCode != ""){
		var ydKindCodeArr=ydKindCode.split("|");
		var ydNmArr=ydNm.split("|");
		var ydCnt=ydKindCodeArr.length;
		ydTxt=ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt=ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		sheetObj.CellComboItem(Row,sheetObj.id+"_yd_cd", {ComboText:ydTxt, ComboCode:ydKindCode} );
	}
}
/**
 * Sheet의 Terminal Combo Data Clear...
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function setSheetClearCombo(sheetObj, Row, Col){
	sheetObj.CellComboItem(Row,sheetObj.id+"_yd_cd", {ComboText:"", ComboCode:""} );
}
/**
 * Calling Port ,Distance (P/S ~ P/S) 데이타 출력
 */
/*
function viewDetailData(sheetObj,formObj){
	var cnt=sheetObj.RowCount();
	var prefix="sheet2_";
	//Calling Port
	var callingPortCnt=cnt-1;
	formObj.clpt_knt.value=callingPortCnt+" ports";
	//Distance
	var disSum=0;
	//var spdArr = new Array();
	for(var i=3; i<=cnt+2; i++){
disSum += parseInt(sheetObj.GetCellValue(i,prefix+"lnk_dist"));
	}
	disSum=ComGetMaskedValue(disSum+"","int","");
	formObj.ttl_dist.value=disSum+" Miles";	
}
*/
/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:      //조회
			if(ComIsNull(formObj.sim_dt.value)){
				ComShowCodeMessage('VSK00027', "Simulation date");
				formObj.sim_dt.focus();
				return false;
			}
			if(ComIsNull(formObj.sim_no.value)){
				ComShowCodeMessage('VSK00027', "Simulation No.");
				formObj.sim_no.focus();
				return false;
			}
			if(formObj.sim_dt.value.length < 8){
				ComShowCodeMessage("VSK01018", "Simulation No.");
				formObj.sim_dt.focus();
				return false;
			}
			break;
		case "Settle":     
			var prefix=sheetObj.id + "_";
			var headCnt=sheetObj.HeaderRows();
			var totCnt=sheetObj.LastRow();
			if(ComIsNull(formObj.sim_dt.value)){
				ComShowCodeMessage('VSK00027', "Simulation date");
				formObj.sim_dt.focus();
				return false;
			}
			if(ComIsNull(formObj.sim_no.value)){
				ComShowCodeMessage('VSK00027', "Simulation No.");
				formObj.sim_no.focus();
				return false;
			}
			if(formObj.sim_dt.value.length < 8){
				ComShowCodeMessage("VSK01018", "Simulation No.");
				formObj.sim_dt.focus();
				return false;
			}
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			} 
			if (ComIsNull(formObj.pf_svc_tp_cd.value)) {
				ComShowCodeMessage("VSK00027", "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			} 
			if(sheetObjects[1].RowCount()< 2){
				ComShowCodeMessage("VSK00043");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			var n1stVslClssCd=formObj.n1st_vsl_clss_cd;
			var n2stVslClssCd=formObj.n2nd_vsl_clss_cd;
			var n3stVslClssCd=formObj.n3rd_vsl_clss_cd;
			var n1stVslClssKnt=formObj.n1st_vsl_clss_knt;
			var n2stVslClssKnt=formObj.n2nd_vsl_clss_knt;
			var n3stVslClssKnt=formObj.n3rd_vsl_clss_knt;
//			var	comVslClss = 0;
			if(VskIsNull(n1stVslClssCd.value) || VskIsNull(n1stVslClssKnt.value)){
				n1stVslClssCd.focus();
				ComShowCodeMessage('VSK00027', "Vessel Class - 1");
				return false;
			}
			if(ComIsNull(n2stVslClssCd.value) && (n2stVslClssKnt.value > 0)) {
				n2stVslClssCd.focus();
				ComShowCodeMessage('VSK00027', "Vessel Class - 2");
				return false;
			}
			if (VskIsNotNull(n2stVslClssCd.value) && VskIsNullZero(n2stVslClssKnt.value)) {
				n2stVslClssKnt.focus();
				ComShowCodeMessage('VSK00027', "Vessel Count - 2");
				return false;
			}
			if(ComIsNull(n3stVslClssCd.value) && (n3stVslClssKnt.value > 0)) {
				n3stVslClssCd.focus();
				ComShowCodeMessage('VSK00027', "Vessel Class - 3");
				return false;
			}
			if(VskIsNotNull(n3stVslClssCd.value) && VskIsNullZero(n3stVslClssKnt.value)) {
				n3stVslClssKnt.focus();
				ComShowCodeMessage('VSK00027', "Vessel Count - 3");
				return false;
			}
			if(VskIsNotNull(n1stVslClssCd.value) && VskIsNotNull(n2stVslClssCd.value)){
				if (n1stVslClssCd.value == n2stVslClssCd.value) {
					n2stVslClssCd.focus();
					ComShowCodeMessage('VSK00099', n2stVslClssCd.value);
					return false;
				};
			}
			if(VskIsNotNull(n1stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)){
				if (n1stVslClssCd.value == n3stVslClssCd.value) {
					n3stVslClssCd.focus();
					ComShowCodeMessage('VSK00099', n3stVslClssCd.value);
					return false;
				}
			}
			if(VskIsNotNull(n2stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)){
				if (n2stVslClssCd.value == n3stVslClssCd.value) {
					n3stVslClssCd.focus();
					ComShowCodeMessage('VSK00099', n3stVslClssCd.value);
					return false;
				}
			}
			if (VskIsNull(n2stVslClssCd.value) && VskIsNotNull(n3stVslClssCd.value)) {
				n2stVslClssCd.value=n3stVslClssCd.value;
				n2stVslClssKnt.value=n3stVslClssKnt.value;
				n3stVslClssCd.value="";
				n3stVslClssKnt.value="";
			}
			if(VskIsNullZero(formObj.svc_dur_dys.value)) {
				formObj.svc_dur_dys.focus();
				ComShowCodeMessage('VSK01017', "Duration");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}			
			if(VskIsNullZero(formObj.brth_itval_dys.value)) {
				formObj.brth_itval_dys.focus();
				ComShowCodeMessage('VSK01017', "Frequency");	//'({?msg1}) field is missing. Please check again!'
				return false;
			}
			if(totCnt > headCnt){
				for(var i=headCnt; i<=totCnt; i++){
					if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
					if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
						ComShowCodeMessage("VSK01018", "Terminal Code");
						sheetObj.SelectCell(i,"sheet2_yd_cd");
						return false;
					}
					if(sheetObj.GetCellValue(i, prefix+"turn_port_flg").length < 1){
						ComShowCodeMessage("VSK01018", "T/Port IND(N/Y)");
						sheetObj.SelectCell(i,"sheet2_turn_port_flg");
						return false;
					}
					var portCd=sheetObj.GetCellValue(i, prefix+"port_cd");
					var etbDyNo=sheetObj.GetCellValue(i, prefix+"etb_dy_no");
					var etbTmHrmnt=sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt");
					var etdDyNo=sheetObj.GetCellValue(i, prefix+"etd_dy_no");
					var etdTmHrmnt=sheetObj.GetCellValue(i, prefix+"etd_tm_hrmnt");
					// ETB, ETD가 순차적으로 입력되였는지 확인한다.
					if ((i < totCnt) && (etbDyNo+etbTmHrmnt)*1 >= (etdDyNo+etdTmHrmnt)*1) {
						ComShowCodeMessage("VSK01018", "Seq : "+(i-headCnt+1)+" (" +portCd+ ")ETB >= ETD");
						sheetObj.SelectCell(i,"sheet2_etb_dy_no");
						return false;
					}
					// Pre ETD, ETB가 순적적으로 입력되였는지 확인한다.
					if (i > headCnt) {
						var PrePortCd=sheetObj.GetCellValue(i-1, prefix+"port_cd");
						var preEtdDyNo=sheetObj.GetCellValue(i-1, prefix+"etd_dy_no");
						var preEtdTmHrmnt=sheetObj.GetCellValue(i-1, prefix+"etd_tm_hrmnt");
						if ((preEtdDyNo+preEtdTmHrmnt)*1 >= (etbDyNo+etbTmHrmnt)*1) {
							ComShowCodeMessage("VSK01018", "Seq : "+(i-headCnt+1)+"( " +PrePortCd+ ") Previous ETD >= (" +portCd+ ") Current ETB");
							sheetObj.SelectCell(i,"sheet2_etb_dy_no");
							return false;
						}
					}
				}
			}
			//2008 10 29 임창빈 수석이 Feeder 나 Trunker 상관없이 사용자가 입력한 
			//Manual에 따라 양방향, 단방향을 따진다
			var firstRow=getSearchFirstRow(sheetObjects[1]);
			var lastRow=searchLastRow()(sheetObjects[1]);
			var firstDirCd=sheetObjects[1].GetCellValue(firstRow,"sheet2_skd_dir_cd");
			var otherDirCd=0;
			//첫번째 포트의 Dir Cd와 다른 Dir Cd를 찾는다
			//사용자가 입력한 Dir Cd가 단 방향인지 (예 : 모든 Dir Cd가 W 아님 E )일 경우는 첫번째 포트의 Port Cd와 Yd Cd가 마지막 포트의 Port Cd, Yd Cd가  다르더라도 무방
			//사용자가 입력한 Dir Cd가 양 방향인지 (예 : Dir Cdrk W -> E, 아님 N -> S)일 경우는 첫번째 포트와 마지막 포트의 Port Cd와 Yd Cd가 같아야 한다
			for(var i=3; i<=sheetObjects[1].RowCount()+2; i++){
				//처음 입력한 포트의 dir_cd와 다른 첫번째 포트의 위치를 가져온다
				if(sheetObjects[1].GetCellValue(i,"sheet2_skd_dir_cd") != firstDirCd){
					otherDirCd=i;
					break;
				}
			}
			// 첫번째 포트의 Dir Cd와 다른 Dir Cd가 있을 경우  => 양 방향일경우
			// CHM-201005742-01 Non-Weekly P/F SKD 생성을 위해 DY_NO 동일 체크는 제거한다.
			if(otherDirCd > 0){
				if(sheetObjects[1].GetCellValue(firstRow,"sheet2_port_cd") == sheetObjects[1].GetCellValue(lastRow-1,"sheet2_port_cd")
						&& sheetObjects[1].GetCellValue(firstRow,"sheet2_yd_cd") == sheetObjects[1].GetCellValue(lastRow-1,"sheet2_yd_cd")
					  //&& sheetObjects[1].CellValue(firstRow,"sheet2_etb_dy_cd") == sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_dy_cd")
						&& sheetObjects[1].GetCellValue(firstRow,"sheet2_etb_tm_hrmnt") == sheetObjects[1].GetCellValue(lastRow-1,"sheet2_etb_tm_hrmnt")
					  ){
						// 첫번째, 마지막 Row에 Port, Yard, ETB, ETB Hour이 동일할 경우 마지막 Row에 ETD에 Day, Hour를 첫번째 Row와 동일 하게 생성한다.
						// Long Range SKD 생성시 필요함.
						//sheetObjects[1].CellValue(lastRow-1,"sheet2_etd_dy_cd") =  sheetObjects[1].CellValue(firstRow,"sheet2_etd_dy_cd");
					sheetObjects[1].SetCellValue(lastRow-1,"sheet2_etd_tm_hrmnt",sheetObjects[1].GetCellValue(firstRow,"sheet2_etd_tm_hrmnt"));
				}else{
					ComShowCodeMessage("VSK00084");
					if(sheetObjects[1].GetCellValue(firstRow,"sheet2_port_cd") != sheetObjects[1].GetCellValue(lastRow-1,"sheet2_port_cd")){
						sheetObjects[1].SelectCell(firstRow, "sheet2_port_cd", true);
					}else if(sheetObjects[1].GetCellValue(firstRow,"sheet2_yd_cd") != sheetObjects[1].GetCellValue(lastRow-1,"sheet2_yd_cd")){
						sheetObjects[1].SelectCell(firstRow, "sheet2_yd_cd", true);
					//}else if(sheetObjects[1].CellValue(firstRow,"sheet2_etb_dy_cd") != sheetObjects[1].CellValue(lastRow-1,"sheet2_etb_dy_cd")){
					//	sheetObjects[1].SelectCell(firstRow, "sheet2_etb_dy_cd", true);
					}else if(sheetObjects[1].GetCellValue(firstRow,"sheet2_etb_tm_hrmnt") != sheetObjects[1].GetCellValue(lastRow-1,"sheet2_etb_tm_hrmnt")){
						sheetObjects[1].SelectCell(firstRow, "sheet2_etb_tm_hrmnt", true);
					}
					return false;
				}
			}
			var pfTypeData=g_pfTypeData.split(":");
			if(pfTypeData[0] == "Y"){
				ComShowCodeMessage("VSK00091");
				formObj.pf_svc_tp_cd.value="";
				formObj.pf_svc_tp_cd.focus();
				return false;
			}else if(pfTypeData[1] == "Y"){
				ComShowCodeMessage("VSK00092");
				formObj.pf_svc_tp_cd.value="";
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			/*
			 * CHM-201005742-01 Non-Weekly P/F SKD 생성을 위한 검증 로직 추가
			 */
			// 입력한 Duration 값과 일정상의 Duration 값을 비교하고 다를 시에는 사용자에게 알린다.
			var dur1=Number(formObj.svc_dur_dys.value);
			var dur2=Number(sheetObj.GetCellValue(totCnt, prefix+"etb_dy_no")) - Number(sheetObj.GetCellValue(headCnt, prefix+"etb_dy_no"));
			if(dur1!=dur2){
				ComShowCodeMessage("VSK00096", "Duration or ETB No");
				return false;
			}
			// Duration을 Vessel의 척수로 나눈 값은 Frequence와 동일해야 한다.
			var vslCnt=Number(formObj.n1st_vsl_clss_knt.value) + Number(formObj.n2nd_vsl_clss_knt.value) + Number(formObj.n3rd_vsl_clss_knt.value);
			var frequency=Number(formObj.brth_itval_dys.value);
			if((dur1/vslCnt)!=frequency){
				ComShowCodeMessage("VSK00096", "Frequency or Vessel Class Count");
				return false;
			}
			break;
		case "simul":  
			var rowCnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
			var prefix=sheetObj.id + "_";
				if(sheetObjects[1].RowCount()< 1){
					ComShowCodeMessage("VSK00043");
					formObj.sim_dt.focus();
					return false;
				}
				if(rowCnt > 2){
					for(var i=3; i<=sheetObj.RowCount()+2; i++){
						if(i == 3){
							if(sheetObj.GetCellValue(i, prefix+"etb_dy_cd") == ""){
								ComShowCodeMessage("VSK01018", "ETB Day");
								sheetObj.SelectCell(i,"sheet2_etb_dy_cd");
								return false;
							}
							if(sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt") == ""){
								ComShowCodeMessage("VSK01018", "ETB Time");
								sheetObj.SelectCell(i,"sheet2_etb_tm_hrmnt");
								return false;
							}
						}
						if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
							ComShowCodeMessage("VSK01018", "Port Code");
							sheetObj.SelectCell(i,"sheet2_port_cd");
							return false;
						}
					}
				}
			break;
		case "vsl_slan_cd_change":      	//vsl_slan_cd onChange Event
			if(!ComIsNull(formObj.vsl_slan_cd.value)){
				if(formObj.vsl_slan_cd.value.length < 3){
					ComShowCodeMessage("VSK01018", "Lane Code");
					formObj.vsl_slan_cd.value="";
					return false;
				}
			} 
			break;
		case "Save":         //저장
			/*
			 * <필수 여부 검사>
			 * 1. Lane Code 3자리 확인.
			 * 3. Service Lane Type Code가 Feeder('O')가 아닌 경우 반드시 Proforma Type Code를 입력토록 한다.
			 * 4. Grid내에 Calling Port가 2개 이상 있어야 한다.
			 * 5. Calling Port Indicator를 설정한다.
			 * 6. Calling Sequence를 설정
			 * 7. Turn IND = 'Y' 일 경우 Turning Port 입력 여부 확인.
			 * 9. Port Code 5자리 확인
			 * 10. Yard Code 7자리 확인
			 * <EXCEPTION>
			 * 3.[VSK02005] 메시지 출력 후 리턴 Service Lane Type Code에 Focus On
			 * 4.[VSK02006] 메시지 출력 후 리턴
			 * 7.[VSK02007] 메시지 출력 후 리턴 해당 줄에 Focus On
			 * 8.[VSK02008] 메시지 출력 후 리턴 해당 줄에 Focus On
			 * 9.[VSK02009] 메시지 출력 후 리턴 해당 줄에 Port Code 항목에 Focus On
			 * 10.[VSK02010] 메시지 출력 후 리턴 해당 줄에 Yard Code 항목에 Focus On
			 */
			var rowCnt=sheetObj.RowCount()+ sheetObj.HeaderRows();
			var prefix=sheetObj.id + "_";
			if(formObj.sim_dt.value.length < 8){
				ComShowCodeMessage("VSK01018", "Simulation No.");
				formObj.sim_dt.focus();
				return false;
			}
			if(ComIsNull(formObj.sim_no.value)){
				ComShowCodeMessage('VSK00027', "Simulation date");
				formObj.sim_no.focus();
				return false;
			}
			if(formObj.vsl_slan_cd.value.length < 3){
				ComShowCodeMessage("VSK01018", "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return false;
			}
//			if(formObj.pf_svc_tp_cd.value.length < 4){
//				if(ComIsNull(formObj.pf_svc_tp_cd.value)){
//					//VSK02005
//					ComShowCodeMessage("VSK01018", "P/F SKD Type");
//					formObj.pf_svc_tp_cd.focus();
//					
//					return false;
//				}
//			}
			if(sheetObj.RowCount()< 2){
				//VSK02006
				ComShowCodeMessage("VSK00043");
				return false;
			}
			if(rowCnt > 2){
				for(var i=3; i<=sheetObj.RowCount()+2; i++){
					if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
						ComShowCodeMessage("VSK01018", "Port Code");
						sheetObj.SelectCell(i,"sheet2_port_cd");
						return false;
					}
					if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
						ComShowCodeMessage("VSK01018", "Terminal Code");
						sheetObj.SelectCell(i,"sheet2_yd_cd");
						return false;
					}
				}
			}
			break;
	}
    return true;
}
/**
 * Lane Code Help 파일을 오픈한다
 */
function openLandCdHelp(sheetObj){
   var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd";
   var v_display="0,0";
   var laneCd=document.form.vsl_slan_cd.value;
   //ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 520, 470, targetObjList, v_display, true);
   ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "getLaneCd", v_display, true);
}

function getLaneCd( rtnVal ){
	var formObj=document.form;
	if( rtnVal != "" ){
		formObj.vsl_slan_cd.value = rtnVal;
	}
}
/**
 * P/F Lane Type Code Help 파일을 오픈한다  
 */
function openPfLandTypeCdHelp(sheetObj){
	var formObj=document.form;
	var laneCd=formObj.vsl_slan_cd.value;
	var sUrl="/opuscntr/VOP_VSK_0241.do?vsl_slan_cd="+laneCd;
	ComOpenPopup(sUrl, 620, 490, "getPfTpyeCd", "0,0", true);
}
function getPfTpyeCd(obj){
	var formObj=document.form;
	if(obj){
		var rtnDatas=obj[0];
		if(rtnDatas.length > 0){
			document.form.pf_svc_tp_cd.value=rtnDatas[3];
			var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH06);
			//var pfTypeData = ComGetEtcData(sXml, "pfTypeData").split(":");
			var pfTypeData=ComGetEtcData(sXml, "pfTypeData");
			g_pfTypeData=pfTypeData;
//			if(pfTypeData[0] == "Y"){
//				ComShowCodeMessage("VSK00091");
//			 	formObj.pf_svc_tp_cd.value = "";
//			 	formObj.pf_svc_tp_cd.focus();
//			 }else if(pfTypeData[1] == "Y"){
//				ComShowCodeMessage("VSK00092");
//				formObj.pf_svc_tp_cd.value = "";
//				formObj.pf_svc_tp_cd.focus();
//			 }
		}
	}
}
/**
 *Simulation NO Code Help 파일을 오픈한다  
 */
function openSimNoCdHelp(sheetObj){
	var laneCd=document.form.vsl_slan_cd.value;
	var sUrl="/opuscntr/VOP_VSK_0201.do?uiFlg=A&vsl_slan_cd="+laneCd;
	ComOpenPopup(sUrl, 800, 470, "getSimData", "0,0", true);
}
function getSimData(obj){
	if(obj){
		var rtnDatas=obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				var vslSlanCdTemp=rtnDatas[2];
				document.form.vsl_slan_cd.value=vslSlanCdTemp;
				var simTemp=rtnDatas[4];
				simTemp=ComReplaceStr(simTemp,"-","");
				document.form.sim_dt.value=simTemp.substring(0,8);
				document.form.sim_no.value=Number(simTemp.substring(8,11));
			}
		}
	}
}
function open_BerthWindow(sheetObj1,sheetObj2,formObj){
	var masterCnt=sheetObj1.RowCount();
	var dtlCnt=sheetObj2.RowCount();
	var prefix=sheetObj2.id + "_";
	if(masterCnt < 1 || dtlCnt < 1){
		ComShowCodeMessage("VSK00043");
		formObj.sim_dt.focus();
		return;
	}
	for(var i=3; i<=sheetObj2.RowCount()+2; i++){
		if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
			ComShowCodeMessage("VSK01018", "Port Code");
			sheetObj.SelectCell(i,"sheet2_port_cd");
			return false;
		}
		if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
			ComShowCodeMessage("VSK01018", "Terminal Code");
			sheetObj.SelectCell(i,"sheet2_yd_cd");
			return false;
		}
	}
	sheetObj1.SetCellValue(1, "sheet1_hiddencheck","Y");
	for(var i=3; i<=sheetObj2.RowCount()+2; i++){
		sheetObj2.SetCellValue(i, "sheet2_hiddencheck","Y");
	}
	var vslSlanCd=formObj.vsl_slan_cd.value;
	var pfSvcTpCd=formObj.pf_svc_tp_cd.value;
	var seq=formObj.brth_itval_dys.value;
	var dur=formObj.svc_dur_dys.value;
	//sUrl = "/opuscntr/VOP_VSK_0238.do?op_=0238&vsl_slan_cd="+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd+"&seq="+seq+"&dur="+dur;
	sUrl="/opuscntr/VOP_VSK_0238.do?vsl_slan_cd="+vslSlanCd+"&pf_svc_tp_cd="+pfSvcTpCd+"&seq="+seq+"&dur="+dur;
	ComOpenPopup(sUrl, 900, 620, "", "0,0", true);
}
function openEOTPCreation(sheetObj1,sheetObj2,formObj){
	var cnt=sheetObj1.RowCount();
	var cnt2=sheetObj2.RowCount();
	//기존에 화면에서 조회를 하지않고 add Row로 데이타를 입력 후 EOTP를 오픈하는 것을
	//막았는데 그것을 풀고 pf_skd 데이타만 입력하지 않은면 막는 것으로 수정
	//if(cnt  < 1 ||  sheetObj1.CellValue(1,"sheet1_ibflag") == "I"){
	if(cnt2  < 1){
		ComShowCodeMessage("VSK00043");
		formObj.sim_dt.focus();
		return;
	}  
	sheetObj1.SetCellValue(1, "sheet1_hiddencheck","Y");
	for(var i=3; i<=sheetObj2.RowCount()+2; i++){
		sheetObj2.SetCellValue(i, "sheet2_hiddencheck","Y");
	}
	sUrl="/opuscntr/VOP_VSK_0243.do";
	ComOpenPopup(sUrl, 1020, 589, "returnEOTP", "none", true);
}
/**
 * EOTP (Pop-Up)에서 받은 데이타 처리.
 * [EOTP] Button Click 후 Pop-up에서 호출.
 * @param rtnObjs
 * @return
 */
function returnEOTP(rtnObjs){
	var formObj=document.form;
	var sheetObj=null;
	if(rtnObjs.length > 0){
		var rtnDatas=rtnObjs[idx];
		if(rtnDatas.length > 0){
			//sheetObj.CellValue2(currRow, prefix+"ts_port_cd") = rtnDatas[2];
		}
	}
}
/**
 * 화면을 초기화 한다.
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1,sheetObj2,formObj){
	formObj.sim_dt.value="";
	formObj.sim_no.value="";
	formObj.vsl_slan_cd.value="";
	formObj.slan_stnd_flg.value="N";
	formObj.pf_svc_tp_cd.value="";
	formObj.n1st_vsl_clss_cd.value="";
	formObj.n1st_vsl_clss_knt.value="";
	formObj.n2nd_vsl_clss_cd.value="";
	formObj.n2nd_vsl_clss_knt.value="";
	formObj.n3rd_vsl_clss_cd.value="";
	formObj.n3rd_vsl_clss_knt.value="";
	formObj.svc_dur_dys.value="";
	formObj.brth_itval_dys.value="";	
	formObj.pf_skd_rmk.value="";
	//formObj.clpt_knt.value = "";
	formObj.tot_buf_rat.value="";
	//formObj.ttl_dist.value = "";
	formObj.sea_buf_rat.value="";
	formObj.max_spd.value="";
	formObj.port_buf_rat.value="";
	//formObj.avg_spd.value = "";
	formObj.pf_spd_rat.value="";
	//formObj.buf_spd.value = "";
	formObj.buf_spd_rat.value="";
	formObj.eotp1.value="";
	formObj.eotp2.value="";
	formObj.lf.value="";
	formObj.rpb.value="";
	formObj.rev.value="";
	formObj.op.value="";
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
	formObj.sim_dt.focus();
	//All Check 초기화
	sheetObj2.CheckAll(sheetObj2.id+"_Sel",0);
}
/**
 * Enter키 이벤트
 * @param sheetObj
 * @param formObj
 * @return
 */
function doSearch(){
	var formObject=document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}
/**
 * grid 출력 후 Duration,Frequency 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function gridEndJob(sheetObj,formObj){
	formObj.slan_stnd_flg.value="N";
	var lastEtbDyNo=parseInt(sheetObj.GetCellValue(sheetObj.HeaderRows()+sheetObj.RowCount()-1,"sheet2_etb_dy_no"));
	var lastEtbTmHrmnt=sheetObj.GetCellValue(sheetObj.HeaderRows()+sheetObj.RowCount()-1,"sheet2_etb_tm_hrmnt");
	var firstEtbDyNo=parseInt(sheetObj.GetCellValue(sheetObj.HeaderRows(),"sheet2_etb_dy_no"));
	var firstEtbTmHrmnt=sheetObj.GetCellValue(sheetObj.HeaderRows(),"sheet2_etb_tm_hrmnt");
	var tempLastEtbTmHrmnt=lastEtbTmHrmnt.length;
	var tempFirstEtbTmHrmnt=firstEtbTmHrmnt.length;
	var lastEtbTmHrmntVal=0;
	var firstEtbTmHrmntVal=0;
	if(tempLastEtbTmHrmnt == 4){
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
	}else{
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
	}
	if(tempFirstEtbTmHrmnt == 4){
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,2);
	}else{
		firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,1);
	}
	var lastTot=parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
	var firstTot=parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
	var tempDur=parseInt(lastTot - firstTot);
	var durVal1=parseInt(tempDur/24);
	var resultDurVal=isNaN(durVal1);
	if(resultDurVal == true){
		durVal1=0;
	}
	formObj.svc_dur_dys.value=parseInt(durVal1);
/*	
	var vslClssKnt1=formObj.n1st_vsl_clss_knt.value;
	var vslClssKnt2=formObj.n2nd_vsl_clss_knt.value;
	if(vslClssKnt2 == "") vslClssKnt2=0;
	var vslClssKnt3=formObj.n3rd_vsl_clss_knt.value;
	if(vslClssKnt3 == "") vslClssKnt3=0;
	var totClssKnt=parseInt(vslClssKnt1)+parseInt(vslClssKnt2)+parseInt(vslClssKnt3);
	var svcDurDysVal=parseInt(formObj.svc_dur_dys.value);
	var freVal=svcDurDysVal/totClssKnt;
	var resultFreVal=isNaN(freVal);
	if(resultFreVal == true){
		freVal=0;
	}
	formObj.brth_itval_dys.value=parseInt(freVal);
*/	
}
/**
 * grid 출력 후 last 로우 Color 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowView(sheetObj,rowPos){
	var rdInx=rowPos - 1;		
	var prefix="sheet2_";
	var rtnRowCnt = getRowCount(sheetObj);
	if(rtnRowCnt > 0){
		//회색
		var grayColor="#EFEBEF";
		//흰색
		var withrColor="#FFFFFF";
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_dist",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_spd",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tztm_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_spd",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_in_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_out_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"act_wrk_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"port_buf_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ipcgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ipcgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ocn_cgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ocn_cgo_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tml_prod_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"crn_knt",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"turn_port_flg",0);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_no",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_cd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_tm_hrmnt",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_dist",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_spd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tztm_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_spd",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_out_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"act_wrk_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"port_buf_hrs",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ipcgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ipcgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ocn_cgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ocn_cgo_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tml_prod_qty",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"crn_knt",grayColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"turn_port_flg",grayColor);
		sheetObjects[1].SetCellBackColor(rdInx,prefix+"mnvr_in_hrs",withrColor);
	}
}
/**
 * grid 출력 후 last 로우 Color 셋팅
 * @param sheetObj
 * @param formObj
 * @return
 */
function setlastLowViewUndo(sheetObj,rowPos){
	var rdInx=rowPos - 1;					
	var prefix="sheet2_";
	var rtnRowCnt = getRowCount(sheetObj);
	if(rtnRowCnt > 0){
		//회색
		var grayColor="#EFEBE6";
		//흰색
		var withrColor="#FFFFFF";
		//검은색
		var blackColor="#000000";
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_dist",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"lnk_spd",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tztm_hrs",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"sea_buf_spd",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_in_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"mnvr_out_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"act_wrk_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"port_buf_hrs",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ipcgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ipcgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ib_ocn_cgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"ob_ocn_cgo_qty",1);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"tml_prod_qty",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"crn_knt",0);
		sheetObjects[1].SetCellEditable(rdInx, prefix+"turn_port_flg",1);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_no",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_dy_cd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"etd_tm_hrmnt",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_dist",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"lnk_spd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tztm_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"sea_buf_spd",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_in_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"mnvr_out_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"act_wrk_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"port_buf_hrs",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ipcgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ipcgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ib_ocn_cgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"ob_ocn_cgo_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"tml_prod_qty",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"crn_knt",blackColor);
		sheetObjects[1].SetCellFontColor(rdInx,prefix+"turn_port_flg",blackColor);
		//sheetObjects[1].CellBackColor(rdInx,prefix+"mnvr_in_hrs") = withrColor;
	}
}
/**
 * Row_SEQ 순차적으로 다시 생성
 * @param sheetObj
 * @return
 */
function resetRowSeq(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var prefix=sheetObj.id + "_";
	var idx=0;
	var vIbFlag="";
//	for(var i=0; i<rowCnt; i++){
//		if(sheetObj.CellValue(i+headCnt, prefix+"ibflag") != "D"){
//			vIbFlag = sheetObj.CellValue(i+headCnt, prefix+"ibflag");
//			idx++;
//			sheetObj.CellValue2(i+headCnt, prefix+"row_seq") = idx;
//			sheetObj.CellValue2(i+headCnt, prefix+"ibflag") = vIbFlag;
//		}
//	}
	for(var i=0; i<rowCnt; i++){
		if(sheetObj.GetRowStatus(i+headCnt) != "D"){
			vIbFlag=sheetObj.GetRowStatus(i+headCnt);
			idx++;
			sheetObj.SetCellValue(i+headCnt, prefix+"row_seq",idx,0);
			sheetObj.SetRowStatus(i+headCnt,vIbFlag);
		}
	}
}
/**
 * Delete된 Row를 제외한 마지막 로우를 찾늗다
 * @param sheetObj
 * @return
 */
function searchLastRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var prefix=sheetObj.id + "_";
	for(var i=totalCnt-1; i>headCnt-1; i--){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx=i;
			break;
		}
	}
	return idx+1;
}
/**
 * 첫번재 로우의 Manu In은 항상 가려져야 한다
 * 만약 첫번째 로우를 Delete하면 하위 로우중 Delete Flag가 아닌 로우의 Manu In을 가져준다
 * @param sheetObj
 * @return
 */
function searchFirstRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix=sheetObj.id + "_";
	var grayColor="#EFEBE6";
	var rtlRowCnt = getRowCount(sheetObj);
	if(rtlRowCnt > 0){
		for(var i=headCnt; i<totalCnt; i++){
			if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
				idx=i;
				break;
			}
		}
		sheetObj.SetCellEditable(idx, "sheet2_etb_dy_no",1);
		sheetObj.SetCellEditable(idx, "sheet2_etb_dy_cd",1);
		sheetObj.SetCellEditable(idx, "sheet2_etb_tm_hrmnt",1);
		sheetObj.SetCellEditable(idx, prefix+"mnvr_in_hrs",0);
		sheetObj.SetCellFontColor(idx,prefix+"mnvr_in_hrs",grayColor);
	}
}
/**
 * Delete된 Row를 제외한 첫번째 로우를 찾늗다
 * @param sheetObj
 * @return
 */
function getSearchFirstRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix=sheetObj.id + "_";
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx=i;
			break;
		}
	}
	return idx;
}
/**
 *  조회 조건이 아닌 모든 데이타 초기화.
 *  
 * @param sheetObj1
 * @param sheetObj2
 * @param formObj
 * @return
 */
function clearDescData(sheetObjects, formObj){
	formObj.vsl_slan_cd.value="";
	formObj.slan_stnd_flg.value="N";
	formObj.pf_svc_tp_cd.value="";
	formObj.n1st_vsl_clss_cd.value="";
	formObj.n1st_vsl_clss_knt.value="";
	formObj.n2nd_vsl_clss_cd.value="";
	formObj.n2nd_vsl_clss_knt.value="";
	formObj.n3rd_vsl_clss_cd.value="";
	formObj.n3rd_vsl_clss_knt.value="";
	formObj.svc_dur_dys.value="";
	formObj.brth_itval_dys.value="";	
	formObj.pf_skd_rmk.value="";
	formObj.tot_buf_rat.value="";
	formObj.sea_buf_rat.value="";
	formObj.max_spd.value="";
	formObj.port_buf_rat.value="";
	formObj.pf_spd_rat.value="";
	formObj.buf_spd_rat.value="";
	formObj.lf.value="";
	formObj.rev.value="";
	formObj.eotp1.value="";
	formObj.rpb.value="";
	formObj.op.value="";
	formObj.eotp2.value="";
	if(sheetObjects.length > 0){
		for(var i=0; i<sheetObjects.length; i++){
			sheetObjects[i].RemoveAll();
			if(i == 1){
				//All Check 초기화
				sheetObjects[i].CheckAll(sheetObjects[i].id+"_Sel",0);
			}
		}
	}
	formObj.sim_dt.focus();
}
/**
 * 
 * @param sheetObj
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
    if(sheetObj.RowCount()> 0){
    	//마우스 위치를 행과 컬럼과 값 가져오기
        var Row=sheetObj.MouseRow();
        var Col=sheetObj.MouseCol();
        var prefix=sheetObj.id+"_";
        if(Row > 0 && (colSaveName == "sheet2_port_cd" || Col == "sheet2_etb_dy_no" || Col == "sheet2_etb_dy_cd" || Col == "sheet2_etb_tm_hrmnt")){
        	var checkWkTm=sheetObj.GetCellValue(Row, "sheet2_check_wk_tm");
        	if(checkWkTm == "Y"){
	        	var sText=sheetObj.GetCellText(Row,"sheet2_crane_wk_tm");
	        	if(sText != ""){
	        		sheetObj.SetMousePointer("Hand");
	        	}else{
	                sheetObj.SetMousePointer("Default");
	        	}
        	}else{
            	sheetObj.SetMousePointer("Default");
            }
        }
    } 
}
function getRowCount(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var prefix=sheetObj.id + "_";
	for(var i=headCnt; i<totalCnt; i++){
		if(sheetObj.GetCellValue(i, prefix+"ibflag") != "D"){
			idx++;
		}
	}
	return idx;
}
function sheet2_OnBeforeEdit(sheetObj, Row, Col){
	bakObjForEdit=sheetObj.GetCellValue(Row, Col);
	//alert("Row == " + Row + " : Col == " + sheetObj.ColSaveName(Col) + " : " + sheetObj.CellValue(Row, Col));
}
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	if(bakObjForEdit != sheetObj.GetCellValue(Row, Col)){
		//alert("Row == " + Row + " : Col == " + sheetObj.ColSaveName(Col) + " : Before == " + bakObjForEdit + " :  After == " + sheetObj.CellValue(Row, Col));
		setEditMode(true);
	}
}
function setEditMode(mode){
	if(mode){
		editMode=true;
		ComBtnDisable("btn_Save");
		ComBtnDisable("btn_Settlement");
	}else{
		editMode=false;
		ComBtnEnable("btn_Save");
		ComBtnEnable("btn_Settlement");
	}
}
	/* 개발자 작업  끝 */