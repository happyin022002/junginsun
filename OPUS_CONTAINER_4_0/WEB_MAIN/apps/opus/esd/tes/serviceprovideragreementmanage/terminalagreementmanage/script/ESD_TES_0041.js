/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESD_TES_0041.js
*@FileTitle : China Special Feeder
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
					[수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
					기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
   /**
     * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
     * @author 
     */
   	/* 개발자 작업	*/
	var sheetObjects=new Array(); //setsheetObject에서 사용
	var sheetCnt=0;
	var gv_btn_popup="";
    // 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
    document.onclick=processButtonClick;
    // 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
         /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
			case "btn_polpopup":
			case "btn_podpopup":
				gv_btn_popup = srcName;
				ComOpenPopup("/opuscntr/COM_ENS_051.do?cnt_cd=CN", 800, 460,"setLocationCd", "1,0,1,1,1", true);
				break;
   			case "btn_Retrieve":
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   				break;
   			case "btn_Save":
				doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
   				break;   				
   			case "btn_exceldown":
				doActionIBSheet(sheetObjects[0],document.form,"btn_exceldown","","");
   				break;
   			case "btn_RowDel":
   				delRow();
   				break;   
   			case "btn_RowAdd":
				addRow();
   				break;   				
   			case "btn_New":
				doActionIBSheet(sheetObjects[0],document.form,IBRESET);
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
    function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }
     function loadPage() {
         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         // 화면에서 필요한 이벤트
     	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
     	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     	axon_event.addListenerForm('change', 'obj_change', document.form); // change
     	axon_event.addListenerForm('click', 'obj_click', document.form); // click
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
                 
               var HeadTitle1="||Seq.|POL|POL/Name|POD|POD/Name";
               var headCount=ComCountHeadTitle(HeadTitle1);

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle1, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                      {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"check" },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
                      {Type:"PopupEdit", Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"fdr_pol_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:270,  Align:"Center",  ColMerge:1,   SaveName:"pol_loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"PopupEdit", Hidden:0, Width:170,  Align:"Center",  ColMerge:1,   SaveName:"fdr_pod_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
                      {Type:"Text",      Hidden:0,  Width:270,  Align:"Center",  ColMerge:1,   SaveName:"pod_loc_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               SetWaitImageVisible(0);
                     SetAutoRowHeight(0);
               SetDataRowHeight(22);
               resizeSheet();//SetSheetHeight(440);
               }
                break;
         }
     }
     function resizeSheet(){
     	ComResizeSheet(sheetObjects[0]);
     }
    // Sheet관련 프로세스 처리
 	 function doActionIBSheet(sheetObj,formObj,sAction) {
 	     sheetObj.ShowDebugMsg(false);
 	     switch(sAction) {
 	     	case IBSEARCH:      //조회
	     		ComOpenWait(true);
 				formObj.f_cmd.value=SEARCH;
 				var sParam=FormQueryString(formObj);
 				sheetObj.DoSearch("ESD_TES_0041GS.do",sParam );
 				ComOpenWait(false);
 				break;
			case SEARCH01:	//POL,POD값 fullname 조회
				formObj.f_cmd.value=SEARCH01;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSaveData("ESD_TES_0041GS.do", FormQueryString(formObj));
				var valResult=ComGetEtcData(sXml, "loc_fullname");
	        	if(sheetObj.GetSelectCol()==3)
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pol_loc_nm",valResult);
	        	else
	        		sheetObj.SetCellValue(sheetObj.GetSelectRow(),"pod_loc_nm",valResult);
	        	break;
			case SEARCH02:	//POL,POD값 중복여부확인
				formObj.f_cmd.value=SEARCH02;
			    sheetObj.SetWaitImageVisible(0);
 	      	    var sXml=sheetObj.GetSaveData("ESD_TES_0041GS.do", FormQueryString(formObj));
	      	    var valResult=ComGetEtcData(sXml, "samecd_cnt");
        	    if(valResult == '1'){
        		    var Msg=formObj.chk_pol_cd.value + " and " + formObj.chk_pod_cd.value;
				    ComShowCodeMessage('TES90104', Msg);//{?msg1} are duplicated.
				    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "fdr_pol_cd",'',0);
				    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "fdr_pod_cd",'',0);
				    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pol_loc_nm",'',0);
				    sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pod_loc_nm",'',0);
			    }
        	    break;	  
			case SEARCH03:	// pol과 pod가 country code가 CN인 값만 조회되었는지 check
				formObj.f_cmd.value=SEARCH03;
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSaveData("ESD_TES_0041GS.do", FormQueryString(formObj));
				var valResult=ComGetEtcData(sXml, "check_cn");
				if(valResult!=1){
					if(sheetObj.GetSelectCol()==3){
						ComShowCodeMessage('TES90105');//Please select the location in China
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "fdr_pol_cd",'',0);
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pol_loc_nm",'',0);
					}
					else{
						ComShowCodeMessage('TES90105');//Please select the location in China
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "fdr_pod_cd",'',0);
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "pod_loc_nm",'',0);
					}
				}
				break;  
 	     	case IBRESET: // New
	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
 				formObj.reset();
 				sheetObjects[0].RemoveAll();
 				loadPage();
 				break;
 	     	case IBSAVE: // Save
 	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
// 	     		ComOpenWait(true, true);
				formObj.f_cmd.value=MULTI;
				var sheet2=sheetObjects[1];
				var sParam=sheetObj.GetSaveString(false, true, "ibflag");
 				var sXml=sheetObjects[0].GetSaveData("ESD_TES_0041GS.do", "f_cmd=" + MULTI + "&" +sParam);
				var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false, false);
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('TES90108');
				}
				doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
 			case "btn_exceldown":
 				 if(sheetObj.RowCount() < 1){
 					ComShowCodeMessage("COM132501");
 				}else{
 					sheetObj.Down2Excel({ HiddenColumn:1});
 				}  				
 				break;
 	     }
 	 }
       /**
        * 화면 폼입력값에 대한 유효성검증 프로세스 처리
        */
        function validateForm(sheetObj,formObj,sAction){
      	 with(formObj){
      		 if (sAction == IBSAVE){
    			var sheet1RowCount = sheetObj.RowCount();
	   			for(var i=1; i <=sheet1RowCount; i++ ){
	   				if(sheetObj.GetCellValue(i,"fdr_pol_cd") ==''){
		   				ComShowCodeMessage('TES22037','POL');//{?msg1} is mandatory item.
		   				sheetObj.SelectCell(i, "fdr_pol_cd", true, "");
		   				return false;
	   				}
	   				if(sheetObj.GetCellValue(i,"fdr_pod_cd") ==''){
		   				ComShowCodeMessage('TES22037','POD');//{?msg1} is mandatory item.
		   				sheetObj.SelectCell(i, "fdr_pod_cd", true, "");
		   				return false;
	   				}
	   			} 
       	     	if (!sheetObj.IsDataModified()){
       	     		ComShowCodeMessage('TES10028');//There is no data to Save.\n\n Please check again.
 					return false; 
    		    }
       	     	if(sheetObj.GetCellValue(sheetObj.GetSelectRow(),"ibflag")=='U'){
      				ComShowCodeMessage('TES90106');//You can't change this data. Please delete first and insert if you want to change.
      				return false;
      			}      				
      		 }
      		 else if (sAction == IBRESET){
        	     	if (sheetObj.IsDataModified()){
    					if(!ComShowConfirm(ComGetMsg("TES90107"))){ 
    						return false; //There is modified data.Do you want to continue?
    					}
        		    }
       			} 
      	 	}
            return true;
        }
      /**
       * 조회조건 입력할 때 처리
       */
      function obj_KeyUp() {
      	var formObject=document.form;
      	var srcName=ComGetEvent("name");
      	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
      	var srcValue=window.event.srcElement.getAttribute("value");
        switch(event.srcElement.dataformat) {
        case "engup":  //영문대문자
        ComKeyOnlyAlphabet('upper'); break;
      }
       }     
	 /**
	  * sheet1의 add row 에 대한 처리
	  * 새로운 row를 추가한다.
	  */
	  function addRow() {
	  	  with (sheetObjects[0]) {
	          var nowRow=GetSelectRow();
	        	 nowRow=DataInsert(-1);//-1:마지막행에 생성, 0:첫행에 생성, ():선택한 다음에 생성
	          return true;
	           }
	  }
	 /**
	  * sheet1의 add delete 에 대한 처리
	  * row 를 삭제한다.
	  */  
	  function delRow() {
		     with (sheetObjects[0]) {
		    	 
		         /*var sRowStr=FindCheckedRow("check");		         
		         var arr=sRowStr.split("|");		         
		         for (var i=0; i<arr.length - 1; i++) {
		        	 SetRowStatus(arr[i],"D");
		             SetRowHidden(arr[i],"1");
		         }*/
		         
		        var selectedRow = sheetObjects[0].GetSelectionRows('|').split('|');
     	        for(var i=selectedRow.length-1; i>=0; i--){
     	        	sheetObjects[0].RowDelete(selectedRow[i], false);
     	        }
		     }       
	  }
	 /**
   * OnPopupClick 이벤트 발생시 호출되는 function <br>
   * <br><b>Example :</b>
   * <pre>
   *
   * </pre>
   * @param {ibsheet} sheetObj 필수 IBSheet Object
   * @param {int} Row 필수 OnClick 이벤트가 발생한 해당 셀의 Row Index
   * @param {int} Col 필수 OnClick 이벤트가 발생한 해당 셀의 Column Index 변경된 값
   * @param {str} Value 필수 Format이 적용되지 않은 저장 시 사용되는 값
   * @return 없음
	 * @author JEONGMIN CHO
	 * @version 2012.04.18
   */
   function sheet1_OnPopupClick(sheetObj, Row, Col, Value) {
	    var colname=sheetObj.ColSaveName(Col);
		var formObj=document.form;
    	switch(colname)
    	{
    		case "fdr_pol_cd":     	
    			ComOpenPopup("/opuscntr/COM_ENS_051.do?cnt_cd=CN", 800, 460,"getLocationCd","1,0,1,1,1", true);
    			break;
 	    	case "fdr_pod_cd":
 	    		ComOpenPopup("/opuscntr/COM_ENS_051.do?cnt_cd=CN", 800, 460,"getLocationCd","1,0,1,1,1", true);
	    		break;	
    	}
   } 
	   /**
	    * 시트에 키필드 Validation 체크 및 해당 코드의 full name 조회
	    */
	   function sheet1_OnChange(sheetObj, Row, Col, Value){
	    	var formObj=document.form;
	    	if(sheetObj.ColSaveName(Col) == "fdr_pol_cd"||sheetObj.ColSaveName(Col) == "fdr_pod_cd"){
	    		formObj.search_cd.value=sheetObj.GetCellValue(Row, Col); // pol과 pod가 cnt_cd가 CN인 값만 조회되었는지 check
	    		doActionIBSheet(sheetObj, formObj, SEARCH03);
	    		formObj.f_cmd.value=SEARCH01;
	    		formObj.search_cd.value=sheetObj.GetCellValue(Row, Col); // full name 조회
	    		doActionIBSheet(sheetObj, formObj, SEARCH01);
	    		if(sheetObj.GetCellValue(Row,"fdr_pol_cd")!= '' && sheetObj.GetCellValue(Row,"fdr_pod_cd")!= ''){
	    			if(sheetObj.GetCellValue(Row,"fdr_pol_cd") == sheetObj.GetCellValue(Row,"fdr_pod_cd")){
	    				ComShowCodeMessage('TES90109');
	    				return false;
	    			}
	    			formObj.chk_pol_cd.value=sheetObj.GetCellValue(Row, "fdr_pol_cd");
	    			formObj.chk_pod_cd.value=sheetObj.GetCellValue(Row, "fdr_pod_cd");
	    			doActionIBSheet(sheetObj, formObj, SEARCH02); //같은 pol,pod값 있는지 확인
				}
	   		}
	    }
	/** 
	 * form에 있는 popup에서 Location 코드 조회 팝업 창 리턴값을 받는 setLocationCd <br>
	 * <br><b>Example :</b>
	 * <pre>
	 * </pre>
	 * @param  {IBSheet} aryPopupData  : 시트오브젝트  
	 * @return 없음
	 * @see #
	 * @author JEONGMIN CHO
	 * @version 2012.04.18
	 */ 
	 	function setLocationCd(aryPopupData) {
		 	var formObject=document.form;
		 	//var srcName=ComGetEvent("name");
		 	var srcName=gv_btn_popup;
	 	switch(srcName) {
	 		case "btn_polpopup":
	 			formObject.pol_cd.value=aryPopupData[0][3];
	 			break;
	 		case "btn_podpopup":
		 			formObject.pod_cd.value=aryPopupData[0][3];
		 			break;
		 	}
	 	} 
	  /** 
	  * sheet에 있는 popup에서 Location 코드 조회 팝업 창 리턴값을 받는 getLocationCd <br>
	  * <br><b>Example :</b>
	  * <pre>
	  * </pre>
	  * @param  {IBSheet} aryPopupData  : 시트오브젝트  
	  * @return 없음
	  * @see #
	  * @author JEONGMIN CHO
	  * @version 2012.04.18
	  */   
	  function getLocationCd(aryPopupData) {
		  var sel_col=sheetObjects[0].GetSelectCol();
		  if(sel_col==3)
			  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"fdr_pol_cd",aryPopupData[0][3]);
	  else
		  sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"fdr_pod_cd",aryPopupData[0][3]);
	} 
	/* 개발자 작업  끝 */
