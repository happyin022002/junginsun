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
	 var sheetObj = sheetObjects[beforetab];
	 /*******************************************************/
	 var formObj = document.form;
//	 var opener = window.dialogArguments;
	try {
		var srcName = window.event.srcElement.getAttribute("name");
		
		switch(srcName) {
			case "btn_verify":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);//sAction => 0
				break;
			case "btn_new":
				sheetObj.RemoveAll();
				formObj.reset();
				break;

			case "btng_fileimport":
				doActionIBSheet(sheetObj,formObj,IBLOADEXCEL);
				break;

			case "btng_rowadd":
				doActionIBSheet(sheetObj,formObj,IBINSERT);//sAction => 3
				break;

			case "btn_ok":
			try {
				  //opener.getESD_SCE_0048(sheetObjects[0], sheetObjects[1], sheetObjects[2], sheetObjects[3]);
    	             var runnersh = opener.sheetObjects[0];
    	             var openersh = opener.sheetObjects[1];  // opener sheet1 이름은받아오세요
    	             var openform = opener.document.form;	// opener form

    	             //var rows = sheetObject.Rows ;
                   //opener.CellText( iRow, opener.ColSaveName(k)) = sheetObject.CellText( i , sheetObject.ColSaveName(j)) ;
    	             var tsheet0 = sheetObjects[0];
    	             var tsheet1 = sheetObjects[1];
    	             var tsheet2 = sheetObjects[2];
    	             var tsheet3 = sheetObjects[3];

    	             var tsheet4 = sheetObjects[4];
    	             var tsheet5 = sheetObjects[5];
    	             var tsheet6 = sheetObjects[6];
    	             var tsheet7 = sheetObjects[7];
    	             var tsheet8 = sheetObjects[8];
    	             
    	             var tsheetmaxrow = tsheet0.Rows;
    	             if(tsheetmaxrow < tsheet1.Rows) tsheetmaxrow = tsheet1.Rows;
    	             if(tsheetmaxrow < tsheet2.Rows) tsheetmaxrow = tsheet2.Rows;
    	             if(tsheetmaxrow < tsheet3.Rows) tsheetmaxrow = tsheet3.Rows;
    	             
     	             if(tsheetmaxrow < tsheet4.Rows) tsheetmaxrow = tsheet4.Rows;
	 	             	 if(tsheetmaxrow < tsheet5.Rows) tsheetmaxrow = tsheet5.Rows;
     	             if(tsheetmaxrow < tsheet6.Rows) tsheetmaxrow = tsheet6.Rows;
     	             if(tsheetmaxrow < tsheet7.Rows) tsheetmaxrow = tsheet7.Rows;
     	             if(tsheetmaxrow < tsheet8.Rows) tsheetmaxrow = tsheet8.Rows;     	                  	             
    	             
    	             var i01 = 0;
    	             var i02 = 0;
    	             var i03 = 0;
    	             var i04 = 0;
    	             
    	             var i05 = 0;
	 	             	 var i06 = 0;
	 	             	 var i07 = 0;	
     	             var i08 = 0;
     	             var i09 = 0;     	             
//alert("tsheetmaxrow:"+tsheetmaxrow+" tsheet0.Rows:"+tsheet0.Rows+" tsheet1.Rows:"+tsheet1.Rows+" tsheet2.Rows:"+tsheet2.Rows+" tsheet3.Rows:"+tsheet3.Rows);
    	             //openersh.Redraw = false ;
    	             openersh.RemoveAll();
    	             openform.bkg_no.value = "";
    	             openform.bl_no.value = "";
    	             openform.eq_no.value = "";
    	             for (var i = 1 ; i < tsheetmaxrow ; i++ )
    	             {
	                    var iRow = openersh.DataInsert(-1);
        	            //Container No.
	                    if(i < tsheet0.Rows){ 
	                    			if ( tsheet0.CellText( i , "r_remark") == "Clear" ){
                            	//openersh.CellText( iRow, "r_cntr_no") = tsheet0.CellText( i , "r_cntr_no") ;
                            	//alert("Clear r_cntr_no:"+tsheet0.CellText( i , "r_cntr_no")+" i:"+i);
                            	openersh.CellText( ++i01, "r_cntr_no") = tsheet0.CellText( i , "r_cntr_no") ;
                            	if(openform.eq_no.value == ""){
                            		openform.eq_no.value = tsheet0.CellText( i , "r_cntr_no") ;
                            	}else if(openform.eq_no.value != ""){
                            		openform.eq_no.value = openform.eq_no.value+","+tsheet0.CellText( i , "r_cntr_no") ;
                            	}

                            }
	                    }
	                    //BKG
	                    if(i < tsheet1.Rows){
                            if ( tsheet1.CellText( i , "r_remark") == "Clear" ){
                                ++i02;
                                //openersh.CellText( iRow, "r_bkg_no") = tsheet1.CellText( i , "r_bkg_no") ;
                                //openersh.CellText( iRow, "r_bkg_no_split") = tsheet1.CellText( i , "r_bkg_no_split") ;
                                openersh.CellText( i02, "r_bkg_no") = tsheet1.CellText( i , "r_bkg_no") ;
                                //openersh.CellText( i02, "r_bkg_no_split") = tsheet1.CellText( i , "r_bkg_no_split") ;
                            	if(openform.bkg_no.value == ""){
                            		openform.bkg_no.value = tsheet1.CellText( i , "r_bkg_no") ;
                            	}else if(openform.bkg_no.value != ""){
                            		openform.bkg_no.value = openform.bkg_no.value+","+tsheet1.CellText( i , "r_bkg_no") ;
                            	}
                            }
                            //alert("r_bkg_no===" + openersh.CellText( i02, "r_bkg_no") + ", " + i);
	                    }
	                    //B/L
	                    if(i < tsheet2.Rows){
                            if ( tsheet2.CellText( i , "r_remark") == "Clear" ){
                            //openersh.CellText( iRow, "r_bl_no") = tsheet2.CellText( i , "r_bl_no") ;
                            	openersh.CellText( ++i03, "r_bl_no") = tsheet2.CellText( i , "r_bl_no") ;
                              	if(openform.bl_no.value == ""){
                            		openform.bl_no.value = tsheet2.CellText( i , "r_bl_no") ;
                            	}else if(openform.bl_no.value != ""){
                            		openform.bl_no.value = openform.bl_no.value+","+tsheet2.CellText( i , "r_bl_no") ;
                            	}
                            }
	                    }
	                    //VVD
	                    if(i < tsheet3.Rows){
                            if ( tsheet3.CellText( i , "r_remark") == "Clear" ){
	                            //openersh.CellText( iRow, "r_vvd") = tsheet3.CellText( i , "r_vvd") ;
	                            openersh.CellText( ++i04, "r_vvd") = tsheet3.CellText( i , "r_vvd") ;
                            }
	                    }
	                    
						//POL / POD
	                    if(i < tsheet4.Rows){
//                            if ( tsheet4.CellText( i , "r_remark") == "Clear" ){
                            	openersh.CellText( ++i05, "r_polpod") = tsheet4.CellText( i , "r_polpod") ;
//                            }
	                    }	  
						//ORIGIN
	                    if(i < tsheet5.Rows){
 //                           if ( tsheet5.CellText( i , "r_remark") == "Clear" ){
                            	openersh.CellText( ++i06, "r_origin") = tsheet5.CellText( i , "r_origin") ;
//                            }
	                    }	      	                                      
						//DEST
	                    if(i < tsheet6.Rows){
 //                           if ( tsheet6.CellText( i , "r_remark") == "Clear" ){
                            	openersh.CellText( ++i07, "r_dest") = tsheet6.CellText( i , "r_dest") ;
   //                         }
	                    }	  
						//S/C No
	                    if(i < tsheet7.Rows){
   //                         if ( tsheet7.CellText( i , "r_remark") == "Clear" ){
                            	openersh.CellText( ++i08, "r_scno") = tsheet7.CellText( i , "r_scno") ;
  //                          }
	                    }	
						// CUST CODE
	                    if(i < tsheet8.Rows){	//2012.03.29 박찬민 [CHM-201216948] 개발-Rail Transit Report상의 일부항목 변경 및 보완 - 기존 Cust_cd는 불작동 -> 정상 작동
                            if ( tsheet8.CellText( i , "r_remark") != "Clear" ){
                                ++i09;
                                openersh.CellText( i09, "r_cust_cnt_cd") = tsheet8.CellText( i , "r_custcd") ;
                                //openersh.CellText( i02, "r_bkg_no_split") = tsheet1.CellText( i , "r_bkg_no_split") ;
                            }
	                    }
	                    	                    
    	             }
    	             //openersh.Redraw = true ;
    	            if (tsheet0.Rows > 1 ||tsheet1.Rows > 1 || tsheet2.Rows > 1 || tsheet3.Rows > 1 || tsheet4.Rows > 1 ||
    	            			tsheet5.Rows > 1 || tsheet6.Rows > 1 || tsheet7.Rows > 1 || tsheet8.Rows > 1) {
    	            	opener.doActionIBSheet(runnersh,runnersh,IBSEARCH,"multi_input");
    	            	window.close();
    	            } else {
    	            	ComShowMessage('Please Check Data!!');
    	            }
    	             //window.close();
    	              	}catch(e) {
				    		
				    			ComShowMessage(e);
				    	}

			  break;

			case "btn_close":
				  window.close();
			  break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111") ;
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

	//khlee-시작 환경 설정 함수 이름 변경
		ComConfigSheet(sheetObjects[i]);

		initSheet(sheetObjects[i],i+1);
	//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
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
		case 1:      //IBSheet1 init
			with (sheetObj) {
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				MergeSheet = msHeaderOnly;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEAD,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo( 1, 1, 9, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|Container No.|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,	   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_cntr_no",	false,			"",		dfNone,		0,			true,		true,		11);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);
				
				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;
			
		case 2:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|BKG No|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  		  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",			false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",			false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",			false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			120,    daLeft,    true,	"r_bkg_no",			false,			"",		dfNone,		0,			true,		true,		12);	//Bkg_no 최대자리수 11->12자리로 변경
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",			false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",			false,			"",		dfNone,		0,			false,		false);
				
				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				InitDataValid(0, 4, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;
			
		case 3:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|B/L No.|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,  	  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_bl_no",		false,			"",		dfNone,		0,			true,		true,		12);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;
			
		case 4:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|VVD|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_vvd",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;
		
		// pod - pod	
		case 5:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|POL/POD|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_polpod",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;	

		// origin
		case 6:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|ORIGIN|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_origin",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;	
			
		// dest
		case 7:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|DEST|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_dest",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;		
		// S/C no
		case 8:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|S/C No|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_scno",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;	
			
		// CUST CODE
		case 9:      //IBSheet1 init
			with (sheetObj) {
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
				InitColumnInfo(6, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false)

				var HeadTitle = "Del.|STS|SEQ|CUST CD|Remark" ;

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle, true);

				//데이터속성    [ROW, COL,  DATATYPE,		  WIDTH,   DATAALIGN, COLMERGE, SAVENAME,      KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtDelCheckEx,	 30,    daCenter,  false,	"r_del",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHiddenStatus,	 30,    daCenter,  false,	"r_sts",		false,			"",		dfNone,		0,			false,		true);
				InitDataProperty(0, cnt++ , dtSeq,			 30,    daCenter,  true,	"r_seq",		false,			"",		dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			150,    daLeft,    true,	"r_custcd",		false,			"",		dfNone,		0,			true,		true,		9);
				InitDataProperty(0, cnt++ , dtData,			 90,    daCenter,  true,	"r_remark",		false,			"",		dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		  0,    daCenter,  true,	"r_clear",		false,			"",		dfNone,		0,			false,		false);

				InitDataValid(0, 3, vtEngOther, "1234567890") ;
				style.height = GetSheetHeight(12) ;

			}
			break;													
	}
}

  // Sheet관련 프로세스 처리
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;
	
	switch(sAction) {

		case IBSEARCH:
			if(validateForm(sheetObj, formObj, sAction)){
				form.f_cmd.value = SEARCHLIST ;
				form.type.value  = beforetab ;
				result = sheetObj.DoAllSave("ESD_SCE_0048GS.do", SceFrmQryString(formObj)+"&"+ComGetPrefixParam("r_"));
			}
			break;
		case IBLOADEXCEL:
			sheetObj.LoadExcel() ;
			break ;

		case IBINSERT:
			sheetObj.DataInsert();
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
				InsertTab( cnt++, "Container" , -1 );
				InsertTab( cnt++, "   BKG   " , -1 );
				InsertTab( cnt++, "   B/L   " , -1 );
				InsertTab( cnt++, "   VVD   " , -1 );
				
				InsertTab( cnt++, "POL / POD" , -1 );
				InsertTab( cnt++, "  ORIGIN " , -1 );
				InsertTab( cnt++, "  DEST   " , -1 );
				InsertTab( cnt++, " S/C No. " , -1 );
				InsertTab( cnt++, " CUST CD " , -1 );				

			}
		 break;

	}
}

/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 */
function tab1_OnChange(tabObj , nItem)
{

	var objs = document.all.item("tabLayer");

	objs[nItem].style.display = "Inline";
	objs[beforetab].style.display = "none";

	//--------------- 요기가 중요 --------------------------//
	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
	//------------------------------------------------------//
		beforetab= nItem;

	}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	var result = true ;
	
	switch (sAction) {
		
		case IBSEARCH:
			var msgs  = new Array() ;
			msgs[0] = "Container No" ;
			msgs[1] = "BKG No" ;
			msgs[2] = "B/L No" ;
			msgs[3] = "VVD" ;
			
			var names = new Array() ;
			names[0] = "r_cntr_no" ;
			names[1] = "r_bkg_no" ;
			names[2] = "r_bl_no" ;
			names[3] = "r_vvd" ;

			var rowCnt = sheetObj.RowCount ;
			if(rowCnt==0){
				result = false
				ComShowMessage(ComGetMsg("SCE90031", msgs[beforetab])) ;
			}
			else {
				for(i=1; result && i<=rowCnt; i++){
					//if(isEmpty2(sheetObj.CellValue(i, names[beforetab]))){
					if(sheetObj.CellValue(i, names[beforetab]) == ""){
						result = false ;
//						ComShowMessage(ComGetMsg("COM12114", msgs[beforetab])) ;
//						sheetObj.SelectCell(i, names[beforetab]) ;
					}
				}
			}
			break;

		default:
			break;
	}

	return result;
}

function t1sheet1_OnSaveEnd(sheetObj, errMsg) {
	if(errMsg==""){
		var cnt = 0 ;
		newForm = "<form name='form1' method='post'>\n" ;
		newForm += "	<input type='hidden' name='f_cmd'>\n";
		
		for(i=1; i<=sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "r_clear")=="Y"){
				newForm += "	<input type='hidden' name='cntr_no' value='" + sheetObj.CellValue(i,"r_cntr_no") + "'>\n";
				cnt++ ;
			}
		}
		newForm += "</form>\n" ;
		
		if(cnt==0){
			return ;
		}
		
		searchRTR(newForm) ;
	}
}

function t2sheet1_OnSaveEnd(sheetObj, errMsg) {
	if(errMsg==""){
		var cnt = 0 ;
		
		newForm = "<form name='form1' method='post'>\n" ;
		newForm += "	<input type='hidden' name='f_cmd'>\n";
		
		for(i=1; i<=sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "r_clear")=="Y"){
				newForm += "	<input type='hidden' name='bkg_no'       value='" + sheetObj.CellValue(i,"r_bkg_no") + "'>\n";
				//newForm += "	<input type='hidden' name='bkg_no_split' value='" + sheetObj.CellValue(i,"r_bkg_no_split") + "'>\n";
				cnt ++ ;
			}
		}
		newForm += "</form>\n" ;
		if(cnt==0){
			return ;
		}

		searchRTR(newForm) ;
	}
}

function t3sheet1_OnSaveEnd(sheetObj, errMsg) {
	if(errMsg==""){
		var cnt = 0 ;
		
		newForm = "<form name='form1' method='post'>\n" ;
		newForm += "	<input type='hidden' name='f_cmd'>\n";
		
		for(i=1; i<=sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "r_clear")=="Y"){
				newForm += "	<input type='hidden' name='bl_no' value='" + sheetObj.CellValue(i,"r_bl_no") + "'>\n";
				cnt ++ ;
			}
		}
		newForm += "</form>\n" ;

		if(cnt==0){
			return ;
		}

		searchRTR(newForm) ;
	}
}

function t4sheet1_OnSaveEnd(sheetObj, errMsg) {
	if(errMsg==""){
		var cnt = 0 ;
		
		newForm = "<form name='form1' method='post'>\n" ;
		newForm += "	<input type='hidden' name='f_cmd'>\n";
		
		for(i=1; i<=sheetObj.RowCount; i++){
			if(sheetObj.CellValue(i, "r_clear")=="Y"){
				newForm += "	<input type='hidden' name='vvd' value='" + sheetObj.CellValue(i,"r_vvd") + "'>\n";
				cnt ++ ;
			}
		}
		newForm += "</form>\n" ;

		if(cnt==0){
			return ;
		}

		searchRTR(newForm) ;
	}
}

function searchRTR(newForm){
	opener.document.all.new_form.innerHTML = newForm ;
				
	var formObj  = opener.document.form1 ;
	var sheetObj = opener.sheetObjects[0] ;
	opener.doActionIBSheet(sheetObj, formObj, IBSEARCH, window.name) ;
}

function t1sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_cntr_no"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t2sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_bkg_no" || colName=="bkg_no_split"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t3sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_bl_no"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t4sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_vvd"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t5sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_polpod"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t6sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_origin"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t7sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_dest"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t8sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_scno"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

function t9sheet1_OnChange(sheetObj, row, col){
	var colName = sheetObj.ColSaveName(col) ;
	
	if(colName=="r_custcd"){
		sheetObj.CellValue2(row, col) = sheetObj.CellValue(row, col).toUpperCase() ;
	}		
}

