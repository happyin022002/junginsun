/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DVFactorMgtDBDAOmodifyDVFactorDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DVFactorMgtDBDAOmodifyDVFactorDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public DVFactorMgtDBDAOmodifyDVFactorDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_init_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_mtrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_dpc_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_dpc_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_dpc_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.integration").append("\n"); 
		query.append("FileName : DVFactorMgtDBDAOmodifyDVFactorDataUSQL").append("\n"); 
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
		query.append("MERGE INTO MNR_EQ_DPC A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON (EQ_DPC_YR = @[eq_dpc_yr]" ).append("\n"); 
		query.append("       AND EQ_TPSZ_CD = @[cd_id]" ).append("\n"); 
		query.append("       AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE" ).append("\n"); 
		query.append("         SET CURR_CD = @[curr_cd]," ).append("\n"); 
		query.append("             EQ_INIT_PRC = @[eq_init_prc]," ).append("\n"); 
		query.append("             EQ_DPC_RT = @[eq_dpc_rt]," ).append("\n"); 
		query.append("             EQ_MTRL_CD = @[eq_mtrl_cd]," ).append("\n"); 
		query.append("             MAX_DPC_RTO = @[max_dpc_rto]," ).append("\n"); 
		query.append("             UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("             UPD_DT = SYSDATE " ).append("\n"); 
		query.append("       WHERE EQ_DPC_YR = @[eq_dpc_yr]" ).append("\n"); 
		query.append("         AND EQ_TPSZ_CD = @[cd_id]" ).append("\n"); 
		query.append("         AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("      INSERT (" ).append("\n"); 
		query.append("        	 EQ_DPC_YR," ).append("\n"); 
		query.append("        	 EQ_TPSZ_CD," ).append("\n"); 
		query.append("        	 EQ_KND_CD," ).append("\n"); 
		query.append("             CURR_CD," ).append("\n"); 
		query.append("        	 EQ_INIT_PRC," ).append("\n"); 
		query.append("        	 EQ_DPC_RT," ).append("\n"); 
		query.append("             EQ_MTRL_CD," ).append("\n"); 
		query.append("             MAX_DPC_RTO," ).append("\n"); 
		query.append("        	 CRE_USR_ID," ).append("\n"); 
		query.append("        	 CRE_DT," ).append("\n"); 
		query.append("        	 UPD_USR_ID," ).append("\n"); 
		query.append("        	 UPD_DT" ).append("\n"); 
		query.append("            ) VALUES( " ).append("\n"); 
		query.append("        	 @[eq_dpc_yr]," ).append("\n"); 
		query.append("        	 @[cd_id]," ).append("\n"); 
		query.append("        	 @[eq_knd_cd]," ).append("\n"); 
		query.append("             @[curr_cd]," ).append("\n"); 
		query.append("        	 @[eq_init_prc]," ).append("\n"); 
		query.append("        	 @[eq_dpc_rt]," ).append("\n"); 
		query.append("             @[eq_mtrl_cd]," ).append("\n"); 
		query.append("             @[max_dpc_rto]," ).append("\n"); 
		query.append("        	 @[cre_usr_id]," ).append("\n"); 
		query.append("        	 SYSDATE," ).append("\n"); 
		query.append("        	 @[upd_usr_id]," ).append("\n"); 
		query.append("        	 SYSDATE" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}