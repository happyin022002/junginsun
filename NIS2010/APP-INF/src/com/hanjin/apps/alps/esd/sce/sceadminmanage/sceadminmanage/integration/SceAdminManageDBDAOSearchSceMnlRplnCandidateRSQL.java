/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SceAdminManageDBDAOSearchSceMnlRplnCandidateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.03.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOSearchSceMnlRplnCandidateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * replan 할 LEA 결산 대상 리스트를 조회한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOSearchSceMnlRplnCandidateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOSearchSceMnlRplnCandidateRSQL").append("\n"); 
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
		query.append("X.COP_COP_NO COP_NO" ).append("\n"); 
		query.append(",'T' IO_BND_CD" ).append("\n"); 
		query.append(",'N' RPLN_SCS_FLG" ).append("\n"); 
		query.append(",'LEAACCT' CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'T'" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("XX.COP_COP_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.PCTL_NO" ).append("\n"); 
		query.append(",H.MST_COP_NO" ).append("\n"); 
		query.append(",T.CRE_DT" ).append("\n"); 
		query.append(",T.UPD_DT" ).append("\n"); 
		query.append(",S.BKG_NO LEA_BKG_NO" ).append("\n"); 
		query.append(",S.CNTR_NO" ).append("\n"); 
		query.append(",P.COP_NO COP_COP_NO" ).append("\n"); 
		query.append(",P.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",P.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",P.N1ST_NOD_CD" ).append("\n"); 
		query.append(",P.N2ND_NOD_CD" ).append("\n"); 
		query.append(",P.N3RD_NOD_CD" ).append("\n"); 
		query.append(",P.N4TH_NOD_CD" ).append("\n"); 
		query.append(",T.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_CSR_MNTR S," ).append("\n"); 
		query.append("SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_PLN_SO_LIST P," ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("WHERE H.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND H.CNTR_NO= S.CNTR_NO" ).append("\n"); 
		query.append("AND H.COP_STS_CD<>'X'" ).append("\n"); 
		query.append("AND T.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND T.EQ_NO = S.CNTR_NO" ).append("\n"); 
		query.append("AND T.COP_NO = P.COP_NO" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_SEQ = P.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_CD = P.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("AND T.DELT_FLG='N'" ).append("\n"); 
		query.append("AND P.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD NOT IN ('P', 'U')" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N')='N'" ).append("\n"); 
		query.append("AND NVL(T.RPLN_UMCH_FLG,'N')='N'" ).append("\n"); 
		query.append("AND ((P.N1ST_NOD_CD <> T.FM_NOD_CD))" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("GROUP BY XX.COP_COP_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.COP_COP_NO" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("X.COP_COP_NO COP_NO" ).append("\n"); 
		query.append(",'T' IO_BND_CD" ).append("\n"); 
		query.append(",'N' RPLN_SCS_FLG" ).append("\n"); 
		query.append(",'LEAACCT' CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'SYSTEM'" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",'T'" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("XX.COP_COP_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("H.PCTL_NO" ).append("\n"); 
		query.append(",H.MST_COP_NO" ).append("\n"); 
		query.append(",T.CRE_DT" ).append("\n"); 
		query.append(",T.UPD_DT" ).append("\n"); 
		query.append(",S.BKG_NO LEA_BKG_NO" ).append("\n"); 
		query.append(",S.CNTR_NO" ).append("\n"); 
		query.append(",P.COP_NO COP_COP_NO" ).append("\n"); 
		query.append(",P.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",P.COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",P.N1ST_NOD_CD" ).append("\n"); 
		query.append(",P.N2ND_NOD_CD" ).append("\n"); 
		query.append(",P.N3RD_NOD_CD" ).append("\n"); 
		query.append(",P.N4TH_NOD_CD" ).append("\n"); 
		query.append(",T.*" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("SCE_CSR_MNTR S," ).append("\n"); 
		query.append("SCE_COP_HDR H," ).append("\n"); 
		query.append("SCE_PLN_SO_LIST P," ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("WHERE H.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND H.CNTR_NO= S.CNTR_NO" ).append("\n"); 
		query.append("AND H.COP_STS_CD<>'X'" ).append("\n"); 
		query.append("AND T.BKG_NO = S.BKG_NO" ).append("\n"); 
		query.append("AND T.EQ_NO = S.CNTR_NO" ).append("\n"); 
		query.append("AND T.COP_NO = P.COP_NO" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_SEQ = P.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("AND T.COST_ACT_GRP_CD = P.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("AND T.DELT_FLG='N'" ).append("\n"); 
		query.append("AND P.COP_NO = H.COP_NO" ).append("\n"); 
		query.append("AND P.TRSP_SO_STS_CD NOT IN ('P', 'U')" ).append("\n"); 
		query.append("AND NVL(T.TRSP_FRST_FLG,'N')='N'" ).append("\n"); 
		query.append("AND ((P.N1ST_NOD_CD <> T.FM_NOD_CD))" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("GROUP BY XX.COP_COP_NO" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("GROUP BY X.COP_COP_NO" ).append("\n"); 

	}
}