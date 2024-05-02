/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_SPE_1013.js
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
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
     * @class ESD_SPE_1013 : ESD_SPE_1013 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_SPE_1013() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.calEndFunction 			= calEndFunction;
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
	
    var temYear ="";
	    
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
//	 				if(validateForm(sheetObjects[0],frm,srcName)){
//	 				}
	 				break;
	 				
	 			case "btn_save":
 					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
	 				break;
				case "btn_vndr_seq":
					vndr_OnPopupClick("form");
			        break;	 	
	 				
	 				
	 			case "btn_RowAdd":
	 				doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
	 				break;
                case "btn_tml_cd":		// Yard
                	//ComOpenPopupWithTarget('/hanjin/COM_ENS_061.do', 1000, 450, "3:crnt_yd_cd", "1,0,1,1,1,1,1", true);
                	ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYard", "1,0,1,1,1", true, false);
                	break;
	 				
	 			case "btn_RowDel":
	 				if(sheetObjects[0].FindCheckedRow("chk") == ""){

	 				}else if(ComShowCodeConfirm("COM12171","")){
	 					doActionIBSheet(sheetObjects[0], frm, IBDELETE);
	 				}
	 				break;
	 				
				case "btn_audit_month":
					temYear = frm.s_ev_yr.value;
					var cal = new ComCalendar();
						cal.setDisplayType('year');
						cal.setEndFunction('calEndFunction');
						cal.select(frm.s_ev_yr, 'yyyy');
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
	     doActionIBCombo(frm.s_eg_rhq_cd); // Level1
	     doActionIBCombo(frm.s_ev_svc_cate_cd); // Level3
	     //IBMultiCombo 설정
         for(var k = 0; k < comboObjects.length; k++){
       	  	 initCombo(comboObjects[k], k + 1);
         }
         // 현재년도 설정
         if (frm.s_ev_yr.value == "") {
        	 frm.s_ev_yr.value = year;
         }
         initControl();
         
//         sheet1_OnLoadFinishLoad(sheetObjects[0])
         
	}


	 function calEndFunction(){ 
		 if(temYear != frm.s_ev_yr.value){
			 sheetObjects[0].RemoveAll();
			 temYear = frm.s_ev_yr.value; 
		 }
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
//   	  			comboObj.Index=0;
   	  			comboObj.DropHeight = 300;
   	  		    comboObj.Code = "TM";
   	  		    comboObj.Enable= false;
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
		 		 sheetObjects[0].RemoveAll();
		 		 
			break;
			case "s_tml_cd":
				 sheetObjects[0].RemoveAll();
				 tml_change(frm.s_tml_cd.value);
				
			break;
			case "s_ev_yr":
				if(!ComChkObjValid(obj))obj.value="" ;
				sheetObjects[0].RemoveAll();
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
	    	case 1:      //sheet1 init
		    	with (sheetObj) {
					// 높이 설정
					style.height = GetSheetHeight(20);
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				    //전체Edit 허용 여부 [선택, Default false]
				    Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(2, 1, 10, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(15, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false,false) ;

					var HeadTitle1 = "ibflag|Seq.|CHK|EG ID|EG Name|S/P Code|S/P Name|Year|Terminal|Prior Year|Prior Year|Target|Remark|EV_TML_PROD_TGT_SEQ|isflag";
					var HeadTitle2 = "ibflag|Seq.|CHK|EG ID|EG Name|S/P Code|S/P Name|Year|Terminal|Performance|Target|Target|Remark|EV_TML_PROD_TGT_SEQ |isflag";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);

					HeadRowHeight = 12;
					//데이터속성    [ROW,   COL,  DATATYPE,    WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,              KEYFIELD, CALCULOGIC, DATAFORMAT,     POINTCOUNT, UPDATEEDIT,INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0,	cnt++,	dtHiddenStatus,	50,		daCenter,	true,	"ibflag");
					InitDataProperty(0,	cnt++,	dtDataSeq,		30,		daCenter,	true,	"seq");
					InitDataProperty(0,	cnt++,	dtCheckBox,     50,		daCenter,	true,	"chk");         
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "eg_id",         	         false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         100,  	daCenter,   true,   "eg_nm",                     false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtPopupEdit,    75,  	daCenter,   true,   "sp_seq",                    true,     "",     dfNone,          0,          true,         true,   10);
					InitDataProperty(0, cnt++ , dtData,         170,  	daLeft,     true,   "sp_name",                   false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         70,  	daCenter,   true,   "ev_yr",                     true,     "",     dfNone,          0,          false,        false,   4);
					InitDataProperty(0, cnt++ , dtPopupEdit,    80,  	daCenter,   true,   "tml_cd",                    true,     "",     dfNone,          0,          true,         true,   10);
					InitDataProperty(0, cnt++ , dtData,         80,  	daCenter,   true,   "pre_perf_rto",              false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "pre_tgt_rto",               false,    "",     dfNone,          0,          false,        false,  10);
					InitDataProperty(0, cnt++ , dtData,         60,  	daCenter,   true,   "kpi_tgt_rto",               true,     "",     dfNullFloat,     2,          true,         true,   5);
					InitDataProperty(0, cnt++ , dtData,         110,  	daLeft,     true,   "kpi_rmk",                   false,    "",     dfNone,          0,          true,         true,   2000);
					InitDataProperty(0, cnt++ , dtHidden,       110,  	daLeft,     true,   "ev_tml_prod_tgt_seq",      true,     "",     dfNone,          0,          true,         true,   10);
					InitDataProperty(0, cnt++ , dtHidden,       0,  	daLeft,     true,   "isflag",                    true,     "",     dfNone,          0,          true,         true,   10);
//					InitDataValid(0, 8, vtEngUpOnly);
					
					InitDataValid(0, "sp_seq"       , vtNumericOnly);
//					InitDataValid(0, "kpi_tgt_rto"  , vtNumericOther, ".");
					InitDataValid(0, "ev_yr"        , vtNumericOnly);
					
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
				sheetObj.ShowDebugMsg = false;
				if(validateForm(sheetObj,frm,sAction)){
					searchFlag="1";
					sheetObjects[0].RemoveAll();
					frm.f_cmd.value = SEARCH01;
					var sParam = FormQueryString(frm);
//					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("ESD_SPE_1013GS.do", sParam);
					sheetObj.loadSearchXml(sXml);
					
//					ComOpenWait(false);
				}
				break;
		
			// SAVE LOGIC
			case IBSAVE:
				if(!validateForm(sheetObj,frm,sAction)) return false;
				if (!ComShowCodeConfirm("COM130101")) return; // Do you want to save {?msg1}?
				
            	frm.f_cmd.value = MULTI01;
				var sParam = sheetObj.GetSaveString(false, true) + "&" + FormQueryString(frm);
		    		ComOpenWait(true);
            	
			        var sXml = sheetObjects[0].GetSaveXml("ESD_SPE_1013GS.do", sParam);
					var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
					if (State != "S") {
						ComShowCodeMessage('COM130103', 'Data');
						ComOpenWait(false);
						return false;
					} else if (State == "S") {
						ComShowCodeMessage('COM130102', 'Data');
						doActionIBSheet(sheetObjects[0], frm, IBSEARCH);
					}
					
					ComOpenWait(false);
		    				
				break;
			case IBDELETE :
	   	   		if(sheetObj.FindCheckedRow("chk") != ""){
					ComRowHideDelete(sheetObj,"chk"); 
				}
			    break;			
			case "btn_downexcel":	// EXCEL DOWNLOAD
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "");
				break;
			case IBCOPYROW:	// Copy Row
				
				if (searchFlag=="0" && sheetObjects[0].RowCount == 0) {
					ComShowCodeMessage('SPE10008', ''); //조회후 추가하세요
					return false;
				}
				if (searchFlag=="1" && sheetObjects[0].RowCount == 0) {
					ComShowCodeMessage('SPE10002', 'EG ID'); //선택된 EG ID 가 없습니다
					return false;
				}
				
				var row = sheetObj.DataCopy();
				sheetObj.CellValue2(row, 'sp_seq')                   = "";
				sheetObj.CellValue2(row, 'sp_name')                  = "";
				sheetObj.CellValue2(row, 'tml_cd')                   = "";
				sheetObj.CellValue2(row, 'pre_perf_rto')             = "";
				sheetObj.CellValue2(row, 'pre_tgt_rto')              = "";
				sheetObj.CellValue2(row, 'kpi_tgt_rto')              = "";
				sheetObj.CellValue2(row, 'kpi_rmk')                  = "";
				sheetObj.CellValue2(row, 'ev_tml_prod_tgt_seq')  = "";
				break;
		}
	}


    // Combo관련 프로세스 처리
    function doActionIBCombo(comboObj) {
    	var sheetObj = sheetObjects[1];
    	
    	sheetObj.WaitImageVisible = false;
        switch(comboObj.id) {
	    case "s_eg_rhq_cd":  
//	        frm.f_cmd.value = COMMAND01;
//
//	        rhqXml = sheetObj.GetSearchXml("ESD_SPE_COMGS.do", FormQueryString(frm));
//	        frm.s_eg_rhq_cd.RemoveAll();
//	    	ComXml2ComboItem(rhqXml, frm.s_eg_rhq_cd, "eg_ofc_cd", "eg_ofc_cd");
	    	rhqXml = search03CommonCombo("CD03373",frm.s_eg_rhq_cd,sheetObj); 
	    	comboObj.InsertItem(0, "", "");
//	    	frm.s_eg_rhq_cd.Code2=frm.eg_rhq_cd.value;
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
	 	 case IBSAVE :
			if(sheetObj.RowCount<1){
				ComShowCodeMessage('COM130201', 'Grid'); //Grid 값을 입력하셔야 합니다
				return false;
			}
			
			// 그리드에 필수값 입력 했는지 체크
         	if(sheetObj.GetSaveString(false, true)==""){
        		return false;
        	}	 	
         	

			
			
	 		 break;	 		 
	 	 } // end switch()
	 	 return true;
	  }	 
      
      
	  
	  /**
	   * Sheet1 의 OnSearchEnd 이벤트처리 <br>
	   * @param  {object} sheetObj	필수	 Sheet Object
	   * @param  {string} ErrMsg		필수 String
	   * @return 없음
	   */ 
// 사용자 요청으로 로직 변경
//	  function sheet1_OnSearchEnd(sheetObj, ErrMsg){
//		  with(sheetObj){
//			  for(var i=2; i<= rowcount+1; i++){
//				  if(cellValue(i,'tml_cd')==""){
//					  // tml_cd null 이면 저장하지 않은 데이터여서 상태값을 입력으로 변경한다.
//					  sheetObj.RowStatus(i)="I";
//				  }
//			  }
//		  }
//	  } 
	  
      /**
       * 콜백 함수. <br>
       * @param  {Array} aryPopupData	필수	 Array Object
       * @param  {Int} row				필수 선택한 Row
       * @param  {Int} col				필수 선택한 Column
       * @param  {Int} sheetIdx			필수 Sheet Index
       * @return 없음
       * @author 김창식
       * @version 2009.07.16
       */   
      function callBackYard(aryPopupData, row, col, sheetIdx){
           	 
          var formObj = document.form;
          var crntYdCd = "";
          var i = 0;
          
          for(i = 0; i < aryPopupData.length; i++){
          	
          	crntYdCd = crntYdCd + aryPopupData[i][3];
          	
          	if(i < aryPopupData.length - 1){
          		crntYdCd = crntYdCd + ",";
           	}
          }
           	 
          frm.s_tml_cd.value = crntYdCd;
          
          //chungpa 20091015 check yard
          //checkGroup2Yard();
      }
      
      
      /**
       * 콜백 함수. <br>
       * @param  {Array} aryPopupData	필수	 Array Object
       * @param  {Int} row				필수 선택한 Row
       * @param  {Int} col				필수 선택한 Column
       * @param  {Int} sheetIdx			필수 Sheet Index
       * @return 없음
       * @author 
       * @version 2015.02.24
       */   
      function callBackYardGrid(aryPopupData, row, col, sheetIdx){
    	  
    	  var formObj = document.form;
    	  var crntYdCd = "";
    	  var i = 0;
    	  
    	  for(i = 0; i < aryPopupData.length; i++){
    		  
    		  crntYdCd = crntYdCd + aryPopupData[i][3];
    		  
    		  if(i < aryPopupData.length - 1){
    			  crntYdCd = crntYdCd + ",";
    		  }
    	  }
    	  
    	  sheetObjects[sheetIdx].CellValue2(row, col)=crntYdCd;
    	  check_dup(sheetObjects[sheetIdx],sheetObjects[sheetIdx].ColSaveName(col),row, col);
    	  
    	  
    	  //chungpa 20091015 check yard
    	  //checkGroup2Yard();
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
	   * sheet1 OnChange 이벤트
	   * @param {ibsheet} sheet 해당 시트   
	   * @param {long} row 해당 셀의 Row Index
	   * @param {long} col 해당 셀의 Column Index
	   * @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
	   */
	  function sheet1_OnChange(sheetObj, row, col ,value) {
		  var sName = sheetObj.ColSaveName(col);
		  switch(sName){
		    case "sp_seq" :
		    	 grid_Vender_Change(sheetObj, row, col ,value);
		    	 check_dup(sheetObj,sName,row, col);
			     break;
		    case "tml_cd" :
		    	 tml_change_grid(sheetObj, row, col ,value);
		    	 check_dup(sheetObj,sName,row, col);
			     break;			     

		    		
		  }
	  }
	  
	  function check_dup(sheetObj,sName,row, col){
		  sheetObj.SpaceDupCheck = false;
		  var dupVal = sheetObj.ColValueDup("sp_seq|tml_cd", false)
			if(dupVal> 0){
				if(sheetObj.CellValue(row,"sp_seq")!="" && sheetObj.CellValue(row,"tml_cd")!=""){
					if(sName == "sp_seq"){
						ComShowCodeMessage('COM12115','S/P Code');
						sheetObj.CellValue2(row,"sp_seq")="";
						sheetObj.CellValue2(row,"sp_name")="";
					}else{
						ComShowCodeMessage('COM12115','Terminal');
						sheetObj.CellValue2(row,sName)="";
					}
					return;
				}
			}
		  
	  }
		  
	  
		/**
	 	 * sheet1의 OnPopupClick Event 처리부분.<br>
	 	 * @param sheetObj
	 	 * @param Row
	 	 * @param Col
	 	 */
	    function sheet1_OnPopupClick(sheetObj,row,col) {
	 		with(sheetObj) {
				var sName = ColSaveName(col);

				switch(sName) {
					case "sp_seq":		//Yard Code No Pop-up
						vndr_OnPopupClick("grid")
						break;
					case "tml_cd":		//Yard Code No Pop-up
						ComOpenPopup('/hanjin/COM_ENS_061.do', 800, 475, "callBackYardGrid", "1,0,1,1,1", true, false, row, col, 0); 
						break;
				}
	 		}
	    }	  
	    
	  /**
	   * COM_ENS_061 팝업호출
	   */
	  function vndr_OnPopupClick(callType) {
		  var returnFun = "";
		  var param = "";
		  var evSvcCateCd =frm.s_ev_svc_cate_cd.Code;    
		  var evSvcCateNm =frm.s_ev_svc_cate_cd.Text ; 
		  
		  if(evSvcCateCd==""){
			  ComShowCodeMessage('COM130201', 'Level 3'); //Level 3 값을 입력하셔야 합니다
			  return;
		  }
		  
		  if(callType == "grid"){
			  var sheetObj = sheetObjects[0];
			  returnFun = "callBackVndr_Grid";
			  param = "?EG_ID="+sheetObj.CellValue(sheetObj.SelectRow,"eg_id")+"&EG_NM="+sheetObj.CellValue(sheetObj.SelectRow,"eg_nm")+
			          "&EV_SVC_CATE_CD="+evSvcCateCd+"&EV_SVC_CATE_NM="+evSvcCateNm+
			          "&EG_RHQ_CD="+frm.s_eg_rhq_cd.Code+"&EG_OFC_CD="+frm.s_eg_ofc_cd.Code+"&EV_YR="+frm.s_ev_yr.value+
			          "&SEARCH_TYPE=A";
		  }else{
			  returnFun = "callBackVndr_Form"
			  param ="?EV_SVC_CATE_CD="+evSvcCateCd+"&EV_SVC_CATE_NM="+evSvcCateNm+
			         "&EG_RHQ_CD="+frm.s_eg_rhq_cd.Code+"&EG_OFC_CD="+frm.s_eg_ofc_cd.Code+"&EV_YR="+frm.s_ev_yr.value+
			         "&SEARCH_TYPE=A";
			  
		  }
			
			ComOpenPopup('/hanjin/ESD_SPE_1022.do' + param, 699, 422, returnFun, '1,0,1,1,1',false);
	   }	 	    
	    
	    
		/**
		* S/P Code 팝업호출 : 팝업에서 단일 선택을 한경우..
		*/
		function callBackVndr_Form(rowArray) {
			for(var i=0; i<rowArray.length; i++){
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				
				frm.s_sp_seq.value =colArray2;
				frm.s_sp_nm.value =colArray4;
				// DB 에 넘어갈 파라미터 정의
				frm.sp_seq.value =colArray2;
				sheetObjects[0].RemoveAll();
			}
		}
		
		
		/**
		 * S/P Code 팝업호출 : 그리드에서 선택을 한경우..
		 */
		function callBackVndr_Grid(rowArray) {
			var sheetObj = sheetObjects[0];
			for(var i=0; i<rowArray.length; i++){
				var colArray = rowArray[0];
				var colArray2 = colArray[2];
				var colArray3 = colArray[3];
				var colArray4 = colArray[4];
				sheetObj.CellValue2(sheetObj.SelectRow,"sp_seq") =colArray2;
				sheetObj.CellValue2(sheetObj.SelectRow,"sp_name") =colArray4;
			}
			
		}	  
	  
		/**
		* S/P 정보를 조회 하여 존재하는 코드인지 확인하고 있으면 명칭을 입력한다.
		*/
		function grid_Vender_Change(sheetObj, row, col ,value){
			
			if(value == "" ){
				sheetObj.CellValue2(row,"sp_seq") = "";
				sheetObj.CellValue2(row,"sp_name") = "";
				return;
			}else {
				frm.f_cmd.value = SEARCH01;
				frm.vndr_cd.value = value;
				frm.ev_svc_cate_cd.value = frm.s_ev_svc_cate_cd.Code;
				var param = FormQueryString(frm)
				var sXml=sheetObjects[0].GetSearchXml("ESD_SPE_1022GS.do", param);
				var vndrSeq = SpeXmlString(sXml,"vndr_seq");
				var vndrNm = SpeXmlString(sXml,"vndr_lgl_eng_nm");
				if(vndrNm==0){
					ComShowCodeMessage('COM132202', 'S/P Code'); //사용할수 없는 S/P Code 
					sheetObj.CellValue2(row,"sp_seq") = "";
					sheetObj.CellValue2(row,"sp_name") = "";
					sheetObj.CellValue2(row,"sp_grp_ofc_cd") = "";
					sheetObj.CellValue2(row,"sp_ctrl_ofc_cd") = "";
					return;
				}else{
					sheetObj.CellValue2(row,"sp_seq") = vndrSeq;
					sheetObj.CellValue2(row,"sp_name") = vndrNm;
				}
			}
		}
		




	/* 개발자 작업  끝 */