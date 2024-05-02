/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOMulti01SingleTransportationSOManageCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOMulti01SingleTransportationSOManageCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQR_REPO_EXE_SO_IF INSERT
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOMulti01SingleTransportationSOManageCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_pln_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("repo_purp_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_rqst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_if_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOMulti01SingleTransportationSOManageCSQL").append("\n"); 
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
		query.append("INSERT INTO EQR_REPO_EXE_SO_IF(" ).append("\n"); 
		query.append("			 REPO_PLN_ID" ).append("\n"); 
		query.append("			,PLN_YRWK" ).append("\n"); 
		query.append("			,PLN_SEQ" ).append("\n"); 
		query.append("			,REF_ID" ).append("\n"); 
		query.append("			,REF_SEQ" ).append("\n"); 
		query.append("			,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,CO_CD" ).append("\n"); 
		query.append("			,SO_IF_DIV_CD" ).append("\n"); 
		query.append("			,TRSP_MOD_CD" ).append("\n"); 
		query.append("			,FM_YD_CD" ).append("\n"); 
		query.append("			,FM_DT" ).append("\n"); 
		query.append("			,TO_YD_CD" ).append("\n"); 
		query.append("			,TO_DT" ).append("\n"); 
		query.append("			,VSL_LANE_CD" ).append("\n"); 
		query.append("			,VSL_CD" ).append("\n"); 
		query.append("			,SKD_VOY_NO" ).append("\n"); 
		query.append("			,SKD_DIR_CD" ).append("\n"); 
		query.append("			,REPO_PURP_RMK" ).append("\n"); 
		query.append("			,WO_EXE_FLG" ).append("\n"); 
		query.append("			,REPO_COST_AMT" ).append("\n"); 
		query.append("			,EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("			,SO_RQST_DT" ).append("\n"); 
		query.append("			,WO_RQST_FLG" ).append("\n"); 
		query.append("			,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("			,CRE_USR_ID" ).append("\n"); 
		query.append("			,CRE_DT" ).append("\n"); 
		query.append("			,UPD_USR_ID" ).append("\n"); 
		query.append("			,UPD_DT" ).append("\n"); 
		query.append("		)VALUES(" ).append("\n"); 
		query.append("			 @[repo_pln_id]       		-- REPO_PLN_ID" ).append("\n"); 
		query.append("			,@[pln_yrwk]          		-- PLN_YRWK" ).append("\n"); 
		query.append("			,1           		  		-- PLN_SEQ" ).append("\n"); 
		query.append("			,@[ref_id]            		-- REF_ID" ).append("\n"); 
		query.append("			,@[ref_seq]           		-- REF_SEQ" ).append("\n"); 
		query.append("			,@[eq_tpsz_cd]        		-- CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			,'H'             	  		-- CO_CD H:SM LINE" ).append("\n"); 
		query.append("			,@[so_if_div_cd]      		-- SO_IF_DIV_CD" ).append("\n"); 
		query.append("			,@[trsp_mod_cd]       		-- TRSP_MOD_CD" ).append("\n"); 
		query.append("			,@[fm_loc_cd]||@[fm_nod_cd] -- FM_YD_CD" ).append("\n"); 
		query.append("			,@[fm_dt]             		-- FM_DT" ).append("\n"); 
		query.append("			,@[to_loc_cd]||@[to_nod_cd] -- TO_YD_CD" ).append("\n"); 
		query.append("			,@[to_dt]             		-- TO_DT" ).append("\n"); 
		query.append("			,@[slan_cd]          		-- VSL_LANE_CD" ).append("\n"); 
		query.append("			,SUBSTR(@[vvd_cd],1,4)      -- VSL_CD" ).append("\n"); 
		query.append("			,SUBSTR(@[vvd_cd],5,4)  	-- SKD_VOY_NO" ).append("\n"); 
		query.append("			,SUBSTR(@[vvd_cd],9,1)		-- SKD_DIR_CD" ).append("\n"); 
		query.append("			,@[repo_purp_rmk]     		-- REPO_PURP_RMK" ).append("\n"); 
		query.append("			,'N'        		  		-- WO_EXE_FLG" ).append("\n"); 
		query.append("			,0				      		-- REPO_COST_AMT" ).append("\n"); 
		query.append("			,@[ofc_cd]    		  		-- EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append("			,@[so_rqst_dt]        		-- SO_RQST_DT" ).append("\n"); 
		query.append("            ,'Y'				  		-- WO_RQST_FLG" ).append("\n"); 
		query.append("			,'P'  				  		-- TRSP_SO_STS_CD" ).append("\n"); 
		query.append("			,@[usr_id]            		-- CRE_USR_ID" ).append("\n"); 
		query.append("			,SYSDATE	          		-- CRE_DT" ).append("\n"); 
		query.append("			,@[usr_id]        	  		-- UPD_USR_ID" ).append("\n"); 
		query.append("			,SYSDATE              		-- UPD_DT" ).append("\n"); 
		query.append("		)" ).append("\n"); 

	}
}