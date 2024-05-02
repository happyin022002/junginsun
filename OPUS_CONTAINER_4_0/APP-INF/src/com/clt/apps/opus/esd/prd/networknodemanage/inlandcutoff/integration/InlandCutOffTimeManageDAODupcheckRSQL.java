/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandCutOffTimeManageDAODupcheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandCutOffTimeManageDAODupcheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandCutOffTimeManageDAODupcheck
	  * </pre>
	  */
	public InlandCutOffTimeManageDAODupcheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prio_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration").append("\n"); 
		query.append("FileName : InlandCutOffTimeManageDAODupcheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("  FROM PRD_INLND_CUT_OFF_TM_MGMT X" ).append("\n"); 
		query.append(" WHERE X.LANE_CD = @[lane_cd]" ).append("\n"); 
		query.append("   AND X.ORG_YD_CD = @[org_yd_cd]" ).append("\n"); 
		query.append("   AND X.DEST_YD_CD = @[dest_yd_cd]" ).append("\n"); 
		query.append("   AND X.SPCL_CGO_CNTR_TP_CD = @[spcl_cgo_cntr_tp_cd]" ).append("\n"); 
		query.append("   AND (  TO_DATE(@[eff_fm_dt], 'YYYYMMDD') BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT " ).append("\n"); 
		query.append("       OR TO_DATE(@[eff_to_dt], 'YYYYMMDD') BETWEEN X.EFF_FM_DT AND X.EFF_TO_DT      " ).append("\n"); 
		query.append("       OR (TO_DATE(@[eff_fm_dt], 'YYYYMMDD') < X.EFF_FM_DT AND TO_DATE(@[eff_to_dt], 'YYYYMMDD') > X.EFF_TO_DT)" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("	AND X.PRIO_SEQ = DECODE(@[prio_seq], 'ALL', 0, TO_NUMBER(@[prio_seq]))" ).append("\n"); 

	}
}