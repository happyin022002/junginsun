/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOsearchBkg0061ListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.25
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2015.06.25 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jinhwan, Son
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOsearchBkg0061ListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_COP_HDR, BKG_BOOKING, _BKG_INFO, _BKG_COST_DTL 테이블의 데이터 조회
	  * 
	  * 
	  * 1. 관련 Table : BKG Info
	  * 2. 조건 :  BKG INFo Table에서 조회 조건으로 where조건 구성
	  * 3. Route 정보만 넘김
	  * 
	  * 2012.03.12 김종준 [CHM-201216637-01] Inquiry by BKG 화면에 Bill Type Indicator 추가
	  * 2015.06.26 손진환 [CHM-201536375] Inquiry by BKG 상 Route 중복 건 수정
	  * </pre>
	  */
	public SalesRPTDBDAOsearchBkg0061ListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOsearchBkg0061ListRSQL").append("\n"); 
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
		query.append("SELECT ' '                                                                                      PCTL_NO" ).append("\n"); 
		query.append("                  , A1.BKG_NO" ).append("\n"); 
		query.append("                  , DECODE(A3.RNUM, 1, 'All', A2.COST_ROUT_NO) COST_ROUT_NO" ).append("\n"); 
		query.append("				  , DECODE(A3.RNUM, 1, 'All', A1.ROUT_NO) COST_ROUT_NO2" ).append("\n"); 
		query.append("                  , COA_LOC_FNC(A1.MTY_PKUP_YD_CD, 'LOC') AS MTY_PKUP_LOC" ).append("\n"); 
		query.append("                  , COA_LOC_FNC(A1.MTY_PKUP_YD_CD, 'ECC') AS MTY_PKUP_ECC" ).append("\n"); 
		query.append("                  , A1.POR_CD" ).append("\n"); 
		query.append("                  , A1.POL_CD" ).append("\n"); 
		query.append("                  , A1.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("                  , A1.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("                  , A1.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("                  , A1.POD_CD" ).append("\n"); 
		query.append("                  , A1.DEL_CD" ).append("\n"); 
		query.append("                  , COA_LOC_FNC(A1.MTY_RTN_YD_CD, 'LOC') AS MTY_RTN_LOC" ).append("\n"); 
		query.append("                  , COA_LOC_FNC(A1.MTY_RTN_YD_CD, 'ECC') AS MTY_RTN_ECC" ).append("\n"); 
		query.append("                  , A1.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("                  , A1.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("                  , A1.SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("                  , A1.SPCL_RC_FLG" ).append("\n"); 
		query.append("                  , A1.SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("                  , A1.SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("                  , A2.SOC_FLG                                                                             SOC_FLG" ).append("\n"); 
		query.append("                  , A2.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                  , A2.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                  , A2.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                  , A2.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                  , A2.N4TH_RLANE_CD" ).append("\n"); 
		query.append("                  , A2.CLT_OFC_CD" ).append("\n"); 
		query.append("                  , A2.SLS_OFC_CD" ).append("\n"); 
		query.append("                  , A2.SHIPPER" ).append("\n"); 
		query.append("                  , A2.IOC_CD" ).append("\n"); 
		query.append("                  , A2.VVD" ).append("\n"); 
		query.append("                  , A2.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                  , A2.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                  , A2.REP_CMDT_CD" ).append("\n"); 
		query.append("                  , A2.SHPR_NM" ).append("\n"); 
		query.append("                  , A2.RLANE_CD" ).append("\n"); 
		query.append("                  , NVL(A1.TTL_TZTM_HRS,0) / 24                                                            HRS" ).append("\n"); 
		query.append("                  , A2.BKG_STS_CD" ).append("\n"); 
		query.append("                  , A2.SLS_YRMON" ).append("\n"); 
		query.append("                  , A2.COST_YRMON" ).append("\n"); 
		query.append("                  , A2.COST_WK" ).append("\n"); 
		query.append("                  , A2.BKG_CGO_WGT" ).append("\n"); 
		query.append("                  , A2.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("				  , COA_GET_CD_NM_FNC('CD01639', NVL(RT_BL_TP_CD, 'X')) RT_BL_TP_NM" ).append("\n"); 
		query.append("FROM     (SELECT DISTINCT A1.BKG_NO" ).append("\n"); 
		query.append("						  ,'ROUTE'||DENSE_RANK() OVER (" ).append("\n"); 
		query.append("		                   ORDER BY A3.MTY_PKUP_YD_CD, A3.POR_CD, A3.POL_CD, A3.POD_CD, A3.DEL_CD, A3.MTY_RTN_YD_CD, A3.TTL_TZTM_HRS ) ROUT_NO" ).append("\n"); 
		query.append("                          , A2.DCGO_FLG    SPCL_DG_CGO_FLG" ).append("\n"); 
		query.append("                          , A2.RC_FLG      SPCL_RC_FLG" ).append("\n"); 
		query.append("                          , A2.AWK_CGO_FLG SPCL_AWK_CGO_FLG" ).append("\n"); 
		query.append("                          , A2.BB_CGO_FLG  SPCL_BB_CGO_FLG" ).append("\n"); 
		query.append("                          , A3.POR_CD" ).append("\n"); 
		query.append("                          , A3.POL_CD" ).append("\n"); 
		query.append("                          , A3.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("                          , A3.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("                          , A3.N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("                          , A3.POD_CD" ).append("\n"); 
		query.append("                          , A3.DEL_NOD_CD" ).append("\n"); 
		query.append("                          , A3.OB_ITCHG_CTNT" ).append("\n"); 
		query.append("                          , A3.IB_ITCHG_CTNT" ).append("\n"); 
		query.append("                          , A3.DEL_CD" ).append("\n"); 
		query.append("                          -- ,a3.dg_spcl_flg" ).append("\n"); 
		query.append("                          -- ,a3.rf_spcl_flg" ).append("\n"); 
		query.append("                          -- ,a3.spcl_awk_cgo_flg" ).append("\n"); 
		query.append("                          -- ,a3.bb_spcl_flg" ).append("\n"); 
		query.append("                          , A3.TTL_TZTM_HRS" ).append("\n"); 
		query.append("                          , COALESCE(A3.MTY_PKUP_YD_CD, A4.MTY_PKUP_YD_CD, A2.MTY_PKUP_YD_CD) MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("                          , COALESCE(A3.MTY_RTN_YD_CD, A4.MTY_PKUP_YD_CD, A2.MTY_RTN_YD_CD) MTY_RTN_YD_CD" ).append("\n"); 
		query.append("          FROM   SCE_COP_HDR A1" ).append("\n"); 
		query.append("                 , BKG_BOOKING A2" ).append("\n"); 
		query.append("                 , PRD_PROD_CTL_MST A3" ).append("\n"); 
		query.append("                 , COA_RGST_BKG A4" ).append("\n"); 
		query.append("          WHERE  1 = 1" ).append("\n"); 
		query.append("          AND A1.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("          AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("          AND A1.PCTL_NO = A3.PCTL_NO" ).append("\n"); 
		query.append("          AND A1.COP_STS_CD <> DECODE(A2.BKG_STS_CD,'S','Z','X')" ).append("\n"); 
		query.append("          AND A1.BKG_NO = A4.BKG_NO) A1" ).append("\n"); 
		query.append("         , (SELECT DISTINCT A.BKG_NO" ).append("\n"); 
		query.append("				 , A.COST_ROUT_NO" ).append("\n"); 
		query.append("				 , 'ROUTE'||SUBSTR(A.COST_ROUT_NO, -1) ROUT_NO" ).append("\n"); 
		query.append("                 , A.RLANE_CD" ).append("\n"); 
		query.append("                 , A.N1ST_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N2ND_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N3RD_RLANE_CD" ).append("\n"); 
		query.append("                 , A.N4TH_RLANE_CD" ).append("\n"); 
		query.append("                 , NVL(A.AGMT_SGN_OFC_CD,A.SLS_OFC_CD) CLT_OFC_CD" ).append("\n"); 
		query.append("                 , A.SLS_OFC_CD" ).append("\n"); 
		query.append("                 , A.SHPR_CNT_CD" ).append("\n"); 
		query.append("                   ||A.SHPR_CUST_SEQ    SHIPPER" ).append("\n"); 
		query.append("                 , A.IOC_CD" ).append("\n"); 
		query.append("                 , A.VSL_CD" ).append("\n"); 
		query.append("                   ||A.SKD_VOY_NO" ).append("\n"); 
		query.append("                   ||A.DIR_CD VVD" ).append("\n"); 
		query.append("                 , A.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("                 , A.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("                 , A.REP_CMDT_CD" ).append("\n"); 
		query.append("                 , A.SHPR_NM" ).append("\n"); 
		query.append("                 , A.BKG_STS_CD" ).append("\n"); 
		query.append("                 , A.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("                 , A.SOC_FLG" ).append("\n"); 
		query.append("                 , A.SLS_YRMON" ).append("\n"); 
		query.append("                 , A.COST_YRMON" ).append("\n"); 
		query.append("                 , A.COST_WK" ).append("\n"); 
		query.append("                 -- ,a.spcl_dg_cgo_flg" ).append("\n"); 
		query.append("                 -- ,a.spcl_rc_flg" ).append("\n"); 
		query.append("                 -- ,a.spcl_awk_cgo_flg" ).append("\n"); 
		query.append("                 -- ,a.spcl_bb_cgo_flg" ).append("\n"); 
		query.append("                 , A.BKG_CGO_WGT" ).append("\n"); 
		query.append("                 , A.BKG_WGT_TP_CD" ).append("\n"); 
		query.append("				 , A.RT_BL_TP_CD" ).append("\n"); 
		query.append("          FROM   COA_BKG_EXPN_DTL A" ).append("\n"); 
		query.append("          WHERE  A.BKG_NO = @[f_bkg_no]" ).append("\n"); 
		query.append("          AND a.bl_no_tp      IN ('M','0')" ).append("\n"); 
		query.append("          AND A.BKG_STS_CD IN ('F','S','W')" ).append("\n"); 
		query.append("          AND A.BKG_CGO_TP_CD <> 'P') A2" ).append("\n"); 
		query.append("         , (SELECT LEVEL AS RNUM" ).append("\n"); 
		query.append("          FROM dual CONNECT BY LEVEL < 3 ) A3" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND A1.ROUT_NO = A2.ROUT_NO" ).append("\n"); 
		query.append("ORDER BY A3.RNUM, A2.COST_ROUT_NO" ).append("\n"); 

	}
}