/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAOaddInvArAmtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.10.28 최도순
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

public class BookingARCreationDBDAOaddInvArAmtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingARCreationDBDAOaddInvArAmtCSQL
	  * </pre>
	  */
	public BookingARCreationDBDAOaddInvArAmtCSQL(){
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOaddInvArAmtCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_AR_AMT" ).append("\n"); 
		query.append("(AR_IF_NO, AR_IF_SER_NO, TJ_SRC_NM, CURR_CD, INV_AMT," ).append("\n"); 
		query.append("CRE_DT, CRE_USR_ID, UPD_DT, UPD_USR_ID)" ).append("\n"); 
		query.append("(select AA.ar_if_no, rownum, tj_src_nm, curr_cd, inv_amt," ).append("\n"); 
		query.append("SYSDATE, @[user_id], SYSDATE, @[user_id]" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(select ar_if_no , tj_src_nm , curr_cd, sum(chg_amt) inv_amt" ).append("\n"); 
		query.append("from inv_ar_chg" ).append("\n"); 
		query.append("where ar_if_no = @[ar_if_no]" ).append("\n"); 
		query.append("group by ar_if_no , tj_src_nm , curr_cd ) AA)" ).append("\n"); 

	}
}