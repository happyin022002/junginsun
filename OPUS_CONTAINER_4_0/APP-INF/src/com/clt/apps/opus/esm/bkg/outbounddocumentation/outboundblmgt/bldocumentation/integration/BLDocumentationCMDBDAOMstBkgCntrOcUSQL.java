/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOMstBkgCntrOcUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOMstBkgCntrOcUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MVMT STS CD가 'OC'일떄 BKG COntainer Update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOMstBkgCntrOcUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnmv_id_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstrm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOMstBkgCntrOcUSQL").append("\n"); 
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
		query.append("#if ((${mvmt_sts_cd} == 'OC' || ${mvmt_sts_cd} == 'VL' )&& ${fnd_bkg} == '1')" ).append("\n"); 
		query.append("MERGE INTO BKG_CONTAINER A USING (" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO, CTM.CNTR_NO, CTM.CNTR_TPSZ_CD, CTM.CNMV_YR, CTM.CNMV_ID_NO," ).append("\n"); 
		query.append("       CTM.CNMV_CYC_NO, CTM.MVMT_STS_CD, CTM.BKG_RCV_TERM_CD, CTM.ORG_YD_CD," ).append("\n"); 
		query.append("       CTM.DEST_YD_CD, 'Y', CTM.CNMV_RMK, CTM.CNTR_HNGR_RCK_FLG," ).append("\n"); 
		query.append("       DECODE (CTM.SUBST_RULE_CD, NULL, 'N', 'Y') RL,  CTM.CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CTM.SUBST_RULE_CD, BKG.DE_TERM_CD, CTM.CRE_USR_ID, CTM.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("       BKG_BOOKING BKG," ).append("\n"); 
		query.append("       (SELECT DISTINCT /*+ ORDERED INDEX_DESC(A XAK1BKG_CONTAINER) INDEX(BO XPKBKG_BOOKING) */ BO.BKG_NO" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BO, BKG_BOOKING BO2" ).append("\n"); 
		query.append("         WHERE BO.BKG_NO  IN  (SELECT BKG_NO FROM BKG_CONTAINER WHERE CNTR_NO = @[cntr_no] AND CRE_DT > SYSDATE - 60)" ).append("\n"); 
		query.append("           AND NVL (BO.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("           AND BO.VSL_CD = BO2.VSL_CD" ).append("\n"); 
		query.append("           AND BO.SKD_VOY_NO	= BO2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND BO.SKD_DIR_CD	= BO2.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND BO2.BKG_NO	    = @[bkg_no]" ).append("\n"); 
		query.append("           AND BO.POL_CD	    = BO2.POL_CD" ).append("\n"); 
		query.append("           AND BO.POD_CD        = BO2.POD_CD" ).append("\n"); 
		query.append("           ) BB" ).append("\n"); 
		query.append(" WHERE CTM.CNTR_NO    = @[cntr_no]" ).append("\n"); 
		query.append("   AND CTM.CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO     = BB.BKG_NO" ).append("\n"); 
		query.append("   AND CTM.CNMV_YR    = @[cnmv_yr]" ).append("\n"); 
		query.append("                    ) B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.CNTR_NO = B.CNTR_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET  " ).append("\n"); 
		query.append("       A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CNMV_YR      = B.CNMV_YR" ).append("\n"); 
		query.append("      ,A.CNMV_ID_NO   = B.CNMV_ID_NO" ).append("\n"); 
		query.append("      ,A.CNMV_CYC_NO  = B.CNMV_CYC_NO" ).append("\n"); 
		query.append("      ,A.CNMV_STS_CD  = B.MVMT_STS_CD" ).append("\n"); 
		query.append("      ,A.ORG_YD_CD    = B.ORG_YD_CD" ).append("\n"); 
		query.append("      ,A.DEST_YD_CD   = B.DEST_YD_CD" ).append("\n"); 
		query.append("      ,A.CNMV_FLG     = 'Y'" ).append("\n"); 
		query.append("      ,A.DIFF_RMK     = NVL(B.CNMV_RMK, A.DIFF_RMK)" ).append("\n"); 
		query.append("      ,A.EQ_SUBST_FLG = B.RL" ).append("\n"); 
		query.append("      ,A.CNMV_EVNT_DT = B.CNMV_EVNT_DT" ).append("\n"); 
		query.append("      ,A.EQ_SUBST_TPSZ_CD = B.SUBST_RULE_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD       = B.DE_TERM_CD" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID       = B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("      ,A.CGO_RCV_DT = CASE WHEN A.CGO_RCV_DT IS NULL AND (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(B.BKG_NO,B.CNTR_NO,'N'),'YYYYMMDDHH24MI') FROM DUAL) IS NOT NULL THEN " ).append("\n"); 
		query.append("                                (SELECT TO_DATE(BKG_GET_CNTR_CORR_DT_FNC(B.BKG_NO,B.CNTR_NO,'N'),'YYYYMMDDHH24MI') FROM DUAL)" ).append("\n"); 
		query.append("                           WHEN A.CGO_RCV_DT IS NULL THEN B.CNMV_EVNT_DT" ).append("\n"); 
		query.append("                      ELSE A.CGO_RCV_DT" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("      ,A.CGO_RCV_YD_CD = DECODE(A.CGO_RCV_YD_CD, NULL, B.ORG_YD_CD, A.CGO_RCV_YD_CD)" ).append("\n"); 
		query.append("#elseif ((${mvmt_sts_cd} == 'OP' && ${fnd_bkg} != '1') || (${mvmt_sts_cd} == 'OC' && ${fnd_bkg} != '1'))" ).append("\n"); 
		query.append("      INSERT INTO BKG_CONTAINER (BKG_NO, CNTR_NO, CNTR_TPSZ_CD, CNMV_YR,          CNMV_ID_NO, CNMV_CYC_NO, CNMV_STS_CD, " ).append("\n"); 
		query.append("                                 RCV_TERM_CD,     ORG_YD_CD,    DEST_YD_CD,       CNMV_FLG,   DIFF_RMK," ).append("\n"); 
		query.append("                                 EQ_SUBST_FLG,    CNMV_EVNT_DT, EQ_SUBST_TPSZ_CD, DE_TERM_CD, " ).append("\n"); 
		query.append("                                 CRE_DT, UPD_DT,  CRE_USR_ID,   UPD_USR_ID,   " ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} == 'OC')    " ).append("\n"); 
		query.append("                                 CGO_RCV_DT, CGO_RCV_YD_CD, " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                 CNTR_VOL_QTY, SOC_FLG, RD_CGO_FLG," ).append("\n"); 
		query.append("                                 WGT_UT_CD, MEAS_UT_CD) (" ).append("\n"); 
		query.append("                    SELECT BKG.BKG_NO, CTM.CNTR_NO, CTM.CNTR_TPSZ_CD, CTM.CNMV_YR, CTM.CNMV_ID_NO, CTM.CNMV_CYC_NO, CTM.MVMT_STS_CD," ).append("\n"); 
		query.append("                           CTM.BKG_RCV_TERM_CD, CTM.ORG_YD_CD, CTM.DEST_YD_CD, 'Y', CTM.CNMV_RMK, " ).append("\n"); 
		query.append("                           DECODE(CTM.SUBST_RULE_CD, NULL, 'N', 'Y') RL, CTM.CNMV_EVNT_DT, CTM.SUBST_RULE_CD,  BKG.DE_TERM_CD, " ).append("\n"); 
		query.append("                           CTM.CRE_DT, CTM.UPD_DT, CTM.CRE_USR_ID, CTM.UPD_USR_ID," ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} == 'OC')  " ).append("\n"); 
		query.append("                           CTM.CNMV_EVNT_DT, CTM.ORG_YD_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                           1, DECODE(@[lstrm_cd], 'SH', 'Y', 'N'), DECODE(SUBSTR(CTM.CNTR_TPSZ_CD, 1, 1), 'R', 'Y', 'N')," ).append("\n"); 
		query.append("                           DOC.WGT_UT_CD, 'CBM'" ).append("\n"); 
		query.append("                      FROM CTM_MOVEMENT CTM, BKG_BOOKING BKG, BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                     WHERE CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                       AND CTM.CNMV_ID_NO = @[cnmv_id_no]" ).append("\n"); 
		query.append("                       AND BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND CTM.CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("                       AND BKG.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("#elseif (${mvmt_sts_cd} == 'MT' || ${mvmt_sts_cd} == 'EN' || ${mvmt_sts_cd} == 'TN' || (${mvmt_sts_cd} == 'OP' && ${fnd_bkg} == '1'))" ).append("\n"); 
		query.append("MERGE INTO BKG_CONTAINER A USING (" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO, CTM.CNTR_NO, CTM.CNTR_TPSZ_CD, CTM.CNMV_YR, CTM.CNMV_ID_NO," ).append("\n"); 
		query.append("       CTM.CNMV_CYC_NO, CTM.MVMT_STS_CD, CTM.BKG_RCV_TERM_CD, CTM.ORG_YD_CD," ).append("\n"); 
		query.append("       CTM.DEST_YD_CD, 'Y', CTM.CNMV_RMK," ).append("\n"); 
		query.append("       DECODE (CTM.SUBST_RULE_CD, NULL, 'N', 'Y') RL, CTM.CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CTM.SUBST_RULE_CD, BKG.DE_TERM_CD, CTM.CRE_USR_ID, CTM.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("       BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE CTM.CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("   AND CTM.CNMV_YR     = @[cnmv_yr]" ).append("\n"); 
		query.append("   AND BKG.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("   AND CTM.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   and CTM.CNMV_ID_NO  = @[cnmv_id_no]" ).append("\n"); 
		query.append(" ) B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.CNTR_NO = B.CNTR_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET  " ).append("\n"); 
		query.append("      A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A.CNMV_YR      = B.CNMV_YR" ).append("\n"); 
		query.append("      ,A.CNMV_ID_NO   = B.CNMV_ID_NO" ).append("\n"); 
		query.append("      ,A.CNMV_CYC_NO  = B.CNMV_CYC_NO" ).append("\n"); 
		query.append("      ,A.CNMV_STS_CD  = B.MVMT_STS_CD" ).append("\n"); 
		query.append("      ,A.ORG_YD_CD    = B.ORG_YD_CD" ).append("\n"); 
		query.append("      ,A.DEST_YD_CD   = B.DEST_YD_CD" ).append("\n"); 
		query.append("      ,A.CNMV_FLG     = 'Y'" ).append("\n"); 
		query.append("      ,A.DIFF_RMK     = NVL(B.CNMV_RMK, A.DIFF_RMK)" ).append("\n"); 
		query.append("      ,A.EQ_SUBST_FLG = B.RL" ).append("\n"); 
		query.append("      ,A.CNMV_EVNT_DT = B.CNMV_EVNT_DT" ).append("\n"); 
		query.append("      ,A.EQ_SUBST_TPSZ_CD = B.SUBST_RULE_CD" ).append("\n"); 
		query.append("      ,A.DE_TERM_CD       = B.DE_TERM_CD" ).append("\n"); 
		query.append("      ,A.UPD_USR_ID       = B.UPD_USR_ID" ).append("\n"); 
		query.append("      ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${mvmt_sts_cd} == 'MT' || (${mvmt_sts_cd} == 'OP' && ${fnd_bkg} == '1'))" ).append("\n"); 
		query.append("      ,A.CGO_RCV_DT = NULL" ).append("\n"); 
		query.append("      ,A.CGO_RCV_YD_CD = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("MERGE INTO BKG_CONTAINER A USING (" ).append("\n"); 
		query.append("SELECT BKG.BKG_NO, CTM.CNTR_NO, CTM.CNTR_TPSZ_CD, CTM.CNMV_YR, CTM.CNMV_ID_NO," ).append("\n"); 
		query.append("       CTM.CNMV_CYC_NO, CTM.MVMT_STS_CD, CTM.BKG_RCV_TERM_CD, CTM.ORG_YD_CD," ).append("\n"); 
		query.append("       CTM.DEST_YD_CD, 'Y', CTM.CNMV_RMK," ).append("\n"); 
		query.append("       DECODE (CTM.SUBST_RULE_CD, NULL, 'N', 'Y') RL, CTM.CNMV_EVNT_DT," ).append("\n"); 
		query.append("       CTM.SUBST_RULE_CD, BKG.DE_TERM_CD, CTM.CRE_USR_ID, CTM.UPD_USR_ID" ).append("\n"); 
		query.append("  FROM CTM_MOVEMENT CTM," ).append("\n"); 
		query.append("       BKG_CONTAINER BKG" ).append("\n"); 
		query.append(" WHERE CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND CTM.CNMV_YR = @[cnmv_yr]" ).append("\n"); 
		query.append("   AND CTM.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("   AND CTM.CNMV_ID_NO  = @[cnmv_id_no]" ).append("\n"); 
		query.append("   AND CTM.CNTR_NO     = BKG.CNTR_NO" ).append("\n"); 
		query.append("   AND BKG.CNMV_CYC_NO >= CTM.CNMV_CYC_NO" ).append("\n"); 
		query.append("                    ) B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.CNTR_NO = B.CNTR_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE SET  " ).append("\n"); 
		query.append("      A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD, " ).append("\n"); 
		query.append("      A.CNMV_YR      = B.CNMV_YR, " ).append("\n"); 
		query.append("      A.CNMV_ID_NO   = B.CNMV_ID_NO, " ).append("\n"); 
		query.append("      A.CNMV_CYC_NO  = B.CNMV_CYC_NO, " ).append("\n"); 
		query.append("      A.CNMV_STS_CD  = B.MVMT_STS_CD, " ).append("\n"); 
		query.append("      A.ORG_YD_CD    = B.ORG_YD_CD, " ).append("\n"); 
		query.append("      A.DEST_YD_CD   = B.DEST_YD_CD, " ).append("\n"); 
		query.append("      A.CNMV_FLG     = 'Y', " ).append("\n"); 
		query.append("      A.DIFF_RMK     = NVL(B.CNMV_RMK, A.DIFF_RMK)," ).append("\n"); 
		query.append("      A.EQ_SUBST_FLG = B.RL," ).append("\n"); 
		query.append("      A.CNMV_EVNT_DT = B.CNMV_EVNT_DT, " ).append("\n"); 
		query.append("      A.EQ_SUBST_TPSZ_CD = B.SUBST_RULE_CD, " ).append("\n"); 
		query.append("      A.DE_TERM_CD       = B.DE_TERM_CD," ).append("\n"); 
		query.append("      A.UPD_USR_ID       = B.UPD_USR_ID," ).append("\n"); 
		query.append("      A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}