/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_906.js
*@FileTitle : Toal Amount화면-On-Dock Rail Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-23
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-23 parkyeonjin
* 1.0 최초 생성
=========================================================*/
// 공통전역변수


var sheetObjects = new Array();
var sheetCnt = 0;

/* 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick = processButtonClick;
/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         /*******************************************************/
         var sheetObject = sheetObjects[0];
         var formObject = document.form;

    	 try {
    		 var srcName=ComGetEvent("name");
    		 switch(srcName) {
         	    case "btn_ok":
         	    	ComShowMessage ("btn_ok button click");
        	        break;

         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e);
    		}
    	}
    }

    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     * @param(sheet_obj) sheet object 
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
        setTotalAmountSheet();
    }
    
   /**
     * 시트 초기설정값, 헤더 정의
     * @param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
     * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
     * @param(sheetObj) sheet object
     * @param(sheetNo)  sheet number
     */
    function initSheet(sheetObj,sheetNo) {

        var cnt = 0;
        switch(sheetNo) {
             case 1:      //sheet1 init
                with (sheetObj) {
            	 	var HeadTitle = "Cost Code|Amount";
            	 	SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle, Align:"Center"} ];
            	 	InitHeaders(headers, info);
            	 	var cols = [ {Type:"Text",    Hidden:0,  Width:200, Align:"Center", ColMerge:0, SaveName:"lgs_cost_cd",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
        		                 {Type:"AutoSum", Hidden:0,  Width:200, Align:"Center", ColMerge:0, SaveName:"inv_amt",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:2,   UpdateEdit:0,   InsertEdit:0} ];
            	 	InitColumns(cols);
		            SetEditable(0);
		            resizeSheet();//SetSheetHeight(240);
//		            ShowSubSum([{StdCol:1, SumCols:"2"}]);
		            
             
             }
                break;
        }
    }
    function resizeSheet(){ ComResizeSheet(sheetObjects[0]); }



  // Sheet관련 프로세스 처리
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBLOADEXCEL:      //조회
                   sheetObj.LoadExcel();
                break;
        }
    }


   /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!ComIsNumber(iPage)) {
//
//                return false;
//            }
        }

        return true;
    }


		function setTotalAmountSheet(){
			var openerObj=window.dialogArguments;
			
			if (!openerObj) openerObj=window.opener;  //이 코드 추가할것
			if (!openerObj) openerObj=parent;         // 기존 가이드 부분
			
			var openerObject;
			if(document.form.tml_inv_tp_cd.value == "ON"){				// On-Dock Charge Invoice Case
				openerObject =openerObj.t3sheet1;
			}else{														// Marine Terminal Invoice Case
				openerObject =openerObj.costCalc_hidden;
			}
			
//			sheetObjects[0].ShowSubSum([{StdCol:"lgs_cost_cd", SumCols:"inv_amt", CaptionText:"Storage Sub Total" }]);
			
			for(var i= openerObject.HeaderRows(); i< openerObject.HeaderRows() + openerObject.RowCount(); i++){

				Row = sheetObjects[0].DataInsert(-1);
				sheetObjects[0].SetCellValue(Row,"lgs_cost_cd", openerObject.GetCellValue(i,"lgs_cost_cd" ));
				sheetObjects[0].SetCellValue(Row,"inv_amt",  openerObject.GetCellValue(i,"inv_amt"));
//				sheetObjects[0].ShowSubSum("lgs_cost_cd", "inv_amt", -1, true, false, -1, "Amount;lgs_cost_cd= Amount;");
								
//				sheetObjects[0].ShowSubSum([{StdCol:"sum_basis", SumCols:"inv_amt", ShowCumulate:0, OtherColText:"vvd=VVD Amount;io_bnd_cd=VVD AMOUNT;lgs_cost_cd=VVD Amount"}]);
								
	    	//sheetObjects[0].SubSumBackColor = sheetObjects[0].RgbColor(255,255,204);

//				sheetObjects[0].RowMerge(Row) 	= false;

			}
			//sheetObjects[0].SubSumBackColor = sheetObjects[0].RgbColor(255,255,204);
//			sheetObjects[0].SumBackColor  	= sheetObjects[0].RgbColor(204,204,255);
//			sheetObjects[0].SumFontBold 		= true;
//			sheetObjects[0].RowMerge(sheetObjects[0].RowCount) 	= true;
			
			sheetObjects[0].ShowSubSum([{StdCol:"lgs_cost_cd", SumCols:"inv_amt", ShowCumulate:0, OtherColText:"AMOUNT;lgs_cost_cd=Amount"}]);
			
			sheetObjects[0].SetSumBackColor("#CCCCFF");
			sheetObjects[0].SetSumFontBold(1);
			sheetObjects[0].SetRowMerge(sheetObjects[0].RowCount,1);
			sheetObjects[0].SetSumText(0,"lgs_cost_cd","TOTAL");			
			

	}
		