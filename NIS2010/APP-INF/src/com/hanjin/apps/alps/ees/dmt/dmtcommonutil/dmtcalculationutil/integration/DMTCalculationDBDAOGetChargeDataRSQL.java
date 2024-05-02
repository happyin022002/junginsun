/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DMTCalculationDBDAOGetChargeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetChargeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getChargeData
	  * </pre>
	  */
	public DMTCalculationDBDAOGetChargeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetChargeDataRSQL").append("\n"); 
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
		query.append("SELECT    C.DMDT_TRF_APLY_TP_CD                         AS Z_DC_APPL_RATE" ).append("\n"); 
		query.append(", C.BZC_TRF_CURR_CD                             AS Z_CUR_CD" ).append("\n"); 
		query.append(", C.OFC_CD                                      AS Z_OFC_CD" ).append("\n"); 
		query.append(", C.OFC_RHQ_CD                                  AS Z_OFC_RHQ" ).append("\n"); 
		query.append(", C.BZC_TRF_SEQ                                 AS Z_DTN_SEQ" ).append("\n"); 
		query.append(", NVL(C.BZC_DMDT_DE_TERM_CD, 'N')               AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append(", C.BZC_TRF_GRP_SEQ                             AS Z_DTG_GRP_ID" ).append("\n"); 
		query.append(", C.RFA_EXPT_APRO_NO                            AS Z_RFA_APPR_NO" ).append("\n"); 
		query.append(", C.RFA_EXPT_DAR_NO                             AS Z_RFA_DAR_NO" ).append("\n"); 
		query.append(", C.RFA_EXPT_MAPG_SEQ                           AS Z_RFA_MAPG_SEQ" ).append("\n"); 
		query.append(", C.RFA_EXPT_VER_SEQ                            AS Z_RFA_VER_SEQ" ).append("\n"); 
		query.append(", C.RFA_RQST_DTL_SEQ                            AS Z_RFA_DTL_SEQ" ).append("\n"); 
		query.append(", C.SC_NO                                       AS Z_SC_NO" ).append("\n"); 
		query.append(", C.SC_EXPT_VER_SEQ	                            AS Z_SC_VER_SEQ" ).append("\n"); 
		query.append(", C.SC_EXPT_GRP_SEQ                             AS Z_SC_GRP_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(C.SC_RFA_EXPT_APLY_DT,'YYYYMMDD')     AS Z_SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append(", SUBSTR (C.DMDT_TRF_CD, 3, 1)                  AS Z_DBC_IO_BND" ).append("\n"); 
		query.append(", B.CNTR_TPSZ_CD                                AS Z_CNTRTS_CD" ).append("\n"); 
		query.append(", B.VSL_CD                                      AS Z_VSL_CD" ).append("\n"); 
		query.append(", B.SKD_VOY_NO                                  AS Z_SKD_VOYAGE_NO" ).append("\n"); 
		query.append(", B.SKD_DIR_CD                                  AS Z_SKD_DIR_CD" ).append("\n"); 
		query.append(", B.POL_CD                                      AS Z_POL_LOC" ).append("\n"); 
		query.append(", B.POD_CD                                      AS Z_POD_LOC" ).append("\n"); 
		query.append(", B.POR_CD                                      AS Z_POR_LOC" ).append("\n"); 
		query.append(", B.DEL_CD                                      AS Z_DEL_LOC" ).append("\n"); 
		query.append(", K.PST_RLY_PORT_CD                             AS Z_POST_RLY" ).append("\n"); 
		query.append(", K.PRE_RLY_PORT_CD                             AS Z_PRE_RLY" ).append("\n"); 
		query.append(", F.CURR_CD                                     AS Z_RFA_CUR_CD" ).append("\n"); 
		query.append("," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  S.CURR_CD" ).append("\n"); 
		query.append("FROM    PRI_SP_HDR          P," ).append("\n"); 
		query.append("DMT_SC_EXPT_GRP     S" ).append("\n"); 
		query.append("WHERE   P.PROP_NO           = S.PROP_NO" ).append("\n"); 
		query.append("AND     C.SC_NO             = P.SC_NO" ).append("\n"); 
		query.append("AND     C.SC_EXPT_VER_SEQ   = S.SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND     C.SC_EXPT_GRP_SEQ   = S.SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(")                                               AS Z_SC_CUR_CD" ).append("\n"); 
		query.append(", TO_CHAR(C.BZC_TRF_APLY_DT,'YYYYMMDD')         AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(", B.BKG_NO                                      AS Z_BKG_NO" ).append("\n"); 
		query.append(", NVL (C.OFC_TRNS_RHQ_CNG_FLG, 'N')             AS Z_DCC_TRS_IND" ).append("\n"); 
		query.append(", C.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(", DECODE(SUBSTR(C.DMDT_TRF_CD,3,1),'I',V.POD_CLPT_IND_SEQ,V.POL_CLPT_IND_SEQ) AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM    DMT_CHG_CALC         C," ).append("\n"); 
		query.append("DMT_CHG_BKG_CNTR     B," ).append("\n"); 
		query.append("BKG_BOOKING          K," ).append("\n"); 
		query.append("DMT_RFA_EXPT_TRF_DTL F," ).append("\n"); 
		query.append("BKG_VVD              V" ).append("\n"); 
		query.append("WHERE   C.CNTR_NO                = @[cntr_no]" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO            = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD            = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD    = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     C.CHG_SEQ                = 1" ).append("\n"); 
		query.append("AND     C.SYS_AREA_GRP_ID        = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     C.CNTR_NO                = B.CNTR_NO" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO            = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND     B.BKG_NO                 = K.BKG_NO" ).append("\n"); 
		query.append("AND     C.RFA_EXPT_DAR_NO        = F.RFA_EXPT_DAR_NO        (+)" ).append("\n"); 
		query.append("AND     C.RFA_EXPT_MAPG_SEQ      = F.RFA_EXPT_MAPG_SEQ      (+)" ).append("\n"); 
		query.append("AND     C.RFA_EXPT_VER_SEQ       = F.RFA_EXPT_VER_SEQ       (+)" ).append("\n"); 
		query.append("AND     C.RFA_RQST_DTL_SEQ       = F.RFA_RQST_DTL_SEQ       (+)" ).append("\n"); 
		query.append("AND		V.BKG_NO				 = B.BKG_NO" ).append("\n"); 
		query.append("AND		DECODE(SUBSTR(C.DMDT_TRF_CD,3,1),'I',V.POD_CD,V.POL_CD)				 = DECODE(SUBSTR(C.DMDT_TRF_CD,3,1),'I',K.POD_CD,K.POL_CD)" ).append("\n"); 

	}
}