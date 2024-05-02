/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGTAuditDBDAOAgtAgnCommApprovalNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.22
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.02.22 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGTAuditDBDAOAgtAgnCommApprovalNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * agt_agn_Comm 테이블에서 Approval No를 조회
	  * </pre>
	  */
	public AGTAuditDBDAOAgtAgnCommApprovalNoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.integration").append("\n"); 
		query.append("FileName : AGTAuditDBDAOAgtAgnCommApprovalNoVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("           APRONO AS APRO_NO" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("               SELECT /*+INDEX_DESC (AGN XAK11AGT_AGN_COMM)*/" ).append("\n"); 
		query.append("                      1 AS NO," ).append("\n"); 
		query.append("                      SUBSTRB (AGN.AR_OFC_CD, 1, 3)" ).append("\n"); 
		query.append("                   || TO_CHAR (SYSDATE, 'YYMM')" ).append("\n"); 
		query.append("                   || TRIM (TO_CHAR (SUBSTR (MAX (AGN.COMM_APRO_NO), 8, 4) + 1, '0000'))" ).append("\n"); 
		query.append("                   || 'T' AS APRONO" ).append("\n"); 
		query.append("                 FROM AGT_AGN_COMM AGN" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} == 'HAMUR' or ${ar_ofc_cd} == 'HAMBB') " ).append("\n"); 
		query.append("                WHERE AGN.AR_OFC_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      @[ar_ofc_cd], 'HAMUR','HAMBB'" ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("#elseif (${ar_ofc_cd} == 'JKTBA' or ${ar_ofc_cd} == 'JKTBB')" ).append("\n"); 
		query.append("                WHERE AGN.AR_OFC_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      @[ar_ofc_cd], 'JKTBA', 'JKTBB'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#elseif (${ar_ofc_cd} == 'MEXBA' or ${ar_ofc_cd} == 'MEXBB')" ).append("\n"); 
		query.append("                WHERE AGN.AR_OFC_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      @[ar_ofc_cd], 'MEXBA', 'MEXBB'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                WHERE AGN.AR_OFC_CD         = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                  AND AGN.AGN_CD            = AGN.AGN_CD" ).append("\n"); 
		query.append("                  AND AC_APRO_DT           >  SYSDATE - 31" ).append("\n"); 
		query.append("                  AND AGN.COMM_APRO_NO   LIKE SUBSTRB (AGN.AR_OFC_CD,1,3) || TO_CHAR (SYSDATE,'YYMM') || '%'" ).append("\n"); 
		query.append("                  AND AGN.AC_APRO_DT       IS NOT NULL" ).append("\n"); 
		query.append("                  AND AGN.COMM_PROC_STS_CD" ).append("\n"); 
		query.append("                   IN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      'AS', 'IF'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("             GROUP BY SUBSTRB (AGN.AR_OFC_CD,1,3)" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("               SELECT" ).append("\n"); 
		query.append("                      2 AS No," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      SUBSTR (@[ar_ofc_cd], 1, 3)" ).append("\n"); 
		query.append("                   || TO_CHAR (SYSDATE,'YYMM')" ).append("\n"); 
		query.append("                   || '0001T' AS APRONO " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 FROM DUAL" ).append("\n"); 
		query.append("             ORDER BY NO" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("     WHERE ROWNUM = 1" ).append("\n"); 

	}
}