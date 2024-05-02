/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTAuditDBDAOSearchAPActualInterfaceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.08 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOSearchAPActualInterfaceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPActualInterfaceDetail
	  * </pre>
	  */
	public AGTAuditDBDAOSearchAPActualInterfaceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_option",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOSearchAPActualInterfaceDetailRSQL").append("\n"); 
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
		query.append("		   A.COMM_VSL_CD||A.COMM_SKD_VOY_NO||A.COMM_SKD_DIR_CD||A.COMM_REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("           NVL(B.BL_NO, 'OTHERS') AS BL_NO," ).append("\n"); 
		query.append("           A.BKG_NO BKG_NO," ).append("\n"); 
		query.append("           A.AGN_CD," ).append("\n"); 
		query.append("           --DECODE(A.AC_TP_CD,'G',1,'N',2,'K',3,'H',4,'S',5,'R',6,'O',7,'C',8,'D',9,10) AS SEQ," ).append("\n"); 
		query.append("           (	" ).append("\n"); 
		query.append("				SELECT INTG_CD_VAL_DESC " ).append("\n"); 
		query.append("                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                 WHERE INTG_CD_ID = 'CD20039' " ).append("\n"); 
		query.append("                   AND INTG_CD_VAL_CTNT = A.AC_TP_CD     " ).append("\n"); 
		query.append("						--'Common1','Common2','Brokerage','T/S','T/R','SOC','Cross','Doc','OTHERS'     " ).append("\n"); 
		query.append("           )             		  AS TP," ).append("\n"); 
		query.append("           A.AR_OFC_CD," ).append("\n"); 
		query.append("           A.AP_OFC_CD," ).append("\n"); 
		query.append("		   C.BKG_STS_CD," ).append("\n"); 
		query.append("           A.ACT_IF_LOCL_COMM_AMT AS IF_AMT" ).append("\n"); 
		query.append("      FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("           AGT_COMM_BKG_INFO B," ).append("\n"); 
		query.append("		   BKG_BOOKING C" ).append("\n"); 
		query.append("     WHERE A.COMM_APRO_NO     = @[comm_apro_no]" ).append("\n"); 
		query.append("       AND A.COMM_PROC_STS_CD = @[if_option]" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("       AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	   AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("#if(${exp_type} == 'G')" ).append("\n"); 
		query.append("	  AND A.COMM_STND_COST_CD NOT IN ('512692','512693')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  AND A.COMM_STND_COST_CD IN ('512692','512693')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("    SELECT 'VAT' AS VVD," ).append("\n"); 
		query.append("           '' AS BL_NO," ).append("\n"); 
		query.append("           '' AS BKG_NO," ).append("\n"); 
		query.append("           '' AS AGN_CD," ).append("\n"); 
		query.append("           --NULL AS SEQ," ).append("\n"); 
		query.append("           '' AS TP," ).append("\n"); 
		query.append("           '' AS AR_OFC_CD," ).append("\n"); 
		query.append("           '' AS AP_OFC_CD," ).append("\n"); 
		query.append("		   '' AS BKG_STS_CD," ).append("\n"); 
		query.append("           ROUND(SUM(A.ACT_IF_LOCL_COMM_AMT * NVL(A.INV_TAX_RT, 0) / 100), 2) AS IF_AMT" ).append("\n"); 
		query.append("      FROM AGT_AGN_COMM A," ).append("\n"); 
		query.append("           AGT_COMM_BKG_INFO B" ).append("\n"); 
		query.append("     WHERE A.COMM_APRO_NO     = @[comm_apro_no]" ).append("\n"); 
		query.append("       AND A.COMM_PROC_STS_CD = @[if_option]" ).append("\n"); 
		query.append("       AND A.CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("       AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("#if(${exp_type} == 'G')" ).append("\n"); 
		query.append("	  AND A.COMM_STND_COST_CD NOT IN('512692','512693')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	  AND A.COMM_STND_COST_CD IN('512692','512693')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}