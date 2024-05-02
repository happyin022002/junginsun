/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_2004.js
*@FileTitle : Hard Coding Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.24
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.24 조정민
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
     * @class esm_bkg_2004 : esm_bkg_2004 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_2004() {
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
	var childResult = 0;
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
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
						break;
					
					case "btn_New":
						doActionIBSheet(sheetObjects[0], formObject, IBRESET);
						break;
						
					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;

					case "btn_Detail":
						doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
						break;
						
					case "btn_excelup":
						sheetObjects[0].RemoveAll();
						sheetObjects[0].Redraw = false;
						sheetObjects[0].LoadExcel(1);
						sheetObjects[0].Redraw = true;
						break;
						
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
//    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);


     }
  	function obj_keypress() {                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		switch (event.srcElement.dataformat) {                                                                                                                                                                                                                                                                                                                                                                                                                              
		case "int":                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			//숫자 만입력하기                                                                                                                                                                                                                                                                                                                                                                                                                                           
			ComKeyOnlyNumber(event.srcElement);                                                                                                                                                                                                                                                                                                                                                                                                                         
			break;                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		case "float":                                                                                                                                                                                                                                                                                                                                                                                                                                                       
			//숫자+"."입력하기                                                                                                                                                                                                                                                                                                                                                                                                                                          
			ComKeyOnlyNumber(event.srcElement, ".");                                                                                                                                                                                                                                                                                                                                                                                                                    
			break;                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		case "eng":                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			//영문만입력하기                                                                                                                                                                                                                                                                                                                                                                                                                                            
			ComKeyOnlyAlphabet('upper');                                                                                                                                                                                                                                                                                                                                                                                                                                
			break;                                                                                                                                                                                                                                                                                                                                                                                                                                                      
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		case "uppernum":                                                                                                                                                                                                                                                                                                                                                                                                                                                    
			//영문+숫자 입력하기                                                                                                                                                                                                                                                                                                                                                                                                                                        
			ComKeyOnlyAlphabet('uppernum');                                                                                                                                                                                                                                                                                                                                                                                                                             
			break;                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		default:                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			//숫자만입력하기                                                                                                                                                                                                                                                                                                                                                                                                                                            
			ComKeyOnlyNumber(event.srcElement);                                                                                                                                                                                                                                                                                                                                                                                                                         
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
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

                     // setting height
                     style.height = 440;
                     //setting width
                     SheetWidth = mainTable.clientWidth;

                     //setting Host information[mandatory][HostIp, Port, PagePath]
                     if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                     //Merge kind [Default msNone]
                     MergeSheet = msHeaderOnly;

                    //Edit kind [Default false]
                     Editable = true;

                     //setting Row information[mandatory][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                     InitRowInfo( 1, 1, 15, 100);


                     // setting Header Mode
                     InitHeadMode(true, true, false, true, false,false)


                     var HeadTitle1 = "||Seq.|ID|Description|Attribute 1|Attribute 2|Attribute 3|Attribute 4|Attribute 5|Attribute 6|Attribute 7|Attribute 8|Attribute 9|Attribute 10";
     				var headCount = ComCountHeadTitle(HeadTitle1);

     				 //setting Column information[mandatory][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     				 InitColumnInfo(headCount, 0, 0, true);
                     
                     //setting Header row information[mandatory][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                     InitHeadRow(0, HeadTitle1, true);
     	
     				// data property    [	ROW, COL,  DATATYPE,   		WIDTH, 	DATAALIGN, 	COLMERGE, 	SAVENAME,
     				// KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT,
     				// INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK,
     				// SAVESTATUS, FORMATFIX]
                     InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,		true,	"ibflag");
     				 InitDataProperty(0, cnt++ , dtDummyCheck, 		40, 	daCenterTop,	true, 	"check");
                     InitDataProperty(0, cnt++ , dtHidden,  30,     daCenterTop, 	 true,     "seq");
                     InitDataProperty(0, cnt++ , dtData, 140,    daCenterTop, 	 true,     "hrd_cdg_id",	false,       "",      dfNone,      	0,     false,		true,	20);
                     InitDataProperty(0, cnt++ , dtData, 385,    daLeft, 	 true,     "hrd_cdg_desc", 	false,       "",      dfNone,      	0,     true,		true,	400);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm1",	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm2", 	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm3",	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm4", 	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm5",	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm6", 	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm7",	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm8", 	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm9",	false,       "",      dfNone,      	0,     true,		true,	100);
                     InitDataProperty(0, cnt++ , dtData, 100,    daCenterTop, 	 true,     "attr_nm10", 	false,       "",      dfNone,      	0,     true,		true,	100);
                     
                     InitDataValid(0, 	3, vtEngUpOther,"_1234567890");
                     sheetObj.FrozenCols = 5;
     			}
     			break;
     	

         }
     }


   // handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg = false;
	     
	     switch(sAction) {

	     	case IBSEARCH:      //retrieve


//				ComOpenWait(true);
				formObj.f_cmd.value = SEARCH;
				var sParam = FormQueryString(formObj);
				//ComShowMessage("sParam : " + sParam);
				sheetObj.DoSearch("ESM_BKG_2004GS.do",sParam);
				ComOpenWait(false);

				break;
					

	     	case IBRESET: // New

        	    if (sheetObj.IsDataModified){
  					if(ComShowConfirm(ComGetMsg("BKG00962"))){ 
  						doActionIBSheet(sheetObjects[0], formObj, IBSAVE);//Do you want to save the modified information?
  					}
     		    }

				formObj.reset();
				sheetObjects[0].RemoveAll();

				
				break;
				
	     	case IBSAVE: // Save
	     		if(!validateForm(sheetObj,formObj,sAction)) return false;
	//			ComOpenWait(true, true);
				formObj.f_cmd.value = MULTI;
				var sheet2 = sheetObjects[1];
				var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_2004GS.do", "f_cmd=" + MULTI + "&" +sParam);
				var State = ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				if(State != "S"){
					ComShowMessage(ComResultMessage(sXml));
					ComOpenWait(false, false);
					return false;
				}else if(State == "S"){
					ComShowCodeMessage('BKG00166');
				}
				formObj.hrd_cdg_id.value ='';
				doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);

				break;

			case SEARCH01:  //Detail
				if(!validateForm(sheetObj,formObj,sAction)) return false;
	   			 var cnt = 0;
				 var row = 0;
				 for (var i = 1 ; i < sheetObj.RowCount +1 ; i++){
	    			 if(sheetObj.CellValue(i, "check") == 1){
	    				 cnt++;
	    				 row = i;
	    			 }
				 }
				 if(cnt != 1){
					 ComShowCodeMessage("BKG40076");//Please select one row
				     return false;
				 }

	     		popupId(row); 
		        				
				break;
				
			case SEARCH02:	//check if there is id in DB
	        	  formObj.f_cmd.value = SEARCH02;
				  sheetObj.WaitImageVisible = false;
	        	  
	        	  var sXml = sheetObj.GetSaveXml("ESM_BKG_2004GS.do", FormQueryString(formObj));

	        	  var valResult = ComGetEtcData(sXml, "hrd_id_cnt");
	        	  if(valResult == '1'){
	        		  
					  ComShowCodeMessage('BKG95051');//The Same ID is existed.
					  sheetObj.CellValue2(sheetObj.SelectRow, "hrd_cdg_id") = '';
				  }
               	break;
			case SEARCH03:	        //check if there are some data on child table
		      	  formObj.f_cmd.value = SEARCH03;
				  sheetObj.WaitImageVisible = false;	      	  
		      	  var sXml = sheetObj.GetSaveXml("ESM_BKG_2004GS.do", FormQueryString(formObj));		
		      	  childResult = ComGetEtcData(sXml, "child_cnt");


		         break;   	
	     }
	 }



     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	 with(formObj){
    		 if (sAction == IBSAVE){
		      	for (var i = 1 ; i < sheetObj.RowCount +1 ; i++){
		  	    	if (sheetObj.Cellvalue(i, 3) == ''){
		  	    		ComShowCodeMessage("BKG01101", 'ID');//($s) is mandatory. Please enter ($s).
		  	    		sheetObj.SelectCell(i, "hrd_cdg_id", true, ""); 				
		  	    		return false;
		  	    	}
		  	    	if(sheetObj.Cellvalue(i,"ibflag") == 'D'){
		  	    		childResult = 0;
		  	    		formObj.f_cmd.value = SEARCH03;
		  	    
		  	    		formObj.frm_hrd_cdg_id.value = sheetObj.Cellvalue(i,"hrd_cdg_id");
		  	    		doActionIBSheet(sheetObj, formObj, SEARCH03);
				      	if(childResult != 0){
				      		  
						  ComShowCodeMessage('BKG95057');//Hard Coding Contents table data should be deleted first
						  doActionIBSheet(sheetObj, formObj, IBSEARCH);
						  return false;
						 }
	
		  	    	}
		      	}

		       	     if (!sheetObj.IsDataModified){
						ComShowCodeMessage('BKG00743');//There is no updated data to save.
						
						return false; 
		    		 }
	       	    	
		      	
    		 }   	        
    		 else if (sAction == SEARCH01){
    			 if(sheetObj.Cellvalue(sheetObj.SelectRow,"ibflag")=='I'){
    				 ComShowCodeMessage("BKG01129"); //Please Save First.
    				 return false;
    			 }
    		 }

    	 }
          return true;
      }
		
     /**
      * process when you enter retrieve condition
      */
     function obj_KeyUp() {
     	var formObject = document.form;
     	var srcName = window.event.srcElement.getAttribute("name");
     	var srcMaxLength = window.event.srcElement.getAttribute("maxlength");
     	var srcValue = window.event.srcElement.getAttribute("value");
     }
   
  
	  /**
	   * Validation check- check if there is id in DB
	   */
	  function sheet1_OnChange(sheetObj, Row, Col, Value){
	  	var formObj = document.form;

	  	if(sheetObj.ColSaveName(Col) == "hrd_cdg_id"){
	  		
	  		formObj.f_cmd.value = SEARCH02;
	  		formObj.frm_hrd_cdg_id.value = sheetObj.CellValue(Row, Col);
	  		doActionIBSheet(sheetObj, formObj, SEARCH02);
	  		}
	
	  	}
	 
      
	/**
	 * add row process in sheet1
	 * add one row
	 */
 	function addRow() {
 	  with (sheetObjects[0]) {
         var nowRow = SelectRow;
       	 nowRow = DataInsert(-1);  
       	 sheetObjects[0].SelectCell(nowRow, 'hrd_cdg_id', true, ''); 
         return true;
          }
	 }
	/**
	 * delete row process in sheet1
	 * delete one row
	 */  
	 function deleteRow() {
 
	     with (sheetObjects[0]) {
	  		if (sheetObjects[0].CheckedRows("check") <= 0 ) {
				ComShowCodeMessage("BKG00249");
	 		}	 
	         var sRowStr = FindCheckedRow("check");
	         var arr = sRowStr.split("|");
	
	
	         for (var i=0; i<arr.length - 1; i++) {
	             
	        	 RowStatus(arr[i]) = "D";    
	             RowHidden(arr[i]) = "true"; 
	                 
	         }
	
	     }         
	 }
	/**
	 * connected with ESM_BKG_2005 popup screen
	 */  
	 function popupId(row) {
	     with (sheetObjects[0]) {
	    	 	var num = row;
				var idx = sheetObjects[0].CellValue(num, "hrd_cdg_id");
				var idx1 = sheetObjects[0].CellValue(num, "attr_nm1");
				var idx2 = sheetObjects[0].CellValue(num, "attr_nm2");
				var idx3 = sheetObjects[0].CellValue(num, "attr_nm3");
				var idx4 = sheetObjects[0].CellValue(num, "attr_nm4");
				var idx5 = sheetObjects[0].CellValue(num, "attr_nm5");
				var idx6 = sheetObjects[0].CellValue(num, "attr_nm6");
				var idx7 = sheetObjects[0].CellValue(num, "attr_nm7");
				var idx8 = sheetObjects[0].CellValue(num, "attr_nm8");
				var idx9 = sheetObjects[0].CellValue(num, "attr_nm9");
				var idx10 = sheetObjects[0].CellValue(num, "attr_nm10");
				
	        	var sUrl = "/hanjin/ESM_BKG_2005.do?hrd_cdg_id="+idx+"&attr_nm1="+idx1+"&attr_nm2="+idx2+"&attr_nm3="+idx3+"&attr_nm4="+idx4+"&attr_nm5="+idx5+"&attr_nm6="+idx6+"&attr_nm7="+idx7+"&attr_nm8="+idx8+"&attr_nm9="+idx9+"&attr_nm10="+idx10;
	        	ComOpenPopup(sUrl, 835, 660, "", "0,0", true);
	     }         
	 }
	/**
	 * vaidation check in sheet1 and call  popupId function
	 */  	 
	 function sheet1_OnDblClick(sheetObj, row, col){
	      	
		 if(sheetObj.Cellvalue(row, 3) == ''){
	  	    						
			ComShowCodeMessage("BKG01129");//Please save first.
			sheetObj.SelectCell(row, 'hrd_cdg_id', true, ''); 
			sheetObj.hrd_cdg_id.focus();				
			return false;
	  	    	}
		 if(sheetObj.Cellvalue(row,"ibflag") == 'I'){
 			ComShowCodeMessage("BKG01129");//Please save first.
	    		return false;
		 }
	  		popupId(row);
	 }
	 
	 