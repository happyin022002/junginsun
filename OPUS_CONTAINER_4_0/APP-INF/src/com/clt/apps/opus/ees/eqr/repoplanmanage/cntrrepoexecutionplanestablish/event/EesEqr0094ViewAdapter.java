
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0094ViewAdapter.java
*@FileTitle : EesEqr0094 화면 cntr 입력 시 데이터 가져오기  IBSheet Generation Class
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-21
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009-08-21 정은호
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanCntrInfoVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.ViewAdapter;

/**
 * EesEqr0094 화면 IBSheet XML 생성<br>
 * - IBSheet로 반환할 서버처리결과를 XML로 변환하는 클래스이다.<br>
 * 
 * @author ChungEunHo
 * @see ViewAdapter 참조
 * @since J2EE 1.6
 */
public class EesEqr0094ViewAdapter extends ViewAdapter {

	
	/**
	 * VO List를 Parsing하여 <Data>태그 부분의 XML문자열을 반환한다.<br>
	 * 
	 * @param vos List<AbstractValueObject> List 객체
	 * @param colOrder String[] Column명 문자열 
	 * @param prefix String IBSheet savename's prefix
	 * @return String <Data>태그 부분의 XML문자열
	 * @exception 
	 */	
	@SuppressWarnings("unchecked")
	protected String makeDataTag(List<AbstractValueObject> vos, String prefix) {
		CommonRsVO listVO = new CommonRsVO();
		AbstractValueObject rsVO = (AbstractValueObject)vos.get(0);
		ObjectCloner.build(rsVO, listVO);
		EesEqr0094ConditionVO conditionVO = (EesEqr0094ConditionVO) listVO.getConditionVO();
		
		
		List resultVOList = listVO.getResultVOList();
		String row = "";
		String[] cntr_no	= new String[1];
		String[] cntr_tpsz_cd  = new String[1];
		String[] lstm_cd  = new String[1];
		String[] mvmt_sts_cd  = new String[1];
		String[] vndr_abbr_nm  = new String[1];
		String[] curr_ind  = new String[1];
		String[] dmg_flg  = new String[1];
		String[] cntr_hngr_rck_cd  = new String[1];
		String[] cntr_hngr_bar_atch_knt  = new String[1];
		String[] rfub_flg  = new String[1];
		String[] disp_flg  = new String[1];
		String[] plst_flr_flg  = new String[1];
		String[] imdt_ext_flg  = new String[1];
		String[] rf_tp_cd_c  = new String[1];
		String[] rf_tp_cd_h  = new String[1];
		
		StringBuilder sbufXML = new StringBuilder();
		
		StringBuilder sbCntrNo = new StringBuilder();
		StringBuilder sbCntrTpszCd = new StringBuilder();
		StringBuilder sbLstmCd = new StringBuilder();
		StringBuilder sbMvmtStsCd = new StringBuilder();
		StringBuilder sbVndrAbrNm = new StringBuilder();
		StringBuilder sbCurrInd = new StringBuilder();
		StringBuilder sbDmgFlg = new StringBuilder();
		StringBuilder sbCntrHngrRckCd = new StringBuilder();
		StringBuilder sbCntrHngrBarAtchKnt = new StringBuilder();
		StringBuilder sbRfubFlg = new StringBuilder();
		StringBuilder sbDispFlg = new StringBuilder();
		StringBuilder sbPlstFlrFlg = new StringBuilder();
		StringBuilder sbImdtExtFlg = new StringBuilder();
		StringBuilder sbRfTpCdc = new StringBuilder();
		StringBuilder sbRfTpCdh = new StringBuilder();

		cntr_no[0] = "";
		cntr_tpsz_cd[0]  = "";
		lstm_cd[0]  = "";
		mvmt_sts_cd[0]  = "";
		vndr_abbr_nm[0]  = "";
		curr_ind[0]  = "";
		dmg_flg[0]  = "";
		cntr_hngr_rck_cd[0]  = "";
		cntr_hngr_bar_atch_knt[0]  = "";
		rfub_flg[0]  = "";
		disp_flg[0]  = "";
		plst_flr_flg[0]  = "";
		imdt_ext_flg[0]  = "";
		rf_tp_cd_c[0]  = "";
		rf_tp_cd_h[0]  = "";
		
		row 	= conditionVO.getRow();
		
		// 상단Sheet의 경우
		if (resultVOList != null && resultVOList.size() > 0) {
			int totCnt = resultVOList.size();
			//int realCnt = resultVOList.size();

			AbstractValueObject vo = (AbstractValueObject)resultVOList.get(0);
			//String[] realColNms=getColHeader(vo);
			//String[] changedColNms = getChangedColNms(realColNms, prefix);
			
			if(vo.getMaxRows()>0){
				totCnt = vo.getMaxRows();
			}
			
			if(totCnt > 0){
				Iterator iterator = resultVOList.iterator();
				while(iterator.hasNext()){
					SearchExecutionPlanCntrInfoVO voInfoVO = (SearchExecutionPlanCntrInfoVO)iterator.next();
					sbCntrNo.append(JSPUtil.getNull(voInfoVO.getCntrNo()));
					sbCntrTpszCd.append(JSPUtil.getNull(voInfoVO.getCntrTpszCd()));
					sbLstmCd.append(JSPUtil.getNull(voInfoVO.getLstmCd()));
					sbMvmtStsCd.append(JSPUtil.getNull(voInfoVO.getMvmtStsCd()));
					sbVndrAbrNm.append(JSPUtil.getNull(voInfoVO.getVndrAbbrNm()));
					sbCurrInd.append(JSPUtil.getNull(voInfoVO.getCntrUseCoCd()));
					sbDmgFlg.append(JSPUtil.getNull(voInfoVO.getDmgFlg()));
					sbCntrHngrRckCd.append(JSPUtil.getNull(voInfoVO.getCntrHngrRckCd()));
					sbCntrHngrBarAtchKnt.append(JSPUtil.getNull(voInfoVO.getCntrHngrBarAtchKnt()));
					sbRfubFlg.append(JSPUtil.getNull(voInfoVO.getRfubFlg()));
					sbDispFlg.append(JSPUtil.getNull(voInfoVO.getDispFlg()));
					sbPlstFlrFlg.append(JSPUtil.getNull(voInfoVO.getPlstFlrFlg()));
					sbImdtExtFlg.append(JSPUtil.getNull(voInfoVO.getImdtExtFlg()));
					sbRfTpCdc.append(JSPUtil.getNull(voInfoVO.getRfTpCdC()));
					sbRfTpCdh.append(JSPUtil.getNull(voInfoVO.getRfTpCdH()));
					
					/*cntr_no[0] += JSPUtil.getNull(voInfoVO.getCntrNo());					
					cntr_tpsz_cd[0]  += JSPUtil.getNull(voInfoVO.getCntrTpszCd());
					lstm_cd[0]  += JSPUtil.getNull(voInfoVO.getLstmCd());
					mvmt_sts_cd[0]  += JSPUtil.getNull(voInfoVO.getMvmtStsCd()); // CTM_MOVEMENT.CNMV_STS_CD 필드명 변경됨 09.08.21 By ChungEunHo
					vndr_abbr_nm[0]  += JSPUtil.getNull(voInfoVO.getVndrAbbrNm());
					curr_ind[0]  += JSPUtil.getNull(voInfoVO.getCntrUseCoCd());
					dmg_flg[0]  += JSPUtil.getNull(voInfoVO.getDmgFlg());
					cntr_hngr_rck_cd[0]  += JSPUtil.getNull(voInfoVO.getCntrHngrRckCd()); // MST_CONTAINER.CNTR_HNGR_RCK_FLG 필드명 변경됨 09.08.21 By ChungEunHo
					cntr_hngr_bar_atch_knt[0]  += JSPUtil.getNull(voInfoVO.getCntrHngrBarAtchKnt()); // MST_CONTAINER.CNTR_HNGR_BAR_FLG 필드명 변경됨 09.08.21 By ChungEunHo
					rfub_flg[0]  += JSPUtil.getNull(voInfoVO.getRfubFlg());
					disp_flg[0]  += JSPUtil.getNull(voInfoVO.getDispFlg());
					plst_flr_flg[0]  += JSPUtil.getNull(voInfoVO.getPlstFlrFlg());
					imdt_ext_flg[0]  += JSPUtil.getNull(voInfoVO.getImdtExtFlg());
					rf_tp_cd_c[0]  += JSPUtil.getNull(voInfoVO.getRfTpCdC());
					rf_tp_cd_h[0]  += JSPUtil.getNull(voInfoVO.getRfTpCdH());*/
				}
			}		
		}
		
		cntr_no[0] = sbCntrNo.toString();
		cntr_tpsz_cd[0] =sbCntrTpszCd.toString();
		lstm_cd[0] =sbLstmCd.toString();
		mvmt_sts_cd[0] =sbMvmtStsCd.toString();
		vndr_abbr_nm[0] =sbVndrAbrNm.toString();
		curr_ind[0] =sbCurrInd.toString();
		dmg_flg[0] =sbDmgFlg.toString();
		cntr_hngr_rck_cd[0] =sbCntrHngrRckCd.toString();
		cntr_hngr_bar_atch_knt[0] =sbCntrHngrBarAtchKnt.toString();
		rfub_flg[0] =sbRfubFlg.toString();
		disp_flg[0] =sbDispFlg.toString();
		plst_flr_flg[0] =sbPlstFlrFlg.toString();
		imdt_ext_flg[0] =sbImdtExtFlg.toString();
		rf_tp_cd_c[0] =sbRfTpCdc.toString();
		rf_tp_cd_h[0] =sbRfTpCdh.toString();

		sbufXML.append("<DATA>\n");
		sbufXML.append("	<TR ROW='"+row+"'>\n");
		sbufXML.append("	<TD COL='cntr_no' DATA-TYPE='dtData'><![CDATA["+cntr_no[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='cntr_tpsz_cd' DATA-TYPE='dtData'><![CDATA["+cntr_tpsz_cd[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='lstm_cd' DATA-TYPE='dtData'><![CDATA["+lstm_cd[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='mvmt_sts_cd' DATA-TYPE='dtData'><![CDATA["+mvmt_sts_cd[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='vndr_abbr_nm' DATA-TYPE='dtData'><![CDATA["+vndr_abbr_nm[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='cntr_use_co_cd' DATA-TYPE='dtData'><![CDATA["+curr_ind[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='dmg_flg' DATA-TYPE='dtData'><![CDATA["+dmg_flg[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='cntr_hngr_rck_cd' DATA-TYPE='dtData'><![CDATA["+cntr_hngr_rck_cd[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='cntr_hngr_bar_atch_knt' DATA-TYPE='dtData'><![CDATA["+cntr_hngr_bar_atch_knt[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='rfub_flg' DATA-TYPE='dtData'><![CDATA["+rfub_flg[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='disp_flg' DATA-TYPE='dtData'><![CDATA["+disp_flg[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='plst_flr_flg' DATA-TYPE='dtData'><![CDATA["+plst_flr_flg[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='imdt_ext_flg' DATA-TYPE='dtData'><![CDATA["+imdt_ext_flg[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='rf_tp_cd_c' DATA-TYPE='dtData'><![CDATA["+rf_tp_cd_c[0]+"]]></TD>\n");
		sbufXML.append("	<TD COL='rf_tp_cd_h' DATA-TYPE='dtData'><![CDATA["+rf_tp_cd_h[0]+"]]></TD>\n");
		sbufXML.append("	</TR>\n");
		sbufXML.append("</DATA>\n");
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
