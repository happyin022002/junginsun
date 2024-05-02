/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0081.js
*@FileTitle  :  Hanger Installation Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

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
	      var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 					case "btn_Save":
 						if(validateForm(sheetObject1, formObject)){
 							setPopupSheetToParent(sheetObject1, formObject);
                            ComClosePopup(); 
 						}
                        break; 
 					case "btn_Close":
                        ComClosePopup(); 
                        break; 
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
         setParentSheetToPopup(sheetObjects[0],document.form);
     }
     /**
      * Parent에 있는 정보를 Copy한다.
      */
     function setParentSheetToPopup(mySheet,formObj){
    	var sheetIdx = 0;
    	if (formObj.callSheetIdx.value !="") sheetIdx = formObj.callSheetIdx.value;
    	var  parentSheet;
    	if (opener && opener.sheetObjects) parentSheet =opener.sheetObjects[sheetIdx]; 
    	else if (parent && parent.sheetObjects) parentSheet =parent.sheetObjects[sheetIdx];   
    	
        for (var i=1 ; i <= parentSheet.LastRow(); i++ ){
            var iRow = mySheet.DataInsert(-1);
            for(var j=0 ; j <= parentSheet.LastCol(); j++){
           	 if ( parentSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건
           		 for(var k=0 ; k <= mySheet.LastCol(); k ++){
                        if ( mySheet.ColSaveName(k) == parentSheet.ColSaveName(j)){
                            mySheet.SetCellValue( iRow, k, parentSheet.GetCellValue( i , j) ,0);
                       }            			 
           		 }
           	 }
            }
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
                with(sheetObj){
                    var HeadTitle1="|Seq.|TP/SZ|Q'TY|C'HGR|C'HGR|C'HGR|C'HGR|M'HGR";
                    var HeadTitle2="|Seq.|TP/SZ|Q'TY|Single|Double|Triple|Total|M'HGR";
                    
                    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                    
                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle1, Align:"Center"},
                                    { Text:HeadTitle2, Align:"Center"} ];
                    InitHeaders(headers, info);
                    
                    var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                                 {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"op_cntr_qty",           KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_sgl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_dbl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                                 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_tpl_bar_qty",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
                                 {Type:"Float",     Hidden:0,  Width:75,   Align:"Right",   ColMerge:0,   SaveName:"crr_hngr_qty",          KeyField:0,   CalcLogic:"|crr_hngr_sgl_bar_qty|+|crr_hngr_dbl_bar_qty|+|crr_hngr_tpl_bar_qty|",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                                 {Type:"Float",     Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"mer_hngr_qty",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 } ];
                     
                    InitColumns(cols);
                    
                    SetEditable(1);
                    SetCountPosition(0);
                    SetSheetHeight(125);
                }

                 break;
         }
     }
     /**
      * Editing 종료후 Validation Check
      */
     function sheet1_OnChange(sheetObj,Row,Col, Val){
    	 checkEditData(sheetObj,Row,Col);
     }         
     /**
      * Single or Double 입력시 Total 자동계산
      */
     function checkEditData(sheetObj,Row,Col){
    	 var chkFlag=false;;
    	 var bkgQty,hngrQty, mhgr;
         if(ComIsNumber(sheetObj.GetCellValue(Row,"op_cntr_qty"), ".")){
            bkgQty=parseFloat(sheetObj.GetCellValue(Row,"op_cntr_qty"));
    	 }else{
    		 bkgQty=0;
    	 }

         if(ComIsNumber(sheetObj.GetCellValue(Row,"crr_hngr_qty"), ".")){
        	 hngrQty=parseFloat(sheetObj.GetCellValue(Row,"crr_hngr_qty"));
     	 }else{
     		 hngrQty=0;
     	 }
         
		 // Single + Double <= Bkg Qty 여부 확인
		 if(hngrQty > bkgQty){
			 ComShowCodeMessage("BKG00258");
			 chkFlag=true;
		 }
		 
		 // Merchant Hanger <= Bkg Qty 여부 확인
         if(ComIsNumber(sheetObj.GetCellValue(Row,"mer_hngr_qty"), ".")){
            mhgr=parseFloat(sheetObj.GetCellValue(Row,"mer_hngr_qty"));
		 }else{
			 mhgr=0;
		 }    
		 if(mhgr > bkgQty){
			 ComShowCodeMessage("BKG00258");
			 chkFlag=true;
		 }   
    	 if(!chkFlag){    		 
    		 // Total + Merchant Hanger <= Bkg Qty 여부 확인
    		 if(hngrQty + mhgr > bkgQty){
				 ComShowCodeMessage("BKG00258");
				 chkFlag=true;    			 
    		 }
    	 }
    	 if(chkFlag){
    		 // Validation 에러 후 입력된 값을 Clear 시키고 다시 Total 계산.
    		 sheetObj.SetCellValue(Row,Col,"",0);
    	 }
    	 return chkFlag;
     }
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj){
         with(formObj){
        	 for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
          		if(checkEditData(sheetObj,i,4)){
          			sheetObj.SelectCell(i, 4);
          			return false;
          		}else if(checkEditData(sheetObj,i,5)){
          			sheetObj.SelectCell(i, 5);
          			return false;
          		}else if(checkEditData(sheetObj,i,6)){
          			sheetObj.SelectCell(i, 6);
          			return false;          			
          		}else if(checkEditData(sheetObj,i,8)){
          			sheetObj.SelectCell(i, 8);
          			return false;
          		}
     	    }
         }         
         return true;
     }
     /**
      * 화면의 정보를 Parent화면에 전달한다.
      */
     function setPopupSheetToParent(mySheet,formObj){
     	var parentSheet;
     	if (opener && opener.sheetObjects) parentSheet =opener.sheetObjects[0]; 
    	else if (parent && parent.sheetObjects) parentSheet =parent.sheetObjects[0];    	

		var hngrFlg="N";
		var hngrQty=0;
		var merQty=0;
		for (i=mySheet.HeaderRows(); i<= mySheet.LastRow(); i++) {
			for (j=1; j<= parentSheet.LastRow(); j++) {
				if (mySheet.GetCellText(i, "cntr_tpsz_cd") == parentSheet.GetCellText(j, "cntr_tpsz_cd")){
                    parentSheet.SetCellValue(j, "crr_hngr_sgl_bar_qty",mySheet.GetCellValue(i, "crr_hngr_sgl_bar_qty"));
                    parentSheet.SetCellValue(j, "crr_hngr_dbl_bar_qty",mySheet.GetCellValue(i, "crr_hngr_dbl_bar_qty"));
                    parentSheet.SetCellValue(j, "crr_hngr_tpl_bar_qty",mySheet.GetCellValue(i, "crr_hngr_tpl_bar_qty"));
                    parentSheet.SetCellValue(j, "crr_hngr_qty",mySheet.GetCellValue(i, "crr_hngr_qty"));
                    parentSheet.SetCellValue(j, "mer_hngr_qty",mySheet.GetCellValue(i, "mer_hngr_qty"));
				}
			}			
            if(mySheet.GetCellValue(i, "crr_hngr_qty") != ""){
                hngrQty=hngrQty + mySheet.GetCellValue(i, "crr_hngr_qty");
			}
            if(mySheet.GetCellValue(i, "mer_hngr_qty") != ""){
                merQty=merQty + mySheet.GetCellValue(i, "mer_hngr_qty");
			}			
		}
		if(hngrQty > 0 || merQty > 0){
			hngrFlg="Y";
		}
		var calllFunc=formObj.calllFunc.value;
		if(calllFunc != ''){
			if (ComFuncCheck("opener." + calllFunc)) ComFunc(hngrFlg);
			else if (ComFuncCheck("parent." + calllFunc)) ComFunc(hngrFlg);
		}		
     }     
	/* 개발자 작업  끝 */
