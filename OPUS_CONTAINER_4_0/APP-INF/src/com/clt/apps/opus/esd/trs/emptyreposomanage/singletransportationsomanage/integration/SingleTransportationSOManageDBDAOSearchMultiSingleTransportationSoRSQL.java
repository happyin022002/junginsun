/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchMultiSingleTransportationSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.03.22 최종혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchMultiSingleTransportationSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EmptyRepo SO있는지 조회
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchMultiSingleTransportationSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.emptyreposomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchMultiSingleTransportationSoRSQL").append("\n"); 
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
		query.append("#if( $eqrArr.size() > 0 )" ).append("\n"); 
		query.append("#foreach( ${key} in ${eqrArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("SELECT 'X' CHK_UNIT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID	= '${key.repoPlnId}'" ).append("\n"); 
		query.append("AND PLN_YRWK		= '${key.plnYrwk}'" ).append("\n"); 
		query.append("AND REF_ID		= '${key.refId}'" ).append("\n"); 
		query.append("AND REF_SEQ		= ${key.refSeq}" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("OR EXISTS" ).append("\n"); 
		query.append("(SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID	= '${key.repoPlnId}'" ).append("\n"); 
		query.append("AND PLN_YRWK		= '${key.plnYrwk}'" ).append("\n"); 
		query.append("AND REF_ID		= '${key.refId}'" ).append("\n"); 
		query.append("AND REF_SEQ		= ${key.refSeq}" ).append("\n"); 
		query.append("AND DELT_FLG		= 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'X' CHK_UNIT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID	= '${key.repoPlnId}'" ).append("\n"); 
		query.append("AND PLN_YRWK		= '${key.plnYrwk}'" ).append("\n"); 
		query.append("AND REF_ID		= '${key.refId}'" ).append("\n"); 
		query.append("AND REF_SEQ		= ${key.refSeq}" ).append("\n"); 
		query.append("AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("OR EXISTS" ).append("\n"); 
		query.append("(SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE REPO_PLN_ID	= '${key.repoPlnId}'" ).append("\n"); 
		query.append("AND PLN_YRWK		= '${key.plnYrwk}'" ).append("\n"); 
		query.append("AND REF_ID		= '${key.refId}'" ).append("\n"); 
		query.append("AND REF_SEQ		= ${key.refSeq}" ).append("\n"); 
		query.append("AND DELT_FLG		= 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 'X' CHK_UNIT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X'" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD where 1=2 )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}