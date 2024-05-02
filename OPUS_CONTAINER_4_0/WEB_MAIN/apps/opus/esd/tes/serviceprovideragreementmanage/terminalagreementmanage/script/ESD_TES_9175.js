/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9170.jsp
*@FileTitle  : Agreement Storage Rate List Excel Load
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
var sheetErrCount=0;
var opener=window.dialogArguments;
if (!opener) opener=parent;
var gap_st = 1;
var strErrLine = "";

/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		/*******************************************************/
		var sheetObject=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_loadexcel":
					doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
					break;
				case "btn_verify":
					var k=sheetObjects[0].RowCount();
					var err_count=0;
					if( k == 0 ) {
						ComShowCodeMessage('TES10087');
						return false;		
					}
					
					var dupRowCount=0;
					strErrLine = "";
					
				   	 for(var i=0;i<sheetObjects[0].RowCount()+2;i++){
							//sheetObjects[2].SetRowBackColor(i, "");
							// 43 column
							for(var j=0;j<42+gap_st; j++){
							sheetObjects[0].SetCellBackColor(i, j, "");
							}
						}
				   	 
//					var dupRowInfo = sheetObjects[0].ColValueDupRows("1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41", false, true);
//					if(dupRowInfo != ""){															
//						var dupRow=dupRowInfo.split("|");											
//						var dupRowNum=dupRow[1].split(",");	
//						
//						if(dupRowNum.length > 0){											
//							for(var i=0 ; i<dupRowNum.length ;i++){					
//								if(sheetObjects[0].GetCellValue(dupRowNum[i],"5lgs_cost_cd") != "SRXXDC"){
//									dupRowCount++;	
//									sheetObjects[0].SetRowBackColor(dupRowNum[i],"#FF0000");
//									errLineAdd(dupRowNum[i]);
//								}
//							}
//							if(dupRowCount>0){
//								alert("Dup Err Line : "+ strErrLine+"\nThere are "+dupRowCount+" duplicate rows total.");
////								ComShowCodeMessage('TES10119', dupRowCount);
//								return false;
//							}
//						}	
//					}
				   	 
//					doActionIBSheet1(sheetObject1,formObject,IBSEARCH);	
					if(sheetErrCount==0){
						for(var i=0 ; i<=k ;i++){         	     			
							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 1))){//lgs_cost_cd
								sheetObjects[0].SetCellBackColor(i+2,1,"#FF0000");
								errLineAdd(i+2);
								err_count++;			     		  			   					
							}else{
								//sheetObjects[0].SetCellBackColor(i+2,0,"#000000");
								sheetObjects[0].SetCellBackColor(i+2,1,"");
							}
//							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 1+gap_st))){
//								sheetObjects[0].SetCellBackColor(i+2,1+gap_st,"#FF0000");
//								errLineAdd(i+2);
//								err_count++;	
//							}	else{	
//								//sheetObjects[0].SetCellBackColor(i+2,1,"#000000");
//								sheetObjects[0].SetCellBackColor(i+2,1+gap_st,"");
//							}						
//							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 2+gap_st))){
//								sheetObjects[0].SetCellBackColor(i+2,2+gap_st,"#FF0000");
//								errLineAdd(i+2);
//								err_count++;					     		  			   					
//							}else{
//								//sheetObjects[0].SetCellBackColor(i+2,2,"#000000");
//								sheetObjects[0].SetCellBackColor(i+2,2+gap_st,"");
//							}	
//							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 3+gap_st))){
//								sheetObjects[0].SetCellBackColor(i+2,3+gap_st,"#FF0000");
//								errLineAdd(i+2);
//								err_count++;						     		  				   					
//							}else{
//								//sheetObjects[0].SetCellBackColor(i+2,3,"#000000");
//								sheetObjects[0].SetCellBackColor(i+2,3+gap_st,"");
//							}	
////							if (ComIsNull(sheetObjects[0].GetCellValue(i+2, 4+gap_st))){
////								sheetObjects[0].SetCellBackColor(i+2,4+gap_st,"#FF0000");
////								errLineAdd(i+2);
////								err_count++;						     		  				   					
////							}else{
////								//sheetObjects[0].SetCellBackColor(i+2,4,"#000000");
////								sheetObjects[0].SetCellBackColor(i+2,4+gap_st,"");
////							}
						}
					}	
					if(sheetErrCount > 0 || err_count > 0){
						if(strErrLine!=""){
							alert("Err Line : "+strErrLine+"\nPlease modify sheet.");	
						}
						
//						ComShowCodeMessage('TES10088');
						sheetErrCount=0;
						return false;         	     			
					}else if(sheetErrCount == 0 && err_count == 0) { 
						var opener_sheet_obj=opener.t5sheet1;
						var appendFlg="";
						if(opener_sheet_obj.RowCount()==0){
							ComShowCodeMessage('TES10089');  
							appendFlg=true;
						}else if(opener_sheet_obj.RowCount()>0){
							appendFlg=ComShowConfirm(ComGetMsg('TES10131'));  
						}
						for(var i=0;i<sheetObjects[0].RowCount();i++){
							if(sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase() == "IB" || sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase() == "OB" || sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase() == "SAME" ){
								sheetObjects[0].SetCellValue(i+2,"9io_bnd_cd",sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase());
								if(sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase()  == "IB"){
									sheetObjects[0].SetCellValue(i+2,"9io_bnd_cd","I");
								}else	if(sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase()  == "OB"){
									sheetObjects[0].SetCellValue(i+2,"9io_bnd_cd","O");
								}else	if(sheetObjects[0].GetCellValue(i+2,"9io_bnd_cd").toUpperCase()  == "SAME"){
									sheetObjects[0].SetCellValue(i+2,"9io_bnd_cd","S");
								}					
							}else{
								sheetObjects[0].SetCellValue(i+2,"9io_bnd_cd","");
							} 					
							if(sheetObjects[0].GetCellValue(i+2,"9sat_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].SetCellValue(i+2,"9sat_flg_fd","Y");
							}else if(sheetObjects[0].GetCellValue(i+2,"9sat_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].SetCellValue(i+2,"9sat_flg_fd","");
							}
							if(sheetObjects[0].GetCellValue(i+2,"9sun_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].SetCellValue(i+2,"9sun_flg_fd","Y");
							}else if(sheetObjects[0].GetCellValue(i+2,"9sun_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].SetCellValue(i+2,"9sun_flg_fd","");
							}		
							if(sheetObjects[0].GetCellValue(i+2,"9hol_flg_fd").toUpperCase() == "E"){
								sheetObjects[0].SetCellValue(i+2,"9hol_flg_fd","Y");
							}else if(sheetObjects[0].GetCellValue(i+2,"9hol_flg_fd").toUpperCase() == "I"){
								sheetObjects[0].SetCellValue(i+2,"9hol_flg_fd","");
							}
							if(sheetObjects[0].GetCellValue(i+2,"9to_tr_dys").toUpperCase() == "MAX"){
								sheetObjects[0].SetCellValue(i+2,"9to_tr_dys",sheetObjects[0].GetCellValue(i+2,"9to_tr_dys").toUpperCase());
							}
						}		         	     			
						//setDtaCurrSht2OprSht(sheetObjects[0], sheetObjects[2]);  
						if(appendFlg==true){
							setDtaCurrSht2OprSht1(sheetObjects[0],'');         	     			
						}else if(appendFlg==false){ 
							opener_sheet_obj.RemoveAll();
							setDtaCurrSht2OprSht1(sheetObjects[0],'');         	     					
						}		    	            
						ComClosePopup(); 
						sheetErrCount=0;
					}									
					break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('TES21025');
			} else {
				ComShowMessage(e.message);
			}
		}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param{ibsheet}	sheet_obj	Sheet Object
     */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
    /**
     * initializing sheet.<br>
     * implementing onLoad event handler in body tag.<br>
     * adding first-served functions after loading screen..<br>
     */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj ==> , sheetNo ==>  
	 * adding case as numbers of counting sheets
	 * @param{ibsheet}		sheetObj	Sheet Object
	 * @param{int,String}	sheetNo		Sheet No
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
			case 1:      //sheet1 init
			    with(sheetObj){	
			      sheetNo=9;		     
			      var HeadTitle0="Seq|Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
			      + "Exclude Date|Exclude Date|Exclude Date|"
			      + "Tier Over Days|Tier Over Days|Cal.\nPeriod|Pool\nTEU|"
			      + "Days|Days|Days|Days|Days|Days|Days|Days|Days|"
			      + "Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|Rate|"
			      + "Rate\nTEU|Rate\nBox|Rate\nMove|Verify\nResult|Remark";
			      var HeadTitle1="Seq|Cost Code|Volume\nUOM|Currency|Agreement\nType|Comm.\nTime of\na Day|FT Day|I/O|"
			      + "SA|SU|Ho|"
			      + "From|To|Cal.\nPeriod|Pool\nTEU|"
	              + "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|" 
	              + "SL2|TA2|GN4|EG5|CH2|CH4|CLG|UMG|Chassis-\nGenset|"
			      + "Rate\nTEU|Rate\nBox|Rate\nMove|Verify\nResult|Remark";
	
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                  { Text:HeadTitle1, Align:"Center"}];
			      InitHeaders(headers, info);
	
			      var cols = [ {Type:"Seq",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }, 
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_agmt_vol_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"curr_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"tml_sto_agmt_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"cmnc_hrmnt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ft_dys",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"io_bnd_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sat_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sun_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"hol_flg_fd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fm_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"to_tr_dys",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_calc_prd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             
			             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"fp_teu_qty",            KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sl2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ta2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gn4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eg5_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },

		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch2_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch4_d",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"clg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"umg_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
		                 {Type:"Int",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"com_d",                  KeyField:0,   CalcLogic:"",   Format:"Integer",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
			             
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"sl2_r",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ta2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"gn4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"eg5_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch2_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  
		                  {Type:"Float",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ch4_r",                 KeyField:0,   CalcLogic:"",   Format:"Float",     PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"clg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"umg_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
		                  {Type:"Float",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"com_r",                  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:18 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"teu_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"box_rate",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"move_rate",             KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"verify_result",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"agmt_dtl_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"xcld_dy_aply_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             
			             {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"auto_calc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ts_rt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:1,    Align:"Center",  ColMerge:1,   SaveName:sheetNo+"vrfyFlg",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:sheetNo+"ibflag" } ];
			       
			      InitColumns(cols);
	
			      SetEditable(1);
			      SetCellBackColor(1,7+gap_st,"#555555");//
			      SetRangeBackColor(1, 8+gap_st,  1, 37+gap_st,"#555555");//
			      SetRangeBackColor(1, 20+gap_st,  1, 23+gap_st,"#555555");//
			      SetRangeBackColor(2,  8+gap_st, 2, 37+gap_st,"#555555");//
			      SetRangeBackColor(1, 36+gap_st, 1, 37+gap_st,"#555555");//
			      SetRangeBackColor(1, 39+gap_st, 1, 91+gap_st,"#555555");//
			      SetHeaderRowHeight(21);
			      SetHeaderRowHeight(20);
			      SetColProperty(sheetNo+"lgs_cost_cd", {ComboText:"|SRNDCH|SRNDGS|SRFDCH|SRFDGS", ComboCode:"|SRNDCH|SRNDGS|SRFDCH|SRFDGS"} );
			      SetColProperty(sheetNo+"tml_cntr_sty_cd", {ComboText:"|Same|F|M", ComboCode:"|S|F|M"} );
			      SetColProperty(sheetNo+"tml_agmt_vol_ut_cd", {ComboText:vol_ut_cdCode, ComboCode:vol_ut_cdCode} );
			      SetColProperty(sheetNo+"tml_sto_agmt_tp_cd", {ComboText:tml_sto_agmt_tp_codeCode, ComboCode:tml_sto_agmt_tp_codeCode} );
			      SetColProperty(sheetNo+"io_bnd_cd", {ComboText:io_bnd_codeText, ComboCode:io_bnd_codeCode} );
			      SetColProperty(sheetNo+"ft_dys", {ComboText:"|F", ComboCode:"|F"} );
			      SetColProperty(sheetNo+"fp_calc_prd_cd", {ComboText:"|D|M", ComboCode:"|D|M"} );

			      SetColProperty(sheetNo+"cmnc_hrmnt", {Format:"##:##"} );
			      //SetCountFormat()("[SELECTDATAROW / ROWCOUNT]");
			      resizeSheet();//SetSheetHeight(300);
		      	}

				break;
			case 2:   //t2sheet1 init
			    with(sheetObj){
				      var HeadTitle="cost_cd|vrfy";
		
				      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
				      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				      var headers = [ { Text:HeadTitle, Align:"Center"} ];
				      InitHeaders(headers, info);
		
				      var cols = [ {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:"",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 } ];
				       
				      InitColumns(cols);
		
				      SetEditable(1);
				      SetCountPosition(0);
		           }

				break;                   
		}
	}
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0]);
    }
	/**
	 * handling sheet process. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBLOADEXCEL:
				sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
				//sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:true});
				break;
		}
	}
 	/**
 	 * handling sheet process. <br>
 	 * @param {ibsheet}  	sheetObj	Sheet Object
 	 * @param {String}  	formObj		Form Object
 	 * @param {String}  	sAction		Action Command
 	 */
	function doActionIBSheet1(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:            					 
				formObj.f_cmd.value=SEARCH;               
				var param=sheetObjects[0].GetSaveString(false,false);
				var sXml=sheetObjects[1].GetSearchData("ESD_TES_9170GS.do", param+'&'+tesFrmQryStr(formObj),"",true);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
				break;         	
		}
	}  
	/**
	 * @param {ibsheet}  	ip_sht_obj		input sheet
	 * @param {String}  	opr_sht_nm_str	opener sheet
	 */
    function setDtaCurrSht2OprSht(ip_sht_obj, opr_sht_nm_str) {
		var formObj=document.form;		
		var total_rate=0;
		var i=0; 
		var opener_sheet_obj=opener.t5sheet1;
		var sheetObject=ip_sht_obj;     
		//opener_sheet_obj.RemoveAll();
		for (i=2; i<sheetObject.Rows; i++)
		{	
			var iRow=opener_sheet_obj.DataInsert(-1);
			for(j=0; j<=sheetObject.LastCol(); j++)
			{
				if (sheetObject.ColSaveName(j) != "")
				{   					
					for(k=0; k<=opener_sheet_obj.LastCol(); k++)
					{
						if (opener_sheet_obj.ColSaveName(k) == sheetObject.ColSaveName(j))
						{
							opener_sheet_obj.SetCellValue(iRow, opener_sheet_obj.ColSaveName(k),sheetObject.GetCellValue(i, sheetObject.ColSaveName(j)) ,0);
						}
					}
				}
			}		
		}
		opener_obj.document.form.fileImportFlg.value="Y";	
	}
	/**
	 * @param {ibsheet}		sheet	IBSheet
	 * @param {String}		ErrMsg	Error Message
	 */
	function setDtaCurrSht2OprSht1(sheet, ErrMsg){		
		if (sheet.RowCount()> 0)
		{ 
			var queryStr='';
			var opr_sht_idx=0;
			var opener_sheet_obj;
			queryStr=sheet.GetSaveString(false, false)+"&prefix=9";
			if (queryStr == null || queryStr == '') {
				//return false;
			} else {
				opr_sht_idx=2;
				opener_sheet_obj=opener.t5sheet1;
				tes_agmt_copy_rows_to(sheet, opener_sheet_obj, "", false, true, "9");				
			}		
			opener.form.fileImportFlg.value="Y";	
			ComClosePopup(); 
		}
	}
    /**
     * Sheet Excel Load <br>
     * 
     */
	function sheet_OnLoadExcel(sheet, result, code, msg){				
		if(isExceedMaxRow(msg))return;
		
		var k=sheetObjects[0].RowCount()+2;
		var sheetNo=9; 
		var j=0;
   		var daysTotalRate=0;
   		var rateTotalRate=0;
   		var total_rate_day="";
   		var total_rate_rate=""; 
   		var cellNullCheckString="";
   		var i=0; 		
		for(i=2;i<k;i++){				
			for(j=0;j<42+gap_st;j++){ 
				cellNullCheckString=cellNullCheckString+"|"+sheetObjects[0].GetCellValue(i,j);
			}
			if(cellNullCheckString=="||||||||||||||0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0|0||"){
				for(var jj=i;jj<k;jj++){
					sheetObjects[0].RowDelete(i, false);
				}
				break;
			} 
			cellNullCheckString="";
		}	  	
	
	}
    /**
     * Processing After the sheet retrieved.. <br>
     */
	function sheet1_OnSearchEnd(){		
		var k=sheetObjects[0].RowCount()+2;
		var vrfyFlg ;
		var vrfyRateSum=0;
		var vrfyDysSum=0;
		var errCount=0;
		var totalErrCount=0;
		strErrLine = "";
		
		for(var i=2;i<k;i++){}
	}
	
	function errLineAdd(row){
		if(strErrLine==""){
			strErrLine = strErrLine + sheetObjects[0].GetCellValue(row,'9seq');
		}else{
			if(strErrLine.indexOf(",")==-1){
				if(strErrLine.indexOf(sheetObjects[0].GetCellValue(row,'9seq'))==-1){
					strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row,'9seq');
				}
			}else{
				if(strErrLine.indexOf(","+sheetObjects[0].GetCellValue(row,'9seq'))==-1){
					strErrLine = strErrLine + "," + sheetObjects[0].GetCellValue(row,'9seq');
				}
			}
			
		}
		sheetObjects[0].SetCellBackColor(row, '9seq',"#FF0000");
	}
		
 