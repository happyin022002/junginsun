/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0444.js
*@FileTitle : ESM_BKG-0444
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // global variable
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet1Flag=0;
    var sheet2Flag=0;
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
        /***** using extra sheet valuable if there are more 2 sheets *****/
	    var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
       /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH, "RE");
				break;
				case "btn_new":
					sheetObject1.RemoveAll();
					sheetObject2.RemoveAll();
				break;							
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel({DownCols: makeHiddenSkipCol(sheetObject1),  Merge:1});
					}    								
				break;	
				case "btn_bl":
					doActionIBSheet(sheetObject1, formObject, COMMAND01);
				break;		
				case "btn_list":
					doActionIBSheet(sheetObject1, formObject, COMMAND03);
				break;	
				case "btn_addLane":
					doActionIBSheet(sheetObject1,formObject,COMMAND04);
				break;	
				case "btn_calendar": //calendar button
			       	// can not use before searching data
			        var cal=new ComCalendarFromTo();
			        cal.select(formObject.vps_eta_start_dt,formObject.vps_eta_end_dt, 'yyyy-MM-dd');
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
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
    	axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
    	axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
        var formObject=document.form;
        if(formObject.cn_no.value != "" || formObject.vvd_no.value != "")
        {
        	if(formObject.vvd_no.value.length > 0)
        	{
        		formObject.vsl_cd.value=formObject.vvd_no.value.substring(0,4);
        		formObject.skd_voy_no.value=formObject.vvd_no.value.substring(4,8);
        		formObject.skd_dir_cd.value=formObject.vvd_no.value.substring(8);
        		formObject.vvd_number.value=formObject.vvd_no.value;
        	}
        	formObject.frm_crn_number.value=formObject.cn_no.value;
        	var sheetObject1=sheetObjects[0];
        	doActionIBSheet(sheetObject1,document.form,IBSEARCH);	
        	formObject.frm_crn_number.focus();
        }
    	formObject.vps_eta_start_dt.focus();
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
	                  var HeadTitle1="|Check|Seq.|Lane|CRN|VVD|Call Date|Vessel Name|POD|User ID|Creation Status|Created Date|eu_stf_flg";
	
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                         {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
	                         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"vvd_number",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_eta_dt",              KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cstms_decl_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_sts_cd_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_cre_dt",               KeyField:0,   CalcLogic:"",   Format:"Ymd",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"vsl_call_ref_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"eu_stf_flg",			     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
	                   
	                  InitColumns(cols);
	                  SetSheetHeight(370);
	                  SetEditable(1);
                    }
                break;
            case "sheet2":      //sheet1 init
                with(sheetObj){
	                  var HeadTitle1="|Check|Seq.|POL|POD ATD|POD|BDR|BDR DATE|Sub B/L TTL\n(Excl. Non-BDR)|Sub B/L TTL\n(Incl. Non-BDR)|";
	
	                  SetConfig( { SearchMode:2, MergeSheet:5, Page:20,  DataRowMerge:1 } );
	
	                  var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	                  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                  InitHeaders(headers, info);
	
	                  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                         {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"Chk" },
	                         {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"Seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"vps_etd_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pod",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"trnk_bdr_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trnk_auto_bdr_dt",  KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"excl_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                         {Type:"Text",      Hidden:0, Width:95,   Align:"Right",   ColMerge:1,   SaveName:"incl_count",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                   
	                  InitColumns(cols);
	                  SetCountPosition(0);
	                  
	                  SetEditable(0);
	                  SetSheetHeight(120);
                    }
                break;                  
        }
    }
  // handling of Sheet 
    var gubun="";
    function doActionIBSheet(sheetObj,formObj,sAction,gb) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      
			     if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				  }
				  sheetObj.SetWaitImageVisible(0);
				  sheetObjects[1].SetWaitImageVisible(0);
				  ComOpenWait(true);
			      sheetObjects[0].RemoveAll();
			      sheetObjects[1].RemoveAll();
				  formObj.f_cmd.value=SEARCH;
				  //sheet1Flag = 0;
				  //sheet2Flag = 0;    				   
	       	 	  formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
	       	 	  formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
	       	 	  formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);
	       	 	  gubun = gb;
	       	 	  sheetObj.DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObj)  );
			break;
			case COMMAND01:        //B/L Create
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
			    //alert(sheet1Flag);
			    formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				    			    //alert(sheetObjects[0].CellValue( sheet1Flag, 4 ));
				var vvd = sheetObjects[0].GetCellValue( sheet1Flag, "vvd_number" )
				formObj.vsl_cd.value=vvd.substring(0,4);
				formObj.skd_voy_no.value=vvd.substring(4,8);
				formObj.skd_dir_cd.value=vvd.substring(8);
				sheetObjects[1].DoSave("ESM_BKG_0444GS.do", FormQueryString(formObj) );
				
				ComOpenWait(false);
				//sheetObjects[0].RemoveAll(); 
		        //sheetObjects[1].RemoveAll();  
		        //sheet1Flag = 0;
		        //sheet2Flag = 0;
				formObj.f_cmd.value=SEARCH;   
       	 	  	formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
       	 	  	formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
       	 	  	formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);
       	 	  	sheetObjects[0].SelectCell(sheet1Flag,1);
       	 	  	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "PR");
       	 	  	//sheetObj.DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObj) );  			       
			break;
			case COMMAND02:        //CRN Cancel
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				if(formObj.vvd_number.value.length > 0)
				{
					formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
					formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
					formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);    					 
				}
		 	    formObj.f_cmd.value=REMOVE;
				if(ComShowCodeConfirm("BKG00575")){  						 
					sheetObjects[0].DoSave("ESM_BKG_0444GS.do", FormQueryString(formObj) );
				}
				ComOpenWait(false);
				//sheetObjects[0].RemoveAll(); 
		       // sheetObjects[1].RemoveAll();  
		        //sheet1Flag = 0;
		        //sheet2Flag = 0;
				formObj.f_cmd.value=SEARCH;
       	 	  	formObj.vsl_cd.value=formObj.vvd_number.value.substring(0,4);
       	 	  	formObj.skd_voy_no.value=formObj.vvd_number.value.substring(4,8);
       	 	  	formObj.skd_dir_cd.value=formObj.vvd_number.value.substring(8);
       	 	  	doActionIBSheet(sheetObjects[0], formObj, IBSEARCH, "PR");
       	 	  	//sheetObj.DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObj) );
		    break;
			case COMMAND03:        //
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				var sUrl="/opuscntr/ESM_BKG_0061_POP.do?pgmNo=ESM_BKG_0061&crn_no="+sheetObjects[0].GetCellValue( sheet1Flag, "vsl_call_ref_no" )+"&vvd_no="+sheetObjects[0].GetCellValue( sheet1Flag, "vvd_number" )+"&mainPage=N";
				ComOpenWindowCenter(sUrl, "ESM_BKG_0061", 1200, 670, false);
			break;
			case COMMAND04:
				ComOpenWindowCenter("ESM_BKG_1135.do" , "ESM_BKG_1135", 420, 440, false);
			break;		
        }
    }
    /**
     *  by the vvd information of sheet1,getting port list list information
     */
    function sheet1_OnDblClick(sheetObj, row, col) { 
    	var formObject=document.form;
    	formObject.f_cmd.value=SEARCH01;
		//ComOpenWait(true);
		formObject.frm_slan_cd.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_sts_cd_nm" );
		formObject.lane_cd.value=sheetObjects[0].GetCellValue( row, "slan_cd" );
		formObject.crn_number.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
		formObject.vsl_call_ref_no.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
    	sheetObjects[0].SetCellValue( row, "Chk" ,1,0);
    	sheetObjects[0].SetCellValue( row, "ibflag" ,"U",0);
		formObject.vsl_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(0,4);
		formObject.skd_voy_no.value=sheetObjects[0].GetCellValue( row, 5 ).substring(4,8);
		formObject.skd_dir_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(8);
		sheetObjects[1].DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObject)  );
    	sheet1Flag=row;  
    	//ComOpenWait(false);
    }
    
    
    function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
    	ComOpenWait(false);
    	if ( sheet1Flag == 0 ) {
	    	  sheet1Flag=1;
    	}
    	
	    if ( gubun == "PR" ) {
	      sheetObjects[0].SelectCell(sheet1Flag,1);
	    }
	    goDblClick(sheetObjects[0].GetSelectRow(), sheetObjects[0].GetSelectCol());
    }
    /**
     *  by the vvd information of sheet1,getting port list list information
     */
    function goDblClick(row, col) { 
    	var formObject=document.form;
    	formObject.f_cmd.value=SEARCH01;
		//sheetObj.WaitImageVisible = false;
		//ComOpenWait(true);
		formObject.frm_slan_cd.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_sts_cd_nm" );
		formObject.lane_cd.value=sheetObjects[0].GetCellValue( row, "slan_cd" );
		formObject.crn_number.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
		formObject.vsl_call_ref_no.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
    	sheetObjects[0].SetCellValue( row, "Chk" ,1,0);
    	sheetObjects[0].SetCellValue( row, "ibflag" ,"U",0);
		formObject.vsl_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(0,4);
		formObject.skd_voy_no.value=sheetObjects[0].GetCellValue( row, 5 ).substring(4,8);
		formObject.skd_dir_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(8);
		sheetObjects[1].DoSearch("ESM_BKG_0444GS.do", FormQueryString(formObject)  );
    	sheet1Flag=row;    
    	//ComOpenWait(false);
    }        
     /**
      * 
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet1_OnClick(sheetObj, row, col) { 
     	var formObject=document.form;         	 
		formObject.frm_slan_cd.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_sts_cd_nm" );
		formObject.lane_cd.value=sheetObjects[0].GetCellValue( row, "slan_cd" );
		formObject.crn_number.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
		formObject.vsl_call_ref_no.value=sheetObjects[0].GetCellValue( row, "vsl_call_ref_no" );
     	sheetObjects[0].SetCellValue( row, "Chk" ,1,0);
     	sheetObjects[0].SetCellValue( row, "ibflag" ,"U",0);
		formObject.vsl_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(0,4);
		formObject.skd_voy_no.value=sheetObjects[0].GetCellValue( row, 5 ).substring(4,8);
		formObject.skd_dir_cd.value=sheetObjects[0].GetCellValue( row, 5 ).substring(8);
     	sheet1Flag=row;        	
     }
     /**
      * 
      * @param sheetObj
      * @param row
      * @param col
      * @return
      */
     function sheet2_OnClick(sheetObj, row, col) { 
     	var formObject=document.form;   
     	sheetObjects[1].SetCellValue( row, "Chk" ,"1",0);
     	if(sheetObjects[1].RowCount()> 0)
 	    {
 	    	sheetObjects[1].SetCellValue( row, "ibflag" ,"U",0);
 	    }
     	formObject.pol_cd.value=sheetObjects[1].GetCellValue( row, "vps_port_cd" )
 	    sheet2Flag=row;
     } 
/**
* handling process for input validation
*/
     function validateForm(sheetObj,formObj,sAction){
	       switch (sAction) {
	       		case IBSEARCH: 
	       		if(formObj.vps_eta_start_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_start_dt.value, "ymd"))
	  			{
	  				ComShowCodeMessage('BKG00377');
	  				formObj.vps_eta_start_dt.focus();
	  				return false;
	  			}
	       		if(formObj.vps_eta_end_dt.value.length > 0 && !ComIsDate(formObj.vps_eta_end_dt.value, "ymd"))
	  			{
	  				ComShowCodeMessage('BKG00377');
	  				formObj.vps_eta_end_dt.focus();
	  				return false;
	  			}
	       		if ( ComChkPeriod(formObj.vps_eta_start_dt.value, formObj.vps_eta_end_dt.value) < 1 )
				{
					ComShowCodeMessage('BKG00626','기간이 정확하지 않습니다.');
					formObj.vps_eta_start_dt.focus();
					return false;				
				}
	       		if (formObj.frm_crn_number.value == "" && formObj.vvd_number.value == "" 
	       			&& (formObj.vps_eta_start_dt.value == "" || formObj.vps_eta_end_dt.value == "") ) 
				{
					ComShowCodeMessage('BKG00564');
					formObj.vps_eta_start_dt.focus();
					return false;
				} 
	       		return true;
	       			break;
	       		case COMMAND01: // ADD
	       			if (formObj.frm_slan_cd.value  == "Cancel") {
	       				ComShowCodeMessage('BKG00572');       				 
	       				return false;
	       			}  
	       			if(sheet1Flag != 0)
	       			{       			 
	       				if(sheetObjects[0].GetCellValue( sheet1Flag, "vsl_call_ref_no" ) == "")
	       				{
	       					ComShowCodeMessage('BKG00569');      				 
	           				return false;
	       				}
	       			}
	       			if(sheet1Flag == 0)
	       			{       				 
	       				ComShowCodeMessage('BKG00567');       				 
	       				return false;
	       			}
	       			if(sheet2Flag == 0)
	       			{
	       				ComShowCodeMessage('BKG00568');       				 
	       				return false;
	       			}
	     		return true;
	     			break;
	       		case COMMAND02: // confirm all
	       			if(sheet1Flag != 0)
	       			{       				 
	       				if(sheetObjects[0].GetCellValue( sheet1Flag, "vsl_call_ref_no" ) == "")
	       				{
	       					ComShowCodeMessage('BKG00569');      				 
	       					return false;
	       				}
	       			}
	   				if (formObj.frm_slan_cd.value  == "Cancel") {
	   					ComShowCodeMessage('BKG00572');   					 
	   					return false;
	   				}
	   				if(sheet1Flag == 0)
	   				{
	   					ComShowCodeMessage('BKG00567');       				 
	   					return false;
	   				}
	       		return true;
	     		break;
	       		case COMMAND03: // B/L list
	       		    if(sheet1Flag == 0)
					{
						ComShowCodeMessage('BKG00567');       				 
						return false;
					}
	       		    if (sheetObjects[0].GetCellValue( sheet1Flag, "vsl_call_ref_sts_cd_nm" )  == "Cancel") {
						ComShowCodeMessage('BKG00572');				 
						return false;
					}				 			      		     
	       		return true;
	 		break;
   		}	
    }  
/**
* controlling keyboard in onkeyUp event of HTML Control 
**/
//function obj_KeyUp() {
//	    var formObject=document.form;        
//	    var srcName=ComGetEvent("name");
//	    var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	    var srcValue=window.event.srcElement.getAttribute("value");
//	    if (ComChkLen(srcValue, srcMaxLength) == "2") {
//	    	ComSetNextFocus();        	    		
//	    }
//}
/**
 * Enter event
 * @return
 */
function obj_ComKeyEnter() {
	if( event.keyCode != 13){return;}
 	var formObject=document.form;
 	var srcName=ComGetEvent("name");
 	if(srcName != "fax_no" && srcName != "cust_eml" 
 		&& srcName != "shpr_addr1" && srcName != "cnee_addr1" && srcName != "ntfy_addr1"
 		&& srcName != "shpr_addr2" && srcName != "cnee_addr2" && srcName != "ntfy_addr2" && srcName != "") {         		 
 		ComKeyEnter();
 	}         	         
}
 /**
  * checking Validation in onblur event of HTML Control . <br>
  **/
 function obj_activate(){
	//checking Validation 
	 var formObj=document.form;
	switch(event.srcElement.name){
		case "vps_eta_start_dt":
			//ComClearSeparator(event.srcElement);
			formObj.vps_eta_start_dt.value=formObj.vps_eta_start_dt.value.replace(eval("/-/gi"), "");
			break;	
    	case "vps_eta_end_dt":
    		//ComClearSeparator(event.srcElement);
    		formObj.vps_eta_end_dt.value=formObj.vps_eta_end_dt.value.replace(eval("/-/gi"), "");
			break;
		default:
			break;
			//return;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}
/**
 * checking Validation in onblur event of HTML Control <br>
 **/
function obj_deactivate(){
	//if (event.srcElement.getAttribute("required") != null) return;
    //checking Validation 
	switch(event.srcElement.name){
    	case "vps_eta_start_dt":
    		//ComAddSeparator(event.srcElement);
    		 ComChkObjValid(event.srcElement);
			break;
    	case "vps_eta_end_dt":
    		//ComAddSeparator(event.srcElement);
    		 ComChkObjValid(event.srcElement);
			break;
		default:
			break;
			//ComAddSeparator(event.srcElement);
			//ComChkObjValid(event.srcElement);
	}
}  
