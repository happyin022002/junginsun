/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchBkgBookingRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       BL_NO," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN ACT_WGT > 999999.999 THEN ROUND(ACT_WGT * 0.001, 3)" ).append("\n"); 
		query.append("         ELSE ACT_WGT" ).append("\n"); 
		query.append("       END AS ACT_WGT," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("         WHEN ACT_WGT > 999999.999 THEN 'TNE'" ).append("\n"); 
		query.append("         ELSE KGS" ).append("\n"); 
		query.append("       END AS KGS," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       CBM," ).append("\n"); 
		query.append("       RCV_TERM_CD," ).append("\n"); 
		query.append("       DE_TERM_CD," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       BDR_FLG," ).append("\n"); 
		query.append("       BRD_DT," ).append("\n"); 
		query.append("       BDR_CNG_FLG," ).append("\n"); 
		query.append("       CMDT_CD," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       BKG_CGO_TP_CD2," ).append("\n"); 
		query.append("       UN_NO," ).append("\n"); 
		query.append("       CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("       (SELECT A.BKG_NO," ).append("\n"); 
		query.append("               A.BL_NO," ).append("\n"); 
		query.append("               A.POR_CD," ).append("\n"); 
		query.append("               A.POL_CD," ).append("\n"); 
		query.append("               A.DEL_CD," ).append("\n"); 
		query.append("               B.PCK_QTY," ).append("\n"); 
		query.append("               B.PCK_TP_CD," ).append("\n"); 
		query.append("               DECODE(B.WGT_UT_CD, 'LBS', B.ACT_WGT*0.4536, NVL(B.ACT_WGT, 0)) AS ACT_WGT," ).append("\n"); 
		query.append("               'KGS' AS KGS," ).append("\n"); 
		query.append("               DECODE(B.MEAS_UT_CD, 'CBF', B.MEAS_QTY*0.0283, NVL(B.MEAS_QTY, 0)) AS MEAS_QTY," ).append("\n"); 
		query.append("               'CBM' AS CBM," ).append("\n"); 
		query.append("               A.RCV_TERM_CD," ).append("\n"); 
		query.append("               A.DE_TERM_CD," ).append("\n"); 
		query.append("               A.DCGO_FLG," ).append("\n"); 
		query.append("               B.BDR_FLG," ).append("\n"); 
		query.append("               TO_CHAR(B.BDR_DT, 'YYYYMMDDHH24MISS') AS BRD_DT," ).append("\n"); 
		query.append("               B.BDR_CNG_FLG," ).append("\n"); 
		query.append("               A.CMDT_CD," ).append("\n"); 
		query.append("               DECODE(A.BKG_CGO_TP_CD, 'P', 'M', 'R', 'M', 'F') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("               A.POD_CD," ).append("\n"); 
		query.append("               DECODE(A.BKG_CGO_TP_CD, 'P', 'M', 'F') AS BKG_CGO_TP_CD2," ).append("\n"); 
		query.append("               (SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */" ).append("\n"); 
		query.append("                       IMDG_UN_NO" ).append("\n"); 
		query.append("                  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("                 WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND IMDG_UN_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS UN_NO," ).append("\n"); 
		query.append("               (SELECT /*+ INDEX_ASC(DG XPKBKG_DG_CGO) */" ).append("\n"); 
		query.append("                       IMDG_CLSS_CD" ).append("\n"); 
		query.append("                  FROM BKG_DG_CGO DG" ).append("\n"); 
		query.append("                 WHERE BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                   AND IMDG_UN_NO IS NOT NULL" ).append("\n"); 
		query.append("                   AND ROWNUM = 1) AS CLSS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          FROM BKG_BOOKING A," ).append("\n"); 
		query.append("               BKG_BL_DOC B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         WHERE A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("           AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1)" ).append("\n"); 

	}
}