/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0012.js
*@FileTitle : CSR I/F Inquiry
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.08.17
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.08.17 전재홍
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
     * @class ESD_LEA_0012 : ESD_LEA_0012 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESD_LEA_0012() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	this.sheet1_OnScrollNext 	= sheet1_OnScrollNext;
    }
    
   	/* 개발자 작업	*/
    /* 공통전역변수 */
    var curTab = 1;
    var beforetab = 0;
    var sheetObjects = new Array();
    var sheetCnt = 0;

    /* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
    
    	/**
    	 * IBTab Object를 초기화 설정
    	 * 탭 ID는 tab1,tab2,...
    	 * setupPage() 함수에서 loadPage() 호출 전에 이 함수를 호출한다.
    	 */
//    	function InitTab() {
//    		try{
//    			with(document.all.tab1){
//    				InsertTab(0, "Dry Index" , 23 );
//    				InsertTab(1, "Tanker Index" , 23); 
//    				InsertTab(2, "Time Charter" , 23 );
//    				InsertTab(3, "Bunker Price" , 23 );
//    				InsertTab(4, "Ship Price" , 23); 
//    				InsertTab(5, "FFA Index" , 23 );
//    				TabBackColor(0)="146,174,230";
//    			}
//    		}catch(e){
//    			ComShowMessage(e);
//    		}
//    	}
//    	
//    	/**
//    	 * tab1의 onChange이벤트핸들러
//    	 * IBSheetConfig.js에서 정의한 핸들러 함수를 구현한 것임
//    	 */
//    	function tab1_OnChange(nItem){
//    		ChangeTab(document.all.tab1,nItem);
//    	}
//    	
//    	/**
//    	 * IBTab Object 클릭할 때 해당 탭의 내용을 보여준다
//    	 * 탭별로 그루핑된 DIV TAG의 ID는 모두 동일하게 "tabLayer"로 정한다.
//    	 */
//    	function ChangeTab(tabObj,nItem){
//    		tabObj.BackColor="#FFFFFF";
//    		tabObj.TabBackColor(nItem)="146,174,230";
//    	
//    		var objs = document.all.item("tabLayer");
//    		objs[beforetab].style.display = "none";
//    		objs[nItem].style.display = "Inline";
//    		
//    		//--------------- 요기가 중요 --------------------------//
//    		//objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
//    		//ksw수정 : zIndex가 -2이하로 가게되면 버튼클릭이 안됨
//    		objs[beforetab].style.zIndex = 0;
//    		objs[nItem].style.zIndex = 9;
//    		//------------------------------------------------------//
//    		beforetab= nItem;
//    	}
//
    	/**
    	 * IBSheet Object를 배열로 등록
    	 * comSheetObject(id)에서 호출한다
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
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}

    	}

    	/**
    	* @param     : obj	=> 객체
    	* sample	: <input type ="text" name ="date" onblur="lea_com_convertYymmdd(this)">
    	* @return 	: 
    	* 설명		: 년월(YYYY-MM-DD)을 검사 하여 보여주기 
    	**/
    	function lea_convertYymmdd(obj){
    		obj.value = ComReplaceStr(obj.value, '-', '');
    		switch(obj.value.length){
    			case 0 :
    					return;
    					break;
    			case 6 :
    					if (parseInt(obj.value.substring(0,2),10)  > 80 )
    					{
    						obj.value = "19"+obj.value;
    					}
    					else
    					{
    						obj.value = "20"+obj.value;
    					}
    					break;
    			case 8 :
    					break;
    			default :
    					obj.focus();
    					return;
    					break;
    		}
    		
    		var realDate = ComIsDate(obj.value);
    		if (!realDate)
    		{
    			//ComShowMessage('잘못된 날짜입니다.');
    			ComShowMessage(ComGetMsg("LEA90001"));
    			obj.value="";
    			obj.focus();
    			return;
    		}
    		
    		str = obj.value;
    		str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6,8);
    		obj.value = str;
    	}
    	
    	/**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		sheetObj.UseUtf8 = true;
    		var cnt = 0;
    		var onepagerows = document.form.pagerows.value;
    		//alert("onepagerows = "+onepagerows);
    		switch(sheetNo) {
    			case 1:	  //IBSheet1 init
    				with (sheetObj) {
    					
    					//전체 너비 설정
    					SheetWidth = mainTable.clientWidth;
    					
    					// 높이 설정
    					style.height = 400;
    		
    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    		
    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;
    		
    					//전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
    		
    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 2, 1, 9, onepagerows);
    		
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(14, 0, 0, true); //11+2
    		
    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false)
    		
    					//var HeadTitle  = "Seq||CSR No.|Source|ERP I/F|ERP I/F|ERP I/F|LEA I/F|LEA I/F|LEA I/F|Currency|Total Amt|Old CSR" ;
    					//var HeadTitle1 = "Seq||CSR No.|Source|Status|Update Time|Error Reason|Status|Update Time|Error Reason|Currency|Total Amt|Old CSR" ;
    					
    					var HeadTitle  = "Seq||CSR No.|Source|Office|Final Invoice\nIssue Date|ERP I/F|ERP I/F|ERP I/F|LEA I/F|Currency|Total Amt|Old CSR|A|B" ;
    					var HeadTitle1 = "Seq||CSR No.|Source|Office|Final Invoice\nIssue Date|Status|I/F Date|Error Reason|Status|Currency|Total Amt|Old CSR|A|B" ;
    		
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);
    					InitHeadRow(1, HeadTitle1, true);
    			
    					//데이터속성	[ROW,	  COL,	DATATYPE, WIDTH,   DATAALIGN, COLMERGE,	 SAVENAME,   KEYFIELD, CALCULOGIC,   DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,	cnt++,	dtDataSeq		,	35,		daRight, 	true);
    					InitDataProperty(0,	cnt++,	dtHiddenStatus	,	0,		daCenter,	false,	"ibflg"			,	false,	"",	dfNone		,	0,	true,	true);
    					InitDataProperty(0,	cnt++,	dtData			,	125,	daCenter,	true,	"csr_no"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"src_ctnt"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	60,		daCenter,	true,	"inv_ofc_cd"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	80,		daCenter,	true,	"inv_dt"	    ,	false,	"",	dfDateYmd	,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"if_flg"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	70,		daCenter,	true,	"if_dt"			,	false,	"",	dfDateYmd	,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	150,	daLeft,		true,	"if_err_rsn"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"lea_flg"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	60,		daCenter,	true,	"csr_curr_cd"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	100,	daRight,	true,	"csr_amt"		,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					InitDataProperty(0,	cnt++,	dtData			,	50,		daCenter,	true,	"err_csr_no"	,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					//Hidden Column, Using CSR Monitoring Parameter(G/L Date, Inv.Office Code)!!
    					InitDataProperty(0,	cnt++,	dtHidden		,	50,		daCenter,	true,	"gl_dt"			,	false,	"",	dfNone		,	0,	false,	true,	400,	false,	 true,	"",	false);
    					
    					HeadRowHeight = 22 ;
    					// style.height = 260 ;
    				}
    				break;
    			case 2:      //IBSheet1 init

    		with (sheetObj) {
    			//전체 너비 설정
    			SheetWidth = mainTable.clientWidth;

    			//Host정보 설정[필수][HostIp, Port, PagePath]
    			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    			//전체Merge 종류 [선택, Default msNone]
    			MergeSheet = msHeaderOnly;

    			//전체Edit 허용 여부 [선택, Default false]
    			Editable = true;

    			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    			InitRowInfo( 1, 1, 9, onepagerows);

    			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    			InitColumnInfo(6, 0, 0, true);

    			// 해더에서 처리할 수 있는 각종 기능을 설정한다
    			InitHeadMode(true, true, true, true, false,false)

    			var HeadTitle  = "Inv.Office|ERP I/F Date|ERP I/F Date|Source|ERP I/F|LEA I/F";

    			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    			InitHeadRow(0, HeadTitle, true);

    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    			InitDataProperty(0, cnt++ , dtData   ,	100,	daCenter,  true,	"inv_ofc_cd",	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "st_if_dt"	,	false,	"",	dfDateYm,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "end_if_dt"	,	false,	"",	dfDateYm,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "src_ctnt"	,	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,    daCenter,  true,    "if_flg"	,	false,	"",	dfNone	,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData   ,	100,	daCenter,  true,	"lea_flg"	,	false,	"",	dfNone	,	0,	false,	false);
    			style.height = GetSheetHeight(13) ;
    		}
    		break;
    		}
    	}

    	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    	document.onclick = processButtonClick;
    	
    	/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */	
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****/
    		 var sheetObject = sheetObjects[0];
    		 var sheetObject1 = sheetObjects[1];
    		 /******************************************************/
    		 var formObject = document.form;
    		 if(curTab == 2)
    			formObject = document.form2;
    			
    		try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			switch(srcName) {
    				case "btn_retrieve":
    					formObject.page_no.value="1";
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    					
    				case "btns_calendar1":
    					var cal = new ComCalendar();
    					cal.select(formObject.frm_st_if_dt, 'yyyy-MM-dd');
    					break;
    					
    				case "btns_calendar2":
    					var cal = new ComCalendar();
    					cal.select(formObject.frm_end_if_dt, 'yyyy-MM-dd');
    					break;
    					
    				case "btng_downexcel":
//    					lea_form2sheet(formObject,sheetObject1);
//    					sheetObject1.Down2Excel(-1,false,false,true,"","",false,false, "",true);
//    					sheetObject .Down2Excel(-1,true,false,true,"","",false,false, "",true);
    					sheetObject. ExcelOption= "NOCOLOR";
            	    	sheetObject.SpeedDown2Excel(true);
            	    	sheetObject. ExcelOption= "";   
    					break;
    					
            	    case "btng_csrmonitoring":	//Link CSR Monitoring
    		            if ( sheetObject.RowCount < 1 ) 
    		            {
    		              	ComShowMessage(ComGetMsg("LEA90008"));
    		                return false;
    		            }
    		            if ( sheetObject.SelectRow < 0 ) 
    		            {
    		              	ComShowMessage(ComGetMsg("LEA90003"));
    		                return false;
    		            }
    		            	//Sample: http://127.0.0.1:7001/hanjin/ESD_LEA_013.do?f_cmd=2&iPage=&frm_st_gl_dt=2007-11-01&frm_end_gl_dt=2007-11-01&frm_src_ctnt=ALL&frm_inv_ofc_cd=ATLBB&frm_csr_no=12SATLBB07110900006&frm_rslt_cd=ALL&open_div=POP
    						var url_str = "ESD_LEA_0013.do";
    								url_str += "?f_cmd="			+ "2";
    								url_str += "&frm_opt_st_dt="	+ sheetObject.CellValue(sheetObject.SelectRow, "gl_dt");
    								url_str += "&frm_opt_end_dt="	+ sheetObject.CellValue(sheetObject.SelectRow, "gl_dt");
    								url_str += "&frm_src_ctnt="		+ "ALL";
    								url_str += "&frm_inv_ofc_cd="	+ sheetObject.CellValue(sheetObject.SelectRow, "inv_ofc_cd");
    								url_str += "&frm_csr_no="		+ sheetObject.CellValue(sheetObject.SelectRow, "csr_no");
    								url_str += "&frm_rslt_cd="		+ "ALL";
    								url_str += "&winopen_div="		+ "POP";
    								url_str += "&dt_div="           + "GL";
    						//alert(url_str);		
    						window.showModalDialog(url_str, window, "dialogWidth:1050px; dialogHeight:600px; help:no; status:no; resizable:yes;");
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
         * EnterKey Event 조회 프로세스 처리
         */
    	function lea_enterRetrieve(){
    		var sheetObject = sheetObjects[curTab-1];
    		var formObject = document.form;
    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	}
    	
    	/**
         * Page Loading Event 조회 프로세스 처리
         */
//    	function lea_load_page(){
//    		var sheetObject = sheetObjects[curTab-1];
//    		var formObject = document.form;
//    	}
    	
    	/* Sheet관련 프로세스 처리 */
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false; 
    		switch(sAction) {
    		   case IBSEARCH:	  //조회
    			   
    			   if(!validateForm(sheetObj,formObj,sAction)) {
    					return false;
    			   }
    			   
    			   formObj.f_cmd.value = SEARCH;
    			   var rXml = sheetObj.GetSearchXml("ESD_LEA_0012GS.do", FormQueryString(formObj));		
    			   if(formObj.page_no.value=="1"){
    			   	sheetObj.LoadSearchXml(rXml, false); 
    			   }else{						
    			   	sheetObj.LoadSearchXml(rXml, true); //true --> append
    			   }
    			   //sheetObj.DoSearch4Post("ESD_LEA_0012GS.do", leaFormQueryString(formObj));
    			   
    			   //추가 조회데이터가 남은 경우에 보여주는 메세지.
      			   	if(sheetObj.TotalRows >  sheetObj.RowCount){
    			   		ComShowCodeMessage("LEA90029");
    			   	}
    			   break;

    		}
    	}
    	
    	/**
       	 * 스크롤을 움직여 리스트의 최 하단에 도착했을 때 조회할 내역이 남은 경우 발생하는 이벤트
       	 */
       	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows){
           var formObj = document.form ;
           formObj.page_no.value = PageNo;
           doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        }
    	
    	/**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			/**
    			 * @ 모든 조건이 ALL 이거나 I/F 구분자들이 모두 "Y" 인 경우 기간을 1개월로 제한함.
    			 */
    			if(formObj.frm_inv_ofc_cd.value == '' && formObj.frm_if_flg.value == 'Y' && formObj.frm_lea_flg.value != 'N'){
    			    var sDate = formObj.frm_st_if_dt.value;
    			    var eDate = formObj.frm_end_if_dt.value;
    			    var oneMonthAfterDate = ComGetDateAdd(ComGetDateAdd(sDate, "M", +1), "D", -1);
    				
    				if(eDate > oneMonthAfterDate){
    					ComShowMessage(ComGetMsg("LEA90028", "1")); 
    					return false;
    				}
    			}else if(formObj.frm_inv_ofc_cd.value == '' && formObj.frm_if_flg.value == 'ALL' && formObj.frm_lea_flg.value != 'N'){
    			    var sDate = formObj.frm_st_if_dt.value;
    			    var eDate = formObj.frm_end_if_dt.value;
    			    var oneMonthAfterDate = ComGetDateAdd(ComGetDateAdd(sDate, "M", +1), "D", -1);
    				
    				if(eDate > oneMonthAfterDate){
    					ComShowMessage(ComGetMsg("LEA90028", "1")); 
    					return false;
    				}
    			}
    			 //Inv.Office Code check
    			 /*if (formObj.frm_inv_ofc_cd.value.trim() == '' ) {
    			 	ComShowMessage(ComGetMsg("TRS90091")); //'Please input the Office code.'
    			 	return false;
    			 }			 
    			 //Date check
    			 if (parseInt(get_IntervalDay(formObj.frm_st_if_dt.value, formObj.frm_end_if_dt.value)) > 7)  {
    			 	ComShowMessage(ComGetMsg("LEA90022", "1")); //'Period is limited to 1 week.'
    			 	return false;
    			 }*/
    			 
    		}
    		
    		return true;
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
     	* Form Data를Sheet로 Copy 프로세스 처리
    	 */
    	function lea_form2sheet(formObj,sheetObj){
    		sheetObj.RemoveAll();
    		var Row = sheetObj.DataInsert();
    		
    		sheetObj.CellValue2(Row, "inv_ofc_cd"	) = formObj.frm_inv_ofc_cd.value;
    		sheetObj.CellValue2(Row, "st_if_dt"		) = formObj.frm_st_if_dt.value;
    		sheetObj.CellValue2(Row, "end_if_dt"	) = formObj.frm_end_if_dt.value;
    		sheetObj.CellValue2(Row, "src_ctnt"		) = formObj.frm_src_ctnt.value;
    		sheetObj.CellValue2(Row, "if_flg"		) = formObj.frm_if_flg.value;
    		sheetObj.CellValue2(Row, "lea_flg"		) = formObj.frm_lea_flg.value;
    	}

    	/**
         * CSR No.를 Double Click 시 해당 시스템의 CSR 조회 화면을 호출함(TRS, TES)
         */		
    	function sheet1_OnDblClick(sheet1, row, col){
    		if(col==2 || col==11){ //CSR No, Old CSR Column
    			var csr_no = sheet1.cellValue(row, col);
    			var inv_sys_id = sheet1.cellValue(row, 3); //TRS, TES
    		
    			if (inv_sys_id == "TRS") {
    				window.showModalDialog("ESD_TRS_0960.do?csr_no=" + csr_no, window, "dialogWidth:800px; dialogHeight:530px; help:no; status:no; resizable:yes;");
    			} else if (inv_sys_id == "TES"){
       				window.showModalDialog("ESD_TES_0101.screen?csr_no=" + csr_no, window, "dialogWidth:910px; dialogHeight:480px; help:no; status:no; resizable:yes;");
       				//window.open("http://"+host+"/hanjin/ESD_TES_100.do?READONLY_YN=Y&CSR_NO=" + csr_no);   				
    			}
    		}
    	}	
    		

	/* 개발자 작업  끝 */