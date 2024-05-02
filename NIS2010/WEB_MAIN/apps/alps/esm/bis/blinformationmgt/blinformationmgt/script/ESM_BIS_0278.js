/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0278.js
*@FileTitle : Group & Multi B/L Print
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.01.18 박준용
* 1.0 Creation
======================================================================
 History
 2010.10.06 이일민 [SRM-201008739] Booking 탭에 B/L Preview 추가 요청
 2012.08.22 김기택 [CHM-201219155-01j] B/L Preview 기능 추가 
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
     * @class ESM_BIS_0278 : ESM_BIS_0278 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BIS_0278() {
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

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var rdObjects = new Array();
var rdCnt = 0;
var queryStr = "";

var prefix1 = "t1sheet1_";
var prefix2 = "t2sheet1_";
var prefix3 = "t1sheet2_";

var iterator = "|$$|";

var multiSeparator = "|";

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

			// B/L No. sheet입력란이 활성화 된 경우 비활성화로....
			// bl_sheet
			if( srcName != "tb1_btn_input_bl_no" ) {
				if ( srcName != "input_bl_no" ) {
					setBlNo(sheetObject1, 3);
					//alert("go");
				}
			}
			
			// BKG No. sheet입력란이 활성화 된 경우 비활성화로....
			// bkg_sheet
			if( srcName != "tb1_btn_input_bkg_no" ) {
				if ( srcName != "input_bkg_no" ) {
					setBkgNo(sheetObject2, 3);
					//alert("go");
				}
			}

            switch(srcName) {

/** tab [ esm_bis_0278 ] (S) **/

            	case "tb1_btn_Retrieve":
					Retrive(srcName);
                	break;
                	
				case "tb1_btn_New": // btn_New
					pageReset (sheetObject1, formObject );
                	break;

            	case "tb1_btn_calendar": // B/L Release (Issue) Date
					var cal = new ComCalendarFromTo();
					cal.select(formObject.obl_iss_from_dt, formObject.obl_iss_to_dt, 'yyyy-MM-dd');
                	break;

            	case "tb1_btn_rep_cmdt_cd": // Rep. Commodity
					Pop_COM_ENS_011(formObject);
                	break;

            	case "tb1_btn_cmdt_cd": // Commodity
					Pop_COM_ENS_011(formObject);
                	break;

            	case "tb1_btn_sc_rfa_no": // S/C / RFA
					// S/C - UI_BKG-0655 | RFA - UI_BKG-0654
					Pop_ESM_BKG_06545(formObject);
                	break;

            	case "tb1_btn_cust_cd": // Customer KR
					Pop_COM_ENS_041(formObject);
                	break;

            	case "tb1_btn_input_bl_no": // B/L No.
					if ( document.getElementById("bl_input").style.display == "block" ) {
						setBlNo(sheetObject1, 1);
					}
					else {
						setBlNo(sheetObject1, 2);
					}
                	break;
                	
            	case "tb1_btn_input_bkg_no": // BKG No.
					if ( document.getElementById("bkg_input").style.display == "block" ) {
						setBkgNo(sheetObject2, 1);
					}
					else {
						setBkgNo(sheetObject2, 2);
					}
            		break;

            	case "bkg_sts_cd_w": // W-Waiting
					if ( formObject.bkg_sts_cd_w.checked ) {
						formObject.bkg_rsn_spcl_cgo_flg.disabled = false;
						formObject.wt_rsn_hld_flg.disabled = false;
					}
					else {
						formObject.bkg_rsn_spcl_cgo_flg.disabled = true;
						formObject.wt_rsn_hld_flg.disabled = true;

						formObject.bkg_rsn_spcl_cgo_flg.checked = false;
						formObject.wt_rsn_hld_flg.checked = false;
					}
					break;

            	case "eq_por_cd": // EQ Control Office
					if ( formObject.eq_por_cd.checked ) {
						formObject.eq_del_cd.checked = false;
					}
					break;

            	case "eq_del_cd": // EQ Control Office
					if ( formObject.eq_del_cd.checked ) {
						formObject.eq_por_cd.checked = false;
					}
                	break;
				/*
				/ 요청에의해 처리를 하지 않음 후에 다시 적용되면 필요하므로 주석처리
            	case "aes_itn_y": // ITN
					if ( formObject.aes_itn_y.checked ) {
						formObject.aes_itn_n.checked = false;
					}
					break;

            	case "aes_itn_n": // ITN
					if ( formObject.aes_itn_n.checked ) {
						formObject.aes_itn_y.checked = false;
					}
                	break;
				*/

/** tab [ esm_bis_0278 ] (E) **/

/** tab [ esm_bkg_0280 ] (S) **/

				case "tb2_btn_Sort": // btn_Sort
					Pop_ESM_BKG_0161(formObject);
                	break;

				case "tb2_btn_CheckAll":
					sheetObject3.CheckAll2(prefix2 + "Check") = 1;
					break;
					
				case "tb2_btn_UncheckAll":
					sheetObject3.CheckAll2(prefix2 + "Check") = 0;
					break;

				case "tb2_btn_Retrieve":
					doActionIBSheet(sheetObject3,formObject,IBSEARCH);
					break;
					
				case "tb2_btn_EIR":
					RdPrint(sheetObject3, "HKG");
					break;

				case "tb2_btn_Manifest":
					//RdPrint(sheetObject3, "US");
					BLPrint(formObject, sheetObject3, "Manifest");
					break;
					
                /* 2012.07.30 B/L Preview 버튼 이벤트 추가
                 * prefix2 = t2sheet1_
                 */
                
                case "tb2_btn_BLPreview":
                var bkgNos = "";
                var arrRow = ComFindText(sheetObject3, prefix2 + "Check", 1);
                
                if (arrRow && 0 < arrRow.length) {
                    for (var i = 0; i < arrRow.length; i++) {
                        bkgNos += sheetObject3.CellValue(arrRow[i], prefix2 + "bkg_no") + ",";
                    }
                    if (0 < bkgNos.indexOf(","))
                        bkgNos = bkgNos.substring(0, bkgNos.length - 1);
                    if (1 < bkgNos.split(",").length) {
                        ComShowCodeMessage("BKG01002");
                        // Please select one B/L No
                        return;
                    }
                } else {
                    ComShowCodeMessage("COM12176");
                    // Please select one at least.
                    return false;
                }
                
                comBisCallPop0927(sheetObject3.CellValue(arrRow[0], prefix2 + "bkg_no"), sheetObject3.CellValue(arrRow[0], prefix2 + "bl_no"));
    
                break;

	
				case "tb2_btn_BLPrint":
					var param = bkgNos = "";
					var arrRow = ComFindText(sheetObject3, prefix2+"Check", 1);
					if (arrRow && 0<arrRow.length) {
						for (var i=0; i<arrRow.length; i++) {
							bkgNos += sheetObject3.CellValue(arrRow[i],prefix2+"bkg_no")+",";
						}
						if (0<bkgNos.indexOf(",")) bkgNos = bkgNos.substring(0,bkgNos.length-1);
						if (500 < bkgNos.split(",").length) {
							ComShowCodeMessage("BKG08124",500);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
							return;
						}
					} else {
    					ComShowCodeMessage("COM12176");
						return false;
					}
					param  = "?bkg_no="+bkgNos;
					ComOpenWindowCenter("/hanjin/ESM_BIS_0743_01.do"+param, "PopupEsmBis074301", 900, 340, false);
					break;

				case "tb2_btn_Back":
					//alert("btn_Back");
					tabObjects[0].selectedIndex = 0;
					break;

				case "tb2_btn_DownExcel":
					doActionIBSheet(sheetObject3,formObject,IBDOWNEXCEL);
					break;

				case "tb2_btn_Test0927":
					var bkg_no = sheetObject3.CellValue(sheetObject3.SelectRow, prefix2 + "bkg_no");
					//var bkg_no = "";
					//var bl_no = sheetObject3.CellValue(sheetObject3.SelectRow, prefix2 + "bl_no");
					var bl_no = "";

					bl_no = (bl_no.length != 0 && bl_no.length > 12) ? bl_no.substring(0, 12) : bl_no;

					var bl_tp_cd = "";

					var param = "bkg_no=" + bkg_no + "&bl_no=" + bl_no + "&bl_tp_cd=" + bl_tp_cd + "&email=bateau75@naver.com";
					ComOpenWindow("/hanjin/ESM_BIS_0927.do?" + param, "PopupEsmBkg0927", "width=916, height=768, scrollbars=no", false);
					break;

/** tab [ esm_bkg_0280 ] (E) **/

            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			//ComShowMessage(OBJECT_ERROR);
				alert(e.description);
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

		for(k=0; k < tabObjects.length; k++){
            initTab(tabObjects[k],k+1);
        }
		
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		initCombo();

		initRdConfig(rdObjects[0]);

		init_Control();
	
    }

	function initRdConfig(rdObject){
		
		var Rdviewer = rdObject ;
		Rdviewer.AutoAdjust = true;
		Rdviewer.ViewShowMode(0);
		Rdviewer.setbackgroundcolor(128,128,128);
		Rdviewer.SetPageLineColor(128,128,128);
	}

	function rdOpen(rdObject, formObject, param){
		var Rdviewer = rdObject;
		// /rp [" + param + "] /riprnmargin /rprncenteropt [1] /rwait -- 파라메터 순서
		//var rdParam = "/rp [" + param + "] /riprnmargin /rwait";
		var rdParam = "/rp " + param + " /riprnmargin /rwait";

		// 열고자 하는 RD 파일을 지정한다.
		var strPath = RD_path+"apps/alps/esm/bis/blinformationmgt/blinformationmgt/report/ESM_BIS_0791.mrd";

		//alert(rdParam + "\n\n" + strPath);

		Rdviewer.FileOpen(strPath, RDServer + rdParam);

		Rdviewer.CMPrint();

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

			case "t1sheet1":
				with (sheetObj) {

					// 높이 설정
					style.height = 150;
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = " |bl_no|bl_combo";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, prefix1+"ibflag",   false, "", dfNone,     0, true, true, 12);
					InitDataProperty(0, cnt++, dtData,         80, daLeft, true, prefix1+"bl_no",    false, "", dfEngUpKey, 0, true, true, 12);
					InitDataProperty(0, cnt++, dtHidden,       0,  daLeft, true, prefix1+"bl_combo", false, "", dfNone,     0, true, true);

					CountPosition = 0;

				}
				var formObject = document.form;

				// row 50개 생성 후 
				// input_bl_no.value 값을 초기 Row에 설정 후
				// 타이틀 제거

				for (var i=1; i<=50; i++) {
					//
					sheetObj.DataInsert(-1);
					sheetObj.CellValue(i, prefix1 + "ibflag") = "R";
				}

				sheetObj.CellValue(1, prefix1 + "bl_no") = formObject.input_bl_no.value;
				sheetObj.SelectCell(1, prefix1 + "bl_no");

				sheetObj.RowHidden(0) = true;

				break;
				
			case "t1sheet2":
				with (sheetObj) {

					// 높이 설정
					style.height = 150;
					//전체 너비 설정
					SheetWidth = mainTable1.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

				   //전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 2, 100);

					var HeadTitle1 = " |bkg_no|bkg_combo";
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					
					InitDataProperty(0, cnt++, dtHiddenStatus, 80, daLeft, true, prefix3+"ibflag",   false, "", dfNone,     0, true, true, 13);
					InitDataProperty(0, cnt++, dtData,         80, daLeft, true, prefix3+"bkg_no",    false, "", dfEngUpKey, 0, true, true, 13);
					InitDataProperty(0, cnt++, dtHidden,       0,  daLeft, true, prefix3+"bkg_combo", false, "", dfNone,     0, true, true);

					CountPosition = 0;

				}
				var formObject = document.form;

				// row 50개 생성 후 
				// input_bl_no.value 값을 초기 Row에 설정 후
				// 타이틀 제거

				for (var i=1; i<=50; i++) {
					//
					sheetObj.DataInsert(-1);
					sheetObj.CellValue(i, prefix3 + "ibflag") = "R";
				}

				sheetObj.CellValue(1, prefix3 + "bkg_no") = formObject.input_bkg_no.value;
				sheetObj.SelectCell(1, prefix3 + "bkg_no");

				sheetObj.RowHidden(0) = true;

				break;

            case "t2sheet1":      //t2sheet1
                with (sheetObj) {

                    // 높이 설정
                    //style.height = 300;
                    style.height = 425;

                    //전체 너비 설정
                    SheetWidth = mainTable2.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    //MergeSheet = msAll;
					MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 16, 100);

                    var HeadTitle1 = "|Sel.|Seq.|B/L No.|BKG No.|Booking Route|Booking Route|Booking Route|Booking Route|R/D Term|R/D Term|Relay Port|Relay Port|Commodity|Commodity|Special Cargo|Special Cargo|Special Cargo|Special Cargo|A/S|ST|BDR|CA|S/O|EQ Control Office|EQ Control Office|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|OB/L|OB/L|OB/L||||||TEU|FEU";
                    var HeadTitle2 = "|Sel.|Seq.|B/L No.|BKG No.|POR|POL|POD|DEL|R|D|POL|POD|Rep|Commodity|D|R|A|B|A/S|ST|BDR|CA|S/O|POR|DEL|Contract|AES|CAED|Manifest|Rating|Consignee|Shipper|Issue|Print|Release||||||TEU|FEU";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					// InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D]) 
                    InitHeadMode(true, false, true, true, false,false);                    

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus, 30,  daCenter, true, prefix2+"ibflag"        );
                    InitDataProperty(0, cnt++, dtDummyCheck,   40,  daCenter, true, prefix2+"Check",        false, "", dfNone, 0, true,  true,  0, false, false);
                    InitDataProperty(0, cnt++, dtDataSeq,      40,  daCenter, true, prefix2+"Seq",          false, "", dfNone, 0, false, false, 0, false, false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter, true, prefix2+"bl_no",        false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         100, daCenter, true, prefix2+"bkg_no",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         62,  daCenter, true, prefix2+"por",          false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtData,         62,  daCenter, true, prefix2+"pol",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         62,  daCenter, true, prefix2+"pod",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         62,  daCenter, true, prefix2+"del",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true, prefix2+"r_term",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true, prefix2+"d_term",       false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtData,         60,  daCenter, true, prefix2+"pol_cd",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         70,  daCenter, true, prefix2+"pod_cd",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, false,prefix2+"rep",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         80,  daCenter, false,prefix2+"commodity",    false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, false,prefix2+"d_sc",         false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, false,prefix2+"r_sc",         false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, false,prefix2+"a_sc",         false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         30,  daCenter, false,prefix2+"b_sc",         false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"a_s",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         50,  daCenter, true, prefix2+"st",           false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"bdr",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"ca",           false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"twn_so_no",    false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"por_eq",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"del_eq",       false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"sc_rfa_no",    false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"aes",          false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"caed",         false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"manifest",     false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"rate",         false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true, prefix2+"consignee",    false, "", dfNone, 0, false, false, 4000);

                    InitDataProperty(0, cnt++, dtData,         120, daLeft,   true, prefix2+"shipper",      false, "", dfNone, 0, false, false, 4000);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"obl_iss_flg",  false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"obl_prn_flg",  false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtData,         65,  daCenter, true, prefix2+"obl_rlse_flg", false, "", dfNone, 0, false);

                    InitDataProperty(0, cnt++, dtHidden,       0,   daCenter, true, prefix2+"bl_bkg_no",    false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daCenter, true, prefix2+"bl_act_wgt",   false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daCenter, true, prefix2+"bl_meas_qty",  false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daCenter, true, prefix2+"order_col",    false, "", dfNone, 0, false);
                    InitDataProperty(0, cnt++, dtHidden,       0,   daCenter, true, prefix2+"blank",        false, "", dfNone, 0, false);
                    
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true, prefix2+"teu",          false, "", dfFloat,2, false);
                    InitDataProperty(0, cnt++, dtData,         55,  daCenter, true, prefix2+"feu",          false, "", dfFloat,2, false);
                    

					//DataRowMerge(0) = true;

					CountPosition = 2;

					SetSortDialog(false);

					AutoRowHeight = false;
               }
               break;
		}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
          case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESM_BIS_0278GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix2) + "&" + ComGetPrefixParam(prefix3));
                break;

			case IBDOWNEXCEL:      // 엑셀다운로드
				//sheetObj.SpeedDown2Excel(-1);
				
				var formObj = document.form;

				var sqlOrder = formObj.query_sort.value.split("|");

				var sqlShowSubSumCol= sqlOrder[0].toLowerCase();

				var sRow = "";
				sRow += sheetObj.FindSubSumRow(prefix2 + sqlShowSubSumCol);

				sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", false, "", sRow, false);
			break;
        }
    }

	function init_Control() {
	    //Axon 이벤트 처리1. 이벤트catch
		axon_event.addListenerForm  ("blur",    "obj_blur",     form);  //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
	    axon_event.addListenerFormat("focus",   "obj_focus",    form);    //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat("keypress","obj_KeyPress", form);     //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
		axon_event.addListenerForm  ("keydown", "obj_keydown", 	form);
		axon_event.addListener      ("keydown", "sheet_keydown","mainTable2");
		axon_event.addListener      ("keyup",   "sheet_keyup",  "mainTable2");
	}

	//Axon 이벤트 처리2. 이벤트처리함수
	function obj_blur(){
		switch(event.srcElement.name) {

			case "obl_iss_from_dt":
				event.srcElement.value = ComGetMaskedValue(event.srcElement, "ymd");
				break;
			case "obl_iss_to_dt":
				event.srcElement.value = ComGetMaskedValue(event.srcElement, "ymd");
				break;

			default:

				if ( event.srcElement.name == "cust_seq" ) {
					event.srcElement.value = ComReplaceStr(event.srcElement.value, ",", "");
				}
				else {
					//ComChkObjValid(event.srcElement);
				}
		}
	}
	
	function obj_focus(){
		ComClearSeparator(event.srcElement);
	}

	function obj_keydown(){
		var formObject = document.form;
		var obj = event.srcElement;

		if (event.keyCode == 13){ // Enter Key
			//
			switch(obj.name){
				// 멀티콤보에서의 Enter Key 적용에 대한 처리
				
				default:
					Retrive(obj.name);
			}
		}
	}

    /**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

    }

    /**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {

         switch(tabNo) {
             case 1:
                with (tabObj) {

                    var cnt  = 0 ;
                    InsertTab( cnt++ , "Search" , -1 );
                    InsertTab( cnt++ , "Result" , -1 );
                }
             		break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {

        var objs = document.all.item("tabLayer");

	    	objs[nItem].style.display = "Inline";
	    	objs[beforetab].style.display = "none";

	    	//--------------- 요기가 중요 --------------------------//
	    	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    	//------------------------------------------------------//
	    	beforetab= nItem;
    }

	function initCombo() {
		// initCombo
		var formObject = document.form;

		var sXml = sheetObjects[0].GetSearchXml("ESM_BIS_0278GS.do", FormQueryString(formObject));
		var arrXml = sXml.split(iterator);

		// IBMultiCombo Setting
		// [0] - R/D Term - rcv_term_cd
		// [1] - R/D Term - de_term_cd
		// [2] - R/D Term - tb1_Morg_sconti_cd
		// [3] - R/D Term - tb1_Mdesc_sconti_cd
		// [4] - R/D Term - tb1_Morg_svc_mod_cd
		// [5] - R/D Term - tb1_Mdesc_inlnd_svc_mod_cd
		// IBMultiCombo Setting

		if (arrXml[0].length > 0) {
			ComBkgXml2ComboItem(arrXml[0], formObject.tb1_Mbooking_rcv_term_cd, "val", "name"); // R/D Term - rcv_term_cd
			formObject.tb1_Mbooking_rcv_term_cd.MultiSelect = true;
			formObject.tb1_Mbooking_rcv_term_cd.MultiSeparator = multiSeparator;
		}
		if (arrXml[1].length > 0) {
			ComBkgXml2ComboItem(arrXml[1], formObject.tb1_Mbooking_de_term_cd, "val", "name"); // R/D Term - de_term_cd
			formObject.tb1_Mbooking_de_term_cd.MultiSelect = true;
			formObject.tb1_Mbooking_de_term_cd.MultiSeparator = multiSeparator;
		}
		if (arrXml[2].length > 0) {
			ComBkgXml2ComboItem(arrXml[2], formObject.tb1_Morg_sconti_cd, "val", "name"); // S.Route(From) - tb1_Morg_sconti_cd
			formObject.tb1_Morg_sconti_cd.MultiSelect = true;
			formObject.tb1_Morg_sconti_cd.MultiSeparator = multiSeparator;
		}
		if (arrXml[3].length > 0) {
			ComBkgXml2ComboItem(arrXml[3], formObject.tb1_Mdesc_sconti_cd, "val", "name"); // S.Route(to) - tb1_Mdesc_sconti_cd
			formObject.tb1_Mdesc_sconti_cd.MultiSelect = true;
			formObject.tb1_Mdesc_sconti_cd.MultiSeparator = multiSeparator;
		}
		if (arrXml[4].length > 0) {
			ComBkgXml2ComboItem(arrXml[4], formObject.tb1_Morg_svc_mod_cd, "val", "name"); // S.Mode(From) - tb1_Morg_svc_mod_cd
			formObject.tb1_Morg_svc_mod_cd.MultiSelect = true;
			formObject.tb1_Morg_svc_mod_cd.MultiSeparator = multiSeparator;
		}
		if (arrXml[5].length > 0) {
			ComBkgXml2ComboItem(arrXml[5], formObject.tb1_Mdesc_inlnd_svc_mod_cd, "val", "name"); // S.Mode(From) - tb1_Mdesc_inlnd_svc_mod_cd
			formObject.tb1_Mdesc_inlnd_svc_mod_cd.MultiSelect = true;
			formObject.tb1_Mdesc_inlnd_svc_mod_cd.MultiSeparator = multiSeparator;
		}

	}

	function Retrive(srcName) {
        var sheetObject1 = sheetObjects[0];
        var sheetObject2 = sheetObjects[1];
        var sheetObject3 = sheetObjects[2];
        var formObject = document.form;

		if ( validateForm(sheetObject1,formObject,srcName) ) {
			//alert("btn_Retrieve");

			// MultiCombo Value Setting
			formObject.booking_rcv_term_cd.value = formObject.tb1_Mbooking_rcv_term_cd.Code;
			formObject.booking_de_term_cd.value = formObject.tb1_Mbooking_de_term_cd.Code;
			formObject.org_sconti_cd.value = formObject.tb1_Morg_sconti_cd.Code;
			formObject.desc_sconti_cd.value = formObject.tb1_Mdesc_sconti_cd.Code;
			formObject.org_svc_mod_cd.value = formObject.tb1_Morg_svc_mod_cd.Code;
			formObject.desc_inlnd_svc_mod_cd.value = formObject.tb1_Mdesc_inlnd_svc_mod_cd.Code;

			var strValue = "";

			// bkg_cgo_tp_cd
			if (formObject.bkg_cgo_tp_cd_f.checked) {
				strValue += formObject.bkg_cgo_tp_cd_f.value + "|";
			}
			if (formObject.bkg_cgo_tp_cd_p.checked) {
				strValue += formObject.bkg_cgo_tp_cd_p.value + "|";
			}
			if (formObject.bkg_cgo_tp_cd_r.checked) {
				strValue += formObject.bkg_cgo_tp_cd_r.value + "|";
			}
			strValue = strValue.substring(0, eval(strValue.lengthByte()) - 1);
			formObject.bkg_cgo_tp_cd.value = strValue;

			strValue = "";

			// bkg_sts_cd
			if (formObject.bkg_sts_cd_f.checked) {
				strValue += formObject.bkg_sts_cd_f.value + "|";
			}
			if (formObject.bkg_sts_cd_w.checked) {
				strValue += formObject.bkg_sts_cd_w.value + "|";
			}
			strValue = strValue.substring(0, eval(strValue.lengthByte()) - 1);
			formObject.bkg_sts_cd.value = strValue;

			strValue = "";

			// adv_shtg_cd
			if (formObject.adv_shtg_cd_a.checked) {
				strValue += formObject.adv_shtg_cd_a.value + "|";
			}
			if (formObject.adv_shtg_cd_s.checked) {
				strValue += formObject.adv_shtg_cd_s.value + "|";
			}
			strValue = strValue.substring(0, eval(strValue.lengthByte()) - 1);
			formObject.adv_shtg_cd.value = strValue;

			strValue = "";

			// revenue
			if (formObject.revenue_r.checked) {
				//strValue += formObject.revenue_r.value + "|";
				strValue = formObject.revenue_r.value;
			}
			else if (formObject.revenue_n.checked) {
				//strValue += formObject.revenue_n.value + "|";
				strValue = formObject.revenue_n.value;
			}
			else {
				//
				strValue= "";
			}
			formObject.revenue.value = strValue;

			strValue = "";

			// Sort Test
			formObject.query_sort.value = "POL|POD";

			//alert(formObject.vvd_pol_cd.value.indexOf("US"));

			if ( formObject.booking_por_cd.value.indexOf("US") != -1 || formObject.booking_pol_cd.value.indexOf("US") != -1  || formObject.vvd_pol_cd.value.indexOf("US") != -1 ) {
				sheetObjects[2].ColHidden(prefix2 + "aes") = false;
				sheetObjects[2].ColHidden(prefix2 + "manifest") = false;
				sheetObjects[2].ColHidden(prefix2 + "rate") = false;
			}
			else {
				sheetObjects[2].ColHidden(prefix2 + "aes") = true;
				sheetObjects[2].ColHidden(prefix2 + "manifest") = true;
				sheetObjects[2].ColHidden(prefix2 + "rate") = true;
			}

			if ( formObject.booking_por_cd.value.indexOf("CA") != -1 || formObject.booking_pol_cd.value.indexOf("CA") != -1 || formObject.vvd_pol_cd.value.indexOf("CA") != -1 ) {
				sheetObjects[2].ColHidden(prefix2 + "caed") = false;
			}
			else {
				sheetObjects[2].ColHidden(prefix2 + "caed") = true;
			}

			tabObjects[0].selectedIndex = 1;
			
			formObject.obl_iss_date.value = formObject.obl_iss_chk[0].checked ? formObject.obl_iss_chk[0].value : formObject.obl_iss_chk[1].value;
			doActionIBSheet(sheetObject3,document.form,IBSEARCH);
		}
	}

    /**
     * Rep. Commodity 팝업창 선택값 Return
     */
    function getCOM_ENS_011(rowArray){

		var formObject = document.form;
		var colArray = rowArray[0];

		formObject.rep_cmdt_cd.value = colArray[4]; // Rep. Commodity - btn_rep_cmdt_cd
		formObject.cmdt_cd.value = colArray[2]; // Commodity - cmdt_cd
		formObject.cmdt_nm.value = colArray[3]; // Commodity - btn_cmdt_cd
    }

    /**
     * Contract / RFA 팝업창 선택값 Return
     */
    function getESM_BKG_06545(rowArray){

		var formObject = document.form;
		
		var colArray = rowArray[0];

		if ( formObject.sc_rfa_chk[0].checked == true ) {
			formObject.sc_rfa_no.value = colArray[5]; // Contract S/C
		} else {
			formObject.sc_rfa_no.value = colArray[5]; // Contract RFA
		}
    }

    /**
     * Customer KR 팝업창 선택값 Return
     */
    function getCOM_ENS_041(rowArray){

		var formObject = document.form;
		var colArray = rowArray[0];
		//alert("colArray[3] : [" + colArray[3] + "]\n\n" + "colArray[4] : [" + colArray[4] + "]\n\n" + "colArray[3].length : [" + colArray[3].lengthByte() + "]");

		if ( colArray[3].lengthByte() >= 3 ) {
			formObject.cust_cnt_cd.value = colArray[3].substring(0, 2); // Customer - cust_cnt_cd (EX - KR)
			formObject.cust_seq.value = colArray[3].substring(2, colArray[3].lengthByte()); // Customer - cust_seq (EX - 949)
		}
		formObject.cust_nm.value = colArray[4]; // Customer - cust_nm (EX - SAMSUNG SDI.)
    }

    /**
     * Contract / RFA 팝업창 선택값 Return
     */
    function setOrderBy(returnCode){

		var formObject = document.form;

		if ( returnCode != "" ) {
			// alert( "****** returnCode *****" + "\n\n" + ComReplaceStr(returnCode, ",", multiSeparator) );

			formObject.query_sort.value = ComReplaceStr(returnCode, ",", multiSeparator);

			//alert("query_sort : [" + formObject.query_sort.value + "]");

			doActionIBSheet(sheetObjects[2],document.form,IBSEARCH);
		}
    }

    /**
     * B/L No. 값 설정
     */
    function setBlNo(sheetObj, param){

		//alert("param : [" + param + "]");

		var formObject = document.form;

		var rect = document.getElementById("td_bl_no").getBoundingClientRect();

		formObject.bl_rect_top.value = formObject.bl_rect_top.value == "" ? rect.top : formObject.bl_rect_top.value;
		formObject.bl_rect_left.value = formObject.bl_rect_left.value == "" ? rect.left : formObject.bl_rect_left.value;

		if ( param == 1 ) {

			// sheet 활성화
			document.getElementById("bl_input").style.display = "none";
			document.getElementById("bl_sheet").style.display = "block";

			// sheet 위치설정
			document.getElementById("bl_sheet").style.top = formObject.bl_rect_top.value;
			document.getElementById("bl_sheet").style.left = formObject.bl_rect_left.value;

			// sheet(1, "bl_no")값에 input_bl_no.value값 입력

			var BlNoselectRow = formObject.sheet_bl_no_row_chk.value != "" ? formObject.sheet_bl_no_row_chk.value : "1";

			if ( sheetObj.RowCount > 0 ) {
				sheetObj.CellValue2(BlNoselectRow, prefix1 + "bl_no") = formObject.input_bl_no.value;
			}
			sheetObj.SelectCell(BlNoselectRow, prefix1 + "bl_no");
		}
		else if ( param == 2 ) {
			// input 활성화
			document.getElementById("bl_input").style.display = "block";
			document.getElementById("bl_sheet").style.display = "none";

			for (var i=sheetObj.HeaderRows; i <=sheetObj.LastRow; i++) {
				//
				if ( sheetObj.CellValue(i, prefix1 + "bl_no") != "" ) {
					formObject.sheet_bl_no_row_chk.value = i;
					formObject.input_bl_no.value = sheetObj.CellValue(i, prefix1 + "bl_no");
					//alert(prefix1 + "bl_no : [" + sheetObj.CellValue(i, prefix1 + "bl_no") + "]\n\n" + "input_bl_no : [" + formObject.input_bl_no.value + "]");
					break;
				}
			}
		}
		else if ( param == 3) {
			if ( document.getElementById("bl_sheet").style.display == "block" ) {
				setBlNo(sheetObj, 2);
			}
		}

    }
     
     /**
      * BKG No. 값 설정
      */
     function setBkgNo(sheetObj, param){

 		//alert("param : [" + param + "]");

 		var formObject = document.form;

 		var rect = document.getElementById("td_bkg_no").getBoundingClientRect();

 		formObject.bkg_rect_top.value = formObject.bkg_rect_top.value == "" ? rect.top : formObject.bkg_rect_top.value;
 		formObject.bkg_rect_left.value = formObject.bkg_rect_left.value == "" ? rect.left : formObject.bkg_rect_left.value;

 		if ( param == 1 ) {

 			// sheet 활성화
 			document.getElementById("bkg_input").style.display = "none";
 			document.getElementById("bkg_sheet").style.display = "block";

 			// sheet 위치설정
 			document.getElementById("bkg_sheet").style.top = formObject.bkg_rect_top.value;
 			document.getElementById("bkg_sheet").style.left = formObject.bkg_rect_left.value;

 			// sheet(1, "bkg_no")값에 input_bkg_no.value값 입력

 			var BkgNoselectRow = formObject.sheet_bkg_no_row_chk.value != "" ? formObject.sheet_bkg_no_row_chk.value : "1";

 			if ( sheetObj.RowCount > 0 ) {
 				sheetObj.CellValue2(BkgNoselectRow, prefix3 + "bkg_no") = formObject.input_bkg_no.value;
 			}
 			sheetObj.SelectCell(BkgNoselectRow, prefix3 + "bkg_no");
 		}
 		else if ( param == 2 ) {
 			// input 활성화
 			document.getElementById("bkg_input").style.display = "block";
 			document.getElementById("bkg_sheet").style.display = "none";

 			for (var i=sheetObj.HeaderRows; i <=sheetObj.LastRow; i++) {
 				//
 				if ( sheetObj.CellValue(i, prefix3 + "bkg_no") != "" ) {
 					formObject.sheet_bkg_no_row_chk.value = i;
 					formObject.input_bkg_no.value = sheetObj.CellValue(i, prefix3 + "bkg_no");
 					//alert(prefix3 + "bkg_no : [" + sheetObj.CellValue(i, prefix3 + "bkg_no") + "]\n\n" + "input_bkg_no : [" + formObject.input_bkg_no.value + "]");
 					break;
 				}
 			}
 		}
 		else if ( param == 3) {
 			if ( document.getElementById("bkg_sheet").style.display == "block" ) {
 				setBkgNo(sheetObj, 2);
 			}
 		}

     }

    /**
     * 페이지 초기화
     */
	function pageReset(sheetObj, formObject) {
		// pageReset(sheetObjects[0] formObject)

		for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			sheetObj.CellValue2(i, prefix1 + "bl_no") = "";
		}
		for (var i=sheetObjects[1].HeaderRows; i <= sheetObjects[1].LastRow; i++) {
			sheetObjects[1].CellValue2(i, prefix3 + "bkg_no") = "";
		}

		formObject.reset();

		// 멀티콤보초기화
		formObject.tb1_Mbooking_rcv_term_cd.Code = "";
		formObject.tb1_Mbooking_de_term_cd.Code = "";
		formObject.tb1_Morg_sconti_cd.Code = "";
		formObject.tb1_Mdesc_sconti_cd.Code = "";
		formObject.tb1_Morg_svc_mod_cd.Code = "";
		formObject.tb1_Mdesc_inlnd_svc_mod_cd.Code = "";
	}

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObject,sAction, bParam){

		//alert("validateForm\n\nwindow.event  : [" + chk + "]");

		with(formObject){

			var BlNoselectRow = sheet_bl_no_row_chk.value != "" ? sheet_bl_no_row_chk.value : "1";
			var BkgNoselectRow = sheet_bkg_no_row_chk.value != "" ? sheet_bkg_no_row_chk.value : "1";

			if ( sheetObj.RowCount > 0 ) {
				sheetObj.CellValue2(BlNoselectRow, prefix1 + "bl_no") = input_bl_no.value;
			}
			if ( sheetObjects[1].RowCount > 0 ) {
				sheetObjects[1].CellValue2(BkgNoselectRow, prefix3 + "bkg_no") = input_bkg_no.value;
			}
			sheetObj.SelectCell(BlNoselectRow, prefix1 + "bl_no");
			sheetObjects[1].SelectCell(BkgNoselectRow, prefix3 + "bkg_no");

			// B/L No
			master_bl_no.value = multiSheetRow(formObject, sheetObj, prefix1 + "bl_no", true);
			master_bl_no.value = master_bl_no.value.length == 0 ? input_bl_no.value : master_bl_no.value;
			
			// BKG No
			master_bkg_no.value = multiSheetRow(formObject, sheetObjects[1], prefix3 + "bkg_no", true);
			master_bkg_no.value = master_bkg_no.value.length == 0 ? input_bkg_no.value : master_bkg_no.value;

			if ( vvd.value.trimAll().length == 0 && master_bl_no.value.length == 0 && master_bkg_no.value.length == 0 && obl_iss_from_dt.value == "" && obl_iss_to_dt.value == "" ) {
				//
				ComShowCodeMessage("BKG00367");
				if (window.event != null) {
					if (vvd.value.length == 0) {
						vvd.focus();
					}
					else if (master_bl_no.value.length == 0) {
						master_bl_no.focus();
					}
					else if (master_bkg_no.value.length == 0) {
						master_bkg_no.focus();
					}
					else if (obl_iss_from_dt.value.length == 0) {
						obl_iss_from_dt.focus();
					}
					else if (obl_iss_to_dt.value.length == 0) {
						obl_iss_to_dt.focus();
					}
				}
				return false;
			}
			
			//alert("master_bl_no.value.length : [" + master_bl_no.value.length + "]\n\n" + "master_bl_no : [" + master_bl_no.value + "]");

			// obl_iss_from_dt / obl_iss_to_dt
			if ( obl_iss_from_dt.value != "" && obl_iss_to_dt.value != "" ) {
				var sTitle1 = (obl_iss_from_dt.getAttribute("caption")==null)?"start date":obl_iss_from_dt.getAttribute("caption");
				var sTitle2 = (obl_iss_to_dt.getAttribute("caption")==null)?"start date":obl_iss_to_dt.getAttribute("caption");

				var blDateChk = 0;
				blDateChk = ComGetDaysBetween(obl_iss_from_dt.value, obl_iss_to_dt.value);

				if ( blDateChk < 0 ) {

					var sMsg = ComGetMsg("COM12133", "'" + sTitle1+ "'",  "'" + sTitle2+ "'", "later");

					ComShowMessage(sMsg);

					obl_iss_from_dt.focus();
					return false;
				}

                if (ComGetDaysBetween(obl_iss_from_dt.value,obl_iss_to_dt.value) > 7 ) {
                    ComShowCodeMessage("BKG00756","Duration","7Days")
                    obl_iss_from_dt.focus();
                    return false;
                }
			}
			
			if (ComIsEmpty(vvd) &&
                ComIsEmpty(input_bl_no) &&
                ComIsEmpty(input_bkg_no) &&
               !ComIsEmpty(obl_iss_from_dt) &&
               !ComIsEmpty(obl_iss_to_dt) &&
				ComIsEmpty(vvd_pol_cd) &&
                ComIsEmpty(vvd_pod_cd) &&
                ComIsEmpty(booking_por_cd) &&
                ComIsEmpty(booking_pol_cd) &&
                ComIsEmpty(booking_pod_cd) &&
                ComIsEmpty(booking_del_cd) &&
                ComIsEmpty(bkg_ofc_cd) &&
                ComIsEmpty(doc_usr_cd) &&
                ComIsEmpty(ob_sls_ofc_cd) &&
                ComIsEmpty(ob_srep_cd) &&
                ComIsEmpty(obl_iss_ofc_cd) &&
                ComIsEmpty(obl_iss_usr_id) ) {
				//Mandatory item is missing. Please enter ({?msg1})
				ComShowCodeMessage("BKG00104",
					"\n\tPOL or"+
					"\n\tPOD or"+
					"\n\tBooking Route or"+
					"\n\tBooking Office or"+
					"\n\tBooking Staff or"+
					"\n\tSales Office or"+
					"\n\tSales Rep. or"+
					"\n\tB/L Office or"+
					"\n\tB/L Staff");
				return false;
			}
		}

		return true;
	}

	/**
	 * 공통팝업 - COM_ENS_011
	 */
	function Pop_COM_ENS_011(formObject) {
		var param = "?rep_cmdt_cd=" + formObject.rep_cmdt_cd.value;
		param += "&cmdt_cd=" + formObject.cmdt_cd.value;
		param += "&cmdt_nm=" + formObject.cmdt_nm.value;
		ComOpenPopup("/hanjin/COM_ENS_011.do" + param, 780, 460, "getCOM_ENS_011", "1,0,1,1,1,1,1,1", true);
	}

	/**
	 * 팝업 - ESM_BKG_0655.do / ESM_BKG_0654.do
	 */
	function Pop_ESM_BKG_06545(formObject) {
		if (formObject.sc_rfa_chk[0].checked) {
			ComOpenPopup("/hanjin/ESM_BKG_0655.do", 585, 460, "getESM_BKG_06545", "1,0,1,1,1,1,1,1", true);
		} else if (formObject.sc_rfa_chk[1].checked) {
			ComOpenPopup("/hanjin/ESM_BKG_0654.do", 835, 460, "getESM_BKG_06545", "1,0,1,1,1,1,1,1", true);
		} else if (formObject.sc_rfa_chk[2].checked) {
			var pgmNo = "ESM_PRI_3007";
			var pgmUrl = "/hanjin/ESM_PRI_3007.do";
			var params = "&cond_taa_no="+ComGetObjValue(formObject.sc_rfa_no);
			var parentPgmNo = pgmNo.substring(0,8)+"M001";
			var src = "&pgmUrl="+ComReplaceStr(pgmUrl,"/","^")+"&pgmNo="+pgmNo+params;
			var sUrl = "alpsMain.screen?parentPgmNo="+parentPgmNo+src;
			var iWidth = 1024;
			var iHeight = 700;
			var leftpos = (screen.width - iWidth) / 2;
			if (leftpos < 0) leftpos = 0;
			var toppos = (screen.height - iHeight) / 2;
			if (toppos < 0) toppos = 0;
			var sFeatures = "status=no, resizable=yes, scrollbars=yes, width="+iWidth+", height="+iHeight+", left="+leftpos+", top="+toppos;
			ComOpenWindow(sUrl, "", sFeatures);	   
		}
	}

	/**
	 * 공통팝업 - COM_ENS_041
	 */
	function Pop_COM_ENS_041(formObject) {
		var param = "?cust_cd=" + formObject.cust_cnt_cd.value + formObject.cust_seq.value;
		param += "&cust_nm=" + formObject.cust_nm.value;
		ComOpenPopup("/hanjin/COM_ENS_041.do" + param, 780, 460, "getCOM_ENS_041", "1,0,1,1,1,1,1,1", true);
	}

	/**
	 * 공통팝업 - Pop_ESM_BKG_0161
	 */
	function Pop_ESM_BKG_0161(formObject) {
		var param = "?codeGubun=CD02347&isPop=Y";
		ComOpenWindowCenter2("/hanjin/ESM_BKG_0161.do"+param, "PopupEsmBkg0161", 400, 230, false, "scrollbars=no,resizable=yes");
	}

/*
//	멀티콤보에서의 Enter Key 적용에 대한 처리 - 객체별로 정의
	// IBMultiCombo OnCheckClick
	function tb1_Mbooking_rcv_term_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}

	function tb1_Mbooking_de_term_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}

	function tb1_Morg_sconti_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}

	function tb1_Mdesc_sconti_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}

	function tb1_Morg_svc_mod_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}

	function tb1_Mdesc_inlnd_svc_mod_cd_OnKeyDown(comboObj, KeyCode, Shift) {
		//
		if (KeyCode = 13) {
			Retrive("tb1_btn_Retrieve");
		}
	}
*/

	/**
	 * BLPrint / Manifest 버튼 선택 시 체크여부 및 프린트 처리
	 */
	function BLPrint(formObj, sheetObj, strGubun) {
		var iCheckRow = sheetObj.FindCheckedRow(prefix2 + "Check");

		var obl_rlse_flg = "";

		if (iCheckRow <= 1) {
			ComShowCodeMessage("COM12176");  //Please select one at least.
			return;
		}

		var strResult = "";

		var arrRow = iCheckRow.split("|");

		for (idx=0; idx<arrRow.length-1; idx++) {
			//alert(arrRow[idx]);

			if (0>strResult.indexOf(sheetObj.CellValue(arrRow[idx], prefix2 + "bkg_no"))) {
				strResult += sheetObj.CellValue(arrRow[idx], prefix2 + "bkg_no") + ",";
			}

			//strResult += sheetObj.CellValue(arrRow[idx], prefix2 + "bkg_no") + "|";

			if ( idx == 0 && ""!=obl_rlse_flg) {
				//strResult = sheetObj.CellValue(arrRow[idx], prefix2 + "bkg_no");
				obl_rlse_flg = sheetObj.CellValue(arrRow[idx], prefix2 + "obl_rlse_flg");
				//break;
			}
		}
		strResult = strResult.substring(1,eval(strResult.lengthByte())-2);
		
		//strResult = strResult.substring(0, eval(strResult.lengthByte()) - 1);

		var form_manifest = "N";

		/*
		1. 리스트 검색 조건의 POD가 VN으로 시작하는 Location Code 일 경우에는 Final Destination에 Yard Name을 아래와 같이 표시함 ---> manifest 이면서 VN검색 조건이 충족
		- VNSGNY6 : VICT  
		- VNSGNY2 : Cat Lai Terminal 
		2. 위 이외의 조건일 경우에는  B/L Print 시에는, B/L의 Port of Discharging에 Booking POD 대신, T/VVD의 POD를 표기함 ---> manifest 이면서 BKG_BOOKING.POD_CD 대신 BKG_VVD.POD_CD(TRUNK VVD 기준)을 표기함.
		*/

		// vvd_pod_cd / vvd_post_pod / booking_pod_cd
		if ( strGubun == "Manifest" ) {
			/*
			if ( formObj.vvd_pod_cd.value.indexOf("VN") == 0 || formObj.vvd_post_pod.value.indexOf("VN") == 0 || formObj.booking_pod_cd.value.indexOf("VN") == 0 ) {
				form_manifest = "Y";
			}
			else {
				//
				form_manifest = "X";
			}
			*/
			form_manifest = "X";
		}

		//alert( formObj.vvd_pod_cd.value + "\n\n" + formObj.vvd_post_pod.value + "\n\n" + formObj.booking_pod_cd.value );
		//alert( formObj.vvd_pod_cd.value.indexOf("VN") + "\n\n" + formObj.vvd_post_pod.value.indexOf("VN") + "\n\n" + formObj.booking_pod_cd.value.indexOf("VN") );

		//alert("form_manifest : [" + form_manifest + "]");

		var param = "?bkg_no=" + strResult + "&form_manifest=" + form_manifest + "&obl_rlse_flg=" + obl_rlse_flg;
		//alert("param : [" + param + "]");

		if (500 < strResult.split(",").length) {
			ComShowCodeMessage("BKG08124",500);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
			return;
		}
		
		var obj = new Object();
		obj.bkg_no = strResult;
		obj.form_manifest = form_manifest;
		obj.obl_rlse_flg = obl_rlse_flg;
		var sFeatures = "scroll:no;status:no;help:no;dialogWidth:900px;dialogHeight:340px";//;dialogLeft:450;dialogTop:345";
		window.showModalDialog("/hanjin/ESM_BIS_0743_01.do", obj, sFeatures);
	}

	/**
	 * 조회 후 sheet의 컬럼 선택 시 정렬에 대한 처리(소계와 연계가 되서 sheet에서 제공되는 기본 정렬기능은 사용하지 못함)
	 */
	function SheetSort(formObj, sheetObj, sortarrow) {
		//
		with(sheetObj)
		{
			if ( sortarrow == "" || sortarrow == undefined ) {
				sortarrow = "ASC";
			}

			HideSubSum();

			var sqlOrder = formObj.query_sort.value.split("|");

			var sqlShowSubSunCol= sqlOrder[0].toLowerCase();

			var strCol = "";
			var strColSort = "";

			for (var j=0; j < sqlOrder.length ; j++ ) {
				strCol += prefix2 + sqlOrder[j].toLowerCase() + "=%s;";
				strColSort += prefix2 + sqlOrder[j].toLowerCase() + "|";
			}// end for

			strColSort = strColSort.substr(0, strColSort.length-1);

			//alert("sqlOrder : [" + sqlOrder + "]\n\n" + "sqlOrder.length : [" + sqlOrder.length + "]\n\n" + "strCol : [" + strCol + "]\n\n" + "strColSort : [" + strColSort + "]");

			ColumnSort(strColSort, sortarrow);

			//return;

			// 소계를 하기위한 기준 컬럼을 첫번째 정렬기준 컬럼으로 정한다.(임의로 결정한 것이므로 추후 결정되면 수정되야 함)
			ShowSubSum(prefix2 + sqlShowSubSunCol, prefix2 + "blank", 0, false, false, -1, strCol);

			var sRow = FindSubSumRow(prefix2 + sqlShowSubSunCol);

			var arrRow = sRow.split("|");
			for (idx=0; idx<arrRow.length-1; idx++) {
				//alert("arrRow["+idx+"] : [" + arrRow[idx] + "]");
				CellFont("FontBold", arrRow[idx],1, arrRow[idx],LastCol) = true;
			}
		}
	}

	/**
	 * t2shee1의 시트 조회 완료 후 처리
	 */
	function t2sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		var formObj = document.form;

		if (sheetObj.RowCount > 0) {

			//sheetObj.ColFontUnderline(prefix2 + "bl_no") = true;
			//sheetObj.ColFontColor(prefix2 + "bl_no") = sheetObj.RgbColor(000,000,255);

			var blbkgnoCnt = 0;
			// 다른 컬럼과 마찬가지로 색을 조정(수정불가의 바탕색)
			sheetObj.ColBackColor(prefix2 + "consignee") = sheetObj.RgbColor(239,235,239);
			sheetObj.ColBackColor(prefix2 + "shipper") = sheetObj.RgbColor(239,235,239);
			// 디폴트로 체크된상태로 표기
			//sheetObj.CheckAll2(prefix2 + "Check") = 1;

			for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
				if ( sheetObj.CellValue(i, prefix2 + "bkg_no") != "" ) {
					blbkgnoCnt++;
				}
			}

			SheetSort(formObj, sheetObj);
			
			// Booking Q'ty set - sheetObj.RowCount
			formObj.bookingCnt.value = ComAddComma(sheetObj.RowCount("R"));

			// B/L Q'ty set - blbkgnoCnt
			formObj.bldocCnt.value = ComAddComma(blbkgnoCnt);

			// Weight(TON) set
			formObj.weightTon.value = ComAddComma( ComTrunc(sheetObj.ComputeSum(prefix2 + "bl_act_wgt"), 0) );

			// Measure set
			formObj.Measure.value = ComAddComma( ComTrunc(sheetObj.ComputeSum(prefix2 + "bl_meas_qty"), 0) );

			// TOT TEU set
			formObj.total_all_teu.value = new Number(ComTrunc(sheetObj.ComputeSum(prefix2 + "teu"), 0)+ComTrunc(sheetObj.ComputeSum(prefix2 + "feu"), 0)*2).toFixed(2);

			
			//searching = false;

			// 조회 완료 후 조회결과 시트가 있는 탭으로 이동
			if (tabObjects[0].selectedIndex != 1) {
				tabObjects[0].selectedIndex = 1;
			}

			// B/L No. 2개이상의 입력된 값이 있을경우 bl_sheet 레이어를 띄어준다.
			var bl_input_chk = 0;
			for (var j=sheetObjects[0].HeaderRows; j < sheetObjects[0].LastRow; j++) {
				if ( sheetObjects[0].CellValue(j, prefix1 +"bl_no") != "" ) {
					bl_input_chk++;

					if ( bl_input_chk > 1 ) {
						setBlNo(sheetObjects[0], 1);
						break;
					}
				}
			}

			// BKG No. 2개이상의 입력된 값이 있을경우 bkg_sheet 레이어를 띄어준다.
			var bkg_input_chk = 0;
			for (var j=sheetObjects[1].HeaderRows; j < sheetObjects[1].LastRow; j++) {
				if ( sheetObjects[1].CellValue(j, prefix3 +"bkg_no") != "" ) {
					bkg_input_chk++;

					if ( bkg_input_chk > 1 ) {
						setBkgNo(sheetObjects[1], 1);
						break;
					}
				}
			}


		}
		else {
			// Booking Q'ty set - sheetObj.RowCount
			formObj.bookingCnt.value = "";
			// B/L Q'ty set - blbkgnoCnt
			formObj.bldocCnt.value = "";
			// Weight(TON) set
			formObj.weightTon.value = "";
			// Measure set
			formObj.Measure.value = "";
			// TOT TEU set
			formObj.total_all_teu.value = "";
		}
		
	}

	/**
	 * t2shee1의 정렬 이벤트 발생 시 처리
	 */
	function t2sheet1_OnSort(sheetObj, Col, SortArrow) {
		//
		var formObj = document.form;

		var colnm = sheetObj.ColSaveName(Col);

		if ( colnm != prefix2 + "ibflag" && colnm != prefix2 + "Check" && colnm != prefix2 + "Seq") {
			//alert("Col : [" + sheetObj.ColSaveName(Col) + "]\n\n" + "SortArrow : [" + SortArrow + "]");

			formObj.query_sort.value = colnm.split(prefix2)[1];

			//alert("sheetObj.RowCount  : [" +  sheetObj.RowCount + "]\n\n" + "ColSaveName : [" + sheetObj.ColSaveName(Col) + "]\n\n" + "formObj.query_sort.value : [" + formObj.query_sort.value + "]");

			SheetSort(formObj, sheetObj, SortArrow);
		}
	}

	/**
	 * t2shee1의 check cell을 check 시 처리
	 */
	var oldRow = 0;
	var oldChk = 0;
	var isShift = false;
	function t2sheet1_OnBeforeCheck(sheetObj, newRow, Col) {
		if (1==Col) {
			with(sheetObj) {
				if (isShift) {
					var curRow = newRow;
					if (newRow < oldRow) {
						newRow = oldRow;
						oldRow = curRow;
					}
					for (var i=oldRow; i<=newRow; i++) {
						if (!ComIsEmpty(CellValue(i,prefix2+"bl_no"))) {
							CellValue2(i,prefix2+"Check") = 0==oldChk ? 1 : 0;
						}
					}
					CellValue2(curRow,prefix2+"Check") = 0==CellValue(curRow,prefix2+"Check") ? 1 : 0;
				}
				oldRow = newRow;
				oldChk = CellValue(oldRow,prefix2+"Check");
			}
		}
	}
	function sheet_keydown() {
		if (16==event.keyCode) {  //shift
			isShift = true;
		}
	}
	function sheet_keyup() {
		if (16==event.keyCode) {  //shift
			isShift = false;
		}
	}

	/**
	 * 선택된 key값에 의해 기 생성된 RD(*.mrd)로 파라메터를 보내 처리
	 */
	function RdPrint(sheetObject, param) {
		///rp [( ('SHAZ7250007','  '), ('SLCZ5120010','  ') )] /riprnmargin /rprncenteropt [1]

		var formObject = document.form;

		var iCheckRow = sheetObject.FindCheckedRow(prefix2 + "Check");

		if (iCheckRow <= 1) {
			//alert("선택한 항목이 없습니다!!!");
			ComShowCodeMessage("COM12176");  //Please select one at least.
			return;
		}
		var strResult = "";

		var arrRow = iCheckRow.split("|");

		for (idx=0; idx<arrRow.length-1; idx++) {
			//alert(arrRow[idx]);

			strResult += "'" + sheetObject.CellValue(arrRow[idx], prefix2 + "bkg_no") + "',";
		}
		if (0<strResult.indexOf(",")) strResult = strResult.substring(0,strResult.length-1);

		if (500 < strResult.split(",").length) {
			ComShowCodeMessage("BKG08124",500);  //You select more than {?msg1} B/Ls for B/L print. Max is {?msg1} B/Ls one time
			return;
		}

		strResult = "[( " + strResult + " )] [" + param + "]";

		//alert("strResult : [" + strResult + "]");

		// 2009-10-21 RD공통팝업으로 수정
		//rdOpen(rdObjects[0], document.form, strResult);
		formObject.com_mrdTitle.value = "EIR (HKG)";
		formObject.com_mrdBodyTitle.value = "EIR (HKG)";
		formObject.com_mrdPath.value = "apps/alps/esm/bis/blinformation/blinformation/report/ESM_BIS_0791.mrd";
		
		formObject.com_mrdArguments.value = "/rp " + strResult + " /riprnmargin";
		formObject.com_isBatch.value = "Y";
		
		ComOpenRDPopup();
	}

	/**
	 * 선택한 sheet의 특정 컬럼의 전체Row의 값을 문자열로 반환
	 * @param {object} sheetObj 필수, IBSheet Object
	 * @param {object} formObj 필수, form Object
	 * @param {boolean} boolean 필수, '를 포함한 개별 문자열로 묶을것인지 여부
	 */
	function multiSheetRow(formObject, sheetObj, col, gubun) {
		var strValue = "";

		// B/L No. input값에 데이터가 있을 경우
		if ( sheetObj.RowCount > 0 ) {
			sheetObj.CellValue2(0, prefix1 + "bl_no") = formObject.input_bl_no.value;
		}
		// BKG No. input값에 데이터가 있을 경우
		if ( sheetObj.RowCount > 0 ) {
			sheetObj.CellValue2(0, prefix3 + "bkg_no") = formObject.input_bkg_no.value;
		}
		//formObject.input_bl_no.value

		for (var i=sheetObj.HeaderRows; i <= sheetObj.LastRow; i++) {
			if ( sheetObj.CellValue(i, col) != "" ) {
				if (gubun) {
					strValue += sheetObj.CellValue(i, col) + "|";
				}
				else {
					strValue += sheetObj.CellValue(i, col);
				}
			}
		}

		strValue = strValue.substring(0, eval(strValue.lengthByte()) - 1);

		return strValue;
	}

	/* 개발자 작업  끝 */