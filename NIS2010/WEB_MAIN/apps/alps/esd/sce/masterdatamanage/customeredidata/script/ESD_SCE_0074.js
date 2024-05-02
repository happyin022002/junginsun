// 공통전역변수

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;

var sheetObjects = new Array();
var sheetCnt = 0;

var selRow = 0;

var isFirst1 = 0;
var isFirst2 = 0;

// 공통전역변수
var pageNo =1 ;
var rowCnt = 0;

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */        
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        var formObject = document.form;
    	var sheetObject0 = sheetObjects[0];
    	var srcName = window.event.srcElement.getAttribute("name");
    	
    	switch(srcName) {
    	    case "btng_send":
    	       if(sheetObject0.CheckedRows("flag")>0){
    	           var chkrow = 0;
    	           if(sheetObject0.CheckedRows("flag") < 100){
        	           for(var i = 0 ; i < sheetObject0.CheckedRows("flag"); i++){
                    	   chkrow = sheetObject0.FindCheckedRow("flag").split('|')[i];
                    	   if(sheetObject0.CellValue(chkrow, "act_dt1") == '' || sheetObject0.CellValue(chkrow, "act_dt2") == ''){
                 	    		alert("Please, Insert Event DT");
            	    			return;
            	    		}else if(sheetObject0.CellValue(chkrow, "nod_cd") == ''){    
                 	    		alert("Please, Insert LOC");
            	    			return;
            	    		}            
        	           }
    	               doActionIBSheet(sheetObject0,formObject,IBINSERT);
    	           } else {
//    	               showErrMessage("Over 100 rows. Please define the rows you select");
                       var retVal = window.showModalDialog("ESD_SCE_0091.do", "RowLimited", "scroll:no;status:no;resizable:no;help:no;dialogWidth:550px;dialogHeight:160px");
                       
                       if(typeof retVal != "undefined"){
                           var arr_val = retVal.split(",");
    
                           var temp_row = arr_val[0];
                           var temp_row1 = arr_val[1];
                           
                           sheetObject0.CheckAll("flag") = 0 ;
                           for(temp_row;temp_row <= temp_row1;temp_row++ ){
                               sheetObject0.CellValue(temp_row, "flag") = 'Y'; 
                           } 
                           for(var i = 0 ; i < sheetObject0.CheckedRows("flag"); i++){
                	    		chkrow = sheetObject0.FindCheckedRow("flag").split('|')[i];
                	    		if(sheetObject0.CellValue(chkrow, "act_dt1") == '' || sheetObject0.CellValue(chkrow, "act_dt2")  == ''){
                     	    		alert("Please, Insert Event DT");
                	    			return;
                	    		}else if(sheetObject0.CellValue(chkrow, "nod_cd") == ''){    
                     	    		alert("Please, Insert LOC");
                	    			return;
                	    		}
                            }
                            doActionIBSheet(sheetObject0,formObject,IBINSERT);
                       }
    	           }
    	       }else{
                    alert("Please, Check CheckBox");
                }
    	       break;
    	       
    	    case 'btn_saveas':
    	       doActionIBSheet(sheetObject0,formObject,IBDOWNEXCEL);
    	       break;   
    	    case 'btn_close':
    	      if(formObject.sendClose.value == "reload"){
    	          window.returnValue = true;  
    	      } else {
    	          window.returnValue = false;  
    	      }
     	      self.close();
     	      break;
    	}
    }
    
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++] = sheet_obj;
    }
    
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        var sheetObject = sheetObjects[0];
        var formObject = document.form;
        var diffOnMiss = formObject.diff.value;

        if((diffOnMiss == "1") || (diffOnMiss == "2")){
           doActionIBSheet(sheetObject,formObject,IBSEARCH);            
        } else {
           doActionIBSheet(sheetObject,formObject,COMMAND01);         
        }
    }
    
    function initSheet(sheetObj,sheetNo) {
        var cnt = 0;

        switch(sheetNo) {
            case 1:     
                with (sheetObj) {
                    // 높이 설정
                    style.height = GetSheetHeight(16) ;
                    //전체 너비 설정
                    SheetWidth = mainTable.clientWidth; 
                    
                    //Host정보 설정[필수][HostIp, Port, PagePath]
                    if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

                    //전체Merge 종류 [선택, Default msNone]
                    MergeSheet = msHeaderOnly;

                   //전체Edit 허용 여부 [선택, Default false]
                    Editable = true;

                    //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
                    InitRowInfo( 1, 1, 5, 300);

                    //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
                    InitColumnInfo(21, 5, 0, true);

                    // 해더에서 처리할 수 있는 각종 기능을 설정한다
                    InitHeadMode(true, true, true, true, false,false);
                    
                    var HeaderTitle = "VVD|BKG NO.|BL NO.|CNTR NO.|POR|POL|POD|DEL||EDI STS|CUST\nSTS|SEQ|Event DT|Event DT|LOC|EDI PROCESS DT(KST)|EDI PROCESS DT(KST)|EDI PROCESS DT(LCL)|EDI PROCESS DT(LCL)|cop_no|";
                    
                    InitHeadRow(0, HeaderTitle, true);
                    
                    //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
                    /*
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "vvd_nos",         false,          "",      dfNone,      0,     false,       false,          30);
/                   
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "bkg_nos",         false,          "",      dfNone,      0,     false,       false,          30);
                    //InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  true,    "bkg_no_splits",   false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "bl_no",           false,          "",      dfNone,      0,     false,       false,          30);    
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "cntr_nos",        false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "por_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "pol_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "pod_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "del_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtCheckBox,     60,    daCenter,  false,    "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "act_stnd_st",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "cust_st",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "seq",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "actual_dt1",      false,          "",      dfDateYmd,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "actual_dt2",      false,          "",      dfTimeHms,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "nod_cds",      false,          "",      dfEngUpKey,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "edi_prc_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "edi_prc_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "edi_lcl_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "edi_lcl_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
 					InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    "cop_no",      false,          "",      dfNone,   0,     true,       false,          30);
					InitDataProperty(0, cnt++ , dtHiddenStatus,   25,    daCenter,  false,    "ibflg",     	  false,          "",       dfNone,   		0,     false,      false, 30);
*/
					
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "s_vvd",         false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "s_bkg_no",         false,          "",      dfNone,      0,     false,       false,          30);
                    //InitDataProperty(0, cnt++ , dtData,         20,    daCenter,  true,    "bkg_no_splits",   false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "s_bl_no",           false,          "",      dfNone,      0,     false,       false,          30);    
                    InitDataProperty(0, cnt++ , dtData,         90,    daCenter,  true,    "s_cntr_no",        false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "por_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "pol_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "pod_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         60,    daCenter,  true,    "del_cd",            false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtCheckBox,     60,    daCenter,  false,    "flag",          false,          "",      dfNone,      0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "edi_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "edi_sub_sts_cd",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "edi_snd_knt",    false,          "",      dfNone,      0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "act_dt1",      false,          "",      dfDateYmd,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "act_dt2",      false,          "",      dfTimeHms,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "nod_cd",      false,          "",      dfEngUpKey,   0,     true,       true,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "cre_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "cre_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         80,    daCenter,  true,    "gmt_dt1",      false,          "",      dfDateYmd,   0,     false,       false,          30);
                    InitDataProperty(0, cnt++ , dtData,         70,    daCenter,  true,    "gmt_dt2",      false,          "",      dfTimeHms,   0,     false,       false,          30);
 					InitDataProperty(0, cnt++ , dtHidden,         70,    daCenter,  true,    "cop_no",      false,          "",      dfNone,   0,     true,       false,          30);
					InitDataProperty(0, cnt++ , dtHiddenStatus,   25,    daCenter,  false,    "ibflag",     	  false,          "",       dfNone,   		0,     false,      false, 30);
				
                }
            break;
        }
    }
    
    function doActionIBSheet(sheetObj,formObj,sAction,a,PageNo) {
        sheetObj.ShowDebugMsg = false;

        switch(sAction) {
            case IBSEARCH:      //조회   
               formObj.f_cmd.value = SEARCH01;                
               sheetObj.DoSearch4Post("ESD_SCE_0074GS.do", SceFrmQryString(formObj)); 
               break;
               
            case IBINSERT:
               formObj.f_cmd.value = MULTI01; 
            
               //sheetObj.DoSave("ESD_SCE_0074GS.do", SceFrmQryString(formObj),"flag"); 
				sheetObj.DoSave("ESD_SCE_0074GS.do", SceFrmQryString(formObj));
               formObj.sendClose.value = "reload";
               break;
               
            case COMMAND01:
               formObj.f_cmd.value = SEARCH02;                
               sheetObj.DoSearch4Post("ESD_SCE_0074GS.do", SceFrmQryString(formObj));  
               break;               

            case IBDOWNEXCEL:
                sheetObj.Down2Excel(-1, false, false, true);
                break;
                
            case IBSEARCHAPPEND:
               var MissATotal = formObj.diff.value;
               formObj.i_page.value = PageNo;
               if((MissATotal == "1") || (MissATotal == "2")){
                   formObj.f_cmd.value = SEARCH01;                
                   sheetObj.DoSearch4Post("ESD_SCE_0074GS.do", SceFrmQryString(formObj), "iPage=" + PageNo, true); 
               } else {
                   formObj.f_cmd.value = SEARCH02;                
                   sheetObj.DoSearch4Post("ESD_SCE_0074GS.do", SceFrmQryString(formObj), "iPage=" + PageNo, true);  
               }
               break;
        }
    }

    function t1sheet_OnScrollNext(sheet,CondParam, PageNo, OnePageRows) {
         doActionIBSheet(sheetObjects[0], document.form, IBSEARCHAPPEND, true, PageNo);
    }