/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgHrdCdgDescVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.08.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgHrdCdgDescVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgHrdCdgDesc에 필요한 vo를 생성한다.
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgHrdCdgDescVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgHrdCdgDescVORSQL").append("\n"); 
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
		query.append("SELECT ''hrd_cdg_id" ).append("\n"); 
		query.append("     , ''hrd_cdg_desc" ).append("\n"); 
		query.append("     , ''attr_nm1" ).append("\n"); 
		query.append("     , ''attr_nm2" ).append("\n"); 
		query.append("     , ''attr_nm3" ).append("\n"); 
		query.append("     , ''attr_nm4" ).append("\n"); 
		query.append("     , ''attr_nm5" ).append("\n"); 
		query.append("     , ''attr_nm6" ).append("\n"); 
		query.append("     , ''attr_nm7" ).append("\n"); 
		query.append("     , ''attr_nm8" ).append("\n"); 
		query.append("     , ''attr_nm9" ).append("\n"); 
		query.append("     , ''attr_nm10" ).append("\n"); 
		query.append("     , ''attr_nm10" ).append("\n"); 
		query.append("     , ''frm_hrd_cdg_id" ).append("\n"); 
		query.append("	 , ''user_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("From dual" ).append("\n"); 

	}
}