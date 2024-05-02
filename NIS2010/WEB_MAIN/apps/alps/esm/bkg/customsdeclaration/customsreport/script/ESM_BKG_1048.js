/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : Esm_bkg_1048.js
 *@FileTitle : ESM_BKG-1048
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.18
 *@LastModifier : 오동현
 *@LastVersion : 1.0
 * 2009.09.18 오동현
 * 1.0 Creation
=========================================================*/
function esm_bkg_1048() {
	this.processButtonClick = tprocessButtonClick;
	this.setSheetObject = setSheetObject;
	this.loadPage = loadPage;
	this.initSheet = initSheet;
	this.doActionIBSheet = doActionIBSheet;
	this.validateForm = validateForm;
}

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
     /*******************************************************/
     var formObject = document.form;

	try {
		var srcName = window.event.srcElement.getAttribute("name");

        switch(srcName) {
        
        	case "btn_excel":
        		doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
        		break;
									
			case "btn_Close":
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

    	//khlee-시작 환경 설정 함수 이름 변경
        ComConfigSheet (sheetObjects[i] );

        initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
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
        case "sheet1":      //sheet1 init
            with (sheetObj) {
                // 높이 설정
                style.height = 500;
                //전체 너비 설정
                SheetWidth = mainTable.clientWidth;

                //Host정보 설정[필수][HostIp, Port, PagePath]
                if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                //전체Merge 종류 [선택, Default msNone]
                MergeSheet = msPrevColumnMerge + msHeaderOnly;

                //전체Edit 허용 여부 [선택, Default false]
                Editable = true;

                //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                InitRowInfo( 1, 1, 3, 100);

				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                InitColumnInfo(18, 0, 0, true);

                // 해더에서 처리할 수 있는 각종 기능을 설정한다
                InitHeadMode(true, true, false, true, false,false)              

                var HeadTitle1 = "|Seq.|B/L No.|RHQ|POL|POD|SEND DATE|B/L ACK|B/L ACK TEXT|Agency Ack Message|Agency Ack Date|CNTR No.|Customs Ack Message|Customs Ack Date|CNTR ACK|CNTR ACK TEXT|ACK DATE|CNT";
                //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                InitHeadRow(0, HeadTitle1, true);
                                    
                //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                InitDataProperty(0, cnt++ , dtHiddenStatus,	  0, daCenter,  true,  	"Status");
            	//InitDataProperty(0, cnt++ , dtCheckBox,	30, daCenter,  true,     "CHK",   false,    "",   dfNone, 	0,     true,	true);
                //InitDataProperty(0, cnt++ , dtSeq,		30,		daCenter,	true,	"SEQ");
                
                InitDataProperty(0, cnt++ , dtData, 	30,		daCenterTop,	true,   "seq",			false,    "",  	dfNone, 0,   false,	true);
                InitDataProperty(0, cnt++ , dtData, 	90,		daCenterTop,	true,   "bl_no",			false,    "",  	dfNone, 0,   false,	true);
                InitDataProperty(0, cnt++ , dtData, 	70,		daCenterTop,	true,   "rhq",			false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	50,		daCenterTop,	true,   "pol_cd",  			false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	50,		daCenterTop,	true,   "pod_cd",  			false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	130,	daCenterTop,	true,   "sent_dt",  		false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtHidden, 	200,	daLeftTop,		true,   "bl_ack_type",  	false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtHidden, 	200,	daLeftTop,		true,   "bl_ack_text",  	false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	200,	daLeftTop,		true,   "agn_ack_msg",  	false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	120,	daCenter,		false,  "agn_ack_dt",  		false,    "",	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	100,	daCenter,		false,   "cntr_no",  		false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	200,	daLeftTop,		true,   "cust_ack_msg",  	false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtData, 	120,	daCenter,		false,  "cust_ack_dt",  	false,    "",	dfNone, 0,   false,	true);
			    //InitDataProperty(0, cnt++ , dtPopup,    20,		daLeftTop,	true,	"bl_ack_text2", 	false,    "",   dfNone,	0,   false,	true);
			    
			    InitDataProperty(0, cnt++ , dtHidden, 	200,	daLeft,		false,   "cntr_ack_type",	false,    "",  	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtHidden, 	200,	daLeft,		false,   "cntr_ack_text",	false,    "",  	dfNone, 0,   false,	true);
			    //InitDataProperty(0, cnt++ , dtPopup,    20,   	daCenter,	false,	"cntr_ack_text2",   false,    "",  	dfNone,	0,   false,	true);			    
			    
			    InitDataProperty(0, cnt++ , dtHidden, 	120,	daCenter,	false,   "ack_rcv_dt",  			false,    "",	dfNone, 0,   false,	true);
			    InitDataProperty(0, cnt++ , dtHidden, 	1,		daCenter,	false,   "cnt",			false,    "",  	dfNone, 0,   false,	true);
			    //InitDataProperty(0, cnt++ , dtData, 	120,	daCenter,	false,   "ack_rcv_dt",  		false,    "",	dfNone, 0,   false,	true);
			    //InitDataProperty(0, cnt++ , dtData, 	1,		daCenter,	false,   "cnt",			false,    "",  	dfNone, 0,   false,	true);
                        
			    ShowButtonImage = 2;
				CountPosition = 2; 
				CountFormat = "";
               }
                break;
        }
    }

/**
 * Sheet관련 프로세스 처리
 */ 
function doActionIBSheet(sheetObj,formObj,sAction) {
    //sheetObj.ShowDebugMsg = false;
	sheetObj.WaitImageVisible = false;
	
    switch(sAction) {
		case IBSEARCH:      //조회
			ComOpenWait(true);
			formObj.f_cmd.value = SEARCH;
			if(sheetObj.id == "sheet1")
				sheetObj.DoSearch("ESM_BKG_1048GS.do", FormQueryString(formObj));
			ComOpenWait(false);
		break;
		
		case IBDOWNEXCEL: 	//Down Excel
		   	if (sheetObj.RowCount == 0 ) {
		   		ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
		   	    return;
		   	} else {
				ComOpenWait(true);
		   	    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
				ComOpenWait(false);
		   	}
			break;
    }
}

/**
 * 조회 후 처리
 */ 
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	sheetObj.CellValue(sheetObj.SelectRow,"edi_ref_id")+"&vvd_cd="+sheetObj.CellValue(sheetObj.SelectRow,"vvd_cd")

	var tot_bl = 0;
	var pre_bl = "";
	var tot_cntr = 0;
	var i = 0;
	var j = 0;
	for (i=1; i<=sheetObj.RowCount; i++){
		bl_no = sheetObj.CellValue(i,"bl_no")
		if ( pre_bl != bl_no)
		{
			tot_bl = tot_bl + 1;
		}
		
		pre_bl = bl_no;
	}
    document.form.cntr_cnt.value = ComAddComma(sheetObj.TotalRows);
    document.form.bl_cnt.value = tot_bl;
    
    with(sheetObj)
	{
		sheetObj.SubSumBackColor = sheetObj.RgbColor(195,195,195)
		ShowSubSum("bl_no", "17", -1, false, false, 0, "2=CNTR :;3=|17|");
		

		var sRow = FindSubSumRow();
		var arrRow = sRow.split("|");
		for (idx=0; idx<arrRow.length-1; idx++){
			CellFont("FontBold", arrRow[idx],2,arrRow[idx],3) = true;
		}
	}
}

/**
 * 시트 클릭 시 처리
 * @param SheetObj
 * @param Row
 * @param Col
 * @return
 */ 
function sheet1_OnClick(SheetObj, Row, Col){
	 if (SheetObj.ColSaveName(Col) == "bl_ack_text")
	 {
		ComShowMemoPad2(SheetObj,Row,8,false,326,100,4000,8);         		
	 }
	 if (SheetObj.ColSaveName(Col) == "agn_ack_msg")
	 {
		ComShowMemoPad2(SheetObj,Row,9,false,326,100,4000,9);         		
	 }
	 if (SheetObj.ColSaveName(Col) == "cust_ack_msg")
	 {
		ComShowMemoPad2(SheetObj,Row,12,false,326,100,4000,12);         		
	 }
	 if (SheetObj.ColSaveName(Col) == "cntr_ack_text")
	 {
		ComShowMemoPad2(SheetObj,Row,12,false,326,100,4000,12);         		
	 }  
}


/**
 * IBSheet의 특정셀의 글자가 줄바꿈되어 한눈에 볼수 없을때 MemoPad를 이용하여 확인하거나 값을 변경할 때 사용한다. <br>
 * MemoPad는 TextArea와 버튼으로 구성되며, 값을 확인하고 MemoPad를 닫을때는 ESC키를 누르거나 Close 버튼을 누르거나 HTML 영역을 클릭한다. <br>
 * MemoPad가 표시될 위치의 셀은 반드시 편집불가능이어야 한다. <br>
 * <br><b>Example :</b>
 * <pre>
 *    function sheet1_OnClick(sheetObj, Row, Col, Value) {
 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj);
 *    }
 *    function sheet2_OnClick(sheetObj, Row, Col, Value) {
 *        //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집불가능)
 *        if (sheetObj.ColSaveName(Col) == "desc") ComShowMemoPad(sheetObj, Row, Col, true);
 *    }
 * </pre>
 * @param {ibsheet} 	sheetObj    필수,IBSheet Object
 * @param {int} 		row    		선택,MemoPad를 표시할 셀의 행 Index, default=sheetObj.SelectRow
 * @param {int} 		col    		선택,MemoPad를 표시할 셀의 컬럼 Index, default=sheetObj.SelectCol
 * * @param {int} 		col2    	선택,MemoPad를 표시할 위치 계산값
 * @param {bool} 		bReadOnly	선택,MemoPad에 표시된 값의 편집가능 여부, default=true
 * @param {int}    		iWidth		선택,MemoPad의 넓이, default=200
 * @param {int}    		iHeight		선택,MemoPad의 높이, default=200
 * @see #ComHideMemoPad
 * @return 없음<br>
 */
function ComShowMemoPad2(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax,col2) {
	try{
		//함수의 인자 default 값 설정하기			
		if (row == undefined 		|| row == null) 		row=sheetObj.SelectRow;
		if (col == undefined 		|| col == null) 		col=sheetObj.SelectCol;
		if (bReadOnly == undefined  || bReadOnly == null) 	bReadOnly=false;
		if (iWidth == undefined 	|| iWidth == null) 		iWidth = 200; 
		if (iHeight == undefined 	|| iHeight == null) 	iHeight = 200; 
		if (iMax == undefined 	    || iMax == null) 	    iMax = 4000; 

		//메모를 위한 IBSheet 정보의 Validation 확인하기
		if (sheetObj.CellEditable(row,col)) {
			return ComShowMessage("[ComShowMemoPad] "+ sheetObj.id + "(" + row + "," + col + ") 셀은 편집불가능이어야 합니다.");
		}
		//메모를 위한 IBSheet 정보 받기
		if (!ComIsNumber(col)) col = sheetObj.SaveNameCol(col);
        memoSheet=sheetObj;
        memoRow=row;
        memoCol=col;

		//메모메드 만들기
        
        momo_imsi = sheetObj.CellText(row,col);
		if (!initMemoPad2(iMax)) return;
		
        //메모 DIV 표시할 위치 계산하기 (AnchorPosition_getPageOffsetLeft, AnchorPosition_getPageOffsetTop 함수는 ComCalendar.js 있는것을 사용함)
        var iLeft = AnchorPosition_getPageOffsetLeft(sheetObj) + sheetObj.ColLeft(col2) + 2;
        var iTop  = AnchorPosition_getPageOffsetTop(sheetObj)  + sheetObj.RowTop(row)  + 2;
        if (sheetObj.CountPosition!= 0)  iTop += 16; //건수정보가 표시될 때 표시위치를 조금 내린다.

        //현재페이지가 iframe이나 frame 안에 있고, 그것의 scrolling이 불가능한 경우 표시 위치를 변경함
        if (top.document != document && window.frameElement.scrolling=="no") {
        	//높이초과
        	if (iTop + iHeight  > document.body.clientHeight) {
        		iBottom = iTop + sheetObj.RowHeight(row);
        		if (iBottom > document.body.clientHeight) iBottom = document.body.clientHeight;  
        		iTop = iBottom-iHeight;
        		if (iTop <0) iTop = 0
        	}
        	
        	//넓이초과
            if (iLeft + iWidth  > document.body.clientWidth)   {
            	iLeft = document.body.clientWidth - iWidth;    
            	if (iLeft<0) iLeft = 0;
            }
        }

        var _divMemo = document.getElementById(MEMO_DIV_NAME);
        var _frameDoc  = document.getElementById(MEMO_FRAME_NAME).contentWindow.document;

		//_frameDoc.getElementById("btn_apply").style.display = (bReadOnly)?"none":"inline";
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.backgroundColor = bReadOnly?"#E8E7EC":"";
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontFamily  = sheetObj.SheetFontName;
        _frameDoc.getElementById(MEMO_TEXT_NAME).style.fontSize  = 11;
		_frameDoc.getElementById(MEMO_TEXT_NAME).style.height = iHeight-25;
        _frameDoc.getElementById(MEMO_TEXT_NAME).value = sheetObj.CellText(row,col);
        _frameDoc.getElementById(MEMO_TEXT_NAME).readOnly = bReadOnly;

		_divMemo.style.width = iWidth;
		_divMemo.style.height = iHeight;
        _divMemo.style.top = iTop;
        _divMemo.style.left = iLeft;
        _divMemo.style.visibility = "visible";
        _divMemo.focus();	
        
        ComSetFocus(_frameDoc.getElementById(MEMO_TEXT_NAME));
    } catch(err) { ComFuncErrMsg(err.message); }
}
/**
 * MemoPad를 위한 DIV안에 iFrame을 만들고, iFrame안에 Textarea와 버튼을 생성한다. <br>
 * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
 */
function initMemoPad2(iMax) {
	try {
        //메모용 Div가 없으면 생성한다.
        if (document.getElementById(MEMO_DIV_NAME) != null) return true;
		
		//메모용 Div 만들기	        
        var _divMemo=document.createElement("<div id='"+  MEMO_DIV_NAME +"' style='position:absolute; overflow:hidden; width:200px; height:200px; visibility:hidden'/>");
        document.body.insertBefore(_divMemo);

        //메모용 Div 안에 iFrame 만들기(Select태그나 Object태그 위쪽으로 나타나게 하기 위함)
        var _frameMemo = document.createElement("<IFRAME id='"+MEMO_FRAME_NAME+"' src='' frameborder=0 marginHeight=0 marginWidth=0 width=100% height=100% />");
        _divMemo.appendChild(_frameMemo);	        

        var _FrameDoc = _frameMemo.contentWindow.document;

		//iFrame안에 Div 태그 만들기(테두리 만들기,ESC키시 닫기처리 위함)
        var _FrameDiv=_FrameDoc.createElement("<div onkeydown='if(event.keyCode==27) parent.ComHideMemoPad(true);' style='border:1.2px solid #aaa; padding:1px; overflow:hidden; background-color:#E6EFF6; width:100%; height:100%;'/>");
        _FrameDoc.appendChild(_FrameDiv);
        
		//Div안에 Textarea 만들기 
        var _area = _FrameDoc.createElement("<textarea id='" + MEMO_TEXT_NAME +"' style='border:#7F9DB9 1px solid; font-family:Tahoma,Arial; font-size:12px; color:#4f4f4f; height:175px; width:100%'/>");
        _FrameDiv.appendChild(_area);
        
        //Div 안에 center 태그 만들기(버튼을 가운데 놓기 위함)
        var _centerTag = _FrameDoc.createElement("<center>");
        _FrameDiv.appendChild(_centerTag);
		
		//Apply 버튼 만들기 - Apply 버튼 제거(저장기능 없음)
//        var _button1 = _FrameDoc.createElement("<span id='btn_apply' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.setMemoValue2(document.getElementById(\""+MEMO_TEXT_NAME+"\").value,"+iMax+");'/>");
//        _button1.innerHTML = "Apply";
//        _centerTag.appendChild(_button1);
        
		//Close 버튼 만들기
        var _button2 = _FrameDoc.createElement("<span id='btn_close' style='font-size:9pt;cursor:hand;width:40;height:18;padding:0,3,0,3;text-align:center;border:1 solid gray;background-color:#eaeaea' onclick='parent.ComHideMemoPad(true)'/>");
        _button2.innerHTML = "Close";
        _centerTag.appendChild(_button2);
        
        //메모용 iFrame 자동 닫기 처리
        if (document.onmouseup==null || document.onmouseup.toString().indexOf("ComHideMemoPad") < 0) {
	        //Axon에서 onmouseup을 쓰고 있으므로, 아래와 같은 방법으로 MemoPad 닫기 처리
	        window.popupMemoOldEventListener = document.onmouseup;
	        if (window.popupMemoOldEventListener != null) {
	        	//alert("CoObject \n" + window.popupMemoOldEventListener.toString());
	            //기존에 document.onmouseup에  정의된 함수가 있는 경우
	            document.onmouseup = new Function("window.popupMemoOldEventListener(); ComHideMemoPad();");
	        } else {
	            //기존에 document.onmouseup에  정의된 함수가 없는 경우
	            document.onmouseup = ComHideMemoPad;
	        }
	        
	        //ActiveX에 포커스가 갔을때 메모DiV 닫기
	        var objs = document.getElementsByTagName("OBJECT")
			window.popupMemoOldObjEventListener = new Array(objs.length);
	        for(var i = 0 ; i < objs.length ; i++){
		        window.popupMemoOldObjEventListener[i] = objs[i].onfocus;
		        if (window.popupMemoOldObjEventListener[i] != null) {
		            //기존에 document.onmouseup에  정의된 함수가 있는 경우
		            objs[i].onfocus = new Function("window.popupMemoOldObjEventListener["+i+"](); ComHideMemoPad();");
		        } else {
		            //기존에 document.onmouseup에  정의된 함수가 없는 경우
		            objs[i].onfocus = ComHideMemoPad;
		        }
	        }
        }
    } catch(err) { ComFuncErrMsg(err.message); return false;}
    return true;
} 
/**
* MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
* 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌다. <br>
*/
function setMemoValue2(sValue,iMax) {
	try {
		 
		if(sValue.length > iMax){    				
			ComShowMessage("characters long");
//			document.getElementById(MEMO_FRAME_NAME).focus();
			return;
		}else{
			if (memoSheet == null) return;
			if(momo_imsi == "")
//				memoSheet.CellValue2(memoRow, "bl_ack_text") = sValue;
//				memoSheet.CellValue2(memoRow, "bl_ack_text") = sValue;
			memoSheet.CellValue2(memoRow, memoCol) = sValue;
			ComHideMemoPad(true);
		}
   } catch(err) { ComFuncErrMsg(err.message); }
}
		