/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAOAsaNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.05.17 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConsultationSlipRequestMgtDBDAOAsaNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ConsultationSlipRequestMgtDBDAOAsaNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration").append("\n"); 
		query.append("FileName : ConsultationSlipRequestMgtDBDAOAsaNoRSQL").append("\n"); 
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
		query.append("SELECT ASA_NO AS CODE ," ).append("\n"); 
		query.append("       ASA_NO||' '||ASA_CURR_CD||' ('||ASA_PRD_FM_DT||'~'||ASA_PRD_TO_DT||')' AS NAME" ).append("\n"); 
		query.append("FROM (  SELECT  A.ASA_NO " ).append("\n"); 
		query.append("             ,  A.ASA_CURR_CD" ).append("\n"); 
		query.append("             ,  TO_CHAR(TO_DATE(A.ASA_PRD_FM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') ASA_PRD_FM_DT" ).append("\n"); 
		query.append("             ,  TO_CHAR(TO_DATE(A.ASA_PRD_TO_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') ASA_PRD_TO_DT" ).append("\n"); 
		query.append("        FROM AR_AGN_STMT_AGMT   A, " ).append("\n"); 
		query.append("          (SELECT SUBSTR(DECODE(A.STS ,'O' , REPLACE(@[iss_dt],'-','')" ).append("\n"); 
		query.append("                                      ,'C' ,DECODE(B.DT, '01', NULL, B.DT)" ).append("\n"); 
		query.append("                                      ,'N' ,NULL),1,6)     GL_DATE" ).append("\n"); 
		query.append("                     FROM" ).append("\n"); 
		query.append("                             (SELECT NVL(" ).append("\n"); 
		query.append("                                         (SELECT" ).append("\n"); 
		query.append("                                                 CASE" ).append("\n"); 
		query.append("                                                         WHEN SUM(DECODE(CLZ_STS_CD" ).append("\n"); 
		query.append("                                                                       ,'O',1,0)) > 0" ).append("\n"); 
		query.append("                                                         THEN 'O'" ).append("\n"); 
		query.append("                                                         ELSE 'C'" ).append("\n"); 
		query.append("                                                 END STS" ).append("\n"); 
		query.append("                                         FROM    AP_PERIOD" ).append("\n"); 
		query.append("                                         WHERE   SYS_DIV_CD = '15'" ).append("\n"); 
		query.append("                                             AND EFF_YRMON  = SUBSTR(REPLACE(@[iss_dt],'-',''),1,6)" ).append("\n"); 
		query.append("                                             AND OFC_CD    IN (@[cost_ofc_cd]" ).append("\n"); 
		query.append("                                                              ,(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                                FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                                                                WHERE   M.OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("                                                                ) )" ).append("\n"); 
		query.append("                                             AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("                                         ),'C') STS" ).append("\n"); 
		query.append("                             FROM    DUAL" ).append("\n"); 
		query.append("                             ) A" ).append("\n"); 
		query.append("                           , (SELECT MIN(EFF_YRMON)" ).append("\n"); 
		query.append("                                             ||'01' DT" ).append("\n"); 
		query.append("                             FROM    AP_PERIOD" ).append("\n"); 
		query.append("                             WHERE   SYS_DIV_CD   = '15'" ).append("\n"); 
		query.append("                                 AND EFF_YRMON   >= SUBSTR(REPLACE(@[iss_dt],'-',''),1,6)" ).append("\n"); 
		query.append("                                 AND AR_AP_DIV_CD = 'P'" ).append("\n"); 
		query.append("                                 AND OFC_CD      IN (@[ap_ofc_cd]" ).append("\n"); 
		query.append("                                                   ,(SELECT M.AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                     FROM    MDM_ORGANIZATION M" ).append("\n"); 
		query.append("                                                     WHERE   M.OFC_CD = @[ap_ofc_cd]" ).append("\n"); 
		query.append("                                                     ) )" ).append("\n"); 
		query.append("                                 AND CLZ_STS_CD = 'O'" ).append("\n"); 
		query.append("                             ) B" ).append("\n"); 
		query.append("      ) GL" ).append("\n"); 
		query.append("WHERE A.EXPN_EFF_DT IS NULL" ).append("\n"); 
		query.append("AND   A.AC_EFF_DT   IS NULL" ).append("\n"); 
		query.append("AND   A.ASA_CLZ_DT  IS NULL" ).append("\n"); 
		query.append("AND   A.ASA_APRO_DT IS NULL" ).append("\n"); 
		query.append("AND   NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("AND   A.ASA_OFC_CD IN ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = @[inv_ofc_cd])" ).append("\n"); 
		query.append("AND   GL.GL_DATE BETWEEN SUBSTR(A.ASA_PRD_FM_DT,1,6) AND SUBSTR(A.ASA_PRD_TO_DT,1,6)                                                     " ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}