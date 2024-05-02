/*=========================================================
* *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ESM_BKG_0496.js
*@FileTitle : T/S Remain Status by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/10
=========================================================*/
 /****************************************************************************************
  	Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	var sheetObjects=new Array();
	var sheetCnt=0;
	var prefix1="sheet1_";
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	function processButtonClick(){
	     var sheetObject=sheetObjects[0];
	     var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
				case "btn_retrieve":  
					if (validateForm(sheetObject,formObject,IBSEARCH)) {
						formObject.cnmv_sts_cds.value="";
						formObject.cntr_tpsz_cds.value="";
						if (!ComIsEmpty(formObject.cnmv_sts_cd1.value)){
							formObject.cnmv_sts_cds.value=formObject.cnmv_sts_cd1.value+"|";
						}
						if (!ComIsEmpty(formObject.cnmv_sts_cd2.value)){
							formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd2.value+"|";
						}
						if (!ComIsEmpty(formObject.cnmv_sts_cd3.value)){
							formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd3.value+"|";
						}
						if (ComIsEmpty(formObject.cnmv_sts_cd1.value) && ComIsEmpty(formObject.cnmv_sts_cd2.value)
							&& ComIsEmpty(formObject.cnmv_sts_cd3.value)){
							formObject.cnmv_sts_cds.value="TS|TN|EN|";
						}
						if (!ComIsEmpty(formObject.cntr_tpsz_cd1.value)){
							formObject.cntr_tpsz_cds.value=formObject.cntr_tpsz_cd1.value+"|";
						}
						if (!ComIsEmpty(formObject.cntr_tpsz_cd2.value)){
							formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd2.value+"|";
						}
						if (!ComIsEmpty(formObject.cntr_tpsz_cd3.value)){
							formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd3.value+"|";
						}
						if (!ComIsEmpty(formObject.cntr_tpsz_cd4.value)){
							formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd4.value+"|";
						}
						if (!ComIsEmpty(formObject.cntr_tpsz_cd5.value)){
							formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd5.value+"|";
						}
						
						doActionIBSheet(sheetObject,document.form,IBSEARCH);
					}
				break; 
				case "btn_downExcel":
					 doActionIBSheet(sheetObject,document.form,IBDOWNEXCEL);
				break; 
				case "btn_VVDAssign": 
				    var param="?pgmNo=ESM_BKG_0387&relay="+formObject.loc_cd.value+formObject.loc_yd_cd.value;
					param+="&etbFrom="+formObject.vps_etb_dt.value+"&etbTo="+formObject.vps_etd_dt.value;
					param+="&nextVvd="+ComGetObjValue(formObject.next_vvd);
					param+="&pgmNo=ESM_BKG_0387";
					if (ComChkLen(formObject.loc_cd,5)!=2){
						ComShowCodeMessage("BKG00461");
					}else{ 
						ComOpenWindowCenter("/opuscntr/ESM_BKG_0387Pop.do"+param, "myWin", 1010,700, true);
					}
				break;
				case "btn_loc_cd":
					var param="?loc_cd="+formObject.loc_cd.value; 
				    param+="&pgmNo=COM_ENS_061";
			        ComOpenPopup('/opuscntr/COM_ENS_061.do' + param, 800, 550, 'getCOM_ENS_061', '1,0,1,1,1,1,1,1,1,1,1,1', true);
				break;
				case "btns_calendar":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.vps_etb_dt, formObject.vps_etd_dt,'yyyy-MM-dd');
				break;
				case "btn_yard_sum":
					formObject.cnmv_sts_cds.value="";
					formObject.cntr_tpsz_cds.value="";
					if (!ComIsEmpty(formObject.cnmv_sts_cd1.value)){
						formObject.cnmv_sts_cds.value=formObject.cnmv_sts_cd1.value+"|";
					}
					if (!ComIsEmpty(formObject.cnmv_sts_cd2.value)){
						formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd2.value+"|";
					}
					if (!ComIsEmpty(formObject.cnmv_sts_cd3.value)){
						formObject.cnmv_sts_cds.value+=formObject.cnmv_sts_cd3.value+"|";
					}
					if (ComIsEmpty(formObject.cnmv_sts_cd1.value) && ComIsEmpty(formObject.cnmv_sts_cd2.value)
							&& ComIsEmpty(formObject.cnmv_sts_cd3.value)){
							formObject.cnmv_sts_cds.value="TS|TN|EN|";
						}
					if (!ComIsEmpty(formObject.cntr_tpsz_cd1.value)){
						formObject.cntr_tpsz_cds.value=formObject.cntr_tpsz_cd1.value+"|";
					}
					if (!ComIsEmpty(formObject.cntr_tpsz_cd2.value)){
						formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd2.value+"|";
					}
					if (!ComIsEmpty(formObject.cntr_tpsz_cd3.value)){
						formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd3.value+"|";
					}
					if (!ComIsEmpty(formObject.cntr_tpsz_cd4.value)){
						formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd4.value+"|";
					}
					if (!ComIsEmpty(formObject.cntr_tpsz_cd5.value)){
						formObject.cntr_tpsz_cds.value+=formObject.cntr_tpsz_cd5.value+"|";
					}	
					var nextvvd="";
					if (formObject.next_vvd[0].checked){
						nextvvd=formObject.next_vvd[0].value;
					}else if (formObject.next_vvd[1].checked){
						nextvvd=formObject.next_vvd[1].value;
					}else if (formObject.next_vvd[2].checked){
						nextvvd=formObject.next_vvd[2].value;
					}
					var param="?loc_cd="+formObject.loc_cd.value+"&loc_yd_cd="+formObject.loc_yd_cd.value+"&date="+ComGetNowInfo()
						+"&vps_etb_dt="+formObject.vps_etb_dt.value+"&vps_etd_dt="+formObject.vps_etd_dt.value
					    +"&cnmv_sts_cds="+formObject.cnmv_sts_cds.value+"&cntr_tpsz_cds="+formObject.cntr_tpsz_cds.value
						+"&vps_eta_dt="+formObject.vps_eta_dt.value+"&next_vvd="+nextvvd; 
					param+="&pgmNo=ESM_BKG_0924";
					if (ComChkLen(ComTrim(formObject.loc_cd),5)!=2){ 
						ComShowCodeMessage("BKG00461");
					}else if(ComChkLen(ComTrim(formObject.loc_yd_cd),1)==2){ //inputed 1 digit 
						ComShowCodeMessage("BKG00269");
					}else{
						ComOpenWindowCenter("/opuscntr/ESM_BKG_0924.do"+param, "myWin", 900,420, true);
					}
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
     *  adding process for list in case of needing batch processing with other items 
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
		//initDate(document.form);  
    }
    
    
    /**
     * setting sheet initial values and header
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){
		        
				var HeadTitle1="|Seq.|Yard CD|Container No.|T/S|F/M|MV|Event Date|B/L No.|POL|POD|Next\nPort|Former VVD|Lane|Next VVD|Lane|ETD Date|Special|S/Days|Shipper|Consignee";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix1+"ibflag" },
		             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_tpsz_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"fm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:28,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"act",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"next_port",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"frmr_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"frmr_lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"next_vvd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"next_lane",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"etd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"special",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Int",      Hidden:0, Width:55,   Align:"Right",   ColMerge:0,   SaveName:prefix1+"stay_day",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:240,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"sh_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"cn_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
		       
			      InitColumns(cols);

			      SetEditable(1);
			      SetEllipsis(1);//"..."
			      SetSheetHeight(455);
		    }
			break;
        }
    }
    
    
    
    //handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
		var arrPreFix=new Array("sheet1_");
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:   
				formObj.f_cmd.value=SEARCH; 
				//alert("1");
				var sXml=sheetObj.GetSearchData("ESM_BKG_0496GS.do", FormQueryString(formObj)+ "&" + ComGetPrefixParam(arrPreFix));
				//alert("2");
				//sheetObj.RenderSheet(0);
				//alert("3");
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//alert("4");
				//sheetObj.RenderSheet(1);
				//alert("1");
				formObj.cntr_qty.value=ComAddComma(sheetObj.RowCount());
			break;  
			case IBDOWNEXCEL:   
				if (sheetObj.RowCount()== 0 ) {
			   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
			   	    return;
			   	} else {
			   		sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
			   	}
				
			break; 
        }
    }
    
    
     /**
      *  initialize date input form
      */
     function initDate(formObj){
    	 with(formObj){
    		 vps_etb_dt.value=ComGetNowInfo();
    		 vps_etd_dt.value=ComGetNowInfo();
    	 }
     }
     
     
	 /**
     * registering initial event 
     */
    function initControl() {
    	var formObject=document.form;
 	    /*axon_event.addListenerFormat('keypress','bkg0496_keypress',formObject);  
	    axon_event.addListenerForm  ('beforedeactivate', 'bkg0496_obj_deactivate',  formObject); //- focus out
	    axon_event.addListenerFormat('beforeactivate',   'bkg0496_obj_activate',    formObject); //- focus in
*/    }        
    
    
    /*
	 * handling Activate Event
	 */
	function bkg0496_obj_activate(){
    	switch(event.srcElement.name){
	    	case "vps_etb_dt":
	    		ComClearSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComClearSeparator(event.srcElement);
    			break; 
    		default:
    			break;
    	}
    }
	
	
	/*
	 * handling Deactivate Event
	 */
    function bkg0496_obj_deactivate(){ 
    	switch(event.srcElement.name){ 
	    	case "vps_etb_dt":
	    		ComAddSeparator(event.srcElement);
    			break;
	    	case "vps_etd_dt":
	    		ComAddSeparator(event.srcElement);
    			break; 
    		default:
    			break; 
    	}
    }
    
    
	 /*
	 * Handling KeyPress Event
	 */
    function bkg0496_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat; 
	    switch(obj.dataformat){ 
	        case "num": 
	        	ComKeyOnlyNumber(event.srcElement);
	            break;	 
			 case "engup":
                if(obj.name=="cntr_tpsz_cd1" || obj.name=="cntr_tpsz_cd2" 
				 || obj.name=="cntr_tpsz_cd3" ||obj.name=="cntr_tpsz_cd4" 
				 ||obj.name=="cntr_tpsz_cd5" || obj.name=="loc_yd_cd")  
				 ComKeyOnlyAlphabet('uppernum') 
				 else ComKeyOnlyAlphabet('upper');
	            break; 
	    }
	}    
    
    
	 /*
	 * function for get Location info
	 */
	function getCOM_ENS_061(rowArray){
		var formObject=document.form;
		var colArray=rowArray[0]; 
		formObject.loc_cd.value=colArray[3].substring(0,5);
        formObject.loc_yd_cd.value=colArray[3].substring(5); 
	}
	
	
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with(formObj){
        	switch (sAction) {
        		case IBSEARCH: {
					if (ComChkLen(ComTrim(loc_cd),5)!=2){ 
						ComShowCodeMessage("BKG00461");
						return false;
					}else if(ComChkLen(ComTrim(loc_yd_cd),1)==2){ //in case of input 1 digit
						ComShowCodeMessage("BKG00269");
						return false;
					}else if(ComIsEmpty(vps_etb_dt)&&!ComIsEmpty(vps_etd_dt)) {
						ComShowCodeMessage("BKG00156");  //Invalid duration
						vps_etb_dt.focus();
						return false;
					}else if(!ComIsEmpty(vps_etb_dt)&&ComIsEmpty(vps_etd_dt)) {
						ComShowCodeMessage("BKG00156");  //Invalid duration
						vps_etd_dt.focus();
						return false;
					}else if(!ComIsEmpty(vps_etb_dt)&&!ComIsEmpty(vps_etd_dt)&&ComGetDaysBetween(vps_etb_dt.value,vps_etd_dt.value)>30){
						ComShowCodeMessage("BKG00756", "Duration", "30Days");
						vps_etb_dt.focus();
						return false;
					}
					break;
        		}
        	}
        }
        return true;
    }
    
    
	/*
	* select same B/L in case of checkbox selected
	*/
	function sheet1_OnChange(sheetObj,Row,Col,Value){ 
		CheckSame(sheetObj,Row,Col,Value,prefix1+"del_chk",prefix1+"bl_no");
	} 
	
	
	/*
    function CheckSame(sheetObj,Row,Col,Value,ChkCol,SameCol){
		if (sheetObj.ColSaveName(Col)==ChkCol){
var sblNO=sheetObj.GetCellValue(Row,SameCol);
for (i=1;i<sheetObj.Rows;i++ ){
if (sblNO == sheetObj.GetCellValue(i,SameCol)){
					  sheetObj.SetCellValue(i,ChkCol,Value,0);
			     }else{
					 sheetObj.SetCellValue(i,ChkCol,0,0);
				 }
			 }
		}
	}*/
