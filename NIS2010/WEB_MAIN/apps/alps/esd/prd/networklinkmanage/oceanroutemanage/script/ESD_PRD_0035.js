//* csr N200903120230 20080414  [PRD] Ocean Route 기능 보완
//* CSR : CHM-201005409-01 : OCEAN ROUTE CREATION시, Dummy Ocean Route 생성 방지를 위한 Validation 추가요청.
// 공통전역변수 

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
         var sheetObject1 = sheetObjects[1];
         /*******************************************************/
         var formObject = document.form;
        
    	try {
    		var srcName = window.event.srcElement.getAttribute("name");

            switch(srcName) {

        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;

        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
        	        break;

        	    case "btn_save":
    	            doActionIBSheet(sheetObject,formObject,IBSAVE);
        	        break;

        	    case "btn_downexcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;

        	    case "btn_loadexcel":
        	        doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
        	        break;

        	    case "btng_rowadd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;

        	    case "btng_rowcopy":
      	            doActionIBSheet(sheetObject,formObject,IBCOPYROW);
        	        break;
        	        
        	    case "btng_rowdel":
        	    	doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;
        	        
        	    case "btn_ok":
					doSetValue(sheetObject,formObject);
        	        break;

        	    case "btn_close":
      	            self.close();
        	        break;


            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
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
        //CHM-201005409-01 의거 추가 
        if(CRUD == "R") {
			ComBtnDisable("btn_ok");
			ComBtnDisable("btng_rowadd");
			ComBtnDisable("btng_rowcopy");
			ComBtnDisable("btng_rowdel");
		}
        var formObject = document.form;
        doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
    }

   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;

        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                    //전체 너비 설정
                    style.height = GetSheetHeight(15) ;
                    //style.height = 270 ;
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
                    InitColumnInfo(60, 4, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle = "Seq.|Chk|STS|OCN Flag|RMK|RMK|Validation date|Priority|POL|1st Link|1st Link|1st Link|1st Link|2nd Link|2nd Link|2nd Link|2nd Link|3rd Link|3rd Link|3rd Link|3rd Link|4th Link|4th Link|4th Link|4th Link|POD|DIR1|FDRFLG1|DIR2|FDRFLG2|DIR3|FDRFLG3|DIR4|FDRFLG4|PRIOR|TTIME|TTDY|TTHR|TT1|TT2|TT3|TT4|STIMIE|STDY|STHR|ST1|ST2|ST3|TSIND|FU|POD1ETB|POL2ETB|POD2ETB|POL3ETB|POD3ETB|POL4ETB|LNKCNT|";
                    var HeadTitle1 ="Seq.|Chk|STS|OCN Flag|Type|Note|Validation date|Priority|POL|Pol|Lane|Type|Pod|Pol|Lane|Type|Pod|Pol|Lane|Type|Pod|Pol|Lane|Type|Pod|POD|";

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, true);
                    InitHeadRow(1, HeadTitle1, true);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtSeq,       30,   daCenter,  true,    "s_seq",              false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,   daCenter,  true,    "s_chk",              false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtStatus,    30,   daCenter,  true,    "ibflag",             false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtCombo,     70,   daCenter,  true,    "s_route_flg",        true,   "",       dfNone,     0,     true,       true);
                    
                    //InitDataProperty(0, cnt++ , dtComboEdit, 140,  daCenter,  true,    "s_route_rmk",        true,   "",       dfNone,     0,     true,       true);
                    
                    InitDataProperty(0, cnt++ , dtCombo,       60,    daLeft,  true,    "s_route_rmk",      false,          "",       dfNone, 	0,     true,       true);
					InitDataProperty(0, cnt++ , dtData,       100,    daLeft,  true,    "s_route_note",      false,          "",       dfNone, 	0,     false,       false);
					InitDataProperty(0, cnt++,  dtPopupEdit,  100,    daCenter,true,    "s_ocn_rout_tmp_exp_dt",false,          "",       dfDateYmd,    0,     true,       true);
					
                    InitDataProperty(0, cnt++ , dtHidden,    70,   daCenter,  true,    "s_prior",            false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "s_pol",              true,   "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_pol1",             false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,    "s_ts1_lane",         false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_ts1_type",         false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 50,   daCenter,  true,    "s_pod1",             false,  "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_pol2",             false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,    "s_ts2_lane",         false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_ts2_type",         false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 50,   daCenter,  true,    "s_pod2",             false,  "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_pol3",             false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,    "s_ts3_lane",         false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_ts3_type",         false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 50,   daCenter,  true,    "s_pod3",             false,  "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_pol4",             false,  "",       dfNone,     0,     false,      false);
                    InitDataProperty(0, cnt++ , dtData,      40,   daCenter,  true,    "s_ts4_lane",         false,  "",       dfNone,     0,     false,       true);
                    InitDataProperty(0, cnt++ , dtData,      50,   daCenter,  true,    "s_ts4_type",         false,  "",       dfNone,     0,     false,       false);
                    InitDataProperty(0, cnt++ , dtPopupEdit, 50,   daCenter,  true,    "s_pod4",             false,  "",       dfNone,     0,     false,       true,5);
                    InitDataProperty(0, cnt++ , dtData,      70,   daCenter,  true,    "s_pod",              false,  "",       dfNone,     0,     false,       false);
    
                    //HIDDEN
                    InitDataProperty(0, cnt++ , dtHidden,    50,   daCenter,  true,    "s_dir1",             false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    40,   daCenter,  true,    "s_fdr_flg1",         false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    50,   daCenter,  true,    "s_dir2",             false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    40,   daCenter,  true,    "s_fdr_flg2",         false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    50,   daCenter,  true,    "s_dir3",             false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    40,   daCenter,  true,    "s_fdr_flg3",         false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    50,   daCenter,  true,    "s_dir4",             false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    40,   daCenter,  true,    "s_fdr_flg4",         false,  "",       dfNone,     0,     false,      true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_t_time",           false,  "|s_t_t1|+|s_t_t2|+|s_t_t3|+|s_t_t4|",       dfNone,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_t_t_dy",           false,  "Int(|s_t_time|/24)",  dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_t_t_hr",           false,  "|s_t_time|%24",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_t_t1",    false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_t_t2",    false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_t_t3",    false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_t_t4",    false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_s_time",           false,  "|s_s_t1|+|s_s_t2|+|s_s_t3|",       dfNone,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_s_t_dy",           false,  "Int(|s_s_time|/24)",  dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    75,   daCenter,  true,    "s_s_t_hr",           false,  "|s_s_time|%24",       dfUserFormat2,   0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_s_t1", false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_s_t2", false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_s_t3", false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_ts_ind",           false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    70,   daCenter,  true,    "s_f_u",              true,   "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pod1_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pol2_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pod2_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pol3_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pod3_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_pol4_etb",         false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_lnk_cnt",          false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_row_copy_flg",     false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "sDoubtFlg",        false,  "",       dfNone,     0,     true,       true);
                    InitDataProperty(0, cnt++ , dtHidden,    20,   daCenter,  true,    "s_dup_allow",        false,  "",       dfNone,     0,     true,       true);
					InitDataProperty(0, cnt++ , dtHidden,   	50,    	daCenter,  	false,  "s_ocn_rout_tmp_flg",   false,          "",       dfNone,	    0,     false,      false);

                    InitUserFormat2(0, "s_t_t_dy", "##", "" );
                    InitUserFormat2(0, "s_t_t_hr", "##", "" );
                    InitComboNoMatchText(true);
                    
		            InitDataCombo (0, "s_route_flg", " |Guide|Standard|Temporary", " |G|S|T");   // 20090317
		            InitDataCombo (0, "s_route_rmk", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others", " |Space Shortage|Customer Request|Port Skip|VSL Phase Out|Add Call|Customs Problem|Clerical Error|The Others");   // 20090317
                    InitDataCombo (0, "s_prior", " |1|2|3|4|5|6|7|8|9|10", " |1|2|3|4|5|6|7|8|9");
		            
                    ImageList(0) = "/hanjin/img/alps/button/btns_calendar.gif";
		            PopupButtonImage(0, "s_ocn_rout_tmp_exp_dt") = 0;
		            
		            RangeBackColor(1, 4, 1, 19) = RgbColor(222, 251, 248);   // ENIS
		            HeadRowHeight = 20 ;

					InitDataValid(0, "s_pol",        vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts1_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_pod1",       vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts2_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_pod2",       vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts3_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_pod3",       vtEngUpOther, "1234567890");
					InitDataValid(0, "s_ts4_lane",   vtEngUpOther, "1234567890");
					InitDataValid(0, "s_pod4",       vtEngUpOther, "1234567890");

					WaitImageVisible=false;
                }
                break;
        }
    }


	// Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        var Row ;
		sheetObj.ShowDebugMsg = false;
        openerFormObj = opener.document.form;
        //openerFormObj = document.form;
		switch(sAction) {

			case IBSEARCH:      //조회
				if(validateForm(sheetObj,formObj,sAction));
				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				sheetObj.DoSearch4Post("ESD_PRD_0035GS.do", PrdFQString(formObj));
				ComOpenWait(false);	
				break;

			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction));
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI;
				sheetObj.DoAllSave("ESD_PRD_0035GS.do", PrdFQString(formObj));
				ComOpenWait(false);
				break;

			case IBINSERT:      // 입력
				if(validateForm(sheetObj,formObj,sAction))
					
				var iRow = sheetObj.DataInsert();
				
				sheetObj.CellValue2( iRow,"s_pol" )  =openerFormObj.pol_port_cd.value ;
				sheetObj.CellValue2( iRow,"s_pod" )  =openerFormObj.pod_port_cd.value ;
				sheetObj.CellValue2( iRow,"s_pol1" ) =openerFormObj.pol_port_cd.value ;
				
				sheetObj.CellEditable(iRow, "s_route_flg") = true;
      	        if( formObj.expt_flag.checked ){
      	        	
      	        	sheetObj.CellValue(iRow,"s_route_flg")='T';
      	        	sheetObj.CellEditable(iRow, "s_route_flg") = false;
      	        	
      	        	sheetObj.CellEditable(iRow, "s_pol2") = true;
      	        	sheetObj.CellEditable(iRow, "s_pol3") = true;
      	        	sheetObj.CellEditable(iRow, "s_pol4") = true;
      	        } else {
      	        	sheetObj.CellValue(iRow,"s_route_flg")='S';
      	        }
      	        sheetObj.CellValue2( iRow, "s_chk") = 1;
				break;

			case IBCOPYROW:        //행 복사
				Row = sheetObj.DataCopy();
				sheetObj.CellValue2( Row,"s_row_copy_flg" ) ="Y" ;
				break;

			case IBDELETE:         
				Row = sheetObj.SelectRow;
				sheetObj.RowDelete(Row);
				break;
				
			case IBDOWNEXCEL:        //엑셀 다운로드
				sheetObj.Down2Excel(-1, false, false, true);
				break;

			case IBLOADEXCEL:        //엑셀 업로드
				sheetObj.LoadExcel();
				break;

		}
	}

// dtPopupEdit 로 처리 할 경우 팝업오픈 처리
var CALENDAR_SELECTED_ROW ='';
function sheet1_OnPopupClick(sheetObj, row, col)
{
    var oriLoc  =  "";
    var destLoc =  "";
    
    var lane   =  "";
    var gubun  =  "";
    var idx = sheetObj.ColSaveName(col).substring(5);
    
    if ( sheetObj.ColSaveName(col) == "s_pod"+idx )
    {
        gubun = idx; //첫번째 
        oriLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pol"+idx);
        destLoc =  sheetObj.CellValue(sheetObj.SelectRow ,"s_pod"+idx);
        lane   =  sheetObj.CellValue(sheetObj.SelectRow ,"s_ts"+idx+"_lane");
             
        var param = '?ori_loc='+ oriLoc +'&dest_loc='+ destLoc+'&f_cmd='+ SEARCH +'&lane='+lane+'&gubun='+gubun+"&row=" + sheetObj.SelectRow + "&col=" + sheetObj.SelectCol;
        myWin  = window.open('ESD_PRD_0040.do'+param, "compop", "status=1,width="+800+",height="+560+",resizable=yes,scrollbars=no,left="+100+",top="+100);
        myWin.focus();
    }
    var cal ;
	if(sheetObj.ColSaveName(col) == "s_ocn_rout_tmp_exp_dt"){
		CALENDAR_SELECTED_ROW = sheetObj.SelectRow;
		cal = new ComCalendarGrid();
		cal.setEndFunction("chkExpDate");	//Callback Function
		cal.select( sheetObj,  row, col , "yyyyMMdd");
		
		
	}
  
}
/*
 * Sheet의 s_ocn_rout_tmp_exp_dt 선택후 CallBack
 */ 
function chkExpDate(){
	var exp_dt     = sheetObjects[0].CellValue(CALENDAR_SELECTED_ROW, "s_ocn_rout_tmp_exp_dt");
 	if( 0 == ComChkPeriod ( exp_dt ,ComGetDateAdd(null, "D", 30)) ) {
		//alert('30일 이내로 ~')
		ComShowMessage(ComGetMsg('PRD90142'));
		sheetObjects[0].CellValue2(CALENDAR_SELECTED_ROW, "s_ocn_rout_tmp_exp_dt")=ComGetDateAdd(null, "D", 30);
	};
 
}
   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
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

	/******************************************************************************/

	function changeSelect(gubun) {
		var frm = document.form;
		var val = ''
		if(gubun=='T'){
			val = frm.select1[frm.select1.selectedIndex].value;
			frm.ts_type.value = (val==0) ? "" : val;
		}
		if(gubun=='S'){
			val = frm.select2[frm.select2.selectedIndex].value;
			frm.stay_time.value = (val==0) ? "0" : val;
		}

	}

	var portInd = '';
	function getCOM_ENS_051(rArray) {
		var cArray  =  rArray [0];
		var frm = document.form;

		if(portInd == 'ORGI'){
			 frm.pol_cont_cd.value = cArray[5];
			 frm.pol_cnty_cd.value = cArray[8];
			 frm.pol_port_cd.value = '';
		}
		if(portInd == 'DEST'){
			 frm.pod_cont_cd.value = cArray[5];
			 frm.pod_cnty_cd.value = cArray[8];
			 frm.pod_port_cd.value = ''
		}
		if(portInd == 'POL'){
			 frm.pol_cont_cd.value = cArray[5];
			 frm.pol_cnty_cd.value = cArray[8];
			 frm.pol_port_cd.value = cArray[3];
		}
		if(portInd == 'POD'){
			 frm.pod_cont_cd.value = cArray[5];
			 frm.pod_cnty_cd.value = cArray[8];
			 frm.pod_port_cd.value = cArray[3];
		}
	}

    function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	//input 
    	var sPol =  "";
    	var sPod =  ""; 
    	var sLane = ""; 
    	//output 
    	var rowCnt = 0;
    	sheetObj.EtcData("rowCnt")='';
	    var polx = "";
    	var podx = "";
    	var lanex = "";
    	var svc_tpx = "";
    	var ttx = "";
    	var dirx = "";
    	var fdr_flgx = "";
    	var polxetb = "";
    	var podxetb = "";
    	// index gubun
    	var tsIdx = '';
        var next =0;

	    if(sheetObj.CellValue(Row, "s_route_flg") == "T" ) { //&& sheetObj.CellValue(Row, "s_route_rmk") == "The Others") { //jsy 201301
	    	sheetObj.CellEditable(Row, "s_route_note") = true;
	    } else {
	    	sheetObj.CellEditable(Row, "s_route_note") = false;
	    }

        if( sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "T") {

        	ComShowMessage(ComGetMsg('PRD90102'));
            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='';
            sheetObj.CellValue2(Row, "s_route_note")='';
            //jsy
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='Y';
            sheetObj.CellEditable(Row, "s_ocn_rout_tmp_exp_dt") = true;
            
        } 
        else if(sheetObj.ColSaveName(Col) == "s_route_flg" && Value != "T") {
            sheetObj.CellValue2(Row, "s_route_rmk")='';     
            sheetObj.CellValue2(Row, "s_route_note")=''; 
            //jsy
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")='';
            sheetObj.CellEditable(Row, "s_ocn_rout_tmp_exp_dt") = false;
            sheetObj.CellValue2(Row, "s_ocn_rout_tmp_flg")='N'; 
        }
      //jsy 201301 -------------------        
//        else if(sheetObj.ColSaveName(Col) == "s_route_rmk" && Value != "The Others") {                 
//            sheetObj.CellValue2(Row, "s_route_note")=''; 
//        }
//        else if(sheetObj.ColSaveName(Col) == "s_route_note" && Value != " ") {        	
//        	if(sheetObj.CellValue(Row, "s_route_rmk") != "The Others") {        	
//        		sheetObj.CellValue2(Row, "s_route_note")='';
//        	}
//        }
        // validation date 는 현재일 +30 이내 지정
        if( sheetObj.ColSaveName(Col) == "s_ocn_rout_tmp_exp_dt" ) {
        	
        	if( 0 == ComChkPeriod ( Val ,ComGetDateAdd(null, "D", 30)) ) {
//        		alert('30일 이내로 ~')
        		ComShowMessage(ComGetMsg('PRD90142'));
        		sheetObj.CellValue2(Row, "s_ocn_rout_tmp_exp_dt")=ComGetDateAdd(null, "D", 30);
        	};
            
        }
        
        //CHM-201005409-01 의거 추가
        if(sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "V") {
            ComShowMessage(ComGetMsg('PRD90104','Validation'));
            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");
            return;
        } 
        if(sheetObj.ColSaveName(Col) == "s_route_flg" && Value == "G" ) {
            if(OCN_FLG !='S'){
	            ComShowMessage(ComGetMsg('PRD90104','Guide'));
	            sheetObj.CellValue2(Row,"s_route_flg") = sheetObj.CellValue(Row,"s_upd_ind_cd");	                
            }else {
                sheetObj.CellValue2(Row,"s_prior") = 1;
            }

            return;
        }

        // S 일때 DROP BOX에서 SELECT 하면 못하게 처리 
        var idx   = sheetObj.GetComboInfo(Row, "s_route_rmk", "SelectedIndex");

        if(  (sheetObj.CellValue(Row, "s_route_flg") != "T" ) &&  (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx >0){
   
            sheetObj.CellValue2(Row, "s_route_rmk")=' '; 
            ComShowMessage(ComGetMsg('PRD90103'));
        }  	    
        if(  (sheetObj.CellValue(Row, "s_route_flg") == "T" ) &&   (sheetObj.ColSaveName(Col) == "s_route_rmk") && idx < 1){

            sheetObj.SelectCell(Row, "s_route_rmk");
            sheetObj.CellValue2(Row, "s_route_rmk")='';
            ComShowMessage(ComGetMsg('PRD90102'));
            
        } 

//        if( sheetObj.ColSaveName(Col) == "sChk") {
//        	if(Val != "1"){
//
//                 sheetObj.CellValue2(Row, "sChk") = "0";
//                 sheetObj.CellValue2(Row, "sDupAllow") = "";
//            }
//        }        
        
//        sheetObj.RemoveEtcData();
    	if( sheetObj.ColSaveName(Col)=="s_pol1" || sheetObj.ColSaveName(Col)=="s_pod1" || sheetObj.ColSaveName(Col)=="s_ts1_lane" ) {
            tsIdx ='1';
            sPol =  sheetObj.CellValue(Row,"s_pol1");
    	    sPod =  sheetObj.CellValue(Row,"s_pod1"); 
    	    sLane = sheetObj.CellValue(Row,"s_ts1_lane"); 
        } else if(sheetObj.ColSaveName(Col)=="s_pol2" || sheetObj.ColSaveName(Col)=="s_pod2" || sheetObj.ColSaveName(Col)=="s_ts2_lane" ) {
            tsIdx ='2';
            sPol =  sheetObj.CellValue(Row,"s_pol2");
    	    sPod =  sheetObj.CellValue(Row,"s_pod2"); 
    	    sLane = sheetObj.CellValue(Row,"s_ts2_lane");             
        } else if(sheetObj.ColSaveName(Col)=="s_pol3" || sheetObj.ColSaveName(Col)=="s_pod3" || sheetObj.ColSaveName(Col)=="s_ts3_lane" ) {
            tsIdx ='3';
            sPol =  sheetObj.CellValue(Row,"s_pol3");
    	    sPod =  sheetObj.CellValue(Row,"s_pod3"); 
    	    sLane = sheetObj.CellValue(Row,"s_ts3_lane");             
        } else if(sheetObj.ColSaveName(Col)=="s_pol4" || sheetObj.ColSaveName(Col)=="s_pod4" || sheetObj.ColSaveName(Col)=="s_ts4_lane" ) {
            tsIdx ='4';
            sPol =  sheetObj.CellValue(Row,"s_pol4");
    	    sPod =  sheetObj.CellValue(Row,"s_pod4"); 
    	    sLane = sheetObj.CellValue(Row,"s_ts4_lane");             
        }
        
        next = ComParseInt(tsIdx)+1;          
      
        if( sPol == "" && sPod == ""  && sLane == "")    return; //처음 row add 시 아무것도 없으니까 
      
        var rowCnt = 0;
     
    	if(sPod.length ==5 ) {
    		ComOpenWait(true);
    		sheetObj.DoSearch("ESD_PRD_0035GS.do", "f_cmd="+SEARCH11+"&ori_loc="+sPol +"&dest_loc="+sPod +"&lane="+sLane+"&row="+Row+"&col="+Col ); 
    		rowCnt = sheetObj.EtcData("rowCnt");
            ComOpenWait(false);
          
            if( tsIdx == '4' && sPod != sheetObj.CellValue( sheetObj.SelectRow, "s_pod") ) {
	            ComShowMessage(ComGetMsg('PRD90012'));
	            return;
            }  
    	}
        
        if( rowCnt != 1 ){
        	polx = sPol;
        	podx = sPod;
        	lanex = sLane;
        	svc_tpx = '';
        	ttx = '';
        	dirx = '';
        	fdr_flgx = '';
        	polxetb = '';
        	podxetb = '';
        	
        } else {
        	polx = sheetObj.EtcData("polx");
        	podx = sheetObj.EtcData("podx");
        	lanex = sheetObj.EtcData("lanex");
        	svc_tpx = sheetObj.EtcData("svc_tpx");
        	ttx = sheetObj.EtcData("ttx");
        	dirx = sheetObj.EtcData("dirx");
        	fdr_flgx = sheetObj.EtcData("fdr_flgx");
        	polxetb = sheetObj.EtcData("polxetb");
        	podxetb = sheetObj.EtcData("podxetb");
    	}

        
        //---------------------------------------------------------------------------------------------------------------------------------
        // 040 logic 
        // sheetObj -> 035GS에서가져온 etc값(polx,podx,..으로) ,openerSheet -> 035 화면 값( sheetObj 으로)

		sheetObj.CellValue2( sheetObj.SelectRow, "s_ts"+tsIdx+"_lane" ) = lanex;
		sheetObj.CellValue2( sheetObj.SelectRow, "s_pod"+tsIdx       ) = podx;
	
		// 서버 에서 가져온 값 (없으면 '') 
		sheetObj.CellValue2( sheetObj.SelectRow, "s_ts"+tsIdx+"_type" ) = svc_tpx;//aaaaaaa
		sheetObj.CellValue2( sheetObj.SelectRow, "s_t_t"+tsIdx        ) = ttx;
		sheetObj.CellValue2( sheetObj.SelectRow, "s_dir"+tsIdx       ) = dirx; //bbbbbbbb
		sheetObj.CellValue2( sheetObj.SelectRow, "s_fdr_flg"+tsIdx    ) = fdr_flgx;
                                                                                                            
        if(tsIdx == '1' ) {      
                                                                                                                    
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pod"+tsIdx+"_etb"   ) = podxetb;     
            sheetObj.CellValue2( sheetObj.SelectRow, "s_f_u"      ) = 'N';
                                                                        
        }else if(tsIdx == '2' || tsIdx == '3' ){  
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+tsIdx       ) = polx;
                                                                                                   
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+tsIdx+"_etb"    ) = polxetb;    
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pod"+tsIdx+"_etb"    ) = podxetb;                                                           
        }else if(tsIdx == '4'){
    		sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+tsIdx       ) = polx;
                                                                                                                      
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+tsIdx+"_etb"    ) = polxetb; 
 
        }                                                                                                                                

        //1,2,3 일때 pod가 destLoc 과 같으면 다음 pod에 넣지 않는다.  (PODX는 입력된값 )                                                                   
        if((tsIdx == '1'||tsIdx == '2'||tsIdx == '3') && podx!= sheetObj.CellValue( sheetObj.SelectRow, "s_pod")) {  

                if(sheetObj.CellValue( sheetObj.SelectRow, "s_ts"+tsIdx+"_lane" ) =="" ||  sheetObj.CellValue( sheetObj.SelectRow, "s_ts"+tsIdx+"_type" ) =="" ) {
                    // ROW COPY 시 는 현재 POD 와 NEXT POL 이 같은지 확인후 지워줌 (지울떄 ? ) 
                    if(podx!= sheetObj.CellValue( sheetObj.SelectRow,  "s_pol"+next  )) {
                        sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+next       ) = ""; 
                        
                    }
                    return;
                }
             
            sheetObj.CellValue2( sheetObj.SelectRow, "s_pol"+next       ) = podx;           
        }
        
        // tsIdx 가 2,3,4 일때 ST 계산 (차례대로 순서적으로 만들때), ROW COPY후 앞에 있는 데이터를 바꾸면?-> 바꾼 이후의 계산 다시 함 
        if(tsIdx == '2' || tsIdx == '3' || tsIdx == '4' ) {
            // tsIdx-1 인 podEtb 를 가져온다 
            var podEtb = sheetObj.CellValue( sheetObj.SelectRow , "s_pod"+(tsIdx-1)+"_etb" );
            var podEtbNum = 0;
            if( podEtb != '' ){
                podEtbNum = ( (podEtb == 'SUN') ? 7:
                             ( (podEtb == 'MON') ? 6:
                             ( (podEtb == 'TUE') ? 5:
                             ( (podEtb == 'WED') ? 4:
                             ( (podEtb == 'THU') ? 3:
                             ( (podEtb == 'FRI') ? 2:
                             ( (podEtb == 'SAT') ? 1:0)))))))
            }

            var polEtb = polxetb;
            var polEtbNum = 0;
            if( polEtb != '' ){
                polEtbNum = ( (polEtb == 'SUN') ? 7:
                             ( (polEtb == 'MON') ? 6:
                             ( (polEtb == 'TUE') ? 5:
                             ( (polEtb == 'WED') ? 4:
                             ( (polEtb == 'THU') ? 3:
                             ( (polEtb == 'FRI') ? 2:
                             ( (polEtb == 'SAT') ? 1:0)))))))
            }
            
            var calEtb = podEtbNum-polEtbNum;
            var st = ( (calEtb == -1)? 7:
                      ( (calEtb == -2)? 6:
                      ( (calEtb == -3)? 5:
                      ( (calEtb == -4)? 4:
                      ( (calEtb == -5)? 3:
                      ( (calEtb == -6)? 2: 
                      ( (calEtb ==  0)? 1:
                      ( (calEtb ==  1)? 1:
                      ( (calEtb ==  2)? 3:
                      ( (calEtb ==  3)? 4:
                      ( (calEtb ==  4)? 5:
                      ( (calEtb ==  5)? 6:
                      ( (calEtb ==  6)? 7: 0))))))))))))) *24;

//            var sST = "";
//          
//            if(tsIdx=='2'){
//            	sST = "sST1";
//            }else if(tsIdx=='3'){
//            	sST = "sST2";
//            }else if(tsIdx=='4'){
//            	sST = "sST3";
//            }
//            sheetObj.CellValue2( sheetObj.SelectRow, sST ) = st;    
            sheetObj.CellValue2( sheetObj.SelectRow, "s_s_t"+(tsIdx-1)    ) = st; 
        }
               
    }
    
    /*
     *  몇번째 link 까지 있는지 알려준다.
     *  0 이면 잘못된 링크가 포함 되있다. 
     */
    function getLinkCnt(sheetObj, insertRow ) {
        
        var findPodIdx =0;
        //-----------------                 
        //  링크의 정보가 빠짐없이 있는지 확인     
        
        for(index = 1 ; index<  5  ; index++){      
        	
        //alert("sPol:" + sheetObj.CellValue( insertRow , "sPol"+index)   + " | sTs: " + sheetObj.CellValue( insertRow , "s_ts"+index+"_lane"));
        	if(sheetObj.CellValue( insertRow , "s_pol"+index)!="" && sheetObj.CellValue( insertRow , "s_ts"+index+"_lane")!="" 
        	&&sheetObj.CellValue( insertRow , "s_ts"+index+"_type")!="" && sheetObj.CellValue( insertRow , "s_pod"+index)!="" ){
        	    findPodIdx++;
        	}            	            	            	
        } 
        return  findPodIdx;      
    }

    //저장전 체크 
    function chkRoute(sheetObj) {
    	var formObj = document.form;
        if(sheetObj.CheckedRows("s_chk")>0) {
    		var checkedRow = sheetObj.FindCheckedRow("s_chk");
    		var arrRow     = checkedRow.split("|");
    		var findPodIdx =0;
            for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){                
                var insertRow = i;
                          
                //pol1 OR pod1 이 값이 있으면 lane,type이 있어야 함  
                //pod1 과 POD 가 같은지 확인 같으면 다음 pol2는 없어야 함 
                if( sheetObj.CellValue( insertRow , "s_pol1")!="" || sheetObj.CellValue( insertRow , "s_pod1")!="") {
                    if( sheetObj.CellValue( insertRow , "s_ts1_lane")=="" || sheetObj.CellValue( insertRow , "s_ts1_type")=="") {
                        return false;
                    }
                }

                if( sheetObj.CellValue( insertRow , "s_pol1")!="" && sheetObj.CellValue( insertRow , "s_pod1")== sheetObj.CellValue( insertRow , "s_pod") ) {
                    if( sheetObj.CellValue( insertRow , "s_pol2")!=""  && !formObj.expt_flag.checked ) {
                        return false;
                    }
                    findPodIdx =1;
                    
                }     
                //---------------
                if( sheetObj.CellValue( insertRow , "s_pol2")!="" || sheetObj.CellValue( insertRow , "s_pod2")!="") {
                    if( sheetObj.CellValue( insertRow , "s_ts2_lane")=="" || sheetObj.CellValue( insertRow , "s_ts2_type")=="") {
                        return false;
                    }
                }
                if( sheetObj.CellValue( insertRow , "s_pol2")!="" && sheetObj.CellValue( insertRow , "s_pod2")== sheetObj.CellValue( insertRow , "s_pod") ) {
                    if( sheetObj.CellValue( insertRow , "s_pol3")!=""  && !formObj.expt_flag.checked) {
                        return false;
                    }
                    findPodIdx =2;
                }      
                //-----------------
                if( sheetObj.CellValue( insertRow , "s_pol3")!="" || sheetObj.CellValue( insertRow , "s_pod3")!="") {
                    if( sheetObj.CellValue( insertRow , "s_ts3_lane")=="" || sheetObj.CellValue( insertRow , "s_ts3_type")=="") {
                        return false;
                    }
                }
                if( sheetObj.CellValue( insertRow , "s_pol3")!="" && sheetObj.CellValue( insertRow , "s_pod3")== sheetObj.CellValue( insertRow , "s_pod") ) {
                    if( sheetObj.CellValue( insertRow , "s_pol4")!="" && !formObj.expt_flag.checked ) {
                        return false;
                    }
                    findPodIdx =3;
                }      
                //-----------------    
                if( sheetObj.CellValue( insertRow , "s_pol4")!="" || sheetObj.CellValue( insertRow , "s_pod4")!="") {
                    if( sheetObj.CellValue( insertRow , "s_ts4_lane")=="" || sheetObj.CellValue( insertRow , "s_ts4_type")=="") {
                        return false;
                    }
                }
                //마지막 pod4 과 POD 가 같지 않으면 FALSE
                if( sheetObj.CellValue( insertRow , "s_pol4")!="" && sheetObj.CellValue( insertRow , "s_pod4") !=sheetObj.CellValue( insertRow , "s_pod") ) {
                        return false;
                } else {
                    findPodIdx =4;
                }
                //-----------------                 
                // findPodIdx 보다 뒤에 데이터가 있으면 안됨 
                //    
                if( !formObj.expt_flag.checked){
                	
                	for(var index=(1+findPodIdx); index<5; index++) {
                		if(sheetObj.CellValue( insertRow , "s_pol"+index)!="" ){
                			return false;
                		}
                		if(sheetObj.CellValue( insertRow , "s_ts"+index+"_lane")!="" ){
                			return false;
                		}
                		if(sheetObj.CellValue( insertRow , "s_ts"+index+"_type")!="" ){
                			return false;
                		}
                		if(sheetObj.CellValue( insertRow , "s_pod"+index)!="" ){
                			return false;
                		}            	            	            	
                	}                         
                }
            }

            return true;
        } 
    }
    
	function doSetValue(sheetObj,formObj){
		
		var openerSheet = opener.document.sheet1 ;
        var fmtStr ='';
        
			    // 에러를 체크한다. org ~ dest 가 맞는지 
        if(sheetObj.CheckedRows("s_chk")==0){
            ComShowMessage(ComGetMsg('PRD90106'));
            return ;
        }	
        
        // OCN_FLAG INPUT CHK 
        if(!ocnFlagChk(sheetObj)){
            ComShowMessage(ComGetMsg('PRD90100'));
            return;            
        }
        
        if(!chkTempRmk(sheetObj)) {
        	ComShowMessage(ComGetMsg('PRD90107'));
            return;
        }        
        if(!chkRoute(sheetObj)) {
        	ComShowMessage(ComGetMsg('PRD90026')); 
            return ;
        }
        if(!otherFlagChk(sheetObj)){                	
            ComShowMessage(ComGetMsg('PRD90124'));
            return;            
        }
        //jsy
        if(!ocnTempExpDtChk(sheetObj)){
//        	ComShowMessage('exp dt 입력~');// PRD90100
        	ComShowMessage(ComGetMsg('PRD90143'));
        	return;            
        }        
        
		if(sheetObj.CheckedRows("s_chk")>0) {
			var checkedRow = sheetObj.FindCheckedRow("s_chk");
			var arrRow     = checkedRow.split("|");
		    var idx = 0;
		    var endIdx = sheetObj.Rows;
            for(idx = sheetObj.HeaderRows ; idx < sheetObj.Rows ; idx++ ){
                // Duplication Route check - Doubt Route 인 경우, Warning Message 띄워줌.
                // Not Used 인 경우 Warning Message 없이 Temporary로 Update        
                if( sheetObj.CellValue( idx , "s_chk")==1 ) {
                	sheetObj.DoRowSearch("ESD_PRD_0032_ROW_GS.do", "f_cmd="+SEARCH11+"&org_loc_cd="+sheetObj.CellValue(idx, "s_pol") +"&dest_loc_cd="+sheetObj.CellValue(idx, "s_pod") 
                                                             +"&n1st_pol_cd="+sheetObj.CellValue(idx,"s_pol1") + "&n1st_pod_cd="+sheetObj.CellValue(idx, "s_pod1")+ "&n1st_lane_cd="+sheetObj.CellValue(idx, "s_ts1_lane")
                                                             +"&n2nd_pol_cd="+sheetObj.CellValue(idx,"s_pol2") + "&n2nd_pod_cd="+sheetObj.CellValue(idx, "s_pod2")+ "&n2nd_lane_cd="+sheetObj.CellValue(idx, "s_ts2_lane")
                                                             +"&n3rd_pol_cd="+sheetObj.CellValue(idx,"s_pol3") + "&n3rd_pod_cd="+sheetObj.CellValue(idx, "s_pod3")+ "&n3rd_lane_cd="+sheetObj.CellValue(idx, "s_ts3_lane")
                                                             +"&n4th_pol_cd="+sheetObj.CellValue(idx,"s_pol4") + "&n4th_pod_cd="+sheetObj.CellValue(idx, "s_pod4")+ "&n4th_lane_cd="+sheetObj.CellValue(idx, "s_ts4_lane")
                                                             +"&row="+idx+"&col="+sheetObj.SaveNameCol("s_chk") );
                    if(sheetObj.EtcData("rowCount")==0) {
                	    sheetObj.CellValue2(idx,"sDoubtFlg")="";
                	    sheetObj.CellValue2(idx,"s_dup_allow")="";
                	} else {
                		ComShowMessage(ComGetMsg('PRD90072'));
                		sheetObj.CellValue2( idx , "s_chk")= 0; 
                		return;
                	}
                }
                sheetObj.RemoveEtcData();
            	
            	if(sheetObj.CellValue(idx, "sDoubtFlg") == "Y"){
                 
                    if(!CONFIRM(ComGetMsg('PRD90053'))){
                        continue;
                    } else {
                        sheetObj.CellValue2(idx , "s_dup_allow" ) = "Y";
                    }
                }			    
                
				// 내려준 데이터는 수정을 못하게 한다. 
				var insertRow = idx;
				if( sheetObj.CellValue( insertRow , "s_chk")==1 ) {
					// sLnkCnt 를 셋팅한다.
					var sLnkCnt = getLinkCnt(sheetObj, insertRow );
					sheetObj.CellValue2( insertRow, "s_lnk_cnt"       ) = sLnkCnt;	
					
					if(sLnkCnt == 1 ) {
						sheetObj.CellValue2( insertRow, "s_ts_ind"   )  = 'D';                                                               
					}else if(sLnkCnt > 1 ) {
						sheetObj.CellValue2( insertRow, "s_ts_ind"   )  = 'T';                                                               
					} else {
						ComShowMessage(ComGetMsg('PRD90105'));
						return; 
					}                   	
       				
					var iRow = openerSheet.DataInsert(-1);
                    openerSheet.RowEditable(iRow) = false;
				    
                    //14 <- 35 
    				openerSheet.CellValue2( iRow, "s_seq"        ) = "";
    				openerSheet.CellValue2( iRow, "s_del"        ) = "";
    				openerSheet.RowStatus(iRow) = "I";
    				openerSheet.CellValue2( iRow, "s_pol"        ) = sheetObj.CellValue( insertRow , "s_pol");
    				openerSheet.CellValue2( iRow, "s_lane"       ) = sheetObj.CellValue( insertRow , "s_ts1_lane");
    				openerSheet.CellValue2( iRow, "s_svc_type"    ) = sheetObj.CellValue( insertRow , "s_ts1_type");
    				openerSheet.CellValue2( iRow, "s_ts1_port"    ) = sheetObj.CellValue( insertRow , "s_pol2");
    				openerSheet.CellValue2( iRow, "s_ts1_lane"    ) = sheetObj.CellValue( insertRow , "s_ts2_lane");
    				openerSheet.CellValue2( iRow, "s_ts1_type"    ) = sheetObj.CellValue( insertRow , "s_ts2_type");
    				openerSheet.CellValue2( iRow, "s_ts2_port"    ) = sheetObj.CellValue( insertRow , "s_pol3");
    				openerSheet.CellValue2( iRow, "s_ts2_lane"    ) = sheetObj.CellValue( insertRow , "s_ts3_lane");
    				openerSheet.CellValue2( iRow, "s_ts2_type"    ) = sheetObj.CellValue( insertRow , "s_ts3_type");
    				openerSheet.CellValue2( iRow, "s_ts3_port"    ) = sheetObj.CellValue( insertRow , "s_pol4");
    				openerSheet.CellValue2( iRow, "s_ts3_lane"    ) = sheetObj.CellValue( insertRow , "s_ts4_lane");
    				openerSheet.CellValue2( iRow, "s_ts3_type"    ) = sheetObj.CellValue( insertRow , "s_ts4_type");
    				openerSheet.CellValue2( iRow, "s_pod"        ) = sheetObj.CellValue( insertRow , "s_pod");
    				fmtStr = ComLpad(sheetObj.CellValue( insertRow , "s_t_t_dy"), 2, 0)+ComLpad(sheetObj.CellValue( insertRow , "s_t_t_hr"), 2, 0);
    				openerSheet.CellValue2( iRow, "s_fmt_t_time"   ) = fmtStr;
    				
    				
    				fmtStr = ComLpad(sheetObj.CellValue( insertRow , "s_s_t_dy"), 2, 0)+ComLpad(sheetObj.CellValue( insertRow , "s_s_t_hr"), 2, 0);
    				openerSheet.CellValue2( iRow, "s_fmt_s_time"   ) = fmtStr;
    				
    				openerSheet.CellValue2( iRow, "s_route_flg")    = sheetObj.CellValue( insertRow , "s_route_flg");
    				
//    				openerSheet.CellValue2( iRow, "s_prior"      ) = sheetObj.CellValue( insertRow , "s_prior");

                    // PRIORITY AUTO RANKING 으로 DEFAULT 로 5 로 의미없는값으로 셋팅.
    				openerSheet.CellValue2( iRow, "s_prior"      ) = '5';
    				openerSheet.CellValue2( iRow, "s_f_u"         ) = sheetObj.CellValue( insertRow , "s_f_u");
    				openerSheet.CellValue2( iRow, "s_t_time"      ) = sheetObj.CellValue( insertRow , "s_t_time");
    				openerSheet.CellValue2( iRow, "s_s_time"      ) = sheetObj.CellValue( insertRow , "s_s_time");
    				openerSheet.CellValue2( iRow, "s_pol1"       ) = sheetObj.CellValue( insertRow , "s_pol1");
    				openerSheet.CellValue2( iRow, "s_pod1"       ) = sheetObj.CellValue( insertRow , "s_pod1");
    				openerSheet.CellValue2( iRow, "s_dir1"       ) = sheetObj.CellValue( insertRow , "s_dir1");
    				openerSheet.CellValue2( iRow, "s_fdr_flg1"    ) = sheetObj.CellValue( insertRow , "s_fdr_flg1");
    				
    				openerSheet.CellValue2( iRow, "s_pol2"       ) = sheetObj.CellValue( insertRow , "s_pol2");
    				openerSheet.CellValue2( iRow, "s_pod2"       ) = sheetObj.CellValue( insertRow , "s_pod2");
    				openerSheet.CellValue2( iRow, "s_dir2"       ) = sheetObj.CellValue( insertRow , "s_dir2");
    				openerSheet.CellValue2( iRow, "s_fdr_flg2"    ) = sheetObj.CellValue( insertRow , "s_fdr_flg2");
    				
    				openerSheet.CellValue2( iRow, "s_pol3"       ) = sheetObj.CellValue( insertRow , "s_pol3");
    				openerSheet.CellValue2( iRow, "s_pod3"       ) = sheetObj.CellValue( insertRow , "s_pod3");
    				openerSheet.CellValue2( iRow, "s_dir3"       ) = sheetObj.CellValue( insertRow , "s_dir3");
    				openerSheet.CellValue2( iRow, "s_fdr_flg3"    ) = sheetObj.CellValue( insertRow , "s_fdr_flg3");
    				
    				openerSheet.CellValue2( iRow, "s_pol4"       ) = sheetObj.CellValue( insertRow , "s_pol4");
    				openerSheet.CellValue2( iRow, "s_pod4"       ) = sheetObj.CellValue( insertRow , "s_pod4");
    				openerSheet.CellValue2( iRow, "s_dir4"       ) = sheetObj.CellValue( insertRow , "s_dir4");
    				openerSheet.CellValue2( iRow, "s_fdr_flg4"    ) = sheetObj.CellValue( insertRow , "s_fdr_flg4");
    				
    				openerSheet.CellValue2( iRow, "s_route_rmk"        ) = sheetObj.CellValue( insertRow , "s_route_rmk");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_route_note"        ) = sheetObj.CellValue( insertRow , "s_route_note");//aaaaaaa
    				
    				openerSheet.CellValue2( iRow, "s_ocn_rout_tmp_exp_dt"        ) = sheetObj.CellValue( insertRow , "s_ocn_rout_tmp_exp_dt");//aaaaaaa
    				
    				openerSheet.CellValue2( iRow, "s_n1st_tztm_hrs") = sheetObj.CellValue( insertRow , "s_t_t1");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_n2nd_tztm_hrs") = sheetObj.CellValue( insertRow , "s_t_t2");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_n3rd_tztm_hrs") = sheetObj.CellValue( insertRow , "s_t_t3");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_n4th_tztm_hrs") = sheetObj.CellValue( insertRow , "s_t_t4");//aaaaaaa
    
    				openerSheet.CellValue2( iRow, "s_n1st_stay_tm_hrs") = sheetObj.CellValue( insertRow , "s_s_t1");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_n2nd_stay_tm_hrs") = sheetObj.CellValue( insertRow , "s_s_t2");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_n3rd_stay_tm_hrs") = sheetObj.CellValue( insertRow , "s_s_t3");//aaaaaaa
    
    				openerSheet.CellValue2( iRow, "s_ts_ind_cd"    ) = sheetObj.CellValue( insertRow , "s_ts_ind");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_pod1_etb"    ) = sheetObj.CellValue( insertRow , "s_pod1_etb");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_pol2_etb"    ) = sheetObj.CellValue( insertRow , "s_pol2_etb");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_pod2_etb"    ) = sheetObj.CellValue( insertRow , "s_pod2_etb");//aaaaaaa
                    openerSheet.CellValue2( iRow, "s_pol3_etb"    ) = sheetObj.CellValue( insertRow , "s_pol3_etb");//aaaaaaa
    				openerSheet.CellValue2( iRow, "s_pod3_etb"    ) = sheetObj.CellValue( insertRow , "s_pod3_etb");//aaaaaaa
                    openerSheet.CellValue2( iRow, "s_pol4_etb"    ) = sheetObj.CellValue( insertRow , "s_pol4_etb");//aaaaaaa
    
                    openerSheet.CellValue2( iRow, "s_lnk_cnt"     ) = sheetObj.CellValue( insertRow , "s_lnk_cnt");//aaaaaaa
                    openerSheet.CellValue2( iRow, "s_dup_allow"        ) = sheetObj.CellValue( insertRow , "s_dup_allow" );
                    openerSheet.CellValue2( iRow, "s_ocn_rout_tmp_flg"        ) = sheetObj.CellValue( insertRow , "s_ocn_rout_tmp_flg");//aaaaaaa
                    
				}

			}//FOR
			
			opener.ocnRoutSave();
		}//IF
//        self.close();
	}
	
	function chkPriority(sheetObj){
	    if(sheetObj.CheckedRows("s_chk")>0) {
    		var checkedRow = sheetObj.FindCheckedRow("s_chk");
    		var arrRow     = checkedRow.split("|");
    		
    		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){

        	    // Priority Check
                if( sheetObj.CellValue(i, "s_prior") == ""){
                    return false;
                }                
            }

            return true;
	    }
	    
	}
	
	function ocnFlagChk(sheetObj){
	    if(sheetObj.CheckedRows("s_chk")>0) {
    		
    		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
                if( sheetObj.CellValue(i, "s_route_flg") == ""){
                    return false;
                }                
            }
            return true;
	    }
	    
	}

    /**
     * save 전에 temp 일때 expire date 입력 체크.OCN_ROUT_TMP_EXP_DT jsy
     */
	function ocnTempExpDtChk(sheetObj){

		i = 0;
		
		for(i = 0+parseInt(sheetObj.HeaderRows) ; i<  sheetObj.RowCount+parseInt(sheetObj.HeaderRows)  ; i++){
    	    // Priority Check
            if(  (sheetObj.RowStatus(i)=='U' || sheetObj.RowStatus(i)=='I')  &&
                 (sheetObj.CellValue(i, "s_route_flg") == "T" ) &&  
            	 (sheetObj.CellValue(i, "s_ocn_rout_tmp_exp_dt") =='' ) ) {
            		return false;
            }                
        }
        return true;
	    
	}
	
	function chkTempRmk(sheetObj){
	    if(sheetObj.CheckedRows("s_chk")>0) {
    		var checkedRow = sheetObj.FindCheckedRow("s_chk");
    		
    		for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
        	    // tempflg Check
                if( sheetObj.CellValue(i, "s_route_flg") == "T"){
                    if(sheetObj.GetComboInfo(i, "s_route_rmk", "SelectedIndex")== 0) {
                        return false;
                    }
                }                
            }
            return true;
	    }
	    
	}	
	
    /**
    * OK 버튼 클릭 전에 Type이 "The Ohter"이면서 Note가 null 인 경우 Message 처리
    * @return
    */
   function otherFlagChk(sheetObj){
   	i = 0;
   	
   	for(var i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++){
   		//alert("!!!!length!!!!!!!" + sheetObj.CellValue(i, "s_route_note").length );
   		//alert("!!!!RowStatus!!!!!!!" + sheetObj.RowStatus(i) );
   	    // Priority Check    	        	    
           if(  (sheetObj.CellValue(i, "s_route_rmk") == "The Others" ) && ( ComTrim(sheetObj.CellValue(i, "s_route_note")) == "") ){                          
               return false;
           }                
       }
       return true;
   }
	
	
	function CONFIRM(msg1)
	{
		msg1 = "\n" +
	       "────────────────────────────────     \n\n" +
	       "\n" +
	       "" + msg1 + "\n" +
	       "\n" +
	       "\n────────────────────────────────     \n" +
	       "If you click 'Cancel' button, this route can't be created.";
		return confirm(msg1);
	}   	
	
    function checkExptFlag() {
        var frm = document.form;
        sheetObjects[0].RemoveAll();
        if(frm.expt_flag.checked ) {
        	
        	ComShowMessage('Please be informed that the right process is creating one more BKG over ship back route.');
        }
        doActionIBSheet(sheetObjects[0],frm,IBINSERT);
    }