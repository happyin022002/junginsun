/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BasicDataDBDAOSearchLaneBoundCheckListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * SQM_QTA_LANE_MGMT 와 SQM_QTA_LANE_OFC 간의 Act Flg 체크.
	  * * History
	  * CHM-201430324 이혜민 IAs Sector -프로젝트 안정화 및 3분기 판매목표 수립 지원(Overall과 IAS Sector구분)
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
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.integration").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("         DECODE(A2.CPY_NO, 0, 'C', 'L') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,A1.TRD_CD" ).append("\n"); 
		query.append("        ,A1.RLANE_CD" ).append("\n"); 
		query.append("        ,NVL(A1.LANE_DIR_CD, DECODE(A3.CPY_NO, 0, 'E', 'W')) || 'B' AS DIR_CD" ).append("\n"); 
		query.append("    FROM SQM_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("        ,COM_CPY_NO        A2" ).append("\n"); 
		query.append("        ,COM_CPY_NO        A3" ).append("\n"); 
		query.append("   WHERE A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("     AND A2.CPY_NO      < 2" ).append("\n"); 
		query.append("     AND A3.CPY_NO      < 2" ).append("\n"); 
		query.append("#if (${f_ias_sctr_flg} == '' || ${f_ias_sctr_flg} == 'null')" ).append("\n"); 
		query.append("     AND A1.TRD_CD <> 'IAS'" ).append("\n"); 
		query.append("#elseif (${f_ias_sctr_flg} == 'Y')" ).append("\n"); 
		query.append("     AND A1.TRD_CD = 'IAS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   MINUS" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD || 'B'" ).append("\n"); 
		query.append("    FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${f_ias_sctr_flg} == '' || ${f_ias_sctr_flg} == 'null')" ).append("\n"); 
		query.append("     AND TRD_CD <> 'IAS'" ).append("\n"); 
		query.append("#elseif (${f_ias_sctr_flg} == 'Y')" ).append("\n"); 
		query.append("     AND TRD_CD = 'IAS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 

	}
}