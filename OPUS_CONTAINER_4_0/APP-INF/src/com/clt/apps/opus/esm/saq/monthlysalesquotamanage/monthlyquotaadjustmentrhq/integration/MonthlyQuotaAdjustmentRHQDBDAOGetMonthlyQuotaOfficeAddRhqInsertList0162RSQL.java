/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddRhqInsertList0162RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddRhqInsertList0162RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 04 Step 사용 DB에 입력한 List를 문자열로 리턴.
	  * </pre>
	  */
	public MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddRhqInsertList0162RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaAdjustmentRHQDBDAOGetMonthlyQuotaOfficeAddRhqInsertList0162RSQL").append("\n"); 
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
		query.append("SELECT SUB_TRD_CD||' / '||RLANE_CD||' / '||CTRT_RHQ_CD||' / '||" ).append("\n"); 
		query.append("          DECODE(CTRT_AQ_CD, '', '', CTRT_AQ_CD||' / ')||CTRT_RGN_OFC_CD||' / '||" ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(BSE_MON, 'MM'), 'Month', 'NLS_DATE_LANGUAGE=AMERICAN') AS MSG" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT DISTINCT SUB_TRD_CD, RLANE_CD, CTRT_RHQ_CD, CTRT_AQ_CD, CTRT_RGN_OFC_CD, BSE_MON" ).append("\n"); 
		query.append("              FROM SAQ_MON_QTA_RHQ" ).append("\n"); 
		query.append("             WHERE OFC_ADD_FLG     = 'Y'" ).append("\n"); 
		query.append("               AND MQTA_STEP_CD    = @[mqta_step_cd]" ).append("\n"); 
		query.append("               AND BSE_YR          = @[bse_yr]" ).append("\n"); 
		query.append("               AND BSE_QTR_CD      = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND TRD_CD          = @[trd_cd]" ).append("\n"); 
		query.append("               AND DIR_CD          = @[dir_cd]" ).append("\n"); 
		query.append("               AND MQTA_VER_NO     = @[mqta_ver_no]" ).append("\n"); 
		query.append("               AND CTRT_RHQ_CD     = @[rhq_cd]" ).append("\n"); 
		query.append("               AND SUB_TRD_CD      = @[sub_trd_cd]" ).append("\n"); 
		query.append("               AND RLANE_CD        = @[rlane_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${aq_cd} != '') " ).append("\n"); 
		query.append("			   AND CTRT_AQ_CD      = @[aq_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("			   AND CTRT_AQ_CD      IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               AND CTRT_RGN_OFC_CD = @[rgn_ofc_cd] )" ).append("\n"); 
		query.append(" ORDER BY SUB_TRD_CD, DECODE(RLANE_CD, 'RBCCO', 'ZZ', SUBSTR(RLANE_CD, -2)), RLANE_CD, CTRT_RHQ_CD," ).append("\n"); 
		query.append("          DECODE(CTRT_AQ_CD, '', '', (DECODE(NVL(CTRT_AQ_CD, 99), '99', 99, 11)||CTRT_AQ_CD)), CTRT_RGN_OFC_CD, BSE_MON" ).append("\n"); 

	}
}