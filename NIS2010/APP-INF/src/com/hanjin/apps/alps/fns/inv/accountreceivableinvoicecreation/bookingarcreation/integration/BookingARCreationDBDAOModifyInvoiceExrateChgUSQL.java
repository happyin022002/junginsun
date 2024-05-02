/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOModifyInvoiceExrateChgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.04.20 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOModifyInvoiceExrateChgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] BookingARCreationDBDAO::checkAccountRateExist ( effDt ) return int
	  * </pre>
	  */
	public BookingARCreationDBDAOModifyInvoiceExrateChgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rev_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOModifyInvoiceExrateChgUSQL").append("\n"); 
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
		query.append("UPDATE INV_AR_CHG" ).append("\n"); 
		query.append("   SET INV_XCH_RT = @[inv_xch_rt]," ).append("\n"); 
		query.append("       INV_XCH_RT_DT = @[inv_xch_rt_dt]," ).append("\n"); 
		query.append("#if (${rev_vvd} != '')" ).append("\n"); 
		query.append("	   REV_COA_VSL_CD = NVL(REV_COA_VSL_CD, DECODE(REV_COA_ACCT_CD, null, '', DECODE(SUBSTR(REV_COA_ACCT_CD,1,1), '4', SUBSTR(@[rev_vvd],1,4), '7', SUBSTR(@[rev_vvd],1,4), DECODE(SUBSTR(REV_COA_ACCT_CD,1,2), '51', SUBSTR(@[rev_vvd],1,4), '0000'))))," ).append("\n"); 
		query.append("	   REV_COA_VOY_NO = NVL(REV_COA_VOY_NO, DECODE(REV_COA_ACCT_CD, null, '', DECODE(SUBSTR(REV_COA_ACCT_CD,1,1), '4', SUBSTR(@[rev_vvd],5,4), '7', SUBSTR(@[rev_vvd],5,4), DECODE(SUBSTR(REV_COA_ACCT_CD,1,2), '51', SUBSTR(@[rev_vvd],5,4), '0000'))))," ).append("\n"); 
		query.append("	   REV_COA_SKD_DIR_CD = NVL(REV_COA_SKD_DIR_CD, DECODE(REV_COA_ACCT_CD, null, '', DECODE(SUBSTR(REV_COA_ACCT_CD,1,1), '4', SUBSTR(@[rev_vvd],9,1), '7', SUBSTR(@[rev_vvd],9,1), DECODE(SUBSTR(REV_COA_ACCT_CD,1,2), '51', SUBSTR(@[rev_vvd],9,1), '0'))))," ).append("\n"); 
		query.append("	   REV_COA_DIR_CD = NVL(REV_COA_DIR_CD, DECODE(REV_COA_ACCT_CD, null, '', DECODE(SUBSTR(REV_COA_ACCT_CD,1,1), '4', SUBSTR(@[rev_vvd],10,1), '7', SUBSTR(@[rev_vvd],10,1), DECODE(SUBSTR(REV_COA_ACCT_CD,1,2), '51', SUBSTR(@[rev_vvd],10,1), '0'))))," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = sysdate" ).append("\n"); 
		query.append(" WHERE AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("   AND AR_IF_SER_NO  = @[ar_if_ser_no]" ).append("\n"); 
		query.append("   AND CHG_SEQ = @[chg_seq]" ).append("\n"); 

	}
}