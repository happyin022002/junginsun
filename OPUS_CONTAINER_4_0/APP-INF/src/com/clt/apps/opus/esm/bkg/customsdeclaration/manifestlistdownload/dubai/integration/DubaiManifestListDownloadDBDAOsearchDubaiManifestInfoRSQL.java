/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAOsearchDubaiManifestInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.22 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAOsearchDubaiManifestInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiBlInfoVO, DubaiCstmsBlVO
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAOsearchDubaiManifestInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAOsearchDubaiManifestInfoRSQL").append("\n"); 
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
		query.append("SELECT B.BL_NO" ).append("\n"); 
		query.append("      ,B.POD_CD" ).append("\n"); 
		query.append("      ,B.VSL_CD" ).append("\n"); 
		query.append("      ,B.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,B.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,B.DU_ROTN_NO" ).append("\n"); 
		query.append("      ,B.DU_LINE_ID" ).append("\n"); 
		query.append("      ,B.DU_VOY_AGN_ID" ).append("\n"); 
		query.append("      ,B.ORG_PORT_CD" ).append("\n"); 
		query.append("      ,B.POR_CD" ).append("\n"); 
		query.append("      ,B.POL_CD" ).append("\n"); 
		query.append("      ,B.DEL_CD" ).append("\n"); 
		query.append("      ,B.DU_MF_NO" ).append("\n"); 
		query.append("      ,B.DU_CGO_CD" ).append("\n"); 
		query.append("      ,B.DU_CNTR_SVC_TP_CD" ).append("\n"); 
		query.append("      ,B.DU_TRD_CD" ).append("\n"); 
		query.append("      ,B.DU_TS_MOD_CD" ).append("\n"); 
		query.append("      ,B.CNSL_CGO_FLG" ).append("\n"); 
		query.append("      ,B.ORG_CNT_CD" ).append("\n"); 
		query.append("      ,B.ORG_BL_NO" ).append("\n"); 
		query.append("      ,B.ORG_VSL_CD" ).append("\n"); 
		query.append("      ,B.ORG_SKD_VOY_NO" ).append("\n"); 
		query.append("      ,B.ORG_SKD_DIR_CD" ).append("\n"); 
		query.append("      ,B.VSL_NM" ).append("\n"); 
		query.append("      ,B.MK_NO_CTNT" ).append("\n"); 
		query.append("      ,B.DU_CMDT_CD" ).append("\n"); 
		query.append("      ,B.CMDT_DESC" ).append("\n"); 
		query.append("      ,B.PCK_QTY" ).append("\n"); 
		query.append("      ,B.DU_PCK_DESC" ).append("\n"); 
		query.append("      ,B.DU_PCK_TP_CD" ).append("\n"); 
		query.append("      ,B.CNTR_NO" ).append("\n"); 
		query.append("      ,B.CNTR_KNT" ).append("\n"); 
		query.append("      ,B.BKG_TEU_QTY" ).append("\n"); 
		query.append("      ,B.TARE_WGT" ).append("\n"); 
		query.append("      ,B.CGO_WGT" ).append("\n"); 
		query.append("      ,B.GRS_WGT" ).append("\n"); 
		query.append("      ,B.MEAS_QTY" ).append("\n"); 
		query.append("      ,B.DU_TTL_QTY" ).append("\n"); 
		query.append("      ,B.DU_FRT_WGT" ).append("\n"); 
		query.append("      ,B.PLT_QTY" ).append("\n"); 
		query.append("      ,S.BKG_CUST_TP_CD  AS S_BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,S.CUST_CNT_CD     AS S_CUST_CNT_CD" ).append("\n"); 
		query.append("      ,S.CUST_NM         AS S_CUST_NM" ).append("\n"); 
		query.append("      ,S.CUST_ADDR       AS S_CUST_ADDR" ).append("\n"); 
		query.append("      ,S.ORG_CUST_NM     AS S_ORG_CUST_NM" ).append("\n"); 
		query.append("      ,S.ORG_CUST_ADDR   AS S_ORG_CUST_ADDR" ).append("\n"); 
		query.append("      ,C.BKG_CUST_TP_CD  AS C_BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,C.DU_CUST_ID      AS C_DU_CUST_ID" ).append("\n"); 
		query.append("      ,C.CUST_NM         AS C_CUST_NM" ).append("\n"); 
		query.append("      ,C.CUST_ADDR       AS C_CUST_ADDR" ).append("\n"); 
		query.append("      ,C.ORG_CUST_NM     AS C_ORG_CUST_NM" ).append("\n"); 
		query.append("      ,C.ORG_CUST_ADDR   AS C_ORG_CUST_ADDR" ).append("\n"); 
		query.append("      ,N.BKG_CUST_TP_CD  AS N_BKG_CUST_TP_CD" ).append("\n"); 
		query.append("      ,N.CUST_NM         AS N_CUST_NM" ).append("\n"); 
		query.append("      ,N.CUST_ADDR       AS N_CUST_ADDR" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_DU_BL B" ).append("\n"); 
		query.append("      ,BKG_CSTMS_DU_CUST S" ).append("\n"); 
		query.append("      ,BKG_CSTMS_DU_CUST C" ).append("\n"); 
		query.append("      ,BKG_CSTMS_DU_CUST N" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("   AND B.BL_NO = S.BL_NO(+)" ).append("\n"); 
		query.append("   AND B.POD_CD = S.POD_CD(+)" ).append("\n"); 
		query.append("   AND S.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND B.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("   AND B.POD_CD = C.POD_CD(+)" ).append("\n"); 
		query.append("   AND C.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND B.BL_NO = N.BL_NO(+)" ).append("\n"); 
		query.append("   AND B.POD_CD = N.POD_CD(+)" ).append("\n"); 
		query.append("   AND N.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND B.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND B.POD_CD = @[pod_cd]" ).append("\n"); 

	}
}