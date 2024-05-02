/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0163.js
*@FileTitle : US Inbound Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.30 장영석
* 1.0 Creation
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.06.23 전윤주 CSR No.CHM-201004232 US route cost inquiry 화면 기능 수정
* 2011.11.01 최성민 [CHM-201114173-01] CNTR BIZ PFMC Analysis report 화면 수정
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
     * @class ESM_MAS_0163 : ESM_MAS_0163 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0163() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.openLocationCode 		= openLocationCode;
    	this.getF_from       		= getF_from;
    	this.getF_to       		    = getF_to;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
 // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;

    //버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
    document.onclick = processButtonClick;

        // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
        function processButtonClick(){
            var sheetObject = sheetObjects[0];
            var sheetObject1 = sheetObjects[1];
            var formObject = document.form;
            
            try {
                var srcName = window.event.srcElement.getAttribute("name");
                
                switch(srcName) {
                    case "btn_Retrieve":
                        doActionIBSheet(sheetObject,formObject,IBSEARCH);
                        break;
                    case "btn_DownExcel":
                        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                        break;
                    case "btns_buzoomin1":

                        if(sheetObject.Rows > 8){
                            sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows);
                            div_zoom_out1.style.display = "inline";
                            div_zoom_in1.style.display = "none";
                        }
                        break;
                    case "btns_buzoomout1":
                        if(sheetObject.Rows >8){
                            sheetObject.style.height = sheetObject.GetSheetHeight(8);
                            div_zoom_in1.style.display = "inline";
                            div_zoom_out1.style.display = "none";
                        }
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
    		var formObject = document.form;
    		
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
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
    			case 1:	//sheet1 init
    				with (sheetObj) {

    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msPrevColumnMerge;//전체Merge 종류 [선택, Default msNone]  msPrevColumnMerge
    					Editable = false;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					//MassOfSearch = 1;//대량데이타조회시
    					InitColumnInfo(12, 5, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, false, false, true, false,false) ;// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					var HeadTitle = "Bound|TPSZ|FM|Rail Hub|TO|TTL Cost|Railage|Truckage|Mty Trans.\nCost|Railage\nLevel|Truckage\nLevel|Mty Trans.\nLevel";
    					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

    					//데이터속성	[ROW, COL,  DATATYPE,	WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtData,	50, daCenter,	true,	"bound",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++,  dtData, 50, daCenter,   true,   "cntr_tpsz_cd",  false, "",  dfNone,     0,  false,  false);
    					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"fm_loc",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"hub_loc",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,	true,	"to_loc",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	150,daRight,	true,	"ttl_cost",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	100,daRight,	true,	"r_amt",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	100,daRight,	true,	"t_amt",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	100,daRight,	true,	"m_amt",	false,	"",	dfNumber,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	"r_rmk",	false,	"",	dfNone,		0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	"t_rmk",	false,	"",	dfNone,	    0,	false,	false);
    					InitDataProperty(0, cnt++ , dtData,	80,	daCenter,	true,	"m_rmk",	false,	"",	dfNone,	    0,	false,	false);
    					
    					//HeadRowHeight  = 10;
    					CountPosition  = 0 ;
    					style.height = GetSheetHeight(20) ;
    			    }
    				break;

    		}
    	}
    	
    	/**
    	* sheet1조회 후 Null 로 표시된 location 이상의 단가가 있으면 해당 팝업을 호출한다.
    	* location 이상의 단가는 Null 로 표시, TTL AMT 도 Null 로 표시
    	*/
    	function sheet1_OnSearchEnd(sheetObj, errMessge) {  
    		if(sheetObj.RowCount < 1) {
    			ComShowMessage(ComGetMsg("MAS10062"));
    		}
    		
    		/*
    		if(sheetObj.FindText("r_rmk","Null") != -1) {
    			sheetObj.RangeFontColor(1,5,sheetObj.RowCount,5) = sheetObj.RgbColor(255,0,0);
    			sheetObj.RangeFontColor(1,6,sheetObj.RowCount,6) = sheetObj.RgbColor(255,0,0);
    			sheetObj.RangeFontColor(1,9,sheetObj.RowCount,9) = sheetObj.RgbColor(255,0,0);  
    			
    		    for(i=1;i<sheetObj.Rows;i++){	        
    		         sheetObj.CellValue(i,"ttl_cost") = "Null"; 
    		         sheetObj.CellValue(i,"r_amt") = "Null";
    		    }	
    			ComShowMessage(ComGetMsg("MAS10059"));
    		}
    		
    		if(sheetObj.FindText("t_rmk","Null") != -1 ){
    			sheetObj.RangeFontColor(1,5,sheetObj.RowCount,5) = sheetObj.RgbColor(255,0,0);
    			sheetObj.RangeFontColor(1,7,sheetObj.RowCount,7) = sheetObj.RgbColor(255,0,0);
    			sheetObj.RangeFontColor(1,10,sheetObj.RowCount,10) = sheetObj.RgbColor(255,0,0);
    			
    			for(i=1;i<sheetObj.Rows;i++){	        
   		         sheetObj.CellValue(i,"ttl_cost") = "Null"; 
   		         sheetObj.CellValue(i,"t_amt") = "Null";
    			} 
    			ComShowMessage(ComGetMsg("MAS10059"));		
    		}  
    		*/
    		
   	    }

        // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg = false;
            
            switch(sAction) {
                case IBSEARCH:	//조회
                	if(validateForm(sheetObj,formObj,sAction)) {
                		// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
                		formObj.f_cmd.value = SEARCH;
                		sheetObj.DoSearch4Post("ESM_MAS_0163GS.do", masFormQueryString(formObj));
                		ComOpenWait(false);
                	}
                	break;
                case IBDOWNEXCEL:		//엑셀 다운로드
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
    	* location code 공통 팝업 오픈
    	*/
    	function openLocationCode(funtionNm){
    			if(funtionNm == "getF_from" || funtionNm == "getF_to")
    				ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	funtionNm, '1,0,1,1,1,1,1,1,1,1,1,1',true);
    	}
        function getF_from(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_from.value = colArray[3];
    		document.form.f_to.focus();
    	}
    	function getF_to(rowArray) {
    		var colArray = rowArray[0];
    		document.form.f_to.value = colArray[3];
    	}	
    	
    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		with(formObj){
    			if(f_from.value =="") {
    			   ComShowMessage(ComGetMsg('MAS10002', 'From'));
    			    ComSetFocus(formObj.f_from);
    			    return false;
    			}
    			if(f_to.value =="") {
    			    ComShowMessage(ComGetMsg('MAS10002', 'To'));
    			    ComSetFocus(formObj.f_to);
    			    return false;
    			}
    		}
    		return true;
    	}




	/* 개발자 작업  끝 */