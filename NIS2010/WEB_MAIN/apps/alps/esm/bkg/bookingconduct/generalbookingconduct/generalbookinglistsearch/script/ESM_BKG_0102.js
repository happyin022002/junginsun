/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0102.js
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
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
     * @class esm_bkg_0102 : esm_bkg_0102 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0102() {
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
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;
    
    var transaction = false;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH,"");
					break;
				case "btn_New":
					sheetObject1.RemoveAll();
					formObject.reset();
					break;						
				case "btn_CompulsoryFirm":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE,"");
					break;
		        case "btns_Calendar": //달력버튼
		            var cal = new ComCalendarFromTo();
		            cal.select(formObject.s_bkg_cre_dt,formObject.e_bkg_cre_dt, 'yyyy-MM-dd');
		            break;	
		        case "btn_Firm":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY04);
                	break;
		        case "btn_Waiting":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY05);
	              	break;
		        case "btn_StandbyToFirm":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY07);
	              	break;
		        case "btn_FirmToStandby":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY06);
	              	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111");   
    		} else {
    			ComShowMessage(e);
    		}
    	}
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
		var formObj = document.form;
		var sXml = ComGetObjValue(formObj.sXml);
		formObj.sXml.value = null;
		var arrXml = sXml.split("|$$|");    
		// Combo 셋팅
		if (arrXml.length > 0){
			ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "name");
		}     	        
		if (arrXml.length > 1){
			ComBkgXml2ComboItem(arrXml[1], comboObjects[1], "val", "name");
		}     	        
		if (arrXml.length > 2){
			ComBkgXml2ComboItem(arrXml[2], comboObjects[2], "val", "name");
		}     	        
		comboObjects[0].Code2 = "W";
		ComBtnDisable("btn_Waiting");
		ComBtnDisable("btn_FirmToStandby");
		
		if(ComGetObjValue(formObj.rhq_ofc_cd) != "NYCRA"
			&& ComGetObjValue(formObj.usr_ofc_cd) != "SELCMQ"
			&& ComGetObjValue(formObj.usr_ofc_cd) != "SELCTY"
			&& ComGetObjValue(formObj.usr_ofc_cd) != "CLTCO"){
			ComSetDisplay("btn_StandbyToFirm", false);
			ComSetDisplay("btn_FirmToStandby", false);
			ComSetDisplay("id_aloc_sts_cd", false);
			ComSetDisplay("id_aloc_svc_cd", false);
			ComSetDisplay("aloc_sts_cd", false); 
			ComSetDisplay("aloc_svc_cd", false); 
			sheetObjects[0].ColHidden("aloc_sts_cd") = true;	
			sheetObjects[0].ColHidden("aloc_svc_cd") = true;			
		} else {
			ComSetDisplay("btn_StandbyToFirm", true);
			ComSetDisplay("btn_FirmToStandby", true);
			ComSetDisplay("id_aloc_sts_cd", true);
			ComSetDisplay("id_aloc_svc_cd", true);
			ComSetDisplay("aloc_sts_cd", true); 
			ComSetDisplay("aloc_svc_cd", true); 
			comboObjects[1].Code2 = "S";
			formObj.aloc_svc_cd.Enable = true;	
		}
		
		document.form.bkg_vvd_cd.focus();
		
		initControl()
	}
     
     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * 
      * @param {ibsheet}
      *            sheetObj IBSheet Object
      * @param {int}
      *            sheetNo sheetObjects 배열에서 순번
      */
    function initControl() {
     	var formObject = document.form;
        axon_event.addListenerFormat('keypress','bkg0102_keypress',formObject); //- 키보드 입력할때
        axon_event.addListenerForm  ('beforedeactivate', 'bkg0102_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'bkg0102_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }   

   /**
    * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
    **/
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
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
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		var sheetID = sheetObj.id;

        switch(sheetID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 352;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 2, 100);

					var HeadTitle1 = "|Sel.|No.|Booking No.|STS|Standby|Standby|T.VVD|T.POL|Shipper|Forwarder|Rep. Commodity|Rep. Commodity|Q’ty|Q’ty|K.Ton|POD";
					var HeadTitle2 = "|Sel.|No.|Booking No.|STS|STS|SVC Type|T.VVD|T.POL|Shipper|Forwarder|Code|Description|FEU|TEU|K.Ton|POD";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //[SORT=true,COLUMNMOVE=false,ALLCHECK=true,USERRESIZE=true]
                    InitHeadMode(true, true, true, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox	,	40,     daCenter,    	true,     	"chk",			false,    		"",      dfNone, 			0,     true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"seq");
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"bkg_number",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			30,		daCenter,		true,		"bkg_sts_cd",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		"aloc_sts_cd",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"aloc_svc_cd",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		"bkg_t_vvd",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"pol_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,			true,		"s_cust_nm",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			170,	daLeft,			true,		"f_cust_nm",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"cmdt_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			140,	daLeft,			true,		"cmdt_nm",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		"feu",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			35,		daCenter,		true,		"teu",			false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"ton",			false,			"",      dfNullFloat,		1,		false,		false);
					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"pod_cd",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden,   	30,    	daCenter,  		false,     	"bkg_no");        
					InitDataProperty(0, cnt++ , dtHidden,   	30,    	daCenter,  		false,     	"bdr_flg");  

					CountPosition = 2;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, custTp) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				if(custTp == "S"){
					if(transaction) {
						return;
					} else {
						transaction = true;
					}
					
					if(!ComIsNull(formObj.s_cust_seq)){
						if(!ComIsNumber(formObj.s_cust_seq)){
				 			ComShowCodeMessage("BKG00340");
							formObj.s_cust_seq.focus();
							return false;
						}
					}
					var custCntCd = formObj.s_cust_cnt_cd.value;
					var custSeq = formObj.s_cust_seq.value;
					formObj.s_cust_nm.value = "";
					
					formObj.f_cmd.value = SEARCH01;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0102GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq , FormQueryString(formObj));
					ComOpenWait(false);
					
					transaction = false;
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
						formObj.s_cust_nm.value = ComGetEtcData(sXml,"cust_nm");
					} else {
						sheetObj.LoadSearchXml(sXml)
					}
				} else if(custTp == "F"){
					if(transaction) {
						return;
					} else {
						transaction = true;
					}				
					
					if(!ComIsNull(formObj.f_cust_seq)){
						if(!ComIsNumber(formObj.f_cust_seq)){
				 			ComShowCodeMessage("BKG00340");
							formObj.f_cust_seq.focus();
							return false;
						}
					}
					var custCntCd = formObj.f_cust_cnt_cd.value;
					var custSeq = formObj.f_cust_seq.value;	
					formObj.f_cust_nm.value = "";	
					
					formObj.f_cmd.value = SEARCH01;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0102GS.do?cust_cnt_cd="+custCntCd+"&cust_seq="+custSeq , FormQueryString(formObj));
					ComOpenWait(false); 
					
					transaction = false;
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){
						formObj.f_cust_nm.value = ComGetEtcData(sXml,"cust_nm");
					} else {
						sheetObj.LoadSearchXml(sXml)
					}
				} else {					
					if(validateForm(sheetObj, formObj, sAction)){
						formObj.f_cmd.value = SEARCH;
						sheetObj.WaitImageVisible=false;
						ComOpenWait(true);						
						var sXml = sheetObj.GetSearchXml("ESM_BKG_0102GS.do" , FormQueryString(formObj));
						ComOpenWait(false); 
						
						sheetObj.LoadSearchXml(sXml);
						if(sheetObj.Rows == 3){ // 조회 결과가 1건
							var bkgStsCd = sheetObj.CellValue(2, "bkg_sts_cd");
							if(bkgStsCd.length == 1){
								comboObjects[0].Code2 = bkgStsCd;							
								bkg_sts_cd_OnChange(formObj, bkgStsCd, bkgStsCd);
							}
						}
					}
				}
				break;

			case IBSAVE:        // comp firm
				if(validateForm(sheetObj, formObj, sAction)){
					var chkRowArr = sheetObj.FindCheckedRow("chk");
					var chkRow = chkRowArr.split("|");

					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					for (var idx=0;idx<chkRow.length-1;idx++) {
						var param = "?f_cmd=" + MODIFY;
						param = param + "&bkg_no=" + sheetObj.CellValue(chkRow[idx], "bkg_no");
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0102GS.do"+param);
						if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)!="S"){
							sheetObj.LoadSearchXml(sXml);
							break;
						}
					}
					ComOpenWait(false); 
					//기존 한번에 전부 firm
//					param = param + "&" + sheetObj.GetSaveString(false);
//					
//					sheetObj.WaitImageVisible=false;
//					ComOpenWait(true);
//					var sXml = sheetObj.GetSaveXml("ESM_BKG_0102GS.do" , param);
//					ComOpenWait(false); 
//					
//					sheetObj.LoadSearchXml(sXml);
//
					if(ComGetEtcData(sXml,ComWebKey.Trans_Result_Key)=="S"){	
						ComBkgSaveCompleted();							
					}
					doActionIBSheet(sheetObj,formObj,IBSEARCH,"");			
				}
				break;
			
			case MODIFY04:      //Waiting -> Firm (pending 제거)
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
	    	     		if(sheetObj.CellValue(idx,"chk") == "1"){
							var param = "?f_cmd=" + MODIFY04 + "&newStsCd=F&bkg_no=" + sheetObj.CellValue(idx, "bkg_no");
							
							var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchXml(sXml);	
								break;
							}
	    	     		}
	    	      	}	    	      	
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();					
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
				break;			

			case MODIFY05:      //Firm -> Waiting
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
	    	     		if(sheetObj.CellValue(idx,"chk") == "1"){
							var param = "?f_cmd=" + MODIFY05 + "&newStsCd=P&bkg_no=" + sheetObj.CellValue(idx, "bkg_no");
							
							var sXml = sheetObj.GetSaveXml("ESM_BKG_0079_01GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchXml(sXml);				
								break;
							}
	    	     		}
	    	      	}					
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
				break;

			case MODIFY06:      //Firm -> Stand by
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
	    	     		if(sheetObj.CellValue(idx,"chk") == "1"){
							var param = "?f_cmd=" + MODIFY01 + "&aloc_sts_cd=S&bkg_no=" + sheetObj.CellValue(idx, "bkg_no");
	
							var sXml = sheetObj.GetSaveXml("ESM_BKG_0102GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchXml(sXml);				
								break;
							}
	    	     		}
	    	      	}					
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
				break;

			case MODIFY07:      //Stand by-> Firm 
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
	    	      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
	    	     		if(sheetObj.CellValue(idx,"chk") == "1"){
							var param = "?f_cmd=" + MODIFY01 + "&aloc_sts_cd=F&bkg_no=" + sheetObj.CellValue(idx, "bkg_no");

							var sXml = sheetObj.GetSaveXml("ESM_BKG_0102GS.do" + param);
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchXml(sXml);				
								break;
							}
	    	     		}
	    	      	}					
					ComOpenWait(false); 
				}
				if(ComGetEtcData(sXml, "isSuccess") == "Y"){
					ComBkgSaveCompleted();
				}
				doActionIBSheet(sheetObj,formObj,IBSEARCH,"");
				break;
        }
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:      //조회
				if(formObj.bkg_no.value.length >10){
					return true;
				}
				if(!ComIsNull(formObj.s_cust_seq)){
					if(!ComIsNumber(formObj.s_cust_seq)){
			 			ComShowCodeMessage("BKG00340");
						formObj.s_cust_seq.focus();
						return false;
					}
				}
				if(!ComIsNull(formObj.f_cust_seq)){
					if(!ComIsNumber(formObj.f_cust_seq)){
			 			ComShowCodeMessage("BKG00340");
						formObj.f_cust_seq.focus();
						return false;
					}
				}
				if (formObj.s_bkg_cre_dt.value != "" && formObj.e_bkg_cre_dt.value != "") {
					if (ComGetDaysBetween(formObj.s_bkg_cre_dt.value, formObj.e_bkg_cre_dt.value)>31){
						ComShowMessage(msgs['BKG50469']);
						return false;
					} 
					if(formObj.pol_cd.value.length==0 && formObj.pod_cd.value.length==0 
							&& formObj.bkg_ofc_cd.value.length==0 && formObj.ob_sls_ofc_cd.value.length==0){
						ComShowCodeMessage("BKG00104","POL or POD or B.OFC or S.OFC");			
						return false;
					} 
					return true;
				}				
				if(formObj.bkg_vvd_cd.value.length != 9){
					ComShowCodeMessage("BKG00115");
					formObj.bkg_vvd_cd.focus();
					return false;
				}
				break;
				
			case IBSAVE:        //저장
				if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{
	    	      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
	    	     		if(sheetObj.CellValue(idx,"chk") == "1"){
	    	     			if(sheetObj.CellValue(idx,"bdr_flg") == "Y"){
//	    	     				ComShowCodeMessage("BKG00003");
//	    	     				return false;
//	    	     				break;
	    	     			}
	    	     		}
	    	 	    } 							
				}				
				break;
				
	    	case MODIFY04:      // Waiting -> Firm   
				if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{	        
			      	for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
			     		if(sheetObj.CellValue(idx,"chk") == "1"){
			     			if(sheetObj.CellValue(idx,"bkg_sts_cd") == "F"){
			     				ComShowCodeMessage("BKG00383");
			     				return false;
			     				break;
			     			}
			     		}
			 	    } 	
				}
				break;   
				
        	case MODIFY05:      // Firm -> Waiting    
	        	if(sheetObj.CheckedRows("chk") < 1){
					ComShowCodeMessage("BKG00155");
					return false;
				}else{	        
					for (var idx=sheetObj.HeaderRows; idx<=sheetObj.LastRow; idx++) {
			     		if(sheetObj.CellValue(idx,"chk") == "1"){
			     			if(sheetObj.CellValue(idx,"bkg_sts_cd") == "W"){
			     				ComShowCodeMessage("BKG00383");
			     				return false;
			     				break;
			     			}
			     		}
			 	    } 
				}
				return true;        		
				break;              
        }
	    return true;
	}

	function bkg_sts_cd_OnChange(formObj, Code, Text){
		if(Code=="W"){
			ComBtnEnable("btn_Firm");
			ComBtnDisable("btn_Waiting");
		} else {
			ComBtnEnable("btn_Waiting");
			ComBtnDisable("btn_Firm");			
		}
	}	

	function aloc_sts_cd_OnChange(formObj, Code, Text){
		if(Code=="S"){
			ComBtnEnable("btn_StandbyToFirm");
			ComBtnDisable("btn_FirmToStandby");
		} else {
			ComBtnEnable("btn_FirmToStandby");
			ComBtnDisable("btn_StandbyToFirm");			
		}
	}
	
//    /**
//     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
//     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
//     * <br><b>Example :</b>
//     * <pre>
//     * 
//     * </pre>
//     * @param {ibsheet} sheetObj 필수 IBSheet Object
//     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
//     * @return 없음
//     * @author 김병규
//     * @version 2009.05.17
//     */ 	
// 	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
// 		if (ErrMsg == "") {
//			ComBkgSaveCompleted();
//			sheetObj.RemoveAll();
//			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH,"");
//		}
//	}     	
     
	function bkg0102_keypress(){
	    switch(event.srcElement.dataformat){
	    	case "engup":
		        //영문대문자
	    		ComKeyOnlyAlphabet('upper');
		        break;
	        case "engupnum":
	            //숫자+"영문대분자"입력하기
	        	ComKeyOnlyAlphabet('uppernum');
	            break;
	        case "num":
	            //숫자 입력하기
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	            
	        default:
	    }
	}    
    
    /**
     * HTML Control의 onBlur을 제어한다.
     **/
    function bkg0102_deactivate() {
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "s_cust_seq":	    		
	    		if(formObj.s_cust_cnt_cd.value.length > 0 && formObj.s_cust_seq.value.length > 0){
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "S");
	    		}else{
	    			//formObj.s_cust_nm.value = "";
	    		}
	    		break;
	    	case "f_cust_seq":
	    		if(formObj.f_cust_cnt_cd.value.length > 0 && formObj.f_cust_seq.value.length > 0){
	    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "F");
	    		}else{
	    			//formObj.s_cust_nm.value = "";
	    		}
	    		break;        	
	    	case "s_bkg_cre_dt":
	    		ComAddSeparator(event.srcElement);
				break;
	    	case "e_bkg_cre_dt":
	    		ComAddSeparator(event.srcElement);
				break;	    		
	    }
    }        

	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function bkg0102_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "s_bkg_cre_dt":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "f_bkg_cre_dt":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}    
	/* 개발자 작업  끝 */