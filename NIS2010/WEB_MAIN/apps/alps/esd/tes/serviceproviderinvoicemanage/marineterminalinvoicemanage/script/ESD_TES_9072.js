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
* 2015-04-09 김영신 [CHM-201534988] EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;

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
         	        sheetObj.CellValue(Row, "rvis_cntr_tpsz_cd") = formObj.cntr_tpsz_cd.value;
         	        sheetObj.CellValue(Row, "rvis_cntr_sty_cd") = formObj.cntr_sty_cd.value;
         	        sheetObj.CellValue(Row, "rvis_tml_inv_tp_cd") = 'TM';
         	        sheetObj.CellValue(Row, "rvis_calc_cost_grp_cd") = 'TM';
         	        sheetObj.CellValue(Row, "rvis_tml_rvis_tp_cd") = 'V';
         	        sheetObj.CellValue(Row, "rvis_calc_tp_cd") = 'M';
    	            break;

         	    case "btn_close":
    	            window.close();
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //showErrMessage("지금은 사용하실 수가 없습니다");
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
        //alert(formObj.calc_tp_cd.value);
		//doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value =='A'){
			//자동MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		} else if (formObj.calc_tp_cd.value!=undefined && formObj.calc_tp_cd.value!=null && formObj.calc_tp_cd.value=='M'){
			//수동MODE
			doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
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
                    InitHeadMode(true, true, true, true, false, false)

                    var HeadTitle = "STS|Seq.|cntr Seq.|dtl Seq.|rvis Seq.||Cost Code|CNTR No.|TP|F/M|INV TP|CALC GROUP|RVIS TP|Booking No|bkg_no_split|vsl_cd|skd_voy_no|skd_dir_cd";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++, dtHiddenStatus     ,     30,    daCenter,  true,    "ibflag");
                    InitDataProperty(0, cnt++, dtSeq		,     30,    daCenter,  true,    ""      );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "tml_so_cntr_list_seq"     );
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_dtl_seq");
                    InitDataProperty(0, cnt++, dtHidden	    ,     30,    daCenter,  true,    "rvis_tml_so_rvis_list_seq");

                    InitDataProperty(0, cnt++, dtCheckBox	,     30,    daCenter,  true,    "rvis_ind_flg" 		    ,        true ,          "",       dfNone,    0,     false,       true,		14);
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


    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        switch(sAction) {
            case IBSEARCH:	  //조회
                formObj.f_cmd.value = SEARCH01;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9072GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchXml(searchXml,true);
                break;

            case IBSEARCH_ASYNC01:	  //조회
                formObj.f_cmd.value = SEARCH02;
                var searchXml = sheetObj.GetSearchXml("ESD_TES_9072GS.do",  tesFrmQryStr(formObj));
                if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
                break;
                
            case IBSEARCH_ASYNC02:	  //[CHM-201534988]EDI로 수신한 모든 cost code에 대해 CNTR List 의 Revised Vol 으로 I/F 2015-04-09
	            formObj.f_cmd.value = SEARCH03;
	            var searchXml = sheetObj.GetSearchXml("ESD_TES_9032GS.do",  tesFrmQryStr(formObj));
	            if (searchXml != "") sheetObj.LoadSearchXml(searchXml,true);
	            break;

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
	        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC02);
	        }
    	}
    }
    	

