/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ThailandManifestListDownloadDBDAOsearchCustomsBlInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.20
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.11.20 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ThailandManifestListDownloadDBDAOsearchCustomsBlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ThailandManifestListDownloadDBDAOsearchCustomsBlInfo
	  * </pre>
	  */
	public ThailandManifestListDownloadDBDAOsearchCustomsBlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.integration").append("\n");
		query.append("FileName : ThailandManifestListDownloadDBDAOsearchCustomsBlInfoRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("    B.BKG_NO, " ).append("\n");
		query.append("    C.CNTR_NO, " ).append("\n");
		query.append("    C.CNTR_TPSZ_CD," ).append("\n");
		query.append("	B.POR_CD," ).append("\n");
		query.append("	B.POL_CD," ).append("\n");
		query.append("	B.POD_CD," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(S.CUST_NM,CHR(10),'  ') AS CUST_NM     FROM BKG_CUSTOMER S WHERE S.BKG_NO=B.BKG_NO AND S.BKG_CUST_TP_CD='S' AND ROWNUM=1 ), ' ' ) AS SH_CUST_NM," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(S.CUST_ADDR,CHR(10),'  ') AS CUST_ADDR FROM BKG_CUSTOMER S WHERE S.BKG_NO=B.BKG_NO AND S.BKG_CUST_TP_CD='S' AND ROWNUM=1 ), ' ' ) AS SH_CUST_ADDR," ).append("\n");
		query.append("	NVL( (SELECT REPLACE(F.CUST_NM,CHR(10),'  ') AS CUST_NM     FROM BKG_CUSTOMER F WHERE F.BKG_NO=B.BKG_NO AND F.BKG_CUST_TP_CD='F' AND ROWNUM=1 ), ' ' ) AS FW_CUST_NM," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(C.CUST_NM,CHR(10),'  ') AS CUST_NM     FROM BKG_CUSTOMER C WHERE C.BKG_NO=B.BKG_NO AND C.BKG_CUST_TP_CD='C' AND ROWNUM=1 ), ' ' ) AS CN_CUST_NM," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(S.CUST_ADDR,CHR(10),'  ') AS CUST_ADDR FROM BKG_CUSTOMER S WHERE S.BKG_NO=B.BKG_NO AND S.BKG_CUST_TP_CD='C' AND ROWNUM=1 ), ' ' ) AS CN_CUST_ADDR," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(N.CUST_NM,CHR(10),'  ') AS CUST_NM     FROM BKG_CUSTOMER N WHERE N.BKG_NO=B.BKG_NO AND N.BKG_CUST_TP_CD='N' AND ROWNUM=1 ), ' ' ) AS NO_CUST_NM," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(S.CUST_ADDR,CHR(10),'  ') AS CUST_ADDR FROM BKG_CUSTOMER S WHERE S.BKG_NO=B.BKG_NO AND S.BKG_CUST_TP_CD='N' AND ROWNUM=1 ), ' ' ) AS NO_CUST_ADDR," ).append("\n");
		query.append("    NVL( (SELECT REPLACE(TO_CHAR(U.MK_DESC),CHR(10),'  ') AS MK_DESC     FROM BKG_BL_MK_DESC U WHERE U.BKG_NO=B.BKG_NO AND ROWNUM=1 ), ' ' ) AS MK_DESC, " ).append("\n");
		query.append("    NVL( D.PCK_QTY, 0.000 ) AS PCK_QTY, " ).append("\n");
		query.append("    NVL( D.PCK_TP_CD, ' ' ) AS PCK_TP_CD, " ).append("\n");
		query.append("    NVL( D.CNTR_MF_WGT, 0.000 ) AS CNTR_MF_WGT, " ).append("\n");
		query.append("    NVL( D.WGT_UT_CD, ' ' ) AS WGT_UT_CD, " ).append("\n");
		query.append("    NVL( D.MEAS_QTY, 0.000 ) AS MEAS_QTY, " ).append("\n");
		query.append("    NVL( D.MEAS_UT_CD, ' ' ) AS MEAS_UT_CD, " ).append("\n");
		query.append("    NVL( (SELECT REPLACE(TO_CHAR(U.CMDT_DESC),CHR(10),'  ') AS CMDT_DESC     FROM BKG_BL_MK_DESC U WHERE U.BKG_NO=B.BKG_NO AND ROWNUM=1 ), ' ' ) AS CMDT_DESC, " ).append("\n");
		query.append("    B.DEL_NOD_CD" ).append("\n");
		query.append("  FROM BKG_VVD A, BKG_BOOKING B, BKG_CONTAINER C, BKG_CNTR_MF_DESC D " ).append("\n");
		query.append(" WHERE 1=1 " ).append("\n");
		query.append("   AND A.BKG_NO = B.BKG_NO " ).append("\n");
		query.append("   AND B.BKG_STS_CD != 'X' " ).append("\n");
		query.append("   AND A.BKG_NO = C.BKG_NO " ).append("\n");
		query.append("   AND C.BKG_NO = D.BKG_NO(+)" ).append("\n");
		query.append("   AND C.CNTR_NO = D.CNTR_NO(+)" ).append("\n");
		query.append("   AND A.VSL_CD = SUBSTR(@[s_vvd],1,4)" ).append("\n");
		query.append("   AND A.SKD_VOY_NO = SUBSTR(@[s_vvd],5,4)" ).append("\n");
		query.append("   AND A.SKD_DIR_CD = SUBSTR(@[s_vvd],9,1)" ).append("\n");
		query.append("   AND B.VSL_CD = SUBSTR(@[trnk_vvd],1,4)" ).append("\n");
		query.append("   AND B.SKD_VOY_NO = SUBSTR(@[trnk_vvd],5,4)" ).append("\n");
		query.append("   AND B.SKD_DIR_CD = SUBSTR(@[trnk_vvd],9,1)" ).append("\n");
		query.append("   AND B.POL_CD = @[pol_cd]" ).append("\n");
		query.append("   AND B.POD_CD = @[pod_cd]" ).append("\n");
		query.append("   AND B.DEL_CD = @[s_del_cd]" ).append("\n");
		query.append("   AND B.DEL_NOD_CD like NVL(@[s_del_cd]||@[s_del_nod_cd]||'%','%')" ).append("\n");
		query.append("ORDER BY A.BKG_NO, C.CNTR_NO, D.CNTR_MF_SEQ" ).append("\n");

	}
}