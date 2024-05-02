/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOAdjustSettlementSHVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOAdjustSettlementSHVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slot Hire Adjust조회
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOAdjustSettlementSHVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOAdjustSettlementSHVORSQL").append("\n"); 
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
		query.append("SELECT J.*" ).append("\n"); 
		query.append("     ,ROWNUM AS RN" ).append("\n"); 
		query.append("  FROM (SELECT 'R' AS IBFLAG" ).append("\n"); 
		query.append("             ,J.ACCT_YRMON" ).append("\n"); 
		query.append("             ,J.STL_VVD_SEQ" ).append("\n"); 
		query.append("             ,J.STL_SEQ" ).append("\n"); 
		query.append("             ,J.TRD_CD" ).append("\n"); 
		query.append("             ,J.JO_CRR_CD" ).append("\n"); 
		query.append("             ,J.RLANE_CD" ).append("\n"); 
		query.append("             ,J.RE_DIVR_CD" ).append("\n"); 
		query.append("             ,J.JO_STL_ITM_CD" ).append("\n"); 
		query.append("             ,J.JO_MNU_NM" ).append("\n"); 
		query.append("             ,J.VSL_CD||J.SKD_VOY_NO||J.SKD_DIR_CD||J.REV_DIR_CD AS VVD" ).append("\n"); 
		query.append("             ,J.VSL_CD" ).append("\n"); 
		query.append("             ,J.SKD_VOY_NO" ).append("\n"); 
		query.append("             ,J.SKD_DIR_CD" ).append("\n"); 
		query.append("             ,J.REV_DIR_CD" ).append("\n"); 
		query.append("             ,J.STL_BZC_PORT_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(J.ETA_DT,'YYYYMMDDHH24MISS') AS ETA_DT" ).append("\n"); 
		query.append("             ,J.JO_STL_JB_CD" ).append("\n"); 
		query.append("             -- BSA DATA가 정산후에 들어가므로..." ).append("\n"); 
		query.append("             ,J.BSA_QTY" ).append("\n"); 
		query.append("             ,J.BSA_SLT_PRC" ).append("\n"); 
		query.append("            -- JOO는 역으로 계산해야함 (COA - DIFF)" ).append("\n"); 
		query.append("             ,NVL(J.BSA_QTY,0) - NVL(K.DTL_BSA_QTY, 0) AS BSA_QTY1" ).append("\n"); 
		query.append("             ,NVL(J.BSA_SLT_PRC,0) - NVL(K.DTL_BSA_SLT_PRC, 0) AS BSA_SLT_PRC1" ).append("\n"); 
		query.append("            -- DIFF는 JOO_STL_DTL에 1이면 TEU, 2면 PRICE" ).append("\n"); 
		query.append("             ,NVL(K.DTL_BSA_QTY , 0) AS DTL_BSA_QTY" ).append("\n"); 
		query.append("             ,NVL(K.DTL_BSA_SLT_PRC, 0) AS DTL_BSA_SLT_PRC" ).append("\n"); 
		query.append("             ,J.LOCL_CURR_CD" ).append("\n"); 
		query.append("             ,J.ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("             ,J.ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("             ,J.STL_LOCL_AMT" ).append("\n"); 
		query.append("             ,J.STL_USD_AMT" ).append("\n"); 
		query.append("             ,J.IOC_CD" ).append("\n"); 
		query.append("             ,J.SCONTI_CD" ).append("\n"); 
		query.append("             ,J.FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("             ,J.FNL_BSA_WGT" ).append("\n"); 
		query.append("             ,J.USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("             ,J.USD_SLT_WGT" ).append("\n"); 
		query.append("             ,J.BSA_PER_WGT" ).append("\n"); 
		query.append("             ,J.FM_PORT_CD" ).append("\n"); 
		query.append("             ,J.TO_PORT_CD" ).append("\n"); 
		query.append("             ,J.RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("             ,J.RF_SCG_PRC" ).append("\n"); 
		query.append("             ,J.STL_RMK" ).append("\n"); 
		query.append("             ,J.CMB_CFM_FLG" ).append("\n"); 
		query.append("             ,J.STL_TJ_NO" ).append("\n"); 
		query.append("             ,C.STL_CMB_SEQ" ).append("\n"); 
		query.append("             ,J.STL_ADJ_FLG" ).append("\n"); 
		query.append("             ,J.STL_LST_FLG" ).append("\n"); 
		query.append("             ,J.PRE_ACCT_YRMON" ).append("\n"); 
		query.append("             ,J.PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("             ,J.PRE_STL_SEQ" ).append("\n"); 
		query.append("             ,J.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(J.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') AS UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("             ,J.STL_ADJ_IRR_FLG" ).append("\n"); 
		query.append("             ,J.STL_ADJ_IRR_RMK" ).append("\n"); 
		query.append("             ,TO_CHAR(J.CRE_DT,'YYYYMMDDHH24MISS') AS CRE_DT" ).append("\n"); 
		query.append("             ,J.CRE_USR_ID" ).append("\n"); 
		query.append("             ,TO_CHAR(J.UPD_DT,'YYYYMMDDHH24MISS') AS UPD_DT" ).append("\n"); 
		query.append("             ,J.UPD_USR_ID" ).append("\n"); 
		query.append("            --,C.SLIP_NO" ).append("\n"); 
		query.append("             ,C.RVS_CMB_FLG" ).append("\n"); 
		query.append("          FROM JOO_SETTLEMENT J" ).append("\n"); 
		query.append("             , (SELECT A.ACCT_YRMON" ).append("\n"); 
		query.append("                     , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     , A.STL_SEQ" ).append("\n"); 
		query.append("                     , SUM(DECODE(A.STL_DTL_SEQ,1,A.BSA_QTY)) AS DTL_BSA_QTY" ).append("\n"); 
		query.append("                     , SUM(DECODE(A.STL_DTL_SEQ,2,A.BSA_SLT_PRC)) AS DTL_BSA_SLT_PRC" ).append("\n"); 
		query.append("                  FROM JOO_STL_DTL A" ).append("\n"); 
		query.append("                 WHERE A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                 GROUP BY A.ACCT_YRMON" ).append("\n"); 
		query.append("                     , A.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     , A.STL_SEQ ) K" ).append("\n"); 
		query.append("             , (SELECT B.ACCT_YRMON" ).append("\n"); 
		query.append("                     ,B.STL_VVD_SEQ" ).append("\n"); 
		query.append("                     ,B.STL_SEQ" ).append("\n"); 
		query.append("                     ,B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                     ,A.RVS_CMB_FLG" ).append("\n"); 
		query.append("                     ,A.JO_CRR_CD" ).append("\n"); 
		query.append("                    --,A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS SLIP_NO" ).append("\n"); 
		query.append("                  FROM JOO_STL_CMB A" ).append("\n"); 
		query.append("                     , JOO_STL_CMB_DTL B" ).append("\n"); 
		query.append("                 WHERE A.ACCT_YRMON = B.ACCT_YRMON" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append("                   AND A.STL_CMB_SEQ = B.STL_CMB_SEQ" ).append("\n"); 
		query.append("                   AND A.RE_DIVR_CD = B.RE_DIVR_CD" ).append("\n"); 
		query.append("                   AND A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("                   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("                   AND A.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("                    --2010.03.09 REVERSE된 DATA는 빠진다." ).append("\n"); 
		query.append("                   --AND NVL(A.RVS_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                   --AND NVL(A.RJCT_CMB_FLG,'N') = 'N' " ).append("\n"); 
		query.append("                ) C" ).append("\n"); 
		query.append("         WHERE J.STL_VVD_SEQ = K.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("           AND J.STL_SEQ = K.STL_SEQ (+)" ).append("\n"); 
		query.append("           AND J.ACCT_YRMON = C.ACCT_YRMON (+)" ).append("\n"); 
		query.append("           AND J.STL_VVD_SEQ = C.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("           AND J.STL_SEQ = C.STL_SEQ (+)" ).append("\n"); 
		query.append("           AND J.JO_CRR_CD = C.JO_CRR_CD (+)" ).append("\n"); 
		query.append("           AND J.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("           AND J.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("           AND J.RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("           AND J.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("           AND J.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("           AND J.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("           AND J.STL_ADJ_FLG = 'Y' ) J" ).append("\n"); 
		query.append(" WHERE NVL(J.RVS_CMB_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" ORDER BY J.VVD" ).append("\n"); 
		query.append("     , J.JO_STL_JB_CD" ).append("\n"); 
		query.append("     , J.JO_MNU_NM DESC" ).append("\n"); 

	}
}