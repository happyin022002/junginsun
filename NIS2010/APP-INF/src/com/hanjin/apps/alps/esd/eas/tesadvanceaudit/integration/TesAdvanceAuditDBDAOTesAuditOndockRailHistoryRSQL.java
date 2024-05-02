/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesAuditOndockRailHistoryRSQL.java
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

public class TesAdvanceAuditDBDAOTesAuditOndockRailHistoryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesAuditOndockRailHistory
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesAuditOndockRailHistoryRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesAuditOndockRailHistoryRSQL").append("\n"); 
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
		query.append("     , D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("     , D.IO_BND_CD" ).append("\n"); 
		query.append("     , TO_CHAR(D.ATB_DT,'YYYY-MM-DD') AS ATB_DT" ).append("\n"); 
		query.append("     , D.CALC_TP_CD" ).append("\n"); 
		query.append("     , D.LGS_COST_CD" ).append("\n"); 
		query.append("     , D.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , D.DCGO_IND_CD" ).append("\n"); 
		query.append("     , D.RC_FLG" ).append("\n"); 
		query.append("     , D.TML_WRK_DY_CD     --Applied Date" ).append("\n"); 
		query.append("     , D.IOC_CD            --IPC" ).append("\n"); 
		query.append("     , D.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("     , D.LANE_CD" ).append("\n"); 
		query.append("     , NVL(FM_TR_VOL_VAL,'1')||' ~ '||NVL(TO_TR_VOL_VAL,'99999') AS TIER" ).append("\n"); 
		query.append("     , D.CALC_VOL_QTY" ).append("\n"); 
		query.append("     , D.RVIS_VOL_QTY" ).append("\n"); 
		query.append("     , D.VOL_TR_UT_CD" ).append("\n"); 
		query.append("     , D.CTRT_RT" ).append("\n"); 
		query.append("     , D.CURR_CD" ).append("\n"); 
		query.append("     , D.INV_XCH_RT" ).append("\n"); 
		query.append("     , D.INV_AMT" ).append("\n"); 
		query.append("     , D.CALC_RMK" ).append("\n"); 
		query.append("     , D.N3PTY_FLG" ).append("\n"); 
		query.append(" FROM TES_TML_SO_HDR H" ).append("\n"); 
		query.append("    , TES_TML_SO_DTL D" ).append("\n"); 
		query.append(" WHERE H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("   AND H.TML_SO_SEQ        = D.TML_SO_SEQ" ).append("\n"); 
		query.append("   AND H.TML_INV_TP_CD     = 'ON'" ).append("\n"); 
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
		query.append("ORDER BY  H.YD_CD, H.VNDR_SEQ" ).append("\n"); 

	}
}