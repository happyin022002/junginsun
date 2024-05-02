/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOEqRepoCostVO02CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOEqRepoCostVO02CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20141002.SJH : COA_FULL_SCC_IMBAL 테이블의 데이터 삽입
	  * </pre>
	  */
	public MTCostDBDAOEqRepoCostVO02CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mty_cost_mod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOEqRepoCostVO02CSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MTY_COST_HIS B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	 AND B1.SCC_CD             = @[scc_cd]" ).append("\n"); 
		query.append("     AND B1.COST_SRC_FM_YRMON  = @[cost_src_fm_yrmon]" ).append("\n"); 
		query.append("     AND B1.COST_SRC_TO_YRMON  = @[cost_src_to_yrmon]" ).append("\n"); 
		query.append("     AND ORG_NOD_CD            = @[org_nod_cd]" ).append("\n"); 
		query.append("     AND DEST_NOD_CD           = @[dest_nod_cd]" ).append("\n"); 
		query.append("     AND TRSP_MTY_COST_MOD_NM  = @[trsp_mty_cost_mod_nm]) 		--SJH.20141127.MOD : MOVE, CD->NM" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET MTY_QTY       			= @[mty_qty]" ).append("\n"); 
		query.append("            ,MTY_UT_AMT       		= @[mty_ut_amt]" ).append("\n"); 
		query.append("            ,UPD_USR_ID        		= @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT            		= SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			 ,SCC_CD" ).append("\n"); 
		query.append("			 ,COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("			 ,COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("			 ,ORG_NOD_CD" ).append("\n"); 
		query.append("			 ,DEST_NOD_CD" ).append("\n"); 
		query.append("             ,TRSP_MTY_COST_MOD_NM	--SJH.20141127.MOD : CD->NM" ).append("\n"); 
		query.append("			 ,MTY_QTY			 " ).append("\n"); 
		query.append("			 ,MTY_UT_AMT             " ).append("\n"); 
		query.append("             ,CRE_USR_ID" ).append("\n"); 
		query.append("             ,CRE_DT" ).append("\n"); 
		query.append("             ,UPD_USR_ID" ).append("\n"); 
		query.append("             ,UPD_DT" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("      VALUES (@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("             ,@[scc_cd]" ).append("\n"); 
		query.append("             ,@[cost_src_fm_yrmon]" ).append("\n"); 
		query.append("             ,@[cost_src_to_yrmon]" ).append("\n"); 
		query.append("             ,@[org_nod_cd]" ).append("\n"); 
		query.append("			 ,@[dest_nod_cd]" ).append("\n"); 
		query.append("			 ,@[trsp_mty_cost_mod_nm]	--SJH.20141127.MOD : CD->NM" ).append("\n"); 
		query.append("             ,@[mty_qty]			 " ).append("\n"); 
		query.append("			 ,@[mty_ut_amt]" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}