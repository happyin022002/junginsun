/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9033.js
*@FileTitle : Revised Volume Popup화면-On-Dock Rail Charge Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-14
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2007-03-14 kimjinjoo
* 1.0 최초 생성
* 2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.
* 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
* 2011.11.21 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완(수정)
* 2011.11.23 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var err_flag = false;

var EDI_init_rtrv_cnt = 0;

var comboObjects = new Array();
var comboCnt = 0 ;	

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

         	    case "btng_rowadd":
					var lvcnt = 0;
	    			var lvrow = sheetObj.RowCount;
	    			if( !isNaN(formObj.row_count.value) ) {
	    				lvcnt = eval(formObj.row_count.value);
	    				if( !donumberheck(lvcnt) ) {
	    					for(i=lvrow; i < lvcnt+lvrow; i++){
	    						var Row = sheetObj.DataInsert(i);
	    						sheetObj.CellValue(Row, "rvis_ind_flg") = 0;
	    	         	        sheetObj.CellValue(Row, "rvis_lgs_cost_cd") = formObj.lgs_cost_cd.value;
	    	         	        sheetObj.CellValue(Row, "rvis_vsl_cd") = formObj.vvd.value.substring(0,4);
	    	         	        sheetObj.CellValue(Row, "rvis_skd_voy_no") = formObj.vvd.value.substring(4,8);
	    	         	        sheetObj.CellValue(Row, "rvis_skd_dir_cd") = formObj.vvd.value.substring(8,9);
	    	         	        sheetObj.CellValue(Row, "rvis_cntr_sty_cd") = formObj.cntr_sty_cd.value;
	    	         	        sheetObj.CellValue(Row, "rvis_tml_inv_tp_cd") = 'TM';
	    	         	        sheetObj.CellValue(Row, "rvis_calc_cost_grp_cd") = 'TM';
	    	         	        sheetObj.CellValue(Row, "rvis_tml_rvis_tp_cd") = 'V';
	    	         	        sheetObj.CellValue(Row, "rvis_calc_tp_cd") = 'M';
	    	         	        sheetObj.CellValue(Row, "rvis_page_rows") = formObj.page_rows.value;
	    						sheetObj.RowStatus(Row) = "I";
	    						sheetObj.CellEditable(Row, "rvis_lgs_cost_cd") = false;
	    						sheetObj.CellEditable(Row, "rvis_cntr_no") = true;
	    						sheetObj.CellEditable(Row, "rvis_bkg_no") = true;
	    					}
	    				} else {
	    					var Row = sheetObj.DataInsert(-1);
	    					sheetObj.CellValue(Row, "rvis_ind_flg") = 0;
	             	        sheetObj.CellValue(Row, "rvis_lgs_cost_cd") = formObj.lgs_cost_cd.value;
	             	        sheetObj.CellValue(Row, "rvis_vsl_cd") = formObj.vvd.value.substring(0,4);
	             	        sheetObj.CellValue(Row, "rvis_skd_voy_no") = formObj.vvd.value.substring(4,8);
	             	        sheetObj.CellValue(Row, "rvis_skd_dir_cd") = formObj.vvd.value.substring(8,9);
	             	        sheetObj.CellValue(Row, "rvis_cntr_sty_cd") = formObj.cntr_sty_cd.value;
	             	        sheetObj.CellValue(Row, "rvis_tml_inv_tp_cd") = 'TM';
	             	        sheetObj.CellValue(Row, "rvis_calc_cost_grp_cd") = 'TM';
	             	        sheetObj.CellValue(Row, "rvis_tml_rvis_tp_cd") = 'V';
	             	        sheetObj.CellValue(Row, "rvis_calc_tp_cd") = 'M';
	             	        sheetObj.CellValue(Row, "rvis_page_rows") = formObj.page_rows.value;
	    					sheetObj.RowStatus(Row) = "I";
	    					sheetObj.CellEditable(Row, "rvis_lgs_cost_cd") = false;
	    					sheetObj.CellEditable(Row, "rvis_cntr_no") = true;
	    					sheetObj.CellEditable(Row, "rvis_bkg_no") = true;
	    				}
	    			} else {
	    				formObj.row_count.value = "1";
	    			}
	    			
	    			
	    			break;
	    			
        	    case "btn_ok":
//         	        if (!sheetObj.IsDataModified){
//         	            ComShowCodeMessage('TES21601'); //ComShowMessage('수정된 내역이 없습니다.');
//         	            return false;
//         	        }

//					if(!chkDupRow(sheetObj)){
//						return false;
//					}
					for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i,"ibflag")!='D'){
							if(sheetObj.CellValue(i,"eff_cntr_yn")=='N'){
								sheetObj.CellFontColor(i, "rvis_cntr_no") = sheetObj.RgbColor(255, 0, 0);
								err_flag = true;
							}
							if(err_flag == true){
								alert('Wrong TPSZ');
								err_flag = false;
								return false;
							}
							
							// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 양양선B 요청)
							if ( formObj.cntr_tpsz_cd.value != sheetObj.CellValue(i, "rvis_cntr_tpsz_cd") ) {
								ComShowMessage(ComGetMsg('TES21609'));	// Unmatched TpSz.
								return false;
							}
						}
					}
					if(err_flag == false){
						if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value =='A'){
							doActionIBSheet(sheetObj,formObj,IBSAVE);
	         	        }else{
	         	        	//setParentRvisSheet();
							doActionIBSheet(sheetObj,formObj,IBINSERT);
	         	        }
	         	        if(err_flag == false){
	         	            window.close();
	         	        }
					} 
					
        	        break;

         	    case "btn_close":
    	            window.close();
        	        break;
        	        
         	    case "btn_rowdel":
					doActionIBSheet(sheetObj,formObj,IBDELETE);
        	        break;

           	    // CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 양양선B 요청)
         	    case "btn_apply":
         	    	// param_rvis_cntr_tpsz_cd 에 공백 선택이 되어있으면 Code 초기화시킴.
         	    	var		arrStr	= formObj.param_rvis_cntr_tpsz_cd.Code.split(",");
					for (var i = 0; i < arrStr.length; i++ ) {
						if ( arrStr[i] == "" ) {
							formObj.param_rvis_cntr_tpsz_cd.Code = "";
							break;
						}
					}

					doActionIBSheet(sheetObj, formObj, IBSEARCH_ASYNC03);
         	    	break;
         	    	

            } // end switch

    	} catch(e) {
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
        
		if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value =='A'){
			//자동MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		// CHM-201432522 [TES] Semi-auto calculation시 Revised Vol에  입력된 컨테이너 Save ( 4347-11-14 양양선B 요청)
		// Semi-auto calculation 인 경우 조건 누락으로 추가함.
		} else if ( formObj.calc_tp_cd.value != undefined && formObj.calc_tp_cd.value != null && ( formObj.calc_tp_cd.value == 'M' || formObj.calc_tp_cd.value == 'S' ) ) {
			// CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 양양선B 요청)
			tes_getComboItem('param_rvis_cntr_tpsz_cd', 1, SEARCH13, '');

			//수동MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
		}
    }

	/**
	 * Combo 기본 설정
	 * Combo의 항목을 설정한다.
	 * @param(comboObjl) 	combo object
	 * @param(comboNo) 		combo number
	 * @param(combo_val) 	combo value
	 * @param(def_val) 		def value
	 */
	function initCombo (comboObj, comboNo, combo_val, def_val) {
		var cnt  = 0 ;
		
		switch(comboNo) {

			case 1:   //nod_cd
				with (comboObj) {
					SetColAlign('left');
					SetColWidth('45');
					MultiSelect = true;
					DropHeight=150;

					var tmp = '';
					cnt	= 0;
					if (combo_val != null) {
						tmp = combo_val.split('|');
						InsertItem(0, '', '');  // 전체 조회 추가
						cnt++;
					}
					for (var i = 0; tmp != null && i < tmp.length; i++) {
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val != undefined && def_val != null && def_val.trim() != '') {
						Code = def_val;
					} else {
						Code = '';
					}
				}
			break;
		}
	}

	/**
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 * @param(combo_obj) como object
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++] = combo_obj;
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
                    InitColumnInfo(25, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle = "STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.|Chk.|Del.|Cost Code|CNTR No.|TPSZ|TP|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|Plug In|Plug Out|Plug Term|vsl_cd|skd_voy_no|skd_dir_cd|calc_tp|page_rows|cntr_yn";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus     ,     30,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq		,     30,    daCenter,  true,    ""      );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_cntr_list_seq"     );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_dtl_seq");
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_rvis_list_seq");

                    InitDataProperty(0, cnt++, dtHidden		,     50,    daCenter,  false,   "chk");
                    InitDataProperty(0, cnt++, dtCheckBox	,     30,    daCenter,  true,    "rvis_ind_flg"             );
                    InitDataProperty(0, cnt++, dtData		,     75,    daCenter,  true,    "rvis_lgs_cost_cd"	        ,        true ,          "",       dfNone,    0,     false,       true, 	 6,		true);
                    InitDataProperty(0, cnt++, dtData		,     90,    daCenter,  true,    "rvis_cntr_no" 		    ,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtData		,     40,    daCenter,  true,    "rvis_cntr_tpsz_cd" 		,        false,          "",       dfNone,    0,     false,       true,		14);
                    
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_cntr_sty_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_inv_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_cost_grp_cd" 	,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_rvis_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtData		,     100,   daCenter,  true,    "rvis_bkg_no"      	    ,        false,          "",       dfNone,    0,     false,       true, 	13);                    

                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_bkg_no_split"	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     110,   daCenter,  true,    "rvis_plug_in"      	    ,        false,          "",       dfNone,    0,     false,       true, 	20);
                    InitDataProperty(0, cnt++, dtHidden		,     110,   daCenter,  true,    "rvis_plug_out"      	    ,        false,          "",       dfNone,    0,     false,       true, 	20);
                    InitDataProperty(0, cnt++, dtData		,     70,    daCenter,  true,    "rvis_plug_term"      	    ,        false,          "",       dfNone,    0,     false,       true, 	11);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_vsl_cd"      	    ,        false,          "",       dfNone,    0,     false,       false);

                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_voy_no"  	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_dir_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_tp_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_page_rows"  	        ,        false,          "",      dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtHidden		,     40,    daCenter,  true,    "eff_cntr_yn" 				,        false,          "",       dfNone,    0,     false,       true,		14);
                    
					InitDataValid(0, "rvis_lgs_cost_cd"	, vtEngUpOnly);
					InitDataValid(0, "rvis_cntr_no"		, vtEngUpOther, "0123456789");
					InitDataValid(0, "rvis_bkg_no"		, vtEngUpOther, "0123456789");
               }
               break;
        }
    }


    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9033GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSEARCH_ASYNC01:	  //조회
	            formObj.f_cmd.value = SEARCH02;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9033GS.do",  tesFrmQryStr(formObj));
	            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
	            break;
            
            case IBSEARCH_ASYNC02:	  // 2009-08-27 [PJM-200900072] : EDI manual cntr조회
	            formObj.f_cmd.value = SEARCH03;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9033GS.do",  tesFrmQryStr(formObj));
	            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
	            break;

            case IBSEARCH_ASYNC03:	  // CHM-201534707 TES Manual cost code인 경우 Get Coincidence container기능 추가 (4348-03-30 양양선B 요청)
            	formObj.f_cmd.value = SEARCH02;
                sheetObj.RemoveAll();
            	var searchXml = sheetObj.GetSearchXml("ESD_TES_9033GS.do", tesFrmQryStr(formObj));
            	if (searchXml != "") sheetObj.LoadSearchXml(searchXml, true);
            	break;
                
            case IBSAVE:
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();
                formObj.rf_mntr_dys.value = getRfMntrDys();
                var param = sheetObj.GetSaveString(false, false);
                
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9033GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
            	window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'plug_term') = formObj.rf_mntr_dys.value;

                break;

            case IBINSERT:
                for(var i=sheetObjects[0].HeaderRows ; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
			        sheetObjects[0].RowFontColor(i) = sheetObjects[0].RgbColor(0, 0, 0);
		        }

                err_flag = false;
                var Rows;
		        Rows = sheetObj.ColValueDupRows("rvis_cntr_no",false);
		        var arr_rows = Rows.split(',');
		        for (var i=0; arr_rows!='' && i<arr_rows.length; i++){
		        	sheetObj.RowFontColor(arr_rows[i]) = sheetObj.RgbColor(255, 0, 0);
			        err_flag = true;
			       // sheetObj.CellValue(arr_rows[i],"remark") = 'Duplicate';
		        }
	            if(err_flag == true){
	            	ComShowMessage("Please check the column in red.");
	                return false;
	            }
                formObj.f_cmd.value = MODIFY02;
                formObj.rvis_vol_qty.value = getRVISQty();
                formObj.rf_mntr_dys.value = getRfMntrDys();
                
            	window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'plug_term') = formObj.rf_mntr_dys.value;
            	
                var param = sheetObj.GetSaveString();
				var saveXml = sheetObj.GetSaveXml("ESD_TES_9033GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                break;
                
            case IBDELETE:
            	if (sheetObj.RowCount > 0){
            		var chkRow = sheetObj.FindCheckedRow ("chk");
         	    	var Row = chkRow.split("|");
         	    	if (chkRow != null && Row.length > 1)	{
						for(var i = Row.length - 2; i >= 0; i-- ) {
							var rvis_calc_tp_cd = sheetObj.CellValue(Row[i],"rvis_calc_tp_cd");
							
							if (rvis_calc_tp_cd!=null && rvis_calc_tp_cd.trim()=='M'){
								if (sheetObj.CellValue(Row[i],"rvis_tml_so_cntr_list_seq")==null || sheetObj.CellValue(Row[i],"rvis_tml_so_cntr_list_seq").trim()=='' || parseInt(sheetObj.CellValue(Row[i],"rvis_tml_so_cntr_list_seq"),10)==0){
									if (sheetObj.CellValue(Row[i],"rvis_tml_so_dtl_seq")==null || sheetObj.CellValue(Row[i],"rvis_tml_so_dtl_seq").trim()=='' || parseInt(sheetObj.CellValue(Row[i],"rvis_tml_so_dtl_seq"),10)==0){
										sheetObj.RowDelete(Row[i], false);
									} else {
										sheetObj.RowStatus(Row[i]) = 'D';
										sheetObj.RowHidden(Row[i]) = true;
									}
								}
							}
						}
         	    	}	
				}
                break;

        }
    }

    function sheet_OnSearchEnd(sheetObj){
    	if (sheetObj.RowCount == 0) {
     		/**
     		 * 2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.
     		 *                              기본적으로 조회되는 DATA가 없을 경우만 EDI data를 조회해온다.
     		 */    		
	        if (window.dialogArguments.document.form.edi_flg.value == 'Y' && EDI_init_rtrv_cnt == 0){
	        	EDI_init_rtrv_cnt++; // 반드시 EDI 기본 조회 바로 전에 증가해야 한다.
	        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	        }
    	}
    	
    	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,"ibflag")=='R'){
				if(sheetObj.CellValue(i,"rvis_cntr_tpsz_cd")!=document.getElementById("cntr_tpsz_cd").value){
					sheetObj.CellFontColor(i, "rvis_cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
					
	            }
			}
 		}
    }

    //save는 Auto에서만 실행
    function sheet_OnSaveEnd(sheetObj){
    	var rvis_vol_qty = document.form.rvis_vol_qty.value;
    	var rf_mntr_dys = document.form.rf_mntr_dys.value;
    	var opner_row = document.form.opener_row.value;
    	if(rvis_vol_qty>0){
    		window.dialogArguments.setShtCellsEditable(window.dialogArguments.document.t3sheet1,opner_row,'cntr_tpsz_cd','N');
    	} else {
    		window.dialogArguments.setShtCellsEditable(window.dialogArguments.document.t3sheet1,opner_row,'cntr_tpsz_cd','Y');
    	}
        window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = rvis_vol_qty;
        if(rf_mntr_dys>=0){
        	window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rf_mntr_dys') = rf_mntr_dys;
        }
    }

	function sheet_OnChange(sheet, row, col){
		var formObj = document.form;
		var sName = sheet.ColSaveName(col);
		if (sheet.RowCount > 0) {
			if (formObj.calc_tp_cd.value == 'A'){
				//자동은 그냥 그대로 한다.
			} else if (formObj.calc_tp_cd.value == 'M'){
				if (sheet.ColSaveName(col) == "rvis_ind_flg") {
					if (sheet.CellSearchValue(row,'rvis_ind_flg')!=sheet.CellValue(row,'rvis_ind_flg')) {
						if (sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')=='') {
//							sheet.CellValue(row,'ibflag') = "I";
							sheet.RowStatus(row) = "I";
						} else {
//							sheet.CellValue(row,'ibflag') = "U";
							sheet.RowStatus(row) = "U";
						}
					}
					/*
					if (sheet.CellSearchValue(row,'rvis_ind_flg')!=sheet.CellValue(row,'rvis_ind_flg')) {
						if (sheet.CellValue(row,'rvis_ind_flg')=='0'){
							if (sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')=='') {
//								sheet.CellValue(row,'ibflag') = "I";
								sheet.RowStatus(row) = "I";
							} else {
//								sheet.CellValue(row,'ibflag') = "U";
								sheet.RowStatus(row) = "U";
							}
						} else if (sheet.CellValue(row,'rvis_ind_flg')=='1') {
							if (!(sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')=='')) {
//								sheet.CellValue(row,'ibflag') = "D";
								sheet.RowStatus(row) = "D";
							} else {
//								sheet.CellValue(row,'ibflag') = "R";
								sheet.RowStatus(row) = "R";
							}
						}
					} else {
						//alert('ELSE : ' + sheet.CellSearchValue(row,'ibflag'));
						//sheet.RowStatus(row) = sheet.CellSearchValue(row,'ibflag');
						//sheet.CellValue2(row,'ibflag') = sheet.CellSearchValue(row,'ibflag');
//						sheet.CellValue2(row,'ibflag') = "I";
						sheet.RowStatus(row) = "I";
					}*/
				}
			}
			
			if ( sName == 'rvis_cntr_no' ) {
				// Bkg No 조회한 데이타 RowId에 넣기 위해 설정.
				document.getElementById("rowId").value	= row;
				document.getElementById("cntr_no").value = sheet.CellValue(row, "rvis_cntr_no");
				
				if ( ComIsNull( sheet.CellValue(row, "rvis_cntr_no") ) ) {
					return false;				
				}
				// UpperCase
				sheet.CellValue2(row, "rvis_cntr_no") = sheet.CellValue(row, "rvis_cntr_no").toUpperCase();
				
				// checkDigsit
				sheet.CellValue2(row, "rvis_cntr_no") = cntrCheckDigit( sheet.CellValue(row, "rvis_cntr_no") );
				
				// Container No. Duplication Check.
//				if ( !checkDupCntrNo(sheet, row) ) {
//					return false;
//				}
				
				if(!chkDupRow(sheet, row)){
					return false;
				}
				
				// Container No.로 Bkg No. search.
				searchBkgNo(formObj,sheet,row);	
			} else if ( sName == 'rvis_cntr_tpsz_cd' ) {
				// UpperCase
				sheet.CellValue2(row, "rvis_cntr_tpsz_cd") = sheet.CellValue(row, "rvis_cntr_tpsz_cd").toUpperCase();
				
			}
		}
	}

	/**
	 * 중복된 값이 존재 여부 체크
	 * @param {sheet}	sheet	ibsheet
	 * @return
	 */
	function chkDupRow(sheet, row){
		for (var i = sheet.HeaderRows; i < (sheet.HeaderRows + sheet.RowCount); i++) {
			if ( i != row ) {
				if (sheet.CellValue(i, "rvis_cntr_no") == sheet.CellValue(row, "rvis_cntr_no"))
				{
					ComShowMessage(ComGetMsg('TES23050','CNTR NO'));
				    return false;
				}
			}else{
		        return true;
		    }
		}
	}	

//	/**
//	 * Container No. Duplication Check. <br>
//	 * 
//	 * @param{ibsheet}		sheetObj	IBSheet Object.
//	 * @param{int,string}	row			Row Index.
//	 */
//	function checkDupCntrNo(sheetObj, row) {
//
//		for (var i = sheetObjects[0].HeaderRows; i < (sheetObjects[0].HeaderRows + sheetObjects[0].RowCount); i++) {
//		
//			if ( i != row ) {
//				if ((sheetObjects[0].CellValue(i, "rvis_cntr_no") == sheetObjects[0].CellValue(row, "rvis_cntr_no") ) &&
//					(sheetObjects[0].CellValue(i, "rvis_bkg_no") == sheetObjects[0].CellValue(row, "rvis_bkg_no") ) && 
//					 sheetObjects[0].CellValue(i, "ibflag") != 'D'
//				) {
//					ComShowCodeMessage("TES70117", sheetObjects[0].CellValue(row, "rvis_bkg_no"), sheetObjects[0].CellValue(row, "bkg_no"));		//[Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.
//					return false;
//				}
//			}
//		}
//		return true;
//	}
	 
	 /**
	 * Container No. BKG No. List 조회. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
	function searchBkgNo(formObj, sheetObj, row) {
		formObj.search_bkg_no.value = '';
//		document.getElementById("cntr_no").value	= sheetObj.CellValue(row, "rvis_cntr_no");
//		tes_getInputValue2('search_bkg_no', row, SEARCHLIST10, 'yd_cd|vvd|io_bnd_cd|atb_dt|cntr_no', eval('checkValidBkgCode(' + row + ')'));
		tes_getInputValue2('search_bkg_no', row, SEARCHLIST10, 'yd_cd|vvd|io_bnd_cd|atb_dt|cntr_no', 'checkValidBkgCode');
	}	 	 	 
	
	
	/**
	 *  BkgCode Validation 함수
	 */
	function checkValidBkgCode(rowId){		 
		var formObj = document.form;
		var tmp = '';
		var cntr_no = formObj.cntr_no.value;
		var cntr_tpsz_cd = formObj.cntr_tpsz_cd.value;
		var row = formObj.rowId.value;
		var row = rowId;
		//var test = 'Y|A2|SGN109974700';
		if (formObj.search_bkg_no.value!='undefined' && formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value.trim()!=''){
			tmp = formObj.search_bkg_no.value.split('|');
			//tmp = test.split('|');
			if (tmp.length > 0){
				formObj.search_bkg_no.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				//
				sheetObjects[0].CellValue(row, "rvis_cntr_tpsz_cd") = tmp[1];
				sheetObjects[0].CellValue(row, "eff_cntr_yn") = 'N';
				if (formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value == 'N'){
					//sheetObjects[0].CellFontColor(row, "rvis_cntr_no") = sheetObjects[0].RgbColor(255, 0, 0);
					ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('cntr_no는 등록이 안 된 EQ입니다.');
				} else {
					if (tmp[1]!=cntr_tpsz_cd){
						ComShowMessage(ComGetMsg('TES21607', row, cntr_no)); //ComShowMessage('cntr_no의 T/S코드가 다릅니다.');
					} else {
						sheetObjects[0].CellValue(row, "eff_cntr_yn") = 'Y';
						if (tmp[2]!=null && tmp[2]!=''){
							sheetObjects[0].CellValue(row, "rvis_bkg_no") = tmp[2];
						}
					}
				}
			} 
		} 
		else {
			ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
		
	}

	function getRfMntrDys(){
		var sheetObj = sheetObjects[0];
		var rfMntrDys = 0;
		var calc_tp = 0;
	    if(document.form.calc_tp_cd.value == 'A'){
	        calc_tp = 0;
	    }else if(document.form.calc_tp_cd.value == 'M'){
	        calc_tp = 0;
	    }
	    
		for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'rvis_plug_term')!="" && sheetObj.CellValue(i,'rvis_plug_term')>= 0 && 
	        		sheetObj.CellValue(i,'rvis_ind_flg') == calc_tp && sheetObj.CellValue(i,'ibflag')!='D'){
	        	rfMntrDys = parseInt(rfMntrDys) + parseInt(sheetObj.CellValue(i,'rvis_plug_term'));	 
	        }
	    }
		return rfMntrDys;
	}
	
	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz = document.form.cntr_tpsz_cd.value;
	    var calc_tp = 0;
	    if(document.form.calc_tp_cd.value == 'A'){
	        calc_tp = 0;
	    }else if(document.form.calc_tp_cd.value == 'M'){
	        calc_tp = 0;
	    }

	    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,'rvis_ind_flg') == calc_tp && sheetObj.CellValue(i,'ibflag')!='D'){
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
	
	/**
	 * 숫자에 대한 유효성을 체크.
	 */
	function donumberheck(obj) {
		var lveng = /[0-9]/;
		if( lveng.test(obj) ) {
			return false;
		}
		return true;
	}