/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQMatchBackNLoadFactorFinderDAOSearchMBByVesselVvdListByTradeLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.21 문중철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Mun Jung Cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorFinderDAOSearchMBByVesselVvdListByTradeLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMBByVesselVvdListByTradeLane
	  * </pre>
	  */
	public EQMatchBackNLoadFactorFinderDAOSearchMBByVesselVvdListByTradeLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromdate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorFinderDAOSearchMBByVesselVvdListByTradeLaneRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT Z.VVD FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("/*+ ORDERED USE_NL( VPS1 VPS2 )" ).append("\n"); 
		query.append("INDEX( VPS1 XAK2VSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("INDEX( VPS2 XAK4VSK_VSL_PORT_SKD )" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("DISTINCT NVL( VPS1.VSL_CD||VPS1.SKD_VOY_NO||VPS1.SKD_DIR_CD , '' ) VVD" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD VPS1," ).append("\n"); 
		query.append("VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	DISTINCT TRD_CD, SUBSTR(RLANE_CD,1, 3) LANE_CD" ).append("\n"); 
		query.append("FROM	BSA_VVD_MST   -- 108 건" ).append("\n"); 
		query.append(") BSA" ).append("\n"); 
		query.append("WHERE	NVL(VPS1.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("AND		NVL(VPS1.TURN_PORT_IND_CD,	' ') NOT IN ('D', 'F', 'V')" ).append("\n"); 
		query.append("AND		NVL(VPS1.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("AND		VPS1.SLAN_CD			=	LANE_CD" ).append("\n"); 
		query.append("AND		VPS2.VSL_CD				=	VPS1.VSL_CD" ).append("\n"); 
		query.append("AND		VPS2.SKD_VOY_NO			=	VPS1.SKD_VOY_NO" ).append("\n"); 
		query.append("AND		VPS2.SKD_DIR_CD			=	VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append("AND		VPS2.CLPT_SEQ			>	VPS1.CLPT_SEQ" ).append("\n"); 
		query.append("AND		NVL(VPS2.VPS_PORT_CD,		' ') NOT IN ('PAPAC', 'EGSUZ')" ).append("\n"); 
		query.append("AND		NVL(VPS2.SKD_CNG_STS_CD,	' ') <> 'S'" ).append("\n"); 
		query.append("AND		VPS1.VPS_ETD_DT BETWEEN TO_DATE(@[fromdate], 'YYYY-MM-DD')                    /* :from Date */" ).append("\n"); 
		query.append("AND								TO_DATE(@[todate], 'YYYY-MM-DD') + 0.99999          /* :to date   */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* ___________________________________________________> Trade Code */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == '' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	=	BSA.TRD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'IMS' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	IN ( 'TAS','TPS' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'IES' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	IN ( 'AES','TAS' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'AES' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	=  'AES'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'TPS' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	=  'TPS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${trade} == 'TAS' )" ).append("\n"); 
		query.append("AND		BSA.TRD_CD	=  'TAS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* ___________________________________________________> Trade Code */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${lane} != '' )" ).append("\n"); 
		query.append("AND		BSA.LANE_CD = @[lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--ORDER BY VPS1.VSL_CD||VPS1.SKD_VOY_NO||VPS1.SKD_DIR_CD" ).append("\n"); 
		query.append(") Z" ).append("\n"); 
		query.append("ORDER BY Z.VVD" ).append("\n"); 

	}
}