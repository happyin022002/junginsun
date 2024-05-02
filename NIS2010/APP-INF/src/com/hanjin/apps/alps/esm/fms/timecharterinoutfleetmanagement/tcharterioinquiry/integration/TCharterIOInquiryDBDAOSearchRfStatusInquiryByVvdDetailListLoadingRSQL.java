/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListLoadingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListLoadingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD로 RF 상태를 상세 조회한다.
	  * Loading값 조회
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListLoadingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOSearchRfStatusInquiryByVvdDetailListLoadingRSQL").append("\n"); 
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
		query.append("WITH SKD AS (" ).append("\n"); 
		query.append("    SELECT S.*," ).append("\n"); 
		query.append("      P.REP_PORT_CD," ).append("\n"); 
		query.append("      DECODE(P.CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLANTYPE" ).append("\n"); 
		query.append("    FROM VSK_VSL_PORT_SKD S," ).append("\n"); 
		query.append("      STO_PLN_VSL_PORT_SKD P" ).append("\n"); 
		query.append("    WHERE S.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'V'" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'F'" ).append("\n"); 
		query.append("      AND S.TURN_PORT_IND_CD <> 'D'" ).append("\n"); 
		query.append("      AND (S.SKD_CNG_STS_CD IS NULL OR S.SKD_CNG_STS_CD <> 'S')" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD <> 'PAPAC'" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD <> 'EGSUZ'" ).append("\n"); 
		query.append("      AND S.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("      AND S.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("      AND S.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("      AND S.VPS_PORT_CD = P.VPS_PORT_CD" ).append("\n"); 
		query.append("      AND S.CLPT_IND_SEQ = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("	  AND (P.CHK_FNL_PLN_FLG = 'Y' OR P.CHK_MTY_PLN_FLG = 'Y')	" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" P.PORT_CD	AS port" ).append("\n"); 
		query.append(",P.POL		AS loadingport" ).append("\n"); 
		query.append(",P.POD		AS dischargingport" ).append("\n"); 
		query.append(",P.OPR_CD	AS operator" ).append("\n"); 
		query.append(",P.ID 		AS cntrno" ).append("\n"); 
		query.append(",'Loading' 	AS kind" ).append("\n"); 
		query.append(",S.YD_CD     AS yard" ).append("\n"); 
		query.append(",S.CLPT_IND_SEQ  AS indicator  " ).append("\n"); 
		query.append(",TO_CHAR(S.VPS_ETA_DT, 'YYYY-MM-DD') vpsetadt" ).append("\n"); 
		query.append(",TO_CHAR(S.VPS_ETD_DT, 'YYYY-MM-DD') vpsetddt   " ).append("\n"); 
		query.append("FROM BAY_PLAN P, SKD S" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND P.VSL_CD = S.VSL_CD" ).append("\n"); 
		query.append("AND P.VOY_NO = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND P.DIR_CD = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND P.PORT_CD = S.VPS_PORT_CD" ).append("\n"); 
		query.append("AND P.CALL_IND = S.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND P.PLAN_TYPE = 'F'" ).append("\n"); 
		query.append("AND P.TEMP IS NOT NULL" ).append("\n"); 
		query.append("AND NVL(S.REP_PORT_CD, P.PORT_CD) = P.POL" ).append("\n"); 
		query.append("ORDER BY S.CLPT_SEQ ASC" ).append("\n"); 

	}
}