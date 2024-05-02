/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0028ViewAdapter.java
*@FileTitle      : Inquiry by Sub Office
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.10.12
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.10.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceAllocationControlFlagListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryOfficeSalesOrgListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.ViewAdapter;

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
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctTsVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getFctTsWgt())+"</TD>\n");
					
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcTsVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getAlcTsWgt())+"</TD>\n");


					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgFirm())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgWait())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgWgt())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsVol())+"</TD>\n");
					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getBkgTsWgt())+"</TD>\n");

					sbufXML.append("<TD>"+JSPUtil.getNull(viewList.get(i).getRatio())+"</TD>\n");
					
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
	
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
			int view_level = 1;
			
			if(flagList != null) {//4.1
				for(int h=0;h<flagList.size();h++){
					ctrl_port = flagList.get(h).getPolPod();
					ctrl_wgt = flagList.get(h).getWeight().equals("Y");
					ctrl_40hc = flagList.get(h).getHc40().equals("Y");
					ctrl_45hc = flagList.get(h).getHc45().equals("Y");
					ctrl_ft53 = flagList.get(h).getFt53().equals("Y");
					ctrl_rf = flagList.get(h).getReefer().equals("Y");
				}
			}
			view_level = ctrl_port.equals("O")?1:ctrl_port.equals("L")?2:3;
			
			List<SearchSpaceControlInquiryOfficeSalesOrgListVO> orgList = new ArrayList<SearchSpaceControlInquiryOfficeSalesOrgListVO>();
			orgList = complexMainVO.getSearchSpaceControlInquiryOfficeSalesOrgListVO();
			if(orgList != null) rowCount = orgList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			String ofc_cd = "";
			String pol_cd = "";
			String pod_cd = "";
			int level = 0;
			if (orgList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
					ofc_cd = JSPUtil.getNull(orgList.get(i).getOfcCd());
					pol_cd = (orgList.get(i).getPolCd());
					pod_cd = (orgList.get(i).getPodCd());
					level = (Integer.parseInt(orgList.get(i).getLvl()));
					if(level == 1){
						pol_cd = "-";
					}
					if(level == 2){
						pod_cd = "-";
					}
	
			sbufXML.append("<TR LEVEL='"+level+"' EXPAND='"+(view_level>level)+"'>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getIocTsCd())+"</TD>\n");
			sbufXML.append("<TD>"+ofc_cd+"</TD>\n");
			sbufXML.append("<TD>"+pol_cd+"</TD>\n");
			sbufXML.append("<TD>"+pod_cd+"</TD>\n");
			sbufXML.append("<TD></TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getBkgQta())+"</TD>\n");
			sbufXML.append("<TD>"+orgList.get(i).getFcTtlTeu()+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFct45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFct53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFctWgt())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlc45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlc53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getAlcWgt())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrm53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getFrmWgt())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatVol())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat20())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat40())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatHc())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat45())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWat53())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatRf())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(orgList.get(i).getWatWgt())+"</TD>\n");
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
			sbufXML.append("</ETC-DATA>\n");			
			sbufXML.append("</SHEET>\n");			
			sbufXML.append("[+]\n");
			
			List<SearchSpaceControlInquiryOfficeCustomerListVO> customerList = new ArrayList<SearchSpaceControlInquiryOfficeCustomerListVO>();
			customerList = complexMainVO.getSearchSpaceControlInquiryOfficeCustomerListVO();
			if(customerList != null) rowCount = customerList.size();
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			if (customerList != null) {//3.1				
				for(int j=0;j<rowCount;j++){
			sbufXML.append("<TR>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getOrd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getCustCd())+"</TD>\n");
			sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(customerList.get(j).getCustNm())+"]]></TD>\n");
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
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList.get(j).getFlg())+"</TD>\n");
			sbufXML.append("</TR>\n");
				}
			}			
			sbufXML.append("</DATA>\n");
			sbufXML.append("</SHEET>\n");
			sbufXML.append("[+]\n");
			
			
			
			List<SearchSpaceControlInquiryOfficeCustomerListVO> customerList2 = new ArrayList<SearchSpaceControlInquiryOfficeCustomerListVO>();
			customerList2 = complexMainVO.getSearchSpaceControlInquiryOfficeCustomerList2VO();
			if(customerList2 != null) rowCount = customerList2.size();
			sbufXML.append("<SHEET>\n");
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");
			
			if (customerList2 != null) {//3.1				
				for(int k=0;k<rowCount;k++){
			sbufXML.append("<TR>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getOrd())+"</TD>\n");
			sbufXML.append("<TD>"+JSPUtil.getNull(customerList2.get(k).getCustCd())+"</TD>\n");
			sbufXML.append("<TD><![CDATA["+JSPUtil.getNull(customerList2.get(k).getCustNm())+"]]></TD>\n");
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
}
