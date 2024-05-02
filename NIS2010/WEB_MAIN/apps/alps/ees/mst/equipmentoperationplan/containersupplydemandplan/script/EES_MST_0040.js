/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0040.js
*@FileTitle : EQ Procurement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.07.10 민정호
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
     * @class EES_MST_0040 : EES_MST_0040 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function EES_MST_0040() {
    	this.processButtonClick		= processButtonClick;
    	this.setSheetObject 		= setSheetObject;
		this.setComboObject 		= setComboObject;    	
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
		this.obj_blur				= obj_blur;
		this.obj_focus				= obj_focus;
		this.obj_keypress			= obj_keypress;    	    	
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수
var vOrcCntrTpszCd = "";
   	
var sheetObjects = new Array();
var sheetCnt = 0;
 
// Combo Object Array
var comboObjects = new Array();
var comboCnt = 0; 

 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {  	 
	    var formObj = document.form;
		 
		initControl();	
			
	     for(i=0;i<sheetObjects.length;i++){
	     //khlee-시작 환경 설정 함수 이름 변경
	         ComConfigSheet (sheetObjects[i] );
	         initSheet(sheetObjects[i],i+1);
	     //khlee-마지막 환경 설정 함수 추가
	         ComEndConfigSheet(sheetObjects[i]);
	     }         		 
	} 

	/**
	 * sheet1에서 LoadFinish이벤트를 처리한다.
	 * @param sheetObj
	 * @return
	 */
	function sheet1_OnLoadFinish(sheetObj) {
		addCombo();	// 콤보박스 아이템 추가
		ComBtnDisable("btn_save");		
		ComBtnDisable("btn_loadexcel");	
	} 
 
	/**
	 * Form 이벤트 등록
	 */
	function initControl() {
		var formObj = document.form;
	
		axon_event.addListenerFormat('blur', 'obj_deactivate',  form); 					//- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리		
		axon_event.addListenerFormat('keypress',	'obj_keypress',	formObj); 			//- 키 눌렸을때	
		axon_event.addListener('change', 'pln_yr_change', 'input_pln_yr', '');			//pln_yr 변경시 이벤트 처리
	}

	// pln_yr 값이 변화할때 이벤트
	function pln_yr_change(){
		var selYr = ComGetObjValue(form.input_pln_yr);
		var prevYr = eval(selYr) - 1;
		
		if(selYr != ''){
			var inYrMon1 = prevYr + "-07|" + prevYr + "-08|" + prevYr + "-09|" + prevYr
							+ "-10|" + prevYr + "-11|" + prevYr + "-12|";
			var inYrMon2 = selYr + "-01|" + selYr + "-02|" + selYr + "-03|" + selYr
							+ "-04|" + selYr + "-05|" + selYr + "-06";
			
			var inYrMon = inYrMon1 + inYrMon2;
			var arrYrMon = inYrMon.split("|");
			
			form.bse_dt1.RemoveAll();
			with (form.bse_dt1) {
				DropHeight = 270;
				for ( var i = 0; i < inYrMon.split("|").length; i++) {
					InsertItem(i, arrYrMon[i], arrYrMon[i]);
				}
			}	
		}
	}


	 // 콤보박스 아이템 추가
	 function addCombo(){
		var plnYr = "2006|"
		var today = new Date();
		var lastYr = today.getYear() + 1;
		for ( var k = 2007; k <= lastYr; k++) {
			if (k == lastYr) {
				plnYr = plnYr + k;
			} else {
				plnYr = plnYr + k + "|";
			}
		}
		var arrPlnYr = plnYr.split("|");
	
		with (form.input_pln_yr) {
			DropHeight = 270;
			for ( var i = 0; i < plnYr.split("|").length; i++) {
				InsertItem(i, arrPlnYr[i], arrPlnYr[i]);
			}
		} 
	 }
  
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
 					sheetObject1.RemoveAll();				
 					formObject.input_bse_yrmon.value = ComReplaceStr(ComGetObjValue(form.bse_dt1), "-", "");
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
				
				case "btn_new":
 					comboObjects[0].Code = "";
 					comboObjects[1].Code = "";
 					
 					formObject.input_pln_yr.value = "";
 					formObject.bse_dt1.value = "";
 					
					sheetObject1.RemoveAll();
					comboObjects[1].RemoveAll();
					sheetObject1.ColBackColor("g_total") = sheetObject1.SubSumBackColor;
					
					comboObjects[0].Enable = true;
					ComBtnDisable("btn_loadexcel");				
					ComBtnEnable("btn_retrieve");		
					ComBtnDisable("btn_save");					
				break;
				
				case "btn_save":					
					formObject.input_bse_yrmon.value = ComReplaceStr(ComGetObjValue(form.bse_dt1), "-", "");
					setCntrProcuPlnCd();					
					setHBseYrmon();
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);	
				break;
				
				
				case "btn_loadexcel":						
					var aa = sheetObject1.LoadExcel(-1,1,"","-1","-1","",false);
				break; 
				
				case "btn_downexcel":
					sheetObject1.Down2Excel(-1);
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
  	 * IBMultiCombo Object를 배열로 등록
  	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  	 * 배열은 소스 상단에 정의
  	 */
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++] = combo_obj;
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
                     //style.height = 440;
                     //전체 너비 설정
                     //SheetWidth = mainTable.clientWidth;
                     SheetWidth = 989;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msPrevColumnMerge + msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 14, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0, 2, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, false, false, true, false,false);
                     Rows = 14;
                     var HeadTitle = "Item|TP/SZ|D2|D4|D5|D7|R2|R5|O2|O4|F2|F4|G.Total|";                     
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         			 InitHeadRow(0, HeadTitle, true);                     

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData, 200,  daCenter,  true, "item",		false,      "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData, 100,  daCenter,  true, "tp_sz",		false,      "",      dfNone, 		0,     false,       false);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d2_qty",	false,      "",      dfInteger, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d4_qty",	false,      "",      dfInteger, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d5_qty",	false,      "",      dfInteger,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "d7_qty",	false,      "",      dfInteger, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "r2_qty",	false,      "",      dfInteger,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "r5_qty",	false,      "",      dfInteger, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "o2_qty",	false,      "",      dfInteger,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "o4_qty",	false,      "",      dfInteger,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "f2_qty",	false,      "",      dfInteger,		0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "f4_qty",	false,      "",      dfInteger, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData, 60,  daRight,   false,  "g_total",	false,      "|d2_qty|+|d4_qty|+|d5_qty|+|d7_qty|+|r2_qty|+|r5_qty|+|o2_qty|+|o4_qty|+|f2_qty|+|f4_qty|",      dfInteger,		0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  false,   "cntr_procu_pln_cd");
					InitDataProperty(0, cnt++ , dtHidden,  		0,    daCenter,  false,   "h_bse_yrmon");
					InitDataProperty(0, cnt++ , dtHiddenStatus, 0,    daCenter,  false,   "ibflag");
					InitHeadColumn(0, "Inventory in Current Year|Inventory in Current Year|Inventory in Current Year|Plan Year|Plan Year|Reduction Plan|Reduction Plan|Reduction Plan|Reduction Plan|Reduction Plan|EQ Procurement Qty in Plan Year|EQ Procurement Qty in Plan Year|EQ Procurement Qty in Plan Year");
					InitHeadColumn(1, "OW|LT|ST|Supply Plan|Sales Plan|EQ Disposal(-)|LT Off Hire(-)|ST Off Hire(-)|OW Delivery(+)|LT Delivery(+)|OW|LT|ST");

					CountPosition = 0;
					ColBackColor("g_total") = SubSumBackColor;
                }
                 break;
         }
     }

     // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {		         
			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){	
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch("EES_MST_0040GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
			break;
			
			case IBSAVE: 		//저장
				if (validateForm(sheetObj, formObj, sAction)){
					if (!window.confirm("Do you want to save?")) {
						return false;
					}
					sheetObj.WaitImageVisible=false;
					ComOpenWait(true);
					formObj.f_cmd.value = MULTI;
					sheetObj.DoSave("EES_MST_0040GS.do", FormQueryString(formObj),-1,false);
					ComOpenWait(false);
				}
			break;			
         }
      }
     
      /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
     		switch(sAction) {        	 
				case IBSEARCH://조회
					if ( ComGetObjValue(formObj.input_pln_yr) == "" ) {
						ComShowCodeMessage("MST00001","Plan Year");
						ComSetFocus(formObj.input_pln_yr);
						return false;
					}						
				break;
				
				case IBSAVE://조회
					if ( ComGetObjValue(formObj.input_pln_yr) == "" ) {
						ComShowCodeMessage("MST00001","Plan Year");
						ComSetFocus(formObj.input_pln_yr);
						return false;
					}
				
					if ( ComGetObjValue(formObj.bse_dt1) == "" ) {
						ComShowCodeMessage("MST00001","Inventory Year & Month");
						ComSetFocus(formObj.bse_dt1);
						return false;
					}				
				break;				
     		}
         }
         return true;
     }     	
	
	 /**
	 * Key-Press Event 처리
	 */
 	 function obj_keypress() {
		var obj = event.srcElement;

		switch(obj.dataformat) {
	        case "ymd":
	        case "ym":
	        case "hms":
	        case "hm":
	        case "jumin":
	        case "saupja":
	        case "int":
	            ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet(); 
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        default:
	            ComKeyOnlyNumber(obj);
	        	break;
	    }
 	 }	
	
      	       
	 //Axon 이벤트 처리2. 이벤트처리함수
	 function obj_deactivate(){
		
		var obj = event.srcElement;
	    switch(obj.name){
	        default:
	            //Validation 전체 체크(길이,format,최대,최소 등등)
	            ComChkObjValid(obj);
	        	break;
	    }				
	 }  	 	    
	 
	 /**
	  * 엑셀 업로드시 체크
	  * @param sheetObj
	  * @return
	  */
	 function sheet1_OnLoadExcel(sheetObj){		 		 		 
		var rowCount = sheetObj.RowCount;		 
		for(var Row=1; Row<rowCount+1; Row++){
			for(var Col=2; Col<12; Col++){
				if(Row == 6 || Row == 7 || Row == 8){
					if( sheetObj.cellValue(Row, Col) > 0 ) {
						sheetObj.cellValue(Row, Col) = 0;
					}
				}else{
					if( sheetObj.cellValue(Row, Col) < 0 ) {
						sheetObj.cellValue(Row, Col) = 0;
					}			
				}
			}
		}	
	 }
	  
	 // row, col 
	 function sheet1_OnChange(Value, Row, Col){		
		var sheetObject1 = sheetObjects[0];		 
		 		
		sheetObject1.ColBackColor("g_total") = sheetObject1.SubSumBackColor;		
		
		if(Row == 6 || Row == 7 || Row == 8){
			if( sheetObject1.cellValue(Row, Col) > 0 ) {
				sheetObject1.cellValue2(Row, Col) = 0;
			}
		}else{
			if( sheetObject1.cellValue(Row, Col) < 0 ) {
				sheetObject1.cellValue2(Row, Col) = 0;
			}			
		}		
	 }
	  
	  
	// CNTR_PROCU_PLN_CD 값세팅
	function setCntrProcuPlnCd(){
		var sheetObject1 = sheetObjects[0];
		
		//		장비 확보계획 구분 코드
		//
		//		A:Inventory in the end this Year(OW)
		//		B:Inventory in the end this Year(LT)
		//		C:Inventory in the end this Year(ST)
		//		D:Supply Plan In Next Year(Supply Plan)
		//		E:Supply Plan In Next Year(Sales Plan)
		//		F:Reduction Plan in Next Year(EQ Disposal)
		//		G:Reduction Plan in Next Year(LT Off Hire)
		//		H:Reduction Plan in Next Year(ST Off Hire)
		//		I:.Reduction Plan in Next Year(OW Delivery)
		//		J:Reduction Plan in Next Year(LT Delivery)
		
		sheetObject1.CellValue2(1,"cntr_procu_pln_cd") = "A";
		sheetObject1.CellValue2(2,"cntr_procu_pln_cd") = "B";
		sheetObject1.CellValue2(3,"cntr_procu_pln_cd") = "C";		
		sheetObject1.CellValue2(4,"cntr_procu_pln_cd") = "D";
		sheetObject1.CellValue2(5,"cntr_procu_pln_cd") = "E";
		sheetObject1.CellValue2(6,"cntr_procu_pln_cd") = "F";
		sheetObject1.CellValue2(7,"cntr_procu_pln_cd") = "G";
		sheetObject1.CellValue2(8,"cntr_procu_pln_cd") = "H";
		sheetObject1.CellValue2(9,"cntr_procu_pln_cd") = "I";		
		sheetObject1.CellValue2(10,"cntr_procu_pln_cd") = "J";	
		sheetObject1.CellValue2(11,"cntr_procu_pln_cd") = "K";
		sheetObject1.CellValue2(12,"cntr_procu_pln_cd") = "L";
		sheetObject1.CellValue2(13,"cntr_procu_pln_cd") = "M";		
	}
	
	// H_BSE_YRMON 값세팅
	function setHBseYrmon(){
		var sheetObject1 = sheetObjects[0];
		
		sheetObject1.CellValue2(1,"h_bse_yrmon") = ComReplaceStr(ComGetObjValue(form.bse_dt1), "-", "");
		sheetObject1.CellValue2(2,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(3,"h_bse_yrmon") = "";		
		sheetObject1.CellValue2(4,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(5,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(6,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(7,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(8,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(9,"h_bse_yrmon") = "";		
		sheetObject1.CellValue2(10,"h_bse_yrmon") = "";	
		sheetObject1.CellValue2(11,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(12,"h_bse_yrmon") = "";
		sheetObject1.CellValue2(13,"h_bse_yrmon") = "";		
	}	
	
	// 조회 후 설정
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form; 
		var comboObject1 = comboObjects[1];
		var comboObject0 = comboObjects[0];		
		var rowCount = sheetObj.RowCount;
		var h_bse_yrmon = sheetObj.CellValue(1,"h_bse_yrmon");
	
		if(rowCount > 0){		
			sheetObj.ColBackColor("g_total") = sheetObj.SubSumBackColor;			
			comboObject1.Text = h_bse_yrmon.substring(0,4) + "-" + h_bse_yrmon.substring(4,6);
			comboObject0.Enable = false;				
			ComBtnDisable("btn_retrieve");		
			ComBtnEnable("btn_save");				
			ComBtnEnable("btn_loadexcel");	
		}		 
	 }
		    
	 // 저장 후 설정
	 function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		 		
		if(ErrMsg != '' && ErrMsg.length > 0) return;
				
		ComShowCodeMessage("MST01025");
		sheetObject1.RemoveAll();				
		formObject.input_bse_yrmon.value = ComReplaceStr(ComGetObjValue(form.bse_dt1), "-", "");			
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
	 }
	 
	/* 개발자 작업  끝 */