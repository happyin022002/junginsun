/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AGTAuditDBDAOAGTCommTobeApprovedEAIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2010.02.22 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAGTCommTobeApprovedEAIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ESM_AGT_0036 화면에서 Confirm 할때 범한 EDI I/F 용으로 조회한다.
	  * </pre>
	  */
	public AGTAuditDBDAOAGTCommTobeApprovedEAIRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_apro_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scn_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAGTCommTobeApprovedEAIRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'I' AS EAI_STS," ).append("\n"); 
		query.append("TO_CHAR	(SYSDATE, 'yyyymmddhh24miss') AS EAI_DT," ).append("\n"); 
		query.append("'EDI' AS COMPANY," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AC_SEQ," ).append("\n"); 
		query.append("COMM_PROC_STS_CD," ).append("\n"); 
		query.append("COMM_PROC_STS_RSN," ).append("\n"); 
		query.append("VNDR_CNT_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("ACT_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_COMM_AMT," ).append("\n"); 
		query.append("ACT_LOCL_COMM_AMT," ).append("\n"); 
		query.append("ACT_IF_LOCL_COMM_AMT," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("DECODE(XCH_RT_APLY_LVL, '1', VVD_XCH_RT, '2', MON_XCH_RT, '3', DLY_XCH_RT, '') AS XCH_RT," ).append("\n"); 
		query.append("CRE_USR_ID" ).append("\n"); 
		query.append("FROM AGT_AGN_COMM" ).append("\n"); 
		query.append("WHERE COMM_APRO_NO	= @[s_apro_no]" ).append("\n"); 
		query.append("AND AGN_CD IN ('SHACQ','TSNXY')" ).append("\n"); 
		query.append("AND IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND ((@[scn_id] = 'AGTCOMM' AND AC_TP_CD	<> 'T')	OR --//:scn_id" ).append("\n"); 
		query.append("(@[scn_id] = 'OTHER' AND AC_TP_CD =	'T')) --//:scn_id" ).append("\n"); 
		query.append("AND COMM_PROC_STS_CD IN ('RS', 'AS',	'IF')" ).append("\n"); 
		query.append("AND CRE_USR_ID != 'COST'" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("AGN_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("AC_TP_CD," ).append("\n"); 
		query.append("AC_SEQ" ).append("\n"); 

	}
}