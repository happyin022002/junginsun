/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveQueueMdmCommodityDBDAOAddMdmCommodityCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCommodityDBDAOAddMdmCommodityCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JMS에서 받은 데이터 DB Logic 처리를 담당한다.(추가)
	  * </pre>
	  */
	public ReceiveQueueMdmCommodityDBDAOAddMdmCommodityCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fmc_exp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chem_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCommodityDBDAOAddMdmCommodityCSQL").append("\n"); 
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
		query.append("INSERT INTO mdm_commodity (" ).append("\n"); 
		query.append("    cmdt_cd        ," ).append("\n"); 
		query.append("    cmdt_nm        ," ).append("\n"); 
		query.append("    grp_cmdt_cd    ," ).append("\n"); 
		query.append("    rep_cmdt_cd    ," ).append("\n"); 
		query.append("    rep_imdg_lvl_cd," ).append("\n"); 
		query.append("    cre_usr_id     ," ).append("\n"); 
		query.append("    cre_dt         ," ).append("\n"); 
		query.append("    upd_usr_id     ," ).append("\n"); 
		query.append("    upd_dt         ," ).append("\n"); 
		query.append("    delt_flg       ," ).append("\n"); 
		query.append("    eai_evnt_dt    ," ).append("\n"); 
		query.append("    fmc_exp_flg    ," ).append("\n"); 
		query.append("    eai_if_id      ," ).append("\n"); 
		query.append("    chem_flg" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[cmdt_cd]        ," ).append("\n"); 
		query.append("    @[cmdt_nm]        ," ).append("\n"); 
		query.append("    @[grp_cmdt_cd]    ," ).append("\n"); 
		query.append("    @[rep_cmdt_cd]    ," ).append("\n"); 
		query.append("    @[rep_imdg_lvl_cd]," ).append("\n"); 
		query.append("    @[cre_usr_id]     ," ).append("\n"); 
		query.append("    TO_DATE(@[cre_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[upd_usr_id]     ," ).append("\n"); 
		query.append("    TO_DATE(@[upd_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[delt_flg]       ," ).append("\n"); 
		query.append("    TO_DATE(@[eai_evnt_dt], 'yyyymmddhh24miss')," ).append("\n"); 
		query.append("    @[fmc_exp_flg]," ).append("\n"); 
		query.append("    @[eai_if_id]," ).append("\n"); 
		query.append("    @[chem_flg]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}