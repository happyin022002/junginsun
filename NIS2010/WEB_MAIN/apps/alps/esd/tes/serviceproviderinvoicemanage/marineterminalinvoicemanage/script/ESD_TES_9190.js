/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9190.js
*@FileTitle : Total Amount List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-08
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-08 parkyeonjin
* 2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.
* 1.0 최초 생성
=========================================================*/

	// 공통전역변수
	var sheetObjects = new Array();
	var sheetCnt = 0;
	var err_flag = false;

	//2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수 조회 횟수
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
         	   case "btn_rowdel":
         		   doActionIBSheet(sheetObject,formObject,IBDELETE);
         		   break;

         	    case "btn_ok":
         	    	//setParentRvisSheet(sheetObject,formObject,formObject.rh_vol_qty.value);
					doActionIBSheet(sheetObject,formObject,IBSAVE);
					if(err_flag == false){
					    window.close();
					}
        	        
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
     * @param {ibsheet}	sheet_obj	IBsheet object
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
        	ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }

		doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * @param {ibsheet} sheetObj ==> 시트오브젝트
     * @param {int}		sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
             case 1:      //sheet init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 240;

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
                    InitColumnInfo(11, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, true, true, false, false);

                    var HeadTitle = "STS|Sel.|Seq.|CNTR No.|TPSZ|Caused CNTR|Reason Code";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus,  30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtCheckBox,     	40,    daCenter,  true,    "rvis_ind_flg");
                    InitDataProperty(0, cnt++, dtSeq		,       30,    daCenter,  true,    ""   							,        false,          "",       dfNone,    0,     false,       false);
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cntr_no"					,        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData		,       40,    daCenter,  true,    "rvis_cntr_tpsz_cd"					,        false,          "",       dfNone,    0,     true,       true);
                    InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_cuz_cntr_no"	,        false,          "",       dfNone,    0,     true ,       true );

					InitDataProperty(0, cnt++, dtData		,       90,    daCenter,  true,    "rvis_rhnd_rsn_cd"			,        false,          "",       dfNone,    0,     true ,       true );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_dtl_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_tml_so_rvis_list_seq"			,        false,          "",       dfNone,    0,     false ,       false );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_lgs_cost_cd"			,        false,          "",       dfNone,    0,     false ,       false );
                    InitDataProperty(0, cnt++, dtHidden		,       90,    daCenter,  true,    "rvis_page_rows"			,        false,          "",       dfNone,    0,     false ,       false );

               }
                break;
        }
    }



	// Sheet관련 프로세스 처리
	/**
	 * @param {ibsheet}	sheetObj	IBsheet object
	 * @param {form}	formObj		form object
	 * @param {String}	sAction		Action value
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9190GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSEARCH_ASYNC01:	  //조회
	            formObj.f_cmd.value = SEARCH01;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9190GS.do",  tesFrmQryStr(formObj));
	            sheetObj.LoadSearchXml(searchXml,true);
	            break;                
                
            case IBSAVE:
            
                for(var i=sheetObjects[0].HeaderRows ; i<sheetObjects[0].HeaderRows + sheetObjects[0].RowCount; i++){
			        sheetObjects[0].RowFontColor(i) = sheetObjects[0].RgbColor(0, 0, 0);
		        }
            
                err_flag = false;
                var Rows;
		        Rows = sheetObj.ColValueDupRows("rvis_cntr_no");
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
            
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();
                var param = sheetObj.GetSaveString();
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9190GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                break;

            case IBDELETE:
            	if (sheetObj.RowCount > 0){
					var Row = sheetObj.SelectRow;
					sheetObj.RowStatus(Row) = 'D';
					sheetObj.RowHidden(Row) = true;
				}
                break;

        }
    }

	/**
	 * rvis 갯수를 opener에 저장하도록 
	 * 
	 * @param {ibsheet} sheetObj
	 * @return
	 */
    function sheet_OnSaveEnd(sheetObj){
		//alert(document.form.opener_row.value + '  /  ' + getRVISQty());
        window.dialogArguments.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = getRVISQty();
    }

    /** Manual RVIS의 경우,, Popup창에서 OK버튼을 눌러도 바로DB에 반영되지는 않는다.
     * opener의 rvis hidden sheet에만 관련 data가 저장되어 있기 때문에
     * popup화면 재 open시,, 유저의 작업내용을 다시 보여주기 위해, openr의 hidden sheet를
     * @param {ibsheet}	sheetObj	IBsheet object
     */
    function sheet_OnSearchEnd(sheetObj){
        var openerObj = window.dialogArguments.document.rvis_hidden;
        var formObj = document.form;
        
    	if (sheetObj.RowCount == 0) {
    		/**
    		 * 2009-08-27 [PJM-200900072] : 기본 조회되는 DATA가 없을 경우 EDI로 접수된 MANUAL CNTR목록을 조회한다.
    		 *                              기본적으로 조회되는 DATA가 없을 경우만 EDI data를 조회해온다.
    		 */
	        if (window.dialogArguments.document.form.edi_flg.value == 'Y' && EDI_init_rtrv_cnt == 0){
	        	EDI_init_rtrv_cnt++; // 반드시 EDI 기본 조회 바로 전에 증가해야 한다.
	        	doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC01);
	        }
    	}
    }
    
    /**
     * 
     * @param {ibsheet}	sheet	IBSheet Object
     * @param {int}		row		셀의 row index값
     * @param {int}		col		셀의 col index값
     * @return
     */
	function sheet_OnChange(sheet, row, col){
		var formObj = document.form;
		if (sheet.RowCount > 0) {
			if (sheet.ColSaveName(col) == "rvis_ind_flg") {
				if (sheet.CellSearchValue(row,'rvis_ind_flg')!=sheet.CellValue(row,'rvis_ind_flg')) {
					if (sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')=='') {
//						sheet.CellValue(row,'ibflag') = "I";
						sheet.RowStatus(row) = "I";
					} else {
//						sheet.CellValue(row,'ibflag') = "U";
						sheet.RowStatus(row) = "U";
					}
				}
			}
		}
	}
	
	/**
	 *  rvis 수량
	 *  
	 * @return
	 */
	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz =window.dialogArguments.document.t3sheet1.CellValue( document.form.opener_row.value, "cntr_tpsz_cd");

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
