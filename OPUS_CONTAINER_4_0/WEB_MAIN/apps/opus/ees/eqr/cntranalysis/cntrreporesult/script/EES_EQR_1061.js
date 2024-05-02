/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1061.js
*@FileTitle  : Empty Repo Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
    /**
     * @extends 
     * @class EES_EQR_1061
     */
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0 ;
    document.onclick=processButtonClick;
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
        	    case "btn_retrieve":
    	            doActionIBSheet(sheetObject,formObject,IBSEARCH);
        	        break;
        	    case "btn_new":
    	            sheetObject.RemoveAll();
    	            formObject.reset();
    	            comboObjects[0].SetSelectCode("ALL");
    	            document.form.transmode.value="ALL";
    	            comboObjects[1].SetSelectCode(consTpsz);
        	        break;
                case "btn_downexcel":
			        doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
			        break;        	        
      			case "fmloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:fmloc|loc_dpth_cd:fmType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 470, 470, targetObjList, display);
        		     break;
        		case "toloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:toloc|loc_dpth_cd:toType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 470, 470, targetObjList, display);
        		     break;
        		case "atloc_btn":
                     var display="0,1,1,1,1,1";
                     var targetObjList="loc_cd:atEccCd|loc_dpth_cd:atType";
                     var param="?depth=3&classId=COM_ENS_0O1";
                     ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 470, 470, targetObjList, display);
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
     * IBSheet Object
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * IBCombo Object
     */
    function setComboObject(combo_obj){
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Sheet 
     */
    function loadPage() {
        var tpsz=null;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1,tpsz);
            ComEndConfigSheet(sheetObjects[i]);
        }
        for(p=0;p< comboObjects.length;p++){
            initCombo (comboObjects[p],p+1);
        }
        document.form.tpszall.value=consTpsz;
        document.form.fmdate.maxLength="8";
        comboObjects[1].SetSelectCode(consTpsz);
    }
   /**
     * param : sheetObj
     */
    function initSheet(sheetObj,sheetNo,tpsz) {
        var cnt=0;
        var TotalCount='';
        var TitleCount;
        var TitleKey=consTpsz;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
            with(sheetObj){
                if ((tpsz =='' || tpsz == null)){
	              title=tpszallText+'|';
	              num=TitleKey.split(',');
	              TotalCount=num.length + 9;
              }else {
	              TitleCount=""+ tpsz +"";
	              title=TitleMake(TitleCount);
	              num=TitleCount.split(',');
	              TotalCount=num.length + 9;
              }
              (TotalCount, 0, 0, true);
              var TotSum="";
              var HeadVol="";
              if ((tpsz !='' || tpsz != null)){
	              for(var i=0; i<num.length ; i++) {
		              TotSum += "|"+num[i]+"cntr_qty|+"
		              HeadVol += "|Vol"
	              }
              }
              TotSum=TotSum.substring(0,TotSum.length-1);
              var HeadTitle1="Del.|STS|Seq.|FM LOC|TO LOC|Period|Mode|Vol" + HeadVol ;
              var HeadTitle="Del.|STS|Seq.|FM LOC|TO LOC|Period|Mode|TTL|" + title ;

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del" },
                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"fm_loc",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"to_loc",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:7 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"period",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 },
                     {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"transmode",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                     {Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",                         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
                    if ((tpsz =='' || tpsz == null)){
                    	for(var i=0; i<num.length ; i++) {
                    		cols.push({Type:"Int",       Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:num[i].toLowerCase()+"cntr_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
                    	}
	              } else {
		              for(var i=0; i<num.length ; i++) {
		            	  cols.push({Type:"Int",       Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:num[i].toLowerCase()+"cntr_qty", KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:2,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 });
		              }
		              cols.push({Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"hidden" });
	                }
                    InitColumns(cols);
                    SetEditable(1);
                    SetSheetHeight(400);
              }
            document.form.tpcnt.value=num.length;
            break;
        }
    }
	function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	  subSum(sheetObj);
	  if(document.form.weekMonth[1].checked == true){
	    sheetObj.SetCellValue(0,"week","Month");
	  }else{
	    sheetObj.SetCellValue(0,"week","Week");
	  }
	  //data1 && data2 
	   if(document.form.orgDst[0].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',0);
	     sheetObj.SetColHidden('to_ecc_cd',1);
	   }
	   if(document.form.orgDst[1].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',1);
	     sheetObj.SetColHidden('to_ecc_cd',0);
	   }
	   if(document.form.orgDst[2].checked == true){
	     sheetObj.SetColHidden('fm_ecc_cd',0);
	     sheetObj.SetColHidden('to_ecc_cd',0);
	   }
	  //data1
	  if(document.form.dataSelect1.value != 'P' && document.form.dataSelect2.value == '' ){
	      sheetObj.SetColHidden('fm_ecc_cd',0);
	      sheetObj.SetColHidden('to_ecc_cd',1);
	  }
	}
   /**
     * Tab 
     */
    function initCombo (comboObj, comboNo) {
        var cnt=0 ;
        switch(comboNo) {
		// Item
        case 1:
           	with (comboObj) {
           		SetDropHeight(5 * 18);
					var menuname=itemText.split('|');
					var menucode=itemCode.split('|');
           		SetMultiSelect(1);
           		SetMaxSelect(menuname.length+1);
           		SetMultiSeparator(",");
           		InsertItem(cnt ++, "ALL", "ALL");
    			for(i=0; i<menuname.length; i++) {
    				if (menucode[i] == "R") {
    					InsertItem(cnt++, menuname[i], "RD");
    				}
    				if (menucode[i] == "T") {
    					InsertItem(cnt++, menuname[i], "TD");
    				}
    				if (menucode[i] == "W") {
    					InsertItem(cnt++, menuname[i], "WD");
    				}
  				}
    			comboObj.SetSelectCode("ALL");// Default
	    	}
           break;
           // Type Size
            case 2:
               with (comboObj) {
               	SetDropHeight(12 * 18);
                var menuname2=tpszallText.split('|');
                var menucode2=tpszallCode.split('|');
               	SetMultiSelect(1);
               	SetMaxSelect(menuname2.length );
               	SetMultiSeparator(",");
       	        for(i=0; i<menuname2.length; i++) {
                    InsertItem(cnt ++, menuname2[i], menucode2[i]);                      		
                } 
    	    }
               break;
         }
    }
  // Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
       sheetObj.ShowDebugMsg(false);
        var perfix=new Array(comboObjects[1].GetSelectText());
        switch(sAction) {
           case IBSEARCH:      
               if(!validateForm(sheetObj,formObj,sAction)){
   			      return false;
   			    }
                 sheetObj.RemoveAll();
   			     formObj.f_cmd.value=SEARCHLIST;
			     sheetObj.DoSearch("EES_EQR_1061GS.do", eqrFormQryStr(formObj) );
                break;
            case IBSAVE:        
              if(validateForm(sheetObj,formObj,sAction))
                formObj.f_cmd.value=MULTI;
                break;
           case IBINSERT:      
                sheetObj.DataInsert();
                break;
           case IBCOPYROW:        
              sheetObj.DataCopy();
              break;
           case IBDOWNEXCEL: 
				if(sheetObj.RowCount()<1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
				}
              break;
           case IBLOADEXCEL:        
               sheetObj.LoadExcel();
             break;
        }
    }
   /**
     * check validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        	var pd=formObj.period.value;
        	var fm=formObj.fmdate.value;
        	var to=formObj.todate.value;
        	if(pd == 'Day'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From date");//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To date");//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		if(ComGetDaysBetween(fm, to) >= 90){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}else if(pd == 'Week'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From "+pd);//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To "+pd);//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		var fromTo=52;  
        		var fmyyyy=fm.substr(0,4);
        		var fmWeek=fm.substr(4,2);
        		var toyyyy=to.substr(0,4);
        		var toWeek=to.substr(4,2);
        		var yyyyDiff=fromTo * (parseInt(toyyyy)-parseInt(fmyyyy));
        		var fmToDiff=yyyyDiff + parseInt(toWeek) - parseInt(fmWeek); 
        		if(fmToDiff > 12){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}else if(pd == 'Month'){
        		if(!isValidDate(fm,pd)){
        			ComShowCodeMessage("EQR90113", "From "+pd);//From date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        		if(!isValidDate(to,pd)){
        			ComShowCodeMessage("EQR90113", "To "+pd);//To date is wrong.
        			eval("formObj.todate").focus();
        			return false;
        		}
        		var fmMonth=fm + "01";
        		var toyyyy=to.substr(0,4);
        		var tomm=to.substr(4,2);
        		var toMonth=to + ComGetLastDay(toyyyy, tomm);
        		if(ComGetDaysBetween(fmMonth, toMonth) > 93){
        			ComShowCodeMessage("EQR70008");//To date is wrong.
        			eval("formObj.fmdate").focus();
        			return false;
        		}
        	}
        	if(fm > to){
        		ComShowCodeMessage("EQR90215") // End date must be greater than start date.
        		eval("formObj.todate").focus();
        		return false;
        	}
        	if (formObj.transmode.value == "") {
        		ComShowCodeMessage("EQR90016", "Mode");//Please select Mode.
        		return false;
        	}
        	if (formObj.fmType.value != "ALL") {
				if(!checkLocItem(formObj, 'fmType', 'fmloc')) {
					return false;
				}
        	}
        	if (formObj.toType.value != "ALL") {
				if(!checkLocItem(formObj, 'toType', 'toloc')) {
					return false;
				}
        	}
        }
        return true;
    }
    function tpszChange(key){
    	// 선택 초기화
    	comboObjects[1].SetSelectCode(-1);
        switch (key)
        {
            case "ALL":
                comboObjects[1].SetSelectCode(consTpsz);
            	break;
            case "D":
                comboObjects[1].SetSelectCode(consTpszDry);
            	break;
            case "R":
                comboObjects[1].SetSelectCode(consTpszRfr);
            	break;
            case "O":
                comboObjects[1].SetSelectCode(consTpszOt);
            	break;
            case "F":
                comboObjects[1].SetSelectCode(consTpszFr);
            	break;
        }
    }	   
    function subSum(sheetObj){
		//
		var TotalCount='';
		var num=document.form.tpcnt.value;
		var TotSum='7';
	  for(var i=0, j=8 ; i<num ; i++, j++) {
		     TotSum += "|"+j
		 }     
	  sheetObj.ShowSubSum([{StdCol:"ibflag", SumCols:TotSum, Sort:true, ShowCumulate:false, CaptionCol:-1, CaptionText:"2=TTL"}]);
    }
    function TitleMake(TitleCount){
      var strCheckList='';
          num=TitleCount.split(',');
      for(var i=0; i < num.length ; i++)  {
           strCheckList=strCheckList + num[i] + "|";
       }
      return strCheckList;
    } 
    // date 
    function isValidDate(date, period){
    	if(period == 'Day'){
    		if(date.length != 8){
    			return false;
    		}
    		if(isValidYear(date) && isValidMonth(date)){
    			if(isValidDay(date)){
    				return true;	
    			}else{
        			return false;
    			}
    		} else {
    			return false;
    		}
    	} else if(period == 'Month'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidMonth(date)){
    			return true;
    		} else {
    			return false;
    		}
    	} else if(period == 'Week'){
    		if(date.length != 6) return false
    		if(isValidYear(date) && isValidWeek(date)){
    			return true;
    		} else {
    			return false;
    		}
    	}
    }
    // year check
    function isValidYear(yyyyww) {
    	var year=yyyyww.substring(0,4);
    	if (parseInt( year ) >= 1900) {
    		return true;
    	} else {
    		return false;
    	}
    }    
    // month check
    function isValidMonth(yyyymm) {
    	var month=yyyymm.substring(4,6);
       	var intmonth=parseInt( month , 10 )
       	if( intmonth >= 1  && intmonth <= 12 ) {
       		return true;
       	} else {
       		return false;
       	}
    }
    // week check
    function isValidWeek(yyyyww) {
    	var week=yyyyww.substring(4,6);
    	if (parseInt( week , 10) >= 1 &&  parseInt(week , 10) <= 53) {
    		return true;
    	} else {
    		return false;
    	}
    }
    // date check
    function isValidDay( date ) {
    	var year=date.substring(0,4);
    	var month=date.substring(4,6);
    	var day=date.substring(6,8);
    	var monthDD=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
    	var im=parseInt(month) - 1;
    	if( ( (year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0) ) {
    		monthDD[1]=29;
    	}
    	if( parseInt( day , 10 ) <= 0 || parseInt( day , 10 ) > monthDD[im] ) {
    		return false;
    	} else {
    		return true;
    	}
    } 
    // Period Type
    function changeFmDateMaxLength(arg) {
    	var checkType=arg.value;
    	document.form.fmdate.value="";
    	document.form.todate.value="";
    	if (checkType == "Day") {
    		document.form.fmdate.maxLength="8";
    		document.form.todate.maxLength="8";
    	} else if (checkType == "Week" || checkType == "Month") {
    		document.form.fmdate.maxLength="6";
    		document.form.todate.maxLength="6";
    	}
    }
    // Mode 
    function item_OnChange(idx ,txt){
    	var selectMode="";
    	var preSelectMode=document.form.transmode.value;
    	if (preSelectMode == "ALL" && txt.search("ALL") != -1) {
    		comboObjects[0].SetSelectCode(txt.substring(4, txt.length));
    		selectMode=txt.substring(4, txt.length);
    	} else {
    		if (preSelectMode.search("ALL") == -1 && txt.search("ALL") != -1) {
    			comboObjects[0].SetSelectCode("ALL");
    			selectMode="ALL";
    		} else {
    			selectMode=txt;
    		}
    	}
    	document.form.transmode.value=selectMode;
    }
