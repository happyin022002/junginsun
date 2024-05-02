/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandRouteManageDBDAOInlandRoutePortChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.01 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOInlandRoutePortChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InlandRoutePortChk
	  * </pre>
	  */
	public InlandRouteManageDBDAOInlandRoutePortChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration ").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOInlandRoutePortChkRSQL").append("\n"); 
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
		query.append("SELECT DECODE (m1.loc_cd, NULL, 'N', 'Y') from_port_chk," ).append("\n"); 
		query.append("DECODE (m2.loc_cd, NULL, 'N', 'Y') to_port_chk" ).append("\n"); 
		query.append("FROM mdm_location m1," ).append("\n"); 
		query.append("mdm_location m2," ).append("\n"); 
		query.append("(SELECT @[i_org_cd] aaa" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE ROWNUM = 1)," ).append("\n"); 
		query.append("(SELECT @[i_dest_cd] bbb" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE ROWNUM = 1)" ).append("\n"); 
		query.append("WHERE m1.loc_cd(+) = SUBSTR(aaa,1,5)" ).append("\n"); 
		query.append("AND m2.loc_cd(+) = SUBSTR(bbb,1,5)" ).append("\n"); 
		query.append("AND m1.call_port_flg(+) = 'Y'" ).append("\n"); 
		query.append("AND m2.call_port_flg(+) = 'Y'" ).append("\n"); 
		query.append("AND ((m1.delt_flg <> 'Y') OR (m1.delt_flg IS NULL))" ).append("\n"); 
		query.append("AND ((m2.delt_flg <> 'Y') OR (m2.delt_flg IS NULL))" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}