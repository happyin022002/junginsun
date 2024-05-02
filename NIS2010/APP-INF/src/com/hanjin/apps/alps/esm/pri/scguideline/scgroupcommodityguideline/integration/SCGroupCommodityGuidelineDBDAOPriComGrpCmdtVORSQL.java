/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupCommodityGuidelineDBDAOPriComGrpCmdtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class SCGroupCommodityGuidelineDBDAOPriComGrpCmdtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public SCGroupCommodityGuidelineDBDAOPriComGrpCmdtVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("scg_grp_cmdt_desc" ).append("\n"); 
		query.append(",	delt_flg" ).append("\n"); 
		query.append(",	svc_scp_cd" ).append("\n"); 
		query.append(",	chg_cd" ).append("\n"); 
		query.append(",	scg_grp_cmdt_cd" ).append("\n"); 
		query.append("FROM pri_com_grp_cmdt" ).append("\n"); 
		query.append("WHERE	svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND	chg_cd = 'GRI'" ).append("\n"); 
		query.append("AND delt_flg = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.scguideline.scgroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : SCGroupCommodityGuidelineDBDAOPriComGrpCmdtVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}