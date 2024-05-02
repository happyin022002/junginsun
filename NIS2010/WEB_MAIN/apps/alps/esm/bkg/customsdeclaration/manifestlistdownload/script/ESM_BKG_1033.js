/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1033.js
 *@FileTitle : Bangladesh Cargo Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.06
 *@LastModifier : 전창현
 *@LastVersion : 1.0
 * 2009.10.06 전창현
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
 * @class Delivery Mode : Delivery Mode 생성 및 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function ESM_BKG_1033() {
    this.processButtonClick		= tprocessButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.doActionIBSheet 		= doActionIBSheet;
    this.validateForm 			= validateForm;
}

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
//    	alert("processButtonClick");
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		 var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if(pgmno == "01"){
	    		if(document.form.data_type[0].checked){									// Outbound B/L List 조회
		            switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC01);
						break;		
						
						case "btn_Save":
							doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
						break;
						
						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						break;
						
						case "btn_New":
							doActionIBSheet(sheetObjects[0],formObject,IBRESET);
						break;
						
		                case "btn_Sailed":
		                	var cal = new ComCalendar();
		     				cal.select(formObject.sail_dt, 'yyyy-MM-dd');
		     			break;
		     			
		                case "btn_PopUp":
		                	var params = FormQueryString(formObject);
		                	ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 850, 500);
		     			break;
		     			
//		                case "btn_Transmit":
//		                	doActionIBSheet(sheetObjects[0],document.form,MULTI01); 	
//		                break;
		            }// end switch
	    		}
	    		else{																		// Outbound D/L List 조회
		            switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC02);
						break;		
						
						case "btn_Save":
							doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
						break;
						
						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						break;   	
						
						case "btn_New":
							doActionIBSheet(sheetObjects[0],formObject,IBRESET);
						break;
						
		                case "btn_Sailed":
		                	var cal = new ComCalendar();
		     				cal.select(formObject.sail_dt, 'yyyy-MM-dd');
		     			break;
		     			
		                case "btn_PopUp":
		                	var params = FormQueryString(formObject);
		                	ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 850, 500);
		     			break;
		     			
//		                case "btn_Transmit":
//		                	doActionIBSheet(sheetObjects[0],document.form,MULTI01); 	
//		                break;
		            }// end switch
	    		}		
    		}
    		else{
	    		if(document.form.data_type[0].checked){									// Inbound B/L List 조회
		            switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC03);
						break;		
						
						case "btn_Save":
							doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
						break;
						
						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						break;
						
						case "btn_New":
							doActionIBSheet(sheetObjects[0],formObject,IBRESET);
						break;
						
		                case "btn_Sailed":
		                	var cal = new ComCalendar();
		     				cal.select(formObject.sail_dt, 'yyyy-MM-dd');
		     			break;
		     			
		                case "btn_Assign":
							doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
		     			break;
		     			
		                case "btn_PopUp":
		                	var params = FormQueryString(formObject);
		                	ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 850, 500);
		     			break;
		     			
		                case "btn_Transmit":
		                	doActionIBSheet(sheetObjects[0],document.form,MULTI01); 	
		                break;
		            }// end switch
	    		}
	    		else{																		// Inbound D/L List 조회
		            switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObjects[0],formObject,IBSEARCH_ASYNC04);
						break;		
						
						case "btn_Save":
							doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
						break;
						
						case "btn_DownExcel":
							doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
						break;   	
						
						case "btn_New":
							doActionIBSheet(sheetObjects[0],formObject,IBRESET);
						break;
						
		                case "btn_Sailed":
		                	var cal = new ComCalendar();
		     				cal.select(formObject.sail_dt, 'yyyy-MM-dd');
		     			break;
		     			
		                case "btn_Assign":
							doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
		     			break;
		     			
		                case "btn_PopUp":
		                	var params = FormQueryString(formObject);
		                	ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 850, 500);
		     			break;
		     			
		                case "btn_Transmit":
		                	doActionIBSheet(sheetObjects[0],document.form,MULTI01); 	
		                break;
		            }// end switch
	    		}	
    		}
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
//    	alert("loadPage");
		for(i=0;i<sheetObjects.length;i++){
//			alert(sheetObjects.length);
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		
		//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("click", "obj_Click", document.form); 

		//콤보 데이터 조회
		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
		
		if(pgmno == "01"){
			ComBtnDisable("btn_Transmit");
		}else{
			ComBtnEnable("btn_Transmit");
		}
	}

	/**
	 * 조회조건 입력할 때 MaxLength까지 입력하면 다음탭으로 이동
	 */
	function obj_KeyUp() {
		var formObject = document.form;
		var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
		var srcValue = window.event.srcElement.getAttribute("value");
		var srcName = window.event.srcElement.getAttribute("name");
		
		if ( (  srcName == "vvd" || srcName == "pol_cd" || srcName == "pol_yd" || srcName == "pod_cd" || srcName == "pod_yd" || srcName == "bl_no" || srcName == "sail_dt" || srcName == "rot_no") && ComChkLen(srcValue, srcMaxLength) == "2" ) {
			ComSetNextFocus();
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
            case "sheet1":      //sheet1 init - Inbound B/L or D/L List 화면 Grid
                with (sheetObj) {

                    // 높이 설정
                    style.height = 400; //148
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|Line No./\nNo. Serial|B/L Number|Number/\nQuantity|Description|Marks & Number|Descriptions of Goods|Date of Entry\nof Goods|Cons.\nLicense No|Cons. Name|Notify\nLicense No|Notify P. Name|Gross Weight\nPer B/L|Net Weight\nPer B/L|Container No|Seal|Size|Type|Height|Cont. Gross\nWeight|Cont. Tare\nWeight|Status|IMCO|UN|VAT|Commodity\nCode|Off Dock Id|Perishable Info|Remarks|ISO Code||||||||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ , dtHiddenStatus,0,daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	 60,	daLeft,			true,		"line_no",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,		"bl_no",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,	 60,	daRight,		true,		"qty",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"description",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	120,	daLeft,			true,		"marks",			false,		"",      dfNone,	0,		true,		true);

                    InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"goods_desc",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"goods_date",		false,		"",      dfDateYmd,	0,		true,		true,	8);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cons_lice",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"cons_nm",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"noty_lice",		false,		"",      dfNone,	0,		true,		true);
										   					                                                                                                        		                                        
                    InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"noty_nm",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"bl_gross_wgt",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"bl_net_wgt",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"cntr_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"seal",				false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtData,	 50,	daRight,		true,		"cntr_size",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"cntr_type",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daRight,		true,		"height",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"cntr_gross_wgt",	false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"cntr_tare_wgt",	false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtCombo, 50,	daLeft,			true,		"status",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"imco",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 50,	daLeft,			true,		"un",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"vat",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cmdt_cd",			false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"off_dock",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtCombo,120,	daLeft,			true,		"perish_cd",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"remarks",			false,		"",      dfNone,	0,		true,		true);

                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"cntr_tpsz_iso_cd",	false,		"",      dfNone,	0,		false,		false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"org_bl_no",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_tz",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pol_cd",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pod_cd",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_wgt",			false,		"",      dfNone,	0,		false,		false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_ut_cd",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"bkg_cgo_tp_cd",	false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vsl_nm",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"voy_no",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"temp",				false,		"",      dfNone,	0,		false,		false);
                    
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vvd",				false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cre_usr_id",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"upd_usr_id",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vsl_cd",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"skd_voy_no",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"skd_dir_cd",		false,		"",      dfNone,	0,		false,		false);
                    
                    InitViewFormat(0, "goods_date", "yyyy-mm-dd");
               }
                break;
                
            case "sheet3":      //sheet3 init - Inbound B/L or D/L List DownExcel Grid
	            with (sheetObj) {
	                // 높이 설정
	                //style.height = 400; //148
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	               //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo(1, 1, 2, 100);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false);
	
	                var HeadTitle1 = "|Line No./\nNo. Serial|B/L Number|Number/\nQuantity|Description|Marks & Number|Descriptions of Goods|Date of Entry\nof Goods|Cons.\nLicense No|Cons. Name|Notify\nLicense No|Notify P. Name|Gross Weight\nPer B/L|Net Weight\nPer B/L|Container No|Seal|Size|Type|Height|Cont. Gross\nWeight|Cont. Tare\nWeight|Status|IMCO|UN|VAT|Commodity\nCode|Off Dock Id|Perishable Info|Remarks|Sailed Year|Ship's Name|Voy No|Import Rot Number|MLO Code|ISO Code|||||||||||||";
	                var headCount = ComCountHeadTitle(HeadTitle1);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	                
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                                    
	                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0,	cnt++ , dtHiddenStatus,0,daCenter,		true,		"ibflag");
	                InitDataProperty(0, cnt++ , dtData,	 60,	daLeft,			true,		"line_no",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtData,	120,	daCenter,		true,		"bl_no",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtData,	 60,	daRight,		true,		"qty",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"description",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	120,	daLeft,			true,		"marks",			false,		"",      dfNone,	0,		true,		true);
	
	                InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"goods_desc",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"goods_date",		false,		"",      dfDateYmd,	0,		true,		true,	8);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cons_lice",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"cons_nm",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"noty_lice",		false,		"",      dfNone,	0,		true,		true);
										   					                                                                                                        		                                        
	                InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"noty_nm",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"bl_gross_wgt",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"bl_net_wgt",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		false,		"cntr_no",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			false,		"seal",				false,		"",      dfNone,	0,		true,		true);
		
	                InitDataProperty(0, cnt++ , dtData,	 50,	daRight,		false,		"cntr_size",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			false,		"cntr_type",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 70,	daRight,		false,		"height",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daRight,		false,		"cntr_gross_wgt",	false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daRight,		false,		"cntr_tare_wgt",	false,		"",      dfNone,	0,		true,		true);
		
	                InitDataProperty(0, cnt++ , dtCombo, 50,	daLeft,			false,		"status",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"imco",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 50,	daLeft,			true,		"un",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"vat",				false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cmdt_cd",			false,		"",      dfNone,	0,		true,		true);
		
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"off_dock",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData, 120,	daLeft,			true,		"perish_cd",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"remarks",			false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_sail_dt",	false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_vsl_nm",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_voy_no",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_rot_no",		false,		"",      dfNone,	0,		true,		true);
	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_mlo_cd",		false,		"",      dfNone,	0,		true,		true);

	                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cntr_tpsz_iso_cd",	false,		"",      dfNone,	0,		true,		true);
	                
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"org_bl_no",		false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_tz",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pol_cd",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pod_cd",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_wgt",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_ut_cd",		false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"bkg_cgo_tp_cd",	false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vsl_nm",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"voy_no",			false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"temp",				false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vvd",				false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cre_usr_id",		false,		"",      dfNone,	0,		false,		false);
	                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"upd_usr_id",		false,		"",      dfNone,	0,		false,		false);
	                
	                InitViewFormat(0, "goods_date", "yyyy-mm-dd");
	           }
            break;
                
            case "sheet2":      //sheet2 init - Outbound B/L or D/L List 화면 Grid
                with (sheetObj) {

                    // 높이 설정
                    style.height = 400;  //358
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    var HeadTitle1 = "|SL No.|TR No.|TR Date|S/BILL\nNo.|S/B Date|EXP No.|EXP Date|POD|Marks &\nNumber|No. of\nPackages|Nat of\nPackage|Descriptions of Goods|Gross Weight|Container No|Seal|Size|Type|Height|Weight|Status|IMCO|UN|VAT|Commodity\nCode|Off Dock Id|Perishable Info|By Whom\nShipped|To  Whom\nShipped||||||||||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,	cnt++ , dtHiddenStatus,0,daCenter,		true,		"ibflag");
                    InitDataProperty(0, cnt++ , dtData,	 60,	daLeft,			true,		"sl_no",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"tr_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"tr_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"sbill_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"sb_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);

                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"exp_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"exp_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"pod_nm",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	120,	daLeft,			true,		"mark_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"pack_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daCenter,		true,		"pack_nat",			false,		"",      dfNone,	0,		true,		true);
										   					                                                                                                        		                                        
                    InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"goods_desc",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	120,	daRight,		true,		"gross_wgt",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"cntr_no",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"seal",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 50,	daRight,		true,		"cntr_size",				false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"cntr_type",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daRight,		true,		"height",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"weight",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtCombo, 50,	daLeft,			true,		"status",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"imco",				false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"un",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"vat",				false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cmdt_cd",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"off_dock",			false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtCombo,120,	daLeft,			true,		"perish_cd",		false,		"",      dfNone,	0,		true,		true);
		
                    InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"shipper_nm",		false,		"",      dfNone,	0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cnee_nm",			false,		"",      dfNone,	0,		true,		true);
                    
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"org_bl_no",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_tz",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pol_cd",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pod_cd",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_wgt",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_ut_cd",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"bkg_cgo_tp_cd",	false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vsl_nm",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"voy_no",			false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vvd",				false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cre_usr_id",		false,		"",      dfNone,	0,		false,		false);
                    InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"upd_usr_id",		false,		"",      dfNone,	0,		false,		false);
                    
                    InitViewFormat(0, "tr_date", "yyyy-mm-dd");
                    InitViewFormat(0, "sb_date", "yyyy-mm-dd");
                    InitViewFormat(0, "exp_date", "yyyy-mm-dd");
               }
                break;
                
	            case "sheet4":      //sheet2 init - Outbound B/L or D/L List DownExcel Grid
		            with (sheetObj) {
	
		                // 높이 설정
		                //style.height = 400;  //358
		                //전체 너비 설정
		                SheetWidth = mainTable.clientWidth;
		
		                //Host정보 설정[필수][HostIp, Port, PagePath]
		                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		
		                //전체Merge 종류 [선택, Default msNone]
		                MergeSheet = msHeaderOnly;
		
		               //전체Edit 허용 여부 [선택, Default false]
		                Editable = true;
		
		                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		                InitRowInfo(1, 1, 2, 100);
		
		                // 해더에서 처리할 수 있는 각종 기능을 설정한다
		                InitHeadMode(true, true, false, true, false,false);
		
		                var HeadTitle1 = "|SL No.|TR No.|TR Date|S/BILL\nNo.|S/B Date|EXP No.|EXP Date|POD|Marks &\nNumber|No. of\nPackages|Nat of\nPackage|Descriptions of Goods|Gross Weight|Container No|Seal|Size|Type|Height|Weight|Status|IMCO|UN|VAT|Commodity\nCode|Off Dock Id|Perishable Info|By Whom\nShipped|To  Whom\nShipped|Sailed Year|Ship's Name|Voy No|Export Rot Number|MLO Code||||||||||||";
		                var headCount = ComCountHeadTitle(HeadTitle1);
		
		                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		                InitColumnInfo(headCount, 0, 0, true);
		
		                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		                InitHeadRow(0, HeadTitle1, true);
		                                    
		                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		                InitDataProperty(0,	cnt++ , dtHiddenStatus,0,daCenter,		true,		"ibflag");
		                InitDataProperty(0, cnt++ , dtData,	 60,	daLeft,			true,		"sl_no",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"tr_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"tr_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"sbill_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"sb_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);
		
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"exp_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"exp_date",			false,		"",      dfDateYmd,	0,		true,		true,	8);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"pod_nm",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	120,	daLeft,			true,		"mark_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"pack_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	 70,	daCenter,		true,		"pack_nat",			false,		"",      dfNone,	0,		true,		true);
											   					                                                                                                        		                                        
		                InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"goods_desc",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	120,	daRight,		true,		"gross_wgt",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daCenter,		true,		"cntr_no",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"seal",				false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	 50,	daRight,		true,		"cntr_size",				false,		"",      dfNone,	0,		true,		true);
			
		                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"cntr_type",				false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	 70,	daRight,		true,		"height",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daRight,		true,		"weight",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtCombo, 50,	daLeft,			true,		"status",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"imco",				false,		"",      dfNone,	0,		true,		true);
			
		                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"un",				false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	 70,	daLeft,			true,		"vat",				false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cmdt_cd",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"off_dock",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData, 120,	daLeft,			true,		"perish_cd",		false,		"",      dfNone,	0,		true,		true);
			
		                InitDataProperty(0, cnt++ , dtData,	150,	daLeft,			true,		"shipper_nm",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"cnee_nm",			false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_sail_dt",	false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_vsl_nm",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_voy_no",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_rot_no",		false,		"",      dfNone,	0,		true,		true);
		                InitDataProperty(0, cnt++ , dtData,	100,	daLeft,			true,		"excel_mlo_cd",		false,		"",      dfNone,	0,		true,		true);
		                
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"org_bl_no",		false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_tz",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pol_cd",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"pod_cd",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_wgt",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cntr_ut_cd",		false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"bkg_cgo_tp_cd",	false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vsl_nm",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"voy_no",			false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"vvd",				false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"cre_usr_id",		false,		"",      dfNone,	0,		false,		false);
		                InitDataProperty(0, cnt++ , dtHidden,100,	daCenter,		true,		"upd_usr_id",		false,		"",      dfNone,	0,		false,		false);
		                
		                InitViewFormat(0, "tr_date", "yyyy-mm-dd");
	                    InitViewFormat(0, "sb_date", "yyyy-mm-dd");
	                    InitViewFormat(0, "exp_date", "yyyy-mm-dd");
										
		            }
            break;
        }
    }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         //sheetObj.ShowDebugMsg = false;
    	 sheetObj.WaitImageVisible = false;
    	 
         switch(sAction) {
 			case IBCREATE:      //콤보 데이터 조회
 				formObj.f_cmd.value = INIT;
 				var sXml = sheetObj.GetSearchXml("ESM_BKG_1033GS.do", FormQueryString(formObj));
 				var arrXml = sXml.split('|$$|');
 				var arrCombo;
 				
 				arrCombo = ComXml2ComboString(arrXml[0], "name", "val");
 				sheetObj.InitDataCombo(0, "perish_cd", arrCombo[0], arrCombo[1]);

 				arrCombo = ComXml2ComboString(arrXml[1], "val", "val");
 				sheetObj.InitDataCombo(0, "status", arrCombo[0], arrCombo[1]);
	    	break;
	    	
	        case IBSEARCH_ASYNC01:      //Outbound B/L List 조회
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
				formObj.io_flag.value = 'O';
				formObj.data_flag.value = 'B';
    			formObj.f_cmd.value = SEARCH01;
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_1033GS.do", FormQueryString(formObj));
    			var arrXml = sXml.split('|$$|');
    			sheetObj.Redraw = false;  
    			sheetObj.LoadSearchXml(arrXml[0]);
    			
    			if(sheetObj.RowCount > 0){
    				formObj.vsl_nm.value = ComGetEtcData(arrXml[0],"vsl_nm");
    				formObj.voy_no.value = ComGetEtcData(arrXml[0],"voy_no");    
    			}
    			else{
    				formObj.vsl_nm.value = "";
    				formObj.voy_no.value = "";
    			}
    			var sheetObj2 = sheetObjects[1];
    			sheetObj2.LoadSearchXml(sXml);
                sheetObj.Redraw = true;  
    			ComOpenWait(false);
    		break;
    		
	        case IBSEARCH_ASYNC02:      //Outbound D/L List 조회
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
				formObj.io_flag.value = 'O';
				formObj.data_flag.value = 'D';
    			formObj.f_cmd.value = SEARCH02;
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_1033GS.do", FormQueryString(formObj));
    			var arrXml = sXml.split('|$$|');
    			sheetObj.Redraw = false;  
    			sheetObj.LoadSearchXml(arrXml[0]);
    			
    			if(sheetObj.RowCount > 0){
    				formObj.vsl_nm.value = ComGetEtcData(arrXml[0],"vsl_nm");
    				formObj.voy_no.value = ComGetEtcData(arrXml[0],"voy_no");    
    			}
    			else{
    				formObj.vsl_nm.value = "";
    				formObj.voy_no.value = "";
    			}
    			var sheetObj2 = sheetObjects[1];
    			sheetObj2.LoadSearchXml(sXml);
                sheetObj.Redraw = true;
    			ComOpenWait(false);
    		break;
    		
	        case IBSEARCH_ASYNC03:      //Inbound B/L List 조회
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
				formObj.io_flag.value = 'I';
				formObj.data_flag.value = 'B';
    			formObj.f_cmd.value = SEARCH03;
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_1033GS.do", FormQueryString(formObj));
    			var arrXml = sXml.split('|$$|');
                sheetObj.Redraw = false;
    			sheetObj.LoadSearchXml(arrXml[0]);      			
    			
    			if(sheetObj.RowCount > 0){
    				formObj.vsl_nm.value = ComGetEtcData(arrXml[0],"vsl_nm");
    				formObj.voy_no.value = ComGetEtcData(arrXml[0],"voy_no");   

    			}
    			else{
    				formObj.vsl_nm.value = "";
    				formObj.voy_no.value = "";
    			}

    			var sheetObj2 = sheetObjects[1];
    			sheetObj2.LoadSearchXml(arrXml[1]);
                sheetObj.Redraw = true;  
    			ComOpenWait(false);
    		break;
    		
	        case IBSEARCH_ASYNC04:      //Inbound D/L List 조회
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
				formObj.io_flag.value = 'I';
				formObj.data_flag.value = 'D';
    			formObj.f_cmd.value = SEARCH04;
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_1033GS.do", FormQueryString(formObj));
    			var arrXml = sXml.split('|$$|');
                sheetObj.Redraw = false;  
    			sheetObj.LoadSearchXml(arrXml[0]);
    			
    			if(sheetObj.RowCount > 0){
    				formObj.vsl_nm.value = ComGetEtcData(arrXml[0],"vsl_nm");
    				formObj.voy_no.value = ComGetEtcData(arrXml[0],"voy_no");    
    			}
    			else{
    				formObj.vsl_nm.value = "";
    				formObj.voy_no.value = "";
    			}
    			var sheetObj2 = sheetObjects[1];
    			sheetObj2.LoadSearchXml(arrXml[1]);
                sheetObj.Redraw = true;
    			ComOpenWait(false);
    		break;
    			
	        case IBRESET:        //초기화
    	    	formObj.reset();
    	    	sheetObj.RemoveAll();
    	    break;
			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
		    	formObj.f_cmd.value = MULTI;
		    	var sXml = sheetObj.GetSaveXml("ESM_BKG_1033GS.do", FormQueryString(formObj)+"&"+ComGetSaveString(sheetObj, true, true));
		    	sheetObj.LoadSaveXml(sXml);		// Save 가 정상적이면 성공 메세지를 보여준다.
				ComOpenWait(false);
			break;
    		
	        case MULTI01:      //EDI Transmit

			    formObj.f_cmd.value = MULTI01;
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true); 
				
				for (var i=1; i < sheetObjects[0].RowCount+1; i++)
				{   
					sheetObjects[0].RowStatus(i) = "I";		
					sheetObjects[0].CellValue2(i, "vsl_cd") = formObj.vvd.value.substring(0,4);
					sheetObjects[0].CellValue2(i, "skd_voy_no") = formObj.vvd.value.substring(4,8);
					sheetObjects[0].CellValue2(i, "skd_dir_cd") = formObj.vvd.value.substring(8);
//					sheetObjects[0].CellValue2(i, "vsl_nm") = formObj.vsl_nm.value; 이미 있음
//					sheetObjects[0].CellValue2(i, "carrier_no") = formObj.carrier_no.value;
//					sheetObjects[0].CellValue2(i, "customs_office_code") = formObj.customs_office_code.value;
//					sheetObjects[0].CellValue2(i, "reg_no") = formObj.reg_no.value;
//					sheetObjects[0].CellValue2(i, "call_port") = formObj.call_port.value;
//					sheetObjects[0].CellValue2(i, "auth_no") = formObj.auth_no.value;
				} 	
				
				var sParam ="";
    			var sParamSheet2 = sheetObjects[0].GetSaveString();
    			if (sParamSheet2 != "") {    	    				 
    				sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1");
    			}		
    			sParam += "&" + FormQueryString(formObj);    		
    			var sXml = sheetObj.GetSaveXml("ESM_BKG_1033GS.do", sParam);
    			sheetObjects[0].LoadSaveXml(sXml);
    			sXml = ComDeleteMsg(sXml); 
    			ComOpenWait(false); 
    		break;
			
			case IBDOWNEXCEL:   //Down Excel
				ComOpenWait(true);
				sheetObjects[1].CellValue2(1,"excel_sail_dt") = formObj.sail_dt.value;
				sheetObjects[1].CellValue2(1,"excel_vsl_nm") = formObj.vsl_nm.value;
				sheetObjects[1].CellValue2(1,"excel_voy_no") = formObj.voy_no.value;
				sheetObjects[1].CellValue2(1,"excel_rot_no") = formObj.rot_no.value;
				sheetObjects[1].CellValue2(1,"excel_mlo_cd") = formObj.mlo_cd.value;
		   	    sheetObjects[1].SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
				ComOpenWait(false);
			break;
			
			case IBINSERT:		// Assign 버튼을 통해 Sailed Year 를 Date of Entry of Goods 에 셋팅
				sheetObj.Redraw = false;
				for(var i=1; i<sheetObj.RowCount+1; i++){
					sheetObj.CellValue2(i, "goods_date") = formObj.sail_dt.value;					//Grid에 셋팅
					if(sheetObjects[1].CellValue(i,"bl_no") == ""){
					}else{
						sheetObjects[1].CellValue2(i,"goods_date") = formObj.sail_dt.value;			//엑셀에 셋팅
					}
				}
				sheetObj.Redraw = true;
			break;
         }
     }


     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
      function validateForm(sheetObj,formObj,sAction){
     	 switch (sAction) {
     	    case IBSEARCH_ASYNC01: // 조회
     			if(!ComChkRequired(formObj)) return false;
     	        break;
 
     	    case IBSEARCH_ASYNC02: // 조회
 			if(!ComChkRequired(formObj)) return false;
 	        break;
 	        
     	    case IBSEARCH_ASYNC03: // 조회
 			if(!ComChkRequired(formObj)) return false;
 	        break;
 	        
     	    case IBSEARCH_ASYNC04: // 조회
 			if(!ComChkRequired(formObj)) return false;
 	        break;
 	        
     	 }

          return true;
      }
 		