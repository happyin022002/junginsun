/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EstimationReportDBDAObudgetSmryByMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2013.05.31 서관영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Seo Kwan Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationReportDBDAObudgetSmryByMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사업계획에 따른 Month 별 Report
	  * </pre>
	  */
	public EstimationReportDBDAObudgetSmryByMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration ").append("\n"); 
		query.append("FileName : EstimationReportDBDAObudgetSmryByMonthRSQL").append("\n"); 
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
		query.append(" SELECT" ).append("\n"); 
		query.append("   REV_YRMON," ).append("\n"); 
		query.append("   SUM(VVD_CNT)     VVD_CNT," ).append("\n"); 
		query.append("   SUM(PORT_CNT)    PORT_CNT," ).append("\n"); 
		query.append("   SUM(PORT_CHARGE) PORT_CHARGE," ).append("\n"); 
		query.append("   SUM(CANAL_CNT)   CANAL_CNT," ).append("\n"); 
		query.append("   SUM(CANAL_FEE)   CANAL_FEE," ).append("\n"); 
		query.append("   SUM(PORT_CHARGE) + SUM(CANAL_FEE) TOTAL_CHARGE" ).append("\n"); 
		query.append(" FROM  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("          REV_YRMON," ).append("\n"); 
		query.append("          RLANE_CD," ).append("\n"); 
		query.append("          VSL_CD," ).append("\n"); 
		query.append("          SKD_VOY_NO," ).append("\n"); 
		query.append("          SKD_DIR_CD," ).append("\n"); 
		query.append("          COUNT(*) OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD) VVD_CNT," ).append("\n"); 
		query.append("          SUM(DECODE(PORT_CHARGE,0,0,1)) PORT_CNT," ).append("\n"); 
		query.append("          SUM(DECODE(CANAL_FEE,0,0,1))   CANAL_CNT," ).append("\n"); 
		query.append("          SUM(PORT_CHARGE)  PORT_CHARGE," ).append("\n"); 
		query.append("          SUM(CANAL_FEE)    CANAL_FEE" ).append("\n"); 
		query.append("     FROM      " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT REV_YRMON," ).append("\n"); 
		query.append("               RLANE_CD," ).append("\n"); 
		query.append("               VSL_CD," ).append("\n"); 
		query.append("               SKD_VOY_NO," ).append("\n"); 
		query.append("               SKD_DIR_CD," ).append("\n"); 
		query.append("               YD_CD," ).append("\n"); 
		query.append("               SUM(DECODE(ACCT_CD, 511911, 0, INV_USD_AMT)) PORT_CHARGE," ).append("\n"); 
		query.append("               SUM(DECODE(ACCT_CD, 511911, INV_USD_AMT, 0)) CANAL_FEE" ).append("\n"); 
		query.append("        FROM   PSO_TGT_YD_EXPN T1, TES_LGS_COST T2" ).append("\n"); 
		query.append("        WHERE  1=1" ).append("\n"); 
		query.append("        AND    T1.PSO_BZTP_CD='1'" ).append("\n"); 
		query.append("        AND    T1.BUD_SCNR_NO=@[scn_dt]||@[scn_cd]" ).append("\n"); 
		query.append("        AND    T1.REV_YRMON  BETWEEN REPLACE(@[start_dt],'-','') AND REPLACE(@[end_dt],'-','')" ).append("\n"); 
		query.append("        AND    T1.LGS_COST_CD=T2.LGS_COST_CD" ).append("\n"); 
		query.append("        GROUP BY REV_YRMON,RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("        ORDER BY REV_YRMON,RLANE_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, YD_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       GROUP BY REV_YRMON,RLANE_CD,VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("       ORDER BY REV_YRMON,RLANE_CD,VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("   ) " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   GROUP BY REV_YRMON" ).append("\n"); 

	}
}