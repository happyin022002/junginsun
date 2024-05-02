/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgCustEtcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.11 
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

public class EBookingReceiptDBDAOsearchXterBkgCustEtcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBooking Cust Tab에 BKG_CUSTOMER 테이블 제외한 나머지 값들
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgCustEtcRSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgCustEtcRSQL").append("\n"); 
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
		query.append("select bk.bkg_no" ).append("\n"); 
		query.append(", bk.bl_no" ).append("\n"); 
		query.append(", bk.bl_tp_cd" ).append("\n"); 
		query.append(", bk.bl_no_tp" ).append("\n"); 
		query.append(", bk.agmt_act_cnt_cd" ).append("\n"); 
		query.append(", DECODE(bk.agmt_act_cust_seq,0,'',bk.agmt_act_cust_seq) agmt_act_cust_seq" ).append("\n"); 
		query.append(", bk.kr_cstms_Cust_tp_cd kr_cstms_cust_tp_cd" ).append("\n"); 
		query.append("from bkg_booking bk" ).append("\n"); 
		query.append("where bk.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}