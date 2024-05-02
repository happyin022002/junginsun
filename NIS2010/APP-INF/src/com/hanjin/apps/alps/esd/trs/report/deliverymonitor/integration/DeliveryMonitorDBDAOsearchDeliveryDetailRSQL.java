/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DeliveryMonitorDBDAOsearchDeliveryDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DeliveryMonitorDBDAOsearchDeliveryDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delivery Monitor Detail 조회
	  * </pre>
	  */
	public DeliveryMonitorDBDAOsearchDeliveryDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sDorLoc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sBndCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sToDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sFromDt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sToLoc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sOfcCd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sFmLoc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sViaLoc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sYrWeek",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration").append("\n"); 
		query.append("FileName : DeliveryMonitorDBDAOsearchDeliveryDetailRSQL").append("\n"); 
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
		query.append("SELECT CTRL_OFC_CD SCE_SO_OFC_CD" ).append("\n"); 
		query.append("      ,@[sYrWeek] YR_WEEK" ).append("\n"); 
		query.append("      ,TO_CHAR(PLN_DATE, 'YYYY.MM.DD HH24:MI:SS') PLN_DATE" ).append("\n"); 
		query.append("      ,SO_TP_CD" ).append("\n"); 
		query.append("      ,BND_CD" ).append("\n"); 
		query.append("      ,BKG_NO" ).append("\n"); 
		query.append("      ,DECODE(CNTR_NO, 'SMCU0000000', '', CNTR_NO) CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD      " ).append("\n"); 
		query.append("      ,SUBSTR(AA.MVMT, 1, INSTR(AA.MVMT, '$', 1, 1) - 1) AS CRNT_MVMT_STS_CD" ).append("\n"); 
		query.append("      ,SUBSTR(AA.MVMT, INSTR(AA.MVMT, '$', 1, 1) + 1, INSTR(AA.MVMT, '$', 1, 2) - INSTR(AA.MVMT, '$', 1, 1) - 1) AS CRNT_YD_CD" ).append("\n"); 
		query.append("      ,SUBSTR(AA.MVMT, INSTR(AA.MVMT, '$', 1, 2) + 1, INSTR(AA.MVMT, '$', 1, 3) - INSTR(AA.MVMT, '$', 1, 2) - 1) AS EVNT_DT" ).append("\n"); 
		query.append("      ,SUBSTR(AA.MVMT, INSTR(AA.MVMT, '$', 1, 3) + 1, INSTR(AA.MVMT, '$', 1, 4) - INSTR(AA.MVMT, '$', 1, 3) - 1) AS SP_CD" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = SUBSTR(AA.MVMT, INSTR(AA.MVMT, '$', 1, 3) + 1, INSTR(AA.MVMT, '$', 1, 4) - INSTR(AA.MVMT, '$', 1, 3) - 1)) SP_NM" ).append("\n"); 
		query.append("      ,POR_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,DEL_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,COP_NO" ).append("\n"); 
		query.append("      ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("      ,NVL(SUBSTR(AA.SO, INSTR(AA.SO, '$', 1,13) + 1, INSTR(AA.SO, '$', 1,14) - INSTR(AA.SO, '$', 1,13) - 1), TRSP_SO_STS_CD) AS TRSP_SO_STS_CD" ).append("\n"); 
		query.append("      ,(SELECT X.ZN_NM FROM MDM_ZONE X WHERE X.ZN_CD = DOR_NOD_CD) DOR_NM" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, 1, INSTR(AA.SO, '$', 1, 1) - 1) AS SO_NO" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 1) + 1, INSTR(AA.SO, '$', 1, 2) - INSTR(AA.SO, '$', 1, 1) - 1) AS SO_CRE_DT  " ).append("\n"); 
		query.append("      ,NVL((SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 2) + 1, INSTR(AA.SO, '$', 1, 3) - INSTR(AA.SO, '$', 1, 2) - 1))" ).append("\n"); 
		query.append("           ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 2) + 1, INSTR(AA.SO, '$', 1, 3) - INSTR(AA.SO, '$', 1, 2) - 1)) SO_CRE_USR_NM " ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 3) + 1, INSTR(AA.SO, '$', 1, 4) - INSTR(AA.SO, '$', 1, 3) - 1) AS WO_NO" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 4) + 1, INSTR(AA.SO, '$', 1, 5) - INSTR(AA.SO, '$', 1, 4) - 1) AS WO_CRE_DT" ).append("\n"); 
		query.append("      ,NVL((SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 5) + 1, INSTR(AA.SO, '$', 1, 6) - INSTR(AA.SO, '$', 1, 5) - 1))" ).append("\n"); 
		query.append("           ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 5) + 1, INSTR(AA.SO, '$', 1, 6) - INSTR(AA.SO, '$', 1, 5) - 1)) WO_CRE_USR_NM" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 6) + 1, INSTR(AA.SO, '$', 1, 7) - INSTR(AA.SO, '$', 1, 6) - 1) AS VNDR_SEQ" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 7) + 1, INSTR(AA.SO, '$', 1, 8) - INSTR(AA.SO, '$', 1, 7) - 1) AS APNT_DT" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 8) + 1, INSTR(AA.SO, '$', 1, 9) - INSTR(AA.SO, '$', 1, 8) - 1) AS DE_DT" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 9) + 1, INSTR(AA.SO, '$', 1,10) - INSTR(AA.SO, '$', 1, 9) - 1) AS UMCH_FLG" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1,10) + 1, INSTR(AA.SO, '$', 1,11) - INSTR(AA.SO, '$', 1,10) - 1) AS FRST_FLG" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1,11) + 1, INSTR(AA.SO, '$', 1,12) - INSTR(AA.SO, '$', 1,11) - 1) AS TRS_SO_OFC_CD" ).append("\n"); 
		query.append("      ,SUBSTR(AA.SO, INSTR(AA.SO, '$', 1,12) + 1, INSTR(AA.SO, '$', 1,13) - INSTR(AA.SO, '$', 1,12) - 1) AS HJL_YN" ).append("\n"); 
		query.append("      ,(SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR X WHERE X.VNDR_SEQ = SUBSTR(AA.SO, INSTR(AA.SO, '$', 1, 6) + 1, INSTR(AA.SO, '$', 1, 7) - INSTR(AA.SO, '$', 1, 6) - 1)) VNDR_NM" ).append("\n"); 
		query.append("      ,(SELECT Y.CONTI_CD" ).append("\n"); 
		query.append("          FROM MDM_ORGANIZATION X," ).append("\n"); 
		query.append("               MDM_LOCATION     Y" ).append("\n"); 
		query.append("         WHERE X.LOC_CD = Y.LOC_CD" ).append("\n"); 
		query.append("           AND X.OFC_CD = AA.CTRL_OFC_CD" ).append("\n"); 
		query.append("           AND ROWNUM = 1) CONTI_CD" ).append("\n"); 
		query.append("      ,(CASE WHEN TRSP_MOD_CD = 'RD' AND CTRL_OFC_CD = 'PHXSA' THEN 'R' ELSE 'X' END) RAIL_CD" ).append("\n"); 
		query.append("      ,PKUP_AVAL_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("                /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("              #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("                /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                /*+ INDEX (A XAK2SCE_PLN_SO_LIST) */" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("               A.N1ST_NOD_PLN_DT PLN_DATE" ).append("\n"); 
		query.append("              ,A.PCTL_COST_MOD_CD SO_TP_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("              ,A.PCTL_IO_BND_CD BND_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,B.CNTR_NO" ).append("\n"); 
		query.append("              ,B.CNTR_TPSZ_CD        " ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       MVMT_STS_CD||'$'||ORG_YD_CD||'$'||TO_CHAR(CNMV_EVNT_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'||VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                 WHERE X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) MVMT" ).append("\n"); 
		query.append("              ,A.N1ST_NOD_CD  FM_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') TO_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') VIA_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') DOR_NOD_CD" ).append("\n"); 
		query.append("              ,C.POR_CD" ).append("\n"); 
		query.append("              ,C.POL_CD" ).append("\n"); 
		query.append("              ,C.POD_CD" ).append("\n"); 
		query.append("              ,C.DEL_CD " ).append("\n"); 
		query.append("              ,A.CTRL_OFC_CD" ).append("\n"); 
		query.append("              ,A.COP_NO" ).append("\n"); 
		query.append("              ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("              ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("              ,(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_WO_OFC_CTY_CD||X.TRSP_WO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(Y.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||Y.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.APNT_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.DE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.RPLN_UMCH_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_FRST_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_OFC_CD||'$'" ).append("\n"); 
		query.append("                     ||DECODE (X.HJL_NO,'', 'N','Y')||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_SO_STS_CD||'$'" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                      ,TRS_TRSP_WRK_ORD Y" ).append("\n"); 
		query.append("                 WHERE X.TRSP_WO_OFC_CTY_CD = Y.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND X.TRSP_WO_SEQ        = Y.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("                   AND X.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("                   AND X.COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("              ||(SELECT /*+ INDEX_DESC (Y XPKTRS_TRSP_EDI_RAIL_ORD) */" ).append("\n"); 
		query.append("                       X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(Y.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||Y.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_FRST_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_OFC_CD||'$'" ).append("\n"); 
		query.append("                     ||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_SO_STS_CD||'$'" ).append("\n"); 
		query.append("                   FROM TRS_TRSP_RAIL_BIL_ORD X" ).append("\n"); 
		query.append("                       ,TRS_TRSP_EDI_RAIL_ORD Y" ).append("\n"); 
		query.append("                  WHERE X.TRSP_SO_OFC_CTY_CD = Y.TRSP_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                    AND X.TRSP_SO_SEQ = Y.TRSP_SO_SEQ(+)" ).append("\n"); 
		query.append("                    AND X.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("                    AND X.COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                    AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) SO" ).append("\n"); 
		query.append("              ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                     WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND X.EQ_NO  = B.CNTR_NO" ).append("\n"); 
		query.append("                       AND X.CRE_OFC_CD = A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                       AND X.DOR_DE_ADDR IS NOT NULL" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND X.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1),'N') DO_YN" ).append("\n"); 
		query.append("              ,(SELECT TO_CHAR(X.PKUP_AVAL_DT, 'YYYY.MM.DD HH24:MI:SS')" ).append("\n"); 
		query.append("                  FROM BKG_PKUP_NTC_PKUP_NO X" ).append("\n"); 
		query.append("                      ,MDM_LOCATION         Y" ).append("\n"); 
		query.append("                 WHERE SUBSTR(X.PKUP_YD_CD,1,5) = Y.LOC_CD" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND Y.LOC_CD  = SUBSTR(B.DEL_NOD_CD, 1,5)" ).append("\n"); 
		query.append("               ) PKUP_AVAL_DT" ).append("\n"); 
		query.append("          FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("              ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("              ,BKG_BOOKING     C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("           AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND A.CTRL_OFC_CD  = @[sOfcCd]" ).append("\n"); 
		query.append("          AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("          AND A.N1ST_NOD_CD LIKE @[sFmLoc]||'%'" ).append("\n"); 
		query.append("          AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sToLoc]||'%'" ).append("\n"); 
		query.append("          #if (${sViaLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sViaLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${sDorLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sDorLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("       AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("       AND A.PCTL_COST_MOD_CD LIKE '%'           " ).append("\n"); 
		query.append("       AND A.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("       AND (A.PCTL_COST_MOD_CD = 'C' OR (A.PCTL_COST_MOD_CD = 'Z' AND A.PCTL_IO_BND_CD = 'O' AND B.CFM_OB_DOR_ARR_DT IS NULL) OR (A.PCTL_COST_MOD_CD = 'Z' AND A.PCTL_IO_BND_CD = 'I' AND B.CFM_APNT_DT IS NULL))" ).append("\n"); 
		query.append("#if (${sBndCd} == 'O' || ${sBndCd} == 'ALL') " ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("             #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("               /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("             #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("               /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("             #else" ).append("\n"); 
		query.append("               /*+ INDEX (B XAK7SCE_COP_HDR) */" ).append("\n"); 
		query.append("             #end" ).append("\n"); 
		query.append("        SELECT B.CFM_OB_DOR_ARR_DT PLN_DATE" ).append("\n"); 
		query.append("              ,A.PCTL_COST_MOD_CD SO_TP_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("              ,A.PCTL_IO_BND_CD BND_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,B.CNTR_NO" ).append("\n"); 
		query.append("              ,B.CNTR_TPSZ_CD        " ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       MVMT_STS_CD||'$'||ORG_YD_CD||'$'||TO_CHAR(CNMV_EVNT_DT, 'YYYY.MM.DD')||'$'||VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                 WHERE X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) MVMT" ).append("\n"); 
		query.append("              ,A.N1ST_NOD_CD  FM_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') TO_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') VIA_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') DOR_NOD_CD" ).append("\n"); 
		query.append("              ,C.POR_CD" ).append("\n"); 
		query.append("              ,C.POL_CD" ).append("\n"); 
		query.append("              ,C.POD_CD" ).append("\n"); 
		query.append("              ,C.DEL_CD " ).append("\n"); 
		query.append("              ,A.CTRL_OFC_CD" ).append("\n"); 
		query.append("              ,A.COP_NO" ).append("\n"); 
		query.append("              ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("              ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("              ,(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_WO_OFC_CTY_CD||X.TRSP_WO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(Y.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||Y.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.APNT_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.DE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.RPLN_UMCH_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_FRST_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_OFC_CD||'$'" ).append("\n"); 
		query.append("                     ||DECODE (X.HJL_NO,'', 'N','Y')||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_SO_STS_CD||'$'" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                      ,TRS_TRSP_WRK_ORD Y" ).append("\n"); 
		query.append("                 WHERE X.TRSP_WO_OFC_CTY_CD = Y.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND X.TRSP_WO_SEQ        = Y.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("                   AND X.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("                   AND X.COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) SO" ).append("\n"); 
		query.append("              ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                     WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND X.EQ_NO  = B.CNTR_NO" ).append("\n"); 
		query.append("                       AND X.CRE_OFC_CD = A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                       AND X.DOR_DE_ADDR IS NOT NULL" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND X.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1),'N') DO_YN" ).append("\n"); 
		query.append("              ,(SELECT TO_CHAR(X.PKUP_AVAL_DT, 'YYYY.MM.DD HH24:MI:SS')" ).append("\n"); 
		query.append("                  FROM BKG_PKUP_NTC_PKUP_NO X" ).append("\n"); 
		query.append("                      ,MDM_LOCATION         Y" ).append("\n"); 
		query.append("                 WHERE SUBSTR(X.PKUP_YD_CD,1,5) = Y.LOC_CD" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND Y.LOC_CD  = SUBSTR(B.DEL_NOD_CD, 1,5)" ).append("\n"); 
		query.append("               ) PKUP_AVAL_DT" ).append("\n"); 
		query.append("          FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("              ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("              ,BKG_BOOKING     C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("           AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND A.CTRL_OFC_CD  = @[sOfcCd]" ).append("\n"); 
		query.append("          AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("          AND A.N1ST_NOD_CD LIKE @[sFmLoc]||'%'" ).append("\n"); 
		query.append("          AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sToLoc]||'%'" ).append("\n"); 
		query.append("          #if (${sViaLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sViaLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${sDorLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sDorLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("       AND A.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("       AND A.PCTL_COST_MOD_CD = 'Z'" ).append("\n"); 
		query.append("       AND B.CFM_OB_DOR_ARR_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sBndCd} == 'I' || ${sBndCd} == 'ALL') " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("            #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("              /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("            #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("              /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("              /*+ INDEX (B XAK13SCE_COP_HDR) */" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        SELECT B.CFM_APNT_DT PLN_DATE" ).append("\n"); 
		query.append("              ,A.PCTL_COST_MOD_CD SO_TP_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("              ,A.PCTL_IO_BND_CD BND_CD" ).append("\n"); 
		query.append("              ,B.BKG_NO" ).append("\n"); 
		query.append("              ,B.CNTR_NO" ).append("\n"); 
		query.append("              ,B.CNTR_TPSZ_CD        " ).append("\n"); 
		query.append("              ,(SELECT /*+ INDEX_DESC (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       MVMT_STS_CD||'$'||ORG_YD_CD||'$'||TO_CHAR(CNMV_EVNT_DT, 'YYYY.MM.DD')||'$'||VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                 WHERE X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) MVMT" ).append("\n"); 
		query.append("              ,A.N1ST_NOD_CD  FM_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') TO_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') VIA_NOD_CD" ).append("\n"); 
		query.append("              ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') DOR_NOD_CD" ).append("\n"); 
		query.append("              ,C.POR_CD" ).append("\n"); 
		query.append("              ,C.POL_CD" ).append("\n"); 
		query.append("              ,C.POD_CD" ).append("\n"); 
		query.append("              ,C.DEL_CD " ).append("\n"); 
		query.append("              ,A.CTRL_OFC_CD" ).append("\n"); 
		query.append("              ,A.COP_NO" ).append("\n"); 
		query.append("              ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("              ,A.TRSP_MOD_CD" ).append("\n"); 
		query.append("              ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("              ,(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_WO_OFC_CTY_CD||X.TRSP_WO_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(Y.LOCL_CRE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||Y.CRE_USR_ID||'$'" ).append("\n"); 
		query.append("                     ||X.VNDR_SEQ||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.APNT_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||TO_CHAR(X.DE_DT, 'YYYY.MM.DD HH24:MI:SS')||'$'" ).append("\n"); 
		query.append("                     ||X.RPLN_UMCH_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_FRST_FLG||'$'" ).append("\n"); 
		query.append("                     ||X.CRE_OFC_CD||'$'" ).append("\n"); 
		query.append("                     ||DECODE (X.HJL_NO,'', 'N','Y')||'$'" ).append("\n"); 
		query.append("                     ||X.TRSP_SO_STS_CD||'$'" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                      ,TRS_TRSP_WRK_ORD Y" ).append("\n"); 
		query.append("                 WHERE X.TRSP_WO_OFC_CTY_CD = Y.TRSP_WO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                   AND X.TRSP_WO_SEQ        = Y.TRSP_WO_SEQ(+)" ).append("\n"); 
		query.append("                   AND X.COP_NO = A.COP_NO" ).append("\n"); 
		query.append("                   AND X.COST_ACT_GRP_SEQ = A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                   AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("                ) SO" ).append("\n"); 
		query.append("              ,NVL((SELECT 'Y'" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                     WHERE X.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                       AND X.EQ_NO  = B.CNTR_NO" ).append("\n"); 
		query.append("                       AND X.CRE_OFC_CD = A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                       AND X.DOR_DE_ADDR IS NOT NULL" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND X.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1),'N') DO_YN" ).append("\n"); 
		query.append("              ,(SELECT TO_CHAR(X.PKUP_AVAL_DT, 'YYYY.MM.DD HH24:MI:SS')" ).append("\n"); 
		query.append("                  FROM BKG_PKUP_NTC_PKUP_NO X" ).append("\n"); 
		query.append("                      ,MDM_LOCATION         Y" ).append("\n"); 
		query.append("                 WHERE SUBSTR(X.PKUP_YD_CD,1,5) = Y.LOC_CD" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = B.BKG_NO" ).append("\n"); 
		query.append("                   AND X.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND Y.LOC_CD  = SUBSTR(B.DEL_NOD_CD, 1,5)" ).append("\n"); 
		query.append("               ) PKUP_AVAL_DT" ).append("\n"); 
		query.append("          FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("              ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("              ,BKG_BOOKING     C" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("           AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("           AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("           AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #else" ).append("\n"); 
		query.append("                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                  UPPER('${key}'), " ).append("\n"); 
		query.append("                #else " ).append("\n"); 
		query.append("                  UPPER('${key}')" ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("              #end" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND A.CTRL_OFC_CD  = @[sOfcCd]" ).append("\n"); 
		query.append("          AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("          AND A.N1ST_NOD_CD LIKE @[sFmLoc]||'%'" ).append("\n"); 
		query.append("          AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sToLoc]||'%'" ).append("\n"); 
		query.append("          #if (${sViaLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sViaLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("          #if (${sDorLoc} != '') " ).append("\n"); 
		query.append("            AND TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, '') LIKE @[sDorLoc]||'%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("       AND A.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("       AND A.PCTL_COST_MOD_CD = 'Z'" ).append("\n"); 
		query.append("       AND B.CFM_APNT_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("    #if (${sDoYn} == 'Y') " ).append("\n"); 
		query.append("      AND DO_YN = 'Y'" ).append("\n"); 
		query.append("    #elseif (${sDoYn} == 'N') " ).append("\n"); 
		query.append("      AND DO_YN = 'N'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}