/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchKPIRHQCodeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.28
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.04.28 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchKPIRHQCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 KPI에 속해 있는 RHQ Code를 조회 한다.
	  * History------------------------------------------------------------------------------------
	  * 2012.02.20 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
	  * 2012.07.09 문동선 [CHM-201218855-01] Base line 입력화면 추가
	  * 2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchKPIRHQCodeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_tgt_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchKPIRHQCodeListRSQL").append("\n"); 
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
		query.append("#if(${tab_chk}=='KPI'||${tab_chk}=='')" ).append("\n"); 
		query.append("SELECT  RHQ_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  (" ).append("\n"); 
		query.append("                SELECT  O.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("--						CASE WHEN CONTI_CD  IN ('E','F') AND LOC_CD NOT IN ('EGAIS','ZADUR','RUVVO')      THEN 'HAMRU'" ).append("\n"); 
		query.append("--                        WHEN CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                        WHEN CONTI_CD = 'A' AND SCONTI_CD = 'AF'  THEN DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                        WHEN (CONTI_CD = 'A'        AND SCONTI_CD <> 'AF') OR LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--						WHEN CONTI_CD  IN ('E') AND LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                        ELSE ''" ).append("\n"); 
		query.append("--                        END" ).append("\n"); 
		query.append("                FROM    MDM_LOCATION    S, MAS_OFC_LVL O" ).append("\n"); 
		query.append("                WHERE   S.LOC_CD = T.VPS_PORT_CD" ).append("\n"); 
		query.append("                	AND S.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                	AND S.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                	AND S.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                	AND O.OFC_APLY_TO_YRMON ='999912'" ).append("\n"); 
		query.append("                	AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                ) AS RHQ_CD" ).append("\n"); 
		query.append("        FROM    OPF_PORT_TM_KPI T" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     KPI_TGT_YR        = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("        AND     KPI_VER_SEQ       = @[kpi_ver_seq]    -- Version Sequence 입력시에만 수행" ).append("\n"); 
		query.append("#if(${slan_cd} != '')" ).append("\n"); 
		query.append("        AND     SLAN_CD           = @[slan_cd]        -- Service Lane Code 입력시에만 수행" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vps_port_cd} != '')" ).append("\n"); 
		query.append("        AND     VPS_PORT_CD       = @[vps_port_cd]    -- Port Code 입력시에만 수행" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY RHQ_CD" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${tab_chk}=='BSEL')" ).append("\n"); 
		query.append("SELECT  RHQ_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  (" ).append("\n"); 
		query.append("                SELECT  O.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("--						CASE WHEN CONTI_CD  IN ('E','F') AND LOC_CD NOT IN ('EGAIS','ZADUR','RUVVO')      THEN 'HAMRU'" ).append("\n"); 
		query.append("--                        WHEN CONTI_CD  = 'M'                                                              THEN 'NYCRA'" ).append("\n"); 
		query.append("--                        WHEN CONTI_CD = 'A' AND SCONTI_CD = 'AF' THEN  DECODE(CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                        WHEN (CONTI_CD = 'A'        AND SCONTI_CD <> 'AF') OR LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--						WHEN CONTI_CD  IN ('E') AND LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                        ELSE ''" ).append("\n"); 
		query.append("--                        END" ).append("\n"); 
		query.append("                FROM    MDM_LOCATION    S, MAS_OFC_LVL O" ).append("\n"); 
		query.append("                WHERE   S.LOC_CD = T.VPS_PORT_CD" ).append("\n"); 
		query.append("                	AND S.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                	AND S.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                	AND S.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                	AND O.OFC_APLY_TO_YRMON ='999912'" ).append("\n"); 
		query.append("                	AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("                ) AS RHQ_CD" ).append("\n"); 
		query.append("        FROM    OPF_PORT_TM_BSEL T" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     BSEL_YR        = @[kpi_tgt_yr]" ).append("\n"); 
		query.append("#if(${slan_cd} != '')" ).append("\n"); 
		query.append("        AND     SLAN_CD           = @[slan_cd]        -- Service Lane Code 입력시에만 수행" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${vps_port_cd} != '')" ).append("\n"); 
		query.append("        AND     VPS_PORT_CD       = @[vps_port_cd]    -- Port Code 입력시에만 수행" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY RHQ_CD" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}