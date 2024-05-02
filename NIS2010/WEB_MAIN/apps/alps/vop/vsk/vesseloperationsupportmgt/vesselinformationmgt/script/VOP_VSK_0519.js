/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VOP_VSK_0519.js
*@FileTitle : Vessel Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.13
*@LastModifier : 임예지
*@LastVersion : 1.0
* 2014.10.13 임예지
* 1.0 Creation
* 
* History
* 2014.10.13 임예지 CHM-201430615 Vessel Particular Summary 화면 개발
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
     * @class VOP_VSK_0502 : VOP_VSK_0502 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function VOP_VSK_0519() {
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
    var comboObjects = new Array();
    var comboCnt = 0;
    var colCnt = 0;

    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */ 
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject1  = sheetObjects[0];   //sheet1
        //var sheetObject2  = sheetObjects[1];   //임시 시트
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;

				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
					
				case "btn_Excel":
					sheetObjects[0].Down2Excel(-1);
					break;
					
				case "btn_period":
					if(!document.getElementById(srcName).disabled){
						var cal = new ComCalendarFromTo();
						cal.select(formObject.fm_date, formObject.to_date, 'yyyy-MM-dd');
					}
					break;
	                
				case "btns_search1":
					if(!document.getElementById(srcName).disabled){
						var sUrl = "/hanjin/VOP_VSK_0202.do?intg_cd_id=CD00717";
						var rVal = ComOpenPopupWithTarget(sUrl, 428, 470, "", "0,0", true);
						if(rVal){
							formObject.vsl_slan_cd.value = rVal;
						}
					}
					break;
					
				case "btns_search2":
					var sUrl = "/hanjin/VOP_VSK_0219.do?inc_del_vsl_pop=Y"; 
					var rVal = ComOpenPopupWithTarget(sUrl, 464, 500, "", "0,0", true);
					if(rVal){
						formObject.vsl_cd.value = rVal;
					}
					break;
					
				case "btns_search4":
					if(!document.getElementById(srcName).disabled){
						var sUrl = "/hanjin/COM_ENS_0N1.do";
						ComOpenPopupWithTarget(sUrl, 426, 450, "3:crr_cd", "0,0", true);
					}
					break;
					
				case "btn_Viewoption":
					var sUrl = "/hanjin/VOP_VSK_0520.do";
					var rtnVal = ComOpenPopupWithTarget(sUrl, 900, 600, "", "0,0", true, "yes");
					if(rtnVal){
						sheetChange(rtnVal);
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
    
    function sheetChange(rtnVal){
		var colName1 = rtnVal[0].split("|");
		//alert(rtnVal[0]);
		var colName2 = rtnVal[1].split("|");
		//alert(rtnVal[1]);
		var prefix = "sheet1_";
		for(var i=0; i<colName1.length; i++){
			colName1[i] = prefix + colName1[i];
		}
		for(var i=0; i<colName2.length; i++){
			colName2[i] = prefix + colName2[i];
		}

		for(var i=0; i<colName1.length; i++){
			if(colName1[i] != ""){
				for(var j=0; j<colCnt; j++){
					if(colName1[i] == sheetObjects[0].ColSaveName(j)){
						//alert(colName1[i] + " == " + sheetObjects[0].ColSaveName(j));
						sheetObjects[0].ColHidden(colName1[i]) = true;
						//sheetObjects[0].ColHidden("vsl_clss_no") = true;
					}
				}
			}
		}
		for(var i=0; i<colName2.length; i++){
			if(colName2[i] != ""){
				for(var j=0; j<colCnt; j++){
					if(colName2[i] == sheetObjects[0].ColSaveName(j)){
						sheetObjects[0].ColHidden(colName2[i]) = false;
						//sheetObjects[0].ColHidden("vsl_clss_no") = true;
						//sheetObjects[0].ColHidden(tmp) = true;
					}
					
				}

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
    	var formObject = document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
 		
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initCombo(comboObjects[0]);
        initCombo(comboObjects[1]);
        initCombo(comboObjects[2]);
        initCombo(comboObjects[3]);

    	doActionIBCombo(sheetObjects[0],formObject,IBSEARCH,comboObjects[3],SEARCH01);

    	initControl();
        
        document.form.fm_date.value = ComGetDateAdd(null, "M", -1);
        document.form.to_date.value = ComGetNowInfo();
        formObj.vsl_type2.value = "CNTR";
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj) {
		var i=0;
   	    switch(comboObj.id) {
			case "vsl_type":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.BackColor = "#CCFFFD";
					InsertItem(i++,  "Container",  "CNTR");
					InsertItem(i++,  "Bulk", "BLK");
					comboObj.Code = "CNTR";
	        	}
				break;
				
			case "vsl_svc_tp_cd":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.BackColor = "#FFFFFF";
					InsertItem(i++,  "All",  "A");
					InsertItem(i++,  "Owner", "I");
					InsertItem(i++,  "Charter", "S");
					InsertItem(i++,  "Joint Operation", "J");
					InsertItem(i++,  "Feeder", "O");
					comboObj.Code = "A";
	        	}
				break;
			
			case "vsl_own_ind_cd":
				with(comboObj) {
					comboObj.DropHeight=125;
					comboObj.BackColor = "#FFFFFF";
					InsertItem(i++,  "All",  "A");
					InsertItem(i++,  "Owned",  "O");
					InsertItem(i++,  "Charter", "C");
					comboObj.Code = "A";
	        	}
				break;
			
			case "cntr_vsl_clss_capa":
				with(comboObj) {
					MultiSelect = false; 
					UseAutoComplete = true;	
					SetColAlign("left");        
					SetColWidth("50");
					BackColor = "#FFFFFF"; 
					FontColor = "#000000";
					ColBackColor(0) = "#FFFFFF";
					ColFontColor(0) = "#000000";
					DropHeight = 160;
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
                    style.height = 402;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msPrevColumnMerge + msHeaderOnly;
                    //MergeSheet = msAll;
                    //MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = false;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]document.form.pagerows.value
                    InitRowInfo(2, 1, 3, 100);

					var HeadTitle1 = "|Vessel\nCode|Name|Name|Carrier\nCode|Owner|Ship\nType|Capacity|Capacity|Capacity|Identification|Identification|Identification|Class|Class|Registry|Registry|Registry|Built & Delivery date|Built & Delivery date|Built & Delivery date|Built & Delivery date|Built & Delivery date|Built & Delivery date" +
									 "|Communication|Communication|Communication|Communication|Reefer|Reefer|Speed|Speed|Speed|Dimension|Dimension|Dimension|Dimension|Dimension|Dimension|Dimension|Tonnage|Tonnage|Tonnage|Gross Tons|Gross Tons|Gross Tons|Net Tons|Net Tons|Net Tons|Net Tons|Net Tons|Tank Capacity|Tank Capacity|Tank Capacity|Tank Capacity" +
									 "|Consumption|Consumption|Consumption|Main Engine|Main Engine|Main Engine|Main Engine|Generator Engine|Generator Engine|Generator Engine|Generator Engine|Bow Thrust|Bow Thrust|Bow Thrust|Bow Thrust|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming|RPM & Slow Steaming" +
									 "|Design Max Load Hold/Deck|Design Max Load Hold/Deck|Design Max Load Hold/Deck|Design Max Load Hold/Deck|Design Max Load Hold/Deck|Other|Other";
					
					var HeadTitle2 = "|Vessel\nCode|ENG|China|Carrier\nCode|Owner|Ship\nType|Vessel Class|Design TEU|Panama|IMO No.|Call Sign|Office No.|Class|Class No.|Flag|Port of\nRegistry|P&I\nClub|Heavy\nIndustry|Hull No.|Keel Laid\nDT|Launched\nDT|Delivered\nDT|Registered\nDT|Tel No.|Fax No.|TLX No.|E-Mail|Operation|Max.|MIN.|Service|MAX.|L.O.A|L.B.P|Breadth|Depth|Height|Summer\nDraft|Freeboard|Displacement|Dead\nWeight|Light\nShip" +
									 "|International|Panama|Suez|International|Panama|Suez(KR)|Sue(Maiden)|ITC|F.O\n(85%)|D.O\n(85%)|F.W\n(100%)|Ballast\n(100%)|F.O|D.O|F.W|Maker|Type|BHP/KW|RPM|Maker|Type|BHP/KW|RPM|Maker|Type|BHP/KW|RPM|Critical RPM\nZone(from)|Critical RPM\nZone(to)|OPS MIN.\nRPM|OPS MIN\nSpeed|Slow\nSteaming|Super Slow\nSteaming|Fuel Saving\nEquip|Load(%)|In Hold\nby Tier|In Hold\nby Row|H/C\nin Hold|O/Deck\nby Tier|O/Deck\nby Row|Max.\nCrew|AMP Type";
					
					var headCount = ComCountHeadTitle(HeadTitle1);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false);

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var prefix="sheet1_";
                    //데이터속성            [ROW, COL,  DATATYPE,       WIDTH, DATAALIGN,       COLMERGE,   SAVENAME,             KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,	40,	    daCenter,		true,		prefix+"ibflag");
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"vsl_cd",     	 false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,		prefix+"vsl_eng_nm",     false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		prefix+"vsl_locl_nm",	 false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"crr_cd",		 false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"vsl_own_ind_cd", false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"vsl_type",		false,		"",				dfNone,				0,		true,		true);
                    
                    //Capacity
                    InitDataProperty(0, cnt++ , dtData,			75,		daRight,		true,		prefix+"cntr_vsl_clss_capa",	false,		"",			dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"cntr_dzn_capa",			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"cntr_pnm_capa",			false,		"",				dfNone,				0,		true,		true);
                    
                    //Identification
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"lloyd_no",			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		true,		prefix+"call_sgn_no",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix+"rgst_no",			false,		"",				dfNone,				0,		true,		true);
                    
 					//Class
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		false,		prefix+"clss_no_rgst_area_nm",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daCenter,		false,		prefix+"vsl_clss_no",				false,		"",				dfNone,				0,		true,		true);
                    
                    //Registry
                    InitDataProperty(0, cnt++ , dtData,			50,		daCenter,		true,		prefix+"cnt_cd",			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daLeft,		true,		prefix+"cnt_nm",			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			90,		daLeft,		true,		prefix+"piclb_desc",		false,		"",				dfNone,				0,		true,		true);
                    
                    //Built & Delivery date
                    InitDataProperty(0, cnt++ , dtData,			65,		daRight,		true,		prefix+"vsl_dldr_nm",		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			65,		daLeft,		true,		prefix+"vsl_hl_no", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"vsl_kel_ly_dt", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"vsl_lnch_dt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"vsl_de_dt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daCenter,		true,		prefix+"rgst_dt", 			false,		"",				dfNone,				0,		true,		true);
                    
                    //Communication
                    InitDataProperty(0, cnt++ , dtData,			85,		daCenter,		true,		prefix+"phn_no", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			85,		daCenter,		true,		prefix+"fax_no", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			85,		daCenter,		true,		prefix+"tlx_no", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			115,	daCenter,		true,		prefix+"vsl_eml", 			false,		"",				dfNone,				0,		true,		true);
                   
                    //Reefer
                    InitDataProperty(0, cnt++ , dtData,			65,		daRight,		true,		prefix+"rf_rcpt_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"rf_rcpt_max_knt", 	false,		"",				dfNone,				0,		true,		true);
                    
                    //Speed
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"ecn_spd", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"vsl_svc_spd", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"max_spd", 			false,		"",				dfNone,				0,		true,		true);
                    
                    //Dimension
                    InitDataProperty(0, cnt++ , dtData,			45,		daRight,		true,		prefix+"loa_len", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			45,		daRight,		true,		prefix+"lbp_len", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"vsl_wdt", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"vsl_dpth", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"vsl_hgt", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"smr_drft_hgt", 		false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"wnt_drft_ght", 		false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"trop_drft_hgt", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"fbd_capa", 			false,		"",				dfNone,				0,		true,		true);
                    
                    //Tonnage
                    InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		prefix+"dpl_capa", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"dwt_wgt", 			false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"wnt_dwt_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    //InitDataProperty(0, cnt++ , dtData,			70,		daCenter,		true,		prefix+"trop_dwt_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"lgt_shp_tong_wgt", 	false,		"",				dfNone,				0,		true,		true);
                    
                    //Gross Tons
                    InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		prefix+"grs_rgst_tong_wgt", false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"pnm_gt_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"suz_gt_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    
                    //Net Tons
                    InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		prefix+"net_rgst_tong_wgt", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"pnm_net_tong_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"suz_net_tong_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			80,		daRight,		true,		prefix+"madn_voy_suz_net_tong_wgt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			40,		daCenter,		true,		prefix+"intl_tong_certi_flg", 		false,		"",				dfNone,				0,		true,		true);
                    
                    //Tank Capacity
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"foil_capa", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"doil_capa", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"frsh_wtr_capa", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"blst_tnk_capa", 	false,		"",				dfNone,				0,		true,		true);
                   
                    //Consumption
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"foil_csm", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"doil_csm", 			false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"frsh_wtr_csm", 		false,		"",				dfNone,				0,		true,		true);
                   
                    //Main Engine
                    InitDataProperty(0, cnt++ , dtData,			120,		daCenter,		true,		prefix+"mn_eng_mkr_nm", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			100,		daCenter,		true,		prefix+"mn_eng_tp_desc", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"mn_eng_bhp_pwr", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"mn_eng_rpm_pwr", 	false,		"",				dfNone,				0,		true,		true);
                    
                    //Generator Engine
                    InitDataProperty(0, cnt++ , dtData,			120,		daCenter,		true,		prefix+"gnr_mkr_nm", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			100,		daCenter,		true,		prefix+"gnr_tp_desc", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"gnr_bhp_pwr", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"gnr_rpm_pwr", 		false,		"",				dfNone,				0,		true,		true);
                    
                    //Bow Thrust
                    InitDataProperty(0, cnt++ , dtData,			120,		daCenter,		true,		prefix+"bwthst_mkr_nm", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			100,		daCenter,		true,		prefix+"bwthst_tp_desc", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"bwthst_bhp_pwr", 	false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			50,		daRight,		true,		prefix+"bwthst_rmp_pwr", 	false,		"",				dfNone,				0,		true,		true);
                   
                    //RPM & Slow Steaming
                    InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		prefix+"ctcl_rpm_no", 		false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			90,		daRight,		true,		prefix+"ctcl_to_rpm_no", 	false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"op_min_rpm_no", 	false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"op_min_spd", 		false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"slw_stmng_flg", 	false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"spr_slw_stmng_flg", false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			70,		daRight,		true,		prefix+"fuel_sav_eq_flg", 	false,		"",				dfFloat,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"vsl_lod_rto", 		false,		"",				dfFloat,				0,		true,		true);
                    
                    //Design Max Load Hold/dock
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"in_hld_per_tr_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"in_hld_per_row_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"htch_cvr_in_hld_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"on_deck_per_tr_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"on_deck_per_row_knt", 		false,		"",				dfNone,				0,		true,		true);
                    
                    InitDataProperty(0, cnt++ , dtData,			60,		daRight,		true,		prefix+"crw_knt", 		false,		"",				dfNone,				0,		true,		true);
                    InitDataProperty(0, cnt++ , dtData,			60,		daLeft,			true,		prefix+"amp_tp_cd", 		false,		"",				dfNone,				0,		true,		true);

                    //InitUserFormat2(0, prefix+"phn_no", "###-###-###" );

                    
                    colCnt = cnt;
                    //CountPosition = 0;
                    //CountFormat = "[SELECTDATAROW / TOTALROWS]";
 				}
 		}
	}


  //조회조건필드인 vsl_clss_no 조회
    function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
           case IBSEARCH:      // 조회
    			if (sheetObj.id == "sheet1") {				
    				//콤보필드를 초기화시킨다.
    				sComboObj.RemoveAll();
    									
    				formObj.f_cmd.value = SEARCH01;
    				var param = "f_cmd=" + SEARCH01;
    				var sXml = sheetObj.GetSearchXml("VSK_COMGS.do", param);
    				var comboItems = ComGetEtcData(sXml, "vslCls").split("|");
    				
    				addComboItem(comboObjects[3],comboItems);

    			};
    														
                break;
        }
    }
    
    /**
     * 콤보필드에 데이터를 추가해준다.
     */	
    function addComboItem(comboObj,comboItems) {
    	for (var i = 0 ; i < comboItems.length ; i++) {
    		var comboItem = comboItems[i].split(",");
    		comboObj.InsertItem(i, comboItem,comboItem);
    	}   		
    }
    
    
    /** 
     * initControl()
     */ 
    function initControl() {
    	var formObj = document.form;
    	axon_event.addListenerForm('keyup', 'obj_keyup', formObj);
    	axon_event.addListenerForm('keypress', 'obj_keypress', formObj);
    	axon_event.addListenerForm('change', 'obj_change', formObj);
    	axon_event.addListenerForm('blur', 'obj_blur', formObj);
    	//axon_event.addListener('keydown',  'ComKeyEnter',   'form');
    	//axon_event.addListener('change', 'loc_cd_onchangeMax5', 'loc_cd', ''); //loc_cd 변경 Event
    }
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 임예지
     * @version 2014.10.25
     */ 
    function obj_keyup(){
    	var sheetObj = sheetObjects[0];
    	var formObj = document.form;
    	var obj = event.srcElement;
     	switch(event.srcElement.name) {
      	
    		case "vsl_slan_cd":
    			if(ComChkLen(obj.value, 3)==2){
    				doActionIBSheet(sheetObj, formObj, SEARCH01);
    			}
    			break;
    		case "vsl_cd" :
    			if(formObj.vsl_type2.value == "CNTR"){
	    			if(ComChkLen(obj.value, 4)==2){
	    				doActionIBSheet(sheetObj, formObj, SEARCH02);
	    			}
    			}
    			break;
    		case "crr_cd":
    			if(formObj.vsl_type2.value == "CNTR"){
	    			if(ComChkLen(obj.value, 3)==2){
	    				doActionIBSheet(sheetObj, formObj, SEARCH04);
	    			}
    			}
    			break;
    		
     	}
    } 
    
    /**
     * 화면 폼의 데이터 값의 데이터 유형을 설정
     * @param 
     * @return
     */
    function obj_keypress(){
    	var formObj = document.form;
    	switch (event.srcElement.name) {

    	    case "vsl_slan_cd":
    	    	ComKeyOnlyAlphabet('uppernum');
    	    	break;
    	    	
    	    case "vsl_cd":
    	    	ComKeyOnlyAlphabet('uppernum');
    	    	break;
    	    
    	    case "crr_cd":
    	    	ComKeyOnlyAlphabet('upper');
    	    	break;
    			
    	    case "fm_date":
    	    	ComKeyOnlyNumber(formObj.fm_date);
    			break;
    			
    	    case "to_date":
    	    	ComKeyOnlyNumber(formObj.to_date);
    			break;
    	}
    }

    /**
	 * 화면 폼의 데이터 값에 커서를 두는 이벤트
	 * @param 
	 * @return
	 */
	function obj_blur(){
		var srcName = event.srcElement.name;
		
		switch(srcName){
			case "fm_date":
			case "to_date":
				ComChkObjValid(event.srcElement);
				break;
		}
	}
    
//    /** 
//     * Port Code 5자리 체크
//     */ 
//	function loc_cd_onchangeMax5(){
//		var formObj = document.form;
//
//		if(formObj.loc_cd.value != ""){
//			//alert("LOC_CD = "+formObj.loc_cd.value);
//			if(formObj.loc_cd.value.length < 5 ){
//				ComShowCodeMessage("VSK50014");
//				ComAlertFocus(formObj.loc_cd, "");
//				return ;
//			}
//		}
//	}
	
	
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */

	function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {
		var formObj = document.form;
  		formObj.page_no.value = PageNo;
  		doActionIBSheet(sheetObj,formObj,IBSEARCH);
	}
	
	//vsl_type 변경 이벤트
    function vsl_type_OnChange(comObj,index,text)
    {
    	
    	var formObj = document.form;
    	if(text == "Container"){
    		formObj.vsl_type2.value = "CNTR";
    		//Period 처리
    		formObj.fm_date.className = "input1";
    		formObj.to_date.className = "input1";
    		formObj.fm_date.value = ComGetDateAdd(null, "M", -1);
    		formObj.to_date.value = ComGetNowInfo();
    		formObj.fm_date.readOnly = false;
    		formObj.to_date.readOnly = false;  
    		
    		//Lane Code
    		formObj.vsl_slan_cd.className = "input";
    		formObj.vsl_slan_cd.readOnly = false;
    		
    		//Using type, class
    		formObj.vsl_svc_tp_cd.Enable = "true";
    		formObj.vsl_svc_tp_cd.Text = "All";
    		formObj.cntr_vsl_clss_capa.Enable = "true";
    		
    		//Period, Vessel code, Lane code, Carrier code button enable 처리
    		ComEnableObject(document.all.btn_period, true);
    		ComEnableObject(document.all.btns_search1, true);
    		ComEnableObject(document.all.btns_search4, true);


    	}else{
    		formObj.vsl_type2.value = "BLK";
    		//Period Disable 처리
    		formObj.fm_date.className = "input2";
    		formObj.to_date.className = "input2";
    		formObj.fm_date.value = "";
    		formObj.to_date.value = "";
    		formObj.fm_date.readOnly = true;
    		formObj.to_date.readOnly = true;  		
    		
    		//Lane Code
    		formObj.vsl_slan_cd.className = "input2";
    		formObj.vsl_slan_cd.readOnly = true;
    		formObj.vsl_slan_cd.value = "";
    		
    		//Using type, class
    		formObj.vsl_svc_tp_cd.Enable = "false";
    		formObj.vsl_svc_tp_cd.Text = "";
    		formObj.cntr_vsl_clss_capa.Enable = "false";
    		
    		//Period, Vessel code, Lane code, Carrier code button disable 처리
    		ComEnableObject(document.all.btn_period, false);
    		ComEnableObject(document.all.btns_search1, false);
    		ComEnableObject(document.all.btns_search4, false);
    	}
    }
    
    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
 			case IBSEARCH:      //조회
 				if(validateForm(sheetObj,formObj,sAction)){
 					ComOpenWait(true);
 					formObj.f_cmd.value = SEARCH;
 					var param = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 					var sXml = sheetObj.GetSearchXml("VOP_VSK_0519GS.do", param);
 					
 					sheetObj.LoadSearchXml(sXml);
 					ComOpenWait(false);
 				}	
 				break;
 			
 			case SEARCH01: // Lane Code 조회
 				ComOpenWait(true);
 				formObj.f_cmd.value = SEARCH01;
 				var sParam = FormQueryString(formObj);
 				var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
 				ComOpenWait(false);
 				
 				var vsl_slan_cd = ComGetEtcData(sXml, "vsl_slan_cd");
 				if(vsl_slan_cd==null){
 					ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
 					formObj.vsl_slan_cd.value = "";
 					formObj.vsl_slan_cd.focus();
 				}
 				break;
 				
 			case SEARCH02: // Vessel Code 조회
 				ComOpenWait(true);
 				formObj.f_cmd.value = SEARCH02;
 				var sParam = FormQueryString(formObj);
 				var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
 				ComOpenWait(false);
 				
 				var vsl_cd = ComGetEtcData(sXml, "vsl_cd");
 				if(vsl_cd==null){
 					ComShowCodeMessage('VSK00021', formObj.vsl_cd.value);
 					formObj.vsl_cd.value = "";
 					formObj.vsl_cd.focus();
 				}
 				break;
 			
 			case SEARCH04: // Carrier Code 조회
 				ComOpenWait(true);
 				formObj.f_cmd.value = SEARCH04;
 				var sParam = FormQueryString(formObj);
 				var sXml = sheetObj.GetSearchXml("VOP_VSK_0032GS.do", sParam);
 				ComOpenWait(false);
 				
 				var crr_cd = ComGetEtcData(sXml, "crr_cd");
 				if(crr_cd==null){
 					ComShowCodeMessage('VSK00021', formObj.crr_cd.value);
 					formObj.crr_cd.value = "";
 					formObj.crr_cd.focus();
 				}
 				break;
 	
			case IBCLEAR:
				formObj.vsl_cd.value = "";
				formObj.vsl_slan_cd.value = "";
				formObj.crr_cd.value = "";

				comboObjects[0].RemoveAll();
				comboObjects[1].RemoveAll();
				comboObjects[2].RemoveAll();
				comboObjects[3].RemoveAll();
		        initCombo(comboObjects[0], 1);
		        initCombo(comboObjects[1], 1);
		        initCombo(comboObjects[2], 1);
		        initCombo(comboObjects[3]);
	    		formObj.fm_date.value = ComGetDateAdd(null, "M", -1);
	    		formObj.to_date.value = ComGetNowInfo();         		
				sheetObj.RemoveAll();
				break;
 					
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      * @param sheetObj,formObj,sAction
      * @return true
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch(sAction) {
     		case IBSEARCH:
     			if(formObj.fm_date.value == "" && formObj.vsl_type2.value == "CNTR"){
     				ComShowCodeMessage('VSK00027','Period');
     				formObj.fm_date.focus();
     				return false;
     			}
     			
     			if(formObj.to_date.value == "" && formObj.vsl_type2.value == "CNTR"){
     				ComShowCodeMessage('VSK00027','Period');
     				formObj.to_date.focus();
     				return false;
     			}
     			
     			// fm_dt to_dt보다 앞선일자가 아니면 오류
     			if(!checkPeriod(formObj.fm_date, formObj.to_date) && formObj.vsl_type2.value == "CNTR"){
     				ComShowCodeMessage("VSK00025", "End date", "start date");
     				formObj.to_date.focus();
     				return false;
     			}
     			break;
     			
     		case SEARCH03:
     			if(formObj.fm_date.value=="" || formObj.to_date.value==""){
     				ComShowCodeMessage('VSK01017', 'Period');
     				formObj.fm_date.focus();
     				return false;
     			}
     			break;
     	}
     	return true;
     }
     
 	 function checkPeriod(fromDate, toDate){
		var fmDt = ComReplaceStr(fromDate.value, "-", "");
		var toDt = ComReplaceStr(toDate.value, "-", "");
		if(ComChkPeriod(fmDt, toDt) < 1){
			return false;
		}else{
			return true;
		}
	 }


	/* 개발자 작업  끝 */