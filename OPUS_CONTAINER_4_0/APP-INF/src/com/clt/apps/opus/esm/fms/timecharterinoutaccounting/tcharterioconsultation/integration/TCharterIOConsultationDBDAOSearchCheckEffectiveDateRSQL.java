/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 회계일자 검사한다
	  * 20141229 S.AR_HD_QTR_OFC_CD > S.AP_OFC_CD
	  * </pre>
	  */
	public TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.integration").append("\n"); 
		query.append("FileName : TCharterIOConsultationDBDAOSearchCheckEffectiveDateRSQL").append("\n"); 
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
		query.append("SELECT A.MAX_EFF_YRMON AS EFF_YRMON" ).append("\n"); 
		query.append("  FROM (SELECT '1' AS SEQ" ).append("\n"); 
		query.append("             , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("             , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("             , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND SYS_DIV_CD = DECODE(P.AR_AP_DIV_CD, 'R', '16', '17') --FMS AP전표, '16' AR전표" ).append("\n"); 
		query.append("           AND EFF_YRMON <= SUBSTR(REPLACE(@[eff_yrmon],'-',''), 1, 6) --201409' --sysdate's month" ).append("\n"); 
		query.append("           AND AR_AP_DIV_CD = DECODE('AP','AP','P','R') --AP,  'R' AR인 경우" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT X.AP_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                         WHERE X.OFC_CD = @[slp_ofc_cd] )" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT '2' AS SEQ" ).append("\n"); 
		query.append("             , MAX(CLZ_STS_CD) CLZ_STS_CD" ).append("\n"); 
		query.append("             , MIN(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MIN_EFF_YRMON" ).append("\n"); 
		query.append("             , MAX(DECODE(CLZ_STS_CD,'O',EFF_YRMON)) MAX_EFF_YRMON" ).append("\n"); 
		query.append("          FROM AP_PERIOD P" ).append("\n"); 
		query.append("         WHERE CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("           AND SYS_DIV_CD = DECODE(P.AR_AP_DIV_CD, 'R', '16', '17') --FMS AP전표, '16' AR전표" ).append("\n"); 
		query.append("           AND EFF_YRMON <= SUBSTR(REPLACE(@[eff_yrmon],'-',''), 1, 6) --201409' --sysdate's month" ).append("\n"); 
		query.append("           AND AR_AP_DIV_CD = DECODE('AP','AP','P','R') --AP,  'R' AR인 경우" ).append("\n"); 
		query.append("           AND OFC_CD = (SELECT X.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                          FROM MDM_ORGANIZATION X" ).append("\n"); 
		query.append("                             , MDM_ORGANIZATION Y" ).append("\n"); 
		query.append("                         WHERE X.OFC_CD = Y.AP_OFC_CD" ).append("\n"); 
		query.append("                           AND Y.OFC_CD =@[slp_ofc_cd] )" ).append("\n"); 
		query.append("         ORDER BY 1 ) A" ).append("\n"); 
		query.append(" WHERE A.CLZ_STS_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND ROWNUM = 1 " ).append("\n"); 

	}
}