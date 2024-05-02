/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyKrCstmsCustTpCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.27 
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

public class GeneralBookingReceiptDBDAOModifyKrCstmsCustTpCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CHM-201429314] - 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가
	  * PRI_SP_CTRT_CUST_TP 에 따라 KR_CSTMS_CUST_TP_CD 값을 업데이트 함. 
	  * 미주발 화물의 경우 S/C에 등록된 Customer Type이 기존 MDM 등록 데이터보다 더 정확한 H/BL 존재 여부를 제공 할 수 있음.
	  * PRI_SP_CTRT_CUST_TP  -> KR_CSTMS_CUST_TP_CD
	  *   A -> Simple
	  *   I -> Simple
	  *   N -> Console
	  *   O -> Simple
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyKrCstmsCustTpCdUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOModifyKrCstmsCustTpCdUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS BKK  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING BKK  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET KR_CSTMS_CUST_TP_CD = ( SELECT DECODE (NVL(( SELECT PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                                                      FROM BKG_BKG_HIS         BK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                                                      FROM BKG_BOOKING         BK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                         , PRI_SP_HDR          HDR" ).append("\n"); 
		query.append("                                                         , PRI_SP_CTRT_CUST_TP CUST_TP" ).append("\n"); 
		query.append("                                                     WHERE 1=1" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                                                       AND BK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                                       AND BK.BKG_NO   = BKK.BKG_NO" ).append("\n"); 
		query.append("                                                       AND HDR.SC_NO   = BK.SC_NO  " ).append("\n"); 
		query.append("                                                       AND HDR.PROP_NO = CUST_TP.PROP_NO " ).append("\n"); 
		query.append("                                                       AND CUST_TP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("                                                       AND CUST_TP.AMDT_SEQ = (SELECT MAX(AMDT_SEQ) " ).append("\n"); 
		query.append("                                                                                 FROM PRI_SP_CTRT_CUST_TP " ).append("\n"); 
		query.append("                                                                                WHERE PROP_NO = HDR.PROP_NO)" ).append("\n"); 
		query.append("                                                       AND ROWNUM = 1)" ).append("\n"); 
		query.append("                                                    ,'') " ).append("\n"); 
		query.append("                                                 , 'A', 'S', 'I', 'S', 'O', 'S', 'N', 'C', '', BKK.KR_CSTMS_CUST_TP_CD) FROM DUAL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKK.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("   AND BKK.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mode} != 'CRE')" ).append("\n"); 
		query.append("   AND BKK.KR_CSTMS_CUST_TP_CD IS NULL -- 기존 KR_CSTMS_CUST_TP_CD 값 없을 때 만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND (    BKK.POL_CD LIKE 'US%' " ).append("\n"); 
		query.append("         OR BKK.POL_CD LIKE 'CA%' )    -- 미주발 화물" ).append("\n"); 
		query.append("   AND BKK.SC_NO IS NOT NULL" ).append("\n"); 
		query.append("   AND BKK.SC_NO NOT LIKE 'DUM%'" ).append("\n"); 

	}
}