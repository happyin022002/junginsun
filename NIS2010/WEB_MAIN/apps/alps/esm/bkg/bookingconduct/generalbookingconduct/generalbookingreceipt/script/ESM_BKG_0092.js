/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0092.js
*@FileTitle : Route Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.28 김병규
* 1.0 Creation
* 2011.03.30 정선용 [CHM-201109338-01] Split 18-ALPS의 Location 조회불가건 수정 보완 요청.
* 2011.06.27 이일민 [CHM-201109402] T/S Yard 정보 가시화 및 Yard 정보 수정화 요청
* 2011.07.11 이일민 [CHM-201110327-01] [긴급] VVD ASSIGN 오류
* 2012.01.11 전성진 [SRM-201223055] [긴급 형상관리 요청] BKG Validation Logic 일시 해제 요청
* 2012.01.12 전성진 [SRM-201223055] [긴급 형상관리 요청] BKG Validation Logic 일시 해제 요청 - 원복
* 2012.01.05 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
* 2012.05.31 조정민 [CHM-201218075] BKG Split 시 Auto-rating 오류
* 2012.11.26 조정민 [CHM-201221359] [Route Detail] T.VVD copy from BKG main 버튼의 팝업 메시지 보완
* 2013.04.04 류대영 [CHM-201323757] T/S 화물에 대한  CLL 마감 이후 CLOSING 기능 로직 변경
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
	 * @class esm_bkg_0092 : esm_bkg_0092 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    function esm_bkg_0092() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    	
    	this.initCombo = initCombo;
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
    
    var openPop = "true";
    
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject = sheetObjects[0];
        var combo1 = comboObjects[0];
        var combo2 = comboObjects[1];
        /** **************************************************** */
        var formObj = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
                case "btn_Save":
                   	if(validateForm(sheetObject, formObj)){     
                   		// port skip flg 세팅 추가 2012.01.05 kbj
                   		setRouteDetailFlag(formObj);
            	   		if(formObj.ca_flg.value == 'Y' && sheetObject.RowCount > 4){
                   			// vvd 4개 이상이면 SCE와 결별
            	    		setParentToPopup(sheetObject, formObj);	            	   			 
            	   		} else {
            	   			doActionIBSheet(sheetObject, formObj, IBSAVE, "", "");
            	   		}
                   	}
                   	break;

				case "btn_New":
					clearOceanRoute(sheetObject, formObj);
					break;
                    
				case "btn_RowAdd":
					// caFlag가 'Y'이면 최대 7Row, 'N'이면 최대 5Row
					var caFlg = formObj.ca_flg.value;
					var rowCnt = sheetObject.RowCount;
					if(caFlg == "Y"){
						if(rowCnt < 7){
							sheetObject.DataInsert(-1);
						}
					}else{
						if(rowCnt < 4){
							sheetObject.DataInsert(-1);
							if(sheetObject.CellValue(rowCnt, "pod_cd")!=formObj.pod_loc_cd.value){
    							sheetObject.CellValue2(rowCnt + 1, "pol_cd") = sheetObject.CellValue(rowCnt, "pod_cd");
    							sheetObject.CellValue2(rowCnt + 1, "pol_yd_cd") = sheetObject.CellValue(rowCnt, "pod_yd_cd");
							}
						}
					} 					 					
                    break;

				case "btn_Delete":
    				sheetObject.RowDelete(sheetObject.SelectRow,false);
   /*
 * for(k=0 ; k <= sheetObject.LastCol ; k ++){ sheetObject.CellValue2(
 * sheetObject.SelectRow, sheetObject.ColSaveName(k)) = "" ; }
 */	           		  					
					setVslPrePostCd();
                    break;
                    
				case "btn_Close":
				    window.close();
                    break;

				case "btn_Clear":
					sheetObject.RemoveAll();
					setParentToPopup(sheetObject, formObj);
                    break; 
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("COM12111"); 
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
    * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
    * @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
    **/
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
		
		initControl();
        
		// IBMultiCombo초기화
		for(var k=0; k<comboObjects.length; k++){
		    initCombo(comboObjects[k]);
		}
		
		var sheetObj = sheetObjects[0];
		var formObj = document.form;
		var parentRefSheet;			
		
		if (ComIsNull(formObj.bkg_no)){
			formObj.cust_ntc_flg.disabled = true;
		}
		var parentObj = window.dialogArguments.document.form;
		if(parentObj.pgm_no.value != "ESM_BKG_0079_01" && parentObj.pgm_no.value != "ESM_BKG_0229_01" && parentObj.pgm_no.value != "ESM_BKG_0898"){
			formObj.cust_ntc_flg.disabled = true;
		}
		if (formObj.callSheetIdx.value !=""){
			parentRefSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx.value]);
		}else{
			// Booking Creation
			parentRefSheet =window.dialogArguments.sheetObjects[1];
		}
		var parentRow = parentRefSheet.Rows ;
		if(parentRow > 1){
			 // Main Sheet에 데이터가 있는 경우 데이터를 Copy해 온다.         
			for ( i = 1 ; i < parentRow ; i++ ){
			    var iRow = sheetObj.DataInsert(-1);
			    for(j = 0 ; j <= parentRefSheet.LastCol ; j++){
			    	if ( parentRefSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
			    		for(k=0 ; k <= sheetObj.LastCol ; k ++){
			                if ( sheetObj.ColSaveName(k) == parentRefSheet.ColSaveName(j)){	                        	 
			                	sheetObj.CellValue2( iRow, sheetObj.ColSaveName(k)) = parentRefSheet.CellValue( i , parentRefSheet.ColSaveName(j)) ;
			                }            			 
			    		}	
			    	}
			    }
			}
			doActionIBSheet(sheetObj,document.form,IBSEARCH, "Y", "Y");

			// Main Sheet에 데이터가 있는 경우 데이터를 Copy해 온다.         
			for ( i = 1 ; i < parentRow ; i++ ){
			    for(j = 0 ; j <= parentRefSheet.LastCol ; j++){
			    	if ( parentRefSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
			    		for(k=0 ; k <= sheetObj.LastCol ; k ++){
			                if ( sheetObj.ColSaveName(k) == parentRefSheet.ColSaveName(j)){	                        	 
			                	sheetObj.CellValue2( i, sheetObj.ColSaveName(k)) = parentRefSheet.CellValue( i , parentRefSheet.ColSaveName(j)) ;
			                }            			 
			    		}
			    	}
			    }
			}
		}else{
		   	// Main Sheet에 데이터가 없는 경우 Seq를 생성한다.
			 sheetObj.DataInsert(-1);
			 sheetObj.DataInsert(-1);
			 sheetObj.DataInsert(-1);
			 sheetObj.DataInsert(-1);
			 sheetObj.DataInsert(-1);
			 sheetObj.CellValue2(1, "seq") = "First";
			 sheetObj.CellValue2(2, "seq") = "Second";
			 sheetObj.CellValue2(3, "seq") = "Third";
			 sheetObj.CellValue2(4, "seq") = "Forth";
			 sheetObj.CellValue2(5, "seq") = "Fifth";
			 sheetObj.CellValue2(1, "chk_flag") = "N";
			 sheetObj.CellValue2(2, "chk_flag") = "N";
			 sheetObj.CellValue2(3, "chk_flag") = "N";
			 sheetObj.CellValue2(4, "chk_flag") = "N";
			 sheetObj.CellValue2(5, "chk_flag") = "N";   			 
			 
			 sheetObj.CellValue2(1, "pol_cd")    = document.form.pol_loc_cd.value;
			 sheetObj.CellValue2(1, "pol_yd_cd") = document.form.pol_nod_cd.value;
			 sheetObj.CellValue2(1, "pod_cd")    = document.form.pod_loc_cd.value;
			 sheetObj.CellValue2(1, "pod_yd_cd") = document.form.pod_nod_cd.value;
			 
			 doActionIBSheet(sheetObj,document.form,IBSEARCH, "N", "Y");
		 }
		 // 초기값 셋팅
		 setDetaultSetting(sheetObj,document.form);   	  	
		 
		 if(formObj.displayOnly.value == "Y"){
			 ComBtnDisable("btn_Save");
			 ComBtnDisable("btn_Clear");
		 } else if(formObj.displayOnly.value == "1"){
//				 sheetObj.RowEditable(1) = false;
// sheetObj.CellEditable(1, "pol_cd") = false;
// sheetObj.CellEditable(1, "pod_cd") = false;
// sheetObj.CellEditable(1, "bkg_vvd_cd") = false;
		 }
		 
//			 if(formObj.ca_flg.value == "Y"){
//				 for(var i = sheetObj.HeaderRows; i < sheetObj.Rows ; i++ ){
//					sheetObj.CellEditable(i, "pol_cd")     = false; 
// sheetObj.CellEditable(i, "pod_cd") = false;
// }
// ComBtnDisable("btn_New");
// ComBtnDisable("btn_RowAdd");
// ComBtnDisable("btn_Delete");
// ComBtnDisable("btn_Clear");
// }			 
		 formObj.combo1.DropHeight = 250;
		 formObj.combo1.SetColWidth("20|80");
		 formObj.combo2.DropHeight = 250;
		 formObj.combo2.SetColWidth("20|80");
		 var podCd = document.form.pod_loc_cd.value;
		 if(podCd == "USLGB" || podCd == "USLGB" || podCd == "USTIW" || podCd == "USPDX" 
			 || podCd == "USSEA" || podCd == "CAVAN" || podCd == "CAPRR" || podCd == "USLAX"){
			 formObj.combo1.enable = false;
			 formObj.combo2.enable = false;
//			 ComShowCodeMessage('BKG02062');
			 formObj.us_west_coast.value = ComGetMsg('BKG02062');
		 } else {
			 formObj.combo1.enable = true;
			 formObj.combo2.enable = true;
		 }
		 
		 //2012.01.05 port_skp_flg값에 따라 체크 여부 결정
		 if( formObj.portSkpFlg.value == 'Y' ){
			 formObj.port_skp_flg.checked = true;
		 }
    }

    /**
     * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
     * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
     * 
     * @param {ibsheet}
     *            sheetObj IBSheet Object
     * @param {int}
     *            sheetNo sheetObjects 배열에서 순번
     */
    function initControl() {
    	var formObj = document.form;
        axon_event.addListenerForm('click', 'bkg0092_click',    	formObj); // 클릭시
    }
     
    /**
    * 콤보 초기설정값
    * @param {IBMultiCombo} comboObj  comboObj
    */
    function initCombo(comboObj) {
    	comboObj.MultiSelect = false;
    	comboObj.UseCode = true;
    	comboObj.LineColor = "#ffffff";
    	comboObj.SetColAlign("left|left");
    	comboObj.MultiSeparator = "|";	
    }
    
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) {
					// 높이 설정
					style.height = 142;
					// 전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					// Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					// 전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					// 전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					// 행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					// 컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(21, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, true, false, true, false,false)
					
					var HeadTitle = "|Seq.|POL|POL|POL|POD|POD|POD|VVD|Lane|POL ETD|POL ETD|POD ETA|POD ETA";
									
					// 해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
									
					// 데이터속성 [ROW, COL, DATATYPE, WIDTH, DATAALIGN,
					// COLMERGE, SAVENAME, KEYFIELD, CALCULOGIC, DATAFORMAT,
					// POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,
					// FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS,
					// FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,		"ibflag");					 
					InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,   false,    	"seq",     			false,          "",      dfNone,      	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		45,    	daCenter,   false,     	"pol_cd",     		false,          "",      dfNone,      	0,     true,       true,	5);
					InitDataProperty(0, cnt++ , dtData,      		25,    	daCenter,   false,     	"pol_yd_cd",     	false,          "",      dfNone,      	0,     true,       true,	2);
					InitDataProperty(0, cnt++ , dtCombo,   			30,    	daCenter,  	false,     	"pol_clpt_ind_seq",	false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,      		45,    	daCenter,   false,     	"pod_cd",    		false,          "",      dfNone,      	0,     true,       true,	5);
					InitDataProperty(0, cnt++ , dtData,      		25,    	daCenter,   false,     	"pod_yd_cd",     	false,          "",      dfNone,      	0,     true,       true,	2);
					InitDataProperty(0, cnt++ , dtCombo,   			30,    	daCenter,  	false,     	"pod_clpt_ind_seq",	false,          "",      dfNone,      	0,     true,       true);
					InitDataProperty(0, cnt++ , dtPopupEdit,    	100,    daCenter,   false,     	"bkg_vvd_cd",    	false,          "",      dfNone,      	0,     true,       true,	9);
					InitDataProperty(0, cnt++ , dtData,      		60,    	daCenter,   false,     	"slan_cd",     		false,          "",      dfNone,      	0,     false,     false);			 					
					InitDataProperty(0, cnt++ , dtData,      		70,    	daCenter,   false,     	"etd_day",     		false,          "",      dfDateYmd,   	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,   false,     	"etd_time",     	false,          "",      dfTimeHm,     	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,     		70,    	daCenter,   false,     	"eta_day",     		false,          "",      dfDateYmd,   	0,     false,     false);
					InitDataProperty(0, cnt++ , dtData,      		50,    	daCenter,   false,     	"eta_time",     	false,          "",      dfTimeHm,     	0,     false,     false);
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"pol_clpt_ind_seq_list");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"pod_clpt_ind_seq_list");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"vsl_pre_pst_cd");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"voyage_time");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"vsl_seq");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"etd");
					InitDataProperty(0, cnt++ , dtHidden,   		30,    	daCenter,  	false,     	"eta");
		 				 
					InitDataValid(0,  "bkg_vvd_cd",				vtEngUpOther,	"1234567890");		
					InitDataValid(0,  "pod_yd_cd",				vtEngUpOther,	"1234567890");		
					InitDataValid(0,  "pol_yd_cd",				vtEngUpOther,	"1234567890");		
					InitDataValid(0,  "pol_cd",					vtEngUpOther,	"1234567890");	
					InitDataValid(0,  "pod_cd",					vtEngUpOther,	"1234567890");	
					
					ScrollBar = 2;
					ShowButtonImage = 2;
					CountPosition = 0;		
				}
            break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, dataYn, isOpen) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:      //조회
           		formObj.f_cmd.value = SEARCH;
           		var params = FormQueryString(formObj);
           		params = params + "&dataYn=" +dataYn + "&" + ComGetSaveString(sheetObj);           		
           		var sXml = sheetObj.GetSearchXml("ESM_BKG_0092GS.do", params);
           		
           		var arrXml = sXml.split("|$$|");    
           		if(isOpen == "Y"){	
					for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
						if(sheetObj.CellValue(i, "bkg_vvd_cd") == formObj.bkgTrunkVvd.value){
							ComSetObjValue(formObj.trunkSeq, i);						
						}
					}
           		} else {
           			ComSetObjValue(formObj.trunkSeq, ComGetEtcData(arrXml[0],"trunk_seq"));
           		}

               	if(dataYn == "Y"){					
   					if (arrXml.length > 0){
   						sheetObj.LoadSearchXml(arrXml[1]);
   						for (var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
   							sheetObj.CellComboItem(i, "pol_clpt_ind_seq", sheetObj.CellValue(i,"pol_clpt_ind_seq_list"), sheetObj.CellValue(i,"pol_clpt_ind_seq_list"));
   							sheetObj.CellComboItem(i, "pod_clpt_ind_seq", sheetObj.CellValue(i,"pod_clpt_ind_seq_list"), sheetObj.CellValue(i,"pod_clpt_ind_seq_list"));
   						}
   						//combo까지 setting되면 sheet 처리 종료로 판단
   		    			openPop = "false";
   					}
   					if (arrXml.length > 0){
        				ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "desc");
        				ComBkgXml2ComboItem(arrXml[0], comboObjects[1], "val", "desc");			
   					}            	
   					if(ComGetEtcData(arrXml[0],"TRANS_RESULT_KEY") == "S"){
	   					formObj.n1st_eta_day.value  = ComGetEtcData(arrXml[0],"n1st_eta_day");
	   					formObj.n1st_eta_time.value = ComGetEtcData(arrXml[0],"n1st_eta_time");
	   					formObj.del_eta_day.value   = ComGetEtcData(arrXml[0],"del_eta_day");
	   					formObj.del_eta_time.value  = ComGetEtcData(arrXml[0],"del_eta_time");
   					}	    				
               	}else{
    				if (arrXml.length > 0){
    					ComBkgXml2ComboItem(arrXml[0], comboObjects[0], "val", "desc");
    					ComBkgXml2ComboItem(arrXml[0], comboObjects[1], "val", "desc");     					
    				}                    		
               	}
               	// 20091203 추가 - 화면 Open후 조회시 Lane이 없을때 처리
               	if(isOpen == "Y"){	  
               		var addFlag = false;
               		for(var i = sheetObj.HeaderRows; i < sheetObj.Rows ; i++ ){
               			if(sheetObj.CellValue(i, "slan_cd") == ""){
               				//open했을 때 yard가 다 있어야만 조회
	               			if(sheetObj.CellValue(i, "bkg_vvd_cd") != ""
		               				&& sheetObj.CellValue(i, "pol_yd_cd") != ""
			               			&& sheetObj.CellValue(i, "pod_yd_cd") != "" 
		               				&& !CheckPseudoVvd(sheetObj.CellValue(i, "bkg_vvd_cd"))){
	               				searchLaneEtaEtd(sheetObj, formObj, i, "bkg_vvd_cd");
		               			if(sheetObj.CellValue(i, "slan_cd") == ""){
		               				ComShowCodeMessage('BKG00078', sheetObj.CellValue(i, "pol_cd"), sheetObj.CellValue(i, "pod_cd"), sheetObj.CellValue(i, "bkg_vvd_cd"));
		        			   		sheetObj.CellValue2(i, "eta_day")  = "";
		        			   		sheetObj.CellValue2(i, "eta_time") = "";
		        			   		sheetObj.CellValue2(i, "etd_day")  = "";
		        			   		sheetObj.CellValue2(i, "etd_time") = "";
		        			   		sheetObj.CellValue2(i, "eta") = "";
		        			   		sheetObj.CellValue2(i, "etd") = "";
		               			}
	               			}	               				
               				addFlag = true;
               			}
               		}
               		if(addFlag){
	               		for(var i = sheetObj.RowCount; i < 4 ; i++ ){
	               			sheetObj.DataInsert(-1);
	               		}	               			
               		}
               	}
               	
               	comboObjects[0].InsertItem(0,"","");
               	comboObjects[1].InsertItem(0,"","");           	
                break;
                
            case IBSAVE:      //Validation을 SAVE로 처리
				formObj.f_cmd.value = MULTI;
				var params = FormQueryString(formObj);
				params = params + "&" + ComGetSaveString(sheetObj);
				sheetObj.DoSave("ESM_BKG_0092GS.do", FormQueryString(formObj), "", false);				
				break;                
        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj){
	    var rowCnt = sheetObj.Rows;    	 
		// 20100118 Row에 데이터가 없으면 삭제 후 Validation		 
		for(var k = rowCnt ; k >  sheetObj.HeaderRows; k--){
			if(ComTrim(sheetObj.CellValue(k, "pod_cd")) == "" && ComTrim(sheetObj.CellValue(k, "pol_cd")) == "" && ComTrim(sheetObj.CellValue(k, "bkg_vvd_cd")) == ""){
				sheetObj.RowDelete(k,false);
			}else{
				break;
			}
		}    		 
		var isBkgVvd = true;
		var lstPod = "";
		var isTrunkVvd = false;	// ,Row 체크시 TrunkVvd가 지났는지 여부 확인
   		for ( var i = sheetObj.HeaderRows ; i < rowCnt ; i++ ){
	   		if(sheetObj.CellValue(i, "pod_cd").length ==5 ) {
	   			lstPod = sheetObj.CellValue(i, "pod_cd");
	   		}
	   		 		
   			if(ComIsNull(sheetObj.CellValue(i, "seq"))){
   				continue;
   			}
   			 
   			// 01. POL,POD가 5자리인지 확인.
   			if(ComChkLen(sheetObj.CellValue(i, "pol_cd"),5) < 2 || ComChkLen(sheetObj.CellValue(i, "pod_cd"),5) < 2){
   				ComShowCodeMessage('BKG00137');
   				return false;
   			}
   			//부산 신항 관련 validation 제거(20091222 임종한 대리님 요청) 
   			// 02. POD가 'KRPUS'인 경우 YD가 2자리 입력되었는지 확인.
// if(sheetObj.CellValue(i, "pod_cd") == "KRPUS" &&
// ComChkLen(sheetObj.CellValue(i, "pod_yd_cd"),2) < 2){
// ComShowCodeMessage('BKG00808');
// return false;
// }
   			// 03. VVD의 자리수가 9자리인지 확인.
   			if(sheetObj.CellValue(i, "bkg_vvd_cd").length > 0 && ComChkLen(sheetObj.CellValue(i, "bkg_vvd_cd"),9) < 2){
   				ComShowCodeMessage('BKG00144', i);
   				return false;
   			}			  			 
   			// 05. 입력 VVD중 BKG_VVD가 없으면 에러.
/*
 * 20100119 추가 if(isBkgVvd && (sheetObj.CellValue(i, "bkg_vvd_cd") ==
 * formObj.bkgTrunkVvd.value)){ isBkgVvd = false; }
 */	   			 
   			// 06. 같은 Row에 POL/POD가 같으면 에러.
   			if(sheetObj.CellValue(i, "pod_cd") == sheetObj.CellValue(i, "pol_cd")){
   				// EGPSD 면 허용 // hard_coding 테이블 EQUAL_POL_POD 에도 추가해야 함 !!!
   				// SAJED 임시 허용 // 20140514 강정민 차장 긴급 요청
   				// BKG# SIN416330300 만 임시 허용 // 20140811 홍우리 대리 요청
   				if(sheetObj.CellValue(i, "pod_cd") != "EGPSD"
   					&& sheetObj.CellValue(i, "pod_cd") != "SAJED"
   					&& ComGetObjValue(formObj.bkg_no) != "SIN416330300" 
   					&& ComGetObjValue(formObj.bkg_no) != "SEL4A4265200"	){
   					ComShowCodeMessage('BKG00141');
   					return false;				 
   				}
   			}	 
//	   		 // 07. 같은 VVD가 두번이상 입력되면 에러. -> 제외(20100510 임종한 과장 요청)
// for ( j = 1 ; j < rowCnt ; j++ ){
// if(ComIsNull(sheetObj.CellValue(j, "seq"))){
// continue;
// }
// if(i != j){
// if(sheetObj.CellValue(i, "bkg_vvd_cd") == sheetObj.CellValue(j,
// "bkg_vvd_cd")){
// ComShowCodeMessage('BKG00145');
// return false;
// }
// }
// }
   			 // location, vvd가 있는데 etd, eta가 조회되지 않으면 error
//				 if(ComTrim(sheetObj.CellValue(i, "pod_cd")).length == 5 
//					 && ComTrim(sheetObj.CellValue(i, "pol_cd")).length == 5 
//					 && ComTrim(sheetObj.CellValue(i, "bkg_vvd_cd")).length == 9){
//		   			 if(ComIsNull(sheetObj.CellValue(i, "etd_day"))||ComIsNull(sheetObj.CellValue(i, "eta_day"))){
//		   				 if(sheetObj.CellValue(i, "bkg_vvd_cd").substring(0, 4)!="HJXX"
//		   					 &&sheetObj.CellValue(i, "bkg_vvd_cd").substring(0, 4)!="HJYY"
//		   					 &&sheetObj.CellValue(i, "bkg_vvd_cd").substring(0, 4)!="HJZZ"){
//		   					 ComShowCodeMessage("BKG00078", sheetObj.CellValue(i, "pol_cd")+"("+sheetObj.CellText(i, "pol_clpt_ind_seq")+")", 
//		   							 						sheetObj.CellValue(i, "pod_cd")+"("+sheetObj.CellText(i, "pod_clpt_ind_seq")+")", 
//		   							 						sheetObj.CellValue(i, "bkg_vvd_cd"));
//			   				 return false;
//		   				 }
//		   			 }	
//				 }
   			if(sheetObj.CellValue(i, "vsl_pre_pst_cd") == "T"){
   				isTrunkVvd = true;
   			}
   			 
   			// 08. 마지막 POD가 BKG POD와 동일하면 다음Row는 무시
   			if(i+1 < rowCnt && ComIsNull(sheetObj.CellValue(i+1, "pod_cd")) && sheetObj.CellValue(i, "pod_cd") == formObj.pod_loc_cd.value){
   				for(j = rowCnt ; j >  i; j--){
   					sheetObj.RowDelete(j,false);
   				}
   				break;
   			}
   			//vvd가 있는데 ETD가 없으면 return false
   			if (!ComIsEmpty(sheetObj.CellValue(i, "bkg_vvd_cd")) && ComIsEmpty(sheetObj.CellValue(i, "etd_day"))) {
   				ComShowCodeMessage('BKG02082');
   				return false;
   			}
   		}	   			   		 

		// 04. 최종 POD가 BKG_POD와 다르면 에러.
		if(lstPod.length == 5){
			if(lstPod != formObj.pod_loc_cd.value){
				ComShowCodeMessage('BKG00146', formObj.pod_loc_cd.value); 
				return false; 
			} 
		}
   		// 09. caFlg가 'Y'가 아니고 Row가 5 이상 이면 에러.
   		if(formObj.ca_flg.value != 'Y' && sheetObj.RowCount > 4){
   			ComShowCodeMessage('BKG00145');
   			return false;
   		}
   		//5라인(이상)부터 VVD 있을때 POL, POD의 yard, clptSeq에 대한 필수 여부 확인
		if (formObj.ca_flg.value == 'Y' && sheetObj.RowCount > 4){
   			for (var i=5; i<=sheetObj.RowCount; i++) {
				if (!ComIsEmpty(sheetObj.CellValue(i,"bkg_vvd_cd"))) {
					sheetObj.CellValue2(i,"pod_clpt_ind_seq") = sheetObj.CellText(i,"pod_clpt_ind_seq");
//alert(
//sheetObj.CellText(i,"pol_yd_cd")+"\n"+
//sheetObj.CellText(i,"pol_clpt_ind_seq")+"\n"+
//sheetObj.CellText(i,"pod_yd_cd")+"\n"+
//sheetObj.CellText(i,"pod_clpt_ind_seq")+"\n\n"+
//sheetObj.CellValue(i,"pol_yd_cd")+"\n"+
//sheetObj.CellValue(i,"pol_clpt_ind_seq")+"\n"+
//sheetObj.CellValue(i,"pod_yd_cd")+"\n"+
//sheetObj.CellValue(i,"pod_clpt_ind_seq")+"\n"+
//"");
   					if (ComIsEmpty(sheetObj.CellValue(i,"pol_yd_cd"))) {
	   					ComShowCodeMessage("BKG00104","POL Yard Code (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pol_yd_cd");
	   					return false;
   					}
                    if (ComIsEmpty(sheetObj.CellValue(i,"pol_clpt_ind_seq"))) {
	   					ComShowCodeMessage("BKG00104","POL Clpt Ind Seq (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pol_clpt_ind_seq");
	   					return false;
                    }
                    if (ComIsEmpty(sheetObj.CellValue(i,"pod_yd_cd"))) {
	   					ComShowCodeMessage("BKG00104","POD Yard Code (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pod_yd_cd");
	   					return false;
                    }
                    if (ComIsEmpty(sheetObj.CellValue(i,"pod_clpt_ind_seq"))) {
                    	ComShowCodeMessage("BKG00104","POD Clpt Ind Seq (Row : "+i+")");
	   					sheetObj.SelectCell(i,"pod_clpt_ind_seq");
                    	return false;
                    }
   				}
   			}
		}
		
		// 신규 생성 일 때, 
		if(formObj.bkg_no.value == "" && formObj.ca_flg.value != 'Y'){
			var befEta = "";
			var befVvd = "";
			for (var i=0; i<=sheetObj.RowCount; i++) {
				if(befEta!="" && sheetObj.CellValue(i,"etd_day")!=""){
					if(ComGetDaysBetween(befEta, sheetObj.CellValue(i,"etd_day")) > 40){
						ComShowCodeMessage('BKG08338',sheetObj.CellValue(i,"bkg_vvd_cd"),befVvd);
			   			return false;
					}
				}
				befEta = sheetObj.CellValue(i,"eta_day");
				befVvd = sheetObj.CellValue(i,"bkg_vvd_cd");
			}
		}
		
		return true;
    }
     
	// 최초 로딩시 데이터를 셋팅한다.
	function setDetaultSetting(sheetObj, formObj){
		var parentObj = window.dialogArguments.document.form;
		
		formObj.por_loc_cd.value = parentObj.bkg_por_cd.value;
		formObj.por_nod_cd.value = parentObj.bkg_por_yd_cd.value;
		formObj.pol_loc_cd.value = parentObj.bkg_pol_cd.value;
		formObj.pol_nod_cd.value = parentObj.bkg_pol_yd_cd.value;
		formObj.pod_loc_cd.value = parentObj.bkg_pod_cd.value;
		formObj.pod_nod_cd.value = parentObj.bkg_pod_yd_cd.value;
		formObj.del_loc_cd.value = parentObj.bkg_del_cd.value;
		formObj.del_nod_cd.value = parentObj.bkg_del_yd_cd.value;
		
		var orgTrnsModCd = parentObj.org_trns_mod_cd.value;
		var destTrnsModCd = parentObj.dest_trns_mod_cd.value;
		comboObjects[0].Code2 = orgTrnsModCd;
		comboObjects[1].Code2 = destTrnsModCd;
	}
	
	// New버튼 클릭시 처리.
	function clearOceanRoute(sheetObj, formObj){    		
   		formObj.n1st_eta_day.value = "";
   		formObj.n1st_eta_time.value = "";
   		formObj.del_eta_day.value = "";
   		formObj.del_eta_time.value = "";    
   		
   		sheetObj.RemoveAll();
   		 
   		sheetObj.DataInsert(-1);
   		sheetObj.DataInsert(-1);
   		sheetObj.DataInsert(-1);
   		sheetObj.DataInsert(-1);
   		sheetObj.DataInsert(-1);
   		sheetObj.CellValue2(1, "seq") = "First";
   		sheetObj.CellValue2(2, "seq") = "Second";
   		sheetObj.CellValue2(3, "seq") = "Third";
   		sheetObj.CellValue2(4, "seq") = "Forth";
   		sheetObj.CellValue2(5, "seq") = "Fifth";
   		 
   		sheetObj.CellValue2(1, "pol_cd") = formObj.pol_loc_cd.value;
   		sheetObj.CellValue2(1, "pol_yd_cd") = formObj.pol_nod_cd.value;
   		sheetObj.CellValue2(1, "pod_cd") = formObj.pod_loc_cd.value;
   		sheetObj.CellValue2(1, "pod_yd_cd") = formObj.pod_nod_cd.value;
	} 	
	
	// Popup내용을 Main으로 돌려준다.
	function setParentToPopup(sheetObj, formObj){		
		setVslPrePostCd();
		var parentObj = window.dialogArguments.document.form;
		 
		// 1. Sheet의 내용을 내려준다.
	 	var parentRefSheet;
	 	if (formObj.callSheetIdx.value !=""){
	 		parentRefSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx.value]);
	 	}else{
	 		// Booking Creation
	 		parentRefSheet =window.dialogArguments.sheetObjects[1];
	 	} 		
	 	parentRefSheet.RemoveAll();
        for ( i = 1 ; i < sheetObj.Rows ; i++ ){
            var iRow = parentRefSheet.DataInsert(-1);
            
            for(j = 0 ; j <= sheetObj.LastCol ; j++){
           	 	if ( sheetObj.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
           	 		for(k=0 ; k <= parentRefSheet.LastCol ; k ++){
                       if ( parentRefSheet.ColSaveName(k) == sheetObj.ColSaveName(j)){
                    	   if(parentRefSheet.ColSaveName(k)=="pol_clpt_ind_seq"||parentRefSheet.ColSaveName(k)=="pod_clpt_ind_seq"){
                    		   parentRefSheet.CellValue( iRow, parentRefSheet.ColSaveName(k)) = sheetObj.CellText( i , sheetObj.ColSaveName(j)) ;
                    	   } else {
                    		   parentRefSheet.CellValue( iRow, parentRefSheet.ColSaveName(k)) = sheetObj.CellValue( i , sheetObj.ColSaveName(j)) ;
                    	   }
                       }                        
           	 		}
           	 	}
            }
 		}	
        
		// 2. TransMode를 설정한다.
		parentObj.org_trns_mod_cd.value = comboObjects[0].Code;
		parentObj.dest_trns_mod_cd.value = comboObjects[1].Code;
		
		window.close();
		var calllFunc = formObj.calllFunc.value;
		if(calllFunc != ''){
			eval('window.dialogArguments.'+calllFunc)();
		}		
	}
	
	// 조회가 끝나면 VslPrePostCd를 재설정한다.
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		if(ErrMsg == ""){
			setVslPrePostCd(); 			
		}
	}
	
	// 조회가 끝나면 VslPrePostCd를 재설정한다.
	function sheet1_OnSaveEnd(sheetObj, ErrMsg){
		if(ErrMsg == ""){
			setParentToPopup(sheetObj, document.form);
		}
	}
	
	// POL,POD,VVD 편집후 LANE/ETD/ETA를 조회한다.
  	function sheet1_OnChange(sheetObj, Row, Col){
		//최초 pop-up시에는 기저장된 data를 우선으로 조회한다.
		if(openPop == "true"){
			return;
		}
		var colName = sheetObj.ColSaveName(Col);
		var formObj = document.form;
		var parentObj = window.dialogArguments.document.form;
		var flg =false;
		if(colName == "pol_cd" || colName == "pol_yd_cd" 
			|| colName == "pod_cd" || colName == "pod_yd_cd"  
			|| colName == "bkg_vvd_cd"){
			if(parentObj.pgm_no.value == "ESM_BKG_0079_01" || parentObj.pgm_no.value == "ESM_BKG_0229_01"){
				ComSetObjValue(parentObj.aloc_chk_flg,"Y");
			}
	 		if(colName == "pod_cd"){
	 			sheetObj.CellValue2(Row, "pod_yd_cd") = "";
	 			sheetObj.CellComboItem(Row, "pod_clpt_ind_seq", "", "");
	 			sheetObj.CellValue2(Row, "pod_clpt_ind_seq") = " ";
	 			if(sheetObj.CellValue(Row, Col) != formObj.pod_loc_cd.value){
	 				// 편집한 Row가 마지막이면 Row 추가
	 				if(sheetObj.RowCount == Row){
	 					addRow = sheetObj.DataInsert(-1);
	 					sheetObj.CellValue2(addRow, "pol_cd") = sheetObj.CellValue(Row, Col);
	 				}else{
	 					sheetObj.CellValue2(Row+1, "pol_cd") = sheetObj.CellValue(Row, Col);
	 				}
	 				//sheetObj.CellValue2(Row+1, "pol_cd") = sheetObj.CellValue(Row, Col);    	 				
	 			}    	 
	 			setCheckTsCloseFlag("Y");
	 		}else if(colName == "bkg_vvd_cd"){
	 			if(sheetObj.CellValue(Row, Col) == formObj.bkgTrunkVvd.value){
	 				for ( i = 1 ; i < sheetObj.Rows ; i++ ){
	 					sheetObj.CellValue2(i, "vsl_pre_pst_cd" ) = "";
	 				}
	 				sheetObj.CellValue2(Row, "vsl_pre_pst_cd" ) = "T";
	 				
	 				setPrePstSeq(sheetObj);
	 			}
	 			setCheckTsCloseFlag("Y");
	 		}else if(colName == "pol_cd"){
	 			sheetObj.CellValue2(Row, "pol_yd_cd") = "";    	 	
	 			sheetObj.CellComboItem(Row, "pol_clpt_ind_seq", "", "");
	 			sheetObj.CellValue2(Row, "pol_clpt_ind_seq") = " ";
	 		}else if(colName == "pol_yd_cd"){
	 			if(sheetObj.CellSearchValue(Row, Col) != sheetObj.CellValue(Row,Col)){
	 				sheetObj.CellValue2(Row,"pol_clpt_ind_seq") = "";
	 			}
	 		}else if(colName == "pod_yd_cd"){
	 			if(sheetObj.CellSearchValue(Row, Col) != sheetObj.CellValue(Row,Col)){
	 				sheetObj.CellValue2(Row,"pod_clpt_ind_seq") = "";
	 			}    	 			
	 		}   	 		

			if(	sheetObj.CellValue(Row, "pol_cd").length > 0 && 
	 			sheetObj.CellValue(Row, "pod_cd").length > 0 &&
	 			sheetObj.CellValue(Row, "bkg_vvd_cd").length > 0){    	 			
	 			searchLaneEtaEtd(sheetObj, formObj, Row, colName);
	 			
	 			if(Row<sheetObj.Rows){
					if(sheetObj.CellValue(Row, "pod_cd")!=formObj.pod_loc_cd.value){
		 				sheetObj.CellValue2(Row + 1, "pol_cd") = sheetObj.CellValue(Row, "pod_cd");
		 				sheetObj.CellValue2(Row + 1, "pol_yd_cd") = sheetObj.CellValue(Row, "pod_yd_cd");
		 				sheetObj.CellValue2(Row + 1, "pol_clpt_ind_seq") = "";
			 			searchLaneEtaEtd(sheetObj, formObj, Row+1, "pol_cd");
					}
	 			}
	 		}
    		if(	sheetObj.CellValue(Row, "pol_cd").length < 1 ||
	 			sheetObj.CellValue(Row, "pod_cd").length< 1 ||	
	 			sheetObj.CellValue(Row, "bkg_vvd_cd").length < 1){
	 			
	 			sheetObj.CellValue2(Row, "slan_cd") = "";
	 			sheetObj.CellValue2(Row, "etd_day") = "";
	 			sheetObj.CellValue2(Row, "etd_time") = "";
	 			sheetObj.CellValue2(Row, "eta_day") = "";
	 			sheetObj.CellValue2(Row, "eta_time") = "";
	 		}
		}    
	} 	 	
	
	function sheet1_OnComboChange(sheetObj, Row, Col, Text) {
		var formObj = document.form;
		var colName = sheetObj.ColSaveName(Col);
		if(Text==""){
			return;
		}
 		if(colName == "pol_clpt_ind_seq"){
 			sheetObj.CellValue2(Row, "pol_yd_cd") = "";
 		} else if(colName == "pod_clpt_ind_seq"){
 			sheetObj.CellValue2(Row, "pod_yd_cd") = "";
 		}
 		searchLaneEtaEtd(sheetObj, formObj, Row, colName);
		if(Row<sheetObj.Rows){
			if(sheetObj.CellValue(Row, "pod_cd")!=formObj.pod_loc_cd.value){
 				sheetObj.CellValue2(Row + 1, "pol_cd") = sheetObj.CellValue(Row, "pod_cd");
 				sheetObj.CellValue2(Row + 1, "pol_yd_cd") = sheetObj.CellValue(Row, "pod_yd_cd");
 				sheetObj.CellValue2(Row + 1, "pol_clpt_ind_seq") = "";
	 			searchLaneEtaEtd(sheetObj, formObj, Row+1, "pol_cd");
			}
		}
	}

	// POD/POL/VVD 편집시
	function searchLaneEtaEtd(sheetObj, formObj, Row, colNm){
		if(	sheetObj.CellValue(Row, "pol_cd").length > 0 
				&& sheetObj.CellValue(Row, "pod_cd").length > 0 
				&& sheetObj.CellValue(Row, "bkg_vvd_cd").length > 0){
	   		formObj.f_cmd.value = SEARCH01;
	   		var params = FormQueryString(formObj);
       		params = params + "&edit_row=" + Row + "&" + ComGetSaveString(sheetObj);
       		
	   		var sXml = sheetObj.GetSearchXml("ESM_BKG_0092GS.do", params);

	   		if (ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq_list")) || ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq_list"))) {
		   		sheetObj.CellValue2(Row, "eta_day")  = "";
		   		sheetObj.CellValue2(Row, "eta_time") = "";
		   		sheetObj.CellValue2(Row, "etd_day")  = "";
		   		sheetObj.CellValue2(Row, "etd_time") = "";
		   		sheetObj.CellValue2(Row, "eta") = "";
		   		sheetObj.CellValue2(Row, "etd") = "";
	   		} else {
	   			if(ComGetEtcData(sXml,"trunk_seq") != ""){
	   				ComSetObjValue(formObj.trunkSeq, ComGetEtcData(sXml,"trunk_seq"));
	   			}else{
	   				ComSetObjValue(formObj.trunkSeq, "1");
	   			}
		   		sheetObj.CellValue2(Row, "slan_cd") 	= (ComIsNull(ComGetEtcData(sXml,"slan_cd")))	?"":ComGetEtcData(sXml,"slan_cd");
				sheetObj.CellComboItem(Row, "pol_clpt_ind_seq", ComGetEtcData(sXml,"pol_clpt_ind_seq_list"), ComGetEtcData(sXml,"pol_clpt_ind_seq_list"));
				sheetObj.CellComboItem(Row, "pod_clpt_ind_seq", ComGetEtcData(sXml,"pod_clpt_ind_seq_list"), ComGetEtcData(sXml,"pod_clpt_ind_seq_list"));

				sheetObj.CellValue2(Row, "pol_yd_cd") 	= (ComIsNull(ComGetEtcData(sXml,"pol_yd_cd")))	?"":ComGetEtcData(sXml,"pol_yd_cd");
				sheetObj.CellValue2(Row, "pol_clpt_ind_seq") = (ComIsNull(ComGetEtcData(sXml,"pol_clpt_ind_seq")))?"":ComGetEtcData(sXml,"pol_clpt_ind_seq");
		   		sheetObj.CellValue2(Row, "pod_yd_cd") 	= (ComIsNull(ComGetEtcData(sXml,"pod_yd_cd")))	?"":ComGetEtcData(sXml,"pod_yd_cd");
				sheetObj.CellValue2(Row, "pod_clpt_ind_seq") = (ComIsNull(ComGetEtcData(sXml,"pod_clpt_ind_seq")))?"":ComGetEtcData(sXml,"pod_clpt_ind_seq");

		   		// 조회한 결과를 담는다.
		   		sheetObj.CellValue2(Row, "eta_day") 	= (ComIsNull(ComGetEtcData(sXml,"eta_day")))	?"":ComGetEtcData(sXml,"eta_day");
		   		sheetObj.CellValue2(Row, "eta_time") 	= (ComIsNull(ComGetEtcData(sXml,"eta_time")))	?"":ComGetEtcData(sXml,"eta_time");
		   		sheetObj.CellValue2(Row, "etd_day") 	= (ComIsNull(ComGetEtcData(sXml,"etd_day")))	?"":ComGetEtcData(sXml,"etd_day");
		   		sheetObj.CellValue2(Row, "etd_time") 	= (ComIsNull(ComGetEtcData(sXml,"etd_time")))	?"":ComGetEtcData(sXml,"etd_time");
		   		sheetObj.CellValue2(Row, "eta") 		= (ComIsNull(ComGetEtcData(sXml,"eta")))		?"":ComGetEtcData(sXml,"eta");
		   		sheetObj.CellValue2(Row, "etd") 		= (ComIsNull(ComGetEtcData(sXml,"etd")))		?"":ComGetEtcData(sXml,"etd");
		   		setVslPrePostCd();
	   		}
		}
	}
	
	// Trunk Code 셋팅
	function setVslPrePostCd(){
		var formObj = document.form;
		var sheetObj = sheetObjects[0];
		var zint = ComParseInt(ComGetObjValue(formObj.trunkSeq));
		sheetObj.CellValue2(zint, "vsl_pre_pst_cd") = "T";
		for ( j = 1 ; j < sheetObj.Rows ; j++ ){
			if(j < ComGetObjValue(formObj.trunkSeq)){
  				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "S";
			} else if(j > ComGetObjValue(formObj.trunkSeq)){
  				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "U";
			}
		}
		setPrePstSeq(sheetObj);	
	}
	
	// Seq 정렬
	function setPrePstSeq(sheetObj){
       // Seq 셋팅
       	var isPre = true;
       	var prePostIdx = 1;
       	for ( j = 1 ; j < sheetObj.Rows ; j++ ){        	   
       		if(sheetObj.CellValue(j, "pol_cd").length==0
   				&&sheetObj.CellValue(j, "pod_cd").length==0
   				&&sheetObj.CellValue(j, "bkg_vvd_cd").length==0){
       			continue;
    		}
      		if(sheetObj.CellValue(j, "vsl_pre_pst_cd") != "T"){
      			if(isPre){
      				sheetObj.CellValue2(j, "seq") = "Pre" + prePostIdx;
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "S";
      				sheetObj.CellValue2(j, "vsl_seq") = prePostIdx;
      				prePostIdx++;
      			}else{
      				sheetObj.CellValue2(j, "seq") = "Post" + prePostIdx;
      				sheetObj.CellValue2(j, "vsl_pre_pst_cd") = "U";
      				sheetObj.CellValue2(j, "vsl_seq") = prePostIdx;
      				prePostIdx++;	        				 
      			}
      		}else{
      			sheetObj.CellValue2(j, "seq") = "Trunk";
      			sheetObj.CellValue2(j, "vsl_seq") = "0";
      			isPre = false;
      			prePostIdx = 1;
      		}
 		}	   		
	}	

	function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		if(sheetObj.ColSaveName(NewCol) == "pod_yd_cd"){
			if(NewRow == sheetObj.Rows-1){
       			if(sheetObj.CellValue(sheetObj.Rows-1, "pod_cd") == ""){
    				sheetObj.SelectCell(sheetObj.Rows-1, "pod_cd", false);
       			}	        				
			}		
		}
	}

    // VVD Popup 호출
 	function sheet1_OnPopupClick( sheetObj, Row, Col ){
 		comBkgCallPop0019(	"setBkg0019Popup",
 										sheetObj.CellValue(Row, "bkg_vvd_cd"),
 										sheetObj.CellValue(Row, "pol_cd"),
 										sheetObj.CellValue(Row, "pod_cd"));
 	}

    function bkg0092_click(){
    	var formObj = document.form;
    	var srcName = window.event.srcElement.getAttribute("name");
    	
    	if(srcName == "mnl_tvvd_flg"){
    		if(ComIsNull(formObj.bkgTrunkVvd.value)){
    			ComShowCodeMessage("BKG00058", formObj.bkgTrunkVvd.value);
    			return false;
    		}
    		var foundTvvd = "false";
    		for (var i = sheetObjects[0].HeaderRows ; i < sheetObjects[0].Rows ; i++ ){
				if(sheetObjects[0].CellValue(i, "bkg_vvd_cd") == formObj.bkgTrunkVvd.value){
					foundTvvd = "true";
					ComSetObjValue(formObj.trunkSeq, i);
					setVslPrePostCd();
				}
			}
    		if("false" == foundTvvd){
    			ComShowCodeMessage("BKG00022", formObj.bkgTrunkVvd.value);
    			return false;
    		}
    	}
    	else if(srcName == "cust_ntc_flg"){
    		if(ComGetObjValue(formObj.cust_ntc_flg) == "Y"){
    			ComOpenPopup("ESM_BKG_1176.do?pgmNo=ESM_BKG_1176", 300, 200, "","1,0,1,1,1", true);
    		} else {
    			ComSetObjValue(formObj.vsl_cng_rsn, "");
    		}
    	}    		
    }
    
	// VVD PopUp 호출뒤 Return 받는 값.
	function setBkg0019Popup(arrVal){
		sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pol_cd") = arrVal[0][4] ;
		if(arrVal[0][5] != null && arrVal[0][5].length > 5){
			sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pol_yd_cd") = arrVal[0][5].substring(5) ;
		}
		sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pod_cd") = arrVal[0][12] ;
		if(arrVal[0][13] != null && arrVal[0][13].length > 5){
			sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "pod_yd_cd") = arrVal[0][13].substring(5) ;
		}    		
		sheetObjects[0].CellValue( sheetObjects[0].SelectRow, "bkg_vvd_cd") = arrVal[0][3] ;
		
		searchLaneEtaEtd(sheetObjects[0], document.form, sheetObjects[0].SelectRow, "bkg_vvd_cd");
	}	
	
	// port skip flg 세팅 추가 2012.01.05 kbj
	// customer notice flag 세팅 추가 2013.10.14 dyryu
	function setRouteDetailFlag(formObj){
		var parentObj = window.dialogArguments.document.form;
		if(parentObj.port_skp_flg != null) {
   			if(formObj.port_skp_flg.checked){
   				parentObj.port_skp_flg.value = formObj.port_skp_flg.value;
   			}else{
   				parentObj.port_skp_flg.value = '';
   			}
		}
		if(ComGetObjValue(formObj.cust_ntc_flg) == "Y"){
			parentObj.cust_ntc_flg.value = formObj.cust_ntc_flg.value;
			parentObj.vsl_cng_rsn.value = formObj.vsl_cng_rsn.value;
		} else {
			parentObj.cust_ntc_flg.value = "N";
			parentObj.vsl_cng_rsn.value = "";
		}
	}
	
	// Check T/S Close Flag 세팅 추가 20130402 DYR
	function setCheckTsCloseFlag(flag){
		var parentObj = window.dialogArguments.document.form;
		parentObj.check_ts_close_flag.value = flag;
	}
	
	/* 개발자 작업  끝 */