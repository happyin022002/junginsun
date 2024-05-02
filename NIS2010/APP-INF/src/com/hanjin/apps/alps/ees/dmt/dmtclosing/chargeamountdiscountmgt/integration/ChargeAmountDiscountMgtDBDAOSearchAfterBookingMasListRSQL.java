/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasList
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingMasListRSQL").append("\n"); 
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
		query.append("SELECT @[aft_expt_dar_no] AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("     , T2.CUST_CD" ).append("\n"); 
		query.append("     , T2.CUST_NM" ).append("\n"); 
		query.append("     , NVL(T1.LOD_QTY,0) LOD_QTY" ).append("\n"); 
		query.append("     , NVL(T1.CM_AMT, 0 ) CM_AMT" ).append("\n"); 
		query.append("     , NVL(T1.CMPB_AMT, 0) CMPB_AMT" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("SELECT @[aft_expt_dar_no] AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("      ,BB.CUST_CNT_CD||TRIM(TO_CHAR(BB.CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("      ,BB.CUST_LGL_ENG_NM CUST_NM" ).append("\n"); 
		query.append("      --,CTRT_NO AS AFT_BKG_CTRT_NO" ).append("\n"); 
		query.append("      --,CTRT_TP_CD AS BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("      ,NVL(SUM(LOAD),0) AS LOD_QTY    --LOAD" ).append("\n"); 
		query.append("      ,NVL(ROUND(SUM(BKG_REV+MISC_REV+DEM_DET) - NVL(SUM(CM_COST),0),2),0) AS CM_AMT   -- CM" ).append("\n"); 
		query.append("      ,NVL(ROUND((SUM(BKG_REV+MISC_REV+DEM_DET) - NVL(SUM(CM_COST),0) ) / SUM(LOAD),2),0)  AS CMPB_AMT   -- CMPB" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT AA.CTRT_NO CTRT_NO" ).append("\n"); 
		query.append("         , AA.CTRT_TP_CD" ).append("\n"); 
		query.append("         , CUST_CD" ).append("\n"); 
		query.append("         , SUM(DECODE(SUBSTR(D.SPCL_CNTR_TPSZ_CD,-1,1),'2', D.BKG_QTY, '3', D.BKG_QTY, D.BKG_QTY*2)) AS LOAD" ).append("\n"); 
		query.append("         , SUM(NVL(D.BKG_REV,0)+NVL(D.BKG_OFT_REV,0)) AS BKG_REV" ).append("\n"); 
		query.append("         , SUM(NVL(D.BKG_MISC_REV,0)+NVL(D.SCR_CHG_REV,0)) AS MISC_REV  " ).append("\n"); 
		query.append("         , SUM(NVL(D.PA_CM_COST_TTL_AMT, 0)) AS CM_COST" ).append("\n"); 
		query.append("         , SUM(NVL(D.DMDT_COM_AMT,0)) AS DEM_DET" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BB, MAS_BKG_EXPN_DTL_WK D, MAS_OFC_LVL L, MAS_MON_VVD V " ).append("\n"); 
		query.append("       , ( SELECT DISTINCT SC_NO CTRT_NO, 'S' CTRT_TP_CD " ).append("\n"); 
		query.append("                , C.CUST_CNT_CD||TRIM(TO_CHAR(C.CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_SP_MN A, PRI_SP_HDR B, PRI_SP_CTRT_PTY C" ).append("\n"); 
		query.append("            WHERE C.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("            AND C.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("            AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("            AND A.PROP_NO = C.PROP_NO" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT DISTINCT B.RFA_NO, 'R' CTRT_TP_CD " ).append("\n"); 
		query.append("                 , A.CTRT_CUST_CNT_CD||TRIM(TO_CHAR(A.CTRT_CUST_SEQ,'000000')) CUST_CD" ).append("\n"); 
		query.append("            FROM PRI_RP_MN A, PRI_RP_HDR B" ).append("\n"); 
		query.append("            WHERE A.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("            AND A.CTRT_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("            AND A.PROP_NO = B.PROP_NO ) AA" ).append("\n"); 
		query.append("		, ( SELECT to_char(sysdate - DECODE(@[lcc_flg],'Y3', 365 + 94, 'Y0', 365, '63', 183 + 94, '60', 183, 0),'YYYYWW') FM_WK, " ).append("\n"); 
		query.append("                   to_char(sysdate - DECODE(@[lcc_flg],'Y3', 94, '63', 94, 0),'YYYYWW')-1 TO_WK" ).append("\n"); 
		query.append("              FROM DUAL ) CC" ).append("\n"); 
		query.append("    WHERE AA.CTRT_NO IN ( BB.RFA_NO, BB.SC_NO )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND BB.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND TRIM(SUBSTR(D.SLS_YRMON, 1, 4)||D.COST_WK) BETWEEN FM_WK AND TO_WK" ).append("\n"); 
		query.append("    AND D.BL_NO_TP             IN ('M','0')" ).append("\n"); 
		query.append("    AND D.BKG_STS_CD           IN ('F','S',DECODE(NVL('','N'), 'Y', 'W'))" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND D.AGMT_SGN_OFC_CD = L.OFC_CD" ).append("\n"); 
		query.append("    AND L.OFC_LVL < '9'" ).append("\n"); 
		query.append("    AND D.SLS_YRMON  BETWEEN L.OFC_APLY_FM_YRMON AND L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND V.TRD_CD              = D.TRD_CD " ).append("\n"); 
		query.append("    AND V.RLANE_CD            = D.RLANE_CD " ).append("\n"); 
		query.append("    AND V.IOC_CD              = D.IOC_CD " ).append("\n"); 
		query.append("    AND V.VSL_CD              = D.VSL_CD " ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO          = D.SKD_VOY_NO " ).append("\n"); 
		query.append("    AND V.DIR_CD              = D.DIR_CD " ).append("\n"); 
		query.append("    AND NVL(V.DELT_FLG,'N')   = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    GROUP BY AA.CTRT_NO, AA.CTRT_TP_CD, AA.CUST_CD" ).append("\n"); 
		query.append("    ) AA, MDM_CUSTOMER BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND BB.CUST_CNT_CD = SUBSTR(AA.CUST_CD(+),1,2)" ).append("\n"); 
		query.append("  AND BB.CUST_SEQ = SUBSTR(AA.CUST_CD(+),3)" ).append("\n"); 
		query.append("  AND BB.CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  AND BB.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("GROUP BY --CTRT_NO, CTRT_TP_CD, " ).append("\n"); 
		query.append("		BB.CUST_CNT_CD||TRIM(TO_CHAR(BB.CUST_SEQ,'000000')), BB.CUST_LGL_ENG_NM ) T1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, ( SELECT @[cust_cd] CUST_CD, " ).append("\n"); 
		query.append("               ( SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],1,2) AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))) CUST_NM" ).append("\n"); 
		query.append("          FROM DUAL ) T2" ).append("\n"); 
		query.append("WHERE T1.CUST_CD(+) = T2.CUST_CD" ).append("\n"); 

	}
}