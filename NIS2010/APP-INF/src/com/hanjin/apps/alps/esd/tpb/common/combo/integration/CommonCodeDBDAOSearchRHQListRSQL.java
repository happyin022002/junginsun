/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchRHQListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.12 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchRHQListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRHQList
	  * </pre>
	  */
	public CommonCodeDBDAOSearchRHQListRSQL(){
		SetQuery();
		
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
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchRHQListRSQL").append("\n"); 
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
	public void SetQuery(){
		query.append("SELECT DISTINCT TPB_GET_HNDL_OFC_FNC('R',NVL(n3pty_ofc_cd,ofc_cd)) AS ofc_cd," ).append("\n");
		query.append("       TPB_GET_HNDL_OFC_FNC('R',NVL(n3pty_ofc_cd,ofc_cd)) AS ofc_cd2" ).append("\n");
		query.append("  FROM TPB_HNDL_OFC" ).append("\n");
		query.append(" WHERE delt_flg = 'N'" ).append("\n");
		query.append("   AND TPB_GET_HNDL_OFC_FNC('R',NVL(n3pty_ofc_cd,ofc_cd)) IS NOT NULL" ).append("\n");
		query.append("   AND n3pty_ofc_tp_cd = 'G'" ).append("\n");
		query.append("#if (${s_office_level} == 'R')" ).append("\n");
		query.append("   AND rhq_cd = @[s_ofc_cd_for_rhq]" ).append("\n");
		query.append("#elseif (${s_office_level} == 'G' || ${s_office_level} == '')" ).append("\n");
		query.append("   AND TPB_GET_HNDL_OFC_FNC('R',n3pty_ofc_cd) = @[s_ofc_cd_for_rhq]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(" ORDER BY ofc_cd" ).append("\n");
	}
}