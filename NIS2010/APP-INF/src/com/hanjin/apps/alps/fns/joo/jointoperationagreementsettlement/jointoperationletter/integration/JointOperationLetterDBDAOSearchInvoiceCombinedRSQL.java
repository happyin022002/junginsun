/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchInvoiceCombinedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.02
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.04.02 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationLetterDBDAOSearchInvoiceCombinedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchInvoiceCombinedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchInvoiceCombinedRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("Z.ACCT_YRMON," ).append("\n"); 
		query.append("Z.RLANE_CD," ).append("\n"); 
		query.append("Z.JO_HJS_AMT," ).append("\n"); 
		query.append("Z.JO_PRNR_AMT," ).append("\n"); 
		query.append("CASE WHEN Z.JO_HJS_AMT < Z.JO_PRNR_AMT THEN '('||TO_CHAR(Z.JO_BAL_AMT,'fm999,999,999,999,990.90')||')'  ELSE  TO_CHAR(Z.JO_BAL_AMT,'fm999,999,999,999,990.90') END JO_BAL_AMT_LBL," ).append("\n"); 
		query.append("Z.JO_BAL_AMT," ).append("\n"); 
		query.append("Z.JO_CRR_CD" ).append("\n"); 
		query.append(",''STL_RMK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR( TO_DATE(A.ACCT_YRMON||'01', 'YYYYMMDD'), 'YYYY-MM' )ACCT_YRMON" ).append("\n"); 
		query.append(",SUBSTR(A.RLANE_CD,0,3) AS RLANE_CD" ).append("\n"); 
		query.append(",SUM(NVL(DECODE(A.RE_DIVR_CD,'R',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)),0)) AS JO_HJS_AMT" ).append("\n"); 
		query.append(",SUM(NVL(DECODE(A.RE_DIVR_CD,'E',DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT)),0)) AS JO_PRNR_AMT" ).append("\n"); 
		query.append(",ABS(SUM(NVL(DECODE(A.RE_DIVR_CD, 'R', DECODE(A.STL_ADJ_FLG, 'Y', B.STL_LOCL_AMT, A.STL_LOCL_AMT)), 0))" ).append("\n"); 
		query.append("- SUM(NVL(DECODE(A.RE_DIVR_CD, 'E', DECODE(A.STL_ADJ_FLG, 'Y', B.STL_LOCL_AMT, A.STL_LOCL_AMT)), 0))) AS JO_BAL_AMT" ).append("\n"); 
		query.append(",A.JO_CRR_CD" ).append("\n"); 
		query.append("FROM   JOO_SETTLEMENT  A," ).append("\n"); 
		query.append("JOO_STL_DTL     B," ).append("\n"); 
		query.append("JOO_STL_CMB_DTL C" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON  = C.ACCT_YRMON" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD  = C.RE_DIVR_CD" ).append("\n"); 
		query.append("AND    A.STL_SEQ     = C.STL_SEQ" ).append("\n"); 
		query.append("AND    A.STL_VVD_SEQ = C.STL_VVD_SEQ" ).append("\n"); 
		query.append("AND    A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("AND    A.ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    NVL(A.CMB_CFM_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${stlcmbseq} != '')" ).append("\n"); 
		query.append("AND   C.STL_CMB_SEQ  in (" ).append("\n"); 
		query.append("#foreach($key IN ${stlcmbseq})" ).append("\n"); 
		query.append("#if($velocityCount < $stlcmbseq.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.JO_CRR_CD,  A.ACCT_YRMON, A.RLANE_CD" ).append("\n"); 
		query.append("ORDER BY A.RLANE_CD" ).append("\n"); 
		query.append(")Z" ).append("\n"); 

	}
}