/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0044.js
*@FileTitle : Allocation Control by Main Office
*Open Issues :
*@LastModifyDate : 2009.09.15
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.15 한상훈
* 1.0 Creation
* 
*Change history :
* 2008-02-18 김원섭 CSR : N200801300018 - Alloc 입력화면에서 History data 저장 
*    - Office/POL 레벨 Tree 모양 변경
*    - Office/POL 레벨 저장 가능하도록 상태(RowStatus) 변경 조정
*    - Forecast/Booking 저장 되도록 컬럼명 변경
*    - Trade/Sub Trade 컬럼 추가
* 2008-02-20 김원섭 CSR : N200802180011   Control Option 적용대상 변경
*   - IBSheet 컬럼 머지 기능 변경에 따라 기능 추가(msPrevColumnMerge + msHeaderOnly)
*   - Tree 컬럼 위치 변경
* 2008-03-04 김원섭 - Summarize 기능 개선
* 2008-04-11 서관영 CSR : N200803195497 - Split 01-T/S allocation 관련 SPC 화면 수정
*    Allocated?→?HO/RHQ?Alloc,?2)Allocation?→?Office?Alloc 
*    상단 HO/RHQ Alloc T/S 추가, NULL 이면 0 이 아닌 공백으로  표시
*    하단 Customer Guarantee 정보 삭제
*    하단 T/S Alloc Lane 체크 Query 주석 처리
*    하단 FCAST, Final Load QTY 정수로 표시
* CSR : N200804100009 - e-NIS 용어변경 (Allocated → HO/RHQ Alloc, Allocation → BB/BA Alloc)
* 2008-04-30 서관영 CSR : N200804280004 - aloc maximum 100000까지
* 2008-10-14 서관영 CSR : N200810020013 - Allocation Control 2/3차 화면의 remark 기능 추가요청
* 2008-10-29 임옥영 CSRNO:N200810240577 단축키 설정으로 인해 추가된 FUNCTION line 940이후부터 끝까지
* 2008-11-13 임옥영 CSR:N200811120012 -단축키 추가사항 반영(toggle 및 적용 화면추가, focus)
* 2008-12-12 CSR:N200812080003 Total TEU 컬럼 추가
* 2008-12-26 임옥영 CSR:N200812230019 BKG의 TEU->Total TEU로 변경
* 2010. 04. 05 CHOI.Y.S  - Booking Creation 화면에서 Inquiry by Sub Office 화면 Pop-up 사용 처리 로직 추가
* 2010.07.07 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171 [프로젝트] 53FT 관련 필드 추가
* 2010.08.03 CHOI.Y.S - Ticket ID : CHM-201005140-01 - Remark Hidden 처리 하면서 관련된 부분 주석처리.
* 2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완 - Remark 가능한 Office인지 체크하기
* 2011.07.05 이석준 [CHM-201111880] control by HO 화면 보완 - IPC, TS 관련  
* 2011.07.19 최성민 [선조치] 콤보 데이터 관련 수정                                        
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - CMB Trend 추가 / TTL 라인 COA 팝업 연결
* 2013.05.03 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - Save 후 상위 grid에 aloc 반영되도록 수정
* 2013.07.10 진마리아 [선처리] Temprory Input 팝업 호출 관련 수정
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완  - Sync/Desync 빼고 Yield Group, Fixed Edit 추가
* 2015.11.19 이혜민 [CHM-201538539] Allocation Control by Main office - Daily FCST Acct 화면 팝업 처리
* 2016.05.18 최성민 Double Callling Route(Port/Tmnl)에 대한 물량집계 및 병목상 Logic 보완 사항 요청
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
     * @class ESM_SPC_0044 : ESM_SPC_0044 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_SPC_0044() { 
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
    var comObjects = new Array();
    var sheetCnt = 0;
    var comboCnt = 0;

    //var sheetResizeFull = true;
    var sheetResizeCount = 2;

    var txtDelem = "|";
    var HeadTail = "";
    //var HeadTypeSize = "|TEU|20'|40'|HC|45'|Reefer|"+txtHeadMT;
    var HeadTypeSize = new Array("TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)", //aloc
    							 "Total TEU|20'|D2|40'|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",//booking
    							 "CMB WK1|CMB WK2|CMB WK3|CMB WK4|CMB WK1|CMB WK2|CMB WK3|CMB WK4",
    							 "OP|OC|VL",
    							 "TEU|WGT",
    							 "Guide",
    							 "Total TEU|TEU|D2|D4|HC|45'|53'|Reefer|RD|WT\n(M/T)",//forecast
    							 "TEU|WT\n(M/T)",
    							 "TEU|WT\n(M/T)");
    //var txtHeadVolume = "Volume";
    HeadVolume = new Array("Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
    					   "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
    					   "TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT",
    					   "OP|OC|VL",
    					   "TEU|WGT",
						   "Guide",
    					   "Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|Volume|WT\n(M/T)",
    					   "Volume|WT\n(M/T)",
						   "Volume|WT\n(M/T)") ;
    var txtHeadItem = new Array("CMB Trend(+/-)", "Weekly CMB", "Guide", "Forecast", "Booking(TTL)", "HO/RHQ Alloc", "Office Alloc", "CNTR Movement", "Base","Booking(VGM)", "Booking(Standby)");
    var preColName = new Array("trend", "cmb", "guide", "fcast", "usd_bkg", "asgn", "bkg_aval", "cm", "base","bs","vgm");
    var sizeColName = new Array(new Array("_ttl_qty", "_d2_qty", "_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_rd_qty", "_ttl_wgt"),//aloc
    							new Array("_ttl_qty", "_20ft_qty", "_d2_qty", "_40ft_qty", "_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_rd_qty", "_ttl_wgt"),//booking
    							new Array("1","2","3","4","_wgt1","_wgt2","_wgt3","_wgt4"),
	   		                    new Array("_op","_oc","_vl"),
	   		                    new Array("_qty","_wgt"),
	   		                    new Array(""),
    							new Array("_ttl_teu_qty", "_ttl_qty", "_d2_qty","_d4_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty","_rd_qty", "_ttl_wgt"),//forecast
    							new Array("_teu","_wgt"),
    							new Array("_vol","_wgt")
    							);
    
    //var sizeColName = new Array("_ttl_qty", "_20ft_qty", "_40ft_qty", "_40ft_hc_qty", "_45ft_hc_qty", "_53ft_qty", "_rf_qty", "_ttl_wgt");
//    var sizeColType = new Array(new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"),
//    							new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"),
//    							new Array("dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger", "dfInteger"),
//				                new Array("dfInteger", "dfInteger", "dfInteger"));
    
    // 항목에 보여야 하는 Tp/Sz 컬럼을 어떤 것을 사용하는지 index (sizeColName의 index)
    var colSizeIdx = new Array(4, 2, 5, 6, 1, 0, 0, 3, 0, 7,8);
    // 항목에 보여야 하는 Number type의 index (sizeColType의 index)
//    var colTypeIdx = new Array(2, 1, 1, 0, 3, 0);
    // 항목이 Type/Size, Weight control option에 따라 조절되어야 하는 항목인지 여부
    //var syncTarget = new Array(false, false, false, false, false, true, true, false);
    var syncTarget = new Array(false, false, false, true, true, true, true, false, false,true,true);
    // 항목이 화면에 보이는 control 대상인지 여부 
    var controlCols = new Array(false, false, false, true, true, true, true, false, false,true,true);
    // DataSelect에 나타나는 Item별 check box name 
    var dataSelectionItemName = new Array("chkWKCMB", "", "", "", "", "", "", "", "");
    							
    //var sizeColType = new Array(dfInteger, dfInteger, dfInteger, dfInteger, dfInteger, dfInteger, dfInteger);
    //var sizeColTypeAlt = new Array(dfFloat, dfFloat, dfFloat, dfFloat, dfFloat, dfFloat, dfInteger);
    //var TypeSizeCnt = sizeColName.length - 1;
    // 2014.07.18 Loal/IPI, Account, DEST 추가로 +3
    var MasterCnt = 15;
    var TailCnt = 28; //Total TEU추가에 따라 1추가
    
    var ColumnCnt = 0;
//    var fcastIdx = 0;
//    var bkgTtlIdx = 1;
//    var alocIdx = 3;
//    var baseIdx = 6;

    var cmbTrendIdx  = 0;
    var weeklyCmbIdx = 1;
    var guideIdx     = 2;
    var fcastIdx     = 3;
    var bkgTtlIdx    = 4;
    var modelIdx     = 5;
    var alocIdx      = 6;
    var cntrMoveIdx  = 7;
    var baseIdx      = 8;

    //
//    var weightCols = new Array(13, 17);
//    var controlWeightCols = new Array(8, 15);
//	 var weightCols        = new Array(14, 16,22,24);
	 var weightCols        = new Array(14, 16 ,22,23,24,26,28,30)
	 var controlWeightCols = new Array(8,10,18,20);   
	 var popParam = "";
	 var headWeek = "";	//Weekly CMB 4주차를 위한 Hearder
	 var order = "C";
	 
    /* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick = processButtonClick;

    var init_year = ''; 
    var init_week = '';
    var init_duration= '';
    /* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    	function processButtonClick(){
    		 /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
    		 var sheetObject = sheetObjects[0];
    		 var sheetObject1 = sheetObjects[1];
    		 /*******************************************************/
    		 var formObject = document.form;

    		//try {
    			var srcName = window.event.srcElement.getAttribute("name");
    			if(srcName == "" || 
    				(document.getElementsByName(srcName) == null || 
    				(window.event.srcElement.tagName == "IMG" && 
    					document.getElementsByName(srcName)[0].Enable != undefined && 
    					!document.getElementsByName(srcName)[0].Enable))){
    				return;
    			}

    			switch(srcName) {

    				case "btn_retrieve":
    					//cancelControlOption(sheetObject);
    					enableButtons(false);
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);
    					break;
    				case "btn_new":
    					if(checkModifiedSheet(sheetObjects[1])){
    						if(ComShowConfirm (getMsg("SPC90001")) != 1){
    							return;
    						}
    					}  				
    					resetAll();
    					//단축키설정 42번과 동일하게 아래 hiddenTypeSize, hiddenWeight주석처리
    					//hiddenTypeSize(sheetObject1);
    					//cancelControlOption(sheetObject);
    					enableButtons(false);
    					hiddenMasterCols(sheetObject, formObject, "INIT");
    					//hiddenWeight(sheetObject1);

    					formObject.year.value = init_year;
    		    		formObject.week.value = init_week;
    		    		formObject.duration.value = init_duration;
    		    		SpcSearchOptionWeek("week",false,document.form.year.value);
    		    		
						SpcSearchOptionTrade("trade", true, true);
						SpcSearchOptionSubTrade("subtrade");
						SpcSearchOptionLane("lane",true,true); // 0207 SHKIM
						ComBtnDisable("btng_aloc_confirm");
    					break;
    				case "btn_save":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					break;
    				case "btn_downexcel":
    					doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
    					break;
    				case "btng_temp":
    					var param = "";
    					var row1 = sheetObject1.SelectRow;
    					var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    					param = param + "&trd_cd="+sheetObject.CellValue(frow, "TRADE");
    					param = param + "&sub_trd_cd="+sheetObject.CellValue(frow, "STRADE");
    					param = param + "&week="+sheetObject.CellValue(frow, "WEEK");
    					param = param + "&rlane_cd="+sheetObject1.CellValue(row1, "rlane_cd");
    					param = param + "&dir_cd="+sheetObject1.CellValue(row1, "dir_cd");
    					param = param + "&vsl_cd="+sheetObject1.CellValue(row1, "vsl_cd");
    					param = param + "&skd_voy_no="+sheetObject1.CellValue(row1, "skd_voy_no");
    					param = param + "&skd_dir_cd="+sheetObject1.CellValue(row1, "skd_dir_cd");
    					param = param + "&ioc_cd="+sheetObject1.CellValue(row1, "ioc_cd");
    					param = param + "&pol_cd="+sheetObject1.CellValue(row1, "pol_cd");
    					param = param + "&pod_cd="+sheetObject1.CellValue(row1, "pod_cd");
    					// 2015.01.12 live반영 위해 잠시 막음
    					//param = param + "&del_cd="+sheetObject1.CellValue(row1, "del_cd");
    					//param = param + "&us_mod="+sheetObject1.CellValue(row1, "us_mod");
    					//param = param + "&account_cd="+sheetObject1.CellValue(row1, "account_cd");
    					param = param + "&ofc_cd="+formObject.office.value;
    					var url = "ESM_SPC_0066.do?"+param;
    					//var rtn = window.showModalDialog(url, window, "scroll:"+(isDevMode?"auto":"no")+";status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
    					var rtn = window.showModalDialog(url, window, "scroll:"+(isDevMode?"auto":"no")+";status:no;help:no;dialogWidth:"+560+"px;dialogHeight:"+450+"px")
    					if(rtn == "OK"){
    						sheet1_OnDblClick(sheetObject, frow, 1);
    						var vol = 0;
    						var wgt = 0;
    						
    						var volColName = preColName[alocIdx] + sizeColName[colSizeIdx[alocIdx]][0];
    						var wgtColName = preColName[alocIdx] + sizeColName[colSizeIdx[alocIdx]][sizeColName[colSizeIdx[alocIdx]].length-1];
    						var trow = 0;
    						for(var r = 0 ; r < Flags.length ; r++){
    							trow = totalRows[Flags[r]];
    							if(trow == undefined){
    								continue;
    							}
    							vol += sheetObject1.CellValue(trow, volColName)*1;
    							wgt += sheetObject1.CellValue(trow, wgtColName)*1;
    						}
    						sheetObject.CellValue2(frow, "alloc_vol") = vol;
    						sheetObject.CellValue2(frow, "alloc_wgt") = wgt;
    					}
    					break;
    				case "btng_bottleneck":
    					var param = "";
    					var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    					var vvd = sheetObject.CellValue(frow, "VVD");
    					param = param + "&year1="+sheetObject.CellValue(frow, "WEEK").substring(0, 4);
    					param = param + "&week1="+sheetObject.CellValue(frow, "WEEK").substring(4);
    					param = param + "&lane="+sheetObject.CellValue(frow, "rlane_cd");
    					param = param + "&bound="+sheetObject.CellValue(frow, "dir_cd");
    					param = param + "&vvd="+vvd;
    					var url = "ESM_SPC_045.do?"+param;
    					var rtn = window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+800+"px;dialogHeight:"+550+"px")
    					break;
    				case "btng_skd":
//    					var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
//    					spcPopup("VVD", "vvd_cd="+sheetObject.CellValue(frow, "VVD"), 770, 470, "getVVD", "1,0,1,1,1,1,1,1");
    					var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
            	    	var param = "&vvd=" + sheetObject.CellValue(frow, "VVD");
            	    	var url = "ESM_SPC_0071.do?"+param;
    		    		window.showModalDialog(url, window, "scroll:no;status:no;help:no;dialogWidth:"+700+"px;dialogHeight:"+450+"px")
    					break;
    				case "btng_bsa":
    					break;
    				case "btng_controlEdit":
    					editControlOption(sheetObject);
    					break;
    				case "btng_controlSave":
    					var rtn = saveControlOption(sheetObject);
    					if(rtn == "OK"){
    						var frow = sheetObject.FindText("dataSeq", sheet1_SelectedRow);
    						sheet1_OnDblClick(sheetObject, frow, 1);
    					}
    					break;
    				case "btng_controlCancel":
    					cancelControlOption(sheetObject);
    					break;
    				case "btng_load_ofc":
    					if(popParam != ""){
    						window.showModalDialog("ESM_SPC_0032.do?"+popParam, null, "dialogHeight:650px;dialogWidth:970px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;");
    					}
    					break;
    				case "btng_season_grp":
    					yieldGrpPopup();
    					break;
    				case "btng_cmpl_firm" :
    					var obj = document.getElementById("office");
    					var selOfc = obj.value;
    					var param = "vvd_no=" + sheetObjects[0].CellValue( sheetObjects[0].SelectRow , "VVD" )+"&origin="+selOfc;
    					var url = "ESM_SPC_0116.do?" + param;
    					var rtn = window.open(url, "SPC", "height=610px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")

    			} // end switch
    		//}catch(e) {
    		//	if( e == "[object Error]") {
    		//		ComShowCodeMessage("COM12111");
    		//	} else {
    		//		ComShowMessage(e);
    		//	}
    		//}
    	}
    	
    	function getVVD(){
    	}

    	/**
    	 * IBSheet Object를 배열로 등록
    	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
    	 * 배열은 소스 상단에 정의
    	 */
    	function setSheetObject(sheet_obj){

    	   sheetObjects[sheetCnt++] = sheet_obj;


    	}
    	function setComboObject(combo_obj){

    	   comObjects[comboCnt++] = combo_obj;


    	}

    	/**
    	 * Sheet 기본 설정 및 초기화
    	 * body 태그의 onLoad 이벤트핸들러 구현
    	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    	 */
    	function loadPage() {
    		SpcSearchOptionYear("year");
        	SpcSearchOptionWeek("week");
        	SpcSearchOptionDuration("duration", 5, 5);
        	SpcSearchOptionTrade("trade", true, true);
        	SpcSearchOptionSubTrade("subtrade");
        	SpcSearchOptionLane("lane",true,true);
        	SpcSearchOptionBound("bound",false,true,false,true);

    		for(i=0;i<sheetObjects.length;i++){

    		//khlee-시작 환경 설정 함수 이름 변경
    			ComConfigSheet(sheetObjects[i]);

    			initSheet(sheetObjects[i],i+1);
    		//khlee-마지막 환경 설정 함수 추가
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		
    		var sheetResizeFull = true;
    		document_onresize();
    		
    		enableButtons(false);
    		document.form.year.focus();
    		var formObject = document.form;
    		//if(formObject.office.value != "SELHO"){
    		//	formObject.office.disabled = true;
    		//}
            /* test using  s
    		if(isDevMode){
    			 formObject.year.value = "2007";
    			 formObject.week.value = "40";
    			 formObject.duration.value = "3";
    			 formObject.office.value = "SZPSC";
    			 comObjects[0].Code = "TPS";
    			 comObjects[2].Code = "PSXTP";
    			 controlDiv.style.display = "block";
    			 formObject.vvd.value = "KVGB0026E";
    			 doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
    			 if(sheetObjects[0].RowCount > 0){
//    				 sheet1_OnDblClick(sheetObjects[0], 2, 1);
    			 }
    			sheetControlDiv[0].style.display = "";
    			sheetControlDiv[1].style.display = "";
    		} test using e */ 
    		sheetObjects[0].ReDraw = true;
    		sheetObjects[1].ReDraw = true;
//    		formObject.office.value = "SELSC";
//    		formObject.vvd.value = "HNGE0010E";//"HNGE0010E";
    		
    		// Booking Creation 화면에서 Inquiry by Sub Office 화면 Pop-up 사용 처리 로직
            if(pop_vvd != "") {
            	var formObj = document.form;
            	formObj.vvd.value    = pop_vvd;
            	formObj.office.value = pop_ofc;
            	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            	ComBtnDisable("btn_save");
            }
    		init_year = formObject.year.value;	//년 초기화용
    		init_week = formObject.week.value;	//주차 초기화용            
    		init_duration = formObject.duration.value;	//Duration 초기화용
    		
    		hiddenSelectionField(sheetObjects[1]);
    		ComBtnDisable("btng_cmpl_firm");
    	}

    	function enableButtons(enable){
    		if(enable){
//    			ComBtnEnable("btng_controlEdit");
    			ComBtnEnable("btng_bottleneck");
    			ComBtnEnable("btng_skd");
    			ComBtnEnable("btng_bsa");
    			if(document.form.acctCtrl.value == "Y"){
    				ComBtnEnable("btng_load_ofc");
    				ComBtnEnable("btng_season_grp");
    			}else{
    				ComBtnDisable("btng_load_ofc");
    				ComBtnDisable("btng_season_grp");
    			}
    		} else {
//    			ComBtnDisable("btng_controlEdit");
    			ComBtnDisable("btng_bottleneck");
    			ComBtnDisable("btng_skd");
    			ComBtnDisable("btng_bsa");
    			ComBtnDisable("btng_temp");
    			ComBtnDisable("btng_load_ofc");
    			ComBtnDisable("btng_season_grp");
    			ComBtnDisable("btng_aloc_confirm");
    		}
    		
    		if(pop_vvd != "") {
            	var formObj = document.form;
            	ComBtnDisable("btng_temp");
            }
    	}

       /**
    	 * 시트 초기설정값, 헤더 정의
    	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
    	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
    	 */
    	function initSheet(sheetObj,sheetNo) {
    		var cnt = 0;
        	var formObj = document.form;
        	var acctCtrl = formObj.acctCtrl.value;
       	
    		switch(sheetNo) {

    			case 1:	  //sheet1 init
    			   with (sheetObj) {
    					// 높이 설정
    					style.height = getSheetHeight(10) ;
    					//전체 너비 설정
    					SheetWidth = mainTable1.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msHeaderOnly;

    				  //전체Edit 허용 여부 [선택, Default false]
    					Editable = false;
    					FocusEditMode = default_edit_mode;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo( 3, 1, 9, 100);

    					// 해더에서 처리할 수 있는 각종 기능을 설정한다
    					InitHeadMode(true, true, false, true, false,false) ;

    					var Head1 = "SEQ|Trade|Sub\nTrade|Lane|Bound|Week|VVD|";
    					var HeadTitle0 = Head1+"HO/RHQ Alloc|HO/RHQ Alloc|HO/RHQ Alloc|HO/RHQ Alloc|Load QTA|Load QTA|F'CAST|F'CAST|F'CAST|F'CAST|Office Alloc|Office Alloc|Office Alloc|Office Alloc|BKG|BKG|BKG|BKG|Booking VGM|Booking VGM|Booking VGM|Booking VGM|Standby BKG|Standby BKG|CNTR Movement|CNTR Movement|CNTR Movement|Unallocated\nSpace";
    					var HeadTitle1 = Head1+"VOL|WGT|TS|TS|VOL|CMB|VOL|WGT|TS|TS|VOL|WGT|TS|TS|VOL|WGT|TS|TS|VOL|WGT|TS|TS|TEU|WGT|OP|OC|VL|Unallocated\nSpace| v |v|d|vol|port|hc|45|53'|rf|wgt|smp|fixed|flag|status|dataSeq|edit_flg|mnl_flg|";
    					var HeadTitle2 = Head1+"VOL|WGT|VOL|WGT|VOL|CMB|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|VOL|WGT|TEU|WGT|OP|OC|VL|Unallocated\nSpace| v |v|d|vol|port|hc|45|53'|rf|wgt|smp|fixed|flag|status|dataSeq|edit_flg|mnl_flg|";
    					
    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//    					InitColumnInfo(46, 7 , 0, true);
    					InitColumnInfo(ComCountHeadTitle(HeadTitle2), 7 , 0, true);
    					
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle0, true);
    					InitHeadRow(1, HeadTitle1, true);
    					InitHeadRow(2, HeadTitle2, true);
 
    					
    					//데이터속성	[ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0, cnt++ , dtDataSeq ,30,	daCenter,   true,	"SEQ",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daCenter,   true,	"TRADE",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daCenter,   true,	"STRADE",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	45,	daCenter,   true,	"rlane_cd",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	45,	daCenter,   true,	"dir_cd",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	55,	daCenter,   true,	"WEEK",	 false,		  "",	   dfNone,	 0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	70,	daCenter,   true,	"VVD",	 false,		  "",	   dfNone,	   0,	 true,	   true);

    					InitDataProperty(0, cnt++ , dtData,	60,	daRight,   true,   "alloced_vol",	 false,		  "",	   dfNullInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "alloced_wgt",	 false,		  "",	   dfNullInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	60,	daRight,   true,   "alloced_ts_vol",	 false,		  "",	   dfNullInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	60,	daRight,   true,   "alloced_ts_wgt",	 false,		  "",	   dfNullInteger,	   0,	 true,	   true);
                        //Load Quota
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	45,	daRight,   true,   "",	 false,		  "",	   dfFloat,	   1,	 true,	   true);

    					// F'Cast
    					InitDataProperty(0, cnt++ , dtData,	50,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    				

    					// office alloc
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "alloc_vol",	 false,		  "",	   dfInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "alloc_wgt",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "alloc_ts_vol",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "alloc_ts_wgt",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					

    					//Booking
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_vol",	 false,		  "",	   dfInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_wgt",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_ts_vol",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_ts_wgt",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					//Booking VGM
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_vol_vgm",	 false,		  "",	   dfInteger,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_wgt_vgm",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_ts_vol_vgm",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_ts_wgt_vgm",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					
    					//Standby BKG
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_bs_vol",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "bkg_bs_wgt",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					
    					// CNTR Movement
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtData,	40,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   2,	 true,	   true);
    					

    					InitDataProperty(0, cnt++ , dtData,	80,	daRight,   true,   "",	 false,		  "",	   dfInteger,	   0,	 true,	   true);

    					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,   true,   "vsl_cd",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,   true,   "skd_voy_no",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtHidden,	30,	daCenter,   true,   "skd_dir_cd",	 false,		  "",	   dfNone,	   0,	 true,	   true);

    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_spc_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_port_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_40ft_hc_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_45ft_hc_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_53ft_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_rf_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "ctrl_wgt_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "acct_grp_ctrl_flg",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,	30,	daCenter,	true,	"ctrl_fx_rt_flg",		false,	"",	dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , isDevMode?dtData:dtHidden,	30,	daCenter,   true,   "flag",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , isDevMode?dtStatus:dtHiddenStatus,	40,	daCenter,   true,   "ibflag",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0, cnt++ , dtSeq,	40,	daCenter,   true,   "dataSeq",	 false,		  "",	   dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			30,	daCenter,	true,	"edit_flg",		    	false,	"",	dfNone,			0,	true,	true);
    					InitDataProperty(0,	cnt++ ,	isDevMode?dtData:dtHidden,			40,	daCenter,	true,	"mnl_flg",				false,	"",	dfNone,			0,	true,	true);
    					InitDataProperty(0, cnt++ , dtData,    1,    daRight,   true,   "",     false,          "",       dfNone,       0,     false,       false);
    					ColHidden("dataSeq") = true;
    					HeadRowHeight  = 10;
    					var backColor = RgbColor(222, 251, 248);
    					RangeBackColor(1, 7, 1, 17) = backColor;

    			   }
    				break;

    			case 2:	  //sheet2 init
    			   with (sheetObj) {
    					// 높이 설정
    					style.height = getSheetHeight(15) ;
    					//전체 너비 설정
    					SheetWidth = mainTable2.clientWidth;

    					//Host정보 설정[필수][HostIp, Port, PagePath]
    					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    					//전체Merge 종류 [선택, Default msNone]
    					MergeSheet = msPrevColumnMerge + msHeaderOnly;

    				  //전체Edit 허용 여부 [선택, Default false]
    					Editable = true;
    					FocusEditMode = default_edit_mode;

    					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    					InitRowInfo(acctCtrl=="Y"?5:3, 1, 9, 100);
    					
//                        MasterCnt = 11;
//    					TailCnt = 24; //Total TEU추가에 따라 1추가
    					ColumnCnt = MasterCnt + TailCnt;
    					
//    					var HeadTitle0 = HeadMaster1;
//    					var HeadTitle1 = HeadMaster2;
//    					var vHeadTitle2 = HeadMaster2;
    					
                        //성수기 CMB로 인해 HeadMaster가 QTA까지로 변경. Total TEU추가
//                        HeadTitle0 = HeadTitle0 + "|CMB|Forecast|Guide|Forecast|";
//                        HeadTitle1 = HeadTitle1 + "|CMB|Forecast|Guide|Volume|";
//                        var vHeadTitle2 = HeadTitle2 + "|CMB|Forecast|Guide|Total TEU|";
                        
//                        HeadTitle0 = HeadTitle0 + "|CMB|CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|Weekly CMB|CMBForecast|Guide|Forecast";
//                        HeadTitle1 = HeadTitle1 + "|" + (acctCtrl=="Y"?"AVG":"TEU") + "|WGT|TEU|TEU|TEU|TEU|WGT|WGT|WGT|WGT|Forecast|Guide|Volume";
//                        HeadTitle2 = vHeadTitle2 + "|" + (acctCtrl=="Y"?"A CMPB":"TEU") + "|WGT|"+headWeek+"|Forecast|Guide|Total TEU";
//                 	    HeadTitle3 = vHeadTitle2 + "|B CMPB|WGT|"+headWeek+"|Forecast|Guide|Total TEU";
//                 	    HeadTitle4 = vHeadTitle2 + "|C CMPB|WGT|"+headWeek+"|Forecast|Guide|Total TEU";
                 	    
                 	   var HeadTitle0 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load\nQTA|CMB|CMB|Blank";
                	   var HeadTitle1 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load\nQTA|" + (acctCtrl=="Y"?"AVG":"TEU") + "|WGT|Blank";
                	   var HeadTitle2 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load\nQTA|" + (acctCtrl=="Y"?"A CMPB":"TEU") + "|WGT|Blank";
                	   var HeadTitle3 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load\nQTA|B CMPB|WGT|Blank";
                	   var HeadTitle4 = "OCN\nIPC\nT/S|RHQ|Load\nOffice|Yield\nGroup|Local\nIPI|Account\nCMDT|Account\nCMDT|POL|POD|DEST| |Load\nQTA|C CMPB|WGT|Blank";
                        
                	   if(headWeek != ""){
                		   HeadTypeSize[2] = headWeek;
                	   }

                        for(var k = 0 ; k < txtHeadItem.length ; k++){
    						var colNames = sizeColName[colSizeIdx[k]];
    						for(var i = 0 ; i < colNames.length ; i++){
    		                    HeadTitle0 = HeadTitle0 + txtDelem + txtHeadItem[k];
    		                    ColumnCnt = ColumnCnt + 1;
    						}
    						HeadTitle1 = HeadTitle1 + txtDelem + HeadVolume[colSizeIdx[k]];
    						HeadTitle2 = HeadTitle2 + txtDelem + HeadTypeSize[colSizeIdx[k]];
    						if(acctCtrl=="Y") {
    							HeadTitle3 = HeadTitle3 + txtDelem + HeadTypeSize[colSizeIdx[k]];
    							HeadTitle4 = HeadTitle4 + txtDelem + HeadTypeSize[colSizeIdx[k]];
    						}
    					}
                        
                        HeadTail = "|flg|status|lane|bound|V|V|D|TS|MNG|OFC|lvl1|lvl2|lvl3|lvl4|lvl5|child|leaf|pol|lvl||||||Remark|Remark|Remark";
    					HeadTitle0 = HeadTitle0 + HeadTail;
    					HeadTitle1 = HeadTitle1 + HeadTail;
    					HeadTitle2 = HeadTitle2 + HeadTail;
    					if(acctCtrl=="Y") {
    						HeadTitle3 = HeadTitle3 + HeadTail;
    						HeadTitle4 = HeadTitle4 + HeadTail;
    					}
    					
    					log(HeadTitle0);
    					log(HeadTitle1);
    					log(HeadTitle2);
    					log(HeadTitle3);
    					log(HeadTitle4);
    					
    					//ALOC 물량 변경시 데이터 저장용.
    					ColumnCnt += 1;
                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    					InitColumnInfo(ColumnCnt , MasterCnt - 1 , 0, true);
                        
                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
                        InitHeadMode(true, true, false, true, false,false) ;
                        
    					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    					InitHeadRow(0, HeadTitle0, true);
    					InitHeadRow(1, HeadTitle1, true);
    					InitHeadRow(2, HeadTitle2, false);
    					if(acctCtrl=="Y") {
                 		   InitHeadRow(3, HeadTitle3, true);
                     	   InitHeadRow(4, HeadTitle4, true);
                 	    }
    					
    					ImageList(0) = "img/nolines_plus.gif";
    					ImageList(1) = "img/nolines_minus.gif";

    					//			  [ROW, COL,  DATATYPE, WIDTH,		DATAALIGN,  COLMERGE, SAVENAME,	KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    					InitDataProperty(0,   cnt++,dtData,   30,		   daCenterTop,   true,	 "ioc_cd",	   	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtHidden, 45,		   daCenterTop,   true,	 "sls_rhq_cd",	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "sls_ofc_cd",	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "cust_ctrl_cd",false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "us_mod",		false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtHidden, 55,		   daCenterTop,   true,	 "account_cd",	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daLeftTop,     true,	 "account_nm",	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "pol_cd",		false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "pod_cd",		false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   55,		   daCenterTop,   true,	 "del_cd",		false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtHidden, 42,		   daCenter,   	  true,	 "",		  	false,	"",		 dfNone,	   0,	 false,	   false);
    					InitDataProperty(0,   cnt++,dtData,   60,		   daRight,		  true,	 "",		  	false,	"",		 dfInteger,	   0,	 false,	   false);//qta
    					InitDataProperty(0,   cnt++,dtData,   60,		   daRight,		  true,	 "cmb",		  	false,	"",		 dfInteger,	   0,	 false,	   false);//cmb
    					InitDataProperty(0,   cnt++,dtData,   60,		   daRight,		  true,	 "cmg_wgt",		false,	"",		 dfInteger,	   0,	 false,	   false);//cmb
    					InitDataProperty(0,   cnt++,dtHidden, 60,		   daRight,		  true,	 "",		  	false,	"",		 dfInteger,	   0,	 false,	   false);//?

    		            for(var j = 0 ; j < txtHeadItem.length ; j++){
    						var colNames = sizeColName[colSizeIdx[j]];
//    						var colTypes = sizeColType[colTypeIdx[j]];
    						var dtType = false;
    						
    						if(controlCols[j] || preColName[j] == "cm" || preColName[j] == "cmb"  || preColName[k] ==  "trend" || preColName[j] ==  "guide"){
    							dtType = true;
    						}
    						
    						for(var m = 0 ; m < colNames.length ; m++){
    							InitDataProperty(0,   cnt++,dtType?dtData:(isDevMode?dtData:dtHidden),   defaultWidth, daRight,    true,     preColName[j]+colNames[m],          false,    "",         dfInteger,       1,     (j==alocIdx),       (j==alocIdx));
    						}
    					}

    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 20,		   daCenter,   true,	 "mode",	  false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtStatus:dtHiddenStatus,20,  daCenter,   true,	 "ibflag",	false,	"",		  dfNone,	   0,	 true,	   true);

    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "rlane_cd",  false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "dir_cd",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "vsl_cd",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "skd_voy_no",false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "skd_dir_cd",false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "ts_flg",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "mnl_flg",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "sls_rgn_ofc_cd",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl1",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl2",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl3",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl4",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl5",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "child_cnt",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "leaf_cnt",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "pol_cnt",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "lvl",	false,	"",		  dfNone,	   0,	 true,	   true);
                        InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,         daCenter,   true,     "tsedit",    false,    "",          dfNone,       0,     true,       true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "trd_cd",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "sub_trd_cd",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "rowIoc",	false,	"",		  dfNone,	   0,	 true,	   true);
    					InitDataProperty(0,   cnt++,isDevMode?dtData:dtHidden, 40,		   daCenter,   true,	 "rowOfc",	false,	"",		  dfNone,	   0,	 true,	   true);    					
    					
    					// 2010.08.03 Remark Hidden 처리.
                        InitDataProperty(0,   cnt++,  dtData, 100,                      daLeft,     true,     "spc_ctrl_aloc_rmk",    false,    "",          dfNone,       0,     true,       true);
                        InitDataProperty(0,   cnt++,  dtData, 100,                      daLeft,     true,     "spc_ctrl_aloc_pol_rmk",    false,    "",          dfNone,       0,     true,       true);
                        InitDataProperty(0,   cnt++,  dtData, 100,                      daLeft,     true,     "spc_ctrl_aloc_pod_rmk",    false,    "",          dfNone,       0,     true,       true);
                        InitDataProperty(0,   cnt++ , dtData,    1,    daRight,   true,   "",     false,          "",       dfNone,       0,     false,       false);
                        InitDataProperty(0,	cnt++,	dtHidden,			1,		daRight,	true,	"aloc_mdfy",				false,	"",	dfNone,	0,	false,	false); //2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
    					HeadRowHeight  = 10;

    					var backColor = RgbColor(203, 210, 248);
    					//RangeBackColor(Row1, Col1, Row2, Col2) 
    					if(acctCtrl=="Y") {
    						RangeBackColor(1, MasterCnt - 3, 7, ColumnCnt - TailCnt - 1) = backColor;
    					}else{
    						RangeBackColor(1, MasterCnt - 3, 5, ColumnCnt - TailCnt - 1) = backColor;
    					}
    					InitTreeInfo(10, "sLevel", RgbColor(0, 0, 255), false);
    					ClipPasteMode = 1;

    					//EditableColorDiff = false;
    					EditableColor	   = RgbColor(255,255,128);	//Default:255,255,255, 흰색 Edit 가능 데이터 배경색
    					UnEditableColor	   = RgbColor(255,255,255);   //Default:239,235,239, 회색 Edit 불가능 데이터 배경색
//    					for(var i = 0 ; i < TypeSizeCnt + 1 ; i++){
//                        	MinimumValue(0, preColName[alocIdx]+sizeColName[i]) = 0;
    					
    					
//    					colSizeIdx = new Array(0, 0, 1, 1, 0, 0, 2, 0, 0);
//    					alocIdx = 5;
//    					finalIdx = 1;
//    					bkgFirmIdx = 2;
//    					guarIdx = 6;
//    					
//    					for(var n = 0 ; n < sizeColName[colSizeIdx[alocIdx]].length + 1 ; n++){
//                        	MinimumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][n]) = 0;
//                        	MaximumValue(0, preColName[alocIdx]+sizeColName[colSizeIdx[alocIdx]][n]) = 100000;
//    					}
//    					
////    					for(var i = 0 ; i < TypeSizeCnt + 1 ; i++){
////                        	ColHidden(preColName[finalIdx]+sizeColName[i]) = true;
////                        	ColHidden(preColName[bkgFirmIdx]+sizeColName[i]) = true;
//                       	for(var p = 0 ; p < sizeColName[colSizeIdx[finalIdx]].length + 1 ; p++){
//                        	ColHidden(preColName[finalIdx]+sizeColName[colSizeIdx[finalIdx]][p]) = true;
//    					}
//    					
////    					CellText(2, preColName[alocIdx] + sizeColName[1]) = "OTH";
////    					ColHidden(preColName[alocIdx] + sizeColName[2]) = true;
//                    
//    					for(var q = 0 ; q < sizeColName[colSizeIdx[bkgFirmIdx]].length + 1 ; q++){
//                        	ColHidden(preColName[bkgFirmIdx]+sizeColName[colSizeIdx[bkgFirmIdx]][q]) = true;
//    					}
//    					for(var w = 0 ; w < sizeColName[colSizeIdx[guarIdx]].length + 1 ; w++){
//                        	ColHidden(preColName[guarIdx]+sizeColName[colSizeIdx[guarIdx]][w]) = true;
//    					}
    					/* 2010.08.16 LHJ [Ticket ID:CHM-201005552-01] Remark 기능이 가능한 Office인지를 체크해서 보여줌.*/
    					if( rmkFlg == "Y"){
    						ColHidden("spc_ctrl_aloc_rmk")     = false;
    						ColHidden("spc_ctrl_aloc_pol_rmk") = false;
    						ColHidden("spc_ctrl_aloc_pod_rmk") = false;
    					} else {
    						ColHidden("spc_ctrl_aloc_rmk")     = true;
    						ColHidden("spc_ctrl_aloc_pol_rmk") = true;
    						ColHidden("spc_ctrl_aloc_pod_rmk") = true;    						
    					}
    					
    					if(acctCtrl=="N") {
                 		   ColHidden("cust_ctrl_cd") = true;
                 		   ColHidden("guide") = true;
                 	   } else {
                 		   ColHidden("cust_ctrl_cd") = false;
                 		   ColHidden("guide") = false;
                 	   }
    			   }
    				break;
    		}
    	}

      // Sheet관련 프로세스 처리
    	function doActionIBSheet(sheetObj,formObj,sAction) {
    		sheetObj.ShowDebugMsg = false;

    		switch(sAction) {

    		   case IBSEARCH:	  //조회
    				if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    				formObj.f_cmd.value = SEARCHLIST01;
    				sheetObj.ReDraw=false;
    				sheetObj.RemoveAll();
    				sheetObjects[1].RemoveAll();
    				formObj.chkTS.checked = true;
    				
    				var param = SpcFormString(formObj,"f_cmd,year,week,duration,vvd,trade,subtrade,lane,bound,office");
    				
    				//sheetObj.DoSearch4Post("ESM_SPC_0044GS.do", FormQueryString(formObj));
    				sheetObj.DoSearch4Post("ESM_SPC_0044GS.do",param);
    				hiddenMasterCols(sheetObj, formObj, "INIT");
//    				btnImgEnable("btng_temp", false);
    				ComBtnDisable("btng_temp");
    				sheetObj.ReDraw=true;
    				// 조회된 데이터가 1건인 경우 하단 데이터를 바로 조회하도록 처리
    				if(sheetObj.RowCount == 1){
    					sheet1_OnDblClick(sheetObj, sheetObj.HeaderRows, 1);
    				}
    				break;
    			case IBSAVE:		//저장
    			    if(!validateForm(sheetObj,formObj,sAction)){
    					return false;
    				}
    			
	    			if(formObj.acctCtrl.value == "Y"){
	    				formObj.f_cmd.value = MULTI01;
	    			} else {
	    				formObj.f_cmd.value = MULTI;
	    			}
    				var rows = sheetObj.GetTransColText("U", "mode");
    				var rowArr = rows.split(";");
    				var rowCnt = rowArr.length;
    				var chekport = formObj.chkPort.value;
    				
    				for(var i = 0 ; i < rowCnt ; i++){
    					var rowInfo = rowArr[i].split("=");
    					if(sheetObj.CellValue(rowInfo[0]*1, "lvl")*1 < 6){
    						sheetObj.RowStatus(rowInfo[0]*1) = "I";
    					}
    					else if(rowInfo[1] == "I"){
    						sheetObj.RowStatus(rowInfo[0]*1) = "I";
    					}
    					
    							
    				}
    				
    				var param = SpcFormString(formObj,"f_cmd");
//    				alert( sheetObj.CellValue( 22, "bkg_aval_ttl_qty" ) );
    				//var rtn = doSaveSheet(sheetObj, "ESM_SPC_0044GS.do", FormQueryString(formObj));
    				var rtn = doSaveSheet(sheetObj, "ESM_SPC_0044GS.do", param);
    				//저장하고 난 다음 변경된 값을 가져온다.
    				var rData = rtn.split(":");
    				if(rData[0] == "OK"){
    					//저장한 후 가져온 결과값을 sheet에 세팅.
    					if( rData[1] != "null" ){
    						var ary = rData[1].split("|");
    						if( ary.length > 0 ) {
    							for( var xx=0 ; xx<ary.length ; xx++ ) {
    								var ary2 = ary[xx].split(",");
    								if( ary2.length > 1 && ary2[0] != "" && ary2[1] != null && ary2[1] != "" ) { 
    									var rRow = ary2[0]*1;
    									if( rRow > 0 ){
	    									var ov = sheetObj.CellValue( rRow , "bs_teu" )*1; //bs_wgt
	    									var dv = ary2[3]*1;
	    									var dif = dv - ov;
	    									var ctrl_lvl = sheetObj.CellValue(rRow,"lvl");
	    									var yield = sheetObj.CellValue(rRow,"sls_ofc_cd");
	    									var oit = sheetObj.CellValue(rRow,"ioc_cd");
	    									sheetObjects[0].CellValue2( sheet1_selRow ,"bkg_bs_vol") = parseInt( sheetObjects[0].CellValue( sheet1_selRow ,"bkg_bs_vol") ) + dif ;//위쪽 sheet의 standby 변경
	    									changValueStandby(sheetObj, rRow, '', dif , "", yield, oit );
    									}
    								}
    							}
//    							getSheet2Total();
    						}
    					}
    					for(var j = 0 ; j < rowCnt ; j++){
    						var rowInfo = rowArr[j].split("=");
    						if(rowInfo[1] == "I"){
    							sheetObj.CellValue2(rowInfo[0]*1, "mode") = "R";
    							sheetObj.RowStatus(rowInfo[0]*1) = "R";
    						}
    					}
    					
    					var cnt = sizeColName[colSizeIdx[alocIdx]].length - 1;
    					var frow = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
    					var sumArr = getSum(sheetObj, ":OCN:IPC:T-OCN:T-IPC:", preColName[alocIdx], formObj);
    					sheetObjects[0].CellValue2(frow, "alloc_vol") = sumArr[0];
    					sheetObjects[0].CellValue2(frow, "alloc_wgt") = sumArr[cnt];
    					sheetObjects[0].RowStatus(frow) = "R";
                     
    					var trow = 0;
    					for(var r = 0 ; r < Flags.length ; r++){
    						trow = totalRows[Flags[r]];
    						if(trow == undefined){
    							continue;
    						}
    						setTotalRowColor(sheetObj, trow);
    					}
    				}
    				break;

    		   case IBDOWNEXCEL:		//엑셀 다운로드
    			  sheetObj.Down2Excel(-1, false, false, true);
    			  break;

    		}
    	}

    	var selectedCell_OldValue = 0;
    	function sheet2_OnSelectCell(sheetObj, orow, ocol, row, col){
    		if(row > 1){
    			selectedCell_OldValue = sheetObj.CellValue(row, col)*1;
    			
    			var status = (sheetObj.CellValue(row, "ioc_cd") != null && sheetObj.CellValue(row, "ioc_cd").substring(0, 2) == "T/" && 
    						  //sheetObj.CellValue(row, "lvl") == "6" && 
    						  sheetObj.CellValue(row, "lvl") == "3" && 
    						  ComTrim(sheetObj.CellValue(row, "sls_ofc_cd")) == ComTrim(document.form.office.value));
//    			btnImgEnable("btng_temp", status);
    			if(status){
    				ComBtnEnable("btng_temp");
    			} else {
    				ComBtnDisable("btng_temp");
    			}
    		}
    	}

    	function sheet2_OnChange(sheetObj, row, col, value){
    		log("sheet2_OnChange1 : " + row + " - " + col);
    		var colName = sheetObj.ColSaveName(col);
    		var formObj = document.form;
    		
    		
    		var pre = "";
    		for(var i = 0 ; i < preColName.length ; i++){
    			if(colName.substring(0, preColName[i].length) == preColName[i]){
    				pre = preColName[i];
    				break;
    			}
    		}
    	
    		var sizeName = colName.substring(pre.length);
    		var orgValue = 0;
    		value = value * 1;
    		var level = sheetObj.CellValue(row, "lvl") * 1;
    		
    		log("sheet2_OnChange1 : " + row + " - " + col);
          
      	
	      	/////////////////CNEP0054E	
    		//vvd 별 어떤 데이터든 변경되면 메시지 호출
      		if(formObj.chkPort.value == "L" && formObj.pol_dbl_port_chk.value == "Y") {
      			sheetObj.CellValue2(row, col) = selectedCell_OldValue;
      			ComShowMessage("In case of Double Calling Lane(Route) touching two different tmnl within one port or one port several times,\nPlease allocate space with 'POL/POD' control option.");
      			return false;
      		}
      	
          
    		if(pre == preColName[alocIdx]){
    			orgValue = sheetObj.CellValue(row, preColName[baseIdx]+sizeName) * 1;
    			// office level이 account 일 때.
    			// 여기서 그럼 account 와 local IPI는 모두 Others로 가정해야 함
    			if(level == 1){
    				// 새로 setting할 row
    				// 해당 office로 첫  Others/Others row을 찾아 값을 세팅
    				//frow  = sheetObj.FindText("us_mod", "OTHERS", row + 1);
    				//new_row  = sheetObj.FindText("account_cd", "OTHERS", frow + 1);
    				frow  = sheetObj.FindText("lvl", "2", row + 1 );
    				new_row  = sheetObj.FindText("lvl", "3", frow + 1);
    				sheetObj.CellValue2(frow, pre + sizeName)= value; 
    				// level 3의 경우 상태를 변하게 해서 하단의 allocate by office 타도록 함
    				sheetObj.CellValue(new_row, pre + sizeName)= value; 
    			}
    			if (level == 2) {
    				// Account level에서 입력 할때
    				oldGrpValue_2 = selectedCell_OldValue;
    				new_row = sheetObj.FindText("account_cd", "OTHERS", row + 1);
    				sheetObj.CellValue(new_row, pre + sizeName) = value;
    				if (sheetObj.CellEditable(row, col)) {
    					var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_2, level);
    					//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
    					if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
    						sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
    					}
    				}

    			}
    			if(level == 3){
                    oldGrpValue_3 = selectedCell_OldValue;
        			allocateByOffice(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
        			if (sheetObj.CellEditable(row, col)) {
        				var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_3, level);
        				//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
        				if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
        					sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
        				}
        			}
    			}
    			if(level == 4){
    				// oldGrpValue는 changeSuperiorValue에 이전 값 SETTING
					oldValue = selectedCell_OldValue;
					oldGrpValue_4 = selectedCell_OldValue;
					allocateByPol(sheetObj, row, pre, sizeName, preColName[baseIdx], value, orgValue);
					if (sheetObj.CellEditable(row, col)) {
						var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_4, level);
						//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
						if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
							sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
						}
					}
    			}
    			if(level == 5){
    				oldValue = selectedCell_OldValue;
    				oldGrpValue_5 = selectedCell_OldValue;
    				allocateByPod(sheetObj, row, pre, sizeName, preColName[baseIdx], value, oldValue);
    				if(sheetObj.CellEditable(row, col)){
    					var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_5, level);
    					//2015.04.16 allocation 물량 변경시 confirm 으로 변경관련
    					if( sheetObj.CellValue( row, "aloc_mdfy" ) == "" ){ //값이 변경되었을때 해당 필드에 원본값이 없으면 selectedCell_OldValue 값이 원본이므로 그 값을 저장 
    						sheetObj.CellValue2( row, "aloc_mdfy" ) = row;//"1";//selectedCell_OldValue;
    					}
    				}		

                    var ioc_cd       = sheetObj.CellValue(row, "ioc_cd");
    				var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
    				var rowOfc       = sheetObj.CellValue(row, "rowOfc");
    				//changeTotalValue(sheetObj, ioc_cd, col, pre, value, oldValue);
    				
    				if(document.form.acctCtrl.value == "Y") {
    					changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
        				changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre, value, oldValue);
    				}
    				
    			}
    			if(level == 6){
    				oldValue = selectedCell_OldValue;
    				oldGrpValue_6 = selectedCell_OldValue;
    				if (sheetObj.CellEditable(row, col)) {
    					var rtn = changeSuperiorValue(sheetObj, row, col, pre, value, oldGrpValue_6, level);
    				}
    				
    				var ioc_cd       = sheetObj.CellValue(row, "ioc_cd");
    				var cust_ctrl_cd = sheetObj.CellValue(row, "cust_ctrl_cd");
    				var rowOfc       = sheetObj.CellValue(row, "rowOfc");
    				
    				changeTotalValue(sheetObj, ioc_cd, col, pre, value, selectedCell_OldValue);
    				
    				if(document.form.acctCtrl.value == "Y" && sheetObj.CellEditable(row, col)) {
    					changeOfcTotalValue(sheetObj, rowOfc, col, pre, value, oldValue);
    					changeGroupTotalValue(sheetObj, ioc_cd, cust_ctrl_cd, col, pre, value, oldValue);
    				}
    			}
    		}
    		selectedCell_OldValue = value;               
    	}
    	

    	function sheet2_OnClick(sheetObj, row, col){
    		switch(sheetObj.ColSaveName(col)){
    		case "cust_ctrl_cd":
    		case "us_mod":
    		case "account_cd":
            case "account_nm":
    		case "pol_cd":
    		case "pod_cd":
    		case "del_cd":
    			var mark = sheetObj.CellValue(row, col);
    			var status = sheetObj.RowStatus(row);
    			if(mark == "0"){
       				sheetObj.RowExpanded(row) = true;
       				sheetObj.CellValue2(row, col) = "1";
       				sheetObj.RowStatus(row) = status;
    			}
    			else if(mark == "1"){
       				sheetObj.RowExpanded(row) = false;
       				sheetObj.CellValue2(row, col) = "0";
       				sheetObj.RowStatus(row) = status;
    			}
    			break;
    		}
    	}
    	
    	function sheet2_OnDblClick(sheetObj, row, col) {
            var colName = sheetObj.ColSaveName(col);
    		var rhq   = "";
    		var param = "";
    		var sheet1 = sheetObjects[0];
    		var sheet2 = sheetObjects[1];

    		//Booking(TTL) TOtal TEU 물량이 있을시 
    		if(colName == "usd_bkg_ttl_qty" || colName == "vgm_vol"){
    			sUrl = "/hanjin/ESM_SPC_0049.do";
    			var cnt = eval(sheetObj.CellValue(row, col));
    			var ctrt_no = sheet2.CellValue(row, "account_cd");
    			
    			if( cnt > 0){
    	    		var slsOfc = "";
    	    		var ofcLvl = "";
    				if(ComTrim(sheet2.CellValue(row, "sls_ofc_cd"))=="TTL"){
    	    			slsOfc = document.form.office.value;
    	    			ofcLvl = "5";
    	    		}else{
    	    			slsOfc = sheet2.CellValue(row, "sls_ofc_cd");
    	    			ofcLvl = "6";
    	    		}
    				
    				param = "?f_cmd="+SEARCHLIST
    	    			+ "&trade="   		+ sheet1.CellValue(sheet1_selRow, "TRADE")
    					+ "&subtrade="		+ sheet1.CellValue(sheet1_selRow, "STRADE")
    					+ "&lane="    		+ sheet1.CellValue(sheet1_selRow, "rlane_cd")
    					+ "&bound="   		+ sheet1.CellValue(sheet1_selRow, "dir_cd")
    					+ "&year="    		+ sheet1.CellValue(sheet1_selRow, "WEEK").substring(0, 4)
    					+ "&week="   		+ sheet1.CellValue(sheet1_selRow, "WEEK").substring(4)
    					+ "&vvd="     		+ sheet1.CellValue(sheet1_selRow, "VVD")
    					
    					+ "&ioc_cd="   		+ sheet2.CellValue(row, "ioc_cd")
    					+ "&sls_area_cd="   + ""
    					+ "&sls_ofc_cd="   	+ slsOfc
    					+ "&pol_cd="   		+ sheet2.CellValue(row, "pol_cd")
    					+ "&pod_cd="   		+ sheet2.CellValue(row, "pod_cd")
    				    + "&cust_ctrl="		+ ComTrim(sheet2.CellValue(row, "cust_ctrl_cd"))
    					+ "&ofc_lvl=" 		+ ofcLvl;

    				// Account에 계약이 오는 경우 COA popup에 해당 값 setting
    				if (ctrt_no.length == 9){
    					param = param + "&sc_no=" + ctrt_no;
    				} else if (ctrt_no.length == 10){
    					param = param + "&rfa_no="+ ctrt_no;
    				} 
    				var leftpos = (screen.width - 1024) / 2;
    				if (leftpos < 0)
    					leftpos = 0;
    				var toppos = (screen.height - 540) / 2;
    				if (toppos < 0)
    					toppos = 0;    				

    				var rtn = window.open(sUrl+param, "none", "height=540px,width=1024px,status=no,toolbar=no,menubar=no,location=no,resizable=yes,Left="+leftpos + ",dialogTop:" + toppos)
    			}
    		}
    		//Compulsory firm 화면으로 이동, orgin, pol_cd, pod_cd 를 동반하여 넘김.
    		if( colName == "bs_teu" ) {
    			var val = sheetObj.CellValue( row, colName );
    			if( val != "0" ){
    				sUrl = "/hanjin/ESM_SPC_0116.do";
    				var ofc = document.form.office.value;//sheetObj.CellValue( row , "sls_ofc_cd" );
    				if( ofc == "" )
    					ofc = sheetObj.CellValue( row, "sls_ofc_cd" ) ;
    				if( ofc.indexOf("TTL")>0)
    					ofc = "";
    				var param = "origin=" 	 + sheetObj.CellValue( row, "sls_ofc_cd" ) 
	    			    + "&trade="			 + sheetObj.CellValue(row, "trd_cd")
	    			    + "&rlane_cd="		 + sheetObj.CellValue(row, "rlane_cd")
    					+ "&pol_cd=" 		 + sheetObj.CellValue( row , "pol_cd" )
    					+ "&pod_cd=" 		 + sheetObj.CellValue( row , "pod_cd" )
    					+ "&del_cd=" 		 + sheetObj.CellValue( row , "del_cd" )
    					+ "&cust_ctrl_cd="   + sheetObj.CellValue( row , "cust_ctrl_cd" )
    					+ "&ofc_vw=" 		 + ofc
    					+ "&ioc_cd="		 + sheet2.CellValue(row, "ioc_cd")
    					+ "&usa_bkg_mod_cd=" + sheet2.CellValue(row, "us_mod")
    					+ "&vvd_no=" 		 + document.getElementById("idTxtVVD").value;
    				ComOpenWindow( sUrl + "?" + param, 'SB BKG Firm', "height=720px,width=1000px,status=no,toolbar=no,menubar=no,location=no,resizable=yes")
    			}		
    		}
 		
    		if(colName == "guide" && ComTrim(sheetObj.CellValue(row, col)) != "" && ComTrim(sheetObj.CellValue(row, "sls_ofc_cd")) != "TTL" && ComTrim(sheetObj.CellValue(row, "sls_rhq_cd"))!=""){
    			var param = "year="         + document.getElementById("idTxtWeek").value.substring(0, 4)
    		 	          + "&week="        + document.getElementById("idTxtWeek").value.substring(4)
    		 	          + "&duration="    + "1" 
    		 	          + "&trade="       + sheetObj.CellValue(row, "trd_cd")
    		 	          + "&sub_trade="   + sheetObj.CellValue(row, "sub_trd_cd")
    		 	          + "&rlane_cd="    + sheetObj.CellValue(row, "rlane_cd")
    		 	          + "&rhq="         + sheetObj.CellValue(row, "sls_rhq_cd")
    		 	          + "&rgn_cd="      + sheetObj.CellValue(row, "sls_ofc_cd")
    		 	          + "&src=0044";
    		 	
    		 	ComOpenWindow("ESM_SPC_0021.do?" + param, 'daily forecast status',"height=650,width=1024,status=0,resizable=yes");
    		}
 		
        }

    	function sheet1_OnDblClick(sheetObj, row, col){
    		var sheetObj1 = sheetObjects[1];
    		var formObj = document.form;
    		formObj.acctCtrl.value = sheetObj.CellValue(row, "acct_grp_ctrl_flg"); //acct->acct_grp_ctrl_flg
    		sheetObj1.Enable = false;
    		sheetObj1.ReDraw=false;
    		sheetObj1.RemoveAll();
    		
    		var weekXml = sheetObj.GetSearchXml("ESM_SPC_0042GS2.do?f_cmd="+SEARCH);
    		headWeek = ComGetEtcData(weekXml, "headerWeek");
    		initSheet(sheetObj1, 2);
        	sheet1_selRow =  row;
    		// control option이 edit 상태이면 cancel 상태로 변경
    		//cancelControlOption(sheetObj);
    	    // 상단 sheet의 현재 선택된 row를 지정
    		setSelectetRow(sheetObj, row);
    		
    		// 선택된 VVD / Week 정보를 하단 조건에 셋팅
    		document.getElementById("idTxtVVD").value = sheetObj.CellValue(row, "VVD");
    		document.getElementById("idTxtWeek").value = sheetObj.CellValue(row, "WEEK");
    		
    		var param = makeDetailParam(sheetObj, row);
    		
    		param = param + "&vsl_cd="+sheetObj.CellValue(row, "vsl_cd");
    		param = param + "&skd_voy_no="+sheetObj.CellValue(row, "skd_voy_no");
    		param = param + "&skd_dir_cd="+sheetObj.CellValue(row, "skd_dir_cd")
    		param = param + "&order=" + order;
    		
    		popParam = "week="        + sheetObj.CellValue(row, "WEEK")
			         + "&trd_cd="     + sheetObj.CellValue(row, "TRADE")
			         + "&sub_trd_cd=" + sheetObj.CellValue(row, "STRADE")
			         + "&ofc_cd="      + formObj.office.value ;
    		sheetObj1.DoSearch4Post("ESM_SPC_0044GS.do", param);
    		//checkControlOption(sheetObj, true);
    		// 검색 결과에 따라 control option을 체크 해준다.
    		checkControlOption();
    		

    		formObj.pol_dbl_port_chk.value = sheetObj1.EtcData("DBL_CALL_CHK"); // double calling 확인

    		
//    		var affCols = new Array();
//    		affCols[0] = preColName[modelIdx];
    		checkSelectionOption(sheetObj1, formObj.acctCtrl.value);
    		hiddenMasterCols(sheetObj, formObj, sheetObj.CellValue(row, "TRADE").substring(0, 1));
    		//hiddenSelectionField(sheetObj1, affCols);
    		hiddenSelectionField(sheetObj1);
    		//hiddenWeight(sheetObj1);
    		
    		sheetObj1.ShowTreeLevel(formObj.chkPort.selectedIndex+1);
    		controlTree(sheetObj1, true);
//    		
//    		// 2010.08.03 Remark Hidden 처리 하면서 관련된 펑션 호출부분 주석처리.
//    		// 2010.08.30 Remark 기능 주석해제
    		checkPortcontrolTree(sheetObj1);
    		
    		enableButtons(true);
    		//alocateSubGSO(sheetObj1, formObj.office.value, preColName[modelIdx], ":OCN:IPC:T/S:");
//    		formObj.chkTYP.checked = formObj.chkHC.checked || formObj.chk45.checked;
//    		hiddenTypeSize(sheetObj1);
    		sheetObj1.ReDraw=true;
    		sheetObj1.Enable = true;
    		
    		var bs_teu = sheetObj.CellValue(row , "bkg_bs_vol");
    		if( bs_teu > 0 ) {
    			ComBtnEnable("btng_cmpl_firm");
    			document.getElementById("btng_cmpl_firm").style.color = "red";
    		} else {
    			ComBtnDisable("btng_cmpl_firm");
    			document.getElementById("btng_cmpl_firm").style.color = "gray";
    			
    		}
    	}
       /**
    	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
    	 */
    	function validateForm(sheetObj,formObj,sAction){
    		 with(formObj){
    			switch(sAction) {
    				case IBSEARCH:	  //조회
    					if(formObj.vvd.value == "" && comObjects[0].Code == ""){
    						ComShowMessage(getMsg("SPC90114", "Trade"));
    			            if(comObjects[0].Enable) comObjects[0].focus();
    			            else comObjects[1].focus();//Trade비활성화 되어있으므로 SubTrade로 Focus를 준다.
    						return false;
    					}
    			        if(formObj.vvd.value != "" && formObj.vvd.value.length < 9){
    			        	ComShowCodeMessage("COM12174", "VVD", "9");
    			            formObj.vvd.focus();
    			            return false;
    			        }
    			        //순서변경 
    			        if(formObj.office.value == ""){
    			            ComShowMessage(getMsg("SPC90114", "ORG"));
    			            if(!formObj.office.disabled){
    				            formObj.office.focus();
    				        }
    			            return false;
    			        }
    					break;
    				case IBSAVE:		//저장
    				    var rtn = validAllocation(sheetObj, formObj, ":OCN:T-OCN:");
    					if(rtn >= 0){
    						return false;
    						
    					}
    					rtn = validAllocation(sheetObj, formObj, ":IPC:T-IPC:T/S:T-T/S:");
    					if(rtn >= 0){
    						return false;
    						
    					}
    					break;
    				case IBINSERT:	  // 입력
    					break;
    				case IBCOPYROW:		//행 복사
    					break;
    				case IBDOWNEXCEL:		//엑셀 다운로드
    					break;
    				case IBLOADEXCEL:		//엑셀 업로드
    					break;
    			}
    		}
    		return true;
    	}
    	
    	// 2010.08.03 Remark Hidden 처리 하면서 관련된 펑션 호출부분 주석처리.
    	// 2010.08.27 Remark Hidden 원복, Remark가능한 Office인지를 체크해서 보여줌.
    function checkPortcontrolTree(sheetObj){
    	var formObj = document.form;
    	var sts1 = formObj.chkOfc.checked;
    	var sts2 = formObj.chkPol.checked;
    	var sts3 = formObj.chkPod.checked;

    	if ( rmkFlg == "Y" ){
	    	if((sts1==true)&& (sts2==true) && (sts3==true) ){
	    	    sheetObj.ColHidden("spc_ctrl_aloc_rmk")=true;
	    	    sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk")=true;
	    	    sheetObj.colhidden("spc_ctrl_aloc_pod_rmk")=false;
	    	}
	    	if((sts1==true) && (sts2 == false) &&(sts3 == false)){
	    	    sheetObj.colhidden("spc_ctrl_aloc_rmk")=false;
	    	    sheetObj.ColHidden("spc_ctrl_aloc_pol_rmk")=true;
	    	    sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk")=true;
	    	    
	    	}
	    	if((sts1==true) && (sts2 == true) &&(sts3 == false)){
	    	    sheetObj.colhidden("spc_ctrl_aloc_pol_rmk")=false;
	    	    sheetObj.ColHidden("spc_ctrl_aloc_rmk")=true;
	    	    sheetObj.ColHidden("spc_ctrl_aloc_pod_rmk")=true;
	          	
	    	}
    	}
    }
    	
        /* Win7 화면에서 제대로 수행되지 않아 CoSpc.js 내용 각각 심음 */
        
        // Win7 Start
        // control option에 따라 syncTarget에 대한 항목의 Type/Size별 컬럼 display 설정 
//function hiddenSelectionField(sheetObj){
//	var formObj = document.form;
//	var chCOItemHC = formObj.chkHC.checked;
//	var chCOItem45 = formObj.chk45.checked;
//	var chCOItemRFR = formObj.chkRFR.checked;
//	var chCOItemWGT = formObj.chkWGT.checked;
//	var chDSItemWT = formObj.chkWT.checked;
//	var chDSItemTYP = formObj.chkTYP.checked;
//
//	for(var c = 0 ; c < controlCols.length ; c++){
//		if(controlCols[c]){
//			var pre = preColName[c];
//			var colNames = sizeColName[colSizeIdx[c]];
//			// 2010.02.24 아래 eval 함수가 제대로 작동하지 않아 switch 문으로 변경
//			// var itemChecked = (dataSelectionItemName[c]=="")?true:eval("formObj."+dataSelectionItemName[c]+".checked");
//			var checked = false;
//			
//			switch(dataSelectionItemName[c]) {
//			    case "chkUSG":
//			    	checked = formObj.chkUSG.checked;
//			    	break;
//			    case "chkMDL":
//			    	checked = formObj.chkMDL.checked;
//			    	break;
//			    case "chkBKGF":
//			    	checked = formObj.chkBKGF.checked;
//			    	break;
//			    case "chkCUS":
//			    	checked = formObj.chkCUS.checked;
//			    	break;
//			    default:
//			    	checked = false;
//			}
//			
//			var itemChecked = (dataSelectionItemName[c]=="")?true:checked;
//			//control option sync 대상이면
//			if(syncTarget[c]){
//				switch(colSizeIdx[c]){
//					case 0:
//						sheetObj.ColHidden(pre + colNames[0]) = !itemChecked;
//						sheetObj.ColHidden(pre + colNames[1]) = !(chCOItemHC && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[2]) = !(chCOItem45 && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[3]) = !(chCOItemRFR && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[4]) = !(chCOItemWGT && chDSItemWT && itemChecked);
//						break;
//					case 1:
//						sheetObj.ColHidden(pre + colNames[0]) = !itemChecked;
//						sheetObj.ColHidden(pre + colNames[1]) = !((chCOItemHC || chCOItem45) && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[2]) = !((chCOItemHC || chCOItem45) && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[3]) = !(chCOItemHC && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[4]) = !(chCOItem45 && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[5]) = !(chCOItemRFR && chDSItemTYP && itemChecked);
//						sheetObj.ColHidden(pre + colNames[6]) = !(chCOItemWGT && chDSItemWT && itemChecked);
//						break;
//				}
//				if(itemChecked){
//					// Tp/Sz가 보이지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
//					var w = (!chDSItemTYP || !(chCOItemHC || chCOItem45 || chCOItemRFR))?wideWidth:defaultWidth;
//					sheetObj.ColWidth(pre+ colNames[0]) = w;
//					sheetObj.ColWidth(pre+ colNames[colNames.length - 1]) = w;
//				}
//			}
//			//control option sync 대상이 아니면
//			else{
//				sheetObj.ColHidden(pre + colNames[0]) = !itemChecked;
//				for(var i = 1 ; i < colNames.length - 1 ; i++){
//					sheetObj.ColHidden(pre + colNames[i]) = !(chDSItemTYP && itemChecked);
//				}
//				sheetObj.ColHidden(pre + colNames[colNames.length - 1]) = !(chDSItemWT && itemChecked);
//				if(itemChecked){
//					// DataSelection에 View by Tp/Sz가 선택되지 않으면 컬럼의 크기를 wide로 보이도록 하기위한 width 설정
//					var w = chDSItemTYP?defaultWidth:wideWidth;
//					sheetObj.ColWidth(pre+ colNames[0]) = w;
//					sheetObj.ColWidth(pre+ colNames[colNames.length - 1]) = w;
//				}
//			}
//		}
//	}
//	
//    //Total TEU추가에 따른 TUE컬럼 처리
//	if(chDSItemTYP) sheetObj.ColHidden(MasterCnt+1) = false;
//	else sheetObj.ColHidden(MasterCnt+1) = true;
//	//Total TEU 컬럼크기 조절
//	sheetObj.ColWidth(MasterCnt) = chDSItemTYP?defaultWidth:wideWidth;
//}
    function lane_OnChange(comObj,value,text ){
    	if(value == "" ) return;
    	var arrLane = text.split("|");
    	if(arrLane.length > 1) {
    		comObjects[0].Code2 = arrLane[0];
    		comObjects[1].Code2 = arrLane[1];
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[1].Code2 = comObj.GetText(value,1);  
    	}	
    }
    
    function subtrade_OnChange(comObj,value,text ){
//    	if(text == '||ALL'){   optionAllReset("subtrade",document.form.trade.Code,"true"); return;    	} // 0207 SHKIM
    	SpcSearchOptionLane("lane",true,true,'',document.form.trade.Code,value,true);	// 0207 SHKIM
    	if(value == "" ) return;
    	var arrTrade = text.split("|");
    	if(arrTrade.length > 1) {
    		comObjects[0].Code2 = arrTrade[0];
    		comObjects[2].Code2 = '';
    	} else {
    		comObjects[0].Code2 = comObj.GetText(value,0);  
    		comObjects[2].Code2 = '';
    	} 
    	
    }  
    function trade_OnChange(comObj,value,text ){
//    	if(text == '|ALL'){	optionAllReset("trade",value,"true");   return;} // 0207 SHKIM
//    	if(value == "" ) return;
    	var repTrade = comObj.GetText(value,0);  
    	comObjects[1].Code2 = ""; //sub trade
    	comObjects[2].Code2 = ""; // lane
    	SpcSearchOptionSubTrade("subtrade",true,false,"","",value);
    	SpcSearchOptionLane("lane",true,true,'',value,'',true);	// 0207 SHKIM
    }   
    
    // trade 종류에 따라 상단 sheet의 OCN/IPC 선택 display
    function hiddenMasterCols(sheetObj, formObj, trade){
    	if(trade != undefined){
    		if(trade == "I"){
    			formObj.chkOCN.checked = false;
    		}
    		else if(trade != "INIT"){
    			formObj.chkIPC.checked = false;
    		}
    	}
    	  	
    	var checked = formObj.chkWT.checked || trade == "INIT";
    	for(var i = 0 ; checked && i < weightCols.length ; i++){
    		sheetObj.ColHidden(weightCols[i]) = !checked;
    	}
    	checked = formObj.chkWT.checked || trade == "INIT";
    	for(var j = 0 ; !checked && j < weightCols.length ; j++){
    		sheetObj.ColHidden(weightCols[j]) = !checked;
    	}
    	checked = formObj.chkWGT.checked || trade == "INIT";
    	for(var k = 0 ; k < controlWeightCols.length ; k++){
    		sheetObj.ColHidden(controlWeightCols[k]) = !checked;
    	}
    }
    
    // Win7 End

    function initDataValue_trade(){
    	var sheetObj = document.getElementById("trade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_subtrade(){
    	var sheetObj = document.getElementById("subtrade");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }
    
    function initDataValue_lane(){
    	var sheetObj = document.getElementById("lane");
    	with(sheetObj){
    		Index2 = 0;
    	}
    }

    /**
     * Start Week 의 year 변경시
     * Start Week 의 year 변경시 주차 변경
     */
    function checkWeek(){
    	SpcSearchOptionWeek("week",false,document.form.year.value);
    	
    }

         
    /**
     * CMPB 클릭시 해당 정보로 Order By 하여 재조회
     */
    function sheet2_OnMouseDown(sheetObj, Button, Shift, X, Y){
    	var header = "";
     	
    	if(sheetObj.MouseRow > 0){
    		header = ComTrim(sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol));
    		
    		if((header == "AVG" || header == "A CMPB" || header == "B CMPB" || header == "C CMPB") && sheetObj.DataRows > 0 ){
    			order = header=="AVG"?"":header.substr(0,1);
    			var frow  = sheetObjects[0].FindText("dataSeq", sheet1_SelectedRow);
    			sheet1_OnDblClick(sheetObjects[0], frow, 1);
    		}
    	}
    }
     
    /**
     * 마우스가 이동될 때 이벤트 처리 
     * 
     * @param sheetObj
     * @param Button
     * @param Shift
     * @param X
     * @param Y
     * @return
     */
    function sheet2_OnMouseMove(sheetObj, Button, Shift, X, Y){
    	var header = ComTrim(sheetObj.CellValue(sheetObj.MouseRow, sheetObj.MouseCol));
 	
	 	if((header == "AVG" || header == "A CMPB" || header == "B CMPB" || header == "C CMPB") && sheetObj.DataRows > 0 ){
	 		sheetObj.MousePointer = "Hand";
//	 	}else if (sheetObj.ColSaveName(sheetObj.MouseCol) == "sls_ofc_cd" && header != "" && header != "TTL" && sheetObj.MouseRow + 1> sheetObj.HeaderRows ){
//	 		sheetObj.MousePointer = "Hand";
	 	} else {
	 		sheetObj.MousePointer = "Default";
	 	}
    }  
    
    /**
     * Yield Group 팝업 호출(ESM_SPC_0094)
     */
    function yieldGrpPopup() {
    	var formObj = document.form;
    	var sheet1  = sheetObjects[0];
    	
    	var param = "yrwk="   + sheet1.CellValue(sheet1_selRow, "WEEK");
    	param = param + "&trd_cd=" + sheet1.CellValue(sheet1_selRow, "TRADE");
    	
    	ComOpenWindow("ESM_SPC_0094.do?" + param, "Yield Group", "height=300,width=450,status=0");
    }

    /**
     * Standby 값 변경 되면 하위 레벨 값, total 값 변경해야 함.
     * sheetObj : 적용 sheet
     * row : 변경된 row 번호
     * col : 변경된 col
     * dif : 변경된 값(원래값에 변경된값을 뺀거)
     * ctrl_lvl : 현재 vvd 의 control level
     * yield : 현 vvd가 smp 인 경우 변경 한 row 의 yield group
     * oit : 변경한 row 의 OCN/IPC/TS 
     */
    function changValueStandby(sheetObj, row, col, dif , ctrl_lvl, yield, oit ){
    	var endRow = sheetObj.CellValue( row , "rowOfc" );//현재 row 가 속한 L.OFC 의 끝 Row 번호 (L.OFC는 같은 값인 경우 하나의 ROW가 되므로 범위의 끝값을 rowOfc 컬럼이 가지고 있다.)
    	endRow = endRow + sheetObj.HeaderRows;
    	
    	//현 row의 값을 증가 시키면서 같거나 작은 level값이 나올때 까지 혹은 비교한 값 다음 값이 이전값보다 작을때 까지(즉, 계속 증가만 한다. 작아지면 종료)
    	//현 level 값 보다 큰값을 변경
    	//level = 6 인경우(Dest) 동일한 dest가 있을수 있는데 이때는 other로 된것을 변경시킴.
    	var oldRowVal = -1;
    	var nowRowVal = 0;
    	var orgRowVal = sheetObj.CellValue( row , "lvl" ); //변경한 level 값
    	sheetObj.CellValue2( row , "bs_teu" ) = parseInt( sheetObj.CellValue( row , "bs_teu" ) ) + dif; //현재 값 변경
    	
    	//row 값 증가 시키면서 pol, pod, dest 의 row  증가시키기.
    	for( var rowNum = row ; rowNum<endRow ; rowNum++ ) {
    		if( oldRowVal == -1 ) {
    			oldRowVal = orgRowVal;
    		}
    		nowRowVal = sheetObj.CellValue( rowNum , "lvl" );
    		
    		if( rowNum != row && orgRowVal <= nowRowVal ) { //처음 시작하는 row가 아닌 경우
    		
    			if( nowRowVal > orgRowVal && oldRowVal <= nowRowVal ) { //지금 row의 lvl값이 이전 보다 크다,, 즉, 계속 증가 하고 있다.
    				
    				if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) == "OTHERS") //현재 row가 dest고 여러개 있는 경우 OTHERS 라면
    					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif; //값 변경
    				else if( nowRowVal < 6 ) //row의 lvl 이 증가 중이면서( 감소된적 없음, 감소되었을때는 위 쪽 if 문에서 걸러줌)
    					sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif;
    				else if( nowRowVal == 6 && sheetObj.CellValue( rowNum , "del_cd" ) != "OTHERS")
    					continue;
    				else
    					break;
    			} else {
    				break;
    			}
    		}
    		oldRowVal = nowRowVal;
    	}
    	
    	//현재 row 가 속한 Yield, L.OFC 범위 내 TTL 값 변경,
//    	var fRow = sheetObj.FindText( "rowOfc" , endRow );
    	var fRow = sheetObj.FindText( "rowOfc", sheetObj.CellValue( row, "rowOfc" ) );
    	var nextVal = orgRowVal-1; //변경한 level 값
    	
    	for( var rowNum = row ; rowNum>=fRow ; rowNum-- ) {
    		nowRowVal = sheetObj.CellValue( rowNum , "lvl" );
    		if( orgRowVal > nowRowVal && nextVal == nowRowVal && row != rowNum ) {//현재 row가 아니고 현재 row의 lvl 보다 작은 값만 변경
    			sheetObj.CellValue2( rowNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rowNum , "bs_teu" ) ) + dif;
    			nextVal -= 1;
    		}
    	}
    	
    	var startRow = 0;
    	var oit_cd = oit.substring(0,1);
    	if( oit_cd == "I" ){
    		startRow = sheetObj.FindText( "ioc_cd" , "IPC" , 0 );
    		endRow = sheetObj.FindText( "ioc_cd" , "T/S" );
    	} else if( oit_cd == "T" ) {
    		startRow = sheetObj.FindText( "ioc_cd" , "T/S" , 0 );
    		endRow = sheetObj.RowCount;
    	} else {
    		endRow = sheetObj.FindText( "ioc_cd" , "IPC" );
    		if( endRow == -1 )
    			sheetObj.FindText( "ioc_cd" , "T/S" , 0 );
    		if( endRow == -1 )
    			endRow = sheetObj.RowCount;
    	}
    	startRow = startRow + sheetObj.HeaderRows;
    	endRow = endRow + sheetObj.HeaderRows;
    	//O/I/T 의 control level이 dest 인경우 TTL, dest TTL 모두 변경
    	//SMP 인경우 TTL의 yield group 값 변경 ==> if(formObj.acctCtrl.value == "Y"){
    	var isSMP = document.getElementById( "acctCtrl" ).value;
    	startRow = sheetObj.FindText( "sls_ofc_cd" , " TTL" , startRow );
    	if( isSMP == "Y" ) { //SMP인 경우 TTS 의 Yield Group 에 변경한 row의 yield 와 동일한 TTL 변경
    		for( var rNum=startRow ; rNum<endRow ; rNum++ ) {
    			var lofc = sheetObj.CellValue( rNum , "sls_ofc_cd" );
    			var ioc = sheetObj.CellValue( rNum , "ioc_cd" );
    			var nCCC = sheetObj.CellValue( rNum , "cust_ctrl_cd" );
    			if( rNum == startRow ){ //TTL 값
    				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
    				
    			} else if( nCCC == yield ) { //변경한 row 의 Cust Control Cd와 동일한것.
    				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
    				
    			} else if( lofc == " DEST TTL" ) {
    				sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
    			} else if( oit != ioc )
    				break;
    		}
    	} else {
    		for( var rNum=startRow ; rNum<endRow ; rNum++ ) {
    			sheetObj.CellValue2( rNum , "bs_teu" ) = parseInt( sheetObj.CellValue( rNum , "bs_teu" ) ) + dif;
    		}
    	}
    }
	/* 개발자 작업  끝 */
