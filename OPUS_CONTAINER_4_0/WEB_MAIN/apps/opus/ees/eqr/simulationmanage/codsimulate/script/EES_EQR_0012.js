/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0012.js
*@FileTitle  : Change POD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author
     */
    /**
     * @extends
     * @class EES_EQR_0012 : business script for EES_EQR_0012 
     */
    var DoSearch_Sheet1=false;
//    var tabName=new Array();
//    tabName[0]=" COD Simulation ";
//    tabName[1]="Analysis by POL";
//    tabName[2]="Analysis by POD";
    var tabObjects=new Array();
    var tabCnt=0 ;
    var beforetab=1;
    
    var sheetObjects=new Array(); 
    var sheetCnt=0;
    
    var comboObjects=new Array();
    var comboCnt=0 ;
    var click_vvd="";
    
    var linkPageNum=null;  	// selected tab from EES_EQR_0051
    
    /* Event handler processing by button click event */
    document.onclick=processButtonClick;
    /* Event handler processing by button name */
        function processButtonClick(){
             var sheetObject=sheetObjects[0];
             //var sheetObject1=sheetObjects[1];
             //var sheetObject2=sheetObjects[2];
             /*******************************************************/
             var formObject=document.form;
             //var tabObject=tabObjects[0];
             //var curTabIndex=tabObject.GetSelectedIndex();
        	try {
        		 var srcName=ComGetEvent("name");
                 if(!ComIsBtnEnable(srcName) ) return;
                switch(srcName) {
                  case "btn_new":
                	  	var toPlnyr = document.form.toPlnYr.value;
                	  	var toPlnWk = document.form.toPlnWk.value;
                	  	                  
                        formObject.reset();
                        
                	  	//document.form.toPlnYr.value = toPlnyr;
                	  	//document.form.toPlnWk.value = toPlnWk;
                	  	document.form.yyyyww.value = "";
                	  	document.form.seq.value = "";
                        comboObjects[0].SetSelectCode(consTpsz);
                        tpszChange(''); // ALL 선택
                        sheetObject.RemoveAll();
                        //sheetObject1.RemoveAll();
                        //sheetObject2.RemoveAll();
                        ComBtnDisable("btn_create");
                        ComBtnDisable("btn_delete");
                        // t1btng_rowadd 버튼 Disable
                        ComBtnDisable("t1btng_rowadd");
                        ComBtnDisable("t1btng_rowdelete");
                        break;
//                    
            	    case "btn_retrieve":
            	        doActionIBSheet(sheetObject,formObject,IBSEARCH);
//            	         
            	        break;
            	    case "btn_create":
    		        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
            	    	break;
            	    case "btn_delete":
    		        	doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
            	    	break;
                    case "btn_save":
                       doActionIBSheet(sheetObject,formObject,IBSAVE);
                       break;
                     
                   case "btn_confirm":
        	            doActionIBSheet(sheetObject,formObject,IBSEARCH_ASYNC01);
            	        break;
            	        
                   case "btn_downexcel":
        	            doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
//                      
            	        break;
                    case "btn_print":
//                       if(curTabIndex == 0){
                            if(sheetObjects[0].RowCount('') > 0){
                                sheetObjects[0].DoPrint();
                            } else{
                           ComShowMessage(ComGetMsg("EQR90095"));
                            }
//                       }else if(curTabIndex == 1){
//                             if(sheetObjects[1].RowCount('') > 0){
//                                sheetObjects[1].DoPrint();
//                              }else{
//                               ComShowMessage(ComGetMsg("EQR90095"));
//                              }
//                       }else if(curTabIndex == 2){
//                             if(sheetObjects[2].RowCount('') > 0){
//                               sheetObjects[2].DoPrint();
//                             }else{
//                              ComShowMessage(ComGetMsg("EQR90095"));
//                              }
//                       }
                       break;
                    case "t1btng_rowadd":
                        doActionIBSheet(sheetObject,formObject,IBINSERT);
                        break;
                        
                    case "t1btng_rowdelete":
                    	ComRowHideDelete(sheetObject,"delcheck");
                        break;
                                                
                    case "t1btng_save":
                        doActionIBSheet(sheetObject,formObject,IBSAVE);
                        break;
//                    case "t2btng_rowadd":
//                        doActionIBSheet(sheetObject1,formObject,IBINSERT);
//                        break;
//                    case "t2btng_save":
//                        doActionIBSheet(sheetObject1,formObject,IBSAVE);
//                        break;
//                    case "t3btng_rowadd":
//                        doActionIBSheet(sheetObject2,formObject,IBINSERT);
//                        break;
//                    case "t3btng_save":
//                        doActionIBSheet(sheetObject2,formObject,IBSAVE);
//                        break;
                    case "fmloc_btn":
                        var display="0,1,1,1,1,1";
                        var targetObjList="loc_cd:fmEccCd|loc_dpth_cd:fmType";
          				var param="?depth=3&classId=COM_ENS_0O1";
          				       ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
//          				ComOpenPopup("/opuscntr/COM_ENS_0O1.do"+param, 400, 470, targetObjList, display, true);
      				    break;
      		        case "toloc_btn":
                        var display="0,1,1,1,1,1";
                        var targetObjList="loc_cd:toEccCd|loc_dpth_cd:toType";
          				var param="?depth=3&classId=COM_ENS_0O1";
          				      ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
 //         				ComOpenPopup("/opuscntr/COM_ENS_0O1.do"+param, 400, 470, targetObjList, display, true);
      		            break;
      		        case "btn_trade":
      		            var v_scnr_id="REPO"+ formObject.yyyyww.value + "W" + formObject.seq.value;
      		            var v_display="0,1";
                        if(v_scnr_id == "") {
                             ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
                               return false;
                        }
                        var targetObjList="trade:trade";
                        var param="?classId=COM_ENS_0P1&scnr_id="+v_scnr_id+"&depth=1&chkDepth=1";
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 410, 500, targetObjList, v_display, true);
                        //ComOpenPopup("/opuscntr/COM_ENS_0P1.do"+param, 410, 470, targetObjList, v_display, true);
                        break;
                        
                    case "btn_lane":
      		            var v_scnr_id="REPO"+ formObject.yyyyww.value + "W" + formObject.seq.value;
      		            var v_display="0,1";
                        if(v_scnr_id == "") {
                            ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
                            return false;
                        }
                        var targetObjList="lane:lane";
                        var param="?classId=COM_ENS_0P1&scnr_id="+v_scnr_id+"&depth=2&chkDepth=2";
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 410, 500, targetObjList, v_display, true);
                        //ComOpenPopup("/opuscntr/COM_ENS_0P1.do"+param, 410, 470, targetObjList, v_display, true);
                        break;
                        
                     case "btn_lane_1":
                    	 var v_scnr_id="REPO"+ formObject.yyyyww.value + "W" + formObject.seq.value;
      		             var v_display="0,1";
                         if(v_scnr_id == "") {
                         ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
                              return false;
                         }
                         var targetObjList="trade:trade|lane:lane_1";
                         var param="?classId=COM_ENS_0P1&scnr_id="+v_scnr_id+"&depth=2&chkDepth=2";
                         ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 400, 480, targetObjList, v_display, true);
                         break;
                         
                    case "btn_vvd":
                        var v_scnr_id="REPO"+ formObject.yyyyww.value + "W" + formObject.seq.value;
                        var v_display="0,1";
                        if(v_scnr_id == "") {
                        	ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
                            return false;
                        }
                        var targetObjList="vvd:vvd";
                        var param="?classId=COM_ENS_0P1&scnr_id="+v_scnr_id+"&depth=3&chkDepth=3";
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 410, 500, targetObjList, v_display, true);
                        //ComOpenPopup("/opuscntr/COM_ENS_0P1.do"+param, 410, 470, targetObjList, v_display, true);
                        break;
                        
                   case "btn_vvd_1":
                        var v_scnr_id="REPO"+ formObject.yyyyww.value + "W" + formObject.seq.value;
                        var v_display="0,1";
                        if(v_scnr_id == "") {
                         ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
                            return false;
                        }
                        var targetObjList="trade:trade|lane:lane_1|vvd:vvd_1";
                        var param="?classId=COM_ENS_0P1&scnr_id="+v_scnr_id+"&depth=3&chkDepth=3";
                        ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 400, 480, targetObjList, v_display, true);
                        break;
                        
                    case "btn_repolist":
                    	var week = formObject.yyyyww.value;
     	            	
     	            	if(week != "") {
		  		  			var toWeek = week.substr(4,2);
		  		  			var fmWeek = toWeek - 3;
		  		  			
			  		  		if(fmWeek <= 0)  {
		  		  				fmWeek = "";
		  		  			}
		  		  			
		  		  			fmWeek = "" + fmWeek;
		  		  			if(fmWeek.length == 1) {
		  		  				fmWeek = "0"+fmWeek;
		  		  			}
	  		  			
		  		  			var repo_SWeek = "repo_SWeek=" + fmWeek;
		  		  			var repo_EWeek = "repo_EWeek=" + toWeek;
	      		  		}else{
		      		  		var repo_SWeek = "repo_SWeek=";
		  		  			var repo_EWeek = "repo_EWeek=";
	      		  		}
     	            	
     	            	ComOpenWindowCenter('EES_EQR_0107.do?' + repo_SWeek + "&" +repo_EWeek, "EES_EQR_0107", 1000, 600, true);
                        break;
                } // end switch
        	}catch(e) {
        		if( e == "[object Error]") {
        			//ComShowMessage(OBJECT_ERROR);
        			ComShowMessage(ComGetMsg("EQR90004"));
        		} else {
        			//(e);
        			//ComShowMessage(e);
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
         * registering IBSheet Combo Object as list
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
        	ComOpenWait(true);
            //sheetObjects[0].SetWaitImageVisible(1);
            var formObject=document.form;
 
            
            for(i=0;i<sheetObjects.length;i++){
                ComConfigSheet (sheetObjects[i]);
                initSheet(sheetObjects[i],i+1);
                ComEndConfigSheet(sheetObjects[i]);
            }
            
            /*
        	setTimeout( function () {
	            for(i=0;i<sheetObjects.length;i++){
	                ComConfigSheet (sheetObjects[i]);
	                initSheet(sheetObjects[i],i+1);
	                ComEndConfigSheet(sheetObjects[i]);
	            }
	           
	            
        	} , 2000);
        	*/ 
            
            for(p=0;p< comboObjects.length;p++){
                initCombo (comboObjects[p],p+1);
            }
         //  formObject.tpszallTypeAll.value =  consTpszArr;
           formObject.tpszCurrent.value=consTpszArr;
           goCheckEqrAccess();
           ComBtnDisable("t1btng_rowadd");
           ComBtnDisable("t1btng_rowdelete");
           
           ComBtnDisable("btn_create");
           ComBtnDisable("btn_delete");
           
           sheet1_OnLoadFinish(sheetObjects[0]);
        }
        
        
        function sheet1_OnLoadFinish(sheetObject) {
        	formObject = document.form;
        	//doActionIBSheet(sheetObject,formObject,IBSEARCH);
        }
        
        
      /**
         * setting sheet initial values and header
         * param : sheetObj, sheetNo
         * adding case as numbers of counting sheets
         */
        function initSheet(sheetObj,sheetNo ,tpsz) {
            var cnt=0;
            var selectTpsz=""+tpsz+"";
            var menu="";
            var menu1="";
            var makeTitle="";
          // sheetObj.onlyTextTriggerForOnEdit = true;  // 영문 window에서의 문제 제거를 위해 사용됨.(중요)
            switch(sheetNo) {
                case 1:      //t1sheet1 init
                    with (sheetObj) {
                	if ((tpsz =='' || tpsz == null)){
                		for(i=0; i<consTpszArr.length; i++) {
                			for(j=0; j< 1; j++) {
                				menu=menu + consTpszArr[i]+"|";
                				menu1=menu1 + consTpszArr[i]+"|";
	                        }
                		}
                		num=tpszallText.split('|');
	                        menu=menu.substring(0,menu.length-1);
	                        menu1=menu1.substring(0,menu1.length-1);
                        }else {
	                        makeTitle=""+ selectTpsz +"";
	                        menu=TitleMake2(makeTitle);
	                        menu1=TitleMake2(makeTitle);
	                        num=makeTitle.split(',');
                        }
                    
                        TotalCount=39 + (num.length * 3) + (consTpszArr.length * 4);
                        
                        SetHeaderRowHeight(20);
//                        (TotalCount, 2, 0, true);
                        var HeadTitle0="Del.|STS|WK|Target \nVVD|Confirm|Lane|VVD|From|From|To|To|To|Total|"+menu;
                        var HeadTitle1="Del.|STS|WK|Target \nVVD|Confirm|Lane|VVD|POL|ETD|POD|ETB|TO YARD|Total|"+menu1 ;

                        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

                        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                        var headers = [ { Text:HeadTitle0, Align:"Center"},
                                        { Text:HeadTitle1, Align:"Center"} ];
                        InitHeaders(headers, info);

                        var cols = [ {Type:"CheckBox",  Hidden:0, 	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"delcheck",     KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:1,   InsertEdit:1},
					                {Type:"Status",    	Hidden:0,  	Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					                {Type:"Text",      	Hidden:0,  	Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk", KeyField:1,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
					                {Type:"CheckBox",  	Hidden:0,  	Width:62,   Align:"Center",  ColMerge:1,   SaveName:"check", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1 },
					                {Type:"Text",  		Hidden:0,  	Width:62,   Align:"Center",  ColMerge:1,   SaveName:"confirm_flg", KeyField:0,   CalcLogic:"",   Format:"", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
					                
					                {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"land_cd",                                     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
					                {Type:"PopupEdit", Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vvd",                                         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:9 },
					                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd_tmp",                               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0, EditLen:9 },
					                {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,    SaveName:"fm_etd_dt",                                   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					                {Type:"Combo",     Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd_tmp",                               KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					                {Type:"Text",      Hidden:0,  Width:90,  Align:"Center",  ColMerge:0,    SaveName:"to_etb_dt",                                   KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:0 },
					                
					                {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"to_yard",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 },
					                {Type:"AutoSum",   Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"total",                                       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
                        
                        for(var i=0 ; i < num.length ; i++){
                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:num[i].toLowerCase(),                          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:0,   EditLen:6 });
                        }
                        
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"repo_pln_id",                                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:20 });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",                                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",                                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",                                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd",                                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd",                                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd_tmp1",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"fm_etd_dt1",                                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd_tmp1",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"to_etb_dt1",                                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd_flg",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd_flg",                               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"plan_seq",                                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                                                 
                        for(var k=0 ; k < num.length ; k++){
                        	cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:num[k].toLowerCase()+"_flag",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,    });
                        }
                        for(var k1=0 ; k1 < consTpszArr.length ; k1++){
                        	cols.push({Type:"Text",      Hidden:1, Width:250,  Align:"Center",  ColMerge:0,   SaveName:"sum_cntp_code"+consTpszArr[k1].toLowerCase(), KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:0,    });
                        }
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"ldis_ts_flg",                                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        for(var k2=0 ; k2 < consTpszArr.length ; k2++){
                        	cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sum_cntp_qty"+consTpszArr[k2].toLowerCase(),  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        }
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sum_flg_code",                                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        for(var k3=0 ; k3 < consTpszArr.length ; k3++){
                        	cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"sum_cntp_flg"+consTpszArr[k3].toLowerCase(),  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        }
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"save_flg",                                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        for(var k4=0 ; k4 < consTpszArr.length ; k4++){
                        	cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"save_flg"+consTpszArr[k4].toLowerCase(),      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        }
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"search_eta_start",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"search_eta_end",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"search_etd_start",                            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"search_etd_end",                              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"fix_to_ecc",                                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        for(var i=0 ; i < num.length ; i++){
                        	cols.push({Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"fix_"+num[i].toLowerCase(),                   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        }
                        cols.push({Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"duplicate_check",                             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pln_seq",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"pln_seq1",                                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fm_yard",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"past_repo_pln_flg",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd_tmp2",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd_tmp2",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd_tmp3",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,    });
                        cols.push({Type:"Text",      Hidden:1, Width:110,  Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd_tmp3",                                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,    });
    
                        InitColumns(cols);
                        SetEditable(1);
                        resizeSheet();
                        //SetSheetHeight(400); 
/*                        sheetObj.SetColProperty("fm_etd_dt", {Format:"####-##-####:##:##"} );
                        sheetObj.SetColProperty("to_etb_dt", {Format:"####-##-####:##:##"} );*/
                        SetRangeBackColor(1, 6, 1, 12,"#555555");
                        SetColHidden("check",1);//Target VVD(check) 숨김
                        InitComboNoMatchText(1,"",1);
                        
                        SetColProperty("vvd" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
                        
                        var sumcol = "";
                        for(var i=0 ; i < num.length ; i++) {
                        	sumcol = sumcol + "|"+ num[i].toLowerCase();
                        }
                        sheetObj.ShowSubSum([{StdCol:1, SumCols:"total"+sumcol, Sort:false, ShowCumulate:false, CaptionCol:2, CaptionText:"SubTTL"}]);      
                        //ShowSubSum([{StdCol:1, SumCols:"total"+sumcol, Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"SubTTL"}]);                        
//                        SetHeaderRowHeight(20);
                        
                    }
                    break;
//               case 2:      //t2sheet1 init
//                    with (sheetObj) {
//	                   if ((tpsz =='' || tpsz == null)){
//	                       num=tpszallText.split('|');
//	                       var menu_title=new Array();
//	                       menu_title[0]="BEFORE";
//	                       menu_title[1]="AFTER";
//	                       menu_title[2]="Difference";
//	                       for(j=0; j < 3; j++){
//	                       for(k=0; k < num.length ; k++){
//		                       menu  += menu_title[j] + "|";
//		                       menu1 += num[k] + "|";
//	                       }
//		                       menu  += menu_title[j]+"|";
//		                       menu1 += "Total|";
//	                       }
//		                       menu=menu.substring(0, menu.length-1);
//		                       menu1=menu1.substring(0, menu1.length-1);
//	                       } else {
//		                       makeTitle=""+ selectTpsz +"";
//		                       menu=TitleMake1(makeTitle);
//		                       menu1=TitleMake2(makeTitle);
//		                       num=makeTitle.split(',');
//	                       }
//	                       TotalCount=12 + (num.length * 3);
//	//                       (TotalCount, 2, 0, true);
//	                       var HeadTitle0="Del.|STS|WK|Target \nVVD|Co.|Lane|VVD|Loading|Loading|"+ menu ;
//	                       var HeadTitle1="Del.|STS|WK|Target \nVVD|Co.|Lane|VVD|POL|ETD|Total|"+menu1+"|Total|"+menu1+"|Total|"+menu1 ;
//	
//	                       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
//	
//	                       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
//	                       var headers = [ { Text:HeadTitle0, Align:"Center"},
//	                                       { Text:HeadTitle1, Align:"Center"} ];
//	                       InitHeaders(headers, info);
//	
//	                       var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
//					                  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
//					                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
//					                  {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"targetvvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
//					                  {Type:"Combo",     Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"co_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
//					                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"vsl_lane_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
//					                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vvd",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
//					                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"fm_ecc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
//					                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"fm_etd_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
//					                  {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"oldplantotal",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
//                           for(var i=0 ; i < num.length ; i++){
//                            	 cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"oldplan"+num[i].toLowerCase(), KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//	                       }
//	                                         cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"newplantotal",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 });
//	                       for(var j=0 ; j < num.length ; j++){
//	                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"newplan"+num[j].toLowerCase(), KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//	                       }
//	                       cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"difftotal",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 });
//	                       for(var k=0 ; k < num.length ; k++){
//	                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"diff"+num[k].toLowerCase(),    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//	                       }	      
//	                       InitColumns(cols);
//	                       SetEditable(1);
//	                       SetSheetHeight(350); 
//	                       SetColProperty("co_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
//	                       SetRangeBackColor(1, 7, 1, TotalCount-1,"#555555");
//	                       SetHeaderRowHeight(20);
//                    }
//                    break;
//               case 3:      //t2sheet1 init
//                    with (sheetObj) {
//                   if ((tpsz =='' || tpsz == null)){
//	                       menu="BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|BEFORE|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|AFTER|Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference|Difference";
//	                       menu1="D2|D4|D5|D7|R2|R5|O2|O4|F2|F4|Total|D2|D4|D5|D7|R2|R5|O2|O4|F2|F4|Total|D2|D4|D5|D7|R2|R5|O2|O4|F2|F4";
//	                       num=tpszallText.split('|');
//                       }else {
//	                       makeTitle=""+ selectTpsz +"";
//	                       menu=TitleMake1(makeTitle);
//	                       menu1=TitleMake2(makeTitle);
//	                       num=makeTitle.split(',');
//                       }
//                       TotalCount=12 + (num.length * 3);
////                       (TotalCount, 2, 0, true);
//                       var HeadTitle0="Del.|STS|WK|Target \nVVD|Co.|Lane|VVD|Discharging|Discharging|" +menu ;
//                       var HeadTitle1="Del.|STS|WK|Target \nVVD|Co.|Lane|VVD|POD|ETD|Total|"+menu1+"|Total|"+menu1+"|Total|"+menu1;
//
//                       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
//
//                       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
//                       var headers = [ { Text:HeadTitle0, Align:"Center"},
//                                       { Text:HeadTitle1, Align:"Center"} ];
//                       InitHeaders(headers, info);
//
//                       var cols = [ {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
//				                  {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"" },
//				                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pln_yrwk",                     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:7 },
//				                  {Type:"CheckBox",  Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"targetvvd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:1 },
//				                  {Type:"Combo",     Hidden:0, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"co_cd",                        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:4 },
//				                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Left",    ColMerge:1,   SaveName:"vsl_lane_cd",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
//				                  {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vvd",                          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 },
//				                  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"to_ecc_cd",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
//				                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"to_etb_dt",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:8 },
//				                  {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"oldplantotal",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 } ];
//                       for(var i=0 ; i < num.length ; i++){
//                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"oldplan"+num[i].toLowerCase(), KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//                       }
//                       	cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"newplantotal",                 KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 });
//                       for(var j=0 ; j < num.length ; j++){
//                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"newplan"+num[j].toLowerCase(), KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//                       }
//                       	cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"difftotal",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:11 });
//                       for(var k=0 ; k < num.length ; k++){
//                    	   cols.push({Type:"AutoSum",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"diff"+num[k].toLowerCase(),    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 });
//                       }
//                       for (var i=7 ; i < TotalCount ; i ++ ) {
//                    	   SetCellBackColor(1,i,GetCellBackColor(1,7));
//                       }
//      
//                       InitColumns(cols);
//
//                       SetEditable(1);
//                       SetSheetHeight(350); 
//                       SetCellBackColor(1,7,"#555555");
//                       SetCellBackColor(1,i,GetCellBackColor(1,7));
//                       SetColProperty("co_cd", {ComboText:combo01Text, ComboCode:combo01Code} );
//                       SetHeaderRowHeight(20);
//
//                    }
//                    break;
            }
        }
    	function resizeSheet(){
    	    ComResizeSheet(sheetObjects[0]);
    	}
       /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
        function initCombo (comboObj, comboNo) {
            var cnt=0 ;
            switch(comboNo) {
                case 1:
                   with (comboObj) {
                   SetDropHeight(12 * 18);
           	      var menuname2=tpszallText.split('|');
                  var menucode2=tpszallCode.split('|');
                   SetMultiSelect(1);
                   SetMaxSelect(menuname2.length);
                   SetMultiSeparator(",");
             	      for(i=0; i<menuname2.length; i++) {
             	    	  InsertItem(cnt ++, menuname2[i], menucode2[i]);
                       }
        	    }
                   break;
             }
        }
     // Sheet관련 프로세스 처리
        function doActionIBSheet(sheetObj,formObj,sAction) {
             sheetObj.ShowDebugMsg(false);
             var tpszperfix=new Array(comboObjects[0].GetSelectText());
             var repo_id="REPO"+formObj.yyyyww.value+"W"+formObj.seq.value;
             var tabObject=tabObjects[0];
             //var curTabIndex=tabObject.GetSelectedIndex();
             switch(sAction) {
               case SEARCH01:      //조회(입력된 Repo Plan ID가 신규일 경우 사용)
                    formObj.f_cmd.value=SEARCH;
                    //sheetObj.RenderSheet(0);
                    ////sheetObj.RemoveAll();
                    //sheetObj = sheetObj.Reset();
                    //initSheet(sheetObj,1 ,tpszperfix);
                    //sheetObj.RenderSheet(1);
                    //sheetObj.SetExtendLastCol(0);
                    
                    /*sheetObj.RenderSheet(0);
                    sheetObj.RemoveAll();
                    //sheetObj.Reset();
                    sheetObj = sheetObj.Reset();
                    initSheet(sheetObj, 1, tpszperfix);
                    sheetObj.RenderSheet(1);
                    sheetObj.SetExtendLastCol(0);*/
                    
                    
                    document.form.checksave.value="N";
                    DoSearch_Sheet1=true;
                    //sheetObj.DoSearch("EES_EQR_0012GS.do?searchKey=1", eqrFormQryStr(formObj) );
                    // t1btng_rowadd 버튼 Enable
                    ComBtnEnable("t1btng_rowadd");
                    ComBtnEnable("t1btng_rowdelete");
                    ComOpenWait(false);
                    break;
                    
               case IBSEARCH:      //조회 

            	   if(!validateForm(sheetObj,formObj,sAction)){
            		   return false;
            	   }

            	   formObj.f_cmd.value=SEARCHLIST;
                    
					/*sheetObj.RenderSheet(0);
					sheetObj.RemoveAll();
					sheetObj = sheetObj.Reset();
					initSheet(sheetObj,1 ,tpszperfix);
					sheetObj.RenderSheet(1);
					sheetObj.SetExtendLastCol(0);*/
            	   
            	    sheetObj = sheetObj.Reset();
            		sheetObjects[0] = sheetObj; 
                    
                    initSheet(sheetObj,1,tpszperfix);
                    document.form.checksave.value="N";
                    
               	    DoSearch_Sheet1=true;
            	    sheetObj.DoSearch("EES_EQR_0012GS.do?searchKey=1", eqrFormQryStr(formObj) );
            	 /* User Check 안하는 것으로 처리
                    if(formObj.userId.value =="" && formObj.userTime.value == ""){
                         if (formObj.repo_id_used.value == ""){
                             DoSearch_Sheet1=true;
                             sheetObj.DoSearch("EES_EQR_0012GS.do?searchKey=1", eqrFormQryStr(formObj) );
                         }
                    } else {
                         if (formObj.userId.value == formObj.chkUserid.value){
                             //confirm("사용자"+formObj.userId.value+"가 "+formObj.userTime.value+"부터 사용중에 있습니다. 계속 하시겠습니까?"
                             var checkQuery=ComShowConfirm(ComGetMsg("EQR90097", formObj.userId.value, formObj.userTime.value));
                             if(checkQuery == 1){
                            	 //  formObj.f_cmd.value = SEARCHLIST;
                            	 DoSearch_Sheet1=true;
                            	 sheetObj.DoSearch("EES_EQR_0012GS.do?searchKey=1", eqrFormQryStr(formObj) );
                            	 // var sXml = sheetObj.GetSaveXml("EES_EQR_012GS.do?searchKey=2", eqrFormQryStr(formObj));
                            	 // document.form.xml.value = sXml;
                             }else{
                            	 ComOpenWait(false);
                             }
                         } else {
                             var checkQuery1=ComShowConfirm(ComGetMsg("EQR90097", formObj.userId.value, formObj.userTime.value));
                             if(checkQuery1 == 1){
                                 DoSearch_Sheet1=true;
                                 sheetObj.DoSearch("EES_EQR_0012GS.do?searchKey=1", eqrFormQryStr(formObj) );
                             }else{
                            	 ComOpenWait(false);
                             }
                         }
                    }
                 */   
                    formObj.pre_repo_rmk.value=formObj.repo_rmk.value;
            		var totalRow=sheetObj.RowCount();
            		for (i=1 ; i <= totalRow ; i++){
            			if(sheetObj.GetCellValue(i, "confirm_flg") == 'Y'){
	                		sheetObj.SetCellEditable(i ,"pln_yrwk",0);
	                		sheetObj.SetCellEditable(i ,"land_cd",0);
	                		sheetObj.SetCellEditable(i ,"vvd",0);
	                		sheetObj.SetCellEditable(i ,"fm_ecc_cd_tmp",0);
	                		sheetObj.SetCellEditable(i ,"fm_etd_dt",0);
	                		sheetObj.SetCellEditable(i ,"to_ecc_cd_tmp",0);
	                		sheetObj.SetCellEditable(i ,"to_etb_dt",0);
                      		sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",0);
                      		sheetObj.SetCellEditable(Row ,"fm_etd_dt",0);
                      		sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",0);
                      		sheetObj.SetCellEditable(Row ,"to_etb_dt",0);
                			 for(n=0; n<consTpszArr.length; n++) {
                               sheetObj.SetCellEditable(i ,consTpszArr[n].toLowerCase(),0);
                			}
                		}else{
        		        	sheetObj.InitCellProperty(i,"fm_ecc_cd_tmp",{ Type:"Data"} );
        		        	sheetObj.InitCellProperty(i,"to_ecc_cd_tmp",{ Type:"Data"} );
        		        }
                	}
            		
                    // t1btng_rowadd 버튼 Enable
                    ComBtnEnable("t1btng_rowadd");
                    // t1btng_rowdelete 버튼 Enable
                    ComBtnEnable("t1btng_rowdelete");
                                        
                    break;
               case IBDELETE:
            	   if(ComShowConfirm(ComGetMsg("EQR90193"))) {
            		   if(!validateForm(sheetObj,formObj,sAction)){
                           return false;
                        }
            		   
	            	   formObj.f_cmd.value=MULTI04;
	            	   var sXml= sheetObj.GetSaveData("EES_EQR_0012GS.do", FormQueryString(formObj));
	            	   var strDelYn=ComGetEtcData(sXml, "delYN");
	                   if (strDelYn == "Y" || strDelYn == "E") {
	                	   if(strDelYn == "E") {
	                		   ComShowCodeMessage("EQR01150");
	                	   }
	                	   formObj.yyyyww.value = "";
	                	   formObj.seq.value = "";
	                	   formObj.repo_rmk.value = "";
	       	        	 
	       	        	   ComBtnDisable("btn_create");
	       				   ComBtnDisable("btn_delete");
	       				   
		       				var toPlnyr = document.form.toPlnYr.value;
		            	  	var toPlnWk = document.form.toPlnWk.value;
		            	  	                  
		            	  	formObj.reset();
		                    
		                    comboObjects[0].SetSelectCode(consTpsz);
		                    tpszChange(''); // ALL 선택
		                    sheetObjects[0].RemoveAll();
		                    // t1btng_rowadd 버튼 Disable
		                    ComBtnDisable("t1btng_rowadd");
		                    ComBtnDisable("t1btng_rowdelete");
		                    
		                    ComShowCodeMessage("EQR01151");
	                   }else{
	                	   ComShowCodeMessage("EQR01150");
		              	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
		              	   ComBtnDisable("btn_create");
	       				   ComBtnDisable("btn_delete");
		               }
            	   }
            	   break;
               case IBSAVE:        //저장
                	 if(!validateForm(sheetObj,formObj,sAction)){
                       return false;
                     }
                	 
                     var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I")  + sheetObj.RowCount("U");
                     var totalIURow = sheetObj.RowCount("I")  + sheetObj.RowCount("U")  + sheetObj.RowCount("D");
                     var current=0;
                     var current1=0;
                     var current2=0;
                     
                     if(totalIURow == 0) {
                    	 ComShowMessage(ComGetMsg("EQR90225"));
                  	   	return false;
                     }
                     
                     // FIXED 에서 해당 VVD,POL 총 수량이  변경이 일어났을때 체크로직
                     for (m=1 ; m <= totalRow ; m++){
                    	 if (sheetObj.GetCellValue(m ,"save_flg") == 'Y'){
                            current++;
                        }
                     }
                     // 저장을 안하고 confirm 버튼을 눌렸을때 방지하기 위한 체크로직
                      for (m=1 ; m <= totalRow ; m++){
                    	  if (sheetObj.GetCellValue(m ,"ibflag") == 'I'){
                            current1++;
                        }
                      }
                      // insert 된 PLAN의 Total값이 0이 있는지 체크하는 로직
                      for (m=1 ; m <= totalRow ; m++){
                    	  if (sheetObj.GetCellValue(m ,"ibflag") == 'I'){
                    		  if(sheetObj.GetCellValue(m, "total")=="0")
                          	   {
                          		ComShowCodeMessage("EQR90128", eval(m));
                          		return false;
                          	   }
                           }
                       }
                      
                      for (m=1 ; m <= totalRow ; m++){
                    	  if (sheetObj.GetCellValue(m ,"ibflag") == 'U'){
                    		  if(sheetObj.GetCellValue(m, "total")=="0")
                          	   {
                          		ComShowCodeMessage("EQR90128", eval(m));
                          		return false;
                          	   }
                           }
                       }
                      
                     //FIXED에서 해당 VVD,POL의 총 수량의 오류 위치를 만들어주는 로직
                      if(current > 0){
                            var checkPOL='';
                            var checkname='';
                            var tpszperfix1=comboObjects[0].GetSelectText();
                            var tpsz1=tpszperfix1.split(',');
                            for (m=1 ; m <= totalRow ; m++){
                            	if (sheetObj.GetCellValue(m ,"save_flg") == 'Y'){
                                    for(i=0 ; i <tpsz1.length ; i++){
                                      var checkYpsz="save_flg"+tpsz1[i].toLowerCase();
                                      if(sheetObj.GetCellValue(m, checkYpsz.toLowerCase()) == 'Y'){
                                    	  checkname="POL:"+sheetObj.GetCellValue(m,"fm_ecc_cd")+" VVD:"+ sheetObj.GetCellValue(m,"vvd") +" TP/SZ:"+tpsz1[i]+"\n";
                                          checkPOL=checkPOL + checkname;
                                       }
                                   }
                                }
                            }
                         // (checkPOL+"에 대한 수량이 맞지 않습니다.");
                         // ComShowMessage(checkPOL+"에 대한 수량이 맞지 않습니다.");
                         //ComShowMessage(ComGetMsg("EQR90134",checkPOL));
                          //return false;
                      }
//                      if(current1 > 0){
//                        var rerunflg =  ComShowConfirm(ComGetMsg("EQR90155"));
//                          if (rerunflg == '1'){
//                              return false;
//                          }
//                      }
                     // distirbuted 가 된 RepoPlna id 인지 아닌지 체크
                    var dist_flg=formObj.dtrb_flg.value;
                        if (dist_flg == 'Y'){
                          if (current1 >0){
                              var dist_flag_num=ComShowConfirm(ComGetMsg("EQR90157" , formObj.repo_id_used.value , ComGetMsg("EQR90155")));
                                  if (dist_flag_num != 1){
                                      return false;
                                     }
                          }else {
                              var dist_flag_num=ComShowConfirm(ComGetMsg("EQR90132" , formObj.repo_id_used.value));
                                 if (dist_flag_num != 1){
                                  return false;
                                 }
                           }
                        }else{
                          if (current1 >0){
                             var rerunflg=ComShowConfirm(ComGetMsg("EQR90156"));
                                if (rerunflg != 1){
                                    return false;
                                  }
                             }
                        }
                        
                        var totalChkRow = sheetObj.HeaderRows() + sheetObj.RowCount("I")  + sheetObj.RowCount("U");
	                   	if(totalChkRow > 0 ) {
							var strfmlen = "";
							var strfmCd = "";
							var strtolen = "";
							var strtoCd = "";
							for(var i=sheetObj.HeaderRows();i<totalChkRow;i++) {
								strfmCd = sheetObj.GetCellValue(i,"fm_ecc_cd_tmp");
	              				strfmlen = strfmCd.length;
	              					
	              				strtoCd = sheetObj.GetCellValue(i,"to_ecc_cd_tmp");
	              				strtolen = strtoCd.length;
	              					
	              				if(strfmlen != 5) {
	              					sheetObj.InitCellProperty(i,"fm_ecc_cd_tmp",{ Type:"Text"});
	       							sheetObj.SetCellValue(i,"fm_ecc_cd_tmp","",0);
	              					sheetObj.SetCellValue(i,"fm_ecc_cd_tmp",strfmCd.substring(3,8),0);
	              				}
	              					
	              				if(strtolen != 5) {
	              					sheetObj.InitCellProperty(i,"to_ecc_cd_tmp",{ Type:"Text"});
	       							sheetObj.SetCellValue(i,"to_ecc_cd_tmp","",0);
	              					sheetObj.SetCellValue(i,"to_ecc_cd_tmp",strtoCd.substring(3,8),0);
	              				}
	              			}
	                    }                      
                        
                        if(totalRow > 0 ) {
                        	var sRow=sheetObj.FindStatusRow("I|U|D");
              				var arRow=sRow.split(";");
        					var flag=true;
        					var saveStr = sheetObj.GetSaveString();
        					if(sRow!="" && sRow!=null) {
        						formObj.f_cmd.value=MULTI;
        						sheetObj.DoSave("EES_EQR_0012GS.do", eqrFormQryStr(formObj), -1, false);
        					}
                        }
                        
                       if(formObj.pre_repo_rmk.value != formObj.repo_rmk.value){
                    	    ComShowConfirm(ComGetMsg("EQR90236"));
	   						formObj.f_cmd.value=MULTI03;
	   						ComOpenWait(true);
	   						var sXml=sheetObj.GetSaveData("EES_EQR_0012GS.do" , eqrFormQryStr(formObj));
	   						ComOpenWait(false);
	   						sheetObj.LoadSaveData(sXml,{Sync:1});
	   						formObj.pre_repo_rmk.value=formObj.repo_rmk.value;
	   						ComEtcDataToForm(document.form, sheetObj);
                        }
                   break;
               case IBSEARCH_ASYNC01:        //comfirm 실행
                   if(!validateForm(sheetObj,formObj,sAction)) {
                       return false;
                   }
                   var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I");
                   var current=0;
                   for (m=1 ; m <= totalRow ; m++){
                	   if (sheetObj.GetRowStatus(m) == 'I' || sheetObj.GetRowStatus(m) == 'U'){
                		   current++;
                	   }
                   }
                   
                   if(current > 0){
                          //("변경된 값이 저장이 안되었습니다. 저장을 먼저 하십시요!");
                	   ComShowMessage(ComGetMsg("EQR90118"));
                	   return false;
                   }

                   
                   formObj.f_cmd.value=MULTI01;
                   sheetObj.DoAllSave("EES_EQR_0012GS.do", eqrFormQryStr(formObj));
                   break;
                   
                case IBSEARCH_ASYNC02:        //저장
                    sheetObj.SetWaitImageVisible(0);
                    formObj.f_cmd.value=SEARCHLIST04;
                    sheetObj.DoSearch("EES_EQR_0012GS3.do", eqrFormQryStr(formObj) );
                    sheetObj.RemoveAll();
                    //if(curTabIndex == 0){
        	               sheetObj.SetWaitImageVisible(1);
            	    //}
//            	         //두번째 탭 retrive 설정
//            	        if (curTabIndex == 1){
//        	               sheetObj.SetWaitImageVisible(1);
//            	        }
//            	         // 세번째 탭 retrive 설정
//        	            if(curTabIndex == 2){
//        	               sheetObj.SetWaitImageVisible(1);
//        	            }
                    break;
                    
                case IBSEARCH_ASYNC03:        //저장
                    sheetObj.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    formObj.f_cmd.value=MULTI02;
                    //조회후 repo_rmk의 값을 pre_repo_rmk에 동일하게 설정한다.
                    formObj.pre_repo_rmk.value = formObj.repo_rmk.value;  
                    sheetObj.DoSearch("EES_EQR_0012GS6.do", eqrFormQryStr(formObj) );
                    break;
                case IBSEARCH_ASYNC04:
                	sheetObj.SetWaitImageVisible(2);
                    ComOpenWait(true);
                    
                	formObj.f_cmd.value=SEARCH18;
                    var sXml=sheetObj.GetSearchData("EES_REPO_COMMONGS.do" , FormQueryString(formObj));        
                    var strDataYN		=	ComGetEtcData(sXml, "DataYN");
                    //Search01
                    var strScnrId01		=	"";
                    var strRepoRmk01	=	"";
                    var strType01			=	"";
                    var strRepoPlnId01	=	"";
                    var strDtrbFlg01		=	"";
                    var strReplPlnYn01	=	"";     
                    //Search02
                    var strStYear02		=	"";
                    var strStWeekly02	=	"";
                    var strStMonth02		=	"";
                    var strEndYear02		=	"";
                    var strEndWeekly02	=	"";
                    var strEndMonth02		=	"";      
                    //Search03
                    var strPerFixMonth03	=	"";
                    var strTitleMonth03		=	"";    
                    //Search04
                    var strPerFixWeekly04	=	"";
                    var strTitleWeekly04		=	"";
                    var strPerFixMonthly04	=	"";    
                    //Search05
                    var strMonthlyCount05	=	"";  
                    //Search06
                    var strMaxPlyYr06	=	"";
                    var strMaxWeekly06	=	"";
                    var strMaxPlnMon06	=	"";     
                    //Search07
                    var strFromToPlnId07	=	"";                        
                    //Search08
                    var strScnrIdList08		=	"";
                    var strReplPlnIdList08	=	"";    
                    //Search09
                    var strTodayWeekly09	=	"";  
                    //Searhc10
                    var strExePlnEditFlg10	=	"";                    
                    //Search11
                    var strMaxWkStr11		= "";                    
                    //Search12
                    var strRepoPlnNextWeek12	=	"";                    
                    //Search13
                    var strExePlnEditFlgSplit13	=	"";	                    
                    var max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
                    
                    if(strDataYN == "Y") {
	                    //Search01
	                    strScnrId01		=	ComGetEtcData(sXml, "scnr_id");
	                    strRepoRmk01	=	ComGetEtcData(sXml, "repo_rmk");
	                    strType01			=	ComGetEtcData(sXml, "type");
	                    strRepoPlnId01	=	ComGetEtcData(sXml, "repo_pln_id");
	                    strDtrbFlg01		=	ComGetEtcData(sXml, "dtrb_flg");
	                    strReplPlnYn01	=	ComGetEtcData(sXml, "replPlnYn");     
	                    //Search02
	                    strStYear02		=	ComGetEtcData(sXml, "st_year");
	                    strStWeekly02	=	ComGetEtcData(sXml, "st_weekly");
	                    strStMonth02		=	ComGetEtcData(sXml, "st_month");
	                    strEndYear02		=	ComGetEtcData(sXml, "end_year");
	                    strEndWeekly02	=	ComGetEtcData(sXml, "end_weekly");
	                    strEndMonth02		=	ComGetEtcData(sXml, "end_month");      
	                    //Search03
	                    strPerFixMonth03	=	ComGetEtcData(sXml, "perfix_month");
	                    strTitleMonth03		=	ComGetEtcData(sXml, "title_month");    
	                    //Search04
	                    strPerFixWeekly04	=	ComGetEtcData(sXml, "perfix_weekly");
	                    strTitleWeekly04		=	ComGetEtcData(sXml, "title_weekly");
	                    strPerFixMonthly04	=	ComGetEtcData(sXml, "perfix_monthly");    
	                    //Search05
	                    strMonthlyCount05	=	ComGetEtcData(sXml, "monthly_count");  
	                    //Search06
	                    strMaxPlyYr06	=	ComGetEtcData(sXml, "max_plnYr");
	                    strMaxWeekly06	=	ComGetEtcData(sXml, "max_weekly");
	                    strMaxPlnMon06	=	ComGetEtcData(sXml, "max_plnMon");     
	                    //Search07
	                    strFromToPlnId07	=	ComGetEtcData(sXml, "fromToPlnId");                        
	                    //Search08
	                    strScnrIdList08		=	ComGetEtcData(sXml, "scnrIdList");
	                    strReplPlnIdList08	=	ComGetEtcData(sXml, "repoPlnIdList");    
	                    //Search09
	                    strTodayWeekly09	=	ComGetEtcData(sXml, "todayWeekly");  
	                    //Searhc10
	                    strExePlnEditFlg10	=	ComGetEtcData(sXml, "exePlnEditFlg");                    
	                    //Search11
	                    strMaxWkStr11		=ComGetEtcData(sXml, "maxWkStr");                    
	                    //Search12
	                    strRepoPlnNextWeek12	=	ComGetEtcData(sXml, "repoPlnNextWeek");                    
	                    //Search13
	                    strExePlnEditFlgSplit13	=	ComGetEtcData(sXml, "exePlnEditFlg_split");	                    
	                    max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
                    }
                    
                    formObj.scnr_id.value = strScnrId01;
          			formObj.repo_rmk.value = strRepoRmk01;
          			formObj.repo_rmk.title = strRepoRmk01;
          			formObj.st_year.value = strStYear02;
          			formObj.st_month.value = strStMonth02;
          			formObj.st_weekly.value = strStWeekly02;
          			formObj.end_year.value =	strEndYear02;
          			formObj.end_month.value = strEndMonth02;
          			formObj.end_weekly.value = strEndWeekly02;
          			formObj.perfix_month.value = strPerFixMonth03;
          			formObj.title_month.value = strTitleMonth03;
          			formObj.perfix_weekly.value =strPerFixWeekly04;
          			formObj.title_weekly.value = strTitleWeekly04;
          			formObj.monthly_count.value = strMonthlyCount05;
          			formObj.status_type.value = strType01;
          			formObj.dtrb_flg.value = strDtrbFlg01;
          			formObj.max_weekly.value = strMaxWeekly06;
          			formObj.fromToPlnId.value = strFromToPlnId07;
          			formObj.max_plnYrWk.value = max_plnYrWk;
          			if(formObj.scnrIdList != null )  	formObj.scnrIdList.value 	= strScnrIdList08;
          			if(formObj.repoPlnIdList != null ) formObj.repoPlnIdList.value= strReplPlnIdList08;
          			if(formObj.max_plnYr != null )  	formObj.max_plnYr.value 	= strMaxPlyYr06;
          			if(formObj.max_plnMon != null )  	formObj.max_plnMon.value 	= strMaxPlnMon06;
          			if(formObj.todayWeekly != null )  	formObj.todayWeekly.value 	= strTodayWeekly09;
          			if(formObj.exePlnEditFlg != null ) formObj.exePlnEditFlg.value= strExePlnEditFlg10;
          			if(formObj.exePlnEditFlg_split != null ) formObj.exePlnEditFlg_split.value= strExePlnEditFlgSplit13;
          			if(formObj.repoPlnNextWeek != null ) formObj.repoPlnNextWeek.value = strRepoPlnNextWeek12;
          			
          			if(strReplPlnYn01 == "Y") {
          				parent.ComBtnDisable("btn_create");
          				parent.ComBtnDisable("btn_delete");
          			}else{
          				parent.ComBtnDisable("t1btng_rowadd");
          				parent.ComBtnDisable("t1btng_rowdelete");
          				
          				parent.ComBtnDisable("btn_create");
          				parent.ComBtnEnable("btn_delete");
          			}
          			formObj.maxWkStr.value = strMaxWkStr11;  
          			ibSearchAsync03();
          			setEccCommon();
                    
          			ComOpenWait(false);
                	break;
               case IBINSERT:
                    var sum1='';
                    var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I");
                    var tpszperfix=comboObjects[0].GetSelectText();
                    var tpsz=tpszperfix.split(',');
                    //var Row=sheetObj.DataInsert();
                    var Row=parseInt(sheetObj.DataInsert());
                    var setRow = Row-1;
                    
                    var formObject=document.form;
                    if(sheetObj.GetCellValue(setRow, 'past_repo_pln_flg') == '1'){  // 20070626 체크 로직 변경 (fix 관련 )
                    	var past_repo_pln_check=ComShowConfirm(ComGetMsg("EQR90166"));
                    	if (past_repo_pln_check == '1') {
                    		var currentDay=replaceAll(document.form.currentDay.value.substring(0,10),"/","");
                            var etd_st=replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(0,10),"-","");
                            var eta_dt=replaceAll(sheetObj.GetCellValue(Row,"to_etb_dt").substring(0,10),"-","");
                            
                            // 선택된 fixed 된 row을 아래 Row로 카피한다.
                            sheetObj.SetCellValue(Row ,'pln_yrwk',sheetObj.GetCellValue(Row-1 , 'pln_yrwk'),0);
    	                    sheetObj.SetCellEditable(Row ,'pln_yrwk',0);
    	                    sheetObj.SetCellValue(Row ,'land_cd',sheetObj.GetCellValue(Row-1 , 'land_cd'),0);
    	                    sheetObj.SetCellEditable(Row ,'land_cd',0);
    	                    sheetObj.SetCellValue(Row ,'vvd',sheetObj.GetCellValue(Row-1 , 'vvd'),0);
    	                    sheetObj.SetCellEditable(Row ,'vvd',0);
    	                    
    	                    sheetObj.SetCellValue(Row ,'fm_ecc_cd_tmp',sheetObj.GetCellValue(Row-1 , 'fm_ecc_cd_tmp'),0);
    	                    sheetObj.SetCellValue(Row,"fm_ecc_cd",sheetObj.GetCellValue(Row-1 , 'fm_ecc_cd_tmp'),0);
    	                    sheetObj.SetCellEditable(Row ,'fm_ecc_cd_tmp',0);
    	                    sheetObj.SetCellValue(Row ,'fm_etd_dt',sheetObj.GetCellValue(Row-1 , 'fm_etd_dt'),0);
							sheetObj.SetCellEditable(Row ,'fm_etd_dt',1);
							sheetObj.SetCellValue(Row ,'fm_yard',sheetObj.GetCellValue(Row-1 , 'fm_yard'),0);
							   //sheetObj.CellValue2(Row ,'to_ecc_cd_tmp') = sheetObj.CellValue(Row-1 , 'to_ecc_cd_tmp');
							sheetObj.SetCellEditable(Row ,'to_ecc_cd_tmp',1);
							   // sheetObj.CellValue2(Row ,'to_etb_dt') = sheetObj.CellValue(Row-1 , 'to_etb_dt');
							sheetObj.SetCellEditable(Row ,'to_etb_dt',1);
							sheetObj.SetCellEditable(Row ,'to_yard',1);
							
							sheetObj.SetCellValue(Row , 'repo_pln_id',sheetObj.GetCellValue(setRow ,'repo_pln_id'),0);
							sheetObj.SetCellValue(Row , 'vsl_cd',sheetObj.GetCellValue(Row-1 ,'vsl_cd'),0);
							sheetObj.SetCellValue(Row , 'skd_voy_no',sheetObj.GetCellValue(Row-1 ,'skd_voy_no'),0);
							sheetObj.SetCellValue(Row , 'skd_dir_cd',sheetObj.GetCellValue(Row-1 ,'skd_dir_cd'),0);
							sheetObj.SetCellValue(Row , 'fm_ecc_cd',sheetObj.GetCellValue(Row-1 ,'fm_ecc_cd'),0);
							sheetObj.SetCellValue(Row , 'to_ecc_cd',sheetObj.GetCellValue(Row-1 ,'to_ecc_cd'),0);
							sheetObj.SetCellValue(Row , 'fm_ecc_cd_tmp1',sheetObj.GetCellValue(Row-1 ,'fm_ecc_cd_tmp1'),0);
							sheetObj.SetCellValue(Row , 'fm_etd_dt1',sheetObj.GetCellValue(Row-1 ,'fm_etd_dt1'),0);
							sheetObj.SetCellValue(Row , 'to_ecc_cd_tmp1',sheetObj.GetCellValue(Row-1 ,'to_ecc_cd_tmp1'),0);
							sheetObj.SetCellValue(Row , 'to_etb_dt1',sheetObj.GetCellValue(Row-1 ,'to_etb_dt1'),0);
							sheetObj.SetCellValue(Row , 'fm_ecc_cd_flg',sheetObj.GetCellValue(Row-1 ,'fm_ecc_cd_flg'),0);
							sheetObj.SetCellValue(Row , 'to_ecc_cd_flg',sheetObj.GetCellValue(Row-1 ,'to_ecc_cd_flg'),0);
							sheetObj.SetCellValue(Row , 'fix_to_ecc',sheetObj.GetCellValue(Row-1 ,'to_ecc_cd'),0);
							sheetObj.SetCellValue(Row-1 , 'fix_to_ecc',sheetObj.GetCellValue(Row-1 ,'to_ecc_cd'),0);
							sheetObj.SetCellValue(Row , 'pln_seq',"0",0);
							// 구분자를 체크해서 반영을 한다.
							for(m=0 ; m <tpsz.length ; m++){
								var tpszCol="sum_cntp_code"+tpsz[m].toLowerCase();
								var tpszflg="sum_cntp_flg"+tpsz[m].toLowerCase();
								var tpszqty="sum_cntp_qty"+tpsz[m].toLowerCase();
								var tpszval="fix_"+tpsz[m].toLowerCase();
								sheetObj.SetCellValue(Row , tpszCol,sheetObj.GetCellValue(Row , "land_cd")+sheetObj.GetCellValue(Row ,"vvd")+sheetObj.GetCellValue(Row,"fm_ecc_cd")+tpsz[m]+"1" ,0);
								sheetObj.SetCellValue(Row-1 , tpszval,sheetObj.GetCellValue(Row-1 ,tpsz[m].toLowerCase()),0);
								sheetObj.SetCellValue(Row , tpszval,sheetObj.GetCellValue(Row-1 ,tpsz[m].toLowerCase()),0);
							    sheetObj.SetCellValue(Row , tpszflg,'',0);
							    sheetObj.SetCellValue(Row , tpszqty,0 ,0);
							  // sheetObj.CellValue2(Row , tpsz[m]) = 0 ;
                            }
							
							
    	                    for(n=0 ; n <tpsz.length ; n++){
    	                    	sheetObj.SetCellEditable(Row ,tpsz[n].toLowerCase(),1);

    	                    }
    	                        sheetObj.SetCellValue(Row, 'past_repo_pln_flg',sheetObj.GetCellValue(Row-1, 'past_repo_pln_flg'),0);
    	                       // sheetObj.CellValue (Row-1,"check") = "1";
    	                        sheetObj.SetCellValue(Row,"check","1",0);
    	                        sheetObj.SetCellEditable(Row , 'past_repo_pln_flg',0);
    	                        // pod 검색
    	                        var seachword=sheetObj.GetCellValue(Row,"vvd");
    	                        var repo_id=sheetObj.GetCellValue(2,"repo_pln_id");
    	                          var vsl_cd=seachword.substring(0,4);
    	                          var skd_voy_no=seachword.substring(4,seachword.length -1);
    	                          var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
    	                          var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
    	                          var colname="to_ecc_cd_tmp";
    	                          var vsl_loc_cd=sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
    	                          var fmToAt2=1;
    	                          var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
    	                          var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    	                          var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    	                          var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
    	                          var pln_yrwk1=sheetObj.GetCellValue(Row,"pln_yrwk");
    	                          	var pln_yrwk_tmp=sheetObj.GetCellValue(Row,"fm_etd_dt"); // etd_dt날짜 기준으로 조회
    	                          var pln_yrwk=pln_yrwk_tmp.substr(0,10);
    	                          //sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
    	                          var f_cmd=SEARCHLIST06;
//
    	                          sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=to&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&colname1=search_etd_start&colname2=search_etd_end&searchword="+ pln_yrwk1);
    	                          
    	                          sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
    	                          
    	                          var chkData=sheetObj.GetCellValue(Row, colname);
    	                          if (chkData != "" ) { 
    	                        	  sheetObj.SetCellValue(Row,colname, "", 0);
    	                          } else {
    	                        	  
    	                        	  //sheetObj.InitCellProperty(Row,colname,dtData);
//    	                        	  var info = {Type: "Text", Align: "Center", Edit: 0};
    	                        	  sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
    	                        	  sheetObj.SetCellValue(Row,colname, "", 0);
    	                          } 
    	                          
    	                              	                          
     	                        }else {
                                     sheetObj.SetCellEditable(Row ,"pln_yrwk",0);
                              //      sheetObj.CellEditable(Row ,"co_cd") = true;
                                     sheetObj.SetCellEditable(Row ,"land_cd",0);  // false
                                     sheetObj.SetCellEditable(Row ,"vvd",1);
                                     sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",0);
                                     sheetObj.SetCellEditable(Row ,"fm_etd_dt",1);
                                     sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",0);
                                     sheetObj.SetCellEditable(Row ,"to_etb_dt",1);
                                       for(n=0 ; n <tpsz.length ; n++){
                                           sheetObj.SetCellEditable(Row ,tpsz[n].toLowerCase(),1);
                                         }
                                     sheetObj.SetCellValue(Row , 'pln_seq',"0",0);
                                   //  sheetObj.CellValue2(Row, 'past_repo_pln_flg') = sheetObj.CellValue(Row-1, 'past_repo_pln_flg');
                                     sheetObj.SetCellEditable(Row , 'past_repo_pln_flg',0);// 20070626 fix관련 추가
                            }
                          } else {
                           
                                     sheetObj.SetCellEditable(Row ,"pln_yrwk",0);
                              //      sheetObj.CellEditable(Row ,"co_cd") = true;
                                     sheetObj.SetCellEditable(Row ,"check",0);
                                     sheetObj.SetCellEditable(Row ,"land_cd",0);
                                     sheetObj.SetCellEditable(Row ,"vvd",1);
                                     sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",0);
                                     sheetObj.SetCellEditable(Row ,"fm_etd_dt",1);
                                     sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",0);
                                     sheetObj.SetCellEditable(Row ,"to_etb_dt",1);

                        	         if(Row > 2) {
                        	        	 //sheetObj.SetCellValue(Row, 'pln_yrwk', 0) = sheetObj.GetCellValue(setRow , 'pln_yrwk');
                        	        	 sheetObj.SetCellValue(Row, 'pln_yrwk', sheetObj.GetCellValue(setRow , 'pln_yrwk'), 0);
                        	         } else {
                        	        	 //sheetObj.SetCellValue(Row, 'pln_yrwk', 0) = formObject.yyyyww.value;
                        	        	 sheetObj.SetCellValue(Row, 'pln_yrwk', formObject.yyyyww.value, 0);
                        	         }                                  
                                                                          
                                     sheetObj.SetCellValue(Row , 'pln_seq',"0",0);
                                       for(n=0 ; n <tpsz.length ; n++){
                                           sheetObj.SetCellEditable(Row ,tpsz[n].toLowerCase(),1);
                                         }
                                       sheetObj.SetCellValue(Row, 'past_repo_pln_flg',sheetObj.GetCellValue(Row-1, 'past_repo_pln_flg'),0);
                                     sheetObj.SetCellEditable(Row , 'past_repo_pln_flg',0);// 20070626 fix관련 추가
                          }
                    break;
                case IBDOWNEXCEL:
                	if(sheetObj.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
       	       		}else{
       	       			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
       	       		}
                    break;
            }
        }
    /**
     * 조회 함수를 이용하여 조회가 완료된 후의 작업 처리<br>
     * @param {ibsheet} Event       IBSheet 조회 후 발생하는 Event
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//sheetObjects[0].SetWaitImageVisible(0);            
		
        if (ErrMsg == "") {
            var formObject=document.form;
            // IBSEARCH_ASYNC03 실행후 신규일 경우
            if (formObject.f_cmd.value == MULTI02) {
                if (sheetObj.GetEtcData("dupYN") == "N") {
                    /*formObject.f_cmd.value=SEARCHLIST03;
                    formObject.target="051iframe";
                    formObject.action="EES_REPO_COMMON.do";
                    formObject.submit();*/
                	ComOpenWait(true);
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
                    setTimeout(search01, 1500);
                } else {
                    doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC02);
                }
                ComOpenWait(false);
            } else if (formObject.f_cmd.value == SEARCH) {
                sheetObj.RenderSheet(0);
                for (var i=sheetObj.HeaderRows(); sheetObj.SearchRows(); i++) {
                    sheetObj.SetRowStatus(i,"I");
                    sheetObj.SetCellValue(i, "to_ecc_cd_flg","Y",0);
                }
                sheetObj.RenderSheet(1);
                DoSearch_Sheet1=false;
            } else {
                // 조회후 소계 계산
                ComEtcDataToForm(formObject, sheetObj);

                var sum1='';
                var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I");
                var tpszperfix=comboObjects[0].GetSelectText();
                var tpsz=tpszperfix.split(',');

                for (m=0 ; m <tpsz.length ; m++) {
                    sum1=sum1 +  "|"+tpsz[m].toLowerCase();
                }

                if(DoSearch_Sheet1) {
                    //sheetObj.HideSubSum();
                    sheetObj.SetSumBackColor("#ECE7F7");;
                    //sheetObj.SetSumText( 0,1,"");
                    //sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
                    sheetObj.SetSumText( 0,1,"Grand TTL");
                    sheetObj.SetMergeCell(sheetObjects[0].LastRow(), 1, 1, 5);
                    //sheetObj.SetCellText(sheetObjects[0].LastRow(), "pln_yrwk", "Grand TTL");
                    sheetObj.ShowSubSum([{StdCol:1, SumCols:"total"+sum1, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"SubTTL"}]);
                    
                }
                
                DoSearch_Sheet1=false;
            }
            ComOpenWait(false);
         // Checking the Confirm Flag.
            var cnt=sheetObj.RowCount()+1;
            for(var i=1; i <= cnt ; i++){
            	if(sheetObj.GetCellValue(i, "confirm_flg") == "Y"){
            		sheetObj.SetCellEditable(i ,"delcheck",0);
            		
            		sheetObj.SetCellEditable(i,"vvd",0);    	  
              	  
              	  	sheetObj.SetCellEditable(i,"fm_etd_dt",0);
              	  	sheetObj.SetCellEditable(i,"to_etb_dt",0);
              	  	sheetObj.SetCellEditable(i,"fm_ecc_cd_tmp",0);
              	  	sheetObj.SetCellEditable(i,"to_ecc_cd_tmp",0);
              	  	
              	    for(n=0 ; n <tpsz.length ; n++){
              	    	sheetObj.SetCellEditable(i ,tpsz[n].toLowerCase(),0);
              	    }
		        }else{
		        	sheetObj.SetCellEditable(i,"fm_etd_dt",0);
              	  	sheetObj.SetCellEditable(i,"to_etb_dt",0);
		        }
            }
            
            var formObj = document.form; 
        	formObj.f_cmd.value=SEARCHLIST10;
        	var sXml= sheetObj.GetSearchData("EES_EQR_0012GS.do", FormQueryString(formObj));
        	
        	var strDataYN=ComGetEtcData(sXml, "dataYN");
        	
        	if(strDataYN == "Y") {
        		ComBtnDisable("btn_create");
                ComBtnDisable("btn_delete");
        	}else{
        		ComBtnDisable("btn_create");
                ComBtnEnable("btn_delete");
        	}
            
        }
    }
    
    
	function  sheet1_OnSaveEnd(sheetObj, errMsg){
		if(form.pre_repo_rmk.value == form.repo_rmk.value){
			ComEtcDataToForm(document.form, sheetObj);
			document.form.checksave.value="Y";
			//if(errMsg=='') ComShowMessage(ComGetMsg("EQR90106")); // 저장완료
		}
		
		document.form.userId.value="";
  	  	document.form.userTime.value="";
  	  	document.form.repo_id_used.value="";
  	  	
  	  	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	}
      
      // 수치 바꾼후에 소개 계산
	function sheet1_OnChange(sheetObj , Row, Col, Val){
		var sum1='';
        var sum2=0;
        var sum3=0;
        var sum4=0;
        var cnt=0;
        var cnt1=0;
        var bol=false;
        var searchword="";
        var formObject=document.form;
        var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I");
        var tpszperfix=comboObjects[0].GetSelectText();
        var tpsz=tpszperfix.split(',');
        var savekey="";
        var savekey1="";
        formObject.tpszCurrent.value=tpszperfix;
        
        for(m=0 ; m <tpsz.length ; m++){
        	sum1=sum1 +  "|"+tpsz[m].toLowerCase();
        }
        
        // 해당 Row의 Total 합계를 구한다.
        for(l=0 ; l < tpsz.length ; l++){
        	sum2=eval(sum2) + eval((sheetObj.GetCellValue(Row ,tpsz[l].toLowerCase())));
        }
         
        sheetObj.SetCellValue(Row,"total",sum2,0);
        sheetObj.SetSelectRow(Row);
         
        // 
        ComEtcDataToForm(formObject, sheetObj);
        var sum1='';
        var totalRow = sheetObj.RowCount() + sheetObj.RowCount("I");
        var tpszperfix=comboObjects[0].GetSelectText();
        var tpsz=tpszperfix.split(',');
        for (m=0 ; m <tpsz.length ; m++) {
        	sum1=sum1 +  "|"+tpsz[m].toLowerCase();
        }
         
        //sheetObj.HideSubSum();
        sheetObj.SetSumBackColor("#ECE7F7");
        sheetObj.SetSumText( 0,1,"");
        //sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
        //sheetObj.ShowSubSum([{StdCol:"pln_yrwk", SumCols:"total"+sum1, Sort:true, ShowCumulate:false, CaptionCol:1, OtherColText:"0=;1=;2=SubTTL"}]);
        sheetObj.ShowSubSum([{StdCol:1, SumCols:"total"+sum1, Sort:false, ShowCumulate:false, CaptionCol:1,  OtherColText:"0=;1=;2=SubTTL"}]);
        
        //INSERT 시 del을 체크 했을땐 그 Row를 sheet에서 삭제를 한다.
        //if(sheetObj.ColSaveName(Col) == "delcheck"){
        //    sheetObj.RowDelete(Row, false);
        // }
        // 체크버튼 클릭시 저장이나 인서트씨 입력할수 있는 컬럼 활성화 시킴
        // TRGET vvd 선택시 작동 되는 스크립트
        if(sheetObj.ColSaveName(Col) == "check"){
        	var currentDay=replaceAll(document.form.currentDay.value.substring(0,10),"/","");
            var etd_st=replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(0,10),"-","");
            var eta_dt=replaceAll(sheetObj.GetCellValue(Row,"to_etb_dt").substring(0,10),"-","");
            // 체크버튼이 활성화 시킬때
            if(sheetObj.GetCellValue(Row,"check") == "1"){
            	if (parseInt(etd_st)- parseInt(currentDay) > 0){
            		sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",1);
                }
                 
                if (eta_dt != ""){
                	if (parseInt(eta_dt)- parseInt(currentDay) > 0){
                		sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",1);
                    }
                }else{
                	sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",1);
                }
                 
                //선택된 Row의 TPSZ 입력 쉘을 활성화 시킨다.
                for(n=0 ; n <tpsz.length ; n++){
                	sheetObj.SetCellEditable(Row ,tpsz[n].toLowerCase(),1);
                }
                
              	if(parseInt(currentDay)- parseInt(etd_st) < 0){
              		sheetObj.SetCellValue(Row , "sum_flg_code","N",0);
              	}else{
              		sheetObj.SetCellValue(Row , "sum_flg_code",'',0);
              	}
              	
              	// 수량 체크를 하기 위해서 해당 스크립트는 TPSZ ALL로 스크립트를 생성한다.
              	//CSRNO : R200807097903 의거 수정
              	for(i=0; i<tpsz.length; i++){
              		var checktext=sheetObj.GetCellValue(Row,"sum_cntp_code"+ tpsz[i].toLowerCase());
              		var sum=0;
              		if (sheetObj.GetCellValue(Row,"sum_cntp_flg"+ tpsz[i].toLowerCase()) == ''){
              			// 이미 클릭이 되어 있는지 안되어 있는지 확인을 한다.
              			// 이유 type size별의 total을 구하는데 변경을 일으키지 않기 위해서 값을 셋팅을 한다.
              			for(m=1 ; m <= totalRow ; m++){
              				if(checktext == sheetObj.GetCellValue(m,"sum_cntp_code"+ tpsz[i].toLowerCase())){
              					sum=eval(sum) + eval(sheetObj.GetCellValue( m ,tpsz[i].toLowerCase()));
              				}
              			}
              		}
              		
              		if (sheetObj.GetCellValue(Row,"sum_cntp_flg" + tpsz[i].toLowerCase()) == ''){
              			for(k=1 ; k <= totalRow ; k++){
              				// 해당 컬럼에 값을 반영
              				if(checktext == sheetObj.GetCellValue(k,"sum_cntp_code"+ tpsz[i].toLowerCase())){
              					sheetObj.SetCellValue(k ,"sum_cntp_qty"+ tpsz[i].toLowerCase(),sum,0);
              					sheetObj.SetCellValue(k ,"sum_cntp_flg" + tpsz[i].toLowerCase(),'Y',0);
              					if(sheetObj.GetCellValue(k, 'past_repo_pln_flg') != '1'){
              						sheetObj.SetCellValue(k , "sum_flg_code","N",0);
              					}else {
              						if (sheetObj.GetCellValue(k,"fix_to_ecc") == ''){
              							sheetObj.SetCellValue(k,"fix_to_ecc",sheetObj.GetCellValue(k ,"to_ecc_cd_tmp1"),0);
              						}
              					}
              					
              					
              					if(sheetObj.GetCellValue(k,"check") != 1){
              						if (sheetObj.GetCellValue(k ,"ibflag") != 'I'){
              							sheetObj.SetCellValue(k,"check","1",0);
              							//해당 Row위치의 내용을 수정할수 있도록 활성화 시킨다.
              						}
              						
              						if (parseInt(etd_st)- parseInt(currentDay) > 0){
              							sheetObj.SetCellEditable(k ,"fm_ecc_cd_tmp",1);
              						}
              						
              						if (eta_dt != ""){
              							if (parseInt(eta_dt)- parseInt(currentDay) > 0){
              								sheetObj.SetCellEditable(k ,"to_ecc_cd_tmp",1);
              							}
              						}else{
              							sheetObj.SetCellEditable(k ,"to_ecc_cd_tmp",1);
              						}
              						
              						for (n=0 ; n <tpsz.length ; n++){
              							sheetObj.SetCellEditable(k ,tpsz[n].toLowerCase(),1);
              						}
              					}
              				}
              			}
              		}
              	}  // for loop 끝
            }else{
            	//클릭후 다시 버튼 클릭을 했을때는 컬럼을 비활성화 시킴
            	var unchecktextd2=sheetObj.GetCellValue(Row,"sum_cntp_code"+tpsz[0].toLowerCase());
            	for(m=2 ; m <= totalRow ; m++) {
            		
            		if(unchecktextd2 == sheetObj.GetCellValue(m,"sum_cntp_code"+tpsz[0].toLowerCase())) {
            			sheetObj.SetCellValue(m,"check","0",0);
            			sheetObj.SetCellEditable(m ,"fm_ecc_cd_tmp",1);
            			sheetObj.SetCellEditable(m,"fm_etd_dt",1);
            			sheetObj.SetCellEditable(m ,"to_ecc_cd_tmp",1);
            			sheetObj.SetCellEditable(m ,"to_etb_dt",1);
        	     	 	for(n=0 ; n <tpsz.length ; n++) {
        	     	 		sheetObj.SetCellEditable(m ,tpsz[n].toLowerCase(),0);
        	     	 		//sheetObj.SetCellEditable(m ,tpsz[n],1);
        	     	 	}
        	     	 	
        	     	 	if(sheetObj.GetRowStatus(m) == 'I'){
        	     	 		for(n=0 ; n <tpsz.length ; n++) {
        	     	 			if(sheetObj.GetCellValue(m ,tpsz[n].toLowerCase()+"_flag") !='Y'){
        	     	 				sheetObj.SetCellValue(m ,tpsz[n].toLowerCase()+"_flag",'N',0);
        	     	 			}
        	     	 		}
        	     	 	}
        	     	 	
        	     	 	// CSRNO : R200807097903 변경
        	     	 	for(n=0 ; n <tpsz.length ; n++){
        	     	 		sheetObj.SetCellValue(m ,"sum_cntp_flg"+tpsz[n].toLowerCase(),'',0);
        	     	 		sheetObj.SetCellEditable(m ,tpsz[n].toLowerCase(),1);
        	     	 	}
        	     	 	
        	     	 	if(sheetObj.GetCellValue(m, "confirm_flg") == 'Y'){
        	     	 		sheetObj.SetCellEditable(m ,"pln_yrwk",0);
	                		sheetObj.SetCellEditable(m ,"land_cd",0);
	                		sheetObj.SetCellEditable(m ,"vvd",0);
	                		sheetObj.SetCellEditable(m ,"fm_ecc_cd_tmp",0);
	                		sheetObj.SetCellEditable(m ,"fm_etd_dt",0);
	                		sheetObj.SetCellEditable(m ,"to_ecc_cd_tmp",0);
	                		sheetObj.SetCellEditable(m ,"to_etb_dt",0);
                      		sheetObj.SetCellEditable(m ,"fm_ecc_cd_tmp",0);
                      		sheetObj.SetCellEditable(m ,"fm_etd_dt",0);
                      		sheetObj.SetCellEditable(m ,"to_ecc_cd_tmp",0);
                      		sheetObj.SetCellEditable(m ,"to_etb_dt",0);
                			 for(n=0; n<consTpszArr.length; n++) {
                               sheetObj.SetCellEditable(m ,consTpszArr[n].toLowerCase(),0);
                			}
        	     	 	}
        	     	 	//sheetObj.SetRowStatus(m,'');
            		}
            	}
            }
        }
 	 
          
        // insert를 한 경우
        if(sheetObj.GetRowStatus(Row) == 'I'){
        	//ETA ETD COBO(TO)
        	if(sheetObj.GetCellValue(Row ,"pln_yrwk") !="" && sheetObj.GetCellValue(Row , "land_cd") !="" && sheetObj.GetCellValue(Row ,"vvd") !="" && sheetObj.GetCellValue(Row ,"fm_ecc_cd_tmp") !=""){
        		for(m=0 ; m <tpsz.length ; m++){
        			var tpszCol="sum_cntp_code"+tpsz[m].toLowerCase();
        			sheetObj.SetCellValue(Row , tpszCol,sheetObj.GetCellValue(Row , "land_cd")+sheetObj.GetCellValue(Row ,"vvd")+sheetObj.GetCellValue(Row,"fm_ecc_cd")+tpsz[m] + sheetObj.GetCellValue(Row,"past_repo_pln_flg"),0);
        		}
        		sheetObj.SetCellValue(Row,"check","1",0);
        	}
        }     
        // insert 인경우 끝-----------------
     
        if (sheetObj.ColSaveName(Col) == "pln_yrwk"){
        	var weekInput=sheetObj.GetCellValue(Row, Col);            // 입력한 데이타 week
			var pln_yrwk=document.form.yyyyww.value;  // pln yrwk 데이타
			var maxWeek=document.form.toPlnYr.value + document.form.toPlnWk.value;  // repo plan의 최대한계 week
			// 반드시 PLN YRWK 에 6자리 입력이어야 다음 진행
			if(pln_yrwk.length != 6) {
				// pln yrwk 를 입력하세요.
				ComShowCodeMessage("EQR90001", "WK");
				sheetObj.SetCellValue(Row, Col,"",0);// 입력데이타 비우기
				sheetObj.SelectCell(Row, "pln_yrwk");  // pln yrwk 로 이동
				return false;
			}
			// 6자리 입력인지 확인
			if(weekInput.length < 6) {
				//ComShowMessage("please input week data format ! ");
				ComShowCodeMessage("EQR90056");
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.SelectCell(Row, Col);
				return false;
			}else {
			    // 숫자값만 입력인지 확인
				  for(var i=0; i < weekInput.length; i++) {
					  if(!('0' <= weekInput.charAt(i) && weekInput.charAt(i) <= '9')) {
						  //ComShowMessage("please input week data format ! ");
						  ComShowCodeMessage("EQR90056");
						  sheetObj.SetCellValue(Row, Col,"",0);
						  sheetObj.SelectCell(Row, Col);
						  sheetObj.SelectCell(Row, Col);
						  return false;
					  }
				  }
				  
				  // 주차 01 - 53 으로 입력했는지 확인
				  if(weekInput.substring(4,6) < 01 || weekInput.substring(4,6) > 53) {
					  //ComShowMessage("please input week data format ! ");
					  ComShowCodeMessage("EQR90056");
					  sheetObj.SetCellValue(Row, Col,"",0);
					  sheetObj.SelectCell(Row, Col);
					  return false;
				  }
				  
				  
				  if(weekInput < pln_yrwk || weekInput > maxWeek) {
					  //ComShowMessage("Week 는 "+fromWeek+"보다 작거나 "+toWeek+"보다 클수 없습니다." );
					  ComShowCodeMessage("EQR90127", pln_yrwk, maxWeek);
					  sheetObj.SetCellValue(Row, Col,"",0);
					  sheetObj.SelectCell(Row, Col);
					  return false;
				  }
			}
			//   var main_cmd = SEARCHLIST17;
			//   sheetObj.DoRowSearch("EES_WEEKDATEPERIOD.do" ,"row="+ Row +"&colname1=search_eta_start&colname2=search_eta_end&searchword="+ weekInput + "&f_cmd=" + main_cmd ,false);
        }
        
        
        // land 입력시
        if (sheetObj.ColSaveName(Col) == "land_cd"){
        	//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
        	var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
        	if(pln_yrwk.length != 6) {
        		// pln yrwk 를 입력하세요.
        		ComShowCodeMessage("EQR90001", "WK");
        		sheetObj.SetCellValue(Row, Col,"",0);// 입력데이타 비우기
        		sheetObj.SelectCell(Row, "pln_yrwk");  // pln yrwk 로 이동
        		return false;
        	}
        	
        	
        	//no support[check again]CLT var seachword=sheetObj.EditText;
        	var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
        	var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
        	var colname=sheetObj.ColSaveName(Col);
            //
        	sheetObj.SetCellEditable(Row,"vvd",1);
        	//  var f_cmd1 = SEARCH01;
        	//  sheetObj.DoRowSearch("EES_EQR_0012GS5.do" ,"row=" + Row +"&repo_id=" + repo_id+"&vsl_lane_cd=" + vsl_lane_cd + "&col=land_cd&f_cmd=" + f_cmd1 ,false);
            // 분기 타입을 설정을 한다.
        	if (sheetObj.GetCellValue(Row,"land_cd") !=''){
        		//var f_cmd = SEARCHLIST01;
        		//sheetObj.DoRowSearch("EES_EQR_0052GS1.do" ,"row=" + Row +"&vvd_yrwk=" + pln_yrwk+"&repo_id=" + repo_id+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd);
        	}else {
          	  	ComShowCodeMessage("EQR90197");
          	  	sheetObj.InitCellProperty(Row,"vvd",{ Type:"Data"} );
          	  	sheetObj.SetCellValue(Row,"vvd",'',0);
          	  	sheetObj.SetCellEditable(Row,"vvd",1);
        	}
        }
 	  
        
        //VVD 입력시
        if (sheetObj.ColSaveName(Col) == "vvd"){
        	var seachword=sheetObj.GetCellValue(Row,"vvd");
        	var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;

        	var vsl_cd=seachword.substring(0,4);
        	var skd_voy_no=seachword.substring(4,seachword.length -1);
        	var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);

        	sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",1);
        	sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Combo"});
        	sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
        	sheetObj.SetCellValue(Row,"fm_etd_dt","",0);
          
        	sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
        	sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
        	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
        	sheetObj.SetCellValue(Row,"to_etb_dt","",0);
          
        	sheetObj.SetCellEditable(Row,"land_cd",0);
//          sheetObj.InitCellProperty(Row,"land_cd",{ Type:"Combo"});
        	sheetObj.SetCellValue(Row,"land_cd","",0);          
         // hidden Column에 데이터를 셋팅 한다.          
          
        	sheetObj.SetCellValue(Row,"vsl_cd",vsl_cd,0);
        	sheetObj.SetCellValue(Row,"skd_dir_cd",skd_dir_cd,0);
        	sheetObj.SetCellValue(Row,"skd_voy_no",skd_voy_no,0);
        	sheetObj.SetCellValue(Row,"repo_pln_id",repo_id,0);
        	click_vvd=seachword;

        	var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd",0);
        	var colname   = "fm_ecc_cd_tmp";
        	var colname11 = "to_ecc_cd_tmp";
        	var colname12 = "land_cd";
                    
        	var vsl_loc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp",0);
        	var fmToAt2=1;
        	var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
        	var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
        	var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
        	//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
        	var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");

        	// added by ui opus
        	var f_cmd = SEARCHLIST06;
        	sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);          		
			
//          var chkData=sheetObj.GetCellValue(Row, colname);
        	var chkData=sheetObj.GetComboInfo(Row, colname, "Text");
        	if (chkData != "" ) { 
        		sheetObj.SetCellValue(Row,colname,"",0);
        	} else {
        		sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
        		sheetObj.SetCellValue(Row,colname,"",0);
        	}
          
        	// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
        	sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);
        	var chkData=sheetObj.GetCellValue(Row, colname11);
          
        	if (chkData != "" ) { 
        		sheetObj.SetCellValue(Row,colname11,"",0);
        	} else {
        		sheetObj.InitCellProperty(Row,colname11,{ Type:"Data"});
        		sheetObj.SetCellValue(Row,colname11,"",0);
        	}
        	
        	// VVD입력 시 해당 Lane 데이터를 입력해준다.
        	var f_cmd = SEARCHLIST07;
        	var sXml = sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname12 + "&f_cmd=" + f_cmd);
        	changeViewText(sheetObj, sXml, colname12);
        }
    
    
        // 변경된 값을 체크를 한다.  변경표시를 해준다.
        if (sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp"){
        	var eccTmp = sheetObj.GetComboInfo(Row, "fm_ecc_cd_tmp" , "Text");
        	var selIndex = sheetObj.GetComboInfo( Row , "fm_ecc_cd_tmp" , "SelectedIndex");
        	
        	var eccTmpArr = eccTmp.split("|");
        	var eccDefault = eccTmpArr[selIndex].replace(/\s/gi, ''); // 모든 공백을 제거;
        	var ecc_cd=eccDefault.substring(0,5);
        	var dt=eccDefault.substring(5,15); //25);
        	//var ecc_cd=eccTmpArr[selIndex].substring(0,5);
        	//var dt=eccTmpArr[selIndex].substring(6,16);
    	
        	var fm_ecc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
        	if (to_ecc_cd != ""){
        		sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Text"});        
        		sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp",trim(ecc_cd),0);
        		// sheetObj.CellValue2(Row,"fm_ecc_cd_tmp1") = trim(ecc_cd);
        		sheetObj.SetCellValue(Row,"fm_ecc_cd",trim(ecc_cd),0);
        		sheetObj.SetCellValue(Row,"fm_etd_dt",dt,0);
        		var search_eta_start=sheetObj.GetCellValue(Row,"search_eta_start");
        		var search_eta_end=sheetObj.GetCellValue(Row,"search_eta_end");
        		var main_eta_dt=replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(0,10),"-","");
        		//sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp3",eccDefault.substring(0,3),0);
        		//해당되는 주차내의 ETA를 선택하기 위한 조건
        		if(parseInt(search_eta_start) > parseInt(main_eta_dt)){
        			ComShowMessage(ComGetMsg("EQR90144" ,sheetObj.GetCellValue(Row,"search_eta_start") ,sheetObj.GetCellValue(Row,"search_eta_end")));
        			sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
        			sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp1","",0);
        			sheetObj.SetCellValue(Row,"fm_ecc_cd","",0);
        			sheetObj.SetCellValue(Row,"fm_etd_dt","",0);
        			if(sheetObj.GetRowStatus(Row) == 'I'){
        				sheetObj.SetCellValue(Row,"check","0",0);
        			}
        		}
          
        		//해당되는 주차내의 ETA를 선택하기 위한 조건
        		if(parseInt(search_eta_end) < parseInt(main_eta_dt)){                 	    
        			ComShowMessage(ComGetMsg("EQR90144" ,sheetObj.GetCellValue(Row,"search_eta_start") ,sheetObj.GetCellValue(Row,"search_eta_end")));
        			sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
        			sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp1","",0);
        			sheetObj.SetCellValue(Row,"fm_ecc_cd","",0);
        			sheetObj.SetCellValue(Row,"fm_etd_dt","",0);
        			if(sheetObj.GetRowStatus(Row) == 'I'){
        				sheetObj.SetCellValue(Row,"check","0",0);
        			}
        		}
        	}
        
        	sheetObj.SetCellFontUnderline(Row, Col,1);
        	//sheetObj.SetCellFontColor(Row,Col,"#FF0000");
        	sheetObj.SetCellValue(Row ,"fm_ecc_cd_flg" ,"Y",0);
        	if(sheetObj.GetCellValue(Row ,"pln_yrwk") !="" && sheetObj.GetCellValue(Row , "land_cd") !="" && sheetObj.GetCellValue(Row ,"vvd") !="" ){
        		for(m=0 ; m <tpsz.length ; m++){
        			var tpszCol="sum_cntp_code"+tpsz[m].toLowerCase();
        			var tpszflg="sum_cntp_flg"+tpsz[m].toLowerCase();
        			var tpszqty="sum_cntp_qty"+tpsz[m].toLowerCase();
        			sheetObj.SetCellValue(Row , tpszCol,sheetObj.GetCellValue(Row , "land_cd")+sheetObj.GetCellValue(Row ,"vvd")+sheetObj.GetCellValue(Row,"fm_ecc_cd")+tpsz[m]+ sheetObj.GetCellValue(Row , "past_repo_pln_flg"));
        			sheetObj.SetCellValue(Row , tpszflg,'',0);
        			sheetObj.SetCellValue(Row , tpszqty,0 ,0);
        			// sheetObj.CellValue2(Row , tpsz[m]) = 0 ;
        		}
        		
        		var indexflg=0;
        		var index=sheetObj.GetCellValue(Row,"sum_cntp_code"+tpsz[0].toLowerCase());
        		for(m=1 ; m <= totalRow ; m++){
        			if (sheetObj.GetCellValue(m ,"sum_cntp_code"+tpsz[0].toLowerCase()) == index){
        				indexflg++;
        			}
        		}
        		
        		
        		// 똑같은 건이 한건 이상일 경우 , 수량 체크 메세지를 보여주거나 안보여주기 위해 값을 저장한다.
        		// sum_flg_code의 컬럼이 "" 이면 똑같은 값이 한개 이상이라는 뜻으로
        		// sum_flg_code의 컬럼이 'N' 이면 자기 것 밖에 없다는 뜻으로
        		// 현재날짜를 비교하여 과거이면 수량을 체크하고 미래이면 수량체크를 안하게 한다.
        		var start_etd_dt=replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(0,10),"-","")+ replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(11,19),":","");
        		var end_etd_dt=replaceAll(document.form.currentDay.value.substring(0,10),"/","")+ replaceAll(document.form.currentDay.value.substring(11,19),":","");
        		var currentDay=replaceAll(document.form.currentDay.value.substring(0,10),"/","");
        		var seachword=sheetObj.GetCellValue(Row,"vvd");
        		var repo_id=sheetObj.GetCellValue(2,"repo_pln_id");
        		var vsl_cd=seachword.substring(0,4);
        		var skd_voy_no=seachword.substring(4,seachword.length -1);
        		var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
        		var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
        		var colname="to_ecc_cd_tmp";
        		var vsl_loc_cd=sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
        		var fmToAt2=1;
        		var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
        		var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
        		var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
        		var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
        		var pln_yrwk1=sheetObj.GetCellValue(Row,"pln_yrwk");
        		var pln_yrwk_tmp=sheetObj.GetCellValue(Row,"fm_etd_dt"); // etd_dt날짜 기준으로 조회
        		var pln_yrwk=pln_yrwk_tmp.substr(0,10);
        		
        		sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
        		// var f_cmd = SEARCHLIST06;
        		// sheetObj.DoRowSearch("EES_EQR_0012GS4.do" ,"posCol=to&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&colname1=search_etd_start&colname2=search_etd_end&searchword="+ pln_yrwk1);
        		sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
        		sheetObj.SetCellValue(Row,"to_etb_dt","",0);
        		var typeflg="";
        		typeflg=sheetObj.GetRowStatus(Row);
        		if(indexflg > 1){
        			sheetObj.SetCellValue(Row , "sum_flg_code","",0);
        			if(sheetObj.GetCellValue(Row,"check") == "1"){
        				sheetObj.SetCellValue(Row,"check","0",0);// 체크버튼 비활성화
        				sheetObj.SetCellValue(Row,"check","1",0);// 체크버튼 활성화
        			}else {
        				sheetObj.SetCellValue(Row,"check","1",0);
        			}
        		}else {
        			sheetObj.SetCellValue(Row , "sum_flg_code",'N',0);
        		}
             	sheetObj.SelectCell(Row,'fm_etd_dt');
        	}
        
        	sheetObj.SetRowStatus(Row,typeflg);
        	if (sheetObj.GetCellValue(Row, 'past_repo_pln_flg') == '1') {
        		sheetObj.SetCellValue(Row , "sum_flg_code",'',0);
        	}else {
        		sheetObj.SetCellValue(Row , "sum_flg_code",'N',0);
        	}
        	sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",1);
        }
    
    
        //ETA, ETD COMBO(TO)
        if (sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){
        	var yard_cd="";
        	sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
    	
        	var to_ecc_cd=sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
        	var eccTmp = sheetObj.GetComboInfo(Row, "to_ecc_cd_tmp" , "Text");
        	var selIndex = sheetObj.GetComboInfo( Row , "to_ecc_cd_tmp" , "SelectedIndex");
    	
        	var eccTmpArr = eccTmp.split("|");
        	
        	var eccDefault = eccTmpArr[selIndex].replace(/\s/gi, ''); // 모든 공백을 제거;
        	
        	var ecc_cd=eccDefault.substring(0,5);
        	var dt=eccDefault.substring(5,15); //25);
        	var pod_use_flg=eccDefault.substring(30);
        	
        	//   var yard_cd="";
        	//   sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
     
        	//   var to_ecc_cd=sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
        	//    var ecc_cd=to_ecc_cd.substring(0,5);
        	//    var dt=to_ecc_cd.substring(6,25);
        	//var pod_use_flg=to_ecc_cd.substring(26,to_ecc_cd.length);
        	// Checking the pod_use_flg 
        	if (pod_use_flg == "FALSE"){
        		ComShowMessage(ComGetMsg("EQR70009" , ecc_cd));
        		sheetObj.SetCellValue(Row, "to_ecc_cd_tmp","",0);
        	}

        	//ecc_cd = eccDefault[0] +"_" + ecc_cd;
        	if (to_ecc_cd != "" && pod_use_flg != "FALSE"){
        		sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Text"});        		
        		sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
        		
        		sheetObj.SetCellValue(Row,"to_ecc_cd_tmp",trim(ecc_cd),0);
        		// sheetObj.CellValue2(Row,"to_ecc_cd_tmp1") = trim(ecc_cd);
        		sheetObj.SetCellValue(Row,"to_ecc_cd",trim(ecc_cd),0);
        		sheetObj.SetCellValue(Row,"to_etb_dt",dt,0);
        		if(sheetObj.GetCellValue(Row ,"past_repo_pln_flg") == '1'){ //fixed 일때만 to_yard에 반영이 되어야 함
        			sheetObj.SetCellValue(Row,"to_yard",yard_cd,0);
        		}
        		//sheetObj.SetCellValue(Row,"to_ecc_cd_tmp3",eccDefault.substring(0,3),0);
        		
        		//ETD, ETA Validate
        		var fm_etd_dt=replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(0,10),"-","")+replaceAll(sheetObj.GetCellValue(Row,"fm_etd_dt").substring(11,19),":","");
        		var to_etb_dt=replaceAll(sheetObj.GetCellValue(Row,"to_etb_dt").substring(0,10),"-","")+replaceAll(sheetObj.GetCellValue(Row,"to_etb_dt").substring(11,19),":","");
        		//if(parseInt(to_etb_dt)- parseInt(fm_etd_dt) < 0){
        		if(parseInt(to_etb_dt)- parseInt(fm_etd_dt) < 0){                       
                //("ETA 를  ETD 보다 크게 설정하세요.");
        			ComShowMessage(ComGetMsg("EQR90139"));
        			sheetObj.SetCellValue(Row, "to_ecc_cd","",0);
        			sheetObj.SetCellValue(Row, "to_ecc_cd_tmp","",0);
        			sheetObj.SetCellValue(Row, "to_etb_dt","",0);
        			//    sheetObj.SelectCell(Row, "to_ecc_cd_tmp")="";
        		}
        	}
        	// ----  20070706 FIX 관련 추가 ----
        	if(sheetObj.GetCellValue(Row,"past_repo_pln_flg") == '1' ){
        		var search_etd_start=sheetObj.GetCellValue(Row,"search_etd_start");
        		var search_etd_end=sheetObj.GetCellValue(Row,"search_etd_end");
        		var main_etd_dt=replaceAll(sheetObj.GetCellValue(Row,"to_etb_dt").substring(0,10),"-","");
        		//해당되는 주차내의 ETA를 선택하기 위한 조건
        		if(parseInt(search_etd_start) > parseInt(main_etd_dt)){
        			ComShowMessage(ComGetMsg("EQR90169" ,sheetObj.GetCellValue(Row,"search_etd_start") ,sheetObj.GetCellValue(Row,"search_etd_end")));
        			sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
        			sheetObj.SetCellValue(Row,"to_ecc_cd_tmp1","",0);
        			sheetObj.SetCellValue(Row,"to_ecc_cd","",0);
        			sheetObj.SetCellValue(Row,"to_etb_dt","",0);
        			sheetObj.SetCellValue(Row,"to_yard","",0);
        		}
        		//해당되는 주차내의 ETA를 선택하기 위한 조건
        		if(parseInt(search_etd_end) < parseInt(main_etd_dt)){
        			ComShowMessage(ComGetMsg("EQR90169" ,sheetObj.GetCellValue(Row,"search_etd_start") ,sheetObj.GetCellValue(Row,"search_etd_end")));
       		     	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
       		     	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp1","",0);
       		     	sheetObj.SetCellValue(Row,"to_ecc_cd","",0);
       		     	sheetObj.SetCellValue(Row,"to_etb_dt","",0);
       		     	sheetObj.SetCellValue(Row,"to_yard","",0);
        		}
        	}
        }
        
        
    //
        if (sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){
        	sheetObj.SetCellFontUnderline(Row, Col,1);
        	//sheetObj.SetCellFontColor(Row,Col,"#FF0000");
        	sheetObj.SetCellValue(Row ,"to_ecc_cd_flg" ,"Y",0);
        }
   
        //TYPE SIZE 별 수량구하고 그 수량을 비교하여 변경여부를 체크한다.
        //CSRNO : R200807097903 의거 수정
        for(i=0; i<consTpszArr.length; i++) {
        	var gubunTpsz=consTpszArr[i].toLowerCase();
        	if (sheetObj.GetCellValue(Row,consTpszArr[i].toLowerCase()) > 0 || sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp" || sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){
        	//if (sheetObj.GetCellValue(Row,consTpszArr[i].toLowerCase()) > 0){
        		sheetObj.SetCellFontUnderline(Row, Col,1);
        		//sheetObj.SetCellFontColor(Row,Col,"#FF0000");
        		sheetObj.SetCellValue(Row , consTpszArr[i].toLowerCase()+"_flag" ,"Y",0);
        		// 수량 체크를 위한 로직
        		var checktext=sheetObj.GetCellValue(Row,"sum_cntp_code"+ consTpszArr[i].toLowerCase());
        		var newsum=0;
        		var oldsum=0;
        		//실제로 변경된 수량을 다시 체크를 한다.
        		for(m=1 ; m <= totalRow ; m++){
        			if( checktext == sheetObj.GetCellValue(m,"sum_cntp_code"+consTpszArr[i].toLowerCase())){
        				//newsum=eval(newsum) + eval(sheetObj.GetCellValue( m ,consTpszArr[i].toLowerCase()));
        			}
        		} // for loop 끝 !!
        		
        		
        		oldsum=eval(sheetObj.GetCellValue(Row ,"sum_cntp_qty"+consTpszArr[i].toLowerCase()));  // 기존에 저장되어 있던 수량을 가져 온다.
        		var validatecheck=sheetObj.GetCellValue(Row , "sum_flg_code");
        		if(validatecheck != "N"){
        			if (oldsum < newsum){ // 기존 수량보다 새로 변경된 값이 크면
        				// VVD의 "+sheetObj.CellValue(Row,"vvd")+"와 POL "+sheetObj.CellValue(Row,"fm_ecc_cd")+"에 정해진 수량 ("+ oldsumd2 + ")보다 큽니다. 확인바랍니다.
        				//ComShowMessage(ComGetMsg("EQR90099" ,sheetObj.GetCellValue(Row,"vvd") ,sheetObj.GetCellValue(Row,"fm_ecc_cd") , oldsum));
        				sheetObj.SetCellValue(Row,"save_flg" + consTpszArr[i].toLowerCase(),'Y',0);// 변경된 값이 틀리다는것을 체크하여 둔다
        			}
        			
        			if (oldsum > newsum){ // 기존 수량보다 새로 변경된 값이 작으면
        				// VVD의 "+sheetObj.CellValue(Row,"vvd")+"와 POL "+sheetObj.CellValue(Row,"fm_ecc_cd")+"에 정해진 수량 ("+ oldsumd2 + ")보다 작습니다. 확인바랍니다
        				//ComShowMessage(ComGetMsg("EQR90100" ,sheetObj.GetCellValue(Row,"vvd") ,sheetObj.GetCellValue(Row,"fm_ecc_cd") , oldsum));
        				sheetObj.SetCellValue(Row,"save_flg" + consTpszArr[i].toLowerCase(),'Y',0);// 변경된 값이 틀리다는것을 체크하여 둔다
        			}
                  
        			if (oldsum == newsum){// 기존 수량보다 새로 변경된 값이 같으면
        				for(m=0 ; m <= totalRow ; m++){
        					if( checktext == sheetObj.GetCellValue(m,"sum_cntp_code"+ consTpszArr[i].toLowerCase())){
        						sheetObj.SetCellValue(m,"save_flg" + consTpszArr[i].toLowerCase(),'',0);// 수량 변경이 없다는 것을 체크한다.
                                // 수량이 변경이 없으면 다른 Row의 컬럼의 상태도 수량이 변경이 없다는것으로 체크를 돌려 놓는다.
                                	for(z=0; z<consTpszArr.length; z++ ) {
                                	   if(sheetObj.GetCellValue(m ,"save_flg"+consTpszArr[z].toLowerCase()) == '')  sheetObj.SetCellValue(m,"save_flg",'',0);
                                	}
                              	}
        					}
        				}
        		} else {
                      sheetObj.SetCellValue(Row,"save_flg" + consTpszArr[i].toLowerCase(),'',0);// 수량 변경이 없다는 것을 체크한다.
        		}
        	}  // if (sheetObj.ColSaveName(Col) == ""+gubunTpsz+"") 조건 끝 !!
        }  //for loop 끝 !!
        
        
        
        for(z=0; z<consTpszArr.length; z++ ) {
        	if(sheetObj.GetCellValue(Row ,"save_flg"+consTpszArr[z].toLowerCase()) != '')  sheetObj.SetCellValue(Row,"save_flg",'Y',0);
        }
        // PLN_YRWK가 변경시 체크 로직
        if (sheetObj.ColSaveName(Col) == "pln_yrwk"){
        	if (sheetObj.GetCellValue(Row ,"past_repo_pln_flg") == '1'){
        		sheetObj.SetCellValue(Row , "to_ecc_cd_tmp",'',0);
        		sheetObj.SetCellValue(Row , "to_etb_dt",'',0);
        		var pln_yrwk1=sheetObj.GetCellValue(Row,"pln_yrwk");
//            	var main_cmd = SEARCHLIST17;
//            	sheetObj.DoRowSearch("EES_WEEKDATEPERIOD.do" ,"row="+ Row +"&colname1=search_etd_start&colname2=search_etd_end&searchword="+ pln_yrwk1 + "&f_cmd=" + main_cmd ,false);
        	}else{
        		sheetObj.SetCellValue(Row , "land_cd",'',0);
        		sheetObj.InitCellProperty(Row,"vvd",{ Type:"Data"} );
        		sheetObj.SetCellValue(Row , "vvd",'',0);
        		sheetObj.SetCellEditable(Row,"vvd",1);
        		sheetObj.SetCellEditable(Row , "fm_ecc_cd_tmp",1);
        		sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Data"} );
        		sheetObj.SetCellValue(Row , "fm_ecc_cd_tmp",'',0);
        		sheetObj.SetCellValue(Row , "fm_etd_dt",'',0);
        		sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Data"} );
        		sheetObj.SetCellValue(Row , "to_ecc_cd_tmp",'',0);
        		sheetObj.SetCellValue(Row , "to_etb_dt",'',0);
        	}
        }
        // 중복체크 insert 시에 중복 체크
        // CSR NO : N200801070017 에 의거 변경
        // ==================================================================================
        if (sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){
        	if(sheetObj.GetCellValue(Row, 'pln_yrwk') != '' && sheetObj.GetCellValue(Row, 'land_cd') != ''
        		&& sheetObj.GetCellValue(Row, 'vvd') != '' && sheetObj.GetCellValue(Row, 'fm_ecc_cd_tmp') != '' && sheetObj.GetCellValue(Row, 'to_ecc_cd_tmp') != '' ){
        		// 중복 가능 여부를 알려주는 메세지
        		//  var index  =  sheetObj.ColValueDup('pln_yrwk|land_cd|vvd|fm_ecc_cd_tmp|fm_etd_dt|to_ecc_cd_tmp|to_etb_dt|past_repo_pln_flg');
        		var index=0;
        		var index0=sheetObj.GetCellValue(Row,"sum_cntp_code"+tpsz[0].toLowerCase()) + sheetObj.GetCellValue(Row,"to_ecc_cd") + sheetObj.GetCellValue(Row,"past_repo_pln_flg");
        		for(m=1 ; m <= totalRow ; m++){
        			if (sheetObj.GetCellValue(m ,"sum_cntp_code"+tpsz[0].toLowerCase()) + sheetObj.GetCellValue(m,"to_ecc_cd") + sheetObj.GetCellValue(m,"past_repo_pln_flg") == index0){
        				index++;
        			}
        		}
        		// 실제 DB에 값이 있는지 체크 한다.
        		var indexflg=0;
        		if(sheetObj.GetRowStatus(Row) == 'I' || sheetObj.GetCellValue(Row , 'to_ecc_cd_flg') == 'Y'){
//              	var main_cmd1= SEARCH07;
//                  sheetObj.DoRowSearch("EES_DUPLICATECHECKPOD.do" ,"row="+Row+"&colname=duplicate_check&pln_yrwk="+ sheetObj.CellValue(Row, 'pln_yrwk')+"&land_cd="+sheetObj.CellValue(Row,'land_cd')+"&vvd="+sheetObj.CellValue(Row, 'vvd')+"&fm_ecc_cd="+sheetObj.CellValue(Row,'fm_ecc_cd')+"&fm_etd_dt="+sheetObj.CellValue(Row, 'fm_etd_dt')+"&to_ecc_cd="+ sheetObj.Cellvalue(Row, 'to_ecc_cd')+"&to_etb_dt="+sheetObj.Cellvalue(Row, 'to_etb_dt')+"&repo_pln_id="+sheetObj.Cellvalue(Row , 'repo_pln_id')+"&f_cmd="+ main_cmd1);
        		}
        		var indexflg1=0;
        		var index1=sheetObj.GetCellValue(Row,"sum_cntp_code"+tpsz[0].toLowerCase()) + sheetObj.GetCellValue(Row,"to_ecc_cd") + sheetObj.GetCellValue(Row,"past_repo_pln_flg");
        		for(m=1 ; m <= totalRow ; m++){
        			if (sheetObj.GetCellValue(m ,"sum_cntp_code"+tpsz[0].toLowerCase()) + sheetObj.GetCellValue(m,"to_ecc_cd") + sheetObj.GetCellValue(m,"past_repo_pln_flg") == index1){
        				indexflg++;
        			}
        			if (sheetObj.GetCellValue(m ,'duplicate_check') == 'F'){
        				indexflg1++;
        			}
        		}
        		
        		if(index > 1){
        			//('Data Duplicate');
        			ComShowMessage(ComGetMsg("EQR90009"));
        			if (sheetObj.GetCellValue(Row ,"past_repo_pln_flg") == '1'){
        				sheetObj.SetCellValue(Row,'to_ecc_cd_tmp','',0);
        	            sheetObj.SetCellValue(Row,'to_etb_dt','',0);
        	            sheetObj.SetCellValue(Row,'duplicate_check','',0);
        	            sheetObj.SetCellValue(Row,'to_yard','',0);
        			}else {
        				//sheetObj.SetCellValue(Row,'pln_yrwk','',0);
        	            sheetObj.SetCellValue(Row,'land_cd','',0);
        	            sheetObj.InitCellProperty(Row,"vvd",{ Type:"Data"} );
        	            sheetObj.SetCellValue(Row,'vvd','',0);
        	            //sheetObj.SetCellEditable(Row,"vvd",0);        	            
        	            sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Data"} );
        	            sheetObj.SetCellValue(Row,'fm_ecc_cd_tmp','',0);
        	            sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",0);        	            
        	            sheetObj.SetCellValue(Row,'fm_etd_dt','',0);        	 
        	            sheetObj.SetCellEditable(Row,"fm_etd_dt",1);  
        	            sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Data"} );
        	            sheetObj.SetCellValue(Row,'to_ecc_cd_tmp','',0);
        	            sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",0);
        	            sheetObj.SetCellValue(Row,"to_etb_dt","",0);
        	            sheetObj.SetCellEditable(Row,"to_etb_dt",1);  
        	            sheetObj.SelectCell(Row,'pln_yrwk');
        	            sheetObj.SetCellValue(Row,'duplicate_check','',0);
        	            sheetObj.SetCellValue(Row,'to_yard','',0);
        			}
        		}else if(indexflg > 1){
    	            //('Data Duplicate');
	            	var checkValidate=ComShowConfirm(ComGetMsg("EQR90174",sheetObj.GetCellValue(Row ,'repo_pln_id')));
	            	if (checkValidate != 1){
	            		if (sheetObj.GetCellValue(Row ,"past_repo_pln_flg") == '1'){
	            			sheetObj.SetCellValue(Row,'to_ecc_cd_tmp','',0);
	            			sheetObj.SetCellValue(Row,'to_etb_dt','',0);
	            		}else {
	            			sheetObj.RowDelete(Row,false);
	            		}
	            	}
        		}else if (indexflg1 > 0 ) {
        			var checkValidate=ComShowConfirm(ComGetMsg("EQR90174",sheetObj.GetCellValue(Row ,'repo_pln_id')));
        			if (checkValidate != 1){
        				if (sheetObj.GetCellValue(Row ,"past_repo_pln_flg") == '1'){
        					sheetObj.SetCellValue(Row,'to_ecc_cd_tmp','',0);
        					sheetObj.SetCellValue(Row,'to_etb_dt','',0);
        				}else {
        					sheetObj.RowDelete(Row,false);
        				}
        			}
        		}
        	}
        }
        
        if(sheetObj.GetCellValue(Row,'vvd') == "" && sheetObj.GetCellValue(Row,'fm_ecc_cd_tmp') == "" && sheetObj.GetCellValue(Row,'fm_etd_dt') == "" && sheetObj.GetCellValue(Row,'to_ecc_cd_tmp') == "") {
    		sheetObj.SetCellValue(Row,"to_etb_dt","",0);
    	} 
	}
      
      
    // 조회후 소개 계산
//        function sheet2_OnSearchEnd(sheetObj, ErrMsg)
//        {
//    	    var sum1='';
//            var sum2='';
//            var sum3='';
//            var tpszperfix=comboObjects[0].GetSelectText();
//            var tpsz=tpszperfix.split(',');
//                 for(m=0 ; m <tpsz.length ; m++){
//                   sum1=sum1 +  "|"+"oldplan"+tpsz[m].toLowerCase();
//                }
//                 for(n=0 ; n <tpsz.length ; n++){
//                   sum2=sum2 +  "|"+"newplan"+tpsz[n].toLowerCase();
//                }
//                 for(l=0 ; l <tpsz.length ; l++){
//                   sum3=sum3 +  "|"+"diff"+tpsz[l].toLowerCase();
//                }
//            sheetObj.SetSumBackColor("#ECE7F7");
//            sheetObj.SetSumText( 0,1,"");
//            sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
//            sheetObj.ShowSubSum([{StdCol:"pln_yrwk", SumCols:"oldplantotal"+sum1+"|newplantotal"+sum2+"|difftotal"+sum3, Sort:false, ShowCumulate:false, CaptionCol:1, CaptionText:"0=%s;1=%s;2=SubTTL"}]);
//            var inSumIdx=sheetObj.FindText("pln_yrwk", "Sub TTL");
//            //var inSumIdx  = findText("pln_yrwk", "Sub TTL");
//           // sheetObj.CellAlign( "Sub TTL" , inSumIdx ) = daCenter;
//            sheetObj.SetCellAlign( inSumIdx , "Sub TTL" ,"Center");
//            //bntImgEnable(document.form.btn_save, false);
//            ComBtnDisable("btn_save");
//            ComBtnDisable("btn_confirm");
//        }
//    // 조회후 소개 계산
//        function sheet3_OnSearchEnd(sheetObj, ErrMsg)
//        {
//            var sum1='';
//            var sum2='';
//            var sum3='';
//            var tpszperfix=comboObjects[0].GetSelectText();
//            var tpsz=tpszperfix.split(',');
//                 for(m=0 ; m <tpsz.length ; m++){
//                   sum1=sum1 +  "|"+"oldplan"+tpsz[m].toLowerCase();
//                }
//                 for(n=0 ; n <tpsz.length ; n++){
//                   sum2=sum2 +  "|"+"newplan"+tpsz[n].toLowerCase();
//                }
//                 for(l=0 ; l <tpsz.length ; l++){
//                   sum3=sum3 +  "|"+"diff"+tpsz[l].toLowerCase();
//                }
//            sheetObj.SetSumBackColor("#ECE7F7");
//            sheetObj.SetSumText( 0,1,"");
//            sheetObj.SetSumText( 0,"pln_yrwk","Grand TTL");
//            sheetObj.ShowSubSum([{StdCol:"pln_yrwk", SumCols:"oldplantotal"+sum1+"|newplantotal"+sum2+"|difftotal"+sum3, Sort:true, ShowCumulate:false, CaptionCol:1, CaptionText:"0=%s;1=%s;2=SubTTL"}]);
//            var inSumIdx=sheetObj.findText("pln_yrwk", "Sub TTL");
//            sheetObj.SetCellAlign( inSumIdx , "Sub TTL" ,"Center");
//            // bntImgEnable(document.form.btn_save, false);
//            ComBtnDisable("btn_save");
//            ComBtnDisable("btn_confirm");
//        }
//    // 수치 바꾼후에 소개 계산
//        function sheet3_OnChange(sheetObj , Row, Col, Val)
//        {
//        }
        /**
         * IBTab Object를 배열로 등록
         * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
         * 배열은 소스 상단에 정의
         */
//        function setTabObject(tab_obj){
//            tabObjects[tabCnt++]=tab_obj;
//        }
        /**
         * Tab 기본 설정
         * 탭의 항목을 설정한다.
         */
//        function initTab(tabObj , tabNo) {
//             switch(tabNo) {
//                 case 1:
//                    with (tabObj) {
//                        var cnt=0 ;
////						InsertItem( "COD Simulation" , "");
////						InsertItem( "Analysis by POL" , "");
////						InsertItem( "Analysis by POD" , "");
////                        InsertItem( tabName[0], "");
////                        InsertItem( tabName[1], "");
////                        InsertItem( tabName[2], "");
//                    }
//                 break;
//             }
//        }
        /**
         * Tab 클릭시 이벤트 관련
         * 선택한 탭의 요소가 활성화 된다.
         */
//        function tab1_OnChange(tabObj , nItem) {
//            var tabObject=tabObjects[0];
//            var curTabIndex=tabObject.GetSelectedIndex();
//            var objs=document.all.item("tabLayer");
//            var sheetObject=sheetObjects[0];
//            var sheetObject1=sheetObjects[1];
//            var sheetObject2=sheetObjects[2];
//        	objs[nItem].style.display="Inline";
//        	objs[beforetab].style.display="none";
//        	if (curTabIndex == 1){ // 두번째 탭에서 초기값을 셋팅
//        	  goSearchRepoid();
//        	}
//          if (curTabIndex == 2){
//          //sheetObject2.RemoveAll();
//        	}
//        	//--------------- 요기가 중요 --------------------------//
//        	objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
//        	//------------------------------------------------------//
//        	beforetab=nItem;
//      		//bntImgEnable(document.form.btn_save, true);
//      		ComBtnEnable("btn_save");
//      		ComBtnEnable("btn_confirm");
//        }
       /**
         * 화면 폼입력값에 대한 유효성검증 프로세스 처리
         */
        function validateForm(sheetObj,formObj,sAction){
//            var tabObject=tabObjects[0];
//            var curTabIndex=tabObject.GetSelectedIndex();
          //  var repo_pln_id1 = new Array(comboObjects[1].Text);
             with(formObj){
                  if(!chkPlanId(formObj, 'yyyyww', 'seq')){
                   return  false;
                   }
                 if(!checkLocItem(formObj, 'fmType', 'fmEccCd')) {
                    return false;
                   }
                 if(!checkLocItem(formObj, 'toType', 'toEccCd')) {
                    return false;
                   }
                 if(!checkTpszCombo(0)) { //괄호안의 0 은 comboObject Index 를 나타낸다
                    return false;
                   }
         }
           return true;
    }
        
        
    function goSearchRepoid(Type){
        var formObject=document.form;
        var result="";
        if(formObject.yyyyww.value.length != '6'){
            //("Plan ID 를 입력하세요");
            //ComShowMessage(ComGetMsg("EQR90001","Repoplan ID"));
        	
  			if(Type != "Loading") {
  				ComShowCodeMessage("EQR70011");
  			}
            ComSetFocus(formObject.yyyyww);
            ComOpenWait(false);
            return false;
        }
        
        if(formObject.seq.value.length == 4){     
            ComOpenWait(true);
            doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
        }else{
        	if(formObject.seq.value.length > 0 && formObject.seq.value.length < 4){
        		ComShowCodeMessage("EQR70011");
                formObject.seq.value ="";
                formObject.repo_rmk.value = "";
                ComSetFocus(formObject.seq);
        	}else if(formObject.seq.value.length == 0) {
	 			formObject.repo_rmk.value = "";
                //ComSetFocus(formObject.seq);
	 		}
        }
        
    }
    
    
    function ibSearchAsync03(){
        var formObject=document.form;
        if(formObject.status_type.value == "" || formObject.status_type.value == "null"){
        	
        	var stryyyyww = document.form.yyyyww.value;
        	var strseq = document.form.seq.value;
        	formObject.reset();
            
    	  	document.form.yyyyww.value = stryyyyww;
    	  	document.form.seq.value = strseq;
    	  	
        	ComBtnEnable("btn_create");
			ComBtnDisable("btn_delete");
			
			ComShowCodeMessage("EQR01149");
			
			comboObjects[0].SetSelectCode(consTpsz);
            tpszChange(''); // ALL 선택
            sheetObjects[0].RemoveAll();
            ComBtnDisable("t1btng_rowadd");
            ComBtnDisable("t1btng_rowdelete");
			ComOpenWait(false); 
        }
    }
    
    
    function search01(){
        var formObject=document.form;
        doActionIBSheet(sheetObjects[0], formObject, SEARCH01);
    }
    
    
    function setEccCommon(){
         var formObject=document.form;
         if(formObject.max_plnYr.value != "") {
	         formObject.fmPlnYr.value=formObject.st_year.value;
	         formObject.fmPlnWk.value=formObject.st_weekly.value;
	       //  formObject.toPlnYr.value = formObject.end_year.value;
	         formObject.toPlnYr.value=formObject.max_plnYr.value;
	         formObject.toPlnWk.value=formObject.max_weekly.value;
	          //to LOC
	         formObject.fmToPlnYr.value=formObject.st_year.value;
	         formObject.fmToPlnWk.value=formObject.st_weekly.value;
	       //  formObject.toToPlnYr.value = formObject.end_year.value;
	         formObject.toToPlnYr.value=formObject.max_plnYr.value;
	         formObject.toToPlnWk.value=formObject.max_weekly.value;
	      //   comboObjects[1].RemoveAll();
	      //   initCombo (comboObjects[1], 2); // Mutil combo를 셋팅한다.
	           doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         }
      }
    
    
      function displayType()
       {
    		 with(document.form)
    		 {
    			   if(fmType.value == '') {
    			      fmEccCd.disabled=true;
    			      fmEccCd.value='';
    			   }else{
    			      fmEccCd.disabled=false;
    			   }
    			   if(toType.value == '') {
    			      toEccCd.disabled=true;
    			      toEccCd.value='';
    			   }else{
    			      toEccCd.disabled=false;
    			   }
    		 }
    	 }
      
      
    	// 멀티 콤보박스 선택셋팅
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
                /*case "D":
                	comboObjects[0].SetSelectCode(consTpszDry);
                	//cntrTpszCd.SetSelectCode("D2,D4");
                	break;
                case "R":
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
    	
//      function TitleMake1(TitleCount){
//        var title1_temp="";
//        var title2_temp="";
//        var title3_temp="";
//        var formObject=document.form;
//        var repo_plan_id="BEFORE";
//        var repo_plan_id_title="AFTER";
//        var title_id="Difference";
//            num=TitleCount.split(',');
//              for(var i=0; i <num.length +1 ; i++) {
//                  title1_temp=title1_temp + repo_plan_id+"|";
//              }
//              for(var j=0; j <num.length +1 ; j++){
//                  title2_temp=title2_temp + repo_plan_id_title+"|";
//              }
//              for(var k=0; k < num.length +1 ; k++){
//                  title3_temp=title3_temp + title_id+"|";
//              }
//              title3_temp=title3_temp.substring(0,title3_temp.length-1);
//        return title1_temp + title2_temp + title3_temp;
//     }
      
     function TitleMake2(TitleCount){
      var title1_temp="";
      num=TitleCount.split(',');
          // 반복적으로 포함되는 문구를 선언한다.
        for(var i=0; i < num.length ; i++) {
            title1_temp=title1_temp + num[i]+"|";
            }
            title1_temp=title1_temp.substring(0,title1_temp.length-1);
       return title1_temp;
     }
     
     // 이미 입력되어 있는 PLAN의 POL 이나 POD를 변경하기 위해서  작동을 한다.
     function sheet1_OnKeyUp( sheetObj, Row, Col,KeyCode, shift) {
    	 if (sheetObj.GetRowStatus(Row) =='U') {
    		var searchword="";
    		var formObject=document.form;
    		if (( KeyCode == "9" || KeyCode =="229") && sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp"){
    			if (sheetObj.GetCellValue(Row ,"past_repo_pln_flg") != '1'){ // FIX ROW를 선택했을경우에는 FM_ECC_CD가 조회가 되면 안된다.
    				var seachword=sheetObj.GetCellValue(Row,"vvd");
    				var repo_id=sheetObj.GetCellValue(2,"repo_pln_id");
    				var vsl_cd=seachword.substring(0,4);
    				var skd_voy_no=seachword.substring(4,seachword.length -1);
    				var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
    				var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
    				var colname=sheetObj.ColSaveName(Col);
    				var vsl_loc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
    				var fmToAt2=1;
    				var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
    				var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    				var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    				//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
    				var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
    				var main_cmd=SEARCHLIST17;
    				sheetObj.DoRowSearch("EES_WEEKDATEPERIOD.do" ,"row="+ Row +"&colname1=search_eta_start&colname2=search_eta_end&searchword="+ pln_yrwk + "&f_cmd=" + main_cmd);
//                    sheetObj.DoRowSearch( ROW,row=Row&colname1=search_eta_start&colname2=search_eta_end&searchword=pln_yrwk&f_cmd=main_cmd );                   
                    
    				var f_cmd=SEARCHLIST06;
    				sheetObj.DoRowSearch("EES_EQR_0012GS4.do" ,"posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd+"&vsl_loc_cd=" + vsl_loc_cd);
//                    sheetObj.DoRowSearch( ROW,posCol=fm&fmToAt2=fmToAt2&atFmPlnYrWk_2=pln_yrwk&atToPlnYrWk_2=atToPlnYrWk_2&fmFmPlnYrWk_2=pln_yrwk&fmToPlnYrWk_2=fmToPlnYrWk_2&toFmPlnYrWk_2=pln_yrwk&toToPlnYrWk_2=toToPlnYrWk_2&row=Row&repo_id=repo_id&vsl_cd=vsl_cd&skd_voy_no=skd_voy_no&skd_dir_cd=skd_dir_cd&vsl_lane_cd=vsl_lane_cd&col=colname&f_cmd=f_cmd&vsl_loc_cd=vsl_loc_cd );

    		        var chkData=sheetObj.GetCellValue(Row, colname);
    		        if (chkData != "" ) { 
                        sheetObj.SetCellValue(Row,colname,0) = "";
    		        } else {
    		            sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
    		            sheetObj.SetCellValue(Row,colname,0) = "";
    		        } 
    			}
        	}
    		if (( KeyCode == "9" || KeyCode =="229") && sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){
    			var seachword=sheetObj.GetCellValue(Row,"vvd");
    			var repo_id=sheetObj.GetCellValue(2,"repo_pln_id");
    				var vsl_cd=seachword.substring(0,4);
    				var skd_voy_no=seachword.substring(4,seachword.length -1);
    				var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
    				var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
    				var colname=sheetObj.ColSaveName(Col);
    				//var vsl_loc_cd = sheetObj.CellValue(Row,"to_ecc_cd_tmp");
    				var vsl_loc_cd="";
    				var fmToAt2=1;
    				var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
    				var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    				var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
    				//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
    				// var pln_yrwk = sheetObj.CellValue(Row,"pln_yrwk");
    				var pln_yrwk1=sheetObj.GetCellValue(Row,"pln_yrwk");
    				var main_cmd=SEARCHLIST17;
    				sheetObj.DoRowSearch("EES_WEEKDATEPERIOD.do" ,"row="+ Row +"&colname1=search_etd_start&colname2=search_etd_end&searchword="+ pln_yrwk1 + "&f_cmd=" + main_cmd ,false);
    				var pln_yrwk_tmp=sheetObj.GetCellValue(Row,"fm_etd_dt"); // etd_dt날짜 기준으로 조회
    				var pln_yrwk=pln_yrwk_tmp.substr(0,10);
//               	var f_cmd = SEARCHLIST06;
//               	sheetObj.DoRowSearch("EES_EQR_0012GS4.do" ,"posCol=to&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);
    				
    				//sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
    				
    				var f_cmd=SEARCHLIST06;
    				sheetObj.DoRowSearch("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=to&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&colname1=search_etd_start&colname2=search_etd_end&searchword="+ pln_yrwk1 ,false);
    				//sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
    				
    		        var chkData=sheetObj.GetCellValue(Row, colname);
    		        if (chkData != "" ) { 
    		            sheetObj.SetCellValue(Row,colname,0) = "";
    		        } else {
    		            sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
    		            sheetObj.SetCellValue(Row,colname,0) = "";
    		        } 
    		              				
           	}
    	 }
      }

      // 신규프로젝트 No: S2Q-09P-004
      // VVD 클릭시 VVD값을 가지고 있다가 Bayplan Button을 클릭시 자동 조회되도록
	function sheet1_OnClick(sheetObj ,Row, Col){
		var formObject=document.form;
		click_vvd=sheetObj.GetCellValue(Row,6);		
		var CellPro = sheetObj.GetCellProperty(Row, "fm_ecc_cd_tmp", "Type");
		if (sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp"){   
			if(sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp2") == "" || CellPro =="Text" ) {
				if(sheetObj.GetCellEditable(Row, Col) == "1") {
					sheet1_OnDblClick(sheetObj ,Row, Col);
					/*var seachword=sheetObj.GetCellValue(Row,"vvd");
					var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
					var vsl_cd=seachword.substring(0,4);
					var skd_voy_no=seachword.substring(4,seachword.length -1);
					var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
	
					sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",1);
					sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Combo"});
					sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
					sheetObj.SetCellValue(Row,"fm_etd_dt","",0);
	
					
					//sheetObj.SetCellEditable(Row,"land_cd",0);
					//sheetObj.SetCellValue(Row,"land_cd","",0);  
	
					
					sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
					sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
					
					sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
					sheetObj.SetCellValue(Row,"to_etb_dt","",0);
	
	
					// hidden Column???곗씠?곕? ?뗮똿 ?쒕떎.
					//sheetObj.SetCellValue(Row,"vsl_cd",vsl_cd,0);
					//sheetObj.SetCellValue(Row,"skd_dir_cd",skd_dir_cd,0);
					//sheetObj.SetCellValue(Row,"skd_voy_no",skd_voy_no,0);
					//sheetObj.SetCellValue(Row,"repo_pln_id",repo_id,0);
	
					click_vvd=seachword;
					var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
					var colname="fm_ecc_cd_tmp";
					var colname11="to_ecc_cd_tmp";
					var colname12="land_cd";
	
					var vsl_loc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
					var fmToAt2=1;
					var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
					var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
					var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
					 //議고쉶二쇱감??from 媛믪씠 ?꾨땶 insert ?섎뒗 pln_yrwk 媛믪쓣 媛?졇媛꾨떎.
					var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
					  
					// added by ui opus
					var f_cmd = SEARCHLIST06;
					//if(sheetObj.GetCellValue(Row,"to_ecc_cd_tmp2") == "") {
						sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);          		
		
		//				                  var chkData=sheetObj.GetCellValue(Row, colname);
						var chkData=sheetObj.GetComboInfo(Row, colname, "Text")
						if (chkData != "" ) { 
							sheetObj.SetCellValue(Row,colname,"",0);
						} else {
							sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
							sheetObj.SetCellValue(Row,colname,"",0);
						}
					
						// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
						sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);
						var chkData=sheetObj.GetCellValue(Row, colname11);
		
						if (chkData != "" ) { 
							sheetObj.SetCellValue(Row,colname11,"",0);
						} else {
							sheetObj.InitCellProperty(Row,colname11,{ Type:"Data"});
							sheetObj.SetCellValue(Row,colname11,"",0);
						}
					//}
	*/				
					sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp2","Y",0);
				}
			}
		}
		
		var CellPro = sheetObj.GetCellProperty(Row, "to_ecc_cd_tmp", "Type");
		if (sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp"){   
			if(sheetObj.GetCellValue(Row,"to_ecc_cd_tmp2") == "" || CellPro =="Text" ) {
				if(sheetObj.GetCellEditable(Row, Col) == "1") {
					//sheet1_OnDblClick(sheetObj ,Row, Col);
					var strfm_ecc_cd_tmp = sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
					var strfm_etd_dt = sheetObj.GetCellValue(Row,"fm_etd_dt");
					var strto_ecc_cd_tmp = sheetObj.GetCellValue(Row,"to_ecc_cd_tmp3")+sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
					
					var strto_etb_dt = sheetObj.GetCellValue(Row,"to_etb_dt");
					if(sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp2") == "") {
						var seachword=sheetObj.GetCellValue(Row,"vvd");
						var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
						var vsl_cd=seachword.substring(0,4);
						var skd_voy_no=seachword.substring(4,seachword.length -1);
						var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
						
						
						sheetObj.SetCellEditable(Row,"land_cd",0);
						sheetObj.SetCellValue(Row,"land_cd","",0);  
		
						sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
						sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
						sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
						sheetObj.SetCellValue(Row,"to_etb_dt","",0);
						
						if (sheetObj.GetRowStatus(Row) != 'U'){
							sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",1);
							sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Combo"});
			
							sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
							sheetObj.SetCellValue(Row,"fm_etd_dt","",0);
						}else{
							sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",0);
							sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Text"});
			
							sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
						}
						
		
						// hidden Column
						sheetObj.SetCellValue(Row,"vsl_cd",vsl_cd,0);
						sheetObj.SetCellValue(Row,"skd_dir_cd",skd_dir_cd,0);
						sheetObj.SetCellValue(Row,"skd_voy_no",skd_voy_no,0);
						sheetObj.SetCellValue(Row,"repo_pln_id",repo_id,0);
		
						click_vvd=seachword;
						var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
						var colname="fm_ecc_cd_tmp";
						var colname11="to_ecc_cd_tmp";
						var colname12="land_cd";
		
						var vsl_loc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
						var fmToAt2=1;
						var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
						var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
						var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
						//
						var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
						 
						// added by ui opus
						var f_cmd = SEARCHLIST06;
						
						if (sheetObj.GetRowStatus(Row) != 'U'){
							sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);          		
			
							var chkData=sheetObj.GetComboInfo(Row, colname, "Text")
							if (chkData != "" ) { 
								//sheetObj.SetCellValue(Row,colname,"",0);
								sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp",strfm_ecc_cd_tmp,0);
								sheetObj.SetCellValue(Row,"fm_etd_dt",strfm_etd_dt,0);
							} else {
								sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
								sheetObj.SetCellValue(Row,colname,"",0);
							}
						}else{
							sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp",strfm_ecc_cd_tmp,0);
						}
					
						var strFromDate = sheetObj.GetCellValue(Row,"fm_etd_dt");
						// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
						
						sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&fm_etd_date="+strFromDate);
						var chkData=sheetObj.GetCellValue(Row, colname11);
		
						if (chkData != "" ) { 
							sheetObj.SetCellValue(Row,colname11,"",0);
						} else {
							sheetObj.InitCellProperty(Row,colname11,{ Type:"Data"});
							//sheetObj.SetCellValue(Row,colname11,"",0);
							sheetObj.SetCellValue(Row,"to_ecc_cd_tmp",strto_ecc_cd_tmp,0);
							if (sheetObj.GetRowStatus(Row) == 'U'){
								if(sheetObj.GetCellValue(Row,"to_ecc_cd_tmp") == "") {
									sheetObj.SetCellValue(Row,"to_etb_dt","",0);
								}else{
									sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
								}
								
							}else{
								sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
							}
							
						}
						// VVD
						var f_cmd = SEARCHLIST07;
						var sXml = sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname12 + "&f_cmd=" + f_cmd);          
						changeViewText(sheetObj, sXml, colname12);
					}else{
						var seachword=sheetObj.GetCellValue(Row,"vvd");
			        	var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
			        	var vsl_cd=seachword.substring(0,4);
			        	var skd_voy_no=seachword.substring(4,seachword.length -1);
			        	var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);

			        	var strto_ecc_cd_tmp = sheetObj.GetCellValue(Row,"to_ecc_cd_tmp3")+sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
						var strto_etb_dt = sheetObj.GetCellValue(Row,"to_etb_dt");
			        	sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
			        	sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
			        	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
			        	sheetObj.SetCellValue(Row,"to_etb_dt","",0);
			          
			          
			        	click_vvd=seachword;

			        	var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd",0);
			        	var colname   = "fm_ecc_cd_tmp";
			        	var colname11 = "to_ecc_cd_tmp";
			        	var colname12 = "land_cd";
			                    
			        	var vsl_loc_cd="";
			        	var fmToAt2=1;
			        	var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
			        	var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
			        	var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
			        	//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
			        	var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");

			        	// added by ui opus
			        	var f_cmd = SEARCHLIST06;
			        	
			        	// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
			        	var strFromDate = sheetObj.GetCellValue(Row,"fm_etd_dt");
			        	sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&fm_etd_date="+strFromDate);
			        	
		        		sheetObj.SetCellValue(Row,"to_ecc_cd_tmp",strto_ecc_cd_tmp,0);
						sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
				        	
					}
					
					sheetObj.SetCellValue(Row,"to_ecc_cd_tmp2","Y",0);
				}
				
				sheetObj.SelectCell(Row,"to_ecc_cd_tmp",true);
			}else{
				var seachword=sheetObj.GetCellValue(Row,"vvd");
	        	var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
	        	var vsl_cd=seachword.substring(0,4);
	        	var skd_voy_no=seachword.substring(4,seachword.length -1);
	        	var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);

	        	var strto_ecc_cd_tmp = sheetObj.GetCellValue(Row,"to_ecc_cd_tmp3")+sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
				var strto_etb_dt = sheetObj.GetCellValue(Row,"to_etb_dt");
	        	sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
	        	sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
	        	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
	        	sheetObj.SetCellValue(Row,"to_etb_dt","",0);
	          
	          
	        	click_vvd=seachword;

	        	
				var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd",0);
	        	var colname   = "fm_ecc_cd_tmp";
	        	var colname11 = "to_ecc_cd_tmp";
	        	var colname12 = "land_cd";
	                    
	        	var vsl_loc_cd="";
	        	var fmToAt2=1;
	        	var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
	        	var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
	        	var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
	        	//조회주차의 from 값이 아닌 insert 하는 pln_yrwk 값을 가져간다.
	        	var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");

	        	sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
	        	sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
	        	sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
	        	sheetObj.SetCellValue(Row,"to_etb_dt","",0);
	        	
	        	// added by ui opus
	        	var f_cmd = SEARCHLIST06;
	        	
	        	// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
	        	var strFromDate = sheetObj.GetCellValue(Row,"fm_etd_dt");
	        	sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd+"&fm_etd_date="+strFromDate);
	        	
	        	sheetObj.SelectCell(Row,"to_ecc_cd_tmp",true);
				
			}
		}
	}
	      
	function sheet1_OnAfterEdit(sheetObj, Row, Col) {
		if (sheetObj.ColSaveName(Col) == "to_ecc_cd_tmp" || sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp"){   
			if(sheetObj.GetCellValue(Row,Col).length > 5) {
				var strData = sheetObj.GetCellValue(Row,Col);
				sheetObj.SetCellValue(Row,Col,strData.substr(3,8),0);
				var Val = "";
				sheet1_OnChange(sheetObj , Row, Col, Val)
			}
		}
	}
	
	
      // 신규프로젝트 No: S2Q-09P-004
      // VVD 더블클릭시 BayPlan POPUP 호출
	function sheet1_OnDblClick(sheetObj ,Row, Col){
		var formObject=document.form;
		if(sheetObj.GetCellValue(Row, "confirm_flg") != 'Y'){
			if (sheetObj.ColSaveName(Col) == "vvd"){
				sheetObj.SetCellEditable(Row,"vvd",1);
			}
    		 
			
			if (sheetObj.ColSaveName(Col) == "fm_ecc_cd_tmp"){   
				var seachword=sheetObj.GetCellValue(Row,"vvd");
				var repo_id="REPO" +document.form.yyyyww.value + "W" +document.form.seq.value;
				var vsl_cd=seachword.substring(0,4);
				var skd_voy_no=seachword.substring(4,seachword.length -1);
				var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);
				
				var CellProText = sheetObj.GetCellProperty(Row, "to_ecc_cd_tmp", "Type");
				var to_ecc_cdText = sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
				
				var strfm_ecc_cd_tmp = sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp3")+sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
				var strfm_etd_dt = sheetObj.GetCellValue(Row,"fm_etd_dt");
				var strto_ecc_cd_tmp = sheetObj.GetCellValue(Row,"to_ecc_cd_tmp3")+sheetObj.GetCellValue(Row,"to_ecc_cd_tmp");
				var strto_etb_dt = sheetObj.GetCellValue(Row,"to_etb_dt");
				
				sheetObj.SetCellEditable(Row,"fm_ecc_cd_tmp",1);
				sheetObj.InitCellProperty(Row,"fm_ecc_cd_tmp",{ Type:"Combo"});
				
				sheetObj.SetCellValue(Row,"fm_ecc_cd_tmp","",0);
				sheetObj.SetCellValue(Row,"fm_etd_dt","",0);

				sheetObj.SetCellEditable(Row,"land_cd",0);
				sheetObj.SetCellValue(Row,"land_cd","",0);  
				
				if(to_ecc_cdText.length == 5) {
					sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
					sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Text"});
				}else{
					sheetObj.SetCellEditable(Row,"to_ecc_cd_tmp",1);
					sheetObj.InitCellProperty(Row,"to_ecc_cd_tmp",{ Type:"Combo"});
				}
				
				sheetObj.SetCellValue(Row,"to_ecc_cd_tmp","",0);
				sheetObj.SetCellValue(Row,"to_etb_dt","",0);

				sheetObj.SetCellValue(Row,"vsl_cd",vsl_cd,0);
				sheetObj.SetCellValue(Row,"skd_dir_cd",skd_dir_cd,0);
				sheetObj.SetCellValue(Row,"skd_voy_no",skd_voy_no,0);
				sheetObj.SetCellValue(Row,"repo_pln_id",repo_id,0);
				click_vvd=seachword;
				var vsl_lane_cd=sheetObj.GetCellValue(Row,"land_cd");
				var colname="fm_ecc_cd_tmp";
				var colname11="to_ecc_cd_tmp";
				var colname12="land_cd";

				var vsl_loc_cd=sheetObj.GetCellValue(Row,"fm_ecc_cd_tmp");
				var fmToAt2=1;
				var fmToPlnYrWk_2=formObject.toPlnYr.value +    formObject.toPlnWk.value ;
				var toToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
				var atToPlnYrWk_2=formObject.toToPlnYr.value +   formObject.toToPlnWk.value ;
				var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
				  
				// added by ui opus
				var f_cmd = SEARCHLIST06;
				sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);          		
				var chkData=sheetObj.GetComboInfo(Row, colname, "Text")
				if (chkData != "" ) { 
					sheetObj.SetCellValue(Row,colname,strfm_ecc_cd_tmp,0);
					sheetObj.SetCellValue(Row,"fm_etd_dt",strfm_etd_dt,0);
				} else {
					sheetObj.InitCellProperty(Row,colname,{ Type:"Data"});
					sheetObj.SetCellValue(Row,colname,"",0);
				}

				// VVD입력 시 From PoL과 동일한 정보의 콤보를 생성해준다.
				if(to_ecc_cdText.length != 5) {
					sheetObj.DoRowSearch2("EES_EQR_0012GS4.do" ,"view_sc=0012&posCol=fm&fmToAt2=" + fmToAt2 +"&atFmPlnYrWk_2=" + pln_yrwk+"&atToPlnYrWk_2=" + atToPlnYrWk_2+"&fmFmPlnYrWk_2=" + pln_yrwk +"&fmToPlnYrWk_2=" + fmToPlnYrWk_2 +"&toFmPlnYrWk_2=" + pln_yrwk +"&toToPlnYrWk_2=" + toToPlnYrWk_2+"&row=" + Row +"&repo_id=" + repo_id+"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd+"&vsl_lane_cd=" + vsl_lane_cd + "&col=" + colname11 + "&f_cmd=" + f_cmd +"&vsl_loc_cd=" + vsl_loc_cd);
					var chkData=sheetObj.GetCellValue(Row, colname11);
					if (chkData != "" ) { 
						//sheetObj.SetCellValue(Row,colname11,"",0);
						sheetObj.SetCellValue(Row,colname11,strto_ecc_cd_tmp,0);
						sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
					} else {
						sheetObj.InitCellProperty(Row,colname11,{ Type:"Data"});
						//sheetObj.SetCellValue(Row,colname11,"",0);
						sheetObj.SetCellValue(Row,colname11,strto_ecc_cd_tmp,0);
						sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
					}
				}else{
					sheetObj.SetCellValue(Row,colname11,to_ecc_cdText,0);
					sheetObj.SetCellValue(Row,"to_etb_dt",strto_etb_dt,0);
				}

				// VVD?낅젰 ???대떦 Lane ?곗씠?곕? ?낅젰?댁???
				var f_cmd = SEARCHLIST07;
				var sXml = sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname12 + "&f_cmd=" + f_cmd);          
				changeViewText(sheetObj, sXml, colname12);
				
				sheetObj.SelectCell(Row,"fm_ecc_cd_tmp",true);
			}
			
		}else{
			var totalRow=sheetObj.RowCount();
        	sheetObj.SetCellEditable(Row ,"pln_yrwk",0);
        	sheetObj.SetCellEditable(Row ,"land_cd",0);
        	sheetObj.SetCellEditable(Row ,"vvd",0);
        	sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",0);
        	sheetObj.SetCellEditable(Row ,"fm_etd_dt",0);
        	sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",0);
        	sheetObj.SetCellEditable(Row ,"to_etb_dt",0);
        	sheetObj.SetCellEditable(Row ,"fm_ecc_cd_tmp",0);
        	sheetObj.SetCellEditable(Row ,"fm_etd_dt",0);
        	sheetObj.SetCellEditable(Row ,"to_ecc_cd_tmp",0);
        	sheetObj.SetCellEditable(Row ,"to_etb_dt",0);
        	for(n=0; n<consTpszArr.length; n++) {
        		sheetObj.SetCellEditable(Row ,consTpszArr[n].toLowerCase(),0);
        	}
		}
	}

      
      
	  // 신규프로젝트 CSRNO : CHM-201003779
	  // EQR VL-VD 전주차 접근권한 유저 신규메뉴 생성관련 버튼 활성화 여부체크
	function goCheckEqrAccess() {
		document.form.f_cmd.value=SEARCH11;
		/** 단순히 ETCData만 가져오기 위해서는 DoSearch가 아닌 GetSearchData호출하여 ETCData를 취득하도록 한다. **/
		var sXml=sheetObjects[0].GetSearchData("EES_CHECK_EQR_ACCESS.do", eqrFormQryStr(document.form));
		var ofcCd=ComGetEtcData(sXml,"ofcCd");
	}
      
      /**
    	 * handling in case of clicking image button on sheet1
    	 * @param sheetObj
    	 * @param Row
    	 * @param Col
    	 * @return
    	 */
	function sheet1_OnPopupClick(sheetObj, Row,Col){
		var formObject = document.form;
		with(sheetObj) {
			var sName = ColSaveName(Col);
			switch (sName) {
				case "vvd":
    				//alert(sheetObj.CellValue(Row, "ofc_cd"));
    				ComOpenPopup("ESM_BKG_0019POP.do", 870, 580, 'setPopupParam', '0,0', true, false, Row, Col, 0);
    				break;
			}
		}
	}
    	
    	
    	/**
  	 * function get parameter from popup
  	 * @param aryPopupData
  	 * @param Row
  	 * @param Col
  	 * @param SheetIdx
  	 * @return
  	 */
  	function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
  		//alert( aryPopupData + "::"+ Row + "::"+ Col+ "::"+SheetIdx);
  		var str = aryPopupData +"";
  		var arr = str.split(',');
  		var sheetObj =  sheetObjects[SheetIdx];
  		sheetObj.SetCellValue( Row, Col, arr[3], 0);

  		sheet1_OnChange(sheetObj , Row, Col, arr[3]);
  	}
      
  	
  	
  	function LaneText(sheetObj, sXml) {
  		var comboText = "";
  	    var xmlDoc = ComGetXmlDoc(sXml);
  	    var xmlRoot = xmlDoc.documentElement;
  	    var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
  	    
  	    if (dataNode == null) {
  	        return;
  	    }
  	    
  	    var trDataChildNodes = dataNode.childNodes;
  	    
  	    for (var i=0; i<trDataChildNodes.length; i++) {
  	    	if (trDataChildNodes[i] == null) {
  	    		return;
  	    	} else {
  	    		if (trDataChildNodes[i].nodeName == "TR") {
  	    			var tdDataChildNodes = trDataChildNodes[i].childNodes;
  	    			var targetRow = trDataChildNodes[i].getAttribute("ROW");
  	    			
  	    			for (var j=0; i<tdDataChildNodes.length; j++) {
  	    				if (tdDataChildNodes[j] == null) {
  	    					return;
  	    				} else {
  	    					if (tdDataChildNodes[j].nodeName == "TD") {
  	        					var targetCol = tdDataChildNodes[j].getAttribute("COL");
  	        					var dataType = tdDataChildNodes[j].getAttribute("DATA-TYPE");
  	        					
  	        					if (targetCol == null || dataType == null) {
  	        						return;
  	        					} else {
  	        						if (dataType == "dtComboEdit") {
  	                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
  	                					comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
  	        							
  	        						}  
  	        					}
  	    					}
  	    				}
  	    			}
  	    		}
  	    	}
  	    }
  	    
  	    return comboText;
  	    
  	}
