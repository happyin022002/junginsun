/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OrganizationDBDAOSearchVndrCntCDUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.03.26 채창호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.organization.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang HO Chae
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OrganizationDBDAOSearchVndrCntCDUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * vndr_seq의 국가코드를 가져온다 
	  * </pre>
	  */
	public OrganizationDBDAOSearchVndrCntCDUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.organization.integration").append("\n"); 
		query.append("FileName : OrganizationDBDAOSearchVndrCntCDUSQL").append("\n"); 
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
		query.append("SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq]" ).append("\n"); 

	}
}