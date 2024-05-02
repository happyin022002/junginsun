/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_MAS_0006.js
*@FileTitle : Office Role Setup
*Open Issues :
*@LastModifyDate : 2015-03-12
*@LastModifier : Je Ryang Yoo
*@LastVersion :
*  2015-03-12 Je Ryang Yoo
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
	 * @class ESM_MAS_0006 : ESM_MAS_0006 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
	function ESM_MAS_0006() {
	    this.processButtonClick    = processButtonClick;
	    this.loadPage              = loadPage          ;
	    this.initSheet             = initSheet         ;
	    this.setSheetObject        = setSheetObject    ;	    
	    this.doActionIBSheet       = doActionIBSheet   ;
	    this.validateForm          = validateForm      ;
	}

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	/*var comboObjects = new Array();
	var comboCnt = 0;*/
	
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
                    
                case "btn_Rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	        
                case "btn_Rowdelete":
                    doActionIBSheet(sheetObject,formObject,IBDELETE);
                    break;
                    
              /*
				case "btn_New":
                    doActionIBSheet(sheetObject,formObject,IBRESET);
                    break;
                    
                case "btn_Loadexcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
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
    /*function setYrWk(fYear,prevWeek){
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

        //fnYearWeekSet(document.getElementById("f_yearweek"));
    }*/	
    
    /**
     * 입력창에 금월 셋팅
     * 사용 : setYrMon()
     *
     * @param NONE
     * @return NONE
     */        
    /*function setYrMon(){
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

        //fnYearWeekSet(document.getElementById("f_yearweek"));
    }*/	

    /*function fnYearWeekSet(obj){
        if ( document.form.f_yrtype[0].checked ) {
            obj.value = ComGetMaskedValue(obj.value,"ym");
        } else {
            obj.value = ComGetMaskedValue(obj.value,"yw");
        }

        setPeriod(obj);

    }*/

    /**
	 * month, week가 변경되었을때 Period를 변경한다.
	 */
	/*function setPeriod(obj){	
        ComMasSetPeriod2(obj);
	}*/

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
        
        /*for(k=0;k<comboObjects.length;k++){
        	initCombo(comboObjects[k],comboObjects[k].id);
    	}*/
        
        /*for(k=0;k<comboObjects.length;k++){
        	doActionComboSheet(sheetObjects[0], document.form, comboObjects[k]);		
		}*/        
        loadingMode = false;
        ComSetFocus(document.form.f_ofc_cd);                
    }
    
    /**
	 * 멀티콤보 항목을 설정한다.
	 */
 	/*function initCombo(comboObj, comboId) {
 		with (comboObj) {
 			DropHeight = 300;
 			Index = 0;
 			MaxLength = 4;
 			ValidChar(2,1);
 			
 			switch(comboObj.id) {			
				case "ob_sto_flg":
					//InsertItem(0, "", "");
					//InsertItem(1, "Y", "Y");
					//InsertItem(2, "N", "N");
					//DropHeight = 300;
					//ValidChar(2, 1);	//영문대문자+숫자
					//MaxLength = 2;
					//Index = 2;
					DropHeight = 260;
					MultiSelect = false;
					MaxSelect = 1;
					UseAutoComplete = true;

					IMEMode = 0;
					ValidChar(2, 0);
					break;
	
				case "ib_sto_flg":
					InsertItem(0, "", "");
					InsertItem(1, "Y", "Y");
					InsertItem(2, "N", "N");						
					DropHeight = 300;
					MaxLength = 2;
					Index = 2;
					break;
					
				case "mas_uc_flg":
					InsertItem(0, "", "");
					InsertItem(1, "Y", "Y");
					InsertItem(2, "N", "N");
					//comboObj.Index2=0;
					DropHeight = 300;
					MaxLength = 1;
					Index = 1;
					break;
			} 			
 		}
 	}*/
    
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
	/*function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}*/

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
                    InitRowInfo(1 , 1, 2, 100);                         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    
                    var HeadTitle1  = "|STS|Sel|Office|delt_flg|Cre Id|Cre Dt|Upd Id|Upd Dt|||";
                    
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);
                    
                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false); 
                    
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(0, HeadTitle1, true);    				

                    //데이터속성    [ROW,    COL,    DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,   KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT,UPDATEEDIT,INSERTEDIT,EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtHidden,       30,     daCenter,   true,    "");
                    InitDataProperty(0,     cnt++,  dtHiddenStatus,       30,     daCenter,   false,   "ibflag");
                    InitDataProperty(0,     cnt++ , dtDummyCheck,	40,	    daCenter,	false,	 "del_chk");
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "ofc_cd",           false,   "",   dfNone,    0,  true,  true, 6);
                    InitDataProperty(0,     cnt++,  dtHidden,      100,     daCenter,   true,    "delt_flg",         false,   "",   dfNone,    0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "cre_usr_id_sheet", false,   "",   dfNone,    0,  false, false);
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "cre_dt",           false,   "",   dfDateYmd, 0,  false, false);                    
                    InitDataProperty(0,     cnt++,  dtData,        100,     daCenter,   true,    "upd_usr_id_sheet", false,   "",   dfNone,    0,  false, false);
                    InitDataProperty(0,     cnt++,  dtData,   	   100,     daCenter,   true,    "upd_dt",           false,   "",   dfDateYmd, 0,  false, false);
                                            
                    InitDataProperty(0,     cnt++,  dtHidden,       50,     daCenter,   true,    "ofc_cd_org",       false,   "",  dfNone,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtHidden,       50,     daCenter,   true,    "cre_usr_id_org",   false,   "",  dfNone,  0,  true,  true);
                    InitDataProperty(0,     cnt++,  dtHidden,       50,     daCenter,   true,    "upd_usr_id_org",   false,   "",  dfNone,  0,  true,  true);
                    
                    InitDataValid(0, "ofc_cd",    vtEngUpOnly);
                    
                    CountPosition = 0;
                    
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
     * 
     */
    /*function sheet1_OnChange(sheetObj, row, col, value){
        var formObj = document.form;
        
        if(sheetObj.ColSavename(col) == "nod_cd"){
            if(sheetObj.CellValue(row,"nod_cd") != ""){
//           	var param = "f_cmd="+COMMAND02;
//         		param = param + "&f_slan_cd="+value;
//				var sXml = sheetObj.GetSearchXml("ESM_MAS_0006GS.do", param);
//				var arrXml = sXml.split("|$$|");
//				isValidSlane(row,ComMasGetEtcData(arrXml[0], "rtnValue"));
				
				formObj.f_cmd.value = COMMAND02;                        
				formObj.nod_cd.value = sheetObj.CellValue(row, "nod_cd");
	        	var sXml = sheetObj.GetSearchXml("ESM_MAS_0006GS.do","",masFormQueryString(formObj),true);
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
			/*case IBCLEAR:          //조회
				//ComOpenWait(true);
				var sXml = document.form.sXml.value;
				var arrXml = sXml.split("|$$|");
				fYear = ComGetEtcData(arrXml[0], "fYear"); 
				
				if (arrXml.length > 0) {
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
					ComMasSetIBCombo(sheetObj, arrXml[4], "vsl_clss_capa", true, 0);				
				document.form.sXml.value = "";
				setYrMon();  // 월/주 입력 창에 금월 셋팅
				break;*/

			case IBSEARCH:              //조회
                if(!validateForm(sheetObj,formObj,sAction)) return false;
                // 업무처리중 버튼사용 금지 처리
                ComOpenWait(true);
                sheetObj.Redraw = false;                           
                formObj.f_cmd.value = SEARCH; 
                //alert(masFormQueryString(formObj));
                sheetObj.DoSearch("ESM_MAS_0006GS.do", masFormQueryString(formObj));                 
                ComOpenWait(false);
                sheetObj.Redraw = true;                                
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
                sheetObj.DoSave("ESM_MAS_0006GS.do", masFormQueryString(formObj,'f_cmd',true), -1, true);
                
                ComOpenWait(false);
                sheetObj.Redraw = true;
                break;
            
            case IBINSERT:      // 입력
              //sheetObj.DataCopy(); //행복사
				sheetObj.DataInsert(-1); // 마지막행에 행삽입
			  //sheetObj.CellValue2(sheetObj.LastRow, "mas_uc_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "delt_flg") = "N";
			  //sheetObj.CellValue2(sheetObj.LastRow, "stup_flg") = "0";
			  /*sheetObj.SumText(0,1) = "";
                sheetObj.SumText(0,2) = "Total";*/
                break;

            case IBDELETE:      // 입력
            	//sheetObj.RowDelete(sheetObj.SelectRow, false);
            	ComRowHideDelete(sheetObj, "del_chk");
//            	var checkRow = sheetObj.FindCheckedRow("del_chk");            	
//            	var checkRowArr = checkRow.split("|");
//            	//alert(checkRowArr);            	
// 	    		if(checkRow!=null && checkRowArr.length>1){
// 	    			for(var i=checkRowArr.length-2;i>-1;i--){
//	 	    			//alert(i);
// 	    				//alert(checkRowArr[i]);
//	 	    			sheetObj.RowHidden(checkRowArr[i]) = true;	 	    			
//	 	    			//sheetObj.CellValue2(checkRowArr[i],"del_chk") = "D";
//	 	    		}
////	 	    		for(var i=0;i<checkRowArr.length-1;i++){
////	 	    			alert(checkRowArr[i]);
////	 	    			sheetObj.RowDelete(checkRowArr[i], false);
////	 	    			/*if(checkRowArr[i]!=Row){
////	 	    				sheetObjects[0].CellValue2(checkRowArr[i],"del_chk") = 0;
////	 	    			}*/
////	 	    		}
// 	    		}            	
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
                sheetObj.DoSearch("ESM_MAS_0006GS.do", FormQueryString(formObj));          
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
	        	/*if (formObj.f_cntrno.value == "" && formObj.f_bkgno.value == "") {
	        		if (formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value == "") {
	        			ComShowCodeMessage('MAS10002','Off Hire Date, or input BKG NO. / CNTR No.');	        			
						return false;
	        		} else if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value == "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Off Hire Date:yyyymmdd ~ yyyymmdd');
						return false;
	        		} else if (formObj.f_fmyearmonth.value == "" && formObj.f_toyearmonth.value != "") {
	        			ComShowCodeMessage('MAS10002','correct date.\nFormat: Off Hire Date:yyyymmdd ~ yyyymmdd');
	        			return false;
	        		} else if (formObj.f_fmyearmonth.value != "" && formObj.f_toyearmonth.value != "") {
	        			if (!ComIsDate(formObj.f_fmyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_fmyearmonth.value = "";
	        				return false;
	        			} else if (!ComIsDate(formObj.f_toyearmonth.value,"ymd")) {
	        				ComShowCodeMessage('MAS10002','correct date.\nFormat: yyyymmdd');
	        				formObj.f_toyearmonth.value = "";
	        				return false;
	        			}
	        		}
	        	}*/
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
    
    /*function fnYearMonthSet(obj){
        if ( ComGetMaskedValue(obj.value,"ym") ) {
            
        } else {
        	ComShowMessage("Please enter correct date.\nFormat: Batch Date:yyyymm");
			return false;			
        }    
    }*/
    
    //Include Check Bok를 Click했을 때
    /*function fun_chkOffice() {
    	
    	var doc_office = document.form.chk_office;
    	var formObj = document.form;
    	var prm_office = doSepRemove(document.form.f_ctrl_ofc_cd.value.toUpperCase(), " ");
        
    	if(doc_office.checked == true){
    		document.form.incl_sub_ofc_flg.value="Y";
    		document.form.old_ofc_cd.value = document.form.f_ctrl_ofc_cd.value;
    	}else{
    		document.form.incl_sub_ofc_flg.value="N";
    		document.form.old_ofc_cd.value = "";
    	}
    	
    	if( prm_office == "" ) {
    		doc_office.checked = false;
    		document.form.f_ctrl_ofc_cd.value = "";
    		ComShowMessage("Please input the 'Control Office'!!" );
    		return false;
    	}
    	
        if( doc_office.checked == true ) {
        	formObj.f_cmd.value = COMMAND01;                        
        	var sXml = sheetObjects[0].GetSearchXml("ESM_MAS_0006GS.do","",masFormQueryString(formObj),true);
            var arrResult = XmlToArray(sXml);
            
            if(typeof arrResult=="undefined"){
            	return false;
            }else{
            	formObj.f_ctrl_ofc_cd.value=arrResult;
            }            
    	} else {
    		document.form.f_ctrl_ofc_cd.value = "";
    	}        
    }*/
    
    /*function doSepRemove(obj, sep) {
    	var ch = "";
    	var lvobj = "";
    	for(var i=0; i<obj.length; i++) {
    		if(obj.charAt(i) == sep) {
    			ch = "";
    		} else {
    			ch = obj.charAt(i);
    		}
    		lvobj = lvobj + ch;
    	}
    	return lvobj;
    }*/
    
    /*function XmlToArray(xmlStr) {
    	var rtnArr = new Array();

    	if (xmlStr == null || xmlStr == "") {
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

    		var retStr = "";

    		for ( var i = 0; i < dataChildNodes.length; i++) {
    			if (dataChildNodes[i].nodeType != 1) {
    				continue;
    			}
    			var arrData = dataChildNodes[i].firstChild.nodeValue.split(sep).join("");
    			rtnArr.push(arrData);
    		}
    	} catch (err) {
    		ComFuncErrMsg(err.message);
    	}

    	return rtnArr;
    }*/
    
       
 