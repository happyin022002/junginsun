/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApplicationDateRuleDBDAOaddLocationInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.27 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ApplicationDateRuleDBDAOaddLocationInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route Locaiton conversion에 데이터를 삽입한다.
	  * </pre>
	  */
	public ApplicationDateRuleDBDAOaddLocationInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_rly_port_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_appl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration").append("\n"); 
		query.append("FileName : ApplicationDateRuleDBDAOaddLocationInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_ROUT_LOC_CONV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SVC_SCP_CD," ).append("\n"); 
		query.append("ORG_LOC_CD," ).append("\n"); 
		query.append("CONV_LOC_CD," ).append("\n"); 
		query.append("POR_APPL_FLG," ).append("\n"); 
		query.append("POL_APPL_FLG," ).append("\n"); 
		query.append("POD_APPL_FLG," ).append("\n"); 
		query.append("DEL_APPL_FLG," ).append("\n"); 
		query.append("PRE_RLY_PORT_APPL_FLG," ).append("\n"); 
		query.append("PST_RLY_PORT_APPL_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID, " ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[svc_scp_cd]," ).append("\n"); 
		query.append("@[org_loc_cd]," ).append("\n"); 
		query.append("@[conv_loc_cd]," ).append("\n"); 
		query.append("DECODE(@[por_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("DECODE(@[pol_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("DECODE(@[pod_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("DECODE(@[del_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("DECODE(@[pre_rly_port_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("DECODE(@[pst_rly_port_appl_flg], '1','Y','0','N')," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}