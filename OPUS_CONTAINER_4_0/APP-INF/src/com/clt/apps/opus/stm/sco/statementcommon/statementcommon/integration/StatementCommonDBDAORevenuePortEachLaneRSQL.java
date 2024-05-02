/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : StatementCommonDBDAORevenuePortEachLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAORevenuePortEachLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search RevenuePortEachLane
	  * </pre>
	  */
	public StatementCommonDBDAORevenuePortEachLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration").append("\n"); 
		query.append("FileName : StatementCommonDBDAORevenuePortEachLaneRSQL").append("\n"); 
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
		query.append("SELECT  AAA.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("    ,   AAA.RLANE_CD" ).append("\n"); 
		query.append("    ,   AAA.RLANE_NM" ).append("\n"); 
		query.append("    ,   NVL(BBB.FINC_REV_DIR_CD, AAA.VSL_SLAN_DIR_CD || AAA.RLANE_DIR_CD) AS FINC_REV_DIR_CD" ).append("\n"); 
		query.append("    ,   NVL(BBB.REV_IPT_OCN_CD, AAA.ZN_IOC_CD)  AS  REV_IPT_OCN_CD" ).append("\n"); 
		query.append(" 	,   NVL(BBB.REV_IPT_OCN_CD, AAA.ZN_IOC_CD)  AS  H_REV_IPT_OCN_CD" ).append("\n"); 
		query.append("    ,   BBB.REV_PORT_CD" ).append("\n"); 
		query.append(" 	, 	DECODE(AAA.VSL_SLAN_DIR_CD, AAA.RLANE_DIR_CD, 'N', 'Y')  AS DIR_CNG_CD" ).append("\n"); 
		query.append(" 	, 	NVL(BBB.DELT_FLG, 'N') AS DELT_FLG" ).append("\n"); 
		query.append(" 	, 	'' AS CRE_USR_ID" ).append("\n"); 
		query.append(" 	, 	'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  DISTINCT" ).append("\n"); 
		query.append("            B.VSL_SLAN_CD    " ).append("\n"); 
		query.append("        ,   A.RLANE_CD" ).append("\n"); 
		query.append("        ,   A.RLANE_NM" ).append("\n"); 
		query.append("        ,   C.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("        ,   NVL" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                    SELECT  DISTINCT" ).append("\n"); 
		query.append("                            AFDC.RLANE_DIR_CD" ).append("\n"); 
		query.append("                    FROM    AR_FINC_DIR_CONV    AFDC" ).append("\n"); 
		query.append("                    WHERE   AFDC.SLAN_CD       = C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                      AND   AFDC.SLAN_DIR_CD   = C.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                      AND   AFDC.RLANE_CD      = A.RLANE_CD" ).append("\n"); 
		query.append("                      AND   NVL(AFDC.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                      AND   ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                ," ).append("\n"); 
		query.append("                VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("            ) AS   RLANE_DIR_CD" ).append("\n"); 
		query.append("        ,   D.ZN_IOC_CD" ).append("\n"); 
		query.append("    FROM    MDM_REV_LANE            A" ).append("\n"); 
		query.append("        ,   MDM_VSL_SVC_LANE        B" ).append("\n"); 
		query.append("        ,   MDM_VSL_SVC_LANE_DIR    C" ).append("\n"); 
		query.append("        ,   AR_ROUT_RNK             D" ).append("\n"); 
		query.append("    WHERE   1 = 1" ).append("\n"); 
		query.append("      AND   A.VSL_TP_CD         =   B.VSL_TP_CD" ).append("\n"); 
		query.append("      AND   A.VSL_SLAN_CD       =   B.VSL_SLAN_CD" ).append("\n"); 
		query.append("      AND   B.VSL_SLAN_CD       =   C.VSL_SLAN_CD" ).append("\n"); 
		query.append("      AND   D.RLANE_CD          =   A.RLANE_CD" ).append("\n"); 
		query.append("      AND   D.SLAN_CD           =   A.VSL_SLAN_CD" ).append("\n"); 
		query.append("      AND   B.VSL_SLAN_CD LIKE DECODE(@[vsl_slan_cd], NULL, '', @[vsl_slan_cd]) || '%'" ).append("\n"); 
		query.append("      AND   A.RLANE_CD LIKE DECODE(@[rlane_cd], NULL, '', @[rlane_cd]) || '%'" ).append("\n"); 
		query.append("      AND   NVL(A.DELT_FLG      , 'N')  <> 'Y'" ).append("\n"); 
		query.append("      AND   NVL(B.DELT_FLG      , 'N')  <> 'Y'" ).append("\n"); 
		query.append("      AND   NVL(C.DELT_FLG      , 'N')  <> 'Y'" ).append("\n"); 
		query.append("      AND   NVL(D.DELT_FLG      , 'N')  <> 'Y'" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append(",   " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        SELECT  SRLPI.SLAN_CD" ).append("\n"); 
		query.append("            ,   SRLPI.RLANE_CD" ).append("\n"); 
		query.append("            ,   SRLPI.REV_IPT_OCN_CD" ).append("\n"); 
		query.append("            ,   SRLPI.REV_PORT_CD" ).append("\n"); 
		query.append("            ,   SRLPI.FINC_REV_DIR_CD" ).append("\n"); 
		query.append("   ,   SRLPI.DELT_FLG" ).append("\n"); 
		query.append("        FROM    SCO_REV_LANE_PORT_INFO  SRLPI" ).append("\n"); 
		query.append("        WHERE   NVL(SRLPI.DELT_FLG, 'N')  <> 'Y'" ).append("\n"); 
		query.append(")   BBB" ).append("\n"); 
		query.append("WHERE   AAA.VSL_SLAN_CD     =   BBB.SLAN_CD(+)" ).append("\n"); 
		query.append("  AND   AAA.RLANE_CD        =   BBB.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND   AAA.VSL_SLAN_DIR_CD =   SUBSTR(BBB.FINC_REV_DIR_CD(+),1,1)" ).append("\n"); 
		query.append("  AND   AAA.ZN_IOC_CD       =   BBB.REV_IPT_OCN_CD(+)" ).append("\n"); 
		query.append("ORDER BY    VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,   RLANE_CD" ).append("\n"); 
		query.append("        ,   VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("        ,   RLANE_DIR_CD" ).append("\n"); 
		query.append("        ,   AAA.ZN_IOC_CD   DESC" ).append("\n"); 
		query.append("        ,   BBB.REV_PORT_CD" ).append("\n"); 

	}
}