/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_921.js
*@FileTitle : More Candidates 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-2-3
*@LastModifier : Bong-jun
*@LastVersion : 1.125
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.9 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
* 1.10 2010.12.28 민정호 [CHM-201008042] AGMT 적용시 Customer Nominated 적용
* 2011.05.06  손은주 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.07.03 김영철 2011.07.14 김영철 [CHM-201110224] [TRS] Flat rack CNTR Bundling 기능 추가요청 - SO화면에서 Bundling Data를 보여줌.
=========================================================*/ 
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @fileoverview Booking 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 * @author 한진해운
 */

/**
 * @extends Bkg
 * @class ESD_TRS_0921 : Morecandidate
 */
function ESD_TRS_0921() {
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
    	            //if (setMoreCandidates(sheetObject))       window.close();
        	    	setMoreCandidates(sheetObject);
        	        break;
        	    case "btn_close":
	  				if(!ComShowCodeConfirm("TRS90712")){ // You are not finished yet, are you sure?
						return false;
					}
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
    	 var formObject = document.form;
    	 for(i=0;i<sheetObjects.length;i++){
    		 //khlee-시작 환경 설정 함수 이름 변경
    		 ComConfigSheet(sheetObjects[i]);
    		 initSheet(sheetObjects[i],i+1);
    		 //khlee-마지막 환경 설정 함수 추가
    		 ComEndConfigSheet(sheetObjects[i]);
    	 }
    	 getTrsIbComboList(formObject.eq_tp_sz_cd , eq_tp_sz_cd  , eq_tp_sz_cd  , 'ALL');  

    	 getTrsIbComboList(formObject.way_tp_cd , 'ONE|RND' ,  'One Way(CY rate)|Round Trip(DR rate)' , 'ALL');  //Way Type
    	 
    	 formObject.eq_tp_sz_cd.Index = 1; 

    	 doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH);
    	 
    	 //html컨트롤 이벤트초기화
    	 initControl();       
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
                    style.height = 293;

                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 2, 1, 9, 100);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(35, 6, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle0 = "Sel.|Seq|AGMT\nNo|S/P\nType|S/P\nCode|S/P\nName|Hazmat\n(DG)|Over\nweight|Rejected\nHistory|AGMT\nType|AGMT\nConfirm|"
                                  + "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Reason of S/P Select|Change Remark|"
                                  + "Customer\nCode|Reference No|Feeder Term|Feeder Term|Effective Date|Effective Date|One Way/\nRound Trip|Update\nDate|Update\nUser"
                                  ;

                    var HeadTitle1 = "Sel.|Seq|AGMT\nNo|S/P\nType|S/P\nCode|S/P\nName|Hazmat\n(DG)|Over\nweight|Rejected\nHistory|AGMT\nType|AGMT\nConfirm|"
                                  + "CUR|Basic\nAmount|Fuel\nSurcharge|Toll Fee|Vat\nSurcharge|Total\nAmount|Total\nAmount(USD)|Reason of S/P Select|Change Remark|"
                                  + "Customer\nCode|Reference No|Receiving|Delivery|From|To|One Way/\nRound Trip|Update\nDate|Update\nUser"
                                  ;

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle0, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtRadioCheck ,  28, daCenter, true, "ibchk"																		);
                    InitDataProperty(0, cnt++, dtData       ,  43, daCenter, true, "seq"					, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData       ,  65, daCenter, true, "agmt_no"	            , false, "", dfNone			, 0, false	, false	    );
                    
                    //InitDataProperty(0, cnt++, dtData       ,  38, daCenter, true, "vndr_tp_cd"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtCombo       ,  38, daCenter, true, "vndr_tp_cd"				, false, "", dfNone			, 0, false	, false		);
                    
                    
                    InitDataProperty(0, cnt++, dtData		,  45, daCenter, true, "vndr_seq"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  80, daLeft,   true, "vndr_nm"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  50, daCenter, true, "hzd_mtrl_flg"			, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  50, daCenter, true, "ovwt_tri_axl_flg"		, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  56, daCenter, true, "rjt_hist"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtHidden		,  60, daCenter, true, "trsp_agmt_rt_tp_nm"		, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  50, daCenter, true, "cfm_flg"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  35, daCenter, true, "curr_cd"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  70,  daRight, true, "basic_rate"				, false, "", dfNullFloat    , 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  70,  daRight, true, "fuel_scg_rt"			, false, "", dfNullFloat    , 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  60,  daRight, true, "toll_fee_rt"			, false, "", dfNullFloat    , 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  65,  daRight, true, "vat_scg_rt"				, false, "", dfNullFloat    , 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  70,  daRight, true, "tot_amount"				, false, "", dfNullFloat    , 2, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  85,  daRight, true, "tot_usd_amount"			, false, "", dfNullFloat    , 2, false	, false		);
                    
                    // USA Only
                    if(mlt_mor_ony_flg == 'Y'){
                    	InitDataProperty(0, cnt++, dtCombo  , 170, daCenter, true, "trsp_sp_cng_rsn_cd"		, false, "", dfNone			, 0, true	, true		);
                    	InitDataProperty(0, cnt++, dtData  , 170, daLeft, true, "trsp_sp_cng_rsn_rmk"		, false, "", dfNone			, 0, false	, false		);
                    }else{
                    	InitDataProperty(0, cnt++, dtHidden , 90, daCenter, true, "trsp_sp_cng_rsn_cd"		, false, "", dfNone			, 0, false	, false		);
                    	InitDataProperty(0, cnt++, dtHidden , 100, daLeft, true, "trsp_sp_cng_rsn_rmk"		, false, "", dfNone			, 0, false	, false		);
                    }
                    InitDataProperty(0, cnt++, dtData		,  70, daCenter, true, "cust_cd"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  90, daLeft, true, "agmt_ref_no"				, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  65, daCenter, true, "wtr_rcv_term_cd"		, false, "", dfNone			, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData		,  65, daCenter, true, "wtr_de_term_cd"			, false, "", dfNone			, 0, false	, false		);
                    
                    InitDataProperty(0, cnt++, dtData       ,  75, daCenter, true, "eff_fm_dt" 				, false, "", dfDateYmd		, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData       ,  75, daCenter, true, "eff_to_dt" 				, false, "", dfDateYmd		, 0, false	, false		);
                    
                    InitDataProperty(0, cnt++, dtCombo      , 110, daLeft, true, "way_type"				, false, "", dfNone			, 0, false	, false		);
                    
                    InitDataProperty(0, cnt++, dtData       , 120, daCenter, true, "trsp_agmt_upd_dt" 		, false, "", dfUserFormat2	, 0, false	, false		);
                    InitDataProperty(0, cnt++, dtData       ,  80, daLeft, true, "trsp_agmt_upd_usr_id" 	, false, "", dfNone			, 0, false	, false		);
                    //get Agreement Number
                    InitDataProperty(0, cnt++, dtHidden     ,  65, daCenter, true, "trsp_agmt_ofc_cty_cd"	, false, "", dfNone			, 0, false	, false	    );
                    InitDataProperty(0, cnt++, dtHidden     ,  65, daCenter, true, "trsp_agmt_seq"			, false, "", dfNone			, 0, false	, false	    );
                    //get Agreement Number
                    //get agreement rate type + cnt indicator
                    InitDataProperty(0, cnt++, dtHidden     ,  65, daCenter, true, "trsp_agmt_rt_tp_cd"	     , false, "", dfNone		, 0, false	, false	    );
                    InitDataProperty(0, cnt++, dtHidden     ,  65, daCenter, true, "cust_nomi_trkr_flg"	     , false, "", dfNone		, 0, false	, false	    );

    				InitDataProperty(0, cnt++ , dtHidden    ,	0, daCenter, false, "trsp_agmt_rt_seq");
//    				InitDataProperty(0, cnt++ , dtHidden    ,	0, daCenter, false, "trsp_agmt_upd_dt");
    				
    				InitDataProperty(0, cnt++ , dtHidden    ,	0, daCenter, false, "rank_amt");
    				
    				InitUserFormat2(0, "trsp_agmt_upd_dt", 		"####-##-## ##:##:##", "-|:" );

                    InitDataCombo(0, 'way_type', " |One Way(CY rate)|Round Trip(DR rate)", " |ONE|RND");
                    InitDataCombo(0, 'trsp_sp_cng_rsn_cd', trsp_sp_cng_rsn_cdText, trsp_sp_cng_rsn_cdCode);
                    InitDataCombo(0, 'vndr_tp_cd',    "SML|CNT|CPT|HPT",    "HJS|CNT|CPT|HPT");
                    
                    HeadRowHeight = 30;
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
                sheetObj.DoSearch4Post ("ESD_TRS_0921GS.do" , TrsFrmQryString(formObj));
                break;
        }
    }

     function setMoreCandidates(sheetObj) {
    	 
         var formObject = document.form;
         var opener_obj = window.dialogArguments;

         var rowTotCnt          = 0 ;
         var chkRowCnt          = 0 ;
         var selectedRowNo      = "";
         var way_tp_cd          = "";
         var oneway_curr_cd     = "";
         var roundtrip_curr_cd  = "";

         var targetRow          = document.form.targetRow.value;
         var gubun_name         = "";

         rowTotCnt              = sheetObj.RowCount;
         for( var i=2; i<rowTotCnt+2; i++ ){        	 
        	 if ( sheetObj.CellValue(i, "ibchk") == "1" ){        	
        		 chkRowCnt      = chkRowCnt+1;
        		 selectedRowNo  = i;

        		// USA Only
                 if( mlt_mor_ony_flg == "Y" && sheetObj.CellValue(selectedRowNo , "rank_amt") != "1" && sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_cd") == ""){
                 	ComShowCodeMessage('TRS90710'); // Not the lowest price. Please enter a reason.
                 	return false;
                 }
                 
                // Other일 경우 remark를 필수 입력
              	if (sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_cd") == 'O' && sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_rmk").length == 0 ) {
             		ComShowCodeMessage('TRS90710'); // Not the lowest price. Please enter a reason.
             		return false;
             	}                 

				 if( formObject.single_multi_sep.value == "M" ) {
					var agmtObj = new Object();
					if( sheetObj.CellValue(selectedRowNo , "cust_cd").length > 0 ) {
						agmtObj.po_sp_type      = "Y";
						agmtObj.cust_cnt_cd_seq = sheetObj.CellValue(selectedRowNo , "cust_cd");
						agmtObj.po_cust_cnt_cd  = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(0,2);
						agmtObj.po_cust_seq     = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(2,8);
						agmtObj.po_cust_nomi_trkr_flg = "Y";
						agmtObj.po_cust_nomi_trkr_ind_cd = sheetObj.CellValue(selectedRowNo , "vndr_tp_cd");
					} else {
						agmtObj.po_sp_type      = "N";    
						agmtObj.cust_cnt_cd_seq = "";
						agmtObj.po_cust_cnt_cd  = "";
						agmtObj.po_cust_seq     = "";        			
						agmtObj.po_cust_nomi_trkr_flg = "N";        			
						agmtObj.po_cust_nomi_trkr_ind_cd = "HJS";
					}
					agmtObj.eq_tp_sz_cd             = formObject.eq_tp_sz_cd.Code;
					agmtObj.vndr_seq                = sheetObj.CellValue(selectedRowNo , "vndr_seq"                 );
					agmtObj.vndr_nm                 = sheetObj.CellValue(selectedRowNo , "vndr_nm"                  );
					agmtObj.hzd_mtrl_flg            = sheetObj.CellValue(selectedRowNo , "hzd_mtrl_flg"             );
					agmtObj.ovwt_tri_axl_flg        = sheetObj.CellValue(selectedRowNo , "ovwt_tri_axl_flg"         );
					agmtObj.po_trsp_agmt_rt_tp_nm   = sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_tp_nm"       );
					agmtObj.po_local_curr_cd        = sheetObj.CellValue(selectedRowNo , "curr_cd"                  );
					agmtObj.po_basic_rt             = sheetObj.CellValue(selectedRowNo , "basic_rate"               );
					agmtObj.po_fuel_scg_rt          = sheetObj.CellValue(selectedRowNo , "fuel_scg_rt"              );
					agmtObj.toll_fee_amt          	= sheetObj.CellValue(selectedRowNo , "toll_fee_rt"              );
					agmtObj.po_vat_scg_rt           = sheetObj.CellValue(selectedRowNo , "vat_scg_rt"               );
					agmtObj.po_local_curr_tot_amt   = sheetObj.CellValue(selectedRowNo , "tot_amount"               );
					agmtObj.po_usd_curr_tot_amt     = sheetObj.CellValue(selectedRowNo , "tot_usd_amount"           );
					agmtObj.po_trsp_agmt_ofc_cty_cd = sheetObj.CellValue(selectedRowNo , "trsp_agmt_ofc_cty_cd"     );
					agmtObj.po_trsp_agmt_seq        = sheetObj.CellValue(selectedRowNo , "trsp_agmt_seq"            );
					agmtObj.po_way_type             = sheetObj.CellValue(selectedRowNo , "way_type"                 );
					agmtObj.po_trsp_agmt_rt_tp_cd   = sheetObj.CellValue(selectedRowNo , "agmt_rt_tp_cd"            );
					agmtObj.po_wtr_rcv_term_cd      = sheetObj.CellValue(selectedRowNo , "wtr_rcv_term_cd"          );
					agmtObj.po_wtr_de_term_cd       = sheetObj.CellValue(selectedRowNo , "wtr_de_term_cd"           );
					
					agmtObj.po_cfm_flg          	= sheetObj.CellValue(selectedRowNo , "cfm_flg"           );
					agmtObj.po_agmt_rt_seq    		= sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_seq"           );
					agmtObj.po_agmt_upd_dt   		= sheetObj.CellValue(selectedRowNo , "trsp_agmt_upd_dt"           );
					
					// Office 가 USA 이면서 Agreement Type 이 HJS 일경우 More Candidate 사용을 필수 처리 하기 위한
					// 최저 요율 S/P 미선택 후 기타 S/P 선택 시 Reason 필수 입력
					agmtObj.trsp_sp_cng_rsn_cd   	= sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_cd");
					agmtObj.trsp_sp_cng_rsn_rmk   	= sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_rmk");
					
					agmtObj.more_candidates_flg   	= "Y";

					/* Default Service Provicer Flag 처리 - Default S/P --> 'Y', None-default S/O --> 'N' */
					if(sheetObj.CellValue(selectedRowNo, "seq") == 'Preset')    agmtObj.trsp_dflt_vndr_flg = "Y";
					else                                                        agmtObj.trsp_dflt_vndr_flg = "N";
					opener_obj.rtnMultiESD_TRS_0921(agmtObj);
					
					//Rate Apply 완료후 적용된 TP/SZ는 삭제 후 다른 TP/SZ가 있을 경우 TP/SZ 변경 후 재조회
					formObject.eq_tp_sz_cd.DeleteItem(agmtObj.eq_tp_sz_cd);
					formObject.eq_tp_sz_cd.Index = 1; 

					if (formObject.eq_tp_sz_cd.Code == "") {
						//ComBtnDisable("btn_apply"); // 모두 반영되었으면 Apply 버튼 비활성화
						window.close();
					}else{
						doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH);
						
						for( var j=2; j<sheetObj.RowCount+2; j++ ){
							if ( sheetObj.CellValue(j, "vndr_seq") == agmtObj.vndr_seq ){ 
								//sheetObj.CellValue(j, "ibchk") = "1";
								//sheetObj.CellValue(j, "trsp_sp_cng_rsn_cd") = agmtObj.trsp_sp_cng_rsn_cd;
								//sheetObj.CellValue(j, "trsp_sp_cng_rsn_rmk") = agmtObj.trsp_sp_cng_rsn_rmk;
							}
						}
					}

					return true;
				 } else {
					 if (opener_obj.document.sheet.CellValue(targetRow, "mcntr_bdl_grp_seq") != ""  && opener_obj.document.sheet.CellValue(targetRow, "mcntr_bdl_grp_seq") != null){
						 for( var j=2 ; j<opener_obj.document.sheet.RowCount+2; j++ ){
							if(opener_obj.document.sheet.CellValue(targetRow, "mcntr_bdl_grp_seq") == opener_obj.document.sheet.CellValue(j, "mcntr_bdl_grp_seq")){
								 if(sheetObj.CellValue(selectedRowNo , "cust_cd").length > 0){
									opener_obj.document.sheet.CellValue2(j, "po_sp_type") = "Y";
									opener_obj.document.sheet.CellValue2(j, "cust_cnt_cd_seq") = sheetObj.CellValue(selectedRowNo , "cust_cd");
									opener_obj.document.sheet.CellValue2(j, "po_cust_cnt_cd") = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(0,2);
									opener_obj.document.sheet.CellValue2(j, "po_cust_seq") = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(2,8);
									opener_obj.document.sheet.CellValue2(j, "po_cust_nomi_trkr_flg") = "Y";
								 }else{
									opener_obj.document.sheet.CellValue2(j ,"po_sp_type") = "N";    
									opener_obj.document.sheet.CellValue2(j, "cust_cnt_cd_seq") = "";
									opener_obj.document.sheet.CellValue2(j, "po_cust_cnt_cd") = "";
									opener_obj.document.sheet.CellValue2(j, "po_cust_seq") = "";        			
									opener_obj.document.sheet.CellValue2(j ,"po_cust_nomi_trkr_flg") = "N";        			
								 }

								 opener_obj.document.sheet.CellValue2( j , "vndr_seq"                 ) = sheetObj.CellValue(selectedRowNo , "vndr_seq"                 );
								 opener_obj.document.sheet.CellValue2( j , "vndr_nm"                  ) = sheetObj.CellValue(selectedRowNo , "vndr_nm"                  );
								 
								 opener_obj.document.sheet.CellValue2( j , "hzd_mtrl_flg"             ) = sheetObj.CellValue(selectedRowNo , "hzd_mtrl_flg"             );
								 opener_obj.document.sheet.CellValue2( j , "ovwt_tri_axl_flg"         ) = sheetObj.CellValue(selectedRowNo , "ovwt_tri_axl_flg"         );
								 
								 opener_obj.document.sheet.CellValue2( j , "po_trsp_agmt_rt_tp_nm"    ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_tp_nm"       );
								 opener_obj.document.sheet.CellValue2( j , "po_local_curr_cd"         ) = sheetObj.CellValue(selectedRowNo , "curr_cd"                  );
								 opener_obj.document.sheet.CellValue2( j , "po_trsp_agmt_ofc_cty_cd"  ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_ofc_cty_cd"     );
								 opener_obj.document.sheet.CellValue2( j , "po_trsp_agmt_seq"         ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_seq"            );
								 opener_obj.document.sheet.CellValue2( j , "po_way_type"              ) = sheetObj.CellValue(selectedRowNo , "way_type"                 );
								 opener_obj.document.sheet.CellValue2( j , "po_trsp_agmt_rt_tp_cd"    ) = sheetObj.CellValue(selectedRowNo , "agmt_rt_tp_cd"            );
								 opener_obj.document.sheet.CellValue2( j , "po_vat_scg_rt"            ) = sheetObj.CellValue(selectedRowNo , "vat_scg_rt"               );

								 if(opener_obj.document.sheet.CellValue(j, "mcntr_bdl_seq")=="1"){
									 opener_obj.document.sheet.CellValue2( j , "po_basic_rt"              ) = sheetObj.CellValue(selectedRowNo , "basic_rate"               );
									 opener_obj.document.sheet.CellValue2( j , "po_fuel_scg_rt"           ) = sheetObj.CellValue(selectedRowNo , "fuel_scg_rt"              );
									 opener_obj.document.sheet.CellValue2( j , "toll_fee_amt"             ) = sheetObj.CellValue(selectedRowNo , "toll_fee_rt"              );
									 opener_obj.document.sheet.CellValue2( j , "po_local_curr_tot_amt"    ) = sheetObj.CellValue(selectedRowNo , "tot_amount"               );
									 opener_obj.document.sheet.CellValue2( j , "po_usd_curr_tot_amt"      ) = sheetObj.CellValue(selectedRowNo , "tot_usd_amount"           );
								 } else {
									 opener_obj.document.sheet.CellValue2( j , "po_basic_rt"              ) = 0;
									 opener_obj.document.sheet.CellValue2( j , "po_fuel_scg_rt"           ) = 0;
									 opener_obj.document.sheet.CellValue2( j , "toll_fee_amt"             ) = 0;
									 opener_obj.document.sheet.CellValue2( j , "po_local_curr_tot_amt"    ) = 0;
									 opener_obj.document.sheet.CellValue2( j , "po_usd_curr_tot_amt"      ) = 0;
								 }
								 
								 opener_obj.document.sheet.CellValue2( j , "po_cfm_flg"            ) = sheetObj.CellValue(selectedRowNo , "cfm_flg"               );
								 opener_obj.document.sheet.CellValue2( j , "po_agmt_rt_seq"      ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_seq"               );
								 opener_obj.document.sheet.CellValue2( j , "po_agmt_upd_dt"     ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_upd_dt"               );
								 opener_obj.document.sheet.CellValue2( j , "agmt_mor_cnddt_aply_flg"     ) = 'Y';
								 
								// Office 가 USA 이면서 Agreement Type 이 HJS 일경우 More Candidate 사용을 필수 처리 하기 위한
								// 최저 요율 S/P 미선택 후 기타 S/P 선택 시 Reason 필수 입력
								opener_obj.document.sheet.CellValue2( j , "trsp_sp_cng_rsn_cd"            ) = sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_cd");
								opener_obj.document.sheet.CellValue2( j , "trsp_sp_cng_rsn_rmk"            ) = sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_rmk");
								opener_obj.document.sheet.CellValue2( j , "more_candidates_flg"           ) = "Y";
								 
								 if (opener_obj.document.sheet.CellValue(j, 'po_cfm_flg') == 'N') {			
									 opener_obj.document.sheet.RowFontColor(j) =  opener_obj.document.sheet.RgbColor(163, 73, 164);
								 }else if (opener_obj.document.sheet.CellValue(j, 'po_cfm_flg') == 'Y') {
									 opener_obj.document.sheet.RowFontColor(j) =  opener_obj.document.sheet.RgbColor(0,0,0);
								 }
				
								 /* Default Service Provicer Flag 처리 - Default S/P --> 'Y', None-default S/O --> 'N' */
								 if(sheetObj.CellValue(selectedRowNo, "seq") == 'Preset')    opener_obj.document.sheet.CellValue2(j, "trsp_dflt_vndr_flg") = 'Y';
								 else                                                        opener_obj.document.sheet.CellValue2(j, "trsp_dflt_vndr_flg") = 'N';
							}
						 }
					 } else {

						 if(sheetObj.CellValue(selectedRowNo , "cust_cd").length > 0){
							opener_obj.document.sheet.CellValue2(targetRow, "po_sp_type") = "Y";
							opener_obj.document.sheet.CellValue2(targetRow, "cust_cnt_cd_seq") = sheetObj.CellValue(selectedRowNo , "cust_cd");
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_cnt_cd") = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(0,2);
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_seq") = sheetObj.CellValue(selectedRowNo , "cust_cd").substring(2,8);
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_nomi_trkr_flg") = "Y";
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_nomi_trkr_ind_cd")  = sheetObj.CellValue(selectedRowNo , "vndr_tp_cd");
						 }else{
							opener_obj.document.sheet.CellValue2(targetRow, "po_sp_type") 		= "N";    
							opener_obj.document.sheet.CellValue2(targetRow, "cust_cnt_cd_seq") 	= "";
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_cnt_cd") 	= "";
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_seq") 		= "";        			
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_nomi_trkr_flg") = "N";        			
							opener_obj.document.sheet.CellValue2(targetRow, "po_cust_nomi_trkr_ind_cd")  = "HJS";
						 }
												 
						 opener_obj.document.sheet.CellValue2( targetRow , "vndr_seq"                 ) = sheetObj.CellValue(selectedRowNo , "vndr_seq"                 );
						 opener_obj.document.sheet.CellValue2( targetRow , "vndr_nm"                  ) = sheetObj.CellValue(selectedRowNo , "vndr_nm"                  );
						 opener_obj.document.sheet.CellValue2( targetRow , "hzd_mtrl_flg"             ) = sheetObj.CellValue(selectedRowNo , "hzd_mtrl_flg"             );
						 opener_obj.document.sheet.CellValue2( targetRow , "ovwt_tri_axl_flg"         ) = sheetObj.CellValue(selectedRowNo , "ovwt_tri_axl_flg"         );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_trsp_agmt_rt_tp_nm"    ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_tp_nm"       );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_local_curr_cd"         ) = sheetObj.CellValue(selectedRowNo , "curr_cd"                  );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_basic_rt"              ) = sheetObj.CellValue(selectedRowNo , "basic_rate"               );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_fuel_scg_rt"           ) = sheetObj.CellValue(selectedRowNo , "fuel_scg_rt"              );
						 opener_obj.document.sheet.CellValue2( targetRow , "toll_fee_amt"   	      ) = sheetObj.CellValue(selectedRowNo , "toll_fee_rt"              );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_vat_scg_rt"            ) = sheetObj.CellValue(selectedRowNo , "vat_scg_rt"               );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_local_curr_tot_amt"    ) = sheetObj.CellValue(selectedRowNo , "tot_amount"               );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_usd_curr_tot_amt"      ) = sheetObj.CellValue(selectedRowNo , "tot_usd_amount"           );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_trsp_agmt_ofc_cty_cd"  ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_ofc_cty_cd"     );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_trsp_agmt_seq"         ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_seq"            );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_way_type"              ) = sheetObj.CellValue(selectedRowNo , "way_type"                 );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_trsp_agmt_rt_tp_cd"    ) = sheetObj.CellValue(selectedRowNo , "agmt_rt_tp_cd"            );
						 
						 opener_obj.document.sheet.CellValue2( targetRow , "po_wtr_rcv_term_cd"    	  ) = sheetObj.CellValue(selectedRowNo , "wtr_rcv_term_cd"          );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_wtr_de_term_cd"    	  ) = sheetObj.CellValue(selectedRowNo , "wtr_de_term_cd"           );
		
						 opener_obj.document.sheet.CellValue2( targetRow , "po_cfm_flg"            	  ) = sheetObj.CellValue(selectedRowNo , "cfm_flg"               	);
						 opener_obj.document.sheet.CellValue2( targetRow , "po_agmt_rt_seq"      	  ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_rt_seq"         );
						 opener_obj.document.sheet.CellValue2( targetRow , "po_agmt_upd_dt"     	  ) = sheetObj.CellValue(selectedRowNo , "trsp_agmt_upd_dt"         );			
						 opener_obj.document.sheet.CellValue2( targetRow , "agmt_mor_cnddt_aply_flg"  ) = 'Y';
						 
						// Office 가 USA 이면서 Agreement Type 이 HJS 일경우 More Candidate 사용을 필수 처리 하기 위한
						// 최저 요율 S/P 미선택 후 기타 S/P 선택 시 Reason 필수 입력
						opener_obj.document.sheet.CellValue2( targetRow , "trsp_sp_cng_rsn_cd"        ) = sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_cd");
						opener_obj.document.sheet.CellValue2( targetRow , "trsp_sp_cng_rsn_rmk"        ) = sheetObj.CellValue(selectedRowNo , "trsp_sp_cng_rsn_rmk");
						opener_obj.document.sheet.CellValue2( targetRow , "more_candidates_flg"       ) = 'Y';
						 
						 if (opener_obj.document.sheet.CellValue(targetRow, 'po_cfm_flg') == 'N') {			
							 opener_obj.document.sheet.RowFontColor(targetRow) =  opener_obj.document.sheet.RgbColor(163, 73, 164);
						 }else if (opener_obj.document.sheet.CellValue(targetRow, 'po_cfm_flg') == 'Y') {	
							 opener_obj.document.sheet.RowFontColor(targetRow) =  opener_obj.document.sheet.RgbColor(0, 0, 0);
						 }
						 
						 /* Default Service Provicer Flag 처리 - Default S/P --> 'Y', None-default S/O --> 'N' */
						 if(sheetObj.CellValue(selectedRowNo, "seq") == 'Preset')    opener_obj.document.sheet.CellValue2(targetRow, "trsp_dflt_vndr_flg") = 'Y';
						 else                                                        opener_obj.document.sheet.CellValue2(targetRow, "trsp_dflt_vndr_flg") = 'N';
					 }
					window.close();
        			return true;
				 }
        	 }
         }

         if ( rowTotCnt == 0){
        	 ComShowCodeMessage('PRD90013');         //Search result data is empty! << 'PRD90013'
        	 return false;
         }

         if ( chkRowCnt == 0 ){
        	 ComShowCodeMessage('TRS90215');          //Please select at least one row : 20100121 김진 변경
        	 return false;
         }

         return false;
     }

     /**
      * 조회결과에 오류가 발생했을 때 공통처리하는 함수
      * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
      */
     function sheet_OnSearchEnd(sheetObj, errMsg) {
     	var formObj = document.form;
     	
     	sheetObj.CellEditable(2, "trsp_sp_cng_rsn_cd") = false;
     	
     	if( errMsg != '' ) {
     		ComShowMessage(errMsg);
     	}else{
     		for(var i=1; i<=sheetObjects[0].RowCount+1; i++){
    			if (sheetObj.CellValue(i, 'cfm_flg') == 'N') {
    			    sheetObj.RowFontColor(i) =  sheetObj.RgbColor(163, 73, 164);
    			    sheetObj.CellEditable(i, "ibchk"   )    = false;
    			}else if (sheetObj.CellValue(i, 'cfm_flg') == 'Y') {
    				sheetObj.RowFontColor(i) =  sheetObj.RgbColor(0,0,0);
    				sheetObj.CellEditable(i, "ibchk"   )    = true;
    			}
    			
    			if (sheetObj.CellValue(i, 'trsp_agmt_ofc_cty_cd') != '') {
    				sheetObj.CellValue(i, 'agmt_no') = sheetObj.CellValue(i, 'trsp_agmt_ofc_cty_cd') + sheetObj.CellValue(i, 'trsp_agmt_seq');
    			}
     		}
     	}
     }

     function changeSheetRows(){
     	var windowHeight = 0;
     	var calcuRows = 0;
     	sheetObj = sheetObjects[0];

     	if (parseInt(navigator.appVersion)>3) {
     		if (navigator.appName=="Netscape") {
     			windowHeight = window.innerHeight-16;
     		}

     		if (navigator.appName.indexOf("Microsoft")!=-1) {
     			//windowWidth = document.body.offsetWidth-20;
     			windowHeight = document.body.offsetHeight-20;
     		}
     	}
     	if(windowHeight > 350)
     		sheetObj.style.height = windowHeight-187;
      }
     

     function sheet_OnChange(sheetObj, row , col , value) {
    	 if( sheetObj.ColSaveName(col) == "trsp_sp_cng_rsn_cd" ) {
    		 if( sheetObj.CellValue(row, "trsp_sp_cng_rsn_cd")=="O"){ 
    			 sheetObj.CellEditable(row, "trsp_sp_cng_rsn_rmk") = true;
    		 }else{
    			 sheetObj.CellEditable(row, "trsp_sp_cng_rsn_rmk") = false;
    			 sheetObj.CellValue2(row, "trsp_sp_cng_rsn_rmk") = "";
    		 }
    	 }
     }
     
 	function eq_tp_sz_cd_OnChange(comboObj,Index_Code, Text){
 		if (Index_Code == '') {
 			sheetObjects[0].removeAll();
 		}else{
 	 		doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH);
 		}
	}
 	
 	function way_tp_cd_OnChange(comboObj,Index_Code, Text){
 		doActionIBSheet(sheetObjects[0] , document.form , IBSEARCH);
	}
