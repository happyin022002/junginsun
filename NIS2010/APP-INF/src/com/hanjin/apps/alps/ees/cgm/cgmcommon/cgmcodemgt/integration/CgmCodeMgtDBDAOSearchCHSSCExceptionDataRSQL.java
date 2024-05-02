/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmCodeMgtDBDAOSearchCHSSCExceptionDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.03.21 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOSearchCHSSCExceptionDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * -------------------------------------------------------------------------------------------------------------------------------------------
	  * [자체 CSR] 2014-01-22 Jonghee HAN Row copy 및 Data Update시 Eff_dt, Exp_dt가 IBSheet내에 저장되지 않게 Coding에 되어 있어 해당 Data가 누락되는 현상 복구
	  * -------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public CgmCodeMgtDBDAOSearchCHSSCExceptionDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOSearchCHSSCExceptionDataRSQL").append("\n"); 
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
		query.append("WITH LV_PARM AS (" ).append("\n"); 
		query.append("    SELECT @[prop_no] PROP_NO," ).append("\n"); 
		query.append("      @[sc_expt_ver_seq] SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("    FROM DUAL ) ," ).append("\n"); 
		query.append("  LV_CURR_LIST AS (" ).append("\n"); 
		query.append("    SELECT 'C' STS," ).append("\n"); 
		query.append("      LOC_CD," ).append("\n"); 
		query.append("      CUST_CNT_CD," ).append("\n"); 
		query.append("      CUST_SEQ," ).append("\n"); 
		query.append("      CHSS_CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("      CMDT_CD," ).append("\n"); 
		query.append("      USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("      EFF_DT," ).append("\n"); 
		query.append("      EXP_DT," ).append("\n"); 
		query.append("	  A.SC_EXPT_VER_SEQ," ).append("\n"); 
		query.append("	  A.SC_EXPT_GRP_SEQ," ).append("\n"); 
		query.append("	  A.PROP_NO," ).append("\n"); 
		query.append("      A.FT_DYS" ).append("\n"); 
		query.append("    FROM CGM_SC_EXPT_LIST A," ).append("\n"); 
		query.append("      LV_PARM P" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = P.PROP_NO" ).append("\n"); 
		query.append("      AND A.SC_EXPT_VER_SEQ = P.SC_EXPT_VER_SEQ ) ," ).append("\n"); 
		query.append("  LV_OLD_LIST AS (" ).append("\n"); 
		query.append("    SELECT 'O' STS," ).append("\n"); 
		query.append("      LOC_CD," ).append("\n"); 
		query.append("      CUST_CNT_CD," ).append("\n"); 
		query.append("      CUST_SEQ," ).append("\n"); 
		query.append("      CHSS_CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("      CMDT_CD," ).append("\n"); 
		query.append("      USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("      EFF_DT," ).append("\n"); 
		query.append("      EXP_DT," ).append("\n"); 
		query.append("	  A.SC_EXPT_VER_SEQ," ).append("\n"); 
		query.append("	  A.SC_EXPT_GRP_SEQ," ).append("\n"); 
		query.append("	  A.PROP_NO," ).append("\n"); 
		query.append("      A.FT_DYS" ).append("\n"); 
		query.append("    FROM CGM_SC_EXPT_LIST A," ).append("\n"); 
		query.append("      LV_PARM P" ).append("\n"); 
		query.append("    WHERE A.PROP_NO = P.PROP_NO" ).append("\n"); 
		query.append("      AND A.SC_EXPT_VER_SEQ = P.SC_EXPT_VER_SEQ-1 )" ).append("\n"); 
		query.append("SELECT TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("  TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("  A.STS," ).append("\n"); 
		query.append("  A.LOC_CD," ).append("\n"); 
		query.append("  A.CUST_CNT_CD," ).append("\n"); 
		query.append("  A.CUST_SEQ," ).append("\n"); 
		query.append("  A.CHSS_CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("  A.CMDT_CD," ).append("\n"); 
		query.append("  A.USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("  REPLACE((A.CUST_CNT_CD || TO_CHAR(A.CUST_SEQ, '000000')), ' ', '') CUST_CD," ).append("\n"); 
		query.append("  (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ) CUST_NM," ).append("\n"); 
		query.append("  (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = A.CMDT_CD AND DELT_FLG = 'N') CMDT_NM," ).append("\n"); 
		query.append("  NVL((" ).append("\n"); 
		query.append("        SELECT 'E'" ).append("\n"); 
		query.append("        FROM LV_OLD_LIST B" ).append("\n"); 
		query.append("        WHERE A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("          AND NVL(A.CUST_CNT_CD, 'X') = NVL(B.CUST_CNT_CD, 'X')" ).append("\n"); 
		query.append("          AND NVL(A.CUST_SEQ, 0) = NVL(B.CUST_SEQ, 0)" ).append("\n"); 
		query.append("          AND NVL(A.CHSS_CNTR_CGO_TP_CD, 'X') = NVL(B.CHSS_CNTR_CGO_TP_CD, 'X')" ).append("\n"); 
		query.append("          AND NVL(A.CMDT_CD, 'X') = NVL(B.CMDT_CD, 'X') ), 'I') CUD_FLG," ).append("\n"); 
		query.append("	A.SC_EXPT_VER_SEQ," ).append("\n"); 
		query.append("	A.SC_EXPT_GRP_SEQ," ).append("\n"); 
		query.append("	A.PROP_NO," ).append("\n"); 
		query.append("    A.FT_DYS" ).append("\n"); 
		query.append("FROM LV_CURR_LIST A" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT TO_CHAR(A.EFF_DT, 'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("  TO_CHAR(A.EXP_DT, 'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("  A.STS," ).append("\n"); 
		query.append("  A.LOC_CD," ).append("\n"); 
		query.append("  A.CUST_CNT_CD," ).append("\n"); 
		query.append("  A.CUST_SEQ," ).append("\n"); 
		query.append("  A.CHSS_CNTR_CGO_TP_CD," ).append("\n"); 
		query.append("  A.CMDT_CD," ).append("\n"); 
		query.append("  A.USA_SC_EXPT_RMK," ).append("\n"); 
		query.append("  REPLACE((A.CUST_CNT_CD || TO_CHAR(A.CUST_SEQ, '000000')), ' ', '') CUST_CD," ).append("\n"); 
		query.append("  (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.CUST_CNT_CD AND CUST_SEQ = A.CUST_SEQ) CUST_NM," ).append("\n"); 
		query.append("  (SELECT CMDT_NM FROM MDM_COMMODITY WHERE CMDT_CD = A.CMDT_CD AND DELT_FLG = 'N') CMDT_NM," ).append("\n"); 
		query.append("  'D' CUD_FLG," ).append("\n"); 
		query.append("   A.SC_EXPT_VER_SEQ," ).append("\n"); 
		query.append("   A.SC_EXPT_GRP_SEQ," ).append("\n"); 
		query.append("   A.PROP_NO," ).append("\n"); 
		query.append("   A.FT_DYS" ).append("\n"); 
		query.append("FROM LV_OLD_LIST A," ).append("\n"); 
		query.append("  LV_CURR_LIST B" ).append("\n"); 
		query.append("WHERE A.LOC_CD = B.LOC_CD(+)" ).append("\n"); 
		query.append("  AND NVL(A.CUST_CNT_CD, 'X') = NVL(B.CUST_CNT_CD(+), 'X')" ).append("\n"); 
		query.append("  AND NVL(A.CUST_SEQ, 0) = NVL(B.CUST_SEQ(+), 0)" ).append("\n"); 
		query.append("  AND NVL(A.CHSS_CNTR_CGO_TP_CD, 'X') = NVL(B.CHSS_CNTR_CGO_TP_CD(+), 'X')" ).append("\n"); 
		query.append("  AND NVL(A.CMDT_CD, 'X')= NVL(B.CMDT_CD(+), 'X')" ).append("\n"); 
		query.append("  AND B.LOC_CD IS NULL" ).append("\n"); 
		query.append("ORDER BY STS, LOC_CD, CUST_CNT_CD, CUST_SEQ, CHSS_CNTR_CGO_TP_CD, CMDT_CD" ).append("\n"); 

	}
}