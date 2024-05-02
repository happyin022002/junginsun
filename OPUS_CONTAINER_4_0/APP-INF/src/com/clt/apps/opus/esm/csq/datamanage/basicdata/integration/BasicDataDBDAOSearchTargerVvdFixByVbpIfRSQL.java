/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BasicDataDBDAOSearchTargerVvdFixByVbpIfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.26 
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

public class BasicDataDBDAOSearchTargerVvdFixByVbpIfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target VVD List를 조회
	  * </pre>
	  */
	public BasicDataDBDAOSearchTargerVvdFixByVbpIfRSQL(){
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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.basicdata.integration").append("\n"); 
		query.append("FileName : BasicDataDBDAOSearchTargerVvdFixByVbpIfRSQL").append("\n"); 
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
		query.append("SELECT VBP.BSE_TP_CD" ).append("\n"); 
		query.append("      ,VBP.BSE_YR" ).append("\n"); 
		query.append("      ,DECODE(VBP.BSE_TP_CD,'Y','00',@[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("      ,VBP.TRD_CD" ).append("\n"); 
		query.append("      ,VBP.RLANE_CD" ).append("\n"); 
		query.append("      ,VBP.DIR_CD" ).append("\n"); 
		query.append("      ,VBP.VSL_CD||VBP.SKD_VOY_NO||VBP.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,VBP.VSL_CD" ).append("\n"); 
		query.append("      ,VBP.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,VBP.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,VBP.BSE_MON" ).append("\n"); 
		query.append("      ,VBP.BSE_WK" ).append("\n"); 
		query.append("      ,VBP.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,VBP.IOC_CD" ).append("\n"); 
		query.append("      ,NVL(VBP.FNL_BSA_CAPA,0) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("  FROM CSQ_QTA_TGT_VVD_IF VBP" ).append("\n"); 
		query.append("      ,CSQ_QTA_LANE_MGMT LANE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND VBP.BSE_TP_CD  = LANE.BSE_TP_CD " ).append("\n"); 
		query.append("   AND VBP.BSE_YR     = LANE.BSE_YR " ).append("\n"); 
		query.append("   AND VBP.BSE_QTR_CD = LANE.BSE_QTR_CD " ).append("\n"); 
		query.append("   AND VBP.TRD_CD     = LANE.TRD_CD" ).append("\n"); 
		query.append("   AND VBP.RLANE_CD   = LANE.RLANE_CD" ).append("\n"); 
		query.append("   AND VBP.SUB_TRD_CD = LANE.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND VBP.DIR_CD     = NVL(LANE.LANE_DIR_CD,VBP.DIR_CD)" ).append("\n"); 
		query.append("   AND VBP.BSE_TP_CD  = @[f_bse_tp_cd] " ).append("\n"); 
		query.append("   AND VBP.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND VBP.BSE_MON    BETWEEN '01' AND '12'" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("   AND VBP.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("   AND VBP.BSE_WK     BETWEEN '00' AND '53'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VBP.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND VBP.BSE_WK     BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND VBP.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("  AND VBP.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("  AND VBP.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("  AND VBP.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND VBP.DELT_FLG      =  'N'" ).append("\n"); 
		query.append("   AND LANE.CSQ_ACT_FLG  =  'Y'" ).append("\n"); 
		query.append("ORDER BY VBP.TRD_CD" ).append("\n"); 
		query.append("        ,VBP.DIR_CD" ).append("\n"); 
		query.append("        ,VBP.SUB_TRD_CD" ).append("\n"); 
		query.append("        ,VBP.RLANE_CD" ).append("\n"); 
		query.append("        ,VBP.BSE_MON" ).append("\n"); 
		query.append("        ,VBP.BSE_WK" ).append("\n"); 

	}
}