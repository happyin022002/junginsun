/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DeliveryMonitorDBDAOsearchDeliveryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.19
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2015.06.19 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DeliveryMonitorDBDAOsearchDeliveryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Delivery Monitoring Summary 조회
	  * </pre>
	  */
	public DeliveryMonitorDBDAOsearchDeliveryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("sDrNm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sDrLoc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sFmLoc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sViaLoc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration").append("\n"); 
		query.append("FileName : DeliveryMonitorDBDAOsearchDeliveryRSQL").append("\n"); 
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
		query.append("SELECT YR_WEEK" ).append("\n"); 
		query.append("      ,DT_PERIOD" ).append("\n"); 
		query.append("      ,SO_OFC_CD" ).append("\n"); 
		query.append("      ,SO_TP_CD" ).append("\n"); 
		query.append("      ,BND_CD" ).append("\n"); 
		query.append("      ,FM_NOD_CD" ).append("\n"); 
		query.append("      ,TO_NOD_CD" ).append("\n"); 
		query.append("      ,VIA_NOD_CD" ).append("\n"); 
		query.append("      ,DOR_NOD_CD" ).append("\n"); 
		query.append("      ,(SELECT ZN_NM FROM MDM_ZONE X WHERE X.ZN_CD = DOR_NOD_CD||'01') DOR_NM" ).append("\n"); 
		query.append("      ,FM_DT" ).append("\n"); 
		query.append("      ,TO_DT" ).append("\n"); 
		query.append("      ,SO_CNT" ).append("\n"); 
		query.append("      ,WO_CNT" ).append("\n"); 
		query.append("      ,DO_CNT" ).append("\n"); 
		query.append("      ,CNTR_CNT" ).append("\n"); 
		query.append("      ,CASE WHEN BKG_CNT <= 921 THEN TO_CHAR(SUBSTR(BKG_DESC, 1, 3990)) END BKG_DESC" ).append("\n"); 
		query.append("      ,CASE WHEN BKG_CNT > 307 AND BKG_CNT <= 921 THEN TO_CHAR(SUBSTR(BKG_DESC, 3991, 3991)) END BKG_DESC2" ).append("\n"); 
		query.append("      ,CASE WHEN BKG_CNT > 614 AND BKG_CNT <= 921 THEN TO_CHAR(SUBSTR(BKG_DESC, 7982, 3991)) END BKG_DESC3" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT WK YR_WEEK" ).append("\n"); 
		query.append("          ,MIN(TO_CHAR(WK_FM_DT,'YYYY.MM.DD')) || '~' ||MIN(TO_CHAR(WK_TO_DT,'YYYY.MM.DD')) DT_PERIOD" ).append("\n"); 
		query.append("          ,CTRL_OFC_CD SO_OFC_CD" ).append("\n"); 
		query.append("          ,PCTL_COST_MOD_CD SO_TP_CD" ).append("\n"); 
		query.append("          ,PCTL_IO_BND_CD BND_CD" ).append("\n"); 
		query.append("          ,FM_NOD_CD" ).append("\n"); 
		query.append("          ,TO_NOD_CD" ).append("\n"); 
		query.append("          ,VIA_NOD_CD" ).append("\n"); 
		query.append("          ,DOR_NOD_CD" ).append("\n"); 
		query.append("          ,MIN(TO_CHAR(DT, 'YYYYMMDD')) FM_DT" ).append("\n"); 
		query.append("          ,MAX(TO_CHAR(DT, 'YYYYMMDD')) TO_DT" ).append("\n"); 
		query.append("          ,COUNT(SO_NO)  SO_CNT" ).append("\n"); 
		query.append("          ,COUNT(WO_NO)  WO_CNT" ).append("\n"); 
		query.append("          ,COUNT(DO_NO)  DO_CNT" ).append("\n"); 
		query.append("          ,COUNT(*) CNTR_CNT" ).append("\n"); 
		query.append("          ,COUNT(BKG_NO) BKG_CNT" ).append("\n"); 
		query.append("          ,SUBSTR(XMLAGG(XMLELEMENT(X, ',', BKG_NO) ORDER BY BKG_NO).EXTRACT('//text()').getCLOBVal() ,2) BKG_DESC" ).append("\n"); 
		query.append("      FROM ( SELECT CTRL_OFC_CD" ).append("\n"); 
		query.append("                  ,TRSP_SO_STS_CD" ).append("\n"); 
		query.append("                  ,PCTL_COST_MOD_CD" ).append("\n"); 
		query.append("                  ,N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                  ,COP_NO" ).append("\n"); 
		query.append("                  ,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                  ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                  ,FM_NOD_CD" ).append("\n"); 
		query.append("                  ,TO_NOD_CD" ).append("\n"); 
		query.append("                  ,VIA_NOD_CD" ).append("\n"); 
		query.append("                  ,DOR_NOD_CD" ).append("\n"); 
		query.append("                  ,SUBSTR(AA.WK, 1, INSTR(AA.WK, '$', 1, 1) - 1) AS WK" ).append("\n"); 
		query.append("                  ,TO_DATE(SUBSTR(AA.WK, INSTR(AA.WK, '$', 1, 1) + 1, INSTR(AA.WK, '$', 1, 2) - INSTR(AA.WK, '$', 1, 1) - 1), 'YYYYMMDD') AS WK_FM_DT" ).append("\n"); 
		query.append("                  ,TO_DATE(SUBSTR(AA.WK, INSTR(AA.WK, '$', 1, 2) + 1, INSTR(AA.WK, '$', 1, 3) - INSTR(AA.WK, '$', 1, 2) - 1), 'YYYYMMDD') AS WK_TO_DT" ).append("\n"); 
		query.append("                  ,DT" ).append("\n"); 
		query.append("                  ,BKG_NO" ).append("\n"); 
		query.append("                  ,(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                     WHERE X.COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("                       AND X.COST_ACT_GRP_SEQ = AA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("                 ||(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_RAIL_BIL_ORD X" ).append("\n"); 
		query.append("                     WHERE X.COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("                       AND X.COST_ACT_GRP_SEQ = AA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) SO_NO" ).append("\n"); 
		query.append("                  ,(SELECT Y.TRSP_WO_OFC_CTY_CD||Y.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                          ,TRS_TRSP_WRK_ORD Y" ).append("\n"); 
		query.append("                     WHERE X.TRSP_WO_OFC_CTY_CD = Y.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("                       AND X.TRSP_WO_SEQ = Y.TRSP_WO_SEQ" ).append("\n"); 
		query.append("                       AND X.COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("                       AND X.COST_ACT_GRP_SEQ = AA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1) " ).append("\n"); 
		query.append("                 ||(SELECT X.TRSP_SO_OFC_CTY_CD||X.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_RAIL_BIL_ORD X" ).append("\n"); 
		query.append("                          ,TRS_TRSP_EDI_RAIL_ORD Y" ).append("\n"); 
		query.append("                     WHERE X.TRSP_SO_OFC_CTY_CD = Y.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                       AND X.TRSP_SO_SEQ = Y.TRSP_SO_SEQ" ).append("\n"); 
		query.append("                       AND X.COP_NO = AA.COP_NO" ).append("\n"); 
		query.append("                       AND X.COST_ACT_GRP_SEQ = AA.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1" ).append("\n"); 
		query.append("                   ) WO_NO" ).append("\n"); 
		query.append("                  ,(SELECT X.BL_NO||X.EQ_NO" ).append("\n"); 
		query.append("                      FROM TRS_TRSP_SVC_ORD X" ).append("\n"); 
		query.append("                     WHERE X.BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("                       AND X.EQ_NO  = AA.CNTR_NO" ).append("\n"); 
		query.append("                       AND X.CRE_OFC_CD = AA.CTRL_OFC_CD" ).append("\n"); 
		query.append("                       AND X.DOR_DE_ADDR IS NOT NULL" ).append("\n"); 
		query.append("                       AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                       AND X.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1) DO_NO" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                          #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("                          #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            /*+ INDEX (A XAK2SCE_PLN_SO_LIST) */" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                           A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                          ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("                          ,A.PCTL_COST_MOD_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("                          ,A.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                          ,A.COP_NO" ).append("\n"); 
		query.append("                          ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                          ,A.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                          ,SUBSTR(A.N1ST_NOD_CD,1,5)  FM_NOD_CD" ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     TO_NOD_CD     " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     VIA_NOD_CD   " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     DOR_NOD_CD" ).append("\n"); 
		query.append("                          ,(SELECT WK.COST_YR||WK.COST_WK||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_FM_DT||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_TO_DT||'$'" ).append("\n"); 
		query.append("                              FROM MAS_WK_PRD WK" ).append("\n"); 
		query.append("                             WHERE A.N1ST_NOD_PLN_DT BETWEEN TO_DATE (WK.SLS_FM_DT, 'rrrrmmdd') AND TO_DATE (WK.SLS_TO_DT, 'rrrrmmdd') + 0.99999" ).append("\n"); 
		query.append("                           ) WK" ).append("\n"); 
		query.append("                          ,A.N1ST_NOD_PLN_DT DT" ).append("\n"); 
		query.append("                          ,B.BKG_NO" ).append("\n"); 
		query.append("                          ,B.CNTR_NO" ).append("\n"); 
		query.append("                      FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("                          ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0 || $arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("                            AND A.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_ofc_cd}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_ofc_cd.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sBndCd} != '' && ${sBndCd} != 'ALL')" ).append("\n"); 
		query.append("                            AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("                            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                       AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("                       AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("                       AND A.PCTL_COST_MOD_CD LIKE '%'           " ).append("\n"); 
		query.append("                       AND A.N1ST_NOD_PLN_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                       AND (A.PCTL_COST_MOD_CD = 'C' OR (A.PCTL_COST_MOD_CD = 'Z' AND A.PCTL_IO_BND_CD = 'O' AND B.CFM_OB_DOR_ARR_DT IS NULL) OR (A.PCTL_COST_MOD_CD = 'Z' AND A    .PCTL_IO_BND_CD = 'I' AND B.CFM_APNT_DT IS NULL))" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                          #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("                          #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK7SCE_COP_HDR) */" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                           A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                          ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("                          ,A.PCTL_COST_MOD_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("                          ,A.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                          ,A.COP_NO" ).append("\n"); 
		query.append("                          ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                          ,A.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("                          ,SUBSTR(A.N1ST_NOD_CD,1,5)  FM_NOD_CD" ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     TO_NOD_CD     " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     VIA_NOD_CD   " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     DOR_NOD_CD" ).append("\n"); 
		query.append("                          ,(SELECT WK.COST_YR||WK.COST_WK||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_FM_DT||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_TO_DT||'$'" ).append("\n"); 
		query.append("                              FROM MAS_WK_PRD WK" ).append("\n"); 
		query.append("                             WHERE B.CFM_OB_DOR_ARR_DT BETWEEN TO_DATE (WK.SLS_FM_DT, 'rrrrmmdd') AND TO_DATE (WK.SLS_TO_DT, 'rrrrmmdd') + 0.99999" ).append("\n"); 
		query.append("                           ) WK" ).append("\n"); 
		query.append("                          ,B.CFM_OB_DOR_ARR_DT DT" ).append("\n"); 
		query.append("                          ,B.BKG_NO" ).append("\n"); 
		query.append("                          ,B.CNTR_NO" ).append("\n"); 
		query.append("                      FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("                          ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0 || $arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("                            AND A.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_ofc_cd}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_ofc_cd.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sBndCd} != '' && ${sBndCd} != 'ALL')" ).append("\n"); 
		query.append("                            AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("                            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                       AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("                       AND A.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                       AND A.PCTL_COST_MOD_CD = 'Z'" ).append("\n"); 
		query.append("                       AND B.CFM_OB_DOR_ARR_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                          #if ($arr_bkg_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK1SCE_COP_HDR) */" ).append("\n"); 
		query.append("                          #elseif ($arr_cntr_no.size() > 0)" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK9SCE_COP_HDR) ORDERED */" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            /*+ INDEX (B XAK13SCE_COP_HDR) */" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                           A.CTRL_OFC_CD" ).append("\n"); 
		query.append("                          ,A.TRSP_SO_STS_CD" ).append("\n"); 
		query.append("                          ,A.PCTL_COST_MOD_CD -- C: CY, Z: ZONE" ).append("\n"); 
		query.append("                          ,A.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("                          ,A.COP_NO" ).append("\n"); 
		query.append("                          ,A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                          ,A.PCTL_IO_BND_CD                    " ).append("\n"); 
		query.append("                          ,SUBSTR(A.N1ST_NOD_CD,1,5)  FM_NOD_CD" ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('TO' , A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     TO_NOD_CD     " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('VIA', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     VIA_NOD_CD   " ).append("\n"); 
		query.append("                          ,TRS_CYDOOR_COMM_PKG.GET_SO_NODE_FNC('DOR', A.PCTL_IO_BND_CD, A.PCTL_COST_MOD_CD, A.N1ST_NOD_CD, A.N2ND_NOD_CD, A.N3RD_NOD_CD, A.N4TH_NOD_CD, 'NODE')     DOR_NOD_CD" ).append("\n"); 
		query.append("                          ,(SELECT WK.COST_YR||WK.COST_WK||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_FM_DT||'$'" ).append("\n"); 
		query.append("                                  ||WK.SLS_TO_DT||'$'" ).append("\n"); 
		query.append("                              FROM MAS_WK_PRD WK" ).append("\n"); 
		query.append("                             WHERE B.CFM_APNT_DT BETWEEN TO_DATE (WK.SLS_FM_DT, 'rrrrmmdd') AND TO_DATE (WK.SLS_TO_DT, 'rrrrmmdd') + 0.99999" ).append("\n"); 
		query.append("                           ) WK" ).append("\n"); 
		query.append("                          ,B.CFM_APNT_DT DT" ).append("\n"); 
		query.append("                          ,B.BKG_NO" ).append("\n"); 
		query.append("                          ,B.CNTR_NO" ).append("\n"); 
		query.append("                      FROM SCE_PLN_SO_LIST A" ).append("\n"); 
		query.append("                          ,SCE_COP_HDR     B" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0 || $arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                     WHERE A.COP_NO = B.COP_NO" ).append("\n"); 
		query.append("                          #if($arr_so_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.SO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_so_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_wo_no.size() > 0) " ).append("\n"); 
		query.append("                            AND A.COP_NO = SO.COP_NO" ).append("\n"); 
		query.append("                            AND A.COST_ACT_GRP_SEQ = SO.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("                            AND SO.WO_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} IN ${arr_wo_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount == 1) " ).append("\n"); 
		query.append("                                  ( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #else" ).append("\n"); 
		query.append("                                 ,( SUBSTR('${key}',1,3),SUBSTR('${key}',4) )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("                            AND A.CTRL_OFC_CD IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_ofc_cd}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_ofc_cd.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_bkg_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.BKG_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_bkg_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_bkg_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if($arr_cntr_no.size() > 0) " ).append("\n"); 
		query.append("                            AND B.CNTR_NO IN (" ).append("\n"); 
		query.append("                              #foreach( ${key} in ${arr_cntr_no}) " ).append("\n"); 
		query.append("                                #if($velocityCount < $arr_cntr_no.size()) " ).append("\n"); 
		query.append("                                  UPPER('${key}'), " ).append("\n"); 
		query.append("                                #else " ).append("\n"); 
		query.append("                                  UPPER('${key}')" ).append("\n"); 
		query.append("                                #end " ).append("\n"); 
		query.append("                              #end" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sBndCd} != '' && ${sBndCd} != 'ALL')" ).append("\n"); 
		query.append("                            AND A.PCTL_IO_BND_CD = @[sBndCd]" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("                          #if (${sStsCd} != '') " ).append("\n"); 
		query.append("                            #if (${sStsCd} == 'P')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD = 'P'" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'C')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('C', 'R')" ).append("\n"); 
		query.append("                            #elseif (${sStsCd} == 'I')" ).append("\n"); 
		query.append("                              AND A.TRSP_SO_STS_CD IN ('I')" ).append("\n"); 
		query.append("                            #end" ).append("\n"); 
		query.append("                          #else" ).append("\n"); 
		query.append("                            AND A.TRSP_SO_STS_CD LIKE '%'" ).append("\n"); 
		query.append("                          #end" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'M'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'O'" ).append("\n"); 
		query.append("                       AND B.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                       AND DECODE (B.MST_COP_NO, B.COP_NO, 'P', 'X') = 'P'" ).append("\n"); 
		query.append("                       AND A.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                       AND A.PCTL_COST_MOD_CD = 'Z'" ).append("\n"); 
		query.append("                       AND B.CFM_APNT_DT BETWEEN TO_DATE(@[sFromDt], 'YYYYMMDD') AND TO_DATE(@[sToDt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                    ) AA" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("            #if (${sDrNm} != '') " ).append("\n"); 
		query.append("              AND EXISTS (SELECT 1 " ).append("\n"); 
		query.append("                            FROM MDM_ZONE X" ).append("\n"); 
		query.append("                           WHERE X.ZN_CD BETWEEN DOR_NOD_CD||'01' AND DOR_NOD_CD||'99'" ).append("\n"); 
		query.append("                             AND UPPER(ZN_NM) LIKE UPPER('%'|| @[sDrNm] ||'%')   " ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${sFmLoc} != '') " ).append("\n"); 
		query.append("              AND FM_NOD_CD LIKE @[sFmLoc]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${sToLoc} != '') " ).append("\n"); 
		query.append("              AND TO_NOD_CD LIKE @[sToLoc]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${sViaLoc} != '') " ).append("\n"); 
		query.append("              AND VIA_NOD_CD LIKE @[sViaLoc]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("            #if (${sDrLoc} != '') " ).append("\n"); 
		query.append("              AND DOR_NOD_CD LIKE @[sDrLoc]||'%'" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("             ) AAA" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("            #if (${sDoYn} == 'Y') " ).append("\n"); 
		query.append("              AND DO_NO IS NOT NULL" ).append("\n"); 
		query.append("            #elseif (${sDoYn} == 'N') " ).append("\n"); 
		query.append("              AND DO_NO IS NULL" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("    GROUP BY WK" ).append("\n"); 
		query.append("          ,CTRL_OFC_CD" ).append("\n"); 
		query.append("          ,PCTL_COST_MOD_CD" ).append("\n"); 
		query.append("          ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("          ,FM_NOD_CD" ).append("\n"); 
		query.append("          ,TO_NOD_CD" ).append("\n"); 
		query.append("          ,VIA_NOD_CD" ).append("\n"); 
		query.append("          ,DOR_NOD_CD" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}