/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0079_04.js
*@FileTitle : Container Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.19 김영출
* 1.0 Creation
===============================================================================
 History
 2010.09.13 이일민 [CHM-201005276-01] ALPS-[BKG/DOC]주요UI버턴-단축키 기능개발
 2010.11.22 이일민 [CHM-201006893-01] CRD P/Pu 기능 로직 보완
 2010.12.15 전성진 [CHM-201007196] CRD P/Pu 기능 로직 보완 - Save할때 저장으로 기능변경
 2011.01.27 이일민 [CHM-201108410-01] [CSR] Container OC History Table 항목 추가
 2011.04.12 정선용 [CHM-201109867-01] China 24HR Container Seal Kind/Code로직 추가
 2012.01.25 전성진 [] Seal No pop-up 호출 이후 Ibflag가 Insert인 경우 그대로 유지하게 변경
 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 2012.07.04 이준근 [CHM-201218427-01 ] CNTR Seal # 중복 입력 방지 (Seal No가 모두 숫자일 경우 만 중복 체크)
 2012.08.03 변종건 [CHM-201219358-01] [CNTR 화면] R/D Term Validation: Mixted 입력방지
 2015.06.08 양동훈 [CHM-201536025] 중국향 부킹에 한하여 Seal Kind Code 의 Mandtory 적용 요청
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
     * @class esm_bkg_0079_04 : esm_bkg_0079_04 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0079_04() {
        this.processButtonClick   = processButtonClick;
        this.setSheetObject       = setSheetObject;
        this.loadPage             = loadPage;
        this.initSheet            = initSheet;
        this.initControl          = initControl;
        this.doActionIBSheet      = doActionIBSheet;
        this.setTabObject         = setTabObject;
        this.validateForm         = validateForm; 
    }

    /* 개발자 작업    */

 
    // 공통전역변수
    var sheetObjects = new Array();
    var sheetCnt = 0;
	var cur_usr_id = '';
	var before_edit_val = '';
	var scrnAuth = '';
	var rcv_term_str = "Y|D|S|T|I";
	var del_term_str = "Y|D|S|T|O";
	var seal_knd_str = "| |M|E";
	var seal_knd_str2 = "| |M\tMechanical|E\tElectronic";
	var seal_pty_tp_str = "| |SH|CA|AA|CU|AB|AC|TO";
	var seal_pty_tp_str2 = "| |SH\tShipper|CA\tCarrier|AA\tConsolidator|CU\tCustoms|AB\tUnknown|AC\tAgency|TO\tTerminal Operator";
	var tpsz_chk = true;
	var isWarnMsg = false;
	var cntrs;
	var isCrdUpdate = false;
	var decision_flag = -1; //0-NO, 1-Yes, 2-Close
	var eurFlg = "Y";

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한다. *****/
         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4];
         /*******************************************************/
         var formObject = document.form;

        try {
            var srcName = window.event.srcElement.getAttribute("name");

    		if(srcName != "btn_splitPop"){
        		if(layList.style.display != "none"){
        			layList.style.display = "none";
        		}    	    			
    		}
			
			switch(srcName) {
				case "btn_splitPop":			
					doActionIBSheet(sheetObject1,formObject,COMMAND04);					
				break;
				
				case "btn_CargoDtl":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_0890.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_0890", 800, 430, true);
				break;
								
				case "btn_VarianceDtl":
					var bkg_no = formObject.bkg_no.value;
					var url = "ESM_BKG_1051.do?func=&bkg_no="+bkg_no;
					ComOpenWindowCenter(url, "ESM_BKG_1051", 860, 470, true);
				break;
				
				case "btn_t6retrieve":
					// 변경된 값이 있을 경우
					//alert("before search -> dirty_flag = " + formObject.dirty_flag.value);
					if(formObject.dirty_flag.value == 'Y' && confirm(ComGetMsg("BKG00824"))){
						var rflag = doActionIBSheet(sheetObject2, formObject, IBSAVE);
						//alert("before search -> rflag = " + rflag);
//						if(rflag) doActionIBSheet(sheetObject2,formObject,IBSEARCH) ;
					}else{
						doActionIBSheet(sheetObject2,formObject,IBSEARCH) ;
					}
				break;

				case "btn_t6save":
					if(ComIsBtnEnable("btn_t6save")){
						formObject.modify_fnl_cfm_flg.value = 'N';
						// confirm 'Save'
						//if(confirm(ComGetMsg("BKG00254"))){
							doActionIBSheet(sheetObject2, formObject, IBSAVE);
						//}
					}
				break;

				case "btn_t6downexcel":
					//sheetObject2.Down2Excel([Mode],[UseOpenFile],[NewSheet],[Merge],[SaveAsName],[ReportPageUrl],
					//                        [HideExcelMsg],[WriteTreeLevel],[WorkSheetName],[FocusFirstSheet],
					//                        [ColumnSkipList],[RowSkipList],[bProtect],[bFormula], [IncludeImageType])
                    //sheetObject2.SpeedDown2Excel([Mode], [UseOpenFile], [NewSheet], [SaveAsName],[ReportPageUrl],
                    //                        [HideExcelMsg],[WriteTreeLevel], [WorkSheetName],[FocusFirstSheet],
                    //                        [ColumnSkipList],[RowSkipList],[bProtect]) 					
					//sheetObject2.Down2Excel(-1, true, true, false, '', '', false, false, '', false, "ibflag|cntr_dp_seq|sel|PCKPop");
					sheetObject2.SpeedDown2Excel(-1, true, true, '', '', false, false, '', false, "ibflag|cntr_dp_seq|sel|SEALPop|PCKPop");
				break;

				case "btn_t6print":
					 if(formObject.bkg_no.value == '' ){
						  ComShowMessage(ComGetMsg("BKG00463"));
						  formObject.bkg_no.focus();
					 }else{
						var strTitle = "Container Report";
						var strToolbar = "0;2;3;12;13;14;15;16;17";
						var strPath = "apps/alps/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/ESM_BKG_0919.mrd";
						var rvParam = "/rp ["+ formObject.bkg_no.value +"] /riprnmargin";
						formObject.elements["com_mrdPath"     ].value = strPath;
						formObject.elements["com_mrdArguments"].value = rvParam;
						formObject.elements["com_mrdDisableToolbar"].value = strToolbar;
						formObject.elements["com_mrdTitle"    ].value = strTitle;
						formObject.elements["com_mrdBodyTitle"].value = "<span style='color:red'>"+strTitle+"</span>";
						ComOpenRDPopup("width=800, height=800");
					 }
					//alert("btn_t6print --> UI_BKG-0919");
					//ComOpenWindow("ESM_BKG_0369.do", "ESM_BKG_0919", "width=640,height=480", false);
					break;

				case "btn_t6cntrconfirm":
					if(ComIsBtnEnable("btn_t6cntrconfirm")){
						var rflag = doActionIBSheet(sheetObject2, formObject, COMMAND01);
						if(rflag){
							changeEditableByConfirm("CFM");
						}
					}
				break;

				case "btn_t6cntrrelease":
					if(!confirm(ComGetMsg("BKG00181"))){
						return false;
					}
					
					if(ComIsBtnEnable("btn_t6cntrrelease")){
						var rflag = doActionIBSheet(sheetObject2, formObject, MULTI02);
						if(rflag){
							changeEditableByConfirm("RLS");
						}						
					}
				break;

				case "btn_t6cntrhist":
					var srow = sheetObjects[1].SelectRow;
					var tmp = sheetObjects[1].CellValue(srow, "cntr_no");
					
					var cntrNo = (tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
                    var checkDigit = (tmp != null && tmp.length>10) ? tmp.substring(10) : '';
					var typeSize = sheetObjects[1].CellValue(srow, "cntr_tpsz_cd");
					
					var url = "EES_CTM_0411.do?func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize+"&pop_mode=1";
					//alert(url);
					ComOpenWindowCenter(url, "EES_CTM_0411", 1020, 682, false);
				break;

				case "btn_t6notupdated":
					//alert("btn_t6notupdated --> UI_BKG-0901");
					var url = "ESM_BKG_0901.do?func=callbackNotUpdatedContainer&bkg_no=" + formObject.bkg_no.value;
					ComOpenWindowCenter(url, "ESM_BKG_0901", 625, 340, false);
				break;

				case "btn_t6gridcntrirr":
					if(ComIsBtnEnable("btn_t6gridcntrirr")){
						doActionIBSheet(sheetObject2, formObject, MODIFY01);
					}
				break;
				//+"&s_amdt_seq="+ctrt_amdt_seq
				case "btn_t6gridcntrodcy":  
					if(ComIsBtnEnable("btn_t6gridcntrodcy")){
						var bkgNo = ComGetObjValue(formObject.bkg_no);
					
						rValue =ComOpenPopup("/hanjin/ESM_BKG_1134.do?mainPage=false&bkg_no="+bkgNo,650, 450, "getBKG_1134","1,0,1,1,1", true,true);
						getBKG_1134(rValue);
					}
					break;
					
				case "btn_t6gridadd":
					if(ComIsBtnEnable("btn_t6gridadd")){
						doActionIBSheet(sheetObject2, formObject, IBINSERT);
					}
				break;

				case "btn_t6griddel":
					if(ComIsBtnEnable("btn_t6griddel")){
						doActionIBSheet(sheetObject2, formObject, IBDELETE);
					}
				break;

				case "btn_t6gridmove":
					if(ComIsBtnEnable("btn_t6gridmove")){
						if(validateForm(sheetObject2, formObject, COMMAND03)) {
							var bkg_no = formObject.bkg_no.value;
							var cntrNos = "";
							var cntrvols ="";
							
							var arrRow = ComFindText(sheetObject2,"sel", 1);
							if (arrRow && 0 < arrRow.length) {
								for ( var i = 0; i < arrRow.length; i++) {
									cntrNos += sheetObject2.CellValue(arrRow[i], "cntr_no")
											+ ",";
									cntrvols += sheetObject2.CellValue(arrRow[i], "cntr_vol_qty")
									+ ",";
								}
								if (0 < cntrNos.indexOf(","))
									cntrNos = cntrNos.substring(0, cntrNos.length - 1);
								if (0 < cntrvols.indexOf(","))
									cntrvols = cntrvols.substring(0, cntrvols.length - 1);
//								if (1000 < bkgNos.split(",").length) {
//									ComShowCodeMessage("BKG08124", 500); // You select more
//																			// than {?msg1} B/Ls
//																			// for B/L print.
//																			// Max is {?msg1}
//																			// B/Ls one time
//									return;
//								}
							} else {
								ComShowCodeMessage("COM12176");
								return false;
							}
							
							
							
							var url = "ESM_BKG_0170.do?func=callbackMove&bkg_no="+bkg_no+"&cntr_no="+cntrNos+"&cntr_vol="+cntrvols;
							//ComOpenWindow(url, "ESM_BKG_0170", "width=300,height=360", false);
							ComOpenWindowCenter(url, "ESM_BKG_0170", 405, 500, true);
						}
					}
				break;

				case "btn_t6sequp":
					if(ComIsBtnEnable("btn_t6sequp")){
						//alert(sheetObject2.HeaderRows + " <- " + sheetObject2.SelectRow);
						if(sheetObject2.RowCount == 0 || sheetObject2.HeaderRows == sheetObject2.SelectRow) return;
						sheetObject2.DataMove(sheetObject2.SelectRow-1);
						setSeq(true);
						//
						formObject.dirty_flag.value = 'Y';
					}
				break;

				case "btn_t6seqdown":
					if(ComIsBtnEnable("btn_t6seqdown")){				
						//alert(sheetObject2.SelectRow + " -> " + sheetObject2.LastRow);
						if(sheetObject2.RowCount == 0 || sheetObject2.LastRow == sheetObject2.SelectRow) return;
						sheetObject2.DataMove(sheetObject2.SelectRow+2);
						setSeq(true);
						//
						formObject.dirty_flag.value = 'Y';
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

        for(i=0;i<sheetObjects.length;i++){

            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );
			//initSheet
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
			//
			sheetObjects[i].WaitImageVisible=false;
        }
		
		//iframe 생성 
    	//CofigIframe();
        
    	//------------------------------------------------>
    	//setInquiryDisableButton 이벤트 호출
   		setInquiryDisableButton();
     	//------------------------------------------------>

        // set init-data for sheets
		if(document.form.bkg_no.value != ''){
			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
		}

        initControl();
    }

	function initControl() {
        //add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
        axon_event.addListenerForm('blur', 'form1_blur', document.form);
        axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
        axon_event.addListenerForm('change', 'form1_change', document.form);
        axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
        applyShortcut();
	}
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        var sheetID = sheetObj.id;

        switch(sheetID) {

            case "t6sheet1":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 102;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(5, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "BKG NO|TP/SZ|BKG Q'ty|CNTR Q'ty|OF Q'ty";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,  WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,        KEYFIELD,  CALCULOGIC,  DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHidden,  40,    daCenter,   false,    "bkg_no",        false,    "",          dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,    90,    daCenter,   false,    "cntr_tpsz_cd",  false,    "",          dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,    100,    daRight,    false,    "op_cntr_qty",   false,    "",          dfFloat,    2,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,    100,    daRight,    false,    "bkg_cntr_qty",  false,    "",          dfFloat,    2,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,    50,    daRight,    false,    "of_qty",        false,    "",          dfFloat,    2,        true,        true);
                    
                    CountPosition = 0;
                }
            break;

            case "t6sheet2":
                with (sheetObj) {

                    // 높이 설정
                    style.height = 260;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 2, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(51, 8, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "|Sel.|Seq.|Bkg No|C|Old No.|Container No.|TS|Seal No.1|Kind/Code|Kind/Code|Seal No.2|Kind/Code|Kind/Code| |Package|Package|Package|Weight|Weight|VGM|VGM|Signature|Verif. Date|Deter. Date|Method|Measure|Measure|R/D Term|R/D Term|P|Vol|AS|ST|HG|DG|BB|AK|RF|RD|SOC|OF|LBP|ORG YD|Event Date|CRD|Remark(s)|CM Flg|dcgo_cnt|CM CFRM FLG";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH,  DATAALIGN,  COLMERGE,  SAVENAME,            KEYFIELD,  CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++,  dtHiddenStatus, 20,    daCenter,   false,     "ibflag");
                    InitDataProperty(0, cnt++,  dtDummyCheck,   30,    daCenter,   false,     "sel");
                    InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cntr_dp_seq",       false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtHidden,       80,    daCenter,   false,     "bkg_no",            false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,       20,    daCenter,   false,     "cntr_cfm_flg",      false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,       90,    daCenter,   false,     "cntr_no_old",       false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         90,    daCenter,   false,     "cntr_no",           false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cntr_tpsz_cd",      false,     "",      dfNone,    0,        false,       false);
                    InitDataProperty(0, cnt++,  dtData,         70,    daCenter,   false,     "seal1_no",          false,     "",      dfNone,    0,        true,        true, 15);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daCenter,   false,     "seal1_knd_cd",      false,     "",      dfNone,    0,        true,        true);

                    InitDataProperty(0, cnt++,  dtCombo,        40,    daCenter,   false,     "seal1_pty_tp_cd",   false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         70,    daCenter,   false,     "seal2_no",          false,     "",      dfNone,    0,        true,        true, 15);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daCenter,   false,     "seal2_knd_cd",      false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtCombo,        40,    daCenter,   false,     "seal2_pty_tp_cd",   false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,   false,     "SEALPop",           false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         70,    daRight,    false,     "pck_qty",           false,     "",      dfNullInteger, 0,        true,        true, 7);
                    InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "pck_tp_cd",         false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtPopup,        20,    daCenter,   false,     "PCKPop",            false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "cntr_wgt",          false,     "",      dfFloat,   3,        true,        true, 13);
                    InitDataProperty(0, cnt++,  dtHidden,       30,    daRight,    false,     "wgt_ut_cd",         false,     "",      dfNone,    0,        true,        true);

                    InitDataProperty(0, cnt++,  dtData,         90,    daRight,    false,     "vgm_wgt",           false,     "",      dfFloat,   3,        true,        true, 13);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daRight,    false,     "vgm_wgt_ut_cd",     false,     "",      dfNone,    0,        true,        true);
                   
                    InitDataProperty(0, cnt++,  dtData,         90,    daCenter,   false,     "vgm_vrfy_sig_ctnt", false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,      140,    daCenter,   false,     "vgm_vrfy_dt", 	   false,     "",      dfDateYmd, 0,        true,        true, 8);
                    InitDataProperty(0, cnt++,  dtHidden,      140,    daCenter,   false, 	  "vgm_dtmn_dt", 	   false,     "",      dfDateYmd, 0,        true,        true, 8);
                    InitDataProperty(0, cnt++,  dtCombo,        90,    daCenter,   false,     "vgm_mzd_tp_cd",     false,     "",      dfNone,    0,        true,        true);
                    
                    
                    InitDataProperty(0, cnt++,  dtData,         70,    daRight,    false,     "meas_qty",          false,     "",      dfFloat,   3,        true,        true, 9);
                    InitDataProperty(0, cnt++,  dtHidden,       30,    daRight,    false,     "meas_ut_cd",        false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daCenter,   false,     "rcv_term_cd",       false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daCenter,   false,     "de_term_cd",        false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtCheckBox,     20,    daCenter,   false,     "cntr_prt_flg",      false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtData,         30,    daRight,    false,     "cntr_vol_qty",      false,     "",      dfFloat,   2,        true,        true);
                    InitDataProperty(0, cnt++,  dtCombo,        30,    daCenter,   false,     "adv_shtg_cd",       false,     "",      dfNone,    0,        true,        true, 1);
                    InitDataProperty(0, cnt++,  dtData,         30,    daCenter,   false,     "cnmv_sts_cd",       false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "hngr_flg",          false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "dcgo_flg",          false,     "",      dfNone,    0,        false,        false);

                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "bb_cgo_flg",        false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "awk_cgo_flg",       false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "rc_flg",            false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "rd_cgo_flg",        false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "soc_flg",           false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "one_wy_free_flg",   false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtCheckBox,     30,    daCenter,   false,     "lbp_flg",		    false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtData,         60,    daCenter,   false,     "org_yd_cd",         false,     "",      dfNone,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtData,        100,    daCenter,   false,     "cnmv_evnt_dt",      false,     "",      dfUserFormat2,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtData,        100,    daCenter,   false,     "cgo_rcv_dt",        false,     "",      dfUserFormat2,    0,        false,        false);
                    InitDataProperty(0, cnt++,  dtData,        120,    daCenter,   false,     "diff_rmk",          false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,      120,    daCenter,   false,     "cm_flg",            false,     "",      dfNone,    0,        true,        true);

                    InitDataProperty(0, cnt++,  dtHidden,      120,    daCenter,   false,     "dcgo_cnt",          false,     "",      dfNone,    0,        true,        true);
                    InitDataProperty(0, cnt++,  dtHidden,        0,    daCenter,   false,     "cgo_rcv_dt_flg",    false);
                    InitDataProperty(0, cnt++,  dtHidden,       20,    daCenter,   false,     "mf_cfm_flg",        false,     "",      dfNone,    0,        true,        true);
                    
                    ShowButtonImage = 2;
                    PopupImage = "/hanjin/img/btns_calendar.gif";

					InitDataCombo(0, "seal1_knd_cd", seal_knd_str2, seal_knd_str);
                    InitDataCombo(0, "seal1_pty_tp_cd",  seal_pty_tp_str2, seal_pty_tp_str);
					InitDataCombo(0, "seal2_knd_cd", seal_knd_str2, seal_knd_str);
                    InitDataCombo(0, "seal2_pty_tp_cd",  seal_pty_tp_str2, seal_pty_tp_str);
					InitDataCombo(0, "rcv_term_cd", rcv_term_str, rcv_term_str);
                    InitDataCombo(0, "de_term_cd",  del_term_str, del_term_str);
					InitDataCombo(0, "adv_shtg_cd", " |A|S", " |A|S");
					InitDataCombo(0, "vgm_wgt_ut_cd", " |KGS|LBS", " |KGS|LBS");
//					InitDataCombo(0, "vgm_mzd_tp_cd", " |SHP|SM1|SM2|DRF", " |SHP|SM1|SM2|DRF");

					InitUserFormat2(0, "cnmv_evnt_dt", "####-##-## ##:##", "-|:");
					InitUserFormat2(0, "cgo_rcv_dt",   "####-##-## ##:##", "-|:");
					
//					InitDataValid(0,  "seal1_no",			vtEngUpOther,	"1234567890");
//					InitDataValid(0,  "seal2_no",			vtEngUpOther,	"1234567890");
					InitDataValid(0,  "seal1_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/? ");
					InitDataValid(0,  "seal2_no",   	vtEngOther, "1234567890~!@#$%^&*()--_+={}[]|\:;<.>/? ");

					SelectHighLight = false;
					DataAutoTrim = false;
                }
           break;

            case "t6sheet3":

                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);

                    var HeadTitle = "||bkg no|cntr no|Seal Seq.|Seal No|knd_cd|pty_tp|pty_nm|Print|old_cntr_no";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);


                    //데이터속성    [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN, COLMERGE,  SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtStatus,       30,    daCenter,  true,     "ibflag");
                    InitDataProperty(0, cnt++ , dtDummyCheck,   0,     daCenter,  false,    "sel");
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  false,    "bkg_no",         false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  false,    "cntr_no",        false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  false,    "cntr_seal_seq",  false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         110,   daCenter,  false,    "cntr_seal_no",   false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++,  dtData,         40,    daCenter,  false,    "seal_knd_cd",    false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++,  dtData,         50,    daCenter,  false,    "seal_pty_tp_cd", false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         80,    daLeft,    false,    "seal_pty_nm",    false,    "",         dfNone,     2,          true,        true);
                    InitDataProperty(0, cnt++ , dtCheckBox,     70,    daCenter,  false,    "prn_flg",        false,    "",         dfNone,     0,          true,        true);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  false,    "old_cntr_no",    false,    "",         dfNone,     0,          true,        true);

                    CountPosition = 0;
                }
            break;

            case "t6sheet4":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
					//MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(8, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

					var HeadTitle = "|Cntr No.|Booking No.|Vol.|Current|Adjusted|S/O|Special CGO";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL, DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtStatus,       20,    daCenter,  true,  "ibflag");
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,  "cntr_no",       false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         100,   daCenter,  true,  "bkg_no",        false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "bkg_vol",       false,    "",         dfFloat,    2,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "cntr_vol_qty",  false,    "",         dfFloat,    2,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daRight,   true,  "adj_vol_qty",   false,    "",         dfFloat,    2,          true,      true);

                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,  "spcl_flg",      false,    "",         dfNone,     0,          false,     false);
                    InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,  "so_flg",        false,    "",         dfNone,     0,          false,     false);

			   }
            break;
			
            case "t6sheet5":
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;
					//MergeSheet = msAll;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(20, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "TP/SZ|Category|DR|DG|RF|AK|BB|HG|SOC|R Term|R Term|R Term|R Term|R Term|D Term|D Term|D Term|D Term|D Term|Vol";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

					//데이터속성    [ROW, COL, DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,       KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtData,         40,    daCenter,  true,    "cntr_tpsz_cd", false,    "",        dfNone,     0,          true,       true);   
					InitDataProperty(0, cnt++, dtData,         60,    daCenter,  true,    "category",     false,    "",         dfNone,     0,          true,       true);     
					                                                                                                                                     
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "dry_cgo_flg",  false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "dcgo_flg",     false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "rc_flg",       false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "awk_cgo_flg",  false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "bb_cgo_flg",   false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "hngr_flg",     false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "soc_flg",      false,    "",         dfFloat,    2,          true,       true);      
					                                                                                                                                     
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "rcv_term_y",   false,    "",         dfFloat,    2,          true,       true);                                                
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "rcv_term_d",   false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "rcv_term_s",   false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "rcv_term_t",   false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "rcv_term_i",   false,    "",         dfFloat,    2,          true,       true);      
					                                                                                                                                     
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "de_term_y",    false,    "",         dfFloat,    2,          true,       true);                                                 
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "de_term_d",    false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "de_term_s",    false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "de_term_t",    false,    "",         dfFloat,    2,          true,       true);      
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  false,    "de_term_o",    false,    "",         dfFloat,    2,          true,       true);      
					                                                                                                                                     
					InitDataProperty(0, cnt++, dtData,         40,    daRight,  true,    "op_cntr_qty",  false,    "",         dfFloat,    2,          true,       true);     

			   }
            break;

        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
     //   sheetObj.ShowDebugMsg = 1;
        switch(sAction) {

            case IBSEARCH:
                if(validateForm(sheetObj,formObj,sAction)) {
				try {
					ComOpenWait(true); 
					isCrdUpdate = false;
					
					ComBtnEnable("btn_t6save");
					ComBtnEnable("btn_t6cntrconfirm");
					ComBtnEnable("btn_t6cntrrelease");
					ComBtnEnable("btn_t6gridcntrirr");
					ComBtnEnable("btn_t6gridadd");
					ComBtnEnable("btn_t6griddel");
					ComBtnEnable("btn_t6gridmove");
					ComBtnEnable("btn_t6sequp");
					ComBtnEnable("btn_t6seqdown");
					// sheet
					sheetObjects[0].Editable = true;
					sheetObjects[1].Editable = true;
					sheetObjects[2].Editable = true;
					// object
					formObj.bkg_wgt_ut_cd.disabled = false;
					formObj.bkg_meas_ut_cd.disabled = false;
					
                    formObj.f_cmd.value = SEARCH;
                    //sheetObj.DoSearch("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
                    var rXml = sheetObj.GetSearchXml("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
					if(rXml == '' || rXml.length < 7) return false;
					if(rXml.substring(1, 6) == "ERROR"){
						//alert(ComResultMessage(rXml).split('<||>').join('\n'));
						ComShowMessage(ComResultMessage(rXml));
						return false;
					}
					
                    var arrXml = rXml.split("|$$|");
					if(arrXml.length == 5){
						// xml array
						var etcXml  = arrXml[0];
						var qtyXml  = arrXml[1];
						var sealXml = arrXml[2];
						var volXml  = arrXml[3];
						var vgmXml  = arrXml[4];
						
						//vgm code
						var arrData = ComBkgXml2ComboString(vgmXml, "val", "multidesc");
					    arrData[1] =" \t |"+ arrData[1].replace("|A","|N/A");
					    arrData[0] =" |"+ arrData[0];
					    sheetObjects[1].InitDataCombo(0,"vgm_mzd_tp_cd", arrData[1], arrData[0]);
						
						// qty sheet
						sheetObjects[0].LoadSearchXml(qtyXml, false);
						// container sheet
						sheetObjects[1].LoadSearchXml(etcXml, false);
						// seal no sheet
						//alert(sheetObjects[2].id + "\n" + sealXml);
						sheetObjects[2].LoadSearchXml(sealXml, false);
						// term qty sheet
						//alert(sheetObjects[4].id + "\n" + volXml);
						sheetObjects[4].LoadSearchXml(volXml, false);
						

						// QTY의 행이 하나도 없을 경우 메시지 표시 "ERR_DATA, Create booking quantity, first!" 후 리턴
						if(sheetObjects[0].TotalRows == 0){
							//alert("ERR_DATA, Create booking quantity first!");
							return false;
						}
						
						formObj.old_bkg_no.value = ComGetEtcData(arrXml[0],"bkg_no");
						// etc data
/*
						ComEtcDataXmlToForm(etcXml, formObj);
						//formObj.bl_no.value = ComGetEtcData(etcXml, "bl_no");
						formObj.t_vvd.value = ComGetEtcData(etcXml, "vsl_cd") 
						                    + ComGetEtcData(etcXml, "skd_voy_no") 
											+ ComGetEtcData(etcXml, "skd_dir_cd");
						// pkg container
						document.getElementById("wgt_ut_cd").innerText    = ComGetEtcData(etcXml, "wgt_ut_cd");
						document.getElementById("meas_ut_cd").innerText   = ComGetEtcData(etcXml, "meas_ut_cd");
						document.getElementById("bkg_qty").innerText      = ComAddComma3(ComGetEtcData(etcXml, "quantity"), "#,###.00");
						//document.getElementById("bkg_spc_qty").innerText  = ComAddComma3(ComGetEtcData(etcXml, "spc_qty"), "#,###.00");
						document.getElementById("bkg_pck_qty").innerText  = ComAddComma3(ComGetEtcData(etcXml, "pck_qty"), "#,###");
						document.getElementById("bkg_act_wgt").innerText  = ComAddComma3(ComGetEtcData(etcXml, "act_wgt"), "#,###.000");
						document.getElementById("bkg_meas_qty").innerText = ComAddComma3(ComGetEtcData(etcXml, "meas_qty"), "#,###.000");
*/
						ComEtcDataToForm(formObj ,sheetObjects[1], '');
						
						// pkg container
						document.getElementById("wgt_ut_cd").innerText  = sheetObjects[1].EtcData("wgt_ut_cd");
						document.getElementById("meas_ut_cd").innerText = sheetObjects[1].EtcData("meas_ut_cd");
						document.getElementById("bkg_qty").innerText        = ComAddComma3(sheetObjects[1].EtcData("quantity"), "#,###.00");
						//document.getElementById("bkg_spc_qty").innerText    = ComAddComma3(sheetObjects[1].EtcData("spc_qty"), "#,###.00");
						document.getElementById("ori_bkg_pck_qty").innerText    = ComAddComma3(sheetObjects[1].EtcData("pck_qty"), "#,###");
						document.getElementById("ori_bkg_act_wgt").innerText    = ComAddComma3(sheetObjects[1].EtcData("act_wgt"), "#,###.000");
						document.getElementById("ori_bkg_meas_qty").innerText   = ComAddComma3(sheetObjects[1].EtcData("meas_qty"), "#,###.000");
				
						// after loading of container
						calculateCntrQty();
						// Set Seq.
						//setSeq(false);
						// after loading of seal no
						setAllSealNo();
						// POR/POL/POD/DEL에 CN이 있는 경우
						var cn_flg = formObj.cn_flg.value;
						//alert("* cn_flg : " + cn_flg);
						var por_cnt = ComIsEmpty(formObj.por_cd.value) ? "NA" : formObj.por_cd.value.substring(0, 2);
						var del_cnt = ComIsEmpty(formObj.del_cd.value) ? "NA" : formObj.del_cd.value.substring(0, 2);
						if(cn_flg == 'Y' || por_cnt=='CN' || del_cnt == 'CN'){
							sheetObjects[1].ColHidden("seal1_knd_cd") = false;
							sheetObjects[1].ColHidden("seal1_pty_tp_cd") = false;
							sheetObjects[1].ColHidden("seal2_knd_cd") = false;
							sheetObjects[1].ColHidden("seal2_pty_tp_cd") = false;
						}else{
							sheetObjects[1].ColHidden("seal1_knd_cd") = true;
							sheetObjects[1].ColHidden("seal1_pty_tp_cd") = true;
							sheetObjects[1].ColHidden("seal2_knd_cd") = true;
							sheetObjects[1].ColHidden("seal2_pty_tp_cd") = true;
							// ''이 있을 경우.
							formObj.cn_flg.value = 'N';
						}
						//BDR flag = "Y" 일 경우 BKG no 바탕색을 파랑게 변경. "N"일 경우 흰색으로 변경
						if(formObj.bdr_flg.value == 'Y'){
							document.getElementById("bkg_no").className = "input1";
						}else{
							document.getElementById("bkg_no").className = "input";
						}
						// not_updated_flg
						if(formObj.not_updated_flg.value == 'Y'){
							getBtnObject("btn_t6notupdated").style.color = "red";
						}else{
							getBtnObject("btn_t6notupdated").style.color = "#000000";
						}
						// wgt_ut_cd
						var wgtCd1  =  formObj.bkg_wgt_ut_cd.options[formObj.bkg_wgt_ut_cd.selectedIndex].value;
						var wgtCd2  =  sheetObjects[1].EtcData("wgt_ut_cd");
						if(wgtCd1 == null || wgtCd1 == ''){
							if(wgtCd2 == null || wgtCd2 == ''){
								formObj.bkg_wgt_ut_cd.value = "KGS";
							}else{
								formObj.bkg_wgt_ut_cd.value = wgtCd2;
							}
						}
						// meas_ut_cd
						var measCd1 =  formObj.bkg_meas_ut_cd.options[formObj.bkg_meas_ut_cd.selectedIndex].value;
						var measCd2 =  sheetObjects[1].EtcData("meas_ut_cd");
						if(measCd1 == null || measCd1 == ''){
							if(measCd2 == null || measCd2 == ''){
								formObj.bkg_meas_ut_cd.value = "CBM";
							}else{
								formObj.bkg_meas_ut_cd.value = measCd2;
							}
						}
						// For Inquery 
						// final confirm flag
						//if(!ComIsEmpty(formObj.evnt_dt.value)){
						if(formObj.fnl_cfm_flg.value == 'Y'){
							changeEditableByConfirm('CFM');
						}else{
							formObj.fnl_cfm_flg.value = 'N';
							changeEditableByConfirm('RLS')
						}
						// 데이터 변경 여부 체크
						formObj.dirty_flag.value = 'N';
						//alert("* scrnAuth : " + scrnAuth);
						setInquiryDisableButton();
						
						// ca controll
						//alert("1. " +(parent.outerFrame != undefined)+ ", 2. " + (parent.outerFrame != "undefined") + ", 3. " + (typeof(parent.outerFrame) == "object"));
						if(parent.t6frame != undefined && typeof(parent.t6frame) == "object") {
							parent.initCAControl(formObj.bkg_no.value, formObj.corr_flg.value, formObj.bdr_flg.value, formObj.ca_exist_flg.value, formObj.bl_no.value);
						}
//						if ("W"==formObj.bl_tp_cd.value) {
//							formObj.bl_no.value += "W";
//						} else if ("Y"==formObj.obl_iss_flg.value) {
//							formObj.bl_no.value += "S";
//						}

						var arrRow = ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
						var cgoRcvDtBtn = false;
						if (arrRow) {
							for (var i=0; i<arrRow.length; i++) {
								if (!ComIsEmpty(sheetObj.CellValue(arrRow[i], "cgo_rcv_dt"))) {
									if ("N"==sheetObj.CellValue(arrRow[i], "cgo_rcv_dt_flg")) {
										cgoRcvDtBtn = true;
										break;
									}
								}
							}
						}
						formObj.not_crd_flg.value = cgoRcvDtBtn ? "Y":"N";
				
						var isIrrBtn = false;
						if ("Y"==formObj.corr_flg.value) {
							if ("Y"==formObj.not_crd_flg.value) {
								isIrrBtn = true;
							} else {
								isIrrBtn = false;
							}
						} else {
							if ("Y"==formObj.bdr_flg.value) {
								isIrrBtn = false;
							} else {
								if ("Y"==formObj.not_crd_flg.value) {
									isIrrBtn = true;
								} else {
									isIrrBtn = false;
								}
							}
						}
						
						if (isIrrBtn) {
							getBtnObject("btn_t6gridcntrirr").style.color = "blue";
							ComBtnEnable("btn_t6gridcntrirr");
							ComShowMessage(ComGetMsg("BKG95060"));
							
						} else {
							getBtnObject("btn_t6gridcntrirr").style.color = "#C0C0C0";
							ComBtnDisable("btn_t6gridcntrirr");
						}
						//Bangladesh shipment Detail pop up 연결 활성화, 비활성화 설정 
						                
						if(formObj.pol_cd.value.substring(0,2)=="BD"){
							ComBtnEnable("btn_t6gridcntrodcy");
						} else{
							ComBtnDisable("btn_t6gridcntrodcy");
						}
						
						// 2017.10.26 iylee Prime Service(OLBP)일때만 체크 Control 할 수 있도록 수정.
						var olbpFlg = "0";
						if(formObj.stwg_cd.value == "OLBP"){
							olbpFlg = "1";
						}
						for (rn=1; rn<=sheetObjects[1].RowCount; rn++) {
							if(olbpFlg == "1"){
								sheetObjects[1].CellEditable(rn, "lbp_flg")   = true;
							} else {
								sheetObjects[1].CellEditable(rn, "lbp_flg")   = false;
							}
						}
						
						for (var i=sheetObj.HeaderRows; i<=sheetObj.RowCount; i++) {
							if ("N"==sheetObj.CellValue(i,"cgo_rcv_dt_flg") || ""==sheetObj.CellValue(i,"cgo_rcv_dt")) {
								ComSetObjValue(document.form.cgo_rcv_dt,"");
								break;
							}
						}
						checkShowVGM();
					}else{
						return false;
					}
				}finally{
					ComOpenWait(false);
				}
                }else{
					return false;
				}
            break;

            case IBSAVE:        //저장
				/* 수정여부의 메세지를 보이지 않고, 저장시 변경하는걸로 수정. update on 2010.02.10 */
				// unit code sync.
            	
            	//도착지 중국일 때 seal, kind code validation 체크
            	if(!chk_china_cntr_seal()) return false;
				if(scrnAuth == 'R') return;
            	
            	if(sheetObj.id == 't6sheet2') {
	            	if(!allTypeSealNoDupChk(sheetObj))
	            		return false;
	            	
	            	if(!checkSealNo(sheetObj))
	            		return false;
            	}
				
				var wgtCd1  =  formObj.bkg_wgt_ut_cd.options[formObj.bkg_wgt_ut_cd.selectedIndex].value;
				var measCd1 =  formObj.bkg_meas_ut_cd.options[formObj.bkg_meas_ut_cd.selectedIndex].value;
				for (rn=1; rn<=sheetObjects[1].RowCount; rn++) {
					if(wgtCd1 != sheetObjects[1].CellValue(rn, "wgt_ut_cd")){
						sheetObjects[1].CellValue2(rn, "wgt_ut_cd") = wgtCd1;
					}
					if(measCd1 != sheetObjects[1].CellValue(rn, "meas_ut_cd")){
						sheetObjects[1].CellValue2(rn, "meas_ut_cd") = measCd1;
					}
					
					if (sheetObjects[1].CellValue(1, "ibflag") != "D") {
//						// VGM 입력되었을 때, VGM 단위가 없으면 save block
						if (sheetObjects[1].CellValue(rn, "vgm_wgt_ut_cd") == "" && sheetObjects[1].CellValue(rn, "vgm_wgt") != "0") {
							ComShowCodeMessage("BKG00104", " VGM Unit ");
							return false;
						} 
						
						// VGM이 weight보다는 작으면 save block
						var cntrTpSz = sheetObjects[1].CellValue(rn,"cntr_tpsz_cd");
						if(document.form.bkg_cgo_tp_cd.value=="R" || cntrTpSz =="T2" || cntrTpSz == "T4"){
							if (sheetObjects[1].CellValue(rn, "vgm_wgt") != "0" && (BkgParseFloat(sheetObjects[1].CellValue(rn, "vgm_wgt")) < BkgParseFloat(sheetObjects[1].CellValue(rn, "cntr_wgt")))) {
								ComShowMessage(ComGetMsg("BKG95118"));
								return false;
							}
						}else{	
							if (sheetObjects[1].CellValue(rn, "vgm_wgt") != "0" && (BkgParseFloat(sheetObjects[1].CellValue(rn, "vgm_wgt")) <= BkgParseFloat(sheetObjects[1].CellValue(rn, "cntr_wgt")))) {
								ComShowMessage(ComGetMsg("BKG95118"));
								return false;
							}
						}
//
						// [CHM-201641324] DEL이 바레인일 때 measure값이 0이면 save block
						var cntrMeasQty = BkgParseFloat(ComTrimAll(document.getElementById("cntr_meas_qty").innerText, ","));
						if (cntrMeasQty <= 0 && "BH" == formObj.del_cd.value.substring(0, 2)) {
							ComShowMessage(ComGetMsg("BKG95112"));
							return false;
						}
					}
				}
				
			
                if(validateForm(sheetObj,formObj,sAction)) {
                	//BKG95061 [CHM-201324007] 개발:CNTR Screen에서 WGT 관련 Pop-up 생성 개발
                	formObj.f_cmd.value = SEARCH03;
                	var params = FormQueryString(formObj);
    				params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true), "sheet1_");
    	           	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_04GS.do", params);
    	           	var arrXml = sXml.split("|$$|");
    	           	var chkFlg = ComGetEtcData(arrXml[0],"chkFlg");
    	           	if(chkFlg =="Y"){
    	           		ComShowMessage(ComGetMsg("BKG95061"));
    	           	}
    	            // At Risk에 해당하는 장비이면 validation메시지 팝업(Reefer)
    	           	// 조건: POD = US, POD= CA,  US Frob의 경우
    	           	formObj.f_cmd.value = SEARCH04;
    	           	var params = FormQueryString(formObj);
    	           	params = params + "&" + ComSetPrifix(sheetObjects[1].GetSaveString(true), "sheet1_");
    	           	var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_04GS.do", params);
    	           	var arrXml = sXml.split("|$$|");
    	           	var rskFlg = ComGetEtcData(arrXml[0],"rskFlg");
    	           	if(rskFlg =="Y"){
    	           		ComShowMessage(ComGetMsg("BKG08275"));
    	           	}
					
				try {
					ComOpenWait(true); 
                    //formObj.f_cmd.value = MULTI;
					//sheetObj.DoSave("ESM_BKG_0079_04GS.do", FormQueryString(formObj));
					formObj.f_cmd.value = MULTI;
					var sParam = FormQueryString(formObj) + "&eur_flg=" + eurFlg;
					//alert(sheetObjects[0].id);
					//var sParamSheet0 = sheetObjects[0].GetSaveString();
					//if (sParamSheet0 != "") {
					//	sParam = sParam + "&sheet0_" + sParamSheet0.replace(/&/g, '&sheet0_');
					//}
					//
					if (!isCrdUpdate) {
						for (var i=1; i<= sheetObj.RowCount; i++) {
							sheetObj.CellValue2(i, "cgo_rcv_dt_flg") = "N";
						}
					}
					
					var sParamSheet1 = sheetObjects[1].GetSaveString();
					//alert("Container :\n" + sParamSheet1);
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}
					//
					var sParamSheet2 = sheetObjects[2].GetSaveString();
					//alert("Seal No. :\n" + sParamSheet2);
					if (sParamSheet2 != "") {
						sParam = sParam + "&sheet2_" + sParamSheet2.replace(/&/g, '&sheet2_');
					}
					//
					var sParamSheet3 = sheetObjects[3].GetSaveString();
					//alert("Volumn :\n" + sParamSheet3);
					if (sParamSheet3 != "") {
						sParam = sParam + "&sheet3_" + sParamSheet3.replace(/&/g, '&sheet3_');
					}
					//alert(sParam);
					
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0079_04GS.do", sParam);
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						//sheetObjects[0].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						sheetObjects[1].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						sheetObjects[2].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						sheetObjects[3].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						//sheetObjects[4].LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						
						// show message
						if(formObj.modify_fnl_cfm_flg.value == 'Y'){
							if(formObj.fnl_cfm_flg.value == 'Y'){
								ComShowMessage(ComGetMsg("BKG00865"));
							}else{
								ComShowMessage(ComGetMsg("BKG00864"));
							}
						}else{
							var cstms_download = ComGetEtcData(rXml, "USA_CSTMS_DOWNLOAD");
							if(cstms_download == 'true'){
								ComShowMessage(ComGetMsg("BKG00166") + '\n\n' + ComGetMsg("BKG00087"));
							}else{
								ComShowMessage(ComGetMsg("BKG00166"));
							}
						}
						
//						for(i=1; i<sheetObjects[1].Rows ; i++) {
//							sheetObjects[1].CellValue2(i,"cntr_no_old") = sheetObjects[1].CellValue(i,"cntr_no");
//							sheetObjects[1].CellValue2(i,"ibflag") = "";
//						}
						// 데이터 변경 여부 체크
						formObj.dirty_flag.value = 'N';
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
						return false;
					}
				}finally{
					ComOpenWait(false);
				}
                }else{
					return false;
				}
            break;

			case COMMAND01:      // Confirmation
				if(sheetObj.id == 't6sheet2') {
					if(!allTypeSealNoDupChk(sheetObj))
		        		return false;
				
					if(!checkSealNo(sheetObj))
						return false;
				}
			
				if(validateForm(sheetObj,formObj,sAction)) {
					
					//브라질 향/발에 대해 CM confirm이 되어 있지 않으면 cntr confirmation 불가
					if(formObj.pol_cd.value.substring(0,2)=="BR"||formObj.pod_cd.value.substring(0,2)=="BR"){
						for (var ix=1;ix <= sheetObj.RowCount;ix++) {
							var mfFlg = sheetObj.CellValue(ix,"mf_cfm_flg")
							if(mfFlg!='Y'){
								ComShowMessage(ComGetMsg("BKG95109"));
								return false;
							}
						}
					}
					var tmp_usr_id = formObj.evnt_usr_id.value;
					var tmp_dt = formObj.evnt_dt.value;
					// comfirm
					formObj.evnt_usr_id.value = cur_usr_id;
					formObj.evnt_dt.value = getToday();
					formObj.fnl_cfm_flg.value = 'Y';
					formObj.modify_fnl_cfm_flg.value = 'Y';
					//set change flag
					formObj.dirty_flag.value = 'Y';
					// confirm message
					//ComShowMessage(ComGetMsg("BKG00865"));
					// save 호출
					var res = doActionIBSheet(sheetObj,formObj,IBSAVE);
					if(!res){

						// release
						formObj.evnt_usr_id.value = tmp_usr_id;
						formObj.evnt_dt.value = tmp_dt;
						formObj.fnl_cfm_flg.value = 'N';
						formObj.modify_fnl_cfm_flg.value = 'N';
					}
					eurFlg = "Y";
					return res;
				}else{
					return false;
				}
			break;

			case MULTI02:      // Cancel Confirmation
				var tmp_usr_id = formObj.evnt_usr_id.value;
				var tmp_dt = formObj.evnt_dt.value;
				// release
				formObj.evnt_usr_id.value = '';
				formObj.evnt_dt.value = '';
				formObj.fnl_cfm_flg.value = 'N';
				formObj.modify_fnl_cfm_flg.value = 'Y';
				//set change flag
				formObj.dirty_flag.value = 'Y';
                formObj.f_cmd.value = MULTI02;

				var sParam = FormQueryString(formObj);

				var res = sheetObj.GetSaveXml("ESM_BKG_0079_04GS.do", sParam);
				var State = ComGetEtcData(res,"TRANS_RESULT_KEY");
				
				if(State != null){
					if ( State == "S" ) {
						ComShowMessage(ComGetMsg("BKG00864"));

						formObj.fnl_cfm_flg.value = 'N';
						formObj.modify_fnl_cfm_flg.value = 'N';
						formObj.dirty_flag.value = 'N';
						changeEditableByConfirm("RLS");
						
						sheetObj.LoadSaveXml(sXml);
					}else{
						fnExceptionMessage(sXml);
					}
				}
				return res;
			break;
			
			case COMMAND03: 
			break;
			
			case COMMAND04:      //booking split no조회 
				if(validateForm(sheetObj,formObj,sAction)) {
				//try {
				//	ComOpenWait(true); 
					sheetObj.WaitImageVisible = false;
					ComSetObjValue(formObj.f_cmd, COMMAND03);
					var sXml = sheetObj.GetSearchXml("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list = ComGetEtcData(sXml, "bkg_split_no_list");
					bkgSplitNoListPop(formObj.bkg_no, bkg_split_no_list, -15); 
					sheetObj.WaitImageVisible = true;
				//}finally{
				//	ComOpenWait(false);
				//}
				}else{
					return false;
				}					
			break;
				  

            case IBINSERT:      // 입력
				var newRow = sheetObj.DataInsert(-1);
				sheetObj.CellValue2(newRow, "bkg_no") =  formObj.bkg_no.value;
				if(formObj.rcv_term_cd.value != 'M'){
					sheetObj.CellValue2(newRow, "rcv_term_cd") =  formObj.rcv_term_cd.value;
//					sheetObj.CellEditable(newRow, "rcv_term_cd") = false;
				} else{
					sheetObj.CellValue2(newRow, "rcv_term_cd") =  "";
				}
				if(formObj.de_term_cd.value != 'M'){
					sheetObj.CellValue2(newRow, "de_term_cd") =  formObj.de_term_cd.value;
//					sheetObj.CellEditable(newRow, "de_term_cd") = false;
				} else{
					sheetObj.CellValue2(newRow, "de_term_cd") =  "";
				}
				sheetObj.CellValue2(newRow, "cntr_vol_qty") =  1;
				sheetObj.CellValue2(newRow, "wgt_ut_cd")    =  ComGetObjValue(formObj.bkg_wgt_ut_cd);
				sheetObj.CellValue2(newRow, "meas_ut_cd")   =  ComGetObjValue(formObj.bkg_meas_ut_cd);
				sheetObj.SelectCell(newRow, "cntr_no");
				// Set Seq.
//				setSeq(false);
				/* calculateCntrQty */
				//calculateCntrQty();
				// 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';

            break;

			case IBDELETE:      // 삭제
				//alert (" Delete .. ");
				//ComRowHideDelete(sheetObj, "sel");
				var rCntrNo = '';
				var rCfrm = '';
				var rCMFlag = '';
				var selRows = sheetObj.FindCheckedRow("sel");
				if(selRows == ''){
					ComShowMessage(ComGetMsg("COM12189"));
					return false;
				}
				var idxArr = selRows.split("|");
				var cidx = 0;
				//alert(idxArr.length + " : " + selRows);
				for(ix=0;ix<idxArr.length;ix++){
					cidx = idxArr.length - 1 - ix;
					if(idxArr[cidx] == '') continue;
					rCntrNo = sheetObj.CellValue(idxArr[cidx], "cntr_no");
					rCfrm   = sheetObj.CellValue(idxArr[cidx], "cntr_cfm_flg");
					rCMFlag = sheetObj.CellValue(idxArr[cidx], "cm_flg");
					if(rCfrm == 1 && !confirm(ComGetMsg("BKG00175"))){
						continue;
					}
					if(sheetObj.CellValue(idxArr[cidx], "dcgo_flg")    == 1 ||
						sheetObj.CellValue(idxArr[cidx], "bb_cgo_flg")  == 1 ||
						sheetObj.CellValue(idxArr[cidx], "awk_cgo_flg") == 1 ||
						sheetObj.CellValue(idxArr[cidx], "rc_flg")      == 1){
						//Special Cargo 가 있을 경우에는 삭제하지 않음.
						//alert(ComGetMsg("BKG00176"));
						ComShowMessage(ComGetMsg("BKG00171", rCntrNo));
						continue;
					}
					if(rCMFlag == 'Y' && !confirm(ComGetMsg("BKG00177"))){
						continue;
					}

					// delete container
					//alert(idxArr[cidx] + " - " + sheetObj.CellValue(idxArr[cidx], "cntr_dp_seq") + " : " + rCntrNo);
					sheetObj.RowHidden(idxArr[cidx]) = true;
					sheetObj.RowStatus(idxArr[cidx]) = 'D';
					sheetObj.CellValue2(idxArr[cidx], "sel") = 0;
					// delete seal no
					ComRowDelete(sheetObjects[2], "cntr_no", rCntrNo);
				}
				// Set Seq.
//				setSeq(false);
				/* calculateCntrQty */
				calculateCntrQty();
				// 데이터 변경 여부 체크
				formObj.dirty_flag.value = 'Y';
			break;

			case MODIFY01:
				if (validateForm(sheetObj,formObj,sAction)) {
//	        		if (!ComShowCodeConfirm("BKG00498", "CNTR IRR")) return false;  //Do you want to save {?msg1}?
					sheetObj.CheckAll2("sel") = 0;
					var arrRow = ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
					for (var i=1; i<=sheetObj.RowCount; i++) {
						sheetObj.CellValue2(i, "cgo_rcv_dt_flg") = "N";
					}
					if (arrRow) {
						//CRD 데이터 정리
						for (var i=0; i<arrRow.length; i++) {
							if (!ComIsEmpty(sheetObj.CellValue(arrRow[i], "cgo_rcv_dt"))) {
								sheetObj.CellValue2(arrRow[i], "sel") = 1;
								sheetObj.CellValue2(arrRow[i], "ibflag") = "U";
								sheetObj.CellValue2(arrRow[i], "cgo_rcv_dt_flg") = "Y";
								sheetObj.CellFontColor(arrRow[i],"cgo_rcv_dt") = sheetObj.CellFontColor(arrRow[i],"cntr_no");
							}
						}
					}

					//Cargo Receiving Date 설정
					var maxCrdDt = '';
					var currCrdDt = '';

					for (var i=1; i<sheetObj.Rows; i++) {
						currCrdDt = sheetObj.CellValue(i, "cgo_rcv_dt");
						if (maxCrdDt == null || maxCrdDt < currCrdDt) {
							maxCrdDt = currCrdDt;
						}
					}
					
					if(maxCrdDt!='') {
						maxCrdDt = maxCrdDt.substring(0,4) + '-' + maxCrdDt.substring(4,6) + '-' + maxCrdDt.substring(6,8);
					}
					formObj.cgo_rcv_dt.value = maxCrdDt;
					
					//버튼 정리 및 저장 활성화
					getBtnObject("btn_t6gridcntrirr").style.color = "#C0C0C0";
					ComBtnDisable("btn_t6gridcntrirr");
					formObj.dirty_flag.value = 'Y';
					isCrdUpdate = true;
				} else {
					return false;
				}					
			break;
        }
		return true;
    }
    
    /**
    * fnExceptionMessage  
    * 에러처리 메세지 
    * @param 
    * @return 
    */
    function fnExceptionMessage(rXml){
    	var rMsg = ComGetEtcData(rXml,"Exception")
    	var rmsg = rMsg.split("<||>");
    	if(rmsg[3] != undefined && rmsg[3].length > 0) {
    		ComShowMessage(rmsg[3]);
    	}else{
    		sheetObjects[0].LoadSaveXml(rXml);
    	}
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	var bkgNo = formObj.bkg_no.value;
        switch(sAction) {

			case IBSEARCH:
				/*
				1. 데이터 변경 여부 체크 - 메시지 [BKG00824] 출력 후 ""Yes"" 선택하면 저장 이벤트 호출
				2. MANDATORY ITEMS 입력 체크 - BKG no(10자리), B/L no(12자리) 안될 경우 메시지 [BKG00445] 출력 후 focus 처리
				3. BKG Split no 체크 - 없을 경우 공백 2자리로 변경
				4. 데이터 조회
				*/
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
			break;

            case IBSAVE:
				/*
				1. 데이터 변경 여부 체크 - 변경사항 없으면 리턴처리
				2. 저장여부 확인 메시지 표시
				3. 데이터 변경 여부 체크 및 confirm flag 체크 - confirm flag가 = false 일 경우 리턴
				4. BKG status 체크 - status가 "X"일 경우 메시지 [BKG00433] 표시 후 리턴
				5. BDR 및 CA 체크 - BDR = "Y", CA = "N"일 경우 메시지 [BKG00335] 표시 후 리턴 처리
				6. MANDATORY ITEMS 입력 체크 - MANDATORY 값이 없을 경우 메세지 표시 후 focus 처리
				   : BKG no, Container no, Package, R/D term, Vol : Vol > 1 or Vol <= 0 인 경우도 체크, Package qty < 1 인 경우도 체크
				7. QTY Grid를 업데이트 하고 variance 체크 - variance가 있을 경우 행을 빨간색으로 변경
				8. Package Grid를 업데이트 하고 variance 체크 -  (-)인 경우 메세지 [BKG00848] 표시 후 진행여부 확인 메세지 [BKG00852] 표시
				   (-)인 경우 행을 빨간색으로 변경으로 변경하고 PKG, WGT, MEA 각각의 메세지 [BKG00849], [BKG00850], [BKG00851] 표시 후
				   진행여부 확인 메세지 [BKG00852] 표시
				9. B/L Confirm, B/L Issue 인 경우 Warning Message
				   - B/L Confirm만 된 경우 진행여부 확인 메세지 [BKG08234] 표시
				   - B/L Issue가 된 경우 진행여부 확인 메세지 [BKG08235] 표시
				*/
				
				if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
					
					ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
					ComSetFocus(formObj.bkg_no);
					return false;    				
				}
				
				
				if(scrnAuth == 'R') return;
				
				if(formObj.dirty_flag.value != 'Y'){
					//alert(formObj.dirty_flag.value);
					return false;
				}
				
				if(!confirm(ComGetMsg("BKG00254"))){
					return false;
				}

				if(formObj.bkg_sts_cd.value == 'X'){
					ComShowMessage(ComGetMsg("BKG00433"));
					return false;
				}
				//if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
				//	ComShowMessage(ComGetMsg("BKG00335"));
				//	return false;
				//}
				
				if(!tpsz_chk) {
					ComShowMessage(ComGetMsg("BKG00651", "Container TP/SZ "));
					return false;
				}

				var qtySheet = sheetObjects[0];
				var qtyCount = qtySheet.RowCount;
				for(ir=1; ir <= qtyCount; ir++){
					if((qtySheet.CellValue(ir, "op_cntr_qty") - qtySheet.CellValue(ir, "bkg_cntr_qty")) < 0){
						qtySheet.RowBackColor(ir) = qtySheet.RgbColor(192,0,0);
					}
				}

				var cntrSheet = sheetObjects[1];
				var cntrCount = cntrSheet.RowCount;
				for(ir=1;ir<=cntrCount;ir++){
					//alert("!!!" + cntrSheet.CellValue(ir, "cntr_no"));
					if(cntrSheet.RowStatus(ir) == 'D') continue;

					if(ComIsEmpty(cntrSheet.CellValue(ir, "bkg_no"))){
						ComShowMessage(ComGetMsg("BKG00888", "bkg_no"));
						//cntrSheet.SelectCell(ir, "bkg_no");
						return false;
					}
					if(ComIsEmpty(cntrSheet.CellValue(ir, "cntr_no"))){
						ComShowMessage(ComGetMsg("BKG00888", "cntr_no"));
						cntrSheet.SelectCell(ir, "cntr_no");
						return false;
					}
					//if(ComIsEmpty(cntrSheet.CellValue(ir, "pck_qty"))){
					//	ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
					//	cntrSheet.SelectCell(ir, "pck_qty");				
					//	return false;
					//}
					if(!ComIsEmpty(cntrSheet.CellValue(ir, "pck_qty"))){
						// pck qty && BB_FLAG
						if(BkgParseInt(cntrSheet.CellValue(ir, "pck_qty")) < 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
							cntrSheet.SelectCell(ir, "pck_qty");
							return false;
						}else if(BkgParseInt(cntrSheet.CellValue(ir, "pck_qty")) == 0 && cntrSheet.CellValue(ir, "bb_cgo_flg") == 0){
							ComShowMessage(ComGetMsg("BKG00888", "pck_qty"));
							cntrSheet.SelectCell(ir, "pck_qty");
							return false;
						}
						// pck tpye
						if(ComIsEmpty(cntrSheet.CellValue(ir, "pck_tp_cd"))){
							ComShowMessage(ComGetMsg("BKG00888", "pck_tp_cd"));
							cntrSheet.SelectCell(ir, "pck_tp_cd");
							return false;
						}							
					}
					if(ComIsEmpty(cntrSheet.CellValue(ir, "rcv_term_cd"))){
						ComShowMessage(ComGetMsg("BKG08241"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
					if(ComIsEmpty(cntrSheet.CellValue(ir, "de_term_cd"))){
						ComShowMessage(ComGetMsg("BKG08241"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
					if(ComIsEmpty(cntrSheet.CellValue(ir, "cntr_vol_qty")) || BkgParseFloat(cntrSheet.CellValue(ir, "cntr_vol_qty")) < 0 || BkgParseFloat(cntrSheet.CellValue(ir, "cntr_vol_qty")) > 1){
						ComShowMessage(ComGetMsg("BKG00888", "cntr_vol_qty"));
						cntrSheet.SelectCell(ir, "cntr_vol_qty");
						return false;
					}

				}

				var var_qty      = BkgParseFloat(ComTrimAll(document.getElementById("var_qty").innerText, ","));
				//var var_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("var_spc_qty").innerText, ","));
				var var_pck_qty  = BkgParseFloat(ComTrimAll(document.getElementById("var_pck_qty").innerText, ","));
				var var_act_wgt  = BkgParseFloat(ComTrimAll(document.getElementById("var_act_wgt").innerText, ","));
				var var_meas_qty = BkgParseFloat(ComTrimAll(document.getElementById("var_meas_qty").innerText, ","));
				var dif_message = '';
				if(var_qty<0){
					//document.getElementById("var_qty").style.backgroundColor = "red";
					//document.getElementById("var_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00849"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message = (dif_message == '') ? "Container Qty" : dif_message + ", Container Qty";
				}
				if(var_pck_qty<0){
					//document.getElementById("var_pck_qty").style.backgroundColor = "red";
					//document.getElementById("var_pck_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00849"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message = (dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(var_act_wgt<0){
					//document.getElementById("var_act_wgt").style.backgroundColor = "red";
					//document.getElementById("var_act_wgt").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00850"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message = (dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(var_meas_qty<0){
					//document.getElementById("var_meas_qty").style.backgroundColor = "red";
					//document.getElementById("var_meas_qty").style.color = "#606060";
					//ComShowMessage(ComGetMsg("BKG00851"));
					//if(!confirm(ComGetMsg("BKG00852"))){
					//	return false;
					//}
					dif_message = (dif_message == '') ? "Package Qty" : dif_message + ", Package Qty";
				}
				if(dif_message != '' && !confirm(ComGetMsg("BKG00852", dif_message))){
					return false;
				}
				
				/*
				 * Variance DTL 과 비교하여 차이가 나면 Confirm 안됨.
				 * updated on 2009-11-04 by KimYoungchul
				*/
				var volSheet = sheetObjects[4];
				for(ir=volSheet.HeaderRows ;ir<=volSheet.RowCount ;ir++ ){
					// cntr TP/SZ
					var tpSz = volSheet.CellValue(ir, "cntr_tpsz_cd");
					//alert(tpSz);
					var cntrQtyArr = getCntrQtyByType(tpSz);
					//alert(cntrQtyArr);
					
					for(ic=2 ;ic<=volSheet.LastCol ;ic++){
						var p1 = parseFloat(volSheet.CellValue(ir, ic));
						var p2 = parseFloat(cntrQtyArr[ic]);
						if((p1-p2) != 0) {
							getBtnObject("btn_VarianceDtl").style.color = "red";
							break;
						}else{
							getBtnObject("btn_VarianceDtl").style.color = "#737373";
						}
					}
				}
				
    			// 2012.04.24 BKG/DOC System 보완 요청 START
    			if (!checkBkgIssStatus(formObj)) {
    				return false;
    				break;
    			}
    			// 2012.04.24 BKG/DOC System 보완 요청 END
				
			break;

            case COMMAND01:
				/*
				1. BKG No 체크 - 메시지 BKG00463] 표시후 리턴
				2. BKG Split no 체크       - 없을 경우 공백 2자리로 변경
				3. BKG QTY와 CNTR QTY를 tpsz별로 비교하여 하나라도 같지 않을 경우 메시지 [BKG00179] 표시 후 리턴 처리
				4. DG application에 등록되어 있는 container중에서 DG flag는 있으나 DG rider는 없는 경우에 다음 메시지 [BKG00180] 표시하고 confirm 안됨
				5. container의 개별 R/D term에 mixed term이 있으면 메세지 [BKG00861] 표시 후 리턴
				6. container column의 TP/SZ별 Vol.과 booking creation의 TP/SZ별 Vol이 다른 경우 메세지 [BKG00854] 표시 후 리턴
				7. BKG의 R/D term과 다른 R/D term이 입력된 경우 메세지 [BKG00862] 표시 후 리턴
				8. C(onfrim) 전체에 체크표시
				*/
				with (formObj) {
					if(bkg_no.value == '' || bkg_no.value.length < 11){
						if(bl_no.value == '' ){
							ComShowMessage(ComGetMsg("BKG00463"));
							bkg_no.focus();
							return false;
						}
					}
				}
				if(ComGetObjValue(formObj.old_bkg_no) != bkgNo){	// 조회없이 Booking 번호만 변경시
					
					ComShowCodeMessage("BKG00048",formObj.old_bkg_no.value,bkgNo);
					ComSetFocus(formObj.bkg_no);
					return false;    				
				}

				var var_qty = BkgParseFloat(ComTrimAll(document.getElementById("var_qty").innerText, ","));
				if(var_qty != 0){
					ComShowMessage(ComGetMsg("BKG00179"));
					return false;
				}

				var qtySheet = sheetObjects[0];
				var qtyCount = qtySheet.RowCount;
				var cntrSheet = sheetObjects[1];

				for(ir=1;ir<=qtyCount;ir++){
					// 'cntr_tpsz_cd' = Q2, Q4는 비교제외 - updated on 2009.07.27
					//if(qtySheet.CellValue(ir, "cntr_tpsz_cd") == "Q2" || qtySheet.CellValue(ir, "cntr_tpsz_cd") == "Q4") continue;
					if(formObj.flex_hgt_flg.value == 'Y' && ((qtySheet.CellValue(ir, "cntr_tpsz_cd") == "D4" || qtySheet.CellValue(ir, "cntr_tpsz_cd") == "D5"))){
						//alert(" * flex_hgt_flg : " + formObj.flex_hgt_flg.value);
						var qtyD4 = ComColumnSumByCond(qtySheet, "bkg_cntr_qty", "cntr_tpsz_cd", "D4", false);
						var qtyD5 = ComColumnSumByCond(qtySheet, "bkg_cntr_qty", "cntr_tpsz_cd", "D5", false);
						var cntrD4 = ComColumnSumByCond(cntrSheet, "cntr_vol_qty", "cntr_tpsz_cd", "D4", false);
						var cntrD5 = ComColumnSumByCond(cntrSheet, "cntr_vol_qty", "cntr_tpsz_cd", "D5", false);
						//alert("("+qtyD4+"+" +qtyD5+") - ("+cntrD4+"+"+cntrD5+") = "+((qtyD4+qtyD5) - (cntrD4+cntrD5)));
						if(((qtyD4+qtyD5) - (cntrD4+cntrD5)) != 0){
							ComShowMessage(ComGetMsg("BKG00854"));
							return false;
						}
					}else{
						if((qtySheet.CellValue(ir, "op_cntr_qty") - qtySheet.CellValue(ir, "bkg_cntr_qty")) != 0){
							ComShowMessage(ComGetMsg("BKG00854"));
							return false;
						}
					}
				}

				var bkg_rcv_term = formObj.rcv_term_cd.value;
				var bkg_del_term = formObj.de_term_cd.value;
				var cntrCount = cntrSheet.RowCount;
				var cn_flg = formObj.cn_dir_flg.value;

				for(ir=1;ir<=cntrCount;ir++){
					if(cntrSheet.CellValue(ir, "rcv_term_cd") == 'M'){
						ComShowMessage(ComGetMsg("BKG00861"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
					if(cntrSheet.CellValue(ir, "de_term_cd") == 'M'){
						ComShowMessage(ComGetMsg("BKG00861"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
					if(bkg_rcv_term != 'M' && cntrSheet.CellValue(ir, "rcv_term_cd") != bkg_rcv_term){
						ComShowMessage(ComGetMsg("BKG00862"));
						cntrSheet.SelectCell(ir, "rcv_term_cd");
						return false;
					}
					if(bkg_del_term != 'M' && cntrSheet.CellValue(ir, "de_term_cd") != bkg_del_term){
						ComShowMessage(ComGetMsg("BKG00862"));
						cntrSheet.SelectCell(ir, "de_term_cd");
						return false;
					}
					//if(cntrSheet.CellValue(ir, "dcgo_flg") == 1 && BkgParseInt(cntrSheet.CellValue(ir, "dcgo_cnt")) == 0){
					//	ComShowMessage(ComGetMsg("BKG00180", cntrSheet.CellValue(ir, "cntr_no")));
					//	cntrSheet.SelectCell(ir, "cntr_no");
					//	return false;
					//}
					if(ComIsEmpty(cntrSheet.CellValue(ir, "cntr_no"))){
						ComShowMessage(ComGetMsg("BKG00443"));						
						return false;
						//cntrSheet.CellValue2(ir, "cntr_cfm_flg") = 0;
					}else{
						cntrSheet.CellValue2(ir, "cntr_cfm_flg") = 1;
						//changeCntrStatus
						//changeCntrStatus(row);
					}
					
					if(cn_flg == 'Y' && cntrSheet.RowStatus(ir) != 'D'){
						if(ComIsEmpty(cntrSheet.CellValue(ir, "seal1_no"))
							&& ( ComIsContainsChars( cntrSheet.CellValue(ir, "cntr_tpsz_cd").substring(0,1),"TFAP" )==false )){
							//BKG08188
							ComShowMessage(ComGetMsg("BKG08188"));
							cntrSheet.SelectCell(ir, "seal1_no") ;
							return false;
						}
					}
				}
				
				/*
				 * Variance DTL 과 비교하여 차이가 나면 Confirm 안됨.
				 * updated on 2009-11-04 by KimYoungchul
				*/
				var volSheet = sheetObjects[4];
				for(ir=volSheet.HeaderRows ;ir<=volSheet.RowCount ;ir++ ){
					// cntr TP/SZ
					var tpSz = volSheet.CellValue(ir, "cntr_tpsz_cd");
					//alert(tpSz);
					var cntrQtyArr = getCntrQtyByType(tpSz);
					//alert(cntrQtyArr);
					
					for(ic=2 ;ic<=volSheet.LastCol ;ic++){
						var p1 = parseFloat(volSheet.CellValue(ir, ic));
						var p2 = parseFloat(cntrQtyArr[ic]);
						if((p1-p2) != 0) {
							//alert(volSheet.ColSaveName(ic) +" : "+ p1 + " - " + p2 + " = " + (p1 - p2));
							getBtnObject("btn_VarianceDtl").style.color = "red";
							ComShowMessage(ComGetMsg("BKG08071", volSheet.ColSaveName(ic)));
							return false;
						}
					}
					getBtnObject("btn_VarianceDtl").style.color = "#737373";
				}
				
				/*
				 * Booking Container 화면에서 Container Confirm 시, 
           		 * C/M 과 동일한 로직 적용 하여 ESM_BKG_0958 메뉴를 Open 하여 Volume 정보 Update
				 * updated on 2012-05-09 by LaSangbo
				*/
				
				var bkg_pck_qty   = ComTrimAll(document.getElementById("ori_bkg_pck_qty").innerText, ",");
				var bkg_pck_unit  = sheetObjects[1].CellValue(1, "pck_tp_cd");
				var bkg_wgt_qty   = ComTrimAll(document.getElementById("ori_bkg_act_wgt").innerText, ",");
				var bkg_wgt_unit  = document.getElementById("wgt_ut_cd").innerText;
				var bkg_meas_qty  = ComTrimAll(document.getElementById("ori_bkg_meas_qty").innerText, ",");
				var bkg_meas_unit = document.getElementById("meas_ut_cd").innerText;
				var cm_pck_qty    = ComTrimAll(document.getElementById("cntr_pck_qty").innerText, ",");
				var cm_pck_unit   = bkg_pck_unit;
				var cm_wgt_qty    = ComTrimAll(document.getElementById("cntr_act_wgt").innerText, ",");
				var cm_wgt_unit   = bkg_wgt_unit;
				var cm_meas_qty   = ComTrimAll(document.getElementById("cntr_meas_qty").innerText, ",");
				var cm_meas_unit  = bkg_meas_unit;

//					alert("pck_qty : " + bkg_pck_qty + " = " + cm_pck_qty + "\n" +
//						  "act_wgt : " + bkg_wgt_qty + " = " + cm_wgt_qty + "\n" +
//						  "meas_qty : " + bkg_meas_qty + " = " +cm_meas_qty + "\n");
				if(bkg_pck_qty != cm_pck_qty || bkg_wgt_qty != cm_wgt_qty || bkg_meas_qty != cm_meas_qty){
                    var url="ESM_BKG_0958.do" +
                            "?bkg_pck_qty=" + bkg_pck_qty +
                            "&bkg_pck_unit=" + bkg_pck_unit +
                            "&bkg_wgt_qty=" + bkg_wgt_qty +
                            "&bkg_wgt_unit=" + bkg_wgt_unit +
                            "&bkg_meas_qty=" + bkg_meas_qty +
                            "&bkg_meas_unit=" + bkg_meas_unit +
                            "&cm_pck_qty=" + cm_pck_qty +
                            "&cm_pck_unit=" + cm_pck_unit +
                            "&cm_wgt_qty=" + cm_wgt_qty +
                            "&cm_wgt_unit=" + cm_wgt_unit +
                            "&cm_meas_qty=" + cm_meas_qty +
                            "&cm_meas_unit=" + cm_meas_unit +
                            "&sub_title=Container";

					ComOpenWindowCenter(url, "ESM_BKG_0958", 600, 300, true);
					
					if(decision_flag==0){
						eurFlg = "Y";
					}else if(decision_flag==1){
						formObj.bkg_pck_qty.value = cm_pck_qty;
						formObj.bkg_wgt_qty.value  = cm_wgt_qty;
						formObj.bkg_meas_qty.value = cm_meas_qty;
						eurFlg = "N";

					}else {
						return false;
					}
				}
			break;

            case MULTI02:
				/*
				1. BKG No 체크  - [BKG00183] 표시 후 리턴
				2. BKG Split no 체크  - 없을 경우 공백 2자리로 변경
				3. [BKG00181] 메세지 표시
				4. CA 여부 체크  - CA 상태이면 메세지 [BKG00182] 표시하고 리턴
				5. C(onfrim) 전체에 언체크표시
				*/
				if(!confirm(ComGetMsg("BKG00181"))){
					return false;
				}

				var cntrSheet = sheetObjects[1];
				var cntrCount = cntrSheet.RowCount;
				for(ir=1;ir<=cntrCount;ir++){
					cntrSheet.CellValue2(ir, "cntr_cfm_flg") = 0;
				//	//changeCntrStatus
				//	changeCntrStatus(ir);
				}
				//
				//changeEditableByConfirm('RLS');

			break;

			case COMMAND03:
				/*
				1. 데이터 변경 여부 체크 - 변경 데이터 있을 경우 메시지 [BKG00178] 표시 후 리턴
				2. BKG status 체크 - status가 "X"일 경우 메시지 [BKG00433] 표시 후 리턴
				3. BDR 및 CA 체크 - BDR = "Y", CA = "N"일 경우 메시지 [BKG00335] 표시 후 리턴 처리
				*/
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
					if(dirty_flag.value == 'Y'){
						ComShowMessage(ComGetMsg("BKG00178"));
						return false;
					}
					if(bkg_sts_cd.value == 'X'){
						ComShowMessage(ComGetMsg("BKG00433"));
						return false;
					}
					if(bdr_flg.value == 'Y' && corr_flg.value == 'N'){
						ComShowMessage(ComGetMsg("BKG00335"));
						return false;
					}
				}

				if(ComIsEmpty(sheetObj.CellValue(sheetObj.SelectRow, "cntr_no"))){
					ComShowMessage(ComGetMsg("BKG00753"));
					sheetObj.SelectCell(sheetObj.SelectRow, "cntr_no") ;
					return false;
				}
						
			break;

			case COMMAND04: 
				with (formObj) {
					if(ComIsEmpty(bkg_no.value)){
						ComShowMessage(ComGetMsg("BKG00463"));
						bkg_no.focus();
						return false;
					}
				}
			break;

        	case MODIFY01:
        		var idx = 0;
        		var cnt1 = cnt2 = 0;
        		cntrs = new Array();
				for (var i=sheetObj.HeaderRows; i<=sheetObj.RowCount; i++) {
					if ("N"==sheetObj.CellValue(i,"cgo_rcv_dt_flg")) {
						cnt1++;
					}
					if (""==sheetObj.CellValue(i,"cgo_rcv_dt")) {
						cnt2++;
					}
//					if ("N"==sheetObj.CellValue(i,"cgo_rcv_dt_flg") || ""==sheetObj.CellValue(i,"cgo_rcv_dt")) {
					if (""==sheetObj.CellValue(i,"cgo_rcv_dt")) {
						cntrs[idx++] = sheetObj.CellValue(i,"cntr_no");
					}
				}
				isWarnMsg = 0<cnt1 && 0<cnt2;
        		var arrRow = ComFindText(sheetObj, "cgo_rcv_dt_flg", "N");
				if (arrRow) {
					for (var i=0; i<arrRow.length; i++) {
						if (!ComIsEmpty(sheetObj.CellValue(arrRow[i], "cgo_rcv_dt"))) {
							if ("N"==sheetObj.CellValue(arrRow[i], "cgo_rcv_dt_flg")) {
								return true;
							}
						}
					}
				}
				return false;
        	break;

		}
        return true;
    }

	/* --------------------------------------------------------------------
	 * Event 처리
	 ---------------------------------------------------------------------- */
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}

    function form1_blur(){
		//ComChkObjValid(event.srcElement);
    }
	
	function form1_keypress(){
		//
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[1], document.form, IBSEARCH);
			//ComKeyEnter("search");
		}
		switch(event.srcElement.dataformat){
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
			case "ym":
			case "yw":
			case "jumin":
			case "saupja":	//숫자 + "-"
				ComKeyOnlyNumber(event.srcElement, "-"); 
			break;
			case "hms":
			case "hm":		//숫자 + ":"
				ComKeyOnlyNumber(event.srcElement, ":"); 
			break;
			case "int":		//숫자
				ComKeyOnlyNumber(event.srcElement); 
			break;
			case "float":	//숫자+"."	            
				ComKeyOnlyNumber(event.srcElement, "."); 
			break;	    
			case "engup":
				//영문대문자
				ComKeyOnlyAlphabet("upper");
			break;
			case "engupnum":
				//숫자+"영문대분자"입력하기
				ComKeyOnlyAlphabet("uppernum");
			break;
			case "engupnumspc":
				//영문대문자 + 숫자 + 스페이스
				//ComKeyOnlyAlphabet("uppernum", "32|45|95");
				var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
				if(keyValue >= 97 && keyValue <= 122){
                	event.keyCode = keyValue + 65 - 97;
				}
				//event.returnValue = true;
			break;
		}	
	}
	
    function form1_change(){
		/* 대문자 */
		//if(event.srcElement.type =="text") {
		//	event.srcElement.value = event.srcElement.value.toUpperCase();
		//}
		// 데이터 변경 여부 체크
		//document.form.dirty_flag.value = 'Y';

        var srcName = event.srcElement.getAttribute("name");
        switch(srcName){
            case "bkg_wgt_ut_cd":
            case "bkg_meas_ut_cd":
				for (rn=1; rn<=sheetObjects[1].RowCount; rn++) {
					sheetObjects[1].CellValue2(rn, srcName.substring(4)) = event.srcElement.value;
				}
				// calculateCntrQty
				calculateCntrQty();
				// 데이터 변경 여부 체크
				document.form.dirty_flag.value = 'Y';
            break;
        }
    }

	function t6sheet2_OnPopupClick(sheetObj, row, col){
		
        var col_name = sheetObj.ColSaveName(col);
		switch(col_name) {
			
			case "SEALPop":
				var bkg_no       = sheetObj.cellValue(row, "bkg_no");
				var cntr_no      = sheetObj.cellValue(row, "cntr_no");
		
				if(cntr_no==''){
					ComShowMessage(ComGetMsg("BKG00443"));
					return;
				}
				var url = "ESM_BKG_0697.do?bkg_no=" +bkg_no+ "&cntr_no=" + cntr_no;
				//ComOpenWindow(url, "ESM_BKG_0697", "width=300,height=280", false);이거아님
				ComOpenWindowCenter(url, "ESM_BKG_0697", 300, 400, true)

				
			break;
			
			case "PCKPop":
				//var url = "ESM_BKG_0696.do";
				//ComOpenWindow(url, "ESM_BKG_0696", "width=400,height=389", false);
				comBkgCallModal0696("callbackPckTp", sheetObj.CellValue(row, "pck_tp_cd"));
			break;
			
			case "vgm_vrfy_dt":
				if ("vgm_vrfy_dt"==sheetObj.ColSaveName(col)) {
		    		new ComCalendarGrid().select(sheetObj, row, col, 'yyyy-MM-dd');
		    	}
			break;
			
			case "vgm_dtmn_dt":
				if ("vgm_dtmn_dt"==sheetObj.ColSaveName(col)) {
		    		new ComCalendarGrid().select(sheetObj, row, col, 'yyyy-MM-dd');
		    	}
			break;
//			sheetObjects[1].ColHidden("vgm_vrfy_dt") = true;
//			sheetObjects[1].ColHidden("vgm_dtmn_dt") = true;
		}		
	}

	function t6sheet2_OnSearchEnd(sheetObj, errMsg) {
		with (sheetObj) {
			for (var i=HeaderRows; i<=RowCount; i++) {
				if ("N"==CellValue(i,"cgo_rcv_dt_flg")) {
					CellFontColor(i,"cgo_rcv_dt") = RgbColor(255, 0, 0);
				}
			}
			//OF 개수 계산을 위해 이중 for문
			var cnt = 0;
			for (var i=HeaderRows; i<=RowCount; i++) {
				for (var j=HeaderRows; j<=RowCount; j++) {
					if("1"==CellValue(j,"one_wy_free_flg") && CellValue(j,"cntr_tpsz_cd")==sheetObjects[0].CellValue(i,"cntr_tpsz_cd"))
						cnt += CellValue(j,"cntr_vol_qty");
				}
				sheetObjects[0].CellValue2(i,"of_qty") = cnt;
				cnt = 0;
			}
		}
	}

	function t6sheet2_OnSaveEnd(sheetObj, errMsg) {
		if(errMsg == "") doActionIBSheet(sheetObj,document.form,IBSEARCH) ;
	}
	
	function t6sheet2_OnDblClick(sheetObj, row, col) {
		//alert("OnDblClick -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
	}

	function t6sheet2_OnKeyDown(sheetObj, row, col, keyCode, shift) {
		//alert("OnKeyDown -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col));
		if( sheetObj.ColSaveName(col) =="cntr_no")
		{
			before_edit_val = sheetObj.CellValue(row, col);
		}
	}

	function t6sheet2_OnBeforeEdit(sheetObj, row, col, val) {
		//alert("OnBeforeEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col) + " (" +val+ ")");
		before_edit_val = sheetObj.CellValue(row, col);

	}

	function t6sheet2_OnAfterEdit(sheetObj, row, col, val) {
		//alert("OnAfterEdit -> " + sheetObj.ColSaveName(col) + " = " + sheetObj.cellValue(row, col))
	}

	function saveSeal(flg, cntr_no){
		if(flg != null && flg == 'Y'){
			var cntrObj = sheetObjects[1];
			var arrRow = ComFindText(cntrObj, "cntr_no", cntr_no);
			
			// Insert인 경우는 유지하게 변경
			if(cntrObj.CellValue(arrRow,"ibflag") != "I")
				cntrObj.CellValue2(arrRow,"ibflag") = "U";
		}
	}
	function t6sheet2_OnChange(sheetObj, row, col, val) {
		// 데이터 변경 여부 체크
		document.form.dirty_flag.value = 'Y';

		/* 대문자 */
		var data_type = sheetObj.ReadDataProperty(row, col, 0);
		if(data_type == dtData) {
			sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase();
		}	
		
		/* ColSaveName */
	    var col_save_name = sheetObj.ColSaveName(col);
        var bkg_no        = sheetObj.CellValue(row, "bkg_no");
        var cntr_no       = sheetObj.CellValue(row, "cntr_no");    	   	
    	
		/* seal1_no */
		if (col_save_name == "seal1_no") {
			//if(ComIsEmpty(val)){
			//	sheetObj.CellValue2(row, "seal1_knd_cd") = '';
			//	sheetObj.CellValue2(row, "seal1_pty_tp_cd") = '';
			//}
			
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;
			
			
			if(len == 0){
				if(ComIsEmpty(val)){
					//alert("ComIsEmpty:" + val);
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = val;
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal1_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal1_knd_cd");
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal1_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal1_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[0], "cntr_seal_no") = '';
				}else{
					sealObj.CellValue2(arrRow[0], "cntr_seal_no") = val;
				}
			}
			ComRowDelete(sealObj, "cntr_seal_no", '');
			//
			setAllSealNo();
		}

		/* seal1_knd_cd */
		if (col_save_name == "seal1_knd_cd") {
			if(ComIsEmpty(sheetObj.CellValue(row, "seal1_no"))){				
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.1]"));
				return false;
			}
			
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal1_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = val;
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal1_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal1_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[0], "seal_knd_cd") = '';
				}else{
					sealObj.CellValue2(arrRow[0], "seal_knd_cd") = val;
				}
			}
		}

		/* seal1_pty_tp_cd */
		if (col_save_name == "seal1_pty_tp_cd") {
			if(ComIsEmpty(sheetObj.CellValue(row, "seal1_no"))){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.1]"));
				return false;
			}
			
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal1_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal1_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal1_knd_cd");
					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = val;
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[0], "seal_pty_tp_cd") = '';
				}else{
					sealObj.CellValue2(arrRow[0], "seal_pty_tp_cd") = val;
				}
			}
		}

		/* seal2_no */
		if (col_save_name == "seal2_no") {
			//if(ComIsEmpty(val)){
			//	sheetObj.CellValue2(row, "seal2_knd_cd") = '';
			//	sheetObj.CellValue2(row, "seal2_pty_tp_cd") = '';
			//}
						
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;	
			
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = val;
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal2_knd_cd");
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal2_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal2_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else if(len == 1){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = val;
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal2_knd_cd");
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal2_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal2_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[1], "cntr_seal_no") = '';
				}else{
					sealObj.CellValue2(arrRow[1], "cntr_seal_no") = val;
				}
			}
			ComRowDelete(sealObj, "cntr_seal_no", '');
			//
			setAllSealNo();
		}

		/* seal2_knd_cd */
		if (col_save_name == "seal2_knd_cd") {
			if(ComIsEmpty(sheetObj.CellValue(row, "seal2_no"))){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.2]"));
				return false;
			}
			
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal2_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = val;
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal2_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal2_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else if(len == 1){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal2_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = val;
//					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = (sheetObj.CellValue(row, "seal2_pty_tp_cd") == '') ? "SH" : sheetObj.CellValue(row, "seal2_pty_tp_cd");
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[1], "seal_knd_cd") = '';
				}else{
					sealObj.CellValue2(arrRow[1], "seal_knd_cd") = val;
				}
			}
		}

		/* seal2_pty_tp_cd */
		if (col_save_name == "seal2_pty_tp_cd") {
			if(ComIsEmpty(sheetObj.CellValue(row, "seal2_no"))){
				ComShowMessage(ComGetMsg("BKG00651", "Empty Column! [Seal No.2]"));
				return false;
			}
			
			var sealObj = sheetObjects[2];
			var arrRow = ComFindText(sealObj, "cntr_no", cntr_no);
			var len = arrRow.length;
			if(len == 0){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal2_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal2_knd_cd");
					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = val;
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else if(len == 1){
				if(ComIsEmpty(val)){
					// do nothing!
				}else{
					var newRow = sealObj.DataInsert(-1);
					sealObj.CellValue2(newRow, "bkg_no") = bkg_no;
					sealObj.CellValue2(newRow, "cntr_no") = cntr_no;
					sealObj.CellValue2(newRow, "cntr_seal_no") = sheetObj.CellValue(row, "seal2_no");
					sealObj.CellValue2(newRow, "seal_knd_cd") = (sheetObj.CellValue(row, "seal2_knd_cd") == '') ? "M" : sheetObj.CellValue(row, "seal2_knd_cd");
					sealObj.CellValue2(newRow, "seal_pty_tp_cd") = val;
					sealObj.CellValue2(newRow, "prn_flg") = 1;
					sealObj.CellValue2(newRow, "old_cntr_no") = cntr_no;
				}
			} else {
				if(ComIsEmpty(val)){
					sealObj.CellValue2(arrRow[1], "seal_pty_tp_cd") = '';
				}else{
					sealObj.CellValue2(arrRow[1], "seal_pty_tp_cd") = val;
				}
			}
		}
		
		// 
		if(col_save_name == "seal1_no" || col_save_name == "seal2_no"){
			if(!allTypeSealNoDupChk(sheetObj)) {
	    		return false;
			}
		}
			
		/* Confirm Flag 수정 */
		if(col_save_name == "cntr_cfm_flg"){
			// cntr no 가 입력되었는지 체크
			if(ComIsEmpty(cntr_no)){
				ComShowMessage(ComGetMsg("BKG00169"));
				sheetObj.SelectCell(row, "cntr_no");
				return false;
			}
			//changeCntrStatus
			//changeCntrStatus(row);
			
			// 재수출 화물의 경우 Do Issue가 안되었을 경우 BKG00170 메세지 출력
			//if(sheetObj.CellValue(row, "do_no") == ''){
			//	ComShowMessage(ComGetMsg("BKG00170"));
			//	sheetObj.SelectCell(row, "do_no");
			//	return false;
			//}
		}

		/* Container No 수정 */
		if(col_save_name == "cntr_no"){
			//alert(col_save_name + ":\nbefore_edit_val=" + before_edit_val + ",\ncntr_no=" + cntr_no + ",\nSearchedValue="+sheetObj.CellSearchValue(row, "cntr_no"));
			// check NULL
			if(cntr_no == '') {
				//ComShowMessage(ComGetMsg("BKG00753"));
				//sheetObj.CellValue2(row, "cntr_no") = before_edit_val;
				//sheetObj.SelectCell(row, "cntr_no") ;
				return false;
			}
			
/*###########################################################################################*/			
			if( cntr_no != '' && before_edit_val != cntr_no) {
			   
				 if(ComIsEmpty(before_edit_val)){
					//alert("ComIsEmpty:" + before_edit_val);
				 }else{
					var sealObj2 = sheetObjects[2];
					 
					var arrRow2 = ComFindText(sealObj2, "old_cntr_no", before_edit_val);
				    var len2 = arrRow2.length;						
				    
					if(len2 > 0){				
						for(i=0; i<arrRow2.length; i++){
							sealObj2.CellValue2(arrRow2[i],"cntr_no") = val;
						}
					}	
			    }
			}
/*###########################################################################################*/
			
			// Special Cargo
			if(sheetObj.CellValue(row,  "dcgo_flg")    == 1 ||
			   sheetObj.CellValue(row, "bb_cgo_flg")  == 1 ||
			   sheetObj.CellValue(row, "awk_cgo_flg") == 1 ||
			   sheetObj.CellValue(row, "rc_flg")      == 1 ){
			    ComShowMessage(ComGetMsg("BKG00171", before_edit_val));
				sheetObj.CellValue2(row, "cntr_no") = before_edit_val;
				sheetObj.SelectCell(row, "cntr_no") ;
				return false;
			}
			// 숫자이고 7자리일경우 [BKG00172] 메세지를 표시하고 Yes를 선택하면 HJCU를 앞에 붙여줌
			if(!isNaN(cntr_no) && cntr_no.length==7){
				if(confirm(ComGetMsg("BKG00172"))){
					cntr_no = "HJCU" + cntr_no;
					sheetObj.CellValue2(row, "cntr_no") = cntr_no;
				}
			}
			// 첫자리가 K이고 8자리이면 K를 KSCU로 변경
			if(cntr_no.charAt(0) == 'K' && cntr_no.length==8){
				//if(confirm(ComGetMsg("BKG00172"))){
					cntr_no = "KSCU" + cntr_no.substring(1);
					sheetObj.CellValue2(row, "cntr_no") = cntr_no;
				//}
			}
			
			// 중복되는 CNTR No.를 넣은 경우 메시지 [BKG00965] 표시후 입력한 Data 삭제후 focus
			for(ir=sheetObj.HeaderRows;ir<=sheetObj.RowCount;ir++){
				var tmpNo = sheetObj.CellValue(ir, "cntr_no");
				if(ir==row) continue;
				//alert(ir + ":" + cntr_no + "=" + tmpNo + "=")
				if(cntr_no.replace(/\s/gi,"") == tmpNo.replace(/\s/gi,"")){
					ComShowMessage(ComGetMsg("BKG00965", cntr_no.replace(/\s/gi,"")));
					sheetObj.CellValue2(row, "cntr_no") = '';
					sheetObj.SelectCell(row, "cntr_no") ;
					return false;
				}
			}
			
			// cntr tpsz 가져오기 및 각종 데이터 설정. 잘못된 Container No를 넣으면 메세지 표시[BKG00173]
			try{
				ComOpenWait(false);
			// make empty
			//ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no,cntr_no_old,cntr_tpsz_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
			// search container
			var cntrXml = sheetObjects[1].GetSearchXml("ESM_BKG_0079_04GS.do", "f_cmd="+SEARCH01+"&bkg_no="+bkg_no+"&cntr_no=" + cntr_no);
			// XML Parsing
			var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.async="false";
			xmlDoc.loadXML(cntrXml);
			
			var dataNode = xmlDoc.documentElement.getElementsByTagName("ETC-DATA").item(0);
			var dataChildNodes = dataNode.childNodes;
			//alert(dataChildNodes.length);
			if(dataChildNodes.length > 0){
				var hasCntr = false;
				for (ic=0; ic<dataChildNodes.length; ic++) {
					var xName = dataChildNodes.item(ic).getAttribute("KEY");
					if(xName == "cntr_no") {
						hasCntr = true;
						break;
					}
				}
				
				if(hasCntr){
					for (ic=0; ic<dataChildNodes.length; ic++) {
						var xName = dataChildNodes.item(ic).getAttribute("KEY");
						if(xName == "ibflag") continue;
						sheetObj.CellValue2(row, xName) = dataChildNodes.item(ic).text
					}
					cntr_no = sheetObj.CellValue(row, "cntr_no");
				}else{
					sheetObj.CellValue2(row, "cntr_no") = '';
				}
			}
			}finally{
				ComOpenWait(false);
			}
			

			//alert(sheetObj.CellValue(row, "cntr_no") + "/" + sheetObj.CellValue(row, "cntr_tpsz_cd"));
			if(sheetObj.CellValue(row, "cntr_no") == '' || sheetObj.CellValue(row, "cntr_tpsz_cd") == ''){
				ComShowMessage(ComGetMsg("BKG00173", cntr_no));
				sheetObj.CellValue2(row, "cntr_no") = '';
				sheetObj.SelectCell(row, "cntr_no") ;
				return false;
			//}else{
			//	//calculateCntrQty
			//	calculateCntrQty();
			//	return true;
			}
			
			//R로 시작하는 경우 RF없을 경우 RD로 인식 
			if(sheetObj.CellValue(row, "cntr_tpsz_cd").substring(0,1) == "R" && sheetObj.CellValue(row, "rc_flg") == 0 ) {
				sheetObj.CellValue2(row, "rd_cgo_flg") = 1;
			}
			
			// 존재하지 않은 Type Code를 사용하는지 체크.
			var cTp = sheetObj.CellValue(row, "cntr_tpsz_cd");
			if((cTp == 'D4' || cTp == 'D5') && document.form.flex_hgt_flg.value == 'Y'){
				// ignore it!
			}else{
				var qTpArr = ComFindText(sheetObjects[0], "cntr_tpsz_cd", cTp);
				if(qTpArr.length == 0){
					ComShowMessage(ComGetMsg("BKG00062", cTp));
					ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no_old,seal1_no,seal1_knd_cd,seal1_pty_tp_cd,seal2_no,seal2_knd_cd,seal2_pty_tp_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
					return false;
				}else if(sheetObjects[0].CellValue(qTpArr[0], "op_cntr_qty") == '' || sheetObjects[0].CellValue(qTpArr[0], "op_cntr_qty") == 0){
					ComShowMessage(ComGetMsg("BKG00062", cTp));
					ComMakeEmptyRow(sheetObj, row, "ibflag,cntr_dp_seq,bkg_no,cntr_cfm_flg,cntr_no_old,seal1_no,seal1_knd_cd,seal1_pty_tp_cd,seal2_no,seal2_knd_cd,seal2_pty_tp_cd,rcv_term_cd,de_term_cd,cnmv_sts_cd");
					return false;
				}
			}
			
			// seal no 변경
			if(!ComIsEmpty(before_edit_val)){
				var arr_sealno = ComFindText(sheetObjects[2], "cntr_no", before_edit_val);
				//alert(before_edit_val + " -> " + cntr_no + " : " + arr_sealno);
				for(ir=0;ir<arr_sealno.length;ir++){
					//sheetObjects[2].CellValue2(arr_sealno[ir], "cntr_no") = cntr_no;
					sheetObjects[2].RowStatus(arr_sealno[ir]) = 'D';
				}
			}
			
			//calculateCntrQty
			calculateCntrQty();
		}
		
		/* package */
		if(col_save_name == "pck_qty"){
			// quantity, package  재계산
			calculateCntrQty();
		}

		/* weight */
		if(col_save_name == "cntr_wgt"){
			// quantity, package  재계산
			calculateCntrQty();
			
			// 2015.12.03 [CHM-201538980] POD USLAX/USLGB, USOAK, USSEA 인 경우 Weight LIMITATION을 확인하고 초과하면 경고메세지
			var formObj = document.form;
			var podCd = ComGetObjValue(formObj.pod_cd).substring(0,5);
			if(podCd=="USLAX"||podCd=="USLGB"){
				var maxWgt = 0;
				var tpSz = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");  
				if(tpSz.substring(1,2) == "2"){
					maxWgt = 44000;
				}
				if(ComGetObjValue(formObj.bkg_wgt_ut_cd)=="KGS"){
					maxWgt = ComUnitConverter("LBSKGS", maxWgt);
				}
				if(maxWgt!=0 && BkgParseFloat(sheetObjects[1].CellValue(row, "cntr_wgt")) > maxWgt){
					ComShowCodeMessage("BKG08350","20ft: 44,000LBS");
				}
			}else if(podCd=="USOAK"||podCd=="USSEA"){
				var maxWgt = 0;
				var tpSz = sheetObjects[1].CellValue(row, "cntr_tpsz_cd");  
				if(tpSz.substring(1,2) == "2"){
					maxWgt = 47000;
				}else{
					maxWgt = 57000;
				}
				if(ComGetObjValue(formObj.bkg_wgt_ut_cd)=="KGS"){
					maxWgt = ComUnitConverter("LBSKGS", maxWgt);
				}
				if(maxWgt!=0 && BkgParseFloat(sheetObjects[1].CellValue(row, "cntr_wgt")) > maxWgt){
					ComShowCodeMessage("BKG08350","(20ft: 47,000LBS, 40,45ft:57,000LBS)");
				}
			}
			
		}

		/* Measure */
		if(col_save_name == "meas_qty"){
			//alert(parseFloat(sheetObj.CellValue(row, "meas_qty")) + "-->" + (parseFloat(sheetObj.CellValue(row, "meas_qty")) >= 1000));
			if(sheetObj.CellValue(row, "meas_qty") >= 1000){
				ComShowMessage(ComGetMsg("BKG00174"));
				sheetObj.CellValue2(row, "meas_qty") = 0;
				sheetObj.SelectCell(row, "meas_qty");
				return false;
			}
			// quantity, package  재계산
			calculateCntrQty();
		}

		/* Volumn */
		if(col_save_name == "cntr_vol_qty"){
			//alert("OnChange -> cntr_vol_qty = " + sheetObj.CellValue(row, "cntr_vol_qty") + "(" + val + ")");
			//
			//var col_save_name = sheetObj.ColSaveName(col);
			//if(col_save_name == "cntr_vol_qty"){
				/* Cntr이 final confirm이 된경우에 partial volumn 경우 */
				if(document.form.fnl_cfm_flg.value == 'Y') {
					var bkg_no        = sheetObj.CellValue(row, "bkg_no");
					var cntr_no       = sheetObj.CellValue(row, "cntr_no");	
					// 
					var url = "ESM_BKG_1050.do?func=calbackAdjVol&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&cntr_vol="+val;
					ComOpenWindowCenter(url, "ESM_BKG_1050", 400, 440, true);
					// set focus
					//sheetObj.SelectCell(row, "cntr_vol_qty", false);				
				} else{
					// search confirm booking
					var bkg_no  = sheetObj.CellValue(row, "bkg_no");
					var cntr_no = sheetObj.CellValue(row, "cntr_no");
					//alert(bkg_no + ":" + cntr_no);
					var rXml    = sheetObjects[1].GetSearchXml("ESM_BKG_0079_04GS.do", "f_cmd="+SEARCH02+"&bkg_no="+bkg_no+"&cntr_no="+cntr_no);
					//alert(rXml);
					var rFlg = ComGetEtcData(rXml, "PTL_CFRM_FLG");
					//alert("rFlg -> " + rFlg);
					if(rFlg == 'Y'){
						// 
						var url = "ESM_BKG_1050.do?func=calbackAdjVol&bkg_no="+bkg_no+"&cntr_no="+cntr_no+"&cntr_vol="+val;
						ComOpenWindowCenter(url, "ESM_BKG_1050", 400, 440, true);
						// set editable = flase 
						//sheetObj.SelectCell(row, "cntr_vol_qty", false);					
					}
				}
			//}			
			// 0 <= vol < 1
			if(sheetObj.CellValue(row, "cntr_vol_qty") <= 0 || sheetObj.CellValue(row, "cntr_vol_qty") > 1 ){
				// Not OK
				ComShowMessage(ComGetMsg("BKG08013"));
				sheetObj.CellValue2(row, "cntr_vol_qty") = before_edit_val;
				sheetObj.SelectCell(row, "cntr_vol_qty", false);
				return false;
			}
			// vol == 1 -> P
			if(sheetObj.CellValue(row, "cntr_vol_qty") == 1){
				sheetObj.CellValue2(row, "cntr_prt_flg") = 0;
			}else{
				sheetObj.CellValue2(row, "cntr_prt_flg") = 1;
			}
			// quantity, package  재계산
			calculateCntrQty();
			// open window
		}

		/* adv_shtg_cd */
		if(col_save_name == "adv_shtg_cd"){
			if(ComIsEmpty(sheetObj.CellValue(row, "adv_shtg_cd")) || sheetObj.CellValue(row, "adv_shtg_cd") == 'A' || sheetObj.CellValue(row, "adv_shtg_cd") == 'S'){
				// OK
			}else{
				ComShowMessage(ComGetMsg("BKG00651", "AS Field!"));
				sheetObj.CellValue2(row, "adv_shtg_cd") = before_edit_val;
				sheetObj.SelectCell(row, "adv_shtg_cd") ;
				return false;
			}
		}
		
		/* Sub */
		if(col_save_name == "eq_subst_tpsz_cd"){
			if(sheetObj.CellValue(row, "eq_subst_tpsz_cd") == 1){
				ComShowMessage(ComGetMsg("BKG00174"));
			}
		}

	}

	function changeEditableByConfirm(cfrm){
		var formObj = document.form;
		//alert("BDR : " +(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N')+ " -> " + cfrm);
		if(scrnAuth == "R") return;
		if(formObj.bdr_flg.value == 'Y' && formObj.corr_flg.value == 'N'){
			if(cfrm == 'CFM'){
				// button
				ComBtnDisable("btn_t6save");
//				ComBtnDisable("btn_t6cntrconfirm");
//				ComBtnDisable("btn_t6cntrrelease");
//				ComBtnDisable("btn_t6gridcntrirr");
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				ComBtnDisable("btn_t6sequp");
				ComBtnDisable("btn_t6seqdown");
				// sheet
				sheetObjects[0].Editable = false;
				sheetObjects[1].Editable = false;
				sheetObjects[2].Editable = false;
				// object
				formObj.bkg_wgt_ut_cd.disabled = true;
				formObj.bkg_meas_ut_cd.disabled = true;
			}else{
				// button
				//ComBtnDisable("btn_t6save");
//				ComBtnDisable("btn_t6cntrconfirm");
//				ComBtnDisable("btn_t6cntrrelease");
//				ComBtnDisable("btn_t6gridcntrirr");
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				//ComBtnDisable("btn_t6sequp");
				//ComBtnDisable("btn_t6seqdown");
				// sheet
				sheetObjects[0].Editable = false;
				sheetObjects[1].Editable = false;
				sheetObjects[2].Editable = false;
				// object
				formObj.bkg_wgt_ut_cd.disabled = true;
				formObj.bkg_meas_ut_cd.disabled = true;
			}
		}else{
			if(cfrm == 'CFM'){
				// button
				//ComBtnDisable("btn_t6save");
//				ComBtnDisable("btn_t6gridcntrirr");
				ComBtnDisable("btn_t6gridadd");
				ComBtnDisable("btn_t6griddel");
				ComBtnDisable("btn_t6gridmove");
				ComBtnDisable("btn_t6sequp");
				ComBtnDisable("btn_t6seqdown");
//				ComBtnDisable("btn_t6cntrconfirm");
//				ComBtnEnable("btn_t6cntrrelease");
				// sheet
				sheetObjects[0].Editable = true;
				sheetObjects[1].Editable = true;
				sheetObjects[2].Editable = true;
				// object
				formObj.bkg_wgt_ut_cd.disabled = false;
				formObj.bkg_meas_ut_cd.disabled = false;
				
				for(ir=1;ir<=sheetObjects[1].RowCount ;ir++ ){
					sheetObjects[1].CellEditable(ir, "cntr_no") = false;
					sheetObjects[1].CellEditable(ir, "rcv_term_cd")  = false;
					sheetObjects[1].CellEditable(ir, "de_term_cd")   = false;
					sheetObjects[1].CellEditable(ir, "cntr_vol_qty") = false;
					sheetObjects[1].CellEditable(ir, "adv_shtg_cd")  = false;								
					sheetObjects[1].CellEditable(ir, "hngr_flg") = false;
				}
			}else{
				// button
				//ComBtnEnable("btn_t6save");
//				ComBtnEnable("btn_t6gridcntrirr");
				ComBtnEnable("btn_t6gridadd");
				ComBtnEnable("btn_t6griddel");
				ComBtnEnable("btn_t6gridmove");
				ComBtnEnable("btn_t6sequp");
				ComBtnEnable("btn_t6seqdown");
//				ComBtnEnable("btn_t6cntrconfirm");
//				ComBtnDisable("btn_t6cntrrelease");
				// sheet
				sheetObjects[0].Editable = true;
				sheetObjects[1].Editable = true;
				sheetObjects[2].Editable = true;
				// object
				formObj.bkg_wgt_ut_cd.disabled = false;
				formObj.bkg_meas_ut_cd.disabled = false;
				
				for(ir=1;ir<=sheetObjects[1].RowCount ;ir++ ){
					sheetObjects[1].CellEditable(ir, "cntr_no") = true;
//					if(document.form.rcv_term_cd.value != 'M'){
//						sheetObjects[1].CellEditable(ir, "rcv_term_cd") = false;
//					}else{
//						sheetObjects[1].CellEditable(ir, "rcv_term_cd")  = true;
//					}
//					if(document.form.de_term_cd.value != 'M'){
//						sheetObjects[1].CellEditable(ir, "de_term_cd") = false;
//					}else{
//						sheetObjects[1].CellEditable(ir, "de_term_cd")   = true;
//					}
					sheetObjects[1].CellEditable(ir, "cntr_vol_qty") = true;
					sheetObjects[1].CellEditable(ir, "adv_shtg_cd")  = true;								
					sheetObjects[1].CellEditable(ir, "hngr_flg") = true;
				}
			}
		}
		/* CNTR Confirm 을 BDR 과 상관없이 가능 하도록 적용 
		 * 단 C/A 일 경우 Block 처리 한다 (C/A 구현안됨)
		 */
		if(formObj.corr_flg.value == 'N'){
			if(cfrm == 'CFM'){
				ComBtnDisable("btn_t6cntrconfirm");
				ComBtnEnable("btn_t6cntrrelease");
			}else{
				ComBtnEnable("btn_t6cntrconfirm");
				ComBtnDisable("btn_t6cntrrelease");
			}
		}else{
			ComBtnDisable("btn_t6cntrconfirm");
			ComBtnDisable("btn_t6cntrrelease");
		}
	}

	function calculateCntrQty(){

		var qtyObj  = sheetObjects[0];
		var cntrObj = sheetObjects[1];

		var bkg_qty       = 0;
		//var bkg_spc_qty   = 0;
		var bkg_pck_qty   = 0;
		var bkg_act_wgt   = 0;
		var bkg_meas_qty  = 0;
		var cntr_qty      = 0;
		//var cntr_spc_qty  = 0;
		var cntr_pck_qty  = 0;
		var cntr_act_wgt  = 0;
		var cntr_meas_qty = 0;
		var var_qty       = 0;
		//var var_spc_qty   = 0;
		var var_pck_qty   = 0;
		var var_act_wgt   = 0;
		var var_meas_qty  = 0;
		//var tmp_cntr_vol  = 0;

		// quantity grid
		var qtyCount = qtyObj.RowCount;
		for(jr=1;jr<=qtyCount;jr++){
			//if(qtyObj.cellValue(jr, "cntr_tpsz_cd") != "Q2" || qtyObj.cellValue(jr, "cntr_tpsz_cd") != "Q4"){
			//	qtyObj.cellValue2(jr, "bkg_cntr_qty") = qtyObj.cellValue(jr, "op_cntr_qty");
			//	tmp_cntr_vol  += BkgParseFloat(qtyObj.cellValue(jr, "op_cntr_qty"));
			//} else {
				qtyObj.cellValue2(jr, "bkg_cntr_qty") = 0;
			//}
		}
		// container grid
		tpsz_chk = true; // 초기화
		for(ir=cntrObj.HeaderRows ;ir<=cntrObj.RowCount ;ir++ ){
			if(cntrObj.RowStatus(ir) != 'D'){
				// TpSz in 'container table'
				var cntrTpsz   = cntrObj.cellValue(ir, "cntr_tpsz_cd");
				var cntrVolQty = cntrObj.CellValue(ir, "cntr_vol_qty");
				//alert(ir + " -> " + cntrTpsz + " = " + cntrVolQty);
				if(cntrTpsz == '') continue;
				// TpSz in 'quantity table'
				var qtyTpSzs   = ComFindText(qtyObj, "cntr_tpsz_cd", cntrTpsz);
				
				if(document.form.flex_hgt_flg.value == "Y" && (qtyTpSzs == null || qtyTpSzs.length == 0)) {
					var flexCntrTpsz = "";
					if (cntrTpsz == "D4") {
						flexCntrTpsz = "D5";
					} else if(cntrTpsz == "D5"){
						flexCntrTpsz = "D4";
					}
					qtyTpSzs   = ComFindText(qtyObj, "cntr_tpsz_cd", flexCntrTpsz);
				}
				//alert(ir + " : " + cntrTpsz + " -> " + qtyTpSzs + " -> " + cntrVolQty);
				if(qtyTpSzs == null || qtyTpSzs.length == 0){
					ComShowMessage(ComGetMsg("BKG00651", "Container TP/SZ ('" +cntrTpsz+ "')"));
					tpsz_chk = false;
					return false;
					//var rno = qtyObj.DataInsert(-1);
					//qtyObj.CellValue2(rno, "bkg_no") = document.form.bkg_no.value;
					//qtyObj.CellValue2(rno, "cntr_tpsz_cd") = cntrTpsz;
					//qtyObj.CellValue2(rno, "op_cntr_qty") = 0;
					//qtyObj.CellValue2(rno, "bkg_cntr_qty") = cntrVolQty;

				}else{
					//alert(cntrTpsz + " : " + BkgParseFloat(qtyObj.cellValue(qtyTpSzs[0], "bkg_cntr_qty")) + " -> " + (BkgParseFloat(qtyObj.cellValue(qtyTpSzs[0], "bkg_cntr_qty")) + BkgParseFloat(cntrVolQty)));
					qtyObj.cellValue2(qtyTpSzs[0], "bkg_cntr_qty") = BkgParseFloat(qtyObj.cellValue(qtyTpSzs[0], "bkg_cntr_qty")) + BkgParseFloat(cntrVolQty);
					tpsz_chk = true;
				}
				//for(jn=1;jn<qtyCount;jn++){
				//	if(cntrTpsz == qtyObj.cellValue(jn, "cntr_tpsz_cd")){
				//		qtyObj.cellValue2(jn, "bkg_cntr_qty") = BkgParseInt(qtyObj.cellValue(jn, "bkg_cntr_qty")) + BkgParseFloat(cntrVolQty);
				//		break;
				//	}
				//}

				//alert("* cntr_qty     = " + BkgParseFloat(cntrVolQty) + "\n" +
				//      "* cntr_pck_qty = " + BkgParseFloat(cntrObj.CellValue(ir, "pck_qty")) + "\n" +
				//      "* cntr_act_wgt = " + BkgParseFloat(cntrObj.CellValue(ir, "cntr_wgt")) + "\n" +
				//      "* cntr_act_wgt = " + BkgParseFloat(cntrObj.CellValue(ir, "meas_qty")));

				cntr_qty      += BkgParseFloat(cntrVolQty);
				cntr_pck_qty  += BkgParseFloat(cntrObj.CellValue(ir, "pck_qty"));
				cntr_act_wgt  += BkgParseFloat(cntrObj.CellValue(ir, "cntr_wgt"));
				cntr_meas_qty += BkgParseFloat(cntrObj.CellValue(ir, "meas_qty"));
			}
		}
		// Q2, Q4 에 대한 수정
		//cntr_qty += tmp_cntr_vol;
		// Weight의 단위 환산
		var wgt1 =  document.getElementById("wgt_ut_cd").innerText;
		var wgt2 = ComGetObjValue(document.form.bkg_wgt_ut_cd);
		//alert("wgt1=" + wgt1 + ", wgt2=" + wgt2);
		if(wgt1 == '' || wgt1 == wgt2){
			// skip
		}else{
			cntr_act_wgt = ComUnitConverter(wgt2+wgt1, cntr_act_wgt);
		}
		// Measure의 단위 환산
		var meas1 = document.getElementById("meas_ut_cd").innerText;
		var meas2 = ComGetObjValue(document.form.bkg_meas_ut_cd);
		var measEx = 1;
		//alert("meas1=" + meas1 + ", meas2=" + meas2);
		if(meas1 == '' || meas1 == meas2){
			// skip
		}else{
			cntr_meas_qty = ComUnitConverter(meas2+meas1, cntr_meas_qty);
		}
		// 소숫점 이하 반올림
		cntr_qty      = Math.round(cntr_qty * 100) / 100;
		cntr_pck_qty  = Math.round(cntr_pck_qty);
		cntr_act_wgt  = Math.round(cntr_act_wgt * 1000) / 1000;
		cntr_meas_qty = Math.round(cntr_meas_qty * 1000) / 1000;
		//
		document.getElementById("cntr_qty").innerText      = ComAddComma3(String(cntr_qty), "#,###.00");
		//document.getElementById("cntr_spc_qty").innerText  = ComAddComma3(String(cntr_spc_qty), "#,###.00");
		document.getElementById("cntr_pck_qty").innerText  = ComAddComma3(String(cntr_pck_qty), "#,###");
		document.getElementById("cntr_act_wgt").innerText  = ComAddComma3(String(cntr_act_wgt), "#,###.000");
		document.getElementById("cntr_meas_qty").innerText = ComAddComma3(String(cntr_meas_qty), "#,###.000");

		bkg_qty      = BkgParseFloat(ComTrimAll(document.getElementById("bkg_qty").innerText, ","));
		//bkg_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("bkg_spc_qty").innerText, ","));
		bkg_pck_qty  = BkgParseFloat(ComTrimAll(document.getElementById("ori_bkg_pck_qty").innerText, ","));
		bkg_act_wgt  = BkgParseFloat(ComTrimAll(document.getElementById("ori_bkg_act_wgt").innerText, ","));
		bkg_meas_qty = BkgParseFloat(ComTrimAll(document.getElementById("ori_bkg_meas_qty").innerText, ","));

		/* Javascript의 parseFloat 함수의 오류(.00000001차이) 로 인해
		 * Variance를 계산하기 전에 강제로 소숫점을 잘라낸 수를 다시 사용한다. */
		cntr_qty      = BkgParseFloat(ComTrimAll(document.getElementById("cntr_qty").innerText, ","));
		//cntr_spc_qty  = BkgParseFloat(ComTrimAll(document.getElementById("cntr_spc_qty").innerText, ","));
		cntr_pck_qty  = BkgParseFloat(ComTrimAll(document.getElementById("cntr_pck_qty").innerText, ","));
		cntr_act_wgt  = BkgParseFloat(ComTrimAll(document.getElementById("cntr_act_wgt").innerText, ","));
		cntr_meas_qty = BkgParseFloat(ComTrimAll(document.getElementById("cntr_meas_qty").innerText, ","));

		var_qty      = bkg_qty - cntr_qty;
		//var_spc_qty  = bkg_spc_qty - cntr_spc_qty;
		var_pck_qty  = bkg_pck_qty - cntr_pck_qty;
		var_act_wgt  = bkg_act_wgt - cntr_act_wgt;
		var_meas_qty = bkg_meas_qty - cntr_meas_qty;
		var_qty      = Math.round(var_qty * 100) / 100;
		var_pck_qty  = Math.round(var_pck_qty);
		var_act_wgt  = Math.round(var_act_wgt * 1000) / 1000;
		var_meas_qty = Math.round(var_meas_qty * 1000) / 1000;		
		//alert("* var_qty      = " + bkg_qty +"-"+ cntr_qty +"="+ var_qty + "\n" +
		//      "* var_pck_qty  = " + bkg_pck_qty +"-"+ cntr_pck_qty +"="+ var_pck_qty + "\n" +
		//      "* var_act_wgt  = " + bkg_act_wgt +"-"+ cntr_act_wgt +"="+ var_act_wgt + "\n" +
		//      "* var_meas_qty = " + bkg_meas_qty +"-"+ cntr_meas_qty +"="+ var_meas_qty);
		
		document.getElementById("var_qty").innerText      = ComAddComma3(String(var_qty), "#,###.00");
		//document.getElementById("var_spc_qty").innerText  = ComAddComma3(String(var_spc_qty), "#,###.00");
		document.getElementById("var_pck_qty").innerText  = ComAddComma3(String(var_pck_qty), "#,###");
		document.getElementById("var_act_wgt").innerText  = ComAddComma3(String(var_act_wgt), "#,###.000");
		document.getElementById("var_meas_qty").innerText = ComAddComma3(String(var_meas_qty), "#,###.000");

		// text color
		document.getElementById("var_qty").style.backgroundColor = "#E8E7EC";
		if(var_qty != 0) document.getElementById("var_qty").style.color = "red";
		else document.getElementById("var_qty").style.color = "#606060";
		//document.getElementById("var_spc_qty").style.backgroundColor = "#E8E7EC";
		//if(var_spc_qty != 0) document.getElementById("var_spc_qty").style.color = "red";
		//else document.getElementById("var_spc_qty").style.color = "#606060";
		document.getElementById("var_pck_qty").style.backgroundColor = "#E8E7EC";
		if(var_pck_qty != 0) document.getElementById("var_pck_qty").style.color = "red";
		else document.getElementById("var_pck_qty").style.color = "#606060";
		document.getElementById("var_act_wgt").style.backgroundColor = "#E8E7EC";
		if(var_act_wgt != 0) document.getElementById("var_act_wgt").style.color = "red";
		else document.getElementById("var_act_wgt").style.color = "#606060";
		document.getElementById("var_meas_qty").style.backgroundColor = "#E8E7EC";
		if(var_meas_qty != 0) document.getElementById("var_meas_qty").style.color = "red";
		else document.getElementById("var_meas_qty").style.color = "#606060";
		
		// Variance DTL 버튼 - updated on 2010-01-18
		var volSheet = sheetObjects[4];
		for(ir=volSheet.HeaderRows ;ir<=volSheet.RowCount ;ir++ ){
			// cntr TP/SZ
			var tpSz = volSheet.CellValue(ir, "cntr_tpsz_cd");
			//alert(tpSz);
			var cntrQtyArr = getCntrQtyByType(tpSz);
			//alert(cntrQtyArr);
			for(ic=2 ;ic<=volSheet.LastCol ;ic++){
				var p1 = parseFloat(volSheet.CellValue(ir, ic));
				var p2 = parseFloat(cntrQtyArr[ic]);
				//alert(ir +","+ic + " : " +p1+"-" +p2+ "=" + (p1-p2));
				if((p1-p2) != 0) {
					getBtnObject("btn_VarianceDtl").style.color = "red";
					break;
				}else{
					getBtnObject("btn_VarianceDtl").style.color = "#737373";
				}
			}
		}
		
		// return
		return true;
	}

	function setAllSealNo(){
		var cntrObj = sheetObjects[1];

		var cntrCount = cntrObj.RowCount;
		for(idx=1;idx<=cntrCount;idx++){
			setSealNo(cntrObj.CellValue(idx, "cntr_no"));
		}
	}

	function setSealNo(cntr_no){
		var toObject = sheetObjects[1];
		var fmObject = sheetObjects[2];

		// Container 그리드 데이터 행의 개수 확인
		var arrToRow = ComFindText(toObject, "cntr_no", cntr_no);
		if(arrToRow.length == 0){
			//alert("SetSealNo : " + arrToRow);
			return;
		}
		if(arrToRow.length > 1){
//			alert("SetSealNo : " + arrToRow);
			//return;
		}

		// SealNo 그리드 데이터 행의 개수 확인
		var arrFmRow = ComFindText(fmObject, "cntr_no", cntr_no);
		if(arrFmRow.length==0){
			var stsCd = toObject.RowStatus(arrToRow[0]);
			toObject.CellValue2(arrToRow[0], "seal1_no") = '';
			toObject.CellValue2(arrToRow[0], "seal1_knd_cd") = '';
			toObject.CellValue2(arrToRow[0], "seal1_pty_tp_cd") = '';
			toObject.CellValue2(arrToRow[0], "seal2_no") = '';
			toObject.CellValue2(arrToRow[0], "seal2_knd_cd") = '';
			toObject.CellValue2(arrToRow[0], "seal2_pty_tp_cd") = '';
			toObject.RowStatus(arrToRow[0]) = stsCd;
		} else if(arrFmRow.length==1){
			var stsCd = toObject.RowStatus(arrToRow[0]);
			toObject.CellValue2(arrToRow[0], "seal1_no") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "cntr_seal_no");
			toObject.CellValue2(arrToRow[0], "seal1_knd_cd") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_knd_cd");
			toObject.CellValue2(arrToRow[0], "seal1_pty_tp_cd") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_pty_tp_cd");
			toObject.CellValue2(arrToRow[0], "seal2_no") = '';
			toObject.CellValue2(arrToRow[0], "seal2_knd_cd") = '';
			toObject.CellValue2(arrToRow[0], "seal2_pty_tp_cd") = '';
			toObject.RowStatus(arrToRow[0]) = stsCd;
		} else {
			var stsCd = toObject.RowStatus(arrToRow[0]);
			toObject.CellValue2(arrToRow[0], "seal1_no") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "cntr_seal_no");
			toObject.CellValue2(arrToRow[0], "seal1_knd_cd") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_knd_cd");
			toObject.CellValue2(arrToRow[0], "seal1_pty_tp_cd") = arrFmRow[0] == '' ? "" : fmObject.CellValue(arrFmRow[0], "seal_pty_tp_cd");
			toObject.CellValue2(arrToRow[0], "seal2_no") = arrFmRow[1] == '' ? "" : fmObject.CellValue(arrFmRow[1], "cntr_seal_no");
			toObject.CellValue2(arrToRow[0], "seal2_knd_cd") = arrFmRow[1] == '' ? "" : fmObject.CellValue(arrFmRow[1], "seal_knd_cd");
			toObject.CellValue2(arrToRow[0], "seal2_pty_tp_cd") = arrFmRow[1] == '' ? "" : fmObject.CellValue(arrFmRow[1], "seal_pty_tp_cd");
			toObject.RowStatus(arrToRow[0]) = stsCd;
		}
		
		// 데이터 변경 여부 체크
		document.form.dirty_flag.value = 'Y';
	}

	// set Seq. No
	function setSeq(change_ibflag){
		var rSeq = 1;
		var rCnt = sheetObjects[1].RowCount;
		for (rn = 1; rn <= rCnt; rn++) {
			var rsts = sheetObjects[1].RowStatus(rn);
			if(rsts != 'D'){
				sheetObjects[1].CellValue2(rn, "cntr_dp_seq") = rSeq++;

				if(sheetObjects[1].CellValue(rn,"ibflag") != "I"){
					sheetObjects[1].RowStatus(rn) = "U";
				}
			}
		}	
	}	

	/**/
	function getCntrQtyByType(cntrTpsz){
		var sheetObj = sheetObjects[1];
		var tpSzs = null;
		
		var dry_cgo_flg = 0;
		var dcgo_flg    = 0;
		var rc_flg      = 0;
		var awk_cgo_flg = 0;
		var bb_cgo_flg  = 0;
		var hngr_flg    = 0;
		var soc_flg     = 0;
		var rcv_term_y  = 0;
		var rcv_term_d  = 0;
		var rcv_term_s  = 0;
		var rcv_term_t  = 0;
		var rcv_term_i  = 0;
		var de_term_y   = 0;
		var de_term_d   = 0;
		var de_term_s   = 0;
		var de_term_t   = 0;
		var de_term_o   = 0;
		var op_cntr_qty = 0;
		
		tpSzs = ComFindText(sheetObj, "cntr_tpsz_cd", cntrTpsz);
		if(tpSzs != null && tpSzs.length > 0){
			for(idx=0;idx<tpSzs.length;idx++){
				// values
				var vol = ComIsEmpty(sheetObj.CellValue(tpSzs[idx], "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.CellValue(tpSzs[idx], "cntr_vol_qty"));
				var rterm = sheetObj.CellValue(tpSzs[idx], "rcv_term_cd");
				var dterm = sheetObj.CellValue(tpSzs[idx], "de_term_cd");
	
				// special cargo
				if(sheetObj.CellValue(tpSzs[idx], "dcgo_flg") == 1) dcgo_flg += vol;
				if(sheetObj.CellValue(tpSzs[idx], "rc_flg") == 1) rc_flg += vol;
				if(sheetObj.CellValue(tpSzs[idx], "awk_cgo_flg") == 1) awk_cgo_flg += vol;
				if(sheetObj.CellValue(tpSzs[idx], "bb_cgo_flg") == 1) bb_cgo_flg += vol;
				if(sheetObj.CellValue(tpSzs[idx], "hngr_flg") == 1) hngr_flg += vol;
				if(sheetObj.CellValue(tpSzs[idx], "soc_flg") == 1) soc_flg += vol;
				
				// dry cargo
				if(sheetObj.CellValue(tpSzs[idx], "dcgo_flg") == 0 && 
					sheetObj.CellValue(tpSzs[idx], "rc_flg") == 0 && 
					sheetObj.CellValue(tpSzs[idx], "awk_cgo_flg") == 0 && 
					sheetObj.CellValue(tpSzs[idx], "bb_cgo_flg") == 0){
					dry_cgo_flg += vol;
				}
	
				// receive term / delivery term
				if(rterm == 'Y') rcv_term_y  += vol;
				if(rterm == 'D') rcv_term_d  += vol;
				if(rterm == 'S') rcv_term_s  += vol;
				if(rterm == 'T') rcv_term_t  += vol;
				if(rterm == 'I') rcv_term_i  += vol;
				if(dterm == 'Y') de_term_y  += vol;
				if(dterm == 'D') de_term_d  += vol;
				if(dterm == 'S') de_term_s  += vol;
				if(dterm == 'T') de_term_t  += vol;
				if(dterm == 'O') de_term_o  += vol;
	
				// total volumn
				op_cntr_qty += vol;
			}
		}
		
		if(cntrTpsz == 'D4' && document.form.flex_hgt_flg.value == 'Y'){
			//alert("* flex_hgt_flg : " + document.form.flex_hgt_flg.value);
			tpSzs = ComFindText(sheetObj, "cntr_tpsz_cd", "D5");
			if(tpSzs != null && tpSzs.length > 0) {
				for(idx=0;idx<tpSzs.length;idx++){
					// values
					var vol = ComIsEmpty(sheetObj.CellValue(tpSzs[idx], "cntr_vol_qty")) ? 0 : parseFloat(sheetObj.CellValue(tpSzs[idx], "cntr_vol_qty"));
					var rterm = sheetObj.CellValue(tpSzs[idx], "rcv_term_cd");
					var dterm = sheetObj.CellValue(tpSzs[idx], "de_term_cd");
		
					// special cargo
					if(sheetObj.CellValue(tpSzs[idx], "dcgo_flg") == 1) dcgo_flg += vol;
					if(sheetObj.CellValue(tpSzs[idx], "rc_flg") == 1) rc_flg += vol;
					if(sheetObj.CellValue(tpSzs[idx], "awk_cgo_flg") == 1) awk_cgo_flg += vol;
					if(sheetObj.CellValue(tpSzs[idx], "bb_cgo_flg") == 1) bb_cgo_flg += vol;
					if(sheetObj.CellValue(tpSzs[idx], "hngr_flg") == 1) hngr_flg += vol;
					if(sheetObj.CellValue(tpSzs[idx], "soc_flg") == 1) soc_flg += vol;
					
					// dry cargo
					if(sheetObj.CellValue(tpSzs[idx], "dcgo_flg") == 0 && 
						sheetObj.CellValue(tpSzs[idx], "rc_flg") == 0 && 
						sheetObj.CellValue(tpSzs[idx], "awk_cgo_flg") == 0 && 
						sheetObj.CellValue(tpSzs[idx], "bb_cgo_flg") == 0){
						dry_cgo_flg += vol;
					}
		
					// receive term / delivery term
					if(rterm == 'Y') rcv_term_y  += vol;
					if(rterm == 'D') rcv_term_d  += vol;
					if(rterm == 'S') rcv_term_s  += vol;
					if(rterm == 'T') rcv_term_t  += vol;
					if(rterm == 'I') rcv_term_i  += vol;
					if(dterm == 'Y') de_term_y  += vol;
					if(dterm == 'D') de_term_d  += vol;
					if(dterm == 'S') de_term_s  += vol;
					if(dterm == 'T') de_term_t  += vol;
					if(dterm == 'O') de_term_o  += vol;
		
					// total volumn
					op_cntr_qty += vol;
				}
			}
		}
		
		// return array
		var cntrQtyArr = new Array();
		cntrQtyArr[0] = cntrTpsz;
		cntrQtyArr[1] = "Difference";
		cntrQtyArr[2] = Math.round(dry_cgo_flg * 1000) / 1000;
		cntrQtyArr[3] = Math.round(dcgo_flg * 1000) / 1000;
		cntrQtyArr[4] = Math.round(rc_flg * 1000) / 1000;
		cntrQtyArr[5] = Math.round(awk_cgo_flg * 1000) / 1000;
		cntrQtyArr[6] = Math.round(bb_cgo_flg * 1000) / 1000;
		cntrQtyArr[7] = Math.round(hngr_flg * 1000) / 1000;
		cntrQtyArr[8] = Math.round(soc_flg * 1000) / 1000;
		cntrQtyArr[9] = Math.round(rcv_term_y * 1000) / 1000;
		cntrQtyArr[10] = Math.round(rcv_term_d * 1000) / 1000;
		cntrQtyArr[11] = Math.round(rcv_term_s * 1000) / 1000;
		cntrQtyArr[12] = Math.round(rcv_term_t * 1000) / 1000;
		cntrQtyArr[13] = Math.round(rcv_term_i * 1000) / 1000;
		cntrQtyArr[14] = Math.round(de_term_y * 1000) / 1000;
		cntrQtyArr[15] = Math.round(de_term_d * 1000) / 1000;
		cntrQtyArr[16] = Math.round(de_term_s * 1000) / 1000;
		cntrQtyArr[17] = Math.round(de_term_t * 1000) / 1000;
		cntrQtyArr[18] = Math.round(de_term_o * 1000) / 1000;
		cntrQtyArr[19] = Math.round(op_cntr_qty * 1000) / 1000;
		
		return cntrQtyArr;
	}
	
	//
	function bkgSplitNoList(split_list){
		document.form.bkg_no.value = split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}

	function callbackPckTp(returnVal){
		//alert(returnVal[0][0] + "|" + returnVal[0][1] + "|" + returnVal[0][2] + "|" + returnVal[0][3])
		sheetObjects[1].CellValue2(sheetObjects[1].SelectRow, "pck_tp_cd") = returnVal[0][3];
	}
	
	function calbackAdjVol(cntrNo, returnVal){
		//alert("calbackAdjVol -> returnVal = " + returnVal);
		var sheetObj = sheetObjects[3];
		var formObj = document.form;
				
		if(returnVal!=null && returnVal.length>0){
			// delete container
			ComRowDeleteComplete(sheetObj, "cntr_no", cntrNo);
			//
			var rcnt = returnVal==null ? 0 : returnVal.length;
			for(var ir=0;ir<rcnt;ir++){
				var rarr = returnVal[ir];
				var nrow = sheetObj.DataInsert(-1);
				//alert("" + rarr);
				for(var ic=0;ic<rarr.length;ic++){
					sheetObj.CellValue2(nrow, ic) = rarr[ic];
				}
				//alert(document.form.bkg_no.value +"="+ rarr[2])
				if(formObj.bkg_no.value == rarr[2]){
					var arrRow = ComFindText(sheetObjects[1], "cntr_no", rarr[1]);
					//alert(arrRow + " -> " + rarr[1] + " : " + rarr[4]);
					if(rarr[5] == 0){
						sheetObjects[1].CellValue2(arrRow[0], "cntr_vol_qty") = 0;
						sheetObjects[1].CellValue2(arrRow[0], "cntr_prt_flg") = 1;
						sheetObjects[1].RowStatus(arrRow[0]) = 'D';
						sheetObjects[1].RowHidden(arrRow[0]) = true;
					} if(rarr[5] == 1){
						sheetObjects[1].CellValue2(arrRow[0], "cntr_vol_qty") = 1;
						sheetObjects[1].CellValue2(arrRow[0], "cntr_prt_flg") = 1;
					} else{
						sheetObjects[1].CellValue2(arrRow[0], "cntr_vol_qty") = rarr[5];
						sheetObjects[1].CellValue2(arrRow[0], "cntr_prt_flg") = (rarr[5] == '1') ? 0 : 1;
					}
				}
			}
		}
		// set focus
		sheetObj.SelectCell(sheetObj.SelectRow, "cntr_vol_qty", false);
		//
		changeEditableByConfirm('RLS');
		// Confirm Release 상태로..
		formObj.evnt_usr_id.value = '';
		formObj.evnt_dt.value = '';
		formObj.fnl_cfm_flg.value = 'N';
		formObj.modify_fnl_cfm_flg.value = 'Y';
		// 데이터 변경 여부 체크 
		formObj.dirty_flag.value = 'Y';
		// calculateCntrQty
		calculateCntrQty();
		
	}
	
	function callbackMove(rcopy, rvol){
		//alert(rcopy + " -> " + rvol);
		var sheetObj = sheetObjects[1];
		var formObj = document.form;
		
		if(rcopy == 'C'){
			sheetObj.CellValue2(sheetObj.SelectRow, "cntr_cfm_flg") = 0;
			sheetObj.CellValue2(sheetObj.SelectRow, "cntr_prt_flg") = 1;
			sheetObj.CellValue2(sheetObj.SelectRow, "cntr_vol_qty") = rvol;
		}else if(rcopy == 'M'){
			sheetObj.RowDelete(sheetObj.SelectRow, false);
		}
		// 모든 컨테이너의 Confirm 상태를 해제
		for(ir=sheetObj.HeaderRows ;ir<=sheetObj.RowCount ;ir++ ){
			sheetObj.CellValue2(ir, "cntr_cfm_flg") = 0;
		}
		// calculateCntrQty
		calculateCntrQty();
		// all release..
		var cntrCount = sheetObjects[1].RowCount;
		for(ir=1;ir<=cntrCount;ir++){
			sheetObjects[1].CellValue2(ir, "cntr_cfm_flg") = 0;
			//changeCntrStatus
			//changeCntrStatus(ir);
		}
		//
		changeEditableByConfirm('RLS');
		// Confirm Release 상태로..
		formObj.evnt_usr_id.value = '';
		formObj.evnt_dt.value = '';
		formObj.fnl_cfm_flg.value = 'N';
		formObj.modify_fnl_cfm_flg.value = 'Y';
		// 데이터 변경 여부 체크 
		formObj.dirty_flag.value = 'Y';
		// calculateCntrQty
		calculateCntrQty();
		
	}	

	/* ESM_BKG_0901 : */
	function callbackNotUpdatedContainer(returnVal){
		//alert(returnVal);
		var newRow = sheetObjects[1].DataInsert(-1);
		sheetObjects[1].CellValue(newRow, "cntr_dp_seq") = ComGetMaxValue(sheetObjects[1], "cntr_dp_seq")+1;
		sheetObjects[1].CellValue(newRow, "bkg_no") = document.form.bkg_no.value;
		sheetObjects[1].CellValue(newRow, "cntr_no_old") = returnVal;
		sheetObjects[1].CellValue(newRow, "cntr_no") = returnVal;
	}

	/* 탭이동 시 화면의 데이타 변경여부 체크 */
	function checkModify(){
		var formObj = document.form;
		if(ComGetObjValue(formObj.dirty_flag) == "Y"){
//			if(ComShowCodeConfirm("BKG00350")){
				//ComSetObjValue(formObj.bkg_no, ComGetObjValue(formObj.old_bkg_no));
				doActionIBSheet(sheetObjects[1], formObj, IBSAVE);
//			}
		}
	}

	function searchData(bkgNo){
		var formObj = document.form;
		ComSetObjValue(formObj.bkg_no, bkgNo);
		doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
	}
	
	function setInquiryDisableButton() {
		if(scrnAuth == 'R'){
			// button
			ComBtnDisable("btn_t6save");
			ComBtnDisable("btn_t6cntrconfirm");
			ComBtnDisable("btn_t6cntrrelease");
//			ComBtnDisable("btn_t6gridcntrirr");
			ComBtnDisable("btn_t6gridadd");
			ComBtnDisable("btn_t6griddel");
			ComBtnDisable("btn_t6gridmove");
			ComBtnDisable("btn_t6sequp");
			ComBtnDisable("btn_t6seqdown");
			// sheet
			sheetObjects[0].Editable = false;
			sheetObjects[1].Editable = false;
			sheetObjects[2].Editable = false;
			// object
			document.form.bkg_wgt_ut_cd.disabled = true;
			document.form.bkg_meas_ut_cd.disabled = true;
			// 데이터 변경 여부 체크
			document.form.dirty_flag.value = 'N';
		}
	}

	/**
	 * HTML Control의 onblur이벤트 <br>
	 **/
	function obj_deactivate() {
		var formObj = document.form;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcValue = window.event.srcElement.getAttribute("value");
		if (srcName == "bkg_no" || srcName == "bl_no") {
			formObj.elements[srcName].value = srcValue.toUpperCase();
		}
	}
	
	function chk_china_cntr_seal() {
		var formObj = document.form;
		var cn_flg = formObj.cn_dir_flg.value;
		var pod_cd = formObj.pod_cd.value;
		//alert("* cn_flg : " + cn_flg);
//		var por_cnt = ComIsEmpty(formObj.por_cd.value) ? "NA" : formObj.por_cd.value.substring(0, 2);
//		var del_cnt = ComIsEmpty(formObj.del_cd.value) ? "NA" : formObj.del_cd.value.substring(0, 2);
//		if(cn_flg == 'Y' || del_cnt == 'CN'){
	    if(cn_flg == 'Y' ){
			var cntrSheet = sheetObjects[1];
			var sealPopUpSheet = sheetObjects[2];
			for(ir=cntrSheet.HeaderRows ;ir<=cntrSheet.RowCount ;ir++ ){
				if(cntrSheet.RowStatus(ir) != 'D'){
					if(!ComIsEmpty(cntrSheet.CellValue(ir, "seal1_no"))){
						if( (   ComIsEmpty(cntrSheet.CellValue(ir, "seal1_knd_cd")) ||
								ComIsEmpty(cntrSheet.CellValue(ir, "seal1_pty_tp_cd"))) &&
							( ComIsContainsChars( cntrSheet.CellValue(ir, "cntr_tpsz_cd").substring(0,1),"TFAP" )==false )) {
							//BKG08188
							ComShowMessage(ComGetMsg("BKG08188"));
							cntrSheet.SelectCell(ir, "seal1_no") ;
							return false;
						}
					}
				}
			}

			for(ir = sealPopUpSheet.HeaderRows; ir<=sealPopUpSheet.RowCount; ir++){
				if(sealPopUpSheet.RowStatus(ir) != 'D'){
					if(!ComIsEmpty(sealPopUpSheet.CellValue(ir,"cntr_no"))){
						var cntrRow = cntrSheet.FindText("cntr_no", sealPopUpSheet.CellValue(ir,"cntr_no"), 0);
						if(ComIsContainsChars( cntrSheet.CellValue(cntrRow,"cntr_tpsz_cd").substring(0,1),"TFAP" )==false){
							if(ComIsEmpty(sealPopUpSheet.CellValue(ir,"seal_knd_cd")) ||
									   ComIsEmpty(sealPopUpSheet.CellValue(ir,"seal_pty_tp_cd"))){
										ComShowMessage(ComGetMsg("BKG08188"));
										cntrSheet.SelectCell(ir, "SEALPop") ;
										return false;
									}
						}
					}
				}
			}

		}
		return true;
		
	}
	
	
	/**
	 * callback 함수 getBKG_1134 호출 .<br>
	 * @param _val
	 */
	function getBKG_1134(_val) {
		 
		if (_val == null || _val == undefined ) return;// null 이면 return
		var obj = _val;
		var sheetObj = sheetObjects[1];
		var sheetObj1=sheetObjects[2];
		var cnt = sheetObj.RowCount;
		var tcnt = obj.length;
		var bkg_no = document.form.bkg_no.value;
		
		for ( var z = 0; z < tcnt; z++){
			for( var i=0; i <= cnt ; i++){
				if (obj[z].cntr_no ==sheetObj.CellValue(i, "cntr_no")){//obj 컨테이너랑 화면에 있는 cntr 비교
			
					sheetObj.CellValue(i, "seal1_no") = obj[z].cntr_seal_no;
					sheetObj.CellValue(i, "cntr_vol_qty") = obj[z].cntr_vol_qty;
					sheetObj.CellValue(i, "pck_qty") = obj[z].pck_qty;
					sheetObj.CellValue(i, "pck_tp_cd") 	= obj[z].pck_tp_cd;
					sheetObj.CellValue(i, "cntr_wgt") 	= obj[z].cntr_wgt;
					sheetObj.CellValue(i, "meas_qty") 	= obj[z].meas_qty;
					sheetObj.CellValue(i, "wgt_ut_cd") = obj[z].wgt_ut_cd;
			    }
			}
			newRow = sheetObj.DataInsert(-1);
				
			sheetObj.RowStatus(newRow)= "R";
			sheetObj.CellValue(newRow, "cntr_no") = obj[z].cntr_no;
			sheetObj.CellValue(newRow, "cntr_tpsz_cd") = obj[z].cntr_tpsz_cd;
			sheetObj.CellValue(newRow, "seal1_no") = obj[z].cntr_seal_no;
			sheetObj.CellValue(newRow, "cntr_vol_qty") = obj[z].cntr_vol_qty;
			sheetObj.CellValue(newRow, "pck_qty") = obj[z].pck_qty;
			sheetObj.CellValue(newRow, "pck_tp_cd") 	= obj[z].pck_tp_cd;
			sheetObj.CellValue(newRow, "cntr_wgt") 	= obj[z].cntr_wgt;
			sheetObj.CellValue(newRow, "meas_qty") 	= obj[z].meas_qty;
			sheetObj.CellValue(newRow, "wgt_ut_cd") = obj[z].wgt_ut_cd;
			sheetObj.CellValue(newRow, "bkg_no") = obj[z].bkg_no;
			sheetObj1.CellValue2(newRow, "bkg_no") = obj[z].bkg_no;
		
		
			if(sheetObj.CellValue(newRow, "cntr_no")==""|| sheetObj.CellValue(newRow, "cntr_no")== null){
				sheetObj.RowDelete(newRow,false);
			}
		}
		for( var i = 0 ; i <= sheetObj1.RowCount; i++){
			if(sheetObj1.CellValue(i, "cntr_no")== "" ||sheetObj1.CellValue(i, "cntr_no")== null){	
				sheetObj1.RowDelete(i,false);
			}
		}
		/* Sheet 가 변경 되지 않은 경우 dirty_flag 를 'N' 으로 셋팅 한다. */
		for(i = 0; i <= sheetObjects[2].LastRow; i++){
			if(null != sheetObj.Cellvalue(i,"ibflag") && sheetObj.Cellvalue(i,"ibflag") == "I"
													  || sheetObj.CellValue(i,"ibflag") == "D" 
													  || sheetObj.CellValue(i,"ibflag") == "U"){ //변경 됐음
				document.form.dirty_flag.value = 'Y';
				break;
			}else{
				document.form.dirty_flag.value = 'N';
			}
		}
	 }
	 
	 
	 /**
	  * BKG B/L Confirm, B/L Issued 여부 판단
	  * 2012.04.24 오요한 BKG/DOC System 보완 요청
	  * @param formObj
	  * @return
	  */
	function checkBkgIssStatus(formObj) {
		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", "f_cmd="+SEARCH12+"&bkg_no="+formObj.bkg_no.value);
		var bkgIssStatus = ComGetEtcData(sXml, "BKG_ISS_STATUS");
		if ("C" == bkgIssStatus) {
			if(ComShowConfirm(ComGetMsg("BKG08234"))) {//"B/L was already confirmed by shipper, do you want to still change?";
				return true;
			} else {
				return false;
			}
		} else if ("I" == bkgIssStatus) {
			if (ComShowConfirm(ComGetMsg("BKG08235"))) { //"B/L was already issued, do you want to still change?";
				return true;
			} else {
				return false;
			}
		} else {
			// C / I 가 아닌경우엔 체크를 하지 않는다.
			return true;
		}
	} 

	function checkSealNo(sheetObj) {
		// Seal No.1, 2, .. 의 값에 (,) 가 들어가면 메시지를 띄우고 중지한다.
		var sRows = sheetObj.FindStatusRow("I|U|R");
		
		if (sRows != undefined && sRows != '') {
			var sRowArr = sRows.split(";");
			var fmObject = sheetObjects[2];
			for (var i = 0; i < sRowArr.length; i ++) {
				
				if(sRowArr[i] != "") {
					var cntrNo   = sheetObj.CellValue(parseInt(sRowArr[i]), "cntr_no");
					var arrFmRow = ComFindText(fmObject, "cntr_no", cntrNo);
					
					if(arrFmRow.length > 2) {
						for(var j = 0; j < arrFmRow.length; j++) {
							var sealNo = fmObject.CellValue(arrFmRow[j], "cntr_seal_no");
							
							if (sealNo.length > 0 && sealNo.indexOf(",") != -1) {
								ComShowMessage(ComGetMsg("BKG08237"));
//								sheetObj.SelectCell(i+1, "seal1_no");
								return false;
							}
						}
					} else {
						var sealNo1 = sheetObj.CellValue(parseInt(sRowArr[i]), "seal1_no");
						var sealNo2 = sheetObj.CellValue(parseInt(sRowArr[i]), "seal2_no");
						
						if (sealNo1.length > 0 && sealNo1.indexOf(",") != -1) {
							ComShowMessage(ComGetMsg("BKG08237"));
							sheetObj.SelectCell(i+1, "seal1_no");
							return false;
						}
						if (sealNo2.length > 0 && sealNo2.indexOf(",") != -1) {
							ComShowMessage(ComGetMsg("BKG08237"));
							sheetObj.SelectCell(i+1, "seal2_no");
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	var allTypeSealNo = new Array(0);
	function allTypeSealNoDupChk(sheetObj) {
		// Seal No.1, 2, .. 의 값이 숫자로만 이루어진 것을 구한다.
		var sRows = sheetObj.FindStatusRow("I|U|R");
		
		if (sRows != undefined && sRows != '') {
			var sRowArr = sRows.split(";");
			var fmObject = sheetObjects[2];
			
			// numTypeSealNo 초기화
			allTypeSealNo.splice(0, allTypeSealNo.length);
			
			for (var i = 0; i < sRowArr.length; i ++) {
				if(sRowArr[i] != "") {
					var cntrNo   = sheetObj.CellValue(parseInt(sRowArr[i]), "cntr_no");
					var cntrTp = sheetObj.CellValue(parseInt(sRowArr[i]), "cntr_tpsz_cd").substring(0,1);
					var bbChk = sheetObj.CellValue(parseInt(sRowArr[i]),"bb_cgo_flg");
					
					if(cntrTp != "F" && cntrTp != "A" && cntrTp != "T" && !bbChk){
						var arrFmRow = ComFindText(fmObject, "cntr_no", cntrNo);
						
						for(var j = 0; j < arrFmRow.length; j++) {
							var sealNo = fmObject.CellValue(arrFmRow[j], "cntr_seal_no");
							if (sealNo.length > 0 ) {
								allTypeSealNo.push(sealNo);
							}
						}
						
						// 숫자로만 이루어진 sealNo의 중복을 체크한다.
						if(dupCheck(allTypeSealNo)) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
//	function isAllNumberType(_sealNo){
//		var str = _sealNo;
//		
//		for (var i=0 ; i<str.length;i++) {
//			if (str.charAt(i) < "0" || str.charAt(i) > "9"){
//		    	return false;
//			}
//		}
//		return true;
//	}
	
	// 중복 데이타가 있으면 true return
	function dupCheck(_sealNos){
		var sealNos = _sealNos;
		// 중복 체크를 위해 정렬한다.
		sealNos.sort();
		for (var i=0 ; i<sealNos.length-1;i++) {
			if (sealNos[i] == sealNos[i+1]) {
				ComShowMessage(ComGetMsg("BKG95007", "SealNo : " + sealNos[i]));
		    	return true;
			}
		}
		return false;
	}
	
//	// 순행 정렬
//	function ascComparator(a, b) {alert(a - b);
//		return a - b;
//	}
	
	function checkShowVGM(){
		if(document.form.chk_show_vgm.checked==true){
			sheetObjects[1].ColHidden("vgm_vrfy_sig_ctnt") = false;
			sheetObjects[1].ColHidden("vgm_mzd_tp_cd") = false;
//			sheetObjects[1].ColHidden("vgm_vrfy_dt") = false;
//			sheetObjects[1].ColHidden("vgm_dtmn_dt") = false;
			for (var j=sheetObjects[1].HeaderRows; j<=sheetObjects[1].RowCount; j++) {
				sheetObjects[1].InitCellProperty(j,"vgm_vrfy_sig_ctnt", dtData);
				sheetObjects[1].InitCellProperty(j,"vgm_mzd_tp_cd", dtCombo);
//				sheetObjects[1].InitCellProperty(j,"vgm_vrfy_dt", dtPopupEditFormat);
//				sheetObjects[1].InitCellProperty(j,"vgm_dtmn_dt", dtPopupEditFormat);
			}
		}else{
			sheetObjects[1].ColHidden("vgm_vrfy_sig_ctnt") = true;
			sheetObjects[1].ColHidden("vgm_mzd_tp_cd") = true;
//			sheetObjects[1].ColHidden("vgm_vrfy_dt") = true;
//			sheetObjects[1].ColHidden("vgm_dtmn_dt") = true;
		}
	}
	
	
	
    /* 개발자 작업  끝 */