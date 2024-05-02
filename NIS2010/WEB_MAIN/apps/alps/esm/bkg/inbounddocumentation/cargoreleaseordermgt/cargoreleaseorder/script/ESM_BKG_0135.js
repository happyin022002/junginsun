/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0135.js
*@FileTitle : Cargo Release Order E-D/O inquery_E-D/O Issue Application Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.25 안진응
* 1.0 Creation
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
     * @class esm_bkg_0135 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0135() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
    }

    /* 개발자 작업  */

    ﻿
    // 공통전역변수

	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;

	// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
             
            	case "btn_close":
					window.close();
                break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
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
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);

            ComEndConfigSheet(sheetObjects[i]);
        }
		
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }     
     
    /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
 		var sheetID = sheetObj.id;
 				
        switch(sheetID) {
            case "sheet1":      //sheetHidden init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 0;
                                         
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

 					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(13, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, false, false, true, false,false)

                    var HeadTitle1 = "|bl_no|edo_rct_dt|edo_ack_cd|edo_ack_dt|edo_rct_loc_cd|edo_ack_usr_id|edo_skd_voy_no|edo_skd_dir_cd|edo_vsl_nm|vsl_arr_dt|diff_rmk|edo_rct_loc_nm";
                                         
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);

                    var prefix="sheet1_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 	                InitDataProperty(0, cnt++ , dtHiddenStatus,	     0,    daCenter,    true,  	  prefix + "ibflag");
 					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "bl_no",      	    false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_rct_dt",        false,    "",      dfNone, 			0,     false,		false);
  					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_ack_cd",        false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
  					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_ack_dt",        false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
  					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_rct_loc_cd",    false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_ack_usr_id",    false,    "",      dfNone, 			0,     false,		false);
				  	InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_skd_voy_no",    false,    "",      dfNone, 			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_skd_dir_cd",    false,    "",      dfNone, 	        0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_vsl_nm",        false,    "",      dfNone, 	        0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "vsl_arr_dt",        false,    "",      dfNone, 	        0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "diff_rmk",          false,    "",      dfNone,			0,     false,		false);
  					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "edo_rct_loc_nm",    false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
					  
					CountPosition = 0;
                }
                break;
            case "sheet2":      //sheetHidden init
	            with (sheetObj) {
	                // 높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(17, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = " |arr_area_no|arr_area_vndr_nm|arr_cstms_no|arr_cstms_vndr_nm|pck_qty|pck_tp_cd|cntr_no|gds_desc1|gds_desc2|gds_desc3|gds_desc4|ttl_wgt|wgt_ut_cd|rqst_trsp_dt|inv_amt|inv_curr_cd";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                var prefix="sheet2_";
	                InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
	                InitDataProperty(0,   cnt++ ,     dtData,         100,    daCenter,  false,   prefix +"arr_area_no"         ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"arr_area_vndr_nm"    ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"arr_cstms_no"        ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"arr_cstms_vndr_nm"   ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pck_qty"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pck_tp_cd"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"cntr_no"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"gds_desc1"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"gds_desc2"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"gds_desc3"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"gds_desc4"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"ttl_wgt"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"wgt_ut_cd"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"rqst_trsp_dt"        ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"inv_amt"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"inv_curr_cd"         ,   false,     "",        dfNone,     0,          false,       true);

                    CountPosition = 0;
	            }
                break;
            case "sheet3":      //sheetHidden init
                with (sheetObj) {
                    // 높이 설정
	                style.height = 0;
	                //전체 너비 설정
	                SheetWidth = mainTable.clientWidth;
	
	                //Host정보 설정[필수][HostIp, Port, PagePath]
	                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
	                //전체Merge 종류 [선택, Default msNone]
	                MergeSheet = msNone;
	
  	                //전체Edit 허용 여부 [선택, Default false]
	                Editable = true;
	
	                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	                InitRowInfo( 1, 1, 3, 100);
	
	                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                InitColumnInfo(11, 0, 0, true);
	
	                // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                InitHeadMode(true, true, false, true, false,false)
	
	                var HeadTitle = " |pty_rgst_no|pty_nm1|pty_nm2|pty_cntc_pson_nm|phn_no|edo_pty_cd|pty_rep_nm|pty_addr1|pty_addr2|pty_addr3";
	
	                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                InitHeadRow(0, HeadTitle, true);
	
	                //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                var prefix="sheet3_";
	                InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
	                InitDataProperty(0,   cnt++ ,     dtData,         100,    daCenter,  false,   prefix +"pty_rgst_no"         ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_nm1"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_nm2"             ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_cntc_pson_nm"    ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"phn_no"              ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"edo_pty_cd"          ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_rep_nm"          ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_addr1"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_addr2"           ,   false,     "",        dfNone,     0,          false,       true);
	                InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"pty_addr3"           ,   false,     "",        dfNone,     0,          false,       true);
	 
	                CountPosition = 0;
                   
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
        switch(sAction) {
			case IBSEARCH:      //조회
				formObj.f_cmd.value = SEARCH;
                //다중조회
                var aryPrefix = new Array("sheet1_", "sheet2_", "sheet3_"); //prefix 문자열 배열
                var sXml = sheetObjects[1].GetSearchXml("ESM_BKG_0135GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
                var arrXml = sXml.split("|$$|");

                for(var idx = 0; idx < arrXml.length; idx++){
                    sheetObjects[idx].Redraw = false;
                    if(idx > 0) {
                        sheetObjects[idx].WaitImageVisible = false;
                    }
                    sheetObjects[idx].LoadSearchXml(arrXml[idx]);
                    sheetObjects[idx].Redraw = true;
                }
			break;
        }
    }     

    /**
     * sheet1의 조회가 완료된 경우 처리 이벤트
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
     	
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                var prefix = "sheet1_"; 
         		formObj.bl_no.value = sheetObj.CellValue(1, prefix + "bl_no");
         		formObj.edo_rct_dt.value = sheetObj.CellValue(1,prefix + "edo_rct_dt");
         		
         		if (sheetObj.CellValue(1,prefix + "edo_ack_cd") == "A") {
         			formObj.edo_ack_dt_a.value = sheetObj.CellValue(1,prefix + "edo_ack_dt");
         		} else {
         			formObj.edo_ack_dt_r.value = sheetObj.CellValue(1,prefix + "edo_ack_dt");
         		}
         		
         		formObj.edo_rct_loc_cd.value = sheetObj.CellValue(1,prefix + "edo_rct_loc_cd");
         		formObj.edo_rct_loc_nm.value = sheetObj.CellValue(1,prefix + "edo_rct_loc_nm");
         		
         		formObj.edo_ack_usr_id.value = sheetObj.CellValue(1,prefix + "edo_ack_usr_id");         		
         		formObj.skd_nm.value = sheetObj.CellValue(1,prefix + "edo_skd_voy_no") + sheetObj.CellValue(1,prefix + "edo_skd_dir_cd");
         		formObj.edo_vsl_nm.value = sheetObj.CellValue(1,prefix + "edo_vsl_nm");         		
         		formObj.vsl_arr_dt.value = sheetObj.CellValue(1,prefix + "vsl_arr_dt");
         		formObj.diff_rmk.value = sheetObj.CellValue(1,prefix + "diff_rmk");         		
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }
   
    /**
    * sheet2의 조회가 완료된 경우 처리 이벤트
    */
    function sheet2_OnSearchEnd(sheetObj, ErrMsg){
    	var formObj = document.form;
      	
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
                //Grid의 Data를 Html의 인자값으로 Copy한다.
                var prefix = "sheet2_"; 
          		formObj.arr_area_no.value = sheetObj.CellValue(1, prefix + "arr_area_no"); 
          		formObj.arr_area_vndr_nm.value = sheetObj.CellValue(1,prefix + "arr_area_vndr_nm");
          		formObj.arr_cstms_no.value = sheetObj.CellValue(1,prefix + "arr_cstms_no");
          		formObj.arr_cstms_vndr_nm.value = sheetObj.CellValue(1,prefix + "arr_cstms_vndr_nm");
          		formObj.pck_qty.value = ComAddComma2(sheetObj.CellValue(1,prefix + "pck_qty"), "#,###");
          		formObj.pck_tp_cd.value = sheetObj.CellValue(1,prefix + "pck_tp_cd");
          		formObj.gds_desc1.value = sheetObj.CellValue(1,prefix + "gds_desc1");
          		formObj.gds_desc2.value = sheetObj.CellValue(1,prefix + "gds_desc2");
          		formObj.gds_desc3.value = sheetObj.CellValue(1,prefix + "gds_desc3");
          		formObj.gds_desc4.value = sheetObj.CellValue(1,prefix + "gds_desc4");

          		formObj.ttl_wgt.value = ComAddComma2(sheetObj.CellValue(1, prefix + "ttl_wgt"), "#,###.00");
          		
          		formObj.rqst_trsp_dt.value = sheetObj.CellValue(1,prefix + "rqst_trsp_dt");
          		formObj.inv_amt.value = ComAddComma2(sheetObj.CellValue(1, prefix + "inv_amt"), "#,###.0");
          		formObj.cntr_no.value = ComAddComma(sheetObj.CellValue(1, prefix + "cntr_no"));
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }

    /**
    * sheet3의 조회가 완료된 경우 처리 이벤트
    */
    function sheet3_OnSearchEnd(sheetObj, ErrMsg){
       	var formObj = document.form;
       	
        if (ErrMsg == "") {
            if(sheetObj.RowCount > 0){
            	//Grid의 Data를 Html의 인자값으로 Copy한다.
	            var prefix = "sheet3_";
	                
	            for(var i=1; i<=sheetObj.RowCount; i++) {
	                if (sheetObj.CellValue(i,prefix + "edo_pty_cd") == "MS") {
	                	if (sheetObj.CellValue(i,prefix + "pty_rgst_no").length == 10) {
	                    	formObj.ms_pty_rgst_no.value = sSaupFormat(sheetObj.CellValue(i,prefix + "pty_rgst_no"));
	                    } else {
	                    	formObj.ms_pty_rgst_no.value = sheetObj.CellValue(i,prefix + "pty_rgst_no");
	                    }
	    	           	formObj.ms_pty_nm.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	    	           	formObj.ms_pty_nm2.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	    	           	formObj.ms_pty_cntc_pson_nm.value = sheetObj.CellValue(i,prefix + "pty_cntc_pson_nm");
	    	           	formObj.ms_phn_no.value = sheetObj.CellValue(i,prefix + "phn_no");
	                }else if (sheetObj.CellValue(i,prefix + "edo_pty_cd") == "GA") {
	    	            formObj.ga_pty_rgst_no.value = sheetObj.CellValue(i,prefix + "pty_rgst_no");
	    	            formObj.ga_pty_nm.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	                }else if (sheetObj.CellValue(i,prefix + "edo_pty_cd") == "AS") {
	    	        	formObj.as_pty_nm.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	    	        	if (sheetObj.CellValue(i,prefix + "pty_rgst_no").length == 10) {
	    	        		formObj.as_pty_rgst_no.value = sSaupFormat(sheetObj.CellValue(i,prefix + "pty_rgst_no"));
	    	        	} else {
	    	        		formObj.as_pty_rgst_no.value = sheetObj.CellValue(i,prefix + "pty_rgst_no");
	    	        	}
	    	        	formObj.as_pty_rep_nm.value = sheetObj.CellValue(i,prefix + "pty_rep_nm");
	    	           	formObj.as_phn_no.value = sheetObj.CellValue(i,prefix + "phn_no");
	    	           	formObj.as_pty_addr1.value = sheetObj.CellValue(i,prefix + "pty_addr1");
	    	           	formObj.as_pty_addr2.value = sheetObj.CellValue(i,prefix + "pty_addr2");
	    	           	formObj.as_pty_addr3.value = sheetObj.CellValue(i,prefix + "pty_addr3");
	                }else if (sheetObj.CellValue(i,prefix + "edo_pty_cd") == "CN") {
	    	        	formObj.cn_pty_nm.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	    	        	if (sheetObj.CellValue(i,prefix + "pty_rgst_no").length == 10) {
	    	           		formObj.cn_pty_rgst_no.value = sSaupFormat(sheetObj.CellValue(i,prefix + "pty_rgst_no"));
	    	           	} else {
	    	           		formObj.cn_pty_rgst_no.value = sheetObj.CellValue(i,prefix + "pty_rgst_no");
	    	           	}
	                }else if (sheetObj.CellValue(i,prefix + "edo_pty_cd") == "NI") {
	    	        	formObj.ni_pty_nm.value = sheetObj.CellValue(i, prefix + "pty_nm1")+sheetObj.CellValue(i, prefix + "pty_nm2");
	    	        	if (sheetObj.CellValue(i,prefix + "pty_rgst_no").length == 10) {
	    	        		formObj.ni_pty_rgst_no.value = sSaupFormat(sheetObj.CellValue(i,prefix + "pty_rgst_no"));
	    	        	} else {
	    	        		formObj.ni_pty_rgst_no.value = sheetObj.CellValue(i,prefix + "pty_rgst_no");
	    	        	}
	                }
	            }	                
            }
        } else {
            ComShowMessage(ErrMsg);
        }
    }

    /**
     * 사업자 등록번호의 포멧을 설정한다.
     */
    function sSaupFormat(sValue) {
    	 var sDelim="-";
         var re    = null;
         var sResultVal  = null;
      	 
  		 re      = new RegExp('([0-9][0-9][0-9])([0-9][0-9])([0-9][0-9][0-9][0-9][0-9])');
  		 sResultVal  = sValue.replace(re,'$1' + sDelim + '$2' + sDelim + '$3');
  		
  		 return sResultVal;
    }                  
    /* 개발자 작업  끝 */