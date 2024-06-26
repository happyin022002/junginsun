/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AGTCommonDBDAOSearchFACSubOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.03.02 이정수
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

public class AGTCommonDBDAOSearchFACSubOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchFACSubOfficeList
	  * </pre>
	  */
	public AGTCommonDBDAOSearchFACSubOfficeListRSQL(){
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
		query.append("FileName : AGTCommonDBDAOSearchFACSubOfficeListRSQL").append("\n"); 
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
		query.append("	DISTINCT X.SUB_OFC AS CODE, " ).append("\n"); 
		query.append("		X.SUB_OFC AS NAME " ).append("\n"); 
		query.append("FROM (SELECT " ).append("\n"); 
		query.append("		DISTINCT '1', " ).append("\n"); 
		query.append("			A.OFC_CD AS USRIDOFC, " ).append("\n"); 
		query.append("			A.AR_OFC AS AR_OFC, " ).append("\n"); 
		query.append("	        C.OFC_CD SUB_OFC " ).append("\n"); 
		query.append("        FROM (SELECT " ).append("\n"); 
		query.append("				A.OFC_CD AS OFC_CD, " ).append("\n"); 
		query.append("				B.AR_OFC_CD AS AR_OFC " ).append("\n"); 
		query.append("            FROM MDM_ORGANIZATION A, " ).append("\n"); 
		query.append("            	MDM_ORGANIZATION B " ).append("\n"); 
		query.append("            WHERE A.OFC_CD = @[code] " ).append("\n"); 
		query.append("            AND A.OFC_CD = " ).append("\n"); 
		query.append("                    DECODE " ).append("\n"); 
		query.append("                        (A.OFC_KND_CD, " ).append("\n"); 
		query.append("                         '2', NVL (B.AR_HD_QTR_OFC_CD, B.PRNT_OFC_CD), " ).append("\n"); 
		query.append("                         '3', B.AR_OFC_CD, " ).append("\n"); 
		query.append("                         B.OFC_CD " ).append("\n"); 
		query.append("                        ) " ).append("\n"); 
		query.append("                   ) A, " ).append("\n"); 
		query.append("            MDM_ORGANIZATION C " ).append("\n"); 
		query.append("            WHERE A.AR_OFC = NVL (C.AR_OFC_CD, C.OFC_CD) " ).append("\n"); 
		query.append("                AND C.VNDR_CNT_CD IS NOT NULL " ).append("\n"); 
		query.append("                AND NVL (C.DELT_FLG, 'N') = 'N') X " ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}