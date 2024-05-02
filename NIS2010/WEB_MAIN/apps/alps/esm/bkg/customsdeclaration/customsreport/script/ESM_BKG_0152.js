/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0152.js
 *@FileTitle : Delivery Mode
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.01
 *@LastModifier : 전창현
 *@LastVersion : 1.0
 * 2009.09.01 전창현
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
 * @class Delivery Mode : Delivery Mode 생성 및 조회를 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */

function ESM_BKG_0152() {
    this.processButtonClick		= tprocessButtonClick;
    this.setSheetObject 		= setSheetObject;
    this.loadPage 				= loadPage;
    this.initSheet 				= initSheet;
    this.doActionIBSheet 		= doActionIBSheet;
    this.validateForm 			= validateForm;
}

// 공통전역변수
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
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
				break;
				
				case "btn_Delete":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
				break;
				
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
				
				case "btn_New":
					doActionIBSheet(sheetObjects[0],formObject,IBRESET);
				break;
				
				case "btn_Save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
				break;
				
				case "btn_DownExcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
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
        
		//화면에서 필요한 이벤트
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	
    	//콤보 데이터 조회
    	doActionIBSheet(sheetObjects[0],document.form,IBCREATE);
    	
    	//버튼 Enable or Disable 설정
    	if(document.form.btn_chk.value == "N"){
    		ComBtnDisable("btn_Save");
    	}else if(document.form.btn_chk.value == "Y"){
    		ComBtnEnable("btn_Save");
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
            case "sheet1":      //sheet1 init
                with (sheetObj) {
                    // 높이 설정
                    style.height = 426;
                    
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 3, 100);

					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(7, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    var HeadTitle1 = "|Sel.|Seq.|POD|Province|DEL|DEL MODE|Remark(s)||||";
                    var headCount = ComCountHeadTitle(HeadTitle1);
                    
                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
    				InitColumnInfo(headCount, 0, 0, true);
                     
                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
                                        
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    
                    InitDataProperty(0,	cnt++ , dtHiddenStatus,	0,		daCenter,		true,	"ibflag");
                    InitDataProperty(0, cnt++ , dtCheckBox,		30, 	daCenter,		true, 	"Chk",		false,		"",  	dfNone,			0,		true,	true);
    			    InitDataProperty(0, cnt++ , dtSeq, 			40,    	daCenter,    	true,   "Seq");     
    	            InitDataProperty(0, cnt++ , dtData,			80,    	daCenter,    	false,  "pod_cd",      	true,     	"",     dfNone, 		0,     	false,	true,	5);
    	            InitDataProperty(0, cnt++ , dtData,			150,   	daLeft,    		false,  "area_nm",    	false,    	"",     dfNone, 		0,     	true,	true,   100);
    			    
    	            InitDataProperty(0, cnt++ , dtData, 		80,   	daCenter,    	false,  "del_cd",    	true,     	"",     dfNone, 		0,     	false,	true,	5);
    			    InitDataProperty(0, cnt++ , dtCombo,		180,  	daLeft,    		false,  "trsp_mod_cd", 	false,    	"",     dfNone, 		0,     	true,	true);
    			    InitDataProperty(0, cnt++ , dtData, 		200,  	daLeft,    		false,  "diff_rmk",    	false,    	"",     dfNone, 		0,     	true,	true,	4000);
    				InitDataProperty(0,	cnt++ , dtHidden,		100,	daCenter,		false,	"cre_usr_id",	false,		"",		dfNone,			0,		false,	false);
    				InitDataProperty(0,	cnt++ , dtHidden,		110,	daCenter,		false,	"cre_dt",		false,		"",		dfUserFormat2,	0,		false,	false);

    				InitDataProperty(0,	cnt++ , dtHidden,		100,	daCenter,		false,	"upd_usr_id",	false,		"",		dfNone,			0,		false,	false); 
    				InitDataProperty(0,	cnt++ , dtHidden,		110,	daCenter,		false,	"upd_dt",		false,		"",		dfUserFormat2,	0,		false,	false);
    				
					//영문 대문자만 입력가능 하도록 함.
    				
		    		InitDataValid(0, "pod_cd", 			vtEngUpOther, "0123456789");
		    		InitDataValid(0, "del_cd", 			vtEngUpOther, "0123456789");
    				//InitDataValid(0, "pod_cd", vtEngUpOnly);
    				InitDataValid(0, "area_nm", vtEngUpOther, " -,");
    				//InitDataValid(0, "del_cd", vtEngUpOnly);
    				InitDataValid(0, "diff_rmk", vtEngUpOther, " -,0123456789");
               }
               break;
        }
    }

    // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
        //sheetObj.ShowDebugMsg = false;
    	sheetObj.WaitImageVisible = false;
    	
        switch(sAction) {
			case IBCREATE:      //콤보 데이터 조회
				formObj.f_cmd.value = INIT;
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0152GS.do", FormQueryString(formObj));
				var arrCombo;
				arrCombo = ComXml2ComboString(sXml, "name", "val");
				sheetObj.InitDataCombo(0, "trsp_mod_cd", arrCombo[0], arrCombo[1]);
	    	break;
	    	
	        case IBSEARCH:      //조회
    			if(!validateForm(sheetObj,formObj,sAction)) return false;
    			ComOpenWait(true);
    			formObj.f_cmd.value = SEARCH;
    			sheetObj.DoSearch("ESM_BKG_0152GS.do", FormQueryString(formObj));
    			ComOpenWait(false);
    		break;
    			
	        case IBRESET:        //초기화
    	    	formObj.reset();
    	    	sheetObj.RemoveAll();
    	    break;
			
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
		    	formObj.f_cmd.value = MULTI;
		    	sheetObj.DoSave("ESM_BKG_0152GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			break;
			
			case IBINSERT:      //Row Add
				var row = sheetObj.DataInsert(-1);
				sheetObj.CellEditable(row, "Chk") = false;
				sheetObj.CellEditable(row, "pod_cd") = true;
				sheetObj.CellEditable(row, "area_nm") = true;
				sheetObj.CellEditable(row, "del_cd") = true;
				sheetObj.CellEditable(row, "trsp_mod_cd") = true;
				sheetObj.CellEditable(row, "diff_rmk") = true;
			break;
			
			case IBDELETE:     //Row Delete
				if(ComShowCodeConfirm('BKG03037')){
					ComRowHideDelete(sheetObj,"Chk");
				}
			break;
			
			case IBDOWNEXCEL:   //Down Excel
				ComOpenWait(true);
		   	    sheetObj.SpeedDown2Excel(-1, false, false, "", "", false, false, "", true);
				ComOpenWait(false);
			break;
			
			case SEARCH01: // 그리드에서 POD Location Code Validation 체크
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				
				formObj.f_cmd.value = SEARCH01;
	            sheetObj.WaitImageVisible = false;  
	            var Row = sheetObj.SelectRow;
				var params = FormQueryString(formObj)+"&loc_cd="+sheetObj.CellValue(Row, "pod_cd");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0152GS.do", params);
	    		var loc_cd = ComGetEtcData(sXml, "locCd");
	    		
		        if(loc_cd == undefined || loc_cd == ""){
	    			ComShowCodeMessage("BKG06012", sheetObj.CellText(Row, "pod_cd"));
	    			sheetObj.CellValue2(Row, "pod_cd") = "";
	    			sheetObj.SelectCell(Row, "pod_cd");
	    		}else{
					sheetObj.CellValue2(Row, "pod_cd") = loc_cd;
	    		}
			break;
			
			case SEARCH02: // 그리드에서 DEL Location Code Validation 체크
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				
				formObj.f_cmd.value = SEARCH01;
	            sheetObj.WaitImageVisible = false;  
	            var Row = sheetObj.SelectRow;
				var params = FormQueryString(formObj)+"&loc_cd="+sheetObj.CellValue(Row, "del_cd");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_0152GS.do", params);
	    		var loc_cd = ComGetEtcData(sXml, "locCd");
	    		
		        if(loc_cd == undefined || loc_cd == ""){
	    			ComShowCodeMessage("BKG06012", sheetObj.CellText(Row, "del_cd"));
	    			sheetObj.CellValue2(Row, "del_cd") = "";
	    			sheetObj.SelectCell(Row, "del_cd");
	    		}else{
					sheetObj.CellValue2(Row, "del_cd") = loc_cd;
	    		}
			break;
	    }
	}
  
    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
     function validateForm(sheetObj,formObj,sAction){
    	 switch (sAction) {
    	    case IBSEARCH: // 조회
    			if(!ComChkRequired(formObj)) return false;
    	        break;
    	        
    	    case IBSAVE: // 저장
    	    	var pod_cd;
    	    	var del_cd;
    	    	
    			for(var i=1; i<sheetObj.RowCount+1; i++){
    		    	if(sheetObj.RowStatus(i) == "I"){
    		    		pod_cd = sheetObj.CellValue(i,"pod_cd");
    		    		del_cd = sheetObj.CellValue(i,"del_cd");
    	    		
    		    		if( pod_cd != "" && del_cd != "" ){
    		    			for(var j=1; j<sheetObj.RowCount+1; j++){
    		    				if( sheetObj.RowStatus(j) == "I" ) continue;
    		    				if( sheetObj.CellValue(j,"pod_cd") == pod_cd &&
    		    					sheetObj.CellValue(j,"del_cd") == del_cd )
    		    				{
    		    					ComShowCodeMessage('BKG06028',sheetObj.CellValue(j,"Seq"));
    		    					return false;
    		    				}
    		    			}
    		    		}
    		    	}
    	    	}
    	    	break;
    	 }
         return true;
     }
     
 	/**
 	 * 저장 후 이벤트 : Multi Command 수행 후 Error Message 가 없이 정상적으로 수행하면 IBSEARCH 를 통해 최종 데이타를 조회한다.
 	 * @param sheetObj
 	 * @param ErrMsg
 	 * @return
 	 */
     function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
     	var formObj = document.form;
     	var saveGubun = formObj.f_cmd.value;
     	
 		if (ErrMsg == "") {
 			ComShowCodeMessage("BKG00166"); // Data Saved Successfully!!
 			doActionIBSheet(sheetObj,formObj,IBSEARCH);
 		} 
     }
     
  	/**
  	 * 저장 후 이벤트 : POD 와 DEL 입력한 값에 대한 유효성 검사를 한다. (OnChange)
  	 * @param sheetObj
  	 * @param ErrMsg
  	 * @return
  	 */
     function sheet1_OnChange(sheetObj, row, col, val){
    		if (sheetObj.ColSaveName(col) == "pod_cd"){
    			doActionIBSheet(sheetObj,document.form,SEARCH01);
    		}
    		if (sheetObj.ColSaveName(col) == "del_cd"){
    			doActionIBSheet(sheetObj,document.form,SEARCH02);
    		}
    	}
		