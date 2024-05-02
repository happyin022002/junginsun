/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0277.js
*@FileTitle : DEM/DET Cost Report by Customer
*Open Issues :
*@LastModifyDate : 2015-03-24
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-03-24 Je Ryang Yoo
*  1.0 최초 생성
=========================================================*/

/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
	/**
	 * @extends 
	 * @class ESM_MAS_0277 : ESM_MAS_0277 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0277() {
	    this.processButtonClick    = processButtonClick;
	    this.loadPage              = loadPage          ;
	    this.initSheet             = initSheet         ;
	    this.initCombo 			   = initCombo         ;
	    this.setSheetObject        = setSheetObject    ;
	    this.setPeriod             = setPeriod         ;
	    this.doActionIBSheet       = doActionIBSheet   ;
	    this.validateForm          = validateForm      ;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;
	
	var loadingMode = false;
	
	var EXCEL_LOAD_FLG = false;	//엑셀 로드 실행체크
	var sRow = 0;
	
	/** 
	 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의  
	 */
	document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
        
            switch(srcName) {
                case "btn_Retrieve":                	
                	doActionIBSheet(sheetObject,formObject,IBSEARCH);
                	if ( formObject.f_demdet.checked ) {	   				
    	   				sheetObjects[0].ColHidden("dmdt_com_amt") = false;
    	   				sheetObjects[0].ColHidden("dmdt_com_amt2") = false;
    	   	    	} else {	   	    		
    	   	    		sheetObjects[0].ColHidden("dmdt_com_amt") = true;
    	   	    		sheetObjects[0].ColHidden("dmdt_com_amt2") = true;	   	    	
    	   	    	}
                    break;
                    
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                /*case "f_demdet": // 조회영역 체크박스 체크시 시트 헤더 히든처리 부분 관리
		   			if ( formObject.f_demdet.checked ) {
		   				doActionIBSheet(sheetObject,formObject,IBSEARCH);
		   				sheetObjects[0].ColHidden("dmdt_com_amt") = false;
		   				sheetObjects[0].ColHidden("dmdt_com_amt2") = false;
		   	   			//sheetObjects[0].ColHidden("cost_yrmon") = false;
		   	   			//sheetObjects[0].ColHidden("cost_wk") = true;
		   	    	} else {
		   	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
		   	    		sheetObjects[0].ColHidden("dmdt_com_amt") = true;
		   	    		sheetObjects[0].ColHidden("dmdt_com_amt2") = true;
		   	    		//sheetObjects[0].ColHidden("cost_yrmon") = false;
		   	    		//sheetObjects[0].ColHidden("cost_wk") = false;
		   	    	}    		            		    	
                    break;*/
                                    
              /*
				case "btn_New":
                    doActionIBSheet(sheetObject,formObject,IBRESET);
                    break;
                    
                case "btn_Save":    	
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                       
				case "btn_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                    
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                
                case "btng_copyfrompast":
                    break;
                                        
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;

                case "btn_Create":
                    doActionIBSheet(sheetObject,formObject,IBCREATE);
                    break;
                    
                case "btn_rowadd":                	     
                	sheetObject.DataInsert(-1);
                    break;
                    
                case "btn_rowdel":                	   
					if(sheetObject.FindCheckedRow("del_chk") != ""){
						ComRowHideDelete(sheetObject,"del_chk");
					} else {
						ComShowCodeMessage("MNR00150");
					}
                    break;*/           
        
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } finally {
        	ComOpenWait(false);
        }
        
    }
        
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	var formObj = document.form;
    	loadingMode = true;      	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        loadingMode = false;
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        
        for(k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],comboObjects[k].id);
    	}
        /*for(k=0;k<comboObjects.length;k++){
	    	doActionComboSheet(sheetObjects[0], document.form, comboObjects[k]);		
		}*/
        //formObj.f_revyrmon.className = "input1";
        //ComSetFocus(document.form.f_revyrmon);
        sheetObjects[0].ColHidden("dmdt_com_amt") = true;
   		sheetObjects[0].ColHidden("dmdt_com_amt2") = true;
    }
    
    /**
	 * 멀티콤보 항목을 설정한다.
	 */
 	function initCombo(comboObj, comboId) {
 		with (comboObj) {
 			switch(comboObj.id) {
	 			case "f_status":
					InsertItem(0, "All", "A");
					InsertItem(1, "Finish", "F");
					InsertItem(2, "Unfinish", "U");
					Index = 0;
					break;
			}
 		}
 	}
    
    /*function doActionComboSheet(sheetObj, formObj, comboObjects) {
    	try {    		
    		sheetObj.ShowDebugMsg = false;
    		switch (comboObjects.id) {
    		case "ob_sto_flg":
    			//comboObjects.RemoveAll();
    			comboObjects.InsertItem(0, '', ''); 
    			comboObjects.InsertItem(1, 'Y', 'Y'); 
    			comboObjects.InsertItem(2, 'N', 'N');
    			break;
    		}
    	} catch (e) {
    		if (e == "[object Error]") {
    			ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	} finally {
    		ComOpenWait(false);
    	}		
    }*/
 	
 	/**
	 * IBCombo Object를 배열로 등록
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
            		//style.height = 202;
                    SheetWidth = sheetTable.clientWidth; //전체 너비 설정
            		//SheetWidth = 400; //전체 너비 설정
                    
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msHeaderOnly;                          //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                    //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo(2, 1, 1, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle1  = "|STS|YYYY-MM|WK|Contract|Por|Del|S/C|RFA|TPSZ|Status|Original CM|Original CM|Original CM|Original CM|Original CM|Original CM|Revised CM|Revised CM|Revised CM|Revised CM|Revised CM|Revised CM";
                    var HeadTitle2  = "|STS|YYYY-MM|WK|Contract|Por|Del|S/C|RFA|TPSZ|Status|Box|Dem/Det Rev|Storage(Per Box)|CNTR EQ Cost\n(Per Box)|CHZ EQ Cost\n(Per Box)|CMPB|Box|Dem/Det Rev|Storage(Per Box)|CNTR EQ Cost\n(Per Box)|CHZ EQ Cost\n(Per Box)|CMPB2";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 10, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);
                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHidden,       30,     daCenter,   true,    "");
                    InitDataProperty(0,     cnt++,  dtHiddenStatus, 30,     daCenter,   true,    "ibflag");                    
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "cost_yrmon",         false,   "",   dfUserFormat,  0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daCenter,   true,    "cost_wk",      	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "ctrt_ofc_cd",        false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "por_cd",       	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         50,     daCenter,   true,    "del_cd",       	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "sc_no",       	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         70,     daCenter,   true,    "rfa_no",       	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daCenter,   true,    "cntr_tpsz_cd",       false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         60,     daCenter,   true,    "status",       	   false,   "",   dfNone,        0,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daRight,    true,    "bkg_qty",            false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daRight,    true,    "dmdt_com_amt",       false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        110,     daRight,    true,    "sto_eq_amt",         false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,    "cntr_org_dem_amt",   false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,    "chss_org_dem_amt",   false,   "",   dfNullFloat,   2,  false,  false);                    
                    InitDataProperty(0,     cnt++,  dtData,         80,     daRight,    true,    "cmpb",       		   false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         40,     daRight,    true,    "cntr_qty",           false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,         90,     daRight,    true,    "dmdt_com_amt2",  	   false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        110,     daRight,    true,    "sto_dem_amt",        false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,    "cntr_dem_amt",       false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,    "chss_dem_amt",       false,   "",   dfNullFloat,   2,  false,  false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daRight,    true,    "cmpb2",       	   false,   "",   dfNullFloat,   2,  false,  false);
                    
                    sheetObj.InitUserFormat(0, "cost_yrmon", "####-##", "-" );
                    
                    /*InitDataValid(0, "bkg_no",    vtEngUpOther, "1234567890");
                    InitDataValid(0, "cntr_no",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "tpsz_cd",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "term_cd",   vtEngUpOther, "1234567890");
                    InitDataValid(0, "mvmt_cd",   vtEngUpOther, "1234567890");
                    //InitDataValid(0, "onh_dt",    vtNumericOnly);
                    InitDataValid(0, "onh_yd_cd", vtEngUpOther, "1234567890");
                    //InitDataValid(0, "offh_dt",   vtNumericOnly);
                    InitDataValid(0, "offh_yd_cd",vtEngUpOther, "1234567890");*/
                    
                    CountPosition = 0;
                    
                    sheetObj.style.height = 430; //sheetObj.GetSheetHeight(13);                    
                    //Edit 가능한 셀과 불가능한 셀을 배경색으로 구분하여 표시 (업로드시)
                    EditableColorDiff = true;
                    WaitImageVisible = false;
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
    
    /**
     * year, month, week가 변경되었을때 보여지는 Period를 변경한다.
     */
    function setPeriod(obj) {    	
    	ComMasSetPeriod1(obj);
    }
    
    /**
     * 
     */
    /*function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        if(sheetObj.ColSavename(col) == "nod_cd"){
            if(sheetObj.CellValue(row,"nod_cd") != ""){
//           	var param = "f_cmd="+COMMAND02;
//         		param = param + "&f_slan_cd="+value;
//				var sXml = sheetObj.GetSearchXml("ESM_MAS_0277GS.do", param);
//				var arrXml = sXml.split("|$$|");
//				isValidSlane(row,ComMasGetEtcData(arrXml[0], "rtnValue"));
				
				formObj.f_cmd.value = COMMAND02;                        
				formObj.nod_cd.value = sheetObj.CellValue(row, "nod_cd");
	        	var sXml = sheetObj.GetSearchXml("ESM_MAS_0277GS.do","",masFormQueryString(formObj),true);
	        	var etcNodNm = ComGetEtcData(sXml, "etcNodNm"); 
	        	var etcCtrlOfcCd = ComGetEtcData(sXml, "etcCtrlOfcCd");        	
	        	sheetObj.CellValue(row, "nod_nm") = etcNodNm;
	        	sheetObj.CellValue(row, "ctrl_ofc_cd") = etcCtrlOfcCd;
            }
        } 
    }*/
    
    /*function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";        
    }*/

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {        
			case IBCLEAR:          //조회				
				formObj.f_year.value   = ComGetNowInfo("yy");
		        formObj.f_fm_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        formObj.f_to_mon.value = ComGetNowInfo("mm").lpad(2, "0");
		        
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				sheetObj.Redraw = false;
				formObj.f_cmd.value = INIT;
				//var sXml = document.form.sXml.value;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0277GS.do", masFormQueryString(formObj));
				//document.form.sXml.value = "";
				//var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key); 
				var arrXml = sXml.split("|$$|");
				formObj.f_fm_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        formObj.f_to_wk.value = ComGetEtcData(arrXml[0], "prevWeek"); 
		        document.getElementById("div_period").innerHTML = "("+ComGetEtcData(arrXml[0], "period") +")";
		        formObj.f_year.value = ComGetEtcData(arrXml[0], "fYear"); 
		        sheetObj.Redraw = true;
		        ComOpenWait(false);
			
				break;

			case IBSEARCH:              //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;                           
                formObj.f_cmd.value = SEARCH; 
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0277GS.do", masFormQueryString(formObj));
                sheetObj.Redraw = true;                                
                ComOpenWait(false);
                
                break;
            
			/*case IBRESET: // RESET
                formObj.f_nod_cd.value = "";
				formObj.f_nod_nm.value = "";
				formObj.f_ctrl_ofc_cd.value = "";
				formObj.chk_office.checked = false;
	    		ComSetObjValue(document.form.f_rdodelflg,"");
	    		sheetObj.RemoveAll();	    		
    			break;*/
                
            case IBSAVE:                //저장            	
            	/*if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }*/
            	sheetObj.Redraw = false;
                ComOpenWait(true);                
                formObj.f_cmd.value = MULTI;                
                sheetObj.DoSave("ESM_MAS_0277GS.do", masFormQueryString(formObj,'f_cmd',true), -1, true);
                
                ComOpenWait(false);
                sheetObj.Redraw = true;
                break;
            
            case IBINSERT:      // 입력
              //sheetObj.DataCopy(); //행복사
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
			  
                break;

            case IBDELETE:      // 입력
            	//sheetObj.RowDelete(sheetObj.SelectRow, false);
            	var checkRow = sheetObj.FindCheckedRow("del_chk");            	
            	var checkRowArr = checkRow.split("|");
            	//alert(checkRowArr);
            	//alert(checkRowArr.length);
 	    		if(checkRow!=null && checkRowArr.length>1){
 	    			for(var i=checkRowArr.length-2;i>-1;i--){	 	    		
	 	    			sheetObj.RowHidden(checkRowArr[i]) = true;	 	    		
	 	    		}
 	    		}            	
                break;
            
            case IBDOWNEXCEL:           //엑셀 다운로드
                //sheetObj.SpeedDown2Excel(-1);
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
             	
        	case IBLOADEXCEL:
        		sheetObj.Redraw = false;
        		ComOpenWait(true);
	        	sheetObj.RemoveAll();	
	        	sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
	        	//EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
//	        	if(EXCEL_LOAD_FLG) {
//	        		ComShowObject(document.getElementById("btn_Rowdelete"),  true);
//	        	}
	        	ComOpenWait(false);
	        	sheetObj.Redraw = true;
				break;	

            case IBCREATE:
            	if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }
            	            	
            	if (!ComShowCodeConfirm("MAS10020")) {
            		return false;
            	}
            	
                ComOpenWait(true);
                sheetObj.Redraw = false;
                
                formObj.f_cmd.value = COMMAND02;                
                sheetObj.DoSearch("ESM_MAS_0277GS.do", FormQueryString(formObj));          
                doActionIBSheet(sheetObj, formObj, IBSEARCH);                 
                sheetObj.Redraw = true;
                break;    
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	//버튼별 체크
        switch (sAction) {
	        case IBSEARCH: // 조회
	        	
	        	
				break;
		
        	case IBSAVE:
	  			if(EXCEL_LOAD_FLG) {
//	  				if(!checkValidationAllData(sheetObj)) {  					
//	  					return false;
//	  				}
	  			}    	  			
				break;
	  	
	  		case IBCREATE:
	  			if ( formObj.f_yrtype[0].checked ) {
	  				ComShowCodeMessage('MAS10003','Creation','YYYY-WW');
	  				return false;
	  			}
				break;
				
	  		case IBDELETE:
	  			if(sheetObj.RowCount < 1) {
	  				return false;
	  			}
				break;
        }
        
        return true;
    }
    
    function frevyrmonInputChange(obj,value,text) {    	
        var formObj = document.form;
        formObj.f_revyrmon.className = "input1";
        formObj.f_fmyearmonth.className = "input";
        formObj.f_toyearmonth.className = "input";
        if (formObj.f_fmyearmonth.value != "" || formObj.f_toyearmonth.value != "") {
	        formObj.f_fmyearmonth.className = "input1";
	        formObj.f_toyearmonth.className = "input1";
        }        
    }   
    
    function fyearmonthInputChange(obj,value,text) {    	
    	var formObj = document.form;
        formObj.f_revyrmon.className = "input";
        formObj.f_fmyearmonth.className = "input1";
        formObj.f_toyearmonth.className = "input1";        
        if (formObj.f_revyrmon.value != "") {
        	formObj.f_revyrmon.className = "input1";
        }
    }
    
    /**
     * sheet1을 더블클릭하여 상세조회한다
     */
     function sheet1_OnDblClick(sheetObj , row, col){
    	 var formObj = document.form;
    	 if ( sheetObj.rowCount != 0 ) {
    		 var fStatus = "";
    		 if ( sheetObj.CellValue(row,"status") == "Finish") {
    			 fStatus = "F";
    		 } else {
    			 fStatus = "U";
    		 }
    		 
    		 var param =  "f_chkprd="+"W" //ComGetObjValue(formObj.f_chkprd)
    		 	+ "&f_year="+sheetObj.CellValue(row,"cost_yrmon").substring(0, 4) //ComGetObjValue(formObj.f_year)
    		 	//+ "&f_fm_mon="+sheetObj.CellValue(row,"cost_yrmon").substring(4, 6) //ComGetObjValue(formObj.f_fm_mon)
    		 	//+ "&f_to_mon="+sheetObj.CellValue(row,"cost_yrmon").substring(4, 6) //ComGetObjValue(formObj.f_to_mon)
    		 	+ "&f_fm_wk="+sheetObj.CellValue(row,"cost_wk") //ComGetObjValue(formObj.f_fm_wk)
    		 	+ "&f_to_wk="+sheetObj.CellValue(row,"cost_wk") //ComGetObjValue(formObj.f_to_wk)    		 	
	            + "&f_status="+fStatus
	            + "&f_c_ofc="+sheetObj.CellValue(row,"ctrt_ofc_cd")
	            + "&f_sc="+sheetObj.CellValue(row,"sc_no")
	            + "&f_rfa="+sheetObj.CellValue(row,"rfa_no")
	            + "&f_por="+sheetObj.CellValue(row,"por_cd")
	            + "&f_del="+sheetObj.CellValue(row,"del_cd")
	            + "&f_tpsz="+sheetObj.CellValue(row,"cntr_tpsz_cd")
	            + "&pop_mode=1";
    		 //alert(param);
    		 ComOpenWindowCenter("/hanjin/ESM_MAS_0279.do?"+param, "ESM_MAS_0279", 1200, 620);
    	 }    	      
	 }
    