/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOSearchUncollectedInquiryByCaseListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOSearchUncollectedInquiryByCaseListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UC Inquiry By Case 리스트 조회
	  * </pre>
	  */
	public UncollectedCargoDBDAOSearchUncollectedInquiryByCaseListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnee_uc_dt_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_dys_fr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_hndl_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_dys_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_hndl_brnc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_kntr_brnc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cnee_uc_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_kntr_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_uc_disp_opt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOSearchUncollectedInquiryByCaseListRSQL").append("\n"); 
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
		query.append("SELECT	ROWNUM AS RNUM" ).append("\n"); 
		query.append("	, UC_CS_NO" ).append("\n"); 
		query.append("	, UC_STS_CD" ).append("\n"); 
		query.append("	, HNDL_RHQ_CD" ).append("\n"); 
		query.append("	, HNDL_BRNC_CD" ).append("\n"); 
		query.append("	, KNTR_RHQ_CD" ).append("\n"); 
		query.append("	, KNTR_BRNC_CD" ).append("\n"); 
		query.append("	, BL_NO" ).append("\n"); 
		query.append("	, CNTR_CNT" ).append("\n"); 
		query.append("	, BL_CNT" ).append("\n"); 
		query.append("	, SHPR" ).append("\n"); 
		query.append("	, CNEE" ).append("\n"); 
		query.append("	, NOTI" ).append("\n"); 
		query.append("	, POL_CD" ).append("\n"); 
		query.append("	, POL_ETD" ).append("\n"); 
		query.append("	, POD_CD" ).append("\n"); 
		query.append("	, POD_ETA" ).append("\n"); 
		query.append("	, CNEE_UC_DT" ).append("\n"); 
		query.append("	, UC_CLZ_DT" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UC_DYS" ).append("\n"); 
		query.append("	, ROUND(NVL(TO_DATE(UC_CLZ_DT,'YYYYMMDD'),SYSDATE) - POD_ETA,0) AS DAYS_FROM_DISC" ).append("\n"); 
		query.append("	, UC_DCHG_DYS" ).append("\n"); 
		query.append("	, UC_DISP_OPT_CD" ).append("\n"); 
		query.append("	, OTS_OTR_COST_AMT" ).append("\n"); 
		query.append("	, OTS_RCVR_AMT" ).append("\n"); 
		query.append("	, NET_LOSS" ).append("\n"); 
		query.append("	, UC_CGO_N1ST_NTC_DT" ).append("\n"); 
		query.append("	, UC_CGO_N2ND_NTC_DT" ).append("\n"); 
		query.append("	, UC_CGO_N3RD_NTC_DT" ).append("\n"); 
		query.append("	, UC_CGO_FNL_NTC_DT" ).append("\n"); 
		query.append("	, UC_PICLB_CD" ).append("\n"); 
		query.append("	, OTS_INSUR_CVR_AMT" ).append("\n"); 
		query.append("	, HNDL_UPD_ID" ).append("\n"); 
		query.append("	, UC_RSN_CD" ).append("\n"); 
		query.append("	, CMDT" ).append("\n"); 
		query.append("FROM(SELECT DISTINCT DTL.BL_NO" ).append("\n"); 
		query.append("		    ,  CGO.UC_CS_NO" ).append("\n"); 
		query.append("		    , CGO.UC_STS_CD" ).append("\n"); 
		query.append("		    , CGO.HNDL_RHQ_CD" ).append("\n"); 
		query.append("		    , CGO.HNDL_BRNC_CD" ).append("\n"); 
		query.append("		    , CGO.KNTR_RHQ_CD" ).append("\n"); 
		query.append("		    , CGO.KNTR_BRNC_CD" ).append("\n"); 
		query.append("            , (SELECT COUNT(1) FROM CIM_UC_CGO_CNTR AA " ).append("\n"); 
		query.append("             WHERE  AA.UC_CS_NO = CGO.UC_CS_NO" ).append("\n"); 
		query.append("             ) CNTR_CNT            " ).append("\n"); 
		query.append("            , (SELECT COUNT(1) FROM CIM_UC_CGO_DTL AA " ).append("\n"); 
		query.append("             WHERE  AA.UC_CS_NO = DTL.UC_CS_NO" ).append("\n"); 
		query.append("             ) BL_CNT" ).append("\n"); 
		query.append("           , ( SELECT REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("               FROM   BKG_CUSTOMER C" ).append("\n"); 
		query.append("               WHERE  BKG.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("               AND    C.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("              ) SHPR" ).append("\n"); 
		query.append("           , ( SELECT REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("               FROM   BKG_CUSTOMER C" ).append("\n"); 
		query.append("               WHERE  BKG.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("               AND    C.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("              ) CNEE        " ).append("\n"); 
		query.append("            , ( SELECT REPLACE(SUBSTR(C.CUST_NM,1,50),CHR(13)||CHR(10),' ')" ).append("\n"); 
		query.append("                FROM   BKG_CUSTOMER C" ).append("\n"); 
		query.append("                WHERE  BKG.BKG_NO         = C.BKG_NO" ).append("\n"); 
		query.append("                AND    C.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("              ) NOTI        " ).append("\n"); 
		query.append("           , (" ).append("\n"); 
		query.append("                SELECT  MIN(bb.pol_cd)" ).append("\n"); 
		query.append("                FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND kk.bl_no = BKG.bl_no" ).append("\n"); 
		query.append("                AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                AND kk.pol_cd = bb.pol_cd" ).append("\n"); 
		query.append("                AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                AND bb.pol_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pol_cd" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("             SELECT  MIN(vv.vps_etd_dt)" ).append("\n"); 
		query.append("             FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("             WHERE   1 = 1" ).append("\n"); 
		query.append("                     AND kk.bl_no = BKG.bl_no" ).append("\n"); 
		query.append("                     AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                     AND kk.pol_cd = bb.pol_cd" ).append("\n"); 
		query.append("                     AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                     AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                     AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                     AND bb.pol_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pol_etd" ).append("\n"); 
		query.append("       , ( " ).append("\n"); 
		query.append("            SELECT  MIN(bb.pod_cd)" ).append("\n"); 
		query.append("            FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND kk.bl_no = BKG.bl_no" ).append("\n"); 
		query.append("                    AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                    AND kk.pod_cd = bb.pod_cd" ).append("\n"); 
		query.append("                    AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                    AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                    AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                    AND bb.pod_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pod_cd" ).append("\n"); 
		query.append("        , ( " ).append("\n"); 
		query.append("            SELECT  MIN(vv.vps_eta_dt)" ).append("\n"); 
		query.append("            FROM    bkg_vvd bb, bkg_booking kk, vsk_vsl_port_skd vv" ).append("\n"); 
		query.append("            WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND kk.bl_no = BKG.bl_no" ).append("\n"); 
		query.append("                    AND kk.bkg_no = bb.bkg_no" ).append("\n"); 
		query.append("                    AND kk.pod_cd = bb.pod_cd" ).append("\n"); 
		query.append("                    AND bb.vsl_cd = vv.vsl_cd" ).append("\n"); 
		query.append("                    AND bb.skd_voy_no = vv.skd_voy_no" ).append("\n"); 
		query.append("                    AND bb.skd_dir_cd = vv.skd_dir_cd" ).append("\n"); 
		query.append("                    AND bb.pod_cd = vv.vps_port_cd" ).append("\n"); 
		query.append("          ) pod_eta        " ).append("\n"); 
		query.append("		, CGO.CNEE_UC_DT" ).append("\n"); 
		query.append("		, CGO.UC_CLZ_DT" ).append("\n"); 
		query.append("		, CGO.CRE_DT" ).append("\n"); 
		query.append("		, NVL(TO_DATE(CGO.UC_CLZ_DT,'YYYYMMDD'), TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')) - TO_DATE(CGO.CNEE_UC_DT,'YYYYMMDD') UC_DYS" ).append("\n"); 
		query.append("		, UC_DCHG_DYS" ).append("\n"); 
		query.append("		, DTL.UC_DISP_OPT_CD" ).append("\n"); 
		query.append("        , (SELECT SUM((NVL(OTS_OFT_AMT,0) + NVL(OTS_OTR_AMT,0) + NVL(OTS_DMDT_AMT,0) + NVL(OTS_STO_AMT,0) + NVL(OTS_OTR_COST_AMT,0)))" ).append("\n"); 
		query.append("           FROM   CIM_UC_CGO_DTL" ).append("\n"); 
		query.append("           WHERE  UC_CS_NO = DTL.UC_CS_NO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           )  AS OTS_OTR_COST_AMT         " ).append("\n"); 
		query.append("        , (SELECT SUM(OTS_RCVR_AMT)" ).append("\n"); 
		query.append("           FROM   CIM_UC_CGO_DTL" ).append("\n"); 
		query.append("           WHERE  UC_CS_NO = DTL.UC_CS_NO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ) AS OTS_RCVR_AMT      " ).append("\n"); 
		query.append("        , (SELECT SUM((NVL(OTS_OFT_AMT,0) + NVL(OTS_OTR_AMT,0) + NVL(OTS_DMDT_AMT,0) + NVL(OTS_STO_AMT,0) + NVL(OTS_OTR_COST_AMT,0)) - NVL(OTS_RCVR_AMT,0))" ).append("\n"); 
		query.append("           FROM   CIM_UC_CGO_DTL" ).append("\n"); 
		query.append("           WHERE  UC_CS_NO = DTL.UC_CS_NO" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("           ) AS NET_LOSS" ).append("\n"); 
		query.append("		, DTL.UC_CGO_N1ST_NTC_DT" ).append("\n"); 
		query.append("		, DTL.UC_CGO_N2ND_NTC_DT" ).append("\n"); 
		query.append("		, DTL.UC_CGO_N3RD_NTC_DT" ).append("\n"); 
		query.append("		, DTL.UC_CGO_FNL_NTC_DT" ).append("\n"); 
		query.append("		, DTL.UC_PICLB_CD" ).append("\n"); 
		query.append("		, DTL.OTS_INSUR_CVR_AMT" ).append("\n"); 
		query.append("		, CGO.HNDL_HDLR_USR_ID HNDL_UPD_ID" ).append("\n"); 
		query.append("		, DTL.UC_RSN_CD" ).append("\n"); 
		query.append("                , ( SELECT C.CMDT_NM " ).append("\n"); 
		query.append("                     FROM MDM_COMMODITY C " ).append("\n"); 
		query.append("                    WHERE C.CMDT_CD = BKG.CMDT_CD" ).append("\n"); 
		query.append("                ) CMDT        " ).append("\n"); 
		query.append("    FROM CIM_UC_CGO CGO" ).append("\n"); 
		query.append("	    , CIM_UC_CGO_DTL DTL" ).append("\n"); 
		query.append("	    , CIM_UC_CGO_CNTR CNTR" ).append("\n"); 
		query.append("	    , BKG_BOOKING BKG" ).append("\n"); 
		query.append("    WHERE CGO.UC_CS_NO = DTL.UC_CS_NO" ).append("\n"); 
		query.append("    AND   DTL.UC_CS_NO = CNTR.UC_CS_NO" ).append("\n"); 
		query.append("    AND   DTL.BL_NO = CNTR.BL_NO" ).append("\n"); 
		query.append("    AND   DTL.BL_NO = BKG.BL_NO" ).append("\n"); 
		query.append("    AND   DTL.UC_SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${s_retrieve_gb} == 'A' )  " ).append("\n"); 
		query.append("	#if (${s_uc_cs_no} != '' )" ).append("\n"); 
		query.append("	    AND UC_CS_NO = @[s_uc_cs_no]    -- UC Case No" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_bl_no} != '' )" ).append("\n"); 
		query.append("	    AND BL_NO = @[s_bl_no]          -- B/L No" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_cntr_no} != '' )" ).append("\n"); 
		query.append("	    AND CNTR_NO = @[s_cntr_no]      -- CNTR NO" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_retrieve_gb} == 'B' )  " ).append("\n"); 
		query.append("	#if (${s_uc_sts_cd} != '' )   " ).append("\n"); 
		query.append("	    AND UC_STS_CD = @[s_uc_sts_cd]    -- UC Status" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_uc_rsn_cd} != '' )" ).append("\n"); 
		query.append("	    AND uc_rsn_cd = @[s_uc_rsn_cd]    -- UC Type" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_uc_disp_opt_cd} != '' )" ).append("\n"); 
		query.append("	    AND UC_DISP_OPT_CD = @[s_uc_disp_opt_cd]  -- Disposal" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_hndl_rhq_cd} != '' )" ).append("\n"); 
		query.append("	    AND HNDL_RHQ_CD = @[s_hndl_rhq_cd]  -- Handling RHQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_kntr_rhq_cd} != '' )" ).append("\n"); 
		query.append("	    AND KNTR_RHQ_CD = @[s_kntr_rhq_cd]  -- Counter RHQ" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_hndl_brnc_cd} != '' )" ).append("\n"); 
		query.append("	    AND HNDL_BRNC_CD = @[s_hndl_brnc_cd]    -- Handling OFC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_kntr_brnc_cd} != '' )" ).append("\n"); 
		query.append("	    AND KNTR_BRNC_CD = @[s_kntr_brnc_cd]    -- Counter OFC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_pol_cd} != '' )" ).append("\n"); 
		query.append("	    AND POL_CD = @[s_pol_cd]    -- POL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_pod_cd} != '' )" ).append("\n"); 
		query.append("	    AND POD_CD = @[s_pod_cd]    -- POD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_cnee_uc_dt_fr} != '' && ${s_cnee_uc_dt_to} != '' )" ).append("\n"); 
		query.append("	      #if (${s_cnee_uc_dt_gb} == 'A') -- UC Date" ).append("\n"); 
		query.append("	      	AND CNEE_UC_DT BETWEEN @[s_cnee_uc_dt_fr] AND @[s_cnee_uc_dt_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	      #if (${s_cnee_uc_dt_gb} == 'B') -- Close Date" ).append("\n"); 
		query.append("	      	AND UC_CLZ_DT BETWEEN @[s_cnee_uc_dt_fr] AND @[s_cnee_uc_dt_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	      #if (${s_cnee_uc_dt_gb} == 'C') -- Creation Date" ).append("\n"); 
		query.append("	      	AND TO_CHAR(CRE_DT,'YYYYMMDD') BETWEEN @[s_cnee_uc_dt_fr] AND @[s_cnee_uc_dt_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	      #if (${s_cnee_uc_dt_gb} == 'D') -- POL Date" ).append("\n"); 
		query.append("	      	AND TO_CHAR(POL_ETD,'YYYYMMDD') BETWEEN @[s_cnee_uc_dt_fr] AND @[s_cnee_uc_dt_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	      #if (${s_cnee_uc_dt_gb} == 'E') -- POD Date" ).append("\n"); 
		query.append("	      	AND TO_CHAR(POD_ETA,'YYYYMMDD') BETWEEN @[s_cnee_uc_dt_fr] AND @[s_cnee_uc_dt_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_uc_dys_fr} != '' && ${s_uc_dys_to} != '' )" ).append("\n"); 
		query.append("	      #if (${s_uc_dys_gb} == 'A') -- UC Days" ).append("\n"); 
		query.append("	      	AND UC_DYS  BETWEEN @[s_uc_dys_fr] AND @[s_uc_dys_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	      #if (${s_uc_dys_gb} == 'B') -- Days from Disc" ).append("\n"); 
		query.append("	      	AND ROUND(SYSDATE - POD_ETA,0) BETWEEN @[s_uc_dys_fr] AND @[s_uc_dys_to]" ).append("\n"); 
		query.append("	      #end	" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY UC_CS_NO" ).append("\n"); 

	}
}