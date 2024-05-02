/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterRqstNoInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchXterRqstNoInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 Booking 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterRqstNoInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterRqstNoInterfaceRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("       BL_NO_CTNT," ).append("\n"); 
		query.append("       XTER_RQST_NO RQST_NO," ).append("\n"); 
		query.append("       XTER_RQST_SEQ RQST_SEQ," ).append("\n"); 
		query.append("       XTER_SNDR_ID SENDER_ID," ).append("\n"); 
		query.append("       SI_NO," ).append("\n"); 
		query.append("       XTER_BL_TP_CD," ).append("\n"); 
		query.append("       DOC_TP_CD," ).append("\n"); 
		query.append("       NVL((SELECT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("            FROM BKG_REFERENCE" ).append("\n"); 
		query.append("            WHERE BKG_NO = M.BKG_NO" ).append("\n"); 
		query.append("            AND BKG_REF_TP_CD = DECODE(M.DOC_TP_CD, 'B', 'EBFF', 'S', 'ESFF')" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("            ),M.SHPR_REF_NO) FF_REF_NO," ).append("\n"); 
		query.append("	  PRE_SEQ_DELT_FLG," ).append("\n"); 
		query.append("	  CUST_ID," ).append("\n"); 
		query.append("	  POR_CD," ).append("\n"); 
		query.append("	  POL_CD," ).append("\n"); 
		query.append("	  POD_CD," ).append("\n"); 
		query.append("	  VSL_CD||SKD_VOY_NO||SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST M" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}