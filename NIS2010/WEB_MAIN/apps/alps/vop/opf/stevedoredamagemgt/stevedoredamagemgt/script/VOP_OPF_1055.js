/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_1055.js
*@FileTitle : Stevedore Damage Detail - Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 
*@LastVersion : 1.0
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
     * @class vop_opf_1055 : vop_opf_1055 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_opf_1055() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initTab				= initTab;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.obj_deactivate			= obj_deactivate;
    	this.obj_activate			= obj_activate;
    	this.obj_keypress			= obj_keypress;
    	this.initCombo				= initCombo;
    	
    	this.isNull					= isNull;
    	this.setComboItem			= setComboItem;
    	this.setComboItem2			= setComboItem2;
    	this.setComboItem3			= setComboItem3;
    	this.setDisplaySeq			= setDisplaySeq;
    	this.moveScreen				= moveScreen;
    	this.getDateHoursBetween	= getDateHoursBetween;
    	this.setDisplayData			= setDisplayData;
    	this.setRprDisplayData		= setRprDisplayData;
    	this.setCmpnDisplayData		= setCmpnDisplayData;
    	this.setStlDisplayData		= setStlDisplayData;
    	this.initDefaultSheet		= initDefaultSheet;
    	this.dmgFormObjControl		= dmgFormObjControl;
    	this.rprFormObjControl		= rprFormObjControl;
    	this.cmpnFormObjControl		= cmpnFormObjControl;
    	this.authPermission			= authPermission;
    	this.rprValidateForm 		= rprValidateForm;
    	this.cmpnValidateForm 		= cmpnValidateForm;
    	this.setStlDatareadOnly		= setStlDatareadOnly;
    }
    
   	/* 개발자 작업	*/

    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var comboObjects = new Array();
    var comboCnt = 0;
    
    var uploadObjects = new Array();
	var uploadCnt = 0;    
    
    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    
    var beforeSheet = 1;
    var firstTabFlag = true;
    
    var userId = "";
    var userNm = "";
    var glusrName = "";
    var officeCd = "";
    var dfCurrency = "";
    var approvalFlag = false;
    
    var ofcAuth = "";
    
    var changeFlag = false;
    var loadFlag = false;
    
    var opf01 = false;
    var opf04 = false;
    var opf05 = false;
    var opf06 = false;
    var claimHandlingOfc = false;
    var claimed = false;
    
    //Responsible Party 의 UnKnown 체크 유무
    var unKnownFlg = false;
    //load 발생
    var firstLoad = true;
    
    var firstReqPortComboList = "";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다 *****/
	     var sheetObject1 = sheetObjects[0];

         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
            
            	case "btn_SDR":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=SDR&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_Picture":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=D&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_t2Result":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=RES&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
            		
            	case "btn_t2Invoice":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=INV&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t2PIC":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=PIC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t2Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=R&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t4Invoice":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=S&stvDmgAtchFileTpCd=INV&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;

            	case "btn_t4Document":
           			ComOpenPopup("VOP_OPF_1052.do?pageId=OPF1053&stvDmgNo="+formObject.stv_dmg_no.value+"&stvDmgProcCd=S&stvDmgAtchFileTpCd=DOC&vslCd="+formObject.vsl_cd.value, 505, 350, "setFileUpload", "none", true, "","","","","Damage_Detail");
            		break;
	            	
            	case "btn_stv_dmg_evnt_dt":
            		if(!(formObject.stv_dmg_evnt_dt.readOnly)){
            			var cal = new ComCalendar();
                    	cal.select(form.stv_dmg_evnt_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_stv_dmg_cmpn_dt":
            		if(formObject.stv_dmg_cmpn_proc_sts_cd[5].checked){
            			var cal = new ComCalendar();
                    	cal.select(form.stv_dmg_cmpn_dt, 'yyyy-MM-dd');
            		}
            		break;
            		
            	case "btn_pay_dt":
            		var cal = new ComCalendar();
                	cal.select(form.pay_dt, 'yyyy-MM-dd');
                	break;
					
            	case "rpr_seq_prev":
            		moveScreen(sheetObjects[2], formObject, -1);
            		break;
            		
            	case "rpr_seq_next":
                	moveScreen(sheetObjects[2], formObject, 1);
            		break;
			
				case "btn_Print":
					rdOpen();
					break;
					
				case "btn_Mail":
			    	formObject.com_templateMrdArguments.value = "/rp ["+formObject.stv_dmg_no.value+"]";
			    	ComSendMailModal();
					break;
					
				case "btn_Close":
					self.close();
					var opener = window.dialogArguments;
					opener.call_1055();
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

    //RD 공통 팝업  
    function rdOpen(){
    	var formObject = document.form;
    	var rdParam = "/rp ["+formObject.stv_dmg_no.value+"]";
    	var strPath = "apps/alps/vop/opf/stevedoredamagemgt/stevedoredamagemgt/report/VOP_OPF_1153.mrd";

    	formObject.com_mrdPath.value = strPath;
    	formObject.com_mrdArguments.value = rdParam;
    	ComOpenRDPopupModal();
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
    	//alert(comboCnt);
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }
    
    /**
     * Combo 기본 설정
     * Combo의 항목을 설정한다.
     */
    function initCombo(comboObj) {
    	with(comboObj) {
    		switch(id) {
	    		case "vps_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 5;
		            break;
		            
		        case "vsl_oshp_cntr_blk_tp_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_prt_cate_cd":
	            	SetTitle("Category");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_prt_cd":
	            	SetTitle("Code|Part");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_tp_cd":
	            	SetTitle("Code|Damage");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
		            break;
		            
		        case "req_port_cd":
	            	SetTitle("Port");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	//BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 5;
		            break;
		            
		        case "combo_req_port_cd":
		        	SetTitle("Port|Calling Seq.");
		        	SetColWidth("60|90");
		        	SetColAlign("left|center");
		        	DropHeight = 230;
		        	break;
		            
		        case "stv_dmg_qttn_rsn_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|140")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "stv_dmg_respb_desc":
	            	SetTitle("Code|Description");
	            	SetColWidth("45|185")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
		            break;
		            
		        case "qttn_locl_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 3;
		            break;
		            
		        case "cmpn_curr_cd":
	            	SetTitle("Currency");
	            	//SetColWidth("100|50|200")
	            	DropHeight = 230;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	UseAutoComplete = true;
	            	BackColor = "#CCFFFD";
	            	ValidChar(2,0);
	            	MaxLength = 3;
		            break;
		    }
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
                    InsertTab( cnt++ , "Damage" , -1 );
                    InsertTab( cnt++ , "Repair" , -1 );
                    InsertTab( cnt++ , "Compensation" , -1 );
                    InsertTab( cnt++ , "Settlement" , -1 );

                }
             break;

         }
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
    	if(firstTabFlag){
            var objs = document.all.item("tabLayer");

        	objs[beforetab].style.display = "none";
        	objs[nItem].style.display = "Inline";

        	//--------------- 요기가 중요 --------------------------//
        	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        	//------------------------------------------------------//
        	beforetab= nItem;
        	
        	beforeSheet = beforetab+1;
        	firstTabFlag = false;
        	changeFlag = false;
        	
    	}
    }
    
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     * 2010.12.15 nItem은 tabIdx를 의미한다.
     */
    function tab1_OnClick(tabObj , nItem)
    {
    	 // Tab 이동시 기존 작업된 데이터를 저장할 것인지 여부 확인.
    	var formObject = document.form;
    	var sheet1 = sheetObjects[0].RowStatus(sheetObjects[0].SelectRow);
    	//2010.12.15 이상민 수정 - 기존 tabName은 beforetab으로 tabName을 정의하였음. 예) beforeta==0 tabName="Damage"
    	//위의 정의는 의도가 불분명하고 실제 사용되지 않아 하기와 같이 변경
    	//tabName은 현재 tabName을 의미. nItem은 현재 tabIdx를 의미함
    	var tabName = "";
    	     if(nItem == 0) tabName = "Damage";
    	else if(nItem == 1) tabName = "Repair";
    	else if(nItem == 2) tabName = "Compensation";
    	else if(nItem == 3) tabName = "Settlement";
    	
    	    if(!loadFlag){
	    		tabObj.SelectedIndex = beforetab;
    			return false;
			}
    		else if(beforetab==0 && formObject.dmg_auth_sts_cd.value=="N"){
    			//ComShowMessage("No approval from PUSCOV yet for the unknown responsible party.\n Please request PUSCOV to give confirmation for this damage case \n before proceeding to the next process.");
    			ComShowCodeMessage("OPF50017");
    			tabObj.SelectedIndex = beforetab;
    			return false;
    		}
    		else{
    			var objs = document.all.item("tabLayer");

            	objs[beforetab].style.display = "none";
            	objs[nItem].style.display = "Inline";

            	//--------------- 요기가 중요 --------------------------//
            	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
            	//------------------------------------------------------//
            	beforetab= nItem;
            	
            	beforeSheet = beforetab+1;
            	changeFlag = false;            	
          	
            	if(nItem==0 && authPermission(nItem)){
            		formObject.clm_hndl_ofc_cd.readOnly = true;
            		formObject.clm_hndl_ofc_cd.className = "input1";
            	}
            	else{
            		formObject.clm_hndl_ofc_cd.readOnly = true;
            		formObject.clm_hndl_ofc_cd.className = "input2";
            	}
    		}
    	//}
     
    	// 아래의 로직을 제외 시키고 authPermission 함수 안에서 처리.
    	authPermission(nItem);
    	
    	if(nItem == 1 && formObject.stv_dmg_rpr_proc_sts_cd[3].checked){// Repair Tab && Completed
    		
    		setClaimHandlingUserProcChange("R");
    	}else{
    		setClaimHandlingUserProcChange("D");
    	}
    	
    	if(nItem == 0 && comboObjects[6].Code == "U"){
    		setResponsiblePartyBehind("OnChange", true);
    	}
    	
    }
     
     //2011.01.04 진마리아 권한으로 save 버튼의 enable/disable 을 제어한다.
     //2011.05.26 송호진    OPF01,04,05,06, Claimed 와 ClaimHandling Office 소속 인자 만을 가지고 
     //                  Delete, Save Button 의 Enable/Disable 을 제어하도록 수정
     //2013.09.16 roll code 삭제
    function authPermission(nItem){
    	var formObj = document.form;
    	
    	var rVal = false;
    	
    	switch(nItem){
    		case 0:
    			//rVal = ( opf01 || opf04 ? true : false );  
    			break;
    		case 1:
    			//rVal = ( opf01 || opf05 ? true : false );
    			break;
    		case 2:
    			//rVal = ( opf01 || opf06 || ( !claimed && claimHandlingOfc ) ? true : false );
    			break;
    		case 3:
    			rVal = true;
    			break;
    	}
    	// 바깥에서 다시 조정하는 일 없도록  해당 함수 안에서 처리 함. 
		if ( rVal ) {
			//ComBtnEnable ( "btn_Delete" );
			//ComBtnEnable ( "btn_Save" );			
			    	
			if(sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_stv_dmg_respb_pty_kwn_cd") != "U") {
				//Claim Handling User 셋팅
				sheetObjects[17].RowDelete(1, false);
				sheetObjects[17].DataInsert(-1);
				sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
				setClaimHandlingUser(sheetObjects[17]);
			}
		}else {
			//ComBtnDisable ( "btn_Delete" );
			//ComBtnDisable ( "btn_Save" );
			
			//Claim Handling User 셋팅
			//alert("03");
			sheetObjects[17].RowDelete(1, false);   //sheet0 , clm_hndl_usr_nm, 권한없으면 PIC 안보이게
			
		}

    	return rVal;
    }
  
    /**
     * Default Combo Data Set <br>
     **/
    function setDefaultComboData(comboXml) {
    	 
    	//Vessel Category Combo List Set..
    	var vslCateCode = ComGetEtcData(comboXml, "vslCategory");
    	setComboItem(comboObjects[0], vslCateCode);
    	//Category Combo List Set..
    	var categoryCode = ComGetEtcData(comboXml, "categoryCode");
    	setComboItem(comboObjects[1], categoryCode);
    	//Damage Combo List Set..
    	var damageCode = ComGetEtcData(comboXml, "damageCode");
    	setComboItem2(comboObjects[3], damageCode);
    	// Requirement - Damage Reason Combo List.
    	var reqReasonCode = ComGetEtcData(comboXml, "reqReasonCode");
    	setComboItem3(comboObjects[5], reqReasonCode);
    	
    	// Responsible Party Combo List.
    	var responsiblePartyCode = ComGetEtcData(comboXml, "responsiblePartyCode");
    	setComboItem(comboObjects[6], responsiblePartyCode);
    	
    	// Responsible - Damage Reason Combo List.
    	var resReasonCode = ComGetEtcData(comboXml, "resReasonCode");
    	setComboItem3(comboObjects[7], resReasonCode);
    	
    	//Currency Code Combo List Set..
    	var strCurrencyCdList = ComGetEtcData(comboXml, "currencyCode");
    	setComboItem(comboObjects[8], strCurrencyCdList);
    	setComboItem(comboObjects[9], strCurrencyCdList);
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(strUsrId, strUsrNm, strOffcCd) {
        //ComOpenWait(true);
		for(i=0;i<sheetObjects.length;i++){

			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );

			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }
		
		ComOpenWait(true);
		//Combo 초기화
    	for(var m=0; m<comboObjects.length; m++){
        	initCombo(comboObjects[m]);
        }

		//UPLOAD 환경 설정
//        for(var i=0;i<uploadObjects.length;i++){
//		    //1. 기본 환경 설정
//		    ComConfigUpload(uploadObjects[i], "/hanjin/VOP_OPF_1053GS.do");
//		}
        
		userId = strUsrId;
		userNm = strUsrNm;
		officeCd = strOffcCd;
		
		
//		initControl();
		
		dataSearch();		
	
		document.form.stv_dmg_prt_cate_cd.focus();
		ofcAuth = document.form.clm_hndl_ofc_cd.value;
		
    	var formObj = document.form;

    		/*  
			   Inquiry 화면으로 분리하여 Role Code hard coding 제거, 2013.08.16 
			*/

		if ( formObj.clm_hndl_ofc_cd.value == officeCd ) claimHandlingOfc = true; 
		if ( formObj.stv_dmg_cmpn_proc_sts_cd[1].checked ) claimed = true;
		
		authPermission(0);
		
		// 화면 로딩이 완료되었는지 여부를 표시하는 Flag.
		loadFlag = true;

		firstLoad = false;
	}
     
    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {int}     sheetNo     sheetObjects 배열에서 순번
     **/
    function initControl(){
    	axon_event.addListenerFormat('blur',      'obj_deactivate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',     'obj_activate',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',  'obj_keypress',   document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	
    }
    
    /**
     * Grid Data 화면에 Setting. <br>
     **/
    function setDisplayData(formObj, gubun, strReqPortComboList){
    	
    	var sheetObj = null;
    	var thisRow = null;
    	var prefix = "";
    	
//		if(officePermission(0)){
    	if(authPermission(0)){
			formObj.clm_hndl_ofc_cd.readOnly = true;
			formObj.clm_hndl_ofc_cd.className = "input1";
    	}
    	else{
    		formObj.clm_hndl_ofc_cd.readOnly = true;
    		formObj.clm_hndl_ofc_cd.className = "input2";
    	}
    	
    	if(gubun!="Dtl"){
    		//** OPF_STV_DMG Data Set..
        	sheetObj = sheetObjects[0];
        	thisRow = sheetObj.SelectRow;
        	prefix = "sheet1_";
        	
        	formObj.vsl_cd.value 				= sheetObj.CellValue(thisRow, prefix+"vsl_cd");
            formObj.skd_voy_no.value 			= sheetObj.CellValue(thisRow, prefix+"skd_voy_no");
            formObj.skd_dir_cd.value 			= sheetObj.CellValue(thisRow, prefix+"skd_dir_cd");
            // Lane Code Set..
            formObj.f_cmd.value = SEARCH02;
        	var laneXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
        	var strLaneCode = ComGetEtcData(laneXml, "laneCode");
        	//alert(strLaneCode);
        	if(isNull(strLaneCode)){
        		formObj.slan_cd.value = "";
        	}else{
        		formObj.slan_cd.value = strLaneCode;
        	}
            // Port Code Set..
        	formObj.vps_port_cd.value 			= sheetObj.CellValue(thisRow, prefix+"vps_port_cd");
            formObj.stv_dmg_evnt_dt.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_evnt_dt");
            comboObjects[0].Code2 				= sheetObj.CellValue(thisRow, prefix+"vsl_oshp_cntr_blk_tp_cd");
            formObj.clm_hndl_ofc_cd.value 		= sheetObj.CellValue(thisRow, prefix+"clm_hndl_ofc_cd");            
            
            formObj.dmg_auth_sts_cd.value 		= sheetObj.CellValue(thisRow, prefix+"dmg_auth_sts_cd");
            formObj.auth_usr_id.value 			= sheetObj.CellValue(thisRow, prefix+"auth_usr_id");
            formObj.auth_dt.value 				= sheetObj.CellValue(thisRow, prefix+"auth_dt");
    	}
        if(gubun!="Dmg"){
        	//** OPF_STV_DMG_DTL Data Set..
            sheetObj = sheetObjects[1];
        	thisRow = sheetObj.SelectRow;
        	prefix = "sheet2_";
        	
            var cateCodeValue = sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd");
            comboObjects[1].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd");
            stv_dmg_prt_cate_cd_OnChange(comboObjects[1], sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cate_cd"), "");
            comboObjects[2].Code2 				= cateCodeValue;
            sheetObj.CellValue(thisRow, prefix+"stv_dmg_prt_cd") = cateCodeValue;
            comboObjects[3].Code2 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_tp_cd");
            formObj.stv_dmg_loc_desc.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_loc_desc");
           
            formObj.stv_dmg_rpt_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_rpt_atch_knt");
            formObj.stv_dmg_pict_atch_knt.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_pict_atch_knt");
            formObj.stv_dmg_doc_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_doc_atch_knt");
            
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
            formObj.cntr_no.value 	= sheetObj.CellValue(thisRow, prefix+"cntr_no");
            
        	formObj.fm_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt");
        	formObj.to_tm_lss_dt.value 		= sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt");
            
            formObj.time_loss_hours.value = "";
            if( !isNull(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"))
            	&& !isNull(sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt")))
            {
            	formObj.time_loss_hours.value = getDateHoursBetween(sheetObj.CellValue(thisRow, prefix+"fm_tm_lss_dt"), sheetObj.CellValue(thisRow, prefix+"to_tm_lss_dt"));
            }
            
            formObj.stv_dmg_rmk.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_rmk");
            
            formObj.req_skd_voy_dir.value 		= sheetObj.CellValue(thisRow, prefix+"req_skd_voy_no") + sheetObj.CellValue(thisRow, prefix+"req_skd_dir_cd");
            
            if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="Q")
            {
            	formObj.stv_dmg_req_cate_cd[2].checked = true;
    			comboObjects[5].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_cd");
    			formObj.req_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_qttn_rsn_desc");
            }
            else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="R"){
            	formObj.stv_dmg_req_cate_cd[0].checked = true;
        	}
        	else if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_req_cate_cd")=="S"){
        		formObj.stv_dmg_req_cate_cd[1].checked = true;
        	}
            
            
			if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="U"){
				comboObjects[6].index = 2;
    			comboObjects[7].Code2 = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_cd");
    			formObj.res_reason_desc.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
			}else{				

				if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="T"){
					comboObjects[6].index = 0;
				}
				if(sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_kwn_cd")=="S"){
					comboObjects[6].index = 1;
				}
				
            	formObj.stv_dmg_respb_desc_dtl.value = sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_desc");
			}
			
			// Damage 화면의 입력가능 필드 설정.
            dmgFormObjControl(formObj, sheetObj, false);
			
            //Requirement Port 셋팅
            var tempReqPortCd = sheetObj.CellValue(thisRow, prefix+"req_port_cd");
            var tempReqEtaDt = sheetObj.CellValue(thisRow, prefix+"req_eta_dt");
            
            setReqPortCombo(strReqPortComboList);
            if(strReqPortComboList != ""){
        		for(var i=0 ; i < comboObjects[4].GetCount() ; i++){
        			if(tempReqPortCd == comboObjects[4].GetIndexText(i, 0) && tempReqEtaDt == comboObjects[4].GetIndexText(i, 2)){
        				formObj.req_port_cd.value = tempReqPortCd;
        				formObj.req_eta_dt.value = tempReqEtaDt;
        				comboObjects[4].Index2 = i;
        				combo_req_port_cd_OnChange(comboObjects[4], tempReqPortCd, tempReqPortCd);
        				break;
        			}
        		}
            } else {
            	formObj.req_port_cd.value = tempReqPortCd;
                formObj.req_eta_dt.value = tempReqEtaDt;
            }
	
            formObj.dmg_upd_dt.value 			= sheetObj.CellValue(thisRow, prefix+"upd_dt");
            formObj.dmg_upd_usr_id.value		= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
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
            //Groupware 의 Office Code 중 6자리보다 클 경우 제외하고 저장한다 
        	for(var i=0 ; i<sheetObjects[15].RowCount ; i++){
        		if(sheetObjects[15].CellValue(i, "sheet20_clm_hndl_ofc_cd").length > 6){
        			sheetObjects[15].RowDelete(i, false);
        		}
        	}
			setClaimHandlingUser(sheetObj);
		}
    }
     
      
 	/* Responsible Party 값에 따른 Claim Handling Office, Claim Handling User 후속 작업
 	 * 
 	 */
 	function setResponsiblePartyBehind(event, flg) {
 		var formObj = document.form;
 		var sheetObj = sheetObjects[0];
// 		alert("event:"+event+"flg:"+flg);
 		switch(event) {
 			case "Search":
 				if(flg) {
 					sheetObjects[17].Editable = false;
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#F3F2F8");//E9E9E9
 				}else {
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
 				}
 				
 				break;
 			case "OnChange":
 				sheetObjects[17].Editable = true;
 				if(flg) {
 					formObj.clm_hndl_ofc_cd.value = "";
 					formObj.clm_hndl_ofc_cd.className = "input2";
 					sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
 					sheetObjects[17].RemoveAll();
 					sheetObjects[15].RemoveAll();
 					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#F3F2F8");
// 					btnImgEnable(formObj.clm_hndl_ofc_cd_pop, false);
 				}else {
 					if(doActionIBSheet(sheetObj,formObj,COMMAND03)){
 						//Claim Handling User
 		   				if(formObj.clm_hndl_ofc_cd.value != "" && unKnownFlg){
 		   					sheetObjects[17].RowDelete(1, false);
 		   					sheetObjects[17].DataInsert(-1);
 		   					sheetObjects[17].SelectBackColor = sheetObjects[17].WebColor("#CCFFFD");
 		   				}
// 		   				btnImgEnable(formObj.clm_hndl_ofc_cd_pop, true);
 					}
 				}
 				break;
 		}
 		unKnownFlg = flg;
 		return;
 	}  
 	 
 	 /**
      * Category Combo Data 선택시 Part Combo List에 해당 Data Set. <br>
      **/
     function stv_dmg_prt_cate_cd_OnChange(comboObj, idx_cd, text) {

     	var formObj = document.form;
     	var sheetObj = sheetObjects[1];
     	
     	sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_prt_cate_cd") = comboObj.Code;
     	
     	if(!isNull(comboObj.Code)){

 	    	// 선택된 Category에 해당하는 Part Code 가져오기.
 	    	formObj.f_cmd.value = SEARCH03;
 	    	var categoryPartXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
 	    	var categoryPart = ComGetEtcData(categoryPartXml, "catePart");
 	    	
 	    	if(categoryPart==null || categoryPart.length<1){
     			ComShowCodeMessage("OPF50009", "Part Code");
 	    		comboObjects[2].RemoveAll();
 	    		return false;
 	    	}else{
 	    		setComboItem2(comboObjects[2], categoryPart);
 	    		formObj.stv_dmg_prt_cate_cd.focus();
 	    	}
     	}else{
     		comboObjects[2].RemoveAll();
     		formObj.stv_dmg_prt_cate_cd.focus();
     	}
 		sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_prt_cd") = "";
     } 	
     
     function combo_req_port_cd_OnChange(comboObj, idx_cd, text) {
     	var formObj = document.form;
     	
     	formObj.req_port_cd.value = comboObj.Code;
     	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_port_cd") = formObj.req_port_cd.value;
     	formObj.req_eta_dt.value = comboObj.GetIndexText(comboObj.Index, 2);
     	sheetObjects[1].CellValue(sheetObjects[1].SelectRow, "sheet2_req_eta_dt") = formObj.req_eta_dt.value;
     }
   
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[1], comboItem[0]);
        	}
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem2(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1], comboItem[0]);
        	}
    	}
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function setComboItem3(comboObj,comboItems) {
    	comboObj.RemoveAll();
    	if(!isNull(comboItems)){
    		var dataList = comboItems.split("|");
        	
        	for (var i = 0 ; i < dataList.length ; i++) {
        		
        		var comboItem = dataList[i].split(",");
        		//comboObj.InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[1]);
        		comboObj.InsertItem(i, comboItem[1]+"|"+comboItem[2], comboItem[1]);
        	}
    	}
    }
    

	/**
	 * 팝업 IBSheet에 업로드하고자 선택한 파일들을 IBUpload로 추가한다.
	 * File Upload..
	 **/
	function setFileUpload(popSheetObj, stvDmgAtchFileTpCd, stvDmgProcCd) {
		 
		return; 
	}
	 
	/**
	 * 업로드용 Hidden IBSheet의 정보를 가져온다.
	 **/
	function getFileUpload(strFlag, stvDmgProcCd) {
		if(stvDmgProcCd == "D"){
			if(strFlag=="SDR"){
				return sheetObjects[6];
			}else if(strFlag=="PIC"){
				return sheetObjects[7];
			}else if(strFlag=="DOC"){
				return sheetObjects[8];
			}
		}else if(stvDmgProcCd == "R"){
			if(strFlag=="RES"){
				return sheetObjects[9];
			}else if(strFlag=="INV"){
				return sheetObjects[10];
			}else if(strFlag=="PIC"){
				return sheetObjects[11];
			}else if(strFlag=="DOC"){
				return sheetObjects[12];
			}
		}else if(stvDmgProcCd == "S"){
			if(strFlag=="INV"){
				return sheetObjects[13];
			}else if(strFlag=="DOC"){
				return sheetObjects[14];
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
		var sheetID = sheetObj.id;

        switch(sheetID) {

            case "sheet1":
                with (sheetObj) {

                    //높이 설정
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
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|VSL_CD|SKD_VOY_NO|SKD_DIR_CD|VPS_PORT_CD|STV_DMG_EVNT_DT|VSL_OSHP_CNTR_BLK_TP_CD|STV_DMG_REF_NO|CLM_HNDL_OFC_CD|DMG_AUTH_STS_CD|AUTH_USR_ID|AUTH_DT|UPD_USR_ID|UPD_DT|CRE_USR_ID";
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
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_voy_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"skd_dir_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vps_port_cd",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_evnt_dt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"vsl_oshp_cntr_blk_tp_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_ref_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_ofc_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"dmg_auth_sts_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"auth_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cre_usr_id",			false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet2":
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
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_PRT_CATE_CD|STV_DMG_PRT_CD|STEVEDORE DAMAGE TYPE CODE|STV_DMG_LOC_DESC|STV_DMG_RPT_ATCH_FLG|STV_DMG_PICT_ATCH_FLG";
                    HeadTitle += "|STV_DMG_DOC_ATCH_FLG|CNTR_DMG_FLG|CGO_DMG_FLG|CNTR_NO|FM_TM_LSS_DT|TO_TM_LSS_DT|STV_DMG_RMK|STV_DMG_REQ_CATE_CD|REQ_VSL_CD|REQ_SKD_VOY_NO";
                    HeadTitle += "|REQ_SKD_DIR_CD|REQ_PORT_CD|REQ_ETA_DT|STV_DMG_QTTN_CD|STV_DMG_QTTN_RSN_DESC|STV_DMG_RESPB_PTY_KWN_CD|STV_DMG_RESPB_CD|STV_DMG_RESPB_DESC|UPD_USR_ID|UPD_DT";
                    HeadTitle += "|stv_dmg_rpt_atch_knt|stv_dmg_pict_atch_knt|stv_dmg_doc_atch_knt";
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
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
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
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  				false,	"",		dfNone,		0,	true,	true);

                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rpt_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_pict_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_doc_atch_knt",	false,	"",		dfNone,		0,	true,	true);
				}
                break;
                
            case "sheet3":
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
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_RPR_SEQ|STV_DMG_RPR_PROC_STS_CD|QTTN_LOCL_CURR_CD|QTTN_COST_LOCL_AMT|QTTN_COST_USD_AMT|RPR_PORT_CD|RPR_DT";
                    HeadTitle += "|RPR_VNDR_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|RPR_COST_USD_AMT|RPR_RSLT_RPT_ATCH_FLG|RPR_INV_ATCH_FLG|RPR_PICT_ATCH_FLG|RPR_DOC_ATCH_FLG";
                    HeadTitle += "|RPR_RMK|UPD_USR_ID|UPD_DT";
                    HeadTitle += "|rpr_rslt_rpt_atch_knt|rpr_inv_atch_knt|rpr_pict_atch_knt|rpr_doc_atch_knt";
                    
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
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  			false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtDataSeq,	30,	daCenter,	false,	prefix+"stv_dmg_rpr_seq");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_rpr_proc_sts_cd",  	false,	"",		dfNone,		0,	true,	true);
                    //InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_cost_usd_amt",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_locl_curr_cd",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_cost_locl_amt",  		false,	"",		dfFloat,	2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"qttn_cost_usd_amt",  		false,	"",		dfFloat,	2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_port_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_dt",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_vndr_nm",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"ustl_acct_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"run_rpr_acct_no",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_cost_usd_amt",  		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rslt_rpt_atch_flg",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_inv_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_pict_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_doc_atch_flg",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rmk",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  					false,	"",		dfNone,		0,	true,	true);
                    
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_rslt_rpt_atch_knt",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_inv_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_pict_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"rpr_doc_atch_knt",  		false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet4":
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
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|STV_DMG_CMPN_PROC_STS_CD|CLM_HNDL_OFC_CD|CLM_HNDL_USR_ID|CLM_HNDL_USR_NM|STV_DMG_RESPB_PTY_CO_NM|STV_DMG_RESPB_PTY_PIC_NM|STV_DMG_RESPB_PTY_PIC_TIT_NM|STV_DMG_CMPN_DT|CMPN_CURR_CD|CMPN_COST_LOCL_AMT|CMPN_COST_USD_AMT|CMPN_ACCT_NO|CMPN_RMK|UPD_USR_ID|UPD_DT";
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
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  					false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_cmpn_proc_sts_cd",  	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_ofc_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_usr_id",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"clm_hndl_usr_nm",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_co_nm",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_pic_nm",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_respb_pty_pic_tit_nm",  false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_cmpn_dt",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_curr_cd",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_cost_locl_amt",  			false,	"",		dfFloat,		2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_cost_usd_amt",  			false,	"",		dfFloat,		2,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_acct_no",  				false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"cmpn_rmk",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",  					false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",  						false,	"",		dfNone,		0,	true,	true);
                    
				}
                break;
                
            case "sheet5":
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
                    InitRowInfo(1, 1, 3, 100);
                    
                    var HeadTitle = "|STV_DMG_NO|SHP_OWNR_CO_NM|USTL_ACCT_NO|RUN_RPR_ACCT_NO|BIL_INV_NO|PAY_DT|PAY_CURR_CD|PAY_LOCL_AMT|PAY_USD_AMT|STL_INV_ATCH_FLG|STL_DOC_ATCH_FLG|STL_RMK|UPD_USR_ID|UPD_DT|stl_inv_atch_knt|stl_doc_atch_knt";
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    var prefix="sheet5_";
                    InitDataProperty(0, cnt++ , dtStatus, 30,	daCenter,	false,	prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stv_dmg_no",  		false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"shp_ownr_co_nm",	false,	"",		dfNone,		0,	false,	false);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"ustl_acct_no",  	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"run_rpr_acct_no",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"bil_inv_no",  		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_dt",  			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_curr_cd",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_locl_amt",		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"pay_usd_amt",		false,	"",		dfFloat,	0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stl_inv_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	30,		daLeft,		true,	prefix+"stl_doc_atch_flg",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_rmk",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_usr_id",		false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"upd_dt",			false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_inv_atch_knt",	false,	"",		dfNone,		0,	true,	true);
                    InitDataProperty(0, cnt++ , dtData,	90,		daLeft,		true,	prefix+"stl_doc_atch_knt",	false,	"",		dfNone,		0,	true,	true);
				}
                break;
                
            case "sheet7":
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
                    var prefix="sheet7_";
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
                
            case "sheet8":
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
                    var prefix="sheet8_";
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

            case "sheet9":
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
                    var prefix="sheet9_";
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

            case "sheet10":
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
                    var prefix="sheet10_";
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
                
            case "sheet11":
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
                    var prefix="sheet11_";
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
                
            case "sheet12":
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
                    var prefix="sheet12_";
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
                
            case "sheet13":
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
                    var prefix="sheet13_";
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

            case "sheet14":
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
                    var prefix="sheet14_";
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
                
            case "sheet15":
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
                    var prefix="sheet15_";
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
              	
         	case "sheet20":	//Claim Handling User
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
              	
         	case "sheet21":	//Claim Handling User
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

                     var HeadTitle = "|Name|1|2|3|4|5|6|7|8|9|10|11|12|13|14";
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
				
    	      case COMMAND03:
    	    	  var port_cd = formObj.vps_port_cd.value;
    	    	  formObj.f_cmd.value = COMMAND03;
    	    	  var resultXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do?f_cmd="+COMMAND03+"&vps_port_cd="+port_cd);
    	    	  var ofcCd = ComGetEtcData(resultXml, "ofcCd");
    	    	  //Claim Handling Office
    	    	  if(ofcCd != null){
					  formObj.clm_hndl_ofc_cd.value = ofcCd;
					  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_clm_hndl_ofc_cd") = ofcCd;
	    	    	  return true;
    	    	  }
    	    	  break;
    	    	   	    	  
    	      case IBSEARCH:      //조회
    	    	  var sheetID = sheetObj.id;
    	    	  
    	    	  if(strFlag=="All"){
    	    		  	formObj.f_cmd.value = SEARCH;
    	    		  	
    	    		  	uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
    	    		  	
    	    	    	var aryPrefix = new Array("sheet1_","sheet2_","sheet3_","sheet4_","sheet5_", "sheet7_", "sheet8_", "sheet9_", "sheet10_", "sheet11_", "sheet12_", "sheet13_", "sheet14_", "sheet15_", "sheet20_");
    	  	    		var sXml = sheetObj.GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&stv_dmg_proc_cd=D" + "&" + ComGetPrefixParam(aryPrefix));
    	  	    		var arrXml = sXml.split("|$$|");
    	              	
    	              	if (arrXml.length > 0) {
    	              		sheetObjects[0].LoadSearchXml(arrXml[0]);
    	              		firstReqPortComboList = ComGetEtcData(arrXml[0], "reqPortComboList");
    	              	}   	              	
    	              	
    	              	if (arrXml.length > 1) sheetObjects[1].LoadSearchXml(arrXml[1]);
    	              	if (arrXml.length > 2) sheetObjects[2].LoadSearchXml(arrXml[2]);
    	              	if (arrXml.length > 3) sheetObjects[3].LoadSearchXml(arrXml[3]);
    	              	if (arrXml.length > 4) sheetObjects[4].LoadSearchXml(arrXml[4]);
    	              	
    	              	if (arrXml.length > 5) sheetObjects[6].LoadSearchXml(arrXml[5]);
    	              	if (arrXml.length > 6) sheetObjects[7].LoadSearchXml(arrXml[6]);
    	              	if (arrXml.length > 7) sheetObjects[8].LoadSearchXml(arrXml[7]);

    	              	if (arrXml.length > 8) sheetObjects[9].LoadSearchXml(arrXml[8]);
    	              	if (arrXml.length > 9) sheetObjects[10].LoadSearchXml(arrXml[9]);
    	              	if (arrXml.length > 10) sheetObjects[11].LoadSearchXml(arrXml[10]);
    	              	if (arrXml.length > 11) sheetObjects[12].LoadSearchXml(arrXml[11]);

    	              	if (arrXml.length > 12) sheetObjects[13].LoadSearchXml(arrXml[12]);
    	              	if (arrXml.length > 13) sheetObjects[14].LoadSearchXml(arrXml[13]);
    	              	
    	              	//Default ComboData Set..
    	              	setDefaultComboData(arrXml[0]); 	              	
    	              	    	              	
    	              	//Claim Handling User 셋팅
    	              	if (arrXml.length > 14) {
    	              		sheetObjects[15].LoadSearchXml(arrXml[14]);
    	              		sheetObjects[16].LoadSearchXml(arrXml[14]);
    	              		
    	   					//2011.11.10 UnKnown 일 경우 처리
    	  					if(sheetObj.CellValue(sheetObj.SelectRow, "sheet2_stv_dmg_respb_pty_kwn_cd") == "U") {
    	  						setResponsiblePartyBehind("Search", true);
    	  					}else {
    	  						sheetObjects[17].RowDelete(1, false);
    	  	   					sheetObjects[17].DataInsert(-1);
    	  	   					
    	  						setResponsiblePartyBehind("Search", false);
    	  					}
    	              		
    	              		setClaimHandlingUser(sheetObjects[17]);
    	              	}
    	              	
    	              	//Repair Default Currency Set..
    	              	dfCurrency = ComGetEtcData(arrXml[0], "defaultCurrency");
    	    	  }
    	    	  else if(sheetID=="sheet1"){
    	    		  //alert("222"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH01;
    	    		  sheetObjects[0].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
    	    		  setDisplayData(formObj, "Dmg", "");
    	    	  }
    	    	  else if(sheetID=="sheet2"){
    	    		  //alert("333"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH02;
    	    		  var sXml = sheetObjects[1].GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_"));
    	    		  sheetObjects[1].LoadSearchXml(sXml);
    	    		  
    	    		  setDisplayData(formObj, "Dtl", "");
    	    	  }
    	    	  else if(sheetID=="sheet3"){
    	    		  //alert("444"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH03;
    	    		  sheetObjects[2].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
    	    		  if(sheetObjects[2].RowCount > 0){
        	    		  setRprDisplayData(formObj);
    	    		  }else{
    	    			  initDefaultSheet(formObj, "Rpr");
    	    			  // Grid Data를 화면에 Set..
    	                  setRprDisplayData(formObj);
    	    		  }
    	    	  }
    	    	  else if(sheetID=="sheet4"){
    	    		  //alert("555"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH04;
    	    		  sheetObjects[3].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet4_"));
    	    		  if(sheetObjects[3].RowCount > 0){
    	    			  setCmpnDisplayData(formObj);
    	    		  }else{
    	    			  initDefaultSheet(formObj, "Cmpn");
    	    			  // Grid Data를 화면에 Set..
    	    			  setCmpnDisplayData(formObj);
    	    		  }
    	    	  }
    	    	  else if(sheetID=="sheet5"){
    	    		  //alert("666"+sheetID);
    	    		  formObj.f_cmd.value = SEARCH05;
    	    		  sheetObjects[4].DoSearch("VOP_OPF_1053GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet5_"));
    	    		  if(sheetObjects[4].RowCount > 0){
    	    			  setStlDisplayData(formObj);
    	    		  }
    	    		  else{
    	    			  //initDefaultSheet(formObj, "Stl");
    	    			  setStlDatareadOnly(formObj);
    	    		  }
    	    	  }
    	        break;
    	        
    	      case IBROWSEARCH:
    	    	  if(strFlag=="dmgDate"){
    	    		  formObj.f_cmd.value = SEARCH06;
    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do" , FormQueryString(formObj));
    	    		  
    	    		  var etdDate = ComGetEtcData(dateXml, "etd_date");
    	    		  
    	    		  if(isNull(etdDate)){
    	    			  //ComShowMessage("ETD DB Data is not exist.");
    	      			  ComShowCodeMessage("OPF50009", "ETD DB Data");
  						  return;
    	    		  }else{
    	    			  var dateFlag = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, etdDate);
    	    			  if(dateFlag < 0){
    	    				  //ComShowMessage("Damage Date must be earlier than ETD Date("+etdDate+").");
        	      			  ComShowCodeMessage("OPF50013", "ETD Date("+etdDate+")", "Damage Date");
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_evnt_dt") = "";
        	    			  formObj.stv_dmg_evnt_dt.value = "";
        	    			  formObj.stv_dmg_evnt_dt.focus();
        	    			  return false;
    	    			  }
    	    			  else{
    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_evnt_dt") = formObj.stv_dmg_evnt_dt.value;
    	    				  formObj.vsl_oshp_cntr_blk_tp_cd.focus();
    	    			  }
    	    		  }
    	    	  }
//    	    	  if(strFlag=="etaDate"){
//    	    		  formObj.f_cmd.value = SEARCH06;
//    	    		  var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//    	    		  var dirCode = formObj.req_skd_voy_dir.value.substring(4);
//    	    		  //var port = formObj.req_port_cd.value;
//    	    		  var port = comboObjects[44].Code;
//    	    		  var dateXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?skd_voy_no="+voyNo+"&skd_dir_cd="+dirCode+"&vps_port_cd="+port , FormQueryString(formObj));
//    	    		  
//    	    		  var etaDate = ComGetEtcData(dateXml, "eta_date");
//    	    		  
//    	    		  if(isNull(etaDate)){
//    	    			  //ComShowMessage("ETA DB Data is not exist.");
//    	      			  //ComShowCodeMessage("OPF07001", "ETA DB Data");
//  						  return;
//    	    		  }else{
//    	    				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_req_eta_dt") = etaDate;
//    	    				  formObj.req_eta_dt.value = etaDate;
//    	    		  }
//    	    	  }
    	    	  else if(strFlag=="ClmHndlOfc"){
    	    		  formObj.f_cmd.value = SEARCH07;
    	    		  //var ofcXml = sheetObj.GetSearchXml("COM_ENS_071GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  var ofcXml = sheetObj.GetSearchXml("VOP_OPF_0052GS.do?ofc_cd="+formObj.clm_hndl_ofc_cd.value, FormQueryString(formObj));
    	    		  //alert(ofcXml);
    	    		  var ofcArr = ComOpfXml2Array(ofcXml, "ofc_cd");
    	    		  //alert(ofcArr);
    	    		  if(isNull(ofcArr) || ofcArr.length < 1){
    	    			  //ComShowMessage("등록되지 않은 Office CD 입니다.");
    	      			  ComShowCodeMessage("OPF50004", "Data");
    	      			  sheetObjects[0].CellValue(sheetObjects[0].SelectRow, "sheet1_clm_hndl_ofc_cd") = "";
    	    			  formObj.clm_hndl_ofc_cd.value = "";
    	    			  formObj.clm_hndl_ofc_cd.focus();
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
    	    	  
    	    	  //2011.1.7 진마리아 delete 로직 변경
    	      case IBDELETE:
    	    	  formObj.f_cmd.value = REMOVE;
    	    	  var deleteParam = ComGetSaveString(sheetObj);
    	    	  deleteParam = deleteParam +"&"+ FormQueryString(formObj);
    	    	  var tabNo = tabObjects[0].SelectedIndex;
//    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), deleteParam);
    	    	  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", "del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no") + "&tabNo=" + tabNo + deleteParam);//"&fcmd=REMOVE");
    	    	  //sheetObj.DoSave("VOP_OPF_0052GS.do?del_stv_dmg_no="+sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj), -1,false);
    	    	  break;

    	 
    	        
    	      case IBSAVE:        //저장
    	    	  if(strFlag=="Approval"){
    	    		  var stvDmgNo = sheetObj.CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no");
    	    		  
    	    		  formObj.dmg_auth_sts_cd.value = "Y";
    	    		  formObj.auth_usr_id.value     = userId;
      				  formObj.auth_dt.value         = ComGetNowInfo("ymd");
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_dmg_auth_sts_cd") = "Y";
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_usr_id")     = userId;
      				  sheetObj.CellValue(sheetObj.SelectRow, "sheet1_auth_dt")         = ComGetNowInfo("ymd");
    	    		  
    	    		  formObj.f_cmd.value = MODIFY01;
          	          sheetObj.DoAllSave("VOP_OPF_0052GS.do?stv_dmg_no="+stvDmgNo, FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet1_"));
      				  formObj.dmg_auth_sts_cd.className = "input2";
      				  document.getElementById("btnApproval").style.color="#c0c0c0";
                	  
          	          break;
    	    	  }
    	    	  else{
    	    		  var sheetID = sheetObj.id;
    	    		  
    	    		  var uploadObj = uploadObjects[0];
    	    		  
    	    		  if(sheetID=="sheet1"){
    	    			  if(isTrue(validateForm(sheetObj,formObj))){
    	    				  // 하단의 Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet1_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.dmg_upd_usr_id.value		= userId;
          	    	    	  formObj.dmg_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
          	    	    	  //...............................................................................//
    	    				  
          	    	    	  setClaimHandlingUserStatus("I");
          	    	    	  
    	    				  formObj.f_cmd.value = MULTI01;
    	    				  var prefixs = new Array("sheet1_","sheet2_","sheet20_");
    	    				  var sParam = ComGetSaveString(sheetObj);
    	    				  sParam += "&" + ComGetSaveString(sheetObjects[1], true);
    	    	    		  sParam += "&" + ComGetSaveString(sheetObjects[15], true);
    	    	    		  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);
//                  	          sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs), -1,false);
    	    				  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
    	    				  sheetObj.LoadSaveXml(saveXml);
    	    				  saveXml = ComDeleteMsg(saveXml);//저장완료 메세지 삭제 
    	    	              sheetObjects[1].LoadSaveXml(saveXml);
    	    				  
    	    				  //Claim Handling User 셋팅
    	    				  setClaimHandingUserSheetSync("R");
    	    				  setClaimHandlingUser(sheetObjects[17]);
    	    				  
    	    	    	  }
    	    			  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet2"){
        	    		  if(isTrue(validateForm(sheetObj,formObj))){
        	    			  setClaimHandlingUserStatus("I");

        	    			  formObj.f_cmd.value = MULTI02;
        	    			  var sParam = ComGetSaveString(sheetObj);
            	    		  var fParam1 = ComGetSaveString(sheetObjects[6], true);
            	    		  var fParam2 = ComGetSaveString(sheetObjects[7], true);
            	    		  var fParam3 = ComGetSaveString(sheetObjects[8], true);
            	    		  var fParam4 = ComGetSaveString(sheetObjects[15], true);

        	    			  var prefixs = new Array("sheet2_","sheet7_","sheet8_","sheet9_","sheet20");
        	    			  // Upload Sheet Data를 Query String에 추가..
        	    			  sParam += "&" + fParam1;
        	    			  sParam += "&" + fParam2;
        	    			  sParam += "&" + fParam3;
        	    			  sParam += "&" + fParam4;
        	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

        	    			  //파일 업로드 추가, 삭제 갯수
        	    			  var fileUploadCount = sheetObjects[6].RowCount("I") + sheetObjects[6].RowCount("D");
        	    			  fileUploadCount += sheetObjects[7].RowCount("I") + sheetObjects[7].RowCount("D");
        	    			  fileUploadCount += sheetObjects[8].RowCount("I") + sheetObjects[8].RowCount("D");
        	    			   
        	    			  // 하단의 Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet2_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.dmg_upd_usr_id.value		= userId;
          	    	    	  formObj.dmg_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.dmg_upd_dt);
          	    	    	  //...............................................................................//
          	    	    	  
            	    		  if(uploadObj.LocalFiles==""){ 
        	    			  //if( fileUploadCount == 0) {
            	    			  //1. 업로드할 파일이 없을때=> DB정보만 변경.
            	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  
                	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  }
            	    		  else{
            	    			  //1. 업로드할 파일이 있을때=> 파일업로드 & DB정보 변경.
                	    		  uploadObj.ExtendParam = sParam;
                       		      uploadObj.ParamDecoding = true;
                       		      
                       		      var saveXml = uploadObj.DoUpload(true);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  ComDeleteMsg(saveXml);
                	    		  uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
            	    		  }        	    			  
            	              formObj.f_cmd.value = SEARCH09;
                    	      sheetObjects[6].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=SDR&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet7_"));
                    	      sheetObjects[7].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet8_"));
                    	      sheetObjects[8].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=D&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet9_"));
                    	      
                    	      //Claim Handling User 셋팅
    	    				  setClaimHandingUserSheetSync("R");
    	    				  setClaimHandlingUser(sheetObjects[17]);
        	    			  
            	    	  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet3"){
        	    		  if(isTrue(rprValidateForm(formObj))){
            	    		  //formObj.f_cmd.value = MULTI03;
            	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet3_"), -1,false);
            	    		  
        	    			  formObj.f_cmd.value = MULTI03;
        	    			  var sParam = ComGetSaveString(sheetObj);
            	    		  var fParam1 = ComGetSaveString(sheetObjects[9], true);
            	    		  var fParam2 = ComGetSaveString(sheetObjects[10], true);
            	    		  var fParam3 = ComGetSaveString(sheetObjects[11], true);
            	    		  var fParam4 = ComGetSaveString(sheetObjects[12], true);
            	    		  var fParam5 = ComGetSaveString(sheetObjects[15], true);

        	    			  var prefixs = new Array("sheet3_","sheet10_","sheet11_","sheet12_","sheet13_","sheet20_");
        	    			  // Upload Sheet Data를 Query String에 추가..
        	    			  sParam += "&" + fParam1;
        	    			  sParam += "&" + fParam2;
        	    			  sParam += "&" + fParam3;
        	    			  sParam += "&" + fParam4;
        	    			  sParam += "&" + fParam5;
        	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

        	    			  //파일 업로드 추가, 삭제 갯수
        	    			  var fileUploadCount = sheetObjects[9].RowCount("I") + sheetObjects[9].RowCount("D");
        	    			  fileUploadCount += sheetObjects[10].RowCount("I") + sheetObjects[10].RowCount("D");
        	    			  fileUploadCount += sheetObjects[11].RowCount("I") + sheetObjects[11].RowCount("D");
        	    			  fileUploadCount += sheetObjects[12].RowCount("I") + sheetObjects[12].RowCount("D");
        	    			  
        	    			// 하단의 Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet3_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet3_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.rpr_upd_usr_id.value		= userId;
          	    	    	  formObj.rpr_upd_dt.value 			= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.rpr_upd_dt);
          	    	    	  //alert("uploadObj.LocalFiles:"+uploadObj.LocalFiles);
            	    		  if(uploadObj.LocalFiles==""){
        	    			  //if( fileUploadCount == 0) {
            	    			  //1. 업로드할 파일이 없을때=> DB정보만 변경.
            	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  
                	    		  saveXml = ComDeleteMsg(saveXml);
            	    		  }
            	    		  else{
            	    			  //1. 업로드할 파일이 있을때=> 파일업로드 & DB정보 변경.
                	    		  uploadObj.ExtendParam = sParam;
                       		      uploadObj.ParamDecoding = true;
                       		      
                       		      var saveXml = uploadObj.DoUpload(true);
                	    		  sheetObj.LoadSaveXml(saveXml);
                	    		  ComDeleteMsg(saveXml);
                	    		  uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
            	    		  } 
            	              formObj.f_cmd.value = SEARCH09;
                    	      sheetObjects[9].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=RES&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet10_"));
                    	      sheetObjects[10].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet11_"));
                    	      sheetObjects[11].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=PIC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet12_"));
                    	      sheetObjects[12].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=R&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet13_"));
                    	      

            	    		  
        	    		  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet4"){
        	    		  if(isTrue(cmpnValidateForm(formObj))){
            	    		  formObj.f_cmd.value = MULTI04;
            	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_"), -1,false);
            	    		  //setCmpnDisplayData(formObj);
            	    		  var sParam = ComGetSaveString(sheetObj);
            	    		  sParam = sParam +"&"+ FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet4_");
            	    		  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
            	    		  
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_ofc_cd") = ComGetEtcData(saveXml, "clmHndlOfc");
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_usr_id") = ComGetEtcData(saveXml, "clmHndlUsrId");
            	    		  sheetObj.CellValue(sheetObj.SelectRow, "sheet4_clm_hndl_usr_nm") = ComGetEtcData(saveXml, "clmHndlUsrNm");
            	    		  setCmpnDisplayData(formObj);
            	    		  // 하단의 Update UserID/Date Setting.............................................//
                  	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet4_upd_usr_id") = userId;
          	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet4_upd_dt")     = ComGetNowInfo("ymd");
          	                  formObj.cmpn_upd_usr_id.value		= userId;
          	    	    	  formObj.cmpn_upd_dt.value 		= ComGetNowInfo("ymd");
          	    	    	  ComAddSeparator(formObj.cmpn_upd_dt);
          	    	    	  //...............................................................................//
            	    		  
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  
                    	      claimHandlingOfc = ( formObj.clm_hndl_ofc_cd.value == officeCd ? true : false );  
                    		  claimed = ( formObj.stv_dmg_cmpn_proc_sts_cd[1].checked ? true : false );
                    		  authPermission ( 2 );
        	    		  }
        	    		  else{
    	    				  return false;
    	    			  }
        	    	  }
        	    	  else if(sheetID=="sheet5"){
        	    		  //formObj.f_cmd.value = MULTI05;
        	    		  //sheetObj.DoSave("VOP_OPF_1053GS.do", FormQueryString(formObj)+"&"+ComGetPrefixParam("sheet5_"), -1,false);
       	    		  
    	    			  formObj.f_cmd.value = MULTI05;
    	    			  var sParam = ComGetSaveString(sheetObj);
        	    		  var fParam1 = ComGetSaveString(sheetObjects[13], true);
        	    		  var fParam2 = ComGetSaveString(sheetObjects[14], true);

    	    			  var prefixs = new Array("sheet5_","sheet14_","sheet15_");
    	    			  // Upload Sheet Data를 Query String에 추가..
    	    			  sParam += "&" + fParam1;
    	    			  sParam += "&" + fParam2;
    	    			  sParam += "&" + FormQueryString(formObj)+"&"+ComGetPrefixParam(prefixs);

    	    			  //파일 업로드 추가, 삭제 갯수
    	    			  var fileUploadCount = sheetObjects[13].RowCount("I") + sheetObjects[13].RowCount("D");
    	    			  fileUploadCount += sheetObjects[14].RowCount("I") + sheetObjects[14].RowCount("D");

        	    		  // 하단의 Update UserID/Date Setting.............................................//
              	          sheetObj.CellValue2(sheetObj.SelectRow, "sheet5_upd_usr_id") = userId;
      	    		      sheetObj.CellValue2(sheetObj.SelectRow, "sheet5_upd_dt")     = ComGetNowInfo("ymd");
      	                  formObj.stl_upd_usr_id.value		= userId;
      	    	    	  formObj.stl_upd_dt.value 			= ComGetNowInfo("ymd");
      	    	    	  ComAddSeparator(formObj.stl_upd_dt);
      	    	    	  //...............................................................................//
      	    	    	  
        	    		  if(uploadObj.LocalFiles==""){
    	    			  //if( fileUploadCount == 0) {
        	    			  //1. 업로드할 파일이 없을때=> DB정보만 변경.
        	    			  var saveXml = sheetObj.GetSaveXml("VOP_OPF_1053GS.do", sParam);
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  
            	    		  saveXml = ComDeleteMsg(saveXml);
        	    		  }
        	    		  else{
        	    			  //sheetObjects[4].RowStatus(1) = "U";
        	    			  
        	    			  //1. 업로드할 파일이 있을때=> 파일업로드 & DB정보 변경.
            	    		  uploadObj.ExtendParam = sParam;
                   		      uploadObj.ParamDecoding = true;
                   		      
                   		      var saveXml = uploadObj.DoUpload(true);
            	    		  sheetObj.LoadSaveXml(saveXml);
            	    		  ComDeleteMsg(saveXml);
            	    		  uploadObjects[0].Files=""; // 기존파일을 모두 지운다.
            	    	  }
        	              formObj.f_cmd.value = SEARCH09;
                	      sheetObjects[13].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=INV&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet14_"));
                	      sheetObjects[14].DoSearch("VOP_OPF_1053GS.do?stv_dmg_proc_cd=S&stv_dmg_atch_file_tp_cd=DOC&stv_dmg_no="+sheetObjects[0].CellValue(sheetObj.SelectRow, "sheet1_stv_dmg_no"), FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet15_"));

        	    	  }
          	          break;
    	    	  }
     	         
    	    }
    	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj){
    	//alert("validation");
		
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
    	
    	var prefix = "sheet2_";
		 
        if(isNull(comboObjects[1].Code)){
         	//ComShowMessage("\'Category\' is mandatory item.");
			ComShowCodeMessage("OPF50009", "Category");
         	formObj.stv_dmg_prt_cate_cd.focus();
         	return false;
        }
        
        if(!unKnownFlg && sheetObjects[17].CellValue(1, "clm_hndl_usr_nm").length == 0){
			 ComShowCodeMessage("OPF50009", "Claim Handling User");
			 sheetObjects[17].SelectCell(1, "clm_hndl_usr_nm");
          	 return false;
		 }
        
        if(isNull(comboObjects[2].Code)){
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
			if(isNull(comboObjects[5].Code))
			{
				//ComShowMessage("\'Requirement- Reason\' is mandatory item.");
				ComShowCodeMessage("OPF50009", "Requirement- Reason");
				formObj.stv_dmg_qttn_rsn_desc.focus();
				return false;
			}
			else if(comboObjects[5].Code=="TXT" && isNull(formObj.req_reason_desc.value)){
				ComShowCodeMessage("OPF50009", "Requirement- Reason Description");
				formObj.req_reason_desc.focus();
				return false;
			}
		}
        else{
			if(isNull(formObj.req_skd_voy_dir.value))
			{
				//ComShowCodeMessage("OPF50009", "Requirement- Voyage No.");
				//formObj.req_skd_voy_dir.focus();
				//return false;
			}
			else{
				
//				//Voyage No. 데이터 조회.
//				formObj.f_cmd.value = SEARCH01;
//	    		var voyNo = formObj.req_skd_voy_dir.value.substring(0,4);
//	    		var dirCd = formObj.req_skd_voy_dir.value.substring(4);
//
//	    		var portXml2 = sheetObjects[1].GetSearchXml("VOP_OPF_0052GS.do?vps_port_cd=OrderBySeq&skd_voy_no="+voyNo+"&skd_dir_cd="+dirCd , FormQueryString(formObj));
//	    		//alert("asdf");
//	   	    	var strPortCdList2 = ComGetEtcData(portXml2, "vvdPortComboList");
//	   	    	if(isNull(strPortCdList2)){
//	    			//ComShowMessage("스케줄에 등록되지 않은 Voyage No.입니다.");
//	    			ComShowCodeMessage("OPF50004", "Data");
//	    			formObj.req_skd_voy_dir.value = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_voy_no") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_dir_cd") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_port_cd") = "";
//	    			sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_skd_voy_dir") = "";
////	    			comboObjects[44].RemoveAll();
//	    			formObj.req_skd_voy_dir.focus();
//	   	    		return false;
//	   	    	}
				
			}
			
//			if(isNull(comboObjects[44].Code))
//			{
//				//ComShowCodeMessage("OPF50009", "Port");
//				//formObj.req_port_cd.focus();
//				//return false;
//			}
			
			if(isNull(formObj.req_eta_dt.value))
			{
				//ComShowCodeMessage("OPF50009", "ETA");
				//formObj.req_eta_dt.focus();
				//return false;
			}
			else{
				
//				var dateFlag = ComGetDaysBetween(formObj.stv_dmg_evnt_dt.value, formObj.req_eta_dt.value);
//	  			if(dateFlag <= 0){
//	  				 //ComShowMessage("ETA Date must be later than Damage Date.");
//        			 ComShowCodeMessage("OPF50013", "ETA Date", "Damage Date");
//	  				 sheetObjects[1].CellValue(sheetObjects[1].SelectRow, prefix+"req_eta_dt") = "";
//		    		 formObj.req_eta_dt.value = "";
//		    		 formObj.req_eta_dt.select();
//		    		 return false;
//	  			}
				
			}
		}
        
		

        //return true;
    }

    /**
     * 입력된 값의 True/False 여부 리턴.
     */
    function isTrue(strValue)
    {
    	if(strValue+""=="false"){
    		return false;
    	}
    	else{
    		return true;
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
     * Damage Data Form Object Enable/Disable Control. <br>
     */
    function dmgFormObjControl(formObj, sheetObj, clickFlag){
    	var prefix = "sheet2_";
    	
    	if(formObj.stv_dmg_req_cate_cd[2].checked){
    		
    		if(clickFlag){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_voy_no") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_skd_dir_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_eta_dt") = "";
        		sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_port_cd") = "";
    		}
    		formObj.req_skd_voy_dir.value = "";
    		formObj.req_port_cd.value = "";
    		formObj.req_eta_dt.value = "";
    		formObj.req_skd_voy_dir.readOnly = true;
    		formObj.req_port_cd.readOnly = true;
    		formObj.req_eta_dt.readOnly = true;
    		formObj.req_skd_voy_dir.className = "input2";
    		formObj.req_port_cd.className = "input2";
    		formObj.req_eta_dt.className = "input2";
    		comboObjects[5].Enable = false;
    		if(comboObjects[5].Code=="TXT"){
    			formObj.req_reason_desc.readOnly == true;
        		formObj.req_reason_desc.className = "input1";
    		}
    		//formObj.stv_dmg_qttn_rsn_desc.focus();
    	}
    	else{
    		if(clickFlag){
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"req_vsl_cd") = formObj.vsl_cd.value;
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_qttn_cd") = "";
    			sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_qttn_rsn_desc") = "";
    		}
    		formObj.req_skd_voy_dir.readOnly = true;
    		formObj.req_eta_dt.readOnly = true;
    		formObj.req_skd_voy_dir.className = "input";
    		formObj.req_eta_dt.className = "input";
    		comboObjects[5].Index2 = "";
    		comboObjects[5].Enable = false;
    		formObj.req_reason_desc.value = "";
    		formObj.req_reason_desc.readOnly == true;
    		formObj.req_reason_desc.className = "input2";
    	}
    	
       	if(comboObjects[6].Code == "U"){

    		comboObjects[7].Enable = false;
    		 
			if(comboObjects[7].Code=="TXT"){
		
				formObj.res_reason_desc.readOnly = true;
	    		formObj.res_reason_desc.className = "input1"; // 파랑.
			}
			else {
				formObj.res_reason_desc.readOnly = true;
	    		formObj.res_reason_desc.className = "input2"; // 회색.
			}
    		
    		formObj.stv_dmg_respb_desc_dtl.value = "";
    		formObj.stv_dmg_respb_desc_dtl.readOnly = true;
    		formObj.stv_dmg_respb_desc_dtl.className = "input2"; //회색.			
    		
    	}
    	else
    	{	
    		formObj.res_reason_desc.value = "";
    		formObj.res_reason_desc.readOnly = true;
    		formObj.res_reason_desc.className = "input2";		//회색.
    		    		
    		formObj.stv_dmg_respb_desc_dtl.readOnly = true;
    		formObj.stv_dmg_respb_desc_dtl.className = "input"; //흰색
    		
			comboObjects[7].Enable = false;			

			if(clickFlag){
				sheetObj.CellValue(sheetObj.SelectRow, prefix+"stv_dmg_respb_desc") = "";
    		}			
    	}
       	
       	formObj.cntr_dmg_flg.disabled = true; 
       	formObj.cgo_dmg_flg.disabled = true;
       	
       	formObj.stv_dmg_req_cate_cd[0].disabled = true;
       	formObj.stv_dmg_req_cate_cd[1].disabled = true;
       	formObj.stv_dmg_req_cate_cd[2].disabled = true;
    	
    }
    
    // Repair Tab Control Start! ==========================================================//
    /**
     * 조회된 데이터 없을시 해당 Grid 및 화면 초기화. <br>
     **/
    function initDefaultSheet(formObj, sheetFlag){
    	var sheetObj = null;
    	var row = null;
    	if(sheetFlag=="Rpr"){
    		sheetObj = sheetObjects[2];
    		//sheetObj.RemoveAll();
    		row = sheetObj.DataInsert(-1);
    		sheetObj.CellValue(row, "sheet3_stv_dmg_no") = formObj.stv_dmg_no.value;
    		sheetObj.CellValue(row, "sheet3_stv_dmg_rpr_proc_sts_cd") = "O";
    		rprFormObjControl(formObj);
    		
    		comboObjects[8].Code = dfCurrency;
    		sheetObj.CellValue(row, "sheet3_qttn_locl_curr_cd") = dfCurrency;
    		sheetObj.CellValue(row, "sheet3_rpr_rslt_rpt_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_inv_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_pict_atch_flg") = "N";
    		sheetObj.CellValue(row, "sheet3_rpr_doc_atch_flg") = "N";
    		
    		setDisplaySeq(formObj, sheetObj);
    	}
    	else if(sheetFlag=="Cmpn"){
    		sheetObj = sheetObjects[3];
    		sheetObj.RemoveAll();
    		row = sheetObj.DataInsert();
    		sheetObj.CellValue(row, "sheet4_stv_dmg_no") = formObj.stv_dmg_no.value;
    		sheetObj.CellValue(row, "sheet4_stv_dmg_cmpn_proc_sts_cd") = "R";
    		
    		comboObjects[9].Code = dfCurrency;
    		//sheetObj.CellValue(row, "sheet4_cmpn_curr_cd") = dfCurrency;
    		
    		cmpnFormObjControl(formObj);
    	}
    }
    /**
     * Grid Data 화면에 Setting. <br>
     **/
    function setRprDisplayData(formObj){
    	var sheetObj = sheetObjects[2];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet3_";
    	
    	var statusCode = sheetObj.CellValue(thisRow, prefix+"stv_dmg_rpr_proc_sts_cd");
    	if(statusCode=="O"){
    		formObj.stv_dmg_rpr_proc_sts_cd[1].checked = true;
    		////[2009-10-14] 김종옥 수정 Ordered 저장 후 실행
    		//formObj.stv_dmg_rpr_proc_sts_cd[1].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[2].disabled = true;
    		//formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    	}else if(statusCode=="R"){
    		formObj.stv_dmg_rpr_proc_sts_cd[2].checked = true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_rpr_proc_sts_cd[3].checked = true;
    	}else if(statusCode=="Q"){
    		formObj.stv_dmg_rpr_proc_sts_cd[0].checked = true;
    	}
    	
    	// Status별 입력 가능 필드 설정.
    	rprFormObjControl(formObj);    	
  	
    	formObj.rpr_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"rpr_cost_usd_amt");
    	comboObjects[8].Code2			= sheetObj.CellValue(thisRow, prefix+"qttn_locl_curr_cd");
    	formObj.qttn_cost_locl_amt.value= sheetObj.CellText(thisRow, prefix+"qttn_cost_locl_amt");
    	formObj.qttn_cost_usd_amt.value = sheetObj.CellText(thisRow, prefix+"qttn_cost_usd_amt");
    	formObj.rpr_port_cd.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_port_cd");
    	formObj.rpr_dt.value 			= sheetObj.CellValue(thisRow, prefix+"rpr_dt");
    	formObj.rpr_vndr_nm.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_vndr_nm");
    	formObj.ustl_acct_no.value 		= sheetObj.CellValue(thisRow, prefix+"ustl_acct_no");
    	formObj.run_rpr_acct_no.value 	= sheetObj.CellValue(thisRow, prefix+"run_rpr_acct_no");
    	formObj.rpr_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"rpr_cost_usd_amt");
    	formObj.rpr_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"rpr_rmk");
    	formObj.rpr_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	formObj.rpr_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	
    	formObj.rpr_rslt_rpt_atch_knt.value = sheetObj.CellValue(thisRow, prefix+"rpr_rslt_rpt_atch_knt");
    	formObj.rpr_inv_atch_knt.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_inv_atch_knt");
    	formObj.rpr_pict_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"rpr_pict_atch_knt");
    	formObj.rpr_doc_atch_knt.value 		= sheetObj.CellValue(thisRow, prefix+"rpr_doc_atch_knt");

    	setDisplaySeq(formObj, sheetObj);
    	setRprTotalAmt(formObj, sheetObj);

    }

    /**
     * Display Sequence Set. <br>
     */
    function setDisplaySeq(formObj, sheetObj){
    	formObj.stv_dmg_rpr_seq.value = sheetObj.CellValue(sheetObj.SelectRow, "sheet3_stv_dmg_rpr_seq");
    	formObj.stv_dmg_rpr_seq_total.value = sheetObj.RowCount;
    }
    
    /**
     * Prev/Next 버튼의 화면이동 기능. <br>
     **/
    function moveScreen(sheetObj, formObj, moveSeq) {
    	
    	if( moveSeq==-1 && sheetObj.SelectRow==1 ){
        	//ComShowMessage("No more Previous Page.");
        	return false;
        }
        else if( moveSeq==1 && sheetObj.SelectRow==sheetObj.LastRow ){
        	
        	// 한번에 최대 1개 이상 Add 불가능.
        	var addFlag = true;
        	for(var i=1; i<=sheetObj.RowCount; i++){
        		//alert(sheetObj.RowStatus(i));
        		if(sheetObj.RowStatus(i)=="I"){
        			addFlag = false;
        		}
        	}
        	
        	if( ComIsBtnEnable("btn_Save")
        		&& addFlag
        		//&& isTrue(rprValidateForm(formObj))
        		//&& ComShowConfirm(ComGetMsg("OPF07011"))
        		)
        	{
        		//sheetObj.DataInsert();
        		initDefaultSheet(document.form, "Rpr");
        		// Grid Data를 화면에 Set..
                setRprDisplayData(formObj);
        	}else{
        		return false;
        	}
        }
        else{
        	//if(isTrue(rprValidateForm(formObj))){
        		sheetObj.SelectRow = sheetObj.SelectRow + moveSeq;
                // Grid Data를 화면에 Set..
                setRprDisplayData(formObj);
        	//}
        }
    }
    

    /* Compensation - USD AMT 가져옴 
     * curr_cd   : Curr Code
     * local_amt : Local Amt
     * obj       : 계산된 값 set 위치
     */
	function setCompensation_usd_amt(curr_cd, local_amt, obj){
		var formObj = document.form;
	   	formObj.f_cmd.value = SEARCH08;
		var sXml = sheetObjects[5].GetSearchXml("VOP_OPF_1053GS.do", FormQueryString(formObj));
		obj.value = ComGetEtcData(sXml, "usdAmt");
		
		sheetObjects[3].CellValue(sheetObjects[3].SelectRow, "sheet4_cmpn_cost_usd_amt") = obj.value;
	}    
    
  
    /**
     * Popup Data Validation Check. <br>
     **/
    function popEvent_rpr_port_cd(aryPopupData) {
    	
    	document.form.rpr_port_cd.value = aryPopupData[0][2];
    	sheetObjects[2].CellValue(sheetObjects[2].SelectRow, "sheet3_rpr_port_cd") = aryPopupData[0][2];
    }
    
    /**
     * Repair Total Amount calculate. <br>
     **/
    function setRprTotalAmt(formObj, sheetObj){
    	var amtTotal = 0;
    	for(i=1; i<= sheetObj.RowCount; i++){
    		//alert(sheetObj.CellValue(i, prefix+elementObj.name)+"|"+sheetObj.RowCount);
    		amtTotal += parseFloat(sheetObj.CellValue(i, "sheet3_rpr_cost_usd_amt"));
    		// 소수점 둘째자리 이하 반올림 처리.
    		//amtTotal = amtTotal.toFixed(2);
    	}
    	//alert(amtTotal);
    	formObj.rpr_cost_usd_amt_total.value = amtTotal;
    	ComAddSeparator(formObj.rpr_cost_usd_amt_total);
    }
    
    /**
     * Repair Data Form Object Enable/Disable Control. <br>
     **/
    function rprFormObjControl(formObj)
    {
    	if(formObj.stv_dmg_rpr_proc_sts_cd[1].checked)
    	{
    		//[2009-11-16 김종옥 수정] Ordered일 경우Ordered, Repairing, Quotation선택가능, Completed선택 불가
    		formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    		
			comboObjects[8].Enable = false;
			formObj.qttn_cost_locl_amt.readOnly = true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className  = "input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			
			formObj.rpr_port_cd.readOnly = true;
			formObj.rpr_dt.readOnly = true;
			formObj.rpr_vndr_nm.readOnly = true;
			formObj.rpr_port_cd.className  = "input1";
			formObj.rpr_dt.className  = "input1";
			formObj.rpr_vndr_nm.className  = "input1";
			
			formObj.ustl_acct_no.readOnly = true;
			formObj.run_rpr_acct_no.readOnly = true;
			formObj.rpr_cost_usd_amt.readOnly = true;
			formObj.ustl_acct_no.className  = "input2";
			formObj.run_rpr_acct_no.className  = "input2";
			formObj.rpr_cost_usd_amt.className  = "input2";
		}
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[2].checked 
        		|| formObj.stv_dmg_rpr_proc_sts_cd[3].checked)
    	{
    		
    		//[2009-11-16 김종옥 수정] Completed는 Repairing에서만 선택가능
   			formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = false;
    		
			comboObjects[8].Enable = false;
			formObj.qttn_cost_locl_amt.readOnly = true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className  = "input2";
			//formObj.qttn_cost_usd_amt.className = "input2";
			
			formObj.rpr_port_cd.readOnly = true;
			formObj.rpr_dt.readOnly = true;
			formObj.rpr_vndr_nm.readOnly = true;
			formObj.rpr_port_cd.className  = "input2";
			formObj.rpr_dt.className  = "input2";
			formObj.rpr_vndr_nm.className  = "input2";
			

			if(sheetObjects[1].CellValue(1, "sheet2_stv_dmg_respb_pty_kwn_cd")=="U"){
				formObj.ustl_acct_no.readOnly = true;
				formObj.run_rpr_acct_no.readOnly = true;
				formObj.ustl_acct_no.className  = "input2";
				formObj.run_rpr_acct_no.className  = "input";
			}
			else{
//				formObj.ustl_acct_no.readOnly = true;
//				formObj.run_rpr_acct_no.readOnly = true;
//				formObj.ustl_acct_no.className  = "input2";
//				formObj.run_rpr_acct_no.className  = "input";
				
				formObj.ustl_acct_no.readOnly = true;
				formObj.run_rpr_acct_no.readOnly = true;
				formObj.ustl_acct_no.className  = "input1";
				formObj.run_rpr_acct_no.className  = "input2";
			}
			formObj.rpr_cost_usd_amt.readOnly = true;
			formObj.rpr_cost_usd_amt.className  = "input1";
		}
    	else if(formObj.stv_dmg_rpr_proc_sts_cd[0].checked)
    	{
    		//[2009-11-16 김종옥 수정] Completed는 Repairing에서만 선택가능
    		formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;    		
    		
			comboObjects[8].Enable = false;
			formObj.qttn_cost_locl_amt.readOnly = true;
			//formObj.qttn_cost_usd_amt.readOnly = true;
			formObj.qttn_cost_locl_amt.className  = "input1";
			//formObj.qttn_cost_usd_amt.className = "input1";
			
			formObj.rpr_port_cd.readOnly = true;
			formObj.rpr_dt.readOnly = true;
			formObj.rpr_vndr_nm.readOnly = true;
			formObj.rpr_port_cd.className  = "input2";
			formObj.rpr_dt.className  = "input2";
			formObj.rpr_vndr_nm.className  = "input2";
			
			formObj.ustl_acct_no.readOnly = true;
			formObj.run_rpr_acct_no.readOnly = true;
			formObj.rpr_cost_usd_amt.readOnly = true;
			formObj.ustl_acct_no.className  = "input2";
			formObj.run_rpr_acct_no.className  = "input2";
			formObj.rpr_cost_usd_amt.className  = "input2";
		}
    	formObj.stv_dmg_rpr_proc_sts_cd[0].disabled = true;
    	formObj.stv_dmg_rpr_proc_sts_cd[1].disabled = true;
    	formObj.stv_dmg_rpr_proc_sts_cd[2].disabled = true;
    	formObj.stv_dmg_rpr_proc_sts_cd[3].disabled = true;
    }
    
    /**
     * Repair 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function rprValidateForm(formObj){
    	 var sheetObj = sheetObjects[2];
    	 var prefix = "sheet3_";
    	 
    	 for(var i=1; i<= sheetObj.LastRow; i++)
    	 {
    		 var moveRow = i - sheetObj.SelectRow;
    		 
    		 //[2009-10-13] 김종옥 수정
    		 //if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O" || sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
   			 if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="O")	 
    		 {
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_port_cd")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Port");
    				 formObj.rpr_port_cd.focus();
    				 return false;
    			 }
    			 else{
    				 // Repair Port Code Validation Check!
    				 formObj.f_cmd.value = COMMAND13;
	   	    		 var polXml = sheetObj.GetSearchXml("VOP_VSK_0043GS.do?op=0043&loc_cd="+sheetObj.CellValue(i, prefix+"rpr_port_cd") , FormQueryString(formObj));
	   	    		 var strPolCd = ComGetEtcData(polXml, "port_name");
	   	    		 if(isNull(strPolCd)){
		   	      		  if(moveRow != 0){
	       					  moveScreen(sheetObj, formObj, moveRow);
	       				  }
	   	      			  ComShowCodeMessage("OPF50004", "Data");
	   	    			  sheetObj.CellValue(i, "sheet3_rpr_port_cd") = "";
	   	    			  formObj.rpr_port_cd.value = "";
	   	    			  formObj.rpr_port_cd.focus();
	 					  return false;
	   	    		 }
    			 }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_dt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Date");
    				 formObj.rpr_dt.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"rpr_vndr_nm")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Vendor");
    				 formObj.rpr_vndr_nm.focus();
    				 return false;
    			 }
    		 }
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="R")
    		 {
    	         if( formObj.ustl_acct_no.className  == "input1" ){
        			 if(isNull(sheetObj.CellValue(i, prefix+"ustl_acct_no")))
        			 {
        				 if(moveRow != 0){
        					 moveScreen(sheetObj, formObj, moveRow);
        				 } 
        				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");//
        				 formObj.ustl_acct_no.focus();
        				 return false;
        			 }
    	         }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
    		 //[2009-10-13] 김종옥 수정
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="C")
    		 {
    			 if( formObj.ustl_acct_no.className  == "input1" ){
	    			 if(isNull(sheetObj.CellValue(i, prefix+"ustl_acct_no")))
	    			 {
	    				 if(moveRow != 0){
	    					 moveScreen(sheetObj, formObj, moveRow);
	    				 }
	    				 ComShowCodeMessage("OPF50009", "Unsettled Inter-Office Account No.");
	    				 formObj.ustl_acct_no.focus();
	    				 return false;
	    			 }
    			 }
    			 if(isNull(sheetObj.CellValue(i, prefix+"rpr_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Repair Total Amount");
    				 formObj.rpr_cost_usd_amt.focus();
    				 return false;
    			 }
    		 }
   			 
    		 else if(sheetObj.CellValue(i, prefix+"stv_dmg_rpr_proc_sts_cd")=="Q")
    		 {
    			 if(isNull(sheetObj.CellValue(i, prefix+"qttn_cost_usd_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation USD Amount");
    				 formObj.qttn_cost_usd_amt.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"qttn_locl_curr_cd")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Currency");
    				 formObj.qttn_locl_curr_cd.focus();
    				 return false;
    			 }
    			 else if(isNull(sheetObj.CellValue(i, prefix+"qttn_cost_locl_amt")))
    			 {
    				 if(moveRow != 0){
    					 moveScreen(sheetObj, formObj, moveRow);
    				 }
    				 ComShowCodeMessage("OPF50009", "Quotation Local Amount");
    				 formObj.qttn_cost_locl_amt.focus();
    				 return false;
    			 }
    		 }
    	 }
    	
    }
    // Repair Tab Control End! ============================================================//
    
    // Compensation Tab Control Start! =======================================================//
    /**
     * Grid Data 화면에 Setting. <br>
     **/
    function setCmpnDisplayData(formObj){
    	var sheetObj = sheetObjects[3];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet4_";
    	
    	var statusCode = sheetObj.CellValue(thisRow, prefix+"stv_dmg_cmpn_proc_sts_cd");
    	
    	if(statusCode=="R"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[0].checked = true;
    	}else if(statusCode=="C"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].checked = true;
    	}else if(statusCode=="N"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].checked = true;
    	}else if(statusCode=="A"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].checked = true;
    	}else if(statusCode=="J"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].checked = true;
    	}else if(statusCode=="P"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[5].checked = true;
    	}else if(statusCode=="E"){
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].checked = true;
    	}
    	if(sheetObjects[3].RowStatus(sheetObjects[3].SelectRow)=="R")
    	{
    		if(formObj.stv_dmg_cmpn_proc_sts_cd[0].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
        	}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[1].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked){
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[3].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = false;
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[4].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;
    		}
    		else if(formObj.stv_dmg_cmpn_proc_sts_cd[6].checked){
    			formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = false;
        		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
        		formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		}
    	}
    	else{
    		/*formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = false;
    		formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
			formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    		formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;*/
    	}
    	formObj.clm_hndl_ofc_cd_cmpn.value 			= sheetObj.CellValue(thisRow, prefix+"clm_hndl_ofc_cd");
    	formObj.clm_hndl_usr_id.value 				= sheetObj.CellValue(thisRow, prefix+"clm_hndl_usr_id");
    	formObj.clm_hndl_usr_name.value 			= sheetObj.CellValue(thisRow, prefix+"clm_hndl_usr_nm");
    	formObj.stv_dmg_respb_pty_co_nm.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_co_nm");
    	formObj.stv_dmg_respb_pty_pic_nm.value 		= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_nm");
    	formObj.stv_dmg_respb_pty_pic_tit_nm.value 	= sheetObj.CellValue(thisRow, prefix+"stv_dmg_respb_pty_pic_tit_nm");
    	formObj.stv_dmg_cmpn_dt.value 				= sheetObj.CellValue(thisRow, prefix+"stv_dmg_cmpn_dt");
    	//formObj.cmpn_curr_cd.value 			= sheetObj.CellValue(thisRow, prefix+"cmpn_curr_cd");
    	comboObjects[9].Code2				= sheetObj.CellValue(thisRow, prefix+"cmpn_curr_cd");
    	formObj.cmpn_cost_locl_amt.value 	= sheetObj.CellText(thisRow, prefix+"cmpn_cost_locl_amt");
    	formObj.cmpn_cost_usd_amt.value 	= sheetObj.CellText(thisRow, prefix+"cmpn_cost_usd_amt");
    	formObj.cmpn_acct_no.value 		= sheetObj.CellValue(thisRow, prefix+"cmpn_acct_no");
    	formObj.cmpn_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"cmpn_rmk");
    	formObj.cmpn_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	formObj.cmpn_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	
    	// Status별 입력 가능 필드 설정.
    	cmpnFormObjControl(formObj);
    	
    }
    
    /**
     * Compensation Data Form Object Enable/Disable Control. <br>
     **/
    function cmpnFormObjControl(formObj){
    	
    	if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked
			|| formObj.stv_dmg_cmpn_proc_sts_cd[3].checked
			|| formObj.stv_dmg_cmpn_proc_sts_cd[4].checked)
    	{
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input1";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input1";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input1";
    		
    		comboObjects[9].Enable = false;
    		formObj.stv_dmg_cmpn_dt.readOnly = true;
    		formObj.cmpn_cost_locl_amt.readOnly = true;
    		//formObj.cmpn_cost_usd_amt.readOnly = true;
    		formObj.cmpn_acct_no.readOnly = true;
    		formObj.stv_dmg_cmpn_dt.className = "input2";
    		formObj.cmpn_cost_locl_amt.className = "input2";
    		//formObj.cmpn_cost_usd_amt.className = "input2";
    		formObj.cmpn_acct_no.className = "input2";
    	}
    	else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
    		
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input2";
    		
    		comboObjects[9].Enable = false;
    		formObj.stv_dmg_cmpn_dt.readOnly = true;
    		formObj.cmpn_cost_locl_amt.readOnly = true;
    		//formObj.cmpn_cost_usd_amt.readOnly = true;
    		formObj.cmpn_acct_no.readOnly = true;
    		formObj.stv_dmg_cmpn_dt.className = "input1";
    		formObj.cmpn_cost_locl_amt.className = "input1";
    		//formObj.cmpn_cost_usd_amt.className = "input1";
    		formObj.cmpn_acct_no.className = "input1";
    	}
    	else{
    		formObj.stv_dmg_respb_pty_co_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_pic_tit_nm.readOnly = true;
    		formObj.stv_dmg_respb_pty_co_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_nm.className = "input2";
    		formObj.stv_dmg_respb_pty_pic_tit_nm.className = "input2";
    		
    		comboObjects[9].Enable = false;
    		formObj.stv_dmg_cmpn_dt.readOnly = true;
    		formObj.cmpn_cost_locl_amt.readOnly = true;
    		//formObj.cmpn_cost_usd_amt.readOnly = true;
    		formObj.cmpn_acct_no.readOnly = true;
    		formObj.stv_dmg_cmpn_dt.className = "input2";
    		formObj.cmpn_cost_locl_amt.className = "input2";
    		//formObj.cmpn_cost_usd_amt.className = "input2";
    		formObj.cmpn_acct_no.className = "input2";
    		
    	}
    	formObj.stv_dmg_cmpn_proc_sts_cd[0].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[1].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[2].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[3].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[4].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[5].disabled = true;
    	formObj.stv_dmg_cmpn_proc_sts_cd[6].disabled = true;
    	
    }
    
    /**
     * Compensation 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function cmpnValidateForm(formObj){
        
        if(formObj.stv_dmg_cmpn_proc_sts_cd[0].checked
        	|| formObj.stv_dmg_cmpn_proc_sts_cd[1].checked
        	|| formObj.stv_dmg_cmpn_proc_sts_cd[6].checked)
        {
		}
        else if(formObj.stv_dmg_cmpn_proc_sts_cd[2].checked
        		|| formObj.stv_dmg_cmpn_proc_sts_cd[3].checked
        		|| formObj.stv_dmg_cmpn_proc_sts_cd[4].checked)
        {
        	if(isNull(formObj.stv_dmg_respb_pty_co_nm.value))
			{
				//ComShowMessage("[Company] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Company");
				formObj.stv_dmg_respb_pty_co_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_co_nm);
				return false;
			}
        	else if(isNull(formObj.stv_dmg_respb_pty_pic_nm.value))
			{
				//ComShowMessage("[Name] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Name");
				formObj.stv_dmg_respb_pty_pic_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_pic_nm);
				return false;
			}
        	else if(isNull(formObj.stv_dmg_respb_pty_pic_tit_nm.value))
			{
				//ComShowMessage("[Title] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Title");
				formObj.stv_dmg_respb_pty_pic_tit_nm.focus();
				//ComSetFocus(formObj.stv_dmg_respb_pty_pic_tit_nm);
				return false;
			}
        }
        else if(formObj.stv_dmg_cmpn_proc_sts_cd[5].checked){
        	if(isNull(formObj.stv_dmg_cmpn_dt.value))
			{
				//ComShowMessage("[Compensation Date] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Date");
				formObj.stv_dmg_cmpn_dt.focus();
				//ComSetFocus(formObj.stv_dmg_cmpn_dt);
				return false;
			}
        	else if(isNull(comboObjects[9].Code))
			{
				//ComShowMessage("[Compensation Local Currency] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Local Currency");
				formObj.cmpn_curr_cd.focus();
				//ComSetFocus(formObj.cmpn_curr_cd);
				return false;
			}
        	else if(isNull(formObj.cmpn_cost_locl_amt.value))
			{
				//ComShowMessage("[Compensation Local Amount] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Local Amount");
				formObj.cmpn_cost_locl_amt.focus();
				return false;
			}
        	else if(isNull(formObj.cmpn_cost_usd_amt.value))
			{
				//ComShowMessage("[Compensation USD Amount] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation USD Amount");
				formObj.cmpn_cost_usd_amt.focus();
				//ComSetFocus(formObj.cmpn_cost_usd_amt);
				return false;
			}
        	else if(isNull(formObj.cmpn_acct_no.value))
			{
				//ComShowMessage("[Compensation Inter-Office No] is mandatory item.");
    			ComShowCodeMessage("OPF50009", "Compensation Inter-Office No");
				formObj.cmpn_acct_no.focus();
				//ComSetFocus(formObj.cmpn_acct_no);
				return false;
			}
        }
        //return true;
    }
    // Compensation Tab Control End! =========================================================//
    
    // Settlement Tab Control Start! ==========================================================//
    /**
     * Grid Data 화면에 Setting. <br>
     **/
    function setStlDisplayData(formObj){
    	var sheetObj = sheetObjects[4];
    	var thisRow = sheetObj.SelectRow;
    	var prefix = "sheet5_";
    	
    	formObj.shp_ownr_co_nm.value 		= sheetObj.CellValue(thisRow, prefix+"shp_ownr_co_nm");
    	formObj.ustl_acct_no_stl.value 		= sheetObj.CellValue(thisRow, prefix+"ustl_acct_no");
    	formObj.run_rpr_acct_no_stl.value 	= sheetObj.CellValue(thisRow, prefix+"run_rpr_acct_no");
    	formObj.bil_inv_no.value 			= sheetObj.CellValue(thisRow, prefix+"bil_inv_no");
    	formObj.pay_dt.value 				= sheetObj.CellValue(thisRow, prefix+"pay_dt");
    	formObj.pay_curr_cd.value 			= sheetObj.CellValue(thisRow, prefix+"pay_curr_cd");
    	formObj.pay_locl_amt.value 		= sheetObj.CellText(thisRow, prefix+"pay_locl_amt");
    	formObj.pay_usd_amt.value 		= sheetObj.CellText(thisRow, prefix+"pay_usd_amt");
    	formObj.stl_inv_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stl_inv_atch_knt");
    	formObj.stl_doc_atch_knt.value 	= sheetObj.CellValue(thisRow, prefix+"stl_doc_atch_knt");
    	formObj.stl_rmk.value 			= sheetObj.CellValue(thisRow, prefix+"stl_rmk");
    	formObj.stl_upd_dt.value 		= sheetObj.CellValue(thisRow, prefix+"upd_dt");
    	formObj.stl_upd_usr_id.value 	= sheetObj.CellValue(thisRow, prefix+"upd_usr_id");
    	
    }    
  
    /**
     * 조회된 Data 없을시 Form Object readOnly 처리. <br>
     **/
    function setStlDatareadOnly(formObj) {
    	
    	formObj.pay_curr_cd.readOnly = true;
    	formObj.pay_locl_amt.readOnly = true;

        //ComBtnDisable("btn_Save");
    }
    // Settlement Tab Control End! ============================================================//

    	
    /**
     * data 전체 조회. <br>
     **/
    function dataSearch(){
		// 조회.
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "All");

		//[PIC of Claim Handling Office] 가져옴.
        doActionIBSheet(sheetObjects[5],document.form, IBROWSEARCH, "MailContentPic");
		ComOpenWait(false);
		
		// OPF_STV_DMG 정보 Update 가능 여부 적용.
//		comboObjects[A].Enable = false;
		comboObjects[0].Enable = false;
		comboObjects[1].Enable = false;

		
		if(sheetObjects[2].RowCount > 0){
			setRprDisplayData(document.form);
		}else{
			

			initDefaultSheet(document.form, "Rpr");
			// Grid Data를 화면에 Set..
			
			//alert("01");  sheet0 , clm_hndl_usr_nm : sheetObjects[15]
            setRprDisplayData(document.form);
            //alert("09");
		}
		
//		alert("glusrName:"+glusrName);
//		sheetObjects[17].CellValue2(1, "clm_hndl_usr_nm") = glusrName;
		
		if(sheetObjects[3].RowCount > 0){
			setCmpnDisplayData(document.form);
		}else{
			initDefaultSheet(document.form, "Cmpn");
			// Grid Data를 화면에 Set..
			setCmpnDisplayData(document.form);
		}
		if(sheetObjects[4].RowCount > 0){
			setStlDisplayData(document.form);
		}else{
			//initDefaultSheet(document.form, "Stl");
			setStlDatareadOnly(document.form);
		}
		//alert("10");
		
		// 가져온 Data 화면에 Set.
		setDisplayData(document.form, "", firstReqPortComboList);

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
    	var sXml = ComOpfSheet2Xml(sheetObjects[15]);
//        alert("부모창getSheetXml:"+sXml);
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
//    	alert("부모창setSheetXml:"+sXml);
		sheetObjects[15].LoadSearchXml(sXml);
		var tempStr = sheetObjects[0].CellValue(1, "sheet1_stv_dmg_no");
		for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
			sheetObjects[15].CellValue2(i, "sheet20_stv_dmg_no") = tempStr;
			sheetObjects[15].CellValue2(i, "sheet20_stv_dmg_proc_cd") = "D";
			sheetObjects[15].RowStatus(i) = "I";
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
		for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
			if(i == sheetObjects[15].RowCount)
				usrName = usrName + sheetObjects[15].CellValue(i, "sheet20_clm_hndl_usr_nm");
			else
				usrName = usrName + sheetObjects[15].CellValue(i, "sheet20_clm_hndl_usr_nm")+", ";
		}

		sheetObj.CellValue2(1, "clm_hndl_usr_nm") = usrName;
		glusrName = usrName;

    }
    
	/**
	 * Claim Handling User 의 Update 유무를 판별한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function checkClaimHandlingUser(){
    	var sheetObj15 = sheetObjects[15];
    	var sheetObj16 = sheetObjects[16];
    	var sheet15Rc = sheetObj15.RowCount;
    	var sheet16Rc = sheetObj16.RowCount;
    	if(sheet15Rc != sheet16Rc){
    		return true;
    	}
    	for(var i=1 ; i<=sheet15Rc ; i++){
    		var val15 = sheetObj15.CellValue(i, "sheet20_clm_hndl_usr_id");
    		var idx = sheetObj16.FindText("sheet20_clm_hndl_usr_id", val15);
    		if(idx == -1){
    			return true;
    		}
    	}
    	return false;    	
    }
    
	/**
	 * Claim Handling User 의 hidden sheet 를 동기화한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function setClaimHandingUserSheetSync(sts){
    	var sheetObj15 = sheetObjects[15];
    	for(var i=1 ; i<=sheetObj15.RowCount ; i++){
    		sheetObj15.RowStatus(i) = sts;
    	}
    	var sXml = getSheetXml();
    	sheetObjects[16].LoadSearchXml(sXml);
    }
    
	/**
	 * Tab 에 따라 Claim Handling User 의 hidden sheet 필드 값을 변경한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @version 2011.10.06
	 */
    function setClaimHandlingUserProcChange(procCd){
    	var sheetObj15 = sheetObjects[15];
    	for(var i=1 ; i<=sheetObj15.RowCount ; i++){
    		sheetObj15.CellValue2(i, "sheet20_stv_dmg_proc_cd") = procCd;
    	}
    	setClaimHandingUserSheetSync("I");
    }
    
    /**
     * Port ComboObject 셋팅
     * @param strReqPortComboList
     * @return
     */
    function setReqPortCombo(strReqPortComboList){
    	var formObj = document.form;
 		if(strReqPortComboList != ""){
         	var dataList = strReqPortComboList.split("|");
         	for (var i = 0 ; i < dataList.length ; i++) {   
         		var comboItem = dataList[i].split(",");			
             		comboObjects[4].InsertItem(i, comboItem[0]+"|"+comboItem[1]+"|"+comboItem[2], comboItem[0]);
         	}
  			document.all.item("inputReqPortCd").style.display = "none"; 
  			document.all.item("comboReqPortCd").style.display = "inline";
  			formObj.req_eta_dt.readOnly = true;
  			formObj.req_eta_dt.className = "input2";
  		 }else{
  			//수기 입력
  			document.all.item("comboReqPortCd").style.display = "none";
     		document.all.item("inputReqPortCd").style.display = "inline";
     		formObj.req_eta_dt.readOnly = true;
     		formObj.req_eta_dt.className = "input";
  		 }
    }
    
    function setClaimHandlingUserStatus(sts){
		//Claim Handling User 변경 없이 타 정보 수정시 셋팅
		if(!checkClaimHandlingUser()){
			for(var i=1 ; i<=sheetObjects[15].RowCount ; i++){
	   			sheetObjects[15].RowStatus(i) = sts;
	   		}
		}
	}
	/* 개발자 작업  끝 */