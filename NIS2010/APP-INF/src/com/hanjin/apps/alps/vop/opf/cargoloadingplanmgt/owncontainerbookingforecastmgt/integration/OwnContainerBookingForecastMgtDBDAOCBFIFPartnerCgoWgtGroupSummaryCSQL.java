/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoWgtGroupSummaryCSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoWgtGroupSummaryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CBF의 타선사 WEIGHT GROUP SUMMARY를 입력하기 위함.
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoWgtGroupSummaryCSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFPartnerCgoWgtGroupSummaryCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_WGT_GRP_SMRY ( VSL_CD ," ).append("\n"); 
		query.append("                                             SKD_VOY_NO ," ).append("\n"); 
		query.append("                                             SKD_DIR_CD," ).append("\n"); 
		query.append("                                             YD_CD," ).append("\n"); 
		query.append("                                             POL_CLPT_IND_SEQ," ).append("\n"); 
		query.append("                                             CRR_CD," ).append("\n"); 
		query.append("                                             POD_CD," ).append("\n"); 
		query.append("                                             BLCK_STWG_CD," ).append("\n"); 
		query.append("                                             CNTR_SZ_CD," ).append("\n"); 
		query.append("                                             FULL_MTY_CD," ).append("\n"); 
		query.append("                                             CNTR_WGT_GRP_CD," ).append("\n"); 
		query.append("                                             CNTR_QTY," ).append("\n"); 
		query.append("                                             CNTR_GRS_WGT," ).append("\n"); 
		query.append("                                             WGT_UT_CD," ).append("\n"); 
		query.append("                                             CRE_USR_ID," ).append("\n"); 
		query.append("                                             CRE_DT," ).append("\n"); 
		query.append("                                             UPD_USR_ID," ).append("\n"); 
		query.append("                                             UPD_DT )" ).append("\n"); 
		query.append("SELECT @[vsl_cd],          @[skd_voy_no],    @[skd_dir_cd],              AA.YD_CD,          @[pol_clpt_ind_seq]," ).append("\n"); 
		query.append("       AA.CRR_CD,          AA.POD_CD,        SUBSTR(AA.POD_CD,3,3) ,     AA.CNTR_SZ_CD,     AA.FULL_MTY_CD, " ).append("\n"); 
		query.append("       AA.CNTR_WGT_GRP_CD, COUNT(1) AS QTY,  ROUND(SUM(WGT)/COUNT(1),2), 'KGS',             @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE,            @[upd_usr_id],    SYSDATE" ).append("\n"); 
		query.append(" FROM (   " ).append("\n"); 
		query.append("       SELECT X.*, Y.CNTR_WGT_GRP_CD, " ).append("\n"); 
		query.append("              CASE WHEN Z.CNTR_SZ_CD = '2' THEN Z.CNTR_SZ_CD" ).append("\n"); 
		query.append("                   WHEN Z.CNTR_SZ_CD = '4' THEN Z.CNTR_SZ_CD" ).append("\n"); 
		query.append("                   WHEN X.CNTR_TPSZ_CD IN ('R8','R9') OR Z.CNTR_SZ_CD = '5' THEN '5'" ).append("\n"); 
		query.append("                   WHEN X.CNTR_TPSZ_CD NOT IN('R8','R9') AND Z.CNTR_SZ_CD IN ('6','7','8','9','W','X') THEN '6'" ).append("\n"); 
		query.append("              END AS CNTR_SZ_CD" ).append("\n"); 
		query.append("       FROM (   SELECT DISTINCT D.POD_CD, D.CNTR_NO, D.CNTR_TPSZ_CD, D.CRR_CD, D.YD_CD, D.POL_CLPT_IND_SEQ, " ).append("\n"); 
		query.append("                        CASE WHEN VGM_WGT IS NOT NULL THEN " ).append("\n"); 
		query.append("                                  DECODE(D.VGM_WGT_UT_CD,'LBS',(D.VGM_WGT*0.453592), D.VGM_WGT)" ).append("\n"); 
		query.append("                             ELSE " ).append("\n"); 
		query.append("                                  DECODE(D.CNTR_WGT_UT_CD,'LBS',NVL(D.TTL_WGT,1)*0.453592,NVL(D.TTL_WGT,1))" ).append("\n"); 
		query.append("                        END AS WGT, DECODE(D.MTY_BKG_FLG,'Y','E','F') AS FULL_MTY_CD" ).append("\n"); 
		query.append("                FROM (   SELECT DISTINCT  MAX(A.EDI_RCV_DT) AS EDI_RCV_DT ,   MAX(A.EDI_SND_ID) AS EDI_SND_ID " ).append("\n"); 
		query.append("                           FROM OPF_PRNR_EDI_CGO_BKG_FCAST A" ).append("\n"); 
		query.append("                          WHERE A.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                            AND A.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                            AND A.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                            AND A.YD_CD||A.POL_CLPT_IND_SEQ = @[yd_cd]       " ).append("\n"); 
		query.append("                            AND A.UPLD_DT          IS NULL" ).append("\n"); 
		query.append("                            AND A.CRR_CD           <> 'SML'" ).append("\n"); 
		query.append("                            AND NOT EXISTS ( SELECT DISTINCT EDI_RCV_DT, EDI_SND_ID " ).append("\n"); 
		query.append("                                               FROM OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("                                              WHERE EDI_RCV_DT       = A.EDI_RCV_DT" ).append("\n"); 
		query.append("                                                AND EDI_SND_ID       = A.EDI_SND_ID" ).append("\n"); 
		query.append("                                                AND ( CRR_CD IS NULL OR POD_CD IS NULL OR CNTR_TPSZ_CD IS NULL ) )" ).append("\n"); 
		query.append("                         GROUP BY A.CRR_CD, A.YD_CD, A.POL_CLPT_IND_SEQ ) C, OPF_PRNR_EDI_CGO_BKG_FCAST D" ).append("\n"); 
		query.append("     WHERE C.EDI_RCV_DT = D.EDI_RCV_DT" ).append("\n"); 
		query.append("       AND C.EDI_SND_ID = D.EDI_SND_ID ) X, OPF_CGO_BKG_FCAST_WGT_GRP Y, MDM_CNTR_TP_SZ Z" ).append("\n"); 
		query.append(" WHERE Y.SLAN_CD     =  ( SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("                            FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("                           WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("                             AND SKD_DIR_CD = @[skd_dir_cd] )                " ).append("\n"); 
		query.append("   AND Y.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND Y.POL_CD        = SUBSTR(X.YD_CD,1,5)" ).append("\n"); 
		query.append("   AND Y.FULL_MTY_CD   = 'F'" ).append("\n"); 
		query.append("   AND Y.CNTR_SZ_CD    = DECODE( SUBSTR(X.CNTR_TPSZ_CD,2,1),2,2,4) " ).append("\n"); 
		query.append("   AND X.WGT/1000       > Y.FM_LMT_WGT " ).append("\n"); 
		query.append("   AND X.WGT/1000       <= NVL(Y.TO_LMT_WGT,9999999999)" ).append("\n"); 
		query.append("   AND X.CNTR_TPSZ_CD   = Z.CNTR_TPSZ_CD  ) AA" ).append("\n"); 
		query.append("  GROUP BY AA.POD_CD, AA.CNTR_SZ_CD, AA.CRR_CD, AA.YD_CD, AA.POL_CLPT_IND_SEQ, AA.FULL_MTY_CD, AA.CNTR_WGT_GRP_CD" ).append("\n"); 

	}
}