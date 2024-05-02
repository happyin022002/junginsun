/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0171.js
*@FileTitle : Optimum Route Pass Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------------------------------------------------------
* History
* 2013.04.29 조인영 [CHM-201323843] [SCE] Optimum Route Pass의 조회 조건 및 칼럼 추가
* 2013.07.09 조인영 [CHM-201325044] [TRS] Optimum Route Pass에 Alternative Optimum 관련 보완
* 2013.07.16 조인영 [CHM-201324797] [TRS] Optimum Route Pass의 칼럼 로직 정정 및 Compact 양식 추가
* 2013.09.12 조인영 [CHM-201326228] [TRS] Optimum Route Pass의 Batch Logic 수정 및 Contract 칼럼 추가
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author SM LINE
     */

    /**
     * @extends 
     * @class ESD_SCE_0171 : esd_sce_0171 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_sce_0171() {
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
						if(sheetObject1.SelectRow >= sheetObject1.HeaderRows){
							if( sheetObject1.CellValue(sheetObject1.LastRow, "sheet1_tot_knt") > 2000){
								//ComShowCodeMessage("SCE90059");
								setObjValue("exl_flg", "Y");
						
								ComOpenWait(true, true);
								setTimeout("getSheet2Search()", 100);
							}else{
								setObjValue("exl_flg", "N");
								sheetObject1.SpeedDown2Excel(-1);
							}
						}else{
							ComShowCodeMessage("COM12177");
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
								InsertItem(i++,  '-',  arrCode[j]);
							} else {
								if (arrCode[j] != 'M'){
									InsertItem(i++,  arrText[j],  arrCode[j]);
								}
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

					var HeadTitle1 = "Flag|Seq.|Optimum\nRoute Pass|Pass Type|W/O Issue\nOFC|TRO OFC|Trans\nMode|Discrepancy\nReason|Inland Route|Inland Route|Door Full Name|EQ No.|TP/SZ|BND|Cost\nMode|BKG No.|SC No.|RFA No.|TAA No.|TRO\nSEQ|S/O No.|W/O No.|W/O Issue\nDate|W/O Issue ID|INV CFM\nDate";
					HeadTitle1 += "|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|Door Info|Door Info|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG";
					HeadTitle1 += "|BKG Route|BKG Route|BKG Route|BKG Route|Remark|Remark|Shipper|Consignee|tot_knt|||||";

					var HeadTitle2 = "Flag|Seq.|Optimum\nRoute Pass|Pass Type|W/O Issue\nOFC|TRO OFC|Trans\nMode|Discrepancy\nReason|Fm/To|Door|Door Full Name|EQ No.|TP/SZ|BND|Cost\nMode|BKG No.|SC No.|RFA No.|TAA No.|TRO\nSEQ|S/O No.|W/O No.|W/O Issue\nDate|W/O Issue ID|INV CFM\nDate";
					HeadTitle2 += "|Transmode|S/P Code|S/P Name|From|Via|To|Door|Factory Name|ZIP Code|Transmode|S/P Code|S/P Name|From|Via|To|Door";
					HeadTitle2 += "|POR|POL|POD|DEL|TRO|TRS S/O|Shipper|Consignee|tot_knt|||||";

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
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"optm_rout_pass_flg",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"pass_type",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"tro_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	130,daLeft,		true,	prefix+"dscr_rsn_desc",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"bkg_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"bkg_dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	180,	daLeft,	true,	prefix+"bkg_dor_nod_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"eq_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"eq_tpsz_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	35,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_cost_dtl_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"sc_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"rfa_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"taa_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"tro_seq",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"so_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"wo_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"wo_iss_dt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"wo_iss_usr_id",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"inv_cfm_dt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"trsp_crr_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"wo_vndr_seq",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"vndr_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"via_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	85,	daCenter,	true,	prefix+"door_fctry_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"door_zip",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	80,	daCenter,	true,	prefix+"optm_trsp_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"optm_sp_code",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	180,daLeft,		true,	prefix+"optm_sp_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"optm_from_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"optm_via_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"optm_to_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	60,	daCenter,	true,	prefix+"optm_door_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"por_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pol_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"del_cd",	false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 	200,	daCenter,	true,	prefix+"not_optm_rsn",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,	daCenter,	true,	prefix+"cng_rsn_desc",	false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"shpr_cust_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	200,daLeft,		true,	prefix+"cnee_cust_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,50,	daCenter,	true,	prefix+"tot_knt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,20,	daCenter,	true,	prefix+"mod_colr_flg", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,20,	daCenter,	true,	prefix+"fm_colr_flg" , 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,20,	daCenter,	true,	prefix+"via_colr_flg", 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,20,	daCenter,	true,	prefix+"to_colr_flg" , 	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,20,	daCenter,	true,	prefix+"dor_colr_flg", 	false, "", dfNone, 0, false, false);
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

					var HeadTitle1 = "Flag|Seq.|Optimum\nRoute Pass|Pass Type|W/O Issue\nOFC|TRO OFC|Trans\nMode|Discrepancy\nReason|Inland Route|Inland Route|Door Full Name|EQ No.|TP/SZ|BND|Cost\nMode|BKG No.|SC No.|RFA No.|TAA No.|TRO\nSEQ|S/O No.|W/O No.|W/O Issue Date|W/O Issue ID|INV CFM\nDate";
					HeadTitle1 += "|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|W/O Route|Door Info|Door Info|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG|Optimum IRG";
					HeadTitle1 += "|BKG Route|BKG Route|BKG Route|BKG Route|Remark|Remark|Shipper|Consignee|tot_knt";

					var HeadTitle2 = "Flag|Seq.|Optimum\nRoute Pass|Pass Type|W/O Issue\nOFC|TRO OFC|Trans\nMode|Discrepancy\nReason|Fm/To|Door|Door Full Name|EQ No.|TP/SZ|BND|Cost\nMode|BKG No.|SC No.|RFA No.|TAA No.|TRO\nSEQ|S/O No.|W/O No.|W/O Issue Date|W/O Issue ID|INV CFM\nDate";
					HeadTitle2 += "|Transmode|S/P Code|S/P Name|From|Via|To|Door|Factory Name|ZIP Code|Transmode|S/P Code|S/P Name|From|Via|To|Door";
					HeadTitle2 += "|POR|POL|POD|DEL|TRO|TRS S/O|Shipper|Consignee|tot_knt";

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
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"optm_rout_pass_flg",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"pass_type",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"wo_cre_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	65,	daCenter,	true,	prefix+"tro_ofc_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	130,daLeft,		true,	prefix+"dscr_rsn_desc",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"bkg_fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"bkg_dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	180,	daLeft,	true,	prefix+"bkg_dor_nod_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"eq_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"eq_tpsz_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_bnd_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_cost_dtl_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"bkg_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"sc_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"rfa_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	82,	daCenter,	true,	prefix+"taa_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"tro_seq",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"so_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"wo_no",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"wo_iss_dt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"wo_iss_usr_id",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	70,	daCenter,	true,	prefix+"inv_cfm_dt",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"trsp_crr_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"wo_vndr_seq",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"vndr_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"fm_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"via_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"to_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"dor_nod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"door_fctry_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"door_zip",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_trsp_mod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_sp_code",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_sp_name",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_from_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_via_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_to_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"optm_door_node",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"por_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pol_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"pod_cd",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"del_cd",	false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"not_optm_rsn",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"cng_rsn_desc",	false, "", dfNone, 0, false, false);
					
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"shpr_cust_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtData, 	50,	daCenter,	true,	prefix+"cnee_cust_nm",	false, "", dfNone, 0, false, false);
					InitDataProperty(0, cnt++, dtHidden,50,	daCenter,	true,	prefix+"tot_knt",	false, "", dfNone, 0, false, false);
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

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		var colorFont = 255;
		var colorBack = 11003848;
		for(var i=sheetObj.HeaderRows ; i<=sheetObj.RowCount+1 ; i++){
			if(sheetObj.CellValue(i,'sheet1_mod_colr_flg') == 'Y') {
				sheetObj.CellFontColor(i,'sheet1_optm_trsp_mod_cd') = colorFont;
				sheetObj.CellFont("FontBold", i,'sheet1_optm_trsp_mod_cd') = true;
				sheetObj.CellBackColor(i,'sheet1_optm_trsp_mod_cd') = colorBack;
			}
			if(sheetObj.CellValue(i,'sheet1_fm_colr_flg') == 'Y') {
				sheetObj.CellFontColor(i,'sheet1_optm_from_node') = colorFont;
				sheetObj.CellFont("FontBold", i,'sheet1_optm_from_node') = true;
				sheetObj.CellBackColor(i,'sheet1_optm_from_node') = colorBack;
			}
			if(sheetObj.CellValue(i,'sheet1_via_colr_flg') == 'Y') {
				sheetObj.CellFontColor(i,'sheet1_optm_via_node') = colorFont;
				sheetObj.CellFont("FontBold", i,'sheet1_optm_via_node') = true;
				sheetObj.CellBackColor(i,'sheet1_optm_via_node') = colorBack;
			}
			if(sheetObj.CellValue(i,'sheet1_to_colr_flg') == 'Y') {
				sheetObj.CellFontColor(i,'sheet1_optm_to_node') = colorFont;
				sheetObj.CellFont("FontBold", i,'sheet1_optm_to_node') = true;
				sheetObj.CellBackColor(i,'sheet1_optm_to_node') = colorBack;
			}
			if(sheetObj.CellValue(i,'sheet1_dor_colr_flg') == 'Y') {
				sheetObj.CellFontColor(i,'sheet1_optm_door_node') = colorFont;
				sheetObj.CellFont("FontBold", i,'sheet1_optm_door_node') = true;
				sheetObj.CellBackColor(i,'sheet1_optm_door_node') = colorBack;
			}
		}
		
		if( sheetObj.CellValue(sheetObj.LastRow, "sheet1_tot_knt") > 2000){
			sheetObj.TotalRows = sheetObj.CellValue(sheetObj.LastRow, "sheet1_tot_knt");
			ComShowCodeMessage("SCE90059");
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
					var sXml = sheetObj.GetSearchXml("ESD_SCE_0171GS.do", sParam);
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
									InsertItem(i++,  '-',  arrCode[j]);
								}
							} else {
								if((mode == 'NO' || mode == 'ALL') && arrCode[j] != 'M') {
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
	
	/*
	 * Compact 체크박스 선택 시 입력란 활성화
	 */
	function chkCompactOption(){
		if(document.form.chk_compact.checked == true){
			sheetObjects[0].ColHidden("sheet1_trsp_mod_cd") = true;
			sheetObjects[0].ColHidden("sheet1_bkg_fm_nod_cd") = true;
			sheetObjects[0].ColHidden("sheet1_bkg_dor_nod_cd") = true;
			sheetObjects[0].ColHidden("sheet1_bkg_dor_nod_name") = true;
			sheetObjects[0].ColHidden("sheet1_tro_seq") = true;
			sheetObjects[0].ColHidden("sheet1_wo_no") = true;
			sheetObjects[0].ColHidden("sheet1_wo_iss_dt") = true;
			sheetObjects[0].ColHidden("sheet1_inv_cfm_dt") = true;
			sheetObjects[0].ColHidden("sheet1_door_fctry_nm") = true;
			sheetObjects[0].ColHidden("sheet1_door_zip") = true;
			sheetObjects[0].ColHidden("sheet1_shpr_cust_nm") = true;
			sheetObjects[0].ColHidden("sheet1_cnee_cust_nm") = true;
		} else {
			sheetObjects[0].ColHidden("sheet1_trsp_mod_cd") = false;
			sheetObjects[0].ColHidden("sheet1_bkg_fm_nod_cd") = false;
			sheetObjects[0].ColHidden("sheet1_bkg_dor_nod_cd") = false;
			sheetObjects[0].ColHidden("sheet1_bkg_dor_nod_name") = false;
			sheetObjects[0].ColHidden("sheet1_tro_seq") = false;
			sheetObjects[0].ColHidden("sheet1_wo_no") = false;
			sheetObjects[0].ColHidden("sheet1_wo_iss_dt") = false;
			sheetObjects[0].ColHidden("sheet1_inv_cfm_dt") = false;
			sheetObjects[0].ColHidden("sheet1_door_fctry_nm") = false;
			sheetObjects[0].ColHidden("sheet1_door_zip") = false;
			sheetObjects[0].ColHidden("sheet1_shpr_cust_nm") = false;
			sheetObjects[0].ColHidden("sheet1_cnee_cust_nm") = false;
		}
	}
	/* 개발자 작업  끝 */