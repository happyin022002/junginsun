/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7014.jsp
 *@FileTitle : IHC Guideline Creation / Amend ad Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.12
 *@LastModifier : 조정민
 *@LastVersion : 1.0
 * 2013.04.12 조정민
 * 1.0 Creation
 =========================================================
 * History
 * 2013.06.10 서미진 [선처리 CSR] Load Excel data 의 증가로 backendjob으로 upload 로직 변경
 * 2013.07.08 서미진 [CHM-201325626] HAMRU 산하 TAE, TAW, ASE, ASW 인 경우 Local Currency 가 기준이 되도록 변경
 * 2013.07.15 서미진 [선처리 CSR] Excel upload 시 Local currency 도 update 되도록 변경
 * 2013.09.11 전윤주 [CHM-201326761] HAMRU 산하  EAN, EAS 인 경우 Local Currency 가 기준이 되도록 추가
 * 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
 ========================================================= */
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7014() { 
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }
    

    /* 개발자 작업 */

    // 공통전역변수

    var sheetObjects = new Array();
    var sheetCnt = 0;
    
    var isClear = true;
    var isChanged = false;
    var timerID = "";
    var jobKey = "";
    
    /**
     * 팝업장 닫을시 부모 창에 returnValue을 넘겨줌.
     */
    window.onunload=function(){
    	window.returnValue = isChanged;
    }
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *     processButtonClick();
	 * </pre>
	 * @return 없음
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function processButtonClick() {
       /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
        var sheetObject1 = sheetObjects[0];
    
        /** **************************************************** */
        var formObject = document.form;
    
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            if (srcName != null && srcName != "" && srcName.indexOf("btn") == 0) {
                if (getButtonTable(srcName).disabled) {
                    return false;
                }
            }
    
            switch (srcName) {
			case "btn_rowadd":
				doActionIBSheet(sheetObject1, formObject, IBINSERT);
				break;
				
			case "btn_delete":
				doActionIBSheet(sheetObject1, formObject, IBDELETE);
				break;
            
            case "btn_openfile":
            	doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
                break;
    
            case "btn_check":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
                break;
    
            case "btn_save":
                doActionIBSheet(sheetObject1, document.form, IBSAVE);
                break;
            case "btn_close":
                window.close();
                break;
            } // end switch
        } catch (e) {
            if (e == "[object Error]") {
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
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function setSheetObject(sheet_obj) {
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
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function loadPage() {
        for (i = 0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            sheetObjects[i].WaitImageVisible = false;
            ComEndConfigSheet(sheetObjects[i]);
        }

        toggleButtons("INIT");
        doActionIBSheet(sheetObjects[0], document.form, IBCLEAR);
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
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function initSheet(sheetObj, sheetNo) {
        var cnt = 0;
        var formObj = document.form;
        switch (sheetNo) {
	        case 1: // sheet1 init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 440;
	                // 전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                // Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "")
	                    InitHostInfo(location.hostname, location.port, page_path);
	
	                // 전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msHeaderOnly;
	
	                // 전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                InitRowInfo( 3, 1, 20, 100);
	                
	                var HeadTitle1 = "Sel|Seq.|Point|Description|Hub|Base Port|Contract\nTerm|Trans Mode|Tariff (USD)|Tariff (USD)|Tariff (USD)||";
	                var HeadTitle2 = "Sel|Seq.|Point|Description|Hub|Base Port|Contract\nTerm|Trans Mode|Tariff (USD)|Tariff (USD)|Tariff (USD)||";
	                var HeadTitle3 = "Sel|Seq.|Point|Description|Hub|Base Port|Contract\nTerm|Trans Mode|20'|40'|45'||";
	                var headCount = ComCountHeadTitle(HeadTitle3);

					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, true, true, false, false)
					
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true);
					InitHeadRow(2, HeadTitle3, false);                

	                InitDataProperty(0, cnt++,  dtCheckBox, 	40, 		daCenter, 	true, 	"chk");         
	                InitDataProperty(0, cnt++, 	dtDataSeq,     	40,    		daCenter,  	true,  	"Seq");               
	                InitDataProperty(0, cnt++, 	dtData, 			70, 			daCenter, 	true, 	"pnt_loc_cd",            		true,  "", dfNone, 0, true, true, 5); 
	                InitDataProperty(0, cnt++, 	dtData, 	    	120, 		daLeft	,	 	true, 	"pnt_loc_nm",            	false, "", dfNone, 0, false, false); 
	                InitDataProperty(0, cnt++, 	dtData, 			80,	 		daCenter, 	true, 	"hub_loc_cd",            	false, "", dfNone, 0, true, true, 5); 
	                InitDataProperty(0, cnt++, 	dtData, 			80,	 		daCenter, 	true, 	"bse_port_loc_cd",       	true,  "", dfNone, 0, true, true, 5);      
	                InitDataProperty(0, cnt++, 	dtCombo, 		80,	 		daCenter, 	true, 	"rcv_de_term_cd",        	true,  "", dfNone, 0, true, true);   
	                InitDataProperty(0, cnt++, 	dtCombo,			100, 		daCenter, 	true, 	"prc_trsp_mod_cd",       	true,  "", dfNone, 0, true, true); 
		 			if(formObj.rhq_cd.value == "HAMRU"){
		 				if(formObj.svc_scp_cd.value == "TAE" || formObj.svc_scp_cd.value == "TAW" || formObj.svc_scp_cd.value == "ASE" || formObj.svc_scp_cd.value == "ASW"
		 				|| formObj.svc_scp_cd.value == "EAN" || formObj.svc_scp_cd.value == "EAS"){
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_locl_curr_20ft_amt", 	false, "", dfFloat, 2, true, true, 9);
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_locl_curr_40ft_amt", 	false, "", dfFloat, 2, true, true, 9);  
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_locl_curr_45ft_amt", 	false, "", dfFloat, 2, true, true, 9);
		 				}else{
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_20ft_frt_rt_amt", 		false, "", dfFloat, 2, true, true, 9);
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_40ft_frt_rt_amt", 		false, "", dfFloat, 2, true, true, 9);   
			                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_45ft_frt_rt_amt", 		false, "", dfFloat, 2, true, true, 9);
		 				}
		 			}else{
		                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_20ft_frt_rt_amt", 		false, "", dfFloat, 2, true, true, 9);
		                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_40ft_frt_rt_amt", 		false, "", dfFloat, 2, true, true, 9);   
		                InitDataProperty(0, cnt++, 	dtData, 			100, 		daRight,		true, 	"gline_45ft_frt_rt_amt", 		false, "", dfFloat, 2, false, false, 9);
		 			}		 				
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30, 		daCenter, 	true, 	"ibflag"); 
	                InitDataProperty(0, cnt++, 	dtHidden, 			100, 		daCenter, 	true, 	"locl_curr_cd",            	false, "", dfNone, 0, true, true); 
	                InitDataCombo(0, "prc_trsp_mod_cd", prcTrspModCdText, prcTrspModCdValue);   
	                InitDataValid(0, "pnt_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
	                InitDataValid(0, "hub_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
	                InitDataValid(0, "bse_port_loc_cd", vtEngUpOther, "0123456789");// 영대문자,숫자만 입력
	                HeadRowHeight = DataRowHeight;
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
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function doActionIBSheet(sheetObj, formObj, sAction) {
       try {
//            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
//                ComOpenWait(true);
//            }
	        sheetObj.ShowDebugMsg = false;
	        switch (sAction) {
	            
			case IBSEARCH_ASYNC02: // Open
				ComOpenWait(true);
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					sheetObj.LoadExcel( 1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObj.RowCount > 0) {
					toggleButtons("LOAD");
				} else {
					toggleButtons("INIT");
				}
				ComOpenWait(false);
		     	break;
	        
	        case IBSEARCH_ASYNC01: // Check
	        	ComOpenWait(true);
	            if (!validateForm(sheetObj, document.form, sAction)) {
	            	ComOpenWait(false);
	                return false;
	            }
	            ComOpenWait(false);
	            break;
	        
	        case IBSAVE: // Save
	        	{
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            ComOpenWait(true);
		            if (!ComPriConfirmSave()) {
		                return false;
		            }	
		            
	                formObj.f_cmd.value = MULTI;
	                var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true);
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_7014GS.do", sParam);	                
	                jobKey = ComGetEtcData(sXml, "BackEndJobKey");

	                if (sXml.indexOf("ERROR") >= 0) {
	                	sheetObj.LoadSaveXml(sXml);
	                    return false;
					} else if (jobKey == null || jobKey == "" || jobKey == undefined || jobKey.length <= 0) {
						ComOpenWait(false);
						ComShowCodeMessage("PRI00201");
						return false;
					} else {
						timerID = setInterval(getJobStatus, 2000);
					}
				}	                    
	            break;
	            
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				break;	            
	            
	        case IBCLEAR: // 화면 로딩시 
	        	formObj.f_cmd.value = SEARCH19;
	            var sXml_Rcv_de_term_cd = "";
	            var stdRcvDeTermCd = "";
	            if(formObj.org_dest_tp_cd.value == 'O') {
	            	stdRcvDeTermCd = "CD02070";
	    		} else if(formObj.org_dest_tp_cd.value == 'D') {
	    			stdRcvDeTermCd = "CD02071";	
	    		}  
	            sXml_Rcv_de_term_cd = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd="+stdRcvDeTermCd);
	            setIBCombo(sheetObj, sXml_Rcv_de_term_cd, "rcv_de_term_cd", false, 0, "D");
	            
	 			if(formObj.rhq_cd.value == "HAMRU"){
	 				if(formObj.svc_scp_cd.value == "TAE" || formObj.svc_scp_cd.value == "TAW" || formObj.svc_scp_cd.value == "ASE" || formObj.svc_scp_cd.value == "ASW"
	 				|| formObj.svc_scp_cd.value == "EAN" || formObj.svc_scp_cd.value == "EAS"){
		                sheetObjects[0].CellValue2( 0 , 8 ) = "Tariff ("+ formObj.locl_curr_cd.value+")";
		                sheetObjects[0].CellValue2( 1 , 8 ) = "Tariff ("+ formObj.locl_curr_cd.value+")"; 
		                sheetObjects[0].CellValue2( 0 , 9 ) = "Tariff ("+ formObj.locl_curr_cd.value+")";
		                sheetObjects[0].CellValue2( 1 , 9 ) = "Tariff ("+ formObj.locl_curr_cd.value+")"; 
		                sheetObjects[0].CellValue2( 0 , 10 ) = "Tariff ("+ formObj.locl_curr_cd.value+")";		// 45' Cost 추가
		                sheetObjects[0].CellValue2( 1 , 10 ) = "Tariff ("+ formObj.locl_curr_cd.value+")";		// 45' Cost 추가
	 				}
	 			}
	            break;
	            
	        case IBINSERT: 
	          	sheetObj.DataInsert(-1);
	          	isClear = false;
	          	toggleButtons("LOAD");
	            break;
	            
	        case IBDELETE:
  				var iCheckRow2 = sheetObj.FindCheckedRow("chk");	        
	        	var arrRow = iCheckRow2.split("|");
  			  	for (idx = arrRow.length-2; idx >= 0; idx--){ 
					sheetObj.RowDelete(arrRow[idx], false);
  			  	}
	        	isClear = false;
	        	if(sheetObj.RowCount > 0)
	       			toggleButtons("LOAD");
	            break;
	        }
        } catch (e) {
            if (e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e);
            }
        } 
//        finally {
//        	ComOpenWait(false);
//        }       
    }

	/**
	 * 화면의 모든 버튼들의 Enable/Disable을 처리하는 함수. <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param {string} mode 필수 사용자 권한이나 모드
	 * @author 이은섭
	 * @version 2012.05.30
	 */
    function toggleButtons(step) {
        switch (step) {
        case "INIT":
            ComBtnEnable("btn_openfile");
            ComBtnDisable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "LOAD":
            ComBtnEnable("btn_openfile");
            ComBtnEnable("btn_check");
            ComBtnDisable("btn_save");
            break;
        case "CHECK":
            ComBtnEnable("btn_openfile");
            ComBtnEnable("btn_check");
            ComBtnEnable("btn_save");
            break;
 		case "DISABLED":
            ComBtnDisable("btn_openfile");
            ComBtnDisable("btn_check");
            ComBtnDisable("btn_save");
            ComBtnDisable("btn_rowadd");
            ComBtnDisable("btn_delete");
            break;            
        }
    }
    
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리 <br>
     * <br><b>Example :</b>
     * <pre>
     *     if (validateForm(sheetObj,document.form,IBSAVE)) {
     *         로직처리;
     *     }
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @param {form} formObj 필수 html form object
     * @param {int} sAction 필수 프로세스 플래그 상수
     * @returns bool <br>
     *          true  : 폼입력값이 유효할 경우<br>
     *          false : 폼입력값이 유효하지 않을 경우
     * @author 이은섭
     * @version 2012.05.30
     */
    function validateForm(sheetObj, formObj, sAction) {
         switch (sAction) {
        	case IBSEARCH_ASYNC01: // Check
            	isClear = true;
            	clearTooltip();
            	
        		//Point,Hub,Base Port 의 중복 체크
        		var duprows2 = sheetObj.ColValueDupRows("pnt_loc_cd|hub_loc_cd|bse_port_loc_cd|rcv_de_term_cd|prc_trsp_mod_cd", false, true);
        		if(duprows2 != '') {
					var arrRow = duprows2.split("|");
					for (idx=0; idx < arrRow.length; idx++) {
						var duprows = arrRow[idx].split(",");
						for (var x=0; x < duprows.length; x++) {
							add2Tooltip(duprows[x], 'pnt_loc_cd', msgs['PRI00302']);
							add2Tooltip(duprows[x], 'hub_loc_cd', msgs['PRI00302']);
							add2Tooltip(duprows[x], 'bse_port_loc_cd', msgs['PRI00302']);
							add2Tooltip(duprows[x], 'rcv_de_term_cd', msgs['PRI00302']);
							add2Tooltip(duprows[x], 'prc_trsp_mod_cd', msgs['PRI00302']);
							isClear = false;
						}
					 }
        		}
    
        		//Point - Base Port 체크, Length 체크
    			//Point 및 Base Port 값이 mdm_location 테이블에 존재 여부 체크.
	            formObj.f_cmd.value = SEARCH;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true);
	            var sXml = sheetObj.GetSearchXml("ESM_PRI_7014GS.do", sParam);
	            var check_code = ComGetEtcData(sXml,"CHECK_CODE");
	            var chk = check_code.split(",");
	            var sText = sheetObj.GetComboInfo(sheetObj.LastRow, 'rcv_de_term_cd', 'Text');
	            var mText = sheetObj.GetComboInfo(sheetObj.LastRow, 'prc_trsp_mod_cd', 'Text');
	     
            	for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
        			var pnt_loc_cd = sheetObj.CellValue(i, 'pnt_loc_cd');
        			var hub_loc_cd = sheetObj.CellValue(i, 'hub_loc_cd');
        			var bse_port_loc_cd = sheetObj.CellValue(i, 'bse_port_loc_cd');
        			var rcv_de_term_cd = sheetObj.CellValue(i, 'rcv_de_term_cd');
        			var rcv_de_term_nm = sheetObj.CellText(i, 'rcv_de_term_cd');
        			var prc_trsp_mod_cd = sheetObj.CellValue(i, 'prc_trsp_mod_cd');
        			var prc_trsp_mod_nm = sheetObj.CellText(i, 'prc_trsp_mod_cd');
        			
        			if( rcv_de_term_cd != "D" && pnt_loc_cd == bse_port_loc_cd) { //Door term 일 경우에는 Point와 base port가 같을 수 있음
        				add2Tooltip(i, 'pnt_loc_cd', msgs['PRI01078']);
						add2Tooltip(i, 'bse_port_loc_cd', msgs['PRI01078']);
						isClear = false;
        			}
        			if(pnt_loc_cd.length == 0) {
		            	add2Tooltip(i, 'pnt_loc_cd', msgs['PRI00316'].replace('{?msg1}', 'Point'));	
		            	isClear = false;
        			}
        			if(pnt_loc_cd.length > 5) {
		            	add2Tooltip(i, 'pnt_loc_cd', msgs['PRI00307'].replace('{?msg1}', '5'));	
		            	isClear = false;
        			}        			
        			
        			if(hub_loc_cd.length > 5) {
		            	add2Tooltip(i, 'hub_loc_cd', msgs['PRI00307'].replace('{?msg1}', '5'));	
		            	isClear = false;
        			}
        			
        			if(bse_port_loc_cd.length == 0) {
		            	add2Tooltip(i, 'bse_port_loc_cd', msgs['PRI00316'].replace('{?msg1}', 'Base Port'));	
		            	isClear = false;
        			}
        			
        			if(bse_port_loc_cd.length > 5) {
        				add2Tooltip(i, 'bse_port_loc_cd',  msgs['PRI00307'].replace('{?msg1}', '5'));	
        				isClear = false;
        			}
        			
        			if(rcv_de_term_cd.length == 0) {
        				add2Tooltip(i, 'rcv_de_term_cd', msgs['PRI00316'].replace('{?msg1}', 'Term'));	
        				isClear = false;
        			} 
        			
        			if(prc_trsp_mod_cd.length == 0) {
        				add2Tooltip(i, 'prc_trsp_mod_cd', msgs['PRI00316'].replace('{?msg1}', 'Trans Mode'));	
        				isClear = false;
        			}
        			
        			if(rcv_de_term_nm.length > 0) {
        				var arrText = sText.split('|');
        				var ch = 0;
						for(var c = 0; c < arrText.length; c++) {
							if(rcv_de_term_nm == arrText[c]) {
								ch++;
							}
						}
						if(ch == 0) {
							add2Tooltip(i, 'rcv_de_term_cd', msgs['PRI03004'].replace('{?msg1}', rcv_de_term_nm));	
							isClear = false;								
						}
							
        			}	
        			
        			if(prc_trsp_mod_nm.length > 0) {
        				var arrText = mText.split('|');
        				var ch = 0;
						for(var c = 0; c < arrText.length; c++) {
							if(prc_trsp_mod_nm == arrText[c]) {
								ch++;
							}
						}
						if(ch == 0) {
							add2Tooltip(i, 'prc_trsp_mod_cd', msgs['PRI03004'].replace('{?msg1}', prc_trsp_mod_nm));	
							isClear = false;								
						}
							
        			}	
        			
        			if(chk.length > 0) {
        				for(var x = 0; x < chk.length; x++) {
		            		if(ComTrim(chk[x]) !="" && pnt_loc_cd !="" && ComTrim(chk[x]) == pnt_loc_cd) {
		            			add2Tooltip(i, 'pnt_loc_cd', msgs['PRI03004'].replace('{?msg1}', ComTrim(chk[x])));	
								isClear = false;		            			            			
		            		}
		            		if(ComTrim(chk[x]) !="" && hub_loc_cd !="" && ComTrim(chk[x]) == hub_loc_cd) {
		            			add2Tooltip(i, 'hub_loc_cd', msgs['PRI03004'].replace('{?msg1}', ComTrim(chk[x])));	
								isClear = false;		            			            			
		            		}
		            		if(ComTrim(chk[x]) !="" && bse_port_loc_cd !="" && ComTrim(chk[x]) == bse_port_loc_cd) {
		            			add2Tooltip(i, 'bse_port_loc_cd', msgs['PRI03004'].replace('{?msg1}', ComTrim(chk[x])));	
								isClear = false;				            			
		            		}
        				}	
	            	} 
        			
        			// local currency setting 
        			sheetObjects[0].CellValue2( i , "locl_curr_cd" ) = formObj.locl_curr_cd.value;       			
        		}
	            if (isClear) {
                	toggleButtons("CHECK");
	                return true;
	            } else {
	                toggleButtons("LOAD");
	                return false;
	            }
	            
				break;
			case IBSAVE: // save
					formObj.f_cmd.value = SEARCH01;
		            var sParam = FormQueryString(formObj);
		            var sXml = sheetObj.GetSearchXml("ESM_PRI_7014GS.do", sParam);
					var check_code = ComGetEtcData(sXml,"CHK_STATUS");
					if(!(check_code != undefined && check_code == 'I')) {
						ComShowCodeMessage("PRI07014");
						toggleButtons("DISABLED");
						return false;
					}
				break;	
        	
         }
         return true;
    }   	

	function clearTooltip() {
        var sheetObj = sheetObjects[0];
        var n = sheetObj.HeaderRows + sheetObj.RowCount;
        var m = sheetObj.LastCol;
        var i = sheetObj.HeaderRows;
        var j = 0;
        for (i = sheetObj.HeaderRows ; i < n; i++) {
            for (j = 0 ; j <= m ; j++) {
                if (sheetObj.ToolTipText(i, j) != "") {
                    sheetObj.CellBackColor(i, j) = sheetObj.EditableColor;
                    sheetObj.ToolTipText(i, j) = "";
                }
            }
        }
    }
    
	function add2Tooltip(row, col, msg) {
        var sheetObj = sheetObjects[0];
        	sheetObj.CellBackColor(row, col) = sheetObj.RgbColor(255,0,0);
        	sheetObj.ToolTipText(row, col) +="\n- " +  msg;

    }
    
 	/**
	 * OnChange 이벤트 발생시 호출되는 function <br>
	 * <br><b>Example :</b>
	 * <pre>
	 *
	 * </pre>
	 * @param {ibcombo} comboObj 필수 IBSheet Combo Object
	 * @param {int} code 필수 Onclick 이벤트가 발생한 해당  code
	 * @param {int} text 필수 화면에 표시된 글자
	 * @return 없음
	 * @author 이은섭
	 * @version 2012.06.01
	 */   
    function sheet1_OnChange(sheetObj, Row, Col, Value) {
        var colName = sheetObj.ColSaveName(Col);
        var formObj = document.form;
        if (colName == "pnt_loc_cd" || colName == "hub_loc_cd"|| colName == "bse_port_loc_cd" ) {
        	if(Value != "") {
				formObj.f_cmd.value = SEARCH02;
		        var sParam = FormQueryString(formObj);
		        	sParam += "&loc_cd=" + Value;
		        var sXml = sheetObj.GetSearchXml("ESM_PRI_7013GS.do", sParam);
				var check_code = ComGetEtcData(sXml,"CHK_STATUS");
				if(check_code == undefined || check_code == '0') {
					sheetObj.CellValue2(Row, Col) = '';
					if (colName == "pnt_loc_cd") {
						ComShowMessage(ComGetMsg("PRI03004", "Point"));
					} 
					if (colName == "hub_loc_cd") {
						ComShowMessage(ComGetMsg("PRI03004", "Hub"));
					} 
					if (colName == "bse_port_loc_cd") {
						ComShowMessage(ComGetMsg("PRI03004", "Base Port"));
					}					
					
				}
        	}        
        } 
        toggleButtons("LOAD"); //check 하고 난 후에 수정하면 다시 Save 버튼이 비활성화 됨
        
    } 

    /**
     * LoadExcel 이벤트 발생시 호출되는 function <br>
     * 엑셀파일 로드 후 정상이면 SHEET COLUMN 을 제어한다. <br>
     * 
     * HAMRU이아닐 경우 excel load 한 후에 45' cost가 입력되지 않도록 제어.
     * <br><b>Example :</b>
     * <pre>
     * 
     * </pre>
     * @param {ibsheet} sheetObj 필수 IBSheet Object
     * @return 없음
     * @author 최성민
     * @version 2009.06.25
     */
    function sheet1_OnLoadExcel(sheetObj) {
    	var formObj = document.form;
    	var topRow = sheetObj.TopRow;                                                                                                                                                                                                                                                                                                                                                                                                                                   
    	var lastRow = sheetObj.LastRow;
    	
		if(formObj.rhq_cd.value != "HAMRU") {
			for(var i=topRow; i<=lastRow; i++) {
				sheetObj.CellValue2(i, 'gline_45ft_frt_rt_amt' ) = "0";
			}
		}
    }
    
	function getJobStatus() {
		var jobStatus = null;		
		form.f_cmd.value = SEARCHLIST18;
		var sXml = sheetObjects[0].GetSearchXml("PRICommonGS.do", FormQueryString(form) + "&key=" + jobKey);
		jobStatus = ComGetEtcData(sXml, "JB_STS_FLG");

		if (jobStatus == "3") {
			clearInterval(timerID);

            isChanged = true;
            ComPriSaveCompleted();
            window.close();
		} else if (jobStatus == "4") {
			clearInterval(timerID);			
			ComShowCodeMessage("PRI00201");
			return false;
		}
	}