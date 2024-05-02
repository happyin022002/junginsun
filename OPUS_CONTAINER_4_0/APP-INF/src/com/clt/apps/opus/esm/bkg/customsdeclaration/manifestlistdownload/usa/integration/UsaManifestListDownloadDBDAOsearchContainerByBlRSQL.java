/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchContainerByBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchContainerByBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchContainerByBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchContainerByBlRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT 'US' CNT_CD," ).append("\n"); 
		query.append("       H.CNTR_MF_NO AS BL_NO," ).append("\n"); 
		query.append("       C.CNTR_NO," ).append("\n"); 
		query.append("       C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       C.PCK_QTY," ).append("\n"); 
		query.append("       C.CNTR_WGT AS GRS_WGT," ).append("\n"); 
		query.append("       C.WGT_UT_CD," ).append("\n"); 
		query.append("       DECODE(NVL(B.BKG_CGO_TP_CD,'F'),'F','F','M') AS FULL_MTY_CD," ).append("\n"); 
		query.append("       @[usr_id] AS CRE_USR_ID," ).append("\n"); 
		query.append("       @[usr_id] AS UPD_USR_ID," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       DECODE(RSLT.A_IND, '0', (SELECT TO_CHAR(CNT.ARR_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), '') AS ARR_DT," ).append("\n"); 
		query.append("       DECODE(RSLT.A_IND, '0', (SELECT TO_CHAR(CNT.CGO_ARR_ACPT_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), '') AS CGO_ARR_ACPT_DT," ).append("\n"); 
		query.append("       DECODE(RSLT.A_IND, '0', (SELECT CNT.ARR_FLG" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), 'N') AS ARR_FLG," ).append("\n"); 
		query.append("       DECODE(RSLT.X_IND, '0', (SELECT TO_CHAR(CNT.XPT_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), '') AS XPT_DT," ).append("\n"); 
		query.append("       DECODE(RSLT.X_IND, '0', (SELECT TO_CHAR(CNT.XPT_ACPT_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), '') AS XPT_ACPT_DT," ).append("\n"); 
		query.append("       DECODE(RSLT.X_IND, '0', (SELECT CNT.XPT_FLG" ).append("\n"); 
		query.append("                                  FROM BKG_CSTMS_ADV_CNTR CNT" ).append("\n"); 
		query.append("                                 WHERE CNT.BL_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("                                   AND CNT.CNT_CD = 'US'" ).append("\n"); 
		query.append("                                   AND CNT.CNTR_NO = C.CNTR_NO), 'N') AS XPT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  BKG_BOOKING B," ).append("\n"); 
		query.append("        BKG_CONTAINER C," ).append("\n"); 
		query.append("        BKG_HBL H," ).append("\n"); 
		query.append("        BKG_CNTR_MF_DESC D," ).append("\n"); 
		query.append("        (SELECT NVL(MAX(CASE WHEN DSPO_CD IN ('63', '64', '65') THEN '1' ELSE '0' END), '0') AS A_IND," ).append("\n"); 
		query.append("                NVL(MAX(CASE WHEN DSPO_CD IN ('66', '67', '68') THEN '1' ELSE '0' END), '0') AS X_IND" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_RSLT A," ).append("\n"); 
		query.append("               BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("           AND A.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("           AND (#foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("                   #if($velocitycount > 1)" ).append("\n"); 
		query.append("                      OR #end B.BKG_NO IN ( $field_id )" ).append("\n"); 
		query.append("                #end)" ).append("\n"); 
		query.append("           ) RSLT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  1=1" ).append("\n"); 
		query.append("   AND  H.BKG_NO > ' '" ).append("\n"); 
		query.append("   AND ( #foreach($field_id in ${field_list})" ).append("\n"); 
		query.append("         #if($velocityCount > 1)" ).append("\n"); 
		query.append("         OR #end      H.CNTR_MF_NO IN ( $field_id )" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("   AND  B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND  B.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("   AND  C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND  C.CNTR_NO = D.CNTR_NO" ).append("\n"); 
		query.append("   AND  D.CNTR_MF_NO = H.CNTR_MF_NO" ).append("\n"); 
		query.append("   AND  B.BKG_STS_CD NOT IN ('X')" ).append("\n"); 

	}
}