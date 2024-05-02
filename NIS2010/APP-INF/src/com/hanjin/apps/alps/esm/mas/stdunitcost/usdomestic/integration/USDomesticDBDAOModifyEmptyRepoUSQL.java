/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : USDomesticDBDAOModifyEmptyRepoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.19
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2012.11.19 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Song HoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOModifyEmptyRepoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyEmptyRepo
	  * </pre>
	  */
	public USDomesticDBDAOModifyEmptyRepoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sim_mty_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rail_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOModifyEmptyRepoUSQL").append("\n"); 
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
		query.append("UPDATE MAS_USA_DMST_UT_COST" ).append("\n"); 
		query.append("   SET SIM_MTY_UC_AMT = REPLACE(@[sim_mty_uc_amt], ',', '')" ).append("\n"); 
		query.append("	 , UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COST_YRMON       = REPLACE(@[cost_yrmon], '-', '')" ).append("\n"); 
		query.append("   AND ORG_RAIL_LOC_CD  = @[org_rail_loc_cd]" ).append("\n"); 
		query.append("   AND COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}