/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalFinderDAOSearchDefaultDateInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDAOSearchDefaultDateInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Default Request , Effective Date Search.
	  * 20141229 S.AR_HD_QTR_OFC_CD > S.AP_OFC_CD
	  * </pre>
	  */
	public ExternalFinderDAOSearchDefaultDateInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDAOSearchDefaultDateInfoRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(LAST_DAY(TO_DATE(A.MAX_EFF_YRMON||'01','YYYYMMDD')),'YYYYMMDD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(SYSDATE,'YYYYMMDD') AS RQST_DT" ).append("\n"); 
		query.append("     , A.CLZ_STS_CD AS VVD_CXL_FLG" ).append("\n"); 
		query.append("  FROM (SELECT '1' AS SEQ" ).append("\n"); 
		query.append("             , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("             , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("             , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND SYS_DIV_CD = DECODE(P.AR_AP_DIV_CD, 'R', '16', '17') --FMS AP전표, '16' AR전표" ).append("\n"); 
		query.append("           AND EFF_YRMON <= TO_CHAR(SYSDATE,'YYYYMM') --201409' --sysdate's month" ).append("\n"); 
		query.append("           AND AR_AP_DIV_CD = DECODE(@[csr_type],'AP','P','R') --AP,  'R' AR인 경우" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT X.AP_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                         WHERE X.OFC_CD = @[slp_ofc_cd]  )" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT '2' AS SEQ" ).append("\n"); 
		query.append("             , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("             , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("             , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND SYS_DIV_CD = DECODE(P.AR_AP_DIV_CD, 'R', '16', '17') --FMS AP전표, '16' AR전표" ).append("\n"); 
		query.append("           AND EFF_YRMON <= TO_CHAR(SYSDATE,'YYYYMM') --201409' --sysdate's month" ).append("\n"); 
		query.append("           AND AR_AP_DIV_CD = DECODE(@[csr_type],'AP','P','R') --AP,  'R' AR인 경우" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                             , MDM_ORGANIZATION Y" ).append("\n"); 
		query.append("                         WHERE X.OFC_CD = Y.AP_OFC_CD" ).append("\n"); 
		query.append("                           AND Y.OFC_CD =@[slp_ofc_cd]  )" ).append("\n"); 
		query.append("         ORDER BY 1 ) A" ).append("\n"); 
		query.append(" WHERE A.CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND ROWNUM = 1 " ).append("\n"); 

	}
}