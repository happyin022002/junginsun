/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.01 최 선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sun, Choi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyTPBGroupRemaking
	  * </pre>
	  */
	public OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL(){
		SetQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no",new String[]{arrTmp[0],arrTmp[1]});
		
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_no_org",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.processmanage.outstandinggroupmanage.integration ").append("\n"); 
		query.append("FileName : OutstandinggroupManageDBDAOModifyTPBGroupRemakingUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	public void SetQuery(){
		query.append("CALL TPB_GROUP_REMAKE_PRC(" ).append("\n");																																																																																																																																					
		query.append("	 @[ots_dtl_seq]" ).append("\n");
		query.append("	,@[n3pty_no]" ).append("\n");
		query.append(" 	,@[s_user_ofc_cd]" ).append("\n");
		query.append(" 	,@[s_user_id]" ).append("\n");
		query.append(")" ).append("\n");
		
	}
}