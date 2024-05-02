/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommApprovalDBDAOSearchAGNCommApprovalDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommApprovalDBDAOSearchAGNCommApprovalDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AGNCommApprovalDBDAOSearchAGNCommApprovalDetailListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aud_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.integration").append("\n"); 
		query.append("FileName : AGNCommApprovalDBDAOSearchAGNCommApprovalDetailListRSQL").append("\n"); 
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
		query.append("SELECT A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("       NVL(B.BL_NO, 'OTHERS') AS BL_NO," ).append("\n"); 
		query.append("       A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       DECODE(A.AC_TP_CD, 'G', 1, 'K', 2, 'H', 3, 'N', 4, 'R', 5, 'S', 6, 'C',  7, 8) AS AC_TP_CD_SEQ," ).append("\n"); 
		query.append("       DECODE(A.AC_TP_CD, 'G', 'General', 'K', 'Brokerage', 'H', 'CHF', 'N', 'CSF', 'R', 'RCSF', 'S', 'T/S', 'C', 'Cross', 'Others') AS AC_TP_CD," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       A.AP_OFC_CD," ).append("\n"); 
		query.append("       C.BKG_STS_CD," ).append("\n"); 
		query.append("       A.PAY_IF_AMT," ).append("\n"); 
		query.append("       ROUND((A.PAY_IF_AMT * DECODE(A.INV_TAX_RT,'',0,A.INV_TAX_RT) / 100) + A.PAY_IF_AMT,2) AS IF_AMT" ).append("\n"); 
		query.append("  FROM ACM_AGN_COMM A," ).append("\n"); 
		query.append("       ACM_AGN_BKG_INFO B," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if(${aud_no} != '')" ).append("\n"); 
		query.append("   AND A.AUD_NO = @[aud_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${csr_no} != '')" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ( 'PS', 'IF' )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("   AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT A.AC_VSL_CD||A.AC_SKD_VOY_NO||A.AC_SKD_DIR_CD||A.AC_REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("       NVL(A.OTR_COMM_NO, 'OTHERS') AS BL_NO," ).append("\n"); 
		query.append("       A.OTR_COMM_NO BKG_NO," ).append("\n"); 
		query.append("       A.AGN_CD," ).append("\n"); 
		query.append("       DECODE(A.AC_TP_CD, 'G', 1, 'K', 2, 'H', 3, 'N', 4, 'R', 5, 'S', 6, 'C',  7, 8) AS AC_TP_CD_SEQ," ).append("\n"); 
		query.append("       DECODE(A.AC_TP_CD, 'G', 'General', 'K', 'Brokerage', 'H', 'CHF', 'N', 'CSF', 'R', 'RCSF', 'S', 'T/S', 'C', 'Cross', 'Others') AS AC_TP_CD," ).append("\n"); 
		query.append("       A.AR_OFC_CD," ).append("\n"); 
		query.append("       A.AP_OFC_CD," ).append("\n"); 
		query.append("       C.BKG_STS_CD," ).append("\n"); 
		query.append("       A.PAY_IF_AMT," ).append("\n"); 
		query.append("       ROUND((A.PAY_IF_AMT * DECODE(A.INV_TAX_RT,'',0,A.INV_TAX_RT) / 100) + A.PAY_IF_AMT,2) AS IF_AMT" ).append("\n"); 
		query.append("  FROM ACM_AGN_OTR_COMM A," ).append("\n"); 
		query.append("       BKG_BOOKING C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("#if(${aud_no} != '')" ).append("\n"); 
		query.append("   AND A.AUD_NO = @[aud_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${csr_no} != '')" ).append("\n"); 
		query.append("   AND A.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ac_sts_cd} == 'AS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = 'AS'" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'PS')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD IN ( 'PS', 'IF' )" ).append("\n"); 
		query.append("#elseif(${ac_sts_cd} == 'IC')" ).append("\n"); 
		query.append("   AND A.AC_STS_CD = @[ac_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("   AND A.OTR_COMM_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append(" ORDER BY VVD, BL_NO, BKG_NO, AGN_CD, AC_TP_CD_SEQ" ).append("\n"); 

	}
}