/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0104.js
*@FileTitle : EAC Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2008-09-17 O Wan-Ki  1.0 최초 생성
* 2009-08-17 Sun, CHOI 1.1 ALPS Migration
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
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
     * @class ESD_TPB_0104 : ESD_TPB_0104 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_TPB_0104() {
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
	/* 공통전역변수 */
  var curTab = 1;
  var beforetab = 0;
  var sheetObjects = new Array();
  var sheetCnt = 0;

  	/**
  	 * IBTab Object를 초기화 설정
  	 * 탭 ID는 tab1,tab2,...
  	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
  	 */
  	function InitTab() {
  		try{
  			with(document.all.tab1){
  				InsertTab(0, "Dry Index" , 23 );
  				InsertTab(1, "Tanker Index" , 23); 
  				InsertTab(2, "Time Charter" , 23 );
  				InsertTab(3, "Bunker Price" , 23 );
  				InsertTab(4, "Ship Price" , 23); 
  				InsertTab(5, "FFA Index" , 23 );
  				TabBackColor(0)="146,174,230";
  			}
  		}catch(e){
  			ComShowMessage(e);
  		}
  	}
  	
  	/**
  	 * tab1의 onChange이벤트핸들러
  	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
  	 */
  	function tab1_OnChange(nItem){
  		ChangeTab(document.all.tab1,nItem);
  	}
  	
  	/**
  	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
  	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
  	 */
  	function ChangeTab(tabObj,nItem){
  		tabObj.BackColor="#FFFFFF";
  		tabObj.TabBackColor(nItem)="146,174,230";
  	
  		var objs = document.all.item("tabLayer");
  		objs[beforetab].style.display = "none";
  		objs[nItem].style.display = "Inline";
  	
  		//--------------- 요기가 중요 --------------------------//
  		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
  		objs[beforetab].style.zIndex = 0;
  		objs[nItem].style.zIndex = 9;
  		//------------------------------------------------------//
  		beforetab= nItem;
  	}

  	/**
  	 * IBSheet Object를 배열로 등록
  	 * ComSheetObject(id)에서 호출한다
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
  		   //khlee-시작 환경 설정 함수 이름 변경
  			ComConfigSheet(sheetObjects[i]);
  			initSheet(sheetObjects[i],i+1);
  			ComEndConfigSheet(sheetObjects[i]);
  		}
  		document.form.s_n3pty_bil_tp_cd.onchange = s_n3pty_bil_tp_cd_OnChange; 
  		document.form.s_bkg_no_all.onblur = s_bkg_no_all_OnBlur; 
  		document.form.s_bl_no_all.onblur = s_bl_no_all_OnBlur; 
  		document.form.s_vvd.onblur = s_vvd_OnBlur;
  		document.form.s_vndr_cust_div_cd.onchange = s_vndr_cust_div_cd_OnChange;
  		document.form.s_trd_party_val.onfocus = s_trd_party_val_OnFocus; // Added By Kim Jin-seung In 2007-06-21
  		document.form.s_trd_party_val.onblur = s_trd_party_val_OnBlur;
  		//document.form.s_src_vndr_no.onblur = s_src_vndr_no_OnBlur;
  		
  		getTPBGenCombo('s_curr_cd','searchEACCurrency','F','','2',new Array("s_ofc_cd", "s_rhq_cd", "s_cnt_cd"));
  	 }

   	/**
   	 * 시트 초기설정값, 헤더 정의
   	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
   	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
   	 */
   	function initSheet(sheetObj,sheetNo) {
   		sheetObj.UseUtf8 = true;
   		switch(sheetNo) {
   			case 1:	  //IBSheet1 init
   				with (sheetObj) {
   					var cnt = 0;
   					style.height = 280;
   					//전체 너비 설정
   					SheetWidth = mainTable.clientWidth;
   		
   					//Host정보 설정[필수][HostIp, Port, PagePath]
   					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
   		
   					//전체Merge 종류 [선택, Default msNone]
   					MergeSheet = msNone;
   		
   					//전체Edit 허용 여부 [선택, Default false]
   					Editable = true;
   		
   					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
   					InitRowInfo( 1, 1, 9, 100);

   					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
   					InitColumnInfo(6, 0, 0, true);

   					// 해더에서 처리할 수 있는 각종 기능을 설정한다
   					InitHeadMode(true, true, true, true, false, false)

   					//var HeadTitle = "Del.|STS|EQ Type|EQ No.|EQ Type Size|Amount";
   					var HeadTitle = "Del.|STS|EQ Kind|EQ No. or VVD|EQ Type Size|Amount";

   					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
   					InitHeadRow(0, HeadTitle, false);
   		
   					//데이터속성	[ROW,	  COL, DATATYPE,  WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD,  CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
   					InitDataProperty(0, cnt++, dtDelCheck,   40,    daLeft,    true,    "",        		false,          "",       dfNone,    	0,     		true,       true,       1,        false,    false,    "",  false);
   					InitDataProperty(0, cnt++, dtStatus,     40,    daCenter,  true,    "ibflag");
   					InitDataProperty(0, cnt++, dtCombo,     200,    daCenter,  true,    "eq_knd_cd",    false,          "",       dfNone,    	0,     		true,       true, 		1);
   					InitDataProperty(0, cnt++, dtData,      200,    daCenter,  true,    "eq_no",        false,          "",       dfNone,    	0,     		true,       true, 	   14);
   					InitDataProperty(0, cnt++, dtData,      200,    daCenter,  true,    "eq_tpsz_cd",   false,          "",       dfNone,    	0,     	    true,       true, 		3);
   					InitDataProperty(0, cnt++, dtData,      200,     daRight,  true,    "if_amt",        true,          "",      dfFloat,    	2,     		true,       true);

   					//InitDataCombo (0, "eq_knd_cd", " |"+combo01Text, " |"+combo01Code);
   					
   					InitDataValid (0, "eq_no", vtEngUpOther,"1234567890");
   					InitDataValid (0, "eq_tpsz_cd", vtEngUpOther,"1234567890");

   				}
   				break;
   		}
   	}

  	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
  	document.onclick = processButtonClick;
  	function processButtonClick(){
  		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
  		 var sheetObject = sheetObjects[curTab-1];
  		 /******************************************************/
  		 var formObject = document.form;
  		 if(curTab == 2)
  			formObject = document.form2;

  		try {
  			var srcName = window.event.srcElement.getAttribute("name");
  			// form 이름에 주의하시기 바랍니다. 
  			with(document.form) {
  				switch (srcName) {
	  				case "btn_add":
	  					doActionIBSheet(sheetObject,formObject,IBINSERT);
	  					break;
  					case "btn_save":
  						doActionIBSheet(sheetObject,formObject,IBSAVE);
  						break;
  	  				case "btn_vvd":
  	  					var param = '?sdate='+formObject.s_sdate.value+'&edate='+formObject.s_edate.value;
  	  					ComOpenPopup('/hanjin/COM_ENS_0B2.do'+ param, 770, 470, 'getVVD', '1,0,1,1,1,1,1,1');
  	  					break;
  					case "btn_3rdParty":
  						get3rdParty( document.all.s_vndr_cust_div_cd.value );
  						break;
  					case "btn_3rdParty_v":
  						get3rdParty( "SP" );
  						break;
  					case "btn_new":
  						formObject.reset();
  						sheetObject.RemoveAll();
  						break;
  	  				case "btn_location":
  	  					 if(!window.event.srcElement.disabled){
  	  						var param = "";
  	  						ComOpenPopup('/hanjin/COM_ENS_051.do'+ param, 770, 470, 'getLocation', '1,0,1,1,1,1,1,1');
  	  				     }
  	  					break;
  	  				case "btns_calendar1":
  	  					var cal = new ComCalendar();
  	  					cal.select(formObject.s_if_dt, 'yyyy-MM-dd');
  	  					break;
  					case "btn_filesearch":
  						openFileUploadPopup(document.form.s_file_no.value, 'getFileNo', 'Y', 'Y');
  						break;
  				} // end switch
  			}// end with
  		} catch(e) {
  			if( e = "[object Error]") {
  				ComShowMessage(ComGetMsg('COM12111'));
  			} else {
  				ComShowMessage(e);
  			}
  		}
  	}

  	/* file upload 관련 처리 - fileNo받기 */
  	function getFileNo(fileNoReceive){
  		document.form.s_file_no.value = fileNoReceive;
  	}

  	/* Sheet관련 프로세스 처리 */
  	function doActionIBSheet(sheetObj,formObj,sAction) {
  		sheetObj.ShowDebugMsg = false;
  		switch(sAction) {
		   case IBSEARCH:	  //조회
				
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_TPB_0104GS.do", tpbFrmQryStr(formObj));
				break;
		   case IBSAVE:		//저장
				if(!validateForm(sheetObj,formObj,sAction)) {
  					return false;
  				}

  				//입력값 길이 체크
  				var lenArr = new Array();
  				lenArr[0] = new Array(formObj.s_bkg_no_all,'BKG No',formObj.s_bkg_no_all.getAttribute("maxlength"),11);
  				lenArr[1] = new Array(formObj.s_bl_no_all,'B/L No',formObj.s_bl_no_all.getAttribute("maxlength"));
  				lenArr[2] = new Array(formObj.s_vvd,'VVD',formObj.s_vvd.getAttribute("maxlength"));
  				

  				if(!checkFormLength(lenArr)){
  					return false;
  				}
  				//입력값 쪼개기
  				formObj.s_bkg_no.value     = formObj.s_bkg_no_all.value;
  				formObj.s_bl_no.value	   = formObj.s_bl_no_all.value;
  				formObj.s_vsl_cd.value	   = formObj.s_vvd.value.substring(0,4);
  				formObj.s_skd_voy_no.value = formObj.s_vvd.value.substring(4,8);
  				formObj.s_skd_dir_cd.value = formObj.s_vvd.value.substring(8,9);
  				formObj.s_src_vndr_seq.value   = formObj.s_src_vndr_no.value;
  				formObj.f_cmd.value = ADD;
  				// sheetObj.DataInsert();
  				
  				var s_if_ofc_cd = formObj.s_if_ofc_cd.value; // Added In 2008-09-17
  				var s_eq_no = getEqNoArrayString(sheetObj); // '|'구분자로 연결된 문자열 // Added In 2008-09-17 
  				var s_bkg_no = formObj.s_bkg_no.value; // Added In 2008-09-17
  				//alert(s_if_ofc_cd);
  				//alert(s_eq_no);
  				//alert(s_bkg_no);
  				
  				if( document.form.isChecked.value == "0" && ComTrim(document.form.s_vvd.value).length != 0 ){
  					ComShowCodeMessage('TPB90072');
  					return;
  				}
  				
  				//* 2009-06-08 O Wan-Ki 1.4 VVD Checking 을 위한 isChecked 설정.  				
  				var duplicationCheckAndSave = openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no);
  				
                  if ( duplicationCheckAndSave != null && duplicationCheckAndSave == true ) {  // Added In 2008-09-17
                	  sheetObj.DoSave("ESD_TPB_0104GS.do", tpbFrmQryStr(formObj), "ibflag", false); // Save 안되는 현상에 대한 문제 해결을 위한 수정....
                  }
                  sheetObj.RemoveAll(); // 저장 후, IBSheet 초기화
  				break;

  			case IBINSERT:	  //입력
  			
				if ( document.form.s_bkg_no_all.value.length >= 11 && document.form.s_bkg_no_all.value.length <= 13 && document.form.s_n3pty_expn_tp_cd.value !="PSO") {
  					// * 2009-02-19 O Wan-Ki 1.2 ESD_TPB_0811 UI 호출로직 추가.					
  					// var resultArr = openContainerPopup( document.form.s_bkg_no.value, document.form.s_bkg_no_split.value);
  					var resultArr = openContainerPopup( document.form.s_bkg_no_all.value);
  					if( resultArr.length > 0 ){
  						var tempArr;
  						for( i=0 ; i<resultArr.length ; i++ ){
  							tempArr = resultArr[i].split('|$|');
  							sheetObj.DataInsert(i);
  							sheetObj.CellValue2(i+1,'eq_no') = tempArr[0];
  							if(tempArr[0]!=''){
  								//sheetObj.CellValue2(i+1,'eq_tp_cd') = 'C';
  								sheetObj.CellValue2(i+1,'eq_knd_cd') = 'U';
  							}
  							sheetObj.CellValue2(i+1,'eq_tpsz_cd') = tempArr[1];
  						}
  					}
  				}else{
  					sheetObj.DataInsert();
  				}
  			
	  			 if(document.form.s_n3pty_expn_tp_cd.value =="PSO"){
	  				 for(i=1;i<=sheetObj.RowCount;i++){
	  					 sheetObj.CellEditable(i,"eq_tpsz_cd") = false;
	  				}
	  			   }else {
	  				 for(i=1;i<=sheetObj.RowCount;i++){
	  				   sheetObj.CellEditable(i,"eq_tpsz_cd") = true; 
	  				 }
	  			   }
  				break;
  			case IBCLEAR:	   //Clear
  				sheetObj.RemoveAll();
  				break;
  			case IBDOWNEXCEL:  //엑셀내려받기
  				sheetObj.SpeedDown2Excel(true);
  				break;
  				
  			case SEARCH01:
  		
      			formObj.f_cmd.value = SEARCH01;
      			//alert(sheetObj.length);
      		for(i=1;i< sheetObj.RowCount+1;i++){
      			if(sheetObj.CellValue(i,"eq_no")!='' && sheetObj.CellValue(i,"eq_no")!=null){
	      			var sParam = "f_cmd="       +formObj.f_cmd.value
		 						+ "&eq_no=" +sheetObj.Cellvalue(i,"eq_no");
		 			var sXml = sheetObj.GetSearchXml("ESD_TPB_0104GS.do", sParam);
		 			var eq_no = ComGetEtcData(sXml, "result");
			        if(eq_no == ""){
			        	ComShowCodeMessage("TPB90070"); // VVD_CD verify 	
			        	sheetObj.CellValue2(i,"eq_no") = "";
			        }
		        }
	 		}
  				
  				
  				break;	
  			
  		}
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet_OnSearchEnd(sheetObj,errMsg){
  		if(errMsg!=null){
  			ComShowMessage(errMsg);
  		}
  	}

  	/**
  	 * 조회결과가 오류가 발생했을 때 공통처리하는 함수
  	 * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
  	 */
  	function sheet1_OnSaveEnd(sheetObj,errMsg){
  		if(errMsg==null || errMsg == ''){
  			ComShowMessage(ComGetMsg('COM12149','Data','',''));
  			sheetObj.RemoveAll();
  		} 				
  	}
  	
  	/**
  	 * IBSheet 내 셀 값이 변경되었을 때 처리되는 함수.
  	 * 
  	 */		
  	function sheet1_OnChange(sheetObj, Row, Col, Value){

  		var colNm = sheetObj.ColSaveName(Col);

  		// * 2008-11-21 O Wan-Ki 1.1 Container EQ No. Digit Check 기능 추가.
  		if( colNm == 'eq_no' && Value != '' && sheetObj.CellValue(Row,'eq_knd_cd')!='' && sheetObj.CellValue(Row,'eq_knd_cd')!='V'	||
  	  			colNm == 'eq_knd_cd' && Value != '' && sheetObj.CellValue(Row,'eq_no')!=''&& sheetObj.CellValue(Row,'eq_knd_cd')!='V')
  	  	{
  	  		Value = sheetObj.CellValue(Row,'eq_no');
  	  		document.form.s_eq_no.value = Value;
  	  		document.form.s_eq_knd_cd.value = sheetObj.CellValue(Row,'eq_knd_cd');
  	  		getTPBGenCombo('CheckEqNo','checkEqNo','V','','',new Array('s_eq_knd_cd','s_eq_no'),Value);
  	  	}
  		
  		if( colNm == 'eq_no' && Value != '' && sheetObj.CellValue(Row,'eq_knd_cd') == '')
  		{	
 			ComShowMessage(ComGetMsg('COM12119','EQ Kind'));
  			sheetObj.CellValue(Row,'eq_no') = '';
  		}
  		
 		if( sheetObj.CellValue(Row,'eq_knd_cd') == 'V')
  		{	
 			sheetObj.CellEditable(Row,"eq_tpsz_cd") = false;
 			sheetObj.CellValue(Row,"eq_tpsz_cd") = "";
  		}else{
  			sheetObj.CellEditable(Row,"eq_tpsz_cd") = true;
  		}
 		
 		if( sheetObj.CellValue(Row,'eq_knd_cd') == 'V'|| document.form.s_n3pty_expn_tp_cd.value =='PSO')
  		{	
 			
 			sheetObj.CellEditable(Row,"eq_tpsz_cd") = false;
 			sheetObj.CellValue(Row,"eq_tpsz_cd") = "";
  		}else{
  			sheetObj.CellEditable(Row,"eq_tpsz_cd") = true;
  		}
 		
  		if( colNm == 'eq_no' && Value != '' && sheetObj.CellValue(Row,'eq_knd_cd')!='' && sheetObj.CellValue(Row,'eq_knd_cd')=='V'	||
  	  			colNm == 'eq_knd_cd' && Value != '' && sheetObj.CellValue(Row,'eq_no')!=''&& sheetObj.CellValue(Row,'eq_knd_cd')=='V')
  		{
  		//쿼리 타게 함
 			doActionIBSheet(sheetObj, document.form, SEARCH01);
  		}
  	}

//  	/**
//  	 * EQ No. 정보 얻기 
//  	 */ 
//  	function getEqInfo(){
//          return; // 기능 규칙 혼재로 기능 취하 By Kim Jin-seung In 2007-05-25
  //
//  		var eq_no = document.form.s_eq_no.value;
//  		if(eq_no!=undefined && eq_no!=null){ // trim 
//  			eq_no = trim(eq_no);
//  		}
//  		var eq_tp_cd = document.form.s_eq_tp_cd.value;
//  		var n3pty_bil_tp_cd = document.form.s_n3pty_bil_tp_cd.value;
  //
//  		if( eq_no.length > 0 ){ // EQ No. 공백이 아닌 값이 있을 경우
//  			if ( trim(eq_tp_cd).length==0 ) { // EQ Type를 선택하지 않았을 경우
//  				ComShowMessage(getMsg('COM12113','EQ Type'));
//  				document.form.s_eq_tp_cd.focus();
//  				return;
//  			} else { // EQ Type를 선택한 경우
//  				if ( n3pty_bil_tp_cd=='JO' ) { 
//  					return; 
//  				} else {
//  					getTPBGenCombo("s_eq_tpsz_cd",'checkEqNo','T','','',new Array("s_eq_no", "s_eq_tp_cd"));
//  				}
//  			}
//  		} 
//  	}

//  	/**
//  	 * EQ No.에 대한 OnBlur 이벤트 함수 
//  	 */
//  	function s_eq_no_OnBlur(){
//  		// _txt_onkeyup('s_eq_no'); // to upper case
//  		// document.form.s_eq_tpsz_cd.value = "";
//  		// getEqInfo();
//  	}

//  	/**
//  	 * EQ Type 에 대한 OnChange 이벤트 함수 
//  	 */
//  	function s_eq_tp_cd_OnChange(){
//  		// document.form.s_eq_tpsz_cd.value = "";
//  		// getEqInfo();
//  	}

  	 
    //2012.01.17 Expense Type이 PSO일때 sheet의 EQ Kind 는 VSL 만 나오게 
  	 function getPortList(val){
     	var formObj = document.form;
     	
     	formObj.f_cmd.value = val;
     	
 		var sXml = sheetObjects[0].GetSearchXml("ESD_TPB_0104GS.do", FormQueryString(formObj));
 		var arrXml = sXml.split("|$$|");
 		
 		if (arrXml.length < 1) return; 

 	    if (val == SEARCH02 ){
 			//arrXml[0] = ComReplaceStr(arrXml[0], "port_cd", "val");
 			
 		 setIBCombo(sheetObjects[0], arrXml[0], "eq_knd_cd", true, "", "","","intg_cd_val_dp_desc");
 		}
      }
  	 
  	 
  	/**
  	 * Billing Type code 에 대한 OnChange 이벤트 함수 
  	 */
  	function s_n3pty_bil_tp_cd_OnChange(){
  		// getEqInfo();
  	}

  	/**
 	 * BKG No. 대한 OnChange 이벤트 함수 
 	 * BL No.를 가져온다. 
 	 */
 	 function s_bkg_no_all_OnBlur(){
 		 getBLNo( document.form, document.form.s_bkg_no_all, 's_' );
 	 }

   	/**
   	 * BL No. 대한 OnChange 이벤트 함수 
   	 * BKG No.를 가져온다.
   	 */
    function s_bl_no_all_OnBlur(){
        var bl_no = document.form.s_bl_no_all.value; 
        var bkg_no = document.form.s_bkg_no_all.value; 
        // if ( bl_no.length==12 && ( ComTrim(bkg_no).length!=11 && ComTrim(bkg_no).length!=13 ) ){
        if ( bl_no.length==12 && bkg_no.length==0 ){
            getTPBGenCombo('s_bkg_no_all','checkBKGNoWithBLNo','T','','',new Array("s_bl_no_all"));  
        } 
    }
   	 
   	 /* s_vvd_OnBlur
      * 
      * 2009-04-20, N200904160080
      * IFRAME 을 이용한 VVD Check 
      */
     function s_vvd_OnBlur(){
     	if( document.form.s_vvd != undefined && document.form.s_vvd.value != '' ){
     		
     		document.form.isChecked.value = '0';// 2009-06-08 O Wan-Ki 1.4 
     		
     		if( document.form.s_vvd.value.length == 9 ){
 		    	// VVD 직접입력에 대한 Validation Check - iframe생성이용.
 				var f = document.frames;
 				var ifr = "frame_"+f.length;
 				var o = document.createElement("DIV");
 				o.style.display = "none";
 				o.innerHTML = '<iframe name="'+ifr+'" scrolling="no" frameborder="0" width="0" height="0"></iframe>';
 				document.body.appendChild(o);
 				eval("document."+ifr).location.href 
 				 = "TPBCommonCode.do?mode=T&id=s_vvd&method=searchCheckVVD&s_vvd="+document.form.s_vvd.value + "&otherObjs=" + document.form.s_if_ofc_cd.value ;
 			}else{
 				ComShowCodeMessage('TPB90070');
 				document.form.s_vvd.value = '';
 				document.form.s_vvd.focus();
 			}
     	}
     }
    
    
     /* s_src_vndr_no_OnBlur
     * 
     * IFRAME 을 이용한 S/P Check
     */
     function s_src_vndr_no_OnBlur()
     {
   	  if( document.form.s_src_vndr_no != undefined && document.form.s_src_vndr_no.value != '' )
   	  {
   		  if( ComIsNumber(document.form.s_src_vndr_no) == false )
   		  {
   			  ComShowCodeMessage('TPB90071');
   			  document.form.s_src_vndr_no.value = '';
   			  document.form.s_src_vndr_no.focus();
   		  } else
   		  {
       		  getTPBGenCombo('CheckVendorCode','checkVendorCode','V','','',new Array('s_src_vndr_no'));
   		  }
   	  }
     }
        
  	/**
  	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
  	 */
  	function validateForm(sheetObj,formObj,sAction){
  		
  		
  		if(sheetObjects[0].RowCount == 0){
  			ComShowCodeMessage('TPB90078', 'Amount'); 
  			return false;
  		}
  		
  		// sheet 내 Amount 금액 0.0 초과 체크 	
  	    // 2015.04.10 EQ No check 로직 추가 (TPB90112)
  		for(var i=1;i<=sheetObjects[0].RowCount; i++) {
  			var if_amt = sheetObjects[0].CellValue(i, "if_amt");
  			if ( if_amt - 0.0 <= 0.0 ) {
  				ComShowMessage( ComGetMsg ('COM12114', 'Amount') ); 
  				sheetObjects[0].SelectCell(i, "if_amt");
  				return false; 
  			}
  			
  			var s_eq_no  = sheetObj.CellValue(i,"eq_no");
  			var eq_dup = 0 ;
  			  for(var j=1;j<=sheetObjects[0].RowCount; j++) {
  				if(i != j && s_eq_no == sheetObj.CellValue(j,"eq_no")){
  					eq_dup = eq_dup + 1 ;
  				}
  			  }
  			  if(eq_dup > 0){
  				ComShowCodeMessage('TPB90112',s_eq_no); 
  	  			return false; 
  			  }
  		}
  		
  		with(formObj){
  			if(!ComChkValid(formObj)) return false;

  			if(document.all.s_n3pty_src_no.className == "input1"){
  				if(s_n3pty_src_no.value == ""){
  					//ComShowMessage("'S/P Invoice No' " + Msg_Required);
  					ComShowCodeMessage('TPB90085',Msg_Required);
  					s_n3pty_src_no.focus();
  					return false;
  				}
  			}
  			
  			if(document.all.s_src_vndr_no.className == "input1"){
  				if(s_src_vndr_no.value == ""){
  					//ComShowMessage("'S/P' " + Msg_Required);
  					ComShowCodeMessage('TPB90086',Msg_Required);
  					s_src_vndr_no.focus();
  					return false;
  				}
  			}

  			if(document.all.s_bkg_no_all.className == "input1"){
  				if(s_bkg_no_all.value == ""){
  					//ComShowMessage("'Booking No' " + Msg_Required);
  					ComShowCodeMessage('TPB90087',Msg_Required);
  					s_bkg_no_all.focus();
  					return false;
  				}
  			}
  			
  			if(document.all.s_vndr_cust_div_cd.className == "input1"){
  				if(s_src_vndr_no.value == ""){
  					//ComShowMessage("'3rd Party' " + Msg_Required);
  					ComShowCodeMessage('TPB90088',Msg_Required);
  					s_vndr_cust_div_cd.focus();
  					return false;
  				}
  			}
  			
  			if(document.all.s_trd_party_val.className == "input1"){
  				if(s_trd_party_val.value == ""){
  					//ComShowMessage("'3rd Party Value' " + Msg_Required);
  					ComShowCodeMessage('TPB90089',Msg_Required);
  					s_trd_party_val.focus();
  					return false;
  				}
  			}
  			
  			if(document.all.s_trd_party_nm.className == "input1"){
  				if(s_trd_party_nm.value == ""){
  					//ComShowMessage("'3rd Party Name' " + Msg_Required);
  					ComShowCodeMessage('TPB90090',Msg_Required);
  					s_trd_party_nm.focus();
  					return false;
  				}
  			}
  			
  			var svvd = s_vvd.value ;
  			if(svvd !=""){
  			   var fincDirCd = getFincDirCd(sheetObj);
			    if (fincDirCd == "BXX"){
			    	if(ComShowCodeConfirm('TPB90110')){
			    		return true;
			   	    }else{
			    		return false; 
			    	}
			    }else if(fincDirCd == "VXX"){
	           	    ComShowCodeMessage('TPB90111');
			    	return false;
			    }
  			}
  		}
        

  		return true;
  	}
  	
	/**
	 * Expense Type 에 따라 Billing case 콤보를 만드는 함수
	 */
	function changeBillingCase(f){
		var expVal = f.s_n3pty_expn_tp_cd.value;
		//alert(expVal);		
		if(expVal.replace(" ","").length == 0){
			ComClearCombo(f.s_n3pty_bil_tp_cd);
			ComAddComboItem(f.s_n3pty_bil_tp_cd, "<<Select>>", "");
		}else{
			getTPBGenCombo('s_n3pty_bil_tp_cd','searchBillingCaseName','F','','2',new Array("s_bil_tp_cd", "s_n3pty_expn_tp_cd", "s_n3pty_if_tp_cd", "s_jo_display")); 
  			if(expVal == "MNR"||expVal=="PSO"){
  				document.all.s_bkg_no_all.className	= "";
  			}else{
  				document.all.s_bkg_no_all.className	= "input1";
  			}
		}
		
  		
		for ( var i = 1; i <= sheetObjects[0].RowCount; i++ ){
			sheetObjects[0].CellValue2(i,'eq_knd_cd') = '';
			
			}
		
		if(expVal=="PSO"){
	  			for ( var i = 1; i <= sheetObjects[0].RowCount; i++ ){
			      sheetObjects[0].CellValue(i,"eq_tpsz_cd") = "";
			      sheetObjects[0].CellEditable(i,"eq_tpsz_cd") = false;
	  			}	
	  			getPortList(SEARCH02);
        }else{
        	 for(i=1;i<=sheetObjects[0].RowCount;i++){
				   if(sheetObjects[0].CellValue(i,"eq_knd_cd") !='V'){
				   sheetObjects[0].CellEditable(i,"eq_tpsz_cd") = true; 
				   }
			 }
        	 getPortList(SEARCH02);
        }
	}
 	
      function openDuplicationCheckPopup(s_if_ofc_cd,s_eq_no,s_bkg_no){ /// By Kim Jin-seung In 2008-06-05
      	var theURL = "ESD_TPB_0801.do";
      	theURL += "?s_if_ofc_cd=" + s_if_ofc_cd;
      	theURL += "&s_eq_no=" + s_eq_no;
      	theURL += "&s_bkg_no=" + s_bkg_no;
          // ComShowMessage( theURL );
      	var features = "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:460px";
      	var rtnValue = window.showModalDialog(theURL, window, features);

     	return rtnValue;
      }
      
      function getEqNoArrayString(sheetObj){ /// By Kim Jin-seung In 2008-06-05
  		var str = '';
  		if(sheetObj.RowCount > 0){
  			for ( var i = 1; i <= sheetObj.RowCount; i++ ){
  				str += sheetObj.CellValue(i,'eq_no')+"|";
  			}
  		}
  		return str;
      }
      
      //* 2009-02-19 O Wan-Ki 1.2 ESD_TPB_0811 UI 호출로직 추가.
      function openContainerPopup(s_bkg_no, s_bkg_no_split){
       
      	var theURL = "ESD_TPB_0811.do";
      	theURL += "?s_bkg_no=" + s_bkg_no;
      	theURL += "&s_bkg_no_split=" + s_bkg_no_split;
      	var features = "scroll:no;status:no;help:no;dialogWidth:340px;dialogHeight:350px";
      	var rtnValue = window.showModalDialog(theURL, window, features);

      	return rtnValue;
      }
      
      
      /**
       * IBSheet의 콤보 컬럼에 데이터를 setting한다. <br>
       * <b>Example :</b>
       * <pre>
       * setIBCombo(sheetObj,sXml,"rcv_de_term_cd",false,1);
       * </pre>
       *
       * @param {string} sheetObj 필수
       * @param {string} sXml 필수, Combo에 채울 데이터(IBSheet를 통해 받아온 xml 문자열.)
       * @param {string} title 필수, Combo field명(IBSheet SaveName).
       * @param {string} iBlank 선택, Combo의 첫번째로우를 블랭크로 설정
       * @param {string} sCol 선택, 멀티콤보일경우 콤보를 선택하면 콤보에 보여질 순서설정(0:코드 or 1:description)
       * @param {string} dCode 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Code값
       * @param {string} dText 선택, 신규 "입력" 상태일 때 기본으로 선택되어야 할 Item에 대한 Text값
       * @param {string} dispCol 선택, 콤보에서 화면에 보여주는 코드값의 칼럼 val,desc 중 val값일 때 선택가능.
       * (코드|디스크립션 형태가 아닐 경우는 0으로 설정해야함)
       * @return
       * @author 공백진, jong 추가 수정
       * @version 2009.04.30
       */
      function setIBCombo(sheetObj, sXml, title, iBlank, sCol, dCode, dText, dispCol){
        var showCol = 0;
         var bFlag = false;
         if (sCol != undefined && sCol !=""){
           showCol = sCol;
         }
         if (iBlank != undefined && iBlank !=""){
           bFlag = iBlank;
         }
         if (dispCol == undefined || dispCol ==""){
           dispCol = "desc";
         }

        var arrData = ComBkgXml2ComboString(sXml, "intg_cd_val_ctnt", dispCol);
        if (bFlag == true){
          arrData[1] =" \t |"+ arrData[1];
          arrData[0] =" |"+ arrData[0];
        }
        sheetObj.InitDataCombo(0,title, arrData[1], arrData[0],dText, dCode, showCol);
      }
      
      /**
      * IBSheet의 GetSearchXml함수를 통해 가져온 XML 데이터를 <br>
      * IBSheet의 Combo에 연결할수 있는 문자열형태로 반환한다.(&quot;|&quot;로 연결된 문자열)<br>
      * Return되는 배열의 0번째는 Code문자열, 1번째는 Text문자열이 담겨있다.
      * <b>Example :</b>
      *
      * <pre>
      * var sXml = mySheet.GetSearchXml(&quot;aaa.do&quot;); // 조회결과 35건.
      * var arrData = ComBkgXml2ComboString(xmlStr, &quot;cd&quot;, &quot;nm&quot;);
      *
      * </pre>
      *
      * @param {string} xmlStr 필수, IBSheet를 통해 받아온 xml 문자열.
      * @param {string} codeCol 필수, Combo의 Code컬럼명.
      * @param {string} textCol 필수, Combo의 Text컬럼명.
      * @return array   Code연결 문자열과 Text연결 문자열이 담긴 배열.
       * @author 박성수
       * @version 2009.04.22
      */
     function ComBkgXml2ComboString(xmlStr, codeCol, textCol) {
       var rtnArr = new Array();

       if (xmlStr == null || xmlStr == "") {
         return;
       }
       if (codeCol == null || codeCol == "" || textCol == null || textCol == "") {
         return;
       }

       try {
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
         for (var i = 0; i < colArr.length; i++) {
           if (colArr[i] == codeCol) {
             colListIdx[0] = i;
           }
           if (colArr[i] == textCol) {
             colListIdx[1] = i;
           }
         }

         var sCode = "";
         var sText = "";
         for (var i = 0; i < dataChildNodes.length; i++) {
           if (dataChildNodes[i].nodeType != 1) {
             continue;
           }
           var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep);

           sCode += arrData[colListIdx[0]];
           sText += arrData[colListIdx[1]];

           if (i != dataChildNodes.length - 1) {
             sCode += "|";
             sText += "|";
           }
         }
         rtnArr.push(sCode);
         rtnArr.push(sText);
       } catch (err) {
         ComFuncErrMsg(err.message);
       }

       return rtnArr;
     }
     /* BKG VVD 및 Finance Dir  check 로직 */
     function getFincDirCd(sheetObj){ 
 		var formObj = document.form ;
 		var sbkgNo = formObj.s_bkg_no_all.value ; 
 		var sVVD = formObj.s_vvd.value ;
 	    var sYdCD = formObj.s_yd_cd.value ;
 	    var fincDirCd = "" ;
 	    formObj.f_cmd.value = SEARCH03;	
 	
       	var sParam = "f_cmd="+formObj.f_cmd.value+"&s_vvd=" +sVVD+"&s_yd_cd="+sYdCD+"&s_bkg_no_all="+sbkgNo;
 		var sXml = sheetObj.GetSearchXml("ESD_TPB_0103GS.do", sParam);
 		 fincDirCd = ComGetEtcData(sXml, "fincDirCd");
 		 
 		return fincDirCd;
     }
	/* 개발자 작업  끝 */