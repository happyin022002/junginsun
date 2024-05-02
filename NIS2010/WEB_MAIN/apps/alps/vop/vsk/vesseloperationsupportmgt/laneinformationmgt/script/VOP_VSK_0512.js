/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0010.js
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.29
*@LastModifier : 유재민
*@LastVersion : 1.0
* 2009.06.16 장석현
* 1.0 Creation
* 
* History
* 2011.04.29 유재민 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건
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
var marrTabTitle = new Array("Lane Group", "Status", "PIC", "Bunkering Port");

var marrPicTpCd = new Array("I", "J", "S");
var marrPicTpNm = new Array("Independence Operation Lane", "Joint Operation Lane", "Special Cargo Authorization Part");
var mCheckValue = false;
var mEditRow = 0;
var mEditSheet = 0;
var mPrefix = "";

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
         var sheetObject11 = sheetObjects[10];         
         var sheetObject12 = sheetObjects[11];         

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
							
							break;
						
						case "ComOpenPopupWithTarget":
							if( objs[0].style.display != "inline" ){
								ComOpenPopupWithTarget('/hanjin/COM_ENS_081.do', 830, 460, "col1:slan_cd", "0,0,1,1,1,1,1", true);
							}
							break;

						case "btn_DownExcel":
								if(beforetab == 1){
									jointSheet2ExcelStatus();
								}else if(beforetab == 2){
									jointSheet2Excel();
								}else{
									sheetObject11.Down2Excel(1, false, false, true, "", "", false, false, "",
															false, "t3sheet1_del_chk|t3sheet1_upd_usr_id|t3sheet1_upd_dt", 
															"", false, false, "") ;
									
								}
								break;					
								
						case "btn_t1DLGroup":
								ComOpenPopupWithTarget('/hanjin/VOP_VSK_0202.do', 725, 630, "loc_cd:loc_cd", "0,1,1,1,1,1,1", true);
								break;																		

/**		TAB 2		**/
						//Independence Operation Lane
						case "btn_t2insert1":
								var Row = sheetObject5.DataInsert();
								sheetObject5.CellValue(Row, "t2sheet1_slan_cd") = formObject.slan_cd.value;
								sheetObject5.CellValue(Row, "t2sheet1_lane_pic_tp_cd") = marrPicTpCd[0];
								sheetObject5.SelectCell(Row, "t2sheet1_usr_nm", true);
								break; 
								
						case "btn_t2add1":
								var Row = sheetObject5.DataInsert(-1);
								sheetObject5.CellValue(Row, "t2sheet1_slan_cd") = formObject.slan_cd.value;
								sheetObject5.CellValue(Row, "t2sheet1_lane_pic_tp_cd") = marrPicTpCd[0];
								sheetObject5.SelectCell(Row, "t2sheet1_usr_nm", true);
								break;	
								
						case "btn_t2del1":
								ComRowHideDelete(sheetObject1,"t2sheet1_del_chk");
								break;

						//Joint Operation Lane
						case "btn_t2insert2":
								var Row = sheetObject6.DataInsert();
								sheetObject6.CellValue(Row, "t2sheet2_slan_cd") = formObject.slan_cd.value;
								sheetObject6.CellValue(Row, "t2sheet2_lane_pic_tp_cd") = marrPicTpCd[1];
								sheetObject6.SelectCell(Row, "t2sheet2_usr_nm", true);
								break; 
								
						case "btn_t2add2":
								var Row = sheetObject6.DataInsert(-1);
								sheetObject6.CellValue(Row, "t2sheet2_slan_cd") = formObject.slan_cd.value;
								sheetObject6.CellValue(Row, "t2sheet2_lane_pic_tp_cd") = marrPicTpCd[1];
								sheetObject6.SelectCell(Row, "t2sheet2_usr_nm", true);
								break;	
								
						case "btn_t2del2":
								ComRowHideDelete(sheetObject6,"t2sheet2_del_chk");
								break;
																
						//Special Cargo Authorization Part
						case "btn_t2insert3":
								var Row = sheetObject7.DataInsert();
								sheetObject7.CellValue(Row, "t2sheet3_slan_cd") = formObject.slan_cd.value;
								sheetObject7.CellValue(Row, "t2sheet3_lane_pic_tp_cd") = marrPicTpCd[2];
								sheetObject7.SelectCell(Row, "t2sheet3_usr_nm", true);
								break; 
								
						case "btn_t2add3":
								var Row = sheetObject7.DataInsert(-1);
								sheetObject7.CellValue(Row, "t2sheet3_slan_cd") = formObject.slan_cd.value;
								sheetObject7.CellValue(Row, "t2sheet3_lane_pic_tp_cd") = marrPicTpCd[2];
								sheetObject7.SelectCell(Row, "t2sheet3_usr_nm", true);
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

				var HeadTitle1 = "|No|Lane Code|Lane Name|vskd_flet_grp_cd|upd_usr_id|upd_usr_id";

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
		}else if(sheetNo > 7 && sheetNo < 12){
            with (sheetObj) {
				// 높이 설정
				style.height = 102;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = (sheetNo == 11 ? true : false);

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]\
				InitRowInfo(1, 1, 3, 100);

				var HeadTitle1 = ""
				if(sheetNo == 9){
					HeadTitle1 = "|RSO|Name|Lane Code|Lane Code|Carrier| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
				}else{
					HeadTitle1 = "|RSO|Name|Lane Code|Lane Code|Vessel Code| Job Disc.|E-mail Address|E-mail Address|Tel.|Cell Phone|Fax|Remark(s)|lane_pic_tp_cd|lane_pic_tp_seq|upd_usr_id|upd_usr_id";
				}

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "";
				
				if(sheetNo < 11)
					prefix =  "t3sheet" + (parseInt(sheetNo) - 7) + "_";

				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtComboEdit,	60,		daLeft,		true,		prefix + "rgn_shp_opr_cd",		true,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix + "usr_nm",				true,	"",	dfNone,	0,	false,	true);
				InitDataProperty(0, cnt++ , dtPopupEdit,	50,		daCenter,	true,		prefix + "slan_cd",				true,	"",	dfEngUpKey,	0,	false,	true, 4);
				InitDataProperty(0, cnt++ , dtData,			50,		daLeft,		true,		prefix + "lane_mng_usr_desc",	false,	"",	dfNone,	0,	true,	true);
				if(sheetNo == 9){
					InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "pic_crr_desc",		false,	"",	dfNone,	0,	true,	true);
				}else{
					InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "pic_vsl_desc",		false,	"",	dfNone,	0,	true,	true);
				}
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "jb_desc",				false,	"",	dfNone,	0,	true,	true);

				InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,		prefix + "pic_eml",				true,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			60,		daLeft,		true,		prefix + "lane_pic_usr_eml",	false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "pic_phn_no",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "mphn_no",				false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "fax_no",				false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix + "lane_rmk",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix + "lane_pic_tp_cd",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix + "lane_pic_seq",		false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		90,		daCenter,	true,		prefix + "upd_usr_id",			false,	"",	dfNone,	0,	true,	true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		prefix + "upd_dt",				false,	"",	dfNone,	0,	true,	true);
				
				InitDataValid(0, prefix + "slan_cd", vtEngUpOnly);
				CountPosition = 0;
			}
		}else if(sheetObj.id == "t4sheet1"){
			with (sheetObj) {
				// 높이 설정
				style.height = 382;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 15, 100);

				var HeadTitle1 = "|Bunkering Ports|Bunkering Ports" + document.form.bunkerPort.value + "|Total";
						
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 3, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				var prefix = "t4sheet1_";
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,			daCenter,	false,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtData,			70,			daCenter,	true,		prefix + "vsl_slan_nm",		false,		"",					dfNone,		0,		false,		false);
				InitDataProperty(0, cnt++ , dtComboEdit,	60,			daCenter,	false,		prefix + "vsl_slan_cd",		false,		"",					dfEngUpKey,	0,		true,		true);
				
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
				InitDataCombo(0, prefix + "vsl_slan_cd", " " + document.form.laneCd.value,  " " + document.form.laneCd.value);
				CountPosition = 0;
			}
		}else if(sheetObj.id == "t2sheet1"){
			with (sheetObj) {
									// 높이 설정
				style.height = 145;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);

				var HeadTitle1 = "|Service Status|Service Status|Service Status";
				var HeadTitle2 = "|Type|Count|SML VSL SVC";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
									
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "t2sheet1_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	true,		prefix + "hidStatus");
				InitDataProperty(0, cnt++ , dtData,				135,	daLeft,		true,		prefix + "type",		false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,			70,		daCenter,	true,		prefix + "Count",		false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,			110,	daCenter,	true,		prefix + "hjs_vsl_svc",	false,		"",	dfNone,	0,		true,		true);
				
				CountPosition = 0;
				
			}
		}else if(sheetObj.id == "t2sheet2"){
			with (sheetObj) {
				// 높이 설정
				style.height = 145;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = false;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(2, 1, 3, 100);

				var HeadTitle1 = "|Deployed Vessel Status|Deployed Vessel Status";
				var HeadTitle2 = "|Operator|Count";

				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
				
				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				var prefix = "t2sheet2_";
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,		true,		prefix + "hidStatus");
				InitDataProperty(0, cnt++ , dtData,			135,	daCenter,		true,		prefix + "opr",			false,		"",	dfNone,	0,		true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,		110,	daCenter,		true,		prefix + "count",		false,		"",	dfNone,	0,		true,		true);
				
				CountPosition = 0;
			}
		}else if(sheetObj.id == "t2sheet3" || sheetObj.id == "sheet2"){
			with (sheetObj) {
									// 높이 설정
				style.height = 230;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				var prefix = "t2sheet3_";
				if(sheetObj.id == "t2sheet3"){
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 3, 100);

					var HeadTitle1 = "| | |Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|Fleet Information|SVC Opening Date|Port Rotation|Fre.|Remark(s)";
					var HeadTitle2 = "| | |VSL Name|OPT|Size|SML VSL|SML VSL|OTH|TTL|SVC Opening Date|Port Rotation|Fre.|Remark(s)";
					var HeadTitle3 = "|SVC Lane|SVC Lane|VSL Name|OPT|Size|OWN|CHTR|OTH|TTL|SVC Opening Date|Port Rotation|Fre.|Remark(s)";
							
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, true); 
					InitHeadRow(2, HeadTitle3, true);                     
				}else{
					prefix = "sheet2_";
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 3, 100);

					var HeadTitle1 = "|SVC Lane|SVC Lane|VSL Name|OPT|Size|OWN|CHTR|OTH|TTL|SVC Opening Date|Port Rotation|Fre.|Remark(s)";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false)

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
				}

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	40,		daCenter,	true,		prefix + "hidStatus");
				InitDataProperty(0, cnt++ , dtData,			35,		daCenter,	true,		prefix + "grp",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "svc_lane",	false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			180,	daLeft,		true,		prefix + "vsl_nm",		false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "opt",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "vsl_class",	false,		"",					dfNone,		0,		true,		true);
																			  
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix + "own",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix + "cht",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix + "oth",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			40,		daCenter,	true,		prefix + "ttl",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			110,	daCenter,	true,		prefix + "svc_open_dt",	false,		"",					dfDateYmd,	0,		true,		true);
																		
				InitDataProperty(0, cnt++ , dtData,			235,	daLeft,		true,		prefix + "port_rot",	false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "fre",			false,		"",					dfNone,		0,		true,		true);
				InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,		prefix + "remark",		false,		"",					dfNone,		0,		true,		true);
				
				CountPosition = 0;
			}
		}
		
	}	//End function

	function initCombo(comboObj, comboNo) {
		
		switch(comboObj.id) {
			case "vskd_flet_grp_cd":    //R/D Term-post
				var i=0;
				with(comboObj) {
					style.width = 250;

					ComVskXml2ComboItem(sXml, comboObjects[0], "val", "desc");
					comboObjects[0].InsertItem(0, "ALL", "%");
					comboObjects[0].Code = "%";

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
						formObj.f_cmd.value = SEARCH01;

						var arrPrefix = new Array("t2sheet1_", "t2sheet2_", "t2sheet3_");
						var sXml = sheetObjects[4].GetSearchXml("VOP_VSK_0512GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml = sXml.split("|$$|");

						if(arrXml.length > 2){
							for(var cnt = 4; cnt < arrXml.length + 4; cnt++){
								sheetObjects[cnt].Redraw = false;    
								sheetObjects[cnt].WaitImageVisible = false;	
								sheetObjects[cnt].LoadSearchXml(arrXml[cnt - 4]); 
								sheetObjects[cnt].Redraw = true; 
							}

							sheetObjects[sheetObjects.length - 1].LoadSearchXml(ComReplaceStr(arrXml[2], "t2sheet3_", "sheet2_"));
						}

					}else if(tabIdx == 2){
						formObj.f_cmd.value = SEARCH02;
						sheetObjects[7].WaitImageVisible = true;	
						var arrPrefix = new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
						var sXml = sheetObjects[7].GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
						var arrXml = sXml.split("|$$|");

						if(arrXml.length > 2){
							for(var cnt = 7; cnt < arrXml.length + 7; cnt++){
								sheetObjects[cnt].Redraw = false;    
								sheetObjects[cnt].LoadSearchXml(arrXml[cnt - 7]); 
								sheetObjects[cnt].Redraw = true; 
								sheetObjects[cnt].WaitImageVisible = false;	
							}
						}
					}else if(tabIdx == 3){
						with(sheetObjects[11]){
							formObj.f_cmd.value = SEARCH03;
							WaitImageVisible = true;	
							var arrPrefix = new Array("t4sheet1_");
							var sXml = GetSearchXml("VOP_VSK_0510GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
							var arrXml = sXml.split("|$$|");

							Redraw = false;    
							LoadSearchXml(arrXml[0]); 
							Redraw = true; 
							WaitImageVisible = false;	

							ColBackColor("t4sheet1_vsl_slan_nm") = HeadBackColor;
							ColFontColor("t4sheet1_vsl_slan_nm") = HeadFontColor;
							CellFont("FontBold", HeaderRows, "t3sheet1_vsl_slan_nm", RowCount, "t3sheet1_vsl_slan_nm") = true;
						}
					}
				}
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

	function t3sheet1_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t3sheet1_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t3sheet1_upd_usr_id");
	}

	function t3sheet2_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t3sheet2_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t3sheet2_upd_usr_id");
	}

	function t3sheet3_OnClick(sheetObj, Row, Col, Value){
		document.form.upd_dt_view.value = sheetObj.CellValue(Row, "t3sheet3_upd_dt");
		document.form.upd_id_view.value = sheetObj.CellValue(Row, "t3sheet3_upd_usr_id");
	}

	function t2sheet1_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet1_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue = true;
	}

    function t2sheet2_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd" && mCheckValue){
			if(sheetObj.CellValue(Row, "t2sheet2_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SelectCell(Row, "t2sheet2_slan_cd", true);
			}else{
				document.form.f_cmd.value = SEARCH03;
				mEditRow = Row;
				mEditSheet = 5;
				mPrefix = "t2sheet2_";
				sheetObjects[9].DoSearch("VOP_VSK_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(Row, "t2sheet2_slan_cd"));
			}
		}
	}

	function t2sheet2_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet2_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue = true;
	}

    function t2sheet3_OnChange(sheetObj,Row, Col, Value) {
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd" && mCheckValue){
			if(sheetObj.CellValue(Row, "t2sheet3_slan_cd").length < 3){
				ComShowCodeMessage("VSK50010", Row, "Lane");
				sheetObj.SelectCell(Row, "t2sheet3_slan_cd", true);
			}else{
				document.form.f_cmd.value = SEARCH03;
				mEditRow = Row;
				mEditSheet = 6;
				mPrefix = "t2sheet3_";
				sheetObjects[9].DoSearch("VOP_VSK_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheet1_") + "&vsl_slan_cd=" + sheetObj.CellValue(Row, "t2sheet3_slan_cd"));
			}
		}
	}

	function t2sheet3_OnKeyDown(sheetObj, Row, Col, KeyCode, Shift){
		var prefix = "t2sheet3_";
		if(sheetObj.ColSaveName(Col) == prefix + "slan_cd" || sheetObj.ColSaveName(Col) == prefix + "crr_cd")
			mCheckValue = true;
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
		}
	}

	function t2sheet1_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet1_slan_cd"){
			mEditSheet = 4;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet2_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet2_slan_cd"){
			mEditSheet = 5;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
		}
	}
	function t2sheet3_OnPopupClick(sheetObj, Row, Col){
		if(sheetObj.ColSaveName(Col) == "t2sheet3_slan_cd"){
			mEditSheet = 6;
			ComOpenPopup('/hanjin/COM_ENS_081.do', 830, 560, 'setLaneInfoOperation', '0,0,1,1,1,1', false, false, Row, Col, 0);
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
		document.form.f_cmd.value = SEARCH03;
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
		sheetObjects[7].WaitImageVisible = true;
		for(var cnt = 0; cnt < marrPicTpNm.length; cnt++){
			with(sheetObjects[cnt + 7]){
				if(RowCount > 0){
					var insRow = sheetObjects[10].DataInsert(-1);
					sheetObjects[10].CellValue(insRow, "usr_nm") = "  " + marrPicTpNm[cnt];
					sheetObjects[10].SetMergeCell(insRow, sheetObjects[10].SaveNameCol("rgn_shp_opr_cd"), 1, sheetObjects[10].LastCol - 3);
					for(var idxRow = HeaderRows; idxRow <= RowCount; idxRow++){
						var insRow = sheetObjects[10].DataInsert(-1);
						
						for(var idxCol = 1; idxCol <= LastCol; idxCol++){
							sheetObjects[10].CellValue(insRow, idxCol) = CellValue(idxRow, idxCol);
						}
					}
				}
			}
		}

		if(sheetObjects[10].RowCount > 0){
			sheetObjects[10].Down2Excel(1, false, false, true, "", "", false, false, "",
									false, "del_chk|lane_pic_tp_cd|lane_pic_seq|upd_usr_id|upd_dt", 
									"", false, false, "") ;
			sheetObjects[10].RemoveAll();
		}
		sheetObjects[7].WaitImageVisible = false;
	}

	function jointSheet2ExcelStatus(){
		sheetObjects[4].WaitImageVisible = true;
		var isStatStart = 2;
		var ivStatStart = 6;

		var sheetObj = sheetObjects[sheetObjects.length - 1];
		var endRow = sheetObjects[4].RowCount > sheetObjects[5].RowCount ? sheetObjects[4].RowCount : sheetObjects[5].RowCount;

		//미리 테이블에 
		for(var cnt = 0; cnt <= endRow + 4; cnt++){
			sheetObj.DataInsert(0);
		}
		
		//Service Status   기리그...
		for(var idxRow = 0; idxRow <= sheetObjects[4].LastRow; idxRow++){
			for(var idxCol = 1; idxCol <= sheetObjects[4].LastCol; idxCol++){
				sheetObj.CellValue(idxRow + 1, idxCol + isStatStart) = sheetObjects[4].CellValue(idxRow, idxCol);
			}
		}

		//Deployed Vessel Status   기리그...
		for(var idxRow = 0; idxRow <= sheetObjects[5].LastRow; idxRow++){
			for(var idxCol = 1; idxCol <= sheetObjects[5].LastCol; idxCol++){
				sheetObj.CellValue(idxRow + 1, idxCol + ivStatStart) = sheetObjects[5].CellValue(idxRow, idxCol);
			}
		}
		//SML Vessel SVC - Service including SML vessel 헤더 기리고............
		for(var idxHedCol = 1; idxHedCol < sheetObjects[6].LastCol; idxHedCol++){
			sheetObj.CellValue(endRow + 5, idxHedCol) = sheetObjects[6].CellValue(2, idxHedCol);
		}
		
		//이제 머지하고 색깔 칠하자...
		
		//1.1 Service Status Header
		sheetObj.SetMergeCell(1, isStatStart + 1, 1, 3);
		cellHeaderChange(sheetObj, 1, isStatStart + 1);
		for(var cnt = 1; cnt < 4; cnt++){
			cellHeaderChange(sheetObj, 2, isStatStart + cnt);
		}
		
		//1.2 Service Total
		//Total페이지 색깔 칠하기.
		for(var idxRow = 2; idxRow < endRow + 5; idxRow++){
			if(sheetObj.CellValue(idxRow, isStatStart + 1) == "TOTAL"){
				for(var cnt = 1; cnt < 4; cnt++){
					cellTotalChange(sheetObj, idxRow, isStatStart + cnt);
				}
				break;
			}
		}



		//2.1 Service Status Header
		sheetObj.SetMergeCell(1, ivStatStart + 1, 1, 2);
		cellHeaderChange(sheetObj, 1, ivStatStart + 1);
		for(var cnt = 1; cnt < 3; cnt++){
			cellHeaderChange(sheetObj, 2, ivStatStart + cnt);
		}
		
		//2.2 Service Total
		//Total페이지 색깔 칠하기.
		for(var idxRow = 2; idxRow < endRow + 5; idxRow++){
			if(sheetObj.CellValue(idxRow, ivStatStart + 1) == "TOTAL"){
				for(var cnt = 1; cnt < 3; cnt++){
					cellTotalChange(sheetObj, idxRow, ivStatStart + cnt);
				}
				break;
			}
		}

		//3.1 SML Vessel SVC - Service including SML vessel 색깔 칠하기...
		//3.1.1 SVC Lane
		var headStartRow = endRow + 5;
		sheetObj.SetMergeCell(headStartRow, 1, 1, 2);
		cellHeaderChange(sheetObj, headStartRow, 1);
		
		for(var cnt = 3; cnt <= sheetObj.LastCol; cnt++){
			cellHeaderChange(sheetObj, headStartRow, cnt);
		}

		sheetObj.Down2Excel(1, false, false, true, "", "", false, false, "",
								false, "", 
								"0", false, false, "") ;

	}
	
	function cellHeaderChange(sheetObj, headerRow, headerCol){
		sheetObj.CellAlign(headerRow, headerCol) = daCenter;
		sheetObj.CellFont("FontBold",  headerRow, headerCol) = true;
		sheetObj.CellBackColor(headerRow, headerCol) = sheetObj.HeadBackColor;
		sheetObj.CellFontColor(headerRow, headerCol) = sheetObj.HeadFontColor;
	}

	
	function cellTotalChange(sheetObj, totRow, totCol){
		sheetObj.CellAlign(totRow, totCol) = daCenter;
		sheetObj.CellFont("FontBold",  totRow, totCol) = true;
		sheetObj.CellBackColor(totRow, totCol) = sheetObj.SubSumBackColor;
	}
	


	function clearFormNData(){
		for(var cnt = 0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
	}

	function moveFocus(nItem){
		switch(nItem){
			case 0:
				ComAlertFocus(document.form.vskd_flet_grp_cd, "");
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
	
	/* 개발자 작업  끝 */