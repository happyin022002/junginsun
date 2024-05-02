/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOcheckPortalCustomerCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.29 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOcheckPortalCustomerCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * checkPortalCustomerCd
	  * </pre>
	  */
	public EBookingReceiptDBDAOcheckPortalCustomerCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOcheckPortalCustomerCdRSQL").append("\n"); 
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
		query.append("select DECODE(count(1)  , 0, 'N', 'Y') is_exists" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("                (SELECT GRP.ESVC_GRP_CD           GROUP_EDI_ID" ).append("\n"); 
		query.append("                         , GRP.CUST_TRD_PRNR_ID     EDI_RECEIVE_ID" ).append("\n"); 
		query.append("                         , GRP_CUST.CNT_CD   " ).append("\n"); 
		query.append("                         , GRP_CUST.CUST_SEQ" ).append("\n"); 
		query.append("                         , GRP_CUST.BKG_CUST_TP_DESC " ).append("\n"); 
		query.append("                         , GRP_CUST.ULTI_NEW_ASIA_CUST_FLG" ).append("\n"); 
		query.append("                         , GRP_CUST.ULTI_TRNS_CUST_FLG" ).append("\n"); 
		query.append("                   FROM BKG_EDI_GRP_CUST GRP_CUST, BKG_EDI_GRP GRP" ).append("\n"); 
		query.append("                  WHERE GRP.ESVC_GRP_CD         = GRP_CUST.ESVC_GRP_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = GRP_CUST.CO_CD" ).append("\n"); 
		query.append("                    AND GRP.CO_CD               = 'H'" ).append("\n"); 
		query.append("                    AND GRP.ESVC_GRP_DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.CNT_CD         > ' '" ).append("\n"); 
		query.append("                    AND GRP_CUST.CUST_SEQ       > 0" ).append("\n"); 
		query.append("                    AND GRP_CUST.DELT_FLG       = 'N'" ).append("\n"); 
		query.append("                    AND GRP_CUST.BKG_CFM_FLG    = 'Y'" ).append("\n"); 
		query.append("                    ) EDI_BY_CUST               " ).append("\n"); 
		query.append("                , (SELECT 'S' RCV_TP, '1SH' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'C' RCV_TP, '2CN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'N' RCV_TP, '3NF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'F' RCV_TP, '4FF' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'A' RCV_TP, '5AN' RANK FROM DUAL " ).append("\n"); 
		query.append("                   UNION SELECT 'E' RCV_TP, '6EX' RANK FROM DUAL) TP_RANK" ).append("\n"); 
		query.append("         WHERE @[cust_tp_cd]   = TP_RANK.RCV_TP" ).append("\n"); 
		query.append("           and cnt_cd || lpad(cust_seq, 6, 0) = @[cust_cd]" ).append("\n"); 
		query.append("           #if( ${xter_sndr_id} != '' )" ).append("\n"); 
		query.append("			and edi_receive_id = @[xter_sndr_id]" ).append("\n"); 
		query.append("		   #end" ).append("\n"); 
		query.append("           AND DECODE(BKG_CUST_TP_DESC,'ALL','ALL', @[cust_tp_cd] )" ).append("\n"); 
		query.append("                               IN (SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("                                     FROM TABLE(BKG_SPLIT_FNC(BKG_CUST_TP_DESC,',')))" ).append("\n"); 

	}
}