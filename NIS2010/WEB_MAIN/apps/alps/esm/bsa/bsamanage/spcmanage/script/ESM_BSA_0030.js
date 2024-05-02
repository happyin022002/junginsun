/*=========================================================
* History
* 2008.02.27 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경에 따른 Script변경
* 2008.10.24 전성진 CSR No.N200810100017
*                  - Slot Price 및 TEU & Slot Price 화면 추가:
* 2009.09.10 남궁진호 ALPS 전환 작업  1.0 Creation
* 2010.04.15 남궁진호 formQueryString수정              
* 2010.10.05 이행지 [CHM-201005758-01] BSA Architecture 위배사항 수정   
* 2011.07.20 이행지 [CHM-201112101-01] Price 항목 소수점 첫째자리까지 보여주도록 변경
* 2014.12.15 김용습 [CHM-201433095] Error Finder 버튼 추가
* 2015.05.29 김용습 [CHM-201536073] BSA Inquiry by VVD 화면 로딩 시간 개선 요청의 건
* 2015.12.22 김성욱 [CHM-201539410] BSA System 개선의 건 / 동일 날짜에 서로 다른 항차 BSA 입력 가능 실현
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
     * @class ESM_BSA_0030 : ESM_BSA_0030 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BSA_0030() {
    	this.processButtonClick		= processButtonClick;
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

    var sheet_height = 20; // sheet의 height
    var first_load0 = true;  //최초 Load시만 sheet1 height 조정 TEU
    var first_load1 = true;  //최초 Load시만 sheet2 height 조정 Slot Price
    var first_load2 = true;  //최초 Load시만 sheet3 height 조정 TEU & Slot Price
    var first_load3 = true;  //최초 Load시만 sheet2 height 조정 Basic Slottage

	var comboObjects = new Array();
	var comboCnt = 0;
	var loadingMode = false;
	
	var rdoPerf = "0";
	
	var finalHJS_in_SC = new Array();
	
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

	/**
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
	function processButtonClick(){
		var sheetObject0 = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		var formObject = document.form;

		try {
			var srcName = window.event.srcElement.getAttribute("name");

			switch(srcName) {
				case "btn_retrieve":
					
				    if(formObject.rdoPerf[1].checked){ 
				    	showHiddenCarrierCodeColumnOnFirstRetrieve(sheetObjects[1]); // 첫 조회시 화면 첫 로딩시 감췄던 컬럼들의 hidden을 풀기
					    doActionIBSheet1(sheetObject1,formObject,IBSEARCH); // Slot Price
					    rdoPerf = "1";
				    } else if (formObject.rdoPerf[2].checked){
				    	showHiddenCarrierCodeColumnOnFirstRetrieve(sheetObjects[2]); // 첫 조회시 화면 첫 로딩시 감췄던 컬럼들의 hidden을 풀기
					    doActionIBSheet2(sheetObject2,formObject,IBSEARCH);   // TEU & Slot Price
					    rdoPerf = "2";
				    } else if (formObject.rdoPerf[3].checked){
				    	showHiddenCarrierCodeColumnOnFirstRetrieve(sheetObjects[3]); // 첫 조회시 화면 첫 로딩시 감췄던 컬럼들의 hidden을 풀기
					    doActionIBSheet3(sheetObject3,formObject,IBSEARCH);   // Basic Slottage
					    rdoPerf = "3";
				    } else {
				    	showHiddenCarrierCodeColumnOnFirstRetrieve(sheetObjects[0]); // 첫 조회시 화면 첫 로딩시 감췄던 컬럼들의 hidden을 풀기
					    doActionIBSheet0(sheetObject0,formObject,IBSEARCH);  // TEU (1번 시트)
					    rdoPerf = "0";
				    }
					break;

				case "btn_save":
//    				    if(formObject.rdoPerf[3].checked){ 
//    					    doActionIBSheet3(sheetObject1,formObject,IBSAVE);
//    				    }else{
//    					    doActionIBSheet0(sheetObject0,formObject,IBSAVE);
//    				    }
						// 2015.12.22 Manual Flag 클릭된것 찾아서 변경된 값 저장.
						if(formObject.rdoPerf[0].checked){ 
							doActionIBSheet0(sheetObject0, formObject, IBSAVE);
						} else if(formObject.rdoPerf[1].checked){ 
							doActionIBSheet1(sheetObject1, formObject, IBSAVE);
						}
    					break;

				case "btng_creation":
					formObject.flag.value="search";
					doActionIBSheet0(sheetObject0,formObject,IBCREATE);
					break;

				case "btn_skdinquiry0":
				case "btn_skdinquiry1":
				case "btn_skdinquiry2":
				case "btn_skdinquiry3":
                    var vsl_cd  = "";
                    var classId = "COM_ENS_0B1";
                    var param = "";
                    if(formObject.rdoPerf[0].checked) {
                        if(sheetObject0.SelectRow > 1){
                            vsl_cd = ComTrim(sheetObject0.CellValue(sheetObject0.SelectRow, "vsl_cd"))
                                   + ComTrim(sheetObject0.CellValue(sheetObject0.SelectRow, "skd_voy_no"))
                                   + ComTrim(sheetObject0.CellValue(sheetObject0.SelectRow, "skd_dir_cd"));
                        }else{
                            //[COM12113] : VVD 를(을) 선택하세요.
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                        
                    } else if(formObject.rdoPerf[1].checked) {
                        if(sheetObject1.SelectRow > 1){
                            vsl_cd = ComTrim(sheetObject1.CellValue(sheetObject1.SelectRow, "vsl_cd"))
                                   + ComTrim(sheetObject1.CellValue(sheetObject1.SelectRow, "skd_voy_no"))
                                   + ComTrim(sheetObject1.CellValue(sheetObject1.SelectRow, "skd_dir_cd"));
                        }else{
                            //[COM12113] : VVD 를(을) 선택하세요.
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                        
                    } else if(formObject.rdoPerf[2].checked) {
                        if(sheetObject2.SelectRow > 2){
                            vsl_cd = ComTrim(sheetObject2.CellValue(sheetObject2.SelectRow, "vsl_cd"))
                                   + ComTrim(sheetObject2.CellValue(sheetObject2.SelectRow, "skd_voy_no"))
                                   + ComTrim(sheetObject2.CellValue(sheetObject2.SelectRow, "skd_dir_cd"));
                        }else{
                            //[COM12113] : VVD 를(을) 선택하세요.
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                        
                    } else {
                        if(sheetObject3.SelectRow > 1){
                            vsl_cd = ComTrim(sheetObject3.CellValue(sheetObject3.SelectRow, "vsl_cd"))
                                   + ComTrim(sheetObject3.CellValue(sheetObject3.SelectRow, "skd_voy_no"))
                                   + ComTrim(sheetObject3.CellValue(sheetObject3.SelectRow, "skd_dir_cd"));
                        }else{
                            //[COM12113] : VVD 를(을) 선택하세요.
                            ComShowCodeMessage("COM12113","VVD","");
                            return false;
                        }
                        
                    }

                    param = '?vvd_cd='+vsl_cd+'&classId='+classId;
                    ComOpenPopup("/hanjin/COM_ENS_0B1.do"+param, 620, 430, "", "0,0,1,1,1,1,1,1,1,1", false);
					break;

                case "btng_reset0":
                    formObject.reset_flag.value="BSA";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;

                case "btng_reset1":
                    formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;
                
                case "btng_reset2":
//                        formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break; 
                    
                case "btng_reset3":
//                        formObject.reset_flag.value="PFMC";
                    doActionIBSheet0(sheetObject0,formObject,IBRESET);
                    break;    

				case "btn_downexcel":
					if(document.all.RadioLayer0.style.display != "none"){
						doActionIBSheet0(sheetObject0,formObject,IBDOWNEXCEL);
					} else if(document.all.RadioLayer1.style.display != "none"){
						doActionIBSheet0(sheetObject1,formObject,IBDOWNEXCEL);
					} else if(document.all.RadioLayer2.style.display != "none"){
						doActionIBSheet0(sheetObject2,formObject,IBDOWNEXCEL);
					} else {
						doActionIBSheet0(sheetObject3,formObject,IBDOWNEXCEL);
					}
					break;

    			case "bu_zoom_in":
    				sheet_height = getSheetHeightCnt(sheetObject0,"MAX",1);
    				sheetObject0.style.height = sheetObject0.GetSheetHeight(sheet_height);
    				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
    				sheetObject2.style.height = sheetObject1.GetSheetHeight(sheet_height);
    				sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "none";
    				div_zoom_out.style.display = "inline";
    				parent.syncHeight();
    				break;
    
    			case "bu_zoom_out":
    				sheet_height = getSheetHeightCnt(sheetObject0,"MIN",0);
    				sheetObject0.style.height = sheetObject0.GetSheetHeight(sheet_height);
    				sheetObject1.style.height = sheetObject1.GetSheetHeight(sheet_height);
    				sheetObject2.style.height = sheetObject2.GetSheetHeight(sheet_height);
    				sheetObject3.style.height = sheetObject3.GetSheetHeight(sheet_height);
    				div_zoom_in.style.display = "inline";
    				div_zoom_out.style.display = "none";
    				parent.syncHeight();
    				break;
    				
    			case "btng_error_finder0":
				case "btng_error_finder1":
				case "btng_error_finder2":
				case "btng_error_finder3":
					ComOpenPopup("/hanjin/ESM_BSA_0035.do", 650, 600, "", "0,0,1,1,1,1,1,1,1,1", false);
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
	    
		RadioLayer1.style.display="none";       // Basic Slottage
		RadioLayer2.style.display="none";       // Slot Price
		RadioLayer3.style.display="none";       // TEU & Slot Price
		
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
    		// Other Carrier's BSA(Expense) 부분을 처음에는 Hidden시킨다.
    		//--------------------------------------------------------
			initHidden(i+1);
		}
		
		// 멀티콤보 처리
		loadingMode = true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		loadingMode = false;
		
		hideCarrierCodeColumnOnFirstPageLoading(); // 화면 첫 로딩시 선사코드를 보여주는 헤더 컬럼들를 감춤
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
	    // Header Title 선언 , 2015.12.22 manual flag 추가
	    var mnuFlg_header = "|Manual\nFlag";
	    if(sheetNo > 1)
	    	mnuFlg_header = "";
	var comHeaderTitle = "STS"+mnuFlg_header+"|BSA\nFlag|bsa_flg|YYYY-WW|Trade|Sub Trade|S.Lane|Lane"
               		  	+ "|Type|type_flg|Vessel|Voy.|Dir.|OPR|Carrier|vop_flg"
               		  	+ "|V.Capa.|vsl_capa|Loadable\nCapacity|SML Final|CHT out|SML(%)"
               		  	+ "|CHT(%)|SML\nInclude Sub" ;
	    var comHeaderTitle0 = "";
	    var comHeaderTitle1 = "";
	    
        saveNM  = formObj.saveNM.value.split("|");
        crr_cnt = formObj.crr_cnt.value.split("|");
//    	    aryCD   = formObj.jb_cd.value.split("|");
	    aryCrr  = formObj.crr_cd.value.split("|");
	    
	    if(formObj.saveNM.value != "") subColNo = saveNM.length;
        if(formObj.crr_cnt.value != ""){
            var p=0;
            num = 0;
            for(j=0; j<crr_cnt.length; j++){
                if(saveNM[num].substring(3,6) == "000") {
                    for(k=0; k<parseInt(crr_cnt[j]); k++){
                        p++;
                        if (sheetNo==2){
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
            	        if (sheetNo==2){
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
            	        if (sheetNo==2){
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
            	        if (sheetNo==2){
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
            	        if (sheetNo==2){
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
            	        if (sheetNo==2){
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
			case 0:      //sheet1 init
				colNo = 33 + subColNo; // 32 + subColNo;// 2015.12.22 Manual Flag추가

				with (sheetObj) {
//    				   style.height = GetSheetHeight(sheet_height) ;
                    if (first_load0 == true) { style.height = GetSheetHeight(sheet_height); }
			        first_load0 = false;

					SheetWidth = mainTable1.clientWidth;										//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;												//전체Merge 종류 [선택, Default msNone]
					Editable = true;														//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 3, 1, 9, 100);												//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//					InitColumnInfo(colNo, 17, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(colNo, 18, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]
					
//    					var HeadTitle0 = "STS|BSA\nFlag|bsa_flg|YYYY-WW|Trade|Sub Trade|S.Lane|Lane"
//						               + "|Type|type_flg|Vessel|Voy.|Dir.|OPR|Carrier|vop_flg"
//						               + "|V.Capa.|vsl_capa|Loadable\nCapacity|SML Final|CHT out|SML(%)"
//						               + "|CHT(%)|SML\nInclude Sub" ;
					var HeadTitle0 = comHeaderTitle+comHeaderTitle0;
					var HeadTitle1 = comHeaderTitle+comHeaderTitle1;
					var HeadTitle2 = comHeaderTitle;
					
//					SetMergeCell(0,24+num,1,2)
					SetMergeCell(0,25+num,1,2) //MNL_FLG 추가 하면서 1증가
					
//                        if(formObj.crr_cnt.value != ""){
//                            num = 0;
//                            for(j=0; j<crr_cnt.length; j++){
//                                if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Basic Slots"; HeadTitle1 += "|Other Vessels(Expense)" ;}
//                                if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Basic Slots"; HeadTitle1 += "|SML Vessels(Income)";}
//                                if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Chartered Slots"; HeadTitle1 += "|Basic Leased(Income)";}
//                                if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Chartered Slots"; HeadTitle1 += "|Basic Chartered(Expense)";}
//                                if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Chartered Slots"; HeadTitle1 += "|Additional Leased(Income)";}
//                                if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) {HeadTitle0 += "|Chartered Slots"; HeadTitle1 += "|Additional Chartered(Expense)";}
//                                num = parseInt(num) + parseInt(crr_cnt[j]);
//                            }
//                        }
                    HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
					HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
					
                    if(formObj.crr_cd.value != "") HeadTitle2 += "|" + formObj.crr_cd.value;
					HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
					
					
					InitHeadRow(0, HeadTitle0, true);	
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, false);
					
					//---------------------------------------------------------
				    final_hjs_bsa = "IF(|type_flg|==0, |hjs_bsa_bfr_sub_capa|-(" + sub_charter_out + ")+(" + sub_charter_in + ")-(" + cross_charter_out + ")+(" + cross_charter_in + "), |final_hjs_bsa2|)";
				    cht_out = "IF(|type_flg|==0, IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + "+" + cross_charter_out + ", " + sub_charter_out + "+" + cross_charter_out + "), " +
				                                "IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + ", " + sub_charter_out + "))";
				    hjs_rto = "IF(|bsa_flg|==1, 100 , IF(|fnl_hjs_bsa_capa|==0, 0,(|fnl_hjs_bsa_capa|/(|fnl_hjs_bsa_capa|+|co_bsa_capa|))*100))";
				    cht_rto = "IF(|bsa_flg|==1, 0,(1-"+hjs_rto+"/100)*100)";
					//---------------------------------------------------------

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",               false);
					InitDataProperty(0, cnt++, dtCheckBox, 45, daCenter, true,	"mnl1_flg", false); //2015.12.22
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "bsa_zr_flg",           false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   "bsa_flg",              false,      "",            dfNone,         0,     false,       false);
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
//				            if(saveNM[j].substring(3,6) == "000"){ //2015.12.22 
//				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     false,       false);
//				            }else{
//				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     true,       true);
//				            }
				            InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     false,       false);
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
					RangeBackColor(1, 22, 1, 23+subColNo) = RgbColor(222, 251, 248);
					var cnt1 = 24;
					var cnt2 = 23;
					for(j=0; j<crr_cnt.length; j++){
					    cnt2 = cnt2 + parseInt(crr_cnt[j]);
					    if(j%2 == 0){
					        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
					    }
					    cnt1 = cnt1 + parseInt(crr_cnt[j]);
					}
					HeadRowHeight = 10;
					CountPosition  = 0 ;
					     					
				}
				break;

			case 1:      //Slot Price sheet init
				colNo = 33 + subColNo; // 32 + subColNo; //2015.12.22 manual flag 추가

				with (sheetObj) {
//    				    style.height = GetSheetHeight(sheet_height) ;
                    if (first_load2 == true) { style.height = GetSheetHeight(sheet_height); }
			        first_load2 = false;

					SheetWidth = mainTable1.clientWidth;										//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;												//전체Merge 종류 [선택, Default msNone]
					Editable = true;														//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 3, 1, 9, 100);												//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//					InitColumnInfo(colNo, 17, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(colNo, 18, 0, true);										//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);					// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]
					
					var HeadTitle0 = comHeaderTitle+comHeaderTitle0;
					var HeadTitle1 = comHeaderTitle+comHeaderTitle1;
					var HeadTitle2 = comHeaderTitle;
					
//					SetMergeCell(0,24+num,1,2)
//    					var HeadTitle0 = "STS|BSA\nFlag|bsa_flg|YYYY-WW|Trade|Sub Trade|S.Lane|Lane"
//    					               + "|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg"
//    					               + "|V.Capa.|vsl_capa|BSA Capa.|1st Final\nSML BSA|CHT out|SML(%)"
//    					               + "|CHT(%)|SML BSA\nBefore Sub" ;
//                        if(formObj.crr_cnt.value != ""){
//                            num = 0;
//                            for(j=0; j<crr_cnt.length; j++){
//                                if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Other Carrier's BSA(Expense)";
//                                if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Joint Operating Carrier's BSA(Cht-out)";
//                                if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Lease(Income)";
//                                if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Charter in(Expense)";
//                                if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Lease(lease)";
//                                if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Charter in";
//                                num = parseInt(num) + parseInt(crr_cnt[j]);
//                            }
//                        }
					HeadTitle0 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
					HeadTitle1 += "|Revenue Port|Revenue Port|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";
                    
					if(formObj.crr_cd.value != "") HeadTitle2 += "|" + formObj.crr_cd.value;
					HeadTitle2 += "|Port|ETD|S.Lane\n 1st Port ETD|Rule|IOC|bsa_op_cd|final_hjs_bsa2";

					InitHeadRow(0, HeadTitle0, true);										//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(1, HeadTitle1, true);
					InitHeadRow(2, HeadTitle2, false);
					
//					SetMergeCell(0,24+num,1,2)
					SetMergeCell(0,25+num,1,2)
					
					//---------------------------------------------------------
				    final_hjs_bsa = "IF(|type_flg|==0, |hjs_bsa_bfr_sub_capa|-(" + sub_charter_out + ")+(" + sub_charter_in + ")-(" + cross_charter_out + ")+(" + cross_charter_in + "), |final_hjs_bsa2|)";
				    cht_out = "IF(|type_flg|==0, IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + "+" + cross_charter_out + ", " + sub_charter_out + "+" + cross_charter_out + "), " +
				                                "IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + ", " + sub_charter_out + "))";
				    hjs_rto = "IF(|bsa_flg|==1, 100 , IF(|fnl_hjs_bsa_capa|==0, 0,(|fnl_hjs_bsa_capa|/(|fnl_hjs_bsa_capa|+|co_bsa_capa|))*100))";
				    cht_rto = "IF(|bsa_flg|==1, 0,(1-"+hjs_rto+"/100)*100)";
					//---------------------------------------------------------

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",               false);
					InitDataProperty(0, cnt++, dtCheckBox, 45, daCenter, true, "mnl1_flg", false); // 2015.12.22
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "bsa_zr_flg",           false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   "bsa_flg",              false,      "",            dfNone,         0,     false,       false);
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
//					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   "fnl_hjs_bsa_capa",     false,     "" , dfInteger,      0,     false,        false);
//					InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   "co_bsa_capa",          false,      "",       dfInteger,      0,     false,        false);
//					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "hjs_bsa_rto",          false,      "",       dfFloatOrg,     0,     false,        false);
//					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "chtr_bas_rto",         false,      "",       dfFloatOrg,     0,     false,        false);
					InitDataProperty(0, cnt++ , dtAutoSum,    70,    daRight ,  true,   "hjs_bsa_bfr_sub_capa", false,      "",            dfInteger,      0,     false,       false);
				    if(formObj.saveNM.value != ""){
				        for(j=0; j<saveNM.length; j++){
				        	/* 2015.12.22
				            if(saveNM[j].substring(3,6) == "000"){
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  2,     false,       false);
				            }else{
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  2,     true,       true);
				            }*/
				        	InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  2,     false,       false);
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

					RangeBackColor(1, 22, 1, 23+subColNo) = RgbColor(211, 219, 255);
					
					var cnt1 = 24;
					var cnt2 = 23;
					for(j=0; j<crr_cnt.length; j++){
					    cnt2 = cnt2 + parseInt(crr_cnt[j]);
					    if(j%2 == 0){
					        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
					    }
					    cnt1 = cnt1 + parseInt(crr_cnt[j]);
					}

					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;				
			case 2:      //TEU & Slot Price sheet init
				colNo = 33 + subColNo * 2; // 32 + subColNo*2;
				with (sheetObj) {
//    				   style.height = GetSheetHeight(sheet_height) ;
                    if (first_load3 == true) { style.height = GetSheetHeight(sheet_height); }
			        first_load3 = false;

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
					
//                        if(formObj.crr_cnt.value != ""){
//                            num = 0;
//                            for(j=0; j<crr_cnt.length; j++){
//                                if(saveNM[num].substring(3,6) == "000") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Other Carrier's BSA(Expense)|Other Carrier's BSA(Expense)";
//                                if(saveNM[num].substring(3,6) == "001") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Joint Operating Carrier's BSA(Cht-out)|Joint Operating Carrier's BSA(Cht-out)";
//                                if(saveNM[num].substring(3,6) == "002") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Lease(Income)|Lease(Income)";
//                                if(saveNM[num].substring(3,6) == "003") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Charter in(Expense)|Charter in(Expense)";
//                                if(saveNM[num].substring(3,6) == "004") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Lease(lease)|Additional Lease(lease)";
//                                if(saveNM[num].substring(3,6) == "005") for(k=0; k<parseInt(crr_cnt[j]); k++) HeadTitle0 += "|Additional Charter in|Additional Charter in";
//                                num = parseInt(num) + parseInt(crr_cnt[j]);
//                            }
//                        }
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
					
					SetMergeCell(0,24+(num*2),1,2)
					
					//---------------------------------------------------------
				    final_hjs_bsa = "IF(|type_flg|==0, |hjs_bsa_bfr_sub_capa|-(" + sub_charter_out + ")+(" + sub_charter_in + ")-(" + cross_charter_out + ")+(" + cross_charter_in + "), |final_hjs_bsa2|)";
				    cht_out = "IF(|type_flg|==0, IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + "+" + cross_charter_out + ", " + sub_charter_out + "+" + cross_charter_out + "), " +
				                                "IF(|vop_flg|==0, " + joint_operation + "+" + sub_charter_out + ", " + sub_charter_out + "))";
				    hjs_rto = "IF(|bsa_flg|==1, 100 , IF(|fnl_hjs_bsa_capa|==0, 0,(|fnl_hjs_bsa_capa|/(|fnl_hjs_bsa_capa|+|co_bsa_capa|))*100))";
				    cht_rto = "IF(|bsa_flg|==1, 0,(1-("+hjs_rto+"/100))*100)";
					//---------------------------------------------------------

					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,               KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtStatus,     30,    daCenter,  true,   "ibflag",               false);
//					InitDataProperty(0, cnt++, dtCheckBox, 45, daCenter, true, "mnl_flg", false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "bsa_zr_flg",           false,      "",            dfNone,         0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,     40,    daCenter,  true,   "bsa_flg",              false,      "",            dfNone,         0,     false,       false);
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
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg, 2,     false,       false);
				            }else{
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfInteger,  0,     true,       true);
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg, 2,     true,       true);
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
					for(j=0; j<crr_cnt.length; j++){
					    cnt2 = cnt2 + parseInt(crr_cnt[j])*2;
					    if(j%2 == 0){
					        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
					    }
					    cnt1 = cnt1 + parseInt(crr_cnt[j])*2;
					}

					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;		
			case 3:      //Basic Slottage sheet init
				with (sheetObj) {
//    				    style.height = GetSheetHeight(sheet_height) ;
                    if (first_load1 == true) { style.height = GetSheetHeight(sheet_height); }
			        first_load1 = false;

				    colNo = 33 + subColNo; //32 + subColNo;
					SheetWidth = mainTable2.clientWidth;								//전체 너비 설정
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);	//Host정보 설정[필수][HostIp, Port, PagePath]
					MergeSheet = msHeaderOnly;										//전체Merge 종류 [선택, Default msNone]
					Editable = true;												//전체Edit 허용 여부 [선택, Default false]
					InitRowInfo( 2, 1, 9, 100);										//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitColumnInfo(colNo, 17, 0, true);									//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitHeadMode(true, false, false, true, false,false);				// 해더에서 처리할 수 있는 각종 기능을 설정한다[SortEnable], [ColumnMove], [AllCheckEnable], [UserResize], [RowMove],[Head3D]
                    num = 0;
					var HeadTitle0 = "STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nSML BSA|CHT out|SML(%)|CHT(%)"
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
					var HeadTitle1 = "STS|BSA\nFlag|YYYY-WW|Trade|Sub Trade|S.Lane|Lane|Type|type_flg|Vessel|Voy.|BND|OPR|Carrier|vop_flg|V.Capa.|vsl_capa|BSA Capa.|1st Final\nSML BSA|CHT out|SML(%)|CHT(%)"
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
//					InitDataProperty(0, cnt++, dtCheckBox, 45, daCenter, true,	"mnl_flg", false);
					InitDataProperty(0, cnt++ , dtData,       40,    daCenter,  true,   "bsa_zr_flg",        false,          "",       dfNone,    0,     false,       false);
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
					InitDataProperty(0, cnt++ , dtData,       60,    daRight,   true,   "chtr_bsa_rto",      false,          "",       dfFloatOrg, 2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_bzc_chtr_amt", false,          "",       dfFloatOrg, 2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_sub_chtr_amt", false,          sub_charter_in,        dfFloatOrg,   2,     false,       false);

					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_crs_chtr_amt", false,          cross_charter_in,      dfFloatOrg,   2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "expn_tot",          false,          expn_tot,              dfFloatOrg,   2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_bzc_chtr_amt", false,          joint_operation,       dfFloatOrg,   2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_sub_chtr_amt", false,          sub_charter_out,       dfFloatOrg,   2,     false,       false);
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_crs_chtr_amt", false,          cross_charter_out,     dfFloatOrg,   2,     false,       false);
 
					InitDataProperty(0, cnt++ , dtAutoSum,    80,    daRight ,  true,   "incm_tot",          false,          incm_tot,              dfFloatOrg,   2,     false,       false);
				    if(formObj.saveNM.value != ""){
				        for(j=0; j<saveNM.length; j++){
				            if(saveNM[j].substring(3,6) == "000"){
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  2,     false,       false);
				            }else{
				                InitDataProperty(0, cnt++ , dtAutoSum,    60,    daRight ,  true,   saveNM[j],  false,          "",      dfFloatOrg,  2,     true,       true);
				            }
				        }
				    }
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "ioc_cd",             false,   "",       dfNone,     0,     false,       false);
					InitDataProperty(0, cnt++ , dtHidden,       40,     daCenter,   true,   "bsa_op_cd",          false,   "",       dfNone,     0,     false,       false);

					RangeBackColor(1, 20, 1, colNo-1) = RgbColor(211, 219, 255);
					RangeBackColor(0, 22, 0, 24) = RgbColor(187,188,230);
					var cnt1 = 29;
					var cnt2 = 28;
					for(j=0; j<crr_cnt.length; j++){
					    cnt2 = cnt2 + parseInt(crr_cnt[j]);
					    if(j%2 == 0){
					        RangeBackColor(0, cnt1, 0, cnt2) = RgbColor(187,188,230);
					    }
					    cnt1 = cnt1 + parseInt(crr_cnt[j]);
					}

					HeadRowHeight = 10;
					CountPosition  = 0 ;
				}
				break;
		}
	}

	/**
	 * Sheet관련 프로세스 처리
	 */
	function doActionIBSheet0(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0','left');
				formObj.f_cmd.value = SEARCHLIST;
				var sXml = sheetObj.GetSearchXml("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
				
				formObj.crr_cnt.value = GetEtcDataForExceptional(sXml,"crr_cnt");
				formObj.crr_cd.value = GetEtcDataForExceptional(sXml,"crr_cd");
				formObj.saveNM.value = GetEtcDataForExceptional(sXml,"saveNM");
				
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
                sheetObj.LoadSearchXml(sXml);
                sheetObj.RemoveEtcData();
                initHidden(1);
                
//                alert( sheetObj.CellValue( 3 , "ACL"));
                
                
				break;

			case IBSAVE:        //2015.12.22 저장  - 기능 추가 
				if (document.getElementById("btn_save").disabled == true) {
					return;
				}
		
				if (!validateForm(sheetObj, formObj, sAction))
					return false;
				
				formObj.f_cmd.value = MULTI04;
		
				var sParamSheet = ""; //sheetObj.GetSaveString(false);
				var rowCnt = sheetObj.RowCount;
				var ibflag = "";
				var yyww = "";
				var mnl_flg = "";
				var trd_cd = "";
				var sub_trd_cd = "";
				var slan_cd = "";
				var lane_cd = "";
				var type = "";
				var vsl_cd = "";
				var voy_no = "";
				var dir_cd = "";
				var opr_cd = "";
				var car_cd = "";
				var capa = "";
				var hName = "";// 수정한 헤더명 -DAO에서 ',' 를 분리해서 각각 처리함
				var hValue = "";// 수정한 헤더의 값 -DAO에서 ',' 를 분리해서 각각 처리함
				var hDelta = "";//수정한 값의 증감분 -DAO에서 ',' 를 분리해서 각각 처리함
		
				sParamSheet = "";

				for ( var r = 3; r < rowCnt + 3; r++) { // 생성된 row 갯수 만큼, +3은 헤더 갯수
					var ibFlg = sheetObj.CellValue(r, 0); //Manual Flag가 U인 경우(체크되었다가 풀리는것도 처리함)
					
					if ( sheetObj.CellValue(r, "1") == "0" && ( ibFlg == "R" || ibFlg =='' ) ) { // 해당 row가 선택되지 않으면 값을 수정했어도 반영되지 않음., 조회 후 수정 되지 않은 Row 는 skip
						continue;
					}
					
					ibflag = sheetObj.CellValue(r, "ibflag");
					if( ibflag == "R" ) continue; 
					yyww = sheetObj.CellValue(r, "cost_yrmon");
					mnl_flg = sheetObj.CellValue(r, 1);
					trd_cd = sheetObj.CellValue(r, "trd_cd");
					sub_trd_cd = sheetObj.CellValue(r, "sub_trd_cd");
					slan_cd = sheetObj.CellValue(r, "slan_cd");
					lane_cd = sheetObj.CellValue(r, "rlane_cd");
					type = sheetObj.CellValue(r, "vsl_lane_tp_cd");
					vsl_cd = sheetObj.CellValue(r, "vsl_cd");
					voy_no = sheetObj.CellValue(r, "skd_voy_no");
					dir_cd = sheetObj.CellValue(r, "skd_dir_cd");
					opr_cd = sheetObj.CellValue(r, "vop_cd");
					car_cd = sheetObj.CellValue(r, "crr_cd");
					capa = sheetObj.CellValue(r, "vsl_capa");
					hName = "";
					hValue = "";
					hDelta = "";
					
					var flag = false;
					
					for ( var k = 25; k < sheetObj.LastCol - 7; k++) {// 체크된 row에 대해서
						var val = sheetObj.CellValue(r, k);
						var defaultValue = sheetObj.CellSearchValue(r,k);
						
						if( defaultValue == val ) continue; //변경된 값만 처리하기 위해서 이전과 동일한 값은 처리 하지 않음.
						
						if ( defaultValue != "0" ||  val > 0) { // 값이 0이 아니면 무조건 반영 - INSERT OR UPDATE.
							var sName = sheetObj.ColSaveName(k);
							
//							alert(sName);
							
							hName += "," + sName;
							hValue += "," + val;
							
							var crrName = sName.substr(0, 3);
							var jobCode = sName.substr(3);
							
//							var job002 = ( typeof sheetObj.CellValue( r , crrName + "002") == "undefined" ? 0 : sheetObj.CellValue( r , crrName + "002") * 1 ) ; 
//							var job003 = ( typeof sheetObj.CellValue( r , crrName + "003") == "undefined" ? 0 : sheetObj.CellValue( r , crrName + "003") * 1 ) ; 
//							var job004 = ( typeof sheetObj.CellValue( r , crrName + "004") == "undefined" ? 0 : sheetObj.CellValue( r , crrName + "004") * 1 ) ;
//							var job005 = ( typeof sheetObj.CellValue( r , crrName + "005") == "undefined" ? 0 : sheetObj.CellValue( r , crrName + "005") * 1 ) ;
//							
//							var job002_b = ( typeof sheetObj.CellSearchValue( r , crrName + "002") == "undefined" ? 0 : sheetObj.CellSearchValue( r , crrName + "002") * 1 ) ; 
//							var job003_b = ( typeof sheetObj.CellSearchValue( r , crrName + "003") == "undefined" ? 0 : sheetObj.CellSearchValue( r , crrName + "003") * 1 ) ; 
//							var job004_b = ( typeof sheetObj.CellSearchValue( r , crrName + "004") == "undefined" ? 0 : sheetObj.CellSearchValue( r , crrName + "004") * 1 ) ;
//							var job005_b = ( typeof sheetObj.CellSearchValue( r , crrName + "005") == "undefined" ? 0 : sheetObj.CellSearchValue( r , crrName + "005") * 1 ) ;
							
//							var va = 0;
							
							/*if( car_cd == crrName ) {
								if( job002+job004 == 0 ) //우선 음수는 허용하지 않을 예정이므로 음수 나오는 경우를 제외 하려고... 물론 계산식에서 음수 나올수있지만,, 그건 유저가 잘 넣는다고 보고 배제시킴.
									va =job003+job005;
								else
									va =( -job002_b + job003_b -job004_b + job005_b ) + ( job002+job004 ) - ( job003+job005 ); //현재 값을 원복 후 수정한 값을 가지고 조작.
							} else {
//								'car_cd != crrName'일때 완성하면 됨!!
								va = ( job002+job004 ) - ( job003+job005 ) ;//이거를 하면 되는듯하나, 그러면 쿼리에서 현재 '기존값 + va'구조를 그냥 'va' 값만 넣는 것으로 바꿔야 할듯
							}*/
							
//							if( va < 0 ) {
//								flag = true;
//								break;
//							}
							var jobxxx = ( typeof sheetObj.CellValue( r , sName) == "undefined" ? 0 : sheetObj.CellValue( r , sName) * 1 ) ; 
							var jobxxx_b = ( typeof sheetObj.CellSearchValue( r , sName) == "undefined" ? 0 : sheetObj.CellSearchValue( r , sName) * 1 ) ;
							
							if( jobCode == "002" || jobCode == "004" ) //JO / 용선
								hDelta += "," + (jobxxx-jobxxx_b) ;
							else if( jobCode == "001" ) //JO / 사선
								hDelta += "," + (jobxxx-jobxxx_b) ;
							else if( jobCode == "000" && type == "SC" ) //SC 
								hDelta += "," + (jobxxx-jobxxx_b) ;
							else //JO / 용선
								hDelta += "," + (-jobxxx+jobxxx_b) ;
						}
					}
					
//					flag = true;
//					if( flag ){
//						ComShowCodeMessage("BSA10048"); //결과가 음수인경우 저장 안됨
//						return false;
//					}
					
					hName = hName.substr(1);
					hValue = hValue.substr(1);
					hDelta = hDelta.substr(1);
		
					sParamSheet += "&ibflag=" + ibflag;
					sParamSheet += "&yyww=" + yyww;
					sParamSheet += "&year=" + formObj.txtYear.value;
					sParamSheet += "&fm_week=" + formObj.txtFmWeek.value;
					sParamSheet += "&to_week=" + formObj.txtToWeek.value;
					sParamSheet += "&mnl_flg=" + (mnl_flg == "1" ? "Y" : "N");
					sParamSheet += "&ioc_cd=" + sheetObj.CellValue( r , "ioc_cd");
					sParamSheet += "&trd_cd=" + trd_cd;
					sParamSheet += "&sub_trd_cd=" + sub_trd_cd;
					sParamSheet += "&slan_cd=" + slan_cd;
					sParamSheet += "&lane_cd=" + lane_cd;
					sParamSheet += "&type=" + type;
					sParamSheet += "&vsl_cd=" + vsl_cd;
					sParamSheet += "&voy_no=" + voy_no;
					sParamSheet += "&dir_cd=" + dir_cd;
					sParamSheet += "&opr_cd=" + opr_cd;
					sParamSheet += "&car_cd=" + car_cd;
					sParamSheet += "&capa=" + capa; //vsl_capa
					sParamSheet += "&bsa_capa=" + sheetObj.CellValue(r, "bsa_capa");
					
//					if( type == "SC" ) //SC
						sParamSheet += "&fnl_hjs_bsa_capa_sc=" + finalHJS_in_SC[r]*1.0;
//					else
						sParamSheet += "&fnl_hjs_bsa_capa=" + sheetObj.CellValue(r, "fnl_hjs_bsa_capa")*1.0;
					
					sParamSheet += "&hjs_bsa_bfr_sub_capa=" + sheetObj.CellValue(r, "fnl_hjs_bsa_capa");
					
					sParamSheet += "&header_name=" + hName;
					sParamSheet += "&header_value=" + hValue;
					sParamSheet += "&d_value=" + hDelta;
					//rto 계산
					var fnl_capa = sheetObj.CellValue( r , "fnl_hjs_bsa_capa" ) * 1.0;
					var bfr_capa = sheetObj.CellValue( r , "hjs_bsa_bfr_sub_capa" ) * 1.0;
					var co_capa = sheetObj.CellValue( r , "co_bsa_capa" ) * 1.0

//					if( finalHJS_in_SC[r] == "" || co_capa == "" ){ //SML Final / co capa 에 빈값이 들어가면 안됨!!
//						ComShowCodeMessage("BSA10049");
//						return;
//					}

//					var hjs_rto = fnl_capa / ( fnl_capa + co_capa );
//					if( hjs_rto < 1 ); hjs_rto = 1;
//					var cht_rto = 1-hjs_rto;
//					sParamSheet += "&fnl_hjs_bsa_capa=" + fnl_capa;//sheetObj.CellValue( r , "fnl_hjs_bsa_capa" );
					sParamSheet += "&hjs_bsa_bfr_sub_capa=" + bfr_capa;//sheetObj.CellValue( r , "hjs_bsa_bfr_sub_capa" );
//					sParamSheet += "&hjs_bsa_rto=" + hjs_rto;//sheetObj.CellValue( r , "hjs_bsa_rto" );
//					sParamSheet += "&chtr_bas_rto=" + cht_rto;//sheetObj.CellValue( r , "chtr_bas_rto" );
					sParamSheet += "&cht_out=" + co_capa;//sheetObj.CellValue( r , "co_bsa_capa" );
					sParamSheet += "&tab_index=0";
					
				}
				sParamSheet = sParamSheet.substr(1) + "&f_cmd=" + MULTI04;
//				alert( sParamSheet );
				var SaveStr = sheetObj.GetSaveString(false);
				sheetObj.DoSave("ESM_BSA_0030GS.do", sParamSheet, -1, false);
				
				ComShowCodeMessage("BSA10006");
				
				break;

			case IBCREATE:        //생성
				formObj.f_cmd.value = MULTI01;
			    if(formObj.flag.value == "search"){
			        // Creation버튼이 클릭되었을때
			        //---------------------------------------------------
				    if(!chkValidCreate()) return false;
				    // [BSA10020] : 정보를 생성하시겠습니까?
                    if (ComShowCodeConfirm("BSA10020")==false) return false;
    				sheetObj.DoSearch4Post("ESM_BSA_0030GS2.do", bsaFormString(formObj,getParam2(curPgmNo)));
			    }else{
			        // 그리드를 더블 클릭했을때
			        //---------------------------------------------------
			        // [BSA10019] : 선택한 정보를 생성하시겠습니까?
                    if (ComShowCodeConfirm("BSA10019")==false) return false;
			        //+"&"+sheetObj.RowSaveStr(sheetObj.SelectRow)
    				sheetObj.DoSearch4Post("ESM_BSA_0030GS2.do", bsaFormString(formObj,getParam2(curPgmNo)));
    			}
                var err_cd = sheetObj.EtcData("err_cd");
                var err_msg = sheetObj.EtcData("err_msg");
                sheetObj.RemoveEtcData();
    			
    			// 작업종료를 알려준다.
    			//-------------------------------------------------
				if(err_cd == "00000"){
					ComShowCodeMessage("BSA10006");
				} else {
				    ComShowMessage(err_msg);
				}
    			//-------------------------------------------------
				break;

			case IBRESET:      //생성데이터 초기화
                if (chkValidCreate()) {
                    if (ComShowCodeConfirm('BSA10021') == true) { //정보를 RESET 하시겠습니까?
                        formObj.f_cmd.value = MULTI03;
                        sheetObj.DoSearch4Post("ESM_BSA_0030GS2.do", bsaFormString(formObj,getParam2(curPgmNo)));
                        var err_cd = sheetObj.EtcData("err_cd");
                        var err_msg = sheetObj.EtcData("err_msg");
                        sheetObj.RemoveEtcData();
                        
                        if (err_cd == "00000") {
                        	ComShowCodeMessage('BSA10018','RESET'); //msg1 + ' 처리가 정상적으로 완료 되었습니다.'
        				} else {
        				    ComShowMessage(err_msg);
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
	 * 콤보 항목을 설정한다. by.yjjeon
	 */
 	function initCombo (comboObj, comboNo) {
		with (comboObj) {
			DropHeight = 300; 
			InsertItem(0, 'All' ,''); 
			Index = 0;
		}
 	}

    /**
     * Slot Price sheet관련 프로세스 처리
     */
    function doActionIBSheet1(sheetObj, formObj, sAction){
		sheetObj.ShowDebugMsg = false;

		switch(sAction) {
			case IBSEARCH:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				if(formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2) formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2, '0','left');
				if(formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2) formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2, '0','left');
				if(formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2) formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
				if(formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2) formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0','left');
				
				formObj.f_cmd.value = SEARCHLIST01;
				var xml = sheetObj.GetSearchXml("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
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
                initSheet(sheetObj, 1);
                sheetObj.Redraw = true;
                sheetObj.Visible = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
                initHidden(1);
				break;

			case IBSAVE:        //저장  기능 제거로인한 주석처리
				if (document.getElementById("btn_save").disabled == true) {
					return;
				}
	
				if (!validateForm(sheetObj, formObj, sAction))
					return false;
				
				formObj.f_cmd.value = MULTI04;
		
				var sParamSheet = ""; //sheetObj.GetSaveString(false);
				var rowCnt = sheetObj.RowCount;
				var ibflag = "";
				var yyww = "";
				var mnl_flg = "";
				var trd_cd = "";
				var sub_trd_cd = "";
				var slan_cd = "";
				var lane_cd = "";
				var type = "";
				var vsl_cd = "";
				var voy_no = "";
				var dir_cd = "";
				var opr_cd = "";
				var car_cd = "";
				var capa = "";
				var hName = "";// 수정한 헤더명 -DAO에서 ',' 를 분리해서 각각 처리함
				var hValue = "";// 수정한 헤더의 값 -DAO에서 ',' 를 분리해서 각각 처리함
				var hDelta = "";
		
				sParamSheet = "";
		
				for ( var r = 3; r < rowCnt + 3; r++) { // 생성된 row 갯수 만큼, +3은 헤더 갯수
				var ibFlg = sheetObj.CellValue(r, 0); //Manual Flag가 U인 경우(체크되었다가 풀리는것도 처리함)
				
				if ( sheetObj.CellValue(r, "1") == "0" && ( ibFlg == "R" || ibFlg =='' ) ) { // 해당 row가 선택되지 않으면 값을 수정했어도 반영되지 않음., 조회 후 수정 되지 않은 Row 는 skip
					continue;
				}
				
				ibflag = sheetObj.CellValue(r, "ibflag");
				if( ibflag == "R" ) continue;
				
				yyww = sheetObj.CellValue(r, "cost_yrmon");
				mnl_flg = sheetObj.CellValue(r, 1);
				trd_cd = sheetObj.CellValue(r, "trd_cd");
				sub_trd_cd = sheetObj.CellValue(r, "sub_trd_cd");
				slan_cd = sheetObj.CellValue(r, "slan_cd");
				lane_cd = sheetObj.CellValue(r, "rlane_cd");
				type = sheetObj.CellValue(r, "vsl_lane_tp_cd");
				vsl_cd = sheetObj.CellValue(r, "vsl_cd");
				voy_no = sheetObj.CellValue(r, "skd_voy_no");
				dir_cd = sheetObj.CellValue(r, "skd_dir_cd");
				opr_cd = sheetObj.CellValue(r, "vop_cd");
				car_cd = sheetObj.CellValue(r, "crr_cd");
				capa = sheetObj.CellValue(r, "vsl_capa");
				hName = "";
				hValue = "";
	
				for ( var k = 25; k < sheetObj.LastCol - 7; k++) {// 체크된 row에 대해서
					var val = sheetObj.CellValue(r, k);
					var defaultValue = sheetObj.CellSearchValue(r,k);
					
					if( defaultValue == val ) continue; //변경된 값만 처리하기 위해서 이전과 동일한 값은 처리 하지 않음.
					
					if ( defaultValue != "0" ||  val > 0) { // 값이 0이 아니면 무조건 반영 - INSERT OR UPDATE.
						var sName = sheetObj.ColSaveName(k);
						hName += "," + sName;
						hValue += "," + val;
						
						var crrName = sName.substr(0, 3);
						var jobCode = sName.substr(3);
													
						
						var jobxxx = ( typeof sheetObj.CellValue( r , sName) == "undefined" ? 0 : sheetObj.CellValue( r , sName) * 1 ) ; 
						var jobxxx_b = ( typeof sheetObj.CellSearchValue( r , sName) == "undefined" ? 0 : sheetObj.CellSearchValue( r , sName) * 1 ) ;
						
						if( jobCode == "002" || jobCode == "004" ) //JO / 용선
							hDelta += "," + (jobxxx-jobxxx_b) ;
						else if( jobCode == "001" ) //JO / 사선
							hDelta += "," + (jobxxx-jobxxx_b) ;
						else //JO / 용선
							hDelta += "," + (-jobxxx+jobxxx_b) ;
					}
				}
	
				hName = hName.substr(1);
				hValue = hValue.substr(1);
	
				sParamSheet += "&ibflag=" + ibflag;
				sParamSheet += "&yyww=" + yyww;
				sParamSheet += "&year=" + formObj.txtYear.value;
				sParamSheet += "&fm_week=" + formObj.txtFmWeek.value;
				sParamSheet += "&to_week=" + formObj.txtToWeek.value;
				sParamSheet += "&mnl_flg=" + (mnl_flg == "1" ? "Y" : "N");
				sParamSheet += "&ioc_cd=" + sheetObj.CellValue( r , "ioc_cd");
				sParamSheet += "&trd_cd=" + trd_cd;
				sParamSheet += "&sub_trd_cd=" + sub_trd_cd;
				sParamSheet += "&slan_cd=" + slan_cd;
				sParamSheet += "&lane_cd=" + lane_cd;
				sParamSheet += "&type=" + type;
				sParamSheet += "&vsl_cd=" + vsl_cd;
				sParamSheet += "&voy_no=" + voy_no;
				sParamSheet += "&dir_cd=" + dir_cd;
				sParamSheet += "&opr_cd=" + opr_cd;
				sParamSheet += "&car_cd=" + car_cd;
				sParamSheet += "&capa=" + capa; //vsl_capa
				sParamSheet += "&bsa_capa=" + sheetObj.CellValue(r, "bsa_capa");
				sParamSheet += "&fnl_hjs_bsa_capa=" + sheetObj.CellValue(r, "fnl_hjs_bsa_capa");
				sParamSheet += "&hjs_bsa_bfr_sub_capa=" + sheetObj.CellValue(r, "fnl_hjs_bsa_capa");
			
				sParamSheet += "&header_name=" + hName;
				sParamSheet += "&header_value=" + hValue;
				sParamSheet += "&d_value=" + hDelta;
				
				//rto 계산
				var fnl_capa = sheetObj.CellValue( r , "fnl_hjs_bsa_capa" ) * 1.0;
				var bfr_capa = sheetObj.CellValue( r , "hjs_bsa_bfr_sub_capa" ) * 1.0;
				var co_capa = sheetObj.CellValue( r , "co_bsa_capa" ) * 1.0
//				var hjs_rto = fnl_capa / ( fnl_capa + co_capa );
//				if( hjs_rto < 1 ); hjs_rto = 1;
//				var cht_rto = 1-hjs_rto;
				sParamSheet += "&fnl_hjs_bsa_capa=" + fnl_capa;//sheetObj.CellValue( r , "fnl_hjs_bsa_capa" );
				sParamSheet += "&hjs_bsa_bfr_sub_capa=" + bfr_capa;//sheetObj.CellValue( r , "hjs_bsa_bfr_sub_capa" );
//				sParamSheet += "&hjs_bsa_rto=" + hjs_rto;//sheetObj.CellValue( r , "hjs_bsa_rto" );
//				sParamSheet += "&chtr_bas_rto=" + cht_rto;//sheetObj.CellValue( r , "chtr_bas_rto" );
				sParamSheet += "&cht_out=" + co_capa;//sheetObj.CellValue( r , "co_bsa_capa" );
				sParamSheet += "&tab_index=1";
			}
			sParamSheet = sParamSheet.substr(1) + "&f_cmd=" + MULTI04;
			
			sheetObj.DoSave("ESM_BSA_0030GS.do", sParamSheet, -1, false);
			
			ComShowCodeMessage("BSA10006");
		
			break;
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
				formObj.f_cmd.value = SEARCHLIST02;
				var xml = sheetObj.GetSearchXml("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
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
                initSheet(sheetObj, 2);
                ComEndConfigSheet(sheetObj);
                sheetObj.Redraw = true;
                sheetObj.Visible = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
                initHidden(3);
				break;

			case IBSAVE:        //저장  기능 제거로인한 주석처리
				if (document.getElementById("btn_save").disabled == true) {
					return;
				}
		//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
		//    				formObj.f_cmd.value = MULTI01;
		//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
		//    				break;
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
				formObj.f_cmd.value = SEARCHLIST03;
				var xml = sheetObj.GetSearchXml("ESM_BSA_0030GS.do", bsaFormString(formObj,getParam2(curPgmNo)));
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
                initSheet(sheetObj, 3);
                ComEndConfigSheet(sheetObj);
                sheetObj.Redraw = true;
                sheetObj.Visible = true;
                //--------------------------------------------------
                sheetObj.LoadSearchXml(xml);
                sheetObj.RemoveEtcData();
                initHidden(3);
				break;

			case IBSAVE:        //저장
		if (document.getElementById("btn_save").disabled == true) {
			return;
		}
//    				if(!validateForm(sheetObj,formObj,sAction)) return false;
//    				formObj.f_cmd.value = MULTI01;
//    				sheetObj.DoSave("ESM_BSA_0030GS.do", FormQueryString(formObj), -1, false);
//    				break;
		}
	}
    	
	/**
	 * Other Carrier's BSA(Expense) 부분을 처음에는 Hidden시킨다.
	 */
	function initHidden(num){
	    var formObj = document.form;
	    
		// Other Carrier's BSA(Expense) 부분을 처음에는 Hidden시킨다.
		// Carriers with BSA only 기능 추가하면서 삭제
		//--------------------------------------------------------
//    		var crr_cnt = formObj.crr_cnt.value.split("|");
//    		
//    		if(formObj.crr_cnt.value != ""){
//    		    if(crr_cnt.length>0){
//    		        for(k=0; k<crr_cnt[0]; k++){
//    		            if(sheetObjects[0].ColSaveName(22+k).substring(3,6)=="000"){
//        		            if(num == "1"){
//        		                sheetObjects[0].ColHidden(22+k) = true;
//        		            } else if(num == "2"){
//        		                sheetObjects[1].ColHidden(29+k) = true;
//        		            }
//    		            }
//    		        }
//    		    }
//    		}
		//--------------------------------------------------------
	    
	}

    /**
     * sheet 더블클릭시에 선택된 행을 creation
     */
    function sheet0_OnDblClick(sheetObj, row, col){
        var formObj = document.form;

        formObj.flag.value = "sheet";
        if (sheetObj.CellValue(row, "mnl1_flg") == "0") // Checkbox가 선택되어 있는 경우는 수정 모드 이므로 create 않함.....
        	doActionIBSheet0(sheetObj,formObj,IBCREATE);
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
	      for(var k=0; k<=sheetObj.LastCol -8; k++) {
	          if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
	             sheetObj.ColHidden(k) = true;	 
	      }
 	  } else {
	      for(var k=0; k<=sheetObj.LastCol -8; k++){
              if(sheetObj.CellValue(0, k) != sheetObj.CellValue(1, k) && parseFloat(sheetObj.SumValue(0,k)) == 0.00)
                  sheetObj.ColHidden(k) = false;	          
           
	      }	      
	  }
	  
	  for( var x=3 ; x<sheetObj.RowCount+3 ; x++ ) {
		  setEditableCell( sheetObj , x , 1 , -1 );
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
       for( var x=3 ; x<sheetObj.RowCount+3 ; x++ ) {
 		  setEditableCell( sheetObj , x , 1 , -1 );
 	  }
    }

    /**
     * 마스터에만 있는 정보이면 입력 못하게한다.(상태가 Ins이면)
     */
    function sheet2_OnSearchEnd(sheetObj, errMsg){
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
    function sheet3_OnSearchEnd(sheetObj, errMsg){
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
	function InvOnChange( kind ){
	    var formObj = document.form;
		if ( kind == "0" ){// TEU : 물량정보를 조회하는 그리드
			document.getElementById("RadioLayer0").style.display= "inline";
			document.getElementById("RadioLayer1").style.display= "none";
			document.getElementById("RadioLayer2").style.display= "none";
			document.getElementById("RadioLayer3").style.display= "none";
			document.form.rdoPerf[0].checked= true;
			document.getElementById("btn_save").disabled = false;
//    			if(formObj.txtYear.value != "") doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		} else if ( kind == "1") { // Basic Slottage : 수입/비용을 조회하는 그리드
			document.getElementById("RadioLayer0").style.display= "none";
			document.getElementById("RadioLayer1").style.display= "inline";
			document.getElementById("RadioLayer2").style.display= "none";
			document.getElementById("RadioLayer3").style.display= "none";
			document.form.rdoPerf[1].checked= true;
			document.getElementById("btn_save").disabled = false;
//    			if(formObj.txtYear.value != "")doActionIBSheet2(sheetObjects[1],formObj,IBSEARCH);
		} else if ( kind == "2") { // Slot Price
			document.getElementById("RadioLayer0").style.display= "none";
			document.getElementById("RadioLayer1").style.display= "none";
			document.getElementById("RadioLayer2").style.display= "inline";
			document.getElementById("RadioLayer3").style.display= "none";
			document.form.rdoPerf[2].checked= true;
			document.getElementById("btn_save").disabled = true;
		} else if ( kind == "3") { // TEU & Slot Price
			document.getElementById("RadioLayer0").style.display= "none";
			document.getElementById("RadioLayer1").style.display= "none";
			document.getElementById("RadioLayer2").style.display= "none";
			document.getElementById("RadioLayer3").style.display= "inline";
			document.form.rdoPerf[3].checked= true;
			document.getElementById("btn_save").disabled = true;
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
			if(chkPrd.value == "M"){
			    if(txtFmMonth.value == "") {
    			    // [COM12138] :Month를 입력하세요.'
    			    ComShowCodeMessage("COM12114", "Month");
    			    return false;
			    }
    			if (txtFmMonth.value != "" && txtToMonth.value == ""){
    				ComShowCodeMessage("COM12114", "To Month", "");
    			    txtToMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value == "" && txtToMonth.value != ""){
    				ComShowCodeMessage("COM12114", "FM Month", "");
    			    txtFmMonth.focus();
    			    return false;
    			}
    			if (txtFmMonth.value != "" && txtToMonth.value != "") {
    			    if(ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)){
    			        // [COM12133] : from Month는(은) to Month 보다 작은값 이어야 합니다.
    			        ComShowCodeMessage("COM12133","from Month"," to Month","작은값");
    			        txtToWeek.focus();
    			        return false;
    			    }

    			    if(ComParseInt(txtToMonth.value)-ComParseInt(txtFmMonth.value)>0){
    			        // [BSA10008] : 1달 를(을) 초과할수 없습니다.
    			        ComShowCodeMessage("BSA10008","1");
    			        txtToMonth.focus();
    			        return false;
    			    }

    			}
			    
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
//    		    if(!chkValidSearch()) return false;
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
    
    
    // 화면 첫 로딩시 선사코드를 보여주는 헤더 컬럼들를 감춤
    function hideCarrierCodeColumnOnFirstPageLoading(){
    	sheetObjects[0].ColHidden(24) = true;
    	sheetObjects[0].ColHidden(25) = true;
    	
    	sheetObjects[1].ColHidden(24) = true;
    	sheetObjects[1].ColHidden(25) = true;
    	
    	sheetObjects[2].ColHidden(24) = true;
    	sheetObjects[2].ColHidden(25) = true;
    	sheetObjects[2].ColHidden(26) = true;
    	sheetObjects[2].ColHidden(27) = true;
    	
    	sheetObjects[3].ColHidden(30) = true;
    	sheetObjects[3].ColHidden(31) = true;
    }
    
    
    // 첫 조회시 화면 첫 로딩시 감췄던 컬럼들의 hidden을 풀기
    function showHiddenCarrierCodeColumnOnFirstRetrieve(sheetObj){
    	if(sheetObj == sheetObjects[0]){
    		sheetObjects[0].ColHidden(24) = false;
        	sheetObjects[0].ColHidden(25) = false;
    	}else if(sheetObj == sheetObjects[1]){
    		sheetObjects[1].ColHidden(24) = false;
        	sheetObjects[1].ColHidden(25) = false;
    	}else if(sheetObj == sheetObjects[2]){
    		sheetObjects[2].ColHidden(24) = false;
        	sheetObjects[2].ColHidden(25) = false;
        	sheetObjects[2].ColHidden(26) = false;
        	sheetObjects[2].ColHidden(27) = false;
    	}else if(sheetObj == sheetObjects[3]){
    		sheetObjects[3].ColHidden(30) = false;
        	sheetObjects[3].ColHidden(31) = false;
    	}
    }

 //################### 2015.12.22 Manual Flag, SAVE 기능 추가.
function sheet0_OnClick(sheet, row, col, value) {
	if( row > 2 )
		setEditableCell( sheet , row , col , value );
}

//################### 2015.12.22 Manual Flag, SAVE 기능 추가.
function sheet1_OnClick(sheet, row, col, value) {
	if( row > 2 )
		setEditableCell( sheet , row , col , value );
}
var changeable = true;
function setEditableCell( sheet , row , col , value ) {
	var sName = sheet.ColSaveName(col);
	var chValue = sheet.CellValue( row , col );
	
	if (col == "1") {
		if( value == -1 && chValue == 1) // value가 -1 인 경우는 처음 검색 결과를 뿌려줄때 임
			value = 0;
		for ( var k = 25; k < sheet.LastCol - 7; k++) {
			if (value == 0)
				sheet.CellEditable(row, k) = true;
			else
				sheet.CellEditable(row, k) = false;
		}
	}
	else if( sName.substr( 3 ) == "000" && sheet.CellValue( row, "vop_cd") == "SML" ) {
		ComShowCodeMessage("BSA10048", "Other Vessels(Expense)", "SML");
		changeable = false;
	}
	else if( sName.substr( 3 ) == "001" && sheet.CellValue( row, "vop_cd") == "OTH" ) {
		ComShowCodeMessage("BSA10048", "SML Vessels(Income)", "OTH");
		changeable = false;
	}else
		changeable = true;
}
function sheet0_OnChange( sheetObj, row, col, value ) {
	calculateCell( sheetObj , row, col , value );
}
function sheet1_OnChange( sheetObj, row, col, value ) {
	calculateCell( sheetObj , row, col , value );
}
function calculateCell( sheetObj , row, col , value ) {
	if( col > 24 ) { //Check Box가 있어서.
		if( !changeable ) {
			sheetObj.CellValue( row , col ) = sheetObj.CellSearchValue( row , col );
			var sName = sheetObj.ColSaveName(col);
			if( sName.substr( 3 ) == "000" && sheetObj.CellValue( row, "vop_cd") == "SML" ) {
				ComShowCodeMessage("BSA10048", "SML Vessels(Income)", "SML");
			} else if( sName.substr( 3 ) == "001" && sheetObj.CellValue( row, "vop_cd") == "OTH" ) {
				ComShowCodeMessage("BSA10048", "Other Vessels(Expense)", "OTH");
			}
			changeable = true;
		} else {
			//선사 물량이 변경 되면 SML Final, SML(%), SML Include Sub 값이 변경됨.
			//SML Final = 모든 선사 물량의 합
			//SML(%) = basic 
			//CHT(%) =  basic 이외
			//SML Include Sub = basic
			
			//SML Final
			var hjsF = 0;
			var hjsIS = 0;
			var cht_out = 0;
			var hjsRatio = 0;
			var chtRatio = 0;
			
			var bsaCapa = sheetObj.CellValue( row , "bsa_capa" ) * 1;
			var hjs = 0;
			var init = 0;
			var sco = 0;
			var sci = 0;
			var cco = 0;
			var cci = 0;
			
			for ( var k = 25; k < sheetObj.LastCol - 8; k++) {// 체크된 row에 대해서
				var val = sheetObj.CellValue( row , k ) * 1;
				
				var sName = sheetObj.ColSaveName( k );
				
				var opCd = sName.substr( 3 , 6 );
				if( opCd == "000") {
					hjs += val;
				}
				if( opCd == "001") {
					init += val;
				}
				if( opCd == "002") {
					sco += val;
				}
				if( opCd == "003") {
					sci += val;
				}
				if( opCd == "004") {
					cco += val;
				}
				if( opCd == "005") {
					cci += val;
				}
			}
			
			finalHJS_in_SC[ row ] = hjs - sco + sci - cco + cci;
//			alert( row + ":"+ finalHJS_in_SC[ row ] );
			
			if( sheetObj.CellValue( row , "vop_cd" ) == "SML" ) {
				hjsIS = bsaCapa - init;
			} else {
				hjsIS = hjs;
				if( rdoPerf == "0" )
					sheetObj.CellValue( row , "final_hjs_bsa2" ) = hjsIS; //IBSheet의 컬럼에 CalLogic이 있어서 해당 컬럼에 값을 바로 넣지 못하고 수식의 컬럼에 값을 넣는다.
			}
			if( rdoPerf == "0" )
				sheetObj.CellValue( row , "hjs_bsa_bfr_sub_capa" ) = hjsIS;
		}
		
	}
	
}
	/* 개발자 작업  끝 */