/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CandidateConfirmDBDAOUpdateNonTPBDescUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CandidateConfirmDBDAOUpdateNonTPBDescUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateNonTPBDesc
	  * </pre>
	  */
	public CandidateConfirmDBDAOUpdateNonTPBDescUSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.integration ").append("\n"); 
		query.append("FileName : CandidateConfirmDBDAOUpdateNonTPBDescUSQL").append("\n"); 
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
		query.append("UPDATE TPB_NON_CFM_RSN_DESC" ).append("\n"); 
		query.append("SET N3PTY_NON_CFM_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND OTS_DTL_SEQ = @[ots_dtl_seq]" ).append("\n"); 
		query.append("AND N3PTY_NON_CFM_DT = (SELECT MAX(N3PTY_NON_CFM_DT)" ).append("\n"); 
		query.append("							FROM TPB_NON_CFM_RSN_DESC" ).append("\n"); 
		query.append("							WHERE 1=1" ).append("\n"); 
		query.append("							AND OTS_DTL_SEQ = @[ots_dtl_seq])" ).append("\n"); 

	}
}