/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_1038.js
 *@FileTitle : Bangladesh Cargo Manifest - Freight Forward License No.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.13
 *@LastModifier : OH DONG HYUN
 *@LastVersion : 1.0
 * 2009.10.08 OH DONG HYUN
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
 * @class Customer License Info : Customer License Info 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function esm_bkg_1038() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.doActionIBSheet = doActionIBSheet;
    this.setComboObject = setComboObject;
    this.validateForm = validateForm;
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

				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
							
				case "btn_save":
					doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
					break;
							
				case "btn_new":
					//form 초기화
					sheetObjects[0].RemoveAll();
					formObject.cust_lic_no.value='';
					formObject.cust_cd.value='';
					formObject.cust_nm.value='';
					formObject.cust_lic_no.focus();
					break;
							
				case "btn_close":
					window.close();
					break;
							
				case "btn_downexcel":
					doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					break;
				case "btn_rowadd":
					doActionIBSheet(sheetObjects[0],formObject,IBINSERT);
					break;
				
				case "btn_rowdelete":
					doActionIBSheet(sheetObjects[0],formObject,IBDELETE);
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
    	 var formObject = document.form;
        for(i=0;i<sheetObjects.length;i++){

        //khlee-시작 환경 설정 함수 이름 변경
            ComConfigSheet (sheetObjects[i] );

            initSheet(sheetObjects[i],i+1);
        //khlee-마지막 환경 설정 함수 추가
            ComEndConfigSheet(sheetObjects[i]);
        }

		axon_event.addListenerForm("FocusOut","obj_FocusOut", document.form);
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        axon_event.addListenerFormat("keypress","obj_Keypress", document.form);        	 
        axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');       
        axon_event.addListenerForm("click", "obj_Click", document.form); 

        formObject.cust_lic_no.focus(); 
    }
     
  /**
     * 시트 초기설정값, 헤더 정의
     * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt = 0;

		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
				with (sheetObj) {

					// 높이 설정
					style.height = 300;
					
					//전체 너비 설정
                    SheetWidth = mainTable.clientWidth;

                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo(1, 1, 15, 100);

					var HeadTitle1 = "|Sel.|Seq.|License No.|Customer Code|Customer Name|Updated Date|Updated ID|";
					var headCount = ComCountHeadTitle(HeadTitle1);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(headCount, 0, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, false, true, false,false)

                    //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                    InitHeadRow(0, HeadTitle1, true);
					
					//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtHiddenStatus,	30,    		daCenter,	true,   	"ibflag");
					InitDataProperty(0, cnt++ , dtCheckBox,		30,			daCenter,	true,		"Chk",			false,			"",      dfNone,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtSeq,			30,			daCenter,	true,		"",				false,			"",      dfNone,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			100,		daCenter,	true,		"cust_lic_no",	true,			"",      dfNone,	0,			true,		true);
					InitDataProperty(0, cnt++ , dtData,			110,		daCenter,	true,		"cust_cd",		true,			"",      dfNone,	0,			false,		true,	8);
					InitDataProperty(0, cnt++ , dtData,			300,		daLeft,		true,		"cust_nm",		false,			"",      dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			120,		daCenter,	true,		"upd_dt",		false,			"",      dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtData,			80,			daCenter,	true,		"upd_usr_id",	false,			"",      dfNone,	0,			false,		true);
					InitDataProperty(0, cnt++ , dtHidden,		120,		daCenter,	true,		"upd_usr_nm",	false,			"",      dfNone,	0,			false,		true);
					
					InitDataValid(0, "cust_cd", vtEngUpOther, "0123456789");
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
						
				if(validateForm(sheetObj,formObj,sAction))
				{
					ComOpenWait(true);
					formObj.f_cmd.value = SEARCH;
					if(sheetObj.id == "sheet1")								
						sheetObj.DoSearch("ESM_BKG_1038GS.do", FormQueryString(formObj));
					ComOpenWait(false);
				}
				break;
			case IBSAVE:        //저장
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
		    	formObj.f_cmd.value = MULTI;
		    	sheetObj.DoSave("ESM_BKG_1038GS.do", FormQueryString(formObj), -1, false);
				ComOpenWait(false);
			break;
			
			case IBINSERT:      //Row Add
				var row = sheetObj.DataInsert(-1);
				sheetObj.CellEditable(row, "Chk") = true;
				sheetObj.CellEditable(row, "cust_lic_no") = true;
				sheetObj.CellEditable(row, "cust_cd") = true;
				sheetObj.CellEditable(row, "cust_nm") = false;
				sheetObj.CellEditable(row, "upd_dt") = false;
				sheetObj.CellEditable(row, "upd_usr_id") = false;
				break;
				
			case IBROWSEARCH: // 그리드에서 customer code. 입력시 조회
				if(!validateForm(sheetObj,formObj,IBSEARCH))return false;
				
				formObj.f_cmd.value = SEARCH01;
	            var Row = sheetObj.SelectRow;
	            
	            var custValue = "";
	            var tempValue = "";
	            var tempZero = "";
	            custValue = sheetObj.CellText(Row, "cust_cd");
	            
	            tempValue = custValue.substring(2);	
				
				if(tempValue.length != 6 && tempValue.length != 0)
				{
					for(var i = 1; i <= 6 - tempValue.length;i++)
					{
						tempZero = tempZero + "0"  
					}
					custValue = custValue.substring(0,2) + tempZero + tempValue;	
					
					sheetObj.CellValue2(Row, "cust_cd") = custValue; 
				}            
	            
				var params = FormQueryString(formObj)+"&cust_grid_cd="+sheetObj.CellValue(Row, "cust_cd");
				var sXml = sheetObj.GetSearchXml("ESM_BKG_1038GS.do", params);
	    		var cust_cd = ComGetEtcData(sXml, "cust_cd");
	    		var cust_nm = ComGetEtcData(sXml, "cust_nm");
	    		var cust_cnt = ComGetEtcData(sXml, "cust_cnt");
	    		
		        if(cust_cd == undefined || cust_cd == ""){
	    			ComShowCodeMessage("BKG06012", sheetObj.CellText(Row, "cust_cd"));
	    			sheetObj.CellValue2(Row, "cust_cd") = "";
	    			sheetObj.SelectCell(Row, "cust_cd");
	    			if(sheetObj.id == "sheet1"){
	        			sheetObj.CellValue2(Row, "cust_nm") = "";
	    			}
	    		}else if(cust_cnt > 0){
	    			ComShowCodeMessage("BKG06061", sheetObj.Celltext(Row, "cust_cd"));
	    			sheetObj.CellValue2(Row, "cust_cd") = "";
	    			sheetObj.SelectCell(Row, "cust_cd");
	    			if(sheetObj.id == "sheet1"){
	        			sheetObj.CellValue2(Row, "cust_nm") = "";
	    			}
	    		}else{
					sheetObj.CellValue2(Row, "cust_cd") = cust_cd;
	    			if(sheetObj.id == "sheet1"){
	    				sheetObj.CellValue2(Row, "cust_nm") = cust_nm; 
	    			}
	    		}
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
   * Change 이벤트 처리
   */ 
    function sheet1_OnChange(sheetObj, row, col, val){
    	if(sheetObj.ColSaveName(col) == "seal_pty_tp_cd") {
    		document.form.seal_pty_tp_cd.Code = val;
    		sheetObj.CellValue2(row, "seal_pty_nm") = document.form.seal_pty_tp_cd.Text;
    	}
    	else if (sheetObj.ColSaveName(col) == "cust_cd" && sheetObj.CellValue(row, "cust_cd") != ""){
    		for(var i=1; i<=sheetObj.LastRow; i++){
    			if(i == row) continue;
    			if(sheetObj.CellValue(i, "cust_cd") == sheetObj.CellValue(row, "cust_cd")) {
    		   		ComShowCodeMessage("BKG06046");
    		   		sheetObj.CellValue2(row, "cust_cd") = "";
    		   		sheetObj.SelectCell(row, "cust_cd");
    				return;
    			}
    		}
    		doActionIBSheet(sheetObj,document.form,IBROWSEARCH);
    	}
    }
    
    /**
	 * 마이스 이동시 이벤트
	 * @param Button
	 * @param Shift
	 * @param X
	 * @param Y
	 * @return
	 */
	function sheet1_OnMouseMove(Button, Shift, X, Y) {
		Row = sheetObjects[0].MouseRow;
		Col = sheetObjects[0].MouseCol;
		
        var colSaveName = sheetObjects[0].ColSaveName(Col);
		
		if(colSaveName == "upd_usr_id") {
			sText = sheetObjects[0].CellText(Row,"upd_usr_nm");
		} else if(colSaveName == "consignee_cust_nm") {
				sText = sheetObjects[0].CellText(Row,Col);
		} else {
			sText = "";
		}

		//풍선도움말 만들기
		sheetObjects[0].MouseToolTipText = sText;
	}

    /**
     * 조회 후 처리
     */ 
    function sheet3_OnSearchEnd(sheetObj, ErrMsg)
    {
     	var irow = sheetObj.LastRow;
		
     	sheetObj.RowMerge(irows);	
    }
    
    /**
    * HTML Control의 onkeypress이벤트에서 키보드 입력을 제어한다.
    **/
    function obj_Keypress(){
    	var srcName = event.srcElement.getAttribute("name");
    	var srcValue = event.srcElement.getAttribute("value");	
    	var keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;

    	switch(event.srcElement.dataformat){
	       	case "uppernum":
	               //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	               ComKeyOnlyAlphabet('uppernum');
	               break;
	       	case "upper":
	               //영문 대문자만 입력하기, 영문대+숫자 -> ComKeyOnlyAlphabet('uppernum');
	               ComKeyOnlyAlphabet('upper');
	               break;   
	       	case "saupja":
	            //숫자 + "+-."
	            ComKeyOnlyNumber(event.srcElement, "/-.");
	            break;
	       	case "etc": //모든 문자 가능하지만 영문은 대문자로
		        if(keyValue >= 97 && keyValue <= 122) {//소문자
	                event.keyCode = keyValue + 65 - 97;
	            }
	            break;
	        case "ymd":            
	               //alert(srcValue.length);
	           	ComKeyOnlyNumber(event.srcElement);
	               if (srcValue.length == 4) {
	               	document.form.elements[srcName].value = srcValue.substring(0,4) + "-"
	               }
	               if (srcValue.length == 7) {
	                 document.form.elements[srcName].value = srcValue.substring(0,7) + "-"
	               }
	                 break;            
	           default:
	               //숫자만입력하기(정수,날짜,시간)
	               ComKeyOnlyNumber(event.srcElement);
    	}
    }
    

    /**
     * HTML Control의 onkeyUp이벤트에서 키보드 입력을 제어한다.
     **/
     function obj_KeyUp() {
     	     
     	    var formObject = document.form;        
     	    var srcName = window.event.srcElement.getAttribute("name");
     	    var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	    var srcValue = window.event.srcElement.getAttribute("value");
     	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
     	    	ComSetNextFocus();        	    		
     	    }
     }
     
     /**
      * HTML Control의 FOCUS OUT 이벤트에서 키보드 입력을 제어한다.
      * CUSTOMER CODE 입력란 변환
      **/
     function obj_FocusOut(){
		var srcObj = window.event.srcElement;
		var srcName = window.event.srcElement.getAttribute("name");
		var srcValue = window.event.srcElement.getAttribute("value");
		var tempValue = "";
		var tempZero = "";
			
		if (srcName == "cust_cd") {			
			tempValue = srcValue.substring(2);			
			
			if(tempValue.length != 6 && tempValue.length != 0)
			{
				for(var i = 1; i <= 6 - tempValue.length;i++)
				{
					tempZero = tempZero + "0"  
				}
				srcValue = srcValue.substring(0,2) + tempZero + tempValue;			
				
				srcObj.form.elements[srcName].value = srcValue;

			}
		}     
     }

    /**
    * HTML Control의 ENTER KEY 이벤트에서 키보드 입력을 제어한다.
    * CUSTOMER CODE 입력란 변환 시 FOCUS OUT 후 조회처리를 위하여.
    **/
    function obj_ComKeyEnter() {
	    keyValue = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	    
	    if (keyValue == 13) { 
	    	obj_FocusOut();
	    	
    		var obj = document.getElementById("btn_Retrieve");
    		if (obj==null) obj = document.getElementById("btn_retrieve");
    		if (obj) obj.fireEvent("onclick");
	    }
    }