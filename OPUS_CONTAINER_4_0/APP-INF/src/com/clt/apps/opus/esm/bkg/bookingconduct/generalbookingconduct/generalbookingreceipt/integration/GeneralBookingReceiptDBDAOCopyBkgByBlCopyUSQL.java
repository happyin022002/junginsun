/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCopyBkgByBlCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.06
*@LastModifier : 전성진
*@LastVersion : 1.0
* 2010.01.06 전성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung Jin Jeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOCopyBkgByBlCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyBkgByBlCopy
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCopyBkgByBlCopyUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOCopyBkgByBlCopyUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BOOKING" ).append("\n"); 
		query.append("SET (" ).append("\n"); 
		query.append("CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(", KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append(", SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append(", AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append(", AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append(") = (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CUST_TO_ORD_FLG" ).append("\n"); 
		query.append(", KR_CSTMS_CUST_TP_CD" ).append("\n"); 
		query.append(", SAM_CNEE_NTFY_FLG" ).append("\n"); 
		query.append(", AGMT_ACT_CNT_CD" ).append("\n"); 
		query.append(", AGMT_ACT_CUST_SEQ" ).append("\n"); 
		query.append("FROM BKG_BOOKING" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[copy_bkg_no]" ).append("\n"); 

	}
}