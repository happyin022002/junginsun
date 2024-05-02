/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_980.js
*@FileTitle : More CNT Candidates
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-18
*@LastModifier : SHIN DONG IL
*@LastVersion  
* 2014-11-18 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/ 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends 
 * @class ESD_TRS_0980 : Morecandidate
 */
function ESD_TRS_0980() {
    this.processButtonClick     = processButtonClick;
    this.setSheetObject         = setSheetObject;
    this.setComboObject         = setComboObject;
    this.setTabObject           = setTabObject;
    this.loadPage               = loadPage;
    this.initSheet              = initSheet;        
    this.initControl            = initControl;
    this.initTab                = initTab;
    this.doActionIBSheet        = doActionIBSheet;
    this.validateForm           = validateForm;
}
/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/

// 공통전역변수

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {

        	    case "btn_apply":
    	            if (getMoreCntCandidates(sheetObjects[1]))       window.close();
        	    break;
        	    case "btn_close":
    	            window.close();
         	    break;
            } // end switch
    	 }catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TRS90384');
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
    		 ComConfigSheet(sheetObjects[i]);
    		 initSheet(sheetObjects[i],i+1);
    		 ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 //html컨트롤 이벤트초기화
    	 initControl();

    	 if(document.form.scrn_mode.value == "S"){
    		 ComBtnDisable("btn_apply");
    	 }
    	 
    	 doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH);
     }

     /**
      * 페이지에 있는 HTML Control의 이벤트를 동적으로 로드한다. <br>
      * {@link #loadPage}함수에서 이 함수를 호출하여 IBSheet Object를 초기화 한다. <br>
      * @param {ibsheet} sheetObj    IBSheet Object
      * @param {int}     sheetNo     sheetObjects 배열에서 순번
      **/
     function initControl() {
     }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 200;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(6, 7, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle0 = "Sel.|CNT Type|S/P\nCode|S/P\nName";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtRadioCheck ,  28,  daCenter, true, "ibchk"																		);
                    
                    //InitDataProperty(0, cnt++, dtData		,  70,  daCenter, true, "cnt_tp_cd"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtCombo		,  70,  daCenter, true, "cnt_tp_cd"				, false, "", dfNone			, 0, false	, false		);
                    
                    
                    InitDataProperty(0, cnt++, dtData		,  70,  daCenter, true, "vndr_seq"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  100, daLeft,   true, "vndr_nm"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtHidden		,  70,  daCenter, true, "cust_cnt_cd"			, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtHidden		,  100, daLeft,   true, "cust_seq"				, false, "", dfNone			, 0, false	, false		);
                    InitDataCombo(0, 'cnt_tp_cd',    "SML|CNT|CPT|HPT",    "HJS|CNT|CPT|HPT");
 
               }
            break;
     		case 2:      //sheet1 init
    			with (sheetObj) {
    				// 높이 설정
    				style.height=0;
    				//전체 너비 설정
    				SheetWidth = 0;

    				//Host정보 설정[필수][HostIp, Port, PagePath]
    				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

    				//전체Merge 종류 [선택, Default msNone]
    				MergeSheet = msHeaderOnly;

    			   //전체Edit 허용 여부 [선택, Default false]
    				Editable = true;

    				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
    				InitRowInfo( 1, 1, 9, 100);

    				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(30, 4, 0, true);  //24

    				// 해더에서 처리할 수 있는 각종 기능을 설정한다
    				InitHeadMode(true, true, true, true, false,false);

    				var HeadTitle = "|soOfc|soSeq|agmtOfc|agmtSeq";

    				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
    				InitHeadRow(0, HeadTitle, true);

    				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    				InitDataProperty(0, cnt++ , dtStatus,  0,   daCenter,   true,    "ibflag");
    				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "trsp_so_ofc_cty_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "trsp_so_seq");
    				InitDataProperty(0, cnt++ , dtData,    30,   daCenter,   true,    "po_trsp_agmt_ofc_cty_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_trsp_agmt_seq");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_trsp_agmt_rt_tp_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_way_type");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_trsp_agmt_rt_tp_nm");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_sp_type");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_cust_nomi_trkr_flg");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_cust_cnt_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_cust_seq");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_local_curr_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_basic_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_fuel_scg_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_vat_scg_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_scg1_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "toll_fee_amt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_scg3_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_over_wgt_scg_rt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_local_curr_tot_amt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_usd_curr_tot_amt");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_rtn_cd");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_rtn_msg");
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_wtr_rcv_term_cd");  
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_wtr_de_term_cd");
    				
    				InitDataProperty(0, cnt++ , dtData,    0,   daCenter,   true,    "po_cfm_flg");
    				InitDataProperty(0, cnt++ , dtData,    0,   daCenter,   true,    "po_agmt_rt_seq");
    				InitDataProperty(0, cnt++ , dtData,    0,   daCenter,   true,    "po_agmt_upd_dt");
    				
    				InitDataProperty(0, cnt++ , dtData,    60,   daCenter,   true,    "po_cust_nomi_trkr_ind_cd");

    				ColHidden('ibflag')	= true;
    			}
    		break;       
                
        }
    }

	//Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
	    sheetObj.ShowDebugMsg = false;
	    switch(sAction) {
	
	        case IBSEARCH:        //저장
	            formObj.f_cmd.value = SEARCH;            
	            sheetObj.DoSearch4Post ("ESD_TRS_0980GS.do" , TrsFrmQryString(formObj));
	        break;
	    }
	}
	
	function getMoreCntCandidates(sheetObj){
		var formObj = document.form;
		var chk_row = formObj.chk_row.value;
		var arr_chk_row = chk_row.split("|");
		var sel_row 	= sheetObjects[0].FindCheckedRow("ibchk");
		
		if(sel_row==""){
			return;	
		}
		
		var arr_sel_row = sel_row.split("|");
		var scrn_mode 	= formObj.scrn_mode.value;
		var opener		= window.dialogArguments;
		var open_SheetObj = opener.sheetObjects[0];
		sheetObjects[1].RemoveAll();
		//G : Grid PopUp, M: Multi CNT Button 일 경우
		if(scrn_mode =="G" && arr_chk_row.length > 1){
			var queryStr = open_SheetObj.RowSaveStr(arr_chk_row[0]);
		}else if(scrn_mode =="M"){
			var queryStr = open_SheetObj.GetSaveString(false, true, 'ibcheck');			
		}
		sheetObj.DoSearch4Post('ESD_TRS_0969.screen',queryStr,'', false);

		var cust_cnt_cd = sheetObjects[0].CellValue(arr_sel_row[0], 'cust_cnt_cd');
		var cust_seq = sheetObjects[0].CellValue(arr_sel_row[0], 'cust_seq');
		formObj.f_cmd.value = SEARCH02;
		formObj.WY_TP_CD.value = "";
		formObj.SP_TP_CD.value = sheetObjects[0].CellValue(arr_sel_row[0], 'cnt_tp_cd');				// SP Select 처럼 CNT Type 를 Param..에
		formObj.CUST_CNT_CD.value = cust_cnt_cd;
		formObj.CUST_SEQ.value = cust_seq;
		formObj.VNDR_CD.value = sheetObjects[0].CellValue(arr_sel_row[0], 'vndr_seq');
		formObj.BASIS_DT.value = "";
		formObj.WTR_RCV_TERM.value = "";
		formObj.WTR_DE_TERM.value = "";
		sheetObj.DoAllSave("ESD_TRS_0023GS.do",queryStr+"&"+ TrsFrmQryString(formObj));
	}
	
	/**
	 * Apply 버튼 클릭시 메인창에 S/P Code Setting.
	 */
	function setMoreCntCandidates(){
		var formObj = document.form;
	    var opener = window.dialogArguments;
		var opener_sheetObj = opener.sheetObjects[0];
		var chk_row = formObj.chk_row.value;
	    var arr_chk_row = chk_row.split("|");
		var sel_row 	= sheetObjects[0].FindCheckedRow("ibchk");
		var arr_sel_row = sel_row.split("|");
	    var value1 = '';
		var value2 = '';
		var result = 0;
	    // scrn_mode : S= Search, M=Modify
	    for( var i=0; i<arr_chk_row.length-1; i++ ){
			value1 = opener_sheetObj.CellValue(arr_chk_row[i], 'trsp_so_ofc_cty_cd')+opener_sheetObj.CellValue(arr_chk_row[i], 'trsp_so_seq');
			for(var k=1; k< sheetObjects[1].RowCount+1; k++){
				value2 = sheetObjects[1].CellValue(k, 'trsp_so_ofc_cty_cd')+sheetObjects[1].CellValue(k, 'trsp_so_seq');
				if(value1 == value2){
					if(sheetObjects[0].CellValue(arr_sel_row[0] , "cust_cnt_cd").length > 0){
//						opener_sheetObj.CellValue(arr_chk_row[i], "po_sp_type")				= "Y";
						opener_sheetObj.CellValue(arr_chk_row[i], "cust_cnt_cd_seq")		= sheetObjects[0].CellValue(arr_sel_row[0] , "cust_cnt_cd")+sheetObjects[0].CellValue(arr_sel_row[0] , "cust_seq");
						opener_sheetObj.CellValue(arr_chk_row[i], "po_cust_cnt_cd")			= sheetObjects[0].CellValue(arr_sel_row[0] , "cust_cnt_cd");
						opener_sheetObj.CellValue(arr_chk_row[i], "po_cust_seq")			= sheetObjects[0].CellValue(arr_sel_row[0] , "cust_seq");
						opener_sheetObj.CellValue(arr_chk_row[i], "ctrt_tp_flg")			= "Y";
						opener_sheetObj.CellValue(arr_chk_row[i], "ctrt_tp_cd")				= sheetObjects[0].CellValue(arr_sel_row[0] , "cnt_tp_cd");
					}else{
//						opener_sheetObj.CellValue(arr_chk_row[i], "po_sp_type")				= "N";    
						opener_sheetObj.CellValue(arr_chk_row[i], "cust_cnt_cd_seq")		= "";
						opener_sheetObj.CellValue(arr_chk_row[i], "po_cust_cnt_cd")			= "";
						opener_sheetObj.CellValue(arr_chk_row[i], "po_cust_seq")			= "";        			
						opener_sheetObj.CellValue(arr_chk_row[i], "ctrt_tp_flg")			= "N";
						opener_sheetObj.CellValue(arr_chk_row[i], "ctrt_tp_cd") 			= "HJS"
					}
					opener_sheetObj.CellValue(arr_chk_row[i], "vndr_seq")		 			= sheetObjects[0].CellValue(arr_sel_row[0] , "vndr_seq");
					opener_sheetObj.CellValue(arr_chk_row[i], "vndr_nm")		 			= sheetObjects[0].CellValue(arr_sel_row[0] , "vndr_nm");
					/*opener_sheetObj.CellValue(arr_chk_row[i], 'po_cust_cnt_cd') 			= sheetObjects[1].CellValue(k, 'po_cust_cnt_cd');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_cust_seq') 				= sheetObjects[1].CellValue(k, 'po_cust_seq');*/
					if(sheetObjects[1].CellValue(k, 'po_local_curr_cd')!=""){
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_local_curr_cd') 			= sheetObjects[1].CellValue(k, 'po_local_curr_cd');
					}
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_trsp_agmt_ofc_cty_cd') 	= sheetObjects[1].CellValue(k, 'po_trsp_agmt_ofc_cty_cd');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_trsp_agmt_seq') 			= sheetObjects[1].CellValue(k, 'po_trsp_agmt_seq');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_trsp_agmt_rt_tp_cd') 		= sheetObjects[1].CellValue(k, 'po_trsp_agmt_rt_tp_cd');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_way_type') 				= sheetObjects[1].CellValue(k, 'po_way_type');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_trsp_agmt_rt_tp_nm') 		= sheetObjects[1].CellValue(k, 'po_trsp_agmt_rt_tp_nm');
					/*if(sheetObjects[1].CellValue(k, 'po_sp_type')!=""){
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_sp_type') 			= sheetObjects[1].CellValue(k, 'po_sp_type');
					}*/

					/*if(sheetObjects[1].CellValue(k, 'po_cust_nomi_trkr_flg') !=""){
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_cust_nomi_trkr_flg') 	= sheetObjects[1].CellValue(k, 'po_cust_nomi_trkr_flg');
					}*/
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_basic_rt') 				= sheetObjects[1].CellValue(k, 'po_basic_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_fuel_scg_rt') 			= sheetObjects[1].CellValue(k, 'po_fuel_scg_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_vat_scg_rt') 				= sheetObjects[1].CellValue(k, 'po_vat_scg_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_scg1_rt') 				= sheetObjects[1].CellValue(k, 'po_scg1_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'toll_fee_amt') 				= sheetObjects[1].CellValue(k, 'toll_fee_amt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_scg3_rt') 				= sheetObjects[1].CellValue(k, 'po_scg3_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_over_wgt_scg_rt') 		= sheetObjects[1].CellValue(k, 'po_over_wgt_scg_rt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_local_curr_tot_amt') 		= sheetObjects[1].CellValue(k, 'po_local_curr_tot_amt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_usd_curr_tot_amt') 		= sheetObjects[1].CellValue(k, 'po_usd_curr_tot_amt');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_rtn_cd') 					= sheetObjects[1].CellValue(k, 'po_rtn_cd');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_rtn_msg') 				= sheetObjects[1].CellValue(k, 'po_rtn_msg');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_wtr_rcv_term_cd') 		= sheetObjects[1].CellValue(k, 'po_wtr_rcv_term_cd'); 
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_wtr_de_term_cd') 			= sheetObjects[1].CellValue(k, 'po_wtr_de_term_cd');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_cfm_flg') 				= sheetObjects[1].CellValue(k, 'po_cfm_flg');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_agmt_rt_seq') 			= sheetObjects[1].CellValue(k, 'po_agmt_rt_seq');
					opener_sheetObj.CellValue(arr_chk_row[i], 'po_agmt_upd_dt') 			= sheetObjects[1].CellValue(k, 'po_agmt_upd_dt');
					
					opener_sheetObj.CellValue(arr_chk_row[i], 'trsp_sp_cng_rsn_cd') 			= "";
					opener_sheetObj.CellValue(arr_chk_row[i], 'trsp_sp_cng_rsn_rmk') 			= "";
					opener_sheetObj.CellValue(arr_chk_row[i], 'agmt_mor_cnddt_aply_flg') 	= "";
					
					// 160404 1.	More CNT Candidate로 선택한 CNT S/P의 요율이 AGMT에 존재해서 적용되면 CNT(Agreement) 컬럼에 그에 맞는 값
					if(sheetObjects[1].CellValue(k, 'po_cust_nomi_trkr_flg') == "Y"){
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_sp_type') 				= sheetObjects[1].CellValue(k, 'po_cust_nomi_trkr_flg');
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_cust_nomi_trkr_ind_cd') 	= sheetObjects[1].CellValue(k, 'po_cust_nomi_trkr_ind_cd');
					}else{
						opener_sheetObj.CellValue(arr_chk_row[i], 'po_cust_nomi_trkr_ind_cd') 	= "";
					}
					
					if(ComTrim(sheetObjects[1].CellValue(k, 'po_trsp_agmt_seq')) != ''){
						result++;
					}
				}//end if(value1 == value2)
			}
		}

	    if(result < 1){
	    	ComShowCodeMessage('TRS90132');
	    }else {
			ComShowCodeMessage('TRS90216');
		}

	    window.close();
	}
	 /**
	  * 조회결과에 오류가 발생했을 때 공통처리하는 함수
	  * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	  */
	function sheet_OnSearchEnd(sheetObj, errMsg) {
		var formObj = document.form;
	 	if( errMsg != '' ) {
	 		ComShowMessage(errMsg);
	 	}else{
	 		for(var i=1;sheetObj.RowCount > 0 && i<=sheetObj.RowCount;i++){
	 			if(formObj.vndr_seq.value == sheetObj.CellValue(i,"vndr_seq")){
		 			sheetObj.CellFont("FontBold", i,"cnt_tp_cd") = true;
		 			sheetObj.CellFont("FontBold", i,"vndr_seq") = true;
		 			sheetObj.CellFont("FontBold", i,"vndr_nm") = true;
	 			}
	 		}
	 	}
	 }
	
	 /**
	  * 조회결과에 오류가 발생했을 때 공통처리하는 함수
	  * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
	  */
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
	 	if( errMsg != '' ) {
	 		ComShowMessage(errMsg);
	 	}else{
	 		setMoreCntCandidates();
	 	}
	 }
