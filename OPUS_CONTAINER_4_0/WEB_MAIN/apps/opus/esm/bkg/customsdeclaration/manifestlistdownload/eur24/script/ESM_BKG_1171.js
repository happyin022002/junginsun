/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1171.js
*@FileTitle  : A/N with MRNs (FI) 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================
*/
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
 * @class esm_bkg_1171 : esm_bkg_1171 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
	/* 개발자 작업	*/
	var comboObjects=new Array();
	var comboCnt=0;
	// 공통전역변수
	var IBDOWNLOAD="IBDOWNLOAD";
	var sheetObjects=new Array();
	var sheetCnt=0;
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick=processButtonClick;
	// POFE에 mapping되는 YD_CD를 담아내는 배열 : form_cstms_yd_cd property에 mapping된다!
	var eu_1st_port_yd_cd=new Array();
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH); //Main
				doActionIBSheet(sheetObject1, formObject, SEARCH01); //Grid
				break;
			case "btn_new":
				doActionIBSheet(sheetObject1, formObject, IBINSERT); //Main
				sheetObject2.RemoveAll();                            //Grid
				break;
			case "btn_save":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
				break;
			case "btn_downExcel":
				if(sheetObject2.RowCount() < 1){//no data
	                   ComShowCodeMessage("COM132501");
	              }else{
	            	  if(validateForm(formObject, IBDOWNLOAD)){
	  	   	    		sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
	  	   	    	}
	              }
	   	    	
	   	        break;
			case "btn_transmit":
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				break;
			case "btn_History":
				  var row1=sheetObject1.GetSelectRow();
			      var row2=sheetObject2.GetSelectRow();
			      var p_vvd=sheetObject1.GetCellValue(row1, "vvd");
			      var p_pod_cd=sheetObject2.GetCellValue(row2, "pod");
			      var p_bl_no=sheetObject2.GetCellValue(row2, "bl_no");
			      ComOpenWindowCenter("/opuscntr/ESM_BKG_1172.do?pgmNo=ESM_BKG_1172&p_vvd=" + p_vvd + "&p_pod_cd=" + p_pod_cd+ "&p_bl_no=" + p_bl_no, "1172", 900, 500, false);
			      break;     
		    case "btn_viewMsg":
		    	 var row1=sheetObject1.GetSelectRow();
		    	 var row2=sheetObject2.GetSelectRow();
		    	 if (ComIsNull(sheetObject2.GetCellValue(row2,"ens_result"))) {
	    				ComShowCodeMessage('BKG00442');
	 					return;    
			      }
		    	 var edi_rcv_dt=sheetObject2.GetCellValue(row2, "edi_rcv_dt");
		    	 var edi_rcv_seq=sheetObject2.GetCellValue(row2, "edi_rcv_seq");
		    	 var cnt_cd="";
		    	 if (sheetObject2.GetCellValue(row2, "pod") <=0)
		    		 {
		    		 cnt_cd=sheetObject2.GetCellValue(row2, "pod");
		    		 }
		    	 else
		    		 {
		    		 cnt_cd=sheetObject2.GetCellValue(row2, "pod").substring(0,2);
		    		 }
		    	 ComOpenWindowCenter("/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1171", 540, 600, false);//
		    	 break;  
			} // end switch
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
		var formObj=document.form;
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for (i=0; i < comboObjects.length; i++) {
			initCombo(comboObjects[i], i + 1);
		}
		//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		// axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
		// axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm('change', 'obj_change', document.form);
		SetButtonStatus();
	}
	 /**
	 * 화면 로드 시 버튼 처리
	 */
	function SetButtonStatus(){
		if (document.form.vvd.value == ''){
			ComBtnDisable("btn_transmit");
		} else {
				if(document.form.form_an_edi_svc_flg.value == 'Y'){
					ComBtnEnable("btn_transmit");
				}else{
					ComBtnDisable("btn_transmit");
				}
	    }
	} 
	/**
	 * 화면 로딩 완료 후 이벤트
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		initSheetData(sheetObjects[0], formObj);
		ComSetFocus(formObj.form_vvd_cd);
	}
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
		case "sheet1":
		    with(sheetObj){
			      var HeadTitle1="| |vvd|cvy_ref_no|cvy_ref_no_hidden|vsl_cd|skd_voy_no|skd_dir_cd|vsl_eng_nm|lloyd_no|piclb_desc|cstms_port_cd|eta_dt|etd_dt|n1st_port_ofc_cd|tml_cd|tml_nm|lst_clpt_cd|nxt_clpt_cd|rgst_no|rgst_dt|rgst_port_cd|grs_rgst_tong_wgt|net_rgst_tong_wgt|cre_usr_id|cre_dt|upd_usr_id|upd_dt|snd_usr_id|snd_dt|snd_ofc_cd|ack|result|cstms_yd_cd|edi_rcv_dt|edi_rcv_seq|edi_rcv_dt_msg|crr_cd|init_eta_dt|an_edi_svc_flg|port_net_no";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"cvy_ref_no_hidden",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lloyd_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"piclb_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"eta_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"etd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"n1st_port_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"tml_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"tml_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"lst_clpt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"nxt_clpt_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"rgst_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"grs_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"net_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"snd_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ack",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"result",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cstms_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"edi_rcv_dt_msg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"crr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"init_eta_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"an_edi_svc_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"port_net_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetSheetHeight(100);
	            }
			break;
		case "sheet2":
		    with(sheetObj){
			      var HeadTitle1="|Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|CNTR No|Ack.Status|result2|Sent Time(GMT)|ENS MRN|Received Time(GMT)||edi_rcv_seq|edi_rcv_dt|bkg_no";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      headCount=ComCountHeadTitle(HeadTitle1);
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sel",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_status",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bpol",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bpod",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_cntr_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ens_result",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"result2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"sent_time",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"received_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_yn",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			      InitColumns(cols);
			      SetEditable(1);
			      SetSelectionMode(smSelectionRow);
			      SetSheetHeight(280);
		      }
			break;
		}
	}
	/**
	 * Sheet관련 프로세스 처리
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
		case IBSEARCH: //조회
			if (!validateForm(sheetObj, formObj, sAction)) return false;
			formObj.f_cmd.value=SEARCH;
	//		if(form.p_type.Code == "ENS") {
	//			formObj.vvd.value = formObj.form_vvd.value;
	//			formObj.cvy_ref_no.value = formObj.form_cvy_ref_no.value;
	//			var cstms_yd_cd = formObj.form_cstms_yd_cd.value;
	//			formObj.cstms_yd_cd.value = formObj.form_cstms_yd_cd.value;
	//			
	//			var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_1171GS.do",	FormQueryString(formObj));
	//			var valResult = ComGetEtcData(sXml, "data");
	//			sheetObjects[0].LoadSearchXml(sXml);
	//			
	//			var vvd = sheetObjects[0].CellValue(1, "vvd");
	//			
	//			if(vvd == "CSGP0071W" || vvd == "CSHI0074W" || vvd == "COLH0178W" || vvd == "CHKG0079W" ||  vvd == "CHAM0076W" 
	//					 || vvd == "CRTM0069W" ||  vvd == "CQIN0083W"){
	//				var oldDt = sheetObjects[0].CellValue(1, "init_eta_dt");
	//				var timeDt = oldDt.substr(10,6);
	//				var newDt = ComGetDateAdd(oldDt, "D", -1)+timeDt;
	//				sheetObjects[0].CellValue2(1, "init_eta_dt") = newDt;	
	//			}
	//			
	//			if (sheetObj.RowCount == 1) {
	//				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
	//				if (cstms_yd_cd != '' && cstms_yd_cd != undefined)
	//					formObj.form_cstms_yd_cd.value = cstms_yd_cd;
	//			} else {
	//				ComShowCodeMessage('BKG00095', "VSL Code");
	//				initSheetData(sheetObj, formObj);
	//				ComSetFocus(formObj.form_vvd);
	//			}
			//} else { // Finland (IE344)
		    formObj.vvd.value=formObj.form_fi_vvd.value;
			formObj.port_net_no.value=formObj.form_fi_cvy_ref_no.value;
			var cstms_yd_cd=formObj.form_fi_cstms_yd_cd.value;
			formObj.cstms_yd_cd.value=formObj.form_fi_cstms_yd_cd.value;
			formObj.eur_edi_msg_tp_id.value="347";
			var sParam=""; 
			sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&" + FormQueryString(formObj);
			var sXml=sheetObjects[0].GetSearchData("ESM_BKG_1171GS.do", sParam);
			var valResult=ComGetEtcData(sXml, "data");
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			var vvd=sheetObjects[0].GetCellValue(1, "vvd");
			if (vvd != "") {
				IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
				if (cstms_yd_cd != '' && cstms_yd_cd != undefined) formObj.form_fi_cstms_yd_cd.value=cstms_yd_cd;
				formObj.form_fi_cvy_ref_no.value=sheetObjects[0].GetCellValue(1, "port_net_no");
			} else {
				ComShowCodeMessage('BKG00095');
				initSheetData(sheetObjects[0], formObj);
				ComSetFocus(formObj.form_fi_vvd);
//				formObj.form_fi_vvd.value = "";
//				formObj.form_fi_eta_dt.value = "";
//				formObj.form_fi_etd_dt.value = "";
//				//formObj.form_fi_cvy_ref_no.value = "";
//				ComSetFocus(formObj.form_fi_vvd);
			}
		//}
			SetButtonStatus();
			break;
			case SEARCH01: //조회
				if (!validateForm(sheetObj, formObj, sAction))
					return false;
					formObj.f_cmd.value=SEARCH01;
				    formObj.vvd.value=formObj.form_fi_vvd.value;
					//formObj.cvy_ref_no.value = formObj.form_fi_cvy_ref_no.value;
					var cstms_yd_cd=formObj.form_fi_cstms_yd_cd.value;
					formObj.cstms_yd_cd.value=formObj.form_fi_cstms_yd_cd.value;
					formObj.eur_edi_msg_tp_id.value="347";
					var sParam=""; 
					sParam += "cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value	+ "&" + FormQueryString(formObj); 
					var sXml=sheetObjects[1].GetSearchData("ESM_BKG_1171GS.do", sParam);
					var valResult=ComGetEtcData(sXml, "data");
					sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				    SetButtonStatus();
			break;
		case IBINSERT: // 초기화
			initSheetData(sheetObjects[0], formObj);
			formObj.form_fi_vvd.value="";
			formObj.form_fi_cvy_ref_no.value="";
			ComSetFocus(formObj.form_fi_vvd);
			break;
		case IBSAVE: // 저장,수정
			if (!validateForm(sheetObj, formObj, sAction)) return;
			formObj.form_cstms_port_cd.value=formObj.form_fi_cstms_yd_cd.value;
			formObj.form_cstms_yd_cd.value=sheetObjects[0].GetCellValue(1, "tml_cd");
			formObj.form_port_net_no.value=formObj.form_fi_cvy_ref_no.value; 
			IBS_CopyFormToRow(formObj, sheetObj, 1, "form_");
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			sheetObj.DoSave("ESM_BKG_1171GS.do", FormQueryString(formObj));
			ComOpenWait(false);
			break;
		case MULTI01: // 전송	
			if (!validateForm(sheetObj, formObj, sAction)) return;
			if (sheetObjects[1].CheckedRows("sel") <= 0 ) {
		        ComShowCodeMessage("COM12189");
		        return;
		    }
	        var sParam=""; 
			formObj.vvd.value=formObj.form_fi_vvd.value;
			formObj.form_cstms_port_cd.value=formObj.form_fi_cstms_yd_cd.value;
		//	formObj.form_cstms_yd_cd.value = sheetObjects[0].CellValue(1, "tml_cd");
			formObj.form_port_net_no.value=formObj.form_fi_cvy_ref_no.value; 
			var arrRow=ComFindText(sheetObjects[1], "sel", 1);
			var tempBlno="";
			for(var i=0; i< arrRow.length; i++) {
				if (tempBlno == sheetObjects[1].GetCellValue(arrRow[i], "bl_no")) continue; //BL 같은 거 있으면 건너 뜀 (merge 기능때문에)
				sParam += "&" +  "ibflag=U"     +"&bl_no="       +sheetObjects[1].GetCellValue(arrRow[i], "bl_no") +"&pod_cd=" + sheetObjects[1].GetCellValue(arrRow[i], "pod") +"&cstms_port_cd="	+ formObj.form_fi_cstms_yd_cd.value + "&"+ "p_type=" + "FI"+"&";
				formObj.f_cmd.value=MULTI01;
				sParam += "&" + FormQueryString(formObj);
				tempBlno=sheetObjects[1].GetCellValue(arrRow[i], "bl_no");
			}
			var sXml=sheetObjects[1].GetSaveData("ESM_BKG_1171GS.do", sParam);
			var valResult=ComGetEtcData(sXml, "flatFile");
			formObj.flatfile.value=valResult;
			var state=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
			if (state != "S"){
				ComShowCodeMessage("BKG00099"); // Failed to transmit ED!!
			} else{
				ComShowCodeMessage("BKG00101"); // Data Transmitted Successfully!!
			}
			doActionIBSheet(sheetObjects[1], document.form, SEARCH01);
			ComOpenWait(false);
			break;
		}
	 }
	// 시트 데이터 초기화
	function initSheetData(sheetObj, formObj) {
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
		if(sheetObj.GetCellValue(1, "vvd_cd") != ""){
			IBS_CopyRowToForm(sheetObj, formObj, 1, "form_");
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: { 
				if (formObj.form_fi_vvd.value == "") {
					ComShowCodeMessage("BKG00115"); // "Please, input VVD!"
					ComSetFocus(formObj.form_fi_vvd);
					return false;
				}
			break;
		}
		case MULTI01: {
			if (!ComChkValid(formObj))	return false;
			if (formObj.form_n1st_port_ofc_cd.value == "") {
				ComShowCodeMessage('BKG01131');
				ComSetFocus(formObj.form_n1st_port_ofc_cd);
				return false;
			}
		}
		} // end switch
		return true;
	}
	/**
	 * 저장 후 이벤트
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			if (document.form.f_cmd.value == MULTI
					&& document.form.f_cmd_detail.value != "D") {
				ComShowCodeMessage('BKG00102');
				return false;
			}
			if (document.form.f_cmd_detail.value == "D") {
				ComShowCodeMessage('BKG00593');
				return false;
			}
		}
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
	 /**
	  * 조회후  이벤트 처리 >>> 폰트 칼라변경
	  */
	 function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		 var formObj=document.form;
		 with (sheetObj) {
	    	var rfsFlg="N";
	    	var rfsBls="";
	    	var rfsCnt=0;  // RFS 신고 대상 개수 2개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
	    	var tempBl="";
	    	var rfsBlArray=new Array();
	    	ShowSubSum([{StdCol:"pod", SumCols:"dr_yn", Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("bl_status")}]);
	    	var redColor="#FF0000";
	    	var blueColor="#0000FF";
	    	for (var i=HeaderRows(); i<= LastRow(); i++) {
	        	 if (GetCellValue(i,"result2") == "DNL" || GetCellValue(i,"result2") == "R" || GetCellValue(i,"result2") == "H") {
	        		 SetCellFontColor(i,"ens_result",redColor);
	        		 SetCellFontUnderline(i,"ens_result",1);
	        	 } else if(GetCellValue(i,"rcv_msg") != "" || GetCellValue(i,"result2") == "L"){
	        		 SetCellFontColor(i,"ens_result",blueColor);
	        	 }
            	SetColFontUnderline("bl_no",1);
    			SetColFontColor("bl_no",blueColor);
	                //}
    			if (GetCellValue(i,"trsm_blck_flg")=="Y"){
            		SetCellBackColor(i,"sel","#EFF0F3");
	            		// 해당 bl_no 랑 bl_status 컬럼에 가운데 줄
            			SetCellFont("FontStrikethru", i,"bl_status",1);
	                    SetCellFont("FontStrikethru", i,"bl_no",1);
	        		}
	//                if(ComGetObjValue(formObj.p_pod_cd_temp).substring(0,5) != "FIKTK" && formObj.p_type.Code == "ENS"){
	//                	if (CellValue(i,"rfs_yn") == "Y"){
	//						rfsFlg = "Y";
	//            			if(rfsBlArray[CellValue(i, "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
	//            				rfsBlArray[CellValue(i, "bl_no")] = CellValue(i, "bl_no");
	//							
	//            				rfsCnt++;
	//							if(rfsCnt <= 2)
	//								rfsBls += CellValue(i, "bl_no")+", ";
	//						}
	//    				}
	//					if (tempBl== CellValue(i, "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
	//					tempBl = CellValue(i, "bl_no");
	//                }
	    		}
	         if(rfsFlg == "Y" && rfsCnt > 0){
	        	 rfsBls=rfsCnt > 2 ? rfsBls+"..etc.":rfsBls.substring(0,rfsBls.length-1);
	        	 // BKGs via FIKTK are selected, "BKG NO, BKG NO, ..."
	        	 // Do not miss to send ENS to second POFE “FIKTK”.
	//        	 second POFE alert msg 제거
	//        	 ComShowCodeMessage('BKG06147',rfsBls);
	         }
	     }//end width
	     pagedMaxCnt=sheetObj.LastRow();
	     // 체크박스 초기화
	     sheetObj.CheckAll("sel",0,1);
	 }	
	/**
	 * 폼 필드 변경시 이벤트
	 * 
	 * @return
	 */
	function obj_change() {
		var formObj=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var srcMaxLength= ComGetEvent("maxlength");
		var srcValue= ComGetEvent("value");
		if (srcName == "cstms_port_cd") {
			var comboIndex=comboObjects[1].GetSelectIndex();
		}
	}
	/**
	 * 조회조건 입력할 때 처리
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		var srcMaxLength = ComGetEvent("maxlength");
		var srcValue = ComGetEvent("value");
	}
	/**
	 * 컨테이너 리스트 콤보 변경시 이벤트
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */
	function cstms_port_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text) {
		var formObj=document.form;
		var index=comboObj.GetSelectIndex();
		formObj.form_cstms_yd_cd.value=eu_1st_port_yd_cd[index];
	}
	/**
	 * Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	//function p_type_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {//CHECK OLD CODE: OnChange(comboObj, value, text){
	//	if(form.p_type.Code == "ENS") {
	//		document.getElementById("ensView").style.display = "Inline";
	//		document.getElementById("fiView").style.display = "none";
	//		ComSetDisplay("ensEtaView", true);
	//		ComSetDisplay("fiEtaView", false);
	//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	//		document.form.eur_edi_msg_tp_id.value = "ARN"
	//	} else if (form.p_type.Code == "FI") {
	//		document.getElementById("ensView").style.display = "none";
	//		document.getElementById("fiView").style.display = "Inline";
	//		ComSetDisplay("ensEtaView", false);
	//		ComSetDisplay("fiEtaView", true);
	//		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
	//		document.form.eur_edi_msg_tp_id.value = "347"
	//	}
	//	document.form.reset();
	//	sheetObjects[0].RemoveAll();
	//}
	 /**
	  * 시트를 행 다중선택 시 처리
	  */
	 function sheet2_OnSelectMenu(sheetObj, sAction) {
	 	 //메뉴에 대한 처리 Check selected|Unheck selected|-|Check all|Uncheck all
	 	  switch(sAction){
	 	    case "Check selected" :
	 	      var sRowStr=sheetObj.GetSelectionRows("/");
	 	      //자바 스크립트 배열로 만들기
	 	      var arr=sRowStr.split("/");
	 	      for (i=0; i<arr.length; i++) {
	 	    	  if(arr[i] < 2) continue;//header 부분
	 	    	  if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	 	    	  if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	 	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
		  		    		for(var j=0; j <= sameRows.length ; j++) {
		  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
		  		    			sheetObj.SetCellValue(sameRows[j], "sel",1,0);
		  		    		}
	 	    	  }else
	 	    		  sheetObj.SetCellValue(arr[i], "sel",1,0);
	 	      }
	 	      break;
	 	    case "Unheck selected" :
	 	    	var sRowStr=sheetObj.GetSelectionRows("/");
	 	    	//자바 스크립트 배열로 만들기
	 	    	var arr=sRowStr.split("/");
	 	    	for (i=0; i<arr.length; i++) {
	 	    		if(arr[i] < 2) continue;//header 부분
	 	    		if(sheetObj.GetCellValue(arr[i],"bl_no") == "") continue;//subsum 행이면
	 	    		if(i== arr.length-1){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
	 	    			var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(arr[i],"dt_seq"));
	 	    			for(var j=0; j <= sameRows.length ; j++) {
	 	    				if(sameRows[j] == undefined || sameRows[j] == "") continue;
	 	    				sheetObj.SetCellValue(sameRows[j], "sel",0,0);
	 	    			}
	 	    		} else
	 	    			sheetObj.SetCellValue(arr[i], "sel",0,0);
	 	    	}
	 	      break;
	 	    case "Check all" :
	 	    	sheetObj.CheckAll("sel",1,1);
	 	    	break;
	 	    case "Uncheck all" :
	 	    	sheetObj.CheckAll("sel",0,1);
	 	    	break;
	 	  }
	 }
	 var startSelectedRow=0 ; //shift + 마우스 클릭 으로 체크시키기  위함.
	 /**
	  * sheet1 All 체크시 체크플래그 세팅
	  * @param sheetObj 시트오브젝트
	  * @param Button 마우스버튼 방향
	  * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
	  * @param X X 좌표
	  * @param Y Y 좌표
	  */
	 function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y) {
	 	if(Shift == 0){
	 		startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
	 		var colSaveName=sheetObj.ColSaveName(sheetObj.MouseCol());
	 		var check=sheetObj.GetCellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
	 		var keySeq=sheetObj.GetCellValue(startSelectedRow,"dt_seq");
		        switch(colSaveName) {
			    	case "sel" :
			    		if(startSelectedRow < 2) return;
			    		//alert(startSelectedRow +" "+check+" "+keySeq);
			    		for(i=startSelectedRow ; i<= sheetObj.LastRow(); i++) {
			    			if(eval(keySeq) < eval(sheetObj.GetCellValue(i, "dt_seq")) ) break;
			    			if(keySeq == sheetObj.GetCellValue(i, "dt_seq")) {
			    				sheetObj.SetCellValue(i, "sel",check);
			    			}
			    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
			    		}
			    		break;
		        } // end switch
	 	} else {
	 		var endSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.;
	 		startSelectedRow=startSelectedRow ==0 ? endSelectedRow:startSelectedRow;
		    		if(startSelectedRow > endSelectedRow){
		    			endSelectedRow=startSelectedRow;
		    			startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
		    		}
		    		for (var i=startSelectedRow; i <= endSelectedRow; i++) {
		    	    	  if(i < sheetObj.HeaderRows()) continue;//header 부분
		    	    	  if(sheetObj.GetCellValue(i,"bl_no") == "") continue;//subsum 행이면
		    	    	  if(i== endSelectedRow){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
		    	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(i,"dt_seq"));
		    	    		  if(sheetObjects[0].GetCellValue(i,"trsm_blck_flg")=="Y"){
			    	    		  sheetObj.SetCellValue(i, "sel",0,0);
			    	    		} else {
		    	    		  		for(var j=0; j <= sameRows.length ; j++) {
	 	    		  				if(sameRows[j] == undefined || sameRows[j] == "") continue;
	 	    		  				sheetObj.SetCellValue(sameRows[j], "sel",1,0);
			    	    		  	}
			    	    	  }
		    	    	  } else{
		    	    		  if(sheetObjects[0].GetCellValue(i,"trsm_blck_flg")=="N"){
		    	    			  sheetObj.SetCellValue(i, "sel",1,0);
		    	    		  } else {
		    	    			  sheetObj.SetCellValue(i, "sel",0,0);
		    	    		  }
		    	    	  }
		    	      }
	 	}
	 }
	 /**
	  * 시트를 클릭했을 때 처리 0127참조
	  */
	 function sheet2_OnClick(sheetObj, row, col) {
	 	var colSaveName=sheetObj.ColSaveName(col);
	     switch(colSaveName) {
	    	case "sel" :
	    		if(sheetObj.GetCellValue(row,"bl_no") == "") return;//subsum 행이면
	    		var check=sheetObj.GetCellValue(row,"sel") == 1 ?0:1;
	    		sheetObj.SetCellValue(row, "sel",check,0);//mousedown 에서 처리한것을 다시 역으로 처리하므로 이것을 다시 역으로 바꿔준다.
	    		break;
	    	case "ens_result":
	    		var row2=sheetObjects[1].GetSelectRow();
	    		if (sheetObj.GetCellValue(row,"result2") != "R" && sheetObj.GetCellValue(row,"result2") != "DNL" ) {
	             	return;
	            }	                
	    		var edi_rcv_dt=sheetObj.GetCellValue(row, "edi_rcv_dt");
	    		var edi_rcv_seq=sheetObj.GetCellValue(row, "edi_rcv_seq");
	    		var cnt_cd=sheetObjects[1].GetCellValue(row2, "pod").substring(0,2);
	    		ComOpenWindowCenter("/opuscntr/ESM_BKG_1112.do?pgmNo=ESM_BKG_1112&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1171", 540, 600, false);
	    		break;   
	     } // end switch
	 }
	 /**
	  * Booking Creation 화면 이동
	  * @param sheetObj Sheet
	  * @param Row Row Index
	  * @param Col Col Index
	  */
	 function sheet2_OnDblClick(sheetObj, row, col) {
        var colSaveName=sheetObjects[1].ColSaveName(col);
        switch(colSaveName) {
        	case "bl_no" :
        		ComBkgCall0079(sheetObjects[1].GetCellValue(row, "bkg_no"));
	    	break;
        } // end switch
	 }	 
	/* 개발자 작업  끝 */