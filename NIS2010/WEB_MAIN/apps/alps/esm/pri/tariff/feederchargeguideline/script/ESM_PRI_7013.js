/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7013.js
*@FileTitle : EUR Add-on Guideline Creation / Amend – Load Excel
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 이은섭
*@LastVersion : 1.0
* 2012.05.30 이은섭
* 1.0 Creation
=========================================================
* History
* 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
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
     * @class Commodity Group : Commodity Group 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_PRI_7013() {
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
	
	                InitRowInfo(3, 1, 3, 100);
	                
	                var prc_io_bnd_nm = "";
	                if(document.form.org_dest_tp_cd.value == 'D') {
	                	prc_io_bnd_nm = "Destination";
	                } else {
	                	prc_io_bnd_nm = "Origin";
	                }	
	
	                var HeadTitle1 = "Sel|Seq.|"+prc_io_bnd_nm+"|Base Port|Contract\nTerm|Dry Tariff (USD)|Dry Tariff (USD)|Dry Tariff (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|Dry Total Cost|" +
									     "Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|" +
	                	             	 "RF SVC|RF Tariff (USD)|RF Tariff (USD)|RF Diff. (USD)|RF Diff. (USD)|RF Total Cost|RF Total Cost|RF Total Cost|RF Total Cost|RF Total Cost|RF Full trans cost (USD)|RF Full trans cost (USD)|RF MTY trans cost (USD)|RF MTY trans cost (USD)|RF TMNL cost (USD)|RF TMNL cost (USD)|RF M/B Ratio (%, in SCC)|RF M/B Ratio (%, in SCC)||||Remarks||Rhq";
	                var HeadTitle2 = "Sel|Seq.|"+prc_io_bnd_nm+"|Base Port|Contract\nTerm|Dry Tariff (USD)|Dry Tariff (USD)|Dry Tariff (USD)|Dry Diff. (USD)|Dry Diff. (USD)|Dry Diff. (USD)|USD|USD|USD|Local Currency|Local Currency|Local Currency|Local Currency|" +
								     	 "Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry Full trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry MTY trans cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry TMNL cost (USD)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|Dry M/B Ratio (%, in SCC)|" +
	                		             "RF SVC|RF Tariff (USD)|RF Tariff (USD)|RF Diff. (USD)|RF Diff. (USD)|USD|USD|Local Currency|Local Currency|Local Currency|RF Full trans cost (USD)|RF Full trans cost (USD)|RF MTY trans cost (USD)|RF MTY trans cost (USD)|RF TMNL cost (USD)|RF TMNL cost (USD)|RF M/B Ratio (%, in SCC)|RF M/B Ratio (%, in SCC)||||Remarks||Rhq";
	                var HeadTitle3 = "Sel|Seq.|"+prc_io_bnd_nm+"|Base Port|Contract\nTerm|20'|40'|45'|20'|40'|45'|20'|40'|45'|Cur.|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|20'|40'|45'|RF SVC|20'|40'|20'|40'|20'|40'|Cur.|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'||||Remarks||Rhq";
	                var headCount = ComCountHeadTitle(HeadTitle3);
	
	                // 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(headCount, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(false, true, true, true, false, false)
	
	                // 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle1, true);
	                InitHeadRow(1, HeadTitle2, true);
	                InitHeadRow(2, HeadTitle3, false);
	
	                InitDataProperty(0, cnt++, dtCheckBox, 		40, daCenter,  	true,  "chk",								false, "", 	dfNone, 0, true, true, 5 , false, false, '', true );	                
	                InitDataProperty(0, cnt++, dtDataSeq, 		50, daCenter,  	true,  "seq");
	                InitDataProperty(0, cnt++, dtData, 			0,	daCenter,  	true,  "pnt_loc_cd", 						true, "", 	dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtData, 			80, daCenter,  	true,  "bse_port_loc_cd", 					true, "", 	dfNone, 0, true, true, 5);
	                InitDataProperty(0, cnt++, dtCombo, 		70, daCenter,  	true,  "rcv_de_term_cd", 					true, "", 	dfNone, 0, true, true, 1);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "gline_20ft_frt_rt_amt", 			false, "", 	dfFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "gline_40ft_frt_rt_amt", 			false, "", 	dfFloat, 2, true, true, 9);
	                // 45' Cost 추가
	                if(document.form.rhq_cd.value == "HAMRU"){
	                	InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "gline_45ft_frt_rt_amt", 			false, "", 	dfFloat, 2, true, true, 9);
	                } else {
	                	InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "gline_45ft_frt_rt_amt", 			false, "", 	dfFloat, 2, false, false, 9);
	                }
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "diff_20ft", 						false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "diff_40ft", 						false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "diff_45ft", 						false, "", 	dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "cost_20ft_frt_rt_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "cost_40ft_frt_rt_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "cost_45ft_frt_rt_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, 	dtData, 			40,	daCenter, 	true, 	"locl_curr_cd", false, "", dfNone, 0, false, false,3); 
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "locl_curr_cost_20ft_frt_rt_amt", 	false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "locl_curr_cost_40ft_frt_rt_amt", 	false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "locl_curr_cost_45ft_frt_rt_amt", 	false, "", 	dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "trsp_20ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "trsp_40ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "trsp_45ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, 	dtData, 			80,	daRight,	true, 	"mty_trsp_20ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);    
	                InitDataProperty(0, cnt++, 	dtData, 			80,	daRight,	true, 	"mty_trsp_40ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 			80,	daRight,	true, 	"mty_trsp_45ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "tml_20ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "tml_40ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtData, 			80, daRight, 	true,  "tml_45ft_cost_amt", 				false, "", 	dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                InitDataProperty(0, cnt++, 	dtData, 			80, daRight, 	true, 	"mb_20ft_rto", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 			80, daRight,	true, 	"mb_40ft_rto", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 			80, daRight,	true, 	"mb_45ft_rto", false, "", dfNullFloat, 2, false, false, 9);		// 45' Cost 추가
	                
	                InitDataProperty(0, cnt++, 	dtCombo, 			50, 		daCenter,		true, 	"rc_svc_flg", false, "", dfNone, 2, true, true, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"gline_rf_20ft_frt_rt_amt", false, "" , dfNullFloat, 2, true, true, 9);                                           
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"gline_rf_40ft_frt_rt_amt", false, "" , dfNullFloat, 2, true, true, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"diff_rf_20ft", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"diff_rf_40ft", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"cost_rf_20ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);                                           
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"cost_rf_40ft_frt_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 			40,	daCenter, 	true, 	"locl_curr_cd_rf", false, "", dfNone, 0, false, false,3); 
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"locl_curr_cost_rf_20ft_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"locl_curr_cost_rf_40ft_rt_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"trsp_rf_20ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);                                           
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"trsp_rf_40ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"mty_trsp_rf_20ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);                                           
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,	 	true, 	"mty_trsp_rf_40ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"tml_rf_20ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"tml_rf_40ft_cost_amt", false, "", dfNullFloat, 2, false, false, 9);         
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"mb_rf_20ft_rto", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, 	dtData, 				80, 		daRight,		true, 	"mb_rf_40ft_rto", false, "", dfNullFloat, 2, false, false, 9);
	                InitDataProperty(0, cnt++, dtHidden, 			20, daLeft,   	true,  "A", 						false, "", 	dfNone, 0, true, true, 4000);	          
	                InitDataProperty(0, cnt++, dtHidden, 			20, daLeft,   	true,  "B", 						false, "", 	dfNone, 0, true, true, 4000);	          
	                InitDataProperty(0, cnt++, dtHidden, 			20, daLeft,   	true,  "C", 						false, "", 	dfNone, 0, true, true, 4000);	          

	                InitDataProperty(0, cnt++, dtData, 			200, daLeft,   	true,  "fdr_rt_rmk", 						false, "", 	dfNone, 0, true, true, 4000);	          
	                InitDataProperty(0, cnt++, dtHiddenStatus, 	30, daCenter,  	true, "ibflag");
	                InitDataProperty(0, cnt++, dtHidden, 		60,	daCenter,  	true,  "rhq_cd", 							true, "", 	dfNone, 0, true, true, 5);	                

	                sheetObj.CellBackColor(0,"gline_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(0,"gline_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(0,"gline_45ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);		// 45' Cost 추가
	                sheetObj.CellBackColor(1,"gline_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(1,"gline_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(1,"gline_45ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);		// 45' Cost 추가
	                sheetObj.CellBackColor(0,"gline_rf_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(0,"gline_rf_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(1,"gline_rf_20ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                sheetObj.CellBackColor(1,"gline_rf_40ft_frt_rt_amt") = sheetObj.RgbColor(209, 178, 255);
	                
	                sheetObj.SetMergeCell (0, 5, 2, 3);  
	                sheetObj.SetMergeCell (0, 8, 2, 3);  
		            sheetObj.SetMergeCell (0, 18, 2, 3);  
		            sheetObj.SetMergeCell (0, 21, 2, 3);  
		            sheetObj.SetMergeCell (0, 24, 2, 3); 
	                sheetObj.SetMergeCell (0, 27, 2, 3);  
	                //RF
	                sheetObj.SetMergeCell (0, 31, 2, 2); 
	                sheetObj.SetMergeCell (0, 33, 2, 2); 
	                sheetObj.SetMergeCell (0, 40, 2, 2); 
	                sheetObj.SetMergeCell (0, 42, 2, 2);  
	                sheetObj.SetMergeCell (0, 44, 2, 2);  
	                sheetObj.SetMergeCell (0, 46, 2, 2);  
	                
	                ShowButtonImage = 2;
	                ToolTipOption = "balloon:true;width:1000;icon:3;title:Load Excel";
	                
	                InitDataValid(0, "pnt_loc_cd", vtEngUpOnly);
	                InitDataValid(0, "bse_port_loc_cd", vtEngUpOnly);     
	               	InitDataValid(0, "fdr_rt_rmk", vtEngOther, '1234567890');
	                InitDataCombo(0, "rc_svc_flg", "YES|NO",    "Y|N");
	                InitDataValid(0, "locl_curr_cd", vtEngUpOnly);
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
            if (window.event == null || window.event.srcElement == null || window.event.srcElement.getAttribute("suppressWait") != "Y") {
                ComOpenWait(true);
            }
	        sheetObj.ShowDebugMsg = false;
	        switch (sAction) {
	            
			case IBSEARCH_ASYNC02: // Open
				var strFilePath = sheetObj.OpenFileDialog("Load Excel", "", "", "Excel Documents(*.xls; *.xlsx)|*.xls; *.xlsx");
				if (strFilePath != "<USER_CANCEL>") {
					sheetObj.LoadExcel( 1, 1, strFilePath, -1, -1, "", false, false, "");
				}
				if (sheetObj.RowCount > 0) {
					toggleButtons("LOAD");
				} else {
					toggleButtons("INIT");
				}
		        
		     	break;
	        
	        case IBSEARCH_ASYNC01: // Check
	        	ComOpenWait(true);
	            if (!validateForm(sheetObj, document.form, sAction)) {
	                return false;
	            }
	            break;
	        
	        case IBSAVE: // Save
	        	{
		            if (!validateForm(sheetObj,document.form,sAction)) {
		                return false;
		            }
		            
		            if (!ComPriConfirmSave()) {
		                return false;
		            }	
		            
	                formObj.f_cmd.value = MULTI;
	                var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true);
	                var sXml = sheetObj.GetSaveXml("ESM_PRI_7013GS.do", sParam);
	                sheetObj.LoadSaveXml(sXml);
	                if (sXml.indexOf("ERROR") >= 0) {
	                    return false;
	                }
	                isChanged = true;
	                ComPriSaveCompleted();
	                window.close();
				}	                    
	            break;
			case IBDOWNEXCEL:
				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", "", false, "", true);
				break;	            
	            
	        case IBCLEAR: // 화면 로딩시 
	            var sXml = ""; 
	            formObj.f_cmd.value = SEARCH19;
	            sXml = sheetObj.GetSearchXml("PRICommonGS.do", FormQueryString(formObj) + "&cd=CD03074");
	            setIBCombo(sheetObj, sXml, "rcv_de_term_cd", true, 0);
	            // formObj.f_cmd.value = SEARCH03;
	            //var sXml1 = sheetObj.GetSearchXml("ESM_PRI_7013GS.do", FormQueryString(formObj));
	            //setIBCombo(sheetObj, sXml1, "rhq_cd", false, 0);
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
        } finally {
        	ComOpenWait(false);
        }       
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
            	
        		//Point,Base Port 의 중복 체크
        		var duprows2 = sheetObj.ColValueDupRows("pnt_loc_cd|bse_port_loc_cd", false, true);
        		if(duprows2 != '') {
					var arrRow = duprows2.split("|");
					for (idx=0; idx < arrRow.length; idx++) {
						var duprows = arrRow[idx].split(",");
						for (var x=0; x < duprows.length; x++) {
							add2Tooltip(duprows[x], 'pnt_loc_cd', msgs['PRI00302']);
							add2Tooltip(duprows[x], 'bse_port_loc_cd', msgs['PRI00302']);
							isClear = false;
						}
					 }
        		}
        		
        		//Point - Base Port 체크, Length 체크
    			//Point 및 Base Port 값이 mdm_location 테이블에 존재 여부 체크.
	            formObj.f_cmd.value = SEARCH;
	            var sParam = FormQueryString(formObj) + "&" + sheetObj.GetSaveString(true);
	            var sXml = sheetObj.GetSearchXml("ESM_PRI_7013GS.do", sParam);
	            var check_code = ComGetEtcData(sXml,"CHECK_CODE");
	            var chk = check_code.split(",");
	            
	            var sText = sheetObj.GetComboInfo(sheetObj.LastRow, 'rcv_de_term_cd', 'Text');
            	for(var i = sheetObj.HeaderRows; i < sheetObj.HeaderRows + sheetObj.RowCount; i++) {
            		sheetObj.CellValue2(i, 'rhq_cd') = formObj.rhq_cd.value ;
        			var pnt_loc_cd = sheetObj.CellValue(i, 'pnt_loc_cd');
        			var bse_port_loc_cd = sheetObj.CellValue(i, 'bse_port_loc_cd');
        			var rcv_de_term_cd = sheetObj.CellValue(i, 'rcv_de_term_cd');
        			var rcv_de_term_nm = sheetObj.CellText(i, 'rcv_de_term_cd');
        			if( pnt_loc_cd == bse_port_loc_cd) {
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
        			
        			if(chk.length > 0) {
        				for(var x = 0; x < chk.length; x++) {
		            		if(ComTrim(chk[x]) == pnt_loc_cd) {
		            			add2Tooltip(i, 'pnt_loc_cd', msgs['PRI03004'].replace('{?msg1}', ComTrim(chk[x])));	
								isClear = false;		            			            			
		            		}
		            		if(ComTrim(chk[x]) == bse_port_loc_cd) {
		            			add2Tooltip(i, 'bse_port_loc_cd', msgs['PRI03004'].replace('{?msg1}', ComTrim(chk[x])));	
								isClear = false;				            			
		            		}
        				}	
	            	}     
                    // RF SVC 를 선택 안했을 경우
                    if (sheetObj.CellValue(i, "rc_svc_flg") == "") {
            			add2Tooltip(i, 'rc_svc_flg', msgs['PRI01042'].replace('{?msg1}', 'RF SVC'));	
						isClear = false;	
                    }
                	// RF SVC 값이 없을 경우 (RF SVC FLAG N 제외)
                    if (sheetObj.CellValue(i, "rc_svc_flg") != "N") {
                    	if(sheetObj.CellValue(i, "gline_rf_20ft_frt_rt_amt") == ""){
	            			add2Tooltip(i, 'gline_rf_20ft_frt_rt_amt', msgs['PRI01042'].replace('{?msg1}', '20 RF Tariff (USD)'));	
							isClear = false;	
                    	}
                    	
                    	if(sheetObj.CellValue(i, "gline_rf_40ft_frt_rt_amt") == ""){
	            			add2Tooltip(i, 'gline_rf_40ft_frt_rt_amt', msgs['PRI01042'].replace('{?msg1}', '40 RF Tariff (USD)'));	
							isClear = false;	
                    	}
                    }
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
		            var sXml = sheetObj.GetSearchXml("ESM_PRI_7013GS.do", sParam);
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
        
        if (colName == "pnt_loc_cd" || colName == "bse_port_loc_cd" ) {
        	if(Value != '') {
				formObj.f_cmd.value = SEARCH02;
		        var sParam = FormQueryString(formObj);
		        	sParam += "&loc_cd=" + Value;
		        var sXml = sheetObj.GetSearchXml("ESM_PRI_7013GS.do", sParam);
				var check_code = ComGetEtcData(sXml,"CHK_STATUS");
				if(check_code == undefined || check_code == '0') {
					sheetObj.CellValue2(Row, Col) = '';
				}
        	}
        } 
        
        if (colName ==  "rc_svc_flg"){
	        if (Value == "N") {
	            sheetObj.CellValue(Row, "gline_rf_20ft_frt_rt_amt") = "";
	            sheetObj.CellValue(Row, "gline_rf_40ft_frt_rt_amt") = "";
				sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = false;   
				sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = false;   
                sheetObj.CellBackColor(Row, "gline_rf_20ft_frt_rt_amt") = sheetObj.UnEditableColor ;
                sheetObj.ToolTipText(Row, "gline_rf_20ft_frt_rt_amt") = "";
                sheetObj.CellBackColor(Row, "gline_rf_40ft_frt_rt_amt") = sheetObj.UnEditableColor;
                sheetObj.ToolTipText(Row, "gline_rf_40ft_frt_rt_amt") = "";
	        } else {
				sheetObj.CellEditable(Row, "gline_rf_20ft_frt_rt_amt") = true;   
				sheetObj.CellEditable(Row, "gline_rf_40ft_frt_rt_amt") = true;                
				 sheetObj.CellBackColor(Row, "gline_rf_20ft_frt_rt_amt") = sheetObj.EditableColor;
				 sheetObj.CellBackColor(Row, "gline_rf_40ft_frt_rt_amt") = sheetObj.EditableColor;
	        }
        }
        
        toggleButtons("LOAD");
    } 
	/**
	 * OnLoadExcel 이벤트 발생시 호출되는 function <br>
	 * 
	 * @return 없음
	 * @author 이은섭
	 * @version 2012.06.01
	 */   
    function sheet1_OnLoadExcel(obj) {
    	var formObj = document.form;
		var n = obj.HeaderRows + obj.RowCount;
        for (var i = obj.HeaderRows ; i < n; i++) {
        	var rqh_cd = obj.CellValue(i, 'rhq_cd');
        	if(rqh_cd == '' || rqh_cd == undefined) {
        		//obj.CellValue2(i, 'rhq_cd') = comboCode[0];
        		obj.CellValue2(i, 'rhq_cd') = formObj.rhq_cd.value ;
        	}
        } 
    }