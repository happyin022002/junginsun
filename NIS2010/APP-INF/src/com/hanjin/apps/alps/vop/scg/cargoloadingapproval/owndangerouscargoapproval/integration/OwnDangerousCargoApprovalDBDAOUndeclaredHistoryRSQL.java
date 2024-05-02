/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOUndeclaredHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOUndeclaredHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnDangerousCargoApprovalDBDAOUndeclaredHistory
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOUndeclaredHistoryRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOUndeclaredHistoryRSQL").append("\n"); 
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
		query.append("SELECT  A.BKG_NO" ).append("\n"); 
		query.append("      , A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("      , TO_CHAR(A.RQST_DT,'YYYY-MM-DD HH24:MI:SS') AS RQST_DT" ).append("\n"); 
		query.append("      , TO_CHAR(A.UDECL_DT,'YYYY-MM-DD HH24:MI:SS') AS UDECL_DT" ).append("\n"); 
		query.append("      , ( SELECT  CASE WHEN DECODE(X.CONTI_CD, 'F', 'E', X.CONTI_CD) = 'E' AND NVL(X.DELT_FLG, 'N') = 'N'  THEN 'HAMUR'" ).append("\n"); 
		query.append("                       WHEN X.CONTI_CD  = 'M' AND NVL(X.DELT_FLG, 'N') = 'N'  THEN 'NYCNA'" ).append("\n"); 
		query.append("                       WHEN X.CONTI_CD  = 'A' AND X.CNT_CD NOT IN ('KR','JP') AND NVL(X.DELT_FLG, 'N') = 'N'  AND X.SCONTI_CD = 'AF' THEN 'SHAAS'" ).append("\n"); 
		query.append("                       WHEN X.CONTI_CD  = 'A' AND X.CNT_CD NOT IN ('KR','JP') AND NVL(X.DELT_FLG, 'N') = 'N' THEN 'SINWA'" ).append("\n"); 
		query.append("                       WHEN X.CNT_CD    = 'KR' THEN 'SELIB'" ).append("\n"); 
		query.append("                       WHEN X.CNT_CD    = 'JP' THEN 'TYOIB'                 " ).append("\n"); 
		query.append("                   END " ).append("\n"); 
		query.append("           FROM MDM_LOCATION           X" ).append("\n"); 
		query.append("          WHERE X.LOC_CD               = E.POL_CD ) AS RHQ" ).append("\n"); 
		query.append("      , A.RQST_OFC_CD" ).append("\n"); 
		query.append("      , A.SLAN_CD" ).append("\n"); 
		query.append("      , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("      , A.VSL_CD" ).append("\n"); 
		query.append("      , A.SKD_VOY_NO" ).append("\n"); 
		query.append("      , A.SKD_DIR_CD" ).append("\n"); 
		query.append("      , E.POL_CD" ).append("\n"); 
		query.append("      , TO_CHAR(E.POL_ETD_DT,'YYYY/MM/DD') AS POL_ETA_DT" ).append("\n"); 
		query.append("      , ( SELECT MIN(DECODE(Y.NON_DCGO_CATE_GRP_CD,'A','I','B','II','C','III','D','IV')) FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("           WHERE X.NON_DCGO_RQST_SEQ = A.NON_DCGO_RQST_SEQ " ).append("\n"); 
		query.append("             AND X.BKG_NO            = A.BKG_NO" ).append("\n"); 
		query.append("             AND X.NON_DCGO_KW_SEQ   = Y.NON_DCGO_KW_SEQ ) AS KEYWORD_TYPE" ).append("\n"); 
		query.append("      , ( SELECT WM_CONCAT(Y.NON_DCGO_KW_NM) FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("           WHERE X.NON_DCGO_RQST_SEQ = A.NON_DCGO_RQST_SEQ " ).append("\n"); 
		query.append("             AND X.BKG_NO            = A.BKG_NO" ).append("\n"); 
		query.append("             AND X.NON_DCGO_KW_SEQ   = Y.NON_DCGO_KW_SEQ ) AS KEYWORD" ).append("\n"); 
		query.append("      , A.CSTMS_DESC" ).append("\n"); 
		query.append("      , A.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      , A.CMDT_DESC AS CST_CMDT_DESC" ).append("\n"); 
		query.append("      , A.CMDT_DESC" ).append("\n"); 
		query.append("      , A.XTER_RMK" ).append("\n"); 
		query.append("      , A.INTER_RMK" ).append("\n"); 
		query.append("      , ( SELECT CUST_NM FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("           WHERE BKG_NO = E.BKG_NO AND BKG_CUST_TP_CD = 'S' ) AS SHIPPER" ).append("\n"); 
		query.append("      , A.ON_BRD_FLG        " ).append("\n"); 
		query.append("      , A.CMDT_CTNT" ).append("\n"); 
		query.append("      , A.RSLT_RMK1" ).append("\n"); 
		query.append("      , A.RSLT_RMK2" ).append("\n"); 
		query.append("      , A.FILE_SAV_ID" ).append("\n"); 
		query.append("      , A.FILE_NM" ).append("\n"); 
		query.append("FROM    SCG_NON_DG_CGO_UDECL_HIS A" ).append("\n"); 
		query.append("      , BKG_BOOKING E" ).append("\n"); 
		query.append("WHERE A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '')    " ).append("\n"); 
		query.append("	AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TO_CHAR(A.RQST_DT, 'YYYY-MM-DD') BETWEEN @[rqst_dt_fr] AND @[rqst_dt_to]" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != 'ALL') " ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("               @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD FROM SCG_RGN_SHP_OPR_PORT" ).append("\n"); 
		query.append("                WHERE   E.POL_CD 					= LOC_CD " ).append("\n"); 
		query.append("                AND     DELT_FLG 					= 'N'" ).append("\n"); 
		query.append("                AND		RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("              @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                WHERE   (" ).append("\n"); 
		query.append("                SELECT OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                WHERE OFC_N8TH_LVL_CD = (SELECT  EQ_CTRL_OFC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                WHERE   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                AND     LOC_CD  =   E.POL_CD))" ).append("\n"); 
		query.append("                IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                WHERE   (" ).append("\n"); 
		query.append("						SELECT	DECODE(SYS_AREA_GRP_ID, 'SWA', 'SINRS', 'EUR', 'HAMRU', 'USA', 'NYCRA', 'KOR', 'SHARC', 'CHN', 'SHARC')" ).append("\n"); 
		query.append("                        FROM	COM_SYS_AREA_GRP_ID A, MDM_LOCATION B" ).append("\n"); 
		query.append("                        WHERE	A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                            AND A.CNT_CD = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                            AND EQ_CTRL_OFC_CD IS NULL" ).append("\n"); 
		query.append("                        AND   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL(CALL_PORT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                        AND     B.LOC_CD  =   E.POL_CD)" ).append("\n"); 
		query.append("                IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.RQST_DT" ).append("\n"); 

	}
}