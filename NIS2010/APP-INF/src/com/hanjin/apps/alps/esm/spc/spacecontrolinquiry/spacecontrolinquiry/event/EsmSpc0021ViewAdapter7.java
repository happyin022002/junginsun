/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0021ViewAdapter7.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.27
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ETCVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021AllocPortViewList5BySRepVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.layer.event.EventResponse;



/**
 * 기본 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author 한상훈
 * @see ViewAdapter 참조
 * @since J2EE 1.5
 */
public class EsmSpc0021ViewAdapter7 extends ViewAdapter{
	
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
				
		ComplexMainVO comMain = (ComplexMainVO)vos.get(0);
		
		
		List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> viewList = new ArrayList<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO>();
//		etc = comMain.getEtc();
		viewList = comMain.getSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs();
		
		SearchSpaceControlInquiryConditionVO condition = comMain.getCondition();
		
//		int rowCountetc  = etc.size();
		int rowCountview = viewList.size();
		
		sbufXML.append("<DATA TOTAL=\""+rowCountview+"\">\n");
		
		int crrCnt    = 0;
		String[] crr  = null;
		String strCrr = "";
		String strVvd = "";
		String portv   = condition.getChkview();
		String srep_cd = "";
		String cust_cd = "";
		String ctrt_cust_cd = "";
		String pol_cd = "";
		String pod_cd = "";
		String srep_nm = "";
		
		int rnum = 0;
		int temp = 1;
		int temp1 = 0;
		int gid = 0;
		int gid1 = 0;
		int gid2 = 0;
		int gid3 = 0;
		int level = 0;
		double bkg = 0.0;
		double qta = 0.0;
		double alloc = 0.0;
		
		if (rowCountview > 0 && viewList != null) {//3.1
			for(int i =0 ; i < rowCountview ; i++){
				
				if(i == 0){
					strCrr = viewList.get(i).getRlaneCd();
					strVvd = viewList.get(i).getVslCd();
					crr = strCrr.split(",");
					crrCnt = crr.length;
				}
				
				if(i > 0){
					temp = i;
					srep_cd = viewList.get(i).getSrepCd();
					cust_cd = viewList.get(i).getCustCntCd() + viewList.get(i).getCustSeq();
					ctrt_cust_cd = viewList.get(i).getCtrtCustCntCd() + viewList.get(i).getCtrtCustSeq();
					pol_cd = viewList.get(i).getPolYdCd().isEmpty()?"-":viewList.get(i).getPolYdCd();
					pod_cd = viewList.get(i).getPodYdCd().isEmpty()?"-":viewList.get(i).getPodYdCd();
					srep_nm = viewList.get(i).getSrepNm();
					
					if(!pod_cd.equals("-")){
						level = 4;
					}else if(!pol_cd.equals("-")){
						level = 3;
					}else if(!cust_cd.isEmpty()) {
						level = 2;
					}else{
						level = srep_nm.isEmpty()?0:1;
					}
					
					sbufXML.append("<tr LEVEL=\"" + level + "\" BGCOLOR=\"").append(srep_cd.isEmpty()?"223,232,247":(cust_cd.isEmpty()?"247,231,236":"")).append("\">\n");
					sbufXML.append("<td>" + viewList.get(i).getBseDt()  + "</td>\n");
					sbufXML.append("<td>" + viewList.get(i).getSlsRgnOfcCd() + "</td>\n");
					sbufXML.append("<td>" + (srep_nm.isEmpty()?"TTL":srep_nm) + "</td>\n");
					sbufXML.append("<td>" + cust_cd + "</td>\n");
					sbufXML.append("<td>" + (ctrt_cust_cd.isEmpty()?(srep_nm.isEmpty()?"":(cust_cd.isEmpty()?"-":cust_cd)):ctrt_cust_cd) + "</td>\n");
					sbufXML.append("<td>" + (cust_cd.isEmpty()?"":pol_cd) + "</td>\n");
					sbufXML.append("<td>" + (pol_cd.isEmpty()?"":(pol_cd.equals("-")?"":pod_cd)) + "</td>\n");
					
					gid = Integer.parseInt(viewList.get(i).getGid());
					gid2 = Integer.parseInt(viewList.get(i).getGid2());
					
					for(int j=0; j<crrCnt; j++){
						
						rnum = Integer.parseInt(viewList.get(temp).getRnum());
						gid1 = Integer.parseInt(viewList.get(temp).getGid());
						gid3 = Integer.parseInt(viewList.get(temp).getGid2());
						
						if(rnum == (j+1) && gid == gid1 && gid2 == gid3){
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\" >" + viewList.get(temp).getFcastTtlQty() + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + viewList.get(temp).getFcast20ftQty() + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + viewList.get(temp).getFcast40ftQty() + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + viewList.get(temp).getBkgTtlQty() + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + viewList.get(temp).getBkg20ftQty() + "</td>\n");
							sbufXML.append("<td DATA-FORMAT=\"dfInteger\">" + viewList.get(temp).getBkg40ftQty() + "</td>\n");
							sbufXML.append("<td>" + viewList.get(temp).getPfmcTtl() + "%" + "</td>\n");
							sbufXML.append("<td>" + viewList.get(temp).getPfmc20ft() + "%" + "</td>\n");
							sbufXML.append("<td>" + viewList.get(temp).getPfmc40ft() + "%" + "</td>\n");
							temp = temp+1;
						}else{
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
							sbufXML.append("<td></td>\n");
						}
						
						if(temp == rowCountview){
							for(int k = j + 1; k < crrCnt; k++){
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
							}
							
							break;
						}
					}

					sbufXML.append("<td>" + viewList.get(i).getGid() + "</td>\n");
					sbufXML.append("<td>" + viewList.get(i).getLvl() + "</td>\n");
					sbufXML.append("<td>" + level  + "</td>\n");
					sbufXML.append("<td></td>\n");
					sbufXML.append("</tr>\n");
					
					if(temp != 1 && srep_cd.isEmpty()){
						sbufXML.append("<tr LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"223,232,247\" >\n");
						sbufXML.append("<td>" + viewList.get(i).getBseDt()  + "</td>\n");
						sbufXML.append("<td>" + viewList.get(i).getSlsRgnOfcCd() + "</td>\n");
						sbufXML.append("<td>QTA</td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						
						temp1 = i;
						
						for(int j=0; j<crrCnt; j++){
							rnum = Integer.parseInt(viewList.get(temp1).getRnum());
							gid1 = Integer.parseInt(viewList.get(temp1).getGid());
							gid3 = Integer.parseInt(viewList.get(temp1).getGid2());
							
							bkg = Double.parseDouble(viewList.get(temp1).getBkgTtlQty().isEmpty()?"0":viewList.get(temp1).getBkgTtlQty());
							qta = Double.parseDouble(viewList.get(temp1).getQtaQty().isEmpty()?"0":viewList.get(temp1).getQtaQty());
							
							if(rnum == (j+1) && gid == gid1 && gid2 == gid3){
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getQtaQty() + "</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getQtaQty() + "</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getQtaQty() + "</td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (qta==0?0:Math.round(bkg*100.0/qta)) + "%</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (qta==0?0:Math.round(bkg*100.0/qta)) + "%</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (qta==0?0:Math.round(bkg*100.0/qta)) + "%</td>\n");
								temp1++;
							}else{
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
							}

							if(temp1 == rowCountview) break;
						}
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("</tr>\n");
						
						sbufXML.append("<tr LEVEL=\"0\" MERGE=\"true\" BGCOLOR=\"223,232,247\" >\n");
						sbufXML.append("<td>" + viewList.get(i).getBseDt()  + "</td>\n");
						sbufXML.append("<td>" + viewList.get(i).getSlsRgnOfcCd() + "</td>\n");
						sbufXML.append("<td>Alloc</td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						
						temp1 = i;
						
						for(int j=0; j<crrCnt; j++){
							rnum = Integer.parseInt(viewList.get(temp1).getRnum());
							gid1 = Integer.parseInt(viewList.get(temp1).getGid());
							gid3 = Integer.parseInt(viewList.get(temp1).getGid2());
							
							bkg = Double.parseDouble(viewList.get(temp1).getBkgTtlQty().isEmpty()?"0":viewList.get(temp1).getBkgTtlQty());
							alloc = Double.parseDouble(viewList.get(temp1).getAlocQty().isEmpty()?"0":viewList.get(temp1).getAlocQty());
							
							if(rnum == (j+1) && gid == gid1 && gid2 == gid3){
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getAlocQty() + "</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getAlocQty() + "</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + viewList.get(temp1).getAlocQty() + "</td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (alloc==0?0:Math.round(bkg*100.0/alloc)) + "%</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (alloc==0?0:Math.round(bkg*100.0/alloc)) + "%</td>\n");
								sbufXML.append("<td DATA-FORMAT=\"dfNone\" DATA-ALIGN=\"daCenter\">" + (alloc==0?0:Math.round(bkg*100.0/alloc)) + "%</td>\n");
								temp1++;
							}else{
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
								sbufXML.append("<td></td>\n");
							}

							if(temp1 == rowCountview) break;
						}
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("<td></td>\n");
						sbufXML.append("</tr>\n");
					}
					
					i = temp-1;
				}
			}
			
		}else{		//3.9 데이타가 없는 경우
			strCrr = strCrr;
		}
		
		sbufXML.append("</DATA>\n");
		sbufXML.append("<ETC-DATA>\n");
		sbufXML.append("<ETC KEY=\"crr\">").append(strCrr).append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"vvd\">").append(strVvd).append("</ETC>\n");
		sbufXML.append("<ETC KEY=\"portv\">" + portv + "</ETC>\n");
		sbufXML.append("</ETC-DATA>\n");
		
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
	
	protected String getETCData(EventResponse eventResponse) {
		return "";
	}
}