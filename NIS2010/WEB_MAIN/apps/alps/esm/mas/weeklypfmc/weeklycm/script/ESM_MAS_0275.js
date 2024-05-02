/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0275.js
*@FileTitle : Chassis Per Diem Upload
*Open Issues :
*@LastModifyDate : 2015-02-06
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-02-06 Je Ryang Yoo
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
	 * @class ESM_MAS_0275 : ESM_MAS_0275 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0275() {
	    this.processButtonClick    = processButtonClick;  
	    this.setYrWk               = setYrWk           ;
	    this.setYrMon              = setYrMon          ;
	    this.fnYearWeekSet         = fnYearWeekSet     ;
	    this.setPeriod             = setPeriod         ;
	    this.loadPage              = loadPage          ;
	    this.initSheet             = initSheet         ;
	    this.setSheetObject        = setSheetObject    ;
	    this.sheet1_OnChange       = sheet1_OnChange   ;
	    this.sheet1_OnSearchEnd    = sheet1_OnSearchEnd;
	    this.doActionIBSheet       = doActionIBSheet   ;
	    this.validateForm          = validateForm      ;
	    this.isValidSlane          = isValidSlane      ;
	    this.isValidRLane          = isValidRLane      ;
	    this.fnYearMonthSet        = fnYearMonthSet    ;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
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
                    break;
                
                case "btn_Save":
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                    
                case "btn_Downexcel":
                    doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
                /*case "btn_New":
                    doActionIBSheet(sheetObject,formObject,IBRESET);
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
     * 입력창에 지정한 주 셋팅
     * 사용 : setYrWk('2013', '25')
     *
     * @param Previous Week's year
     * @param Previous Week
     * @return NONE
     */    
    function setYrWk(fYear,prevWeek){
    	var formObj = document.form;
    	with(formObj){
    		var nowYear = fYear;
            f_yearweek.value = nowYear+prevWeek;	
            //if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
            //if(!ComAddSeparator(f_yearweek)) return false;
            if(!ComChkObjValid(f_yearweek, null, null, "yw")) return false;
    		f_yearweek.select();
    		// 기간 표시     		
            setPeriod(f_yearweek);    		
    	}

        fnYearWeekSet(document.getElementById("f_yearweek"));
    }	
    
    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */        
    function setYrMon(){
    	var formObj = document.form;
    	with(formObj){
            var nowYear = ComGetNowInfo("yy");
            var nowMon  = ComGetNowInfo("mm"); 
            if ( nowMon.length == 1 ) nowMon = "0" + nowMon; // 1월 -> 01월로 변환
    		var nowYrMon = nowYear + nowMon;
            f_yearweek.value = nowYrMon;	
    		//isValidYYYYMM(f_yearweek,true,'-',true);
            if(!ComAddSeparator(f_yearweek)) return false;
    		f_yearweek.select();
    		// 기간 표시 
            setPeriod(f_yearweek);
    	}

        fnYearWeekSet(document.getElementById("f_yearweek"));
    }	

    function fnYearWeekSet(obj){
        if ( document.form.f_yrtype[0].checked ) {
            obj.value = ComGetMaskedValue(obj.value,"ym");
        } else {
            obj.value = ComGetMaskedValue(obj.value,"yw");
        }

        setPeriod(obj);

    }

    /**
	 * month, week가 변경되었을때 Period를 변경한다.
	 */
	function setPeriod(obj){	
        ComMasSetPeriod2(obj);
	}

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
    	loadingMode = true;      	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        loadingMode = false;
        //ComSetFocus(document.form.f_yearmonth);
        ComSetFocus(document.form.f_cntrno);        
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
                    InitRowInfo(1 , 1, 1, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle1  = "|STS|Del.|Pool|SCC|Basic Rate|Tax|Rate|YYYYMM|||";                    
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 9, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false); 
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(0, HeadTitle1, true);    				
                    
                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHidden,       30,     daCenter,   true,       "");
                    InitDataProperty(0,     cnt++,  dtHiddenStatus, 30,     daCenter,   false,      "ibflag");                    
                    //InitDataProperty(0,     cnt++,  dtDataSeq,      30,     daCenter,   true,       "",        	 false,   "",   dfNone,  0,  false, false);
                    InitDataProperty(0,     cnt++ , dtDelCheck,	    40,	    daCenter,	false,		"");
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "pool_cd",       false,   "",   dfNone,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "scc_cd",        false,   "",   dfNone,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "bzc_rt",        false,   "",   dfFloat, 2,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "tax_pct",       false,   "",   dfNone,  0,  true,  true);                    
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "rt_amt",        false,   "",   dfFloat, 2,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,       "cost_yrmon",    false,   "",   dfNone,  0,  true,  true);
                    
                    InitDataProperty(0,     cnt++,  dtHidden,      100,     daCenter,   true,       "pool_cd_org",    false,   "",  dfNone,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtHidden,      100,     daCenter,   true,       "scc_cd_org",     false,   "",  dfNone,  0,  true,  true);                    
                    InitDataProperty(0,     cnt++,  dtHidden,      100,     daCenter,   true,       "cost_yrmon_org", false,   "",  dfNone,  0,  true,  true);
                     	 	 	 	 	                  
                    CountPosition  = 0 ;
                    
                    sheetObj.style.height = 410; //sheetObj.GetSheetHeight(13);                    
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
     * S.Lane code의 유효성 체크
     */
    /*function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        if(sheetObj.ColSavename(col) == "slan_cd"){
            if(sheetObj.CellValue(row,"slan_cd") != ""){
           	 	var param = "f_cmd="+SEARCH02;
         		param = param + "&f_slan_cd="+value;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0275GS.do", param);
				var arrXml = sXml.split("|$$|");
				isValidSlane(row,ComMasGetEtcData(arrXml[0], "rtnValue"));
            }
        } else if(sheetObj.ColSavename(col) == "rlane_cd"){
            if(sheetObj.CellValue(row, "rlane_cd") != ""){
            	var param = "f_cmd="+SEARCH03;
         		param = param + "&f_rlane_cd="+value;
				var sXml = sheetObj.GetSearchXml("ESM_MAS_0275GS.do", param);
				var arrXml = sXml.split("|$$|");
				isValidRLane(row,ComMasGetEtcData(arrXml[0], "rtnValue"));
            }
        }
    }

    function sheet1_OnSearchEnd(sheetObj, errMsg){
        sheetObj.SumText(0,0) = "";
        sheetObj.SumText(0,"cost_yrmon") = "TOTAL";        
    }*/

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {        
			case IBCLEAR:          //조회
				//ComOpenWait(true);
				var sXml = document.form.sXml.value;
				var arrXml = sXml.split("|$$|");
				fYear = ComGetEtcData(arrXml[0], "fYear"); 
				
				/*if (arrXml.length > 0) {
					ComXml2ComboItem(arrXml[0], formObj.f_selslane, "code", "name");
					formObj.f_yrtype[1].onclick = function(){setYrWk(ComGetEtcData(arrXml[0], "fYear"), ComGetEtcData(arrXml[0],"prevWeek"))};
				}
				if (arrXml.length > 1)
					ComXml2ComboItem(arrXml[1], formObj.f_selrlane, "code", "name");
				if (arrXml.length > 2)
					ComXml2ComboItem(arrXml[2], formObj.f_selclass, "code", "name");
				if (arrXml.length > 3)
					ComMasSetIBCombo(sheetObj, arrXml[3], "slan_dir_cd", true, 0);
				if (arrXml.length > 4)
					ComMasSetIBCombo(sheetObj, arrXml[4], "vsl_clss_capa", true, 0);*/				
				document.form.sXml.value = "";
				setYrMon();  // 월/주 입력 창에 금월 셋팅
				break;

			case IBSEARCH:              //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;
                /*if(formObj.f_yrtype[0].checked) {
                	ComAddSeparator(formObj.f_yearweek, "ym");
                } else {
                	ComAddSeparator(formObj.f_yearweek, "yw");
                }*/                
                formObj.f_cmd.value = SEARCH; 
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0275GS.do", masFormQueryString(formObj));
                //sheetObj.DoSearch4Post("ESM_MAS_0275GS.do", masFormQueryString(formObj)); 
                ComOpenWait(false);
                sheetObj.Redraw = true;
                break;
            
			case IBRESET: // RESET				
				//formObj.f_yearmonth.value = "";
				//formObj.t_yearmonth.value = "";
				formObj.f_cntrno.value = "";
				formObj.f_bkgno.value = "";
                sheetObj.RemoveAll(); //sheetObjects[0].reset();
                //loadPage();
    			break;
 
            case IBSAVE:                //저장
                
            	/*if(!validateForm(sheetObj,formObj,sAction)) {
                	return false;
                }*/
            	sheetObj.Redraw = false;
                ComOpenWait(true);                
                formObj.f_cmd.value = MULTI;                
                sheetObj.DoSave("ESM_MAS_0275GS.do", masFormQueryString(formObj,'f_cmd',true), -1, true);
                
                ComOpenWait(false);
                sheetObj.Redraw = true;
                break;
            
            case IBINSERT:      // 입력
              //sheetObj.DataCopy(); //행복사
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
			  //sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "stup_flg") = "0";
			  /*sheetObj.SumText(0,1) = "";
                sheetObj.SumText(0,2) = "Total";*/
                break;

            case IBDELETE:      // 입력
            	sheetObj.RowDelete(sheetObj.SelectRow, false);
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
	        	EXCEL_LOAD_FLG = sheetObj.LoadExcel(-1, 1, "", "-1", "-1", "", false);
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
                sheetObj.DoSearch("ESM_MAS_0275GS.do", FormQueryString(formObj));          
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
//	        	if (formObj.f_cntrno.value == "" && formObj.f_bkgno.value == "") {
//		    		/*if (!ComIsDate(formObj.f_yearmonth.value,"ymd") || !ComIsDate(formObj.t_yearmonth.value,"ymd")) {		    			
//						ComShowMessage("Please enter correct date.\nFormat: Batch Date:yyyymmdd");						
//						formObj.f_yearmonth.focus();
//						return false;
//					}*/
//	        		ComShowMessage("Please enter CNTR No. or BKG No.");	
//	        		formObj.f_cntrno.value = "";
//					formObj.f_bkgno.value = "";
//	                sheetObj.RemoveAll();
//					formObj.f_cntrno.focus();
//					return false;
//	        	}
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
    
    function fnYearMonthSet(obj){
        if ( ComGetMaskedValue(obj.value,"ym") ) {
            
        } else {
        	ComShowMessage("Please enter correct date.\nFormat: yyyymm");
        	document.form.f_yearmonth.value = "";
        	document.form.f_yearmonth.focus();
			return false;			
        }    
    }

    