/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOsearchYdChgNoDataInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOsearchYdChgNoDataInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * tariff copy하기 위한 정보 조회
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOsearchYdChgNoDataInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOsearchYdChgNoDataInfoRSQL").append("\n"); 
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
		query.append("WITH ACCT_LIST AS (" ).append("\n"); 
		query.append(" SELECT B.ACCT_CD||RPAD(A.VNDR_SEQ,6,'*')||RPAD(A.YD_CHG_NO,10,'*')||RPAD(A.YD_CHG_VER_SEQ,3,'*') AS ACCT_VNDR, A.YD_CHG_VER_SEQ, YD_CHG_NO" ).append("\n"); 
		query.append("   FROM PSO_YD_CHG A, TES_LGS_COST B" ).append("\n"); 
		query.append("   WHERE A.YD_CD       = @[yd_cd]                                      " ).append("\n"); 
		query.append("   -- AND A.LST_FLG         ='Y'" ).append("\n"); 
		query.append("  --  AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT " ).append("\n"); 
		query.append("    AND A.LGS_COST_CD   = B.LGS_COST_CD" ).append("\n"); 
		query.append("     ) " ).append("\n"); 
		query.append("  SELECT  ACCT_CD," ).append("\n"); 
		query.append("          VNDR_SEQ," ).append("\n"); 
		query.append("          YD_CHG_NO, " ).append("\n"); 
		query.append("          YD_CHG_VER_SEQ, " ).append("\n"); 
		query.append("          LGS_COST_CD AS COST_CD," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'B','Y',NULL)) AS BASE," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'S','Y',NULL)) AS SURCHARGE," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'D','Y',NULL)) AS DISCOUNT," ).append("\n"); 
		query.append("          MAX(VNDR_LGL_ENG_NM) AS VNDR_NM," ).append("\n"); 
		query.append("          DECODE(MIN(X.CNT),0,NULL,'Y') AS REGULAR," ).append("\n"); 
		query.append("          ACCT_CD AS ACCT_CD2, " ).append("\n"); 
		query.append("          @[yd_cd] AS YD_CD," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'B','Y',NULL)) AS BASE2," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'S','Y',NULL)) AS SURCHARGE2," ).append("\n"); 
		query.append("          MIN(DECODE(X.PSO_CHG_TP_CD,'D','Y',NULL)) AS DISCOUNT2," ).append("\n"); 
		query.append("          DECODE(MIN(X.CNT),0,NULL,'Y') AS REGULAR2" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT B.PSO_CHG_TP_CD ,      " ).append("\n"); 
		query.append("       C. ACCT_CD,  A.VNDR_SEQ," ).append("\n"); 
		query.append("       A.YD_CHG_NO, A.YD_CHG_VER_SEQ,  " ).append("\n"); 
		query.append("       A.LGS_COST_CD,E.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("       NVL(( SELECT COUNT(1) FROM PSO_YD_CHG_OBJ_LIST" ).append("\n"); 
		query.append("              WHERE YD_CHG_NO      =  A.YD_CHG_NO" ).append("\n"); 
		query.append("                AND YD_CHG_VER_SEQ = A.YD_CHG_VER_SEQ ),0) CNT" ).append("\n"); 
		query.append(" FROM PSO_YD_CHG A, PSO_YD_CHG_XPR B, TES_LGS_COST C, ACCT_LIST D, MDM_VENDOR E" ).append("\n"); 
		query.append("WHERE A.YD_CD           = @[yd_cd]                                       " ).append("\n"); 
		query.append("  --AND A.LST_FLG         = 'Y'" ).append("\n"); 
		query.append("  AND A.YD_CHG_NO       = B.YD_CHG_NO" ).append("\n"); 
		query.append("  AND A.YD_CHG_VER_SEQ  = B.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("  AND A.LGS_COST_CD     = C.LGS_COST_CD" ).append("\n"); 
		query.append("  AND A.YD_CHG_NO       = D.YD_CHG_NO" ).append("\n"); 
		query.append("  AND A.YD_CHG_VER_SEQ  = D.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("  AND E.VNDR_SEQ        = A.VNDR_SEQ" ).append("\n"); 
		query.append("  AND D.ACCT_VNDR  IN  ( #foreach( $key IN ${all_acct_vndr}) " ).append("\n"); 
		query.append("                                                   #if($velocityCount < $all_acct_vndr.size())" ).append("\n"); 
		query.append("                                                        '$key'," ).append("\n"); 
		query.append("                                                    #else" ).append("\n"); 
		query.append("                                                        '$key'" ).append("\n"); 
		query.append("                                                    #end" ).append("\n"); 
		query.append("                                          #end " ).append("\n"); 
		query.append("                                           )" ).append("\n"); 
		query.append("  AND SYSDATE BETWEEN A.EFF_DT AND A.EXP_DT ) X" ).append("\n"); 
		query.append(" GROUP BY ACCT_CD," ).append("\n"); 
		query.append("          VNDR_SEQ," ).append("\n"); 
		query.append("          YD_CHG_NO, " ).append("\n"); 
		query.append("          YD_CHG_VER_SEQ, " ).append("\n"); 
		query.append("          LGS_COST_CD" ).append("\n"); 

	}
}