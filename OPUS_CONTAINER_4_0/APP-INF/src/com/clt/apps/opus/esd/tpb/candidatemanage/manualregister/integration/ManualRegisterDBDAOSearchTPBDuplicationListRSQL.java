/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchTPBDuplicationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchTPBDuplicationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTPBDuplicationList
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchTPBDuplicationListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchTPBDuplicationListRSQL").append("\n"); 
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
		query.append("SELECT 'TPB Candidate' STATUS" ).append("\n"); 
		query.append("      ,OFC_CD" ).append("\n"); 
		query.append("      ,'' N3PTY_NO" ).append("\n"); 
		query.append("      ,N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("      ,EQ_NO" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("      ,IF_CURR_CD" ).append("\n"); 
		query.append("      ,IF_AMT" ).append("\n"); 
		query.append("      ,N3PTY_CFM_CD AS STS_CD" ).append("\n"); 
		query.append("      ,N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND N3PTY_CFM_CD IN ('R','N','I')" ).append("\n"); 
		query.append("   AND N3PTY_DELT_TP_CD IN ('N','S')" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (1 = 0" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("    OR EQ_NO IN (NULL, ${s_eq_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("    OR BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT 'TPB Case' STATUS" ).append("\n"); 
		query.append("      ,A.OFC_CD" ).append("\n"); 
		query.append("      ,A.N3PTY_NO" ).append("\n"); 
		query.append("      ,A.N3PTY_SRC_SUB_SYS_CD" ).append("\n"); 
		query.append("      ,A.EQ_NO" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("      ,TPB_GET_N3PTY_BIL_TP_NM_FNC(A.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_NM" ).append("\n"); 
		query.append("      ,A.IF_CURR_CD" ).append("\n"); 
		query.append("      ,A.IF_AMT" ).append("\n"); 
		query.append("      ,C.OTS_STS_CD AS STS_CD" ).append("\n"); 
		query.append("      ,A.N3PTY_EXPN_TP_CD" ).append("\n"); 
		query.append("  FROM TPB_OTS_DTL A, TPB_OTS_GRP B, TPB_OTS_GRP_STS C" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND A.N3PTY_NO = B.N3PTY_NO" ).append("\n"); 
		query.append("   AND B.N3PTY_NO = C.N3PTY_NO" ).append("\n"); 
		query.append("   AND A.N3PTY_CFM_CD IN ('Y')" ).append("\n"); 
		query.append("   AND B.N3PTY_DELT_TP_CD IN ('N')" ).append("\n"); 
		query.append("   AND C.OTS_STS_LST_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${s_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND A.OFC_CD = @[s_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ( 1 = 0" ).append("\n"); 
		query.append("#if (${s_eq_no} != '')" ).append("\n"); 
		query.append("    OR A.EQ_NO IN (NULL, ${s_eq_no})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("    OR A.BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY STATUS, N3PTY_NO, N3PTY_EXPN_TP_CD, EQ_NO, BKG_NO, IF_CURR_CD" ).append("\n"); 

	}
}