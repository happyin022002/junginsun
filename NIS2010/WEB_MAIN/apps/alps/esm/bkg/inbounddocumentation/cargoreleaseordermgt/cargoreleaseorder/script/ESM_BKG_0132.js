/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0132.js
*@FileTitle : Cargo Release Order_E-D/O inquiry _Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.16 안진응
* 1.0 Creation
===============================================
==========*/
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
     * @class esm_bkg_0132 : esm_bkg_0964 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0132() {
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
    	var sheetObject1 = sheetObjects[0];
    	var sheetObject2 = sheetObjects[1];
    	var sheetObject3 = sheetObjects[2];
        /*******************************************************/
        var formObject = document.form;

       	try {
       		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;				
				
				case "btn_self":

	                var iCheckRow = sheetObject1.CheckedRows("sheet1_del_chk");
	    			if(iCheckRow <= 0){
	    				ComShowCodeMessage('BKG40075');
	    			   return;
	    			}else if(iCheckRow > 40){
	    				ComShowCodeMessage('BKG06146');
	    				 return;
	    			}
	                
	                
					doActionIBSheet(sheetObject1,document.form,SEARCH03);
				break;							
				
				case "btn_boseApproval":
					
					var iCheckRow = sheetObject1.CheckedRows("sheet1_del_chk");
	    			if(iCheckRow <= 0){
	    				ComShowCodeMessage('BKG40075');
	    			   return;
	    			}else if(iCheckRow > 40){
	    				ComShowCodeMessage('BKG06146');
	    				 return;
	    			}
	    			
					doActionIBSheet(sheetObject1,document.form,SEARCH04);
				break;
				
				case "btn_Retrieve2":
					doActionIBSheet(sheetObject3,document.form,SEARCH02);
				break;
				
				case "btn_downexcel":
             		if(sheetObject1.rowcount < 1){//결과가 없을경우
             			ComShowCodeMessage("BKG00109");             			
             		}else{    								
             			sheetObject1.Down2Excel(true);
             		}
				break;
				
				case "btn_delete":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
					break;
				break;														
				
				case "btn_cargo":
					var curRow = sheetObject1.SelectRow;
             		
             		var bkgNo = "";
             		if (curRow > 1) {
             			bkgNo = sheetObject1.CellValue(curRow ,"sheet1_bkg_no");
             		} 
	        		
					var param="?bkg_no="+bkgNo+"&pgmNo=ESM_BKG_0682";
					
//					ComOpenWindow("/hanjin/ESM_BKG_0682.do"+param, "myWin", "scroll:auto;status:no;help:no;dialogWidth:1024px;dialogHeight:768px;dialogLeft:0;dialogTop:0", false);
					
					ComOpenWindowCenter("/hanjin/ESM_BKG_0682.do"+param, "ESM_BKG_0682", 1024, 878, false, 'yes');
				break;
				
				case "btn_do":
             		if(sheetObject1.rowcount < 1){//결과가 없을경우
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		
             		var curRow = sheetObject1.SelectRow;
             		
	        		var rqstNo = sheetObject1.CellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd   =  "5JN";
	        		var rqstSeq5jn =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jk");
					
	        		if (rqstSeq5jn == "") {
//	        			alert("D/O 신청명세 자료가 존재하지 않습니다.");      
	        			ComShowCodeMessage("BKG03055");	        			
             			return false;
	        		}
	        		
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0133";
					
					ComOpenWindow("/hanjin/ESM_BKG_0133.do"+param, "myWin", "dialogWidth:940px;dialogHeight:720px;dialogLeft:0;dialogTop:0", true);
				break;																					
								
				case "btn_jaga":
					if(sheetObject1.rowcount < 1){//결과가 없을경우
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		
             		var curRow = sheetObject1.SelectRow;
             		
	        		var rqstNo = sheetObject1.CellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd   =  "5JM";
	        		var rqstSeq5jn =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jk");

	        		if (rqstSeq5jm == "") {
//	        			alert("자가운송명세 자료가 존재하지 않습니다.");
	        			ComShowCodeMessage("BKG03055");
             			return false;
	        		}
	        		
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0136";
					
					ComOpenWindow("/hanjin/ESM_BKG_0136.do"+param, "myWin", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:670px;dialogLeft:0;dialogTop:0", true);
 
    			break;	
    							
    			case "btn_bose":
					if(sheetObject1.rowcount < 1){//결과가 없을경우
             			ComShowCodeMessage("BKG00149");       
             			return false;
             		}
             		
             		var curRow = sheetObject1.SelectRow;
             		
	        		var rqstNo = sheetObject1.CellValue(curRow ,"sheet1_edo_rqst_no");
	        		var tpCd   =  "5JK";
	        		var rqstSeq5jn =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jn");
	        		var rqstSeq5jm =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jm");
	        		var rqstSeq5jk =  sheetObject1.CellValue(curRow,"sheet1_edo_rqst_seq_5jk");
					
	        		if (rqstSeq5jk == "") {
//	        			alert("보세운송명세 자료가 존재하지 않습니다.");
	        			ComShowCodeMessage("BKG03055");
             			return false;
	        		}
	        		
					var param="?edo_rqst_no="+rqstNo+"&edo_tp_cd="+tpCd;
				    param+="&edo_rqst_seq_5jn="+rqstSeq5jn+"&edo_rqst_seq_5jm="+rqstSeq5jm; 
					param+="&edo_rqst_seq_5jk="+rqstSeq5jk+"&pgmNo=ESM_BKG_0135";
					
					ComOpenWindow("/hanjin/ESM_BKG_0135.do"+param, "myWin", "scroll:auto;status:no;help:no;dialogWidth:960px;dialogHeight:670px;dialogLeft:0;dialogTop:0", true);
				break;
				
				case "btn_check":
             		var curRow = sheetObject1.SelectRow;
             		
             		var blNo = "";
             		if (curRow > 1) {
             			blNo = sheetObject1.CellValue(curRow ,"sheet1_bl_no");
             		} 
	        		
	        		var fromDt = document.form.edo_rqst_dt_s.value;
	        		var toDt = document.form.edo_rqst_dt_e.value;
					
					var param="?edo_rqst_dt_s="+fromDt+"&edo_rqst_dt_e="+toDt;
					param+="&bl_no="+blNo+"&pgmNo=ESM_BKG_0134";
					
					ComOpenWindowCenter("/hanjin/ESM_BKG_0134.do"+param, "myWin", 1000, 630, true);
				break;							

//                case "btns_calendar1":
//                    var cal = new ComCalendar();                    
//                    cal.select(formObject.edo_rqst_dt_s, 'yyyy-MM-dd');
//                break;

                case "btns_calendar2":
//                    var cal = new ComCalendar();
//                    cal.select(formObject.edo_rqst_dt_e, 'yyyy-MM-dd');

					var cal = new ComCalendarFromTo();
					cal.select(formObject.elements["edo_rqst_dt_s"], formObject.elements["edo_rqst_dt_e"],'yyyy-MM-dd');

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
		
		    initControl();
		    ComBtnDisable("btn_boseApproval");
		    ComBtnDisable("btn_self");
            //2009-10-26 임진영
            if(document.getElementById("autoSearchFlg").value =='Y'){
                doActionIBSheet(sheetObjects[0], document.form,IBSEARCH);
            }
		}


		/**
		 * 화면의 Control의 초기값과 이벤트를 설정한다.
		 */
		function initControl() {
			var formObject = document.form;
			formObject.edo_rqst_dt_s.value = ComGetNowInfo("ymd", "");	//현재일자를 설정
			formObject.edo_rqst_dt_e.value = ComGetNowInfo("ymd", "");	//현재일자를 설정
			   
			axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form); //- form 전체 컨트롤 중 rdoCity를 제외한 모든 컨트롤의 OnBeforeDeactivate이벤트에 코드 처리
			axon_event.addListenerForm  ('beforeactivate',   'obj_activate',    form);
			axon_event.addListenerFormat('keypress',         'obj_keypress',    form); //- 키보드 입력할때

			ComBtnDisable("btn_Retrieve2");
			axon_event.addListener("change","obj_change", "edo_tp_cd"); //Doc.Type
			
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
                case "sheet1":      //sheet1 init
                    with (sheetObj) {
                        // 높이 설정
                        style.height = 402;
                                            
                        //전체 너비 설정
                        SheetWidth = mainTable.clientWidth;

                        //Host정보 설정[필수][HostIp, Port, PagePath]
                        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                        //전체Merge 종류 [선택, Default msNone]
                        MergeSheet = msHeaderOnly;

                        //전체Edit 허용 여부 [선택, Default false]
                        Editable = true;

                        //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                        InitRowInfo( 2, 1, 3, 100);

    					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                        InitColumnInfo(35, 4, 0, true);

                        // 해더에서 처리할 수 있는 각종 기능을 설정한다(Sort, Move, AllCheck, UserResize, RowMove, Head 3D)
                        InitHeadMode(true, false, true, true, false,false)

                        var HeadTitle1 = "| |No|B/L No|신청업체|신청업체|POD|DEL|DEL Term|Cargo Type|Warehouse|D/O 신청|D/O 신청|D/O 신청|D/O 발급|D/O 발급|자가운송|자가운송|자가운송|자가운송|보운|보운|ARRIVAL VESSEL|ARRIVAL VESSEL|B/L Type|D/O Release ID|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|RQST_NO|RLSE_FLG";
                        var HeadTitle2 = "| |No|B/L No|신청업체|신청업체|POD|DEL|DEL Term|Cargo Type|Warehouse|H.Sts|Request Date|접수지|Approval Date|H.OFC|H.Sts|Request Date|Approval Date|Approval User ID|H.Sts|Request Date|VVD|DATE|B/L Type|D/O Release ID|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|RQST_NO|RLSE_FLG"; 
                                            
                        //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                        InitHeadRow(0, HeadTitle1, true);
                        InitHeadRow(1, HeadTitle2, true);
                        
                        
                        SetMergeCell(0,4,2,2);
                        var prefix="sheet1_";

                        //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
    	                InitDataProperty(0, cnt++ , dtHiddenStatus,	     0,    daCenter,    true,  	  prefix + "ibflag");
    	                InitDataProperty(0, cnt++ , dtCheckBox,         30,    daCenter,    true,     prefix + "del_chk",             false,    "",      dfNone,            0,     true,        true);//,-1 , false, true,"" ,true);    
//    	                InitDataProperty(0, cnt++ , dtCheckBox,  		20,    	daCenter,  	false,    	prefix +"del_chk", 	false,          "",       dfNone, 		0,     		true,       true,-1,false,true,"",true);
    					InitDataProperty(0, cnt++ , dtSeq,	     	    35,    daCenter,    true,     prefix + "seq");
    					  
    					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "bl_no",      	      false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "pty_nm",              false,    "",      dfNone, 			0,     false,		false);
    					InitDataProperty(0, cnt++ , dtData,      	   30,    daCenter,      true,     prefix + "pty_flg",              false,    "",      dfNone, 			0,     false,		false);
     					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "pod_cd",       	      false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
     					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "del_cd",       	      false,    "",      dfNone, 			0,     false,		false);
     					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "de_term_cd",       	      false,    "",      dfNone, 			0,     false,		false);
     					InitDataProperty(0, cnt++ , dtData,      	    75,    daCenter,    true,     prefix + "cntr_tp_cd",       	      false,    "",      dfNone, 			0,     false,		false);
     					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "wh_nm",       	      false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
                                                                                       
    					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "do_edo_ack_cd",       false,    "",      dfNone, 			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "do_edo_rct_dt",       false,    "",      dfUserFormat2, 	0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "do_edo_rct_loc_cd",   false,    "",      dfNone,			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "rqst_edo_iss_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "hndl_ofc_cd",         false,    "",      dfNone, 			0,     false,		false);
                                                                                       
  						InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "selt_edo_ack_cd",     false,    "",      dfNone, 			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "selt_edo_rct_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "selt_edo_apr_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   120,    daCenter,    true,     prefix + "selt_edo_apr_usr_id", false,    "",      dfNone,			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "ibdt_edo_ack_cd",     false,    "",      dfNone,			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "ibdt_edo_rct_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    90,    daLeft,	    true,     prefix + "vvd",                 false,    "",      dfNone, 			0,     false,		false);
                                                                                                       
   						InitDataProperty(0, cnt++ , dtData,      	    80,    daCenter,    true,     prefix + "vsl_arr_dt",          false,    "",      dfUserFormat2,		0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    70,    daCenter,    true,     prefix + "bl_tp_cd",            false,    "",      dfNone, 			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    100,    daCenter,    true,     prefix + "do_rlse_usr_id",      false,    "",      dfNone, 			0,     false,		false);
   						InitDataProperty(0, cnt++ , dtData,      	    70,    daCenter,    true,     prefix + "delt_usr_id",         false,    "",      dfNone, 			0,     false,		false);

    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jn");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jm");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jk");
    					InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,     prefix + "edo_rqst_no");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_tp_cd");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "bkg_no");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "rqst_no");
    	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "rlse_flg");

   						InitUserFormat2(0, prefix + "do_edo_rct_dt",   "####-##-## ##:##", "-|:" );
   						InitUserFormat2(0, prefix + "rqst_edo_iss_dt", "####-##-## ##:##", "-|:" );
   						InitUserFormat2(0, prefix + "selt_edo_rct_dt", "####-##-## ##:##", "-|:" );
   						InitUserFormat2(0, prefix + "selt_edo_apr_dt", "####-##-## ##:##", "-|:" );
   						InitUserFormat2(0, prefix + "ibdt_edo_rct_dt", "####-##-## ##:##", "-|:" );																														
   						InitUserFormat2(0, prefix + "vsl_arr_dt",      "####-##-##", "-|:" );		
   						
   						//sheetObjects[0].SetMergeCell(1,5,1,2);
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
	                    InitColumnInfo(4, 0, 0, true);
	
	                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
	                    InitHeadMode(true, true, false, true, false,false)
	
	                    var HeadTitle = " |EDO_RQST_NO|EDO_TP_CD|DEL_CHK";
	
	                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	                    InitHeadRow(0, HeadTitle, true);
	
	                    //데이터속성    [ROW, COL,        DATATYPE,        WIDTH, DATAALIGN, COLMERGE, SAVENAME,           KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                    var prefix="sheet2_";
	                    
	                    InitDataProperty(0,   cnt++ ,     dtHiddenStatus,  70,    daCenter,  false,   prefix +"ibflag");
	                    InitDataProperty(0,   cnt++ ,     dtData,         100,    daCenter,  false,   prefix +"edo_rqst_no"  ,   false,     "",        dfNone,     0,          false,       true);
	                    InitDataProperty(0,   cnt++ ,     dtData,          70,    daCenter,  false,   prefix +"edo_tp_cd"    ,   false,     "",        dfNone,     0,          false,       true);
	                    InitDataProperty(0,   cnt++ ,     dtCheckBox,      70,    daCenter,  false,   prefix +"del_chk"      ,   false,     "",        dfNone,     0,          false,       true);
	
	                    CountPosition = 0;
	                  
	                }
                    break;
                case "sheet3":      //sheet3 init
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
                    InitRowInfo( 2, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(31, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다(Sort, Move, AllCheck, UserResize, RowMove, Head 3D)
                    InitHeadMode(true, false, false, true, false,false)

                    var HeadTitle1 = "| |No|B/L No|POD|DEL|Warehouse|D/O 신청|D/O 신청|D/O 신청|D/O 발급|D/O 발급|자가운송|자가운송|보운|보운|ARRIVAL VESSEL|ARRIVAL VESSEL|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|신청업체명|신청업체연락처|실화주명|실화주연락처|컨테이너타입|컨테이너QTY";
                    var HeadTitle2 = "| |No|B/L No|POD|DEL|Warehouse|H.Sts|Request Date|접수지|Approval Date|H.OFC|H.Sts|Request Date|H.Sts|Request Date|VVD|DATE|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO|신청업체명|신청업체연락처|실화주명|실화주연락처|컨테이너타입|컨테이너QTY"; 
//                    var HeadTitle1 = "| |No|B/L No|POD|DEL|Warehouse|D/O 신청|D/O 신청|D/O 신청|D/O 발급|D/O 발급|자가운송|자가운송|보운|보운|ARRIVAL VESSEL|ARRIVAL VESSEL|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO";
//                    var HeadTitle2 = "| |No|B/L No|POD|DEL|Warehouse|H.Sts|Request Date|접수지|Approval Date|H.OFC|H.Sts|Request Date|H.Sts|Request Date|VVD|DATE|Delete ID|EDO_RQST_SEQ_5JN|EDO_RQST_SEQ_5JM|EDO_RQST_SEQ_5JK|EDO_RQST_NO|EDO_TP_CD|BKG_NO"; 
                                        
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                    InitHeadRow(1, HeadTitle2, true);

                    var prefix="sheet3_";

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	                InitDataProperty(0, cnt++ , dtHiddenStatus,	     0,    daCenter,    true,  	  prefix + "ibflag");
	                InitDataProperty(0, cnt++ , dtCheckBox,         30,    daCenter,    true,     prefix + "del_chk",             false,    "",      dfNone,            0,     true,        true);    	                  
					InitDataProperty(0, cnt++ , dtSeq,	     	    35,    daCenter,    true,     prefix + "seq");
					  
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "bl_no",      	      false,    "",      dfNone, 			0,     false,		false);
//					InitDataProperty(0, cnt++ , dtData,      	   100,    daLeft,      true,     prefix + "pty_nm",              false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "pod_cd",       	      false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
 					InitDataProperty(0, cnt++ , dtData,      	    60,    daCenter,    true,     prefix + "del_cd",       	      false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "wh_nm",       	      false,    "",      dfNone, 			0,     false,		false);                                                                                                                                            	
                                                                                   
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "do_edo_ack_cd",       false,    "",      dfNone, 			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "do_edo_rct_dt",       false,    "",      dfUserFormat2, 	0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "do_edo_rct_loc_cd",   false,    "",      dfNone,			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "rqst_edo_iss_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "hndl_ofc_cd",         false,    "",      dfNone, 			0,     false,		false);
                                                                               
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "selt_edo_ack_cd",     false,    "",      dfNone, 			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "selt_edo_rct_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    50,    daCenter,    true,     prefix + "ibdt_edo_ack_cd",     false,    "",      dfNone,			0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	   100,    daCenter,    true,     prefix + "ibdt_edo_rct_dt",     false,    "",      dfUserFormat2, 	0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    90,    daLeft,	    true,     prefix + "vvd",                 false,    "",      dfNone, 			0,     false,		false);
                                                                                               
					InitDataProperty(0, cnt++ , dtData,      	    80,    daCenter,    true,     prefix + "vsl_arr_dt",          false,    "",      dfUserFormat2,		0,     false,		false);
					InitDataProperty(0, cnt++ , dtData,      	    70,    daCenter,    true,     prefix + "delt_usr_id",         false,    "",      dfNone, 			0,     false,		false);

	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jn");
	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jm");
	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_rqst_seq_5jk");
					InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,     prefix + "edo_rqst_no");
	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "edo_tp_cd");
	                InitDataProperty(0, cnt++ , dtHidden,	         0,    daCenter,    true,  	  prefix + "bkg_no");
	                
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "pty_nm",       	      false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "phn_no",       	      false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "pty_as_nm",       	  false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "phn_as_no",       	  false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "cntr_tpsz_cd",        false,    "",      dfNone, 			0,     false,		false);
 					InitDataProperty(0, cnt++ , dtData,      	   120,    daLeft,      true,     prefix + "op_cntr_qty",         false,    "",      dfNone, 			0,     false,		false); 						                

					InitUserFormat2(0, prefix + "do_edo_rct_dt",   "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "rqst_edo_iss_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "selt_edo_rct_dt", "####-##-## ##:##", "-|:" );
					InitUserFormat2(0, prefix + "ibdt_edo_rct_dt", "####-##-## ##:##", "-|:" );																														
					InitUserFormat2(0, prefix + "vsl_arr_dt",      "####-##-##", "-|:" );																														
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
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					formObj.f_cmd.value = SEARCH;
	                if(sheetObj.id == "sheet1"){
	                	sheetObj.DoSearch("ESM_BKG_0132GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
	                }
				break;
				
				
				case SEARCH02:      //조회
					//if(!validateForm(sheetObj,formObj,sAction)) return false;
					formObj.f_cmd.value = SEARCH02;
					//if(sheetObj.id == "sheet3"){
						sheetObj.DoSearch("ESM_BKG_0132GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet3_"));
						//sheetObj.Down2Excel(true);
                		sheetObj.SpeedDown2Excel(-1, false,false, "", "");
					//}
				break;
				

				case SEARCH03:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				 if( !ComShowCodeConfirm('BKG00447') ){
	                    return false;
	                }
				 formObj.f_cmd.value = SEARCH03;                
                 var prefix="sheet1_";
                 var sParamSheet = sheetObjects[0].GetSaveString(false, true, prefix + "del_chk"	);                 
     	         var sParam =  FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
     	         var sXml = sheetObj.GetSaveXml("ESM_BKG_0132GS.do", sParam);
     	       
     	         var rMsg = ComResultMessage(sXml);
     	         
                  if(rMsg != ''){
                	  var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
                	  if(State == "S"){
                		  ComShowCodeMessage("BKG00218");	
                		  sheetObjects[0].CheckAll("sheet1_del_chk") = 0; 
                	  } else {
   					
                		  ComShowMessage(rMsg);
   				  }
   			 }  
    
			   break;
			   

				case SEARCH04:      //조회
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				 if( !ComShowCodeConfirm('BKG00447') ){
	                    return false;
	                }
				formObj.f_cmd.value = SEARCH04;
				var prefix="sheet1_";
                var sParamSheet = sheetObjects[0].GetSaveString(false, true, prefix + "del_chk"	);                 
    	        var sParam =  FormQueryString(formObj)+ "&" +ComSetPrifix(sParamSheet, "");
    	        var sXml = sheetObj.GetSaveXml("ESM_BKG_0132GS.do", sParam);
    	        
    	        var rMsg = ComResultMessage(sXml);
    	         
                if(rMsg != ''){
                	var State = ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
    				if(State == "S"){
    					 					 
    					 ComShowCodeMessage("BKG00218");	
    					 sheetObjects[0].CheckAll("sheet1_del_chk") = 0; 
    				} else {
    					
    					ComShowMessage(rMsg);
    					
    				}
    			 }  
               
			   break;
				
				case IBDELETE:        //삭제
					if(!validateForm(sheetObj,formObj,sAction)) return false;
				
					if(!ComShowCodeConfirm('BKG43029')){
	                    return false;
	                }					
				
					formObj.f_cmd.value = REMOVE;
	
					var prefix="sheet1_";
					var saveString = sheetObj.GetSaveString(false, true, prefix + "del_chk");
					
	                var sParam = FormQueryString(formObj) + "&" + saveString;	                        
	                
	                sheetObj.DoSave("ESM_BKG_0132GS.do", sParam, "", false);
					
				break;    					
            }
        }

        /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
     		switch(sAction) {       	 
				case IBSEARCH:
	                if(ComIsEmpty(formObj.edo_rqst_dt_s.value) && ComIsEmpty(formObj.edo_rqst_dt_e.value)){
	                    ComShowCodeMessage('BKG00545');
	                    formObj.edo_rqst_dt_s.focus();
	                    return false;
	                }

                    var v_sdate = formObj.edo_rqst_dt_s.value;//시작일
                    var v_edate = formObj.edo_rqst_dt_e.value;//종료일

                    if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
                        ComShowCodeMessage("BKG00421");
                        formObj.edo_rqst_dt_s.focus();
                        return false;
                    }
                    
                    if(formObj.vsl_cd.value.length > 0 && formObj.vsl_cd.value.length <4){
                        ComShowCodeMessage("BKG95018","Vessel Code","4");
                        formObj.vsl_cd.focus();
                        return false;
                    }
                    
                    
	                
                    if(ComGetDaysBetween(v_edate, v_sdate) > 0){
                    	ComShowCodeMessage("BKG00421");
                        formObj.edo_rqst_dt_s.focus();
                        return false;
                    }
	                return true;
		    		break;
		    	
		    	case IBDELETE:
		    		
		    		var prefix="sheet1_";
		    		
		    	    if(document.form.delt_flg.value == "Y"){
		    	        return false;
		    	    }
		    	    
		    	    if(sheetObj.RowCount == 0){
		    	    	ComShowCodeMessage("BKG00546");
		    	        return false;
		    	    }

		    	    var sDel = sheetObj.GetSaveString(false, true, prefix + "del_chk");
		    	    
		    	    if (sDel == "") {
		    	    	ComShowCodeMessage("BKG00546");
		    	    	return false;
		    	    }
		    	    
			        break; 
     		}
     		
            return true;
        }

        /**
         * 업무 자바스크립트 OnFocus 이벤트 처리
         */
        function obj_activate() {
            var objName = event.srcElement.name;
            var formObj = document.form;
            
            switch(objName) {
                case "edo_rqst_dt_s":
                    formObj.edo_rqst_dt_s.value = formObj.edo_rqst_dt_s.value.replace(eval("/-/gi"), "");
                    break;
                case "edo_rqst_dt_e":
                    formObj.edo_rqst_dt_e.value = formObj.edo_rqst_dt_e.value.replace(eval("/-/gi"), "");
                    break;
            }
        }
            
        /**
        * 업무 자바스크립트 Blur 이벤트 처리
        */
        function obj_deactivate(){
            //입력Validation 확인 및 마스킹 처리
            ComChkObjValid(event.srcElement);
        }

        /**
         * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
         **/
        function obj_keypress(){
            switch(event.srcElement.dataformat){
                case "float":
                    //숫자+"."입력하기
                    ComKeyOnlyNumber(event.srcElement, ".");
                    break;
                case "eng":
                    //영문만 입력하기, 영문+숫자 -> ComKeyOnlyAlphabet('num');
                    //ComKeyOnlyAlphabet();
                    ComKeyOnlyAlphabet('uppernum', '8|32');
                    break;
                case "engdn":
                    //영문 소문자만 입력하기, 영문소+숫자 -> ComKeyOnlyAlphabet('lowernum');
                    ComKeyOnlyAlphabet('lower', '8|32');
                    break;
                case "engup":
                    //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
                    ComKeyOnlyAlphabet('upper', '8|32');
                    break;
                default:	
                    //숫자만입력하기(정수,날짜,시간)
                    ComKeyOnlyNumber(event.srcElement);
            }
        }
        
        /**
         * Hidden IBSheet를 조회하고 나서 처리할 사항
         */
        function sheet1_OnSearchEnd(sheetObj, ErrMsg){
        	var formObj = document.form;
        	
            if (ErrMsg == "") {
                if(sheetObj.RowCount > 0){
                    //Grid의 Data를 Html의 인자값으로 Copy한다.
            		formObj.frm_sheet2_edo_rqst_no.value = sheetObj.CellValue(2,"sheet1_edo_rqst_no");
            		formObj.frm_sheet2_edo_tp_cd.value = sheetObj.CellValue(2,"sheet1_edo_tp_cd");
                }
            } else {
                ComShowMessage(ErrMsg);
            }
            
            if(formObj.edo_tp_cd.value =="5JM"){
            	//자가운송
            	ComBtnEnable("btn_self");
				ComBtnDisable("btn_boseApproval");
            }else if(formObj.edo_tp_cd.value =="5JK"){
            	//보세운송
            	ComBtnEnable("btn_boseApproval");
				ComBtnDisable("btn_self");
            }else if(formObj.edo_tp_cd.value =="5JN"){
            	ComBtnDisable("btn_self");
            	ComBtnDisable("btn_boseApproval");
            }
        
            for(i=0; i< sheetObjects[0].RowCount+2; i++){
            	if(sheetObj.CellValue(i,"sheet1_rlse_flg") == "N"){
            	  sheetObj.CellEditable(i,"sheet1_del_chk") = false;
              }
            }
            
            buttonControl();
         }

        /**
         * IBSheet Object를 마우스로 클릭한경우
         */
        function sheet1_OnClick(sheetObj, Row, Col, Value) {
        	var formObj = document.form;

        	if (Row > 1) {
        		
        		if (Col == 1) {
	        		if (sheetObj.CellValue(Row,"sheet1_del_chk") == true) {
//	                  2010.04.09 수정 지침에 따라서 수정(안진응)
//	        			sheetObj.CellValue2(Row,"sheet1_ibflag") = "";	        			
	        			sheetObj.RowStatus(Row) = "";
	        		} else {
//		                  2010.04.09 수정 지침에 따라서 수정(안진응)
//	        			sheetObj.CellValue2(Row,"sheet1_ibflag") = "U";
	        			sheetObj.RowStatus(Row) = "U";
	        		}
        		}
        	}
        }    

        /**
         * sheet1를 저장하고 나서 처리할 사항
         */
        function sheet1_OnSaveEnd(sheetObj, ErrMsg){

            if (ErrMsg == "") {
                doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
                ComBkgSaveCompleted();  //서버메세지 처리
            }
        }         
          
        /**
        * 화면의 버튼을 제어한다.
        */
        function buttonControl(){
           	if (document.form.delt_flg.value == "Y") {
          		ComBtnDisable("btn_delete");
          	} else {
          		ComBtnEnable("btn_delete");
          	}
        }
          
         /**
          * 엔터키 수행 시 조회 함수 호출
          */
        function enterKeySearch(){
            var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
            var formObject = document.form;
            var srcName = window.event.srcElement.getAttribute("name");

            if(ComIsEmpty(srcName)){
                return;
            }

            // 엔터키(13)이면
            if (keyCode == 13) {
	            if(ComIsEmpty(formObject.edo_rqst_dt_s.value) && ComIsEmpty(formObject.edo_rqst_dt_e.value)){
	            	ComShowCodeMessage('BKG00545');
	                formObject.edo_rqst_dt_s.focus();
	                return false;
	            }

                var v_sdate = formObject.edo_rqst_dt_s.value;//시작일
                var v_edate = formObject.edo_rqst_dt_e.value;//종료일

                if(!ComIsDate(v_sdate, 'yyyy-MM-dd') || !ComIsDate(v_edate, 'yyyy-MM-dd')){
                	ComShowCodeMessage("BKG00421");
                    formObject.edo_rqst_dt_s.focus();
                    return false;
                }
	                
                if(ComGetDaysBetween(v_edate, v_sdate) > 0){
                	ComShowCodeMessage("BKG00421");
                    formObject.edo_rqst_dt_s.focus();
                    return false;
                }

                doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
            } // end if
        }               
          
          /**
           * Change 이벤트를 처리한다.<br>
           * 2010.06.23 곽영범 추가 : [Doc.Type]이 자가운송일 경우에만 [자가운송 D/L]버튼을 활성화한다. 
           * @return 없슴
           */
          function obj_change() {
        	  var form = document.form;
         	    switch(event.srcElement.name) {
                  case "edo_tp_cd":
					if(form.edo_tp_cd[1].selected) {	
						ComBtnEnable("btn_Retrieve2");
					}
					else
					{
						ComBtnDisable("btn_Retrieve2");
					}
                  	break;
         	    }
          }
          
    /* 개발자 작업  끝 */