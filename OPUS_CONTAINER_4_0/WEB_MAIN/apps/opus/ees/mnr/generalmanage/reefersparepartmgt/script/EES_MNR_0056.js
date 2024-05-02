/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0056.jsp
*@FileTitle  : VSL Reefer Spare Part Inventory
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
	/****************************************************************************************
				  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
	 ***************************************************************************************/
	/**
	 * @extends 
	 * @class ees_mnr_0056 : business script for ees_mnr_0056.
	 */
	/* developer job	*/
	//common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject1=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
				case "btn_New":
					doActionIBSheet(sheetObjects[0], formObject, IBCLEAR);
					break;
				case "btn_calendar":
					var cal=new ComCalendarFromTo();
				    cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				    break;			
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
					break;
				case "btn_spare_type_list":
					ComOpenPopup("EES_MNR_0198.do", 950, 450, '', '0,1', true);					
					break;	
				case "btn_workorder_history":
					formObject.vsl_cd2.value=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_vsl_cd");
					ComOpenPopup("EES_MNR_0194.do", 950, 420, '', '0,1', true);
					break;	
				case "btn_Lane":
					ComOpenPopup("COM_ENS_081.do", 780, 420, 'setPopUpParam_COM_ENS_081', '0,1', true);
					break;				
				case "btn_RowAdd":
					doActionIBSheet(sheetObjects[0], formObject,IBINSERT);
					break;
				case "btn_delete":
					if(sheetObjects[0].FindCheckedRow("del_chk") == ""){
						ComShowCodeMessage("MNR00038","DELETE ");
						return false;             	   
					}
					if(ComShowCodeConfirm("MNR00026")){
						ComRowHideDelete(sheetObjects[0], "del_chk");
						calReq=0;
					}
					break;
				case "btn_DownExcel":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObjects[0].Down2Excel();
					}
					break;
				case "btn_LoadExcel":
					ComOpenPopup("/opuscntr/EES_MNR_0219.do", 698, 535, 'setPopUpParam_EES_MNR_0219', '1,0', true); 
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	 MnrWaitControl(true);
    	 initControl();
        for(i=0;i<sheetObjects.length;i++)
        {
	        //
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
	        //
			ComEndConfigSheet(sheetObjects[i]);
        }
        initCombo();
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		MnrWaitControl(false);
    }
 	/**
 	 * initializing multi Combo 
 	 * @return
 	 */
 	function initCombo() {
 		with (combo_spr_tp_cd) {
 			SetMultiSeparator("|");
			SetColAlign(0, "left");
			SetColWidth(0, "80");
 			SetDropHeight(160);
 			SetEnable(1);
 		}
 	}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      // sheet1 init
                with(sheetObj){
              var HeadTitle1="|Sel|Seq|Vessel Code|Vessel Name|Lane|Spare Type|Supply Date|Check Date|Discharge Date|Remark(s)";
              var headCount=ComCountHeadTitle(HeadTitle1);
              var prefix="sheet1_";

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
                     {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
                     {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:4 },
                     {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"PopupEdit", Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"lane_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3 },
                     {Type:"Combo",     Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_spl_dt", KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_chk_dt", KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"PopupEdit", Hidden:0, Width:92,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dchg_dt",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"invt_rmk",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
               
              InitColumns(cols);
              SetEditable(1);
              SetImageList(0,"img/btns_detail.gif");
              SetImageList(1,"img/btns_calendar.gif");
              
              SetColProperty(0 ,prefix+"vsl_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              SetColProperty(0 ,prefix+"lane_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
//              SetColProperty(0 ,"lane_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
              //conversion of function[check again]CLT 				InitDataValid(   0,    cnt,  vtEngUpOther, "0123456789");
              ///PopupButtonImage(0, 4)=0;
              ///PopupButtonImage(0, 7)=1;
              ///PopupButtonImage(0, 8)=1;
              ///PopupButtonImage(0, 9)=1;
              SetShowButtonImage(2);
//              SetSheetHeight(380);
              resizeSheet( sheetObj );
              }
			break;
            case 2: 
        		with (sheetObj) {
        		}	 
        		break;
        }
    }
  	function initControl() {       
  		//Axon handling event1. event catch  
  		var formObject=document.form;       
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  
//  	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);             
//  	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            
  		axon_event.addListenerFormat('change',	 'obj_change',	formObject); 
  	}
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
  	//Axon handling event2. handling event   
  	function obj_deactivate(){      
  		ComChkObjValid(ComGetEvent()); 
  	} 
  	function obj_activate(){   
  		ComClearSeparator(ComGetEvent());
  	}        
  	function obj_change(){	     
  		var obj=ComGetEvent(); 
  		var formObj=document.form; 
  		var sheetObj=sheetObjects[0]; 
  		if ( ComTrim(obj.value) != "" ) {
  			switch(ComGetEvent("name")) {      
  			case "empty":   
  				break;   
  			}       
  		} 
  	}    
//  	function obj_keypress(){   
//  		obj=ComGetEvent();    
//  		keys=event.keyCode;
//  		if(obj.dataformat == null) return; 
//  		window.defaultStatus=obj.dataformat;
//  		var formObj=document.form; 
//  		if ( ComTrim(obj.value) != "" ) {
//  			switch(ComGetEvent("name")) {      
//  			case "empty":   
//  				break;   
//  			}       
//  		}				 			              
//  		switch(obj.dataformat) {   
//  		case "ymd":   
//  		case "int":       
//  			ComKeyOnlyNumber(obj); 
//  			break;     
//  		case "float":    
//  			ComKeyOnlyNumber(obj, "-.");
//  			break; 
//  		case "eng":   
//  			ComKeyOnlyAlphabet();
//  			break;   
//  		case "engup":  
//  			ComKeyOnlyAlphabet('uppernum');           
//  			break; 
//  		}         
//  	}     
    function sheet1_OnSearchEnd(sheetObj, errMsg) {
		var formObj=document.form;
		var prefix="sheet1_";
		MnrWaitControl(false);
		nowLoad=0;
	}     
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
		var formObj=document.form;
		if(formObj.f_cmd.value == MULTI)
		{
			if (errMsg == "") { 
				ComShowCodeMessage("MNR00009", "Reefer Spare Parts Inventory");
				formObj.vsl_cd.value="";
				doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
			} else { 
				ComShowCodeMessage("MNR00008",ErrMsg);
			}
		}
		nowLoad=0;
		MnrWaitControl(false);
	}	   	
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		if (sheetObj.ColSaveName(Col) == "sheet1_spr_spl_dt" ||
				sheetObj.ColSaveName(Col) == "sheet1_dchg_dt" ||
				sheetObj.ColSaveName(Col) == "sheet1_spr_chk_dt" )
		{
			var cal=new ComCalendarGrid();     
			cal.select(sheetObj, Row, Col, 'yyyy-MM-dd'); 
		}else if(sheetObj.ColSaveName(Col) == "sheet1_vsl_cd")
		{
			MnrWaitControl(true);
			ComOpenPopup("COM_ENS_0A1.do", 620, 420, 'setPopUpParam_COM_ENS_0A1', '0,1', true);
			MnrWaitControl(false); 
		}else if(sheetObj.ColSaveName(Col) == "sheet1_lane_cd")
		{
			MnrWaitControl(true);
			ComOpenPopup("COM_ENS_081.do", 780, 400, 'setPopUpParamSheet_COM_ENS_081', '0,1', true);
			MnrWaitControl(false); 
		}
	}  
	function sheet1_OnChange(sheetObj,Row, Col, Value){
		if(sheetObj.ColSaveName(Col) == "sheet1_vsl_cd"){
			MnrWaitControl(true);
			var formObj=document.form;
			var checkVsl=sheetObjects[0].GetCellValue(Row,"sheet1_vsl_cd");
			sheetObjects[0].SetCellValue(Row,"sheet1_vsl_cd",checkVsl.toUpperCase(),0);
			checkVsl=checkVsl.toUpperCase();
			// showing EQ_NUMBER Equipment Information
			
			setVesselInfo(sheetObjects[0],Row,checkVsl);	 
			return; 	   
		}
	}    
	function sheet1_OnSelectCell(sheetObj,OldRow, OldCol, NewRow, NewCol){
		var formObj=document.form;
		if(OldRow !=NewRow)
		{
			if(sheetObj.GetCellValue(NewRow,"sheet1_ibflag")== "I"){
				sheetObj.SetCellEditable(NewRow,"sheet1_vsl_cd",1);
			}else{
				sheetObj.SetCellEditable(NewRow,"sheet1_vsl_cd",0);
			}
			return;
		}	 	
	}	
	/**
	 * checking Uniqueness Vessel Code
	 */
	function sheet1_vsl_cd_UniqueCheck(sheetObj,formObj,Row){
			formObj.f_cmd.value=SEARCH; 
			formObj.vsl_cd.value=sheetObj.GetCellValue(Row,"sheet1_vsl_cd");
			formObj.spr_tp_cd.value="";
			var sParam="";
			var aryPrefix=new Array("sheet1_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSearchData("EES_MNR_0056GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				var Slength=arrDataSearchDbXml[i].indexOf("TOTAL='");
				var intSize=arrDataSearchDbXml[i].substring(Slength + 7,Slength + 8);
			}   
			if(intSize>0)
			{
				return false;
			}
		return true;
	}
  // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBCLEAR:  //NEW
				MnrWaitControl(true);
				formObj.f_gubuns.value="";
				formObj.vsl_slan_cd.value="";
				formObj.cost_ofc_cd.value=currOfcCd;
				formObj.tocal.value = ComGetNowInfo();
				formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
				//setting combo
				costDtlCode="";
				costDtlDesc="";
				combo_spr_tp_cd.RemoveAll();
				// combo_spr_tp_cd.SetSelectCode("-1",false);
				var sCondition=new Array (
						new Array("MnrGenCd","CD00031", "CUSTOM8") //Spare Type
					   ,new Array("MnrGenCd","CD00031",  "COMMON") // Sheet Spare Type
					);   
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				var code,Texts="";
				for(var i=0; i<comboList.length; i++)
				{	
					if(comboList[i] != null)
					{
	                    if(i==0){
	                    	combo_spr_tp_cd.InsertItem(0, "All" ,"All");
						}
						for(var j=0; j < comboList[i].length;j++)
						{   
							var xmlVal=comboList[i][j].split("|");  
							if(i==0){
								combo_spr_tp_cd.InsertItem(j + 1, xmlVal[1] ,xmlVal[0].substring(1));
							}else if(i==1){
								costDtlCode=costDtlCode + xmlVal[0].substring(1) + "|";
								costDtlDesc=costDtlDesc + xmlVal[1] + "|";
							}
						}	
						if(i==1){
							costDtlCode=costDtlCode.substring(0, costDtlCode.length - 1);
							costDtlDesc=costDtlDesc.substring(0, costDtlDesc.length - 1);
							sheetObjects[0].SetColProperty(0,"sheet1_spr_tp_cd", {ComboText:costDtlDesc, ComboCode:costDtlCode} );
						}
					}
					else
					{
						if(i==0){
							ComShowCodeMessage("MNR00005", "Spare Type  ");
						}
					}
				}		
				combo_spr_tp_cd.SetSelectIndex(0);
				sheetObjects[0].RemoveAll();
				MnrWaitControl(false);        
				break;
			case IBSEARCH:      //retrieving
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				nowLoad=1;
				formObj.f_gubuns.value="";
				sheetObjects[0].RemoveAll();
			    formObj.f_cmd.value=SEARCH; 
			    formObj.vsl_cd2.value="";
				formObj.spr_tp_cd.value= combo_spr_tp_cd.GetSelectCode() == "All" ? " " : combo_spr_tp_cd.GetSelectCode();
				var sParam="";
				var aryPrefix=new Array("sheet1_");
				sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("EES_MNR_0056GS.do", sParam);
				arrDataSearchDbXml=sXml.split("|$$|");
				for ( var i=0; i < arrDataSearchDbXml.length; i++) {
					///sheetObjects[i].RenderSheet(0);
					sheetObjects[i].SetWaitImageVisible(0);
					sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:1} );
					///sheetObjects[i].RenderSheet(1);
				}   
				break;		
			case IBSAVE:        //saving
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				formObj.f_cmd.value=MULTI;
				var aryPrefix=new Array("sheet1_");
				var sParam=ComGetSaveString(sheetObjects, true, true);
				if (sParam == "")
				{
					MnrWaitControl(false);
					return false;
				}
				sParam += "&" + FormQueryString(formObj) + "&"
				+ ComGetPrefixParam(aryPrefix);
				var sXml=sheetObj.GetSaveData("EES_MNR_0056GS.do", sParam);
				sheetObjects[0].LoadSaveData(sXml);
				break;
			case IBINSERT:      // saving
				if(!validateForm(sheetObj,formObj,sAction))return;
				MnrWaitControl(true);
				var row=sheetObj.DataInsert(-1);
				sheetObj.SetCellValue(row, "sheet1_spr_tp_cd","",0);
				MnrWaitControl(false);
                break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
			with(formObj){
				// saving in case of confirmed
				if(sAction==IBSAVE)
				{
					//1. checking row in Grid Main whether one or more
					var rCnt=sheetObj.RowCount();
					if(rCnt<=0)
					{
						//ComShowCodeMessage("MNR00072");
						return false;             	   
					}
					for(var i=sheetObj.HeaderRows();i<=sheetObj.LastRow();i++)
					{
						//2.checking Vessel Code Mandatory.
						var strSel=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_vsl_cd")," ");
						if(strSel=="")
						{
							ComShowCodeMessage("MNR00036","Vessel Code");
							sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
							return false; 
						}
						//3.checking duplicate Vessel Code and input value.     		
						if(sheetObj.GetCellValue(i, "sheet1_ibflag")=="I")
						{
							var startUnique=sheetObj.FindText("sheet1_vsl_cd",sheetObj.GetCellValue(i, "sheet1_vsl_cd"),1);
							if(startUnique != i && startUnique != -1)
							{
								ComShowCodeMessage("MNR00006","Vessel Code");
								sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
								return false; 
							}							
							if(i<sheetObj.LastRow())
							{
								var endUnique=sheetObj.FindText("sheet1_vsl_cd",sheetObj.GetCellValue(i, "sheet1_vsl_cd"),i + 1);
								if(endUnique != i && endUnique != -1)
								{
									ComShowCodeMessage("MNR00006","Vessel Code");
									sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
									return false; 
								}						
							}
							if(!sheet1_vsl_cd_UniqueCheck(sheetObj,formObj,i))
							{
								ComShowCodeMessage("MNR00006","Vessel Code");
								sheetObj.SelectCell(i, "sheet1_vsl_cd",true);
								return false; 
							}
						}
						
						if(sheetObj.GetCellValue(i, "sheet1_ibflag")!="D"){
							//2.checking LAND Code Mandatory.
							var strSel=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_lane_cd")," ");
							if(strSel=="")
							{
								ComShowCodeMessage("MNR00172","Lane Code");
								sheetObj.SelectCell(i, "sheet1_lane_cd",true);
								return false; 
							}
							//4.checking LANE whether or not.    
							var returnValue=MnrGeneralCodeCheck(sheetObj,"LANE",sheetObj.GetCellValue(i, "sheet1_lane_cd"))
							if(returnValue==null)
							{
								ComShowCodeMessage("MNR00159","Lane Code");
								sheetObj.SetCellValue(i, "sheet1_lane_cd","");
								sheetObj.SelectCell(i, "sheet1_lane_cd",true);
								return false; 
							}
							//4.checking Spare Type whether or not.    				
							var strInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_tp_cd")," ");
							if(strInput=="")
							{
								ComShowCodeMessage("MNR00172","Spare Type");
								sheetObj.SelectCell(i, "sheet1_spr_tp_cd",true);
								return false; 
							}  
							//4 checking Date whether or not.    				
							var strSplInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_spl_dt")," ");
							var strChgInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_dchg_dt")," ");
							var strChkInput=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_spr_chk_dt")," ");
							if(strSplInput=="" && strChgInput=="" && strChkInput=="")
							{
								ComShowCodeMessage("MNR00172"," One Of Supply Date,Discharge Date,Check Date");
								sheetObj.SelectCell(i, "sheet1_spr_spl_dt",true);
								return false; 
							}
						}
						    				
					}
				}
				//retrieving
				else if(sAction==IBSEARCH)
				{
					var sRow=sheetObj.FindStatusRow("I|U|D");  // checking sheet status
					if(sRow != "") // in case of existing edits
					{                               	
						if(!ComShowCodeConfirm("MNR00007"))
						{
							return false;
						}
					}
				}
			}
			return true;
    }
    function setPopUpParam_COM_ENS_081(array) {
    	if(array == null)return;
    	var formObj=document.form;
    	var str=array + "";
    	var arr=str.split(",");
    	formObj.vsl_slan_cd.value=arr[3];
    }     
    function setPopUpParamSheet_COM_ENS_081(array) {
    	if(array == null)return;
    	var formObj=document.form;
    	var str=array + "";
    	var arr=str.split(",");
    	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(),"sheet1_lane_cd",arr[3]);
    }
    function setPopUpParam_COM_ENS_0A1(array) {
    	if(array == null)return;
    	var str=array + "";	
    	var arr=str.split(',');
    	var Row=sheetObjects[0].GetSelectRow();
    	sheetObjects[0].SetCellValue(Row,"sheet1_vsl_cd",arr[3],0);
    	var checkVsl=sheetObjects[0].GetCellValue(Row,"sheet1_vsl_cd");
		sheetObjects[0].SetCellValue(Row,"sheet1_vsl_cd",checkVsl.toUpperCase(),0);
		checkVsl=checkVsl.toUpperCase();
		// showing EQ_NUMBER Equipment Information
		setVesselInfo(sheetObjects[0],Row,checkVsl);	
    }  	
	function setVesselInfo(sheetObj,Row,vsl_cd){
		var formObj=document.form;
		var sXml=MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr=MnrXmlToArray(sXml); 
		if(retArr != null){  
			
			//TpSz	
			sheetObjects[0].SetCellValue(Row,"sheet1_vsl_eng_nm",retArr[0][0],0);
			sheetObjects[0].SetCellValue(Row,"sheet1_lane_cd",retArr[0][5],0);
			//Lane	
			if(retArr[0][5]=="")
			{
				ComShowCodeMessage("MNR00254",vsl_cd + " of Veseel Code","Lane");
				sheetObjects[0].SetCellValue(Row,"sheet1_vsl_eng_nm","",0);
				sheetObjects[0].SetCellValue(Row,"sheet1_lane_cd","",0);
				sheetObjects[0].SetCellValue(Row,"sheet1_vsl_cd","",0);
				sheetObjects[0].SelectCell(Row,"sheet1_vsl_cd");
			}
			sheetObjects[0].SelectCell(Row,"sheet1_spr_tp_cd");
		} else {	  
			//TpSz	
			sheetObjects[0].SetCellValue(Row,"sheet1_vsl_eng_nm","",0);
			//Lane	
			sheetObjects[0].SetCellValue(Row,"sheet1_lane_cd","",0);
			ComShowCodeMessage("MNR00165",vsl_cd,"Vessel Code");          				
			sheetObjects[0].SetCellValue(Row,"sheet1_vsl_cd","",0);
			sheetObjects[0].SelectCell(Row,"sheet1_vsl_cd");
		}	
		MnrWaitControl(false);
		calReq=0;
	}		
	function combo_spr_tp_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex, newtext, newcode)
	{
		document.form.combo_spr_tp_cd_text.value = comboObj.GetText(parseInt(newindex), 0);
	}
	function combo_spr_tp_cd_OnBlur() {
		document.form.combo_spr_tp_cd_text.value = combo_spr_tp_cd.GetText(parseInt(combo_spr_tp_cd.GetSelectIndex()), 0);
	}
