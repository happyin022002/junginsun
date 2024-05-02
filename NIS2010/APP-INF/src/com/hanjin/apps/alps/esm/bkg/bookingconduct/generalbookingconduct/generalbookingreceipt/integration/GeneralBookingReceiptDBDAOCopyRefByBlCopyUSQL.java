/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCopyRefByBlCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.01 이일민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCopyRefByBlCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyRefByBlCopy
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCopyRefByBlCopyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("copy_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCopyRefByBlCopyUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_REFERENCE REF" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", REF_SEQ" ).append("\n"); 
		query.append(", BKG_REF_TP_CD" ).append("\n"); 
		query.append(", CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_MF_SEQ" ).append("\n"); 
		query.append(", CPY_DESC_FLG" ).append("\n"); 
		query.append(", NVL((SELECT MAX(REF_SEQ)" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_NO=@[copy_bkg_no]),0)+ROWNUM AS MAX_REF_SEQ" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_REF_TP_CD IN ('FMCN','FFNO')" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("ON (REF.BKG_NO = @[copy_bkg_no] AND REF.BKG_REF_TP_CD = T.BKG_REF_TP_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("CUST_REF_NO_CTNT  = T.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", CNTR_NO           = T.CNTR_NO" ).append("\n"); 
		query.append(", CNTR_MF_SEQ       = T.CNTR_MF_SEQ" ).append("\n"); 
		query.append(", CPY_DESC_FLG      = T.CPY_DESC_FLG" ).append("\n"); 
		query.append(", UPD_USR_ID        = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", REF_SEQ" ).append("\n"); 
		query.append(", BKG_REF_TP_CD" ).append("\n"); 
		query.append(", CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", CNTR_MF_SEQ" ).append("\n"); 
		query.append(", CPY_DESC_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[copy_bkg_no]" ).append("\n"); 
		query.append(", T.MAX_REF_SEQ" ).append("\n"); 
		query.append(", T.BKG_REF_TP_CD" ).append("\n"); 
		query.append(", T.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append(", T.CNTR_NO" ).append("\n"); 
		query.append(", T.CNTR_MF_SEQ" ).append("\n"); 
		query.append(", T.CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}