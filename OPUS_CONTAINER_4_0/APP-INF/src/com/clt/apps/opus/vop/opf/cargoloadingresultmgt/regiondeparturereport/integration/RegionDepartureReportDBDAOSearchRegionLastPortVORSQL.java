/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RegionDepartureReportDBDAOSearchRegionLastPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOSearchRegionLastPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.29 이준범 [CHM-201111792-01]
	  * 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
	  * 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
	  *           2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
	  *              해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리 
	  * </pre>
	  */
	public RegionDepartureReportDBDAOSearchRegionLastPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOSearchRegionLastPortVORSQL").append("\n"); 
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
		query.append("SELECT      YY.REGION_CD   AS REGION" ).append("\n"); 
		query.append("        --    YY.SCONTI_CD AS REGION" ).append("\n"); 
		query.append("        ,   YY.VPS_PORT_CD AS VAL" ).append("\n"); 
		query.append("        --,   YY.VPS_PORT_CD || '|' || ( SELECT  LOC_NM FROM MDM_LOCATION WHERE LOC_CD = YY.VPS_PORT_CD ) AS NAME" ).append("\n"); 
		query.append("        ,   ( SELECT  LOC_NM FROM MDM_LOCATION WHERE LOC_CD = YY.VPS_PORT_CD ) AS NAME" ).append("\n"); 
		query.append("        ,   YY.YD_CD" ).append("\n"); 
		query.append("        ,   YY.CLPT_IND_SEQ AS CALL_IND " ).append("\n"); 
		query.append("        ,   YY.CLPT_SEQ" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            SELECT      XX.*" ).append("\n"); 
		query.append("                    ,   RANK() OVER (PARTITION BY XX.REGION_CD ORDER BY XX.CLPT_SEQ DESC) REGION_PORT_SEQ" ).append("\n"); 
		query.append("            FROM        ( " ).append("\n"); 
		query.append("                        SELECT      PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                ,   PS.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("                                ,   PS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                                --,   CASE WHEN SC.CONTI_CD = 'A' AND CC.CNT_CD    = 'AO' THEN 'T'   -- [T : AUSTRALIA]      " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'A' AND SC.SCONTI_CD = 'AM' THEN 'D'   -- [D : MIDDLE EAST]    " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'A'                         THEN 'A'   -- [A : ASIA]          " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'M' AND SC.SCONTI_CD = 'MS' THEN 'S'   -- [M : SOUTH AMERICA]  " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'M'                         THEN 'M'   -- [M : AMERICA]        " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'E'                         THEN 'E'   -- [E : EUROPE]        " ).append("\n"); 
		query.append("                                --         WHEN SC.CONTI_CD = 'F'                         THEN 'F'   -- [F : AFRICA]        " ).append("\n"); 
		query.append("                                --         ELSE 'O'                                                  -- [O : OTHER]            " ).append("\n"); 
		query.append("                                --    END  AS REGION_CD" ).append("\n"); 
		query.append("                                ,   SC.RDR_RGN_CD AS REGION_CD" ).append("\n"); 
		query.append("                                ,   SC.CONTI_CD   " ).append("\n"); 
		query.append("                                ,   CC.SCONTI_CD          " ).append("\n"); 
		query.append("                                ,   CC.CNT_CD   " ).append("\n"); 
		query.append("                                ,   PS.VPS_PORT_CD  " ).append("\n"); 
		query.append("                                ,   PS.YD_CD     " ).append("\n"); 
		query.append("                                ,   PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                ,   PS.CLPT_SEQ" ).append("\n"); 
		query.append("                        FROM        VSK_VSL_PORT_SKD           	PS" ).append("\n"); 
		query.append("                                --,   MDM_COUNTRY                	CC " ).append("\n"); 
		query.append("                                ,   MDM_LOCATION                CC " ).append("\n"); 
		query.append("                                --,   MDM_SUBCONTINENT           	SC" ).append("\n"); 
		query.append("                                ,   OPF_RDR_RGN_CD           	SC" ).append("\n"); 
		query.append("                        WHERE       1 = 1                           " ).append("\n"); 
		query.append("                        --AND         SUBSTR(PS.VPS_PORT_CD,1,2) 	= CC.CNT_CD" ).append("\n"); 
		query.append("                        AND         PS.VPS_PORT_CD 	            = CC.LOC_CD" ).append("\n"); 
		query.append("                        AND         CC.SCONTI_CD               	= SC.SCONTI_CD" ).append("\n"); 
		query.append("                        AND         PS.VSL_CD                  	= @[vsl_cd]   -- 변수매핑" ).append("\n"); 
		query.append("                        AND         PS.SKD_VOY_NO              	= @[voy_no]   -- 변수매핑" ).append("\n"); 
		query.append("                        AND         PS.SKD_DIR_CD              	= @[dir_cd]   -- 변수매핑" ).append("\n"); 
		query.append("                        AND         PS.TURN_PORT_IND_CD   		IN ('Y', 'N') " ).append("\n"); 
		query.append("                                    --  Y : Port Change " ).append("\n"); 
		query.append("                                    --  N : *Normal Port " ).append("\n"); 
		query.append("                                    --  D : Direction Change " ).append("\n"); 
		query.append("                                    --  V : Voyage Change" ).append("\n"); 
		query.append("                                    --  F : Final Port " ).append("\n"); 
		query.append("                        AND         NVL(PS.SKD_CNG_STS_CD, '*') <> 'S'  " ).append("\n"); 
		query.append("                                    --  A : Additional calling " ).append("\n"); 
		query.append("                                    --  I : Phase In " ).append("\n"); 
		query.append("                                    --  O : Phase Out " ).append("\n"); 
		query.append("                                    --  S : Skip Calling " ).append("\n"); 
		query.append("                        AND         PS.VPS_PORT_CD        		NOT IN ('PAPCA', 'EGSCA') " ).append("\n"); 
		query.append("                        AND         PS.VT_ADD_CALL_FLG IS NULL" ).append("\n"); 
		query.append("                        ) XX " ).append("\n"); 
		query.append("            ) YY                     " ).append("\n"); 
		query.append("WHERE       YY.REGION_PORT_SEQ       = 1  " ).append("\n"); 
		query.append("ORDER BY    YY.CLPT_SEQ              ASC" ).append("\n"); 

	}
}