/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOSearchSvcLaneByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.06.29 김병규
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

public class BookingUtilDBDAOSearchSvcLaneByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD 로 Lane 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchSvcLaneByVvdRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select vsl_slan_cd" ).append("\n"); 
		query.append("from vsk_vsl_skd" ).append("\n"); 
		query.append("where vsl_cd       = substr(@[vvd], 1, 4)--AAAA0150E" ).append("\n"); 
		query.append("and skd_voy_no   = substr(@[vvd], 5, 4)" ).append("\n"); 
		query.append("and skd_dir_cd   = substr(@[vvd], 9, 1)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration ").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchSvcLaneByVvdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}