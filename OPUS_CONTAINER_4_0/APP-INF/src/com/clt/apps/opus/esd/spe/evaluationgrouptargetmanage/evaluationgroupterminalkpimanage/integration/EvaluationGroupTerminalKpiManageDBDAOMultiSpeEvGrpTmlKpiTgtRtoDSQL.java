/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageDBDAOMultiSPE_EV_GRP_TML_KPI_TGT_RTODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : 권정화
*@LastVersion : 1.0
* 2009.07.24 권정화
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kown Jeong hwa
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupTerminalKpiManageDBDAOMultiSpeEvGrpTmlKpiTgtRtoDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * spe_ev_grp_tml_kpi_tgt_rto delete
	  * </pre>
	  */
	public EvaluationGroupTerminalKpiManageDBDAOMultiSpeEvGrpTmlKpiTgtRtoDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupTerminalKpiManageDBDAOMultiSPE_EV_GRP_TML_KPI_TGT_RTODSQL").append("\n"); 
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
		query.append("DELETE FROM SPE_EV_GRP_TML_KPI_TGT_RTO" ).append("\n"); 
		query.append("WHERE	EG_ID = @[eg_id]" ).append("\n"); 
		query.append("AND	EG_ID_SEQ = TO_NUMBER(@[eg_id_seq])" ).append("\n"); 
		query.append("AND	EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("AND	YD_CD = UPPER(@[yd_cd])" ).append("\n"); 
		query.append("AND	VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 

	}
}