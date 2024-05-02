/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0040.js
*@FileTitle  : OceanRoute Manual Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
    function processButtonClick(){
         var sheetObject=sheetObjects[0];
         var sheetObject1=sheetObjects[1];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
			//showErrMessage("srcName > " + srcName);
            switch(srcName) {
        	    case "btn_ok":
					doSetValue(sheetObject,formObject);
        	        //break;
        	    case "btn_close":
        	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowMessage(ComGetMsg('COM12111'));
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
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject=sheetObjects[0];
        var formObject=document.form;
    	doActionIBSheet(sheetObject,formObject,IBSEARCH);
    }
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //IBSheet1 init
                with (sheetObj) {
                var HeadTitle="Seq.|Chk|POL|POD|Lane|Type|T/Time\n(Day/Hr)|Dir|FDR_FLG|POL ETB|POD ETB";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);
                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sSeq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Radio",     Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"sChk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sPol",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                          {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sPod",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sLane",    KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sSvcTp",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sTT",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sDir",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sFdrFlg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sPolEtb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                          {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"sPodEtb",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetEditable(1);
                SetWaitImageVisible(0);
                SetRangeBackColor(1, 6, 1, 14,"#555555");
                SetHeaderRowHeight(20);
                SetSheetHeight(200);
                }
                break;
        }
    }
  // handling of Sheet process
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
           case IBSEARCH:      
				if(validateForm(sheetObj,formObj,sAction));
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				sheetObj.DoSearch("ESD_PRD_0040GS.do", PrdFQString(formObj) , {Sync:2});
				ComOpenWait(false);
				break;
        }
    }
   /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
//            if (!isNumber(iPage)) {
//
//                return false;
//            }
        }
        return true;
    }
	/******************************************************************************/
	function doSetValue(sheetObj,formObj){
		if (!opener) opener=window.dialogArguments;
	    if(!opener) opener=parent;
		var openerSheet=opener.sheet1 ;
        var tsIdx='';
        var next=0;
        var sTsPort='';
        var isLastPod='';
        tsIdx=formObj.gubun.value;
        sTsPort=formObj.sTsPort.value;
        isLastPod=formObj.isLastPod.value;
        if( tsIdx == '4' && sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPod") != openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_pod") && sTsPort !='Y' ) {
            ComShowMessage(ComGetMsg('PRD90012'));
            return;
        }  
			openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pol"+tsIdx       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPol"),0);
			openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_ts"+tsIdx+"_lane" ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sLane"),0);
			openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_ts"+tsIdx+"_type" ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sSvcTp"),0);//aaaaaaa
			openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pod"+tsIdx       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPod"),0);
		var  sttNm="";
		if(tsIdx == '1'){
			sttNm="s_n1st_tztm_hrs";
		}else if(tsIdx == '2'){
			sttNm="s_n2nd_tztm_hrs";
		}else if(tsIdx == '3'){
			sttNm="s_n3rd_tztm_hrs";
		}else if(tsIdx == '4'){
			sttNm="s_n4th_tztm_hrs";
		}
		
		var  sttNN="";
		if(tsIdx == '1'){
			sttNN="s_t_t1";
		}else if(tsIdx == '2'){
			sttNN="s_t_t2";
		}else if(tsIdx == '3'){
			sttNN="s_t_t3";
		}else if(tsIdx == '4'){
			sttNN="s_t_t4";
		}
		//openerSheet.CellValue2( openerSheet.SelectRow, "s_t_t"+tsIdx        ) = sheetObj.CellValue( sheetObj.SelectRow , "sTT");
		openerSheet.SetCellValue( openerSheet.GetSelectRow(), sttNm       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sTT"),0);
		try {
		openerSheet.SetCellValue( openerSheet.GetSelectRow(), sttNN       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sTT"),0);
		} catch(e) {
			
		}
		openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_dir"+tsIdx       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sDir"),0);
		openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_fdr_flg"+tsIdx    ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sFdrFlg"),0);
        next=ComParseInt(tsIdx)+1;                                                                                                       
        if(tsIdx == '1' ) {                                                                                                              
        	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pod"+tsIdx+"_etb"   ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPodEtb"),0);
            openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_ts_ind"   ,'D',0);
            openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_f_u"      ,'N',0);
        }else if(tsIdx == '2' || tsIdx == '3' ){                                                                                         
        	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pol"+tsIdx+"_etb"    ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPolEtb"),0);
        	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pod"+tsIdx+"_etb"    ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPodEtb"),0);
            openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_ts_ind"   ,'T',0);
        }else if(tsIdx == '4'){                                                                                                          
        	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pol"+tsIdx+"_etb"    ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPolEtb"),0);
        }      
        //In case of 1,2,3, if pod is equal destLoc, it is not put in next pod                                                                    
		if((tsIdx == '1'||tsIdx == '2'||tsIdx == '3') && sheetObj.GetCellValue(sheetObj.GetSelectRow(), "sPod")!= openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_pod")) {
		if(openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_ts"+tsIdx+"_lane" ) =="" ||  openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_ts"+tsIdx+"_type" ) =="" ) {
		if(openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_pod"+tsIdx)!= openerSheet.GetCellValue( openerSheet.GetSelectRow(),  "s_pol"+next  )) {
                    openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pol"+next       ,"",0);
                }
                return;
            }
            if(isLastPod !='Y') {
            	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pol"+next       ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPod"),0);
            }
            if(sTsPort =='Y') {
            	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_ts"+tsIdx+"_port"      ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPod"),0);
            }       
        }
        if(isLastPod =='Y') {
        	openerSheet.SetCellValue( openerSheet.GetSelectRow(), "s_pod"      ,sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPod"),0);
        }
        // calculating ST when tsIdx is 2,3,4 
        if(tsIdx == '2' || tsIdx == '3' || tsIdx == '4' ) { 
            // get podEtb where tsIdx is -1
            var sstName="";
        	if(tsIdx == '2'){ 
        		sstName="s_n1st_stay_tm_hrs";
        	} else if(tsIdx == '3'){
        		sstName="s_n2nd_stay_tm_hrs";
        	} else if(tsIdx == '4'){
        		sstName="s_n3rd_stay_tm_hrs";
        	}
        	
        	var sstTHrs="";
        	if(tsIdx == '2'){ 
        		sstTHrs="s_t_t1";
        	}else if(tsIdx == '3'){
        		sstTHrs="s_t_t2";
        	}else if(tsIdx == '4'){
        		sstTHrs="s_t_t3";
        	}
        	var podEtb=openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_pod"+(tsIdx-1)+"_etb" );
            var podEtbNum=0;
            if( podEtb != '' ){
                podEtbNum=( (podEtb == 'SUN') ? 7:
                             ( (podEtb == 'MON') ? 6:
                             ( (podEtb == 'TUE') ? 5:
                             ( (podEtb == 'WED') ? 4:
                             ( (podEtb == 'THU') ? 3:
                             ( (podEtb == 'FRI') ? 2:
                             ( (podEtb == 'SAT') ? 1:0)))))));
            } else {
                  //setting 0 when podEtb is ''(FDR)
                  openerSheet.SetCellValue( openerSheet.GetSelectRow(), sstName    ,0,0);
                  try {
                  openerSheet.SetCellValue( openerSheet.GetSelectRow(), sstTHrs    ,0,0);
            	  }catch(e){}
                  return true;                                           
            }
            // 
            var polEtb=sheetObj.GetCellValue( sheetObj.GetSelectRow(), "sPolEtb");
            var polEtbNum=0;
            if( polEtb != '' ){
                polEtbNum=( (polEtb == 'SUN') ? 7:
                             ( (polEtb == 'MON') ? 6:
                             ( (polEtb == 'TUE') ? 5:
                             ( (polEtb == 'WED') ? 4:
                             ( (polEtb == 'THU') ? 3:
                             ( (polEtb == 'FRI') ? 2:
                             ( (polEtb == 'SAT') ? 1:0)))))));
            }else {
                 openerSheet.GetCellValue( openerSheet.GetSelectRow(), sstName   ,0,0);
                 try {
                 openerSheet.GetCellValue( openerSheet.GetSelectRow(), sstTHrs   ,0,0);
                 }catch(e){}
                 return true;                                           
            }
            var calEtb=podEtbNum-polEtbNum;
            var st=( (calEtb == -1)? 7:
                      ( (calEtb == -2)? 6:
                      ( (calEtb == -3)? 5:
                      ( (calEtb == -4)? 4:
                      ( (calEtb == -5)? 3:
                      ( (calEtb == -6)? 2: 
                      ( (calEtb ==  0)? 1:
                      ( (calEtb ==  1)? 1:
                      ( (calEtb ==  2)? 3:
                      ( (calEtb ==  3)? 4:
                      ( (calEtb ==  4)? 5:
                      ( (calEtb ==  5)? 6:
                      ( (calEtb ==  6)? 7: 0))))))))))))) *24;
            openerSheet.GetCellValue( openerSheet.GetSelectRow(), sstName   ,st,0);
            try {
            openerSheet.GetCellValue( openerSheet.GetSelectRow(), sstTHrs   ,st,0);
            }catch(e){}
        }
        var sLnkCnt=getLinkCnt(openerSheet, openerSheet.GetSelectRow());
        openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_lnk_cnt"       ,sLnkCnt,0);
        if(sLnkCnt == 1 ) {
             openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_ts_ind"   ,'D',0);
        }else if(sLnkCnt > 1 ) {
             openerSheet.GetCellValue( openerSheet.GetSelectRow(), "s_ts_ind"   ,'T',0);
        } else {
            ComShowMessage(ComGetMsg('PRD90105'));
        }
	}
    function getLinkCnt(sheetObj, insertRow ) {
        var findPodIdx=0;
        //-----------------                 
        //  check whether it has all the necessary link information
        for(index=1 ; index<  5  ; index++){                     
			if(sheetObj.GetCellValue( insertRow , "s_pol"+index)!="" && sheetObj.GetCellValue( insertRow , "s_ts"+index+"_lane")!=""
			&&sheetObj.GetCellValue( insertRow , "s_ts"+index+"_type")!="" && sheetObj.GetCellValue( insertRow , "s_pod"+index)!="" ){
        	    findPodIdx++;
        	}            	            	            	
        } 
        return  findPodIdx;      
    }
