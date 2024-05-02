/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0890.js
*@FileTitle : Cargo Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.18 김병규
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
     * @class ESM_BKG_0890 : ESM_BKG_0890 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0890() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
   	/* 개발자 작업	*/

 // 공통전역변수

 var tabObjects = new Array();
 var tabCnt = 0 ;
 var beforetab = 1;

 var sheetObjects = new Array();
 var sheetCnt = 0;
 
 var cntr_tpsz_str = "";
 var eq_sub_cntr_tpsz_str = ""; 		
	
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;

 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
          /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
 		var sheetObject1 = sheetObjects[0];
 		var sheetObject2 = sheetObjects[1];
          /*******************************************************/
        var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");
 			
             switch(srcName) {
				case "btn_Add":
					addRow = sheetObject1.DataInsert(-1);
					   sheetObjects[0].CellValue(addRow, "rcv_term_cd") = ComGetObjValue(formObject.rcv_term_cd);
					   sheetObjects[0].CellValue(addRow, "de_term_cd") = ComGetObjValue(formObject.de_term_cd);					
					if(ComGetObjValue(formObject.mixed_flg) != "Y"){
//						sheetObjects[0].CellValue(addRow, "rcv_term_cd") = "";
//						sheetObjects[0].CellValue(addRow, "de_term_cd") = "";
					}else{
						if(ComGetObjValue(formObject.rcv_term_cd) == "M"){
//							sheetObjects[0].CellValue(addRow, "rcv_term_cd") = "";
							sheetObjects[0].CellEditable(addRow, "rcv_term_cd") = true;
						}else{
//							sheetObjects[0].CellValue(addRow, "rcv_term_cd") = ComGetObjValue(formObject.rcv_term_cd);
							sheetObjects[0].CellEditable(addRow, "rcv_term_cd") = false;
						}
						if(ComGetObjValue(formObject.de_term_cd) == "M"){
//							sheetObjects[0].CellValue(addRow, "de_term_cd") = "";
							sheetObjects[0].CellEditable(addRow, "de_term_cd") = true;							
						}else{
//							sheetObjects[0].CellValue(addRow, "de_term_cd") = ComGetObjValue(formObject.de_term_cd);							
							sheetObjects[0].CellEditable(addRow, "de_term_cd") = false;
						}					
					}					
				break;
				
				case "btn_Delete":
					sheetObject1.RowDelete(sheetObject1.SelectRow,false);  
					setTotalVol("1");
				break;	
				
				case "btn_Save":
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
		 //sheetObjects[0].AutoSizeMode = false;
		 
		 var formObj = document.form;
		 if(ComGetObjValue(formObj.callTp) != "B"){// bkg creation이외의 화면(container)
			 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		 }else{
			 // Main에 있는 Qty Dtl 정보 Copy
			 var parentQtyDtlSheet;
			 var parentQuantitySheet;

			 // Main에 있는 QtyDtl 정보 Copy
			 if(ComIsNull(formObj.callSheetIdx1)){
				 if(!opener)
					 parentQtyDtlSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx1.value]);
				 try {
					 parentQtyDtlSheet = eval(opener.sheetObjects[formObj.callSheetIdx1.value]);
				 }catch(e) {
				    ComShowCodeMessage("COM12111");
				 }					 
			 }else{
				 //parentQtyDtlSheet =opener.sheetObjects[3];
				 parentQtyDtlSheet = window.dialogArguments.sheetObjects[3];
			 }
			 var parentQtyDtlRow = parentQtyDtlSheet.Rows;
			 
			 // Main에 있는 Quantity 정보 Copy
			 if(ComIsNull(formObj.callSheetIdx2)){
				 if(!opener)
					 parentQuantitySheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx2.value]);
				 try {
				   	parentQuantitySheet = eval(opener.sheetObjects[formObj.callSheetIdx2.value]);
				 }catch(e) {
				    ComShowCodeMessage("COM12111");
				 }				 
			 }else{
				 //parentQuantitySheet = opener.sheetObjects[0];
				 parentQuantitySheet = window.dialogArguments.sheetObjects[0];
			 }
			 var parentQuantityRow = parentQuantitySheet.Rows;		

			 if(parentQuantitySheet.RowCount > 0){
				 var isCntrFirst = true;
				 var isEqCntrFirst = true;
				 for (var i = 1 ; i < parentQuantityRow ; i++ ){
				     var qtyRow = sheetObjects[1].DataInsert(-1);
				     for(j = 0 ; j <= parentQuantitySheet.LastCol ; j++){
				    	 if ( parentQuantitySheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
				    		 for(var k=0 ; k <= sheetObjects[1].LastCol ; k ++){
				                 if ( sheetObjects[1].ColSaveName(k) == parentQuantitySheet.ColSaveName(j)){	                        	 
				                	 sheetObjects[1].CellValue( qtyRow, sheetObjects[1].ColSaveName(k)) = parentQuantitySheet.CellValue( i , parentQuantitySheet.ColSaveName(j)) ;
				                }            			 
				    		 }
				    	 }
				     }
				}				
			 }			 
			 
			 // Main에 있는 QtyDtl 정보 Copy
			 if(parentQtyDtlSheet.RowCount > 0){
				 for (var i = 1 ; i < parentQtyDtlRow ; i++ ){
				     var qtyDtlRow = sheetObjects[0].DataInsert(-1);
				     for(var j = 0 ; j <= parentQtyDtlSheet.LastCol ; j++){
				    	 if ( parentQtyDtlSheet.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
				    		 for(var k=0 ; k <= sheetObjects[0].LastCol ; k ++){
				                 if ( sheetObjects[0].ColSaveName(k) == parentQtyDtlSheet.ColSaveName(j)){	                        	 
				                	 sheetObjects[0].CellValue( qtyDtlRow, sheetObjects[0].ColSaveName(k)) = parentQtyDtlSheet.CellValue( i , parentQtyDtlSheet.ColSaveName(j)) ;
				                }            			 
				    		 }
				    	 }
				     }
				}
			   
				// Main화면에서 AutoCheck가 아닌 경우만 실행(autoCheck : 저장진행여부)
			    if(!window.dialogArguments.checkAutoCaluate(window.dialogArguments.document.form)){
					   // 기본적인 정보만 Display한다.
		        	// CntrTpSz가 삭제(변경)된 경우 QtyDtl에서 삭제한다. 
			   		for(var i = sheetObjects[0].Rows  ; i >= sheetObjects[0].HeaderRows ; i-- ){
			   			if(sheetObjects[1].FindText("cntr_tpsz_cd", sheetObjects[0].CellValue(i, "cntr_tpsz_cd")) < 0){
			   				sheetObjects[0].RowDelete(i,false);		   				
				   		}
			   		}	   					   
			   		// CntrTpSz가 신규로 등록된 경우
			   		for(var i = sheetObjects[1].HeaderRows  ; i < sheetObjects[1].Rows ; i++ ){
			   			if(sheetObjects[0].FindText("cntr_tpsz_cd", sheetObjects[1].CellValue(i, "cntr_tpsz_cd")) < 0){
			 			   cntrQty = sheetObjects[1].CellValue(i, "op_cntr_qty");
						   // EQ Sub가 있으면 Total Qty에서 Eq Sub를 뺀다.			   
						   eqSubSameQty = false;
						   if(sheetObjects[1].CellValue(i, "eq_subst_cgo_qty") > 0){
							   if(sheetObjects[1].CellValue(i, "op_cntr_qty") == sheetObjects[1].CellValue(i, "eq_subst_cgo_qty")){
								   eqSubSameQty = true;
								   existEqSub = false;
							   }else{
								   existEqSub = true;
							   }
							   
						   }else{
							   existEqSub = false;
						   }
						   socSameQty = false;
						   if(sheetObjects[1].CellValue(i, "soc_qty") > 0){
							   if(sheetObjects[1].CellValue(i, "op_cntr_qty") == sheetObjects[1].CellValue(i, "soc_qty")){
								   socSameQty = true;
							   }
						   }
						   
						   if(existEqSub){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "eq_subst_cgo_qty");
							   
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd");				   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "eq_subst_cgo_qty");
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, sheetObjects[1].CellValue(i, "rd_cgo_flg"), sheetObjects[1], "N");
							   }
						   }
						   // SOC가 존재하면 Total Qty에서 SOC를 뺀다.
						   if(sheetObjects[1].CellValue(i, "soc_qty") > 0 && sheetObjects[1].CellValue(i, "op_cntr_qty") != sheetObjects[1].CellValue(i, "soc_qty")){
							   existSocQty = true;
						   }else{
							   existSocQty = false;
						   }			   
						   if(existSocQty){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "soc_qty");

							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "soc_qty");	
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
							   }
						   }			   
						   // Hanger가 존재하는 경우 Row 추가 후 자동 계산
						   if( sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty") > 0){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty");
						 
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg") = 1;
							   if(socSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
							   }								   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty");
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }
						   if( sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty") > 0){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty");
						 
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg") = 1;
							   if(socSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
							   }								   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty");			
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }				
						   if( sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty") > 0){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty");
						 
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg") = 1;
							   if(socSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
							   }								   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty");			
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }			
						   if( sheetObjects[1].CellValue(i, "mer_hngr_qty") > 0){
							   cntrQty = cntrQty-sheetObjects[1].CellValue(i, "mer_hngr_qty");
						 
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "mer_hngr_flg") = 1;
							   if(socSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
							   }								   
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "mer_hngr_qty");	
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
							   
							   if(isAutoChk()){
								   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
							   }
						   }	
						   if(cntrQty > 0){					   
							   qtyDtlRow = sheetObjects[0].DataInsert(-1);
							   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
							   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = cntrQty;
							   if(eqSubSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd");
							   }						   
							   if(socSameQty){
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
							   }								   
							   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
							   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);						   
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");	
						   }
				   		}else{
				   			// Quantity에서 변경한 정보를 QtyDtl에 반영한다.
				   			// 01. Quantity에 존재하는 EqSubVol과 QtyDtl Vol 비교
				   			if(sheetObjects[1].CellValue(i, "eq_subst_cgo_qty") > 0){
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd") &&
				   						sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "eq_subst_cntr_tpsz_cd") ){
				   						
				   						addRow = false;

				   						// QtyDtl에도 EqSub가 존재하면 EqSubVol를 새로 덮어쓴다.
				   						// [CHM-201642008] BKG Creation에서 팝업 열 때 js상 잘못된 데이터 입력 방지차원
//				   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "eq_subst_cgo_qty");		   						
				   						
				   						break;
				   					}
				   				}
				   				if(addRow){
				 				   // Quantity에는 EqSub 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd");				   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "eq_subst_cgo_qty");
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, sheetObjects[1].CellValue(i, "rd_cgo_flg"), sheetObjects[1] , "N");
								   }
				   				}
				   			}
				   			// 02. Quantity에 존재하는 SocVol과 QtyDtl Vol 비교		   			
				   			if(sheetObjects[1].CellValue(i, "soc_qty") > 0){
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd") &&
				   						sheetObjects[0].CellValue(k, "soc_flg") == 1){		   						
				   						
				   						addRow = false;
			
				   						// QtyDtl에도 Soc가 존재하면 SocVol를 새로 덮어쓴다.
				   						// 이미 SOC가 저장 되었음에도 이 화면이 열릴 때 마다 SOC Vol을 다시 덮어쓰기 때문에 주석처리
//				   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "soc_qty");
				   						
				   						break;
				   					}
				   				}
				   				if(addRow){
				 				   // Quantity에는 Soc 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "soc_qty");		
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
								   }
				   				}
				   			} 
				   			
				   			// 03. Quantity에 존재하는 Hanger과 QtyDtl Vol 비교		
				   			if(sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty") > 0){
				   				
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].CellValue(k, "crr_hngr_sgl_bar_use_flg") == 1 || 
				   						   BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].CellValue(i, "op_cntr_qty"))){
					   						addRow = false;

					   						// QtyDtl에도 Sgl 존재하면 SglVol를 새로 덮어쓴다.
					   					    // [CHM-201642008] BKG Creation에서 팝업 열 때 js상 잘못된 데이터 입력 방지차원
//					   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty");
					   						
					   						break;				   							
				   						}
				   					}
				   				}

				   				if(addRow){
				 				   // Quantity에는 Sgl 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg") = 1;			   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty");	
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 		
				   			if(sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty") > 0){
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].CellValue(k, "crr_hngr_dbl_bar_use_flg") == 1 || 
				   						   BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].CellValue(i, "op_cntr_qty"))){
					   						addRow = false;

					   						// QtyDtl에도 Sgl 존재하면 SglVol를 새로 덮어쓴다.
					   					    // [CHM-201642008] BKG Creation에서 팝업 열 때 js상 잘못된 데이터 입력 방지차원
//					   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty");
					   						
					   						break;				   							
				   						}
				   					}
				   				}
				   				if(addRow){
				 				   // Quantity에는 Dbl 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg") = 1;			   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty");		
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			   			

				   			if(sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty") > 0){
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].CellValue(k, "crr_hngr_tpl_bar_use_flg") == 1 || 
				   						   BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].CellValue(i, "op_cntr_qty"))){
					   						addRow = false;

					   						// QtyDtl에도 Sgl 존재하면 SglVol를 새로 덮어쓴다.
					   					    // [CHM-201642008] BKG Creation에서 팝업 열 때 js상 잘못된 데이터 입력 방지차원
//					   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty");
					   						
					   						break;				   							
				   						}
				   					}				   					
				   				}
				   				if(addRow){
				 				   // Quantity에는 Tpl 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg") = 1;			   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty");			
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			   			
				   			if(sheetObjects[1].CellValue(i, "mer_hngr_qty") > 0){
				   				addRow = true;
				   				for(var k = sheetObjects[0].HeaderRows  ; k < sheetObjects[0].Rows ; k++ ){
				   					if(	sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(k, "cntr_tpsz_cd")){
				   						if(sheetObjects[0].CellValue(k, "mer_hngr_flg") == 1 || 
				   						   BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_qty")) + BkgParseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) == BkgParseFloat(sheetObjects[1].CellValue(i, "op_cntr_qty"))){
					   						addRow = false;

					   						// QtyDtl에도 Sgl 존재하면 SglVol를 새로 덮어쓴다.
					   					    // [CHM-201642008] BKG Creation에서 팝업 열 때 js상 잘못된 데이터 입력 방지차원
//					   						sheetObjects[0].CellValue(k, "op_cntr_qty") = sheetObjects[1].CellValue(i, "mer_hngr_qty");
					   						
					   						break;				   							
				   						}
				   					}								   					
				   				}
				   				if(addRow){
				 				   // Quantity에는 Mer 존재, QtyDtl에는 미존재
				   					qtyDtlRow = sheetObjects[0].DataInsert(-1);
								   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								   sheetObjects[0].CellValue(qtyDtlRow, "mer_hngr_flg") = 1;			   
								   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = sheetObjects[1].CellValue(i, "mer_hngr_qty");		
								   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
								   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
								   
								   if(isAutoChk()){
									   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
								   }
				   				}
				   			} 			  
				   			// 전체 Vol을 바꾸어야 하면 여기에 추가. (type이 정해지지 않은 dry의 변경된 vol)	   			
				   		}

			   		}
		   			// QtyDtl에 있던 정보를 Booking에서 삭제한 경우.(QtyDtl에는 있는데 Quantity에는 없는 경우)	   		
		   			for(var i = sheetObjects[0].HeaderRows  ; i < sheetObjects[0].Rows ; i++ ){
		   				cntrTpSz = sheetObjects[0].CellValue(i, "cntr_tpsz_cd");
		   				qtyRow = sheetObjects[1].FindText("cntr_tpsz_cd", cntrTpSz);
		   				if(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") != ""){	   					
		   					if(sheetObjects[1].CellValue(qtyRow,"eq_subst_cntr_tpsz_cd") == ""){
		   						// EqSub 삭제한 경우
		   						if(sheetObjects[1].CellValue(qtyRow, "op_cntr_qty") == sheetObjects[0].CellValue(i, "op_cntr_qty")){
		   							sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") = "";
		   						}else{
		   							sheetObjects[0].RowDelete(i,false);
		   						}
		   					}	   					
		   				}
		   				if(sheetObjects[0].CellValue(i, "soc_flg") == 1){
		   					if(sheetObjects[1].CellValue(qtyRow,"soc_qty") <= 0){
		   						// Soc 삭제한 경우
		   						if(sheetObjects[1].CellValue(qtyRow, "op_cntr_qty") == sheetObjects[0].CellValue(i, "op_cntr_qty")){
		   							sheetObjects[0].CellValue(i, "soc_flg") = 0;
		   						}else{
		   							sheetObjects[0].RowDelete(i,false);
		   						}
		   					}	   					
		   				}	   				
		   			}
					// RD Term이 'M'이 아닌 경우 Main에 있는 RD Term으로 변경한다.
					for(var i = sheetObjects[0].HeaderRows  ; i < sheetObjects[0].Rows ; i++ ){
						if(ComGetObjValue(formObj.rcv_term_cd) != "M"){
							sheetObjects[0].CellValue(i, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						}
						if(ComGetObjValue(formObj.de_term_cd) != "M"){
							sheetObjects[0].CellValue(i, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						}						
					}		   			
			    }
				

			 }else{
				 // 저장된 데이터가 없는 경우 Quantity 정보를 바탕으로 자동 체크해준다.
				 if(parentQuantitySheet.RowCount > 0){

				   for(var i = parentQuantitySheet.HeaderRows  ; i < parentQuantitySheet.Rows ; i++ ){			   
					   cntrQty = parentQuantitySheet.CellValue(i, "op_cntr_qty");
					   // EQ Sub가 있으면 Total Qty에서 Eq Sub를 뺀다.
					   eqSubSameQty = false;
					   if(parentQuantitySheet.CellValue(i, "eq_subst_cgo_qty") > 0){
						   if(parentQuantitySheet.CellValue(i, "op_cntr_qty") == parentQuantitySheet.CellValue(i, "eq_subst_cgo_qty")){
							   eqSubSameQty = true;
							   existEqSub = false;
						   }else{
							   existEqSub = true;
						   }
						   
					   }else{
						   existEqSub = false;
					   }
					   socSameQty = false;
					   if(parentQuantitySheet.CellValue(i, "soc_qty") > 0){
						   if(parentQuantitySheet.CellValue(i, "op_cntr_qty") == parentQuantitySheet.CellValue(i, "soc_qty")){
							   socSameQty = true;
						   }
					   }
					   
					   if(existEqSub){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "eq_subst_cgo_qty");
						   
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "eq_subst_cntr_tpsz_cd");				   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "eq_subst_cgo_qty");
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);	
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, parentQuantitySheet.CellValue(i, "rd_cgo_flg"), sheetObjects[1], "N");
						   }
					   }
					   // SOC가 존재하면 Total Qty에서 SOC를 뺀다.
					   if(parentQuantitySheet.CellValue(i, "soc_qty") > 0 && parentQuantitySheet.CellValue(i, "op_cntr_qty") != parentQuantitySheet.CellValue(i, "soc_qty")){
						   existSocQty = true;
					   }else{
						   existSocQty = false;
					   }			   
					   if(existSocQty){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "soc_qty");

						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "soc_qty");			
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
						   }
					   }			   
					   // Hanger가 존재하는 경우 Row 추가 후 자동 계산
					   if( parentQuantitySheet.CellValue(i, "crr_hngr_sgl_bar_qty") > 0){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "crr_hngr_sgl_bar_qty");
					 
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_sgl_bar_use_flg") = 1;
						   if(socSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
						   }							   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "crr_hngr_sgl_bar_qty");
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }
					   if( parentQuantitySheet.CellValue(i, "crr_hngr_dbl_bar_qty") > 0){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "crr_hngr_dbl_bar_qty");
					 
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_dbl_bar_use_flg") = 1;
						   if(socSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
						   }							   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "crr_hngr_dbl_bar_qty");		
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }				
					   if( parentQuantitySheet.CellValue(i, "crr_hngr_tpl_bar_qty") > 0){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "crr_hngr_tpl_bar_qty");
					 
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "crr_hngr_tpl_bar_use_flg") = 1;
						   if(socSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
						   }							   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "crr_hngr_tpl_bar_qty");			
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }			
					   if( parentQuantitySheet.CellValue(i, "mer_hngr_qty") > 0){
						   cntrQty = cntrQty-parentQuantitySheet.CellValue(i, "mer_hngr_qty");
					 
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "mer_hngr_flg") = 1;
						   if(socSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
						   }							   
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = parentQuantitySheet.CellValue(i, "mer_hngr_qty");			
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);
						   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "Y");
						   }
					   }	
					   
					   if(cntrQty > 0){
						   qtyDtlRow = sheetObjects[0].DataInsert(-1);
						   sheetObjects[0].CellValue(qtyDtlRow, "cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "cntr_tpsz_cd");
						   sheetObjects[0].CellValue(qtyDtlRow, "op_cntr_qty") = cntrQty;
						   if(eqSubSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "eq_subst_cntr_tpsz_cd") = parentQuantitySheet.CellValue(i, "eq_subst_cntr_tpsz_cd");
						   }
						   if(socSameQty){
							   sheetObjects[0].CellValue(qtyDtlRow, "soc_flg") = 1;			 
						   }							   
						   sheetObjects[0].CellValue(qtyDtlRow, "rcv_term_cd") = ComGetObjValue(formObj.rcv_term_cd);
						   sheetObjects[0].CellValue(qtyDtlRow, "de_term_cd") = ComGetObjValue(formObj.de_term_cd);					   
						   if(isAutoChk()){
							   setDefaultCheckCgTp(sheetObjects[0], formObj, qtyDtlRow, "", sheetObjects[1], "N");
						   }						   
					   }
				   }
				 }				 
			 }
			 
			 // Main에 있는 Quantity 정보 Copy	 
			 if(parentQuantitySheet.RowCount > 0){
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
			 }
		 }
		 
	    // 2018.05.16 iylee CNTR TYPE : D7이면서 EQ Sub : D4 or D5 인 경우, Dry로 체크하고 다른 Type으로 수정하지 못하게 한다.
    	for(var i = 1 ; i < sheetObjects[0].Rows ; i++){
    		if(sheetObjects[0].CellValue(i, "cntr_tpsz_cd") == "D7" && 
    			(sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") == "D4" || sheetObjects[0].CellValue(i, "eq_subst_cntr_tpsz_cd") == "D5")){
    			sheetObjects[0].CellValue(i, "dry_cgo_flg") = 1;
    			sheetObjects[0].CellValue(i, "dcgo_flg") = 0;
    			sheetObjects[0].CellValue(i, "rc_flg") = 0;
    			sheetObjects[0].CellValue(i, "awk_cgo_flg") = 0;
    			sheetObjects[0].CellValue(i, "bb_cgo_flg") = 0;
    			
    			sheetObjects[0].CellEditable(i, "dry_cgo_flg") = false;
    			sheetObjects[0].CellEditable(i, "dcgo_flg") = false;
    			sheetObjects[0].CellEditable(i, "rc_flg") = false;
    			sheetObjects[0].CellEditable(i, "awk_cgo_flg") = false;
    			sheetObjects[0].CellEditable(i, "bb_cgo_flg") = false;
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
 		 var sheetID = sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
                     // 높이 설정
                     style.height = 220;
                     // 전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo(2, 1, 7, 100);

                    var HeadTitle1 = "|TP/SZ|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|Cargo Information|R/D Term|R/D Term|VOL";
 					var HeadTitle2 = "|TP/SZ|DR|DG|RF|AK|BB|S/HGR|D/HGR|T/HGR|M/HGR|EQ SUB TP/SZ|SOC|R|D|VOL";
 					var headCount = ComCountHeadTitle(HeadTitle1);
 										
                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(16, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(false, true, false, true, false,false);

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
                     InitHeadRow(1, HeadTitle2, true);


                     //데이터속성    [ROW, COL,  DATATYPE,		WIDTH,	DATAALIGN, COLMERGE,	SAVENAME,  						KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,		30,		daCenter,		false,			"ibflag");
 					 InitDataProperty(0, cnt++ , dtComboEdit,		50,     	daCenter,    	false,			"cntr_tpsz_cd",          			false,    	"",      				dfNone, 			0,     	true,		true, 2);
 					 InitDataProperty(0, cnt++ , dtCheckBox,			40,     	daCenter,    	false,			"dry_cgo_flg",         			false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox,			40,     	daCenter,    	false,     		"dcgo_flg",           				false,    	"",      				dfNone, 			0,     	true,		true);                                                                                                                                            																																	 
 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,    	false,     		"rc_flg",      						false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,  	 	false,     		"awk_cgo_flg",       				false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox, 		40,     	daCenter,  	 	false,     		"bb_cgo_flg",       				false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox, 		60,     	daCenter,  	 	false,     		"crr_hngr_sgl_bar_use_flg",	false,    	"",      				dfNone, 			0,     	true,		true); 
 					 InitDataProperty(0, cnt++ , dtCheckBox, 		60,     	daCenter,    	false,     		"crr_hngr_dbl_bar_use_flg", 	false,    	"",      				dfNone,		  	0,     	true,		true);                                                                                                                                            																												 
 					 InitDataProperty(0, cnt++ , dtCheckBox,			60,     	daCenter,	 	false,     		"crr_hngr_tpl_bar_use_flg", 	false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox,			60,     	daCenter,	 	false,     		"mer_hngr_flg",   	  			false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtComboEdit,		90,     	daCenter,    	false,     		"eq_subst_cntr_tpsz_cd",    	false,    	"",      				dfNone,      	0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtCheckBox,			40,     	daCenter,	 	false,     		"soc_flg",   	  					false,    	"",      				dfNone, 			0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtComboEdit,		35,     	daCenter, 	 	false,     		"rcv_term_cd",           			false,    	"",      				dfNone, 		  	0,     	true,		true);
 					 InitDataProperty(0, cnt++ , dtComboEdit,		35,     	daCenter, 	 	false,     		"de_term_cd",          			false,    	"",      				dfNone,      	0,     	true,		true); 
 					 InitDataProperty(0, cnt++ , dtData,      			50,     	daRight,     	false,     		"op_cntr_qty",          			false,    	"",      				dfNullFloat,		2,     	true,		true,	5);
 					 
 					 InitDataValid(0,  "cntr_tpsz_cd",				vtEngUpOther,	"1234567890");		// 영문대문자+숫자 입력
 					 CountPosition = 0;		// Total 없음.
 					 

 					sheetObj.SetMergeCell(0, 1, 2, 1);
 					sheetObj.SetMergeCell(0, 15, 2, 1); 
 				}
 				break;                
 			case "sheet2":
				with (sheetObj) {
					// 높이 설정
					style.height = 0;
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;
					
					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
					
					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msAll;
					
					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;
					
					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo( 1, 1, 3, 100);
					
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(11, 0, 0, true);
					
					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(false, false, false, false, false,false)
					
					var HeadTitle = "|TP/SZ|Vol.|EQ Sub|EQ Sub|EQ Sub|S.O.C|S/HGR|D/HGR|T/HGR|HGR VOL|M/HGR";
					
					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle, true);
					
					
					//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
					InitDataProperty(0, cnt++ , dtData,					45,		daCenter,	false,		"cntr_tpsz_cd",				false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		false,		"op_cntr_qty",					false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					30,		daCenter,	false,		"eq_subst_cntr_tpsz_cd",	false,		"",	dfNone,		0,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					70,		daRight,		false,		"eq_subst_cgo_qty",		false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					35,		daCenter,	false,		"rd_cgo_flg",					false,		"",	dfNone,		0,		false,		false);    					
					InitDataProperty(0, cnt++ , dtData,					40,		daRight,		false,		"soc_qty",						false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,		"crr_hngr_sgl_bar_qty",	false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,		"crr_hngr_dbl_bar_qty",	false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,		"crr_hngr_tpl_bar_qty",		false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,		"crr_hngr_qty",				false,		"",	dfNullFloat,	2,		false,		false);
					InitDataProperty(0, cnt++ , dtData,					50,		daRight,		false,		"mer_hngr_qty",				false,		"",	dfNullFloat,	2,		false,		false);
					
					CountPosition = 0;
				}
				break; 				
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
			case IBSEARCH:      //조회
    			ComSetObjValue(formObj.f_cmd, SEARCH);
    			var sXml = sheetObj.GetSearchXml("ESM_BKG_0890GS.do", FormQueryString(formObj));    			
    			var arrXml = sXml.split("|$$|");  
				if (arrXml.length > 0){	// R Term
					setIBCombo(sheetObjects[0],arrXml[0],"rcv_term_cd",false,0, " ", " ", "val");
				}             		
				if (arrXml.length > 1){	// D Term
					setIBCombo(sheetObjects[0],arrXml[1],"de_term_cd",false,0, " ", " ", "val");
				}      														
		
				// Booking Creation에서 호출한 경우는 Main에서 받아오고 그 외에는 조회결과를 담는다.

				if(ComGetObjValue(formObj.callTp) != "B"){
					if (arrXml.length > 2){			
						sheetObjects[0].LoadSearchXml(arrXml[2]);
					}								
					if (arrXml.length > 3){			
						sheetObjects[1].LoadSearchXml(arrXml[3]);
					}					
					BkgEtcDataXmlToForm(arrXml[0], formObj);										
				}

				// CntrTpSz,EqSubCntrTpSz Combo List 셋팅
				if(sheetObjects[1].Rows > 1){
					var isCntrFirst = true;
					var isEqCntrFirst = true;
					for (var i = 1 ; i < sheetObjects[1].Rows ; i++ ){
						if(!ComIsNull(sheetObjects[1].CellValue(i, "cntr_tpsz_cd"))){
							if(cntr_tpsz_str.indexOf(sheetObjects[1].CellValue(i, "cntr_tpsz_cd")) < 0){
								if(isCntrFirst){
									cntr_tpsz_str = sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
									isCntrFirst = false;
								}else{
									cntr_tpsz_str = cntr_tpsz_str + "|" + sheetObjects[1].CellValue(i, "cntr_tpsz_cd");
								}
							}
						}
						if(!ComIsNull(sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd"))){
							if(eq_sub_cntr_tpsz_str.indexOf(sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd")) < 0){
								if(isEqCntrFirst){
									eq_sub_cntr_tpsz_str = " |" + sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd");
									isEqCntrFirst = false;
								}else{
									eq_sub_cntr_tpsz_str = eq_sub_cntr_tpsz_str + "|" + sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd");
								}
							}						 
						}
					}
					sheetObjects[0].InitDataCombo(0,"cntr_tpsz_cd", cntr_tpsz_str, cntr_tpsz_str);
					sheetObjects[0].InitDataCombo(0,"eq_subst_cntr_tpsz_cd", eq_sub_cntr_tpsz_str, eq_sub_cntr_tpsz_str);					
				}
				// InitDataCombo 후에 Load를 해줘야 데이터가 보임.
				if(ComGetObjValue(formObj.callTp) != "B"){
					if (arrXml.length > 2){			
						sheetObjects[0].LoadSearchXml(arrXml[2]);
					}								
					if (arrXml.length > 3){			
						sheetObjects[1].LoadSearchXml(arrXml[3]);
					}

					ComBtnDisable("btn_Save");
					ComBtnDisable("btn_Add");
					ComBtnDisable("btn_Delete");
				}else{					
					ComBtnEnable("btn_Add");
					ComBtnEnable("btn_Delete");
					if(ComGetObjValue(formObj.bdr_flg)=="Y"&&ComGetObjValue(formObj.ca_flg)=="N"){
						ComBtnDisable("btn_Save");
					} else {
						ComBtnEnable("btn_Save");					
					}
				}
				
				if(ComGetObjValue(formObj.bdr_flg)=="Y"&&ComGetObjValue(formObj.ca_flg)=="N"){
				} else {
					ComBtnEnable("btn_Save");					
				}
				
				setTotalVol("1");
				setBkgTotalVol();
				
				// Hidden Column 셋팅
				if(ComGetObjValue(formObj.dcgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "dcgo_flg", 0);
					sheetObjects[0].ColHidden("dcgo_flg") = true;		
				}
				if(ComGetObjValue(formObj.rc_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "rc_flg", 0);
					sheetObjects[0].ColHidden("rc_flg") = true;
				}
				if(ComGetObjValue(formObj.awk_cgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "awk_cgo_flg", 0);
					sheetObjects[0].ColHidden("awk_cgo_flg") = true;
				}
				if(ComGetObjValue(formObj.bb_cgo_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "bb_cgo_flg", 0);
					sheetObjects[0].ColHidden("bb_cgo_flg") = true;
				}	
				var isSingle = true;
				var isDouble = true;
				var isTriple = true;
				var mHgr = true;
				for(var i = 1 ; i < sheetObjects[1].Rows ; i++ ){
					if(isSingle){						
						if(sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty") != "" && parseFloat(sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty")) > 0){
							isSingle = false;
						}						
					}
					if(isDouble){
						if(sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty") != "" && parseFloat(sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty")) > 0){
							isDouble = false;
						}						
					}
					if(isTriple){
						if(sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty") != "" && parseFloat(sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty")) > 0){
							isTriple = false;
						}						
					}	
					if(mHgr){
						if(sheetObjects[1].CellValue(i, "mer_hngr_qty") != "" && parseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) > 0){
							mHgr = false;
						}						
					}						
				}
				if(isSingle){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_sgl_bar_use_flg", 0);
				}
				if(isDouble){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_dbl_bar_use_flg", 0);
				}
				if(isTriple){
					changeCheckAllBySaveName(sheetObjects[0], "crr_hngr_tpl_bar_use_flg", 0);
				}	
				if(mHgr){
					changeCheckAllBySaveName(sheetObjects[0], "mer_hngr_flg", 0);
				}					
				sheetObjects[0].ColHidden("crr_hngr_sgl_bar_use_flg") = isSingle;
				sheetObjects[0].ColHidden("crr_hngr_dbl_bar_use_flg") = isDouble;
				sheetObjects[0].ColHidden("crr_hngr_tpl_bar_use_flg") = isTriple;
				sheetObjects[0].ColHidden("mer_hngr_flg") = mHgr;
				if(ComGetObjValue(formObj.eq_subst_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "eq_subst_cntr_tpsz_cd", "");
					sheetObjects[0].ColHidden("eq_subst_cntr_tpsz_cd") = true;
				}			
				if(ComGetObjValue(formObj.soc_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "soc_flg", 0);
					sheetObjects[0].ColHidden("soc_flg") = true;
				}			
				if(ComGetObjValue(formObj.mixed_flg) != "Y"){
					changeCheckAllBySaveName(sheetObjects[0], "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
					sheetObjects[0].ColHidden("rcv_term_cd") = true;

					changeCheckAllBySaveName(sheetObjects[0], "de_term_cd", ComGetObjValue(formObj.de_term_cd));
					sheetObjects[0].ColHidden("de_term_cd") = true;
				}else{
					if(ComGetObjValue(formObj.callTp) == "B"){
						if(ComGetObjValue(formObj.rcv_term_cd) == "M"){
							changeEditableBySaveName(sheetObjects[0], "rcv_term_cd", true);
						}else{
							changeCheckAllBySaveName(sheetObjects[0], "rcv_term_cd", ComGetObjValue(formObj.rcv_term_cd));
							changeEditableBySaveName(sheetObjects[0], "rcv_term_cd", false);
						}
						if(ComGetObjValue(formObj.de_term_cd) == "M"){
							changeEditableBySaveName(sheetObjects[0], "de_term_cd", true);
						}else{
							changeCheckAllBySaveName(sheetObjects[0], "de_term_cd", ComGetObjValue(formObj.de_term_cd));
							changeEditableBySaveName(sheetObjects[0], "de_term_cd", false);
						}		
					}
				}

				sheetObjects[0].FitColWidth();
				
			break;
			
			case IBSAVE:        //저장
				if(validateForm(sheetObj,formObj,sAction)){
					if(ComGetObjValue(formObj.callTp) == "B"){
						// Main으로 정보 전달
						setPopToMain(sheetObj, formObj);
					}else{
						// 현재는 button이 비활성화되어있음
		    			ComSetObjValue(formObj.f_cmd, MULTI);					
						var params = FormQueryString(formObj);	
						params = params + "&" + ComSetPrifix(sheetObj.GetSaveString(true),"sheet1_");
						var sXml = sheetObj.GetSaveXml("ESM_BKG_0890GS.do", params);						
						if(ComGetEtcData(sXml, "SuccessYn") == "Y"){
							ComBkgSaveCompleted();
						}
					}
				}
			break;
         }
     }

     /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
/*    	  
    	 var totalArr = ComGetObjValue(formObj.total_vol).split(","); 
    	 var bkgArr = ComGetObjValue(formObj.bkg_vol).split(",");
    	 // Booking Vol 과 Total Vol 이 다르면 Save 불가
    	 if(totalArr.length != bkgArr.length){
    		 ComShowCodeMessage("BKG00493");
    		 return false;
    	 }
    	 for(var i = 0 ; i < bkgArr.length ; i++){
    		 if(ComGetObjValue(formObj.total_vol).indexOf(bkgArr[i]) < 0){
        		 ComShowCodeMessage("BKG00493");
        		 return false;    			 
    		 }
    	 }
*/    	 
		// 20090909 추가 - Hanger에서 지정된 hanger TP 별 개수와 차이가 있는 경우 SAVE 금지.(BKG02007)    			
		// 20090909 추가 - 지정된 TP/SZ별 EQ-Sub와 volume이 맞지 않는 경우 SAVE 금지.(BKG02008)    			
		// 20090909 추가 - Booking의 TP/SZ 별 합과 EQ Detail에서의 TP/SZ별 합이 다른 경우 SAVE 금지.(BKG02009)        			
		for(var i = sheetObjects[1].HeaderRows ; i < sheetObjects[1].Rows ; i++){
			var sumSingle = 0;
			var sumDouble = 0;
			var sumTriple = 0;
			var sumMer = 0;
			var eqSubVol = 0;
			var sumEqDtlVol = 0;
			for(var j = sheetObjects[0].HeaderRows ; j < sheetObjects[0].Rows ; j++){
				if(sheetObjects[1].CellValue(i, "cntr_tpsz_cd") == sheetObjects[0].CellValue(j, "cntr_tpsz_cd")){
					if(sheetObjects[0].CellValue(j, "crr_hngr_sgl_bar_use_flg") == 1){
						sumSingle = sumSingle + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));	
						sumSingle = parseFloat(sumSingle.toFixed(2));
					}
					if(sheetObjects[0].CellValue(j, "crr_hngr_dbl_bar_use_flg") == 1){
						sumDouble = sumDouble + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));
						sumDouble = parseFloat(sumDouble.toFixed(2));
					}
					if(sheetObjects[0].CellValue(j, "crr_hngr_tpl_bar_use_flg") == 1){
						sumTriple = sumTriple + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));
						sumTriple = parseFloat(sumTriple.toFixed(2));
					}
					if(sheetObjects[0].CellValue(j, "mer_hngr_flg") == 1){
						sumMer = sumMer + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));
						sumMer = parseFloat(sumMer.toFixed(2));
					}				
					
					if(sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd") != ""){
						if(sheetObjects[1].CellValue(i, "eq_subst_cntr_tpsz_cd") == sheetObjects[0].CellValue(j, "eq_subst_cntr_tpsz_cd")){
							eqSubVol = eqSubVol + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));
							eqSubVol = parseFloat(eqSubVol.toFixed(2));
						}    							
					}	
					sumEqDtlVol = sumEqDtlVol + BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty"));
					sumEqDtlVol = parseFloat(sumEqDtlVol.toFixed(2));
				}			
				if(BkgParseFloat(sheetObjects[0].CellValue(j, "op_cntr_qty")) <= 0){
					ComShowCodeMessage("BKG00013");
					return false;					
				}
			}    				
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_sgl_bar_qty")) != sumSingle){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_dbl_bar_qty")) != sumDouble){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "crr_hngr_tpl_bar_qty")) != sumTriple){
				ComShowCodeMessage("BKG02007");
				return false;
			}
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "mer_hngr_qty")) != sumMer){
				ComShowCodeMessage("BKG02007");
				return false;
			}    			
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "eq_subst_cgo_qty")) != eqSubVol){
				ComShowCodeMessage("BKG02008", sheetObjects[1].CellValue(i, "cntr_tpsz_cd"));
				return false;    					
			}
			if(BkgParseFloat(sheetObjects[1].CellValue(i, "op_cntr_qty")) != sumEqDtlVol){
				ComShowCodeMessage("BKG00493", sheetObjects[1].CellValue(i, "cntr_tpsz_cd"), sheetObjects[1].CellValue(i, "cntr_tpsz_cd"));
				return false;    					
			}    				
		}		    	 
         return true;         
     }

     // 화면에 있는 정보를 Booking Creation화면으로 전달한다.
    function setPopToMain(sheetObj, formObj){
 		// 20100107 R/D Term에 'M'이 존재하면 안된다.
 		for ( i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
 			if(sheetObj.CellValue(i, "rcv_term_cd") == "M" || sheetObj.CellValue(i, "de_term_cd") == "M"){
 				ComShowCodeMessage("BKG00853");				
 				return;
 			}
 		}
     	// Main에 있는 Qty Dtl 정보 Copy
 		 var parentQtyDtlSheet;
 		 // Main에 있는 QtyDtl 정보 Copy
 		 if(ComIsNull(formObj.callSheetIdx1)){
 			 if(!opener)
 				 parentQtyDtlSheet = eval(window.dialogArguments.sheetObjects[formObj.callSheetIdx1.value]);
 			 try {
 				 parentQtyDtlSheet = eval(opener.sheetObjects[formObj.callSheetIdx1.value]);
 			 }catch(e) {
 			    ComShowCodeMessage("COM12111");
 			 }		
 		 }else{
 			 //parentQtyDtlSheet =opener.sheetObjects[3];
 			 parentQtyDtlSheet =window.dialogArguments.sheetObjects[3];
 		 }

 		 parentQtyDtlSheet.RemoveAll();

          for ( i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
              var iRow = parentQtyDtlSheet.DataInsert(-1);
              for(j = 0 ; j <= sheetObj.LastCol ; j++){            	 
             	 if ( sheetObj.ColSaveName(j) != "" ) {   // 현재 SaveName이 없는것들을 걸러내기위한조건	            		 
             		 for(k=0 ; k <= parentQtyDtlSheet.LastCol ; k ++){
                          if ( parentQtyDtlSheet.ColSaveName(k) == sheetObj.ColSaveName(j)){	                        	 
                         	 parentQtyDtlSheet.CellValue( iRow, parentQtyDtlSheet.ColSaveName(k)) = sheetObj.CellValue( i , sheetObj.ColSaveName(j)) ;
                         }                        
             		 }
             	 }
              }
 	 	}
 	 	
  		var calllFunc = ComGetObjValue(formObj.func);
  		var autoFlg = ComGetObjValue(formObj.auto_flg);
  		
  		window.returnValue = autoFlg;
  		window.close();
 /* 		
 		if(calllFunc != ''){
 			 if(!opener)
 				 //eval('window.dialogArguments.'+calllFunc)(autoFlg);
 			 try {
 				 //eval('opener.'+calllFunc)(autoFlg);
 			 }catch(e) {
 			    //ComShowCodeMessage("COM12111");
 			 }		
 		}
 		//window.close();
 */		
    }
    	
    	
    // SaveName별 체크값을 전체 변경한다.
    function changeCheckAllBySaveName(sheetObj, saveName, chkValue){
		if(sheetObj.RowCount > 0){
			for ( i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
				sheetObj.CellValue(i, saveName) = chkValue;
		 	}
		}    	
    }
    // Cell별로 Editable처리를 한다.    
    function changeEditableBySaveName(sheetObj, saveName, editable){
		if(sheetObj.RowCount > 0){
			for ( i = sheetObj.HeaderRows ; i < sheetObj.Rows ; i++ ){
				sheetObj.CellEditable(i, saveName) = editable;
		 	}
		}    	
    }
    
 	function sheet1_OnChange(sheetObj, Row, Col, Value){
		setTotalVol("1");
	}		

	function sheet1_OnAfterEdit(sheetObj, Row, Col){		
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			if(BkgParseFloat(sheetObj.CellValue(Row, Col)) <= 0){
				ComShowCodeMessage("BKG00013");
				sheetObj.CellValue2(Row, Col) = "";						
			}			
		}		
		
		// TP/SZ별 totalVolume이 booking vol 보다 같거나 작아야함.
		if(sheetObj.ColSaveName(Col) == "op_cntr_qty"){
			if(sheetObj.CellValue(Row,Col) != ""){
				var bkgRow = sheetObjects[1].FindText("cntr_tpsz_cd",sheetObj.CellValue(Row,"cntr_tpsz_cd"));
				if(bkgRow >= 0){
					var bkgVol = sheetObjects[1].CellValue(bkgRow, "op_cntr_qty");
					var totVol = sheetObj.CellValue(Row,"op_cntr_qty");
					if(totVol != null && totVol.length > 0){
						if(parseFloat(bkgVol) < parseFloat(totVol)){
							ComShowCodeMessage("BKG02005");
							sheetObj.CellValue(Row,"op_cntr_qty") = "";
						}
					}
				}
			}
		}
		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
			setTotalVol("2");			
		}
	}		
//	function sheet1_OnComboChange(sheetObj, Row, Col, Code, Text)
//	{
//		if(sheetObj.ColSaveName(Col) == "cntr_tpsz_cd"){
////			al"ert(Code);	
//		}
//	}		

	function sheet1_OnBeforeCheck(Row, Col){
		var sName = sheetObjects[0].ColSaveName(Col);
		if(sName == "dry_cgo_flg"){
			
		}
	}
    // type의 중복 check방지
	function sheet1_OnClick(sheetObj, Row, Col, Value)
	{
		var sName = sheetObj.ColSaveName(Col);
		//2018.05.16 iylee CNTR TYPE : D7이면서 EQ Sub : D4 or D5 인 경우, Dry로 체크하고 다른 Type으로 수정하지 못하게 한다. 
		if(sheetObj.CellEditable(Row, Col) == false){
			return false;
		}
		if(sName == "dry_cgo_flg"){
			sheetObj.CellValue(Row, "dcgo_flg") = 0;
			sheetObj.CellValue(Row, "rc_flg") = 0;
			sheetObj.CellValue(Row, "awk_cgo_flg") = 0;
			sheetObj.CellValue(Row, "bb_cgo_flg") = 0;
		}else if(sName == "dcgo_flg"){
			sheetObj.CellValue(Row, "dry_cgo_flg") = 0;
		}else if(sName == "rc_flg"){
			sheetObj.CellValue(Row, "dry_cgo_flg") = 0;
		}else if(sName == "awk_cgo_flg"){
			sheetObj.CellValue(Row, "dry_cgo_flg") = 0;
		}else if(sName == "bb_cgo_flg"){
			sheetObj.CellValue(Row, "dry_cgo_flg") = 0;
		}				
	}		
 	// Total Vol 계산
 	function setTotalVol(flag){
 		var sheetObj = sheetObjects[0];
 		var cntrArray = new Array();
 		var volArray = new Array();
 		var arrCnt = 0;
 		for(var i = sheetObj.HeaderRows; i < sheetObj.Rows ; i++){
 			if(cntrArray.length < 1){
 				cntrArray[arrCnt] = sheetObj.CellValue(i, "cntr_tpsz_cd");
 				volArray[arrCnt] = sheetObj.CellValue(i, "op_cntr_qty"); 		
 				arrCnt++;
 			}else{
 				var isExist = false;
 	 			for(var k = 0 ; k < cntrArray.length ; k++){
 	 				if(cntrArray[k] == sheetObj.CellValue(i, "cntr_tpsz_cd")){
 	 					if(ComIsNumber(volArray[k], ".") && ComIsNumber(sheetObj.CellValue(i, "op_cntr_qty"),".")){
 	 						volArray[k] = parseFloat(volArray[k]) + Math.round(parseFloat(sheetObj.CellValue(i, "op_cntr_qty")) * 1000) / 1000;
 	 						volArray[k] = parseFloat(volArray[k].toFixed(2));
 	 					}else if(ComIsNumber(volArray[k], ".")){
 	 						volArray[k] = volArray[k];
 	 					}else if(ComIsNumber(sheetObj.CellValue(i, "op_cntr_qty"),".")){
 	 						volArray[k] = sheetObj.CellValue(i, "op_cntr_qty");
 	 					}
 	 					isExist = true;
 	 				}
 	 			} 				
 	 			if(!isExist){
 	 				cntrArray[arrCnt] = sheetObj.CellValue(i, "cntr_tpsz_cd");
 	 				volArray[arrCnt] = sheetObj.CellValue(i, "op_cntr_qty"); 		
 	 				arrCnt++; 	  	 				
 	 			}
 			}
 		}
 		var totalVol = "";

 		for(var i = 0 ; i < cntrArray.length ; i++){
 			if(i > 0){
 				totalVol = totalVol + "," + cntrArray[i] + "X" + volArray[i];
 			}else{
 				totalVol = cntrArray[i] + "X" + volArray[i];
 			}
 		}
 		// Booking에서 입력하지 않은 TP/SZ를 직접입력했을 경우
 		if(flag != "1"){
 	 		for(var i = sheetObj.HeaderRows; i < sheetObj.Rows ; i++){
 	 			//alert(sheetObj.CellValue(i,"cntr_tpsz_cd"));
 				if(sheetObj.CellValue(i,"cntr_tpsz_cd") == "" || cntr_tpsz_str.indexOf(sheetObj.CellValue(i,"cntr_tpsz_cd")) < 0){
 					ComShowCodeMessage("BKG02003");
 					sheetObj.CellValue(i,"cntr_tpsz_cd") = "";
 					setTotalVol("1");
 				}	
 	 		} 			
 		}

 		ComSetObjValue(document.form.total_vol, totalVol);		
 	}
 	
 	// BKG Vol 계산
 	function setBkgTotalVol(){
		var totalVol;
		for(var i = 1 ; i < sheetObjects[1].Rows ; i++){
			// Total Volumn
			if(i > 1){
				totalVol = totalVol + "," + sheetObjects[1].CellValue(i, "cntr_tpsz_cd") + "X" + sheetObjects[1].CellValue(i, "op_cntr_qty");
			}else{
				totalVol = sheetObjects[1].CellValue(i, "cntr_tpsz_cd") + "X" + sheetObjects[1].CellValue(i, "op_cntr_qty");
			}
		}
		// Total Vol 입력
		ComSetObjValue(document.form.bkg_vol, totalVol);			 		
 	}
 	
		
//	function sheet1_OnPopupClick(sheetObj, Row, Col)
//	{
//		with(sheetObj)
//		{
//				var sName = ColSaveName(Col);				
//				
//				if(sName == "Entry"){
//					al"ert("PopupClick : " + sName);
//				}else if(sName == "Disch"){
//					al"ert("PopupClick : " + sName);						
//				}else if (sName == "BondedWH"){
//					al"ert("PopupClick : " + sName);						
//				}
//		}
//	}			

	/* 개발자 작업  끝 */