/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchRollOverNoticeParamRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchRollOverNoticeParamRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Roll Over Notice 발송 여부와 발송을 위한 항목을 조회 한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchRollOverNoticeParamRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchRollOverNoticeParamRSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO " ).append("\n"); 
		query.append("     , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("         WHERE VSL_CD = PRE.PRE_VSL_CD AND SKD_VOY_NO = PRE.PRE_SKD_VOY_NO AND SKD_DIR_CD = PRE.PRE_SKD_DIR_CD AND ROWNUM = 1) PRE_LANE" ).append("\n"); 
		query.append("     , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("         WHERE VSL_CD = PRE.NEW_VSL_CD AND SKD_VOY_NO = PRE.NEW_SKD_VOY_NO AND SKD_DIR_CD = PRE.NEW_SKD_DIR_CD AND ROWNUM = 1) NEW_LANE           " ).append("\n"); 
		query.append("     , PRE.PRE_VSL_CD||PRE.PRE_SKD_VOY_NO||PRE.PRE_SKD_DIR_CD PRE_VVD" ).append("\n"); 
		query.append("     , PRE.NEW_VSL_CD||PRE.NEW_SKD_VOY_NO||PRE.NEW_SKD_DIR_CD NEW_VVD" ).append("\n"); 
		query.append("     , BK.BKG_OFC_CD" ).append("\n"); 
		query.append("     , LTRIM(RTRIM(DECODE(OB_REP.SREP_EML, CTRT_REP.SREP_EML, OB_REP.SREP_EML, OB_REP.SREP_EML||';'||CTRT_REP.SREP_EML),';'),';') SREP_EML" ).append("\n"); 
		query.append("     , NVL(BK.SC_NO, NVL(RFA_NO, TAA_NO))CTRT_NO" ).append("\n"); 
		query.append("     , (SELECT MDM.CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("          FROM BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("             , MDM_CUSTOMER MDM" ).append("\n"); 
		query.append("         WHERE CUST.BKG_NO         = BK.BKG_NO" ).append("\n"); 
		query.append("           AND CUST.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("           AND MDM.CUST_CNT_CD     = CUST.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND MDM.CUST_SEQ        = CUST.CUST_SEQ" ).append("\n"); 
		query.append("           AND MDM.DELT_FLG       <> 'Y'" ).append("\n"); 
		query.append("           AND ROWNUM = 1)CUST_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING  BK" ).append("\n"); 
		query.append("     , BKG_ROLL_OVR NEW" ).append("\n"); 
		query.append("     , BKG_ROLL_OVR PRE" ).append("\n"); 
		query.append("     , MDM_SLS_REP  OB_REP" ).append("\n"); 
		query.append("     , MDM_SLS_REP  CTRT_REP" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NEW.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND PRE.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("   AND NEW.ROLL_OVR_SEQ = (SELECT MAX(ROLL_OVR_SEQ) " ).append("\n"); 
		query.append("                             FROM BKG_ROLL_OVR " ).append("\n"); 
		query.append("                            WHERE BKG_NO = BK.BKG_NO)    " ).append("\n"); 
		query.append("   AND PRE.ROLL_OVR_SEQ = (SELECT MAX(ROLL_OVR_SEQ) " ).append("\n"); 
		query.append("                             FROM BKG_ROLL_OVR " ).append("\n"); 
		query.append("                            WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                              AND ROLL_OVR_SEQ <> NEW.ROLL_OVR_SEQ)     " ).append("\n"); 
		query.append("   AND OB_REP.SREP_CD = OB_SREP_CD      " ).append("\n"); 
		query.append("   AND CTRT_REP.SREP_CD = CTRT_SREP_CD                     " ).append("\n"); 
		query.append("   AND GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,BK.POL_CD) BETWEEN PRE.PRE_ETD_DT-5 AND PRE.PRE_ETD_DT" ).append("\n"); 
		query.append("   AND PRE.PRE_ETD_DT < PRE.NEW_ETD_DT" ).append("\n"); 
		query.append("   AND BK.NON_RT_STS_CD <> 'R'" ).append("\n"); 

	}
}