/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOModifyMasterContainerUcDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOModifyMasterContainerUcDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master Container 에서 UC Cargo에 해당하는 Conatiner의 uc date를  Update 한다 
	  * </pre>
	  */
	public UncollectedCargoDBDAOModifyMasterContainerUcDateUSQL(){
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
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOModifyMasterContainerUcDateUSQL").append("\n"); 
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
		query.append("UPDATE	MST_CONTAINER" ).append("\n"); 
		query.append("SET 	 upd_dt = SYSDATE" ).append("\n"); 
		query.append("		, upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE 	1 = 1" ).append("\n"); 
		query.append("		AND cntr_no IN (" ).append("\n"); 
		query.append("	       					SELECT  cntr_no 	" ).append("\n"); 
		query.append("	       					FROM	CIM_UC_CGO_CNTR" ).append("\n"); 
		query.append("	       					WHERE	1 = 1" ).append("\n"); 
		query.append("	               					AND uc_cs_no = @[uc_cs_no]" ).append("\n"); 
		query.append("	       				)" ).append("\n"); 

	}
}