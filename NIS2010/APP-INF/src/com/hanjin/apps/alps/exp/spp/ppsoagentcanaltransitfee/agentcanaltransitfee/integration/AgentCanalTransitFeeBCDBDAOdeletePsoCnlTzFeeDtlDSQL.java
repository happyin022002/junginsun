/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.29
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.08.29 Park Yeon-Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkPsoCnlTzFeeDtl
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOdeletePsoCnlTzFeeDtlDSQL").append("\n"); 
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
		query.append("DELETE FROM PSO_CNL_TZ_FEE_DTL A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.PSO_BZTP_CD    = 5" ).append("\n"); 
		query.append("AND A.VSL_CD         = @[vsl_cd]  --'COAF'" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO     = @[skd_voy_no]  --'0005'" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD     = @[skd_dir_cd]  --'W'" ).append("\n"); 
		query.append("AND A.YD_CD          = @[yd_cd]  --'EGSUZT1'" ).append("\n"); 
		query.append("AND A.CALL_SEQ       = @[call_seq]  --'1'" ).append("\n"); 
		query.append("AND A.LGS_COST_CD	= @[lgs_cost_cd]" ).append("\n"); 
		query.append("AND A.BUD_SCNR_NO 		= '999912'" ).append("\n"); 

	}
}