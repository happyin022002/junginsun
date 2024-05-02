/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.23 
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

public class ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG No. 나 B/L No. 에 해당되는 데이터를 조회하기 위한 쿼리
	  * </pre>
	  */
	public ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration").append("\n"); 
		query.append("FileName : ChargeAmountDiscountMgtDBDAOSearchBookingDataRSQL").append("\n"); 
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
		query.append("SELECT	TVVD" ).append("\n"); 
		query.append(", 	POR_CD" ).append("\n"); 
		query.append(", 	POL_CD" ).append("\n"); 
		query.append(", 	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(", 	RD" ).append("\n"); 
		query.append(",   DCGO_FLG" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(", 	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(", 	RD_CGO_FLG" ).append("\n"); 
		query.append(", 	SOC_FLG" ).append("\n"); 
		query.append(", 	CMDT_CD" ).append("\n"); 
		query.append(",	CMDT_NM" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	DECODE(NVL(RP_CUST_CD, ''), '', SP_CUST_CD, RP_CUST_CD) CUST_CD" ).append("\n"); 
		query.append(",	DECODE(NVL(RP_CUST_CD, ''), '', SP_CUST_NM, RP_CUST_NM) CUST_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("SELECT  ROWNUM IDX" ).append("\n"); 
		query.append(",	BOOKING.VSL_CD || BOOKING.SKD_VOY_NO || BOOKING.SKD_DIR_CD TVVD" ).append("\n"); 
		query.append(",   BOOKING.POR_CD" ).append("\n"); 
		query.append(",   BOOKING.POL_CD" ).append("\n"); 
		query.append(",   BOOKING.POD_CD" ).append("\n"); 
		query.append(",   BOOKING.DEL_CD" ).append("\n"); 
		query.append(",   BOOKING.RCV_TERM_CD || '/' || BOOKING.DE_TERM_CD RD" ).append("\n"); 
		query.append(",   DECODE(BOOKING.DCGO_FLG, 'N', '', BOOKING.DCGO_FLG) DCGO_FLG" ).append("\n"); 
		query.append(",   DECODE(BOOKING.RC_FLG, 'N', '', BOOKING.RC_FLG) RC_FLG" ).append("\n"); 
		query.append(",   DECODE(BOOKING.AWK_CGO_FLG, 'N', '', BOOKING.AWK_CGO_FLG) AWK_CGO_FLG" ).append("\n"); 
		query.append(",   DECODE(BOOKING.BB_CGO_FLG, 'N', '', BOOKING.BB_CGO_FLG) BB_CGO_FLG" ).append("\n"); 
		query.append(", 	DECODE(BOOKING.RD_CGO_FLG, 'N', '', BOOKING.RD_CGO_FLG) RD_CGO_FLG" ).append("\n"); 
		query.append(", 	DECODE(BOOKING.SOC_FLG, 'N', '', BOOKING.SOC_FLG) SOC_FLG" ).append("\n"); 
		query.append(",	BOOKING.BKG_NO" ).append("\n"); 
		query.append(",	BOOKING.BL_NO" ).append("\n"); 
		query.append(",	BOOKING.SC_NO" ).append("\n"); 
		query.append(",	BOOKING.RFA_NO" ).append("\n"); 
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
		query.append(", 	BOOKING.CMDT_CD" ).append("\n"); 
		query.append(",	CMDT.CMDT_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM	BKG_BOOKING BOOKING" ).append("\n"); 
		query.append(",	MDM_COMMODITY CMDT" ).append("\n"); 
		query.append(",   PRI_RP_HDR RP_HDR" ).append("\n"); 
		query.append(",   PRI_RP_MN RP_MN" ).append("\n"); 
		query.append(",   PRI_SP_HDR SP_HDR" ).append("\n"); 
		query.append(",   PRI_SP_CTRT_PTY SP_PTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if(${bkg_no} != '')" ).append("\n"); 
		query.append("BOOKING.BKG_NO 	= @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("BOOKING.BKG_NO 	= (SELECT BKG_NO FROM BKG_BOOKING WHERE BL_NO = @[bl_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BOOKING.CMDT_CD = CMDT.CMDT_CD(+)" ).append("\n"); 
		query.append("AND BOOKING.RFA_NO 	= RP_HDR.RFA_NO(+)" ).append("\n"); 
		query.append("AND RP_HDR.PROP_NO 	= RP_MN.PROP_NO(+)" ).append("\n"); 
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
		query.append("AND BOOKING.SC_NO 	= SP_HDR.SC_NO(+)" ).append("\n"); 
		query.append("AND SP_HDR.PROP_NO 	= SP_PTY.PROP_NO(+)" ).append("\n"); 
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
		query.append(")" ).append("\n"); 
		query.append("WHERE IDX = 1" ).append("\n"); 

	}
}