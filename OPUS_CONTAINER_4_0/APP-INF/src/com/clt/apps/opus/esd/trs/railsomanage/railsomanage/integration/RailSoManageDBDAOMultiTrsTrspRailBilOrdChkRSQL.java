/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RailSoManageDBDAOMultiTrsTrspRailBilOrdChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOMultiTrsTrspRailBilOrdChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 대상이 맞는지 확인하는 조회 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOMultiTrsTrspRailBilOrdChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOMultiTrsTrspRailBilOrdChkRSQL").append("\n"); 
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
		query.append("#set(${verifyCopNo}=${verifyCopNo})" ).append("\n"); 
		query.append("#set(${verifyCostActGrpSeq}=${verifyCostActGrpSeq})" ).append("\n"); 
		query.append("#set(${verifyRoutOrgNodCd}=${verifyRoutOrgNodCd})" ).append("\n"); 
		query.append("#set(${verifyRoutDestNodCd}=${verifyRoutDestNodCd})" ).append("\n"); 
		query.append("#set(${verifyRoutSeq}=${verifyRoutSeq})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    'X' CHK_UNIT " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    DUAL " ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    'X' " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    TRS_TRSP_RAIL_BIL_ORD " ).append("\n"); 
		query.append("                WHERE COP_NO = ${verifyCopNo.get($key)}" ).append("\n"); 
		query.append("                AND   COST_ACT_GRP_SEQ = ${verifyCostActGrpSeq.get($key)}" ).append("\n"); 
		query.append("				AND   NVL(TRSP_FRST_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                'X' " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("            WHERE COP_NO = ${verifyCopNo.get($key)}" ).append("\n"); 
		query.append("            AND   COST_ACT_GRP_SEQ = ${verifyCostActGrpSeq.get($key)}" ).append("\n"); 
		query.append("			AND   NVL(TRSP_FRST_FLG,'N') = 'N' 	" ).append("\n"); 
		query.append("            AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("OR NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    'X' " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    PRD_INLND_ROUT_MST A, " ).append("\n"); 
		query.append("                    PRD_INLND_ROUT_DTL B, " ).append("\n"); 
		query.append("                    PRD_INLND_EACH_LNK C " ).append("\n"); 
		query.append("                WHERE B.ROUT_ORG_NOD_CD = ${verifyRoutOrgNodCd.get($key)}" ).append("\n"); 
		query.append("                AND   B.ROUT_DEST_NOD_CD = ${verifyRoutDestNodCd.get($key)}" ).append("\n"); 
		query.append("                AND   B.ROUT_SEQ = ${verifyRoutSeq.get($key)}" ).append("\n"); 
		query.append("                AND   B.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("                AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("                AND   A.ROUT_SEQ = B.ROUT_SEQ " ).append("\n"); 
		query.append("                AND   NVL(A.DELT_FLG,'N') <> 'Y'  " ).append("\n"); 
		query.append("                AND   B.LNK_ORG_NOD_CD = C.LNK_ORG_NOD_CD " ).append("\n"); 
		query.append("                AND   B.LNK_DEST_NOD_CD = C.LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("                AND   B.TRSP_MOD_CD = C.TRSP_MOD_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("    'X' CHK_UNIT " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    DUAL " ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    'X' " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    TRS_TRSP_RAIL_BIL_ORD " ).append("\n"); 
		query.append("                WHERE COP_NO = ${verifyCopNo.get($key)}" ).append("\n"); 
		query.append("                AND   COST_ACT_GRP_SEQ = ${verifyCostActGrpSeq.get($key)}" ).append("\n"); 
		query.append("                AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                'X' " ).append("\n"); 
		query.append("            FROM " ).append("\n"); 
		query.append("                TRS_TRSP_SVC_ORD " ).append("\n"); 
		query.append("            WHERE COP_NO = ${verifyCopNo.get($key)}" ).append("\n"); 
		query.append("            AND   COST_ACT_GRP_SEQ = ${verifyCostActGrpSeq.get($key)}" ).append("\n"); 
		query.append("            AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append("          ) " ).append("\n"); 
		query.append("OR NOT EXISTS (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                    'X' " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                    PRD_INLND_ROUT_MST A, " ).append("\n"); 
		query.append("                    PRD_INLND_ROUT_DTL B, " ).append("\n"); 
		query.append("                    PRD_INLND_EACH_LNK C " ).append("\n"); 
		query.append("                WHERE B.ROUT_ORG_NOD_CD = ${verifyRoutOrgNodCd.get($key)}" ).append("\n"); 
		query.append("                AND   B.ROUT_DEST_NOD_CD = ${verifyRoutDestNodCd.get($key)}" ).append("\n"); 
		query.append("                AND   B.ROUT_SEQ = ${verifyRoutSeq.get($key)}" ).append("\n"); 
		query.append("                AND   B.TRSP_MOD_CD = 'RD' " ).append("\n"); 
		query.append("                AND   A.ROUT_ORG_NOD_CD = B.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("                AND   A.ROUT_DEST_NOD_CD = B.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("                AND   A.ROUT_SEQ = B.ROUT_SEQ " ).append("\n"); 
		query.append("                AND   NVL(A.DELT_FLG,'N') <> 'Y'  " ).append("\n"); 
		query.append("                AND   B.LNK_ORG_NOD_CD = C.LNK_ORG_NOD_CD " ).append("\n"); 
		query.append("                AND   B.LNK_DEST_NOD_CD = C.LNK_DEST_NOD_CD " ).append("\n"); 
		query.append("                AND   B.TRSP_MOD_CD = C.TRSP_MOD_CD" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}