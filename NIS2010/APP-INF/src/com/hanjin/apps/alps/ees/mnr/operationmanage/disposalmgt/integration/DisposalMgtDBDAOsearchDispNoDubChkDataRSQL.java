/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DisposalMgtDBDAOsearchDispNoDubChkDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOsearchDispNoDubChkDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public DisposalMgtDBDAOsearchDispNoDubChkDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOsearchDispNoDubChkDataRSQL").append("\n"); 
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
		query.append("SELECT MAX(MDD.DISP_NO) AS DISP_NO" ).append("\n"); 
		query.append("FROM MNR_DISP_DTL MDD,MNR_DISP_HDR MDH" ).append("\n"); 
		query.append("WHERE MDD.DISP_NO = MDH.DISP_NO" ).append("\n"); 
		query.append("AND MDH.DISP_STS_CD <> 'HD'" ).append("\n"); 
		query.append("#if (${eq_no_list} != '')" ).append("\n"); 
		query.append("AND MDD.EQ_NO IN (" ).append("\n"); 
		query.append("#foreach ($user_eq_no IN ${eqNos})" ).append("\n"); 
		query.append("#if($velocityCount < $eqNos.size())" ).append("\n"); 
		query.append("'$user_eq_no'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$user_eq_no'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}