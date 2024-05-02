/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0024.js
*@FileTitle  : L/S Flag Status
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var IBSEARCH01=29;
var IBSEARCH02=30;
var tot_cntr_tpsz_cd="";
var obj_cntr_tpsz_cd="";
var tot_cnmv_sts_cd="";
var HeadTitleCnt=0;
var comboObjects=new Array();
var comboCnt=0 ;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
         var shtCnt=0;
         var sheetObject=sheetObjects[shtCnt++];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
				switch(srcName) {
				case "btn_Retrieve":
					
					document.form.cntr_tpsz_cd.value=comboObjects[0].GetSelectCode();
					document.form.cnmv_sts_cd.value=comboObjects[1].GetSelectCode();
					document.form.lstm_cd.value=comboObjects[2].GetSelectCode();
					
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_loc_cd":	//retrieving Location popup
	    	        var cnt_cd="";
	    	        var loc_cd="";
		            cnt_cd=formObject.loc_type_code.value;
		            loc_cd=formObject.loc_cd.value;
					if ( formObject.loc_type_code.value == '5' ) {	//yard
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_061.do', 800, 480, "3:loc_cd", "1,0,1,1,1,1,1", true);
					} else {
	        			var loc_code="";
	        			if ( form.loc_type_code.value == "1" ) {
	        				loc_code="lcc_cd";
	        			} else if ( form.loc_type_code.value == "2" ) {
	        				loc_code="rcc_cd";
	        			} else if ( form.loc_type_code.value == "3" ) {
	        				loc_code="ecc_cd";
	        			} else if ( form.loc_type_code.value == "4" ) {
	        				loc_code="scc_cd";
	        			}
						var param="?cnt_cd="+cnt_cd+"&loc_cd="+loc_cd;
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, loc_code+":loc_cd", "0,1,1,1,1,1", true);
		            } 
					break; 	
				case "btn_new":
					formObject.reset();
					sheet1.SetWaitImageVisible(0);
					sheet1.SetCellValue(0,"loc_cd",'Location',0);
				    comboObjects[0].SetSelectText("");
				    comboObjects[1].SetSelectText("");
				    comboObjects[2].SetSelectText("");
					sheet1.RemoveAll();
				    break;
				case "btn_DownExcel":
//	            	doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
					sheetObject.Down2Excel({ SheetDesign:1, HiddenColumn:1, Merge:1 });
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
    function loadPage( cnmv_sts_cd, cnmv_sts_nm ) {
        for(i=0;i<sheetObjects.length;i++){
             ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
	    for(p=0;p< comboObjects.length;p++){
		       initCombo (comboObjects[p],p+1);
		} 
	    initControl();
	    makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm);
	    sheet1_OnLoadFinish(sheetObjects[0]);
    }
    /**
     * creating MVMT Status 
     */    
    function makeCnmvStsInfo(cnmv_sts_cd , cnmv_sts_nm) {
        var arr_cnmv_sts_cd=cnmv_sts_cd.split("|");
        var arr_cnmv_sts_nm=cnmv_sts_nm.split("|");
        tot_cnmv_sts_cd=arr_cnmv_sts_cd;
        with (combo_cnmv_sts_cd) {
        	SetMultiSelect(1);
            SetMultiSeparator(",");
            SetDropHeight(320);
        	InsertItem(0 , 'ALL','');
        	for ( var i=1; i<=arr_cnmv_sts_cd.length; i++) {
        		InsertItem(i, arr_cnmv_sts_cd[i-1], arr_cnmv_sts_nm[i-1]);
        	}
        } 
    }    
    /**
     *	handling event after ending sheet1 Load 
     */    
    function sheet1_OnLoadFinish(sheetObj) {
    	doActionIBSheet(sheetObjects[0],document.form,IBSEARCH01); //getting TP/SZ,MVMT Status,Lease Term data
    	ComSetFocus(document.form.loc_cd);
    	document.getElementById("loc_cd").setAttribute("maxLength",5);
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
     * initializing Tab
     * setting Tab items
     */
    function initCombo (comboObj, comboNo) {
    } 
    /**
     * registering initial event
     */
    function initControl() {
    	axon_event.addListener('change', 'loc_type_code_onchange', 'loc_type_code');	//handling event when changing Location by
    	//axon_event.addListenerFormat('beforeactivate', 'obj_activate', form); 				
    	//axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', form); 			
    	axon_event.addListener('blur', 'obj_blur', 'loc_cd');
    }
	/**
     * handling TP/SZ click event
     */
    function combo_cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    /**
     * handling MVMT Status click event
     */
    function combo_cnmv_sts_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }    
    /**
     * handling Lease Term click event
     */    
    function combo_lstm_cd_OnCheckClick(comboObj, index, code) {
    	if(index==0) { 	    	
    		var bChk=comboObj.GetItemCheck(index);
    		if(bChk){
    			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
    				comboObj.SetItemCheck(i,0);
    			}
    		}
    	} else {
    		var bChk=comboObj.GetItemCheck(index);
    		if (bChk) {
    			comboObj.SetItemCheck(0,0);
    		}
    	}
    }
    /**
     * handling event when changing loc_type_code 
     */   
    function loc_type_code_onchange() {
        var formObject=document.form;
		if  ( formObject.loc_type_code.value == '5' ) {
			document.getElementById("loc_cd").setAttribute("maxLength",7);
		} else {
			document.getElementById("loc_cd").setAttribute("maxLength",5);
		}
//        formObject.loc_cd.value = "";
        ComSetFocus(document.form.loc_cd);		
    }   
	/**
	 * handling Location  blur event
	 * validating Location code
	 */	
	function obj_blur() {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02);
	}
    /**
     * handling beforeactivate event
     */    
  	function obj_activate() {
  		ComClearSeparator(event.srcElement);
  	}
    /**
  	 * handling Period to  beforedeactivate event
  	 * YYYY-MM format
  	 */	
  	function obj_deactivate() {
  		ComClearSeparator(event.srcElement);
  	}
  	/**
  	 * setting sheet initial values and header
  	 * param : sheetObj, sheetNo
  	 * adding case as numbers of counting sheets
  	 */
    function initSheet(sheetObj,sheetNo,headTitle) {
        var cnt=0;
        var shtID=sheetObj.id;
        switch(shtID) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {
            		
            		var tot_cntr_tpsz_cd = form.tot_cntr_tpsz_cd.value;
	                if (headTitle==null || headTitle =="") {
	                	headTitle="Location|MVMT|Flag Status|Total|D2|D4|D5|D7|R2|R4|R5|R7|O2|S2|O4|S4|F2|A2|F4|A4|F5|P2|P4|T2|T4";
	                }else{
	                	headTitle="Location|MVMT|Flag Status|Total|"+tot_cntr_tpsz_cd;
	                }
	                var headArrCnt = headTitle.split("|").length - 5;
	                var headViewCnt = headArrCnt;
	                
	                var headCount=ComCountHeadTitle(headTitle);
	                var aaa = headCount-7;
	                sheetObj.FrozenCols=4;	
	                SetConfig( { SearchMode:2, FrozenCol:4, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );	
	                var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:headTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var i=1;
	                var cols = [ {Type:"Text",  	Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flag_status",  KeyField:0,   CalcLogic:"",   Format:"" },
	                             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",        KeyField:0,   CalcLogic:"",   Format:"" } ];
	                for(i;i <= headViewCnt ; i++){
	                	cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"qty"+(i),      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                }
	                cols.lenght=0;
//	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flag_status",  KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",        KeyField:0,   CalcLogic:"",   Format:"" });
	                for(; i <= headViewCnt; i++){
	                	cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"qty"+(i),      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                }
//	                cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",       KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cnmv_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"flag_status",  KeyField:0,   CalcLogic:"",   Format:"" });
//	                cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",        KeyField:0,   CalcLogic:"",   Format:"" });
	                for(; i <= headViewCnt; i++){
	                	cols.push({Type:"Text",      Hidden:0,  Width:55,   Align:"Right",   ColMerge:0,   SaveName:"qty"+(i),      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	                }
	                cols.push({Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"lvl",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	              
	                InitColumns(cols);
	                //SetSheetHeight(430);
	                resizeSheet();
	                SetEditable(0);
                }
                break;
        }
    }
    // Sheet의 높이 자동으로 변경
    function resizeSheet(){
        ComResizeSheet(sheetObjects[0]);
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
//        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
        	case IBSEARCH:    
         		if(!validateForm(sheetObj,formObj,sAction)) return;
         		sheetObj.SetWaitImageVisible(0);
         		ComOpenWait(true); 
         		/*var tot_cntr_tpsz_cd = form.tot_cntr_tpsz_cd.value;
         		var HeadTitle="Location|MVMT|Flag Status|Total|"+tot_cntr_tpsz_cd;
         		initSheet(sheet1,1,HeadTitle);*/
	            formObj.f_cmd.value=SEARCH;
	           // sheet1.RenderSheet(0);
	            sheet1.RemoveAll();
 		        sheetObj.DoSearch("EES_CIM_0024GS.do",FormQueryString(formObj) );
 		       //sheet1.RenderSheet(1);
         		
         		break;
        	case IBSEARCH01:      
//         		sheetObj.SetWaitImageVisible(0);
    			form.f_cmd.value=SEARCH01;
     			var sXml=sheetObj.GetSearchData("EES_CIM_0024GS.do" , FormQueryString(form));
    			var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");	   //retrieving TP/SZ 
    			formObj.tot_cntr_tpsz_cd.value=cntr_tpsz_cd;
    			tot_cntr_tpsz_cd=cntr_tpsz_cd;
    			var strCntrTpszCd=cntr_tpsz_cd.split("|");
    			HeadTitleCnt=strCntrTpszCd.length+4;
    			//initializing multi Combo
    			with (combo_cntr_tpsz_cd) {
    				SetMultiSelect(1);
    				SetMultiSeparator(",");
    				SetDropHeight(330);
    				InsertItem(0 , 'ALL','');
    				for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
    					InsertItem(i, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
    				}
    			} 
    			//setting header title
				for ( var i=0; i<cntr_tpsz_cd.split("|").length; i++) {
					sheetObj.SetCellValue(0,i+4,strCntrTpszCd[i],0);
				}
				var location="";
				if ( document.form.loc_type_code.value == '1' ) {
					location='ECC';
				} else if  ( document.form.loc_type_code.value == '2' ) {
					location='LCC';
				} else if  ( document.form.loc_type_code.value == '3' ) {
					location='SCC';
				} else if  ( document.form.loc_type_code.value == '4' ) {
					location='Yard';
				} else if  ( document.form.loc_type_code.value == '5' ) {
					location='Yard';
				}
	            var HeadTitle="Location|MVMT|Flag Status|Total|"+tot_cntr_tpsz_cd;
//	            sheet1.RenderSheet(0);
	            sheet1.RemoveAll();
//	            sheet1.Reset();
	            initSheet(sheet1,1,HeadTitle);
//	            sheet1.RenderSheet(1);
                //Lease Term
                var sLeaseTermNm=ComGetEtcData(sXml,"lease_term_nm");
                var sLeaseTermCd=ComGetEtcData(sXml,"lease_term_cd");
                var arrLeaseTermNm=sLeaseTermNm.split("|");
                var arrLeaseTermCd=sLeaseTermCd.split("|");
                tot_lstm_cd=arrLeaseTermCd;
                with (combo_lstm_cd) {
                	SetMultiSelect(1);
   	             	SetMultiSeparator(",");
   	             	SetDropHeight(320);
   	             	InsertItem(0 , 'ALL','');
   	             	for ( var i=1; i<=arrLeaseTermCd.length; i++) {
   	             		InsertItem(i, arrLeaseTermCd[i-1], arrLeaseTermNm[i-1]);
   	             	}
   	         	}   
    			break; 
        	case IBSEARCH02:      //validating location cd
				var inquiryLevel="";
				if ( formObj.loc_type_code.value == '1') {
					inquiryLevel="L";
				} else if  ( formObj.loc_type_code.value == '2' ) {
					inquiryLevel="R";
				} else if  ( formObj.loc_type_code.value == '3' ) {
					inquiryLevel="E";
				} else if  ( formObj.loc_type_code.value == '4' ) {
					inquiryLevel="S";
				} else if  ( formObj.loc_type_code.value == '5' ) {
					inquiryLevel="Y";
				} 
				formObj.inquiryLevel.value=inquiryLevel;
				formObj.location.value=formObj.loc_cd.value;
				formObj.f_cmd.value=SEARCH02;
				if (formObj.loc_cd.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_0024GS.do",FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					if (document.form.loc_cd.value != "") {
						ComShowCodeMessage("CIM30013","Location code");
						document.form.loc_cd.value="";
						ComSetFocus(document.form.loc_cd);
						return false;
					} else {
						ComSetFocus(document.form.loc_cd); 
						return true;
					}
				} else {
					ComSetFocus(document.form.over_stay_days);
				}
				break;	    			
			case IBDOWNEXCEL:      // 입력
				if(sheetObj.RowCount() < 1){//no data
	      			ComShowCodeMessage("COM132501");
	      		}else{
 				sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
				break;
	      		}
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
     	    if ( doActionIBSheet(sheetObjects[0], document.form, IBSEARCH02) ) {	//Location 유효성체크
     	        return false;
     	    } else {
     	    	if (!ComChkValid(formObj)) return false;
     	    }
        }
        return true;
    }
    /**
     * handling process after retrieving screen
     */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg)
	{
		ComOpenWait(false); 
		if ( document.form.loc_type_code.value == '1' ) {
			sheetObj.SetCellValue(0,"loc_cd",'ECC',0);
		} else if  ( document.form.loc_type_code.value == '2' ) {
			sheetObj.SetCellValue(0,"loc_cd",'LCC',0);
		} else if  ( document.form.loc_type_code.value == '3' ) {
			sheetObj.SetCellValue(0,"loc_cd",'SCC',0);
		} else if  ( document.form.loc_type_code.value == '4' ) {
			sheetObj.SetCellValue(0,"loc_cd",'Yard',0);
		} else if  ( document.form.loc_type_code.value == '5' ) {
			sheetObj.SetCellValue(0,"loc_cd",'Yard',0);
		}
		if ( sheetObj.RowCount()!= 0 ) {
			for(var i=1; i <= sheetObj.LastRow(); i++)
			{
//				if( sheetObj.GetCellValue(i,"lvl") == '001' || sheetObj.GetCellValue(i,"lvl") == '011'){
//	    			sheetObj.SetRowBackColor(i,"#C9D5EB");
//	    		}
				if( sheetObj.GetCellValue(i,"lvl") == '001'){
	    			sheetObj.SetRowBackColor(i,"#C9D5EB");
	    		}else if(sheetObj.GetCellValue(i,"lvl") == '011'){
	    			sheetObj.SetRowBackColor(i,"#F7E1EC");
	    		}
			}
/*			
	    	for ( var i=sheetObj.LastRow()-5; i<sheetObj.LastRow()-2; i++) {
	    		for ( var j=2; j<HeadTitleCnt; j++ ) {
	    			sheetObj.SetCellValue(i+3,j,sheetObj.GetCellValue(i, j),0);
	    	    	sheetObj.SetCellAlign(i+3,"cnmv_sts_cd","Center");
	    		}
	    	}
*/	    	
/*	    	
	    	sheetObj.RowDelete(sheetObj.LastRow()-5, false);
	    	sheetObj.RowDelete(sheetObj.LastRow()-4, false);
	    	sheetObj.RowDelete(sheetObj.LastRow()-3, false);
*/	    	
	    	sheetObj.SetCellValue(sheetObj.LastRow()-2,0,'G.Total',0);
	    	sheetObj.SetCellAlign(sheetObj.LastRow()-2,"flag_status","Center");
	    	sheetObj.SetCellAlign(sheetObj.LastRow()-1,"flag_status","Center");
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),"flag_status","Center");
	    	sheetObj.SetCellAlign(sheetObj.LastRow()-2,"loc_cd","CenterTop");
	    	sheetObj.SetCellAlign(sheetObj.LastRow()-1,"loc_cd","CenterTop");
	    	sheetObj.SetCellAlign(sheetObj.LastRow(),"loc_cd","CenterTop");
	    	sheetObj.SetMergeCell(sheetObj.LastRow()-2, 0, 3, 2);	    		    	
		}   	 	
		sheetObj.RenderSheet(1);
	}
	/**
     * event when clicking cell
     * setting background color for selected row
     */
