/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BLInformationMgtDBDAOSearchOblIssFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.22
*@LastModifier : 김기택
*@LastVersion : 1.0
* 2012.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLInformationMgtDBDAOSearchOblIssFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOblIssFlg
	  * </pre>
	  */
	public BLInformationMgtDBDAOSearchOblIssFlgRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration").append("\n"); 
		query.append("FileName : BLInformationMgtDBDAOSearchOblIssFlgRSQL").append("\n"); 
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
		query.append("SELECT obl_iss_flg" ).append("\n"); 
		query.append("  FROM BIS_BL_ISS" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}