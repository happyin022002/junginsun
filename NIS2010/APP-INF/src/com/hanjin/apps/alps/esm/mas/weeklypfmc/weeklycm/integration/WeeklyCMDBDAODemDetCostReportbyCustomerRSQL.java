/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WeeklyCMDBDAODemDetCostReportbyCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2016.03.22 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAODemDetCostReportbyCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Cost Report by Customer 를 조회한다.
	  * 2015.05.11 김시몬 Status 추가
	  * </pre>
	  */
	public WeeklyCMDBDAODemDetCostReportbyCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rfa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAODemDetCostReportbyCustomerRSQL").append("\n"); 
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
		query.append("SELECT COST_YRMON, " ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD, " ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(STATUS,1,'Finish','Unfinish') AS STATUS," ).append("\n"); 
		query.append("       SUM(BKG_QTY) AS BKG_QTY," ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,SUM(PA_CM_AMT)/SUM(BKG_QTY))       AS CMPB," ).append("\n"); 
		query.append("#if (${f_demdet} == 'Y')        " ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,SUM(DMDT_COM_AMT)/SUM(BKG_QTY))    AS DMDT_COM_AMT," ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,SUM(STO_ORG_AMT)/SUM(BKG_QTY))     AS STO_EQ_AMT," ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,SUM(CNTR_ORG_AMT)/SUM(BKG_QTY))    AS CNTR_ORG_DEM_AMT," ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,SUM(CHSS_ORG_AMT)/SUM(BKG_QTY))    AS CHSS_ORG_DEM_AMT," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       SUM(CNTR_QTY) AS CNTR_QTY," ).append("\n"); 
		query.append("#if (${f_demdet} == 'Y')       " ).append("\n"); 
		query.append("       ROUND(DECODE(SUM(CNTR_QTY),0,0,SUM(DMDT_COM_AMT2)/SUM(CNTR_QTY)),2) AS DMDT_COM_AMT2," ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("       DECODE(SUM(CNTR_QTY),0,0,SUM(STO_TTL_AMT)/SUM(CNTR_QTY))   AS STO_DEM_AMT," ).append("\n"); 
		query.append("       DECODE(SUM(CNTR_QTY),0,0,SUM(CNTR_TTL_AMT)/SUM(CNTR_QTY))  AS CNTR_DEM_AMT," ).append("\n"); 
		query.append("       DECODE(SUM(CNTR_QTY),0,0,SUM(CHSS_TTL_AMT)/SUM(CNTR_QTY))  AS CHSS_DEM_AMT,       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       DECODE(SUM(BKG_QTY),0,0,(SUM(PA_CM_AMT)/SUM(BKG_QTY) + " ).append("\n"); 
		query.append("                                                 (SUM(STO_ORG_AMT)  +" ).append("\n"); 
		query.append("                                                  SUM(CNTR_ORG_AMT) + " ).append("\n"); 
		query.append("                                                  SUM(CHSS_ORG_AMT) " ).append("\n"); 
		query.append("                                          #if (${f_demdet} == 'Y')         " ).append("\n"); 
		query.append("                                                  + SUM(DMDT_COM_AMT)" ).append("\n"); 
		query.append("                                          #end        " ).append("\n"); 
		query.append("                                                  )/SUM(BKG_QTY)" ).append("\n"); 
		query.append("                                                  -" ).append("\n"); 
		query.append("                                                 (SUM(STO_TTL_AMT)  + " ).append("\n"); 
		query.append("                                                  SUM(CNTR_TTL_AMT) +" ).append("\n"); 
		query.append("                                                  SUM(CHSS_TTL_AMT)" ).append("\n"); 
		query.append("                                          #if (${f_demdet} == 'Y')         " ).append("\n"); 
		query.append("                                                  + SUM(DMDT_COM_AMT2) " ).append("\n"); 
		query.append("                                          #end       " ).append("\n"); 
		query.append("                                                  ) /SUM(CNTR_QTY)" ).append("\n"); 
		query.append("                                               ))  AS CMPB2                              " ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT COST_YRMON, " ).append("\n"); 
		query.append("               COST_WK," ).append("\n"); 
		query.append("               BKG_NO," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               SC_NO," ).append("\n"); 
		query.append("               RFA_NO," ).append("\n"); 
		query.append("               DECODE(SIGN(COUNT(CNTR_NO) - MAX(BKG_QTY)),-1,0,DECODE(MIN(STATUS),1,1,0)) AS STATUS," ).append("\n"); 
		query.append("               MAX(BKG_QTY)         AS BKG_QTY," ).append("\n"); 
		query.append("               MAX(DMDT_COM_AMT)    AS DMDT_COM_AMT," ).append("\n"); 
		query.append("               MAX(PA_CM_AMT)       AS PA_CM_AMT," ).append("\n"); 
		query.append("               MAX(STO_ORG_AMT)     AS STO_ORG_AMT," ).append("\n"); 
		query.append("               MAX(CNTR_ORG_AMT)    AS CNTR_ORG_AMT," ).append("\n"); 
		query.append("               MAX(CHSS_ORG_AMT)    AS CHSS_ORG_AMT," ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               COUNT(CNTR_NO)     AS CNTR_QTY," ).append("\n"); 
		query.append("               SUM(DMDT_COM_AMT2) AS DMDT_COM_AMT2," ).append("\n"); 
		query.append("               SUM(STO_TTL_AMT)   AS STO_TTL_AMT," ).append("\n"); 
		query.append("               SUM(CHSS_TTL_AMT)  AS CHSS_TTL_AMT," ).append("\n"); 
		query.append("               SUM(CNTR_TTL_AMT)  AS CNTR_TTL_AMT" ).append("\n"); 
		query.append("          FROM (   " ).append("\n"); 
		query.append("                SELECT A.COST_YRMON, " ).append("\n"); 
		query.append("                       A.COST_WK," ).append("\n"); 
		query.append("                       A.BKG_NO," ).append("\n"); 
		query.append("                       B.CNTR_NO," ).append("\n"); 
		query.append("                       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       A.POR_CD," ).append("\n"); 
		query.append("                       A.DEL_CD," ).append("\n"); 
		query.append("                       A.CTRT_OFC_CD," ).append("\n"); 
		query.append("                       A.SC_NO," ).append("\n"); 
		query.append("                       A.RFA_NO," ).append("\n"); 
		query.append("                       MAX(DECODE(B.CNTR_FM_MVMT_STS_CD,'ID',1,0)) AS STATUS," ).append("\n"); 
		query.append("                       MAX(A.BKG_QTY)         AS BKG_QTY," ).append("\n"); 
		query.append("                       MAX(A.DMDT_COM_AMT)    AS DMDT_COM_AMT," ).append("\n"); 
		query.append("                       MAX(A.PA_CM_AMT)       AS PA_CM_AMT," ).append("\n"); 
		query.append("                       MAX(A.STO_ORG_AMT)     AS STO_ORG_AMT," ).append("\n"); 
		query.append("                       MAX(A.CNTR_ORG_AMT)    AS CNTR_ORG_AMT," ).append("\n"); 
		query.append("                       MAX(A.CHSS_ORG_AMT)    AS CHSS_ORG_AMT," ).append("\n"); 
		query.append("                                              " ).append("\n"); 
		query.append("                       NVL(SUM(B.INV_CHG_AMT), 0) AS DMDT_COM_AMT2," ).append("\n"); 
		query.append("                       " ).append("\n"); 
		query.append("                       SUM(DECODE(SUBSTR(B.ITM_NM,LENGTH(B.ITM_NM)-2,3),'STO',B.COST_TTL_AMT,0)) AS STO_TTL_AMT," ).append("\n"); 
		query.append("                       SUM(DECODE(SUBSTR(B.ITM_NM,5,4),'CHSS', B.COST_TTL_AMT,0)) AS CHSS_TTL_AMT," ).append("\n"); 
		query.append("                       SUM(DECODE(SUBSTR(B.ITM_NM,5,4),'CNTR', B.COST_TTL_AMT,0)) AS CNTR_TTL_AMT" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("                        #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                               /*+ INDEX(B XFN3MAS_BKG_EXPN_DTL_WK) */" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                               /*+ INDEX(B XAK3MAS_BKG_EXPN_DTL) */" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                               B.SLS_YRMON AS COST_YRMON,  -- WEEK 선택시                       " ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                               B.COST_YRMON,       -- MONTH선택시" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                               B.COST_WK," ).append("\n"); 
		query.append("                               B.BKG_NO," ).append("\n"); 
		query.append("                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               B.BKG_POR_CD   AS POR_CD," ).append("\n"); 
		query.append("                               B.BKG_DEL_CD   AS DEL_CD," ).append("\n"); 
		query.append("                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                               B.SC_NO," ).append("\n"); 
		query.append("                               B.RFA_NO," ).append("\n"); 
		query.append("                               SUM(B.BKG_QTY)    AS BKG_QTY,       " ).append("\n"); 
		query.append("                               SUM(NVL(B.BKG_REV,0) + NVL(B.BKG_OFT_REV,0) + NVL(B.BKG_MISC_REV,0) + NVL(B.SCR_CHG_REV,0)) " ).append("\n"); 
		query.append("                               - SUM(NVL(B.PA_CM_COST_TTL_AMT,0))     AS PA_CM_AMT," ).append("\n"); 
		query.append("                               NVL(SUM(B.DMDT_COM_AMT),0)             AS DMDT_COM_AMT," ).append("\n"); 
		query.append("                               NVL(SUM(B.FCNTR_STO_COM_AMT),0)        AS STO_ORG_AMT,  " ).append("\n"); 
		query.append("                               NVL(SUM(B.CNTR_STERM_RNTL_LAND_AMT),0) + " ).append("\n"); 
		query.append("                               NVL(SUM(B.CNTR_LTERM_RNTL_LAND_AMT),0) + " ).append("\n"); 
		query.append("                               NVL(SUM(B.CNTR_MNR_LAND_AMT),0)        + " ).append("\n"); 
		query.append("                               NVL(SUM(B.CNTR_DPC_LAND_AMT),0)        + " ).append("\n"); 
		query.append("                               NVL(SUM(B.CNTR_INSUR_LAND_AMT),0)      AS CNTR_ORG_AMT, " ).append("\n"); 
		query.append("                               NVL(SUM(B.CHSS_AMT),0)                 AS CHSS_ORG_AMT     " ).append("\n"); 
		query.append("                          FROM " ).append("\n"); 
		query.append("                        #if (${f_chkprd} == 'W')" ).append("\n"); 
		query.append("                               MAS_BKG_EXPN_DTL_WK B " ).append("\n"); 
		query.append("                        #else       " ).append("\n"); 
		query.append("                               MAS_BKG_EXPN_DTL B" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                         WHERE " ).append("\n"); 
		query.append("                        #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                               -- WEEK 선택시                       " ).append("\n"); 
		query.append("                               SUBSTR(SLS_YRMON,1,4)||COST_WK BETWEEN @[f_year]||@[f_fm_wk] AND @[f_year]||@[f_to_wk]" ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                               COST_YRMON BETWEEN @[f_year]||@[f_fm_mon] AND @[f_year]||@[f_to_mon]  -- MONTH선택시" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                         " ).append("\n"); 
		query.append("                        #if (${f_sc} != '')" ).append("\n"); 
		query.append("                           AND SC_NO         LIKE @[f_sc]||'%'" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        #if (${f_rfa} != '')   " ).append("\n"); 
		query.append("                           AND RFA_NO        LIKE @[f_rfa]||'%'" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        #if (${f_por} != '')   " ).append("\n"); 
		query.append("                           AND BKG_POR_CD    LIKE @[f_por]||'%'" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        #if (${f_del} != '')   " ).append("\n"); 
		query.append("                           AND BKG_DEL_CD    LIKE @[f_del]||'%'" ).append("\n"); 
		query.append("                        #end   " ).append("\n"); 
		query.append("                        #if (${f_tpsz} != '')   " ).append("\n"); 
		query.append("                           AND CNTR_TPSZ_CD  LIKE @[f_tpsz]||'%'" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                         GROUP BY " ).append("\n"); 
		query.append("                        #if (${f_chkprd} == 'W') " ).append("\n"); 
		query.append("                               B.SLS_YRMON,  -- WEEK 선택시                       " ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                               B.COST_YRMON,       -- MONTH선택시" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                               B.COST_WK," ).append("\n"); 
		query.append("                               B.BKG_NO," ).append("\n"); 
		query.append("                               B.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                               B.BKG_POR_CD," ).append("\n"); 
		query.append("                               B.BKG_DEL_CD," ).append("\n"); 
		query.append("                               B.CTRT_OFC_CD," ).append("\n"); 
		query.append("                               B.SC_NO," ).append("\n"); 
		query.append("                               B.RFA_NO" ).append("\n"); 
		query.append("                       ) A, MAS_DMDT_COST_RPT_BKG_DTL B" ).append("\n"); 
		query.append("                 WHERE A.BKG_NO       = B.BKG_NO" ).append("\n"); 
		query.append("                   AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				   AND NVL(B.DMDT_CHG_STS_CD, 'F') IN ('F', 'L', 'N', 'U', 'C', 'I')" ).append("\n"); 
		query.append("                 GROUP BY A.COST_YRMON, " ).append("\n"); 
		query.append("                       A.COST_WK," ).append("\n"); 
		query.append("                       A.BKG_NO," ).append("\n"); 
		query.append("                       B.CNTR_NO," ).append("\n"); 
		query.append("                       A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                       A.POR_CD," ).append("\n"); 
		query.append("                       A.DEL_CD," ).append("\n"); 
		query.append("                       A.CTRT_OFC_CD," ).append("\n"); 
		query.append("                       A.SC_NO," ).append("\n"); 
		query.append("                       A.RFA_NO               )" ).append("\n"); 
		query.append("         GROUP BY COST_YRMON, " ).append("\n"); 
		query.append("               COST_WK," ).append("\n"); 
		query.append("               BKG_NO," ).append("\n"); 
		query.append("               CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               CTRT_OFC_CD," ).append("\n"); 
		query.append("               SC_NO," ).append("\n"); 
		query.append("               RFA_NO" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE STATUS IN (DECODE(@[f_status],'A',0,'F',1,'U',0),DECODE(@[f_status],'A',1,'F',1,'U',0))" ).append("\n"); 
		query.append(" GROUP BY COST_YRMON, " ).append("\n"); 
		query.append("       COST_WK," ).append("\n"); 
		query.append("       CTRT_OFC_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       SC_NO," ).append("\n"); 
		query.append("       RFA_NO," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD," ).append("\n"); 
		query.append("       DECODE(STATUS,1,'Finish','Unfinish')" ).append("\n"); 
		query.append("ORDER BY COST_YRMON," ).append("\n"); 
		query.append("		 COST_WK," ).append("\n"); 
		query.append("         CTRT_OFC_CD," ).append("\n"); 
		query.append("         POR_CD," ).append("\n"); 
		query.append("         DEL_CD," ).append("\n"); 
		query.append("         SC_NO," ).append("\n"); 
		query.append("         RFA_NO," ).append("\n"); 
		query.append("         CNTR_TPSZ_CD," ).append("\n"); 
		query.append("         STATUS" ).append("\n"); 

	}
}