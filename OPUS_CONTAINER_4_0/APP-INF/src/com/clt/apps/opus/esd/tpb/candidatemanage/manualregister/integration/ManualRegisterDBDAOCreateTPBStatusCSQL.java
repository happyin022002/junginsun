/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterDBDAOCreateTPBStatusCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.08.26 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOCreateTPBStatusCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTPBStatus
	  * </pre>
	  */
	public ManualRegisterDBDAOCreateTPBStatusCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOCreateTPBStatusCSQL").append("\n"); 
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
		query.append("CALL TPB_ADD_OTS_DTL_STS_PRC(" ).append("\n"); 
		query.append("@[ots_dtl_seq]" ).append("\n"); 
		query.append(",'O'" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}