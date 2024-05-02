/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOModifyUsaRailBillVoScePlnSoListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.08.20 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOModifyUsaRailBillVoScePlnSoListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 상태를 SCE의 테이블에 수정 SQL
	  * </pre>
	  */
	public RailSoManageDBDAOModifyUsaRailBillVoScePlnSoListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOModifyUsaRailBillVoScePlnSoListUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("SET TRSP_SO_STS_CD = 'R'" ).append("\n"); 
		query.append("WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND   COST_ACT_GRP_SEQ = @[cost_act_grp_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}