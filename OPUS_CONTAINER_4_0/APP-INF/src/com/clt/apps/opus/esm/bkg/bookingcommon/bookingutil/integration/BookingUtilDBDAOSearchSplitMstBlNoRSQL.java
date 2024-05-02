/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSplitMstBlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.07 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchSplitMstBlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Booking No의 BL번호와 원Booking의 BL번호를 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSplitMstBlNoRSQL(){
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
		query.append("select bl_no" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select bl_no||BL_TP_CD bl_no --for old bkg" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("WHERE BKG_NO = substr(@[bkg_no], 1, 11) --old bkg의 원본 bkg_no는 11자리" ).append("\n"); 
		query.append("AND LENGTH(@[bkg_no]) = 13" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select bl_no||BL_TP_CD bl_no --for new bkg" ).append("\n"); 
		query.append("from bkg_booking" ).append("\n"); 
		query.append("where bkg_no = substr(@[bkg_no], 1, 10)||'00' --new bkg의 원본 bkg_no는 11,12자리가 반드시 '00'" ).append("\n"); 
		query.append("and length(@[bkg_no]) = 12" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where rownum = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSplitMstBlNoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}