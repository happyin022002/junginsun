/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0157.js
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이연각
*@LastVersion : 1.0
* 2009.09.18 장영석
* 1.0 Creation
*=========================================================
* History
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
*=========================================================*/
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
     * @class ESM_MAS_0157 : ESM_MAS_0157 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_MAS_0157() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.sheet1_OnChange        = sheet1_OnChange;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.f_loc_cd_OnChange   	= f_loc_cd_OnChange;
    	this.divideCheckZero     	= divideCheckZero;
    	this.validateForm 			= validateForm;
    }

 // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
    var sheet_height = 20; // sheet의 height
    var comboObjects = new Array();
    var comboCnt = 0;
    var loadingMode = false;
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

    				case "btn_Retrieve":
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;

    				case "btn_DownExcel":
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    					break;

    				case "btng_Save":
    					doActionIBSheet(sheetObject,formObject,IBSAVE);
    					break;

    			    case "btng_RowAdd":
        				doActionIBSheet(sheetObject,formObject,IBINSERT);
        			    break;
                    case "btn_Month_Copy":
                        doActionIBSheet(sheetObject,formObject,MULTI02);
                        break;                  

                    case "btng_RowDel":// 행삭제
                        doActionIBSheet(sheetObject,formObject,IBDELETE);
                        break;      

        			case "bu_zoom_in":
    				    if(sheetObject.Rows>17){
    					   sheetObject.style.height = sheetObject.GetSheetHeight(sheetObject.Rows);
    					   div_zoom_out.style.display = "inline";
    					   div_zoom_in.style.display = "none";
    					   parent.syncHeight();
    				    }
        				break;

        			case "bu_zoom_out":
        				if(sheetObject.Rows>17){
        					sheetObject.style.height = sheetObject.GetSheetHeight(17);
        					div_zoom_in.style.display = "inline";
        					div_zoom_out.style.display = "none";
        					parent.syncHeight();
        				}
        				break;
    			} // end switch
    		}catch(e) {
    			if( e == "[object Error]") {
    				ComShowCodeMessage(OBJECT_ERROR);
    			} else {
    			ComShowMessage(e);
    			}
    		}
    	}
    	/**
         * IBCombo Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setComboObject(combo_obj){
            comboObjects[comboCnt++] = combo_obj;
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
    		var formObj = document.form;
    		if( formObj.v_ofc_cd.value != "SELCSG" && formObj.v_ofc_cd.value != "SELAPM"){
    			ComSetDisplay("btn_control",false);    			
    		}
    		
    		for(i=0;i<sheetObjects.length;i++){
    			//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);
    			initSheet(sheetObjects[i],i+1);
    			//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		loadingMode = true;
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
            for(k=0;k<comboObjects.length;k++){
                initCombo(comboObjects[k],comboObjects[k].id);
            }
            
            loadingMode = false;
    	}
    	/**
         * 멀티콤보 항목을 설정한다.
         */
         function initCombo(comboObj, comboId) {
        	 with (comboObj) {
                MaxLength = 5;
                ValidChar(2, 1);
                IMEMode = 0;
                DropHeight = 300;
                Index = 0;

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
    			case 1:	//sheet2 init
    				with (sheetObj) {
    					SheetWidth = mainTable.clientWidth;//전체 너비 설정
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);//Host정보 설정[필수][HostIp, Port, PagePath]
    					MergeSheet = msHeaderOnly;//전체Merge 종류 [선택, Default msNone]
    					Editable = true;//전체Edit 허용 여부 [선택, Default false]
    					InitRowInfo( 1, 1, 9, 100);//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitColumnInfo(13, 3, 0, true);//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitHeadMode(true, false, false, true, false,false)//([SortEnable], [ColumnMove], [AllCheckEnable],[UserResize], [RowMove],[Head3D])

    					var HeadTitle = "Del.|STS||YYYY-MM|Location|Location|배부기준|SO Code|SO Code|UOM|Total AMT|QTY|Per Unit" ;
    					InitHeadRow(0, HeadTitle, true);//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]

    					//데이터속성	    [ROW, COL,	 DATATYPE,	 WIDTH, DATAALIGN,  COLMERGE, SAVENAME,	            KEYFIELD, CALCULOGIC, DATAFORMAT,   POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,   cnt++, dtDelCheck, 30,	daCenter,	false,	  "");
    					InitDataProperty(0,   cnt++, dtStatus,	 30,	daCenter,	false,	  "ibflag");
    	                   InitDataProperty(0, cnt++, dtDummyCheck,    40,  daCenter, false, "chk");

    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "cost_yrmon",         true,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "comm_loc_cd",        true,	  "",	      dfNone,		0,	        false,	    true,    5);
                        InitDataProperty(0,   cnt++, dtData,     80,    daCenter,   false,    "comm_loc_nm",        true,     "",         dfNone,       0,          false,      true,    5);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "div_stnd", false,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 80,	daCenter,	false,	  "mas_cost_src_cd_nm", false,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtCombo,	 80,	daCenter,	false,	  "mas_cost_src_cd",    true,	  "",	      dfNone,		0,	        false,	    true,6);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daCenter,	false,	  "cntr_tpsz_cd",		true,	  "",	      dfNone,		0,	        false,	    false);
    					InitDataProperty(0,   cnt++, dtData,	 100,	daRight,	false,	  "otr_comm_ttl_amt",	false,	  "",	      dfFloatOrg,	2,	        true,	    true);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daRight,	false,	  "bkg_ttl_qty",		false,	  "",	      dfInteger,	0,	        true,	    true);
    					InitDataProperty(0,   cnt++, dtData,	 70,	daRight,	false,	  "stnd_cost_usd_amt",	false,	  "",	      dfFloatOrg,	2,	        false,	    false);

    					// 영문자 또는 숫자만 입력
    					InitDataValid(0, "comm_loc_cd", vtEngUpOther, "1234567890");

    					CountPosition	= 0 ;
    					style.height = GetSheetHeight(sheet_height) ;
    	                ColHidden("chk") =true;
    	                InitDataCombo(0,"mas_cost_src_cd", " |512691\tOthers|512692\tOthers1|512693\tOthers2", " |512691|512692|512693","","");
    	                InitDataValid(0, "comm_loc_nm", vtEngUpOnly);
//'512691', 'Location', '512692', 'Country', '512693', 'Common'
    				}
    				break;
    		}
    	}


    	function sheet1_OnChange(sheetObj, Row,Col, Value) {
    		var sName = sheetObj.ColSaveName(Col);
            var sValue = sheetObj.CellValue(Row,Col);
            var formObj = document.form;

    		if ( sName == "bkg_ttl_qty") {
    		    sheetObj.CellValue2(Row, "stnd_cost_usd_amt") = divideCheckZero(sheetObj.CellValue(Row,"otr_comm_ttl_amt") , Value);
    		} else if( sName == "otr_comm_ttl_amt"){
    		    sheetObj.CellValue2(Row, "stnd_cost_usd_amt") = divideCheckZero(Value, sheetObj.CellValue(Row, "bkg_ttl_qty"));
            } else if( sName == "mas_cost_src_cd"){
                if( sValue == "512691"){
                    sheetObj.CellValue2(Row,"mas_cost_src_cd_nm")="Others";
                    sheetObj.CellValue2(Row,"div_stnd")="Location";
                    sheetObj.CellEditable(Row,"comm_loc_cd")=true;
                    sheetObj.CellEditable(Row,"comm_loc_nm")=true;
                    if(sheetObj.CellValue(Row,"comm_loc_cd").length != 5 ){
                        sheetObj.CellValue2(Row,"comm_loc_nm")="";      
                        sheetObj.CellValue2(Row,"comm_loc_cd")="";                            
                    }
                }else if( sValue == "512692"){
                    sheetObj.CellValue2(Row,"mas_cost_src_cd_nm")="Others1";
                    sheetObj.CellValue2(Row,"div_stnd")="Country";   
                    sheetObj.CellEditable(Row,"comm_loc_cd")=true;
                    sheetObj.CellEditable(Row,"comm_loc_nm")=true;
                    if(sheetObj.CellValue(Row,"comm_loc_cd").length != 2 ){
                        sheetObj.CellValue2(Row,"comm_loc_nm")="";      
                        sheetObj.CellValue2(Row,"comm_loc_cd")="";                            
                    }
                }else if( sValue == "512693"){
                    sheetObj.CellValue2(Row,"mas_cost_src_cd_nm")="Others2";
                    sheetObj.CellValue2(Row,"div_stnd")="Common";   
                    sheetObj.CellValue2(Row,"comm_loc_nm")="Common";      
                    sheetObj.CellValue2(Row,"comm_loc_cd")="XXX";      
                    sheetObj.CellEditable(Row,"comm_loc_cd")=false;
                    sheetObj.CellEditable(Row,"comm_loc_nm")=false;
                    
                }else{
                    sheetObj.CellValue2(Row,"mas_cost_src_cd_nm")="";
                    sheetObj.CellValue2(Row,"div_stnd")="";
                    sheetObj.CellEditable(Row,"comm_loc_cd")=true;
                    sheetObj.CellEditable(Row,"comm_loc_nm")=true;
                    sheetObj.CellValue2(Row,"comm_loc_nm")="";      
                    sheetObj.CellValue2(Row,"comm_loc_cd")="";   
                }
            } else if( sName == "comm_loc_nm"){
                var locCd = sheetObj.CellValue(Row,"comm_loc_nm");
                var sValue = sheetObj.CellValue(Row,"mas_cost_src_cd");
                 
                if( sValue == "512691"){//location
                    
                    formObj.f_cmd.value = SEARCH07;
                    var param = "&f_type_cd=LOC_CD&nm=proposal" + "&f_loc_cd=" + locCd  ;
                    var sXml = sheetObj.GetSearchXml("MasCommonUtilGS.do", masFormQueryString(formObj) + param);
                    var returnValue = ComGetEtcData(sXml, "rtnValue");
                    if( returnValue != "true"){
                        locCd = "";
                        sheetObj.CellValue2(Row,"comm_loc_nm") ="";
                        
                    }
                }else if( sValue == "512692"){//country
                    formObj.f_cmd.value = SEARCH09;
                    var param = "&f_type_cd=CNT_CD&nm=proposal" + "&f_loc_cd=" + locCd  ;
                    var sXml = sheetObj.GetSearchXml("MasCommonUtilGS.do", masFormQueryString(formObj) + param);
                    var returnValue = ComGetEtcData(sXml, "rtnValue");
                    if( returnValue != "true"){
                        locCd = "";
                        sheetObj.CellValue2(Row,"comm_loc_nm") ="";
                        
                    }
 
                }else if ( sValue == ""){
                    locCd = "";
                    sheetObj.CellValue2(Row,"comm_loc_nm") ="";
                }

                
                sheetObj.CellValue2(Row,"comm_loc_cd") = locCd;

    		}
    	}

    	// Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {
    			case IBCLEAR:          //조회
			        sheetObj.WaitImageVisible = false;
					ComOpenWait(true);
					formObj.f_cmd.value = INIT;
					var sXml = sheetObj.GetSearchXml("ESM_MAS_0157GS.do", masFormQueryString(formObj));

					var arrXml = sXml.split("|$$|");
					if (arrXml.length > 0)
						ComXml2ComboItem(arrXml[0], formObj.f_comm_loc_cd, "code", "code");

					ComOpenWait(false);
					break
    			case IBSEARCH:	//조회
    				if(validateForm(sheetObj,formObj,sAction)){
    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = SEARCH;
    					sheetObj.DoSearch4Post("ESM_MAS_0157GS.do", masFormQueryString(formObj));
    					ComOpenWait(false);
    				}
    				break;

    			case IBSAVE:	//저장
    				if(validateForm(sheetObj,formObj,sAction)){
    				    
    				    
                        //삭제된 행을 제외하고 중복된 행을 찾는다.
                        var rowM = sheetObj.ColValueDup("cost_yrmon|comm_loc_cd|cntr_tpsz_cd|mas_cost_src_cd", false);
                       
                         if (rowM >= 0) {
                             ComShowMessage(ComGetMsg("MAS00015","Row "+rowM));
                             return false;
                        }
                        //필수 입력 체크
                        var sRow = sheetObj.FindStatusRow("I|U");
                        //받은 결과를 배열로 생성한다.
                        var arrRow = sRow.split(";");
                        for (idx=0; idx<arrRow.length-1; idx++){
                            if(sheetObj.CellValue(arrRow[idx],"mas_cost_src_cd") == ""){
                                ComShowMessage(ComGetMsg("MAS00013","SO Code"));
                                return false;
                            }
                             if(sheetObj.CellValue(arrRow[idx],"cost_yrmon") == ""){
                                ComShowMessage(ComGetMsg("MAS00013","Cost YRMON"));
                                return false;
                            }   
                            if(sheetObj.CellValue(arrRow[idx],"comm_loc_cd") == ""){
                                ComShowMessage(ComGetMsg("MAS00013","Location"));
                                return false;
                            }

                            if(sheetObj.CellValue(arrRow[idx],"otr_comm_ttl_amt") == "" || sheetObj.CellValue(arrRow[idx],"otr_comm_ttl_amt") == "0"){
                                ComShowMessage(ComGetMsg("MAS00013","Total AMT"));
                                return false;
                            }  
                            if(sheetObj.CellValue(arrRow[idx],"bkg_ttl_qty") == "" || sheetObj.CellValue(arrRow[idx],"bkg_ttl_qty") == "0"){
                                ComShowMessage(ComGetMsg("MAS00013","QTY"));
                                return false;
                            }  
                        }
     

    					// 업무처리중 버튼사용 금지 처리
    					sheetObj.WaitImageVisible = false;
    					ComOpenWait(true);
    					formObj.f_cmd.value = MULTI;
	    				sheetObj.DoSave("ESM_MAS_0157GS.do", masFormQueryString(formObj));
	    				ComOpenWait(false);
    				}
    				break;

    			case IBINSERT:	//행 추가
    			    if(formObj.f_cost_yrmon.value == "") {
    			        ComShowCodeMessage('MAS10039');
    			    } else {
        				var row = sheetObj.DataInsert(-1);
        				if(row > 1) {
        				    sheetObj.CellValue2(row, "cost_yrmon") = sheetObj.CellValue(row-1, "cost_yrmon");
        				} else {
        				    sheetObj.CellValue2(row, "cost_yrmon") = formObj.f_cost_yrmon.value.replace("-","");
        			    }
        			    sheetObj.CellValue2(row, "cntr_tpsz_cd") = "TEU";
    			    }
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
                case IBDELETE:                  // 행삭제
                    //sheetObj.RowDelete(sheetObj.SelectRow, false);
                    deleteRowCheck(sheetObj, "chk" ,true);  
                    break;
                case MULTI02:      //팝업창(Month Copy)
                    var display = "0,1";
                    ComOpenPopup("ESM_MAS_0173.do?classId=ESM_MAS_0157&check_cnt=Y", 250, 200, "Agent Other Commission Inquiry (PA/RA)", display, true, false);

                    break;
    		}
    	}

       	function f_comm_loc_cd_OnChange(obj) {
    	    sheetObjects[0].RemoveAll();
    	}

        function divideCheckZero(vNum, vDen) {
            var vRtn = 0;

            if(parseFloat(vDen) == 0) {
                vRtn = 0;
            } else {
                vRtn = parseFloat(vNum) / parseFloat(vDen);
            }

            return vRtn;
        }

    	/**
    	* 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	*/
    	function validateForm(sheetObj,formObj,sAction){
    		var rt = false;
    		with(formObj){
    			if(!isValidYYYYMM(formObj.f_cost_yrmon , false, '-', false)){
    			} else {
    				rt = true;
    			}
    		}
    		return rt;
    	}
