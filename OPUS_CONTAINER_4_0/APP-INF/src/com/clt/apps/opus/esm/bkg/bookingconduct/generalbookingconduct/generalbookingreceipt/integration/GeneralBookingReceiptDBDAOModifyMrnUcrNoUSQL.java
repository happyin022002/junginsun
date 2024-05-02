/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyMrnUcrNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.30 
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

public class GeneralBookingReceiptDBDAOModifyMrnUcrNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update bkg_reference (MRN, UCR)
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyMrnUcrNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_ref_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyMrnUcrNoUSQL").append("\n"); 
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
		query.append("	UPDATE BKG_REF_HIS" ).append("\n"); 
		query.append("	    SET CUST_REF_NO_CTNT = @[cust_ref_no_ctnt]" ).append("\n"); 
		query.append("	    ,BKG_REF_TP_CD = @[bkg_ref_tp_cd]" ).append("\n"); 
		query.append("		,CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	    ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	    ,UPD_DT = sysdate" ).append("\n"); 
		query.append("		,REF_NO = @[ref_no]" ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	AND REF_SEQ = @[ref_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	UPDATE BKG_REFERENCE" ).append("\n"); 
		query.append("	    SET CUST_REF_NO_CTNT = @[cust_ref_no_ctnt]" ).append("\n"); 
		query.append("	    ,BKG_REF_TP_CD = @[bkg_ref_tp_cd]" ).append("\n"); 
		query.append("		,CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	    ,UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	    ,UPD_DT = sysdate" ).append("\n"); 
		query.append("		,REF_NO = @[ref_no]" ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND REF_SEQ = @[ref_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}