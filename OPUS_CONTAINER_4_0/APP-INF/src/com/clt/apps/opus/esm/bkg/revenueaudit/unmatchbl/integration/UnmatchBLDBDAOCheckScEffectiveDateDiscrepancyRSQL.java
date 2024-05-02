/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckScEffectiveDateDiscrepancyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckScEffectiveDateDiscrepancyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckScEffectiveDateDiscrepancy
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckScEffectiveDateDiscrepancyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckScEffectiveDateDiscrepancyRSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("SC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("계약 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT  SS.PROP_NO    ," ).append("\n"); 
		query.append("        SS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        SS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BOOKING     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_SP_HDR      SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN       SM  ," ).append("\n"); 
		query.append("        PRI_SP_SCP_MN   SS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     SH.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("AND     SM.PROP_NO      = SH.PROP_NO" ).append("\n"); 
		query.append("AND     SM.PROP_STS_CD  = 'F'       -- FILED S/C" ).append("\n"); 
		query.append("AND     SS.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("AND     SS.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SS.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT * FROM (" ).append("\n"); 
		query.append("SELECT  SS.PROP_NO    ," ).append("\n"); 
		query.append("        SS.AMDT_SEQ   ," ).append("\n"); 
		query.append("        SS.SVC_SCP_CD" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS     BK  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L1  ," ).append("\n"); 
		query.append("        MDM_LOCATION    L4  ," ).append("\n"); 
		query.append("        PRI_SP_HDR      SH  ," ).append("\n"); 
		query.append("        PRI_SP_MN       SM  ," ).append("\n"); 
		query.append("        PRI_SP_SCP_MN   SS" ).append("\n"); 
		query.append("WHERE   L1.LOC_CD       = BK.POR_CD" ).append("\n"); 
		query.append("AND     L4.LOC_CD       = BK.DEL_CD" ).append("\n"); 
		query.append("AND     SH.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("AND     SM.PROP_NO      = SH.PROP_NO" ).append("\n"); 
		query.append("AND     SM.PROP_STS_CD  = 'F'       -- FILED S/C" ).append("\n"); 
		query.append("AND     SS.PROP_NO      = SM.PROP_NO" ).append("\n"); 
		query.append("AND     SS.AMDT_SEQ     = SM.AMDT_SEQ" ).append("\n"); 
		query.append("AND     SS.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("AND     ( SELECT BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_DT_FNC(@[bkg_no], @[ca_flg]) FROM DUAL )" ).append("\n"); 
		query.append("        BETWEEN SS.EFF_DT AND SS.EXP_DT" ).append("\n"); 
		query.append("AND     BK.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND     BK.CORR_NO      = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND     @[ca_flg]       = 'Y'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("BK AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("BKG 정보 조회" ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  BK.SC_NO       ," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD  ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_TP_FNC (@[bkg_no], @[ca_flg])  REV_APLY_TP_CD  ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_RT_APLY_DT_FNC  (@[bkg_no], @[ca_flg])  RT_APLY_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_CGO_RCV_DT_FNC  (@[bkg_no], @[ca_flg])  CGO_RCV_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC      (@[bkg_no], @[ca_flg])  POL_ETD_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_ETB_DT_FNC      (@[bkg_no], @[ca_flg])  POL_ETB_DT" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND     @[ca_flg]   = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  BK.SC_NO       ," ).append("\n"); 
		query.append("        BK.SVC_SCP_CD  ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_REV_APLY_TP_FNC (@[bkg_no], @[ca_flg])  REV_APLY_TP_CD  ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_RT_APLY_DT_FNC  (@[bkg_no], @[ca_flg])  RT_APLY_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_CGO_RCV_DT_FNC  (@[bkg_no], @[ca_flg])  CGO_RCV_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_ETD_DT_FNC      (@[bkg_no], @[ca_flg])  POL_ETD_DT      ," ).append("\n"); 
		query.append("        BKG_REV_APLY_DT_PKG.BKG_GET_ETB_DT_FNC      (@[bkg_no], @[ca_flg])  POL_ETB_DT" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS BK" ).append("\n"); 
		query.append("WHERE   BK.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND     BK.CORR_NO  = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("AND     @[ca_flg]   = 'Y'" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("C1 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CASE" ).append("\n"); 
		query.append("        WHEN  BK.REV_APLY_TP_CD = 'C'" ).append("\n"); 
		query.append("          THEN  '[CRD][' || TO_CHAR(BK.CGO_RCV_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        ELSE  '[POL ETD][' || TO_CHAR(BK.POL_ETD_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        END   BKG_ITM_LOG   ," ).append("\n"); 
		query.append("        '[Effective Date][' || TO_CHAR(SD.CTRT_EFF_DT, 'YYYY-MM-DD') || ']' || CHR(10) || '[Expiration Date][' || TO_CHAR(SD.CTRT_EXP_DT, 'YYYY-MM-DD') || ']'  CTRT_ITM_LOG" ).append("\n"); 
		query.append("FROM    BK  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        /* S/C Duration */" ).append("\n"); 
		query.append("        SELECT  SD.CTRT_EFF_DT    ," ).append("\n"); 
		query.append("                SD.CTRT_EXP_DT" ).append("\n"); 
		query.append("        FROM    SC  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_DUR  SD" ).append("\n"); 
		query.append("        WHERE   SD.PROP_NO      = SC.PROP_NO" ).append("\n"); 
		query.append("        AND     SD.AMDT_SEQ     = SC.AMDT_SEQ" ).append("\n"); 
		query.append("        AND     SD.SVC_SCP_CD   = SC.SVC_SCP_CD" ).append("\n"); 
		query.append("        ) SD" ).append("\n"); 
		query.append("WHERE   CASE" ).append("\n"); 
		query.append("        WHEN      BK.REV_APLY_TP_CD = 'C'" ).append("\n"); 
		query.append("              AND NVL(BK.CGO_RCV_DT, SD.CTRT_EFF_DT) BETWEEN SD.CTRT_EFF_DT AND SD.CTRT_EXP_DT" ).append("\n"); 
		query.append("          THEN  'Y'" ).append("\n"); 
		query.append("        WHEN      BK.REV_APLY_TP_CD <> 'C'" ).append("\n"); 
		query.append("              AND (" ).append("\n"); 
		query.append("                      NVL(BK.POL_ETD_DT, BK.RT_APLY_DT) BETWEEN SD.CTRT_EFF_DT AND SD.CTRT_EXP_DT" ).append("\n"); 
		query.append("                  OR  NVL(BK.POL_ETB_DT, BK.RT_APLY_DT) BETWEEN SD.CTRT_EFF_DT AND SD.CTRT_EXP_DT" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("          THEN  'Y'" ).append("\n"); 
		query.append("        ELSE  'N'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  CASE" ).append("\n"); 
		query.append("        WHEN  BK.REV_APLY_TP_CD = 'C'" ).append("\n"); 
		query.append("          THEN  '[CRD][' || TO_CHAR(BK.CGO_RCV_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        ELSE  '[POL ETD][' || TO_CHAR(BK.POL_ETD_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        END   BKG_ITM_LOG   ," ).append("\n"); 
		query.append("        '[Effective Date][' || TO_CHAR(SD.CTRT_EFF_DT, 'YYYY-MM-DD') || ']' || CHR(10) || '[Expiration Date][' || TO_CHAR(SD.CTRT_EXP_DT, 'YYYY-MM-DD') || ']'  CTRT_ITM_LOG" ).append("\n"); 
		query.append("FROM    BK  ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  SD.CTRT_EFF_DT    ," ).append("\n"); 
		query.append("                SD.CTRT_EXP_DT    ," ).append("\n"); 
		query.append("                ROW_NUMBER() OVER ( ORDER BY SD.AMDT_SEQ DESC )  ROW_NUMBER" ).append("\n"); 
		query.append("        FROM    BK  ," ).append("\n"); 
		query.append("                PRI_SP_HDR      SH  ," ).append("\n"); 
		query.append("                PRI_SP_SCP_DUR  SD" ).append("\n"); 
		query.append("        WHERE   SH.SC_NO        = BK.SC_NO" ).append("\n"); 
		query.append("        AND     SD.PROP_NO      = SH.PROP_NO" ).append("\n"); 
		query.append("        AND     SD.SVC_SCP_CD   = BK.SVC_SCP_CD" ).append("\n"); 
		query.append("        ) SD" ).append("\n"); 
		query.append("WHERE   NOT EXISTS  ( SELECT 'X' FROM SC )" ).append("\n"); 
		query.append("AND     SD.ROW_NUMBER = 1" ).append("\n"); 
		query.append(") ," ).append("\n"); 
		query.append("C2 AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  CASE" ).append("\n"); 
		query.append("        WHEN  BK.REV_APLY_TP_CD = 'C'" ).append("\n"); 
		query.append("          THEN  '[CRD][' || TO_CHAR(BK.CGO_RCV_DT, 'YYYY-MM-DD') || ']' || CHR(10) || '[Application Date][' || TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        ELSE  '[POL ETD][' || TO_CHAR(BK.POL_ETD_DT, 'YYYY-MM-DD') || ']' || CHR(10) || '[Application Date][' || TO_CHAR(BK.RT_APLY_DT, 'YYYY-MM-DD') || ']'" ).append("\n"); 
		query.append("        END   BKG_ITM_LOG   ," ).append("\n"); 
		query.append("        NULL  CTRT_ITM_LOG" ).append("\n"); 
		query.append("FROM    BK" ).append("\n"); 
		query.append("WHERE   CASE" ).append("\n"); 
		query.append("        WHEN      BK.REV_APLY_TP_CD = 'C'" ).append("\n"); 
		query.append("              AND NVL(BK.CGO_RCV_DT, BK.RT_APLY_DT) = BK.RT_APLY_DT" ).append("\n"); 
		query.append("          THEN  'Y'" ).append("\n"); 
		query.append("        WHEN      BK.REV_APLY_TP_CD <> 'C'" ).append("\n"); 
		query.append("              AND BK.RT_APLY_DT BETWEEN NVL(BK.POL_ETB_DT, BK.RT_APLY_DT) AND NVL(BK.POL_ETD_DT, BK.RT_APLY_DT)" ).append("\n"); 
		query.append("          THEN  'Y'" ).append("\n"); 
		query.append("        ELSE  'N'" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  'A1'   UMCH_TP_CD      ," ).append("\n"); 
		query.append("        C1.BKG_ITM_LOG    BKG_ITM_LOG     ," ).append("\n"); 
		query.append("        C1.CTRT_ITM_LOG CTRT_ITM_LOG    ," ).append("\n"); 
		query.append("        'U'   MTCH_UMCH_TP_CD ," ).append("\n"); 
		query.append("        ( SELECT UMCH_TP_DESC FROM BKG_REV_UMCH_TP WHERE UMCH_TP_CD = 'A1' ) UMCH_TP_DESC  ," ).append("\n"); 
		query.append("        ( SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD02456' AND INTG_CD_VAL_CTNT = 'U' ) MTCH_UMCH_TP_DESC" ).append("\n"); 
		query.append("FROM    C1" ).append("\n"); 
		query.append("        LEFT OUTER JOIN C2 ON 1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/*******************************************************************************************" ).append("\n"); 
		query.append("신규 BKG 만 대상으로 한다." ).append("\n"); 
		query.append("*******************************************************************************************/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   LENGTH(@[bkg_no]) = 12" ).append("\n"); 

	}
}