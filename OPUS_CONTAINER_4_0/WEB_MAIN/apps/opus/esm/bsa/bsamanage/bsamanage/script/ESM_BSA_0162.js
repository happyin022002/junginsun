/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0162.js
*@FileTitle  : Inquire/Edit Over Used Slot Price
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BSA_0162 : business script for ESM_BSA_0162
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var sheet_height=14; // sheet의 height
    var min_height;
    var first_load=true;  
    var selRow="";
    var selValue="";
    var selCol="";
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	var comboXml="";
    /*  Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick() {
    	var sheetObject=sheetObjects[0];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
//       			2014.08.06 김용습 - 재차 조회시 SEQ. 무너져서 조회되는 버그를 해결하기 위해 조회시 먼저 시트 내용이 지워지도록 함
       				sheetObjects[0].RemoveAll();
    				doActionIBSheet(sheetObject,formObject,IBSEARCH);
    				break;
    			case "btn_save":
    				doActionIBSheet(sheetObject,formObject,IBSAVE);
    				break;
    			case "btn_downexcel":
    				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
    				break;
    			case "btns_calendar1":
    				 var cal=new ComCalendar();
    				cal.select(formObject.txtSDate,  'yyyy-MM-dd');
    				break;
//    			case "btns_calendar2":
//    				 var cal = new ComCalendar();
//    				cal.select(formObject.txtEDate,  'yyyy-MM-dd');
//    				break;
    			case "bu_zoom_in":
//    		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("div_zoom_in").style.display="none";
    	            document.getElementById("div_zoom_out").style.display="inline";
//     				div_zoom_in.style.display="none";
//    				div_zoom_out.style.display="inline";
    				//parent.syncHeight();
    				
//    				2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
    				var rowcount = sheet1.RowCount(); // 시트의 열 개수
					var totalrowheight = 0; // 총 열 높이의 합 초기화												
					for(y=0; y<=rowcount; y++){
						totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
					}			
					if(totalrowheight+150 > 405){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
						sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
					}	
					
    				break;
    			case "bu_zoom_out":
    				sheet_height=getSheetHeightCnt(sheetObject,"MIN",0);
//    		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("div_zoom_in").style.display="inline";
    	            document.getElementById("div_zoom_out").style.display="none";
    				div_zoom_in.style.display="inline";
    				div_zoom_out.style.display="none";
    				//parent.syncHeight();
    				resizeSheet();
    				break;
    			case "btng_rowcopy":
    				doActionIBSheet(sheetObject,formObject,IBCOPYROW);
    				break;
    			case "btng_rowadd":
    				doActionIBSheet(sheetObject,formObject,IBINSERT);
    				break;	
    		} // end switch
    	} catch(e) {
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
    function setSheetObject(sheet_obj) {
    	 sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
 	function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
 	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage(head1,head2) {
    	for(i=0;i<sheetObjects.length;i++){
    		ComConfigSheet(sheetObjects[i]);
    		initSheet(sheetObjects[i],i+1,head1,head2);
    		ComEndConfigSheet(sheetObjects[i]);
    	}
    	loadingMode=true;
    	loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for(l=0;l<sheetObjects.length;l++){
			initIBCombo(sheetObjects[l]);			
		}
		loadingMode=false;
//		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
    
    
    /*function initControl() {
		  axon_event.addListener('keydown', 'ComKeyEnter', 'form');
     }*/ 
    
    
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo,head1,head2) {
    	var formObj=document.form;
    	var arrHead1="";
    	var arrHead2="";
    	var fixCnt=16; 
    	var varCnt=0;  
    	switch(sheetNo) {
    		case 1:  
    			if (head1 == "" && head2 == "") {
    				head1 = "|Initial Slots|Initial Slots|Initial Slots"
    							+ "|Sub lease(Charter-out)|Sub lease(Charter-out)|Sub lease(Charter-out)"
    							+ "|Cross-charter out(lease)|Cross-charter out(lease)|Cross-charter out(lease)";
    				head2 = "|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3";
    			}

    			arrHead1 = head1.replace(/(^\s*)/g, '').split("|");
    			arrHead2 = head2.replace(/(^\s*)/g, '').split("|");

    			varCnt = arrHead2.length - 1;
                with(sheetObj){
                //no support[check again]CLT if (first_load == true) { style.height=GetSheetHeight(sheet_height); }
              
                //no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
                var head0="";
                var varCnt=arrHead2.length - 1;
            	for (var cnt=0; cnt<varCnt; cnt++) {
            		head0=head0 + "|Rate (Income)";
            	}
                var HeadTitle0="Del|STS|group|SEQ|VVD|From|To|Trade|R.Lane|Dir.|From Port|To Port||Rate (Expense)|Rate (Expense)|Rate (Expense)"+head0;
                var HeadTitle1="Del|STS|group|SEQ|VVD|From|To|Trade|R.Lane|Dir.|From Port|To Port||Charter In|Charter In|Charter In"+ head1;
                var HeadTitle2="Del|STS|group|SEQ|VVD|From|To|Trade|R.Lane|Dir.|From Port|To Port||Initial Slots|Basic Chartered|Additional Chartered"+ head2;
                var cnt=0;
                
//              2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                HeadTitle0 = HeadTitle0 + "| |";
                HeadTitle1 = HeadTitle1 + "| |";
                HeadTitle2 = HeadTitle2 + "| |";

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:1 } );

                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                var headers = [ 
                                { Text:HeadTitle0, Align:"Center"},
                                { Text:HeadTitle1, Align:"Center"},
                                { Text:HeadTitle2, Align:"Center"}
                                ];
                InitHeaders(headers, info);

                var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
							  {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							  {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"grp",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|[0123456789]", InputCaseSensitive:1},
							  {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bsa_slt_prc_fm_dt",    KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
							  {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"bsa_slt_prc_to_dt",    KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
							  {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_port_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:5 },
							  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_port_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:5 },
							  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ovr_usd_slt_prc_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bzc_chtr_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"chtr_uc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"add_chtr_uc_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
                               
                			for (var n=0; n<varCnt; n++) {
                            	   cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"uc_amt"+n,   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
//                            	   SetCellBackColor(1, n,"#D3DBFF");
                            	   cnt++;
                            }           
                               
//                          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                               
                            InitColumns(cols);			
           			        SetEditable(1);
//           			        SetCellBackColor(1,cnt,"#D3DBFF");
           			        SetEditableColorDiff(0);
//           			        SetRangeBackColor(1, 13, 1, 60,"#8C8C8C");
//           			        SetRangeBackColor(1, 16, 1, 60,"#D3DBFF");
           			        SetHeaderRowHeight(10);
           			        if (first_load == true) {SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));}
               		    	first_load = false;
               		    	
               		    	SetSheetHeight(405);
               		    	resizeSheet();
               		    	
//                		  2014.11.20 김용습 - Port에 영어 대문자 자동 전환  기능 설정 (영 대문자가 아니면 유효하지 않은 코드라는 오류가 뜸)
                			var info2 = {AcceptKeys:"N|E" , InputCaseSensitive:1};				//20151209.MOD : AcceptKeys E->N,E
                			SetColProperty(0 ,"fm_port_cd" , info2);
                			SetColProperty(0 ,"to_port_cd" , info2);
               		    	
//            				2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
            				for(z=0; z<=cols.length; z++){
            					
            					if(GetCellValue(1,z) == "Charter In"){
            						SetCellBackColor(1, z, "#454545");
            						SetToolTipText(1, z, "Charter In");
            					}
            					
            					if(GetCellValue(1,z) == "Initial Slots"){
            						SetCellBackColor(1, z, "#050099");
            						SetToolTipText(1, z, "Initial Slots");
            					}
            					
            					if(GetCellValue(1,z) == "Basic Leased"){
            						SetCellBackColor(1, z, "#8041D9");
            						SetToolTipText(1, z, "Basic Leased");
            					}
            					
            					if(GetCellValue(1,z) == "Additional Leased"){
            						SetCellBackColor(1, z, "#99004C");
            						SetToolTipText(1, z, "Additional Leased");
            					}     
            				}         
            				
            				SetEditArrowBehavior(3); 
		        }
			break;
    	}
    }
    /**
 	 * Setting combo item
 	 */
 	function initCombo (comboObj, comboNo) {
 		with (comboObj) {
 			SetDropHeight(300);
 			comboObj.InsertItem(0, 'All' ,''); 
 			SetSelectIndex(0);
 			ValidChar(2,1);
 		}
 	}
 	/**
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return
	 */
	function initIBCombo(sheetObj){
		if (comboXml.length > 0){
			comboXml[0]=changeNameAndCode(comboXml[0]);
			ComSetIBCombo(sheetObj, comboXml[0], "trd_cd", true, 0);
		}
		if (comboXml.length > 2){
			comboXml[2]=changeNameAndCode(comboXml[2]);
			ComSetIBCombo(sheetObj, comboXml[2], "dir_cd",true,0);
		}
		if (comboXml.length > 3){
			comboXml[3]=changeNameAndCode(comboXml[3]);
			ComSetIBCombo(sheetObj, comboXml[3], "rlane_cd",true,0);
		}
	}
	
	/**
	 * 
	 * @param comboXml
	 * @returns
	 */
	function changeNameAndCode(comboXml){
		comboXml = ComReplaceStr(comboXml, "|name|", "|nm|");
		return ComReplaceStr(comboXml, "|code|", "|cd|");
	}
    // Handling the process realated with Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:      //조회
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value=SEARCHLIST;
    			ComOpenWait(true);
    			    setTimeout( function () {
		    			//var sXml=sheetObj.GetSearchData("ESM_BSA_0162GS.do",  coaFormQueryString(formObj,getParam(curPgmNo)));
		    			var sXml=sheetObj.GetSearchData("ESM_BSA_0162GS.do",  bsaFormString(formObj),getParam(curPgmNo));
		 			
		    			//var head1=GetEtcDataForExceptional(sXml,"head1");ComCoaGetEtcData
		    			//var head2=GetEtcDataForExceptional(sXml,"head2");
		 				var head1=ComGetEtcData(sXml,"head1");
		 				var head2=ComGetEtcData(sXml,"head2");
		    			if (head1 != "" && head2 != "") {
		    				sheetObj.SetVisible(false);
		//    				sheetObj.RemoveAll();
		    				sheetObjects[0] = sheetObjects[0].Reset();
		    				ComConfigSheet(sheetObjects[0]);	
		    				initSheet(sheetObjects[0], 1, head1, head2);
		    				initIBCombo(sheetObjects[0]);
		    				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
		    			}
		    			//sheetObj.InitHeadMode(false, false, false, true, false, false);
		    			ComOpenWait(false);
    				} , 100);
    			break;
    		case IBSAVE:        
    			if (!validateForm(sheetObj)) {
    				return false;
    			}
    			
    			//20150820.MOD/ADD
            	var sParam = sheetObj.GetSaveString(0);
            	if (!sheetObj.IsDataModified() && sParam == "") {
            		ComShowMessage("There is no contents to save.");
                	return false;
                }            	
    			formObj.f_cmd.value=MULTI;
    			sParam = sParam + "&" + FormQueryString(formObj);
                var sXml = sheetObj.GetSaveData("ESM_BSA_0162GS.do", sParam);
                sheetObj.LoadSaveData(sXml, {Sync:1});                
//    			sheetObj.DoSave("ESM_BSA_0162GS.do", bsaFormString(formObj,getParam(curPgmNo)), -1, true);		//SJH.20150210.MOD
                
                var result = ComGetEtcData(sXml, "result");
     			var transResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 
     			
     			if((result == "S"||result=="") && transResultKey == "S"){
     				doActionIBSheet(sheetObj,document.form,IBSEARCH);
    			}else if(result == "Dup"){
    				//SJH.20141105.MOD
    				ComShowCodeMessage('COM12115', '[ Trade, R.Lane, Dir., From Port, To Port, From, To ]');
    				if(ComTrim(formObj.txtSDate.value) == "") sheetObj.RemoveAll();
    				else doActionIBSheet(sheetObj,document.form,IBSEARCH);
     			}else if(result == "Over"){
    				//SJH.20141105.MOD
     				ComShowMessage("There are Some invalid Date(Overlapping Period). Please Check.");
     				if(ComTrim(formObj.txtSDate.value) == "") sheetObj.RemoveAll();
    				else doActionIBSheet(sheetObj,document.form,IBSEARCH);
     			}else{
     				ComShowCodeMessage("COM12151",'Data'); //Failed
     				if(ComTrim(formObj.txtSDate.value) == "") sheetObj.RemoveAll();
    				else doActionIBSheet(sheetObj,document.form,IBSEARCH);
     			}
    			break;
    		case IBDOWNEXCEL:   
    			//sheetObj.SpeedDown2Excel(-1);
                var excelType=selectDownExcelMethod(sheetObj);
//                switch (excelType) {
//                    case "AY":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel({ HiddenColumn:0,Merge:false});
//                    		}
//
//                         
//                        break;
//                    case "DY":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			 sheetObj.Down2Excel({ HiddenColumn:-1,Merge:false});
//                    		}
//
//                        
//                        break;
//                    case "AN":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel({ HiddenColumn:0});
//                    		}
//
//                         
//                        break;
//                    case "DN":
//                    	if(sheetObj.RowCount() < 1){//no data
//                    		ComShowCodeMessage("COM132501");
//                    		}else{
//                    			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
//                    		}
//
//                         
//                        break;
//                }               
    			break;
    		case IBINSERT:   
    			with(sheetObj) {
    			    var row=0;
    			    row=DataInsert(-1);
    			    SetCellValue(row, "seq","",0);
    			    
    			}
    			break;	
    		case IBCOPYROW:      
    			with(sheetObj) {
        			if (RowCount()> 0) {
        				var row=DataCopy(false);
        				SetCellValue(row, "seq","",0);
        				SetCellValue(row, "ovr_usd_slt_prc_seq","",0);
        				
                		//20160119.ADD, 20160317.MOD : 기준 앞에만 비활성화.
        				var grpRow=getFindRows(sheet1, row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(arrRow[i]) < parseInt(row)){									
									SetCellEditable(arrRow[i],"bsa_slt_prc_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"bsa_slt_prc_to_dt",0);	
									SetCellEditable(row,"bsa_slt_prc_fm_dt",1);
									SetCellEditable(row,"bsa_slt_prc_to_dt",1);										
								}
							}
						}    				
            		}
    			}
    			break;
    	}
    }
    
    
	function callBackExcelMethod(excelType){
		 var sheetObj = sheet1;
	      switch (excelType) {
	      case "AY":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
	      			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
	      		}
	
	      	
	          break;
	      case "DY":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
	      			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
	      		}
	
	      	
	          break;
	      case "AN":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
	      			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
	      		}
	
	      	
	          break;
	      case "DN":
	      	if(sheetObj.RowCount() < 1){//no data
	      		ComShowCodeMessage("COM132501");
	      		}else{
	      			sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
	      		}
	          break;
	  }         
      
	}   
    
    
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//Setting and Checking BG color of all row.
    		SetColBackColor("ibflag","#EFEBEF");
    		sheetObj.SetSumText(0, 'ibflag', "TOTAL");
    		SetColBackColor("seq","#EFEBEF");
    	}
    	 //Making the column hidden in case isExcludZero is checked and total value is zero.
    	//sheetObj.RenderSheet(0);
        if(document.form.isExcludZero.checked) {
//          sheetObj.SetFrozenCol(1);
	      	sheetObj.RenderSheet(0);
	      	var count = 0;
      	  
//  		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//  		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
	    	for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
	  			if(k >= 10){ 
	  				sum = sum + sheetObj.GetSumValue(0,k);
	  			}    			    			
	    	}
  		
//  		2014.12.05 김용습
	  		if(sum==0){
	  			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
	  		}else{
	  			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
	  		}
	        	
//      	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
	  		for(var k=13; k<=sheetObj.LastCol()-1; k++) {
          	
//            2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
	          if(k>=16){
	          		sheetObj.SetColHidden(k,0);	
	          }       
        	  //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
        	  if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                 sheetObj.SetColHidden(k,1);
        	  	 sheetObj.SetColWidth(k,0);
        	  }else if(parseFloat(sheetObj.GetSumValue(0,k)) != 0.00) {
				sheetObj.SetColHidden(k, 0);				
				//sheetObj.SetColWidth(k,60);
				count = k ;
			  }
          }
      	  sheetObj.RenderSheet(1);
		  if(count > 12){
			  sheetObj.SetFrozenCol(12);
		  }
      	  
        } else {
          sheetObj.RenderSheet(0);
          
//        2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
      	  sheetObj.SetColHidden(sheetObj.LastCol(),1);
      	
//        2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
      	  for(var k=0; k<=sheetObj.LastCol()-1; k++) {
        	  //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
        	  if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                  sheetObj.SetColHidden(k,0);
        	  }
        	  if(k>=4){
        		  if(sheetObj.GetCellValue(0,k) != "Trade"){ // Trade 컬럼의 넓이는 조정하지 않음
        			  if(sheetObj.GetCellValue(0,k) != "R.Lane"){ // R.Lane 컬럼의 넓이는 조정하지 않음
        				  if(sheetObj.GetCellValue(0,k) != "Dir."){ // Dir. 컬럼의 넓이는 조정하지 않음
        				  sheetObj.SetColWidth(k,80);
        				  }
        			  }        			    
        		  }        		  
        	  }        	  
          }	      
          sheetObj.RenderSheet(1);          
          sheetObj.SetFrozenCol(12);
        }
        //sheetObj.RenderSheet(1);
        
        for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
        	if(sheetObj.GetCellValue(i, "bsa_slt_prc_fm_dt") > sheetObj.GetCellValue(i, "bsa_slt_prc_to_dt")){
				ComShowMessage("There are some invalid date(From Date is greater than To Date). Please check.");
				sheetObj.SelectCell(i, "seq");
				break;
			}
        }
        
//      2014.12.05 김용습 - 헤더 색갈 및 툴팁 적용 (검색 후 헤더가 Joint Operating Carrier's Slot Price에서 Basic Slots로 변경되어 아래 소스 삽입)
		for(q=0; q<=sheet1.LastCol(); q++){
			
			if(sheet1.GetCellValue(0,q) == "Basic Slots"){
				sheet1.SetCellBackColor(0, q, "#050099");
				sheet1.SetToolTipText(0, q, "Basic Slots");
			}   
		}
    }
    /**
     * Handling in case of changing sheet data
     * Setting First ETD DT in case of changing VVD
     */    
    function sheet1_OnChange(sheetObj,Row,Col,Value) {
        var formObj=document.form;
        var param="";
    	with(sheetObj){
    		// Cotrolling period and status 
    		if (ColSaveName(Col) == "bsa_slt_prc_fm_dt") {
    			if(GetCellValue(Row-1,"grp") == GetCellValue(Row,"grp")) {
        			SetCellValue(Row-1,"bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
//        			Cellvalue2(Row-1, "ibflag")="U";    
    		    }
		    	if(GetCellValue(Row,"grp") == GetCellValue(Row+1,"grp"))  {
		    		SetCellValue(Row,"bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"bsa_slt_prc_fm_dt"),-1),0);
    			}
    		}
    		//SJH.20150211.MOD : 막음
//    		if (ColSaveName(Col) == "bsa_slt_prc_to_dt" && Row+1 < LastRow()&& GetCellValue(Row+1,"grp") == GetCellValue(Row,"grp")) {
//    			SetCellValue(Row+1,"bsa_slt_prc_fm_dt",getOffsetDate(Value,1),0);
//    		}
        	//SJH.20150209.ADD
    		if (ColSaveName(Col) == "vvd_cd" || ColSaveName(Col) == "dir_cd") {
    			selRow=Row;
    			//SJH.20150209.ADD
    			if(GetCellValue(selRow,"dir_cd") != "" && GetCellValue(selRow,"vvd_cd") != "" ) {
    				if(GetCellValue(selRow,"dir_cd") != GetCellValue(selRow,"vvd_cd").substring(GetCellValue(selRow,"vvd_cd").length-1)) {
    					alert("VVD's Last Element is not the same as Dir.");
    					if(ColSaveName(Col) == "vvd_cd") SetCellValue(selRow,"vvd_cd","",0);
    					else SetCellValue(selRow,"dir_cd","",0);
    					ComOpenWait(false);
    					return false;
    				}
    			}  
    		}
    		//SJH.20150211.ADD : TO > FROM 이어야함.
    		if (ColSaveName(Col) == "bsa_slt_prc_fm_dt" || ColSaveName(Col) == "bsa_slt_prc_to_dt") {        			
    			selRow=Row;
				if(GetCellValue(selRow,"bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"bsa_slt_prc_to_dt") != "" ) {
					if ( parseInt(GetCellValue(selRow, "bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"bsa_slt_prc_to_dt")) ) {
			  	 		alert("From Date is greater than To Date.");
			  	 		SetCellValue(selRow,"bsa_slt_prc_to_dt","",0);
						ComOpenWait(false);
						return false;
					}
				} 
    		}    		
    	}
   	
    	// Setting First ETD DT in case of changing VVD.
    	if (sheetObj.ColSaveName(Col) == "vvd_cd") {
			selRow=Row;
			selValue=Value;
			param=param+"f_cmd="+SEARCHLIST02;
			param=param+"&vvd_cd="+sheetObj.GetCellValue(Row,Col);
			param=param+"&code=etdDt";
 			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
			getEdtDate(etdDt);
    	}
    	if (sheetObj.ColSaveName(Col) == "trd_cd") {
    		ibTrade_OnChange(sheetObj, Row, Col);
		}
    	if (sheetObj.ColSaveName(Col) == "fm_port_cd" || sheetObj.ColSaveName(Col) == "to_port_cd") {
    		selRow=Row;
    		selCol=Col;
    		selValue=Value;
    		param="f_cmd="+SEARCHLIST02;
    		param=param+"&port_cd="+sheetObj.GetCellValue(Row,Col);
    		param=param+"&code=locCd";
     		var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
    		var locCd=GetEtcDataForExceptional(sXml, "locCd", "0");
    		isValidLocation(locCd);
    	}
    	
    }
    //VVD --> edt-date
    function getEdtDate(result) {
    	var sheetObj=sheetObjects[0];
    	var tmpRow=0;
    	if(result == null || result == "" || result == "null"){
    		ComShowMessage(ComGetMsg('BSA10027',selValue)); 
    		sheetObj.SelectCell(selRow,"vvd_cd",true);
    	} else {
    		sheetObj.SetCellValue(selRow,"bsa_slt_prc_fm_dt",result);
    	}
    }
    function isValidLocation(result) {
        var sheetObj=sheetObjects[0];
        if(!result){
    		ComShowMessage(ComGetMsg('BSA10004',selValue)); 
        	sheetObj.SelectCell(selRow,selCol,true);
    	}
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj) {
    	var sTitle = new Array();
    	with(sheetObj){
    		//SJH.20150209.ADD
    		for(var cRow = HeaderRows(); cRow <= LastRow(); cRow++) {
   			 if(GetCellValue(cRow, "ibflag") == "I" || GetCellValue(cRow, "ibflag") == "U"){
   			    //1--- Keyfield Validation : 20150820.ADD : 4003, 4001 적용
  				for ( var Col = 0 ; Col <= LastCol() ; Col++) {
					if (GetCellProperty(cRow, Col, "KeyField") == 1) {
						if (ComTrimAll(GetCellText(cRow, Col)).length == 0) {							
		   		    		ComShowMessage(ComGetMsg('BSA10002',GetCellValue(0, ColSaveName(Col)).replace("\n"," "))); 
		   		        	SelectCell(cRow, Col, true);   					
		   					return false;
  						} 	  								
					}
				}  				
   	    		for ( var z = HeaderRows(); z <= LastRow(); z++) {
   	    			if (z != cRow &&
   	    				GetCellValue(z,"trd_cd") == GetCellValue(cRow,"trd_cd") && 
   	    				GetCellValue(z,"rlane_cd") == GetCellValue(cRow,"rlane_cd") && 
   	    				GetCellValue(z,"dir_cd") == GetCellValue(cRow,"dir_cd") && 
   	    				GetCellValue(z,"fm_port_cd") == GetCellValue(cRow,"fm_port_cd") && 
   	    				GetCellValue(z,"to_port_cd") == GetCellValue(cRow,"to_port_cd")) {
   	    				if(GetCellValue(z, "ibflag") != "D") {								//20150820.ADD
   	   						if (GetCellValue(cRow, "bsa_slt_prc_fm_dt").length > 0) {
   	   							if (parseInt(GetCellValue(cRow, "bsa_slt_prc_fm_dt")) >= parseInt(GetCellValue(z,"bsa_slt_prc_fm_dt")) &&
   	   								parseInt(GetCellValue(cRow, "bsa_slt_prc_fm_dt")) <= parseInt(GetCellValue(z,"bsa_slt_prc_to_dt"))) {
   	   								 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
   	   					  	 		 return false; 
   	   							}
   	   						}
   	   						//SJH.20150211.ADD
   	   						if (GetCellValue(cRow, "bsa_slt_prc_to_dt").length > 0) {
   	   							if (parseInt(GetCellValue(cRow, "bsa_slt_prc_to_dt")) >= parseInt(GetCellValue(z,"bsa_slt_prc_fm_dt")) &&
   	   								parseInt(GetCellValue(cRow, "bsa_slt_prc_to_dt")) <= parseInt(GetCellValue(z,"bsa_slt_prc_to_dt"))) {
   	   							 	 alert("Effective Date can not be Duplicate. ( "+(cRow-HeaderRows()+1)+" Row )");
   	   					  	 		 return false; 
   	   							}
   	   						}     	    					
   	    				}
   	    			}
   	    		}  	
   		    }  				 
   		}	    		
    	}
    	return true;
    }
    /**
     * handling process for input validation
     */
    function validateCond(formObj) {
    	with(formObj){
    		if (ComTrim(txtSDate.value) == "") {
    			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
    			//txtSDate.focus();
    			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
    			return false;
    		}
//    		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
//    			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
//    				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
//    				//txtEDate.focus();
//    				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
//    				return false;
//    			}
//    		}
    	}
    	return true;
    }
    /**
     * showing R.Lane with using ifram
     */
    function cobTrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		sheetObj.SetWaitImageVisible(0);
		if(comboObj.GetSelectText()!= ""){
			trd_cd=comboObj.GetSelectCode();
			param="f_cmd="+SEARCHLIST01;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=rLane";
 			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], cobLane, "code", "code");
			cobLane.SetSelectIndex(0);
		}
		sheetObj.SetWaitImageVisible(1);
    }
    function ibTrade_OnChange(sheetObj, row, col) {
 		if (loadingMode == true) return; 
 		var param="";
 		var trd_cd="";
 		trd_cd=sheetObj.GetCellValue(row, col);
		sheetObj.SetWaitImageVisible(0);
		if(trd_cd != ""){
			param="f_cmd="+SEARCHLIST02;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=ibLane";
 			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var rlane=GetEtcDataForExceptional(sXml, "trdCd", "0");
			sheetObj.CellComboItem(row,"rlane_cd", {ComboText:rlane, ComboCode:rlane} );
		}
		sheetObj.SetWaitImageVisible(1);
 	}
    function loadCombo() {
    	var formObj=document.form;
		var sXml=formObj.sXml.value;
		var arrXml=sXml.split("|$$|");
		comboXml=arrXml;
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
		document.form.sXml.value="";
    }
    
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    
//  2014.12.26 김용습 - 아래 4개의 moveTo~ 펑션은 라디오 버튼으로 컬럼을 이동하기 위해 만들어진 것들임
    function moveToCharterIn(){
    	sheet1.SetLeftCol(13);
    }
    
    function moveToBasicSlots(){
    	sheet1.SetLeftCol(16);
    }
    
    function moveToBasicLeased(){    	
    	for(z=16; z<=sheet1.LastCol(); z++){
    		if(sheet1.GetCellValue(1,z) == "Basic Leased"){
    			var fistColofBasicLeased = z;
    			break;
    		}
    	}    	    	
    	sheet1.SetLeftCol(fistColofBasicLeased);
    }
    
    function moveToAdditionalLeased(){
    	for(z=16; z<=sheet1.LastCol(); z++){
    		if(sheet1.GetCellValue(1,z) == "Additional Leased"){
    			var fistColofAddionalLeased = z;
    			break;
    		}
    	}    	    	
    	sheet1.SetLeftCol(fistColofAddionalLeased);
    }
    
	 //Grouping별 Max값을 추출 : 20160119.ADD
//	 function getFindRow(sheetObj) {
//	 	var bsa_seq=0;
//	 	var tmpSeq=0;
//	 	var tmpRow=0;
//	 	var maxRow=0;
//	 	with(sheetObj) {
//	 		if (GetSelectRow()> 0) {
//	 			tmpRow=FindText("grp", GetCellValue(GetSelectRow(),"grp"), 0);
//	 			if (tmpRow == -1) {
//	 			} else {
//		 			for (var i=tmpRow; i<LastRow(); i++) {	 							
//	 					if(GetCellValue(i,"seq") != "") {
//	 						tmpSeq=parseInt(GetCellValue(i,"seq"));
//		 					if (bsa_seq <= tmpSeq) {
//		 						bsa_seq=tmpSeq;  //최대값
//		 					}	 						
//	 					}
//		 			} //end of for	 
//		 			maxRow=FindText("seq", String(bsa_seq), 0);
//	 			}
//	 		}
//	 	} //end of with
//	 	return maxRow;
//	 }
	 //20160317.ADD : 기준 앞에만 비활성화.
	 function getFindRows(sheetObj, Row) {
		var rtnRow="";	
		var col1=0;
		var tmp=0;
		with(sheetObj) {
			for (var i=HeaderRows(); i<LastRow(); i++) {				
				col1=FindText("grp", GetCellValue(Row,"grp"), tmp);
				if (col1 == -1) { 
					rtnRow = rtnRow.substring(0, rtnRow.length-1);
					break; 
				} //Not Found
				SetCellEditable(col1,"bsa_slt_prc_fm_dt",1);
				SetCellEditable(col1,"bsa_slt_prc_to_dt",1);
				rtnRow=rtnRow+col1+",";
				tmp=col1 + 1;
			}
		}
		return rtnRow;
	 }	 
    