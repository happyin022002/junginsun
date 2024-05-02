/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
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

public class PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAddCNTRList에서 추가된 정보에 대해서 BKG에서 PSA정보를 조회한다.
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PSAManifestDBDAOsearchPSAImpStsInfoAddListRSQL").append("\n"); 
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
		query.append("SELECT /*+ ORDERED */ " ).append("\n"); 
		query.append("       C.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , C.CNTR_NO CNTR_NO" ).append("\n"); 
		query.append("     , BKG_JOIN_FNC( CURSOR(SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("                           FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                           WHERE C.BKG_NO = BKG_NO" ).append("\n"); 
		query.append("                           AND   C.CNTR_NO = CNTR_NO                                     " ).append("\n"); 
		query.append("                    )) SEAL_NO" ).append("\n"); 
		query.append("     , V.POL_CD POL_CD" ).append("\n"); 
		query.append("     , B.POD_CD POD_CD" ).append("\n"); 
		query.append("     --, TRUNC(DECODE(NVL(C.CNTR_WGT,0),0,DECODE(CC.CNTR_COUNT,0,0,D.ACT_WGT/CC.CNTR_COUNT), NVL(C.CNTR_WGT,0)+NVL(TS.CNTR_TPSZ_TARE_WGT,0)),0) CNTR_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     ,TRUNC((" ).append("\n"); 
		query.append("        CASE NVL(C.CNTR_WGT,0)" ).append("\n"); 
		query.append("            WHEN 0 THEN " ).append("\n"); 
		query.append("                DECODE(CC.CNTR_COUNT,0,0," ).append("\n"); 
		query.append("                                DECODE(NVL(D.WGT_UT_CD,' '),'LBS', ROUND(NVL(D.ACT_WGT, 0) * 0.4536, 3), NVL(D.ACT_WGT,0)) / CC.CNTR_COUNT)" ).append("\n"); 
		query.append("            ELSE DECODE(NVL(C.WGT_UT_CD,' '),'LBS',ROUND(NVL(C.CNTR_WGT,0)*0.4536,3)," ).append("\n"); 
		query.append("                                                NVL(C.CNTR_WGT,0)) + NVL(TS.CNTR_TPSZ_TARE_WGT,0)" ).append("\n"); 
		query.append("        END " ).append("\n"); 
		query.append("     )) AS CNTR_WGT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     , V.VSL_CD VSL_CD" ).append("\n"); 
		query.append("     , V.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("     , V.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("     , C.DCGO_FLG DCGO_FLG" ).append("\n"); 
		query.append("     , C.RC_FLG RC_FLG" ).append("\n"); 
		query.append("     , C.AWK_CGO_FLG AWK_CGO_FLG" ).append("\n"); 
		query.append("     , C.BB_CGO_FLG BB_CGO_FLG" ).append("\n"); 
		query.append("     , C.RD_CGO_FLG RD_CGO_FLG" ).append("\n"); 
		query.append("     , NV.OP_CD OOP" ).append("\n"); 
		query.append("     , DECODE(B.BKG_CGO_TP_CD,'F','F','P','M','R','M','B','M','F') FM_CD" ).append("\n"); 
		query.append("     , NV.VSL_CD NEXT_VSL_CD" ).append("\n"); 
		query.append("     , NV.SKD_VOY_NO NEXT_SKD_VOY_NO" ).append("\n"); 
		query.append("     , NV.SKD_DIR_CD NEXT_SKD_DIR_CD" ).append("\n"); 
		query.append("     , NV.POD_CD PORT_CD" ).append("\n"); 
		query.append("     , C.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , DECODE(C.RC_FLG, 'Y', '1', '0') SPC" ).append("\n"); 
		query.append("     , UPPER(TRIM(PV.PSA_VOY_DIR_CD)) PSA_VOY_DIR_CD" ).append("\n"); 
		query.append("     , UPPER(TRIM(PV.PSA_VSL_NM)) PSA_VSL_NM" ).append("\n"); 
		query.append("     , '+' SAV" ).append("\n"); 
		query.append("     , 'SM' COP" ).append("\n"); 
		query.append("     , 'SM' IOP" ).append("\n"); 
		query.append("     , 'T'  TS_TP_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD V, BKG_BOOKING B, BKG_CONTAINER C, BKG_BL_DOC D, BKG_VVD NV, MDM_CNTR_TP_SZ TS, BKG_CSTMS_PSA_VVD PV, VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("      ( SELECT  BC.BKG_NO, COUNT(BC.CNTR_NO) CNTR_COUNT" ).append("\n"); 
		query.append("        FROM    BKG_CONTAINER BC," ).append("\n"); 
		query.append("                BKG_VVD BV" ).append("\n"); 
		query.append("        WHERE   BV.BKG_NO           = BC.BKG_NO" ).append("\n"); 
		query.append("        AND     BV.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("        AND     BV.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     BV.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     BV.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("        GROUP BY BC.BKG_NO) CC" ).append("\n"); 
		query.append("WHERE  V.VSL_CD           = @[vsl_cd]" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO       = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD       = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    V.POD_CD           = @[pod_cd]" ).append("\n"); 
		query.append("#if(${cntr_no}!='')" ).append("\n"); 
		query.append("AND    C.CNTR_NO          = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    B.BKG_STS_CD NOT IN   ( 'X','S' )  " ).append("\n"); 
		query.append("AND    V.BKG_NO           = B.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = C.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = D.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = NV.BKG_NO" ).append("\n"); 
		query.append("AND    V.BKG_NO           = CC.BKG_NO" ).append("\n"); 
		query.append("AND    C.CNTR_TPSZ_CD     = TS.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("AND    NV.VSL_CD          = PV.VSL_CD(+)               " ).append("\n"); 
		query.append("AND    NV.SKD_VOY_NO      = PV.SKD_VOY_NO(+) " ).append("\n"); 
		query.append("AND    NV.SKD_DIR_CD      = PV.SKD_DIR_CD(+)       " ).append("\n"); 
		query.append("AND    NV.VSL_PRE_PST_CD||NV.VSL_SEQ  = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("                               FROM   BKG_VVD" ).append("\n"); 
		query.append("                               WHERE  BKG_NO       = V.BKG_NO" ).append("\n"); 
		query.append("                               AND    V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("AND    NV.VSL_CD     		= VPS.VSL_CD" ).append("\n"); 
		query.append("AND    NV.SKD_VOY_NO 		= VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    NV.SKD_DIR_CD 		= VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    NV.POD_CD     		= VPS.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    NV.POD_YD_CD 		= VPS.YD_CD" ).append("\n"); 
		query.append("AND    NV.POD_CLPT_IND_SEQ 	= VPS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#if(${cntr_no}!='')" ).append("\n"); 
		query.append("AND    ROWNUM = 1  " ).append("\n"); 
		query.append("#end                " ).append("\n"); 
		query.append("ORDER BY C.CNTR_NO" ).append("\n"); 

	}
}