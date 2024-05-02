/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOMndVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.05.12 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class BookingHistoryMgtDBDAOMndVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    Select
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOMndVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no_split",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("col_nm" ).append("\n"); 
		query.append(",	pre_ctnt" ).append("\n"); 
		query.append(",	crnt_ctnt" ).append("\n"); 
		query.append(",	ca_flg" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	bkg_no" ).append("\n"); 
		query.append(",	bkg_no_split" ).append("\n"); 
		query.append(",	his_seq" ).append("\n"); 
		query.append(",	his_dtl_seq" ).append("\n"); 
		query.append(",	tbl_nm" ).append("\n"); 
		query.append("FROM bkg_his_dtl" ).append("\n"); 
		query.append("WHERE	bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND	bkg_no_split = @[bkg_no_split]" ).append("\n"); 
		query.append("" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOMndVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}