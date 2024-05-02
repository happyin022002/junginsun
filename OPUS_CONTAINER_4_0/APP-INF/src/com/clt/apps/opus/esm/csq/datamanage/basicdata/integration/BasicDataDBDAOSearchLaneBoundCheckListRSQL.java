/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchLaneBoundCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BasicDataDBDAOSearchLaneBoundCheckListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSQ_QTA_LANE_MGMT 와 CSQ_QTA_LANE_OFC 간의 Act Flg 체크.
	  * </pre>
	  */
	public BasicDataDBDAOSearchLaneBoundCheckListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchLaneBoundCheckListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("           DECODE(A2.CPY_NO, 0, 'C', 'L') AS OFC_VW_CD" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,NVL(A1.LANE_DIR_CD, A3.VSL_SLAN_DIR_CD) || 'B' AS DIR_CD" ).append("\n"); 
		query.append("     FROM CSQ_QTA_LANE_MGMT      A1" ).append("\n"); 
		query.append("         ,COM_CPY_NO             A2" ).append("\n"); 
		query.append("         ,MDM_VSL_SVC_LANE_DIR   A3" ).append("\n"); 
		query.append("    WHERE A1.CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("      AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("      AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("      AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("      AND A2.CPY_NO       < 2" ).append("\n"); 
		query.append("      AND SUBSTR(A1.RLANE_CD,0,3) = A3.VSL_SLAN_CD" ).append("\n"); 
		query.append("      AND A3.VSL_SLAN_DIR_CD      = NVL(A1.LANE_DIR_CD, A3.VSL_SLAN_DIR_CD)" ).append("\n"); 
		query.append("      AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${f_ias_sctr_flg} == '' || ${f_ias_sctr_flg} == 'null')" ).append("\n"); 
		query.append("      AND A1.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${f_ias_sctr_flg} == 'Y')" ).append("\n"); 
		query.append("      AND A1.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MINUS" ).append("\n"); 
		query.append("    SELECT DISTINCT" ).append("\n"); 
		query.append("           A1.OFC_VW_CD" ).append("\n"); 
		query.append("          ,A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,A1.DIR_CD || 'B'" ).append("\n"); 
		query.append("     FROM CSQ_QTA_LANE_OFC A1," ).append("\n"); 
		query.append("          CSQ_QTA_LANE_MGMT A2" ).append("\n"); 
		query.append("    WHERE A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("      AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("      AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("      AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${f_ias_sctr_flg} == '' || ${f_ias_sctr_flg} == 'null')" ).append("\n"); 
		query.append("      AND A2.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("#elseif (${f_ias_sctr_flg} == 'Y')" ).append("\n"); 
		query.append("      AND A2.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("      AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("      AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("      AND A1.SUB_TRD_CD  = A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 

	}
}