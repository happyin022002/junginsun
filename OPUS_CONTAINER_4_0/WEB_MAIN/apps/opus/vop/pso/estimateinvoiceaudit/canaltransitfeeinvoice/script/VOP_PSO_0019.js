/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_pso_0019.js
*@FileTitle  : Requested Actual Invoice
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class vop_pso_0019 : business script for vop_pso_0019
     */
    function vop_pso_0019() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
	        switch(srcName) {
		        case "btn_sdr":
					var sUrl="http://www.imf.org/external/np/fin/data/param_rms_mth.aspx";
					var WIDTH_POPUP=850;
					var HEIGHT_POPUP=600;
					var sFeatures="toolbar=no,location=no,status=no,menubar=no,scrollbars=yes,resizable=no,alwaysRaised,dependent,titlebar=no,width=" + WIDTH_POPUP + ",height=" + HEIGHT_POPUP;
					ComOpenWindow(sUrl, "EXCHANGE_RATE", sFeatures, false);		        	
		        	break;
	            case "btn_Close":
  ComClosePopup(); 
	            	break;
	            case "btn_DownExcel": 	            	
	            	sheetObject1.Down2Excel({ HiddenColumn:0});
	            	break;
				case "btn_Reject":
					if(!ComShowCodeConfirm("PSO00041", "reject")){
						return;
					}
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC03);
					break;
				case "btn_ToCSR":
					ComShowMessage("Under Construction!!!");
					break;
				case "btn_Confirm":
					if(formObject.inv_no.value != ""&&formObject.inv_no.value != undefined){
						ComShowCodeMessage("PSO01001");
						break;
					}
					if(!ComShowCodeConfirm("PSO00041", "confirm")){
						return;
					}
					for(var j=sheetObject1.HeaderRows()+1 ; j<=sheetObject1.RowCount();j++)//Setting ibflag to Insert except 1st row
						sheetObject1.SetCellValue(j,0,"I",0);
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH_ASYNC01);
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
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		/*when PopUp open, Retrieving*/
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
			        
			      
			      var HeadTitle1="|Seq.|Cost\nCode|ITEM|DEBITS|Last Invoice|CREDITS|BALANCE|Remark|Tariff Amount|Diff.|Formula|Formula Value|InvNo.|ydCd|h1|h2|h3|h4|h5|ydChgNo|ydChgVerSeq|vvd|callSeq";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet1_";

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:5, DataRowMerge:1 } );

			      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lgs_cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rqst_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"last_inv",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"credits",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"balance",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"diff_rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"calc_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"Diff",                    KeyField:0,   CalcLogic:"|sheet1_credits|-|sheet1_calc_amt|",Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"sys_xpr_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:prefix+"dflt_xpr_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"suz_net_tong_wgt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"locl_xch_rt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"scg_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"tr_vol_val",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"inv_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_ver_seq",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"call_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);

			      SetEditable(1);
			      SetImageList(0,"img/btng_detail.gif");//Detail
			      SetCountPosition(0);
			      SetSheetHeight(262);						
//			      InitDataValid(0, prefix+"diff_rmk", vtEngOther, "0123456789~!@#$%^&*()_+|{}/-,.'\" ?<>");
			      SetColProperty(0 ,prefix+"diff_rmk", {AcceptKeys:"E|N|[.-/,() &]"});
			      }
				    break;
				case "sheet2":
				    with(sheetObj){
			        
			     
			      var HeadTitle1="|Seq.|ITEM|CREDITS|Last Invoice|DEBITS|BALANCE";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet2_";

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:4, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"lgs_cost_full_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"CREDITS",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"LastInvoice",             KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:prefix+"rqst_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
			             {Type:"AutoSum",   Hidden:0, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"BALANCE",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 } ];
			       
			      InitColumns(cols);

			      SetEditable(1);
			      SetImageList(0,"img/btng_detail.gif");//Detail
			      SetCountPosition(0);
			      SetRowHidden(0, 1);
			      SetSheetHeight(62);
			            }


						break;
        }
    }
     // handling sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        switch(sAction) {
        	case IBSEARCH:      //Retrieving
        		formObj.f_cmd.value=SEARCH;
           		if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "sheet1"){
						ComOpenWait(true);
    						
						sheetObj.DoSearch("VOP_PSO_0019GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"), {Sync:2});
   						//if(formObj.sts.value == "10"){
   							var row=sheetObj.FindText("sheet1_inv_no", "-INV-", 0, 2); //Finding INV_NO
   							if(row > 0 )
   								formObj.inv_no.value=sheetObj.GetCellValue(row, "sheet1_inv_no");
   						//}
   						var row=0;
   						for(i=sheetObj.HeaderRows(); i<sheetObj.RowCount()+sheetObj.HeaderRows(); i++){
   							if(sheetObj.GetCellValue(i, "sheet1_yd_cd") != ""){
   								row=i;
   								break;
   							}
   						}
formObj.scnt.value=sheetObj.GetCellValue(row, "sheet1_suz_net_tong_wgt");
formObj.sdr.value=sheetObj.GetCellValue(row, "sheet1_locl_xch_rt");
formObj.limit.value=sheetObj.GetCellValue(row, "sheet1_scg_rt_amt");
formObj.tier.value=sheetObj.GetCellValue(row, "sheet1_tr_vol_val");
formObj.inv_rgst_no.value=sheetObj.GetCellValue(row, "sheet1_inv_rgst_no");
						ComOpenWait(false);
					}
           		}
				break;
            case IBSEARCH_ASYNC01: //Save btn click
            	formObj.f_cmd.value=MULTI01;
              	if(validateForm(sheetObj,formObj,sAction))
					if ( sheetObj.id == "sheet1"){
						var SaveStr=ComGetSaveString(sheetObj);
						
						var sXml=sheetObj.GetSaveData("VOP_PSO_0019GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
						var etcVal=ComGetEtcData(sXml, "invoiceNo");
						if(etcVal==undefined || etcVal==null || etcVal==""){
							//return;
							
							sheetObj.LoadSaveData(sXml);
						}
						else{
							formObj.inv_no.value=etcVal;//Setting InvoiceNo
							ComShowCodeMessage("PSO01003");
  ComClosePopup(); 
							var opener=window.dialogArguments;
							opener.setInvStatus("A", formObj.row.value, formObj.col.value);
						}
					}	
              	break;
            case IBSEARCH_ASYNC03: //Reject btn click
              formObj.f_cmd.value=MODIFY;
              if(validateForm(sheetObj,formObj,sAction))
            	  if ( sheetObj.id == "sheet1"){
            		  var SaveStr=ComGetSaveString(sheetObj);
           		  
            		  var sXml=sheetObj.GetSaveData("VOP_PSO_0019GS.do",SaveStr + "&" + FormQueryString(formObj)+ "&" + ComGetPrefixParam("sheet1_"));
            		  var etcVal=ComGetEtcData(sXml, "calcelResult");
            		  if(etcVal=="OK"){
            			  ComShowCodeMessage("PSO01002");
            			  ComClosePopup(); 
            			  var opener=window.dialogArguments;
            			  opener.setInvStatus("R", formObj.row.value, formObj.col.value);
            		  }
            		  else
            			  ComShowMessage("The process failed");
            	  }	
                break;
        }
    }
    /**
     * handling process for input validation
     */
     function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//                if (!isNumber(formObj.iPage)) {
//                    return false;
//                }
        }
        return true;
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
		with(sheetObj)
		{
			for (var i=1; i <= LastRow(); i ++)
			{
if (GetCellValue(i, "Diff") > 0)
					
	SetCellFontColor(i, "Diff","#FF0000");// RED
else if (GetCellValue(i, "Diff") < 0)
				
	SetCellFontColor(i, "Diff","#0000FF");// BLUE
				//--> Changing cost code which length is 6
	if(GetCellValue(i, "sheet1_lgs_cost_cd").length < 6 ) {
					//Coloring back color to gray
	if(GetCellValue(i, "sheet1_lgs_cost_full_nm") == "TTL Amount:")
						sheetObj.SetRowBackColor(i,"#FFC8C8");
					else
						sheetObj.SetRowBackColor(i,"#C8FFC8");
				}
			}
			SetRowHidden(LastRow(),1);//Hidden Sum Row
		}
	}
