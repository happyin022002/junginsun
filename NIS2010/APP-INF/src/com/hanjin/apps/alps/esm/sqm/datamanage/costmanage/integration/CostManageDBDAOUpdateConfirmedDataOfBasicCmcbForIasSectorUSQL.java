/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CostManageDBDAOUpdateConfirmedDataOfBasicCmcbForIasSectorUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
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

public class CostManageDBDAOUpdateConfirmedDataOfBasicCmcbForIasSectorUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201639850 CMCB 수정 데이터 Creation 버튼 생성 CSR
	  * </pre>
	  */
	public CostManageDBDAOUpdateConfirmedDataOfBasicCmcbForIasSectorUSQL(){
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
		params.put("bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOUpdateConfirmedDataOfBasicCmcbForIasSectorUSQL").append("\n"); 
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
		query.append("MERGE INTO SQM_SCTR_CFM_QTA A1                                               " ).append("\n"); 
		query.append("USING SQM_SCTR_PAIR_COST A2                                                                          " ).append("\n"); 
		query.append("    ON (                                                                                   " ).append("\n"); 
		query.append("                   A1.BSE_TP_CD                  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("               AND A1.BSE_YR                     = A2.BSE_YR" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD                 = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND A1.TRD_CD                     = A2.TRD_CD" ).append("\n"); 
		query.append("               AND A1.SUB_TRD_CD                 = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND A1.RLANE_CD                   = A2.RLANE_CD" ).append("\n"); 
		query.append("               AND A1.DIR_CD                     = A2.DIR_CD " ).append("\n"); 
		query.append("               AND A1.POL_CD                     = A2.POL_CD" ).append("\n"); 
		query.append("               AND A1.POD_CD                     = A2.POD_CD" ).append("\n"); 
		query.append("               AND A1.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("               AND A1.BSE_YR                     = @[bse_yr]" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD                 = @[bse_qtr_cd]" ).append("\n"); 
		query.append("               AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("               AND A2.TRD_CD                     = @[trd_cd]" ).append("\n"); 
		query.append("               AND A2.SUB_TRD_CD                 = @[sub_trd_cd]" ).append("\n"); 
		query.append("               AND A2.RLANE_CD                   = @[rlane_cd]" ).append("\n"); 
		query.append("               AND A2.DIR_CD                     = @[dir_cd] " ).append("\n"); 
		query.append("               AND A2.POL_CD                     = @[pol_cd]" ).append("\n"); 
		query.append("               AND A2.POD_CD                     = @[pod_cd]" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  A1.PA_CM_UC_AMT = A2.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,A1.RA_CM_UC_AMT = A2.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,A1.UPD_USR_ID   = @[upd_usr_id]                                  " ).append("\n"); 
		query.append("                            ,A1.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}