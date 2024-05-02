/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlHubCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23 
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

public class PrdCreateManageDBDAOUpdatePrdDtlHubCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePrdDtlHubCnst
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlHubCnstUSQL(){
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
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlHubCnstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL DM																					 " ).append("\n"); 
		query.append("SET CNST_FLG = (" ).append("\n"); 
		query.append("    SELECT MIN(DECODE(NVL(C.SVC_USE_FLG, 'Y'), 'N', 'X', 'N')) CNST" ).append("\n"); 
		query.append("    FROM PRD_HUB_LOC_CNST_MGMT C, PRD_PROD_CTL_MST M,PRD_PROD_CTL_ROUT_DTL D, PRD_PROD_CTL_QTY Q" ).append("\n"); 
		query.append("    WHERE C.PORT_CD  = DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_ORG_NOD_CD,1,5),'O',SUBSTR(D.ROUT_DEST_NOD_CD,1,5)) " ).append("\n"); 
		query.append("    AND C.HUB_LOC_CD = NVL((SELECT HUB_LOC_CD " ).append("\n"); 
		query.append("                             FROM PRD_INLND_ROUT_MST H" ).append("\n"); 
		query.append("                            WHERE H.ROUT_ORG_NOD_CD = D.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                              AND H.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                              AND H.ROUT_SEQ = D.ROUT_SEQ),C.PORT_CD)" ).append("\n"); 
		query.append("    AND C.HUB_LOC_CD = SUBSTR(D.ORG_NOD_CD,1,5)" ).append("\n"); 
		query.append("    AND C.NOD_CD=DECODE(C.NOD_CD,'ALL',C.NOD_CD,DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_DEST_NOD_CD,1,LENGTH(TRIM(C.NOD_CD))),'O',SUBSTR(D.ROUT_ORG_NOD_CD,1,LENGTH(TRIM(C.NOD_CD))))) " ).append("\n"); 
		query.append("    AND C.IO_BND_CD= DECODE(C.IO_BND_CD,'B',C.IO_BND_CD,D.PCTL_IO_BND_CD)" ).append("\n"); 
		query.append("    AND D.PCTL_IO_BND_CD <> 'T'" ).append("\n"); 
		query.append("    AND M.PCTL_NO = D.PCTL_NO    " ).append("\n"); 
		query.append("    AND M.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("    AND Q.CNTR_TPSZ_CD LIKE NVL(C.CNTR_TP_CD,'%')||NVL(C.CNTR_SZ_CD,'%')" ).append("\n"); 
		query.append("    AND C.CNST_LANE_CD = (CASE WHEN C.CNST_LANE_CD = 'ALL' THEN C.CNST_LANE_CD" ).append("\n"); 
		query.append("                                ELSE (SELECT DECODE(D.PCTL_IO_BND_CD,'O',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),1,3)" ).append("\n"); 
		query.append("                                                                    ,'I',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),-3)) " ).append("\n"); 
		query.append("                                        FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                       WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                           = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                               WHERE DX.PCTL_NO LIKE D.PCTL_NO" ).append("\n"); 
		query.append("                                                 AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                 AND ROWNUM =1)" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                          END)" ).append("\n"); 
		query.append("    AND NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                            END)" ).append("\n"); 
		query.append("    AND NVL(C.DIR_CD,'A') = (CASE WHEN NVL(C.DIR_CD,'A') = 'A' THEN NVL(C.DIR_CD,'A')" ).append("\n"); 
		query.append("                                  WHEN C.IO_BND_CD ='O' THEN  ( SELECT /*+ INDEX_ASC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                                 WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                   AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                                   AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                                  WHEN C.IO_BND_CD ='I' THEN  ( SELECT /*+ INDEX_DESC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                                 WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                   AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                                   AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                                  WHEN C.IO_BND_CD ='B' AND ( M.POR_CD = SUBSTR(C.NOD_CD,1,5) OR M.POL_CD = C.PORT_CD )   " ).append("\n"); 
		query.append("                                                        THEN  ( SELECT /*+ INDEX_ASC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                                 WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                   AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                                   AND ROWNUM = 1 )                               " ).append("\n"); 
		query.append("                                  WHEN C.IO_BND_CD ='B' AND ( M.DEL_CD = SUBSTR(C.NOD_CD,1,5) OR M.POD_CD = C.PORT_CD )   " ).append("\n"); 
		query.append("                                                        THEN  ( SELECT /*+ INDEX_DESC (DT XPKPRD_PROD_CTL_ROUT_DTL) */  SKD_DIR_CD " ).append("\n"); 
		query.append("                                                                  FROM PRD_PROD_CTL_ROUT_DTL DT" ).append("\n"); 
		query.append("                                                                 WHERE PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                                   AND PCTL_NO =M.PCTL_NO" ).append("\n"); 
		query.append("                                                                   AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("                               END)" ).append("\n"); 
		query.append("    AND DECODE(C.NOD_CD,'ALL',1000,0) + DECODE(C.IO_BND_CD,'B',100,0) + DECODE(C.CNST_LANE_CD,'ALL',10,0) + DECODE(C.SPCL_CGO_CNTR_TP_CD,'AL',1,0) " ).append("\n"); 
		query.append("     = (SELECT MIN(DECODE(C2.NOD_CD,'ALL',1000,0) + DECODE(C2.IO_BND_CD,'B',100,0) + DECODE(C2.CNST_LANE_CD,'ALL',10,0) + DECODE(C2.SPCL_CGO_CNTR_TP_CD,'AL',1,0) )" ).append("\n"); 
		query.append("         FROM PRD_HUB_LOC_CNST_MGMT C2" ).append("\n"); 
		query.append("        WHERE C2.PORT_CD = C.PORT_CD" ).append("\n"); 
		query.append("          AND C2.HUB_LOC_CD = C.HUB_LOC_CD" ).append("\n"); 
		query.append("          AND C2.NOD_CD= DECODE(C2.NOD_CD,'ALL',C2.NOD_CD,DECODE(D.PCTL_IO_BND_CD,'I',SUBSTR(D.ROUT_DEST_NOD_CD,1,LENGTH(TRIM(C2.NOD_CD))),'O',SUBSTR(D.ROUT_ORG_NOD_CD,1,LENGTH(TRIM(C2.NOD_CD))))) " ).append("\n"); 
		query.append("          AND C2.IO_BND_CD =DECODE(C2.IO_BND_CD,'B',C2.IO_BND_CD,'ALL',C2.IO_BND_CD,D.PCTL_IO_BND_CD)" ).append("\n"); 
		query.append("          AND C2.CNST_LANE_CD = (CASE WHEN C2.CNST_LANE_CD = 'ALL' THEN C2.CNST_LANE_CD" ).append("\n"); 
		query.append("                                        ELSE (SELECT DECODE(D.PCTL_IO_BND_CD,'O',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),1,3)" ).append("\n"); 
		query.append("                                                                            ,'I',SUBSTR(TRIM(N1ST_LANE_CD||N2ND_LANE_CD||N3RD_LANE_CD||N4TH_LANE_CD),-3)) " ).append("\n"); 
		query.append("                                                FROM PRD_OCN_ROUT O" ).append("\n"); 
		query.append("                                               WHERE (ORG_LOC_CD, DEST_LOC_CD, ROUT_SEQ ) " ).append("\n"); 
		query.append("                                                   = (SELECT DX.ROUT_ORG_NOD_CD, DX.ROUT_DEST_NOD_CD, DX.ROUT_SEQ" ).append("\n"); 
		query.append("                                                        FROM PRD_PROD_CTL_ROUT_DTL DX" ).append("\n"); 
		query.append("                                                       WHERE DX.PCTL_NO LIKE D.PCTL_NO" ).append("\n"); 
		query.append("                                                         AND DX.PCTL_IO_BND_CD ='T'" ).append("\n"); 
		query.append("                                                         AND ROWNUM =1) " ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                                    END)" ).append("\n"); 
		query.append("          AND NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL') = (CASE WHEN NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL') ='AL' THEN NVL(C2.SPCL_CGO_CNTR_TP_CD,'AL')" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RD'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AD'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.DG_SPCL_FLG,'N') ='Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.RF_SPCL_FLG,'N') ='Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.SPCL_AWK_CGO_FLG,'N') ='Y' THEN 'AK'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.BB_SPCL_FLG,'N') ='Y' THEN 'BB'" ).append("\n"); 
		query.append("                                                       WHEN NVL(M.DG_SPCL_FLG,'N') ='N' AND NVL(M.RF_SPCL_FLG,'N') ='N' AND NVL(M.SPCL_AWK_CGO_FLG,'N') ='N' AND NVL(M.BB_SPCL_FLG,'N') ='N'  THEN 'GP'" ).append("\n"); 
		query.append("                                                   END) " ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("    AND D.NOD_LNK_DIV_CD = 'N'  " ).append("\n"); 
		query.append("    AND DM.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("    AND DM.PCTL_SEQ = D.PCTL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE DM.PCTL_NO LIKE @[hd_pctl_no]||'%'																	 				 " ).append("\n"); 
		query.append("AND DM.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("AND DM.MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("AND NVL(DM.CNST_FLG,'N') <> 'X'" ).append("\n"); 

	}
}