/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0906.js
*@FileTitle : TRO-Confirm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.30 이남경
* 1.0 Creation 
=========================================================
* History
* 2011.12.06 금병주 [CHM-201114805] [BKG] 구주 TRO M/H 상 CNTR 중복 confirm 에 대한 Validation 추가 요청 
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
============================================================*/

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
     * @class esm_bkg_0906 : esm_bkg_0906 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0906() {
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
    var glineRevAmtFlg = "N";
    
    //2011.12.06 modal창에서 opener를 알기 위해 전역변수 설정 kbj
    var opener = window.dialogArguments;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Confirm":
					doActionIBSheet(sheetObject1, formObject, IBSAVE, MULTI);
	                break; 

				case "btn_Close":
					self.close();
					break;
/* : 사용않함 
				case "btn_chkRange":
					var chk_range_1 = parseInt(formObject.chk_range_1.value);
					var chk_range_2 = parseInt(formObject.chk_range_2.value);
					for (var i=1; i<=sheetObject1.LastRow; i++) {
						if (sheetObject1.CellEditable(i, "chk") == true && 
							parseInt(sheetObject1.CellValue(i, "tro_seq")) >= chk_range_1 &&
							parseInt(sheetObject1.CellValue(i, "tro_seq")) <= chk_range_2 ) {
							sheetObject1.CellValue2(i, "chk") = "1";
						} else {
							sheetObject1.CellValue2(i, "chk") = "";
						}
					}
					break;
*/ 
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
        
        axon_event.addListenerFormat('keypress', 'obj_KeyPress',   form);
        axon_event.addListenerForm  ('click',    'obj_click',      form); 
        axon_event.addListenerForm  ('change',   'obj_change_loc', form);
        axon_event.addListenerForm  ('beforedeactivate', 'bkg0906_deactivate',  form); //- 포커스 나갈때
        
        initControl();
        
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);        
    }
     
    function initControl() {
    	var formObj = document.form;
    	formObj.bkg_no.focus(); 
    	
    	var ioBoundCd = formObj.io_bnd_cd.value ;
    	if (ioBoundCd == "O") {
    		document.getElementById("div_inbound").style.display = "none";
    		formObj.sheet1.style.height = 210;
    	} else {
    		document.getElementById("div_inbound").style.display = "block";
    	}
    }
    
    function obj_click() {
		var formObj = document.form; 
		with(formObj) {
			switch(event.srcElement.name){			   
	            case "rdo_cct_ofc_cd":
	            	if (rdo_cct_ofc_cd[0].checked) {
	            	    cct_ofc_cd.value = cre_ofc_cd.value;
	            	} else if (rdo_cct_ofc_cd[1].checked) {
	            		cct_ofc_cd.value = clt_ofc_cd.value;
	            	}
	            	break;
			}
		}
    }

    /**
    * change시, 이벤트처리
    */
    function obj_change_loc() {
    	var formObj = document.form;
		with(formObj) {
			switch(event.srcElement.name){
	            case "chk_range_1":
	            case "chk_range_2": 
					if (formObj.chk_range_1.value.trim() == "" || 
						formObj.chk_range_2.value.trim() == "") {
						return;
					}
					var chk_range1 = parseInt(formObj.chk_range_1.value);
					var chk_range2 = parseInt(formObj.chk_range_2.value);
					
					for (var i=1; i<=sheetObjects[0].LastRow; i++) {
						if (sheetObjects[0].CellEditable(i, "chk") == true && 
							parseInt(sheetObjects[0].CellValue(i, "tro_seq")) >= chk_range1 &&
							parseInt(sheetObjects[0].CellValue(i, "tro_seq")) <= chk_range2 ) {
							sheetObjects[0].CellValue2(i, "chk") = "1";
						} else {
							sheetObjects[0].CellValue2(i, "chk") = "";
						}
					}
					formObj.chk_range_1.value = "";
					formObj.chk_range_2.value = "";
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
			case "sheet1":      //hidden sheet1
	            with (sheetObj) {	
	                // 높이 설정
	                style.height = 120;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 15, 100);
	
	                var HeadTitle = "|||SEQ|Container No.|Status|Currency|Rate|Manifested|T1 Doc|Add Rate1|Add Rate1|Add Rate2|Add Rate2|Add Rate3|Add Rate3|VAT||||||||||||||||||||";
					var headCount = ComCountHeadTitle(HeadTitle);
		
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, true, true, false,false); 
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]					
					InitDataProperty(0,	cnt++,	dtCheckBox,		21, 	daCenter,	false,	"chk",		        false);
					InitDataProperty(0,	cnt++,	dtRadioCheck,	30 , 	daCenter,	false,	"radio",            false,  "",         dfNone,	    0,          true,       true);
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	0, 		daCenter,	false,	"ibflag");
					//InitDataProperty(0,	cnt++,	dtData,			49, 	daCenter,	false,	"tro_seq_disp",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,	    	50,		daCenter,	false,	"tro_seq",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			90,		daCenter,	false,	"cntr_no",	        false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"cfm_flg_old",	    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			60,		daCenter,	false,	"curr_cd",	        false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"trns_rev_amt",		false,	"",			dfNullFloat,2,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70,		daCenter,	false,	"all_in_rt_cd",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			50, 	daCenter,	false,	"t1_doc_flg",	    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"add_rev_amt",	    false,	"",			dfNullFloat,2,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	"add_rev_chg_cd",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"add_rev_amt2",	    false,	"",			dfNullFloat,2,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	"add_rev_chg_cd2",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			70, 	daCenter,	false,	"add_rev_amt3",	    false,	"",			dfNullFloat,2,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			30, 	daCenter,	false,	"add_rev_chg_cd3",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtData,			30,		daCenter,	false,	"vat_flg",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		40,		daCenter,	false,	"cxl_flg",		    false,	"",			dfNone,		0,			false,		false);
					//hidden
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"bkg_no",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"io_bnd_cd",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"hlg_tp_cd", 		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"corr_no",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"cfm_dt",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		70,		daCenter,	false,	"cfm_flg",	        false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"bkg_trsp_mzd_cd",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"cntr_pkup_yd_cd",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"cntr_rtn_yd_cd",	false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"zn_cd",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"cntr_tpsz_cd",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"tro_sub_seq",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"optm_sts_cd",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,		50,		daCenter,	false,	"not_optm_rsn",		false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,			50,		daCenter,	false,	"dg_flg",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,			50,		daCenter,	false,	"loc_cd",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,			50,		daCenter,	false,	"pod_cd",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,			50,		daCenter,	false,	"rc_flg",		    false,	"",			dfNone,		0,			false,		false);
					InitDataProperty(0,	cnt++,	dtHidden,			50,		daCenter,	false,	"awk_cgo_flg",		    false,	"",			dfNone,		0,			false,		false);
			    }
				break; 	
		}
	}

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj, formObj, sAction, sCmd) {    	
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          	case IBSEARCH:      //조회	              		
	          	if(!validateForm(sheetObj,formObj,sAction)){
 	          		return false;
 	          	}          	
	          	formObj.f_cmd.value = SEARCH;
          	    sheetObj.DoSearch("ESM_BKG_0906GS.do", FormQueryString(formObj));
                break;
          	case COMMAND01:  
          		formObj.f_cmd.value = COMMAND01;
          		var SaveXml = sheetObj.DoSearch("ESM_BKG_0906GS.do", FormQueryString(formObj));
          		
				sheetObj.LoadSaveXml(SaveXml);
          		break;
          	case IBSAVE: 
          	//2011.12.06 spcial cargo가 남아 있으면 comfirm창 표시 kbj
          		if(isRemainSpCgo()){
          			if(!ComShowConfirm(ComGetMsg("BKG02103"))){
          				return false;
          			}
          		}
          		// T1 Revenue 상에 Arbitrary charge 존재하지만 운임이 적용 되지 않은 경우 메시지 출력
          		T1RevChkFnc();
      			if("I"== document.form.io_bnd_cd.value && "Y"== glineRevAmtFlg){
      				ComShowCodeMessage("BKG08299");
      			}	
          			
 	          	if(!validateForm(sheetObj, formObj, sAction, sCmd)){
 	          		return false;
 	          	} 
 	          	
            	if (formObj.rdo_cct_ofc_cd[0].checked) {
            		formObj.cct_ofc_cd.value = formObj.cre_ofc_cd.value;
            	} else if (formObj.rdo_cct_ofc_cd[1].checked) {
            		formObj.cct_ofc_cd.value = formObj.clt_ofc_cd.value;
            	}
            	//기존 한번에 호출 -> time out 문제
// 	          	formObj.f_cmd.value = sCmd;  //MULTI, MULTI01
//		        //sheetObj.DoSave("ESM_BKG_0906GS.do", FormQueryString(formObj), -1, false); 
//          		var sParam = ComGetSaveString(sheetObjects);
//                if (sParam == "") return;
//                sParam += "&" + FormQueryString(formObj);
//          		sParam += "&" + ComSetPrifix(sheetObjects[0].GetSaveString(), "sheet1_"); 
//          		
//          		var sXml = sheetObj.GetSaveXml("ESM_BKG_0906GS.do", sParam); 
//          		sheetObjects[0].LoadSaveXml(sXml);
            	
				//건별 호출
            	formObj.f_cmd.value = sCmd
				var params = FormQueryString(formObj);
				var params2 = "";
				var sXml = "";
				var chkCnt = 0;
				var bSuccess = false;
				
        		sheetObj.WaitImageVisible=false
				ComOpenWait(true);
				for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
//					//alert(i + ":"+sheetObj.CellValue(i, "chk") );
					if("1" != sheetObj.CellValue(i, "chk")){
						continue;
					}
					params2 =   "&sheet1_"+"radio="				+ sheetObj.CellValue(i, "radio") +		
								"&sheet1_"+"ibflag="			+ sheetObj.CellValue(i,	"ibflag") +		
								"&sheet1_"+"tro_seq_disp="		+ sheetObj.CellValue(i,	"tro_seq_disp") +	
								"&sheet1_"+"tro_seq="			+ sheetObj.CellValue(i,	"tro_seq") +		
								"&sheet1_"+"cntr_no="			+ sheetObj.CellValue(i,	"cntr_no") +		
								"&sheet1_"+"cfm_flg_old="		+ sheetObj.CellValue(i,	"cfm_flg_old") +		
								"&sheet1_"+"curr_cd="			+ sheetObj.CellValue(i,	"curr_cd") +		
								"&sheet1_"+"trns_rev_amt="		+ sheetObj.CellValue(i,	"trns_rev_amt") +	
								"&sheet1_"+"all_in_rt_cd="		+ sheetObj.CellValue(i,	"all_in_rt_cd") +	
								"&sheet1_"+"t1_doc_flg="		+ sheetObj.CellValue(i,	"t1_doc_flg") +		
								"&sheet1_"+"vat_flg="			+ sheetObj.CellValue(i,	"vat_flg") +		
								"&sheet1_"+"cxl_flg="			+ sheetObj.CellValue(i,	"cxl_flg") +		
								"&sheet1_"+"bkg_no="			+ sheetObj.CellValue(i,	"bkg_no") +		
								"&sheet1_"+"io_bnd_cd="			+ sheetObj.CellValue(i,	"io_bnd_cd") +		
								"&sheet1_"+"hlg_tp_cd=" 		+ sheetObj.CellValue(i,	"hlg_tp_cd") + 		
								"&sheet1_"+"corr_no="			+ sheetObj.CellValue(i,	"corr_no") +		
								"&sheet1_"+"cfm_dt="			+ sheetObj.CellValue(i,	"cfm_dt") +		
								"&sheet1_"+"cfm_flg="			+ sheetObj.CellValue(i,	"cfm_flg") +		
								"&sheet1_"+"bkg_trsp_mzd_cd="	+ sheetObj.CellValue(i,	"bkg_trsp_mzd_cd") +	
								"&sheet1_"+"cntr_pkup_yd_cd="	+ sheetObj.CellValue(i,	"cntr_pkup_yd_cd") +	
								"&sheet1_"+"cntr_rtn_yd_cd="	+ sheetObj.CellValue(i,	"cntr_rtn_yd_cd") +	
								"&sheet1_"+"zn_cd="				+ sheetObj.CellValue(i,	"zn_cd") +	
								"&sheet1_"+"add_rev_amt="		+ sheetObj.CellValue(i,	"add_rev_amt") +
								"&sheet1_"+"add_rev_chg_cd="	+ sheetObj.CellValue(i,	"add_rev_chg_cd") +
								"&sheet1_"+"add_rev_amt2="		+ sheetObj.CellValue(i,	"add_rev_amt2") +
								"&sheet1_"+"add_rev_chg_cd2="	+ sheetObj.CellValue(i,	"add_rev_chg_cd2") +
								"&sheet1_"+"add_rev_amt3="		+ sheetObj.CellValue(i,	"add_rev_amt3") +
								"&sheet1_"+"add_rev_chg_cd3="	+ sheetObj.CellValue(i,	"add_rev_chg_cd3") +
								"&sheet1_"+"cntr_tpsz_cd="		+ sheetObj.CellValue(i,	"cntr_tpsz_cd")+
								"&sheet1_"+"tro_sub_seq="		+ sheetObj.CellValue(i,	"tro_sub_seq");
					//alert(params + params2);
					sXml = sheetObj.GetSaveXml("ESM_BKG_0906GS.do", params + params2); 

					if(ComGetEtcData(sXml, "isSuccess") != "Y"){
						//INV에 booking data를 interface한다
						f_interfaceToInv(false,chkCnt);
						sheetObj.LoadSaveXml(sXml);
						sheetObj.CellValue(i, "chk") = "0";
		            	return false;
					} else {
						bSuccess = true;
					}
					chkCnt++;
				}
				//INV에 booking data를 interface한다
				f_interfaceToInv(true,chkCnt);
				sheetObj.LoadSearchXml(sXml);
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				
				//searching in case of success over 1.
				if(bSuccess) {
					var oForm = opener.document.form;
					var currTroSeq = oForm.tro_seq.Text;

					opener.doActionIBSheet(opener.x_sheetObject2, oForm, IBSEARCH);
					oForm.tro_seq.Code = currTroSeq;
					opener.changeTroSeqProc();
				}
            	break;					
		}
        return true;
    }        
    function f_interfaceToInv(result,chkCnt){
    	var formObj = document.form;
    	if (chkCnt > 0){
    		doActionIBSheet(sheetObjects[0], formObj, COMMAND01);
    	}
    	ComOpenWait(false);
    }
     
    //#################(Event)############################
    // Sheet saveEnd
    function sheet1_OnSaveEnd(sheetObj, ErrMsg)
    {
    	var formObj = document.form;
		if (ErrMsg.trim() == msgs['BKG00166'].trim()) {	
			pre_comPopupOK();
		}
    }

    // Sheet searchEnd
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
   	    var formObj = document.form;
   	 
 		with(sheetObj)
 		{
 			formObj.cre_ofc_cd.value   = EtcData("cre_ofc_cd");
 			formObj.clt_ofc_cd.value   = EtcData("clt_ofc_cd");
 	   	    formObj.payer_cnt_cd.value = (EtcData("payer_cnt_cd") == undefined)? '' : EtcData("payer_cnt_cd"); 
 	        formObj.payer_seq.value    = (EtcData("payer_seq") == undefined)? '' : EtcData("payer_seq"); 
 	   	    formObj.payer_nm.value     = EtcData("payer_nm"); 
 		}
 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
				if ("Y" == CellValue(i, "cxl_flg") || "Yes" == CellValue(i, "cfm_flg")) {
					CellEditable (i, "chk") = false;
				} else {
					CellEditable (i, "chk") = true;
				}
				
				if ("Yes" == CellValue(i, "cfm_flg")) {
					CellFontColor(i, "cfm_flg") = RgbColor(255, 0, 0);
				} else {
					CellFontColor(i, "cfm_flg") = RgbColor(0, 0, 0);
				}
 			}
 		}	
    }
    
    
    //#################(Etc/Logic)############################
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction,sCmd){
    	        	
        with(formObj)
        {
        	switch (sAction) {
         	    case IBSEARCH:
 					if (bkg_no.value == "") {
 					    ComShowCodeMessage("BKG00255");
 					    return false;
 					}
         	    	break;
         	    	
         	    case IBSAVE:
					if ( sheetObj.CheckedRows("chk") < 1 ) {
						ComShowCodeMessage("BKG00155");
						return false;
					}
					var chkRow = sheetObj.FindCheckedRow("chk");
					var arrRow = chkRow.split("|");
					for (var i=0; i<arrRow.length-1; i++){ 
						if(sheetObj.CellValue(arrRow[i], "optm_sts_cd") !='Y' && sheetObj.CellValue(arrRow[i], "not_optm_rsn") == '' 
							&& sheetObj.CellValue(arrRow[i], "hlg_tp_cd") =='C'){
							ComShowCodeMessage("BKG95054",sheetObj.CellValue(arrRow[i],"tro_seq"));
							return false;
						} 
					}					

 					if (sCmd == MULTI) {
 						if (!setConfirm()) {
 							return false;
 						}
 					} else if (sCmd == MULTI01) {
 						if (!setCancel()) {
 							return false;
 						}
 					}
         	    	break; 
            }
        }

        return true;
    }
     
 	/**     
 	 * setCancel -> cxl_flg check
 	 */
 	function setCancel() {
 	    var formObj  = document.form;
 		var sheetObj = sheetObjects[0]; 
 		
 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{				
 				if (CellValue(i, "chk") == 1) {
 					var cxlFlg = CellValue(i, "cxl_flg");
 					if (cxlFlg == "Yes") {
 						ComShowCodeMessage("BKG00384");   //cancel건 제외처리 
 						return false;
 					}
 				} 
 			}
 	
 			if (!ComBkgProcessYn("Cancel")) {
 	    		return false;
 	    	}
 			
 			var toDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting
 			for (var i=1; i<=LastRow; i++)
 			{ 				
 				if (CellValue(i, "chk") == 1) { 					
 					CellValue2(i, "cfm_dt") = toDay;
 				} 
 			}
 		}
 		
 		return true;
 	}

 	/**     
 	 * setConfirm -> status check / cfm_dt set
 	 */
 	function setConfirm() {
 	    var formObj  = document.form;
 		var sheetObj = sheetObjects[0];
 		var j = 0 ;

 		with(sheetObj)
 		{
 			for (var i=1; i<=LastRow; i++)
 			{
 				if (CellValue(i, "chk") == 1) {
 					if (!setCfmCheck(sheetObj, i, "chk")) {
 						return false;
 					}
 					j = j + 1;
// 					if  (j > 3) {
// 			 			ComShowCodeMessage("BKG08169", "Confirm is available up to 3 TROs at the same time due to system performance!!");
// 		 	 			return false;
// 					}
 				} 
 			}
 			var boundCd = formObj.io_bnd_cd.value;
 			if (boundCd == "I") {
 	 			//필수입력체크 : radiobox
 	 			if (!formObj.rdo_cct_ofc_cd[0].checked && !formObj.rdo_cct_ofc_cd[1].checked) {
 	 				ComShowCodeMessage("BKG00888", "Office Code[TRO/CCT at B/L]");
 	 				return false;
 	 			} 				
	 			if (!ComBkgProcessYn("Confirm")) {
	 	    		return false;
	 	    	}
 			} else if (boundCd == "O") {
 				if (!ComBkgProcessYn("Confirm")) {
     	    		return false;
     	    	}
 			}
 			if (boundCd == "I") {
 				for (var i=1; i<=LastRow; i++)
 				{
 					if(CellValue(i, "chk") == 1) {
 						var now_cntr_no = CellValue(i, "cntr_no");
 						//alert(now_cntr_no);
 						var nRow = sheetObj.FindText("cntr_no", now_cntr_no);
 						//alert(nRow);
 						var test = CellValue(nRow, "cfm_flg_old");
 						//alert(test); (nRow != i && test == "Yes")
 						if (nRow != i) {
 							// 2010.06.16 Frustrate시에 cancel call추가 했기 때문에 해당 메세지 필요 없음
 							//ComShowCodeMessage("BKG08171", "Duplicated container no!! Please check container no again");
 							//return false;
 						}
 					}
 				}
 			}
 			
 			
 			var toDay = ComGetNowInfo("ymd")+" "+ComGetNowInfo("hm");  //checked -> Confirm Date setting
 			for (var i=1; i<=LastRow; i++)
 			{ 				
 				if (CellValue(i, "chk") == 1) {
 					CellValue2(i, "cfm_dt")  = toDay; 
 					CellValue2(i, "cfm_flg") = "Yes";

 					//containerNo check 
 					if (boundCd == "I") {
	 					if (CellValue(i, "cntr_no") == "") {
	 						ComShowCodeMessage("BKG01028");
	 	 	 				return false;
	 					}
 					}
 				} 
 			}
 		}
 		
 		return true;
 	} 	
 	
 	/**     
 	  * setCfmCheck -> cfm_upd_dt set
 	  */
 	function setCfmCheck(sheetObj, nRow, colId) {
 		var formObj = document.form;
 		
 		with(sheetObj) {
 			var cfmFlg = CellValue(nRow, "cfm_flg");
 			var cfmFlgOld = CellValue(nRow, "cfm_flg_old");
 			var cxlFlg    = CellValue(nRow, "cxl_flg");
 			// confirm 후 S/O 나지 않은 case에 대한 reconfirm 가능하도록 함. 2010.02.17 cateshin
 			// rollback reconfirm의 경우 PRD상의 문제가 있어 다시 불가 조치
 			if (cfmFlgOld == "Yes") {
 				ComShowCodeMessage("BKG00383");   //confirm건 제외처리 
 				return false;
 			}
 			if (cxlFlg == "Yes") {
 				ComShowCodeMessage("BKG00384");   //cancel건 제외처리 
 				return false;
 			}
 		}
 		
 		return true;
 	} 	
    
	/**
	 * parent : default Recall 
	 */
    function pre_comPopupOK() {
	   	sheetObjects[0].CellValue2(1, "radio") = "Y";
   	    comPopupOK();
    } 

    function bkg0906_deactivate() {
    	var formObject = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
    	var srcValue = window.event.srcElement.getAttribute("value");
    	
    	if(srcName == "payer_cnt_cd"){
    		if(ComIsNull(srcValue)){
        		ComSetObjValue(formObject.payer_nm,"");
        	}
		}else if(srcName == "payer_seq"){
			if(ComIsNull(srcValue)){
				ComSetObjValue(formObject.payer_nm,"");
			}else{
				ComSetObjValue(formObject.payer_seq,ComLpad(srcValue,6,"0"));
				// 20091131 추가
				if(ComChkLen(formObject.payer_cnt_cd, 2) == "2"){
					formObject.f_cmd.value = SEARCHLIST14;
					var sXml = sheetObjects[0].GetSearchXml("ESM_BKG_0079_01GS.do?cust_cnt_cd="+ComGetObjValue(formObject.payer_cnt_cd)+"&cust_seq="+ComGetObjValue(formObject.payer_seq), FormQueryString(formObject));
					if(ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S"){
						ComSetObjValue(formObject.payer_nm,ComGetEtcData(sXml,"cust_nm"));
					}else{
						ComSetObjValue(formObject.payer_nm,"");
					}
				}
			}
		}
    }
    
    //2011.12.06 spcial cargo가 남아 있는지 체크 하는 함수 kbj
    function isRemainSpCgo(){
    	var flag = false;
    	var objForm = opener.form;
    	var x_sheetObject2= opener.x_sheetObject2;
    	var x_sheetObject4 = opener.x_sheetObject4;
    	
    	for(var i = 0; i < objForm.rc_seq.GetCount;i++){
    		
    		if(objForm.rc_seq.GetIndexText(i,0) != ''){
    			var chkRow = new Array();
        		var isCancel = null;
    			//rc_seq로 idx 가져오기
    			for(var j = 1; j <= x_sheetObject2.RowCount; j++){
    				if(x_sheetObject2.FindText("rc_seq", objForm.rc_seq.GetIndexText(i,0), j ) != -1){
    					chkRow.push(x_sheetObject2.FindText("rc_seq", objForm.rc_seq.GetIndexText(i,0), j ));
    				}
    			}
    			
    			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
    			for(var j=0; j< chkRow.length ;j++){ 
    				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
    					isCancel = true; 
    				}else{
    					isCancel = false; 
    					break;
    				}
    			} 
    			
    			if(x_sheetObject2.FindText("rc_seq",objForm.rc_seq.GetIndexText(i,0)) == -1 || isCancel){
    				flag = true;
    				break;
    			}
    		}
    	}
    	
    	for(var i = 0; i < objForm.awk_cgo_seq.GetCount;i++){
    		if(objForm.awk_cgo_seq.GetIndexText(i,0) != ''){
    			var chkRow = new Array();
        		var isCancel = null;
    			//rc_seq로 idx 가져오기
    			for(var j = 1; j <= x_sheetObject2.RowCount; j++){
    				if(x_sheetObject2.FindText("rc_seq", objForm.awk_cgo_seq.GetIndexText(i,0), j ) != -1){
    					chkRow.push(x_sheetObject2.FindText("awk_cgo_seq", objForm.awk_cgo_seq.GetIndexText(i,0), j ));
    				}
    			}
    			
    			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
    			for(var j=0; j< chkRow.length ;j++){ 
    				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
    					isCancel = true; 
    				}else{
    					isCancel = false; 
    					break;
    				}
    			} 
    			
    			if(x_sheetObject2.FindText("awk_cgo_seq",objForm.awk_cgo_seq.GetIndexText(i,0)) == -1 || isCancel){
    				flag = true;
    				break;
    			} 
    		}
    	}
    	
    	
    	for(var i = 0; i < objForm.dcgo_seq.GetCount;i++){
    		if(objForm.dcgo_seq.GetIndexText(i,0) != ''){
    			var chkRow = new Array();
    			var chkTro = new Array();
    			var isCancel = null;
    			//dcgo_seq로 tro_seq 가져오기
    			for(var j = 1; j <= x_sheetObject4.RowCount; j++){
    				if(objForm.dcgo_seq.GetIndexText(i,0) == x_sheetObject4.CellValue(j,"tro_dcgo_seq")){
    					chkTro.push(x_sheetObject4.CellValue(j,"tro_seq"));
    				}
    			}
    			//가져온 tro_seq를 가진 idx 가져오기
    			for(var k=0; k < chkTro.length; k++){
    				for(var j=1;j<=x_sheetObject2.RowCount;j++){
    					if(chkTro[k]==x_sheetObject2.CellValue(j,"tro_seq")){
    						chkRow.push(x_sheetObject2.FindText("tro_seq", chkTro[k], j ));
    					}
    				}
    			}

    			//해당 idx별 취소 여부 판별 취소가 하나라도 안된게 있으면 false세팅후 for break
    			for(var j=0; j< chkRow.length ;j++){ 
    				if(x_sheetObject2.CellValue(chkRow[j],"cxl_flg") == "Y"){
    					isCancel = true; 
    				}else{
    					isCancel = false; 
    					break;
    				}
    			} 
    			
    			if(x_sheetObject4.FindText("tro_dcgo_seq",objForm.dcgo_seq.GetIndexText(i,0))== -1 || isCancel){
    				flag = true;
    				break;
    			}
    		}
    	}
    	return flag;
    	
    }
    function T1RevChkFnc(){
  		// T1 Revenue 상에 Arbitrary charge 존재하지만 Pop up 으로 Open 하여 입력 하지 않은 경우 메시지 출력을 위한 작업	
		var formObj = document.form;
  		for(var i=1; i<= sheetObjects[0].RowCount; i++){
  			if("1" == sheetObj.CellValue(i, "chk")){
	  			formObj.bse_port_loc_cd.value = sheetObjects[0].CellValue(i,"pod_cd");
	  			formObj.pnt_loc_cd.value = sheetObjects[0].CellValue(i,"loc_cd");
	  			formObj.trsp_mode_cd.value = sheetObjects[0].CellValue(i,"bkg_trsp_mzd_cd");
	  			formObj.rf_flag.value = sheetObjects[0].CellValue(i,"rc_flg");
	  			formObj.awk_flag.value = sheetObjects[0].CellValue(i,"awk_cgo_flg");
	  			formObj.dg_flag.value = sheetObjects[0].CellValue(i,"dg_flg");
	  			formObj.cntr_tpsz_cd.value = sheetObjects[0].CellValue(i,"cntr_tpsz_cd");
	  			formObj.f_cmd.value = SEARCH01;
		  		var param =  FormQueryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0317GS.do", param);
				if (sXml != "") {
					//Arbitrary charge 존재하는지 체크
					if(ComGetEtcData(sXml, "gline_rev_amt") != "" && undefined != ComGetEtcData(sXml, "gline_rev_amt")){
						//Arbitrary charge 적용 하였는지 계속 체크
						if(ComGetEtcData(sXml, "gline_rev_amt") != sheetObjects[0].CellValue(i,"trns_rev_amt")){
							glineRevAmtFlg ="Y";	
							break;
						}else{
							glineRevAmtFlg ="N";
						}
					}else{
						glineRevAmtFlg ="N";	
					}
				}
  			}
  		}
    }
    
	/* 개발자 작업  끝 */