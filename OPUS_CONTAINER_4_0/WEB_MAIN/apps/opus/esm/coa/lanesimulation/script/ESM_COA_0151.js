/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0151.js
*@FileTitle  : LaneSimulation >> Step3 >> Tap3 >> Consumption Matrix by Class(popup)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
var crud_flg="";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        var sheetObject1=sheetObjects[1];
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;
                case "btng_save":
                    crud_flg="U";
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                case "btng_sizedel":
                	if(sheetObject.GetCellValue(sheetObject.GetSelectRow(), "ibflag") != "I"){
                        crud_flg="D";
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                    }
                    break;
                case "btn_close":
                	ComClosePopup(); 
                    break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
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
    function loadPage(param1,param2) {
    	loadingMode=true; 
        // IBSheet 처리
        //---------------------------------------------        
        for(i=0;i<sheetObjects.length;i++){
            //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }
        // 멀티콤보 처리
        //---------------------------------------------
        for(k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k],comboObjects[k].id);
        }    
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        loadingMode=false;
    }
    /**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
		with (comboObj) {
			SetDropHeight(300);
			Index=0;
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
            case 1:      //sheet1 init
                with (sheetObj) {
                var pre_fix="f_";
                var HeadTitle="|Sel.|DEL|STS|VslClass|Speed|QTY"
                var HeadTitle1="||DEL|STS|VslClass|Speed|QTY";
                SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"delflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vsl_clss_capa",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"bzc_vsl_spd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"foil_sail_csm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                 
                InitColumns(cols);
                SetEditable(1);//전체Edit허용여부[선택,Defaultfalse]
                }
                break;
        }
    }
    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				formObj.f_cmd.value=INIT;
				var sXml=sheetObj.GetSearchData("ESM_COA_0151GS.do", coaFormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.cobVslCls, "code", "name");
				ComSetObjValue(formObj.cobVslCls,ComGetObjValue(formObj.f_vsl_clss_capa));
				ComOpenWait(false);
				break;  
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=SEARCHLIST01;
                if(comboObjects[0].GetSelectCode()== ""){
                	ComShowMessage(ComGetMsg("COA10002","Vsl Class"));
    			        return false;
                }
                document.form.f_vsl_clss_capa.value=document.form.cobVslCls.text;
                sheetObj.DoSearch("ESM_COA_0151GS.do", coaFormQueryString(formObj) );
                ComOpenWait(false);
                break;
            case IBSAVE:        //저장
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
                formObj.f_cmd.value=MULTI01;
                if(crud_flg=="D"){
                    for(j=1;j<=sheetObj.LastRow();j++){
                        //sheetObj.CellValue(j, "ibflag") = "D";
                        sheetObj.SetRowStatus(j,"D");
                    }
                	if(!ComShowConfirm(ComGetMsg("COA10028"))) {
                		ComOpenWait(false);
                		return false;
                	}
                }
                sheetObj.DoSave("ESM_COA_0151GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            case IBINSERT:      // 입력
                var tmpSum=10;
                if(comboObjects[0].GetSelectCode()!= "" && sheetObj.LastRow()< 2){
                    for(j=0; j<201; j++){
                        sheetObj.DataInsert(-1);
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vsl_clss_capa",comboObjects[0].GetSelectCode(),0);
                        sheetObj.SetCellValue(sheetObj.GetSelectRow(), "bzc_vsl_spd",tmpSum,0);
                        tmpSum=(parseFloat(tmpSum) + 0.1).toFixed(1);
                    }
                } else {
                	ComShowMessage(ComGetMsg("COA10058"));
                }
                break;
        }
    }
