/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_2001_12.js
*@FileTitle : Guideline Creation - Arbitrary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.07.14 김재연
* 1.0 Creation
=========================================================
* History
* 2011.12.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 중 숫자를 포함한 Code 를 조회, 입력 등 모든 부분에서 가능하도록 수정
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
     * @class ESM_PRI_2001_12 : ESM_PRI_2001_12 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_2001_12() {
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
    var enableFlag = true;
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
     * <br><b>Example :</b>
     * <pre>
     *     processButtonClick();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function processButtonClick(){
    	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    	var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];

        var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");
    		if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
            	if (getButtonTable(srcName).disabled) {
            		return false;
            	}
            }
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
					
				case "btn_downexcel":
					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					break;

				case "btn_loadexcel":
					doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
					break; 

				case "btn_rowadd":
					doActionIBSheet(sheetObject1,formObject,IBINSERT);
					break;
					
				case "btn_rowcopy":
					doActionIBSheet(sheetObject1,formObject,IBCOPYROW);
					break;

				case "btn_delete":
					doActionIBSheet(sheetObject1,formObject,IBDELETE);
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
     * IBSheet Object를 배열로 등록 <br>
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다 <br>
     * 배열은 소스 상단에 정의 <br>
     * <br><b>Example :</b>
     * <pre>
     *     setSheetObject(sheetObj);
     * </pre>
     * @param {ibsheet} sheet_obj 필수 IBSheet Object
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }

    /**
     * Sheet 기본 설정 및 초기화 <br>
     * body 태그의 onLoad 이벤트핸들러 구현 <br>
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다. <br>
     * <br><b>Example :</b>
     * <pre>
     *     loadPage();
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
        	//khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
            
        	//khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        pageOnLoadFinish();
    }

    /**
     * 시트 초기설정값, 헤더 정의 <br>
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 <br>
     * <br><b>Example :</b>
     * <pre>
     *     initSheet(sheetObj,1);
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} sheetNo 필수 IBSheet Object 태그의 아이디에 붙인 일련번호
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function initSheet(sheetObj,sheetNo) {
    	 
        var cnt = 0;
        var sheetID = sheetObj.id;
        
        switch(sheetID) {
        
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
					style.height = 308;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msNone;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					var HeadTitle = "|Sel.|Seq.|Point|Description|Term|Base Port|Trans Mode|Per|Cargo Type|Cur.|Rate|fic_gline_rt_amt|Diff|Weight\n(Ton <=)|Weight\n(<Ton )|||||||EFFDT|base_port_list|optm_trsp_mod_flg|fic_rout_cmb_tp_cd|fic_rt_use_sts_cd|fic_gline_upd_dt";
					var headCount = ComCountHeadTitle(HeadTitle);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false); 
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++, dtHiddenStatus,	40,		daCenter,  	false,	"ibflag");
					
					InitDataProperty(0, cnt++, dtDummyCheck,    40,		daCenter,  	false,  "chk");                    
					InitDataProperty(0, cnt++, dtDataSeq,    	30, 	daCenter,  	true,   "Seq");
					InitDataProperty(0, cnt++, dtPopupEdit,  	60,   	daCenter,  	false,  "rout_pnt_loc_def_cd",  true,	"",	dfEngUpKey, 	0,	true,	true,	5,	true);
    				InitDataProperty(0, cnt++, dtData,    		130,  	daLeft,	 	false,  "loc_des",  false,  "", dfNone, 		0,  false,  false,	30);
                    InitDataProperty(0, cnt++, dtCombo,         70,     daCenter,   false,  "rcv_de_term_cd",       true,   "", dfEngUpKey,     0,  true,   true);
                    InitDataProperty(0, cnt++, dtComboEdit,     80,     daCenter,   false,  "bse_port_def_cd",      true,   "", dfNone,         0,  true,   true,   5);
                    InitDataProperty(0, cnt++, dtCombo,         90,     daCenter,   false,  "prc_trsp_mod_cd",      true,  "", dfEngUpKey,     0,  true,   true);
                    InitDataProperty(0, cnt++, dtCombo,         70,     daCenter,   false,  "rat_ut_cd",            true,   "", dfNone,         0,  true,   true);
                    InitDataProperty(0, cnt++, dtCombo,         90,     daCenter,   false,  "prc_cgo_tp_cd",        true,  "", dfNone,         0,  true,   true);
                    InitDataProperty(0, cnt++, dtCombo,         70,     daCenter,   false,  "curr_cd",              true,   "", dfNone,         0,  true,   true);
                    InitDataProperty(0, cnt++, dtData,          80,     daRight,    true,   "frt_rt_amt",           true,   "", dfFloat,        2,  true,   true,   9);
                    InitDataProperty(0, cnt++, dtHidden,        68, daRight,    false,  "fic_gline_rt_amt",     false,  "", dfFloat,        2,  true,   true,   9);
                    InitDataProperty(0, cnt++, dtData,          68, daRight,    false,  "diff_with_gl",         false,  "", dfNone,         2,  false,  false,  9);

                    
    				InitDataProperty(0, cnt++, dtData,      	80,    	daCenter,  	true,   "min_cgo_wgt",    	 	false,  "", dfNullFloat,	2,  true,   true,	4);
					InitDataProperty(0, cnt++, dtData,      	80,    	daCenter,  	true,   "max_cgo_wgt",      	false,  "", dfNullFloat, 	2,  true,   true,	4);
					
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"svc_scp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"gline_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,		"org_dest_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,    	"arb_seq");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "rout_pnt_loc_tp_cd");
    				InitDataProperty(0, cnt++, dtHidden, 		30,   daCenter,  false,     "bse_port_tp_cd");
    				

                    InitDataProperty(0, cnt++, dtHidden,          80, daCenter,   false,  "eff_dt",               false,  "", dfDateYmd,      0,  false,  false);
                    InitDataProperty(0, cnt++, dtHidden,        30, daCenter,  false,   "base_port_list");
                    InitDataProperty(0, cnt++, dtHidden,        30, daCenter,  false,   "optm_trsp_mod_flg");
                    InitDataProperty(0, cnt++, dtHidden,        30, daCenter,  false,   "fic_rout_cmb_tp_cd");
                    InitDataProperty(0, cnt++, dtHidden,        30, daCenter,  false,   "fic_rt_use_sts_cd");
                    InitDataProperty(0, cnt++, dtHidden,        30, daCenter,  false,   "fic_gline_upd_dt");

    				
    				//2011.03.15 이행지 [CHM-201109281-01] ALPS의 Location 조회불가건 수정 보완 요청 - Location Code 영문대문자,숫자 입력가능하도록 수정					
 					InitDataValid(0, "rout_pnt_loc_def_cd", vtEngUpOther, "0123456789");        // 영문대문자,숫자만 입력 
 					InitDataValid(0, "bse_port_def_cd",	vtEngUpOther, "1234567890");// 영문대문자와 숫자입력
    				
    				InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);
    				InitDataCombo(0, "rat_ut_cd", ratUtCdText, ratUtCdValue);
    				InitDataCombo(0, "curr_cd", currCdText, currCdValue, "USD");
    				InitDataCombo(0, "prc_cgo_tp_cd", prcCgoTpCdText, prcCgoTpCdValue);
    				
    				AutoRowHeight = false;
    				WaitImageVisible = false;
				}
				break;
				
	            case "sheet2":
	            	with (sheetObj) {
	                    
	                    //Host정보 설정[필수][HostIp, Port, PagePath]
	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                    InitRowInfo( 1, 1, 3, 100);

	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                    InitColumnInfo(1, 0, 0, true);

	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, "", true);

	                }
					break;
        }
    }

    /**
     * Sheet관련 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     doActionIBSheet(sheetObj, document.form, IBSEARCH)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        
        	case IBSEARCH:      //조회
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
              	}
	        	formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch("ESM_PRI_2001_12GS.do", FormQueryString(formObj));
				ComOpenWait(false);
           		break;
        	
        	case IBSEARCH_ASYNC01: // radio button select
	 			//var firstCheck = false;
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2001_12GS.do" , FormQueryString(formObj));
			
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				var obj = document.form;
				
				if (parseInt(arrData[0][1]) > 0) {
					formObj.org_dest_tp_cd[0].checked = true;
				} else if(parseInt(arrData[1][1]) > 0) {
					formObj.org_dest_tp_cd[1].checked = true;
				}
				break;
			
        	case IBSEARCH_ASYNC02: // Font Style
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchXml("ESM_PRI_2001_12GS.do" , FormQueryString(formObj));
				var arrData = ComPriXml2Array(sXml, "typecd|typecount");
				
				if (parseInt(arrData[0][1]) > 0) {
					document.getElementById("org_dest_tp_cd1").style.fontWeight = "bold";
				} else {
					document.getElementById("org_dest_tp_cd1").style.fontWeight = "";
				}
				
				if(parseInt(arrData[1][1]) > 0) {
					document.getElementById("org_dest_tp_cd2").style.fontWeight = "bold";
				} else {
					document.getElementById("org_dest_tp_cd2").style.fontWeight = "";
				}
				break;		
				
        	case IBSEARCH_ASYNC03:
				formObj.f_cmd.value = SEARCH19;
				if(ComGetObjValue(formObj.org_dest_tp_cd) == 'O') {
					formObj.cd.value="CD02070";
				} else {
					formObj.cd.value="CD02071";
				}
				sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
				setIBCombo(sheetObjects[0],sXml,"rcv_de_term_cd",true,0);
				break;
				
        	case IBSAVE:
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
            	}
            		
           		formObj.f_cmd.value = MULTI;			
				var sParam = FormQueryString(formObj);
				
 				var sParamSheet = sheetObj.GetSaveString(false);
 				var sXml = sheetObj.GetSaveXml("ESM_PRI_2001_12GS.do", sParam+"&"+sParamSheet);
 				sheetObj.LoadSaveXml(sXml);
 				ComOpenWait(false);
                break;
            
        	case MODIFY01:
        		ComOpenWait(true);
        		if(!validateForm(sheetObj,formObj,sAction)) {
        			ComOpenWait(false);
        			return false;
	        	}
	
	       		formObj.f_cmd.value = MULTI;
				var sParamSheet = sheetObj.GetSaveString()+"&f_cmd="+MULTI;
				var sXml = sheetObj.GetSaveXml("ESM_PRI_2001_12GS.do", sParamSheet);
				sheetObj.LoadSaveXml(sXml);
				ComOpenWait(false);
	            break;
            
        	case IBDOWNEXCEL:
				//sheetObj.Down2Excel(-1);
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "chk|seq");
				break;
			
        	case IBLOADEXCEL:
	        	if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
        
				var svcScpCd = formObj.svc_scp_cd.value;
				var glineSeq = formObj.gline_seq.value;
				var ordDestTpCd = ComGetObjValue(formObj.org_dest_tp_cd);
				var sParam = "svc_scp_cd="+svcScpCd+"&gline_seq="+glineSeq+"&org_dest_tp_cd="+ordDestTpCd;		
				var str = ComPriOpenWindowCenter("/hanjin/ESM_PRI_2048.do?"+sParam, "", getWidth(850), getHeight(425), true);
			
				break;
			
			case IBINSERT:      // 입력
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
			
				var idx = sheetObj.DataInsert();
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
				sheetObj.CellValue(idx, "org_dest_tp_cd") = ComGetObjValue(formObj.org_dest_tp_cd);
				sheetObj.CellValue(idx, "arb_seq") = parseInt(ComPriGetMax(sheetObj, "arb_seq")) + 1;
                sheetObj.CellValue(idx, "eff_dt") = formObj.eff_dt.value;
                sheetObj.CellValue(idx, "prc_cgo_tp_cd") = "DR";
                sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");

				break;
				
			case IBCOPYROW:      // Row Copy
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
			
				var idx = sheetObj.DataCopy();
				sheetObj.CellValue(idx, "svc_scp_cd") = formObj.svc_scp_cd.value;
				sheetObj.CellValue(idx, "gline_seq") = formObj.gline_seq.value;
				sheetObj.CellValue(idx, "org_dest_tp_cd") = ComGetObjValue(formObj.org_dest_tp_cd);
				sheetObj.CellValue(idx, "arb_seq") = parseInt(ComPriGetMax(sheetObj, "arb_seq")) + 1;
				sheetObj.SelectCell(idx, "rout_pnt_loc_def_cd");
				break;
				
			case IBDELETE: // Delete
				if(enableFlag && !validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				deleteRowCheck(sheetObj, "chk" ,true);
				break;
				
				
				

				
				
				
            case IBSEARCH_ASYNC06: //Search FIC Route
                formObj.f_cmd.value = SEARCH09;
                var Row = formObj.rout_tgt_row.value;
                var sParam = FormQueryString(formObj);
                sParam += "&fic_prop_sts_cd=" + sheetObj.CellValue(Row, "prc_prog_sts_cd") + 
                          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
                          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
                          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
                var sXml = sheetObjects[1].getSearchXml("ESM_PRI_2001_12GS.do", sParam);
                
                var arr = ComPriXml2ComboString(sXml, "bse_port_def_cd", "bse_port_def_cd");
                if(arr!=null && arr.length>0){
                    sheetObj.CellComboItem(Row, "bse_port_def_cd", " |"+arr[0], " |"+arr[1]); 
                }
                break;
            
            case IBSEARCH_ASYNC07: //Search FIC Route
                if(!validateForm(sheetObj,formObj,sAction)) {
                    ComOpenWait(false);
                    return false;
                }
                formObj.f_cmd.value = SEARCH02;
                var Row = formObj.rout_tgt_row.value;
                var sParam = FormQueryString(formObj);
                sParam += "&fic_prop_sts_cd=" + sheetObj.CellValue(Row, "prc_prog_sts_cd") + 
                          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
                          "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") +
                          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
                          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
                var sXml = sheetObjects[1].getSearchXml("ESM_PRI_2001_12GS.do", sParam);
                var arr = ComPriXml2ComboString(sXml, "prc_trsp_mod_cd", "prc_trsp_mod_cd");
                if(arr!=null && arr.length>0){
                    sheetObj.CellValue(Row, "prc_trsp_mod_cd") = arr[0];
                }
                break;
                
            case IBSEARCH_ASYNC08: //Search FIC Guide Line
                if(!validateForm(sheetObj,formObj,sAction)) {
                    ComOpenWait(false);
                    return false;
                }
                formObj.f_cmd.value = SEARCH03;
                var Row = formObj.rout_tgt_row.value;
                var sParam = FormQueryString(formObj);
                sParam += "&fic_prop_sts_cd=" + sheetObj.CellValue(Row, "prc_prog_sts_cd") + 
                          "&rout_pnt_loc_def_cd=" + sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") +
                          "&bse_port_def_cd=" + sheetObj.CellValue(Row, "bse_port_def_cd") +
                          "&rcv_de_term_cd=" + sheetObj.CellValue(Row, "rcv_de_term_cd") +
                          "&prc_trsp_mod_cd=" + sheetObj.CellValue(Row, "prc_trsp_mod_cd") +
                          "&rat_ut_cd=" + sheetObj.CellValue(Row, "rat_ut_cd") +
                          "&prc_cgo_tp_cd=" + sheetObj.CellValue(Row, "prc_cgo_tp_cd") +
                          "&curr_cd=" + sheetObj.CellValue(Row, "curr_cd") +
                          "&eff_dt=" + sheetObj.CellValue(Row, "eff_dt");
                var sXml = sheetObjects[1].getSearchXml("ESM_PRI_2001_12GS.do", sParam);
                var saveName = "fic_rt_use_sts_cd|fic_rout_cmb_tp_cd|optm_trsp_mod_flg|fic_gline_rt_amt|fic_gline_upd_dt";
                var saveNameArr = saveName.split("|");
                var arrDesc = ComPriXml2Array(sXml, saveName);
                if (arrDesc != null && arrDesc.length > 0) {
                    sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = arrDesc[0][0];
                    sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = arrDesc[0][1];
                    sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = arrDesc[0][2];
                    sheetObj.CellValue2(Row, "fic_gline_rt_amt") = arrDesc[0][3];
                    sheetObj.CellValue2(Row, "frt_rt_amt") = arrDesc[0][3];
                    sheetObj.CellValue2(Row, "fic_gline_upd_dt") = arrDesc[0][4];
                    calcProposalAmt(sheetObj, Row);
                }
                break;
                				
        }
    }
    
    /**
	 * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
	 * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
	 * <br><b>Example :</b>
     * <pre>
     *     initControl();
     * </pre>
	 * @return 없음
     * @author 김재연
     * @version 2009.07.14
	 */
 	function initControl() {
 		//** Date 구분자 **/
 		DATE_SEPARATOR = "-";
 	
 		//Axon 이벤트 처리1. 이벤트catch
 		axon_event.addListenerForm  ('click', 'obj_click', form);  
 	}
 	
 	/**
     * OnClick 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
	function obj_click(){
		var formObj = document.form;
		
		if (event.srcElement.name == "org_dest_tp_cd") {
			if(sheetObjects[0].IsDataModified) {
				if(ComShowCodeConfirm('PRI00006')) {
					if(!doActionIBSheet(sheetObjects[0], formObj, MODIFY01)) {
						returnRadioButton();
						return;
					}
				} else {
					returnRadioButton();
					return;
				}
			}
     		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
		}
	}

	/**
	 * OnPopupClick 이벤트 발생시 호출되는 function <br>
	 * 해당 popup 화면을 호출한다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.14
	 */
    function sheet1_OnPopupClick(sheetObj, Row, Col) {
    	var colName = sheetObj.ColSaveName(Col);
    	var formObj = document.form;
    	
 		if (colName == "rout_pnt_loc_def_cd") { //Point
 			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd=" + PRI_RG + "&location_cmd=L&svc_scp_cd="+ formObj.svc_scp_cd.value +"&gline_seq="+ formObj.gline_seq.value;
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
			var tpCd = "G";
			if (rtnVal != null){
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				sheetObj.CellValue2(Row, Col + 1) = rtnVal.nm;			
				//Location Type을 변경한다.
				if (rtnVal.cd.length == 5){
					tpCd = "L";
				}
				sheetObj.CellValue2(Row,"rout_pnt_loc_tp_cd") = tpCd ;
                initFicRoute(sheetObj, Row, Col+1);

			}
 		} else if (colName == "bse_port_def_cd") { //Base Point
 			var sUrl = "/hanjin/ESM_PRI_4026.do?group_cmd="+ PRI_RG +"&location_cmd=LG&svc_scp_cd="+ formObj.svc_scp_cd.value +"&gline_seq="+ formObj.gline_seq.value;
			var rtnVal = ComPriOpenWindowCenter(sUrl, "ESM_PRI_4026",700, 325, true);
			var tpCd = "G";
			if (rtnVal != null && checkBasePort(sheetObj, Row, rtnVal.cd)) {
				sheetObj.CellValue2(Row, Col) = rtnVal.cd;
				//Location Type을 변경한다.
				if (rtnVal.cd.length == 5){
					tpCd = "L";
				}
				sheetObj.CellValue2(Row,"bse_port_tp_cd") = tpCd ;
			}
 		}
    }

    /**
     * OnChange 이벤트 발생시 호출되는 function <br>
	 * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibsheet} sheetObj 필수 IBSheet Object
	 * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
	 * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
	 * @return 없음
	 * @author 김재연
	 * @version 2009.07.14
	 */  	    
    function sheet1_OnChange(sheetObj, Row, Col, Value) {

        sheet_OnChange(sheetObj, Row, Col, Value);
        sheet_PostOnChange(sheetObj, Row, Col, Value);

        /*
    	var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
	
		switch(sName) {
			case "rout_pnt_loc_def_cd": //point
				validCheckLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
				break;	
			
			case "bse_port_def_cd": //base port
				if(!checkBasePort(sheetObj, Row, Value)) { //point와 비교
					 return;
				}
				validCheckLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
 	    		break;
 	    	
			case "rcv_de_term_cd": //term
				if(Value != "D") {
					checkBasePort(sheetObj, Row, sheetObj.CellValue(Row, "bse_port_def_cd"));
				}
				break;
			
			case "rat_ut_cd":
				checkPerType(sheetObj, Row, Value);
				break;
				
			case "prc_cgo_tp_cd":
				checkCargoType(sheetObj, Row, Value);
				break;
				
			case "frt_rt_amt":
				break;
		}
		*/
    }

    
	/**
     * OnSearchEnd 이벤트 발생시 호출되는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */ 	
 
  	 function sheet1_OnSearchEnd(sheetObj, errMsg)  {
          
         if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
        }
         var sRow = sheetObj.HeaderRows;
         var eRow = sRow + sheetObj.SearchRows;
         
         var strPropFrtRtAmt = "";
         var strFicGlineRtAmt = "";
         var numPropFrtRtAmt = 0;
         var numFicGlineRtAmt = 0;
         
         for(var i=sRow; i < eRow; i++){
             calcProposalAmt(sheetObj, i);
             // base port list 구성
             var bsePortDefCd = sheetObj.CellValue(i, "bse_port_def_cd");
             var basePortList = sheetObj.CellValue(i, "base_port_list");
             if(bsePortDefCd != basePortList){
                 sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + basePortList,  " |" + basePortList);
             }else{
                 sheetObj.CellComboItem(i, "bse_port_def_cd", " |" + bsePortDefCd,  " |" + bsePortDefCd);
             }
             sheetObj.CellValue2(i, "bse_port_def_cd") = bsePortDefCd;
             
             sheetObj.RowStatus(i) = "R";
         }
         
         sheetObj.SelectCell(1, 1);
         
     }
	
    /**
     * OnSaveEnd 이벤트 발생시 호출되는 function <br>
     * 저장완료 후 정상이면 저장완료 메세지를 보여준다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {string} ErrMsg 필수 서버에서 넘어온 메세지
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */ 	
  	function sheet1_OnSaveEnd(sheetObj, ErrMsg)  {
    	if(sheetObj.EtcData(ComWebKey.Trans_Result_Key) == "S") {
    		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
			parent.setTabStyle();
		}
    	 
        
        
	}   
    /**
     * Propocal Amount 계산 function <br>
     * <br><b>Example :</b>
     * <pre>
     *      calcProposalAmt(sheetObj, Row)
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.30
     */
    function calcProposalAmt(sheetObj, Row){
        
        var strPropFrtRtAmt = "";
        var strFicGlineRtAmt = "";
        var numPropFrtRtAmt = 0;
        var numFicGlineRtAmt = 0;
        
        if("S"==sheetObj.CellValue(Row, "fic_rt_use_sts_cd")){
            
            strPropFrtRtAmt = sheetObj.CellValue(Row, "frt_rt_amt");
            if(strPropFrtRtAmt){
                numPropFrtRtAmt = Number(strPropFrtRtAmt);
            }
            
            strFicGlineRtAmt = sheetObj.CellValue(Row, "fic_gline_rt_amt");
            if(strFicGlineRtAmt){
                numFicGlineRtAmt = Number(strFicGlineRtAmt);
            }
            
            // 부동소수점 제어를 위해 정수형 변경후 처리
            numPropFrtRtAmt = numPropFrtRtAmt * 100;
            numFicGlineRtAmt = numFicGlineRtAmt * 100;
            
            numPropFrtRtAmt = numPropFrtRtAmt.toFixed();
            numFicGlineRtAmt = numFicGlineRtAmt.toFixed();
            
            sheetObj.CellValue2(Row, "diff_with_gl") =  ComAddComma2(((numPropFrtRtAmt - numFicGlineRtAmt)/100).toString(), '#,###.00');
            
        }else{
            sheetObj.CellValue2(Row, "diff_with_gl") = "N/A";
        }
    }
  	
    /**
     * Page Loading시에 실행하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    
     * </pre>
     * @returns 없음
     * @author 김재연
     * @version 2009.04.29
     */ 
    function pageOnLoadFinish() {
    	initControl();
      	toggleButtons("CLEAR");
      	parent.loadTabPage();
    }
     
    /**
     * location code 유효성 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    validCheckLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */ 
    /*
	function validCheckLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
		var formObj = document.form;
		var locCd = sheetObj.CellValue(Row, cellDefCdNm);
		
		// Location
		if (locCd.length == 5 && isLoc) {
			formObj.f_cmd.value = SEARCH05;
			formObj.cd.value = locCd;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
			var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			
			if (arrDesc != null && arrDesc.length > 0) {
				sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"loc_des") = arrDesc[0][1];
				}
			} else {	
				locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
				if (cellDefCdNm == "rout_pnt_loc_def_cd") {
					sheetObj.CellValue2(Row,"loc_des") = "";
				}
				sheetObj.SelectCell(Row, cellDefCdNm);
			}
		} 
		// Group Location
		else if (locCd.length == 4 && isGrpLoc) {
			formObj.f_cmd.value = COMMAND24;
			formObj.cd.value = locCd;
			var sParam = FormQueryString(formObj);
			sParam += "&etc1="+PRI_RG;
			var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
			var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
			} else {
				sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
				sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
				sheetObj.SelectCell(Row, "bse_port_def_cd");
			}
 		} else {
			locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
			sheetObj.SelectCell(Row, cellDefCdNm);
 		}
	}
	*/
	
	/**
     * location code 를 리셋하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
     * @param (string) cellTpCdNm 선택한 cell의 tp code
     * @param (string) cellDefCdNm 선택한 cell의 def code
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
	function locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm) {
		sheetObj.CellValue2(Row, cellTpCdNm) = "";
		sheetObj.CellValue2(Row, cellDefCdNm) = "";
	}
	
	/**
     * rat_ut_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkPerType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
     function checkPerType(sheetObj, Row, Value) {
 		var validPerClass = "A,F,O,Q,S,P";
         if(sheetObj.CellValue(Row, "prc_cgo_tp_cd") == "AK" && ( ComIsNull(Value) || validPerClass.indexOf(Value.charAt(0)) < 0 )) {
         	ComShowCodeMessage("PRI08003");
     		sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
         }
 	}
	
	/**
     * prc_cgo_tp_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	setCargoType(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
     function checkCargoType(sheetObj, Row, Value) {
     	var validPerClass = "A,F,O,Q,S,P";
     	var ratUtCd = sheetObj.CellValue(Row, "rat_ut_cd");
         if (Value == "AK" && ( ComIsNull(ratUtCd) || validPerClass.indexOf(ratUtCd.charAt(0)) < 0 )) {
             ComShowCodeMessage("PRI08003");
             sheetObj.CellValue2(Row, "prc_cgo_tp_cd") = "";
         }
 	}
	
	/**
     * bse_port_def_cd의 validation 확인하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *	 	checkBasePort(sheetObj, Row, Value)
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
	 * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
	function checkBasePort(sheetObj, Row, Value) {
		if (sheetObj.CellValue(Row, "rout_pnt_loc_def_cd") == Value && sheetObj.CellValue(Row, "rcv_de_term_cd") != "D") {
			ComShowCodeMessage('PRI01020');
			sheetObj.CellValue(Row, "bse_port_def_cd") = "";
			sheetObj.CellValue(Row, "bse_port_tp_cd") = "";
			sheetObj.SelectCell(Row, "bse_port_def_cd");
			return false;
		}
		return true;
	}
	
	/**
     * org_dest_tp_cd의 value를 가져오는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *		getOrgDestTpCd()
     * </pre>
     * @return (String)
     * @author 김재연
     * @version 2009.07.14
     */
	function getOrgDestTpCd() {
		return ComGetObjValue(document.form.org_dest_tp_cd);
	}
    
    /**
     * Type Radio button Click 시 Validation 체크나 변경내용 저장 Confirm 에서 No 선택시 되돌리는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    returnRadioButton()
     * </pre>
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */  
    function returnRadioButton() {
     	var formObj = document.form;
     	if(formObj.org_dest_tp_cd[0].checked) {
 			formObj.org_dest_tp_cd[1].checked = true;
 		} else if(formObj.org_dest_tp_cd[1].checked) {
 			formObj.org_dest_tp_cd[0].checked = true;
 		}
    }
     
     
	/**
     * parent 화면에서 탭 화면의 control을 clear 하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabClearSheet()
     * </pre>
     * @param 없음
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */ 
	function tabClearSheet() {
		var formObject = document.form;
		
		formObject.svc_scp_cd.value = "";
		formObject.gline_seq.value = "";
		
		sheetObjects[0].RemoveAll();
		toggleButtons("CLEAR");

	}
	
	/**
     * 메인에서 호출하는 function <br>
     * Confirmation이 YES 인 경우 입력,수정,삭제할 수 없게 한다. <br>
     * <br><b>Example :</b>
     * <pre>
     * 		tabEnableSheet(flag)
     * </pre>
     * @param {boolean} flag 필수 메인화면에서 넘긴다.
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
	function tabEnableSheet(flag) {
		var formObject = document.form;	
		enableFlag = flag;
		sheetObjects[0].Editable = flag;
		
		if (enableFlag) {
			toggleButtons("INIT");
		} else {
			toggleButtons("READONLY");
		}		
	}
    
	/**
     * parent 화면에서 탭을 click 했을 때 호출하는 function <br>
     * 화면이 보여지며 조회를 한다.<br>
     * <br><b>Example :</b>
     * <pre>
     *		tabLoadSheet("ACE", "1")
     * </pre>
     * @param {string} sSvcScpCd 필수 svc_scp_cd 값
     * @param {string} sGlineSeq 필수 gline_seq 값
     * @return (String)
     * @author 김재연
     * @version 2009.07.14
     */
	function tabLoadSheet(sSvcScpCd, sGlineSeq, isAproUsr,effDt) {
        
		var formObject = document.form;
		
		//alert("svc_scp_cd : "+sSvcScpCd+"\ngline_seq : "+sGlineSeq+"\nisAproUsr : "+isAproUsr);
		if(formObject.svc_scp_cd.value != sSvcScpCd || formObject.gline_seq.value != sGlineSeq) {
			formObject.svc_scp_cd.value = sSvcScpCd;
			formObject.gline_seq.value = sGlineSeq;
			formObject.eff_dt.value = effDt;
	        
			
			if (isAproUsr && parent.getCfmFlg() == "N") {
            	enableFlag = true;
            } else {
            	enableFlag = false;
            }
			
			tabEnableSheet(enableFlag);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC03);
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}
 	
    /**
     * parent 화면의 상태로 edit여부를 판단한다. function <br>
     * <br><b>Example :</b>
     * <pre>
     * getMainStatus())
     * </pre>
     * @param 없음
     * @return {Boolean} true(수정가능,메인의 상태는 No) false(수정불가능,메인의상태는 Yes)
     * @author 김재연
     * @version 2009.07.14
     */    
    function getMainStatus(){
    	var mainStatus = parent.document.form.cfm_flg.value;
     	var editStatus = true;
     	
     	if (mainStatus == "Yes"){
     		editStatus = false;
    	}
    	return editStatus;
    }
     
	/**
     * button의 속성을 설정하는 function <br>
     * <br><b>Example :</b>
     * <pre>
     *    toggleButtons("INIT")
     * </pre>
     * @param (string) 필수 button 설정 mode
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */
    function toggleButtons(mode) {
    	switch (mode) {
	 		case "CLEAR":
	 			ComBtnDisable("btn_retrieve");
	 			ComBtnDisable("btn_save");
	 			ComBtnDisable("btn_downexcel");
	 			ComBtnDisable("btn_loadexcel");
	 			ComBtnDisable("btn_rowadd");
	 			ComBtnDisable("btn_rowcopy");
	 			ComBtnDisable("btn_delete");
	 			break;
	 			
	 		case "INIT":
	 			ComBtnEnable("btn_retrieve");
	 			if(getMainStatus()){
	 				ComBtnEnable("btn_save");
	 				ComBtnEnable("btn_loadexcel");
	 			} else {
	 				ComBtnDisable("btn_save");
	 				ComBtnDisable("btn_loadexcel");
	 			}
	 			ComBtnEnable("btn_downexcel");
	 			ComBtnEnable("btn_rowadd");
	 			ComBtnEnable("btn_rowcopy");
	 			ComBtnEnable("btn_delete");
	 			break;
	 			
	 		case "READONLY":
	 			ComBtnEnable("btn_retrieve");
	 			ComBtnDisable("btn_save");
	 			ComBtnEnable("btn_downexcel");
	 			ComBtnDisable("btn_loadexcel");
	 			ComBtnDisable("btn_rowadd");
	 			ComBtnDisable("btn_rowcopy");
	 			ComBtnDisable("btn_delete");
	 			break;
 		}
 	}
     
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *    validateForm(sheetObj, document.form, sAction)
     * </pre>
     * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
     * @param (object) formObj 필수 Form Object
     * @param (string) sAction 필수 
     * @return 없음
     * @author 김재연
     * @version 2009.07.14
     */ 
    function validateForm(sheetObj,formObj,sAction){
    	switch (sAction) {
	  		case IBSEARCH: // 조회			
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					ComShowCodeMessage('PRI08001');
					return false;
				} else {
					return true;
				}
	  			return true;
				break;
				
		  	case IBSAVE: // 저장
	            if(!ComPriConfirmSave()) {
	                return false;
	            }

			  	if(!sheetObjects[0].IsDataModified) {
					ComShowCodeMessage("PRI00301");
					return false;
				}
			  	
			  	if(sheetObjects[0].GetSaveString() == "") {
					return false;
				}
			  	
			  	var rCnt = sheetObjects[0].RowCount;
			  	for(var i=1; i<=rCnt; i++) {
			  		if(sheetObjects[0].CellValue(i, "frt_rt_amt") == 0) {
			  			ComShowCodeMessage("PRI01042", "Rate");
			  			sheetObjects[0].SelectCell(i, "frt_rt_amt");
			  			return false;
			  		}
			  	}
			  	
				if(sheetObjects[0].IsDataModified ) {
					var rowM = sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd");
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
					    return false;
				    }
				}
				return true;
				break;
			
		  	case MODIFY01: // Radio Button Click Save
			  	if(sheetObjects[0].GetSaveString() == "") {
					return false;
				}
			  	
			  	var rCnt = sheetObjects[0].RowCount;
			  	for(var i=1; i<=rCnt; i++) {
			  		if(sheetObjects[0].CellValue(i, "frt_rt_amt") == 0) {
			  			ComShowCodeMessage("PRI01042", "Rate");
			  			sheetObjects[0].SelectCell(i, "frt_rt_amt");
			  			return false;
			  		}
			  	}
			  	
				if(sheetObjects[0].IsDataModified ) {
					var rowM = sheetObjects[0].ColValueDup("rout_pnt_loc_def_cd|prc_trsp_mod_cd|rcv_de_term_cd|min_cgo_wgt|max_cgo_wgt|bse_port_def_cd|rat_ut_cd|prc_cgo_tp_cd|curr_cd");
					if (rowM >= 0) {
						ComShowCodeMessage("PRI00303", "Sheet", rowM);
					    return false;
				    }
				}
				return true;	
				break;
			
			case IBINSERT: // Row Add
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				return true;
				break;
				
			case IBCOPYROW: // Row Copy
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				}
				return true;
				break;
				
			case IBDELETE: // Delete
				if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
					return false;
				} else {
					return true;
				}
				return true;
				break;
				
			case IBLOADEXCEL: // Excel Load
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            }
				if(sheetObjects[0].IsDataModified) {
					ComShowCodeMessage('PRI01057');
					return false;
				}
				return true;
				break;
				
	        case IBDOWNEXCEL: // 엑셀조회
	            if (formObj.svc_scp_cd.value == "" || formObj.gline_seq.value == "") {
	                return false;
	            } else {
	                return true;
	            }
	        	return true;
	            break;				
    	}
    	return true;
    }    	
    
    
    

    /**
      * OnChange 이벤트 발생시 호출되는 function <br>
      * Change가 발생한 Row를 초기화 한다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
      * @return 없음
      * @author 김재연
      * @version 2009.05.19
      */ 
     function initFicRoute(sheetObj, Row, Col) {
         var formObj = document.form;
          
         sheetObj.Redraw = false;
         var saveName = sheetObj.ColSaveName(Col);
         switch(saveName){
             
             case "rout_pnt_loc_def_cd":
                 sheetObj.CellValue(Row, "rcv_de_term_cd") = "";
             
             case "rcv_de_term_cd":
                 sheetObj.CellComboItem(Row, "bse_port_def_cd", " ", " ");
                 
             case "bse_port_def_cd":
                 sheetObj.CellValue2(Row, "prc_trsp_mod_cd") = "";
                 
             case "prc_trsp_mod_cd":
                 sheetObj.CellValue2(Row, "rat_ut_cd") = "";
                 
             case "rat_ut_cd":
                 sheetObj.CellValue2(Row, "frt_rt_amt") = "";
                 sheetObj.CellValue2(Row, "fic_gline_rt_amt") = "";
                 sheetObj.CellValue2(Row, "diff_with_gl") = "";
                 sheetObj.CellValue2(Row, "base_port_list") = "";
                 sheetObj.CellValue2(Row, "optm_trsp_mod_flg") = "";
                 sheetObj.CellValue2(Row, "fic_rout_cmb_tp_cd") = "";
                 sheetObj.CellValue2(Row, "fic_rt_use_sts_cd") = "";
                 sheetObj.CellValue2(Row, "fic_gline_upd_dt") = "";
                 break;
         }
         sheetObj.Redraw = true;
     }
     
     /**
      * OnChange 이벤트 발생시 호출되는 function <br>
      * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
      * <br><b>Example :</b>
      * <pre>
      *
      * </pre>
      * @param {ibsheet} sheetObj 필수 IBSheet Object
      * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
      * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
      * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
      * @return 없음
      * @author 김재연
      * @version 2009.05.19
      */         
      function sheet_OnChange(sheetObj, Row, Col, Value) {
         var formObj = document.form;
         var sName = sheetObj.ColSaveName(Col);

         switch(sName) {
             case "rout_pnt_loc_def_cd": //point

                 if(!checkRoutePointLocation(sheetObj, Row, Value)) {
                     return;
                 }
                 initFicRoute(sheetObj, Row, Col);
                 checkLocationCode(sheetObj, Row, 'rout_pnt_loc_tp_cd', 'rout_pnt_loc_def_cd', true, false);
                 break;  
             
             case "rcv_de_term_cd": //Term
                 initFicRoute(sheetObj, Row, Col);
                 break;
                 
             case "bse_port_def_cd": //base port
                 if(sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && !checkBasePort(sheetObj, Row, Value)) { //point와 비교
                      return;
                 }
                 initFicRoute(sheetObj, Row, Col);
                 checkLocationCode(sheetObj, Row, 'bse_port_tp_cd', 'bse_port_def_cd', true, true);
                 break;
                 
             case "prc_trsp_mod_cd": //trans mode
                 if(Value==""){
                     initFicRoute(sheetObj, Row, Col);
                 }
                 break;
             
             case "rat_ut_cd":
                 checkPerType(sheetObj, Row, Value);
                 initFicRoute(sheetObj, Row, Col);
                 break;
                 
             case "prc_cgo_tp_cd":
                 checkCargoType(sheetObj, Row, Value);
                 if(Value==""){
                     initFicRoute(sheetObj, Row, Col);
                 }
                 break;
                 
             case "frt_rt_amt":
                 break;
                  
         }
          
     }

      /**
       * OnChange 이벤트 발생시 호출되는 function <br>
       * Multi ComboBox 선택 시 Description의 내용을 보여준다. <br>
       * <br><b>Example :</b>
       * <pre>
       *
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
       * @param {int} Col 필수 Onclick 이벤트가 발생한 해당 셀의 Column Index
       * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
       * @return 없음
       * @author 김재연
       * @version 2009.05.19
       */         
      function sheet_PostOnChange(sheetObj, Row, Col, Value) {
          var formObj = document.form;
          var sName = sheetObj.ColSaveName(Col);

          switch(sName) {
              case "rcv_de_term_cd":  //term  
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC06);
                  break;  
                  
              case "bse_port_def_cd": //base port
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC07);
                  break;  
              
              case "prc_trsp_mod_cd": //trans mode
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
                  break;
                  
              case "rat_ut_cd":
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
                  break;
                  
              case "prc_cgo_tp_cd":
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
                  break;
                  
              case "curr_cd":
                  formObj.rout_tgt_row.value = Row;
                  doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC08);
                  break;
                  
              case "frt_rt_amt":
                  calcProposalAmt(sheetObj, Row);
                  break;
          }
      }
 
      
      /**
       * rout_pnt_loc_tp_cd의 validation 확인하는 function <br>
       * <br><b>Example :</b>
       * <pre>
       *      checkRoutePointLocation(sheetObj, Row, Value)
       * </pre>
       * @param {ibsheet} sheetObj 필수 IBSheet Object
       * @param {int} Row 필수 이벤트가 발생한 해당 셀의 Row Index
       * @param {string} Value 필수 이벤트가 발생한 해당 셀의 Value
       * @return 없음
       * @author 김재연
       * @version 2009.07.30
       */
      function checkRoutePointLocation(sheetObj, Row, Value) {
          if(ComIsNull(Value)) {
              return true;
          }
          
          if (sheetObj.CellValue(Row, "rcv_de_term_cd") != "D" && sheetObj.CellValue(Row, "bse_port_def_cd") == Value) {
              ComShowCodeMessage('PRI01078');
              sheetObj.CellValue2(Row, "rout_pnt_loc_def_cd") = "";
              sheetObj.CellValue2(Row, "rout_pnt_loc_tp_cd") = "";
              sheetObj.SelectCell(Row, "rout_pnt_loc_def_cd");
              return false;
          }
          return true;
      }
      
      /**
       * location code 유효성 확인하는 function <br>
       * <br><b>Example :</b>
       * <pre>
       *    checkLocationCode(sheetObj, Row, 'via_port_tp_cd', 'via_port_def_cd', true, false)
       * </pre>
       * @param {ibsheet} sheetObj 필수 HTML태그(Object) 오브젝트
       * @param {int} Row 필수 Onclick 이벤트가 발생한 해당 셀의 Row Index
       * @param (string) cellTpCdNm 선택한 cell의 tp code
       * @param (string) cellDefCdNm 선택한 cell의 def code
       * @return 없음
       * @author 김재연
       * @version 2009.07.30
       */
      function checkLocationCode(sheetObj, Row, cellTpCdNm, cellDefCdNm, isLoc, isGrpLoc) {
          
          var formObj = document.form;
          var locCd = sheetObj.CellValue(Row, cellDefCdNm);
          // Location
          if (locCd.length == 5 && isLoc) {
              formObj.f_cmd.value = SEARCH05;                     
              formObj.cd.value = locCd;
              var sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj));
              var arrDesc = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
              
              if (arrDesc != null && arrDesc.length > 0) {
                  sheetObj.CellValue2(Row, cellTpCdNm) = "L" ;
                  if (cellDefCdNm == "rout_pnt_loc_def_cd") {
                      sheetObj.CellValue2(Row,"loc_des") = arrDesc[0][1];
                  }
              } else {    
                  locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
                  if (cellDefCdNm == "rout_pnt_loc_def_cd") {
                      sheetObj.CellValue2(Row,"loc_des") = "";
                  }
              }
          } 
          // Group Location
          else if (locCd.length == 4 && isGrpLoc) {
              formObj.f_cmd.value = COMMAND24;
              formObj.cd.value = locCd;
              var sParam = FormQueryString(formObj);
              sParam += "&etc1="+PRI_RP_SCP;
              var sXml = sheetObj.GetSearchXml("PRICommonGS.do", sParam);
              var arrData = ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
              if (arrData != null && arrData.length > 0) {
                  sheetObj.CellValue2(Row, "bse_port_tp_cd") = "G";
              } else {
                  sheetObj.CellValue2(Row, "bse_port_def_cd") = "";
                  sheetObj.CellValue2(Row, "bse_port_tp_cd") = "";
              }
          } else {
              locationCellClear(sheetObj, Row, cellTpCdNm, cellDefCdNm);
              if (cellDefCdNm == "rout_pnt_loc_def_cd") {
                  sheetObj.CellValue2(Row,"loc_des") = "";
              }
          }
      }      
	/* 개발자 작업  끝 */