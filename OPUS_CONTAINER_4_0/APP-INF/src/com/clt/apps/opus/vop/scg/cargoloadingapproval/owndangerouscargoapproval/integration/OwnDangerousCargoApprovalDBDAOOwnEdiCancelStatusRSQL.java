/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOOwnEdiCancelStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOOwnEdiCancelStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인 전에 EDI취소 대상이 있는지 확인 후 EDI취소 
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOOwnEdiCancelStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOOwnEdiCancelStatusRSQL").append("\n"); 
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
		query.append("WITH VVD_BUF AS (" ).append("\n"); 
		query.append("SELECT VVD.*" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD          G" ).append("\n"); 
		query.append("     , SCG_APRO_RQST        R" ).append("\n"); 
		query.append("     , SCG_VVD_APRO_RQST    VVD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR         D" ).append("\n"); 
		query.append("     , SCG_RGN_SHP_OPR_PORT E" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO                   = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = G.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO               = G.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD               = G.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = D.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD                   = E.LOC_CD" ).append("\n"); 
		query.append("   AND VVD.BKG_NO                   = R.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.SPCL_CGO_APRO_RQST_SEQ   = R.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("   AND R.SPCL_CGO_CATE_CD           = 'DG'" ).append("\n"); 
		query.append("   AND R.LST_RQST_DAT_FLG           = 'N'" ).append("\n"); 
		query.append("   AND VVD.MAPG_EDI_TRSM_STS_CD     = 'S'" ).append("\n"); 
		query.append("   AND VVD.SPCL_CGO_APRO_RQST_SEQ   IN (" ).append("\n"); 
		query.append("                                         SELECT MAX(SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ " ).append("\n"); 
		query.append("                                           FROM SCG_VVD_APRO_RQST" ).append("\n"); 
		query.append("                                          WHERE BKG_NO               = VVD.BKG_NO" ).append("\n"); 
		query.append("                                            AND MAPG_EDI_TRSM_STS_CD = VVD.MAPG_EDI_TRSM_STS_CD" ).append("\n"); 
		query.append("                                          GROUP BY BKG_NO, VSL_PRE_PST_CD, VSL_SEQ, SLAN_CD, VSL_CD, SKD_VOY_NO ,SKD_DIR_CD " ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("), CUR_BUF AS (" ).append("\n"); 
		query.append("   SELECT VVD.*" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD          G" ).append("\n"); 
		query.append("     , SCG_APRO_RQST        R" ).append("\n"); 
		query.append("     , SCG_VVD_APRO_RQST    VVD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR         D" ).append("\n"); 
		query.append("     , SCG_RGN_SHP_OPR_PORT E" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO                   = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = G.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO               = G.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD               = G.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = D.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD                   = E.LOC_CD" ).append("\n"); 
		query.append("   AND VVD.BKG_NO                   = R.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.SPCL_CGO_APRO_RQST_SEQ   = R.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("   AND R.LST_RQST_DAT_FLG           = 'Y'" ).append("\n"); 
		query.append("   AND R.SPCL_CGO_CATE_CD           = 'DG'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT CASE " ).append("\n"); 
		query.append("            WHEN (" ).append("\n"); 
		query.append("                 SELECT DECODE(COUNT(" ).append("\n"); 
		query.append("                       (SELECT LISTAGG(" ).append("\n"); 
		query.append("                               X.VSL_CD" ).append("\n"); 
		query.append("                            || X.SKD_VOY_NO" ).append("\n"); 
		query.append("                            || X.SKD_DIR_CD" ).append("\n"); 
		query.append("                            , ',') WITHIN GROUP (ORDER BY X.BKG_NO)" ).append("\n"); 
		query.append("                          FROM SCG_VVD_APRO_RQST X" ).append("\n"); 
		query.append("                             , BKG_DG_CGO F" ).append("\n"); 
		query.append("                         WHERE F.BKG_NO                 = CUR.BKG_NO" ).append("\n"); 
		query.append("                           AND X.BKG_NO                 = F.BKG_NO" ).append("\n"); 
		query.append("                           AND X.SPCL_CGO_APRO_RQST_SEQ = CUR.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                           --AND X.VSL_PRE_PST_CD         = SC2.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                           --AND X.VSL_SEQ                = SC2.VSL_SEQ" ).append("\n"); 
		query.append("                          MINUS" ).append("\n"); 
		query.append("                         SELECT LISTAGG(" ).append("\n"); 
		query.append("                               X.VSL_CD" ).append("\n"); 
		query.append("                            || X.SKD_VOY_NO" ).append("\n"); 
		query.append("                            || X.SKD_DIR_CD" ).append("\n"); 
		query.append("                            , ',') WITHIN GROUP (ORDER BY X.BKG_NO)" ).append("\n"); 
		query.append("                          FROM SCG_VVD_APRO_RQST X" ).append("\n"); 
		query.append("                             , BKG_DG_CGO F" ).append("\n"); 
		query.append("                         WHERE F.BKG_NO                 = VVD.BKG_NO" ).append("\n"); 
		query.append("                           AND X.BKG_NO                 = F.BKG_NO" ).append("\n"); 
		query.append("                           AND X.SPCL_CGO_APRO_RQST_SEQ = VVD.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                     ), 0 , 'X', 'U')" ).append("\n"); 
		query.append("                  FROM DUAL" ).append("\n"); 
		query.append("           ) = 'U' THEN 'NR'" ).append("\n"); 
		query.append("       END EDI_DEL_STS_CD" ).append("\n"); 
		query.append("     , NVL(G.ACT_CRR_CD,D.CRR_CD)  CRR_CD" ).append("\n"); 
		query.append("     , VVD.BKG_NO" ).append("\n"); 
		query.append("     , VVD.POL_CD" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT (" ).append("\n"); 
		query.append("                SELECT FLT_FILE_REF_NO" ).append("\n"); 
		query.append("                  FROM SCG_PRNR_SPCL_CGO_TRSM_HDR 	A" ).append("\n"); 
		query.append("                 WHERE 1 = 1" ).append("\n"); 
		query.append("				   AND A.TRSM_MZD_CD              	= 'EDI'							--::EDI, EML::--" ).append("\n"); 
		query.append("				   AND A.BKG_REF_NO        			= SC2.BKG_NO" ).append("\n"); 
		query.append("                   AND A.PRNR_SPCL_CGO_SEQ 			= SC2.MAPG_PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("               ) FLT_FILE_REF_NO" ).append("\n"); 
		query.append("           FROM SCG_APRO_RQST SC1" ).append("\n"); 
		query.append("              , SCG_VVD_APRO_RQST SC2" ).append("\n"); 
		query.append("          WHERE SC1.BKG_NO                 = VVD.BKG_NO" ).append("\n"); 
		query.append("            AND SC1.SPCL_CGO_APRO_RQST_SEQ = (SELECT MAX(SC1.SPCL_CGO_APRO_RQST_SEQ) SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                                       FROM SCG_APRO_RQST SC1" ).append("\n"); 
		query.append("                                                          , SCG_VVD_APRO_RQST SC2" ).append("\n"); 
		query.append("                                                      WHERE SC1.BKG_NO                 = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                        AND SC2.MAPG_EDI_TRSM_STS_CD   = 'S'" ).append("\n"); 
		query.append("                                                        AND SC1.BKG_NO                 = SC2.BKG_NO" ).append("\n"); 
		query.append("                                                        AND SC1.SPCL_CGO_APRO_RQST_SEQ = SC2.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                                        AND SC2.VSL_PRE_PST_CD         = VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                 AND SC2.VSL_PRE_PST_CD         = VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                 AND SC2.VSL_SEQ                = VVD.VSL_SEQ" ).append("\n"); 
		query.append("                 AND SC1.BKG_NO                 = SC2.BKG_NO" ).append("\n"); 
		query.append("                 AND SC1.SPCL_CGO_APRO_RQST_SEQ = SC2.SPCL_CGO_APRO_RQST_SEQ                 " ).append("\n"); 
		query.append("       ) FLT_FILE_REF_NO" ).append("\n"); 
		query.append("     , R.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("     , VVD.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("     , VVD.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("     , VVD.VSL_SEQ" ).append("\n"); 
		query.append("     , E.RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("     , 'R' EDI_MSG_STS_CD" ).append("\n"); 
		query.append("     , 'R' EDI_STATUS" ).append("\n"); 
		query.append("  FROM VSK_VSL_SKD          G" ).append("\n"); 
		query.append("     , SCG_APRO_RQST        R" ).append("\n"); 
		query.append("     , SCG_VVD_APRO_RQST    VVD" ).append("\n"); 
		query.append("     , MDM_VSL_CNTR         D" ).append("\n"); 
		query.append("     , SCG_RGN_SHP_OPR_PORT E" ).append("\n"); 
		query.append("     , VVD_BUF              BUF" ).append("\n"); 
		query.append("     , CUR_BUF              CUR" ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO                   = BUF.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.SPCL_CGO_APRO_RQST_SEQ   = BUF.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD           = BUF.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_SEQ                  = BUF.VSL_SEQ" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = G.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO               = G.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD               = G.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.VSL_CD                   = D.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD                   = E.LOC_CD" ).append("\n"); 
		query.append("   AND VVD.BKG_NO                   = R.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.SPCL_CGO_APRO_RQST_SEQ   = R.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 

	}
}