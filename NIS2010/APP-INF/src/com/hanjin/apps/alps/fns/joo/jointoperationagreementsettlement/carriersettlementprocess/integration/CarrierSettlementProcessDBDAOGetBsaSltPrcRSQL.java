/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetBsaSltPrcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetBsaSltPrcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS RDR Inter/Ocean 변경시 단가를 가져온다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetBsaSltPrcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_bss_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetBsaSltPrcRSQL").append("\n"); 
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
		query.append("SELECT SUM(CP.UC_AMT) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("  FROM BSA_OCN_OVR_SLT_PRC CP," ).append("\n"); 
		query.append("       BSA_OCN_OVR_MST     CM" ).append("\n"); 
		query.append(" WHERE CM.BSA_SLT_COST_TP_CD  = CP.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("   AND CM.OVR_USD_SLT_PRC_SEQ = CP.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("   AND CM.TRD_CD              = CP.TRD_CD" ).append("\n"); 
		query.append("   AND CM.RLANE_CD            = CP.RLANE_CD" ).append("\n"); 
		query.append("   AND CM.DIR_CD              = CP.DIR_CD" ).append("\n"); 
		query.append("   AND CP.TRD_CD   = @[trd_cd]" ).append("\n"); 
		query.append("   AND CP.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   AND CP.CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND CP.DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND CP.BSA_SLT_COST_TP_CD = DECODE(@[ioc_cd],'O','020','I','021')" ).append("\n"); 
		query.append("   AND SUBSTR(@[uc_bss_port_etd_dt],1,8) BETWEEN CM.BSA_SLT_PRC_FM_DT AND CM.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("   AND CM.DELT_FLG = 'N'" ).append("\n"); 

	}
}