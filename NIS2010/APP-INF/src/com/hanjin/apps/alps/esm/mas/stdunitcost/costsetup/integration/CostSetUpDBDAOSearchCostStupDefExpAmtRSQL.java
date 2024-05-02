/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOSearchCostStupDefExpAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.10.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Min CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostSetUpDBDAOSearchCostStupDefExpAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CostSetUpDBDAOSearchCostStupDefExpAmtRSQL(){
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
		query.append("FileName : CostSetUpDBDAOSearchCostStupDefExpAmtRSQL").append("\n"); 
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
		query.append("select itm_nm," ).append("\n"); 
		query.append("       trim(to_char(TPS_AMT,'$99,999,999,999.99')) TPS_AMT," ).append("\n"); 
		query.append("       trim(to_char(AES_AMT,'$99,999,999,999.99')) AES_AMT," ).append("\n"); 
		query.append("       trim(to_char(TAS_AMT,'$99,999,999,999.99')) TAS_AMT," ).append("\n"); 
		query.append("       trim(to_char(IAS_AMT,'$99,999,999,999.99')) IAS_AMT," ).append("\n"); 
		query.append("       trim(to_char(EMS_AMT,'$99,999,999,999.99')) EMS_AMT," ).append("\n"); 
		query.append("       trim(to_char(COM_AMT,'$99,999,999,999.99')) COM_AMT," ).append("\n"); 
		query.append("       trim(to_char(TTL_AMT,'$99,999,999,999.99')) TTL_AMT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append(" from ( " ).append("\n"); 
		query.append("    SELECT A.COST_YRMON as itm_Nm," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'TPS',OTR_EXPN_AMT)),0),2) TPS_AMT," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'AES',OTR_EXPN_AMT)),0),2) AES_AMT," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'TAS',OTR_EXPN_AMT)),0),2) TAS_AMT," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'IAS',OTR_EXPN_AMT)),0),2) IAS_AMT," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'EMS',OTR_EXPN_AMT)),0),2) EMS_AMT," ).append("\n"); 
		query.append("           round(NVL(SUM(DECODE(A.TRD_CD,'COM',OTR_EXPN_AMT)),0),2) COM_AMT," ).append("\n"); 
		query.append("ROUND(NVL(SUM(OTR_EXPN_AMT),0),2) TTL_AMT" ).append("\n"); 
		query.append("    FROM MAS_MNL_COST_STUP A" ).append("\n"); 
		query.append("    WHERE A.COST_YRMON = (select cost_yr||EQ_WK from mas_wk_prd  where cost_yr = SUBSTR(@[f_cost_yrmon],1,4) and cost_wk =  SUBSTR(@[f_cost_yrmon],5,2))" ).append("\n"); 
		query.append("      AND A.COST_WK    = 'XX'" ).append("\n"); 
		query.append("      AND a.rlane_cd = 'CNTTS'" ).append("\n"); 
		query.append("    group by A.COST_YRMON" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}