/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_9191.js
*@FileTitle  : Total Amount List Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/02
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// global variable
var sheetObjects=new Array();
var sheetCnt=0;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
    function processButtonClick(){
         /***** using extra sheet valuable if there are more 2 sheets *****/
         /*******************************************************/
         var sheetObject=sheetObjects[0];
         var formObject=document.form;
    	 try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {
         	    case "btng_rowadd":
    	            var Row=sheetObject.DataInsert(-1);
        	        break;
         	    case "btn_ok":
         	    	 	setParentRvisSheet(sheetObject,formObject,formObject.rh_vol_qty.value);
         	    	 	ComClosePopup(); 
        	        break;
         	    case "btn_close":
         	    	ComClosePopup(); 
        	        break;
            } // end switch
    	}catch(e) {
    		if( e == "[object Error]") {
    			ComShowCodeMessage('TES21506'); //ComShowMessage(OBJECT_ERROR);
    		} else {
    			ComShowMessage(e.message);
    		}
    	}
    }
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     * @param(sheet_obj) sheet object
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
			 var sheetObject=sheetObjects[0];
			 var formObject=document.form;
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
			doActionIBSheet(sheetObject,formObject,IBSEARCH);
// 			setInitSheetCheck(sheetObject,formObject);
    }
   /**
     * setting sheet initial values and header
     * param : sheetObj ==> , sheetNo ==>  
     * adding case as numbers of counting sheets
     * @param(sheet_obj) sheet object
     * @param(sheetNo) sheet number
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
             case 1:      //sheet init
            	    with(sheetObj){

               
               var HeadTitle="STS||Seq.|CNTR No.|Caused CNTR|Reason Code";

               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
               var headers = [ { Text:HeadTitle, Align:"Center"} ];
               InitHeaders(headers, info);

               var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                      {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rvis_ind_flg" },
                      {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"",                           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cntr_no",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_cuz_cntr_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_rhnd_rsn_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_tml_so_rvis_list_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                      {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"rvis_lgs_cost_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                
               InitColumns(cols);

               SetEditable(1);
               resizeSheet();//SetSheetHeight(260);
                     }


                break;
        }
    }
	function resizeSheet(){
		ComResizeSheet(sheetObjects[0]);
	}
  /** handling sheet process
   *  @param(sheet_obj) sheet object
   *  @param(formObj) formObj object
   *  @param(sAction) action 값
   */
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:	  //Retrieve
                formObj.f_cmd.value=SEARCH;
                 var searchXml=sheetObj.GetSearchData("ESD_TES_9191GS.do",  tesFrmQryStr(formObj));
                sheetObj.RemoveAll();
                sheetObj.LoadSearchData(searchXml,{Append:1 , Sync:1} );
                break;
        }
    }
//    function sheet_OnSearchEnd(sheetObj){
//        var openerObj = window.dialogArguments.document.rvis_hidden;
//        var formObj = document.form;
//         for(var i= openerObj.HeaderRows; i< openerObj.HeaderRows + openerObj.RowCount; i++){
//	        if(openerObj.CellValue(i,"rvis_vsl_cd")        == formObj.vvd.value.substring(0,4)
//	           && openerObj.CellValue(i,"rvis_skd_voy_no") == formObj.vvd.value.substring(4,8)
//	           && openerObj.CellValue(i,"rvis_skd_dir_cd") == formObj.vvd.value.substring(8,9)
//	           && openerObj.CellValue(i,"rvis_lgs_cost_cd")== formObj.lgs_cost_cd.value
//	           && openerObj.RowStatus(i)=='I')
//	        {
//	            if(sheetObj.FindText('cntr_no', openerObj.CellValue(i,'rvis_cntr_no')) > 0){
//	                Row = sheetObj.FindText('cntr_no', openerObj.CellValue(i,'rvis_cntr_no'));
//	            }else{
//	                var Row = sheetObj.DataInsert(-1);
//	            }
//	            sheetObj.CellValue(Row,"tml_so_dtl_seq"      ) = openerObj.CellValue(i, "rvis_tml_so_dtl_seq"       );
//        	  	sheetObj.CellValue(Row,"tml_so_rvis_list_seq") = openerObj.CellValue(i, "rvis_tml_so_rvis_list_seq" );
//        	  	sheetObj.CellValue(Row,"lgs_cost_cd"         ) = openerObj.CellValue(i, "rvis_lgs_cost_cd"          );
//        	  	sheetObj.CellValue(Row,"cntr_no"             ) = openerObj.CellValue(i, "rvis_cntr_no"              );
//        	  	sheetObj.CellValue(Row,"rvis_ind_flg"        ) = openerObj.CellValue(i, "rvis_ind_flg"              );
//        	  	sheetObj.CellValue(Row,"rhnd_rsn_cd"         ) = openerObj.CellValue(i, "rvis_rhnd_rsn_cd"          );
//        	  	sheetObj.CellValue(Row,"rhnd_rsn_cntr_no"    ) = openerObj.CellValue(i, "rvis_cuz_cntr_no"          );
//        	  	sheetObj.CellValue(Row,"rvis_ind_flg"    ) = openerObj.CellValue(i, "rvis_ind_flg"          );
//	        }
//	    }
//
//    }
   /**
     * handling process for input validation
     * @param(sheetObj) sheet object
     * @param(formObj) form object
     * @param(sAction) sAction
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
//	function sheet_OnClick(sheet, row, col){
//		if (sheet.ColSaveName(col) == "chk"){
//			if(sheet.CellValue(row,"click_yn") == "Y")  sheet.CellValue(row,"click_yn") = "N";
//			else 																				sheet.CellValue(row,"click_yn") = "Y";
//		}
//	}
//	function setInitSheetCheck(sheetObj,formObj){
//		var openerObj = window.dialogArguments.document;
//		if(openerObj.rvis_hidden.RowCount > 0){
//			for(var i= openerObj.rvis_hidden.HeaderRows; i< openerObj.rvis_hidden.HeaderRows + openerObj.rvis_hidden.RowCount; i++){
//				for(var j=sheetObj.HeaderRows; j< sheetObj.HeaderRows + sheetObj.RowCount; j++){
//					if(openerObj.rvis_hidden.CellValue(i,"rvis_cntr_no") == sheetObj.CellValue(j, "cntr_no") &&
//				   openerObj.rvis_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//				   		sheetObj.CellValue(j, "chk") = true;
//				  }
//				}
//
//			}
//		}
//
//	}
//	function addParentRvisSheet(sheetObj,row_num,formObj){
//		var openerObj = window.dialogArguments.document;
//		  Row = window.dialogArguments.document.rvis_hidden.DataInsert(-1);
//
//      openerObj.rvis_hidden.CellValue(Row,"rvis_page"           			 			) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "page"           			);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_ofc_cty_cd"		) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_ofc_cty_cd"		);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_seq"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_seq"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_dtl_seq"       ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_dtl_seq"       );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_so_rvis_list_seq" ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_so_rvis_list_seq" );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_cost_grp_cd"     ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_cost_grp_cd"     );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lgs_cost_cd"          ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lgs_cost_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_vsl_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "vsl_cd"               );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_voy_no"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_voy_no"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_skd_dir_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "skd_dir_cd"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_calc_tp_cd"           ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "calc_tp_cd"           );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_ioc_cd"               ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "ioc_cd"               );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_lane_cd"              ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "lane_cd"              );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_io_bnd_cd"            ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "io_bnd_cd"            );
////	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "cntr_tpsz_cd"         );
//	  	openerObj.rvis_hidden.CellValue(Row,"n3rd_dcgo_clss_cd"         ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "dcgo_clss_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"n3rd_tml_wrk_dy_cd"         					) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "tml_wrk_dy_cd"         					 );
//			openerObj.rvis_hidden.CellValue(Row,"rvis_wrk_dt"      				  ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "wrk_dt"       				);
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_fm_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "fm_tr_vol_val"        );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_to_tr_vol_val"        ) =openerObj.t3sheet1.CellValue(formObj.opener_row.value, "to_tr_vol_val"        );
//
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_rvis_tp_cd"       ) ="H";
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_tml_inv_tp_cd"        ) ="TM";
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_no"              ) =sheetObj.CellValue(row_num, "cntr_no"              );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cuz_cntr_no"          ) =sheetObj.CellValue(row_num, "cuz_cntr_no"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_rhnd_rsn_cd"          ) =sheetObj.CellValue(row_num, "rhnd_rsn_cd"          );
//	  	openerObj.rvis_hidden.CellValue(Row,"rvis_cntr_tpsz_cd"          ) =sheetObj.CellValue(row_num, "cntr_tpsz_cd"          );
//
//	}
//	function delParentRvisSheet(sheetObj,row_num,formObj){
//		var openerObj = window.dialogArguments.document;
//		for(var i= openerObj.rvis_hidden.HeaderRows; i< openerObj.rvis_hidden.HeaderRows + openerObj.rvis_hidden.RowCount; i++){
//			if(openerObj.rvis_hidden.CellValue(i,"rvis_cntr_no"		 ) == sheetObj.CellValue(row_num, "cntr_no") &&
//			   openerObj.rvis_hidden.CellValue(i,"rvis_lgs_cost_cd") == formObj.lgs_cost_cd.value){
//			   		openerObj.rvis_hidden.RowDelete(i, false);
//						i--;
//			  }
//		}
//	}
//    function setParentRvisSheet(sheetObj,formObj,volQty){
//    	//ComShowMessage("setParentRvisSheet");
//    	for(var i=sheetObj.HeaderRows; i< sheetObj.HeaderRows + sheetObj.RowCount; i++){
//      	if(sheetObj.CellValue(i,"click_yn") == "Y" ){
//      		if(sheetObj.CellValue(i,"chk")){
//						volQty++;
//						addParentRvisSheet(sheetObj,i,formObj);
//					}else{
//						volQty--;
//						delParentRvisSheet(sheetObj,i,formObj);
//					 }
//      	}
//      }
//      window.dialogArguments.document.t3sheet1.CellValue(formObj.opener_row.value,"rvis_vol_qty") = volQty;
//
//    }
	/**
	 *  set Parent Rvis Sheet
	 */
    function setParentRvisSheet(){
        var sheetObj=sheetObjects[0];
        var openerObj=window.dialogArguments.document.rvis_hidden;
        var openerDtlObj=window.dialogArguments.document.t3sheet1;
        var opener_row=document.form.opener_row.value;
        var Row
        for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
if(sheetObj.GetCellValue(i,'rvis_ind_flg') == 1){
if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.GetCellValue(i,'lgs_cost_cd'))<0
|| openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'))<0)
                {
                    Row=openerObj.DataInsert(-1);
                    copy2Opener(Row, i);
if(sheetObj.GetCellValue(i,'tml_so_dtl_seq')>0 && sheetObj.GetCellValue(i,'tml_so_rvis_list_seq')>0){
                        openerObj.SetRowStatus(Row,'U');
                    }
openerDtlObj.SetRowStatus(opener_row,getOpenerGetRowStatus());
                }else{
if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.GetCellValue(i,'lgs_cost_cd'))>0 && openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'))){
Row=openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'));
                        copy2Opener(Row, i);
if(sheetObj.GetCellValue(i,'tml_so_dtl_seq')>0 && sheetObj.GetCellValue(i,'tml_so_rvis_list_seq')>0){
                            openerObj.SetRowStatus(Row,'U');
                        }
openerDtlObj.SetRowStatus(opener_row,getOpenerGetRowStatus());
                    }
                }
}else if(sheetObj.GetCellValue(i,'rvis_ind_flg') == 0){
if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.GetCellValue(i,'lgs_cost_cd'))>0
&& openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'))>0)
                {
if(openerObj.FindText('rvis_lgs_cost_cd', sheetObj.GetCellValue(i,'lgs_cost_cd'))>0 && openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'))){
Row=openerObj.FindText('rvis_cntr_no', sheetObj.GetCellValue(i,'cntr_no'));
                        delParentRvisSheet(Row);
openerDtlObj.SetRowStatus(opener_row,getOpenerGetRowStatus());
                    }
                }else{
if(sheetObj.GetCellValue(i,'tml_so_dtl_seq')>0 && sheetObj.GetCellValue(i,'tml_so_rvis_list_seq')>0){
                         Row=openerObj.DataInsert(-1);
                         copy2Opener(Row, i);
                         openerObj.SetRowStatus(Row,'R');
                         openerObj.SetRowStatus(Row,'D');
openerDtlObj.SetRowStatus(opener_row,getOpenerGetRowStatus());
                    }
                }
            }
        }
        openerDtlObj.SetCellValue(opener_row,'rvis_vol_qty',getRVISQty());
    }
    /**
     * get Opener Row Status
     */
function getOpenerGetRowStatus(){
        var openerDtlObj=window.dialogArguments.document.t3sheet1;
        var opener_row=document.form.opener_row.value;
var org_status=openerDtlObj.GetRowStatus(opener_row);
        if(org_status == 'I'){
            return 'I';
        }else if(org_status == 'U' || org_status == 'R' || org_status == 'D'){
            return 'U';
        }
    }
    /**
     * get qty value
     * @return
     */ 
    function getRVISQty(){
	    var sheetObj=sheetObjects[0];
	    var qty=0;
var cntr_tpsz=window.dialogArguments.document.t3sheet1.GetCellValue( document.form.opener_row.value, "cntr_tpsz_cd");
//	    var calc_tp = 0;
//	    if(document.form.calc_tp_cd.value == 'A'){
//	        calc_tp = 0
//	    }else if(document.form.calc_tp_cd.value == 'M'){
//	        calc_tp = 1;
//	    }
	    for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+sheetObj.RowCount(); i++){
if(sheetObj.GetCellValue(i,'rvis_ind_flg') == 1){
	            qty=parseInt(qty) + 1;
	        }
	    }
	    if(document.form.vol_tr_ut_cd.value == 'T'){
	        if(cntr_tpsz == 'D4'){
                return parseFloat(qty) * 2;
            }else if(cntr_tpsz == 'D7'){
                return parseFloat(qty) * 2.25;
            }else if(cntr_tpsz == 'D8'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'D9'){
                return parseFloat(qty) * 2.4;
            }else if(cntr_tpsz == 'DW'){
                return parseFloat(qty) * 2.65;
            }else if(cntr_tpsz == 'DX'){
                return parseFloat(qty) * 2.25;
            }else{
                return qty;
            }
	    }
	    return qty;
	}
    /**
     * copy opener value
     * @param Row
     * @param row
     * @return
     */
    function copy2Opener(Row, row){
	    var openerObj=window.dialogArguments.document;
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_so_dtl_seq"       ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "tml_so_dtl_seq"       ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_so_rvis_list_seq" ,sheetObj.GetCellValue(row,"tml_so_rvis_list_seq"));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_calc_cost_grp_cd"     ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "calc_cost_grp_cd"     ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_lgs_cost_cd"          ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "lgs_cost_cd"          ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_vsl_cd"               ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "vsl_cd"               ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_skd_voy_no"           ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "skd_voy_no"           ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_skd_dir_cd"           ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "skd_dir_cd"           ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_calc_tp_cd"           ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "calc_tp_cd"           ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_ioc_cd"               ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "ioc_cd"               ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_lane_cd"              ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "lane_cd"              ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_io_bnd_cd"            ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "io_bnd_cd"            ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_dcgo_clss_cd"         ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "dcgo_ind_cd"          ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_wrk_dy_cd"        ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "tml_wrk_dy_cd"		 ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_trns_mod_cd"      ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "tml_trns_mod_cd"		 ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_wrk_dt"      			,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "wrk_dt"        		 ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_fm_tr_vol_val"        ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "fm_tr_vol_val"        ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_to_tr_vol_val"        ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "to_tr_vol_val"        ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_cntr_tpsz_cd"         ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "cntr_tpsz_cd"         ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_rc_flg"               ,openerObj.t3sheet1.GetCellValue(formObj.opener_row.value, "rc_flg"               ));
	  	openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_rvis_tp_cd"       ,"H");
	  	openerObj.rvis_hidden.SetCellValue(Row,"rvis_tml_inv_tp_cd"        ,"TM");
openerObj.rvis_hidden.SetCellValue(Row,"rvis_cntr_no"              ,sheetObj.GetCellValue(row, "cntr_no"              ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_cuz_cntr_no"          ,sheetObj.GetCellValue(row, "rhnd_rsn_cntr_no"          ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_rhnd_rsn_cd"          ,sheetObj.GetCellValue(row, "rhnd_rsn_cd"          ));
openerObj.rvis_hidden.SetCellValue(Row,"rvis_ind_flg"         ,sheetObj.GetCellValue(row, "rvis_ind_flg"         ));
	}
    /**
     * revise sheet delete
     * @param Row 
     * @return
     */
	function delParentRvisSheet(Row){
		var openerObj=window.dialogArguments.document.rvis_hidden;
if(openerObj.GetRowStatus(Row) == 'U'){
		    openerObj.SetRowStatus(Row,'D');
}else if(openerObj.GetRowStatus(Row) == 'I'){
		    openerObj.RowDelete(Row,false);
		}
	}
