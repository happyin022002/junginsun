/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchAlertCustRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.08.07 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimByungKyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchAlertCustRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Black List Customer 확인
	  * </pre>
	  */
	public BookingUtilDBDAOSearchAlertCustRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchAlertCustRSQL").append("\n"); 
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
		query.append("select	bkg_alt_msg" ).append("\n"); 
		query.append("from	mdm_customer" ).append("\n"); 
		query.append("where	cust_cnt_cd = @[cust_cnt_cd]" ).append("\n"); 
		query.append("and		cust_seq = @[cust_seq]" ).append("\n"); 

	}
}