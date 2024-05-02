/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0317.js
*@FileTitle : TRO-T1 and Revenue Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.29 이남경
* 1.0 Creation 
===============================================================================
* History
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
* 2012.10.29 조정민 [CHM-201220788] [EUR TRO] Manifested Amount Hiding, Speical Instruction 공간확대
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
     * @class esm_bkg_0317 : esm_bkg_0317 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0317() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.obj_keyup_loc           = obj_keyup_loc;
    	this.obj_change				 = obj_change;
    	this.obj_click               = obj_click;
    	this.form_onChange           = form_onChange;
    	this.setChangeDisbled_rt_flg = setChangeDisbled_rt_flg;     	
    }
    
   	/* 개발자 작업	*/
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[1];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
            	case "btn_save": 
            		if(!validateForm(sheetObject1, formObject, "btn_Select")) return;

            		// save시에 charge code validation 수행
            		var formObj = document.form;  
    				var chg_cd = formObj.add_rev_chg_cd.Code;
    				if (chg_cd.length > 0) {
    					var param = param + "&f_cmd=" + SEARCHLIST16 + "&input_text=" + chg_cd;
    					var sXml = sheetObject1.GetSearchXml("ESM_Booking_UtilGS.do", param);
    					var output_text = ComGetEtcData(sXml, "output_text");
    					if ('Y' != output_text) {
    						ComShowMessage(ComGetMsg("BKG00970", chg_cd ));
    						//sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='N';
    						return ;
    					}else{
    						//sheetObj.CellValue(Row, prefix2 + "exist_chg_cd")='';
    					}
    				}           		
            		pre_comPopupOK();
                	break;

				case "btns_popOverIhc":
					var sParam = "svcScpCd=" +	formObject.svc_scp_cd.value
					+ "&ihcTrfNo=" +	formObject.ihc_trf_no.value
					+ "&org_dest_tp_cd=" +  formObject.org_dest_tp_cd.value
					+ "&opn=" +  "7004";
					ComOpenPopup("ESM_PRI_7024.do?"+sParam, 550, 500, "", '1,0,1,1,1,1,1,1,1,1,1,1', true);

					break;
					
				case "btn_close":
					self.close();
					break;

					

            } // end switch
    	}catch(e) {
    		ComShowMessage(e);
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
     * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);                
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        
    	// IBMultiCombo 초기화
    	for ( var k = 0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
       
        initControl();
    }
     
    function initControl() {
    	var formObj = document.form;

        axon_event.addListenerFormat('keypress', 'obj_KeyPress',   formObj);
        axon_event.addListenerForm  ('click',    'obj_click',      formObj); 
        axon_event.addListenerForm  ('keyup',    'obj_keyup_loc',  formObj); 
    	axon_event.addListenerForm	('change',   'obj_change', 	   formObj);
        
    	//if (formObj.cxl_flg.checked) {
    	if (formObj.cxl_flg.checked || formObj.cfm_flg.value == "Y") {
    		//frustrated 의 경우(cxl과 cfm이 동시에 존재) confirm이후에도 save할 수 있도록 변경 requested by 이원모 차장
    		//setDisabled_all();   		
    		//return;
    	}

    	formObj.cstms_clr_no.focus(); 
    	ComEnableManyObjects(false, formObj.all_in_rt_cd[2]);
    	
    	if (formObj.term.value != "D") {
    		// Yes를 어느 경우에나 선택 가능하도록 함 (기존에는 Door인 경우 사용하지 않았음) 2010.02.17 cateshin
    		//ComEnableManyObjects(false, formObj.all_in_rt_cd[0]);
    	}
    	
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    	// multi combo data 조회 이후 값 설정
    	formObj.add_rev_chg_cd.Code = formObj.h_add_rev_chg_cd.value;
    	formObj.add_rev_amt.value = formObj.h_add_rev_amt.value;
    	formObj.add_rev_chg_cd2.Code = formObj.h_add_rev_chg_cd2.value;
    	formObj.add_rev_amt2.value = formObj.h_add_rev_amt2.value;
    	formObj.add_rev_chg_cd3.Code = formObj.h_add_rev_chg_cd3.value;
    	formObj.add_rev_amt3.value = formObj.h_add_rev_amt3.value;
    	formObj.add_rev_rmk.value = formObj.h_add_rev_rmk.value;
    	formObj.arb_curr_cd.value = formObj.h_arb_curr_cd.value;
    	formObj.arb_rev_amt.value = formObj.h_arb_rev_amt.value;
    	
    	doActionIBSheet(sheetObjects[1],document.form,SEARCH);
    	
    	if(formObj.hlg_tp_cd.value == "M" && formObj.io_bnd_cd.value == "I"){
    		ComEnableManyObjects(false, formObj.all_in_rt_cd[1],formObj.non_trns_rev_amt);
    	}
    }

    function obj_keyup_loc() {
//    	document.form.trns_rev_amt.value = changeComma_loc(document.form.trns_rev_amt.value, 0, 9, 2);
    	document.form.non_trns_rev_amt.value = changeComma_loc(document.form.non_trns_rev_amt.value, 0, 9, 2);
    	document.form.add_rev_amt.value = changeComma_loc(document.form.add_rev_amt.value, 0, 9, 2);
    	document.form.add_rev_amt2.value = changeComma_loc(document.form.add_rev_amt2.value, 0, 9, 2);
    	document.form.add_rev_amt3.value = changeComma_loc(document.form.add_rev_amt3.value, 0, 9, 2);
    	document.form.arb_rev_amt.value = changeComma_loc(document.form.arb_rev_amt.value, 0, 9, 2);
    	calcDiffGl();
    }
    
    function obj_click() {
		var formObj = document.form;        
		with(formObj) {
			switch(event.srcElement.name){
	            case "all_in_rt_cd":
	            	if (event.srcElement.value == "N") {
	            		all_in_rt_cd[0].checked = false;
	            		all_in_rt_cd[1].checked = true;
	            	} else if (event.srcElement.value == "Y") {
	            		all_in_rt_cd[0].checked = true;
	            		all_in_rt_cd[1].checked = false;
	            	} else if (event.srcElement.value == "A") {
	            		setAddtional();
	            	}
	            	
	            	if (term.value != "D" && event.srcElement.value == "Y") {
	            		ComShowCodeMessage("BKG02029");
	            		if(formObj.hlg_tp_cd.value == "C" || formObj.io_bnd_cd.value == "O"){
		            		all_in_rt_cd[1].checked = true;
	            		}
	            		all_in_rt_cd[0].checked = false;
	            		return;
	            	}
	            	if(event.srcElement.value == "N" || event.srcElement.value == "Y"){
		            	setMfCheck(); 		
	            	}
	            	break;
			}
		}
    }
    
    function obj_change() {
    	var formObj = document.form;
    	var elementNm = event.srcElement.name;

    	switch (elementNm) {
    	case "curr_cd":
    		if(formObj.all_in_rt_cd[3].checked == true) {
    			formObj.add_trns_curr_cd.value = formObj.curr_cd.value; 
    		}
    		break;
    	}
    }    
    
    function setDisabled_all() {
    	var formObj = document.form; 
    	
    	with(formObj) {
    		//1) data : disabled
    		ComEnableManyObjects(false, t1_doc_flg[0], t1_doc_flg[1], cstms_clr_no, 
    				                    all_in_rt_cd[0], all_in_rt_cd[1], all_in_rt_cd[2], all_in_rt_cd[3], 
    				                    curr_cd, trns_rev_amt,non_trns_rev_amt,add_rev_amt, add_rev_chg_cd, 
    				                    add_rev_amt2, add_rev_chg_cd2, add_rev_amt3, add_rev_chg_cd3, 
    				                    vat_flg[0], vat_flg[1]);
    		//2) save button : disabled
    		ComEnableManyTd(false, "btn_save");
    	}
    }
    
    function setChangeDisbled_rt_flg() {
    	var formObj = document.form;    	
    	var default_curr_cd = "";
    	with(formObj) {  
    		default_curr_cd = gline_curr_cd.value == "" ? "EUR" : gline_curr_cd.value;

//    		if(!ComIsEmpty(h_all_in_rt_cd.value)) {
	    		if(h_all_in_rt_cd.value == "Y" || h_all_in_rt_cd.value == "") {
	    			all_in_rt_cd[0].checked = true;
	    			all_in_rt_cd[1].checked = false;
	    			all_in_rt_cd[3].checked = false;
	    		} else if(h_all_in_rt_cd.value == "N") {
	    			all_in_rt_cd[0].checked = false;
		    		all_in_rt_cd[1].checked = true;
	    			all_in_rt_cd[3].checked = false;
	    		} else if(h_all_in_rt_cd.value == "A") {
	    			all_in_rt_cd[0].checked = true;
	    			all_in_rt_cd[1].checked = false;
		    		all_in_rt_cd[3].checked = true;
		    	} else if(h_all_in_rt_cd.value == "B"){
	    			all_in_rt_cd[0].checked = false;
		    		all_in_rt_cd[1].checked = true;
		    		all_in_rt_cd[3].checked = true;
            	}  
	    		setMfCheck();
//	    	}
	    	if (optm_sts_cd.value == "Y" && manifest_flag.value == "N") {
        		ComEnableManyObjects(false, all_in_rt_cd[0] ,
        				all_in_rt_cd[1], non_trns_rev_amt, curr_cd);
        		
        		trns_rev_amt.value = "";
        		if(arb_rev_amt.value != ""){
	        		non_trns_rev_amt.value = arb_rev_amt.value;
	        		curr_cd.value = arb_curr_cd.value;
	    			all_in_rt_cd[0].checked = false;
		    		all_in_rt_cd[1].checked = true;
		    		all_in_rt_cd[2].checked = true;
		    		all_in_rt_cd[3].checked = false;
        		} else {
        			if(non_trns_rev_amt.value == ""){
    	        		non_trns_rev_amt.value = gline_rev_amt.value;
        			}
        			
        			if(curr_cd.value == ""){
        				curr_cd.value = gline_curr_cd.value;
        			}

        		}
	    	} else if(optm_sts_cd.value == "Y" && manifest_flag.value == "M"){
        		ComEnableManyObjects(false, all_in_rt_cd[0], non_trns_rev_amt
        		                          , all_in_rt_cd[1] );
//        		trns_rev_amt.value = gline_rev_amt.value;
        		non_trns_rev_amt.value = "";
        	    curr_cd.value = gline_curr_cd.value;       	    
        		
	    	} else if(optm_sts_cd.value == "N" && manifest_flag.value == "N"){ 
	    		ComEnableManyObjects(false, all_in_rt_cd[0], all_in_rt_cd[1]);
//        		                          , diff_trns_rev_amt); 
        		
	    	}else if(optm_sts_cd.value == "A" && manifest_flag.value == "N"){ 
	    		ComEnableManyObjects(false, all_in_rt_cd[0], all_in_rt_cd[1]);
//        		                          , diff_trns_rev_amt); 
	    	}        			
    		
	    	if(h_add_rev_amt.value != "" || h_add_rev_amt2.value != "" || h_add_rev_amt3.value != "")
	    		all_in_rt_cd[3].checked = true;
	    		
	    	setAddtional();

    		var boundCd = io_bnd_cd.value;
    		if (boundCd == "I") {
    			ComEnableManyObjects(true,  vat_flg[0], vat_flg[1]);
    		} else {
    			ComEnableManyObjects(false, vat_flg[0], vat_flg[1]);
    		}
    	}
    }
    
    function setAddtional(){
		var formObj = document.form;
		with (formObj) {
	    	// additional
			if(all_in_rt_cd[3].checked == true){
				ComEnableManyObjects(true, add_rev_rmk, add_rev_amt , add_rev_amt2, add_rev_amt3);
				formObj.add_rev_chg_cd.Enable = true;
				formObj.add_rev_chg_cd2.Enable = true;
				formObj.add_rev_chg_cd3.Enable = true;
				formObj.add_trns_curr_cd.value = formObj.curr_cd.value;
				formObj.add_trns_curr_cd2.value = formObj.curr_cd.value;
				formObj.add_trns_curr_cd3.value = formObj.curr_cd.value;
			}else if(all_in_rt_cd[3].checked == false){
				ComEnableManyObjects(false, add_rev_amt, add_rev_rmk, add_rev_chg_cd , add_rev_amt2, add_rev_amt3
						, add_rev_chg_cd2 , add_rev_chg_cd3);
				formObj.add_rev_chg_cd.Enable = false;
				formObj.add_rev_chg_cd2.Enable = false;
				formObj.add_rev_chg_cd3.Enable = false;
				formObj.add_trns_curr_cd.value = "";
				formObj.add_trns_curr_cd2.value = "";
				formObj.add_trns_curr_cd3.value = "";
				formObj.add_rev_amt.value = "";
				formObj.add_rev_amt2.value = "";
				formObj.add_rev_amt3.value = "";
				formObj.add_rev_rmk.value = "";
				formObj.add_rev_chg_cd.Index = "";
			}
		}
    }
    
    function initCombo(comboObj, comboNo) {
    	with (comboObj) {
    		MultiSeparator = "|";

    		switch (comboObj.id) {
    		case "add_rev_chg_cd":
    			SetColWidth("60|280");
    			SetTitle("Code|Description");
    			MultiSelect = false;
    			break;
    		}
    	}
    }
    

    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		switch(sheetObj.id) {
			case "h1sheet1":      //hidden sheet1
				with (sheetObj) {
					// 높이 설정
//					style.height = 80;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "sel|curr|rev";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다	
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX] INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtRadioCheck,	40,  	daCenter,   false,  "radio", 			false,  "", dfNone, 	0, 	    true, true);					
					InitDataProperty(0,	cnt++,	dtData,			30 , 	daCenter,	false,	"gline_curr_cd",	false,	"", dfNone,	    0,      true, true);
					InitDataProperty(0,	cnt++,	dtData,			30 , 	daRight,    false,	"gline_rev_amt",	false,	"",	dfNone,		0,		true, true);
				}
			break; 		
				
			case "h1sheet2":      //hidden sheet2
				with (sheetObj) {
					// 높이 설정
//					style.height = 80;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);
					
					var HeadTitle = "radio|bkg_no|t1_doc_flg|cstms_clr_no|all_in_rt_cd|curr_cd|trns_rev_amt|non_trns_rev_amt|add_rev_amt|add_rev_chg_cd|cxl_flg|vat_flg|add_rev_rmk|arb_curr_cd|arb_rev_amt|arb_rev_amt|arb_rev_flg|add_rev_amt2|add_rev_chg_cd2|add_rev_amt3|add_rev_chg_cd3";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false, false);
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
										
					//데이터속성    [ROW, COL,  DATATYPE,   	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0,	cnt++,	dtRadioCheck,	21 , 	daCenter,	false,	"radio",			false,	"", dfNone,	    0,      true, true);
					InitDataProperty(0,	cnt++,	dtHidden,		30 , 	daLeft,	    false,	"bkg_no",			false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			61 , 	daLeft,	    false,	"t1_doc_flg",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daLeft,	    false,	"cstms_clr_no",		false,	"",	dfNone,		0,		true, true);  
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"all_in_rt_cd",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			30, 	daLeft,	    false,	"curr_cd",			false,	"",	dfNone,	    0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"trns_rev_amt",		false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"non_trns_rev_amt",	false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_amt",		false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_chg_cd",   false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"cxl_flg",			false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"vat_flg",			false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"add_rev_rmk",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"arb_curr_cd",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"arb_rev_amt",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			80, 	daLeft,		false,	"arb_rev_flg",		false,	"",	dfNone,		0,		true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_amt2",		false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_chg_cd2",   false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_amt3",		false,	"",	dfNone,   	0,	    true, true);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daLeft,	    false,	"add_rev_chg_cd3",   false,	"",	dfNone,   	0,	    true, true);
				}
			break; 			
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {    	
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
	      	case SEARCH:      //조회	
	      		var formObj = document.form;
		  		if(formObj.hlg_tp_cd.value == "M"){
		  			return false;
		  		}
	      		formObj.f_cmd.value = SEARCH;
	      		var param = FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0317GS.do", param+"&multi_rev=Y");
				var glineRevAmt = 0;
				var arbRevAmt = "";
				var arbCurrCd = "";
				if (sXml != "") {
					ComSetObjValue(formObj.gline_curr_cd, ComGetEtcData(sXml, "gline_curr_cd"));
					glineRevAmt = ComGetEtcData(sXml, "gline_rev_amt");
					glineRevAmt = glineRevAmt == "N/A"?glineRevAmt:changeComma_loc(glineRevAmt, 0, 9, 2);
					ComSetObjValue(formObj.gline_rev_amt, glineRevAmt);
					ComSetObjValue(formObj.manifest_flag, ComGetEtcData(sXml, "manifest_flag"));
					
					var arrXml = sXml.split("|$$|"); 
					if (arrXml.length > 0){
	    				sheetObjects[0].LoadSearchXml(arrXml[0]);
//						alert(sheetObjects[0].RowCount);
						if(sheetObjects[0].RowCount == 1) {
							arbCurrCd = sheetObjects[0].CellValue(1, "gline_curr_cd");
							arbRevAmt = sheetObjects[0].CellValue(1, "gline_rev_amt");
						}
						// multi revenue case
						else if(sheetObjects[0].RowCount > 1) {
							ComOpenPopup("ESM_BKG_1166POP.do?pgmNo=ESM_BKG_1166&callSheetIdx="+0, 350, 240, "callBack1166", '1,0,1,1,1,1,1,1,1,1,1,1', true);
							arbCurrCd = ComGetObjValue(formObj.arb_curr_cd);
							arbRevAmt = ComGetObjValue(formObj.arb_rev_amt);
						}
					}
					arbRevAmt = arbRevAmt == "N/A"?arbRevAmt:changeComma_loc(arbRevAmt, 0, 9, 2);
					ComSetObjValue(formObj.arb_curr_cd, arbCurrCd);
					ComSetObjValue(formObj.arb_rev_amt, arbRevAmt);
					if(ComGetEtcData(sXml, "arb_curr_cd")!=""){
						formObj.all_in_rt_cd[2].checked  = true
					}
					if(!ComIsEmpty(ComGetEtcData(sXml, "all_in_rt_cd")))
						ComSetObjValue(formObj.h_all_in_rt_cd, ComGetEtcData(sXml, "all_in_rt_cd"));
					if(!ComIsEmpty(ComGetEtcData(sXml, "dih_amt")))
						ComSetObjValue(formObj.dih_amt, ComGetEtcData(sXml, "dih_amt"));
					if(!ComIsEmpty(ComGetEtcData(sXml, "agmt_wgt")))
						ComSetObjValue(formObj.agmt_wgt, ComGetEtcData(sXml, "agmt_wgt"));
					if(!ComIsEmpty(ComGetEtcData(sXml, "ihc_trf_no")))
						ComSetObjValue(formObj.ihc_trf_no, ComGetEtcData(sXml, "ihc_trf_no"));
					if(!ComIsEmpty(ComGetEtcData(sXml, "org_dest_tp_cd")))
						ComSetObjValue(formObj.org_dest_tp_cd, ComGetEtcData(sXml, "org_dest_tp_cd"));
					if(!ComIsEmpty(ComGetEtcData(sXml, "svc_scp_cd")))
						ComSetObjValue(formObj.svc_scp_cd, ComGetEtcData(sXml, "svc_scp_cd"));
					setChangeDisbled_rt_flg();
					
					if(formObj.io_bnd_cd.value == "I"){
						if(formObj.cgo_wgt.value!="" && ComGetEtcData(sXml, "agmt_wgt")!=""){
							if(parseInt(formObj.cgo_wgt.value) > parseInt(ComGetEtcData(sXml, "agmt_wgt"))){
								if(ComGetEtcData(sXml, "gline_curr_cd")!=""){
									eval('DIV_btn_ihc').style.display = 'block';
									document.getElementById('gline_rev_amt').style.color = 'red';
									document.getElementById('gline_rev_amt').style.fontWeight="bold";
									ComShowCodeMessage("BKG95087");
								}else{
									eval('DIV_btn_ihc').style.display = 'none';
									document.getElementById('gline_rev_amt').style.color = '';
									document.getElementById('gline_rev_amt').style.fontWeight="";
								}
							}
						}

					}

					ComEnableManyObjects(false, document.form.trns_rev_amt);
				}
				calcDiffGl();
	            break;
	            
          	case IBSEARCH:      //Combo 조회	
          		var formObj = document.form;
	      		formObj.f_cmd.value = SEARCHLIST01;
          		var param = "f_cmd=" + SEARCHLIST01 + "&cm_code=CD03073";
				var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
				
				var arrXml = sXml.split("|$$|");				
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0], formObj.add_rev_chg_cd, "val", "val|desc");
					ComXml2ComboItem(arrXml[0], formObj.add_rev_chg_cd2, "val", "val|desc");
					ComXml2ComboItem(arrXml[0], formObj.add_rev_chg_cd3, "val", "val|desc");
				}
                break;
        }
    }

    function callBack1166(arrVal){
//    	alert("callBack1166");
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){    	        	
        with(formObj){
        	if ("btn_Select" == sAction){ 	
        		if (hlg_tp_cd.value == "C" && !checkMandatory()) {
					return false;
				}
        	}

        	if(add_rev_chg_cd.Text == "OTR" && add_rev_rmk.value == "") {        		
        		ComShowCodeMessage("BKG02116");
        		return false;
        	}
        }        
        return true;
    }
     
    /*
     * checkMandatory
     */ 
    function checkMandatory() {
    	var formObj = document.form;
    	
    	if (!formObj.all_in_rt_cd[0].checked) {
        	//01. Currency
        	if (formObj.curr_cd.value.trim() == "") {
        		ComShowCodeMessage("COM12200", "Currency");
        		formObj.curr_cd.focus();
        		return false;
        	} 
        	// Manifested Revenue의 경우 우선은 optional로 2010.02.19 cateshin
        	//02.Manifested Revenue
        	//var strTrnsRevAmt = formObj.trns_rev_amt.value.trim();
        	//if (strTrnsRevAmt == "" || strTrnsRevAmt == ".00") {
        	//	ComShowCodeMessage("COM12200", "Manifested Revenue");
        	//	formObj.trns_rev_amt.focus();
        	//	return false;
        	//}
        	//02. Non-Manifested Revenue
        	var strNonTrnsRevAmt = formObj.non_trns_rev_amt.value.trim();
        	if (strNonTrnsRevAmt == "" || strNonTrnsRevAmt == ".00") {
        		ComShowCodeMessage("COM12200", "Non-Manifested Revenue");
        		formObj.non_trns_rev_amt.focus();
        		return false;
        	}        	
    	}
    	
    	if(formObj.all_in_rt_cd[3].checked && formObj.add_rev_chg_cd.Code == ""
    		 && formObj.add_rev_chg_cd2.Code == ""  && formObj.add_rev_chg_cd3.Code == "") {
    		ComShowCodeMessage("BKG00887", "Additional Charge Code");
    		formObj.add_rev_chg_cd.focus();
    		return false;
    	}
        return true;
    }
     
    /** 
     * opener화면에 입력된 값을 전달함
     */ 
    function pre_comPopupOK() {
    	var formObj  = document.form;
    	var sheetObj = sheetObjects[1];
    	
        sheetObj.RemoveAll();                //grid  초기화         
        var nRow = sheetObj.DataInsert(-1);  //신규행 추가 
        
        with (formObj) {
        	var t_trns_rev_amt 		= (all_in_rt_cd[0].checked == true) ? delComma_loc(document.form.calc_trns_rev_amt, 0, 9, 2)
        																: delComma_loc(document.form.trns_rev_amt, 0, 9, 2);
        	
	        var t_non_trns_rev_amt 	= delComma_loc(document.form.non_trns_rev_amt, 0, 9, 2);
	        var t_add_rev_amt 		= delComma_loc(document.form.add_rev_amt, 0, 9, 2);
	        var t_add_rev_amt2 		= delComma_loc(document.form.add_rev_amt2, 0, 9, 2);
	        var t_add_rev_amt3 		= delComma_loc(document.form.add_rev_amt3, 0, 9, 2);
	        var t_bkg_no        	= bkg_no.value;
	        var t_cstms_clr_no  	= cstms_clr_no.value;
	        var t_add_rev_chg_cd 	= add_rev_chg_cd.Code;	
	        var t_add_rev_chg_cd2 	= add_rev_chg_cd2.Code;
	        var t_add_rev_chg_cd3 	= add_rev_chg_cd3.Code;
	        var t_add_rev_rmk       = add_rev_rmk.value;      
	        var t_curr_cd       	= curr_cd.value;	  
	        var t_cxl_flg       	= (cxl_flg.checked)? "Y" : "N"; 
	        var t_t1_doc_flg    	= "";
	        var t_arb_rev_flg 		= "N";
	        if (formObj.arb_rev_amt.value.length > 0 && "0" != formObj.arb_rev_amt.value){
	        	t_arb_rev_flg = "Y";
	        }
	        if (t1_doc_flg[0].checked) {
	        	t_t1_doc_flg = "Y";
	        } else {
	        	t_t1_doc_flg = "N";
	        }
	        var t_all_in_rt_cd = "";
	        if (all_in_rt_cd[0].checked  == true && all_in_rt_cd[3].checked == false) {
	        	t_all_in_rt_cd = "Y";
	        } else if (all_in_rt_cd[1].checked == true && all_in_rt_cd[3].checked == false) {
	        	t_all_in_rt_cd = "N";
	        } else if (all_in_rt_cd[0].checked  == true && all_in_rt_cd[3].checked == true) {
	        	t_all_in_rt_cd = "A";
	        } else if (all_in_rt_cd[1].checked  == true && all_in_rt_cd[3].checked == true) {
	        	t_all_in_rt_cd = "B";
	        }
	        var t_vat_flg    = "";
	        if (vat_flg[0].checked) {
	        	t_vat_flg = "Y";
	        } else {
	        	t_vat_flg = "N";
	        }

	        sheetObj.CellValue2(nRow, "bkg_no")        		= t_bkg_no; 
	 		sheetObj.CellValue2(nRow, "t1_doc_flg")    		= t_t1_doc_flg; 
	 		sheetObj.CellValue2(nRow, "cstms_clr_no")  		= t_cstms_clr_no; 
	 		sheetObj.CellValue2(nRow, "all_in_rt_cd") 		= t_all_in_rt_cd; 
	 		sheetObj.CellValue2(nRow, "curr_cd")       		= t_curr_cd;
	 		sheetObj.CellValue2(nRow, "trns_rev_amt")  		= t_trns_rev_amt; 	
	 		sheetObj.CellValue2(nRow, "vat_flg")       		= t_vat_flg;
	 		sheetObj.CellValue2(nRow, "cxl_flg")       		= t_cxl_flg; 
	 		sheetObj.CellValue2(nRow, "radio")         		= "Y";
	 		sheetObj.CellValue2(nRow, "non_trns_rev_amt")  	= t_non_trns_rev_amt; 
	 		sheetObj.CellValue2(nRow, "add_rev_amt")  		= t_add_rev_amt ;
	 		sheetObj.CellValue2(nRow, "add_rev_chg_cd")  	= t_add_rev_chg_cd;
	 		sheetObj.CellValue2(nRow, "add_rev_rmk")  		= t_add_rev_rmk;
	 		sheetObj.CellValue2(nRow, "arb_rev_flg")  		= t_arb_rev_flg;
	 		sheetObj.CellValue2(nRow, "add_rev_amt2")  		= t_add_rev_amt2 ;
	 		sheetObj.CellValue2(nRow, "add_rev_chg_cd2")  	= t_add_rev_chg_cd2;
	 		sheetObj.CellValue2(nRow, "add_rev_amt3")  		= t_add_rev_amt3 ;
	 		sheetObj.CellValue2(nRow, "add_rev_chg_cd3")  	= t_add_rev_chg_cd3;
        }
    	comPopupOK();
    }
    
 	/**
	 * Calculate diff. with G/L.  
	 */
    function calcDiffGl() {
	    try {
	    	var formObj  = document.form;
	    	var iGlineRevAmt = 0.0;
	    	var iArbRevAmt = 0.0;
	    	var iTrnsRevAmt = 0.0;
	    	var iNonTrnsRevAmt = 0.0;
	    	var iResult = 0.0;
        
	        with (formObj) {
	        	if (ComIsEmpty(gline_rev_amt) || gline_rev_amt == "N/A") {
	        		return;
	        	}
	        	if (ComGetObjValue(curr_cd) != ComGetObjValue(gline_curr_cd)) {
//	        		ComSetObjValue(diff_trns_rev_amt, "");
	        		ComSetObjValue(diff_non_trns_rev_amt, "");
	        		return;
	        	}
//	        	if (all_in_rt_cd[0].checked == true && ComIsEmpty(ComGetObjValue(trns_rev_amt))) {
//	        		return;
//	        	}
	        	if (all_in_rt_cd[1].checked == true && ComIsEmpty(ComGetObjValue(non_trns_rev_amt))) {
	        		return;
	        	}

	        	iGlineRevAmt = ComGetObjValue(gline_rev_amt).replace(/,/g, "");
	        	iArbRevAmt = ComGetObjValue(arb_rev_amt).replace(/,/g, "");
	    		iNonTrnsRevAmt = ComGetObjValue(non_trns_rev_amt).replace(/,/g, "");
	        	
//		    	if (all_in_rt_cd[0].checked == true) {
//		    		iTrnsRevAmt = ComGetObjValue(trns_rev_amt).replace(/,/g, "");
//		    		iResult = (iTrnsRevAmt - iGlineRevAmt).toFixed(2);
//		    		iResult = ComAddComma2("" + iResult, "#,###.0");
//		    		ComSetObjValue(diff_trns_rev_amt, iResult);
//		    	} else 
		    		
		    	if (all_in_rt_cd[1].checked == true) {
		    		iResult = (iNonTrnsRevAmt - iGlineRevAmt).toFixed(2);
		    		iResult = ComAddComma2("" + iResult, "#,###.0");
		    		ComSetObjValue(diff_non_trns_rev_amt, iResult);
		    	}
		    	if (all_in_rt_cd[0].checked == false){
			    	if (all_in_rt_cd[2].checked == true) {
			    		iResult = (iNonTrnsRevAmt - iArbRevAmt).toFixed(2);
			    		iResult = ComAddComma2("" + iResult, "#,###.0");
			    		ComSetObjValue(diff_non_trns_rev_amt, iResult);
			    	}
		    	}
	        }
	    } catch(err) { ComFuncErrMsg(err.message); }
    }
     
    //#################(Util/Etc)############################
    /*
     * 천단위 콤마(,) 제거
     * @author : Lee Nam Kyung
     */    
     function delComma_loc(objTxt) {
         var comma = /,/gi;
         var temp  = objTxt.value;
         temp = temp.replace(comma, '');
         return temp;
     }
     
     /*
     * 소숫점포함 콤마(,) 붙이기
     * pCnt     : 소숫점위 자릿수(콤마제외)
     * nAccount : 소숫점 아래 자릿수
     * @author : Lee Nam Kyung
     */
    //function changeComma_loc(objTxt, term1, pCnt, nAccount)
    function changeComma_loc(txtVal, term1, pCnt, nAccount){
        var strResult = "";    	  
		var comma     = /,/gi;   
		
		//var temp  = objTxt.value;
		var temp  = txtVal;
		temp = temp.replace(comma, '');
		temp = temp.replace('-', '');
		
		if(temp.indexOf('.') != -1)  //소수점이 있는 경우
		{
		    var jum_up = temp.substring(0, temp.indexOf('.'));
		    if (jum_up.length > pCnt) {
			    jum_up = jum_up.substring(0, pCnt);
		    }
		    var jum_down = temp.substring(temp.indexOf('.')+1, temp.length);
		    if (jum_down.length > nAccount) {
			    jum_down = jum_down.substring(0, nAccount);
		    }
		 
		    jum_up = parseInt(jum_up)+'';
		    if(jum_up == 'NaN') jum_up='';
		
		    if (term1 == 0) {
		    	//objTxt.value = Comma_Input(jum_up)+"."+jum_down;
		    	strResult = Comma_Input(jum_up)+"."+jum_down;
		    } else { 
		    	//objTxt.value = jum_up+'.'+jum_down;
		    	strResult = jum_up+'.'+jum_down;
		    }
		}else {
		    temp = parseInt(temp)+'';
		    if (temp.length > pCnt) {
			    temp = temp.substring(0, pCnt);
		    }        
		    if(temp == 'NaN') temp='';
		
		    if (term1 == 0) {
		    	//objTxt.value = Comma_Input(temp);
		    	strResult = Comma_Input(temp);
		    } else {
		    	//objTxt.value = temp;
		    	strResult = temp;
		    }
		}		
		return strResult;
    }
     
    /*
     * 천단위 콤마(,) 붙이기
     * @author : Lee Nam Kyung
     */
    function Comma_Input(txtNumber){
    	var v     = txtNumber;
    	var vlen  = v.length;
    	var c     = 1;       
    	var tmp   = new Array();
    	var comma = ','; 
    	var pas   = "";
    	
    	for ( i=vlen ; i>-1; i-- ) { 
    		c++;
    		if ( ( c%3 == 0 ) && ( i != vlen - 1) ) {
    			tmp[i] = v.charAt(i) + comma; 
    		} else {
    			tmp[i] = v.charAt(i);
    		}
    	}
    	for ( i=0; i<tmp.length; i++ ) {
    		pas = pas + tmp[i];
    	}    	
    	return pas;
    }        
     
    function ComClassNameManyObjects_loc(p_className, objs) {
        try {
            var args = arguments;
            if (args.length < 2) return;
            for(var i=1; i<args.length; i++) {
                if (args[i].tagName != undefined) {
                	args[i].className = p_className;
                }
            }
        } catch(err) { ComFuncErrMsg(err.message); }
    }
    
	function setMfCheck() {
		var formObj = document.form;    
    	var default_curr_cd = "";
	
		with(formObj) {
			default_curr_cd = gline_curr_cd.value == "" ? "EUR" : gline_curr_cd.value;	
			
//			formObj.diff_trns_rev_amt.style.visibility = 'hidden';	
			if (all_in_rt_cd[0].checked == true) {
				// manifested 'Yes' case
	    		vat_flg.value      = "N";
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value = default_curr_cd;
	        	}
	    		ComEnableManyObjects(true, vat_flg[0], vat_flg[1]);
	    		non_trns_rev_amt.value = "";
	    		calc_trns_rev_amt.value = gline_rev_amt.value;
	    		trns_rev_amt.value = "Yes"+":"+ dih_amt.value;
	    		diff_non_trns_rev_amt.value = "";
	    		if(arb_curr_cd.value != ""){
	    			all_in_rt_cd[2].checked = true;
		    		calc_trns_rev_amt.value = arb_rev_amt.value;
	    		} else {
	    			all_in_rt_cd[2].checked = false;
	    		}
	    		ComEnableManyObjects(false, non_trns_rev_amt, curr_cd);
	    		//non_trns_rev_amt.value = "";
//	    		if (hlg_tp_cd.value == "C") {
//	    			ComClassNameManyObjects_loc("input1", curr_cd, trns_rev_amt);
//	    		}
	    	}
			else if (all_in_rt_cd[1].checked == true){
	    		// manifested 'No' case
	        	if (formObj.curr_cd.value == "") {
	        		formObj.curr_cd.value = default_curr_cd;
	        	}
	    		ComEnableManyObjects(true, curr_cd, non_trns_rev_amt);
	    		trns_rev_amt.value = "";
//	    		diff_trns_rev_amt.value = "";
	    		//trns_rev_amt.value = "";
	    		if (hlg_tp_cd.value == "C") {
	    		    ComClassNameManyObjects_loc("input1", curr_cd, non_trns_rev_amt);
	    		}
	    	}	
			setAddtional();
		}
	}    
	/* 개발자 작업  끝 */