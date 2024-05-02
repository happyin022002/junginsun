/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.24 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * delete >>> bkg_esvc_ctrl_ofc
	  * </pre>
	  */
	public BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM BKG_ESVC_CTRL_OFC" ).append("\n"); 
		query.append("WHERE	HNDL_OFC_CD = @[hndl_ofc_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.bookingmasterdata.bookingprocessmgt.integration ").append("\n"); 
		query.append("FileName : BookingProcessmgtDBDAOBkgEsvcHndlOfc2VODSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}