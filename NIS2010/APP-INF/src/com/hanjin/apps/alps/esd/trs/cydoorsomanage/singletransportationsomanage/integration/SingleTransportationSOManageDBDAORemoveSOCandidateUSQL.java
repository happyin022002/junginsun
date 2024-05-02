/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAORemoveSOCandidateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAORemoveSOCandidateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Candidate 로 S/O 대상 상태코드 UPDATE
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAORemoveSOCandidateUSQL(){
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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAORemoveSOCandidateUSQL").append("\n"); 
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
		query.append("UPDATE SCE_PLN_SO_LIST SET" ).append("\n"); 
		query.append("    TRSP_SO_STS_CD      = 'N'" ).append("\n"); 
		query.append(" ,  UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append(" ,  UPD_DT             = sysdate" ).append("\n"); 
		query.append("	-- correction start" ).append("\n"); 
		query.append(" ,  SO_CNDDT_DELT_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(" ,  SO_CNDDT_DELT_DT   = sysdate" ).append("\n"); 
		query.append("	-- correction end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE" ).append("\n"); 
		query.append("     COP_NO            = @[cop_no]" ).append("\n"); 
		query.append(" AND COST_ACT_GRP_SEQ  = @[cost_act_grp_seq]" ).append("\n"); 

	}
}