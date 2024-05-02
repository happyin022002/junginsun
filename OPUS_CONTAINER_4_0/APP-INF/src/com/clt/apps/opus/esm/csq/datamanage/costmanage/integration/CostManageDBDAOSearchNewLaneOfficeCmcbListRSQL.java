/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * New Lane - Office의 Cmcb를 조회한다.
	  * </pre>
	  */
	public CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.csq.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL").append("\n"); 
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
		query.append("SELECT CST.BSE_TP_CD" ).append("\n"); 
		query.append("      ,CST.BSE_YR" ).append("\n"); 
		query.append("      ,CST.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(CST.OFC_VW_CD,'L','Loading','C','Contract') OFC_VW_CD" ).append("\n"); 
		query.append("      ,CST.TRD_CD" ).append("\n"); 
		query.append("      ,CST.RLANE_CD" ).append("\n"); 
		query.append("      ,CST.DIR_CD" ).append("\n"); 
		query.append("      ,CST.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,CST.RHQ_CD" ).append("\n"); 
		query.append("      ,CST.GID_PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CST.GID_RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CST.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,CST.RA_CM_UC_AMT" ).append("\n"); 
		query.append(" FROM CSQ_QTA_NEW_LANE_OFC_COST CST" ).append("\n"); 
		query.append("     ,CSQ_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("WHERE CST.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND CST.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("  AND CST.BSE_QTR_CD = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  AND CST.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND CST.OFC_VW_CD  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("  AND CST.TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND CST.DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("  AND CST.RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("  AND CST.BSE_TP_CD  = OFC.BSE_TP_CD" ).append("\n"); 
		query.append("  AND CST.BSE_YR     = OFC.BSE_YR" ).append("\n"); 
		query.append("  AND CST.BSE_QTR_CD = OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("  AND CST.OFC_VW_CD  = OFC.OFC_VW_CD" ).append("\n"); 
		query.append("  AND CST.TRD_CD     = OFC.TRD_CD" ).append("\n"); 
		query.append("  AND CST.DIR_CD     = OFC.DIR_CD" ).append("\n"); 
		query.append("  AND CST.RLANE_CD   = OFC.RLANE_CD" ).append("\n"); 
		query.append("  AND CST.RGN_OFC_CD = OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND CST.RHQ_CD     = OFC.RHQ_CD    " ).append("\n"); 
		query.append("  AND OFC.CSQ_ACT_FLG= 'Y' " ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC_CD" ).append("\n"); 

	}
}