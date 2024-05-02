/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOUpdateCmcbOfConfirmedDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOUpdateCmcbOfConfirmedDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201639850 CMCB 수정 데이터 Creation 버튼 생성 CSR
	  * </pre>
	  */
	public CostManageDBDAOUpdateCmcbOfConfirmedDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOUpdateCmcbOfConfirmedDataUSQL").append("\n"); 
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
		query.append("               AND QTA.BSE_YR                     = @[bse_yr] " ).append("\n"); 
		query.append("               AND QTA.BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("               AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               AND QTA.BSE_TP_CD                  = @[bse_tp_cd]" ).append("\n"); 
		query.append("               AND QTA.BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("               AND QTA.BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND QTA.OFC_VW_CD                  = @[ofc_vw_cd]" ).append("\n"); 
		query.append("               AND QTA.TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("               AND QTA.RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("               AND QTA.DIR_CD                     = @[dir_cd]" ).append("\n"); 
		query.append("               AND QTA.RHQ_CD                     = @[rhq_cd]" ).append("\n"); 
		query.append("               AND QTA.RGN_OFC_CD                 = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  QTA.PA_CM_UC_AMT = CST.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,QTA.RA_CM_UC_AMT = CST.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,QTA.UPD_USR_ID   = @[upd_usr_id]                                  " ).append("\n"); 
		query.append("                            ,QTA.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}