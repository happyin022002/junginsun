/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOSearchRfStatusPortCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.01.20 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOSearchRfStatusPortCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD로 RF 상태를 상세 조회 할 Port를 조회한다.
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOSearchRfStatusPortCdListRSQL(){
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
		query.append("FileName : TCharterIOInquiryDBDAOSearchRfStatusPortCdListRSQL").append("\n"); 
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
		query.append("    SELECT " ).append("\n"); 
		query.append("      S.VPS_PORT_CD 	AS port," ).append("\n"); 
		query.append("      S.CLPT_IND_SEQ 	AS indicator," ).append("\n"); 
		query.append("      S.YD_CD 			AS yard" ).append("\n"); 
		query.append("      ,DECODE(P.CHK_MTY_PLN_FLG, 'Y', 'E', 'F') AS PLANTYPE" ).append("\n"); 
		query.append("      ,S.CLPT_SEQ" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("      VSK_VSL_PORT_SKD S," ).append("\n"); 
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
		query.append("	  AND (P.CHK_FNL_PLN_FLG = 'Y' OR P.CHK_MTY_PLN_FLG = 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  S.port," ).append("\n"); 
		query.append("  S.indicator," ).append("\n"); 
		query.append("  S.yard" ).append("\n"); 
		query.append("  ,NVL(LAG(S.PLANTYPE,1) OVER (ORDER by S.CLPT_SEQ),'F') AS preplantype" ).append("\n"); 
		query.append("FROM SKD S" ).append("\n"); 
		query.append("ORDER BY S.CLPT_SEQ" ).append("\n"); 

	}
}