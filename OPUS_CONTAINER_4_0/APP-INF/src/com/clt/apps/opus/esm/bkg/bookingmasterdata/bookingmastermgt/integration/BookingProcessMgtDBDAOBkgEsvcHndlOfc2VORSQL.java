/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfc2VORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingProcessMgtDBDAOBkgEsvcHndlOfc2VORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingProcessMgtDBDAOBkgEsvcHndlOfc2VORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingProcessMgtDBDAOBkgEsvcHndlOfc2VORSQL").append("\n"); 
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
		query.append("#if (${chk_op} == 'A') " ).append("\n"); 
		query.append("	SELECT BKG_OFC_CD " ).append("\n"); 
		query.append("	FROM BKG_DOC_PERF_OFC" ).append("\n"); 
		query.append("	WHERE	BKG_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		HNDL_OFC_CD " ).append("\n"); 
		query.append("	FROM BKG_ESVC_HNDL_OFC" ).append("\n"); 
		query.append("	WHERE	HNDL_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}