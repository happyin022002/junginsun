/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0063.jsp
*@FileTitle  : CNTR repo execution feed back examine
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
    // common static variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		   // checking button disable
    		if(!ComIsBtnEnable(srcName) ) return;
            switch(srcName) {
        	    case "btn_retrieve":
        	        sheetObject1.RemoveAll();
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            sheetObject1.RemoveAll();
    	            formObject.reset();
    	            //loadPage();
    	            comboObjects[0].SetSelectCode(consTpsz);
    	            displayORG(0);
    	            
    	            displayType();
    	        	tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value);
    	        	displayORG();
    	        	
    	            var result="";
    	            document.form.gubun.value     = "Load";
    	            document.form.gapmonth.value  = "8";
    	            document.form.editmonth.value = "12";
    	            
    	    	    document.form.f_cmd.value=SEARCHLIST14;
    	            document.form.target="periorIframe";
    	            //document.form.action="EES_CHECK_PERIOD.do?gapmonth="+gapmonth+"&gubun="+gubun+"&editmonth="+editmonth;
    	            document.form.action="EES_CHECK_PERIOD.do";
    	            //result=document.form.submit();
    	            document.form.submit();
    	            //result = document.frames["periorIframe"].document.form.submit();
    	            
        	        break;
         	    case "btn_downexcel":
         	    	sheetObject.Down2ExcelBuffer(true);
         	    	if(sheetObject.RowCount() < 1){//no data
         	    		ComShowCodeMessage("COM132501");
         	    	}else{
         	    			sheetObject.Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:true });
         	    	}
    	            if(sheetObject1.RowCount() > 0){
    	            	sheetObject1.Down2Excel({ HiddenColumn:true, SheetDesign:1,Merge:true });
    	            }
    	            sheetObject.Down2ExcelBuffer(false);
        	        break;
        	    case "btn_print":
        	    	 if(sheetObjects[1].RowCount() > 0){
                     	sheetObjects[1].DoPrint();
                     }
                    if(sheetObjects[0].RowCount() > 0){
                    	sheetObjects[0].DoPrint();
                    }
                   
                    if(sheetObjects[0].RowCount() == 0 && sheetObjects[1].RowCount() == 0){
                    	ComShowCodeMessage("EQR90095");
                    }
        	        break;
        	    case "fmloc_btn":
                var display="0,1,1,1,1,1";
                var targetObjList="loc_cd:fmEccCd|loc_dpth_cd:fmType";
  				      var param="?depth=3&classId=COM_ENS_0O1";
  				      ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
  				      break;
              case "toloc_btn":
                var display="0,1,1,1,1,1";
                var targetObjList="loc_cd:toEccCd|loc_dpth_cd:toType";
  				      var param="?depth=3&classId=COM_ENS_0O1";
  				      ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display, true);
  		          break;
                case "btn_lane":
                    var v_display="0,1";
                    var targetObjList="lane:lane";
                    var param="?classId=COM_ENS_0P1&depth=2&chkDepth=2";
                    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 500, 450, targetObjList, v_display, true);
                    break;
                case "btn_up_1":
                		if($("#btn_up_1").hasClass("btn_up")){
                			$("#btn_up_1").removeClass("btn_up").addClass("btn_down mar_btm_4");
                		}
                		else{
                			$("#btn_up_1").removeClass("btn_down").addClass("btn_up mar_btm_4");
                		}
                	break;
                case "btn_up_2":
            		if($("#btn_up_2").hasClass("btn_up")){
            			$("#btn_up_2").removeClass("btn_up").addClass("btn_down mar_btm_4");
            		}
            		else{
            			$("#btn_up_2").removeClass("btn_down").addClass("btn_up mar_btm_4");
            		}
            	break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage("EQR90004");
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
    function loadPage() {
    	
        for(var i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(var p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        
    	displayType();
    	tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value);
    	displayORG();
    	
        var result="";
        document.form.gubun.value     = "Load";
        document.form.gapmonth.value  = "8";
        document.form.editmonth.value = "12";
        
	    document.form.f_cmd.value=SEARCHLIST14;
        document.form.target="periorIframe";
        //document.form.action="EES_CHECK_PERIOD.do?gapmonth="+gapmonth+"&gubun="+gubun+"&editmonth="+editmonth;
        document.form.action="EES_CHECK_PERIOD.do";
        //result=document.form.submit();
        document.form.submit();
        //result = document.frames["periorIframe"].document.form.submit();
    }
    
    
    /*
     * from-to week 년도 주차 info를 셋팅합니다.
     */
    function setCheckWeek(gubun){
      if(gubun == 'Load'){
        document.form.fmPlnSYr.value=periorIframe.document.form.fm_yr.value;
        document.form.fmPlnSWk.value=periorIframe.document.form.fm_wk.value;
        document.form.fmPlnEYr.value=periorIframe.document.form.to_yr.value;
        document.form.fmPlnEWk.value=periorIframe.document.form.to_wk.value;
        document.form.toPlnSYr.value=periorIframe.document.form.fm_yr.value;
        document.form.toPlnSWk.value=periorIframe.document.form.fm_wk.value;
        document.form.toPlnEYr.value=periorIframe.document.form.to_yr.value;
        document.form.toPlnEWk.value=periorIframe.document.form.to_wk.value;
      }
    }
    
    
   /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo,tpsz) {
        var cnt=0;

        var cheRatioVol=document.form.ratioVol[0].checked; // Ratio, Vol 라디오 checking 박스

        var titleName="";
        var TitleCount;
        var TitleKey=consTpsz;
        var tpszTitle="";
        var volCostTitle="";
        var titleFrequency="";
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                	if(cheRatioVol == true) {  // in case of Ratio checked
                		titleName="Adhere Ratio(b/a)|Perf. Ratio(c/a)|W/O Ratio(c/b)|";
                    } else {                  // in case of Vol checked
                    	titleName="Adhere Ratio(a-b)|Perf. Ratio(a-c)|W/O Ratio(b-c)|";
                    }
                	
                    titleFrequency="Frequency";
                    
                    var HeadTitle0="|Week|LOC|LOC|Item|Plan(a)|Execution(b)|W/O(c)|"+titleName+"|Feedback|Feedback|Feedback|Feedback|Feedback|Feedback|Feedback|Feedback|Feedback|Feedback" ;
                    var HeadTitle1="|Week|ORG|DST|Item|Vol.| Vol.|Vol.| Vol.|Vol.| Vol.|"+titleFrequency+"|01|02|03|04|05|06|07|08|99"
                    SetConfig( { SearchMode:0, MergeSheet:1, Page:20, DataRowMerge:0,PrevColumnMergeMode:0 } );
                    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
                    var headers = [ { Text:HeadTitle0, Align:"Center"}, { Text:HeadTitle1, Align:"Center"} ];
                    InitHeaders(headers, info);
                    var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"" },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"orgCd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
								{Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dstCd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
								{Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"item",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
								{Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"adherence",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:0,   SaveName:"perfratio",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"woissued",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"totVol",             KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:13 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"",                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"orgViewBy" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"dstViewBy" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ratioVolFlag" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"weeklyMonthlyFlag" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"fmSYrWk" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"fmEYrWk" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"toSYrWk" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"toEYrWk" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"adherenceCd" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"weekMonth" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"frequencyCd" },
								{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"itemCd" } ];
            
                    InitColumns(cols);
                    SetCellBackColor(1,2,"#555555");
                    //SetHeaderRowHeight(7);
                    for( var i=3; i < 28; i++) {
                    	SetCellBackColor(1,i,GetCellBackColor(1,2));
                    }
                    SetEditable(0);
//                    SetCellBackColor(1,i,GetCellBackColor(1,2));
                    SetSheetHeight(240);
               }
                break;
            case 2:      //IBSheet1 init
            	with(sheetObj){
        		if ((tpsz =='' || tpsz == null)){
        			for(i=0; i<consTpszArr.length; i++) {
        				tpszTitle=tpszTitle + consTpszArr[i]+"|";
        				if (i % 2 == 1) {
        					volCostTitle=volCostTitle + "Vol.|";
        				} else {
        					volCostTitle=volCostTitle + " Vol.|";
        				}
        			}
        			num=TitleKey.split(',');
        			TotalCount=8 + 1 * consTpszArr.length;
        		}else {
        			TitleCount=""+ tpsz +"";
        			tpszTitle=TitleMake1(TitleCount);
        			volCostTitle=TitleMake2(TitleCount);
        			num=TitleCount.split(',');
        			TotalCount=8 + 1 * num.length;
        		}
              
              
        		var HeadTitle0="Week|LOC|LOC|Co.|Item|Lane|Div.|Total|" + tpszTitle;
        		var HeadTitle1="Week|ORG|DST|Co.|Item|Lane|Div.|Vol.|" + volCostTitle;

        		SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:1, DataRowMerge:0 } );

        		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        		var headers = [ { Text:HeadTitle0, Align:"Center"},
        					{ Text:HeadTitle1, Align:"Center"} ];
        		InitHeaders(headers, info);

        		var cols = [ {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"div",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Float",     Hidden:0,  Width:90,   Align:"Right",   ColMerge:0,   SaveName:"totalVol",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 } ];
        		for(var i=0; i<num.length ; i++) {
        			cols.push({Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:num[i]+"_vol",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 });
        		}
        	for( var i=5 ; i < 29 ; i ++)
        	{
        		SetCellBackColor(1,i,GetCellBackColor(1,4));
        	}
         
              InitColumns(cols);
              SetCellBackColor(1,1,"#555555");
              SetCellBackColor(1,2,"#555555");
        	SetEditable(0);
              //SetCellBackColor(1,i,GetCellBackColor(1,4));
        	SetSheetHeight(240);
       //resizeSheet();
              
                    }
                
                
                break;
        }
    }
    
    
	function resizeSheet(){
	    //ComResizeSheet(sheetObjects[sheetObjects.length-1]);
	}
   /**
     * initializing Tab
     * setting Tab items
     */
    function initCombo (comboObj, comboNo) {
        var cnt=0 ;
        switch(comboNo) {
            case 1:
               with (comboObj) {
               SetDropHeight(12 * 18);
              	SetMultiSelect(1);
               	SetMaxSelect(consTpszArr.length );
               	SetMultiSeparator(","); 
               	var menuname1=tpszallText.split('|');
                var menucode1=tpszallText.split('|');
				for(i=0; i<menuname1.length; i++) {
                	InsertItem(cnt ++, menuname1[i], menucode1[i]);
              	}
    	    }
               break;
            case 2:
               with (comboObj) {
               SetDropHeight(12 * 18);
              	SetMultiSelect(1);
               	SetMaxSelect(10 );
               	SetMultiSeparator(","); 
               	var menuname3=reasonText.split('|');
                var menucode3=reasonCode.split('|');
				    for(i=0; i<menuname3.length; i++) {
                	InsertItem(cnt ++, menuname3[i], menucode3[i]);
              	}
    	    }
               break;
         }
    }
  // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        var title=new Array(comboObjects[0].GetSelectText());
        switch(sAction) {
           case IBSEARCH:      //retrieve
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                formObj.headTitle.value=title;
                oddTpsz(0);

                // showing again after initailizing sheet for dyanamic view
                sheet1.RenderSheet(0);      
                sheet1 = sheet1.Reset();
                ComConfigSheet (sheet1);
                initSheet(sheet1, 1, title);
                ComEndConfigSheet(sheet1);
                sheet1.RenderSheet(1);
                sheetObjects[0] = sheet1;
                
                sheetObjects[1] = sheet2;
                sheetObjects[1] = sheetObjects[1].Reset();
                initSheet(sheetObjects[1],2,title);
                
                //sheetObj.SetExtendLastCol(0);
                formObj.f_cmd.value=SEARCHLIST;
                sheetObjects[0].DoSearch("EES_EQR_0063GS.do", eqrFormQryStr(formObj) );
                break;
            case IBSAVE:          // saving
              if(validateForm(sheetObj,formObj,sAction))
                //sheetObj.DoAllSave("com.clt.apps.bms.bms.pfm.managemarketstatus.UIBMSPFM001Action.do", FormQueryString(formObj));
                break;
           case IBINSERT:         // inserting
                sheetObj.DataInsert();
                break;
           case IBCOPYROW:        //copying row
              sheetObj.DataCopy();
            break;
           case IBDOWNEXCEL:        //downloading excel
        	   if(sheetObj.RowCount() < 1){//no data
        		   ComShowCodeMessage("COM132501");
        		   }else{
        			   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
        		   }
              break;
           case IBLOADEXCEL:        //uploading excel
        	   sheetObj.LoadExcel();
              break;
        }
    }
    

    
    
    function doActionIBSheet2(sheetObj,formObj,sAction,param) {
        sheetObj.ShowDebugMsg(false);
        var title=formObj.headTitle.value;
        switch(sAction) {
			case IBSEARCH:     // in case of double clicking on sheet
                if(!validateForm(sheetObj,formObj,sAction)) {
                    return false;
                }
                
//                sheet2.RenderSheet(0);
//                sheet2 = sheet2.Reset();
//                ComConfigSheet (sheet2);
//                initSheet(sheet2, 1, title);
//                ComConfigSheet (sheet2);
//                sheet2.RenderSheet(1);
//                sheetObjects[1] = sheet2;
                formObj.f_cmd.value=SEARCHLIST01;
                sheetObjects[1].DoSearch("EES_EQR_0063GS1.do", param +"&"+ eqrFormQryStr(formObj) );
           		break;
        }
    }
    
    
    function sheet1_OnSearchEnd(sheetObj, ErrMsg)
    {
        var feedBack=document.form.feedback.value;
        var rowCnt  = sheetObj.RowCount();
        var hiddCnt="";
        if(document.form.feedback.checked == true) {
      		 for(var i=2; i<=rowCnt+1; i++) {
      			 if(sheetObj.GetCellValue(i, 'totVol')=='0') {
      		       sheetObj.SetRowHidden(i,1);
      //no support[check again]CLT 		       sheetObj.RowSumable(i)=false;
      		       hiddCnt++;
      		     }
      		 }
        }
        if( document.all.weeklyMonthly[0].checked == true){
            sheetObjects[0].SetCellValue(0,'pln_yrwk','Week');
            sheetObjects[0].SetCellValue(1,'pln_yrwk','Week');
            sheetObjects[1].SetCellValue(0,'pln_yrwk','Week');
            sheetObjects[1].SetCellValue(1,'pln_yrwk','Week');
        }
        if( document.all.weeklyMonthly[1].checked == true){
            sheetObjects[0].SetCellValue(0,'pln_yrwk','Month');
            sheetObjects[0].SetCellValue(1,'pln_yrwk','Month');
            sheetObjects[1].SetCellValue(0,'pln_yrwk','Month');
            sheetObjects[1].SetCellValue(1,'pln_yrwk','Month');
        }
    }
    
    
    function sheet2_OnSearchEnd(sheetObj, ErrMsg)
    {
       var rowCnt=sheetObjects[1].RowCount();
       if(sheetObjects[0].GetCellValue(2,'weeklyMonthlyFlag') == '1') {
            sheetObjects[1].SetCellValue(0,'pln_yrwk','Week');
            sheetObjects[1].SetCellValue(1,'pln_yrwk','Week');
        }
       if(sheetObjects[0].GetCellValue(2,'weeklyMonthlyFlag') == '2') {
            sheetObjects[1].SetCellValue(0,'pln_yrwk','Month');
            sheetObjects[1].SetCellValue(1,'pln_yrwk','Month');
        }
       if(sheetObjects[0].GetCellValue(2,'ratioVolFlag') == "R") {
	       for(var i=2;i<=rowCnt+1;i++) {
	    	   if(sheetObjects[1].GetCellValue(i, 'div') == 'Adherence') {
	             sheetObjects[1].SetCellValue(i, 'totalVol',document.form.adherenceNum.value,0);
	          }
	    	   if(sheetObjects[1].GetCellValue(i, 'div') == 'W/O Ratio') {
	          	 sheetObjects[1].SetCellValue(i, 'totalVol',document.form.woissuedNum.value,0);
	          }
	    	   if(sheetObjects[1].GetCellValue(i, 'div') == 'Perf. Ratio') {
	          	 sheetObjects[1].SetCellValue(i, 'totalVol',document.form.perfRatioNum.value,0);
	          }
	       }
	   }
	   var titleTpSz=document.form.headTitle.value.split(',');
	   if(sheetObjects[0].GetCellValue(2,'frequencyCd') != "F") {
		   for(var i=2;i<=rowCnt+1;i++) {
			   if(sheetObjects[1].GetCellValue(i, 'div').substring(0,8) == "Feedback") {
				   sheetObjects[1].SetCellValue(i, "totalVol",sheetObjects[1].GetCellValue(2, "totalVol") - sheetObjects[1].GetCellValue(i, "totalVol"),0);
				   sheetObjects[1].SetCellValue(i, "totalCost",sheetObjects[1].GetCellValue(2, "totalCost") - sheetObjects[1].GetCellValue(i, "totalCost"),0);
		   	 	for(var j=0;j<titleTpSz.length;j++) {
		   	 		sheetObjects[1].SetCellValue(i, titleTpSz[j]+"_vol",sheetObjects[1].GetCellValue(2, titleTpSz[j]+"_vol") - sheetObjects[1].GetCellValue(i, titleTpSz[j]+"_vol"),0);
		   	 		sheetObjects[1].SetCellValue(i, titleTpSz[j]+"_cost",sheetObjects[1].GetCellValue(2, titleTpSz[j]+"_cost") - sheetObjects[1].GetCellValue(i, titleTpSz[j]+"_cost"),0);
		   	 	}
		   	 }
		   }
	   }
    }
    
    
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
 		var formObj=document.form;
        with(formObj){
            if(!checkLocItem(formObj, 'fmType', 'fmEccCd')) {
                  return false;
            }
            if(!checkLocItem(formObj, 'toType', 'toEccCd')) {
                  return false;
            }
            var flag=formObj.item.options[document.form.item.selectedIndex].value;
            document.all.adherence[0].checked == true
            if(document.all.adherence[1].checked == true) {
	            if(!chkPeriodField2(formObj, 'fmPlnSYr', 'fmPlnSWk', 'fmPlnEYr', 'fmPlnEWk')){
	             	return false;
	            }
	        } else {
	        	if(flag == "O" || flag =="F") {
		            if(!chkPeriodField2(formObj, 'fmPlnSYr', 'fmPlnSWk', 'fmPlnEYr', 'fmPlnEWk')){
		             	return false;
		            }
	        	} else {
		            if(!chkPeriodField2(formObj, 'fmPlnSYr', 'fmPlnSWk', 'fmPlnEYr', 'fmPlnEWk')){
		             	return false;
		            }
		            if(!chkPeriodField2(formObj, 'toPlnSYr', 'toPlnSWk', 'toPlnEYr', 'toPlnEWk')){
		            	return false;
		            }
	        	}
	        }
            if(!checkTpszCombo(0)) { //0 meaning comboObject Index 
                return false;
            }
        }
        return true;
    }
    
    
   function tpszChange(key){
		comboObjects[0].SetSelectCode(-1);
        switch (key)
        {
            case "":
                comboObjects[0].SetSelectCode(consTpsz);
            	break;
            case "D":
                comboObjects[0].SetSelectCode(consTpszDry);
            	break;
            case "S":
                comboObjects[0].SetSelectCode(consTpszSpc);
            	break;
            case "R":
                comboObjects[0].SetSelectCode(consTpszZrb);
            	break;
           /* case "R":
                comboObjects[0].SetSelectCode(consTpszRfr);
            	break;
            case "O":
                comboObjects[0].SetSelectCode(consTpszOt);
            	break;
            case "F":
                comboObjects[0].SetSelectCode(consTpszFr);
            	break;*/
        }
   }
   
   
   function displayType(){
		with(document.form)
		{
			   if(fmType.value == '') {
			       fmEccCd.disabled=true;
			       fmEccCd.value='';
			   } else {
			       fmEccCd.disabled=false;
			   }
			   if(toType.value == '') {
			       toEccCd.disabled=true;
			       toEccCd.value='';
			   } else {
			       toEccCd.disabled=false;
			   }
		}
	}
   
   
   function sheet1_OnDblClick(sheetObj , row, col) {
	   var rowCnt=sheetObj.RowCount();
	   // in case of Sub TTL or TOTAL Row double clicked, doing nothing
	   if (sheetObj.GetCellValue(row, 'pln_yrwk') != 'Sub TTL' && sheetObj.GetCellValue(row, 'pln_yrwk') != 'TOTAL') {
		   // in case of double clicked on sheet1, throwing total ratio to sheet2
		   if(sheetObj.GetCellValue(row, 'ratioVolFlag') == "R") {	  // in case of ratio
			   document.form.adherenceNum.value=sheetObj.GetCellValue(row, 'adherence');
			   document.form.woissuedNum.value=sheetObj.GetCellValue(row, 'woissued');
			   document.form.perfRatioNum.value=sheetObj.GetCellValue(row, 'perfratio');
		   }
		   sheetObj.SetRowStatus(row,'U');
		   var parm=sheetObj.GetSaveString(false);
           
		   doActionIBSheet2(sheetObjects[1],document.form,IBSEARCH,parm);
		   sheetObj.SetRowStatus(row,'');
	   }
   }
   
   
    // setting title1
    function TitleMake1(TitleCount){
      var strCheckList='';
      num=TitleCount.split(',');
      for(var i=0; i < num.length ; i++)  {
          // for(var j=0; j<2; j++) {
             strCheckList=strCheckList + num[i] + "|";
          // }
       }
      return strCheckList;
    }
	// setting title2
	function TitleMake2(TitleCount){
	  var strCheckList="";
	  num=TitleCount.split(',');
      for(var i=0; i < num.length ; i++)  {
          strCheckList=strCheckList + "Vol.|";
      }
	  return strCheckList;
	}
	function displayORG(no){
	    var item=document.form.item.options[document.form.item.selectedIndex].value;
		with(document.form) {
	  		switch(no) {
	  			case 0:	// ORG / DST
				if(item == "O" || item == "F") {
	  				toType.disabled=true;
	  				toEccCd.disabled=true;
	  				toTypeBy.disabled=true;
	  				toPlnSYr.disabled=true;
	  				toPlnSWk.disabled=true;
	  				toPlnEYr.disabled=true;
	  				toPlnEWk.disabled=true;
	  				ComBtnDisable("toloc_btn");
	  			    toType.value="";
	  				toEccCd.value="";
	  				toTypeBy.value="E";
	  				toPlnSYr.value="";
	  				toPlnSWk.value="";
	  				toPlnEYr.value="";
	  				toPlnEWk.value="";
				} else {
	  			  	toType.disabled=false;
	  				toEccCd.disabled=false;
	  				toTypeBy.disabled=false;
	  				toPlnSYr.disabled=false;
	  				toPlnSWk.disabled=false;
	  				toPlnEYr.disabled=false;
	  				toPlnEWk.disabled=false;
	  				ComBtnEnable("toloc_btn");
				}
	  			break;
	  			case 1: // ORG Only
	  				toType.disabled=true;
	  				toEccCd.disabled=true;
	  				toTypeBy.disabled=true;
	  				toPlnSYr.disabled=true;
	  				toPlnSWk.disabled=true;
	  				toPlnEYr.disabled=true;
	  				toPlnEWk.disabled=true;
	  				ComBtnDisable("toloc_btn");
	  			    toType.value="";
	  				toEccCd.value="";
	  				toTypeBy.value="E";
	  				toPlnSYr.value="";
	  				toPlnSWk.value="";
	  				toPlnEYr.value="";
	  				toPlnEWk.value="";
	  			break;
	  		}
  		}
	}
	function disPlayItem(val){
		with(document.form) {
			if(document.all.adherence[1].checked == true) {
				  	toType.disabled=true;
	  				toEccCd.disabled=true;
	  				toTypeBy.disabled=true;
	  				toPlnSYr.disabled=true;
	  				toPlnSWk.disabled=true;
	  				toPlnEYr.disabled=true;
	  				toPlnEWk.disabled=true;
	  				ComBtnDisable("toloc_btn");
	  			    toType.value="";
	  				toEccCd.value="";
	  				toTypeBy.value="E";
	  				toPlnSYr.value="";
	  				toPlnSWk.value="";
	  				toPlnEYr.value="";
	  				toPlnEWk.value="";
			} else {
				if(val == "O" || val == "F") {
	  				toType.disabled=true;
	  				toEccCd.disabled=true;
	  				toTypeBy.disabled=true;
	  				toPlnSYr.disabled=true;
	  				toPlnSWk.disabled=true;
	  				toPlnEYr.disabled=true;
	  				toPlnEWk.disabled=true;
	  				ComBtnDisable("toloc_btn");
	  			  toType.value="";
	  				toEccCd.value="";
	  				toTypeBy.value="E";
	  				toPlnSYr.value="";
	  				toPlnSWk.value="";
	  				toPlnEYr.value="";
	  				toPlnEWk.value="";
				} else {
	  			  	toType.disabled=false;
	  				toEccCd.disabled=false;
	  				toTypeBy.disabled=false;
	  				toPlnSYr.disabled=false;
	  				toPlnSWk.disabled=false;
	  				toPlnEYr.disabled=false;
	  				toPlnEWk.disabled=false;
	  				ComBtnEnable("toloc_btn");
				}
			}
		}
	}