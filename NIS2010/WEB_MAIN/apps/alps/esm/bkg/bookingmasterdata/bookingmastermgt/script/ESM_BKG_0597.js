/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0597.js
*@FileTitle : BDR Access Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : Shin Kyu Jeong
*@LastVersion : 1.0
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
     * @class esm_bkg_0597 : esm_bkg_0597 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_0597() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    

    // public variable
	var sheetObjects = new Array(); 
	var sheetCnt = 0;

	// Event handler processing by button click event */
	document.onclick = processButtonClick;
	
	// Event handler processing by button name */
     function processButtonClick(){
          /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
 		  var sheetObject = sheetObjects[0];
          /*******************************************************/
          var formObject = document.form;

     	try {
     		var srcName = window.event.srcElement.getAttribute("name");

             switch(srcName) {
             
             		case "btn_Retrieve":
             			//alert("조회눌렀을때");
             			doActionIBSheet(sheetObject, formObject, IBSEARCH);
             				//	alert("조회눌렀을때2");
             			break;

					case "btn_Save":
						//alert("SAVE 눌렀을때");
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						//alert("SAVE 눌렀을때2");
						break;

//					case "btn_Copy":
//						doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
//						break;
						
					case "btn_RowAdd":
						addRow();
						break;
					
					case "btn_RowDel":
						deleteRow();
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
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
    	  sheetObjects[sheetCnt++] = sheet_obj;
 			
     }
     function setComboObject(combo_obj) {  
    		comboObjects[comboCnt++] = combo_obj;  
    	}


     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {

         for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );

             initSheet(sheetObjects[i],i+1);      
             ComEndConfigSheet(sheetObjects[i]);
          
         }

         // Event needed for screen
     	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
     
    	//doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
     }

     
   /**
      * setting sheet initial values and header
      * 
      * adding case as numbers of counting sheets
      */
     
     function initSheet(sheetObj,sheetNo) {

         var cnt = 0;

         switch(sheetNo) {
             case 1:      //sheet1 init
                 with (sheetObj) {

                     // 높이 설정
                     style.height = 440;
                     //전체 너비 설정
                     SheetWidth = mainTable.clientWidth;

                     //Host정보 설정[필수][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //전체Merge 종류 [선택, Default msNone]
                     MergeSheet = msHeaderOnly;

                    //전체Edit 허용 여부 [선택, Default false]
                     Editable = true;

                     //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 15, 100);


                     // 해더에서 처리할 수 있는 각종 기능을 설정한다
                     InitHeadMode(true, true, false, true, false,false)

                     var HeadTitle1 = "|ibflag|Seq.|Open|Close|User Name|User ID|Office|Date|Hrd_Cdg_Id_Seq";
         
   					 var headCount = ComCountHeadTitle(HeadTitle1);

   					 //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
   					 InitColumnInfo(headCount, 0, 0, true);
                     
                     //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);

                     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++, 		dtDummyCheck, 		20, 		daCenter, 			false, 		"DelChk");
                     InitDataProperty(0, cnt++ , 		dtHiddenStatus,			30,		  	daCenter,		    	true,		"ibflag");
                     InitDataProperty(0, cnt++, 		dtSeq, 					30, 		daCenter, 			false, 		"Seq"); 	
                     InitDataProperty(0, cnt++ , 		dtCheckBox, 				105,    	daCenterTop, 	 	true,     	"open_auth",      			false,       "",      dfNone,      	0,     true,		true);
   	                 InitDataProperty(0, cnt++ , 		dtCheckBox, 				105,    	  	daCenterTop, 	 	true,     	"close_auth",  				false,       "",      dfNone,      	0,     true,		true);
   	                 InitDataProperty(0, cnt++ , 		dtData, 					140,     	daCenterTop, 	 	true,     	"usr_nm",						false,       "",      dfNone,      	0,     false,		false);
   	                 InitDataProperty(0, cnt++ , 		dtData, 					100,     	daCenterTop, 	 	true,     	"usr_id",   					false,       "",      dfNone,   		0,     true,		true);
   	                 InitDataProperty(0, cnt++ , 		dtData, 					105,       	daCenterTop, 	 	true,     	"ofc_cd",   					false,       "",      dfNone, 		0,     false,		false);
   	                 InitDataProperty(0, cnt++ , 		dtData, 					50,     	daCenterTop, 	 	true,     	"upd_dt",      				false,       "",      dfNone, 		0,     false,		false);
   	                 InitDataProperty(0, cnt++ , 		dtHidden, 					30,     	daCenterTop, 	 	true,     	"hrd_cdg_id_seq");
					
   	              InitDataValid(0, "usr_id", vtEngOther, "1234567890");
       
   	                 WaitImageVisible=false;

   	                 // 자동 행 높이 지정
   	                 AutoRowHeight = false;
   	                 // 행 높이 설정
   	                 DataRowHeight = 22;
   	                 
                }
                 
                break;
         }
     }
				
// Sheet관련 프로세스 처리
     function doActionIBSheet(sheetObject,formObject,sAction,row) {
		//alert(1);
    	 sheetObject.ShowDebugMsg = false;
 
	     switch(sAction) {

	     	case IBSEARCH:      //조회
	     	
	     		if(!validateForm(sheetObject,formObject,sAction)) return false;

					ComOpenWait(true);
					formObject.f_cmd.value = SEARCH01;
					formObject.sheet_usr_id.value ="";
					var sParam = FormQueryString(formObject);
//					ComShowMessage("sParam : " + sParam);
					sheetObject.DoSearch("ESM_BKG_0597GS.do",sParam);
					ComOpenWait(false);
							
					break;
								
	     	case IBSAVE: // Save
				if(!validateForm(sheetObject,formObject,sAction))	return;
				
				formObject.f_cmd.value = MULTI;
				var sParam 	= sheetObject.GetSaveString();

				sParam += "&" + FormQueryString(formObject);
				//alert(sParam);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_0597GS.do",sParam);
				//alert("save2");
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false, false);
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('BKG00166');
				}
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	
				break;
				
	     	case SEARCH02:      //조회
		     	
	     		if(!validateForm(sheetObject,formObject,sAction)) return false;
					//ComOpenWait(true);
					formObject.f_cmd.value = SEARCH02;
					formObject.sheet_usr_id.value = sheetObject.CellValue(row, "usr_id");
					
					//ComShowMessage("sParam : " + sParam);
					
					var sXml = sheetObject.GetSearchXml("ESM_BKG_0597GS.do", FormQueryString(formObject));

					if(ComGetEtcData(sXml, "USR_CHK")=="X"){
						ComShowCodeMessage('BKG00068', "User Id(Id does not exist )");
						sheetObject.CellValue2(row,"usr_id") = "";
						return false;
					}
					
					if(ComGetEtcData(sXml, "Name") == undefined) {
						sheetObject.LoadSearchXml(sXml, true);
					} else {
						sheetObject.CellValue2(row,"usr_nm") =ComGetEtcData(sXml, "Name");
						sheetObject.CellValue2(row,"ofc_cd") =ComGetEtcData(sXml, "Office");
						//sheetObject.CellValue2(row,"usr_id") =ComGetEtcData(sXml, "usr_id");
					}
					if(ComGetEtcData(sXml, "USR_CHK")=="Y"){
						if (ComBkgErrMessage(sheetObject, sXml)) {
							
							sheetObject.CellValue2(row,"usr_id") = "";
							return false;
						}
					}
					//ComOpenWait(false);
							
					break;
				
	 }
				  }


     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
       	
       		case IBSAVE: // 화면 로우 추가시
	       		if (! sheetObj.IsDataModified){
	  	     		ComShowCodeMessage('BKG00743');
					return false; //There is no updated data to save.
			    }
	  	     	for(var i =1; i<=sheetObj.RowCount; i++){	
	  	     		if(sheetObj.CellValue(i,"usr_id") =="" ) {  	     			
	  	     			ComShowCodeMessage('BKG00104', "User Id("+i+"Row)");
	  	     			return false;
	  	     		}
	  	     		
	  	     		
	  	     		for(var j=1; j<=sheetObj.RowCount; j++){
	  	     			if(sheetObj.CellValue(i,"usr_id") == sheetObj.CellValue(j,"usr_id") && (i != j)&& sheetObj.RowStatus(j)!="D" ){
	  	     				ComShowCodeMessage('BKG00764', "User Id("+i+"Row)");
	  	     				return false;
	  	     			}
	  	     		}    		
	  	     		
	  	     	}
	     		break;	
    	  	}
    	  	return true;

          
      }
     
      
  	/**
  	 * add row process in sheet1
  	 * add one row
  	 */
	 	function addRow() {
	 	  with (sheetObjects[0]) {
	         var nowRow = SelectRow;
	       	 nowRow = DataInsert(-1); 
	     // 	sheetObjects[0].CellValue(nowRow,"hrd_cdg_id") = document.form.hrd_cdg_id.value;
	         return true;
	          }
	 }
	/**
	 * delete row process in sheet1
	 * delete one row
	 */ 
	 function deleteRow() {
	     with (sheetObjects[0]) {
	         var sRowStr = FindCheckedRow("DelChk");
	         
	         var arr = sRowStr.split("|");
	         for (var i=0; i<arr.length - 1; i++) {
	             
	        	 RowStatus(arr[i]) = "D";    
	             RowHidden(arr[i]) = "true"; 
	                 
	         }
	     }         
	 }
	 
	 
	 
	 /**
	  * sheet2 Change 이벤트
	  * 
	  * @param sheetObj
	  * @param Row
	  * @param Col
	  * @param Value
	  * @return
	  */
	 function sheet1_OnChange(sheetObj, row, col, value) {
	 	
	 	var rowCnt = sheetObj.RowCount;
	 	var colSaveName = sheetObj.ColSaveName(col);
	 	var formObj = document.form;
	 	
	 	switch(colSaveName) {
	 	case "usr_id" :
	 		if(sheetObj.CellValue(row ,"usr_id") !=""){
	 			doActionIBSheet(sheetObj, formObj, SEARCH02, row);
	 		}else{
	 			sheetObj.CellValue2(row ,"usr_nm") ="" ;
	 			sheetObj.CellValue2(row ,"ofc_cd") ="" ;
	 		}
	 		
	 			break;
	 	
	 	}
	 	
	 }	
	 
	    /**
	     * 조회 후 이벤트
	     * @param sheetObj
	     * @param ErrMsg
	     * @return
	     */
		function sheet1_OnSearchEnd(sheetObj,ErrMsg){
	
			var formObj = document.form;
			
			if(formObj.f_cmd.value ==SEARCH02){
				if (ErrMsg == "") {
					
				}
			}

		}
     