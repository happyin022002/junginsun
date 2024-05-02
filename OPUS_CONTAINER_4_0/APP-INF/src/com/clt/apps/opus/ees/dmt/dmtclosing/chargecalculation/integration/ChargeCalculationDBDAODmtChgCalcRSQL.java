/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeCalculationDBDAODmtChgCalcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.05.12 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAODmtChgCalcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeCalculationDBDAODmtChgCalcVORSQL.Query
	  * </pre>
	  */
	public ChargeCalculationDBDAODmtChgCalcRSQL(){
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
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAODmtChgCalcRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("B.BKG_NO" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append(",C.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",C.DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",C.CNTR_NO" ).append("\n"); 
		query.append(",C.CNTR_CYC_NO" ).append("\n"); 
		query.append(",C.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",C.OFC_CD" ).append("\n"); 
		query.append(",C.OFC_RHQ_CD" ).append("\n"); 
		query.append(",C.CHG_SEQ" ).append("\n"); 
		query.append(",B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",C.FM_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.TO_MVMT_STS_CD" ).append("\n"); 
		query.append(",C.DMDT_TRF_CD" ).append("\n"); 
		query.append(",C.FT_DYS" ).append("\n"); 
		query.append(",C.FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD') FM_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.TO_MVMT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_CMNC_DT, 'YYYYMMDD') FT_CMNC_DT" ).append("\n"); 
		query.append(",TO_CHAR(C.FT_END_DT, 'YYYYMMDD') FT_END_DT" ).append("\n"); 
		query.append(",C.BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",C.ORG_CHG_AMT" ).append("\n"); 
		query.append(",C.SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",C.AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",C.BIL_AMT" ).append("\n"); 
		query.append(",DECODE(C.CHG_SEQ, 1, 'G', 'B' 	) AS CHG_TYPE" ).append("\n"); 
		query.append(",NVL(B.SOC_FLG, 'N') AS SOC_FLG" ).append("\n"); 
		query.append(",CASE" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD='ID' THEN 'L'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMIF' AND C.TO_MVMT_STS_CD NOT IN ('ID','CS','DR') THEN 'I'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD<>'POL' THEN 'L'" ).append("\n"); 
		query.append("WHEN C.DMDT_TRF_CD='DMOF' AND C.DMDT_CHG_LOC_DIV_CD='POL' THEN 'I'" ).append("\n"); 
		query.append("END AS LI" ).append("\n"); 
		query.append(",(	SELECT NVL(HLG_TP_CD, 'N')      /* 'C'ARRIER, 'M'ERCHANT, 'N'ULL */" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO" ).append("\n"); 
		query.append("WHERE BKG_NO	= B.BKG_NO" ).append("\n"); 
		query.append("AND  IO_BND_CD	= SUBSTR(C.DMDT_TRF_CD, 3, 1)    /* IN/OUT BOUND */" ).append("\n"); 
		query.append("AND  NVL(CXL_FLG, 'N')    = 'N'" ).append("\n"); 
		query.append("AND  CNTR_NO	= C.CNTR_NO" ).append("\n"); 
		query.append("AND	 ROWNUM = 1" ).append("\n"); 
		query.append(") AS CH" ).append("\n"); 
		query.append(",(	SELECT 'Y'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT  BDD.RLSE_STS_CD" ).append("\n"); 
		query.append("FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("BKG_DO_DTL BDD" ).append("\n"); 
		query.append("WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND   BDD.RLSE_STS_CD IN ('R', 'I'))" ).append("\n"); 
		query.append(") AS D_O" ).append("\n"); 
		query.append(",(	SELECT  BDD.EVNT_OFC_CD" ).append("\n"); 
		query.append("FROM    BKG_DO     BDO," ).append("\n"); 
		query.append("BKG_DO_DTL BDD" ).append("\n"); 
		query.append("WHERE BDO.BKG_NO        = BDD.BKG_NO" ).append("\n"); 
		query.append("AND   BDO.BKG_NO        = B.BKG_NO" ).append("\n"); 
		query.append("AND   BDD.RLSE_STS_CD IN ('R', 'I')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(") AS RLSE_OFC" ).append("\n"); 
		query.append(",BR.CLT_OFC_CD" ).append("\n"); 
		query.append(",NVL(C.OFC_TRNS_FLG, 'N') AS OFC_TRNS_FLG" ).append("\n"); 
		query.append(",(	SELECT 'S'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT 1" ).append("\n"); 
		query.append("FROM BKG_ROLL_OVR R" ).append("\n"); 
		query.append("WHERE R.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND R.ROLL_OVR_RSN_CD = 'S' )" ).append("\n"); 
		query.append(") AS ROLL_OVR" ).append("\n"); 
		query.append(",C.DMDT_INV_NO" ).append("\n"); 
		query.append(",TO_CHAR(IDT.CRE_DT, 'YYYYMMDD') AS ISS_DT" ).append("\n"); 
		query.append(",IDT.INV_CURR_CD" ).append("\n"); 
		query.append(",IDT.CNTR_INV_AMT" ).append("\n"); 
		query.append(",IDT.DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",C.WEB_IND_FLG" ).append("\n"); 
		query.append(",DECODE(C.WEB_IND_FLG, 'Y', TO_CHAR(NVL(C.WEB_MTY_DT, C.TO_MVMT_DT), 'YYYY-MM-DD'), TO_CHAR(C.WEB_MTY_DT, 'YYYY-MM-DD')) AS WEB_CRE_DT" ).append("\n"); 
		query.append(",DECODE(C.WEB_IND_FLG, 'Y', TO_CHAR(NVL(C.WEB_MTY_DT, C.TO_MVMT_DT) + 7, 'YYYY-MM-DD'), TO_CHAR(C.WEB_MTY_DT + 7, 'YYYY-MM-DD')) AS WEB_MTY_DT" ).append("\n"); 
		query.append(",C.WEB_NTFY_PIC_NM" ).append("\n"); 
		query.append(",C.DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",C.CXL_BKG_CHG_FLG" ).append("\n"); 
		query.append(",NVL(IDT.CRE_OFC_CD, C.OFC_CD) AS CRE_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#*" ).append("\n"); 
		query.append(",'' NOT_CRE_BAL_FLG" ).append("\n"); 
		query.append(",'' ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",'' AFT_EXPT_OVR_DYS" ).append("\n"); 
		query.append(",'' DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",'' SC_RFA_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_AMT" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_APLY_DT" ).append("\n"); 
		query.append(",'' RFA_EXPT_APRO_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",'' AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' AFT_EXPT_ADJ_SEQ" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append(",'' CORR_RMK" ).append("\n"); 
		query.append(",'' OFC_RHQ_CD" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' CMDT_TRF_SEQ" ).append("\n"); 
		query.append(",'' CMDT_EXPT_APLY_DT" ).append("\n"); 
		query.append(",'' CMDT_OVR_DYS" ).append("\n"); 
		query.append(",'' CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_OFC_CD" ).append("\n"); 
		query.append(",'' DELT_USR_ID" ).append("\n"); 
		query.append(",'' DELT_OFC_CD" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' ACT_CNT_CD" ).append("\n"); 
		query.append(",'' ACT_CUST_SEQ" ).append("\n"); 
		query.append(",'' FM_MVMT_YR" ).append("\n"); 
		query.append(",'' FM_MVMT_SEQ" ).append("\n"); 
		query.append(",'' FM_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",'' TO_MVMT_YR" ).append("\n"); 
		query.append(",'' TO_MVMT_SEQ" ).append("\n"); 
		query.append(",'' TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append(",'' WEB_NTFY_PIC_TELCM_NO" ).append("\n"); 
		query.append(",'' WEB_CRE_USR_ID" ).append("\n"); 
		query.append("*#" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${est_mk} == 'P')" ).append("\n"); 
		query.append("FROM	DMT_CHG_PRE_CALC_BKG_CNTR	B" ).append("\n"); 
		query.append(",DMT_CHG_PRE_CALC           C" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM	DMT_CHG_BKG_CNTR	B" ).append("\n"); 
		query.append(",DMT_CHG_CALC		C" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",BKG_RATE	BR" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT  IM.INV_CURR_CD" ).append("\n"); 
		query.append(",IM.DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",IM.CRE_DT" ).append("\n"); 
		query.append(",IM.CRE_OFC_CD" ).append("\n"); 
		query.append(",ID.CNTR_INV_AMT" ).append("\n"); 
		query.append(",ID.DMDT_INV_NO" ).append("\n"); 
		query.append(",ID.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",ID.CNTR_NO" ).append("\n"); 
		query.append(",ID.CNTR_CYC_NO" ).append("\n"); 
		query.append(",ID.DMDT_TRF_CD" ).append("\n"); 
		query.append(",ID.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",ID.CHG_SEQ" ).append("\n"); 
		query.append("FROM    DMT_INV_MN  IM," ).append("\n"); 
		query.append("DMT_INV_DTL ID" ).append("\n"); 
		query.append("WHERE   IM.BKG_NO			= @[bkg_no]" ).append("\n"); 
		query.append("AND     IM.DMDT_INV_NO		= ID.DMDT_INV_NO" ).append("\n"); 
		query.append("AND     IM.CRE_OFC_CD		= ID.CRE_OFC_CD" ).append("\n"); 
		query.append("AND     IM.DMDT_INV_STS_CD	= 'I'" ).append("\n"); 
		query.append(") IDT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE   B.SYS_AREA_GRP_ID	= C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND B.CNTR_NO           = C.CNTR_NO" ).append("\n"); 
		query.append("AND B.CNTR_CYC_NO       = C.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND B.BKG_NO			= BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND B.BKG_NO        	= @[bkg_no]" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD       = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${est_mk} != 'P')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_STS_CD   IN (" ).append("\n"); 
		query.append("#foreach( $chg_sts_cd in ${chg_sts_cd_list} )" ).append("\n"); 
		query.append("#if($velocityCount < $chg_sts_cd_list.size()) '$chg_sts_cd', #else '$chg_sts_cd' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND NOT (C.DUL_TP_EXPT_FLG  = 'Y' AND SUBSTR(C.DMDT_TRF_CD, 1, 1) = 'D')" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD	<> 'SZP'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.DMDT_INV_NO 			= IDT.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND C.SYS_AREA_GRP_ID 		= IDT.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("AND C.CNTR_NO				= IDT.CNTR_NO(+)" ).append("\n"); 
		query.append("AND C.CNTR_CYC_NO			= IDT.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("AND C.DMDT_TRF_CD			= IDT.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("AND C.DMDT_CHG_LOC_DIV_CD	= IDT.DMDT_CHG_LOC_DIV_CD(+)" ).append("\n"); 
		query.append("AND C.CHG_SEQ				= IDT.CHG_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${rhq_ofc_cd} != 'All')" ).append("\n"); 
		query.append("AND	C.OFC_RHQ_CD			= @[rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY C.DMDT_TRF_CD, C.CNTR_NO, C.CNTR_CYC_NO, TO_CHAR(C.FM_MVMT_DT, 'YYYYMMDD')" ).append("\n"); 

	}
}