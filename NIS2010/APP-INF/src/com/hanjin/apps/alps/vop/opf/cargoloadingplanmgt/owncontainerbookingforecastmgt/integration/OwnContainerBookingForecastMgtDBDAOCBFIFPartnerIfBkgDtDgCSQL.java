/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.18 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Partner CLL의 DG 정보 입력
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerIfBkgDtDgCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SPCL_SMRY (" ).append("\n"); 
		query.append(" VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",CRR_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",BLCK_STWG_CD" ).append("\n"); 
		query.append(",CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",DCGO_FLG" ).append("\n"); 
		query.append(",IMDG_UN_NO" ).append("\n"); 
		query.append(",IMDG_CLSS_CD" ).append("\n"); 
		query.append(",MRN_POLUT_FLG" ).append("\n"); 
		query.append(",CNTR_QTY" ).append("\n"); 
		query.append(",AWK_CGO_FLG             " ).append("\n"); 
		query.append(",FWRD_OVR_DIM_LEN        " ).append("\n"); 
		query.append(",BKWD_OVR_DIM_LEN " ).append("\n"); 
		query.append(",HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append(",LF_SD_OVR_DIM_LEN      " ).append("\n"); 
		query.append(",RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH DG_CGO AS (" ).append("\n"); 
		query.append("    SELECT ROW_NUMBER() OVER(PARTITION BY CNTR_NO ORDER BY POD_CD,CNTR_NO, IMDG_UN_NO, IMDG_CLSS_CD, MRN_POLUT_FLG) NSEQ, " ).append("\n"); 
		query.append("           COUNT(1) OVER(PARTITION BY CNTR_NO ) CNT, " ).append("\n"); 
		query.append("           X.*" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("         SELECT DISTINCT Y.CNTR_NO, Y.CNTR_TPSZ_CD, Y.IMDG_UN_NO,       Y.IMDG_CLSS_CD, Y.MRN_POLUT_FLG, " ).append("\n"); 
		query.append("                              Y.POD_CD,  Y.YD_CD,        Y.POL_CLPT_IND_SEQ, Y.CRR_CD,       Y.AWK_CGO_FLG," ).append("\n"); 
		query.append("                              Y.FWRD_OVR_DIM_LEN,        Y.BKWD_OVR_DIM_LEN, Y.HGT_OVR_DIM_LEN," ).append("\n"); 
		query.append("                              Y.LF_SD_OVR_DIM_LEN,       Y.RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("          FROM (     SELECT  MAX(A.EDI_RCV_DT) AS EDI_RCV_DT ,   MAX(A.EDI_SND_ID) AS EDI_SND_ID " ).append("\n"); 
		query.append("                       FROM OPF_PRNR_EDI_CGO_BKG_FCAST A" ).append("\n"); 
		query.append("                      WHERE A.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                        AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                        AND A.YD_CD            = @[pol_cd]" ).append("\n"); 
		query.append("				        AND A.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("				        AND A.UPLD_DT IS NULL" ).append("\n"); 
		query.append("                        AND NOT EXISTS (    SELECT DISTINCT EDI_RCV_DT, EDI_SND_ID FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                                             WHERE EDI_RCV_DT       = A.EDI_RCV_DT" ).append("\n"); 
		query.append("                                               AND EDI_SND_ID       = A.EDI_SND_ID" ).append("\n"); 
		query.append("                                               AND ( CRR_CD IS NULL OR POD_CD IS NULL OR CNTR_TPSZ_CD IS NULL ) ) ) X, OPF_PRNR_EDI_CGO_BKG_FCAST Y" ).append("\n"); 
		query.append("             WHERE X.EDI_RCV_DT = Y.EDI_RCV_DT" ).append("\n"); 
		query.append("               AND X.EDI_SND_ID = Y.EDI_SND_ID" ).append("\n"); 
		query.append("               AND Y.DCGO_FLG   = 'Y'  ) X )" ).append("\n"); 
		query.append(" SELECT" ).append("\n"); 
		query.append(" @[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",Z.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",Z.CRR_CD" ).append("\n"); 
		query.append(",Z.POD_CD" ).append("\n"); 
		query.append(",SUBSTR(Z.POD_CD,3,3)" ).append("\n"); 
		query.append(", CBF_SPCL_SMRY_SEQ+ ROWNUM" ).append("\n"); 
		query.append(",Z.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'Y'" ).append("\n"); 
		query.append(",Z.IMDG_UN_NO" ).append("\n"); 
		query.append(",Z.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",Z.MRN_POLUT_FLG" ).append("\n"); 
		query.append(",Z.CNT" ).append("\n"); 
		query.append(",Z.AWK_CGO_FLG             " ).append("\n"); 
		query.append(",Z.FWRD_OVR_DIM_LEN        " ).append("\n"); 
		query.append(",Z.BKWD_OVR_DIM_LEN " ).append("\n"); 
		query.append(",Z.HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append(",Z.LF_SD_OVR_DIM_LEN      " ).append("\n"); 
		query.append(",Z.RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",Z.BKG_NO" ).append("\n"); 
		query.append("  FROM  (  " ).append("\n"); 
		query.append("  SELECT 'NO',                      A.CRR_CD,                  A.POD_CD,           A.YD_CD,         A.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("         A.AWK_CGO_FLG,             A.FWRD_OVR_DIM_LEN,        A.BKWD_OVR_DIM_LEN, A.HGT_OVR_DIM_LEN," ).append("\n"); 
		query.append("         A.LF_SD_OVR_DIM_LEN,       A.RT_SD_OVR_DIM_LEN," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG,  COUNT(1) AS CNT, NULL AS BKG_NO ," ).append("\n"); 
		query.append("		 ( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)" ).append("\n"); 
		query.append("                    FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                   WHERE VSL_CD     =  @[vsl_cd]" ).append("\n"); 
		query.append("                     AND SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("                     AND SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                     AND YD_CD      =  @[pol_cd]" ).append("\n"); 
		query.append("                     AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq] ) AS CBF_SPCL_SMRY_SEQ " ).append("\n"); 
		query.append("   FROM DG_CGO A " ).append("\n"); 
		query.append("  WHERE A.CNT = 1  -- NO_CO_LOAD" ).append("\n"); 
		query.append("  GROUP BY A.CRR_CD,       A.POD_CD,     A.YD_CD,        A.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("           A.AWK_CGO_FLG,   A.FWRD_OVR_DIM_LEN,        A.BKWD_OVR_DIM_LEN, A.HGT_OVR_DIM_LEN," ).append("\n"); 
		query.append("                              A.LF_SD_OVR_DIM_LEN,       A.RT_SD_OVR_DIM_LEN," ).append("\n"); 
		query.append("           A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG" ).append("\n"); 
		query.append(" UNION " ).append("\n"); 
		query.append(" SELECT 'CO', A.CRR_CD,  A.POD_CD,     A.YD_CD,        A.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("  A.AWK_CGO_FLG,   A.FWRD_OVR_DIM_LEN,        A.BKWD_OVR_DIM_LEN, A.HGT_OVR_DIM_LEN," ).append("\n"); 
		query.append("                              A.LF_SD_OVR_DIM_LEN,       A.RT_SD_OVR_DIM_LEN," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD, A.IMDG_UN_NO, A.IMDG_CLSS_CD, A.MRN_POLUT_FLG,  1 AS CNT " ).append("\n"); 
		query.append("        , ( SELECT MIN(EDI_BL_NO)" ).append("\n"); 
		query.append("              FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                    WHERE VSL_CD     =  @[vsl_cd]" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND YD_CD      =  @[pol_cd]" ).append("\n"); 
		query.append("                      AND CRR_CD     = A.CRR_CD" ).append("\n"); 
		query.append("                      AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq] " ).append("\n"); 
		query.append("                      AND CNTR_NO    =  A.CNTR_NO )" ).append("\n"); 
		query.append("         ,( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)" ).append("\n"); 
		query.append("                    FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                    WHERE VSL_CD     =  @[vsl_cd]" ).append("\n"); 
		query.append("                      AND SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("                      AND SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("                      AND YD_CD      =  @[pol_cd]" ).append("\n"); 
		query.append("                      AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq] ) AS CBF_SPCL_SMRY_SEQ " ).append("\n"); 
		query.append("   FROM DG_CGO A " ).append("\n"); 
		query.append("  WHERE A.CNT <> 1  -- CO_LOAD" ).append("\n"); 
		query.append("    AND A.NSEQ = 1 ) Z" ).append("\n"); 

	}
}