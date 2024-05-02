/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAOSearchYardExceptionCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.12
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.12.12 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCollectionOfficeMgtDBDAOSearchYardExceptionCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Yard별로 등록된 Exception Cost를 조회함.
	  * (1) DET Amount = CNTR_COST + OTR_COST + CY or DOR + STOCK 
	  * : DTIC, CTIC 인 경우, term 이 'O'(FO) 인 경우
	  * (2) DEM Amount = TML_COST + CNTR_COST + OTR_COST + CY or DOR + STOCK
	  *  : DEM Amount대상 이외 경우
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAOSearchYardExceptionCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_ib_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_ob_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAOSearchYardExceptionCostRSQL").append("\n"); 
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
		query.append("SELECT EXPT.CFM_FLG," ).append("\n"); 
		query.append("       EXPT.COST_STS,                       " ).append("\n"); 
		query.append("       YD.DMDT_OFC_CD," ).append("\n"); 
		query.append("       YD.DEM_IB_CLT_FLG," ).append("\n"); 
		query.append("       YD.YD_CD," ).append("\n"); 
		query.append("       YD.YD_NM," ).append("\n"); 
		query.append("       YD.DELT_FLG," ).append("\n"); 
		query.append("       NVL(EXPT.CURR_CD,'USD') AS CURR_CD," ).append("\n"); 
		query.append("       NVL(EXPT.DMDT_CALC_TP_CD,   (SELECT /*+ INDEX_DESC( TB DMT_CALC_TP XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                            TB.DMDT_CALC_TP_CD" ).append("\n"); 
		query.append("                                      FROM  DMT_CALC_TP TB ," ).append("\n"); 
		query.append("                                            MDM_LOCATION TC" ).append("\n"); 
		query.append("                                      WHERE TC.LOC_CD = SUBSTR(YD.YD_CD,1,5)" ).append("\n"); 
		query.append("                                      AND   ( TB.CNT_CD   =  TC.CNT_CD OR TB.CNT_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.RGN_CD   =  TC.RGN_CD OR TB.RGN_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.STE_CD   =  TC.STE_CD OR TB.STE_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   ( TB.LOC_CD   =  TC.LOC_CD OR TB.LOC_CD = ' ' )" ).append("\n"); 
		query.append("                                      AND   TB.IO_BND_CD  =  'I'" ).append("\n"); 
		query.append("                                      AND   TB.CALC_TP_SEQ = ( SELECT /*+ INDEX_DESC( TD XPKDMT_CALC_TP) */" ).append("\n"); 
		query.append("                                                                    TD.CALC_TP_SEQ" ).append("\n"); 
		query.append("                                                             FROM   DMT_CALC_TP  TD" ).append("\n"); 
		query.append("                                                             WHERE  ( TD.CNT_CD = TC.CNT_CD   OR  TD.CNT_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.RGN_CD = TC.RGN_CD   OR  TD.RGN_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.STE_CD = TC.STE_CD   OR  TD.STE_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    ( TD.LOC_CD = TC.LOC_CD   OR  TD.LOC_CD = ' ' )" ).append("\n"); 
		query.append("                                                             AND    TD.IO_BND_CD =  'I'" ).append("\n"); 
		query.append("                                                             AND    ROWNUM = 1" ).append("\n"); 
		query.append("                                                             )" ).append("\n"); 
		query.append("                                      AND  ROWNUM = 1)" ).append("\n"); 
		query.append("      ) AS DMDT_CALC_TP_CD," ).append("\n"); 
		query.append("       EXPT.TML_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.TML_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.CNTR_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.CNTR_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.CHG_COST_CY_RT_AMT," ).append("\n"); 
		query.append("       EXPT.CHG_COST_DOR_RT_AMT," ).append("\n"); 
		query.append("       EXPT.OTR_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.OTR_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("       EXPT.CNTR_COST_STK_AMT, " ).append("\n"); 
		query.append("       NVL(EXPT.DEM_CY_20FT, 0) AS DEM_CY_20FT," ).append("\n"); 
		query.append("       NVL(EXPT.DEM_CY_40FT, 0) AS DEM_CY_40FT," ).append("\n"); 
		query.append("       NVL(EXPT.DEM_DOR_20FT, 0) AS DEM_DOR_20FT," ).append("\n"); 
		query.append("       NVL(EXPT.DEM_DOR_40FT, 0) AS DEM_DOR_40FT," ).append("\n"); 
		query.append("       NVL(EXPT.DET_CY_20FT, 0) AS DET_CY_20FT," ).append("\n"); 
		query.append("       NVL(EXPT.DET_CY_40FT, 0) AS DET_CY_40FT," ).append("\n"); 
		query.append("       NVL(EXPT.DET_DOR_20FT, 0) AS DET_DOR_20FT," ).append("\n"); 
		query.append("       NVL(EXPT.DET_DOR_40FT, 0) AS DET_DOR_40FT," ).append("\n"); 
		query.append("       EXPT.EFF_DT," ).append("\n"); 
		query.append("       EXPT.EXP_DT," ).append("\n"); 
		query.append("       EXPT.CFM_DT," ).append("\n"); 
		query.append("       EXPT.CFM_USR_ID," ).append("\n"); 
		query.append("       EXPT.YD_EXPT_COST_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      NVL(A.CFM_FLG,'X') AS CFM_FLG," ).append("\n"); 
		query.append("      DECODE(NVL(A.CFM_FLG,'X'),'N','Temp. Saved','Y','Fixed','' ) AS COST_STS,                       " ).append("\n"); 
		query.append("      B.DMDT_OFC_CD," ).append("\n"); 
		query.append("      B.DEM_IB_CLT_FLG," ).append("\n"); 
		query.append("      B.YD_CD," ).append("\n"); 
		query.append("      B.YD_NM," ).append("\n"); 
		query.append("      B.DELT_FLG," ).append("\n"); 
		query.append("      A.CURR_CD," ).append("\n"); 
		query.append("      A.DMDT_CALC_TP_CD," ).append("\n"); 
		query.append("      A.TML_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("      A.TML_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("      A.CNTR_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("      A.CNTR_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("      A.CHG_COST_CY_RT_AMT," ).append("\n"); 
		query.append("      A.CHG_COST_DOR_RT_AMT," ).append("\n"); 
		query.append("      A.OTR_COST_20FT_RT_AMT," ).append("\n"); 
		query.append("      A.OTR_COST_40FT_RT_AMT," ).append("\n"); 
		query.append("      A.CNTR_COST_STK_AMT," ).append("\n"); 
		query.append("      ( NVL(A.TML_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_20FT_RT_AMT,0) + " ).append("\n"); 
		query.append("        NVL(A.OTR_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_CY_RT_AMT,0)    +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DEM_CY_20FT," ).append("\n"); 
		query.append("      ( NVL(A.TML_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_40FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_CY_RT_AMT,0)    +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DEM_CY_40FT," ).append("\n"); 
		query.append("      ( NVL(A.TML_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_20FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_DOR_RT_AMT,0)   +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)  ) AS DEM_DOR_20FT," ).append("\n"); 
		query.append("      ( NVL(A.TML_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_40FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_DOR_RT_AMT,0)   +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DEM_DOR_40FT," ).append("\n"); 
		query.append("      ( NVL(A.CNTR_COST_20FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_CY_RT_AMT,0)    +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DET_CY_20FT," ).append("\n"); 
		query.append("      ( NVL(A.CNTR_COST_40FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_CY_RT_AMT,0)    +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DET_CY_40FT," ).append("\n"); 
		query.append("      ( NVL(A.CNTR_COST_20FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_20FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_DOR_RT_AMT,0)   +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)  ) AS DET_DOR_20FT," ).append("\n"); 
		query.append("      ( NVL(A.CNTR_COST_40FT_RT_AMT,0) +" ).append("\n"); 
		query.append("        NVL(A.OTR_COST_40FT_RT_AMT,0)  + " ).append("\n"); 
		query.append("        NVL(A.CHG_COST_DOR_RT_AMT,0)   +" ).append("\n"); 
		query.append("        NVL(A.CNTR_COST_STK_AMT,0)   ) AS DET_DOR_40FT," ).append("\n"); 
		query.append("      TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT," ).append("\n"); 
		query.append("      TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT," ).append("\n"); 
		query.append("      TO_CHAR(A.CFM_DT,'YYYY-MM-DD') AS CFM_DT," ).append("\n"); 
		query.append("      A.CFM_USR_ID," ).append("\n"); 
		query.append("      A.YD_EXPT_COST_SEQ" ).append("\n"); 
		query.append("FROM DMT_YD_EXPT_COST A," ).append("\n"); 
		query.append("     MDM_YARD B" ).append("\n"); 
		query.append("WHERE A.YD_CD(+) = B.YD_CD" ).append("\n"); 
		query.append("#if ( ${ofc_cd} != '' )" ).append("\n"); 
		query.append("AND	B.DMDT_OFC_CD IN (" ).append("\n"); 
		query.append("   #foreach( $dmdt_ofc_cd in ${dmtOfcList}) " ).append("\n"); 
		query.append("     #if($velocityCount < $dmtOfcList.size()) " ).append("\n"); 
		query.append("        '$dmdt_ofc_cd', " ).append("\n"); 
		query.append("     #else " ).append("\n"); 
		query.append("        '$dmdt_ofc_cd' " ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dem_ib_clt_flg} != 'A' )" ).append("\n"); 
		query.append("AND B.DEM_IB_CLT_FLG =  @[dem_ib_clt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dem_ob_clt_flg} != 'A' )" ).append("\n"); 
		query.append("AND B.DEM_OB_CLT_FLG =  @[dem_ob_clt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cnt_cd} != '' )" ).append("\n"); 
		query.append("AND SUBSTR(A.YD_CD,1,2) =  @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_cd} != '' )" ).append("\n"); 
		query.append("AND A.YD_CD LIKE  @[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_delt_flg} != 'A' )" ).append("\n"); 
		query.append("AND B.DELT_FLG =  @[yd_delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'MA' )" ).append("\n"); 
		query.append("AND B.YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'CY' )" ).append("\n"); 
		query.append("AND B.YD_FCTY_TP_CY_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'CF' )" ).append("\n"); 
		query.append("AND B.YD_FCTY_TP_CFS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'RA' )" ).append("\n"); 
		query.append("AND B.YD_FCTY_TP_RAIL_RMP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'BA' )" ).append("\n"); 
		query.append("AND B.YD_FCTY_TP_BRG_RMP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'Y' &&  ${chk_tobe} == 'Y' &&  ${chk_expired} == 'N' )" ).append("\n"); 
		query.append("AND (  (SYSDATE BETWEEN A.EFF_DT AND  NVL(A.EXP_DT,SYSDATE))" ).append("\n"); 
		query.append("     OR SYSDATE < A.EFF_DT )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'Y' &&  ${chk_tobe} == 'N' &&  ${chk_expired} == 'N' )" ).append("\n"); 
		query.append("AND SYSDATE BETWEEN A.EFF_DT AND  NVL(A.EXP_DT,SYSDATE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'Y' &&  ${chk_tobe} == 'N' &&  ${chk_expired} == 'Y' )" ).append("\n"); 
		query.append("AND ( (SYSDATE BETWEEN A.EFF_DT AND  NVL(A.EXP_DT,SYSDATE))" ).append("\n"); 
		query.append("    OR SYSDATE > NVL(A.EXP_DT,SYSDATE))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'N' &&  ${chk_tobe} == 'Y' &&  ${chk_expired} == 'Y' )" ).append("\n"); 
		query.append("AND (   SYSDATE < A.EFF_DT" ).append("\n"); 
		query.append("     OR SYSDATE > NVL(A.EXP_DT,SYSDATE))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'N' &&  ${chk_tobe} == 'Y' &&  ${chk_expired} == 'N' )" ).append("\n"); 
		query.append("AND SYSDATE < A.EFF_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${chk_current} == 'N' &&  ${chk_tobe} == 'N' &&  ${chk_expired} == 'Y' )" ).append("\n"); 
		query.append("AND  SYSDATE > NVL(A.EXP_DT,SYSDATE)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") EXPT, " ).append("\n"); 
		query.append("  MDM_YARD YD" ).append("\n"); 
		query.append("WHERE EXPT.YD_CD(+) = YD.YD_CD" ).append("\n"); 
		query.append("#if ( ${ofc_cd} != '' )" ).append("\n"); 
		query.append("AND	YD.DMDT_OFC_CD IN (" ).append("\n"); 
		query.append("   #foreach( $dmdt_ofc_cd in ${dmtOfcList}) " ).append("\n"); 
		query.append("     #if($velocityCount < $dmtOfcList.size()) " ).append("\n"); 
		query.append("        '$dmdt_ofc_cd', " ).append("\n"); 
		query.append("     #else " ).append("\n"); 
		query.append("        '$dmdt_ofc_cd' " ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dem_ib_clt_flg} != 'A' )" ).append("\n"); 
		query.append("AND YD.DEM_IB_CLT_FLG =  @[dem_ib_clt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${dem_ob_clt_flg} != 'A' )" ).append("\n"); 
		query.append("AND YD.DEM_OB_CLT_FLG =  @[dem_ob_clt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cnt_cd} != '' )" ).append("\n"); 
		query.append("AND SUBSTR(YD.YD_CD,1,2) =  @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_cd} != '' )" ).append("\n"); 
		query.append("AND YD.YD_CD LIKE  @[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_delt_flg} != 'A' )" ).append("\n"); 
		query.append("AND YD.DELT_FLG =  @[yd_delt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'MA' )" ).append("\n"); 
		query.append("AND YD.YD_FCTY_TP_MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'CY' )" ).append("\n"); 
		query.append("AND YD.YD_FCTY_TP_CY_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'CF' )" ).append("\n"); 
		query.append("AND YD.YD_FCTY_TP_CFS_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'RA' )" ).append("\n"); 
		query.append("AND YD.YD_FCTY_TP_RAIL_RMP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${yd_type} == 'BA' )" ).append("\n"); 
		query.append("AND YD.YD_FCTY_TP_BRG_RMP_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${cfm_flg} != 'A' )" ).append("\n"); 
		query.append("AND  NVL(EXPT.CFM_FLG,'X') =  @[cfm_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY YD.YD_CD, EXPT.YD_EXPT_COST_SEQ" ).append("\n"); 

	}
}