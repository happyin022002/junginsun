/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_9000.js
*@FileTitle  : BKG Cost Re-calculation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/*
 *버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
 */
document.onclick=processButtonClick;
	/*
	 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
	 */
  function processButtonClick(){
         /*
         	**** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 ****
         	*/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	case "btn_calendar":
	                if (!window.event.srcElement.disabled) {
	                    var cal=new ComCalendarFromTo();
	                    cal.select(formObject.f_fm_date, formObject.f_to_date, "yyyy-MM-dd");
	                }
                break;
        	    case "btn_Retrieve":
        	    	if(formObject.f_fm_date.value == "" || formObject.f_to_date.value ==""){
        	    		ComShowMessage(ComGetMsg("COM130201","duration"));
        	    	}else{
        	    		doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	    	}
        	        break;
        	    case "btn_Apply":
       	    	    doActionIBSheet(sheetObject,formObject,IBSAVE)
        	        break;
        	    case "btng_DownExcel":
        	        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
        	        break;
        	    case "btng_RowAdd":
    	            doActionIBSheet(sheetObject,formObject,IBINSERT);
        	        break;
        	    case "btng_RowDel":
    	            doActionIBSheet(sheetObject,formObject,IBDELETE);
        	        break;
                case "btng_LoadExcel":
                    doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
                    break;
                case "btn_New":
                	sheetObject.RemoveAll();
                	var NowDate=ComGetNowInfo();
                	ComSetObjValue(formObject.f_fm_date, NowDate);
                	ComSetObjValue(formObject.f_to_date, NowDate);
                	ComSetObjValue(f_status,"All");
                	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
    		}
    	}
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
	 * IBCombo Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
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
		loadingMode=true;
//        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		doActionIBSheet(sheet1,document.form,IBCLEAR);
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }
        loadingMode=false;
        
        //SJH.20141104.MOD
		ComBtnEnable("btn_Retrieve");
		ComBtnEnable("btn_New");
		ComBtnEnable("btn_Apply");
		ComBtnEnable("btng_RowAdd");
		ComBtnEnable("btng_RowDel");
		ComBtnEnable("btng_DownExcel");
		ComBtnEnable("btng_LoadExcel");
		
		document.form.f_fm_date.value=ComGetNowInfo();
		document.form.f_to_date.value=ComGetNowInfo();
    }
 	/**
     * 멀티콤보 항목을 설정한다.
     */
	function initCombo(comboObj, comboId) {
		with (comboObj) {
			//SJH.20141104.MOD
			SetDropHeight(300);
            SetSelectIndex(0);
		}
	}
   /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
			case 1:
				//sheet1 init
			    with(sheetObj){
				      var HeadTitle="Sel.|STS|Seq.|Booking No.|Remarks|Create User|Status|Finish Time" ;
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sel_chk",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             //20160122.MOD : EDITLEN변경
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13  },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"coa_bat_rmk",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"status",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"finish_time",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				       
				      InitColumns(cols);		
				      SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
				      SetColProperty(0 ,"bkg_no", {AcceptKeys:"E|N" , InputCaseSensitive:1});				//SJH.20150116.ADD
//				      SetSheetHeight(350);
					  resizeSheet();
		            }

				break;
        	}
    }
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBCLEAR:          //조회
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(false);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_COA_9000GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0){
					ComXml2ComboItem(arrXml[0],f_status, "code", "name");
					ComCoaSetIBCombo(sheetObj, arrXml[0], "status", true, 0);
					}
				ComOpenWait(false);
				break;
			case IBSEARCH:      //조회
				//if(!validateForm(sheetObj,formObj,sAction)) return false; 
				// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH01;
				sheetObj.DoSearch("ESM_COA_9000GS.do", coaFormQueryString(formObj) );
				ComOpenWait(false);
				break;
			case IBSAVE:        //저장
				if(sheetObj.RowCount("I")>0) {//Insert된 데이터가 있을때만 수행
					if(!validateForm(sheetObj,formObj,sAction)) return false;
					else {
						callBackPassword("6475");																//SJH.20150116.MOD : 테스트를위한 나중 없애기
//						ComOpenPopup("ESM_COA_3001.do", 370, 140, "callBackPassword","0,0", true);				//SJH.20150116.MOD : 테스트를위한 나중 풀기
					}
				} else {
					return false;
				}
				break;
			case IBINSERT:      // 입력
				if(formObj.f_rownum.value==""){
					var Row=sheetObj.DataInsert(-1);
				}else{
					if(formObj.f_rownum.value>1000){
						ComShowMessage(ComGetMsg("COA10008","1000 rows"));
					}else{
						for(i=0;i<formObj.f_rownum.value;i++){
							sheetObj.DataInsert(-1)
						}
					}
				}
				break;
            case IBDELETE:
            	var arrRow=sheetObj.FindCheckedRow("sel_chk").split("|");
            	for(var idx=0; idx<arrRow.length; idx++){
            			sheetObj.RowDelete(arrRow[idx]-idx, false);
            	}
                break;
			case IBDOWNEXCEL:        //엑셀 다운로드
				var excelType=selectDownExcelMethod(sheetObj);
				break;
        	case IBLOADEXCEL:
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
				break;					
		}
	}
	
	function callBackExcelMethod(excelType){
		//SJH.20141104.MOD
	    var sheetObj = sheetObjects[0];
	    switch (excelType) {
	        case "AY":
	            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:' ', CheckBoxOffValue:' '});
	            break;
	        case "AN":
		    	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:' ', CheckBoxOffValue:' '});
		    	break;
	        case "DY":
	        	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:' ', CheckBoxOffValue:' ' });
	        	break;
	        case "DN":
		    	sheetObj.Down2Excel({ HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:' ', CheckBoxOffValue:' ' });
		    	break;
	    }               
	}
	
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function validateForm(sheetObj,formObj,sAction){
		var rt=true;	
		if(sheetObj.RowCount()>1000){
			rt=false;
			ComShowMessage(ComGetMsg("COA10008","1000 rows"));
		} else if(!checkDup(sheetObj)){
			rt=false;
			ComShowMessage(ComGetMsg("COM131301","Booking No."));
		} else {
			var lastRow=sheetObj.LastRow();
			for (var idx=1; idx<lastRow+1; idx++){
				if(sheetObj.GetCellValue(idx,"bkg_no")==""||sheetObj.GetCellValue(idx,"coa_bat_rmk")==""){
					rt=false;
					ComShowMessage(ComGetMsg("COM130201","Booking No. or Remarks"));
				}
			}
		}
		return rt;
	}
	/**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
	function checkDup(sheetObject){
		var duprow1 = sheetObject.ColValueDupRows("bkg_no",false,false,sheetObject.RowCount("R")+1,sheetObject.LastRow);//조회데이터 이후부터 DUP check
		var rt=true;
		if(duprow1!="") {
			var arrRow=duprow1.split(",");
			if(arrRow.length>0) sheetObject.SelectCell(1, 3);//포커스를 첫로우로 이동, 포커스된 색깔때문에 빨강표시가 안되므로 식별을 위해
			for (var idx=0; idx<arrRow.length; idx++){ 
				sheetObject.SetCellBackColor(arrRow[idx], 3,"#FF0000");
			}
			rt=false;
		}
		return rt;
	}
    /**
     * 날짜 형식으로 변형해준다.
     *
     * @param obj object
     */
    function addDateDash(obj){
        var value=obj.value.replace(/\/|\-|\./g,"");
        var rtnValue="";
        if(value.length>0){
            rtnValue=value.substring(0, 4)+"-"+value.substring(4,6)+"-"+value.substring(6);
            obj.value=rtnValue;
        }
    }

    //password 창의 callback함수
    function callBackPassword(pwd) {
    	var sheetObj = sheet1;
    	var formObj = document.form;
    	
    	if (pwd == "6475") {
    		// 업무처리중 버튼사용 금지 처리
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI01;
			sheetObj.DoAllSave("ESM_COA_9000GS.do", coaFormQueryString(formObj));
			ComOpenWait(false);	
    	}
    	doActionIBSheet(sheet1,document.form,IBSEARCH);
    }

    function resizeSheet(){
   	 ComResizeSheet(sheetObjects[0]);
    }
    
    //SJH.20150105.ADD : 저장후 메시지 추가
    function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
        if(ErrMsg == ""){
            // [COM130102] : Success
        	ComShowMessage(ComGetMsg("COM130102","Data"));
        }else{
            ComShowMessage(ComGetMsg("COM132101"));
        }	
        doActionIBSheet(sheetObj,document.form,IBSEARCH);
    } 
    
    //SJH.20150507.ADD : LOADEXCEL OPTION
    function sheet1_OnLoadExcel(sheetObj, result, code, msg) {	
    	ComOpenWait(false);									//20150716.MOD
    	if(isExceedMaxRow(msg)) return;
    }    
    
    //20150716.ADD
    function sheet1_OnLoadFileSelect(sheetObj){
        ComOpenWait(true);
    }
