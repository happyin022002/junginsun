/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOCopyCustByBlCopyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.21 
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

public class GeneralBookingReceiptDBDAOCopyCustByBlCopyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL Copy 화면에서 Customer 정보를 Copy한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOCopyCustByBlCopyUSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOCopyCustByBlCopyUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_CUSTOMER CUST" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", CUST_NM" ).append("\n"); 
		query.append(", CUST_ADDR" ).append("\n"); 
		query.append(", CUST_CTY_NM" ).append("\n"); 
		query.append(", CUST_STE_CD" ).append("\n"); 
		query.append(", CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", CUST_ZIP_ID" ).append("\n"); 
		query.append(", CUST_FAX_NO" ).append("\n"); 
		query.append(", CUST_EML" ).append("\n"); 
		query.append(", CUST_TP_CD" ).append("\n"); 
		query.append(", REF_NO" ).append("\n"); 
		query.append(", ADDR_PRN_FLG" ).append("\n"); 
		query.append(", VAL_NM" ).append("\n"); 
		query.append(", VAL_FAX_NO" ).append("\n"); 
		query.append(", EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", EORI_NO" ).append("\n"); 
		query.append("FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_CUST_TP_CD <> 'B'" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("ON (CUST.BKG_NO = @[copy_bkg_no] AND CUST.BKG_CUST_TP_CD = T.BKG_CUST_TP_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("CUST_CNT_CD       = T.CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ          = T.CUST_SEQ" ).append("\n"); 
		query.append(", CUST_NM           = T.CUST_NM" ).append("\n"); 
		query.append(", CUST_ADDR         = T.CUST_ADDR" ).append("\n"); 
		query.append(", CUST_CTY_NM       = T.CUST_CTY_NM" ).append("\n"); 
		query.append(", CUST_STE_CD       = T.CUST_STE_CD" ).append("\n"); 
		query.append(", CSTMS_DECL_CNT_CD = T.CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", CUST_ZIP_ID       = T.CUST_ZIP_ID" ).append("\n"); 
		query.append(", CUST_FAX_NO       = T.CUST_FAX_NO" ).append("\n"); 
		query.append(", CUST_EML          = T.CUST_EML" ).append("\n"); 
		query.append(", CUST_TP_CD        = T.CUST_TP_CD" ).append("\n"); 
		query.append(", REF_NO            = T.REF_NO" ).append("\n"); 
		query.append(", ADDR_PRN_FLG      = T.ADDR_PRN_FLG" ).append("\n"); 
		query.append(", VAL_NM            = NULL" ).append("\n"); 
		query.append(", VAL_FAX_NO        = NULL" ).append("\n"); 
		query.append(", VAL_CD            = NULL" ).append("\n"); 
		query.append(", VAL_USR_ID        = NULL" ).append("\n"); 
		query.append(", VAL_OFC_CD        = NULL" ).append("\n"); 
		query.append(", VAL_DT            = NULL" ).append("\n"); 
		query.append(", MTCH_FLG          = 'N'" ).append("\n"); 
		query.append(", AN_SND_FLG        = 'N'" ).append("\n"); 
		query.append(", CHG_DP_FLG        = 'N'" ).append("\n"); 
		query.append(", ORG_CUST_CNT_CD   = T.CUST_CNT_CD" ).append("\n"); 
		query.append(", ORG_CUST_SEQ      = T.CUST_SEQ" ).append("\n"); 
		query.append(", IB_CUST_NM        = NULL" ).append("\n"); 
		query.append(", IB_CUST_ADDR      = NULL" ).append("\n"); 
		query.append(", OB_EV_CD          = NULL" ).append("\n"); 
		query.append(", IB_EV_CD          = NULL" ).append("\n"); 
		query.append(", HQ_EV_CD          = NULL" ).append("\n"); 
		query.append(", UPD_USR_ID        = @[usr_id]" ).append("\n"); 
		query.append(", UPD_DT            = SYSDATE" ).append("\n"); 
		query.append(", EUR_CSTMS_ST_NM   = T.EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", EORI_NO			= T.EORI_NO" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", CUST_CNT_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", CUST_NM" ).append("\n"); 
		query.append(", CUST_ADDR" ).append("\n"); 
		query.append(", CUST_CTY_NM" ).append("\n"); 
		query.append(", CUST_STE_CD" ).append("\n"); 
		query.append(", CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", CUST_ZIP_ID" ).append("\n"); 
		query.append(", CUST_FAX_NO" ).append("\n"); 
		query.append(", CUST_EML" ).append("\n"); 
		query.append(", CUST_TP_CD" ).append("\n"); 
		query.append(", REF_NO" ).append("\n"); 
		query.append(", ADDR_PRN_FLG" ).append("\n"); 
		query.append(", VAL_NM" ).append("\n"); 
		query.append(", VAL_FAX_NO" ).append("\n"); 
		query.append(", VAL_CD" ).append("\n"); 
		query.append(", VAL_USR_ID" ).append("\n"); 
		query.append(", VAL_OFC_CD" ).append("\n"); 
		query.append(", VAL_DT" ).append("\n"); 
		query.append(", MTCH_FLG" ).append("\n"); 
		query.append(", AN_SND_FLG" ).append("\n"); 
		query.append(", CHG_DP_FLG" ).append("\n"); 
		query.append(", ORG_CUST_CNT_CD" ).append("\n"); 
		query.append(", ORG_CUST_SEQ" ).append("\n"); 
		query.append(", IB_CUST_NM" ).append("\n"); 
		query.append(", IB_CUST_ADDR" ).append("\n"); 
		query.append(", OB_EV_CD" ).append("\n"); 
		query.append(", IB_EV_CD" ).append("\n"); 
		query.append(", HQ_EV_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", EORI_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[copy_bkg_no]" ).append("\n"); 
		query.append(", T.BKG_CUST_TP_CD" ).append("\n"); 
		query.append(", T.CUST_CNT_CD" ).append("\n"); 
		query.append(", T.CUST_SEQ" ).append("\n"); 
		query.append(", T.CUST_NM" ).append("\n"); 
		query.append(", T.CUST_ADDR" ).append("\n"); 
		query.append(", T.CUST_CTY_NM" ).append("\n"); 
		query.append(", T.CUST_STE_CD" ).append("\n"); 
		query.append(", T.CSTMS_DECL_CNT_CD" ).append("\n"); 
		query.append(", T.CUST_ZIP_ID" ).append("\n"); 
		query.append(", T.CUST_FAX_NO" ).append("\n"); 
		query.append(", T.CUST_EML" ).append("\n"); 
		query.append(", T.CUST_TP_CD" ).append("\n"); 
		query.append(", T.REF_NO" ).append("\n"); 
		query.append(", T.ADDR_PRN_FLG" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", T.CUST_CNT_CD" ).append("\n"); 
		query.append(", T.CUST_SEQ" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", NULL" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", T.EUR_CSTMS_ST_NM" ).append("\n"); 
		query.append(", T.EORI_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}