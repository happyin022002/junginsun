/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoUpCdDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.12 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoUpCdDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Component 코드의 상위코드명 조회
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoUpCdDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration ").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoUpCdDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_CMPO_CD CD_ID," ).append("\n"); 
		query.append("MAX(B.EQ_CMPO_NM) CD_DESC" ).append("\n"); 
		query.append("FROM MNR_EQ_CMPO_CD A, MNR_EQ_CMPO_CD B" ).append("\n"); 
		query.append("WHERE A.EQ_CMPO_GRP_TP_CD = 3" ).append("\n"); 
		query.append("AND   B.EQ_CMPO_GRP_TP_CD = 2" ).append("\n"); 
		query.append("AND   A.EQ_PRNT_CMPO_CD = B.EQ_CMPO_CD" ).append("\n"); 
		query.append("GROUP BY A.EQ_CMPO_CD" ).append("\n"); 

	}
}