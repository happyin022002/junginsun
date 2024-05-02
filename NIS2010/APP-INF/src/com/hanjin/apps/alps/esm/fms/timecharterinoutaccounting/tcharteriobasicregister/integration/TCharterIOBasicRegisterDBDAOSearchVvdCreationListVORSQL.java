/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.09 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vvd Creation List
	  * </pre>
	  */
	public TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.integration").append("\n"); 
		query.append("FileName : TCharterIOBasicRegisterDBDAOSearchVvdCreationListVORSQL").append("\n"); 
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
		query.append("SELECT 	'I' ibflag," ).append("\n"); 
		query.append("A.REV_YRMON, A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.RLANE_DIR_CD REV_DIR_CD,A.SLAN_CD,A.RLANE_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.RLANE_DIR_CD VVD_CD," ).append("\n"); 
		query.append("TO_CHAR(DECODE(CS.VPS_ETD_DT,NULL, FMS_VVDDT_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.ST_PORT_CD),CS.VPS_ETD_DT),'YYYYMMDD') VST_DT," ).append("\n"); 
		query.append("TO_CHAR(DECODE(CE.VPS_ETD_DT,NULL, FMS_VVDDT_FNC(A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.FNL_PORT_CD),CE.VPS_ETD_DT),'YYYYMMDD') VED_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT 	DISTINCT AR.REV_YRMON, AR.VSL_CD,AR.SKD_VOY_NO,AR.SKD_DIR_CD,AR.RLANE_DIR_CD,AR.SLAN_CD,AR.RLANE_CD," ).append("\n"); 
		query.append("B.ST_PORT_CD, B.FNL_PORT_CD" ).append("\n"); 
		query.append("FROM   	FMS_BSE_PORT B," ).append("\n"); 
		query.append("(SELECT VSL_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE  FLET_CTRT_TP_CD = 'TI' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT FI.VSL_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FLET_CTRT_TP_CD = 'TI' AND FC.FLET_CTRT_FACT_CD = 'ACT' AND FI.USE_FLG = 'Y') FC, AR_MST_REV_VVD AR" ).append("\n"); 
		query.append("WHERE  	FC.VSL_CD		= AR.VSL_CD" ).append("\n"); 
		query.append("AND    	AR.REV_YRMON	= @[rev_yrmon]" ).append("\n"); 
		query.append("AND		AR.RLANE_CD      = B.RLANE_CD(+)" ).append("\n"); 
		query.append("AND		AR.SKD_DIR_CD  	= B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND		AR.RLANE_DIR_CD	= B.REV_DIR_CD(+)" ).append("\n"); 
		query.append("AND		AR.SLAN_CD	= B.SLAN_CD(+)) A," ).append("\n"); 
		query.append("(SELECT AR.VSL_CD, AR.SKD_VOY_NO, AR.SKD_DIR_CD, AR.SLAN_CD, B.VPS_PORT_CD," ).append("\n"); 
		query.append("MAX(B.VPS_ETD_DT) VPS_ETD_DT" ).append("\n"); 
		query.append("FROM   AR_MST_REV_VVD AR,  VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE  AR.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    AR.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    AR.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    AR.REV_YRMON	= @[rev_yrmon]" ).append("\n"); 
		query.append("AND    NVL(B.SKD_CNG_STS_CD,'Z') <> 'S'" ).append("\n"); 
		query.append("AND	EXISTS (SELECT NULL FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE  VSL_CD = AR.VSL_CD AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NULL FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FI.VSL_CD = AR.VSL_CD AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT' AND FI.USE_FLG = 'Y')" ).append("\n"); 
		query.append("GROUP BY AR.VSL_CD, AR.SKD_VOY_NO, AR.SKD_DIR_CD, AR.SLAN_CD, B.VPS_PORT_CD) CS," ).append("\n"); 
		query.append("(SELECT AR.VSL_CD, AR.SKD_VOY_NO, AR.SKD_DIR_CD, AR.SLAN_CD, B.VPS_PORT_CD," ).append("\n"); 
		query.append("MAX(B.VPS_ETD_DT) VPS_ETD_DT" ).append("\n"); 
		query.append("FROM   AR_MST_REV_VVD AR,  VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE  AR.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND    AR.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    AR.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    AR.REV_YRMON	= @[rev_yrmon]" ).append("\n"); 
		query.append("AND    NVL(B.SKD_CNG_STS_CD,'Z') <> 'S'" ).append("\n"); 
		query.append("AND	EXISTS (SELECT NULL FROM FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE  VSL_CD = AR.VSL_CD AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NULL FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("WHERE FI.VSL_CD = AR.VSL_CD AND FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND FC.FLET_CTRT_FACT_CD = 'ACT' AND FI.USE_FLG = 'Y')" ).append("\n"); 
		query.append("GROUP BY AR.VSL_CD, AR.SKD_VOY_NO, AR.SKD_DIR_CD, AR.SLAN_CD, B.VPS_PORT_CD) CE" ).append("\n"); 
		query.append("WHERE 	A.VSL_CD = CS.VSL_CD(+)" ).append("\n"); 
		query.append("AND		A.SKD_VOY_NO = CS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND		A.SKD_DIR_CD = CS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND		A.SLAN_CD = CS.SLAN_CD(+)" ).append("\n"); 
		query.append("AND		A.ST_PORT_CD = CS.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND 	A.VSL_CD = CE.VSL_CD(+)" ).append("\n"); 
		query.append("AND		A.SKD_VOY_NO = CE.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND		A.SKD_DIR_CD = CE.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND		A.SLAN_CD = CE.SLAN_CD(+)" ).append("\n"); 
		query.append("AND		A.FNL_PORT_CD = CE.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("ORDER BY 2,3,4,5" ).append("\n"); 

	}
}