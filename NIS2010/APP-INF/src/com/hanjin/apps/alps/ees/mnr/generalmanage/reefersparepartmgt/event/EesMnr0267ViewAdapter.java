/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EesMnr0267ViewAdapterDL.java
*@FileTitle : EesMnr0267ViewAdapterDL
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.26
*@LastModifier : 노영현
*@LastVersion : 1.0
* 2014.11.26 노영현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrVslSprPrtInvtVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.ViewAdapter;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 * EES_MNR_0267 에 대한 ViewAdapter<br>
 * - EES_MNR_0267HTMLAction에서 작성<br>
 *
 * @author 김봉균
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0267ViewAdapter extends ViewAdapter {
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		StringBuilder sb = new StringBuilder();
		String rtn = "";
		int colCnt = 0;
		try{
			colCnt = vos.size();
		    
			String invtNo = "";
			String invtVerSeq = "";
			String laneCd = "";
			String vslCd = "";	
			String tpCd = "";
			String verSeq = "";
			BigDecimal crntAmt = new BigDecimal("0");
			
			List<String> customOutIndex = new ArrayList<String>();

			customOutIndex.add("spr_prt_invt_no");
			customOutIndex.add("spr_prt_invt_seq");
			customOutIndex.add("spr_prt_invt_ver_seq");
			customOutIndex.add("lane_cd");
			customOutIndex.add("vsl_cd");
			customOutIndex.add("vsl_nm");
			customOutIndex.add("crr_cd");
			customOutIndex.add("spr_prt_tp_cd");
			customOutIndex.add("spr_prt_ver_seq");
			int idx = 0;
			
			int sCnt = 0;
			int oCnt = 0;
			int nCnt = 0;
			
			sb.append("<DATA COLORDER='##' COLSEPARATOR='☜☞' TOTAL='" + colCnt +"'>\n");
			for( int i = 0; i < vos.size(); i++ ){
				MnrVslSprPrtInvtVO vo = (MnrVslSprPrtInvtVO)vos.get(i);
				
				String curInvtNo = JSPUtil.getNull(vo.getSprPrtInvtNo());
				String curInvtSeq = JSPUtil.getNull(vo.getSprPrtInvtSeq());
				String curInvtVerSeq = JSPUtil.getNull(vo.getSprPrtInvtVerSeq());
				String curLaneCd = JSPUtil.getNull(vo.getLaneCd());
				String curVslCd = JSPUtil.getNull(vo.getVslCd());
				String curVslNm = JSPUtil.getNull(vo.getVslNm());
				String curCrrCd = JSPUtil.getNull(vo.getCrrCd());
				String curTpCd = JSPUtil.getNull(vo.getSprPrtTpCd());
				
				String curVerSeq = JSPUtil.getNull(vo.getSprPrtVerSeq());
				String curVndrSeq = JSPUtil.getNull(vo.getSprPrtVndrSeq());
				String curMdlNm = JSPUtil.getNull(vo.getSprUtMdlNm());
				String sprUtShrCd = JSPUtil.getNull(vo.getSprUtShrCd());
				String sprPrtCrntAmt = JSPUtil.getNull(vo.getSprPrtCrntAmt());
				BigDecimal crntAmtVal = new BigDecimal(sprPrtCrntAmt);//Double.parseDouble(sprPrtCrntAmt);

				// 같음면 
				if( invtNo.equals(curInvtNo) 
						&& invtVerSeq.equals(curInvtVerSeq) 
						&& laneCd.equals(curLaneCd) 
						&& vslCd.equals(curVslCd)
						&& tpCd.equals(curTpCd)
						&& verSeq.equals(curVerSeq)
						
						){
					
					sb.append(sprUtShrCd + DELIMITER);
					sb.append(crntAmtVal + DELIMITER);
					if( idx == 1){
						customOutIndex.add("cd_id_" + curVndrSeq + "_" + curMdlNm);
						customOutIndex.add("cd_amt_" + curVndrSeq + "_" + curMdlNm);
					}
					
					if( "O".equals(sprUtShrCd) ){
						oCnt++;
						//crntAmt += crntAmtVal;
						crntAmt = (crntAmt.add(crntAmtVal));
						log.debug("O- " + crntAmtVal + " : " + crntAmt);
					}else if( "S".equals(sprUtShrCd)){
						sCnt++;
					}else if( "N".equals(sprUtShrCd)){
					//}else{
						nCnt++;
					}
					
					//System.out.println(i + "a O: " + oCnt + " , S: " + sCnt + ", N : " + nCnt);
				}else{// 다르면
					if( idx == 0){
						//sb.append("<TR>");
						sb.append("	<TR><![CDATA[");
						
						sb.append(curInvtNo + DELIMITER);
						sb.append(curInvtSeq + DELIMITER);
						sb.append(curInvtVerSeq + DELIMITER);
						sb.append(curLaneCd + DELIMITER);
						sb.append(curVslCd + DELIMITER);
						sb.append(curVslNm + DELIMITER);
						sb.append(curCrrCd + DELIMITER);
						sb.append(curTpCd + DELIMITER);
						
						
						sb.append(curVerSeq + DELIMITER);
						sb.append(sprUtShrCd + DELIMITER);
						sb.append(crntAmtVal + DELIMITER);
						customOutIndex.add("cd_id_" + curVndrSeq + "_" + curMdlNm);
						customOutIndex.add("cd_amt_" + curVndrSeq + "_" + curMdlNm);
						
					}else{
						//sb.append("S(" + sCnt +"),O(" + oCnt + "),N(" + nCnt + ")" + DELIMITER);
						//sb.append( (sCnt +oCnt ) + DELIMITER);
						sb.append( " " + DELIMITER);
						sb.append(crntAmt);
						
						sb.append("]]></TR>\n");
						sb.append("	<TR><![CDATA[");
						
						sb.append(curInvtNo + DELIMITER);
						sb.append(curInvtSeq + DELIMITER);
						sb.append(curInvtVerSeq + DELIMITER);
						sb.append(curLaneCd + DELIMITER);
						sb.append(curVslCd + DELIMITER);
						sb.append(curVslNm + DELIMITER);
						sb.append(curCrrCd + DELIMITER);
						sb.append(curTpCd + DELIMITER);
						sb.append(curVerSeq + DELIMITER);
						sb.append(sprUtShrCd + DELIMITER);	
						sb.append(crntAmtVal + DELIMITER);
						
						
						crntAmt = new BigDecimal("0");
						oCnt = 0;
						sCnt = 0;
						nCnt = 0;
						
						idx++;
					}					
					
					
					if( "O".equals(sprUtShrCd) ){
						oCnt++;
						crntAmt = crntAmtVal;//'O'일때만 합산.
						//log.debug("O " + crntAmtVal + " : " + crntAmt);
					}else if( "S".equals(sprUtShrCd)){
						sCnt++;
					}else if( "N".equals(sprUtShrCd)){
					//}else{
						nCnt++;
					}
					//System.out.println(i + "b O: " + oCnt + " , S: " + sCnt + ", N : " + nCnt);
					idx++;
				}
				
				invtNo = curInvtNo;
				invtVerSeq = curInvtVerSeq;
				laneCd = curLaneCd;
				vslCd = curVslCd;
				tpCd = curTpCd;
				verSeq = curVerSeq;
			}//end of while
			customOutIndex.add("ttl_qty");
			customOutIndex.add("spr_prt_crnt_amt");
			
			// 마지막꺼 Cnt빼기
			
			//sb.append("S(" + sCnt +"),O(" + oCnt + "),N(" + nCnt + ")" + DELIMITER);
			//sb.append( (sCnt +oCnt ) + DELIMITER);
			sb.append( " " + DELIMITER);
			sb.append(crntAmt);
			
			sb.append("]]></TR>\n"); 
			
			sb.append("</DATA>\n");
			String temp = sb.toString();
			Object rArr[] = customOutIndex.toArray();
			String headerArr = StringUtils.join(rArr, "|");
			
			rtn = temp.replaceAll("[#][#]", headerArr);
		
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return rtn;
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
		String rtn = "";
//		
////		System.out.println(" ****************** makeDataTag(DBRowSet rs, String prefix) ");
//		try{
//					    
//			String invtNo = "";
//			String invtVerSeq = "";
//			String laneCd = "";
//			String vslCd = "";	
//			String tpCd = "";
//			double crntAmt = 0.0;
//			
//			List<String> customOutIndex = new ArrayList<String>();
//
//			customOutIndex.add("spr_prt_invt_no");
//			customOutIndex.add("spr_prt_invt_seq");
//			customOutIndex.add("spr_prt_invt_ver_seq");
//			customOutIndex.add("lane_cd");
//			customOutIndex.add("vsl_cd");
//			customOutIndex.add("vsl_nm");
//			customOutIndex.add("crr_cd");
//			customOutIndex.add("spr_prt_tp_cd");
//			
//			int idx = 0;
//			sb.append("<DATA COLORDER='##' COLSEPARATOR='☜☞' TOTAL='" + 1 +"'>\n");
//			while( rs.next()) {
//				String curInvtNo = JSPUtil.getNull(rs.getString("spr_prt_invt_no"));
//				String curInvtSeq = JSPUtil.getNull(rs.getString("spr_prt_invt_seq"));
//				String curInvtVerSeq = JSPUtil.getNull(rs.getString("spr_prt_invt_ver_seq"));
//				String curLaneCd = JSPUtil.getNull(rs.getString("lane_cd"));
//				String curVslCd = JSPUtil.getNull(rs.getString("vsl_cd"));
//				String curVslNm = JSPUtil.getNull(rs.getString("vsl_nm"));
//				String curCrrCd = JSPUtil.getNull(rs.getString("crr_cd"));
//				String curTpCd = JSPUtil.getNull(rs.getString("spr_prt_tp_cd"));
//
//				String curVndrSeq = JSPUtil.getNull(rs.getString("spr_prt_vndr_seq"));
//				String curMdlNm = JSPUtil.getNull(rs.getString("spr_ut_mdl_nm"));
//				String sprUtShrCd = JSPUtil.getNull(rs.getString("spr_ut_shr_cd"));
//				String sprPrtCrntAmt = JSPUtil.getNull(rs.getString("spr_prt_crnt_amt"));
//				double crntAmtVal = Double.parseDouble(sprPrtCrntAmt);				
//				
//				// 같음면 
//				if( invtNo.equals(curInvtNo) 
//						&& invtVerSeq.equals(curInvtVerSeq) 
//						&& laneCd.equals(curLaneCd) 
//						&& vslCd.equals(curVslCd)
//						&& tpCd.equals(curTpCd)
//						){
//					sb.append(sprUtShrCd + DELIMITER);
//					sb.append(crntAmtVal + DELIMITER);
//					if( idx == 1){
//						customOutIndex.add("cd_id_" + curVndrSeq + "_" + curMdlNm);
//						customOutIndex.add("cd_amt_" + curVndrSeq + "_" + curMdlNm);
//					}
//					crntAmt += crntAmtVal;
//				}else{// 다르면
//					if( idx == 0){
//						//sb.append("<TR>");
//						sb.append("	<TR><![CDATA[");
//						
//						sb.append(curInvtNo + DELIMITER);
//						sb.append(curInvtSeq + DELIMITER);
//						sb.append(curInvtVerSeq + DELIMITER);
//						sb.append(curLaneCd + DELIMITER);
//						sb.append(curVslCd + DELIMITER);
//						sb.append(curVslNm + DELIMITER);
//						sb.append(curCrrCd + DELIMITER);
//						sb.append(curTpCd + DELIMITER);
//						
//						sb.append(sprUtShrCd + DELIMITER);
//						sb.append(crntAmtVal + DELIMITER);
//						customOutIndex.add("cd_id_" + curVndrSeq + "_" + curMdlNm);
//						customOutIndex.add("cd_amt_" + curVndrSeq + "_" + curMdlNm);
//					}else{
//					
//						sb.append(crntAmt);
//						
//						sb.append("]]></TR>\n");
//						sb.append("	<TR><![CDATA[");
//						
//						sb.append(curInvtNo + DELIMITER);
//						sb.append(curInvtSeq + DELIMITER);
//						sb.append(curInvtVerSeq + DELIMITER);
//						sb.append(curLaneCd + DELIMITER);
//						sb.append(curVslCd + DELIMITER);
//						sb.append(curVslNm + DELIMITER);
//						sb.append(curCrrCd + DELIMITER);
//						sb.append(curTpCd + DELIMITER);
//						sb.append(sprUtShrCd + DELIMITER);	
//						sb.append(crntAmtVal + DELIMITER);
//						crntAmt = 0.0;
//						idx++;
//					}
//				
//					crntAmt = crntAmtVal;
//					
//					idx++;
//				}
//				
//				invtNo = curInvtNo;
//				invtVerSeq = curInvtVerSeq;
//				laneCd = curLaneCd;
//				vslCd = curVslCd;
//				tpCd = curTpCd;
//			}//end of while
//			customOutIndex.add("spr_prt_crnt_amt");
//			sb.append(crntAmt);
//			sb.append("]]></TR>\n"); 
//			
//			sb.append("</DATA>\n");
//			String temp = sb.toString();
//			Object rArr[] = customOutIndex.toArray();
//			String headerArr = StringUtils.join(rArr, "|");
//			
//			rtn = temp.replaceAll("[#][#]", headerArr);
//			
//		}catch(SQLException ex){
//			throw new RuntimeException(ex.getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new RuntimeException(ex.getMessage());
//		}
		return rtn;
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
		int colCnt = 0;
		int rowCnt = rs.getRowCount();
		//System.out.println("************ makePivotDataTag(DBRowSet rs)");
		String[][] arrRowSet = null;

		try{
			colCnt = rs.getMetaData().getColumnCount();
			arrRowSet = new String[rowCnt][colCnt];
			
			int rowIdx = 0;
			while (rs.next()) { 
				for (int j = 1 ; j <= colCnt ; j++) {
					arrRowSet[rowIdx][j-1] = JSPUtil.getNull(rs.getObject(j)).toString();
				}
				rowIdx++;
			}		
	
			sb.append("<DATA COLSEPARATOR='" + DELIMITER + "'>\n");
			if(rowCnt>0){
				for (int coIdx = 0 ;coIdx < colCnt ; coIdx++) {
					sb.append("	<TR><![CDATA[");
					for(int roIdx=0;roIdx < rowCnt-1; roIdx++){
						sb.append(arrRowSet[roIdx][coIdx] + DELIMITER);
					}
					sb.append(arrRowSet[rowCnt-1][coIdx]  + "]]></TR>\n");
				}//end for coIdx
			}//end for roIdx
			sb.append("</DATA>\n");
			
		}catch(SQLException ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		return sb.toString();
	}

}
