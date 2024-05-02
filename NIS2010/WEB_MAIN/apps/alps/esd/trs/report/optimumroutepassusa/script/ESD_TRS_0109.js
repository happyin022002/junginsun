/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0109.js
*@FileTitle : Optimum Route Pass Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-17
*@LastModifier : 조인영
*@LastVersion : 1.0
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
     * @class ESD_TRS_0109 : esd_trs_0109 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_trs_0109() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }

// 공통전역변수
var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0; 

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0];
		 var sheetObject2 = sheetObjects[1];
         
         /*******************************************************/
         var formObject = document.form;
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
						break;

					case "btn_down_excel":
						sheetObject1.SpeedDown2Excel(-1);
						break;

					case "btn_bkg":
						if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
							var iCheckRow = sheetObject1.CheckedRows("sheet1_del_chk");
							if(iCheckRow <= 0){
								ComShowCodeMessage("COM12176");
								return false;
							}else{
					    		make_detail_info(sheetObject1);
					    		formObject.f_cmd.value = "";
								var myOption = "width=1024,height=640,menubar=0,status=0,scrollbars=0,resizable=1";
					    		ComPostOpenWindow("/hanjin/ESD_TRS_0110.do", "ESD_TRS_0110", myOption);	
							}
						}else{
							ComShowCodeMessage("COM12176");
						}
						break;
						
					case "btn_close":
						window.close();
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

	function getSheet2Search(){
		var formObj = document.form;
		doActionIBSheet(sheetObjects[1],formObj,IBSEARCH);
	}

	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		
		if(sheetObj.RowCount > 0){
    		sheetObjects[1].SpeedDown2Excel(-1);
		}
		ComOpenWait(false);
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
     * Combo Object를 배열로 등록
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

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }
		
		var sheetObject1 = sheetObjects[0];
		var formObject = document.form;
		
    }
     
    function sheet1_OnLoadFinish(sheetObj){
        var formObj = document.form;
    	doActionIBSheet(sheetObj,formObj,IBSEARCH);
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */
	function initCombo(comboObj, comboNo) {
		var i=0;
		//가져온 행을 배열로 반든다.
		
		var arrText = dscr_rsn_cdText.split("|");
		var arrCode = dscr_rsn_cdCode.split("|");
		var dscrRsnMap = document.form.dscr_rsn_map.value;
		
   	    switch(comboObj.id) {
			case "optm_rout_pass_flg":
				with(comboObj) {
					var bMatchFlg = false;
					var bUnMatchFlg = false;
					for (j=0; j<arrCode.length; j++){
						var regData = new RegExp(arrCode[j],"g");
						if (regData.test(dscrRsnMap)==true) {
							if (arrCode[j] == 'M'){
								bMatchFlg = true;
							} else {
								bUnMatchFlg = true;
							}
						}
					}
					
					comboObj.DropHeight=100;
					comboObj.MultiSelect = true;
					InsertItem(i++,  "ALL", "A");
					if(bMatchFlg) {
						InsertItem(i++,  "YES", "Y");
					}
					if(bUnMatchFlg) {
						InsertItem(i++,  "NO",  "N");
					}
					comboObj.Text = "ALL";
	        	}
				break;  

			case "dscr_rsn_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "ALL",  "A");
					for (j=0; j<arrCode.length; j++){
						
						var regData = new RegExp(arrCode[j],"g");
						if (regData.test(dscrRsnMap)==true) {
						
							if (j==arrCode.length-1){
								InsertItem(i++,  ' ',  arrCode[j]);
							} else {
								InsertItem(i++,  arrText[j],  arrCode[j]);
							}
						}
					}
					comboObj.Text = "ALL";
	        	}
				break;
		}
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
            case "sheet1":
                with (sheetObj) {
					// 높이 설정
                    style.height = 446;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag|All|Seq.|Optimum\nRoute Pass|W/O Issue\nOFC|Discrepancy\nReason|Inland Route|Inland Route|POD/DEL Full Name|BKG No.|BKG Term|BKG CNTR QTY|Total No. of S/O|BND";
					HeadTitle1 += "|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Door Info|Door Info|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG";
					HeadTitle1 += "|BKG Route|BKG Route|BKG Route|BKG Route|Shipper|Consignee|qry_ofc_cd";

					var HeadTitle2 = "Flag|All|Seq.|Optimum\nRoute Pass|W/O Issue\nOFC|Discrepancy\nReason|Fm/To|Door|POD/DEL Full Name|BKG No.|BKG Term|BKG CNTR QTY|Total No. of S/O|BND";
					HeadTitle2 += "|Transmode|Rail Origin|Rail Dest|Truck From|Truck To|Door|Factory Name|ZIP Code|Transmode|Rail Origin|Rail Dest|Truck From|Truck To|Door";
					HeadTitle2 += "|POR|POL|POD|DEL|Shipper|Consignee|qry_ofc_cd";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,30,daCenter,false,prefix+"ibflag");
	                InitDataProperty(0, cnt++, dtDummyCheck, 	30, daCenter,	true,	prefix+"del_chk",		false, "", dfNone, 0, true,	true);
					InitDataProperty(0, cnt++, dtDataSeq, 	50,	daCenter,	true,	prefix+"",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"optimum_pass_yn",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	130,daLeft,		true,	prefix+"so_dscr_rsn_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"rout_org_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"rout_dest_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	150,	daLeft,	true,	prefix+"por_del_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"bkg_trem",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_cntr_qty",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	90,	daCenter,	true,	prefix+"act_cntr_qty",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"trsp_crr_mod_ctnt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"rail_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"rail_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daCenter,	true,	prefix+"fctry_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_pst_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"irg_trsp_crr_mod_ctnt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_rail_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,daCenter,		true,	prefix+"irg_rail_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"por_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pol_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"del_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"ship_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"cnee_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,4000,	daCenter,	true,	prefix+"qry_ofc_cd", 	false, "", dfNone, 0, false, false);
					CountFormat = "[ SELECTDATAROW / TOTALROWS ]";
	            	}
				break;

            case "sheet2":
                with (sheetObj) {
					// 높이 설정
                    style.height = 446;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   	//전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "Flag|Seq.|Optimum\nRoute Pass|W/O Issue\nOFC|Discrepancy\nReason|Inland Route|Inland Route|POD/DEL Full Name|BKG No.|BKG Term|BKG CNTR QTY|Total No. of S/O|BND";
					HeadTitle1 += "|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Total W/O Route|Door Info|Door Info|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG";
					HeadTitle1 += "|BKG Route|BKG Route|BKG Route|BKG Route|Shipper|Consignee";

					var HeadTitle2 = "Flag|Seq.|Optimum\nRoute Pass|W/O Issue\nOFC|Discrepancy\nReason|Fm/To|Door|POD/DEL Full Name|BKG No.|BKG Term|BKG CNTR QTY|Total No. of S/O|BND";
					HeadTitle2 += "|Transmode|Rail Origin|Rail Dest|Truck From|Truck To|Door|Factory Name|ZIP Code|Transmode|Rail Origin|Rail Dest|Truck From|Truck To|Door";
					HeadTitle2 += "|POR|POL|POD|DEL|Shipper|Consignee";

					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(false, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

                    var prefix="sheet1_";
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, dtHiddenStatus,30,daCenter,false,prefix+"ibflag");
					InitDataProperty(0, cnt++, dtDataSeq, 	50,	daCenter,	true,	prefix+"",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"optimum_pass_yn",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	130,daLeft,		true,	prefix+"so_dscr_rsn_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"rout_org_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"rout_dest_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	150,	daLeft,	true,	prefix+"por_del_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"bkg_trem",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_cntr_qty",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	90,	daCenter,	true,	prefix+"act_cntr_qty",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"trsp_crr_mod_ctnt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"rail_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"rail_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	100,	daCenter,	true,	prefix+"fctry_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"dor_pst_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"irg_trsp_crr_mod_ctnt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_rail_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,daCenter,		true,	prefix+"irg_rail_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"irg_dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"por_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pol_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"del_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"ship_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"cnee_nm",	false, "", dfNone, 0, false, false);
				}
				break;
        }
    }

	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		var formObj = document.form;
		var sName = sheetObj.ColSaveName(Col);
		
		if (sName == "sheet1_cnt_cd"){
			ComOpenPopup('/hanjin/COM_ENS_0M1.do', 565, 480, 'getGridCountry', "1,0,1,1,1,1,1,1,1,1,1,1", true);
		}
	}

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				//if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					var arr = new Array("sheet1_", "");
		        	var sParam = FormQueryString(formObj)+ "&" + ComGetPrefixParam(arr);
					var sXml = sheetObj.GetSearchXml("ESD_TRS_0109GS.do", sParam);
					if(sXml.length>0){
						sheetObj.LoadSearchXml(sXml);
					}
				//}	
				break;
        }
    }
	
	/**
     * Get Object Value
     */
    function getObjValue(name) {
    	return ComGetObjValue(eval("document.form."+name));
    }
    
    /**
     * Set Object Value
     */
    function setObjValue(name, value) {
    	ComSetObjValue(eval("document.form."+name), value);
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {

		}
        return true;
    }

	function dscr_rsn_cd_OnCheckClick(comboObj, index, code) {
		if( code == "A" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "A";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "A";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
		
		if( code == "A" ){
			var matchCheck = false;
			var unmatchCheck = false;
			for (var i = 0; i < comboObj.GetCount(); i ++) {
				if(comboObj.GetIndexText(i,0) != 'ALL' && comboObj.GetIndexText(i,0) != '-') {
					matchCheck = true;
				} else if (comboObj.GetIndexText(i,0) != 'ALL') {
					unmatchCheck = true;
				}
			}
			if(matchCheck == true && unmatchCheck == true) {
				initComboSub(comboObjects[0], 'ALL');
			}
		} else {
			var matchCheck = comboObj.CheckCode("M");
			var unmatchCheck = false;
			for (var i = 0; i < comboObj.GetCount(); i ++) {
				if(comboObj.GetIndexText(i,0) != 'ALL' && comboObj.GetIndexText(i,0) != '-'
					&& comboObj.CheckIndex(i)) {
					unmatchCheck = true;
					break;
				}
			}
			
			if (matchCheck == true && unmatchCheck == true) {
				initComboSub(comboObjects[0], 'ALL');
			}else if(matchCheck == true) {
				initComboSub(comboObjects[0], 'YES');
			} else {
				initComboSub(comboObjects[0], 'NO');
			}
		}
	}

	function optm_rout_pass_flg_OnCheckClick(comboObj, index, code) {
		if( code == "A" ){
			if( comboObj.CheckCode("A") == false ){
				comboObj.Code = "A";
				comboObj.CheckCode("A") = false;
			} else{
				comboObj.Code = "A";
				comboObj.CheckIndex(0) = true;
			}
			initComboSub(comboObjects[0], 'ALL');
			initComboSub(comboObjects[1], 'ALL');
		} else if(code == "Y") {
			if( comboObj.CheckCode("Y") == false ){
				comboObj.Code = "Y";
				comboObj.CheckCode("Y") = false;
			} else{
				comboObj.Code = "Y";
				comboObj.CheckCode("Y") = true;
			}
			initComboSub(comboObjects[1], 'YES');
		} else {
			if( comboObj.CheckCode("N") == false ){
				comboObj.Code = "N";
				comboObj.CheckCode("N") = false;
			} else{
				comboObj.Code = "N";
				comboObj.CheckCode("N") = true;
			}
			initComboSub(comboObjects[1], 'NO');
		}
	}

	function initComboSub(comboObj, mode) {
		var i=0;
		//가져온 행을 배열로 반든다.
		
		var arrText = dscr_rsn_cdText.split("|");
		var arrCode = dscr_rsn_cdCode.split("|");
		var dscrRsnMap = document.form.dscr_rsn_map.value;
		
   	    switch(comboObj.id) {
			case "optm_rout_pass_flg":
				comboObj.removeAll();
				with(comboObj) {
					var bMatchFlg = false;
					var bUnMatchFlg = false;
					for (j=0; j<arrCode.length; j++){
						var regData = new RegExp(arrCode[j],"g");
						if (regData.test(dscrRsnMap)==true) {
							if (arrCode[j] == 'M'){
								bMatchFlg = true;
							} else {
								bUnMatchFlg = true;
							}
						}
					}

					comboObj.DropHeight=100;
					InsertItem(i++,  "ALL", "A");
					if((mode == 'YES' || mode == 'ALL') && bMatchFlg == true) {
						InsertItem(i++,  "YES", "Y");
					}
					if((mode == 'NO' || mode == 'ALL') && bUnMatchFlg == true) {
						InsertItem(i++,  "NO",  "N");
					}
					comboObj.Text = mode;
	        	}
				break;  

			case "dscr_rsn_cd":
				with(comboObj) {
					comboObj.removeAll();
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "ALL",  "A");
					for (j=0; j<arrCode.length; j++){
						
						var regData = new RegExp(arrCode[j],"g");
						if (regData.test(dscrRsnMap)==true) {
							if (j==arrCode.length-1){
								if(mode == 'YES' || mode == 'ALL') {
									InsertItem(i++,  ' ',  arrCode[j]);
								}
							} else {
								if(mode == 'NO' || mode == 'ALL') {
									InsertItem(i++,  arrText[j],  arrCode[j]);
								}
							}
						}
					}
					comboObj.Code = "A";
	        	}
				break;
		}
   	}
	
	 /**
	 * make_detail_info :: detail에 전달할 정보를 생성하는 Event
	 */
	function make_detail_info(sheetObj) {
		var formObj = document.form;
		
		with(sheetObj) {
			var vDelCheck = FindCheckedRow("sheet1_del_chk").split("|");
			var vOfcCd = "";
			var vBndCd = "";
			var vComma = "";
			var vBkgNo = "";

			for(var i=0; i<vDelCheck.length; i++) {
				if(vDelCheck[i] != "") {
					if(i!=0){ vComma = "#"; };
					vBndCd += vComma + CellValue(vDelCheck[i], "sheet1_trsp_bnd_cd"); 
					vOfcCd += vComma + CellValue(vDelCheck[i], "sheet1_qry_ofc_cd");
					vBkgNo += vComma + CellValue(vDelCheck[i], "sheet1_bkg_no");
				}
			}

            ComSetObjValue(formObj.input_office, vOfcCd);
			ComSetObjValue(formObj.bnd_cd, vBndCd);
			ComSetObjValue(formObj.bkg_no, vBkgNo);
			ComSetObjValue(formObj.sel_op_tp, "MULTI"); // multi row select and go detail
		}
	}
	
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if(sheetObj.RowCount > 0) {
			for(var i = 2; i < sheetObj.RowCount+2; i++) {
				if( sheetObj.CellValue(i, "sheet1_optimum_pass_yn") == "NO" ) {
					if( sheetObj.CellValue(i, "sheet1_trsp_crr_mod_ctnt") != sheetObj.CellValue(i, "sheet1_irg_trsp_crr_mod_ctnt") ) {
						sheetObj.CellBackColor(i, "sheet1_trsp_crr_mod_ctnt") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_trsp_crr_mod_ctnt") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_rail_fm_nod_cd").substring(1,5) != sheetObj.CellValue(i, "sheet1_irg_rail_fm_nod_cd").substring(1,5) ) {
						sheetObj.CellBackColor(i, "sheet1_rail_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_rail_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_rail_to_nod_cd").substring(1,5) != sheetObj.CellValue(i, "sheet1_irg_rail_to_nod_cd").substring(1,5) ) {
						sheetObj.CellBackColor(i, "sheet1_rail_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_rail_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_fm_nod_cd").substring(1,5) != sheetObj.CellValue(i, "sheet1_irg_fm_nod_cd").substring(1,5) ) {
						sheetObj.CellBackColor(i, "sheet1_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_to_nod_cd").substring(1,5) != sheetObj.CellValue(i, "sheet1_irg_to_nod_cd").substring(1,5) ) {
						sheetObj.CellBackColor(i, "sheet1_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_dor_nod_cd") != sheetObj.CellValue(i, "sheet1_irg_dor_nod_cd") ) {
						sheetObj.CellBackColor(i, "sheet1_dor_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						sheetObj.CellBackColor(i, "sheet1_irg_dor_nod_cd") = sheetObj.RgbColor(134, 229, 127);
					}
					if( sheetObj.CellValue(i, "sheet1_so_dscr_rsn_cd") == "Dest Change" || sheetObj.CellValue(i, "sheet1_so_dscr_rsn_cd") == "Origin Change" ) {
						if( sheetObj.CellValue(i, "sheet1_dor_nod_cd") == "" ) {
							if( sheetObj.CellValue(i, "sheet1_trsp_bnd_cd") == "I" ) {
								if( sheetObj.CellValue(i, "sheet1_trsp_crr_mod_ctnt").search("R") > -1 ) {
									sheetObj.CellBackColor(i, "sheet1_rail_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
								} else {
									sheetObj.CellBackColor(i, "sheet1_to_nod_cd") = sheetObj.RgbColor(134, 229, 127);
								}
							} else {
								if( sheetObj.CellValue(i, "sheet1_trsp_crr_mod_ctnt").search("R") > -1 ) {
									sheetObj.CellBackColor(i, "sheet1_rail_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
								} else {
									sheetObj.CellBackColor(i, "sheet1_fm_nod_cd") = sheetObj.RgbColor(134, 229, 127);
								}
							}
						} else {
							sheetObj.CellBackColor(i, "sheet1_dor_nod_cd") = sheetObj.RgbColor(134, 229, 127);
						}
					}
				}
			}
		}
	}

	/* 개발자 작업  끝 */