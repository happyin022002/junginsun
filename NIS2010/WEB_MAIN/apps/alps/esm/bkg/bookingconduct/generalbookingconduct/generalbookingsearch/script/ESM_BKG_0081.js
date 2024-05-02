/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0081.js
*@FileTitle : Hanger Installation Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
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
     * @class esm_bkg_0081 : esm_bkg_0081 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function esm_bkg_0081() {
    	this.processButtonClick	= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            	= initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/
    ﻿
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

 					case "btn_Save":
 						if(validateForm(sheetObject1, formObject)){
 							setPopupSheetToParent(sheetObject1, formObject);
 							window.close();
 						}
                     break; 

 					case "btn_Close":
 						window.close();
                     break; 
                     
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowCodeMessage("COM12111");
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
    	 var  parentSheet;
		 if (formObj.callSheetIdx.value !=""){
			 parentSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx.value]);
		 }else{
			 // Booking Creation
			 parentSheet =window.dialogArguments.sheetObjects[0];
		 }    	 
		var parentRowCount = parentSheet.Rows;

        for ( i = 1 ; i < parentRowCount ; i++ ){
            var iRow = mySheet.DataInsert(-1);
            for(j = 0 ; j <= parentSheet.LastCol ; j++){
           	 if ( parentSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
           		 for(k=0 ; k <= mySheet.LastCol ; k ++){
                        if ( mySheet.ColSaveName(k) == parentSheet.ColSaveName(j)){	                        	 
                        	mySheet.CellValue2( iRow, mySheet.ColSaveName(k)) = parentSheet.CellValue( i , parentSheet.ColSaveName(j)) ;
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

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 125;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 4, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(9, 0, 0, false);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false)

                     var HeadTitle1 = "|Seq.|TP/SZ|Q'TY|C'HGR|C'HGR|C'HGR|C'HGR|M'HGR";
                     var HeadTitle2 = "|Seq.|TP/SZ|Q'TY|Single|Double|Triple|Total|M'HGR";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,	false,	"ibflag");
					InitDataProperty(0, cnt++ , dtSeq,					30,		daCenter,	true,		"seq");
					InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	true,		"cntr_tpsz_cd",				false,			"",      dfNone,		0,		false,	false);
					InitDataProperty(0, cnt++ , dtData,					65,		daCenter,	true,		"op_cntr_qty",					false,			"",      dfNullFloat,	2,		false,	false);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,	"crr_hngr_sgl_bar_qty",	false,			"",      dfNullFloat,	2,		true,		true,		6);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,	"crr_hngr_dbl_bar_qty",	false,			"",      dfNullFloat,	2,		true,		true, 	6);
					InitDataProperty(0, cnt++ , dtData,					60,		daRight,		false,	"crr_hngr_tpl_bar_qty",		false,			"",		 dfNullFloat,	2,		true,		true, 6);
					InitDataProperty(0, cnt++ , dtData,					75,		daRight,		false,	"crr_hngr_qty",				false,			"",      dfNullFloat,	2,		false,	false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		true,		"mer_hngr_qty",				false,			"",      dfNullFloat,	2,		true,		true, 	6);
					
					CountPosition = 0;
                }
                 break;

         }
     }
     /**
      * Editing 종료후 Validation Check
      */
     function sheet1_OnAfterEdit(sheetObj,Row,Col){
    	 //checkEditData(sheetObj,Row,Col);
     }    
     function sheet1_OnChange(sheetObj,Row,Col, Val){
    	 checkEditData(sheetObj,Row,Col);
     }         
     /**
      * Single or Double 입력시 Total 자동계산
      */
     function checkEditData(sheetObj,Row,Col){
    	 var chkFlag = false;;
    	 var bkgQty,single,double,mhgr;
    	 
    	 if(ComIsNumber(sheetObj.CellValue(Row,"op_cntr_qty"), ".")){
    		 bkgQty = parseFloat(sheetObj.CellValue(Row,"op_cntr_qty"));
    	 }else{
    		 bkgQty = 0;
    	 }
    	 
		 // Single + Double <= Bkg Qty 여부 확인
		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_sgl_bar_qty"), ".")){
			 single = parseFloat(sheetObj.CellValue(Row,"crr_hngr_sgl_bar_qty"));
		 }else{
			 single = 0;
		 }
		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_dbl_bar_qty"), ".")){
			 double = parseFloat(sheetObj.CellValue(Row,"crr_hngr_dbl_bar_qty"));
		 }else{
			 double = 0;
		 }
		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_tpl_bar_qty"), ".")){
			 triple = parseFloat(sheetObj.CellValue(Row,"crr_hngr_tpl_bar_qty"));
		 }else{
			 triple = 0;
		 }    		 
		 if(single + double + triple > 0){
			 sheetObj.CellValue2(Row,"crr_hngr_qty") = single + double + triple;
		 }else{
			 sheetObj.CellValue2(Row,"crr_hngr_qty") = "";
		 }
		 if(single + double + triple > bkgQty){
			 ComShowCodeMessage("BKG00258");
			 chkFlag = true;
		 }
	 
		 // Merchant Hanger <= Bkg Qty 여부 확인
		 if(ComIsNumber(sheetObj.CellValue(Row,"mer_hngr_qty"), ".")){
			 mhgr = parseFloat(sheetObj.CellValue(Row,"mer_hngr_qty"));
		 }else{
			 mhgr = 0;
		 }    
		 if(mhgr > bkgQty){
			 ComShowCodeMessage("BKG00258");
			 chkFlag = true;
		 }   
			 
    	 if(!chkFlag){    		 
    		 // Total + Merchant Hanger <= Bkg Qty 여부 확인
    		 if(single + double + triple + mhgr > bkgQty){
				 ComShowCodeMessage("BKG00258");
				 chkFlag = true;    			 
    		 }
    	 }
    	 if(chkFlag){
    		 // Validation 에러 후 입력된 값을 Clear 시키고 다시 Total 계산.
    		 sheetObj.CellValue2(Row,Col) = "";
    		 
    		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_sgl_bar_qty"), ".")){
    			 single = parseFloat(sheetObj.CellValue(Row,"crr_hngr_sgl_bar_qty"));
    		 }else{
    			 single = 0;
    		 }
    		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_dbl_bar_qty"), ".")){
    			 double = parseFloat(sheetObj.CellValue(Row,"crr_hngr_dbl_bar_qty"));
    		 }else{
    			 double = 0;
    		 }
    		 if(ComIsNumber(sheetObj.CellValue(Row,"crr_hngr_tpl_bar_qty"), ".")){
    			 triple = parseFloat(sheetObj.CellValue(Row,"crr_hngr_tpl_bar_qty"));
    		 }else{
    			 triple = 0;
    		 }    		 
    		 if(single + double + triple > 0){
    			 sheetObj.CellValue2(Row,"crr_hngr_qty") = single + double + triple;
    		 }else{
    			 sheetObj.CellValue2(Row,"crr_hngr_qty") = "";
    		 }
    	 }
    	 return chkFlag;
     }
     
     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj){
         with(formObj){
        	 for (var i=sheetObj.HeaderRows; i<=sheetObj.LastRow; i++) {
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
		var parentSheet = window.dialogArguments.sheetObjects[0];
		var hngrFlg = "N";
		var hngrQty = 0;
		var merQty = 0;
		for (i = mySheet.HeaderRows; i<= mySheet.LastRow; i++) {
			for (j = 1; j<= parentSheet.LastRow; j++) {
				if (mySheet.CellText(i, "cntr_tpsz_cd") == parentSheet.CellText(j, "cntr_tpsz_cd")){
					parentSheet.CellValue(j, "crr_hngr_sgl_bar_qty") = mySheet.CellValue(i, "crr_hngr_sgl_bar_qty");
					parentSheet.CellValue(j, "crr_hngr_dbl_bar_qty") = mySheet.CellValue(i, "crr_hngr_dbl_bar_qty");
					parentSheet.CellValue(j, "crr_hngr_tpl_bar_qty") = mySheet.CellValue(i, "crr_hngr_tpl_bar_qty");
					parentSheet.CellValue(j, "crr_hngr_qty") = mySheet.CellValue(i, "crr_hngr_qty");
					parentSheet.CellValue(j, "mer_hngr_qty") = mySheet.CellValue(i, "mer_hngr_qty");					
				}
			}			
			if(mySheet.CellValue(i, "crr_hngr_qty") != ""){
				hngrQty = hngrQty + mySheet.CellValue(i, "crr_hngr_qty");
			}
			if(mySheet.CellValue(i, "mer_hngr_qty") != ""){
				merQty = merQty + mySheet.CellValue(i, "mer_hngr_qty");
			}			
		}
		if(hngrQty > 0 || merQty > 0){
			hngrFlg = "Y";
		}
		var calllFunc = formObj.calllFunc.value;
		if(calllFunc != ''){
			eval('window.dialogArguments.'+calllFunc)(hngrFlg);
		}		
     }     
	/* 개발자 작업  끝 */