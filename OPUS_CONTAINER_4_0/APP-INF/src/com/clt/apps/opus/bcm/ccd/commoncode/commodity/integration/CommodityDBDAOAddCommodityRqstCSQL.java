/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommodityDBDAOAddCommodityRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommodityDBDAOAddCommodityRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Request Commodity 정보를 생성한다.
	  * </pre>
	  */
	public CommodityDBDAOAddCommodityRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eu_xpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_imdg_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmc_exp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.commodity.integration").append("\n"); 
		query.append("FileName : CommodityDBDAOAddCommodityRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CMDT_RQST ( " ).append("\n"); 
		query.append("	   RQST_NO" ).append("\n"); 
		query.append("      ,CMDT_CD" ).append("\n"); 
		query.append("      ,CMDT_NM" ).append("\n"); 
		query.append("      ,REP_IMDG_LVL_CD" ).append("\n"); 
		query.append("      ,REP_CMDT_CD" ).append("\n"); 
		query.append("      ,GRP_CMDT_CD" ).append("\n"); 
		query.append("      ,FMC_EXP_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,EU_XPT_FLG" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	    @[rqst_no]" ).append("\n"); 
		query.append("	   ,@[cmdt_cd]" ).append("\n"); 
		query.append("       ,@[cmdt_nm]" ).append("\n"); 
		query.append("       ,@[rep_imdg_lvl_cd]" ).append("\n"); 
		query.append("       ,@[rep_cmdt_cd]" ).append("\n"); 
		query.append("       ,@[grp_cmdt_cd]" ).append("\n"); 
		query.append("       ,@[fmc_exp_flg]" ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate     " ).append("\n"); 
		query.append("       ,@[cre_usr_id]" ).append("\n"); 
		query.append("       ,sysdate" ).append("\n"); 
		query.append("       ,@[delt_flg]" ).append("\n"); 
		query.append("       ,@[eu_xpt_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}