/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AdjustmentDBDAOSearchNewLaneAddBoundRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.17 
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

public class AdjustmentDBDAOSearchNewLaneAddBoundRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [KPI Creation & Edit New Lane Add] 팝업 내 New Lane 입력시 Bound를 [조회]합니다
	  * </pre>
	  */
	public AdjustmentDBDAOSearchNewLaneAddBoundRSQL(){
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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchNewLaneAddBoundRSQL").append("\n"); 
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
		query.append("SELECT DECODE(LANE_DIR_CD, '' , (SELECT DISTINCT" ).append("\n"); 
		query.append("                                DECODE(COUNT(B1.DIR_CD) OVER(PARTITION BY B1.BSE_TP_CD, B1.BSE_YR, B1.BSE_QTR_CD, B1.SPCL_TGT_CD, B1.TRD_CD, B1.RLANE_CD),2,'',DECODE(B1.DIR_CD,'E','W','W','E')) " ).append("\n"); 
		query.append("                                FROM (" ).append("\n"); 
		query.append("                                        SELECT DISTINCT A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.SPCL_TGT_CD, A1.TRD_CD, A1.RLANE_CD, A1.DIR_CD" ).append("\n"); 
		query.append("                                        FROM SQM_SPCL_CFM_QTA A1" ).append("\n"); 
		query.append("                                        WHERE A1.BSE_TP_CD  = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("                                        AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("                                        AND A1.BSE_QTR_CD   = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                        AND A1.SPCL_TGT_CD  = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("                                        AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("                                        AND A1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("                                     ) B1) ,LANE_DIR_CD) NEW_LANE_DIR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM SQM_QTA_LANE_MGMT C1    " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND C1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("AND C1.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 

	}
}