/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0974.jsp
*@FileTitle  : Master Booking Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
   	/* 개발자 작업	*/
// 공통전역변수
var sheetObjects=new Array();
var sheetCnt=0;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_ConfirmCombine":
						if(!validateForm(sheetObject,formObject,"btn_ConfirmCombine")) {
							return false;
						}
						var bkgNo = getNoCheckRowBkgNo();
						var sXml = sheetObj.GetSaveData("ESM_BKG_0620GS.do", "f_cmd="+SEARCH01 + "&bkg_no="+bkgNo +"&type=B");
						if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
							if(ComGetEtcData(sXml, "CNT") > 0){
								comBkgCallPop0620('setCallBack0620');
								return;
							}
						}
						combineFuncrion('');
					break;
					case "btn_Close":
						ComClosePopup(); 
					break;
            } // end switch
    	}catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
    	}
    }
    
    function getNoCheckRowBkgNo(){
    	var sRow = sheetObjects[0].FindCheckedRow("slct_flg");
    	var bkgNos = '';
    	for (var i = 1; i <= sheetObjects[0].RowCount(); i++) {
			if(i != sRow) bkgNos += sheetObjects[0].GetCellValue(i, "bkg_no") + " ";
		}
    	return bkgNos;
    }
    
    function setCallBack0620(message){
    	var  opener=window.dialogArguments;
    	if (!opener) opener=window.opener;  //이 코드 추가할것
    	if (!opener) opener=parent; //이 코드 추가할것
    	opener.setMessage(message);
    	combineFuncrion();
    }
    
    function combineFuncrion(){
    	ComOpenWait(true);
		ComBtnDisable("btn_ConfirmCombine");
		setTimeout('comPopupOK2()', 1000);
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
	function initControl() {
		var formObject=document.form;
	}

	/**
     * comPopupOK
     */
	function comPopupOK2() {
		var formObj=document.form;	
		var rArray=new Array(); //행데이터를 담고 있는 배열
	    var sRow=sheetObjects[0].FindCheckedRow("slct_flg");
	    //가져온 행을 배열로 반든다.	 	  	 	      
	    var arrRow=sRow.split("|"); 	   
		var cArray=new Array();   		  	   
	    for (idx=0; idx <= arrRow.length; idx++){	     
			 //열데이터를 담고 있는 배열 		 	 
	    	cArray[idx]=sheetObjects[0].GetCellValue(arrRow[idx], "bkg_no");	    	
		}
		// 모달창인 경우 opener를 구해온다.
    		 
    	var  opener=window.dialogArguments;
    	if (!opener) opener=window.opener;  //이 코드 추가할것
    	if (!opener) opener=parent; //이 코드 추가할것
    	
    	opener.callBack0974(cArray);
    	ComOpenWait(false);
    	ComClosePopup(); 
	} 
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
                with (sheetObj) {                
	                var HeadTitle1="|Master|Booking No.|B/L No.|Status|SO No.|Shipper|POR|POR|DEL|DEL|CNTR Vol.";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                       {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slct_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"bkg_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"twn_so_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:145,  Align:"Left",    ColMerge:1,   SaveName:"shipper",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"por_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                       {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_vol",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
	                InitColumns(cols);
	                SetEditable(1);
	                SetSheetHeight(370);
            	}
			break;
        }
    }
  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          case IBSEARCH:      //조회
//		          if(validateForm(sheetObj,formObj,sAction))
	       	var sXml=formObj.sXml.value;
	       	var arrXml=sXml.split("|$$|");
	       	for(var i=0; i < arrXml.length; i++){ 
	       		sheetObjects[i].RenderSheet(0);
	       		if(i > 0) {
     				sheetObjects[i].SetWaitImageVisible(0);
	       		}  
	       		sheetObjects[i].RenderSheet(0);
	       		sheetObjects[i].LoadSearchData(arrXml[i],{Sync:0} );
	       		sheetObjects[i].RenderSheet(1);
	       	}
              break;
        }
    }
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			switch(sAction) {
			case "btn_ConfirmCombine":
				if (sheetObj.CheckedRows("slct_flg") == 0) {
					ComShowMessage(msgs['BKG00155']);
					return false;
				}
			}
	        return true;
        }
    }
