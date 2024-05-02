/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonCodeDBDAOSearchCheckRegOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.12 
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

public class CommonCodeDBDAOSearchCheckRegOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TPB Office Management 등록시 Duplication 체크
	  * </pre>
	  */
	public CommonCodeDBDAOSearchCheckRegOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_n3pty_ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd_reg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchCheckRegOfficeRSQL").append("\n"); 
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
		query.append("SELECT M.OFC_CD, M.OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION M" ).append("\n"); 
		query.append(" WHERE M.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND OFC_CD = @[s_ofc_cd_reg]" ).append("\n"); 
		query.append("   AND NOT EXISTS (" ).append("\n"); 
		query.append("                     SELECT 1" ).append("\n"); 
		query.append("                       FROM TPB_HNDL_OFC" ).append("\n"); 
		query.append("                      WHERE N3PTY_OFC_TP_CD = @[s_n3pty_ofc_tp_cd]" ).append("\n"); 
		query.append("                        AND OFC_CD = @[s_ofc_cd_reg]" ).append("\n"); 
		query.append("                  )" ).append("\n"); 

	}
}