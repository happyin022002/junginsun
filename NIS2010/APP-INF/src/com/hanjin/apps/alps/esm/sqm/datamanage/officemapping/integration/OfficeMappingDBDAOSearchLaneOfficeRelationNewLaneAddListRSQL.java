/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ-Office Mapping Data 를 조회
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(O.RHQ_CD, NULL, 0, 1) + DECODE(O.RGN_OFC_CD, NULL, 0, 1) AS LVL" ).append("\n"); 
		query.append("        ,O.RHQ_CD" ).append("\n"); 
		query.append("        ,O.RGN_OFC_CD" ).append("\n"); 
		query.append("    FROM SQM_QTA_OFC O" ).append("\n"); 
		query.append("        ,SQM_DAT_RLT R" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("			SELECT DECODE(A2.CPY_NO, 1, NVL(TRD_CD,@[f_trd_cd])) AS TRD_CD" ).append("\n"); 
		query.append("                  ,DECODE(A2.CPY_NO, 1, NVL(CONV_DIR_CD, @[f_dir_cd])) AS CONV_DIR_CD" ).append("\n"); 
		query.append("                  ,DECODE(A2.CPY_NO, 1, NVL(DIR_CD, @[f_dir_cd])) AS DIR_CD" ).append("\n"); 
		query.append("              FROM SQM_DIR_CONV A1" ).append("\n"); 
		query.append("                  ,COM_CPY_NO A2" ).append("\n"); 
		query.append("             WHERE A1.BSE_TP_CD(+)  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND A1.BSE_YR(+)     = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND A1.BSE_QTR_CD(+) = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("               AND A1.TRD_CD(+)     = @[f_trd_cd]" ).append("\n"); 
		query.append("               AND A1.RLANE_CD(+)   = @[f_rlane_cd]" ).append("\n"); 
		query.append("               AND A1.DIR_CD(+)     = @[f_dir_cd]" ).append("\n"); 
		query.append("               AND DECODE(A2.CPY_NO, 1, @[f_bse_tp_cd]) = A1.BSE_TP_CD(+)" ).append("\n"); 
		query.append("               AND A2.CPY_NO        = 1" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("         ) C" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("     AND R.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND R.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND R.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND R.OFC_VW_CD   = SUBSTR(@[f_ofc_vw_cd], 1, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     AND O.RHQ_CD      = R.RHQ_CD" ).append("\n"); 
		query.append("     AND O.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("     AND R.RLANE_CD    = DECODE(UPPER(R.RLANE_CD), 'ALL', R.RLANE_CD, @[f_rlane_cd])" ).append("\n"); 
		query.append("     AND R.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("     AND R.CONV_DIR_CD = C.CONV_DIR_CD" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS (" ).append("\n"); 
		query.append("                         (O.RHQ_CD)" ).append("\n"); 
		query.append("                        ,(O.RHQ_CD, O.RGN_OFC_CD)" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("        ,LVL" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 

	}
}