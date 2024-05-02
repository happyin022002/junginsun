/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_2005.js
*@FileTitle : Hard Coding Content
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
     * @class esm_bkg_2005 : esm_bkg_2005 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
     */
    function ESM_BKG_2005() {
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


					case "btn_Save":
						doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
						break;

					case "btn_Copy":
						doActionIBSheet(sheetObjects[0], formObject, IBCOPYROW);
						break;
						
					case "btn_RowAdd":
						addRow();
						break;
					
					case "btn_RowDel":
						deleteRow();
						break;
						
	 				case "btn_Close":
	 					self.close();
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
    	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress", "obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

    	axon_event.addListenerForm('change', 'obj_change', document.form); // change
    	axon_event.addListenerForm('click', 'obj_click', document.form); // click
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);



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
                     style.height = 460;
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
                     
                     var HeadTitle1 = "|||Seq.";
                     var attr_nm = new Array();

                     attr_nm[0] = document.form.attr_nm1.value;
                     attr_nm[1] = document.form.attr_nm2.value;
                     attr_nm[2] = document.form.attr_nm3.value;
                     attr_nm[3] = document.form.attr_nm4.value;
                     attr_nm[4] = document.form.attr_nm5.value;
                     attr_nm[5] = document.form.attr_nm6.value;
                     attr_nm[6] = document.form.attr_nm7.value;
                     attr_nm[7] = document.form.attr_nm8.value;
                     attr_nm[8] = document.form.attr_nm9.value;
                     attr_nm[9] = document.form.attr_nm10.value;
                     
                     for(var i=0;i<10;i++){
                    	 if(attr_nm[i] == ''){
                    		 HeadTitle1 += "|Attribute" +(i+1);
                    	 }
                    	 else
                    		 HeadTitle1 += "|" + attr_nm[i];
                     }


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
     				 InitDataProperty(0, cnt++ , dtHidden,  30,     daCenterTop, 	 true,     "hrd_cdg_id");
                     InitDataProperty(0, cnt++ , dtHidden,  30,     daCenterTop, 	 true,     "hrd_cdg_id_seq");
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt1",	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt2", 	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt3",	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt4", 	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt5",	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt6", 	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt7",	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt8", 	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt9",	false,       "",      dfNone,      	0,     true,		true,	500);
                     InitDataProperty(0, cnt++ , dtData, 130,    daCenterTop, 	 true,     "attr_ctnt10", 	false,       "",      dfNone,      	0,     true,		true, 	500);
                     


                     //sheetObj.FrozenCols = 5;
     			}
     			break;
     	

         }
     }


   // handling sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	     sheetObj.ShowDebugMsg = false;
	     switch(sAction) {

	     	case IBSEARCH:      //retrieve

				formObj.f_cmd.value = SEARCH; 
				var sParam = FormQueryString(formObj);
				sheetObj.DoSearch("ESM_BKG_2005GS.do",sParam);
				ComOpenWait(false);

				break;
					
				
	     	case IBSAVE: // Save
				if(!validateForm(sheetObj,formObj,sAction))	return;


				formObj.f_cmd.value = MULTI;
				var sheet2 = sheetObjects[1];
				var sParam 	= sheetObj.GetSaveString(false, true, "ibflag");

				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObjects[0].GetSaveXml("ESM_BKG_2005GS.do",sParam);
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
			
			case IBCOPYROW: // Row Copy                                                                                                                                                                                                                                                                                                                                                                                                                                   
	                                                                                                                                                                                                                                                                                                                                                                                                                                                        
				if(sheetObj.CheckedRows("check") > 1) {                                                                                                                                                                                                                                                                                                                                                                                                   
					copyMultyRow(sheetObj);                                                                                                                                                                                                                                                                                                                                                                                                         
				} 
				else{
					var oldIdx = sheetObj.SelectRow;  
					var newIdx = sheetObj.DataCopy();                                                                                                                                                                                                                                                                                                                                                                                               
					if(newIdx > 0) {                 
						sheetObj.CellValue2(oldIdx, "check") = 0;
					}                                                                                                                                                                                                                                                                                                                                                                                                                               
				}                                                                                                                                                                                                                                                                                                                                                                                                                                       
				break;   
			
	     }
	 }



     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	  if(sAction==IBSAVE){
  	     	if (! sheetObj.IsDataModified){
  	     		ComShowCodeMessage('BKG00743');
				return false; //There is no updated data to save.
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
  	 * add row process in sheet1
  	 * add one row
  	 */
	 	function addRow() {
	 	  with (sheetObjects[0]) {
	         var nowRow = SelectRow;
	       	 nowRow = DataInsert(-1); 
	       	sheetObjects[0].CellValue(nowRow,"hrd_cdg_id") = document.form.hrd_cdg_id.value;
	         return true;
	          }
	 }
	/**
	 * delete row process in sheet1
	 * delete one row
	 */ 
	 function deleteRow() {
	     with (sheetObjects[0]) {
	         var sRowStr = FindCheckedRow("check");
	         var arr = sRowStr.split("|");
	
	
	         for (var i=0; i<arr.length - 1; i++) {
	             
	        	 RowStatus(arr[i]) = "D";    
	             RowHidden(arr[i]) = "true"; 
	                 
	         }
	
	     }         
	 }
	/**
	 * copyMultyRow process
	 * copy multi row
	 */  	 
	function copyMultyRow(sheetObj) {                                                                                                                                                                                                                                                                                                                                                                                                                               
		var checkArr = ComRtrim(sheetObj.FindCheckedRow("check"), '|').split("|");                                                                                                                                                                                                                                                                                                                                                                                
		if(checkArr != null && checkArr.length > 0) {                                                                                                                                                                                                                                                                                                                                                                                                           
			for(var i=checkArr.length-1; i>=0; i--) {                                                                                                                                                                                                                                                                                                                                                                                                       
				sheetObj.SelectRow = checkArr[i];                                                                                                                                                                                                                                                                                                                                                                                                       
				sheetObj.DataCopy();                                                                                                                                                                                                                                                                                                                                                                                                                    
				sheetObj.CellValue2(checkArr[i], "check") = 0;    
				
			}                                                                                                                                                                                                                                                                                                                                                                                                                                               
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	}        
