/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOGetRfIOChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.23 
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

public class CarrierSettlementProcessDBDAOGetRfIOChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Interport/Ocean 변경시 Reefer Surcharge를 조회한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOGetRfIOChangeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOGetRfIOChangeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.IOC_CD," ).append("\n"); 
		query.append("       NVL(B.RF_SCG_PRC_20,0) AS RF_SCG_PRC_20," ).append("\n"); 
		query.append("       NVL(B.RF_SCG_PRC_40,0) AS RF_SCG_PRC_40" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("#if (${ioc_cd} == 'A' || ${ioc_cd} == 'O')" ).append("\n"); 
		query.append("         SELECT 'O' AS IOC_CD" ).append("\n"); 
		query.append("         FROM   DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ioc_cd} == 'A')" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ioc_cd} == 'A' || ${ioc_cd} == 'I')" ).append("\n"); 
		query.append("         SELECT 'I' AS IOC_CD" ).append("\n"); 
		query.append("         FROM   DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("#if (${rf_scg_stl_tp_cd} == 'T')" ).append("\n"); 
		query.append("--2010.01.21 박효숙차장 TDR인 경우 Inter/Ocean 구분이 없으며 Long Leg(Ocean = 018)을 가져와야함" ).append("\n"); 
		query.append("              DECODE(M.BSA_SLT_COST_TP_CD,'018','I') AS IOC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              DECODE(M.BSA_SLT_COST_TP_CD,'018','O','019','I') AS IOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'T', D.UC_AMT, 0)) RF_SCG_PRC_20" ).append("\n"); 
		query.append("            , SUM(DECODE(M.RT_TEU_FLG, 'A', D.UC_AMT, 'F', D.UC_AMT, 0)) RF_SCG_PRC_40" ).append("\n"); 
		query.append("         FROM BSA_RF_SCG_MST M" ).append("\n"); 
		query.append("            , BSA_RF_SCG_SLT_PRC D" ).append("\n"); 
		query.append("        WHERE M.BSA_SLT_COST_TP_CD = D.BSA_SLT_COST_TP_CD" ).append("\n"); 
		query.append("          AND M.RF_SCG_SLT_PRC_SEQ = D.RF_SCG_SLT_PRC_SEQ" ).append("\n"); 
		query.append("          AND M.TRD_CD             = D.TRD_CD" ).append("\n"); 
		query.append("          AND M.RLANE_CD           = D.RLANE_CD" ).append("\n"); 
		query.append("          AND M.DIR_CD             = D.DIR_CD" ).append("\n"); 
		query.append("          AND D.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("          AND D.RLANE_CD           = @[rlane_cd]" ).append("\n"); 
		query.append("          AND D.DIR_CD             = @[skd_dir_cd]" ).append("\n"); 
		query.append("          AND D.CRR_CD             = @[jo_crr_cd]" ).append("\n"); 
		query.append("          AND M.DELT_FLG           = 'N'" ).append("\n"); 
		query.append("          AND SUBSTR(@[uc_bss_port_etd_dt],1,8) BETWEEN M.BSA_SLT_PRC_FM_DT AND M.BSA_SLT_PRC_TO_DT" ).append("\n"); 
		query.append("#if (${rf_scg_stl_tp_cd} == 'T')" ).append("\n"); 
		query.append("          AND M.BSA_SLT_COST_TP_CD = '018'" ).append("\n"); 
		query.append("        GROUP BY DECODE(M.BSA_SLT_COST_TP_CD,'018','I')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND M.BSA_SLT_COST_TP_CD IN ('018','019')" ).append("\n"); 
		query.append("        GROUP BY DECODE(M.BSA_SLT_COST_TP_CD,'018','O','019','I')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 
		query.append("WHERE  A.IOC_CD = B.IOC_CD (+)" ).append("\n"); 
		query.append("ORDER  BY A.IOC_CD DESC" ).append("\n"); 

	}
}