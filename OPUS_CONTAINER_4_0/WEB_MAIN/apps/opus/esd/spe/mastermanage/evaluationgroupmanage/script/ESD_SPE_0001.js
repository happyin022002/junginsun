/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SPE_0001.js
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

    /**
     * @extends 
     * @class ESD_SPE_0001 : business script for ESD_SPE_0001
     */
    function ESD_SPE_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
    
 // The common global variables

    var tabObjects = new Array();
    var tabCnt = 0 ;
    var beforetab = 1;

    var sheetObjects = new Array();
    var sheetCnt = 0;

    // Event handler processing by button click event */
    document.onclick = processButtonClick;

    // Event handler processing by button name */
        function processButtonClick(){
    		         var sheetObject1 = sheetObjects[0];
    		         var sheetObject2 = sheetObjects[1];

             var formObject = document.form;

        	try {
        		var srcName = window.event.srcElement.getAttribute("name");

                switch(srcName) {
    				case "btn_apply":
    						doActionIBSheet(sheetObject1,formObject,IBINSERT);
    						break;
    				case "btn_delete":
						doActionIBSheet(sheetObject1,formObject,IBDELETE);
						break;
    				case "btn_retrieve":
    						doActionIBSheet(sheetObject1,formObject,IBSEARCH);
    						break;

    				case "btn_save":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
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
         * Registering IBSheet Object as list
         * Adding process for list in case of needing batch processing with other items
         * Defining list on the top of source
         */
        function setSheetObject(sheet_obj){

           sheetObjects[sheetCnt++] = sheet_obj;

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

    		}


      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets 
         */
        function initSheet(sheetObj,sheetNo) {

            var cnt = 0;
    				var sheetID = sheetObj.id;

            switch(sheetID) {

                case "sheet1":
                    with (sheetObj) {

                    	//Setting height
      					 style.height = 260 ;
      					
      					//Setting width
     					SheetWidth = mainTable.clientWidth;
     		
     					//Setting the Host information[Required][HostIp, Port, PagePath]
     					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
     		
     					//Kind of merge [Optional, Default msNone]
     					MergeSheet = msHeaderOnly;
     		
     					//Edit kind [Optional, Default false]
     					Editable = true;
     		
     					//Setting row information[Required][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
     					InitRowInfo( 1, 1, 9, 100);
     		
     					//Setting column information[Required][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
     					InitColumnInfo(9, 0, 0, true);
     					
     					// Setting function handling header
                         InitHeadMode(true, true, false, true, false,false)

                         var HeadTitle = "||EG ID|EG Name|Level 1(RHQ)|Level 2|Level 3(Service Category)|P.I.C|" ;
     		
     					 //The information of the header row[Required][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
                         InitHeadRow(0, HeadTitle, true);
     		
     					//Data attribute    [ROW, COL,  DATATYPE,   WIDTH, 				DATAALIGN, COLMERGE, SAVENAME,  		KEYFIELD, 	CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
     					 InitDataProperty(0, cnt++ , dtDelCheck,   		30,    	daCenter,  	false,    "del_chk", 		false,          "",       dfNone,   	0,     true,       true);
     					 InitDataProperty(0, cnt++ , dtHiddenStatus, 	25,    	daCenter,  	false,    "ibflag",    		false,          "",       dfNone,   	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtData,       		70,    	daCenter,  	true,    "eg_id",     		false,          "",       dfNone,     	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtData,      		130,    daCenter,  	true,    "eg_name",     	false,          "",       dfNone,     	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtData,      		120,    daCenter,  	true,    "eg_rhq_cd",     	false,          "",       dfNone,     	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtData,      		130,    daCenter,  	true,    "eg_cty_cd",     	false,          "",       dfNone,     	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtData,      		170,    daCenter,  	true,    "svc_cate_cd",     false,          "",       dfNone,     	0,     false,      true);
                         InitDataProperty(0, cnt++ , dtPopup,      		50,    	daCenter,  	true,    "eg_pic_usr_id",  	false,           "",       dfNone,     	0,     true,       true);
                         InitDataProperty(0, cnt++ , dtHidden,			5,    	daCenter,  	false,    "eg_id_seq", 		false,          "",       dfNone,     	0,     false,      true);
    				  }
                    break; 
            }
        }

      // Handling the process about the sheet
        function doActionIBSheet(sheetObj,formObj,sAction) {
		  sheetObj.ShowDebugMsg = false;
		    switch(sAction) {
		      case IBSEARCH:      //retrieving
		      if(validateForm(sheetObj,formObj,sAction)){
                	if(!ComChkRequired(formObj)) return;
               		formObj.f_cmd.value = SEARCH;
               		var param = speFormString(formObj,'f_cmd,eg_id,eg_rhq_cd,eg_cty_cd,svc_cate_cd');
               		sheetObj.DoSearch("ESD_SPE_0001GS.do",param);
                }		      
		        break;
		     case IBSAVE:        //saving
		        if(!validateForm(sheetObj,formObj,sAction)) {
		            return false;
		        }//end if
		        formObj.f_cmd.value = MULTI;	
		       var param =speFormString(formObj,'f_cmd');
		       sheetObj.DoSave("ESD_SPE_0001GS.do", param);
		        break;
		      case IBINSERT:      // inserting
	      		if(formObj.search_flg.value == ''){	    
	      			ComShowCodeMessage("SPE10008","Retrieve","");
				}else if(sheetObj.RowCount >= 1){
					ComShowCodeMessage("SPE10001");
				}else if(formObj.search_flg.value == 'OK'){
					//setting the default value after creating
					var temp = '';
	  				if(formObj.svc_cate_cd.value == 'TR')
	  					temp = 'Truck';
	  				else if(formObj.svc_cate_cd.value == 'RL')
		  				temp = 'Rail';
	  				else if(formObj.svc_cate_cd.value == 'CY')
	  					temp = 'ODCY';
	  				else if(formObj.svc_cate_cd.value == 'TM')
	  					temp = 'Terminal';
	  				else if(formObj.svc_cate_cd.value == 'WT')
	  					temp = 'Water';
	  				else if(formObj.svc_cate_cd.value == 'EQ')
	  					temp = 'EQ M&R';	
	  								
					var result = true;
					for(var i=0; i<=sheetObj.RowCount; i++){
						if(sheetObj.CellValue(i,'eg_name') == (formObj.eg_rhq_cd.value +'-'+ formObj.eg_cty_cd.value.toUpperCase() +'-'+ temp))
							result = false;
					}  			
	
				 	if((formObj.eg_id.value != null && formObj.eg_id.value != "") && formObj.eg_id.value.substring(2,5)!= formObj.eg_rhq_cd.value){
				 		ComShowCodeMessage('COM12114','EG ID or LEVEL1');
				 		return false;
				 	}else if((formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == "")
						|| (formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == "")
						|| (formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == "")){
						ComShowCodeMessage('COM12113','LEVEL1');
						return false;
					}else if(!result){
						ComShowCodeMessage('COM12115','EG NAME');
					}else{
						var Row = sheetObj.DataInsert(-1);
						
						var seq = 0;
						var seq_t = '0';
						if(formObj.eg_rhq_cd.value == 'NYC'){
							seq =  Number(formObj.n_t.value) + 1;
							formObj.n_t.value = seq;
						}else if(formObj.eg_rhq_cd.value == 'HAM'){
							seq = Number(formObj.h_t.value) + 1;
							formObj.h_t.value = seq;					
						}else if(formObj.eg_rhq_cd.value == 'SHA'){
							seq = Number(formObj.s_t.value) + 1;
							formObj.s_t.value = seq;
						}else if(formObj.eg_rhq_cd.value == 'SIN'){  //N200903030120
							seq = Number(formObj.k_t.value) + 1;
							formObj.k_t.value = seq;	
						}
						
						if(seq < 10){
							seq_t = '00' + seq
						}else if(seq >= 10){
							seq_t = '0' + seq;
						}
						
						sheetObj.RowStatus(Row) = "I";
						
						if(formObj.eg_id.value == null || formObj.eg_id.value == ""){	
							sheetObj.CellValue2(Row, 2) = 'EG' + formObj.eg_rhq_cd.value + ' ' + seq_t;					
						}else{
							sheetObj.CellValue2(Row, 2) = formObj.eg_id.value.substring(2,5) + ' ' + seq_t;
							formObj.eg_id.value = 'EG' + formObj.eg_rhq_cd.value + ' ' + seq_t;
						}
						
						sheetObj.CellValue2(Row, 3) = formObj.eg_rhq_cd.value +'-'+ formObj.eg_cty_cd.value.toUpperCase() +'-'+ temp;
		  				sheetObj.CellValue2(Row, 4) = formObj.eg_rhq_cd.value;
		  				sheetObj.CellValue2(Row, 5) = formObj.eg_cty_cd.value.toUpperCase();
						sheetObj.CellValue2(Row, 6) = temp;
						
	
						return result;
						
					}
				}
		        break;
		      case IBDELETE:      // deleting
				ComRowHideDelete(sheetObj,"del_chk"); 
				break;	
		    }
		}

            /**
          	 * Handling the process for the input validation
          	 */
          	function validateForm(sheetObj,formObj,sAction){
          		with(formObj){          			
          			 if(formObj.eg_id.value == null || formObj.eg_id.value == ""){
          			 	if((formObj.eg_rhq_cd.value != null && formObj.eg_rhq_cd.value != "")
          					&& (formObj.svc_cate_cd.value != null && formObj.svc_cate_cd.value != "")
          					&& (formObj.eg_cty_cd.value != null && formObj.eg_cty_cd.value != "")){
          					return true;
          				}else if((formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == "")
          					&& (formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == "")
          					&& (formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == "")){ 
          					ComShowCodeMessage('COM12113','The conditions of retrieval');
          					return false;
          				}else if(formObj.eg_rhq_cd.value == null || formObj.eg_rhq_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL1');
          				 	return false;
          				}else if(formObj.eg_cty_cd.value == null || formObj.eg_cty_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL2');
          				 	return false;
          				}else if(formObj.svc_cate_cd.value == null || formObj.svc_cate_cd.value == ""){
          					ComShowCodeMessage('COM12113','LEVEL3');
          				 	return false;
          				}
          				
          				if(sAction == 'IBSAVE' && (sheetObj.CellValue(row, 'eg_pic_usr_id') == "" || sheetObj.CellValue(row, 'eg_pic_usr_id') == null)){
          					ComShowCodeMessage('COM12113','P.I.C.');	
          					return false;
          				}
          			 }else{
          			 	return true;
          			 }
          		 }
          	}    
          	
          	
            /**
          	 * Calling this function in case of closing the popup
          	 *
          	 */
          	function getEg_pic_usr_id(aryPopupData, row, col, sheetIdx){
          		var sheetObj = sheetObjects[0];
          		var formObject = document.form;
          		
          		var colArray = aryPopupData[0];
          		sheetObj.CellValue(row, "eg_pic_usr_id") = colArray[5]+ " / " +colArray[4] ;
          	}
          	
               	
          	/**
          	 * Calling this function in case of opening the popup window in sheet
          	 */
          	function sheet1_OnPopupClick(sheetObj, row, col){
          		if ( sheetObj.ColSaveName(col) == "eg_pic_usr_id" ){          			
          			ComOpenPopup('/opuscntr/COM_ENS_091.do', 770, 550, 'getEg_pic_usr_id', '1,0,1,1,1,1,1,1',true,false,row,col,0);
          		}
          	}
          	/**
           	 * Calling this function after finishing to retrieve the sheet
           	 */
           	function sheet1_OnSearchEnd(sheetObj,errMsg){           		
//           		if(errMsg!=null && errMsg ==''){     
//           			alert(errMsg);
//           			ComShowMessage(errMsg);
//           		}    
           		var formObject = document.form;
           		if(sheetObj.RowCount > 0){
	           		
	           		
	           		formObject.eg_id.value = sheetObj.CellValue(1,'eg_id');
	           		formObject.eg_rhq_cd.value = sheetObj.CellValue(1,'eg_rhq_cd');
	           		formObject.eg_cty_cd.value = sheetObj.CellValue(1,'eg_cty_cd');
	           		
	           		var temp = '';
	           		var svc_cate_cd = sheetObj.CellValue(1,'svc_cate_cd');
	           		if(svc_cate_cd == 'Truck')
	             			temp = 'TR';
	             		else if(svc_cate_cd == 'Rail')
	           	  		temp = 'RL';
	             		else if(svc_cate_cd == 'ODCY')
	             			temp = 'CY';
	             		else if(svc_cate_cd == 'Terminal')
	             			temp = 'TM';
	             		else if(svc_cate_cd == 'Water')
	             			temp = 'WT';
	             		else if(svc_cate_cd == 'EQ M&R')
	             			temp = 'EQ';
	             					
	           		formObject.svc_cate_cd.value = temp;	           		
           		
           		}else{               	
           			formObject.eg_id.value = "";
           			formObject.eg_rhq_cd.value = sheetObj.EtcData('eg_rhq_cd');
           			formObject.eg_cty_cd.value = sheetObj.EtcData('eg_cty_cd');
           			formObject.svc_cate_cd.value = sheetObj.EtcData('svc_cate_cd');              		
           		}           		
           		formObject.search_flg.value = 'OK';           	
           	}      
