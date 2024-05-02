/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_1121.js
*@FileTitle  : Europe Advanced Manifest  : EXS Download  & Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	
	//  global variable
	var sheetObjects = new Array();
	var sheetCnt = 0;	
    var comboObjects = new Array();
    var comboCnt = 0;
	
    //전역변수
    var intervalId = "";
    
     // Event handler processing by button click event */
    document.onclick = processButtonClick;
 	
    // Event handler processing by button name */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	    var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
   	//try {
   		var srcName=ComGetEvent("name");
   		if(ComGetBtnDisable(srcName)) return false;

        switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
			case "btn_New":
				formObject.reset();
				sheetObject1.RemoveAll();
				p_pol_cd_temp.RemoveAll();
				div_option.innerHTML=""; 
				ComBtnDisable("btn_Inquiry");
				ComBtnDisable("btn_Transmit");
				ComBtnEnable("btn_EDIDownload");
//				formObject.div_ttl_bl.value="";
//				formObject.div_ttl_err.value="";
//				formObject.div_ttl_cntr.value="";
				
				break;
			case "btn_DownExcel":
				
				if(sheetObject1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObject1),Merge:1,DownSum:1});
				}
				break;
         	case "btn_EDIDownload":
         		doActionIBSheet(sheetObject1,formObject,MULTI);
          		break;  
          	case "btn_BLAdd":
          		break;  
          	case "btn_BLDelete":
          		break;  
			case "btn_Inquiry":
	    		if (sheetObject1.CheckedRows("sel") <= 0 ) {
	    			ComShowCodeMessage("COM12189");
	    			return;
	    		}
				var arrRow=ComFindText(sheetObject1, "sel", 1);
				var tempBlno=sheetObject1.GetCellValue(arrRow[0], "bl_no"); //bl_no가 머지 되어있어 CheckedRows의 개수로는 유효성검사가 안된다.
				for(var i=0; i< arrRow.length; i++) {
					//B/L no가 두개 이상 체크되면 에러처리
					if (tempBlno != sheetObject1.GetCellValue(arrRow[i], "bl_no")) {
						ComShowCodeMessage("BKG01134");
		    			return;
					}
					//tempBlno = sheetObject1.CellValue(arrRow[i], "bl_no");
				}
				var p_bl_no=sheetObject1.GetCellValue(arrRow[0], "bl_no");
		        ComOpenWindowCenter("/opuscntr/ESM_BKG_1124_POP.do?pgmNo=ESM_BKG_1124&bl_no=" + p_bl_no, "1107", 1150, 700, false);
				break;  
			case "btn_Transmit":
				formObject.p_send_yn.value="Y";
				doActionIBSheet(sheetObject1, formObject, MULTI03);
				break;  
			case "btn_Makefile":
				/*
				formObject.p_send_yn.value="N";
				doActionIBSheet(sheetObject1, formObject, MULTI01);
				*/
				break;  
			case "p_data_cd":
				sheetObject1.RemoveAll();
				div_option.innerHTML="";
				
				formObject.div_ttl_bl.value="";
				formObject.div_ttl_err.value="";
				formObject.div_ttl_cntr.value="";
				formObject.port_ofc_cd.value="";
				formObject.div_sent_bl_cnt.value="";
				formObject.div_unsent_bl_cnt.value="";
				formObject.div_sent_bl_cnt2.value="";
				formObject.div_a_cnt.value="";
				formObject.div_r_cnt.value="";
				formObject.div_dnl_cnt.value="";
				formObject.div_h_cnt.value="";
				formObject.div_l_cnt.value="";
				formObject.div_nr_cnt.value="";
				
				if(ComGetObjValue(formObject.p_data_cd) == "BL"){
					ComBtnDisable("btn_Inquiry");
					ComBtnDisable("btn_Transmit");
					ComBtnEnable("btn_EDIDownload");
				}else{
					ComBtnEnable("btn_Inquiry");
					ComBtnEnable("btn_Transmit");
					ComBtnDisable("btn_EDIDownload");
				}
				break;  
			case "btn_Delete":
				doActionIBSheet(sheetObject1, formObject, MULTI05);
				break;  
           } // end switch
//   	}catch(e) {
//   		if( e == "[object Error]") {
//   			ComShowMessage(OBJECT_ERROR);
//   		} else {
//   			ComShowMessage(e);
//   		}
//   	}
   }

    
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){

    	sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    /**
     * registering combo Object at comboObjects list 
     * @param combo_obj
     * @return
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj; 
    }
    
    
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */                    
    function loadPage() {
    	var formObj = document.form;
    	
		for(i=0;i<sheetObjects.length;i++){
	        ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
	        ComEndConfigSheet(sheetObjects[i]);
		}
		
	    // initializing MultiCombo 
	    for(var k=0;k<comboObjects.length;k++){
	        initCombo(comboObjects[k],comboObjects[k].options.id);
	    }
	    
		ComBtnDisable("btn_BLAdd");
		ComBtnDisable("btn_BLDelete");
		ComBtnDisable("btn_Inquiry");
		ComBtnDisable("btn_Transmit");
		
		initControl();
		
		doActionIBSheet(sheetObjects[0],document.form,SEARCH05);

	}
    
    /**
     * handling buttons on loading
     */
    function SetButtonStatus(){
    		// Customs Common Code 테이블의 EU Staff 인 경우에만 Data Delete 버튼 활성화
    		if(sheetObjects[0].GetCellValue(2, "eu_stf_flg")=="Y" && ComGetObjValue(document.form.p_data_cd2) == "DL"){
    			document.getElementById("btn_Delete").style.display='';
    		}else{
    			document.getElementById("btn_Delete").style.display='none';
    		}		
        }
    
     function initControl() {
     	var formObject = document.form;

        axon_event.addListenerFormat('focus', 'bkg_focus',    formObject); //- 포커스 들어갈때
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
        axon_event.addListenerForm ('change', 'bkg_change', formObject);
     }

    /**
     * Combo Object initialization
     * @param comboObj
     * @param comNo
     * @return
     */
 	function initCombo(comboObj, comboId) {
  	    var formObject=document.form
 		initComboEditable(comboObj, comboId);
  	}
 	
 	/** 
 	* 콤보 멀티 셀렉트 및 수정 여부 초기 설정 <br> 
 	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
 	* @param {String} comboId 필수,combo ID
 	* @return 없음.
 	*/ 
  	function initComboEditable(combo, comboId) {
 		with (combo) {
	 		if(comboId == "p_pol_cd_temp" ){
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
 	 			ValidChar(2,1);//영어대문자,숫자포함 도움말 ValidChar 참고
	 		}
 		}
 	} 	

/*********************** KEY EVENT START ********************/ 	 
    /**
     * 폼 필드 변경시 이벤트
     * 
     * @return
     */
    function bkg_change(){
	    switch (ComGetEvent("name")) {
	    	case "p_vvd_cd":
	    		sheetObjects[2].RemoveAll();
	    		p_pol_cd_temp.RemoveAll();
	    		form.p_pod_yard_cd.value="";
//	   	 		form.p_search_pofe_yard_cd.value = "";
	    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
	    		if(p_pol_cd_temp.GetItemCount() >= 1 ){
	    			p_pol_cd_temp.SetSelectIndex(0);
	    		}
	    		form.p_pod_cd.focus();
				break;
			default:
				break;
	    }
    }

    /**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg_focus(){
		//입력Validation 확인하기
		switch(ComGetEvent("name")){	
	    	case "bkg_from_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
	    	case "bkg_to_dt":
	    		ComClearSeparator(ComGetEvent());
					break;
			default:
					break;
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
			case "sheet1":
			    with(sheetObj){
		       
		      var HeadTitle1="Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|SH|SH|SH|SH|SH|SH|SH|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|CNEE|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|NTFY|B/L Data|B/L Data|B/L Data|UPDATE\nREASON|Container Data|Container Data|Container Data|Container Data|Container Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|C/M Data|rcv_msg|EDI|EDI|EDI|EDI|EDI|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|eu_stf_flg|IB Flag";
		      var HeadTitle2="Seq.|Sel.|Transmit\nType|B/L No|POL|POD|B/POL|B/POD|DEL|C/T|L/T|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str|EORI|NM|AD|CT|CN|ZIP|Str |EORI|PK|WT|MS|UPDATE\nREASON|CNTR  No|Seal|PK|WT|MS|PK|WT|MS|DS|MK|HS|rcv_msg|Ack. Status|Sent Time(GMT)|MRN|Ref No|Received Time(GMT)|vsl_cd|skd_voy_no|skd_dir_cd|eu_1st_port|eu_1st_port_yd_cd|bkg_no|err_yn|download_yn|msg_snd_no|dr|result2|edi_rcv_dt|edi_rcv_seq|kts_send_dt|IB Flag";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);
		      //(headCount, 5, 0, true);

		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0, FrozenCol:5 } );

		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"dt_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"sel",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"bl_status",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bpol",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bpod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ct",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ad",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_ct",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_cn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_zip",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_str",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sh_eori",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ad",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_ct",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_cn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_zip",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_str",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cnee_eori",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ad",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_ct",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_cn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_zip",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_str",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ntfy_eori",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_pk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_wt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bl_ms",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:200,  Align:"Left",    ColMerge:1,   SaveName:"update_reason",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_seal",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_pk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_wt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_ms",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_pk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_wt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_ms",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_ds",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_mk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cm_hts",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"rcv_msg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ens_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"sent_time",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
		             {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"received_time",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0, Wrap:1 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"err_yn",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"download_yn",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"msg_snd_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"dr_yn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"result2",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_rcv_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"kts_send_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_stf_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		       
		      InitColumns(cols);
		      SetEditable(1);
		      SetSheetHeight(330);
		      SetSelectionMode(smSelectionRow);
		      SetRangeBackColor(1,11,1,50,"#555555");
		      SetRangeBackColor(1,51,1,52,"#555555");

		      SetCountPosition(0);
//		      ShowSubSum([{StdCol:"pod", SumCols:"dr_yn", Sort:false, ShowCumulate:false, CaptionCol:SaveNameCol("bl_status")}]);
		      }


				break;
			case "sheet2":
			    with(sheetObj){
		        
		      var HeadTitle1="|cnt_cd";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                   {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cnt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetSheetHeight(280);
		      SetEditable(0);
		     
		            }
				break;
			case "sheet3":
			    with(sheetObj){		       
		      var HeadTitle1="|search_eu_1st_port_yd_cd|eu_1st_port_yd_cd|eu_1st_port_name|eu_1st_port|edi_mrn";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [   {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"search_eu_1st_port_yd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_yd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port_name",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"eu_1st_port",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"edi_mrn",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		      SetSheetHeight(280);
		      SetEditable(0);
		            }

				break;
		}//end switch
	} 
	/**
	 * Trans Type 콤보 이벤트 처리 
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */ 
	function p_pol_cd_temp_OnChange(comboObj, value, text){
		 if(value.substr(0,2)=="GB"){
			 sheetObjects[0].SetColHidden("update_reason",0);
		 }else{
			 sheetObjects[0].SetColHidden("update_reason",1);
		 }
	}      
 
	/**
	 * 시트를 행 다중선택 시 처리
	 */
	function sheet1_OnSelectMenu(sheetObj, sAction) {

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
  	    		}else
  	    			sheetObj.SetCellValue(arr[i], "sel",0,0);
  	    	}
  	    	break;
  	    case "Check all" :
  	    	sheetObj.CheckAll("sel",1,1);break;
  	    case "Uncheck all" :
  	    	sheetObj.CheckAll("sel",0,1);break;
	  	}
	    	  
	}
	    
	var startSelectedRow =0 ; //shift + 마우스 클릭 으로 체크시키기  위함.
    /**
     * sheet1 All 체크시 체크플래그 세팅
     * @param sheetObj 시트오브젝트
     * @param Button 마우스버튼 방향
     * @param Shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param X X 좌표
     * @param Y Y 좌표
     */
//    function sheet1_OnMouseDown(sheetObj, Button, Shift, X, Y) {
//    	if(Shift == 0){
//    		startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
//    		var colSaveName=sheetObj.ColSaveName(sheetObj.MouseCol());
//    		var check=sheetObj.GetCellValue(startSelectedRow,"sel") == 0?1:0;//down일때 아직 체크박스가 바뀌기 전이므로 미리 바꾸어 놓는다.
//    		var keySeq=sheetObj.GetCellValue(startSelectedRow,"dt_seq");
//	        switch(colSaveName) {
//		    	case "sel" :
//		    		if(startSelectedRow < 2) return;
//		    		//alert(startSelectedRow +" "+check+" "+keySeq);
//		    		for(i=startSelectedRow ; i<= sheetObj.LastRow(); i++) {
//		    			if(eval(keySeq) < eval(sheetObj.GetCellValue(i, "dt_seq")) ) break;
//		    			if(keySeq == sheetObj.GetCellValue(i, "dt_seq")) {
//		    					sheetObj.SetCellValue(i, "sel",check);
//			    			}
//			    			//alert(i+" " + keySeq+" "+sheetObj.CellValue(i, "dt_seq"));
//		    		}
//		    		break;
//	        } // end switch
//    	}else{
//    		var endSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.;
//    		startSelectedRow=startSelectedRow ==0 ? endSelectedRow:startSelectedRow;
//	    		if(startSelectedRow > endSelectedRow){
//	    			endSelectedRow=startSelectedRow;
//	    			startSelectedRow=sheetObj.FindText("dt_seq",sheetObj.GetCellValue(sheetObj.MouseRow(),"dt_seq"));//현재 클릭된 seq중 가장 적은 것을 찾는다. merge 때문.
//	    		}
//	    		for (var i=startSelectedRow; i <= endSelectedRow; i++) {
//	    	    	  if(i < sheetObj.HeaderRows()) continue;//header 부분
//	    	    	  if(sheetObj.GetCellValue(i,"bl_no") == "") continue;//subsum 행이면
//	    	    	  if(i== endSelectedRow){//마지막 셀렉션 로우는 머지된 행들의 가장 빠른 것만 가져온다. 따라서 나머지도 체크 처리한다.
//	    	    		  var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(i,"dt_seq"));
//		  		    		for(var j=0; j <= sameRows.length ; j++) {
//		  		    			if(sameRows[j] == undefined || sameRows[j] == "") continue;
//		  		    			sheetObj.SetCellValue(sameRows[j], "sel",1,0);
//		  		    		}
//	    	    	  }else{
//	    	    		  sheetObj.SetCellValue(i, "sel",1,0);
//	    	    	  }
//	    	      }
//    	}//shift end
//    }//method end

	    	    
    /**
     * 시트를 클릭했을 때 처리 0127참조
     */
    function sheet1_OnClick(sheetObj, row, col) {
    	var colSaveName=sheetObj.ColSaveName(col);
        switch(colSaveName) {
        	case "bl_no" :
        		if (ComGetObjValue(form.p_data_cd) == "DL") {
		            return;
	    		}
        		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
        		break;
	    	case "sel" :
                var bl_no = sheetObj.GetCellValue(row, "bl_no");
                for(var i=1; i <= sheetObj.RowCount() + 1 ; i++) {
                    if (sheetObj.GetCellValue(i, "bl_no") == bl_no) {
                        sheetObj.SetCellValue(i, "sel", sheetObj.GetCellValue(row, "sel")) ;
                    }
                }
                break;
	    	case "ens_result":
				if (sheetObj.GetCellValue(row,"result2") != "R" && sheetObj.GetCellValue(row,"result2") != "DNL"
				&& sheetObj.GetCellValue(row,"result2") != "D" && sheetObj.GetCellValue(row,"result2") != "P" && sheetObj.GetCellValue(row,"result2") != "H") {
                	return;
                }	                
    			 //ComShowMemoPad(sheetObj, row, "rcv_msg", true, 300, 150);	//편집불가능
				var edi_rcv_dt=sheetObj.GetCellValue(row, "edi_rcv_dt");
				var edi_rcv_seq=sheetObj.GetCellValue(row, "edi_rcv_seq");
				var cnt_cd=sheetObj.GetCellValue(row, "pol").substring(0,2);
		       ComOpenWindowCenter("/opuscntr/ESM_BKG_1128.do?pgmNo=ESM_BKG_1128&edi_rcv_dt=" + edi_rcv_dt + "&edi_rcv_seq=" + edi_rcv_seq+"&cnt_cd="+cnt_cd, "1104", 540, 600, false);
		       break;   
        } // end switch
    }
 
     /**
      * Booking Creation 화면 이동
      * @param sheetObj Sheet
      * @param Row Row Index
      * @param Col Col Index
      */
    function sheet1_OnDblClick(sheetObj, row, col) {
        var colSaveName=sheetObj.ColSaveName(col);
        switch(colSaveName) {
        	case "bl_no" :
        		if (ComGetObjValue(form.p_data_cd) == "DL") {
		            return;
	    		}
        		ComBkgCall0079(sheetObj.GetCellValue(row, "bkg_no"));
        		break;
	  		case "update_reason":
	  			var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(row,"dt_seq"));
				//머지된셀이기 때문에 모두 에디터 불가능하게 한다.
	    		for(var i=0; i <= sameRows.length ; i++) {
	    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
	    			sheetObj.SetCellEditable(sameRows[i], "update_reason",0);
	    		}
   				ComShowMemoPad(sheetObj, row, col, false, 400, 200);
   				/*JSP에서 function setMemoValue(sValue,iMax) 오버 라이딩함 Apply적용시 onChange가 발생 및
   				 * 머지된셀을 에디터블 가능 불가능을 하기 위함.
   				 */
	    	break;
        } // end switch
    }	

     /**
      * bl별 머지 되도록 처리하기 위해
      * CoObject.js에 있는 함수를 오버라이딩 한것임
      * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
      * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
      */
 	function setSameBlUpdateReason(memoRow, memoCol,sValue) {
 		var sheetObj=sheetObjects[0];
 		var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(memoRow,"dt_seq"));
		for(var i=0; i <= sameRows.length ; i++) {
//    			if(sheetObj.CellValue(i,"bl_no") == "") continue;//subsum 행이면
			if(sameRows[i] == undefined || sameRows[i] == "") continue;
			sheetObj.SetCellValue(sameRows[i], "update_reason",sValue == ""  ? " ": sValue,0);
			sheetObj.SetCellEditable(sameRows[i], "update_reason",1);//다시 수정가능하게 한다.
		}
 	}	
 		     

    /**
    * sheet1 All 체크시 체크플래그 세팅
    * @param sheetObj 시트오브젝트
	* @param Row Long 해당 셀의 Row Index 
	* @param Col Long 해당 셀의 Column Index 
	* @param KeyCode Integer 키보드의 아스키 값 
	* @param Shift Integer Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0 
    * 
    */
//	    function sheet1_OnKeyUp(sheetObj,row, col, keyCode, Shift)  {
//	    	//return;
//	    	var colSaveName = sheetObj.ColSaveName(col);
//	    	switch(colSaveName) {
//	    	
//	    	//Del키 처리시 처리하기 위함
//	    	case "update_reason":
//	    		//alert(Shift);
//	    		if(sheetObj.CellValue(row,"bl_no") == "") return;//subsum 행이면
//	    		if(keyCode == 46){
//			  		var sameRows = ComFindText(sheetObj,"dt_seq",sheetObj.CellValue(row,"dt_seq"));
//			  		if(sameRows.length < 2) return;
//		    		for(var i =0; i <= sameRows.length ; i++) {
//		    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
//		    			sheetObj.CellValue2(sameRows[i], "update_reason") = ' ' ;
//		    		}
//	    		}
//	    		break;
//	    	} // end switch
//	    }//method end	 
    
    /**
    * sheet1 All 체크시 체크플래그 세팅
    * @param sheetObj 시트오브젝트
	* @param row Long 해당 셀의 Row Index 
	* @param col Long 해당 셀의 Column Index 
	* @param val 변경된 값, Format이 적용되지 않은 저장 시 사용되는  
    * 
    */
    function sheet1_OnChange(sheetObj,row, col, sValue)  {
    	//return;
    	var colSaveName=sheetObj.ColSaveName(col);
    	switch(colSaveName) {
    	//memopad를  안띄우고 직접입력할 경우 머지된 셀 처리를 위함
    	case "update_reason":
    		if(sheetObj.GetCellValue(row,"bl_no") == "") return;//subsum 행이면
    		var sameRows=ComFindText(sheetObj,"dt_seq",sheetObj.GetCellValue(row,"dt_seq"));
	  		if(sameRows.length < 2) return;
    		for(var i=0; i <= sameRows.length ; i++) {
    			if(sameRows[i] == undefined || sameRows[i] == "") continue;
    			sheetObj.SetCellValue(sameRows[i], "update_reason",sValue == ""  ? " ": sValue,0);
    		}
    		break;
    	} // end switch
    }//method end	
 
	    	    
	     /**
      * 조회후  이벤트 처리 >>> 폰트 칼라변경
      */
     function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	    var formObj = document.form; 
			if(bl_sc_no == 0 && sheetObj.RowCount()< 1 && p_pol_cd_temp.GetItemCount() < 1){
				ComShowCodeMessage('BKG95001','select a EU POL');
			} 
			if (bl_sc_no == 1 && sheetObj.RowCount()> 0 && temp_pol_yd != ""){
				p_pol_cd_temp.SetSelectText(temp_pol_yd);
				formObj.p_pol_yard_cd.value=temp_pol_yd;
			}
			if(sheetObj.RowCount()> 0) {
				formObj.search_eu_pol_cd.value=p_pol_cd_temp.GetSelectText();
			}	    	 
         with (sheetObj) {
        	  //pod별로 그룹을 묶어 pod를 소그룹 상단에 보여준다. 따라서 sum은  보여줄 필요가 없으므로 히든 칼럼 중 하나를 선택해서 sum칼럼으로 지정한다.
//no support[implemented common]CLT 	        	 MessageText("SubSum")="POD";
        	 
             var redColor="#FF0000";
             var blueColor="#0000FF";
             var blackColor="#000000";
             
             for(var i=HeaderRows(); i<= LastRow(); i++) {
				if (isError(GetCellValue(i,"sh_nm"))) SetCellFontColor(i,SaveNameCol("sh_nm"),redColor);
				if (isError(GetCellValue(i,"sh_ad")))SetCellFontColor(i,SaveNameCol("sh_ad"),redColor);
				if (isError(GetCellValue(i,"sh_ct"))) SetCellFontColor(i,SaveNameCol("sh_ct"),redColor);
				if (isError(GetCellValue(i,"sh_cn"))) SetCellFontColor(i,SaveNameCol("sh_cn"),redColor);
				if (isError(GetCellValue(i,"sh_zip"))) SetCellFontColor(i,SaveNameCol("sh_zip"),redColor);
				if (isError(GetCellValue(i,"sh_str"))) SetCellFontColor(i,SaveNameCol("sh_str"),redColor);
				if (isError(GetCellValue(i,"sh_eori"))) SetCellFontColor(i,SaveNameCol("sh_eori"),redColor);
				if (isError(GetCellValue(i,"cnee_nm"))) SetCellFontColor(i,SaveNameCol("cnee_nm"),redColor);
				if (isError(GetCellValue(i,"cnee_ad"))) SetCellFontColor(i,SaveNameCol("cnee_ad"),redColor);
				if (isError(GetCellValue(i,"cnee_ct"))) SetCellFontColor(i,SaveNameCol("cnee_ct"),redColor);
				if (isError(GetCellValue(i,"cnee_cn"))) SetCellFontColor(i,SaveNameCol("cnee_cn"),redColor);
				if (isError(GetCellValue(i,"cnee_zip"))) SetCellFontColor(i,SaveNameCol("cnee_zip"),redColor);
				if (isError(GetCellValue(i,"cnee_str"))) SetCellFontColor(i,SaveNameCol("cnee_str"),redColor);
				if (isError(GetCellValue(i,"cnee_eori"))) SetCellFontColor(i,SaveNameCol("cnee_eori"),redColor);
				if (isError(GetCellValue(i,"ntfy_nm"))) SetCellFontColor(i,SaveNameCol("ntfy_nm"),redColor);
				if (isError(GetCellValue(i,"ntfy_ad"))) SetCellFontColor(i,SaveNameCol("ntfy_ad"),redColor);
				if (isError(GetCellValue(i,"ntfy_ct"))) SetCellFontColor(i,SaveNameCol("ntfy_ct"),redColor);
				if (isError(GetCellValue(i,"ntfy_cn"))) SetCellFontColor(i,SaveNameCol("ntfy_cn"),redColor);
				if (isError(GetCellValue(i,"ntfy_zip"))) SetCellFontColor(i,SaveNameCol("ntfy_zip"),redColor);
				if (isError(GetCellValue(i,"ntfy_str"))) SetCellFontColor(i,SaveNameCol("ntfy_str"),redColor);
				if (isError(GetCellValue(i,"ntfy_eori"))) SetCellFontColor(i,SaveNameCol("ntfy_eori"),redColor);
				if (isError(GetCellValue(i,"bl_pk"))) SetCellFontColor(i,SaveNameCol("bl_pk"),redColor);
				if (isError(GetCellValue(i,"bl_wt"))) SetCellFontColor(i,SaveNameCol("bl_wt"),redColor);
				if (isError(GetCellValue(i,"cntr_seal"))) SetCellFontColor(i,SaveNameCol("cntr_seal"),redColor);
				if (isError(GetCellValue(i,"cntr_pk"))) SetCellFontColor(i,SaveNameCol("cntr_pk"),redColor);
				if (isError(GetCellValue(i,"cntr_wt"))) SetCellFontColor(i,SaveNameCol("cntr_wt"),redColor);
				if (isError(GetCellValue(i,"cntr_ms"))) SetCellFontColor(i,SaveNameCol("cntr_ms"),redColor);
				if (isError(GetCellValue(i,"cm_pk"))) SetCellFontColor(i,SaveNameCol("cm_pk"),redColor);
				if (isError(GetCellValue(i,"cm_wt"))) SetCellFontColor(i,SaveNameCol("cm_wt"),redColor);
				if (isError(GetCellValue(i,"cm_ds"))) SetCellFontColor(i,SaveNameCol("cm_ds"),redColor);
				if (isError(GetCellValue(i,"cm_mk"))) SetCellFontColor(i,SaveNameCol("cm_mk"),redColor);
				
				if (GetCellValue(i,"result2") == "DNL" || GetCellValue(i,"result2") == "R" || GetCellValue(i,"result2") == "D" || GetCellValue(i,"result2") == "P" || GetCellValue(i,"result2") == "H") {
					SetCellFontColor(i,SaveNameCol("ens_result"),redColor);
					SetCellFontUnderline(i,"ens_result",1);
				}else if(GetCellValue(i,"rcv_msg") != ""){
					SetCellFontColor(i,SaveNameCol("ens_result"),blueColor);
	            }
                if (ComGetObjValue(form.p_data_cd) == "BL") {
                	SetColFontColor("bl_no",blueColor);
                	SetColFontUnderline("bl_no",1);
                	
                }else if(ComGetObjValue(form.p_data_cd) == "DL"){
                	SetColFontColor("bl_no",blackColor);
                	SetColFontUnderline("bl_no",0);
                }
                
             }
         }//end width
         pagedMaxCnt=sheetObj.LastRow();
         SetButtonStatus();
     }
    
     
     /**
      * Booking Creation 화면 이동
      * @param String cellValue
      * return boolean 에러여부
      */
     function isError(cellValue) {
	    if(cellValue == "E") return true;
	    
     	return false;
     }		
     
    
 	
          
    
     var ata_yn ="";
     
     /* A/N Sending 후 Accepted 된 VVD에 대한 ENS전송 방지 */
     var arn_yn ="";
     /* Diversion Request된 VVD에 대한 ENS전송 방지 */
     var dr_yn ="";
     
    /**
     * Sheet관련 프로세스 처리<br>
     * 
     * @param sheetObj
     * @param formObj
     * @param sAction
     */
     var bl_sc_no=0;
     var temp_pol_yd="";
    function doActionIBSheet(sheetObj,formObj,sAction) {

    	sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {

			case MULTI01: // EDI FLAT FILE 생성 및 전송
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				
				var arrRow = ComFindText(sheetObj, "sel", 1);

				var sParam = "";  
				var tempBlno = ""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				for(var i= 0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.CellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					sParam +=   "ibflag=U"      +"&"+
								"p_send_yn="    +formObj.p_send_yn.value+"&"+
					            "vsl_cd="       +sheetObj.CellValue(arrRow[i], "vsl_cd"        )+"&"+
					            "skd_voy_no="   +sheetObj.CellValue(arrRow[i], "skd_voy_no"    )+"&"+
					            "skd_dir_cd="   +sheetObj.CellValue(arrRow[i], "skd_dir_cd"    )+"&"+
					            "bl_no="        +sheetObj.CellValue(arrRow[i], "bl_no"         )+"&"+
					            "pol="          +sheetObj.CellValue(arrRow[i], "pol"           )+"&"+
					            "update_reason="+sheetObj.UrlEncoding(sheetObj.CellValue(arrRow[i], "update_reason" ))+"&";
					tempBlno = sheetObj.CellValue(arrRow[i], "bl_no");
					
				}
				
				formObj.f_cmd.value = MULTI01;
				sParam += "&" + FormQueryString(formObj);
//				alert(sParam);
//			    return;
//				
				ComOpenWait(true,true);
 				var sXml = sheetObj.GetSaveXml("ESM_BKG_1121GS.do", sParam)
				var key = ComGetEtcData(sXml, "KEY");
				intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

	 				
				break;
			case MULTI03: // EDI FLAT FILE 생성 및 전송 - 단건
				
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				var arrRow=ComFindText(sheetObj, "sel", 1);
				var sParam="";  
				var tempBlno=""; //bl_no가 머지 되어있어 같은게 두번나온다 이를 체크하여 같으면 건너뛴다.
				var successCnt=0; 
				var failCnt=0;
				ComOpenWait(true);
				for(var i=0; i< arrRow.length; i++) {
					if (tempBlno == sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
					sParam="ibflag=U"      +"&"+
					"p_send_yn="    +formObj.p_send_yn.value+"&"+
					"vsl_cd="       +sheetObj.GetCellValue(arrRow[i], "vsl_cd"        )+"&"+
					"skd_voy_no="   +sheetObj.GetCellValue(arrRow[i], "skd_voy_no"    )+"&"+
					"skd_dir_cd="   +sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"    )+"&"+
					"bl_no="        +sheetObj.GetCellValue(arrRow[i], "bl_no"         )+"&"+
					"pol="          +sheetObj.GetCellValue(arrRow[i], "pol"           )+"&";
					formObj.f_cmd.value=MULTI03;
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObj.GetSaveData("ESM_BKG_1121GS.do", sParam)
					var state=ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if (state != "S"){
						failCnt++;
					}else{
						successCnt++;
					}
					tempBlno=sheetObj.GetCellValue(arrRow[i], "bl_no");
				}
				//성공메시지 보여주고
	     		//ComShowCodeMessage('BKG00101');
				ComShowMessage("Total:"+(successCnt+failCnt)+"\nSuccess:"+successCnt+"\nFail:"+failCnt);
	     		ComOpenWait(false);
	     		//전송 성공 후 재조회함.
	     		doActionIBSheet(sheetObj,form,IBSEARCH);	
				break;				
			case IBSEARCH : // 조회
				if(!validateForm(sheetObj,formObj,sAction)) return;
				
				sheetObj.RenderSheet(0);
				sheetObj.SetWaitImageVisible(1);
//				sheetObj.RemoveAll();
				if (!ComIsNull(formObj.p_bl_no) && ComIsNull(formObj.p_vvd_cd)) {
					formObj.f_cmd.value=SEARCH04;
					var pofeXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj));
					var vvd_cnt=ComGetEtcData(pofeXml,"vvd_cnt");
					var pol_cnt=ComGetEtcData(pofeXml,"pol_cnt");
					var temp_pol=ComGetEtcData(pofeXml,"pol");//bl로 조회한 pol
					    temp_pol_yd=ComGetEtcData(pofeXml,"pol_yd");//bl로 조회한 pol
					formObj.p_pol_cd.value=temp_pol;
					formObj.p_pol_yard_cd.value=temp_pol_yd;
					formObj.p_vvd_cd.value=ComGetEtcData(pofeXml,"vvd");
					formObj.p_pod_cd.value=ComGetEtcData(pofeXml,"pod");
					formObj.p_pod_yard_cd.value=ComGetEtcData(pofeXml,"pod_yd");
					doActionIBSheet(sheetObj, formObj, SEARCH01);
//					if(eval(vvd_cnt) > 1){
//						ComShowCodeMessage('BKG95001','BL이 2개이상 VVD를 가지고 있습니다. 직접 입력해주세요.');
//						sheetObj.Redraw = true;
//						sheetObj.WaitImageVisible = false;
//						return;
//					}
					if(p_pol_cd_temp.GetItemCount() == 1){
						p_pol_cd_temp.SetSelectIndex(0);
					}else if(p_pol_cd_temp.GetItemCount() > 1){
						//doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
			    		p_pol_cd_temp.SetSelectText(temp_pol);
			    		p_pol_cd_temp.focus();
			    		//ComShowCodeMessage('BKG95001','select a EU POL');
						sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						bl_sc_no=1;
			    		//return;
					}else{
						ComShowCodeMessage('BKG03061','BL:'+formObj.p_bl_no.value);
						sheetObj.RenderSheet(1);
						sheetObj.SetWaitImageVisible(0);
						return;
		    		}
	    		}
				formObj.f_cmd.value=SEARCH;
				formObj.p_pol_cd.value=ComGetObjValue(p_pol_cd_temp);
//				formObj.p_pol_yard_cd.value = sheetObjects[2].CellValue(sheetObjects[2].FindText('eu_1st_port',formObj.p_pol_cd.value),"eu_1st_port_yd_cd");
				formObj.p_pol_yard_cd.value=ComGetObjValue(p_pol_cd_temp);
//				if ( ComIsNull(formObj.p_pol_yard_cd) ) {
//					ComShowCodeMessage('BKG03061','EU POL');
//					sheetObj.Redraw = true;
//					sheetObj.WaitImageVisible = false;
//					return;
//				}
				var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				if(ComGetEtcData(sXml,"div_pol") == undefined){
					div_option.innerHTML=""; //"POL :  / ETD :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; POD (1st EU Port) :  / ETA : " ;
					formObj.div_ttl_bl.value="0";
					formObj.div_ttl_err.value="0";
					formObj.div_ttl_cntr.value="0";
					formObj.port_ofc_cd.value="";
					formObj.div_sent_bl_cnt.value="0";
					formObj.div_unsent_bl_cnt.value="0";
					formObj.div_sent_bl_cnt2.value="0";
					formObj.div_a_cnt.value="0";
					formObj.div_r_cnt.value="0";
					formObj.div_dnl_cnt.value="0";
					formObj.div_h_cnt.value="0";
					formObj.div_l_cnt.value="0";
					formObj.div_nr_cnt.value="0";
					ata_yn="";
					arn_yn="";
					dr_yn="";
//			
				}else{
					div_option.innerHTML="EU POL : "                + ComGetEtcData(sXml,"div_pol")
					                     + " / ETD : "             + ComGetEtcData(sXml,"vps_etd_dt");
//					                     + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
//					                     +" POD (1st EU Port) : "  + ComGetEtcData(sXml,"eu_1st_port")
//					                     + " / ETA : "             + ComGetEtcData(sXml,"vps_eta_dt"); 
					formObj.div_ttl_bl.value=ComGetEtcData(sXml,"ttl_bl");
					formObj.div_ttl_err.value=ComGetEtcData(sXml,"ttl_err_bl");
					formObj.div_ttl_cntr.value=ComGetEtcData(sXml,"ttl_cntr");
					formObj.port_ofc_cd.value=ComGetEtcData(sXml,"port_ofc_cd");
					formObj.div_sent_bl_cnt.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_unsent_bl_cnt.value=ComGetEtcData(sXml,"unsent_bl_cnt");
					formObj.div_sent_bl_cnt2.value=ComGetEtcData(sXml,"sent_bl_cnt");
					formObj.div_a_cnt.value=ComGetEtcData(sXml,"a_cnt");
					formObj.div_r_cnt.value=ComGetEtcData(sXml,"r_cnt");
					formObj.div_dnl_cnt.value=ComGetEtcData(sXml,"dnl_cnt");
					formObj.div_h_cnt.value=ComGetEtcData(sXml,"h_cnt");
					formObj.div_l_cnt.value=ComGetEtcData(sXml,"l_cnt");
					formObj.div_nr_cnt.value=ComGetEtcData(sXml,"nr_cnt");
					ata_yn=ComGetEtcData(sXml,"ata_yn");
					arn_yn=ComGetEtcData(sXml,"arn_yn");
					dr_yn=ComGetEtcData(sXml,"dr_yn");
					if(ComGetObjValue(formObj.p_data_cd) == "DL"){
 						if(ComGetEtcData(sXml,"exs_edi_svc_flg") == "Y")
 							ComBtnEnable("btn_Transmit");
 						else
 							ComBtnDisable("btn_Transmit");
 					}
				}
				sheetObj.RenderSheet(1);
				sheetObj.SetWaitImageVisible(0);
				break;
			case SEARCH01 : // pol 조회
			//if(!validateForm(sheetObj,formObj,sAction)) return;
			sheetObj.RenderSheet(0);
			sheetObj.SetWaitImageVisible(1);
			formObj.f_cmd.value=SEARCH01;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj));
//			ComXml2ComboItem(sXml, formObj.p_pol_cd_temp, "eu_1st_port", "eu_1st_port");
			ComXml2ComboItem(sXml, p_pol_cd_temp, "search_eu_1st_port_yd_cd", "search_eu_1st_port_yd_cd");
			sheetObjects[2].LoadSearchData(sXml,{Sync:0} );
			//formObj.p_pol_cd.value = ComGetEtcData(sXml,"eu_1st_port");
			sheetObj.RenderSheet(1);
			sheetObj.SetWaitImageVisible(0);

			
			break;
			case SEARCH05 : // eu 포트 조회
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				
				
				sheetObjects[1].RenderSheet(0);
				sheetObjects[1].SetWaitImageVisible(1);
				formObj.f_cmd.value=SEARCH05;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", FormQueryString(formObj));
				sheetObjects[1].LoadSearchData(sXml,{Sync:0} );
				sheetObjects[1].RenderSheet(1);
				sheetObjects[1].SetWaitImageVisible(0);

				
				
				break;
			case MULTI: //저장
				if ( !validateForm(sheetObj, formObj, sAction)) return;
	            var cntr_list="";
				var arrRow=ComFindText(sheetObj, "sel", 1);
				var p_eu_1st_port="";
				var p_eu_1st_port_yd_cd="";
				if (arrRow && arrRow.length > 0) {
					p_eu_1st_port_yd_cd=sheetObj.GetCellValue(arrRow[0], "eu_1st_port_yd_cd");
					for (var i=0; i<arrRow.length; i++) {
						cntr_list += sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+","+
						sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+","+
						sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+","+
						sheetObj.GetCellValue(arrRow[i], "bl_no"        )+","+
						sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+","+
						sheetObj.GetCellValue(arrRow[i], "cntr_cntr_no" )+","+
						sheetObj.GetCellValue(arrRow[i], "edi_mrn"      )+","+
						sheetObj.GetCellValue(arrRow[i], "msg_snd_no" )+"@";
					}
				}
				if(ComGetLenByByte(cntr_list) > 4000){
					cntr_list=getStringToClobString(cntr_list, 30,"@")
				} else{
					cntr_list="'"+cntr_list+"'";
				}
			  //alert(cntr_list);
			  //return;
			  sheetObj.SetWaitImageVisible(0);
			  ComOpenWait(true);
			  formObj.f_cmd.value=MULTI;
			  var sParam="&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list+"&eu_1st_port="+p_eu_1st_port+"&eu_1st_port_yd_cd="+p_eu_1st_port_yd_cd;
			  var xmlStr=sheetObj.GetSaveData("ESM_BKG_1121GS.do", sParam);
			  var sResult=ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
			  sheetObj.LoadSaveData(xmlStr);
			  ComOpenWait(false);
			  sheetObj.SetWaitImageVisible(0);
			  // 다운로드 후  버튼 비활성화,재조회 한다.
	      		ComSetObjValue(formObj.p_data_cd,"DL");
	    		ComBtnEnable("btn_Inquiry");
				ComBtnEnable("btn_Transmit");
				ComBtnDisable("btn_EDIDownload");
	    		doActionIBSheet(sheetObj,formObj,IBSEARCH);

			  break;				
			  case MULTI05: // 데이터 삭제
			  if (!validateForm(sheetObj, formObj, sAction)) {
				return;
			  }	
				if(!ComShowCodeConfirm("BKG01188")) return; // Do you want to delete all saved data?
	            var cntr_list="";
				var arrRow=ComFindText(sheetObj, "sel", 1);
				if (arrRow && arrRow.length > 0) {
					for (var i=0; i<arrRow.length; i++) {
						cntr_list += sheetObj.GetCellValue(arrRow[i], "vsl_cd"       )+","+
						sheetObj.GetCellValue(arrRow[i], "skd_voy_no"   )+","+
						sheetObj.GetCellValue(arrRow[i], "skd_dir_cd"   )+","+
						sheetObj.GetCellValue(arrRow[i], "bl_no"        )+","+
						sheetObj.GetCellValue(arrRow[i], "eu_1st_port"  )+","+"@";
					}
				}
				if(ComGetLenByByte(cntr_list) > 4000){
					cntr_list=getStringToClobString(cntr_list, 30,"@")
				} else{
					cntr_list="'"+cntr_list+"'";
				}
				formObj.f_cmd.value=MULTI05;
				var sParam="&ibflag=U&f_cmd="+formObj.f_cmd.value+"&cntr_list="+ cntr_list;
			  formObj.f_cmd.value=MULTI05;
		      var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do", sParam);
			  sheetObj.LoadSearchData(sXml,{Sync:1} );
			  doActionIBSheet(sheetObj,form,IBSEARCH); // 데이터 삭제 후 재조회함
			  break;
        }
    }
    

     /**
      * BackEndJob 실행결과조회<br>
      * 
      * @param sheetObj
      * @param sKey
      */
    function doActionValidationResult(sheetObj, sKey) {
    			var sXml=sheetObj.GetSearchData("ESM_BKG_1121GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
    	     	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
    	     	//ComShowMessage("doActionValidationResult "+sJbStsFlg);
    	     	// 에러가 발생했을 경우 대기사항을 종료한다.
    	     	if (!ComBkgErrMessage(sheetObj, sXml)) {
    	     		clearInterval(intervalId);
    	     		ComOpenWait(false);
    	     		return;
    	     	}
    	     	if (sJbStsFlg == "SUCCESS") {
    	     		clearInterval(intervalId);
    	     		ComOpenWait(false);
    	     		// 성공메시지 보여주고
    	     		ComShowCodeMessage('BKG00101');	
    	     		//resultlist.innerHTML = "<pre>"+ ComGetEtcData(sXml, "RESULT")+"</pre>";
    	     		//전송 성공 후 재조회함.
    	     		doActionIBSheet(sheetObj,form,IBSEARCH);
    	     		return;
    	     	} else if (sJbStsFlg == "FAIL") {
    	     		//에러
    	     		clearInterval(intervalId);
    	     		ComOpenWait(false);
    	     		// 에러메시지 보여주고
    	     		ComShowMessage(ComResultMessage(sXml));
    	     	}
    	     }

    
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
 	    switch(sAction) {
 	    	case IBSEARCH:
 	    		if (!ComIsNull(formObj.p_bl_no)) {
 	    			return true;
 	    		}
     			if (ComIsNull(formObj.p_vvd_cd)) {
     				ComShowCodeMessage('BKG00104','VVD');
  					formObj.p_vvd_cd.focus();
  					return false;    
     			}
     			if (ComGetObjValue(p_pol_cd_temp) == "") {
     				ComShowCodeMessage('BKG00104','POL');
     				//p_pol_cd_temp.focus();
     				return false;    
     			}
 				break;
 	    	case MULTI://다운로드
 	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
 	    			ComShowCodeMessage("COM12189");
 	    			return false;
 	    		}
 	    		if(formObj.search_eu_pol_cd.value != p_pol_cd_temp.GetSelectText()) {
 	    			ComShowCodeMessage("BKG06138");
 	    			//p_pol_cd_temp.focus();
 	    			return false;
 	    		}
 	    		var arrRow=ComFindText(sheetObj, "sel", 1);
 	    		/*
 	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
 	    		 * */
 	    		var errorCnt=0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
 	    		var errorBls="";
 	    		var tempBl="";
 	    		var beBlNo="";
 	    		var nowBlNo="";
 	    		var errBlArray=new Array();
 	    		for (var i=0; i<arrRow.length; i++) {
				 if(sheetObj.GetCellValue(arrRow[i], "err_yn") == "Y"){
				 if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
 		    				errorCnt++;
 		    				if(errorCnt > 10){
 		    					continue;
 		    				}else{
 		    					nowBlNo=sheetObj.GetCellValue(arrRow[i], "bl_no");
 		    					if(beBlNo == nowBlNo){
 		    						errorCnt--;
 		    					}else{
 		    						beBlNo=nowBlNo;
 		    						errorBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
 		    					}
 		    				}
 	    				}
 	    			}
 	    		}
 			    if(errorCnt > 0){
 					errorBls=errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
 					//에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
 					if(!ComShowConfirm(ComGetMsg("BKG01133",errorBls,"Will you proceed to download?")) ){
 						return false;
 					}
 			    }
 	    		break;
 	    	case MULTI01:// EDI FLAT FILE 생성 및 전송
 	    	case MULTI03:// EDI FLAT FILE 생성 및 전송
 	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
 	    			ComShowCodeMessage("COM12189");
 	    			return false;
 	    		}
 	    		if (ComIsNull(formObj.port_ofc_cd)) {
 	    			ComShowCodeMessage('BKG01131');
 	    			return false;    
 	    		}
 	    		var errYN="N";
 	    		var arrRow=ComFindText(sheetObj, "sel", 1);
 	    		var nodownCnt=0;//다운로드 하지 않은 개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
 	    		var nodownBls="";
 	    		/*
 	    		 * Error BL이면 B/L 번호를 보여주고 중단한다.
 	    		 * */
 	    		var errorCnt=0;  //error개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
 	    		var errorBls="";
 	    		/* not received이 존재하면 확인창 후 취소 버튼 클릭시 진행 안함 */
 	    		var nrCnt=0;
 	    		var nrBls="";
 	    		/*
 	    		 * Amend전송: Send log 테이블, cre_dt 기준,  1/18 17:18 분 이후 건에 대해 Amendment Block,  BL은 재전송 못하게 한다.
 	    		 * */
 	    		var amdCnt=0;  //amd개수가 10개 까지만 BL번호를 보여주고 그 뒤 부터는 etc.
 	    		var amdBls="";
 	    		var tempBl="";
 	    		var errBlArray=new Array();
 				for (var i=0; i<arrRow.length; i++) {
				 if(sheetObj.GetCellValue(arrRow[i], "err_yn") == "Y"){
				 if(errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")] == undefined){ // bl단위로 에러 메시지를 보여주기 위함.
				 errBlArray[sheetObj.GetCellValue(arrRow[i], "bl_no")]=sheetObj.GetCellValue(arrRow[i], "bl_no");
 							errorCnt++;
 							if(errorCnt <= 10)
 								errorBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
 						}
 					}
				 if (tempBl== sheetObj.GetCellValue(arrRow[i], "bl_no")) continue;// 이전 bl과 같으면 건너뛴다.
				 tempBl=sheetObj.GetCellValue(arrRow[i], "bl_no");
 					/* 2010-11-30 Download조회에서만 전송버튼이 활성화 되므로 이부분은 현재 실효성은 없으나 초기버전대로 일단 수행은 한다.*/
				 if(sheetObj.GetCellValue(arrRow[i], "download_yn") == "N"){
 						nodownCnt++;
 						if(nodownCnt <= 10)
 							nodownBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
 					}
				 if(sheetObj.GetCellValue(arrRow[i], "result2") == "NR"){
 						nrCnt++;
 						if(nrCnt <= 10)
 							nrBls += sheetObj.GetCellValue(arrRow[i], "bl_no")+",";
 					}
 				}//end for
 				if(nodownCnt > 0){
 					nodownBls=nodownCnt > 10 ? nodownBls+"..etc.":nodownBls.substring(0,nodownBls.length-1);
 					ComShowCodeMessage("BKG01130",nodownBls,"");
 					return false;
 				}
 			    if(errorCnt > 0){
 					errorBls=errorCnt > 10 ? errorBls+"..etc.":errorBls.substring(0,errorBls.length-1);
 			    	ComShowCodeMessage("BKG01133",errorBls,"");
 			    	return false;
 			    }
 				//에러이면서 계속진행 하지 않겠다면 더 이상 진행하지 않음.
 				if(nrCnt > 0 ){
 					nrBls=nrCnt > 10 ? nrBls+"..etc.":nrBls.substring(0,nrBls.length-1);
 					if(!ComShowConfirm(ComGetMsg("BKG01141",nrBls)) ) 
 						return false;
 				}
 				break;
 	    	case MULTI05:// 데이터 삭제
 	    		if (sheetObj.CheckedRows("sel") <= 0 ) {
 	    			ComShowCodeMessage("COM12189"); // "Nothing Selected."
 	    			return false;
 	    		}
 	    }//end case
         return true;
     }
    
    