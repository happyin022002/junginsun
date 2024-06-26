/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteConditionManageDBDAOOceanRouteCondiHistoryMaxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.16 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteConditionManageDBDAOOceanRouteCondiHistoryMaxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteCondiHistoryMax
	  * </pre>
	  */
	public OceanRouteConditionManageDBDAOOceanRouteCondiHistoryMaxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.integration ").append("\n"); 
		query.append("FileName : OceanRouteConditionManageDBDAOOceanRouteCondiHistoryMaxRSQL").append("\n"); 
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
		query.append("select NVL(max(NTWK_HIS_SEQ),0)+1 max_seq" ).append("\n"); 
		query.append("from  prd_port_tml_mtx_his" ).append("\n"); 
		query.append("WHERE port_cd = @[port_cd]" ).append("\n"); 
		query.append("AND vsl_slan_cd = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND skd_dir_cd = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND crr_cd = @[crr_cd]" ).append("\n"); 

	}
}