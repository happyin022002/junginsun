/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0022ViewAdapter.java
*@FileTitle      : Inquiry by Trade
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.10.08
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.10.08
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.controller.ViewAdapter;

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
					sbufXML.append("<TD>"+viewList.get(i).getFctTsVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTsWgt()+"</TD>\n"); 
					sbufXML.append("<TD>"+viewList.get(i).getLf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcTsVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcTsWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgFirm()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWait()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTtl()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgTsWgt()+"</TD>\n"); 
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("</TR>\n");
				}//4.9
			}//3.9
			
			sbufXML.append("</DATA>\n");
	
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST02")){	//2.1
			
			List<SearchSpaceControlInquirySalesOrgListVO> viewList = new ArrayList<SearchSpaceControlInquirySalesOrgListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquirySalesOrgListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getIocTsCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getQtaVol()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");	
					sbufXML.append("<TD>"+viewList.get(i).getFctVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST03")){	//2.1
			
			List<SearchSpaceControlInquiryPolPodListVO> viewList = new ArrayList<SearchSpaceControlInquiryPolPodListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryPolPodListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD></TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlc53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getAlcWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatWgt()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgVol()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkg53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getBkgWgt()+"</TD>\n");
					sbufXML.append("</TR>\n");
			
				}//4.9
			}//3.9
			sbufXML.append("</DATA>\n");
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST04")){	//2.1
			
			List<SearchSpaceControlInquiryCustomerListVO> viewList = new ArrayList<SearchSpaceControlInquiryCustomerListVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryCustomerListVO();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOrd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCustCd()+"</TD>\n");
					sbufXML.append("<TD><![CDATA["+viewList.get(i).getCustNm()+"]]></TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFrmTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getWatTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatWgt()+"</TD>\n");
					
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
			
		}
		else if( complexMainVO.getEventCommand().equals("SEARCHLIST05")){	//2.1
			
			List<SearchSpaceControlInquiryContractorVO> viewList = new ArrayList<SearchSpaceControlInquiryContractorVO>();
			viewList = complexMainVO.getSearchSpaceControlInquiryContractorVO();
			
			if(viewList != null) rowCount = viewList.size();
			
			sbufXML.append("<DATA TOTAL=\""+rowCount+"\">\n");		
			if (viewList != null) {//3.1
				
				for(int i=0;i<rowCount;i++){
		
					sbufXML.append("<TR>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOrd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getCustCd()+"</TD>\n");
					sbufXML.append("<TD><![CDATA["+viewList.get(i).getCustNm()+"]]></TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getPortCd()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getOfcCd()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFcTtlTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFct53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFctWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getFrmTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrm53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getFrmWgt()+"</TD>\n");
					
					sbufXML.append("<TD>"+viewList.get(i).getWatTeu()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat20()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat40()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatHc()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat45()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWat53()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatRf()+"</TD>\n");
					sbufXML.append("<TD>"+viewList.get(i).getWatWgt()+"</TD>\n");
					
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