/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0053.js
*@FileTitle : Target Lane for SPCL CGO APVL (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철 jkc
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
     * @class vop_scg_0053 : vop_scg_0053 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_scg_0053() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;
    var gRow = 0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject = sheetObjects[0];
    	/*******************************************************/
    	var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

    		switch(srcName) {
    		case "btn_retrieve":
    			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    			break;
    							
    		case "btn1_Excel":    								 
    			doActionIBSheet(sheetObjects[0],document.form,IBDOWNEXCEL);
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

    	for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    		ComConfigSheet (sheetObjects[i] );

    		initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    }
    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet( sheetObj,document.form,IBSEARCH);
    } 

    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

    	var cnt = 0;

    	switch(sheetNo) {
    		case 1:      //t1sheet1 init
    			with (sheetObj) {

    				// 높이 설정
    				style.height = 460;
    				//전체 너비 설정
    				SheetWidth = mainTable.clientWidth;
    				
    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
    				
    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msNone;
    				
    				//전체Edit 허용 여부 [선택, Default false]
    				Editable = false;
    				
    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 3, 100);
    				
    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(5, 0, 0, true);
    				
    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, false, true, false,false)
    				
    				var HeadTitle = "|No.|Target Lane|Full Name|Service Type";
    				
    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);
    				var prefix="sheet1_";
    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				
    				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	   daCenter,    false,   prefix+"ibflag"        );    
    				InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter);
    				InitDataProperty(0, cnt++ , dtData,        150,    daCenter,     false,  prefix+"vsl_slan_cd"   ,      false ,     "",     dfNone,             0,      false,   true);
    				InitDataProperty(0, cnt++ , dtData,        300,    daLeft,       true,   prefix+"vsl_slan_nm"   ,      false,     "",      dfNone,             0,      false,    false);
    				InitDataProperty(0, cnt++ , dtData,        430,    daLeft  ,     true,   prefix+"svc_type_name" ,      false,     "",      dfNone,             0,      false,    false);
    				
    				BasicImeMode     = 2;           
                      	 
    			}
    			break;
    	}
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg = false;
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			formObj.f_cmd.value = SEARCH;
    			var aryPrefix = new Array("sheet1_");
    			var param =  FormQueryString(formObj) +"&spcl_cgo_rqst_tgt_lane_flg=Y" +"&" + ComGetPrefixParam( aryPrefix );
    			
    			var sXml = sheetObj.GetSearchXml("VOP_SCG_0053GS.do", param);
    			sheetObj.Redraw = false;    							
    			sheetObj.LoadSearchXml( sXml ); 
    			sheetObj.Redraw = true;    							
    			break;
    			
    		case IBDOWNEXCEL:      // 삭제
                var paramObj = new Object();
                paramObj.title = "Target Lane for SPCL CGO APVL";
                paramObj.orientation = "Portrait";
                paramObj.columnwidth = "2:10|3:40|4:30";
                var url = ComScgGetPgmTitle(sheetObj, paramObj); 
                sheetObj.SpeedDown2Excel(-1, false, false, "", url );
    			break;   					
    					
    	}
    }
    /** 
     * Sheet vsl_slan_cd의 정보 조회 <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */  
    function sheet1_OnChange(sheetObj, row, col) {
       	  
    	if( sheetObj.ColSaveName(col) == "sheet1_vsl_slan_cd" ){
    		getVslSlanCd(sheetObj, row, col );
    	}
    }
    /** 
     * Sheet vsl_slan_cd의 정보 조회 <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */  
    function getVslSlanCd(sheetObj, row, col) {
    	var vsl_slan_cd  = sheetObj.CellValue(row,"sheet1_vsl_slan_cd");
    	document.form.f_cmd.value = SEARCH01;
    	var aryPrefix = new Array("sheet1_");
         
    	var sXml = sheetObj.GetSearchXml("VOP_SCG_0035GS.do", FormQueryString(document.form)+"&vsl_slan_cd="+vsl_slan_cd+"&tml_prod_rpt_flg=N"+"&" + ComGetPrefixParam( aryPrefix ) );
    	var VslSlanCd_info = ComGetEtcData(sXml,"VslSlanCd");   
    	setVslSlanCd(row, VslSlanCd_info);
    		
    }
    /** 
     * VslSlanCd  결과 처리  <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */  
    function setVslSlanCd(cRow, VslSlanCd_info) {
    	var sheetObject = sheetObjects[0];
    	
    	var aVslSlanCd_info = VslSlanCd_info.split("|");
    	sheetObject.CellValue2(cRow,"sheet1_vsl_slan_cd")  =  aVslSlanCd_info[0];
    	sheetObject.CellValue2(cRow,"sheet1_vsl_slan_nm")  =  aVslSlanCd_info[1];    
    	sheetObject.CellValue2(cRow,"sheet1_svc_type_name") =  aVslSlanCd_info[2];
    	if( aVslSlanCd_info != 0 ){
    		// sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
    	}
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
    	}

    	return true;
    }

    function sheet1_OnPopupClick(sheetObj, Row, Col)
    {
    	with(sheetObj)
    	{
    		gRow = Row;
    		ComOpenPopup('/hanjin/VOP_VSK_0202.do', 426, 455, "setVslSlanCdPopup", "0,0", true, false, Row, Col, 0);
    	}
    }
    /** 
     * VslSlanCd 팝업에서 선택한 값 Setting. <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */       
    function setVslSlanCdPopup(aryPopupData){
      
   	   var sheetObject = sheetObjects[0];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_slan_cd")   =  aryPopupData[0][1];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_slan_nm"    )   =  aryPopupData[0][2];
	   sheetObject.CellValue2(gRow,"sheet1_vsl_svc_tp_cd"  )   =  aryPopupData[0][3];	   
	   sheetObject.SelectCell(gRow, "sheet1_vsl_slan_cd");  
	    
	   //doActionIBSheet( sheetObject,document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][1] );
   	   gRow =0;
    }  		
   	/* 개발자 작업  끝 */