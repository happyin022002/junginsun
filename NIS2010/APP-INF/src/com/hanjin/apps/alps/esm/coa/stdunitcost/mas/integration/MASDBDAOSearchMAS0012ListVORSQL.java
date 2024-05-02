/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MASDBDAOSearchMAS0012ListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.10.13 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.mas.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Yun Joo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MASDBDAOSearchMAS0012ListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ABC STP 단가 조회   
	  * </pre>
	  */
	public MASDBDAOSearchMAS0012ListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_svc_trns_prc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_act_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.mas.integration").append("\n"); 
		query.append("FileName : MASDBDAOSearchMAS0012ListVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("COST_YRMON" ).append("\n"); 
		query.append(",OFC_CD" ).append("\n"); 
		query.append(",OFC_ACT_CD" ).append("\n"); 
		query.append(",OFC_ACT_NM" ).append("\n"); 
		query.append(",SVC_TRNS_PRC_FLG" ).append("\n"); 
		query.append(",DIV_MEAS_NM" ).append("\n"); 
		query.append(",ACT_OFC_TTL_QTY" ).append("\n"); 
		query.append(",ACT_OFC_TTL_AMT" ).append("\n"); 
		query.append(",ACT_COST_UT_AMT" ).append("\n"); 
		query.append(",SVC_TRNS_PRC_CNT_CD" ).append("\n"); 
		query.append(",CNT_AVG_UC_AMT" ).append("\n"); 
		query.append(",STP_MGN_RTO" ).append("\n"); 
		query.append(",SVC_TRNS_PRC_UT_AMT" ).append("\n"); 
		query.append("FROM COA_SVC_TRNS_PRC" ).append("\n"); 
		query.append("WHERE COST_YRMON = @[f_cost_yrmon]" ).append("\n"); 
		query.append("#if (${f_ofc_cd} != '')" ).append("\n"); 
		query.append("AND OFC_CD = @[f_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_svc_trns_prc_cnt_cd} != '')" ).append("\n"); 
		query.append("AND SVC_TRNS_PRC_CNT_CD = @[f_svc_trns_prc_cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_ofc_act_cd} != '')" ).append("\n"); 
		query.append("AND OFC_ACT_CD = @[f_ofc_act_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}