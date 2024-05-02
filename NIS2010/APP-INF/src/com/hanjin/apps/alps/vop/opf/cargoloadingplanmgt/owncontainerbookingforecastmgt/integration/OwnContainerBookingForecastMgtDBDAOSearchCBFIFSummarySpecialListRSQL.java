/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFSummarySpecialListRSQL").append("\n"); 
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
		query.append("SELECT  VSL_CD " ).append("\n"); 
		query.append("		, SKD_VOY_NO " ).append("\n"); 
		query.append("		, SKD_DIR_CD " ).append("\n"); 
		query.append("		, YD_CD " ).append("\n"); 
		query.append("		, POL_CLPT_IND_SEQ " ).append("\n"); 
		query.append("		, CRR_CD " ).append("\n"); 
		query.append("		, POD_CD" ).append("\n"); 
		query.append("		, BLCK_STWG_CD " ).append("\n"); 
		query.append("		, CBF_SPCL_SMRY_SEQ " ).append("\n"); 
		query.append("        , SUBSTR(POD_CD,1,2)||BLCK_STWG_CD AS POD_NM" ).append("\n"); 
		query.append("        , SUBSTR(POD_CD,1,2)||BLCK_STWG_CD AS POD_NM2" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , CNTR_QTY" ).append("\n"); 
		query.append("        , CBF_RMK" ).append("\n"); 
		query.append("        , STWG_CD" ).append("\n"); 
		query.append("		#if (${condition_gb} == 'searchDG') " ).append("\n"); 
		query.append("        	, IMDG_UN_NO" ).append("\n"); 
		query.append("        	, IMDG_CLSS_CD" ).append("\n"); 
		query.append("        	, MRN_POLUT_FLG" ).append("\n"); 
		query.append("			, IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("        	, CASE  WHEN RC_FLG = 'Y' THEN 'REEFER'" ).append("\n"); 
		query.append("            	    WHEN AWK_CGO_FLG = 'Y' THEN 'AWK'" ).append("\n"); 
		query.append("					WHEN MTY_BKG_FLG = 'Y' THEN 'MTY'" ).append("\n"); 
		query.append("                	ELSE NULL" ).append("\n"); 
		query.append("          	END CARGO_TYPE" ).append("\n"); 
		query.append("            , DECODE(( SELECT COUNT(1) CNT" ).append("\n"); 
		query.append("                         FROM OPF_CGO_BKG_FCAST_DG_DTL" ).append("\n"); 
		query.append("                        WHERE VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("                          AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND YD_CD      = A.YD_CD" ).append("\n"); 
		query.append("                          AND POL_CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                          AND CRR_CD     = A.CRR_CD" ).append("\n"); 
		query.append("                          AND POD_CD     = A.POD_CD" ).append("\n"); 
		query.append("                          AND BLCK_STWG_CD = A.BLCK_STWG_CD" ).append("\n"); 
		query.append("                          AND CBF_SMRY_SEQ = A.CBF_SPCL_SMRY_SEQ ),0, 'N','Y') CO_LOAD" ).append("\n"); 
		query.append("            , FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${condition_gb} == 'searchAWK') " ).append("\n"); 
		query.append("        	, FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("        	, RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("			, CRN_PST_STS_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${condition_gb} == 'searchBB') " ).append("\n"); 
		query.append("			, VOID_20FT_QTY" ).append("\n"); 
		query.append("			, USD_BKG_TTL_QTY" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${condition_gb} == 'searchBN') " ).append("\n"); 
		query.append("			, USD_BKG_TTL_QTY" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${condition_gb} == 'searchRF') " ).append("\n"); 
		query.append("			, '' AS CARGO_TYPE" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            , PRCT_FLG" ).append("\n"); 
		query.append("            , IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("            , BKG_REV_MCGO_FLG " ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_SPCL_SMRY A" ).append("\n"); 
		query.append("WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("AND CRR_CD     = NVL(@[crr_cd],'SML')" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchDG') " ).append("\n"); 
		query.append("	AND NVL(DCGO_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND NVL(DCGO_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchAWK') " ).append("\n"); 
		query.append("	AND NVL(AWK_CGO_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchBB') " ).append("\n"); 
		query.append("	AND NVL(BB_CGO_FLG, 'N')= 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchSSTWG') " ).append("\n"); 
		query.append("	AND NVL(STWG_CGO_FLG, 'N') = 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchRF') " ).append("\n"); 
		query.append("	AND ( NVL(RC_FLG, 'N') = 'Y'  OR " ).append("\n"); 
		query.append("          (NVL(AWK_CGO_FLG, 'N') = 'N' AND NVL(BB_CGO_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND NVL(STWG_CGO_FLG, 'N') = 'N' AND NVL(BDL_CGO_FLG, 'N') = 'N' AND NVL(MTY_BKG_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("            AND CNTR_TPSZ_CD LIKE 'T%')) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchBN') " ).append("\n"); 
		query.append("	AND NVL(BDL_CGO_FLG, 'N') = 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${condition_gb} == 'searchMTY') " ).append("\n"); 
		query.append("	AND NVL(MTY_BKG_FLG, 'N') = 'Y' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}