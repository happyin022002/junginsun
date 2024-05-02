/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0042.js
*@FileTitle : BSA Inquiry by VVD(Yearly Plan)
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.26
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.26 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.26 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
* 2011.07.20 이행지 [CHM-201112101-01] Price 항목 소수점 첫째자리까지 보여주도록 변경
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
     * @class ESM_BSA_0042 : ESM_BSA_0042 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0042() {
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

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var sheet_height = 20; // sheet의 height
    var first_load0 = true;  //최초 Load시만 sheet3 height 조정 TEU & Slot Price
    var first_load1 = true;  //최초 Load시만 sheet2 height 조정 Basic Slottage

	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick(){
		var sheetObject0 = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					if (formObject.rdoPerf[0].checked){
					    doActionIBSheet2(sheetObject0,formObject,IBSEARCH);   // TEU & Slot Price
				    } else if (formObject.rdoPerf[1].checked){
					    doActionIBSheet3(sheetObject1,formObject,IBSEARCH);   // Basic Slottage
				    }
					break;

				case "btng_creation":
					doActionIBSheet2(sheetObject0,formObject,IBCREATE);
					break;

				case "btn_downexcel":
					if(document.all.RadioLayer_d.style.display != "none"){
						doActionIBSheet2(sheetObject0,formObject,IBDOWNEXCEL);
					} else {
						doActionIBSheet3(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject0,"MAX",1);
    				sheetObject0.style.height = sheetObject0.GetSheetHeight(sheet_height);
    				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;
    
    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject0,"MIN",0);
    				sheetObject0.style.height = sheetObject0.GetSheetHeight(sheet_height);
    				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
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
		RadioLayer_p.style.display="none";       //  TEU & Slot Price
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
    		// Other Carrier's BSA(Expense) 부분을 처음에는 Hidden시킨다.
    		//--------------------------------------------------------
		}
		
		// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
	}

	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
		var formObj = document.form;
		var cnt = 0;
		var saveNM = "";
		var crr_cnt = "";
		var colNo  = 0;                   // 전체컬럼수
		var subColNo = 0;                 // 유동적인 컬럼의 수
		// calcuLogic 을 위해서 사용한 변수
		// -------------------------------------------------------
		var joint_operation   = "";
		var sub_charter_out   = "";
		var sub_charter_in    = "";
		var cross_charter_out = "";
		var cross_charter_in  = "";
		var final_hjs_bsa     = "";
		var cht_out = "";
		var hjs_rto = "";
		var cht_rto = "";
		var num = 0;
		// -------------------------------------------------------
		// Header Title 선언
		var comHeaderTitle = "STS|YYYY-WW|Trade|Sub Trade|S.Lane|Lane"
							+ "|Type|type_flg|Vessel|Voy.|Dir.|OPR|Carrier|vop_flg"
							+ "|V.Capa.|vsl_capa|Loadable\nCapacity|SML Final|CHT out|SML(%)"
							+ "|CHT(%)|SML\nInclude Sub" ;
		var comHeaderTitle0 = "";
		var comHeaderTitle1 = "";
		
		saveNM  = formObj.saveNM.value.split("|");
		crr_cnt = formObj.crr_cnt.value.split("|");
		aryCrr  = formObj.crr_cd.value.split("|");
		if(formObj.saveNM.value != "") subColNo = saveNM.length;
		
		if(formObj.crr_cnt.value != ""){
            var p=0;
            num = 0;
            for(j=0; j<crr_cnt.length; j++){
                if(saveNM[num].substring(3,6) == "000") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
                        p++;
                        if (sheetNo==0){
                            comHeaderTitle0 += "|Basic Slots|Basic Slots"; 
                            comHeaderTitle1 += "|Other Vessels(Expense)|Other Vessels(Expense)";
                        }else{
                        	comHeaderTitle0 += "|Basic Slots"; 
                            comHeaderTitle1 += "|Other Vessels(Expense)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "001") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        joint_operation += "|" + saveNM[p++] + "|";
            	        if(k != parseInt(crr_cnt[j])-1) joint_operation += "+";
            	        if (sheetNo==0){
                	        comHeaderTitle0 += "|Basic Slots|Basic Slots"; 
                            comHeaderTitle1 += "|SML Vessels(Income)|SML Vessels(Income)";
            	        }else{
                        	comHeaderTitle0 += "|Basic Slots"; 
                            comHeaderTitle1 += "|SML Vessels(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "002") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        sub_charter_out += "|" + saveNM[p++] + "|";
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_out += "+";
            	        if (sheetNo==0){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Leased(Income)|Basic Leased(Income)";
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Leased(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "003") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        sub_charter_in += "|" + saveNM[p++] + "|";
            	        if(k != parseInt(crr_cnt[j])-1) sub_charter_in += "+";
            	        if (sheetNo==0){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Chartered(Expense)|Basic Chartered(Expense)";
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Basic Chartered(Expense)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "004") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        cross_charter_out += "|" + saveNM[p++] + "|";
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_out += "+";
            	        if (sheetNo==0){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Leased(Income)|Additional Leased(Income)";
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Leased(Income)";
                        }
                    }
                }
                if(saveNM[num].substring(3,6) == "005") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
            	        cross_charter_in += "|" + saveNM[p++] + "|";
            	        if(k != parseInt(crr_cnt[j])-1) cross_charter_in += "+";
            	        if (sheetNo==0){
                	        comHeaderTitle0 += "|Chartered Slots|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Chartered(Expense)|Additional Chartered(Expense)";
            	        }else{
                        	comHeaderTitle0 += "|Chartered Slots"; 
                            comHeaderTitle1 += "|Additional Chartered(Expense)";
                        }
                    }
                }
                num = ComParseInt(num) + ComParseInt(crr_cnt[j]);  
                
            }
        }
		switch(sheetNo) {
			case 0:      //TEU & Slot Price sheet init
			    colNo = 30 + subColNo*2;
				with (sheetObj) {
					if (first_load0 == true) { style.height = GetSheetHeight(sheet_height); }
					first_load0 = false;
					SheetWidth = mainTable1.clientWidth;										//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;												//전체Merge 종류 [선택, Default msNone]
					Editable = true;														//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 4, 1, 9, 100);												//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colNo, 17, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]

					var HeadTitle0 = comHeaderTitle+comHeaderTitle0;
					var HeadTitle1 = comHeaderTitle+comHeaderTitle1;
					var HeadTitle2 = comHeaderTitle;
					var HeadTitle3 = comHeaderTitle;
					
					HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
					HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
		               
					if(formObj.crr_cd.value != "") 
					   for(var k = 0; k < aryCrr.length; k++) {
					       HeadTitle2 += "|" + aryCrr[k] + "|" + aryCrr[k];
					   }
					   
					HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";					
		               
					if(formObj.crr_cd.value != "") 
					   for(var k = 0; k < aryCrr.length; k++) {
					       HeadTitle3 += "|TEU|Slot Price";
					   }
					   
					HeadTitle3 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
	
					InitHeadRow(0, HeadTitle0, true);										//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, true);
					InitHeadRow(3, HeadTitle3, false);
					
					SetMergeCell(0,22+(num*2),1,2);
					
					//---------------------------------------------------------
				    final_hjs_bsa = "IF(|type_flg|==0, |hjs_bsa_bfr_sub_capa|-(" + sub_charter_out + ")+(" + sub_charter_in + ")-(" + cross_charter_out + ")+(" + cross_charter_in + "), |final_hjs_bsa2|)";
				    cht_out = "IF(|type_flg|==0, IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + "+" + cross_charter_out + ", " + sub_charter_out + "+" + cross_charter_out + "), " +
				                                "IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + ", " + sub_charter_out + "))";
				    hjs_rto = "IF(|bsa_flg|==1, 100 , IF(|fnl_hjs_bsa_capa|==0, 0,(|fnl_hjs_bsa_capa|/(|fnl_hjs_bsa_capa|+|co_bsa_capa|))*100))";
				    cht_rto = "IF(|bsa_flg|==1, 0,(1-("+hjs_rto+"/100))*100)";
					//---------------------------------------------------------
				    
				    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",               false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   "cost_yrmon",           false,      "",            dfDateYm,       0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "trd_cd",               false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,   "sub_trd_cd",           false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "slan_cd",              false,      "",            dfNone,         0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "rlane_cd",             false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_lane_tp_cd",       false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "type_flg",             false,      "",            dfInteger,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_cd",               false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_voy_no",           false,      "",            dfNone,         0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_dir_cd",           false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "vop_cd",               false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "crr_cd",               false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   "vop_flg",              false,      "",            dfInteger,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight ,  true,   "",                     false,      "",            dfInteger,      0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     60,    daRight ,  true,   "vsl_capa",             false,      "",            dfFloatOrg,     3,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight ,  true,   "bsa_capa",             false,      "",            dfInteger,      0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   "fnl_hjs_bsa_capa",     false,      final_hjs_bsa, dfInteger,      0,     false,        false);
					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   "co_bsa_capa",          false,      cht_out,       dfInteger,      0,     false,        false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "hjs_bsa_rto",          false,      hjs_rto,       dfFloatOrg,     0,     false,        false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "chtr_bas_rto",         false,      cht_rto,       dfFloatOrg,     0,     false,        false);
					InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight ,  true,   "hjs_bsa_bfr_sub_capa", false,      "",            dfInteger,      0,     false,       false);

					if(formObj.saveNM.value != ""){
				        for(j=0; j<saveNM.length; j++){
				            if(saveNM[j].substring(3,6) == "000"){
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     false,       false);
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg, 0,     false,       false);
				            } else{
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     true,       true);
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg, 0,     true,       true);
				            }
				        }
				    }
					InitDataProperty(0, cnt++ , dtData,        60,      daCenter ,  true,   "rev_port_cd",        false,   "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,        110,     daCenter ,  true,   "rev_port_etd_dt",    false,   "",       dfNone,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,        110,     daCenter,   true,   "nlst_port_etd_dt",   false,   "",       dfNone,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,        150,     daLeft,     true,   "ioc_rule_desc",      false,   "",       dfNone,     0,     true,        true);
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "ioc_cd",             false,   "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "bsa_op_cd",          false,   "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       70,     daRight ,   true,   "final_hjs_bsa2",     false,   "",       dfInteger,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "temp",          false,   "",       dfNone,     0,     false,       false);
	
					RangeBackColor(1, 22, 2, 23+subColNo*2) = RgbColor(211, 219, 255);
	
					var cnt1 = 24;
					var cnt2 = 23;
					
					if(crr_cnt.length != 1){
						for(j=0; j<crr_cnt.length; j++){
						    cnt2 = cnt2 + parseInt(crr_cnt[j])*2;
						    if(j%2 == 0){
						        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
						    }
						    cnt1 = cnt1 + parseInt(crr_cnt[j])*2;
						}
					}
	
					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;
			case 1:      //Basic Slottage sheet init
				with (sheetObj) {
	                if (first_load1 == true) { style.height = GetSheetHeight(sheet_height); }
			        first_load1 = false;
	
				    colNo = 31 + subColNo;
					SheetWidth = mainTable2.clientWidth;								//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;										//전체Merge 종류 [선택, Default msNone]
					Editable = true;												//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colNo, 17, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);				// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]
	                num = 0;
					var HeadTitle0 = "STS|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nSML BSA|CHT out|SML(%)|CHT(%)"
									+ "|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)|Chartered in(Expense)"
									+ "|Charter out(Income)|Charter out(Income)|Charter out(Income)|Charter out(Income)";
	                if(formObj.crr_cnt.value != ""){
	                    for(j=0; j<crr_cnt.length; j++){
	                        if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|(Expense)";
	                        if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail Basic Charter out(Income)";
	                        if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail Sub Chater Out(Incom)";
	                        if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Detail Sub Chartered in(Expense)";
	                        if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Lease(lease)";
	                        if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Charter in";
	                        num = parseInt(num) + parseInt(crr_cnt[j]);
	                    }
	                }
					HeadTitle0 += "|ioc_cd|bsa_op_cd";
					var HeadTitle1 = "STS|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nSML BSA|CHT out|SML(%)|CHT(%)"
									+ "|Basic chtred|Sub Chtred|Crs Chtred|Total"
									+ "|Basic chtr|Sub let|Crs Chtr|Total"									
									
	                if(formObj.crr_cd.value != "") HeadTitle1 += "|" + formObj.crr_cd.value;
					   
					HeadTitle1 += "|ioc_cd|bsa_op_cd";
	
	                var expn_tot = "|expn_bzc_chtr_amt|+|expn_sub_chtr_amt|+|expn_crs_chtr_amt|";
	                var incm_tot = "|incm_bzc_chtr_amt|+|incm_sub_chtr_amt|+|incm_crs_chtr_amt|";
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle0, true);
					InitHeadRow(1, HeadTitle1, false);
	
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",            false);
					InitDataProperty(0, cnt++ , dtData,       60,    daCenter,  true,   "cost_yrmon",        false,          "",       dfDateYm,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "trd_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       70,    daCenter,  true,   "sub_trd_cd",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "slan_cd",           false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "rlane_cd",          false,          "",       dfNone,    0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_lane_tp_cd",    false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     50,    daCenter,  true,   "type_flg",          false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daCenter,  true,   "vsl_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_voy_no",        false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "skd_dir_cd",        false,          "",       dfNone,    0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtData,       40,    daRight ,  true,   "vop_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       50,    daRight ,  true,   "crr_cd",            false,          "",       dfNone,    0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daRight ,  true,   "vop_flg",           false,          "",       dfInteger, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   "",                  false,          "",       dfInteger, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     60,    daRight ,  true,   "vsl_capa",          false,          "",       dfFloatOrg,3,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight ,  true,   "bsa_capa",          false,          "",       dfInteger, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight,   true,   "fnl_hjs_bsa_capa",  false,          "",       dfInteger, 0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "co_bsa_capa",       false,          "",       dfInteger,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "hjs_bsa_rto",       false,          "",       dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "chtr_bsa_rto",      false,          "",       dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_bzc_chtr_amt", false,          "",       dfFloatOrg,  0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_sub_chtr_amt", false,          sub_charter_in,        dfFloatOrg, 0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_crs_chtr_amt", false,          cross_charter_in,      dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_tot",          false,          expn_tot,              dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_bzc_chtr_amt", false,          joint_operation,       dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_sub_chtr_amt", false,          sub_charter_out,       dfFloatOrg, 0,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_crs_chtr_amt", false,          cross_charter_out,     dfFloatOrg, 0,     false,       false);
	
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_tot",          false,          incm_tot,   dfFloatOrg,  0,     false,       false);
				    if(formObj.saveNM.value != ""){
				        for(j=0; j<saveNM.length; j++){
				            if(saveNM[j].substring(3,6) == "000"){
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  0,     false,       false);
				            }else{
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  0,     true,       true);
				            }
				        }
				    }
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "ioc_cd",             false,   "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "bsa_op_cd",          false,   "",       dfNone,     0,     false,       false);
	
					RangeBackColor(1, 20, 1, colNo-1) = RgbColor(211, 219, 255);
					RangeBackColor(0, 22, 0, 24) = RgbColor(187,188,230);
					var cnt1 = 29;
					var cnt2 = 28;

					if(crr_cnt.length != 1){
						for(j=0; j<crr_cnt.length; j++){
						    cnt2 = cnt2 + parseInt(crr_cnt[j]);
						    if(j%2 == 0){
						        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
						    }
						    cnt1 = cnt1 + parseInt(crr_cnt[j]);
						}
					}
	
					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;
		}
	}

	
	/**
	 * 콤보 항목을 설정한다. by.yjjeon
	 */
 	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300; 
			InsertItem(0, 'All' ,''); 
			Index = 0;
			
			switch (comboObj.id){
				case "cobTrade":
	            	MaxLength = 3;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);	//영문대문자+숫자					
					break;
				case "cobLane":
	            	MaxLength = 5;
	            	UseAutoComplete = true;
	            	ValidChar(2, 1);	//영문대문자+숫자
					break;
				case "cobDir":
	            	MaxLength = 1;
	            	UseAutoComplete = true;
	            	ValidChar(2, 0);	//영문만 입력
					break;					
			}
		}
 	}

	/**
	 * TEU & Slot Price Sheet관련 프로세스 처리
	 */
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value = SEARCHLIST01;
				var xml = sheetObj.GetSearchXml("ESM_BSA_0042GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value = GetEtcDataForExceptional(xml,"crr_cnt");
				formObj.crr_cd.value = GetEtcDataForExceptional(xml,"crr_cd");
				formObj.saveNM.value = GetEtcDataForExceptional(xml,"saveNM");
				
                // Header 정보를 변경하기 위해 sheet를 초기화 한다.
                //--------------------------------------------------
                // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
                sheetObj.Visible = false;
                sheetObj.Redraw = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObj);
                initSheet(sheetObj, 0);
                ComEndConfigSheet(sheetObj);
                sheetObj.Redraw = true;
                sheetObj.Visible = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
				break;

				
			case IBCREATE:      //생성
				if (!chkValidCreate()) {
					return false;
				}
	
				if (ComShowConfirm(ComGetMsg('BSA10020')) == true) { //정보를 생성 하시겠습니까?
					formObj.f_cmd.value = MULTI01;
				
					var xml = sheetObj.GetSearchXml( "ESM_BSA_0042GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
					if ( xml != null && xml != ''){
						var statusCode = ComGetEtcData(xml, "BatchStatus" );
						switch(statusCode){
							case "4":
								ComShowCodeMessage("COM12116", "BSA Creation Excution");
								break;
							case "5":
								ComShowCodeMessage("COM12151", "BSA Creation Excution");
								break;
							case "6":
								ComShowCodeMessage("BSA00003", "BSA Creation");
								break;
							default: break;							
						}
					}
				}
				break;
				
			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;
		}
	}
	
	/**
	 * Basic Slottage Sheet 관련 프로세스 처리
	 */
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value = SEARCHLIST02;
				var xml = sheetObj.GetSearchXml("ESM_BSA_0042GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				formObj.crr_cnt.value = GetEtcDataForExceptional(xml,"crr_cnt");
				formObj.crr_cd.value = GetEtcDataForExceptional(xml,"crr_cd");
				formObj.saveNM.value = GetEtcDataForExceptional(xml,"saveNM");
				
                // Header 정보를 변경하기 위해 sheet를 초기화 한다.
                //--------------------------------------------------
                // Header 변경으로 인한 Sheet를 초기화 한후에 다시 세팅한다.
                sheetObj.Visible = false;
                sheetObj.Redraw = false;
                sheetObj.RemoveAll();
                sheetObj.Reset();
                ComConfigSheet(sheetObj);
                initSheet(sheetObj, 1);
                ComEndConfigSheet(sheetObj);
                sheetObj.Redraw = true;
                sheetObj.Visible = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
				break;

			case IBDOWNEXCEL:        //엑셀 다운로드
				//sheetObj.SpeedDown2Excel(-1);
                var excelType = selectDownExcelMethod(sheetObj);
                switch (excelType) {
                    case "AY":
                        sheetObj.Down2Excel(0, false, false, true);
                        break;
                    case "DY":
                        sheetObj.Down2Excel(-1, false, false, true);
                        break;
                    case "AN":
                        sheetObj.SpeedDown2Excel(0, false, false);
                        break;
                    case "DN":
                        sheetObj.SpeedDown2Excel(-1, false, false);
                        break;
                }               
				break;
		}
	}

    /**
     * 마스터에만 있는 정보이면 입력 못하게한다.(상태가 Ins이면)
     */
    function sheet0_OnSearchEnd(sheetObj, errMsg){
       var insStatus = sheetObj.FindStatusRow("I");
       var arrRows = insStatus.split(";");

       for(k=0; k<arrRows.length-1; k++){
           sheetObj.RowEditable(arrRows[k]) = false;
       }
       
	  //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
	  if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol-8; k++) {
	          if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
	             sheetObj.ColHidden(k) = true;	 
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol-8; k++){
              if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
                  sheetObj.ColHidden(k) = false;	          
           
	      }	      
	  }
	  
    }
    
    /**
     * 마스터에만 있는 정보이면 입력 못하게한다.(상태가 Ins이면)
     */
    function sheet1_OnSearchEnd(sheetObj, errMsg){
       var insStatus = sheetObj.FindStatusRow("I");
       var arrRows = insStatus.split(";");

       for(k=0; k<arrRows.length-1; k++){
           sheetObj.RowEditable(arrRows[k]) = false;
       }
       
	  //isExcludZero가 체크 된 경우 total값이 0인컬럼은 Hidden시킨다.
	  if(document.form.isExcludZero.checked) {
	      for(var k=0; k<=sheetObj.LastCol; k++) {
	          if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
	             sheetObj.ColHidden(k) = true;	 
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol; k++){
              if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
                  sheetObj.ColHidden(k) = false;
	      }	      
	  }
    }
    
	/**
	 * radio 버튼 클릭 시 화면 display
	 * title,sheet 변경
	 */
	function invOnChange(kind){		 
	    var formObj = document.form;
	    
		if ( kind == "1") { // Slot Price
			document.getElementById("RadioLayer_d").style.display= "inline";
			document.getElementById("RadioLayer_p").style.display= "none";
			document.form.rdoPerf[0].checked= true;
		} else if ( kind == "2") { // TEU & Slot Price
			document.getElementById("RadioLayer_d").style.display= "none";
			document.getElementById("RadioLayer_p").style.display= "inline";
			document.form.rdoPerf[1].checked= true;
		}
	}

	 /**
	  * ifram을 이용하여 R.Lane 표시
	  */
	 function cobTrade_OnChange(obj) {
		if (loadingMode == true) return;
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var param = "";
		var trd_cd = "";
		sheetObj.WaitImageVisible = false;
		
		if(obj.Text != ""){
			trd_cd = obj.Code;
			param = "f_cmd="+SEARCHLIST01;
			param = param+"&trd_cd="+trd_cd;
			param = param+"&code=rLane";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			
			var arrXml = sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], formObj.cobLane, "code", "code");
			formObj.cobLane.Index = 0;
		}
		sheetObj.WaitImageVisible = true;
	 }

    /**
     * month, week가 변경되었을때 Period를 변경한다.
     */
    function setPeriod(obj){
        var formObj = document.form;
        var sheetObj = sheetObjects[0];
        var param = "";
        var gubun = "";
        var fm_mon ="";
        var to_mon ="";
        var fm_wk ="";
        var to_wk ="";

        if(obj.value == ""){// to에 데이터가 없으면 from의 데이터도 클리어 시켜준다.
            if(obj.name == "txtToMonth" ){
                formObj.txtFmMonth.value = "";
            } else if (obj.name == "txtToWeek"){
                formObj.txtFmWeek.value = "";
            }
            return false;
        } else { // from에서 포커스를 잃었을때 데이터가 있으면 그냥 스킵한다.
            if(obj.name == "txtFmMonth") return false;
            if(obj.name == "txtFmWeek") return false;
        }

        if(chkValidSearch()){
            if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != ""){
            	gubun = "5";
            } else if(formObj.txtFmMonth.value == "" && formObj.txtFmWeek.value != "") {
            	gubun = "4";
            } else if(formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value == "") {
            	gubun = "3";
            }
            formObj.param2.value = formObj.txtYear.value;
            if(formObj.chkPrd[0].checked){
                formObj.param5.value = "";
                formObj.param6.value = "";
                formObj.param7.value = formObj.txtFmWeek.value;
                formObj.param8.value = formObj.txtToWeek.value;
                fm_wk = formObj.txtFmWeek.value;
                to_wk = formObj.txtToWeek.value;
            } else {
                formObj.param5.value = formObj.txtFmMonth.value;
                formObj.param6.value = formObj.txtToMonth.value;
                formObj.param7.value = "";
                formObj.param8.value = "";
                fm_mon = formObj.txtFmMonth.value;
                to_mon = formObj.txtToMonth.value;
            }
            
            param = param+"f_cmd="+SEARCHLIST02;
			param = param+"&gubun="+gubun;
			param = param+"&fm_mon="+fm_mon;
			param = param+"&to_mon="+to_mon;
			param = param+"&fm_wk="+fm_wk;
			param = param+"&to_wk="+to_wk;
			param = param+"&year="+eval(formObj.txtYear.value);
			param = param+"&code=period";
			var sXml = sheetObj.GetSearchXml("ESM_BSA_CODE.do", param);
			var period = GetEtcDataForExceptional(sXml, "period", "0");
			document.getElementById("div_period").innerHTML = "<div id=\"div_period\">("+ period +")</div>";
        }
    }

    /**
     * 검색시 필수입력사항 체크
     */
    function chkValidSearch(){
        var formObj = document.form;

		with(formObj){
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			    txtYear.focus();
				return false;
			}
			if (txtFmMonth.value != "" && txtToMonth.value == "") {
				ComShowCodeMessage("COM12114", "month", "");
			    txtToMonth.focus();
			    return false;
			}
			if (txtFmMonth.value == "" && txtToMonth.value != "") {
				ComShowCodeMessage("COM12114", "month", "");
			    txtFmMonth.focus();
			    return false;
			}

			if (txtFmWeek.value != "" && txtToWeek.value == ""){
				ComShowCodeMessage("COM12114", "week", "");
			    txtToWeek.focus();
			    return false;
			}
			if (txtFmWeek.value == "" && txtToWeek.value != ""){
				ComShowCodeMessage("COM12114", "week", "");
			    txtFmWeek.focus();
			    return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
//    			    ComShowCodeMessage("COM12138", "month", "week");
			    return false;
			}
		    if(!isValidYear(txtYear,false,true)) return false;
			if(!isValidMonth(txtFmMonth,false,true)) return false;
			if(!isValidMonth(txtToMonth,false,true)) return false;
			if(!isValidWeek(txtFmWeek,false,true)) return false;
			if(!isValidWeek(txtToWeek,false,true)) return false;
			
		}
		return true;
    }

    /**
     * 생성을 위한 필수항목 체크
     */
    function chkValidCreate(){
        var formObj = document.form;

        with(formObj){
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			    txtYear.focus();
				return false;
			}
			if(chkPrd[1].checked){
				// [COM12114] : W/M 를(을) 확인하세요. => Month일 경우 Batch 실행 불가
				ComShowCodeMessage("COM12114", "W/M");
				return false;
			    
			} else {
    			if(txtFmWeek.value == ""){
    			    // [COM12138] :week를 입력하세요.'
    			    ComShowCodeMessage("COM12114", "week");
    			    return false;
    			}
    			
    			if (txtFmWeek.value != "" && txtToWeek.value == ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtToWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value == "" && txtToWeek.value != ""){
    				ComShowCodeMessage("COM12114", "week", "");
    			    txtFmWeek.focus();
    			    return false;
    			}
    			if (txtFmWeek.value != "" && txtToWeek.value != "") {
    			    if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
    			        // [COM12133] : from Week는(은) to Week 보다 작은값 이어야 합니다.
    			        ComShowCodeMessage("COM12133","from Week"," to Week","작은값");
    			        txtToWeek.focus();
    			        return false;
    			    }
    			    if(cobTrade.value != "" && cobLane.value != ""){
        			    if(ComParseInt(txtToWeek.value)-ComParseInt(txtFmWeek.value)>22){
        			        // [BSA10008] : 22주 을(를)  초과할수 없습니다.
        			        ComShowCodeMessage("BSA10008","22주");
        			        txtToWeek.focus();
        			        return false;
        			    }
    			    }else{
        			    if(ComParseInt(txtToWeek.value)-ComParseInt(txtFmWeek.value)>55){
        			        // [BSA10024] : 5주 를(을) 초과할수 없습니다.\n  trade, Lane 정보를 선택하여 주시기 바랍니다.
        			        ComShowCodeMessage("BSA10024","5", "Trade, Lane");
        			        txtToWeek.focus();
        			        return false;
        			    }
    			    }
    			}
			}
			
			
        }
        return true;
    }

    /**
     * 컬럼을 임시로 Hidden 여부를 선택할수 있는 PopUp장을 띄운다.
     */
    function viewPopUp(){
        var formObj = document.form;
        var count = 0;
        var hValue = "";
        var tmp = "";
        var crr_cnt = formObj.crr_cnt.value.split("|");
        
        for(j=0; j<crr_cnt.length; j++) count = parseInt(count) + parseInt(crr_cnt[j]);
        if(formObj.rdoPerf[0].checked){
            var sheetObj = sheetObjects[0];
            for(k=21; k<count+21; k++){
                if(sheetObj.ColHidden(k))tmp = "0";     // Hidden
                else tmp = "1";                         // Show
                
                hValue = hValue + tmp;
                if(k!=count+20) {
                    hValue = hValue + "|";
                }
            }
        } else {
            var sheetObj = sheetObjects[1];
            for(k=28; k<count+28; k++){
                if(sheetObj.ColHidden(k))tmp = "0";     // Hidden
                else tmp = "1";                         // Show
                
                hValue = hValue + tmp;
                if(k!=count+27) hValue = hValue + "|";
            }
        }
        var param = "?hValue="+hValue+"&txtYear="+formObj.txtYear.value+"&txtFmMonth="+formObj.txtFmMonth.value+"&txtToMonth="+formObj.txtToMonth.value+"&txtFmWeek="+formObj.txtFmWeek.value+"&txtToWeek="+formObj.txtToWeek.value
        noRtnPopup('ESM_BSA_126.do'+param , 'width=870,height=460,menubar=0,status=1,scrollbars=0,resizable=0');
    }
    
    
    /**
     * 컬럼을 Hidden시킨다.
     */
    function chgView(){
        var formObj = document.form;
        var j = 0;
        var hValue = formObj.hValue.value.split("|");

        if(formObj.rdoPerf[0].checked){
            var sheetObj = sheetObjects[0];
            for(k=21; k<hValue.length+21; k++){
                if(hValue[j] == "1") sheetObj.ColHidden(k) = false;
                else sheetObj.ColHidden(k) = true;
                j++;
            }
        } else {
            var sheetObj = sheetObjects[1];
            for(k=28; k<hValue.length+28; k++){
                if(hValue[j] == "1") sheetObj.ColHidden(k) = false;
                else sheetObj.ColHidden(k) = true;
                j++;
            }
        }
        
    }

	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if (txtYear.value == "") {
				ComShowCodeMessage("COM12114", "Year", "");
			    txtYear.focus();
				return false;
			}
			if(txtFmMonth.value == "" && txtFmWeek.value == ""){
				ComShowCodeMessage("COM12138", "month", "week");
			    return false;
			}
            
			if((chkPrd[1].checked && txtFmMonth.value == "" && txtToMonth.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Month", "VVD");
			    return false;
			}
			if((chkPrd[0].checked && txtFmWeek.value == ""  && txtToWeek.value == "") 
			   && txtVsl_cd.value == "" && txtSkd_voy_no.value == "" && txtDir_cd.value == ""){
				ComShowCodeMessage("COM12138", "Week", "VVD");
			    return false;
			}	
			
			// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
			if (chkPrd[1].checked && txtFmMonth.value != "" && txtToMonth.value != "") {
	    		if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
	    			ComAlertFocus(txtToMonth, ComGetMsg('BSA10011','Month','First Element','Second Element'));
	        		return false;
	    		}
			}
			if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
	    		if(ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)){
	    			ComAlertFocus(txtToWeek, ComGetMsg('BSA10011','Week','First Element','Second Element'));
	        		return false;
	    		}
			}

		}
		return true;
	}
    /**
     * VVD code 입력후 유효성을 체크한다.
     */
    function chkVVD() {
        var formObj = document.form;
        // User의 요청으로 VVD항목 유효성 체크하지 않음 : ESM_BSA_039에서 사용하지 않으았으므로 그냥 선언만 했음 (kevin.kim)
    }

     
    function loadCombo() {
    	var formObj = document.form;
 		var sXml = formObj.sXml.value;

 		var arrXml = sXml.split("|$$|");

 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], formObj.cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], formObj.cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], formObj.cobDir, "code", "code");
 		if (arrXml.length > 3)
 			ComXml2ComboItem(arrXml[3], formObj.cobIOC, "code", "code");
 		document.form.sXml.value="";
     }
	/* 개발자 작업  끝 */