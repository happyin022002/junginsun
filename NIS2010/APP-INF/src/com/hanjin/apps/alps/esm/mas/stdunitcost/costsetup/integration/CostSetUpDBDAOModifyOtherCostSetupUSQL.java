/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CostSetUpDBDAOModifyOtherCostSetupUSQL.java
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

public class CostSetUpDBDAOModifyOtherCostSetupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CostSetUpDBDAOModifyOtherCostSetupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_expn_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.costsetup.integration").append("\n"); 
		query.append("FileName : CostSetUpDBDAOModifyOtherCostSetupUSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_MNL_COST_STUP A" ).append("\n"); 
		query.append(" USING (" ).append("\n"); 
		query.append("         SELECT SUBSTR('${cost_yrwk}',1,4) cost_yr," ).append("\n"); 
		query.append("                SUBSTR('${cost_yrwk}',5,2) cost_wk," ).append("\n"); 
		query.append("                @[trd_cd] TRD_CD," ).append("\n"); 
		query.append("                @[rlane_cd] RLANE_CD," ).append("\n"); 
		query.append("                (SELECT COST_YR||EQ_WK FROM MAS_WK_PRD WHERE COST_YR = SUBSTR('${cost_yrwk}',1,4) AND COST_WK  = SUBSTR('${cost_yrwk}',5,2)) AS COST_YRMON" ).append("\n"); 
		query.append("           FROM DUAL) B" ).append("\n"); 
		query.append("   ON (    A.COST_YRMON LIKE B.COST_YR||'%'" ).append("\n"); 
		query.append("       AND A.COST_WK = B.COST_WK" ).append("\n"); 
		query.append("       AND A.TRD_CD  = B.TRD_CD" ).append("\n"); 
		query.append("       AND A.RLANE_CD = B.RLANE_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("        SET OTR_EXPN_AMT = @[otr_expn_amt]," ).append("\n"); 
		query.append("            UPD_USR_ID   = '${usr_id}'," ).append("\n"); 
		query.append("            UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("    ( COST_YRMON,COST_WK,TRD_CD,RLANE_CD,IOC_CD,DIR_CD,SUB_TRD_CD,OTR_EXPN_AMT," ).append("\n"); 
		query.append("      CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("   VALUES (B.COST_YRMON," ).append("\n"); 
		query.append("           SUBSTR('${cost_yrwk}',5,2)," ).append("\n"); 
		query.append("           @[trd_cd]," ).append("\n"); 
		query.append("           @[rlane_cd]," ).append("\n"); 
		query.append("           'O'," ).append("\n"); 
		query.append("           'M'," ).append("\n"); 
		query.append("           'OT'," ).append("\n"); 
		query.append("           @[otr_expn_amt]," ).append("\n"); 
		query.append("           '${usr_id}'," ).append("\n"); 
		query.append("           sysdate," ).append("\n"); 
		query.append("           '${usr_id}'," ).append("\n"); 
		query.append("           sysdate" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}