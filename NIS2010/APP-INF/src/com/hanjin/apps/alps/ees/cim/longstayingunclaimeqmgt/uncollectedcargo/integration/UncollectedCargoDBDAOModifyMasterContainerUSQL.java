/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOModifyMasterContainerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOModifyMasterContainerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Uncollected Cargo 와 관련된 Master Container 를 Update 한다. 
	  * </pre>
	  */
	public UncollectedCargoDBDAOModifyMasterContainerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("temp1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_ls_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uclm_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOModifyMasterContainerUSQL").append("\n"); 
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
		query.append("UPDATE	MST_CONTAINER a" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("	    uclm_ls_div_cd = @[uclm_ls_div_cd]" ).append("\n"); 
		query.append("	    , uclm_dt = TO_DATE(REPLACE(@[uclm_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("		#if (${type} == 'REOPEN')" ).append("\n"); 
		query.append("	      	, uc_rsn_cd =	(	SELECT  d.uc_rsn_cd" ).append("\n"); 
		query.append("	        					FROM	CIM_UC_CGO_DTL D, CIM_UC_CGO_CNTR C" ).append("\n"); 
		query.append("	        					WHERE	1 = 1" ).append("\n"); 
		query.append("                                        AND c.cntr_no = a.cntr_no" ).append("\n"); 
		query.append("                                        AND d.uc_cs_no = c.uc_cs_no" ).append("\n"); 
		query.append("                                        AND d.bl_no = c.bl_no )" ).append("\n"); 
		query.append("            , uclm_rsn =    (   SELECT  (   SELECT	INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                            FROM	COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                            WHERE	INTG_CD_ID = 'CD03293' AND INTG_CD_VAL_CTNT = d.uc_rsn_cd)" ).append("\n"); 
		query.append("                                 FROM	CIM_UC_CGO_DTL D, CIM_UC_CGO_CNTR C" ).append("\n"); 
		query.append("                                 WHERE	1 = 1" ).append("\n"); 
		query.append("                                        AND c.cntr_no = a.cntr_no" ).append("\n"); 
		query.append("                                        AND d.uc_cs_no = c.uc_cs_no" ).append("\n"); 
		query.append("                                        AND d.bl_no = c.bl_no ) " ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			, uclm_rsn = @[uclm_rsn] " ).append("\n"); 
		query.append("			, uc_rsn_cd = @[uc_rsn_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    , uclm_end_dt = TO_DATE(REPLACE(@[uclm_end_dt],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("		, upd_dt = SYSDATE" ).append("\n"); 
		query.append("		, upd_usr_id = @[temp1]" ).append("\n"); 
		query.append("WHERE 	" ).append("\n"); 
		query.append("		1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${type} == 'OLD')" ).append("\n"); 
		query.append("			AND cntr_no IN (" ).append("\n"); 
		query.append("	        					SELECT  cntr_no 	" ).append("\n"); 
		query.append("	        					FROM	CIM_UC_CGO_CNTR" ).append("\n"); 
		query.append("	        					WHERE	1 = 1" ).append("\n"); 
		query.append("	                					AND uc_cs_no = @[uc_cs_no]" ).append("\n"); 
		query.append("	                					AND bl_no = @[bl_no]" ).append("\n"); 
		query.append("	        				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${type} == 'NEW')" ).append("\n"); 
		query.append("	    	AND cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${type} == 'ALL' || ${type} == 'REOPEN')" ).append("\n"); 
		query.append("			AND cntr_no IN (" ).append("\n"); 
		query.append("	        					SELECT  cntr_no 	" ).append("\n"); 
		query.append("	        					FROM	CIM_UC_CGO_CNTR" ).append("\n"); 
		query.append("	        					WHERE	1 = 1" ).append("\n"); 
		query.append("	                					AND uc_cs_no = @[uc_cs_no]" ).append("\n"); 
		query.append("	        				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 

	}
}