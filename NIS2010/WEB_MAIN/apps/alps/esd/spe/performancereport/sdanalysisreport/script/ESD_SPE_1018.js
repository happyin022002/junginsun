/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1018.js
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
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
     * @class ESD_SPE_1018 : ESD_SPE_1018 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1018() {
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

	//공통전역변수
    var frm = null;
    var searchFlag = "0";
    var rhqXml = null;
    var ofcXml = null;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// Combo Object Array
	var comboObjects = new Array();
	var comboCnt = 0;	
	

	    
	 /**
	  * IBSheet Object를 배열로 등록
	  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	  * 배열은 소스 상단에 정의
	  */
	 function setSheetObject(sheet_obj){
	    sheetObjects[sheetCnt++] = sheet_obj;
	 }    	    
	 
	 /**
      * IBMultiCombo Object를 배열로 등록
      * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
      * 배열은 소스 상단에 정의
      */
     function setComboObject(combo_obj) {
    	 comboObjects[comboCnt++] = combo_obj;
     }
     
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;    

	 
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	 function processButtonClick() {
	 	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	 	var sheetObj    = sheetObjects[0];

	 	/*******************************************************/
	 
	 	try {
	 		var srcName = window.event.srcElement.getAttribute("name");
	 		switch (srcName) {

	 			case "btn_retrieve":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, IBSEARCH);	 
	 				break;
	 			case "btn_downexcel":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, "btn_downexcel");	 				
	 				break;
	 			case "btn_detail":
	 				// IBSHEET 조회
	 				doActionIBSheet(sheetObjects[0], frm, "btn_detail");	 				
	 				break;	 				
				case "btn_vndr_seq":
					vndr_OnPopupClick();
			        break;	 	
		        case "btns_calendar1": //달력버튼
		        	var cal = new ComCalendar();
		        	cal.setDisplayType('month');
		        	cal.select(frm.from_dt, 'yyyy-MM');
		        	break;
		        
		        case "btns_calendar2":
			        var cal = new ComCalendar();
			        cal.setDisplayType('month');
			        cal.select(frm.to_dt, 'yyyy-MM');
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
	 * body 태그의 onLoad 이벤트핸들러 구현 <br>
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br> 
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  없음
	 * @return 없음
	 * @see #
	 * @author Choi Do Soon
	 * @version 2009.11.16
	 */
	function loadPage(year) {
		frm = document.form;
	    for(i=0;i<sheetObjects.length;i++){
			 //-시작 환경 설정 함수 이름 변경
			 ComConfigSheet(sheetObjects[i]);
			 initSheet(sheetObjects[i],i+1);
			 //-마지막 환경 설정 함수 추가
			 ComEndConfigSheet(sheetObjects[i]);
		 }
	    
	     // combo 생성
	     doActionIBCombo(frm.s_sd_gp); // SD Group
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // Level3
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }
         // 현재년도 설정
         if (frm.from_dt.value == "") {
        	 frm.from_dt.value = year+'-01';
         }
         if (frm.to_dt.value == "") {
        	 frm.to_dt.value = year+'-12';
         }
         frm.s_ev_yr.value = year;
         initControl();
         
	}



	/**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * @param {ibsheet} sheetObj    IBSheet Object
	 * @param {int}     sheetNo     sheetObjects 배열에서 순번
	 **/	
	function initControl() {
		axon_event.addListenerForm('keypress',   'obj_keypress',      frm); //- 키 눌렸을때
		axon_event.addListenerForm('blur'    ,   'obj_blur'    ,      frm ); //- 포커스 나갈때
        axon_event.addListenerForm('change',     'obj_change', frm);
        axon_event.addListener ('keydown', 'keydownEnter', 'form');
	}
	
	 /**
	  * HTML Control KeyDown 이벤트 호출
	  */
	 function keydownEnter() {
	 	if (event.keyCode != 13) {
	 		return;
	 	}
	 	doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
	 	focusOut();
	  
	 } 	
	
	/**
	* HTML Control의 onkeypress 이벤트에서 숫자만 입력되게 한다. <br>
	**/
	function obj_keypress(){
		 switch(event.srcElement.dataformat){
	        case "float":
	            //숫자+"."입력하기
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	            ComKeyOnlyAlphabet();
	            break;		
	        case "num":
	        	//영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
	        	ComKeyOnlyAlphabet('num');
	        	break;		
	        case "engdn":
	            //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
	            ComKeyOnlyAlphabet('lower');
	            break;		
	        case "uppernum":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('uppernum','32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|75|76|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113|114|115|116|117|118|119|120|121|122|123|124|125|126');
	            break;    
	        case "engup":
	            //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	        	ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	        	//숫자만입력하기(정수,날짜,시간)
	        	ComKeyOnlyNumber(event.srcElement);            
		}	
	}	
 	
 	
    /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
    function initCombo(comboObj, comboNo) {
    	comboObj.ValidChar(2,0);
    	comboObj.UseAutoComplete = true;
    	 switch(comboObj.id) {
   	  		case "s_eg_rhq_cd":
        		comboObj.DropHeight = 250;
  			break;  
   	  		case "s_eg_ofc_cd":
   	  			comboObj.DropHeight = 250;
   	  			break;  
   	  		case "s_ev_svc_cate_cd":
   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
   	  			break;  
   	  		case "s_ev_mon":
   	  		   comboObj.InsertItem(0, "", "");
   	  		   comboObj.InsertItem(1, "1", "1");
   	  		   comboObj.InsertItem(2, "2", "2");
   	  		   comboObj.InsertItem(3, "3", "3");
   	  		   comboObj.InsertItem(4, "4", "4");
   	  		   comboObj.InsertItem(5, "5", "5");
   	  		   comboObj.InsertItem(6, "6", "6");
   	  		   comboObj.InsertItem(7, "7", "7");
   	  		   comboObj.InsertItem(8, "8", "8");
   	  		   comboObj.InsertItem(9, "9", "9");
   	  		   comboObj.InsertItem(10, "10", "10");
   	  		   comboObj.InsertItem(11, "11", "11");
   	  		   comboObj.InsertItem(12, "12", "12");
   	  		   comboObj.DropHeight = 300;
   	  			break;  
   	  	}
    	
    }	

	function obj_change(){
		var obj = event.srcElement;
		switch(obj.name) {
			case "s_sp_seq":
				
		 		 if(frm.s_eg_rhq_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 1'); //Level 1 값을 입력하셔야 합니다
		 			 frm.s_sp_seq.value="";
					 frm.s_sp_nm.value="";
		 			 return false;
		 		 }
		 		 if(frm.s_eg_ofc_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 2'); //Level 2 값을 입력하셔야 합니다
		 			 frm.s_sp_seq.value="";
					 frm.s_sp_nm.value="";
		 			 return false;
		 		 }
		 		 if(frm.s_ev_svc_cate_cd.Code  == ""){
		 			 ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
		 			 frm.s_sp_seq.value="";
					 frm.s_sp_nm.value="";
		 			 return false;
		 		 }	 		
		 		 vender_change();
		 		 
			break;
		}
	}


	
	/**
	 * S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	 */
	function vender_change(){
		// s/p 코드값이 변경되면 기존 저장값을 초기화 해야한다.
		if(frm.s_sp_seq.value =="" ){
			frm.s_sp_seq.value="";
			frm.s_sp_nm.value="";
			// DB 에 넘어갈 파라미터 정의
			frm.sp_seq.value="";
			return;
		}else {
			frm.f_cmd.value = SEARCH01;
			// DB 에 넘어갈 파라미터 정의
			frm.vndr_cd.value=frm.s_sp_seq.value;
			frm.s_ev_yr.value=frm.from_dt.value.substr(0,4);
			var sXml=sheetObjects[1].GetSearchXml("ESD_SPE_1022GS.do", FormQueryString(frm));
			var vndrNm = SpeXmlString(sXml,"vndr_lgl_eng_nm");
			if(vndrNm==0){
				ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
				frm.s_sp_seq.value="";
				frm.s_sp_nm.value="";
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value="";
				return;
			}else{
				frm.s_sp_nm.value = vndrNm;
			}
		}
		
	}	
	
	
	/**
	 * Terminal 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	 */
	function tml_change(tmlCd){
		if(tmlCd =="" ){
			frm.s_tml_cd.value="";
			return;
		}else {
			frm.f_cmd.value = COMMAND06;
			frm.tml_cd.value=tmlCd;
			// DB 에 넘어갈 파라미터 정의
			var sXml=sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var isflag = SpeXmlString(sXml,"isflag");
			if(isflag==0){
				ComShowCodeMessage('COM132202', 'Terminal'); //사용할수 없는 S/P Code 
				frm.s_tml_cd.value="";
				return;
			}
		}
		
	}	
	
	
	/**
	 * Terminal 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
	 */
	function tml_change_grid(sheetObj, row, col ,value){
		if(value =="" ){
			frm.s_tml_cd.value="";
			return;
		}else {
			frm.f_cmd.value = COMMAND06;
			frm.tml_cd.value=value;
			// DB 에 넘어갈 파라미터 정의
			var sXml=sheetObjects[1].GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
			var isflag = SpeXmlString(sXml,"isflag");
			if(isflag==0){
				ComShowCodeMessage('COM132202', 'Terminal'); //사용할수 없는 S/P Code 
				sheetObj.CellValue2(row, col) = "";
				return;
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

	 	switch(sheetNo) {
		  	case 1:      //IBSheet1 init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = GetSheetHeight(21) ;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = 7;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = false;
	
	                var HeadTitle1 = "|Year|Office|Office|Service Category|Evaluation Group|Evaluation Group|Service Provider|Service Provider|SD Group|P.A. Result|P.A. Result|B.A. Result|B.A. Result" ;
	                var HeadTitle2 = "|Year|RHQ|Branch|Service Category|ID|Name|ID|Name|SD Group|Point|Group|B.A. Result|B.A. Result" ;
	                var headCount = ComCountHeadTitle(HeadTitle1);
	                
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(2, 1, 10, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                HeadRowHeight = 12;
	              //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,      SAVENAME,         KEYFIELD, CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,  daCenter,  true,	  "ibflag");
	                InitDataProperty(0, cnt++ , dtData,         45,  daCenter,  true,     "ev_yr",          false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         45,  daCenter,  true,     "eg_rhq_cd",      false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         45,  daCenter,  true,     "eg_ofc_cd",	    false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         110, daCenter,  true,     "ev_svc_cate_cd", false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         70,  daCenter,  true,     "eg_id",		    false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         100, daCenter,  true,     "eg_nm",          false,          "",       dfNone,       0,     false,       false);
	                
					InitDataProperty(0, cnt++ , dtData,         50,  daCenter,  true,     "sp_seq",         false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,         170, daLeft,    true,     "sp_name",        false,          "",       dfNone,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,         60,  daCenter,  true,     "sd_group",       false,          "",       dfNone,       0,     false,       false);                    
	                InitDataProperty(0, cnt++ , dtData,         50,  daRight,   false,    "pa_point",       false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         80,  daCenter,  false,    "pa_group",	    false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtHidden,       50,  daRight,   true,     "be_point",	    false,          "",       dfNone,       0,     false,       false);
	                InitDataProperty(0, cnt++ , dtData,         100, daCenter,  true,     "be_group", 	    false,          "",       dfNone,       0,     false,       false);
	                
	           }
	           break;        

	    	case 2:      //sheet2 init
	    		with (sheetObj) {
	    		// 높이 설정
	    		style.height = 0;
	    		//전체 너비 설정
	    		SheetWidth = mainTable.clientWidth;
	    		
	    		//Host정보 설정[필수][HostIp, Port, PagePath]
	    		if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	    		
	    		//전체Merge 종류 [선택, Default msNone]
	    		MergeSheet = msHeaderOnly;
	    		
	    		//전체Edit 허용 여부 [선택, Default false]
	    		Editable = true;
	    		
	    		//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	    		InitRowInfo(1, 1, 10, 100);
	    		
	    		//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	    		InitColumnInfo(2, 0, 0, true);
	    		
	    		// 해더에서 처리할 수 있는 각종 기능을 설정한다
	    		InitHeadMode(true, true, true, true, false,false) ;
	    		
	    		var HeadTitle1 = "ibflag|";
	    		
	    		//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	    		InitHeadRow(0, HeadTitle1, true);
	    		
	    		HeadRowHeight = 12;
	    		//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	    		InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	false,	"ibflag");
	    		InitDataProperty(0,	cnt++,	dtCheckBox,	    30,		daCenter,	false,	"chk");
	    		
//					InitDataValid(0, "sp_cd", vtEngUpOnly);
	    		
	    	    }
	    		break;				

			}
		}	
	 

	//SHEET 관련 프로세스 처리
	function doActionIBSheet(sheetObj, frm, sAction) {
		sheetObj.ShowDebugMsg = false;
		
		switch (sAction) {

			// SEARCH LOGIC
			case IBSEARCH:
				if(!validateForm(sheetObj,frm,sAction)) return;
        	    sheetObj.RemoveAll();
				frm.f_cmd.value = SEARCH01;
				var sParam = FormQueryString(frm);

				var sXml = sheetObj.GetSearchXml("ESD_SPE_1018GS.do", sParam);
				sheetObj.loadSearchXml(sXml);
				break;
		
			case "btn_downexcel":	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				
				break;
			case "btn_detail":	    // EXCEL DOWNLOAD
				var sRow= sheetObj.SelectRow;
				if( sRow < 1){
					ComShowCodeMessage('COM12113', 'Row'); //Row 를 선택해주세요
					return;
				}
				var ev_yr          = sheetObj.CellValue(sRow,"ev_yr");
				var eg_rhq_cd      = sheetObj.CellValue(sRow,"eg_rhq_cd");
				var eg_ofc_cd	   = sheetObj.CellValue(sRow,"eg_ofc_cd");
				var ev_svc_cate_cd = sheetObj.CellValue(sRow,"ev_svc_cate_cd");
				var eg_id		   = sheetObj.CellValue(sRow,"eg_id");
				var eg_nm          = sheetObj.CellValue(sRow,"eg_nm");
				var sp_seq         = sheetObj.CellValue(sRow,"sp_seq");
				var sp_name        = sheetObj.CellValue(sRow,"sp_name");
				var sd_group       = sheetObj.CellValue(sRow,"sd_group");
				var pa_point       = sheetObj.CellValue(sRow,"pa_point");
				var pa_group	   = sheetObj.CellValue(sRow,"pa_group");
				var be_point	   = sheetObj.CellValue(sRow,"be_point");
				var be_group	   = sheetObj.CellValue(sRow,"be_group");
				
				var param= "?EV_YR="+ev_yr+"&EG_RHQ_CD="+eg_rhq_cd+"&EG_OFC_CD="+eg_ofc_cd+
				           "&EV_SVC_CATE_CD="+ev_svc_cate_cd+"&EG_ID="+eg_id+
				           "&EG_NM="+eg_nm+"&SP_SEQ="+sp_seq+
				           "&SP_NAME="+sp_name+"&SD_GROUP="+sd_group+
				           "&PA_POINT="+pa_point+"&PA_GROUP="+pa_group+
				           "&BE_POINT="+be_point+"&BE_GROUP="+be_group;
				ComOpenPopup('/hanjin/ESD_SPE_1019.do' + param, 1024, 600, "", '1,0,1,1,1',false);
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.WaitImageVisible = false;
        switch(comboObj.id) {
        case "s_sd_gp":  
        	rhqXml = searchCommonCombo("CD03397",frm.s_sd_gp,sheetObj); 
        	comboObj.InsertItem(0, "", "");
        	break;  
	    case "s_eg_rhq_cd":  
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj); 
	    	comboObj.InsertItem(0, "", "");
	    	doActionIBCombo(frm.s_eg_ofc_cd)
	    	break;  
	    case "s_eg_ofc_cd":  
	    	frm.f_cmd.value = COMMAND02;
	        // eg_rhq_cd 에 값이 있으면 GRID office 값이 변경이 된다.
	        frm.eg_rhq_cd.value = "";
	    	var sXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
	    	frm.s_eg_ofc_cd.RemoveAll();
	    
	    	ComXml2ComboItem(sXml, frm.s_eg_ofc_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_ofc_cd.Index=0;
	    	break;  
	  	case "s_ev_svc_cate_cd":  
	  		searchCommonCombo("CD03377",frm.s_ev_svc_cate_cd,sheetObj); 
	  		comboObj.InsertItem(0, "", "");
			break;  	    	

        }
        sheetObj.WaitImageVisible = true;
    }
    
    
	 
	 /**
	  * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	  */
	  function validateForm(sheetObj,frm,sAction){
	 	 switch(sAction) {
	 	 case IBSEARCH :
	 		 if(frm.from_dt.value  == ""){
	 			 ComShowCodeMessage('COM130201', 'From Date'); //From Date 값을 입력하셔야 합니다
	 			 return false;
	 		 }
	 		 if(frm.to_dt.value  == ""){
	 			 ComShowCodeMessage('COM130201', 'To Date'); //To Date 값을 입력하셔야 합니다
	 			 return false;
	 		 }
	 		 if(frm.s_eg_rhq_cd.Code  == ""){
		 		 ComShowCodeMessage('COM130201', 'Level 1'); //Level 1 값을 입력하셔야 합니다
		 		 return false;
		 	 }
		 	 if(frm.s_eg_ofc_cd.Code  == ""){
		 		 ComShowCodeMessage('COM130201', 'Level 2'); //Level 2 값을 입력하셔야 합니다
		 		 return false;
		 	 }
		 	 if(frm.s_ev_svc_cate_cd.Code  == ""){
		 		 ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
		 		 return false;
		 	 }	 		 		 
	 		 break;
	 	 } // end switch()
	 	 return true;
	  }	 
      
      
	  

	  
	  function s_eg_rhq_cd_OnChange(comboObj,Index_Code, Text){
		sheetObjects[0].RemoveAll();
		doActionIBCombo(frm.s_eg_ofc_cd); // RHQ
	  }
	  
	  function s_eg_ofc_cd_OnChange(comboObj,Index_Code, Text){
		  sheetObjects[0].RemoveAll();
	  }
	  function s_ev_svc_cate_cd_OnChange(comboObj,Index_Code, Text){
		  sheetObjects[0].RemoveAll();
	  }
	  

  
	    
	  /**
	   * COM_ENS_061 팝업호출
	   */
	  function vndr_OnPopupClick() {
		  var returnFun = "";
		  var param = "";
		  var evSvcCateCd =frm.s_ev_svc_cate_cd.Code;    
		  var evSvcCateNm =frm.s_ev_svc_cate_cd.Text ; 
		  
		  if(evSvcCateCd==""){
			  ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
			  return;
		  }
		  param ="?EV_SVC_CATE_CD="+evSvcCateCd+"&EV_SVC_CATE_NM="+evSvcCateNm+
		         "&EG_RHQ_CD="+frm.s_eg_rhq_cd.Code+"&EG_OFC_CD="+frm.s_eg_ofc_cd.Code+"&EV_YR="+frm.s_ev_yr.value+
		         "&SEARCH_TYPE=A";
		ComOpenPopup('/hanjin/ESD_SPE_1022.do' + param, 699, 422, "callBackVndr", '1,0,1,1,1',false);
	   }	 	    
	    
	    
		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
		function callBackVndr(rowArray) {
			for(var i=0; i<rowArray.length; i++){
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				
				frm.s_sp_seq.value =colArray2;
				frm.s_sp_nm.value =colArray4;
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value =colArray2;
			}
		}
		
	    /**
	     * Sheet1 의 Double Click Event 처리 <br>
	     */      
	    function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
	    	doActionIBSheet(sheetObj, frm, "btn_detail");
	    }		

		
	/* 개발자 작업  끝 */