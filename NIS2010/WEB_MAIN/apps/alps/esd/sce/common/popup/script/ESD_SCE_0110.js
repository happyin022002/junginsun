/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0110.js
*@FileTitle : (RCC/LCC/ECC/SCC) 팝업 오픈
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2008-07-21 Hun-Il Jung
* 1.0 최초 생성
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                 [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 var sheetObjects = new Array();
var sheetCnt = 0;
var selRow = 0;
var selCol = 0;
var selOfc = "";

/**
 * IBSheet Object를 배열로 등록
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 */
function loadPage() {
	var dist=document.form.dist.value;
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1,dist);

		ComEndConfigSheet(sheetObjects[i]);
	}
//	document.all['seletad'].selectedIndex = document.form.f_slt_idx.value;
}

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
	/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	var sheetObject = sheetObjects[0];
	/*******************************************************/
	var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");
        switch(srcName) {

    	    case "btn_retrieve":
    	    	//if( validateForm(formObject) ){
		            doActionIBSheet(sheetObject,formObject,IBSEARCH);
		        //}
    	        break;

    	    case "btn_new":
	            sheetObject.RemoveAll();
	            formObject.reset();
    	        break;

//            case "btns_calendar1":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.sdate, 'sdate', 'yyyy-MM-dd');
//    	        break;
//
//    	    case "btns_calendar2":
//    	         var cal = new calendarPopup();
//        		 cal.select(formObject.edate, 'edate', 'yyyy-MM-dd');
//    	        break;

            case "btn_close":
	            self.close();
    	        break;

			case "btn_ok":
				PopupOK(sheetObject, formObject);
			    break;

			case "btn_bkg_calendar":
				var cal = new calendarPopupFromTo();
				cal.displayType = "date";
				cal.select(formObject.sdate, 'sdate',formObject.edate, 'edate', 'yyyy-MM-dd');
				break ;


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
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 */
function initSheet(sheetObj,sheetNo,dist) {		
    var cnt = 0;

    switch(sheetNo) {
        case 1:      //IBSheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(10) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 9, 50);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(3, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false)
                    if(dist=="rcc"){
                        var HeadTitle = "|SEQ|RCC Code" ;
                    }else if(dist=="lcc"){
                        var HeadTitle = "|SEQ|LCC Code" ;
                    }else if(dist=="ecc"){
                        var HeadTitle = "|SEQ|ECC Code" ;
                    }else if(dist=="scc"){
                        var HeadTitle = "|SEQ|SCC Code" ;
                    }

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle, false);

                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                    InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    if(dist=="rcc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "rcc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="lcc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "lcc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="ecc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ecc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="scc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "scc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }               
                    


               }
            break;
        case 9:      //IBSheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = GetSheetHeight(10) ;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msNone;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 9, 50);

                //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(3, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, true, true, false,false)
                if(dist=="rcc"){
                    var HeadTitle = "|SEQ|RCC Code" ;
                }else if(dist=="lcc"){
                    var HeadTitle = "|SEQ|LCC Code" ;
                }else if(dist=="ecc"){
                    var HeadTitle = "|SEQ|ECC Code" ;
                }else if(dist=="scc"){
                    var HeadTitle = "|SEQ|SCC Code" ;
                }

                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle, false);

                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtCheckBox,  30,    daCenter,  false,    "check",        false,          "",       dfNone,   	0,     true,       true);
                InitDataProperty(0, cnt++ , dtSeq,       30,    daCenter,  false,    "",        false,          "",       dfNone,   	0,     false,       true);
                    if(dist=="rcc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "rcc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="lcc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "lcc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="ecc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "ecc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }else if(dist=="scc"){
                        InitDataProperty(0, cnt++ , dtData,      116,    daCenter,  false,    "scc_cd",        false,          "",       dfNone,       0,     false,       true);
                    }   
                

           }
            break;

    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg = false;

	switch(sAction) {
		case IBSEARCH:      //조회
			formObj.f_cmd.value = SEARCH03;

			//delHypen(formObj.sdate);
			//delHypen(formObj.edate);
			//alert("SceFrmQryString(formObj)-->"+SceFrmQryString(formObj));
			sheetObj.DoSearch4Post("ESD_SCE_0110GS.do", SceFrmQryString(formObj));
			break;
	   case IBDOWNEXCEL:        //엑셀 다운로드
		  sheetObj.Down2Excel(-1, false, false, true);
		  break;

	}
}

/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(formObj){
    with(formObj){
    	/*--
 	    if(formObj.sdate.value=="" || formObj.edate.value=="") {
  	        ComShowMessage("You must input period");

  	        if(formObj.sdate.value=="" || !chkDateValue(formObj.sdate.value) )  {
  	          //setFocus(formObj.sdate);
  	          formObj.sdate.focus() ;
  	          return false;
  	        }

  	        if(formObj.edate.value=="" || !chkDateValue(formObj.edate.value) ) {
  	          //setFocus(formObj.edate);
  	          formObj.edate.focus() ;
  	          return false;
  	        }
  	    }

  	    if( formObj.seletad.value == "ETA" ){
	  	    if(formObj.selpod.value=="") {
	  	        ComShowMessage("You must input POD");
	  	        //setFocus(formObj.selpod);
	  	        formObj.selpod.focus() ;
	  	        return false;
	  	    }
  	    } else{
	  	    if(formObj.selpol.value=="") {
	  	        ComShowMessage("You must input POL");
	  	        //setFocus(formObj.selpol);
	  	        formObj.selpol.focus() ;
	  	        return false;
	  	    }
  	    }
  	    --*/
  	    if(formObj.selvvd.value != null && formObj.selvvd.value != "") {
  	    	if(formObj.selvvd.value.length != 9) {
      	        ComShowMessage("VVD must be 9 characters");
      	        setFocus(formObj.selvvd);
      	        return false;
      	    }
  	    }

  	    if(formObj.sellane.value != null && formObj.sellane.value != "") {
  	    	if(formObj.sellane.value.length != 3) {
      	        ComShowMessage("Lane must be 3 characters");
      	        setFocus(formObj.sellane);
      	        return false;
      	    }
  	    }
    }

    return true;
}

function PopupOK(sheetObj, formObject){

	var rcc_val	   = "";	// Target Object에 세팅할 값
	var lcc_val	   = "";

	var rows = sheetObj.Rows;
	var iCheckRow = sheetObj.CheckedRows("check");
	var dist = sheetObj.ColSaveName(2);	
	var opener = window.dialogArguments;
	
	if(rows==1 && iCheckRow == 0) {
		return null;
	}else if(rows > 1 && iCheckRow == 0) {
		ComShowMessage("Please check row") ;
		return null;
	}
	else {
		var ik = 0;
  		if(dist=="rcc_cd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				rcc_val = sheetObj.CellValue(i, "rcc_cd");
	
		  			} else {
		  				rcc_val = rcc_val + "," + sheetObj.CellValue(i, "rcc_cd");
	                }
	                ik++;
	     		}
	  		}
		}else if(dist=="lcc_cd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				lcc_val = sheetObj.CellValue(i, "lcc_cd");
	
		  			} else {
		  				lcc_val = lcc_val + "," + sheetObj.CellValue(i, "lcc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}else if(dist=="ecc_cd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				ecc_val = sheetObj.CellValue(i, "ecc_cd");
	
		  			} else {
		  				ecc_val = ecc_val + "," + sheetObj.CellValue(i, "ecc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}else if(dist=="scc_cd"){
			for(var i = 0; i < rows; i++) {
				if(sheetObj.CellValue(i, "check") == 1) {
		  			if(ik == 0) {
		  				scc_val = sheetObj.CellValue(i, "scc_cd");
	
		  			} else {
		  				scc_val = scc_val + "," + sheetObj.CellValue(i, "scc_cd");
	                }
	                ik++;
	     		}
	  		}		
		}							
  	}
  	
  	if(dist=="rcc_cd"){
  	  	opener.rtn_rcc_code(rcc_val);
  	}else if(dist=="lcc_cd"){
   	  	opener.rtn_lcc_code(lcc_val); 	  	  	   	  	
  	}else if(dist=="ecc_cd"){
   	  	opener.rtn_ecc_code(ecc_val); 	  	  	   	  	
  	}else if(dist=="scc_cd"){
   	  	opener.rtn_scc_code(scc_val); 	  	  	   	  	
  	}
  	self.close();

}
/*
 * ETA/ETD를 선택 함에 따라 조회 IBSheet 변경

function selectVSLEVNT(evt){
  //alert("evt:"+evt);
if(evt=="ETA"){
   document.all['seletad'].selectedIndex = 0;
   document.form.f_slt_idx.value =  0;
}else{
   document.all['seletad'].selectedIndex = 1;
   document.form.f_slt_idx.value =  1;
}


        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[0]);

            initSheet(sheetObjects[0],1,evt);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[0]);



}
 * */

