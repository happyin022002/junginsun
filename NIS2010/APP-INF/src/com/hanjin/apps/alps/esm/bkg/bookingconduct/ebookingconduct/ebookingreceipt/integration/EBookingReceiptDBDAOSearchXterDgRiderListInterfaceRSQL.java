/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchXterDgRiderListInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.23 
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

public class EBookingReceiptDBDAOSearchXterDgRiderListInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * external request 처리를 위해 external rqst의 danger cgo Rider 정보를 조회한다.
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchXterDgRiderListInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchXterDgRiderListInterfaceRSQL").append("\n"); 
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
		query.append("SELECT RIDR_TP_CD," ).append("\n"); 
		query.append("       FILE_NM," ).append("\n"); 
		query.append("       FILE_SAV_ID," ).append("\n"); 
		query.append("       BKG_JOIN_FNC(CURSOR(SELECT DCGO_SEQ " ).append("\n"); 
		query.append("                           FROM BKG_XTER_IMG_STO " ).append("\n"); 
		query.append("                           WHERE  XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("                           AND XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("                           AND XTER_RQST_NO=MAIN_TABLE.XTER_RQST_NO " ).append("\n"); 
		query.append("                           AND FILE_SAV_ID=MAIN_TABLE.FILE_SAV_ID " ).append("\n"); 
		query.append("                           AND DCGO_SEQ > 0)) AS DCGO_SEQ," ).append("\n"); 
		query.append("       'I' AS IBFLAG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        MIN(IMG.XTER_RQST_NO) AS XTER_RQST_NO" ).append("\n"); 
		query.append("        ,MIN(IMG.RIDR_TP_CD) AS RIDR_TP_CD" ).append("\n"); 
		query.append("        ,MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append("        ,MIN(IMG.DCGO_SEQ) AS CARGO_SEQ" ).append("\n"); 
		query.append("	    ,MIN(IMG_SEQ)  IMG_SEQ" ).append("\n"); 
		query.append("        ,IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("        BKG_XTER_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("    WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("      AND IMG.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("      AND IMG.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("      AND IMG.RIDR_TP_CD= 'D'" ).append("\n"); 
		query.append("      AND IMG.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("    GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 
		query.append("ORDER BY IMG_SEQ" ).append("\n"); 

	}
}