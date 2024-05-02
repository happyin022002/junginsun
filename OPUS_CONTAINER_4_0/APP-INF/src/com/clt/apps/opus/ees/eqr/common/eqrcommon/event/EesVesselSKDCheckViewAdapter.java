
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesVesselSKDCheckViewAdapter.java
*@FileTitle : EES_VESSEL_SKD_CHECK 화면 IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-06
*@LastModifier : chung eun ho
*@LastVersion : 1.0
* 2009-08-06 chung eun ho
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.event;

import java.util.List;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EES_VESSEL_SKD_CHECK 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author chung eun ho
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesVesselSKDCheckViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	protected String makeDataTag(List<AbstractValueObject> OBVOS, String prefix) {
		
		StringBuilder sb = new StringBuilder();
		CommonVO listVO = new CommonVO();
		AbstractValueObject vo = (AbstractValueObject)OBVOS.get(0) ;
		ObjectCloner.build(vo, listVO);

		EesCommonConditionVO condiVO = (EesCommonConditionVO)listVO.getConditionVo();
		EesCommonVO retVO  = (EesCommonVO)listVO.getResultVo();
		String[] eta_etb_etd = null;
		String eta_dt = "";
		String etb_dt = "";
		String etd_dt = "";
		String yd_cd  = "";
		String row = "";
		String eta_dt_colname = "";
		String etb_dt_colname = ""; 
		String etd_dt_colname = ""; 
		String yd_cd_colname  = "";
		try{
			eta_etb_etd = retVO.getEtaEtdEtb();
			eta_dt = eta_etb_etd[0];
			etb_dt = eta_etb_etd[1];
			etd_dt = eta_etb_etd[2];
			yd_cd  = eta_etb_etd[3];
			row   = condiVO.getRow();
			eta_dt_colname = condiVO.getEtaDtColname();
			etb_dt_colname = condiVO.getEtbDtColname();
			etd_dt_colname = condiVO.getEtdDtColname();
			yd_cd_colname  = condiVO.getYdCdColname();
			sb.append("<DATA>\n");
			sb.append("<TR ROW=\""+row+"\" >");
			sb.append("	<TD COL=\""+ eta_dt_colname +"\" >"+JSPUtil.getNull(eta_dt)+"</TD>");
			sb.append("	<TD COL=\""+ etb_dt_colname +"\" >"+JSPUtil.getNull(etb_dt)+"</TD>");
			sb.append("	<TD COL=\""+ etd_dt_colname +"\" >"+JSPUtil.getNull(etd_dt)+"</TD>");
			sb.append("	<TD COL=\""+ yd_cd_colname +"\" >"+JSPUtil.getNull(yd_cd)+"</TD>");
			sb.append("</TR>  ");
			sb.append("</DATA>\n");
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new RuntimeException(ex.getMessage());
		}
		
		return sb.toString();
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
	protected String makeDataTag(DBRowSet rowSet,String prefix) {
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
