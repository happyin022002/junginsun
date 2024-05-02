/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : USDomesticDBDAOModifyEmptyRepoCreditUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USDomesticDBDAOModifyEmptyRepoCreditUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 변경된 Empty Repo Credit Value 를 Update 한다.
	  * 2013.05.31 김수정 [CHM-201324859] MAS Domestic Saving Credit 보완
	  * </pre>
	  */
	public USDomesticDBDAOModifyEmptyRepoCreditUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_dmst_sav_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trp_sav_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_offh_fnl_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trp_cr_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_offh_sav_amt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_offh_sav_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.usdomestic.integration").append("\n"); 
		query.append("FileName : USDomesticDBDAOModifyEmptyRepoCreditUSQL").append("\n"); 
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
		query.append("   SET SIM_MTY_UC_AMT      = REPLACE(@[sim_mty_uc_amt], ',', '')" ).append("\n"); 
		query.append("     , USA_DMST_SAV_UT_AMT = REPLACE(@[usa_dmst_sav_ut_amt], ',', '')" ).append("\n"); 
		query.append("     , EQ_OFFH_SAV_AMT     = REPLACE(@[eq_offh_sav_amt], ',', '')" ).append("\n"); 
		query.append("     , EQ_OFFH_SAV_UC_AMT  = REPLACE(@[eq_offh_sav_uc_amt], ',', '')" ).append("\n"); 
		query.append("     , EQ_OFFH_FNL_UC_AMT  = REPLACE(@[eq_offh_fnl_uc_amt], ',', '')" ).append("\n"); 
		query.append("     , TRP_SAV_AMT         = REPLACE(@[trp_sav_amt], ',', '')" ).append("\n"); 
		query.append("     , TRP_CR_UC_AMT       = REPLACE(@[trp_cr_uc_amt], ',', '')" ).append("\n"); 
		query.append("	 , UPD_USR_ID          = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT              = SYSDATE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND COST_YRMON       = REPLACE(@[cost_yrmon], '-', '')" ).append("\n"); 
		query.append("   AND ORG_RAIL_LOC_CD  = @[org_rail_loc_cd]" ).append("\n"); 
		query.append("   AND COST_LOC_GRP_CD  = 'E'" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 

	}
}