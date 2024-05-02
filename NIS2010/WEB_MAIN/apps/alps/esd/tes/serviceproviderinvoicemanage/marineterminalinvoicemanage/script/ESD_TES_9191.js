/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9191.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 1.0 최초 생성
* 2015-04-09 김영신 [CHM-201534988] EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

var EDI_init_rtrv_cnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];

         var formObject = document.form;

    	 try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

         	    case "btng_rowadd":
    	            var Row = sheetObject.DataInsert(-1);
        	        break;

         	    case "btn_ok":
         	    	 	setParentRvisSheet(sheetObject,formObject,formObject.rh_vol_qty.value);
        	        window.close();
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object
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
			 var sheetObject = sheetObjects[0];
			 var formObject = document.form;

        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
// 			setInitSheetCheck(sheetObject,formObject);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheet_obj) sheet object
     * @param(sheetNo) sheet number
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
                    InitColumnInfo(9, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false)

                    var HeadTitle = "STS||Seq.|CNTR No.|Caused CNTR|Reason Code";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,     	30,    daCenter,  true,    "rvis_ind_flg"   );
                    InitDataProperty(0, cnt++, dtSeq		,       30,    daCenter,  true,    ""   							,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cntr_no"					,        false,          "",       dfNone,    0,     true,       true);

                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cuz_cntr_no"	,        false,          "",       dfNone,    0,     true ,       true );
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_rhnd_rsn_cd"			,        false,          "",       dfNone,    0,     true ,       true );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_dtl_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_rvis_list_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_lgs_cost_cd"			,        false,          "",       dfNone,    0,     false ,       false );

                    
               }
                break;
        }
    }



  /** Sheet관련 프로세스 처리
   *  @param(sheet_obj) sheet object
   *  @param(formObj) formObj object
   *  @param(sAction) action 값
   */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9191GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;
                
            case IBSEARCH_ASYNC01:	  //[CHM-201534988]EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F 2015-04-09
	            formObj.f_cmd.value = SEARCH01;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9190GS.do",  tesFrmQryStr(formObj));
	            sheetObj.LoadSearchXml(searchXml,true);
	            break; 
        }
    }



    /** Manual RVIS의 경우,, Popup창에서 OK버튼을 눌러도 바로DB에 반영되지는 않는다.
     * opener의 rvis hidden sheet에만 관련 data가 저장되어 있기 때문에
     * popup화면 재 open시,, 유저의 작업내용을 다시 보여주기 위해, openr의 hidden sheet를
     */
//    function sheet_OnSearchEnd(sheetObj){
//        var openerObj = window.dialogArguments.document.rvis_hidden;
//        var formObj = document.form;
//         for(var i= openerObj.HeaderRows; i< openerObj.HeaderRows + openerObj.RowCount; i++){
//	        if(openerObj.CellValue(i,"rvis_vsl_cd")        == formObj.vvd.value.substring(0,4)
//	           && openerObj.CellValue(i,"rvis_skd_voy_no") == formObj.vvd.value.substring(4,8)
//	           && openerObj.CellValue(i,"rvis_skd_dir_cd") == formObj.vvd.value.substring(8,9)
//	           && openerObj.CellValue(i,"rvis_lgs_cost_cd")== formObj.lgs_cost_cd.value
//	           && openerObj.RowStatus(i)=='I')
//	        {
//	            if(sheetObj.FindText('cntr_no', openerObj.CellValue(i,'rvis_cntr_no')) > 0){
//	                Row = sheetObj.FindText('cntr_no', openerObj.CellValue(i,'rvis_cntr_no'));
//	            }else{
//	                var Row = sheetObj.DataInsert(-1);
//	            }
//	            sheetObj.CellValue(Row,"tml_so_dtl_seq"      ) = openerObj.CellValue(i, "rvis_tml_so_dtl_seq"       );
//        	  	sheetObj.CellValue(Row,"tml_so_rvis_list_seq") = openerObj.CellValue(i, "rvis_tml_so_rvis_list_seq" );
//        	  	sheetObj.CellValue(Row,"lgs_cost_cd"         ) = openerObj.CellValue(i, "rvis_lgs_cost_cd"          );
//        	  	sheetObj.CellValue(Row,"cntr_no"             ) = openerObj.CellValue(i, "rvis_cntr_no"              );
//        	  	sheetObj.CellValue(Row,"rvis_ind_flg"        ) = openerObj.CellValue(i, "rvis_ind_flg"              );
//        	  	sheetObj.CellValue(Row,"rhnd_rsn_cd"         ) = openerObj.CellValue(i, "rvis_rhnd_rsn_cd"          );
//        	  	sheetObj.CellValue(Row,"rhnd_rsn_cntr_no"    ) = openerObj.CellValue(i, "rvis_cuz_cntr_no"          );
//        	  	sheetObj.CellValue(Row,"rvis_ind_flg"    ) = openerObj.CellValue(i, "rvis_ind_flg"          );
//	        }
//	    }
//
//    }

   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     * @param(sheetObj) sheet object
     * @param(formObj) form object
     * @param(sAction) sAction
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


//	function sheet_OnClick(sheet, row, col){
//		if (sheet.ColSaveName(col) == "chk"){
//			if(sheet.CellValue(row,"click_yn") == "Y")  sheet.CellValue(row,"click_yn") = "N";
//			else 																				sheet.CellValue(row,"click_yn") = "Y";
//		}
//	}

//	function setInitSheetCheck(sheetObj,formObj){
//		var openerObj = window.dialogArguments.document;
//		if(openerObj.rvis_hidden.RowCount > 0){
//			for(var i= openerObj.rvis_hidden.HeaderRows; i< openerObj.rvis_hidden.HeaderRows + openerObj.rvis_hidden.RowCount; i++){
//				for(var j=sheetObj.HeaderRows; j< sheetObj.HeaderRows + sheetObj.RowCount; j++){
//					if(openerObj.rvis_hidden.CellValue(i,"rvis_cntr_no") == sheetObj.CellValue(j, "cntr_no") &&
//				   openerObj.rvis_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//				   		sheetObj.CellValue(j, "chk") = true;
//				  }
//				}
//
//			}
//		}
//
//	}

//	function addParentRvisSheet(sheetObj,row_num,formObj){
//		var openerObj = window.dialogArguments.document;
//		  Row = window.dialogArguments.document.rvis_hidden.DataInsert(-1);
//
//      openerObj.rvis_hidden.CellValue(Row,"rvis_page"           			 			) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "page"           			);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_ofc_cty_cd"		) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_ofc_cty_cd"		);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_seq"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_seq"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_dtl_seq"       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_dtl_seq"       );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_rvis_list_seq" ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_rvis_list_seq" );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_cost_grp_cd"     ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_cost_grp_cd"     );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lgs_cost_cd"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lgs_cost_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_vsl_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "vsl_cd"               );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_voy_no"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_voy_no"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_dir_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_dir_cd"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_tp_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_tp_cd"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_ioc_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "ioc_cd"               );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lane_cd"              ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lane_cd"              );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_io_bnd_cd"            ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "io_bnd_cd"            );
////	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "cntr_tpsz_cd"         );
//	  	openerObj.rvis_hidden.CellValue(Row,"n3rd_dcgo_clss_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "dcgo_clss_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"n3rd_tml_wrk_dy_cd"         					) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_wrk_dy_cd"         					 );
//			openerObj.rvis_hidden.CellValue(Row,"rvis_wrk_dt"      				  ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "wrk_dt"       				);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_fm_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "fm_tr_vol_val"        );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_to_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "to_tr_vol_val"        );
//
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_rvis_tp_cd"       ) ="H";
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_inv_tp_cd"        ) ="TM";
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_no"              ) =sheetObj.CellValue(row_num, "cntr_no"              );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cuz_cntr_no"          ) =sheetObj.CellValue(row_num, "cuz_cntr_no"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_rhnd_rsn_cd"          ) =sheetObj.CellValue(row_num, "rhnd_rsn_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"          ) =sheetObj.CellValue(row_num, "cntr_tpsz_cd"          );
//
//	}

//	function delParentRvisSheet(sheetObj,row_num,formObj){
//		var openerObj = window.dialogArguments.document;
//		for(var i= openerObj.rvis_hidden.HeaderRows; i< openerObj.rvis_hidden.HeaderRows + openerObj.rvis_hidden.RowCount; i++){
//			if(openerObj.rvis_hidden.CellValue(i,"rvis_cntr_no"		 ) == sheetObj.CellValue(row_num, "cntr_no") &&
//			   openerObj.rvis_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//			   		openerObj.rvis_hidden.RowDelete(i, false);
//						i--;
//			  }
//		}
//	}


//    function setParentRvisSheet(sheetObj,formObj,volQty){
//    	//ComShowMessage("setParentRvisSheet");
//    	for(var i=sheetObj.HeaderRows; i< sheetObj.HeaderRows + sheetObj.RowCount; i++){
//      	if(sheetObj.CellValue(i,"click_yn") == "Y" ){
//      		if(sheetObj.CellValue(i,"chk")){
//						volQty++;
//						addParentRvisSheet(sheetObj,i,formObj);
//					}else{
//						volQty--;
//						delParentRvisSheet(sheetObj,i,formObj);
//					 }
//      	}
//      }
//      window.dialogArguments.document.t3sheet1.CellValue(formObj.opener_row.value,"rvis_vol_qty") = volQty;
//
//    }



	/**
	 *  팝업창을 오픈한 부모값에 값을 전달함
	 */
    function setParentRvisSheet(){
        var sheetObj = sheetObjects[0];
        var openerObj = window.dialogArguments.document.rvis_hidden;
        var openerDtlObj =  window.dialogArguments.document.t3sheet1;
        var opener_row = document.form.opener_row.value;
        var Row

        for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
            if(sheetObj.CellValue(i,'rvis_ind_flg') == 1){
                if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.CellValue(i,'lgs_cost_cd'))<0
                    || openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'))<0)
                {
                    Row = openerObj.DataInsert(-1);
                    copy2Opener(Row, i);
                    if(sheetObj.CellValue(i,'tml_so_dtl_seq')>0 && sheetObj.CellValue(i,'tml_so_rvis_list_seq')>0){
                        openerObj.RowStatus(Row) = 'U';
                    }
                    openerDtlObj.RowStatus(opener_row) = getOpenerRowStatus();
                }else{
                    if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.CellValue(i,'lgs_cost_cd'))>0 && openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'))){
                        Row = openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'));
                        copy2Opener(Row, i);
                        if(sheetObj.CellValue(i,'tml_so_dtl_seq')>0 && sheetObj.CellValue(i,'tml_so_rvis_list_seq')>0){
                            openerObj.RowStatus(Row) = 'U';
                        }
                        openerDtlObj.RowStatus(opener_row) = getOpenerRowStatus();
                    }
                }

            }else if(sheetObj.CellValue(i,'rvis_ind_flg') == 0){
                if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.CellValue(i,'lgs_cost_cd'))>0
                    && openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'))>0)
                {
                    if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.CellValue(i,'lgs_cost_cd'))>0 && openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'))){
                        Row = openerObj.FindText('rvis_cntr_no', sheetObj.CellValue(i,'cntr_no'));
                        delParentRvisSheet(Row);
                        openerDtlObj.RowStatus(opener_row) = getOpenerRowStatus();
                    }
                }else{
                     if(sheetObj.CellValue(i,'tml_so_dtl_seq')>0 && sheetObj.CellValue(i,'tml_so_rvis_list_seq')>0){
                         Row = openerObj.DataInsert(-1);
                         copy2Opener(Row, i);

                         //이미 RVIS 테이블에저장된 상태인 데이타의 경우 삭제하기 위해,
                         // 1. data를 opener 의 RVIS Hidden sheet에 카피,
                         // 2. Rowstatus를 D로 변경한다.
                         //IBSheet는 Ins 상태의 RowStatus를 'D'로 바꿔주면 Sheet상에서 Data가 사라진다.
                         //캐!!! 꽁수로,, Row Status를 'R'로 만들었다가 다시 'D'로 변경시킴 -_-ㅋ
                         openerObj.RowStatus(Row) = 'R';
                         openerObj.RowStatus(Row) = 'D';
                         openerDtlObj.RowStatus(opener_row) = getOpenerRowStatus();
                    }
                }
            }
        }
        openerDtlObj.CellValue(opener_row,'rvis_vol_qty') = getRVISQty();
    }

    /**
     * Cost Calculation탭에서 Open한 Row의 Status에 따라
     * Revised Vol에서 작업한 내용을 Save 해 줄수 있도록 Setting 할
     * Opener Row의 Status를 return
     */
    function getOpenerRowStatus(){
        var openerDtlObj =  window.dialogArguments.document.t3sheet1;
        var opener_row = document.form.opener_row.value;
        var org_status = openerDtlObj.RowStatus(opener_row);

        if(org_status == 'I'){
            return 'I';
        }else if(org_status == 'U' || org_status == 'R' || org_status == 'D'){
            return 'U';
        }
    }

    /**
     * qty 값을 가져온다.
     * @return
     */ 
    function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz =window.dialogArguments.document.t3sheet1.CellValue( document.form.opener_row.value, "cntr_tpsz_cd");
//	    var calc_tp = 0;
//	    if(document.form.calc_tp_cd.value == 'A'){
//	        calc_tp = 0
//	    }else if(document.form.calc_tp_cd.value == 'M'){
//	        calc_tp = 1;
//	    }

	    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'rvis_ind_flg') == 1){
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
            }else{
                return qty;
            }
	    }
	    return qty;
	}

    /**
     * 팝업창시트에 있는 값들을 히든셀에 담는다.
     * @param Row
     * @param row
     * @return
     */
    function copy2Opener(Row, row){
	    var openerObj = window.dialogArguments.document;
		var sheetObj = sheetObjects[0];
		var formObj = document.form;

	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_dtl_seq"       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_dtl_seq"       );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_rvis_list_seq" ) =sheetObj.CellValue(row,"tml_so_rvis_list_seq");
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_cost_grp_cd"     ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_cost_grp_cd"     );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lgs_cost_cd"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lgs_cost_cd"          );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_vsl_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "vsl_cd"               );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_voy_no"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_voy_no"           );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_dir_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_dir_cd"           );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_tp_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_tp_cd"           );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_ioc_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "ioc_cd"               );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lane_cd"              ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lane_cd"              );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_io_bnd_cd"            ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "io_bnd_cd"            );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_dcgo_clss_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "dcgo_ind_cd"          );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_wrk_dy_cd"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_wrk_dy_cd"		 );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_trns_mod_cd"      ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_trns_mod_cd"		 );
		openerObj.rvis_hidden.CellValue(Row,"rvis_wrk_dt"      			) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "wrk_dt"        		 );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_fm_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "fm_tr_vol_val"        );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_to_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "to_tr_vol_val"        );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "cntr_tpsz_cd"         );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_rc_flg"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "rc_flg"               );

	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_rvis_tp_cd"       ) ="H";
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_inv_tp_cd"        ) ="TM";
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_no"              ) =sheetObj.CellValue(row, "cntr_no"              );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cuz_cntr_no"          ) =sheetObj.CellValue(row, "rhnd_rsn_cntr_no"          );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_rhnd_rsn_cd"          ) =sheetObj.CellValue(row, "rhnd_rsn_cd"          );
	  	openerObj.rvis_hidden.CellValue(Row,"rvis_ind_flg"         ) =sheetObj.CellValue(row, "rvis_ind_flg"         );
	}

    /**
     * revise sheet 값을 삭제하는
     * @param Row 시트에 상태값
     * @return
     */
	function delParentRvisSheet(Row){
		var openerObj = window.dialogArguments.document.rvis_hidden;
		if(openerObj.RowStatus(Row) == 'U'){
		    openerObj.RowStatus(Row) = 'D';
		}else if(openerObj.RowStatus(Row) == 'I'){
		    openerObj.RowDelete(Row,false);
		}
	}
	
	function sheet_OnSearchEnd(sheetObj){     
    	if (sheetObj.RowCount == 0) {
    		/**
     		 * [CHM-201534988]EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F 
     		 * 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.                            
     		 */  
	        if (window.dialogArguments.document.form.edi_flg.value == 'Y' && EDI_init_rtrv_cnt == 0){
	        	EDI_init_rtrv_cnt++; // 반드시 EDI 기본 조회 바로 전에 증가해야 한다.
	        	doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC01);
	        }
    	}
    }









