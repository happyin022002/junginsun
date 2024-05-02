/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_2100.js
*@FileTitle  : Container Type Size Division
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cim_2100 : business script for ees_cim_2100
     */
    function ees_cim_2100() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    var sheetObjects=new Array();
    var sheetCnt=0;
    var strOfcCd="";
     // Event handler processing by button click event */
    document.onclick=processButtonClick;
     // Event handler processing by button name */
        function processButtonClick(){
       	 var sheetObject1=sheetObjects[0];
       	 var formObject=document.form;
        	try {
        		var srcName=ComGetEvent("name");
                switch(srcName)
                {
   				case "btn_add":
   					doActionIBSheet(sheetObject1,formObject,IBINSERT);
   				break; 
   				case "btn_delete":
   					if(sheetObject1.FindCheckedRow("Sel")=="")
   					{
   						ComShowCodeMessage("CIM00010");
   					}
   					else if(ComShowCodeConfirm("CIM00005")) 
   					{ 
   						doActionIBSheet(sheetObject1,formObject,IBDELETE);
   					}
   				break;
   				case "btn_retrieve":
   					sheetObject1.SetWaitImageVisible(0);
   					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
   					sheetObject1.SetWaitImageVisible(1);
   				break;														
   				case "btn_save":
   					doActionIBSheet(sheetObject1,formObject,IBSAVE);
   				break;														
   				case "btn_downexcel":
   					if(sheetObject1.RowCount() < 1){//no data
   						ComShowCodeMessage("COM132501");
   					}else{
   						sheetObject1.Down2Excel({ HiddenColumn:true});
   					}
   				break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			ComShowCodeMessage("CIM00011",srcName+" Button Fail.");
        		} else {
        			ComShowCodeMessage("CIM00011",e);
        		}
        	}
        }
        /**
         * registering IBSheet Object as list
         * adding process for list in case of needing batch processing with other items 
         * defining list on the top of source
         */
        function setSheetObject(sheet_obj)
        {
           sheetObjects[sheetCnt++]=sheet_obj;
        }
        /**
         * initializing sheet
         * implementing onLoad event handler in body tag
         * adding first-served functions after loading screen.
         */
        function loadPage() 
        {
            for(i=0;i<sheetObjects.length;i++)
            {
            	ComConfigSheet (sheetObjects[i] );
            	initSheet(sheetObjects[i],i+1);
            	ComEndConfigSheet(sheetObjects[i]);
            }
            sheet1_OnLoadFinish(sheet1);
            //doActionIBSheet(sheetObjects[0], document.form, SEARCH09);
        }
        function sheet1_OnLoadFinish(sheetObj){
            sheetObj.SetWaitImageVisible(0);
            doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
            sheetObj.SetWaitImageVisible(1);
     	}
     	/**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo) 
        {
            var cnt=0;
            switch(sheetNo) 
            {
                case 1:      //sheet1 init
                    with(sheetObj){
	                  var HeadTitle="||Seq.|Type Size|Type Size Div";
	
	                  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                  var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                         {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Sel" },
	                         {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"dp_seq",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
	                         {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	                         {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_div_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
	                   
	                  InitColumns(cols);
	
	                  SetEditable(1);
	                  SetColProperty(0 ,"dp_seq" , {AcceptKeys:"N"});
	                  SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|N", InputCaseSensitive:1});
	                  SetColProperty(0 ,"cntr_tpsz_div_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                  SetSheetHeight(460);
	                }
                    break;
            }
        }
        /**
         * sheet event
         */
        function doActionIBSheet(sheetObj,formObj,sAction) {
            sheetObj.ShowDebugMsg(false);
			var selrow=sheetObj.GetSelectRow();
            switch(sAction) 
            {
   			case IBINSERT:
//   				if ( selrow > 0 )
//   				{
//   					sheetObj.DataInsert(selrow);
//   					sheetObj.SelectCell(selrow+1, 3, true);
//   				}
//   				else
//   				{
//   					sheetObj.DataInsert(-1);
//   				}
   				var currow=sheetObj.DataInsert(-1);
   			    if ( currow == 1 )
   			    {
   			    	sheetObj.SetCellValue(1, 2,"01");
   			    }
   			    else if ( currow > 1 )
   			    {
   			    	sheetObj.SetCellValue(currow, 2,ComLpad(Number(sheetObj.GetCellValue(currow - 1, 2)) + 1, 2, "0"));
   			    }
   			break;
   			case IBSEARCH:
				if(sheetObj.id == "sheet1") {
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);					
					formObj.f_cmd.value=SEARCH;
	 				var xml="";
	 				xml=sheetObj.GetSearchData("EES_CIM_2100GS.do", FormQueryString(formObj));
	 				sheetObj.LoadSearchData(xml,{Sync:1} );
				}
   			break;
   			case IBSAVE:
   					if(sheetObj.id == "sheet1") 
   					{
   						var sel_code=sheetObj.GetCellValue(selrow,"cntr_tpsz_cd");
   						var cur_code="";
   						sheetObj.SetWaitImageVisible(0);
   						ComOpenWait(true);	   						
   						formObj.f_cmd.value=MULTI;
   						if(sheetObj.DoSave("EES_CIM_2100GS.do", FormQueryString(formObj)))
   						{
   	   						//retrieving in case of successful saving
   	   						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
   	   		                for(var i=1; i<=sheetObj.RowCount(); i++)
   	   		                {
   	   		                	cur_code=sheetObj.GetCellValue(i,"cntr_tpsz_cd");
   	   		   	            	if(sel_code == cur_code)
   	   		   	            	{
   	   		   	            		sheetObj.SelectCell(i, 3, true);
   	   		   	            		ComOpenWait(false);
   	   		   	            		return;
   	   		   	            	}
   	   		                }		// End for
   						}
   						ComOpenWait(false);
   					}
   			break;
   		 	case IBDELETE:
   		 		ComRowHideDelete(sheetObj, "Sel");
   		 	    //retrieving in case of successful saving
//				doActionIBSheet(sheetObj,document.form,IBSEARCH);
   	   		 	sheetObj.SetSelectRow(selrow);
   		 		break;
   		 	case SEARCH09:
				if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "MST", strOfcCd) ) {
					div_ofc1.style.display="none";
					div_ofc2.style.display="none";
				}else{
					div_ofc1.style.display="";
					div_ofc2.style.display="";
				}
			break
            }
        }
        function sheet1_OnChange(sheetObj, row, col, value)
        {
        }
        function sheet1_OnSearchEnd(sheetObj, errMsg) {
        	ComOpenWait(false);
        }