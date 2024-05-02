﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : ESM_BSA_028.js
*@FileTitle  : Inquire/Edit Slot-Cost
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Following code is added code to make JSDoc ------------------*/
	/**
	 * @extends 
	 * @class ESM_BSA_0028 : business script for ESM_BSA_0028
	 */
	//var tabObjects = new Array();
	var sheetObjects=new Array();
	var sheetCnt=0;
	var sheet_height=20; // height of sheet
	var first_load1=true;  //setting height at first
	var first_load2=true;
	var first_load3=true;
	var first_load4=true;
	var first_load5=true;
	var first_load6=true;	//20150514.ADD
	var selRow="";
	var selValue="";
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	var comboXml="";
	var sheet_height1=19;
	var sheet_height2=19;
	var sheet_height3=19;
	var sheet_height4=19;
	var sheet_height5=19;
	var sheet_height6=19;			//20150514.ADD
	/* Event handler processing by button click event */
	document.onclick=processButtonClick;
	/* Event handler processing by button name */
	function processButtonClick() {
		var sheetObject0=sheetObjects[0];
		var sheetObject1=sheetObjects[1];
		var sheetObject2=sheetObjects[2];
		var sheetObject3=sheetObjects[3];
		var sheetObject4=sheetObjects[4];
		var sheetObject5=sheetObjects[5];			//20150514.ADD
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_retrieve": 
					
					//sheet1.LoadSearchData("<SHEET><DATA TOTAL=\"1\"><TR>  <TD></TD>  <TD>R</TD>  <TD>1</TD>  <TD>3</TD>  <TD>3</TD>  <TD>3</TD>  <TD></TD>  <TD>20130201</TD>  <TD>99991231</TD>  <TD>AES</TD>  <TD>AE1AE</TD>  <TD>E</TD>  <TD>017</TD>  <TD BGCOLOR='#FFFF00'>1000</TD>  <TD>1000</TD><TD>1000</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>100</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>1000</TD><TD>0</TD><TD>0</TD><TD>1200</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>10</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>1200</TD><TD>0</TD><TD>0</TD><TD>1200</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>0</TD><TD>20</TD><TD>0</TD><TD>0</TD><TD>1200</TD><TD>0</TD><TD>0</TD></TR></DATA></SHEET>");
					
					if(formObject.rdoType[0].checked){
						doActionIBSheet(sheet1,formObject,IBSEARCH);	
					} else if(formObject.rdoType[1].checked){						//20150514.ADD
						doActionIBSheet5(sheetObject5,formObject,IBSEARCH);
					} else if(formObject.rdoType[2].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet1(sheetObject1,formObject,IBSEARCH);	
						} else if(formObject.rdoType2_2.checked){
							doActionIBSheet2(sheetObject2,formObject,IBSEARCH);	
						}
					}else if(formObject.rdoType[3].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet3(sheetObject3,formObject,IBSEARCH);	
						} else if(formObject.rdoType2_2.checked){
							doActionIBSheet4(sheetObject4,formObject,IBSEARCH);	
						}		
					}  
					
					resizeSheet();
					break;
				case "btn_save":
					if(formObject.rdoType[0].checked){
						doActionIBSheet(sheet1,formObject,IBSAVE);	
					}else if(formObject.rdoType[1].checked){						//20150514.ADD
						doActionIBSheet5(sheetObject5,formObject,IBSAVE);
					}else if(formObject.rdoType[2].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet1(sheetObject1,formObject,IBSAVE);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet2(sheetObject2,formObject,IBSAVE);	
						}	
					}else if(formObject.rdoType[3].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet3(sheetObject3,formObject,IBSAVE);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet4(sheetObject4,formObject,IBSAVE);	
						}		
					}  
					break;
				case "btn_downexcel":
					if(formObject.rdoType[0].checked){
						doActionIBSheet(sheet1,formObject,IBDOWNEXCEL);
					}else if(formObject.rdoType[1].checked){						//20150514.ADD
						doActionIBSheet5(sheetObject5,formObject,IBDOWNEXCEL);
					}else if(formObject.rdoType[2].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet1(sheetObject1,formObject,IBDOWNEXCEL);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet2(sheetObject2,formObject,IBDOWNEXCEL);	
						}	
					}else if(formObject.rdoType[3].checked){						//20150514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet3(sheetObject3,formObject,IBDOWNEXCEL);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet4(sheetObject4,formObject,IBDOWNEXCEL);	
						}		
					}  
					break;
				case "btns_calendar1":
					 var cal=new ComCalendar();
					cal.select(formObject.txtSDate,  'yyyy-MM-dd');
					break;
//				case "btns_calendar2":
//					 var cal = new ComCalendar();
//					cal.select(formObject.txtEDate,  'yyyy-MM-dd');
//					break;
				case "div_zoom_in":
					sheet_height=getSheetHeightCnt(sheet1,"MAX",1);					
					$('#div_zoom_in').hide();
					$('#div_zoom_out').show();
					resizeSheet();
					break;
				case "div_zoom_out":
					sheet_height=getSheetHeightCnt(sheet1,"MIN",0);
					$('#div_zoom_in').show();
					$('#div_zoom_out').hide();

//					2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
						if(formObject.rdoType[0].checked||formObject.rdoType[1].checked){			//20150514.MOD,ADD
								var sheetObj;
								if(formObject.rdoType[0].checked) {									//20150520.ADD
									sheetObj = sheet1;
								} else {
									sheetObj = sheet6;
								}
								var rowcount = sheetObj.RowCount(); // 시트의 열 개수
								var totalrowheight = 0; // 총 열 높이의 합 초기화												
								for(y=0; y<=rowcount; y++){
									totalrowheight = totalrowheight + sheetObj.GetRowHeight(y); // 모든 열의 높이의 합 구하기
								}			
								if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
									sheetObj.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
								}
							}		
							else if(formObject.rdoType[2].checked){									//20150514.MOD
									if(formObject.rdoType2_1.checked){
										var rowcount = sheet2.RowCount(); // 시트의 열 개수
										var totalrowheight = 0; // 총 열 높이의 합 초기화												
										for(y=0; y<=rowcount; y++){
											totalrowheight = totalrowheight + sheet2.GetRowHeight(y); // 모든 열의 높이의 합 구하기
										}						
										if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
											sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
										}	
									}
									else if(formObject.rdoType2_2.checked){
										var rowcount = sheet3.RowCount(); // 시트의 열 개수
										var totalrowheight = 0; // 총 열 높이의 합 초기화												
										for(y=0; y<=rowcount; y++){
											totalrowheight = totalrowheight + sheet3.GetRowHeight(y); // 모든 열의 높이의 합 구하기
										}						
										if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
											sheet3.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
										}	
									}	
							}else if(formObject.rdoType[3].checked){								//20150514.MOD
									if(formObject.rdoType2_1.checked){
										var rowcount = sheet4.RowCount(); // 시트의 열 개수
										var totalrowheight = 0; // 총 열 높이의 합 초기화												
										for(y=0; y<=rowcount; y++){
											totalrowheight = totalrowheight + sheet4.GetRowHeight(y); // 모든 열의 높이의 합 구하기
										}						
										if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
											sheet4.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
										}
									}
									else if(formObject.rdoType2_2.checked){
										var rowcount = sheet5.RowCount(); // 시트의 열 개수
										var totalrowheight = 0; // 총 열 높이의 합 초기화												
										for(y=0; y<=rowcount; y++){
											totalrowheight = totalrowheight + sheet5.GetRowHeight(y); // 모든 열의 높이의 합 구하기
										}						
										if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
											sheet5.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
										}
									}		
							} 
					break;
				case "btng_rowcopy":
					if(formObject.rdoType[0].checked){
						doActionIBSheet(sheetObjects[0],formObject,IBINSERT);	
					}else if(formObject.rdoType[1].checked){						//20151514.ADD
						doActionIBSheet5(sheetObject5,formObject,IBINSERT);
					}else if(formObject.rdoType[2].checked){						//20151514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet1(sheetObject1,formObject,IBCOPYROW);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet2(sheetObject2,formObject,IBCOPYROW);	
						}	
					}else if(formObject.rdoType[3].checked){						//20151514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet3(sheetObject3,formObject,IBCOPYROW);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet4(sheetObject4,formObject,IBCOPYROW);	
						}		
					}  
					break;
				case "btng_rowadd":
					if(formObject.rdoType[2].checked){								//20151514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet1(sheetObject1,formObject,IBINSERT);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet2(sheetObject2,formObject,IBINSERT);	
						}	
					}else if(formObject.rdoType[3].checked){						//20151514.MOD
						if(formObject.rdoType2_1.checked){
							doActionIBSheet3(sheetObject3,formObject,IBINSERT);	
						}else if(formObject.rdoType2_2.checked){
							doActionIBSheet4(sheetObject4,formObject,IBINSERT);	
						}		
					}  
					break;	
				case "btn_LoadExcel":
					if(formObject.rdoType[1].checked){								//20151514.MOD
						doActionIBSheet5(sheetObject5,formObject,IBLOADEXCEL);
					}
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
	function loadPage(head1,head2,head3) {
		for(l=0;l<sheetObjects.length;l++){
			ComConfigSheet(sheetObjects[l]);
			
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
            document.getElementById("tr_slot").style.display="inline";
            document.getElementById("tr_rf_l").style.display="inline";
            document.getElementById("tr_rf_s").style.display="inline";
            document.getElementById("tr_over_l").style.display="inline";
            document.getElementById("tr_over_s").style.display="inline";    
            document.getElementById("tr_op_slot").style.display="inline";			//20150514.ADD
//		    tr_slot.style.display="inline";
//			tr_rf_l.style.display="inline";
//			tr_rf_s.style.display="inline";
//		    tr_over_l.style.display="inline";
//		    tr_over_s.style.display="inline";
		    
			initSheet(sheetObjects[l],l+1,head1,head2,head3);
			
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
            document.getElementById("tr_rf_l").style.display="none";
            document.getElementById("tr_rf_s").style.display="none";
            document.getElementById("tr_over_l").style.display="none";
            document.getElementById("tr_over_s").style.display="none";
            document.getElementById("tr_op_slot").style.display="none";				//20150520.ADD
//			tr_rf_l.style.display="none";
//			tr_rf_s.style.display="none";
//		    tr_over_l.style.display="none";
//		    tr_over_s.style.display="none"; 
            
			ComEndConfigSheet(sheetObjects[l]);
		}
		loadingMode=true;		
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		// Handling multi combo
		loadingMode=true;
		loadCombo();
		for(k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],comboObjects[k].id);
		}
		for(l=0;l<sheetObjects.length;l++){
			initIBCombo(sheetObjects[l]);			
		}
		loadingMode=false;
		axon_event.addListener('keydown', '', 'form'); 
		resizeSheet();
	}
	function loadCombo() {
		var formObj=document.form;
	 	var sXml=formObj.sXml.value;
	 	var arrXml=sXml.split("|$$|");
	 	comboXml=arrXml;
		var rtnArr=null;
		var divStr="";
		var codeArr=null;
		var nameArr=null;
		var checked="";
	 	if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
		if (arrXml.length > 2)
			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
		if (arrXml.length > 6){
			rtnArr=ComXml2ComboString(arrXml[6], "code", "name");
			codeArr=null;
			nameArr=null;
			codeArr=rtnArr[0].split("|");
			nameArr=rtnArr[1].split("|");
			divStr="";
			for(var i=0; i<codeArr.length; i++){
				if (i == 0)
					checked="checked";
				else
					checked="";
				divStr += "\n";
				divStr += "<input type=\"radio\" name=\"rdoType\"  id=\"rdoType"+[i]+"\" value=\""+codeArr[i]+"\" class=\"trans\" onClick=\"changeSheet(this.value);\""+checked+"><label for=\"rdoType"+[i]+"\">"+nameArr[i]+"</label>";
				if(i < codeArr.length)
					divStr += "&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_ui_slot").innerHTML="<div id=\"div_ui_slot\">"+ divStr +"</div>";
		}
	 	document.form.sXml.value="";
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo,head1,head2,head3) {
		var formObj=document.form;
		var head0="";
		var arrHead1="";
		var arrHead2="";
		var arrHead3="";
		var arrHead4="";
		var arrHead5="";
		var arrHead6="";			//20150514.ADD
		var fixCnt=17; // fixed length
		var varCnt=0;  // variable length
		switch(sheetNo) {
        case 1:      //sheet1 init
        	if (head1 == "" && head2 == "") {
        		head1="|Joint Operation (Charter-out)|Joint Operation (Charter-out)|Joint Operation (Charter-out)"+ "|Sub lease(Charter-out)|Sub lease(Charter-out)|Sub lease(Charter-out)"+ "|Cross-charter out(lease)|Cross-charter out(lease)|Cross-charter out(lease)";
        		head2="|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3";
        	}
        	
//			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
			var arrayHead2=head2.split("|");
			
			head2 = "";
			
			for(j=0; j < arrayHead2.length; j++) {
					if(j%5 == 0 && j != arrayHead2.length - 1){
						arrayHead2[j] = arrayHead2[j] + "|" ;
					}else if(j%5 == 1 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + arrayHead2[j] + " |" ;
					}else if(j%5 == 2 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + arrayHead2[j] + " " + " |" ;
					}else if(j%5 == 3 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + " " + arrayHead2[j] + " " + " " + " |" ;
					}else if(j%5 == 4 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + " " + " " + arrayHead2[j] + " " + " " + " " + " |" ;
					}else if(j == arrayHead2.length - 1){ // 마지막 번째일때
						arrayHead2[j] = " "+ " "+ " "+ " "+ " " + arrayHead2[j] + " "+ " "+ " "+ " " + " " ;
						head2 = head2 + arrayHead2[j];
						break;
					}
					
					head2 = head2 + arrayHead2[j];
				
			}        	
        	
        	if(head1 != "undefined" || head1.length>0)
        		arrHead1=head1.replace(/(^\s*)/g, '').split("|");
        	if(head2 != "undefined" || head2.length>0)
        		arrHead2=head2.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrHead2.length - 1;
        	with(sheetObj){
        	for (var cnt=0; cnt<varCnt; cnt++) {
        		head0=head0 + "|Rate (Income)";
        	}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|★|Rate (Expense)|Rate (Expense)|Rate (Expense)"+ head0;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|★|Initial Slots|Basic Chartered|Additional Chartered"+ head1;
        	var HeadTitle2="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|★|Company | Company | Company"+ head2;
        	var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| |";
            HeadTitle1 = HeadTitle1 + "| |";
            
        	SetConfig({ SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:0 } );
        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
        	InitHeaders(headers, info);
        	var cols = [{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
			            {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Int",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1 , AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9},
						{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
						{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_cost_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"M_co_bfr_sub_capa",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"M_sub_chtr_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"M_crs_chtr_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
            for (var n=0; n<varCnt; n++) {
            	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            	cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_yellow_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
            
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

            InitColumns(cols);
            SetEditable(1);
            //SetEditableColorDiff(0);
//            SetColHidden("M_yellow_cnt",1);
            //SetRangeBackColor(1, 13, 2, 15 + varCnt,"#000000");
            SetHeaderRowHeight(10);
		      if (first_load1 == true) {
		    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
		      }
		      first_load1=false;
		      for (n=0; n < varCnt; n++) {
		    	  if (arrHead1[n+1] == "Basic Leased" || arrHead1[n+1] == "Additional Leased") {
		    		  //SetCellBackColor(2, cnt, "#C4D2FF");
		    	  } else {
		    		  //SetCellBackColor(2, cnt, "#D3DBFF");
		    	  }
		    	  cnt++;
		      }
//		      SetSheetHeight(448);
		      
//				2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
				for(z=16; z<=cnt; z++){ // rate (income)부터 적용하므로 z(컬럼번호)를 16으로 설정
					if(GetCellValue(0,z) == "Initial Slots"){
						SetCellBackColor(0, z, "#454545");
						SetToolTipText(0, z, "Initial Slots");
					}else if(GetCellValue(1,z) == "Initial Slots"){
						SetCellBackColor(1, z, "#454545");
						SetToolTipText(1, z, "Initial Slots");
					}else if(GetCellValue(1,z) == "Basic Leased"){
						SetCellBackColor(1, z, "#050099");
						SetToolTipText(1, z, "Basic Leased");
					}else if(GetCellValue(1,z) == "Additional Leased"){
						SetCellBackColor(1, z, "#99004C");
						SetToolTipText(1, z, "Additional Leased");
					}
					
					if(GetCellValue(0,z) == "Rate (Income)"){
						SetToolTipText(0, z, "Rate (Income)");
					}
					
					if(GetCellValue(0,z) == "Rate (Expense)"){
						SetToolTipText(0, z, "Rate (Expense)");
					}	
				}
				
				SetEditArrowBehavior(3); 
				
        	}
		break;
        case 2:	//sheet2 init
        	if (head3 == "" ) 
        	{head3="|CRR1|CRR2|CRR3|CRR4|CRR5";}
        	
//			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
			var arrayHead3=head3.split("|");
			
			head3 = "";
			
			for(j=0; j < arrayHead3.length; j++) {
					if(j%5 == 0 && j != arrayHead3.length - 1){
						arrayHead3[j] = arrayHead3[j] + "|" ;
					}else if(j%5 == 1 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + arrayHead3[j] + " |" ;
					}else if(j%5 == 2 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + arrayHead3[j] + " " + " |" ;
					}else if(j%5 == 3 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + arrayHead3[j] + " " + " " + " |" ;
					}else if(j%5 == 4 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + " " + arrayHead3[j] + " " + " " + " " + " |" ;
					}else if(j == arrayHead3.length - 1){ // 마지막 번째일때
						arrayHead3[j] = " "+ " "+ " "+ " "+ " " + arrayHead3[j] + " "+ " "+ " "+ " " + " " ;
						head3 = head3 + arrayHead3[j];
						break;
					}
					
					head3 = head3 + arrayHead3[j];
				
			}  
			
        	arrHead3=head3.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrHead3.length ;
        	//style.height=GetSheetHeight(sheet_height) ;
        	var head0="";
        	 with(sheetObj){
        	for(i=0;i<=varCnt; i++)
        	{head0=head0 + "|Rate";}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Unit|★"+ head0;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Unit|★|"+ head3;
        	var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| |";
            HeadTitle1 = HeadTitle1 + "| |";

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:14, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
				{Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1 , AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9},
				{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_unit",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_cost_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        	for (var n=0; n<varCnt; n++) {
        		cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
        	}
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            
        	InitColumns(cols);
        	SetEditable(1);
        	//SetRangeBackColor(1, 13, 2, 15 + varCnt,"#000000");
        	SetHeaderRowHeight(10);
        	 if (first_load2 == true) {
		    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height2));
		      }
		      first_load2=false;
		      for (n=0; n < varCnt; n++) {
		    	  if (arrHead2[n+1] == "Basic Leased" || arrHead2[n+1] == "Additional Leased") {
		    		  //SetCellBackColor(2, cnt, "#C4D2FF");
		    	  } else {
		    		  //SetCellBackColor(2, cnt, "#D3DBFF");
		    	  }
		    	  cnt++;
		      }
//		      SetSheetHeight(420);
		      
		      SetEditArrowBehavior(3); 
		      
        	 }
				break;
	           
         case 3:	//sheet2 init
            	if (head3 == "" ) {head3="|CRR1|CRR2|CRR3|CRR4|CRR5";}
            	
//    			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
    			var arrayHead3=head3.split("|");
    			
    			head3 = "";
    			
    			for(j=0; j < arrayHead3.length; j++) {
    					if(j%5 == 0 && j != arrayHead3.length - 1){
    						arrayHead3[j] = arrayHead3[j] + "|" ;
    					}else if(j%5 == 1 && j != arrayHead3.length - 1){ 
    						arrayHead3[j] = " " + arrayHead3[j] + " |" ;
    					}else if(j%5 == 2 && j != arrayHead3.length - 1){ 
    						arrayHead3[j] = " " + " " + arrayHead3[j] + " " + " |" ;
    					}else if(j%5 == 3 && j != arrayHead3.length - 1){ 
    						arrayHead3[j] = " " + " " + " " + arrayHead3[j] + " " + " " + " |" ;
    					}else if(j%5 == 4 && j != arrayHead3.length - 1){ 
    						arrayHead3[j] = " " + " " + " " + " " + arrayHead3[j] + " " + " " + " " + " |" ;
    					}else if(j == arrayHead3.length - 1){ // 마지막 번째일때
    						arrayHead3[j] = " "+ " "+ " "+ " "+ " " + arrayHead3[j] + " "+ " "+ " "+ " " + " " ;
    						head3 = head3 + arrayHead3[j];
    						break;
    					}
    					
    					head3 = head3 + arrayHead3[j];
    				
    			} 
    			
            	arrHead3=head3.replace(/(^\s*)/g, '').split("|");
            	varCnt=arrHead3.length ;
            	//style.height=GetSheetHeight(sheet_height) ;
            	var head0="";
            	with(sheetObj){
            	for(i=0;i<=varCnt; i++){
            		head0=head0 + "|Rate";
            	}
            	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Unit|★"+ head0;
            	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Unit|★|"+ head3;
            	var cnt=0;
            	
//              2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                HeadTitle0 = HeadTitle0 + "| |";
                HeadTitle1 = HeadTitle1 + "| |";

            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:14, DataRowMerge:1 } );

            	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle0, Align:"Center"},
            	                { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
				     {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9 },
				     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"M_unit",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_cost_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
            	for (var n=0; n<varCnt; n++) {
            		cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            		//cnt++;
            	}
            	
//              2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
                cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                
            	InitColumns(cols);
            	SetEditable(1);
            	//SetRangeBackColor(1, 13, 2, 15 + varCnt,"#000000");
            	SetHeaderRowHeight(10);
            	   if (first_load3 == true){
				    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height3));
				      }
				      first_load3=false;
				      for (n=0; n < varCnt; n++) {
				    	  if (arrHead3[n+1] == "Basic Leased" || arrHead3[n+1] == "Additional Leased") {
				    		  //SetCellBackColor(2, cnt, "#C4D2FF");
				    	  } else {
				    		  //SetCellBackColor(2, cnt, "#D3DBFF");
				    	  }
				    	  cnt++;
				      }
//				      SetSheetHeight(420);
				      
				      SetEditArrowBehavior(3); 
				      
	            }
				break;
	         
       case 4:	//sheet2 init
        	if (head3 == "" ) {
        		head3="|CRR1|CRR2|CRR3|CRR4|CRR5";
        	}
        	
//			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
			var arrayHead3=head3.split("|");
			
			head3 = "";
			
			for(j=0; j < arrayHead3.length; j++) {
					if(j%5 == 0 && j != arrayHead3.length - 1){
						arrayHead3[j] = arrayHead3[j] + "|" ;
					}else if(j%5 == 1 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + arrayHead3[j] + " |" ;
					}else if(j%5 == 2 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + arrayHead3[j] + " " + " |" ;
					}else if(j%5 == 3 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + arrayHead3[j] + " " + " " + " |" ;
					}else if(j%5 == 4 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + " " + arrayHead3[j] + " " + " " + " " + " |" ;
					}else if(j == arrayHead3.length - 1){ // 마지막 번째일때
						arrayHead3[j] = " "+ " "+ " "+ " "+ " " + arrayHead3[j] + " "+ " "+ " "+ " " + " " ;
						head3 = head3 + arrayHead3[j];
						break;
					}
					
					head3 = head3 + arrayHead3[j];
				
			} 
			
        	arrHead3=head3.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrHead3.length ;
        	//style.height=GetSheetHeight(sheet_height) ;
        	var head0="";
        	with(sheetObj){
        	for(i=0;i<=varCnt; i++)
        		{head0=head0 + "|Rate";}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Rate Type|★"+ head0;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Rate Type|★|"+ head3;
        	var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| |";
            HeadTitle1 = HeadTitle1 + "| |";

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:14, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
			     {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9 },
			     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rate_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_cost_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
          	for (var n=0; n<varCnt; n++) {
          		cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
          		cnt++;
          	}
          	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

          	InitColumns(cols);
          	SetEditable(1);
          	//SetRangeBackColor(1, 13, 2, 15 + varCnt,"#000000");
          	SetHeaderRowHeight(10);
          	if (first_load4 == true) {
		    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height4));
		      }
		      first_load4=false;
		      for (n=0; n < varCnt; n++) {
		    	  if (arrHead4[n+1] == "Basic Leased" || arrHead4[n+1] == "Additional Leased") {
		    		  //SetCellBackColor(2, cnt, "#C4D2FF");
		    	  } else {
		    		  //SetCellBackColor(2, cnt, "#D3DBFF");
		    	  }
		    	  cnt++;
		      }
//		      SetSheetHeight(420);
		      
		      SetEditArrowBehavior(3); 
		      
          }
          sheetObj.SetWaitImageVisible(0);
		break;
	         
        case 5:	//sheet2 init
        	if (head3 == "" ) 
        	{head3="|CRR1|CRR2|CRR3|CRR4|CRR5";}
        	
//			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
			var arrayHead3=head3.split("|");
			
			head3 = "";
			
			for(j=0; j < arrayHead3.length; j++) {
					if(j%5 == 0 && j != arrayHead3.length - 1){
						arrayHead3[j] = arrayHead3[j] + "|" ;
					}else if(j%5 == 1 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + arrayHead3[j] + " |" ;
					}else if(j%5 == 2 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + arrayHead3[j] + " " + " |" ;
					}else if(j%5 == 3 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + arrayHead3[j] + " " + " " + " |" ;
					}else if(j%5 == 4 && j != arrayHead3.length - 1){ 
						arrayHead3[j] = " " + " " + " " + " " + arrayHead3[j] + " " + " " + " " + " |" ;
					}else if(j == arrayHead3.length - 1){ // 마지막 번째일때
						arrayHead3[j] = " "+ " "+ " "+ " "+ " " + arrayHead3[j] + " "+ " "+ " "+ " " + " " ;
						head3 = head3 + arrayHead3[j];
						break;
					}
					
					head3 = head3 + arrayHead3[j];
				
			} 
			
        	arrHead3=head3.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrHead3.length ;
        	//style.height=GetSheetHeight(sheet_height) ;
        	var head0="";
        	with(sheetObj){
        	for(i=0;i<=varCnt; i++){
        		head0=head0 + "|Rate";
        	}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Rate Type|★"+ head0;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|Rate Type|★|"+ head3;
        	var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| |";
            HeadTitle1 = HeadTitle1 + "| |";

        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:14, DataRowMerge:1 } );

        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                { Text:HeadTitle1, Align:"Center"} ];
        	InitHeaders(headers, info);

        	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
			     {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			     {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9 },
			     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			     {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rate_type",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_cost_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        	for (var n=0; n<varCnt; n++) {
        		cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
        		//cnt++;
        	}
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

        	InitColumns(cols);
        	SetEditable(1);
        	//SetRangeBackColor(1, 13, 2, 15 + varCnt,"#000000");
        	SetHeaderRowHeight(10);
        	if (first_load5 == true) {
		    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height5));
		      }
		      first_load5=false;
		      for (n=0; n < varCnt; n++) {
		    	  if (arrHead5[n+1] == "Basic Leased" || arrHead5[n+1] == "Additional Leased") {
		    		  //SetCellBackColor(2, cnt, "#C4D2FF");
		    	  } else {
		    		  //SetCellBackColor(2, cnt, "#D3DBFF");
		    	  }
		    	  cnt++;
		      }
//		      SetSheetHeight(420);
		      
		      SetEditArrowBehavior(3); 
		      
          }
          sheetObj.SetWaitImageVisible(0);
		break;		
		//20150514.ADD
        case 6:      //sheet6 init
        	if (head1 == "" && head2 == "") {
        		head1="|Joint Operation (Charter-out)|Joint Operation (Charter-out)|Joint Operation (Charter-out)"+ "|Sub lease(Charter-out)|Sub lease(Charter-out)|Sub lease(Charter-out)"+ "|Cross-charter out(lease)|Cross-charter out(lease)|Cross-charter out(lease)";
        		head2="|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3|CRR1|CRR2|CRR3";
        	}
        	
//			2014.11.07 김용습 - 같은 Carrier가 헤더에 연달아 나올때, merge되서는 안되는 부분에서 merge되는 현상을 피하기 위해 작성
			var arrayHead2=head2.split("|");
			
			head2 = "";
			
			for(j=0; j < arrayHead2.length; j++) {
					if(j%5 == 0 && j != arrayHead2.length - 1){
						arrayHead2[j] = arrayHead2[j] + "|" ;
					}else if(j%5 == 1 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + arrayHead2[j] + " |" ;
					}else if(j%5 == 2 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + arrayHead2[j] + " " + " |" ;
					}else if(j%5 == 3 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + " " + arrayHead2[j] + " " + " " + " |" ;
					}else if(j%5 == 4 && j != arrayHead2.length - 1){ 
						arrayHead2[j] = " " + " " + " " + " " + arrayHead2[j] + " " + " " + " " + " |" ;
					}else if(j == arrayHead2.length - 1){ // 마지막 번째일때
						arrayHead2[j] = " "+ " "+ " "+ " "+ " " + arrayHead2[j] + " "+ " "+ " "+ " " + " " ;
						head2 = head2 + arrayHead2[j];
						break;
					}
					
					head2 = head2 + arrayHead2[j];
				
			}        	
        	
        	if(head1 != "undefined" || head1.length>0)
        		arrHead1=head1.replace(/(^\s*)/g, '').split("|");
        	if(head2 != "undefined" || head2.length>0)
        		arrHead2=head2.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrHead2.length - 1;
        	with(sheetObj){
        	for (var cnt=0; cnt<varCnt; cnt++) {
        		head0=head0 + "|Rate (Income)";
        	}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|VSL Class|Rate (Expense)|Rate (Expense)|Rate (Expense)"+ head0;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|VSL Class|Initial Slots|Basic Chartered|Additional Chartered"+ head1;
        	var HeadTitle2="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|VSL Class|Company | Company | Company"+ head2;
        	var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 하나 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| |";
            HeadTitle1 = HeadTitle1 + "| |";
                        
        	SetConfig({ SearchMode:2, MergeSheet:5, Page:20, FrozenCol:12, DataRowMerge:0 } );
        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},{ Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
        	InitHeaders(headers, info);
        	var cols = [{Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0 },
			            {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",                KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Int",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_slt_prc_seq_org",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
						{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1 , AcceptKeys:"E|N" , InputCaseSensitive:1, EditLen:9},
						{Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_fm_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
						{Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_slt_prc_to_dt",   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",              KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						{Type:"Int",       Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"M_vsl_capa",            KeyField:1,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					    {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"M_co_bfr_sub_capa",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"M_sub_chtr_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
						{Type:"AutoSum",   Hidden:0, Width:130,  Align:"Right",   ColMerge:1,   SaveName:"M_crs_chtr_bsa_capa",   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
            for (var n=0; n<varCnt; n++) {
            	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"D_slt_prc_capa"+n,      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
            	cnt++;
            }
            cols.push({Type:"AutoSum",   Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_yellow_cnt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
            
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

            InitColumns(cols);
            SetEditable(1);
            SetHeaderRowHeight(10);
		      if (first_load6 == true) {
		    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height6));
		      }
		      first_load6=false;
		      for (n=0; n < varCnt; n++) {
		    	  if (arrHead6[n+1] == "Basic Leased" || arrHead6[n+1] == "Additional Leased") {
		    		  //SetCellBackColor(2, cnt, "#C4D2FF");
		    	  } else {
		    		  //SetCellBackColor(2, cnt, "#D3DBFF");
		    	  }
		    	  cnt++;
		      }
//		      SetSheetHeight(448);

				for(z=16; z<=cnt; z++){ // rate (income)부터 적용하므로 z(컬럼번호)를 16으로 설정
					if(GetCellValue(0,z) == "Initial Slots"){
						SetCellBackColor(0, z, "#454545");
						SetToolTipText(0, z, "Initial Slots");
					}else if(GetCellValue(1,z) == "Initial Slots"){
						SetCellBackColor(1, z, "#454545");
						SetToolTipText(1, z, "Initial Slots");
					}else if(GetCellValue(1,z) == "Basic Leased"){
						SetCellBackColor(1, z, "#050099");
						SetToolTipText(1, z, "Basic Leased");
					}else if(GetCellValue(1,z) == "Additional Leased"){
						SetCellBackColor(1, z, "#99004C");
						SetToolTipText(1, z, "Additional Leased");
					}
					
					if(GetCellValue(0,z) == "Rate (Income)"){
						SetToolTipText(0, z, "Rate (Income)");
					}
					
					if(GetCellValue(0,z) == "Rate (Expense)"){
						SetToolTipText(0, z, "Rate (Expense)");
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
			Index=0;
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
			comSetIBCombo(sheetObj, comboXml[0], "M_trd_cd", true, 0);
		}
		if (comboXml.length > 2){
			comSetIBCombo(sheetObj, comboXml[2], "M_dir_cd",true,0);
		}
		if (comboXml.length > 3){
			comSetIBCombo(sheetObj, comboXml[3], "M_rlane_cd",true,0); 
		}
		if (sheetObj.id == "sheet2" || sheetObj.id == "sheet3"){
			if (comboXml.length > 4){
				comSetIBCombo(sheetObj, comboXml[4], "M_unit",false,0);
			}
		}
		if (sheetObj.id == "sheet4" || sheetObj.id == "sheet5"){
			if (comboXml.length > 5){
				comSetIBCombo(sheetObj, comboXml[5], "M_rate_type",false,0,"","","","",true);
			}
		}
	}
	
	
	function callBackExcelMethod(excelType){
		var sheetObj ;
		var formObject=document.form;
		if(formObject.rdoType[0].checked){
			sheetObj = sheet1;
		} else if(formObject.rdoType[1].checked){				//20150514.ADD
			sheetObj = sheet6;
		} else if(formObject.rdoType[2].checked){				//20150514.MOD
			if(formObject.rdoType2_1.checked){
				sheetObj = sheet2;
			} else if(formObject.rdoType2_2.checked){
				sheetObj = sheet3;
			}	
		}else if(formObject.rdoType[3].checked){				//20150514.MOD
			if(formObject.rdoType2_1.checked){
				sheetObj = sheet4;
			} else if(formObject.rdoType2_2.checked){
				sheetObj = sheet5;								//20150514.MOD
			}		
		}  
		switch (excelType) {
           case "AY":
           	if(sheetObj.RowCount() < 1){//no data
           	       ComShowCodeMessage("COM132501");
           	}else
           	{
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
	// handling the process realated with sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheet1.ShowDebugMsg(false);
		var trdCnt;
		var ibRlaneArr="";
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				//sheetObjects[0] = sheetObjects[0].Reset();
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST;
				ComOpenWait(true);
					setTimeout( function(){
		 				var sXml=sheet1.GetSearchData("ESM_BSA_0028GS.do", bsaFormString(formObj,getParam(curPgmNo)));
		// 				var sXml=sheet1.GetSearchData("ESM_BSA_0028GS.do", formObj);
						var head1=GetEtcDataForExceptional(sXml,"head1");
						var head2=GetEtcDataForExceptional(sXml,"head2");
						var head3=GetEtcDataForExceptional(sXml,"head3");
						if (head1 != "" && head2 != "") {
							sheetObjects[0] = sheetObjects[0].Reset();
							ComConfigSheet(sheetObjects[0]);
							initSheet(sheetObjects[0], 1, head1, head2);
							sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
						}
						ComOpenWait(false);
					}, 100);
				//sheetObj.InitHeadMode(false, false, false, true, false, false); 
				break;
			case IBSAVE:        //save
				if (!validateForm(sheet1)) {
					return false;
				}
				formObj.f_cmd.value=MULTI;
				var param="&gsno=1"
				sheet1.DoSave("ESM_BSA_0028GS.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, true);		//SJH.20150210.MOD
				break;
			case IBDOWNEXCEL:   //excel download
				//sheetObj.SpeedDown2Excel(-1);
	            selectDownExcelMethod(sheetObj);
	           
				break;
			case IBINSERT:      
				with(sheet1) {
	    			if (RowCount() > 0) {
	    				var Row=DataCopy(false);
	    				SetCellValue(Row,"M_slt_prc_seq_org","",0);
						if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	                		SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
	                		// setting SEQ generally except deleted row in the group
	        				var index=0;
	        				var v_num=1;
	                        for(i=1; i<LastRow(); i++){
	                        	index=FindText("group", GetCellValue(Row,"group"), i, true);
	                        	if(i == 1) v_num=GetCellValue(index, "M_slt_prc_seq");// increased from seq displayed on th screen
	                            if (index >0){
	                            	if(GetCellValue(index, "ibflag") != "D"){
	                                    SetCellValue(index,"M_slt_prc_seq",v_num);
	                                    v_num++;
	                                } else {
	                                    SetCellValue(index, "M_slt_prc_seq",CellSearchValue(index, "M_slt_prc_seq"));
	                                }
	                                i=parseInt(index);
	                            } else {
	                                i=LastRow();  
	                            }
	                        }
//	                		SetCellValue(Row, "ibflag","U"); 
//	                		SetRowStatus(Row,"U");
//	                		for(i=Row; i<=LastRow(); i++){
//	                			if(GetCellValue(Row,"group") == GetCellValue(i,"group")){
//	                				if(parseInt(GetCellValue(Row,"maxseq")) < parseInt(GetCellValue(i,"M_slt_prc_seq"))){
////	                					if(SetRowStatus(i) != "D") 
////	                						SetRowStatus(i,"I");
//	                		        }
//	                		    }
//	                		}
	                		//20160119.ADD, 20160317.MOD
							var grpRow=getFindRows(sheet1,Row);
							if (grpRow != "") {
								var arrRow=grpRow.split(",");
								for(i=0; i < arrRow.length; i++) {
									if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
										SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
										SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
										SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
										SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
									}
								}
							}
						}
	    			}
				}
				break;
		}
	}
	function doActionIBSheet1(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);		
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST01;
				ComOpenWait(true);
				setTimeout( function(){
					sheetObj.DoSearch("ESM_BSA_0028GS2.do", bsaFormString(formObj,getParam(curPgmNo)), {Sync:2});
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:        //save
				if (!validateForm(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value=MULTI01;
				var param="&gsno=2";
				sheetObj.DoSave("ESM_BSA_0028GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, true);		//SJH.20150210.MOD
				break;
			case IBDOWNEXCEL:   //excel download
				selectDownExcelMethod(sheetObj);
				break;
			case IBCOPYROW:      
				with(sheetObj) {
				var prcSeq=GetCellValue(GetSelectRow(),"M_slt_prc_seq");
	    			if (RowCount()> 0 && prcSeq!=null && prcSeq!="") {
	    				SetSelectRow(getMaxRow(sheetObj));
	    				var Row=DataCopy(false);
//	    				SetCellValue(Row,"M_slt_prc_seq_org","");
//	    				SetCellValue(Row,"M_slt_prc_seq","");
	    				if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	        				SetCellValue(Row,"M_slt_prc_seq_org",parseInt(GetCellValue(Row,"M_slt_prc_seq_org")) + 1,0);
	        				SetCellEditable(Row,"M_trd_cd",0);
	        				SetCellEditable(Row,"M_rlane_cd",0);
	        				SetCellEditable(Row,"M_dir_cd",0);
	                		SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
						}
	    				//20160119.ADD, 20160317.MOD
						var grpRow=getFindRows(sheetObj,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
									SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
									SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
								}
							}
						}						
	    			}
				}
				break;
			case IBINSERT:  
				sheetObj.DataInsert(-1);
				break;		
		}
	}
	
	
	
	
	
	function doActionIBSheet2(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST02;
				ComOpenWait(true);
				setTimeout( function(){
					sheetObj.DoSearch("ESM_BSA_0028GS2.do", bsaFormString(formObj,getParam(curPgmNo)), {Sync:2});
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:        //save
				if (!validateForm(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value=MULTI02;
				var param="&gsno=2"
				sheetObj.DoSave("ESM_BSA_0028GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, true);		//SJH.20150210.MOD
				break;
			case IBDOWNEXCEL:   //excel download
				//sheetObj.SpeedDown2Excel(-1);
	            selectDownExcelMethod(sheetObj);
           
				break;
			case IBCOPYROW:      
				with(sheetObj) {
				var prcSeq=GetCellValue(GetSelectRow(),"M_slt_prc_seq");
					if (RowCount()> 0 && prcSeq!=null && prcSeq!="") {
	    				SetSelectRow(getMaxRow(sheetObj));
	    				var Row=DataCopy(false);
//	    				SetCellValue(Row,"M_slt_prc_seq_org","");
//	    				SetCellValue(Row,"M_slt_prc_seq","");
						if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	        				SetCellValue(Row,"M_slt_prc_seq_org",parseInt(GetCellValue(Row,"M_slt_prc_seq_org")) + 1,0);
	        				SetCellEditable(Row,"M_trd_cd",0);
	        				SetCellEditable(Row,"M_rlane_cd",0);
	        				SetCellEditable(Row,"M_dir_cd",0);
	        				SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
						}
                		//20160119.ADD, 20160317.MOD
						var grpRow=getFindRows(sheetObj,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
									SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
									SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
								}
							}
						}
	    			}
				}
				break;
			case IBINSERT:   
				with(sheetObj) {
				 DataInsert(-1);
				}
				break;	
		}
	}
	function doActionIBSheet3(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST03;
				ComOpenWait(true);
				setTimeout( function(){
					sheetObj.DoSearch("ESM_BSA_0028GS3.do", bsaFormString(formObj,getParam(curPgmNo)));
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:        //save
				if (!validateForm(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value=MULTI03;
				var param="&gsno=3"
				sheetObj.DoSave("ESM_BSA_0028GS3.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, true);		//SJH.20150210.MOD
				break;
			case IBDOWNEXCEL:   //excel download
				selectDownExcelMethod(sheetObj);
				break;
			case IBCOPYROW:      
				with(sheetObj) {
				var prcSeq=GetCellValue(GetSelectRow(),"M_slt_prc_seq");
					if (RowCount()> 0 && prcSeq!=null && prcSeq!="") {
	    				SetSelectRow(getMaxRow(sheetObj));
	    				var Row=DataCopy(false);
//	    				SetCellValue(Row,"M_slt_prc_seq_org","");
//	    				SetCellValue(Row,"M_slt_prc_seq","");
						if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	        				SetCellValue(Row,"M_slt_prc_seq_org",parseInt(GetCellValue(Row,"M_slt_prc_seq_org")) + 1,0);
	        				SetCellEditable(Row,"M_trd_cd",0);
	        				SetCellEditable(Row,"M_rlane_cd",0);
	        				SetCellEditable(Row,"M_dir_cd",0);
	        				SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
						}
                		//20160119.ADD, 20160317.MOD
						var grpRow=getFindRows(sheetObj,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
									SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
									SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
								}
							}
						}	
	    			}
				}
				break;
		case IBINSERT:   
				with(sheetObj) {
				 DataInsert(-1);
				}
				break;	
		}
	}
	function doActionIBSheet4(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST04;
				ComOpenWait(true);
				setTimeout( function(){
					sheetObj.DoSearch("ESM_BSA_0028GS3.do", bsaFormString(formObj,getParam(curPgmNo)));
					ComOpenWait(false);
				}, 100);
				break;
			case IBSAVE:        //save
				if (!validateForm(sheetObj)) {
					return false;
				}
				formObj.f_cmd.value=MULTI04;
				var param="&gsno=3"
				sheetObj.DoSave("ESM_BSA_0028GS3.do", bsaFormString(formObj,getParam(curPgmNo,'S'))+param, -1, true);		//SJH.20150210.MOD
				break;
			case IBDOWNEXCEL:   //excel download
				selectDownExcelMethod(sheetObj);
				break;
			case IBCOPYROW:     
				with(sheetObj) {
				var prcSeq=GetCellValue(GetSelectRow(),"M_slt_prc_seq");
					if (RowCount()> 0 && prcSeq!=null && prcSeq!="") {
	    				SetSelectRow(getMaxRow(sheetObj));
	    				var Row=DataCopy(false);
//	    				SetCellValue(Row,"M_slt_prc_seq_org","");
//	    				SetCellValue(Row,"M_slt_prc_seq","");
						if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	        				SetCellValue(Row,"M_slt_prc_seq_org",parseInt(GetCellValue(Row,"M_slt_prc_seq_org")) + 1,0);
	        				SetCellEditable(Row,"M_trd_cd",0);
	        				SetCellEditable(Row,"M_rlane_cd",0);
	        				SetCellEditable(Row,"M_dir_cd",0);
	        				SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
						}
                		//20160119.ADD, 20160317.MOD
						var grpRow=getFindRows(sheetObj,Row,-1);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
									SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
									SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
								}
							}
						}
	    			}
				}
				break;
			case IBINSERT:  
				with(sheetObj) {
				 DataInsert(-1);
				}
				break;		
		}
	}
	//20150514.ADD
	function doActionIBSheet5(sheetObj,formObj,sAction) {
		sheet6.ShowDebugMsg(false);
		var trdCnt;
		var ibRlaneArr="";
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (!validateCond(formObj)) {
					return false;
				}
				formObj.f_cmd.value=SEARCHLIST05;
				ComOpenWait(true);
					setTimeout( function(){
		 				var sXml=sheet6.GetSearchData("ESM_BSA_0028GS4.do", bsaFormString(formObj,getParam(curPgmNo)));
						var head1=GetEtcDataForExceptional(sXml,"head1");
						var head2=GetEtcDataForExceptional(sXml,"head2");
						var head3=GetEtcDataForExceptional(sXml,"head3");
						if (head1 != "" && head2 != "") {
							sheetObjects[5] = sheetObjects[5].Reset();
							ComConfigSheet(sheetObjects[5]);
							initSheet(sheetObjects[5], 6, head1, head2);
							sheetObjects[5].LoadSearchData(sXml,{Sync:1} );
						}
						ComOpenWait(false);
					}, 100);
				formObj.excl_yn.value = "N";
				break;
			case IBSAVE:        //save
				if (!validateForm(sheet6)) {
					return false;
				}
				var sParam = sheetObj.GetSaveString(0);									//20150518.ADD
				if(formObj.excl_yn.value == "Y") {										//20150527.ADD
					formObj.f_cmd.value=MULTI06;
				} else {
					formObj.f_cmd.value=MULTI05;
				}
				sParam = sParam + "&" + FormQueryString(formObj) + "&gsno=1";			//20150518.ADD		
				
	            var sXml = sheetObj.GetSaveData("ESM_BSA_0028GS4.do", sParam);			//20150518.ADD
	            sheetObj.LoadSaveData(sXml, {Sync:1});
	            
	            var notChk = ComGetEtcData(sXml, "not_chk");
	 			var transResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 
	 			
	 			if((notChk == "S"||notChk=="") && transResultKey == "S"){
	 				doActionIBSheet5(sheetObj,document.form,IBSEARCH);
				}else if(notChk == "Not"){
					ComShowMessage('Please check the date history of the loaded data.');
					sheetObj.RemoveAll();
					ComOpenWait(false);
					break;
					return false;
	 			}else{
	 				ComShowCodeMessage("COM12151",'Data'); //Failed 
	 				ComOpenWait(false);
	 				return false;
	 			}	 			
	 			
				formObj.excl_yn.value = "N";
				break;
			case IBDOWNEXCEL:   //excel download
	            selectDownExcelMethod(sheetObj);
	            formObj.excl_yn.value = "N";
				break;
			case IBLOADEXCEL:
        		//20150716.MOD/ADD/DEL
        		sheetObj.SetWaitImageVisible(0);
	        	sheetObj.RemoveAll();
	        	sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1"});
	        	
	        	EXCEL_VAL_FLG = false;	        	
	        	formObj.excl_yn.value = "Y";
				break; 				
			case IBINSERT:    
				if(formObj.excl_yn.value=="Y") {
					alert("If you uploaded into 'Excel' You can not be used 'Row Copy'");
					return false;
				}
				with(sheet6) {
	    			if (RowCount() > 0) {
	    				var Row=DataCopy(false);
	    				SetCellValue(Row,"M_slt_prc_seq_org","",0);
						if (Row > HeaderRows()) {
	        				//InitHeadMode(false, false, false, true, false, false); 
	        				SetCellValue(Row,"M_slt_prc_seq",parseInt(GetCellValue(Row,"M_slt_prc_seq")) + 1,0);
	                		SetCellBackColor(Row, "ibflag","#EFEBEF");
	                		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
	                		SetCellBackColor(Row, "M_vsl_capa","#EFEBEF");
	                		// setting SEQ generally except deleted row in the group
	        				var index=0;
	        				var v_num=1;
	                        for(i=1; i<LastRow(); i++){
	                        	index=FindText("group", GetCellValue(Row,"group"), i, true);
	                        	if(i == 1) v_num=GetCellValue(index, "M_slt_prc_seq");// increased from seq displayed on th screen
	                            if (index >0){
	                            	if(GetCellValue(index, "ibflag") != "D"){
	                                    SetCellValue(index,"M_slt_prc_seq",v_num);
	                                    v_num++;
	                                } else {
	                                    SetCellValue(index, "M_slt_prc_seq",CellSearchValue(index, "M_slt_prc_seq"));
	                                }
	                                i=parseInt(index);
	                            } else {
	                                i=LastRow();  
	                            }
	                        }
//	                		for(i=Row; i<=LastRow(); i++){
//	                			if(GetCellValue(Row,"group") == GetCellValue(i,"group")){
//	                				if(parseInt(GetCellValue(Row,"maxseq")) < parseInt(GetCellValue(i,"M_slt_prc_seq"))){
//	                		        }
//	                		    }
//	                		}	                		
	                		//20160119.ADD, 20160317.MOD
							var grpRow=getFindRows(sheet6,Row);
							if (grpRow != "") {
								var arrRow=grpRow.split(",");
								for(i=0; i < arrRow.length; i++) {
									if(parseInt(GetCellValue(arrRow[i],"M_slt_prc_seq")) < parseInt(GetCellValue(Row,"M_slt_prc_seq"))){									
										SetCellEditable(arrRow[i],"M_bsa_slt_prc_fm_dt",0);		//20160119.ADD
										SetCellEditable(arrRow[i],"M_bsa_slt_prc_to_dt",0);	
										SetCellEditable(Row,"M_bsa_slt_prc_fm_dt",1);
										SetCellEditable(Row,"M_bsa_slt_prc_to_dt",1);										
									}
								}
							}              		
						}
	    			}
				}
				break;
		}
	}	
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//Setting and Checking BG color of all row.
			//SetColBackColor("ibflag","#EFEBEF");
			//SetColBackColor("M_slt_prc_seq","#EFEBEF");
			//SetColBackColor("M_trd_cd","#EFEBEF");
			//SetColBackColor("M_rlane_cd","#EFEBEF");
			//SetColBackColor("M_dir_cd","#EFEBEF");
			SetColBackColor("M_co_bfr_sub_capa","white");
			
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.
		if(document.form.isExcludZero.checked) {
	    	
//	    	sheetObj.SetFrozenCol(1);
	        sheetObj.RenderSheet(0);
	        var count = 0;
	        
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-2; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	2014.12.05 김용습 - 마지막 컬럼 2개는 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-2으로 변경(sheet1은 히든 컬럼이 2개)
            for(var k=0; k<=sheetObj.LastCol()-2; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=16){
            		sheetObj.SetColHidden(k,0);	
            	} 
            	
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(2, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	               sheetObj.SetColHidden(k,1);
	               sheetObj.SetColWidth(k,0);
	    	    }else if (parseFloat(sheetObj.GetSumValue(0,k)) != 0.00) {
	    	    	count = k ;
	    	    }
	    	    	
	        }
	        sheetObj.RenderSheet(1);

	        if(count > 13){
	        	sheetObj.SetFrozenCol(13);
			}
	        
	    } else {
	    	
	    	sheetObj.SetFrozenCol(13);
	        sheetObj.RenderSheet(0);
	        
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼 2개는 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-2으로 변경(sheet1은 히든 컬럼이 2개)
            for(var k=0; k<=sheetObj.LastCol()-2; k++) {
	            //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(2, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00) {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    
//	    	    2014.11.07 김용습 - 16번째 컬럼(Basic Slots의 시작) 이후의 컬럼만 width 60가 강제 세팅 되도록 함
	    	    if(k>=16){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }
	    	    
	        }
	        sheetObj.RenderSheet(1);
	    }
	}
	function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//Setting and Checking BG color of all row.
/*			SetColBackColor("ibflag","#EFEBEF");
			SetColBackColor("M_slt_prc_seq","#EFEBEF");
			SetColBackColor("M_trd_cd","#EFEBEF");
			SetColBackColor("M_rlane_cd","#EFEBEF");
			SetColBackColor("M_dir_cd","#EFEBEF");*/
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.
		if(document.form.isExcludZero.checked) {
			
//			sheetObj.SetFrozenCol(1);
	        sheetObj.RenderSheet(0);

	    	var count = 0;
	    	
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=14){
            		sheetObj.SetColHidden(k,0);	
            	}            	
            	
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	               sheetObj.SetColHidden(k,1);
	               sheetObj.SetColWidth(k,0);
	               
	            }else if(parseFloat(sheetObj.GetSumValue(0,k)) != 0.00){
	          	    //sheetObj.SetColHidden(k,0);
	            	if(k>=14){
	            		sheetObj.SetColWidth(k,60);
	            	}	        	    
	        	    count = k ;
	            }
	        }
	        sheetObj.RenderSheet(1);
	        
	        if(count > 14){
	        	sheetObj.SetFrozenCol(14);
			}
	        
	    } else {
	    	
	    	sheetObj.SetFrozenCol(14);
	        sheetObj.RenderSheet(0);
	        
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    
	    	    if(k>=14){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }	    	    
	        }
	        sheetObj.RenderSheet(1);
	    }	    
	}
	function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//Setting and Checking BG color of all row.
/*			SetColBackColor("ibflag","#EFEBEF");
			SetColBackColor("M_slt_prc_seq","#EFEBEF");
			SetColBackColor("M_trd_cd","#EFEBEF");
			SetColBackColor("M_rlane_cd","#EFEBEF");
			SetColBackColor("M_dir_cd","#EFEBEF");*/
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.		
    	
	    if(document.form.isExcludZero.checked) {
	    	
//	    	sheetObj.SetFrozenCol(1);
	        sheetObj.RenderSheet(0);

	    	var count = 0;
	    	
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=14){
            		sheetObj.SetColHidden(k,0);	
            	}           
            	
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	                sheetObj.SetColHidden(k,1);
		        }else if(parseFloat(sheetObj.GetSumValue(0,k)) != 0.00){
		    	    //sheetObj.SetColHidden(k,0);
		        	if(k>=14){
		        		sheetObj.SetColWidth(k,60);
		        	}		    	    
		    	    count = k ;
		        }
	        }
	        sheetObj.RenderSheet(1);
	        
	        if(count > 14){
	        	sheetObj.SetFrozenCol(14);
			}
	      
	    } else {
	    	
	    	sheetObj.SetFrozenCol(14);
	        sheetObj.RenderSheet(0);
	        
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    if(k>=14){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }	    	  	
	        }	
	        sheetObj.RenderSheet(1);
	    }	   
	}
	function sheet4_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//Setting and Checking BG color of all row.
/*			SetColBackColor("ibflag","#EFEBEF");
			SetColBackColor("M_slt_prc_seq","#EFEBEF");
			SetColBackColor("M_trd_cd","#EFEBEF");
			SetColBackColor("M_rlane_cd","#EFEBEF");
			SetColBackColor("M_dir_cd","#EFEBEF");*/
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.

	    if(document.form.isExcludZero.checked) {
	    	
//	    	sheetObj.SetFrozenCol(1);
	        sheetObj.RenderSheet(0);

	    	var count = 0;
	    	
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=14){
            		sheetObj.SetColHidden(k,0);	
            	}           
            	
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	                sheetObj.SetColHidden(k,1);
		        }else if(parseFloat(sheetObj.GetSumValue(0,k)) != 0.00){
		      	    //sheetObj.SetColHidden(k,0);
		        	if(k>=14){
		        		sheetObj.SetColWidth(k,60);
		        	}		    	    
		        	count = k ;
		        }
	        }
	        sheetObj.RenderSheet(1);
	        
	        if(count > 14){
	        	sheetObj.SetFrozenCol(14);
			}
	    } else {
	    	
	    	sheetObj.SetFrozenCol(14);
	        sheetObj.RenderSheet(0);
	        
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    if(k>=14){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }	    	  	
	        }	      
	        sheetObj.RenderSheet(1);
	    }	    
	}
	function sheet5_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			//Setting and Checking BG color of all row.
/*			SetColBackColor("ibflag","#EFEBEF");
			SetColBackColor("M_slt_prc_seq","#EFEBEF");
			SetColBackColor("M_trd_cd","#EFEBEF");
			SetColBackColor("M_rlane_cd","#EFEBEF");
			SetColBackColor("M_dir_cd","#EFEBEF");*/
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.
		
	    if(document.form.isExcludZero.checked) {
//	    	sheetObj.SetFrozenCol(1);
	        sheetObj.RenderSheet(0);

	    	var count = 0;
	    	
//    		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-1; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }
    		
//    		2014.12.05 김용습
    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=14){
            		sheetObj.SetColHidden(k,0);	
            	}           
            	
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
	                sheetObj.SetColHidden(k,1);
		        }else if(parseFloat(sheetObj.GetSumValue(0,k)) != 0.00){
		    	    //sheetObj.SetColHidden(k,0);
		        	if(k>=14){
		        		sheetObj.SetColWidth(k,60);
		        	}		    	    
		        	count = k ;
		        }
	        }
            sheetObj.RenderSheet(1);
	        
	        if(count > 14){
	        	sheetObj.SetFrozenCol(14);
			}
	    } else {
	    	sheetObj.SetFrozenCol(14);
	        sheetObj.RenderSheet(0);
	        
//        	2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-1으로 변경
            for(var k=0; k<=sheetObj.LastCol()-1; k++) {
	    	    //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    if(k>=14){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }	    	  	
	        }	
	        sheetObj.RenderSheet(1);
	    }
	}
	
	//20150514.ADD
	function sheet6_OnSearchEnd(sheetObj,ErrMsg) {
		with(sheetObj){
			SetColBackColor("M_co_bfr_sub_capa","white");
			
			SetSumText("ibflag","Total");
		}
		 //Making the column hidden in case isExcludZero is checked and total value is zero.
		if(document.form.isExcludZero.checked) {
	    	
	        sheetObj.RenderSheet(0);
	        var count = 0;
	        
//    		only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//    		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
    		for(var k=0; k<=sheetObj.LastCol()-2; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
    			if(k >= 10){ 
    				sum = sum + sheetObj.GetSumValue(0,k);
    			}    			    			
            }

    		if(sum==0){
    			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
    		}else{
    			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
    		}
	        	
//        	마지막 컬럼 2개는 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-2으로 변경(sheet1은 히든 컬럼이 2개)
            for(var k=0; k<=sheetObj.LastCol()-2; k++) {
            	
//            	2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
            	if(k>=16){
            		sheetObj.SetColHidden(k,0);	
            	} 
            	
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    {
	               sheetObj.SetColHidden(k,1);
	               sheetObj.SetColWidth(k,0);
	    	    }else if (parseFloat(sheetObj.GetSumValue(0,k)) != 0.00) {
	    	    	count = k ;
	    	    }
	    	    	
	        }
	        sheetObj.RenderSheet(1);

	        if(count > 13){
	        	sheetObj.SetFrozenCol(13);
			}
	        
	    } else {
	    	
	    	sheetObj.SetFrozenCol(13);
	        sheetObj.RenderSheet(0);
	        
//        	only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	
//        	마지막 컬럼 2개는 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-2으로 변경(sheet1은 히든 컬럼이 2개)
            for(var k=0; k<=sheetObj.LastCol()-2; k++) {
	            //if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(2, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00)
	    	    if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.00) {
	                sheetObj.SetColHidden(k,0);
	    	    }
	    	    
//	    	    16번째 컬럼(Basic Slots의 시작) 이후의 컬럼만 width 60가 강제 세팅 되도록 함
	    	    if(k>=16){
	    	    	sheetObj.SetColWidth(k,60);
	    	    }
	    	    
	        }
	        sheetObj.RenderSheet(1);
	    }
	}	
	
		function sheet2_OnSaveEnd(sheetObj, ErrMsg){
			var formObject=document.form;
			var rows=sheetObj.RowCount();
			var prcSeq=sheetObj.GetCellValue(rows+1,"M_slt_prc_seq");
			with(sheetObj){			
				if (prcSeq==null || prcSeq==""){
					doActionIBSheet1(sheetObj,formObject,IBSEARCH);
				}
			}
		}	
		function sheet3_OnSaveEnd(sheetObj, ErrMsg){
			var formObject=document.form;
			var rows=sheetObj.RowCount();
			var prcSeq=sheetObj.GetCellValue(rows+1,"M_slt_prc_seq");
			with(sheetObj){			
				if (prcSeq==null || prcSeq==""){
					doActionIBSheet2(sheetObj,formObject,IBSEARCH);
				}
			}
		}
		function sheet4_OnSaveEnd(sheetObj, ErrMsg){
			var formObject=document.form;
			var rows=sheetObj.RowCount();
			var prcSeq=sheetObj.GetCellValue(rows+1,"M_slt_prc_seq");
			with(sheetObj){			
				if (prcSeq==null || prcSeq==""){
					doActionIBSheet3(sheetObj,formObject,IBSEARCH);
				}
			}
		}
		function sheet5_OnSaveEnd(sheetObj, ErrMsg){
			var formObject=document.form;
			var rows=sheetObj.RowCount();
			var prcSeq=sheetObj.GetCellValue(rows+1,"M_slt_prc_seq");
			with(sheetObj){			
				if (prcSeq==null || prcSeq==""){
					doActionIBSheet4(sheetObj,formObject,IBSEARCH);
				}
			}
		}
    /**
     * handling it in case of moditying sheet data
     * setting First ETD data in case of changing VVD
     */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
    	 var param="";
//    	 ComOpenWait(true);
    	 with(sheetObj){
    		 // Controlling column color   
    		 
//    		 2014.09.03 김용습 - "#FFFF00"이라고 영어를 대문자로 쓰니 ==이라고 인식되지 않아 "#ffff00"로 바꿉니다
//    		 if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00"){ //in case of changing the value
    		 if (Value != 0 && GetCellBackColor(Row,Col) == "#ffff00"){
    			 SetCellBackColor(Row,Col,"#FFF8FB");
    		 	 SetCellValue(Row,"M_yellow_cnt",parseInt(GetCellValue(Row,"M_yellow_cnt"), 10) - 1);
    		 } else { //Turning back "#FFFF00" in case changed value is same as orginal value
//    			 if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
    			 if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#fff8fB") {
    				 SetCellBackColor(Row,Col,"#FFFF00");
    				 SetCellValue(Row,"M_yellow_cnt",parseInt(GetCellValue(Row,"M_yellow_cnt"), 10) + 1);
    			 }
    		 }
    		 // Cotrolling period and status 
    		 if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
    			 SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
//    			 SetRowStatus(Row-1,"U");
    			 if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
    				 SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
    			 }
    		 }
			// Changing SEQ, status and period in case of changing DEL status
			if(sheetObj.ColSaveName(Col) == "del") {
				//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
				var index=0;
				var v_num=1;
				for(i=1; i<LastRow(); i++){
					index=FindText("group", GetCellValue(Row,"group"), i, true);
					if(i == 1) v_num=GetCellValue(index, "M_slt_prc_seq");
					if (index >0){
						if(GetCellValue(index, "ibflag") != "D"){
							SetCellValue(index,"M_slt_prc_seq",v_num,0);
							v_num++;
						} else {
							SetCellValue(index, "M_slt_prc_seq",CellSearchValue(index, "M_slt_prc_seq"),0);
						}
						i=parseInt(index);
					} else {
						i=LastRow();
					}
				}
				// Changing status according to changing SEQ
				for(i=Row+1; i<=sheetObj.LastRow(); i++){
					if(sheetObj.GetCellValue(Row,"group") == sheetObj.GetCellValue(i,"group")){
						if(parseInt(sheetObj.GetCellValue(Row,"maxseq")) < parseInt(sheetObj.GetCellValue(i,"M_slt_prc_seq"))){
							if(sheetObj.GetCellValue(i, "ibflag") != "D") 
								sheetObj.SetRowStatus(i,"I");
						} else {
							if(sheetObj.GetCellValue(i, "ibflag") != "D") 
								sheetObj.SetRowStatus(i,"U");
						}
					}
				}
			}
        	//SJH.20150209.ADD
    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
    			selRow=Row;
				//SJH.20150209.ADD
				if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
					if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
						alert("VVD's Last Element is not the same as Dir.");
						if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
						else SetCellValue(selRow,"M_dir_cd","",0);
						ComOpenWait(false);
						return false;
					}
				}  
    		}		
    		//SJH.20150211.ADD : TO > FROM 이어야함.
    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
    			selRow=Row;
				if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
					if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
			  	 		alert("From Date is greater than To Date.");
			  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
						ComOpenWait(false);
						return false;
					}
				} 
    		}    		
	    	// Setting First ETD DT in case of changing VVD
			if (ColSaveName(Col) == "M_vvd_cd") {
				ComOpenWait(true);												//20150529.ADD
				selRow=Row;
				selValue=Value;			
				param=param+"f_cmd="+SEARCHLIST02;
				param=param+"&vvd_cd="+GetCellValue(Row,Col);
				param=param+"&code=etdDt";
	 			var sXml=GetSearchData("ESM_BSA_CODE.do", param);
				var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
				getEdtDate(etdDt);
				ComOpenWait(false);												//20150529.ADD
			} 			
    	}
//		ComOpenWait(false);
	}
	    //VVD --> edt-date
	/**
     * Handling in case of changing sheet data
     * Setting First ETD DT in case of changing VVD
     */	
	    function sheet2_OnChange(sheetObj,Row,Col,Value) {
	    	var formObj=document.form;
	    	var param="";
//	    	ComOpenWait(true);
	    	with(sheetObj){
	    		 // Controlling column color 
	    		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00"){ //in case of changing the value
	    			SetCellBackColor(Row,Col,"#FFF8FB");
	    		} else {//Turning back "#FFFF00" in case changed value is same as orginal value
	    			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
	    				SetCellBackColor(Row,Col,"#FFFF00");
	    			}
	    		}
	    		// Cotrolling period and status , 20150728.ADD
	    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && 
	    			ComTrimAll(GetCellText(Row, "group")).length > 0 && GetCellValue(Row-1,"group") == GetCellValue(Row,"group") ) {
	    			SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
	    			if(GetCellValue(Row-1, "ibflag")!="I"){
//	    				SetRowStatus(Row-1,"U");
	    			}
	    			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
	    				SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
	    			}
	    		}
	    		// Changing SEQ, status and period in case of changing DEL status
	    		if(ColSaveName(Col) == "del") {
	    			//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
	    			if (GetRowStatus(Row-1)=="R" && !GetCellEditable(Row-1,"M_bsa_slt_prc_to_dt")){
	    		    	SetCellEditable(Row -1,"M_bsa_slt_prc_to_dt",1);
	    		    }
	    		}
	        	//SJH.20150209.ADD
	    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
	    			selRow=Row;
					//SJH.20150209.ADD
					if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
						if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
							alert("VVD's Last Element is not the same as Dir.");
							if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
							else SetCellValue(selRow,"M_dir_cd","",0);
							ComOpenWait(false);
							return false;
						}
					}  
	    		}	
        		//SJH.20150211.ADD : TO > FROM 이어야함.
        		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}	    		
		    	// Setting First ETD DT in case of changing VVD.
		    	if (ColSaveName(Col) == "M_vvd_cd") {
		    		ComOpenWait(true);												//20150529.ADD
		    		selRow=Row;
					selValue=Value;						
					param=param+"f_cmd="+SEARCHLIST02;
					param=param+"&vvd_cd="+GetCellValue(Row,Col);
					param=param+"&code=etdDt";
 					var sXml=GetSearchData("ESM_BSA_CODE.do", param);
					var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
					getEdtDate(etdDt);
					ComOpenWait(false);												//20150529.ADD
		    	}
		    	if (ColSaveName(Col) == "M_trd_cd") {
		    		var cnt=formObj.trdCnt.value;
		    		ibTrade_OnChange(sheetObj, Row, Col);
//			    var trdRlaneArr = eval("["+formObj.ibRlaneArr.value+"]");
//		
//			    for (var i=0 ; i<cnt ; i++) {	        
//			        if (GetCellValue(Row,"M_trd_cd") == trdRlaneArr[i][0]) {
//			            CellComboItem(Row,"M_rlane_cd",trdRlaneArr[i][1].replace("null"," "),trdRlaneArr[i][1].replace("null"," "));
//			        	}	        
//			    	}
				}
	    	}	
//	    	ComOpenWait(false);
	    }
	    //VVD --> edt-date
		/**
	     * Handling in case of changing sheet data
	     * Setting First ETD DT in case of changing VVD
	     */	
	    function sheet3_OnChange(sheetObj,Row,Col,Value) {
	        var formObj=document.form;
	    	var param="";
//	        ComOpenWait(true);
	    	with(sheetObj){
	    		 // Controlling column color 
	    		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00"){ //in case of changing the value
	    			SetCellBackColor(Row,Col,"#FFF8FB");
	    		} else { //Turning back "#FFFF00" in case changed value is same as orginal value
	    			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
	    				SetCellBackColor(Row,Col,"#FFFF00");
	    			}
	    		}
	    		// Cotrolling period and status , 20150728.ADD
	    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && 
	    			ComTrimAll(GetCellText(Row, "group")).length > 0 && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
	    			SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
	    			if(GetCellValue(Row-1, "ibflag")!="I"){
//	    				SetRowStatus(Row-1,"U");
	    			}
	    			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
	    				SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
	    			}
	    		}
	    		// Changing SEQ, status and period in case of changing DEL status.
	    		if(ColSaveName(Col) == "del") {
	    		    //Setting SEQ in all row except the rows deleted from the group in case of status is "delete" 
	    			if (GetRowStatus(Row-1)=="R" && !GetCellEditable(Row-1,"M_bsa_slt_prc_to_dt")){
	    		    	SetCellEditable(Row -1,"M_bsa_slt_prc_to_dt",1);
	    		    }
	    		}
	        	//SJH.20150209.ADD
	    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
	    			selRow=Row;
					//SJH.20150209.ADD
					if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
						if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
							alert("VVD's Last Element is not the same as Dir.");
							if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
							else SetCellValue(selRow,"M_dir_cd","",0);
							ComOpenWait(false);
							return false;
						}
					}  
	    		}		    
        		//SJH.20150211.ADD : TO > FROM 이어야함.
        		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}	    		
		    	// Setting First ETD DT in case of changing VVD.
		    	if (ColSaveName(Col) == "M_vvd_cd") {
		    		ComOpenWait(true);												//20150529.ADD
					selRow=Row;
					selValue=Value;						
					param=param+"f_cmd="+SEARCHLIST02;
					param=param+"&vvd_cd="+GetCellValue(Row,Col);
					param=param+"&code=etdDt";
 					var sXml=GetSearchData("ESM_BSA_CODE.do", param);
					var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
					getEdtDate(etdDt);
					ComOpenWait(false);												//20150529.ADD
		    	}
		    	if (ColSaveName(Col) == "M_trd_cd") {
		    		ibTrade_OnChange(sheetObj, Row, Col);
				}
	    	}
//	    	ComOpenWait(false);
	    }
	    //VVD --> edt-date
    /**
     * Handling in case of changing sheet data
     * Setting First ETD DT in case of changing VVD
     */
	    function sheet4_OnChange(sheetObj,Row,Col,Value) {
	    	var formObj=document.form;
	    	var param="";
//	    	ComOpenWait(true);
	    	with(sheetObj){
	    	     // Controlling column color 
	    		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00"){ //in case of changing the value
	    			SetCellBackColor(Row,Col,"#FFF8FB");
	    		} else { //Turning back "#FFFF00" in case changed value is same as orginal value
	    			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
	    				SetCellBackColor(Row,Col,"#FFFF00");
	    			}
	    		}
	    		// Cotrolling period and status, 20150728.ADD 
	    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && 
	    			ComTrimAll(GetCellText(Row, "group")).length > 0 && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
	    			SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
	    			if(GetCellValue(Row-1, "ibflag")!="I"){
//	    				SetRowStatus(Row-1,"U");
	    			}
	    			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
	    				SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
	    			}
	    		}
	    		// Changing SEQ, status and period in case of changing DEL status.
	    		if(ColSaveName(Col) == "del") {
	    		    //Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
	    			if (GetRowStatus(Row-1)=="R" && !GetCellEditable(Row-1,"M_bsa_slt_prc_to_dt")){
	    		    	SetCellEditable(Row -1,"M_bsa_slt_prc_to_dt",1);
	    		    }
	    		}
	        	//SJH.20150209.ADD
	    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
	    			selRow=Row;
					//SJH.20150209.ADD
					if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
						if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
							alert("VVD's Last Element is not the same as Dir.");
							if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
							else SetCellValue(selRow,"M_dir_cd","",0);
							ComOpenWait(false);
							return false;
						}
					}  
	    		}	
        		//SJH.20150211.ADD : TO > FROM 이어야함.
        		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}	    		
		    	// Setting First ETD DT in case of changing VVD.
		    	if (ColSaveName(Col) == "M_vvd_cd") {
		    		ComOpenWait(true);												//20150529.ADD
					selRow=Row;
					selValue=Value;						
					param=param+"f_cmd="+SEARCHLIST02;
					param=param+"&vvd_cd="+GetCellValue(Row,Col);
					param=param+"&code=etdDt";
 					var sXml=GetSearchData("ESM_BSA_CODE.do", param);
					var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
					getEdtDate(etdDt);
					ComOpenWait(false);												//20150529.ADD
		    	}
		    	if (ColSaveName(Col) == "M_trd_cd") {
		    		ibTrade_OnChange(sheetObj, Row, Col);
				}
	    	}
//	    	ComOpenWait(false);
	    }
	    //VVD --> edt-date
	      /**
     * Handling in case of changing sheet data
     * Setting First ETD DT in case of changing VVD
     */
	    function sheet5_OnChange(sheetObj,Row,Col,Value) {
	    	var formObj=document.form;
	    	var param="";
//	    	ComOpenWait(true);
	    	with(sheetObj){
	    	     // Controlling column color 
	    		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00"){// in case of changing the value
	    			SetCellBackColor(Row,Col,"#FFF8FB");
	    		} else { //Turning back "#FFFF00" in case changed value is same as orginal value
	    			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
	    				SetCellBackColor(Row,Col,"#FFFF00");
	    			}
	    		}
	    		// Cotrolling period and status , 20150728.ADD
	    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && 
	    			ComTrimAll(GetCellText(Row, "group")).length > 0 && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
	    			SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
	    			if(GetCellValue(Row-1, "ibflag")!="I"){
//	    				SetRowStatus(Row-1,"U");
	    			}
	    			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
	    				SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
	    			}
	    		}
	    		// Changing SEQ, status and period in case of changing DEL status.
	    		if(ColSaveName(Col) == "del") {
	    		    //Setting SEQ in all row except the rows deleted from the group in case of status is "delete" 
	    			if (GetRowStatus(Row-1)=="R" && !GetCellEditable(Row-1,"M_bsa_slt_prc_to_dt")){
	    		    	SetCellEditable(Row -1,"M_bsa_slt_prc_to_dt",1);
	    		    }
	    		}
	        	//SJH.20150209.ADD
	    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
	    			selRow=Row;
					//SJH.20150209.ADD
					if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
						if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
							alert("VVD's Last Element is not the same as Dir.");
							if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
							else SetCellValue(selRow,"M_dir_cd","",0);
							ComOpenWait(false);
							return false;
						}
					}  
	    		}		
        		//SJH.20150211.ADD : TO > FROM 이어야함.
        		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}	    		
		    	// Setting First ETD DT in case of changing VVD.
		    	if (ColSaveName(Col) == "M_vvd_cd") {
		    		ComOpenWait(true);												//20150529.ADD
					selRow=Row;
					selValue=Value;						
					param=param+"f_cmd="+SEARCHLIST02;
					param=param+"&vvd_cd="+GetCellValue(Row,Col);
					param=param+"&code=etdDt";
 					var sXml=GetSearchData("ESM_BSA_CODE.do", param);
					var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
					getEdtDate(etdDt);
					ComOpenWait(false);												//20150529.ADD
		    	}
		    	if (ColSaveName(Col) == "M_trd_cd") {
		    		ibTrade_OnChange(sheetObj, Row, Col);
				}
	    	}
//	    	ComOpenWait(false);
	    }
	    
	    /**
	     * handling it in case of moditying sheet data
	     * setting First ETD data in case of changing VVD
	     */
		function sheet6_OnChange(sheetObj,Row,Col,Value) {
	    	 var param="";
//	    	 ComOpenWait(true);
	    	 with(sheetObj){

	    		 if (Value != 0 && GetCellBackColor(Row,Col) == "#ffff00"){
	    			 SetCellBackColor(Row,Col,"#FFF8FB");
	    		 	 SetCellValue(Row,"M_yellow_cnt",parseInt(GetCellValue(Row,"M_yellow_cnt"), 10) - 1);
	    		 } else { //Turning back "#FFFF00" in case changed value is same as orginal value
	    			 if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#fff8fB") {
	    				 SetCellBackColor(Row,Col,"#FFFF00");
	    				 SetCellValue(Row,"M_yellow_cnt",parseInt(GetCellValue(Row,"M_yellow_cnt"), 10) + 1);
	    			 }
	    		 }
	    		 // Cotrolling period and status 
	    		 if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
	    			 SetCellValue(Row-1,"M_bsa_slt_prc_to_dt",getOffsetDate(Value,-1),0);
	    			 if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
	    				 SetCellValue(Row,"M_bsa_slt_prc_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_slt_prc_fm_dt"),-1),0);
	    			 }
	    		 }
				// Changing SEQ, status and period in case of changing DEL status
				if(sheetObj.ColSaveName(Col) == "del") {
					//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
					var index=0;
					var v_num=1;
					for(i=1; i<LastRow(); i++){
						index=FindText("group", GetCellValue(Row,"group"), i, true);
						if(i == 1) v_num=GetCellValue(index, "M_slt_prc_seq");
						if (index >0){
							if(GetCellValue(index, "ibflag") != "D"){
								SetCellValue(index,"M_slt_prc_seq",v_num,0);
								v_num++;
							} else {
								SetCellValue(index, "M_slt_prc_seq",CellSearchValue(index, "M_slt_prc_seq"),0);
							}
							i=parseInt(index);
						} else {
							i=LastRow();
						}
					}
					// Changing status according to changing SEQ
					for(i=Row+1; i<=sheetObj.LastRow(); i++){
						if(sheetObj.GetCellValue(Row,"group") == sheetObj.GetCellValue(i,"group")){
							if(parseInt(sheetObj.GetCellValue(Row,"maxseq")) < parseInt(sheetObj.GetCellValue(i,"M_slt_prc_seq"))){
								if(sheetObj.GetCellValue(i, "ibflag") != "D") 
									sheetObj.SetRowStatus(i,"I");
							} else {
								if(sheetObj.GetCellValue(i, "ibflag") != "D") 
									sheetObj.SetRowStatus(i,"U");
							}
						}
					}
				}
	        	
	    		if (ColSaveName(Col) == "M_vvd_cd" || ColSaveName(Col) == "M_dir_cd") {
	    			selRow=Row;
					if(GetCellValue(selRow,"M_dir_cd") != "" && GetCellValue(selRow,"M_vvd_cd") != "" ) {
						if(GetCellValue(selRow,"M_dir_cd") != GetCellValue(selRow,"M_vvd_cd").substring(GetCellValue(selRow,"M_vvd_cd").length-1)) {
							alert("VVD's Last Element is not the same as Dir.");
							if(ColSaveName(Col) == "M_vvd_cd") SetCellValue(selRow,"M_vvd_cd","",0);
							else SetCellValue(selRow,"M_dir_cd","",0);
							ComOpenWait(false);
							return false;
						}
					}  
	    		}		
	    		//SJH.20150211.ADD : TO > FROM 이어야함.
	    		if (ColSaveName(Col) == "M_bsa_slt_prc_fm_dt" || ColSaveName(Col) == "M_bsa_slt_prc_to_dt") {        			
	    			selRow=Row;
					if(GetCellValue(selRow,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(selRow,"M_bsa_slt_prc_to_dt") != "" ) {
						if ( parseInt(GetCellValue(selRow, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_slt_prc_to_dt","",0);
							ComOpenWait(false);
							return false;
						}
					} 
	    		}    		
		    	// Setting First ETD DT in case of changing VVD
				if (ColSaveName(Col) == "M_vvd_cd") {
					ComOpenWait(true);												//20150529.ADD
					selRow=Row;
					selValue=Value;			
					param=param+"f_cmd="+SEARCHLIST02;
					param=param+"&vvd_cd="+GetCellValue(Row,Col);
					param=param+"&code=etdDt";
		 			var sXml=GetSearchData("ESM_BSA_CODE.do", param);
					var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
					getEdtDate(etdDt);
					ComOpenWait(false);												//20150529.ADD
				} 			
	    	}
//			ComOpenWait(false);
		}
		
	    //VVD --> edt-date
	    function getEdtDate(result) {
	    	var sheetObj ;
	    	var tmpRow=0;
	    	var formObj=document.form;
	    	if(formObj.rdoType[0].checked){
	    		sheetObj=sheetObjects[0];
	    	}else if(formObj.rdoType[1].checked){		//20150514.ADD
		    	sheetObj=sheetObjects[5];
	   		}else if(formObj.rdoType[2].checked){		//20150514.MOD
	   			if(formObj.rdoType2_1.checked){
		   			sheetObj=sheetObjects[1];	
	   	   		}else if(formObj.rdoType2_2.checked){
		   	    	sheetObj=sheetObjects[2];	
	   			}
	   		}else if(formObj.rdoType[3].checked){		//20150514.MOD
	   			if(formObj.rdoType2_1.checked){
		   			sheetObj=sheetObjects[3];	
	   	   		}else if(formObj.rdoType2_2.checked){
		   	    	sheetObj=sheetObjects[4];
	   	   		}
	   		}
	    	if(result == null || result == "" || result == "null"){
	    		ComShowCodeMessage('BSA10027',selValue);  //msg1 + ' is invalid VVD or has no ETD.'
	    		sheetObj.SelectCell(selRow,"M_vvd_cd",true);
	    	} else {
	    		sheetObj.SetCellValue(selRow,"M_bsa_slt_prc_fm_dt",result);
	    	}
	    }
		function changeSheet( rdoType){
			var formObj=document.form;
			formObj.excl_yn.value = "N";												//20150515.ADD
			
//				for(var k=0; k<11; k++)
//					if(sheetObjects[k].RowCount>0) sheetObjects[k].removeAll();
			if ( formObj.rdoType[0].checked ) { 
				
//					2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
//					tr_opt.style.display="none";
//					tr_slot.style.display="inline";
//				    tr_rf_l.style.display="none";
//				    tr_rf_s.style.display="none";
//				    tr_over_l.style.display="none";
//				    tr_over_s.style.display="none";
//				    btng_rowadd.style.display="none"
				document.getElementById("tr_opt").style.display="none";
				document.getElementById("tr_slot").style.display="inline";
				document.getElementById("tr_rf_l").style.display="none";
				document.getElementById("tr_rf_s").style.display="none";
				document.getElementById("tr_over_l").style.display="none";
				document.getElementById("tr_over_s").style.display="none";
				document.getElementById("btng_rowadd").style.display="none";
				document.getElementById("tr_op_slot").style.display="none";			//20150514.ADD
				document.getElementById("btn_LoadExcel").style.display="none";		//20150514.ADD

//					2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
			    $('#div_zoom_in').hide();
				$('#div_zoom_out').show();
			} else if ( formObj.rdoType[1].checked) {			//20150514.ADD
				document.getElementById("tr_opt").style.display="none";
				document.getElementById("tr_slot").style.display="none";
				document.getElementById("tr_rf_l").style.display="none";
				document.getElementById("tr_rf_s").style.display="none";
				document.getElementById("tr_over_l").style.display="none";
				document.getElementById("tr_over_s").style.display="none";
				document.getElementById("btng_rowadd").style.display="none";
				document.getElementById("tr_op_slot").style.display="inline";		//20150514.ADD
				document.getElementById("btn_LoadExcel").style.display="inline";	//20150514.ADD

//					2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
			    $('#div_zoom_in').hide();
				$('#div_zoom_out').show();					
			} else if ( formObj.rdoType[2].checked) {			//20150514.MOD
				loadingMode=true;			
				loadingMode=false;					
				
//				    tr_opt.style.display="inline";
//				    btng_rowadd.style.display="inline";
//				    tr_slot.style.display="none";
//				    tr_over_l.style.display="none";
//				    tr_over_s.style.display="none";
				document.getElementById("tr_opt").style.display="inline";
				document.getElementById("btng_rowadd").style.display="inline";
				document.getElementById("tr_slot").style.display="none";
				document.getElementById("tr_over_l").style.display="none";
				document.getElementById("tr_over_s").style.display="none";
				document.getElementById("tr_op_slot").style.display="none";			//20150514.ADD
				document.getElementById("btn_LoadExcel").style.display="none";		//20150514.ADD
				
			    if(formObj.rdoType2_1.checked) {
					doActionIBSheet1(sheetObjects[1],document.form,IBCLEAR);
//				          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
//		         		tr_rf_l.style.display="inline";
//		         		tr_rf_s.style.display="none";
	         		document.getElementById("tr_rf_l").style.display="inline";
	         		document.getElementById("tr_rf_s").style.display="none";
	         		
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
	         		$('#div_zoom_in').hide();
					$('#div_zoom_out').show();
			    } else if(formObj.rdoType2_2.checked) {
					doActionIBSheet2(sheetObjects[2],document.form,IBCLEAR);
//				          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
					document.getElementById("tr_rf_l").style.display="none";
	         		document.getElementById("tr_rf_s").style.display="inline";
//		         		tr_rf_l.style.display="none";
//		         		tr_rf_s.style.display="inline";  
	         		
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
	         		$('#div_zoom_in').hide();
					$('#div_zoom_out').show();
			    }
//				    parent.syncHeight();
			} else if ( formObj.rdoType[3].checked) {		//20150514.MOD
//			          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	            document.getElementById("tr_opt").style.display="inline";
	            document.getElementById("btng_rowadd").style.display="inline";
	            document.getElementById("tr_slot").style.display="none";
	            document.getElementById("tr_rf_l").style.display="none";
	            document.getElementById("tr_rf_s").style.display="none";
	            document.getElementById("tr_op_slot").style.display="none";			//20150514.ADD
	            document.getElementById("btn_LoadExcel").style.display="none";		//20150514.ADD
	            
//					tr_opt.style.display="inline";
//					btng_rowadd.style.display="inline";
//				    tr_slot.style.display="none";
//				    tr_rf_l.style.display="none";
//				    tr_rf_s.style.display="none";
			    if(formObj.rdoType2_1.checked) {
					doActionIBSheet3(sheetObjects[3],document.form,IBCLEAR);
					
//				          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
		            document.getElementById("tr_over_l").style.display="inline";
		            document.getElementById("tr_over_s").style.display="none";
//		         		tr_over_l.style.display="inline";
//		         		tr_over_s.style.display="none";
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
	         		$('#div_zoom_in').hide();
					$('#div_zoom_out').show();
			    } else if(formObj.rdoType2_2.checked) {
					doActionIBSheet4(sheetObjects[4],document.form,IBCLEAR);
					
//				          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
		            document.getElementById("tr_over_l").style.display="none";
		            document.getElementById("tr_over_s").style.display="inline";
//		         		tr_over_l.style.display="none";
//		         		tr_over_s.style.display="inline"; 
//						2014.11.12 김용습 - 시트 변경 시 zoom 초기화 되도록 하기 위하여 추가
	         		$('#div_zoom_in').hide();
					$('#div_zoom_out').show();
			    }
//			    parent.syncHeight();		    
			} 
			//document.form.f_cost_yrmon.focus();
			resizeSheet();
		}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj) {
		with(sheetObj){		
			//SJH.20150209.ADD
			for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
				if(GetCellValue(i, "ibflag") == "I" || GetCellValue(i, "ibflag") == "U"){
		    		//20150721.ADD : TO > FROM 이어야함.
					if(GetCellValue(i,"M_bsa_slt_prc_fm_dt") != "" && GetCellValue(i,"M_bsa_slt_prc_to_dt") != "" ) {
						if ( parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) > parseInt(GetCellValue(i,"M_bsa_slt_prc_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
							return false;
						}
					}					
					for ( var z = HeaderRows(); z <= LastRow(); z++) {						
						if (document.form.rdoType[2].checked) { //Reefer Surcharge				20150514.MOD
							if (z != i &&
								GetCellValue(z,"M_trd_cd") == GetCellValue(i,"M_trd_cd") && 
								GetCellValue(z,"M_rlane_cd") == GetCellValue(i,"M_rlane_cd") &&
								GetCellValue(z,"M_dir_cd") == GetCellValue(i,"M_dir_cd") &&
								GetCellValue(z,"M_unit") == GetCellValue(i,"M_unit")) {
								if (GetCellValue(i, "M_bsa_slt_prc_fm_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
							  	 		 return false; 
									}
								}
								//SJH.20150211.ADD
								if (GetCellValue(i, "M_bsa_slt_prc_to_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(i-HeaderRows()+1)+" Row )");		
							  	 		 return false; 
									}
								}								
							}							
						} else if (document.form.rdoType[1].checked) { //Operational Slot Price				20150528.ADD
							if (z != i &&
								GetCellValue(z,"M_trd_cd") == GetCellValue(i,"M_trd_cd") && 
								GetCellValue(z,"M_rlane_cd") == GetCellValue(i,"M_rlane_cd") &&
								GetCellValue(z,"M_dir_cd") == GetCellValue(i,"M_dir_cd") &&
								GetCellValue(z,"M_vsl_capa") == GetCellValue(i,"M_vsl_capa")) {
								if (GetCellValue(i, "M_bsa_slt_prc_fm_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
							  	 		 return false; 
									}
								}
								if (GetCellValue(i, "M_bsa_slt_prc_to_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(i-HeaderRows()+1)+" Row )");		
							  	 		 return false; 
									}
								}								
							}							
						} else {								//ETC
							if (z != i &&
								GetCellValue(z,"M_trd_cd") == GetCellValue(i,"M_trd_cd") && 
								GetCellValue(z,"M_rlane_cd") == GetCellValue(i,"M_rlane_cd") &&
								GetCellValue(z,"M_dir_cd") == GetCellValue(i,"M_dir_cd") &&
								GetCellValue(z,"M_vsl_cd") == GetCellValue(i,"M_vsl_cd")) {
								if (GetCellValue(i, "M_bsa_slt_prc_fm_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
									 	 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
							  	 		 return false; 
									}
								}
								//SJH.20150211.ADD
								if (GetCellValue(i, "M_bsa_slt_prc_to_dt").length > 0) {
									if (parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_slt_prc_fm_dt")) &&
										parseInt(GetCellValue(i, "M_bsa_slt_prc_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_slt_prc_to_dt"))) {
										 alert("Effective Date can not be Duplicate. ( "+(i-HeaderRows()+1)+" Row )");		
							  	 		 return false; 
									}
								}								
							}							
						}
					}  	
				} 	
			}						
			if(document.form.rdoType[0].checked) {
				// checking if color of field is yellow or not
				// checking if color of field is yellow or not
				if(sheetObj.GetSumValue(0, "M_yellow_cnt") != 0) {		
					
					if(!ComShowCodeConfirm('BSA10046')){
						return false;
					}
				}
			}			
		}
		return true;
	}
	/**
	 * handling process for retrieve validation
	 */
	function validateCond(formObj) {
		with(formObj){
			if (ComTrim(txtSDate.value) == "") {
				ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
				return false;
			}
			// msg1 + '의 ' + msg2 + '는(은) ' + msg3 + ' 보다 적거나 같아야 합니다.';
//			if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
//				if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
//					ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
//					return false;
//				}
//			}
//			 if(formObj.cobTrade.value == ""){
//		            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//		            return false;
//		        }
//		        
//	        if(formObj.cobLane.value == ""){
//	            ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//	            return false;
//	        }
		}
		return true;
	}
	/**
	 * showing R.Lane with iframe
	 */
	function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		if(obj.GetSelectText()!= ""){
			//sheetObj.SetWaitImageVisible(0);
			trd_cd=obj.GetSelectCode();
			param="f_cmd="+SEARCHLIST01;
			param=param+"&trd_cd="+trd_cd;
			param=param+"&code=rLane";
 			var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0],cobLane, "code", "code");
			cobLane.SetSelectIndex(0);
		}
		//sheetObj.SetWaitImageVisible(1);
	}
	//sheet의 현재선택된 Row의 상/하위(offset 만큼) Row를 리턴
	 function getFindRow(sheetObj, Row, offset) {
	 	var rtnRow=-1;
	 	var bsa_group="";
	 	var bsa_seq=-1;
	 	var col1=0;
	 	var col2=0;
	 	var tmp=0;
	 	with(sheetObj) {
	 		sltPrcGroup=GetCellValue(Row,"group");
	 		sltPrcSeq=parseInt(GetCellValue(Row,"M_slt_prc_seq")) + offset;
	 		for (var i=HeaderRows(); i<LastRow(); i++) {
	 			col1=FindText("group", sltPrcGroup, tmp);
	 			if (col1 == -1) { break; } //Not Found
	 			col2=FindText("M_slt_prc_seq", String(sltPrcSeq), col1);
	 			if (col1 == col2) { //Found
	 				rtnRow=col2;
	 				break;
	 			}
	 			tmp=col1 + 1;
	 		}
	 	}
	 	return rtnRow;
	 }
	 //20160317.ADD : 기준 앞에만 비활성화.
	 function getFindRows(sheetObj, Row) {
		var rtnRow="";	
		var col1=0;
		var tmp=0;
		with(sheetObj) {
			for (var i=HeaderRows(); i<LastRow(); i++) {				
				col1=FindText("group", GetCellValue(Row,"group"), tmp);
				if (col1 == -1) { 
					rtnRow = rtnRow.substring(0, rtnRow.length-1);
					break; 
				} //Not Found
				SetCellEditable(col1,"M_bsa_slt_prc_fm_dt",1);
				SetCellEditable(col1,"M_bsa_slt_prc_to_dt",1);
				rtnRow=rtnRow+col1+",";
				tmp=col1 + 1;
			}
		}
		return rtnRow;
	 }		 
	//Grouping별 Max값을 추출
	 function getMaxRow(sheetObj) {
	 	var bsa_group="";
	 	var bsa_seq=0;
	 	var tmpSeq=0;
	 	var tmpRow=0;
	 	var maxRow=0;
	 	var tmp=0;
	 	with(sheetObj) {
	 		if (GetSelectRow()> 0) {
	 			maxRow=GetSelectRow();
	 			bsa_group=GetCellValue(GetSelectRow(),"group");
	 			for (var i=HeaderRows(); i<LastRow(); i++) {
	 				tmpRow=FindText("group", bsa_group, tmp);
	 				if (tmpRow == -1) {
	 					break;
	 				} else {
	 					tmpSeq=parseInt(GetCellValue(tmpRow,"M_slt_prc_seq"));
	 					if (bsa_seq <= tmpSeq) {
	 						bsa_seq=tmpSeq;  //최대값
	 						maxRow=tmpRow;  //최대값이 위치한 Row
	 					}
	 				}
	 				tmp=tmpRow + 1;
	 			} //end of for
	 		}
	 	} //end of with
	 	return maxRow;
	 }
	/**
	 * showing R.Lane with iframe
	 */
	function ibTrade_OnChange(sheetObj, row, col) {
		if (loadingMode == true) return; 
		var param="";
		var trd_cd="";
		with(sheetObj) {
			//sheetObj.SetWaitImageVisible(0);
			//ComOpenWait(false);
			ComOpenWait(true);												//20150529.ADD
			trd_cd=GetCellValue(row, col);
			if(trd_cd != ""){
				param="f_cmd="+SEARCHLIST02;
				param=param+"&trd_cd="+trd_cd;
				param=param+"&code=ibLane";
 				var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
				var rlane=GetEtcDataForExceptional(sXml, "trdCd", "0");
				sheetObj.CellComboItem(row,"M_rlane_cd", {ComboText:rlane, ComboCode:rlane} );
			}
			ComOpenWait(false);												//20150529.ADD
		}
		//sheetObj.SetWaitImageVisible(1);
	}

	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
	
	//LOADEXCEL OPTION : 20150514.ADD
	function sheet6_OnLoadExcel(sheetObj, result, code, msg) {	
		ComOpenWait(false);									//20150716.MOD
		if(isExceedMaxRow(msg)) return;
		
		if (sheetObj.RowCount() > 0) {
			for ( var i = sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
				sheetObj.SetCellValue(i,"group","");
				sheetObj.SetCellValue(i,"maxseq","");
				sheetObj.SetCellValue(i,"M_slt_prc_seq","");
				sheetObj.SetCellValue(i,"M_slt_prc_seq_org","");
			}
		}
	}
	
    //20150716.ADD
    function sheet6_OnLoadFileSelect(sheetObj){
        ComOpenWait(true);
    }	
