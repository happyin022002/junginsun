/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.14
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.06.14 최윤성
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CSQ_QTA_LANE_OFC 의 Data Count
	  * </pre>
	  */
	public OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL(){
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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.officemapping.integration").append("\n"); 
		query.append("FileName : OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL").append("\n"); 
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
		query.append("SELECT BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 
		query.append("        ,CSQ_ACT_FLG" ).append("\n"); 
		query.append("    FROM CSQ_QTA_LANE_OFC" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND OFC_VW_CD  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("     AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("     AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("     AND RGN_OFC_CD = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND RHQ_CD     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 

	}
}