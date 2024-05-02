/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchOpusHbl1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.18 
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

public class EBookingReceiptDBDAOsearchOpusHbl1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOpusHbl1
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchOpusHbl1RSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchOpusHbl1RSQL").append("\n"); 
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
		query.append("SELECT XTER_SI_NO XTER_SI_NO" ).append("\n"); 
		query.append(", XTER_SI_SEQ XTER_SI_SEQ" ).append("\n"); 
		query.append(", HBL.BKG_NO" ).append("\n"); 
		query.append(", HBL.HBL_NO" ).append("\n"); 
		query.append(", SH.CUST_NM SHPR_NM" ).append("\n"); 
		query.append(", SH.CUST_ADDR SHPR_ADDR" ).append("\n"); 
		query.append(", CN.CUST_NM CNEE_NM" ).append("\n"); 
		query.append(", CN.CUST_ADDR CNEE_ADDR" ).append("\n"); 
		query.append(", NF.CUST_NM NOTI_NM" ).append("\n"); 
		query.append(", NF.CUST_ADDR NOTI_ADDR" ).append("\n"); 
		query.append(", HBL.HBL_WGT" ).append("\n"); 
		query.append(", HBL.WGT_UT_CD" ).append("\n"); 
		query.append(", HBL.PCK_QTY" ).append("\n"); 
		query.append(", HBL.PCK_TP_CD" ).append("\n"); 
		query.append(", HBL.CMDT_MEAS_QTY" ).append("\n"); 
		query.append(", HBL.CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(", HBL.BL_MK_DESC" ).append("\n"); 
		query.append(", HBL.BL_GDS_DESC" ).append("\n"); 
		query.append(", HBL.HBL_SEQ HBL_SEQ" ).append("\n"); 
		query.append("FROM BKG_HBL HBL, BKG_HBL_CUST SH, BKG_HBL_CUST CN, BKG_HBL_CUST NF" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("and HBL.BKG_NO       = SH.BKG_NO(+)" ).append("\n"); 
		query.append("and hbl.hbl_seq      = sh.hbl_seq(+)" ).append("\n"); 
		query.append("AND 'S'              = SH.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO       = CN.BKG_NO(+)" ).append("\n"); 
		query.append("and hbl.hbl_seq      = cn.hbl_seq(+)" ).append("\n"); 
		query.append("AND 'C'              = CN.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO       = NF.BKG_NO(+)" ).append("\n"); 
		query.append("and hbl.hbl_seq      = nf.hbl_seq(+)" ).append("\n"); 
		query.append("AND 'N'              = NF.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("AND HBL.BKG_NO       = @[bkg_no]" ).append("\n"); 

	}
}