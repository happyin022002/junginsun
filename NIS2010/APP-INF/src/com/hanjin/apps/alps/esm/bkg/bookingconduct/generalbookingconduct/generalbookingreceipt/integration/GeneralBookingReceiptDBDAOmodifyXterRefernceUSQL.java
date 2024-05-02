/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifyXterRefernceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.07
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.03.07 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifyXterRefernceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyXterRefernce
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifyXterRefernceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cust_ref_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifyXterRefernceUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_REFERENCE BKG_REF " ).append("\n"); 
		query.append("USING ( SELECT @[bkg_no] BKG_NO, @[bkg_ref_tp_cd] BKG_REF_TP_CD" ).append("\n"); 
		query.append("        FROM dual ) REF " ).append("\n"); 
		query.append("ON ( BKG_REF.BKG_NO = REF.BKG_NO" ).append("\n"); 
		query.append("     AND BKG_REF.BKG_REF_TP_CD = REF.BKG_REF_TP_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET CUST_REF_NO_CTNT = @[cust_ref_no_ctnt] ," ).append("\n"); 
		query.append("      UPD_USR_ID = @[usr_id] ," ).append("\n"); 
		query.append("      UPD_DT = sysdate" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND BKG_REF_TP_CD = @[bkg_ref_tp_cd]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT ( BKG_NO ," ).append("\n"); 
		query.append("          REF_SEQ ," ).append("\n"); 
		query.append("          BKG_REF_TP_CD ," ).append("\n"); 
		query.append("          CUST_REF_NO_CTNT ," ).append("\n"); 
		query.append("          CRE_USR_ID ," ).append("\n"); 
		query.append("          CRE_DT ," ).append("\n"); 
		query.append("          UPD_USR_ID ," ).append("\n"); 
		query.append("          UPD_DT)" ).append("\n"); 
		query.append("    VALUES ( @[bkg_no] ," ).append("\n"); 
		query.append("        (SELECT NVL(MAX(REF_SEQ), 0) + 1" ).append("\n"); 
		query.append("        FROM BKG_REFERENCE" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("          @[bkg_ref_tp_cd] ," ).append("\n"); 
		query.append("          @[cust_ref_no_ctnt] ," ).append("\n"); 
		query.append("          @[usr_id] ," ).append("\n"); 
		query.append("          sysdate ," ).append("\n"); 
		query.append("          @[usr_id] ," ).append("\n"); 
		query.append("          sysdate )" ).append("\n"); 

	}
}