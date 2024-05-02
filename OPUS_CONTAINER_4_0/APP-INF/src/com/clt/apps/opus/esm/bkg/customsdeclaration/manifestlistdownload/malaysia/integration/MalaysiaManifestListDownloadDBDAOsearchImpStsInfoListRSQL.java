/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MalaysiaManifestListDownloadDBDAOsearchImpStsInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MalaysiaManifestListDownloadDBDAOsearchImpStsInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public MalaysiaManifestListDownloadDBDAOsearchImpStsInfoListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.integration").append("\n"); 
		query.append("FileName : MalaysiaManifestListDownloadDBDAOsearchImpStsInfoListRSQL").append("\n"); 
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
		query.append("SELECT 1 AS SEL," ).append("\n"); 
		query.append("       NVL2(DEL_CNTR.CNTR_NO, '-', '') AS SAV," ).append("\n"); 
		query.append("       PI.VSL_CD," ).append("\n"); 
		query.append("       PI.SKD_VOY_NO," ).append("\n"); 
		query.append("       PI.SKD_DIR_CD," ).append("\n"); 
		query.append("       PI.CNTR_NO," ).append("\n"); 
		query.append("       PI.POL_CD," ).append("\n"); 
		query.append("       PI.POD_CD," ).append("\n"); 
		query.append("       PI.CNTR_WGT," ).append("\n"); 
		query.append("       PI.VGM_WGT," ).append("\n"); 
		query.append("       PI.TS_TP_CD," ).append("\n"); 
		query.append("       PI.DCGO_FLG," ).append("\n"); 
		query.append("       PI.RC_FLG," ).append("\n"); 
		query.append("       PI.AWK_CGO_FLG," ).append("\n"); 
		query.append("       PI.BB_CGO_FLG," ).append("\n"); 
		query.append("       PI.RD_CGO_FLG," ).append("\n"); 
		query.append("       PI.FULL_MTY_CD AS FM_CD," ).append("\n"); 
		query.append("       PI.LODG_VSL_CD AS NEXT_VSL_CD," ).append("\n"); 
		query.append("       PI.LODG_SKD_VOY_NO AS NEXT_SKD_VOY_NO," ).append("\n"); 
		query.append("       PI.LODG_VSL_DIR_CD AS NEXT_SKD_DIR_CD," ).append("\n"); 
		query.append("       PI.N1ST_POD_CD," ).append("\n"); 
		query.append("       PI.N2ND_POD_CD," ).append("\n"); 
		query.append("       PI.N3RD_POD_CD," ).append("\n"); 
		query.append("       PI.CNTR_OPR_CD AS COP," ).append("\n"); 
		query.append("       PI.IB_SLT_OPR_CD AS IOP," ).append("\n"); 
		query.append("       PI.OB_SLT_OPR_CD AS OOP," ).append("\n"); 
		query.append("       PI.PSA_BAT_NO AS BATCH_NO," ).append("\n"); 
		query.append("       TO_CHAR(PI.SND_DT, 'YYYY-MM-DD') AS SND_DT," ).append("\n"); 
		query.append("       PI.CNTR_SEAL_NO AS SEAL_NO," ).append("\n"); 
		query.append("       PI.BKG_NO," ).append("\n"); 
		query.append("       PI.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN PI.DCGO_FLG = 'Y' OR PI.RC_FLG = 'Y' OR PI.AWK_CGO_FLG = 'Y' OR PI.BB_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("             THEN '1'" ).append("\n"); 
		query.append("          ELSE '0'" ).append("\n"); 
		query.append("       END AS SPC," ).append("\n"); 
		query.append("       'U' AS UDT_FLAG," ).append("\n"); 
		query.append("       UPPER(TRIM(PV.PSA_VOY_DIR_CD)) AS PSA_VOY_DIR_CD," ).append("\n"); 
		query.append("       UPPER(TRIM(PV.PSA_VSL_NM)) AS PSA_VSL_NM," ).append("\n"); 
		query.append("       ' ' AS USER_ID," ).append("\n"); 
		query.append("       ' ' AS TYPE_CD," ).append("\n"); 
		query.append("       ' ' AS RECEIVER_ID," ).append("\n"); 
		query.append("       PI.PSA_STWG_TP_ID AS LD_INS," ).append("\n"); 
		query.append("       PI.PSA_CRE_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_MY_IMP_STS PI," ).append("\n"); 
		query.append("       BKG_CSTMS_MY_IMP_STS_SPCL PS," ).append("\n"); 
		query.append("       BKG_CSTMS_MY_VVD PV," ).append("\n"); 
		query.append("       (SELECT CNTR_NO" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT CNTR_NO" ).append("\n"); 
		query.append("                  FROM BKG_CSTMS_MY_IMP_STS" ).append("\n"); 
		query.append("                 WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                 MINUS" ).append("\n"); 
		query.append("                SELECT DISTINCT C.CNTR_NO" ).append("\n"); 
		query.append("                  FROM BKG_VVD V," ).append("\n"); 
		query.append("                       BKG_BOOKING B," ).append("\n"); 
		query.append("                       BKG_CONTAINER C," ).append("\n"); 
		query.append("                       BKG_VVD NV" ).append("\n"); 
		query.append("                 WHERE V.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                   AND V.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                   AND V.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                   AND V.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("                   AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                   AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("                   AND V.BKG_NO = NV.BKG_NO" ).append("\n"); 
		query.append("                   AND NV.VSL_PRE_PST_CD||NV.VSL_SEQ = (SELECT NVL(MIN(VSL_PRE_PST_CD||VSL_SEQ), V.VSL_PRE_PST_CD||V.VSL_SEQ)" ).append("\n"); 
		query.append("                                                          FROM BKG_VVD" ).append("\n"); 
		query.append("                                                         WHERE BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                                           AND V.VSL_PRE_PST_CD||V.VSL_SEQ < VSL_PRE_PST_CD||VSL_SEQ))) DEL_CNTR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE PI.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND PI.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND PI.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND PI.VSL_CD = PS.VSL_CD(+)" ).append("\n"); 
		query.append("   AND PI.SKD_VOY_NO = PS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND PI.SKD_DIR_CD = PS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND PI.CNTR_NO = PS.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND PI.CNTR_NO = DEL_CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("#if(${type_cd} != '')" ).append("\n"); 
		query.append("   AND TS_TP_CD LIKE SUBSTR(@[type_cd], 1, 1) ||'%'" ).append("\n"); 
		query.append("   AND FULL_MTY_CD LIKE SUBSTR(@[type_cd], 2, 1) ||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND PI.LODG_VSL_CD = PV.VSL_CD(+)" ).append("\n"); 
		query.append("   AND PI.LODG_SKD_VOY_NO = PV.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND PI.LODG_VSL_DIR_CD = PV.SKD_DIR_CD(+)" ).append("\n"); 

	}
}