/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAORefDtlByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.12.10 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAORefDtlByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAORefDtlByCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("src_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAORefDtlByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REF_DTL" ).append("\n"); 
		query.append("            (BKG_NO" ).append("\n"); 
		query.append(",            REF_SEQ" ).append("\n"); 
		query.append(",            CUST_REF_TP_CD" ).append("\n"); 
		query.append(",            DE_NO" ).append("\n"); 
		query.append(",            PRT_NO" ).append("\n"); 
		query.append(",            CPY_DESC_FLG" ).append("\n"); 
		query.append(",            CNTR_NO" ).append("\n"); 
		query.append(",            ITM_NO" ).append("\n"); 
		query.append(",            ITM_DESC" ).append("\n"); 
		query.append(",            PCK_QTY" ).append("\n"); 
		query.append(",            PCK_TP_CD" ).append("\n"); 
		query.append(",            CNTR_WGT" ).append("\n"); 
		query.append(",            WGT_UT_CD" ).append("\n"); 
		query.append(",            MEAS_QTY" ).append("\n"); 
		query.append(",            MEAS_UT_CD" ).append("\n"); 
		query.append(",            PO_NO" ).append("\n"); 
		query.append(",            CRE_USR_ID" ).append("\n"); 
		query.append(",            CRE_DT" ).append("\n"); 
		query.append(",            UPD_USR_ID" ).append("\n"); 
		query.append(",            UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    SELECT @[tgt_bkg_no]" ).append("\n"); 
		query.append(",          ((SELECT NVL(MAX(REF_SEQ), 0)" ).append("\n"); 
		query.append("             FROM   BKG_REF_DTL" ).append("\n"); 
		query.append("             WHERE  BKG_NO = @[tgt_bkg_no]) + ROW_NUMBER() OVER(PARTITION BY BKG_NO ORDER BY REF_SEQ))" ).append("\n"); 
		query.append(",          CUST_REF_TP_CD" ).append("\n"); 
		query.append(",          DE_NO" ).append("\n"); 
		query.append(",          PRT_NO" ).append("\n"); 
		query.append(",          CPY_DESC_FLG" ).append("\n"); 
		query.append(",          CNTR_NO" ).append("\n"); 
		query.append(",          ITM_NO" ).append("\n"); 
		query.append(",          ITM_DESC" ).append("\n"); 
		query.append(",          PCK_QTY" ).append("\n"); 
		query.append(",          PCK_TP_CD" ).append("\n"); 
		query.append(",          CNTR_WGT" ).append("\n"); 
		query.append(",          WGT_UT_CD" ).append("\n"); 
		query.append(",          MEAS_QTY" ).append("\n"); 
		query.append(",          MEAS_UT_CD" ).append("\n"); 
		query.append(",          PO_NO" ).append("\n"); 
		query.append(",          @[cre_usr_id]" ).append("\n"); 
		query.append(",          sysdate" ).append("\n"); 
		query.append(",          @[cre_usr_id]" ).append("\n"); 
		query.append(",          sysdate" ).append("\n"); 
		query.append("    FROM   BKG_REF_DTL" ).append("\n"); 
		query.append("    WHERE  BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("    AND    CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}