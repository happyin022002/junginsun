/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateCmcbAdjustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
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
		query.append("MERGE INTO CSQ_CFM_QTA QTA                                               " ).append("\n"); 
		query.append("USING CSQ_QTA_LANE_OFC_COST CST                                                                          " ).append("\n"); 
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
		query.append("               AND QTA.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND QTA.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("               AND QTA.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("               AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("               AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("               AND QTA.TRD_CD                     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("               AND QTA.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("               AND QTA.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("               AND QTA.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("               AND QTA.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '')" ).append("\n"); 
		query.append("               AND QTA.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '')" ).append("\n"); 
		query.append("               AND QTA.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '')" ).append("\n"); 
		query.append("               AND QTA.SKD_DIR_CD                 = @[f_skd_dir_cd]    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  QTA.PA_CM_UC_AMT = CST.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,QTA.RA_CM_UC_AMT = CST.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,QTA.UPD_USR_ID   = @[usr_id]                                  " ).append("\n"); 
		query.append("                            ,QTA.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}