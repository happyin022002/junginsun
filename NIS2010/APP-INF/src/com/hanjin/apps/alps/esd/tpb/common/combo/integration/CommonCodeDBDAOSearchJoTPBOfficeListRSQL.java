/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonCodeDBDAOSearchJoTPBOfficeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.29
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2013.04.29 신자영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Shin Ja Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchJoTPBOfficeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchJoTPBOfficeList
	  * </pre>
	  */
	public CommonCodeDBDAOSearchJoTPBOfficeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_if_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchJoTPBOfficeListRSQL").append("\n"); 
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
		query.append("SELECT ofc_cd, ofc_cd" ).append("\n"); 
		query.append("FROM TPB_HNDL_OFC A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND n3pty_ctrl_ofc_cd = @[s_if_ctrl_cd]" ).append("\n"); 
		query.append("AND n3pty_ofc_tp_cd in ('T', 'J')" ).append("\n"); 
		query.append("AND delt_flg = 'N'" ).append("\n"); 
		query.append("ORDER BY A.ofc_cd" ).append("\n"); 

	}
}