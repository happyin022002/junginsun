/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0668_01.js
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
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
     * @class esm_bkg_0668_03 : esm_bkg_0668_03 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0668_03() {
        this.processButtonClick     = tprocessButtonClick;
        this.setSheetObject         = setSheetObject;
        this.loadPage               = loadPage;
        this.initSheet              = initSheet;
        this.initControl            = initControl;
        this.doActionIBSheet        = doActionIBSheet;
        this.setTabObject           = setTabObject;
        this.validateForm           = validateForm;
    }

    /* 개발자 작업  */

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;
    var t1beforetab = 1;
    var t3beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    var comboObjects = new Array();
    var comboCnt = 0;
    
    var t3sheet1 = 0;
    var t3sheet1_1 = 1;
    var t3sheet1_2 = 2;
    var t3sheet1_3 = 3;
    
    var comboFlg = null;
    var cntrQtySum = 0;
    
    var chgFlag = null;
    var frt_term_cd = null;
    
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

	                case "btn_Cop":
	                	if (sheetObjects[t3sheet1].RowCount == 0) return;
	                	
	                	cntr_no = sheetObjects[t3sheet1].CellValue(sheetObjects[t3sheet1].SelectRow, "t3sheet1_cntr_no");

	                	param="?pgmNo=ESD_SCE_0001&cntr_no="+cntr_no;
	                    
//	                	ComOpenWindow("/hanjin/ESD_SCE_0001.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:650px;dialogLeft:0;dialogTop:0", true);
//	                	ComOpenWindow("/hanjin/ESD_SCE_0001.do"+param, "myWin", "scroll:no;status:no;help:no;dialogWidth:1024px;dialogHeight:650px;dialogLeft:0;dialogTop:0", true);
	                	ComOpenWindowCenter("/hanjin/ESD_SCE_0001.do"+param, "myWin", 1024, 650, true);
	                	break;
	                case "btn_Movement":
	                	if (sheetObjects[t3sheet1].RowCount == 0) return;
	                	
	                	cntr_no = sheetObjects[t3sheet1].CellValue(sheetObjects[t3sheet1].SelectRow, "t3sheet1_cntr_no").substring(0,10);
	                	var check = sheetObjects[t3sheet1].CellValue(sheetObjects[t3sheet1].SelectRow, "t3sheet1_cntr_no").substring(10);
	                	var tpsz_cd = sheetObjects[t3sheet1].CellValue(sheetObjects[t3sheet1].SelectRow, "t3sheet1_tpsz_cd");

	                	
	                	var fromDate = "";
	                	var toDate = ComGetNowInfo();
	                	
	                	if (sheetObjects[t3sheet1_2].RowCount > 0) {
	                		fromDate = ComGetMaskedValue(sheetObjects[t3sheet1_2].Cellvalue(sheetObjects[t3sheet1_2].RowCount , "t3sheet1_2_event_dt").substring(0,8), "ymd");
	                	} else {
	                		fromDate = toDate;
	                	}
	                	param="?p_cntrno=" + cntr_no + "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
          //            param="?p_cntrno=" + cntr_no + "&" + "p_date1=" + fromDate + "&" + "p_date2=" + toDate+ "&" + "check_digit=" + check + "&" + "ctnr_tpsz_cd=" + tpsz_cd + "&pgmNo=EES_CTM_0408&pop_mode=1";
	                	
	                	ComOpenWindowCenter("/hanjin/EES_CTM_0408.do" + param, "EES_CTM_0408", 1020, 682, true);

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
                
            	if (sheetObjects[i].id == "t3sheet1_3") {
                    initSheet(sheetObjects[i],i+1);            		
            	} else {
                	ComConfigSheet (sheetObjects[i] );

                    initSheet(sheetObjects[i],i+1);

                    ComEndConfigSheet(sheetObjects[i]);
            	}
            }

            for(k=0;k<tabObjects.length;k++){
                initTab(tabObjects[k],k+1);
            }

//            tabObjects[2].Visible = true; 
            
//			document.form.bkg_no.value = "TAOYTS93P05";
			
			if (document.form.bkg_no.value != "") {
				
				fnSearch();
			}
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
//            	case "sheet2":
//            	
//	                with (sheetObj) {
//	                    // 높이 설정
//	                    style.height = 0;
//	                    //전체 너비 설정
//	                    SheetWidth = mainTable.clientWidth;
//	
//	                    //Host정보 설정[필수][HostIp, Port, PagePath]
//	                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
//	
//	                    //전체Merge 종류 [선택, Default msNone]
//	                    MergeSheet = msHeaderOnly;
//	
//	                   //전체Edit 허용 여부 [선택, Default false]
//	                    Editable = true;
//	
//	                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
//	                    InitRowInfo( 1, 1, 3, 100);
//	
//	                    var HeadTitle = "ibflag|partial|bl_no|bkg_no|split_no|bl_tp_cd";
//	                    var headCount = ComCountHeadTitle(HeadTitle);
//	                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
//	                    InitColumnInfo(headCount, 0, 0, true);
//	
//	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
//	                    InitHeadMode(true, false, true, true, false,false)
//	
//	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
//	                    InitHeadRow(0, HeadTitle, true);
//	
//	                    prefix = "sheet2_";
//	                    
//	                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
//						InitDataProperty(0, cnt++ , dtHiddenStatus,     30,	daCenter,  true,	 prefix + "ibflag");
//						InitDataProperty(0, cnt++ , dtData,      	    50,	daCenter,  false,    prefix + "partial",    		false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		50,	daCenter,  false,    prefix + "bl_no",            	false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "bkg_no",   		    false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,      		30,	daCenter,  false,    prefix + "split_flg", 		    false,          "",      dfNone,      0,     false);
//						InitDataProperty(0, cnt++ , dtData,			    30,	daCenter,	false,	 prefix + "bl_tp_cd",		    false,		    "",		dfNone,			0,		false,		true);
//						
//						CountPosition = 0;
//	
//	                }
//	            	break;
			

    				case "t3sheet1":      //t3sheet1 init
	                    with (sheetObj) {
	                        // 높이 설정
	                        style.height = 85;
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
	
	                        var HeadTitle = "|Seq.|Container No.|Size|Last Event(VVD)|Date|Place(Node Code)|ACT NM";
	                        var headCount = ComCountHeadTitle(HeadTitle);
	                        
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 0, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(false, false, false, true, false,false)
	
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);
	
		                    var prefix="t3sheet1_";
	
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
	                        InitDataProperty(0, cnt++ , dtSeq,    			 40,    daCenter,  true,    prefix +"Seq");
	                        InitDataProperty(0, cnt++ , dtData,      		 110,   daCenter,  false,   prefix +"cntr_no",       false,          "",      dfNone,      0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 100,   daCenter,  false,   prefix +"tpsz_cd",       false,          "",      dfNone,      0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 300,   daCenter,  false,   prefix +"lst_event",           false,          "",      dfNone, 	   0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 130,   daCenter,  false,   prefix +"event_dt",  	 false,          "",      dfNone,      0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 250,   daLeft,    false,   prefix +"nod_cd",        false,          "",      dfNone,      0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtHidden,      		 100,   daCenter,  false,   prefix +"act_nm",        false,          "",      dfNone, 	   0,     false,       false);
	
	                        CountPosition = 0;
	                        
	                        WordWrap = true;
	                   	}
                    	break;

    				case "t3sheet1_1":      //t3sheet1_1 init
	                    with (sheetObj) {
	                        // 높이 설정
	                        style.height = 265;
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
	
	                        var HeadTitle = "|Seq|Status|Date|Origin|Destination|Carrier|Train/Truck|Flat Car|Container No.";
	                        var headCount = ComCountHeadTitle(HeadTitle);
	
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 0, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(false, false, true, true, false,false)
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);
	
	                        var prefix="t3sheet1_1_";
	                        
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                        InitDataProperty(0, cnt++ , dtHiddenStatus,    30,      daCenter,  false,     prefix +"ibflag");
	                        InitDataProperty(0, cnt++ , dtSeq,    		   40,      daCenter,  true,      prefix +"Seq");
							InitDataProperty(0, cnt++ , dtData,  	      120,	    daLeft,    false,     prefix +"mvmt_sts_nm",  				false,      "",      dfNone,      	0,		true);
							InitDataProperty(0, cnt++ , dtData,  	      110,		daCenter,  false,     prefix +"mvmt_evnt_dt",  				false,      "",      dfNone,      	0,		true);
							InitDataProperty(0, cnt++ , dtData,		      210,	    daLeft,    false,     prefix +"org_yd_cd",     	            false,      "",      dfNone,    	0,		true);
							InitDataProperty(0, cnt++ , dtData,		      210,		daLeft,    false,     prefix +"dest_yd_cd",   			    false,      "",      dfNone,      	0,		true);
							InitDataProperty(0, cnt++ , dtData,  	       80,	    daLeft,    false,     prefix +"clm_crr_nm",   			    false,      "",      dfNone,      	0,		true);
	
							InitDataProperty(0, cnt++ , dtData,  	      100,		daLeft,    false,     prefix +"trn_no",                     false,      "",      dfNone,      	0,		true);
							InitDataProperty(0, cnt++ , dtData,  	       80,		daLeft,    false,     prefix +"fcar_no",  	                false,      "",      dfNone,      	0,		true);
							InitDataProperty(0, cnt++ , dtHidden,  	       60,		daCenter,  false,     prefix +"cntr_no",     		        false,      "",      dfNone,      	0,		true);
	
	
							ScrollBar = 2;
	  					    CountPosition = 0;
			            }
	                    break;

    				case "t3sheet1_2":      //t3sheet1_2 init
	                    with (sheetObj) {
                        	// 높이 설정
	                        style.height = 262;
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
	                        var HeadTitle = "||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	                        var headCount = ComCountHeadTitle(HeadTitle);
	
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 0, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(false, false, false, true, false,false)
	
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);
	
	  	                    var prefix="t3sheet1_2_";
	
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  	                    InitDataProperty(0, cnt++ , dtHiddenStatus,    30,    daCenter,  false,   prefix +"ibflag");
	                        InitDataProperty(0, cnt++ , dtData,      	   80,    daCenter,  false,   prefix +"sts_nm",     false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	  100,    daCenter,  false,   prefix +"event_dt",   false,          "",      dfUserFormat2,     0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	  240,    daLeft,    false,   prefix +"act_nm",  	false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	   80,    daCenter,  false,   prefix +"loc_cd",     false,          "",      dfNone, 		 	0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	   90,    daCenter,  false,   prefix +"vvd",     	false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	   80,    daCenter,  false,   prefix +"seal_no",    false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	   60,    daCenter,  false,   prefix +"msg",        false,          "",      dfNone, 		 	0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	  100,    daCenter,  false,   prefix +"bl_no",      false,          "",      dfNone,   	 		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      	  110,    daCenter,  false,   prefix +"upd_dt",     false,          "",      dfUserFormat2,     0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtHidden,      	  100,    daCenter,  false,   prefix +"cntr_no",    false,          "",      dfNone,            0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtHidden,         100,    daCenter,  false,   prefix +"fcus_flg",   false,          "",      dfNone,              0,     false,       false);
	      								
	
	  						InitUserFormat2(0, prefix +"event_dt", "####-##-## ##:##", "-|:" );
	  						InitUserFormat2(0, prefix +"upd_dt", "####-##-## ##:##", "-|:" );
	  						 
	  						ScrollBar = 2;
	  						Ellipsis = true;
	  						CountPosition = 0;
	                    }
                      	break;

    				case "t3sheet1_3":      //t3sheet1_3 init
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
	                        var HeadTitle = "||Event Date|Activity|Location|VVD|Seal No.|MSG|B/L No.|Update Date|Container No.|Focus Flg";
	                        var headCount = ComCountHeadTitle(HeadTitle);
	
	                        //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	                        InitColumnInfo(headCount, 0, 0, true);
	
	                        // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                        InitHeadMode(false, false, false, true, false,false)
	
	                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                        InitHeadRow(0, HeadTitle, true);
	
	  	                    var prefix="t3sheet1_3_";
	
	                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  	                    InitDataProperty(0, cnt++ , dtHiddenStatus,      30,    daCenter,  false,   prefix +"ibflag");
	                        InitDataProperty(0, cnt++ , dtData,      		 80,    daCenter,  false,   prefix +"sts_nm",     false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 100,   daCenter,  false,   prefix +"event_dt",   false,          "",      dfUserFormat2,       0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 190,   daCenter,  false,   prefix +"act_nm",  	  false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 110,   daCenter,  false,   prefix +"loc_cd",     false,          "",      dfNone, 		 		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 110,   daCenter,  false,   prefix +"vvd",     	  false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 100,   daCenter,  false,   prefix +"seal_no",    false,          "",      dfNone,      		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 80,    daCenter,  false,   prefix +"msg",        false,          "",      dfNone, 		 		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 100,   daCenter,  false,   prefix +"bl_no",      false,          "",      dfNone,   	 		0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtData,      		 100,   daCenter,  false,   prefix +"upd_dt",     false,          "",      dfUserFormat2,       0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtHidden,        	 100,   daCenter,  false,   prefix +"cntr_no",    false,          "",      dfNone,              0,     false,       false);
	                        InitDataProperty(0, cnt++ , dtHidden,            100,   daCenter,  false,   prefix +"fcus_flg",   false,          "",      dfNone,              0,     false,       false);
	      							
	
	  						InitUserFormat2(0, prefix +"event_dt", "####-##-## ##:##", "-|:" );
	  						InitUserFormat2(0, prefix +"upd_dt", "####-##-## ##:##", "-|:" );
	                    }
    					break;
                      
                        
            }
        }

      // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
            //sheetObj.ShowDebugMsg = false;
            switch(sAction) {

               case IBSEARCH:      //조회
                    
                	ComOpenWait(true);

           			sheetObjects[t3sheet1].WaitImageVisible = false;
           			
           			formObj.f_cmd.value = SEARCH;

           			var aryPrefix = new Array("t3sheet1_", "t3sheet1_1_", "t3sheet1_3_"); //prefix 문자열 배열
                    var sXml = sheetObj.GetSearchXml("ESM_BKG_0668_03GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	        		
	         		var arrXml = sXml.split("|$$|");
	
         			sheetObjects[t3sheet1].Redraw = false;
         			sheetObjects[t3sheet1].WaitImageVisible = false;
         			sheetObjects[t3sheet1].LoadSearchXml(arrXml[0]);
         			sheetObjects[t3sheet1].Redraw = true;

         			sheetObjects[t3sheet1_1].Redraw = false;
         			sheetObjects[t3sheet1_1].WaitImageVisible = false;
         			sheetObjects[t3sheet1_1].LoadSearchXml(arrXml[1]);
         			sheetObjects[t3sheet1_1].Redraw = true;

         			sheetObjects[t3sheet1_3].Redraw = false;
         			sheetObjects[t3sheet1_3].WaitImageVisible = false;
         			sheetObjects[t3sheet1_3].LoadSearchXml(arrXml[2]);
         			sheetObjects[t3sheet1_3].Redraw = true;

//         			sheetObjects[sheetObjects.length-1].Redraw = false;
//         			sheetObjects[sheetObjects.length-1].WaitImageVisible = false;
//         			sheetObjects[sheetObjects.length-1].LoadSearchXml(arrXml[3]);
//         			sheetObjects[sheetObjects.length-1].Redraw = true;
		         		
	         		sheetObjects[t3sheet1].WaitImageVisible = true;
	         		ComOpenWait(false);

                    break;

    			case COMMAND04:
					formObj.f_cmd.value = SEARCH04;
            	 	document.form.xmlData.value = null;
					
		        	sheetObj.DoSearch("ESM_BKG_0668_03GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("t3sheet1_1_"));
		        	break;
            }
        }




        /**
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
        function setTabObject(tab_obj){
            tabObjects[tabCnt++] = tab_obj;
        }


        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initTab(tabObj , tabNo) {
             
        	 switch(tabNo) {
                 case 1:
                   	 with (tabObj) {

                         var cnt  = 0 ;
                         InsertTab( cnt++ , "CLM" , -1 );
                         InsertTab( cnt++ , "General" , -1 );

              			BaseColor = "#F3F2F8";             			
                    }
                 break;

             }
        }

        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         *  B/L Info 안에 들어있는 텝
         */
        function t3tab1_OnChange(tabObj , nItem)
        {


            var objs = document.all.item("t3tabLayer");

    	    	objs[nItem].style.display = "Inline";
    	    	objs[t3beforetab].style.display = "none";


    	    	//--------------- 요기가 중요 --------------------------//
    	    	objs[t3beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
    	    	//------------------------------------------------------//
    	    	t3beforetab= nItem;
    	    	
        }

        /** 
         * isFloat(str) : 숫자값인지 체크, '.' 포함
         */ 
         function isFloat(fVal) {
         	var temp = 0;
         	var sVal = null;
         	
         	
         	var sIdx = fVal.toString().indexOf(".");
         	
         	if (sIdx > 0) {
 	        	var sTemp = fVal.toString();
         		
         		sVal = sTemp.substring(parseInt(sIdx) + 1);
 	        	
 	        	if (parseInt(sVal) > 0 ) {
 	        		return true;
 	        	} else {
 	        		return false;
 	        	}
         	} else {
         		return false;
         	}
         }
 	   
       /**
        * t3sheet1_3의 값이 존재하는 경우, t3sheet1_3 첫번째 Row의 Container에 해당하는 정보를 t3sheet1_3에서 읽어서 t3sheet1_2에 표시한다. 
        */
       function t3sheet1_3_OnSearchEnd(sheetObj, ErrMsg){
           var cntrNo = null;
           var emptyXml = "<SHEET>	<DATA  TOTAL='0'> </DATA> </SHEET>";
           
           if (ErrMsg == "") {
          	 	
           	
           	if(sheetObj.RowCount > 0){
          	 		cntrNo = sheetObjects[t3sheet1].CellValue(1, "t3sheet1_cntr_no");
          	 		
          	 		//t3sheet1_3에 값이 존재하는지를 체크한다. 값이 없는 경우에는 t3sheet1_2를 모두 지운다.
          	 		if (sheetObjects[t3sheet1_3].RowCount > 0) {
          	 			
          	 			copyMovementDetail(cntrNo);
          	 		} else {
          	 			
//          	 			sheetObjects[t3sheet1_2].RemoveAll();
          	 			sheetObjects[t3sheet1_2].LoadSearchXml(emptyXml);
          	 		}
               } else {
//               	sheetObjects[t3sheet1_2].RemoveAll();
            	   sheetObjects[t3sheet1_2].LoadSearchXml(emptyXml);
               }
           }
       }
       
        /**
         * t3sheet1_3의 값이 존재하는 경우, t3sheet1_3 첫번째 Row의 Container에 해당하는 정보를 t3sheet1_3에서 읽어서 t3sheet1_2에 표시한다. 
         */
        function t3sheet1_OnDblClick(sheetObj, row, col){
       	    if (sheetObj.RowCount > 0) {
       		 
	       		var cntrNo = sheetObj.CellValue(row, "t3sheet1_cntr_no");
	  	 	
	       		copyMovementDetail(cntrNo);
	       		
	       		document.form.h_mov_cntr_no.value = cntrNo;
	       		
	       		sheetObjects[t3sheet1_1].RemoveAll();
	       		
    			doActionIBSheet(sheetObjects[t3sheet1_1],document.form,COMMAND04);
       	    }
        }
       
       function copyMovementDetail(cntrNo) {
			sheetObjects[t3sheet1_2].RemoveAll();	//모든 Row를 지운 후, 값을 비교하여 Container No가 일치하는 것만 넣어준다.
			
			var prefix7 = "t3sheet1_2_";
			var prefix8 = "t3sheet1_3_";
			var fcusRow = 0;
			var row7 = 0;
			for(i=0;i<sheetObjects[t3sheet1_3].RowCount;i++){
			   	if (sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "cntr_no") == cntrNo) {
			   		row7 = sheetObjects[t3sheet1_2].DataInsert(-1);			//마지막 열에 Row를 추가한다.
			
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "sts_nm")     = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "sts_nm"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "event_dt")   = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "event_dt"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "act_nm")     = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "act_nm"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "loc_cd")     = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "loc_cd"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "vvd")        = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "vvd"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "seal_no")    = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "seal_no"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "msg")        = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "msg"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "bl_no")      = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "bl_no"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "upd_dt")     = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "upd_dt"); 
					sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "cntr_no")    = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "cntr_no"); 
	                sheetObjects[t3sheet1_2].CellValue2(row7,prefix7+ "fcus_flg")   = sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "fcus_flg");
	                
	                if (sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "fcus_flg") == "Y") {
	                	fcusRow = row7;
	                }
					
	                if (sheetObjects[t3sheet1_3].CellValue(i+1,prefix8+ "sts_nm") != "Actual") {
	                    sheetObjects[t3sheet1_2].RowBackColor(row7) = sheetObjects[t3sheet1_2].RgbColor(102, 204, 0);
	                }
	                
			   	}
		   }
			
           sheetObjects[t3sheet1_2].SelectRow = fcusRow;

       }

       /**
        * t1sheet1_2의 조회가 완료된 시점에 값을 설정한다.
        */
        function t1sheet1_2_OnSearchEnd(sheetObj, ErrMsg){
        	var invTotBilAmt = 0;
        	
        	if (ErrMsg == "") {
                if(sheetObj.RowCount > 0){
                	if (cntrQtySum > 0 && isFloat(cntrQtySum) == false) {				//Container의 값이 정수인 경우
                		if (cntrQtySum != sheetObj.RowCount) {		//Container의 값과 t1sheet3.RowCount의 값이 틀리면 t1sheet2의 값을 파란색 굵은 문자로 설정한다. 
                			
                			for(var i=1; i<=sheetObjects[t1sheet3].RowCount; i++) {
	                			sheetObjects[t1sheet3].CellFont("FontBold", i,"t1sheet3_bkg_qty", i, "t1sheet3_cntr_qty") = true;			//Bold 값을 설정
	                			sheetObjects[t1sheet3].CellFontColor(i, "t1sheet3_bkg_qty" ) = sheetObjects[t1sheet3].RgbColor(0, 0, 255);	//파란색 설정
	                			sheetObjects[t1sheet3].CellFontColor(i, "t1sheet3_cntr_qty" ) = sheetObjects[t1sheet3].RgbColor(0, 0, 255);	//파란색 설정
                			}
                		}
                	}
                	
                	for(var j=1; j<=sheetObj.RowCount; j++) {
                		if (parseFloat(sheetObj.CellValue(j,"t1sheet1_2_cntr_wgt")) > 25000) {
                			sheetObj.CellFont("FontBold", j,"t1sheet1_2_cntr_wgt") = true;					//Bold 값을 설정
                			sheetObj.CellFontColor(j, "t1sheet1_2_cntr_wgt" ) = sheetObj.RgbColor(255, 0, 0);	//빨강색 설정
                		}
                		
                        invTotBilAmt += parseInt(sheetObjects[t1sheet1_2].CellValue(j, "t1sheet1_2_paid_amt"));	//돈 준 것을 저장함                		

						if (sheetObj.CellValue(j, "t1sheet1_2_dcgo_flg") == "Y") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_dcgo_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_bb_cgo_flg") == "Y") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_bb_cgo_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_in_ga_flg") == "OUT") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg") = 0;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_in_ga_flg") = 1;
						}

						if (sheetObj.CellValue(j, "t1sheet1_2_cdo_temp") == "N") {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp") = 1;
						} else {
							sheetObj.PopupButtonImage(j, "t1sheet1_2_cdo_temp") = 0;
						}                	
                	}

                	
                	document.form.invTotBilAmt.value = invTotBilAmt;
                }
        	}        	
        }
       
	     
     /**
     * 화면의 버튼을 비 활성화 시킨다.
     */
    function buttonColorSet(btn_name, color){
	   	var tds = document.getElementsByTagName("td");
	   	var curFlag = null;
	   	 
	   	if (color == 'red') {
	   		curFlag = "hand";
	   	} else {
	   		curFlag = "default";
	   	}
   	 
        for(var i = 0; i < tds.length; i++) {
            var td=tds[i];

            if(td.name == '•' + btn_name){
           	 td.style.color = color;
           	 td.style.cursor = curFlag;
           	 
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value = color;
           	 }
                break;
            }else if(td.name == btn_name){
           	 td.style.color = color;
           	 td.style.cursor = curFlag;
           	 
           	 if (btn_name == "btn_split") {
           		 document.form.h_split.value = color;
           	 }
                break;
            }else{
           	 continue;
            }
        }
    }

   /**
    *  t3sheet1_OnSearchEnd 이벤트 처리
    */
    function t3sheet1_OnSearchEnd(sheetObj, ErrMsg){
        
    	
    	if (ErrMsg != "") {
			fnMovementClear();
        }
    	
    	if (sheetObj.RowCount > 0) {
        	buttonColorSet("btn_Cop", 'red');
        	buttonColorSet("btn_Movement", 'red');
      	} else {
        	buttonColorSet("btn_Cop", 'gray');
        	buttonColorSet("btn_Movement", 'gray');
        }	        	
    }

    function fnMovementClear() {
    	sheetObjects[t3sheet1].RemoveAll();
    	sheetObjects[t3sheet1_1].RemoveAll();
    	sheetObjects[t3sheet1_2].RemoveAll();
    	sheetObjects[t3sheet1_3].RemoveAll();
    }

	        
	        
    //화면의 조회 처리 모듈을 통합적으로 관리한다.
    function fnSearch() {
   		doActionIBSheet(sheetObjects[t3sheet1],document.form,IBSEARCH);        						
    }

    function fnQueryExec(bkg_no) {
    	if (bkg_no != "") {
        	
    		document.form.bkg_no.value = bkg_no;
    		fnSearch();
        }     	
    }    
/* 개발자 작업  끝 */