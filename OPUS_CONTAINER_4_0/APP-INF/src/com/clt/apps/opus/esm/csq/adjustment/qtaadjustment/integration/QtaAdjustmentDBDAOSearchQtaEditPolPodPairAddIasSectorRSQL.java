/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.06 
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

public class QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Edit_ POL-POD Pair Add for IAS Sector List를 조회합니다.
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("FROM CSQ_SCTR_PAIR_MGMT A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND A1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.POL_CD||A1.POD_CD NOT IN ( SELECT DISTINCT POL_CD||POD_CD" ).append("\n"); 
		query.append("                                    FROM CSQ_SCTR_CFM_QTA" ).append("\n"); 
		query.append("                                    WHERE 1=1" ).append("\n"); 
		query.append("                                    AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("                                    AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                    AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("                                    AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                    AND OFC_VW_CD   = SUBSTR(@[f_ofc_vw_cd], 0 ,1)" ).append("\n"); 
		query.append("                                    AND SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("                                    AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("                                    AND DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("									#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("									AND POL_CD      = @[f_pol_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("									#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("									AND POD_CD      = @[f_pod_cd]" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("ORDER BY POL_CD, POD_CD" ).append("\n"); 

	}
}