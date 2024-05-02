/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.29 
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

public class EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchAlpsDgRiderListRSQL").append("\n"); 
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
		query.append("BKG_NO" ).append("\n"); 
		query.append(",RIDR_TP_CD" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_SIZE" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",(SELECT CNTR_NO ||' / '|| CNTR_CGO_SEQ FROM BKG_DG_CGO WHERE BKG_NO=MAIN_TABLE.BKG_NO and DCGO_SEQ = MAIN_TABLE.CARGO_SEQ)  AS CARGO_CONTAIN" ).append("\n"); 
		query.append(",CARGO_CNT" ).append("\n"); 
		query.append(",BKG_JOIN_FNC(CURSOR(SELECT DCGO_SEQ FROM BKG_IMG_STO WHERE  BKG_NO=MAIN_TABLE.BKG_NO AND FILE_SAV_ID=MAIN_TABLE.FILE_SAV_ID AND DCGO_SEQ > 0)) AS DCGO_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(IMG.BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append(",MIN(IMG.RIDR_TP_CD) AS RIDR_TP_CD" ).append("\n"); 
		query.append(",MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append(",MIN(UPLD.FILE_SZ_CAPA) AS FILE_SIZE" ).append("\n"); 
		query.append(",MIN(IMG.DCGO_SEQ) AS CARGO_SEQ" ).append("\n"); 
		query.append(",IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append(",COUNT(IMG.FILE_SAV_ID) AS CARGO_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IMG.RIDR_TP_CD= 'D'" ).append("\n"); 
		query.append("GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 
		query.append("ORDER BY DCGO_SEQ" ).append("\n"); 

	}
}