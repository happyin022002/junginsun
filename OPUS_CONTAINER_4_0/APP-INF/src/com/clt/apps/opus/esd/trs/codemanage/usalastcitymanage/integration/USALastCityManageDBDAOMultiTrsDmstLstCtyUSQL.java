/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USALastCityManageDBDAOMultiTrsDmstLstCtyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.07.28 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USALastCityManageDBDAOMultiTrsDmstLstCtyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Trucker에게 중간 경유지를 지정해 주기 위한 USA Last City를 수정
	  * </pre>
	  */
	public USALastCityManageDBDAOMultiTrsDmstLstCtyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.usalastcitymanage.integration").append("\n"); 
		query.append("FileName : USALastCityManageDBDAOMultiTrsDmstLstCtyUSQL").append("\n"); 
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
		query.append("UPDATE trs_dmst_lst_cty" ).append("\n"); 
		query.append("SET	cre_ofc_cd 	= @[cre_ofc_cd]," ).append("\n"); 
		query.append("cre_usr_id 	= @[cre_usr_id]," ).append("\n"); 
		query.append("cre_dt 		= TO_DATE( @[cre_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("upd_usr_id 	= @[upd_usr_id]," ).append("\n"); 
		query.append("upd_dt 		= TO_DATE( @[upd_dt], 'YYYYMMDD HH24:MI:SS')," ).append("\n"); 
		query.append("delt_flg 	= @[delt_flg]" ).append("\n"); 
		query.append("WHERE	org_loc_cd 	= @[org_loc_cd]" ).append("\n"); 
		query.append("AND		dest_loc_cd = @[dest_loc_cd]" ).append("\n"); 
		query.append("AND		lst_loc_cd 	= @[lst_loc_cd]" ).append("\n"); 

	}
}