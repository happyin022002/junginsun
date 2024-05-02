/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonCodeDBDAOSearchHierarchyOfficeByCountryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.11.12 최 선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonCodeDBDAOSearchHierarchyOfficeByCountryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchHierarchyOfficeByCountry
	  * </pre>
	  */
	public CommonCodeDBDAOSearchHierarchyOfficeByCountryRSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_grd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.common.combo.integration ").append("\n"); 
		query.append("FileName : CommonCodeDBDAOSearchHierarchyOfficeByCountryRSQL").append("\n"); 
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
		query.append("SELECT H.ofc_cd, H.ofc_cd" ).append("\n");
		query.append("  FROM TPB_HNDL_OFC H" ).append("\n");
		query.append(" WHERE ofc_cd IN ( SELECT ofc_cd" ).append("\n"); 
		query.append("                    FROM MDM_CUSTOMER" ).append("\n");
		query.append("                   WHERE cust_cnt_cd = @[cnt_cd]" ).append("\n");
		query.append("                     AND (nmd_cust_flg IS NULL OR nmd_cust_flg != 'Y')" ).append("\n");
		query.append("                     AND delt_flg = 'N'" ).append("\n");
		query.append("                 )" ).append("\n");
		query.append("   AND H.n3pty_ofc_tp_cd = @[ofc_grd]" ).append("\n");
		query.append("   AND H.delt_flg = 'N'" ).append("\n");
		query.append(" ORDER BY h.ofc_cd" ).append("\n");
	}
}