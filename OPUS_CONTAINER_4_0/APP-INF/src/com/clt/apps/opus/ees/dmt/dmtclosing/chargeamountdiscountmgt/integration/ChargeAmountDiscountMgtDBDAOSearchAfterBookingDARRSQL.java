/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR No. 나 APVL No. 로 조회컬럼의 데이터를 조회하는 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apvl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARRSQL").append("\n"); 
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
		query.append("SELECT  APVL_OFC_CD" ).append("\n"); 
		query.append(",   DAR_NO" ).append("\n"); 
		query.append(",   APVL_NO" ).append("\n"); 
		query.append(",   STS_DESC" ).append("\n"); 
		query.append(",   CASE WHEN ROWCOUNT > 1 THEN '' ELSE SC_NO END SC_NO" ).append("\n"); 
		query.append(",   CASE WHEN ROWCOUNT > 1 THEN '' ELSE RFA_NO END RFA_NO" ).append("\n"); 
		query.append(",   CASE WHEN ROWCOUNT > 1 THEN ''" ).append("\n"); 
		query.append("WHEN RFA_NO IS NOT NULL THEN RP_CUST_CD" ).append("\n"); 
		query.append("WHEN SC_NO IS NOT NULL THEN SP_CUST_CD" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CUST_CD" ).append("\n"); 
		query.append(",   CASE WHEN ROWCOUNT > 1 THEN ''" ).append("\n"); 
		query.append("WHEN RFA_NO IS NOT NULL THEN RP_CUST_NM" ).append("\n"); 
		query.append("WHEN SC_NO IS NOT NULL THEN SP_CUST_NM" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	APVL_OFC_CD" ).append("\n"); 
		query.append(",	DAR_NO" ).append("\n"); 
		query.append(",	APVL_NO" ).append("\n"); 
		query.append(",	STS_DESC" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	RP_CUST_CD" ).append("\n"); 
		query.append(",	RP_CUST_NM" ).append("\n"); 
		query.append(",	SP_CUST_CD" ).append("\n"); 
		query.append(",	SP_CUST_NM" ).append("\n"); 
		query.append(",	COUNT(*) OVER (PARTITION BY DAR_NO) ROWCOUNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  DISTINCT ADJ_RQST.APRO_OFC_CD APVL_OFC_CD" ).append("\n"); 
		query.append(",   ADJ_RQST.AFT_EXPT_DAR_NO DAR_NO" ).append("\n"); 
		query.append(",   ADJ_RQST.AFT_BKG_APRO_NO APVL_NO" ).append("\n"); 
		query.append(",   COM_DTL.INTG_CD_VAL_DP_DESC STS_DESC" ).append("\n"); 
		query.append(",   CHG_CNTR.SC_NO" ).append("\n"); 
		query.append(",   CHG_CNTR.RFA_NO" ).append("\n"); 
		query.append(",   RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') RP_CUST_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT	CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM 	MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD = RP_MN.CTRT_CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = RP_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append(") RP_CUST_NM" ).append("\n"); 
		query.append(",   SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') SP_CUST_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("SELECT	CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM	MDM_CUSTOMER" ).append("\n"); 
		query.append("WHERE	CUST_CNT_CD = SP_PTY.CUST_CNT_CD" ).append("\n"); 
		query.append("AND CUST_SEQ = SP_PTY.CUST_SEQ" ).append("\n"); 
		query.append(") SP_CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append(",   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append(",   DMT_CHG_BKG_CNTR CHG_CNTR" ).append("\n"); 
		query.append(",   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append(",   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append(",   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append(",   COM_INTG_CD_DTL COM_DTL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${dar_no} != '')" ).append("\n"); 
		query.append("ADJ_RQST.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("ADJ_RQST.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.BKG_NO = CHG_CNTR.BKG_NO" ).append("\n"); 
		query.append("AND CHG_CNTR.SYS_AREA_GRP_ID =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("FROM    COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("WHERE   CNT_CD =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POD_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'M' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'I'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.DEL_CD, 0, 2)" ).append("\n"); 
		query.append("WHEN SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 2, 1) = 'T' AND SUBSTR(ADJ_RQST_DTL.DMDT_TRF_CD, 3, 1) = 'O'" ).append("\n"); 
		query.append("THEN SUBSTR(CHG_CNTR.POR_CD, 0, 2)" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CNTR.RFA_NO = RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO = RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("AND	(" ).append("\n"); 
		query.append("RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_RP_MN" ).append("\n"); 
		query.append("WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CHG_CNTR.SC_NO = SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("AND SP_HDR.PROP_NO = SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SP_PTY.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("SP_PTY.AMDT_SEQ =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ" ).append("\n"); 
		query.append("FROM	PRI_SP_CTRT_PTY" ).append("\n"); 
		query.append("WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND	ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND ADJ_RQST.DMDT_EXPT_RQST_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND COM_DTL.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}