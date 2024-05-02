/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0143.js
*@FileTitle  : Invoice Creation File Import Pop Up 
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
     * @class EES_MNR_0143 : business script for EES_MNR_0143.
     */
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;       
var comboList;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;    
var comboValue="";  
var verifyCheck=false;      
var retComboVal="";   
// Event handler processing by button click event */
	document.onclick=processButtonClick;  
// Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) { 
		        case "btn_new":  
                    doActionIBSheet(sheetObject, formObject, IBCLEAR);
                    break;   
		        case "btn_downExcel":  
					var cnt=sheetObject.RowCount();
					if(cnt<=0)
						var Row=sheetObject.DataInsert(-1);
					if(sheetObject.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject.Down2Excel( {DownCols: "4|5", SheetDesign:1,Merge:1 });
					}
                     break;   
                 case "btn_loadExcel":
//                	sheetObject.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"1=>4|2=>5"});
                	sheetObject.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false,ColumnMapping:"||||1|2"});
                	                 
                    break;          		     
		        case "btn_ok":
                    if(sheetObject.FindCheckedRow("checkbox") == ""){
						ComShowCodeMessage("MNR00038","SELECT ");             	   
					} else if(!verifyCheck){  
						ComShowCodeMessage("MNR00157");          		 	  
					} else {     
						comPopupOK_143(sheetObject,formObject); 	
					}                                   
					break;         
		        case "btn_Save":    
                    doActionIBSheet(sheetObject, formObject, IBSAVE); 
                    break;        
		        case "btn_RowAdd":                  
                    doActionIBSheet(sheetObject, formObject, IBINSERT);        
                    break; 
		        case "btn_RowDel":                     
                    doActionIBSheet(sheetObject, formObject, IBDELETE);        
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
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() { 
		MnrWaitControl(true); 
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k + 1);
        }   
        //initializing IBMultiCombo 
	    for(var k=0;k<comboObjects.length;k++){ 
	        initCombo(comboObjects[k],k + 1);  
	    }			
        doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);		
    }  
    /**
     * IBsetting combo basic info
     * @param	{IBCombo}	comboObj	initializing ComboObject 
     * @param	{Number}	comboNo		ComboObject tag serial number
     */
    function initCombo(comboObj, comboNo) {
  		var cnt=0 ;
  	    var formObject=document.form
  	    switch(comboNo) {  
			case 1: 
		    	with (comboObj) {   
					SetTitle("S/P Name|S/P Code|AGMT No|EQ TYPE|Effective Date|Reference No|Tariff No"); 
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColAlign(2, "center");
					SetColAlign(3, "left");
					SetColAlign(4, "center");
					SetColAlign(5, "left");
					SetColAlign(6, "left");
					SetColWidth(0, "180");
					SetColWidth(1, "80");
					SetColWidth(2, "90");
					SetColWidth(3, "80");
					SetColWidth(4, "170");
					SetColWidth(5, "180");
					SetColWidth(6, "180");
					SetDropHeight(160);
					SetTitleVisible(true);

			    }  	 
	        break;   
		} 
  	}	
  /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //t1sheet1 init
                with (sheetObj) { 
	                var HeadTitle="|Sel.|Del.|Seq.|W/O No|G.Amount|System Verify Result";
	
	                SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				                 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"checkbox",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_check",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"Seq",        KeyField:0,   CalcLogic:"",   Format:"" },
				                 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"inp_msg1",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11 },
				                 {Type:"Float",     Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:"inp_msg3",   KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
				                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Left",    ColMerge:0,   SaveName:"inp_msg5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                 {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:1,   SaveName:"inp_msg6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	
	                SetEditable(1);
	                SetEditableColorDiff(0);
	                SetSelectionMode(smSelectionRow);
	                SetColProperty(0 ,"inp_msg1" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	                SetSheetHeight(242);
            	}
            break;  
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
	 * registering IBCombo Object as list
	 * @param	{IBMultiCombo}	combo_obj	adding ComboObject. 
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */ 
	function setComboObject(combo_obj){     
    	comboObjects[comboCnt++]=combo_obj;  
	}     
 	/**  
	 * combo1 Change event      
	 * @param	{IBMultiCombo}		comboObj	comboObject  
	 * @param 	{Number} 			Index_Code 	selected row 
	 * @param 	{String} 			Text 		selected Text  
	 */  
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode){ 
		comboValue=comboObj.GetSelectCode();
		form.vndr_seq.value=comboList.items[comboValue].vndr_seq;
	}     
	/**  
	 * combo1 Checkbox event      
	 * @param	{IBSheet}		sheetObj	comboObject  
	 * @param 	{String} 			Row 		Row 
	 * @param 	{String} 			Col 		Col 
	 */  
	function sheet1_OnBeforeCheck(sheetObj,Row,Col){  
		if(sheetObj.ColSaveName(Col) == 'checkbox')
		{
			if(sheetObj.GetCellValue(Row,Col) != 1){
				sheetObj.SetRowBackColor(Row,"#NANNANNAN");
			} else {                            
				sheetObj.SetRowBackColor(Row,"#NANNANNAN");
				sheetObj.SetCellValue(Row,"inp_msg5","",0);
				sheetObj.SetCellEditable(Row,"checkbox",0);
				sheetObj.SetCellEditable(Row,"inp_msg1",1);
				sheetObj.SetCellEditable(Row,"inp_msg2",1);
				sheetObj.SetCellEditable(Row,"inp_msg3",1);
				verifyCheck=false;        
			} 
		}				
	} 
	//showing message after saving
	function sheet1_OnSaveEnd(sheetObj,ErrMsg){ 
		if (ErrMsg == "") {   
			ComShowCodeMessage("MNR00158");         
		} else { 
			ComShowCodeMessage("MNR00159",ErrMsg);   
		}       
	}
  // handling process for sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
			 case IBSAVE:        //saviing
              		formObj.f_cmd.value=MULTI;   
					vndrSeq=form.vndr_seq.value;
					for(var i=1; i <= sheetObj.RowCount(); i++){
						sheetObj.SetCellValue(i,"inp_msg6",vndrSeq,0);
					}    
					for(var i=1; i <= sheetObj.RowCount(); i++){
						sheetObj.SetRowStatus(i,"I");
					}          
					var sParam=sheetObj.GetSaveString(false, true);
					if (sParam == "") return;
				    sParam += "&" + FormQueryString(formObj);  
				    var sXml=sheetObj.GetSaveData("EES_MNR_0143GS.do", sParam);
				    sheetObj.LoadSaveData(sXml);
					for(var i=1; i <= sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i,"checkbox") == 1){
							sheetObj.SetRowBackColor(i,"#NANNANNAN");
							sheetObj.SetCellEditable(i,"inp_msg1",0);
							sheetObj.SetCellEditable(i,"inp_msg2",0);
							sheetObj.SetCellEditable(i,"inp_msg3",0);
						} else {                 
							sheetObj.SetRowBackColor(i,"#NANNANNAN");
							sheetObj.SetCellEditable(i,"checkbox",0);
						}                          
					}         
					verifyCheck=true;
					retComboVal=vndrSeq;         
                break;      
			case IBINSERT:  // ROWADD                   
					var Row=sheetObj.DataInsert(-1);
					sheetObj.SetCellValue(Row,"inp_msg2",ComGetNowInfo("ymd"),0);
					sheetObj.SetCellEditable(Row,"checkbox",0);
					verifyCheck=false;                       
	      		break; 
			case IBDELETE:  // ROWDELETE   
					for(var i=sheetObj.RowCount(); i > 0; i--){
						if(sheetObj.GetCellValue(i,"del_check") == 1){
							sheetObj.RowDelete(i, false);
						}     	
					}           
				break;
			case IBCLEAR: //  retrieving Combo Data and initializing sheet 
					MnrWaitControl(true);
					sheetObj.SetWaitImageVisible(0);
					//initializing Combo Data  
					for(var i=0; i < comboObjects.length;i++){ 
						comboObjects[i].RemoveAll();
					}     
					comboList=new combo1List();	  
					if(woOfcCd=="") woOfcCd=currOfcCd;
					var sXml=MnrAGMTHdrCombo(sheetObj,woOfcCd);
					var arrResult=MnrXmlToArray(sXml);		
					if(arrResult != null){	 	     
						for(var i=0; i < arrResult.length;i ++){ 		
							comboList.items.push(new combo1AGMT(arrResult[i][1],arrResult[i][8],arrResult[i][9],arrResult[i][12],arrResult[i][13],arrResult[i][15],arrResult[i][25],arrResult[i][2],arrResult[i][28],arrResult[i][14],arrResult[i][0],arrResult[i][22],arrResult[i][21]));		
							var tempComboText=arrResult[i][8] + "|" + arrResult[i][1] + "|" + arrResult[i][9] + "|" + arrResult[i][3] + "|" + arrResult[i][13] + " ~ " + arrResult[i][15] + "|" + arrResult[i][2] + "|" + " " + arrResult[i][25];  					
							combo1.InsertItem(i, tempComboText ,String(i));                 
							if(formObj.vndr_seq.value==arrResult[i][1]){
								if(vndrSeq!=""){
									combo1.SetSelectCode(String(i));
									combo1.SetEnable(0);
								}else{
									formObj.vndr_seq.value="";
								}
							}
						}				 				 						
					} else {					
						ComShowCodeMessage("MNR00056");
					}
					if(formObj.strAccess_system.value=="SPP"){
						formObj.vndr_seq.value=ComLpad(formObj.strVndr_seq.value,6,"0");
						var idx=combo1.FindItem( formObj.vndr_seq.value, 1);
						combo1.SetSelectCode(idx,false);
						combo1.SetEnable(0);
					}
					//initializing sheet
					sheetObj.RemoveAll();
					verifyCheck=false;  
					sheetObj.SetWaitImageVisible(1);
                  	MnrWaitControl(false);  
	      	   	break; 	
        } 
    }  
    /**
     * handling process for input validation
     */ 
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){  
        }       
        return true; 
    }   
	/**
     * object list for using combo1 
     */
	function combo1List(){
		this.items=[];		
	}
	/**
     * object for using combo1
     */
	function combo1AGMT(vndr_seq,vndr_nm,agmt_no,agmt_ver_no,eff_dt,exp_dt,trf_no,agmt_ref_no,eq_knd_cd,curr_cd,trsm_mod_cd,edi_id,pay_term_dys){
		this.vndr_seq=vndr_seq;         
		this.vndr_nm=vndr_nm;	        
		this.agmt_no=agmt_no;         
		this.eff_dt=eff_dt;	        
		this.exp_dt=exp_dt;          
		this.agmt_ref_no=agmt_ref_no;      
		this.trf_no=trf_no;          
		this.agmt_ver_no=agmt_ver_no;     
		this.eq_knd_cd=eq_knd_cd;	
		this.curr_cd=curr_cd;         
		this.trsm_mod_cd=trsm_mod_cd; 
		this.edi_id=edi_id;  
		this.pay_term_dys=pay_term_dys; 
	}		
	/**
     * setting return value to parent form.
     */
	function comPopupOK_143(sheetObj,formObject) {
		var formObject=document.form; 
		var rArray=new Array(); //list containing row data
		var ret_val=new Array(); 
		if(comboValue=="") comboValue=0;
		ret_val[0]=retComboVal;    
		ret_val[1]=comboList.items[comboValue].vndr_nm;	
        ret_val[2]=comboList.items[comboValue].pay_term_dys;	
		ret_val[3]=comboList.items[comboValue].curr_cd;	
	    var sRow=sheetObj.FindCheckedRow("checkbox");
	    //setting row as list.          
	    var arrRow=sRow.split("|");   
	    for (idx=0; idx < arrRow.length; idx++){     
			var cArray=new Array(); // list containing col data
			cArray[0]=sheetObj.GetCellValue(arrRow[idx], "inp_msg1");
			cArray[1]=sheetObj.GetCellValue(arrRow[idx], "inp_msg2");
			cArray[2]=sheetObj.GetCellValue(arrRow[idx], "inp_msg3");
			cArray[3]=sheetObj.GetCellValue(arrRow[idx], "inp_msg6");
			rArray[idx]=cArray;                           
		}
	    if (!opener) opener=window.dialogArguments;
	    if(!opener) opener=parent;
		opener.getEES_MNR_0143(rArray,ret_val);  
		ComClosePopup(); 
	}   
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		for(var i=1; i <= sheetObj.RowCount(); i++){
		    //deleting in case of existing header Title
			if(i==1 && sheetObj.GetCellValue(1,"inp_msg1").indexOf("W/O")!=-1){
				sheetObj.RowDelete(1, false);
			}
			sheetObj.SetRowStatus(i,"R");
			sheetObj.SetCellEditable(i,"checkbox",0);
		}
	}
	/* developer job */
