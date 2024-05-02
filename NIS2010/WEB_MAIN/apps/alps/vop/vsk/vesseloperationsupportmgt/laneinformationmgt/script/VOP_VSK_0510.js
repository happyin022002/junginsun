/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0510.js
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
* 
* History
* 2011.05.11 진마리아 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건
* 2011.06.15 진마리아 [CHM-201111079-01] Lane code 체크 로직 부분 수정
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
     * @class vop_vsk_0510 : vop_vsk_0510 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function vop_vsk_0510() {
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
var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0;

var marrPrefix = new Array("t1sheet1_", "t2sheet1_", "t3sheet1_");
var marrTabTitle = new Array("Lane Group", "PIC", "Bunkering Port");

var marrPicTpCd = new Array("I", "J", "S");
var marrPicTpNm = new Array("Independence Operation Lane", "Joint Operation Lane", "Special Cargo Authorization Part");
var mCheckValue = false;
var mEditRow = 0;
var mEditSheet = 0;
var mPrefix = "";
var mPreSearCond = "";
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
         var sheetObject2 = sheetObjects[1];
         var sheetObject3 = sheetObjects[2];
         var sheetObject4 = sheetObjects[3];
         var sheetObject5 = sheetObjects[4]; 
         var sheetObject6 = sheetObjects[5];
         var sheetObject7 = sheetObjects[6];         
         var sheetObject8 = sheetObjects[7];         
         var sheetObject9 = sheetObjects[8];         
         var sheetObject10 = sheetObjects[9];         

         /*******************************************************/
         var formObject = document.form;
         var objs = document.all.item("tabLayer");
         
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

/**		TAB 1		**/
						case "btn_Retrieve":
								doActionIBSheet(beforetab, formObject, IBSEARCH);
								break;

						case "btn_Save":
								doActionIBSheet(beforetab, formObject, IBSAVE);
								break;
								
						case "btn_New":
							var statsCnt = 0;
							var changeSheet = "";
							for(var cnt = 4; cnt < 9; cnt++){
								if(cnt != 7){
									var changeSheetCnt = sheetObjects[cnt].RowCount("I") + sheetObjects[cnt].RowCount("U") + sheetObjects[cnt].RowCount("D");
									
									if(changeSheetCnt > 0){
										var title = (cnt < 8 ? marrPicTpNm[cnt - 4] : "Bunkering Port");
										statsCnt += changeSheetCnt;
										changeSheet += changeSheet == "" ? title : ", " + title;
									}
								}
							}

							if(statsCnt > 0){
								if(ComShowCodeConfirm("VSK50012")){
									clearFormNData();
									moveFocus(beforetab);
								}
							}
							break;
						
						case "ComOpenPopupWithTarget":
							if( objs[0].style.display != "inline" ){
								ComOpenPopupWithTarget('/hanjin/COM_ENS_081.do', 830, 460, "col1:slan_cd", "0,0,1,1,1,1,1", true);
							}
							break;

						case "btn_DownExcel":
								if(beforetab == 1){
									jointSheet2Excel();
								}else{
									sheetObject9.Down2Excel(1, false, false, true, "", "", false, false, "",
															false, "t3sheet1_del_chk|t3sheet1_upd_usr_id|t3sheet1_upd_dt", 
															"", false, false, "") ;
									
								}
								break;					
								
						case "btn_t1DLGroup":
								ComOpenPopupWithTarget('/hanjin/VOP_VSK_0702.do', 725, 660, "loc_cd:loc_cd", "0,1,1,1,1,1,1", true);
								break;																		

/**		TAB 2		**/
						//Independence Operation Lane
						case "btn_t2insert1":
								var Row = sheetObject5.DataInsert();
								sheetObject5.CellValue(Row, "t2sheet1_slan_cd") = formObject.slan_cd.value;
								sheetObject5.CellValue(Row, "t2sheet1_lane_pic_tp_cd") = marrPicTpCd[0];
								sheetObject5.SelectCell(Row, "t2sheet1_rgn_shp_opr_cd", true);
								break; 
								
						case "btn_t2add1":
								var Row = sheetObject5.DataInsert(-1);
								sheetObject5.CellValue(Row, "t2sheet1_slan_cd") = formObject.slan_cd.value;
								sheetObject5.CellValue(Row, "t2sheet1_lane_pic_tp_cd") = marrPicTpCd[0];
								sheetObject5.SelectCell(Row, "t2sheet1_rgn_shp_opr_cd", true);
								break;	
								
						case "btn_t2del1":
								ComRowHideDelete(sheetObject5,"t2sheet1_del_chk");
								break;

						//Joint Operation Lane
						case "btn_t2insert2":
								var Row = sheetObject6.DataInsert();
								sheetObject6.CellValue(Row, "t2sheet2_slan_cd") = formObject.slan_cd.value;
								sheetObject6.CellValue(Row, "t2sheet2_lane_pic_tp_cd") = marrPicTpCd[1];
								sheetObject6.SelectCell(Row, "t2sheet2_rgn_shp_opr_cd", true);
								break; 
								
						case "btn_t2add2":
								var Row = sheetObject6.DataInsert(-1);
								sheetObject6.CellValue(Row, "t2sheet2_slan_cd") = formObject.slan_cd.value;
								sheetObject6.CellValue(Row, "t2sheet2_lane_pic_tp_cd") = marrPicTpCd[1];
								sheetObject6.SelectCell(Row, "t2sheet2_rgn_shp_opr_cd", true);
								break;	
								
						case "btn_t2del2":
								ComRowHideDelete(sheetObject6,"t2sheet2_del_chk");
								break;
																
						//Special Cargo Authorization Part
						case "btn_t2insert3":
								var Row = sheetObject7.DataInsert();
								sheetObject7.CellValue(Row, "t2sheet3_slan_cd") = formObject.slan_cd.value;
								sheetObject7.CellValue(Row, "t2sheet3_lane_pic_tp_cd") = marrPicTpCd[2];
								sheetObject7.SelectCell(Row, "t2sheet3_rgn_shp_opr_cd", true);
								break; 
								
						case "btn_t2add3":
								var Row = sheetObject7.DataInsert(-1);
								sheetObject7.CellValue(Row, "t2sheet3_slan_cd") = formObject.slan_cd.value;
								sheetObject7.CellValue(Row, "t2sheet3_lane_pic_tp_cd") = marrPicTpCd[2];
								sheetObject7.SelectCell(Row, "t2sheet3_rgn_shp_opr_cd", true);
								break;	
								
						case "btn_t2del3":
								ComRowHideDelete(sheetObject7,"t2sheet3_del_chk");
								break;
									
/**		TAB 3		**/
						case "btn_t3add":
								var Row = sheetObject9.DataInsert(-1);
								sheetObject9.CellValue(Row, "t3sheet1_vsl_slan_nm") = "Lane";
								sheetObject9.SelectCell(Row, "t3sheet1_vsl_slan_cd", true);
								break;

						case "btn_t3insert":
								var Row = sheetObject9.DataInsert();
								sheetObject9.CellValue(Row, "t3sheet1_vsl_slan_nm") = "Lane";
								sheetObject9.SelectCell(Row, "t3sheet1_vsl_slan_cd", true);
								break;
								
						case "btn_t3del":
								ComRowHideDelete(sheetObject9, "t3sheet1_del_chk");
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
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++] = tab_obj;

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

		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}


		initControl();
		initComboData();
    }

	function initComboData(){
		var formObj = document.form;

		formObj.f_cmd.value = SEARCH04;
		var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj));

		var arrCombo = ComXml2ComboString(sXml, "val", "name");

		document.t2sheet1.InitDataCombo(0, "t2sheet1_rgn_shp_opr_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
		document.t2sheet2.InitDataCombo(0, "t2sheet2_rgn_shp_opr_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
		document.t2sheet3.InitDataCombo(0, "t2sheet3_rgn_shp_opr_cd", " |" + arrCombo[1], " |" + arrCombo[0]);
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
					for(; cnt < marrTabTitle.length; cnt++){
						InsertTab(cnt, marrTabTitle[cnt], -1);
					}
			}
            break;
        }
    }

    /**
    * 초기 이벤트 등록 
    */
    function initControl() {
		axon_event.addListenerForm  ('blur',			'obj_deactivate',	form); //- form 전체 컨트롤 모든 컨트롤의 OnBeforeDeactivate(blur)이벤트에 코드 처리
        axon_event.addListenerFormat('focus',			'obj_activate',		form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate(focus)이벤트에 코드 처리
        axon_event.addListenerFormat('keypress',        'obj_keypress', 	form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리

		axon_event.addListener('keypress', 'slan_cd_onkeypress', 'slan_cd', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('keyup', 'slan_cd_onkeyup', 'slan_cd', '');			//Port Cd변경시에 처리되는 로직...
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 제거한다. <br>
     **/
    function obj_activate(){
        //마스크구분자 없애기
        ComClearSeparator(event.srcElement);
    }
    /**
     * HTML Control의 onfocus이벤트에서 마스크 구분자를 살려주며. Validate를 체크하여준다.
     **/
	function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}
    /**
     * HTML Control의 onkeypress이벤트에서 숫자만 입력되게 한다. <br>
     **/
    function obj_keypress(){
    	switch(event.srcElement.dataformat){
			case "int":
		        //숫자 만입력하기
		        ComKeyOnlyNumber(event.srcElement);
				break;
			case "float":
		        //숫자+"."입력하기
		        ComKeyOnlyNumber(event.srcElement, ".");
				break;
			default:
		        //숫자만입력하기
		        ComKeyOnlyNumber(event.srcElement);
    	}
    }

    
    function dateFormat(n, digits) {
    	var zero = '';
    	n = n.toString();

    	if (n.length < digits) {
    		for (i = 0; i < digits - n.length; i++)
    	    zero += '0';
    	}
    	return zero + n;
    }
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
		if(sheetNo < 5){
			with (sheetObj) {
				// 높이 설정
				style.height = 162;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msNone;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle1 = "|No.|Lane Code|Lane Name|vskd_flet_grp_cd|upd_usr_id|upd_usr_id";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "t1sheet" + sheetNo + "_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "hidStatus");
				InitDataProperty(0, cnt++ , dtSeq,			40,	 	daCenter,	true,		prefix + "Seq",					false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "vsl_slan_cd",			false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			210,	daLeft,		true,		prefix + "vsl_slan_nm",			false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		0,		daLeft,		true,		prefix + "vskd_flet_grp_cd",	false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix + "upd_usr_id",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix + "upd_dt",				false,	"",	dfNone,	0,	true,	true);
				
				CountPosition = 0;
			}
		}else if(sheetNo > 4 && sheetNo < 9){
            with (sheetObj) {
				// 높이 설정
				style.height = 82;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]\
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle1 = "";
				
				if(sheetNo == 6){
					HeadTitle1 = "|Sel.|RSO|Name|Lane Code|Lane Code|Carrier| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
				}else{
					HeadTitle1 = "|Sel.|RSO|Name|Lane Code|Lane Code|Vessel Code| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
				}

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				/*
				 * mySheet.InitHeadMode([SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove], [Head3D])
				 *  
				 * SortEnable Boolean 선택  해더 행의 소트 가능 여부, Default=true 
				 * ColumnMove Boolean 선택  해더 행의 컬럼 이동 가능 여부, Default=false
				 * AllCheckEnable Boolean 선택  해더 행의 전체 CheckBox 표시 여부, Default=true
				 * UserResize Boolean 선택  해더 행의 컬럼 너비 변경 가능 여부, Default=true
				 * RowMove Boolean 선택  좌측 해더의 행 이동 가능 여부, Default=false
				 * Head3D Boolean 선택  해더 셀의 모양의 입체 여부Default=true 
				 */				
				InitHeadMode(true, true, true, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				
				if(sheetNo < 8)
					prefix =  "t2sheet" + (parseInt(sheetNo) - 4) + "_";

				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtCheckBox,		40,		daCenter,	true,		prefix + "del_chk");
				InitDataProperty(0, cnt++ , dtCombo,		50,		daLeft,		true,		prefix + "rgn_shp_opr_cd",		true,	"",	dfNone,	0,	true,	true, 3);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "usr_nm",				true,	"",	dfNone,	0,	true,	true, 100);
				InitDataProperty(0, cnt++ , dtPopupEdit,	50,		daCenter,	true,		prefix + "slan_cd",				true,	"",	dfEngUpKey,	0,	false,	true, 3);
				InitDataProperty(0, cnt++ , dtData,			50,		daLeft,		true,		prefix + "vsl_slan_nm",			false,	"",	dfNone,	0,	true,	true, 50);
				
				if(sheetNo == 6){
					InitDataProperty(0, cnt++ , dtPopupEdit,	90,		daLeft,		true,		prefix + "pic_crr_desc",		false,	"",	dfEngUpKey,	0,	true,	true, 3);
				}else{
					InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "pic_vsl_desc",		false,	"",	dfNone,	0,	true,	true, 500);
				}
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "jb_desc",				false,	"",	dfNone,	0,	true,	true, 1000);

				InitDataProperty(0, cnt++ , dtData,			110,	daLeft,		true,		prefix + "pic_eml",				true,	"",	dfNone,	0,	true,	true, 200);
				InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix + "lane_pic_usr_eml",	false,	"",	dfNone,	0,	true,	true, 50);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "pic_phn_no",			false,	"",	dfNone,	0,	true,	true, 20);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "mphn_no",				false,	"",	dfNone,	0,	true,	true, 20);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "fax_no",				false,	"",	dfNone,	0,	true,	true, 50);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "lane_rmk",			false,	"",	dfNone,	0,	true,	true, 1000);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		prefix + "lane_pic_tp_cd",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix + "lane_pic_seq",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix + "upd_usr_id",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix + "upd_dt",				false,	"",	dfNone,	0,	true,	true);
				
				InitDataValid(0, prefix + "slan_cd", vtEngUpOther, "1234567890");
				if(sheetNo == 6){
					InitDataValid(0, prefix + "pic_crr_desc", vtEngUpOnly);
				}
				CountPosition = 0;
			}
		}else if(sheetNo == 9){
			with (sheetObj) {
				// 높이 설정
				style.height = 362;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

				var HeadTitle1 = "|Bunkering Ports|Bunkering Ports|Bunkering Ports" + document.form.bunkerPort.value + "|Total";
						
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 4, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				var prefix = "t3sheet1_";
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,			daCenter,	false,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtData,			40,			daCenter,	true,		prefix + "vsl_slan_nm",		false,		"",					dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtCheckBox,		30,			daCenter,	false,		prefix + "del_chk");
				InitDataProperty(0, cnt++ , dtCombo,	60,			daCenter,	false,		prefix + "vsl_slan_cd",		false,		"",					dfEngUpKey,	0,		false,		true, 3);
				
				arrPort = document.form.bunkerPort.value.split("|");
				for(var arrIdx = 1;  arrIdx < arrPort.length; arrIdx++){
					var colNm = prefix + "rfuel_rto";
					if(arrIdx < 10)
						colNm = colNm + "_0" + arrIdx;
					else
						colNm = colNm + "_" + arrIdx;
					
					InitDataProperty(0, cnt++ , dtData,					53,			daCenter,	false,		colNm,			false,		"",					dfNullInteger,		0,		true,		true, 3);
				}

				InitDataProperty(0, cnt++ , dtData,					80,		daCenter,	false,		prefix + "rfuel_rto_tot",			false,		"",					dfNullInteger,		0,		false,		false);

				//InitDataCombo(0, prefix + "lane_cd"
				InitDataCombo(0, prefix + "vsl_slan_cd", " " + document.form.laneNm.value,  " " + document.form.laneCd.value);
				CountPosition = 0;
			}
		}else{
			with (sheetObj) {
									// 높이 설정
				style.height = 50;
				//전체 너비 설정
				SheetWidth = 50;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle1 = "|Value|Name";
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "sheet1_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	false,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "val");
				InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		prefix + "name");
			}
		}
	}	//End function

	function initCombo(comboObj, comboNo) {
		switch(comboObj.id) {
			case "vskd_flet_grp_cd":    //R/D Term-post
				var i=0;
				with(comboObj) {
					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "desc");
					comboObj.InsertItem(0, "ALL", "%");
					DropHeight = 200;
					MaxSelect = 1;
					Code = "%";
				}
				break;
		}
	}

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tabLane_OnChange(tabObj , nItem){

        var objs = document.all.item("tabLayer");

		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";

		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;

		//Fleet Type활성화 
		if(beforetab == 0){
			//document.form.slan_cd.disabled = true;
			ComEnableObject(document.all.slan_cd, false);
			ComClearObject(document.form.slan_cd);
			ComEnableObject(document.all.ComOpenPopupWithTarget, false);
			document.form.slan_cd.className = "input2";
			document.all.item("divExcell").style.display = "none";
		}else{
			//document.form.slan_cd.disabled = false;
			ComEnableObject(document.all.slan_cd, true);
			ComEnableObject(document.all.ComOpenPopupWithTarget, true);
			document.form.slan_cd.className = "input";
			document.all.item("divExcell").style.display = "inline";
		}
		moveFocus(beforetab);
	}

    function doActionIBSheet(tabIdx, formObj, sAction) {
        switch(sAction) {
			case IBSEARCH:		//조회
				if(validateForm(formObj,sAction)){
					//1번 탭을 제외한 PIC와 Bunkering Port는 조회조건이 변동되면. 모두 삭제.
					if(tabIdx != 0){
						if(mPreSearCond != formObj.slan_cd.value){
							clearSheet();
						}
					}

					if ( tabIdx == 0){
						var arrPrefix = new Array("t1sheet1_", "t1sheet2_", "t1sheet3_", "t1sheet4_");
						formObj.f_cmd.value = SEARCH01;
						//전체면. Fleet_Type이 값이 있으면.. 조회가 틀림...
							
						var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml = sXml.split("|$$|");

						if(arrXml.length > 3){
							for(var cnt = 0; cnt < arrXml.length; cnt++){
								sheetObjects[cnt].Redraw = false;    
								sheetObjects[cnt].WaitImageVisible = false;	
								sheetObjects[cnt].LoadSearchXml(arrXml[cnt]); 
								sheetObjects[cnt].Redraw = true; 
							}
						}
					}else if(tabIdx == 1){
						formObj.f_cmd.value = SEARCH02;
						sheetObjects[4].WaitImageVisible = true;	
						var arrPrefix = new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
						var sXml = sheetObjects[0].GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml = sXml.split("|$$|");

						if(arrXml.length > 2){
							for(var cnt = 4; cnt < arrXml.length + 4; cnt++){
								sheetObjects[cnt].Redraw = false;    
								sheetObjects[cnt].LoadSearchXml(arrXml[cnt - 4]); 
								sheetObjects[cnt].Redraw = true; 
								sheetObjects[cnt].WaitImageVisible = false;	
							}
						}
						mPreSearCond = formObj.slan_cd.value;
					}else if(tabIdx == 2){
						with(sheetObjects[8]){
							formObj.f_cmd.value = SEARCH03;
							WaitImageVisible = true;	
							var arrPrefix = new Array("t3sheet1_");
							var sXml = GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
							var arrXml = sXml.split("|$$|");

							Redraw = false;    
							LoadSearchXml(arrXml[0]); 
							Redraw = true; 
							WaitImageVisible = false;	

							ColBackColor("t3sheet1_vsl_slan_nm") = HeadBackColor;
							ColFontColor("t3sheet1_vsl_slan_nm") = HeadFontColor;
							CellFont("FontBold", HeaderRows, "t3sheet1_vsl_slan_nm", RowCount, "t3sheet1_vsl_slan_nm") = true;
						}
						mPreSearCond = formObj.slan_cd.value;
					}
				}
				break;
			case IBSAVE:
				formObj.f_cmd.value = MULTI;
				var sParam = ComGetSaveString(sheetObjects);
				if (sParam == "") return;
				
				if(sParam.indexOf("t3sheet1_") > -1 && (sheetObjects[8].RowCount("I") > 0 || sheetObjects[8].RowCount("U") > 0)){
					for(var idxRow = sheetObjects[8].HeaderRows; idxRow <= sheetObjects[8].RowCount; idxRow++){
						//RowStatus가 입력이나 수정의 상태면. 값  100 체크
						if(
							(sheetObjects[8].RowStatus(idxRow) == "I" || sheetObjects[8].RowStatus(idxRow) == "U") &&
							sheetObjects[8].CellValue(idxRow, "t3sheet1_rfuel_rto_tot") != 100
						){
							ComShowCodeMessage("VSK50024");
							return;
						}
					}
					
				}

				sParam +=  "&" + FormQueryString(formObj);
				
				var sXml = sheetObjects[4].GetSaveXml("VOP_VSK_0510GS.do", sParam);
				var arrXml = OpfDeleteData(sXml);
				

				if(arrXml[1] != null){
					sheetObjects[7].Redraw = false;    
					sheetObjects[7].WaitImageVisible = false;	
					sheetObjects[7].LoadSearchXml(arrXml[1]); 
					sheetObjects[7].Redraw = true; 
					
					var arrPrefix = new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
					for(var cnt = 0; cnt < 3; cnt++){	//각 쉬트들 마다 삽입된 Row를 찾아라
						
						with(sheetObjects[cnt + 4]){
							//Insert된 행이 있는지...
							if(RowCount("I") > 0){
								for(var editRow = HeaderRows; editRow <= RowCount; editRow++){
									if(RowStatus(editRow) == "I"){
										var checkValue = CellValue(editRow, arrPrefix[cnt] + "usr_nm");
										var checkValue2 = CellValue(editRow, arrPrefix[cnt] + "lane_pic_tp_cd");
										var checkValue3 = CellValue(editRow, arrPrefix[cnt] + "slan_cd");
										//저장한 이후 조회된만약 같으면..
										for(var checkRow = sheetObjects[7].HeaderRows; checkRow <= sheetObjects[7].RowCount; checkRow++){
											if(checkValue == sheetObjects[7].CellValue(checkRow, "usr_nm") && 
												checkValue2 == sheetObjects[7].CellValue(checkRow, "lane_pic_tp_cd") &&
												checkValue3 == sheetObjects[7].CellValue(checkRow, "slan_cd")){
												CellValue(editRow, arrPrefix[cnt] + "lane_pic_seq") = sheetObjects[7].CellValue(checkRow, "lane_pic_seq");
												break;		//같은 Row 조회를 탈출.
											}	//	End if	같은 조회조건이 있을시에.
										}	// End For	같은 Row가 있는 지의 Roof
									}	//	End if 삽입행의 여부
								}	//	End Roof 삽입행의 루프
							}	//	End if 해당시트가 삽입된 행이 있는지
						}	//	End with 
					}	//	End for Lane - PIC 저장Insert.
					
					//작업을 다했으니깐 지워라...
					sheetObjects[7].RemoveAll();
				}	//	End	if Inser행이 있는지 여부.
				
				//저장할때는 메시지 한번 보여주고.
				sheetObjects[4].LoadSaveXml(arrXml[0]);

				//그 이후에는 메세지 삭제합니다. 계속 메세지를 보여줄수 없으니깐.
				arrXml[0] = ComDeleteMsg(arrXml[0]);
				sheetObjects[5].LoadSaveXml(arrXml[0]);
				sheetObjects[6].LoadSaveXml(arrXml[0]);
				sheetObjects[8].LoadSaveXml(arrXml[0]);
				
				break;
				
		}
	}

	function t1sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t1sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t1sheet1_upd_usr_id");
	}

	function t1sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t1sheet2_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t1sheet2_upd_usr_id");
	}

	function t1sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t1sheet3_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t1sheet3_upd_usr_id");
	}

	function t1sheet4_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t1sheet4_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t1sheet4_upd_usr_id");
	}

	function t2sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t2sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t2sheet1_upd_usr_id");
	}

	function t2sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t2sheet2_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t2sheet2_upd_usr_id");
	}

	function t2sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t2sheet3_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t2sheet3_upd_usr_id");
	}

	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t2sheet1_slan_cd" && mCheckValue){
			if(sheetObj.CellValue(OldRow, "t2sheet1_slan_cd").length < 3 && sheetObj.CellValue(OldRow, "t2sheet1_slan_cd").length > 0){
				ComShowCodeMessage("VSK50010", OldRow, "Lane");
				sheetObj.SelectCell(OldRow, "t2sheet1_slan_cd", true);
			}else{
				mEditRow = OldRow;
				mEditSheet = 4;
				mPrefix = "t2sheet1_";
				//sheetObjects[9].DoSearch("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet1_slan_cd"));

				document.form.f_cmd.value = SEARCH03;
				var sXml =  sheetObjects[9].GetSearchXml("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet1_slan_cd"));
				
				var arrCombo = ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");

				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.CellValue(OldRow, OldCol) = "";
					sheetObj.SelectCell(OldRow, OldCol, true);
				}

			}
		}
	}

	function t2sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd"){
			mCheckValue = true;
		}
	}

	function t2sheet2_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t2sheet2_slan_cd" && mCheckValue){
			if(sheetObj.CellValue(OldRow, "t2sheet2_slan_cd").length < 3 && sheetObj.CellValue(OldRow, "t2sheet2_slan_cd").length > 0){
				ComShowCodeMessage("VSK50010", OldRow, "Lane");
				sheetObj.SelectCell(OldRow, "t2sheet2_slan_cd", true);
			}else{
				document.form.f_cmd.value = SEARCH03;
				mEditRow = OldRow;
				mEditSheet = 5;
				mPrefix = "t2sheet2_";
				//sheetObjects[9].DoSearch("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet2_slan_cd"));

				document.form.f_cmd.value = SEARCH03;
				var sXml =  sheetObjects[9].GetSearchXml("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet2_slan_cd"));
				
				var arrCombo = ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");

				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.CellValue(OldRow, OldCol) = "";
					sheetObj.SelectCell(OldRow, OldCol, true);
				}
			}
		}
	}

	function t2sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd"){
			mCheckValue = true;
		}
	}

	function t2sheet3_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t2sheet3_slan_cd" && mCheckValue){
			if(sheetObj.CellValue(OldRow, "t2sheet3_slan_cd").length < 3 && sheetObj.CellValue(OldRow, "t2sheet3_slan_cd").length > 0){
				ComShowCodeMessage("VSK50010", OldRow, "Lane");
				sheetObj.SelectCell(OldRow, "t2sheet3_slan_cd", true);
			}else{
				document.form.f_cmd.value = SEARCH03;
				mEditRow = OldRow;
				mEditSheet = 6;
				mPrefix = "t2sheet3_";
				//sheetObjects[9].DoSearch("VOP_VSK_VOSIGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet3_slan_cd"));

				document.form.f_cmd.value = SEARCH03;
				var sXml =  sheetObjects[9].GetSearchXml("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + sheetObj.CellValue(OldRow, "t2sheet3_slan_cd"));
				
				var arrCombo = ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");

				if(arrCombo == null){
					ComShowCodeMessage('COM12114', 'Lane');
					sheetObj.CellValue(OldRow, OldCol) = "";
					sheetObj.SelectCell(OldRow, OldCol, true);
				}
			}
		}
	}

	function t2sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue = true;
	}

	var checkyDcDFlg1 = false;  //Tmml Code 체크 플러그        
	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "t4sheet1_vsl_slan_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(Row, "t4sheet1_vsl_slan_cd", true);
			}
		}
	}
	
	function t3sheet1_OnChange(sheetObj, Row, Col, Value) {
		var prefix = "t3sheet1_";
		if(Col > sheetObj.SaveNameCol(prefix + "vsl_slan_cd")){
			with(sheetObj){
				//
				var totRfuel = 0;
				for(var idxCol = parseInt(SaveNameCol(prefix + "vsl_slan_cd")) + 1; 
						idxCol < SaveNameCol(prefix + "rfuel_rto_tot"); ++idxCol){
					if(CellValue(Row, idxCol) != "")
						totRfuel += parseInt(CellValue(Row, idxCol));
				}

				//100이면 지색깔로 아니면 엉뚱한 색상으로..
				if(totRfuel == 100)
					CellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot")) = UnEditableColor;
				else if(totRfuel < 100)
					CellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot")) = RgbColor(255, 125, 125);
				else
					CellBackColor(Row, SaveNameCol(prefix + "rfuel_rto_tot")) = RgbColor(125, 125, 255);
				
				CellValue(Row, prefix + "rfuel_rto_tot") = totRfuel;
			}
		}else if(sheetObj.ColSaveName(Col) == prefix + "vsl_slan_cd"){
			// Port 중복체크
			var idxDub = sheetObj.ColValueDup(prefix + "vsl_slan_cd");
			if(idxDub > -1){
				ComShowCodeMessage("VSK50303", "Lane", idxDub-1);
				sheetObj.SelectCell(Row, Col);
				return ;
			}
			checkyDcDFlg1 = false;

			//유효 TMNL Code 체크
			var sCode = sheetObj.GetComboInfo(Row, Col, "Code");
			var arrCode = sCode.split("|");

			for(var i=0 ; i<arrCode.length ; i++){
				if(arrCode[i] == Value ){
					checkyDcDFlg1 = true;
				}
			}

			//유효 TMNL Code 없을 경우 TMNL Code 이동
			if(!checkyDcDFlg1){
				//7자리 체크 및 유효 TMNL Code 체크 
				if(sheetObj.CellValue(Row, prefix + "vsl_slan_cd") != "" ){
					if(sheetObj.CellValue(Row, prefix + "vsl_slan_cd").length < 3){
						ComShowCodeMessage("VSK50027");
					}else{
						ComShowCodeMessage("VSK50028");
					}
				}
				sheetObj.CellValue(Row, prefix + "vsl_slan_cd") = "";
				sheetObj.SelectCell(Row, prefix + "vsl_slan_cd", true);
			}
		}
	}

	function t3sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol) {
		if(sheetObj.ColSaveName(OldCol) == "t3sheet1_vsl_slan_cd"){
			if(!checkyDcDFlg1){
				sheetObj.SelectCell(NewRow, "t3sheet1_vsl_slan_cd", true);
			}
		}
	}

	function t2sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet1_slan_cd"){
			mEditSheet = 4;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd"){
			mEditSheet = 5;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd"){
			mEditSheet = 6;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 460, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}

	function setLaneInfoOperation(aryPopupData, Row, Col, sheetIdx){
		mCheckValue = false;
		sheetObjects[mEditSheet].CellValue2(Row,Col) = aryPopupData[0][3];
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount < 1){
			if(mEditRow > 0){
				ComShowCodeMessage('COM12114','Lane');
				sheetObjects[mEditSheet].SelectCell(sheetObjects[mEditSheet].SelectRow, mPrefix +  "slan_cd");
			}else{
				ComShowCodeMessage('COM12114','Lane');
				ComAlertFocus(document.form.slan_cd, "");
			}
		}
	}

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(formObj,sAction){

        return true;
    }

	function OpfDeleteData(sXml){
		var arrXmlData = new Array("", "");

		if(sXml.indexOf("<DATA") > -1) {
			var start = sXml.indexOf('<DATA');
			var end = sXml.indexOf('</DATA>');
			arrXmlData[0] = sXml.substring(0,start) + sXml.substring(end + 8);
			arrXmlData[1] = "<SHEET>" + sXml.substring(start, end + 7) + "</SHEET>";
		}else{
			arrXmlData[0] = sXml;
			arrXmlData[1] = null;
		}

		return arrXmlData;
	}

	function slan_cd_onkeypress(){
		ComKeyOnlyAlphabet('uppernum');
		if((document.form.slan_cd.value == "" || document.form.slan_cd.value.length == 3) && event.keyCode == 13){
			doActionIBSheet(beforetab, document.form, IBSEARCH);
		}
	}
	function slan_cd_onkeyup(){
		if(document.form.slan_cd.value.length == 3){
			document.form.f_cmd.value = SEARCH03;
			mEditRow = 0;
			
			var sXml =  sheetObjects[9].GetSearchXml("VOP_VSK_VOSIGS.do", FormQueryString(document.form)  + "&vsl_slan_cd=" + document.form.slan_cd.value);
			
			var arrCombo = ComXml2ComboString(sXml, "vsl_slan_cd", "ofc_cd");

			if(arrCombo == null){
				ComShowCodeMessage('COM12114', 'Lane');
				document.form.slan_cd.value = "";
				document.form.slan_cd.focus();
			}
		}
	}

	function jointSheet2Excel(){
		sheetObjects[6].WaitImageVisible = true;
		for(var cnt = 0; cnt < marrPicTpNm.length; cnt++){
			with(sheetObjects[cnt + 4]){
				if(RowCount > 0){
					var insRow = sheetObjects[7].DataInsert(-1);
					sheetObjects[7].CellValue(insRow, "usr_nm") = "  " + marrPicTpNm[cnt];
					sheetObjects[7].SetMergeCell(insRow, sheetObjects[7].SaveNameCol("rgn_shp_opr_cd"), 1, sheetObjects[7].LastCol - 3);
					for(var idxRow = HeaderRows; idxRow <= RowCount; idxRow++){
						var insRow = sheetObjects[7].DataInsert(-1);
						
						for(var idxCol = 2; idxCol <= LastCol; idxCol++){
							sheetObjects[7].CellValue(insRow, idxCol) = CellValue(idxRow, idxCol);
						}
					}
				}
			}
		}

		if(sheetObjects[7].RowCount > 0){
			sheetObjects[7].Down2Excel(1, false, false, true, "", "", false, false, "",
									false, "del_chk|lane_pic_tp_cd|lane_pic_seq|upd_usr_id|upd_dt", 
									"", false, false, "") ;
			sheetObjects[7].RemoveAll();
		}
		sheetObjects[6].WaitImageVisible = false;
	}

	function clearFormNData(){
		for(var cnt = 0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.form.slan_cd.value = "";
		document.form.upd_dt_view.value = "";
		document.form.upd_id_view.value = "";
	}

	function clearSheet(){
		for(var cnt = 4; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.form.upd_dt_view.value = "";
		document.form.upd_id_view.value = "";
	}
	function moveFocus(nItem){
		switch(nItem){
			case 0:
				//ComAlertFocus(document.form.vskd_flet_grp_cd, "");
				ComAlertFocus(document.form.slan_cd, "");
				break;
			case 1:
				ComAlertFocus(document.form.slan_cd, "");
				//document.form.por_rhq.Code = "%";
				break;
			case 2:
				ComAlertFocus(document.form.slan_cd, "");
				//document.form.por_rhq.Code = "%";
				break;
		}
	}
	
	/**
	 * IBSheet Popup Event
	 */
	function t2sheet2_OnPopupClick(sheetObj,Row,Col){
		var prefix = "t2sheet2_";

		switch (sheetObj.ColSaveName(Col)) {
		case prefix + "pic_crr_desc" :
			var sUrl = "/hanjin/COM_ENS_0N1.do?";
			ComOpenPopup(sUrl, 500, 450, "setCarrier", "1,0,1,1,1,1", false, false, Row, Col, 0);
			break;
		}
	}
	 
	/**
	 * carrier(pic_vsl_desc) 입력부분.<br>
	 * @param {arry} aryPopupData   sheetObjects[0]  sheetIdx
	 */
	function setCarrier(aryPopupData, Row, Col){
		sheetObjects[5].CellValue2(Row,Col) = aryPopupData[0][3];
	}
	
	function t2sheet2_OnChange(sheetObj, Row, Col, Value) {
		var prefix = "t2sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "pic_crr_desc"){
			with(sheetObj){
				if(CellValue(Row, Col) == ""){
					return;
				}
				else if(CellValue(Row, Col).length != 3){
					ComShowCodeMessage('VSK50029');
					CellValue(Row, Col) = "";
					sheetObj.SelectCell(Row, Col, true);
				}else{
					ComOpenWait(true);
					var sXml = sheetObj.GetSearchXml("VOP_VSK_0510GS.do", "crr_cd="+CellValue(Row, Col)+"&f_cmd="+SEARCH05);
					ComOpenWait(false);
					
					var crr_cd = ComGetEtcData(sXml, "crr_cd");
					if(crr_cd==null){
						ComShowCodeMessage('VSK00021', CellValue(Row, Col));
						CellValue(Row, Col) = "";
						sheetObj.SelectCell(Row, Col, true);
					}
				}
			}
		}
	}
	 
	/* 개발자 작업  끝 */