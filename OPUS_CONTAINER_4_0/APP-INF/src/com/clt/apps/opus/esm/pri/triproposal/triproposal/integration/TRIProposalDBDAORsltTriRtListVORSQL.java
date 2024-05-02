/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TRIProposalDBDAORsltTriRtListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.25 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TRIProposalDBDAORsltTriRtListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRI Rate 조회
	  * </pre>
	  */
	public TRIProposalDBDAORsltTriRtListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tri_prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.triproposal.triproposal.integration").append("\n"); 
		query.append("FileName : TRIProposalDBDAORsltTriRtListVORSQL").append("\n"); 
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
		query.append("SELECT T.TRI_PROP_NO" ).append("\n"); 
		query.append("      ,T.AMDT_SEQ" ).append("\n"); 
		query.append("      ,T.RAT_UT_CD" ).append("\n"); 
		query.append("      ,T.PRC_CGO_TP_CD" ).append("\n"); 
		query.append("      ,T.CURR_CD" ).append("\n"); 
		query.append("      ,T.PROP_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,T.COFFR_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,T.FNL_FRT_RT_AMT" ).append("\n"); 
		query.append("      ,T.NOTE_CTNT" ).append("\n"); 
		query.append("      ,T.NOTE_CONV_MAPG_ID" ).append("\n"); 
		query.append("      ,TO_CHAR(T.EFF_DT, 'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(T.EXP_DT, 'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("      ,T.TRI_RQST_OFC_CD" ).append("\n"); 
		query.append("      ,T.TRI_RQST_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER" ).append("\n"); 
		query.append("         WHERE USR_ID = T.TRI_RQST_USR_ID" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS TRI_RQST_USR_NM" ).append("\n"); 
		query.append("      ,T.TRI_APRO_OFC_CD" ).append("\n"); 
		query.append("      ,T.TRI_APRO_USR_ID" ).append("\n"); 
		query.append("      ,(SELECT USR_NM" ).append("\n"); 
		query.append("          FROM COM_USER" ).append("\n"); 
		query.append("         WHERE USR_ID = T.TRI_APRO_USR_ID" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS TRI_APRO_USR_NM" ).append("\n"); 
		query.append("      ,T.PROP_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID = 'CD02395'" ).append("\n"); 
		query.append("           AND INTG_CD_VAL_CTNT = T.PROP_STS_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS PROP_STS_NM" ).append("\n"); 
		query.append("      ,TO_CHAR(T.PUB_DT, 'YYYY-MM-DD') AS PUB_DT" ).append("\n"); 
		query.append("      ,T.GRI_APPL_TP_CD" ).append("\n"); 
		query.append("      ,T.GRI_APPL_AMT" ).append("\n"); 
		query.append("      ,NVL2(M.TRI_NO, SUBSTR(M.TRI_NO, 1, 6) || '-' || SUBSTR(M.TRI_NO, 7, 4) || '-' || SUBSTR(M.TRI_NO, 11), NULL) AS TRI_NO" ).append("\n"); 
		query.append("      ,M.CMDT_CD" ).append("\n"); 
		query.append("      ,T.TRI_RMK" ).append("\n"); 
		query.append("  FROM PRI_TRI_RT T, PRI_TRI_MN M" ).append("\n"); 
		query.append(" WHERE T.TRI_PROP_NO = M.TRI_PROP_NO" ).append("\n"); 
		query.append("   AND T.TRI_PROP_NO = @[tri_prop_no]" ).append("\n"); 
		query.append(" ORDER BY T.AMDT_SEQ DESC" ).append("\n"); 

	}
}