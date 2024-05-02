/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAORemoveMrnUcrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAORemoveMrnUcrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MRN , UCR NO 삭제
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAORemoveMrnUcrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAORemoveMrnUcrDSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	DELETE FROM BKG_REF_HIS" ).append("\n"); 
		query.append("	WHERE BKG_NO 	= @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO		= 'TMP0000001'" ).append("\n"); 
		query.append("	#if (${ref_seq} != '')" ).append("\n"); 
		query.append("	AND REF_SEQ = @[ref_seq]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND CUST_REF_NO_CTNT IS NULL	-- 불필요한 데이터 삭제 조건" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	DELETE FROM BKG_REFERENCE" ).append("\n"); 
		query.append("	WHERE BKG_NO 	= @[bkg_no]" ).append("\n"); 
		query.append("	#if (${ref_seq} != '')" ).append("\n"); 
		query.append("	AND REF_SEQ = @[ref_seq]" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND CUST_REF_NO_CTNT IS NULL	-- 불필요한 데이터 삭제 조건" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}