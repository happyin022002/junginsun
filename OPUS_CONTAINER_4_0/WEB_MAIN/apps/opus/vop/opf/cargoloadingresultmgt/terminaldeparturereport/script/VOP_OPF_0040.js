/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_0040.js
*@FileTitle  : Re Handle Reseon CodeHelp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------For JSDoc ------------------*/
    /**
	 * @extends
	 * @class vop_opf_0037 : vop_opf_0036 business script for
	 */
// common global variables
var sheetObjects=new Array();
var sheetCnt=0;
var firstCode="";
var secondCode="";
//var opener=window.dialogArguments;
//if (!opener)  opener=window.opener;  //이 코드 추가할것
//if (!opener) opener=parent; //이 코드 추가할것
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         　
        var sheetObject1=sheetObjects[0];   // t1sheet1
         /** **************************************************** */
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_I":
								break;
						case "btn_C":
								break;
						case "btn_OK":
								if(!opener) {
									opener=parent;
								}
								var openerSheet=opener.t6frame.t6sheet1;
								with(openerSheet){
									var prefix="t6sheet1_";
									var party =  openerSheet.GetCellValue(openerSheet.GetSelectRow(), prefix + "party");
									if(party == "U" || party == "T"){
										party = "";
									}
									openerSheet.SetCellValue(openerSheet.GetSelectRow(), prefix + "shift_rsn",firstCode + "" + secondCode + party);
								}
								ComClosePopup(); 
								break;
						case "btn_Close":
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
		if(document.form.shift_rsn.value != ""){
			firstCode=document.form.shift_rsn.value.substring(0, 1);
			secondCode=document.form.shift_rsn.value.substring(1);
		}
		initDefaultSheet(sheetObjects[0], document.form);
		doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
		// Sheet1 Default Data Setting..
    }
    /**
	 * Sheet1 Default Data Setting. setting data in case of loading page on
	 * browser
	 */
    function initDefaultSheet(sheetObj, formObj){
    	var prefix="sheet1_";
    	sheetObj.DataInsert();
    	sheetObj.DataInsert();
    	sheetObj.SetCellText(1, prefix+"rstwg_rsn_cd" ,"S");
    	sheetObj.SetCellText(1, prefix+"rstwg_rsn_cd_full_desc" ,"Restow cell to cell");
    	sheetObj.SetCellText(2, prefix+"rstwg_rsn_cd" ,"D");
    	sheetObj.SetCellText(2, prefix+"rstwg_rsn_cd_full_desc" ,"Restow via quay");
		// initial setting
		if(firstCode == ""){
			sheetObj.SetCellValue(1, "sheet1_rstwg_sel","1");
			firstCode=sheetObj.GetCellValue(1, prefix + "rstwg_rsn_cd");
			sheetObj.SetSelectRow(sheetObj.HeaderRows());
		}else{
			sheetObj.SetSelectRow((firstCode == "S" ? sheetObj.HeaderRows(): sheetObj.HeaderRows()+ 1));
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet1_rstwg_sel","1");
		}
    }
  /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
	    with(sheetObj){
	        
	      //style.width=mainTable[0].clientWidth;
	      // no support[check again]CLT if (location.hostname != "")
			// InitHostInfo(location.hostname, location.port, page_path);
	    	
     	  var HeadTitle1="";	
	      if(sheetID == "sheet2"){
	    	  HeadTitle1="|Code|Account and Reason|Select";  
	      }else{
	    	  HeadTitle1="|Code|Shifting Method|Select";
	      }
	      
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      var prefix=sheetID + "_";

	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibFlag" },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rstwg_rsn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"rstwg_rsn_cd_full_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Radio",     Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rstwg_sel",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);

	      SetEditable(1);
//	      SetCountPosition(0);
	      SetSheetHeight(342);

	      }
    }
    
	function sheet2_OnSearchEnd(sheetObj, ErrMsg){
		if(sheetObj.RowCount()> 0){
			if(secondCode == ""){
				sheetObj.SetCellValue(1, "sheet2_rstwg_sel","1");
				secondCode=sheetObj.GetCellValue(1, "sheet2_rstwg_rsn_cd");
			}else{
				for(var idxRow=sheetObj.HeaderRows(); idxRow < sheetObj.LastRow(); idxRow++){
					if(sheetObj.GetCellValue(idxRow, "sheet2_rstwg_rsn_cd") == secondCode){
						sheetObj.SetSelectRow(idxRow);
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), "sheet2_rstwg_sel","1");
						break;
					}
				}
			}
		}
	}
  // handling process related Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      // Retrieve
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("VOP_OPF_0075GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_") );
				break;
			case IBSAVE:        // save
				break;
			case IBINSERT:      // Insert
				break;
        }
    }
    /**
	 * handling process for input validation
	 */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
// if (!isNumber(formObj.iPage)) {
// return false;
// }
        }
        return true;
    }
	function sheet1_OnClick(sheetObj, Row, Col){
		firstCode=sheetObj.GetCellValue(Row, "sheet1_rstwg_rsn_cd");
	}
	function sheet2_OnClick(sheetObj, Row, Col){
		secondCode=sheetObj.GetCellValue(Row, "sheet2_rstwg_rsn_cd");
	}
