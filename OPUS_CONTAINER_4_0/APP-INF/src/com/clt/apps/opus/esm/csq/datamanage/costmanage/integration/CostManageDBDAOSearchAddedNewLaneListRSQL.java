/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostManageDBDAOSearchAddedNewLaneListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.19
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.07.19 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchAddedNewLaneListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 추가된 LaneList를 조회한다
	  * </pre>
	  */
	public CostManageDBDAOSearchAddedNewLaneListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchAddedNewLaneListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       LANE.BSE_TP_CD" ).append("\n"); 
		query.append("      ,LANE.BSE_YR" ).append("\n"); 
		query.append("      ,LANE.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,LANE.TRD_CD" ).append("\n"); 
		query.append("      ,LANE.RLANE_CD" ).append("\n"); 
		query.append("      ,LANE.DIR_CD" ).append("\n"); 
		query.append("      ,LANE.SRC_RLANE_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(CO.TRD_CD,'*'),'*','N','Y') FLG" ).append("\n"); 
		query.append(" FROM CSQ_QTA_NEW_LANE LANE" ).append("\n"); 
		query.append("     ,CSQ_QTA_NEW_LANE_OFC_COST CO" ).append("\n"); 
		query.append("WHERE LANE.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND LANE.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("  AND LANE.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND LANE.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND LANE.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("  AND LANE.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND LANE.BSE_TP_CD  = CO.BSE_TP_CD(+)" ).append("\n"); 
		query.append("  AND LANE.BSE_YR     = CO.BSE_YR(+)" ).append("\n"); 
		query.append("  AND LANE.BSE_QTR_CD = CO.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("  AND LANE.TRD_CD     = CO.TRD_CD(+)" ).append("\n"); 
		query.append("  AND LANE.RLANE_CD   = CO.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND LANE.DIR_CD     = CO.DIR_CD(+) " ).append("\n"); 
		query.append("ORDER BY LANE.TRD_CD" ).append("\n"); 
		query.append("        ,LANE.RLANE_CD" ).append("\n"); 
		query.append("        ,LANE.DIR_CD" ).append("\n"); 

	}
}