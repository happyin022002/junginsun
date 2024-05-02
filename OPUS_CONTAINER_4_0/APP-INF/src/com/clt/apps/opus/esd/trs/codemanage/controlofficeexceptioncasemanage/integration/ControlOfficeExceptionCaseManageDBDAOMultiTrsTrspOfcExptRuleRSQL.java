/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRule
	  * </pre>
	  */
	public ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.controlofficeexceptioncasemanage.integration").append("\n"); 
		query.append("FileName : ControlOfficeExceptionCaseManageDBDAOMultiTrsTrspOfcExptRuleRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("	FROM TRS_TRSP_OFC_EXPT_RULE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("	#foreach( $vo in ${vos} )" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("         FM_NOD_CD = NVL('$vo.fmNodCd','     ')" ).append("\n"); 
		query.append("     AND TO_NOD_CD = NVL('$vo.toNodCd','     ')" ).append("\n"); 
		query.append("     AND VIA_NOD_CD = NVL('$vo.viaNodCd','     ')" ).append("\n"); 
		query.append("     AND DOR_NOD_CD = NVL('$vo.dorNodCd','     ')" ).append("\n"); 
		query.append("     AND CTRL_OFC_DIV_CD = NVL('$vo.ctrlOfcDivCd',' ')" ).append("\n"); 
		query.append("     AND CGO_TP_CD = NVL('$vo.cgoTpCd','  ')" ).append("\n"); 
		query.append("     AND TRSP_COST_DTL_MOD_CD = NVL('$vo.trspCostDtlModCd','  ')" ).append("\n"); 
		query.append("     AND TRSP_CRR_MOD_CD = NVL('$vo.trspCrrModCd','  ')" ).append("\n"); 
		query.append("     AND CNTR_SZ_CD = NVL('$vo.cntrSzCd','  ')" ).append("\n"); 
		query.append("     AND CNTR_TP_CD = NVL('$vo.cntrTpCd','  ')" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("    #if( $velocityCount < $vos.size()) " ).append("\n"); 
		query.append("    OR " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}