/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetOusTdrSlotPriceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOGetOusTdrSlotPriceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OUS TDR의 경우 VVD, From Port, To Port변경시 Slot Price정보를 조회한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetOusTdrSlotPriceRSQL(){
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
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetOusTdrSlotPriceRSQL").append("\n"); 
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
		query.append("SELECT MAX(CD.UC_AMT) AS BSA_SLT_PRC" ).append("\n"); 
		query.append("  FROM BSA_OVR_USD_MST CM," ).append("\n"); 
		query.append("       BSA_OVR_USD_SLT_PRC CD" ).append("\n"); 
		query.append(" WHERE CM.OVR_USD_SLT_PRC_SEQ = CD.OVR_USD_SLT_PRC_SEQ" ).append("\n"); 
		query.append("   AND CD.UC_AMT    <> 0" ).append("\n"); 
		query.append("   AND CM.DELT_FLG   = 'N' " ).append("\n"); 
		query.append("#if(${re_divr_cd} != '' &&  ${re_divr_cd}=='R')   " ).append("\n"); 
		query.append("	AND CD.CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("#elseif (${re_divr_cd} != '' &&  ${re_divr_cd} == 'E') " ).append("\n"); 
		query.append("    AND CD.CRR_CD   = 'XXX'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CM.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("   AND CM.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("   AND CM.DIR_CD     = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(@[uc_bss_port_etd_dt],1,8) BETWEEN CM.BSA_SLT_PRC_FM_DT AND CM.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("   AND CM.FM_PORT_CD = @[fm_port_cd]" ).append("\n"); 
		query.append("   AND CM.TO_PORT_CD = @[to_port_cd]" ).append("\n"); 
		query.append("--2010.03.02 박효숙 차장...TDR의 OverUsedSlotPrice는 R/E상관없이 MAX값을 가져와라" ).append("\n"); 
		query.append("--if(re_divr_cd =='R')" ).append("\n"); 
		query.append("--   AND CD.BSA_OP_JB_CD IN ('001','002','004')" ).append("\n"); 
		query.append("--elseif(re_divr_cd =='E')" ).append("\n"); 
		query.append("--   AND CD.BSA_OP_JB_CD IN ('000','003','005')" ).append("\n"); 
		query.append("--end" ).append("\n"); 

	}
}