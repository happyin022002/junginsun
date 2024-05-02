/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchEDAEtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchEDAEtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0233 화면 조회용.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchEDAEtaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchEDAEtaRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("a.vvd, a.pod, a.eta, TO_CHAR(a.eda_on_mi, 'YYYY-MM-DD') eda_on_mi, a.bl_count" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("a.VVD, a.POD, a.ETA," ).append("\n"); 
		query.append("TO_DATE(" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE WHEN MAX(V.EDA_UPD_DT) >= a.SND_DT THEN" ).append("\n"); 
		query.append("SUBSTR(MAX(TO_CHAR(V.EDA_UPD_DT, 'YYYYMMDDHH24MISS')||TO_CHAR(V.ETA_DT, 'YYYY-MM-DD')), 15)" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("CASE WHEN MAX(DECODE(V.OFC_CD || NVL(v.UPD_USR_ID, ' '), a.ofc_cd || NVL(a.usr_id, ' '), TO_CHAR(V.ETA_DT, 'YYYY-MM-DD'))) IS NOT NULL THEN" ).append("\n"); 
		query.append("MAX(DECODE(V.OFC_CD || NVL(v.CRE_USR_ID, ' '), a.ofc_cd || NVL(a.usr_id, ' '), TO_CHAR(V.ETA_DT, 'YYYY-MM-DD')))" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("MAX(TO_CHAR(V.ETA_DT, 'YYYY-MM-DD'))" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_VVD_ARR V" ).append("\n"); 
		query.append("WHERE vsl_cd        = SUBSTR(a.vvd, 1, 4)" ).append("\n"); 
		query.append("AND skd_voy_no = SUBSTR(a.vvd, 5, 4)" ).append("\n"); 
		query.append("AND skd_dir_cd    = SUBSTR(a.vvd, 9, 1)" ).append("\n"); 
		query.append("AND CNT_CD = 'US'" ).append("\n"); 
		query.append("AND pod_cd       = a.pod" ).append("\n"); 
		query.append("), 'YYYY-MM-DD'" ).append("\n"); 
		query.append(")   eda_on_mi," ).append("\n"); 
		query.append("a.BL_COUNT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD vvd, A.VPS_PORT_CD pod," ).append("\n"); 
		query.append("TO_CHAR(MIN(A.VPS_ETA_DT), 'YYYY-MM-DD HH24:MI') eta," ).append("\n"); 
		query.append("MAX(B.SND_DT) snd_dt," ).append("\n"); 
		query.append("SUBSTR(MAX(TO_CHAR(B.SND_DT, 'YYYYMMDDHH24MISS')||B.SND_USR_ID), 15) usr_id," ).append("\n"); 
		query.append("SUBSTR(MAX(TO_CHAR(B.SND_DT, 'YYYYMMDDHH24MISS')||B.SND_USR_OFC_CD), 15) ofc_cd," ).append("\n"); 
		query.append("COUNT(BL_NO) bl_count" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT MAX(CNT_CD) CNT_CD,  MAX(IO_BND_CD) IO_BND_CD, MAX(TRSM_MSG_TP_ID) TRSM_MSG_TP_ID," ).append("\n"); 
		query.append("MAX(SND_DT) SND_DT, MAX(SND_USR_OFC_CD) SND_USR_OFC_CD, MAX(SND_USR_ID) SND_USR_ID," ).append("\n"); 
		query.append("VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POD_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POD_CD" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", BKG_CSTMS_ADV_BL I" ).append("\n"); 
		query.append("#if (${edaoreta} == 'EDA')" ).append("\n"); 
		query.append(", BKG_CSTMS_ADV_VVD_ARR V" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE A.VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("#if (${edaoreta} == 'EDA')" ).append("\n"); 
		query.append("AND V.ETA_DT >= TO_DATE(REPLACE(REPLACE(@[from_dt], '-', ''), '/', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND V.ETA_DT <  TO_DATE(REPLACE(REPLACE(@[to_dt], '-', ''), '/', ''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.VPS_ETA_DT >= TO_DATE(REPLACE(REPLACE(@[from_dt], '-', ''), '/', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND A.VPS_ETA_DT <  TO_DATE(REPLACE(REPLACE(@[to_dt], '-', ''), '/', ''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND B.VSL_CD     = A.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.POD_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("AND B.TRSM_MSG_TP_ID = 'MI'" ).append("\n"); 
		query.append("AND B.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("AND B.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND B.CNT_CD = I.CNT_CD" ).append("\n"); 
		query.append("AND B.VSL_CD     = I.VSL_CD" ).append("\n"); 
		query.append("AND B.SKD_VOY_NO = I.SKD_VOY_NO" ).append("\n"); 
		query.append("AND B.SKD_DIR_CD = I.SKD_DIR_CD" ).append("\n"); 
		query.append("AND B.POD_CD     = I.CSTMS_POD_CD" ).append("\n"); 
		query.append("AND I.MF_STS_CD  = 'A'" ).append("\n"); 
		query.append("#if (${edaoreta} == 'EDA')" ).append("\n"); 
		query.append("AND A.VSL_CD = V.VSL_CD (+)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = V.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = V.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND V.CNT_CD (+) = 'US'" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD = V.POD_CD(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD, A.VPS_PORT_CD" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append(") a" ).append("\n"); 
		query.append("#if (${edaoreta} == 'EDA')" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("a.eda_on_mi >= TO_DATE(REPLACE(REPLACE(@[from_dt], '-', ''), '/', ''), 'YYYYMMDD')" ).append("\n"); 
		query.append("AND a.eda_on_mi <  TO_DATE(REPLACE(REPLACE(@[to_dt], '-', ''), '/', ''), 'YYYYMMDD') + 1" ).append("\n"); 
		query.append("ORDER BY a.eda_on_mi" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("ORDER BY a.eta" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}