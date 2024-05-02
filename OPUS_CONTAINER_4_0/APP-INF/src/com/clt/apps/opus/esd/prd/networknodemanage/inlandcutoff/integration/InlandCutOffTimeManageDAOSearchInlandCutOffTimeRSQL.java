/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InlandCutOffTimeManageDAOSearchInlandCutOffTimeRSQL.java
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

public class InlandCutOffTimeManageDAOSearchInlandCutOffTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandCutOffTimeManageDAOSearchInlandCutOffTime
	  * </pre>
	  */
	public InlandCutOffTimeManageDAOSearchInlandCutOffTimeRSQL(){
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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.integration").append("\n"); 
		query.append("FileName : InlandCutOffTimeManageDAOSearchInlandCutOffTimeRSQL").append("\n"); 
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
		query.append("SELECT LANE_CD" ).append("\n"); 
		query.append("      ,ORG_YD_CD" ).append("\n"); 
		query.append("      ,DEST_YD_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(EFF_FM_DT, 'YYYYMMDD') EFF_FM_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(EFF_TO_DT, 'YYYYMMDD') EFF_TO_DT" ).append("\n"); 
		query.append("      ,SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append("      ,INLND_CCT_TP_CD" ).append("\n"); 
		query.append("      ,CCT_DY_CD" ).append("\n"); 
		query.append("      ,CGO_CLZ_HRMNT" ).append("\n"); 
		query.append("      ,AVAL_WK_NO" ).append("\n"); 
		query.append("      ,AVAL_DY_CD" ).append("\n"); 
		query.append("      ,AVAL_HRMNT" ).append("\n"); 
		query.append("      ,INLND_TRSP_FREQ_CD" ).append("\n"); 
		query.append("      ,INLND_TRSP_WK_ITVAL_NO" ).append("\n"); 
		query.append("      ,SUN_ST_FLG" ).append("\n"); 
		query.append("      ,MON_ST_FLG" ).append("\n"); 
		query.append("      ,TUE_ST_FLG" ).append("\n"); 
		query.append("      ,WED_ST_FLG" ).append("\n"); 
		query.append("      ,THU_ST_FLG" ).append("\n"); 
		query.append("      ,FRI_ST_FLG" ).append("\n"); 
		query.append("      ,SAT_ST_FLG" ).append("\n"); 
		query.append("      ,DELT_FLG" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,DECODE(PRIO_SEQ, 0, 'ALL', TO_CHAR(PRIO_SEQ)) PRIO_SEQ" ).append("\n"); 
		query.append("  FROM PRD_INLND_CUT_OFF_TM_MGMT" ).append("\n"); 
		query.append(" WHERE LANE_CD = NVL(@[lane_cd], LANE_CD)" ).append("\n"); 
		query.append("   AND ORG_YD_CD LIKE @[org_yd_cd] || '%'" ).append("\n"); 
		query.append("   AND DEST_YD_CD LIKE @[dest_yd_cd] || '%'" ).append("\n"); 
		query.append("   AND SPCL_CGO_CNTR_TP_CD = NVL(@[spcl_cgo_cntr_tp_cd], SPCL_CGO_CNTR_TP_CD)" ).append("\n"); 
		query.append("   AND NVL(TO_DATE(REPLACE(@[eff_fm_dt], '-', ''), 'YYYYMMDD'), EFF_FM_DT) BETWEEN EFF_FM_DT AND EFF_TO_DT" ).append("\n"); 
		query.append(" ORDER BY LANE_CD,SPCL_CGO_CNTR_TP_CD,ORG_YD_CD,DEST_YD_CD,EFF_FM_DT,EFF_TO_DT,PRIO_SEQ" ).append("\n"); 

	}
}