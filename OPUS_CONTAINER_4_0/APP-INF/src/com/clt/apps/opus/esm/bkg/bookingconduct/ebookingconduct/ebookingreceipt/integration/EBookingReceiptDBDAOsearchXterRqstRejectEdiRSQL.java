/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstRejectEdi
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ediHeader",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstRejectEdiRSQL").append("\n"); 
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
		query.append("SELECT	'IB_BKG_NO:'      ||mst.bkg_no				                 ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_BKG_NO_SPLIT:'||substr(mst.bkg_no, 11, 2)                ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_MSG_FLAG:'    ||mst.doc_tp_cd                            ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_CUST_MSG_NO:' ||MST.XTER_RQST_NO                         ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_APK_MSG_NO:'  ||SUBSTR(@[ediHeader],-15)          		 ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_C_DATE:'      ||TO_CHAR(mst.RQST_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("		'IB_R_DATE:'      ||TO_CHAR(mst.UPLD_DT,'YYYYMMDDHH24MI')    ||CHR(10)||" ).append("\n"); 
		query.append("		'RESPONSE:'       ||REPLACE(NVL(mst.RJCT_RSN_RMK,' '),CHR(10), ' ')||CHR(10)||" ).append("\n"); 
		query.append("        'IB_REQ_CD:'      ||MST.XTER_BKG_RQST_STS_CD                 ||CHR(10)||" ).append("\n"); 
		query.append("        'IB_RES_CD:'      ||'Reject'	                             ||CHR(10)||" ).append("\n"); 
		query.append("        'ACK_C_DATE:'     ||TO_CHAR(sysdate,'YYYYMMDDHH24MI')     EDI_BODY" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("       bkg_xter_Rqst_mst mst" ).append("\n"); 
		query.append(" where mst.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 

	}
}