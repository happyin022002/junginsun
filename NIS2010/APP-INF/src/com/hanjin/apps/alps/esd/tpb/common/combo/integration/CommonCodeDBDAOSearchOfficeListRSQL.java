/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOfficeList
	  * </pre>
	  */
	public CommonCodeDBDAOSearchOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchOfficeListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT n3pty_ofc_cd AS ofc_cd,  " ).append("\n"); 
		query.append("       n3pty_ofc_cd AS ofc_cd2" ).append("\n"); 
		query.append("  FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append(" WHERE TPB_GET_HNDL_OFC_FNC('R',n3pty_ofc_cd) = ( SELECT DECODE(ofc_cd,'SINRS',ofc_cd,DECODE(prnt_ofc_cd,'SELDC',ofc_cd,prnt_ofc_cd)) --SINWA,SELMDC 조직변경" ).append("\n"); 
		query.append("                                                    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                   WHERE 1=1" ).append("\n"); 
		query.append("                                                     AND ofc_knd_cd = '2'" ).append("\n"); 
		query.append("                                                     AND delt_flg = 'N'" ).append("\n"); 
		query.append("                                                     AND ofc_cd = @[if_rhq_cd]" ).append("\n"); 
		query.append("                                                     AND ROWNUM = 1" ).append("\n"); 
		query.append("                                                 )" ).append("\n"); 
		query.append("   AND delt_flg = 'N'" ).append("\n"); 
		query.append("   AND TPB_GET_HNDL_OFC_FNC('R',NVL(n3pty_ofc_cd,ofc_cd)) IS NOT NULL" ).append("\n"); 
		query.append(" ORDER BY n3pty_ofc_cd" ).append("\n"); 

	}
}