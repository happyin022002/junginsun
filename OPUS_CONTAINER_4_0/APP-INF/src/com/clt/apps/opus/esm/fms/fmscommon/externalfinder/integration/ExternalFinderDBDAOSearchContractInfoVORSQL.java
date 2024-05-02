/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDBDAOSearchContractInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDBDAOSearchContractInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS Contract Info Search
	  * </pre>
	  */
	public ExternalFinderDBDAOSearchContractInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_slip_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDBDAOSearchContractInfoVORSQL").append("\n"); 
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
		query.append("SELECT (SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL CD" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD01513'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = A.FLET_CTRT_TP_CD) FLET_CTRT_TP_NM" ).append("\n"); 
		query.append("     , VNDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_VENDOR" ).append("\n"); 
		query.append("         WHERE VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("           AND DELT_FLG = 'N') VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD" ).append("\n"); 
		query.append("     , A.CUST_SEQ" ).append("\n"); 
		query.append("     , (SELECT M.CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("         WHERE M.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND M.CUST_SEQ = A.CUST_SEQ) AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT CASE WHEN (A.FLET_CTRT_TP_CD = 'TO' AND @[call_slip_tp_cd] = 'P') THEN " ).append("\n"); 
		query.append("                        (SELECT M.VNDR_SEQ" ).append("\n"); 
		query.append("                           FROM MDM_CUSTOMER M" ).append("\n"); 
		query.append("                          WHERE M.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("                            AND M.CUST_SEQ = A.CUST_SEQ)" ).append("\n"); 
		query.append("                   ELSE A.VNDR_SEQ" ).append("\n"); 
		query.append("               END VNDR_SEQ" ).append("\n"); 
		query.append("             , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , A.CUST_CNT_CD" ).append("\n"); 
		query.append("             , A.CUST_SEQ" ).append("\n"); 
		query.append("          FROM FMS_CONTRACT A" ).append("\n"); 
		query.append("         WHERE A.FLET_CTRT_NO = @[flet_ctrt_no] " ).append("\n"); 
		query.append("        ) A" ).append("\n"); 

	}
}