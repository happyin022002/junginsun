/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesOffdockCYFreeDayHistoryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.07.08 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesOffdockCYFreeDayHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesOffdockCYFreeDayHistory
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesOffdockCYFreeDayHistoryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lgs_cost_subj_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sto_dys_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_from_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_inv_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_tml_calc_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesOffdockCYFreeDayHistoryRSQL").append("\n"); 
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
		query.append("SELECT H.YD_CD" ).append("\n"); 
		query.append("     , H.VNDR_SEQ" ).append("\n"); 
		query.append("     , H.INV_NO" ).append("\n"); 
		query.append("     , TO_CHAR(H.ISS_DT,'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("     , H.FM_PRD_DT" ).append("\n"); 
		query.append("     , H.TO_PRD_DT" ).append("\n"); 
		query.append("     , H.STO_DYS_IND_CD   --S/D Ind" ).append("\n"); 
		query.append("     , D.CALC_TP_CD       --Cal. Type" ).append("\n"); 
		query.append("     , D.LGS_COST_CD      --Cost Code" ).append("\n"); 
		query.append("     , D.CNTR_TPSZ_CD     --Type/Size" ).append("\n"); 
		query.append("     , D.IO_BND_CD        --I/O" ).append("\n"); 
		query.append("     , D.DCGO_IND_CD      --DG" ).append("\n"); 
		query.append("     , D.CNTR_NO          --CNTR" ).append("\n"); 
		query.append("     , D.REV_YRMON        --Year/Month     " ).append("\n"); 
		query.append("     , D.STAY_DYS         --Stay days" ).append("\n"); 
		query.append("     , D.FREE_DYS         --F/Days" ).append("\n"); 
		query.append("     , D.PAY_DYS          --Pay days" ).append("\n"); 
		query.append("     , D.FREE_DY_XCLD_DYS --Exclude days" ).append("\n"); 
		query.append("     , D.OVR_DYS          --Over days" ).append("\n"); 
		query.append("     , D.VOL_TR_UT_CD     --Uom" ).append("\n"); 
		query.append("     , D.CTRT_RT          --Rate" ).append("\n"); 
		query.append("     , D.CURR_CD          --Curr" ).append("\n"); 
		query.append("     , D.INV_XCH_RT       --Ex. Rate" ).append("\n"); 
		query.append("     , D.INV_AMT          --Inv Amt" ).append("\n"); 
		query.append("     , D.CALC_RMK         --Remark" ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("    , TES_TML_SO_DTL D" ).append("\n"); 
		query.append(" WHERE H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND H.TML_SO_SEQ        = D.TML_SO_SEQ" ).append("\n"); 
		query.append("   AND H.TML_INV_TP_CD     = 'OF'" ).append("\n"); 
		query.append("   AND D.CALC_COST_GRP_CD  = 'SD' --Storage by Free Day" ).append("\n"); 
		query.append("   AND H.INV_CFM_DT BETWEEN TO_DATE(REPLACE(@[s_from_inv_cfm_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[s_to_inv_cfm_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("   AND H.YD_CD             = @[s_loc_cd]||@[s_nod_cd]" ).append("\n"); 
		query.append("#if (${s_vndr_seq} != '')" ).append("\n"); 
		query.append("   AND H.VNDR_SEQ          = @[s_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_inv_ofc_cd} != '')" ).append("\n"); 
		query.append("   AND H.INV_OFC_CD        = @[s_inv_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_calc_tp_cd} != '')" ).append("\n"); 
		query.append("   AND D.CALC_TP_CD        = @[s_calc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_lgs_cost_subj_cd} != '')" ).append("\n"); 
		query.append("   AND SUBSTR(D.LGS_COST_CD, 1, 2) = @[s_lgs_cost_subj_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ($lgs_cost_dtl_cds.size() > 0)" ).append("\n"); 
		query.append("  AND D.LGS_COST_CD IN (" ).append("\n"); 
		query.append("  #foreach($key in ${lgs_cost_dtl_cds}) " ).append("\n"); 
		query.append("    #if($velocityCount < $lgs_cost_dtl_cds.size()) " ).append("\n"); 
		query.append("      '$key', " ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("      '$key' " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_tml_calc_ind_cd} != '')" ).append("\n"); 
		query.append("   AND H.TML_CALC_IND_CD = @[s_tml_calc_ind_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_sto_dys_ind_cd} != '')" ).append("\n"); 
		query.append("   AND H.STO_DYS_IND_CD  = @[s_sto_dys_ind_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_calc_tp_cd} != '')" ).append("\n"); 
		query.append("   AND D.CALC_TP_CD      = @[s_calc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY H.YD_CD" ).append("\n"); 
		query.append("       , H.VNDR_SEQ" ).append("\n"); 
		query.append("       , H.INV_NO" ).append("\n"); 

	}
}