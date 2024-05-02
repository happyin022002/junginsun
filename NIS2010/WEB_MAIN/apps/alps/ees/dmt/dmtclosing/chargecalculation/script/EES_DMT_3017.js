/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2006.js
*@FileTitle : DEM/DET Adjustment Request & Approval Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.08.03 이성훈
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
     * @class DEM/DET Adjustment Request & Approval Status 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
	// 공통전역변수
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;

	var comboObjects = new Array();
	var comboCnt = 0;	

	//Action 정의
	var IBSEARCH_TARIFF = 100;
	var IBSEARCH_OFFICE = 101;	
	var IBSEARCH_DELPROCSTS = 102;
	var IBSEARCH_RSNCD = 103;
	var IBSEARCH_RSNCDDTL = 104;
	var IBSEARCH_DELTPATH   = 105;
	
	//업무전역변수
	var ROWMARK 	= "|";
	var FIELDMARK 	= "=";
	
	//S/C Exception Tariff 컬럼명
			
	//날짜 정보를 가져오기 위한 처음(이전)과 마지막(현재) 일짜의 간격을 나타내는 변수
	var PERIOD_GAP = 7;	
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick() {
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		var sheetObject3 = sheetObjects[2]; 
		/*******************************************************/
		var formObj = document.form;

    	try {
    		var srcObj = window.event.srcElement;
    		var srcName = srcObj.getAttribute("name");

    		switch(srcName) {

	         	case "btns_calendar": //달력 버튼
					var cal = new ComCalendarFromTo();
					cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
					break;            
	            
				case "btn_Retrieve":
					if (ComIsBtnEnable("btn_Retrieve")) 
						doActionRetrieve();					
					break;
				
				case "btn_New":
					if (ComIsBtnEnable("btn_New")) 
						doActionNew();						
					break;
				
				case "btn_Detail":
					if (ComIsBtnEnable("btn_Detail"))
						doActionDetail();
					break;
					
				case "t1btn_Alldownexcel":
					doActionDownExcel(sheetObject1);
					break;
				
				case "t2btn_Processingdownexcel":
					doActionDownExcel(sheetObject2);
					break;
				
				case "t3btn_Enddownexcel":
					doActionDownExcel(sheetObject3);
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
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	
        for (i = 0 ; i < sheetObjects.length ; i++) {
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
		}
         
        for (var k = 0 ; k < tabObjects.length ; k++) {
            initTab(tabObjects[k],k+1);
        }
        
	 	//IBMultiCombo초기화 
	    for (var k = 0 ; k < comboObjects.length ; k++) {
	        initCombo(comboObjects[k],k+1);
	    }
	 	
		//html컨트롤 이벤트초기화
		initControl();
		
		initViewControls();
		
		doInit();
    }

	// 페이지에 Object 태그를 사용하여 IBSheet의 인스턴스를 생성완료 하면 Event가 발생한다.
	function doInit() {
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		
		//Tariff Type 정보를 조회해서 Tariff 콤보에 설정해 준다.
   		doActionIBCommon(sheetObj, formObj, IBSEARCH_TARIFF, SEARCH09);
  		// Office MultiCombo List조회
   		doActionIBCommon(sheetObj, formObj, IBSEARCH_OFFICE, SEARCHLIST02);

   		doActionIBCommon(sheetObj, formObj, IBSEARCH_DELPROCSTS, SEARCH03);	//DEL Process Status

   		doActionIBCommon(sheetObj, formObj, IBSEARCH_RSNCD, SEARCH01);	//Reason Code
   		
   		ComSetObjValue(formObj.mn_rsn_cd, 'All');
   		doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_RSNCDDTL, SEARCH01);	//Reason Code Detail
   		
		doActionIBCommon(sheetObj, formObj, IBSEARCH_DELTPATH, SEARCH04);		//로그인 사용자의 승인권한단계 조회

	}
	
   	function initControl() {
		axon_event.addListenerForm('beforedeactivate',	'obj_deactivate',  	document.form, 'cond_type'); //- 포커스 나갈때
		axon_event.addListenerFormat('focus',			'obj_focus',		document.form); //- 포커스 들어갈때
		axon_event.addListenerFormat('keypress',		'obj_keypress', 	document.form); //- 키보드 입력할때
		axon_event.addListener('click', 				'condType_click', 	'cond_type');
		axon_event.addListener('keydown', 				'ComKeyEnter', 		'form');
		axon_event.addListener('blur', 					'obj_blur', 		'custCd');
  	}
  	
   /**
    * 화면 Load 시점에 컨트롤들의 상태를 초기화하기 위한 함수
    */     
    function initViewControls() {
    	var formObj = document.form;
    	var cboTariff = comboObjects[0];
    	
//	 	ComSetObjValue(formObj.cond_type, "date");
	 	
	 	//Date 조회필드 설정
	 	initDateControls();
	 	
    	//조회결과가 있다면 모두 Clear 해준다.
    	for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
    		sheetObjects[sheetNo].RemoveAll();
    	}	 	
    }
     
  	/**
   	 * 조회 Date 필드 초기화
   	 */
   	function initDateControls() {
   		var formObj = document.form;
   		   		
   		doEnableCondObj();		
   	}      
      
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
		var sheetid = sheetObj.id;

        switch(sheetid) {
            case "t1sheet1":
            case "t2sheet1":
            case "t3sheet1":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 400;
                    // 전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 7, 100);

					var HeadTitle1 = "Seq.|Inactive No|BKG No|CNTR No|Approval No|Status|Reason|Specific Reason|Over|RQT|RQT|RQT|OFC O.Manager|OFC O.Manager|OFC O.Manager|BB|BB|BB|RHQ|RHQ|RHQ|HO|HO|HO|inactiv info||";
					var HeadTitle2 = "Seq.|Inactive No|BKG No|CNTR No|Approval No|Status|Reason|Specific Reason|Over|Date|OFC|Name|Date|OFC|Name|Date|OFC|Name|Date|OFC|Name|Date|OFC|Name|inactiv info||";
                   
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,			30,		daCenter,		true,		"Seq");
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"inact_rqst_no",    		false,	"",	dfNone,			0,	false);
                	
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,		true,		"bkg_no",	     			false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		120,	daCenter,		true,		"cntr_no",	     			false,	"",	dfNone,			0,	false);
					
					InitDataProperty(0, cnt++ , dtData,			120,	daCenter,		true,		"inact_apro_no",    		false,	"",	dfNone,			0,	false);					
					
					InitDataProperty(0, cnt++ , dtData,			130,	daCenter,		true,		"sts_cd",	     			false,	"",	dfNone,			0,	false);

					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"inact_rsn",	     		false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			270,	daLeft,			true,		"spec_rsn",	     			false,	"",	dfNone,			0,	false);
					
					InitDataProperty(0, cnt++ , dtData, 		60,		daCenter,		true,		"ovr_dys",					false,	"",	dfInteger,		0,	false,	false);  
					
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"rqst_dt",  				false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"rqst_ofc",  				false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"rqst_nm",  				false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"oom_dt",  					false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"oom_ofc",  				false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"oom_nm",  					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"bbg_dt",  					false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"bbg_ofc",  				false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"bbg_nm",  					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"rhq_dt",					false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"rhq_ofc",					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"rhq_nm",					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"hdo_dt",					false,	"",	dfDateYmd,		0,	false);
					InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		"hdo_ofc",					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtData,			100,	daLeft,			true,		"hdo_nm",					false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,		true,		"inactiv_info",				false,	"",	dfNone,			0,	false);
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,		true,		"chg_delt_usr_yn",			false,	"",	dfNone,			0,	false);	
					InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,		true,		"rqst_ofc_flg",				false,	"",	dfNone,			0,	false);					
//					CountPosition = 0;
				}
				break;

        }
    }

    //포커스가 나갈 때
 	function obj_deactivate(){
 		//입력Validation 확인하기 + 마스크구분자 넣기
 		var obj = event.srcElement;
 		if(obj.name == 'bkg_no' || obj.name == 'bl_no' ) {

 		} 
 		else {
 			ComChkObjValid(obj);
 		}
	}
    
    /**
     * HTML Control Foucs in
     */
    function obj_focus(){
   	 var obj = event.srcElement;
        ComClearSeparator(obj);
        
        //글자가 있는 경우 블럭으로 선택할수 있도록 한다.
        if (obj.getAttribute("isContentEditable") && obj.getAttribute("value") != null && obj.value.length >=1 ) obj.select();
    }    
 	
	//업무 자바스크립트 OnKeyPress 이벤트 처리
	function obj_keypress() {
		var formObj = document.form;

		switch(event.srcElement.dataformat){
			case "engup":
				// 영문대+숫자 
				ComKeyOnlyAlphabet('uppernum', ',');
				break;
      		case "engup2":
		    	// 영문대+숫자+예외문자
		    	DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
      		case "int":
	 	        //숫자 만입력하기
	 	        ComKeyOnlyNumber(event.srcElement);
	 	        break;
      		default:
	         	// 숫자만입력하기(정수,날짜,시간)
	            ComKeyOnlyNumber(event.srcElement);
		}		
	} 
	    
	function doEnableCondObj() {
		var sheetObj 	= sheetObjects[0];
		var formObj 	= document.form;
		
		with (formObj) {

			var ofcCurrDate = DmtComOfficeCurrDate(sheetObj, formObj);
			
			ComSetObjValue(formObj.fm_dt, ComGetDateAdd(ofcCurrDate, "D", -7));
			ComSetObjValue(formObj.to_dt, ofcCurrDate);
			
			comboObjects[1].Code = formObj.login_ofc_cd.value;

		}
	}
		
  	
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        //메소드내에서 전체적으로 사용하는 변수 정의
        var cboTariff = comboObjects[0];
        
        switch(sAction) {

        	case IBSEARCH:      //조회
              	if(!validateForm(sheetObj,formObj,sAction)) return;

				//1.조회조건 설정
				ComSetObjValue(formObj.f_cmd, 		SEARCH);
				ComSetObjValue(formObj.inact_sts_cd, 	comboObjects[0].Text);
				ComSetObjValue(formObj.ofc_cd, 			comboObjects[1].Text);
				ComSetObjValue(formObj.trf_cd, 			comboObjects[2].Text);
				ComSetObjValue(formObj.inact_rsn_cd, 	comboObjects[3].Text);
				ComSetObjValue(formObj.spec_rsn_cd, 	comboObjects[4].Text);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				sheetObj.DoSearch("EES_DMT_3017GS.do", FormQueryString(formObj));
				
				if( formObj.group_by.value == 'INACT' ){
//					sheetObj.ColHidden("inact_rqst_no") = false;
//					sheetObj.ColHidden("inact_apro_no") = false;
					sheetObj.ColHidden("bkg_no") = true;
					sheetObj.ColHidden("cntr_no") = true;
				} else if( formObj.group_by.value == 'BKG' ){
//					sheetObj.ColHidden("inact_rqst_no") = true;
//					sheetObj.ColHidden("inact_apro_no") = true;
					sheetObj.ColHidden("bkg_no") = false;
					sheetObj.ColHidden("cntr_no") = true;
				} else if( formObj.group_by.value == 'CNTR' ){
//					sheetObj.ColHidden("inact_rqst_no") = true;
//					sheetObj.ColHidden("inact_apro_no") = true;
					sheetObj.ColHidden("bkg_no") = true;
					sheetObj.ColHidden("cntr_no") = false;
				}
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************				
				break;
        }
    }

	/**
	 * 콤보필드를 초기화 시키기 위해서 해당 데이터를 조회후 조회된 데이터로 채운다.
	 */	
	function doActionIBCommon(sheetObj, formObj, sAction, sComboAction) {
	    sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;
		
	    switch(sAction) {
	    
	    	//Tariff Type 을 조회한다.
	    	case IBSEARCH_TARIFF:
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리
				var comboObj = comboObjects[2];
				var comboItems = ComGetEtcData(sXml, "all_tariff_cd").split(ROWMARK);
				addComboItem(comboObj,comboItems);
				
				//4.Tariff 전체선택을 기본설정으로 한다.
				selectAllTariff();
				break;


	    	//Office 을 조회한다.
	    	case IBSEARCH_OFFICE:
	    		
	    		var comboObj = comboObjects[1];
	    		
				//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
				ComSetObjValue(formObj.f_cmd, sComboAction);
				
				//2.조회조건으로 조회실행
				//*********************************************************************************
				ComOpenWait(true);
				sheetObj.WaitImageVisible = false;
				//*********************************************************************************
				
				var sXml = sheetObj.GetSearchXml("DMTCommonFinderGS.do", FormQueryString(formObj));
				
				//*********************************************************************************
				ComOpenWait(false);
				//*********************************************************************************
				
				//3.조회후 결과처리

 	    	   if(sComboAction == SEARCHLIST02) {
	 	    	   	// Office List
					var ofc_cds = ComGetEtcData(sXml, "OFC_CD");
					var ofc_nms = ComGetEtcData(sXml, "OFC_NM");
					
					if (ofc_cds != undefined && ofc_cds != '') {
						var comboCodeArr = ofc_cds.split("|");
			    	    var comboTextArr = ofc_nms.split("|");
			    	    
			    	    // 로그인 User Office를 Default - 리스트에 없을시 item 추가해서 표시
		    	  		var login_ofc_cd = formObj.login_ofc_cd.value;
		    	  		var idx = 0; 
		    	  		
			    	    if(ofc_cds.indexOf(login_ofc_cd) == -1) {
			    	    	comboObj.InsertItem(0, login_ofc_cd, login_ofc_cd);
			    	    	idx = 1;
			    	    }
			    	    
			    	    for (var i = 0 ; i < comboTextArr.length ; i++) {
			    	    	comboObj.InsertItem(idx+i, comboCodeArr[i] + "|" + comboTextArr[i], comboCodeArr[i]);		
			         	}
			    	    
			    	    comboObj.Code = login_ofc_cd;
					}
	    	  		
 	    	   } else { // formCmd == COMMAND01 (Incl. Sub Office)
 	    		   	var subOfcCds = ComGetEtcData(sXml, "OFC_CD");
 	    	   		if (subOfcCds != undefined && subOfcCds != '') {
 	    	   			// 조회된 Sub Office 중에서  기존 콤보리스트에 없는 것은 제거한다.
 	    	   			var arrOfcCd = subOfcCds.split(',');
 	    	   			var str = '';
 	    	   			for(var i=0; i<arrOfcCd.length; i++) {
 	    	   				var idx = comboObj.FindIndex(arrOfcCd[i], 0);
 	    	   				if(idx != -1)
 	    	   					str = str + ',' + arrOfcCd[i];
 	    	   			}
 	    	   			str = str.substring(1);
 	    	   			
 	    	   			// 하위점소 조회대상 Office 목록에  로그인 Office 포함시, 하위점소 조회결과에 로그인 Office가 없을시 추가해준다.
 	    	   			var usrOfcCd = ComGetObjValue(formObj.login_ofc_cd);
 	    	   			if(comboObj.Code.indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
 	    	   				str = usrOfcCd + ',' + str;
 	    	   			}
 	    	   			comboObj.Code = str;
 	    			 }
 	    	   }
				
			break;			
			
	    	case IBSEARCH_DELPROCSTS:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, sComboAction); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 var comboItems = ComGetEtcData(sXml, "chg_delt_proc_sts").split(ROWMARK);
	        	 addComboItem(comboObjects[0], comboItems);

	         break;

	    	case IBSEARCH_RSNCD:
	    		
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, sComboAction); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3017GS.do", FormQueryString(formObj));
	        	 
	        	 ComOpenWait(true);
	        	 
	        	 //3.조회후 결과처리
	        	 var comboItems = ComGetEtcData(sXml, "RSN_CD").split(ROWMARK);
	        	 
	        	 ComOpenWait(false);
	        	 
	        	 addComboItem(comboObjects[3], comboItems);

	         break;

	    	case IBSEARCH_RSNCDDTL:

	        	 ComOpenWait(true);
	        	 
	        	 if ( formObj.mn_rsn_cd.value == "" )
	        		 formObj.mn_rsn_cd.value = "All";
	        	 
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, sComboAction); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3017GS.do", FormQueryString(formObj));
	                
	        	 //3.조회후 결과처리
	        	 var comboItems = ComGetEtcData(sXml, "RSN_CD").split(ROWMARK);

	        	 ComOpenWait(false);
                 
                 comboObjects[4].RemoveAll();
                 
	        	 addComboItem(comboObjects[4], comboItems);

	         break;
	         

	         case IBSEARCH_DELTPATH:
	        	 //1.조회조건 설정
	        	 ComSetObjValue(formObj.f_cmd, sComboAction); 
	                
	        	 //2.조회조건으로 조회실행                 
	        	 var sXml = sheetObj.GetSearchXml("EES_DMT_3014GS.do", FormQueryString(formObj));
	        	 
	        	 //3.조회후 결과처리
	        	 ComSetObjValue(formObj.chg_delt_path_cd, ComGetEtcData(sXml, "CHG_DELT_PATH_CD"));
	         break;
	         
	    }
		sheetObj.WaitImageVisible = true;
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
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
         switch(tabNo) {
             case 1:
                with (tabObj) {
                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Processing" , -1 );
                    InsertTab( cnt++ , "Sent" , -1 );
                    InsertTab( cnt++ , "All" , -1 );
                }
             	break;
         }
    }

  	/** 
  	 * IBCombo Object를 배열로 등록
  	 * param : combo_obj ==> 콤보오브젝트
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */ 
  	function setComboObject(combo_obj) {  
  
  		comboObjects[comboCnt++] = combo_obj;  
  	}

  	/**
   	 * Combo 기본 설정 
   	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
   	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
   	 */ 
   	function initCombo(comboObj, comboNo) {
   	    var formObj = document.form

   	    switch(comboNo) {
   	    	//status
  	    	case 1: 
	        	with (comboObj) {
                    MultiSelect = true; 
                    UseAutoComplete = true; 
					SetColAlign("left|left");
					SetColWidth("25|170");
                    DropHeight = 190;
					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  
				break;   
   	    	//office
  	    	case 2: 
	        	with (comboObj) { 
					MultiSelect = true; 
					UseAutoComplete = true;
					SetColAlign("left|left");   
					SetColWidth("60|300");				
					DropHeight = 160;
//					ColBackColor(0) = "#CCFFFD";
//  					ColBackColor(1) = "#CCFFFD";
					ValidChar(2,2);		//영문 대문자
					IMEMode = 0;
		    	}  	        	  
				break;  
			//tariffType
   	    	case 3:
   	    		with(comboObj) {
   					MultiSelect = true; 
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|330");
   					DropHeight = 160;
   	    		}
   	    		break;
			//inactReason
   	    	case 4:
   	    		with(comboObj) {
   					MultiSelect = true; 
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|330");
   					DropHeight = 160;
   	    		}
   	    		break;
			//specReason
   	    	case 5:
   	    		with(comboObj) {
   					MultiSelect = true; 
   					UseAutoComplete = true;	
   					SetColAlign("left|left");        
   					SetColWidth("55|330");
   					DropHeight = 160;
   	    		}
   	    		break;
   	     } 
   	}
   	
	/**
     * 콤보필드에 데이터를 추가해준다.
     */	
	function addComboItem(comboObj, comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(FIELDMARK);
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[1]);		
    	}   		
	}
	     
    /**
     * 콤보필드에 첫번째 항목을 선택해준다.
     */	
 	function setComboItem(comboObj,comboItems) {
 		var checkedItem = comboItems[0].split(FIELDMARK);
 		comboObj.Text = checkedItem[0];
 	}
 	
    /**
    * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    */
   function validateForm(sheetObj,formObj,sAction){
       with(formObj){
    	   //Type 모두 미선택 후 Retrieve 시 에러처리.
//    	   if (!cond_type[0].checked && !cond_type[1].checked ) {
//    		   ComShowCodeMessage("DMT02010");
//       		   ComSetFocus(cond_type[0]);
//       		   return false;
//       		}
       }
       return true;
   }
	  
    /**	 
	 * Tariff Type 을 전체 선택해준다.
	 */		
	function selectAllTariff() {
		var comboObj = comboObjects[2];
		for (var i = 0 ; i < comboObj.GetCount; i++) {
			comboObj.CheckIndex(i) = true; 
    	} 		
	}
	
    /**	 
	 * Received Tab 의 S/C Exception Tariff 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t1sheet1_OnDblClick(sheetObj,Row,Col) {
		 doProcessPopup(sheetObj, 't1sheet1');
	}
	 
    /**	 
	 * Sent Tab 의 S/C Exception Tariff 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t2sheet1_OnDblClick(sheetObj,Row,Col) {
		 doProcessPopup(sheetObj, 't2sheet1');
	}

    /**	 
	 * Sent Tab 의 S/C Exception Tariff 조회된 항목중 하나를 더블클릭한 경우 팝업으로 CRUD 화면을 띄워준다.
	 */		 
	function t3sheet1_OnDblClick(sheetObj,Row,Col) {
		 doProcessPopup(sheetObj, 't3sheet1');
	}
		
		
 	/*
 	 * 각 공통팝업창 호출 함수 
 	 */
 	function doProcessPopup(sheetObj, srcName) {
 		var formObj	= document.form;
   		var sUrl	= '';
   		var sWidth	= '';
   		var sHeight	= '';
   		var paramVal = '';
   		var sScroll = 'no';
 		
  		switch(srcName) {
  			case "t1sheet1":
  			case "t2sheet1":
  			case "t3sheet1":
  				
 				var chkRow = sheetObj.SelectRow;

				sUrl = "EES_DMT_3104.do";
				
				var inact_info    =  sheetObj.CellValue(chkRow , "inactiv_info");
				var inactInfoList = inact_info.split("|");
				
	  			var svrId 		= inactInfoList[0];
	  			var cntrNo		= inactInfoList[1];
	  			var cntrCycNo	= inactInfoList[2];
	  			var trfCd		= inactInfoList[3];
	  			var chgLocDivCd	= inactInfoList[4];
	  			var chgSeq		= inactInfoList[5];
	  			var chgOfcCd    = inactInfoList[6];
	  			var deltSeq     = inactInfoList[7];
	  			
	  			var paramVal    = "?";
	  			paramVal += "sys_area_grp_id="      + svrId;
	  			paramVal += "&cntr_no="             + cntrNo;
	  			paramVal += "&cntr_cyc_no="         + cntrCycNo;
	  			paramVal += "&dmdt_trf_cd="         + trfCd;
	  			paramVal += "&dmdt_chg_loc_div_cd=" + chgLocDivCd;
	  			paramVal += "&chg_seq="             + chgSeq;
	  			paramVal += "&chg_ofc_cd="          + chgOfcCd;
	  			paramVal += "&delt_seq="            + deltSeq;
	  			paramVal += "&prnt_mnu_id="         + "EES_DMT_3014";

	  			if (formObj.tab_cd.value == "A" && formObj.chg_delt_path_cd.value == "HDO") {
	  				paramVal += "&save_flg="            + "A";
	  			} 
	  			else if (formObj.tab_cd.value == "P" && sheetObj.CellValue(chkRow , "sts_cd") == "Request") {
	  				if (sheetObj.CellValue(chkRow , "chg_delt_usr_yn") == "Y" && sheetObj.CellValue(chkRow , "rqst_ofc_flg") == "Y") {
	  					paramVal += "&save_flg="            + "RA";
	  				} 
	  				else if (sheetObj.CellValue(chkRow , "chg_delt_usr_yn") == "Y" && sheetObj.CellValue(chkRow , "rqst_ofc_flg") == "N") {
	  					paramVal += "&save_flg="            + "A";
	  				} else {
	  					paramVal += "&save_flg="            + "R";
	  				}
	  			} 
	  			else if (sheetObj.CellValue(chkRow , "chg_delt_usr_yn") != "Y") {
	  				paramVal += "&save_flg="            + "N";
	  			} 
	  			else {	  			
	  				if (formObj.tab_cd.value == "P" || formObj.tab_cd.value == "S") {
		  				paramVal += "&save_flg="            + "A";
		  			} 
	  				else {
		  				paramVal += "&save_flg="            + "N";
		  			}
	  			}
	  			paramVal += "&tab_cd="         + formObj.tab_cd.value;
	  			
  				sUrl	= sUrl + paramVal;
          		sWidth	= '770';
          		sHeight	= '720';   	  			

	  	  		if (sUrl != '') {
	  	  			var sWinName = sUrl.substring(0, sUrl.indexOf('.do'));
	  	  			var returnValue = ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true, 'no');
	  	  			
	  	  			if (returnValue == "Y") {
	  	 				doActionIBSheet(sheetObj, formObj, IBSEARCH);
	  	 			}
	  	  		}
				break;

  		}
 	}
 	 
 	/**
 	 * S/C 및 DAR 의 Request & Approval Status 조회조건에 맞는 데이터 조회하는 동작을 정의하는 함수
 	 */ 	 
	function doActionRetrieve() {

 		var formObj = document.form;	 		
 		var sheetProssObjRcvTab = sheetObjects[0];	 		
 		var sheetEndObjRcvTab = sheetObjects[1];	
 		var sheetAllObjRcvTab = sheetObjects[2];

 		var inactNo 	= ComTrim(ComGetObjValue(formObj.inact_no));
 		var apvlNo 	= ComTrim(ComGetObjValue(formObj.apvl_no));
 		var bkgNo 	= ComTrim(ComGetObjValue(formObj.bkg_no));
 		var inactReason = ComTrim(ComGetObjValue(formObj.inact_reason));
 	    var specReason = ComTrim(ComGetObjValue(formObj.spec_reason));

 		//1.DAR 를 선택했다면, S/C No., RFA No., Proposal No., DAR No., APVL No., BKG No., B/L No. 중 반드시 1 개의 항목만 입력되어야 한다.
// 		if (formObj.cond_type[0].checked) {
 			var startDt	= ComTrim(ComGetObjValue(formObj.fm_dt));
 			var endDt	= ComTrim(ComGetObjValue(formObj.to_dt))

 			//필수입력항목 체크
 			if (startDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.fm_dt);
 				return false;
 			}
 			else if (endDt == "") {
 				ComShowCodeMessage("DMT00102", "'Update'");
 				ComSetFocus(formObj.to_dt);
 				return false;
 			}
 			
			startDt = ComGetUnMaskedValue(startDt, 	'ymd');
     		endDt 	= ComGetUnMaskedValue(endDt, 	'ymd');
            limitDt = ComGetDateAdd(startDt, "M", 12);
            if (ComChkPeriod(endDt, limitDt) == 0) {
            	ComShowCodeMessage("DMT00162", "12 month");
            	return false;
            }
// 		}
// 		else if (formObj.cond_type[1].checked) {
//			var inputFieldCount = 0;
//
//			if (inactNo 	!= "") 		inputFieldCount++;
//			if (apvlNo 	!= "") 			inputFieldCount++;
//			if (bkgNo 	!= "") 			inputFieldCount++;
//			if (inactReason 	!= "" && inactReason.substring(0,3) !=  'All') 	inputFieldCount++;
//			if (specReason 	!= "" && specReason.substring(0,3) !=  'All') 		inputFieldCount++;
//
//			if (inputFieldCount < 1) {
//			    ComShowCodeMessage("DMT01182");
//			    ComSetFocus(formObj.inact_no);
//			    return false;    			 
//			}
// 		}
 		
 		//기존에 조회된 결과가 있다면 Clear 시켜준다. =======================================
 		if (formObj.tab_cd.value == 'A') {
 			sheetAllObjRcvTab.RemoveAll();
 			doActionIBSheet(sheetAllObjRcvTab,formObj,IBSEARCH);
 		} 
 		else if (formObj.tab_cd.value == 'P') {
 			sheetProssObjRcvTab.RemoveAll();
 			doActionIBSheet(sheetProssObjRcvTab,formObj,IBSEARCH);
		} 
 		else {
 			sheetEndObjRcvTab.RemoveAll();
 			doActionIBSheet(sheetEndObjRcvTab,formObj,IBSEARCH);
		}
	}
	
 	/**
	 * S/C 및 DAR 의 Request & Approval Status 조회조건을 초기화하는 동작을 정의하는 함수
	 */ 	 
	function doActionNew() {
		 
		 initViewControls();
	}
		
	/**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem) {

 		var formObj = document.form;
        var objs = document.all.item("tabLayer");

        objs[nItem].style.display = "Inline";
        objs[beforetab].style.display = "none";

        //--------------- 요기가 중요 --------------------------//
        objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
        //------------------------------------------------------//
        beforetab= nItem;
        
        if (nItem == 0) {
    		ComSetObjValue(formObj.tab_cd, "P");
        } 
        else if (nItem == 1) {
        	ComSetObjValue(formObj.tab_cd, "S");
        } 
        else {
        	ComSetObjValue(formObj.tab_cd, "A");
        }
    }
    
 	/**
	 * S/C 및 DAR 의 Request & Approval Status 해당 팝업화면을 통해서 상세보기 동작을 정의하는 함수
	 */ 	 
	function doActionDetail() {
		var formObj 	= document.form;
		var isOpenWin 	= false;
		
		var fromSheetNo = tabObjects[0].SelectedIndex * 3;
		var toSheetNo 	= (tabObjects[0].SelectedIndex + 1) * 3;
		
		for (var sheetNo = 0 ; sheetNo < sheetObjects.length ; sheetNo++) {
			if (sheetNo < fromSheetNo || sheetNo >= toSheetNo) continue;

			var sheetObj = sheetObjects[sheetNo];

			with(sheetObj) {
				if (RowCount > 0 && SelectRow >= HeaderRows) {
					switch(id) {
						case "t1sheet1":
							doProcessPopup(sheetObj, 't1sheet1');
							isOpenWin = true;
							break;
							
						case "t2sheet1":
							doProcessPopup(sheetObj, 't2sheet1');
							isOpenWin = true;
							break;
							
						case "t3sheet1":
							doProcessPopup(sheetObj, 't3sheet1');
							isOpenWin = true;
							break;
							
					}
					if (isOpenWin) break;
				}
			}
		}
	}
	 
 	/**
	 * 조회된 결과를 Excel 파일로 다운로드 받는 동작을 정의하는 함수
	 */ 	 
	function doActionDownExcel(sheetObj) {
		
		sheetObj.SpeedDown2Excel();
	}
 	
    /**
    * 서버로부터 정상적으로 전달받지 못한 데이터를 처리해주는 함수 
    */
   function handleNullString(sVal) {
   	
        if (sVal == undefined || sVal == "null" || sVal.length == 0) return "";

        return ComTrim(sVal);
   } 	
   

	/*
	 * 다중선택된 DEM/DET Office의 하위점소(Sub Office) 조회기능 
	 */
	function doInclSubOfc() {
		var formObj = document.form;
		
		if(formObj.chk_sub_ofc.checked) {	// Sub Office 포함
			if( ComIsEmpty(comboObjects[1].Code) ) {
				ComShowCodeMessage('COM12113', "Office");
				formObj.chk_sub_ofc.checked = false;
				return;
			}
			formObj.ofc_cd.value = ComGetObjValue(comboObjects[1]);
			formObj.tmp_ofc_cd.value = ComGetObjValue(comboObjects[1]);
			doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_OFFICE, COMMAND01);
		} else {
			ComSetObjValue(comboObjects[1], formObj.tmp_ofc_cd.value);
		}
	}

	// 멀티콤보 Click Event Catch
 	function office_OnCheckClick(comboObj, index, code) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			if(comboObj.CheckIndex(index))
   				comboObj.CheckIndex(index) = false;
   			else
   				comboObj.CheckIndex(index) = true;
   			
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	
	// 멀티콤보 KeyDown Event Catch
 	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj = document.form;
		
   		if(formObj.chk_sub_ofc.checked) {
   			ComShowCodeMessage('DMT00107');
   		}
 	}
 	
 	//Tariff Type 멀티콤보 클릭 이벤트
 	function tariff_type_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	
 	//Inactive Status 멀티콤보 클릭 이벤트
 	function inact_sts_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	

 	//Inactive Status 멀티콤보 클릭 이벤트
 	function inact_reason_OnCheckClick(comboObj, index, code) {
 		var formObj = document.form;
 		
 		setMultiCombo(comboObj, index, code) ;
 		ComSetObjValue(formObj.mn_rsn_cd, comboObj.Text);
 	}

 	function inact_reason_OnBlur(){
 		var formObj = document.form;
	 		doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_RSNCDDTL, SEARCH01);	//Reason Code Detail
 	}
 	
//    //Inactive Reason 선택 이벤트
//    function inact_reason_OnChange(comboObj, Index_Code, code) {
//    	var formObj = document.form;
//    	
//		ComSetObjValue(formObj.mn_rsn_cd, comboObj.Text);
//   		doActionIBCommon(sheetObjects[0], formObj, IBSEARCH_RSNCDDTL, SEARCH01);	//Reason Code Detail
//    }
    

 	//Tariff Type 멀티콤보 클릭 이벤트
 	function spec_reason_OnCheckClick(comboObj, index, code) {
 		setMultiCombo(comboObj, index, code) ;
 	}
 	

  	/*
  	 * 각 공통팝업창 호출 함수 
  	 */
  	function openPopup(flag, arg) {
  		
  		var sheetObj = sheetObjects[0];
  		var formObj	= document.form;
  		var sUrl	= '';
  		var sWidth	= '';
  		var sHeight	= '';
  		
  		with(sheetObj) {
	  		switch(flag) {
	  			case 'inact_no':		// BKG No. 멀티입력 팝업 호출
	  			case 'bl_no':		// B/L No. 멀티입력 팝업 호출
	  			case 'bkg_no':		// CNTR No. 멀티입력 팝업 호출
	  			case 'apvl_no':		// CNTR No. 멀티입력 팝업 호출
	  				var returntitle = '';
	  				if(flag == 'bkg_no')
	  					returntitle = 'BKG No.';
	  				else if(flag == 'bl_no')
	  					returntitle = 'B/L No.';
	  				else if(flag == 'inact_no')
	  					returntitle = 'Inactive No.';
	  				else if(flag == 'apvl_no')
	  					returntitle = 'APVL No.';
	  				
	  				var param = "?returnval=" + flag + "&returntitle=" + returntitle;
	  				ComOpenPopup('EES_DMT_MULTI.do'+param, 400, 380, 'getDmt_Multi', '1,0,1,1,1,1,1,1,1,1,1,1', true);
					break;
	  			case 's_cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  				
	  		} // switch-end
  		} // with-end
  		
  	}

    /*
     * 멀티입력 팝업 페이지가 닫힌 후, 호출되는 Opener 함수
     * - 해당 필드에 멀티 입력값을 설정해준다.
     */
    function getDmt_Multi(rArray, return_val) {
    	var targObj = eval("document.form." + return_val);
    	var retStr = rArray.toString().toUpperCase();
    	
    	ComSetObjValue(targObj, retStr);
    }