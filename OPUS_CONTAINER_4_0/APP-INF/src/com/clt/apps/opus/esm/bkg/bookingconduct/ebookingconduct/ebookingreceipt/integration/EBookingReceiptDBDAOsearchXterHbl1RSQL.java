/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHbl1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.08 
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

public class EBookingReceiptDBDAOsearchXterHbl1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterHbl1
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHbl1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterHbl1RSQL").append("\n"); 
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
		query.append("SELECT ROWNUM AS HBL_SEQ" ).append("\n"); 
		query.append(", HBL.XTER_RQST_NO AS XTER_SI_NO" ).append("\n"); 
		query.append(", HBL.XTER_RQST_SEQ AS XTER_SI_SEQ" ).append("\n"); 
		query.append(", HBL.BL_NO_CTNT HBL_NO" ).append("\n"); 
		query.append(", SH.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(", SH.CUST_ADDR SHPR_ADDR" ).append("\n"); 
		query.append(", CN.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(", CN.CUST_ADDR CNEE_ADDR" ).append("\n"); 
		query.append(", NF.CUST_NM NOTI_NM" ).append("\n"); 
		query.append(", NF.CUST_ADDR NOTI_ADDR" ).append("\n"); 
		query.append(", HBL.ESTM_WGT AS HBL_WGT" ).append("\n"); 
		query.append(", HBL.ESTM_WGT_UT_CD AS WGT_UT_CD" ).append("\n"); 
		query.append(", HBL.PCK_QTY" ).append("\n"); 
		query.append(", HBL.PCK_TP_CD" ).append("\n"); 
		query.append(", HBL.MEAS_QTY AS CMDT_MEAS_QTY" ).append("\n"); 
		query.append(", HBL.MEAS_UT_CD AS CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(", REPLACE(REPLACE(REPLACE(HBL.MK_desc,  chr(10), ''),chr(13), ' '),'\"\"') BL_MK_DESC" ).append("\n"); 
		query.append(", REPLACE(REPLACE(REPLACE(HBL.gds_desc, chr(10), ''),chr(13), ' '),'\"\"') BL_GDS_DESC" ).append("\n"); 
		query.append(", @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST HBL, BKG_XTER_CUST SH, BKG_XTER_CUST CN, BKG_XTER_CUST NF" ).append("\n"); 
		query.append("WHERE HBL.XTER_SNDR_ID = SH.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_NO = SH.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_SEQ= SH.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'S'              = SH.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.XTER_SNDR_ID = CN.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_NO = CN.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_SEQ= CN. XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'C'              = CN.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.XTER_SNDR_ID = NF.XTER_SNDR_ID(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_NO = NF.XTER_RQST_NO(+)" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_SEQ= NF.XTER_RQST_SEQ(+)" ).append("\n"); 
		query.append("AND 'N'              = NF.XTER_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND HBL.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_SEQ= @[rqst_seq]" ).append("\n"); 
		query.append("AND HBL.XTER_BL_TP_CD= 'H'" ).append("\n"); 
		query.append("AND HBL.XTER_RQST_VIA_CD = (SELECT XTER_RQST_VIA_CD" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("AND XTER_RQST_SEQ= @[rqst_seq])" ).append("\n"); 
		query.append("ORDER BY ROWNUM" ).append("\n"); 

	}
}