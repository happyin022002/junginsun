/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JOOFindCodeAndCheckDBDAOStlCmbSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JOOFindCodeAndCheckDBDAOStlCmbSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_STL_CMB에서 ACCT_YRMON, JO_CRR_CD로 DISTINCT 한 STL_CMB_SEQ를 조회한다.
	  * </pre>
	  */
	public JOOFindCodeAndCheckDBDAOStlCmbSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("super_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration").append("\n"); 
		query.append("FileName : JOOFindCodeAndCheckDBDAOStlCmbSeqRSQL").append("\n"); 
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
		query.append("       A.STL_CMB_SEQ AS CODE," ).append("\n"); 
		query.append("       MAX(A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO) AS NAME" ).append("\n"); 
		query.append("FROM   JOO_STL_CMB A" ).append("\n"); 
		query.append("WHERE  A.ACCT_YRMON  = REPLACE(@[super_cd2],'-','')" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD   = @[super_cd1]" ).append("\n"); 
		query.append("AND    A.RVS_CMB_FLG  = 'N' " ).append("\n"); 
		query.append("AND    A.RJCT_CMB_FLG = 'N'" ).append("\n"); 
		query.append("--CSR Creation시에는 combined된 data중 rlane에 Read 권한만 있는 자료는 나와서는 안된다." ).append("\n"); 
		query.append("--Write 권한이 있는 것만 나온다" ).append("\n"); 
		query.append("AND    EXISTS (" ).append("\n"); 
		query.append("         SELECT 1" ).append("\n"); 
		query.append("         FROM   JOO_STL_CMB_DTL X," ).append("\n"); 
		query.append("                JOO_SETTLEMENT  Y," ).append("\n"); 
		query.append("                JOO_CRR_AUTH    Z" ).append("\n"); 
		query.append("         WHERE  X.ACCT_YRMON  = A.ACCT_YRMON" ).append("\n"); 
		query.append("         AND    X.JO_CRR_CD   = A.JO_CRR_CD" ).append("\n"); 
		query.append("         AND    X.STL_CMB_SEQ = A.STL_CMB_SEQ" ).append("\n"); 
		query.append("         AND    X.RE_DIVR_CD  = A.RE_DIVR_CD" ).append("\n"); 
		query.append("         AND    X.ACCT_YRMON  = Y.ACCT_YRMON" ).append("\n"); 
		query.append("         AND    X.STL_VVD_SEQ = Y.STL_VVD_SEQ" ).append("\n"); 
		query.append("         AND    X.STL_SEQ     = Y.STL_SEQ" ).append("\n"); 
		query.append("         AND    Y.JO_CRR_CD   = Z.JO_CRR_CD" ).append("\n"); 
		query.append("         AND    Y.RLANE_CD    = Z.RLANE_CD" ).append("\n"); 
		query.append("         AND    Z.AUTH_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("         AND    Z.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("         AND    Z.JO_CRR_AUTH_CD = 'W'" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("#if (${code} != '')" ).append("\n"); 
		query.append("AND    A.RE_DIVR_CD  = @[code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP  BY STL_CMB_SEQ" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}