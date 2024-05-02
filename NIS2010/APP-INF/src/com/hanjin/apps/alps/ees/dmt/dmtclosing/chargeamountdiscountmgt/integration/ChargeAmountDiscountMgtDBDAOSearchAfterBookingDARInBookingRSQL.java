/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARInBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARInBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAR No. 나 Approve No. 로 Booking 정보 조회시 Charge Booking Container 에서 Booking 정보를 찾지 못했을 경우
	  * Booking 테이블에서 Booking 정보를 찿기 위한 조회쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARInBookingRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchAfterBookingDARInBookingRSQL").append("\n"); 
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
		query.append("    ,   DAR_NO" ).append("\n"); 
		query.append("    ,   APVL_NO" ).append("\n"); 
		query.append("    ,   STS_DESC" ).append("\n"); 
		query.append("    ,   CASE WHEN ROWCOUNT > 1 THEN '' ELSE SC_NO END SC_NO" ).append("\n"); 
		query.append("    ,   CASE WHEN ROWCOUNT > 1 THEN '' ELSE RFA_NO END RFA_NO" ).append("\n"); 
		query.append("    ,   CASE WHEN ROWCOUNT > 1 THEN '' ELSE TAA_NO END TAA_NO" ).append("\n"); 
		query.append("    ,   CASE WHEN ROWCOUNT > 1 THEN ''" ).append("\n"); 
		query.append("             WHEN RFA_NO IS NOT NULL THEN RP_CUST_CD" ).append("\n"); 
		query.append("             WHEN SC_NO IS NOT NULL THEN SP_CUST_CD" ).append("\n"); 
		query.append("             WHEN TAA_NO IS NOT NULL THEN TAA_CUST_CD" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END CUST_CD" ).append("\n"); 
		query.append("    ,   CASE WHEN ROWCOUNT > 1 THEN ''" ).append("\n"); 
		query.append("             WHEN RFA_NO IS NOT NULL THEN RP_CUST_NM" ).append("\n"); 
		query.append("             WHEN SC_NO IS NOT NULL THEN SP_CUST_NM" ).append("\n"); 
		query.append("             WHEN TAA_NO IS NOT NULL THEN TAA_CUST_NM" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("		SELECT	APVL_OFC_CD" ).append("\n"); 
		query.append("			,	DAR_NO" ).append("\n"); 
		query.append("			,	APVL_NO" ).append("\n"); 
		query.append("			,	STS_DESC" ).append("\n"); 
		query.append("			,	SC_NO" ).append("\n"); 
		query.append("			,	RFA_NO" ).append("\n"); 
		query.append("			,	TAA_NO" ).append("\n"); 
		query.append("			,	RP_CUST_CD" ).append("\n"); 
		query.append("			,	RP_CUST_NM" ).append("\n"); 
		query.append("			,	SP_CUST_CD" ).append("\n"); 
		query.append("			,	SP_CUST_NM" ).append("\n"); 
		query.append("			,   TAA_CUST_CD" ).append("\n"); 
		query.append("			,   TAA_CUST_NM" ).append("\n"); 
		query.append("			,	COUNT(*) OVER (PARTITION BY DAR_NO) ROWCOUNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM    " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		        SELECT  DISTINCT ADJ_RQST.APRO_OFC_CD APVL_OFC_CD" ).append("\n"); 
		query.append("		            ,   ADJ_RQST.AFT_EXPT_DAR_NO DAR_NO" ).append("\n"); 
		query.append("		            ,   ADJ_RQST.AFT_BKG_APRO_NO APVL_NO" ).append("\n"); 
		query.append("		            ,   COM_DTL.INTG_CD_VAL_DP_DESC STS_DESC" ).append("\n"); 
		query.append("		            ,   BOOKING.SC_NO" ).append("\n"); 
		query.append("		            ,   BOOKING.RFA_NO" ).append("\n"); 
		query.append("		            ,   BOOKING.TAA_NO" ).append("\n"); 
		query.append("		            ,   RP_MN.CTRT_CUST_CNT_CD || LPAD(RP_MN.CTRT_CUST_SEQ, 6, '0') RP_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = RP_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = RP_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("						) RP_CUST_NM" ).append("\n"); 
		query.append("		            ,   SP_PTY.CUST_CNT_CD || LPAD(SP_PTY.CUST_SEQ, 6, '0') SP_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = SP_PTY.CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = SP_PTY.CUST_SEQ " ).append("\n"); 
		query.append("						) SP_CUST_NM         " ).append("\n"); 
		query.append("		            ,   TAA_MN.CTRT_CUST_CNT_CD || LPAD(TAA_MN.CTRT_CUST_SEQ, 6, '0') TAA_CUST_CD" ).append("\n"); 
		query.append("		            ,   (" ).append("\n"); 
		query.append("							SELECT	CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("							FROM 	MDM_CUSTOMER " ).append("\n"); 
		query.append("							WHERE	CUST_CNT_CD = TAA_MN.CTRT_CUST_CNT_CD " ).append("\n"); 
		query.append("								AND CUST_SEQ = TAA_MN.CTRT_CUST_SEQ" ).append("\n"); 
		query.append("						) TAA_CUST_NM   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				FROM    DMT_AFT_BKG_ADJ_RQST ADJ_RQST" ).append("\n"); 
		query.append("					,   DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append("					,   BKG_BOOKING BOOKING" ).append("\n"); 
		query.append("					,   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append("					,   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append("					,   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append("					,   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("					,   PRI_TAA_HDR TAA_HDR" ).append("\n"); 
		query.append("					,   PRI_TAA_MN TAA_MN" ).append("\n"); 
		query.append("					,   COM_INTG_CD_DTL COM_DTL " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				WHERE   " ).append("\n"); 
		query.append("					#if(${dar_no} != '')" ).append("\n"); 
		query.append("						ADJ_RQST.AFT_EXPT_DAR_NO = @[dar_no]" ).append("\n"); 
		query.append("					#elseif(${apvl_no} != '')" ).append("\n"); 
		query.append("						ADJ_RQST.AFT_BKG_APRO_NO = @[apvl_no]" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					AND ADJ_RQST.AFT_EXPT_DAR_NO = ADJ_RQST_DTL.AFT_EXPT_DAR_NO" ).append("\n"); 
		query.append("					AND ADJ_RQST_DTL.BKG_NO = BOOKING.BKG_NO" ).append("\n"); 
		query.append("					AND BOOKING.RFA_NO = RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("					AND RP_HDR.PROP_NO = RP_MN.PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							RP_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								RP_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_RP_MN XPKPRI_RP_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_RP_MN" ).append("\n"); 
		query.append("									WHERE	PROP_NO = RP_MN.PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					AND BOOKING.SC_NO = SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("					AND SP_HDR.PROP_NO = SP_PTY.PROP_NO(+)" ).append("\n"); 
		query.append("					AND (" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD IS NULL AND SP_PTY.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("							OR " ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								SP_PTY.PRC_CTRT_PTY_TP_CD = 'C' " ).append("\n"); 
		query.append("								AND " ).append("\n"); 
		query.append("								SP_PTY.AMDT_SEQ = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT	/*+ INDEX_DESC(PRI_SP_CTRT_PTY XPKPRI_SP_CTRT_PTY) */AMDT_SEQ " ).append("\n"); 
		query.append("									FROM	PRI_SP_CTRT_PTY " ).append("\n"); 
		query.append("									WHERE 	PROP_NO = SP_PTY.PROP_NO" ).append("\n"); 
		query.append("										AND	PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)				" ).append("\n"); 
		query.append("							)  " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_NO(+) = BOOKING.TAA_NO" ).append("\n"); 
		query.append("					AND TAA_HDR.TAA_PROP_NO = TAA_MN.TAA_PROP_NO(+)" ).append("\n"); 
		query.append("					AND	(" ).append("\n"); 
		query.append("							TAA_MN.AMDT_SEQ IS NULL" ).append("\n"); 
		query.append("							OR" ).append("\n"); 
		query.append("							(" ).append("\n"); 
		query.append("								TAA_MN.AMDT_SEQ =" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT 	/*+ INDEX_DESC(PRI_TAA_MN XFK1PRI_TAA_MN) */AMDT_SEQ" ).append("\n"); 
		query.append("									FROM	PRI_TAA_MN" ).append("\n"); 
		query.append("									WHERE	TAA_PROP_NO = TAA_MN.TAA_PROP_NO" ).append("\n"); 
		query.append("										AND	ROWNUM = 1" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					AND ADJ_RQST.DMDT_EXPT_RQST_STS_CD = COM_DTL.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("					AND COM_DTL.INTG_CD_ID = 'CD02069'" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		WHERE ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}