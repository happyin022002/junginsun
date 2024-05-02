/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCommonDBDAOSearchSubOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.10
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.10 이정수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTCommonDBDAOSearchSubOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchSubOfficeList
	  * </pre>
	  */
	public AGTCommonDBDAOSearchSubOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.agt.common.integration").append("\n"); 
		query.append("FileName : AGTCommonDBDAOSearchSubOfficeListRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           LST.SUB_OFC AS CODE, " ).append("\n"); 
		query.append("	       LST.SUB_OFC AS NAME" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("                  SELECT " ).append("\n"); 
		query.append("				DISTINCT '1'," ).append("\n"); 
		query.append("               A.OFC_CD USRIDOFC," ).append("\n"); 
		query.append("               A.AR_OFC AR_OFC," ).append("\n"); 
		query.append("               C.OFC_CD SUB_OFC" ).append("\n"); 
		query.append("          FROM (SELECT A.OFC_CD OFC_CD," ).append("\n"); 
		query.append("                       B.AR_OFC_CD AR_OFC" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                 WHERE A.OFC_CD = @[code]" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_KND_CD," ).append("\n"); 
		query.append("                                                '2',B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("                                                '3',B.AR_OFC_CD," ).append("\n"); 
		query.append("                                                B.OFC_CD)" ).append("\n"); 
		query.append("               ) A," ).append("\n"); 
		query.append("               MDM_ORGANIZATION C" ).append("\n"); 
		query.append("         WHERE A.AR_OFC = NVL(C.AR_OFC_CD, C.OFC_CD)" ).append("\n"); 
		query.append("           AND C.VNDR_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("				'2'," ).append("\n"); 
		query.append("               B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("               A.FINC_OFC_CD," ).append("\n"); 
		query.append("               SUBSTR(A.OFC_CD, 1, 3) || A.CHN_AGN_CD" ).append("\n"); 
		query.append("          FROM BKG_CHN_AGN A," ).append("\n"); 
		query.append("               MDM_ORGANIZATION B" ).append("\n"); 
		query.append("         WHERE A.FINC_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.OFC_CD IN" ).append("\n"); 
		query.append("               (SELECT " ).append("\n"); 
		query.append("					DISTINCT B.AR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                 WHERE A.OFC_CD = @[code]" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE(A.OFC_KND_CD," ).append("\n"); 
		query.append("                                                '2',B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("                                                '3',B.AR_OFC_CD," ).append("\n"); 
		query.append("                                                B.OFC_CD))" ).append("\n"); 
		query.append("           AND A.VNDR_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("        UNION" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("				DISTINCT '3'," ).append("\n"); 
		query.append("               B.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("               A.FINC_OFC_CD," ).append("\n"); 
		query.append("               A.OFC_CD" ).append("\n"); 
		query.append("          FROM BKG_CHN_AGN A," ).append("\n"); 
		query.append("               MDM_ORGANIZATION B" ).append("\n"); 
		query.append("         WHERE A.FINC_OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("           AND B.OFC_CD IN" ).append("\n"); 
		query.append("               (SELECT " ).append("\n"); 
		query.append("					DISTINCT B.AR_OFC_CD" ).append("\n"); 
		query.append("                  FROM MDM_ORGANIZATION A," ).append("\n"); 
		query.append("                       MDM_ORGANIZATION B" ).append("\n"); 
		query.append("                 WHERE A.OFC_CD = @[code]" ).append("\n"); 
		query.append("                   AND A.OFC_CD = DECODE (A.OFC_KND_CD, '2',B.AR_HD_QTR_OFC_CD, '3',B.AR_OFC_CD, B.OFC_CD))" ).append("\n"); 
		query.append("           AND A.VNDR_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("       ) LST," ).append("\n"); 
		query.append("       AGT_FINC_OFC_INFO FOI" ).append("\n"); 
		query.append(" WHERE LST.AR_OFC = FOI.AR_OFC_CD" ).append("\n"); 
		query.append("   AND LST.SUB_OFC = FOI.AGN_CD" ).append("\n"); 
		query.append("   AND NVL(FOI.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("  GROUP BY LST.SUB_OFC, " ).append("\n"); 
		query.append("	       LST.SUB_OFC" ).append("\n"); 
		query.append("  ORDER BY 1" ).append("\n"); 

	}
}