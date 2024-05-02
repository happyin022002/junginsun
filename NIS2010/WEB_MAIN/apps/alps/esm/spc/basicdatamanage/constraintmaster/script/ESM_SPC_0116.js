/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0116.js
*@FileTitle : Compulsory Firm / ESM_BKG_0102 을 복사함.
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.02
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.02.02 김성욱
* 1.0 Creation
* 
* 2015.06.26 Title/Navigation, 디자인 변경
* 2015.07.06[CHM-201536749]Mastertable Import기능 오류 수정 CR에 반영(Revenue Management System 추가 보완 개발 요청 선반영 포함 - CMPB 팝업 연결)
* 2015.07.15 [CHM-201537094]MAS CMB 산출 로직 변경 적용에 묶어서 처리 - Candidated Confirm 항목 BKG NO 빨강으로 표시(한줄일때 back color 인지 안됨), 팝업 더블클릭시 수행되도록 수정
* 2015.07.29 S->F 추가, 틀고정 추가, Customer Name 추가
* 2015.07.30 S->F시 Confirm user id, date 보이고, 나머지는 안보이게, report item 설정시 hidden되는거 수정, create Date 기준 SB BKG조회조건 추가
* 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(7.30내용 포함)
* 2015.08.27 CHM-201537700 SB BKG management에서 Cancel BKG인지 요청
* 			 (BKG조회시 주차 조건 무시, 'S'일때만 B.Check Save, Reprocess, Standby -> Frim 기능 버튼 활성화 기능도 추가함)
* 2015.09.02 이혜민 standby booking management에서 reprocess시 같은 조건으로 수행중일때 동일 reprocess 못하도록 alert 띄워줌.
* 2015.09.24 이진서 trade 제약조건 풀어줌 
* 2016.01.07 week 추가, SC/RFA 검색조건 추가, RPT Form 에 항목4개 추가
* 2016.03.17 Stand by BKG MGMT에 대한 Reprocess 정리 및 보완
* 2016.07.12 Reprocess Logic 보완 사항
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
     * @class ESM_SPC_0116 : ESM_SPC_0116 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0116() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
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

    //검색이 이루어 지고 난 후 값을 저장해 둔다.
    // sheet title 이 가변적이라 값을 가지고 있다가 컬럼이 재 설정 되면 재 검색 하지 않고 처리하기 위함.
    var sXml = '';
    
    //RPT Form 용
    var reportFormPopupCallCnt = 0;
    var reportFormID = "ESM_SPC_0116";
    
    //Sheet 의 Header Text, cell의 save name
    var titleData = "";
    var saveNameData = "";
    
    var backendJobCond = "";
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
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
					
				case "btn_Reprocess":
					doActionIBSheet(sheetObjects[0],formObject,MODIFY01);
					break;
			
				case "btn_BranchSave":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
					
				case "btn_New":
					sheetObject1.RemoveAll();
//					formObject.reset();
					document.form.reset();
					
					break;						

		        case "btn_StandbyToFirm":
					doActionIBSheet(sheetObjects[0], formObject, MODIFY02);
	              	break;
	              	
		        case "btn_downexcel":
					doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL);
					
        	    case "btns_calendar":
        	        // 달력 팝업
        	        var cal = new ComCalendarFromTo();
        	        cal.select(formObject.f_sdate,formObject.f_edate, 'yyyy-MM-dd');
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
	    if( isWindow != "Y" ){
    		window.resizeTo(1100,630);
    		document.getElementById("naviTxt").innerHTML = "";
    	}
		for(var i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		

	    //IBMultiCombo초기화
	    for(var k = 0; k < comboObjects.length; k++){
	        initCombo(comboObjects[k], k + 1);
	    }

		
		SpcSearchOptionYear("f_year");
    	SpcSearchOptionWeek("f_week");
		SpcSearchOptionTrade("f_trd_cd", true, true);
    	SpcSearchOptionSubTrade("f_sub_trd_cd", true, false);
    	SpcSearchOptionLane("f_rlane_cd", true, true);
    	SpcSearchOptionBound("f_dir_cd",false,true,false);
    	
    	var rtn = getCodeXmlList("CommonCode", "codeNo=CD03403");   	
		var obj  = document.getElementById("f_sb_rsn_tp_cd");
		
    	ComXml2ComboItem(rtn, obj, "code", "code|text");
    	obj.InsertItem(0, "|ALL");
    	
//        if (arrData != null){
//            arrData[0] = " |" + arrData[0];
//            arrData[1] = " |" + arrData[1];
//        }
//        
//		//이전에 만들어진 Report 목록 가져오기
//		var text = arrData[1].split("|");
//		var code = arrData[0].split("|");
		
//
//		for (var i = 0; i < code.length ; i++) {
//			newOpt       = document.createElement("OPTION");
//			newOpt.text  = text[i];
//			newOpt.value = code[i];
//			obj.add(newOpt);
//		}
		initControl();

		/**
		 * Main화면으로 들어올때와 PopUp 화면으로 들어올때 사용자 권한 컨트롤
		 * 
		 * 점소 : Branch Save 버튼 활성화
		 * 본사, 지역본부 : reprocess, standby->Firm 버튼 활성화
		 * 
		 * 지역본부, 점소에서 들어올 경우 L.OFC에 정보를 입력해 준다
		 */

		var formObj = document.form;
		var ofc_lvl;
		var login_usr_lvl = formObj.f_level.value;
		var orgOfc = formObj.f_org_ofc_cd.value;
		if( orgOfc != "" ) {
			// Main 화면에서 넘어온 Office 정보의 level을 조회한다.
			var param = "&f_cmd="+SEARCH01+"&ofc_cd="+orgOfc;
			sXml = sheetObjects[0].GetSearchXml("ESM_SPC_0116GS.do" , param);
			ofc_lvl = ComGetEtcData(sXml, "ofc_level");
		}

		
		if( ofc_lvl == "1" || (orgOfc == "" && login_usr_lvl == "1")){
			formObj.f_level.value = "1";
			ComBtnDisable("btn_BranchSave");
			
		} else if( ofc_lvl == "2" || (orgOfc == "" && login_usr_lvl <= "2" )) {
			formObj.f_level.value = "2";
			ComBtnDisable("btn_BranchSave");
			//ComBtnDisable("btn_Reprocess");
			//ComBtnDisable("btn_StandbyToFirm");
			if(orgOfc != ""){
				formObj.f_ofc_cd.value     = orgOfc;
				formObj.f_sls_ofc_cd.value = orgOfc;
			} else {
				formObj.f_sls_ofc_cd.value = formObj.f_ofc_cd.value;
			}
			
		} else {
			formObj.f_level.value = "3";
			ComBtnEnable("btn_BranchSave");
			ComBtnDisable("btn_Reprocess");
			ComBtnDisable("btn_StandbyToFirm");
			if(orgOfc != ""){
				formObj.f_ofc_cd.value     = orgOfc;
				formObj.f_sls_ofc_cd.value = orgOfc;
			} else {
				formObj.f_sls_ofc_cd.value = formObj.f_ofc_cd.value;
			}
			
		}
		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		if( formObj.f_vvd_cd.value != "" ) {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}

		document.form.f_vvd_cd.focus();
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
        axon_event.addListenerFormat('keypress','spc0116_keypress',formObject); //- 키보드 입력할때
        axon_event.addListener('keydown', 'ComKeyEnter', 'form');        
        axon_event.addListenerForm  ('beforedeactivate', 'spc0116_deactivate',  formObject); //- 포커스 나갈때     
        axon_event.addListenerFormat('beforeactivate', 'spc0116_activate',    formObject); //- 포커스 들어갈때
        axon_event.addListenerForm('change', 'spc0116_change', formObject); // change
        axon_event.addListenerForm ('click', 'spc0116_onClick', formObject);
    }   
    
	
    /**
     * IBCOMBO를 초기화하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *
     * </pre>
     * @param {ibsheet} comboObj 필수 IBMultiCombo Object
     * @param {int} comboNo 필수 IBMultiCombo의 순번
     * @return 없음
     * @version 2016.01.08
     */ 
 	function initCombo(comboObj, comboNo) {
 	    switch(comboObj.id) {
 	        case "f_bkg_ctrt_tp_cd":
 	            with(comboObj) {
 	            	DropHeight = 260;
 	            	MultiSelect = false;
 	            	MaxSelect = 1;
 	            	InsertItem(0, "RFA","R");
 	            	InsertItem(1, "S/C","S");
 	            	Index = 0; 	            	
 	            }
 	            break;
 	       case "f_aloc_sts_cd":
	            with(comboObj) {
	            	DropHeight = 260;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	     	   		InsertItem(-1, 'F|Firm', 'F');
	     	   		InsertItem(-1, 'S|Standby', 'S');
	     	   		InsertItem(-1, 'S->F|Standby->Firm', 'S->F'); //S->F 추가, BKG시스템의 코드라서 공통코드에 추가 불가함
	     	   		InsertItem(-1, 'S->X|Standby->Cancel', 'S->X'); //S->X 추가
	     	   		InsertItem(-1, 'A|Attention', 'A'); //Attention
	     	   		InsertItem(-1, 'X|Cancel', 'X'); //Cancel
	     	   		Code2 = "S" 	            	
	            }
	            break;
 	       case "f_sb_rsn_tp_cd":
	            with(comboObj) {
	            	DropHeight = 80;
	            	MultiSelect = false;
	            	MaxSelect = 1;
	            	setTitle("Code|Name");
	            	SetColWidth("30|100");
	            }
	            break;	           
 	    }
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
                    style.height = GetSheetHeight(18) ;//352;
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
                    
                    //Salse Rep comfirm Flag
					var HeadTitle1 = " |Sel.|cnddt_cfm_flg|Brc.|No.|Rev\nWEEK|Booking No.|BKG\nSTS|Standby|Standby|Standby|Standby";
					var HeadTitle2 = " |Sel.|cnddt_cfm_flg|Brc.|No.|Rev\nWEEK|Booking No.|BKG\nSTS|STS|Type|Reason|SVC Type";
					var HT1_END = "|Q’ty|Q’ty|Total TEU|Initial\nCMPB|MAS\nCMPB|Estimated\nCMPB|BKG\nCreation Date|Confirm\nUsr|Confirm\nDate|Remark| |";
					var HT2_END = "|FEU|TEU|Total TEU|Initial\nCMPB|MAS\nCMPB|Estimated\nCMPB|BKG\nCreation Date|Confirm\nUsr|Confirm\nDate|Remark| |";
					
					// 서버에서 미리 세팅된  RPT Form 의 값으로 Title 세팅하는 로직 필요 ==
					// 서버에서 받아온 값
//					titleData = "";//"RHQ|Type|Sub Trade|T.Lane|Trunk POL|Trunk POD|PRO LOC|POR NODE|CMDT Code|CMDT Name|Charge(OFT)";
					var titleDAry = titleData.split("|");
					var saveNameDAry = saveNameData.split("|");
					var DataCnt = titleDAry.length
					
					if( titleData.length == 0 )
						DataCnt -= 1;
					
					var rightCnt = -1;
					var widthCnt = -1;
					
					for( var x=0 ; x<DataCnt ; x++ ) {
//						if( titleDAry[x] != '' ) {
							HeadTitle1 += "|"+titleDAry[x];
							HeadTitle2 += "|"+titleDAry[x];
							if( rightCnt == -1  && titleDAry[x].indexOf("Charge" ) > -1 )
								rightCnt = x;
							if( widthCnt == -1 && titleDAry[x].indexOf("CMDT Name" ) > -1 )
								widthCnt = x;
//						}
					}
					////////////////////////////////////////////// 여기까지
					
					HeadTitle1 += HT1_END;
					HeadTitle2 += HT2_END;
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //[SORT=true,COLUMNMOVE=false,ALLCHECK=true,USERRESIZE=true]
                    InitHeadMode(true, false, true, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,		"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox	,	40,     daCenter,    	true,     	"cfm_flg",				false,    		"",      dfNone, 			0,  true,		false);
					InitDataProperty(0, cnt++ , dtHidden	,	40,     daCenter,    	true,     	"cnddt_cfm_flg",		false,    		"",      dfNone, 			0,  true,		false);
					InitDataProperty(0, cnt++ , dtCheckBox	,	40,     daCenter,    	true,     	"cfm_rqst_flg",			false,    		"",      dfNone, 			0,  true,		false);
					InitDataProperty(0, cnt++ , dtSeq,			50,		daCenter,		true,		"seq");

					InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		"yr_mon_wk",			false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			95,		daCenter,		true,		"bkg_no",				false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,		true,		"bkg_sts_cd",			false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		"aloc_sts_cd",			false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		"standby_type",			false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			300,	daLeft,			true,		"standby_reason",		false,			"",      dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"aloc_svc_cd",			false,			"",      dfNone,			0,	false,		false);
					
					//, c_cust, a_cust, cmdt_cd, cmdt_desc, cnee, fwdr
					// 서버에서 미리 세팅된  RPT Form 의 값 세팅
					var isLeftStr = false;
					for( var x=0 ; x<DataCnt ; x++ ) {
						if(saveNameDAry[x] == "c_cust_nm" ||saveNameDAry[x] == "a_cust_nm" ||saveNameDAry[x] == "cmdt_desc" ||saveNameDAry[x] == "cnee_nm"||saveNameDAry[x] == "fwdr_nm") {
							InitDataProperty(0, cnt++ , dtData,			90,		daLeft,			true,		saveNameDAry[x],	false,			"",      dfNone,		0,		false,		false);
						} else if(saveNameDAry[x] == "cgo_rcv_dt"||saveNameDAry[x] == "bl_obrd_dt" ) {
							InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,		saveNameDAry[x],	false,			"",      dfNone,		0,		false,		false);
						} else {
							InitDataProperty(0, cnt++ , dtData,			90,		daCenter,		true,		saveNameDAry[x],	false,			"",      dfNone,		0,		false,		false);							
						}						
					}
					//////////////////////////////////////// 여기까지
					
					InitDataProperty(0, cnt++ , dtAutoSumEx,			50,		daRight,		true,		"feu",			false,			"",      dfFloatOrg,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSumEx,			50,		daRight,		true,		"teu",			false,			"",      dfFloatOrg,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,				70,		daRight,		true,		"total",		false,			"|feu|*2 + |teu|",      dfFloatOrg,		2,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoAvg,				70,		daRight,		true,		"init_cmpb",	false,			"",      dfFloatOrg,		2,		false,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoAvg,				70,		daRight,		true,		"mas_cmpb",		false,			"",      dfFloatOrg,		2,		false,		false,		false);
					InitDataProperty(0, cnt++ , dtAutoAvg,				70,		daRight,		true,		"cmpb",			false,			"",      dfFloatOrg,		2,		false,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		true,		"bkg_cre_dt",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		true,		"cfm_usr_id",	false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					100,	daCenter,		true,		"cfm_dt",		false,			"",      dfNone,			0,		false,		false);
					InitDataProperty(0, cnt++, dtData, 150, daLeft, true, "lst_sb_rmk", false, "", dfNone, 0, false, false, 4000);
//					InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		"ton",			false,			"",      dfNullFloat,		1,		false,		false);
					InitDataProperty(0, cnt++ , dtHidden ,   				10,    	daCenter,  		true,     	"dumy");
					InitDataProperty(0, cnt++ , dtHidden,   			30,    	daCenter,  		false,     	"bkg_no2");//S->F 로 변경시 필요한 값.

					CountPosition = 2;
					HeadRowHeight = 10;
                }
                break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				
				if(validateForm(sheetObj, formObj, sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					
					var bks = document.getElementById("f_aloc_sts_cd").Code;
//					if( bks == "F" ) {
//						sheetObj.ColHidden("cfm_usr_id") = false;
//						sheetObj.ColHidden("cfm_dt")     = false;
//					} else {
//						sheetObj.ColHidden("cfm_usr_id") = true;
//						sheetObj.ColHidden("cfm_dt")     = true;
//					}
					if( bks == "S" ) {
						sheetObj.ColHidden("cfm_usr_id") = true;
						sheetObj.ColHidden("cfm_dt")     = true;
					} else if( bks == "F" ) {
						sheetObj.ColHidden("cfm_usr_id") = true;
						sheetObj.ColHidden("cfm_dt")     = true;
					} else {
						sheetObj.ColHidden("cfm_usr_id") = false;
						sheetObj.ColHidden("cfm_dt")     = false;
					}
					sXml = sheetObj.GetSearchXml("ESM_SPC_0116GS.do" , FormQueryString(formObj));
					ComOpenWait(false); 
					
					sheetObj.LoadSearchXml(sXml);

				}
				break;

			case IBSAVE:        // B.Check Save
				if(validateForm(sheetObj, formObj, sAction)){
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					
					sheetObj.DoSave("ESM_SPC_0116GS.do",FormQueryString(formObj))
					ComOpenWait(false);
					
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
				break;
				
			case MODIFY01:      // Reprocess
				if(!validateForm(sheetObj, formObj, sAction)){
					return false;
				}

				ComOpenWait(true); 
				if(!ComShowConfirm(getMsg("SPC90302"))){
					ComOpenWait(false);
					break; // Do you want to Reprocess?
				}


				formObj.f_cmd.value = MODIFY01;

				var sParam = FormQueryString(formObj);				
  				var sParamSheet = sheetObj.GetSaveString();
  				if (sParamSheet != "") {
  					sParam = sParam + "&" + sParamSheet;
  				} 
  				  				
				var sXml = sheetObj.GetSaveXml("ESM_SPC_0116GS.do", sParam);
				
				
				if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "F" ){
					sheetObj.LoadSaveXml(sXml);
					ComOpenWait(false);
					return false;
			    }	
				
		        var BatchStatus = ComGetEtcData(sXml, "BatchStatus");  
				switch(BatchStatus){
					case "C": // 작업 submit (Create)	
					//	sheetObj.RemoveAll();  
						ComOpenWait(true);
				        ComBtnDisable("btn_Reprocess");
						monitoringBatchJob();
						break;
					case "R"://해당 작업이 진행 중 
						ComShowMessage("Batch is Processing...");
						ComOpenWait(false);  
						break;
					default: 
						ComOpenWait(false); 
						break;	
				}
			
			
				break;
/*			
			case MODIFY01:      // Reprocess
				if(validateForm(sheetObj, formObj, sAction)){
					//Reprocess 버튼 클릭 시 수행전 현재 같은 조건으로 Reprocess되고 있는 백엔드잡이 있는지 체크.
					//if(!checkReprocessCondition(sheetObj, formObj)) break;
					if(!ComShowConfirm(getMsg("SPC90302"))) break; // Do you want to Reprocess?
						 
					ComOpenWait(true);
					formObj.f_cmd.value = MODIFY01;
					
					var sXml = sheetObj.GetSaveXml("ESM_SPC_0116GS.do", FormQueryString(formObj));
					var backendJobKey = ComGetEtcData(sXml, "BackEndJobKey");
					if(ComGetEtcData(sXml, "isSuccess") == "Y"){
						ComShowMessage(getMsg("SPC90303")); // 'Job is starting.';
						//Reprocess 시작 시 해당조건을 삽입.
						//formObj.f_cmd.value = MODIFY03;
						//sheetObj.GetSaveXml("ESM_SPC_0116GS.do", FormQueryString(formObj));
						//backendJobCond = FormQueryString(formObj);
						//Backend job 상태 체크
						//if (backendJobKey != null && backendJobKey.length > 0) {
						//	ComSetObjValue(formObj.backendJobKey, backendJobKey);
						//	sheetObj.RequestTimeOut = 3600; //초 - 1시간
						//	backEndJobTimer = setInterval(getBackEndJobStatus, 2000);	//밀리초 = 2초
						//}
					
					}
					
					ComOpenWait(false); 
				}
				break;
*/				
			case MODIFY02:      //Stand by-> Firm 

				if(validateForm(sheetObj, formObj, sAction)){

					//Sheet에서 한 row 씩 처리 하도록 함.
					var chkRow = sheetObj.FindCheckedRow(1);
					if(chkRow == "") {
						ComShowMessage(getMsg("SPC13058")); // Document is not selected.
						break;
					}
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
				//	formObj.f_cmd.value = MODIFY02;

	     			var param = "?f_cmd=" + MODIFY02;
					var sXml = sheetObj.GetSaveXml("ESM_SPC_0116GS.do" + param+"&"+ComGetSaveString(sheetObj));
					sheetObj.LoadSearchXml(sXml);

/*
					var arrRow = chkRow.split("|");
	    	      	for (var idx=0; idx < arrRow.length-1; idx++) {
	    	     		if(sheetObj.CellValue(arrRow[idx],"cfm_flg") == "1"){
	    	     			//var param = "?f_cmd=" + MODIFY02 + "&aloc_sts_cd=F";
	    	     			var param = "?f_cmd=" + MODIFY02;
							var sXml = sheetObj.GetSaveXml("ESM_SPC_0116GS.do" + param+"&"+ComGetSaveString(sheetObj));
							if(ComGetEtcData(sXml, "isSuccess") != "Y"){
								sheetObj.LoadSearchXml(sXml);				
								break;
							}
	    	     		}
	    	      	}	
*/	    	      		    	      	
	//				ComOpenWait(false);

					if(ComGetEtcData(sXml, "isSuccess") == "Y"){
						ComShowMessage(getMsg("SPC13059")); //Data Firm Successfully.
						doActionIBSheet(sheetObj,formObj,IBSEARCH);
					}
					 
				}
				break;
				
			case IBRESET:          //Header 정보를 조회한다. report form combo 목록 선택시.
	             formObj.rpt_fom_nm.value = formObj.f_selgroup.text;
	             formObj.f_cmd.value = SEARCHLIST03;
	             
	             sheetObj.DoSearch4Post("ESM_SPC_0118GS2.do", FormQueryString(formObj));
	             titleData = sheetObj.EtcData("headerNM");
	             saveNameData = sheetObj.EtcData("header");
	             saveNameData = saveNameData.toLowerCase();
	             
	             formObj.f_header.value   = saveNameData;
	             formObj.f_headernm.value = titleData;
	             
	             sheetObj.RemoveEtcData();

	             initHeader(sheetObj, formObj);

	             break;
				
			//이전에 말들어둔 report form 목록조회
			case IBCLEAR:
		        	formObj.f_cmd.value = SEARCHLIST12;
		        	formObj.pgm.value = reportFormID;//'ESM_SPC_0116';//report upload
					var sXml = sheetObj.GetSearchXml("ESM_SPC_0118GS2.do", FormQueryString(formObj));
					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
					break;
					
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;
        }
    }

	/**
	 *조회 함수를 이용하여 조회가 완료되고 발생하는 Event
	 * @param sheetObj
	 * @param ErrMsg
	 */
	 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
         // Firm 될 대상일 경우 Row의 배경색을 다르게 표시한다
		 var row=0;
		 while((row = sheetObj.FindText("cnddt_cfm_flg", "1", row + 1)) > 0 ){
			 sheetObj.RowBackColor(row) = sheetObj.RgbColor(237,255,168);
			 sheetObj.CellFontColor(row,"bkg_no") = sheetObj.RgbColor(255, 0, 0);
		 }	
				
		 if(document.getElementById("f_aloc_sts_cd").Code == "S") {
			 while((row = sheetObj.FindText("aloc_sts_cd", "F", row + 1, 0)) > 0 ){
				 //sheetObj.RowEditable(row) = false;
				 if(sheetObj.CellValue(row, "aloc_sts_cd") == "F") {
					 //sheetObj.CellEditable(row,"cfm_flg") = false;
					 sheetObj.CellEditable(row,"cfm_rqst_flg") = false;
					 sheetObj.CellFont("FontUnderline", row, "bkg_no") = true;
				 } else if(sheetObj.CellValue(row, "aloc_sts_cd") == "Fs") {
					 sheetObj.CellFont("FontBold", row, "bkg_no") = true;
				 }
			 }	
		 }
	}
	    
	 
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		//공통사항
		//날짜관련 체크
		if(!ComIsNull(formObj.f_sdate) && !ComIsDate(formObj.f_sdate,"ymd")){
			formObj.f_sdate.focus();
			return false;
		}
		if(!ComIsNull(formObj.f_edate) && !ComIsDate(formObj.f_edate,"ymd")){
			formObj.f_edate.focus();
			return false;
		}
		
		// To Date 가 From Date 보다 큰지 Check 
		if ( formObj.f_sdate.value > formObj.f_edate.value ) {
			ComShowCodeMessage("COM12133", "To Date", "from Date", "later");
			formObj.f_edate.focus();
			return false;
		}
		
		// 1주이내
		var fDt = document.form.f_sdate.value.split("-").join("");
		var tDt = document.form.f_edate.value.split("-").join("");

		if ( SpcGetDateIntervals(fDt, tDt, "D") >= 7 ) {
			ComShowCodeMessage("COM12114", "Date");
			formObj.f_edate.focus();
			return false;
		}

		
		if(formObj.f_vvd_cd.value.length > 0 && formObj.f_vvd_cd.value.length != 9){
			ComShowMessage(getMsg("SPC13057")); // Please, input VVD!
			formObj.f_vvd_cd.focus();
			return false;
		} else if (formObj.f_vvd_cd.value == "" && formObj.f_bkg_no.value == "" && formObj.f_ctrt_no.value == "") {
           // vvd가 없는 경우, Start week+duration+trade+sub trade+lane 값으로 검색 가능하게 변경(2015.03.27 . 신혜성 부장 by Mail )
			var year = document.getElementById("f_year").selectedIndex;
			var week = document.getElementById("f_week").selectedIndex;
			var duration = document.getElementById("f_duration").selectedIndex;
			var trd_cd = document.getElementById("f_trd_cd").Code;
			var sub_trd_cd = document.getElementById("f_sub_trd_cd").Code;
			var rlane_cd = document.getElementById("f_rlane_cd").Code;
			var dir_cd = document.getElementById("f_dir_cd").selectedIndex;
			var hul_cd = document.getElementById("f_hul_bnd_cd").selectedIndex;
			var sts = document.getElementById("f_aloc_sts_cd").Code;
			
			if( trd_cd<1 ) {
				ComShowMessage("Select Trade");
				document.getElementById("f_trd_cd").focus();
				return false;
			}
			if( sub_trd_cd<1 ) {
				ComShowMessage("Select Sub Trade");
				document.getElementById("f_sub_trd_cd").focus();
				return false;
			}
			if( dir_cd<1 && hul_cd<1) {
				ComShowMessage("Select Bound/Haul");
				formObj.f_dir_cd.focus();
				return false;
			}
				
			//status가 S, S->F 인경우는 lane 체크하지 않음
			if( rlane_cd<1 && sts == 'F') {
				if( duration > 0 && (ComIsNull(formObj.f_edate) && ComIsNull(formObj.f_bkg_no)) ) { //BKG DATE나 BKG NO가 있으면 Lane 체크는 하지 않는다.
				ComShowMessage("Select Lane");
				document.getElementById("f_rlane_cd").focus();
				return false;
				}
			}
		}		
		
		
		
		
		// 버튼별 조건
		switch(sAction) {
			case IBSEARCH:        //조회
				break;
			case MODIFY01:

				//Sheet에서 한 row 씩 처리 하도록 함.
				var chkRow = sheetObj.FindCheckedRow("cfm_flg");
				if(chkRow == "") {
					ComShowMessage(getMsg("SPC13058")); // Document is not selected.
					return false;
				}
				break;

			case IBSAVE:        //저장
				var sts = sheetObj.FindStatusRow("U");
				var stsAry = sts.split(";");
				if( stsAry.length < 1 ){
					ComShowMessage(getMsg("SPC13058")); //Document is not selected.
					return false;
				}		
				break;
			
		             
        }
		
	    return true;
	}


	/**
	 * 키 입력시 포멧에 따른 동작
	 */
	function spc0116_keypress(){
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
    function spc0116_deactivate() {
    	
    	var formObj = document.form;    	
	    switch (event.srcElement.getAttribute("name")) {
	    	case "f_sdate":
	    		ComAddSeparator(event.srcElement);
					break;	    		
	    	case "f_edate":
	    		ComAddSeparator(event.srcElement);
					break;	    		
				default:
					break;
	    }
    }   
    
	/**
	 * HTML Control의 onFocus 이벤트에서 Validation을 체크한다. <br>
	 **/
	function spc0116_activate(){
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "f_sdate":
	    		ComClearSeparator(event.srcElement);
				break;
	    	case "f_edate":
	    		ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
	
	/**
	 * HTML Control의 onChange 이벤트에서 Validation을 체크한다. <br>
	 **/
	function spc0116_change(){
		var formObj = document.form;
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "f_dir_cd":
	    		if(event.srcElement.selectedIndex >0) document.getElementById("f_hul_bnd_cd").selectedIndex = 0;
				break;
	    	case "f_hul_bnd_cd":
	    		if(event.srcElement.selectedIndex >0) document.getElementById("f_dir_cd").selectedIndex = 0;
				break;
				
	    	case "f_duration":
	    		if(formObj.f_chk_dummy.checked && formObj.f_duration.value > 3) {
	    			formObj.f_chk_dummy.checked = false;
	    			break;
	    		}				
				
				
			default:
				break;
		}
	}

	/**
	 * HTML Control의 onClick 이벤트에서 Validation을 체크한다. <br>
	 **/
	
	function spc0116_onClick(){
		var formObj = document.form;
		//입력Validation 확인하기
		switch(event.srcElement.name){	
	    	case "f_chk_dummy":		    		
	    		if(formObj.f_chk_dummy.checked && formObj.f_duration.value > 3) {
	    			formObj.f_duration.value = 3;
	    			break;
	    		}
				break;
				
			default:
				break;
		}
	}
	
	  /** CoBkg에서 가져온것.-- 김성욱 2015.02.11
	   * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
	   * IBMultiCombo의 item으로 insert 해준다.<br>
	   * <b>Example :</b>
	   *
	   * <pre>
	   * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
	   * var arrData = ComPriXml2ComboItem(xmlStr, combo1, &quot;cd&quot;, &quot;nm&quot;);
	   *
	   * </pre>
	   *
	   * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
	   * @param {object} cmbObj 필수, insert하고자 하는 IBMultiCombo Object.
	   * @param {string} codeCol 필수, Combo의 Code컬럼명.
	   * @param {string} textCol 필수, Combo의 Text컬럼명. 다수일 경우 '|' 로 연결
	   * @param {boolean} bClear 선택, Combo의 기존 내용을 Clear할지 여부(combo.RemoveAll()). 기본값=true.
	   * @return 없음.
	    * @author 박성수
	    * @version 2009.04.22
	   */
	  function ComBkgXml2ComboItem(xmlStr, cmbObj, codeCol, textCol, bClear) {
	      if (xmlStr == null || xmlStr == "" || cmbObj == null || cmbObj == "") {
	          return;
	      }
	      if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
	          return;
	      }

	      try {
	          cmbObj.RemoveAll();

	          var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
	          xmlDoc.loadXML(xmlStr);

	          var xmlRoot = xmlDoc.documentElement;
	          if (xmlRoot == null) {
	              return;
	          }

	          var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	          if (dataNode == null || dataNode.attributes.length < 3) {
	              return;
	          }

	          var col = dataNode.getAttribute("COLORDER");
	          var colArr = col.split("|");
	          var sep = dataNode.getAttribute("COLSEPARATOR");
	          var total = dataNode.getAttribute("TOTAL");

	          var dataChildNodes = dataNode.childNodes;
	          if (dataChildNodes == null) {
	              return;
	          }

	          var colListIdx = Array();
	          for ( var i = 0; i < colArr.length; i++) {
	              if (colArr[i] == codeCol) {
	                  colListIdx[0] = i;
	              }
	              if (colArr[i] == textCol) {
	                  colListIdx[1] = i;
	              }
	          }

	          for ( var i = 0; i < dataChildNodes.length; i++) {
	              if (dataChildNodes[i].nodeType != 1) {
	                  continue;
	              }
	              var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

	              var item = arrData[colListIdx[0]] + "|" + arrData[colListIdx[1]];
	              cmbObj.InsertItem(i, item, arrData[colListIdx[0]]);
	          }

	      } catch (err) {
	          ComFuncErrMsg(err.message);
	      }
	  }
	  
	  /*
  	 *  trade변경시
  	 */
  	function f_trd_cd_OnChange(comObj,value,text){		
//  		if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
      	//sub_trade value change  
  		document.getElementById("f_sub_trd_cd").Index2 = 0; 
      	//lane value change
  		document.getElementById("f_rlane_cd").Index2 = 0;
      	SpcSearchOptionSubTrade("f_sub_trd_cd",true,false,"","",value);			// 0207 SHKIM
  		SpcSearchOptionLane("f_rlane_cd",true,true,'',value,'',true);	// 0207 SHKIM
  	}
  				
  	/*
  	 * sub_trade변경시
  	 */
  	function f_sub_trd_cd_OnChange(comObj,value,text ){
  		SpcSearchOptionLane("f_rlane_cd",true,true,'',document.form.f_trd_cd.Code,value,true);	// 0207 SHKIM
      	if(value == "" ) return;
	     	var arrTrade = text.split("|");
	    	if(arrTrade.length > 1) {
	    		document.getElementById("f_trd_cd").Code2 = arrTrade[0];
	    	} else {
	    		document.getElementById("f_sub_trd_cd").Code2 = comObj.GetText(value,0);  
	    	}     	    
  	    //lane value change
	   	document.getElementById("f_rlane_cd").Index2 = 0;        
	} 
     
     	/*
  	 * lane변경시
  	 */
	function f_rlane_cd_OnChange(comObj,value,text ){
  		var repTrade = comObj.GetText(value,0);  
  	    var subTrade = comObj.GetText(value,1);
  	    if(value != "" ){  
  	    	document.getElementById("f_trd_cd").Code2 = repTrade;		   	
  	    	document.getElementById("f_sub_trd_cd").Code2 = subTrade;
  	 	}else{
  	 		document.getElementById("f_trd_cd").Code2 = "";
  	 		document.getElementById("f_sub_trd_cd").Code2 = "";
  	    }
	}
	
	
	/**
	 * Report Form 용
	 */
	function openRPTFormPopUp(){
    	var formObj = document.form;
    	var curPgmNo = reportFormID;//"ESM_SPC_0116";
        var param = "?col_desc="+document.form.f_header.value+"&call_cnt="+reportFormPopupCallCnt+"&pgm="+curPgmNo; 
    	ComOpenWindow2('ESM_SPC_0118.do'+param, '', 'width=600, height=440, menubar=0, status=1, scrollbars=0, resizable=0');
    	reportFormPopupCallCnt = 1;
    }
	
	/**
     *  Report용 그룹코드 변경시
     *  sheet1정보를 조회한다.
     */
     function f_selgroup_OnChange(obj, code){
    	 chgHeader();
    }
     
     /**reprot upload 추가 
      * Group combo 변경시 sheet의 Header정보를 변경시킨다.
      */
     function chgHeader(){
         var sheetObj = sheetObjects[0];
         var formObj = document.form;

         doActionIBSheet(sheetObj,formObj,IBRESET);
     }
     
     /**
      * sheet를 초기화 시킨다.
      * //reprot upload
      */
     function initHeader(sheetObj, formObj){
       // Header 정보를 변경하기 위해 sheet를 초기화 한다.
       //--------------------------------------------------
       // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
       sheetObj.Redraw = false;
       sheetObj.RemoveAll();
       sheetObj.Reset();
       
       formObj.f_header.value = formObj.f_header.value.toLowerCase()
       titleData    = formObj.f_headernm.value;
       saveNameData = formObj.f_header.value;
//       initSheet(sheetObj, 1, formObj.f_header.value, formObj.f_headernm.value); // 이렇게 사용하게 되어 있었음. 현재는 아래와 같이 사용함.
       initSheet(sheetObj, 1);
       sheetObj.Redraw = true;
       //--------------------------------------------------

     }

     /**
      * 118번 화면이 닫희면서 sheet의 header목록을 변경위해서 sheet를 초기화한다..
      * //reprot upload
      */
     function chgInitSheet(){
         var sheetObj = sheetObjects[0];
         var formObj = document.form;

         initHeader(sheetObj, formObj);

     }
     
     /**reprot upload 추가 
      * Popup이 닫힌 후 group combo를 변경 시킨다.
      */
     function chgGroup(param){
     	var formObj = document.form;
         var sheetObj = sheetObjects[0];
      	formObj.f_cmd.value = SEARCHLIST12;
 		var sXml = sheetObj.GetSearchXml("ESM_SPC_0118GS2.do", FormQueryString(formObj));
 		var arrXml = sXml.split("|$$|");
 		if (arrXml.length > 0)
 		ComXml2ComboItem(arrXml[0], formObj.f_selgroup, "code", "name");
 		ComSetObjValue(formObj.f_selgroup,param);
      }
     
     function sheet1_OnChange(sheetObj, Row, Col, Value){
    	 var sName = sheetObj.ColSaveName(Col);
     	switch(sName){
     	    case "cfm_rqst_flg":
     	    case "cfm_flg":
     	    	if( Value == "0" ) {
     	    		sheetObj.CellValue2( Row, "ibflag" ) = "U";
     	    	}
     	    	
     	    	///////////////////////////
     	    	// STS:F 이면서 sel Checked 일경우 Reprocess 버튼 Disabled 처리
     	    	if(document.getElementById("f_aloc_sts_cd").Code == "S") {
     	    		ComBtnEnable("btn_Reprocess");
     	    	
     	    		for (var i = sheetObj.HeaderRows; sheetObj.RowCount > 0 && i <= sheetObj.LastRow; i++) {
     	    			if(sheetObj.CellValue(i, "aloc_sts_cd") == "F" && sheetObj.CellValue(i, "cfm_flg") == "1") {
     	    				ComBtnDisable("btn_Reprocess");
     	    				break;
     	    			}
     	    		}
     	    	}
     	    	////////////////////////////
     	    	break;
     	}
     }
     
 	/**
      * 시트를 클릭했을 때 처리
      */
 	function sheet1_OnClick(sheetObj, row, col) {	
 		with(sheetObj) {
    		switch (ColSaveName(col)) {
    		case "lst_sb_rmk":
    			if((sheetObj.CellValue(row,"cfm_flg") == "1") 
    					|| ((document.getElementById("f_aloc_sts_cd").Code == "S") && (sheetObj.CellValue(row,"aloc_sts_cd") != "S"))){
    				
        			ComShowMemoPad(sheetObj, row, col,false , 250, 100,4000);//edit
    			}else{
    				ComShowMemoPad(sheetObj, row, col,  true, 250, 100);//view
    			}
    			break;
    		case "standby_reason":
    			ComShowMemoPad(sheetObj, row, col, false, 400, 100);
    			break;
    		}
    	}
 	}
 	
 	/*
    * 시트를 클릭했을 때 처리
    */
	function sheet1_OnDblClick(sheetObj, row, col) {
 		var colSaveName = sheetObj.ColSaveName(col);
 		switch(colSaveName) {     		
 			case "cmpb" :
 				//cmpb 팝업 오픈
 				var sUrl = "/hanjin/ESM_SPC_0122.do";
				var param = '?bkg_no=' + sheetObj.CellValue(row, "bkg_no");
				window.open(sUrl+param, "BKGCmpb", "height=340px,width=500px,status=no,toolbar=no,menubar=no,location=no,resizable=yes");
     		break;
			case "bkg_no" :
				//cmpb 팝업 오픈
				ComOpenWindowCenter("/hanjin/ESM_BKG_0079_Q.do?" +
						"bkg_no="+ sheetObj.CellValue(row, "bkg_no") + "&" +
						"pop_mode=1"
						,"ESM_BKG_0079_Q", 1005, 680);
				
			break;	
 		}
    }   
	

 	/*
    * ALOC STATUS 변경시 아래 버튼 활성화 처리
    */
	function f_aloc_sts_cd_OnChange(comObj,value,text) {
		if(value == 'S') {//SB일때만 버튼 활성화
			if(document.form.f_level.value == "3") {//HO, RHQ 소속이 아니면 
				ComBtnEnable("btn_BranchSave");
				ComBtnDisable("btn_Reprocess");
				ComBtnDisable("btn_StandbyToFirm");
			} else {
				ComBtnDisable("btn_BranchSave");
				ComBtnEnable("btn_Reprocess");
				ComBtnEnable("btn_StandbyToFirm");
			}
		} else { //SB아니면 기능버튼 비활성화
			ComBtnDisable("btn_BranchSave");
			ComBtnDisable("btn_Reprocess");
			ComBtnDisable("btn_StandbyToFirm");
		}
		sheetObjects[0].RemoveAll();
	}
	/**
	 * Start Week 의 year 변경시
	 * Start Week 의 year 변경시 주차 변경
	 */
	function checkWeek(){
		SpcSearchOptionWeek("f_week",false,document.form.f_year.value);
	}
	
	/**
	* BackEndJob 관련 Status='3' 이 될때까지 확인한다.<br>
	*/     
	function getBackEndJobStatus() {
		var formObj  = document.form;
		var sheetObj = sheetObjects[0];
		
		var sXml     = sheetObj.GetSearchXml("ESM_SPC_0116GS.do", "f_cmd=" + SEARCH02 + "&backendjob_key=" + formObj.backendJobKey.value);
		
		var jobState = ComGetEtcData(sXml, "jb_sts_flg");
		var errMsg   = ComGetEtcData(sXml, "jb_usr_err_msg");
		//Backend job이 성공적으로 종료되면
		if (jobState == "3") {
			clearInterval(backEndJobTimer);
			
			//Reprocess 종료 시 해당조건을 삭제.
			formObj.f_cmd.value = MODIFY04;
//			sheetObj.GetSaveXml("ESM_SPC_0116GS.do", FormQueryString(formObj));
			sheetObj.GetSaveXml("ESM_SPC_0116GS.do", backendJobCond);

		} else if (jobState == "4" || jobState == "5") {
			clearInterval(backEndJobTimer);
			//비정상 종료시 해당조건을 삭제.
			formObj.f_cmd.value = MODIFY04;
			sheetObj.GetSaveXml("ESM_SPC_0116GS.do", backendJobCond);
		}
	}
	
	function checkReprocessCondition(sheetObj, formObj){
		formObj.f_cmd.value = SEARCH03;
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0116GS.do", FormQueryString(formObj));
		var chk = ComGetEtcData(sXml, "chk");
		//같은 조건의 Reprocess가 수행중이면 alert 띄워준 후 return false.
		if(chk == "Y"){
			ComShowMessage(getMsg("SPC90308")); //Reprocess is running with same condition.
			return false;
		}
		return true;
		
	}
	

	/**
	 * batch job monitoring 
	 * 
	 * @return 없음
	 */ 
	function monitoringBatchJob(){
		
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObj.GetSearchXml("ESM_SPC_0116GS.do", FormQueryString(formObj));
		var BatchStatus = ComGetEtcData(sXml, "BatchStatus");
		
		if( BatchStatus == "R" ){ //RUNNING
			setTimeout(monitoringBatchJob,5000);
		}else{
			ComBtnEnable("btn_Reprocess");
			ComShowCodeMessage("COM12116","Reprocess"); 
			//ComOpenWait(false);
			doActionIBSheet(sheetObj,formObj,IBSEARCH);
		}
	}
	
	/* 개발자 작업  끝 */