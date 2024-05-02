/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteConditionManageDBDAOSearchCallingTmlMtxExptRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.17 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteConditionManageDBDAOSearchCallingTmlMtxExptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCallingTmlMtxExpt
	  * </pre>
	  */
	public OceanRouteConditionManageDBDAOSearchCallingTmlMtxExptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration ").append("\n"); 
		query.append("FileName : OceanRouteConditionManageDBDAOSearchCallingTmlMtxExptRSQL").append("\n"); 
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
		query.append("SELECT m.port_cd, m.vsl_slan_cd, m.skd_dir_cd,  m.tml_cd, y.yd_nm" ).append("\n"); 
		query.append(",TO_CHAR (m.cre_dt, 'yyyy-mm-dd') cre_dt" ).append("\n"); 
		query.append(",TO_CHAR (m.upd_dt, 'yyyy-mm-dd') upd_dt, m.upd_usr_id" ).append("\n"); 
		query.append("FROM prd_port_tml_expt m, mdm_yard y" ).append("\n"); 
		query.append("WHERE port_cd = @[i_port_cd]" ).append("\n"); 
		query.append("AND m.vsl_slan_cd LIKE @[i_vsl_slan_cd] ||'%'" ).append("\n"); 
		query.append("AND m.tml_cd = y.yd_cd(+)" ).append("\n"); 

	}
}