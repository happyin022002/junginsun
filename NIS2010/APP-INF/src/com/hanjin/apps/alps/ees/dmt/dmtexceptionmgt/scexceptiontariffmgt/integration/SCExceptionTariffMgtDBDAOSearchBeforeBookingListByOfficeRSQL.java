/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchBeforeBookingListByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchBeforeBookingListByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SC & RFA Exception Inquiry (BeforeBooking, OFFICE) 조회쿼리
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchBeforeBookingListByOfficeRSQL(){
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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchBeforeBookingListByOfficeRSQL").append("\n"); 
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
		query.append("SELECT  /*+ ORDERED USE_NL(X TRF MN HDR CUST CUST2 COM_DTL COM_DTL2 COM_DTL3) */" ).append("\n"); 
		query.append("HDR.RFA_NO," ).append("\n"); 
		query.append("COM_DTL.INTG_CD_VAL_DP_DESC   STATUS," ).append("\n"); 
		query.append("X.RQST_SEQ," ).append("\n"); 
		query.append("X.TARIFF," ).append("\n"); 
		query.append("X.EFF_DT," ).append("\n"); 
		query.append("X.EXP_DT," ).append("\n"); 
		query.append("COM_DTL2.INTG_CD_VAL_DP_DESC || ' - ' || COM_DTL3.INTG_CD_VAL_DP_DESC   CNTRCGO," ).append("\n"); 
		query.append("X.CVRG_SEQ," ).append("\n"); 
		query.append("X.CNT_CD," ).append("\n"); 
		query.append("X.RGN_CD," ).append("\n"); 
		query.append("X.LOC_CD," ).append("\n"); 
		query.append("X.FT_ADD_DYS," ).append("\n"); 
		query.append("X.FT_TOT_DYS," ).append("\n"); 
		query.append("X.XCLD_SAT_FLG," ).append("\n"); 
		query.append("X.XCLD_SUN_FLG," ).append("\n"); 
		query.append("X.XCLD_HOL_FLG," ).append("\n"); 
		query.append("X.CURR_CD," ).append("\n"); 
		query.append("X.ORG_DEST_MULTI," ).append("\n"); 
		query.append("X.ORG_DEST_CONTI_CD," ).append("\n"); 
		query.append("X.ORG_DEST_CNT_CD," ).append("\n"); 
		query.append("X.ORG_DEST_RGN_CD," ).append("\n"); 
		query.append("X.ORG_DEST_LOC_CD," ).append("\n"); 
		query.append("X.FNL_DEST_CNT_CD," ).append("\n"); 
		query.append("X.FNL_DEST_RGN_CD," ).append("\n"); 
		query.append("X.FNL_DEST_LOC_CD," ).append("\n"); 
		query.append("X.ACT_CUST_CNT_CD || LPAD(X.ACT_CUST_SEQ, 6, '0')   ACT_CUST_CD," ).append("\n"); 
		query.append("CUST2.CUST_LGL_ENG_NM                               ACT_CUST_NM," ).append("\n"); 
		query.append("X.RT_FLG," ).append("\n"); 
		query.append("X.DAR_NO," ).append("\n"); 
		query.append("X.VER_SEQ," ).append("\n"); 
		query.append("TRF.RFA_EXPT_APRO_NO    APVL_NO," ).append("\n"); 
		query.append("TRF.PROP_NO," ).append("\n"); 
		query.append("MN.CTRT_CUST_CNT_CD || LPAD(MN.CTRT_CUST_SEQ, 6, '0')    CUST_CD," ).append("\n"); 
		query.append("CUST.CUST_LGL_ENG_NM                                     CUST_NM" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("RQST_SEQ" ).append("\n"); 
		query.append(",       TARIFF" ).append("\n"); 
		query.append(",       EFF_DT" ).append("\n"); 
		query.append(",       EXP_DT" ).append("\n"); 
		query.append(",       CVRG_SEQ" ).append("\n"); 
		query.append(",       CNT_CD" ).append("\n"); 
		query.append(",       RGN_CD" ).append("\n"); 
		query.append(",       LOC_CD" ).append("\n"); 
		query.append(",       FT_ADD_DYS" ).append("\n"); 
		query.append(",       FT_TOT_DYS" ).append("\n"); 
		query.append(",       XCLD_SAT_FLG" ).append("\n"); 
		query.append(",       XCLD_SUN_FLG" ).append("\n"); 
		query.append(",       XCLD_HOL_FLG" ).append("\n"); 
		query.append(",       CURR_CD" ).append("\n"); 
		query.append(",       DECODE(CVRG_COUNT, 1, 'Single', 'Multi') ORG_DEST_MULTI" ).append("\n"); 
		query.append(",       DECODE(CVRG_COUNT, 1, ORG_DEST_CONTI_CD, '') ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",       DECODE(CVRG_COUNT, 1, ORG_DEST_CNT_CD, '') ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",       DECODE(CVRG_COUNT, 1, ORG_DEST_RGN_CD, '') ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",       DECODE(CVRG_COUNT, 1, ORG_DEST_LOC_CD, '') ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",       FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",       FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",       FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",       ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",       ACT_CUST_SEQ" ).append("\n"); 
		query.append(",       RT_FLG" ).append("\n"); 
		query.append(",       DAR_NO" ).append("\n"); 
		query.append(",       VER_SEQ" ).append("\n"); 
		query.append(",       DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",       DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",       RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("SELECT  /*+ ORDERED USE_NL(TRF_DTL CVRG) */" ).append("\n"); 
		query.append("TRF_DTL.RFA_RQST_DTL_SEQ RQST_SEQ" ).append("\n"); 
		query.append(",       TRF_DTL.DMDT_TRF_CD TARIFF" ).append("\n"); 
		query.append(",       TO_CHAR(TRF_DTL.EFF_DT, 'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append(",       TO_CHAR(TRF_DTL.EXP_DT, 'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append(",       CVRG.CVRG_CMB_SEQ CVRG_SEQ" ).append("\n"); 
		query.append(",       CVRG.CVRG_CNT_CD CNT_CD" ).append("\n"); 
		query.append(",       CASE WHEN CVRG.CVRG_CNT_CD IN ('CA', 'US') THEN CVRG.CVRG_STE_CD ELSE CVRG.CVRG_RGN_CD END RGN_CD" ).append("\n"); 
		query.append(",       CVRG.CVRG_LOC_CD LOC_CD" ).append("\n"); 
		query.append(",       TRF_DTL.ADD_DYS FT_ADD_DYS" ).append("\n"); 
		query.append(",       TRF_DTL.TTL_DYS FT_TOT_DYS" ).append("\n"); 
		query.append(",       TRF_DTL.XCLD_SAT_FLG" ).append("\n"); 
		query.append(",       TRF_DTL.XCLD_SUN_FLG" ).append("\n"); 
		query.append(",       TRF_DTL.XCLD_HOL_FLG" ).append("\n"); 
		query.append(",       TRF_DTL.CURR_CD" ).append("\n"); 
		query.append(",       CVRG.ORG_DEST_CONTI_CD" ).append("\n"); 
		query.append(",       CVRG.ORG_DEST_CNT_CD" ).append("\n"); 
		query.append(",       CASE WHEN CVRG.ORG_DEST_CNT_CD IN ('CA', 'US') THEN CVRG.ORG_DEST_STE_CD ELSE CVRG.ORG_DEST_RGN_CD END ORG_DEST_RGN_CD" ).append("\n"); 
		query.append(",       CVRG.ORG_DEST_LOC_CD" ).append("\n"); 
		query.append(",       TRF_DTL.FNL_DEST_CNT_CD" ).append("\n"); 
		query.append(",       CASE WHEN TRF_DTL.FNL_DEST_CNT_CD IN ('CA', 'US') THEN TRF_DTL.FNL_DEST_STE_CD ELSE TRF_DTL.FNL_DEST_RGN_CD END FNL_DEST_RGN_CD" ).append("\n"); 
		query.append(",       TRF_DTL.FNL_DEST_LOC_CD" ).append("\n"); 
		query.append(",       TRF_DTL.ACT_CUST_CNT_CD" ).append("\n"); 
		query.append(",       TRF_DTL.ACT_CUST_SEQ" ).append("\n"); 
		query.append(",       TRF_DTL.RT_USE_FLG RT_FLG" ).append("\n"); 
		query.append(",       TRF_DTL.RFA_EXPT_DAR_NO DAR_NO" ).append("\n"); 
		query.append(",       LPAD(TRF_DTL.RFA_EXPT_VER_SEQ, 3, '0') VER_SEQ" ).append("\n"); 
		query.append(",       TRF_DTL.DMDT_CNTR_TP_CD" ).append("\n"); 
		query.append(",       TRF_DTL.DMDT_CGO_TP_CD" ).append("\n"); 
		query.append(",       TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",      (" ).append("\n"); 
		query.append("SELECT  COUNT(CVRG_CMB_SEQ)" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO     = TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND     RFA_EXPT_MAPG_SEQ   = TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND     RFA_EXPT_VER_SEQ    = TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND     RFA_RQST_DTL_SEQ    = TRF_DTL.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(")  CVRG_COUNT" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_TRF_DTL TRF_DTL    -- 기준 집합 레벨" ).append("\n"); 
		query.append(",   DMT_RFA_EXPT_CVRG_CMB CVRG      -- 1집합" ).append("\n"); 
		query.append(",  (SELECT  LCT.CNT_CD, LCT.RGN_CD, LCT.STE_CD, LCT.LOC_CD, ROWNUM" ).append("\n"); 
		query.append("FROM    MDM_YARD YARD" ).append("\n"); 
		query.append(",   MDM_LOCATION LCT" ).append("\n"); 
		query.append("WHERE   YARD.DMDT_OFC_CD IN (" ).append("\n"); 
		query.append("#foreach( $ofc_cd in ${dmdt_ofc_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $dmdt_ofc_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     YARD.LOC_CD = LCT.LOC_CD" ).append("\n"); 
		query.append(")  X" ).append("\n"); 
		query.append("WHERE   TRF_DTL.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("#foreach( $trf_cd in ${trf_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $trf_cd_list.size()) '$trf_cd', #else '$trf_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND    (" ).append("\n"); 
		query.append("(TRF_DTL.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EFF_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(TRF_DTL.EXP_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(TRF_DTL.EFF_DT <= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT >= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(TRF_DTL.EFF_DT >= TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TRF_DTL.EXP_DT <= TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     CVRG.ROWID = (SELECT  /*+ INDEX_ASC(DMT_RFA_EXPT_CVRG_CMB XPKDMT_RFA_EXPT_CVRG_CMB) */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM    DMT_RFA_EXPT_CVRG_CMB" ).append("\n"); 
		query.append("WHERE   RFA_EXPT_DAR_NO = TRF_DTL.RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND     RFA_EXPT_MAPG_SEQ = TRF_DTL.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND     RFA_EXPT_VER_SEQ = TRF_DTL.RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("AND     RFA_RQST_DTL_SEQ = TRF_DTL.RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     CVRG.CVRG_CNT_CD = X.CNT_CD" ).append("\n"); 
		query.append("AND     CVRG.CVRG_RGN_CD = DECODE(CVRG.CVRG_RGN_CD, ' ', ' ', DECODE(X.CNT_CD, 'CA', ' ', 'US', ' ', X.RGN_CD))" ).append("\n"); 
		query.append("AND     CVRG.CVRG_STE_CD = DECODE(CVRG.CVRG_STE_CD, ' ', ' ', DECODE(X.CNT_CD, 'CA', X.CNT_CD, 'US', X.STE_CD, ' '))" ).append("\n"); 
		query.append("AND     CVRG.CVRG_LOC_CD = DECODE(CVRG.CVRG_LOC_CD, ' ', ' ', X.LOC_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")  X," ).append("\n"); 
		query.append("DMT_RFA_EXPT_TRF TRF,           -- 1집합" ).append("\n"); 
		query.append("PRI_RP_MN MN,                   -- 1집합" ).append("\n"); 
		query.append("PRI_RP_HDR HDR,                 -- 1집합" ).append("\n"); 
		query.append("MDM_CUSTOMER CUST,              -- 1집합" ).append("\n"); 
		query.append("MDM_CUSTOMER CUST2,             -- 1집합" ).append("\n"); 
		query.append("COM_INTG_CD_DTL COM_DTL,        -- 1집합" ).append("\n"); 
		query.append("COM_INTG_CD_DTL COM_DTL2,       -- 1집합" ).append("\n"); 
		query.append("COM_INTG_CD_DTL COM_DTL3        -- 1집합" ).append("\n"); 
		query.append("WHERE   HDR.PROP_NO = MN.PROP_NO" ).append("\n"); 
		query.append("AND     MN.ROWID = (SELECT /*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */" ).append("\n"); 
		query.append("ROWID" ).append("\n"); 
		query.append("FROM   PRI_RP_MN" ).append("\n"); 
		query.append("WHERE  PROP_NO = TRF.PROP_NO" ).append("\n"); 
		query.append("AND    ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND 	MN.CTRT_CUST_CNT_CD 	= CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND 	MN.CTRT_CUST_SEQ 		= CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND 	MN.CTRT_CUST_CNT_CD 	= CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("AND 	MN.CTRT_CUST_SEQ 		= CUST.CUST_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cust_cd} != '' && ${act_cust_cd} == '')" ).append("\n"); 
		query.append("AND 	MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3)" ).append("\n"); 
		query.append("#elseif(${cust_cd} == '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND 	X.ACT_CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND X.ACT_CUST_SEQ = SUBSTR(@[act_cust_cd], 3)" ).append("\n"); 
		query.append("#elseif(${cust_cd} != '' && ${act_cust_cd} != '')" ).append("\n"); 
		query.append("AND 	(" ).append("\n"); 
		query.append("(MN.CTRT_CUST_CNT_CD = SUBSTR(@[cust_cd], 0, 2) AND MN.CTRT_CUST_SEQ = SUBSTR(@[cust_cd], 3))" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(X.ACT_CUST_CNT_CD = SUBSTR(@[act_cust_cd], 0, 2) AND X.ACT_CUST_SEQ = SUBSTR(@[act_cust_cd], 3))" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     X.ACT_CUST_CNT_CD         = CUST2.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     X.ACT_CUST_SEQ            = CUST2.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     TRF.DMDT_EXPT_RQST_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND     COM_DTL.INTG_CD_ID        = 'CD02069'" ).append("\n"); 
		query.append("AND     X.DMDT_CNTR_TP_CD         = COM_DTL2.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND     COM_DTL2.INTG_CD_ID       = 'CD02053'" ).append("\n"); 
		query.append("AND     X.DMDT_CGO_TP_CD          = COM_DTL3.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND     COM_DTL3.INTG_CD_ID       = 'CD01963'" ).append("\n"); 
		query.append("AND     TRF.DMDT_EXPT_RQST_STS_CD IN (" ).append("\n"); 
		query.append("#foreach( $sts_cd in ${sts_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $sts_cd_list.size()) '$sts_cd', #else '$sts_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND     TRF.RFA_EXPT_DAR_NO       = X.DAR_NO" ).append("\n"); 
		query.append("AND     TRF.RFA_EXPT_MAPG_SEQ     = X.RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("AND     TRF.RFA_EXPT_VER_SEQ      = TO_NUMBER(X.VER_SEQ)" ).append("\n"); 
		query.append("ORDER BY HDR.RFA_NO, TRF.PROP_NO, X.VER_SEQ, X.RQST_SEQ, X.CVRG_SEQ" ).append("\n"); 

	}
}