/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL.java
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

public class QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CMCB adjust for IAS Sector을 [생성] 합니다.
	  * 
	  * 2014.07.04 이혜민 vvd 조건 삭제
	  * 2015.08.13 김용습 [CHM-201537594] CMCB Adjust Creation시 Year, Quarter만을 조건으로 데이터 생성, 삭제 및 수정 되도록 함
	  * </pre>
	  */
	public QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL(){
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
		query.append("FileName : QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL").append("\n"); 
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
		query.append("               AND A1.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("               AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  A1.PA_CM_UC_AMT = A2.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,A1.RA_CM_UC_AMT = A2.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,A1.UPD_USR_ID   = @[usr_id]                                  " ).append("\n"); 
		query.append("                            ,A1.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}