/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking Customer 저장
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL(){
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOAddMtyBkgCustCSQL").append("\n"); 
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
		query.append("insert into bkg_customer" ).append("\n"); 
		query.append("(bkg_no, bkg_cust_tp_cd, cust_cnt_cd, cust_seq, cust_nm, cust_addr, addr_prn_flg, cre_usr_id, cre_dt, upd_usr_id, upd_dt)" ).append("\n"); 
		query.append("select @[bkg_no], 'S', 'KR', '002073', 'SM LINE CORPORATION', 'SM LINE CORPORATION, 25 GUKJEGEUMYUNG-RO 2-GIL, YEONGDEUNGPO-GU, SEOUL, KOREA', 'N', @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE from dual" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no], 'C', 'KR', '002073', 'SM LINE CORPORATION', 'SM LINE CORPORATION, 25 GUKJEGEUMYUNG-RO 2-GIL, YEONGDEUNGPO-GU, SEOUL, KOREA', 'N', @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE from dual" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select @[bkg_no], 'N', 'KR', '002073', 'SM LINE CORPORATION', 'SM LINE CORPORATION, 25 GUKJEGEUMYUNG-RO 2-GIL, YEONGDEUNGPO-GU, SEOUL, KOREA', 'N', @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE from dual" ).append("\n"); 

	}
}