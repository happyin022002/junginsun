/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TransshipmentMgtDBDAOsearchTSTimeRptDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransshipmentMgtDBDAOsearchTSTimeRptDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransshipmentMgtDBDAOsearchTSTimeRptDtlRSQL
	  * </pre>
	  */
	public TransshipmentMgtDBDAOsearchTSTimeRptDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.integration").append("\n"); 
		query.append("FileName : TransshipmentMgtDBDAOsearchTSTimeRptDtlRSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM MAS_LANE_RGST CLR" ).append("\n"); 
		query.append("     , ( SELECT " ).append("\n"); 
		query.append("               MAX(VVD.POD_YD_CD)         AS POD_YD_CD" ).append("\n"); 
		query.append("              , MAX(BK.BKG_NO)            AS BKG_NO" ).append("\n"); 
		query.append("              , CNTR.CNTR_NO              AS CNTR_NO" ).append("\n"); 
		query.append("              , MAX( TT.TT_DYS)           AS STAY_DAY" ).append("\n"); 
		query.append("              , MAX(CNTR.CNTR_TPSZ_CD)    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , MAX(CNTR.CNMV_STS_CD)     AS CNMV_STS_CD    " ).append("\n"); 
		query.append("              , MAX(CNTR.CNMV_EVNT_DT)    AS EVENT_DT" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , MAX( BK.BL_NO  )          AS BL_NO" ).append("\n"); 
		query.append("              , MAX(BK.POL_CD)            AS POL_CD" ).append("\n"); 
		query.append("              , MAX(VVD.POD_CD)           AS NEXT_PORT" ).append("\n"); 
		query.append("              , MAX(BK.POD_CD )           AS POD_CD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , MAX(FRMR_VVD.SLAN_CD)                                          AS FRMR_LANE" ).append("\n"); 
		query.append("              , MAX(FRMR_VVD.VSL_CD||FRMR_VVD.SKD_VOY_NO||FRMR_VVD.SKD_DIR_CD) AS FRMR_VVD              " ).append("\n"); 
		query.append("              , MAX(TT.SLAN_CD)                                                AS NEXT_LANE                              " ).append("\n"); 
		query.append("              , TT.VSL_CD||TT.SKD_VOY_NO||TT.SKD_DIR_CD                        AS NEXT_VVD  " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              , MAX(ETD.VPS_ETD_DT)        AS ETD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , MAX( DECODE(BK.DCGO_FLG, 'Y', 'DG', DECODE(BK.RC_FLG, 'Y', 'RF', DECODE(BK.AWK_CGO_FLG, 'Y', 'AK', DECODE(BK.BB_CGO_FLG, 'Y', 'BB', '  ')))) ) AS SPECIAL" ).append("\n"); 
		query.append("              , MAX(REPLACE(SH.CUST_NM,CHR(13)||CHR(10),'') ) AS SH_NM" ).append("\n"); 
		query.append("              , MAX(REPLACE(CN.CUST_NM,CHR(13)||CHR(10),'') ) AS CN_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("              , MAX(BK.BKG_CGO_TP_CD)" ).append("\n"); 
		query.append("              , MAX(FRMR_VVD.POD_CD) FRMR_POD" ).append("\n"); 
		query.append("              , MAX(FRMR_VVD.POD_YD_CD) FRMR_YD" ).append("\n"); 
		query.append("              , MAX(ETB.VPS_ETB_DT) ETB" ).append("\n"); 
		query.append("              , MAX(TT.VSL_CD) NEXT_VSL" ).append("\n"); 
		query.append("              , MAX(NISADM.MAS_SLANE_RLANE_CONV_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, TT.SLAN_CD, VVD.POL_CD, VVD.POD_CD) ) AS RLANE_CD" ).append("\n"); 
		query.append("              , MAX(NISADM.MAS_RLANE_TRD_CONV_FNC(VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD, TT.SLAN_CD, VVD.POL_CD, VVD.POD_CD)   ) AS TRD_CD" ).append("\n"); 
		query.append("              , MAX(CASE WHEN C1.CONTI_CD = C2.CONTI_CD THEN 'I' ELSE 'O' END) IOC_CD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("        FROM CIM_PORT_TURN_TM TT, BKG_VVD VVD, BKG_CONTAINER CNTR, MDM_LOCATION C1, MDM_LOCATION C2" ).append("\n"); 
		query.append("            , BKG_BOOKING BK" ).append("\n"); 
		query.append("            , BKG_VVD FRMR_VVD" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD ETB" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD ETD" ).append("\n"); 
		query.append("            , BKG_CUSTOMER SH" ).append("\n"); 
		query.append("            , BKG_CUSTOMER CN" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("          AND VVD.BKG_NO     = CNTR.BKG_NO" ).append("\n"); 
		query.append("          AND TT.CNTR_NO     = CNTR.CNTR_NO" ).append("\n"); 
		query.append("          AND TT.VSL_CD      = VVD.VSL_CD" ).append("\n"); 
		query.append("          AND TT.SKD_VOY_NO  = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND TT.SKD_DIR_CD  = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("          #if (${period} == 'M')                                                                                                                " ).append("\n"); 
		query.append("               AND TT.TGT_MVMT_DT	BETWEEN  TO_CHAR(TO_DATE(@[from_dt],'YYYY-MM'),'YYYYMMDD')	AND TO_CHAR(LAST_DAY(TO_DATE(@[to_dt],'YYYY-MM')),'YYYYMMDD')" ).append("\n"); 
		query.append("          #else " ).append("\n"); 
		query.append("               AND	TT.TGT_YRWK	BETWEEN  REPLACE(@[from_dt],'-','')	AND REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND TT.VL_LOC_CD   = VVD.POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          --AND TT.VSL_CD= SUBSTR(:VVD,1,4)" ).append("\n"); 
		query.append("          --AND TT.SKD_VOY_NO= SUBSTR(:VVD,5,4)" ).append("\n"); 
		query.append("          --AND TT.SKD_DIR_CD= SUBSTR(:VVD,9,1)" ).append("\n"); 
		query.append("          #if (${vvd} != '')" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("              AND TT.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("              AND TT.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("              AND TT.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          #if (${location} != '')" ).append("\n"); 
		query.append("              AND  TT.VL_LOC_CD   =   @[location]" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("														" ).append("\n"); 
		query.append("          #if (${soc} == 'E') " ).append("\n"); 
		query.append("              AND  TT.SOC_FLG  = 'N' " ).append("\n"); 
		query.append("          #elseif (${soc} == 'O') " ).append("\n"); 
		query.append("              AND  TT.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("          #end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND TT.TS_FLG = 'Y'" ).append("\n"); 
		query.append("          AND VVD.POL_CD = C1.LOC_CD" ).append("\n"); 
		query.append("          AND VVD.POD_CD = C2.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND VVD.BKG_NO = BK.BKG_NO(+)" ).append("\n"); 
		query.append("          AND NVL(BK.SPLIT_RSN_CD, 'X') <> 'M'" ).append("\n"); 
		query.append("          AND BK.BKG_STS_CD   <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND BK.BKG_NO       = SH.BKG_NO(+)" ).append("\n"); 
		query.append("          AND 'S'			   = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("          AND BK.BKG_NO       = CN.BKG_NO(+)" ).append("\n"); 
		query.append("          AND 'C'			   = CN.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND BK.BKG_NO       = FRMR_VVD.BKG_NO " ).append("\n"); 
		query.append("          AND FRMR_VVD.POD_CD = VVD.POL_CD" ).append("\n"); 
		query.append("          AND FRMR_VVD.VSL_CD       = ETB.VSL_CD(+)" ).append("\n"); 
		query.append("          AND FRMR_VVD.SKD_VOY_NO   = ETB.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND FRMR_VVD.SKD_DIR_CD   = ETB.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND FRMR_VVD.POD_CD       = ETB.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND FRMR_VVD.POD_CLPT_IND_SEQ = ETB.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          AND VVD.VSL_CD       = ETD.VSL_CD(+)" ).append("\n"); 
		query.append("          AND VVD.SKD_VOY_NO   = ETD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND VVD.SKD_DIR_CD   = ETD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND VVD.POL_CD       = ETD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("          AND VVD.POL_CLPT_IND_SEQ = ETD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("          --AND ROWNUM <= 100" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          GROUP BY TT.VSL_CD||TT.SKD_VOY_NO||TT.SKD_DIR_CD ,CNTR.CNTR_NO" ).append("\n"); 
		query.append("    ) A,CIM_TP_SZ_DP_SEQ	S" ).append("\n"); 
		query.append("WHERE CLR.RLANE_CD(+) = A.RLANE_CD" ).append("\n"); 
		query.append("AND CLR.DIR_CD(+) = SUBSTR(A.NEXT_VVD,9,1)" ).append("\n"); 
		query.append("AND CLR.TRD_CD(+) = A.TRD_CD" ).append("\n"); 
		query.append("AND CLR.IOC_CD(+) = A.IOC_CD" ).append("\n"); 
		query.append("AND S.CNTR_TPSZ_CD = A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("#if (${trade} != '')" ).append("\n"); 
		query.append("    AND CLR.TRD_CD(+) = @[trade]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${p_lane} != '')" ).append("\n"); 
		query.append("    AND CLR.SUB_TRD_CD     IN  (@[p_lane])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tpsz} != 'A')" ).append("\n"); 
		query.append("    AND S.CNTR_TPSZ_DIV_CD = @[tpsz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${tpsz} != 'A')" ).append("\n"); 
		query.append("    S.CNTR_TPSZ_DIV_CD = @[tpsz]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--anD CLR.TRD_CD(+) = :trd_cd" ).append("\n"); 
		query.append("--AND CLR.SUB_TRD_cD IN (:sub_trd_cd)" ).append("\n"); 

	}
}