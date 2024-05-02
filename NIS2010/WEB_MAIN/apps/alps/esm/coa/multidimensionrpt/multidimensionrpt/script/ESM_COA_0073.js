/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0073.jsp
*@FileTitle : MT Adjusted cost detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 이석준
*@LastVersion : 1.0
* 2010.10.12 이석준
* 1.0 Creation
*=========================================================
* History
* 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
* 2012.12.13 송호진 [CHM-201221879]    [COA] Manual Cost Set up 화면 로직 수정
* 2013.02.21 최성민 [CHM-201323054] [COA] Manual Cost Set up 화면 수정 - US Domestic 계정 hidden처리
* 2013.12.05 최성민 [CHM-201327977] [COA] P&L by Lane -> Adjusted Cost Detail 상 ABC 관련 항목 삭제
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
     * @class ESM_COA_0073 : ESM_COA_0073 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_COA_0073() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
	//공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;

	/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	function processButtonClick(){
		var sheetObject = sheetObjects[0];
		var formObject = document.form;
		
		try {
			var srcName = window.event.srcElement.getAttribute("name");
			switch(srcName) {
				case "btn_Retrieve":		//조회
					doActionIBSheet(sheetObject,formObject,IBSEARCH);
					break;
				case "btn_plan_exp":			//저장
					ComOpenPopup('/hanjin/ESM_COA_0074.do',500, 300, 'getVVD', '1,0,1,1,1,1,1,1',true)
					break;
				case "btn_downexcel":			//저장
					
					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
					break;
					
				case "btn_Close":
					window.close();
					break;
			
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(ComGetMsg("COM12111", "", ""));
			} else {
				ComShowMessage(e);
			}
		}
	}
	
	function loadPage(){
		for(i=0;i<sheetObjects.length;i++){
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}		
	}
	
    
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetNo) {
			case 1:		//sheet1 init
				with (sheetObj) {
					style.height = GetSheetHeight(23) ;
					
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet =  msHeaderOnly;  //msNone; //msHeaderOnly //msPrevColumnMerge;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = false;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(3, 1, 9, 100);
					
					var com_head = "|SEQ|R.Month|S.Month|Week|Trade|Sub\nTrade|R.Lane|IOC|Vessel|Voyage|Dir|";
					var head1 =   "Initial AMT|Initial AMT|Initial AMT|Initial AMT|Initial AMT|Initial AMT|Initial AMT|"
						        + "Adjusted Cost|Adjusted Cost|"
						        + "Final AMT|Final AMT|Final AMT|Final AMT|Final AMT|Final AMT"
						        
					var head2 =   "MTY CNTR Steve (P&L)|MTY CNTR Steve (P&L)|MTY CNTR Trans (P&L)|MTY CNTR Trans (P&L)|MTY CNTR Trans (P&L)|MTY CNTR Trans (P&L)|MTY CNTR Trans (P&L)|MTY CNTR Steve\nAdjusted Cost|MTY CNTR Trans\nAdjusted Cost\n(c)|"
								+ "MTY CNTR Steve\n(Adjusted P&L)|MTY CNTR Trans\n(Adjusted P&L)|MTY CNTR Trans\n(Adjusted P&L)|MTY CNTR Trans\n(Adjusted P&L)|MTY CNTR Trans\n(Adjusted P&L)";
					
					var head3 =   "MTY CNTR Steve\n(P&L)|Ratio (%)|MTY CNTR Trans\n(P&L)|Domestic\nSaving Credit\n(a)|Domestic Cost \n(HRP,TRP)\n(b)|MTY CNTR Trans\n(A)=(P&L)+(a)-(b)|Ratio (%)|MTY CNTR Steve\nAdjusted Cost|MTY CNTR Trans\nAdjusted Cost\n(c)|"
								+ "MTY CNTR Steve\n(Adjusted P&L)|MTY CNTR Trans\n(A')=(A)+(c)|Domestic \nSaving Credit\n(a)|Domestic Cost\n(HRP,TRP)\n(b)|MTY CNTR Trans\n(Adjusted P&L)\n(A')-(a)+(b)";
			       
					var HeadTitle0 = com_head + head1;
			        var HeadTitle1 = com_head + head2;
			        var HeadTitle2 = com_head + head3;
			        
			        var headCount = ComCountHeadTitle(HeadTitle2);
					
			        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 0, 0, true);
					// 헤더에서 처리할 수 있는 각종 기능을 설정한다 [SortEnable,ColumnMove,AllCheckEnable,UserResize,RowMove,Head3D]
					InitHeadMode(false, false, false, true, false, false);

					//헤더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			        InitHeadRow(0, HeadTitle0, true);
			        InitHeadRow(1, HeadTitle1, true);
			        InitHeadRow(2, HeadTitle2, true);
			          
					//데이터속성  DataRow, Col, [DataType], [Width], [DataAlign],
					//          [ColMerge], [SaveName], [KeyField], [CalcuLogic], [DataFormat],
					//          [PointCount], [UpdateEdit], [InsertEdit], [EditLen], [FullInput], [ColumnSort],
					//          [ToolTipText], [VisAllCheck], [SaveStatus] , [FormatFix]
					var cnt = 0;
					InitDataProperty(0, cnt++, dtHiddenStatus,  30, 	daCenter, 	true,	"ibflag",					false, 	"", 	dfNone,    0, false, false);
					InitDataProperty(0, cnt++, dtSeq,    		30, 	daCenter, 	true,  	"seq",						false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		60, 	daCenter, 	true,  	"cost_yrmon",				false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		60, 	daCenter, 	true,  	"sls_yrmon",				false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		40, 	daCenter, 	true,  	"cost_wk",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		40, 	daCenter, 	true,  	"trd_cd",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		40, 	daCenter, 	true,  	"sub_trd_cd",				false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		60, 	daCenter, 	true,  	"rlane_cd",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		40, 	daCenter, 	true,  	"ioc_cd",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		50, 	daCenter, 	true,  	"vsl_cd",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		50, 	daCenter, 	true,  	"skd_voy_no",				false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		30, 	daCenter, 	true,  	"dir_cd",					false,  "", 	dfNone);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"mty_cntr_stvg_amt",		false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		70, 	daRight, 	true,  	"mty_cntr_stvg_rt",			false,  "", 	dfFloatOrg,2);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"mty_cntr_trsp_amt",		false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,   		100, 	daRight, 	true,  	"usa_dmst_sav_cr_amt",		false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,   		100, 	daRight, 	true,  	"usa_dmst_repo_amt",		false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		120, 	daRight, 	true,  	"mty_cntr_trsp_incl_cr_amt",false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		70, 	daRight, 	true,  	"mty_cntr_trsp_rt",			false,  "", 	dfFloatOrg,2);
					//InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"biz_act_amt",				false,  "", 	dfInteger,0);
					//InitDataProperty(0, cnt++, dtData,    		70, 	daRight, 	true, 	"biz_act_rt",				false,  "", 	dfFloatOrg,2);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true, 	"mty_cntr_stvg_adj_amt",	false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"mty_cntr_trsp_adj_amt",	false,  "", 	dfInteger,0);
					//InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"biz_act_adj_amt",			false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"mty_cntr_stvg_fnl_amt",	false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"mty_cntr_trsp_fnl_amt",	false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"usa_dmst_sav_cr_amt2",	false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"usa_dmst_repo_amt2",	false,  "", 	dfInteger,0);
					InitDataProperty(0, cnt++, dtData,    		120, 	daRight, 	true,  	"trsp_xcld_cr_fnl_amt",		false,  "", 	dfInteger,0);
					//InitDataProperty(0, cnt++, dtData,    		100, 	daRight, 	true,  	"biz_act_fnl_amt",			false,  "", 	dfInteger,0);
				}
				break;
		}
	}
	
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++] = sheet_obj;
	}
	
	function doActionIBSheet(sheetObj,formObj,sAction) {

		sheetObj.ShowDebugMsg = false;
		sheetObj.WaitImageVisible = false;	//  업무처리중 버튼사용 금지 처리
		
		switch(sAction) {
			case IBSEARCH:      //조회
				// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCHLIST01;
				sheetObj.DoSearch4Post("ESM_COA_0073GS.do", coaFormQueryString(formObj));
				ComOpenWait(false);
				break;
                
  			case IBDOWNEXCEL:	//엑셀 다운로드
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
		}
		
	}
	
//    function sheet1_OnLoadFinish(sheetObj) {
//    	sheetObj.AutoSumBottom =2;
//    }	
    
	/**
	* sheet1조회후   hidden setting
	*/
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        if (ErrMsg != "") return;
        with (sheetObj) {
            if (RowCount > 0) {
                ReDraw = false;
                var initial_row = DataInsert(-1);//
                sheetObj.ColBackColor("mty_cntr_trsp_amt")= sheetObj.RgbColor(192,192,192);
                sheetObj.ColBackColor("usa_dmst_sav_cr_amt")= sheetObj.RgbColor(192,192,192);
                sheetObj.ColBackColor("usa_dmst_repo_amt")= sheetObj.RgbColor(192,192,192);
                sheetObj.ColBackColor("mty_cntr_trsp_fnl_amt")= sheetObj.RgbColor(192,192,192);
                sheetObj.ColBackColor("usa_dmst_sav_cr_amt2")= sheetObj.RgbColor(192,192,192);
                sheetObj.ColBackColor("usa_dmst_repo_amt2")= sheetObj.RgbColor(192,192,192);
                SetMergeCell(initial_row,2,0,10);
                RowBackColor(initial_row) = RgbColor(192,192,192);
                CellValue2(initial_row,"cost_yrmon") = "Initial Amount Total";
                CellValue2(initial_row,"mty_cntr_stvg_amt")    		= ComputeSum("|mty_cntr_stvg_amt|");
                CellValue2(initial_row,"mty_cntr_stvg_rt")     		= ComputeSum("|mty_cntr_stvg_rt|");
                CellValue2(initial_row,"mty_cntr_trsp_amt")    		= ComputeSum("|mty_cntr_trsp_amt|");
                CellValue2(initial_row,"usa_dmst_sav_cr_amt")  		= ComputeSum("|usa_dmst_sav_cr_amt|");
                CellValue2(initial_row,"usa_dmst_repo_amt")  		= ComputeSum("|usa_dmst_repo_amt|");
                CellValue2(initial_row,"mty_cntr_trsp_incl_cr_amt")	= ComputeSum("|mty_cntr_trsp_incl_cr_amt|");
                CellValue2(initial_row,"mty_cntr_trsp_rt")     		= ComputeSum("|mty_cntr_trsp_rt|");
                //CellValue2(initial_row,"biz_act_amt")          		= ComputeSum("|biz_act_amt|");
                //CellValue2(initial_row,"biz_act_rt")           		= ComputeSum("|biz_act_rt|");
                CellValue2(initial_row,"mty_cntr_stvg_adj_amt")		= ComputeSum("|mty_cntr_stvg_adj_amt|");
                CellValue2(initial_row,"mty_cntr_trsp_adj_amt")		= ComputeSum("|mty_cntr_trsp_adj_amt|");
                //CellValue2(initial_row,"biz_act_adj_amt")      		= ComputeSum("|biz_act_adj_amt|");
                CellValue2(initial_row,"mty_cntr_stvg_fnl_amt")		= ComputeSum("|mty_cntr_stvg_fnl_amt|");
                CellValue2(initial_row,"mty_cntr_trsp_fnl_amt")		= ComputeSum("|mty_cntr_trsp_fnl_amt|");
                CellValue2(initial_row,"usa_dmst_sav_cr_amt2")  	= ComputeSum("|usa_dmst_sav_cr_amt2|");
                CellValue2(initial_row,"usa_dmst_repo_amt2")  		= ComputeSum("|usa_dmst_repo_amt2|");
                CellValue2(initial_row,"trsp_xcld_cr_fnl_amt")		= ComputeSum("|trsp_xcld_cr_fnl_amt|");
                //CellValue2(initial_row,"biz_act_fnl_amt")      		= ComputeSum("|biz_act_fnl_amt|");

                var planned_row = DataInsert(-1);
                SetMergeCell(planned_row,2,0,10);
                RowBackColor(planned_row) = RgbColor(192,192,192);
                CellValue2(planned_row,"cost_yrmon") = "Planned Amount Total"
                CellValue2(planned_row,"mty_cntr_stvg_amt")    		=  CellValue(initial_row,"mty_cntr_stvg_fnl_amt")
                CellValue2(planned_row,"mty_cntr_trsp_incl_cr_amt")	=  CellValue(initial_row,"mty_cntr_trsp_fnl_amt")
                //CellValue2(planned_row,"biz_act_amt")          		=  CellValue(initial_row,"biz_act_fnl_amt")
                CellValue2(planned_row,"mty_cntr_stvg_adj_amt")		=  CellValue(initial_row,"mty_cntr_stvg_adj_amt")
                CellValue2(planned_row,"mty_cntr_trsp_adj_amt")		=  CellValue(initial_row,"mty_cntr_trsp_adj_amt")
                //CellValue2(planned_row,"biz_act_adj_amt")      		=  CellValue(initial_row,"biz_act_adj_amt")
                CellValue2(planned_row,"mty_cntr_stvg_fnl_amt")		=  CellValue(initial_row,"mty_cntr_stvg_fnl_amt")
                CellValue2(planned_row,"mty_cntr_trsp_fnl_amt")		=  CellValue(initial_row,"mty_cntr_trsp_fnl_amt")
                CellValue2(planned_row,"usa_dmst_sav_cr_amt2")		=  CellValue(initial_row,"usa_dmst_sav_cr_amt2")
                CellValue2(planned_row,"usa_dmst_repo_amt2")		=  CellValue(initial_row,"usa_dmst_repo_amt2")
                CellValue2(planned_row,"trsp_xcld_cr_fnl_amt")		=  CellValue(initial_row,"trsp_xcld_cr_fnl_amt")
                //CellValue2(planned_row,"biz_act_fnl_amt")      		=  CellValue(initial_row,"biz_act_fnl_amt")
                
                var dif_row =     DataInsert(-1);
                SetMergeCell(dif_row,2,0,10);
                RowBackColor(dif_row) = RgbColor(192,192,192);
                CellValue2(dif_row,"cost_yrmon") = "Difference"
                CellValue2(dif_row,"mty_cntr_stvg_amt")        	=  CellValue(initial_row,"mty_cntr_stvg_amt")     - CellValue(planned_row,"mty_cntr_stvg_amt")
                //CellValue2(dif_row,"mty_cntr_trsp_amt")        =  CellValue(initial_row,"mty_cntr_trsp_amt")     - CellValue(planned_row,"mty_cntr_trsp_amt")
                CellValue2(dif_row,"usa_dmst_sav_cr_amt")      	=  CellValue(initial_row,"usa_dmst_sav_cr_amt")   - CellValue(planned_row,"usa_dmst_sav_cr_amt")
                CellValue2(dif_row,"usa_dmst_repo_amt")        	=  CellValue(initial_row,"usa_dmst_repo_amt")     - CellValue(planned_row,"usa_dmst_repo_amt")
                CellValue2(dif_row,"mty_cntr_trsp_incl_cr_amt")	=  CellValue(initial_row,"mty_cntr_trsp_incl_cr_amt")   - CellValue(planned_row,"mty_cntr_trsp_incl_cr_amt")
                //CellValue2(dif_row,"biz_act_amt")              	=  CellValue(initial_row,"biz_act_amt")           - CellValue(planned_row,"biz_act_amt")
                //CellValue2(dif_row,"mty_cntr_stvg_adj_amt")    	=  CellValue(initial_row,"mty_cntr_stvg_adj_amt") - CellValue(planned_row,"mty_cntr_stvg_adj_amt")
                //CellValue2(dif_row,"mty_cntr_trsp_adj_amt")    	=  CellValue(initial_row,"mty_cntr_trsp_adj_amt") - CellValue(planned_row,"mty_cntr_trsp_adj_amt")
                //CellValue2(dif_row,"biz_act_adj_amt")          	=  CellValue(initial_row,"biz_act_adj_amt")       - CellValue(planned_row,"biz_act_adj_amt")
                //CellValue2(dif_row,"mty_cntr_stvg_fnl_amt")    	=  CellValue(initial_row,"mty_cntr_stvg_fnl_amt") - CellValue(planned_row,"mty_cntr_stvg_fnl_amt")
                //CellValue2(dif_row,"mty_cntr_trsp_fnl_amt")    	=  CellValue(initial_row,"mty_cntr_trsp_fnl_amt") - CellValue(planned_row,"mty_cntr_trsp_fnl_amt")
                //CellValue2(dif_row,"biz_act_fnl_amt")          	=  CellValue(initial_row,"biz_act_fnl_amt")       - CellValue(planned_row,"biz_act_fnl_amt")
                
                CellFont("FontBold",initial_row,"cost_yrmon",dif_row,"trsp_xcld_cr_fnl_amt") =true;
                ReDraw = true;
            }
        }
	   
	}    
	
	/* 개발자 작업  끝 */