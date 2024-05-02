/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0208.js
*@FileTitle  : Bank Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_pso_0208 : business script for vop_pso_0208
     */
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
//    var usrOfcCd="";/*office cd of SSO user */
    var targetSheet=2;//index of target sheet
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
        function processButtonClick(){
    		var sheetObject1=sheetObjects[0];
    		var sheetObject2=sheetObjects[1];
    		var sheetObject3=sheetObjects[2];
    		var sheetObject4=sheetObjects[3];
    		/*******************************************************/
    		var formObject=document.form;
    		try {
        		var srcName=ComGetEvent("name");
        		if(ComGetBtnDisable(srcName)) return false;
            	switch(srcName) {
    	          	case "btn1_OK":
    					doActionIBSheet(sheetObject1,formObject,IBSAVE);
    					//self.close();
    					comPopupOK();
    					break;
    				case "btn1_Close":
    					ComClosePopup(); 
    					break;
    				case "btns_add":
    					/*selected object id on the Left*/
    					//Getting selected row number with "/", ex:"3/4/5"
    					  var sRowStr=sheetObject1.GetSelectionRows("/");
    					  if(sRowStr=="0"||sRowStr=="") break;
    					  var arr=sRowStr.split("/");
    					  for (i=0; i<arr.length; i++) {
    						  sheetObject1.SetCellValue(parseInt(arr[i]), "hiddencheck","Y",0);
    						  switch (targetSheet){
      	                		case 2:
      	                			sheetObject1.SetCellValue(parseInt(arr[i]), "sheet1_row_no","1",0);
      	                			break;
      	                		case 3:
      	                			sheetObject1.SetCellValue(parseInt(arr[i]), "sheet1_row_no","2",0);
      	                			break;
      	                		case 4:
      	                			sheetObject1.SetCellValue(parseInt(arr[i]), "sheet1_row_no","3",0);
      	                			break;
    						  }
    					  }
    	                var sTime=new Date();
    	                //ComSheet2SheetCheck(form.sheet1, form.sheet2, "hiddencheck");
    	                var sXml=ComMakeSearchXml(sheetObject1, false, "hiddencheck","sheet1_pso_obj_cd|sheet1_row_no|sheet1_obj_list_nm|sheet1_pso_meas_ut_cd|sheet1_obj_list_no|sheet1_pso_ofc_cd|sheet1_pso_obj_cd_dsp|sheet1_pso_meas_ut_cd_dsp", true);
    	                switch (targetSheet){
    	                	case 2:
    	                		//sheetObject2.ColumnSort("sheet2_pso_obj_cd|sheet2_pso_meas_ut_cd", "ASC");
    	                		sheetObject2.LoadSearchData(sXml.replace(/sheet1_/gi,"sheet2_"), {Append : 1} );
//    	                		sheetObject2.ColumnSort("sheet2_pso_obj_cd_dsp|sheet2_pso_meas_ut_cd_dsp", "ASC");
    	                		break;
    	                	case 3:
    	                		//sheetObject3.ColumnSort("sheet3_pso_obj_cd|sheet3_pso_meas_ut_cd", "ASC");
    	                		sheetObject3.LoadSearchData(sXml.replace(/sheet1_/gi,"sheet3_"), {Append : 1} );
//    	                		sheetObject3.ColumnSort("sheet3_pso_obj_cd_dsp|sheet3_pso_meas_ut_cd_dsp", "ASC");
    	                		break;
    	                	case 4:
    	                		//sheetObject4.ColumnSort("sheet4_pso_obj_cd|sheet4_pso_meas_ut_cd", "ASC");
    	                		sheetObject4.LoadSearchData(sXml.replace(/sheet1_/gi,"sheet4_"), {Append : 1} ); 
//    	                		sheetObject4.ColumnSort("sheet4_pso_obj_cd_dsp|sheet4_pso_meas_ut_cd_dsp", "ASC");
    	                		break;
    	                	default : break;	
    	                }
    					break;
    				case "btns_del":
	    				var sRowStr="";
	    				var sXml="";
    	                var sTime=new Date();
    	                switch (targetSheet){
	    	                case 2:
	    	                	sRowStr=sheetObject2.GetSelectionRows("/");
	    	                	if(sheetObject2.RowCount()==0||sRowStr=="") break;
	    	                	var arr=sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject2.SetCellValue(parseInt(arr[i]), "hiddencheck","Y");
	    	                	}
//	    	                	sheetObject2.ReNumberSeq();
	    	                	sXml=ComMakeSearchXml(sheetObject2, false, "hiddencheck","sheet2_pso_obj_cd|sheet2_obj_list_nm|sheet2_pso_meas_ut_cd|sheet2_obj_list_no|sheet2_pso_ofc_cd|sheet2_pso_obj_cd_dsp|sheet2_pso_meas_ut_cd_dsp", true)
	    	                	sheetObject1.LoadSearchData(sXml.replace(/sheet2_/gi,"sheet1_"),{Append : 1} );
	    	                	break;
	    	                case 3:
	    	                	sRowStr=sheetObject3.GetSelectionRows("/");
	    	                	if(sheetObject3.RowCount()==0||sRowStr=="") break;
	    	                	var arr=sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject3.SetCellValue(parseInt(arr[i]), "hiddencheck","Y",0);
	    	                	}
	    	                	sXml=ComMakeSearchXml(sheetObject3, false, "hiddencheck","sheet3_pso_obj_cd|sheet3_obj_list_nm|sheet3_pso_meas_ut_cd|sheet3_obj_list_no|sheet3_pso_ofc_cd|sheet3_pso_obj_cd_dsp|sheet3_pso_meas_ut_cd_dsp", true)
	    	                	sheetObject1.LoadSearchData(sXml.replace(/sheet3_/gi,"sheet1_"),{Append : 1});
	    	                	break;
	    	                case 4:
	    	                	sRowStr=sheetObject4.GetSelectionRows("/");
	    	                	if(sheetObject4.RowCount()==0||sRowStr=="") break;
	    	                	var arr=sRowStr.split("/");
	    	                	for (i=0; i<arr.length; i++) {
	    	                		sheetObject4.SetCellValue(parseInt(arr[i]), "hiddencheck","Y",0);
	    	                	}
	    	                	sXml=ComMakeSearchXml(sheetObject4, false, "hiddencheck","sheet4_pso_obj_cd|sheet4_obj_list_nm|sheet4_pso_meas_ut_cd|sheet4_obj_list_no|sheet4_pso_ofc_cd|sheet4_pso_obj_cd_dsp|sheet4_pso_meas_ut_cd_dsp", true)
	    	                	sheetObject1.LoadSearchData(sXml.replace(/sheet4_/gi,"sheet1_"),{Append : 1});
	    	                	break;
	    	                default : break;	
    	              }
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen
     */
    function loadPage() {
    	var formObject=document.form;
//    	formObject.pso_ofc_cd.value=usrOfcCd; //ofc cd 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
     }
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) {
          	var cnt=0;
    		var sheetid=sheetObj.id;
          	switch(sheetid) {
    			case "sheet1":
    			    with(sheetObj){
    		        
    		      var HeadTitle1="Status|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet1_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    		      var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" , TrueValue:"Y", FalseValue:"N"},
    		             //{Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"NONE" },
    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center"},
    		             {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
    		             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm" },
    		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_no" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_ofc_cd" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"row_no" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_obj_cd" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd" } ];
    		       
    		      InitColumns(cols);

    		      SetEditable(0);
//    		      SetSelectionMode(smSelectionList);
//    		      SetColHidden("hiddencheck",1);
    		      SetSheetHeight(535);
    		      }


    				break;
    			case "sheet2":
    			    with(sheetObj){
    		       
    		      var HeadTitle1="|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet2_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    		      var info    = { Sort:1, ColMove:1, ColResize:1, HeaderCheck:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" , TrueValue:"Y", FalseValue:"N"},
    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rn" },
    		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
    		             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm" },
    		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_no" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_ofc_cd" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"row_no" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_obj_cd" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd" } ];
    		      
    		      InitColumns(cols);

    		      SetEditable(0);
//    		      SetSelectionMode(smSelectionList);
//    		      SetColHidden("hiddencheck",1);
    		      SetSheetHeight(140);
    		      SetSelectionMode(1);
    			}
    				break;
    			case "sheet3":
    			    with(sheetObj){
    		       
    		      var HeadTitle1="|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet3_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" , TrueValue:"Y", FalseValue:"N"},
    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rn" },
    		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
    		             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm" },
    		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_no" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_ofc_cd" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"row_no" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_obj_cd" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd" } ];
    		       
    		      InitColumns(cols);

    		      SetEditable(0);
//    		      SetSelectionMode(smSelectionList);
//    		      SetColHidden("hiddencheck",1);
    		      SetSheetHeight(140);
    		      }


    				break;
    			case "sheet4":
    			    with(sheetObj){
    		        
    		      var HeadTitle1="|CHK|Seq.|Subject Item|Subject Item|UOM|OBJLISTNO|OFCCD|ROWNO|hidden1|hidden2";
    		      var headCount=ComCountHeadTitle(HeadTitle1);
    		      var prefix="sheet4_";

    		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

    		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
    		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
    		      InitHeaders(headers, info);

    		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
    		             {Type:"CheckBox",  Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"hiddencheck" , TrueValue:"Y", FalseValue:"N"},
    		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rn" },
    		             {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_cd_dsp" },
    		             {Type:"Text",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm" },
    		             {Type:"Text",     Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd_dsp" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_no" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_ofc_cd" },
    		             {Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:prefix+"row_no" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_obj_cd" },
    		             {Type:"Text",      Hidden:1, Width:0,    Align:"Left",    ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd" } ];
    		       
    		      InitColumns(cols);

    		      SetEditable(0);
//    		      SetSelectionMode(smSelectionList);
//    		      SetColHidden("hiddencheck",1);
    		      SetSheetHeight(140);
    		      }


    				break;
            }
        }
    // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg(false);
        var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var sheetObject3=sheetObjects[2];
		var sheetObject4=sheetObjects[3];
//    		sheetObject4.ShowDebugMsg = true;
		var saveObjs=new Array(3);
		saveObjs[0]=sheetObject2;
		saveObjs[1]=sheetObject3;
		saveObjs[2]=sheetObject4;
//		sheetObject1.SetWaitImageVisible(0);
//		sheetObject2.SetWaitImageVisible(0);
//		sheetObject3.SetWaitImageVisible(0);
//		sheetObject4.SetWaitImageVisible(0);
        switch(sAction) {
			case IBSEARCH:      //Retrieving
				if(!validateForm(sheetObj,formObj,sAction)) return;
				if ( sheetObj.id == "sheet1"){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_", "sheet4_");
 					var sXml=sheetObj.GetSearchData("VOP_PSO_0208GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
					var sXmls=sXml.split('|$$|');
					for(var i=0; i<sXmls.length;i++){
						sheetObjects[i].LoadSearchData(sXmls[i],{Sync:1} );
					}
					ComOpenWait(false);
				}
				break;
			 case IBSAVE:        //Save
				if(!validateForm(sheetObj,formObj,sAction)) return;
			    ComOpenWait(true);
			  	formObj.f_cmd.value=MULTI;
			  	for(var i=0; i<saveObjs.length;i++){
			  		for(var j=saveObjs[i].HeaderRows(); j<=saveObjs[i].RowCount();j++)//setting status to insert
			  			saveObjs[i].SetCellValue(j,0,"I");
			  	}
				//var SaveStr = ComGetSaveString(sheetObjects); 
				var SaveStr=ComGetSaveString(saveObjs);
				//alert(SaveStr);
				var aryPrefix=new Array("sheet2_", "sheet3_", "sheet4_");
 				var sXml=sheetObject2.GetSaveData("VOP_PSO_0208GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
				//alert(sXml);
				ComOpenWait(false);
 				sheetObjects[0].LoadSaveData(sXml);
				break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
	function sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement=document.getElementById("btns_add");
		ComFireEvent(addElement, "click");
	}
	function sheet2_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement=document.getElementById("btns_del");
		ComFireEvent(addElement, "click");
	}
	function sheet3_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement=document.getElementById("btns_del");
		ComFireEvent(addElement, "click");
	}
	function sheet4_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH){
		var addElement=document.getElementById("btns_del");
		ComFireEvent(addElement, "click");
	}
	function sheet2_OnMouseDown(Button, Shift, X, Y){
    	targetSheet=2;
    	var color = "#FF0000";
    	ComSetSheetOuterLine(sheetObjects[1], color);
    	ComSetSheetOuterLine(sheetObjects[2], ComGetSheetOuterLine(sheetObjects[0]));
    	ComSetSheetOuterLine(sheetObjects[3], ComGetSheetOuterLine(sheetObjects[0]));
    }
    function sheet3_OnMouseDown(Button, Shift, X, Y){
    	targetSheet=3;
    	var color = "#FF0000";
    	ComSetSheetOuterLine(sheetObjects[1], ComGetSheetOuterLine(sheetObjects[0]));
    	ComSetSheetOuterLine(sheetObjects[2], color);
    	ComSetSheetOuterLine(sheetObjects[3], ComGetSheetOuterLine(sheetObjects[0]));
    }
    function sheet4_OnMouseDown(Button, Shift, X, Y){
    	targetSheet=4;
    	var color = "#FF0000";
    	ComSetSheetOuterLine(sheetObjects[1], ComGetSheetOuterLine(sheetObjects[0]));
    	ComSetSheetOuterLine(sheetObjects[2], ComGetSheetOuterLine(sheetObjects[0]));
    	ComSetSheetOuterLine(sheetObjects[3], color);
    }
    /**
	 * process after retrieve sheet1
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg){
		//sheetObj.ColumnSort("sheet1_pso_obj_cd_dsp|sheet1_pso_meas_ut_cd_dsp", "ASC");
		//sheetObj.ReNumberSeq();
	}
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColumnSort("sheet2_pso_obj_cd_dsp|sheet2_pso_meas_ut_cd_dsp", "ASC");
		sheetObj.ReNumberSeq();
	}
	function sheet3_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColumnSort("sheet3_pso_obj_cd_dsp|sheet3_pso_meas_ut_cd_dsp", "ASC");
		sheetObj.ReNumberSeq();
	}
	function sheet4_OnSearchEnd(sheetObj, ErrMsg){
		sheetObj.ColumnSort("sheet4_pso_obj_cd_dsp|sheet4_pso_meas_ut_cd_dsp", "ASC");
		sheetObj.ReNumberSeq();
	}