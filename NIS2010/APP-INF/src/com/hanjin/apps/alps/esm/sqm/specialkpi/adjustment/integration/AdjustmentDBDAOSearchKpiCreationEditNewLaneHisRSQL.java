/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOSearchKpiCreationEditNewLaneHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchKpiCreationEditNewLaneHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchKpiCreationEditNewLaneHis
	  * 
	  * * 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
	  * </pre>
	  */
	public AdjustmentDBDAOSearchKpiCreationEditNewLaneHisRSQL(){
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
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchKpiCreationEditNewLaneHisRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("--      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(COUNT(A1.DIR_CD) OVER(PARTITION BY A1.TRD_CD, A1.RLANE_CD), 2, '', A1.DIR_CD) AS DIR_CD" ).append("\n"); 
		query.append("      ,A1.SRC_RLANE_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,SRC_RLANE_CD" ).append("\n"); 
		query.append("         FROM SQM_SPCL_NEW_LANE" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND BSE_TP_CD   = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("         AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("         AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND SPCL_TGT_CD = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("   ) A1" ).append("\n"); 
		query.append("ORDER BY TRD_CD, RLANE_CD, SRC_RLANE_CD" ).append("\n"); 

	}
}