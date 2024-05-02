/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S304.js
*@FileTitle  : My Bidding List  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
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
     * @class EES_MNR_S304 : EES_MNR_S304 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
/* 개발자 작업	*/ 	
// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
//쉬트 
var sheetObjects=new Array();
var sheetCnt=0;
//파일업로드를 사용하기 위한 
var uploadObjects=new Array();
var uploadCnt=0;
//콤보 객체   
var comboObjects=new Array();
var comboCnt=0; 
//파일Seq저장변수 (추가될때) 
var uploadFileSeq="";     
//메세지용 
var actionType="";
//To DAY DEFAULT SYSTEM DATE	
var toDay=""; 	
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				//조회(Header)
				case "btn_Retrieve":   
					doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);  
					break;
				//초기화
				case "btn_New":     
					doActionIBSheet(sheetObjects[0],formObject,IBCLEAR,1);
					break;	 	
				//달력팝업
				case "disp_st_dt_cal":	
					var cal=new ComCalendarFromTo();  	       
					cal.select(formObject.disp_st_dt_fm,  formObject.disp_st_dt_to,  'yyyy-MM-dd'); 	
					break; 
				//멀티입력팝업
				case "disp_no_multi":
				    rep_Multiful_inquiry("disp_no");
					break;
				//멀티입력팝업
				case "eq_no_multi": 
					rep_Multiful_inquiry("eq_no");
					break;
				//조회(Detail)
				case "btn_BiddingDetail":
					doActionIBSheet(sheetObjects[1],formObject,IBROWSEARCH);
					setSeletTab();													//탭설정
					getFileAttachment(sheetObjects[1],sheetObjects[1].GetSelectRow());	//파일 리스트 조회
					getBiddingRemarks(sheetObjects[1],sheetObjects[1].GetSelectRow());	//Bidding Remarks 조회
					//버튼 Edit 설정
					var biddingStatus=sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "bidding_status");
					setBtnEdit(biddingStatus);			
					break;
				//Excel
				case "btn_DownExcel": 
					if(sheetObj.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
						}else{
							sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
						}

 					
					break;
				//Submit
				case "btn_Submit": 
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;		 
				//Cancel
				case "btn_Cancel":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
					break; 
				//Print
				case "btn_Print":
					doActionIBSheet(sheetObjects[0],formObject,"PRINT");
					break; 
			} // end switch
		}catch(e) {	
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();   
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        } 
		for(k=0;k < comboObjects.length;k++){ 
            initCombo(comboObjects[k],k + 1);   
        } 
		ComConfigUpload(uploadObjects[0], "/opuscntr/MNR_INTGS.do");
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,0);
    }
	/**  
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){	     
    	comboObjects[comboCnt++]=combo_obj;  
	} 
	/**
     * IBTab Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
    }
    /**
     * IBUpload Object를 uploadObjects 배열에 등록
     * 배열은 소스 상단에 정의
     * @param uploadObj
     * @return
     */
    function setUploadObject(uploadObj){
	   uploadObjects[uploadCnt++]=uploadObj;
	}
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param sheet_obj
	 * @return
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**   
	 * Combo 기본 설정    
	 * @param	{IBMultiCombo}	combo_obj	콤보오브젝트. 
	 * @param	{Number}	comboNo		콤보오브젝트 태그의 아이디에 붙인 일련번호 
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	 */     
	function initCombo (comboObj, comboNo) {   
	    var formObject=document.form
	    switch(comboNo) {      
			   default :    
		           with (comboObj) {  
				       //SetColAlign("left");         
					   //DropHeight = 160;     
			       }   	   
	           break;	 	
	     } 		
	} 
	/**
	 * Tab 기본 설정
	 * 탭의 항목을 설정한다.
	 * @param tabObj
	 * @param tabNo
	 * @return
	 */
	function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
//no support[check again]CLT 					BaseColor="243,242,248";
InsertItem( "Unit Sale" , "");
InsertItem( "Bulk Sale" , "");
                }
                break;
        }
    }
    /**
     * 파일업로드 항목 설정
     * @param uploadObj
     * @param uploadNo
     * @return
     */
    function initUpload(uploadObj, uploadNo) {
		   uploadObj.Files=""; 
	}	
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
			case "sheet1": 
                with (sheetObj) {
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				}	 
            case "sheet2":
                with(sheetObj){
                
              var HeadTitle1="|Seq|Bidding No|Sale\nType|Posting Date|Start Time|Closing Time|Time Left|Pick-Up Period|Bidding\nStatus|Curr|EQ Info|EQ Info|My Offer|My Offer|Counter Offer|"
              var HeadTitle2="|Seq|Bidding No|Sale\nType|Posting Date|Start Time|Closing Time|Time Left|Pick-Up Period|Bidding\nStatus|Curr|QTY|Total  Price|QTY|Total Amount|QTY|";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"disp_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Left",    ColMerge:1,   SaveName:"disp_ut_tp_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"disp_bultn_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"disp_st_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"disp_end_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"left_time",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"disp_pkup_period",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bidding_status",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"part_disp_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:85,   Align:"Right",   ColMerge:0,   SaveName:"part_ut_amt",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Int",       Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"disp_cfm_qty",      KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"mnr_disp_rmk" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"file_seq" },
                     {Type:"Text",      Hidden:1, Width:0,    Align:"Right",   ColMerge:0,   SaveName:"disp_local_dt" } ];
               
              InitColumns(cols);

              SetEditable(1);
                    SetHeaderRowHeight(21);
                    SetSheetHeight(124);
              }

			
                break;  	
			case "sheet3":
			      with(sheetObj){
	            var prefix="";
	        
	         var HeadTitle1="|Seq.|File|Download";
	         var headCount=ComCountHeadTitle(HeadTitle1);

	         SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	         var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	         var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	         InitHeaders(headers, info);

	         var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
	             {Type:"Popup",     Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix+"org_file_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:50 },
	             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_dw",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"file_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"file_dtl_seq", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	          
	         InitColumns(cols);

	         SetEditable(1);
	         SetImageList(0,"/opuscntr/img/ico_attach.gif"));
	                  SetShowButtonImage(1);
	                  SetSheetHeight(70);
	         }


                break;  	
			case "t1_sheet1": 
			    with(sheetObj){
		       
		      var HeadTitle1="|Sel|Seq|EQ No|TP/SZ|Manu|Location|Material|Reefer\nUnit Maker|Reefer\nUnit Model|Result|Ranking|Bids Cnt\nMAX 3|Starting\nPrice|MNR Cost(USD)|My Offer|Release No|Invoice Status|Remark(s)";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"eq_tpsz_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:0,   SaveName:"manu_year",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"disp_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mtrl_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"mkr_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"mdl_nm",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_cfm_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rnk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vndr_bid_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rpr_cost_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"part_ut_amt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"disp_rlse_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inv_sts_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_dtl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		             {Type:"Text",      Hidden:1, Width:130,  Align:"Left",    ColMerge:0,   SaveName:"disp_rsn_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"disp_yd_nm" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"file_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"part_disp_qty" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_dtl_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"tmp_part_ut_amt" } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetEditableColorDiff(1);
		            SetSelectionMode(smSelectionRow);
		            SetSheetHeight(122);
		      }


                break;    
			case "t2_sheet1":  
			    with(sheetObj){
		      var HeadTitle1="|Sel|Seq|TP/SZ|Q'ty|Location|Result|Ranking|Bids Cnt\nMAX 3|Starting\nPirce|My Offer\n(Qty)|Unit Price|EQ No|Release No|Invoice Status|Remark(s)";
		      var headCount=ComCountHeadTitle(HeadTitle1);

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"" },
		             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"eq_tpsz_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"disp_qty",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"disp_yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_cfm_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rnk",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vndr_bid_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"disp_ut_prc",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"part_disp_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
		             {Type:"Int",       Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"part_ut_amt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"eq_no",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"disp_rlse_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"inv_sts_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"mnr_disp_dtl_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"eq_tpsz_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"disp_yd_nm" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"file_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_no" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"disp_dtl_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_cnt_cd" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"mnr_prnr_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"tmp_part_ut_amt" } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetEditableColorDiff(1);
		            SetShowButtonImage(2);
		      SetSelectionMode(smSelectionRow);
		      SetSheetHeight(122);
		      }

		
                break;  
        }
    }
	/**
     * Sheet관련 프로세스 처리
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @param sActionIdx
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	// 초기화 
        	case IBCLEAR:      
				MnrWaitControl(true);
				sheetObj.SetWaitImageVisible(0);
				//전역 변수 초기화 
				uploadFileSeq="";    
				actionType="";
				//해당 아이디에 해당하는 OFC 정보를 가져온다.
				//세션에 안들어옴
				var sppOfcCd=MnrGetSPPPartnerOFC(sheetObjects[0],spPtalId);
				ofcCd=sppOfcCd;  
				//OFC별 로칼 데이트를 가져온다.		
				toDay=MnrGetLocalDate(sheetObjects[0],sppOfcCd);
				//모든 항목 초기화	
				formObj.reset();	
				formObj.ofc_cd.value=sppOfcCd;					
				//헤더 리스트 조회   
				formObj.f_cmd.value=SEARCH03; 
				sParam=FormQueryString(formObj);  
 				var sXml=sheetObj.GetSaveData("EES_MNR_S304GS.do", sParam);
			    sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				//쉬트 초기화		
				for(var i=1; i < sheetObjects.length;i++){ 
					sheetObjects[i].RemoveAll();
				}    	   										
				//탭 설정
				setSeletTab();
				//최초 로딩시에만 콤보조회 설정
				if(sActionIdx==0) {
					//콤보 초기화  
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].SetSelectCode("-1");
						comboObjects[i].RemoveAll();
					}  
					//콤보 조회(Result, Bidding Status)  
					var sCondition=new Array (
						new Array("MnrGenCd","CD00074", "COMMON"),  //result
						new Array("MnrGenCd","CD00075", "COMMON"),  //bidding_status
						new Array("MnrGenCd","CD00038", "COMMON")	//Sale Category
					)	 	  
					var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
					//콤보 설정(Result, Bidding Status, Sale Category) 
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							//쉬트콤보별 초기화
							sheetComboText="";
							sheetComboCode="";
							//Display[CODE_NAME]:result,bidding_status 
							for(var j=0; j < comboList[i].length;j++){ 
								var tempText=comboList[i][j].split("|");
								sheetComboText +=  tempText[1] + "|";
								sheetComboCode +=  tempText[0] + "|";
								//result 
								if(i==0) {
									formObj.result.InsertItem(j, tempText[1] ,tempText[0]);
								//bidding_status
								} else if(i==1){
									formObj.bidding_status.InsertItem(j, tempText[1] ,tempText[0]);
								}
							}
							//bidding_status
							if(i==1) {
								sheetObjects[1].InitDataCombo (0, "bidding_status", sheetComboText, sheetComboCode ,sheetComboCode); 
							//Sale Category
							} else if(i==2){
								sheetObjects[2].InitDataCombo (0, "disp_rsn_cd", sheetComboText, sheetComboCode ,sheetComboCode); 
							}
						}
					}
					formObj.result.InsertItem(0,"ALL","ALL");
					formObj.bidding_status.InsertItem(0,"ALL","ALL");
				}					
				//초기값 설정
				ComSetObjValue(formObj.disp_st_dt_fm,ComGetDateAdd(toDay, "m", -3));	//Starting Date Fm 
				ComSetObjValue(formObj.disp_st_dt_to,toDay); 							//Starting Date To
				ComSetObjValue(formObj.result,"ALL");									//Result
				ComSetObjValue(formObj.bidding_status,"ALL");							//Bidding Status
				sheetObj.SetWaitImageVisible(1);
				MnrWaitControl(false);  
				setBtnEdit('C');
				break;        
			//조회
			case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction)){
					//디테일 쉬트 초기화		
					for(var i=2; i < sheetObjects.length;i++){ 
						sheetObjects[i].RemoveAll();
					}    	   										
					//헤더 리스트 조회   
					formObj.f_cmd.value=SEARCH;    
				    sParam=FormQueryString(formObj);  
 				    var sXml=sheetObj.GetSaveData("EES_MNR_S304GS.do", sParam);
				    sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				}	 	 	
				break;	
			//상세 조회 
			case IBROWSEARCH:          
				if(validateForm(sheetObj,formObj,sAction)){
formObj.selected_disp_no.value=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "disp_no");
					formObj.f_cmd.value=SEARCH01;         
					sParam=FormQueryString(formObj);      
 					var sXml=sheetObj.GetSaveData("EES_MNR_S304GS.do", sParam);
					var arrXml=sXml.split("|$$|");       
					for(var i=0; i < arrXml.length; i++){   
						sheetObjects[i + 2].LoadSearchData(arrXml[i],{Sync:1} );
					}	 
				}        
               break; 		
            //저장
			case IBSAVE:
              if(validateForm(sheetObj,formObj,sAction)){
					//Closing Time 체크
					formObj.f_cmd.value=SEARCH04;
			        var sParam=FormQueryString(formObj);
 					var sXml=sheetObj.GetSearchData("EES_MNR_S304GS.do", sParam);
					var vBiddingStatus=ComGetEtcData(sXml,"biddingStatus");
					if(vBiddingStatus == "O"){
	            	    actionType="IBSAVE";
	            	  	formObj.f_cmd.value=MULTI;
	            	  	var sParam1=sheetObjects[2].GetSaveString(true, true);
						//멘덴토리 체크         
						if(sParam1 == "" && sheetObjects[2].IsDataModified()){
							return; 		
						}   
						sParam1=ComSetPrifix(sParam1,"biddingDtl_"); 
	            	  	var sParam2=sheetObjects[3].GetSaveString(true, true);
						//멘덴토리 체크         
						if(sParam2 == "" && sheetObjects[3].IsDataModified()){
							return; 		
						}   
						sParam2=ComSetPrifix(sParam2,"biddingDtl_"); 
						var sParam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj); 
 	            	  	var sXml=sheetObjects[0].GetSaveData("EES_MNR_S304GS.do", sParam);
 	            	  	sheetObjects[1].LoadSaveData(sXml);
	            	  	if(MnrComGetErrMsg(sXml) == null){
							var dispNo=ComGetEtcData(sXml, "disp_no");				
							var targetRow=0;
							with(sheetObjects[1]){ 
								for(var j=sheetObjects[1].HeaderRows(); j<=sheetObjects[1].LastRow(); j++){
if(GetCellValue(j,"disp_no") == dispNo){
										targetRow=j;    
									}	
								}
							}	
							//마치 선택된것 처럼 	 	
							if(targetRow != 0){  
								sheetObjects[1].SelectCell(targetRow,1);
								sheet2_OnDblClick(sheetObjects[1],targetRow,1);
							} 
						} 
					}else{
						var formObject=document.form;
						ComShowCodeMessage("MNR00364");
						doActionIBSheet(sheetObjects[0],formObject,IBCLEAR,1);
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					}
				} 	
				break; 
			//삭제
			case IBDELETE:
				if(validateForm(sheetObj,formObj,sAction)){
					//상태값 재설정
					for(var i=2; i<=3; i++) {
						for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
var delChk=sheetObjects[i].GetCellValue(j, "del_chk");
							if(delChk==1) {
								sheetObjects[i].SetRowStatus(j,"D");
							} else {
								sheetObjects[i].SetRowStatus(j,"R");
							}
						}
					}
					actionType="IBDELETE"; 
				 	formObj.f_cmd.value=REMOVE01;      	     
				 	var sParam1=sheetObjects[2].GetSaveString(true, true);
				 	sParam1=ComSetPrifix(sParam1,"biddingDtl_");
				 	var sParam2=sheetObjects[3].GetSaveString(true, true);
				 	sParam2=ComSetPrifix(sParam2,"biddingDtl_"); 
				 	var sParam=sParam1 + "&" + sParam2 + "&" + FormQueryString(formObj); 
             	  	var sXml=sheetObjects[0].GetSaveData("EES_MNR_S304GS.do", sParam);
             	  	sheetObjects[1].LoadSaveData(sXml);
            	  	if(MnrComGetErrMsg(sXml) == null){
						var dispNo=ComGetEtcData(sXml, "disp_no");				
						var targetRow=0;
						with(sheetObjects[1]){ 
							for(var j=sheetObjects[1].HeaderRows(); j<=sheetObjects[1].LastRow(); j++){
if(GetCellValue(j,"disp_no") == dispNo){
									targetRow=j;    
								}	
							}
						}	
						//마치 선택된것 처럼 	 	
						if(targetRow != 0){  
							sheetObjects[1].SelectCell(targetRow,1);
							sheet2_OnDblClick(sheetObjects[1],targetRow,1);
						} 
					} 
				 }   
				break;
	        //인쇄
        	case "PRINT":
        		if(validateForm(sheetObj,formObj,sAction)) {
        			var dispNo=formObj.selected_disp_no.value;
        			var mnrPrnrs=getMnrPrnrCntCd();
        			var rdParam='/rv disp_no['+ dispNo +'] user_nm['+ userNm +'] mnr_prnr_cnt_cd['+ mnrPrnrs[0] +'] mnr_prnr_seq['+mnrPrnrs[1]+']';
        			formObj.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0184.mrd';
        			formObj.com_mrdArguments.value=rdParam;
        			ComOpenRDPopup();
        		}
        		break;
        }				
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
		with(formObj){            	        
	    	switch(sAction) {
				//상세조회     
				case IBROWSEARCH:  
					if(sheetObjects[1].RowCount()< 1){
						ComShowCodeMessage("MNR00248","Disposal ");  
						return false;   
					}	
					break;   	
				//저장 
				case IBSAVE: 
					var eqListCnt=parseFloat(sheetObjects[2].RowCount());
					var bulkListCnt=parseFloat(sheetObjects[3].RowCount());
					if(eqListCnt + bulkListCnt < 1) { return false;}
					if (!ComChkValid(formObj)) return false;
					//EQ List 
					if(eqListCnt > 0) {		
						for(var i=sheetObjects[2].HeaderRows(); i<=sheetObjects[2].LastRow(); i++) {
var startPrice=parseFloat(sheetObjects[2].GetCellValue(i, "disp_ut_prc"));
var myOffer=parseFloat(sheetObjects[2].GetCellValue(i, "part_ut_amt"));
var bidsCnt=parseFloat(sheetObjects[2].GetCellValue(i, "vndr_bid_knt"));
var preMyOffer=parseFloat(sheetObjects[2].GetCellValue(i, "tmp_part_ut_amt"));
							if(myOffer != 0 && startPrice > myOffer) {
								//MyOffer 가  StartPrice 보다 커야 합니다.
								ComShowCodeMessage("MNR00173");	  
								sheetObjects[2].SelectCell(i,"part_ut_amt");
								return false;
							}
							if(bidsCnt > 3 && myOffer != preMyOffer) {
								//3회 이상 입찰 불가능 
								ComShowCodeMessage("MNR00350");  
								sheetObjects[2].SelectCell(i,"part_ut_amt");
								return false;
							}
						}
					}
					//Bulk Sale Setting
					if(bulkListCnt > 0) {
						for(var i=sheetObjects[3].HeaderRows(); i<=sheetObjects[3].LastRow(); i++) {
var qty=parseFloat(sheetObjects[3].GetCellValue(i, "disp_qty"));			//Q'ty
var myOfferQty=parseFloat(sheetObjects[3].GetCellValue(i, "part_disp_qty"));	//My Offer(Qty)
var startPrice=parseFloat(sheetObjects[3].GetCellValue(i, "disp_ut_prc"));		//Starting Price
var myOfferAmt=parseFloat(sheetObjects[3].GetCellValue(i, "part_ut_amt"));      //My Offer(Amt)
var bidsCnt=parseFloat(sheetObjects[3].GetCellValue(i, "vndr_bid_knt"));     //입찰 횟수
var preMyOffer=parseFloat(sheetObjects[3].GetCellValue(i, "tmp_part_ut_amt"));
							//Qty
							if(qty < myOfferQty) {
								ComShowCodeMessage("MNR00166");
								sheetObjects[3].SelectCell(i,"part_disp_qty"); //value1 가 value2 보다 작아야 합니다.
								return false;
							}
							if(myOfferQty > 0) {
								//Price
								if(startPrice > myOfferAmt) {
									//value1 가 value2 보다 커야 합니다. 
									ComShowCodeMessage("MNR00173"); 
									sheetObjects[3].SelectCell(i,"part_ut_amt");
									return false;
								}
							} else {
								sheetObjects[3].SetCellValue(i, "part_ut_amt",0);
							}	
							if(bidsCnt > 3 && myOffer != preMyOffer) {	
								//3회 이상 입찰 불가능	
								ComShowCodeMessage("MNR00350");
								sheetObjects[3].SelectCell(i,"part_ut_amt");
								return false;
							}
						}
					}
					break;
				//삭제
				case IBDELETE:
					var eqListCnt=sheetObjects[2].RowCount();
					var bulkListCnt=sheetObjects[3].RowCount();
					if(eqListCnt + bulkListCnt < 1) { return false;}
					var eqListChkCnt=sheetObjects[2].CheckedRows("del_chk");
					var bulkListChkCnt=sheetObjects[3].CheckedRows("del_chk");
					if(eqListChkCnt + bulkListChkCnt < 1) {
						//삭제할 대상을 선택해달라는 메시지 표시
						ComShowCodeMessage("MNR00150"); 
						return false;
					}
					if (!ComShowCodeConfirm("MNR00275","Bidding Detail Offer","Delete")){return false;}  
					break;
			}		 
		}	
        return true; 
    }	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 * @param tabObj
	 * @param nItem
	 * @return
	 */
    function tab1_OnChange(tabObj , nItem){ 
        var objs=document.all.item("tabLayer");
    	objs[nItem].style.display="Inline";
    	objs[beforetab].style.display="none";
    	//--------------- 요기가 중요 --------------------------//
    	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
    	//------------------------------------------------------//
    	beforetab=nItem;
    }
	/**
	 * 헤더 리스트 조회완료시 탭,저장버튼 설정
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		setSeletTab();		//탭설정
		//setBtnEdit('O');	//저장버튼설정
	}
	/**
	 * 헤더 리스트 조회완료시 탭,저장버튼 설정
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		var formObj=document.form;
		//alert(sheetObj.EtcData("disp_local_dt")); 
		formObj.disp_local_dt.value=sheetObj.GetEtcData("disp_local_dt");
	}
	/**
	 * 헤더 리스트 더블클릭시 상세조회 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function sheet2_OnDblClick(sheetObj,Row,Col) {				
		var formObj=document.form; 
		with(sheetObj){ 
			//해당 쉬트 초기화    
			sheetObjects[2].RemoveAll();
			sheetObjects[3].RemoveAll();
			sheetObjects[4].RemoveAll();
			//디테일 조회   	 
			doActionIBSheet(sheetObjects[1],formObj,IBROWSEARCH); 
			//탭선택
			setSeletTab();
			//파일 리스트 조회   
			getFileAttachment(sheetObj,Row);
			//Remark 조회
			getBiddingRemarks(sheetObj,Row);
			//버튼 설정(Submit, Cancel)
var biddingStatus=sheetObj.GetCellValue(Row, "bidding_status");
			setBtnEdit(biddingStatus);
		} 
    } 
	/**
	 * 상세중 EQ List 의 조회완료시 풍선말 설정 
	 *   Release No, EQ No 컬럼의 값 설정
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function t1_sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()<1) {return;}
		setGetToolTipText(sheetObj);
modifyGetCellValue(sheetObj, 1);
	}
    /**
     * 상세중 Bulk List 의 조회완료시 풍선말 설정
     *   Release No, EQ No 컬럼의 값 설정
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
	function t2_sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		if(sheetObj.RowCount()<1) {return;}
		setGetToolTipText(sheetObj);
modifyGetCellValue(sheetObj, 2);
	}
	/**
	 * 상세중 Bulk List 의 MyOffer(Qty) 에 0 을 입력하면 MyOffer(Amt) 에도 0 을 입력한다. 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @param Value
	 * @return
	 */
	function t2_sheet1_OnChange(sheetObj, Row, Col,Value) {
		with(sheetObj) {					
			var colname=ColSaveName(Col);
			if(colname=="part_disp_qty") { //MyOffer(Qty)
				if(Value == 0) {
					sheetObj.SetCellValue(Row, "part_ut_amt",0);//MyOffer(Amt)
				}		
			//1.첫 입찰은 무제한
			//2.두번째 입찰은 + 25 단위로 가능
			//3.입찰은 3번만 가능
			} else if(colname=="part_ut_amt") {
				if(sheetObj.GetCellValue(Row, "vndr_bid_knt") != 0){
				var bidDifAmt=MnrMakeRound(parseFloat(parseFloat(sheetObj.GetCellValue(Row, "part_ut_amt")) - parseFloat(sheetObj.GetCellValue(Row, "tmp_part_ut_amt"))),0);
					if(bidDifAmt != 25){	
						//2.두번째 입찰은 + 25 단위로 가능하도록 하는 기능 삭제처리(2011-03-04 : 정필성차장님 요청
						//ComShowCodeMessage("MNR00349");
						//var fixedAmt = 	parseFloat(sheetObj.CellValue(Row, "tmp_part_ut_amt")) + 25;
						//sheetObj.CellValue2(Row, "part_ut_amt") = fixedAmt;
					}	
				}				
			}
		}
	}	
	function t1_sheet1_OnChange(sheetObj, Row, Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
			//1.첫 입찰은 무제한 
			//2.두번째 입찰은 +25 단위로 가능
			//3.입찰은 3번만 가능
			if(colname=="part_ut_amt") {
				if(sheetObj.GetCellValue(Row, "vndr_bid_knt") != 0){
				var bidDifAmt=MnrMakeRound(parseFloat(parseFloat(sheetObj.GetCellValue(Row, "part_ut_amt")) - parseFloat(sheetObj.GetCellValue(Row, "tmp_part_ut_amt"))),0);
					if(bidDifAmt != 25){
						//2.두번째 입찰은 + 25 단위로 가능하도록 하는 기능 삭제처리(2011-03-04 : 정필성차장님 요청
						//ComShowCodeMessage("MNR00349");								
						//var fixedAmt = 	parseFloat(sheetObj.CellValue(Row, "tmp_part_ut_amt")) + 25;
						//sheetObj.CellValue2(Row, "part_ut_amt") = fixedAmt;	
					}
				}
			}
		}
	}
	/**
     * 파일 다운받기 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	sheetObj의 선택된 Row
     * @param {ibsheet} Col     	sheetObj의 선택된 Col
     * @param {String} 	Value     	파일명
     **/  
	function sheet3_OnClick(sheetObj,Row,Col,Value){
		var prefix="";  
if (sheetObj.ColSaveName(Col)!=prefix+"file_dw" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_path_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_path_nm");
		return;
	}  
	/**
	 * 저장후 메세지 처리
	 * @param sheetObj
	 * @param ErrMsg
	 * @return
	 */
	function sheet2_OnSaveEnd(sheetObj,ErrMsg){  
		if (ErrMsg == "") {      
			if(actionType == "IBSAVE"){ 
				ComShowCodeMessage("MNR00009","Bidding Detail List");
			} else {
				ComShowCodeMessage("MNR00020"); 	
			} 				 				   
		} 	
	}
/* ********* User Functions ************* */
    /**
     * 상세조회시 헤더의 Bidding Remark(s) 를 하단에 보여준다.
     * @param sheetObj
     * @param Row
     * @return
     */
    function getBiddingRemarks(sheetObj, Row) {
var biddingRemarks=sheetObj.GetCellValue(Row, "mnr_disp_rmk");
	    document.form.mnr_disp_rmk.value=biddingRemarks;
	}
	/**
	 * 상세조회시 File Attachment 를 조회하여 보여준다.
	 * @param sheetObj
	 * @param Row
	 * @return
	 */
	function getFileAttachment(sheetObj,Row) { 
var fileSeq=sheetObj.GetCellValue(Row,"file_seq");
		uploadFileSeq=fileSeq;
		if(fileSeq != "" && fileSeq != null){
			var fileXml=SearchFileUpload(sheetObjects[4],fileSeq);
			if(!MnrIsEmptyXml(fileXml)){
				sheetObjects[4].LoadSearchData(fileXml,{Sync:1} );
			}	
		}	      
	}
	/**
	 * 조회후 상세 Location 컬럼에 풍선말 설정
	 * @param sheetObj
	 * @return
	 */
	function setGetToolTipText(sheetObj) {
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
sheetObj.SetToolTipText(i, "disp_yd_cd",sheetObj.GetCellValue(i, "disp_yd_nm"));
		}
	}
    /** 
	 * rep_Multiful_inquiry 의 리턴처리 메서드
	 * @param	{Array}		rowArray	반환되는 Array
	 * @param	{String}	return_val	반환되는 form element명
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form; 
 		var tempText="";      
 		//초기화     
		eval("document.form." + return_val + ".value='';"); 
 		for(var i=0; i<rowArray.length; i++) {     
 			tempText +=  rowArray[i] + ',';      
 		}     
 		//마지막에 ,를 없애기 위함	   	   
 		tempText=MnrDelLastDelim(tempText);	
 		eval("document.form." + return_val + ".value='" + tempText + "';"); 
 	} 
	/**
	 * 저장버튼의 및 수정컬럼 Edit 설정
	 * @param {String} biddingStatus 
	 * @return
	 */
    function setBtnEdit(biddingStatus){
    	if(biddingStatus=='C') {
    		//버튼
    		ComBtnDisable("btn_Submit");
    		ComBtnDisable("btn_Cancel");
    		//컬럼
    		for(i=2; i<=3; i++) {
	    		for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
	    			if(i==3) {
	    				sheetObjects[i].SetCellEditable(j, "part_disp_qty",0);//My Offer(Qty)
	    			}
	    			sheetObjects[i].SetCellEditable(j, "part_ut_amt",0);//My Offer(Amt)
	    			sheetObjects[i].SetCellEditable(j, "mnr_disp_dtl_rmk",0);//Remark(s)
	    		}
    		}
    	} else {
    		//버튼
    		ComBtnEnable("btn_Submit");
    		ComBtnEnable("btn_Cancel");
    		//컬럼
    		for(i=2; i<=3; i++) {
	    		for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
	    			if(i==3) {
	    				sheetObjects[i].SetCellEditable(j, "part_disp_qty",1);//My Offer(Qty)
	    			}
	    			sheetObjects[i].SetCellEditable(j, "part_ut_amt",1);//My Offer(Amt)
	    			sheetObjects[i].SetCellEditable(j, "mnr_disp_dtl_rmk",1);//Remark(s)
var bidsCnt=parseFloat(sheetObjects[i].GetCellValue(j, "vndr_bid_knt"));
					if(bidsCnt >= 3){									
						sheetObjects[i].SetCellEditable(j, "part_ut_amt",0);
					}
	    		}
    		}
    	}
    	//Print 버튼 설정
		for(i=2; i<=3; i++) {
    		for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
var dispRlseNo=sheetObjects[i].GetCellValue(j, "disp_rlse_no");	//Release No
var mnrPrnrSeq=sheetObjects[i].GetCellValue(j, "mnr_prnr_seq");	//mnr_prnr_seq
    			if(dispRlseNo!=null && dispRlseNo!="" && mnrPrnrSeq!=null && mnrPrnrSeq!="") {
    				ComBtnEnable("btn_Print");
    				return;
    			}
    		}
    		ComBtnDisable("btn_Print");
		}
    }
    /**
     * 조회후 탭의 Edit 상태 설정
     */
	function setSeletTab() {
		var eqListCnt=parseFloat(sheetObjects[2].RowCount());
		var bulkListCnt=parseFloat(sheetObjects[3].RowCount());
		if(eqListCnt > 0) {
			tabObjects[0].TabEnable(0)=true;
			tabObjects[0].TabEnable(1)=false;
			tabObjects[0].SetSelectedIndex(0);
		} else if (bulkListCnt > 0) {
			tabObjects[0].TabEnable(0)=false;
			tabObjects[0].TabEnable(1)=true;
			tabObjects[0].SetSelectedIndex(1);
		} else {
			tabObjects[0].TabEnable(0)=true;
			tabObjects[0].TabEnable(1)=true;
			tabObjects[0].SetSelectedIndex(0);
		}
	}
	function getMnrPrnrCntCd() {
		var mnrPrnrs=new Array();
		var mnrPrnrCntCd="";
		var mnrPrnrSeq="";
		for(i=2; i<=3; i++) {
    		for(var j=sheetObjects[i].HeaderRows(); j<=sheetObjects[i].LastRow(); j++) {
mnrPrnrCntCd=sheetObjects[i].GetCellValue(j, "mnr_prnr_cnt_cd");	//mnr_prnr_cnt_cd
mnrPrnrSeq=sheetObjects[i].GetCellValue(j, "mnr_prnr_seq");	//mnr_prnr_seq
    			if(mnrPrnrCntCd!=null && mnrPrnrCntCd!="") {
    				mnrPrnrs[0]=mnrPrnrCntCd;
    				mnrPrnrs[1]=mnrPrnrSeq;
    				return mnrPrnrs;
    			}
    		}
		}
		return mnrPrnrs;
	}
	/**
	 * Release No, EQ No 컬럼의 값을 낙찰 받은 Buyer 일경우만(mnr_prnr_seq 존재) 보여줌.
	 * @param sheetObj
	 * @param sheetIdx
	 * @return
	 */
function modifyGetCellValue(sheetObj, sheetIdx) {
		for(var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
var mnrPrnrSeq=sheetObj.GetCellValue(i, "mnr_prnr_seq");
			if(mnrPrnrSeq=="" || mnrPrnrSeq==null) {
				sheetObj.SetCellValue(i, "disp_rlse_no","");//Release No
				if(sheetIdx==2) {
					sheetObj.SetCellValue(i, "eq_no","");//EQ No
				}
			}
		}
	}
	 /**
     * Axon 이벤트 설정
     * @return
     */
	function initControl() {       
	    //Axon 이벤트 처리1. 이벤트catch  
		var formObject=document.form;       
	    axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
	//    axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 onkeypress이벤트에 코드 처리
	}             
	/**
	 * Axon 이벤트 처리(blur)
	 * @return
	 */
	function obj_deactivate(){      
	    ComChkObjValid(event.srcElement); 
	} 
	/**
	 * Axon 이벤트 처리(focus)
	 * @return
	 */
	function obj_activate(){   
	    ComClearSeparator(event.srcElement);
	}        
	/**
	 * Axon 이벤트 처리(keypress)
	 * @return
	 */
	function obj_keypress(){   
	    obj=event.srcElement;    
	    if(obj.dataformat == null) return; 
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {   
	        case "ymd":   
				ComKeyOnlyNumber(obj); 
	            break;     
	        case "engup":
	        	if(obj.name=="disp_no"){
	        		ComKeyOnlyAlphabet('uppernum','45|44');	//45:'-', 44:','            
	        	} else {
	        		ComKeyOnlyAlphabet('uppernum','44'); 	//44:','            
	        	}
	            break; 
	    }         
	}			
/* 개발자 작업  끝 */
