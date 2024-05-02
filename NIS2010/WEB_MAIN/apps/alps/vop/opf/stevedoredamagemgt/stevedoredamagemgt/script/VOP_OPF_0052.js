/*=================================================================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_0052.js
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.18 김종옥
* 1.0 Creation
* ----------------------------------------------------------------------------------------
* History
* 2010.09.10 정윤태 [CHM-201005739-01] SDMS Creation 화면 권한별 버튼(Save, Add, Delete) 제어하기
* 2010.09.29 최윤성 [CHM-201006257-01] VVD 팝업 선택시 Lane 값 세팅
* 2010.10.12 이석준 [] Port Combo -> Text box로 변경
*                    VSL,VVD,Port,Lane의 유효성 Check 추가
*                    Delete시 유효성 check Logic 추가
* 2010.12.9 이상민 [CHM-201007482-01] 개인권한과 무관하게 vessel code별로 버튼에 대한 권한은 따로있음
* 					file upload / upload된 파일 cross되어 download되는 현상 수정
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항                    
* 2011.10.21 김민아 [CHM-201113609-01] SDMS 신속 처리를 위한 Auto mailing 기능 추가 - 담당자 선택 기능 추가 및 Auto mailing 기능 추가
* 2011.11.08 김민아 [CHM-201114487-01] SDMS내 과거 SDR 입력 불가 관련 기능 개선 요청
* 2011.11.18 김민아 [CHM-201114254-01] [VOP-OPF/SDMS] Repaur VVD 및 Port 설정 기능 변경
* 2012.02.03 김민아 [CHM-201215702-01] [VOP-OPF] SDMS No. 정의 및 칼럼 정리 : SDMS No. 보완 및 Report No. 제거
==========================================================================================*/
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
     * @class vop_opf_0052 : vop_opf_0052 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_0052() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.initDefaultSheet		= initDefaultSheet;
    	this.dataClear				= dataClear;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_activate			= obj_activate;
    	this.obj_keypress			= obj_keypress;
    	this.engnum_keypress		= engnum_keypress;
    	this.obj_keyup				= obj_keyup;
    	this.change_event			= change_event;
    	this.click_event			= click_event;
    	this.setVVDPortCombo		= setVVDPortCombo;
    	this.blur_event				= blur_event;
    	this.initCombo				= initCombo;
    	
    	this.isNull					= isNull;
    	this.setComboItem			= setComboItem;
    	this.setComboItem2			= setComboItem2;
    	this.setComboItem3			= setComboItem3;
    	this.combo_vps_port_cd_OnChange	= combo_vps_port_cd_OnChange;
    	this.setDefaultComboData	= setDefaultComboData;
    	this.setDamageReasonComboS	= setDamageReasonComboS;
    	this.setDisplaySeq			= setDisplaySeq;
    	this.moveScreen				= moveScreen;
    	this.searchValidation		= searchValidation;
    	this.stv_dmg_prt_cate_cd_OnChange	= stv_dmg_prt_cate_cd_OnChange;
    	this.stv_dmg_prt_cd_OnChange		= stv_dmg_prt_cd_OnChange;
    	this.stv_dmg_tp_cd_OnChange			= stv_dmg_tp_cd_OnChange;
    	this.stv_dmg_qttn_rsn_desc_OnChange	= stv_dmg_qttn_rsn_desc_OnChange;
    	this.stv_dmg_respb_desc_OnChange	= stv_dmg_respb_desc_OnChange;
    	this.getDateHoursBetween			= getDateHoursBetween;
    	this.initApprovalPermission			= initApprovalPermission;
    	this.setStvDmgNo			= setStvDmgNo;
		this.stv_dmg_respb_pty_kwn_cd_OnChange	= stv_dmg_respb_pty_kwn_cd_OnChange;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;
    
    var userId = "";
    var ofcCd = "";
    var approvalFlag = false;
    
    //2차원 배열
    var gVpsEtbEtdDt;
    
    //Port Combo List
    var strPortComboList = "";
    var strYdComboList = "";
    var strTurnPortindCdComboList = "";
    
    var deltFlg = false;
    
    //Responsible Party 의 UnKnown 체크 유무
    var unKnownFlg = false;
    
    //var old_cd = "";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
         var prefix = "sheet1_";

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
            	case "btn_SDR":
            		if(ComIsBtnEnable("btn_SDR")){
            			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=SDR&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", false, "","","","","Damage_Creation");
            		}
            		break;
            		
            	case "btn_Picture":
            		if(ComIsBtnEnable("btn_Picture")){
            			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", false, "","","","","Damage_Creation");
            		}
            		break;
            		
            	case "btn_Document":
            		if(ComIsBtnEnable("btn_Document")){
            			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF0052&stvDmgNo="+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no")+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", false, "","","","","Damage_Creation");
            		}
            		break;
            		
	            case "vsl_cd_pop":
	            	if(!(formObject.vsl_cd.readOnly)){
	            		var sUrl = "";
	                	var vsl_cd = formObject.vsl_cd.value;
	                	
	                	if(isNull(vsl_cd)){
	                		sUrl = "/hanjin/VOP_VSK_0219.do?op=0219";
	                		ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
	                	}else{
	                		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	                		ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
							
							// Port Code 가져오기
							//setVVDPortCombo(sheetObject1, formObject, "Vsl", false);
	                	}
	            	}
					
	            	break;
	            	
	            case "clm_hndl_ofc_cd_pop":
	            	if(!(formObject.clm_hndl_ofc_cd.readOnly)){
		            	ComOpenPopup("COM_ENS_071.do", 750, 470, "clm_hndl_ofc_cd_pop_event", "1,0,1", true);
	            	}
	            	break;
	            	
	            case "req_skd_voy_dir_pop":
	            	if(!(formObject.stv_dmg_req_cate_cd[2].checked)
	            		&& !(formObject.req_skd_voy_dir.readOnly))
	            	{
		            	//ComOpenPopup("VOP_VSK_0230.do?op=0230", 300, 360, "req_skd_voy_dir_pop_event", "0,0", true);
		            	var vsl_cd = formObject.vsl_cd.value;
		            	if(isNull(vsl_cd)){
		            		//ComShowMessage("Vessel Code is not exist.");
		            		ComShowCodeMessage("OPF50009", "Vessel Code");
		            		//ComSetFocus(formObject.vsl_cd);
		            		formObject.vsl_cd.focus();
		            	}
		            	else{
		            		sUrl = "/hanjin/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
	                		ComOpenPopup(sUrl, 335, 420, "req_skd_voy_dir_pop_event", "0,0", true);
		            	}
	            	}
	            	break;
	            	
            	case "btn_stv_dmg_evnt_dt":
            		if(!(formObject.stv_dmg_evnt_dt.readOnly)){
                		var cal = new ComCalendar();
                    	cal.select(form.stv_dmg_evnt_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_req_eta_dt":
            		if(!(formObject.stv_dmg_req_cate_cd[2].checked)
            			&& !(formObject.req_eta_dt.readOnly))
            		{
                		var cal = new ComCalendar();
                    	cal.select(form.req_eta_dt, 'yyyy-MM-dd');
            			
            		}
            		break;
            		
            	case "btn_Prev":
            		if(ComIsBtnEnable("btn_Prev")
            			&& (sheetObject1.RowStatus(sheetObject1.SelectRow)=="R"
            				|| validateForm(sheetObject1,formObject)))
            		{
    					moveScreen(sheetObject1, formObject, -1, "", "");
            		}
					break;
					
            	case "btn_Next":
            		if(ComIsBtnEnable("btn_Next")
            			&& (sheetObject1.RowStatus(sheetObject1.SelectRow)=="R"
            				|| validateForm(sheetObject1,formObject)))
            		{
            			moveScreen(sheetObject1, formObject, 1, "", "");
            		}
					break;
					
				case "btn_Add":
					if(ComIsBtnEnable("btn_Add")){
						if(!validateForm(sheetObject1,formObject)){
							return false;
						}
						initDefaultSheet(sheetObject1, formObject, "A");
						dataClear(formObject, "add");
						setScreenreadOnly(false, formObject, sheetObject1);
					}
					break;
					
				case "btn_Delete":
					
					deltFlg = true;
					
					var stvDmgNo = formObject.stv_dmg_no.value;

					var resultXml1 = sheetObject1.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);

					var delCheckInd = ComGetEtcData(resultXml1, "del_check_ind");
					
					if (delCheckInd !="0"){
						ComShowCodeMessage("OPF50026", stvDmgNo);
						deltFlg = false;
						return false;
					}
					if(ComIsBtnEnable("btn_Delete")){
						// 현재 Row 삭제 후  화면 이동.
						if(sheetObject1.RowStatus(sheetObject1.SelectRow)=="I"){
			        		//SDR, PIC, DOC 시트 sheet1_stv_dmg_no와 같은 파일 삭제
							for(var sh=2; sh<=4; sh++) {
								for(var i=sheetObjects[sh].LastRow; i>=sheetObjects[sh].HeaderRows; i--) {
				        			if( sheetObjects[sh].CellValue(i, "sheet"+(sh)+"_stv_dmg_no") == sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no") ){
				        				sheetObjects[sh].RowStatus(i) = "D";
				        			}
				        			
				        		}
							}
							
							sheetObject1.RowStatus(sheetObject1.SelectRow) = "D";
							moveScreen(sheetObject1, formObject, 0, "", "");
						}
						else{
							if(ComShowCodeConfirm("OPF50002", "the sequence")){
								sheetObject1.RowStatus(sheetObject1.SelectRow) = "D";
							}
						}
					}
					if(ComIsBtnEnable("btn_Save"))
					{
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						if(sheetObject1.RowCount<1){
							initDefaultSheet(sheetObject1, formObject);
							dataClear(formObject);
						}
					}					
					deltFlg = false;
					break;
					
				case "btn_Approval":
					if(ComIsBtnEnable("btn_Approval")){
						doActionIBSheet(sheetObject1,formObject,IBSAVE, "Approval");
					}
					break;
					
				case "btn_Retrieve":
					if(!searchValidation(formObject)){
						return false;
					}
					//2010.12.9 이상민 SDMS No.가 있다면 File도 가져온다
					if(formObject.stv_dmg_no.value != ""){
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						if(formObject.stv_dmg_no.value != ""){
							doActionIBSheet(sheetObject1,formObject,IBSEARCH,"File");
						}
					}else {
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					}
					
					//2010.12.3 이상민 [CSR선처리]-creation화면에서도 vessel code로 retrieve시 조건에 따라 delete버튼이 활성/비활성화 되어야 한다
					//권한과는 무관하다
					var stvDmgNo = formObject.stv_dmg_no.value;
					var resultXml1 = sheetObject1.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND02+"&stv_dmg_no="+stvDmgNo);
					var delCheckInd = ComGetEtcData(resultXml1, "del_check_ind");
					if (delCheckInd == 0) 	ComBtnEnable("btn_Delete");
					else 					ComBtnDisable("btn_Delete");
					
					break;
					
				case "btn_New":
					if(ComIsBtnEnable("btn_New"))
					{
						doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					}
					break;
					
				case "btn_Save":
					if(ComIsBtnEnable("btn_Save"))
					{
						doActionIBSheet(sheetObject1,formObject,IBSAVE);
						if(sheetObject1.RowCount<1){
							initDefaultSheet(sheetObject1, formObject);
							dataClear(formObject);
						}
					}
					break;
					
				case "btn_Mail":
					//ComOpenPopup("VOP_OPF_2052.do", 700, 530, "", "0,0", true);
					formObject.com_templateMrdArguments.value = "/rp ["+sheetObject1.CellValue(sheetObject1.SelectRow, "sheet1_stv_dmg_no")+"]";
					ComSendMailModal();
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
     * 페이지에 생성된 IBMultiCombo Object를 comboObjects 배열에 등록한다. <br>
     * comboObjects 배열은 공통전역변수로 상단에 정의하고, 이 함수는 {@link CoObject#ComComboObject} 함수에 의해서 IBMultiCombo Object가 생성되면서 자동 호출된다. <br>
     * @param {ibmulticombo} combo_obj    IBMultiCombo Object
     **/
    function setComboObject(combo_obj){
       comboObjects[comboCnt++] = combo_obj;
    }
    
    /**
     * 페이지에 생성된 IBUpload Object를 uploadObjects 배열에 등록한다. <br>
     * @param {ibupload} uploadObj    IBUpload Object
     **/
	function setUploadObject(uploadObj) {
		uploadObj.AutoConfirm = "UP_OVERWRITE_YES DELETE_YES";
		uploadObjects[uploadCnt++] = uploadObj;
	}
	
	/**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(id) {
		        case "combo_vps_port_cd":
	            	SetTitle("Port|Yard");
	            	SetColWidth("70|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
//		        case "vsl_oshp_cntr_blk_tp_cd":
//	            	SetTitle("Category");
//	            	//SetColWidth("100|50|200")
//	            	DropHeight = 230;
//	            	MultiSelect = false;
//	            	MaxSelect = 1;
//	            	UseAutoComplete = true;
//		            break;
		            
		        case "stv_dmg_prt_cate_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "stv_dmg_prt_cd":
	            	SetTitle("Code|Part");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "stv_dmg_tp_cd":
	            	SetTitle("Code|Damage");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
//		        case "req_port_cd":
//	            	SetTitle("Port");
//	            	//SetColWidth("100|50|200")
//	            	DropHeight = 230;
//	            	MultiSelect = false;
//	            	MaxSelect = 1;
//	            	UseAutoComplete = true;
//	            	ValidChar(2,0);
//	            	MaxLength = 5;
//		            break;
		            
		        case "stv_dmg_qttn_rsn_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|140");
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "combo_req_port_cd":
		        	SetTitle("Port|Calling Seq.");
		        	SetColWidth("60|90");
		        	SetColAlign("left|center");
		        	DropHeight = 230;
		        	
		        	break;
				
				case "stv_dmg_respb_pty_kwn_cd":
	            	SetTitle("Responsible Party");
	            	SetColWidth("45|140");
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "stv_dmg_respb_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|185");
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "stv_dmg_evnt_dt":
		        	UseEdit = true;
		        	MaxLength = 10;
		        	break;
		    }
    	}
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(strUsrId, strOfcCd) {

		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//Combo 초기화
    	for(var k=0; k<comboObjects.length; k++){
        	initCombo(comboObjects[k]);
        }
		
		//UPLOAD 환경 설정
        for(var i=0;i<uploadObjects.length;i++){
		    //1. 기본 환경 설정
		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_OPF_0052GS.do");
		}
		
		userId = strUsrId;
		ofcCd = strOfcCd;
		
		initControl();
		
		initDefaultSheet(sheetObjects[1], document.form, "Y");
		
		initApprovalPermission(sheetObjects[1], document.form);		
		
		ComSetFocus(document.form.vsl_cd);
	}
    
    
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
    	//axon_event.addListenerForm  ('blur',      'obj_deactivate', form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
        
    	//Code 입력 시 영문 대문자만 입력하기
    	axon_event.addListener  ('keypress', 'engnum_keypress' , 'vsl_cd'
																, 'skd_voy_no'
																, 'skd_dir_cd'
																, 'stv_dmg_no_prefix'
																, 'stv_dmg_no_suffix'
																, 'clm_hndl_ofc_cd'
																, 'cntr_no'
																, 'input_vps_port_cd'
																, 'req_skd_voy_dir'
    															, 'req_port_cd'
    	    													, 'stv_dmg_no'
    	    											        );
    	axon_event.addListener  ('keyup', 'obj_keyup' , 'stv_dmg_no'
    													, 'vsl_cd'
														, 'skd_voy_no'
														, 'skd_dir_cd'
														, 'stv_dmg_no_prefix'
														, 'input_vps_port_cd'
//														, 'stv_dmg_evnt_dt'
														, 'req_skd_voy_dir'
														, 'fm_tm_lss_dt'
														, 'to_tm_lss_dt');
    	
    	// HTML 데이터 입력시 Hidden Grid에 Data Set!
    	axon_event.addListener  ('blur'  , 'blur_event' , 'skd_dir_cd'
    													, 'stv_dmg_no'
    													 , 'vsl_cd'
														 , 'skd_voy_no'
														 , 'clm_hndl_ofc_cd'
														 , 'stv_dmg_loc_desc'
														 , 'cntr_no'
														 , 'stv_dmg_rmk'
														 , 'req_skd_voy_dir' 
														 , 'stv_dmg_respb_desc_dtl'
														 , 'input_vps_port_cd');
    	
    	axon_event.addListener  ('click'  , 'click_event', 'stv_dmg_prt_cd'
    													, 'cntr_dmg_flg'
														, 'cgo_dmg_flg'
														, 'stv_dmg_req_cate_cd'
		   												, 'stv_dmg_respb_pty_kwn_cd');
    	
    	axon_event.addListener  ('change'  , 'change_event', 'vsl_cd'
														   , 'skd_voy_no'
    													   , 'skd_dir_cd'
    													   , 'stv_dmg_no_prefix'
    													   , 'stv_dmg_no_suffix'
    													   , 'input_vps_port_cd'
    													   //, 'clm_hndl_ofc_cd'
//    													   , 'stv_dmg_evnt_dt'
    													   , 'stv_dmg_loc_desc'
    													   , 'cntr_no'
    													   , 'stv_dmg_rmk'
    													   , 'req_skd_voy_dir' 
    													   , 'req_port_cd'
    													   , 'stv_dmg_respb_desc_dtl'
    													   , 'stv_dmg_rpt_atch_flg'
    													   , 'stv_dmg_pict_atch_flg'
    													   , 'stv_dmg_doc_atch_flg'
    													   , 'req_reason_desc'
    													   , 'res_reason_desc'
    													   , 'stv_dmg_no');
    	
    	axon_event.addListener  ('focus'  , 'focus_event', 'vsl_cd'
														 , 'skd_voy_no'
														 , 'skd_dir_cd'
														 , 'stv_dmg_no'
														 , 'stv_dmg_no_suffix'
														 , 'input_vps_port_cd'
														 , 'clm_hndl_ofc_cd'
														 , 'stv_dmg_loc_desc'
														 , 'cntr_no'
														 , 'stv_dmg_rmk'
														 , 'req_skd_voy_dir' 
														 , 'req_port_cd'
														 , 'stv_dmg_respb_desc_dtl');
    }
    
    /**
     * Prev/Next 버튼의 화면이동 기능. <br>
     **/
    function moveScreen(sheetObj, formObj, moveSeq, searchFlg, strReqPortComboList) {
        
        if( moveSeq==-1 && sheetObj.SelectRow==1 ){
        	//ComShowMessage("No more Previous Page.");
        	setSubButton();
        	return false;
        }
        else if( moveSeq==1 && sheetObj.SelectRow==sheetObj.LastRow ){
        	//ComShowMessage("No more Next Page.");
        	setSubButton();
        	return false;
        }
        sheetObj.SelectRow = sheetObj.SelectRow + moveSeq;
        setSubButton();
        
        // Grid Data를 화면에 Set..
        var prefix = "sheet1_";
        var thisRow 						= sheetObj.SelectRow;
        formObj.vsl_cd.value 				= sheetObj.CellValue(thisRow, prefix+"vsl_cd");
        formObj.skd_voy_no.value 			= sheetObj.CellValue(thisRow, prefix+"skd_voy_no");
        formObj.skd_dir_cd.value 			= sheetObj.CellValue(thisRow, prefix+"skd_dir_cd");
        formObj.input_vps_port_cd.value     = sheetObj.CellValue(thisRow, prefix+"vps_port_cd");
//        comboObjects[0].Code2 				= sheetObj.CellValue(thisRow, prefix+"combo_vps_port_cd");
//        formObj.stv_dmg_evnt_dt.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_evnt_dt");
        var dmgDt = sheetObj.CellValue(thisRow, prefix+"stv_dmg_evnt_dt");
        comboObjects[1].removeAll();
        comboObjects[1].InsertItem(0, dmgDt, ComReplaceStr(dmgDt,'-',''));
        comboObjects[1].Code2 = ComReplaceStr(dmgDt,'-','');
        formObj.slan_cd.value = sheetObj.CellValue(thisRow, prefix+"vsl_slan_cd");
        formObj.vsl_oshp_cntr_blk_tp_cd.value = sheetObj.CellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_cd");
		formObj.vsl_oshp_cntr_blk_tp_nm.value = sheetObj.CellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_desc");
        formObj.clm_hndl_ofc_cd.value 		= sheetObj.CellValue(thisRow, prefix+"clm_hndl_ofc_cd");
        var cateCodeValue = sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd");
        comboObjects[2].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd");
        stv_dmg_prt_cate_cd_OnChange(comboObjects[2], sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"), "");
        comboObjects[3].Code2				= cateCodeValue;
        sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd") = cateCodeValue;
        comboObjects[4].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_tp_cd");
        formObj.stv_dmg_loc_desc.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_loc_desc");
        if(sheetObj.CellValue(thisRow, prefix+"cntr_dmg_flg")=="Y"){
        	formObj.cntr_dmg_flg.checked = true;
        }else{
        	formObj.cntr_dmg_flg.checked = false;
        }
        if(sheetObj.CellValue(thisRow, prefix+"cgo_dmg_flg")=="Y"){
        	formObj.cgo_dmg_flg.checked = true;
        }else{
        	formObj.cgo_dmg_flg.checked = false;
        }
        formObj.cntr_no.value			= sheetObj.CellValue(thisRow, prefix+"cntr_no");
        
    	formObj.fm_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt");
    	formObj.to_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt");
        
        formObj.time_loss_hours.value = "";
        if( !isNull(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"))
        	&& !isNull(sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt")))
        {
        	//var lossHour = getDateHoursBetween(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt"));
        	//if(lossHour==false){ lossHour = ""; }
        	//formObj.time_loss_hours.value = lossHour
        	formObj.time_loss_hours.value = getDateHoursBetween(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt"));
        }
        
        formObj.stv_dmg_rmk.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_rmk");
       
        comboObjects[6].Index2 = "";
        comboObjects[8].Index2 = "";
        formObj.req_reason_desc.value = "";
        formObj.res_reason_desc.value = "";
        
        if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R")
        {
        	formObj.stv_dmg_req_cate_cd[0].checked = true;
        }
        else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S")
        {
        	formObj.stv_dmg_req_cate_cd[1].checked = true;
        }
        else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
        {
        	formObj.stv_dmg_req_cate_cd[2].checked = true;
			comboObjects[6].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_cd");
			formObj.req_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_rsn_desc");
        }
        formObj.req_skd_voy_dir.value 		= sheetObj.CellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.CellValue(thisRow, prefix+"req_skd_dir_cd");
//		setVVDPortCombo(sheetObj, formObj, "Voy", false);
        
        //Requirement Port 셋팅
        var tempReqPortCd = sheetObj.CellValue(thisRow, prefix+"req_port_cd");
        var tempReqEtaDt = sheetObj.CellValue(thisRow, prefix+"req_eta_dt");
//        var tempText = tempReqPortCd+tempReqEtaDt;
        
        if(searchFlg == "Search"){
        	comboObjects[5].RemoveAll(); //Requirement Port Combo 셋팅을 초기화 한다.
        	setReqPortCombo(strReqPortComboList);
        	if(strReqPortComboList != ""){
        		for(var i=0 ; i < comboObjects[5].GetCount() ; i++){
        			if(tempReqPortCd == comboObjects[5].GetIndexText(i, 0) && tempReqEtaDt == comboObjects[5].GetIndexText(i, 2)){
//        				alert("Index : "+i+":"+comboObjects[5].GetIndexText(i, 0)+":"+comboObjects[5].GetIndexText(i, 2));
        				formObj.req_port_cd.value = tempReqPortCd;
        				formObj.req_eta_dt.value = tempReqEtaDt;
//        				comboObjects[5].Code2 = tempReqPortCd;
//        				comboObjects[5].Index = i;
        				comboObjects[5].Index2 = i;
        				combo_req_port_cd_OnChange(comboObjects[5], tempReqPortCd, tempReqPortCd);
        				break;
        			}
        		}
        		
//        		var tempidx = comboObjects[5].FindIndex(tempText, 3);
//				alert(tempText+":"+tempidx);
//				comboObjects[5].Index2= tempidx;
        		
        	}else{
            	formObj.req_port_cd.value = tempReqPortCd;
            	formObj.req_eta_dt.value = tempReqEtaDt;
        	}
        }else{
        	formObj.req_port_cd.value = tempReqPortCd;
        	formObj.req_eta_dt.value = tempReqEtaDt;
        }        
        
        
//        if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="Y"){
//        	formObj.stv_dmg_respb_pty_kwn_cd[0].checked = true;
//        	formObj.stv_dmg_respb_desc_dtl.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
//        }else{
//        	formObj.stv_dmg_respb_pty_kwn_cd[1].checked = true;
//        	formObj.stv_dmg_respb_desc_dtl.value = "";
//			comboObjects[8].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_cd");
//			formObj.res_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
//        }

		comboObjects[7].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd");		
		
		//stv_dmg_respb_pty_kwn_cd_OnChange(comboObjects[7], sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd"), "");
				
		if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd") == "U"){
			comboObjects[8].Code2 			= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_cd");
			formObj.res_reason_desc.value   = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
		}else{
			formObj.stv_dmg_respb_desc_dtl.value   = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
		}
                
        if(sheetObj.CellValue(thisRow, prefix+"dmg_auth_sts_cd")=="N")
        {
    		formObj.dmg_auth_sts_cd.className = "input2_red";
			document.getElementById("btnApproval").style.color="red";
			
        	if(approvalFlag){
        		ComBtnEnable("btn_Approval");
        	}
        	else{
        		ComBtnDisable("btn_Approval");
        	}
    	}
        else{
    		formObj.dmg_auth_sts_cd.className = "input2";
			document.getElementById("btnApproval").style.color="#c0c0c0";
			
        	ComBtnDisable("btn_Approval");
        }
        formObj.dmg_auth_sts_cd.value 		= sheetObj.CellValue(thisRow, prefix+"dmg_auth_sts_cd");
        formObj.auth_usr_id.value 			= sheetObj.CellValue(thisRow, prefix+"auth_usr_id");
        formObj.auth_dt.value 				= sheetObj.CellValue(thisRow, prefix+"auth_dt");
        
        formObj.stv_dmg_rpt_atch_flg.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_rpt_atch_knt");
        formObj.stv_dmg_pict_atch_flg.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_pict_atch_knt");
        formObj.stv_dmg_doc_atch_flg.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_doc_atch_knt");
        
        setDisplaySeq(formObj, sheetObj);
        
        if(sheetObj.RowStatus(thisRow)=="R"){
        	// Creation이 아닌, 조회된 Data인 경우는 입력 금지.
        	setScreenreadOnly(true, formObj, sheetObj);
        }
        else{
        	// Creation Data인 경우는 입력 가능.
        	setScreenreadOnly(false, formObj, sheetObj);
        	
        	if(isNull(comboObjects[2].Code)){
            	comboObjects[3].Enable = false;
            }else{
            	comboObjects[3].Enable = true;
            }
        }
        
        initApprovalPermission(sheetObj, formObj);
    }
    
    /**
     * Sub Button의 Disable/Enable 설정. <br>
     **/
    function setSubButton(){
        
        //2010.09.14 정윤태 [CHM-201005739-01] SDMS Creation 화면 권한별 버튼(Save, Add, Delete) 제어하기
    	//2010.10.13 이석준 [CSR] Delete 버튼은 supert user 혹은 해당 SDMS No의 생성자만 실행할 수 있다.
//    	if(   (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow)=="I"
//    		|| ofcCd==sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_cre_usr_ofc")) )
//    	{
//		   alert(1);
//		   	if( (sheetObjects[1].RowCount==1 && sheetObjects[1].RowStatus(sheetObjects[1].SelectRow)=="I")
//    			|| sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_step_cnt") > 0 )
//	        { alert(2);
//	         	ComBtnDisable("btn_Delete");
//	        }
//	        else{
//	        	if (userId == '8804820'||userId == '8803631'||userId == sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_cre_usr_id")){
//					 alert(3);	        		
//	        	  ComBtnEnable("btn_Delete");
//	        	} else {
//					 alert(4);
//	        	  ComBtnDisable("btn_Delete");
//	        	}
//	        }
//    	}
//    	else{
//alert(( (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) !="I")&&(sheetObjects[1].RowCount > 0) && (userId == '8804820' || userId == '8803631' || userId == sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_cre_usr_id"))));
			if ( (sheetObjects[1].RowStatus(sheetObjects[1].SelectRow) !="I")&&(sheetObjects[1].RowCount > 0) && (userId == '8804820' || userId == '8803631' || userId == sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_cre_usr_id"))) {
//				 alert(5);
				ComBtnEnable("btn_Delete");
			} else {
//				 alert(6);
				ComBtnDisable("btn_Delete");
			}
    		
//    	}
        
 		ComBtnEnable("btn_Save");
 		ComBtnEnable("btn_New");
// 		ComBtnDisable("btn_Retrieve");
    }
    
    /**
     * HTML Control의 조회된 데이터는 수정 금지. <br>
     **/
    function setScreenreadOnly(disableFlag, formObj, sheetObj) {
		if(disableFlag){
    		formObj.vsl_cd.readOnly = true;
            formObj.vsl_cd.className = "input2";
            formObj.skd_voy_no.readOnly = true;
            formObj.skd_voy_no.className = "input2";
            formObj.skd_dir_cd.readOnly = true;
            formObj.skd_dir_cd.className = "input2";
//            formObj.stv_dmg_evnt_dt.readOnly = true;
//            formObj.stv_dmg_evnt_dt.className = "input2";
            formObj.input_vps_port_cd.readOnly = true;
            formObj.input_vps_port_cd.className = "input2";
            comboObjects[0].Enable = false;
			comboObjects[1].Enable = false;
//            comboObjects[2].Enable = false;    // vessel category
            comboObjects[2].Enable = false;   // damage category
            
            formObj.stv_dmg_no_prefix.readOnly = true;
        	formObj.stv_dmg_no_prefix.className = "input2";
        	formObj.stv_dmg_no_suffix.readOnly = true;
        	formObj.stv_dmg_no_suffix.className = "input2";
            /************** Header 부분 *****************************/

//            formObj.stv_dmg_ref_no.readOnly = true;
//            formObj.stv_dmg_ref_no.className = "input2";
//            formObj.clm_hndl_ofc_cd.readOnly = true;
//            formObj.clm_hndl_ofc_cd.className = "input2";
//            
//            comboObjects[3].Enable = false;
//            comboObjects[4].Enable = false;
//            formObj.stv_dmg_loc_desc.readOnly = true;
//            formObj.stv_dmg_loc_desc.className = "input2";
//            ComBtnDisable("btn_SDR");
//            ComBtnDisable("btn_Picture");
//            ComBtnDisable("btn_Document");
//            formObj.stv_dmg_rpt_atch_flg.className = "input2";
//            formObj.stv_dmg_pict_atch_flg.className = "input2";
//            formObj.stv_dmg_doc_atch_flg.className = "input2";
//            formObj.cntr_dmg_flg.disabled = true;
//            formObj.cgo_dmg_flg.disabled = true;
//            formObj.cntr_no.readOnly = true;
//            formObj.cntr_no.className = "input2";
//            formObj.fm_tm_lss_dt.readOnly = true;
//            formObj.fm_tm_lss_dt.className = "input2";
//            formObj.to_tm_lss_dt.readOnly = true;
//            formObj.to_tm_lss_dt.className = "input2";
//            formObj.stv_dmg_rmk.readOnly = true;
//            formObj.stv_dmg_rmk.className = "input2";
//            formObj.stv_dmg_req_cate_cd[0].disabled = true;
//            formObj.stv_dmg_req_cate_cd[1].disabled = true;
//            formObj.stv_dmg_req_cate_cd[2].disabled = true;
//            formObj.req_skd_voy_dir.readOnly = true;
//            formObj.req_skd_voy_dir.className = "input2";
//            formObj.req_port_cd.readOnly = true;
//            formObj.req_port_cd.className = "input2";
//            formObj.req_eta_dt.readOnly = true;
//            formObj.req_eta_dt.className = "input2";
//            formObj.stv_dmg_respb_pty_kwn_cd[0].disabled = true;
//            formObj.stv_dmg_respb_pty_kwn_cd[1].disabled = true;
//            formObj.stv_dmg_respb_desc_dtl.readOnly = true;
//            formObj.stv_dmg_respb_desc_dtl.className = "input2";
//            comboObjects[6].Enable = false;
//            comboObjects[8].Enable = false;
//            formObj.req_reason_desc.readOnly = true;
//            formObj.req_reason_desc.className = "input2";
//            formObj.res_reason_desc.readOnly = true;
//            formObj.res_reason_desc.className = "input2";
    	}
    	else{
			if(isNull(sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"))){
    			formObj.vsl_cd.readOnly = false;
                formObj.vsl_cd.className = "input1";
                formObj.skd_voy_no.readOnly = false;
                formObj.skd_voy_no.className = "input1";
                formObj.skd_dir_cd.readOnly = false;
                formObj.skd_dir_cd.className = "input1";
                formObj.input_vps_port_cd.readOnly = false;
                formObj.input_vps_port_cd.className = "input1";   
                formObj.input_vps_port_cd.className = "input1";                 
                comboObjects[0].Enable = true;
				comboObjects[1].Enable = true;
                comboObjects[2].Enable = true;
    		}
    		else{
    			formObj.vsl_cd.readOnly = true;
                formObj.vsl_cd.className = "input2";
                formObj.skd_voy_no.readOnly = true;
                formObj.skd_voy_no.className = "input2";
                formObj.skd_dir_cd.readOnly = true;
                formObj.skd_dir_cd.className = "input2";
                formObj.input_vps_port_cd.readOnly = true;
                formObj.input_vps_port_cd.className = "input2";               
                comboObjects[0].Enable = false;
                comboObjects[1].Enable = false;
                comboObjects[2].Enable = false;
    		}
//            formObj.stv_dmg_evnt_dt.readOnly = false;
//            formObj.stv_dmg_evnt_dt.className = "input1";
            
			formObj.stv_dmg_no_prefix.readOnly = false;
	    	formObj.stv_dmg_no_prefix.className = "input";
            formObj.stv_dmg_no_suffix.readOnly = false;
            formObj.stv_dmg_no_suffix.className = "input";
            
            formObj.clm_hndl_ofc_cd.readOnly = true;
            formObj.clm_hndl_ofc_cd.className = "input2";
//            comboObjects[2].Enable = true;
            comboObjects[4].Enable = true;
            formObj.stv_dmg_loc_desc.readOnly = false;
            formObj.stv_dmg_loc_desc.className = "input";
            ComBtnEnable("btn_SDR");
            ComBtnEnable("btn_Picture");
            ComBtnEnable("btn_Document");
            formObj.stv_dmg_rpt_atch_flg.className = "input";
            formObj.stv_dmg_pict_atch_flg.className = "input";
            formObj.stv_dmg_doc_atch_flg.className = "input";
            formObj.cntr_dmg_flg.disabled = false;
            formObj.cgo_dmg_flg.disabled = false;
            formObj.cntr_no.readOnly = false;
            formObj.cntr_no.className = "input";
            formObj.fm_tm_lss_dt.readOnly = false;
            formObj.fm_tm_lss_dt.className = "input";
            formObj.to_tm_lss_dt.readOnly = false;
            formObj.to_tm_lss_dt.className = "input";
            formObj.stv_dmg_rmk.readOnly = false;
            formObj.stv_dmg_rmk.className = "input";
            formObj.stv_dmg_req_cate_cd[0].disabled = false;
            formObj.stv_dmg_req_cate_cd[1].disabled = false;
            formObj.stv_dmg_req_cate_cd[2].disabled = false;
            formObj.req_skd_voy_dir.readOnly = false;
            formObj.req_skd_voy_dir.className = "input";
            formObj.req_port_cd.readOnly = false;
            formObj.req_port_cd.className = "input";
//            comboObjects[8].Enable = true;
            formObj.req_eta_dt.readOnly = false;
            formObj.req_eta_dt.className = "input";
//            formObj.stv_dmg_respb_pty_kwn_cd[0].disabled = false;
//            formObj.stv_dmg_respb_pty_kwn_cd[1].disabled = false;
            formObj.stv_dmg_respb_desc_dtl.readOnly = false;
            formObj.stv_dmg_respb_desc_dtl.className = "input1";
            
            var thisRow = sheetObj.SelectRow;
            var prefix = "sheet1_";
            
        	if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R"
        		|| sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S")
            {
            	formObj.req_skd_voy_dir.readOnly = false;
    			formObj.req_port_cd.readOnly = false;
    			formObj.req_eta_dt.readOnly = false;
            	formObj.req_skd_voy_dir.className = "input";
    			formObj.req_port_cd.className = "input";
    			formObj.req_eta_dt.className = "input";
//    			comboObjects[8].Enable = true;
    			comboObjects[6].Index2 = "";
    			comboObjects[6].Enable = false;
    			formObj.req_reason_desc.value = "";
    			formObj.req_reason_desc.readOnly = true;
    			formObj.req_reason_desc.className = "input2";
            }
            else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
            {
            	formObj.req_skd_voy_dir.value = "";
    			formObj.req_port_cd.value     = "";
    			formObj.req_eta_dt.value      = "";
    			formObj.req_skd_voy_dir.readOnly = true;
    			formObj.req_port_cd.readOnly = true;
    			formObj.req_eta_dt.readOnly = true;
            	formObj.req_skd_voy_dir.className = "input2";
    			formObj.req_port_cd.className = "input2";
    			formObj.req_eta_dt.className = "input2";
//    			comboObjects[8].Index2 = "";
//    			comboObjects[8].Enable = false;
    			comboObjects[6].Enable = true;
    			if(comboObjects[6].Code=="TXT"){
        			formObj.req_reason_desc.readOnly = false;
        			formObj.req_reason_desc.className = "input1";
    			}
            }
            formObj.req_skd_voy_dir.value 		= sheetObj.CellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.CellValue(thisRow, prefix+"req_skd_dir_cd");
            formObj.req_port_cd.value 			= sheetObj.CellValue(thisRow, prefix+"req_port_cd");
//            comboObjects[8].Code2 = sheetObj.CellValue(thisRow, prefix+"req_port_cd");
            formObj.req_eta_dt.value 			= sheetObj.CellValue(thisRow, prefix+"req_eta_dt");
            if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="U"){
            	formObj.stv_dmg_respb_desc_dtl.value = "";
    			formObj.stv_dmg_respb_desc_dtl.readOnly = true;
            	formObj.stv_dmg_respb_desc_dtl.className = "input2";
    			comboObjects[8].Enable = true;
    			if(comboObjects[8].Code=="TXT"){
        			formObj.res_reason_desc.readOnly = false;
        			formObj.res_reason_desc.className = "input1";
    			}
            }else{
            	formObj.stv_dmg_respb_desc_dtl.readOnly = false;
            	formObj.stv_dmg_respb_desc_dtl.className = "input";
    			comboObjects[8].Index2 = "";
    			comboObjects[8].Enable = false;
    			formObj.res_reason_desc.readOnly = true;
    			formObj.res_reason_desc.className = "input2";
            }
//			if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="Y"){
//            	formObj.stv_dmg_respb_desc_dtl.readOnly = false;
//            	formObj.stv_dmg_respb_desc_dtl.className = "input1";
//    			comboObjects[8].Index2 = "";
//    			comboObjects[8].Enable = false;
//    			formObj.res_reason_desc.readOnly = true;
//    			formObj.res_reason_desc.className = "input2";
//            }else{
//            	formObj.stv_dmg_respb_desc_dtl.value = "";
//    			formObj.stv_dmg_respb_desc_dtl.readOnly = true;
//            	formObj.stv_dmg_respb_desc_dtl.className = "input2";
//    			comboObjects[8].Enable = true;
//    			if(comboObjects[8].Code=="TXT"){
//        			formObj.res_reason_desc.readOnly = false;
//        			formObj.res_reason_desc.className = "input1";
//    			}
//            }

            //ComSetFocus(formObj.stv_dmg_ref_no);
    	}
    }
    
    /**
     * HTML Control의 onkeypress이벤트에서 영문숫자만 입력 처리한다. <br>
     **/
    function engnum_keypress() {
        
        if(event.srcElement.name=="skd_voy_no"
        	|| event.srcElement.name=="stv_dmg_no_suffix")
        {
        	//숫자만 입력가능.
        	ComKeyOnlyNumber(event.srcElement);
        }
        else if(//event.srcElement.name=="vsl_cd"|| 
        		event.srcElement.name=="skd_dir_cd"
        		|| event.srcElement.name=="stv_dmg_no_prefix"
        	    || event.srcElement.name=="clm_hndl_ofc_cd")
        	    //|| event.srcElement.name=="req_port_cd")
        {
        	//영대문자만 입력가능.
        	ComKeyOnlyAlphabet('upper');
        }
        else{
        	//영대문자 & 숫자만 입력가능.
            ComKeyOnlyAlphabet('uppernum');
        }
        
        if(event.keyCode==13 && (event.srcElement.name=="stv_dmg_no")){
        	blur_event();
        	ComKeyEnter();
        }
    }
    
    /**
     * 특정 Data의 Max Length 입력시, 포커스 이동. <br>
     **/
    function obj_keyup() {
       	// Focus 이동..
       	ComKeyEnter('LengthNextFocus');
    }

    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	ComKeyOnlyNumber(event.srcElement);
    }
    
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
    	if(event.srcElement.readOnly==false){
	        ComClearSeparator(event.srcElement);
	        event.srcElement.select();
    	}
    }
    
    /**
     * HTML Control의 onblur이벤트에서 Validation을 체크한다. <br>
     **/
    function obj_deactivate(){
    	
    	var elementObj = event.srcElement;
    	var formObj = document.form;
    	var prefix = "sheet1_";
    	
    	if(elementObj.readOnly==false){
    		
    		// 년월일 dataformat Validation Check!
        	if(!isNull(event.srcElement.value) 
        		&& !ComChkObjValid(event.srcElement))
        	{
        		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+elementObj.name) = "";
        		event.srcElement.value = "";
        		event.srcElement.focus();
        		//ComSetFocus(event.srcElement);
        		return false;
        	}
    		
        	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+elementObj.name) = elementObj.value;
        	
        	if(elementObj.name=="fm_tm_lss_dt" || elementObj.name=="to_tm_lss_dt"){
        		if(isNull(formObj.fm_tm_lss_dt.value) || isNull(formObj.to_tm_lss_dt.value)){
         			
        			formObj.time_loss_hours.value = "";
         		}
        		else{
            		formObj.time_loss_hours.value = getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
            	}
        	}
        	
    	}
    }
    
    /**
     * Text Form Object에 Focus지정시 블럭 설정. <br>
     **/
    function focus_event() {
    	var elementObj = event.srcElement;
    	//ComSetFocus(elementObj);
    	if(elementObj.readOnly == false){
    		elementObj.select();
    	}
    }
     
    /**
     * Data 입력시 Hidden Grid에 해당 Data Set. <br>
     **/
    function change_event() {
    	var elementObj = event.srcElement;
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	var prefix = "sheet1_";
    	
    	if(elementObj.name=="vsl_cd"){
    		var vVsl_cd = formObj.vsl_cd.value;
    		/* Vsl 유효성 check */
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"VSL|MAIN")){ /* VSL CODE가 유효하면 */    		
				//if( sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) == "" ){
	    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
				//}else{
	    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
				//}
	    		//sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
	    	
	    		formObj.vsl_cd.value = vVsl_cd;
//	    		alert(formObj.vsl_cd.value);
	    		formObj.skd_voy_no.value = "";
	    		formObj.skd_dir_cd.value = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_voy_no") = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = "";

				// Vessel Category 가져오기.
        		setVesselCategoryCode(formObj, sheetObj);
	    		
	    		formObj.skd_voy_no.focus();
    		} else {
        			doActionIBSheet(sheetObj,formObj,IBCLEAR);
        			ComShowCodeMessage("OPF50004", vVsl_cd);
        			return false;
        		}
    	}
    	else if(elementObj.name=="skd_voy_no"){
    		var vVsl_cd = formObj.vsl_cd.value;
    		var vSkd_voy_no = formObj.skd_voy_no.value;
    		var vVsl_oshp_cntr_blk_tp_cd = formObj.vsl_oshp_cntr_blk_tp_cd.value;
    		var vVsl_oshp_cntr_blk_tp_nm = formObj.vsl_oshp_cntr_blk_tp_nm.value;    		
    		
    		//if( sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) == "" ){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    		//}else{
    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
    		//}
    		//sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    		
    		formObj.vsl_cd.value = vVsl_cd;
    		formObj.skd_voy_no.value = vSkd_voy_no;
    		formObj.vsl_oshp_cntr_blk_tp_cd.value = vVsl_oshp_cntr_blk_tp_cd;
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_oshp_cntr_blk_tp_cd") = vVsl_oshp_cntr_blk_tp_cd;
    		formObj.vsl_oshp_cntr_blk_tp_nm.value = vVsl_oshp_cntr_blk_tp_nm;
    		
    		formObj.skd_dir_cd.value = "";
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = "";
    		
    		formObj.skd_dir_cd.focus();
    	}
    	else if(elementObj.name=="skd_dir_cd"){
    		/* VVD 유효성 check */
    		var vVsl_cd = formObj.vsl_cd.value;
    		var vSkd_voy_no = formObj.skd_voy_no.value;
    		var vSkd_dir_cd = formObj.skd_dir_cd.value;
    		var vVsl_oshp_cntr_blk_tp_cd = formObj.vsl_oshp_cntr_blk_tp_cd.value;
    		var vVsl_oshp_cntr_blk_tp_nm = formObj.vsl_oshp_cntr_blk_tp_nm.value;
    		
    		if (doActionIBSheet(sheetObj,formObj,COMMAND03)){ /* VSL CODE가 유효하면 */      		
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    			//doActionIBSheet(sheetObj,formObj,IBCLEAR);
    			
        		formObj.vsl_cd.value     = vVsl_cd;
        		formObj.skd_voy_no.value = vSkd_voy_no;
        		formObj.skd_dir_cd.value = vSkd_dir_cd;
        		formObj.vsl_oshp_cntr_blk_tp_cd.value = vVsl_oshp_cntr_blk_tp_cd;
        		formObj.vsl_oshp_cntr_blk_tp_nm.value = vVsl_oshp_cntr_blk_tp_nm;
        		
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"vsl_cd")     = vVsl_cd;
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_voy_no") = vSkd_voy_no;
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = vSkd_dir_cd;
        		
        		//LaneCode
				setLaneCode(formObj, sheetObj);				
				//SDMS No. Prefix setting
				formObj.stv_dmg_no_prefix.value = vVsl_cd;
				formObj.stv_dmg_no_prefix.readOnly = true;
				formObj.stv_dmg_no_prefix.className = "input2";
				
    		} /* end of vvd 유효성 */ 
    		else {
    			doActionIBSheet(sheetObj,formObj,IBCLEAR);
    			ComShowCodeMessage("OPF50004", vVsl_cd+vSkd_voy_no+vSkd_dir_cd);
    			return false;
    		}
    	}
    	else if(elementObj.name=="req_skd_voy_dir") {
    		comboObjects[5].RemoveAll();
  			document.all.item("comboReqPortCd").style.display = "none";
  			document.all.item("inputReqPortCd").style.display = "inline"; 
  			formObj.req_port_cd.value = "";
  			formObj.req_eta_dt.readOnly = false;
  			formObj.req_eta_dt.className = "input";
  			formObj.req_eta_dt.value = ""
  			
  			
    		if(!isNull(elementObj.value) && elementObj.value.length != elementObj.maxLength) {
		    	ComShowCodeMessage("OPF50007", elementObj.caption, elementObj.maxLength);
  				elementObj.focus();
  				return false;
  			} else if(isNull(elementObj.value)) {
		    	sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
	    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
	    		
		    } else {
		    	if (doActionIBSheet(sheetObj,formObj,COMMAND01,"VVD|SUB")){ /* VSL CODE가 유효하면 */  
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = elementObj.value.substring(0,4);
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = elementObj.value.substring(4);
		    		
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
		    		
//		    		formObj.req_port_cd.focus();
		    	} else {
		    		
	    			ComShowCodeMessage("OPF50004", formObj.vsl_cd.value+elementObj.value);
	    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
		    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
	    			formObj.req_skd_voy_dir.value = "";
		    		formObj.req_skd_voy_dir.focus();
	    			return false;		    		
		    	}
    		}
    		
    		//Requirement Port 조회하여 셋팅하기
    		doActionIBSheet(sheetObj,formObj,COMMAND05);
    		
    	}
    	else if (elementObj.name=="input_vps_port_cd"){ /* vps_port_cd */

    		var vpsPortCd = formObj.input_vps_port_cd.value ;
    		
//    		if(doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|MAIN")){
//    			sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd") = vpsPortCd;
//    			//ETB일자 Default
//    			if (gVpsEtbEtdDt.length > 0){
//    				var vpsEtbEtdDt = gVpsEtbEtdDt.split("|");
//    				for (var i=0; i<vpsEtbEtdDt.length; i++){
//    					vpsEtbEtdDt[i] = vpsEtbEtdDt[i].split(",");
//    				}
//    				formObj.stv_dmg_evnt_dt.value = vpsEtbEtdDt[0][0];
//    			}
//    			formObj.stv_dmg_evnt_dt.focus();
//    		} else {
//    			ComShowCodeMessage("OPF50004", vpsPortCd);
//    			formObj.vps_port_cd.value = "";
//	    		formObj.vps_port_cd.focus();
//    			
//    		}
			if(doActionIBSheet(sheetObj,formObj,COMMAND04)){
				sheetObj.CellValue(sheetObj.SelectRow, "sheet1_input_vps_port_cd") = vpsPortCd;
				
				//Claim Handling Office
				formObj.clm_hndl_ofc_cd.value = ofcCd;
				sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = ofcCd;
				
    			//Claim Handling User
   				if(ofcCd != ""){
   					sheetObjects[0].RowDelete(1, false);
   					sheetObjects[0].DataInsert(-1);
//   					sheetObjects[0].SelectCell(1, "clm_hndl_usr_nm");
   					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#CCFFFD");
   				}
				
				//ETB일자 Default
				if (gVpsEtbEtdDt.length > 0){
					comboObjects[1].RemoveAll();
					var dataList = gVpsEtbEtdDt.split("|");
					
					for (var i = 0 ; i < dataList.length ; i++) {					
						var comboItem = dataList[i+1].split(",");
						comboObjects[1].InsertItem(i, comboItem[1], comboItem[0]);
					}
				}
				formObj.stv_dmg_evnt_dt.focus();
			} else {
				var strPortCd = "";
				if(document.all.item("comboVpsPortCd").style.display == "inline"){
					strPortCd = comboObjects[0].Code;
				} else {
					strPortCd = formObj.input_vps_port_cd.value;
					formObj.clm_hndl_ofc_cd.value = "";
					sheetObjects[0].RemoveAll();
				}
				
				ComShowCodeMessage("OPF50004", strPortCd);	
				formObj.input_vps_port_cd.focus();
			}
			
    	}else if (elementObj.name == "stv_dmg_evnt_dt"){//damage date
    		var evntDt = ComReplaceStr(formObj.stv_dmg_evnt_dt.value,-'-','');
    		var bOK = true;
    		
    		if (gVpsEtbEtdDt.length > 0 && evntDt.length > 0){
				var vpsEtbEtdDt = gVpsEtbEtdDt.split("|");

				for (var i=0; i<vpsEtbEtdDt.length; i++){
					vpsEtbEtdDt[i] = vpsEtbEtdDt[i].split(",");
					if (ComChkPeriod(vpsEtbEtdDt[i][0], evntDt) >= 1 && ComChkPeriod(evntDt, vpsEtbEtdDt[i][1]) >= 1){
						bOK = true;
						break;
					}else{
						bOK = false;
					}    				
				}
    		}
    		
    		if (!bOK){
    			ComShowCodeMessage("OPF50027");
    			formObj.stv_dmg_evnt_dt.value = "";
    			formObj.stv_dmg_evnt_dt.focus();
    		}
    	}
    	else if (elementObj.name=="req_port_cd") {/* req_port_cd */
//    		alert("change_event : req_port_cd");
    		
    		if (doActionIBSheet(sheetObj,formObj,COMMAND01,"PORT|SUB")){
	         		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_port_cd") = elementObj.value;
	         	
	    			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
	        		// Request Port Code 입력시, DB에서 ETA Date 가져온다.
	    			doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "etaDate");
	        	
    		} else {
    			ComShowCodeMessage("OPF50004", elementObj.value);
    			elementObj.value ="";
    			document.form.req_port_cd.focus();
    		}
    	}   	
    	else if(elementObj.name=="stv_dmg_respb_desc_dtl")
    	{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_respb_desc")
    	{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_rpt_atch_flg"
    			|| elementObj.name=="stv_dmg_pict_atch_flg"
    			|| elementObj.name=="stv_dmg_doc_atch_flg")
    	{
    		if(elementObj.value > 0){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "Y";
    		}else{
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "N";
    		}
    	}
    	else if(elementObj.name=="req_reason_desc"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_rsn_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="res_reason_desc"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_desc") = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_no"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no") = elementObj.value;
//    		if(elementObj.value.length==11){
//    			ComBtnEnable("btn_Retrieve");
//    		}
    	}
    	else if(elementObj.name=="stv_dmg_no_prefix"){
    		if(formObj.stv_dmg_no_suffix.value != ""){
    			if(elementObj.value == ""){
	    			formObj.stv_dmg_no.value = "";
	    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_no") = ""
    			}else{
	    			formObj.stv_dmg_no.value = elementObj.value + formObj.stv_dmg_no_suffix.value;
	    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_no") = formObj.stv_dmg_no.value;
    			}
    		}
    	}
    	else if(elementObj.name=="stv_dmg_no_suffix"){
    		if(formObj.stv_dmg_no_prefix.value != ""){
    			if(elementObj.value == ""){
    				formObj.stv_dmg_no.value = "";
    				sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_no") = "";
    				sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = "";
    			}else{
	    			formObj.stv_dmg_no.value = formObj.stv_dmg_no_prefix.value + elementObj.value;
	    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_no") = formObj.stv_dmg_no.value;
    			}
    		}
    	}
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    }
    
    /**
     * Radio Button 클릭시 입력가능 필드 변경 및 Hidden Grid에 해당 Data Set. <br>
     **/
    function click_event() {
    	var formObj = document.form;
    	var elementObj = event.srcElement;
    	var prefix = "sheet1_";
    	
    	if(elementObj.name=="cntr_dmg_flg"
			|| elementObj.name=="cgo_dmg_flg")
    	{
    		var dataValue = "N";

        	if(elementObj.checked){
        		dataValue = "Y";
        	}
        	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+elementObj.name) = dataValue;
    	}
    	else if(elementObj.name=="stv_dmg_req_cate_cd"){
//    		alert("click_event:stv_dmg_req_cate_cd:"+elementObj.value);
    		if(elementObj.value=="Q"){
    			formObj.req_skd_voy_dir.value = "";
    			formObj.req_port_cd.value = "";
    			formObj.req_eta_dt.value = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_vsl_cd") = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_voy_no") = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_dir_cd") = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_port_cd") = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_eta_dt") = "";
    			formObj.req_skd_voy_dir.readOnly = true;
    			formObj.req_port_cd.readOnly = true;
    			formObj.req_eta_dt.readOnly = true;
    			formObj.req_skd_voy_dir.className = "input2";
        		formObj.req_port_cd.className = "input2";
        		formObj.req_eta_dt.className = "input2";
//        		comboObjects[8].RemoveAll();
//        		comboObjects[8].Enable = false;
    			comboObjects[6].Enable = true;
    			if(comboObjects[6].Code=="TXT"){
    				formObj.req_reason_desc.readOnly = false;
        			formObj.req_reason_desc.className = "input1";
    			}
    		}else{
    			formObj.req_skd_voy_dir.readOnly = false;
    			formObj.req_port_cd.readOnly = false;
    			formObj.req_eta_dt.readOnly = false;
        		formObj.req_skd_voy_dir.className = "input";
        		formObj.req_port_cd.className = "input";
        		formObj.req_eta_dt.className = "input";
//        		comboObjects[8].Enable = true;
        		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
    			formObj.stv_dmg_qttn_rsn_desc.value = "";
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"stv_dmg_qttn_rsn_desc") = "";
    			comboObjects[6].Index = "";
    			comboObjects[6].Enable = false;
    			formObj.req_reason_desc.readOnly = true;
    			formObj.req_reason_desc.className = "input2";
    		}
    		// 화면에 입력한 Data를 Grid에 Set!
        	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    	else if(elementObj.name=="stv_dmg_respb_pty_kwn_cd"){
//    		if(elementObj.value=="Y"){
//    			formObj.stv_dmg_respb_desc_dtl.readOnly = false;
//    			formObj.stv_dmg_respb_desc_dtl.className = "input1";
//    			formObj.stv_dmg_respb_desc.value = "";
//    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"stv_dmg_respb_desc") = "";
//    			comboObjects[8].Index = "";
//    			comboObjects[8].Enable = false;
//    			formObj.res_reason_desc.readOnly = true;
//    			formObj.res_reason_desc.className = "input2";
//    			
//        		formObj.dmg_auth_sts_cd.className = "input2";
//				document.getElementById("btnApproval").style.color="#c0c0c0";
//				
//    			formObj.dmg_auth_sts_cd.value = "X";
//    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"dmg_auth_sts_cd") = "X";
//    			
//    			ComBtnDisable("btn_Approval");
//    		}
//    		else{
//    			formObj.stv_dmg_respb_desc_dtl.value = "";
//    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"stv_dmg_respb_desc") = "";
//    			formObj.stv_dmg_respb_desc_dtl.readOnly = true;
//    			formObj.stv_dmg_respb_desc_dtl.className = "input2";
//    			comboObjects[8].Enable = true;
//    			if(comboObjects[8].Code=="TXT"){
//    				formObj.res_reason_desc.readOnly = false;
//        			formObj.res_reason_desc.className = "input1";
//    			}
//    			
//        		formObj.dmg_auth_sts_cd.className = "input2_red";
//				document.getElementById("btnApproval").style.color="red";
//				
//    			formObj.dmg_auth_sts_cd.value = "N";
//				sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"dmg_auth_sts_cd") = "N";
//				if(approvalFlag){
//    				ComBtnEnable("btn_Approval");
//    			}
//				else{
//					ComBtnDisable("btn_Approval");
//				}
//    		}
//    		// 화면에 입력한 Data를 Grid에 Set!
//        	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+elementObj.name) = elementObj.value;
    	}
    }
    
    /**
     * 마우스가 Sheet 위에서 움직일 때 발생하는 Event function <br>
     * Sheet의 어떤 영역이든 마우스가 이동 중일 때 Event가 발생한다.<br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {Integer} Button 필수 마우스버튼 방향, 1:왼쪽, 2:오른쪽
     * @param {Integer} Shift 필수 Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
     * @param {Long} X 필수 X 좌표
     * @param {Long} Y 필수 Y 좌표
     * @return 없음
     * @version 2011.10.06
     */
	function sheet0_OnMouseMove(sheetObj, Button, Shift, X, Y)  {
		var Row = sheetObj.MouseRow;
		var Col = sheetObj.MouseCol;
		if(Row == 1 && Col == 1) {
			sheetObj.ToolTipText(Row, Col) = sheetObj.CellText(Row, "clm_hndl_usr_nm");
		}
	}
    
    function sheet0_OnPopupClick(sheetObj, Row, Col, Value) {
 	    var formObj = document.form;
 	    
		var ofc_cd = formObj.clm_hndl_ofc_cd.value;
    	var usr_id = sheetObj.CellValue(Row, "clm_hndl_usr_id");
		var sUrl = "/hanjin/VOP_OPF_9052.do?ofc_cd=" + ofc_cd + "&usr_id=" + usr_id;
		var rtnVal = ComOpenPopup(sUrl, 1000, 500, "", "0,0", true);
		if(rtnVal == "O"){
			//2011.11.09 Claim Handling Office 자리수 validation 제거 (우선 쿼리에서 잘라서 insert)
//            //Groupware 의 Office Code 중 6자리보다 클 경우 제외하고 저장한다 
//        	for(var i=0 ; i<sheetObjects[5].RowCount ; i++){
//        		if(sheetObjects[5].CellValue(i, "sheet20_clm_hndl_ofc_cd").length > 6){
//        			sheetObjects[5].RowDelete(i, false);
//        		}
//        	}
			setClaimHandlingUser(sheetObj);
		}//420
    }
     
    /**
     * vsl_oshp_cntr_blk_tp_cd Combo Data 선택시 Hidden Grid에 해당 Data Set. <br>
     **/
    function vsl_oshp_cntr_blk_tp_cd_OnChange(comboObj, idx_cd, text) {
  
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_vsl_oshp_cntr_blk_tp_cd") = comboObj.Code;
    }
     
    /**
     * req_port_cd Combo Data 선택시 ETA Date 가져온다. <br>
     **/
    function req_port_cd_OnChange(comboObj, idx_cd, text) {

     	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_port_cd") = comboObj.Code;
     	
    	if(!isNull(comboObj.Code)){
			//doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "reqPortCd");
    		// Request Port Code 입력시, DB에서 ETA Date 가져온다.
			doActionIBSheet(sheetObjects[1], document.form, IBROWSEARCH, "etaDate");
		}
    	document.form.req_port_cd.focus();
    }
    
    /**
     * vps_port_cd Combo Data 선택시 Hidden Grid에 해당 Data Set. <br>
     **/
    function combo_vps_port_cd_OnChange(comboObj, idx_cd, text) {
		var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	if(!isNull(comboObjects[0].Code)){
    		if(doActionIBSheet(sheetObj,formObj,COMMAND04)){
    			
    			//Claim Handling Office
    			formObj.clm_hndl_ofc_cd.value = ofcCd;
    			sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = ofcCd;
    			
    			//Claim Handling User
   				if(ofcCd != ""){
   					sheetObjects[0].RowDelete(1, false);
   					sheetObjects[0].DataInsert(-1);
//   					sheetObjects[0].SelectCell(1, "clm_hndl_usr_nm");
   					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#CCFFFD");
   				}
    			
    			//ETB일자 Default
    			if (gVpsEtbEtdDt.length > 0){
    				comboObjects[1].RemoveAll();
    				var dataList = gVpsEtbEtdDt.split("|");
    				
    				for (var i = 0 ; i < dataList.length ; i++) {					
    					if(i != 0){
    						var comboItem = dataList[i].split(",");
    						var dateFormTxt = comboItem[1].substring(0,4)+"-"+comboItem[1].substring(4,6)+"-"+comboItem[1].substring(6,8);
    						comboObjects[1].InsertItem(i-1, dateFormTxt, comboItem[0]);
    					}					
    				}
    			}
    			formObj.stv_dmg_evnt_dt.focus();
    		} else {
    			//ComShowCodeMessage("OPF50004", comboObj.Code);			
    		}
		}    	
    }
    
    function stv_dmg_evnt_dt_OnBlur(comboObj){
    	if(comboObj.Style == 0){
    		var dmgDt = comboObj.Text;
    		
    		if(dmgDt == null || dmgDt == "" || dmgDt == undefined) {
    			return false;
    		}
    		if (ComIsDate(dmgDt)) {
    			var dmgDtCode = dmgDt.replace(/\-/g, "");
    			var dmgDtText = dmgDtCode.substring(0,4) + "-" + dmgDtCode.substring(4,6) + "-" + dmgDtCode.substring(6,8);
    			
    			gVpsEtbEtdDt = dmgDtText;
    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_stv_dmg_evnt_dt") = dmgDtText;
    			
    	    	comboObj.RemoveAll();
    	    	comboObj.InsertItem(0, dmgDtText, dmgDtCode);
    	    	comboObj.index2 = 0;
    		} else {
    			ComShowCodeMessage("COM12134", "Damage Date");
    			comboObj.RemoveAll();
    			document.form.stv_dmg_evnt_dt.focus();
    			return false;
    		}
	    	
    	}
    }

	function stv_dmg_respb_pty_kwn_cd_OnChange(comboObj, idx_cd, text) {
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
    	var prefix = "sheet1_";
		sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_pty_kwn_cd") = comboObj.Code;
		
        if(comboObj.Code == "U"){
        	formObj.stv_dmg_respb_desc_dtl.value = "";
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = "";
			formObj.stv_dmg_respb_desc_dtl.readOnly = true;
			formObj.stv_dmg_respb_desc_dtl.className = "input2";
			comboObjects[8].Enable = true;
		
			if(comboObjects[8].Code=="TXT"){
				formObj.res_reason_desc.readOnly = false;
				formObj.res_reason_desc.className = "input1";
			}
			
			formObj.dmg_auth_sts_cd.className = "input2_red";
			document.getElementById("btnApproval").style.color="red";
			
			formObj.dmg_auth_sts_cd.value = "N";
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd") = "N";
			if(approvalFlag){
				ComBtnEnable("btn_Approval");
			}
			else{
				ComBtnDisable("btn_Approval");
			}
			
			//2011.11.10 UnKnown 일 경우 처리
			setResponsiblePartyBehind("OnChange", true);
        }else{
        	formObj.stv_dmg_respb_desc_dtl.readOnly = false;
			formObj.stv_dmg_respb_desc_dtl.className = "input";
			formObj.stv_dmg_respb_desc.value = "";
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = "";
			comboObjects[8].Index = "";
			comboObjects[8].Enable = false;
			formObj.res_reason_desc.readOnly = true;
			formObj.res_reason_desc.className = "input2";
			
			formObj.dmg_auth_sts_cd.className = "input2";
			document.getElementById("btnApproval").style.color="#c0c0c0";
			
			formObj.dmg_auth_sts_cd.value = "X";
			sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd") = "X";
			
			ComBtnDisable("btn_Approval");        	
			
			//2011.11.10 UnKnown 이 아닐 경우 처리
			setResponsiblePartyBehind("OnChange", false);
        }
        
    }
	
	/* Responsible Party 값에 따른 Claim Handling Office, Claim Handling User 후속 작업
	 * 
	 */
	function setResponsiblePartyBehind(event, flg) {
		var formObj = document.form;
		var sheetObj = sheetObjects[1];
//		alert("event:"+event+"flg:"+flg);
		switch(event) {
			case "Search":
				if(flg) {
					sheetObjects[0].Editable = false;
					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#F3F2F8");//E9E9E9
				}else {
					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#CCFFFD");
				}

				break;
			case "OnChange":
				sheetObjects[0].Editable = true;
				if(flg) {
					formObj.clm_hndl_ofc_cd.value = "";
					sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
					sheetObjects[0].RemoveAll();
					sheetObjects[5].RemoveAll();
//					sheetObjects[6].RemoveAll();
					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#F3F2F8");
				}else {
					if(doActionIBSheet(sheetObj,formObj,COMMAND04)){
						//Claim Handling Office
						formObj.clm_hndl_ofc_cd.value = ofcCd;
						sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = ofcCd;
						//Claim Handling User
		   				if(formObj.clm_hndl_ofc_cd.value != "" && unKnownFlg){
		   					sheetObjects[0].RowDelete(1, false);
		   					sheetObjects[0].DataInsert(-1);
		   					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#CCFFFD");
		   				}
					}
				}
				break;
		}
		unKnownFlg = flg;
	}
     
    /**
     * Category Combo Data 선택시 Part Combo List에 해당 Data Set. <br>
     **/
    function stv_dmg_prt_cate_cd_OnChange(comboObj, idx_cd, text) {

    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_prt_cate_cd") = comboObj.Code;
    	
    	if(!isNull(comboObj.Code)){

	    	// 선택된 Category에 해당하는 Part Code 가져오기.
	    	formObj.f_cmd.value = SEARCH03;
	    	var categoryPartXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
	    	var categoryPart = ComGetEtcData(categoryPartXml, "catePart");
	    	
	    	if(categoryPart==null || categoryPart.length<1){
	    		//ComShowMessage("Part Code not exist.");
    			ComShowCodeMessage("OPF50009", "Part Code");
	    		comboObjects[3].RemoveAll();
	    		return false;
	    	}else{
	    		setComboItem2(comboObjects[3], categoryPart);
	    		formObj.stv_dmg_prt_cate_cd.focus();
	    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
	    	}
    	}else{
    		comboObjects[3].RemoveAll();
    		formObj.stv_dmg_prt_cate_cd.focus();
    		//ComSetFocus(formObj.stv_dmg_prt_cate_cd);
    	}
		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_prt_cd") = "";
		comboObjects[3].Enable = true;
    }
    
    /**
     * Part Combo Data 선택시 Damage Combo List에 해당 Data Set. <br>
     **/
    function stv_dmg_prt_cd_OnBlur(comboObj, idx_cd, text) {
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_stv_dmg_prt_cd") = comboObj.Code;
    }
     
    /**
     * Damage Combo Data 선택시 Hidden Grid에 해당 Data Set. <br>
     **/
    function stv_dmg_tp_cd_OnChange(comboObj, idx_cd, text) {
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_stv_dmg_tp_cd") = comboObj.Code;
    	document.form.stv_dmg_tp_cd.focus();
    	//ComSetFocus(document.form.stv_dmg_tp_cd);
    }
    
    /**
     * Combo Data 선택시 Hidden Grid 에 해당 Data Set. <br>
     **/
    function stv_dmg_qttn_rsn_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_cd") = comboObj.GetText(comboObj.Code, 0);
    	
    	if(comboObj.Code=="TXT"){
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_rsn_desc") = "";
    		formObj.req_reason_desc.value = "";
    		formObj.req_reason_desc.className = "input1";
    		formObj.req_reason_desc.readOnly = false;
    		formObj.req_reason_desc.focus();
    	}
    	else{
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_qttn_rsn_desc") = comboObj.GetText(comboObj.Code, 1);
    		formObj.req_reason_desc.value = comboObj.GetText(comboObj.Code, 1);
    		formObj.req_reason_desc.className = "input2";
    		formObj.req_reason_desc.readOnly = true;
        	formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    }
    
    /**
     * Combo Data 선택시 Hidden Grid 에 해당 Data Set. <br>
     **/
    function stv_dmg_respb_desc_OnChange(comboObj, idx_cd, text) {
    	var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
    	//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_cate_cd") = comboObj.GetText(comboObj.Code, 0);
    	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_cd") = comboObj.GetText(comboObj.Code, 0);
    	
    	if(comboObj.Code=="TXT"){
        	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_desc") = "";
    		formObj.res_reason_desc.value = "";
    		formObj.res_reason_desc.className = "input1";
    		formObj.res_reason_desc.readOnly = false;
    		formObj.res_reason_desc.focus();
    	}
    	else{
        	sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_desc") = comboObj.GetText(comboObj.Code, 1);
    		formObj.res_reason_desc.value = comboObj.GetText(comboObj.Code, 1);
    		formObj.res_reason_desc.className = "input2";
    		formObj.res_reason_desc.readOnly = true;
        	formObj.stv_dmg_respb_desc.focus();
    	}
    }
    
    function combo_req_port_cd_OnChange(comboObj, idx_cd, text) {
    	var formObj = document.form;
    	
    	formObj.req_port_cd.value = comboObj.Code;
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_port_cd") = formObj.req_port_cd.value;
    	formObj.req_eta_dt.value = comboObj.GetIndexText(comboObj.Index, 2);
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_eta_dt") = formObj.req_eta_dt.value;
    }
    
    /**
     * Data 입력시 Hidden Grid에 해당 Data Set. <br>
     **/
    function blur_event() {
    	var formObj = document.form;
    	var sheetObj = sheetObjects[1];
    	
    	var elementObj = event.srcElement;
    	var prefix = "sheet1_";
    	
    	if(elementObj.readOnly==false){
//        		formObj.stv_dmg_no.value = sdms01 + sdms02;
        		if(elementObj.name=="stv_dmg_no"){
        			//ComSetFocus(formObj.stv_dmg_ref_no);
        		}
        	else if(elementObj.name=="clm_hndl_ofc_cd"){
   				sheetObj.CellValue(sheetObj.SelectRow, prefix+elementObj.name) = elementObj.value;
        	}
        	else if(elementObj.name=="input_vps_port_cd"){
        		formObj.stv_dmg_evnt_dt.focus();
        	}
        	
        	elementObj.value = elementObj.value;
    	}
    	
    }
    
//    /**
//     * Claim Handling Office User Setting. <br>
//     **/
//    function clm_hndl_usr_id_pop_event(aryPopupData) {
//    	alert(aryPopupData[0][2]+":"+aryPopupData[0][3]+":::"+aryPopupData[1][2]+":"+aryPopupData[1][3]);
////    	sheet0.CellValue();
////    	document.form.clm_hndl_ofc_cd.value = aryPopupData[0][3];
////    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_clm_hndl_ofc_cd") = aryPopupData[0][3];
//    }
    
    /**
     * Popup Data Validation Check. <br>
     **/
    function clm_hndl_ofc_cd_pop_event(aryPopupData) {
    	document.form.clm_hndl_ofc_cd.value = aryPopupData[0][3];
    	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_clm_hndl_ofc_cd") = aryPopupData[0][3];
    }
    
    /**
  	 * VSL Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} rtnObjs
  	 */
  	function setCallBackVSL(aryPopupData) {
  		
		document.form.vsl_cd.value = aryPopupData[0][1];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_vsl_cd") = aryPopupData[0][1];
		document.form.skd_voy_no.focus();
		//ComSetFocus(document.form.skd_voy_no);

		// Vessel Category 가져오기.
		setVesselCategoryCode(document.form, sheetObjects[1]);
  	} 
  	
    /**
  	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
  	 * @param {arry} obj
  	 */
  	function setCallBackVVD(aryPopupData) {
		document.form.skd_voy_no.value = aryPopupData[0][2];
		document.form.skd_dir_cd.value = aryPopupData[0][3];
		
		// 2010.09.29 최윤성 [CHM-201006257-01] VVD 팝업 선택시 Lane 값 세팅
		document.form.slan_cd.value    = aryPopupData[0][5];
		
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_vsl_cd") = aryPopupData[0][1];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_skd_voy_no") = aryPopupData[0][2];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_skd_dir_cd") = aryPopupData[0][3];
		
		//SDMS No. Prefix setting
		document.form.stv_dmg_no_prefix.value = document.form.vsl_cd.value;
		document.form.stv_dmg_no_prefix.readOnly = true;
		document.form.stv_dmg_no_prefix.className = "input2";
		if(document.form.vsl_cd.value == ""){
			document.form.stv_dmg_no.value = "";
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_stv_dmg_no") = "";
		}

//		document.form.vps_port_cd.focus();
		//ComSetFocus(document.form.vps_port_cd);
		
		//VVD Direction Code 입력시 VVD Port Code Combo Data 가져온다.
//		setVVDPortCombo(sheetObjects[1], document.form, "Vsl", true);
		//portCombo 가져오기
		doActionIBSheet(sheetObjects[1], document.form, COMMAND03);
  	}
  	 
  	/**
   	 * VVD Code Help (Pop-Up)에서 받은 데이타 세팅.<br>
   	 * @param {arry} obj
   	 */
   	function req_skd_voy_dir_pop_event(aryPopupData) {
 		document.form.req_skd_voy_dir.value = aryPopupData[0][2]+aryPopupData[0][3];
 		
 		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_vsl_cd") = aryPopupData[0][1];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_skd_voy_no") = aryPopupData[0][2];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_skd_dir_cd") = aryPopupData[0][3];
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_port_cd") = "";
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_req_eta_dt") = "";
		
		var sheetObj = sheetObjects[1];
    	var formObj = document.form;
    	
		comboObjects[5].RemoveAll();
		document.all.item("comboReqPortCd").style.display = "none";
		document.all.item("inputReqPortCd").style.display = "inline"; 
		formObj.req_port_cd.value = "";
		formObj.req_eta_dt.readOnly = false;
		formObj.req_eta_dt.className = "input";
		formObj.req_eta_dt.value = ""
		
		//Requirement Port 조회하여 셋팅하기
		doActionIBSheet(sheetObj,formObj,COMMAND05);
		
// 		document.form.req_port_cd.focus();
 		//ComSetFocus(document.form.req_port_cd);
 		//Voyage Dir Code 입력시 req Port Code Combo Data 가져온다.
//		setVVDPortCombo(sheetObjects[1], document.form, "Voy", true);
   	}
  	
  	/**
     * VVD 정보 조회
     */
    function searchVVDInfo() {
    	var formObj = document.form;
    	
    	formObj.f_cmd.value = SEARCH05;
 	   	var sXml = sheetObjects[1].GetSearchXml("SCG_COM_EXTERNALGS.do", FormQueryString(formObj)); 	   	
 	    
    }
    
    /**
	 * 팝업 IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다.
	 * File Upload..
	 **/
	function setFileUpload(popSheetObj, stvDmgAtchFileTpCd, stvDmgProcCd) {
		
		var formObj = document.form;
		var uploadObj = uploadObjects[0];
		var sheetObj;
		var prefix;
		var stvDmgAtchFlg= "";
		
		if(stvDmgAtchFileTpCd == "SDR"){
			sheetObj = sheetObjects[2];
			prefix ="sheet2_";
			stvDmgAtchFlg = "stv_dmg_rpt_atch";
		}else if(stvDmgAtchFileTpCd == "PIC"){
			sheetObj  = sheetObjects[3];
			prefix="sheet3_";
			stvDmgAtchFlg = "stv_dmg_pict_atch";
		}else if(stvDmgAtchFileTpCd == "DOC"){
			sheetObj  = sheetObjects[4];
			prefix="sheet4_";
			stvDmgAtchFlg = "stv_dmg_doc_atch";
		}
		
		
		//stv_dmg_no 같은 코드 삭제
		if(popSheetObj.RowCount > 0 ){
			if(sheetObj.RowCount > 0){
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++ ){
					if(sheetObj.CellValue(i, prefix+"stv_dmg_no") == popSheetObj.CellValue(1, "stv_dmg_no")){
						sheetObj.RowDelete(i, false);
					}
				}
			}
			//받아온 데이타 삽입
			for(var j=popSheetObj.HeaderRows; j<=popSheetObj.LastRow; j++ ){
				var addRow = sheetObj.DataInsert(-1);
				for(var cnt=0 ; cnt < 12 ; cnt++){
					sheetObj.CellValue(addRow, cnt) = popSheetObj.CellValue(j, cnt);
				}
			}
		}
		
		var file_cnt = 0;
		for (var rowIdx=1; rowIdx<=popSheetObj.LastRow; rowIdx++){ 
			
			var delFlag   = popSheetObj.CellValue(rowIdx, "deleteFlag");
			var ibFlag    = popSheetObj.RowStatus(rowIdx);

			//파일 경로 가져오기
			var sFile = popSheetObj.CellValue(rowIdx, "file_sav_id");
			if (sFile==""){
    			ComShowCodeMessage("OPF50009", "File name");
    		}

			if(delFlag == 'Y'){
				with(sheetObj){
		    		if(RowStatus(rowIdx)=="I"){
		    			var sFile = CellValue(rowIdx, "file_sav_id");
		        		uploadObjects[0].DeleteFile(sFile);
		        		
		    			RowStatus(rowIdx) = "D";
		    		}
		    		else{
		    			if(RowStatus(rowIdx)=="U"){
		    				var sFile = CellValue(rowIdx, "file_sav_id");
		            		uploadObjects[0].DeleteFile(sFile);
		    			}
		    			RowStatus(rowIdx) = "D";
		    		}
		    	}
			}
			else{
				if(ibFlag=='I' || ibFlag=='U'){
					//IBUpload에 파일 추가하기
					var ret = uploadObj.AddFile(sFile);
				}
				file_cnt++;
			}
		}
		// 파일 갯수 셋팅
		//formObj.stv_dmg_rpt_atch_flg.value = file_cnt;
		eval("formObj."+stvDmgAtchFlg+"_flg").value = file_cnt;
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_"+stvDmgAtchFlg+"_knt") = file_cnt;

		if(file_cnt > 0){
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"sheet1_"+stvDmgAtchFlg+"_flg") = "Y";
		}else{
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_"+stvDmgAtchFlg+"_flg") = "N";
		}
		
		// Filed Style Set.
		if(file_cnt > 0){
			eval("formObj."+stvDmgAtchFlg+"_flg").className = "input3"
    	}else{
    		eval("formObj."+stvDmgAtchFlg+"_flg").className = "input"
    	}
	
		return; 
	}
	
    /**
	 * 팝업 IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다.
	 * SDR File Upload..
	 **/
	function setFileUpload_1(popSheetObj) {
		var formObj = document.form;
		var sheetObj  = sheetObjects[2];
		var uploadObj = uploadObjects[0];
		var prefix="sheet2_";
		
		//stv_dmg_no 같은 코드 삭제
		if(popSheetObj.RowCount > 0 ){
			if(sheetObj.RowCount > 0){
				for(var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++ ){
					if(sheetObj.CellValue(i, prefix+"stv_dmg_no") == popSheetObj.CellValue(1, "stv_dmg_no")){
						sheetObj.RowDelete(i, false);
					}
				}
			}
			//받아온 데이타 삽입
			for(var j=popSheetObj.HeaderRows; j<=popSheetObj.LastRow; j++ ){
				var addRow = sheetObj.DataInsert(-1);
				for(var cnt=0 ; cnt < 12 ; cnt++){
					sheetObj.CellValue(addRow, cnt) = popSheetObj.CellValue(j, cnt);
				}
			}
		}
		
		var file_cnt = 0;
		for (var rowIdx=1; rowIdx<=popSheetObj.LastRow; rowIdx++){ 
			
			var delFlag   = popSheetObj.CellValue(rowIdx, "deleteFlag");
			var ibFlag    = popSheetObj.RowStatus(rowIdx);

			//파일 경로 가져오기
			var sFile = popSheetObj.CellValue(rowIdx, "file_nm");
			if (sFile==""){
    			ComShowCodeMessage("OPF50009", "File name");
    		}

			if(delFlag == 'Y'){
				with(sheetObj){
		    		if(RowStatus(rowIdx)=="I"){
		    			var sFile = CellValue(rowIdx, "file_nm");
		        		uploadObjects[0].DeleteFile(sFile);
		        		
		    			RowStatus(rowIdx) = "D";
		    		}
		    		else{
		    			if(RowStatus(rowIdx)=="U"){
		    				var sFile = CellValue(rowIdx, "file_nm");
		            		uploadObjects[0].DeleteFile(sFile);
		    			}
		    			RowStatus(rowIdx) = "D";
		    		}
		    	}
			}
			else{
				if(ibFlag=='I' || ibFlag=='U'){
					//IBUpload에 파일 추가하기
					var ret = uploadObj.AddFile(sFile);
				}
				file_cnt++;
			}
		}
		// 파일 갯수 셋팅
		formObj.stv_dmg_rpt_atch_flg.value = file_cnt;
		sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_sdr_cnt") = file_cnt;

		if(file_cnt > 0){
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow,"sheet1_stv_dmg_rpt_atch_flg") = "Y";
		}else{
			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet1_stv_dmg_rpt_atch_flg") = "N";
		}
		
		// Filed Style Set.
		if(file_cnt > 0){
    		formObj.stv_dmg_rpt_atch_flg.className = "input3"
    	}else{
    		formObj.stv_dmg_rpt_atch_flg.className = "input"
    	}
	
		return; 
	}
	
	/**
	 * 업로드용 Hidden IBSheet의 정보를 가져온다.
	 **/
	function getFileUpload(strFlag, stvDmgProcCd) {
		
		if(strFlag=="SDR"){
			return sheetObjects[2];
		}
		else if(strFlag=="PIC"){
			return sheetObjects[3];
		}
		else if(strFlag=="DOC"){
			return sheetObjects[4];
		}
	}
    
	/**
     * VVD Code Data 입력시 Lane Code Set. <br>
     **/
    function setLaneCode(formObj, sheetObj) {
		formObj.f_cmd.value = SEARCH02;
    	var laneXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	var strLaneCode = ComGetEtcData(laneXml, "laneCode");
    	if(isNull(strLaneCode)){
    		//ComShowMessage("해당 VVD CD의 Lane이 존재하지 않습니다.");
			//ComShowCodeMessage("OPF07004");
    		formObj.slan_cd.value = "";
    		//formObj.slan_cd.focus();
    		//ComSetFocus(formObj.vps_port_cd);
    		return true;
    	}else{
    		formObj.slan_cd.value = strLaneCode;
    		//sheetObj.CellValue(sheetObj.SelectRow, "sheet1_slan_cd") = strLaneCode;
    		//formObj.vps_port_cd.focus();
    	}    	
    }

	/**
     * Vessel Code Data 입력시 Vessel Category Code Set. <br>
     **/
    function setVesselCategoryCode(formObj, sheetObj) {
    	formObj.f_cmd.value = SEARCH10;
    	var vslCategoryXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	var strVslCategoryCd = ComGetEtcData(vslCategoryXml, "vslCategoryCd");
    	var strVslCategoryNm = ComGetEtcData(vslCategoryXml, "vslCategoryNm");
		
		if(isNull(strVslCategoryCd)){    	
			formObj.vsl_oshp_cntr_blk_tp_cd.value = "";
			formObj.vsl_oshp_cntr_blk_tp_nm.value = "";
    		formObj.vsl_oshp_cntr_blk_tp_cd.focus();
    		return true;
    	}else{
    		formObj.vsl_oshp_cntr_blk_tp_cd.value = strVslCategoryCd;
    		sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vsl_oshp_cntr_blk_tp_cd") = strVslCategoryCd;
    		formObj.vsl_oshp_cntr_blk_tp_nm.value = strVslCategoryNm;
    	}
    }
	
    /**
     * VVD Code Data 입력시 VVD Port Combo Data Set. <br>
     **/
    function setVVDPortCombo(sheetObj, formObj, gubun, isUpdate) {
    	//Combo 데이터 초기화.
    	var prefix = "sheet1_";
    	var comboObj = null;
    	if(gubun=="Vsl"){
    		comboObj = comboObjects[0];
    		//formObj.slan_cd.value = "";    		
    	}
    	else if(gubun=="Voy"){
    		comboObj = comboObjects[6];
    	}
    	
    	//Combo 데이터 조회.
    	formObj.f_cmd.value = SEARCH01;
    	var portXml = null;
    	if(gubun=="Vsl"){
			portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq" , FormQueryString(formObj));
    	}
    	else if(gubun=="Voy"){
    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
    		portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
    	}
    	var strPortCdList = ComGetEtcData(portXml, "vvdPortComboList");

		if(strPortCdList != ""){
			document.all.item("comboVpsPortCd").style.display = "inline";
   			document.all.item("inputVpsPortCd").style.display = "none";
			if(gubun=="Vsl"){
				if(isUpdate){
					comboObj.Index = "-1";
					sheetObj.CellValue(sheetObj.SelectRow, prefix+"vps_port_cd") = "";
				}    		
			}
			else if(gubun=="Voy"){
				if(isUpdate){
					comboObj.Index = "-1";
					sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
					sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
					formObj.req_eta_dt.value = "";
				}
			}
			setComboItem(comboObj,strPortCdList);
			//formObj.req_port_cd.focus();
			//ComSetFocus(formObj.req_port_cd);
			formObj.vsl_cd.readOnly = true;
			formObj.skd_voy_no.readOnly = true;
			formObj.skd_dir_cd.readOnly = true;
//			ComSetFocus(formObj.vps_port_cd);
			formObj.vps_port_cd.focus();
		}else{
			document.all.item("comboVpsPortCd").style.display = "none";
   			document.all.item("inputVpsPortCd").style.display = "inline";
			//axon_event.addListener  ('change'  , 'change_event', 'vps_port_cd');
		}
    }
    
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(sheetObj, formObj) {
    	var categoryXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	//Category Combo List Set..
//    	var vslCateCode = ComGetEtcData(categoryXml, "vslCategory");
//    	setComboItem(comboObjects[2], vslCateCode);
    	//Category Combo List Set..
    	var categoryCode = ComGetEtcData(categoryXml, "categoryCode");
    	setComboItem(comboObjects[2], categoryCode);
    	//Damage Combo List Set..
    	var damageCode = ComGetEtcData(categoryXml, "damageCode");
    	setComboItem2(comboObjects[4], damageCode);
    	// Requirement - Damage Reason Combo List.
    	var reqReasonCode = ComGetEtcData(categoryXml, "reqReasonCode");
    	setComboItem3(comboObjects[6], reqReasonCode);
		// Responsible Party Combo List.
    	var responsiblePartyCode = ComGetEtcData(categoryXml, "responsiblePartyCode");
    	setComboItem(comboObjects[7], responsiblePartyCode);
    	// Responsible - Damage Reason Combo List.
    	var resReasonCode = ComGetEtcData(categoryXml, "resReasonCode");
    	setComboItem3(comboObjects[8], resReasonCode);
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");			
    		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
			comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem3(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	var dataList = comboItems.split("|");
    	
    	for (var i = 0 ; i < dataList.length ; i++) {
    		
    		var comboItem = dataList[i].split(",");
    		//comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[1]);
    		comboObj.InsertItem(i, comboItem[1]+"|"+comboItem[2], comboItem[1]);
    	}
    }
    
    /**
     * IBSheet Grid 초기화.
     */
    function initDefaultSheet(sheetObj, formObj, firstFlag){
    	var prefix = "sheet1_";
    	var sdmsNo = "";
    	if(firstFlag=="A"){
    		var beforeNo = sheetObj.CellValue(sheetObj.LastRow, prefix+"stv_dmg_no");
        	if(!isNull(beforeNo)){
        		var newSeq = (parseInt(beforeNo.substring(9,11))+1)+"";
        		if(newSeq.length==1){
        			newSeq = "0"+newSeq;
        		}
        		sdmsNo = beforeNo.substring(0,9) + newSeq;
        	}
    	}else{
    		sheetObj.RemoveAll();
    		sheetObjects[2].RemoveAll();
    		sheetObjects[3].RemoveAll();
    		sheetObjects[4].RemoveAll();
    	}
    	var row = sheetObj.DataInsert(-1);
    	sheetObj.CellValue(row, prefix+"stv_dmg_no") = sdmsNo;
    	sheetObj.CellValue(row, prefix+"cntr_dmg_flg") = "N";
    	sheetObj.CellValue(row, prefix+"cgo_dmg_flg") = "N";
    	sheetObj.CellValue(row, prefix+"stv_dmg_req_cate_cd") = "R";
    	//sheetObj.CellValue(row, prefix+"stv_dmg_respb_pty_kwn_cd") = "Y";
    	sheetObj.CellValue(row, prefix+"stv_dmg_rpt_atch_flg") = "N";
    	sheetObj.CellValue(row, prefix+"stv_dmg_pict_atch_flg") = "N";
    	sheetObj.CellValue(row, prefix+"stv_dmg_doc_atch_flg") = "N";
    	sheetObj.CellValue(row, prefix+"dmg_auth_sts_cd") = "X";
    	sheetObj.CellValue(row, prefix+"auth_usr_id") = formObj.auth_usr_id.value;
		sheetObj.CellValue(row, prefix+"auth_dt") = formObj.auth_dt.value;
    	
		sheetObj.CellValue(row, prefix+"stv_dmg_rpt_atch_knt") = "0";
		sheetObj.CellValue(row, prefix+"stv_dmg_pict_atch_knt") = "0";
		sheetObj.CellValue(row, prefix+"stv_dmg_doc_atch_knt") = "0";
	
    	comboObjects[6].Enable = false;
    	comboObjects[8].Enable = false;
    	formObj.req_reason_desc.readOnly = true;
		formObj.req_reason_desc.className = "input2";
    	formObj.res_reason_desc.readOnly = true;
		formObj.res_reason_desc.className = "input2";
    	
    	if(firstFlag=="Y"){
    		// Default Combo Data Set!!
    		setDefaultComboData(sheetObj, formObj);
        	formObj.vsl_cd.focus();
        	//ComSetFocus(formObj.vsl_cd);
    	}
    	else if(firstFlag=="A"){
    		// Add Action 수행시에는 상단의 조회 Data 유지.
    		sheetObj.CellValue(row, prefix+"vsl_cd") = formObj.vsl_cd.value;
    		sheetObj.CellValue(row, prefix+"skd_voy_no") = formObj.skd_voy_no.value;
    		sheetObj.CellValue(row, prefix+"skd_dir_cd") = formObj.skd_dir_cd.value;
    		sheetObj.CellValue(row, prefix+"combo_vps_port_cd") = comboObjects[0].Code;
    		sheetObj.CellValue(row, prefix+"input_vps_port_cd") = formObj.vps_port_cd.value;
			sheetObj.CellValue(row, prefix+"stv_dmg_evnt_dt") = comboObjects[1].Code;
//    		sheetObj.CellValue(row, prefix+"stv_dmg_evnt_dt") = formObj.stv_dmg_evnt_dt.value;
    		//sheetObj.CellValue(row, prefix+"slan_cd") = formObj.slan_cd.value;
//    		sheetObj.CellValue(row, prefix+"vsl_oshp_cntr_blk_tp_cd") = comboObjects[2].Code;
			sheetObj.CellValue(row, prefix+"vsl_oshp_cntr_blk_tp_cd") = formObj.vsl_oshp_cntr_blk_tp_cd.value;
    		//sheetObj.CellValue(row, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
			sheetObj.CellValue(row, prefix+"stv_dmg_respb_pty_kwn_cd") = formObj.stv_dmg_respb_pty_kwn_cd.value;
    	}
    	
    	if(isNull(comboObjects[2].Code)){
        	comboObjects[3].Enable = false;
        }else{
        	comboObjects[3].Enable = true;
        }

    	setDisplaySeq(formObj, sheetObj);
    	setSubButton();
    }
    
    /**
     * Display Sequence Set. <br>
     */
    function setDisplaySeq(formObj, sheetObj){
    	formObj.seq.value = sheetObj.SelectRow;
    	formObj.seq_total.value = sheetObj.RowCount;
    }
    /**
     * 데이터값 초기화<br>
     */
    function dataClear(formObj, strFlag){
    	if(strFlag != "add"){
    		
    		formObj.vsl_cd.value="";
    		formObj.skd_voy_no.value="";
    		formObj.skd_dir_cd.value="";
//    		formObj.stv_dmg_evnt_dt.value="";    		
    		formObj.slan_cd.value="";
    		formObj.vsl_oshp_cntr_blk_tp_cd.value="";
    		formObj.vsl_oshp_cntr_blk_tp_nm.value="";
        	//Port Combo 초기화.
    		formObj.input_vps_port_cd.value="";
        	comboObjects[0].RemoveAll();
			comboObjects[1].RemoveAll();
    		
        	comboObjects[2].Index2 = "";
        	
        	formObj.stv_dmg_no.value="";
        	formObj.stv_dmg_no_prefix.value="";
        	formObj.stv_dmg_no_suffix.value="";
//        	formObj.sdms_no_1.value="";
//        	formObj.sdms_no_2.value="";
        	
    	}
    	//Category Part Combo 초기화.
    	comboObjects[3].RemoveAll();
    	comboObjects[3].Enable = false;
    	
    	formObj.clm_hndl_ofc_cd.value="";
    	comboObjects[2].Index2 = "";
    	comboObjects[4].Index2 = "";
    	formObj.stv_dmg_loc_desc.value="";
    	formObj.stv_dmg_rpt_atch_flg.value="0";
    	formObj.stv_dmg_pict_atch_flg.value="0";
    	formObj.stv_dmg_doc_atch_flg.value="0";
    	formObj.cntr_dmg_flg.checked=false;
    	formObj.cgo_dmg_flg.checked=false;
    	formObj.cntr_no.value="";
    	formObj.time_loss_hours.value="";
    	formObj.fm_tm_lss_dt.value="";
    	formObj.to_tm_lss_dt.value="";
    	formObj.stv_dmg_rmk.value="";
    	formObj.stv_dmg_req_cate_cd[0].checked=true;
    	formObj.req_skd_voy_dir.value="";
    	formObj.req_port_cd.value="";
//    	comboObjects[8].RemoveAll();
    	formObj.req_eta_dt.value="";
    	formObj.req_skd_voy_dir.readOnly = false;
    	formObj.req_port_cd.readOnly = false;
    	formObj.req_eta_dt.readOnly = false;
    	formObj.req_skd_voy_dir.className = "input";
    	formObj.req_port_cd.className = "input";
    	formObj.req_eta_dt.className = "input";
    	comboObjects[6].Index2 = "";
    	formObj.req_reason_desc.value = "";
//		formObj.stv_dmg_respb_pty_kwn_cd[0].checked=true;
		formObj.stv_dmg_respb_desc_dtl.value="";
		formObj.stv_dmg_respb_desc_dtl.readOnly = false;
		formObj.stv_dmg_respb_desc_dtl.className = "input";
		comboObjects[7].Index2 = "";
		comboObjects[8].Index2 = "";
		formObj.res_reason_desc.value = "";
		formObj.dmg_auth_sts_cd.value = "";
		formObj.auth_usr_id.value="";
		formObj.auth_dt.value="";
		document.all.item("comboVpsPortCd").style.display = "none";
   		document.all.item("inputVpsPortCd").style.display = "inline";
		
		initApprovalPermission(sheetObjects[1], formObj);
    }
     
     
    /**
      * File 갯수 및 스타일 지정.
      */
    function setFileField(formObj){
    	if(sheetObjects[2].RowCount > 0){
    		formObj.stv_dmg_rpt_atch_flg.value = sheetObjects[2].RowCount;
    		formObj.stv_dmg_rpt_atch_flg.className = "input3"
    	}else{
    		formObj.stv_dmg_rpt_atch_flg.value = "0";
    		formObj.stv_dmg_rpt_atch_flg.className = "input"
    	}
    	if(sheetObjects[3].RowCount > 0){
    		formObj.stv_dmg_pict_atch_flg.value = sheetObjects[3].RowCount;
    		formObj.stv_dmg_pict_atch_flg.className = "input3"
    	}else{
    		formObj.stv_dmg_pict_atch_flg.value = "0";
    		formObj.stv_dmg_pict_atch_flg.className = "input"
    	}
    	if(sheetObjects[4].RowCount > 0){
    		formObj.stv_dmg_doc_atch_flg.value = sheetObjects[4].RowCount;
    		formObj.stv_dmg_doc_atch_flg.className = "input3"
    	}else{
    		formObj.stv_dmg_doc_atch_flg.value = "0";
    		formObj.stv_dmg_doc_atch_flg.className = "input"
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
                    
                    style.height = 150;
                    
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
                    
                    var HeadTitle = "|Seq|STV_DMG_NO|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|VSL_SLAN_CD|VSL_OSHP_CNTR_BLK_TP_CD|VSL_OSHP_CNTR_BLK_TP_DESC|STV_DMG_REF_NO|";
                    HeadTitle += "CLM_HNDL_OFC_CD|STV_DMG_PRT_CATE_CD|STV_DMG_PRT_CD|STEVEDORE DAMAGE TYPE CODE|STV_DMG_LOC_DESC|STV_DMG_RPT_ATCH_FLG|";
                    HeadTitle += "STV_DMG_PICT_ATCH_FLG|STV_DMG_DOC_ATCH_FLG|CNTR_DMG_FLG|CGO_DMG_FLG|CNTR_NO|FM_TM_LSS_DT|TO_TM_LSS_DT|STV_DMG_RMK|";
                    HeadTitle += "STV_DMG_REQ_CATE_CD|REQ_VSL_CD|REQ_SKD_VOY_NO|REQ_SKD_DIR_CD|REQ_PORT_CD|REQ_ETA_DT|STV_DMG_QTTN_CD|STV_DMG_QTTN_RSN_DESC|";
                    HeadTitle += "STV_DMG_RESPB_PTY_KWN_CD|STV_DMG_RESPB_CD|STV_DMG_RESPB_DESC|DMG_AUTH_STS_CD|cre_usr_id|cre_usr_ofc|AUTH_USR_ID|AUTH_DT|step_cnt|";
                    HeadTitle += "stv_dmg_rpt_atch_knt|stv_dmg_pict_atch_knt|stv_dmg_doc_atch_knt"
                    	
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet1_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtDataSeq,	30,	daCenter,	false,	prefix+"seq");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_voy_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_dir_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vps_port_cd", 			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_evnt_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_slan_cd",  			false,	"",		dfNone,		0,	true,	true);                    
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_oshp_cntr_blk_tp_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_oshp_cntr_blk_tp_desc",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_ref_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_ofc_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_prt_cate_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_prt_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_tp_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_loc_desc", 		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_rpt_atch_flg", 	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_pict_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_doc_atch_flg", 	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cntr_dmg_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cgo_dmg_flg",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cntr_no",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"fm_tm_lss_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"to_tm_lss_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rmk",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_req_cate_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_vsl_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_skd_voy_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_skd_dir_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_port_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"req_eta_dt",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_qttn_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_qttn_rsn_desc", false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_kwn_cd",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_cd",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_desc",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"dmg_auth_sts_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	80,		daLeft,		true,	prefix+"cre_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	80,		daLeft,		true,	prefix+"cre_usr_ofc",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"step_cnt",				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_rpt_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_pict_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stv_dmg_doc_atch_knt",	false,	"",		dfNone,		0,	true,	true);
				}
                break;
                
            case "sheet2":
                with (sheetObj) {

                	// 높이 설정
                    style.height = 130;
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
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet2_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;
                
            case "sheet3":
                with (sheetObj) {

                	// 높이 설정
                    style.height = 130;
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
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet3_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;
            
            case "sheet4":
                with (sheetObj) {

                	// 높이 설정
                    style.height = 130;
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
                    
                    var HeadTitle = "||stv_dmg_no|SEQ|File Name|ID|Date|file_sav_id|stv_dmg_proc_cd|stv_dmg_atch_file_tp_cd|vsl_cd|deleteFlag";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet4_";
                    InitDataProperty(0, cnt++ , dtStatus,	30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"strSeq",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_no",				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	40,	daCenter,	true,	prefix+"stv_dmg_atch_file_seq",		false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	230,daCenter,	true,	prefix+"file_nm",					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	prefix+"cre_usr_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"cre_dt",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	100,daCenter,	true,	prefix+"file_sav_id",  				false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	30,	daCenter,	true,	prefix+"stv_dmg_proc_cd",  			false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	50,	daCenter,	true,	prefix+"stv_dmg_atch_file_tp_cd",	false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	prefix+"vsl_cd",  					false,	"",	dfNone,	0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"deleteFlag",  				false,	"",	dfNone,	0,	false,	false);
                    
                    CountPosition = 0;
				}
                break;
                
         	case "sheet0":	//Claim Handling User
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 25;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 1, 100);

                     var HeadTitle = "|Name";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, true, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, false, true);

					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					 InitDataProperty(0, cnt++ , dtHiddenStatus,40,		daCenter,	false,		"ibflag");
					 InitDataProperty(0, cnt++ , dtPopup,  		130,    daLeft,		false,      "clm_hndl_usr_nm", 	true,    	"",	dfNone,	0,	false);
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_no");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_proc_cd");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"stv_dmg_eml_snd_seq");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_ofc_cd");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_usr_id");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"clm_hndl_usr_eml");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"eml_snd_no");
//					 InitDataProperty(0, cnt++ , dtHidden,	    0,		daCenter,	false,		"eml_snd_dt");
					 
					 ToolTipOption = "balloon:true;width:1000;icon:1;title:Name";
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet5":	//Claim Handling User
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 100;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "|Name|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix="sheet20_";
					 InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	false,		prefix+"ibflag");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_proc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,  		20,		daCenter,   false,      prefix+"clm_hndl_usr_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"grd_eng_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_eml");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_dt");
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
              	
         	case "sheet6":	//Claim Handling User
         		with (sheetObj) {
                     // 높이 설정
                     style.height = 100;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 10, 100);

                     var HeadTitle = "|Name|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15";
                     var headCount = ComCountHeadTitle(HeadTitle);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(headCount, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);

					 //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     var prefix="sheet20_";
					 InitDataProperty(0, cnt++ , dtStatus,		40,		daCenter,	false,		prefix+"ibflag");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_proc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,  		20,		daCenter,   false,      prefix+"clm_hndl_usr_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_cd");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_ofc_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"grd_eng_nm");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"clm_hndl_usr_eml");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_no");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"eml_snd_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"stv_dmg_eml_snd_seq");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"cre_dt");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_usr_id");
					 InitDataProperty(0, cnt++ , dtData,	    20,		daCenter,	false,		prefix+"upd_dt");
					 
					 ShowButtonImage = 1;
					 CountPosition = 0;
					 AutoRowHeight = false;
					 WaitImageVisible = false;

         		}
              	break;
        }
    }

    function doActionIBSheet(sheetObj,formObj,sAction, strFlag) {
    	  sheetObj.ShowDebugMsg = false;
    	    switch(sAction) {
    	    
    	    case IBCLEAR:
    	    	sheetObj.RemoveAll();
    	    	sheetObjects[2].RemoveAll();
    	    	sheetObjects[3].RemoveAll();
    	    	sheetObjects[4].RemoveAll();
    	    	sheetObjects[5].RemoveAll();
    	    	sheetObjects[6].RemoveAll();
    	    	sheetObjects[0].RemoveAll();
    	    	sheetObjects[0].Editable = true;
    	    	sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#E9E9E9");
    	    	unKnownFlg = false;
    	    	initDefaultSheet(sheetObj, formObj);
    	    	
    	    	comboObjects[1].Style = 1;
    	    	
    	    	comboObjects[5].RemoveAll();
    	    	document.all.item("inputReqPortCd").style.display = "inline"; 
      			document.all.item("comboReqPortCd").style.display = "none";
      			formObj.req_eta_dt.className = "input";

    	    	dataClear(formObj);
 
    	    	setScreenreadOnly(false, formObj, sheetObj);
    	    	formObj.vsl_cd.focus();
    	    	break;
    	    	
    	    case IBSEARCH:      //조회

              	formObj.f_cmd.value = SEARCH;

              	//[2009-10-23] 김종옥 수정
              	//formObj.stv_dmg_no.value = formObj.sdms01.value + formObj.sdms02.value;
              	//formObj.stv_dmg_no.value = formObj.sdms_no_1.value + formObj.sdms_no_2.value;
              	
                sheetObj.RemoveAll();
    	    	sheetObjects[2].RemoveAll();
    	    	sheetObjects[3].RemoveAll();
    	    	sheetObjects[4].RemoveAll();
    	    	sheetObjects[5].RemoveAll();
    	    	sheetObjects[6].RemoveAll();
    	    	uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
    	    	
    	    	var strReqPortComboList = "";
    	    	
//    	        sheetObj.DoSearch("VOP_OPF_0052GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
    	    	var prefixs = new Array("sheet1_","sheet20_");
    	    	var sXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do", FormQueryString(formObj)+"&stv_dmg_proc_cd=D" + "&" + ComGetPrefixParam(prefixs));
    	    	var arrXml = sXml.split("|$$|");
    	    	if (arrXml.length > 0) {
    	    		sheetObj.LoadSearchXml(arrXml[0]);
    	    		strReqPortComboList = ComGetEtcData(arrXml[0], "reqPortComboList");
    	    	}
  				if (arrXml.length > 1) {
  					sheetObjects[5].LoadSearchXml(arrXml[1]);
  					sheetObjects[6].LoadSearchXml(arrXml[1]);
  					
   					//2011.11.10 UnKnown 일 경우 처리
  					if(sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_respb_pty_kwn_cd") == "U") {
  						setResponsiblePartyBehind("Search", true);
  					}else {
  						sheetObjects[0].RowDelete(1, false);
  	   					sheetObjects[0].DataInsert(-1);
  	   					
  						setResponsiblePartyBehind("Search", false);
  					}
  					
  					setClaimHandlingUser(sheetObjects[0]);
  				}
    	        
    	        if(sheetObj.RowCount==0)
    	        {
    	        	var stv_dmg_no = formObj.stv_dmg_no.value;
    	        	initDefaultSheet(sheetObj, formObj);
    	        	dataClear(formObj);
    	        	setScreenreadOnly(false, formObj, sheetObj);
    	        	
    	        	formObj.com_content.value = formObj.default_content.value;
    	        	ComShowCodeMessage("OPF00001", stv_dmg_no);
    	        }
    	        else{
    	        	// 조회한 Data 화면에 Set.
					moveScreen(sheetObj, formObj, 0, "Search", strReqPortComboList);
    	        	// Port Code Data Set.
//        	    		setVVDPortCombo(sheetObj, formObj, "Vsl", false);
//        	    		comboObjects[0].Code2 = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd");
//	    	    		formObj.vps_port_cd.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd");
    	    		
    	    		//[PIC of Claim Handling Office] 가져옴.
        	        doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "MailContentPic");
    	        }
    	        
              	if(strFlag=="File"){
  	              	formObj.f_cmd.value = SEARCH05;
        	        sheetObjects[2].DoSearch("VOP_OPF_0052GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
        	        sheetObjects[3].DoSearch("VOP_OPF_0052GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
        	        sheetObjects[4].DoSearch("VOP_OPF_0052GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet4_"));
        	        setFileField(formObj);
              	}
              	
              	
              	break;
    	    
    	    case IBROWSEARCH:
    	    	  if(strFlag=="dmgDate"){

    	    		  formObj.f_cmd.value = SEARCH06;
    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	    		  
    	    		  var etaDate = ComGetEtcData(dateXml, "eta_date");
    	    		  var etdDate = ComGetEtcData(dateXml, "etd_date");
    	    		  
    	    		  if(!isNull(etaDate) && !isNull(etdDate)){
//    	    			  var dateChk1 = ComGetDaysBetween(etaDate, formObj.stv_dmg_evnt_dt.value);
//    	    			  var dateChk2 = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, etdDate);
//    	    			  if(dateChk1 < 0 || dateChk2 < 0){
//    	    				  ComShowCodeMessage("OPF07002", "Damage Date", "ETA Date("+etaDate+")");
//    	    				  ComShowCodeMessage("OPF50018", etaDate, etdDate);
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_evnt_dt") = etaDate;
        	    			  formObj.stv_dmg_evnt_dt.value = etaDate;
        	    			  formObj.stv_dmg_evnt_dt.focus();
//        	    			  return false;
        	    			  return true;
//    	    			  }
    	    		  }
    	    	  }
    	    	  if(strFlag=="etaDate"){
    	    		  formObj.f_cmd.value = SEARCH06;
    	    		  var voyNo   = formObj.req_skd_voy_dir.value.substring(0,4);
    	    		  var dirCode = formObj.req_skd_voy_dir.value.substring(4);
    	    		  var port = formObj.req_port_cd.value;
//    	    		  var port = comboObjects[8].Code;
    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?skd_voy_no="+voyNo+"&skd_dir_cd="+dirCode+"&vps_port_cd="+port , FormQueryString(formObj));
    	    		  
    	    		  var etaDate = ComGetEtcData(dateXml, "eta_date");
    	    		   if(!isNull(etaDate)){	    		 
                        
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_req_eta_dt") = etaDate;
    	    				  formObj.req_eta_dt.value = etaDate;
							  }

    	    	  }
    	    	  else if(strFlag=="ClmHndlOfc"){
    	    		  formObj.f_cmd.value = SEARCH07;
    	    		  //var ofcXml = sheetObj.GetSearchXml("COM_ENS_071GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  var ofcXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));

    	    		  var ofcArr = ComOpfXml2Array(ofcXml, "ofc_cd");

    	    		  if(isNull(ofcArr) || ofcArr.length < 1){
    	    			  //ComShowMessage("등록되지 않은 Office CD 입니다.");
    	      			  ComShowCodeMessage("OPF50004", "Data");
    	    			  formObj.clm_hndl_ofc_cd.value = "";
    	    			  formObj.clm_hndl_ofc_cd.focus();
    	    			  //ComSetFocus(formObj.clm_hndl_ofc_cd);
  						  return false;
    	    		  }
    	    	  }

    	    	  else if(strFlag=="MailContentPic"){
    	    		  formObj.f_cmd.value = SEARCH08;
    	    		  var Xml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  var mailContentCic = ComGetEtcData(Xml, "mail_content_pic");
    	    		  formObj.com_content.value = formObj.default_content.value+ mailContentCic;
    	    	  }    	    	  
    	    	  break;
    	        
    	      case IBSAVE:        //저장
    	    	  var vDeleteFlag = false; //삭제 저장 유무 확인
    	    	  
    	    	  if(!validateForm(sheetObj,formObj,sAction)){
    	    		  return false;
    	    	  }

    	    	  if(strFlag=="Approval"){
    	    		  var stvDmgNo = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no");
    	    		  
    	    		  formObj.f_cmd.value = MODIFY01;
    	    		  formObj.dmg_auth_sts_cd.value = "Y";
    	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_dmg_auth_sts_cd") = "Y";
    	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_usr_id") = formObj.auth_usr_id.value;
    	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_dt") = formObj.auth_dt.value;
          	          sheetObj.DoAllSave("VOP_OPF_0052GS.do?stv_dmg_no="+stvDmgNo+"&auth_usr_id="+formObj.auth_usr_id.value+"&auth_dt="+formObj.auth_dt.value, FormQueryString(formObj));
          	          initApprovalPermission(sheetObj, formObj);
          	          //break;
    	    	  }
    	    	  else{

    	    		  //** VVD CD/Port/DamageDate 정보 중복체크가 있으면 그대로 유지.
//    	    		  if( sheetObj.RowCount("I") > 0 && sheetObj.RowCount("R") < 1 ){
//	    	    		  formObj.f_cmd.value = SEARCH09;
//	    	    		  //var checkXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_"));
//	    	    		  var checkXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do", FormQueryString(formObj));
//	    	    		  if( ComOpfGetMessageFromXml(checkXml).indexOf("OPF00003") != -1 ){
//	    	    			  sheetObj.LoadSaveXml(checkXml);
//	    	    			  break;
//	    	    		  }
//    	    		  }

    	    		  formObj.f_cmd.value = MULTI;
    	    		  
    	    		  setSdmsNo();
    	    		 
    	    		  var sParam = ComGetSaveString(sheetObj);
    	    		  sParam += "&" + ComGetSaveString(sheetObjects[5], true);
    	    		  //var sParam = sheetObj.GetSaveString();
    	    		  var fParam1 = ComGetSaveString(sheetObjects[2], true);
    	    		  var fParam2 = ComGetSaveString(sheetObjects[3], true);
    	    		  var fParam3 = ComGetSaveString(sheetObjects[4], true);
    	    		  
    	    		  
    	    		  //전체 페이지 삭제 체크
    	    		  if( sheetObj.RowCount("D") == formObj.seq_total.value ){
    	    			  vDeleteFlag = true;
    	    		  }
    	    		  
    	    		  var uploadObj = uploadObjects[0];
    	    		  if(fParam1=="" && fParam2=="" && fParam3==""){
    	    			  if(sParam==""){
        	    			  return false;
        	    		  }
    	    			  var prefixs = new Array("sheet1_","sheet20_");
    	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
    	    			  //ComOpenWait(true, true);	//키보드나 마우스를 대기상태 & 대기이미지 설정.
    	    			  
        	    		  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do", sParam);
        	    		  setStvDmgNo(sheetObj, ComGetEtcData(saveXml, "stvDmgNoList"));
        	    		 
        	    		  if (ComOpfGetMessageFromXml(saveXml).indexOf("OPF00001") !=-1){
        	    			  sheetObj.LoadSaveXml(saveXml);
        	    			  break;
        	    		  }
        	    		  if (ComOpfGetMessageFromXml(saveXml).indexOf("OPF50005") !=-1){
        	    			  sheetObj.LoadSaveXml(saveXml);
        	    			  break;
        	    		  }
        	    		  sheetObj.LoadSaveXml(saveXml);
        	    		  //** VVD CD/Port/DamageDate 정보 중복체크가 있으면 그대로 유지.
        	    		  //if( ComOpfGetMessageFromXml(saveXml).indexOf("OPF00003") != -1 ){
        	    		  //	vDeleteFlag = true;
        	    		  //}
    	    		  }
    	    		  else{
    	    			  var prefixs = new Array("sheet1_","sheet20_","sheet2_","sheet3_","sheet4_");
    	    			  // Upload Sheet Data를 Query String에 추가..
    	    			  sParam += "&" + fParam1;
    	    			  sParam += "&" + fParam2;
    	    			  sParam += "&" + fParam3;
    	    			  
        	    		  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
        	    		  
        	    		  if(uploadObj.LocalFiles==""){
        	    			  //1. 업로드할 파일이 없을때=> DB정보만 변경.
        	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do", sParam);
            	    		  
            	    		  setStvDmgNo(sheetObj, ComGetEtcData(saveXml, "stvDmgNoList"));
            	    		  
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  
            	    		  //** VVD CD/Port/DamageDate 정보 중복체크가 있으면 초기화.
            	    		  if( ComOpfGetMessageFromXml(saveXml).indexOf("OPF00003") != -1 ){
            	    			  vDeleteFlag = true;
            	    		  }
            	    		  
            	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  
            	    		  sheetObjects[2].LoadSaveXml(saveXml);
            	    		  sheetObjects[3].LoadSaveXml(saveXml);
            	    		  sheetObjects[4].LoadSaveXml(saveXml);
        	    		  }
        	    		  else{
        	    			  
        	    			  //1. 업로드할 파일이 있을때=> 파일업로드 & DB정보 변경.
            	    		  uploadObj.ExtendParam = sParam;
                   		      uploadObj.ParamDecoding = true;
                   		      
                   		      var saveXml = uploadObj.DoUpload(true);

            	    		  setStvDmgNo(sheetObj, ComGetEtcData(saveXml, "stvDmgNoList"));
            	    		  
            	    		  sheetObj.LoadSaveXml(saveXml);

            	    		  //** VVD CD/Port/DamageDate 정보 중복체크가 있으면 초기화.
            	    		  //if( ComOpfGetMessageFromXml(saveXml).indexOf("OPF00003") != -1 ){
            	    		  //	vDeleteFlag = true;
            	    		  //}
            	    		  
            	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  
            	    		  sheetObjects[2].LoadSaveXml(saveXml);
            	    		  sheetObjects[3].LoadSaveXml(saveXml);
            	    		  sheetObjects[4].LoadSaveXml(saveXml);
            	    		  
            	    		  uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
        	    		  }
        	    		  
        	    		  //저장 후 파일 첨부파일 데이타 초기화
        	    		  sheetObjects[2].RemoveAll();
        	    		  sheetObjects[3].RemoveAll();
        	    		  sheetObjects[4].RemoveAll();
        	    		  
        	    		  setScreenreadOnly(true, formObj, sheetObj);
    	    		  }
    	    		  //ComOpenWait(false);	//키보드나 마우스를 대기상태 & 대기이미지 해제.
          	          //break;
    	    	  }

    	    	  //전체 페이지 삭제시 IBCLEAR 시킴.
    	    	  if(vDeleteFlag){
    	    		  doActionIBSheet(sheetObj,formObj,IBCLEAR);
    	    	  }else{
    	    		  doActionIBSheet(sheetObj,formObj,IBSEARCH);
    	    		  doActionIBSheet(sheetObj,formObj,IBSEARCH, "File");	//::2011.11.22 append::jsk
    	    	  }    	    	  
    	    	  
    	    	  break;
    	    	  
    	      case IBDELETE:
    	    	  formObj.f_cmd.value = REMOVE;
    	    	  var deleteParam = ComGetSaveString(sheetObj);
    	    	  deleteParam = deleteParam +"&"+ FormQueryString(formObj);
    	    	  
    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), deleteParam);
    	    	  //sheetObj.DoSave("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj), -1,false);
    	    	  break;
    	      case COMMAND01:
    	    	  formObj.f_cmd.value = COMMAND01;
    	    	  var str_tmp = strFlag.split("|");//str_tmp[0]:VSL,VVD,PORT,LANE등 구분자 str_tmp[1] : port값이 
    	    	  var vsl_cd="";
    	    	  var voy_no="";
    	    	  var dir_cd="";
    	    	  var port_cd="";
    	    	  var lane_cd="";
    	    	  var result="";
    	    	  if (str_tmp[1] =='MAIN'){
					  vsl_cd = formObj.vsl_cd.value;
    	    		  voy_no = formObj.skd_voy_no.value;
    	    		  dir_cd = formObj.skd_dir_cd.value;
					  if(comboObjects[0].Code != ""){
						port_cd = comboObjects[0].Code;
					  }else{
						port_cd = formObj.input_vps_port_cd.value;
					  }
    	    		  lane_cd = formObj.slan_cd.value;    	    		  
    	    	  } else { /* sub */
    	    		  vsl_cd = formObj.vsl_cd.value;
    	      		  voy_no = formObj.req_skd_voy_dir.value.substring(0,4);
    	    		  dir_cd = formObj.req_skd_voy_dir.value.substring(4);
    	    		  port_cd = formObj.req_port_cd.value;
    	    	  }

    	    	  var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND01+"&auto_skd_cng_flg="+str_tmp[0]+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd+"&vps_port_cd="+port_cd+"&slan_cd="+lane_cd);
    	    	  
    	    	  result = ComGetEtcData(resultXml, "result_chk");
    	    	  
    	    	  if (str_tmp[0] == "PORT" && str_tmp[1] == "MAIN"){
    	    		  gVpsEtbEtdDt = ComGetEtcData(resultXml, "VPS_ETB_DT");
    	    	  }

    	    	  if (result==null ||result =="null"|| result=="" || result==undefined){

    	    		  return false;
    	    	  } else {
    	    		  return true;
    	    	  }
    	    	  break;
     	      case COMMAND03:
    	    	 formObj.f_cmd.value = COMMAND03;
    	    	 var vsl_cd="";
    	    	 var voy_no="";
    	    	 var dir_cd="";
    	    	 var port_cd="";
    	    	     	    	  
				 vsl_cd = formObj.vsl_cd.value;
				 voy_no = formObj.skd_voy_no.value;
				 dir_cd = formObj.skd_dir_cd.value;
				 port_cd = "OrderBySeq";
    	    	 var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND03+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd+"&port_cd="+port_cd);
    	    	 result = ComGetEtcData(resultXml, "vslCd");
    	    	 
    	    	 if (result==null ||result =="null"|| result=="" || result==undefined){
     	    		return false;
     	    	 } else {
     	    		 
     	    		strPortComboList = ComGetEtcData(resultXml, "portComboList");
     	    		strYdComboList = ComGetEtcData(resultXml, "ydComboList");
     	    		strTurnPortindCdComboList = ComGetEtcData(resultXml, "turnPortindCdComboList");
             		//alert(strPortComboList);             		      	    		 
     	    		 
     	    		// Port Code 가져오기
             		if(strPortComboList != ""){
              			//Combo List 선택                		
                 		comboObjects[0].RemoveAll();
                     	var dataList = strPortComboList.split("|");
                     	
                     	for (var i = 0 ; i < dataList.length ; i++) {                    		
                     		var comboItem = dataList[i].split(",");			
                     		comboObjects[0].InsertItem(i, comboItem[0]+"|"+comboItem[1].substring(5), comboItem[0]);
                     	}
                 		
              			formObj.vsl_cd.readOnly = true;
              			formObj.skd_voy_no.readOnly = true;
              			formObj.skd_dir_cd.readOnly = true;
              			formObj.vsl_cd.className = "input2";
              			formObj.skd_voy_no.className = "input2";
              			formObj.skd_dir_cd.className = "input2";
              			document.all.item("inputVpsPortCd").style.display = "none"; 
              			document.all.item("comboVpsPortCd").style.display = "inline";
              		 }else{
              			//수기 입력
              			document.all.item("comboVpsPortCd").style.display = "none";
                 		document.all.item("inputVpsPortCd").style.display = "inline";
              		 }
             		 //formObj.vps_port_cd.focus();
             		 return true;
     	    	 }
    	    	 break;
			case COMMAND04:
    	    	 formObj.f_cmd.value = COMMAND04;
    	    	 var port_cd = "";
				 var yd_cd = "";
				 var vsl_cd="";
    	    	 var voy_no="";
    	    	 var dir_cd="";
    	    	 var turn_port_ind_cd = "";
    	    	 
    	    	 var dataListYdCd = strYdComboList.split("|");
    	    	 var dataListIndCd = strTurnPortindCdComboList.split("|");
             	
             	 for (var i = 0 ; i < dataListYdCd.length ; i++) {                    		
             	 	 var comboItemYdCd = dataListYdCd[i].split(",");	
             	 	 var comboItemIndCd = dataListIndCd[i].split(",");
             		 if(i == comboObjects[0].index){
             			yd_cd = comboItemYdCd[0]; 
             			turn_port_ind_cd = comboItemIndCd[0];
             		 }
             	 }
    	    	 
    	    	 if(turn_port_ind_cd=="D" || turn_port_ind_cd=="V" || turn_port_ind_cd=="F"){
    	    		 ComShowCodeMessage("OPF50028", turn_port_ind_cd);
    	    		 comboObjects[0].Index = "";
    	    		 comboObjects[1].RemoveAll();
    	    		 formObj.clm_hndl_ofc_cd.value = "";
    	    		 sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
    	    		 sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd") = "";
    	    		 
    	    		 return false;
    	    	 }else{
    	    		 if(document.all.item("comboVpsPortCd").style.display == "inline"){
    						port_cd = comboObjects[0].Code;
    						comboObjects[1].Style = 1;
    					}else{
    						port_cd = formObj.input_vps_port_cd.value;
    						comboObjects[1].Style = 0;
    		    			//Claim Handling User
    	    				if(comboObjects[8].Code == "U" && formObj.clm_hndl_ofc_cd.value != ""){
    	    					sheetObjects[0].RowDelete(1, false);
    	    					sheetObjects[0].DataInsert(-1);
//    		    					sheetObjects[0].SelectCell(1, "clm_hndl_usr_nm");
    	    					sheetObjects[0].SelectBackColor = sheetObjects[0].WebColor("#CCFFFD");
    	    				}
    					}
    	    		 
    				 vsl_cd = formObj.vsl_cd.value;
    				 voy_no = formObj.skd_voy_no.value;
    				 dir_cd = formObj.skd_dir_cd.value;
    	    		 var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND04+"&port_cd="+port_cd+"&yd_cd="+yd_cd+"&vsl_cd="+vsl_cd+"&skd_voy_no="+voy_no+"&skd_dir_cd="+dir_cd);
        	    	 result = ComGetEtcData(resultXml, "result");
    				 ofcCd = ComGetEtcData(resultXml, "ofcCd");
    				 gVpsEtbEtdDt = ComGetEtcData(resultXml, "dmgDt");
    				 if (result==null ||result =="null"|| result=="" || result==undefined){
        	    		return false;
        	    	 } else {
        	    		 sheetObj.CellValue(sheetObj.SelectRow, "sheet1_vps_port_cd") = port_cd;
        	    		 return true;
        	    	 }
    	    	 }
    	    	break;
			case COMMAND05:
				formObj.f_cmd.value = COMMAND05;
				var vsl_cd = formObj.vsl_cd.value;
   	    	 	var voy_no = formObj.req_skd_voy_dir.value.substring(0, 4);
   	    	 	var dir_cd = formObj.req_skd_voy_dir.value.substring(4);
//   	    	 	alert("formObj.req_skd_voy_dir.value:"+formObj.req_skd_voy_dir.value);
				var resultXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?f_cmd="+COMMAND05+"&vsl_cd="+vsl_cd+"&voy_no="+voy_no+"&dir_cd="+dir_cd);
				var strReqPortComboList = ComGetEtcData(resultXml, "reqPortComboList");
				
				// Requirment Port Code 가져오기
				setReqPortCombo(strReqPortComboList);
//         		if(strReqPortComboList != ""){
//                 	var dataList = strReqPortComboList.split("|");
//                 	
//                 	for (var i = 0 ; i < dataList.length ; i++) {                    		
//                 		var comboItem = dataList[i].split(",");			
//                 		comboObjects[5].InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[0]);
//                 	}
//          			document.all.item("inputReqPortCd").style.display = "none"; 
//          			document.all.item("comboReqPortCd").style.display = "inline";
//          			formObj.req_eta_dt.readOnly = true;
//          			formObj.req_eta_dt.className = "input2";
//          		 }else{
//          			//수기 입력
//          			document.all.item("comboReqPortCd").style.display = "none";
//             		document.all.item("inputReqPortCd").style.display = "inline";
//             		formObj.req_eta_dt.readOnly = false;
//             		formObj.req_eta_dt.className = "input";
//          		 }
				
				break;
    	    }			
    	}
        
        /**
         * 저장 후 stv_dmg_no 가져오기..
         */
        function setStvDmgNo(sheetObj, stvDmgNoList){
        	if(!isNull(stvDmgNoList)){
        		var stvDmgNoS = stvDmgNoList.split("|");
            	
            	for(i=1,j=0; i<=sheetObj.RowCount; i++){
                	if(sheetObj.RowStatus(i)=="I"){
                		sheetObj.CellValue2(i, "sheet1_stv_dmg_no") = stvDmgNoS[j++];
                		sheetObj.CellValue2(i, "sheet1_cre_usr_id") = userId;
                		sheetObj.CellValue2(i, "sheet1_cre_usr_ofc") = ofcCd;
                	}
            	}
            	
//            	document.form.sdms_no_1.value = stvDmgNoS[0].substring(0,4);
//            	document.form.sdms_no_2.value = stvDmgNoS[0].substring(4,11);
            	document.form.stv_dmg_no.value = stvDmgNoS[0];
            	document.form.stv_dmg_no_prefix.value = stvDmgNoS[0].substring(0,4);
            	document.form.stv_dmg_no_suffix.value = stvDmgNoS[0].substring(4,11);
        	}
        }
        

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function searchValidation(formObj){
        	if(isNull(formObj.stv_dmg_no.value)){
        		return false;
        	}
        	else if(formObj.stv_dmg_no_suffix.value.length!=7){
        		//ComShowMessage("Data Length 4.");
    			ComShowCodeMessage("OPF50007", "SDMS No.", "11");
        		formObj.stv_dmg_no_suffix.focus();
        		//ComSetFocus(formObj.sdms_no_1);
        		return false;
        	}
        	ComBtnEnable("btn_Retrieve");
        	return true;
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
        	 
        	 var prefix = "sheet1_";
        	 // 조회된 데이터는 Validation Check 하지 않는다..
        	 if(sheetObj.RowStatus(sheetObj.SelectRow)!="R" || checkClaimHandlingUser()){
       		 
				 if(isNull(formObj.vsl_cd.value)){
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.vsl_cd.focus();
					 return false;
				 }
				 else if(isNull(formObj.skd_voy_no.value)){
					// alert();
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.skd_voy_no.focus();
					 return false;
				 }
				 else if(isNull(formObj.skd_dir_cd.value)){
					 ComShowCodeMessage("OPF50009", "VVD CD");
					 formObj.skd_dir_cd.focus();
					 return false;
				 }
				 else{
//					// VVD Code 유효성 조회.
//	               	 formObj.f_cmd.value = SEARCH01;
//	               	 var portXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq" , FormQueryString(formObj));
//	               	 
//	               	 var strPortCdList = ComGetEtcData(portXml, "vvdPortComboList");
//	               	 if(isNull(strPortCdList)){
//	           		 	//ComShowMessage("등록되지 않은 VVD CD 입니다.");
//	           			ComShowCodeMessage("OPF50004", "Data");
//	               		formObj.vsl_cd.value = "";
//	               		formObj.skd_voy_no.value = "";
//	               		formObj.skd_dir_cd.value = "";
//	               		formObj.vps_port_cd.value ="";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"vsl_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_voy_no") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"skd_dir_cd") = "";
//	               		sheetObj.CellValue(sheetObj.SelectRow, prefix+"vps_port_cd") = "";
////	               		comboObjects[2].RemoveAll();
//
//	               		formObj.vsl_cd.focus();
//	               		//ComSetFocus(formObj.vsl_cd);
//	               		return false;
//	               	 }
				 }
				 if(formObj.stv_dmg_no_suffix.value!="" && formObj.stv_dmg_no_suffix.value.length!=7){
					 ComShowCodeMessage("OPF50007", "SDMS No.", "11");
					 formObj.stv_dmg_no_suffix.focus();
					 return false;
				 }
//        		 alert(formObj.input_vps_port_cd.value);
        		 if(isNull(comboObjects[0].Code) && isNull(formObj.input_vps_port_cd.value)){
//        		 if(isNull(formObj.input_vps_port_cd.value)){
      				//ComShowMessage("\'Port\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Port");
      				formObj.input_vps_port_cd.focus();
      				return false;
          		 }
        		 
				 if(isNull(comboObjects[1].Code)){
//        		 if(isNull(formObj.stv_dmg_evnt_dt.value)){
        			 ComShowCodeMessage("OPF50009", "Damage Date");
        			 formObj.stv_dmg_evnt_dt.focus();
        			 return false;
             	 }
        		 else{
//        			 var isDmgDate = doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "dmgDate");
//        			 if(isNull(isDmgDate+"")) {isDmgDate = true;}
//        			 if(!isDmgDate){
//        				 return false;
//        			 }
        			 sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_evnt_dt") = comboObjects[1].Code;
        		 }
        		 
//        		 if(isNull(comboObjects[2].Code)){
				 if(isNull(formObj.vsl_oshp_cntr_blk_tp_cd.value)){
                  	//ComShowMessage("\'Vessel Category\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Vessel Category");
                  	formObj.vsl_oshp_cntr_blk_tp_nm.focus();
                  	return false;
                 }
        		 
        		 if(isNull(formObj.clm_hndl_ofc_cd.value)){
        			 //2011.11.10 unKnown 이 아닐 경우만 체크
        			 if(!unKnownFlg){
	        			 ComShowCodeMessage("OPF50009", "Claim Handling Office");
	        			 formObj.clm_hndl_ofc_cd.focus();
	                   	 return false;
        			 }
        		 }
        		 else{
        			 var isOfcCd = doActionIBSheet(sheetObj, formObj, IBROWSEARCH, "ClmHndlOfc");
        			 if(isNull(isOfcCd+"")) {isOfcCd = true;}
        			 if(!isOfcCd){
        				 return false;
        			 }
         		 }
        		 
                 if(isNull(comboObjects[2].Code)){
                  	//ComShowMessage("\'Category\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Category");
                  	formObj.stv_dmg_prt_cate_cd.focus();
                  	return false;
                 }
                 
                 //2011.11.10 unKnown 이 아닐 경우만 체크
                 if(!unKnownFlg && !deltFlg && sheetObjects[0].CellValue(1, "clm_hndl_usr_nm").length == 0){
        			 ComShowCodeMessage("OPF50009", "Claim Handling User");
        			 sheetObjects[0].SelectCell(1, "clm_hndl_usr_nm");
                   	 return false;
        		 }else{
        			 //Claim Handling User 변경 없이 타 정보 수정시 셋팅
        			 if(!checkClaimHandlingUser()){
    	        		for(var i=1 ; i<=sheetObjects[5].RowCount ; i++){
    	        			sheetObjects[5].RowStatus(i) = "I";
    	        		}
        			 }
        		 }
//                 //Groupware 의 Office Code 중 6자리보다 클 경우 제외하고 저장한다 
//                 if(!deltFlg && sheetObjects[5].RowCount != 0){
//                	 for(var i=0 ; i<sheetObjects[5].RowCount ; i++){
//                		 if(sheetObjects[5].CellValue(i, "sheet20_clm_hndl_ofc_cd").length > 6){
//                			 sheetObjects[5].RowDelete(i, false);
//                		 }
//                	 }
//                 }
                 
                 if(isNull(comboObjects[3].Code)){
                  	//ComShowMessage("\'Part\' is mandatory item.");
         			ComShowCodeMessage("OPF50009", "Part");
                  	formObj.stv_dmg_prt_cd.focus();
                  	return false;
                 }
        		 
        		 // Loss Time(Hours) Data Validation Check!
        		 var chkLossDate = checkDateHours(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
    			 if(isNull(chkLossDate+"")) {chkLossDate = true;}
    			 if(!chkLossDate){
    				 return false;
    			 }
        		 
        		 // 입력 조건에 따라 변동되는 필수입력 데이터 체크.
                 if(formObj.stv_dmg_req_cate_cd[2].checked){
         			if(isNull(comboObjects[6].Code))
         			{
         				//ComShowMessage("\'Requirement- Reason\' is mandatory item.");
            			ComShowCodeMessage("OPF50009", "Requirement- Reason");
         				formObj.stv_dmg_qttn_rsn_desc.focus();
         				return false;
         			}
         			else if(comboObjects[6].Code=="TXT" && isNull(formObj.req_reason_desc.value)){
         				ComShowCodeMessage("OPF50009", "Requirement- Reason Description");
         				formObj.req_reason_desc.focus();
         				return false;
         			}
         		 }
                 else{
         			if(isNull(formObj.req_skd_voy_dir.value))
         			{
            			//ComShowCodeMessage("OPF50009", "Requirement- Voyage No.");
         				//return ;
         			}
         			else{
         				//Voyage No. 데이터 조회.
//    	    	    	formObj.f_cmd.value = SEARCH01;
//    		    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//    		    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
//    		    		var portXml2 = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
//    		    		
//    	    	    	var strPortCdList2 = ComGetEtcData(portXml2, "vvdPortComboList");
//    	    	    	if(isNull(strPortCdList2)){
//    		    			//ComShowMessage("스케줄에 등록되지 않은 Voyage No.입니다.");
//    		    			ComShowCodeMessage("OPF50004", "Data");
//    		    			formObj.req_skd_voy_dir.value = "";
//    		    			formObj.req_port_cd.value="";
////    		    			comboObjects[8].RemoveAll();
//    		    			formObj.req_eta_dt.value = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
//    		    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
//    		    			formObj.req_skd_voy_dir.focus();
//    	    	    		return false;
//    	    	    	}
         			}
     				
         			//if(isNull(comboObjects[8].Code))
         			//{
            		//	ComShowCodeMessage("OPF50009", "Port");
         			//	formObj.req_port_cd.focus();
         			//	return false;
         			//}
         			
         		}
                 
//         		if(comboObjects[7].Code != 'U'){
//         			if(isNull(formObj.stv_dmg_respb_desc_dtl.value))
//         			{
//         				//ComShowMessage("\'Responsible Party- Details\' is mandatory item.");
//            			ComShowCodeMessage("OPF50009", "Responsible Party- Details");
//         				formObj.stv_dmg_respb_desc_dtl.focus();
//         				return false;
//         			}
//         		}else{
//         			if(isNull(comboObjects[8].Code))
//         			{
//         				//ComShowMessage("\'Responsible Party- Reason\' is mandatory item.");
//            			ComShowCodeMessage("OPF50009", "Responsible Party- Reason");
//         				formObj.stv_dmg_respb_desc.focus();
//         				return false;
//         			}
//         			else if(comboObjects[8].Code=="TXT" && isNull(formObj.res_reason_desc.value)){
//         				ComShowCodeMessage("OPF50009", "Responsible- Reason Description");
//         				formObj.res_reason_desc.focus();
//         				return false;
//         			}
//         		}
        		
        	 } else if(sheetObj.RowStatus(sheetObj.SelectRow)=="R"){
        		 if(!unKnownFlg && !deltFlg && sheetObjects[0].CellValue(1, "clm_hndl_usr_nm").length == 0){
        			 ComShowCodeMessage("OPF50009", "Claim Handling User");
        			 sheetObjects[0].SelectCell(1, "clm_hndl_usr_nm");
                   	 return false;
        		 }
        	 }
        	 
             return true;
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
        
         /**
          * 화면 DateTime 입력 값의 시간 계산 함수.
          */
         function getDateHoursBetween(fromTime, toTime){
        	 
        	 if(isNull(fromTime) || isNull(toTime)){
        		 return "";
        	 }
        	 else{
             	 fromTime = fromTime.replace(/-/g,"");
             	 fromTime = fromTime.replace(/:/g,"");
             	 fromTime = fromTime.replace(/ /g,"");
             	 toTime = toTime.replace(/-/g,"");
             	 toTime = toTime.replace(/:/g,"");
             	 toTime = toTime.replace(/ /g,"");
             	 
         		 var dayTime = ComGetDaysBetween(fromTime.substring(0,8), toTime.substring(0,8)) * 24;
         		 
         		 if(fromTime.substring(10) >= toTime.substring(10)){
         			 dayTime = dayTime - (fromTime.substring(8,10) - toTime.substring(8,10));
         		 }
         		 else{
         			 dayTime = dayTime + (toTime.substring(8,10) - fromTime.substring(8,10));
         		 }
         		 
         		 var minute = 0;
         		 if(fromTime.substring(10) > toTime.substring(10)){
 					 dayTime = dayTime - 1;
 					 minute = (fromTime.substring(10) - toTime.substring(10)) / 60;
 				 }
 				 else if(fromTime.substring(10) < toTime.substring(10)){
 					 minute = (toTime.substring(10) - fromTime.substring(10)) / 60;
 				 }
         		 
         		 var returnTime = "";
         		 if(minute>0){
         			 // 소수점 둘째자리 이하 반올림 처리.
         			 returnTime = (dayTime+minute).toFixed(2);
         		 }else{
         			 returnTime = dayTime;
         		 }
         		 return returnTime;
        	 }
         }
         
         /**
          * 화면 DateTime 입력 값의 유효성 체크 함수.
          */
         function checkDateHours(fromTime, toTime){
        	 var formObj = document.form;
        	 
        	 if(isNull(formObj.fm_tm_lss_dt.value) && !isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 ComShowCodeMessage("OPF50009", "From Loss Hour");
     			 formObj.fm_tm_lss_dt.focus();
     			 return false;
     		 }
     		 else if(!isNull(formObj.fm_tm_lss_dt.value) && isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 ComShowCodeMessage("OPF50009", "To Loss Hour");
     			 formObj.to_tm_lss_dt.focus();
     			 return false;
     		 }
     		 else if(!isNull(formObj.fm_tm_lss_dt.value) && !isNull(formObj.to_tm_lss_dt.value))
     		 {
     			 var lossTime = getDateHoursBetween(formObj.fm_tm_lss_dt.value, formObj.to_tm_lss_dt.value);
     			 if(lossTime <= 0){
	   				 ComShowCodeMessage("OPF50013", "To Loss Hour", "From Loss Hour");
	   				 formObj.fm_tm_lss_dt.focus();
	   				 return false;
	   			 }
     		 }
         }
        
        /**
         * Approval permission Check.
         */
        function initApprovalPermission(sheetObj, formObj){
        	
        	var approvalCheck = "";
        	if(userId=="8804820" || userId=="8803631"){
        		approvalCheck = "1";
        	}
        	
        	var prefix = "sheet1_";
        	
        	if(isNull(sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd"))){
        		formObj.dmg_auth_sts_cd.value = "X";
            	sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd") = "X";
    		}
    		else{
    			formObj.dmg_auth_sts_cd.value = sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd");
    		}
        	
    		if(sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd")=="N"){
        		formObj.dmg_auth_sts_cd.className = "input2_red";
				document.getElementById("btnApproval").style.color="red";
    		}
    		else{
    			formObj.dmg_auth_sts_cd.className = "input2";
				document.getElementById("btnApproval").style.color="#c0c0c0";
    		}
        	
    		if(approvalCheck=="1")
        	{
    			approvalFlag = true;
    			
    			if(sheetObj.CellValue(sheetObj.SelectRow, prefix+"dmg_auth_sts_cd")=="N"){
    				ComBtnEnable("btn_Approval");
        			
            		formObj.auth_usr_id.value = userId;
            		formObj.auth_dt.value = ComGetNowInfo("ymd");
    			}
    			else{
    				ComBtnDisable("btn_Approval");
    			}
        	}
        	else{
        		ComBtnDisable("btn_Approval");
        		formObj.auth_usr_id.value = "";
        		formObj.auth_dt.value = "";
        	}
    		ComSetFocus(formObj.auth_dt);
        }
        
    	/**
    	 * Sheet Data를 XML형태로 변환하여 넘겨준다. <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * </pre>
    	 * @param {int} sheet Index No
    	 * @version 2011.10.06
    	 */
        function getSheetXml() {
        	var sXml = ComOpfSheet2Xml(sheetObjects[5]);
//            alert("부모창getSheetXml:"+sXml);
            return sXml;
        }
        
    	/**
    	 * XML형태의 데이타를 Sheet에 Load한다. <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * </pre>
    	 * @param {int} sheet Index No
    	 * @version 2011.10.06
    	 */
        function setSheetXml(sXml) {
//        	alert("부모창setSheetXml:"+sXml);
    		sheetObjects[5].LoadSearchXml(sXml);
    		//setSdmsNo();
        }
        
        /**
         * 저장전 Claim Handling User Sheet에 SDMS No 를 셋팅한다.
         * @version 2012.02.01
         */
        function setSdmsNo(){
    		var tempStr = sheetObjects[1].CellValue(1, "sheet1_stv_dmg_no");
    		for(var i=1 ; i<=sheetObjects[5].RowCount ; i++){
    			sheetObjects[5].CellValue2(i, "sheet20_stv_dmg_no") = tempStr;
    			sheetObjects[5].CellValue2(i, "sheet20_stv_dmg_proc_cd") = "D";
    			sheetObjects[5].RowStatus(i) = "I";
    		}
        }
        
    	/**
    	 * 조회된 Sheet의 Claim Handling User 데이타를 Name만 Setting한다. <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * </pre>
    	 * @version 2011.10.06
    	 */
        function setClaimHandlingUser(sheetObj){
     	    var usrName = "";
			for(var i=1 ; i<=sheetObjects[5].RowCount ; i++){
				if(i == sheetObjects[5].RowCount)
					usrName = usrName + sheetObjects[5].CellValue(i, "sheet20_clm_hndl_usr_nm");
				else
					usrName = usrName + sheetObjects[5].CellValue(i, "sheet20_clm_hndl_usr_nm")+", ";
			}
			sheetObj.CellValue2(1, "clm_hndl_usr_nm") = usrName;
        }
        
    	/**
    	 * Claim Handling User 의 Update 유무를 판별한다. <br>
    	 * <br><b>Example :</b>
    	 * <pre>
    	 * </pre>
    	 * @version 2011.10.06
    	 */
        function checkClaimHandlingUser(){
        	var sheetObj5 = sheetObjects[5];
        	var sheetObj6 = sheetObjects[6];
        	var sheet5Rc = sheetObj5.RowCount;
        	var sheet6Rc = sheetObj6.RowCount;
        	if(sheet5Rc != sheet6Rc){
        		return true;
        	}
        	for(var i=1 ; i<=sheet5Rc ; i++){
        		var val5 = sheetObj5.CellValue(i, "sheet20_clm_hndl_usr_id");
        		var idx = sheetObj6.FindText("sheet20_clm_hndl_usr_id", val5);
        		if(idx == -1){
        			return true;
        		}
        	}
        	return false;    	
        }
        
        function setReqPortCombo(strReqPortComboList){
        	var formObj = document.form;
     		if(strReqPortComboList != ""){
             	var dataList = strReqPortComboList.split("|");
             	for (var i = 0 ; i < dataList.length ; i++) {   
             		var comboItem = dataList[i].split(",");			
	             		comboObjects[5].InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[0]);
             	}
      			document.all.item("inputReqPortCd").style.display = "none"; 
      			document.all.item("comboReqPortCd").style.display = "inline";
      			formObj.req_eta_dt.readOnly = true;
      			formObj.req_eta_dt.className = "input2";
      		 }else{
      			//수기 입력
      			document.all.item("comboReqPortCd").style.display = "none";
         		document.all.item("inputReqPortCd").style.display = "inline";
         		formObj.req_eta_dt.readOnly = false;
         		formObj.req_eta_dt.className = "input";
      		 }
        }

	/* 개발자 작업  끝 */