/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0148.js
*@FileTitle : BKG Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 이중환
*@LastVersion : 1.1
* 2009.09.11 송호진
* 1.0 Creation
* =========================================================
* History
* 2008.05.30 PEJ N200805260011 COA Report REV 산출 수정 요청
* 2009.05.08 박상희 N200904170011 Report Item 추가(2) : CM COST, OP COST 추가 
* 2009.05.11 박상희 N200904170011 - OPB total 관련 searchend 수정 
* 2009.09.15 송호진  ALPS F/W 적용
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> coaFormQueryString 변경
* 2010.06.14 윤진영 UI표준처리 타이틀 배색 변경
* 2012.02.06 이석준 [CHM-201215969-01] CM2 적용 
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
     * @class ESM_COA_0148 : ESM_COA_0148 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0148() {
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

    var comboObjects = new Array();
    var comboCnt = 0;

    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		var sheetObject = sheetObjects[0];

    		/*******************************************************/
    		var formObject = document.form;

    		try {
    			var srcName = window.event.srcElement.getAttribute("name");

    			switch(srcName) {

    				case "btn_costdetail":
    					openCostDetail();
    					break;

    				case "btn_downexcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btn_close":
    					window.close();
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
                setRetrieveAction();		
    	}
    	
    	/**
    	* 시트 초기설정값, 헤더 정의
    	* param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	* 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	*/
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
            var formObj = document.form;		
    		switch(sheetNo) {
    		    case 1:	//sheet1 init
    				with (sheetObj) {
    		    
                        var colWidth1 = 100;
    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    					Editable = false; //전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(17, 2, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, false, false, true, false,false);// 해더에서 처리할 수 있는 각종 기능을 설정한다

    					var HeadTitle = "BKG NO|TP/SZ|Load|REV|CM COST|CM|CM2 COST|CM2|OP COST|BKG OP" ;

    					if(formObj.f_view_tpsz.value == "box") {
                            HeadTitle  = HeadTitle + "|RPB(BOX)||CM CPB(BOX)|CMB(BOX)||OP CPB(BOX)|OPB(BOX)" ;
                        }else{
                            HeadTitle  = HeadTitle + "|RPB(TEU)||CM CPB(TEU)|CMB(TEU)||OP CPB(TEU)|OPB(TEU)" ;
                        }					

    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle, true);

    					//데이터속성	[ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    									 
                        InitDataProperty(0, cnt++ , dtData,     90,         daCenter, true, "bkg_no",      false, "", dfNone,      0, true, true);
                        
                        InitDataProperty(0, cnt++ , dtData,     50,         daCenter, true,  "spcl_cntr_tpsz_cd",  false, "", dfNone,      0, true, true);
                        InitDataProperty(0, cnt++ , dtAutoSum,  50,         daRight,  true,  "load",       false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  60,         daRight,  true,  "rev",        false, "", dfFloatOrg,  2,  false,  false);
                        
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmc",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm",         false, "", dfFloatOrg,  2,  false,  false);
                        
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm2_cost",         false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm2",         false, "", dfFloatOrg,  2,  false,  false);
                        
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opc",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op",         false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "g_rpb",      false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cm_cost",    false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmcost",     false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "cmb",        false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "op_cost",    false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opcost",     false, "", dfFloatOrg,  2,  false,  false);
                        InitDataProperty(0, cnt++ , dtAutoSum,  colWidth1,  daRight,  true,  "opb",        false, "", dfFloatOrg,  2,  false,  false);

                     
//    					RangeBackColor(0, 8, 0, 11) =  RgbColor(170,210,130)  // ENIS
//    					RangeBackColor(1, 8, 1, 14) =  RgbColor(222, 251, 248);  // ENIS

    					HeadRowHeight  = 10;
    					CountPosition  = 0 ;
    					style.height = GetSheetHeight(15) ;
    					
    					// Profit Level에 따라서 컬럼을 보여준다
                        //------------------------------------
                        ColHidden("cm_cost") = true;
                        ColHidden("op_cost") = true;
                        changeViewColumn();
                        

    			}
    				break;			
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
    	    	
    	/*화면이 로드 되면서 바로 retrieve 되도록 */
    	function setRetrieveAction(){
    		sheetObject = sheetObjects[0];
    		formObject = document.form;

    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    	
    	}
    	
    	
         /**
         * Profit Level에 따라서 컬럼을 보여준다
         */
        function changeViewColumn(){               
            var sheetObj = sheetObjects[0];              
                if (document.form.f_pro_lvl.value == "O" && document.form.f_pro_vw.value == "R"){
                    sheetObj.ColHidden("opc")        = false;
                    sheetObj.ColHidden("op")         = false;
                    sheetObj.ColHidden("opcost")     = false;
                    sheetObj.ColHidden("opb")        = false;
                } else {
                    sheetObj.ColHidden("opc")        = true;
                    sheetObj.ColHidden("op")         = true;
                    sheetObj.ColHidden("opcost")     = true;
                    sheetObj.ColHidden("opb")        = true;
                    
                    if (document.form.f_pro_lvl.value == "M") { // cm2 cost
                    	sheetObj.ColHidden("cm2")             = false;
                    	sheetObj.ColHidden("cm2_cost")        = false;
                    } else {
                    	sheetObj.ColHidden("cm2")             = true;
                    	sheetObj.ColHidden("cm2_cost")        = true;
                    }
                }
                
                if (document.form.f_pro_vw.value == "R"){
                        sheetObj.CellValue(0, "cm")      = "BKG CM";
                        sheetObj.CellValue(0, "cm2")      = "BKG CM2";
                } else {
                        sheetObj.CellValue(0, "cm")      = "CM";
                        sheetObj.CellValue(0, "cm2")      = "CM2";
                }
        }       
        
    	
    	/**
    	* BKG detail정보를 팝업창에서 띄워준다.
    	*/
    	function openCostDetail(){
    		if(!validateForm(sheetObjects[0],document.form,IBSEARCH)) return false;
    		if(sheetObjects[0].RowCount>0){//sheet1에 데이터가 있을때
    		  var cond = '';
    		  var obj1 = sheetObjects[0];				
    	      var row = obj1.SelectRow;
    	      
    			cond = cond + "&s_bkg_no=" + obj1.CellValue(row, "bkg_no")
    				
    		    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
    			ComOpenWindow2('ESM_COA_0149.do?'+ coaFormQueryString(document.form)+cond, 
    			    '_COST', 'width=1010,height=450,menubar=0,status=1,scrollbars=0,resizable=1')	
    		} else {
    			ComShowMessage(ComGetMsg('COA10005', 'Sheet1'));
    		}
    	}

    	/*total값 다시 계산 */
    	function sheet1_OnSearchEnd(sheetObj, errMsg){
            if(eval(sheetObj.SumValue(0, "load")) > 0){
                
                sheetObj.SumValue(0, "g_rpb")  = eval(sheetObj.SumValue(0, "rev")     + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmcost") = eval(sheetObj.SumValue(0, "cm_cost") + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opcost") = eval(sheetObj.SumValue(0, "op_cost") + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "cmb")    = eval(sheetObj.SumValue(0, "cm")      + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
                sheetObj.SumValue(0, "opb")    = eval(sheetObj.SumValue(0, "op")      + "/" + sheetObj.SumValue(0, "load")).toFixed(2);
//                sheetObj.SumValue(0, "opb")    = eval("(" + sheetObj.SumValue(0, "cm")+ "-" + sheetObj.SumValue(0, "op_cost")+ ")/" + sheetObj.SumValue(0, "load")).toFixed(2);
            
            } else {
                
                sheetObj.SumValue(0, "g_rpb") = "0";
                sheetObj.SumValue(0, "cmcost") = "0";
                sheetObj.SumValue(0, "opcost") = "0";
                sheetObj.SumValue(0, "cmb") = "0";
                sheetObj.SumValue(0, "opb") = "0";
                
            }

        }
 
    	/**
    	* sheet1을 더블클릭하여 팝업을 띄운다.
    	*/
    	function sheet1_OnDblClick(sheetObj , row, col){
    		if(validateForm(sheetObj,document.form,IBSEARCH)) openCostDetail();
    	}
    	    	
    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBSEARCH:		//조회
    				if(!validateForm(sheetObj,formObj,sAction)) return false;
    				// 업무처리중 버튼사용 금지 처리
					sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
    				formObj.f_cmd.value = SEARCHLIST01;
        		    //20100414 이중환, FormQueryString -> coaFormQueryString 변경
    				sheetObj.DoSearch4Post("ESM_COA_0148GS.do", coaFormQueryString(formObj));
    				ComOpenWait(false);
    				break;

    			case IBDOWNEXCEL:	//엑셀 다운로드
    				var excelType = selectDownExcelMethod(sheetObj);
    				switch (excelType) {
    					case "AY":
    						sheetObj.Down2Excel(0, false, false, true);
    						break;
    					case "DY":
    						sheetObj.Down2Excel(-1, false, false, true);
    						break;
    					case "AN":
    						sheetObj.SpeedDown2Excel(0, false, false);
    						break;
    					case "DN":
    						sheetObj.SpeedDown2Excel(-1, false, false);
    						break;
    				}

    				break;

    		}
    	}
    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    		}
    		return true;
    	}
    	
    	

	/* 개발자 작업  끝 */