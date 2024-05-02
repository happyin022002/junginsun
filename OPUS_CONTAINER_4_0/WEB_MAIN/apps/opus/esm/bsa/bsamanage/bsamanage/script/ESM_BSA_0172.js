/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0172.js
*@FileTitle  : Inquire/Edit Slot-Cost
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
/****************************************************************************************
  Event classified Code : [Init]INIT=0; [Add]ADD=1; [Search]SEARCH=2; [Search List]SEARCHLIST=3;
					[Modify]MODIFY=4; [Remove]REMOVE=5; [Remove list]REMOVELIST=6 [Multi Handling]MULTI=7
					The Other text constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ESM_BSA_0172 : Defining work Script used in the page to create ESM_BSA_0172.
     */
    function ESM_BSA_0172() {
    }
   	/* Work by Developer */
    // common variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var headTmp="";
    var sheet_height=18; // sheet의 height    
	var comboObjects=new Array();
	var comboCnt=0;
	var loadingMode=false;
	var comboXml="";
	var sheet_height1=28;
	var sheet_height3=28;
	var headCnt=0;
	var first_load1=true;
	var first_load2=true;
	var first_load3=true;
    /* Definition event handler used with getting button event */
    document.onclick=processButtonClick;
    /* Event Handler to branch off from the process accoding to button name */ 
    function processButtonClick() {
    	var sheetObject=sheetObjects[0];
    	var sheetObject1=sheetObjects[1];
    	var sheetObject2=sheetObjects[2];
    	var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
    			case "btn_retrieve":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBSEARCH);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBSEARCH);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBSEARCH);	
    				}  
    				break;
    			case "btn_save":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBSAVE);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBSAVE);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBSAVE);	
    				}  
    				break;
    			case "btn_downexcel":
    					if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBDOWNEXCEL);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBDOWNEXCEL);	
    				}  
    				break;	
    			case "btns_calendar1":
    				 var cal=new ComCalendar();
    				cal.select(formObject.txtSDate,  'yyyy-MM-dd');
    				break;
    			case "btns_calendar2":
    				 var cal=new ComCalendar();
    				cal.select(formObject.txtEDate,  'yyyy-MM-dd');
    				break;
    			case "bu_zoom_in":
//    				sheet_height=getSheetHeightCnt(sheetObject,"MAX",1);
//    				sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheet_height)); 
    				document.getElementById("div_zoom_in").style.display = "none"
    				document.getElementById("div_zoom_out").style.display = "inline"
    				resizeSheet();
    				//parent.syncHeight();
    				break;
    			case "bu_zoom_out":
//    				sheet_height=getSheetHeightCnt(sheetObject,"MIN",0);
//    				sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, 27)); 
    				document.getElementById("div_zoom_in").style.display = "inline"
        			document.getElementById("div_zoom_out").style.display = "none"
    				//parent.syncHeight();
//        			sheet1.SetSheetHeight(1000);
//					sheet2.SetSheetHeight(1000);
//					sheet3.SetSheetHeight(1000);
        				
//        			2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)	
        			if(formObject.rdoType[0].checked){
        				var rowcount = sheet1.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}			
						if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}
        			}else if(formObject.rdoType[1].checked){
        				var rowcount = sheet2.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet2.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}	
        			}else if(formObject.rdoType[2].checked){
        				var rowcount = sheet3.RowCount(); // 시트의 열 개수
						var totalrowheight = 0; // 총 열 높이의 합 초기화												
						for(y=0; y<=rowcount; y++){
							totalrowheight = totalrowheight + sheet3.GetRowHeight(y); // 모든 열의 높이의 합 구하기
						}						
						if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
							sheet3.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						}		
        			}  
        				
    				break;
    			case "btng_rowcopy":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBCOPYROW);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBCOPYROW);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBCOPYROW);	
    				}  
    				break;
    			case "btng_rowadd":
    				if(formObject.rdoType[0].checked){
    					doActionIBSheet(sheetObject,formObject,IBINSERT);	
    				}else if(formObject.rdoType[1].checked){
    					doActionIBSheet2(sheetObject1,formObject,IBINSERT);	
    				}else if(formObject.rdoType[2].checked){
    					doActionIBSheet3(sheetObject2,formObject,IBINSERT);	
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
     * Registering IBSheet Object as Array
     * The process using array can be added in case of needing to handling the others at once
     * Defining the array at the top of the source
     */
    function setSheetObject(sheet_obj) {
    	 sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Registering IBCombo Object as Array
     * The process using array can be added in case of needing to handling the others at once
     * Defining the array at the top of the source
     */
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}
    /**
     * Sheet basic setting and initialization
     * Setting on Load event handler of body tag
     * Adding the function for preceding process after loading 
     */
    function loadPage(head) {
    	headTmp=head;
    	for (i=0; i<sheetObjects.length; i++) {
    		ComConfigSheet(sheetObjects[i]);
    		
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
            document.getElementById("d3_opt").style.display="inline";
            document.getElementById("d5_opt").style.display="inline";
            document.getElementById("d7_opt").style.display="inline";
//    		d3_opt.style.display="inline";
//    		d5_opt.style.display="inline";
//    		d7_opt.style.display="inline";
    		
    		initSheet(sheetObjects[i], i+1, head);
    		
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
            document.getElementById("d5_opt").style.display="none";
            document.getElementById("d7_opt").style.display="none";
//    		d5_opt.style.display="none";
//    		d7_opt.style.display="none";
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
		resizeSheet();
    }
    function loadCombo() {
     	var formObj=document.form;
 		var sXml=formObj.sXml.value;
 		var arrXml=sXml.split("|$$|");
 		var rtnArr=null;
 		var divStr="";
 		var codeArr=null;
 		var nameArr=null;
 		var checked="";
 		comboXml=arrXml;
 		if (arrXml.length > 0)
 			ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
 		if (arrXml.length > 1)
 			ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
 		if (arrXml.length > 2)
 			ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
 		// JO/SC CheckBox Setting
 		if (arrXml.length > 4){
			rtnArr=ComXml2ComboString(arrXml[4], "code", "name");
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
				divStr += "<input type=\"radio\" name=\"rdoType\" value=\""+codeArr[i]+"\" class=\"trans\" onClick=\"changeSheet(this.value);\""+checked+">"+nameArr[i]+"</input>";
				if(i < codeArr.length)
					divStr += "&nbsp;&nbsp;&nbsp;";
			}
			document.getElementById("div_bsaHighCubic").innerHTML="<div id=\"div_bsaHighCubic\">"+ divStr +"</div>";
		}
     }
    function initSheet(sheetObj,sheetNo,head) {
    	var formObj=document.form;
    	var arrhead1="";
//    	var arrhead2 = "";
//    	var arrhead3 = "";
    	var head1="";
    	var head2="";
    	var head3="";
//    	var fixCnt = 16; 
    	var varCnt=0;  
    	switch(sheetNo){
        	
        case 1:	//sheet2 init
        	if (head == "") {head="|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";}
        	arrhead1=head.replace(/(^\s*)/g, '').split("|");
        	varCnt=arrhead1.length ;
        	headCnt=varCnt;
        	(14+(varCnt*2), 14, 0, true);
        	head1="";
        	head2="";
        	haed3="";
        	with(sheetObj){
        	for(k=0;k<=varCnt; k++){        		
//        		2014.12.08 김용습 - arrhead1[k] 마지막 배열에 undefined가 들어가는 현상 수정
        		if(arrhead1[k] != undefined){
        			head1=head1 + "|D3|D3";
        			head2=head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k];
        			head3=head3 + "|Rate|Rate Type";
        		}                		
        	}
        	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"+ head1;
        	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"+ head2;
        	var HeadTitle2="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"+ head3;
        	//var cnt=0;
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
            HeadTitle0 = HeadTitle0 + "| | |";
            HeadTitle1 = HeadTitle1 + "| | |";
            HeadTitle2 = HeadTitle2 + "| | |";
        	
//        	varCnt = arrhead1.length - 1;
        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:13 } );

        	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
        	var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                { Text:HeadTitle1, Align:"Center"},
        	                { Text:HeadTitle2, Align:"Center"} ];
        				InitHeaders(headers, info);

        	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0  },
				{Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_prc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_seq_org",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:9 },
				{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				{Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				{Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				{Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_opr",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				{Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
        	cnt = cols.length;
        	for (var n=0; n<varCnt; n++) {
        			cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"OvrRate"+n,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
        			cnt++;
        			cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"RateType"+n,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
        			cnt++;
       			}
        	
//          2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
            
       			InitColumns(cols);

       			SetCellBackColor(1,cnt,"#D3DBFF");
       			SetEditableColorDiff(0);
       			SetCountPosition(0);
       			SetHeaderRowHeight(10);
       			if (first_load1 == true) {
//			    	  SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height1));
       				SetSheetHeight(440);
			      }
			      first_load1=false;
			      for (n=0; n < varCnt; n++) {
			    	  if (arrhead1[n+1] == "Basic Leased" || arrhead1[n+1] == "Additional Leased") {
			    		  SetCellBackColor(2, cnt, "#C4D2FF");
			    	  } else {
			    		  SetCellBackColor(2, cnt, "#D3DBFF");
			    	  }
			    	  cnt++;
			      }
			      InitComboNoMatchText(1,"",1);
			      
			      SetSheetHeight(445);
			      
// 				2014.10.23 김용습 - 헤더 툴팁 적용
     				for(z=0; z<=cols.length; z++){       					
     					if(GetCellValue(0,z) == "D3"){
     						SetToolTipText(0, z, "D3");    
     					}
     				} 
     				
     				SetEditArrowBehavior(3); 
     				
     				//SJH.20150209.ADD
				    SetColProperty(0 ,"M_dir_cd" , {AcceptKeys:"NEWS"});
				    SetColProperty(0 ,"M_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
        		}     
        		
    			break;
         case 2:	//sheet2 init
                	if (head == "") {
                		head="|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";
                	}
                	arrhead1=head.replace(/(^\s*)/g, '').split("|");
                	varCnt=arrhead1.length ;
                	(14+(varCnt*2), 14, 0, true);
                	head1="";
                	head2="";
                	haed3="";
                	with(sheetObj){
                	for(k=0;k<=varCnt; k++){
//                		2014.12.08 김용습 - arrhead1[k] 마지막 배열에 undefined가 들어가는 현상 수정
                		if(arrhead1[k] != undefined){
                			head1=head1 + "|D5|D5";
                    		head2=head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k];
                    		head3=head3 + "|Rate|Rate Type";
                		}                 		
                	}
                	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head1;
                	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head2;
                	var HeadTitle2="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head3;
                	var cnt=0;

//                  2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
                    HeadTitle0 = HeadTitle0 + "| | | ";
                    HeadTitle1 = HeadTitle1 + "| | | ";
                    HeadTitle2 = HeadTitle2 + "| | | ";
                    
                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:13 } );

                	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle0, Align:"Center"},
                	                { Text:HeadTitle1, Align:"Center"},
                	                { Text:HeadTitle2, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0  },
				     {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_prc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_seq_org",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:9 },
				     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
				     {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_opr",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                	for (var n=0; n<varCnt; n++) {
                		cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"OvrRate"+n,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
                		SetCellBackColor(1, cnt,"#D3DBFF");
                		cnt++;
                		cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"RateType"+n,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                		cnt++;
                	}
                	
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

                	InitColumns(cols);
                	//SetCellBackColor(1,cnt,"#D3DBFF");
                	SetEditableColorDiff(0);
                	SetCountPosition(0);
                	SetHeaderRowHeight(10);
//                	SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height));
                	SetSheetHeight(445);
                	
                	InitComboNoMatchText(1,"",1);
                	
//   				2014.10.23 김용습 - 헤더 툴팁 적용
       				for(z=0; z<=cols.length; z++){       					
       					if(GetCellValue(0,z) == "D5"){
       						SetToolTipText(0, z, "D5");    
       					}
       				}  
       				
       				SetEditArrowBehavior(3); 
       				
     				//SJH.20150209.ADD
				    SetColProperty(0 ,"M_dir_cd" , {AcceptKeys:"NEWS"});
				    SetColProperty(0 ,"M_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
          		}
                	
                	
    			break;
          case 3:	//sheet2 init
                	if (head == "") {
                		head="|CRR1|CRR1|CRR2|CRR2|CRR3|CRR3";
                	}
                	arrhead1=head.replace(/(^\s*)/g, '').split("|");
                	varCnt=arrhead1.length ;
                	(14+(varCnt*3), 14, 0, true);
                	head1="";
                	head2="";
                	haed3="";
                	with(sheetObj){
                	for(k=0;k<=varCnt; k++){
                		if(arrhead1[k] != undefined){
//                			2014.12.08 김용습 - arrhead1[k] 마지막 배열에 undefined가 들어가는 현상 수정
	                		head1=head1 + "|D7|D7|D7";
	                		head2=head2 + "|"+ arrhead1[k] +"|"+ arrhead1[k] +"|"+ arrhead1[k];
	                		head3=head3 + "|Within Rate|Over Rate|Rate Type";
                		}
                	}
                	var HeadTitle0="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head1;
                	var HeadTitle1="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head2;
                	var HeadTitle2="Del|STS|group|maxseq|SEQ|SEQ_ORG|VVD|From|To|Trade|R.Lane|Dir.|OPR|★"
                		+ head3;
                	var cnt=0;
                	
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
                    HeadTitle0 = HeadTitle0 + "| | | ";
                    HeadTitle1 = HeadTitle1 + "| | | ";
                    HeadTitle2 = HeadTitle2 + "| | | ";

                	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1, FrozenCol:13 } );

                	var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
                	var headers = [ { Text:HeadTitle0, Align:"Center"},
                	                { Text:HeadTitle1, Align:"Center"},
                	                { Text:HeadTitle2, Align:"Center"} ];
                	InitHeaders(headers, info);

                	var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del", HeaderCheck:0  },
					     {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"group",           KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"maxseq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_prc_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_seq_org",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"M_vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:9,   UpdateEdit:1,   InsertEdit:1, InputCaseSensitive:1, EditLen:9 },
					     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
					     {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",     KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:8 },
					     {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					     {Type:"Combo",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_opr",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					     {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                 	
                	for (var n=0; n<varCnt; n++) {
                 		cols.push({Type:"AutoSum",   Hidden:0, Width:73,   Align:"Right",   ColMerge:1,   SaveName:"WtnRate"+n,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
                 		SetCellBackColor(1, cnt,"#D3DBFF");
                 		cnt++;
                 		cols.push({Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"OvrRate"+n,       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:1,   InsertEdit:1 });
                 		SetCellBackColor(1, cnt,"#D3DBFF");
                 		cnt++;
                 		cols.push({Type:"Combo",     Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"RateType"+n,      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
                 		cnt++;
                 	}
                	
//                  2014.12.05 김용습 - 마지막에 히든 컬럼 만들기 위해 추가
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
                    cols.push({Type:"Text",      Hidden:1, Width:0,  Align:"Center",  ColMerge:1,   SaveName:"empty3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });

                 	InitColumns(cols);
                 	SetCellBackColor(1,cnt,"#D3DBFF");
                 	SetCellBackColor(1,cnt,"#D3DBFF");
                 	SetEditableColorDiff(0);
                 	SetCountPosition(0);
                 	SetHeaderRowHeight(10);
// 		    	    SetSheetHeight(ComGetSheetHeight(sheetObj, sheet_height3)); 
 		    	    SetSheetHeight(445); 
 		    	    
                       first_load2=false;
                       
                       InitComboNoMatchText(1,"",1);
                       
//       			2014.10.23 김용습 - 헤더 툴팁 적용
       				for(z=0; z<=cols.length; z++){       					
       					if(GetCellValue(0,z) == "D7"){
       						SetToolTipText(0, z, "D7");    
       					}
       				}  
       				
       				SetEditArrowBehavior(3); 
       				
     				//SJH.20150209.ADD
				    SetColProperty(0 ,"M_dir_cd" , {AcceptKeys:"NEWS"});
				    SetColProperty(0 ,"M_vvd_cd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
          }
    			break;
    	}
    }
    /**
  	 * Setting combo 
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
 		//
 		if (comboXml.length > 5){
 			comSetIBCombo(sheetObj, comboXml[5], "M_opr",false,0);
 		}
 		if (comboXml.length > 6){
 	 		for(var i=0; i<headCnt; i++){
 	 			comSetIBCombo(sheetObj, comboXml[6], "RateType"+i,true,0);
 	 		}
 		}
 	}
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheet1.ShowDebugMsg(false);
    	switch(sAction) {
    		case IBSEARCH:     
    			if (!validateCond(sheetObj,formObj,sAction)) {
    				return false;
    			}
    			//formObj.f_cmd.value=SEARCHLIST01;
    			formObj.f_cmd.value=SEARCHLIST;
    			//sheet1.DoSearch("ESM_BSA_0172GS.do", bsaFormString(formObj+"&"+getParam(curPgmNo)) );
    			sheetObj.DoSearch("ESM_BSA_0172GS.do",  bsaFormString(formObj,getParam(curPgmNo)));
    			break;
    		case IBSAVE:     
    			//20150820.MOD
    			if(!saveSheet(sheet1, MULTI)) return false;
    			break;
    		case IBDOWNEXCEL:  
    			selectDownExcelMethod(sheetObj,0);
    			break;
    		case IBCOPYROW:      
    			with(sheetObj) {
        			if (RowCount()> 0) {
        				var Row=DataCopy(false);
        				SetCellValue(Row,"M_seq_org","",0);
        				SetCellValue(Row,"M_prc_seq","",0);
    					if (Row > HeaderRows()) {
//            				InitHeadMode(false, false, false, true, false, false); 
                    		SetCellBackColor(Row, "ibflag","#EFEBEF");
                    		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
    					}
    					//SJH.20150209.ADD : 비활성화
    					SetCellEditable(Row, "M_trd_cd", false);
    					SetCellEditable(Row, "M_rlane_cd", false);
    					SetCellEditable(Row, "M_dir_cd", false);
    					SetCellEditable(Row, "M_opr", false);    	
    					
                		//20160119.ADD, 20160317.MOD
						var grpRow=getFindRows(sheet1,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(arrRow[i]) < parseInt(Row)){									
									SetCellEditable(arrRow[i],"M_bsa_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_to_dt",0);	
									SetCellEditable(Row,"M_bsa_fm_dt",1);
									SetCellEditable(Row,"M_bsa_to_dt",1);										
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
    		case IBSEARCH:     
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value=SEARCHLIST02;
     			//sheetObj.DoSearch("ESM_BSA_0172GS.do", bsaFormString(formObj+"&"+getParam(curPgmNo)) );
     			sheetObj.DoSearch("ESM_BSA_0172GS.do", bsaFormString(formObj, getParam(curPgmNo)) );
    			break;
    		case IBSAVE: 
    			//20150820.MOD
    			if(!saveSheet(sheet2, MULTI02)) return false;
    			break;
    		case IBDOWNEXCEL:  
    			selectDownExcelMethod(sheetObj,1);
    			break;
    		case IBCOPYROW:    
    			with(sheetObj) {
        			if (RowCount()> 0) {
        				var Row=DataCopy(false);
        				SetCellValue(Row,"M_seq_org","",0);
        				SetCellValue(Row,"M_prc_seq","",0);
    					if (Row > HeaderRows()) {
//            				InitHeadMode(false, false, false, true, false, false); 
                    		SetCellBackColor(Row, "ibflag","#EFEBEF");
                    		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
    					}
    					//SJH.20150209.ADD : 비활성화
    					SetCellEditable(Row, "M_trd_cd", false);
    					SetCellEditable(Row, "M_rlane_cd", false);
    					SetCellEditable(Row, "M_dir_cd", false);
    					SetCellEditable(Row, "M_opr", false);    
    					
                		//20160119.ADD, 20160317.MOD
    					var grpRow=getFindRows(sheet2,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(arrRow[i]) < parseInt(Row)){									
									SetCellEditable(arrRow[i],"M_bsa_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_to_dt",0);	
									SetCellEditable(Row,"M_bsa_fm_dt",1);
									SetCellEditable(Row,"M_bsa_to_dt",1);										
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
    		case IBSEARCH:      
    			if (!validateCond(formObj)) {
    				return false;
    			}
    			formObj.f_cmd.value=SEARCHLIST03;
     			//sheetObj.DoSearch("ESM_BSA_0172GS.do", bsaFormString(formObj+"&"+getParam(curPgmNo)) );
     			sheetObj.DoSearch("ESM_BSA_0172GS.do", bsaFormString(formObj , getParam(curPgmNo)) );
    			break;
    		case IBSAVE:  
    			//20150820.MOD
    			if(!saveSheet(sheet3, MULTI03)) return false;			
    			break;
    		case IBDOWNEXCEL:   
    			selectDownExcelMethod(sheetObj,2);                         
    			break;
    		case IBCOPYROW:      
    			with(sheetObj) {
        			if (RowCount()> 0) {
        				var Row=DataCopy(false);
        				SetCellValue(Row,"M_seq_org","",0);
        				SetCellValue(Row,"M_prc_seq","",0);
    					if (Row > HeaderRows()) {
//            				InitHeadMode(false, false, false, true, false, false); 
//            				CellValue2(Row,"M_slt_prc_seq")  = parseInt(CellValue(Row,"M_slt_prc_seq")) + 1;
                    		SetCellBackColor(Row, "ibflag","#EFEBEF");
                    		SetCellBackColor(Row, "M_trd_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_rlane_cd","#EFEBEF");
                    		SetCellBackColor(Row, "M_dir_cd","#EFEBEF");
    					}
    					//SJH.20150209.ADD : 비활성화
    					SetCellEditable(Row, "M_trd_cd", false);
    					SetCellEditable(Row, "M_rlane_cd", false);
    					SetCellEditable(Row, "M_dir_cd", false);
    					SetCellEditable(Row, "M_opr", false);    
    					
                		//20160119.ADD, 20160317.MOD
    					var grpRow=getFindRows(sheet3,Row);
						if (grpRow != "") {
							var arrRow=grpRow.split(",");
							for(i=0; i < arrRow.length; i++) {
								if(parseInt(arrRow[i]) < parseInt(Row)){									
									SetCellEditable(arrRow[i],"M_bsa_fm_dt",0);		//20160119.ADD
									SetCellEditable(arrRow[i],"M_bsa_to_dt",0);	
									SetCellEditable(Row,"M_bsa_fm_dt",1);
									SetCellEditable(Row,"M_bsa_to_dt",1);										
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
    //20150820.ADD
    function saveSheet(sheetObj, str){
    	var formObj = document.form;
		if (!validateForm(sheetObj)) {
			return false;
		}
		if (!validateCond2(sheetObj, headTmp)) {
			return false;
		}		
		//20150820.MOD/ADD
    	var sParam = sheetObj.GetSaveString(0);
    	if (!sheetObj.IsDataModified() && sParam == "") {
    		ComShowMessage("There is no contents to save.");
        	return false;
        }     			
		formObj.f_cmd.value=str;
		sParam = sParam + "&" + FormQueryString(formObj);
        var sXml = sheetObj.GetSaveData("ESM_BSA_0172GS.do", sParam);
        sheetObj.LoadSaveData(sXml, {Sync:1});    
//        sheetObj.DoSave("ESM_BSA_0172GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);		//SJH.20150210.MOD
        
        var result = ComGetEtcData(sXml, "result");
		var transResultKey = ComGetEtcData(sXml, "TRANS_RESULT_KEY"); 
		
		if((result == "S"||result=="") && transResultKey == "S"){
			doActionIBSheet(sheetObj,document.form,IBSEARCH);
		}else if(result == "Dup"){
			ComShowCodeMessage('COM12115', '[ Trade, R.Lane, Dir., OPR, From, To ]');
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
    }
    function changeSheet( rdoType){
    		var formObj=document.form;
    			if ( formObj.rdoType[0].checked ) { 
//    		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("d3_opt").style.display="inline";
    	            document.getElementById("d5_opt").style.display="none";
    	            document.getElementById("d7_opt").style.display="none";
//    			    d3_opt.style.display="inline";
//    				d5_opt.style.display="none";
//    			    d7_opt.style.display="none";
    			    
    			    document.getElementById("div_zoom_in").style.display = "none"
            		document.getElementById("div_zoom_out").style.display = "inline"
    			} else if ( formObj.rdoType[1].checked) {
//  		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("d3_opt").style.display="none";
    	            document.getElementById("d5_opt").style.display="inline";
    	            document.getElementById("d7_opt").style.display="none";
//    			    d3_opt.style.display="none";
//    			    d5_opt.style.display="inline"
//    			    d7_opt.style.display="none";
    			    
    			    document.getElementById("div_zoom_in").style.display = "none"
            		document.getElementById("div_zoom_out").style.display = "inline"
    			} else if ( formObj.rdoType[2].checked) {
//		          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    	            document.getElementById("d3_opt").style.display="none";
    	            document.getElementById("d5_opt").style.display="none";
    	            document.getElementById("d7_opt").style.display="inline";
//    				d3_opt.style.display="none";
//    				d5_opt.style.display="none"
//    			    d7_opt.style.display="inline";
    				
    				document.getElementById("div_zoom_in").style.display = "none"
                	document.getElementById("div_zoom_out").style.display = "inline"
    			} 
    			//document.form.f_cost_yrmon.focus();
    			resizeSheet();
    		}
    function sheet1_OnSearchEnd(sheetObj,ErrMsg) {    	
    	with(sheetObj){
    		//Setting and Checking BG color of all row.
    		SetColBackColor("ibflag","#EFEBEF");
    		SetColBackColor("M_prc_seq","#EFEBEF");
    		SetColBackColor("M_trd_cd","#EFEBEF");
    		SetColBackColor("M_rlane_cd","#EFEBEF");
    		SetColBackColor("M_dir_cd","#EFEBEF");
    	}
      
    	//Making the column hidden in case isExcludZero is checked and total value is zero.
    	//sheetObj.RenderSheet(0);
    
    	if(document.form.isExcludZero.checked) {
//    	    sheetObj.SetFrozenCol(1);
    	    sheetObj.RenderSheet(0);
    	    var count = 0;
    	   
//  		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//  		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
	    	for(var k=0; k<=sheetObj.LastCol()-2; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
	  			if(k >= 10){ 
	  				sum = sum + sheetObj.GetSumValue(0,k);
	  			}    			    			
	    	}
  		
//  		2014.12.05 김용습
	  		if(sum==0){
	  			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,0);
	  		}else{
	  			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
	  		}
	  		
//	  		2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
	  		for(var k=14; k<=sheetObj.LastCol()-2; k++) {        
	          		sheetObj.SetColHidden(k,0);	
            }
	        	
//      	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
	  		for(var k=12; k<=sheetObj.LastCol()-3; k++) {  
	  			
        	    if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00 && String(parseFloat(sheetObj.GetSumValue(0,k+1))) == "NaN"){
                    sheetObj.SetColHidden(k,1);
                    sheetObj.SetColHidden(k+1,1);
                 
                    sheetObj.SetColWidth(k,0);
                    sheetObj.SetColWidth(k+1,0);
                }else if (parseFloat(sheetObj.GetSumValue(0,k)) != 0.00 && String(parseFloat(sheetObj.GetSumValue(0,k+1))) == "NaN") {
                	
                	if(k != 13)
                		{
		                	sheetObj.SetColHidden(k,0);
		                	sheetObj.SetColWidth(k,60);
		                	
		                	if(k>13){
		                        sheetObj.SetColHidden(k+1,0);
		                        sheetObj.SetColWidth(k+1,60);
		                	}
                		}
                	
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
            
//          2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
        	
//          2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
        	  for(var k=12; k<=sheetObj.LastCol()-3; k++) {
//            	if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
            	//if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00 && String(parseFloat(sheetObj.GetSumValue(0,k+1))) == "NaN"){
            	if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k)){
                    sheetObj.SetColHidden(k,0);
                    sheetObj.SetColHidden(k+1,0);
                } 
        	    sheetObj.SetColWidth(k,60);  
        	    sheetObj.SetColWidth(k+1,60);  
            }
    	    //sheetObj.SetColWidth(12,60);        	  
            sheetObj.RenderSheet(1);
            //sheetObj.SetFrozenCol(14);
        }  
    	
        sheetObj.SetSumText(1, "TOTAL");
    }
    
    function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//Setting and Checking BG color of all row.
    		SetColBackColor("ibflag","#EFEBEF");
    		SetColBackColor("M_prc_seq","#EFEBEF");
    		SetColBackColor("M_trd_cd","#EFEBEF");
    		SetColBackColor("M_rlane_cd","#EFEBEF");
    		SetColBackColor("M_dir_cd","#EFEBEF");
    	}
        //Making the column hidden in case isExcludZero is checked and total value is zero.
    	
    	
        if(document.form.isExcludZero.checked) {
        	
//        	sheetObj.SetFrozenCol(1);
      	    sheetObj.RenderSheet(0);
      	    var count = 0;
      	  
//  		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//  		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
	    	for(var k=0; k<=sheetObj.LastCol()-2; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
	  			if(k >= 10){ 
	  				sum = sum + sheetObj.GetSumValue(0,k);
	  			}    			    			
	    	}
  		
//  		2014.12.05 김용습
	  		if(sum==0){
	  			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,0);
	  		}else{
	  			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
	  		}
	  		
//	  		2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
	  		for(var k=14; k<=sheetObj.LastCol()-4; k++) {        
	          		sheetObj.SetColHidden(k,0);	
            }
	        	
//      	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
	  		for(var k=12; k<=sheetObj.LastCol()-3; k++) {  
                //if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
               	if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00 && String(parseFloat(sheetObj.GetSumValue(0,k+1))) == "NaN"){
                    sheetObj.SetColHidden(k,1);
                    sheetObj.SetColHidden(k+1,1);
                    
                    sheetObj.SetColWidth(k,0);
                    sheetObj.SetColWidth(k+1,0);
                //}else if (sheetObj.GetCellValue(0, k) == sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) != 0.00) {
                }else if (parseFloat(sheetObj.GetSumValue(0,k)) != 0.00 && String(parseFloat(sheetObj.GetSumValue(0,k+1))) == "NaN") {
                	if(k != 13)
            		{
	                	sheetObj.SetColHidden(k,0);
	                	sheetObj.SetColWidth(k,60);
	                	
	                	if(k>13){
	                        sheetObj.SetColHidden(k+1,0);
	                        sheetObj.SetColWidth(k+1,60);
	                	}
            		}
                	count = k ;
                }
            }
            
            sheetObj.RenderSheet(1);
    		if(count > 13){
    		    sheetObj.SetFrozenCol(13);
    		}
    		
        } else {
        	sheetObj.SetFrozenCol(14);
        	sheetObj.RenderSheet(0);
        	
//          2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
        	for(var k=12; k<=sheetObj.LastCol(); k++) {
            	//if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
            	if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k)){
                    sheetObj.SetColHidden(k,0);
                    sheetObj.SetColHidden(k+1,0);
                } 
        	    sheetObj.SetColWidth(k,60);  
        	    sheetObj.SetColWidth(k+1,60);            	
            }
        	
//          2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
        	
            sheetObj.RenderSheet(1);
        }
        
        sheetObj.SetSumText(1, "TOTAL");
    }
    function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
    	with(sheetObj){
    		//Setting and Checking BG color of all row.
    		SetColBackColor("ibflag","#EFEBEF");
    		SetColBackColor("M_prc_seq","#EFEBEF");
    		SetColBackColor("M_trd_cd","#EFEBEF");
    		SetColBackColor("M_rlane_cd","#EFEBEF");
    		SetColBackColor("M_dir_cd","#EFEBEF");
    	}
        //Making the column hidden in case isExcludZero is checked and total value is zero.
    	
    	
        /*if(document.form.isExcludZero.checked) {
        	
//        	  sheetObj.SetFrozenCol(1);
      	      sheetObj.RenderSheet(0);
      	      var count = 0;
      	    
              for(var k=14; k<=sheetObj.LastCol(); k++) {
//        	  if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
        	      if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                      sheetObj.SetColHidden(k,1);
                      sheetObj.SetColHidden(k+1,1);
                      sheetObj.SetColHidden(k+2,1);
                      
                      sheetObj.SetColWidth(k,0);
                      sheetObj.SetColWidth(k+1,0);
                      sheetObj.SetColWidth(k+2,0);
        	      }else if (sheetObj.GetCellValue(0, k) == sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) != 0.00) {
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
            for(var k=12; k<=sheetObj.LastCol(); k++){
//        	  if(sheetObj.GetCellBackColor(0, k) != sheetObj.GetCellBackColor(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
        	    if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && parseFloat(sheetObj.GetSumValue(0,k)) == 0.00){
                    sheetObj.SetColHidden(k,0);
                    sheetObj.SetColHidden(k+1,0);
                    sheetObj.SetColHidden(k+2,0);
                }           
    	        sheetObj.SetColWidth(k,60);  
            }
            sheetObj.RenderSheet(1);
        }*/
    	
    	if(document.form.isExcludZero.checked) {
//    		sheetObj.SetFrozenCol(1);
      	    sheetObj.RenderSheet(0);
      	    var count = 0;
      	    
//  		2014.12.05 김용습 - only carriers with bsa 체크 후 모든 선사의 total 값의 합이 0일 때 그리드 모양이 깨지는 현상이 있어 해당 현상을 막기 위해 소스 추가
//  		(맨 마지막에 히튼 컬럼을 하나 넣어 놓고, 모든 선사의 total 값의 합이 0일 때는 해당 히든 컬럼이 보여지게 설정하는 로직)
	    	var sum = 0; 
	    	for(var k=0; k<=sheetObj.LastCol()-3; k++) { // 모든 선사의 total 값이 0인지 아닌지 구분하기 위해 만든 for문    	    			   			
	  			if(k >= 10){ 
	  				sum = sum + sheetObj.GetSumValue(0,k);
	  			}    			    			
	    	}
  		
//  		2014.12.05 김용습
	  		if(sum==0){
	  			sheetObj.SetColHidden(sheetObj.LastCol(),0); // sum(모든 선사의 total 값의 합)이 0일 경우에는 마지막 숨겨진 컬럼의 hidden을 품
//	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,0);
//	  			sheetObj.SetColHidden(sheetObj.LastCol()-2,0);
	  		}else{
	  			sheetObj.SetColHidden(sheetObj.LastCol(),1); // sum(모든 선사의 total 값의 합)이 0이 아닐 경우에는 마지막 숨겨진 컬럼의 hidden을 유지
//	  			sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
//	  			sheetObj.SetColHidden(sheetObj.LastCol()-2,1);
	  		}
	  		
//	  		2014.12.05 김용습 - only carriers with bsa 체크하여 0인 컬럼들이 히든되기 전에, 일단 모든 컬럼이 보여지게 함. 그렇지 않으면 다른 검색조건으로 재차 조회할 때 이미 히든되어져 있는 컬럼들 중에 0이 아닌 컬럼들이 이미 히든되어 있기 때문에 다시 나타나지 않는 현상이 생김
	  		for(var k=14; k<=sheetObj.LastCol()-4; k++) {        
	          		sheetObj.SetColHidden(k,0);	
            }
            
//      	2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
	  		for(var k=12; k<=sheetObj.LastCol()-4; k++) { 
    	    	 //if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.000){
    	    	 if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k) && (parseFloat(sheetObj.GetSumValue(0,k)) == 0.000 || parseFloat(sheetObj.GetSumValue(0,k+1)) == 0.000) && String(parseFloat(sheetObj.GetSumValue(0,k+2))) == "NaN"){
    				sheetObj.SetColHidden(k,1);
    				sheetObj.SetColHidden(k+1,1);
    				sheetObj.SetColHidden(k+2,1);
       				k=k+2;
    			//} else {
    			}else if ((parseFloat(sheetObj.GetSumValue(0,k)) != 0.000 || parseFloat(sheetObj.GetSumValue(0,k+1)) != 0.000) && String(parseFloat(sheetObj.GetSumValue(0,k+2))) == "NaN") {
                	if(k != 13)
            		{
	                	sheetObj.SetColHidden(k,0);
	                	sheetObj.SetColWidth(k,60);
	                	
	                	if(k>13){
	                        sheetObj.SetColHidden(k+1,0);
	                        sheetObj.SetColWidth(k+1,60);
	                        sheetObj.SetColHidden(k+2,0);
	                        sheetObj.SetColWidth(k+2,60);
	                	}
            		}
    				count = k;
    			}
    		}
    	    sheetObj.RenderSheet(1);
    	    if(count > 13){
    		    sheetObj.SetFrozenCol(13);
    		}
    	} else {
    		sheetObj.RenderSheet(0);
    		
//          2014.12.05 김용습 - 마지막 컬럼은 히든되지 않도록 k<=sheetObj.LastCol()에서 k<=sheetObj.LastCol()-3으로 변경
        	for(var k=12; k<=sheetObj.LastCol(); k++) {
    			//if(parseFloat(sheetObj.GetSumValue(0,k)) == 0.000){
    			if(sheetObj.GetCellValue(0, k) != sheetObj.GetCellValue(1, k)){
    			    sheetObj.SetColHidden(k,0);
    			    sheetObj.SetColHidden(k+1,0);
    			    sheetObj.SetColHidden(k+2,0);
    			    //if(sheetObj==sheetObjects[2]) sheetObj.SetColHidden(k+2,0);
    		    }  
    			sheetObj.SetColWidth(k,60);
    			sheetObj.SetColWidth(k+1,60); 
    			//if(sheetObj==sheetObjects[2]) sheetObj.SetColWidth(k+2,60);
    			sheetObj.SetColWidth(k+2,60); 
    	    }	      
        	
//          2014.12.05 김용습 - only carriers with bsa 체크 하지 않았을 때는 마지막 숨겨진 컬럼이 무조건 hidden되게 설정
        	sheetObj.SetColHidden(sheetObj.LastCol(),1);
        	sheetObj.SetColHidden(sheetObj.LastCol()-1,1);
        	sheetObj.SetColHidden(sheetObj.LastCol()-2,1);
        	
    	    sheetObj.RenderSheet(1);
    		sheetObj.SetFrozenCol(13);

    	}
        
        sheetObj.SetSumText(1, "TOTAL");
    }
        function sheet1_OnChange(sheetObj,Row,Col,Value) {
        	 var param="";
        	 ComOpenWait(true);
        	with(sheetObj){
        	    // Cotrolling color of the column 
        		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00F8FB")
        			{ //in case of changing the value
        				SetCellBackColor(Row,Col,"#FFF8FB");
        			} 
        		else { // Turning back "#FFFF00" in case changed value is same as orginal value
        			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB" )
        			{
        				SetCellBackColor(Row,Col,"#FFFF00");
        			}
        		}
        		// Cotrolling period and status
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
        			SetCellValue(Row-1,"M_bsa_to_dt",getOffsetDate(Value,-1),0);
//        			Cellvalue2(Row-1, "ibflag")="U";
//        			SetCellValue(Row-1, "ibflag", "U");
        			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
        				SetCellValue(Row,"M_bsa_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_fm_dt"),-1),0);
        			}
        		}
        		// Changing SEQ, status and period in case of changing DEL status
        		if(sheetObj.ColSaveName(Col) == "del") {
        			//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
    				var index=0;
    				var v_num=1;
                    for(i=1; i<LastRow(); i++){
                    	index=FindText("group", GetCellValue(Row,"group"), i, true);
                    	if(i == 1) v_num=GetCellValue(index, "M_prc_seq");
                        if (index >0){
                        	if(GetCellValue(index, "ibflag") != "D"){
                                SetCellValue(index,"M_prc_seq",v_num);
                                v_num++;
                            } else {
                                SetCellValue(index, "M_prc_seq",CellSearchValue(index, "M_prc_seq"));
                            }
                            i=parseInt(index);
                        } else {
                            i=LastRow();
                        }
                    }
            		// Changing status according to changing SEQ
            		for(i=Row+1; i<=sheetObj.LastRow(); i++){
            			if(sheetObj.GetCellValue(Row,"group") == sheetObj.GetCellValue(i,"group")){
            				if(parseInt(sheetObj.GetCellValue(Row,"maxseq")) < parseInt(sheetObj.GetCellValue(i,"M_prc_seq"))){
//                        		if(sheetObj.SetCellValue(i, "ibflag") != "D") sheetObj.Cellvalue2(i, "ibflag","I");
                        		if(sheetObj.SetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","I");
            		        } else {
            		        	if(sheetObj.GetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","U",0);
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
        		if (ColSaveName(Col) == "M_bsa_fm_dt" || ColSaveName(Col) == "M_bsa_to_dt") {
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_fm_dt") != "" && GetCellValue(selRow,"M_bsa_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_to_dt")) ) {
				  	 		 alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}        		
        		// Setting First ETD DT in case of changing VVD
            	if (ColSaveName(Col) == "M_vvd_cd") {
        			selRow=Row;
        			selValue=Value;
        			param=param+"f_cmd="+SEARCHLIST02;
        			param=param+"&vvd_cd="+GetCellValue(Row,Col);
        			param=param+"&code=etdDt";
         			var sXml=GetSearchData("ESM_BSA_CODE.do", param);
        			var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
        			getEdtDate(etdDt);
            	}        		
        	} 
        	//SJH.20150210.MOD
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
           	 	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
        	}         	
        	ComOpenWait(false);
        }
        //VVD --> edt-date
          /**
         * Handling in case of changing sheet data
         * Setting First ETD DT in case of changing VVD
         */
        function sheet2_OnChange(sheetObj,Row,Col,Value) {
        	var formObj=document.form;
       	 	var param="";
        	ComOpenWait(true);
        	with(sheetObj){
        	    // Cotrolling color of the column 
        		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFFF00F8FB"){ //in case of changing the value
        			SetCellBackColor(Row,Col,"#FFF8FB");
        		} else { //Turning back "#FFFF00" in case changed value is same as orginal value
        			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
        				SetCellBackColor(Row,Col,"#FFFF00");
        			}
        		}
        		// Cotrolling period and status 
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
        			SetCellValue(Row-1,"M_bsa_to_dt",getOffsetDate(Value,-1),0);
//        			Cellvalue2(Row-1, "ibflag")="U";
//        			SetCellValue(Row-1, "ibflag", "U");
        			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
        				SetCellValue(Row,"M_bsa_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_fm_dt"),-1),0);
        			}
        		}
        		// Changing SEQ, status and period in case of changing DEL status
        		if(sheetObj.ColSaveName(Col) == "del") {
        			//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
    				var index=0;
    				var v_num=1;
                    for(i=1; i<LastRow(); i++){
                    	index=FindText("group", GetCellValue(Row,"group"), i, true);
                    	if(i == 1) v_num=GetCellValue(index, "M_prc_seq");
                        if (index >0){
                        	if(GetCellValue(index, "ibflag") != "D"){
                                SetCellValue(index,"M_prc_seq",v_num);
                                v_num++;
                            } else {
                                SetCellValue(index, "M_prc_seq",CellSearchValue(index, "M_prc_seq"));
                            }
                            i=parseInt(index);
                        } else {
                            i=LastRow();
                        }
                    }
            		// Changing status according to changing SEQ
            		for(i=Row+1; i<=sheetObj.LastRow(); i++){
            			if(sheetObj.GetCellValue(Row,"group") == sheetObj.GetCellValue(i,"group")){
            				if(parseInt(sheetObj.GetCellValue(Row,"maxseq")) < parseInt(sheetObj.GetCellValue(i,"M_prc_seq"))){
//                        		if(sheetObj.SetCellValue(i, "ibflag") != "D") sheetObj.Cellvalue2(i, "ibflag","I");
                        		if(sheetObj.SetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","I");
            		        } else {
            		        	if(sheetObj.GetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","U",0);
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
        		if (ColSaveName(Col) == "M_bsa_fm_dt" || ColSaveName(Col) == "M_bsa_to_dt") {
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_fm_dt") != "" && GetCellValue(selRow,"M_bsa_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_to_dt")) ) {
				  	 		 alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}         		
            	// Setting First ETD DT in case of changing VVD
            	if (ColSaveName(Col) == "M_vvd_cd") {
        			selRow=Row;
        			selValue=Value;
        			param=param+"f_cmd="+SEARCHLIST02;
        			param=param+"&vvd_cd="+GetCellValue(Row,Col);
        			param=param+"&code=etdDt";
         			var sXml=GetSearchData("ESM_BSA_CODE.do", param);
        			var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
        			getEdtDate(etdDt);
            	}        		
        	}
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
            	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
    		}
        	ComOpenWait(false);
        }
        /**
         * Handling in case of changing sheet data
         * Setting First ETD DT in case of changing VVD
         */
        function sheet3_OnChange(sheetObj,Row,Col,Value) {
            var formObj=document.form;
       	 	var param="";
            ComOpenWait(true);
        	with(sheetObj){
        	    // Cotrolling color of the column 
        		if (Value != 0 && GetCellBackColor(Row,Col) == "#FFF8FB"){ //in case of changing the value
        			SetCellBackColor(Row,Col,"#FFF8FB");
        		} else { //Turning back "#FFFF00" in case changed value is same as orginal value
        			if (Value == CellSearchValue(Row,Col) && GetCellBackColor(Row,Col) == "#FFF8FB") {
        				SetCellBackColor(Row,Col,"#FFFF00");
        			}
        		}
        		// Cotrolling period and status 
        		if (ColSaveName(Col) == "M_bsa_fm_dt" && GetCellValue(Row-1,"group") == GetCellValue(Row,"group")) {
        			SetCellValue(Row-1,"M_bsa_to_dt",getOffsetDate(Value,-1),0);
//        			Cellvalue2(Row-1, "ibflag")="U";
//        			SetCellValue(Row-1, "ibflag", "U");
        			if(GetCellValue(Row,"group") == GetCellValue(Row+1,"group")){
        				SetCellValue(Row,"M_bsa_to_dt",getOffsetDate(GetCellValue(Row+1,"M_bsa_fm_dt"),-1),0);
        			}
        		}
        		// Changing SEQ, status and period in case of changing DEL status
        		if(sheetObj.ColSaveName(Col) == "del") {
        			//Setting SEQ in all row except the rows deleted from the group in case of status is "delete"
    				var index=0;
    				var v_num=1;
                    for(i=1; i<LastRow(); i++){
                    	index=FindText("group", GetCellValue(Row,"group"), i, true);
                    	if(i == 1) v_num=GetCellValue(index, "M_prc_seq");
                        if (index >0){
                        	if(GetCellValue(index, "ibflag") != "D"){
                                SetCellValue(index,"M_prc_seq",v_num);
                                v_num++;
                            } else {
                                SetCellValue(index, "M_prc_seq",CellSearchValue(index, "M_prc_seq"));
                            }
                            i=parseInt(index);
                        } else {
                            i=LastRow();
                        }
                    }
            		// Changing status according to changing SEQ
            		for(i=Row+1; i<=sheetObj.LastRow(); i++){
            			if(sheetObj.GetCellValue(Row,"group") == sheetObj.GetCellValue(i,"group")){
            				if(parseInt(sheetObj.GetCellValue(Row,"maxseq")) < parseInt(sheetObj.GetCellValue(i,"M_prc_seq"))){
            					if(sheetObj.GetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","I",0);
            		        } else {
            		        	if(sheetObj.GetCellValue(i, "ibflag") != "D") sheetObj.SetCellValue(i, "ibflag","U",0);
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
        		if (ColSaveName(Col) == "M_bsa_fm_dt" || ColSaveName(Col) == "M_bsa_to_dt") {        			
        			selRow=Row;
    				if(GetCellValue(selRow,"M_bsa_fm_dt") != "" && GetCellValue(selRow,"M_bsa_to_dt") != "" ) {
    					if ( parseInt(GetCellValue(selRow, "M_bsa_fm_dt")) > parseInt(GetCellValue(selRow,"M_bsa_to_dt")) ) {
				  	 		alert("From Date is greater than To Date.");
				  	 		SetCellValue(selRow,"M_bsa_to_dt","",0);
    						ComOpenWait(false);
    						return false;
						}
    				} 
        		}         		
            	// Setting First ETD DT in case of changing VVD
            	if (ColSaveName(Col) == "M_vvd_cd") {
        			selRow=Row;
        			selValue=Value;
        			param=param+"f_cmd="+SEARCHLIST02;
        			param=param+"&vvd_cd="+GetCellValue(Row,Col);
        			param=param+"&code=etdDt";
         			var sXml=GetSearchData("ESM_BSA_CODE.do", param);
        			var etdDt=GetEtcDataForExceptional(sXml, "etdDt", "0");
        			getEdtDate(etdDt);
            	}        		
        	}
        	if (sheetObj.ColSaveName(Col) == "M_trd_cd") {
           	 	ComOpenWait(false);
        		ibTrade_OnChange(sheetObj, Row, Col);
    		}
        	ComOpenWait(false);
        }
    function getEdtDate(result) {
        	var sheetObj ;
        	var tmpRow=0;
        	var formObj=document.form;
        	if(formObj.rdoType[0].checked){
        		sheetObj=sheetObjects[0];
       		}else if(formObj.rdoType[1].checked){
    	   			sheetObj=sheetObjects[1];	
       		}else if(formObj.rdoType[2].checked){
    	   			sheetObj=sheetObjects[2];	
       		}
        	if(result == null || result == "" || result == "null"){
        		ComShowMessage(ComGetMsg('BSA10027',selValue));  
        		sheetObj.SelectCell(selRow,"M_vvd_cd",true);
        	} else {
        		sheetObj.SetCellValue(selRow,"M_bsa_fm_dt",result);
        	}
        }
    /**
     * Handling validation check process for input value on the page
     */
    function validateForm(sheetObj) {
    	with(sheetObj){
    	}
    	return true;
    }
    /**
     * Handling validation check process for retrieved value on the page 
     */
    function validateCond(formObj) {
    	formObj = document.form;
    	if (ComTrim(formObj.txtSDate.value) == "") {
    			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
    			//txtSDate.focus();
    			ComAlertFocus(formObj.txtSDate, ComGetMsg('COM12130','Period','First Element'));
    			return false;
		}
		if (ComTrim(formObj.txtSDate.value) != "" && ComTrim(formObj.txtEDate.value) != "") {
			if(parseInt(formObj.txtSDate.value) > parseInt(formObj.txtEDate.value)){
				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
				//txtEDate.focus();
				ComAlertFocus(formObj.txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
				return false;
			}
		}
    	return true;
    }
    function validateCond2(sheetObj,head) {
     var arrhead1="";
     var varCnt=0;  
     var row=sheetObj.FindStatusRow("U|D|I");
     var arrRow=row.split(";");
     var formObject=document.form;
     arrhead1=head.replace(/(^\s*)/g, '').split("|");
     varCnt=arrhead1.length ;
     for(i=0;i<arrRow.length;i++){
    	 for (n=0; n<varCnt; n++) {
//    	 	alert(sheetObj.CellValue(row[i],"OvrRate"+n) + " : "+sheetObj.CellValue(row[i],"RateType"+n));
    	  /*if(formObject.rdoType[0].checked){ 
    		  if ((sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0 && sheetObj.GetCellValue(arrRow[i],"RateType"+n) != "") ||
    				  (sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) != 0 && sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "")
    		    ) {
    			  alert("Please check Rate, RateType")
    			   return false;
    		  }
    	  }else if(formObject.rdoType[1].checked){ 
    		  if ((sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0 && sheetObj.GetCellValue(arrRow[i],"RateType"+n) != "") ||
    				  (sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) != 0 && sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "")
    		    ) {
    			  alert("Please check Rate, RateType")
    			   return false;
    		 }   
    	  }else if(formObject.rdoType[2].checked){	  
    		  if (((sheetObj.GetCellValue(arrRow[i],"WtnRate"+n) == 0 || sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0) && sheetObj.GetCellValue(arrRow[i],"RateType"+n) != "")||
    				  ((sheetObj.GetCellValue(arrRow[i],"WtnRate"+n) != 0 || sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) != 0) && sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "")
    	 		) {
    	 			alert("Please check Rate, RateType")
    			   return false;
    	 		}
    	  }*/ 
		  if(formObject.rdoType[0].checked){ 
		  	 if ((sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "V" && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  ) ||
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "R" && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0 ) ||
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == ""  && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  )) {
		  	 		 alert("Please check Rate, RateType")
		  	 		 return false;
		  	  }
		  }else if(formObject.rdoType[1].checked){ 
		  	 if ((sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "V" && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  ) ||
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "R" && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0 ) || 
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == ""  && sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  )) {
		  	 		 alert("Please check Rate, RateType")
		  	 		 return false;
		  	 }   
		  }else if(formObject.rdoType[2].checked){
		  	 if ((sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "V" && (sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  || sheetObj.GetCellValue(arrRow[i],"WtnRate"+n) > 0 )) ||
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == "R" && (sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) == 0 || sheetObj.GetCellValue(arrRow[i],"WtnRate"+n) == 0)) ||
		  	 	(sheetObj.GetCellValue(arrRow[i],"RateType"+n) == ""  && (sheetObj.GetCellValue(arrRow[i],"OvrRate"+n) > 0  || sheetObj.GetCellValue(arrRow[i],"WtnRate"+n) > 0 ))) {
		  	 		 alert("Please check Rate, RateType")
		  	 		 return false;
		  	 }					  
		  }    	  
      } // for (n=0; n<varCnt; n++)
    } // for(i=0;i<arrRow.length-1;i++)
     
    //SJH.20150209.ADD
	with(sheetObj) {
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
	    				GetCellValue(z,"M_trd_cd") == GetCellValue(cRow,"M_trd_cd") && 
	    				GetCellValue(z,"M_rlane_cd") == GetCellValue(cRow,"M_rlane_cd") && 
	    				GetCellValue(z,"M_dir_cd") == GetCellValue(cRow,"M_dir_cd") &&
	    				GetCellValue(z,"M_opr") == GetCellValue(cRow,"M_opr")) {
	    				if(GetCellValue(z, "ibflag") != "D") {								//20150820.ADD
							if (GetCellValue(cRow, "M_bsa_fm_dt").length > 0) {
								if (parseInt(GetCellValue(cRow, "M_bsa_fm_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
									parseInt(GetCellValue(cRow, "M_bsa_fm_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {									 
						  	 		 alert("Effective Date can not be Duplicate. ( "+(z-HeaderRows()+1)+" Row )");
						  	 		 return false; 
								}
							}
							//SJH.20150211.ADD
							if (GetCellValue(cRow, "M_bsa_to_dt").length > 0) {
								if (parseInt(GetCellValue(cRow, "M_bsa_to_dt")) >= parseInt(GetCellValue(z,"M_bsa_fm_dt")) &&
									parseInt(GetCellValue(cRow, "M_bsa_to_dt")) <= parseInt(GetCellValue(z,"M_bsa_to_dt"))) {
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
     * showing R.Lane with using ifram
     */
    function cobTrade_OnChange(obj) {
		if (loadingMode == true) return; 
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		var param="";
		var trd_cd="";
		sheetObj.SetWaitImageVisible(0);
		if(obj.GetSelectText()!= ""){
			trd_cd=obj.GetSelectCode();
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
		sheetObj.SetWaitImageVisible(0);
  		with(sheetObj) {
  			trd_cd=GetCellValue(row, col);
  			if(trd_cd != ""){
  				param="f_cmd="+SEARCHLIST02;
  				param=param+"&trd_cd="+trd_cd;
  				param=param+"&code=ibLane";
   				var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
  				var rlane=GetEtcDataForExceptional(sXml, "trdCd", "0");
				sheetObj.CellComboItem(row,"M_rlane_cd", {ComboText:rlane, ComboCode:rlane} );
  			}
  		}
		sheetObj.SetWaitImageVisible(1);
  	}
    
    

    function callBackExcelMethod(excelType) {	
        var sheetObj = sheetObjects[excelType[1]];
        switch (excelType[0]) {
        case "AY":
            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
            break;
        case "AN":
            sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
            break;
        case "DY":
            sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
            break;
        case "DN":
            sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
            break;

    	}            
    }
    
    function resizeSheet(){
        for (i=0; i<sheetObjects.length; i++){
            ComResizeSheet(sheetObjects[i]);
        }
    }

	//sheet의 현재선택된 Row의 상/하위(offset 만큼) Row를 리턴 : 20160119.ADD
	 function getFindRow(sheetObj, Row, offset) {
	 	var rtnRow=-1;
	 	var bsa_group="";
	 	var bsa_seq=-1;
	 	var col1=0;
	 	var col2=0;
	 	var tmp=0;
	 	with(sheetObj) {
	 		sltPrcGroup=GetCellValue(Row,"group");
	 		sltPrcSeq=parseInt(GetCellValue(Row,"maxseq"));
	 		for (var i=HeaderRows(); i<LastRow(); i++) {
	 			col1=FindText("group", sltPrcGroup, tmp);
	 			if (col1 == -1) { break; } //Not Found
	 			col2=FindText("M_prc_seq", String(sltPrcSeq), col1);
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
				SetCellEditable(col1,"M_bsa_fm_dt",1);
				SetCellEditable(col1,"M_bsa_to_dt",1);
				rtnRow=rtnRow+col1+",";
				tmp=col1 + 1;
			}
		}
		return rtnRow;
	 }		 
