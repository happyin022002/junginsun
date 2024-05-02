/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AgencyCommissionDBDAOCoaOtrCommVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.04
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2011.03.04 전윤주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yun-ju Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgencyCommissionDBDAOCoaOtrCommVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA_OTR_COMM  테이블의 데이터 삽입
	  * </pre>
	  */
	public AgencyCommissionDBDAOCoaOtrCommVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_comm_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.integration").append("\n"); 
		query.append("FileName : AgencyCommissionDBDAOCoaOtrCommVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_OTR_COMM B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.COST_YRMON = @[cost_yrmon]						" ).append("\n"); 
		query.append("	 AND B1.CNTR_TPSZ_CD = @[cntr_tpsz_cd]						" ).append("\n"); 
		query.append("	 AND B1.COMM_LOC_CD = @[comm_loc_cd]" ).append("\n"); 
		query.append("     AND B1.COA_COST_SRC_CD = @[coa_cost_src_cd])	" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET OTR_COMM_TTL_AMT = @[otr_comm_ttl_amt]" ).append("\n"); 
		query.append("           ,BKG_TTL_QTY = @[bkg_ttl_qty] " ).append("\n"); 
		query.append("           ,STND_COST_USD_AMT = @[stnd_cost_usd_amt] " ).append("\n"); 
		query.append("           ,UPD_USR_ID = @[cre_usr_id] " ).append("\n"); 
		query.append("           ,UPD_DT = SYSDATE    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT  (" ).append("\n"); 
		query.append("			 COST_YRMON" ).append("\n"); 
		query.append("			,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,COMM_LOC_CD" ).append("\n"); 
		query.append("			,COA_COST_SRC_CD " ).append("\n"); 
		query.append("            ,STND_COST_USD_AMT" ).append("\n"); 
		query.append("			,BKG_TTL_QTY" ).append("\n"); 
		query.append("			,OTR_COMM_TTL_AMT " ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("			,CRE_DT" ).append("\n"); 
		query.append("			,UPD_USR_ID" ).append("\n"); 
		query.append("			,UPD_DT" ).append("\n"); 
		query.append("			 )VALUES(" ).append("\n"); 
		query.append("					 @[cost_yrmon]" ).append("\n"); 
		query.append("       				,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("       				,@[comm_loc_cd]" ).append("\n"); 
		query.append("      				,@[coa_cost_src_cd]" ).append("\n"); 
		query.append("       				,@[stnd_cost_usd_amt]" ).append("\n"); 
		query.append("      				,@[bkg_ttl_qty]" ).append("\n"); 
		query.append("     				,@[otr_comm_ttl_amt]" ).append("\n"); 
		query.append("      				,@[cre_usr_id]" ).append("\n"); 
		query.append("      				,SYSDATE" ).append("\n"); 
		query.append("      				,@[cre_usr_id]" ).append("\n"); 
		query.append("      				,SYSDATE)" ).append("\n"); 

	}
}