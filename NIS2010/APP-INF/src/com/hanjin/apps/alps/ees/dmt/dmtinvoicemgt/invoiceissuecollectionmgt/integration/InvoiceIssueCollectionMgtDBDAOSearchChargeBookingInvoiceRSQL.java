/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_chg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL").append("\n"); 
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
		query.append("select  A.SYS_AREA_GRP_ID 								as SVR_ID" ).append("\n"); 
		query.append("	   ,BB.BL_NO" ).append("\n"); 
		query.append("	   ,BB.BKG_NO" ).append("\n"); 
		query.append("	   ,B.DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,B.OFC_CD" ).append("\n"); 
		query.append("	   ,BB.SC_NO" ).append("\n"); 
		query.append("	   --,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD 			as VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       ,MAX(" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("		NVL(" ).append("\n"); 
		query.append("		DECODE(SUBSTR(B.DMDT_TRF_CD,3,1),'I'," ).append("\n"); 
		query.append("         ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                                INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                                INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                   V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("              FROM BKG_VVD V" ).append("\n"); 
		query.append("                  ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("             WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("               AND V.POD_CD = BB.POD_CD" ).append("\n"); 
		query.append("               AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                      (SELECT /*+ INDEX_DESC( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                              VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                             ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                         FROM BKG_VVD VV" ).append("\n"); 
		query.append("                        WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                          AND VV.POD_CD = V.POD_CD" ).append("\n"); 
		query.append("                          AND ROWNUM = 1)" ).append("\n"); 
		query.append("               AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("               AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("               AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("               AND V.POD_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("               AND V.POD_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("               AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("               AND ROWNUM = 1 )" ).append("\n"); 
		query.append("       , ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                   INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                   INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("               V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("          FROM BKG_VVD V" ).append("\n"); 
		query.append("              ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("         WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("           AND V.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("           AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                  (SELECT /*+ INDEX( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                          VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                         ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                     FROM BKG_VVD VV" ).append("\n"); 
		query.append("                    WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                      AND VV.POL_CD = V.POL_CD" ).append("\n"); 
		query.append("                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("           AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND V.POL_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("           AND V.POL_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("           AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("           AND ROWNUM = 1 ))" ).append("\n"); 
		query.append("		, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)" ).append("\n"); 
		query.append("		, BB.VSL_CD||BB.SKD_VOY_NO||BB.SKD_DIR_CD)) VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   ,BB.POR_CD" ).append("\n"); 
		query.append("	   ,BB.POL_CD" ).append("\n"); 
		query.append("	   ,BB.POD_CD" ).append("\n"); 
		query.append("	   ,BB.DEL_CD" ).append("\n"); 
		query.append("--	   ,(select RCV_TERM_CD from BKG_BOOKING where BKG_NO = A.BKG_NO)||'/'||(select DE_TERM_CD from BKG_BOOKING where BKG_NO = A.BKG_NO) as RD" ).append("\n"); 
		query.append("	   ,BB.RCV_TERM_CD||'/'||BB.DE_TERM_CD 		as RD" ).append("\n"); 
		query.append("	   ,B.BZC_TRF_CURR_CD 								as CHG_CURR_CD" ).append("\n"); 
		query.append("	   ,case " ).append("\n"); 
		query.append("			when (select AR_OFC_CD  from MDM_ORGANIZATION where OFC_CD = @[ofc_cd]) in ('MTRBS', 'TORSC', 'VANSO') then 'USD'" ).append("\n"); 
		query.append("            else (select AR_CURR_CD from MDM_ORGANIZATION where OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("        end												as INV_CURR_CD" ).append("\n"); 
		query.append("	   ,@[s_chg_type] 									as CHG_TYPE" ).append("\n"); 
		query.append("	   ,BB.RFA_NO" ).append("\n"); 
		query.append("	   ,max(B.ACT_CNT_CD||lpad(B.ACT_CUST_SEQ,6,'0')) 	as PAYER_CD" ).append("\n"); 
		query.append("	   ,max(lpad(B.VNDR_SEQ,6,'0')) 					as TRUCKER_CD" ).append("\n"); 
		query.append("	   ,sum(nvl(B.ORG_CHG_AMT,0)) 						as MN_ORG_CHG_AMT" ).append("\n"); 
		query.append("	   ,sum(nvl(B.SC_RFA_EXPT_AMT,0)) 					as DMDT_EXPT_AMT" ).append("\n"); 
		query.append("	   ,sum(nvl(B.AFT_EXPT_DC_AMT,0)) 					as CHG_DC_AMT" ).append("\n"); 
		query.append("	   ,sum(nvl(B.BIL_AMT,0)) 							as MN_BIL_AMT" ).append("\n"); 
		query.append("	   ,count(A.CNTR_NO) 								as CNTR_CNT" ).append("\n"); 
		query.append("	   ,BB.TAA_NO" ).append("\n"); 
		query.append("  from  DMT_CHG_BKG_CNTR    A" ).append("\n"); 
		query.append("       ,DMT_CHG_CALC        B" ).append("\n"); 
		query.append("	   ,BKG_BOOKING			BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--########## Confirm 된 Charge 는 무조건 Invoice 생성 대상이 되어야 함.(Office Transfer 조건과는 무관) 2015.02.26 ##############################	   " ).append("\n"); 
		query.append("--	   ,COM_SYS_AREA_GRP_ID D" ).append("\n"); 
		query.append("--####################################################################################################################################" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" where  A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("   and  A.CNTR_CYC_NO     = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  B.OFC_CD	      = @[s_ofc_cd]" ).append("\n"); 
		query.append("   and  A.BKG_NO          = @[s_bkg_no]" ).append("\n"); 
		query.append("   AND  A.BKG_NO          = BB.BKG_NO" ).append("\n"); 
		query.append("##AND B.DMDT_CHG_STS_CD = 'C'" ).append("\n"); 
		query.append("   and  B.DMDT_CHG_STS_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $dmdt_chg_sts_cd in ${dmdt_chg_sts_cd_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_chg_sts_cd_list.size()) " ).append("\n"); 
		query.append("				   '$dmdt_chg_sts_cd', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   '$dmdt_chg_sts_cd' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("   and  B.DMDT_TRF_CD     = @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--########## Confirm 된 Charge 는 무조건 Invoice 생성 대상이 되어야 함.(Office Transfer 조건과는 무관) 2015.02.26 ##############################" ).append("\n"); 
		query.append("--AND (							-- OFC_TRNS_FLG 상태에 따라 쿼리가 달라짐" ).append("\n"); 
		query.append("--			(	nvl(B.OFC_TRNS_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("--				AND D.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--				--AND D.CNT_CD = SUBSTR(B.FM_MVMT_YD_CD,1,2) " ).append("\n"); 
		query.append("--				AND D.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("--                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("--                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("--				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("--				AND DECODE(B.OFC_TRNS_RHQ_CNG_FLG, 'Y', B.SYS_AREA_GRP_ID, A.SYS_AREA_GRP_ID)=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--			)" ).append("\n"); 
		query.append("--       OR" ).append("\n"); 
		query.append("--       		(" ).append("\n"); 
		query.append("--				nvl(B.OFC_TRNS_FLG,'N') = 'N'" ).append("\n"); 
		query.append("--				AND D.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("--                                FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("--                                WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("--				AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("--       			AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID       " ).append("\n"); 
		query.append("--			)" ).append("\n"); 
		query.append("--		)" ).append("\n"); 
		query.append("--####################################################################################################################################" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("	, BB.BL_NO" ).append("\n"); 
		query.append("	, BB.BKG_NO" ).append("\n"); 
		query.append("	, B.DMDT_TRF_CD" ).append("\n"); 
		query.append("	, B.OFC_CD" ).append("\n"); 
		query.append("	, BB.SC_NO" ).append("\n"); 
		query.append("	, BB.POR_CD" ).append("\n"); 
		query.append("	, BB.POL_CD" ).append("\n"); 
		query.append("	, BB.POD_CD" ).append("\n"); 
		query.append("	, BB.DEL_CD" ).append("\n"); 
		query.append("	, BB.RCV_TERM_CD||'/'||BB.DE_TERM_CD" ).append("\n"); 
		query.append("	, B.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	, BB.RFA_NO" ).append("\n"); 
		query.append("    , BB.TAA_NO" ).append("\n"); 

	}
}