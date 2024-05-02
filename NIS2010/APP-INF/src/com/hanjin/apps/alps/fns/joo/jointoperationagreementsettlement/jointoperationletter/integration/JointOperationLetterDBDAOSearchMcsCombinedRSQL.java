/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JointOperationLetterDBDAOSearchMcsCombinedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.02
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.02 장강철
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

public class JointOperationLetterDBDAOSearchMcsCombinedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MCS는 Combined 처리전 데이타도 나오게 처리
	  * </pre>
	  */
	public JointOperationLetterDBDAOSearchMcsCombinedRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.integration").append("\n"); 
		query.append("FileName : JointOperationLetterDBDAOSearchMcsCombinedRSQL").append("\n"); 
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
		query.append("A.ACCT_YRMON" ).append("\n"); 
		query.append(",A.JO_CRR_CD" ).append("\n"); 
		query.append(",A.TRD_CD" ).append("\n"); 
		query.append(",SUBSTR(A.RLANE_CD,1,3)RLANE_CD" ).append("\n"); 
		query.append(",SUM(DECODE(A.STL_ADJ_FLG,'Y',B.STL_LOCL_AMT,A.STL_LOCL_AMT) ) AS  TTL_AMT" ).append("\n"); 
		query.append(",''STL_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  JOO_SETTLEMENT A," ).append("\n"); 
		query.append("JOO_STL_DTL    B" ).append("\n"); 
		query.append("WHERE   A.ACCT_YRMON  = B.ACCT_YRMON (+)" ).append("\n"); 
		query.append("AND   A.STL_VVD_SEQ   = B.STL_VVD_SEQ(+)" ).append("\n"); 
		query.append("AND   A.STL_SEQ       = B.STL_SEQ    (+)" ).append("\n"); 
		query.append("AND   A.STL_LOCL_AMT<>0" ).append("\n"); 
		query.append("AND   A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("#if (${rlane_cds} != '')" ).append("\n"); 
		query.append("AND   SUBSTR(A.RLANE_CD, 1,3) in (" ).append("\n"); 
		query.append("#foreach($key IN ${rlane_cds})" ).append("\n"); 
		query.append("#if($velocityCount < $rlane_cds.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND  A.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append("AND  A.TRD_CD  = @[trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND  A.re_divr_cd  = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND A.CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append("GROUP BY A.ACCT_YRMON" ).append("\n"); 
		query.append(",A.JO_CRR_CD" ).append("\n"); 
		query.append(",A.TRD_CD" ).append("\n"); 
		query.append(",A.RLANE_CD" ).append("\n"); 
		query.append("ORDER BY A.ACCT_YRMON, A.RLANE_CD" ).append("\n"); 

	}
}