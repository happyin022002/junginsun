/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchMissingOfficeViewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchMissingOfficeViewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSQ_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchMissingOfficeViewRSQL(){
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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchMissingOfficeViewRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(B1.OFC_VW_CD, 'L', 'Contract', 'C', 'Loading'), 'N') AS MISS_OFC_VW" ).append("\n"); 
		query.append("FROM (        " ).append("\n"); 
		query.append("      SELECT DECODE(A1.CNT,1,(SELECT DISTINCT OFC_VW_CD" ).append("\n"); 
		query.append("                                FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                AND A1.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("                                AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("                                AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("                                AND A1.RLANE_CD   = @[f_rlane_cd])) AS  OFC_VW_CD    " ).append("\n"); 
		query.append("      FROM (     " ).append("\n"); 
		query.append("           SELECT COUNT(DISTINCT OFC_VW_CD) CNT" ).append("\n"); 
		query.append("            FROM CSQ_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND A1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("            AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("            AND A1.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("            AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("            AND A1.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("            AND A1.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("            ) A1" ).append("\n"); 
		query.append("        ) B1" ).append("\n"); 

	}
}