/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0018.js
*@FileTitle : M&R Agreement List
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.07.01 함형석
* 1.0 Creation
* 2014-03-21 Ticket No : CHM-201429420 Title : ALPS MNR-Agreement-Tariff-Agreement List에 Expiry Date 추가 요청 TD : Jonghee HAN DEV : JongHee HAN -> exp_dt Column 추가
* 2014-11-06 CSR ID : CHM-201432660 : ALPS MNR-AGMTTARIFF 화면에서 GW-Contract Document와 ALPS MNR-AGMT와 Interface된 결과 값을 보여줄수 있도록 구현 : AA Chang Young Kim, DEV 이상근
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
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
     * @class ees_mnr_0018 : ees_mnr_0018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ees_mnr_0018() {
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

var initLoader = 0;

var strMnrOfficeLevel = "";	// 로그인 유저의 Office 레벨 :  HO레벨일때 L1, RHQ레벨일때 L2, Office레벨일때 L3리턴   (CoMnr.js에서 MnrOfficeLevel 함수에 의해 셋팅)


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
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_new":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
				case "btn_popup":
					ComOpenPopup('/hanjin/COM_ENS_0C1.do', 700, 450, 'getCOM_ENS_0C1', '1,0,1,1,1,1,1,1', true);
					break;		
				case "btn_detail":
					var agmt_no = sheetObject1.CellValue(sheetObject1.SelectRow, "agmt_no");
					var agmt_ofc_cd = sheetObject1.CellValue(sheetObject1.SelectRow, "agmt_ofc_cd");
					if(sheetObject1.RowCount >0){
						ComOpenPopup('/hanjin/EES_MNR_0218.do?agmt_no='+agmt_no+'&agmt_ofc_cd='+agmt_ofc_cd, 1050, 620, '', "0,1,1,1,1,1", true);
					}					
					break;	
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;
				case "cre_dt_cal":
					var cal = new ComCalendarFromTo();
					cal.select(formObject.agmt_fm_dt, formObject.agmt_to_dt, 'yyyy-MM-dd');
					break;		
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComFuncErrMsg(e);
    		} else {
    			ComFuncErrMsg(e);
    		}
    	}
    }

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		initControl();
		MnrWaitControl(true);

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //IBMultiCombo초기화 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }	

		//Office Level 조회  및 전역변수(strMnrOfficeLevel)에 세팅
		MnrOfficeLevel(currOfcCd,rhqOfcCd);
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
				
    }

    /**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {        
	    var formObject = document.form
	    switch(comboNo) {    
	        case 1: 
	           	with (comboObj) { 
        	   	SetColAlign("left|left");        
		       	SetColWidth("80|100");      
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break;    
	        case 2: 
	           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150"); 
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break;    
	        case 3: 
	           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150");
			   	DropHeight = 160;  
				UseAutoComplete = true;
		    	}      
	        	break;  
	        case 4: 
	           	with (comboObj) { 
				MultiSeparator = "|";
				SetTitle("Office Code|Office Name");
        	   	SetColAlign("left|left");        
				//SetColWidth("100|150");        
			   	DropHeight = 160;  
				UseAutoComplete = true;
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
        switch(sheetNo) {
            case 1:      // sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 402;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 10, 100);
                    
                    var HeadTitle = "|Seq.|Regional H/O|AGMT OFC|EQ Type|AGMT No.|G/W Contract YN|Delete Flag|Tariff No.|Ref. No.|S/P Code|S/P Name|Eff Date|Exp Date|Repair|Cleaning|Survey|PTI|Pre-maintenance|Tire Purchase|Attach/Detach|PM|Hanger|Other|";
                     
					var headCount = ComCountHeadTitle(HeadTitle);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,			40,		daCenter,		false,		"hdnStatus");
					InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,		false,		"SEQ");
					InitDataProperty(0, cnt++ , dtData,					85,		daCenter,		false,		"rhq_ofc",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		"agmt_ofc_cd",		false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daLeft,			false,		"mnr_cd_dp_desc",	false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		"agmt_no",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtPopup,				110,	daCenter,		false,		"file_atch_flg",	false,	"",		dfNone,		0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		"delt_flg",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		false,		"trf_no",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					140,	daLeft,			false,		"ref_no",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		false,		"vndr_seq",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					180,	daLeft,			false,		"vndr_lgl_eng_nm",	false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		"eff_dt",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daCenter,		false,		"exp_dt",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"rp_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		false,		"cl_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daCenter,		false,		"sv_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,		false,		"pt_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					140,	daCenter,		false,		"pr_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		false,		"tp_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					120,	daCenter,		false,		"ad_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		false,		"pm_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					60,		daCenter,		false,		"hg_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtData,					40,		daCenter,		false,		"ot_chk",			false,	"",		dfNone,		0,			false,		false);
					InitDataProperty(0, cnt++ , dtHidden,				30,		daCenter,		false,		"agmt_ver_no",		false,	"",		dfNone,		0,			false,		false);
					
					SelectionMode = smSelectionRow;  

			   }
         break;

        }
    }

	function initControl() {  
	    //Axon 이벤트 처리1. 이벤트catch  
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	    axon_event.addListenerFormat('focus',   'obj_activate',    form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerFormat('change',	 'obj_change',	form); //- 변경될때.
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
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){    
    	comboObjects[comboCnt++] = combo_obj;  
	}    
			   
	/**
	 * HTML Control의 deactivate 이벤트 <br>
	 **/
	function obj_deactivate(){    
		obj = event.srcElement;       
	    ComChkObjValid(event.srcElement); 
	} 

	/**
	 * HTML Control의 activate 이벤트 <br>
	 **/
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        

	function obj_change(){     
		var obj      = event.srcElement; 
		var formObj  = document.form; 
		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(obj.name) {      
	    		case "vndr_seq":   
	        		vndr_seq_confirm();  
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				   	break;  
			}		
	    } 
	}    
	
	/**
	 * HTML Control의 keypress 이벤트 <br>
	 **/     
	function obj_keypress(){     
	    obj = event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus = obj.dataformat;
			              
	    switch(obj.dataformat) {  
	        case "ymd":   
	        case "int":    
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "float":   
	            ComKeyOnlyNumber(obj, ".");
	            break; 
	        case "eng":   
	            ComKeyOnlyAlphabet();
				break;   
	        case "engup": 
	            if(obj.name=="vndr_seq"){ 
					ComKeyOnlyNumber(obj);     
				}else{
					ComKeyOnlyAlphabet('uppernum');	
				}  		
	        	break;	  
	    }
	} 	

	/**  
	 * combo1 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo1_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;        
		formObj.agmt_eq_type.value = comboObj.Code;   
	}   	

	/**  
	 * combo2 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo2_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;       
		if(comboObj.Code=="A"){
			formObj.ar_hd_qtr_cd.value = ""; 
		}else{
			formObj.ar_hd_qtr_cd.value = comboObj.Code; 
		}
		getAgmtOfcCd(comboObj,Index_Code, Text);
	}  

	/**  
	 * combo3 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  	
	function combo3_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;     
		if(comboObj.Code=="A"){
			formObj.agmt_ofc_cd.value = ""; 
		}else{
			formObj.agmt_ofc_cd.value = comboObj.Code; 
		}
	}  

	/**  
	 * combo4 Change 이벤트      
	 * @param {IBMultiCombo}  comboObj 콤보오브젝트  
	 * @param  {String}    Index_Code   Index 나 코드
	 * @param  {String}    Text   텍스트
	 */  
	function combo4_OnChange(comboObj,Index_Code, Text){ 
		var formObj  = document.form;      
		if(comboObj.Code=="A"){
			formObj.cost_ofc_cd.value = ""; 
		}else{
			formObj.cost_ofc_cd.value = comboObj.Code; 
		}
	}  

  	/**
     * Sheet1관련 프로세스 처리
     * @param	{IBSheet}	sheetObj	프로세스 처리될 시트오브젝트 
     * @param	{Form}		formObj		프로세스 처리될 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {

        switch(sAction) {
            case IBSEARCH:      //조회
                if(validateForm(sheetObj,formObj,sAction)){
					if(sheetObj.id =="sheet1"){       
						formObj.f_cmd.value = SEARCH; 
		        		sheetObj.DoSearch4Post("EES_MNR_0018GS.do",FormQueryString(formObj));	
					}  
				}	
                break;

			case IBCLEAR:        //초기화
				MnrWaitControl(true);
			    sheetObj.WaitImageVisible = false;
				if(initLoader == 0){
					//콤보 초기화 
					for(var i = 0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();       
					}   
					
					var sCondition = new Array (
						new Array("MnrGenCd","SELHO","CUSTOM9"),	//Eq Kind
						new Array("MdmOrganization","RHQ","FALSE")  //Regional HQ
					);   
					
					var comboList = MnrComSearchCombo(sheetObj,sCondition);
	
					//콤보 설정
					for(var i = 0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText = "";
							sheetComboCode = "";
							for(var j = 0; j < comboList[i].length;j++){ 
								var tempText = comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//Eq Kind
								if(i==0) {
									formObj.combo1.InsertItem(j, tempText[1] ,tempText[0]);
								}else if(i==1){ //Regional HQ
									formObj.combo2.InsertItem(j, comboList[i][j] ,tempText[0]);
								}
							}
						}
					}
									
					formObj.combo1.InsertItem(0, "ALL" ,"A" );
					formObj.combo1.Code = "A";
					formObj.agmt_eq_type.value = formObj.combo1.Code;
					formObj.combo2.InsertItem(0, "ALL" ,"A" );
					
					if(strMnrOfficeLevel=="L1"){
						formObj.combo2.Code = "A";
					}else{
						formObj.combo2.Enable = false;
						var rhqCd = MnrHqOfcByOfc(sheetObjects[0],currOfcCd);
						formObj.combo2.Code = rhqCd;
					}

					if(formObj.strAccess_system.value=="SPP"){
						formObj.vndr_seq.value = ComLpad(formObj.strVndr_seq.value,6,"0");
						formObj.vndr_lgl_eng_nm.value = formObj.strVndr_nm.value;
						MnrFormSetReadOnly(formObj,true,"vndr_seq");
						formObj.btn_popup.style.display="none";
						formObj.combo2.Enable = false;
					}
										
					initLoader = 1;	
				}

				//쉬트 초기화   
				for(i=0;i<sheetObjects.length;i++){   
					sheetObjects[i].RemoveAll();    
		        }  
				
				formObj.combo1.Code = "A";
				
				form.agmt_fm_dt.value = ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				form.agmt_to_dt.value = ComGetNowInfo();
				
				if(formObj.strAccess_system.value=="ALP"){
	    	 		formObj.vndr_seq.value = "";
   	 				formObj.vndr_lgl_eng_nm.value = "";
				}
				sheetObj.WaitImageVisible = true;
				MnrWaitControl(false);
                break;
			case IBDOWNEXCEL:
			    //sheetObj.Down2Excel(-1);   
			    sheetObj.SpeedDown2Excel(-1);   
				break;
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param	{IBSheet}	sheetObj	유효성을 검증할 시트오브젝트 
     * @param	{Form}		formObj		유효성을 검증할 폼오브젝트
     * @param	{Number}	sAction		분기처리될 액션의 상수값(CoObject.js에 정의) 
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(formObj.agmt_eq_type.value == "" ) {
				ComAlertFocus(formObj.combo1, ComGetMsg('MNR00003'));
				return;
			} else if(formObj.agmt_fm_dt.value == "") {
				ComAlertFocus(formObj.agmt_fm_dt, ComGetMsg('MNR00003'));
				return;
			} else if(formObj.agmt_to_dt.value == "") {
				ComAlertFocus(formObj.agmt_to_dt, ComGetMsg('MNR00003'));
				return;	
			}
        }
		return true;	 	
    }		

	/**  
	 * ofc_cd 존재여부 체크    
	 */  	
	function ofc_cd_confirm(fieldName){
		var retArray =  null;        
        var formObj = document.form;
		var checkOffice = formObj[fieldName].value;               
		if (checkOffice!=""){
		    retArray = MnrGeneralCodeCheck(sheetObjects[0],"OFC",checkOffice);      
			if(retArray == null){           
				ComShowCodeMessage("MNR00165",checkOffice);  
				formObj[fieldName].value="";
				formObj[fieldName].focus();
			}   
		}
	}

	/**  
	 * vndr_seq 존재여부 체크    
	 */  			
	function vndr_seq_confirm(){
		var formObj = document.form;
		if(formObj.vndr_seq.value != "" && Number(formObj.vndr_seq.value)){ 
			//서비스 프로바이더 조회 
			var sCondition = new Array ( 
			 	new Array("MdmVendor",formObj.vndr_seq.value,"COMMON")
			)                            
			//조회 값이 있다면 세팅
			var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 
			if(comboList[0] != null){
				var tempText = comboList[0][0].split("|"); 
				formObj.vndr_lgl_eng_nm.value  = tempText[1];  
			} else {       
				ComShowCodeMessage("MNR00005", "Service Provider");              
				ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}   
		} else {
			ComShowCodeMessage("MNR00005", "Service Provider");              
			ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); 
			ComSetObjValue(formObj.vndr_seq, "");
			ComSetFocus(formObj.vndr_seq);
		}
	}

    /**
     * getCOM_ENS_0C1 의 값을 받은 함수   
	 * @param	{String[][]}	aryPopupData	팝업화면에서 리턴받은 배열값
     */   
    function getCOM_ENS_0C1(aryPopupData, row, col, sheetIdx){
   	 
   	 var formObj = document.form;
   	 var vndrSeq = "";
   	 var vndrNm = "";
   	 var i = 0;
   	 
   	 for(i = 0; i < aryPopupData.length; i++){
   		 vndrSeq = vndrSeq + aryPopupData[i][2];
   		 
   		 if(aryPopupData.length == 1){
   			 vndrNm = vndrNm + aryPopupData[i][4];
   		 }
   		 
   		 if(i < aryPopupData.length - 1){
   			 vndrSeq = vndrSeq + ",";
   		 }
   	 }
   	 
   	 formObj.vndr_seq.value = vndrSeq;
   	 formObj.vndr_lgl_eng_nm.value = vndrNm;
   	 
    }

   /**
	 * Regional HQ에 대한  Agreement Office 조회
	 * @param comboObj
	 * @param Index_Code
	 * @param Text
	 * @return
	 */   
	function getAgmtOfcCd(comboObj,Index_Code, Text){ 
		var formObj = document.form;
		formObj.combo3.removeAll();
		formObj.combo4.removeAll();

		var sCondition = new Array (      
			new Array("MdmOrganization","SEARCH",Index_Code) 
		)                                
		var comboList = MnrComSearchCombo(sheetObjects[0],sCondition); 

		if(comboList[0] != null){      
			for(var j = 0; j < comboList[0].length;j++){  
		   		var tempText = comboList[0][j].split("|");  
		   		formObj.combo3.InsertItem(j,comboList[0][j] ,tempText[0]);
				formObj.combo4.InsertItem(j,comboList[0][j] ,tempText[0]);
			}             
		 	formObj.combo3.InsertItem(0, "ALL" , "A");
		 	formObj.combo4.InsertItem(0, "ALL" , "A");

			formObj.combo3.Code = "A";
			formObj.combo4.Code = "A";
		} 
 	}
	
	function sheet1_OnPopupClick(sheetObj, row, col){
		if(sheetObj.CellValue(row, col) == "Y") {
//			alert(sheetObj.id + ", " + row + ", " + col);
			
			var strAgmtOfcCtyCd	= sheetObj.CellValue(row, "agmt_no").substring(0,3);
			var strAgmtSeq		= sheetObj.CellValue(row, "agmt_no").substring(3,9);
			var strAgmtVerNo	= sheetObj.CellValue(row, "agmt_ver_no");
			var strFileAtchFlg	= sheetObj.CellValue(row, col);
			var strActnFlg		= "R";
			
			ComOpenPopup('/hanjin/EES_MNR_0017.do?agmt_ofc_cty_cd='+strAgmtOfcCtyCd+
					'&agmt_seq='+strAgmtSeq+
					'&agmt_ver_no='+strAgmtVerNo+
					'&file_atch_flg='+strFileAtchFlg+
					'&actn_flg='+strActnFlg, 920, 540, 'setEES_MNR_0017', "0,1,1,1,1,1", true);
		}
		
	}

	/* 개발자 작업  끝 */