/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.25
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("SET CNST_FLG = (" ).append("\n"); 
		query.append("    SELECT CNST" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT DISTINCT PCTL_NO, DECODE(NVL(CC.SVC_USE_FLG, 'Y'), 'N', 'X', 'N') CNST, DECODE(NVL(CC.SVC_USE_FLG,'Y'),'N',1,2) ORD, CC.ORG_NOD_CD NOD" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                SELECT DECODE(C.NOD_CD,'ALL',D.ORG_NOD_CD,C.NOD_CD) NOD_CD, C.PORT_PNT_CD, C.SVC_USE_FLG, D.PCTL_NO, D.ORG_NOD_CD, D.PCTL_SEQ" ).append("\n"); 
		query.append("                FROM PRD_NOD_CNST_MGMT C" ).append("\n"); 
		query.append("                   , PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("                    ,PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("                   , (SELECT PCTL_NO, PCTL_SEQ, ORG_NOD_CD, NOD_LNK_DIV_CD, PCTL_IO_BND_CD, MTY_YD_FLG, ARR_ST_DT, DEP_FSH_DT" ).append("\n"); 
		query.append("                             , LEAD (VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POL_SLAN_CD" ).append("\n"); 
		query.append("                             , LEAD (VSL_CD || SKD_VOY_NO || SKD_DIR_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POL_VVD" ).append("\n"); 
		query.append("                             , LAG (VSL_SLAN_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POD_SLAN_CD" ).append("\n"); 
		query.append("                             , LAG  (VSL_CD || SKD_VOY_NO || SKD_DIR_CD) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) POD_VVD" ).append("\n"); 
		query.append("                        FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                        WHERE PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no]||'%')) D" ).append("\n"); 
		query.append("                   , MDM_VSL_SVC_LANE SL,MDM_VSL_SVC_LANE SD" ).append("\n"); 
		query.append("                 WHERE M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                 AND D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("                 AND D.ORG_NOD_CD LIKE DECODE(C.NOD_CD, 'ALL','%',C.NOD_CD||'%')" ).append("\n"); 
		query.append("                 AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))" ).append("\n"); 
		query.append("                 AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                 AND NVL(C.CNTR_TP_CD, Q.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                    = DECODE(C.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                                                        --'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                        --'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)))" ).append("\n"); 
		query.append("                                                                        'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                                        'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("                 AND (" ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                                                -- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("                            TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= M.CRE_DT AND" ).append("\n"); 
		query.append("                            M.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                AND D.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                AND SL.VSL_SLAN_CD(+) = D.POL_SLAN_CD" ).append("\n"); 
		query.append("                AND SD.VSL_SLAN_CD(+) = D.POD_SLAN_CD" ).append("\n"); 
		query.append("                AND (   D.POL_SLAN_CD || ',' || DECODE(SL.VSL_SVC_TP_CD, 'O', 'FDR') LIKE '%' || C.VSL_SLAN_CD || '%'" ).append("\n"); 
		query.append("                     OR D.POD_SLAN_CD || ',' || DECODE(SD.VSL_SVC_TP_CD, 'O', 'FDR') LIKE '%' || C.VSL_SLAN_CD || '%'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                AND NVL(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, '#') IN (D.POL_VVD, D.POD_VVD, DECODE(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, NULL, '#'))" ).append("\n"); 
		query.append("                AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                  FROM PRD_NOD_CNST_EXPT X" ).append("\n"); 
		query.append("                                 WHERE 1=1" ).append("\n"); 
		query.append("                                   AND X.NOD_CD          = C.NOD_CD" ).append("\n"); 
		query.append("                                   AND X.NOD_CNST_ITM_CD = C.NOD_CNST_ITM_CD" ).append("\n"); 
		query.append("                                   AND X.NOD_CNST_SEQ    = C.NOD_CNST_SEQ" ).append("\n"); 
		query.append("                                   AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                   AND (" ).append("\n"); 
		query.append("                                        (X.CNST_EXPT_TP_CD = 'K' AND X.CNST_EXPT_NO = M.SC_NO) OR" ).append("\n"); 
		query.append("                                        (X.CNST_EXPT_TP_CD = 'R' AND X.CNST_EXPT_NO = M.RFA_NO)" ).append("\n"); 
		query.append("                                       )" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                ORDER BY DECODE(NVL(SVC_USE_FLG,'Y'),'N',1,2)" ).append("\n"); 
		query.append("                ) CC" ).append("\n"); 
		query.append("            WHERE NVL(CC.PORT_PNT_CD, 'ALL') = 'ALL'" ).append("\n"); 
		query.append("               OR CC.PORT_PNT_CD IN " ).append("\n"); 
		query.append("                  (" ).append("\n"); 
		query.append("                      (SELECT CASE" ).append("\n"); 
		query.append("                          WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                              AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                              AND MTY_YD_FLG = 'N'  ) THEN 'POR'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                      FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                      WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                      AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                      AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                      )," ).append("\n"); 
		query.append("                      (SELECT CASE" ).append("\n"); 
		query.append("                          WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                              AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                              AND MTY_YD_FLG = 'N'  ) THEN 'POL'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                      FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                      WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                      AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                      AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                      )," ).append("\n"); 
		query.append("                      (SELECT CASE" ).append("\n"); 
		query.append("                          WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("                              AND NOD_LNK_DIV_CD = 'N'  ) THEN 'TS'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                      FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                      WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                      AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                      AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                      )," ).append("\n"); 
		query.append("                      (SELECT CASE" ).append("\n"); 
		query.append("                          WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                              AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                              AND MTY_YD_FLG = 'N'  ) THEN 'POD'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                      FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                      WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                      AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                      AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                      )," ).append("\n"); 
		query.append("                      (SELECT CASE" ).append("\n"); 
		query.append("                          WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                              WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                              AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                              AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                              AND MTY_YD_FLG = 'N'  ) THEN 'DEL'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                      FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                      WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                      AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                      and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                      AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("           ) T" ).append("\n"); 
		query.append("     WHERE ROWNUM=1 " ).append("\n"); 
		query.append("       AND D.PCTL_NO = T.PCTL_NO" ).append("\n"); 
		query.append("       AND D.ORG_NOD_CD= T.NOD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no]||'%')" ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 

	}
}