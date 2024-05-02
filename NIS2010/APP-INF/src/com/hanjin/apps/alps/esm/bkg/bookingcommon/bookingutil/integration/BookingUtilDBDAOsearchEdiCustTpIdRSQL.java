/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : BookingUtilDBDAOsearchEdiCustTpIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.31
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  *  * 2011.02.14 이일민 [SRM-201113442] Lowe"s 301 전송로직 변경요청
	  * * 2011.07.28 정선용 [SRM-201118551] IFTMBC 수정 요청 (TP ID: NIPPON-EXPRESS )
	  * 
	  * *2016.05.18
	  * [CHM-201641139] GTN 중복 transaction block 처리 (CHM-201006030 처리로직 원복)
	  * 
	  * *2016.06.21
	  * [CHM-201642250] GTN 중복 transaction block 로직 보완
	  * 현재의 “304(SI) 가 GTN으로부터 왔을 때만 TRADIANT 로 전송”을
	  *  “304(SI)가 Offline, E-mail (Simple SI), EDI로 전송되었을 경우 TRADIANT로 전송”으로 변경. 
	  * 즉, “304(SI) 가 Inttra, Cargosmart 등 타 Portal로 접수되었을 경우에만 
	  * TRADIANT 전송을 제한”하는 것으로 변경
	  * 
	  * *2017.11.17
	  * [CSR #2468] GST 관련 eSVC / ALPS 수정 요청
	  * EDI 수신된 Booking 일 경우만 301 전송
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
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
		query.append("SELECT DISTINCT GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("	, EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("	, REF_CODE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  FROM    " ).append("\n"); 
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
		query.append("                         , grp_cUST.CUST_SEQ" ).append("\n"); 
		query.append("                         , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP_CUST grp_cUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = grp_cUST.CO_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
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
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("                    -- tpCd = 'D'" ).append("\n"); 
		query.append("                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'" ).append("\n"); 
		query.append("				    AND grp_cust.BL_DRFT_AUTO_DYS < 1                           " ).append("\n"); 
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
		query.append("           AND DECODE(BKG_CUST_TP_DESC,'ALL','ALL',CUST.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("                               IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 
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
		query.append("                         , GRP_CUST.BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST grp_cUST" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = grp_cUST.CO_CD      " ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    and grp_cUST.sc_no          > ' '              " ).append("\n"); 
		query.append("                    AND grp_cUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("                    -- tpCd = 'B'" ).append("\n"); 
		query.append("                    AND grp_cUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BKG_CFM_AUTO_FLG = 'Y' " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("                    -- tpCd = 'D'" ).append("\n"); 
		query.append("                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'     " ).append("\n"); 
		query.append("				    AND grp_cust.BL_DRFT_AUTO_DYS < 1                            " ).append("\n"); 
		query.append("	#end                        " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) EDI_BY_SC" ).append("\n"); 
		query.append("         WHERE EDI_BY_SC.SC_NO  = DECODE(EDI_BY_SC.BKG_CTRT_TP_CD, '1', BK.SC_NO, '2', BK.RFA_NO)" ).append("\n"); 
		query.append("           and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("     GROUP BY BKG_NO" ).append("\n"); 
		query.append("        , GROUP_EDI_ID" ).append("\n"); 
		query.append("        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("        , ref_code) mst, bkg_booking bk" ).append("\n"); 
		query.append("  where bk.bkg_no = mst.bkg_no " ).append("\n"); 
		query.append("	#if (${tp_cd} == 'B')" ).append("\n"); 
		query.append("    AND (EDI_RECEIVE_ID NOT IN ('INTTRA', 'INTTRANG2')" ).append("\n"); 
		query.append("         OR EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("               FROM BKG_XTER_RQST_MST BXRM " ).append("\n"); 
		query.append("               WHERE BXRM.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("               AND BXRM.DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("               AND BXRM.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("               AND BXRM.XTER_RQST_VIA_CD = 'INT')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("    --and 'YES' = case when bk.xter_bkg_rqst_Cd <> 'GTN' and edi_receive_id = 'TRADIANT' then 'NO' /* 이병동씨 요청 */" ).append("\n"); 
		query.append("    --                 when bk.xter_bkg_rqst_Cd <> 'CSM' and edi_receive_id = 'CARGOSMART' then 'NO'     " ).append("\n"); 
		query.append("    --                 when 1 > (select count(1) " ).append("\n"); 
		query.append(" 	--							 from bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("	--							where mst.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("	--							  and mst.doc_tp_cd = 'B'" ).append("\n"); 
		query.append("	--							  and mst.BKG_UPLD_STS_CD = 'F'" ).append("\n"); 
		query.append("	--							  and mst.xter_sndr_id in ('INTTRA','INTTRANG2'))" ).append("\n"); 
		query.append("	--						 and (edi_receive_id = 'INTTRA' or edi_receive_id = 'INTTRANG2') then 'NO'" ).append("\n"); 
		query.append("    --                 when bk.xter_bkg_rqst_cd <> 'EDI' and edi_receive_id = 'SEAEXPD' then 'NO'" ).append("\n"); 
		query.append("    --                 when bk.xter_bkg_rqst_cd <> 'EDI' and edi_receive_id = 'NIPPON-EXPRESS' then 'NO' -- 2011.7.28 추가" ).append("\n"); 
		query.append("    --                 when (bk.xter_bkg_rqst_cd <> 'EDI' " ).append("\n"); 
		query.append("    --                      or (SELECT /*+ INDEX(MST XPKBKG_XTER_RQST_MST)*/" ).append("\n"); 
		query.append("    --                                  DECODE(COUNT(1), 1, 'Y', 'N') AS TP_ID" ).append("\n"); 
		query.append("    --                             FROM BKG_XTER_RQST_MST MST" ).append("\n"); 
		query.append("    --                            WHERE XTER_SNDR_ID = '6135830007'" ).append("\n"); 
		query.append("    --                              AND DOC_TP_CD = 'B'" ).append("\n"); 
		query.append("    --                              AND BKG_NO = bkg_no -- prameter" ).append("\n"); 
		query.append("    --                              AND BKG_UPLD_STS_CD NOT IN ('D','R')" ).append("\n"); 
		query.append("    --                              AND ROWNUM = 1) <> 'Y')" ).append("\n"); 
		query.append("    --                      and edi_receive_id = '6135830007' then 'NO'" ).append("\n"); 
		query.append("    --                 else 'YES' end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D')" ).append("\n"); 
		query.append("    AND 'YES' = CASE WHEN BK.XTER_SI_CD IN ('INT','CSM') AND EDI_RECEIVE_ID = 'TRADIANT' THEN 'NO'" ).append("\n"); 
		query.append("                     WHEN BK.XTER_SI_CD <> 'CSM' AND EDI_RECEIVE_ID = 'CARGOSMART' THEN 'NO' /* 이병동씨 요청 */" ).append("\n"); 
		query.append("                     WHEN BK.XTER_SI_CD <> 'INT' AND (EDI_RECEIVE_ID = 'INTTRA' OR EDI_RECEIVE_ID = 'INTTRANG2') THEN 'NO'" ).append("\n"); 
		query.append("					  /* CARGOSMART 는 DPCS 대상인건의 경우 'QA' 완료일때 전송 이지영과장님 요청 */" ).append("\n"); 
		query.append("					 WHEN BK.BKG_OFC_CD NOT IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                          AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND BL_AUD_FLG = 'Y' AND ROWNUM = 1 ),'N') <> 'Y'" ).append("\n"); 
		query.append("						  AND (EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("						  AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND SR_AMD_TP_CD = 'O' AND ROWNUM = 1),'N') = 'Y') THEN 'NO' " ).append("\n"); 
		query.append("                     /* CARGOSMART 인 경우라도 'HKGSC', 'SZPSC', 'XMNSC' 경우에는 BKG AUDIT완료되어있으면 전송 황일균부장님 요청 */" ).append("\n"); 
		query.append("                     WHEN EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("                          AND BK.BKG_OFC_CD IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                          AND NVL((SELECT AUD_STS_CD FROM BKG_RATE WHERE BKG_NO = BK.BKG_NO),'N') != 'Y' THEN 'NO'" ).append("\n"); 
		query.append("                     ELSE 'YES' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("--autoManualCd = 'Y'" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'B') " ).append("\n"); 
		query.append("    and ((not exists (select 'X'" ).append("\n"); 
		query.append("                        from bkg_ntc_his ntc" ).append("\n"); 
		query.append("                       where ntc.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                         and ntc.ntc_via_cd = 'E'" ).append("\n"); 
		query.append("                         and ntc.edi_id = edi_receive_id" ).append("\n"); 
		query.append("                    " ).append("\n"); 
		query.append("                         -- tpCd = 'B'" ).append("\n"); 
		query.append("                         and ntc.ntc_knd_cd = 'BK'" ).append("\n"); 
		query.append("                         and rownum = 1)" ).append("\n"); 
		query.append("         )OR(" ).append("\n"); 
		query.append("          EXISTS     (SELECT 'X' -- BKG Cancel 땐 다시 전송" ).append("\n"); 
		query.append("                        FROM BKG_HIS_MST HIS, BKG_HIS_DTL DTL" ).append("\n"); 
		query.append("                       WHERE HIS.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                         AND DTL.BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                         AND HIS.HIS_SEQ = DTL.HIS_SEQ" ).append("\n"); 
		query.append("                         AND HIS.HIS_SEQ = (SELECT MAX(A.HIS_SEQ) " ).append("\n"); 
		query.append("                                              FROM BKG_HIS_MST A, BKG_HIS_DTL B " ).append("\n"); 
		query.append("                                             WHERE A.BKG_NO = HIS.BKG_NO " ).append("\n"); 
		query.append("                                               AND A.BKG_NO   = B.BKG_NO " ).append("\n"); 
		query.append("                                               AND A.HIS_SEQ  = B.HIS_SEQ)" ).append("\n"); 
		query.append("                         AND DTL.HIS_CATE_NM = 'Booking Cancel.' " ).append("\n"); 
		query.append("                         AND ROWNUM = 1" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("    and exists (select 'x'" ).append("\n"); 
		query.append("                  from bkg_chg_rt rt" ).append("\n"); 
		query.append("                 where rt.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                   and rt.chg_cd = 'OFT'" ).append("\n"); 
		query.append("				 union	" ).append("\n"); 
		query.append("                 select 'x'" ).append("\n"); 
		query.append("                   from bkg_rate rt" ).append("\n"); 
		query.append("                  where rt.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                    and rt.rt_bl_tp_cd ='C' " ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D')" ).append("\n"); 
		query.append("	and exists (select 'x'" ).append("\n"); 
		query.append("                    from bkg_booking " ).append("\n"); 
		query.append("                    where bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("                      and port_clz_dt <= TRUNC(sysdate))" ).append("\n"); 
		query.append("    and not exists (select 'x' " ).append("\n"); 
		query.append("                      from bkg_booking a, bkg_ntc_his ntc" ).append("\n"); 
		query.append("                     where 1=1" ).append("\n"); 
		query.append("                       and a.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("					   and a.port_clz_dt <= TRUNC(sysdate)" ).append("\n"); 
		query.append("                       and a.bkg_no = ntc.bkg_no" ).append("\n"); 
		query.append("                       and ntc.ntc_via_cd ='E'" ).append("\n"); 
		query.append("                       and ntc.ntc_knd_cd ='BL'" ).append("\n"); 
		query.append("                       and ntc.snd_usr_id = 'SYSTEM'" ).append("\n"); 
		query.append("					   and ntc.edi_id = edi_receive_id                 " ).append("\n"); 
		query.append("                     ) " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("	#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("	UNION" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	SELECT DISTINCT GROUP_EDI_ID GROUP_ID" ).append("\n"); 
		query.append("		, EDI_RECEIVE_ID RCV_ID" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("		, REF_CODE" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	 FROM " ).append("\n"); 
		query.append("    	(SELECT BKG_NO" ).append("\n"); 
		query.append("        	, MIN(RANK) RANK" ).append("\n"); 
		query.append("	        , GROUP_EDI_ID" ).append("\n"); 
		query.append("	        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	        , REF_CODE" ).append("\n"); 
		query.append("	      FROM " ).append("\n"); 
		query.append("	        (SELECT  BK.BKG_NO" ).append("\n"); 
		query.append("	                , MIN(TP_RANK.RANK) RANK" ).append("\n"); 
		query.append("	                , edi_BY_CUST.group_edi_id" ).append("\n"); 
		query.append("	                , edi_BY_CUST.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	                , DECODE(@[tp_cd], 'D', 'D', edi_BY_CUST.cnt_cd||edi_BY_CUST.cust_seq) AS ref_code" ).append("\n"); 
		query.append("	          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("	                , BKG_BOOKING BK" ).append("\n"); 
		query.append("	                , (SELECT GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("	                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	                         , grp_cUST.CNT_CD   " ).append("\n"); 
		query.append("	                         , grp_cUST.CUST_SEQ" ).append("\n"); 
		query.append("	                         , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("							 , GRP_CUST.BL_DRFT_AUTO_DYS" ).append("\n"); 
		query.append("	                   FROM BKG_EDI_GRP_CUST grp_cUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("	                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("	                    AND GRP.CO_CD               = grp_cUST.CO_CD" ).append("\n"); 
		query.append("	                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("	                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("	                    AND grp_cUST.cnt_Cd         > ' '" ).append("\n"); 
		query.append("	                    AND grp_cUST.cust_seq       > 0" ).append("\n"); 
		query.append("	                    AND grp_cUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("	                    -- tpCd = 'D'" ).append("\n"); 
		query.append("	                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("		#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("	                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("	                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'" ).append("\n"); 
		query.append("					    AND grp_cust.BL_DRFT_AUTO_DYS > 0	                           " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	                    ) EDI_BY_CUST               " ).append("\n"); 
		query.append("	                , (SELECT 'S' RCV_TP, '1SH' RANK FROM DUAL " ).append("\n"); 
		query.append("	                   UNION SELECT 'C' RCV_TP, '2CN' RANK FROM DUAL " ).append("\n"); 
		query.append("	                   UNION SELECT 'N' RCV_TP, '3NF' RANK FROM DUAL " ).append("\n"); 
		query.append("	                   UNION SELECT 'F' RCV_TP, '4FF' RANK FROM DUAL " ).append("\n"); 
		query.append("	                   UNION SELECT 'A' RCV_TP, '5AN' RANK FROM DUAL " ).append("\n"); 
		query.append("	                   UNION SELECT 'E' RCV_TP, '6EX' RANK FROM DUAL) TP_RANK," ).append("\n"); 
		query.append("					   VSK_VSL_PORT_SKD VSK," ).append("\n"); 
		query.append("					   BKG_VVD VVD" ).append("\n"); 
		query.append("		         WHERE EDI_BY_CUST.CNT_CD   = CUST.CUST_CNT_CD " ).append("\n"); 
		query.append("		           AND EDI_BY_CUST.CUST_SEQ = CUST.CUST_SEQ" ).append("\n"); 
		query.append("		           AND BK.BKG_NO            = CUST.BKG_NO" ).append("\n"); 
		query.append("		           AND CUST.BKG_CUST_TP_CD = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("		           and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("		           AND DECODE(BKG_CUST_TP_DESC,'ALL','ALL',CUST.BKG_CUST_TP_CD) IN (SELECT COLUMN_VALUE FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 
		query.append("		           AND VSK.VPS_ETD_DT    >= TRUNC(SYSDATE) - 11" ).append("\n"); 
		query.append("	           	   AND VSK.VPS_ETD_DT    <= TRUNC(SYSDATE)" ).append("\n"); 
		query.append("              	   AND VSK.VPS_ETD_DT    <= TRUNC(SYSDATE) - EDI_BY_CUST.BL_DRFT_AUTO_DYS + 1" ).append("\n"); 
		query.append("                   AND SYSDATE  >= TRUNC(SYSDATE)+ 23/24" ).append("\n"); 
		query.append("                   AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("                   AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                   AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                   AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("                   AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("           		   AND BK.BKG_STS_CD <> 'X' 		" ).append("\n"); 
		query.append("	               /* Consignee의 Name 누락여부 */										" ).append("\n"); 
		query.append("           		   AND EXISTS (SELECT CUST_NM 										" ).append("\n"); 
		query.append("	                 	         FROM BKG_CUSTOMER 										" ).append("\n"); 
		query.append("	                     		 WHERE BKG_NO = BK.BKG_NO 										" ).append("\n"); 
		query.append("	                          	   AND BKG_CUST_TP_CD ='C' 	" ).append("\n"); 
		query.append("	                          	   AND CUST_NM > ' '									" ).append("\n"); 
		query.append("	                          	   AND ROWNUM = 1 )										" ).append("\n"); 
		query.append("	           		 /* TTL Package and Description 누락여부 */										" ).append("\n"); 
		query.append("	           		 AND EXISTS (SELECT 'Y' 										" ).append("\n"); 
		query.append("	                 	         FROM BKG_BL_DOC A, 										" ).append("\n"); 
		query.append("								  BKG_BL_MK_DESC B 										" ).append("\n"); 
		query.append("	                        	 WHERE BK.BKG_NO = A.BKG_NO										" ).append("\n"); 
		query.append("	                          	   AND A.BKG_NO = B.BKG_NO (+)										" ).append("\n"); 
		query.append("	                          	   AND B.MK_SEQ (+) = 1										" ).append("\n"); 
		query.append("	                               AND (A.PCK_CMDT_DESC IS NOT NULL OR A.CNTR_CMDT_DESC IS NOT NULL OR B.CMDT_DESC IS NOT NULL)										" ).append("\n"); 
		query.append("	                          	   AND ROWNUM = 1 )										" ).append("\n"); 
		query.append("	           		 /* CNTR No 존재 여부 */ 										" ).append("\n"); 
		query.append("	           		 AND EXISTS (SELECT 'Y' 										" ).append("\n"); 
		query.append("	                 	         FROM BKG_CONTAINER 										" ).append("\n"); 
		query.append("	                        	 WHERE BKG_NO = BK.BKG_NO 										" ).append("\n"); 
		query.append("	                          	   AND ROWNUM = 1 )                                          										" ).append("\n"); 
		query.append("	         	  GROUP BY BK.BKG_NO										" ).append("\n"); 
		query.append("						 , EDI_BY_CUST.GROUP_EDI_ID										" ).append("\n"); 
		query.append("	                	 , EDI_BY_CUST.EDI_RECEIVE_ID										" ).append("\n"); 
		query.append("	                     , EDI_BY_CUST.CNT_CD||EDI_BY_CUST.CUST_SEQ		" ).append("\n"); 
		query.append("	         UNION" ).append("\n"); 
		query.append("	          SELECT bk.bkg_no" ).append("\n"); 
		query.append("	                , '7SC' RANK" ).append("\n"); 
		query.append("	                , edi_BY_SC.group_edi_iD" ).append("\n"); 
		query.append("	                , edi_BY_SC.EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	                , DECODE(@[tp_cd], 'D', 'D', edi_BY_SC.sc_no) AS ref_code" ).append("\n"); 
		query.append("	          FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("	                , (SELECT  GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("	                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	                         , grp_cUST.SC_NO" ).append("\n"); 
		query.append("	                         , GRP_CUST.BKG_CTRT_TP_CD" ).append("\n"); 
		query.append("						    , GRP_CUST.BL_DRFT_AUTO_DYS	" ).append("\n"); 
		query.append("	                   FROM BKG_EDI_GRP GRP, BKG_EDI_GRP_CUST grp_cUST" ).append("\n"); 
		query.append("	                  WHERE GRP.ESVC_GRP_CD         = grp_cUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("	                    AND GRP.CO_CD               = grp_cUST.CO_CD      " ).append("\n"); 
		query.append("	                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("	                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("	                    and grp_cUST.sc_no          > ' '              " ).append("\n"); 
		query.append("	                    AND grp_cUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("	#if (${tp_cd} == 'D') " ).append("\n"); 
		query.append("	                    -- tpCd = 'D'" ).append("\n"); 
		query.append("	                    AND grp_cust.bl_drft_flg    = 'Y'       " ).append("\n"); 
		query.append("		#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("                    --autoManualCd = 'Y'" ).append("\n"); 
		query.append("	                    AND grp_cust.BL_DRFT_AUTO_FLG = 'Y'     " ).append("\n"); 
		query.append("					    AND grp_cust.BL_DRFT_AUTO_DYS > 0                            " ).append("\n"); 
		query.append("		#end                        " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	                    ) EDI_BY_SC," ).append("\n"); 
		query.append("					    VSK_VSL_PORT_SKD VSK," ).append("\n"); 
		query.append("	                    BKG_VVD VVD" ).append("\n"); 
		query.append("	         WHERE EDI_BY_SC.SC_NO  = DECODE(EDI_BY_SC.BKG_CTRT_TP_CD, '1', BK.SC_NO, '2', BK.RFA_NO)" ).append("\n"); 
		query.append("	           and bk.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("			   AND VSK.VPS_ETD_DT    >= TRUNC(SYSDATE) - 11" ).append("\n"); 
		query.append("               AND VSK.VPS_ETD_DT    <= TRUNC(SYSDATE)" ).append("\n"); 
		query.append("               AND VSK.VPS_ETD_DT    <= TRUNC(SYSDATE) - EDI_BY_SC.BL_DRFT_AUTO_DYS + 1" ).append("\n"); 
		query.append("               AND SYSDATE  >= TRUNC(SYSDATE)+ 23/24" ).append("\n"); 
		query.append("               AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("               AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("               AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("               AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("               AND VVD.POL_CD = BK.POL_CD" ).append("\n"); 
		query.append("               AND VVD.BKG_NO = BK.BKG_NO								" ).append("\n"); 
		query.append("               AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("               /* Consignee의 Name 누락여부 */										" ).append("\n"); 
		query.append("           	   AND EXISTS (SELECT CUST_NM 										" ).append("\n"); 
		query.append("	                          FROM BKG_CUSTOMER 										" ).append("\n"); 
		query.append("	                          WHERE BKG_NO = BK.BKG_NO 										" ).append("\n"); 
		query.append("	                            AND BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("	                            AND CUST_NM > ' ' 										" ).append("\n"); 
		query.append("	                            AND ROWNUM = 1 )										" ).append("\n"); 
		query.append("           	  /* TTL Package and Description 누락여부 */										" ).append("\n"); 
		query.append("           	  AND EXISTS (SELECT 'Y' 										" ).append("\n"); 
		query.append("                          FROM BKG_BL_DOC A, 										" ).append("\n"); 
		query.append("                               BKG_BL_MK_DESC B 										" ).append("\n"); 
		query.append("                          WHERE BK.BKG_NO = A.BKG_NO										" ).append("\n"); 
		query.append("                            AND A.BKG_NO = B.BKG_NO (+)										" ).append("\n"); 
		query.append("                            AND B.MK_SEQ (+) = 1										" ).append("\n"); 
		query.append("                            AND (A.PCK_CMDT_DESC IS NOT NULL OR A.CNTR_CMDT_DESC IS NOT NULL OR B.CMDT_DESC IS NOT NULL)										" ).append("\n"); 
		query.append("                            AND ROWNUM = 1 )										" ).append("\n"); 
		query.append("           	   /* CNTR No 존재 여부 */ 										" ).append("\n"); 
		query.append("           	   AND EXISTS (SELECT 'Y' 										" ).append("\n"); 
		query.append("                           FROM BKG_CONTAINER 										" ).append("\n"); 
		query.append("                           WHERE BKG_NO = BK.BKG_NO 										" ).append("\n"); 
		query.append("                             AND ROWNUM = 1 ) " ).append("\n"); 
		query.append("	           )" ).append("\n"); 
		query.append("	     GROUP BY BKG_NO" ).append("\n"); 
		query.append("	        , GROUP_EDI_ID" ).append("\n"); 
		query.append("	        , EDI_RECEIVE_ID" ).append("\n"); 
		query.append("	        , ref_code) mst, bkg_booking bk" ).append("\n"); 
		query.append("	  where bk.bkg_no = mst.bkg_no " ).append("\n"); 
		query.append("		#if (${tp_cd} == 'D')" ).append("\n"); 
		query.append("	    AND 'YES' = CASE WHEN BK.XTER_SI_CD IN ('INT','CSM') AND EDI_RECEIVE_ID = 'TRADIANT' THEN 'NO'" ).append("\n"); 
		query.append("	                     WHEN BK.XTER_SI_CD <> 'CSM' AND EDI_RECEIVE_ID = 'CARGOSMART' THEN 'NO' /* 이병동씨 요청 */" ).append("\n"); 
		query.append("	                     WHEN BK.XTER_SI_CD <> 'INT' AND (EDI_RECEIVE_ID = 'INTTRA' OR EDI_RECEIVE_ID = 'INTTRANG2') THEN 'NO'" ).append("\n"); 
		query.append("						  /* CARGOSMART 는 DPCS 대상인건의 경우 'QA' 완료일때 전송 이지영과장님 요청 */" ).append("\n"); 
		query.append("						 WHEN BK.BKG_OFC_CD NOT IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                              AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND BL_AUD_FLG = 'Y' AND ROWNUM = 1 ),'N') <> 'Y'" ).append("\n"); 
		query.append("							  AND (EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("							  AND NVL((SELECT 'Y' FROM BKG_SR_CRNT_RQST WHERE BKG_NO = BK.BKG_NO AND SR_AMD_TP_CD = 'O' AND ROWNUM = 1),'N') = 'Y') THEN 'NO' " ).append("\n"); 
		query.append("                         /* CARGOSMART 인 경우라도 'HKGSC', 'SZPSC', 'XMNSC' 경우에는 BKG AUDIT완료되어있으면 전송 황일균부장님 요청 */" ).append("\n"); 
		query.append("                         WHEN EDI_RECEIVE_ID = 'CARGOSMART' " ).append("\n"); 
		query.append("                              AND BK.BKG_OFC_CD IN ('HKGSC', 'SZPSC', 'XMNSC')" ).append("\n"); 
		query.append("                              AND NVL((SELECT AUD_STS_CD FROM BKG_RATE WHERE BKG_NO = BK.BKG_NO),'N') != 'Y' THEN 'NO'" ).append("\n"); 
		query.append("                         ELSE 'YES' END" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${auto_manual_flg} == 'Y') " ).append("\n"); 
		query.append("		--autoManualCd = 'Y'" ).append("\n"); 
		query.append("			#if (${tp_cd} == 'D')    " ).append("\n"); 
		query.append("			 AND EXISTS (SELECT 'X'									" ).append("\n"); 
		query.append("			   	          FROM BKG_CHG_RT CHG										" ).append("\n"); 
		query.append("			           	  WHERE CHG.BKG_NO = BK.BKG_NO										" ).append("\n"); 
		query.append("		               		AND CHG.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("		               		AND ROWNUM = 1 " ).append("\n"); 
		query.append("		               	  UNION	" ).append("\n"); 
		query.append("		               	  SELECT 'X'" ).append("\n"); 
		query.append("		               	  FROM BKG_RATE RT" ).append("\n"); 
		query.append("			           	  WHERE RT.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("		               	    AND RT.RT_BL_TP_CD ='C' " ).append("\n"); 
		query.append("        	       		)										" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${tp_cd} == 'D')" ).append("\n"); 
		query.append("			AND NOT EXISTS (SELECT /*+USE_NL(A,NTC,VVD,VSK)*/ 'X' 										" ).append("\n"); 
		query.append("		                      FROM BKG_BOOKING A, BKG_NTC_HIS NTC, 	BKG_VVD VVD, VSK_VSL_PORT_SKD VSK										" ).append("\n"); 
		query.append("		                      WHERE 1=1										" ).append("\n"); 
		query.append("		                        AND A.BKG_NO = BK.BKG_NO										" ).append("\n"); 
		query.append("		                        AND A.BKG_NO = NTC.BKG_NO	" ).append("\n"); 
		query.append("								AND A.BKG_NO = @[bkg_no]									" ).append("\n"); 
		query.append("		                        AND NTC.NTC_VIA_CD ='E'										" ).append("\n"); 
		query.append("		                        AND NTC.NTC_KND_CD ='BL'										" ).append("\n"); 
		query.append("		                        AND NTC.SND_USR_ID = 'SYSTEM'" ).append("\n"); 
		query.append("		                        AND NTC.EDI_ID = EDI_RECEIVE_ID										" ).append("\n"); 
		query.append("		                        AND VSK.VPS_ETD_DT <= TRUNC(SYSDATE) " ).append("\n"); 
		query.append("	                            AND VSK.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("	                            AND VSK.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("	                            AND VSK.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("	                            AND VSK.VPS_PORT_CD = VVD.POL_CD" ).append("\n"); 
		query.append("	                            AND VSK.CLPT_IND_SEQ = VVD.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	                            AND VVD.POL_CD = A.POL_CD" ).append("\n"); 
		query.append("	                            AND VVD.BKG_NO = A.BKG_NO                    										" ).append("\n"); 
		query.append("	                         )  " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}