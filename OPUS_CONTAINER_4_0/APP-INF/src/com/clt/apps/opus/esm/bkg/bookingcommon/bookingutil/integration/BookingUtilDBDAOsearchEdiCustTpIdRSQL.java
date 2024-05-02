/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOsearchEdiCustTpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchEdiCustTpIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdiCustTpId
	  * </pre>
	  */
	public BookingUtilDBDAOsearchEdiCustTpIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchEdiCustTpIdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("		nvl((select bhcc.attr_ctnt3 " ).append("\n"); 
		query.append("            from bkg_hrd_cdg_ctnt bhcc " ).append("\n"); 
		query.append("            where bhcc.hrd_cdg_id = 'CUSTOMER_301U' " ).append("\n"); 
		query.append("            and bhcc.attr_ctnt1 = EDI_RECEIVE_ID " ).append("\n"); 
		query.append("            and bhcc.attr_ctnt2 = REF_CODE" ).append("\n"); 
		query.append("            and rownum = 1), GROUP_EDI_ID) GROUP_ID" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	, EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("	, REF_CODE" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (SELECT BKG_NO" ).append("\n"); 
		query.append("        , MIN(RANK) RANK" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("        , REF_CODE" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("        (SELECT  BK.BKG_NO" ).append("\n"); 
		query.append("                , MIN(TP_RANK.RANK) RANK" ).append("\n"); 
		query.append("                , edi_BY_CUST.group_edi_id" ).append("\n"); 
		query.append("                , edi_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , DECODE(@[tp_cd], 'D', 'D', edi_BY_CUST.cnt_cd||edi_BY_CUST.cust_seq) AS ref_code" ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("                , BKG_BOOKING BK" ).append("\n"); 
		query.append("                , (SELECT GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , grp_cUST.CNT_CD   " ).append("\n"); 
		query.append("                         , grp_cUST.CUST_SEQ " ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP_CUST grp_cUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = grp_cUST.CO_CD" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    AND grp_cUST.cnt_Cd         > ' '" ).append("\n"); 
		query.append("                    AND grp_cUST.cust_seq       > 0" ).append("\n"); 
		query.append("                    AND grp_cUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("                    -- tpCd = 'B'" ).append("\n"); 
		query.append("                    AND grp_cUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BKG_CFM_AUTO_FLG = 'Y' " ).append("\n"); 
		query.append("                    AND 1 = 2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("                    -- tpCd = 'D'" ).append("\n"); 
		query.append("                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'                             " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    ) EDI_BY_CUST               " ).append("\n"); 
		query.append("                , (SELECT 'S' RCV_TP, '1SH' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'C' RCV_TP, '2CN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'N' RCV_TP, '3NF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'F' RCV_TP, '4FF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'A' RCV_TP, '5AN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'E' RCV_TP, '6EX' RANK FROM DUAL) TP_RANK" ).append("\n"); 
		query.append("         WHERE EDI_BY_CUST.CNT_CD   = CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("           AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("           AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("           AND CUST.BKG_CUST_TP_CD = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("           and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("         GROUP BY bk.bkg_no" ).append("\n"); 
		query.append("                , edi_BY_CUST.group_edi_id" ).append("\n"); 
		query.append("                , edi_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , edi_BY_CUST.cnt_cd||edi_BY_CUST.cust_seq" ).append("\n"); 
		query.append("         UNION" ).append("\n"); 
		query.append("          SELECT bk.bkg_no" ).append("\n"); 
		query.append("                , '7SC' RANK" ).append("\n"); 
		query.append("                , edi_BY_SC.group_edi_iD" ).append("\n"); 
		query.append("                , edi_BY_SC.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                , DECODE(@[tp_cd], 'D', 'D', edi_BY_SC.sc_no) AS ref_code" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("                , (SELECT  GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , grp_cUST.SC_NO" ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST grp_cUST" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = grp_cUST.CO_CD      " ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    and grp_cUST.sc_no          > ' '              " ).append("\n"); 
		query.append("                    AND grp_cUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("                    -- tpCd = 'B'" ).append("\n"); 
		query.append("                    AND grp_cUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BKG_CFM_AUTO_FLG = 'Y' " ).append("\n"); 
		query.append("                    AND 1 = 2" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("                    -- tpCd = 'D'" ).append("\n"); 
		query.append("                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'     " ).append("\n"); 
		query.append("	#end                        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) EDI_BY_SC" ).append("\n"); 
		query.append("         WHERE EDI_BY_SC.SC_NO  = BK.SC_NO" ).append("\n"); 
		query.append("           and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("#if (${tp_cd} == 'B')" ).append("\n"); 
		query.append("          UNION " ).append("\n"); 
		query.append("           SELECT MST.BKG_NO" ).append("\n"); 
		query.append("                  ,'8EB' RANK" ).append("\n"); 
		query.append("                  ,'' group_edi_iD" ).append("\n"); 
		query.append("                  ,(SELECT BHCC.ATTR_CTNT3" ).append("\n"); 
		query.append("                    FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                    WHERE BHCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                    AND   BHCC.ATTR_CTNT2 = CASE WHEN MST.XTER_SNDR_ID <> 'PEGASUS' THEN MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                            ELSE (SELECT BHCC1.ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                                                          WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                                                          AND BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID) END" ).append("\n"); 
		query.append("                    AND ROWNUM = 1) AS EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                  ,'' AS ref_code" ).append("\n"); 
		query.append("           FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("           WHERE MST.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("           AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_VIA_CD <> 'WEB'" ).append("\n"); 
		query.append("           AND MST.XTER_RQST_SEQ = (SELECT MAX(MST1.XTER_RQST_SEQ) FROM BKG_XTER_RQST_MST MST1 WHERE MST.XTER_SNDR_ID = MST1.XTER_SNDR_ID " ).append("\n"); 
		query.append("                                                                   AND MST.BKG_NO = MST1.BKG_NO" ).append("\n"); 
		query.append("                                                                   AND MST1.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                                   AND MST1.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                                   AND MST1.XTER_RQST_VIA_CD <> 'WEB')" ).append("\n"); 
		query.append("           and not exists (SELECT 'X'" ).append("\n"); 
		query.append("                            from bkg_ntc_his ntc" ).append("\n"); 
		query.append("                           where ntc.bkg_no = MST.bkg_no" ).append("\n"); 
		query.append("                             and ntc.ntc_via_cd = 'E'" ).append("\n"); 
		query.append("                             and ntc.edi_id = (SELECT BHCC.ATTR_CTNT3" ).append("\n"); 
		query.append("                                               FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("                                               WHERE BHCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                               AND   BHCC.ATTR_CTNT2 = CASE WHEN MST.XTER_SNDR_ID <> 'PEGASUS' THEN MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                                       ELSE (SELECT BHCC1.ATTR_CTNT2 FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                                                             WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                                                             AND BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID) END" ).append("\n"); 
		query.append("                                               AND ROWNUM = 1)" ).append("\n"); 
		query.append("                             and ntc.ntc_knd_cd = 'BK'" ).append("\n"); 
		query.append("							 and (select bb.bkg_sts_cd from bkg_booking bb where bb.bkg_no = @[bkg_no]) <> 'X'" ).append("\n"); 
		query.append("		                   )" ).append("\n"); 
		query.append("          UNION" ).append("\n"); 
		query.append("          SELECT BB.BKG_NO" ).append("\n"); 
		query.append("                 ,'9UB' RANK" ).append("\n"); 
		query.append("                 ,BHCC.ATTR_CTNT3 group_edi_iD" ).append("\n"); 
		query.append("                 ,BHCC.ATTR_CTNT1 AS EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                 ,BHCC.ATTR_CTNT2 AS ref_code" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("               ,BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("          WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND BHCC.HRD_CDG_ID = 'CUSTOMER_301U'" ).append("\n"); 
		query.append("          AND EXISTS (SELECT 'X' FROM BKG_CUSTOMER BC WHERE BC.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                                      AND BC.CUST_CNT_CD||BC.CUST_SEQ = BHCC.ATTR_CTNT2)" ).append("\n"); 
		query.append("          AND NOT EXISTS (SELECT 'X' FROM BKG_XTER_RQST_MST MST WHERE MST.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                                                AND MST.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("                                                                AND MST.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("                                                                AND BHCC.ATTR_CTNT1 = CASE WHEN MST.XTER_SNDR_ID <> 'PEGASUS' THEN MST.XTER_SNDR_ID" ).append("\n"); 
		query.append("                                                                                      ELSE (SELECT BHCC1.ATTR_CTNT2 " ).append("\n"); 
		query.append("                                                                                              FROM BKG_HRD_CDG_CTNT BHCC1" ).append("\n"); 
		query.append("                                                                                             WHERE BHCC1.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("                                                                                               AND BHCC1.ATTR_CTNT1 = MST.PGSS_EDI_ID" ).append("\n"); 
		query.append("                                                                                               AND ROWNUM = 1) END" ).append("\n"); 
		query.append("                                                                AND MST.XTER_RQST_VIA_CD <> 'WEB')" ).append("\n"); 
		query.append("          AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                          from bkg_ntc_his ntc" ).append("\n"); 
		query.append("                          where ntc.bkg_no = BB.bkg_no" ).append("\n"); 
		query.append("                          and ntc.ntc_via_cd = 'E'" ).append("\n"); 
		query.append("                          and ntc.edi_id = BHCC.ATTR_CTNT1" ).append("\n"); 
		query.append("                          and ntc.ntc_knd_cd = 'BK'" ).append("\n"); 
		query.append("						  and bb.bkg_sts_cd <> 'X')                                                        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     GROUP BY BKG_NO" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("        , ref_code) mst, bkg_booking bk" ).append("\n"); 
		query.append("  where bk.bkg_no = mst.bkg_no " ).append("\n"); 
		query.append("#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("--autoManualCd = 'Y'" ).append("\n"); 
		query.append("    and not exists (select 'X'" ).append("\n"); 
		query.append("                      from bkg_ntc_his ntc" ).append("\n"); 
		query.append("                     where ntc.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                       and ntc.ntc_via_cd = 'E'" ).append("\n"); 
		query.append("                       and ntc.edi_id = edi_receive_id" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("                       -- tpCd = 'B'" ).append("\n"); 
		query.append("                       and ntc.ntc_knd_cd = 'BK'" ).append("\n"); 
		query.append("					   and bk.bkg_sts_cd <> 'X'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D')" ).append("\n"); 
		query.append("                       -- tpCd = 'D'" ).append("\n"); 
		query.append("                       and ntc.ntc_knd_cd = 'BL'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                       and rownum = 1)" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("    and exists (select 'x'" ).append("\n"); 
		query.append("                  from bkg_chg_rt rt" ).append("\n"); 
		query.append("                 where rt.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                   and rt.chg_cd = 'OFT')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("    and not exists (SELECT 'X' FROM MDM_LOCATION ML " ).append("\n"); 
		query.append("                    WHERE ML.LOC_CD = BK.POL_CD AND ML.CONTI_CD = 'E' " ).append("\n"); 
		query.append("                    AND (BK.DCGO_FLG = 'Y' OR BK.RC_FLG = 'Y' OR BK.AWK_CGO_FLG = 'Y' OR BK.BKG_WT_CHK_FLG = 'Y')" ).append("\n"); 
		query.append("                    AND (BK.BKG_STS_CD <> 'F' OR BK.BKG_WT_CHK_FLG = 'Y')" ).append("\n"); 
		query.append("                   ) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}