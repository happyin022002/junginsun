/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0726.js
*@FileTitle : Group Update for B/L Issue And Onboard Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.07.15 김영출
* 1.0 Creation
=========================================================
 History
 2012.03.30 서미진 [CHM-201217003] on board type 부재시 BL Issue 버튼 Disable
 2012.09.11 이준근 [CHM-201219948-01] B/L Issue 시 or SeaWayBill, Surrender 시 Validation 추가
 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
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
     * @class ESM_BKG_0726 : ESM_BKG_0726 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0726() {
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
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1 = sheetObjects[0];
         /*******************************************************/
         var formObject = document.form;

    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_Retrieve":
						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
	
					case "btn_New":
						sheetObject1.RemoveAll();
						formObject.reset();
					break;
						
					case "btn_Save":
						formObject.chkd_iss.value = 'N';
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
					case "btn_SaveIssue":
						var selRows = sheetObject1.FindCheckedRow("sel");
						
						// Check Issue Date!!
						var arr = ComFindText(sheetObject1, "sel", 1);
						for (i=0; i<arr.length; i++) {
							if(sheetObject1.CellValue(arr[i], "obl_iss_dt_sd") == '' || sheetObject1.CellValue(arr[i], "bl_obrd_dt_sd") == ''){
								ComShowMessage(ComGetMsg("COM12193", "Issue Date (should) and Onboard Date (should)"));
								return;
							}
							//Check BL data (m&d, customer, rate, container)
							if(sheetObject1.CellValue(arr[i], "ob_info_iss_rdy_flg") != 'Y'){
//								ComShowCodeMessage("BKG08084");
								ComShowCodeMessage("BKG95114");
								return;
							}
						}
						
						// 2012.03.30 서미진 [CHM-201217003] on board type 부재시 BL Issue 버튼 Disable	
						for(i = 2; i<sheetObject1.RowCount+2; i++){
							if(sheetObject1.CellValue(i, "ibflag") != "" && sheetObject1.CellValue(i, "ibflag") != "R" ){
								if(sheetObject1.CellValue(i, "bl_obrd_tp_cd") == "" ){
									sheetObject1.RowBackColor( i ) = sheetObject1.RgbColor(255, 0, 0);  // RED
									ComShowCodeMessage("BKG08224");
									return;
								}
							}
						}
						
						// POD CD 에 따른 Validation
						if(!validateByPodCd("B")) {
							return;
						}
						
//						// 이미 ISSUE 된거는 제거한다.
//						for (i=0; i<arr.length; i++) {
//							if(sheetObject1.CellValue(arr[i], "obl_iss_flg") =='Y'){
//								sheetObject1.CellValue(arr[i], "sel") = "N";
//							}		
//						}						
						
						formObject.chkd_iss.value = 'Y';
						doActionIBSheet(sheetObject1, formObject, IBSAVE);
					break;
					
					case "btn_DownExcel":
						sheetObject1.Down2Excel(-1);
					break;
					
					case "btn_faxEml":

						if(sheetObject1.SearchRows==0){
							ComShowCodeMessage("BKG08328");
							return;
						}
						ComOpenWindowCenter("/hanjin/ESM_BKG_0218_01.do?ui_id=ESM_BKG_0726", "ESM_BKG_0218_01", 1110, 650, true);
					break;
					
						
					case "btn_Print":
						var url = "ESM_BKG_0889.do";
						ComOpenWindowCenter(url, "ESM_BKG_0889", 400, 300, false);
					break;
						
					case "btn_Select":
						var sRowStr = sheetObject1.GetSelectionRows("|");
						//alert("sRowStr : " + sRowStr);
						var arr = sRowStr.split("|");
						for (i=0; i<arr.length; i++) {
							//if(arr[i] == '') continue;
							var rlsFlg = sheetObject1.CellValue(arr[i], "obl_rlse_flg");
							if(rlsFlg == 'Y'){
								ComShowMessage(ComGetMsg('BKG00328'));
								continue;
							}else{
								sheetObject1.CellValue2(arr[i], "sel") = 1;
							}
						}
					break;
						
					case "btn_Deselect":
						var sRowStr = sheetObject1.GetSelectionRows("|");
						var arr = sRowStr.split("|");
						for (i=0; i<arr.length; i++) {
							sheetObject1.CellValue2(arr[i], "sel") = 0;
						}
					break;
						
					case "btn_AdjustDate":
						var selRows = sheetObject1.FindCheckedRow("sel");
						var callbackFunc = "callbackAdjustDate";
						
						if(selRows == ""){
							ComShowMessage(ComGetMsg('BKG00323'));
						} else {
							var eta = formObject.act_arr_dt.value;
							var etd = formObject.act_dep_dt.value;
							var url = "";
							if(formObject.vvd.value !=""){
								if(eta == '' || etd == ''){
									alert("ETA/ETD 필요함!!");
									return;
								}
								url = "ESM_BKG_0740.do?func=" + callbackFunc + "&eta=" + eta + "&etd=" + etd;
							}else{
								url = "ESM_BKG_0740.do?func=" + callbackFunc;
							}

//							alert(url);
							ComOpenWindowCenter(url, "ESM_BKG_0740", 380, 270, true);
						}
					break;
					
					case "btn_SWBRelease":
						// POD CD 에 따른 Validation
						if(!validateByPodCd("W")) {
							return;
						}
						
						doActionIBSheet(sheetObject1, formObject, MULTI01);
					break;
				
					case "btn_BlPrint":
						var params = "";
						
						var bkgNos = "";
						var arrRow = ComFindText(sheetObject1, "swb_sel", 1);
						if (arrRow && 0 < arrRow.length) {
							for ( var i = 0; i < arrRow.length; i++) {
								bkgNos += sheetObject1.CellValue(arrRow[i], "bkg_no") + ",";
							}
							if (0 < bkgNos.indexOf(",")){
								bkgNos = bkgNos.substring(0, bkgNos.length - 1);
							}
							if (1000 < bkgNos.split(",").length) {
								ComShowCodeMessage("BKG08124", 1000); // You select more
																		// than {?msg1} B/Ls
																		// for B/L print.
																		// Max is {?msg1}
																		// B/Ls one time
								return;
							}
							for( var j = 0; j< arrRow.length; j++){
							
								var blType = sheetObject1.CellValue(arrRow[j], "bl_tp_cd");
								var obl_iss_flg = sheetObject1.CellValue(arrRow[j], "obl_iss_flg");
								
								if("W" != blType || "N" == obl_iss_flg){
									ComShowCodeMessage('BKG08092');
									return;
								}
							}
							
						} else {
							ComShowCodeMessage("COM12176");
							return false;
						}
						var formObject2 = document.form2;
						var width = 925;
						var height = 370;
						var left = (screen.width-width)/2;
						var top = (screen.height-height)/2;
						
						ComOpenWindow("", "PopupEsmBkg074301", "width="+width+",height="+height+",left="+left+",top="+top+",scrollbars=no", false);
						
						formObject2.bkg_no.value = bkgNos;
						formObject2.param_ui_id.value = "ESM_BKG_0726";
						
						formObject2.action = "/hanjin/ESM_BKG_0743_01.do";
						formObject2.target = "PopupEsmBkg074301";
						formObject2.submit();
						break;
						
						
					case "btns_calendar":
						var cal = new ComCalendarFromTo();
						cal.select(formObject.bkg_from_dt, formObject.bkg_to_dt,'yyyy-MM-dd');
						break;
						
					case "btn_blComplete":
						var oblSelRows = sheetObject1.FindCheckedRow("sel");
						var swbSelRows = sheetObject1.FindCheckedRow("swb_sel");
						// Check Issue Date!!
						if(oblSelRows == "" && swbSelRows==""){
							ComShowMessage(ComGetMsg('BKG00323'));
						}else{
							var oblArr = ComFindText(sheetObject1, "sel", 1);
							if (oblArr && 0 < oblArr.length) {
								for (i=0; i<oblArr.length; i++) {
									//Check BL data (m&d, customer, rate, container)
									if(sheetObject1.CellValue(oblArr[i], "ob_info_iss_rdy_flg") != 'Y'){
										ComShowCodeMessage("BKG95114");
										return;
									}
								}
							}
							var swbArr = ComFindText(sheetObject1, "swb_sel", 1);
							if (swbArr && 0 < swbArr.length) {
								for (i=0; i<swbArr.length; i++) {
									//Check BL data (m&d, customer, rate, container)
									if(sheetObject1.CellValue(swbArr[i], "ob_info_iss_rdy_flg") != 'Y'){
										ComShowCodeMessage("BKG95114");
										return;
									}
								}
							}
							doActionIBSheet(sheetObject1, formObject, MULTI02);
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

            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
             
        }
		// set init data
		if(document.form.vvd.value != '' && document.form.pol_cd.value != '') {
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		}
		// add listener
		axon_event.addListenerForm('focus', 'form1_focus', document.form);
		axon_event.addListenerForm('blur', 'form1_blur', document.form);
		axon_event.addListenerForm('keypress', 'form1_keypress', document.form);
		axon_event.addListenerForm('change', 'form1_change', document.form);
		
		fnSearch0726BlprnUsr();
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
						style.height = 420;
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
						
						//var HeadTitle1 = "|Seq.||SWB|BKG No.|B/L No.|B/L TYPE|BL\nComplete|Issue|Release|SHIPPER CD|SHIPPER NAME|On Board Date|On Board Date|On Board Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|PPD||";
						var HeadTitle1 = "|Seq.||SWB|BKG No.|B/L No.|POD|DEL|B/L TYPE|BL\nComplete|BL Data\nComplete\nB/L TYPE|Issue|Release|Release\nType|Contact Email\n(S/I Contact)|Freight Term\n(PPD-Org.)|B/L Remark|SHPR Code|SHPR Name|CNEE Code|CNEE Name|FWDR Code|FWDR Name|On Board Date|On Board Date|On Board Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|B/L Issue Date|PPD|cust_to_ord_flg|flg_rate|flg_md|flg_ppd|flg_do|do_iss_dt|bl_rcv_tp|bl_rcv_at|pol_etd_dt|cgo_rcv_dt|obl_srnd_flg|bl_iss_no||||pol_eta_dt|ob_info_iss_rdy_flg";
						var HeadTitle2 = "|Seq.||SWB|BKG No.|B/L No.|POD|DEL|B/L TYPE|BL\nComplete|BL Data\nComplete\nB/L TYPE|Issue|Release|Release\nType|Contact Email\n(S/I Contact)|Freight Term\n(PPD-Org.)|B/L Remark|SHPR Code|SHPR Name|CNEE Code|CNEE Name|FWDR Code|FWDR Name|Type|Now|Should|Now|Should|AT|BY|PPD|pol_eta_dt|ob_info_iss_rdy_flg";
						var headCount = ComCountHeadTitle(HeadTitle1);

						//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
						InitColumnInfo(headCount, 0, 0, true);
						
						// 해더에서 처리할 수 있는 각종 기능을 설정한다
						InitHeadMode(true, true, true, true, false,false);
						
						//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]			
						InitHeadRow(0, HeadTitle1, true);
						InitHeadRow(1, HeadTitle2, true);
						
                        //데이터속성    [ROW, COL,   DATATYPE,       WIDTH, DATAALIGN, COLMERGE, SAVENAME,         KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                        InitDataProperty(0,  cnt++,  dtHiddenStatus, 30,    daCenter,  true,     "ibflag");
                        InitDataProperty(0,  cnt++,  dtSeq,          30,    daCenter,  true,     "seq");
                        InitDataProperty(0,  cnt++,  dtDummyCheck,   30,    daCenter,  true,     "sel",             false,    "",         dfNone,     0,          true,        true);
                        InitDataProperty(0,  cnt++,  dtDummyCheck,   60,    daCenter,  true,     "swb_sel",         false,    "",         dfNone,     0,          true,        true);
                        InitDataProperty(0,  cnt++,  dtData,         90,    daLeft,    true,     "bkg_no",          false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         90,    daLeft,    true,     "bl_no",           false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,       	 50,    daCenter,  true,     "pod_cd",          false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,       	 50,    daCenter,  true,     "del_cd",    	    false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "bl_tp_cd",        false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "bl_rdy_flg",      false,    "",         dfNone,     0,          false,       false, 0, 0, false);
                        InitDataProperty(0,  cnt++,  dtData,         80,    daCenter,  true,     "bl_rdy_tp_cd",        false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "obl_iss_flg",     false,    "",         dfNone,     0,          false,       false, 0, 0, false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "obl_rlse_flg",    false,    "",         dfNone,     0,          false,       false, 0, 0, false);
                        
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "ir_bl_type",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         160,   daLeft,    true,     "cntc_pson_eml",   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         80,    daCenter,  true,     "org_ppd_rcv_cd",  false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         160,   daLeft,    true,     "obl_iss_rmk",     false,    "",         dfNone,     0,          false,       false);
                    
                        InitDataProperty(0,  cnt++,  dtData,         80,    daCenter,  true,     "cust_cd",         false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         200,   daLeft,    true,     "cust_nm",         false,    "",         dfNone,     0,          false,       false);
                        
                        InitDataProperty(0,  cnt++,  dtData,         80,    daCenter,  true,     "cnee_cd",         false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         200,   daLeft,    true,     "cnee_nm",         false,    "",         dfNone,     0,          false,       false);
                        
                        InitDataProperty(0,  cnt++,  dtData,         80,    daCenter,  true,     "fwdr_cd",         false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         200,   daLeft,    true,     "fwdr_nm",         false,    "",         dfNone,     0,          false,       false);
                        
						InitDataProperty(0,  cnt++,  dtData,         40,    daCenter,  true,     "bl_obrd_tp_cd",   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "bl_obrd_dt",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "bl_obrd_dt_sd",   false,    "",         dfNone,     0,          false,       false);

                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "obl_iss_dt",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         70,    daCenter,  true,     "obl_iss_dt_sd",   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "obl_iss_ofc_cd",  false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtData,         60,    daCenter,  true,     "obl_iss_usr_id",  false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       10,    daCenter,  true,     "credit_chk",      false,    "",         dfNone,     0,          false,       false);

                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "cust_to_ord_flg",false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "flg_rate",       false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "flg_md",         false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "flg_ppd",        false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "flg_do",         false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "do_iss_dt",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "bl_rcv_tp",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "bl_rcv_at",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "pol_etd_dt",     false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "cgo_rcv_dt",     false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "obl_srnd_flg",   false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "bl_iss_no",      false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtCheckBox,   	 0,   	 daCenter,  true,     "swb_hidden_sel", false,    "",         dfNone,     0,          true,        true);                        
                        InitDataProperty(0,  cnt++,  dtHidden,       140,    daCenter,  true,     "pod_cd",     	false,    "",         dfNone,     0,          false,       false);
                        InitDataProperty(0,  cnt++,  dtHidden,       60,     daCenter,  true,     "ppd_rcv_ofc_cd", false,    "",         dfNone,     0,          false,       false);                                              
                        InitDataProperty(0,  cnt++,  dtHidden,       60,     daCenter,  true,     "pol_eta_dt", 	false,    "",         dfNone,     0,          false,       false);
                        
                        InitDataProperty(0,  cnt++,  dtHidden,         90,    daLeft,    true,     "ob_info_iss_rdy_flg",          false,    "",         dfNone,     0,          false,       false);
                        
                        ColHidden('swb_hidden_sel') = true; 
                        
                        CountPosition = 2;

                        //InitDataCombo(0, "obl_rlse_flg", "Y|N", "Y|N");
                        //InitDataCombo(0, "bl_obrd_tp_cd", "L\tLADEN ON BOARD THE VESSEL|S\tSHIPPED ON BOARD|R\tRECEIVED FOR SHIPMENT|O\tON BOARD|A\tON BOARD THE RAIL|B\tON BOARD THE BARGE|T\tON BOARD THE TRUCK", "L|S|R|O|A|B|T");

                        AutoRowHeight  = false;
						EditableColorDiff = false;
					}
				break;


			}
	}

  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value = SEARCH;
					sheetObj.DoSearch4Post("ESM_BKG_0726GS.do", FormQueryString(formObj)); 

					formObj.act_arr_dt.value = (sheetObj.EtcData("act_arr_dt")==undefined || sheetObj.EtcData("act_arr_dt")=="null") ? "" : sheetObj.EtcData("act_arr_dt").substring(0, 10);
					formObj.act_dep_dt.value = (sheetObj.EtcData("act_dep_dt")==undefined || sheetObj.EtcData("act_dep_dt")=="null") ? "" : sheetObj.EtcData("act_dep_dt").substring(0, 10);

					for(ir=sheetObj.HeaderRows;ir<=sheetObj.LastRow;ir++){
						if(sheetObj.CellValue(ir, "obl_rlse_flg") == 'Y'){
							sheetObj.CellEditable(ir, "sel") = false;
						}
						if(sheetObj.CellValue(ir, "obl_iss_flg") == 'Y' || sheetObj.CellValue(ir, "obl_rlse_flg") == 'Y'){
							//sheetObj.RowEditable(ir) = false;
							sheetObj.CellEditable(ir, "sel") = false;
							sheetObj.CellBackColor(ir, "sel") = sheetObj.RgbColor(235, 235, 235);
							//sheetObj.CellEditable(ir, "swb_sel") = true;
							//sheetObj.CellBackColor(ir, "swb_sel") = sheetObj.RgbColor(235, 235, 235);
						}	
					}
					var blNoStr = "";
					for(ir=sheetObj.HeaderRows;ir<=sheetObj.LastRow;ir++) {
						
						var obl_srnd_flg = sheetObj.CellValue(ir, "obl_srnd_flg");
						var iss_flg = sheetObj.CellValue(ir, "obl_iss_flg");
						var rel_flg = sheetObj.CellValue(ir, "obl_rlse_flg");
						var flg_do = sheetObj.CellValue(ir, "flg_do");
						var bl_obrd_tp_cd = sheetObj.CellValue(ir, "bl_obrd_tp_cd");
						var bl_tp_cd = sheetObj.CellValue(ir,"bl_tp_cd");
						
						/**
						 *[O/BL Release, SWB Release 활성 조건 ]
						 *(1. Issued = 'Y', 2. Released = 'N', 3. not Surrender (BKG_BL_ISS.OBL_SRND_FLG = 'N') , 4. DO not Issue)
						 */
						if ("Y" == iss_flg && "N" == rel_flg && "N" == obl_srnd_flg && ("N" ==flg_do || "L" == bl_obrd_tp_cd)) {
						
						} else {
							sheetObj.CellEditable(ir, "swb_sel") = false;
							sheetObj.CellBackColor(ir, "swb_sel") = sheetObj.RgbColor(235, 235, 235);
						}

						/**
						 Surrender = 'Y' or D/O ='Y'
						**/
						if( "Y" == flg_do && "L" !=bl_obrd_tp_cd) {	
							sheetObj.CellEditable(ir, "swb_sel") = false;
							sheetObj.CellBackColor(ir, "swb_sel") = sheetObj.RgbColor(235, 235, 235);
						}
						 /* Korea 지역인 경우 B/L Print 버튼 활성화 및 SWB 출력 가능 하도록 변경 */
						 if ("Y" == document.form.swbPntFlg.value && 
							 "W" == bl_tp_cd && "Y" == iss_flg && 
							 "Y" == rel_flg && 
							 "N" == obl_srnd_flg && 
							 ("N" ==flg_do || "L" == bl_obrd_tp_cd)) {
							 sheetObj.CellEditable(ir, "swb_sel") = true;
//							 sheetObj.CellBackColor(ir, "swb_sel") = sheetObj.RgbColor(235, 235, 235);
						 }
						 if(ir!=sheetObj.LastRow)
							 blNoStr = blNoStr + sheetObj.CellValue(ir,"bl_no")+",";
						 else
							 blNoStr = blNoStr + sheetObj.CellValue(ir,"bl_no");
						 
						 
						 //iss 필요조건(Mnd,Cntr,Cust 정보 유) 에 해당하는 행은 노란색으로 표기
						 if(sheetObj.CellValue(ir,"ob_info_iss_rdy_flg")=="Y"){
						 	sheetObj.RowBackColor (ir) = sheetObj.RgbColor(255, 255, 0);
						 	if(sheetObj.CellEditable(ir, "swb_sel")==false){
						 		sheetObj.CellBackColor(ir , "swb_sel") = sheetObj.RgbColor(235, 235, 235);
						 	}else{
						 		sheetObj.CellBackColor(ir , "swb_sel") = sheetObj.RgbColor(255, 255, 255);
						 	}
						 }

					}		
					formObj.blNoStr.value = blNoStr;
				}
			
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value = MULTI;
//					sheetObj.DoSave("ESM_BKG_0726GS.do", FormQueryString(formObj), -1, false, true);
					var sParam = FormQueryString(formObj);
					// Sheet1 param
					var sParamSheet1 = sheetObjects[0].GetSaveString();
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}					
					//alert(sParam);
					var rXml = sheetObj.GetSaveXml("ESM_BKG_0726GS.do", sParam);
					var rMsg = ComResultMessage(rXml);
					if(rMsg == ''){
						if(formObj.chkd_iss.value == 'Y'){
							var arr = ComFindText(sheetObj, "sel", 1);
							for (i=0; i<arr.length; i++) {
								sheetObj.CellValue2(arr[i], "obl_iss_flg") = 'Y';								
								sheetObj.CellEditable(arr[i], "sel") = false;
								sheetObj.CellValue(arr[i], "sel") = "N";
								sheetObj.CellBackColor(arr[i], "sel") = sheetObj.RgbColor(235, 235, 235);
								
								sheetObj.CellEditable(arr[i], "swb_sel") = true;
								sheetObj.CellBackColor(arr[i], "swb_sel") = sheetObj.RgbColor(255, 255, 255);
																
								// credit 이 체크되어 있으면 FLG_PPD 의 값을 변경한다.
								if(sheetObj.CellValue(arr[i], "credit_chk") ='Y') {
									sheetObj.CellValue(arr[i], "flg_ppd") = 'N';
								}
								
							}
						}
						sheetObj.LoadSaveXml("<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA/><MESSAGE/></RESULT>");
						// show message
						ComShowMessage(ComGetMsg("BKG00166"));
					} else {
						//alert(rMsg.split('<||>').join('\n'));
						ComShowMessage(rMsg);
					}	
				}
			break;
			
			case MULTI01:
				if(validateForm(sheetObj,formObj,sAction)) {
					//doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}				
			break;
			
			case MULTI02:
				formObj.f_cmd.value = MULTI02;
				var sParamSheet1 = sheetObjects[0].GetSaveString(false,true, "sel");
				var sParamSheet2 = sheetObjects[0].GetSaveString(false,true, "swb_sel");
				
				if (sParamSheet1 != "") {
					sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_')+"&f_cmd="+formObj.f_cmd.value;
				}
				if (sParamSheet2 != "") {
					sParam = sParam + "&sheet1_" + sParamSheet2.replace(/&/g, '&sheet1_')+"&f_cmd="+formObj.f_cmd.value;
				}
//				sheetObj.CellValue(idxArr[ir], "swb_hidden_sel") = "N";
				
				var sXml = sheetObj.GetSaveXml("ESM_BKG_0726GS.do", sParam);	
				
				// 저장후 결과처리
				var state = ComGetEtcData(sXml,"isSuccess");
				if(state=='Y'){
					ComShowMessage(ComGetMsg("BKG06071"));
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}else{
					ComShowMessage(ComGetMsg('BKG06014'));
				}
        }
    }



    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        switch(sAction) {

			case IBSEARCH:      //조회
				with(formObj){
					if((vvd.value == '' || vvd.value.length != 9) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00320'));
						vvd.select();
						return false;
					}
					if((trunk_vvd.value != '' && trunk_vvd.value.length != 9) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00058',trunk_vvd.value));
						trunk_vvd.select();
						return false;
					}
				if((pol_cd.value == '' || pol_cd.value.length != 5) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00321'));
						pol_cd.select();
						return false;
					}
				}
			break;
			
			case IBSAVE:        //저장
				with(formObj){
					if((vvd.value == '' || vvd.value.length != 9) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00320'));
						vvd.select();
						return false;
					}
					if((pol_cd.value == '' || pol_cd.value.length != 5) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00321'));
						pol_cd.select();
						return false;
					}
					
					
					if(chkd_iss.value == 'Y'){
						var sParamSheet1 = sheetObjects[0].GetSaveString(false, true, "sel");
						
						if (sParamSheet1 != "") {
							sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
						}
						var rXml = sheetObj.GetSaveXml("ESM_BKG_0726GS.do",  "f_cmd=" + SEARCH01 + "&" +sParam);
						var valResult = ComGetEtcData(rXml, "err_msg");
			        	if(valResult != ''){
			        		ComShowMessage(ComGetMsg('BKG95094', valResult ));
//			        		return false;
			        	}
					}
				}
				/*
				// Should 값에 ETA -3 , ETD + 3 의 범위를 벗어나는지 확인 - 넘어가는 BKG가 있을 경우 메시지 [BKG00385] 표시하고 리턴
				var eta = formObj.act_arr_dt.value;
				var etd = formObj.act_dep_dt.value;
				var sRow = sheetObj.FindStatusRow("U");
				var arRow = sRow.split(";");
				//alert("arRow : " + arRow);
				for (ir=0; ir<arRow.length; ir++) {
					if(arRow[ir] == '') continue;
					var obd_dt = sheetObj.CellValue(arRow[ir], "bl_obrd_dt_sd");
					var iss_dt = sheetObj.CellValue(arRow[ir], "obl_iss_dt_sd");
			
					//alert(arRow[ir]+">" + sheetObj.CellValue(arRow[ir], "seq") + " " +eta + " " +etd + " " +obd_dt + " " +iss_dt);
					var etaArr = eta.split("-"); 
					var etdArr = etd.split("-");
					var obdArr = obd_dt.split("-");
					var issArr = iss_dt.split("-");
					
					if( etaArr.length != 3 || etdArr.length != 3 || obdArr.length != 3 || issArr.length != 3){
						//alert("날짜 형식이 잘못되었습니다.");
						//return false;
						continue;
					}
					
					var etaDt = new Date(Number(etaArr[0]),Number(etaArr[1])-1,Number(etaArr[2]));
					var etdDt = new Date(Number(etdArr[0]),Number(etdArr[1])-1,Number(etdArr[2]));
					var obdDt = new Date(Number(obdArr[0]),Number(obdArr[1])-1,Number(obdArr[2]));
					var issDt = new Date(Number(issArr[0]),Number(issArr[1])-1,Number(issArr[2]));
					
					var etaInt = Math.floor(etaDt.valueOf()/(24*60*60*1000)-3);
					var etdInt = Math.floor(etdDt.valueOf()/(24*60*60*1000)+3);
					var obdInt = Math.floor(obdDt.valueOf()/(24*60*60*1000));
					var issInt = Math.floor(issDt.valueOf()/(24*60*60*1000));
			
					//alert(obdInt + " < " +etaInt+ " = " + (obdInt < etaInt) +"\n"+ obdInt + " > " +etdInt+ " = " + ( obdInt > etdInt));
					if(obdInt < etaInt || obdInt > etdInt){
						ComShowMessage(ComGetMsg('BKG00385'));
						sheetObj.SelectCell(arRow[ir], "bl_obrd_dt_sd");
						return false;
					}
					// ISSUE date 의 경우 onboard 보다 큰지 여부만 check
					//alert(issInt + " < " +etaInt+ " = " + (issInt < etaInt) +"\n"+ issInt + " > " +etdInt+ " = " + (issInt > etdInt));
					//if(issInt < etaInt || issInt > etdInt){
					//	ComShowMessage(ComGetMsg('BKG00385'));
					//	sheetObj.SelectCell(arRow[ir], "obl_iss_dt_sd");
					//	return false;
					//}
				}
				*/
			break;
				
			case MULTI01:        //SWB				
				// 체크된 row 만큼 loop
				with(formObj){
					if((vvd.value == '' || vvd.value.length != 9) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00320'));
						vvd.select();
						return false;
					}
					if((pol_cd.value == '' || pol_cd.value.length != 5) && bkg_no.value == ''){
						ComShowMessage(ComGetMsg('BKG00321'));
						pol_cd.select();
						return false;
					}
				}
			
				// 1. 체크박스에 체크되었는지 확인
				var notice_flg = false;
				
				var selRows = sheetObj.FindCheckedRow("swb_sel");
			  
				if (selRows.length == 0){
					// 알람 메시지 변경 요
					ComShowMessage(ComGetMsg("BKG00249"));
					return false;
				}
				
				var idxArr = selRows.split("|");						
	
				for (ir=0;ir<idxArr.length;ir++) {
					if(idxArr[ir] == '') {
						continue;
					}
				
					var cust_to_ord_flg = sheetObj.CellValue(idxArr[ir], "cust_to_ord_flg");
					var flg_rate = sheetObj.CellValue(idxArr[ir], "flg_rate");
					var flg_md = sheetObj.CellValue(idxArr[ir], "flg_md");
					var flg_ppd = sheetObj.CellValue(idxArr[ir], "flg_ppd");
					var flg_do = sheetObj.CellValue(idxArr[ir], "flg_do");
					var bl_rcv_tp = sheetObj.CellValue(idxArr[ir], "bl_rcv_tp");
					var bl_tp_cd = sheetObj.CellValue(idxArr[ir], "bl_tp_cd");
					var bkg_no = sheetObj.CellValue(idxArr[ir], "bkg_no");
					var do_iss_dt = sheetObj.CellValue(idxArr[ir], "do_iss_dt");
					var blType = sheetObj.CellValue(idxArr[ir], "bl_tp_cd");
					var obl_iss_flg = sheetObj.CellValue(idxArr[ir], "obl_iss_flg");
					var obl_rlse_flg = sheetObj.CellValue(idxArr[ir], "obl_rlse_flg");
					// 1. cust_to_ord_flg = 'Y'  이면  ComShowCodeMessage("BKG00469");
					
					if ('W' == blType){
						ComShowCodeMessage('BKG00474');
						return false;
					}
					if (cust_to_ord_flg == 'Y') {
						ComShowMessage(ComGetMsg('BKG00469', " ("+bkg_no+")" ));
						return false;
					}
					
					// 2 FLG_RATE != "Y" 이면, ComShowCodeMessage("BKG08078");
					if (flg_rate != 'Y') {
						ComShowMessage(ComGetMsg('BKG08078', " ("+bkg_no+")" ));
						return false;
					}
	
					// 3   FLG_MD != "Y" 이면, ComShowCodeMessage("BKG08077");
					if (flg_md != 'Y') {
						ComShowMessage(ComGetMsg('BKG08077', " ("+bkg_no+")" ));
						return false;
					}
					
					// 4   FLG_MD == "Y" 이면, ComShowCodeMessage("BKG08079");
					if (flg_ppd == 'Y') {
						ComShowMessage(ComGetMsg('BKG08079', " ("+bkg_no+")" ));
						return false;
					}
					
					// 5. DO_ISS_DT == N (null) and  NVL(O_BLRECEIVE_TYPE , DECODE(NVL(O_BLRECEIVE_AT, '*'), '*', BKG_BOOKING.BL_TP_CD, NVL(BKG_BOOKING.BL_TP_CD, 'B'))) ) = "L" 이면ComShowCodeMessage("BKG00434");
					if (do_iss_dt == 'N') {
						if (bl_rcv_tp == "L") {
							ComShowMessage(ComGetMsg('BKG00434', " ("+bkg_no+")" ));
							return false;							
						} else if (bl_rcv_tp =="" &&  bl_tp_cd == "L") {
							ComShowMessage(ComGetMsg('BKG00434', " ("+bkg_no+")" ));
							return false;					
						}						
					}					
					
					// 6. booking_no 로 This customer is blacklisted customer. Pls contact Sales Office for BKG allowance
					if(!fnExistBlackListedCustomer(bkg_no)){
						//return false; // 경고표시만 하고 진행하도록 수정
					}
					
					
					// 7.  date가 null인  경우는  비교하지말것 
					var on_board_date = sheetObj.CellValue(idxArr[ir], "bl_obrd_dt");					
					var on_board_type = sheetObj.CellValue(idxArr[ir], "bl_obrd_tp_cd");					
					var pol_etd_dt = sheetObj.CellValue(idxArr[ir], "pol_etd_dt");
					var cgo_rcv_dt = sheetObj.CellValue(idxArr[ir], "cgo_rcv_dt");
					
					if (!notice_flg) { 
						if ('' != on_board_date) {
							if (('L' == on_board_type || 'S' == on_board_type) && (pol_etd_dt!= on_board_date)) {
								if (!ComShowConfirm(ComGetMsg("BKG00467", " ("+bkg_no+")" ))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
										return false;
								} else {
									notice_flg= true;
								}
							} else if ('R' == on_board_type && (cgo_rcv_dt != on_board_date)) {
								if (!ComShowConfirm(ComGetMsg("BKG08137", " ("+bkg_no+")" ))){// On board Date is not same as actual vessel schedule (ETA/ETD). Do you want to continue?";
										return false;
								} else {
									notice_flg= true;
								}
							}
						}
					}
					// 8. 현재 B/L 상태가 Normal issue 상태가 아니면 SWB Release 를 진행 하지 않는다.
					if("W" == blType || "N" == obl_iss_flg || "Y" == obl_rlse_flg){
						ComShowCodeMessage('BKG00474');
					}
					
					// 모든 validate 체크가 끝났으면 release 실행.					
					ComSetObjValue(formObj.f_cmd, MULTI01);
					var sParam = FormQueryString(formObj);		
					
					
					// 한 row씩 보내기 위해 히든컬럼에 현재 row를 체크를 한다.
					sheetObj.CellValue(idxArr[ir], "swb_hidden_sel") = "Y";
					
					// auto setting
					sheetObjects[0].CellValue(idxArr[ir] , "obl_iss_flg") ="Y";
					sheetObjects[0].CellValue(idxArr[ir] , "obl_rlse_flg") ="Y";
					sheetObjects[0].CellValue(idxArr[ir] , "bl_tp_cd") ="W";
					sheetObjects[0].CellValue(idxArr[ir] , "bl_rcv_tp") ="W";
					sheetObjects[0].CellValue(idxArr[ir] , "bl_iss_no") ="0";
					
					var sParamSheet1 = sheetObjects[0].GetSaveString(false,true, "swb_hidden_sel");
					if (sParamSheet1 != "") {
						sParam = sParam + "&sheet1_" + sParamSheet1.replace(/&/g, '&sheet1_');
					}	
					sheetObj.CellValue(idxArr[ir], "swb_hidden_sel") = "N";
					
					var sXml = sheetObj.GetSaveXml("ESM_BKG_0726GS.do", sParam);	
					
					// 저장후 결과처리
					var errFlg = ComGetEtcData(sXml,"TRANS_RESULT_KEY");
					if ( errFlg !="S" ) {	
						var rMsg = ComGetEtcData(sXml,"Exception")
						var rmsg = sXml.split("<||>");
						if(rmsg[3] != undefined && rmsg[3].length > 0) {
							var spl = rmsg.length-2;
							ComShowMessage(rmsg[spl]+ " ("+bkg_no+")");
						}
						return false;
					}else{					
						sheetObjects[0].CellValue(idxArr[ir] , "obl_rlse_flg") ="Y";
						sheetObjects[0].CellValue(idxArr[ir] , "swb_sel") ="N";
						
						// 릴리즈 되었으므로 체크박스를 비활성화 시킨다.
						if("Y" == document.form.swbPntFlg.value && 
						   "W" == sheetObjects[0].CellValue(idxArr[ir] , "bl_tp_cd") &&
						   "Y" == sheetObjects[0].CellValue(idxArr[ir] , "obl_rlse_flg")){
							sheetObjects[0].CellEditable(idxArr[ir] , "swb_sel") = true;
						}else{
							sheetObjects[0].CellEditable(idxArr[ir] , "swb_sel") = false;
						}
						sheetObjects[0].CellBackColor(idxArr[ir] , "swb_sel") = sheetObj.RgbColor(235, 235, 235);
					}
					
				}
				// 모든 처리 정상
				return true;

			break;
        }
        return true;
    }
     
     /**
      * 1. POD가 UY, CO, EC인 경우 B/L Type B만 선택 가능
      *    다른 Type 선택 시 ‘Only Original B/L can be issued, because of Customs Regulation.’ 문구 처리
      * 2. POD가 BR인 경우
      *     B/L Issue Date와 On Board Date가 다른 상태에서 B/L Issue 시 ‘For the shipment destined to Brazil, the On Board Data and B/L Issue Date should be same. Please check the date once again.’ 문구 처리
      */
     function validateByPodCd(chkBlType) {
    	var selRows;
    	if(chkBlType == "B") {
			selRows = sheetObjects[0].FindCheckedRow("sel");
		}
		else if(chkBlType == "W") {
			selRows = sheetObjects[0].FindCheckedRow("swb_sel");
		}
		
		var idxArr = selRows.split("|");
		
		var chkPodCd = "";
		for (ir=0;ir<idxArr.length;ir++) {
			if(idxArr[ir] == '') {
				continue;
			} else {
				// 해당 BkgNo가 하드코딩 테이블에 있으면 체크하지 않는다.
				if(checkBkgHrdCdgCtnt(sheetObjects[0], document.form, "BKG", sheetObjects[0].CellValue(idxArr[ir], "bkg_no"), ""))
					return true;
				
				chkPodCd = sheetObjects[0].CellValue(idxArr[ir], "pod_cd");
				if(chkPodCd != null) {
					var boolW = checkBkgHrdCdgCtnt(sheetObjects[0], document.form, "CNT", chkPodCd.substr(0,2), "W");
					var  chkW  = "";
					if(boolW) chkW = "W";
					
					var boolS = checkBkgHrdCdgCtnt(sheetObjects[0], document.form, "CNT", chkPodCd.substr(0,2), "S");
					var  chkS  = "";
					if(boolS) chkS = "S";
					
					if(chkBlType == chkW || chkBlType == chkS) {
						// 선택한 row 체크 해제
						sheetObjects[0].SelectCell(idxArr[ir], 1);
						
						ComShowMessage(ComGetMsg("BKG08242", ""));
						return false;
					}

					if(!checkBkgHrdCdgCtnt(sheetObjects[0], document.form, "DATE", chkPodCd.substr(0,2), "")) {
						if(sheetObjects[0].CellValue(idxArr[ir], "bl_obrd_dt_sd") != sheetObjects[0].CellValue(idxArr[ir], "obl_iss_dt_sd")) {
							// 선택한 row 체크 해제
							//sheetObjects[0].CellValue(idxArr[ir], "sel")  = "N";
							sheetObjects[0].SelectCell(idxArr[ir], 1);
							
							ComShowMessage(ComGetMsg("BKG08243", ""));
							return;
						}
					}
				}
			}
		}
		
		return true;
     }
	
	/* ----------------------------------------------------------------------------
	 * Event 처리
	 -----------------------------------------------------------------------------*/
	function form1_focus(){
		//ComClearSeparator(event.srcElement);
	}
	
	function form1_blur(){
//		ComChkObjValid(event.srcElement);

		switch (event.srcElement.name) {

		case "bkg_from_dt":
			event.srcElement.value = ComGetMaskedValue(event.srcElement, "ymd");
			break;
		case "bkg_to_dt":
			event.srcElement.value = ComGetMaskedValue(event.srcElement, "ymd");
			break;

		}
		
	}

	function form1_keypress(){
		if (event.srcElement.type == "text" && event.keyCode == 13 ) {
   			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
				if(keyValue >= 97 && keyValue <= 122){                  //소문자
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
		
		var srcName = event.srcElement.getAttribute("name");
		switch(srcName){
			case "ob_date":
			break;
		}
	}
	
	function callbackAdjustDate(ob_date, issue_date, ussue_at, ussue_by, credit_chk, ppd_rcv_ofc_cd){
		//alert(ob_date+"\n"+issue_date+"\n"+ussue_at+"\n"+ussue_by+"\n"+credit_chk);
		var sheetObj = sheetObjects[0];
		var selRows = sheetObj.FindCheckedRow("sel");
		var idxArr = selRows.split("|");
		for(ix=0;ix<idxArr.length;ix++){
			if(idxArr[ix] == '') continue;
			//alert(idxArr[ix] + ". " + sheetObj.CellValue(idxArr[ix], "bl_obrd_dt_sd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_dt_sd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_ofc_cd") + " " + sheetObj.CellValue(idxArr[ix], "obl_iss_usr_id"));
			if(ob_date != '')    sheetObj.CellValue2(idxArr[ix], "bl_obrd_dt_sd")  = ob_date;
			if(issue_date != '') sheetObj.CellValue2(idxArr[ix], "obl_iss_dt_sd")  = issue_date;
			if(ussue_at != '')   sheetObj.CellValue2(idxArr[ix], "obl_iss_ofc_cd") = ussue_at;
			if(ussue_by != '')   sheetObj.CellValue2(idxArr[ix], "obl_iss_usr_id") = ussue_by;
			if(credit_chk != '') sheetObj.CellValue2(idxArr[ix], "credit_chk")     = credit_chk;
			if(ppd_rcv_ofc_cd != '') sheetObj.CellValue2(idxArr[ix], "ppd_rcv_ofc_cd")     = ppd_rcv_ofc_cd;
			if(sheetObj.CellValue(idxArr[ix], "bl_obrd_tp_cd") == ""){
				sheetObj.CellValue2(idxArr[ix], "bl_obrd_tp_cd")     = "L";
			}
			
		} 
		//alert(idxArr.length + " lines OK ");
	}
	
	
	/**
	 * fnExistBlackListedCustomer  
	 * booking_no 로 This customer is blacklisted customer. Pls contact Sales Office for BKG allowance
	 * param :_val
	 */	 
	 function fnExistBlackListedCustomer(bkg_no) {
		 var sheetObj = sheetObjects[0];
		 var param = "&f_cmd=" + COMMAND02 + "&input_text=" +bkg_no;
		 var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
		 var cust_cd = ComGetEtcData(sXml, "cust_cd");;
		 var rls_ctrl_rsn = ComGetEtcData(sXml, "rls_ctrl_rsn");;
		 var ar_ofc = ComGetEtcData(sXml, "ar_ofc");;
		 var srep_nm = ComGetEtcData(sXml, "srep_nm");
		 
		 if (cust_cd != null && cust_cd != '') {
			 ComShowMessage(ComGetMsg("BKG08099", cust_cd
	                               ,"\n- Release Control Reason : " + rls_ctrl_rsn +
	                                "\n- Contact Sales or AR Office : " + ar_ofc + 
	                                "\n- Contact Sales Rep. : " + srep_nm));
			 return false;// Y이면 error
	 	}
		return true;
	 } 
	
	function checkBkgHrdCdgCtnt(sheetObj, formObj, attrCtnt1, attrCtnt2, attrCtnt3) {
		var formObj = document.form;
		formObj.f_cmd.value = SEARCH10;
			
		formObj.attrCtnt1.value = attrCtnt1;
		formObj.attrCtnt2.value = attrCtnt2;
		formObj.attrCtnt3.value = attrCtnt3;
			
		var sParam = FormQueryString(formObj); // hidden param value 문자열

		var sXml = sheetObj.GetSearchXml("ESM_BKG_0726GS.do", sParam);
			
		// Bkg Hard Coding 데이타 확인.
		State = ComGetEtcData(sXml,"BkgHrdCdgCtnt");
		if ( State != null && State == "Y" ) {
			return false;
		}
			
		return true;
	}
	
	/**
	* Login 한 User Check : 유저가 B/L Print 권한을 가지고 있는지 체크한다.(결과값이 Y:권한 유, N:권한 무)<br>
	*/
	function fnSearch0726BlprnUsr(){
		// 2.search
		var cfmFlg = "N";
		var param = "f_cmd=" + SEARCH13;
		var sXml = sheetObjects[0].GetSearchXml("ESM_Booking_UtilGS.do", param);
			
		cfmFlg = ComGetEtcData(sXml, "cfmFlg");
		
		// 3.output
		if( "N" == cfmFlg){
			eval('DIV_btn_BlPrint').style.display = 'none';
			document.form.swbPntFlg.value = "N"
		}else{
			eval('DIV_btn_BlPrint').style.display = 'block';
			document.form.swbPntFlg.value = "Y"
		}
	}
	
	
    // BKG_NO 입력 받는 메소드(POP UP 에서 호출한다.)
    function openAddPaste(bkgNo){
    	var formObj = document.form;
    	var bkg_no = formObj.bkg_no.value;
    	var _Width = '400';
		var _Height = '420';
//    	var newWin = window.showModalDialog("ESM_BKG_9457.do?bkg_no="+bkgNo, window, "scroll:no;status:no;resizable:yes;help:no;dialogWidth:400px;dialogHeight:400px");
    	var newWin = ComOpenWindow("ESM_BKG_9457.do?bkg_no="+formObj.bkg_no.value, "BKG_Win", "scroll:;dialogWidth:" + _Width + "px; dialogHeight:" + _Height + "px", true);
    }
	
    // Pop UP 에서 입력된 No 를 전달 받는다.
    function addValueNo(multi_value){
    	var multis = multi_value.split('\n');
     	multi_value = '';
    	for(var i = 0 ; i < multis.length ; i++){
			if(i == 0){
				multi_value = multis[i];
			}else{
				multi_value = multi_value + ',' + multis[i];
			}
   		}
    	if(multi_value != ''){
    		document.getElementById('bkg_no').value = multi_value;	
    	}
	}	
    
    //m&d, cntr, cust information이 다 있는 bkg all 체크
    function chkAllIssBkg(){
    	if(document.form.chk_all_iss_bkg.checked==true){
    		for(ir=sheetObjects[0].HeaderRows;ir<=sheetObjects[0].LastRow;ir++) {
    			if(sheetObjects[0].CellValue(ir,"ob_info_iss_rdy_flg")=="Y"){
    				if(sheetObjects[0].CellEditable(ir, "sel")==true)
    					sheetObjects[0].CellValue2(ir, "sel") = 1;
    				if(sheetObjects[0].CellEditable(ir, "swb_sel")==true)
    					sheetObjects[0].CellValue2(ir, "swb_sel") = 1;
    			}
    		}
    	} else {
    		for(ir=sheetObjects[0].HeaderRows;ir<=sheetObjects[0].LastRow;ir++) {
    			if(sheetObjects[0].CellValue(ir,"ob_info_iss_rdy_flg")=="Y"){
    				if(sheetObjects[0].CellEditable(ir, "sel")==true)
    					sheetObjects[0].CellValue2(ir, "sel") = 0;
    				if(sheetObjects[0].CellEditable(ir, "swb_sel")==true)
    					sheetObjects[0].CellValue2(ir, "swb_sel") = 0;
    			}
    		}
    	}
    }
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	if(document.form.usrOfcCd.value=="SELSC"){
    		ComBtnEnable("btn_blComplete");
    	}
    	else{
    		ComBtnDisable("btn_blComplete");
    	}
    }
	/* 개발자 작업  끝 */