/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL
	  * </pre>
	  */
	public ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.integration").append("\n"); 
		query.append("FileName : ChargeCalculationReportDBDAODeleteInquiryByDeleteDateDetailRSQL").append("\n"); 
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
		query.append("select  T2.SYS_AREA_GRP_ID 																as SVR_ID" ).append("\n"); 
		query.append("       ,T2.DMDT_PRE_CHG_STS_CD 															as STATUS" ).append("\n"); 
		query.append("       ,T2.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("       ,T2.OFC_CD" ).append("\n"); 
		query.append("       ,T2.OFC_RHQ_CD" ).append("\n"); 
		query.append("       ,decode(T2.DMDT_CHG_DELT_RSN_CD, 'OTH', 'Other', R.INTG_CD_VAL_DP_DESC) as DELT_RSN_DESC" ).append("\n"); 
		query.append("       ,decode(T2.DMDT_CHG_DELT_RSN_CD, 'OTH', ' ', CTNT.ATTR_CTNT4) as DELT_SPEC_RSN_DESC" ).append("\n"); 
		query.append("       ,T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("       ,T2.CNTR_NO    " ).append("\n"); 
		query.append("       ,T3.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,T2.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,T2.TO_MVMT_YD_CD" ).append("\n"); 
		query.append("       ,T2.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,T2.TO_MVMT_STS_CD" ).append("\n"); 
		query.append("       ,T2.FT_DYS" ).append("\n"); 
		query.append("       ,T2.FX_FT_OVR_DYS" ).append("\n"); 
		query.append("       ,to_char(T2.FM_MVMT_DT, 'YYYYMMDD') 												as FM_MVMT_DT" ).append("\n"); 
		query.append("       ,to_char(T2.TO_MVMT_DT, 'YYYYMMDD') 												as TO_MVMT_DT" ).append("\n"); 
		query.append("       ,to_char(T2.FT_CMNC_DT, 'YYYYMMDD') 												as FT_CMNC_DT" ).append("\n"); 
		query.append("       ,to_char(T2.FT_END_DT,  'YYYYMMDD') 												as FT_END_DT" ).append("\n"); 
		query.append("       ,T2.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	   ,T2.ORG_CHG_AMT" ).append("\n"); 
		query.append("	   ,T2.SC_RFA_EXPT_AMT    " ).append("\n"); 
		query.append("	   ,T2.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	   ,T2.BIL_AMT" ).append("\n"); 
		query.append("	   ,T3.BKG_NO" ).append("\n"); 
		query.append("	   ,T3.BL_NO" ).append("\n"); 
		query.append("	   ,T3.VSL_CD || T3.SKD_VOY_NO || T3.SKD_DIR_CD 									as VVD_CD    " ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("	   	select  VSL_SLAN_CD" ).append("\n"); 
		query.append("	   	  from  VSK_VSL_SKD" ).append("\n"); 
		query.append("	   	 where  VSL_CD  = T3.VSL_CD" ).append("\n"); 
		query.append("	   	   and  SKD_VOY_NO = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("	   	   and  SKD_DIR_CD = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("	   ) 																				as LANE" ).append("\n"); 
		query.append("	   ,T3.POR_CD" ).append("\n"); 
		query.append("	   ,T3.POL_CD" ).append("\n"); 
		query.append("	   ,T3.POD_CD" ).append("\n"); 
		query.append("	   ,T3.DEL_CD" ).append("\n"); 
		query.append("	   ,T3.BKG_RCV_TERM_CD" ).append("\n"); 
		query.append("	   ,T3.BKG_DE_TERM_CD" ).append("\n"); 
		query.append("	   ,T3.SC_NO" ).append("\n"); 
		query.append("	   ,T3.RFA_NO" ).append("\n"); 
		query.append("	   ,decode(T2.CHG_SEQ, 1, 'G', 'B') 												as CHG_TYPE" ).append("\n"); 
		query.append("	   ,T2.CHG_SEQ" ).append("\n"); 
		query.append("	   ,nvl(T3.SOC_FLG, 'N') 															as SOC_FLG" ).append("\n"); 
		query.append("	   ,case" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DMIF' and T2.TO_MVMT_STS_CD = 'ID' then 'L'" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DMIF' and T2.TO_MVMT_STS_CD not in ('ID', 'CS', 'DR') then 'I'" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DMOF' and T2.DMDT_CHG_LOC_DIV_CD <> 'POL' then 'L'" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DMOF' and T2.DMDT_CHG_LOC_DIV_CD = 'POL' then 'I'" ).append("\n"); 
		query.append("	    end 																			as LI" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  nvl(HLG_TP_CD, 'N')" ).append("\n"); 
		query.append("			  from  BKG_EUR_TRO" ).append("\n"); 
		query.append("			 where  BKG_NO			  = T3.BKG_NO" ).append("\n"); 
		query.append("			   and  IO_BND_CD		  = substr(T2.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			   and  NVL(CXL_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("			   and  CNTR_NO	          = T2.CNTR_NO" ).append("\n"); 
		query.append("			   and  ROWNUM            = 1 " ).append("\n"); 
		query.append("	    )  																				as CH" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  'Y'" ).append("\n"); 
		query.append("			  from  DUAL" ).append("\n"); 
		query.append("			 where  exists" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  RLSE_STS_CD" ).append("\n"); 
		query.append("						  from  BKG_DO_DTL" ).append("\n"); 
		query.append("						 where  BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("						   and  RLSE_STS_CD in ('R', 'I')" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("	    ) 																				as D_O" ).append("\n"); 
		query.append("	   ,nvl(T2.OFC_TRNS_FLG, 'N') 														as OFC_TRNS_FLG" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  'C'" ).append("\n"); 
		query.append("			  from  DUAL" ).append("\n"); 
		query.append("			 where  exists" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  1" ).append("\n"); 
		query.append("						  from  BKG_ROLL_OVR" ).append("\n"); 
		query.append("						 where  BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("						   and  ROLL_OVR_RSN_CD IN ( 'C','H' )" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("        )																				as ROLL_OVR	" ).append("\n"); 
		query.append("	   ,T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("	   ,T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("	   ,T2.CORR_RMK" ).append("\n"); 
		query.append("	   ,decode(decode(T2.ACT_CNT_CD,'00','',T2.ACT_CNT_CD) || to_char(T2.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("	   		,'000000', null" ).append("\n"); 
		query.append("	   		,decode(T2.ACT_CNT_CD,'00','',T2.ACT_CNT_CD) || to_char(T2.ACT_CUST_SEQ, 'FM000000')" ).append("\n"); 
		query.append("	    ) 																				as PAYER_CD" ).append("\n"); 
		query.append("	   ,case" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DTIC' and T3.BKG_DE_TERM_CD = 'Y' and instr(nvl(T3.POD_CD,'  '), 'US') = 1 then " ).append("\n"); 
		query.append("				(	" ).append("\n"); 
		query.append("					select  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					  from  MDM_VENDOR" ).append("\n"); 
		query.append("					 where  VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD = 'DTOC' and T3.BKG_RCV_TERM_CD = 'Y' and instr(nvl(T3.POL_CD,'  '), 'US') = 1 then " ).append("\n"); 
		query.append("				(	" ).append("\n"); 
		query.append("					select  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("					  from  MDM_VENDOR" ).append("\n"); 
		query.append("					 where  VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("				)			" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD in ('DMIF', 'CTIC') or (T2.DMDT_TRF_CD = 'DTIC' and instr(nvl(T3.POD_CD,'  '), 'US') <> 1) then" ).append("\n"); 
		query.append("				(	" ).append("\n"); 
		query.append("					select  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("					  from  MDM_CUSTOMER" ).append("\n"); 
		query.append("					 where  CUST_CNT_CD = T2.ACT_CNT_CD" ).append("\n"); 
		query.append("					   and  CUST_SEQ    = T2.ACT_CUST_SEQ" ).append("\n"); 
		query.append("				)			" ).append("\n"); 
		query.append("			when T2.DMDT_TRF_CD in ('DMOF', 'CTOC') or (T2.DMDT_TRF_CD = 'DTOC' and instr(nvl(T3.POL_CD,'  '), 'US') <> 1) then" ).append("\n"); 
		query.append("				replace(BS.CUST_NM, chr(13)||chr(10),' ')" ).append("\n"); 
		query.append("        end  																			as PAYER_NM" ).append("\n"); 
		query.append("	   ,BS.CUST_CNT_CD || trim(to_char(BS.CUST_SEQ, '000000')) 							as SHIPPER_CD " ).append("\n"); 
		query.append("	   ,replace(BS.CUST_NM, chr(13)||chr(10), ' ') 										as SHIPPER_NM   " ).append("\n"); 
		query.append("	   ,decode(BC.CUST_CNT_CD || trim(to_char(BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("	   		,'000000', null" ).append("\n"); 
		query.append("	   		,BC.CUST_CNT_CD || trim(to_char(BC.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("	    ) 																				as CNEE_CD" ).append("\n"); 
		query.append("	   ,replace(BC.CUST_NM, chr(13)||chr(10), ' ') 										as CNEE_NM" ).append("\n"); 
		query.append("	   ,decode(BN.CUST_CNT_CD || trim(to_char(BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("	   		,'000000', null" ).append("\n"); 
		query.append("	   		,BN.CUST_CNT_CD || trim(to_char(BN.CUST_SEQ, '000000'))" ).append("\n"); 
		query.append("	    ) 																				as NTFY_CD" ).append("\n"); 
		query.append("	   ,nvl(rtrim(replace(replace(BN.CUST_NM, '''', ''), chr(13)||chr(10), ' ')), '-')	as NTFY_NM" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  I.ACT_CUST_CNT_CD || to_char(ACT_CUST_SEQ, '000000') " ).append("\n"); 
		query.append("			  from  INV_AR_MN I " ).append("\n"); 
		query.append("			 where  I.BKG_NO	= T3.BKG_NO" ).append("\n"); 
		query.append("			   and  I.IO_BND_CD	= SUBSTR(T2.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			   and  AR_IF_NO	= " ).append("\n"); 
		query.append("					( " ).append("\n"); 
		query.append("						select  max(AR_IF_NO) " ).append("\n"); 
		query.append("							 from  INV_AR_MN" ).append("\n"); 
		query.append("						 where  BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("						   and  IO_BND_CD = substr(T2.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   and  rownum  = 1" ).append("\n"); 
		query.append("	    ) 																				as AR_ACT_CD" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("			  from  MDM_CUSTOMER 	MC" ).append("\n"); 
		query.append("				   ,INV_AR_MN 		I" ).append("\n"); 
		query.append("			 where  MC.CUST_CNT_CD = I.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("			   and  MC.CUST_SEQ    = I.ACT_CUST_SEQ" ).append("\n"); 
		query.append("			   and  I.BKG_NO       = T3.BKG_NO" ).append("\n"); 
		query.append("			   and  I.IO_BND_CD    = substr(T2.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("			   and  AR_IF_NO	   = " ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  max(AR_IF_NO) " ).append("\n"); 
		query.append("						  from  INV_AR_MN" ).append("\n"); 
		query.append("						 where  BKG_NO = T3.BKG_NO" ).append("\n"); 
		query.append("						   and  IO_BND_CD = substr(T2.DMDT_TRF_CD, 3, 1)" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   and  rownum         = 1" ).append("\n"); 
		query.append("	    ) 																				as AR_ACT_NM" ).append("\n"); 
		query.append("	   ,decode(trim(to_char(T2.VNDR_SEQ, '000000')), '000000', null" ).append("\n"); 
		query.append("	   		,trim(to_char(T2.VNDR_SEQ, '000000'))" ).append("\n"); 
		query.append("	    ) 																				as SVC_PROVDR_CD	" ).append("\n"); 
		query.append("	   ,(	" ).append("\n"); 
		query.append("			select  VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("			  from  MDM_VENDOR" ).append("\n"); 
		query.append("			 where  VNDR_SEQ = T2.VNDR_SEQ" ).append("\n"); 
		query.append("	    ) 																				as SVC_PROVDR_NM" ).append("\n"); 
		query.append("	   ,to_char(T2.UPD_DT, 'YYYYMMDD') 													as DEL_DT" ).append("\n"); 
		query.append("	   ,T2.UPD_OFC_CD  																	as DEL_OFC" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  USR_NM" ).append("\n"); 
		query.append("			  from  COM_USER" ).append("\n"); 
		query.append("			 where  USR_ID = T2.UPD_USR_ID" ).append("\n"); 
		query.append("	    ) 																				as DEL_USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  DMT_CHG_DELT_RQST_APRO	T1 " ).append("\n"); 
		query.append("       ,DMT_CHG_CALC            T2" ).append("\n"); 
		query.append("	   ,DMT_CHG_BKG_CNTR		T3" ).append("\n"); 
		query.append("	   ,COM_INTG_CD_DTL			R	" ).append("\n"); 
		query.append("	   ,DMT_HRD_CDG_CTNT        CTNT" ).append("\n"); 
		query.append("	   ,BKG_CUSTOMER			BS" ).append("\n"); 
		query.append("	   ,BKG_CUSTOMER			BC" ).append("\n"); 
		query.append("	   ,BKG_CUSTOMER			BN" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" where  T1.DMDT_DELT_RQST_STS_CD in ('A', 'B', 'Q', 'H')	--// A:Approval(기존코드값 - TO-BE 사용되지 않음), B:BB Approval, Q:RHQ Approval, H:HO Approval" ).append("\n"); 
		query.append("   and  T1.UPD_DT between to_date(replace(@[fm_dt], '-', ''), 'YYYYMMDD') and to_date(replace(@[to_dt], '-', ''), 'YYYYMMDD') + .99999" ).append("\n"); 
		query.append("   and  T1.SYS_AREA_GRP_ID      = T2.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T1.CNTR_NO              = T2.CNTR_NO" ).append("\n"); 
		query.append("   and  T1.CNTR_CYC_NO          = T2.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  T1.DMDT_TRF_CD          = T2.DMDT_TRF_CD" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_LOC_DIV_CD  = T2.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("   and  T1.CHG_SEQ              = T2.CHG_SEQ" ).append("\n"); 
		query.append("   and  T1.CHG_OFC_CD           = T2.OFC_CD" ).append("\n"); 
		query.append("   and  T1.DELT_SEQ             =" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			select  max(DELT_SEQ)" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_RQST_APRO" ).append("\n"); 
		query.append("			 where  SYS_AREA_GRP_ID 	 = T1.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("			   and  CNTR_NO              = T1.CNTR_NO" ).append("\n"); 
		query.append("			   and  CNTR_CYC_NO          = T1.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   and  DMDT_TRF_CD          = T1.DMDT_TRF_CD" ).append("\n"); 
		query.append("			   and  DMDT_CHG_LOC_DIV_CD  = T1.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("			   and  CHG_SEQ              = T1.CHG_SEQ" ).append("\n"); 
		query.append("			   and  CHG_OFC_CD           = T1.CHG_OFC_CD" ).append("\n"); 
		query.append("		)   " ).append("\n"); 
		query.append("   and  T2.DMDT_CHG_STS_CD      = 'D'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("   and  (T2.OFC_RHQ_CD, T2.DMDT_CHG_DELT_RSN_CD,NVL(T2.DMDT_CHG_DELT_SPEC_RSN_CD,' ')) in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			select  BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1)" ).append("\n"); 
		query.append("                   ,BKG_GET_TOKEN_FNC(COLUMN_VALUE, 2)" ).append("\n"); 
		query.append("				   ,NVL(BKG_GET_TOKEN_FNC(COLUMN_VALUE,3),' ')" ).append("\n"); 
		query.append("              from  TABLE(BKG_SPLIT_CLOB_FNC(${ofc_cd_delt_rsn_cd_list}, '@'))" ).append("\n"); 
		query.append("             where  COLUMN_VALUE is not null" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   and  (T2.OFC_CD, T2.DMDT_CHG_DELT_RSN_CD,NVL(T2.DMDT_CHG_DELT_SPEC_RSN_CD,' ')) in " ).append("\n"); 
		query.append("		( " ).append("\n"); 
		query.append("			select  BKG_GET_TOKEN_FNC(COLUMN_VALUE, 1)" ).append("\n"); 
		query.append("				   ,BKG_GET_TOKEN_FNC(COLUMN_VALUE,2)" ).append("\n"); 
		query.append("				   ,NVL(BKG_GET_TOKEN_FNC(COLUMN_VALUE,3),' ')" ).append("\n"); 
		query.append("			  from  TABLE(BKG_SPLIT_CLOB_FNC(${ofc_cd_delt_rsn_cd_list}, '@'))" ).append("\n"); 
		query.append("             where  COLUMN_VALUE is not null" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   and  T2.DMDT_CHG_LOC_DIV_CD <> 'SZP'	-- 2010/03/19 추가   " ).append("\n"); 
		query.append("   and  T2.SYS_AREA_GRP_ID		= T3.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("   and  T2.CNTR_NO				= T3.CNTR_NO" ).append("\n"); 
		query.append("   and  T2.CNTR_CYC_NO			= T3.CNTR_CYC_NO" ).append("\n"); 
		query.append("   and  R.INTG_CD_ID			= 'CD01965'" ).append("\n"); 
		query.append("   and  T1.DMDT_CHG_DELT_RSN_CD = R.INTG_CD_VAL_CTNT   " ).append("\n"); 
		query.append("   and  CTNT.HRD_CDG_ID(+)      = 'CHG_DELT_RSN_CD'" ).append("\n"); 
		query.append("   and  CTNT.ATTR_CTNT1(+)      = T2.DMDT_CHG_DELT_RSN_CD" ).append("\n"); 
		query.append("   and  CTNT.ATTR_CTNT3(+)      = T2.DMDT_CHG_DELT_SPEC_RSN_CD" ).append("\n"); 
		query.append("   and  T3.BKG_NO				= BS.BKG_NO(+)" ).append("\n"); 
		query.append("   and  BS.BKG_CUST_TP_CD(+)	= 'S'" ).append("\n"); 
		query.append("   and  T3.BKG_NO				= BC.BKG_NO(+)" ).append("\n"); 
		query.append("   and  BC.BKG_CUST_TP_CD(+)	= 'C'" ).append("\n"); 
		query.append("   and  T3.BKG_NO				= BN.BKG_NO(+)" ).append("\n"); 
		query.append("   and  BN.BKG_CUST_TP_CD(+)	= 'N'" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("order by T2.OFC_CD, R.INTG_CD_VAL_DP_SEQ, T2.DMDT_TRF_CD, T2.CNTR_NO" ).append("\n"); 

	}
}