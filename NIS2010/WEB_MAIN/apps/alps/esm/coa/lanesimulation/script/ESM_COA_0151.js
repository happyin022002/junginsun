/* =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName      : ESM_COA_0151.js
*@FileTitle     : LaneSimulation >> Step3 >> Tap3 >> Consumption Matrix by Class(popup)
*Open Issues    :
*Change history :
*@LastModifyDate: 2010.02.24
*@LastModifier  : 이연각
*@LastVersion   : 1.0
* 2006-08-28 eunju park
* 1.0 최초 생성
* =======================================================
* History
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2009.07.20 윤진영 Alps전환작업 
* 2010.02.24 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.09 시트의 상태값 변경하기 JS 가이드 적용 cellvalue -> rowstatus
* 2010.06.14 윤진영 UI표준처리 삭제시 메세징 처리
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정 
========================================================= */
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var crud_flg = "";
/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;

    /**
     * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 
     */
    function processButtonClick(){
        var sheetObject = sheetObjects[0];
        var sheetObject1 = sheetObjects[1];
        var formObject = document.form;
        
        try {
            var srcName = window.event.srcElement.getAttribute("name");
            switch(srcName) {
                case "btn_retrieve":
                    doActionIBSheet(sheetObject,formObject,IBSEARCH);
                    break;

                case "btng_save":
                    crud_flg = "U";
                    doActionIBSheet(sheetObject,formObject,IBSAVE);
                    break;
                
                case "btng_rowadd":
                    doActionIBSheet(sheetObject,formObject,IBINSERT);
                    break;
                                
                case "btng_sizedel":
                    if(sheetObject.CellValue(sheetObject.SelectRow, "ibflag") != "I"){
                        crud_flg = "D";
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                    }
                    break;
                                
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
     * IBCombo Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++] = combo_obj;
    }
        
    /**
    * Sheet 기본 설정 및 초기화
    * body 태그의 onLoad 이벤트핸들러 구현
    * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
    */
    function loadPage(param1,param2) {
    	loadingMode = true; 
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
        loadingMode = false;
    }

    /**
     * 멀티콤보 항목을 설정한다.
     */
     function initCombo(comboObj, comboId) {
		with (comboObj) {
			DropHeight = 300;
			Index = 0;
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
            case 1:      //sheet1 init
                with (sheetObj) {
                    var pre_fix="f_";
                    SheetWidth = mainTable.clientWidth;                         //전체 너비 설정
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
                    MergeSheet = msPrevColumnMerge;                             //전체Merge 종류 [선택, Default msNone]
                    Editable = true;                                            //전체Edit 허용 여부 [선택, Default false]
                    InitRowInfo( 1, 1, 9, 100);                                 //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitColumnInfo(5, 0 , 0, true);                            //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitHeadMode(false, false, false, true, false,false) ;      // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    var HeadTitle  = "|Sel.|DEL|STS|VslClass|Speed|QTY"
                    var HeadTitle1 = "||DEL|STS|VslClass|Speed|QTY";
                    InitHeadRow(0, HeadTitle, true);                            //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    //데이터속성[      ROW,   COL,    DATATYPE,   WIDTH,  DATAALIGN,  COLMERGE,   SAVENAME,       KEYFIELD,   CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,    FULLINPUT,SORTENABLE,TOOLTIP,ALLCHECK,SAVESTATUS,FORMATFIX]
                    InitDataProperty(0,     cnt++,  dtDelCheck, 30, daCenter,   false, "delflag",         false, "",  dfNone,      0, false, false);
                    InitDataProperty(0,     cnt++,  dtStatus,   30, daCenter,   false, "ibflag",          false, "",  dfNone,      0, false, false);
                    InitDataProperty(0,     cnt++,  dtData,     90, daCenter,   false, "vsl_clss_capa",   false, "",  dfEngUpKey,  0, false, false);
                    InitDataProperty(0,     cnt++,  dtData ,    90, daCenter,   false, "bzc_vsl_spd",     false, "",  dfNone,      0, false, false);
                    InitDataProperty(0,     cnt++,  dtData,     100, daCenter,   false, "foil_sail_csm",   false, "",  dfNone,      0, true, true);
                    CountPosition  = 0 ;
                    
                    style.height = GetSheetHeight(14) ;
                }
                break;
        }
    }

    /**
     * Sheet관련 프로세스 처리
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg = false;
        
        switch(sAction) {
        	case IBCLEAR:          //조회
		        sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
				formObj.f_cmd.value = INIT;
				
				var sXml = sheetObj.GetSearchXml("ESM_COA_0151GS.do", coaFormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				if (arrXml.length > 0)
					ComXml2ComboItem(arrXml[0], formObj.cobVslCls, "code", "name");
				
				ComSetObjValue(formObj.cobVslCls,ComGetObjValue(formObj.f_vsl_clss_capa));
				ComOpenWait(false);
				break;  
			
            case IBSEARCH:      //조회
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = SEARCHLIST01;
                if(comboObjects[0].Code == ""){
                	ComShowMessage(ComGetMsg("COA10002","Vsl Class"));
    			        return false;
                }
                document.form.f_vsl_clss_capa.value = document.form.cobVslCls.text;
                sheetObj.DoSearch4Post("ESM_COA_0151GS.do", coaFormQueryString(formObj));
                ComOpenWait(false);
                break;
            
            case IBSAVE:        //저장
            	// 업무처리중 버튼사용 금지 처리
				sheetObj.WaitImageVisible = false;
				ComOpenWait(true);
                formObj.f_cmd.value = MULTI01;
                if(crud_flg=="D"){
                    for(j=1;j<=sheetObj.LastRow;j++){
                        //sheetObj.CellValue(j, "ibflag") = "D";
                        sheetObj.RowStatus(j) = "D";
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
                var tmpSum = 10;
                
                if(comboObjects[0].Code != "" && sheetObj.LastRow < 2){
                    for(j=0; j<201; j++){
                        sheetObj.DataInsert(-1);
                        sheetObj.CellValue2(sheetObj.SelectRow, "vsl_clss_capa") = comboObjects[0].Code;
                        sheetObj.CellValue2(sheetObj.SelectRow, "bzc_vsl_spd") = tmpSum;
                        tmpSum = (parseFloat(tmpSum) + 0.1).toFixed(1);
                    }
                } else {
                	ComShowMessage(ComGetMsg("COA10058"));
                }
                break;

        }
    }
    

    
    


