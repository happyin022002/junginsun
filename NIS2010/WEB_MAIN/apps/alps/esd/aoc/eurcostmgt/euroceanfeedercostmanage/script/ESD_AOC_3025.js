/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_AOC_3025.js
*@FileTitle : Ocean Feeder Cost Inquiry(EUR)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
*
* History
* 2013.02.28 이재위 [CHM-201323053-01] [AOC] OCN FDR DG cargo Tab  상에서의 Scale up & down 설정변경
* 2015.02.03 전지예 [CHM-201533794] 45' Cost 추가
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
     * @class ESD_AOC_3025 : esd_aoc_3025 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esd_aoc_3025() {
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
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	var tabNowCnt = 0;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var comboObjects = new Array();
	var comboCnt = 0; 
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){

         var sheetObject1 = sheetObjects[0]; //sheet1
         var sheetObject2 = sheetObjects[1]; //sheet2
         var sheetObject3 = sheetObjects[2]; //sheet3
		 
         /*******************************************************/
         var formObject = document.form;
 		 var objs = document.all.item("tabLayer");
 		 
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

				switch(srcName) {

					case "btn_retrieve":
						formObject.bnt_flg.value = "N";
						doActionIBSheet(sheetObject1, formObject, IBSEARCH, 0);   //tab1
						break;

					case "btn_disp_excel":
						if( objs[0].style.display == "inline" ){
							formObject.bnt_flg.value = "DRY";
							doActionIBSheet(sheetObject1, formObject, IBDOWNEXCEL, 0);   //tab1
						} else if( objs[1].style.display == "inline" ){
							formObject.bnt_flg.value = "DG";
							doActionIBSheet(sheetObject2, formObject, IBDOWNEXCEL, 0);   //tab2
						} else if( objs[2].style.display == "inline" ){
							formObject.bnt_flg.value = "RF";
							doActionIBSheet(sheetObject3, formObject, IBDOWNEXCEL, 0);   //tab2
						}
						break;

		   	        case "from_to_calendar":
	                	var cal = new ComCalendarFromTo();
	                	cal.select(formObject.from_dt, formObject.to_dt, 'yyyy-MM-dd');
		   	            break;

		   	        case "bnt_eff_to_dt":
	                	var cal = new ComCalendar();
	                	cal.select(formObject.eff_to_dt, 'yyyy-MM-dd');
		   	            break;

					case "btn_from":
						openHireYardPopup('getFrom_nod_cd');
						break;

					case "btn_to":
						openHireYardPopup('getTo_nod_cd');
						break;

					case "btn_down_excel1":
						sheetObject1.SpeedDown2Excel(-1);
						break;

					case "btn_cost_detail1":
						popUpCall();
						break;

					case "btn_down_excel2":
						sheetObject1.SpeedDown2Excel(-1);
						break;

					case "btn_down_excel3":
						sheetObject1.SpeedDown2Excel(-1);
						break;

					case "btn_cost_detail3":
						popUpCall();
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

		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
        }

        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

 	 	//IBMultiCombo초기화
 	    for(var c=0; c<comboObjects.length; c++){
 	        initCombo(comboObjects[c], c+1);
 	    }

		initControl();
    }

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */ 
	function initCombo(comboObj, comboNo) {
		var i=0;
		
		//가져온 행을 배열로 반든다.
		var arrRow2Code = f_sys_src_cdCode.split("|");
		var arrRow2Text = f_sys_src_cdText.split("|");

   	    switch(comboObj.id) {
			case "date_flg":  
				with(comboObj) {
					InsertItem(i++, "", "");
					InsertItem(i++, "Batch Creation", "B");
					InsertItem(i++, "Update", "U");
					InsertItem(i++, "Confirm", "C");
				}
				break;

			case "pctl_io_bnd_cd":  
				with(comboObj) {
					InsertItem(i++, "All",  "ALL");
					InsertItem(i++, "Pre", "O");
					InsertItem(i++, "Post", "I");
					comboObj.Code = "ALL";
				}
				break;
				
			case "cost_factor_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "ALL");
					InsertItem(i++,  "Full Trans 20'",  "F2");
					InsertItem(i++,  "Full Trans 40'",  "F4");
					InsertItem(i++,  "Full Trans 45'",  "F45");
					InsertItem(i++,  "Empty 20'",  "E2");
					InsertItem(i++,  "Empty 40'",  "E4");
					InsertItem(i++,  "Empty 45'",  "E45");
					InsertItem(i++,  "TMNL 20'",  "T2");
					InsertItem(i++,  "TMNL 40'",  "T4");					
					InsertItem(i++,  "TMNL 45'",  "T45");
					comboObj.Code = "ALL";
	        	}
				break;

			case "sys_src_cd":
				with(comboObj) {
					comboObj.DropHeight=200;
					comboObj.MultiSelect = true;
					comboObj.MultiSeparator=",";
					comboObj.UseEdit = false;
					InsertItem(i++,  "All",  "ALL");
					for (var j=0; j<arrRow2Code.length; j++){
						InsertItem(i++, arrRow2Text[j], arrRow2Code[j]);
					}
					comboObj.Code = "ALL";
	        	}
				break;

			case "adjustment_cd":  
				with(comboObj) {
					InsertItem(i++, "All", "ALL");
					InsertItem(i++, "=0", "E");
					InsertItem(i++, "≠0", "N");
					comboObj.Code = "ALL";
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
                    style.height = 360;
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

					var HeadTitle1 = "Flag|Tariff No|Status|Effective\nFrom|From|To|Pre/Post|DIR|Feeder Term|Feeder Term|CURR";
					HeadTitle1 += "|Total Cost|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Trans Cost 45'|Trans Cost 45'|Trans Cost 45'|Trans Cost 45'|Trans Cost 45'";	// 45' Cost 추가
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Empty Cost 45'|Empty Cost 45'|Empty Cost 45'|Empty Cost 45'";	// 45' Cost 추가
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Terminal Cost 45'|Terminal Cost 45'|Terminal Cost 45'|Terminal Cost 45'";	// 45' Cost 추가
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Creation|Creation|Creation|Update|Update|Update|cost_trf_rout_seq";

					var HeadTitle2 = "Flag|Tariff No|Status|Effective\nFrom|From|To|Pre/Post|DIR|RCV|DEL|CURR";
					HeadTitle2 += "|20'|40'|45'|SCC|20'|40'|45'";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS2|Weight\n(AGMT)|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS4|Weight\n(AGMT)|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS4|Weight\n(AGMT)|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Time|User|Office|Time|User|Office|cost_trf_rout_seq";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"cost_trf_no",               	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"cost_trf_sts_nm",              false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"eff_fm_dt",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",                	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"curr_cd",           			false, 		"", 		dfNone, 	0, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_45ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false); // 45' Cost 추가
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_45ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false); // 45' Cost 추가
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_20ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_40ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 start
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_45ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_45ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_45ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"agmt_wgt_45ft",            	false, 		"", 		dfNone, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_45ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 end
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 start
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_45ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_45ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_45ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_45ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 end
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 start
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_45ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_45ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_45ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_45ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					// 45' Cost 추가 end
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120,	daCenter, 	true,		"locl_cre_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daLeft, 	true,		"cre_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"cre_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daCenter, 	true,		"locl_upd_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true,		"upd_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"upd_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		false);
				}
				break;

            case "sheet2":
                with (sheetObj) {
					// 높이 설정
                    style.height = 360;
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

                    var HeadTitle1 = "Flag|Tariff No|Status|Effective\nFrom|From|To|BND|DIR|Feeder Term|Feeder Term|CURR";
					HeadTitle1 += "|Service Provider|Service Provider|OLD AGMT|Dry Cost|Dry Cost";
					HeadTitle1 += "|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1|IMDG Class 1";
					HeadTitle1 += "|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2|IMDG Class 2";
					HeadTitle1 += "|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3|IMDG Class 3";
					HeadTitle1 += "|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4|IMDG Class 4";
					HeadTitle1 += "|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5|IMDG Class 5";
					HeadTitle1 += "|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6|IMDG Class 6";
					HeadTitle1 += "|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7|IMDG Class 7";
					HeadTitle1 += "|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8|IMDG Class 8";
					HeadTitle1 += "|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9|IMDG Class 9";
					HeadTitle1 += "|Creation|Creation|Creation|Update|Update|Update";

					var HeadTitle2 = "Flag|Tariff No|Status|Effective\nFrom|From|To|BND|DIR|RCV|DEL|CURR";
					HeadTitle2 += "|Code|Name|OLD AGMT|20'|40'";
					HeadTitle2 += "|SVC_1|20' SCHG_1|40' SCHG_1|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_2|20' SCHG_2|40' SCHG_2|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_3|20' SCHG_3|40' SCHG_3|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_4|20' SCHG_4|40' SCHG_4|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_5|20' SCHG_5|40' SCHG_5|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_6|20' SCHG_6|40' SCHG_6|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_7|20' SCHG_7|40' SCHG_7|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_8|20' SCHG_8|40' SCHG_8|20' TTL|40' TTL";
					HeadTitle2 += "|SVC_9|20' SCHG_9|40' SCHG_9|20' TTL|40' TTL";
					HeadTitle2 += "|Time|User|Office|Time|User|Office";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"cost_trf_no",               	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"cost_trf_sts_nm",              false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"eff_fm_dt",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",                  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daLeft, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"curr_cd",           			false, 		"", 		dfNone, 	0, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n1st_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n1st_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n2nd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n2nd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n3rd_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n3rd_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n4th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n4th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n5th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n5th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n6th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n6th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n7th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n7th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n8th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n8th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtCombo,			50, daCenter, 	true,		"imdg_n9th_clss_svc_flg",       false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_20ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_40ft_scg_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_20ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"imdg_n9th_clss_40ft_ttl_amt",  false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120,	daCenter, 	true,		"locl_cre_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daLeft, 	true,		"cre_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"cre_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daCenter, 	true,		"locl_upd_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true,		"upd_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"upd_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
				}
				break;
				
            case "sheet3":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 360;
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

                    var HeadTitle1 = "Flag|Tariff No|Status|Effective\nFrom|From|To|Pre/Post|DIR|Feeder Term|Feeder Term|CURR";
					HeadTitle1 += "|Total Cost|Total Cost|M/B Ratio|M/B Ratio|M/B Ratio";
					HeadTitle1 += "|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'|Trans Cost 20'";
					HeadTitle1 += "|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'|Trans Cost 40'";
					HeadTitle1 += "|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'|Empty Cost 20'";
					HeadTitle1 += "|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'|Empty Cost 40'";
					HeadTitle1 += "|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'|Terminal Cost 20'";
					HeadTitle1 += "|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'|Terminal Cost 40'";
					HeadTitle1 += "|Service Provider|Service Provider|OLD\nAGMT|Creation|Creation|Creation|Update|Update|Update|cost_trf_rout_seq";

					var HeadTitle2 = "Flag|Tariff No|Status|Effective\nFrom|From|To|Pre/Post|DIR|RCV|DEL|CURR";
					HeadTitle2 += "|20'|40'|SCC|20'|40'";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TRS4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_MTY4|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL2|Total";
					HeadTitle2 += "|System\nSource|System\nAmount|ADJ_TMNL4|Total";
					HeadTitle2 += "|Code|Name|OLD\nAGMT|Time|User|Office|Time|User|Office|cost_trf_rout_seq";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					InitHeadRow(1, HeadTitle2, false);

					//데이터속성[		ROW,COL,	DATATYPE,    	 WIDTH,	DATAALIGN,	COLMERGE,	SAVENAME,						KEYFIELD, 	CALCULOGIC,	DATAFORMAT,	POINTCOUNT,	UPDATEEDIT,	INSERTEDIT,	EDITLEN,	FULLINPUT,	SORTENABLE,	TOOLTIP,	ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++, 	dtHiddenStatus,		30,	daCenter,	false,		"ibflag");
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"cost_trf_no",               	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"cost_trf_sts_nm",              false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"eff_fm_dt",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"fm_nod_cd",               		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daCenter, 	true,		"to_nod_cd",                	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daCenter, 	true,		"pctl_io_bnd_nm",              	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"dir_cd",                		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_rcv_term_cd",             	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"wtr_de_term_cd",           	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"curr_cd",           			false, 		"", 		dfNone, 	0, 			false,		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_20ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"fdr_40ft_ttl_amt",        		false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				50, daCenter, 	true,		"scc_cd",           			false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_20ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				65, daRight, 	true,		"mb_40ft_rto",        			false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_20ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_20ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_20ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"trsp_40ft_cost_sys_src_nm", 	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_cost_amt",        	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"trsp_40ft_adj_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"trsp_40ft_ttl_cost_amt",    	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_20ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_20ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_20ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"mty_trsp_40ft_cost_sys_src_nm",false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_cost_amt",       false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"mty_trsp_40ft_adj_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"mty_trsp_40ft_ttl_cost_amt",   false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_20ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_20ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_20ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"tml_40ft_cost_sys_src_nm",  	false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_cost_amt",         	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				70, daRight, 	true,		"tml_40ft_adj_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daRight, 	true,		"tml_40ft_ttl_cost_amt",     	false, 		"", 		dfFloat, 	2, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,				60, daCenter, 	true,		"vndr_seq",             		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData,			   120,	daLeft, 	true,		"vndr_nm",              		false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"agmt_old_flg", 				false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120,	daCenter, 	true,		"locl_cre_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daLeft, 	true,		"cre_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"cre_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daCenter, 	true,		"locl_upd_dt", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 		   120, daLeft, 	true,		"upd_usr_nm", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtData, 			70, daCenter, 	true,		"upd_ofc_cd", 					false, 		"", 		dfNone, 	0, 			false, 		false);
					InitDataProperty(0, cnt++, 	dtHidden,			75, daCenter, 	true,		"cost_trf_rout_seq",			false, 		"", 		dfNone, 	0, 			false, 		false);
				}
				break;

        	case "sheet4":
        		with (sheetObj) {
					// 높이 설정
                    style.height = 320;
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

					var HeadTitle1 = "Flag|Country|BND|Tariff No|Status|Effective\nFrom|Port-LOC|R/D\nTerm|C|Port|Hub|LOC|Trans\nMode|Total Cost|Total Cost|LOC\nGroup|M/B Ratio|M/B Ratio|M/B Ratio";

					var HeadTitle2 = "Flag|Country|BND|Tariff No|Status|Effective\nFrom|Port-LOC|R/D\nTerm|C|Port|Hub|LOC|Trans\nMode|20'|40'|LOC\nGroup|SCC|20'|40'";
					
					var headCount = ComCountHeadTitle(HeadTitle2);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    //InitHeadMode(true, true, false, true, false,false)
					InitHeadMode(true, true, true, true, false, false)

				}
				break;
        }
    }

	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction, msgFlg) {
		sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH: //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					//Down Excel without Displaying 버튼 클릭 시 조회 시점의 동일한 데이터를 가져오기 위해 조건을 임시 보관
					formObj.excel_date_flg.value 		= comboObjects[0].Code;
					formObj.excel_pctl_io_bnd_cd.value 	= comboObjects[1].Code;
					formObj.excel_cost_factor_cd.value 	= comboObjects[2].Code;
					formObj.excel_sys_src_cd.value 		= comboObjects[3].Code;
					formObj.excel_adjustment_cd.value 	= comboObjects[4].Code;
					formObj.excel_from_dt.value 		= formObj.from_dt.value;
					formObj.excel_to_dt.value 			= formObj.to_dt.value;
					formObj.excel_eff_to_dt.value 		= formObj.eff_to_dt.value;
					formObj.excel_cost_trf_no.value 	= formObj.cost_trf_no.value;
					formObj.excel_from_nod_cd.value 	= formObj.from_nod_cd.value;
					formObj.excel_to_nod_cd.value 		= formObj.to_nod_cd.value;
					
					
					formObj.f_cmd.value = SEARCH;
		        	var sParam = FormQueryString(formObj);
					var sXml = sheetObj.GetSearchXml("ESD_AOC_3025GS.do", sParam);
					var arrXml = sXml.split("|$$|");
					sheetObjects[0].LoadSearchXml(arrXml[0]);
					sheetObjects[1].LoadSearchXml(arrXml[1]);
					sheetObjects[2].LoadSearchXml(arrXml[2]);
				}	
				break;
				
			case IBDOWNEXCEL:
				ComOpenWait(true);
			    formObj.f_cmd.value = SEARCH01;
			    formObj.target = "_blank";
				formObj.action = "ESD_AOC_3025EXCEL.do?"+ AocFrmQryString(formObj);
			    formObj.submit();
			    ComOpenWait(false);
		        break;
		        
			case SEARCH02:
				formObj.f_cmd.value = SEARCH02;
	        	var sParam = AocFrmQryString(formObj);
				var sXml = sheetObj.GetSearchXml("ESD_AOC_3025GS.do", sParam);
				var err_flg = ComGetEtcData(sXml, "err_flg");
				
				if( err_flg == "Y" ){
					ComShowCodeMessage("AOC90034");
					formObj.cost_trf_no.value = "";
					ComAlertFocus(formObj.cost_trf_no, "");
					return;
				}
		        break;

        }
    }

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSEARCH:
		
				if(comboObjects[0].Code == "" && ComIsEmpty(formObj.eff_to_dt.value) && ComIsEmpty(formObj.to_nod_cd.value) && ComIsEmpty(formObj.from_nod_cd.value) && ComIsEmpty(formObj.cost_trf_no.value)){
					ComShowCodeMessage("AOC90021");
					return false;
				}
			
        		if(comboObjects[0].Code != "" && !ComIsEmpty(formObj.eff_to_dt.value)){
					ComShowCodeMessage("AOC90022");
					return false;
				}

				break;
		}
        return true;
    }
	
    /* initControl() */
    function initControl() {
 		axon_event.addListenerForm('keypress', 'obj_keypress',  form);    	  
    	axon_event.addListenerFormat('focus', 'obj_activate', form);
    	axon_event.addListenerForm ('blur', 'obj_blur', form);
		
    }
    
    /** 
     * Object 의 Keypress 이벤트에 대한 처리  <br>
     * 객체의 dataformat 에 따라 입력값에 대한 유효성을 체크한다.  <br>
     * @param  없음
     * @return 없음
     * @author 김종옥
     * @version 2009.06.15
     */ 
    function obj_keypress(){
     	obj = event.srcElement;
     	if(obj.dataformat == null) return;
     	 	
     	window.defaultStatus = obj.dataformat;
     	 
     	switch(obj.dataformat) {
			case "uppernum":
				// 영문 대문자만 입력하기, 영문대+숫자
				ComKeyOnlyAlphabet('uppernum');
				break;
			case "upper":
				// 영문 대문자만 입력하기
				ComKeyOnlyAlphabet('upper');
				break;
        	case "ymd":
        		ComKeyOnlyNumber(event.srcElement);
            	break;
			case "engupcomma": //영문대문자+Comma
				ComKeyOnlyAlphabet('upper', '44');
            	break;
			case "uppernumcomma": //영문대문자+숫자+Comma
				ComKeyOnlyAlphabet('uppernum', '44');
            	break;
     	}
    }    
    

    //업무 자바스크립트 OnFocus 이벤트 처리
    function obj_activate() {
       	//마스크 구분자 없애기
        //ComClearSeparator(event.srcElement);
           
       	switch(event.srcElement.name){ 	    	
       		case "from_dt":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       		case "to_dt":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;
       		case "eff_to_dt":
       			ComClearSeparator(event.srcElement);
       			event.srcElement.select();
       			break;				
       	}
    }

    /** 
     * 업무 자바스크립트 Onblur 이벤트 처리  <br>
     */    
    function obj_blur(){
    	obj = event.srcElement;
    	var formObj = document.form;

    	switch(obj.name) {
			case "from_dt":
    			if( formObj.from_dt.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("from_dt", "");
                    	setFocus("from_dt");
                    	return false;
                    }
                }
    			break;
    		case "to_dt":
    			if( formObj.to_dt.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("to_dt", "");
                    	setFocus("to_dt");
                    	return false;
                    }
                }
    			break;
				
    		case "eff_to_dt":
    			if( formObj.eff_to_dt.value != ""){
                    if(!ComChkObjValid(obj)){
                    	setObjValue("eff_to_dt", "");
                    	setFocus("eff_to_dt");
                    	return false;
                    }
                }
    			break;
    			
    		case "cost_trf_no":
    			if( formObj.cost_trf_no.value != "" ){
    				doActionIBSheet(sheetObjects[3], formObj, SEARCH02, 0);
    			}
    			break;
    	}
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
                    InsertTab( cnt++ , "Dry" , -1 );
                    InsertTab( cnt++ , "Dangerous" , -1 );
                    InsertTab( cnt++ , "Reefer" , -1 );
                }
           		break;
         }
    }

    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tab1_OnChange(tabObj , nItem)
    {
        var objs = document.all.item("tabLayer");
        var formObject = document.form;

	    objs[nItem].style.display = "Inline";
	    objs[beforetab].style.display = "none";

	    //--------------- 요기가 중요 --------------------------//
	    objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	    //------------------------------------------------------//
	    beforetab= nItem;
	}


    /**
     * 화면 폼입력값에 Null Check
     */
    function isNull(itemValue){
        if(itemValue==null || itemValue=="" || itemValue=="undefined"){
        	return true;
        }
        else{
        	return false;
        }
    }
	
	function getFrom_nod_cd(rowArray) {
		var colArray = rowArray[0];
		if( document.form.from_nod_cd.value != ""){
			document.form.from_nod_cd.value = document.form.from_nod_cd.value + "," + colArray[3];
		} else{
			document.form.from_nod_cd.value = colArray[3];
		}
		document.form.from_nod_cd.focus();
	}
	
	function getTo_nod_cd(rowArray) {
		var colArray = rowArray[0];
		if( document.form.to_nod_cd.value != ""){
			document.form.to_nod_cd.value = document.form.to_nod_cd.value + "," + colArray[3];
		} else{
			document.form.to_nod_cd.value = colArray[3];
		}
		document.form.to_nod_cd.focus();
	}
	
	/**
	 * 공통 Node popup
	 */
	function openHireYardPopup(objName) {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId = objName;
		var xx1 = ""; //CONTI
		var xx2 = ""; //SUB CONTI
		var xx3 = ""; //COUNTRY
		var xx4 = ""; //STATE
		var xx5 = ""; //CONTROL OFFIC
		var xx6 = ""; //LOC CODE
		var xx7 = ""; //LOC NAME
		var xx8 = "";
		var xx9 = "";
		v6 = "yard";

		var param ="?conti_cd="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&mode="+v6;
		ComOpenPopup('/hanjin/COM_ENS_061.do' + param, 772, 450, objName, '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	
	/**
	* 팝업호출
	*/
	function so_OnPopupClick(val) {
		var formObject = document.form;
		var cmdt_cd_val ="";   //향후 사용가능 예정변수
		var rep_cmdt_cd_val ="";   //향후 사용가능 예정변수
		var cmdt_desc_val ="";   //향후 사용가능 예정변수
		var classId ="getCOM_ENS_so";
		var xx1=val;  //CONTI
		var xx2="";  //SUB CONTI
		var xx3="";  //COUNTRY
		var xx4="";  //STATE
		var xx5="";  //CONTROL OFFIC
		var xx6="";  //LOC CODE
		var xx7="";  //LOC NAME
		var xx8="";
		var xx9="";
		var title = val;
		if (val == "sw" ) {
			if(formObject.radio_gubun[0].checked)  {
				title = "S/O No.";
			} else {
				title = "W/O No.";
			}
		}
		var param ="?returnval="+xx1+"&sconti_cd="+xx2+"&cnt_cd="+xx3+"&loc_state="+xx4+"&loc_eq_ofc="+xx5+"&loc_cd="+xx6+"&loc_desc="+xx7+"&loc_port_ind="+xx8+"&iPage="+xx9+"&returntitle="+title;
		ComOpenPopup('/hanjin/ESD_TRS_0906.do' + param, 412, 330, 'getCOM_ENS_906', '1,0,1,1,1,1,1,1,1,1,1,1');
	}
	
	/**
	* Multi Select
	*/
	function getTRS_ENS_906(rowArray,returnval) {
		var formObject = document.form;
	
		if(returnval=="cost_trf_no") {
			var x1=document.form.cost_trf_no.value;
			if(x1==""){
				document.form.cost_trf_no.value = rowArray;
			}else{
				document.form.cost_trf_no.value = document.form.cost_trf_no.value+","+rowArray;
			}
			document.form.cost_trf_no.value = document.form.cost_trf_no.value.toUpperCase()
			formObject.cost_trf_no.focus();
		}else if(returnval=="from") {
			var x1=document.form.from_nod_cd.value;
			if(x1==""){
				document.form.from_nod_cd.value = rowArray;
			}else{
				document.form.from_nod_cd.value = document.form.from_nod_cd.value+","+rowArray;
			}
			document.form.from_nod_cd.value = document.form.from_nod_cd.value.toUpperCase()
			formObject.from_nod_cd.focus();
		}else if(returnval=="to") {
			var x1=document.form.to_nod_cd.value;
			if(x1==""){
				document.form.to_nod_cd.value = rowArray;
			}else{
				document.form.to_nod_cd.value = document.form.to_nod_cd.value+","+rowArray;
			}
			document.form.to_nod_cd.value = document.form.to_nod_cd.value.toUpperCase()
			formObject.to_nod_cd.focus();
		}
	}	

	function cost_factor_cd_OnCheckClick(comboObj, index, code) {
		if( code == "ALL" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	function sys_src_cd_OnCheckClick(comboObj, index, code) {
		if( code == "ALL" ){
			if( comboObj.CheckIndex(0) == false ){
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = false;
			} else{
				comboObj.Code = "ALL";
				comboObj.CheckIndex(0) = true;
			}
		} else{
			comboObj.CheckIndex(0) = false;
		}
	}

	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		var formObj = document.form;
		if( sheetObj.RowCount >= 3000 ){
			ComShowCodeMessage("AOC90023");
		}
	}
	
	function popUpCall(){
		if( document.all.item("tabLayer")[0].style.display == "inline" ){
			var sheetObj = sheetObjects[0];
			var acct_tbl_div = "AOC_EUR_FDR_TRF_ACCT";
		} else if( document.all.item("tabLayer")[2].style.display == "inline" ){
			var sheetObj = sheetObjects[2];
			var acct_tbl_div = "AOC_EUR_FDR_RF_TRF_ACCT";
		}
		
		if( sheetObj.RowCount > 0 ){
			var param = "";
			param = param + '?cost_trf_no=' 		+ sheetObj.CellValue(sheetObj.SelectRow,"cost_trf_no");
			param = param + '&cost_trf_rout_seq=' 	+ sheetObj.CellValue(sheetObj.SelectRow,"cost_trf_rout_seq");
			param = param + '&fm_nod_cd=' 			+ sheetObj.CellValue(sheetObj.SelectRow,"fm_nod_cd");
			param = param + '&to_nod_cd='			+ sheetObj.CellValue(sheetObj.SelectRow,"to_nod_cd");
			param = param + '&io_bnd_nm='			+ sheetObj.CellValue(sheetObj.SelectRow,"pctl_io_bnd_nm");
			param = param + '&curr_cd='				+ sheetObj.CellValue(sheetObj.SelectRow,"curr_cd");
			param = param + '&ttlAmt20='			+ sheetObj.CellValue(sheetObj.SelectRow,"fdr_20ft_ttl_amt");
			param = param + '&ttlAmt40='			+ sheetObj.CellValue(sheetObj.SelectRow,"fdr_40ft_ttl_amt");
			param = param + '&ttlAmt45='			+ sheetObj.CellValue(sheetObj.SelectRow,"fdr_45ft_ttl_amt");
			param = param + '&acct_tbl_div=' 		+ acct_tbl_div;
			
			ComOpenPopup('/hanjin/ESD_AOC_3023.do' + param, 1024,620,'', '1,0,1,1,1,1,1,1');
		}
	}

	/* 개발자 작업  끝 */