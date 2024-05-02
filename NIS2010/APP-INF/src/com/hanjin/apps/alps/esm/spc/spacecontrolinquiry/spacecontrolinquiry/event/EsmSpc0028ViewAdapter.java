/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0028ViewAdapter.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.12 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.07.05 김종준 [CHM-201111880-01]  control by HO 화면 보완 - IPC, TS 관련
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.31 [CHM-201431081] SPC Allocation Control Option 추가 보완
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;

/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0028ViewAdapter extends ViewAdapter{
	

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) 
	{
		StringBuilder sbufXML = new StringBuilder();
		ComplexMainVO complexMainVO = (ComplexMainVO)vos.get(0);
		int rowCount	 = 0;
		if( complexMainVO.getEventCommand().equals("SEARCHLIST01")){	//2.1
			
			List<SearchSpaceControlInquiryOfficeListVO> viewList = new ArrayList<SearchSpaceControlInquiryOfficeListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryOfficeListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
			
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getTrdCd())+"</TD>\n");
					sbufXML.append("<TD INDENT='1'>"+JSPUtil.getNull(viewList.get(i).getSubTrdCd())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getRlaneCd())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getDirCd())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getCostWk())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getVvd())+"</TD>\n");
					
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getQtaVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getQtaCmb())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctTcVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctTcWgt())+"</TD>\n");
					
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcTsVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcTsWgt())+"</TD>\n");


//					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgFirm())+"</TD>\n");
//					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgWait())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgVolVgm())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgWgtVgm())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsVolVgm())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsWgtVgm())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getRatio())+"</TD>\n");
					
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n"); 
	
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST02")){	//2.1
		
			List<SearchSpaceAllocationControlFlagListVO> flagList = new ArrayList<SearchSpaceAllocationControlFlagListVO>();
			flagList = complexMainVO.getSearchSpaceAllocationControlFlagListVO();
			
			String ctrl_port = "";
			boolean ctrl_wgt = false;
			boolean ctrl_40hc = false;
			boolean ctrl_45hc = false;
			boolean ctrl_ft53 = false;
			boolean ctrl_rf = false;
//			int view_level = 1;
			
			boolean ctrl_d2 = false;
			boolean ctrl_d4 = false;
			boolean ctrl_rd = false;
			
			boolean ctrl_acct = false;
			boolean ctrl_usa = false;
			
			//rowSet = rowSets[0];
			if(flagList != null) {//4.1
				for(int h=0;h<flagList.size();h++){
					ctrl_port = flagList.get(h).getPolPod();
					ctrl_wgt = flagList.get(h).getWeight().equals("Y");
					ctrl_40hc = flagList.get(h).getHc40().equals("Y");
					ctrl_45hc = flagList.get(h).getHc45().equals("Y");
					ctrl_ft53 = flagList.get(h).getFt53().equals("Y");
					ctrl_rf = flagList.get(h).getReefer().equals("Y");
					
					ctrl_d2 = flagList.get(h).getCtrlD2().equals("Y");
					ctrl_d4 = flagList.get(h).getCtrlD4().equals("Y");
					ctrl_rd = flagList.get(h).getCtrlRd().equals("Y");
					
					ctrl_acct = flagList.get(h).getCtrlAcct().equals("Y");
					ctrl_usa = flagList.get(h).getCtrlUsa().equals("Y");
				}
			}
			//ctrl_port = "O";
//			view_level = ctrl_port.equals("O")?1:ctrl_port.equals("L")?2:3;
			
			List<SearchSpaceControlInquiryOfficeSalesOrgListVO> orgList = new ArrayList<SearchSpaceControlInquiryOfficeSalesOrgListVO>();
			orgList = complexMainVO.getSearchSpaceControlInquiryOfficeSalesOrgListVO();
			if(orgList != null) rowCount = orgList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			String ofc_cd = "";
			String pol_cd = "";
			String pod_cd = "";
			String custCtrlCd = "";
			int level = 0;
			if (orgList != null) {//3.1
				
				String ctrlFlg = orgList.get(0).getCtrlFlg();
				String ofcLvl = orgList.get(0).getOfcLvl();
				
				for(int i=0;i<rowCount;i++){
					custCtrlCd = orgList.get(i).getCustCtrlCd();
					ofc_cd = JSPUtil.getNull(orgList.get(i).getOfcCd());
					pol_cd = (orgList.get(i).getPolCd());
					pod_cd = (orgList.get(i).getPodCd());
					level = (Integer.parseInt(orgList.get(i).getLvl()));
	//				if(level == 1 && custCtrlCd != null && !custCtrlCd.equals("")){
	//					pol_cd = (view_level>level)?"-":"+";
	//					pol_cd = "-";
	//				}
	//				if(level == 2){
	//					pod_cd = (view_level>level)?"-":"+";
	//					pod_cd = "-";
	//				}
	
	//		sbufXML.append("<TR LEVEL='"+level+"' EXPAND='"+(view_level>level)+"'>\n");
			sbufXML.append("<TR LEVEL='"+level+"' EXPAND='true'>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getIocTsCd())+"</TD>\n");
			sbufXML.append("<TD>"+ofc_cd+"</TD>\n");
			
			if("Y".equals(ctrlFlg)){
				sbufXML.append("<TD>"+custCtrlCd+"</TD>\n");
				sbufXML.append("<TD>"+orgList.get(i).getUsaBkgModCd()+"</TD>\n"); //Local IPI(US MOD)
				sbufXML.append("<TD>"+orgList.get(i).getCustAcct()+"</TD>\n"); //Account
				sbufXML.append("<TD><![CDATA[" +JSPUtil.getNull(orgList.get(i).getCustLglEngNm())+"]]></TD>\n"); //Account Name
				sbufXML.append("<TD>"+pol_cd+"</TD>\n");
				sbufXML.append("<TD>"+pod_cd+"</TD>\n");
				sbufXML.append("<TD>"+orgList.get(i).getDestLocCd()+"</TD>\n"); //Dest
				
				if("".equals(custCtrlCd)||" ".equals(custCtrlCd)){
					sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getBkgQta())+"</TD>\n");
					sbufXML.append("<TD></TD>\n");
				}else{
					sbufXML.append("<TD></TD>\n");
					//if("-".equals(pol_cd)){
					if("".equals(orgList.get(i).getUsaBkgModCd())||" ".equals(orgList.get(i).getUsaBkgModCd())){
						sbufXML.append("<TD>"+orgList.get(i).getSmp()+"</TD>\n");
					}else{
						sbufXML.append("<TD></TD>\n");
					}
				}
				sbufXML.append("<TD>"+ofcLvl+"</TD>\n");//ofc_lvl - (성수기) 4 level인 경우에만 smp 존재
			}else{
				sbufXML.append("<TD>"+custCtrlCd+"</TD>\n");//cust_ctrl_cd
				sbufXML.append("<TD>"+orgList.get(i).getUsaBkgModCd()+"</TD>\n"); //Local IPI(US MOD)
				sbufXML.append("<TD>"+orgList.get(i).getCustAcct()+"</TD>\n"); //Account
				sbufXML.append("<TD><![CDATA[" +JSPUtil.getNull(orgList.get(i).getCustLglEngNm())+"]]></TD>\n"); //Account Name
				sbufXML.append("<TD>"+pol_cd+"</TD>\n");
				sbufXML.append("<TD>"+pod_cd+"</TD>\n");
				sbufXML.append("<TD>"+orgList.get(i).getDestLocCd()+"</TD>\n"); //Dest
				sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getBkgQta())+"</TD>\n");
				sbufXML.append("<TD></TD>\n");//smp
				sbufXML.append("<TD></TD>\n");//ofc_lvl
			}
			
			sbufXML.append("<TD>"+orgList.get(i).getLvl()+"</TD>\n");//tree
			sbufXML.append("<TD>"+ctrlFlg+"</TD>\n");//성수기,비수기 구분자
			sbufXML.append("<TD>"+orgList.get(i).getCmb()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmbWgt()+"</TD>\n");
			//Weekly CMB
			sbufXML.append("<TD>"+orgList.get(i).getCmb1()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmb2()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmb3()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmb4()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmbWgt1()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmbWgt2()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmbWgt3()+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getCmbWgt4()+"</TD>\n");
			//Forecast
			sbufXML.append("<TD>"+orgList.get(i).getFcTtlTeu()+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctD2())+"</TD>\n"); //Forecast-D2
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctD4())+"</TD>\n"); //Forecast-D4
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFct45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFct53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctRd())+"</TD>\n"); //Forecast-RD
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctWgt())+"</TD>\n");
			//Allocation
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcD2())+"</TD>\n"); //Allocation-D2
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcD4())+"</TD>\n"); //Allocation-D4
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlc45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlc53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcRd())+"</TD>\n"); //Allocation-RD
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcWgt())+"</TD>\n");
			//Firm
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmD2())+"</TD>\n"); //Firm-D2
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm20())+"</TD>\n"); //20(TEU)
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmD4())+"</TD>\n"); //Firm-D4
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm40())+"</TD>\n"); //40(FEU)
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmRd())+"</TD>\n"); //Firm-RD
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmWgt())+"</TD>\n");
			//Waiting
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatD2())+"</TD>\n"); //Waiting-D2
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat20())+"</TD>\n"); //20(TEU)
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatD4())+"</TD>\n"); //Waiting-D4
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat40())+"</TD>\n"); //40(FEU)
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatRd())+"</TD>\n"); //Waiting-RD
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatWgt())+"</TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getBkgVolVgm())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getBkgWgtVgm())+"</TD>\n");
			sbufXML.append("</TR>\n");				
				}
			}	
			sbufXML.append("</DATA>\n");
			sbufXML.append("<ETC-DATA>\n");
			sbufXML.append("<ETC KEY='volume'></ETC>\n");
			sbufXML.append("<ETC KEY='pol_pod'>"+ctrl_port+"</ETC>\n");
			sbufXML.append("<ETC KEY='hc40'>"+(ctrl_40hc?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='hc45'>"+(ctrl_45hc?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ft53'>"+(ctrl_ft53?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='reefer'>"+(ctrl_rf?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='weight'>"+(ctrl_wgt?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ctrl_d2'>"+(ctrl_d2?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ctrl_d4'>"+(ctrl_d4?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ctrl_rd'>"+(ctrl_rd?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ctrl_acct'>"+(ctrl_acct?"Y":"N")+"</ETC>\n");
			sbufXML.append("<ETC KEY='ctrl_usa'>"+(ctrl_usa?"Y":"N")+"</ETC>\n");
			sbufXML.append("</ETC-DATA>\n");			
			sbufXML.append("</SHEET>\n");			
			sbufXML.append("[+]\n");
			
			
			List<SearchSpaceControlInquiryOfficeCustomerListVO> customerList = new ArrayList<SearchSpaceControlInquiryOfficeCustomerListVO>();
			customerList = complexMainVO.getSearchSpaceControlInquiryOfficeCustomerListVO(); //by Contractor
			if(customerList != null) rowCount = customerList.size();
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			if (customerList != null) {//3.1				
				for(int j=0;j<rowCount;j++){
			sbufXML.append("<TR>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getOrd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getCustCd())+"</TD>\n");
			sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(customerList.get(j).getCustNm())+"]]></TD>\n");
			
			sbufXML.append("<TD>"+customerList.get(j).getRvisCntrCustTpCd()+"</TD>\n");
			sbufXML.append("<TD>"+customerList.get(j).getCustCtrlCd()+"</TD>\n");
			sbufXML.append("<TD>"+customerList.get(j).getSmp()+"</TD>\n");
			if("XX999999".equals(customerList.get(j).getCustCd())){
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
			}else{
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmb1())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmb2())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmb3())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmb4())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmbWgt1())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmbWgt2())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmbWgt3())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList.get(j).getCmbWgt4())+"</TD>\n");
			}
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getPortCd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getOfcCd())+"</TD>\n"); 
			
			sbufXML.append("<TD>"+customerList.get(j).getFcTtlTeu()+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFctTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFctHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFct45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFct53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFctRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFctWgt())+"</TD>\n");
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirmTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirm20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirm40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirmHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirm45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirm53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirmRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFirmWgt())+"</TD>\n");
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWaitTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWait20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWait40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWaitHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWait45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWait53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWaitRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getWaitWgt())+"</TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getBkgVolVgm())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getBkgWgtVgm())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFlg())+"</TD>\n");
			sbufXML.append("</TR>\n");
				}
			}	
			sbufXML.append("</DATA>\n");
			sbufXML.append("</SHEET>\n");
			sbufXML.append("[+]\n");
			
			
			
			List<SearchSpaceControlInquiryOfficeCustomerListVO> customerList2 = new ArrayList<SearchSpaceControlInquiryOfficeCustomerListVO>();
			customerList2 = complexMainVO.getSearchSpaceControlInquiryOfficeCustomerList2VO(); //by Shipper
			if(customerList2 != null) rowCount = customerList2.size();
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			if (customerList2 != null) {//3.1				
				for(int k=0;k<rowCount;k++){
			sbufXML.append("<TR>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getOrd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getCustCd())+"</TD>\n");
			sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(customerList2.get(k).getCustNm())+"]]></TD>\n");
			
			sbufXML.append("<TD>"+customerList2.get(k).getRvisCntrCustTpCd()+"</TD>\n");
			sbufXML.append("<TD>"+customerList2.get(k).getCustCtrlCd()+"</TD>\n");
			sbufXML.append("<TD>"+customerList2.get(k).getSmp()+"</TD>\n");
			if("XX999999".equals(customerList2.get(k).getCustCd())){
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
				sbufXML.append("<TD></TD>\n");
			}else{
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmb1())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmb2())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmb3())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmb4())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmbWgt1())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmbWgt2())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmbWgt3())+"</TD>\n");
				sbufXML.append("<TD>"+nullToZero(customerList2.get(k).getCmbWgt4())+"</TD>\n");
			}
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getPortCd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getOfcCd())+"</TD>\n"); 
			
			sbufXML.append("<TD>"+customerList2.get(k).getFcTtlTeu()+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFctTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFctHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFct45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFct53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFctRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFctWgt())+"</TD>\n");
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirmTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirm20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirm40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirmHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirm45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirm53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirmRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFirmWgt())+"</TD>\n");
			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWaitTeu())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWait20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWait40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWaitHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWait45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWait53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWaitRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getWaitWgt())+"</TD>\n");		
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getBkgVolVgm())+"</TD>\n");			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getBkgWgtVgm())+"</TD>\n");			
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getFlg())+"</TD>\n");
			sbufXML.append("</TR>\n");
				}
			}			
			sbufXML.append("</DATA>\n");
			
		}
		
		
		return sbufXML.toString();
	}

	/**
	 * DBRowSet를 Parsing하여 <DATA>태그를 생성한다.<br>
	 * IBSheet의 prefix값이 있는 경우 COLORDER에 prefix를 붙인 column명으로 표시해 준다.<br>
	 * 
	 * @param rs DBRowSet 		VO객체
	 * @param prefix String 		IBSheet savename's prefix string
	 * @return String IBSheet 		<DATA>태그
	 * @exception 
	 */
	protected String makeDataTag(DBRowSet rs,String prefix) {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	} 
	
	/**
	 * Pivot Table용 Data tag를 생성한다.<br>
	 * 
	 * @param rs			DBRowSet 		VO객체
	 * @return String 	IBSheet 			<DATA>태그
	 * @exception 
	 */
	protected String makePivotDataTag(DBRowSet rs) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}
	
	private String nullToZero(String str) {
		if(str == null || str.equals(""))
			str = "0";
		return str;
	}
	
	
}
