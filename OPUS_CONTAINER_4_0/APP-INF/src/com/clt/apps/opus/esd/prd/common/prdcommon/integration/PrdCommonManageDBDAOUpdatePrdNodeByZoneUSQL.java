/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdCommonManageDBDAOUpdatePrdNodeByZoneUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.14
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.14 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCommonManageDBDAOUpdatePrdNodeByZoneUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CCD Zone 수정시 PRD Node에도 해당 정보를 Update한다.
	  * </pre>
	  */
	public PrdCommonManageDBDAOUpdatePrdNodeByZoneUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcommon.integration").append("\n"); 
		query.append("FileName : PrdCommonManageDBDAOUpdatePrdNodeByZoneUSQL").append("\n"); 
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
		query.append("UPDATE prd_node " ).append("\n"); 
		query.append("SET nod_nm 	       = @[zn_nm]," ).append("\n"); 
		query.append("	nod_tp_cd      = 'Z' ," ).append("\n"); 
		query.append("	onf_hir_yd_flg = 'N' ," ).append("\n"); 
		query.append("	delt_flg       = @[delt_flg] ," ).append("\n"); 
		query.append("	upd_usr_id     = @[usr_id] ,			" ).append("\n"); 
		query.append("	upd_dt 	       = sysdate" ).append("\n"); 
		query.append("WHERE 	nod_cd = @[zn_cd]" ).append("\n"); 

	}
}