/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CostSetUpDBDAOSearchCostSetUpListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchCostSetUpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CostSetUpDBDAOSearchCostSetUpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOSearchCostSetUpListRSQL").append("\n"); 
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
		query.append("       --DECODE(A.COST_YRMON,NULL,'I','R') IBFLAG," ).append("\n"); 
		query.append("       B.cd itm_cd,B.nm itm_nm,b.srt," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'TPS',OTR_EXPN_AMT)),0) TPS_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'AES',OTR_EXPN_AMT)),0) AES_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'TAS',OTR_EXPN_AMT)),0) TAS_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'IAS',OTR_EXPN_AMT)),0) IAS_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'EMS',OTR_EXPN_AMT)),0) EMS_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'COM',OTR_EXPN_AMT)),0) COM_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'TPS',OTR_EXPN_AMT)),0) TPS_OLD_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'AES',OTR_EXPN_AMT)),0) AES_OLD_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'TAS',OTR_EXPN_AMT)),0) TAS_OLD_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'IAS',OTR_EXPN_AMT)),0) IAS_OLD_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'EMS',OTR_EXPN_AMT)),0) EMS_OLD_AMT," ).append("\n"); 
		query.append("       NVL(SUM(DECODE(A.TRD_CD,'COM',OTR_EXPN_AMT)),0) COM_OLD_AMT" ).append("\n"); 
		query.append("FROM MAS_MNL_COST_STUP A," ).append("\n"); 
		query.append("     (SELECT 'CNTMR' cd,'Vessel Market Rate' nm ,1 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'CNTTS' cd,'Deferred Expense'   nm ,2 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'CDMCO' cd,'Vessel Charter'     nm ,3 srt from dual union all" ).append("\n"); 
		query.append("      SELECT 'CNTLY' cd,'Lay Up Expense'     nm ,4 srt from dual" ).append("\n"); 
		query.append("     ) b" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_yrtype} == 'yrmon')" ).append("\n"); 
		query.append("  AND A.COST_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND A.COST_YRMON(+) LIKE SUBSTR(@[f_cost_yrmon],1,4)||'%'" ).append("\n"); 
		query.append("  AND A.COST_WK(+)    = SUBSTR(@[f_cost_yrmon],5,2)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND A.RLANE_CD(+)   = B.CD   " ).append("\n"); 
		query.append(" GROUP BY --DECODE(A.COST_YRMON,NULL,'I','R')," ).append("\n"); 
		query.append("           B.cd,B.nm,b.srt" ).append("\n"); 
		query.append("order by srt" ).append("\n"); 

	}
}