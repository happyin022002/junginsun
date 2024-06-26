/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.08.06 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SpeEvGrpKpiTgtRtoVODSQL.Query
	  * </pre>
	  */
	public EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_kpi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupKpiTargetManageDBDAOSpeEvGrpKpiTgtRtoDSQL").append("\n"); 
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
		query.append("DELETE FROM SPE_EV_GRP_KPI_TGT_RTO" ).append("\n"); 
		query.append("WHERE	EG_ID = substr(@[eg_id],1,5)" ).append("\n"); 
		query.append("AND	EG_ID_SEQ = TO_NUMBER(substr(@[eg_id],7,3))" ).append("\n"); 
		query.append("AND	SP_KPI_CD = @[sp_kpi_cd]" ).append("\n"); 
		query.append("AND	EV_YR = @[ev_yr]" ).append("\n"); 

	}
}