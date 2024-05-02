/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0560.js
*@FileTitle  : Customer Code Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    // Common global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
         /* */
		 var sheetObject1=sheetObjects[0];
         /*******************************************************/
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
            	case "btn_downexcel":
            		doActionIBSheet(sheetObject1,document.form,IBDOWNEXCEL);
            	break;
            	case "btn_add":
					sheetObject1.DataInsert(-1);
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
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * setting event
     */
    function initControl() {
    	var formObject=document.form;
        axon_event.addListener ('keydown', 'ComKeyEnter', formObject);
    }
    /**
	 * onkeypress event
	 */
    function obj_keypress(){
		switch(event.srcElement.dataformat){
	    	case "int":
		        ComKeyOnlyNumber(event.srcElement);
		        break;
	        case "float":
	            ComKeyOnlyNumber(event.srcElement, ".");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
	            break;
	        case "engdn":
	            ComKeyOnlyAlphabet('lower');
	            break;
	        case "engup":
	            ComKeyOnlyAlphabet('upper');
	            break;
	        default:
	            ComKeyOnlyNumber(event.srcElement);
	    }
	}        
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
    	var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
		    case "sheet1":      //sheet1 init
		            with(sheetObj){
						var HeadTitle1="|Sel.|CNTR/BULK|PORT|Bound|D/C|Amount|Amount|Amount|Rate|Rate|Rate";
						var HeadTitle2="|Sel.|CNTR/BULK|PORT|Bound|D/C|20'|40'|45'|20'|40'|45'";
						var prefix='sheet1_';
				
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					    var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
					    InitHeaders(headers, info);
					
					      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Chk" },
					             {Type:"Combo",     Hidden:0, Width:220,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_blk_div_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
					             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"io_bnd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
					             {Type:"Combo",     Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dc_rto_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
					             {Type:"Int",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"teu_prc",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
					             {Type:"Int",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"feu_prc",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
					             {Type:"Int",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hc_prc",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:22 },
					             {Type:"Float",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"teu_amt_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					             {Type:"Float",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"feu_amt_rt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					             {Type:"Float",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hc_amt_rt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 } ];
					       
					      InitColumns(cols);
					
					      SetEditable(1);
					      //conversion of function[check again] 					InitDataValid(0, prefix +"port_cd", vtEngUpOnly);
//					      SetSheetHeight(420);
					      resizeSheet();
					      SetColProperty(prefix+"cntr_blk_div_cd", {ComboText:"CNTR|BULK", ComboCode:"C|B"} );
					      SetColProperty(prefix+"io_bnd_cd", {ComboText:"II|OO", ComboCode:"I|O"} );
					      SetColProperty(prefix+"dc_rto_no", {ComboText:"0%|20%|30%|50%|80%|100%|", ComboCode:"0|1|7|2|3|4"} );
					      FitColWidth("2|5|15|10|10|10|8|8|8|8|8|8");
					   }


		        break;
         }
     }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:      //retrieve
        		if( validateForm(sheetObj,formObj,sAction) ){
					formObj.f_cmd.value=SEARCH;   
					sheetObj.DoSearch("ESM_BKG_0560GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
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
	    	        sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");
 	    	        var SaveXml=sheetObj.GetSaveData("ESM_BKG_0560GS.do", sParam);
 	    	        sheetObj.LoadSaveData(SaveXml);
				}    
    	    break;
			case IBDELETE:      // 
				var checked=0;
				for (var i=2 ; i <= sheetObj.RowCount()+1 ; i++){
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
					sheetObjects[0].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
				else
					ComShowCodeMessage('BKG00389');
			break;
        }
    }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
     	switch (sAction) {
	 		case IBSEARCH: // 
	 			if (formObj.port_cd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00887', 'Port');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
	 		case IBSAVE: // 
	 			for(var i=2; i<=sheetObj.RowCount()+ 1 ; i++){
	 				if( sheetObj.GetCellValue(i,0) == 'I' ){
	 					if( formObj.port_cd.value == '' || sheetObj.GetCellValue(i,3) == '' ){
	 						ComShowCodeMessage('BKG00104');
	 		 				return false;
	 					} 
	 				}
	 			}
	 			return true;
	 		break;
	 		case IBDELETE: // 
	 			if (formObj.port_cd.value == "" ) 
	 			{
	 				ComShowCodeMessage('BKG00266');
	 				formObj.port_cd.focus();
	 				return false;
	 			}
	 			return true;
	 		break;
     	}
     }
     
     function resizeSheet(){
         ComResizeSheet(sheetObjects[0]);
     } 
