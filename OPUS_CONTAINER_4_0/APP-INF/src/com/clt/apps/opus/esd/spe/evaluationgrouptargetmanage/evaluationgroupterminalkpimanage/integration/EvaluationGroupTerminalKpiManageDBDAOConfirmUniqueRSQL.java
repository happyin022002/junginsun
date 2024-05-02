/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageDBDAOConfirmUniqueRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.19
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.03.19 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupTerminalKpiManageDBDAOConfirmUniqueRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 등록된 항목이 있는지 체크
	  * </pre>
	  */
	public EvaluationGroupTerminalKpiManageDBDAOConfirmUniqueRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		query.append("FileName : EvaluationGroupTerminalKpiManageDBDAOConfirmUniqueRSQL").append("\n"); 
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
		query.append("SELECT EG_ID,EG_ID_SEQ,SP_KPI_CD,EV_YR,YD_CD" ).append("\n"); 
		query.append("FROM  SPE_EV_GRP_TML_KPI_TGT_RTO" ).append("\n"); 
		query.append("WHERE EG_ID = @[eg_id]" ).append("\n"); 
		query.append("AND EG_ID_SEQ = TO_NUMBER(@[eg_id_seq])" ).append("\n"); 
		query.append("AND EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("AND YD_CD = UPPER(@[yd_cd])" ).append("\n"); 
		query.append("AND VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 

	}
}