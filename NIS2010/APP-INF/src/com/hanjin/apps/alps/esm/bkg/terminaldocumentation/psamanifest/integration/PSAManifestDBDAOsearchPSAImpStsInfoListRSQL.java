/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAImpStsInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAImpStsInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSA Import Status List조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAImpStsInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAImpStsInfoListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(DEL_CNTR.CNTR_NO,NULL,NULL,'-') SAV " ).append("\n"); 
		query.append("     , PI.VSL_CD VSL_CD" ).append("\n"); 
		query.append("     , PI.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("     , PI.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("     , PI.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("     , PI.POL_CD POL_CD" ).append("\n"); 
		query.append("     , PI.POD_CD POD_CD" ).append("\n"); 
		query.append("     , CASE WHEN CNTR.VGM_WGT > 0 THEN NVL(CNTR.VGM_WGT,0) ELSE NVL(PI.CNTR_WGT,0) END CNTR_WGT " ).append("\n"); 
		query.append("     /*, CASE WHEN CNTR.VGM_WGT > 0 OR PI.VGM_WGT > 0 THEN 'Y' ELSE 'N' END VGM_IND*/" ).append("\n"); 
		query.append("     , CASE WHEN CNTR.VGM_WGT > 0 OR PI.CNTR_WGT > 0 OR PI.VGM_WGT > 0 THEN 'Y' ELSE 'N' END VGM_IND" ).append("\n"); 
		query.append("     , PI.TS_TP_CD TS_TP_CD" ).append("\n"); 
		query.append("     , PI.DCGO_FLG DCGO_FLG" ).append("\n"); 
		query.append("     , PI.RC_FLG RC_FLG" ).append("\n"); 
		query.append("     , PI.AWK_CGO_FLG AWK_CGO_FLG" ).append("\n"); 
		query.append("     , PI.BB_CGO_FLG BB_CGO_FLG" ).append("\n"); 
		query.append("     , PI.RD_CGO_FLG RD_CGO_FLG" ).append("\n"); 
		query.append("     , PI.FULL_MTY_CD FM_CD" ).append("\n"); 
		query.append("     , PI.LODG_VSL_CD NEXT_VSL_CD" ).append("\n"); 
		query.append("     , PI.LODG_SKD_VOY_NO NEXT_SKD_VOY_NO" ).append("\n"); 
		query.append("     , PI.LODG_VSL_DIR_CD NEXT_SKD_DIR_CD" ).append("\n"); 
		query.append("     , PI.N1ST_POD_CD PORT_CD" ).append("\n"); 
		query.append("     , PI.CNTR_OPR_CD   COP" ).append("\n"); 
		query.append("     , PI.IB_SLT_OPR_CD IOP" ).append("\n"); 
		query.append("     , PI.OB_SLT_OPR_CD OOP" ).append("\n"); 
		query.append("     , PI.PSA_BAT_NO BATCH_NO" ).append("\n"); 
		query.append("     , TO_CHAR(PI.SND_DT,'YYYY-MM-DD') SND_DT" ).append("\n"); 
		query.append("     , PI.CNTR_SEAL_NO SEAL_NO" ).append("\n"); 
		query.append("     , PI.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , PI.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(PI.RC_FLG, 'Y', '1', '0') SPC" ).append("\n"); 
		query.append("     , 'U' UDT_FLAG" ).append("\n"); 
		query.append("     , UPPER(TRIM(PV.PSA_VOY_DIR_CD)) PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("     , UPPER(TRIM(PV.PSA_VSL_NM)) PSA_VSL_NM" ).append("\n"); 
		query.append("	 , ' ' USER_ID" ).append("\n"); 
		query.append("     , ' ' TYPE_CD" ).append("\n"); 
		query.append("     , ' ' RECEIVER_ID" ).append("\n"); 
		query.append("     , NVL(PI.VGM_WGT,CNTR.VGM_WGT) VGM_WGT " ).append("\n"); 
		query.append("     , NVL(PI.VGM_MZD_TP_CD,CNTR.VGM_MZD_TP_CD) VGM_MZD_TP_CD" ).append("\n"); 
		query.append("     , NVL(PI.VGM_VRFY_SIG_CTNT,CNTR.VGM_VRFY_SIG_CTNT) VGM_VRFY_SIG_CTNT" ).append("\n"); 
		query.append("     , PI.VGM_REF_NO" ).append("\n"); 
		query.append("     , TO_CHAR(NVL(PI.VGM_VRFY_DT,CNTR.VGM_VRFY_DT),'YYYY-MM-DD') VGM_VRFY_DT" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_PSA_IMP_STS PI" ).append("\n"); 
		query.append("     , BKG_CSTMS_PSA_IMP_STS_SPCL PS" ).append("\n"); 
		query.append("     , BKG_CSTMS_PSA_VVD PV" ).append("\n"); 
		query.append("     , (SELECT CNTR_NO" ).append("\n"); 
		query.append("          FROM" ).append("\n"); 
		query.append("             ( SELECT DISTINCT CNTR_NO" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_PSA_IMP_STS" ).append("\n"); 
		query.append("                WHERE VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("               MINUS" ).append("\n"); 
		query.append("               SELECT DISTINCT C.CNTR_NO" ).append("\n"); 
		query.append("                 FROM BKG_VVD V, BKG_BOOKING B, BKG_CONTAINER C, BKG_VVD NV" ).append("\n"); 
		query.append("                WHERE V.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND V.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND V.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND V.POD_CD           = 'SGSIN'" ).append("\n"); 
		query.append("                  AND B.BKG_STS_CD NOT IN   ('X','S')" ).append("\n"); 
		query.append("                  AND V.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("                  AND V.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("                  AND V.BKG_NO           = NV.BKG_NO" ).append("\n"); 
		query.append("                  AND NV.VSL_PRE_PST_CD||NV.VSL_SEQ  = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("                                                          FROM BKG_VVD" ).append("\n"); 
		query.append("                                                         WHERE BKG_NO  = V.BKG_NO" ).append("\n"); 
		query.append("                                                           AND V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("                                                       )" ).append("\n"); 
		query.append("        )) DEL_CNTR" ).append("\n"); 
		query.append("        , BKG_CONTAINER CNTR" ).append("\n"); 
		query.append("  WHERE  PI.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("  AND    PI.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND    PI.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND    PI.VSL_CD        = PS.VSL_CD(+)" ).append("\n"); 
		query.append("  AND    PI.SKD_VOY_NO    = PS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND    PI.SKD_DIR_CD    = PS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND    PI.CNTR_NO       = PS.CNTR_NO(+)" ).append("\n"); 
		query.append("  AND    PI.CNTR_NO       = DEL_CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("#if(${type_cd}!='')" ).append("\n"); 
		query.append("  AND    TS_TP_CD    LIKE SUBSTR(@[type_cd],1,1) ||'%'" ).append("\n"); 
		query.append("  AND FULL_MTY_CD    LIKE SUBSTR(@[type_cd], 2, 1) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND PI.LODG_VSL_CD     = PV.VSL_CD(+)" ).append("\n"); 
		query.append("  AND PI.LODG_SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND PI.LODG_VSL_DIR_CD = PV.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND PI.BKG_NO          = CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("  AND PI.CNTR_NO         = CNTR.CNTR_NO(+)" ).append("\n"); 

	}
}