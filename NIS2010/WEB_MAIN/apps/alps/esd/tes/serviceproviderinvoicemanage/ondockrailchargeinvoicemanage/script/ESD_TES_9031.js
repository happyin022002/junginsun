/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_903_2.js
*@FileTitle : Revised Volume Popup화면-On-Dock Rail Charge Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-14
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2007-03-14 kimjinjoo
* 1.0 최초 생성
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObj = sheetObjects[0];

         var formObj = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_ok":
     	            doActionIBSheet(sheetObj,formObj,IBSAVE);
        	        window.close();
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
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
        
        var formObj = document.form;
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        switch(sheetNo) {
            case 1:      //sheet init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 260;

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
                    InitColumnInfo(19, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.|chk|Cost Code|CNTR No.|TP|F/M|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus     ,     30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq		,     30,    daCenter,  true,    ""      );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_cntr_list_seq"     );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_dtl_seq");
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_rvis_list_seq");

                    InitDataProperty(0, cnt++, dtCheckBox	,     30,    daCenter,  true,    "rvis_ind_flg"             );
                    InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "rvis_lgs_cost_cd"	        ,        true ,          "",       dfNone,    0,     false,       true, 	 6,		true);
                    InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "rvis_cntr_no" 		    ,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_cntr_tpsz_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_cntr_sty_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);

                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_inv_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_cost_grp_cd" 	,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_rvis_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "rvis_bkg_no"      	    ,        false,          "",       dfNone,    0,     false,       true, 	11);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_bkg_no_split"	    ,        false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_vsl_cd"      	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_voy_no"  	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_dir_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_tp_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);

					InitDataValid(0, "rvis_lgs_cost_cd"	, vtEngUpOnly);
					InitDataValid(0, "rvis_cntr_no"		, vtEngUpOther, "0123456789");
					InitDataValid(0, "rvis_bkg_no"		, vtEngUpOther, "0123456789");
               }
               break;
        }
    }


    function doActionIBSheet(sheetObj,formObj,sAction) {//alert("start doActionIBSheet");
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9031GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

//            case IBSEARCH_ASYNC01:	  //조회
//                formObj.f_cmd.value = SEARCH02;
//                var searchXml = sheetObj.GetSearchXml("ESD_TES_903_1GS.do",  FormQueryString(formObj));
//                if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//                break;

            case IBSAVE:
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();

                var param = sheetObj.GetSaveString();
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9031GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = getRVISQty();
        }
    }


    //save는 Auto에서만 실행 
    function sheet_OnSaveEnd(sheetObj){//alert("start sheet_OnSaveEnd");
        window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = getRVISQty();
    }


	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz = document.form.cntr_tpsz_cd.value;
	    var calc_tp = 0;

	    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'rvis_ind_flg') == calc_tp){
	            qty = parseInt(qty) + 1;
	        }
	    }

	    /**
         * UOM이 T(TEU)인 경우 volume 환산
         * return : 환산한 volume
         */
	    if(document.form.vol_tr_ut_cd.value == 'T'){
	        if(cntr_tpsz == 'D4'){
                return parseFloat(qty) * 2;
            }else if(cntr_tpsz == 'D7'){
                return parseFloat(qty) * 2.25;
            }else if(cntr_tpsz == 'D8'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'D9'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'DW'){
                return parseFloat(qty) * 2.65;
            }else if(cntr_tpsz == 'DX'){
                return parseFloat(qty) * 2.25;
            }
	    }
	    return qty;
	}









///*=========================================================
//*Copyright(c) 2006 CyberLogitec
//*@FileName : ESD_TES_9031.js
//*@FileTitle : Revised Volume Popup화면-On-Dock Rail Charge Invoice
//*Open Issues :
//*Change history :
//*@LastModifyDate : 2006-11-23
//*@LastModifier : parkyeonjin
//*@LastVersion : 1.0
//* 2006-11-23 parkyeonjin
//* 1.0 최초 생성
//=========================================================*/
//// 공통전역변수
//
//
//var sheetObjects = new Array();
//var sheetCnt = 0;
//
///* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
//document.onclick = processButtonClick;
//
///* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
//    function processButtonClick(){
//         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
//         /*******************************************************/
//         var sheetObject = sheetObjects[0];
//
//         var formObject = document.form;
//
//    	 try {
//    		var srcName = window.event.srcElement.getAttribute("name");
//
//            switch(srcName) {
//
//         	    case "btng_rowadd":
//         	        addSheetRow(sheetObject, formObject);
//    	            break;
//
//         	    case "btng_save":
//         	    		if (!sheetObject.IsDataModified){
//										ComShowMessage(ComGetMsg('TES21601')); //ComShowMessage('수정된 내역이 없습니다.');
//										return false;
//									}
//    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
//        	        break;
//
//         	    case "btn_ok":
//         	    	 	setParentRvisSheet(sheetObject,formObject,formObject.rvis_vol_qty.value);
//        	        window.close();
//        	        break;
//
//         	    case "btn_close":
//    	            window.close();
//        	        break;
//
//
//            } // end switch
//    	}catch(e) {
//    		if( e == "[object Error]") {
//    			ComShowMessage(ComGetMsg('TES21506')); //ComShowMessage(OBJECT_ERROR);
//    		} else {
//    			ComShowMessage(e);
//    		}
//    	}
//    }
//
//
//    /**
//     * IBSheet Object를 배열로 등록
//     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
//     * 배열은 소스 상단에 정의
//     */
//    function setDocumentObject(sheet_obj){
//
//       sheetObjects[sheetCnt++] = sheet_obj;
//
//
//    }
//
//    /**
//     * Sheet 기본 설정 및 초기화
//     * body 태그의 onLoad 이벤트핸들러 구현
//     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
//     */
//    function loadPage() {
//			 var sheetObject = sheetObjects[0];
//			 var formObject = document.form;
//
//        for(i=0;i<sheetObjects.length;i++){
//
//        //khlee-시작 환경 설정 함수 이름 변경
//            comConfigSheet(sheetObjects[i],SYSTEM_ENIS);
//
//            initSheet(sheetObjects[i],i+1);
//        //khlee-마지막 환경 설정 함수 추가
//            comEndConfigSheet(sheetObjects[i]);
//        }
//				setRivisDivSheet(sheetObject, formObject.rvis_div.value, formObject);
//    }
//
//   /**
//     * 시트 초기설정값, 헤더 정의
//     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
//     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
//     */
//    function initSheet(sheetObj,sheetNo) {
//
//        var cnt = 0;
//
//        switch(sheetNo) {
//             case 1:      //sheet init
//                with (sheetObj) {
//                    // 높이 설정
//                    style.height = 260;
//
//                    //전체 너비 설정
//                    SheetWidth = mainTable.clientWidth;
//
//                    //Host정보 설정[필수][HostIp, Port, PagePath]
//                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//
//                    //전체Merge 종류 [선택, Default msNone]
//                    MergeSheet = msHeaderOnly;
//
//                   //전체Edit 허용 여부 [선택, Default false]
//                    Editable = true;
//
//                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//                    InitRowInfo( 1, 1, 9, 100);
//
//                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//                    InitColumnInfo(12, 0, 0, true);
//
//                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//                    InitHeadMode(true, true, false, true, false, false)
//
//                    var HeadTitle = "STS|Seq.||Cost Code|CNTR No.|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd|vvd_no|click_yn";
//
//                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//                    InitHeadRow(0, HeadTitle, true);
//
//                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
//                    InitDataProperty(0, cnt++, dtSeq			,     30,    daCenter,  true,       ""   );
//                    InitDataProperty(0, cnt++, dtCheckBox	,     30,    daCenter,  true,    "chk"   );
//                    InitDataProperty(0, cnt++, dtData			,     90,    daCenter,  true,    "lgs_cost_cd"	,        true ,          "",       dfNone,    0,     false,       true, 	 6,		true);
//                    InitDataProperty(0, cnt++, dtData			,     90,    daCenter,  true,    "cntr_no" 			,        true ,          "",       dfNone,    0,     false,       true,		14);
//                    InitDataProperty(0, cnt++, dtData			,     90,    daCenter,  true,    "bkg_no"      	,        false,          "",       dfNone,    0,     false,       true, 	11);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "bkg_no_split"	,        false,          "",       dfNone,    0,     false,       false);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "vsl_cd"      	,        false,          "",       dfNone,    0,     false,       false);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "skd_voy_no"  	,        false,          "",       dfNone,    0,     false,       false);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "skd_dir_cd"  	,        false,          "",       dfNone,    0,     false,       false);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "vvd_no"      	,        false,          "",       dfNone,    0,     false,       false);
//                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "click_yn"			,        false,          "",       dfNone,    0,     false,       false);
//
//										InitDataValid(0, "lgs_cost_cd"	, vtEngUpOnly);
//										InitDataValid(0, "cntr_no"			, vtEngUpOther, "0123456789");
//										InitDataValid(0, "bkg_no"				, vtEngUpOther, "0123456789");
//               }
//                break;
//        }
//    }
//
//
//
//  // Sheet관련 프로세스 처리
//    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg = false;
//
//        switch(sAction) {
//
//				   case IBSEARCH:	  //조회
//						/*
//							if(!validateForm(sheetObj,formObj,sAction)) {
//								return false;
//							}
//							*/
//							formObj.f_cmd.value = SEARCH;
//							//ComShowMessage(FormQueryString(formObj));
//				      var searchXml = sheetObj.GetSearchXml("ESD_TES_9031GS.do",  FormQueryString(formObj));
//							sheetObj.RemoveAll();
//							//ComShowMessage(searchXml);
//							if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//						break;
//
//				   case IBSEARCH_ASYNC02:	  //조회
//						/*
//							if(!validateForm(sheetObj,formObj,sAction)) {
//								return false;
//							}
//							*/
//							formObj.f_cmd.value = SEARCH02;
//							//ComShowMessage(FormQueryString(formObj));
//				      var searchXml = sheetObj.GetSearchXml("ESD_TES_903_1GS.do",  FormQueryString(formObj));
//							sheetObj.RemoveAll();
//							//ComShowMessage(searchXml);
//							if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
//						break;
//
//        }
//    }
//
//
//   /**
//     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
//     */
//    function validateForm(sheetObj,formObj,sAction){
//        with(formObj){
////            if (!isNumber(iPage)) {
////
////                return false;
////            }
//        }
//
//        return true;
//    }
//
//	function sheet_OnClick(sheet, row, col){
//		if (sheet.ColSaveName(col) == "chk"){
//			if(sheet.CellValue(row,"click_yn") == "Y")  sheet.CellValue(row,"click_yn") = "N";
//			else 																				sheet.CellValue(row,"click_yn") = "Y";
//		}
//	}
//
//
//
//
//		function setInitSheetCheck(sheetObj,formObj){
//			//ComShowMessage("setInitSheetCheck");
//			var openerObj = window.dialogArguments.document;
//			if(openerObj.costRvisCntr_hidden.RowCount > 0){
//				for(var i= openerObj.costRvisCntr_hidden.HeaderRows; i< openerObj.costRvisCntr_hidden.HeaderRows + openerObj.costRvisCntr_hidden.RowCount; i++){
//					for(var j=sheetObj.HeaderRows; j< sheetObj.HeaderRows + sheetObj.RowCount; j++){
//						if(openerObj.costRvisCntr_hidden.CellValue(i,"rvis_cntr_no"		) == sheetObj.CellValue(j, "cntr_no") &&
//					   openerObj.costRvisCntr_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//					   		sheetObj.CellValue(j, "chk") = true;
//					  }
//					}
//
//				}
//			}
//
//		}
//
//	function addParentRvisSheet(sheetObj,row_num,formObj){
//
//		var openerObj = window.dialogArguments.document;
//		var rvisType				= "TM";
//		if(formObj.tml_inv_tp_cd.value == "ON"){ 					// On-Dock Charge Invoice
//			rvisType					= "ON";
//		}else{																						// Marine Terminal Invoice
//			rvisType					= "TM";
//		}
//		  Row = openerObj.costRvisCntr_hidden.DataInsert(-1);
//
//      openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_page"           		  ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "page"           			 );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_so_ofc_cty_cd"	  ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_ofc_cty_cd"		 );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_so_seq"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_seq"           );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_so_dtl_seq"      ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_dtl_seq"       );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_so_rvis_list_seq") =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_rvis_list_seq" );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_calc_cost_grp_cd"    ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_cost_grp_cd"     );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_lgs_cost_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lgs_cost_cd"          );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_calc_tp_cd"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_tp_cd"           );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_ioc_cd"              ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "ioc_cd"               );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_lane_cd"             ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lane_cd"              );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_io_bnd_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "io_bnd_cd"            );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "cntr_tpsz_cd"         );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_fm_tr_vol_val"       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "fm_tr_vol_val"        );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_to_tr_vol_val"       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "to_tr_vol_val"        );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_vsl_cd"              ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "vsl_cd"               );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_skd_voy_no"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_voy_no"           );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_skd_dir_cd"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_dir_cd"           );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_vvd_no"      	       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "vvd_no"           		);
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_dcgo_clss_cd"      	 ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "dcgo_clss_cd"          );
//			openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_wrk_dt"      				 ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "wrk_dt"       				);
//			openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_wrk_dy_cd"      						 ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_wrk_dy_cd"         					);
//
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_rvis_tp_cd"      ) ="V";
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_tml_inv_tp_cd"       ) =rvisType;
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_cntr_no"             ) =sheetObj.CellValue(row_num, "cntr_no"              );
//	  	//openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_lgs_cost_cd"	     ) =sheetObj.CellValue(row_num, "lgs_cost_cd"	        );
//	  	//openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_cntr_no" 			     ) =sheetObj.CellValue(row_num, "cntr_no" 		          );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_bkg_no"      	      ) =sheetObj.CellValue(row_num, "bkg_no"               );
//	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_bkg_no_split"	      ) =sheetObj.CellValue(row_num, "bkg_no_split"         );
////	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_vsl_cd"      	       ) =sheetObj.CellValue(row_num, "vsl_cd"               );
////	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_skd_voy_no"  	       ) =sheetObj.CellValue(row_num, "skd_voy_no"           );
////	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_skd_dir_cd"  	       ) =sheetObj.CellValue(row_num, "skd_dir_cd"           );
////	  	openerObj.costRvisCntr_hidden.CellValue(Row,"rvis_vvd_no"      	       ) =sheetObj.CellValue(row_num, "vvd_no"               );
//
//
//	}
//
//	function delParentRvisSheet(sheetObj,row_num,formObj){
//		var openerObj = window.dialogArguments.document;
//		for(var i= openerObj.costRvisCntr_hidden.HeaderRows; i< openerObj.costRvisCntr_hidden.HeaderRows + openerObj.costRvisCntr_hidden.RowCount; i++){
//			if(openerObj.costRvisCntr_hidden.CellValue(i,"rvis_cntr_no"		) == sheetObj.CellValue(row_num, "cntr_no") &&
//			   openerObj.costRvisCntr_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
////			   		openerObj.costRvisCntr_hidden.RowDelete(i, false);
////						i--;
//                openerObj.costRvisCntr_hidden.RowStatus(i) = "D";
//			  }
//		}
//	}
//
//
//    function setParentRvisSheet(sheetObj,formObj,volQty){
//    	//ComShowMessage("setParentRvisSheet");
//    	for(var i=sheetObj.HeaderRows; i< sheetObj.HeaderRows + sheetObj.RowCount; i++){
//      	if(sheetObj.CellValue(i,"click_yn") == "Y" ){
//      		if(sheetObj.CellValue(i,"chk")){
//						if(sheetObj.ReadDataProperty(i, 3, dpKeyField) &&
//							 (sheetObj.CellValue(i, "lgs_cost_cd"	) == "" || sheetObj.CellValue(i, "lgs_cost_cd"	) == null)){
//								ComShowMessage(ComGetMsg('TES21602')); //ComShowMessage("[Cost Code]는(은) 필수 입력 항목입니다.");
//							 	return false;
//							}
//						if(sheetObj.ReadDataProperty(sheetObj.LastRow, 4, dpKeyField) &&
//							 (sheetObj.CellValue(sheetObj.LastRow, "cntr_no"	) == "" || sheetObj.CellValue(sheetObj.LastRow, "cntr_no"	) == null)){
//								ComShowMessage(ComGetMsg('TES21603')); //ComShowMessage("[CNTR No.]는(은) 필수 입력 항목입니다.");
//							 	return false;
//							}
//						volQty++;
//						addParentRvisSheet(sheetObj,i,formObj);
//					}else{
//						volQty--;
//						delParentRvisSheet(sheetObj,i,formObj);
//					}
//      	}
//      }
//
//      window.dialogArguments.document.t3sheet1.CellValue(formObj.opener_row.value,"rvis_vol_qty") = volQty;
//
//    }
//
//		function addSheetRow(sheetObj, formObj){
//			if(sheetObj.RowCount>0){
//				if(sheetObj.ReadDataProperty(sheetObj.LastRow, 3, dpKeyField) &&
//					 (sheetObj.CellValue(sheetObj.LastRow, "lgs_cost_cd"	) == "" || sheetObj.CellValue(sheetObj.LastRow, "lgs_cost_cd"	) == null)){
//						ComShowMessage(ComGetMsg('TES21602')); //ComShowMessage("[Cost Code]는(은) 필수 입력 항목입니다.");
//					 	return false;
//					}
//				if(sheetObj.ReadDataProperty(sheetObj.LastRow, 4, dpKeyField) &&
//					 (sheetObj.CellValue(sheetObj.LastRow, "cntr_no"	) == "" || sheetObj.CellValue(sheetObj.LastRow, "cntr_no"	) == null)){
//						ComShowMessage(ComGetMsg('TES21603')); //ComShowMessage("[CNTR No.]는(은) 필수 입력 항목입니다.");
//					 	return false;
//					}
//			}
//			var Row = sheetObj.DataInsert(-1);
//			sheetObj.CellValue(Row, "chk"					) = true;
//			sheetObj.CellValue(Row, "click_yn"		) = "Y";
//			if(Row > 1){
//				sheetObj.CellValue(Row, "lgs_cost_cd"	) = sheetObj.CellValue(Row-1, "lgs_cost_cd"	);
//			}
//
//		}
//
//
//  function setRivisDivSheet(sheetObj, divValue, formObj){
//			var openerObj = window.dialogArguments.document;
//			var compareStr  = "";
//			/*
//			 * 'N'인 경우 : Revised Pop-up에 Container List를 제공하지 않고 사용자가 Pop-up창에서 직접 입력
//			 *              Revised Container List에 기존에 추가된 Contaner만 보여줌.
//			 */
//			if(divValue == "N"){
//					for(var i= openerObj.costRvisCntr_hidden.HeaderRows; i< openerObj.costRvisCntr_hidden.HeaderRows + openerObj.costRvisCntr_hidden.RowCount; i++){
//						if(openerObj.costRvisCntr_hidden.CellValue(i,"rvis_vsl_cd"		) == formObj.vvd_no.value.substring(0,4) &&
//							 openerObj.costRvisCntr_hidden.CellValue(i,"rvis_skd_voy_no") == formObj.vvd_no.value.substring(4,8) &&
//							 openerObj.costRvisCntr_hidden.CellValue(i,"rvis_skd_dir_cd") == formObj.vvd_no.value.substring(8,9) &&
//							 openerObj.costRvisCntr_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//									var Row = sheetObj.DataInsert(-1);
//									sheetObj.CellValue(Row, "cntr_no"     ) = openerObj.costRvisCntr_hidden.CellValue(i,"rvis_cntr_no");
//									sheetObj.CellValue(Row, "chk"					) = true;
//									sheetObj.CellValue(Row, "click_yn"		) = "Y";
//					  }
//					}
//			 }
//			/*
//			 * 'MT'인 경우 : Auto Calc에서 계산된 Cost Code중 SUBSTR(:COST_CODE,1,4)||'MT'의 해당 Cost Code의 Container List를 List up하되
//			 * 							 Auto Calc의 Revised Volume에서 Check된 Container를 제외한 나머지 부분의 Check Box에 Select Check하여 List Up
//			 */
//			else if(divValue == "MT"){
//				  var orgCostCode = formObj.lgs_cost_cd.value;
//					formObj.lgs_cost_cd.value = formObj.lgs_cost_cd.value.substring(0,4)+"MT";
//					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02);
//					for(var i= sheetObj.HeaderRows; i< sheetObj.HeaderRows + sheetObj.RowCount; i++){
//						if(openerObj.costRvisCntr_hidden.RowCount > 0){
//							for(var j= openerObj.costRvisCntr_hidden.HeaderRows; j< openerObj.costRvisCntr_hidden.HeaderRows + openerObj.costRvisCntr_hidden.RowCount; j++){
//								if(openerObj.costRvisCntr_hidden.CellValue(j,"rvis_vsl_cd"		) == formObj.vvd_no.value.substring(0,4) &&
//									 openerObj.costRvisCntr_hidden.CellValue(j,"rvis_skd_voy_no") == formObj.vvd_no.value.substring(4,8) &&
//									 openerObj.costRvisCntr_hidden.CellValue(j,"rvis_skd_dir_cd") == formObj.vvd_no.value.substring(8,9) &&
//									 openerObj.costRvisCntr_hidden.CellValue(j,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value							 &&
//									 openerObj.costRvisCntr_hidden.CellValue(j,"rvis_cntr_no"		) == sheetObj.CellValue(i, "cntr_no" ) ){
//											sheetObj.CellValue(i, "chk"					) = false;
//							  }else{
//										sheetObj.CellValue(i, "chk"					) = true;
//										sheetObj.CellValue(i, "click_yn"		) = "Y";
//							  }
//							}
//						}else{
//							sheetObj.CellValue(i, "chk"					) = true;
//							sheetObj.CellValue(i, "click_yn"		) = "Y";
//						}
//					}
//					formObj.lgs_cost_cd.value = orgCostCode;
//			}
//			/*
//			 * 'DG'인 경우 : Coi의 'DG'가 'N'이 아닌 모든 Container List를 Check Box에 Select Check하여 List Up
//			 */
//			 else if(divValue == "DG"){
//					for(var i= openerObj.containerlist_hidden.HeaderRows; i< openerObj.containerlist_hidden.HeaderRows + openerObj.containerlist_hidden.RowCount; i++){
//						if(openerObj.containerlist_hidden.CellValue(i,"vvd_no") == formObj.vvd_no.value &&
//							 openerObj.containerlist_hidden.CellValue(i,"dcgo_clss_cd") != "N"){
//									var Row = sheetObj.DataInsert(-1);
//									sheetObj.CellValue(Row, "cntr_no"     ) = openerObj.containerlist_hidden.CellValue(i,"cntr_no");
//									sheetObj.CellValue(Row, "chk"					) = true;
//									sheetObj.CellValue(Row, "click_yn"		) = "Y";
//					  }
//					}
//			 }
//			/*
//			 * 'RF'인 경우 : Coi의 'RF'가 'N'이 아닌 모든 Container List를 Check Box에 Select Check하여 List Up
//			 */
//			else if(divValue == "RF"){
//					for(var i= openerObj.containerlist_hidden.HeaderRows; i< openerObj.containerlist_hidden.HeaderRows + openerObj.containerlist_hidden.RowCount; i++){
//						if(openerObj.containerlist_hidden.CellValue(i,"vvd_no") == formObj.vvd_no.value &&
//							 openerObj.containerlist_hidden.CellValue(i,"rc_flg") != "N"){
//									var Row = sheetObj.DataInsert(-1);
//									sheetObj.CellValue(Row, "cntr_no"     ) = openerObj.containerlist_hidden.CellValue(i,"cntr_no");
//									sheetObj.CellValue(Row, "chk"					) = true;
//									sheetObj.CellValue(Row, "click_yn"		) = "Y";
//					  }
//					}
//			}
//			/*
//			 * 'AK'인 경우 : Coi의 'AK'가 'N'이 아닌 모든 Container List를 Check Box에 Select Check하여 List Up
//			 */
//			else if(divValue == "AK"){
//					for(var i= openerObj.containerlist_hidden.HeaderRows; i< openerObj.containerlist_hidden.HeaderRows + openerObj.containerlist_hidden.RowCount; i++){
//						if(openerObj.containerlist_hidden.CellValue(i,"vvd_no") == formObj.vvd_no.value &&
//							 openerObj.containerlist_hidden.CellValue(i,"awk_cgo_flg") != "N"){
//									var Row = sheetObj.DataInsert(-1);
//									sheetObj.CellValue(Row, "cntr_no"     ) = openerObj.containerlist_hidden.CellValue(i,"cntr_no");
//									sheetObj.CellValue(Row, "chk"					) = true;
//									sheetObj.CellValue(Row, "click_yn"		) = "Y";
//					  }
//					}
//			}else{
//				doActionIBSheet(sheetObj,formObj,IBSEARCH);
//				setInitSheetCheck(sheetObj,formObj);
//			}
//
//		}
