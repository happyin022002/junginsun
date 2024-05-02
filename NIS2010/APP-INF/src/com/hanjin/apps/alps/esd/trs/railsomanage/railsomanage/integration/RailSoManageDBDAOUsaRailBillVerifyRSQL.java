/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailSoManageDBDAOUsaRailBillVerifyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2009.09.22 박준용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailSoManageDBDAOUsaRailBillVerifyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SO 대상 중복여부 Verify SQL
	  * </pre>
	  */
	public RailSoManageDBDAOUsaRailBillVerifyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.railsomanage.railsomanage.integration").append("\n"); 
		query.append("FileName : RailSoManageDBDAOUsaRailBillVerifyRSQL").append("\n"); 
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
		query.append("#set(${verifyRepoPlnId}=${verifyRepoPlnId})" ).append("\n"); 
		query.append("#set(${verifyPlnYrwk}=${verifyPlnYrwk})" ).append("\n"); 
		query.append("#set(${verifyRefId}=${verifyRefId})" ).append("\n"); 
		query.append("#set(${verifyRefSeq}=${verifyRefSeq})" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach(${key} IN ${arrNo})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X' CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = ${verifyRepoPlnId.get($key)}" ).append("\n"); 
		query.append("AND   PLN_YRWK = ${verifyPlnYrwk.get($key)}" ).append("\n"); 
		query.append("AND   REF_ID = ${verifyRefId.get($key)}" ).append("\n"); 
		query.append("AND   REF_SEQ = ${verifyRefSeq.get($key)}" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = ${verifyRepoPlnId.get($key)}" ).append("\n"); 
		query.append("AND   PLN_YRWK = ${verifyPlnYrwk.get($key)}" ).append("\n"); 
		query.append("AND   REF_ID = ${verifyRefId.get($key)}" ).append("\n"); 
		query.append("AND   REF_SEQ = ${verifyRefSeq.get($key)}" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X' CHK_UNIT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("DUAL" ).append("\n"); 
		query.append("WHERE EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = ${verifyRepoPlnId.get($key)}" ).append("\n"); 
		query.append("AND   PLN_YRWK = ${verifyPlnYrwk.get($key)}" ).append("\n"); 
		query.append("AND   REF_ID = ${verifyRefId.get($key)}" ).append("\n"); 
		query.append("AND   REF_SEQ = ${verifyRefSeq.get($key)}" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("OR EXISTS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'X'" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID = ${verifyRepoPlnId.get($key)}" ).append("\n"); 
		query.append("AND   PLN_YRWK = ${verifyPlnYrwk.get($key)}" ).append("\n"); 
		query.append("AND   REF_ID = ${verifyRefId.get($key)}" ).append("\n"); 
		query.append("AND   REF_SEQ = ${verifyRefSeq.get($key)}" ).append("\n"); 
		query.append("AND   DELT_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}