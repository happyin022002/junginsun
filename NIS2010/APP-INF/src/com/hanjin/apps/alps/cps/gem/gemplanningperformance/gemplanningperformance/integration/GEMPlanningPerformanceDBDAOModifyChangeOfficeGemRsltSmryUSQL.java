/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GEMPlanningPerformanceDBDAOModifyChangeOfficeGemRsltSmryUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.09 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMPlanningPerformanceDBDAOModifyChangeOfficeGemRsltSmryUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.04.18 [CHM-201108838-01] 이준범
	  * Title : OFC code Change 설정 시 Assigned Expense Data 변경 요청
	  * </pre>
	  */
	public GEMPlanningPerformanceDBDAOModifyChangeOfficeGemRsltSmryUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_add_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gen_expn_trns_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_co_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_init_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.integration").append("\n"); 
		query.append("FileName : GEMPlanningPerformanceDBDAOModifyChangeOfficeGemRsltSmryUSQL").append("\n"); 
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
		query.append("UPDATE GEM_RSLT_SMRY SET" ).append("\n"); 
		query.append("	   GEN_EXPN_INIT_AMT = GEN_EXPN_INIT_AMT + TO_NUMBER(NVL(@[gen_expn_init_amt],'0'))" ).append("\n"); 
		query.append("      ,GEN_EXPN_ADD_AMT = GEN_EXPN_ADD_AMT + TO_NUMBER(NVL(@[gen_expn_add_amt],'0'))" ).append("\n"); 
		query.append("      ,GEN_EXPN_TRNS_AMT = GEN_EXPN_TRNS_AMT + TO_NUMBER(NVL(@[gen_expn_trns_amt],'0'))" ).append("\n"); 
		query.append("      ,UPD_USR_ID           = @[upd_usr_id]" ).append("\n"); 
		query.append("      ,UPD_DT               = sysdate" ).append("\n"); 
		query.append("WHERE  RSLT_YRMON			= SUBSTR(@[rslt_yrmon],1,6)" ).append("\n"); 
		query.append("AND    OFC_CD               = @[ofc_cd]" ).append("\n"); 
		query.append("AND    SUB_OFC_CD           = @[sub_ofc_cd]" ).append("\n"); 
		query.append("AND    GEN_EXPN_CD          = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND    SUB_GEN_EXPN_CD      = @[sub_gen_expn_cd]" ).append("\n"); 
		query.append("AND    OFC_CO_DIV_CD        = @[ofc_co_div_cd]" ).append("\n"); 

	}
}