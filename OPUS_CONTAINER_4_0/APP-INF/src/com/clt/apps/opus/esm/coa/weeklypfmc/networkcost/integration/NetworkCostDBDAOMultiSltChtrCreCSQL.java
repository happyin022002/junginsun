/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : NetworkCostDBDAOMultiSltChtrCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.19 
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

public class NetworkCostDBDAOMultiSltChtrCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiSltChtrCre INSERT
	  * </pre>
	  */
	public NetworkCostDBDAOMultiSltChtrCreCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incm_crs_chtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_crs_chtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_sub_chtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_slct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incm_bzc_chtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("incm_sub_lse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expn_bzc_chtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vop_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiSltChtrCreCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_SLT_CHTR_INFO (" ).append("\n"); 
		query.append("     SLT_TP_CD" ).append("\n"); 
		query.append("   , VOP_CD" ).append("\n"); 
		query.append("   , INCM_BZC_CHTR_CD" ).append("\n"); 
		query.append("   , INCM_SUB_LSE_CD" ).append("\n"); 
		query.append("   , INCM_CRS_CHTR_CD" ).append("\n"); 
		query.append("   , EXPN_BZC_CHTR_CD" ).append("\n"); 
		query.append("   , EXPN_SUB_CHTR_CD" ).append("\n"); 
		query.append("   , EXPN_CRS_CHTR_CD" ).append("\n"); 
		query.append("   , OP_CRE_STS_CD" ).append("\n"); 
		query.append("   , CRE_SLCT_FLG" ).append("\n"); 
		query.append("   , CRE_USR_ID" ).append("\n"); 
		query.append("   , CRE_DT" ).append("\n"); 
		query.append("   , UPD_USR_ID" ).append("\n"); 
		query.append("   , UPD_DT" ).append("\n"); 
		query.append("   , STND_COST_CD" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("     @[slt_tp_cd]" ).append("\n"); 
		query.append("   , @[vop_cd]" ).append("\n"); 
		query.append("   , @[incm_bzc_chtr_cd]" ).append("\n"); 
		query.append("   , @[incm_sub_lse_cd]" ).append("\n"); 
		query.append("   , @[incm_crs_chtr_cd]" ).append("\n"); 
		query.append("   , @[expn_bzc_chtr_cd]" ).append("\n"); 
		query.append("   , @[expn_sub_chtr_cd]" ).append("\n"); 
		query.append("   , @[expn_crs_chtr_cd]" ).append("\n"); 
		query.append("   , 'R'" ).append("\n"); 
		query.append("   , @[cre_slct_flg]" ).append("\n"); 
		query.append("   , @[cre_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[upd_usr_id]" ).append("\n"); 
		query.append("   , SYSDATE" ).append("\n"); 
		query.append("   , @[stnd_cost_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}