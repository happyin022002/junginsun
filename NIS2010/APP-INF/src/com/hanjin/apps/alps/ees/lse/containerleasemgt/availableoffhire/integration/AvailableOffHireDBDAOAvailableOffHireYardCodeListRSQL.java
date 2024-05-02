/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireYardCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.05.03 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireYardCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AvailableOffHire Yard 코드목록을 조회한다.
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireYardCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireYardCodeListRSQL").append("\n"); 
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
		query.append("SELECT  A.YARD_TYPE, A.YD_CD, A.YD_NM, A.OFC_CD, A.YD_ADDR,         " ).append("\n"); 
		query.append("        B.VNDR_SEQ, B.VNDR_LGL_ENG_NM,         " ).append("\n"); 
		query.append("		A.INTL_PHN_NO, A.PHN_NO, A.FAX_NO, A.YD_PIC_NM, A.YD_EML, " ).append("\n"); 
		query.append("		A.CRE_USR_ID, TO_CHAR(A.CRE_DT, 'YYYYMMDD') AS CRE_DT, " ).append("\n"); 
		query.append("		A.UPD_USR_ID, TO_CHAR(A.UPD_DT, 'YYYYMMDD') AS UPD_DT" ).append("\n"); 
		query.append("FROM   (SELECT  'M' AS YARD_TYPE, A.YD_CD, " ).append("\n"); 
		query.append("                A.YD_NM, A.OFC_CD, A.YD_ADDR," ).append("\n"); 
		query.append("                A.INTL_PHN_NO, A.PHN_NO, A.FAX_NO, A.YD_PIC_NM, " ).append("\n"); 
		query.append("                A.YD_EML, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT " ).append("\n"); 
		query.append("        FROM    MDM_YARD A," ).append("\n"); 
		query.append("                MDM_LOCATION B" ).append("\n"); 
		query.append("        WHERE   A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("        AND     NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        AND     NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT  'L' AS YARD_TYPE, A.LSE_CO_YD_CD AS YD_CD, " ).append("\n"); 
		query.append("                A.LSE_CO_YD_NM AS YD_NM, B.EQ_CTRL_OFC_CD AS OFC_CD, " ).append("\n"); 
		query.append("                A.YD_ADDR, A.INTL_PHN_NO, A.PHN_NO, A.FAX_NO, A.YD_PIC_NM, " ).append("\n"); 
		query.append("                A.YD_EML, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT" ).append("\n"); 
		query.append("        FROM    MDM_LSE_CO_YD A," ).append("\n"); 
		query.append("                MDM_LOCATION B" ).append("\n"); 
		query.append("        WHERE   A.LSE_CO_YD_CD NOT IN(SELECT  YD_CD FROM MDM_YARD WHERE DELT_FLG <> 'Y')" ).append("\n"); 
		query.append("        AND     A.LSE_CO_YD_CD LIKE B.LOC_CD||'%' " ).append("\n"); 
		query.append("        AND     A.DELT_FLG <> 'Y'" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("       (SELECT  DISTINCT A.YD_CD, A.VNDR_SEQ, B.VNDR_LGL_ENG_NM       " ).append("\n"); 
		query.append("        FROM   (SELECT  YD_CD, VNDR_SEQ" ).append("\n"); 
		query.append("                FROM   (SELECT  A.YD_CD, B.LVL_NO,  " ).append("\n"); 
		query.append("                                CASE WHEN B.LVL_NO = 1 THEN A.N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 2 THEN A.N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 3 THEN A.N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("                                END VNDR_SEQ             " ).append("\n"); 
		query.append("                        FROM    MDM_YARD A,       " ).append("\n"); 
		query.append("                               (SELECT LEVEL AS LVL_NO " ).append("\n"); 
		query.append("                                FROM DUAL CONNECT BY LEVEL <= 3) B                   " ).append("\n"); 
		query.append("                        )    " ).append("\n"); 
		query.append("                WHERE   VNDR_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  YD_CD, VNDR_SEQ " ).append("\n"); 
		query.append("                FROM   (SELECT  A.LSE_CO_YD_CD AS YD_CD, B.LVL_NO,  " ).append("\n"); 
		query.append("                                CASE WHEN B.LVL_NO = 1 THEN A.LSE_CO_VNDR_SEQ1" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 2 THEN A.LSE_CO_VNDR_SEQ2" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 3 THEN A.LSE_CO_VNDR_SEQ3" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 4 THEN A.LSE_CO_VNDR_SEQ4" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 5 THEN A.LSE_CO_VNDR_SEQ5" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 6 THEN A.LSE_CO_VNDR_SEQ6" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 7 THEN A.LSE_CO_VNDR_SEQ7" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 8 THEN A.LSE_CO_VNDR_SEQ8" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO = 9 THEN A.LSE_CO_VNDR_SEQ9" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =10 THEN A.LSE_CO_VNDR_SEQ10" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =11 THEN A.LSE_CO_VNDR_SEQ11" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =12 THEN A.LSE_CO_VNDR_SEQ12" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =13 THEN A.LSE_CO_VNDR_SEQ13" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =14 THEN A.LSE_CO_VNDR_SEQ14" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =15 THEN A.LSE_CO_VNDR_SEQ15" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =16 THEN A.LSE_CO_VNDR_SEQ16" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =17 THEN A.LSE_CO_VNDR_SEQ17" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =18 THEN A.LSE_CO_VNDR_SEQ18" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =19 THEN A.LSE_CO_VNDR_SEQ19" ).append("\n"); 
		query.append("                                     WHEN B.LVL_NO =20 THEN A.LSE_CO_VNDR_SEQ20" ).append("\n"); 
		query.append("                                END VNDR_SEQ             " ).append("\n"); 
		query.append("                        FROM    MDM_LSE_CO_YD A,       " ).append("\n"); 
		query.append("                               (SELECT LEVEL AS LVL_NO " ).append("\n"); 
		query.append("                                FROM DUAL CONNECT BY LEVEL <= 20) B                                   " ).append("\n"); 
		query.append("                        )   " ).append("\n"); 
		query.append("                WHERE   VNDR_SEQ IS NOT NULL) A," ).append("\n"); 
		query.append("                MDM_VENDOR B" ).append("\n"); 
		query.append("        WHERE   A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("        ) B  " ).append("\n"); 
		query.append("WHERE   1 = 1           " ).append("\n"); 
		query.append("AND     A.YD_CD = B.YD_CD(+)               " ).append("\n"); 
		query.append("#if (${yd_cd} != '')                                            " ).append("\n"); 
		query.append("AND     A.YD_CD LIKE @[yd_cd]||'%'  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '')                                            " ).append("\n"); 
		query.append("AND     A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${yd_tp} != '')                                            " ).append("\n"); 
		query.append("AND     A.YARD_TYPE = @[yd_tp]    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY DECODE(A.YARD_TYPE, 'M',0,1), A.YD_CD, B.VNDR_SEQ DESC" ).append("\n"); 

	}
}