/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckTPBOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2011.02.28 변종건
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Geon Byeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCheckTPBOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCheckTPBOffice
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckTPBOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckTPBOfficeRSQL").append("\n"); 
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
		query.append("SELECT OFC_CD, " ).append("\n"); 
		query.append("       OFC_CD" ).append("\n"); 
		query.append("  FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append(" WHERE OFC_CD = @[s_if_ofc_cd] " ).append("\n"); 
		query.append("   AND DELT_FLG = 'N' " ).append("\n"); 
		query.append("   AND N3PTY_OFC_TP_CD = 'T'" ).append("\n"); 

	}
}