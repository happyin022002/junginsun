/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName:  : ESM_BKG_0619.js
*@FileTitle  : Outbound Container Movement Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author CLT
     */
    /**
	 * @extends
	 * @class esm_bkg_0619 : esm_bkg_0619 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
	 */
    
   	/* 개발자 작업 */
 // 공통전역변수
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var combo1=null;
    var comboCnt=0;
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
        function processButtonClick(){
             /** *** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 **** */
             var sheetObject=sheetObjects[0];
             var sheetObject1=sheetObjects[1];
             /** **************************************************** */
             var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
                switch(srcName) {
    					case "btn_EQHistory":
    						if (!$('#btn_EQHistory').prop("disabled")) {
    						var srow=sheetObject.GetSelectRow();
    						var tmp=sheetObject.GetCellValue(srow, "cntr_no");
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG04025');
    							return;
    						}
    						var cntrNo=(tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
    	                    var checkDigit=(tmp != null && tmp.length>10) ? tmp.substring(10) : '';
    	                    var typeSize=sheetObject.GetCellValue(srow, "cntr_tpsz_cd_mv");
    	                    //20150603.MOD
    						var url="EES_CTM_0411_POP.do?func=&cntrNo="+cntrNo+"&checkDigit="+checkDigit+"&typeSize="+typeSize+"&mainPage=false";
							ComOpenWindowCenter(url, "EES_CTM_0411", 1010, 650, false);	
    						}   
    						break;
    					case "btn_COP" :
    						if (!$('#btn_COP').prop("disabled")) {
							var srow=sheetObject.GetSelectRow();
							var tmp=sheetObject.GetCellValue(srow, "cntr_no");
							if (tmp == "" || tmp.length != 11 ){
								ComShowCodeMessage('BKG04025');
								return;
							}
							var cntr_no=sheetObject.GetCellValue(srow, "cntr_no");
							var cbkg_no=sheetObject.GetCellValue(srow,"cbkg_no");
							var cop_no=sheetObject.GetCellValue(srow,"cop_no");
							var tmp=sheetObject.GetCellValue(srow, "cntr_no");
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
    						var cntrNo=(tmp != null && tmp.length>10) ? tmp.substring(0,10) : tmp;;
							var url="ESD_SCE_0006_POP.do?f_cmd=" +
									  "&cop_no=" + cop_no + 
									  "&bkg_no=" + cbkg_no + 
									  "&cntr_no=" + cntr_no + 
									  "&pgmNo=ESD_SCE_0006" + 
									  "&dist1=" + "COP_VALUE" + 
									  "&dist2=" + "COP_VALUE" +
									  "&mainPage=false";
							ComOpenWindowCenter(url, "ESD_SCE_0006", 1010, 650, false);	
    						}
    						break;
    					case "btn_CLM" :
    						if (!$('#btn_CLM').prop("disabled")) {
    						var srow=sheetObject.GetSelectRow();
    						var tmp=sheetObject.GetCellValue(srow, "cntr_no");
    						if (tmp == "" || tmp.length != 11 ){
    							ComShowCodeMessage('BKG40055');
    							return;
    						}
							var cntrNo=sheetObject.GetCellValue(srow, "cntr_no");
							var typeSize=sheetObject.GetCellValue(srow, "cntr_tpsz_cd_mv");
							var clmTo=sheetObject.GetCellValue(srow,"clm_dt").substring(0,10);
    						var clmFm=ComGetDateAdd(clmTo.toString(),"D",-180, "-");
    						var param="pgmNo=ESD_SCE_0043&f_cmd=0&row_size=50&"+
    									"cntr_no=" + cntrNo +
    									"&tpsz_cd=" + typeSize +
    									"&arr_dt1=" + clmFm +
    									"&arr_dt2=" + clmTo ;
    						var url="ESD_SCE_0044.do?" + param;
//    						var url="ESD_SCE_0043.do?" + param;
//    						ComOpenPopup(url, 1010, 530, 'ESD_SCE_0043', '0,0', true, true, 0, "", 1);
    						ComOpenPopup(url, 1010, 530, 'ESD_SCE_0044', '0,0', true, true, 0, "", 1);
    						}
    						break;    						
    					case "btn_Retrieve":
    						doActionIBSheet(sheetObjects[tabObjects[0].GetSelectedIndex()],formObject,IBSEARCH);
    						break;
    					case "btn_New":
    						sheetObjects[0].RemoveAll();
    						sheetObjects[1].RemoveAll();
    						sheetObjects[2].RemoveAll();
    	 					ComResetAll();
    	 					ComBtnDisable("btn_EQHistory");
    	 					ComBtnDisable("btn_COP");
    	 					ComBtnDisable("btn_CLM");
    						break;
    					case "btn_DownExcel":
    						var downSheet = sheetObjects[tabObjects[0].GetSelectedIndex()];
    						if(downSheet.RowCount() < 1){//no data
    							ComShowCodeMessage("COM132501");
    						}
    						else{
    							downSheet.Down2Excel({DownCols: makeHiddenSkipCol(downSheet), SheetDesign:1,Merge:1});
							}
    	 					
    	 					break;	
    					case "btn_Preview":
    						doActionIBSheet(sheetObjects[tabObjects[0].GetSelectedIndex()],formObject,RDPRINT);
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
		 * IBSheet Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수
		 * 있다 배열은 소스 상단에 정의
		 */
        function setSheetObject(sheet_obj){
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        function setComboObject(combo_obj){
          	comboObjects[comboCnt++]=combo_obj;
         }
        /**
		 * Sheet 기본 설정 및 초기화 body 태그의 onLoad 이벤트핸들러 구현 화면을 브라우저에서 로딩한 후에 선처리해야
		 * 하는 기능을 추가한다
		 */
        function loadPage() {
        	//alert("loadPage");
        	
    		for(i=0;i<sheetObjects.length;i++){
    			ComConfigSheet (sheetObjects[i] );
    			initSheet(sheetObjects[i],i+1);
    			ComEndConfigSheet(sheetObjects[i]);
    		}
    		for(k=0;k<tabObjects.length;k++){
    			initTab(tabObjects[k],k+1);
    			tabObjects[k].SetSelectedIndex(0);
    		}
    		// Outbound Container Movement Status Table Visible 처리
    		setSheetVisble(0);
    		// Axon Event Initialize
            initControl();
    		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    		// IBMultiCombo초기화
    		for(var j=0; j<comboObjects.length; j++){
    		    initCombo(comboObjects[j]);
    		}
    		// setting ui control
    		ComSetUIItem(sheetObjects[0],document.form,"BKG","ESM_BKG_0619");    
    		
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
        	// ** Date 구분자 **/
        	DATE_SEPARATOR="-";
        	
        	var formObject=document.form;
        	
        	axon_event.addListener('keydown', 'ComKeyEnter', 'form'	);
        	
        	ComBtnDisable("btn_EQHistory");
        	ComBtnDisable("btn_COP");
        	ComBtnDisable("btn_CLM");
        	/*
			 * ComBtnDisable("btn_SumbyYard"); ComBtnDisable("btn_SumbyTPSZ");
			 */
        }
       /** ********************* KEY EVENT START ******************* */ 	 
        /**
		 * Form Element의 OnBeforeDeactivate 이벤트 - form 전체 컨트롤 중 dataformat 속성이
		 * 있는 모든 컨트롤의 OnBeforeDeactivate 이벤트에 코드 처리
		 */
        function obj_deactivate() {
            ComChkObjValid(ComGetEvent());
        }
        /**
		 * Form Element의 OnBeforeActivate 이벤트 - form 전체 컨트롤 중 dataformat 속성이 있는
		 * 모든 컨트롤의 OnBeforeActivate 이벤트에 코드 처리
		 */
        function obj_activate() {
            ComClearSeparator(ComGetEvent());
        }
//     function bkg_keypress(){
//	    switch(event.srcElement.dataformat){
//	    	case "ymd":
//	        // number
//	        ComKeyOnlyNumber(event.srcElement, "-");
//	        break;
//	    	case "engup":
//	        // 영문대문자
//    			ComKeyOnlyAlphabet('upper');
//	        break;
//	      case "engupnum":
//	        // 숫자+"영문대문자"입력하기
//	      	ComKeyOnlyAlphabet('uppernum');
//	        break;
//	      case "num":
//	        // 숫자 입력하기
//	        ComKeyOnlyNumber(event.srcElement);
//	        break;
//	      case "custname":
//	        // 영문,숫자,공백,기타문자(.,등)
//	        ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
//	      break;	            
//	      default:
//	      break;
//	    }
//	}  
      /**
		 * 시트 초기설정값, 헤더 정의 param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의
		 * 아이디에 붙인 일련번호 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
		 */
        function initSheet(sheetObj,sheetNo) {
            var cnt=0;
            var sheetID=sheetObj.id;
            switch(sheetID) {
                case "t1sheet1":      // sheet1 init
                    with(sheetObj){
                    
                  var HeadTitle1="|Sel.|Seq.|Trade|Sub\nTrade|Lane|Booking No.|Booking No.|POR|POD|DEL|R/D|R/D|BKG Q'ty|BKG Q'ty|Container No.|Container No.|I|CNTR R/D|CNTR R/D|ST|Yard|Current Event Time|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|CLM(US Rail)|Shipper|D/G|D/G|R/F|R/F|AK\n(F/R/H/L/R)|AK\n(F/R/H/L/R)|VVD Type|Partial|subgroup_title|";
                  var headCount=ComCountHeadTitle(HeadTitle1);
//                  (42, 0, 0, true);
                  //SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:1, Page:20, DataRowMerge:0 } );
                  SetConfig( { SearchMode:2, FrozenCol:0, MergeSheet:1, Page:20, DataRowMerge:0 } );
                  var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle1, Align:"Center"}];
                  InitHeaders(headers, info);
                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Check",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
                         {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"bkg_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"bkg_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"op_cntr_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"cntr_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_mv",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_check",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd_mv",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"de_term_cd_mv",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"clm_sght_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"arr_loc_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"arr_ste_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"arr_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:105,  Align:"Center",  ColMerge:0,   SaveName:"dep_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"cust_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dg_sts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rf_sts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rf",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ak_sts",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ak",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_pre_pst_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_prt_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cop_no" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cbkg_no" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"clm_dt" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"subgroup_title" },
                         {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"MDST" } ];
                   
                  InitColumns(cols);
                  SetEditable(0);
                  SetSheetHeight(370);
                  SetEditableColorDiff(1);
                  SetCountPosition(0); 
                 
                 }
                    break;
                case "t1sheet2":      // sheet2 init
                    with(sheetObj){
                    
//                  (26, 0, 0, true);
                  var HeadTitle1="|sub_str||Sub\nTrade|Lane|Origin Yard|OP|OP|OP|OP|OC|OC|OC|OC|EN+TN|EN+TN|EN+TN|EN+TN|MT|MT|MT|MT|Others|Others|Others|Others";
                  var HeadTitle2="|sub_str||Sub\nTrade|Lane|Origin Yard|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4|DR2|DR4|RF2|RF4";

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sub_str",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_dr2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_dr4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_rf2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"op_rf4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"oc_dr2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"oc_dr4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"oc_rf2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"oc_rf4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"etn_dr2",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"etn_dr4",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"etn_rf2",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"etn_rf4",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"mt_dr2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"mt_dr4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"mt_rf2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"mt_rf4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"ot_dr2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"ot_dr4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"ot_rf2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:"ot_rf4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                   
                  	InitColumns(cols);
                  	SetEditable(0);
                  	SetSheetHeight(370);
                  	ShowSubSum([{StdCol:"sub_str", SumCols:"op_dr2|op_dr4|op_rf2|op_rf4|oc_dr2|oc_dr4|oc_rf2|oc_rf4|etn_dr2|etn_dr4|etn_rf2|etn_rf4|mt_dr2|mt_dr4|mt_rf2|mt_rf4|ot_dr2|ot_dr4|ot_rf2|ot_rf4", Sort:false, ShowCumulate:false, CaptionCol:0}]);
                  	 SetRangeBackColor(1,4,1,25,"#555555");
                  	SetCountPosition(0); 
                        }
                    break;   
                case "t1sheet3":      // sheet1 init
                    with(sheetObj){
                   
                  (16, 0, 0, true);
                  var HeadTitle1="|sub_str||Sub\nTrade|Lane|Type/Size|BKG Qty|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Container Movement Status|Difference\n(BKG-CNTR) ";
                  var HeadTitle2="|sub_str||Sub\nTrade|Lane|Type/Size|BKG Qty|OP|OC|EN+TN|Port CY|VL|MT|Others|TTL|Difference\n(BKG-CNTR) ";

                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                  var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
                  InitHeaders(headers, info);

                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Status" },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sub_str",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd_mv",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bkg_qty",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"op",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"oc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"etn",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"cy",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vl",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"mt",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ot",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ttl",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                         {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"diff_qty",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                   
                  InitColumns(cols);
                  SetEditable(0);
                  SetSheetHeight(370);
                  ShowSubSum([{StdCol:"sub_str", SumCols:"bkg_qty|op|oc|etn|cy|vl|mt|ot|ttl|diff_qty", Sort:false, ShowCumulate:false, CaptionCol:0}]);         		
                  SetRangeBackColor(1,6,1,15,"#555555");
                  SetCountPosition(0); 
                }
                    break;    
            }
        }
		/**
		 * 콤보 초기설정값
		 * 
		 * @param {IBMultiCombo}
		 *            comboObj comboObj
		 */
		 function initCombo(comboObj) {
		  	 var formObj=document.form;
		  	var strId=comboObj.options.id;
		  	 with(comboObj) {
		  		 switch(strId) {
		  		 	case "trd_cd":
			        	SetDropHeight(260);
		            	SetTitle("Trade|Description");
		            	SetColWidth(0, "50");
		            	SetColWidth(1, "200");
		            	InsertItem(0,"|All","");
		            	SetMaxLength(3);
			            Index2=0;
			            break;
			        case "sub_trd_cd":
	            		SetDropHeight(260);
		            	SetTitle("Trade|SubTrade|Description");
						SetColWidth(0, "50");
						SetColWidth(1, "70");
						SetColWidth(2, "150");
		            	InsertItem(0,"||All","");
		            	SetMaxLength(2);
			            Index2=0;
			            break;
			        case "rlane_cd":
	            		SetDropHeight(260);
		            	SetTitle("Trade|SubTrade|Rev.Lane|Description");
						SetColWidth(0, "50");
						SetColWidth(1, "70");
						SetColWidth(2, "70");
						SetColWidth(3, "250");
		            	SetMaxLength(5);
		            	InsertItem(0,"|||ALL",'');
		            	Index2=0;
			            break;
			        default:
			        	comboObj.SetDropHeight(250);
					 	comboObj.SetUseAutoComplete(1);
					 	comboObj.index=0;
			     }
		  	 }
		 }
      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg(false);
            switch(sAction) {
	            case IBCLEAR: // 화면 로딩시 코드 조회
					formObj.f_cmd.value=COMMAND01;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0619GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 8) 
						ComXml2ComboItem(arrXml[8], rlane_cd, "code", "name");
					if (arrXml.length > 7) 
						ComXml2ComboItem(arrXml[7], sub_trd_cd, "code", "name");
					if (arrXml.length > 6) 
						ComXml2ComboItem(arrXml[6], trd_cd, "code", "name");
					if (arrXml.length > 5) 
						{
							ComXml2ComboItem(arrXml[5], cust_tp_cd, "val", "name");
							cust_tp_cd.SetSelectIndex(0);
						}
					if (arrXml.length > 4) 
						{
						ComXml2ComboItem(arrXml[4], bkg_cgo_tp_cd, "val", "desc");
						bkg_cgo_tp_cd.SetSelectIndex(0);
						}
					if (arrXml.length > 3) 
						{
						ComXml2ComboItem(arrXml[3], xter_bkg_rqst_cd, "val", "name");
						xter_bkg_rqst_cd.SetSelectIndex(0);
						}
					if (arrXml.length > 2) 
						{
						ComXml2ComboItem(arrXml[2], bkg_sts_cd, "val", "name");
						bkg_sts_cd.SetSelectIndex(0);
						}
					if (arrXml.length > 1) 
						{
						ComXml2ComboItem(arrXml[1], de_term_cd, "val", "name");
						de_term_cd.SetSelectIndex(0);
						}
					if (arrXml.length > 0) 
						{
						ComXml2ComboItem(arrXml[0], rcv_term_cd, "val", "name");
						rcv_term_cd.SetSelectIndex(0);
						}
					
					break;
	           case IBSEARCH:      // 조회
	 	          if(validateForm(sheetObj,formObj,sAction)){
	 	        	 formObj.f_cmd.value=SEARCH;
	 	        	sheetObj.SetWaitImageVisible(0);
	 	        	ComOpenWait(true);
	 	        	var sXml=sheetObj.GetSearchData("ESM_BKG_0619_1GS.do", FormQueryString(formObj));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 2) 
						sheetObjects[2].LoadSearchData(arrXml[2],{Sync:1} );
					if (arrXml.length > 1) 
						sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
					if (arrXml.length > 0) 
						sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					ComBtnEnable("btn_EQHistory");
					ComBtnEnable("btn_COP");
					ComBtnEnable("btn_CLM");
	 	          }	  
	              break;
	           case IBDOWNEXCEL:   
	        	   sheetObj.Down2Excel({ HiddenColumn:-1});
	   				break;	    
	           case RDPRINT:   		
					if (sheetObj.RowCount()> 0) {
						/*
						 * formObj.com_mrdPath.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0814.mrd";
						 * formObj.com_mrdArguments.value="/rfn ["+RDServerIP +
						 * "/ESM_BKG_0814_1.do?"+FormQueryString(formObj)+"]";
						 * ComOpenRDPopup();
						 */
				 		sheetObj.SetWaitImageVisible(0);
				 		ComOpenWait(true);
						var url="ESM_BKG_0814.do?"+FormQueryString(formObj);	    	
						var winName="ESM_BKG_0814";
						repWin=openWinCenter("about:blank",winName,1010,700);
						var frm2=document.form2;
						if (tabObjects[0].GetSelectedIndex()== 1){
							formObj.f_cmd.value=SEARCH02;
							frm2.rfn.value="/ESM_BKG_0814_1.do?"+FormQueryString(formObj);
							frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0814.mrd";
							frm2.rv.value="title[Outbound Container Movement Status by Yard] NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
							frm2.title.value="Outbound Container Movement Status by Yard";
						}else if (tabObjects[0].GetSelectedIndex()== 2){
							formObj.f_cmd.value=SEARCH03;
							frm2.rfn.value="/ESM_BKG_0814_1.do?"+FormQueryString(formObj);	    
							frm2.mrd.value="apps/opus/esm/bkg/bookingreport/statusreport/report/ESM_BKG_0815.mrd";
							frm2.rv.value="title[Outbound Container Movement Status by Type/Size] NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]";
							frm2.title.value="Outbound Container Movement Status by Type/Size";
						}
						frm2.action=url;
						frm2.target=winName;
						frm2.submit();
						frm2.target="";
					    repWin.focus();
					} else {
						ComShowCodeMessage("BKG00495");
					}
					break;
			// case SEARCH04:
			// formObj.f_cmd.value = SEARCH04;
			// var sXml = sheetObj.GetSearchXml("ESM_BKG_0619GS.do",
			// FormQueryString(formObj));
			// var arrXml = sXml.split("|$$|");
			//
			// if (arrXml.length > 1)
			// ComXml2ComboItem(arrXml[1], formObj.sub_trd_cd, "trd_cd|code", "name");
			// if (arrXml.length > 0)
			// ComXml2ComboItem(arrXml[0], formObj.rlane_cd, "trd_cd|sub_trd_cd|code",
			// "name");
			// if (arrXml.length > 8)
			// ComXml2ComboItem(arrXml[8], formObj.rlane_cd, "code", "name");
			// break;
            }
            ComOpenWait(false);
        }
        function openWinCenter(url,winName,width,height , scrollYn) {
     	   var left=(screen.width - width)/2;    
     	   if(left < 0) {
     		   left=0;
     	   }
            var top=(screen.height- width)/2;   
            if( top < 0 ) {
         	   top=0;
            }
            if (ComIsNull(scrollYn)) {
         	   scrollYn="no";
            } else {
         	   if (scrollYn == "Y") {
         		   scrollYn="yes";
         	   } else {
         		   scrollYn="no";
         	   }
            }
            var feature=
         	   "status=no, resizable=yes, scrollbars="+scrollYn+", width="+width+", height="+height+", left="+left+", top="+top;
            return window.open(url,winName,feature);
     }
        /**
		 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
		 */
        function validateForm(sheetObj,formObj,sAction){
        	with(formObj){
             	switch(sAction) {
    					case IBSEARCH: // 조회시 확인
    		         		if (!ComChkValid(formObj)) return false;
    		         		if ((!ComIsNull(formObj.bkg_dt_fr) && ComIsNull(formObj.bkg_dt_to)) || (ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to))){
    		         			ComShowMessage("Please input period of BKG Date.");
    		         			return false;
    		         		} 
	    					if (!ComIsNull(formObj.bkg_dt_fr) && !ComIsNull(formObj.bkg_dt_to) && ComGetDaysBetween(formObj.bkg_dt_fr.value, formObj.bkg_dt_to.value) > 31){
			         			ComShowCodeMessage("BKG50469");// Can't Input
																// Date Over 31
																// days!
			         			formObj.bkg_dt_fr.focus();
			         			return false;
			         		}
	    					if (ComIsNull(formObj.pol_cd)){
	    						ComShowCodeMessage("BKG00209"); // Please Input
																// POL.
	    						formObj.pol_cd.focus();
	    						return false
	    					}
    		         		break;
             	}	
             }
             return true;
        }
        // 조회 함수를 이용하여 조회가 완료되고 발생하는 Event
        function t1sheet1_OnSearchEnd(sheetObj, ErrMsg)
        {
        	/* Including CLM Information */
        	chkIncClm();
        	sheetObj.SelectCell(2,1);
        	ComBtnEnable("btn_EQHistory");
        	ComBtnEnable("btn_COP");
        	ComBtnEnable("btn_CLM");
        	// 2011.11.22 변종건[CHM-201113464-01] 동일 CNTR가 다른 VVD로 Double
			// Booking시-IRR조기 감지 Report시스템 구축
			for(var idx=0; idx<= sheetObjects[0].LastRow(); idx++){
			if(sheetObjects[0].GetCellValue(idx, "cntr_check") == "D"){
			if(sheetObjects[0].GetCellValue(idx, "cntr_no")!= ""){
			sheetObjects[0].SetCellFont("FontBold", idx, "cntr_no", idx, "cntr_no",1);
			sheetObjects[0].SetCellFontColor(idx,"cntr_no","#FF0000");
					}
				}
			}
			// 2012.06.11 오요한[CHM-201218315-01] O/B Container Movement Status
			// Report 로직 보완요청 : 컨테이너 타입이 달라도 조회가능 -> 라인은 빨간색으로 표시
			// BKG Q'ty의 타입값 저장
			var temBkgTp='';
			// 헤더와 마지막의 써머리2줄은 제외한다.
			for(var idx=1; idx<= sheetObjects[0].LastRow()-2; idx++){
				// BKG Q'ty의 타입값이 ""인 경우에는 이전값(temBkgTp)을 세팅한다.
				var bkgTp=sheetObjects[0].GetCellValue(idx, "cntr_tpsz_cd")==""?temBkgTp:sheetObjects[0].GetCellValue(idx, "cntr_tpsz_cd");
				temBkgTp=bkgTp;
				var cntrTp=sheetObjects[0].GetCellValue(idx, "cntr_tpsz_cd_mv");
				// 두 타입이 같지 않다면 해당 로우의 텍스트는 빨간색
				if (cntrTp != '' && (bkgTp != cntrTp)) {
					sheetObjects[0].SetRowFontColor(idx,"#FF0000");
				}
			}
        }
        function t1sheet1_OnClick(sheetObj, Row, Col, Value) {
    		var formObj=document.form;
    		// var sheetObject = sheetObjects[1];
    		var colName=sheetObj.ColSaveName(Col);
    		if (colName == "Check"){
	    		for (i=1; i<= sheetObj.LastRow(); i++) {  // sheetObj.LastRow()
	    			if (sheetObj.GetCellValue(i, Col) == true){
	    				sheetObj.SetCellValue(i, Col,0,0);
	    			}
	    		}
        	}
    	}
        /**
		 * sheet2 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
		 */ 
        function t1sheet2_OnSearchEnd(sheetObj, ErrMsg) {
    		var sumRow = sheetObj.FindSumRow();
    		sheetObj.SetCellValue(sumRow,"trd_cd","Total",0);
    		
    		sheetObj.ShowSubSum([{StdCol:"sub_str", SumCols:"op_dr2|op_dr4|op_rf2|op_rf4|oc_dr2|oc_dr4|oc_rf2|oc_rf4|etn_dr2|etn_dr4|etn_rf2|etn_rf4|mt_dr2|mt_dr4|mt_rf2|mt_rf4|ot_dr2|ot_dr4|ot_rf2|ot_rf4", Sort:false, ShowCumulate:false, CaptionCol:0}]);
    		var sRow=sheetObj.FindSubSumRow();
    		
    		var arrRow=sRow.split("|");
    		for (idx=0; idx < arrRow.length; idx++){
    			sheetObj.SetCellValue(arrRow[idx],"trd_cd","Sub Total",0);
    			sheetObj.SetMergeCell(arrRow[idx], 2, 0, 4);
    		}
        }
        /**
		 * sheet3 데이터 조회후 발생하는 OnSearchEnd 이벤트핸들러 <br>
		 */ 
         function t1sheet3_OnSearchEnd(sheetObj, ErrMsg) {
     		var sumRow = sheetObj.FindSumRow();
     		sheetObj.SetCellValue(sumRow,"trd_cd","Total",0);
    		
     		var sRow=sheetObj.FindSubSumRow();         		
     		var arrRow=sRow.split("|");
     		for (idx=0; idx < arrRow.length; idx++){
     			sheetObj.SetCellValue(arrRow[idx],"trd_cd","Sub Total",0);
     			sheetObj.SetMergeCell(arrRow[idx], 2, 0, 4);
     		}
         }
        /**
		 * Check된 Sheet의 Row 값 리턴
		 */
        function getCheckRowSheet(sheetObj){
    		for (i=1; i<= sheetObj.LastRow(); i++) {
    			if (sheetObj.GetCellValue(i, "Check") == true){
    				return i;
    			}
    		}
    		return 0;
    	}
        /**
		 * Including CLM Information 체크여부에 따른 sheet 타이틀 조정.
		 */
        function chkIncClm(){
        	var formObject=document.form;
        	if (ComGetObjValue(formObject.chk_inc_clm) == "Y"){
        		sheetObjects[0].SetColHidden("clm_sght_cd",0);
        		sheetObjects[0].SetColHidden("arr_loc_nm",0);
        		sheetObjects[0].SetColHidden("arr_ste_cd",0);
        		sheetObjects[0].SetColHidden("arr_dt",0);
        		sheetObjects[0].SetColHidden("dep_dt",0);
        	}else{
        		sheetObjects[0].SetColHidden("clm_sght_cd",1);
        		sheetObjects[0].SetColHidden("arr_loc_nm",1);
        		sheetObjects[0].SetColHidden("arr_ste_cd",1);
        		sheetObjects[0].SetColHidden("arr_dt",1);
        		sheetObjects[0].SetColHidden("dep_dt",1);
        	}
        }
        /**
		 * ETD,ETB 기간 선택 달력 띄우기
		 */
      	function callDatePop(val){
      		var cal=new ComCalendarFromTo();
      		if (val == 'BKG_DATE'){
      			cal.select(form.bkg_dt_fr,  form.bkg_dt_to,  'yyyy-MM-dd');
      		}
      	}
        function setSheetVisble(inx){
        	var mainTable = document.all.item('mainTable');
        	var sButtonTable = document.all.item('sButtonTable');
    		for(var k=0; k < mainTable.length; k++){
    		    mainTable[k].style.display="none";
    		}
    		mainTable[inx].style.display="";
    		if (inx == 0){
    			sButtonTable[0].style.display="";
    			sButtonTable[1].style.display="none";
    		}else{
    			sButtonTable[0].style.display="none";
    			sButtonTable[1].style.display="";
    		}
        }
        /**
		 * IBTab Object를 배열로 등록 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
		 * 배열은 소스 상단에 정의
		 */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++]=tab_obj;
        }
        /**
		 * Tab 기본 설정 탭의 항목을 설정한다.
		 */
        function initTab(tabObj , tabNo) {
             switch(tabNo) {
                 case 1:
                    with (tabObj) {
                        var cnt=0 ;
						InsertItem( "Result" , "");
						InsertItem( "Summary by Yard" , "");
						InsertItem( "Summary by Type/Size" , "");
                    }
                 break;
             }
        }
        function tab1_OnClick(tabObj, nItem){
	      	setSheetVisble(nItem);
        }
         /**
			 * 풍선도움말 만들기
			 */
         function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y) {
        	  var msgStr="Note : D - Duplicate  VVD\n         A - Advanced Ship\n         S - Short Ship";
        	  if (sheetObj.MouseCol()==sheetObj.SaveNameCol("cntr_check")){
        		  sheetObj.SetMousePointer("Hand");
        	  }else{
        		  sheetObj.SetMousePointer("Default");
        	  }
          }
         /**
			 * Trade Combo Change Event
			 */
//     	 function trd_cd_OnChange(comboObj,value,text){
         function trd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        	var value = newCode;
			if (value != null && value != "") {  			
				comboObjects[7].SetSelectCode("",false);
				comboObjects[8].SetSelectCode("",false);
			}
			SpcSearchOptionSubTrade("sub_trd_cd",true,false,"","",value);
			SpcSearchOptionLane("rlane_cd",true,true,'',value,'',true);
     	 }
     	 /**
			 * Sub Trade Combo Change Event
			 */
//     	 function sub_trd_cd_OnChange(comboObj,value,text){
         function sub_trd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
        	 var value = newCode;
 			SpcSearchOptionLane("rlane_cd",true,true,'',trd_cd.GetSelectCode(),value,true);	// 0207
																											// SHKIM
 			if(value == "") return;
 	    	var arrTrade=newText.split("|");
 	    	if(arrTrade.length > 1) {
 	    		comboObjects[6].SetSelectCode(arrTrade[0],false);
 	    		comboObjects[8].SetSelectCode('',false);
 	    	} else {
 	    		comboObjects[6].SetSelectCode(comboObj.GetText(value,0),false);
 	    		comboObjects[8].SetSelectCode('',false);
 	    	}
     	 }
     	 /**
			 * Lane Combo Change Event
			 */
//      	 function rlane_cd_OnChange(comboObj,value,text){
	     function rlane_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	    	var value = newCode;
	        var arrLane=newText.split("|");
	    	if(arrLane.length > 1) {
	    		comboObjects[6].SetSelectCode(arrLane[0],false);
	    		comboObjects[7].SetSelectCode(arrLane[1],false);
	    	} else {
	    		comboObjects[6].SetSelectCode(comboObj.GetText(value,0),false);
	    		comboObjects[7].SetSelectCode(comboObj.GetText(value,1),false);
	    	}	
	  	 }
      	/**
		 * 조회 조건의 Sub Trade 설정. trdCd를 추가.
		 * 
		 * @param{elemName} str 필수, Object Name
		 * @param{isAll} Boolean 선택, 모든 Sub Trade 조건 추가 여부, default = true.
		 * @param{isRepTrade} Boolean 선택, Rep Trade 조건 추가 여부, default = false.
		 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
		 */  
      	function SpcSearchOptionSubTrade(elemName, isAll, isRepTrade, del, ipc ,trdCd) {
      		if(isAll == undefined || isAll == null){
      			isAll=true;
      		}
      		if(isRepTrade == undefined || isRepTrade == null){
      			isRepTrade=false;
      		}
      		if(del == undefined || del == null){
      			del='';
      		}
//      		var obj=document.getElementById(elemName);
      		var obj=window[elemName];
      		if(trdCd == null || trdCd == ""){
      			var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc);
      		}else{
      			var rtn=getCodeXmlList("SubTradeCombo", "isRepTrade=" + isRepTrade + "&del=" + del + "&isAll=" + isAll+ "&ipc=" + ipc+ "&trdCd=" + trdCd);
      		}
      		obj.SetTitleVisible(true);
//      		obj.SetTitle("Trade|SubTrade|Description");
      		obj.SetColWidth(0, "50");
      		obj.SetColWidth(1, "60");
      		obj.SetColWidth(2, "200");
      		obj.SetDropHeight(190);
      		ComXml2ComboItem(rtn, obj, "sub_trd_cd", "trd_cd|sub_trd_cd|sub_trd_nm");
      		if(isAll)
      			obj.InsertItem(0, "||ALL");
      	}    
      	/**
		 * 조회 조건의 Lane 설정. locTrdCd,locSubTrdCd,reCdValue 추가.
		 * 
		 * @param{elemName} str 필수, Object Name
		 * @param{isAll} Boolean 선택, Option 에 ALL 입력 여부, Default = true
		 * @param{ipc} Boolean 선택, Rep Trade 조건 추가 여부, true 시 ipc 구간이므로 Rep
		 *             Trade 조건 제외. Default = false.
		 * @param{del} str 선택, 삭제 플레그 조건 추가 여부
		 */  
      	function SpcSearchOptionLane(elemName, isAll, ipc, del,locTrdCd,locSubTrdCd,reCdValue) {
      		 if(isAll == undefined || isAll == null){
      			isAll=true;
      		}
      		if(ipc == undefined || ipc == null){
      			ipc=false;
      		}
      		if(del == undefined || del == null){
      			del='';
      		}
//      		var obj=document.getElementById(elemName);
      		var obj=eval(elemName);
      		if(reCdValue == null || reCdValue == ''){
      			var rtn=getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc);
      		}else{
      			var rtn=getCodeXmlList("RLaneCombo", "del=" + del + "&ipc=" + ipc+ "&locTrdCd=" + locTrdCd+ "&locSubTrdCd=" + locSubTrdCd+ "&reCdValue="+reCdValue);
      		}
      		obj.SetTitleVisible(true);
//      		obj.SetTitle("Trade|SubTrade|Rev.Lane|Description");
      		obj.SetColWidth(0, "50");
      		obj.SetColWidth(1, "60");
      		obj.SetColWidth(2, "60");
      		obj.SetColWidth(3, "250");
      		obj.SetDropHeight(190);
     
      		ComXml2ComboItem(rtn, obj, "rlane_cd", "trd_cd|sub_trd_cd|rlane_cd|rlane_nm");
      		if(isAll)
      			obj.InsertItem(0, "|||ALL");
      	}
      	function getCodeXmlList(cmd, param){
      		var rtn=new Array();
      	    rtn[0]="";
      	    rtn[1]="";
      	    createCodeSheetObject();
      	    with(codeSheet){
      	        ShowDebugMsg(false);
      	        var sXml=GetSearchData("ESM_SPC_CODGS.do", "f_cmd="+SEARCHLIST02+"&mcode="+cmd+"&"+param);
      	        var xml=sXml.substring(sXml.indexOf("<SHEET>"), sXml.indexOf("</SHEET>") + 8);
      	    }
      	    return xml;
      	}  
      	var codeSheet=null;
      	$(document).ready(function(){
      		createCodeSheetObject();
      	});

      	/*
		 * 
		 */
      	function createCodeSheetObject(){
      	    if(codeSheet != null){
      	        return;
      	    }
      	    var baseCode="";
      	    var objs =$("[id^='DIV_']");
      	    for(var i = 0 ; i < objs.length ; i++){
      	    	baseCode="";
      	        break;
      	    }


      	    var sTag="";
      	    var id="codeSheet";

      	    var divElement=document.createElement("DIV");
      	    divElement.id = "MAKE_HIDDEN_SHEET";
      	    divElement.style.display="none";
      	    divElement.innerHTML=sTag;
      	    document.body.appendChild(divElement);
      	    ComGetSheetDivObjectTag(MAKE_HIDDEN_SHEET,id);
      	    ComConfigSheet(codeSheet);

      	    with(codeSheet){
      	       var HeadTitle="Status|Seq.|Code|Name";

      	       SetConfig( { SearchMode:2, MergeSheet:2, Page:20, FrozenCol:0, FrozenCol:1, DataRowMerge:0 } );

      	       var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
      	       var headers = [ { Text:HeadTitle, Align:"Center"} ];
      	       InitHeaders(headers, info);

      	       var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"FLG",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
      	                 {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"SEQ",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
      	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"CODE",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
      	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"TEXT",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

      	       InitColumns(cols);

      			SetSheetWidth(300);
      			SetSheetHeight(150 );
      			SetEditable(1);
      			SetVisible(0);
      	   }

      	    ComEndConfigSheet(codeSheet);
      	}
      	
      	//----------------YONG JOON LEE 추가 20140731 ------START---
      	function fncChk(flg) //INPUT TEXT Only and Number Only 
      	{ alert("fncChk = "+flg);
      	    var form  = document.form;
      	    switch(flg)

    	    {
      	        case 1 :
      	            ptn = /[^\d]/;
      	            if(form.tx.value.search(ptn)!=-1) alert('숫자만 입력 가능 합니다.');
     	        break;

      	        case 2 :
      	            ptn = /\d/;
      	            if(form.tx.value.search(ptn)!=-1) alert('문자만 입력 가능 합니다.');
  	            break;
      	    }
      	}
      	
      	
      //대문자로 입력 변환
   	 function onlyText(obj){
   			val=obj.value;
   			re=/[^a-zA-Z]/gi;
   			//alert("Please input text only");
   			obj.value=val.replace(re,"");
   		}
      //----------------YONG JOON LEE 추가 20140731 ------END---
	/* 개발자 작업 끝 */
