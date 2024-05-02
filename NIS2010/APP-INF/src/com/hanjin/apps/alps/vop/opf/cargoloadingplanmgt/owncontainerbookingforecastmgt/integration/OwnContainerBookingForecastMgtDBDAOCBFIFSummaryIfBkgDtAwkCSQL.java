/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwkCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwk
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwkCSQL(){
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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummaryIfBkgDtAwkCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SPCL_SMRY ( VSL_CD" ).append("\n"); 
		query.append("                                        , SKD_VOY_NO" ).append("\n"); 
		query.append("                                        , SKD_DIR_CD" ).append("\n"); 
		query.append("                                        , YD_CD" ).append("\n"); 
		query.append("                                        , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        , CRR_CD" ).append("\n"); 
		query.append("                                        , POD_CD" ).append("\n"); 
		query.append("                                        , BLCK_STWG_CD" ).append("\n"); 
		query.append("                                        , CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append("                                        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                        , AWK_CGO_FLG" ).append("\n"); 
		query.append("                                        , FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("                                        , STWG_CD" ).append("\n"); 
		query.append("                                        , CRN_PST_STS_CD" ).append("\n"); 
		query.append("                                        , CNTR_QTY" ).append("\n"); 
		query.append("                                        , CRE_USR_ID" ).append("\n"); 
		query.append("                                        , CRE_DT" ).append("\n"); 
		query.append("                                        , UPD_USR_ID" ).append("\n"); 
		query.append("                                        , UPD_DT" ).append("\n"); 
		query.append("                                        , PRCT_FLG" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("  SELECT  @[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[pol_cd]" ).append("\n"); 
		query.append("        , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        , 'SML'" ).append("\n"); 
		query.append("        , POD_CD" ).append("\n"); 
		query.append("        , SUBSTR(MLB,3,5)" ).append("\n"); 
		query.append("        , CBF_SPCL_SMRY_SEQ + ROWNUM" ).append("\n"); 
		query.append("        , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("        , OVR_FWD" ).append("\n"); 
		query.append("        , OVR_AFT" ).append("\n"); 
		query.append("        , OVR_LFT" ).append("\n"); 
		query.append("        , OVR_RGT" ).append("\n"); 
		query.append("        , OVR_HGT" ).append("\n"); 
		query.append("        , STWG_CD" ).append("\n"); 
		query.append("        , CRN_PST_STS_CD" ).append("\n"); 
		query.append("        , CNTR_QTY" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , PRCT_FLG" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("    SELECT Y.POD_CD,Y.MLB,Y.CNTR_TPSZ_CD, Y.OVR_FWD, Y.OVR_AFT, Y.OVR_LFT,Y.OVR_RGT,Y.OVR_HGT, Y.STWG_CD, Y.CRN_PST_STS_CD, SUM(CNTR_VOL_QTY) CNTR_QTY," ).append("\n"); 
		query.append("      ( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)" ).append("\n"); 
		query.append("                    FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                    WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("                    AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                    AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                    AND YD_CD      = @[pol_cd]" ).append("\n"); 
		query.append("                    AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq] ) AS CBF_SPCL_SMRY_SEQ, Y.PRCT_FLG" ).append("\n"); 
		query.append("           FROM ( " ).append("\n"); 
		query.append("              SELECT DISTINCT X.BKG_NO, X.CNTR_NO, X.POD_CD, X.MLB, X.CNTR_TPSZ_CD, X.OVR_FWD, X.OVR_AFT, X.OVR_LFT,X.OVR_RGT,X.OVR_HGT, X.STWG_CD, " ).append("\n"); 
		query.append("                     X.CRN_PST_STS_CD, X.PRCT_FLG, CNTR_CHK, CNTR_VOL_QTY" ).append("\n"); 
		query.append("              FROM " ).append("\n"); 
		query.append("               ( SELECT NVL(BKG.BKG_NO,' ')       BKG_NO," ).append("\n"); 
		query.append("                        NVL(AWK.CNTR_NO,' ')       CNTR_NO," ).append("\n"); 
		query.append("                        NVL(VVD.POD_CD,' ')       POD_CD," ).append("\n"); 
		query.append("                       OPF_BLCK_STWG_CD(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, VVD.POL_YD_CD, VVD.POL_CLPT_IND_SEQ, BKG.BKG_NO) AS MLB," ).append("\n"); 
		query.append("                       NVL(QTY.CNTR_TPSZ_CD,' ') CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       AWK.OVR_FWRD_LEN      OVR_FWD," ).append("\n"); 
		query.append("                       AWK.OVR_BKWD_LEN      OVR_AFT," ).append("\n"); 
		query.append("                       AWK.OVR_LF_LEN        OVR_LFT," ).append("\n"); 
		query.append("                       AWK.OVR_RT_LEN        OVR_RGT," ).append("\n"); 
		query.append("                       AWK.OVR_HGT           OVR_HGT," ).append("\n"); 
		query.append("                       NVL(BKG.STWG_CD,' ')                                                       STWG_CD," ).append("\n"); 
		query.append("                       VVD.VSL_CD," ).append("\n"); 
		query.append("                       VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("                       VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("                       AWK.CRN_PST_STS_CD," ).append("\n"); 
		query.append("                       BKG.PRCT_FLG," ).append("\n"); 
		query.append("                       CASE WHEN AWK.CNTR_NO IS NULL THEN  ROWNUM " ).append("\n"); 
		query.append("                            ELSE 9999" ).append("\n"); 
		query.append("                       END AS CNTR_CHK, " ).append("\n"); 
		query.append("                       AWK.CNTR_VOL_QTY " ).append("\n"); 
		query.append("                FROM   BKG_VVD VVD, " ).append("\n"); 
		query.append("                       BKG_BOOKING BKG, " ).append("\n"); 
		query.append("                       BKG_QUANTITY QTY, " ).append("\n"); 
		query.append("                       BKG_AWK_CGO  AWK" ).append("\n"); 
		query.append("                 WHERE VVD.VSL_CD                          = @[vsl_cd]                                                                                                 " ).append("\n"); 
		query.append("                   AND VVD.SKD_VOY_NO                      = @[skd_voy_no]                                                                                            " ).append("\n"); 
		query.append("         	       AND VVD.SKD_DIR_CD                      = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND VVD.POL_YD_CD                       = @[pol_cd]" ).append("\n"); 
		query.append("                   AND VVD.POL_CLPT_IND_SEQ                = @[pol_clpt_ind_seq]                                                                              " ).append("\n"); 
		query.append("         	         AND VVD.BKG_NO                          = BKG.BKG_NO   " ).append("\n"); 
		query.append("					#if(${bkg_sts_cd} != 'All')" ).append("\n"); 
		query.append("					AND BKG.BKG_STS_CD = @[bkg_sts_cd]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD      <> 'X'" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO          = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("                   AND SUBSTR(QTY.CNTR_TPSZ_CD,1,1) <> 'Q'" ).append("\n"); 
		query.append("                   AND QTY.BKG_NO          = AWK.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.AWK_CGO_FLG     = 'Y'" ).append("\n"); 
		query.append("                   AND NVL(BKG.STWG_CD,'XX')  <> 'ODFT'" ).append("\n"); 
		query.append("                   AND QTY.CNTR_TPSZ_CD    = AWK.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                   AND SUBSTR(QTY.CNTR_TPSZ_CD,1,1) <> 'D'" ).append("\n"); 
		query.append("                   AND NOT EXISTS ( SELECT '*'" ).append("\n"); 
		query.append("                                      FROM BKG_DG_CGO" ).append("\n"); 
		query.append("                                     WHERE BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("                                       AND NVL(CNTR_NO,'') = NVL(AWK.CNTR_NO,'')" ).append("\n"); 
		query.append("                                       AND CNTR_TPSZ_CD    = QTY.CNTR_TPSZ_CD ) ) X" ).append("\n"); 
		query.append("         ) Y" ).append("\n"); 
		query.append("         GROUP BY Y.POD_CD,Y.MLB, Y.CNTR_TPSZ_CD, Y.OVR_FWD, Y.OVR_AFT, Y.OVR_LFT,Y.OVR_RGT,Y.OVR_HGT, Y.STWG_CD,Y.CRN_PST_STS_CD, Y.PRCT_FLG" ).append("\n"); 
		query.append("         ORDER BY Y.MLB )" ).append("\n"); 

	}
}