/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : InlandRouteManageDBDAOupdateRemoveOptimumFlagUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.11
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2012.05.11 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandRouteManageDBDAOupdateRemoveOptimumFlagUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 구간의 Optimum Route Flag를 제거한다.
	  * </pre>
	  */
	public InlandRouteManageDBDAOupdateRemoveOptimumFlagUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.integration").append("\n"); 
		query.append("FileName : InlandRouteManageDBDAOupdateRemoveOptimumFlagUSQL").append("\n"); 
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
		query.append("update prd_inlnd_rout_mst" ).append("\n"); 
		query.append("set INLND_ROUT_OPTM_FLG = 'N'" ).append("\n"); 
		query.append("  , upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("  , upd_dt = SYSDATE" ).append("\n"); 
		query.append("where ROUT_ORG_NOD_CD = @[rout_org_nod_cd]" ).append("\n"); 
		query.append(" and ROUT_DEST_NOD_CD = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append(" and ROUT_SEQ <> TO_NUMBER(@[rout_seq]) -- optimum으로 등록하려는 것을 제외하고는 모두 uncheck" ).append("\n"); 
		query.append(" and INLND_ROUT_OPTM_FLG = 'Y'" ).append("\n"); 
		query.append(" and nvl(delt_flg,'N') = 'N'" ).append("\n"); 

	}
}