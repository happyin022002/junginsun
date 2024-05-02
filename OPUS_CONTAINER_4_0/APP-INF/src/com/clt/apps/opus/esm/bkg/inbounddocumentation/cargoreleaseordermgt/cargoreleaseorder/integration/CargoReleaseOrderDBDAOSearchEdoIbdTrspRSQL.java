/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoIbdTrspRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoIbdTrspRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UI_BKG_0135 화면에서 사용하는 SQL문
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoIbdTrspRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqstNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpCd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoIbdTrspRSQL").append("\n"); 
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
		query.append("SELECT A.EDO_RQST_NO," ).append("\n"); 
		query.append("       A.EDO_RQST_SEQ," ).append("\n"); 
		query.append("       TO_CHAR(A.RQST_TRSP_DT, 'YYYY-MM-DD HH24:MI:SS') RQST_TRSP_DT," ).append("\n"); 
		query.append("       A.ARR_AREA_NO," ).append("\n"); 
		query.append("       B.VNDR_NM AS ARR_AREA_VNDR_NM," ).append("\n"); 
		query.append("       A.ARR_CSTMS_NO," ).append("\n"); 
		query.append("       C.VNDR_NM AS ARR_CSTMS_VNDR_NM," ).append("\n"); 
		query.append("       A.GDS_DESC1," ).append("\n"); 
		query.append("       A.GDS_DESC2," ).append("\n"); 
		query.append("       A.GDS_DESC3," ).append("\n"); 
		query.append("       A.GDS_DESC4," ).append("\n"); 
		query.append("       A.MISC_DESC," ).append("\n"); 
		query.append("       NVL(A.INV_AMT, 0) INV_AMT," ).append("\n"); 
		query.append("       A.INV_CURR_CD," ).append("\n"); 
		query.append("       A.PCK_TP_CD," ).append("\n"); 
		query.append("       NVL(A.PCK_QTY, 0) PCK_QTY," ).append("\n"); 
		query.append("       A.WGT_UT_CD," ).append("\n"); 
		query.append("       NVL(A.TTL_WGT, 0) TTL_WGT," ).append("\n"); 
		query.append("       A.CRE_USR_ID," ).append("\n"); 
		query.append("       A.CRE_DT," ).append("\n"); 
		query.append("       A.UPD_USR_ID," ).append("\n"); 
		query.append("       A.UPD_DT," ).append("\n"); 
		query.append("       (SELECT NVL(COUNT(CNTR_NO), 0)" ).append("\n"); 
		query.append("          FROM BKG_EDO_CNTR" ).append("\n"); 
		query.append("         WHERE EDO_RQST_NO  = A.EDO_RQST_NO" ).append("\n"); 
		query.append("           AND EDO_RQST_SEQ = A.EDO_RQST_SEQ) AS CNTR_NO" ).append("\n"); 
		query.append("  FROM BKG_EDO_IBD_TRSP A," ).append("\n"); 
		query.append("       BKG_EDO_VNDR     B," ).append("\n"); 
		query.append("       BKG_EDO_VNDR     C," ).append("\n"); 
		query.append("       BKG_EDO_MST      D" ).append("\n"); 
		query.append(" WHERE A.EDO_RQST_NO      = @[rqstNo]" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ     = (SELECT MAX(EDO_RQST_SEQ)" ).append("\n"); 
		query.append("                               FROM BKG_EDO_MST" ).append("\n"); 
		query.append("                              WHERE EDO_RQST_NO      = @[rqstNo]" ).append("\n"); 
		query.append("                                AND EDO_TP_CD        = @[tpCd])" ).append("\n"); 
		query.append("   AND A.ARR_AREA_NO      = B.VNDR_NO (+)" ).append("\n"); 
		query.append("   AND B.VNDR_CLSS_CD (+) = '2'" ).append("\n"); 
		query.append("   AND A.ARR_CSTMS_NO     = C.VNDR_NO (+)" ).append("\n"); 
		query.append("   AND C.VNDR_CLSS_CD (+) = '1'" ).append("\n"); 
		query.append("   AND A.EDO_RQST_NO      = D.EDO_RQST_NO" ).append("\n"); 
		query.append("   AND A.EDO_RQST_SEQ     = D.EDO_RQST_SEQ" ).append("\n"); 
		query.append("   AND D.EDO_TP_CD        = @[tpCd]" ).append("\n"); 

	}
}