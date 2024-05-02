/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : JointOperationConsultationDBDAOStlOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2011.03.02 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOStlOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SETTLEMENT의 OFFICE CODE LIST를 조회한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOStlOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOStlOfcRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       D.OFC_CD AS SLP_OFC_CD" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT   A," ).append("\n"); 
		query.append("       COM_USER         D" ).append("\n"); 
		query.append("WHERE  A.CRE_USR_ID  = D.USR_ID" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("AND    NVL(A.CMB_CFM_FLG,'N') = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       D.OFC_CD AS SLP_OFC_CD" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT   A," ).append("\n"); 
		query.append("       JOO_STL_CMB_DTL  B," ).append("\n"); 
		query.append("       JOO_STL_CMB      C," ).append("\n"); 
		query.append("       COM_USER         D" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ" ).append("\n"); 
		query.append("AND    B.ACCT_YRMON  = C.ACCT_YRMON" ).append("\n"); 
		query.append("AND    B.JO_CRR_CD   = C.JO_CRR_CD" ).append("\n"); 
		query.append("AND    B.STL_CMB_SEQ = C.STL_CMB_SEQ" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD  = C.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.CRE_USR_ID  = D.USR_ID" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON >= REPLACE(@[fr_dt],'-','')" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON <= REPLACE(@[to_dt],'-','')" ).append("\n"); 
		query.append("--AND    C.SLP_SER_NO IS NULL" ).append("\n"); 
		query.append("ORDER  BY 1" ).append("\n"); 

	}
}