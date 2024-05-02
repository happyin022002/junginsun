/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DaoNameDAOmakePrdTroInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.12 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DaoNameDAOmakePrdTroInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingUtilDBDAOmakePrdTroInfoVO.java
	  * </pre>
	  */
	public DaoNameDAOmakePrdTroInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : DaoNameDAOmakePrdTroInfoRSQL").append("\n"); 
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
		query.append("select '' cntr_no" ).append("\n"); 
		query.append(", '' dor_zone" ).append("\n"); 
		query.append(", '' haulage" ).append("\n"); 
		query.append(", '' tr_mode" ).append("\n"); 
		query.append(", '' tro_pkup_cy" ).append("\n"); 
		query.append(", '' tro_rtn_cy" ).append("\n"); 
		query.append(", '' tro_seq" ).append("\n"); 
		query.append(", '' tro_sub_seq" ).append("\n"); 
		query.append(", '' area_conti_cd" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}