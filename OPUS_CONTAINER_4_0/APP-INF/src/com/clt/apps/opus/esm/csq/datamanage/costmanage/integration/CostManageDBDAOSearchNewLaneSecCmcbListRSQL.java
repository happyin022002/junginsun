/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostManageDBDAOSearchNewLaneSecCmcbListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchNewLaneSecCmcbListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Lane Sector CMCB List 조회합니다.
	  * </pre>
	  */
	public CostManageDBDAOSearchNewLaneSecCmcbListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchNewLaneSecCmcbListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT A1.BSE_TP_CD" ).append("\n"); 
		query.append("       ,A1.BSE_YR" ).append("\n"); 
		query.append("       ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("       ,A1.RLANE_CD" ).append("\n"); 
		query.append("       ,A1.DIR_CD" ).append("\n"); 
		query.append("       ,A1.TRD_CD" ).append("\n"); 
		query.append("       ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("       ,A1.SRC_RLANE_CD" ).append("\n"); 
		query.append("       ,DECODE(NVL(A2.RLANE_CD, 'N'), 'N', 'N', 'Y') CRE_FLG" ).append("\n"); 
		query.append("FROM CSQ_SCTR_NEW_LANE A1, CSQ_SCTR_NEW_PAIR_COST A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("AND A1.BSE_YR = A2.BSE_YR(+)" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("AND A1.RLANE_CD = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("AND A1.DIR_CD = A2.DIR_CD(+)" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A2.SUB_TRD_CD(+)" ).append("\n"); 
		query.append("ORDER BY A1.BSE_TP_CD , A1.BSE_YR, A1.BSE_QTR_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.SRC_RLANE_CD" ).append("\n"); 

	}
}