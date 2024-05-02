/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaLoadRevForSectorListCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchQtaLoadRevForSectorListCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up for IAS Sector by Head Office]의 데이터 [Count]를 [조회]한다.
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaLoadRevForSectorListCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaLoadRevForSectorListCntRSQL").append("\n"); 
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
		query.append("--버튼 컨트롤을 위해서 조회.(PLANNING, CONFIRM, 년간의 경우 데이터가 1Q데이터가 생성되었는지 조회)" ).append("\n"); 
		query.append("SELECT NVL((SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("          FROM CSQ_SCTR_LOD_REV" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND ROWNUM     = 1" ).append("\n"); 
		query.append("        ), 0) AS P_CNT" ).append("\n"); 
		query.append("       ,NVL((SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("          FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND ROWNUM     = 1" ).append("\n"); 
		query.append("        ), 0) AS C_CNT" ).append("\n"); 
		query.append("       ,NVL((SELECT DECODE(@[f_bse_tp_cd], 'Y', COUNT(*) OVER(), 0) CNT " ).append("\n"); 
		query.append("          FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("         WHERE BSE_TP_CD  = 'Q'" ).append("\n"); 
		query.append("           AND BSE_YR     = @[f_bse_yr] + 1" ).append("\n"); 
		query.append("           AND BSE_QTR_CD = '1Q'" ).append("\n"); 
		query.append("           AND ROWNUM     = 1" ).append("\n"); 
		query.append("        ), 0) AS T_CNT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}