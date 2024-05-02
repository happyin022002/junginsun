/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchCmfDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchCmfDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCmfDetail
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchCmfDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_call_ind",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchCmfDetailRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO BL_NO," ).append("\n"); 
		query.append("       A.BL_SPLIT_NO," ).append("\n"); 
		query.append("       DECODE(DECODE(A.JP_BL_STS_CD, 'A', 'A', 'D', 'D', 'D'), 'A', 'Active', 'D', 'Delete', 'Delete') JP_BL_STS_CD," ).append("\n"); 
		query.append("       DECODE(A.DCGO_FLG, 'Y', 'Danger', '') DCGO_FLG," ).append("\n"); 
		query.append("       DECODE(A.LOCL_TS_IND_CD, 'T', 'T/S', 'Local') LOCL_TS_FLG," ).append("\n"); 
		query.append("       JP_EDI_TRSM_STG_TP_CD," ).append("\n"); 
		query.append("       A.FULL_MTY_CD," ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       A.POD_CD," ).append("\n"); 
		query.append("       TO_CHAR(S.VPS_ETA_DT, 'YYYY-MM-DD') ETA_DT," ).append("\n"); 
		query.append("       A.BKG_POR_CD," ).append("\n"); 
		query.append("       A.BKG_POL_CD," ).append("\n"); 
		query.append("       A.BKG_DEL_CD," ).append("\n"); 
		query.append("       A.PST_VSL_CD||A.PST_SKD_VOY_NO||A.PST_SKD_DIR_CD PST_VVD_CD," ).append("\n"); 
		query.append("       A.PST_RLY_POD_CD," ).append("\n"); 
		query.append("       A.PCK_QTY," ).append("\n"); 
		query.append("       A.PCK_TP_CD," ).append("\n"); 
		query.append("       A.GRS_WGT," ).append("\n"); 
		query.append("       A.WGT_UT_CD," ).append("\n"); 
		query.append("       A.MEAS_QTY," ).append("\n"); 
		query.append("       A.MEAS_UT_CD," ).append("\n"); 
		query.append("       C1.CUST_CNT_CD CUST_CNT_CD," ).append("\n"); 
		query.append("       C1.CUST_SEQ CUST_SEQ," ).append("\n"); 
		query.append("       C1.CUST_NM CUST_NM," ).append("\n"); 
		query.append("       C1.CUST_ADDR CUST_ADDR," ).append("\n"); 
		query.append("       C1.PHN_NO PHN_NO," ).append("\n"); 
		query.append("       C1.FAX_NO FAX_NO," ).append("\n"); 
		query.append("       C2.CUST_CNT_CD CUST_CNT_CD2," ).append("\n"); 
		query.append("       C2.CUST_SEQ CUST_SEQ2," ).append("\n"); 
		query.append("       C2.CUST_NM CUST_NM2," ).append("\n"); 
		query.append("       C2.CUST_ADDR CUST_ADDR2," ).append("\n"); 
		query.append("       C2.PHN_NO PHN_NO2," ).append("\n"); 
		query.append("       C2.FAX_NO FAX_NO2," ).append("\n"); 
		query.append("       C3.CUST_CNT_CD CUST_CNT_CD3," ).append("\n"); 
		query.append("       C3.CUST_SEQ CUST_SEQ3," ).append("\n"); 
		query.append("       C3.CUST_NM CUST_NM3," ).append("\n"); 
		query.append("       C3.CUST_ADDR CUST_ADDR3," ).append("\n"); 
		query.append("       C3.PHN_NO PHN_NO3," ).append("\n"); 
		query.append("       C3.FAX_NO FAX_NO3," ).append("\n"); 
		query.append("       ---------" ).append("\n"); 
		query.append("       A.APRO_NO," ).append("\n"); 
		query.append("       (SELECT WH.CSTMS_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_WH WH" ).append("\n"); 
		query.append("         WHERE A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("           AND WH.YD_CD = BKG.DEL_NOD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS DEL_BND," ).append("\n"); 
		query.append("       (SELECT WH.CSTMS_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("               BKG_VVD VVD," ).append("\n"); 
		query.append("               BKG_CSTMS_JP_WH WH" ).append("\n"); 
		query.append("         WHERE A.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND WH.YD_CD = VVD.POD_YD_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS POD_BND," ).append("\n"); 
		query.append("       A.DELT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_BL A," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL_CUST C1," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL_CUST C2," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL_CUST C3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BL_NO = @[in_bl_no]" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = NVL(@[in_bl_split_no], '  ')" ).append("\n"); 
		query.append("   AND A.BL_NO = C1.BL_NO(+)" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = C1.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND C1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND A.BL_NO = C2.BL_NO(+)" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = C2.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND C2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND A.BL_NO = C3.BL_NO(+)" ).append("\n"); 
		query.append("   AND A.BL_SPLIT_NO = C3.BL_SPLIT_NO(+)" ).append("\n"); 
		query.append("   AND C3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND A.VSL_CD = S.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND A.POD_CD = S.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND S.CLPT_IND_SEQ(+) = @[in_call_ind]" ).append("\n"); 

	}
}