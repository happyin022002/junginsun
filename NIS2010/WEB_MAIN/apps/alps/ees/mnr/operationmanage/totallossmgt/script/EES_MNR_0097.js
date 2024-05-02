﻿	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_mnr_0097.js 
	 *@FileTitle : Total Loss EQ Add - Pop Up
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.12.02
	 *@LastModifier : 권영법
	 *@LastVersion : 1.0
	 * 2009.08.18 권영법
	 * 1.0 Creation
	 * --------------------------------------------------------
	 * 2011.06.09 김민수 [CHM-201111285-01] [MNR] Total Loss 의 TPB No 칸은 삭제 요청
	=========================================================*/
	//공통전역변수
					
	var tabObjects = new Array();
	var tabCnt = 0 ;
	var beforetab = 1;
	
	var sheetObjects = new Array();
	var sheetCnt = 0;
	
	var comboObjects = new Array();
	var comboCnt = 0;  
	
	
	//검증작업을 한데이타만 부모화면으로 이동가능
	var retComboVal = "";  
	//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
	document.onclick = processButtonClick;
	
	//버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
	function processButtonClick(){
		/***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
	
		var sheetObject = sheetObjects[0];
	
		/*******************************************************/
		var formObject = document.form;
	
		try {
			var srcName = window.event.srcElement.getAttribute("name");
	
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
				self.close();  
				break;   
	
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	/** 
	 * IBCombo Object를 배열로 등록
	 * @param	{IBMultiCombo}	combo_obj	화면에서 사용할 콤보들을 추가한다. 
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */ 
	function setComboObject(combo_obj){     
		comboObjects[comboCnt++] = combo_obj;  
	}   
	
	/**
	 * IBSheet Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setSheetObject(sheet_obj){
	
		sheetObjects[sheetCnt++] = sheet_obj;
	
	} 
	
	/**
	 * IBTab Object를 배열로 등록
	 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
	 * 배열은 소스 상단에 정의
	 */
	function setTabObject(tab_obj){
		tabObjects[tabCnt++] = tab_obj;
	}
	/**
	 * Total Loss 화면단에서 값 얻어오기
	 */
	function getParent_0097(targetSheet,formObj) {

		var sourceSheet=null;
		if(window.dialogArguments != undefined)
		{
			var sourceSheetDv,sourceSheetTp,sourceSheetDs,sourceSheetSc,sourceSheetIr=null; //sourceSheet
			var dAr=window.dialogArguments;
			var ix=(formObj.work_type.value=="request")?0:1;
			//Sheet Exist Setting
			if(dAr.sheetObjects[++ix]!=undefined) sourceSheetDv=dAr.sheetObjects[ix]; //D.V Expense
			if(dAr.sheetObjects[++ix]!=undefined) sourceSheetTp=dAr.sheetObjects[ix]; //3rd Party
			if(dAr.sheetObjects[++ix]!=undefined) sourceSheetDs=dAr.sheetObjects[ix]; //Disposal
			if(dAr.sheetObjects[++ix]!=undefined) sourceSheetSc=dAr.sheetObjects[ix]; //Scrapping
			if(dAr.sheetObjects[++ix]!=undefined) sourceSheetIr=dAr.sheetObjects[ix]; //Insurance
			sourceSheet=[sourceSheetDv,sourceSheetTp,sourceSheetDs,sourceSheetSc,sourceSheetIr];
			
		}else{
			return;
		}
		var mnrInvTpCd=["DV","TP","DS","SC","IR"]; //[D.V Expense,3rd Party,Disposal,Scrapping,Insurance]
		for(var i=0; i<sourceSheet.length; i++) 
		{
			if(sourceSheet[i].RowCount <=0){
				sourceSheet[i].RemoveAll();  
			}
		}
		//D.V Expense 값 얻어와서 쉬트에 넣기
		for( var i=0;i<sourceSheet.length;i++)
		{
			if(i==0){
				for(var j=sourceSheet[i].HeaderRows; j<=sourceSheet[i].LastRow; j++) 
				{
					if(sourceSheet[i].CellValue(j,"seq")!=0 && sourceSheet[i].CellValue(j,"ibflag")!="D")
					{
						var row = targetSheet.DataInsert(-1);
				        for (ic = 0; ic<=sourceSheet[i].LastCol; ic++) 
				        {
					        //target paste
				        	if(targetSheet.SaveNameCol(sourceSheet[i].ColSaveName(ic)) > -1)
				        		targetSheet.CellValue2(row, sourceSheet[i].ColSaveName(ic)) = sourceSheet[i].CellValue(j, sourceSheet[i].ColSaveName(ic));
				        	if(sourceSheet[i].ColSaveName(ic)=="rqst_eq_no")
				        		targetSheet.CellValue2(row,"org_eq_no")=sourceSheet[i].CellValue(j, sourceSheet[i].ColSaveName(ic));
				        } 
					}
				}
		        break;
			}
		}
		//D.V Expense 값 얻어와서 쉬트에 넣은 값을 각 해당 텝 EN_NO에 존재하면 플레그 체크하기
		for(var i=targetSheet.HeaderRows; i<=targetSheet.LastRow; i++) 
		{
			var rqstEqNo=targetSheet.CellValue(i,"org_eq_no"); //EQ NO

			for( var j=1;j<sourceSheet.length;j++)
			{	
				var row=sourceSheet[j].FindText("rqst_eq_no", rqstEqNo);
				if(row != -1)
				{
					if(sourceSheet[j].CellValue(row,"ibflag")!="D")
					{
						if(mnrInvTpCd[j]=="TP")     targetSheet.CellValue2(i,"tp_chk")="1";
					    else if(mnrInvTpCd[j]=="DS") targetSheet.CellValue2(i,"ds_chk")="1";
						else if(mnrInvTpCd[j]=="SC") targetSheet.CellValue2(i,"sc_chk")="1";
						else if(mnrInvTpCd[j]=="IR") targetSheet.CellValue2(i,"ir_chk")="1";
					}
				}
			}
		}
	}   
	
	/**
	 * 추가로 넘겨야 될값이 많아서 따로 구현한다.
	 */
	function comPopupOK_0097(fromSheet,formObj,sAction) {
 		MnrWaitControl(true);
		var targetSheet=null;
		if(window.dialogArguments != undefined)
		{
			var targetSheetDv,targetSheetTp,targetSheetDs,targetSheetSc,targetSheetIr=null; //targetSheet
			var dAr=window.dialogArguments;
			var ix=(formObj.work_type.value=="request")?0:1;
			//Sheet Execist Setting
			if(dAr.sheetObjects[++ix]!=undefined) targetSheetDv=dAr.sheetObjects[ix]; //D.V Expense
			if(dAr.sheetObjects[++ix]!=undefined) targetSheetTp=dAr.sheetObjects[ix]; //3rd Party
			if(dAr.sheetObjects[++ix]!=undefined) targetSheetDs=dAr.sheetObjects[ix]; //Disposal
			if(dAr.sheetObjects[++ix]!=undefined) targetSheetSc=dAr.sheetObjects[ix]; //Scrapping
			if(dAr.sheetObjects[++ix]!=undefined) targetSheetIr=dAr.sheetObjects[ix]; //Insurance
			targetSheet=[targetSheetDv,targetSheetTp,targetSheetDs,targetSheetSc,targetSheetIr];

		}else{
			sheetObj.WaitImageVisible=true;
			MnrWaitControl(false);  
			return;
		}
		//확인입력
		var ibFlag,rqstEqNo="";
		var dvChk="1"; //DV Expense
		var tpChk,dsChk,scChk,irChk="0"; //3rd Party,Disposal,Scrapping,Insurance
		var mnrInvTpCd=["DV","TP","DS","SC","IR"];
		for(var i=0; i<targetSheet.length; i++) 
		{
			if(targetSheet[i].RowCount <=0){
				targetSheet[i].RemoveAll();  
			}
		}
		with(fromSheet)
		{
			for(var i=HeaderRows; i<=LastRow; i++) 
			{
				ibFlag  =CellValue(i,"ibflag");    //ROW Status
				rqstEqNo=CellValue(i,"org_eq_no"); //EQ NO
				tpChk   =CellValue(i,"tp_chk"); //3rd Party
				dsChk   =CellValue(i,"ds_chk"); //Disposal
				scChk   =CellValue(i,"sc_chk"); //Scrapping
				irChk   =CellValue(i,"ir_chk"); //Insurance
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
								row = targetSheet[j].DataInsert(-1);
	
						        //target paste
						        for (var ic = 0; ic<=LastCol; ic++) 
						        {
						        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
						        	{
						        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
						        		{
							        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
						        			{
//							        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//							        			{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//							        			}
						        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
						        			{
							        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
							        			{
							        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
							        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
							        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
							        			}
						        			}else if(j==1 && ColSaveName(ic)=="inv_no")
						        			{
							        			var invNo=CellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"T";
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
						        			}else if(j==2 && ColSaveName(ic)=="inv_no")
						        			{
							        			var invNo=CellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"S";
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
						        			}else{
						        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
						        			}
						        		}
						        	}
						        } 
						        targetSheet[j].RowStatus(row)="I";
						        targetSheet[j].CellValue2(row, "mnr_inv_tp_cd") = mnrInvTpCd[j];
							}else{
								if(targetSheet[j].CellValue(row, "ibflag")=="D")
								{
									targetSheet[j].RowHidden(row)= false;		//행 살리기
							        for (var ic = 0; ic<=LastCol; ic++) 
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
//								        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//								        			{
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
								        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
								        			{
								        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
								        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
								        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
								        			}								        			
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
							        			}else{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
							        			}
							        		}
							        	}
							        } 
									targetSheet[j].CellValue2(row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
									targetSheet[j].RowStatus(row)= "U";
								}else{
							        for (var ic = 0; ic<=LastCol; ic++) 
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
//								        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//								        			{
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
								        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
								        			{
								        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
								        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
								        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
							        			}else{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
							        			}
							        		}
							        	}
							        } 
									targetSheet[j].CellValue2(row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
									targetSheet[j].RowStatus(row)= "U";
						        }
						        targetSheet[j].CellValue2(row, "mnr_inv_tp_cd") = mnrInvTpCd[j];
							}
						}else{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].CellValue(row,"ibflag")!="D")
								{
									targetSheet[j].CellValue(row,"del_chk")="1";
									ComRowHideDelete(targetSheet[j], "del_chk");
								}
							}
						}
						targetSheet[j].RedrawSum = true;	//합계 계산하기
					}
				}else if(ibFlag== "D")
				{
					for(var j=0;j<tpAr.length;j++)
					{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].CellValue(row,"ibflag")!="D")
								{
								targetSheet[j].CellValue(row,"del_chk")="1";
								ComRowHideDelete(targetSheet[j], "del_chk");
								}
								
							}
							targetSheet[j].RedrawSum = true;	//합계 계산하기
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
								var row = targetSheet[j].DataInsert(-1);
	
						        //target paste
						        for (ic = 0; ic<=LastCol; ic++) 
						        {
						        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
						        	{
						        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
						        		{
							        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
						        			{
//							        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//							        			{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//							        			}
						        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
						        			{
							        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
							        			{
							        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
							        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
							        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
							        			}
						        			}else if(j==1 && ColSaveName(ic)=="inv_no")
						        			{
							        			var invNo=CellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"T";
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
						        			}else if(j==2 && ColSaveName(ic)=="inv_no")
						        			{
							        			var invNo=CellValue(i, ColSaveName(ic));
							        				invNo.substring(0,invNo.length-1)+"S";
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
						        			}else{
						        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
						        			}
						        		}
						        	}
						        } 
								targetSheet[j].CellValue2(row, "mnr_inv_tp_cd") = mnrInvTpCd[j];
								targetSheet[j].CellValue2(row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
								targetSheet[j].CellValue2(row, "curr_cd") 			= "USD";	//CURR
							}else{
								
								if(targetSheet[j].CellValue(row, "ibflag")=="D")
								{
									targetSheet[j].RowHidden(row)= false;		//행 살리기
							        for (var ic = 0; ic<=LastCol; ic++) 
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
//								        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//								        			{
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
								        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
								        			{
								        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
								        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
								        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
							        			}else{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
							        			}
							        		}
							        	}
							        } 
									targetSheet[j].CellValue2(row, "mnr_inv_tp_cd") = mnrInvTpCd[j];
									targetSheet[j].CellValue2(row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
									targetSheet[j].CellValue2(row, "curr_cd") 			= "USD";	//CURR
									targetSheet[j].RowStatus(row)= "U";
									targetSheet[j].RedrawSum = true;	//합계 계산하기
								}else{
							        for (var ic = 0; ic<=LastCol; ic++) 
							        {
							        	if(targetSheet[j].SaveNameCol(ColSaveName(ic)) > -1)
							        	{
							        		if(!(j>0 && ColSaveName(ic)=="ttl_lss_bil_amt"))
							        		{
								        		if(j==0 && ColSaveName(ic)=="ttl_lss_bil_amt")
							        			{
//								        			if(CellValue(i, ColSaveName(ic))=="" || CellValue(i, ColSaveName(ic))=="0" )
//								        			{
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, "dpc_val_amt");
//								        			}
							        			}else if(ColSaveName(ic)=="mnr_prnr_seq")
							        			{
								        			if(j==0 && CellValue(i, ColSaveName(ic))=="")
								        			{
								        				targetSheet[j].CellValue2(row, "payer_code") = "195013";
								        				targetSheet[j].CellValue2(row, "payer_name") = "EQ Operation Team";
								        				targetSheet[j].CellValue2(row, "mnr_prnr_seq") = "195013";
								        			}
							        			}else if(j==1 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"T";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"T";
							        			}else if(j==2 && ColSaveName(ic)=="inv_no")
							        			{
								        			var invNo=CellValue(i, ColSaveName(ic));
								        				invNo.substring(0,invNo.length-1)+"S";
								        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = invNo.substring(0,invNo.length-1)+"S";
							        			}else{
							        				targetSheet[j].CellValue2(row, ColSaveName(ic)) = CellValue(i, ColSaveName(ic));
							        			}
							        		}
							        	}
							        } 
						        }
						        targetSheet[j].CellValue2(row, "mnr_inv_tp_cd") = mnrInvTpCd[j];
							}
						}else{
							var row=targetSheet[j].FindText("rqst_eq_no", rqstEqNo);
							if(row != -1)
							{
								if(targetSheet[j].CellValue(row,"ibflag")!="D")
								{
									targetSheet[j].CellValue(row,"del_chk")="1";
									ComRowHideDelete(targetSheet[j], "del_chk");
								}
							}
						}
						targetSheet[j].RedrawSum = true;	//합계 계산하기
					}
				}
			}
		}
		window.dialogArguments.setCalculateTotalSum();
 		MnrWaitControl(false);
		window.close();                 
	}   
	/**
	 * Sheet 기본 설정 및 초기화
	 * body 태그의 onLoad 이벤트핸들러 구현
	 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
	 */
	function loadPage() {
	
	
		var formObject=document.form;
		if(window.dialogArguments != undefined)
		{
	
			//hidden Text Setting
			if(window.dialogArguments.document.form.rqst_ofc_cd!=undefined)
			{
				formObject.rqst_ofc_cd.value=window.dialogArguments.document.form.rqst_ofc_cd.value;
	
			}
	
			//hidden Text Setting
			if(window.dialogArguments.document.form.ttl_lss_no!=undefined)
			{
				formObject.ttl_lss_no.value=window.dialogArguments.document.form.ttl_lss_no.value;
	
			}
			//hidden Text Setting
			if(window.dialogArguments.document.form.work_type!=undefined)
			{
				formObject.work_type.value=window.dialogArguments.document.form.work_type.value;
	
			}
		}

	
		MnrWaitControl(true); 
		for(i=0;i<sheetObjects.length;i++){
	
			//khlee-시작 환경 설정 함수 이름 변경
			ComConfigSheet (sheetObjects[i] );
	
			initSheet(sheetObjects[i],i + 1);
			//khlee-마지막 환경 설정 함수 추가
			ComEndConfigSheet(sheetObjects[i]);
	
			//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
		}
	
		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k + 1);
		}   
	
	
	}
	
	
	
	/**
	 * 시트 초기설정값, 헤더 정의
	 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
	 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
	 */
	function initSheet(sheetObj,sheetNo) {
	
		var cnt = 0;
	
		switch(sheetNo) {
		case 1:      //t1sheet1 init
		with (sheetObj) { 
	
			// 높이 설정  
			style.height = 282;
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;
	
			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	
			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msPrevColumnMerge;
	
			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;
	
			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			InitRowInfo(1, 1, 6, 100);
	
			var HeadTitle1 =  "|Sel|Seq|EQ Type|EQ No.|TP/SZ|Term|Yard|DV.Value|3rd Party|Disposal";
			HeadTitle1 += "|lessor_nm|Invoice No._inv_no|CURR_curr_cd|Pay Amount_ttl_lss_bil_amt|EQ Status_ttl_lss_dtl_sts_cd";
			HeadTitle1 += "|ttl_lss_no|ttl_lss_plc_nm|org_eq_no|mnr_prnr_seq";
	
			var headCount = ComCountHeadTitle(HeadTitle1);
	
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
	
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, true, true, false,false)
	
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
	
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0,	cnt++ ,	dtHiddenStatus,	30,		daCenter,	false,	"ibflag");
			InitDataProperty(0, cnt++ , dtDummyCheck,	40,		daCenter,	true,	"del_chk",				false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtSeq,			35,		daCenter,	true,	"seq");
			InitDataProperty(0, cnt++ , dtCombo,		70,		daLeft,		true,	"eq_knd_cd",			true,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtData,			95,		daCenter,	true,	"rqst_eq_no",			true,	"",	dfNone,			0,	true,	true,	14);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"eq_tpsz_cd",			true,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			50,		daCenter,	true,	"lstm_cd",				true,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,			55,		daCenter,	true,	"ttl_lss_yd_cd",		true,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtData,			95,		daRight,	true,	"dpc_val_amt",			true,	"",	dfNullFloat,	2,	true,	true,	13);
			InitDataProperty(0, cnt++ , dtCheckBox,     65,     daCenter,   true,   "tp_chk",     		false,	"", 	dfNone,		0, 	true,  	true,1,false,true,"",false);
			InitDataProperty(0, cnt++ , dtCheckBox,     65,     daCenter,   true,   "ds_chk",     		false,	"", 	dfNone,		0, 	true,  	true,1,false,true,"",false);
			//InitDataProperty(0, cnt++ , dtCheckBox,     65,     daCenter,   true,   "sc_chk",     		false,	"", 	dfNone,		0, 	true,  	true,1,false,true,"",false);
			//InitDataProperty(0, cnt++ , dtCheckBox,     65,     daCenter,   true,   "ir_chk",     		false,	"", 	dfNone,		0, 	true,  	true,1,false,true,"",false);
			//Hidden
			InitDataProperty(0, cnt++ , dtHidden,		145,	daLeft,		true,	"lessor_nm",			false,	"",	dfNone,			0,	false,	false);
			InitDataProperty(0, cnt++ , dtHidden,		140,	daCenter,	true,	"inv_no",				false,	"",	dfNone,			0,	true,	true,	20);
			InitDataProperty(0, cnt++ , dtHidden,		50,		daCenter,	true,	"curr_cd",				false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,	    90,		daRight,	true,	"ttl_lss_bil_amt",		false,	"",	dfNullFloat,	2,	true,	true,	13);
			InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		true,	"ttl_lss_dtl_sts_cd",	false,	"",	dfNone,			0,	true,	true);

			InitDataProperty(0, cnt++ , dtHidden,		30,		daLeft,		true,	"ttl_lss_no");
			InitDataProperty(0, cnt++ , dtHidden,		60,		daLeft,		true,	"ttl_lss_plc_nm",	    false,	"",	dfNone,			0,	true,	true);
			InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"org_eq_no",			false,	"",	dfNone,			0,	true,	true,	14);
			InitDataProperty(0, cnt++ , dtHidden,		95,		daCenter,	true,	"mnr_prnr_seq");

			
			//데이터 Validation
			InitDataValid(0,  "rqst_eq_no", vtEngUpOther,"0123456789");  
			InitDataValid(0,  "inv_no", vtEngUpOther,"0123456789");  
			InitDataValid(0,  "ttl_lss_yd_cd", vtEngUpOther,"0123456789");         
			CountPosition = 0;             
		}
		break;  
		}  
	}
	
	/**
	 * 쉬트 콤보 데이티 조회 및 설정
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 */
	function initSheetCombo() {
		//쉬트 조회
		var sCondition = new Array (
			new Array("MnrGenCd","SELHO","CUSTOM9")		//Eq Kind
		)
		var comboList = MnrComSearchCombo(sheetObj,sCondition);
		//쉬트 설정
		var sheetComboText = "";
		var sheetComboCode = "";
		var sheetComboCodeText = "";
		var sheetComboDefault = "";
		for(var i=0; i<comboList.length; i++) {				
			//쉬트콤보별 초기화
			sheetComboText = "";
			sheetComboCode = "";
			sheetComboCodeText = "";
			sheetComboDefault = ""; 
			for(var j=0; j<comboList[i].length; j++){
				var tempText = comboList[i][j].split("|");    
	
				sheetComboText +=  tempText[1] + "|";
				sheetComboCode +=  tempText[0] + "|";
				sheetComboCodeText +=  tempText[0] + "\t" + tempText[1] + "|";
				if(j ==0){	
					sheetComboDefault = tempText[0];      	
				}
			}

			if(i==0)
			{
				sheetObjects[0].InitDataCombo (0, "eq_knd_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
			}
		}
	}
	
	
	// Sheet관련 프로세스 처리
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg = false;
		var formObj=document.form;
		switch(sAction) {
		case IBINSERT:  // ROWADD                   
			var Row = sheetObj.DataInsert(-1); 
			//Total Loss No 설정
			sheetObj.CellValue2(Row, "ttl_lss_no") = ComGetObjValue(formObj.ttl_lss_no);
			//mnr_inv_tp_cd 설정
			sheetObj.CellValue2(Row, "mnr_inv_tp_cd")      = "DV";
			sheetObj.CellValue2(Row, "ttl_lss_n3pty_tp_cd")= "";
			sheetObj.CellValue2(Row, "ttl_lss_dtl_sts_cd") = "";
			sheetObj.CellValue2(Row, "ttl_lss_plc_nm") = "";
			
			//그리드 콤보 값 초기화
			sheetObj.CellValue2(Row, "curr_cd") 		   = "USD";	//CURR                     
			break; 
		
		case IBDELETE:  // ROWDELETE   
			ComRowHideDelete(sheetObj, "del_chk");          
			break;
		case IBCLEAR: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
			MnrWaitControl(true);
			sheetObj.WaitImageVisible=false;
			//쉬트 초기화
			initSheetCombo();
			sheetObj.WaitImageVisible=true;
			
			MnrWaitControl(false);  
			break; 		
		case COMMAND01: //  콤보 데이터 조회 및 모든 쉬트를 초기화 
			MnrWaitControl(true);
			if(validateForm(sheetObj,formObj,sAction)) {
				sheetObj.WaitImageVisible=false;
				comPopupOK_0097(sheetObj,formObj,sAction);
				//쉬트 초기화
				sheetObj.WaitImageVisible=true;
			}
			MnrWaitControl(false);  
		break; 	
		}
	}
	
	/**
	 * Tab 클릭시 이벤트 관련
	 * 선택한 탭의 요소가 활성화 된다.
	 */
	function tab1_OnChange(tabObj , nItem)
	{
		var objs = document.all.item("tabLayer");
	
		objs[nItem].style.display = "Inline";
		objs[beforetab].style.display = "none";
	
		//--------------- 요기가 중요 --------------------------//
		objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab= nItem;
	}
	
	 
	//YARD Check
	function ttl_lss_yd_cd_Check(checkYard){
	
		retArray = MnrGeneralCodeCheck(sheetObjects[0],"YARD",checkYard);      
		if(retArray == null){        
			return false;
		} else {    
			return true;    
		}   
	}
	
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			if(sAction == COMMAND01)
			{
				//데이타존재여부
				if(sheetObj.LastRow < 1) {
					return false;
				}
				//시트 Mendentory 체크
				var sParam1 = sheetObj.GetSaveString(true, true);
				if(sParam1=="")
				{
					return false;
				}
				// EQ_NO중복체크
				var Row = sheetObj.ColValueDup("rqst_eq_no",false);
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
	 * 셀의 값 변경시 발생하는 Event
	 *     EQ No 를 변경함에 따라 TP/SZ, DV.Value, Lessor을 재설정한다.
	 * 
	 * @param	{IBSheet}	sheetObj	시트오브젝트
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 * @param	{String}	Val			Value
	 */
	function sheet1_OnChange(sheetObj,Row,Col,Value) {
		with(sheetObj) {
			var colname = ColSaveName(Col);
			//EQ Type
			if(colname == 'eq_knd_cd') {
				sheetObj.CellValue2(Row,"rqst_eq_no")="";
				sheetObj.CellValue2(Row,"eq_tpsz_cd")="";
			} 	
			//EQ No
			else if(colname == 'rqst_eq_no') {	
				setEqNoInfo(sheetObj,Row,Col);		
				var lstmCd = sheetObj.CellValue(Row, "lstm_cd");
				if(lstmCd!="OW" && lstmCd!="LP" && lstmCd!="OL") {
					sheetObj.CellValue(Row, "dpc_val_amt") = 0.00;
				}		
			}
			//Yard Cd
			else if(colname == 'ttl_lss_yd_cd') {
				if(!ttl_lss_yd_cd_Check(Value))
				{
					ComShowCodeMessage("MNR00165",Value,"YARD");   
					sheetObj.CellValue2(Row,Col) = "";
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
	 * EQ No 값을 변경함에 따라 TP/SZ, DV.Value, Lessor 값을 재설정한다.
	 *  
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfo(sheetObj,Row,Col) {
		//EQ_TYPE 선택유무 체크 
		var eqKndCd = sheetObj.CellValue(Row, "eq_knd_cd");
		if(eqKndCd == ""){	
			ComShowCodeMessage("MNR00119"); 
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "eq_knd_cd");
			return;	   	 
		} 
		//EQ No 존재유무 체크
		var rqstEqNo 		= sheetObj.CellValue(Row, "rqst_eq_no"); 
		var eqKndCd 		= sheetObj.CellValue(Row, "eq_knd_cd");
		var totalLossDate	= ComGetNowInfo("ymd");
		var retArray = MnrGeneralCodeCheck(sheetObj,"EQN",rqstEqNo+","+eqKndCd);      
		if(retArray == null){ 	          
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");          				
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return; 	     	          
		} 
		//EQ No 관련 항목 조회
		var formObj = document.form;
		var sCostType = "";
		if(eqKndCd == "U"){
			sCostType = "MRDRRC";	
		} else if(eqKndCd == "G"){
			sCostType = "MRGSRC";		
		} else {
			sCostType = "MRZSRC";   
		}	
		var sXml = MnrComEqGenInfoSearch(sheetObj,eqKndCd,rqstEqNo,totalLossDate,sCostType);
		var retArr =  MnrXmlToArray(sXml);
		//0 imm_ext|1 mdl_nm|2 mvmt_dt|3 dv_cur|4 rpr_yd|5 sp_name|6 flg_rmk|7 manu_dt|8 mkr_nm|9 pagerows|10 dv_value|11 ibflag|12 off_hire|13 mvmt_cd|14 dsp_flag|15 hngr_flg_yd|16 lessor_nm|17 hngr_rck_cd|18 crnt_yd_cd|19 lstm_cd|20 eq_no|21 hngr_flg_dt|22 bar_atch_knt|23 status|24 bar_tp_cd|25 dmg_flag|26 cost|27 mtrl_cd|28 eq_type|29 mtrl_nm|30 rpr_type|31 eq_tpsz_cd|32 rpr_dt  						
		if(retArr == null){    
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");  
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return;
		}
		var eqTpszCd 	= retArr[0][31];	//TP/SZ
		var dpcValAmt	= retArr[0][10];	//DV.Value
		var lessorNm	= retArr[0][16];	//Lessor Name
		var lstmCd		= retArr[0][19];	//Term
		var ydCd		= retArr[0][18];	//Yard
					
		//NULL 이면 에러발생 널일경우 아무값이나 넣어줌 2010-06-01
		var ttlNo = ComGetObjValue(formObj.ttl_lss_no);
		if(MnrNullToBlank(ttlNo) == ''){			
			ttlNo = 'XXXXX-999999-999';									  			
		}	 				     
		var retArray = MnrGeneralCodeCheck(sheetObj,"TTLEQN",rqstEqNo+","+eqKndCd+","+eqTpszCd+","+ttlNo);      
		if(retArray == null){ 	          
			ComShowCodeMessage("MNR00165",rqstEqNo,"EQ No.");          				
			sheetObj.CellValue2(Row,"rqst_eq_no") = "";
			sheetObj.SelectCell(Row, "rqst_eq_no");
			setEqNoInfoClear(sheetObj,Row,Col);
			return; 	     	          
		}else{		
			if(retArray[0].split("|")[1]!="OK"){
				ComShowCodeMessage("MNR00311");   
				sheetObj.CellValue2(Row,"rqst_eq_no") = "";
				sheetObj.SelectCell(Row, "rqst_eq_no");
				setEqNoInfoClear(sheetObj,Row,Col);
				return;
			}
		}
				
		//EQ No 관련 항목 설정
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = eqTpszCd;	//TP/SZ
		sheetObj.CellValue2(Row,"lstm_cd") 		= lstmCd;  	//Term
		sheetObj.CellValue2(Row,"ttl_lss_yd_cd")= ydCd;  	//Yard
		if(sheetObj.id == "sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt")		= dpcValAmt;	//DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") 		= lessorNm;  	//Lessor Name
			sheetObj.CellValue2(Row,"ttl_lss_bil_amt")  = dpcValAmt;  	//Pay Amount
			//Invoice No가 없을 경우
			var invNo = sheetObj.CellValue(Row, "inv_no");
			var ofcCd = formObj.rqst_ofc_cd.value;
			var yymm  = totalLossDate.substring(2,7).split("-").join("");
			invNo = yymm+""+ofcCd.substring(0,3)+"-"+rqstEqNo+""+"D";
			sheetObj.CellValue(Row, "inv_no") = invNo;
		}
	}
	
	/**
	 * EQ No 존재하지 않을 때, 관련정보 삭제
	 * 
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 * @return
	 */
	function setEqNoInfoClear(sheetObj,Row,Col){
		sheetObj.CellValue2(Row,"eq_tpsz_cd") = ""; //TP/SZ
	
		if(sheetObj.id == "t1sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
			sheetObj.CellValue2(Row,"lessor_nm") = "";   //Lessor
		} else if(sheetObj.id == "t2sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value 
		}else if(sheetObj.id == "t5sheet1") {
			sheetObj.CellValue2(Row,"dpc_val_amt") = ""; //DV.Value
		} 
	}    	
