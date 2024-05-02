/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateCmcbAdjustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOCreateCmcbAdjustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CMCB adjust]을을 [생성] 합니다
	  * [CHM-201537594] - CMCB Adjust Creation시 Year, Quarter만을 조건으로 데이터 생성되도록 변경
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateCmcbAdjustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOCreateCmcbAdjustUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_CFM_QTA QTA                                               " ).append("\n"); 
		query.append("USING SQM_QTA_LANE_OFC_COST CST                                                                          " ).append("\n"); 
		query.append("    ON (                                                                                   " ).append("\n"); 
		query.append("                   QTA.BSE_TP_CD                  = CST.BSE_TP_CD" ).append("\n"); 
		query.append("               AND QTA.BSE_YR                     = CST.BSE_YR" ).append("\n"); 
		query.append("               AND QTA.BSE_QTR_CD                 = CST.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND QTA.OFC_VW_CD                  = CST.OFC_VW_CD" ).append("\n"); 
		query.append("               AND QTA.TRD_CD                     = CST.TRD_CD" ).append("\n"); 
		query.append("               AND QTA.RLANE_CD                   = CST.RLANE_CD" ).append("\n"); 
		query.append("               AND QTA.DIR_CD                     = CST.DIR_CD" ).append("\n"); 
		query.append("--               AND QTA.RHQ_CD                     = CST.RHQ_CD" ).append("\n"); 
		query.append("               AND QTA.RGN_OFC_CD                 = CST.RGN_OFC_CD" ).append("\n"); 
		query.append("               AND QTA.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("               AND QTA.BSE_YR                     = @[f_bse_yr] " ).append("\n"); 
		query.append("               AND QTA.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("               AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("               AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  QTA.PA_CM_UC_AMT = CST.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,QTA.RA_CM_UC_AMT = CST.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,QTA.UPD_USR_ID   = @[usr_id]                                  " ).append("\n"); 
		query.append("                            ,QTA.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}