/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0738.js
*@FileTitle  : Wharfage Exception Customers
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
	 * @extends
	 * @class Customer Code Entry : business script for Customer Code Entry
	 */
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /** *** using extra sheet valuable if there are more 2 sheets **** */
		 var sheetObject1=sheetObjects[0];
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_retrieve":
                	doActionIBSheet(sheetObject1,document.form,IBSEARCH);
				break;
            	case "btn_save":
            		doActionIBSheet(sheetObject1,document.form,IBSAVE);
            	break;				
            	case "btn_select":
            		doActionIBSheet(sheetObject1,document.form,COMMAND01);
            	break;				
            	case "btn_add":
					var rowNum=sheetObject1.DataInsert(-1);
					sheetObject1.SetCellValue(rowNum, "attr_ctnt1",formObject.attr_ctnt1.value,0);
				break;
				case "btn_del":
					doActionIBSheet(sheetObject1,document.form,IBDELETE);
				break;	
				case "btn_close":
					ComClosePopup(); 
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
	 * registering IBSheet Object as list adding process for list in case of
	 * needing batch processing with other items defining list on the top of
	 * source
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
	 * initializing sheet implementing onLoad event handler in body tag adding
	 * first-served functions after loading screen.
	 */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        if( 'Y' == document.form.popup.value )
        	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
	 * loading HTML Control event <br>
	 * 
	 * @param sheetObj
	 * @param sheetNo
	 */
    function initControl() {
    	var formObject=document.form;
    	// Axon event handling
        axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  formObject); // -
        axon_event.addListenerFormat('beforeactivate',   'obj_activate',    formObject); // -
//        axon_event.addListenerFormat('keypress',         'obj_keypress',    formObject); // - in 
        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    /**
	 * control keyboard input at onkeypress event of HTML Control
	 */
//    function obj_keypress(){
//		switch(event.srcElement.dataformat){
//	    	case "int":
//		        ComKeyOnlyNumber(event.srcElement);
//		        break;
//	        case "float":
//	            ComKeyOnlyNumber(event.srcElement, ".");
//	            break;
//	        case "eng":
//	            ComKeyOnlyAlphabet();
//	            break;
//	        case "engdn":
//	            ComKeyOnlyAlphabet('lower');
//	            break;
//	        case "engup":
//	            ComKeyOnlyAlphabet('upper');
//	            break;
//	        default:
//	            ComKeyOnlyNumber(event.srcElement);
//	    }
//	}        
	 /**
		 * setting sheet initial values and header
		 * 
		 * @param sheetObj
		 * @param sheetNo
		 * @return
		 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
				switch(sheetID) {
					case "sheet1":
					    with(sheetObj){
				        
				      var HeadTitle="|Sel.|면제화주|사업자등록번호||";
				      var headCount=ComCountHeadTitle(HeadTitle);
				      //(6, 0, 0, true);

				      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0, FrozenCol:0 } );

				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:0 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);

				      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Chk" ,			KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, },
				             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt3",      KeyField:0,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"hrd_cdg_id_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"attr_ctnt1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
				       
				      InitColumns(cols);
				      SetSheetHeight(202);
				      SetEditable(1);
//				      SetGetCountPosition(0);
				            }
					break;
			}
	}
    /**
	 * handling sheet process
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return void
	 */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      // retrieve
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;   
						sheetObj.DoSearch("ESM_BKG_0738GS.do",FormQueryString(formObj) + "&hrd_cdg_id=KR_WHF_EXPT_CUST" );
        		}
			break;
			case IBSAVE:       
				if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=MULTI;
				    if (! sheetObj.IsDataModified()){
				    	ComShowCodeMessage('BKG00233');
	    	        	return;
	    	        }
				    var sParam=ComGetSaveString(sheetObjects);
	    	        sParam += "&" + FormQueryString(formObj) + "&hrd_cdg_id=KR_WHF_EXPT_CUST" ;
					 SaveXml=sheetObj.GetSaveData("ESM_BKG_0738GS.do", sParam);
					 sheetObj.LoadSaveData(SaveXml);
				}    
    	    break;
			case IBDELETE:    
				var checked=0;
				for (var i=1 ; i <= sheetObj.RowCount()+1 ; i++){
					if( sheetObj.GetCellValue(i,1) == '1' ){
						checked=1;
						if (sheetObj.GetCellValue(i,0) != "I"){
						if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowHidden( i ,1);
								sheetObj.SetRowStatus( i ,"D");
							}
						}else{
							if( sheetObj.GetCellValue(i,1) == '1' ){
								sheetObj.SetRowStatus( i ,"D");
								i--;
							}
						}
					}	
				}
				if ( checked == 0 ) ComShowCodeMessage('BKG00249');
			break;
			case IBDOWNEXCEL:
				if( sheetObj.RowCount()> 0 )
					sheetObjects[0].Down2Excel({HiddenColumn:-1,Merge:true,TreeLevel:false});
				else
					ComShowCodeMessage('BKG00389');
			break;
			case COMMAND01:
				var vChkRow=0;
				var vRgstNo='';
				for(var i=1; i<=sheetObj.RowCount(); i++){
					if( sheetObj.GetCellValue(i, 1) == '1' ){
						vChkRow=i ;
						vRgstNo=sheetObj.GetCellValue(i, 'attr_ctnt3');
					}	
				}
				if( vChkRow == 0 ){
					ComShowCodeMessage('BKG00624');
				} else {
					try {
			    		var obj=new Object();
			    		obj.vRgstNo=vRgstNo;
			    		//window.returnValue=obj;
			    		 ComPopUpReturnValue(obj);
			    		ComClosePopup(); 
					}catch(e) {}
				}
			break;
        }
    }
    /**
	 * handling process for input validation <br>
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return boolean
	 */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // retrieve
	 			if (formObj.attr_ctnt1.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'Country');
//	 				formObj.attr_ctnt1.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case IBSAVE: 
	 			if (formObj.attr_ctnt1.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00715', 'Country');
//	 				formObj.attr_ctnt1.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case IBDELETE: 
	 			if (formObj.port_cd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266');
//	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
     	}
     }
     function sheet1_OnDblClick(sheetObj, Row, Col, Value){
//
// var vChkRow = 0;
// var vRgstNo = '';
// for(var i=1; i<=sheetObj.RowCount; i++){
// if( sheetObj.Cellvalue(i, 1) == '1' ){
// vChkRow = i ;
// vRgstNo = sheetObj.Cellvalue(i, 'attr_ctnt3');
// }
// }
// if( vChkRow == 0 ){
// ComShowCodeMessage('BKG00624');
// } else {
				try {
		    		var obj=new Object();
		    		obj.vRgstNo=sheetObj.GetCellvalue(Row, 'attr_ctnt3');
		    		//window.returnValue=obj;
		    		ComPopUpReturnValue(obj);
		    		ComClosePopup(); 
				}catch(e) {}
// }
     }
    
