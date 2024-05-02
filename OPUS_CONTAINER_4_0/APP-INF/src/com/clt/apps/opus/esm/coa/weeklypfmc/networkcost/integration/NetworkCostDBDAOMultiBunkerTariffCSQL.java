/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOMultiBunkerTariffCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiBunkerTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiBunkerTariff INSERT
	  * </pre>
	  */
	public NetworkCostDBDAOMultiBunkerTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiBunkerTariffCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_BNK_TRF A" ).append("\n"); 
		query.append(" USING (" ).append("\n"); 
		query.append("       SELECT " ).append("\n"); 
		query.append("           @[cost_yrmon]    AS COST_YRMON" ).append("\n"); 
		query.append("          ,@[slan_cd]       AS SLAN_CD" ).append("\n"); 
		query.append("          ,@[rlane_cd]      AS RLANE_CD" ).append("\n"); 
		query.append("          ,@[slan_dir_cd]   AS SLAN_DIR_CD" ).append("\n"); 
		query.append("          ,@[vsl_clss_capa] AS VSL_CLSS_CAPA		--20150527.MOD" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append(" ON (" ).append("\n"); 
		query.append("         A.COST_YRMON    = B.COST_YRMON" ).append("\n"); 
		query.append("     AND A.SLAN_CD       = B.SLAN_CD" ).append("\n"); 
		query.append("     AND A.RLANE_CD      = B.RLANE_CD" ).append("\n"); 
		query.append("     AND A.SLAN_DIR_CD   = B.SLAN_DIR_CD" ).append("\n"); 
		query.append("     AND A.VSL_CLSS_CAPA = B.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET  FOIL_CSM      = @[foil_csm]" ).append("\n"); 
		query.append("             ,FOIL_UC_AMT   = @[foil_uc_amt]" ).append("\n"); 
		query.append("             ,DOIL_CSM      = @[doil_csm]" ).append("\n"); 
		query.append("             ,DOIL_UC_AMT   = @[doil_uc_amt]" ).append("\n"); 
		query.append("             ,UPD_USR_ID    = @[upd_usr_id]" ).append("\n"); 
		query.append("             ,UPD_DT        = SYSDATE" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT(" ).append("\n"); 
		query.append("             COST_YRMON" ).append("\n"); 
		query.append("            ,SLAN_CD" ).append("\n"); 
		query.append("            ,RLANE_CD" ).append("\n"); 
		query.append("            ,SLAN_DIR_CD" ).append("\n"); 
		query.append("            ,VSL_CLSS_CAPA" ).append("\n"); 
		query.append("            ,FOIL_CSM" ).append("\n"); 
		query.append("            ,FOIL_UC_AMT" ).append("\n"); 
		query.append("            ,DOIL_CSM" ).append("\n"); 
		query.append("            ,DOIL_UC_AMT" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("      )VALUES(" ).append("\n"); 
		query.append("             @[cost_yrmon]" ).append("\n"); 
		query.append("            ,@[slan_cd]" ).append("\n"); 
		query.append("            ,@[rlane_cd]" ).append("\n"); 
		query.append("            ,@[slan_dir_cd]" ).append("\n"); 
		query.append("            ,@[vsl_clss_capa]					--20150527.MOD" ).append("\n"); 
		query.append("            ,@[foil_csm]" ).append("\n"); 
		query.append("            ,@[foil_uc_amt]" ).append("\n"); 
		query.append("            ,@[doil_csm]" ).append("\n"); 
		query.append("            ,@[doil_uc_amt]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}