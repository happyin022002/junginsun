/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOcheckReplaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.07
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2011.03.07 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOcheckReplaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkReplane
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOcheckReplaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("t_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_t",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOcheckReplaneRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG.PCTL_NO," ).append("\n"); 
		query.append("GREATEST(NVL(SO_BND,0),NVL(ACT_BND,0)) PCTL_SEQ," ).append("\n"); 
		query.append("(CASE" ).append("\n"); 
		query.append("    WHEN GREATEST(NVL(SO_BND,0),NVL(ACT_BND,0)) = 1 THEN --OUTBOUND -> POR, RTERM 변경 불가" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN C_POR = 'D' THEN 'E0001'" ).append("\n"); 
		query.append("        WHEN C_RTERM = 'D' THEN 'E0006'" ).append("\n"); 
		query.append("		 -- O/B Rail S/O -> POL 변경불가   (# Add 2008.01.23 by sj)" ).append("\n"); 
		query.append("		 WHEN RD_SO = 'D' AND C_POL = 'D' THEN 'E0002'" ).append("\n"); 
		query.append("		 -- COP_STS = 'F' AND SUB_STS <> 'R' -> Replan 불가" ).append("\n"); 
		query.append("		 WHEN C_REPLAN IS NULL THEN 'E0008'" ).append("\n"); 
		query.append("        ELSE 'E0000'" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHEN GREATEST(NVL(SO_BND,0),NVL(ACT_BND,0)) = 2 THEN --OCEAN -> POR, POL, RTERM 변경 불가" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("        WHEN C_POR = 'D' THEN 'E0001'" ).append("\n"); 
		query.append("        WHEN C_POL = 'D' THEN 'E0002'" ).append("\n"); 
		query.append("        WHEN C_RTERM = 'D' THEN 'E0006'" ).append("\n"); 
		query.append("		 -- COP_STS = 'F' AND SUB_STS <> 'R' -> Replan 불가" ).append("\n"); 
		query.append("		 WHEN C_REPLAN IS NULL THEN 'E0008'" ).append("\n"); 
		query.append("        ELSE 'E0000'" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    WHEN GREATEST(NVL(SO_BND,0),NVL(ACT_BND,0)) = 3 THEN --INBOUND -> POR,POL,POD,RTERM,VVD 변경불가" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    CASE" ).append("\n"); 
		query.append("		 WHEN C_POD = 'D' AND ACT_STS = 'D' THEN 'E0009'	-- I/B TN/IC -> POD 변경불가(#Add 2008.02.21 by sj)" ).append("\n"); 
		query.append("        WHEN C_POR = 'D' THEN 'E0001'   WHEN C_POL = 'D' THEN 'E0002'   WHEN C_VVD = 'D' THEN 'E0003'" ).append("\n"); 
		query.append("        WHEN C_POD = 'D' THEN 'E0004'   WHEN C_RTERM='D' THEN 'E0006'" ).append("\n"); 
		query.append("		 -- I/B Door SO -> DEL 변경불가" ).append("\n"); 
		query.append("		 WHEN ID_SO = 'D' AND C_DEL = 'D' THEN 'E0005'" ).append("\n"); 
		query.append("		 WHEN ID_SO = 'D' AND C_DTERM = 'D' THEN 'E0007'     --  I/B Door SO -> DEL Term 변경불가	(# Add 2007.11.14 by sj)" ).append("\n"); 
		query.append("		 WHEN RD_SO = 'D' AND C_DEL = 'D' THEN 'E0005'       --  I/B Rail SO -> DEL 변경불가(# Add 2007.11.14 by sj)" ).append("\n"); 
		query.append("		 -- COP_STS = 'F' AND SUB_STS <> 'R' -> Replan 불가" ).append("\n"); 
		query.append("		 WHEN C_REPLAN IS NULL THEN 'E0008'" ).append("\n"); 
		query.append("        ELSE 'E0000'" ).append("\n"); 
		query.append("    END" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    ELSE 'E0000'" ).append("\n"); 
		query.append("END) E_CD," ).append("\n"); 
		query.append("CASE WHEN NVL(SO_BND,0) < NVL(ACT_BND,0) THEN 'MVMT'" ).append("\n"); 
		query.append("     WHEN NVL(SO_BND,0) > NVL(ACT_BND,0) THEN 'SOWO'" ).append("\n"); 
		query.append("     ELSE 'ALL' END AS E_TP," ).append("\n"); 
		query.append("NVL(SO_BND,0) SO_BND," ).append("\n"); 
		query.append("NVL(ACT_BND,0) MVMT_BND" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    PCTL_NO," ).append("\n"); 
		query.append("    POR_CD,POL_CD,POD_CD,DEL_CD,BKG_RCV_TERM_CD,BKG_DE_TERM_CD," ).append("\n"); 
		query.append("    DECODE(M.POR_CD,@[por],'S','D') C_POR," ).append("\n"); 
		query.append("    DECODE(M.POL_CD,@[pol],'S','D') C_POL," ).append("\n"); 
		query.append("    DECODE(M.POD_CD,@[pod],'S','D') C_POD," ).append("\n"); 
		query.append("    DECODE(M.DEL_CD,@[del],'S','D') C_DEL," ).append("\n"); 
		query.append("    DECODE(M.TRNK_VSL_CD||M.TRNK_SKD_VOY_NO||M.TRNK_SKD_DIR_CD,@[t_vvd],'S','D') C_VVD," ).append("\n"); 
		query.append("    DECODE(M.BKG_RCV_TERM_CD,@[rcv_t],'S','D') C_RTERM," ).append("\n"); 
		query.append("    DECODE(M.BKG_DE_TERM_CD ,@[del_t],'S','D') C_DTERM" ).append("\n"); 
		query.append("    FROM PRD_PROD_CTL_MST M WHERE PCTL_NO = (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]  )" ).append("\n"); 
		query.append(") BKG," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	 SELECT  SO_BND," ).append("\n"); 
		query.append("        ( SELECT (CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(MAX(COST_ACT_GRP_CD), 1, 2) = 'ID' THEN 'D'" ).append("\n"); 
		query.append("                    ELSE 'Y'" ).append("\n"); 
		query.append("                  END)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("          WHERE COP_NO IN" ).append("\n"); 
		query.append("                        (SELECT COP_NO FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no] AND COP_STS_CD NOT IN ('O','X'))" ).append("\n"); 
		query.append("          AND COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("          AND TRSP_SO_STS_CD IN ('C','R','I','E','X')" ).append("\n"); 
		query.append("          AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("          AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("          AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("       ) ID_SO," ).append("\n"); 
		query.append("	    ( SELECT (CASE" ).append("\n"); 
		query.append("                    WHEN SUBSTR(MAX(COST_ACT_GRP_CD), 1, 1) IN ('I', 'O') AND" ).append("\n"); 
		query.append("                         (SUBSTR(MAX(COST_ACT_GRP_CD), 3, 1) = 'R' OR SUBSTR(MAX(COST_ACT_GRP_CD), 4, 1) = 'R') THEN 'D'" ).append("\n"); 
		query.append("                    ELSE 'Y'" ).append("\n"); 
		query.append("                  END)" ).append("\n"); 
		query.append("          FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("          WHERE COP_NO IN" ).append("\n"); 
		query.append("                        (SELECT COP_NO FROM SCE_COP_HDR" ).append("\n"); 
		query.append("                         WHERE BKG_NO = @[bkg_no] AND COP_STS_CD NOT IN ('O','X'))" ).append("\n"); 
		query.append("          AND COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("          AND TRSP_SO_STS_CD IN ('C','R','I','E','X')" ).append("\n"); 
		query.append("		  AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("          AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        ) RD_SO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("    SELECT  MAX(COST_ACT_GRP_SEQ) COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("		(CASE" ).append("\n"); 
		query.append("		  	WHEN MAX(COST_ACT_GRP_SEQ) >= 400 AND MAX(COST_ACT_GRP_SEQ) < 600 THEN 2" ).append("\n"); 
		query.append("		  	WHEN MAX(COST_ACT_GRP_SEQ) >= 600 AND MAX(COST_ACT_GRP_SEQ) < 900 THEN 3" ).append("\n"); 
		query.append("		  	WHEN MAX(COST_ACT_GRP_SEQ) IS NULL THEN 0" ).append("\n"); 
		query.append("		 	 ELSE 1" ).append("\n"); 
		query.append("	 	END) SO_BND" ).append("\n"); 
		query.append("    	FROM" ).append("\n"); 
		query.append("		  (SELECT MAX(COST_ACT_GRP_SEQ) COST_ACT_GRP_SEQ FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("    	   WHERE COP_NO IN" ).append("\n"); 
		query.append("    	       (SELECT COP_NO FROM SCE_COP_HDR" ).append("\n"); 
		query.append("     	          WHERE BKG_NO = @[bkg_no]  AND COP_STS_CD NOT IN ('O','X'))" ).append("\n"); 
		query.append("    	   AND TRSP_SO_STS_CD IN ('C','R','I','E','X')" ).append("\n"); 
		query.append("           AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("           AND NVL(RPLN_UMCH_FLG,'N') <> 'Y' -- 2010.04.09 추가 by j" ).append("\n"); 
		query.append("           AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    	   UNION" ).append("\n"); 
		query.append("    	   SELECT MAX(COST_ACT_GRP_SEQ) COST_ACT_GRP_SEQ FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("    	   WHERE COP_NO IN" ).append("\n"); 
		query.append("        	   (SELECT COP_NO FROM SCE_COP_HDR" ).append("\n"); 
		query.append("     	          WHERE BKG_NO = @[bkg_no]  AND COP_STS_CD NOT IN ('O','X'))" ).append("\n"); 
		query.append("    	   AND TRSP_SO_STS_CD IN ('C','R','I','E','X')" ).append("\n"); 
		query.append("		   AND NVL(TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("           AND NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    	   )" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 
		query.append(") SO," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("    (CASE   --POD Discharging 은 Ocean 구간으로 간주" ).append("\n"); 
		query.append("		 WHEN ACT_BND IN (1,2) THEN 0" ).append("\n"); 
		query.append("        WHEN ACT_BND = 3 AND ACT_CD IN ('FUVMUD','FUWMUD') AND" ).append("\n"); 
		query.append("            COP_DTL_SEQ = (SELECT MIN(COP_DTL_SEQ) FROM SCE_COP_DTL" ).append("\n"); 
		query.append("                           WHERE COP_NO = D.COP_NO AND SUBSTR(COP_DTL_SEQ,1,1) = '6' AND ACT_CD = D.ACT_CD) THEN 2" ).append("\n"); 
		query.append("        ELSE ACT_BND" ).append("\n"); 
		query.append("    END) ACT_BND," ).append("\n"); 
		query.append("	 (CASE" ).append("\n"); 
		query.append("		 WHEN ACT_STS_MAPG_CD = 'TN' OR ACT_STS_MAPG_CD = 'IC' THEN 'D'" ).append("\n"); 
		query.append("		 ELSE 'S'" ).append("\n"); 
		query.append("      END) ACT_STS" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("            MAX(COP_NO) COP_NO," ).append("\n"); 
		query.append("            MAX(COP_DTL_SEQ) COP_DTL_SEQ,   --MAX(COP_GRP_SEQ) COP_GRP_SEQ," ).append("\n"); 
		query.append("            --OP 는 운송전으로 간주" ).append("\n"); 
		query.append("    		(CASE" ).append("\n"); 
		query.append("    		  WHEN MAX(COP_DTL_SEQ) >= 4000 AND MAX(COP_DTL_SEQ) < 6000 THEN 2" ).append("\n"); 
		query.append("    		  WHEN MAX(COP_DTL_SEQ) >= 6000 AND MAX(COP_DTL_SEQ) < 9000 THEN 3" ).append("\n"); 
		query.append("    		  ELSE 0" ).append("\n"); 
		query.append("    		END) ACT_BND," ).append("\n"); 
		query.append("            MAX(ACT_CD) ACT_CD," ).append("\n"); 
		query.append("    		MAX(ACT_STS_MAPG_CD) ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("            COP_NO, --COP_GRP_SEQ," ).append("\n"); 
		query.append("            COP_DTL_SEQ,ACT_CD,ACT_STS_CD,ACT_STS_MAPG_CD" ).append("\n"); 
		query.append("            FROM SCE_COP_DTL" ).append("\n"); 
		query.append("            WHERE COP_NO IN" ).append("\n"); 
		query.append("            (SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("			  AND COP_STS_CD NOT IN ('X','O') AND NVL(COP_SUB_STS_CD,'X') <> 'R')" ).append("\n"); 
		query.append("            AND ACT_STS_CD = 'F'" ).append("\n"); 
		query.append("            ORDER BY  COP_DTL_SEQ DESC         -- COP_GRP_SEQ||COP_DTL_SEQ DESC" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        WHERE ROWNUM = 1" ).append("\n"); 
		query.append("    ) D" ).append("\n"); 
		query.append(") ACT," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT MAX(COP_NO) C_REPLAN" ).append("\n"); 
		query.append("    FROM SCE_COP_HDR" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND (COP_STS_CD IN ('C', 'T') OR (COP_STS_CD = 'F' AND NVL(COP_SUB_STS_CD, 'X') = 'R'))" ).append("\n"); 
		query.append(") COP" ).append("\n"); 

	}
}