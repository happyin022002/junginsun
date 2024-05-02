/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_SPC_0699.js
*@FileTitle  : Korea WHF Exemption
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class Customer Code Entry : business script for Customer Code Entry 
     */
    function esm_bkg_0555() {
    	this.processButtonClick=processButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
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
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
					case "btn_save":
						doActionIBSheet(sheetObject,document.form,IBSAVE);
					break;
					case "btn_new":
						sheetObject.SetCellValue(1, "sheet1_registno","",0);
						for (var i=1; i <= sheetObject.RowCount(); i++) {
							sheetObject.SetCellValue(i, "sheet1_kr_whf_expt_appl_flg","N",0);
							sheetObject.SetCellValue(i, "sheet1_radio",0,0);
						}
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
        //no support[implemented common]CLT sheetObjects[0].SelectHighLight=false; 
        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
        initControl();
    }
    /**
     * setting event
     */
    function initControl() {
    	var formObject=document.form;
    	//axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
    }
    /**
     * when inputting search condition
     */
//    function obj_KeyUp() {
//    	var formObject=document.form;
//    	var srcName=ComGetEvent("name");
//    	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//    	var srcValue=window.event.srcElement.getAttribute("value");
//    	if (ComChkLen(srcValue, srcMaxLength) == "2") {
//    		ComSetNextFocus();
//    	}
//    }
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetId=sheetObj.id;
        switch(sheetId) {
            case "sheet1":
            	with(sheetObj){
		              (7, 0, 0, true);
		              var HeadTitle=" | | | | |사업자등록번호";
		              var prefix='sheet1_';
		
		              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, DataRowMerge:1 } );
		
		              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		              var headers = [ { Text:HeadTitle, Align:"Center"} ];
		              InitHeaders(headers, info);
		
		              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"kr_whf_expt_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Left",    ColMerge:0,   SaveName:prefix+"kr_whf_expt_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"kr_whf_expt_appl_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"CheckBox",  Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"radio",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		                     {Type:"PopupEdit", Hidden:0, Width:50,   Align:"Left",    ColMerge:1,   SaveName:prefix+"registno",             KeyField:0,   CalcLogic:"",   Format:"SaupNo",      PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
		                     {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"bkg_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		              InitColumns(cols);
		              SetEditable(1);
		              SetSheetHeight(265);
            	}
           break;
            case "sheet2":
            	with(sheetObj){
                var HeadTitle=" | |Container Number|Container Number|SOC|";
                var headCount=ComCountHeadTitle(HeadTitle);
                (headCount, 0, 0, true);
                var prefix2='sheet2_';

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cntr_wfg_expt_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:150,  Align:"Center",  ColMerge:1,   SaveName:prefix2+"cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"soc",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix2+"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetSheetHeight(265);
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
					var aryPrefix=new Array("sheet1_", "sheet2_" ); //prefix array
					var sXml=sheetObj.GetSearchData("ESM_BKG_0699GS.do", FormQueryString(formObj)  + "&" + ComGetPrefixParam(aryPrefix));
					var arrXml=sXml.split("|$$|");
					if (arrXml.length > 0) sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
					if (arrXml.length > 0) sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );

					if (ComGetEtcData(arrXml[0],"shipper_name")) {
						formObj.shipper_name.value=ComGetEtcData(arrXml[0],"shipper_name");
						formObj.export_ref.value=ComGetEtcData(arrXml[0],"export_ref");
						formObj.cstms_desc.value=ComGetEtcData(arrXml[0],"cstms_desc");
						formObj.bkg_cgo_tp_cd.value=ComGetEtcData(arrXml[0],"bkg_cgo_tp_cd");
						sheetObjects[0].SetCellValue(1,5,ComGetEtcData(arrXml[0],"whf_shpr_rgst_no"),0);
						var temp='';
						for( var i=0; i< sheetObjects[0].RowCount(); i++ ){
							sheetObjects[0].SetCellValue(i+2, 5,"     ",0);
							sheetObjects[0].SetCellValue(i+1, 6,formObj.bkg_no.value ,0);
							sheetObjects[0].SetCellValue(i+1, 0,"",0);
							temp=sheetObjects[0].GetCellValue( i+1, 'sheet1_kr_whf_expt_appl_flg' );
							if( 'Y' == temp ) {
								sheetObjects[0].SetCellValue( i+1, 'sheet1_radio' ,1 ,0);
								sheetObjects[0].SetCellValue( i+1, 'sheet1_ibflag' ,"" ,0);
							}
						}
						// can't edit by merging registno column
						sheetObjects[0].SetMergeCell(2, 5, 7, 1);
					}
					if( ComGetEtcData(arrXml[0],"bdr") == 'Y' && ComGetEtcData(arrXml[0],"ca") == 'Y')
					{
						ComBtnDisable("btn_save");
					}
      		  }
              break;
          case IBSAVE:        //
        	  if(validateForm(sheetObj,formObj,sAction)){
	              formObj.f_cmd.value=MULTI;
	              var aryPrefix=new Array("sheet1_", "sheet2_");
	    	      var sParam="";
	    	      if (sheetObjects[0].IsDataModified()== true ) {
	    	    	  sParam="sheet1_ibflag=U&sheet1_bkg_no=" + formObj.bkg_no.value;
	    	    	  var row=sheetObjects[0].FindText("sheet1_kr_whf_expt_appl_flg", "Y");
	    	    	  if ( row > 0) {
						sParam=sParam + "&sheet1_kr_whf_expt_cd=" + sheetObjects[0].GetCellValue(row, "sheet1_kr_whf_expt_cd");
					if (sheetObjects[0].GetCellValue(row, "sheet1_kr_whf_expt_cd") == "S") {
						sParam=sParam + "&sheet1_registno=" + sheetObjects[0].GetCellValue(row, "sheet1_registno");
	    	    		  }
	    	    	  }
	    	    	  else {
	    	    		  sParam=sParam + "&sheet1_kr_whf_expt_cd=";
	    	    	  }
	    	      }
	    	      sParam += "&" + FormQueryString(formObj);
                  var sheet1=sheetObjects[0].GetSaveString();
                  var sheet2=sheetObjects[1].GetSaveString();
                  if(sheet1 != "") {
                      sParam += "&" +  sheet1 + "&" + sheet2
                  } else {
                      sParam += "&" + sheet2
                  }
                  var SaveXml=sheetObj.GetSaveData("ESM_BKG_0699GS.do", sParam);
                  sheetObj.LoadSaveData(SaveXml);
        	  }
   			  break;
          case IBINSERT:      // 
        	  break;
        }
	}
    /**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch (sAction) {
		case IBSEARCH: // 
			return true;
			break;
		case IBSAVE: // 
			if (sheetObjects[0].IsDataModified()== false
					&& sheetObjects[1].IsDataModified()== false) {
				ComShowCodeMessage('BKG00233');
				return false;
			}
			return true;
			break;
		}
	}
    function sheet1_OnChange(SheetObj, Row, Col, Value){
    	var exceptCdChanged=false;
    	if (SheetObj.ColSaveName(Col) == "sheet1_radio") {
    		exceptCdChanged=true;
    	}
    	
        for (var i=0 + sheetObjects[0].HeaderRows(); i < sheetObjects[0].RowCount()+ sheetObjects[0].HeaderRows(); i++){
//        	sheetObjects[0].CellValue2(i, "sheet1_ibflag") = "";
        	if (exceptCdChanged) {
        		if (Row == i)
        		{
        			if( sheetObjects[0].GetCellValue(i, "sheet1_kr_whf_expt_appl_flg") == "Y" )
        			{
        				sheetObjects[0].SetCellValue(i, "sheet1_radio","0",0);
                		sheetObjects[0].SetCellValue(i, "sheet1_kr_whf_expt_appl_flg","N",0);
        			}
        			else
        			{
        				sheetObjects[0].SetCellValue(i, "sheet1_radio","1",0);
                		sheetObjects[0].SetCellValue(i, "sheet1_kr_whf_expt_appl_flg","Y",0);
                		if (sheetObjects[0].GetCellValue(i, "sheet1_kr_whf_expt_cd") == "S") {
                			if (sheetObjects[0].GetCellValue(i, "sheet1_registno") == "") {
                    			sheet1_OnPopupClick(SheetObj, i, sheetObjects[0].SaveNameCol("sheet1_registno"));
                    		}
                    	}
                    	else {
                    		sheetObjects[0].SetCellValue(1, "sheet1_registno","",0);
                    	}
        			}
        		}
        		else
        		{
	        		sheetObjects[0].SetCellValue(i, "sheet1_radio","0",0);
	        		sheetObjects[0].SetCellValue(i, "sheet1_kr_whf_expt_appl_flg","N",0);
        		}
        	}
        }
        
    }
    
    function sheet1_OnPopupClick(SheetObj, Row, Col){
    	if (Row == 1 && SheetObj.ColSaveName(Col) == "sheet1_registno") {
    		
			var _Width='650';
			var _Height='450';
			var param="country=KR&popup=y&frow=1&fcol=";
			var pgmNo="&pgmNo=ESM_BKG_0738";
			var url="ESM_BKG_0738.do?" + param + pgmNo;;
    		rValue=ComOpenPopup(url, _Width, _Height, 'getRgstNo', '0,0', true, true, 0, '', 1);    		
    		
    	}
    }
    
    function getRgstNo(rValue){ 
		sheetObjects[0].SetCellValue(1, 5, rValue.vRgstNo.substring(0,3) + "-" + rValue.vRgstNo.substring(3,5) + "-" + rValue.vRgstNo.substring(5));
    }
    
