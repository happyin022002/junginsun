/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0907.js
*@FileTitle  : TRO-Container Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/31
=========================================================*/
/****************************************************************************************
  EVENT CODE :	INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
				MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7
				OTHER COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * business script for esm_bkg_0907
	 */
    function esm_bkg_0907() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
    // global variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event  */
    document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         var sheetObject1=sheetObjects[0];
         //var sheetObject2 = sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Select":
					if(!validateForm(sheetObject1,formObject,"btn_Select")) return;    					
					comPopupOK();
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
            }
    	}catch(e) {
    		ComShowMessage(e.message);
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     * @param sheet_obj IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
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
        initParam(); 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    }
    /**
     * init parameter 
     */
    function initParam()
    {
    	var formObject=document.form;
    	//var opener = window.dialogArguments;
    	var opener=window.dialogArguments;
    	if (!opener)  opener=window.opener;  //이 코드 추가할것
    	if (!opener) opener=parent; //이 코드 추가할것
    	formObject.bkg_no.value=opener.document.form.bkg_no.value;   
    	formObject.io_bnd_cd.value=opener.document.form.io_bnd_cd.value;  
    }        
    /**
     * setting sheet initial values and header
     * @param sheetObj
     * @param sheetNo
     * @return
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		switch(sheetObj.id) {
			case "sheet1":      //sheet1 init
			    with(sheetObj){
		       
		      var HeadTitle=" ||Container No.|TP/SZ|MVMT|A/S|Currency|Rate|Manifested Rate|T1 Doc|VAT";
		      var headCount=ComCountHeadTitle(HeadTitle);

		      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Radio",     Hidden:0, Width:21,   Align:"Center",  ColMerge:0,   SaveName:"radio",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"io_bnd_cd" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"adv_shtg_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"trns_rev_amt",  KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"all_in_rt_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"t1_doc_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"vat_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];
		       
		      InitColumns(cols);

		      SetEditable(1);
		      SetSheetHeight(280);//80;
		            }


				break;
			}
	}
    /**
     * Sheet process handling
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
          	case IBSEARCH:      //Retrieve	              		
	          	if(!validateForm(sheetObj,formObj,sAction)) return;
	          	formObj.f_cmd.value=SEARCH;
          	
	          	sheetObj.DoSearch("ESM_BKG_0907GS.do", FormQueryString(formObj) );
	          	break;
	 		case IBSAVE:          //Save
	          	if(validateForm(sheetObj,formObj,sAction)) alert (" Save .. ");
                break;
			case IBINSERT:        //Insert
                break;
        }
    }
    /**
     * handling process for input validation
     * @param sheetObj
     * @param formObj
     * @param sAction
     * @return
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	if ("btn_Select" == sAction){              		
				var strChkRows=sheetObj.FindCheckedRow("radio");
		         if(strChkRows.length >0 ) {
		        	 strChkRows = strChkRows +"|";
		         }	
				var arrRow=strChkRows.split("|");
				if (arrRow.length <= 1)
				{
					alert("Not Selected Row.");
					return false;
				}
        	}
        }
        return true;
    }
    /**
     * handling process after ending sheet1 retrieve
     * @param sheetObj
     * @param ErrMsg
     * @return
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	if (sheetObj.SearchRows()>0) {	
    		sheetObj.SetCellBackColor(1,"factory",sheetObj.WebColor("CCFFFD"));
    	}
    }
