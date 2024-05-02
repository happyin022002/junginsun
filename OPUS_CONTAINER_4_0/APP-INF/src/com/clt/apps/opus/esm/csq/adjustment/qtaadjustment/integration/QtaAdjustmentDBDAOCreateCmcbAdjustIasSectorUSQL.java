/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO CSQ_SCTR_CFM_QTA A1                                               " ).append("\n"); 
		query.append("USING CSQ_SCTR_PAIR_COST A2                                                                          " ).append("\n"); 
		query.append("    ON (                                                                                   " ).append("\n"); 
		query.append("                   A1.BSE_TP_CD                  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("               AND A1.BSE_YR                     = A2.BSE_YR" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD                 = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND A1.TRD_CD                     = A2.TRD_CD" ).append("\n"); 
		query.append("               AND A1.SUB_TRD_CD                 = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("               AND A1.RLANE_CD                   = A2.RLANE_CD" ).append("\n"); 
		query.append("               AND A1.DIR_CD                     = A2.DIR_CD" ).append("\n"); 
		query.append("               AND A1.POL_CD                     = A2.POL_CD" ).append("\n"); 
		query.append("               AND A1.POD_CD                     = A2.POD_CD" ).append("\n"); 
		query.append("               AND A1.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("               AND A1.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("               AND A1.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("               AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.SUB_TRD_CD                 = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.POL_CD                     = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("               AND A1.POD_CD                     = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       )                                                                                   " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                                                        " ).append("\n"); 
		query.append("                 UPDATE SET  A1.PA_CM_UC_AMT = A2.PA_CM_UC_AMT                    " ).append("\n"); 
		query.append("                            ,A1.RA_CM_UC_AMT = A2.RA_CM_UC_AMT                " ).append("\n"); 
		query.append("                            ,A1.UPD_USR_ID   = @[usr_id]                                  " ).append("\n"); 
		query.append("                            ,A1.UPD_DT       = SYSDATE" ).append("\n"); 

	}
}