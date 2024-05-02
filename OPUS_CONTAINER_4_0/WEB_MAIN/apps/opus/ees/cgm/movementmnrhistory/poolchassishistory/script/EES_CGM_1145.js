/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CGM_1145.js
*@FileTitle : Invoice File Import(Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
 // common global variables
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var uploadFileSeq="";
	var fileUploadFlag=false;
	var fileSaveFlag=false; 
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
	             case "btn_rowadd":
	            	 sheetObject.DataInsert();
	            	 for(i=1; i<sheetObject.RowCount()+1; i++){
	            		 if(sheetObject.GetCellValue(i, "ibflag") == "I"){
	     					sheetObject.SetCellEditable(i, "org_file_nm",1);
	     				}
	     			}
	            	 break;
	             case "btn_retrieve":
	            	 doActionIBSheet(sheetObject,document.form,IBSEARCH)
	            	 break;
     			// setting hidden culumn value(CUD Query mandatory culumn value)
	     		case "btn_delete":
	    			// page only deleting(deletingfunction call)
	    			rowDelete(sheetObject);
	    			break;
                 case "btn_save":
                	 doActionIBSheet(sheetObject,document.form,IBSAVE)
 					 break;
                 case "btn_close":
                	 ComClosePopup(); 
 								break;
             } // end switch
     	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
     	}
     }
     /**
      * registering IBSheet Object as list
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setSheetObject(sheet_obj){
        sheetObjects[sheetCnt++]=sheet_obj;
     }


      /**
       * selected ROW deleting 
       */
      function rowDelete(sheetObj){
      	for(i=sheetObj.RowCount(); i>0; i--){
      		if( sheetObj.GetCellValue(i, "del_chk") == "1") {
      			if(sheetObj.GetCellValue(i, "file_imp_proc_sts_cd")!="C"
      				&& sheetObj.GetCellValue(i, "file_seq")!=""){
      				ComShowCodeMessage('CGM10083');
      				return ;
      			} else {
      				if(sheetObj.GetCellValue(i, "file_seq")==""){
      					sheetObj.RowDelete(i, false);
      				} else {
      					sheetObj.SetRowHidden(i,1);
        				sheetObj.SetRowStatus(i,"D");
      				}
      			}
      		}
      	}
      	sheetObj.ReNumberSeq();
      }
     /**
      * initializing sheet
      * implementing onLoad event handler in body tag
      * adding first-served functions after loading screen.
      */
     function loadPage() {
  		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        
         sheet1_OnLoadFinish(sheet1);
         
         initUpload();
     }
      /**
       * 
       * @param sheetObj
       * @return
       */
        function sheet1_OnLoadFinish(sheetObj) {
          sheetObj.SetWaitImageVisible(0);
  		 initControl(sheetObjects[0]);   
 		 sheetObj.SetWaitImageVisible(1);
     }
       /**
       * init control of form <br>
       * @param  {object} sheetObj	
       * @return 
       * @author 
       * @version
       */
      function initControl(sheetObj){
      	// Form object
      	  formObj=document.form;
          doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
      }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      //t1sheet1 init
                 with(sheetObj){
	              var HeadTitle="|Seq.|Sel.|Lessor File Name|Import Process Status|Import Result|Import Time|Import User ID||||";
	              var headCount=ComCountHeadTitle(HeadTitle);
	
	              SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
	                  {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
	                  {Type:"Popup",     Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"org_file_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"file_imp_proc_sts_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:0,   SaveName:"imp_rslt_desc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"file_imp_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"org_file_path",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sav_file_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"file_seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                  {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"file_imp_proc_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
                  SetSheetHeight(250);
                  SetShowButtonImage(4);
             }
                 break;
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
               formObj.f_cmd.value=SEARCH;
			   queryString="f_cmd=" + SEARCH ;
			   var params=FormQueryString(formObj);
			   sheetObj.SetWaitImageVisible(0);
			   ComOpenWait(true);
 			   sheetObj.DoSearch("EES_CGM_1145GS.do",  params );
			   ComOpenWait(false);
                 break;
 			 case IBSAVE:        //saving
// 			     var params = sheetObj.GetSaveXml(true);
	 			 if(validateForm(sheetObj,formObj,sAction)){
	 				 var sParam="";
				     var sParam1=sheetObj.GetSaveString(true);
				     formObj.f_cmd.value=MULTI;
				     queryString="f_cmd=" + MULTI ;
				     var params=FormQueryString(formObj);
				   //  sParam = sParam1 + "&"+ params;
				     var sXml=sheetObj.DoSave("EES_CGM_1145GS.do" , params);
	 			 }
                 break;
         }
     }
     /**
      * adding process for list in case of needing batch processing with other items
      * defining list on the top of source
      */
     function setTabObject(tab_obj){
         tabObjects[tabCnt++]=tab_obj;
     }

	 	
     var pSheetObj, pRow, pCol ;
     function initUpload(){
     	upload1.Initialize({
     		SaveUrl:'/opuscntr/CGM_INTGS.do',
     		Files:[
     		]
    		,BeforeAddFile : function(result){ 
    			
     			return true;
    		}
     		,AfterSaveStatus : function(result) {  
	      		var code = result.code;
	      		if( code == 0) {
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	     			uploadFileName=ComGetEtcData(sXml,"filename");
	     			pSheetObj.SetCellValue(pRow, "sav_file_nm",uploadFileName,0);
	    			if(pSheetObj.GetCellValue(pRow, "sav_file_nm")==""){
	    				ComShowCodeMessage('CGM20036'); 
	    				pSheetObj.SetCellValue(pRow, "org_file_nm","",0);
	    			} 
	    			fileUploadFlag=false;
	      		}else {
					ComShowMessage(result.msg);
				}
    			ComOpenWait(false);
     		}
     		,AfterAddFile:function(result){
    			
     			var files = result.files;
     			var fileType="";
     			var badFile=false;
     			
     			var fileName= files[files.length-1].GetFileName();
     			fileType=fileName.substr(fileName.lastIndexOf(".") + 1);  // File Type
 				//TXT, XLS
 				if ( fileType.toUpperCase() != "CSV" && fileType.toUpperCase() != "ZIP" 
 					&& fileType.toUpperCase() != "XLS"&& fileType.toUpperCase() != "XLSX" ) {
 					badFile=true;
 				}
 				
     			if ( !badFile ) {
     		 		ComOpenWait(true);
     		 		fileUploadFlag=true;
     		 		sheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
     				upload1.SaveStatus();

     			} else {
     				files[files.length-1].DeleteFromList();
     		 		ComShowCodeMessage('CGM10081');
     			}
     			
     		}
     	});
     }
     
     /**
      * Occurs when the mouse moves on the sheet <br>
      * @param {ibsheet} sheet    IBSheet Object
      * @param {ibsheet} Button     	selected sheet Button
      * @param {ibsheet} Shift     	selected sheet Shift
      * @param {int} 	X     		X coordinates
      * @param {int} 	Y     		Y coordinates
      **/
     function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
     	var row=sheetObj.MouseRow();
     	var col=sheetObj.MouseCol();
     	if (row < sheetObj.HeaderRows()|| col < 0) {
     		return;
     	}
     
     	var saveName = sheetObj.ColSaveName(col); 
     	var editFlag = sheetObj.GetCellEditable( row , col);
     	//sheetObj.SetSelectCell(row, col);
     	if (row > 0 && saveName=="org_file_nm" && editFlag == 1) {
     	     if ( fileUploadFlag ) {
     	   		return;
     	   	}

     		info = sheetObj.GetCellElement(row, col, 1);

       		pSheetObj = sheetObj;
     			pRow = row;
     			pCol = col;

               upload1.SetFileUploadElement(info);
               
     	} else if (saveName=="file_download") {
     		sheetObj.SetMousePointer((status=="I")?"Default":"Hand");
     	}
     }
     
     

  	  /**
  	   * error log
  	   * @param sheetObj
  	   * @param Row
  	   * @param Col
  	   * @return
  	   */
  	  function sheet1_OnDblClick(sheetObj, Row, Col){
	  		if(Col==5  ){
	  			var param="?pgmNo=EES_CGM_1149";
	  			param=param + "&file_seq=" + sheetObj.GetCellValue(Row, "file_seq") ;
		    	ComOpenPopup('/opuscntr/EES_CGM_1149.do' + param, 700, 460, "", "1,0", true, false);
	  		}
  	   }
     /**
      * handling process for input validation
      */
      function validateForm(sheetObj,formObj,sAction){
    	  switch(sAction) {
			case IBSAVE:      //retrieve
			for(i=1;i<sheetObj.RowCount()+1;   i++){
				if( sheetObj.GetCellValue(i, "del_chk") == "1" &&  sheetObj.GetCellValue(i, "ibflag") == "I") {
					if(sheetObj.GetCellValue(i, "sav_file_nm") == ""){
	      				sheetObj.SetRowStatus(i,"R");
		      			sheetObj.SetCellValue(i, "del_chk","0");
	      			} else {
	      				sheetObj.SetRowStatus(i,"I");
	      			}
				} else if( sheetObj.GetCellValue(i, "ibflag") == "D") {
	      			sheetObj.SetRowStatus(i,"D");
				} else if( sheetObj.GetCellValue(i, "del_chk") == "1" && sheetObj.GetCellValue(i, "ibflag") == "U") {
					if( sheetObj.GetCellValue(i, "file_seq") != ""){
	      				sheetObj.SetRowStatus(i,"R");
	      				sheetObj.SetCellValue(i, "del_chk","0");
	      			} else {
	      				sheetObj.SetRowStatus(i,"I");
	      			}
	      		} else {
	      			sheetObj.SetRowStatus(i,"R");
	      			sheetObj.SetCellValue(i, "del_chk","0");
	      		}
	      	}
            break;
    	  }
         return true;
     }
      function sheet1_OnSaveEnd(sheetObj, code, errMsg) {
		 if(errMsg =='') {   
			 ComShowCodeMessage('CGM00003');
	    	 var sheetObject1=sheetObjects[0];
			 doActionIBSheet(sheetObject1,document.form,IBSEARCH); 
		 }
	 }   
	/* developer job end */
