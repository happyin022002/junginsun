/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_scg_0033.js
*@FileTitle : Loading Port for RSO(Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.19 장강철 jkc
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
     * @class ui_scg_0033 : ui_scg_0033 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ui_scg_0033() {
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

 var sheetObjects = new Array();
 var sheetCnt = 0;
 var comboObjects = new Array();
 var comboCnt = 0; 
 
 var gRow = 0;
 // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
 document.onclick = processButtonClick;


 
 // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
     function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject = sheetObjects[0];
        /*******************************************************/
        var formObject = document.form;
        var doc      = document.all;
  //   	try {
     		var srcName = window.event.srcElement.getAttribute("name");
             switch(srcName) {

 							case "btn_retrieve":
 								doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
 							break;
 							
 							case "btn_add":			
 			                     if( doc.btn_add.className == "btn2_1"){
 			                         return;
 			                     }    							    
 								sheetObject.DataInsert(-1);
 								sheetObject.SelectCell( sheetObject.LastRow ,"sheet1_loc_cd");
 							break;
 							
 							case "btn_insert":
                                if( doc.btn_insert.className == "btn2_1"){
                                    return;
                                }   							    
 								sheetObject.DataInsert();
 								sheetObject.SelectCell( sheetObject.SelectRow ,"sheet1_loc_cd"); 								
 							break; 
 							
 							case "btn_delete":
                                if( doc.btn_delete.className == "btn2_1"){
                                    return;
                                }        							    
 								doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
 							break;	
 							
 							case "btn_save":
//                                if( doc.btn_save.className == "btn2_1"){
//                                    return;
//                                }   							    
 								doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
 							break;		
 							
 							case "btn_copy":
//                                if( doc.btn_copy.className == "btn2_1"){
//                                    return;
//                                }    							    
 								doActionIBSheet(sheetObjects[0],document.form,IBCOPYROW);
 							break;	 
   							
 							

             } // end switch
//     	}catch(e) {
//     		if( e == "[object Error]") {
//     			ComShowMessage(OBJECT_ERROR);
//     		} else {
//     			ComShowMessage(e);
//     		}
//     	}
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
             //sheetObjects[i].WaitImageVisible = false;
             initSheet(sheetObjects[i],i+1);
         //khlee-마지막 환경 설정 함수 추가
             ComEndConfigSheet(sheetObjects[i]);
             
            // initControl(i);
         }
  	 	//IBMultiCombo초기화
 	    for(var k = 0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 		//doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      function sheet1_OnLoadFinish(sheetObj) {
          doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
      }
      /**
       * Form의 Conrol 를 초기화 시킨다. <br>
       * @param  {object} sheetObj	필수
       * @return 없음
       * @author 김창식
       * @version 2009.05.20
       */
      function initControl(sheetObj){
      	// Form 객체 선언
      	 formObj = document.form;
          // axon event 등록
          //axon_event.addListenerFormat('keypress', 'obj_keypress', form);
          //axon_event.addListenerFormat('beforeactivate', 'obj_activate', form);
          //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', form);
         // axon_event.addListenerForm  ('focusout', 'obj_focusout', form);
          axon_event.addListenerFormat('keypress', 'obj_keypress', form);

      }
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param    {IBCombo}	combo_obj	배열로 등록될 IBCombo Object
	 */	
    function setComboObject(combo_obj){
		comboObjects[comboCnt++] = combo_obj;
	}      
     /**
     * Combo 기본 설정 
     * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
     * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
     */ 
     function initCombo(comboObj, comboNo) {
 
    	    switch(comboObj.id) {
  
    	        case "rso":    
    	            var i=0;
    	            with(comboObj) {
    	            	SetTitle("Code|Description");
        	  			SetColAlign("center|left");
    	            	SetColWidth("50|150")
    	            	DropHeight = 200;
    	            }
    	            break;
 
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
             case 1:      //t1sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 420;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msNone;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 3, 100);

                     //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                     InitColumnInfo(9, 0, 0, true);

                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle = "|Sel.|No.|Loading Port Code|Port Name|RSO Code|Country";

                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle, true);
                     var prefix="sheet1_";
                     //데이터속성       [ROW,    COL, DATATYPE,    WIDTH,   DATAALIGN, COLMERGE,                  SAVENAME,   KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus, 30,	daCenter,    false,	  prefix+"ibflag"        );
                     InitDataProperty(0, cnt++ , dtCheckBox,	 30,	daCenter,	  true,	  prefix+"del_chk"       ,      false,	   "",      dfNone,				0,	    true,	 true);
                     InitDataProperty(0, cnt++ , dtDataSeq,      30,    daCenter);
                     InitDataProperty(0, cnt++ , dtPopupEdit ,  150,    daCenter,     true,   prefix+"loc_cd"        ,      true,     "",       dfEngUpKey,         0,      false,   true, 5,	true);
                     InitDataProperty(0, cnt++ , dtData,        250,    daLeft,       true,   prefix+"loc_nm"        ,      false,     "",       dfNone,             0,      false,    false);                     
                     InitDataProperty(0, cnt++ , dtHidden,      100,    daCenter,     true,   prefix+"rgn_shp_opr_cd",      false,     "",       dfNone,             0,      false,    false);
                     InitDataProperty(0, cnt++ , dtData,        520,    daLeft  ,	  true,   prefix+"cnt_nm"        ,      false,     "",      dfNone,             0,      false,    false);
                     
                     InitDataProperty(0, cnt++ , dtHidden,        540,    daLeft  ,	  true,   prefix+"key_loc_cd"    ,      false,     "",      dfNone,             0,      true,    true);
                     InitDataProperty(0, cnt++ , dtHidden,        540,    daLeft  ,	  true,   prefix+"key_rgn_shp_opr_cd" , false,     "",      dfNone,             0,      true,    true);                     
                     InitDataValid(0, "sheet1_loc_cd", vtEngUpOther, "0123456789" );
 					 ShowButtonImage = 1;
 		       
                }
                 break;
                 
         }
     }

   // Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObj,formObj,sAction, cRow, loc_cd) {
         sheetObj.ShowDebugMsg = false;
         switch(sAction) {
							case IBCLEAR:      //콤보조회
							formObj.f_cmd.value = SEARCH01;
				     
							var aryPrefix = new Array("sheet1_");
							var sXml = sheetObj.GetSearchXml("VOP_SCG_0033GS.do", FormQueryString(formObj) );
				
							sheetObj.ShowDebugMsg = false;    							
 
							var sRso = ComGetEtcData(sXml, "cmbRso");

							if(sRso != undefined){
								var arrRso = sRso.split("%");
							    MakeComboObject(formObj.rso, arrRso);
					         }
					          //doActionIBSheet(sheetObj,formObj,IBSEARCH);
						      break;   
 
						     
    						case IBSEARCH:      //조회
								if(!validateForm(sheetObj,formObj,sAction)){
									return;
								}
  
    							formObj.f_cmd.value = SEARCH;
    							var aryPrefix = new Array("sheet1_");
 
    							var sXml = sheetObj.GetSearchXml("VOP_SCG_0033GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam( aryPrefix ));
 
    							sheetObj.ShowDebugMsg = false;    							
    							var arrXml = sXml.split("|$$|");
								//sheetObjects[0].Redraw = false;    							
    							for(var i = 0; i < arrXml.length; i++){ 
    
    								if(i > 0) {
    									sheetObjects[i].WaitImageVisible = false;	
    								}  
    								sheetObjects[i].LoadSearchXml(arrXml[i]); 
    							}
    							 
    							 var total = ComGetTotalRows(arrXml[0]);
                                 if(total != "0"){
                                     initUseBtn(true);
                                 }
    						     break;
    						case IBDELETE:      // 삭제
    							if (sheetObj.id == 'sheet1') {   
    								 ComRowHideDelete(sheetObj, "sheet1_del_chk");
    					   	   	}
    							break;
    							
    						case IBSAVE:        //저장
 							    //alert(sheetObj.CellValue(1,0)+"    "+sheetObj.CellValue(1,1)  );
    							if(!validateForm(sheetObj,formObj,sAction)){
    								return;
    							}
    							formObj.f_cmd.value = MULTI;	
 	
    							var sParam = ComGetSaveString(sheetObjects);
     
    						    if (sParam == "") return;
    						    sParam += "&" + FormQueryString(formObj);
    							var aryPrefix = new Array("sheet1_");
    						    var sXml = sheetObjects[0].GetSaveXml("VOP_SCG_0033GS.do", sParam+"&" + ComGetPrefixParam( aryPrefix ) );
    						    sheetObjects[0].LoadSaveXml(sXml);     
    						    

    						 //   sheetObjects[1].LoadSaveXml(sXml);   
       					        sheetObj.ShowDebugMsg = false;   
                                break;

    						case IBINSERT:      // 입력
    	                        InitDataProperty(0, 2, dtData,        200,    daCenter,     true,   prefix+"rgn_shp_opr_cd",      true,     "",      dfNone,             0,      false,    false);    						
    						    break;
    						case IBCOPYROW:	 
    						    if (sheetObj.id == "sheet1") {
    							    var row = sheetObj.DataCopy();
    							    sheetObj.RowStatus(row) = "I";
    						    }; 
    						break;
    						case IBSEARCH_ASYNC01:	 
    							formObj.f_cmd.value = SEARCH02;
    							var aryPrefix = new Array("sheet1_");
    			 
                                var param = "f_cmd="+formObj.f_cmd.value+"&loc_cd="+loc_cd+"&" + ComGetPrefixParam( aryPrefix ) ;
    							var sXml = sheetObj.GetSearchXml("VOP_SCG_0033GS.do",  param);
    				        	var loc_info = ComGetEtcData(sXml,"loc_info");
    	 
    				        	if( loc_info != ""){
    				        	    var aLocinfo = loc_info.split("|");
    	 
    				        	    sheetObj.CellValue2(cRow,"sheet1_cnt_nm")  =  aLocinfo[2];
    				        	}
    						break;	    						
         }

     }
 
     function sheet1_OnKeyUp(sheetObj,Row, Col, KeyCode, Shift ){
    	 if(KeyCode==13){
    		 getLocCd(sheetObj, Row, Col, sheetObj.SelectCell(Row, Col)  ); 
    	 }
     }     
  
     function sheet1_OnChange(sheetObj, row, col) {

		 
		 if( sheetObj.ColSaveName(col) == "sheet1_loc_cd" ){
			 if( sheetObj.CellValue.length != 5 ){
    	    	 ComShowCodeMessage("SCG50006","Port Code","5");
    	    	 sheetObj.SelectCell(row, "sheet1_loc_cd");
    	    	 return;
			 }
			 
			 getLocCd(sheetObj, row, col, sheetObj.SelectCell(row, col)  ); 			 
             var Row = sheetObj.ColValueDup("sheet1_loc_cd|sheet1_rgn_shp_opr_cd",false);
             
    	     if( Row != -1){
    	    	 ComShowCodeMessage("SCG50005", "Data");
    	    	 sheetObj.CellValue2(Row, "sheet1_loc_cd" ) = "";
    	    	 sheetObj.CellValue2(Row ,"sheet1_rgn_shp_opr_cd" ) = "";  
    	    	 sheetObj.CellValue2(Row ,"sheet1_cnt_nm" ) = "";
    	    	 
    	    	 sheetObj.SelectRow = Row;
                 
    	    	 return false;
    	     }			 
		 }
     }
 
          
   
     /**
     * IBSheet Object에서 입력값이 변경된 경우
     */
    function getLocCd(sheetObj,Row, Col, Value){
 
    	 var key = sheetObj.CellValue(Row,"sheet1_loc_cd")+"|"+sheetObj.CellValue(Row,"sheet1_rgn_shp_opr_cd");
    	 //chkSheetDup(sheetObj, Row, key);
    	 if( sheetObj.ColSaveName(Col) == "sheet1_loc_cd" ){
            document.form.loc_cd.value = sheetObj.CellValue(Row,"sheet1_loc_cd");
            document.form.f_cmd.value  = SEARCH02;
			var sXml = sheetObj.GetSearchXml("VOP_SCG_0033GS.do", FormQueryString(document.form) );
		    var msg =  ComScgGetMessageFromXml(sXml); 	
		    if( msg != "" ){
		    	ComShowMessage(msg);
		    	sheetObj.CellValue2( Row, "sheet1_loc_cd") = "";
		    }
        	var loc_info = ComGetEtcData(sXml,"loc_info");
            if( loc_info != "" ){
        	    setLocInfo(Row, loc_info);
            }else{
            	sheetObj.SelectCell ( Row, Col )  ;
            }
    	 }
     }
    
     function chkSheetDup(sheetObj, key){
    	 var aStr = key.split("|");
    	 var sKey = "";//aaa|bbb| = > sheetObj.CellValue('aaa')+"|"+sheetObj.CellValue('bbb')
    	 for(var i=0;i<aStr.length;i++){
 
    		 if( i < aStr.length-1 ){
    			 sKey +=   "sheetObj.CellValue( $row, '"+aStr[i]+"' )+'|'";
    		 }else{
    			 sKey +=   "+sheetObj.CellValue( $row, '"+aStr[i]+"' )+'|'";
    		 }
    	 }
         var mRowValue = "";
    	 for(var i=1;i<= sheetObj.RowCount;i++ ){
    		 mRowValue = eval( ComReplaceStr(sKey, "$row", i  ) ) ;
 
        	 for(var j=2;j<= sheetObj.RowCount;j++ ){    		 
    		      var dRowValue = eval( ComReplaceStr(sKey, "$row", j  ) ) ;
 
    		      if( (mRowValue == dRowValue) && (i != j) ){
    		    	  alert(i+"  "+mRowValue+"    "+j+" "+dRowValue);
    		    	  return;
    		      }
        	 }
    	 }

     }
 
   	 /**
      * 화면 폼입력값에 대한 유효성검증 프로세스 처리
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
               if(sAction == IBSEARCH){
       		         if ( formObj.rso.Code == "" ){
    		    	     ComShowCodeMessage('COM12113', 'RSO Code!');   
    		    	     formObj.rso.focus();
    		    	     return false;
    		         }
            		 
               }
               if(sAction == IBSAVE){
                     var Row = sheetObj.ColValueDup("sheet1_loc_cd",false);
            	     if( Row != -1){
            	    	 ComShowCodeMessage("SCG50005","Data");
            	    	 //sheetObj.SelectRow = Row;
            	    	 sheetObj.SelectCell(Row, "sheet1_loc_cd");
            	    	 return false;
            	     }
            	     if( !ComShowCodeConfirm('SCG50001' , 'data' ) ){
            	    	 return false;	 
            	     }
               }
         }
 
		     

         return true;
     }
 
	function sheet1_OnPopupClick(sheetObj, Row, Col)
	{
		with(sheetObj)
		{
			 gRow = Row;
 
            var port_cd =  sheetObj.CellValue(Row, Col);
            ComOpenPopup('/hanjin/VOP_VSK_0043.do?port_cd='+port_cd, 427, 520, "setLocCd", "0,0", true);                   
	
 		}
 	}
    /** 
     * Sheet Loc_cd의 결과 처리  <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */  
	function setLocInfo(cRow, locinfo) {
  	   var sheetObject = sheetObjects[0];
       var formObj = document.form;
  	   var aLocinfo = locinfo.split("|");
	   sheetObject.CellValue2(cRow,"sheet1_loc_cd")          =  aLocinfo[0];
 	   
	   sheetObject.CellValue2(cRow,"sheet1_rgn_shp_opr_cd")  =   formObj.rso.Code;//aLocinfo[1];    
	   sheetObject.CellValue2(cRow,"sheet1_cnt_nm")          =  aLocinfo[2];
	   sheetObject.CellValue2(cRow,"sheet1_loc_nm")          =  aLocinfo[3];  	   
	   if( aLocinfo != 0 ){
	       //sheetObject.CellValue2(cRow,"sheet1_del_chk")          =  1;
	   }
	   
	}
 
     /** 
      * Location by loc_cd 팝업에서 선택한 값 Setting. <br>
      * @param  없음
      * @return 없음
      * @author 장강철
      * @version 2009.05.21
      */       
     function setLocCd(aryPopupData){
	   var sheetObject = sheetObjects[0];
	   var formObj = document.form;
	   sheetObject.CellValue(gRow,"sheet1_loc_cd")  =  aryPopupData[0][2];
	   sheetObject.CellValue(gRow,"sheet1_loc_nm")  =  aryPopupData[0][3];	   	   
	   sheetObject.CellValue(gRow,"sheet1_rgn_shp_opr_cd")  =  formObj.rso.Code;//aryPopupData[0][7];
	   sheetObject.CellValue(gRow,"sheet1_cnt_nm")  =  aryPopupData[0][4];
	   
	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01, gRow, aryPopupData[0][2]);
	   
	   gRow =0;
 
     } 
     /** 
     * 멀티콤보 셋 <br>
     * @param  없음
     * @return 없음
     * @author 장강철
     * @version 2009.05.21
     */      
 	 function MakeComboObject(cmbObj, arrStr) {
 			for (var i = 0; i < arrStr.length-1;i++ ) {
 			    var text = arrStr[i].split("|");
 				cmbObj.InsertItem(i,   arrStr[i],text[0]);
 			}
 	 }
     function rso_OnChange (comboObj,value,text) {
    	 var aText = text.split("|");
    	 document.form.rgn_shp_opr_desc.value    = aText[1];
    	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);    
    	 
     }
     function initUseBtn(useyn){
         var doc = document.all;
         if( useyn ){
             doc.btn_add.className        = "btn2";
             doc.btn_insert.className     = "btn2";
             doc.btn_copy.className       = "btn2";
             doc.btn_delete.className     = "btn2";     
         }else{
             doc.btn_add.className        = "btn2_1";
             doc.btn_insert.className     = "btn2_1";
             doc.btn_copy.className       = "btn2_1";
             doc.btn_delete.className     = "btn2_1"; 
         }
     }     
	/* 개발자 작업  끝 */