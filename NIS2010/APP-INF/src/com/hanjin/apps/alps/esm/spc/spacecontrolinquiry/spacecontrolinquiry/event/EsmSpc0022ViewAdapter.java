/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0022ViewAdapter.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.08 한상훈
* 1.0 Creation
* 2010.06.22 Lee Sang-Yong : 프로젝트 CHM-201004171  53ft(DW,DX) 추가
* 2011.07.05 김종준 [CHM-201111880-01]  control by HO 화면 보완 - IPC, TS 관련
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
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
public class EsmSpc0022ViewAdapter extends ViewAdapter{
	

	
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
			
			List<SearchSpaceControlInquiryTradeListVO> viewList = new ArrayList<SearchSpaceControlInquiryTradeListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryTradeListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
			
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getTrdCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getSubTrdCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getRlaneCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getDirCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCostWk()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getVvd()+"</TD>\n");
					sbufXML.append("<TD>"+(viewList.get(i).getIocCd().equals("O")?"OCN":"IPC")+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBsa()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getLoadable()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getQtaVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getQtaCmb()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTcWgt()+"</TD>\n"); 
					sbufXML.append("<TD>"+viewList.get(i).getLf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWgtLf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcTsVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcTsWgt()+"</TD>\n");
//					sbufXML.append("<TD>"+viewList.get(i).getBkgFirm()+"</TD>\n");
//					sbufXML.append("<TD>"+viewList.get(i).getBkgWait()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTtl()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVolVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgtVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsVolVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsWgtVgm()+"</TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
	
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceControlInquirySalesOrgListVO> viewList = new ArrayList<SearchSpaceControlInquirySalesOrgListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquirySalesOrgListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
			String ttlColor = "247,231,236"; //pink
			String nonColor = "255,255,255"; //white
			String bgColor = null;
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null && viewList.size()>0) {//3.1
				
				String ctrlFlg = viewList.get(0).getCtrlFlg();
				
				for(int i=0;i<rowCount;i++){
					String custCtrlCd = viewList.get(i).getCustCtrlCd();
					if("Y".equals(ctrlFlg) && "".equals(custCtrlCd)){
						bgColor = ttlColor;
					}else{
						bgColor = nonColor;
					}
		
					//System.out.println("[ViewAdapter] CTRL_FLG :: " + ctrlFlg + " >>>");
					//System.out.println("[ViewAdapter] CUST_CTRL_CD :: " + custCtrlCd + " >>>");
					
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getIocTsCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					if("Y".equals(ctrlFlg)){
						sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+custCtrlCd+"</TD>\n");
						if("".equals(custCtrlCd)||" ".equals(custCtrlCd)){
							sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+viewList.get(i).getQtaVol()+"</TD>\n");
							sbufXML.append("<TD BGCOLOR='"+bgColor+"'></TD>\n");
						}else{
							sbufXML.append("<TD BGCOLOR='"+bgColor+"'></TD>\n");
							sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+viewList.get(i).getSmp()+"</TD>\n");
						}
					}else{
						sbufXML.append("<TD BGCOLOR='"+bgColor+"'></TD>\n");//cust_ctrl_cd
						sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+viewList.get(i).getQtaVol()+"</TD>\n");
						sbufXML.append("<TD BGCOLOR='"+bgColor+"'></TD>\n");//smp
					}

					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getUsaBkgModCd())+"</TD>\n");//Local/IPI
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCustAcct())+"</TD>\n");	//Account
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.replace(JSPUtil.getNull(viewList.get(i).getCustLglEngNm()),"&"," ")+"</TD>\n");	//Account Name
					//sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCustLglEngNm())+"</TD>\n");	//Account Name
					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmb())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmbWgt())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmb1())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmb2())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmb3())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmb4())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmbWgt1())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmbWgt2())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmbWgt3())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getCmbWgt4())+"</TD>\n");
					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFcTtlTeu())+"</TD>\n");	
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctVol())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctD2())+"</TD>\n");	//Forecase-D2
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctD4())+"</TD>\n");	//Forecase-D4
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctHc())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFct45())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFct53())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctRf())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctRd())+"</TD>\n");	//Forecase-RD					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getFctWgt())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcVol())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcD2())+"</TD>\n");	//Allocation-D2
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcD4())+"</TD>\n");	//Allocation-D4					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcHc())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlc45())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlc53())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcRf())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcRd())+"</TD>\n");	//Allocation-RD					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getAlcWgt())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgVol())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgD2())+"</TD>\n");	//Total Booking-D2
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkg20())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgD4())+"</TD>\n");	//Total Booking-D4		
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkg40())+"</TD>\n");					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgHc())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkg45())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkg53())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgRf())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgRd())+"</TD>\n");	//Total Booking-RD					
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgWgt())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgVolVgm())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+JSPUtil.getNull(viewList.get(i).getBkgWgtVgm())+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'>"+ctrlFlg+"</TD>\n");
					sbufXML.append("<TD BGCOLOR='"+bgColor+"'></TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST03")){	//2.1
			
			List<SearchSpaceControlInquiryPolPodListVO> viewList = new ArrayList<SearchSpaceControlInquiryPolPodListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryPolPodListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getUsaBkgModCd()+"</TD>\n");	//Local/IPI
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getDestLocCd()+"</TD>\n");	//Dest					
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmb1()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmb2()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmb3()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmb4()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmbWgt1()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmbWgt2()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmbWgt3()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCmbWgt4()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctD2()+"</TD>\n");	//Forecase-D2
					sbufXML.append("<TD>"+viewList.get(i).getFctD4()+"</TD>\n");	//Forecase-D4					
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRd()+"</TD>\n");	//Forecase-RD						
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcD2()+"</TD>\n");	//Allocation-D2
					sbufXML.append("<TD>"+viewList.get(i).getAlcD4()+"</TD>\n");	//Allocation-D4							
					sbufXML.append("<TD>"+viewList.get(i).getAlcHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcRd()+"</TD>\n");	//Allocation-RD
					sbufXML.append("<TD>"+viewList.get(i).getAlcWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgD2()+"</TD>\n");	//Total Booking-D2
					sbufXML.append("<TD>"+viewList.get(i).getBkg20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgD4()+"</TD>\n");	//Total Booking-D4	
					sbufXML.append("<TD>"+viewList.get(i).getBkg40()+"</TD>\n");							
					sbufXML.append("<TD>"+viewList.get(i).getBkgHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRd()+"</TD>\n");	//Total Booking-RD		
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVolVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgtVgm()+"</TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST04")){	//by Shipper (tab4)
			
			List<SearchSpaceControlInquiryCustomerListVO> viewList = new ArrayList<SearchSpaceControlInquiryCustomerListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryCustomerListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOrd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCustCd()+"</TD>\n");
					sbufXML.append("<TD><![CDATA["+viewList.get(i).getCustNm()+"]]></TD>\n");

					if("XX999999".equals(viewList.get(i).getCustCd())){
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
					}else{
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb1())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb2())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb3())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb4())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt1())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt2())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt3())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt4())+"</TD>\n");
					}
					
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVolVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgtVgm()+"</TD>\n");
					
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST05")){	//by Customer (tab3)
			
			List<SearchSpaceControlInquiryContractorVO> viewList = new ArrayList<SearchSpaceControlInquiryContractorVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryContractorVO();
			
			if(viewList != null) rowCount = viewList.size();
			
//			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOrd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCustCd()+"</TD>\n");
					sbufXML.append("<TD><![CDATA["+viewList.get(i).getCustNm()+"]]></TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getRvisCntrCustTpCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCustCtrlCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getSmp()+"</TD>\n");
					if("XX999999".equals(viewList.get(i).getCustCd())){
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
						sbufXML.append("<TD></TD>\n");
					}else{
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb1())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb2())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb3())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmb4())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt1())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt2())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt3())+"</TD>\n");
						sbufXML.append("<TD>"+nullToZero(viewList.get(i).getCmbWgt4())+"</TD>\n");
					}
					
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVolVgm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgtVgm()+"</TD>\n");
					
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
//			sbufXML.append("</SHEET>\n");
			
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