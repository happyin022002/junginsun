/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL
	  * 1. 2011.07.04 이수진 [CHM-201111709] PRD > Network Constraint 관련 data upload 및 기능개선 요청
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdMstByRoutCnstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append("SET (CNST_FLG ,    ROUT_CNST_SEQ)" ).append("\n"); 
		query.append(" = (" ).append("\n"); 
		query.append("         SELECT ROUT_CNST_FLG, ROUT_CNST_SEQ " ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("        SELECT MST.PCTL_NO, R.ROUT_CNST_SEQ ROUT_CNST_SEQ, DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'R') ROUT_CNST_FLG" ).append("\n"); 
		query.append("              ,ROW_NUMBER() OVER(PARTITION BY MST.PCTL_NO " ).append("\n"); 
		query.append("                  ORDER BY DECODE(R.TRNK_LANE_CD, 'ALL', 1, 0), " ).append("\n"); 
		query.append("                       DECODE(R.POR_NOD_CD, NULL, 1, 0), " ).append("\n"); 
		query.append("                       DECODE(R.POL_NOD_CD, 'ALL', 1, 0), " ).append("\n"); 
		query.append("                       DECODE(R.POD_NOD_CD, 'ALL', 1, 0)," ).append("\n"); 
		query.append("                       DECODE(R.DEL_NOD_CD, NULL, 1, 0), " ).append("\n"); 
		query.append("                       R.ROUT_CNST_SEQ DESC" ).append("\n"); 
		query.append("            ) RN" ).append("\n"); 
		query.append("        FROM PRD_ROUT_CNST R,PRD_PROD_CTL_QTY Q," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT  M.PCTL_NO, POR_NOD_CD, POL_CD," ).append("\n"); 
		query.append("                MAX (DECODE (TS.RK, 1, TS.LANE_CD)) N1ST_LANE_CD, N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                MAX (DECODE (TS.RK, 2, TS.LANE_CD)) N2ND_LANE_CD, N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                MAX (DECODE (TS.RK, 3, TS.LANE_CD)) N3RD_LANE_CD," ).append("\n"); 
		query.append("                POD_CD, DEL_NOD_CD," ).append("\n"); 
		query.append("                (SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                FROM VSK_VSL_SKD V" ).append("\n"); 
		query.append("                WHERE V.VSL_CD = TRNK_VSL_CD" ).append("\n"); 
		query.append("                AND V.SKD_VOY_NO = TRNK_SKD_VOY_NO" ).append("\n"); 
		query.append("                AND V.SKD_DIR_CD = TRNK_SKD_DIR_CD ) TRNK_LANE," ).append("\n"); 
		query.append("                (SELECT /*+INDEX (D XPKPRD_PROD_CTL_ROUT_DTL) */" ).append("\n"); 
		query.append("						  ORG_NOD_CD" ).append("\n"); 
		query.append("					FROM PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("					WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("					AND PCTL_IO_BND_CD = 'I' AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("					AND MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("					AND ROWNUM = 1) POD_NOD" ).append("\n"); 
		query.append("                ,MAX (DECODE (TS.RK, 1, ORG_NOD_CD )) N1ST_ORG_NOD_CD, MAX (DECODE (TS.RK, 1, DEST_NOD_CD )) N1ST_DEST_NOD_CD" ).append("\n"); 
		query.append("                ,MAX (DECODE (TS.RK, 2, ORG_NOD_CD )) N2ND_ORG_NOD_CD, MAX (DECODE (TS.RK, 2, DEST_NOD_CD )) N2ND_DEST_NOD_CD" ).append("\n"); 
		query.append("                ,MAX (DECODE (TS.RK, 3, ORG_NOD_CD )) N3RD_ORG_NOD_CD, MAX (DECODE (TS.RK, 3, DEST_NOD_CD )) N3RD_DEST_NOD_CD" ).append("\n"); 
		query.append("                ,M.DG_SPCL_FLG,M.RF_SPCL_FLG,M.SPCL_AWK_CGO_FLG,M.BB_SPCL_FLG" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("               (SELECT PCTL_NO,ORG_NOD_CD,DEST_NOD_CD," ).append("\n"); 
		query.append("                   RANK () OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) RK, VSL_SLAN_CD LANE_CD" ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("                 WHERE PCTL_NO LIKE @[hd_pctl_no]||'%' AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("                AND  DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD" ).append("\n"); 
		query.append("                AND  DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD" ).append("\n"); 
		query.append("                AND  DTL.ROUT_SEQ = ROUT.ROUT_SEQ" ).append("\n"); 
		query.append("               ) TS" ).append("\n"); 
		query.append("            WHERE M.PCTL_NO LIKE @[hd_pctl_no]||'%' AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("            GROUP BY M.PCTL_NO, " ).append("\n"); 
		query.append("                 POL_CD," ).append("\n"); 
		query.append("                 POR_NOD_CD," ).append("\n"); 
		query.append("                 N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("                 N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("                 POD_CD," ).append("\n"); 
		query.append("                 DEL_NOD_CD,                 " ).append("\n"); 
		query.append("                 TRNK_VSL_CD," ).append("\n"); 
		query.append("                 TRNK_SKD_VOY_NO," ).append("\n"); 
		query.append("                 TRNK_SKD_DIR_CD,M.DG_SPCL_FLG,M.RF_SPCL_FLG,M.SPCL_AWK_CGO_FLG,M.BB_SPCL_FLG" ).append("\n"); 
		query.append("           ) MST" ).append("\n"); 
		query.append("        WHERE NVL(MST.TRNK_LANE, 'ALL') = DECODE(R.TRNK_LANE_CD, 'ALL', NVL(MST.TRNK_LANE, 'ALL'), R.TRNK_LANE_CD)" ).append("\n"); 
		query.append("        AND NVL(MST.POR_NOD_CD, R.POR_NOD_CD) LIKE NVL(R.POR_NOD_CD, MST.POR_NOD_CD) || '%'" ).append("\n"); 
		query.append("        AND MST.POL_CD LIKE DECODE(R.POL_NOD_CD, 'ALL', MST.POL_CD, SUBSTR(R.POL_NOD_CD,1,5)||'%')" ).append("\n"); 
		query.append("        AND MST.N1ST_ORG_NOD_CD LIKE DECODE(LENGTH(R.POL_NOD_CD),7,R.POL_NOD_CD, MST.N1ST_ORG_NOD_CD)" ).append("\n"); 
		query.append("        AND MST.POD_NOD LIKE DECODE(R.POD_NOD_CD, 'ALL', MST.POD_CD, R.POD_NOD_CD) ||'%'" ).append("\n"); 
		query.append("        AND NVL(MST.DEL_NOD_CD, R.DEL_NOD_CD) LIKE NVL(R.DEL_NOD_CD, MST.DEL_NOD_CD)||'%'" ).append("\n"); 
		query.append("        AND NVL(MST.N1ST_TS_PORT_CD, ' ') = NVL(R.N1ST_TS_PORT_CD, NVL(MST.N1ST_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N2ND_TS_PORT_CD, ' ') = NVL(R.N2ND_TS_PORT_CD, NVL(MST.N2ND_TS_PORT_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N1ST_LANE_CD, ' ') = NVL(R.N1ST_LANE_CD, NVL(MST.N1ST_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N2ND_LANE_CD, ' ') = NVL(R.N2ND_LANE_CD, NVL(MST.N2ND_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(MST.N3RD_LANE_CD, ' ') = NVL(R.N3RD_LANE_CD, NVL(MST.N3RD_LANE_CD, ' '))" ).append("\n"); 
		query.append("        AND NVL(DELT_FLG, 'N') <> 'Y'                " ).append("\n"); 
		query.append("        AND Q.PCTL_NO = MST.PCTL_NO" ).append("\n"); 
		query.append("        AND Q.CNTR_TPSZ_CD LIKE NVL(R.CNTR_TP_CD,'%')||NVL(R.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("        AND NVL(R.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(R.SPCL_CGO_CNTR_TP_CD,'AL')  ='AL' THEN NVL(R.SPCL_CGO_CNTR_TP_CD,'AL') " ).append("\n"); 
		query.append("													WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' AND NVL(MST.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("													WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' AND NVL(MST.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("													WHEN NVL(MST.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("													WHEN NVL(MST.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("													WHEN NVL(MST.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("													WHEN NVL(MST.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("													WHEN NVL(MST.DG_SPCL_FLG,'N') ='N' AND NVL(MST.RF_SPCL_FLG,'N') ='N' AND NVL(MST.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(MST.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("												END)" ).append("\n"); 
		query.append("      ) M" ).append("\n"); 
		query.append("    WHERE RN = 1" ).append("\n"); 
		query.append("        AND PRD.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("WHERE PRD.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}