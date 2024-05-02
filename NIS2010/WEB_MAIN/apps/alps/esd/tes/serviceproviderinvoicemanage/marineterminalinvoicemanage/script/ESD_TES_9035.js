/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TES_9035.js
*@FileTitle : R/H Volume Adjustment PopUp 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2015-02-10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2015-02-10 9014787
* 1.0 최초 생성
* 2015-04-01 [CHM-201534782] R/H Volume Ahjustment pop-up에 TPSZ 별 검색조건 추가
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

var comboObjects = new Array();
var comboCnt = 0 ;

var err_flag = false;

var EDI_init_rtrv_cnt = 0;

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
         	        var Row = sheetObj.DataInsert(-1);
					sheetObj.CellValue(Row, "rvis_ind_flg") = 1;
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
//					sheetObj.CellValue(Row, "ibflag") = "I";
//					sheetObj.RowStatus(Row) = "I";
					sheetObj.RowStatus(Row) = 'R';
					sheetObj.CellEditable(Row, "rvis_lgs_cost_cd") = false;
					sheetObj.CellEditable(Row, "rvis_cntr_no") = true;
					sheetObj.CellEditable(Row, "rvis_bkg_no") = true;
					break;

        	    case "btn_ok":
//         	        if (!sheetObj.IsDataModified){
//         	            ComShowCodeMessage('TES21601'); //ComShowMessage('수정된 내역이 없습니다.');
//         	            return false;
//         	        }

					if(!chkDupRow(sheetObj)){
						return false;
					}
					for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){//alert(sheetObj.CellValue(i,"ibflag") +":"+sheetObj.CellValue(i,"rvis_ind_flg"));
						if(sheetObj.CellValue(i,"ibflag")!='D' && sheetObj.CellValue(i,"rvis_ind_flg") == 1){
							if(sheetObj.CellValue(i,"eff_cntr_yn")=='N'){
								sheetObj.CellFontColor(i, "rvis_cntr_no") = sheetObj.RgbColor(255, 0, 0);
								//err_flag = true;
							}
							if(err_flag == true){
								alert('Wrong TPSZ');
								err_flag = false;
								return false;
							}
							if(sheetObj.CellValue(i,"rvis_cntr_no")==''){
								alert('Container No.');
								return false;
							}
						}
					}
					if(err_flag == false){
						doActionIBSheet(sheetObj,formObj,IBINSERT);
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

         	    case "btn_retrieve":
         	    	
         	    	formObj.f_cmd.value = SEARCH02;
         	    	
         	    	var fm = 'A';
					if(document.form.fm_full.checked && !document.form.fm_empty.checked){
						fm = 'F';
					}else if(!document.form.fm_full.checked && document.form.fm_empty.checked){
						fm = 'E';
					}
					document.form.yn.value = fm;
					
					if(document.form.tpsz_cd.Code == ''){
						ComShowMessage("Not Selected Type/Size");
						return false;
					}

					var prefix = "t6sheet1_";
					prefix = "";

					var sXml = sheetObj.GetSearchXml("ESD_TES_9001GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));

					//sheetObj.Redraw = false;    
					//sheetObj.WaitImageVisible = false;	
					sheetObj.LoadSearchXml(sXml); 
					sheetObj.Redraw = true;
					sheetObj.WaitImageVisible = false;
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param (object)	combo_obj	combo object
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
    	
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        // CHM-201534690 TES: EDI에서 수신한 CNTR LIST를  Invoice 생성시 RVIS VOL POPUP 에서 I/F
        var opener = window.dialogArguments;
        if (opener.document.form.edi_flg.value == 'Y' && EDI_init_rtrv_cnt == 0){
        	EDI_init_rtrv_cnt++; // 반드시 EDI 기본 조회 바로 전에 증가해야 한다.
        	doActionIBSheet(sheetObjects[0],document.form, IBSEARCH_ASYNC02);
        }
        
        // [CHM-201534782] R/H Volume Ahjustment pop-up에 TPSZ 별 검색조건 추가
        tes_getComboItem('tpsz_cd', 1, SEARCH13, '', '');
    }
    
    
    /** Combo 기본 설정 
     *  Combo의 항목을 설정한다.
     * @param {comoObj}	comboObj	combo Object
     * @param {int}		comboNo 	combo no
     * @param {String}	combo_val 	combo value
     * @param {String}	def_val 	def value
     */ 
    function initCombo (comboObj, comboNo, combo_val, def_val) {
        var cnt  = 0 ;
       
        switch(comboNo) {

            case 1:   //currency
                with (comboObj) {
                    SetColAlign('left');
					SetColWidth('70');
					MultiSelect=true;
					DropHeight=150;

					var tmp = '';
					if (combo_val!=null){tmp = combo_val.split('|');}
					InsertItem(cnt++, 'ALL', 'ALL');
					for (var i=0; tmp!=null && i<tmp.length; i++){
						InsertItem(cnt++, new String(tmp[i]), new String(tmp[i]));
					}
					if (def_val!=undefined && def_val!=null && def_val.trim()!=''){
						Code = def_val;
					} else {
						Code = '';
					}
					
					CheckCode('ALL') = true;					
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
        switch(sheetNo) {

        	case 1:
			var cnt = 0;
			var mBtnDis = "N";
			var mustInput = (mBtnDis == "Y" ? true : false); 
			with (sheetObj) {
							// 높이 설정
				style.height = 400;
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(1, 1, 3, 100);
				
				var HeadTitle1 = "";
				HeadTitle1 = "|Seq.|Sel.|Container No.|Responsible\nCNTR No.|Type\n/Size|BKG_NO||F/M|POL|Operator|From Position|To Position|Reason|Account|Responsible\n Party|File Attached|check_row||||||||||";
				var headCount = ComCountHeadTitle(HeadTitle1);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, true, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);

				var prefix = "t6sheet1_";
				prefix = "";

				//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				//
				InitDataProperty(0, cnt++ , dtHiddenStatus,		40,		daCenter,	false,		prefix + "ibflag");
				InitDataProperty(0, cnt++ , dtSeq,				40,		daCenter,	true,		prefix + "seq");
				//InitDataProperty(0, cnt++ , dtCheckBox,			40,		daCenter,	true,		prefix + "rvis_ind_flg",		false,		"",					dfNone,		0,		true,		false);
				InitDataProperty(0, cnt++ , dtCheckBox	,     40,    daCenter,  true,    prefix + "rvis_ind_flg");
				//InitDataProperty(0, cnt++,  dtCheckBox,          20,    daCenter,   true,       prefix + "del_chk",             false,    "",          dfNone,     0,         true,   false);
				InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "rvis_cntr_no",			mustInput,	"",					dfEngUpKey,	0,		false,		true,		13);
				InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "respb_cntr_no",	mustInput,	"",					dfEngUpKey,	0,		false,		true,		14);
				InitDataProperty(0, cnt++ , dtData,			50,	daCenter,	true,		prefix + "rvis_cntr_tpsz_cd",			false,		"",					dfEngUpKey,	0,		false,		true,		4);
				InitDataProperty(0, cnt++ , dtData,     		 90,    daCenter,	true,		prefix + "rvis_bkg_no"      	    ,        false,          "",       dfNone,    0,     false,       true, 	11);
				
				InitDataProperty(0, cnt++ , dtHidden,			    100,	daCenter,	true,		prefix + "cntr_chk",			false,		"",					dfEngUpKey,	0,		false,		true,		20);

				InitDataProperty(0, cnt++ , dtCombo,			50,		daCenter,	true,		prefix + "fe",				mustInput,	"",					dfEngUpKey,	0,		false,		true,		1);
				
				InitDataProperty(0, cnt++ , dtComboEdit,		70,		daCenter,	true,		prefix + "pol",				false,		"",					dfEngUpKey,	0,		false,		true,		5);
				InitDataProperty(0, cnt++ , dtPopupEdit,			70,	daCenter,	true,		prefix + "opr_cd",			mustInput,	"",					dfEngUpKey,	0,		false,		true,		3);
				InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "precell",			mustInput,	"",					dfNone,		0,		false,		true,		6);
				InitDataProperty(0, cnt++ , dtData,				100,	daCenter,	true,		prefix + "position",		mustInput,	"",					dfNone,		0,		false,		true,		6);
				InitDataProperty(0, cnt++ , dtPopupEdit,			70,	daCenter,	true,		prefix + "shift_rsn",		mustInput,	"",					dfEngUpKey,	0,		false,		true,		3);
				InitDataProperty(0, cnt++ , dtPopupEdit,		70,		daCenter,	true,		prefix + "account",			mustInput,	"",					dfEngUpKey,	0,		false,		true,		3);
				InitDataProperty(0, cnt++ , dtData,					90,	daCenter,	true,		prefix + "party",			mustInput,	"",					dfEngUpKey,	0,		false,		true,		12);
				InitDataProperty(0, cnt++ , dtPopupFormat,		80,		daCenter,	true,		prefix + "file_atch",		false,		"",					dfNone,		0,		false,		true,		12);
				InitDataProperty(0, cnt++ , dtHidden,			5,		daCenter,	true,		prefix + "check_row",		false,		"",					dfNone,		0,		false,		true,		3);
				
				// modify
				InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_cntr_sty_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
				
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_inv_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_cost_grp_cd" 	,        true ,          "",       dfNone,    0,     false,       true,		14);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_tml_rvis_tp_cd" 		,        true ,          "",       dfNone,    0,     false,       true,		14);
                
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_vsl_cd"      	    ,        false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_voy_no"  	    ,        false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_skd_dir_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_lgs_cost_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_calc_tp_cd"  	    ,        false,          "",       dfNone,    0,     false,       false);
                
                InitDataProperty(0, cnt++, dtHidden		,     40,    daCenter,  true,    "eff_cntr_yn" 				,        false,          "",       dfNone,    0,     false,       true,		14);
				
				InitDataValid(0, prefix + "rvis_cntr_no",       vtEngUpOther, "1234567890");
				InitDataValid(0, prefix + "precell",       vtNumericOnly );
				InitDataValid(0, prefix + "position",      vtNumericOnly );
				InitDataValid(0, prefix + "shift_rsn",     vtEngUpOnly   );
				InitDataValid(0, prefix + "opr_cd",        vtEngUpOnly   );
				InitDataValid(0, prefix + "account",       vtEngUpOnly   );
				InitDataValid(0, prefix + "respb_cntr_no", vtEngUpOther, "1234567890");

				//InitDataCombo(0, prefix + "rvis_cntr_tpsz_cd", parent.mSztpName,  parent.mSztpCode);alert(parent.mSztpName);
				
				InitDataCombo(0,   prefix + "fe", " |F|M", " |F|E");
				
				FrozenCols = 4;

				//podComboInit();
			}
			break;
        
        
        
            case 2:      //sheet init
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
                    InitColumnInfo(21, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false, false);

                    var HeadTitle = "STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.|Del.|Cost Code|CNTR No.|TPSZ|TP|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd|calc_tp|page_rows|cntr_yn";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus     ,     30,    daCenter,  false,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq		,     30,    daCenter,  true,    ""      );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_cntr_list_seq"     );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_dtl_seq");
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_rvis_list_seq");

                    InitDataProperty(0, cnt++, dtCheckBox	,     30,    daCenter,  true,    "rvis_ind_flg"             );
                    InitDataProperty(0, cnt++, dtData		,     75,    daCenter,  true,    "rvis_lgs_cost_cd"	        ,        true ,          "",       dfNone,    0,     false,       true, 	 6,		true);
                    InitDataProperty(0, cnt++, dtData		,     85,    daCenter,  true,    "rvis_cntr_no" 		    ,        true ,          "",       dfNone,    0,     false,       true,		14);
                    InitDataProperty(0, cnt++, dtData		,     40,    daCenter,  true,    "rvis_cntr_tpsz_cd" 		,        false,          "",       dfNone,    0,     false,       true,		14);
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
                    InitDataProperty(0, cnt++, dtHidden		,     90,    daCenter,  true,    "rvis_page_rows"  	        ,        false,          "",       dfNone,    0,     false,       false);
                    
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
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9032GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSEARCH_ASYNC01:	  //조회
                formObj.f_cmd.value = SEARCH02;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9032GS.do",  tesFrmQryStr(formObj));
                if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSEARCH_ASYNC02:	  // 2009-08-27 [PJM-200900072] : EDI manual cntr조회
	            formObj.f_cmd.value = SEARCH03;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9032GS.do",  tesFrmQryStr(formObj));
	            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
	            break;
                
            case IBSAVE:
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();
                var param = sheetObj.GetSaveString(false, false);
                
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9032GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                break;

            case IBINSERT:

            	// 체크된 Row sheetObj.RowStatus(Row) == 'I'
            	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
        	        if(sheetObj.CellValue(i, "rvis_ind_flg") == 1 && sheetObj.RowStatus(i) != 'I'){
        	        	sheetObj.RowStatus(i) = 'I';
        			}else{
        				sheetObj.RowStatus(i) = 'R';
        			}
         		}
            	
            /*
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
	            }*/
                formObj.f_cmd.value = MODIFY;
                formObj.rvis_vol_qty.value = getRVISQty();
                var param = sheetObj.GetSaveString();
				//var saveXml = sheetObj.GetSaveXml("ESD_TES_9032GS.do", param+'&'+tesFrmQryStr(formObj));
                var saveXml = sheetObj.GetSaveXml("ESD_TES_9190GS.do", param+'&'+tesFrmQryStr(formObj));
                sheetObj.LoadSaveXml(saveXml,true);
                break;
                
            case IBDELETE:

            	// 조회된 껀은 제거 불가.
            	if (sheetObj.RowCount > 0){
					var Row = sheetObj.SelectRow;
					var rvis_calc_tp_cd = sheetObj.CellValue(Row,"rvis_calc_tp_cd");
					//if (sheetObj.RowStatus(Row) == 'I' && rvis_calc_tp_cd!=null && rvis_calc_tp_cd.trim()=='M'){
						if (sheetObj.CellValue(Row,"rvis_tml_so_cntr_list_seq")==null || sheetObj.CellValue(Row,"rvis_tml_so_cntr_list_seq").trim()=='' || parseInt(sheetObj.CellValue(Row,"rvis_tml_so_cntr_list_seq"),10)==0){
							if (sheetObj.CellValue(Row,"rvis_tml_so_dtl_seq")==null || sheetObj.CellValue(Row,"rvis_tml_so_dtl_seq").trim()=='' || parseInt(sheetObj.CellValue(Row,"rvis_tml_so_dtl_seq"),10)==0){
								sheetObj.RowDelete(Row, false);
							} else {
								sheetObj.RowStatus(Row) = 'D';
								sheetObj.RowHidden(Row) = true;
							}
						}
					//}
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
     		// CHM-201534690 TES: EDI에서 수신한 CNTR LIST를  Invoice 생성시 RVIS VOL POPUP 에서 I/F
    		/*var opener = window.dialogArguments;
	        if (opener.document.form.edi_flg.value == 'Y' && EDI_init_rtrv_cnt == 0){
	        	EDI_init_rtrv_cnt++; // 반드시 EDI 기본 조회 바로 전에 증가해야 한다.
	        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	        }*/
    	}
    	
    	for(var i=sheetObj.HeaderRows ; i<sheetObj.HeaderRows + sheetObj.RowCount; i++){
	        if(sheetObj.CellValue(i,"ibflag")=='R'){
				if(sheetObj.CellValue(i,"rvis_cntr_tpsz_cd")!=document.getElementById("cntr_tpsz_cd").value){
					sheetObj.CellFontColor(i, "rvis_cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
					
	            }
			}
	        //sheetObj.RowEditable(i) = false;alert(sheetObj.RowEditable(i));
 		}
    	
    	var formObj = document.form;
    	
    	// modify bkg_no split
    	for(var i=1 ; i<sheetObj.RowCount+1; i++){
	        /*if(sheetObj.CellValue(i,"cntr_chk") != ''){
	        	var tmp = formObj.search_bkg_no.value.split('|');
	        	if(sheetObj.CellValue(i,"rvis_cntr_tpsz_cd")!=document.getElementById("cntr_tpsz_cd").value){
					sheetObj.CellFontColor(i, "rvis_cntr_no") = sheetObj.RgbColor(255, 0, 0);		 // 빨간색 글씨
					
	            }
			}*/
    		var cntr_tpsz_cd = formObj.cntr_tpsz_cd.value;
	        var search_bkg_no = sheetObj.CellValue(i,"cntr_chk");
	        if (search_bkg_no != 'undefined' && search_bkg_no != null && search_bkg_no.trim() != ''){
				var tmp = search_bkg_no.split('|');
				//tmp = test.split('|');
				if (tmp.length > 0){
					search_bkg_no = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
					//
					if(sheetObj.CellValue(i, "rvis_cntr_tpsz_cd") == '') sheetObj.CellValue(i, "rvis_cntr_tpsz_cd") = tmp[1]; //sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_cntr_tpsz_cd") = tmp[1];
					sheetObj.CellValue(i, "eff_cntr_yn") = 'N';
					if (search_bkg_no != null && search_bkg_no == 'N'){
						//sheetObjects[0].CellFontColor(document.getElementById("rowId").value, "rvis_cntr_no") = sheetObjects[0].RgbColor(255, 0, 0);
						//ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('cntr_no는 등록이 안 된 EQ입니다.');
					} else {
						sheetObj.CellValue(i, "eff_cntr_yn") = 'Y';
						if (tmp[2] != null && tmp[2] != ''){
							sheetObj.CellValue(i, "rvis_bkg_no") = tmp[2];
						}
						/*
						if (tmp[1] != cntr_tpsz_cd){
							//ComShowMessage(ComGetMsg('TES21607', row, cntr_no)); //ComShowMessage('cntr_no의 T/S코드가 다릅니다.');
						} else {
							sheetObj.CellValue(i, "eff_cntr_yn") = 'Y';
							if (tmp[2] != null && tmp[2] != ''){
								sheetObj.CellValue(i, "rvis_bkg_no") = tmp[2];
							}
						}
						*/
					}
					
					/*if(sheetObj.CellValue(i, "eff_cntr_yn") != 'Y'){
						sheetObj.CellEditable(i, "rvis_ind_flg") = false;
					}*/
				}
			}
	        
	        sheetObj.CellValue(i, "rvis_ind_flg")			= 0;
 	        sheetObj.CellValue(i, "rvis_lgs_cost_cd")		= formObj.lgs_cost_cd.value;
 	        sheetObj.CellValue(i, "rvis_vsl_cd")			= formObj.vvd.value.substring(0,4);
 	        sheetObj.CellValue(i, "rvis_skd_voy_no")		= formObj.vvd.value.substring(4,8);
 	        sheetObj.CellValue(i, "rvis_skd_dir_cd")		= formObj.vvd.value.substring(8,9);
 	        sheetObj.CellValue(i, "rvis_cntr_sty_cd")		= formObj.cntr_sty_cd.value;
 	        sheetObj.CellValue(i, "rvis_tml_inv_tp_cd")		= 'TM';
 	        sheetObj.CellValue(i, "rvis_calc_cost_grp_cd")	= 'TM';
 	        sheetObj.CellValue(i, "rvis_tml_rvis_tp_cd")	= 'V';
 	        sheetObj.CellValue(i, "rvis_calc_tp_cd")		= 'M';
	        
	        sheetObj.RowStatus(i) = 'R';
 		}
    }

    //save는 Auto에서만 실행
    function sheet_OnSaveEnd(sheetObj){
    	var opener = window.dialogArguments;
    	var rvis_vol_qty = document.form.rvis_vol_qty.value;
    	var opner_row = document.form.opener_row.value;//alert(rvis_vol_qty);alert(document.form.opener_row.value);
    	if(rvis_vol_qty>0){
    		opener.setShtCellsEditable(opener.document.t3sheet1,opner_row,'cntr_tpsz_cd','N');
    	} else {
    		opener.setShtCellsEditable(opener.document.t3sheet1,opner_row,'cntr_tpsz_cd','Y');
    	}
        opener.document.t3sheet1.CellValue(document.form.opener_row.value,'rvis_vol_qty') = rvis_vol_qty;
        if( opener.document.t3sheet1.CellValue(document.form.opener_row.value,'calc_vol_qty') == ''){
        	opener.document.t3sheet1.CellValue(document.form.opener_row.value,'calc_vol_qty') = rvis_vol_qty;
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
						//sheet.RowStatus(row) = "I";
						/*if (sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')==null || sheet.CellValue(row,'rvis_tml_so_rvis_list_seq')=='') {
//							sheet.CellValue(row,'ibflag') = "I";
							sheet.RowStatus(row) = "I";
						} else {
//							sheet.CellValue(row,'ibflag') = "U";
							sheet.RowStatus(row) = "U";
						}*/
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
				
				if(!chkDupRow(sheet)){
					return false;
				}
				
				// Container No.로 Bkg No. search.
				searchBkgNo(formObj,sheet.CellValue(row, "rvis_cntr_no"));
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
	function chkDupRow(sheet){
	    var Row = sheet.ColValueDup("rvis_cntr_no",false);
	    if(Row > 0){
	        ComShowMessage(ComGetMsg('TES23050','CNTR NO'));
	        return false;
	    }else{
	        return true;
	    }
	}
	
	/**
	 * Container No. Duplication Check. <br>
	 * 
	 * @param{ibsheet}		sheetObj	IBSheet Object.
	 * @param{int,string}	row			Row Index.
	 */
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
	function searchBkgNo(formObj, cntr_no) {
		formObj.search_bkg_no.value = '';
		tes_getInputValue('search_bkg_no', SEARCHLIST10, 'yd_cd|vvd|io_bnd_cd|atb_dt|cntr_no', 'checkValidBkgCode');
	}
	 
	/**
	 *  BkgCode Validation 함수
	 */
	function checkValidBkgCode(){
		var formObj = document.form;
		var tmp = '';
		var cntr_no = formObj.cntr_no.value;
		var cntr_tpsz_cd = formObj.cntr_tpsz_cd.value;
		var row = formObj.rowId.value;
		//var test = 'Y|A2|SGN109974700';
		//alert(formObj.search_bkg_no.value);
		
		// 초기화
		sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_cntr_tpsz_cd") = "";
		sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'N';
		sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_bkg_no") = "";
		
		if (formObj.search_bkg_no.value!='undefined' && formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value.trim()!=''){
			tmp = formObj.search_bkg_no.value.split('|');
			//tmp = test.split('|');
			if (tmp.length > 0){
				formObj.search_bkg_no.value = (tmp[0]!=undefined&&tmp[0]!=null?tmp[0]:'');
				//
				sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_cntr_tpsz_cd") = tmp[1];
				sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'N';
				if (formObj.search_bkg_no.value!=null && formObj.search_bkg_no.value == 'N'){
					//sheetObjects[0].CellFontColor(document.getElementById("rowId").value, "rvis_cntr_no") = sheetObjects[0].RgbColor(255, 0, 0);
					ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('cntr_no는 등록이 안 된 EQ입니다.');
				} else {
					sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'Y';
					if (tmp[2]!=null && tmp[2]!=''){
						sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_bkg_no") = tmp[2];
					}
					/*
					if (tmp[1]!=cntr_tpsz_cd){
						ComShowMessage(ComGetMsg('TES21607', row, cntr_no)); //ComShowMessage('cntr_no의 T/S코드가 다릅니다.');
					} else {
						sheetObjects[0].CellValue(document.getElementById("rowId").value, "eff_cntr_yn") = 'Y';
						if (tmp[2]!=null && tmp[2]!=''){
							sheetObjects[0].CellValue(document.getElementById("rowId").value, "rvis_bkg_no") = tmp[2];
						}
					}
					*/
				}
			} 
		} else {
			ComShowMessage(ComGetMsg('TES21606', row, cntr_no)); //ComShowMessage('유효하지 않은 VNDR Code입니다.');
		}
		
	}

	function getRVISQty(){
	    var sheetObj = sheetObjects[0];
	    var qty = 0;
	    var cntr_tpsz = document.form.cntr_tpsz_cd.value;
	    var calc_tp = 0;
	    if(document.form.calc_tp_cd.value == 'A'){
	        calc_tp = 0;
	    }else if(document.form.calc_tp_cd.value == 'M' || document.form.calc_tp_cd.value == 'S'){
	        calc_tp = 1;
	    }//alert(sheetObj.HeaderRows+':'+sheetObj.RowCount)

	    for(var i=sheetObj.HeaderRows; i<sheetObj.HeaderRows+sheetObj.RowCount; i++){//alert(sheetObj.CellValue(i,'rvis_ind_flg')+':'+calc_tp+':'+sheetObj.CellValue(i,'ibflag'));
	        if(sheetObj.CellValue(i,'rvis_ind_flg') == calc_tp && sheetObj.CellValue(i,'ibflag')!='D' && sheetObj.CellValue(i,'ibflag')!='R'){
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