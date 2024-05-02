/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCtrlOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchCtrlOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCtrlOffice
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCtrlOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd_for_rhq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCtrlOfficeRSQL").append("\n"); 
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
		query.append("#if (${s_office_level} == 'T' || ${s_office_level} == 'G')" ).append("\n"); 
		query.append("    SELECT n3pty_ctrl_ofc_cd AS ofc_cd, n3pty_ctrl_ofc_cd AS ofc_cd" ).append("\n"); 
		query.append("      FROM TPB_HNDL_OFC A" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("       AND n3pty_ofc_tp_cd = 'T'" ).append("\n"); 
		query.append("       AND ofc_cd = @[s_ofc_cd_for_rhq]" ).append("\n"); 
		query.append("	   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT 'X' " ).append("\n"); 
		query.append("      FROM DUAL " ).append("\n"); 
		query.append("     WHERE 1=0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}