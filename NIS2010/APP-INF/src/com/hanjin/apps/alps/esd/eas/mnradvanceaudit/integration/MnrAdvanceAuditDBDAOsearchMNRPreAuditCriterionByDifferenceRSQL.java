/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByDifferenceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByDifferenceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR INVOICE중 W/O EQ_NO COST CODE 별 데이터 항목을 모두 나열한다.
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByDifferenceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMNRPreAuditCriterionByDifferenceRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    'MNR' MODULE," ).append("\n"); 
		query.append("    MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.AUD_OFC_CD) RHQ_OFC_CD," ).append("\n"); 
		query.append("    A.AUD_OFC_CD OFC_CD," ).append("\n"); 
		query.append("    A.MNR_VRFY_TP_AUD_FLG OBJ_PRE_AUD," ).append("\n"); 
		query.append("    A.EXPN_MAX_PRMT_RTO RATIO," ).append("\n"); 
		query.append("    A.UPD_OFC_CD UPT_OFC_CD," ).append("\n"); 
		query.append("    TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPT_DT," ).append("\n"); 
		query.append("    A.VRFY_RMK AUT_RMK," ).append("\n"); 
		query.append("	DECODE(A.AUD_OFC_CD, MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.AUD_OFC_CD), '-1', '0') MNR_CD_DP_SEQ" ).append("\n"); 
		query.append("FROM EAS_MNR_PRE_AUD_RTO_CFG A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	1 = 1" ).append("\n"); 
		query.append("#if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND	MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(A.AUD_OFC_CD) = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND	A.AUD_OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${s_set_data_only} == '1')" ).append("\n"); 
		query.append("AND A.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	ORDER BY RHQ_OFC_CD, MNR_CD_DP_SEQ, OFC_CD" ).append("\n"); 

	}
}