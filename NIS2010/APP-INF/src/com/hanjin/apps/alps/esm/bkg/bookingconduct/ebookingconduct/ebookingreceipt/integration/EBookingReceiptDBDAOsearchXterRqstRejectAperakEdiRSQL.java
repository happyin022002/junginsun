/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2012.08.01 
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

public class EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hjs_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstRejectAperakEdiRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'IB_CUST_RFF_NO:'||CUST_REF_NO ||CHR(10)||" ).append("\n"); 
		query.append("#if(${sender_id}=='CARGOSMART')" ).append("\n"); 
		query.append("'IB_SI_NO:'||DECODE(SI_NO,'',XTER_RQST_NO,SI_NO) ||CHR(10)||" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'IB_SI_NO:'||SI_NO ||CHR(10)||" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("'IB_EDI_ID:' ||XTER_SNDR_ID ||CHR(10)||" ).append("\n"); 
		query.append("'IB_HJS_ID:' ||@[hjs_id] ||CHR(10)||" ).append("\n"); 
		query.append("'IB_MSG_FLAG:'||DOC_TP_CD ||CHR(10)||" ).append("\n"); 
		query.append("'IB_PRC:' ||'AP' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_ERC:' ||'REJECT' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_FTX:' ||'REJECTED' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_CUST_RFF_NO2:' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_MBL_NO:' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_BKG_NO:' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VSL_NAME:' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VOYAGE_NO:' ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VSL_ETL:' ||CHR(10)" ).append("\n"); 
		query.append("AS EDI_BODY" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 

	}
}