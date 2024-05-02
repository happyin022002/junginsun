﻿/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0097.js
*@FileTitle  : Total Loss EQ Add - Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
	//Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var retComboVal="";
	//Defining event handler of button click */
	document.onclick=processButtonClick;
	var opener = window.dialogArguments;
	var loadExcelFlg = "N";
	//Event handler to diverge process by button name */
	function processButtonClick(){
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				case "btn_ok":
					doActionIBSheet(sheetObject, formObject, COMMAND01);
					break;
				case "btn_RowAdd":
					doActionIBSheet(sheetObject, formObject, IBINSERT);
					break;
				case "btn_RowDel":
					doActionIBSheet(sheetObject, formObject, IBDELETE);
					break;
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_loadexcel":
					sheetObject.RemoveAll();
					loadExcelFlg = "Y";
					sheetObject.LoadExcel();
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
	 * Assigning array of IBCombo object
	 * @param	{IBMultiCombo}	combo_obj
	 * Array defined at the top of the source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * Assigning array of IBSheet object
	 * Array defined at the top of the source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * Assigning array of IBTab object
	 * Array defined at the top of the source
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++]=tab_obj;
	}
	/**
	 * Getting ToTal Loss screen value
	 */
	function getParent_0097(target,formObj) {
		var sourceSheet=null;
		if(opener != undefined)
		{
			var sourceSheetDv,sourceSheetTp,sourceSheetDs,sourceSheetSc,sourceSheetIr=null; //sourceSheet
//			var dAr=window.dialogArguments;
			var ix=(formObj.work_type.value=="request")?0:1;
			//Sheet Exist Setting
			if(opener.sheetObjects[++ix]!=undefined) sourceSheetDv=opener.sheetObjects[ix]; //D.V Expense
			if(opener.sheetObjects[++ix]!=undefined) sourceSheetTp=opener.sheetObjects[ix]; //3rd Party
			if(opener.sheetObjects[++ix]!=undefined) sourceSheetDs=opener.sheetObjects[ix]; //Disposal
			if(opener.sheetObjects[++ix]!=undefined) sourceSheetSc=opener.sheetObjects[ix]; //Scrapping
			if(opener.sheetObjects[++ix]!=undefined) sourceSheetIr=opener.sheetObjects[ix]; //Insurance
			sourceSheet=[sourceSheetDv,sourceSheetTp,sourceSheetDs,sourceSheetSc,sourceSheetIr];
		}else{
			return;
		}
		var mnrInvTpCd=["DV","TP","DS","SC","IR"]; //[D.V Expense,3rd Party,Disposal,Scrapping,Insurance]
		for(var i=0; i<sourceSheet.length; i++)
		{
			if(sourceSheet[i].RowCount()<=0){
				sourceSheet[i].RemoveAll();
			}
		}
		for( var i=0;i<sourceSheet.length;i++)
		{
			if(i==0){
				for(var j=sourceSheet[i].HeaderRows(); j<=sourceSheet[i].LastRow(); j++)
				{
					if(sourceSheet[i].GetCellValue(j,"seq")!=0 && sourceSheet[i].GetCellValue(j,"ibflag")!="D")
					{
						var row=target.DataInsert(-1);
				        for (ic=0; ic<=sourceSheet[i].LastCol(); ic++)
				        {
					        //target paste
				        	if(target.SaveNameCol(sourceSheet[i].ColSaveName(ic)) > -1)
				        		target.SetCellValue(row, sourceSheet[i].ColSaveName(ic),sourceSheet[i].GetCellValue(j, sourceSheet[i].ColSaveName(ic)),0);
				        	if(sourceSheet[i].ColSaveName(ic)=="rqst_eq_no")
				        		target.SetCellValue(row,"org_eq_no",sourceSheet[i].GetCellValue(j, sourceSheet[i].ColSaveName(ic)),0);
				        }
					}
				}
		        break;
			}
		}
		for(var i=1; i<=target.LastRow(); i++)
		{
			var rqstEqNo=target.GetCellValue(i,"org_eq_no");	//EQ NO
			for( var j=1;j<sourceSheet.length;j++)
			{
				var row=sourceSheet[j].FindText("rqst_eq_no", rqstEqNo);
				if(row != -1)
				{
					if(sourceSheet[j].GetCellValue(row,"ibflag")!="D")
					{
						if(mnrInvTpCd[j]=="TP")     target.SetCellValue(i,"tp_chk","1",0);
					    else if(mnrInvTpCd[j]=="DS") target.SetCellValue(i,"ds_chk","1",0);
						else if(mnrInvTpCd[j]=="SC") target.SetCellValue(i,"sc_chk","1",0);
						else if(mnrInvTpCd[j]=="IR") target.SetCellValue(i,"ir_chk","1",0);
					}
				}
			}
		}
	}
	function comPopupOK_0097(fromSheet, formObj, sAction) {
 		MnrWaitControl(true);
		var targetSheet=null;
		if(opener != undefined)
		{
			var targetSheetDv,targetSheetTp,targetSheetDs,targetSheetSc,targetSheetIr=null; //targetSheet
//			var dAr=window.dialogArguments;
			var ix=(formObj.work_type.value=="request")?0:1;
			//Sheet Execist Setting
			if(opener.sheetObjects[++ix]!=undefined) targetSheetDv=opener.sheetObjects[ix]; //D.V Expense
			if(opener.sheetObjects[++ix]!=undefined) targetSheetTp=opener.sheetObjects[ix]; //3rd Party
			if(opener.sheetObjects[++ix]!=undefined) targetSheetDs=opener.sheetObjects[ix]; //Disposal
			if(opener.sheetObjects[++ix]!=undefined) targetSheetSc=opener.sheetObjects[ix]; //Scrapping
			if(opener.sheetObjects[++ix]!=undefined) targetSheetIr=opener.sheetObjects[ix]; //Insurance
			targetSheet=[targetSheetDv,targetSheetTp,targetSheetDs,targetSheetSc,targetSheetIr];
		}else{
			sheetObj.SetWaitImageVisible(1);
			MnrWaitControl(false);
			return;
		}
		var ibFlag,rqstEqNo="";
		var dvChk="1"; //DV Expense
		var tpChk,dsChk,scChk,irChk="0"; //3rd Party,Disposal,Scrapping,Insurance
		var mnrInvTpCd=["DV","TP","DS","SC","IR"];
		for(var i=0; i<targetSheet.length; i++)
		{
			if(targetSheet[i].RowCount()<=0){
				targetSheet[i].RemoveAll();
			}
		}
		with(fromSheet)
		{
			for(var i=HeaderRows(); i<=LastRow(); i++)
			{
				ibFlag=GetCellValue(i,"ibflag");    //ROW Status
				rqstEqNo=GetCellValue(i,"org_eq_no"); //EQ NO
				tpChk=GetCellValue(i,"tp_chk");    //3rd Party
				dsChk=GetCellValue(i,"ds_chk");    //Disposal
				scChk=GetCellValue(i,"sc_chk");    //Scrapping
				irChk=GetCellValue(i,"ir_chk");    //Insurance
				var tpAr=[dvChk,tpChk,dsChk,scChk,irChk];
				if(ibFlag== "U")
				{
					for(var j=0;j<tpAr.length;j++)
					{
						if(tpAr[j]=="1")
						{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row == -1)
							{
								row=targetSheet[j].DataInsert(-1);
						        //target paste
						        for (var ic=0; ic<=LastCol(); ic++)
						        {
						        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
						        	{
						        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
						        		{
							        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
						        			{
							        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
							        			{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
						        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
						        			{
//						        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
						        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
							        			{
							        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
							        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
							        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
							        				targetSheet[j].SetCellEditable(row, "payer_code", 0);
							        				targetSheet[j].SetCellEditable(row, "payer_name", 0);
							        				targetSheet[j].SetCellEditable(row, "mnr_prnr_seq", 0);
							        			}
						        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
						        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
							        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
							        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
							        			}
						        			}else if(j==1 && ColSaveName(ic)=="inv_no")
						        			{
						        				var invNo=GetCellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"T";
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
						        			}else if(j==2 && ColSaveName(ic)=="inv_no")
						        			{
						        				var invNo=GetCellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"S";
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
						        			}else if(j==0 && ColSaveName(ic)=="inv_no")
						        			{
						        				if(GetCellValue(i, "lstm_cd") == "OW"){
						        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
						        				}else{
						        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
						        				}
						        			}else{
						        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
						        			}
						        		}
						        	}
						        }
						        targetSheet[j].SetRowStatus(row,"I");
						        targetSheet[j].SetCellValue(row, "mnr_inv_tp_cd",mnrInvTpCd[j],0);
							}else{
								if(targetSheet[j].GetCellValue(row, "ibflag")=="D")
								{
									targetSheet[j].SetRowHidden(row,0);
							        for (var ic=0; ic<=LastCol(); ic++)
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
								        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
								        			{
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
//							        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
							        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
								        			{
								        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
								        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
								        				targetSheet[j].SetCellEditable(row, "payer_code", 0);
								        				targetSheet[j].SetCellEditable(row, "payer_name", 0);
								        				targetSheet[j].SetCellEditable(row, "mnr_prnr_seq", 0);
								        			}
							        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
							        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
								        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
							        			}else if(j==0 && ColSaveName(ic)=="inv_no")
							        			{
							        				if(GetCellValue(i, "lstm_cd") == "OW"){
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
							        				}else{
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
							        				}
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
							        		}
							        	}
							        }
									targetSheet[j].SetCellValue(row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
									targetSheet[j].SetRowStatus(row,"U");
								}else{
							        for (var ic=0; ic<=LastCol(); ic++)
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
								        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
								        			{
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
//							        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
							        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
								        			{
								        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
								        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
								        			}
							        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
							        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
								        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
							        			}else if(j==0 && ColSaveName(ic)=="inv_no")
							        			{
							        				if(GetCellValue(i, "lstm_cd") == "OW"){
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
							        					targetSheet[j].SetCellEditable(row, ColSaveName(ic), 0);
							        				}else{
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
							        					targetSheet[j].SetCellEditable(row, ColSaveName(ic), 1);
							        				}
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
							        		}
							        	}
							        }
									targetSheet[j].SetCellValue(row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
									targetSheet[j].SetRowStatus(row,"U");
						        }
						        targetSheet[j].SetCellValue(row, "mnr_inv_tp_cd",mnrInvTpCd[j],0);
							}
						}else{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].GetCellValue(row,"ibflag")!="D")
								{
									targetSheet[j].SetCellValue(row,"del_chk","1");
									ComRowHideDelete(targetSheet[j], "del_chk");
								}
							}
						}
//						targetSheet[j].SetRenderSheetSum(1);//Calculating sum
					}
				}else if(ibFlag== "D")
				{
					for(var j=0;j<tpAr.length;j++)
					{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].GetCellValue(row,"ibflag")!="D")
								{
								targetSheet[j].SetCellValue(row,"del_chk","1");
								ComRowHideDelete(targetSheet[j], "del_chk");
								}
							}
//							targetSheet[j].SetRenderSheetSum(1);//Calculating sum
					}
				}else if(ibFlag== "I")
				{
					for(var j=0;j<tpAr.length;j++)
					{
						if(tpAr[j]=="1")
						{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row == -1)
							{
								var row=targetSheet[j].DataInsert(-1);
						        //target paste
						        for (ic=0; ic<=LastCol(); ic++)
						        {
						        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
						        	{
						        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
						        		{
							        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
						        			{
							        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
							        			{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
						        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
						        			{
//						        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
						        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
							        			{
							        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
							        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
							        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
							        			}
						        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
						        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
							        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
							        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
							        			}
						        			}else if(j==1 && ColSaveName(ic)=="inv_no")
						        			{
						        				var invNo=GetCellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"T";
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
						        			}else if(j==2 && ColSaveName(ic)=="inv_no")
						        			{
						        				var invNo=GetCellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"S";
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
						        			}else if(j==0 && ColSaveName(ic)=="inv_no")
						        			{
						        				if(GetCellValue(i, "lstm_cd") == "OW"){
						        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
						        					targetSheet[j].SetCellEditable(row, ColSaveName(ic), 0);
						        				}else{
						        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
						        					targetSheet[j].SetCellEditable(row, ColSaveName(ic), 1);
						        				}
						        			}else{
						        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
						        			}
						        		}
						        	}
						        }
								targetSheet[j].SetCellValue(row, "mnr_inv_tp_cd",mnrInvTpCd[j],0);
								targetSheet[j].SetCellValue(row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
								targetSheet[j].SetCellValue(row, "curr_cd","USD",0);//CURR
							}else{
								if(targetSheet[j].GetCellValue(row, "ibflag")=="D")
								{
									targetSheet[j].SetRowHidden(row,0);
							        for (var ic=0; ic<=LastCol(); ic++)
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
								        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
								        			{
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
//							        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
							        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
								        			{
								        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
								        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
								        			}
							        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
							        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
								        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
							        			}else if(j==0 && ColSaveName(ic)=="inv_no")
							        			{
							        				if(GetCellValue(i, "lstm_cd") == "OW"){
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
							        				}else{
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
							        				}
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
							        		}
							        	}
							        }
									targetSheet[j].SetCellValue(row, "mnr_inv_tp_cd",mnrInvTpCd[j],0);
									targetSheet[j].SetCellValue(row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
									targetSheet[j].SetCellValue(row, "curr_cd","USD",0);//CURR
									targetSheet[j].SetRowStatus(row,"U");
									targetSheet[j].SetRenderSheetSum(1);//Calculating sum
								}else{
							        for (var ic=0; ic<=LastCol(); ic++)
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
								        			if(GetCellValue(i, ColSaveName(ic))=="" || GetCellValue(i, ColSaveName(ic))=="0" )
								        			{
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, "dpc_val_amt"),0);
								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
//							        				if(j==0 && GetCellValue(i, ColSaveName(ic))=="")
							        				if(j==0 && GetCellValue(i, "lstm_cd")=="OW")
								        			{
								        				targetSheet[j].SetCellValue(row, "payer_code"," ",0);
								        				targetSheet[j].SetCellValue(row, "payer_name"," ",0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq"," ",0);
								        			}
							        				else if(j==0 && GetCellValue(i, "lstm_cd")!="OW"){
							        					targetSheet[j].SetCellValue(row, "payer_code", GetCellValue(i, "mnr_prnr_seq"), 0);
								        				targetSheet[j].SetCellValue(row, "payer_name", GetCellValue(i, "lessor_nm"), 0);
								        				targetSheet[j].SetCellValue(row, "mnr_prnr_seq", GetCellValue(i, "mnr_prnr_seq"), 0);
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"T",0);
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
							        				var invNo=GetCellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].SetCellValue(row, ColSaveName(ic),invNo.substring(0,invNo.length-1)+"S",0);
							        			}else if(j==0 && ColSaveName(ic)=="inv_no")
							        			{
							        				if(GetCellValue(i, "lstm_cd") == "OW"){
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), " ", 0);
							        				}else{
							        					targetSheet[j].SetCellValue(row, ColSaveName(ic), GetCellValue(i, ColSaveName(ic)), 0);
							        				}
							        			}else{
							        				targetSheet[j].SetCellValue(row, ColSaveName(ic),GetCellValue(i, ColSaveName(ic)),0);
							        			}
							        		}
							        	}
							        }
						        }
						        targetSheet[j].SetCellValue(row, "mnr_inv_tp_cd",mnrInvTpCd[j],0);
							}
						}else{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].GetCellValue(row,"ibflag")!="D")
								{
									targetSheet[j].SetCellValue(row,"del_chk","1");
									ComRowHideDelete(targetSheet[j], "del_chk");
								}
							}
						}
//						targetSheet[j].SetRenderSheetSum(1);//Calculating sum
					}
				}
			}
		}
		opener.setCalculateTotalSum();
 		MnrWaitControl(false);
 		ComClosePopup(); 
	}
	/**
	 * Sheet default setting and initializing
	 * To implement for onload event of body tag
	 * After loading in your browser should display the ability to add pre-processing
	 */
	function loadPage() {
		var formObject=document.form;
		if (!opener) opener = parent;
		if(opener != undefined)
		{
			//hidden Text Setting
			if(opener.document.form.rqst_ofc_cd!=undefined)
			{
				formObject.rqst_ofc_cd.value=opener.document.form.rqst_ofc_cd.value;
			}
			//hidden Text Setting
			if(opener.document.form.ttl_lss_no!=undefined)
			{
				formObject.ttl_lss_no.value=opener.document.form.ttl_lss_no.value;
			}
			//hidden Text Setting
			if(opener.document.form.work_type!=undefined)
			{
				formObject.work_type.value=opener.document.form.work_type.value;
			}
		}
		MnrWaitControl(true);
		for(i=0;i<sheetObjects.length;i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		    with(sheetObj){	        
			      var HeadTitle1="|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|3rd Party|Disposal";
			      HeadTitle1 += "|Lessor_lessor_nm|Invoice No._inv_no|CURR_curr_cd|Pay Amount_ttl_lss_bil_amt|EQ Status_ttl_lss_dtl_sts_cd";
			      HeadTitle1 += "|ttl_lss_no|ttl_lss_plc_nm|org_eq_no|mnr_prnr_seq";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      (headCount, 0, 0, true);
			      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:0 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"del_chk",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:1,   SaveName:"eq_knd_cd",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"rqst_eq_no",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lstm_cd",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"ttl_lss_yd_cd",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:95,   Align:"Right",   ColMerge:1,   SaveName:"dpc_val_amt",         KeyField:1,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"tp_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N"},
			             {Type:"CheckBox",  Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ds_chk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1, TrueValue:"Y", FalseValue:"N" },
			             {Type:"Text",      Hidden:1, Width:145,  Align:"Left",    ColMerge:1,   SaveName:"lessor_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"inv_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Right",   ColMerge:1,   SaveName:"ttl_lss_bil_amt",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:13 },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_dtl_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_no" },
			             {Type:"Text",      Hidden:1, Width:60,   Align:"Left",    ColMerge:1,   SaveName:"ttl_lss_plc_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"org_eq_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
			             {Type:"Text",      Hidden:1, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"mnr_prnr_seq" } ];
			       
			      InitColumns(cols);
			      SetEditable(1);
			      SetSheetHeight(282);
			      SetColProperty(0 ,"rqst_eq_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            }
		break;
		}
	}
	/**
	 * Setting and initializing of sheet combo
	 * @param	{IBSheet}	sheetObj	sheet object
	 */
	function initSheetCombo() {
		//Retrieving sheet
		var sCondition=new Array (
			new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
		)
		var comboList=MnrComSearchCombo(sheetObj,sCondition);
		//Setting sheet
		var sheetComboText="";
		var sheetComboCode="";
		var sheetComboCodeText="";
		var sheetComboDefault="";
		for(var i=0; i<comboList.length; i++) {
			//Initializing each combo of sheets
			sheetComboText="";
			sheetComboCode="";
			sheetComboCodeText="";
			sheetComboDefault="";
			for(var j=0; j<comboList[i].length; j++){
				var tempText=comboList[i][j].split("|");
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(j ==0){
					sheetComboDefault=tempText[0];
				}
			}
			if(i==0)
			{
				sheetComboText = MnrDelLastDelim(sheetComboText);
				sheetComboCode =  MnrDelLastDelim(sheetComboCode);
				sheetComboCodeText =  MnrDelLastDelim(sheetComboCodeText);
				sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
			}
		}
	}
	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
//		sheetObj.ShowDebugMsg(false);
		var formObj=document.form;
		switch(sAction) {
			case IBINSERT:  // ROWADD
				var Row=sheetObj.DataInsert(-1);
				//Setting Total Loss No
				sheetObj.SetCellValue(Row, "ttl_lss_no",ComGetObjValue(formObj.ttl_lss_no),0);
				//Setting mnr_inv_tp_cd
				sheetObj.SetCellValue(Row, "mnr_inv_tp_cd","DV",0);
				sheetObj.SetCellValue(Row, "ttl_lss_n3pty_tp_cd","",0);
				sheetObj.SetCellValue(Row, "ttl_lss_dtl_sts_cd","",0);
				sheetObj.SetCellValue(Row, "ttl_lss_plc_nm","",0);
				//Initializing value of sheet combo
				sheetObj.SetCellValue(Row, "curr_cd","USD",0);//CURR
				break;
			case IBDELETE:  // ROWDELETE
				ComRowHideDelete(sheetObj, "del_chk");
				break;
			case IBCLEAR: //  Initializing all sheet and combo data
				MnrWaitControl(true);
				sheet1.SetWaitImageVisible(0);
				//Initializing sheet
				initSheetCombo();
				sheet1.SetWaitImageVisible(1);
				MnrWaitControl(false);
				break;
			case COMMAND01: //  Initializing all sheet and combo data
//				MnrWaitControl(true);
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(0);
					comPopupOK_0097(sheetObj,formObj,sAction);
					//Initializing sheet
					sheetObj.SetWaitImageVisible(1);
				}
//				MnrWaitControl(false);
			break;
		}
	}
	/**
	 * Event handling of changing tab
	 * Activating tab for selected
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- Important logic --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
	}
	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
		retArray=MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);
		if(retArray == null){
			return false;
		} else {
			return true;
		}
	}
	/**
	 * Validating process for input form data
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction == COMMAND01)
			{
				if(sheetObj.LastRow()< 1) {
					return false;
				}
				var sParam1=sheetObj.GetSaveString(true, true);
				if(sParam1=="")
				{
					return false;
				}
				var Row=sheetObj.ColValueDup("rqst_eq_no",false);
				if(Row>0){
					ComShowCodeMessage("MNR00006",(Row) + " row ");
					sheetObj.SelectCell(Row, "rqst_eq_no", true);
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Event handling of OnChange of sheet1
	 *
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname=ColSaveName(Col);
			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);
			}
			//EQ No
			else if(colname == 'rqst_eq_no') {
				setEqNoInfo(sheetObj,Row,Col);
				var lstmCd=sheetObj.GetCellValue(Row, "lstm_cd");
				if(lstmCd!="OW" && lstmCd!="LP" && lstmCd!="OL") {
					sheetObj.SetCellValue(Row, "dpc_val_amt",0.00);
				}
			}
			//Yard Cd
			else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,Col);
				}
			}
		}
	}
function sheet1_OnLoadFinish(sheetObj) {
		doActionIBSheet(sheetObj,document.form,IBCLEAR);
		getParent_0097(sheetObj,document.form);
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){
			ComShowCodeMessage("MNR00119");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;
		}
		var rqstEqNo=sheetObj.GetCellValue(Row, "rqst_eq_no");
		var eqKndCd=sheetObj.GetCellValue(Row, "eq_knd_cd");
		var totalLossDate=ComGetNowInfo("ymd");
		var retArray=MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var formObj=document.form;
		var sCostType="";
		if(eqKndCd == "U"){
			sCostType="MRDRRC";
		} else if(eqKndCd == "G"){
			sCostType="MRGSRC";
		} else {
			sCostType="MRZSRC";
		}
		var sXml=MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr=MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt
		if(retArr == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd=retArr[0][31];	//TP/SZ
		var dpcValAmt=retArr[0][10];	//DV.Value
		var lessorNm=retArr[0][16];	//Lessor
		var lstmCd=retArr[0][19];	//Term
		var ydCd=retArr[0][18];	//Yard
		var lessorCd	= retArr[0][42];	//Lessor Code
		
		var ttlNo=ComGetObjValue(formObj.ttl_lss_no);
		if(MnrNullToBlank(ttlNo) == ''){
			ttlNo='XXXXX-999999-999';
		}
		var retArray=MnrGeneralCodeCheck(sheetObj,"TTLEQN",rqstEqNo+","+eqKndCd+","+eqTpszCd+","+ttlNo);
		if(retArray == null){
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");
			sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}else{
			if(retArray[0].split("|")[1]!="OK"){
				ComShowCodeMessage("MNR00311");
				sheetObj.SetCellValue(Row,"rqst_eq_no","",0);
				sheetObj.SelectCell(Row, "rqst_eq_no");
				setEqNoInfoClear(sheetObj,Row,Col);
				return;
			}
		}
		sheetObj.SetCellValue(Row,"eq_tpsz_cd",eqTpszCd,0);//TP/SZ
		sheetObj.SetCellValue(Row,"lstm_cd",lstmCd,0);//Term
		sheetObj.SetCellValue(Row,"ttl_lss_yd_cd",ydCd,0);//Yard
		if(sheetObj.id == "sheet1") {
			if(loadExcelFlg == "N"){
				sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
				sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt,0);//Pay Amount
			}else{
				if(sheetObj.GetCellValue(Row, "dpc_val_amt") == ""||sheetObj.GetCellValue(Row, "dpc_val_amt") == "0.00"){
					sheetObj.SetCellValue(Row,"dpc_val_amt",dpcValAmt,0);//DV.Value
					sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt,0);//Pay Amount
				}
				
			}
			sheetObj.SetCellValue(Row,"lessor_nm",lessorNm,0);//Lessor
//			sheetObj.SetCellValue(Row,"ttl_lss_bil_amt",dpcValAmt,0);//Pay Amount
			sheetObj.SetCellValue(Row, "mnr_prnr_seq", lessorCd, 0);
			
			var invNo=sheetObj.GetCellValue(Row, "inv_no");
			var ofcCd=formObj.rqst_ofc_cd.value;
			var yymm=totalLossDate.substring(2,7).split("-").join("");
			invNo=yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
			sheetObj.SetCellValue(Row, "inv_no",invNo);
		}
	}
	/**
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.SetCellValue(Row,"eq_tpsz_cd","",0);//TP/SZ
		if(sheetObj.id == "t1sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
			sheetObj.SetCellValue(Row,"lessor_nm","",0);//Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.SetCellValue(Row,"dpc_val_amt","",0);//DV.Value
		}
	}
	
	function sheet1_OnLoadExcel(sheetObj, result, code, msg){
		if(isExceedMaxRow(msg))return;
		
		for(var i = 1 ; i < sheetObj.LastRow()+1 ; i++){
			if(sheetObj.GetCellValue(i, "eq_knd_cd") == ""){
				sheetObj.RemoveAll();
				ComShowMessage("[Row : "+ i + " ]"+ComGetMsg("MNR00119"));
				return;
			}
			
			if(sheetObj.GetCellValue(i, "rqst_eq_no") == ""){
				sheetObj.RemoveAll();
				ComShowMessage("[Row : "+ i + " ]"+ComGetMsg("MNR00005", "EQ No"));
				return;
			}
			
			setEqNoInfo(sheetObj,i,sheetObj.GetCellValue(i, "rqst_eq_no"));
			var lstmCd=sheetObj.GetCellValue(i, "lstm_cd");
//			if(lstmCd!="OW" && lstmCd!="LP" && lstmCd!="OL") {
//				sheetObj.SetCellValue(i, "dpc_val_amt",0.00);
//			}
			if(sheetObj.GetCellValue(i, "dpc_val_amt") == ""){
				sheetObj.SetCellValue(i, "dpc_val_amt",0.00);
			}
			sheetObj.SetCellValue(i, "ttl_lss_no",ComGetObjValue(document.form.ttl_lss_no),0);
			//Setting mnr_inv_tp_cd
			sheetObj.SetCellValue(i, "mnr_inv_tp_cd","DV",0);
			sheetObj.SetCellValue(i, "ttl_lss_n3pty_tp_cd","",0);
			sheetObj.SetCellValue(i, "ttl_lss_dtl_sts_cd","",0);
			sheetObj.SetCellValue(i, "ttl_lss_plc_nm","",0);
			//Initializing value of sheet combo
			sheetObj.SetCellValue(i, "curr_cd","USD",0);//CURR
		}
		loadExcelFlg = "N";
	}
