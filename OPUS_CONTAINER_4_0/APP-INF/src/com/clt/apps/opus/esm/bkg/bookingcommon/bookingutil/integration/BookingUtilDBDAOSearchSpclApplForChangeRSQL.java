/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSpclApplForChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.30 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSpclApplForChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 변경후 Save시, 승인 요청된 special cargo application이 있는 경우
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSpclApplForChangeRSQL(){
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
		query.append("select sum(cnt) CNT" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(SELECT count(1) cnt" ).append("\n"); 
		query.append("FROM  bkg_dg_cgo" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT count(1) cnt" ).append("\n"); 
		query.append("FROM bkg_rf_cgo" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT count(1) cnt" ).append("\n"); 
		query.append("FROM  bkg_awk_cgo" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT count(1) cnt" ).append("\n"); 
		query.append("FROM  bkg_bb_cgo" ).append("\n"); 
		query.append("where bkg_no       = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSpclApplForChangeRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}