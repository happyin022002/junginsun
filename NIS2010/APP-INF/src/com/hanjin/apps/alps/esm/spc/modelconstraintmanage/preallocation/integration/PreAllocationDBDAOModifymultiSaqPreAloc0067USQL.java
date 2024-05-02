/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreAllocationDBDAOModifymultiSaqPreAloc0067USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.01.21 주선영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreAllocationDBDAOModifymultiSaqPreAloc0067USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pre-allocation update
	  * </pre>
	  */
	public PreAllocationDBDAOModifymultiSaqPreAloc0067USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bse_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_aloc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.preallocation.integration").append("\n"); 
		query.append("FileName : PreAllocationDBDAOModifymultiSaqPreAloc0067USQL").append("\n"); 
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
		query.append("UPDATE  SAQ_PRE_ALOC SET" ).append("\n"); 
		query.append("BSE_YR = @[bse_yr]," ).append("\n"); 
		query.append("BSE_MON = @[bse_mon]," ).append("\n"); 
		query.append("RLANE_CD = @[rlane_cd]," ).append("\n"); 
		query.append("DIR_CD = @[dir_cd]," ).append("\n"); 
		query.append("VSL_CLSS_CAPA = @[vsl_clss_capa]," ).append("\n"); 
		query.append("PORT_CD = @[port_cd]," ).append("\n"); 
		query.append("TO_TRD_CD = @[to_trd_cd]," ).append("\n"); 
		query.append("TO_DIR_CD = @[to_dir_cd]," ).append("\n"); 
		query.append("REP_TRD_CD = @[rep_trd_cd]," ).append("\n"); 
		query.append("SPC_ALOC_QTY = @[spc_aloc_qty]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  BSE_YR = @[bse_yr]" ).append("\n"); 
		query.append("AND   BSE_MON = @[bse_mon]" ).append("\n"); 
		query.append("AND   RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND   DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("AND   VSL_CLSS_CAPA = @[vsl_clss_capa]" ).append("\n"); 
		query.append("AND   PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND   TO_TRD_CD = @[to_trd_cd]" ).append("\n"); 
		query.append("AND   TO_DIR_CD = @[to_dir_cd]" ).append("\n"); 

	}
}