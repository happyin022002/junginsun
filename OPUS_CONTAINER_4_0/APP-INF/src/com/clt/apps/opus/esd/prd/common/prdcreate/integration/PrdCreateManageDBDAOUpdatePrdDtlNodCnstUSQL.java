/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlNodCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.08 
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
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL D																					 " ).append("\n"); 
		query.append("SET CNST_FLG = ( " ).append("\n"); 
		query.append("    SELECT CNST" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT DISTINCT DECODE(NVL(CC.SVC_USE_FLG, 'Y'), 'N', 'X', 'N') CNST, DECODE(NVL(CC.SVC_USE_FLG,'Y'),'N',1,2) ORD, CC.ORG_NOD_CD NOD, CC.PCTL_NO " ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("    			SELECT DECODE(C.NOD_CD,'ALL',D.ORG_NOD_CD,C.NOD_CD) NOD_CD, C.PORT_PNT_CD, C.SVC_USE_FLG, D.PCTL_NO, D.ORG_NOD_CD, D.PCTL_SEQ" ).append("\n"); 
		query.append("                FROM PRD_NOD_CNST_MGMT C, PRD_PROD_CTL_QTY Q,PRD_PROD_CTL_MST M , PRD_PROD_CTL_ROUT_DTL D " ).append("\n"); 
		query.append("    			 WHERE M.PCTL_NO = D.PCTL_NO " ).append("\n"); 
		query.append("    			 AND D.PCTL_NO = Q.PCTL_NO							 " ).append("\n"); 
		query.append("                 AND D.ORG_NOD_CD LIKE DECODE(C.NOD_CD, 'ALL','%',C.NOD_CD||'%')" ).append("\n"); 
		query.append("    			 AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))																 " ).append("\n"); 
		query.append("    			 AND NVL(C.DELT_FLG, 'N') <> 'Y'															  		 " ).append("\n"); 
		query.append("    			 AND NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                             WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                                         END)" ).append("\n"); 
		query.append("    			 AND Q.CNTR_TPSZ_CD LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("                 AND NVL(C.VSL_SLAN_CD,'ALL') = (CASE WHEN NVL(C.VSL_SLAN_CD,'ALL') = 'ALL' THEN NVL(C.VSL_SLAN_CD,'ALL')" ).append("\n"); 
		query.append("                                                      WHEN C.PORT_PNT_CD IN ('POR','POL') THEN (SELECT N1ST_LANE_CD" ).append("\n"); 
		query.append("                                                                                                  FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                                 WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                                       = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                            FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                                           WHERE DX.PCTL_NO LIKE D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                             AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                             AND ROWNUM =1) )" ).append("\n"); 
		query.append("                                                      WHEN C.PORT_PNT_CD IN ('POD','DEL') THEN ( SELECT SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),-3)" ).append("\n"); 
		query.append("                                                                                                   FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                                  WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                                       = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                            FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                                           WHERE DX.PCTL_NO LIKE D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                             AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                             AND ROWNUM =1) )    " ).append("\n"); 
		query.append("                                                      WHEN C.PORT_PNT_CD IN ('ALL','TS') THEN (SELECT C.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                                                                 FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                                                                                WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                                                                       = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                                                                            FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                                                                           WHERE DX.PCTL_NO LIKE D.PCTL_NO" ).append("\n"); 
		query.append("                                                                                                             AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                                                             AND ROWNUM =1) " ).append("\n"); 
		query.append("                                                                                                  AND C.VSL_SLAN_CD IN ( N1ST_LANE_CD,N2ND_LANE_CD,N3RD_LANE_CD,N4TH_LANE_CD))" ).append("\n"); 
		query.append("                                                  END)" ).append("\n"); 
		query.append("    			 AND (																								 " ).append("\n"); 
		query.append("    					(																							 " ).append("\n"); 
		query.append("    						TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.ARR_ST_DT AND	 " ).append("\n"); 
		query.append("    						D.ARR_ST_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)		 " ).append("\n"); 
		query.append("    					) OR																						 " ).append("\n"); 
		query.append("    					(																							 " ).append("\n"); 
		query.append("    						TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= D.DEP_FSH_DT AND	 " ).append("\n"); 
		query.append("    						D.DEP_FSH_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)	 " ).append("\n"); 
		query.append("    					)																							 " ).append("\n"); 
		query.append("    				) 				" ).append("\n"); 
		query.append("    			AND D.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("    			AND D.NOD_LNK_DIV_CD = 'N'																		 " ).append("\n"); 
		query.append("    			ORDER BY DECODE(NVL(SVC_USE_FLG,'Y'),'N',1,2)" ).append("\n"); 
		query.append("                ) CC" ).append("\n"); 
		query.append("			WHERE NVL(CC.port_pnt_cd, 'ALL') = 'ALL' OR" ).append("\n"); 
		query.append("                                            CC.port_pnt_cd IN (" ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POR'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )," ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POL'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                ),                                             " ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  IN (SELECT  PCTL_SEQ FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'T'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'  ) THEN 'TS'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                ),                                                " ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MIN(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'POD'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )," ).append("\n"); 
		query.append("                                                (SELECT CASE" ).append("\n"); 
		query.append("                                                    WHEN PCTL_SEQ  = (SELECT  MAX(PCTL_SEQ) FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("                                                        WHERE  PCTL_NO = DD.pctl_no" ).append("\n"); 
		query.append("                                                        AND PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                                                        AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                        AND MTY_YD_FLG = 'N'  ) THEN 'DEL'" ).append("\n"); 
		query.append("                                                    END" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DD" ).append("\n"); 
		query.append("                                                WHERE DD.pctl_no = CC.pctl_no" ).append("\n"); 
		query.append("                                                AND Dd.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                                and dd.PCTL_SEQ = cc.PCTL_SEQ" ).append("\n"); 
		query.append("                                                AND (DD.ORG_NOD_CD LIKE CC.NOD_CD||'%')" ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("		   ) T" ).append("\n"); 
		query.append("	 WHERE ROWNUM=1 AND D.ORG_NOD_CD= T.NOD AND D.PCTL_NO = T.PCTL_NO		" ).append("\n"); 
		query.append(")																						 " ).append("\n"); 
		query.append("WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'																		 				 " ).append("\n"); 
		query.append("AND NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}