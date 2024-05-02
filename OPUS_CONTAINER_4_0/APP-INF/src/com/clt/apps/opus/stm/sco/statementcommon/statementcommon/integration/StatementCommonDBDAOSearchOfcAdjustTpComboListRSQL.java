/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StatementCommonDBDAOSearchOfcAdjustTpComboListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatementCommonDBDAOSearchOfcAdjustTpComboListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search Ofc Adjust Tp Combo List
	  * </pre>
	  */
	public StatementCommonDBDAOSearchOfcAdjustTpComboListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration ").append("\n"); 
		query.append("FileName : StatementCommonDBDAOSearchOfcAdjustTpComboListRSQL").append("\n"); 
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
		query.append("SELECT SAM.ACCT_TP_CD" ).append("\n"); 
		query.append("      ,SLD.LU_DESC" ).append("\n"); 
		query.append("FROM   SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("      ,SCO_LU_HDR SLH" ).append("\n"); 
		query.append("      ,SCO_LU_DTL SLD" ).append("\n"); 
		query.append("WHERE  SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("AND    SLD.LU_CD    = SAM.ACCT_TP_CD" ).append("\n"); 
		query.append("AND    TRUNC(SYSDATE) BETWEEN NVL(SLD.LU_ST_DT, TRUNC(SYSDATE)) AND NVL(SLD.LU_END_DT, SYSDATE+1)" ).append("\n"); 
		query.append("AND    SLD.LU_TP_CD = 'ADJUST TYPE'" ).append("\n"); 
		query.append("AND    SAM.ACCT_CTNT1 = 'ADJ'" ).append("\n"); 
		query.append("AND    SAM.ACCT_CTNT2 = 'OADJ'" ).append("\n"); 
		query.append("AND    NVL(SAM.ACCT_CTNT4, 'X') <> 'DFLT'" ).append("\n"); 

	}
}